package com.larus.bmhome.interactionpanel;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.im.bean.thread.ThreadData;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class y0 implements Runnable {
    public final /* synthetic */ ThreadInteractionPanelHostComponent a;
    public final /* synthetic */ String b;

    public /* synthetic */ y0(ThreadInteractionPanelHostComponent r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ThreadInteractionPanelHostComponent r0 = this.a;
        String r1 = this.b;
        int r2 = ThreadInteractionPanelHostComponent.r;
        r0.getClass();
        fe8.c r3 = s1a.d.a(r0).getAbility(fe8.c.class);
        if (r3 == null) goto L5;
        ThreadData r4 = r3.VE();
    L6:
        if (r4 == null) goto L8;
        String r5 = r4.getThreadId();
    L9:
        String r6 = "";
        if (r5 != null) goto L13;
        r5 = "";
    L13:
        if (StringsKt.isBlank(r5) == false) goto L21;
        fe8.a r7 = r0.Y2();
        if (r7 == null) goto L17;
        r5 = r7.Kd();
    L18:
        if (r5 != null) goto L21;
        r5 = "";
        goto L21
    L17:
        r5 = null;
    L21:
        if (StringsKt.isBlank(r5) == true) goto L40;
        if (r4 == null) goto L25;
        String r8 = r4.getSourceConversationId();
    L26:
        if (r8 != null) goto L29;
        r8 = "";
    L29:
        if (StringsKt.isBlank(r8) == false) goto L39;
        fe8.a r9 = r0.Y2();
        if (r9 == null) goto L33;
        String r10 = r9.K();
    L34:
        if (r10 == null) goto L37;
        r6 = r10;
    L37:
        r8 = r6;
        goto L39
    L33:
        r10 = null;
    L39:
        if (StringsKt.isBlank(r8) == true) goto L40;
        n.b r11 = new n.b(r8, r5);
    L42:
        if (r11 != null) goto L45;
        FLogger.a.w("ThreadInteractionPanelHost", "[" + r1 + "] skip bind, scope unavailable");
        return;
    L45:
        if (Intrinsics.areEqual(r0.p, r11) == true) goto L47;
    L49:
        Job r12 = r0.o;
        if (r12 == null) goto L52;
        Job.DefaultImpls.cancel$default(r12, null, 1, null);
    L52:
        r0.h3().a(r0.q, "thread_scope_changed");
        r0.q = null;
        r0.p = r11;
        String r13 = "thread_organizer_" + r11.a + '_' + r11.b;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        r0.o = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(r0, r0)), null, null, new ThreadInteractionPanelHostComponent$bindThreadScope$1$1(r0, r11, r13, null), 3, null);
        return;
    L47:
        if (r0.o == null) goto L49;
        return;
    L25:
        r8 = null;
    L40:
        r11 = null;
        goto L42
    L8:
        r5 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }
}
