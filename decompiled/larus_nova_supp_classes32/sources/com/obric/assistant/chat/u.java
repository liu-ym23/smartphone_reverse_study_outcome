package com.obric.assistant.chat;

import com.larus.bmhome.chat.component.list.u7;
import com.larus.platform.api.g0;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import s1a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class u implements Function0 {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ ObricChatService b;

    public /* synthetic */ u(boolean r1, ObricChatService r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.obric.assistant.chat.w] */
    public final Object invoke() {
        final boolean r0 = this.a;
        final ObricChatService r1 = this.b;
        if (r0 == true) goto L20;
        List r4 = ObricChatService.m;
        g0 r5 = r1.t();
        boolean r6 = false;
        if (r5 != null) goto L7;
    L9:
        boolean r7 = false;
    L10:
        if (r7 == false) goto L20;
        FLogger.a.i("ObricChatService", "setTtsEnable click to performClick cancel lottie");
        g0 r8 = r1.t();
        if (r8 != null) goto L14;
    L16:
        if (r6 == false) goto L20;
        g0 r9 = r1.t();
        if (r9 == null) goto L20;
        r9.Wa();
        goto L20
    L14:
        if (r8.Ea() != true) goto L16;
        r6 = true;
        goto L16
    L7:
        if (r5.Ea() != true) goto L9;
        r7 = true;
    L20:
        ComponentFeature r10 = r1.c;
        if (r10 == null) goto L25;
        u7 r11 = d.a(r10).getAbility(u7.class);
        if (r11 == null) goto L25;
        r11.A5(r0);
    L25:
        ?? r12 = new w(r0, r1);
        FLogger r13 = FLogger.a;
        r13.i("ObricChatService", "setTtsEnable to " + r0 + " , chatTitle is " + r1.t());
        Ref.BooleanRef r14 = new Ref.BooleanRef();
        if (r1.t() == null) goto L28;
        r14.element = true;
    L28:
        r12.invoke();
        r13.i("ObricChatService", "PERFORMED start a thread to do final job !");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ObricChatService$setTtsEnable$task$1$2(r14, r0, r1, null), 3, null);
        return Unit.INSTANCE;
    }
}
