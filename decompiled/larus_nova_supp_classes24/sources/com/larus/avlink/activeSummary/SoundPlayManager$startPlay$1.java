package com.larus.avlink.activeSummary;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.avlink.n1;
import com.larus.common.apphost.AppHost;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.avlink.activeSummary.SoundPlayManager$startPlay$1", f = "SoundPlayManager.kt", i = {0, 0}, l = {75}, m = "invokeSuspend", n = {"localFilePath", "isFileCached"}, s = {"L$0", "Z$0"})
public final class SoundPlayManager$startPlay$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $assetName;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $ignoreDoraCall;
    final /* synthetic */ SoundPlayManager.b $listener;
    final /* synthetic */ SoundPlayManager.c $stageListener;
    Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ SoundPlayManager this$0;

    /* JADX INFO: renamed from: com.larus.avlink.activeSummary.SoundPlayManager$startPlay$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.avlink.activeSummary.SoundPlayManager$startPlay$1$1", f = "SoundPlayManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $ignoreDoraCall;
        final /* synthetic */ SoundPlayManager.b $listener;
        final /* synthetic */ String $localFilePath;
        final /* synthetic */ SoundPlayManager.c $stageListener;
        int label;
        final /* synthetic */ SoundPlayManager this$0;

        public AnonymousClass1(SoundPlayManager r1, String r2, SoundPlayManager.b r3, boolean r4, SoundPlayManager.c r5, Continuation<? super AnonymousClass1> r6) {
            this.this$0 = r1;
            this.$localFilePath = r2;
            this.$listener = r3;
            this.$ignoreDoraCall = r4;
            this.$stageListener = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.this$0, this.$localFilePath, this.$listener, this.$ignoreDoraCall, this.$stageListener, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r6);
            SoundPlayManager r7 = this.this$0;
            String r0 = this.$localFilePath;
            SoundPlayManager.b r1 = this.$listener;
            boolean r2 = this.$ignoreDoraCall;
            SoundPlayManager.c r3 = this.$stageListener;
            int r4 = SoundPlayManager.f;
            r7.c(r0, r1, r2, r3);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public SoundPlayManager$startPlay$1(String r1, SoundPlayManager r2, Context r3, SoundPlayManager.c r4, SoundPlayManager.b r5, boolean r6, Continuation<? super SoundPlayManager$startPlay$1> r7) {
        this.$assetName = r1;
        this.this$0 = r2;
        this.$context = r3;
        this.$stageListener = r4;
        this.$listener = r5;
        this.$ignoreDoraCall = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new SoundPlayManager$startPlay$1(this.$assetName, this.this$0, this.$context, this.$stageListener, this.$listener, this.$ignoreDoraCall, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        boolean r2 = this.Z$0;
        String r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r12);
        String r6 = r3;
    L13:
        if (((Boolean) r12).booleanValue() == false) goto L18;
        n1.d("SummaryNotifySoundManager", "[playAudio] use asset audio, assetName=" + this.$assetName + ", cached=" + r2);
        SoundPlayManager.c r13 = this.$stageListener;
        if (r13 == null) goto L17;
        r13.c(r2);
    L17:
        SoundPlayManager r14 = this.this$0;
        int r4 = SoundPlayManager.f;
        BuildersKt.launch$default((CoroutineScope) r14.d.getValue(), null, null, new AnonymousClass1(this.this$0, r6, this.$listener, this.$ignoreDoraCall, this.$stageListener, null), 3, null);
    L22:
        return Unit.INSTANCE;
    L18:
        n1.b("SummaryNotifySoundManager", "[realPlayAudio] failure initCheckFile, assetName=" + this.$assetName);
        SoundPlayManager.c r15 = this.$stageListener;
        if (r15 == null) goto L22;
        r15.b(-2);
        goto L22
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        n1.a("SummaryNotifySoundManager", "[NotificationTracer] [playAudio] startPlay access focus");
        String r5 = AppHost.a.getApplication().getFilesDir().getAbsolutePath() + File.separator + this.$assetName;
        boolean r16 = new PolarisFileWrapper(r5).exists();
        SoundPlayManager r7 = this.this$0;
        String r8 = this.$assetName;
        Context r9 = this.$context;
        this.L$0 = r5;
        this.Z$0 = r16;
        this.label = 1;
        Object r10 = SoundPlayManager.a(r7, r8, r5, r9, this);
        if (r10 != r0) goto L11;
        return r0;
    L11:
        r2 = r16;
        r6 = r5;
        r12 = r10;
        goto L13
    }
}
