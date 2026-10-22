package com.ss.android.lark.officesdk.minutes.ui.record.notification;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.notification.MmRecordingNotificationType;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.e;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.notification.MmDoubaoRecordingNotificationProcessor$handleWeakNetwork$2", f = "MmDoubaoRecordingNotificationProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmDoubaoRecordingNotificationProcessor$handleWeakNetwork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isWeak;
    int label;
    final /* synthetic */ MmDoubaoRecordingNotificationProcessor this$0;

    public MmDoubaoRecordingNotificationProcessor$handleWeakNetwork$2(boolean r1, MmDoubaoRecordingNotificationProcessor r2, Continuation<? super MmDoubaoRecordingNotificationProcessor$handleWeakNetwork$2> r3) {
        this.$isWeak = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmDoubaoRecordingNotificationProcessor$handleWeakNetwork$2(this.$isWeak, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r7);
        if (this.$isWeak == false) goto L8;
        a r8 = this.this$0.a;
        MmRecordingNotificationType r0 = MmRecordingNotificationType.WEAK_NETWORK;
        int r1 = e.a;
        r8.a(r0, UIHelper.getString(2131892871), new jub.a(60000, 3));
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
