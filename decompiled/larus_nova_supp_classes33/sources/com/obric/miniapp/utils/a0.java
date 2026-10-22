package com.obric.miniapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.memorydata.sdk.entity.search.SearchError;
import com.obric.oui.picker.reels.views.OReelPickerMulti;
import com.obric.oui.picker.reels.views.WheelView;
import com.obric.oui.selection.OSelectionPanelBtnView;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import java.lang.ref.WeakReference;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a0 {
    public static final a0 a = null;
    public static final Lazy b = null;
    public static final HashSet<Integer> c = null;
    public static WeakReference<OSheet> d;

    public static final class a {
        public final Long a;
        public final Long b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Long r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Long r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "PickerTimestampBounds(minTimestamp=" + this.a + ", maxTimestamp=" + this.b + ')';
        }

        public final long a(long r4) {
            Long r0 = this.a;
            if (r0 != null) goto L5;
        L7:
            Long r1 = this.b;
            if (r1 != null) goto L10;
            return r4;
        L10:
            if (r4 > r1.longValue()) goto L12;
            return r4;
        L12:
            return this.b.longValue();
        L5:
            if (r4 >= r0.longValue()) goto L7;
            return this.a.longValue();
        }

        public a(Long r1, Long r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ OSheet b;

        public b(String r1, OSheet r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void b() {
            a0 r2 = a0.a;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
            FLogger.a.i("DatePickerUtils", "dismissActiveSheet reason=" + this.a);     // Catch: Throwable -> L8
            if (this.b.isShowing() == false) goto L6;
            a(this.b);     // Catch: Throwable -> L8
        L6:
            Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L10:
            Throwable r4 = Result.exceptionOrNull-impl(r1);
            if (r4 == null) goto L16;
            FLogger.a.w("DatePickerUtils", "dismissActiveSheet failed: " + r4.getMessage());
            return;
        L16:
            return;
        L8:
            th = move-exception;
            Result.Companion r5 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L10
        }

        @Override // java.lang.Runnable
        public final void run() {
            b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public static void a(OSheet r3) {
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
    }

    public static final class c implements Runnable {
        public final /* synthetic */ OSheet a;
        public final /* synthetic */ Function1 b;

        public c(OSheet r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            a0 r0 = a0.a;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
            OSheet r2 = this.a;     // Catch: Throwable -> L11
            if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L20;
            DialogLancet.handleBlockedDialogShow(r2);     // Catch: Throwable -> L11
        L9:
            Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
        L13:
            Throwable r4 = Result.exceptionOrNull-impl(r3);
            if (r4 == null) goto L22;
            this.b.invoke(r4);
            return;
        L22:
            return;
        L20:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17 Throwable -> L11
        L8:
            DialogLancet.beforeDialogShow(r2);     // Catch: Throwable -> L11
            r2.show();     // Catch: Throwable -> L11
            DialogLancet.afterDialogShow(r2);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            Result.Companion r5 = Result.Companion;
            r3 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L13
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a0() {
    }

    public static long n(long r3) {
        if (0 <= r3) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
        return r3;
    L10:
        return r3 * ((long) SearchError.ERR_UNKNOWN);
    L5:
        if (r3 >= 1000000000000L) goto L7;
        r0 = true;
        goto L8
    }

    static {
        a = new a0();
        b = LazyKt.lazy(LazyThreadSafetyMode.NONE, new h());
        c = new HashSet();
    }

    public static void a(OInsetSheet r3) {
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

    public static void b(OSheet r3) {
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

    public static void c(OInsetSheet r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public static final Handler d(a0 r0) {
        r0.getClass();
        return (Handler) b.getValue();
    }

    public static void i(OSheet r2) {
        WeakReference<OSheet> r0 = d;
        if (r0 == null) goto L5;
        OSheet r1 = r0.get();
    L6:
        if (r1 != r2) goto L9;
        d = null;
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static Activity l(Context r1) {
    L3:
        if ((r1 instanceof ContextWrapper) == false) goto L10;
        if ((r1 instanceof Activity) == true) goto L7;
        r1 = ((ContextWrapper) r1).getBaseContext();
        goto L3
    L7:
        return (Activity) r1;
    L10:
        if ((r1 instanceof Activity) == true) goto L16;
        return null;
    L16:
        return (Activity) r1;
    }

    public static LocalDate v(long r0) {
        return Instant.ofEpochMilli(r0).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.time.LocalDateTime] */
    public static LocalDateTime w(long r0) {
        return Instant.ofEpochMilli(r0).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public final void k(String r6) {
        WeakReference<OSheet> r2 = d;
        if (r2 == null) goto L23;
        OSheet r3 = r2.get();
        if (r3 == null) goto L26;
        d = null;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L21;
        d(this).post(new b(r6, r3));
        return;
    L21:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L14
        FLogger.a.i("DatePickerUtils", "dismissActiveSheet reason=".concat(r6));     // Catch: Throwable -> L14
        if (r3.isShowing() == false) goto L12;
        b(r3);     // Catch: Throwable -> L14
    L12:
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L24;
        FLogger.a.w("DatePickerUtils", "dismissActiveSheet failed: " + r8.getMessage());
        return;
    L24:
        return;
    L14:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L26:
        return;
    }

    public static List f(Context r3, int r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r5 = Result.constructor-impl(r3.getString(2131912863));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r5) == false) goto L9;
        r5 = null;
    L9:
        String r6 = (String) r5;
        if (r6 != null) goto L12;
        r6 = "";
    L12:
        IntRange r1 = new IntRange(1, r4);
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        IntIterator r2 = r1.iterator();
    L14:
        if (r2.hasNext() == false) goto L16;
        r7.add(r2.nextInt() + r6);
        goto L14
    L16:
        return r7;
    L4:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static FrameLayout j(Context r4, hma.c r5) {
        FrameLayout r0 = new FrameLayout(r4);
        View r6 = r5.a();
        if (r6 == null) goto L12;
        r0.removeAllViews();
        ViewGroup.LayoutParams r1 = r6.getLayoutParams();
        int r2 = -2;
        if (r1 == null) goto L7;
        int r3 = r1.width;
    L8:
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L11;
        r2 = r7.height;
    L11:
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(r3, r2);
        r8.gravity = 17;
        r6.setLayoutParams(r8);
        r0.addView(r6);
        goto L12
    L7:
        r3 = -2;
    L12:
        return r0;
    }

    public static Pair o(JSONObject r4, a r5) {
        if (r4 == null) goto L8;
        String r0 = r4.optString("from");
        if (r0 == null) goto L8;
        Integer r1 = StringsKt.toIntOrNull(r0);
        if (r1 == null) goto L8;
        int r2 = r1.intValue();
    L9:
        if (r4 == null) goto L15;
        String r6 = r4.optString("to");
        if (r6 == null) goto L15;
        Integer r7 = StringsKt.toIntOrNull(r6);
        if (r7 == null) goto L15;
        int r8 = r7.intValue();
    L16:
        Long r3 = r5.a;
        if (r3 == null) goto L19;
        long r9 = r3.longValue();
        a.getClass();
        r2 = Math.max(r2, v(r9).getYear());
    L19:
        Long r10 = r5.b;
        if (r10 == null) goto L22;
        long r11 = r10.longValue();
        a.getClass();
        r8 = Math.min(r8, v(r11).getYear());
    L22:
        if (r2 <= r8) goto L25;
        r8 = r2;
    L25:
        return TuplesKt.to(Integer.valueOf(r2), Integer.valueOf(r8));
    L15:
        r8 = 2030;
    L8:
        r2 = 2000;
        goto L9
    }

    public static final Integer r(JSONObject r0, String r1) {
        if (r0 == null) goto L6;
        String r2 = r0.optString(r1);
        if (r2 == null) goto L6;
        return StringsKt.toIntOrNull(r2);
    L6:
        return null;
    }

    public final void u(OSheet r3, Function1<? super Throwable, Unit> r4) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L20;
        d(this).post(new c(r3, r4));
        return;
    L20:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L22;
        DialogLancet.handleBlockedDialogShow(r3);     // Catch: Throwable -> L12
    L10:
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L24;
        r4.invoke(r6);
        return;
    L24:
        return;
    L22:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19 Throwable -> L12
    L9:
        DialogLancet.beforeDialogShow(r3);     // Catch: Throwable -> L12
        r3.show();     // Catch: Throwable -> L12
        DialogLancet.afterDialogShow(r3);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public static JSONObject h(String r8, long r9, boolean r11) {
        LocalDateTime r0 = w(r9);
        if (r11 == false) goto L5;
        int r12 = r0.getHour();
    L8:
        int r2 = r0.getMinute();
        if (r0.getHour() >= 12) goto L11;
        boolean r1 = true;
    L12:
        JSONObject r3 = new JSONObject();
        r3.put("date", r0.toLocalDate().toString());
        r3.put("year", r0.getYear());
        r3.put("month", r0.getMonthValue());
        r3.put("day", r0.getDayOfMonth());
        r3.put("hour", r12);
        r3.put("minute", r2);
        r3.put("timestamp", r9);
        r3.put("isAm", r1);
        if (Intrinsics.areEqual(r8, "time_with_am_pm") == false) goto L19;
        StringCompanionObject r10 = StringCompanionObject.INSTANCE;
        Object[] r4 = new Object[3];
        r4[0] = Integer.valueOf(r12);
        r4[1] = Integer.valueOf(r2);
        if (r1 == false) goto L17;
        String r13 = "上午";
    L18:
        r4[2] = r13;
        r3.put("formatted", String.format("%02d:%02d %s", Arrays.copyOf(r4, 3)));
    L20:
        return r3;
    L17:
        r13 = "下午";
        goto L18
    L19:
        StringCompanionObject r14 = StringCompanionObject.INSTANCE;
        r3.put("formatted", String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r12), Integer.valueOf(r2)}, 2)));
        goto L20
    L11:
        r1 = false;
        goto L12
    L5:
        r12 = r0.getHour() % 12;
        if (r12 != 0) goto L8;
        r12 = 12;
        goto L8
    }

    public static OSelectionPanelBtnView m(Context r2, View.OnClickListener r3, View.OnClickListener r4) {
        OSelectionPanelBtnView r0 = new OSelectionPanelBtnView(r2, null);
        r0.getBtnNegative().setText("取消");
        r0.getBtnPositive().setText("确认");
        r0.getBtnNegative().setOnClickListener(r3);
        r0.getBtnPositive().setOnClickListener(r4);
        return r0;
    }

    public static final void s(AtomicBoolean r2, g r3, Long r4) {
        if (r2.compareAndSet(false, true) == false) goto L7;
        if (r3 == null) goto L8;
        r3.a(r4);
        return;
    L8:
        return;
    }

    public static final void t(AtomicBoolean r2, g r3, Long r4) {
        if (r2.compareAndSet(false, true) == false) goto L7;
        if (r3 == null) goto L8;
        r3.a(r4);
        return;
    L8:
        return;
    }

    public static final void q(AtomicBoolean r2, Function3<? super Boolean, ? super JSONObject, ? super Map<Integer, Integer>, Unit> r3, boolean r4, JSONObject r5, Map<Integer, Integer> r6) {
        if (r2.compareAndSet(false, true) == false) goto L6;
        r3.invoke(Boolean.valueOf(r4), r5, r6);
        return;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.time.ZonedDateTime] */
    public static long g(String r1, LocalDate r2, int r3, int r4, Integer r5, boolean r6) {
        if (r6 == true) goto L6;
        r3 = r3 + 1;
    L6:
        if (Intrinsics.areEqual(r1, "time_with_am_pm") == false) goto L23;
        if (r6 == true) goto L28;
        if (r5 != null) goto L12;
    L15:
        if (r5 != null) goto L18;
    L20:
        if (r3 != 12) goto L22;
        r3 = 12;
        goto L28
    L22:
        r3 = r3 + 12;
        goto L28
    L18:
        if (r5.intValue() != 0) goto L20;
    L12:
        if (r5.intValue() != 0) goto L15;
        if (r3 != 12) goto L15;
    L26:
        r3 = 0;
    L28:
        return r2.atTime(r3, r4).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    L23:
        if (r6 == true) goto L28;
        if (r3 != 12) goto L28;
        goto L26
    }

    public static void e(Context r4, hma.c r5, Map r6, int r7, int r8, int r9, int r10, int r11, int r12) {
        int r0 = System.identityHashCode(r5);
        HashSet<Integer> r1 = c;
        monitor-enter(r1);
    L98:
        th = move-exception;
        throw th;
    L5:
        if (r1.add(Integer.valueOf(r0)) == true) goto L8;
        monitor-exit(r1);
        return;
    L8:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L98
        monitor-exit(r1);
        OReelPickerMulti r13 = r5.a();     // Catch: Throwable -> L89
        Object r3 = null;
        if ((r13 instanceof OReelPickerMulti) == true) goto L15;
        r13 = null;
    L15:
        if (r13 != null) goto L24;
        monitor-enter(r1);
        r1.remove(Integer.valueOf(r0));     // Catch: Throwable -> L20
        monitor-exit(r1);
        return;
    L20:
        th = move-exception;
        throw th;
    L24:
        WheelView r14 = r13.L0(2);     // Catch: Throwable -> L89
        if (r14 != null) goto L33;
        monitor-enter(r1);
        r1.remove(Integer.valueOf(r0));     // Catch: Throwable -> L30
        monitor-exit(r1);
        return;
    L30:
        th = move-exception;
        throw th;
    L33:
        if (r6 == null) goto L37;
        Integer r15 = (Integer) r6.get(Integer.valueOf(r7));     // Catch: Throwable -> L89
        if (r15 == null) goto L37;
        r11 = r10 + r15.intValue();     // Catch: Throwable -> L89
    L37:
        boolean r16 = true;
        if (r6 == null) goto L101;
        Integer r17 = (Integer) r6.get(Integer.valueOf(r8));     // Catch: Throwable -> L89
        if (r17 == null) goto L101;
        r12 = r17.intValue() + 1;
    L101:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L45
        Object r19 = Result.constructor-impl(Integer.valueOf(YearMonth.of(r11, r12).lengthOfMonth()));     // Catch: Throwable -> L45
    L48:
        if (Result.isFailure-impl(r19) == true) goto L51;
        r3 = r19;
    L51:
        Integer r20 = (Integer) r3;     // Catch: Throwable -> L89
        if (r20 == null) goto L54;
        int r21 = r20.intValue();     // Catch: Throwable -> L89
    L56:
        if (r6 == null) goto L60;
        Integer r22 = (Integer) r6.get(Integer.valueOf(r9));     // Catch: Throwable -> L89
        if (r22 == null) goto L60;
        int r23 = r22.intValue();     // Catch: Throwable -> L89
    L61:
        int r24 = RangesKt.coerceIn(r23, 0, RangesKt.coerceAtLeast(r21 - 1, 0));     // Catch: Throwable -> L89
        if (r14.getItemSize() == r21) goto L64;
        boolean r110 = true;
    L65:
        if (r23 != r24) goto L68;
        r16 = false;
    L68:
        if (r110 == true) goto L78;
        if (r16 == true) goto L78;
        HashSet<Integer> r25 = c;
        monitor-enter(r25);
        r25.remove(Integer.valueOf(r0));     // Catch: Throwable -> L75
        monitor-exit(r25);
        return;
    L75:
        th = move-exception;
        throw th;
    L78:
        if (r110 == false) goto L80;
        r14.setStartIndex(r24);     // Catch: Throwable -> L89
        r14.setEntries(f(r4, r21));     // Catch: Throwable -> L89
    L81:
        HashSet<Integer> r26 = c;
        monitor-enter(r26);
        r26.remove(Integer.valueOf(r0));     // Catch: Throwable -> L86
        monitor-exit(r26);
        return;
    L86:
        th = move-exception;
        throw th;
    L80:
        r14.i(r24);     // Catch: Throwable -> L89
        goto L81
    L64:
        r110 = false;
    L60:
        r23 = 0;
        goto L61
    L54:
        r21 = 31;
    L45:
        th = move-exception;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L89
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        HashSet<Integer> r27 = c;
        monitor-enter(r27);
        r27.remove(Integer.valueOf(r0));     // Catch: Throwable -> L95
        throw th;
    L95:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r15v10, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v9 */
    public static void p(a0 r22, Context r23, final String r24, String r25, JSONObject r26, final JSONObject r27, final List r28, final boolean r29, boolean r30, Integer r31, Integer r32, Long r33, Long r34, final com.obric.miniapp.aibridge.a0 r35) {
        r22.getClass();
        Intrinsics.checkNotNullParameter(r23, "ctx");
        Intrinsics.checkNotNullParameter(r24, "type");
        Intrinsics.checkNotNullParameter(r35, "callback");
        r22.k("showAppletShowDatePicker");
        hma.c.a r13 = new hma.c.a();
        if (r25 != null) goto L5;
        String r14 = "选择";
    L6:
        if (r33 == null) goto L8;
        Long r0 = Long.valueOf(n(r33.longValue()));
    L9:
        if (r34 == null) goto L11;
        Long r2 = Long.valueOf(n(r34.longValue()));
    L12:
        if (r0 == null) goto L17;
        if (r2 == null) goto L17;
        if (r0.longValue() <= r2.longValue()) goto L17;
        r2 = r0;
    L17:
        a r9 = new a(r0, r2);
        if (r26 == null) goto L36;
        String r1 = r26.optString("date");
        if (r1 == null) goto L36;
        if ((!StringsKt.isBlank(r1)) == true) goto L25;
        r1 = null;
    L25:
        if (r1 == null) goto L36;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L28
        Object r3 = Result.constructor-impl(LocalDate.parse(r1));     // Catch: Throwable -> L28
    L31:
        if (Result.isFailure-impl(r3) == false) goto L33;
        r3 = null;
    L33:
        LocalDate r4 = (LocalDate) r3;
        if (r4 == null) goto L36;
    L88:
        switch(r24.hashCode()) {
            case -930218263: goto L168;
            case 99228: goto L159;
            case 3560141: goto L118;
            case 3704893: goto L110;
            case 104080000: goto L101;
            case 1126698537: goto L91;
            default: goto L89;
        };
    L89:
        String r19 = r14;
        boolean r15 = false;
        a r16 = r9;
    L103:
        boolean r17 = r15;
    L228:
        r13.g(SearchError.ERR_PACKAGE_RUN_TIMEOUT, CollectionsKt.listOf("Unsupported: ".concat(r24)), null, 0, 1.0f, null, null, r23);
        ?? r18 = r17;
    L230:
        if (r31 == null) goto L232;
        int r6 = r31.intValue();
        a.getClass();
        Resources r7 = r23.getResources();
        r13.b = Integer.valueOf((int) ((r6 * WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()).density) + 0.5f));
    L232:
        if (r32 == null) goto L234;
        int r8 = r32.intValue();
        a.getClass();
        Resources r10 = r23.getResources();
        r13.c = Integer.valueOf((int) ((r8 * WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()).density) + 0.5f));
    L234:
        final Function1 r11 = null;
        Consumer r12 = new r(r11);
        Intrinsics.checkNotNullParameter(r12, "listener");
        r13.a = r12;
        final hma.c r20 = (hma.c) hma.d.a.a(r13, r23);
        FrameLayout r110 = j(r23, r20);
        final AtomicBoolean r21 = new AtomicBoolean(r18);
        Activity r36 = l(r23);
        if (r36 != null) goto L237;
    L246:
        FLogger.a.w("DatePickerUtils", "showAppletShowDatePicker blocked: invalid Activity context");
        q(r21, r35, true, null, null);
        c1.a(r23, r18);
        return;
    L237:
        if (r36.isFinishing() == true) goto L246;
        if (r36.isDestroyed() == true) goto L246;
        final OSheetBase r111 = c1.a(r23, r18);
        d = new WeakReference(r111);
        final a r37 = r16;
        final LocalDate r38 = r4;
        OSheetBase.DefaultImpls.o(r111, OSheet.Header.ACTION, null, r19, null, true, new s(r111, r21, r35), new t(r20, r24, r27, r37, r38, r29, r28, r111, r21, r35), 16134);
        OSheetBase.DefaultImpls.j(r111, r110);
        r111.setOnDismissListener(new u(r111, r21, r35));
        if (DialogLancet.shouldBlockDialogShow(r111) == false) goto L251;
        DialogLancet.handleBlockedDialogShow(r111);
        return;
    L251:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L248
    L245:
        DialogLancet.beforeDialogShow(r111);
        r111.show();
        DialogLancet.afterDialogShow(r111);
        return;
    L101:
        r19 = r14;
        r15 = false;
        r16 = r9;
        if (r24.equals("month") == false) goto L103;
        Integer r39 = r(r26, "month");
        if (r39 == null) goto L107;
        int r40 = r39.intValue();
    L108:
        r13.f(r23, 1002, Integer.valueOf(RangesKt.coerceIn(r40, 1, 12)), null);
    L167:
        r18 = 0;
        goto L230
    L107:
        r40 = LocalDate.now().getMonthValue();
        goto L108
    L110:
        r19 = r14;
        r17 = false;
        r16 = r9;
        if (r24.equals("year") == false) goto L228;
        Pair r41 = o(r27, r16);
        int r42 = ((Number) r41.component1()).intValue();
        int r43 = ((Number) r41.component2()).intValue();
        Integer r44 = r(r26, "year");
        if (r44 == null) goto L116;
        int r45 = r44.intValue();
    L117:
        r13.i(r23, 1001, r42, r43, Integer.valueOf(RangesKt.coerceIn(r45, r42, r43)), null);
        goto L167
    L116:
        r45 = LocalDate.now().getYear();
        goto L117
    L118:
        r19 = r14;
        r16 = r9;
        if (r24.equals("time") == false) goto L170;
        Integer r46 = r(r26, "hour");
        Integer r47 = r(r26, "minute");
        if (r47 == null) goto L124;
        int r48 = r47.intValue();
        int r49 = 59;
    L125:
        int r50 = RangesKt.coerceIn(r48, 0, r49);
        if (r29 == false) goto L132;
        if (r46 == null) goto L129;
        int r51 = r46.intValue();
    L130:
        int r52 = RangesKt.coerceIn(r51, 0, 23);
    L152:
        LocalDateTime r112 = w(r16.a(g(r24, r4, r52, r50, null, r29)));
        if (r29 == false) goto L155;
        int r53 = r112.getHour();
    L158:
        hma.c.a.d(r13, r23, SearchError.ERR_INTERNAL_ERROR, r29, r30, Integer.valueOf(r53));
        hma.c.a.e(r13, r23, SearchError.ERR_MODEL_NOT_READY, r30, Integer.valueOf(r112.getMinute()));
        goto L167
    L155:
        r53 = r112.getHour() % 12;
        if (r53 != 0) goto L158;
        r53 = 12;
        goto L158
    L129:
        r51 = LocalDateTime.now().getHour();
        goto L130
    L132:
        if (r46 == null) goto L134;
        int r54 = r46.intValue();
    L135:
        if (1 <= r54) goto L137;
    L139:
        boolean r55 = false;
    L140:
        if (r55 == true) goto L151;
        if (r54 >= 0) goto L144;
    L146:
        boolean r56 = false;
    L147:
        if (r56 == false) goto L150;
        r54 = r54 % 12;
        if (r54 != 0) goto L151;
    L150:
        r54 = 12;
        goto L151
    L144:
        if (r54 >= 24) goto L146;
        r56 = true;
    L151:
        r52 = RangesKt.coerceAtLeast(r54 - 1, 0);
        goto L152
    L137:
        if (r54 >= 13) goto L139;
        r55 = true;
        goto L140
    L134:
        r54 = 12;
        goto L135
    L124:
        r49 = 59;
        r48 = 0;
    L170:
        r17 = false;
        goto L228
    L159:
        r19 = r14;
        r16 = r9;
        if (r24.equals("day") == false) goto L170;
        Integer r57 = r(r26, "day");
        if (r57 == null) goto L165;
        int r58 = r57.intValue();
    L166:
        hma.c.a.c(r13, r23, 1003, Integer.valueOf(RangesKt.coerceIn(r58, 1, 31)));
        goto L167
    L165:
        r58 = LocalDate.now().getDayOfMonth();
        goto L166
    L168:
        r19 = r14;
        r16 = r9;
        if (r24.equals("time_with_am_pm") == false) goto L170;
        Integer r59 = r(r26, "hour");
        Integer r60 = r(r26, "minute");
        if (r60 == null) goto L174;
        int r61 = r60.intValue();
        int r62 = 59;
    L175:
        int r63 = RangesKt.coerceIn(r61, 0, r62);
        if (r26 == null) goto L180;
        String r64 = r26.optString("isAm");
        if (r64 == null) goto L180;
        Boolean r65 = StringsKt.toBooleanStrictOrNull(r64);
    L181:
        if (r29 == false) goto L186;
        if (r59 == null) goto L184;
        int r66 = r59.intValue();
    L185:
        int r67 = RangesKt.coerceIn(r66, 0, 23);
    L206:
        if (r65 != null) goto L208;
        if (r59 != null) goto L212;
    L215:
        int r68 = 0;
    L216:
        r18 = 0;
        LocalDateTime r69 = w(r16.a(g(r24, r4, r67, r63, Integer.valueOf(r68), r29)));
        if (r29 == false) goto L219;
        int r70 = r69.getHour();
    L222:
        int r71 = r70;
    L223:
        hma.c.a.d(r13, r23, SearchError.ERR_INTERNAL_ERROR, r29, r30, Integer.valueOf(r71));
        hma.c.a.e(r13, r23, SearchError.ERR_MODEL_NOT_READY, r30, Integer.valueOf(r69.getMinute()));
        if (r69.getHour() >= 12) goto L226;
        int r72 = 0;
    L227:
        hma.c.a.b(r13, r23, SearchError.ERR_PACKAGE_FAILED, Integer.valueOf(r72));
        goto L230
    L226:
        r72 = 1;
        goto L227
    L219:
        r70 = r69.getHour() % 12;
        if (r70 != 0) goto L222;
        r71 = 12;
        goto L223
    L212:
        if (r59.intValue() < 12) goto L215;
    L214:
        r68 = 1;
        goto L216
    L208:
        if (r65.booleanValue() == false) goto L214;
    L184:
        r66 = LocalDateTime.now().getHour();
        goto L185
    L186:
        if (r59 == null) goto L188;
        int r73 = r59.intValue();
    L189:
        if (1 <= r73) goto L191;
    L193:
        boolean r74 = false;
    L194:
        if (r74 == true) goto L205;
        if (r73 >= 0) goto L198;
    L200:
        boolean r75 = false;
    L201:
        if (r75 == false) goto L204;
        r73 = r73 % 12;
        if (r73 != 0) goto L205;
    L204:
        r73 = 12;
        goto L205
    L198:
        if (r73 >= 24) goto L200;
        r75 = true;
    L205:
        r67 = RangesKt.coerceAtLeast(r73 - 1, 0);
        goto L206
    L191:
        if (r73 >= 13) goto L193;
        r74 = true;
        goto L194
    L188:
        r73 = 12;
    L180:
        r65 = null;
        goto L181
    L174:
        r62 = 59;
        r61 = 0;
        goto L175
    L91:
        if (r24.equals("custom_repeat") == false) goto L89;
        if (r28 != null) goto L95;
        List r76 = CollectionsKt.emptyList();
    L96:
        Integer r77 = r(r26, "customIndex");
        if (r77 == null) goto L99;
        int r78 = r77.intValue();
    L100:
        r18 = 0;
        r19 = r14;
        r16 = r9;
        r13.g(SearchError.ERR_PACKAGE_RUN_TIMEOUT, r76, null, RangesKt.coerceIn(r78, 0, RangesKt.coerceAtLeast(r76.size() - 1, 0)), 1.0f, null, null, r23);
        goto L230
    L99:
        r78 = 0;
        goto L100
    L95:
        r76 = r28;
    L28:
        th = move-exception;
        Result.Companion r79 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
    L36:
        if (r26 == null) goto L58;
        Object r80 = r26.opt("timestamp");
        if (r80 == null) goto L58;
        if ((r80 instanceof Number) == false) goto L43;
        a0 r81 = a;
        long r113 = ((Number) r80).longValue();
        r81.getClass();
        Long r82 = Long.valueOf(n(r113));
    L56:
        if (r82 == null) goto L58;
        long r114 = r82.longValue();
        a.getClass();
        r4 = v(r114);
        goto L88
    L43:
        if ((r80 instanceof String) == false) goto L55;
        String r83 = StringsKt.trim((String) r80).toString();
        if (r83.length() <= 0) goto L47;
        boolean r84 = true;
    L48:
        if (r84 == true) goto L51;
        r83 = null;
    L51:
        if (r83 == null) goto L55;
        Long r85 = StringsKt.toLongOrNull(r83);
        if (r85 == null) goto L55;
        a0 r86 = a;
        long r115 = r85.longValue();
        r86.getClass();
        r82 = Long.valueOf(n(r115));
        goto L56
    L47:
        r84 = false;
    L55:
        r82 = null;
    L58:
        if (r26 == null) goto L62;
        String r87 = r26.optString("year");
        if (r87 == null) goto L62;
        Integer r88 = StringsKt.toIntOrNull(r87);
    L63:
        if (r26 == null) goto L67;
        String r89 = r26.optString("month");
        if (r89 == null) goto L67;
        Integer r90 = StringsKt.toIntOrNull(r89);
    L68:
        if (r26 == null) goto L72;
        String r116 = r26.optString("day");
        if (r116 == null) goto L72;
        Integer r117 = StringsKt.toIntOrNull(r116);
    L73:
        if (r88 == null) goto L86;
        if (r90 == null) goto L86;
        if (r117 == null) goto L86;
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L78
        Object r91 = Result.constructor-impl(LocalDate.of(r88.intValue(), r90.intValue(), r117.intValue()));     // Catch: Throwable -> L78
    L81:
        if (Result.isFailure-impl(r91) == false) goto L83;
        r91 = null;
    L83:
        r4 = (LocalDate) r91;
        if (r4 == null) goto L86;
    L78:
        th = move-exception;
        Result.Companion r92 = Result.Companion;
        r91 = Result.constructor-impl(ResultKt.createFailure(th));
    L86:
        r4 = LocalDate.now();
    L72:
        r117 = null;
    L67:
        r90 = null;
    L62:
        r88 = null;
        goto L63
    L11:
        r2 = null;
        goto L12
    L8:
        r0 = null;
        goto L9
    L5:
        r14 = r25;
        goto L6
    }
}
