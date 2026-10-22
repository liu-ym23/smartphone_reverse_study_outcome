package com.larksuite.component.card.component;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import com.larksuite.component.card.utils.UniversalCardHostInfoManager;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.larksuite.component.universe_design.timepicker.UDTimePicker;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerModel;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c extends UDDialogController implements View.OnClickListener, c18.a {
    public CardCalendarDialogFactory$CardCalendarDialogStyle a;
    public long b;
    public CardCalendarDialogFactory$CardCalendarType c;
    public d d;
    public View e;
    public TextView f;
    public View g;
    public UDTimePicker h;
    public UDTimePicker i;
    public View j;
    public TextView k;
    public TextView l;
    public Calendar m;

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateContent() {
        View r0 = super.onCreateContent();
        if (r0 != null) goto L7;
        return null;
    L7:
        if (this.a != CardCalendarDialogFactory$CardCalendarDialogStyle.Modal) goto L9;
        int r1 = 5;
    L10:
        int r2 = a.a[this.c.ordinal()];
        if (r2 != 1) goto L13;
        b(r0);
        UDTimePicker r3 = (UDTimePicker) r0.findViewById(2131372604);
        this.h = r3;
        r3.setPickerMode(PickerModel.YEAR_MONTH_DAY);
        this.h.setItemVisibleNum(r1);
        this.h.setSelectedCalendar(this.m);
        this.h.setDatePickerListener(this);
    L19:
        return r0;
    L13:
        if (r2 == 2) goto L17;
        if (r2 != 3) goto L19;
        UDTimePicker r4 = (UDTimePicker) r0.findViewById(2131372604);
        this.h = r4;
        r4.setPickerMode(PickerModel.YEAR_MONTH_DAY);
        this.h.setSelectedCalendar(this.m);
        this.h.setItemVisibleNum(r1);
        UDTimePicker r5 = (UDTimePicker) r0.findViewById(2131385686);
        this.i = r5;
        r5.setPickerMode(PickerModel.HOUR_MINUTE_24H);
        this.i.setItemVisibleNum(r1);
        this.i.setSelectedCalendar(this.m);
        this.h.setDatePickerListener(this);
        this.i.setDatePickerListener(this);
        goto L19
    L17:
        b(r0);
        UDTimePicker r6 = (UDTimePicker) r0.findViewById(2131372604);
        this.h = r6;
        r6.setPickerMode(PickerModel.HOUR_MINUTE_24H);
        this.h.setItemVisibleNum(r1);
        this.h.setSelectedCalendar(this.m);
        this.h.setDatePickerListener(this);
        goto L19
    L9:
        r1 = 3;
        goto L10
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateFooter() {
        View r0 = super.onCreateFooter();
        if (r0 != null) goto L7;
        return null;
    L7:
        if (this.c != CardCalendarDialogFactory$CardCalendarType.DateTime) goto L9;
        r0.setVisibility(0);
        b(r0);
        this.k = (TextView) r0.findViewById(2131368554);
        this.l = (TextView) r0.findViewById(2131388686);
        View r2 = r0.findViewById(2131388030);
        this.j = r2;
        r2.setVisibility(0);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
    L10:
        return r0;
    L9:
        r0.setVisibility(8);
        goto L10
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateHeader() {
        View r0 = super.onCreateHeader();
        if (r0 == null) goto L5;
        this.e = r0.findViewById(2131365135);
        this.f = (TextView) r0.findViewById(2131388920);
        this.g = r0.findViewById(2131367674);
        this.e.setOnClickListener(this);
        this.g.setOnClickListener(this);
    L5:
        return r0;
    }

    public c(Context r3) {
        super(r3);
        this.a = CardCalendarDialogFactory$CardCalendarDialogStyle.BottomSheet;
        this.b = -1;
        this.m = null;
    }

    public final void b(View r3) {
        int r0 = a.b[this.a.ordinal()];
        if (r0 != 1) goto L5;
        r3.setBackgroundColor(getContext().getResources().getColor(2131100548));
        return;
    L5:
        if (r0 != 2) goto L11;
        r3.setBackgroundResource(2131231900);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.app.Dialog, com.larksuite.component.universe_design.dialog.UDDialog, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        ?? r0 = getMDialog();
        if (r7 != this.e) goto L7;
        if (r0 == 0) goto L49;
        r0.cancel();
        return;
    L49:
        return;
    L7:
        if (r7 == this.g) goto L9;
        TextView r1 = this.k;
        if (r7 != r1) goto L43;
        r1.setTextColor(y9c.d.c(getContext(), 2131105548));
        this.l.setTextColor(y9c.d.c(getContext(), 2131106622));
        this.h.setVisibility(0);
        this.i.setVisibility(8);
        return;
    L43:
        if (r7 != this.l) goto L56;
        r1.setTextColor(y9c.d.c(getContext(), 2131106622));
        this.l.setTextColor(y9c.d.c(getContext(), 2131105548));
        this.h.setVisibility(8);
        this.i.setVisibility(0);
        return;
    L56:
        return;
    L9:
        if (this.d == null) goto L51;
        int r8 = a.a[this.c.ordinal()];
        if (r8 != 1) goto L13;
        String r9 = "yyyy-MM-dd";
    L20:
        this.d.a(c(r9, this.m.getTime(), true), this.m.getTimeInMillis());
        if (r0 == 0) goto L52;
        Handler r10 = DialogLancet.resolveDialogHandler(r0);
        if (r10 != null) goto L25;
    L27:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L30 Exception -> L32
    L36:
        DialogLancet.afterDialogDismiss(r0);
        return;
    L32:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L30
        Throwable r11 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L30
        if (r11 == null) goto L36;
        com.bytedance.crash.d.d(r11, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L25:
        if (Looper.myLooper() == r10.getLooper()) goto L27;
        r10.post(DialogLancet.createDismissRunnable(r0));
        return;
    L52:
        return;
    L13:
        if (r8 != 2) goto L15;
        r9 = "HH:mm";
        goto L20
    L15:
        if (r8 == 3) goto L17;
        r9 = null;
        goto L20
    L17:
        r9 = "yyyy-MM-dd HH:mm";
        goto L20
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r8, UDDialog r9) {
        if ((r8 instanceof b) == false) goto L22;
        b r0 = (b) r8;
        CardCalendarDialogFactory$CardCalendarDialogStyle r1 = r0.b;
        if (r1 == null) goto L18;
        this.a = r1;
        UniversalCardHostInfoManager.a r2 = UniversalCardHostInfoManager.f;
        Context r3 = getContext();
        r2.getClass();
        Size r4 = UniversalCardHostInfoManager.a.a(r3);
        int r5 = 380;
        if (r4.getWidth() > 0) goto L9;
    L11:
        int r6 = a.b[this.a.ordinal()];
        if (r6 != 1) goto L14;
        r8.gravity(80);
        r8.width(1.0f);
        goto L18
    L14:
        if (r6 != 2) goto L18;
        r8.gravity(17);
        r8.width(r5);
        goto L18
    L9:
        if (r4.getHeight() <= 0) goto L11;
        r5 = Math.max(Math.min(Math.min(UIUtils.px2dp(getContext(), r4.getWidth()) - 10, UIUtils.px2dp(getContext(), r4.getHeight()) - 10), 380), 0);
    L18:
        this.b = r0.a;
        Calendar r7 = Calendar.getInstance();
        this.m = r7;
        long r10 = this.b;
        if (r10 <= (-1)) goto L21;
        r7.setTimeInMillis(r10);
    L21:
        this.c = r0.c;
        this.d = r0.d;
    L22:
        super.apply(r8, r9);
    }

    public final String c(String r2, Date r3, boolean r4) {
        if (r4 == false) goto L5;
        r2 = r2 + " Z";
    L5:
        return new SimpleDateFormat(r2, Locale.ENGLISH).format(r3);
    }

    @Override // c18.a
    public final void a(int r7, int r8, int r9, int r10, int r11) {
        this.g.setEnabled(true);
        int r12 = a.a[this.c.ordinal()];
        if (r12 != 1) goto L5;
    L10:
        this.m = this.h.getSelectedCalendar();
        return;
    L5:
        if (r12 == 2) goto L10;
        if (r12 != 3) goto L13;
        Calendar r13 = this.h.getSelectedCalendar();
        Calendar r14 = this.i.getSelectedCalendar();
        Calendar r15 = Calendar.getInstance();
        r15.set(r13.get(1), r13.get(2), r13.get(5), r14.get(11), r14.get(12));
        this.m = r15;
        this.f.setText(c("yyyy-MM-dd HH:mm", r15.getTime(), false));
        return;
    }
}
