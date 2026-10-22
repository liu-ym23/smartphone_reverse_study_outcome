package com.larus.dora.impl.onboarding;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.media.MediaResourceManager;
import com.larus.platform.api.IVideoController;
import java.io.File;
import java.io.InputStream;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.DoraOnboardingBgMusicPlayer$startPlay$1", f = "DoraOnboardingBgMusicPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraOnboardingBgMusicPlayer$startPlay$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ r.a $listener;
    int label;
    final /* synthetic */ r this$0;

    public DoraOnboardingBgMusicPlayer$startPlay$1(r r1, Context r2, r.a r3, Continuation<? super DoraOnboardingBgMusicPlayer$startPlay$1> r4) {
        this.this$0 = r1;
        this.$context = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraOnboardingBgMusicPlayer$startPlay$1(this.this$0, this.$context, null, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L50;
        ResultKt.throwOnFailure(r9);
        g49.d.a("DoraOnboardingBgMusicPlayer", "[playAudio] startPlay access focus");
        String r0 = this.this$0.b;
        Context r3 = this.$context;
        File r6 = new PolarisFileWrapper(r0);     // Catch: Exception -> L31
        if (r6.exists() == true) goto L8;
    L9:
        PolarisFileWrapper r1 = new PolarisFileWrapper(r6.getParentFile(), String.valueOf(UUID.randomUUID()));     // Catch: Exception -> L31
        File r2 = r1.getParentFile();     // Catch: Exception -> L31
        if (r2 == null) goto L12;
        r2.mkdirs();     // Catch: Exception -> L31
    L12:
        InputStream r4 = r3.getAssets().open("dora_onboarding_background_music.mp3");     // Catch: Exception -> L31
        PolarisFileOutputStreamWrapper r5 = new PolarisFileOutputStreamWrapper(r1);     // Catch: Throwable -> L26
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L21
        ByteStreamsKt.copyTo$default(r4, r5, 0, 2, null);     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r5, null);     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r4, null);     // Catch: Exception -> L31
        File r7 = r6.getParentFile();     // Catch: Exception -> L31
        if (r7 == null) goto L19;
        r7.mkdirs();     // Catch: Exception -> L31
    L19:
        r1.renameTo(r6);     // Catch: Exception -> L31
    L20:
        boolean r8 = true;
    L33:
        if (r8 == false) goto L46;
        r r10 = this.this$0;
        r10.getClass();
        Lazy r11 = MediaResourceManager.a;
        MediaResourceManager.m(r10.g, new j(), new k(), 0, 8);
        r10.f = true;
        IVideoController r12 = r10.a();
        if (r12 == null) goto L37;
        r12.setLocalURL(r10.b);
    L37:
        IVideoController r13 = r10.a();
        if (r13 == null) goto L40;
        r13.setLooping(true);
    L40:
        IVideoController r14 = r10.a();
        if (r14 == null) goto L43;
        r14.p(new s(r10));
    L43:
        IVideoController r15 = r10.a();
        if (r15 == null) goto L48;
        r15.play();
    L48:
        return Unit.INSTANCE;
    L46:
        g49.d.b("DoraOnboardingBgMusicPlayer", "[realPlayAudio] failure initCheckFile");
        goto L48
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Exception -> L31
        throw th;     // Catch: Exception -> L31
    L8:
        if (TextUtils.equals("c920642191f088766fc632de23bce5a1", dx8.a.a(r6)) == true) goto L20;
    L31:
        e = move-exception;
        g49.d.b("DoraOnboardingBgMusicPlayer", "initCheckFile error:" + e);
        r8 = false;
        goto L33
    L50:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
