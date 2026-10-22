package com.larksuite.component.universe_design.timepicker.impl.action;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.crash.d;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.larksuite.component.universe_design.timepicker.impl.data.PickerModel;
import com.larksuite.component.universe_design.util.CalendarDate;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Calendar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class a extends UDDialogController {
    public PickerModel a;
    public String b;
    public Integer c;
    public UDTimePickerBuilder.a d;
    public String e;
    public UDTimePickerBuilder.a f;
    public String g;
    public int h;
    public Calendar i;
    public CalendarDate j;
    public CalendarDate k;

    /* JADX INFO: renamed from: com.larksuite.component.universe_design.timepicker.impl.action.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0043a implements View.OnClickListener {
        public final /* synthetic */ a a;
        public final /* synthetic */ UDTimePickerActionView b;

        public ViewOnClickListenerC0043a(a r1, UDTimePickerActionView r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [android.app.Dialog, com.larksuite.component.universe_design.dialog.UDDialog, java.lang.Object] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            a r5 = this.a;
            if (r5.d != null) goto L23;
            ?? r6 = r5.getMDialog();
            if (r6 == 0) goto L23;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L9;
        L11:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L14 Exception -> L16
        L20:
            DialogLancet.afterDialogDismiss(r6);
            goto L23
        L16:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
            if (r1 == null) goto L20;
            d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L9:
            if (Looper.myLooper() == r0.getLooper()) goto L11;
            r0.post(DialogLancet.createDismissRunnable(r6));
        L23:
            CalendarDate r7 = new CalendarDate(this.b.getUDTimePicker().getSelectedCalendar());
            a r2 = this.a;
            UDTimePickerBuilder.a r3 = r2.d;
            if (r3 == null) goto L30;
            a.b(r2, r3, r7);
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ UDTimePickerActionView a;
        public final /* synthetic */ a b;

        public b(UDTimePickerActionView r1, a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            CalendarDate r4 = new CalendarDate(this.a.getUDTimePicker().getSelectedCalendar());
            this.b.getClass();
            a r0 = this.b;
            UDTimePickerBuilder.a r1 = r0.f;
            if (r1 == null) goto L6;
            a.b(r0, r1, r4);
            return;
        }
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public View createView() {
        View r0 = super.createView();
        UDTimePickerActionView r1 = null;
        if (r0 != null) goto L6;
        return null;
    L6:
        if ((r0 instanceof UDTimePickerActionView) == false) goto L8;
        r1 = (UDTimePickerActionView) r0;
    L8:
        if (r1 != null) goto L10;
        return r0;
    L10:
        CalendarDate r2 = this.j;
        CalendarDate r3 = this.k;
        if (r2 == null) goto L14;
        if (r3 == null) goto L14;
        r1.getUDTimePicker().setPickerDateRange$universe_ui_datepicker_release(r2, r3);
    L14:
        r1.setPickerMode(this.a);
        String r4 = this.g;
        String r5 = "";
        if (r4 != null) goto L17;
        r4 = "";
    L17:
        r1.setTitleText(r4);
        String r6 = this.b;
        if (r6 != null) goto L20;
        r6 = "";
    L20:
        r1.setLeftActionViewText(r6);
        Integer r7 = this.c;
        if (r7 == null) goto L23;
        r1.setLeftTextColor(r7.intValue());
    L23:
        String r8 = this.e;
        if (r8 == null) goto L27;
        r5 = r8;
    L27:
        r1.setRightActionViewText(r5);
        setupTextView(r1.getTitleTextView(), getMTitleSize(), getMTitleTextColor());
        r1.setInterval(this.h);
        Calendar r9 = this.i;
        if (r9 == null) goto L30;
        r1.setSelectedTime(r9);
    L30:
        r1.setLeftActionViewClickListener(new ViewOnClickListenerC0043a(this, r1));
        r1.setRightActionViewClickListener(new b(r1, this));
        return r0;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = PickerModel.MONTHDAY_HOUR_MINUTE_24H;
        this.h = 1;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r2, UDDialog r3) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        if ((r2 instanceof UDTimePickerBuilder) == false) goto L7;
        super.apply(r2, r3);
        UDTimePickerBuilder r4 = (UDTimePickerBuilder) r2;
        this.a = r4.a;
        this.d = r4.d;
        this.c = r4.c;
        this.b = r4.b;
        this.f = r4.f;
        this.e = r4.e;
        this.g = r4.g;
        this.h = r4.h;
        this.i = r4.i;
        this.j = r4.j;
        this.k = r4.k;
        return;
    L7:
        throw new IllegalArgumentException("builder should be UDTimePickerBuilder, but actually ".concat(r2.getClass().getSimpleName()).toString());
    }

    public static final void b(a r3, UDTimePickerBuilder.a r4, CalendarDate r5) {
        UDDialog r6 = r3.getMDialog();
        if (r6 == null) goto L6;
        int r0 = r5.getYear();
        int r1 = r5.getMonth() - 1;
        int r2 = r5.getMonthDay();
        r5.getHour();
        r5.getMinute();
        r4.a(r6, r0, r1, r2);
        return;
    }
}
