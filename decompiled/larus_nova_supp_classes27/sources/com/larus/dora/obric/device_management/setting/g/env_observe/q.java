package com.larus.dora.obric.device_management.setting.g.env_observe;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class q {
    public final Function2<Integer, Integer, Unit> a;
    public int b;
    public int c;
    public int d;
    public final OSheet e;

    public static final class a {
    }

    static {
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

    public q(Context r11, String r12, List r13, List r14, c r15) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "type");
        Intrinsics.checkNotNullParameter(r13, "startTime");
        Intrinsics.checkNotNullParameter(r14, "endTime");
        Intrinsics.checkNotNullParameter(r15, "onConfirm");
        this.a = r15;
        if (Intrinsics.areEqual(r12, EnvObserveViewModel.START_TIME_SET) == true) goto L6;
        r13 = r14;
    L6:
        Integer r0 = (Integer) CollectionsKt.getOrNull(r13, 0);
        if (r0 == null) goto L9;
        int r1 = RangesKt.coerceIn(r0.intValue(), 0, 23);
    L10:
        int r2 = 12;
        if (r1 >= 12) goto L13;
        int r3 = 0;
    L14:
        this.b = r3;
        int r4 = r1 % 12;
        if (r4 == 0) goto L18;
        r2 = r4;
    L18:
        this.c = r2 - 1;
        Integer r16 = (Integer) CollectionsKt.getOrNull(r13, 1);
        if (r16 == null) goto L21;
        int r17 = RangesKt.coerceIn(r16.intValue(), 0, 59);
    L22:
        this.d = r17;
        hma.c.a r18 = new hma.c.a();
        hma.c.a.b(r18, r11, 0, Integer.valueOf(this.b));
        hma.c.a.d(r18, r11, 1, false, false, Integer.valueOf(this.c + 1));
        hma.c.a.e(r18, r11, 2, false, Integer.valueOf(this.d));
        Consumer r5 = new p(this);
        Intrinsics.checkNotNullParameter(r5, "listener");
        r18.a = r5;
        hma.c r110 = (hma.c) hma.d.a.a(r18, r11);
        final OSheet r9 = new OSheet(r11, 0, false, 30);
        OSheetBase.DefaultImpls.q(r9, OSheet.HeightMode.WRAP_HEIGHT);
        OSheet.Header r6 = OSheet.Header.ACTION;
        if (Intrinsics.areEqual(r12, EnvObserveViewModel.START_TIME_SET) == false) goto L25;
        int r111 = 2131902557;
    L26:
        OSheetBase.DefaultImpls.o(r9, r6, Integer.valueOf(r111), null, null, true, new n(r9), new o(this, r9), 16156);
        OSheetBase.DefaultImpls.j(r9, r110.a());
        this.e = r9;
        return;
    L25:
        r111 = 2131902554;
        goto L26
    L21:
        r17 = 0;
        goto L22
    L13:
        r3 = 1;
        goto L14
    L9:
        r1 = 0;
        goto L10
    }
}
