package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.vfs.VFSFile;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioPersistent$switchPartDirToMeetingId$2", f = "MmRecordingAudioPersistent.kt", i = {}, l = {341}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingAudioPersistent$switchPartDirToMeetingId$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $fromSessionKey;
    final /* synthetic */ String $toMeetingId;
    final /* synthetic */ String $userId;
    int label;
    final /* synthetic */ MmRecordingAudioPersistent this$0;

    public MmRecordingAudioPersistent$switchPartDirToMeetingId$2(String r1, String r2, String r3, MmRecordingAudioPersistent r4, Continuation<? super MmRecordingAudioPersistent$switchPartDirToMeetingId$2> r5) {
        this.$userId = r1;
        this.$fromSessionKey = r2;
        this.$toMeetingId = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmRecordingAudioPersistent$switchPartDirToMeetingId$2(this.$userId, this.$fromSessionKey, this.$toMeetingId, this.this$0, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        if (((Boolean) r6).booleanValue() == true) goto L15;
        lvb.a.b(this.this$0.c, "[switchPartDirToMeetingId] copy failed, fromSessionKey=" + this.$fromSessionKey + ", toMeetingId=" + this.$toMeetingId);
        return Boxing.boxBoolean(false);
    L15:
        MmRecordFileHelper r7 = MmRecordFileHelper.a;
        String r2 = this.$userId;
        String r3 = this.$toMeetingId;
        r7.getClass();
        VFSFile r8 = MmRecordFileHelper.f(r2, r3);
        MmRecordingAudioPersistent r4 = this.this$0;
        r4.e = r8;
        r4.g = new b(this.$toMeetingId);
        lvb.a.e(this.this$0.c, "[switchPartDirToMeetingId] success, fromSessionKey=" + this.$fromSessionKey + ", toMeetingId=" + this.$toMeetingId);
        return Boxing.boxBoolean(true);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        MmRecordFileHelper r9 = MmRecordFileHelper.a;
        String r5 = this.$userId;
        String r10 = this.$fromSessionKey;
        String r11 = this.$toMeetingId;
        this.label = 1;
        r9.getClass();
        r6 = MmRecordFileHelper.a(r5, r10, r11, this);
        if (r6 != r0) goto L12;
        return r0;
    }
}
