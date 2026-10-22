package com.ss.android.lark.custom.repeat;

import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.custom.repeat.entity.CalendarDate;
import com.ss.android.lark.custom.repeat.entity.EventRecurrence;
import com.ss.android.lark.custom.repeat.entity.RepeatMode;
import com.ss.android.lark.log.Log;
import java.util.Date;
import java.util.GregorianCalendar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ ChooseRepeatFragment a;

    public g(ChooseRepeatFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r14) {
        ChooseRepeatFragment r15 = this.a;
        if (r15.s != null) goto L5;
        boolean r0 = true;
    L6:
        String r1 = r15.h;
        CustomRepeatParams$DayOfWeek r2 = r15.j;
        EventRecurrence r3 = EventRecurrence.d(r1);     // Catch: Exception -> L9
    L11:
        RepeatMode r4 = new RepeatMode(r3);
        r4.setWeekStartDay(r2);
        CustomRepeatParams$DayOfWeek r5 = r15.j;
        boolean r6 = r15.l;
        boolean r7 = r15.m;
        boolean r8 = r15.n;
        GregorianCalendar r9 = r15.o;
        if (r9 == null) goto L14;
        CalendarDate r10 = new CalendarDate(new Date(r9.getTimeInMillis()), r9.getTimeZone());
    L15:
        nab.a r11 = new nab.a(r4, r5, r6, r7, r8, r10, r15.p, r15.q, r15.k);
        ChooseCustomRepeatFragment r12 = r15.s;
        if (r12 == null) goto L18;
        Intrinsics.checkNotNullParameter(r11, "customRepeatData");
        r12.Y90();
        r12.r.setIsSingleInWeek(r11.c);
        r12.r.setIsSingleInMonth(r11.d);
        r12.r.setWeekStartDay(r11.b);
        r12.aa0();
        r12.Z90();
    L19:
        ChooseCustomRepeatFragment r13 = r15.s;
        if (r13 != null) goto L23;
        return;
    L23:
        if (r0 == false) goto L29;
        FragmentTransaction r16 = r15.getChildFragmentManager().beginTransaction().setCustomAnimations(2130772644, 2130772645);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r16, r13, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131384291) == true) goto L28;
        r16 = r16.add(2131384291, r13, null);
    L28:
        r16.commitAllowingStateLoss();
    L30:
        r15.t.add(r13);
        r15.getChildFragmentManager().executePendingTransactions();
        return;
    L29:
        r15.getChildFragmentManager().beginTransaction().setCustomAnimations(2130772644, 2130772645).show(r13).commitAllowingStateLoss();
        goto L30
    L18:
        r15.s = new ChooseCustomRepeatFragment(r15.u, r11);
        goto L19
    L14:
        r10 = new CalendarDate();
    L9:
        e = move-exception;
        Log.e(EventRecurrence.A, "Parse EventRecurrence Error:" + e.getMessage());
        r3 = new EventRecurrence();
        goto L11
    L5:
        r0 = false;
        goto L6
    }
}
