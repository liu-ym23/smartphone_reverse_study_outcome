package com.larus.asr;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.IObricAsrService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import s58.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.asr.OChatBottomSpeakerComponent$transferAudioFileToLark$1", f = "OChatBottomSpeakerComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OChatBottomSpeakerComponent$transferAudioFileToLark$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $audioPath;
    final /* synthetic */ String $localMsgId;
    final /* synthetic */ File $pathFile;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OChatBottomSpeakerComponent this$0;

    public OChatBottomSpeakerComponent$transferAudioFileToLark$1(String r1, OChatBottomSpeakerComponent r2, String r3, File r4, Continuation<? super OChatBottomSpeakerComponent$transferAudioFileToLark$1> r5) {
        this.$audioPath = r1;
        this.this$0 = r2;
        this.$localMsgId = r3;
        this.$pathFile = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        OChatBottomSpeakerComponent$transferAudioFileToLark$1 r6 = new OChatBottomSpeakerComponent$transferAudioFileToLark$1(this.$audioPath, this.this$0, this.$localMsgId, this.$pathFile, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L53;
        ResultKt.throwOnFailure(r9);
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        String r11 = StringsKt.dropLast(this.$audioPath, 4) + ".opus";
        FLogger.a.i("OChatBottomSpeakerComponent", "transferAudioFileToLark: convert pcm->opus start, pcmSize=" + new PolarisFileWrapper(this.$audioPath).length() + " bytes, pcmPath=" + this.$audioPath);
        String r0 = this.$audioPath;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        a.a.getClass();     // Catch: Throwable -> L7
        a.C0125a.a(r0, r11);     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L12;
        FLogger.a.e("OChatBottomSpeakerComponent", "transferAudioFileToLark: convert pcm->opus failed, error=" + r3.getMessage());
    L12:
        PolarisFileWrapper r4 = new PolarisFileWrapper(r11);
        if (r4.exists() == true) goto L15;
    L17:
        String r5 = this.$audioPath;
    L18:
        Uri r6 = OChatBottomSpeakerComponent.F4(this.this$0.getContext(), r5);
        if (r6 != null) goto L22;
        FLogger.a.e("OChatBottomSpeakerComponent", "transferAudioFileToLark: failed to get Uri for file: " + r5);
        return Unit.INSTANCE;
    L22:
        FLogger.a.i("OChatBottomSpeakerComponent", "transferAudioFileToLark: got Uri successfully: " + r6 + " for file: " + r5);
        this.this$0.getContext().grantUriPermission("com.obric.assistantaiagent", r6, 1);
        IObricAsrService r7 = (IObricAsrService) ServiceManager.get().getService(IObricAsrService.class);
        if (r7 == null) goto L26;
        r7.h(this.$localMsgId, r6.toString());
    L26:
        if (Intrinsics.areEqual(r5, r11) == false) goto L51;
        File r12 = this.$pathFile.getParentFile();
        if (r12 == null) goto L51;
        File[] r13 = r12.listFiles();
        if (r13 == null) goto L51;
        ArrayList r8 = new ArrayList();
        int r14 = r13.length;
        int r15 = 0;
    L32:
        if (r15 >= r14) goto L42;
        File r16 = r13[r15];
        if (r16.isFile() == true) goto L36;
    L38:
        boolean r17 = false;
    L39:
        if (r17 == false) goto L41;
        r8.add(r16);
    L41:
        r15 = r15 + 1;
        goto L32
    L36:
        if (StringsKt.endsWith(r16.getName(), ".pcm", true) == false) goto L38;
        r17 = true;
        goto L39
    L42:
        Iterator r19 = r8.iterator();
    L44:
        if (r19.hasNext() == false) goto L51;
        File r20 = (File) r19.next();
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L48
        Result.constructor-impl(Boxing.boxBoolean(r20.delete()));     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L51:
        return Unit.INSTANCE;
    L15:
        if (r4.length() <= 0) goto L17;
        r5 = r11;
    L7:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L53:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
