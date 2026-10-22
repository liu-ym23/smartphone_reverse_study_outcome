package com.google.android.material.datepicker;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
abstract class DateFormatTextWatcher extends TextWatcherAdapter {
    private final CalendarConstraints constraints;
    private final DateFormat dateFormat;
    private final String formatHint;
    private int lastLength;
    private final String outOfRange;
    private final Runnable setErrorCallback;
    private Runnable setRangeErrorCallback;

    @NonNull
    private final TextInputLayout textInputLayout;

    public DateFormatTextWatcher(final String r5, DateFormat r10, @NonNull TextInputLayout r11, CalendarConstraints r12) {
        this.lastLength = 0;
        this.formatHint = r5;
        this.dateFormat = r10;
        this.textInputLayout = r11;
        this.constraints = r12;
        this.outOfRange = r11.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.setErrorCallback = new a(this, r5);
    }

    public static /* synthetic */ void a(DateFormatTextWatcher r5, long r10) {
        r5.lambda$createRangeErrorCallback$1(r10);
    }

    public static /* synthetic */ void b(DateFormatTextWatcher r5, String r10) {
        r5.lambda$new$0(r10);
    }

    private Runnable createRangeErrorCallback(final long r5) {
        return new b(this, r5);
    }

    private /* synthetic */ void lambda$createRangeErrorCallback$1(long r5) {
        String r10 = DateStrings.getDateString(r5);
        this.textInputLayout.setError(String.format(this.outOfRange, new Object[]{sanitizeDateString(r10)}));
        onInvalidDate();
    }

    private /* synthetic */ void lambda$new$0(String r10) {
        TextInputLayout r5 = this.textInputLayout;
        DateFormat r11 = this.dateFormat;
        Context r12 = r5.getContext();
        r5.setError(r12.getString(R.string.mtrl_picker_invalid_format) + "\n" + String.format(r12.getString(R.string.mtrl_picker_invalid_format_use), new Object[]{sanitizeDateString(r10)}) + "\n" + String.format(r12.getString(R.string.mtrl_picker_invalid_format_example), new Object[]{sanitizeDateString(r11.format(new Date(UtcDates.getTodayCalendar().getTimeInMillis())))}));
        onInvalidDate();
    }

    private String sanitizeDateString(String r5) {
        return r5.replace(' ', Typography.nbsp);
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void afterTextChanged(@NonNull Editable r5) {
        if (Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) == false) goto L6;
        return;
    L6:
        if (r5.length() != 0) goto L8;
        return;
    L8:
        if (r5.length() < this.formatHint.length()) goto L10;
        return;
    L10:
        if (r5.length() < this.lastLength) goto L19;
        char r10 = this.formatHint.charAt(r5.length());
        if (Character.isLetterOrDigit(r10) == true) goto L18;
        r5.append(r10);
        return;
    L18:
        return;
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void beforeTextChanged(@NonNull CharSequence r5, int r10, int r11, int r12) {
        this.lastLength = r5.length();
    }

    public void onInvalidDate() {
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void onTextChanged(@NonNull CharSequence r5, int r10, int r11, int r12) {
        this.textInputLayout.removeCallbacks(this.setErrorCallback);
        this.textInputLayout.removeCallbacks(this.setRangeErrorCallback);
        this.textInputLayout.setError(null);
        onValidDate(null);
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        if (r5.length() < this.formatHint.length()) goto L19;
        Date r13 = this.dateFormat.parse(r5.toString());     // Catch: ParseException -> L15
        this.textInputLayout.setError(null);     // Catch: ParseException -> L15
        long r14 = r13.getTime();     // Catch: ParseException -> L15
        if (this.constraints.getDateValidator().isValid(r14) == true) goto L10;
    L13:
        Runnable r15 = createRangeErrorCallback(r14);     // Catch: ParseException -> L15
        this.setRangeErrorCallback = r15;     // Catch: ParseException -> L15
        runValidation(this.textInputLayout, r15);     // Catch: ParseException -> L15
        return;
    L10:
        if (this.constraints.isWithinBounds(r14) == false) goto L13;
        onValidDate(Long.valueOf(r13.getTime()));     // Catch: ParseException -> L15
        return;
    L15:
        runValidation(this.textInputLayout, this.setErrorCallback);
        return;
    }

    public abstract void onValidDate(@Nullable Long r5);

    public void runValidation(View r5, Runnable r10) {
        r5.post(r10);
    }
}
