package grb;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.larksuite.component.universe_design.timepicker.UDTimePicker;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.message.card.component.CardCalendarDialogFactory$CardCalendarType;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends UDDialogController implements View.OnClickListener, c18.a {
    public long a;
    public CardCalendarDialogFactory$CardCalendarType b;
    public d c;
    public View d;
    public TextView e;
    public View f;
    public UDTimePicker g;
    public UDTimePicker h;
    public View i;
    public TextView j;
    public TextView k;
    public Calendar l;

    public final View onCreateContent() {
        View r0 = super.onCreateContent();
        int r1 = a.a[this.b.ordinal()];
        if (r1 != 1) goto L5;
        UDTimePicker r2 = r0.findViewById(2131372604);
        this.g = r2;
        r2.setPickerMode(PickerModel.YEAR_MONTH_DAY);
        this.g.setSelectedCalendar(this.l);
        this.g.setDatePickerListener(this);
    L12:
        return r0;
    L5:
        if (r1 != 2) goto L7;
        UDTimePicker r3 = r0.findViewById(2131372604);
        this.g = r3;
        r3.setPickerMode(PickerModel.HOUR_MINUTE_24H);
        this.g.setSelectedCalendar(this.l);
        this.g.setDatePickerListener(this);
        goto L12
    L7:
        if (r1 != 3) goto L12;
        UDTimePicker r4 = r0.findViewById(2131372604);
        this.g = r4;
        r4.setPickerMode(PickerModel.YEAR_MONTH_DAY);
        this.g.setSelectedCalendar(this.l);
        UDTimePicker r5 = r0.findViewById(2131385686);
        this.h = r5;
        r5.setPickerMode(PickerModel.HOUR_MINUTE_24H);
        this.h.setSelectedCalendar(this.l);
        this.g.setDatePickerListener(this);
        this.h.setDatePickerListener(this);
        goto L12
    }

    public final View onCreateFooter() {
        View r0 = super.onCreateFooter();
        if (r0 != null) goto L5;
    L7:
        return r0;
    L5:
        if (this.b != CardCalendarDialogFactory$CardCalendarType.DateTime) goto L7;
        this.j = (TextView) r0.findViewById(2131368554);
        this.k = (TextView) r0.findViewById(2131388686);
        View r1 = r0.findViewById(2131388030);
        this.i = r1;
        r1.setVisibility(0);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        goto L7
    }

    public final View onCreateHeader() {
        View r0 = super.onCreateHeader();
        this.d = r0.findViewById(2131365135);
        this.e = (TextView) r0.findViewById(2131388920);
        this.f = r0.findViewById(2131367674);
        this.d.setOnClickListener(this);
        this.f.setOnClickListener(this);
        return r0;
    }

    public c(Context r3) {
        super(r3);
        this.a = -1;
        this.l = null;
    }

    public static void b(UDDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        if (r7 != this.d) goto L6;
        b(getMDialog());
        return;
    L6:
        if (r7 == this.f) goto L8;
        TextView r0 = this.j;
        if (r7 != r0) goto L24;
        r0.setTextColor(y9c.d.c(getContext(), 2131105548));
        this.k.setTextColor(y9c.d.c(getContext(), 2131106622));
        this.g.setVisibility(0);
        this.h.setVisibility(8);
        return;
    L24:
        if (r7 != this.k) goto L31;
        r0.setTextColor(y9c.d.c(getContext(), 2131106622));
        this.k.setTextColor(y9c.d.c(getContext(), 2131105548));
        this.g.setVisibility(8);
        this.h.setVisibility(0);
        return;
    L31:
        return;
    L8:
        if (this.c == null) goto L28;
        int r8 = a.a[this.b.ordinal()];
        if (r8 != 1) goto L12;
        String r9 = "yyyy-MM-dd";
    L19:
        this.c.a(c(r9, this.l.getTime(), true), this.l.getTimeInMillis());
        b(getMDialog());
        return;
    L12:
        if (r8 != 2) goto L14;
        r9 = "HH:mm";
        goto L19
    L14:
        if (r8 == 3) goto L16;
        r9 = null;
        goto L19
    L16:
        r9 = "yyyy-MM-dd HH:mm";
        goto L19
    }

    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r8, UDDialog r9) {
        if ((r8 instanceof b) == false) goto L8;
        b r0 = (b) r8;
        this.a = r0.a;
        Calendar r1 = Calendar.getInstance();
        this.l = r1;
        long r2 = this.a;
        if (r2 <= (-1)) goto L7;
        r1.setTimeInMillis(r2);
    L7:
        this.b = r0.b;
        this.c = r0.c;
    L8:
        super.apply(r8, r9);
    }

    public final String c(String r2, Date r3, boolean r4) {
        if (r4 == false) goto L5;
        r2 = r2 + " Z";
    L5:
        return new SimpleDateFormat(r2, Locale.ENGLISH).format(r3);
    }

    public final void a(int r7, int r8, int r9, int r10, int r11) {
        this.f.setEnabled(true);
        int r12 = a.a[this.b.ordinal()];
        if (r12 != 1) goto L5;
    L10:
        this.l = this.g.getSelectedCalendar();
        return;
    L5:
        if (r12 == 2) goto L10;
        if (r12 != 3) goto L13;
        Calendar r13 = this.g.getSelectedCalendar();
        Calendar r14 = this.h.getSelectedCalendar();
        Calendar r15 = Calendar.getInstance();
        r15.set(r13.get(1), r13.get(2), r13.get(5), r14.get(11), r14.get(12));
        this.l = r15;
        this.e.setText(c("yyyy-MM-dd HH:mm", r15.getTime(), false));
        return;
    }
}
