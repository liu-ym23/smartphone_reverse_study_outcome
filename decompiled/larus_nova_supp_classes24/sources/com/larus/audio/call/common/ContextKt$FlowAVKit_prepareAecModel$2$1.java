package com.larus.audio.call.common;

import android.content.Context;
import android.content.res.AssetManager;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.aec.f;
import java.io.File;
import java.io.InputStream;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.call.common.ContextKt$FlowAVKit_prepareAecModel$2$1", f = "Context.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ContextKt$FlowAVKit_prepareAecModel$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ File $file;
    int label;

    public ContextKt$FlowAVKit_prepareAecModel$2$1(File r1, Context r2, Continuation<? super ContextKt$FlowAVKit_prepareAecModel$2$1> r3) {
        this.$file = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ContextKt$FlowAVKit_prepareAecModel$2$1(this.$file, this.$context, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r6);
        PolarisFileWrapper r7 = new PolarisFileWrapper(this.$file.getParentFile(), String.valueOf(UUID.randomUUID()));
        File r0 = r7.getParentFile();
        if (r0 == null) goto L7;
        Boxing.boxBoolean(r0.mkdirs());
    L7:
        AssetManager r1 = this.$context.getAssets();
        int r2 = f.l;
        if (t68.a.a.c() == false) goto L10;
        String r3 = "speech_kws_model/aec_p_micro5_bin_20k_260901_multich_v4.0.model";
    L11:
        InputStream r4 = r1.open(r3);
        PolarisFileOutputStreamWrapper r5 = new PolarisFileOutputStreamWrapper(r7);     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L20
        ByteStreamsKt.copyTo$default(r4, r5, 0, 2, null);     // Catch: Throwable -> L20
        AutoCloseableKt.closeFinally(r5, null);     // Catch: Throwable -> L25
        AutoCloseableKt.closeFinally(r4, null);
        File r8 = this.$file.getParentFile();
        if (r8 == null) goto L19;
        Boxing.boxBoolean(r8.mkdirs());
    L19:
        return Boxing.boxBoolean(r7.renameTo(this.$file));
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        AutoCloseableKt.closeFinally(r5, th);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        AutoCloseableKt.closeFinally(r4, th);
        throw th;
    L10:
        r3 = "aec_doubao_micro5_bin_20k_260418_v3.7.model";
        goto L11
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
