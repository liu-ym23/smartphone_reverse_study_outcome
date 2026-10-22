package com.bytedance.android.monitorV2.lynx.impl.blank;

import android.graphics.Rect;
import android.os.Handler;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.monitorV2.event.HybridEvent$TerminateType;
import com.bytedance.android.monitorV2.h;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.LynxView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashSet;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import oo.j;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.monitorV2.lynx.impl.e f3669a;

    public d(com.bytedance.android.monitorV2.lynx.impl.e r5) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_NAVIGATION);
        this.f3669a = r5;
    }

    public final void a() {
        Intrinsics.checkNotNullParameter("monitor", "detectFrom");
        Intrinsics.checkNotNullParameter("blank", "eventType");
        com.bytedance.android.monitorV2.event.a r10 = j.c("blank", null, null);
        com.bytedance.android.monitorV2.lynx.impl.e r5 = this.f3669a;
        LynxView r11 = r5.F();
        h.e().a().d().getClass();
        boolean r12 = Switches.f3590i.f3600a;
        HybridEvent$TerminateType r13 = HybridEvent$TerminateType.f3540a;
        r10.d(!r12, r13);
        if (r12 == true) goto L5;
        return;
    L5:
        boolean r14 = r5.f3692c.f3688c.f12568b;
        r10.d(!r14, r13);
        if (r14 == true) goto L9;
        return;
    L9:
        if (r11 != null) goto L11;
        boolean r15 = true;
    L12:
        r10.d(r15, HybridEvent$TerminateType.f);
        if (r15 == false) goto L15;
        return;
    L15:
        if (r11 != null) goto L17;
    L53:
        r10.b(HybridEvent$TerminateType.f3541b);
        return;
    L17:
        if (r11.getWidth() == 0) goto L53;
        if (r11.getHeight() == 0) goto L53;
        long r16 = System.currentTimeMillis() - r5.d;
        Lazy r17 = r5.e;
        if (r16 >= ((com.bytedance.android.monitorV2.settings.c) r17.getValue()).a()) goto L25;
        r10.b(HybridEvent$TerminateType.e);
        return;
    L25:
        String[] r18 = ((com.bytedance.android.monitorV2.settings.c) r17.getValue()).b();
        int r19 = r18.length;
        int r110 = 0;
    L26:
        String r111 = "";
        if (r110 >= r19) goto L55;
        String r112 = r18[r110];
        String r113 = r11.getTemplateUrl();
        if (r113 == null) goto L33;
        r111 = r113;
    L33:
        if (StringsKt.g(r111, r112) == true) goto L34;
        r110 = r110 + 1;
        goto L26
    L34:
        r10.b(HybridEvent$TerminateType.e);
        return;
    L55:
        Field r20 = LynxView.class.getDeclaredField("mLynxTemplateRender");     // Catch: Exception -> L41
        r20.setAccessible(true);     // Catch: Exception -> L41
        if (((LynxTemplateRender) r20.get(r11)) != null) goto L43;
        r10.b(HybridEvent$TerminateType.f3541b);     // Catch: Exception -> L41
        return;
    L43:
        final g r21 = new g(r11.getWidth(), r11.getHeight());
        long r22 = System.currentTimeMillis();
        Lazy r23 = e.f3670a;
        Intrinsics.checkNotNullParameter(r21, "projMap");
        Intrinsics.checkNotNullParameter(r11, "view");
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L46
        int[] r25 = new int[2];     // Catch: Throwable -> L46
        r11.getLocationInWindow(r25);     // Catch: Throwable -> L46
        int r26 = r25[0];     // Catch: Throwable -> L46
        Rect r114 = new Rect(r26, r25[1], r11.getWidth() + r26, r11.getHeight() + r25[1]);     // Catch: Throwable -> L46
        e.c(r11, r114, new HashSet(), new BlankViewDetector$detect$1$1(r114, r21));     // Catch: Throwable -> L46
        Object r27 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L46
    L48:
        Throwable r28 = Result.m127exceptionOrNullimpl(r27);
        if (r28 == null) goto L51;
        r21.a(0, 0, r11.getWidth(), r11.getHeight(), 1, r11.getClass().getSimpleName(), false);
        mn.h.g("default_handle", r28);
    L51:
        final long r115 = System.currentTimeMillis() - r22;
        g5.a r29 = new g5.a("blank");
        r29.f17039m = -1;
        r29.f17040n = -1.0f;
        r29.f17043q = "";
        r29.f17049x = "";
        Intrinsics.checkNotNullParameter("monitor", "<set-?>");
        r29.f17049x = "monitor";
        r29.f17034h = 2;
        r29.f17033c = MathKt.roundToInt(r11.getHeight() / r11.getResources().getDisplayMetrics().density);
        r29.d = MathKt.roundToInt(r11.getWidth() / r11.getResources().getDisplayMetrics().density);
        r29.f17041o = MathKt.roundToInt(r11.getAlpha() * 100);
        WeakReference r30 = new WeakReference(r11);
        final c r31 = new c(r29, this.f3669a, System.currentTimeMillis(), r10, this, r30);
        Handler r32 = com.bytedance.android.monitorV2.executor.b.f3573a;
        com.bytedance.android.monitorV2.executor.b.b(new BlankCheckTask$checkInternal$1(r21, r31, r115));
        return;
    L46:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r27 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L41:
        e = move-exception;
        r10.b(HybridEvent$TerminateType.f3542c);
        mn.h.g("default_handle", e);
        goto L43
    L11:
        r15 = false;
        goto L12
    }
}
