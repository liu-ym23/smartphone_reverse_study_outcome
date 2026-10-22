package com.larus.avlink.activeSummary;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.avlink.e1;
import com.larus.avlink.n1;
import com.larus.avlink.q1;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.n0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class SoundPlayManager {
    public static final /* synthetic */ int f = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public volatile boolean e;

    public static final class a {
    }

    public interface b {
        void onBegin();

        void onEnd();

        void onError();
    }

    public interface c {
        void a();

        void b(int r1);

        void c(boolean r1);

        void onRenderStart();
    }

    public static final class d implements n0 {
        public final /* synthetic */ b a;
        public final /* synthetic */ SoundPlayManager b;
        public final /* synthetic */ c c;

        public final void b(Integer r1, Integer r2) {
        }

        public final void c(int r1) {
        }

        public final void d(int r1) {
        }

        public final void onPrepare() {
        }

        public final void onPrepared() {
        }

        public final void onVideoStatusException(int r1) {
        }

        public final void onCompletion() {
            n1.d("SummaryNotifySoundManager", "[NotificationTracer] [realPlayAudio] onCompletion");
            IVideoController r0 = this.b.b();
            if (r0 == null) goto L5;
            r0.stop();
        L5:
            this.b.getClass();
            b r1 = this.a;
            if (r1 == null) goto L9;
            r1.onEnd();
            return;
        }

        public final void onRenderStart() {
            if (this.b.e == false) goto L9;
            n1.d("SummaryNotifySoundManager", "[realPlayAudio] stop requested before render, stop now");
            IVideoController r0 = this.b.b();
            if (r0 == null) goto L7;
            r0.stop();
        L7:
            this.b.getClass();
            return;
        L9:
            b r1 = this.a;
            if (r1 == null) goto L12;
            r1.onBegin();
        L12:
            c r2 = this.c;
            if (r2 == null) goto L15;
            r2.onRenderStart();
        L15:
            n1.b("SummaryNotifySoundManager", "[realPlayAudio] onRenderStart");
        }

        public final void a(Integer r2, Integer r3) {
            n1.b("SummaryNotifySoundManager", "[realPlayAudio] onError");
            b r4 = this.a;
            if (r4 == null) goto L5;
            r4.onError();
        L5:
            this.b.getClass();
            c r5 = this.c;
            if (r5 == null) goto L12;
            if (r2 == null) goto L9;
            int r6 = r2.intValue();
        L10:
            r5.b(r6);
            return;
        L9:
            r6 = -2;
            goto L10
        }

        public d(b r1, SoundPlayManager r2, c r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public final void h() {
        this.e = true;
        BuildersKt.launch$default((CoroutineScope) this.d.getValue(), null, null, new SoundPlayManager$stop$1(this, null), 3, null);
    }

    public final IVideoController b() {
        return (IVideoController) this.a.getValue();
    }

    public SoundPlayManager() {
        this.a = LazyKt.lazy(new p());
        this.b = LazyKt.lazy(new q());
        this.c = LazyKt.lazy(new r());
        this.d = LazyKt.lazy(new s(this));
    }

    public final void f(String r12, e1 r13) {
        Intrinsics.checkNotNullParameter(r12, "filePath");
        if (r12.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        n1.b("SummaryNotifySoundManager", "[playAudio] startPlayLocalFile filePath is empty");
        r13.onError();
        return;
    L9:
        this.e = false;
        BuildersKt.launch$default((CoroutineScope) this.d.getValue(), null, null, new SoundPlayManager$startPlayLocalFile$1(this, r12, r13, true, null), 3, null);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void c(String r2, b r3, boolean r4, c r5) {
        if (r4 == false) goto L5;
    L11:
        n1.d("SummaryNotifySoundManager", "playMusic");
        if (this.e == false) goto L15;
        n1.d("SummaryNotifySoundManager", "[realPlayAudio] stop requested before play, skip");
        return;
    L15:
        IVideoController r6 = b();
        if (r6 == null) goto L18;
        r6.setLocalURL(r2);
    L18:
        IVideoController r7 = b();
        if (r7 == null) goto L21;
        r7.setLooping(false);
    L21:
        IVideoController r8 = b();
        if (r8 == null) goto L24;
        r8.p(new d(r3, this, r5));
    L24:
        if (r5 == null) goto L26;
        r5.a();
    L26:
        IVideoController r9 = b();
        if (r9 == null) goto L30;
        r9.play();
        return;
    L30:
        return;
    L5:
        if (ia8.e.b().b() == true) goto L11;
        IVideoController r10 = b();
        if (r10 == null) goto L9;
        r10.stop();
    L9:
        n1.b("SummaryNotifySoundManager", "[realPlayAudio] is not connect");
    }

    public static final Object a(SoundPlayManager r5, String r6, String r7, Context r8, Continuation r9) {
        r5.getClass();
        if ((r9 instanceof SoundPlayManager$initCheckFile$1) == false) goto L7;
        SoundPlayManager$initCheckFile$1 r1 = (SoundPlayManager$initCheckFile$1) r9;
        int r2 = r1.label;
        if ((r2 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r1.label = r2 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r10 = r1.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        String r12 = (String) r1.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L24
    L29:
        return r10;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r10);
        PolarisFileWrapper r13 = new PolarisFileWrapper(r7);     // Catch: Exception -> L24
        if (r13.exists() == false) goto L20;
        n1.d("SummaryNotifySoundManager", "initCheckFile local cache valid, assetName=" + r6);     // Catch: Exception -> L24
        return Boxing.boxBoolean(true);
    L20:
        CoroutineDispatcher r14 = Dispatchers.getIO();     // Catch: Exception -> L24
        SoundPlayManager$initCheckFile$2 r0 = new SoundPlayManager$initCheckFile$2(r13, r8, r6, null);     // Catch: Exception -> L24
        r1.L$0 = r6;     // Catch: Exception -> L24
        r1.label = 1;     // Catch: Exception -> L24
        r10 = BuildersKt.withContext(r14, r0, r1);     // Catch: Exception -> L24
        if (r10 != r11) goto L29;
        return r11;
    L24:
        e = move-exception;
        n1.b("SummaryNotifySoundManager", "initCheckFile error, assetName=" + r6 + ", type=" + e.getClass().getSimpleName());
        return Boxing.boxBoolean(false);
    L7:
        r1 = new SoundPlayManager$initCheckFile$1(r5, r9);
        goto L8
    }

    public static /* synthetic */ void e(SoundPlayManager r6, Context r7, String r8, boolean r9, b r10) {
        r6.d(r7, r8, r9, r10, null);
    }

    public final void d(Context r14, String r15, boolean r16, b r17, c r19) {
        Intrinsics.checkNotNullParameter(r15, "assetName");
        if (r14 != null) goto L6;
        n1.a("SummaryNotifySoundManager", "[playAudio] startPlay context is null");
        return;
    L6:
        this.e = false;
        BuildersKt.launch$default((CoroutineScope) this.b.getValue(), null, null, new SoundPlayManager$startPlay$1(r15, this, r14, r19, r17, r16, null), 3, null);
    }

    public final void g(Context r19, String r110, String r20, b r21, q1.b r22) {
        Intrinsics.checkNotNullParameter(r110, "assetName");
        Intrinsics.checkNotNullParameter(r20, "geckoFileName");
        Intrinsics.checkNotNullParameter("com_flow_dora_netural_wakeup", "geckoChannel");
        if (r19 != null) goto L6;
        n1.a("SummaryNotifySoundManager", "[playAudio] startPlayWithGecko context is null");
        return;
    L6:
        this.e = false;
        BuildersKt.launch$default((CoroutineScope) this.b.getValue(), null, null, new SoundPlayManager$startPlayWithGecko$1(this, r20, "com_flow_dora_netural_wakeup", r22, r110, r19, true, r21, null), 3, null);
    }
}
