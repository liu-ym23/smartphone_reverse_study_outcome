package com.larus.avlink.activeSummary;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.avlink.n1;
import com.larus.platform.service.c1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.avlink.activeSummary.SoundPlayManager$startPlayWithGecko$1", f = "SoundPlayManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SoundPlayManager$startPlayWithGecko$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $assetName;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $geckoChannel;
    final /* synthetic */ String $geckoFileName;
    final /* synthetic */ boolean $ignoreDoraCall;
    final /* synthetic */ SoundPlayManager.b $listener;
    final /* synthetic */ SoundPlayManager.c $stageListener;
    int label;
    final /* synthetic */ SoundPlayManager this$0;

    /* JADX INFO: renamed from: com.larus.avlink.activeSummary.SoundPlayManager$startPlayWithGecko$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.avlink.activeSummary.SoundPlayManager$startPlayWithGecko$1$1", f = "SoundPlayManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $geckoPath;
        final /* synthetic */ boolean $ignoreDoraCall;
        final /* synthetic */ SoundPlayManager.b $listener;
        final /* synthetic */ SoundPlayManager.c $stageListener;
        int label;
        final /* synthetic */ SoundPlayManager this$0;

        public AnonymousClass1(SoundPlayManager r1, String r2, SoundPlayManager.b r3, boolean r4, SoundPlayManager.c r5, Continuation<? super AnonymousClass1> r6) {
            this.this$0 = r1;
            this.$geckoPath = r2;
            this.$listener = r3;
            this.$ignoreDoraCall = r4;
            this.$stageListener = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.this$0, this.$geckoPath, this.$listener, this.$ignoreDoraCall, this.$stageListener, r9);
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
            String r0 = this.$geckoPath;
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

    public SoundPlayManager$startPlayWithGecko$1(SoundPlayManager r1, String r2, String r3, SoundPlayManager.c r4, String r5, Context r6, boolean r7, SoundPlayManager.b r8, Continuation<? super SoundPlayManager$startPlayWithGecko$1> r9) {
        this.this$0 = r1;
        this.$geckoFileName = r2;
        this.$geckoChannel = r3;
        this.$stageListener = r4;
        this.$assetName = r5;
        this.$context = r6;
        this.$ignoreDoraCall = r7;
        this.$listener = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new SoundPlayManager$startPlayWithGecko$1(this.this$0, this.$geckoFileName, this.$geckoChannel, this.$stageListener, this.$assetName, this.$context, this.$ignoreDoraCall, this.$listener, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L36;
        ResultKt.throwOnFailure(r19);
        SoundPlayManager r0 = this.this$0;
        String r4 = this.$geckoFileName;
        String r5 = this.$geckoChannel;
        int r6 = SoundPlayManager.f;
        r0.getClass();
        boolean r8 = false;
        String r10 = c1.a.b(r4, r5, true);     // Catch: Exception -> L17
        if (r10.length() != 0) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == false) goto L11;
        n1.d("SummaryNotifySoundManager", "resolveGeckoFilePath empty, assetName=" + r4 + ", channel=" + r5);     // Catch: Exception -> L17
    L19:
        String r12 = "";
    L21:
        if (r12.length() <= 0) goto L23;
        r8 = true;
    L23:
        if (r8 == false) goto L29;
        n1.d("SummaryNotifySoundManager", "[playAudio] use gecko audio, geckoFileName=" + this.$geckoFileName + ", channel=" + this.$geckoChannel);
        SoundPlayManager.c r1 = this.$stageListener;
        if (r1 == null) goto L27;
        r1.c(true);
    L27:
        BuildersKt.launch$default((CoroutineScope) this.this$0.d.getValue(), null, null, new AnonymousClass1(this.this$0, r12, this.$listener, this.$ignoreDoraCall, this.$stageListener, null), 3, null);
    L34:
        return Unit.INSTANCE;
    L29:
        if (this.this$0.e == false) goto L32;
        n1.d("SummaryNotifySoundManager", "[playAudio] stop requested before asset fallback, skip");
        this.this$0.getClass();
        return Unit.INSTANCE;
    L32:
        n1.d("SummaryNotifySoundManager", "[playAudio] fallback to asset audio, assetName=" + this.$assetName);
        this.this$0.d(this.$context, this.$assetName, this.$ignoreDoraCall, this.$listener, this.$stageListener);
        goto L34
    L11:
        PolarisFileWrapper r7 = new PolarisFileWrapper(r10);     // Catch: Exception -> L17
        if (r7.isFile() == false) goto L14;
        String r2 = r7.getAbsolutePath();     // Catch: Exception -> L17
    L15:
        Intrinsics.checkNotNull(r2);     // Catch: Exception -> L17
        r12 = r2;
        goto L21
    L14:
        n1.d("SummaryNotifySoundManager", "resolveGeckoFilePath invalid file, assetName=" + r4 + ", channel=" + r5);     // Catch: Exception -> L17
        r2 = "";
        goto L15
    L8:
        r11 = false;
    L17:
        e = move-exception;
        n1.b("SummaryNotifySoundManager", "resolveGeckoFilePath error, assetName=" + r4 + ", channel=" + r5 + ", type=" + e.getClass().getSimpleName());
        goto L19
    L36:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
