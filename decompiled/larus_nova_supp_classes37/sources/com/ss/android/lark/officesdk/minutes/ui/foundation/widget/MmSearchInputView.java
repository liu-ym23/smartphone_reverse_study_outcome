package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010,\u001a\u00020\u001e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010-\u001a\u00020\u001eH\u0002J\b\u0010.\u001a\u00020\u001eH\u0002J\u0010\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u0018H\u0002J\u0006\u00101\u001a\u00020\u0018J\u000e\u00102\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u0018J\u0006\u00103\u001a\u00020\u001eJ\u000e\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u0014J\u000e\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u0018J\u000e\u00108\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u0018J\b\u00109\u001a\u00020\u001eH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006:"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmSearchInputView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "searchEditText", "Landroid/widget/EditText;", "searchCancel", "Landroid/widget/TextView;", "searchClearButton", "Landroid/view/View;", "searchContainer", "debounceTimeMs", "", "debounceJob", "Lkotlinx/coroutines/Job;", "pendingHint", "", "pendingCancelText", "searchCancelVisible", "", "onTextChangedListener", "Lkotlin/Function1;", "", "getOnTextChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnTextChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "onTextChangedWithDebounceListener", "getOnTextChangedWithDebounceListener", "setOnTextChangedWithDebounceListener", "onCancelClickListener", "Lkotlin/Function0;", "getOnCancelClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnCancelClickListener", "(Lkotlin/jvm/functions/Function0;)V", "initAttrs", "initView", "initDebounce", "dispatchDebouncedTextChanged", "text", "getText", "setText", "clearText", "setDebounceTime", "timeMs", "setHint", "hint", "setCancelText", "onDetachedFromWindow", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmSearchInputView extends ConstraintLayout {
    public final CoroutineScope a;
    public EditText b;
    public TextView c;
    public View d;
    public View e;
    public long f;
    public Job g;
    public String h;
    public String i;
    public boolean j;
    public Function1<? super String, Unit> k;
    public Function1<? super String, Unit> l;
    public Function0<Unit> m;

    public MmSearchInputView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MmSearchInputView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final String getText() {
        EditText r0 = this.b;
        String r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r0 = null;
    L5:
        Editable r2 = r0.getText();
        if (r2 == null) goto L8;
        r1 = r2.toString();
    L8:
        if (r1 != null) goto L11;
        return "";
    L11:
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        Job r0 = this.g;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        CoroutineScopeKt.cancel$default(this.a, null, 1, null);
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
    }

    public final Function0<Unit> getOnCancelClickListener() {
        return this.m;
    }

    public final Function1<String, Unit> getOnTextChangedListener() {
        return this.k;
    }

    public final Function1<String, Unit> getOnTextChangedWithDebounceListener() {
        return this.l;
    }

    public final void setCancelText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        TextView r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchCancel");
        r0 = null;
    L5:
        r0.setText(r2);
    }

    public final void setDebounceTime(long r2) {
        this.f = r2;
        Job r3 = this.g;
        if (r3 == null) goto L6;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
        return;
    }

    public final void setHint(String r2) {
        Intrinsics.checkNotNullParameter(r2, "hint");
        EditText r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r0 = null;
    L5:
        r0.setHint(r2);
    }

    public final void setOnCancelClickListener(Function0<Unit> r1) {
        this.m = r1;
    }

    public final void setOnTextChangedListener(Function1<? super String, Unit> r1) {
        this.k = r1;
    }

    public final void setOnTextChangedWithDebounceListener(Function1<? super String, Unit> r1) {
        this.l = r1;
    }

    public final void setText(String r4) {
        Intrinsics.checkNotNullParameter(r4, "text");
        EditText r0 = this.b;
        EditText r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r0 = null;
    L5:
        r0.setText(r4);
        EditText r2 = this.b;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
    L9:
        r1.setSelection(r4.length());
        return;
    L8:
        r1 = r2;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmSearchInputView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = CoroutineScopeKt.MainScope();
        this.f = 600;
        MmRecordingUILaunchMode r7 = com.ss.android.lark.officesdk.minutes.ui.style.c.a(r4);
        com.ss.android.lark.officesdk.minutes.ui.style.e.a.getClass();
        com.ss.android.lark.officesdk.minutes.ui.style.e.b(r7).getLayout().q(LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(r4, r7)), this);
        int r8 = 0;
        if (r5 == null) goto L10;
        TypedArray r9 = getContext().obtainStyledAttributes(r5, new int[]{2130969725, 2130973949, 2130973950, 2130973951});
        this.h = r9.getString(3);     // Catch: Throwable -> L7
        this.i = r9.getString(1);     // Catch: Throwable -> L7
        this.f = r9.getInt(0, 600);     // Catch: Throwable -> L7
        this.j = r9.getBoolean(2, false);     // Catch: Throwable -> L7
        r9.recycle();
    L7:
        th = move-exception;
        r9.recycle();
        throw th;
    L10:
        this.b = (EditText) findViewById(2131385293);
        this.c = (TextView) findViewById(2131385289);
        this.d = findViewById(2131385290);
        View r10 = findViewById(2131385292);
        this.e = r10;
        TextView r11 = null;
        if (r10 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("searchContainer");
        r10 = null;
    L13:
        r10.setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).a(getContext()));
        EditText r12 = this.b;
        if (r12 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r12 = null;
    L16:
        UIUtils.setTextViewCursorDrawable(r12, com.ss.android.lark.officesdk.minutes.ui.style.b.a(getContext()).t(getContext()));
        String r13 = this.h;
        if (r13 == null) goto L22;
        EditText r1 = this.b;
        if (r1 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r1 = null;
    L21:
        r1.setHint(r13);
    L22:
        String r14 = this.i;
        if (r14 == null) goto L28;
        TextView r2 = this.c;
        if (r2 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("searchCancel");
        r2 = null;
    L27:
        r2.setText(r14);
    L28:
        TextView r15 = this.c;
        if (r15 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("searchCancel");
        r15 = null;
    L32:
        if (this.j == true) goto L35;
        r8 = 8;
    L35:
        r15.setVisibility(r8);
        EditText r16 = this.b;
        if (r16 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r16 = null;
    L38:
        r16.addTextChangedListener(new c(this));
        View r17 = this.d;
        if (r17 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("searchClearButton");
        r17 = null;
    L41:
        h.a(r17, new MmSearchInputView$initView$4(this));
        if (this.j == false) goto L51;
        TextView r18 = this.c;
        if (r18 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("searchCancel");
    L47:
        h.a(r11, new MmSearchInputView$initView$5(this));
        return;
    L46:
        r11 = r18;
        goto L47
    }

    public /* synthetic */ MmSearchInputView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
