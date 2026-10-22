package com.larus.business.floatchat.impl.component;

import android.view.View;
import com.larus.business.floatchat.api.AIChatInputConfig;
import com.larus.utils.logger.FLogger;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ AIChatInputConfigComponent a;
    public final /* synthetic */ dw8.d b;
    public final /* synthetic */ String c;

    public /* synthetic */ f(AIChatInputConfigComponent r1, dw8.d r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.larus.business.floatchat.impl.component.c] */
    @Override // java.lang.Runnable
    public final void run() {
        final AIChatInputConfigComponent r0 = this.a;
        dw8.d r1 = this.b;
        String r2 = this.c;
        if (Intrinsics.areEqual(r0.t, r1) == true) goto L5;
    L34:
        FLogger.a.i("AIChatInputConfigComponent", "[applyActionBarConfig] skip stale config");
        return;
    L5:
        if (Intrinsics.areEqual(r0.u, r2) == false) goto L34;
        com.larus.bmhome.instruction.g r4 = s1a.d.a(r0).getAbility(com.larus.bmhome.instruction.g.class);
        if (r4 != null) goto L10;
        FLogger.a.e("AIChatInputConfigComponent", "[applyActionBarConfig] InstructionInput ability is unavailable");
        return;
    L10:
        va8.c0 r3 = s1a.d.a(r0).getAbility(va8.c0.class);
        boolean r5 = true;
        String r6 = null;
        if (r3 == null) goto L17;
        String r7 = r3.uQ();
        if (r7 == null) goto L17;
        if ((!StringsKt.isBlank(r7)) == false) goto L17;
    L18:
        if (r7 != null) goto L20;
        FLogger.a.e("AIChatInputConfigComponent", "[installActionBarSnapshotFilter] ActionBar scope is unavailable");
        r5 = false;
    L28:
        if (r5 == false) goto L38;
        com.larus.bmhome.instruction.g.a.a(r4, CollectionsKt.listOf(new fw8.a(new c(r0), r2)), new d(), null, null, 26);
        AIChatInputConfig r8 = r0.s;
        View r9 = r0.F;
        if (r9 == null) goto L39;
        r9.post(new g(r0, r8, r9));
        return;
    L39:
        return;
    L38:
        return;
    L20:
        fw8.b r10 = new fw8.b(r7);
        String r11 = r0.w;
        if (r11 != null) goto L23;
    L27:
        com.larus.bmhome.view.actionbar.api.a.a(r10);
        r0.w = r10.b;
        goto L28
    L23:
        if ((!Intrinsics.areEqual(r11, r10.b)) == false) goto L25;
        r6 = r11;
    L25:
        if (r6 == null) goto L27;
        com.larus.bmhome.view.actionbar.api.a.b(r6);
    L17:
        r7 = null;
        goto L18
    }
}
