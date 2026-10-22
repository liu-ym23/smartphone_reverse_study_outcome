package com.larus.audio.call.record;

import com.larus.audio.call.aec.w;
import com.larus.im.service.audio.AvAecType;
import com.larus.im.service.audio.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements v68.a {
    public final m a;
    public Function2<? super r58.d, ? super byte[], Unit> b;
    public final CoroutineScope c;
    public final n d;

    /* JADX INFO: renamed from: com.larus.audio.call.record.a$a, reason: collision with other inner class name */
    public static final class C0083a {
    }

    public static final class b implements com.larus.im.service.audio.g {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void a(byte[] r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            m r0 = this.a.a;
            if (r0 == null) goto L8;
            Function1<byte[], Unit> r1 = r0.a;
            if (r1 == null) goto L9;
            r1.invoke(r2);
            return;
        L9:
            return;
        }
    }

    static {
    }

    @Override // v68.a
    public final void b(int r1) {
    }

    @Override // v68.a
    public final void c(long r1, Long r3) {
    }

    @Override // v68.a
    public final void e(Function0<Unit> r1) {
    }

    @Override // v68.a
    public final void f(Function2<? super String, ? super Long, Unit> r1) {
    }

    @Override // v68.a
    public final void g(Function2<? super Boolean, ? super String, Unit> r1) {
    }

    @Override // v68.a
    public final w h() {
        return null;
    }

    @Override // v68.a
    public final void release() {
        com.larus.audio.call.util.e.a.i("AVInnerRecordAdapter", "release");
        this.b = null;
        if (CoroutineScopeKt.isActive(this.c) == false) goto L5;
        CoroutineScopeKt.cancel$default(this.c, null, 1, null);
    L5:
        this.d.release();
    }

    @Override // v68.a
    public final void stopRecord() {
        com.larus.audio.call.util.e.a.i("AVInnerRecordAdapter", "stopRecord");
        this.d.stopCapture();
    }

    @Override // v68.a
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
    }

    @Override // v68.a
    public final void setBluetoothForceToMedia(boolean r2) {
        this.d.setBluetoothForceToMedia(r2);
    }

    @Override // v68.a
    public final boolean start(Function1<? super Exception, Unit> r3) {
        com.larus.audio.call.util.e.a.i("AVInnerRecordAdapter", "start");
        this.d.startCapture();
        return true;
    }

    @Override // v68.a
    public final void d(v58.a r3, Function2<? super r58.d, ? super byte[], Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "onAudioDataReceived");
        com.larus.audio.call.util.e.a.i("AVInnerRecordAdapter", "init");
        this.b = r4;
        com.larus.im.service.audio.f r5 = this.d;
        if ((r5 instanceof com.larus.im.service.audio.f) == false) goto L5;
        r5.a(new b(this));
    L5:
        this.d.setup();
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [com.larus.audio.call.record.AVInnerRecordAdapter$linkAudioRecorder$1] */
    public a(id9.d r2, AvAecType r3, final Function0 r4, int r5, m r6, int r7) {
        if ((r7 & 8) == 0) goto L6;
        r5 = 1;
    L6:
        if ((r7 & 16) == 0) goto L8;
        r6 = null;
    L8:
        Intrinsics.checkNotNullParameter(r2, "session");
        Intrinsics.checkNotNullParameter(r3, "aecType");
        Intrinsics.checkNotNullParameter(r4, "appendExtra");
        this.a = r6;
        this.c = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(new com.larus.audio.call.record.b(CoroutineExceptionHandler.Key)));
        this.d = r2.c(r5, r3, new AVInnerRecordAdapter$linkAudioRecorder$1(this, r4));
    }
}
