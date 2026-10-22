package com.larus.voicecall.impl.plugins;

import com.lynx.jsbridge.LynxResourceModule;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Deprecated(message = "logic trans")
public final class CallEventDispatcher implements com.larus.voicecall.impl.scene.a {
    public final CopyOnWriteArrayList<com.larus.voicecall.impl.scene.a> a;

    @Override // com.larus.voicecall.impl.scene.a
    public final void b() {
        a(new f());
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void c() {
        a(new e());
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void d() {
        a(new l());
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void g() {
        a(new b());
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void k() {
        a(new g());
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void m() {
        a(new h());
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void onInterrupt() {
        a(new i());
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void onRelease() {
        a(new k());
    }

    public CallEventDispatcher() {
        this.a = new CopyOnWriteArrayList();
    }

    public final void a(Function1<? super com.larus.voicecall.impl.scene.a, Unit> r8) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CallEventDispatcher$dispatch$1(this, r8, null), 3, null);
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void j(final a78.a r2) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.DATA_KEY);
        a(new j(r2));
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void e(final String r2, final String r3) {
        a(new c(r2, r3));
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void f(final String r2, final String r3) {
        Intrinsics.checkNotNullParameter(r2, "sectionId");
        Intrinsics.checkNotNullParameter(r3, "queryRound");
        a(new d(r2, r3));
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void i(final Integer r2, final boolean r3) {
        a(new m(r2, r3));
    }

    @Override // com.larus.voicecall.impl.scene.a
    public final void l(final boolean r2, final String r3, final String r4, final String r5) {
        Intrinsics.checkNotNullParameter(r5, "asrTaskId");
        a(new a(r2, r3, r4, r5));
    }
}
