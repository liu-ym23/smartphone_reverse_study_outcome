package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.h;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/MmAudioFileMetaInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioPersistent$persistentAudioToFile$2", f = "MmRecordingAudioPersistent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingAudioPersistent$persistentAudioToFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends ovb.a>>, Object> {
    final /* synthetic */ byte[] $byteArray;
    final /* synthetic */ int $durationInSec;
    final /* synthetic */ int $index;
    int label;
    final /* synthetic */ MmRecordingAudioPersistent this$0;

    public MmRecordingAudioPersistent$persistentAudioToFile$2(MmRecordingAudioPersistent r1, int r2, int r3, byte[] r4, Continuation<? super MmRecordingAudioPersistent$persistentAudioToFile$2> r5) {
        this.this$0 = r1;
        this.$index = r2;
        this.$durationInSec = r3;
        this.$byteArray = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmRecordingAudioPersistent$persistentAudioToFile$2(this.this$0, this.$index, this.$durationInSec, this.$byteArray, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<ovb.a>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r3);
        File r4 = this.this$0.e;
        if (r4 != null) goto L10;
        MmAudioPersistentFatalException r5 = new MmAudioPersistentFatalException("audio dir create failed!");
        String r0 = this.this$0.c;
        String r1 = r5.getErrorMsg();
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        lvb.a.b(r0, r1);
        Result.Companion r2 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(r5));
    L12:
        return Result.box-impl(r6);
    L10:
        h r7 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.a;
        VFSFile r8 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.b(r4, this.$index + '_' + (this.$durationInSec * 1000) + ".ogg");
        r8.writeBytes(this.$byteArray);
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(new ovb.a(r8.getAbsolutePath(), this.$index));
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
