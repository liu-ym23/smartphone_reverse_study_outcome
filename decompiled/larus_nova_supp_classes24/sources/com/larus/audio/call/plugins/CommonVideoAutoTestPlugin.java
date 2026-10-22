package com.larus.audio.call.plugins;

import com.larus.im.service.audio.ILLMVideoStreamIndex;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class CommonVideoAutoTestPlugin extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> implements x0, w0 {
    public final Lazy f;
    public final Lazy g;
    public boolean h;
    public boolean i;
    public final String j;

    public static final class a implements com.larus.im.service.audio.w {
        public final /* synthetic */ CommonVideoAutoTestPlugin a;

        public a(CommonVideoAutoTestPlugin r1) {
            this.a = r1;
        }

        public final com.larus.im.service.audio.u a(ILLMVideoStreamIndex r2, com.larus.im.service.audio.u r3) {
            Intrinsics.checkNotNullParameter(r2, "streamIndex");
            if (r3 != null) goto L5;
            return r3;
        L5:
            int r0 = com.larus.im.a.a;
            gd9.o r1 = com.larus.im.internal.d.a;
            com.larus.im.internal.audio.u.c.getClass();
            com.larus.im.internal.utils.x r4 = com.larus.im.internal.utils.x.a;
            com.larus.im.internal.utils.x.d.getClass();
            if (r2 != ILLMVideoStreamIndex.STREAM_INDEX_MAIN) goto L8;
            ((com.larus.audio.call.l) this.a.f.getValue()).b(r3);
        L8:
            com.larus.im.internal.utils.x.f.getClass();
            if (r2 != ILLMVideoStreamIndex.STREAM_INDEX_SCREEN) goto L11;
            ((com.larus.audio.call.l) this.a.g.getValue()).b(r3);
        L11:
            return r3;
        }
    }

    @Override // com.larus.audio.call.plugins.w0
    public final void J2() {
        com.larus.audio.call.util.e.a.i(this.j, "[onEnterScreenShare] needRegisterScreenShareProcessor: " + this.h);
        if (this.h == false) goto L10;
        id9.d r0 = getContext().j();
        if (r0 == null) goto L9;
        com.larus.im.service.audio.y r1 = r0.a();
        if (r1 == null) goto L9;
        r1.q();
    L9:
        this.h = false;
    L10:
        ((com.larus.audio.call.l) this.g.getValue()).a();
    }

    @Override // com.larus.audio.call.plugins.x0
    public final void Q1() {
        com.larus.audio.call.util.e.a.i(this.j, "onExitCallVideo");
        CoroutineScope r1 = getContext().r();
        if (r1 == null) goto L6;
        BuildersKt.launch$default(r1, null, null, new CommonVideoAutoTestPlugin$onExitCallVideo$1(this, null), 3, null);
        return;
    }

    @Override // com.larus.audio.call.plugins.w0
    public final void S() {
        com.larus.audio.call.util.e.a.i(this.j, "onExitScreenShare");
        CoroutineScope r1 = getContext().r();
        if (r1 == null) goto L6;
        BuildersKt.launch$default(r1, null, null, new CommonVideoAutoTestPlugin$onExitScreenShare$1(this, null), 3, null);
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public final void b3() {
        com.larus.audio.call.util.e.a.i(this.j, "onRelease");
        id9.d r0 = getContext().j();
        if (r0 == null) goto L7;
        com.larus.im.service.audio.z r1 = r0.e();
        if (r1 == null) goto L7;
        r1.q(null);
    L7:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CommonVideoAutoTestPlugin$onRelease$1(this, null), 3, null);
    }

    @Override // com.larus.audio.call.plugins.x0
    public final void k2() {
        com.larus.audio.call.util.e.a.i(this.j, "[onEnterCallVideo] needRegisterVideoCallProcessor: " + this.i);
        ((com.larus.audio.call.l) this.f.getValue()).a();
        CoroutineScope r1 = getContext().r();
        if (this.i == false) goto L7;
        if (r1 == null) goto L8;
        this.i = false;
        BuildersKt.launch$default(r1, Dispatchers.getIO(), null, new CommonVideoAutoTestPlugin$onEnterCallVideo$1(this, null), 2, null);
        return;
    L8:
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        super.e3();
        com.larus.audio.call.util.e.a.i(this.j, "onStart");
        id9.d r0 = getContext().j();
        if (r0 == null) goto L8;
        com.larus.im.service.audio.z r1 = r0.e();
        if (r1 == null) goto L9;
        r1.q(new a(this));
        return;
    L9:
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.j;
    }

    public CommonVideoAutoTestPlugin(final com.larus.audio.call.arch.c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = LazyKt.lazy(new n0(r2));
        this.g = LazyKt.lazy(new o0(r2));
        this.h = true;
        this.i = true;
        this.j = "CommonVideoDumpPlugin";
    }
}
