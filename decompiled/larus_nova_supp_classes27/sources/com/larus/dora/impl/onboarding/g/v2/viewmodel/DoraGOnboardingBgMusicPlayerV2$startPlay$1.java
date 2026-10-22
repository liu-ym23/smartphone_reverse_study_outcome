package com.larus.dora.impl.onboarding.g.v2.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
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
@DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingBgMusicPlayerV2$startPlay$1", f = "DoraGOnboardingBgMusicPlayerV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraGOnboardingBgMusicPlayerV2$startPlay$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isLoop;
    final /* synthetic */ l.a $listener;
    final /* synthetic */ String $path;
    int label;
    final /* synthetic */ l this$0;

    public DoraGOnboardingBgMusicPlayerV2$startPlay$1(String r1, l r2, Context r3, boolean r4, l.a r5, Continuation<? super DoraGOnboardingBgMusicPlayerV2$startPlay$1> r6) {
        this.$path = r1;
        this.this$0 = r2;
        this.$context = r3;
        this.$isLoop = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DoraGOnboardingBgMusicPlayerV2$startPlay$1(this.$path, this.this$0, this.$context, this.$isLoop, null, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L50;
        ResultKt.throwOnFailure(r10);
        g49.d.a("DoraOnboardingBgMusicPlayerV2", "[playAudio] startPlay access focus");
        String r0 = AppHost.a.getApplication().getFilesDir().getAbsolutePath() + File.separator + this.$path;
        l r1 = this.this$0;
        Context r4 = this.$context;
        int r5 = l.g;
        r1.getClass();
        File r6 = new PolarisFileWrapper(r0);     // Catch: Exception -> L31
        if (r6.exists() == true) goto L8;
    L9:
        PolarisFileWrapper r3 = new PolarisFileWrapper(r6.getParentFile(), String.valueOf(UUID.randomUUID()));     // Catch: Exception -> L31
        File r7 = r3.getParentFile();     // Catch: Exception -> L31
        if (r7 == null) goto L12;
        r7.mkdirs();     // Catch: Exception -> L31
    L12:
        InputStream r2 = r4.getAssets().open("dora_onboarding_background_music.mp3");     // Catch: Exception -> L31
        PolarisFileOutputStreamWrapper r8 = new PolarisFileOutputStreamWrapper(r3);     // Catch: Throwable -> L26
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L21
        ByteStreamsKt.copyTo$default(r2, r8, 0, 2, null);     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r2, null);     // Catch: Exception -> L31
        File r9 = r6.getParentFile();     // Catch: Exception -> L31
        if (r9 == null) goto L19;
        r9.mkdirs();     // Catch: Exception -> L31
    L19:
        r3.renameTo(r6);     // Catch: Exception -> L31
    L20:
        boolean r11 = true;
    L33:
        if (r11 == false) goto L46;
        l r12 = this.this$0;
        boolean r13 = this.$isLoop;
        r12.getClass();
        Lazy r14 = MediaResourceManager.a;
        MediaResourceManager.m(r12.f, new b(), new c(), 0, 8);
        r12.e = true;
        IVideoController r15 = r12.a();
        if (r15 == null) goto L37;
        r15.setLocalURL(r0);
    L37:
        IVideoController r16 = r12.a();
        if (r16 == null) goto L40;
        r16.setLooping(r13);
    L40:
        IVideoController r17 = r12.a();
        if (r17 == null) goto L43;
        r17.p(new m(r12));
    L43:
        IVideoController r18 = r12.a();
        if (r18 == null) goto L48;
        r18.play();
    L48:
        return Unit.INSTANCE;
    L46:
        g49.d.b("DoraOnboardingBgMusicPlayerV2", "[realPlayAudio] failure initCheckFile");
        goto L48
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Exception -> L31
        throw th;     // Catch: Exception -> L31
    L8:
        if (TextUtils.equals("c920642191f088766fc632de23bce5a1", dx8.a.a(r6)) == true) goto L20;
    L31:
        e = move-exception;
        g49.d.b("DoraOnboardingBgMusicPlayerV2", "initCheckFile error:" + e);
        r11 = false;
        goto L33
    L50:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
