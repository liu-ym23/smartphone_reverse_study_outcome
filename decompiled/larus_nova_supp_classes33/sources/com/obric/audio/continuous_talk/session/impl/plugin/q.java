package com.obric.audio.continuous_talk.session.impl.plugin;

import com.larus.call_plugins_doubao_common.manager.n0;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.ObricAssistantForAudioDelegate;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class q extends com.larus.call_plugins_doubao_common.h {
    public final boolean h;
    public Job i;
    public Job j;
    public Integer k;
    public final com.obric.audio.continuous_talk.c l;

    public final String T2() {
        return "ObricContTalkMediaFocusPlugin";
    }

    public final void Y2() {
        FLogger.a.i("ObricContTalkMediaFocusPlugin", "onMute, release mediaManager");
        O2(1.0f);
        n0 r0 = ((com.larus.call_plugins_doubao_common.h) this).g;
        if (r0 == null) goto L6;
        r0.k();
        return;
    }

    public final void b3() {
        FLogger.a.i("ObricContTalkMediaFocusPlugin", "onRelease, release mediaManager");
        super.b3();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
        Integer r1 = this.k;     // Catch: Throwable -> L13
        if (r1 != null) goto L7;
    L8:
        this.k = -1;     // Catch: Throwable -> L13
        n0 r2 = ((com.larus.call_plugins_doubao_common.h) this).g;     // Catch: Throwable -> L13
        if (r2 == null) goto L11;
        r2.a(-1, getContext().params().e);     // Catch: Throwable -> L13
    L11:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Job r3 = this.j;
        if (r3 == null) goto L18;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L18:
        this.j = null;
        Job r4 = this.i;
        if (r4 == null) goto L21;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L21:
        this.i = null;
        return;
    L7:
        if (r1.intValue() == (-1)) goto L11;
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.obric.audio.continuous_talk.session.impl.plugin.j] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.obric.audio.continuous_talk.session.impl.plugin.k] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.obric.audio.continuous_talk.session.impl.plugin.l] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.obric.audio.continuous_talk.session.impl.plugin.m] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.obric.audio.continuous_talk.session.impl.plugin.n] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.obric.audio.continuous_talk.session.impl.plugin.o] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.obric.audio.continuous_talk.session.impl.plugin.p] */
    public final void j3() {
        ((com.larus.call_plugins_doubao_common.h) this).g = new com.obric.audio.continuous_talk.session.impl.m(new j(this), new k(this), new l(this), new m(this), new n(this), new o(this), new p(this), new zb8.c(), this.h);
    }

    public final void e3() {
        super.e3();
        Job r0 = this.j;
        Job r1 = null;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        i1 r2 = ObricAssistantForAudioDelegate.b.c5();
        if (r2 == null) goto L10;
        CoroutineScope r3 = getContext().r();
        if (r3 == null) goto L10;
        Job r4 = BuildersKt.launch$default(r3, null, null, new ObricContTalkMediaFocusPlugin$collectSpecialInputStatus$1$1(r2, this, null), 3, null);
    L11:
        this.j = r4;
        CoroutineScope r5 = getContext().r();
        if (r5 == null) goto L14;
        r1 = BuildersKt.launch$default(r5, null, null, new ObricContTalkMediaFocusPlugin$collectDuplexState$1(this, null), 3, null);
    L14:
        this.i = r1;
        return;
    L10:
        r4 = null;
        goto L11
    }

    public final void g3() {
        super.g3();
        FLogger.a.i("ObricContTalkMediaFocusPlugin", "onStop, release mediaManager");
        O2(1.0f);
        n0 r0 = ((com.larus.call_plugins_doubao_common.h) this).g;
        if (r0 == null) goto L6;
        r0.k();
        return;
    }

    public q(com.obric.audio.continuous_talk.session.impl.a r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.h = true;
        t1a.b r3 = ObricChatContextServiceDelegate.b.b(AppHost.a.a().getCurrentActivity());
        if (r3 == null) goto L5;
        com.obric.audio.continuous_talk.c r4 = (com.obric.audio.continuous_talk.c) r3.getAbility(com.obric.audio.continuous_talk.c.class);
    L6:
        this.l = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void O2(float r4) {
        a r0 = (a) getContext().c(Reflection.getOrCreateKotlinClass(a.class), null);
        if (r0 != null) goto L6;
        FLogger.a.w("ObricContTalkMediaFocusPlugin", "updateMediaFocusVolumeFactor skipped, audio plugin not exist, volumeFactor=" + r4);
        return;
    L6:
        r0.O2(r4);
    }
}
