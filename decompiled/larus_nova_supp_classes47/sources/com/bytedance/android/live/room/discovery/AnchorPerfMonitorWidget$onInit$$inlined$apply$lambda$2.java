package com.bytedance.android.live.room.discovery;

import android.hardware.usb.UsbManager;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.discovery.presenter.SoundCardModeManager;
import com.bytedance.android.live.room.utils.UsbDeviceUtils;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/live/room/discovery/AnchorPerfMonitorWidget$onInit$1$2"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.room.discovery.AnchorPerfMonitorWidget$onInit$1$2", f = "AnchorPerfMonitorWidget.kt", i = {}, l = {377}, m = "invokeSuspend", n = {}, s = {})
public final class AnchorPerfMonitorWidget$onInit$$inlined$apply$lambda$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SoundCardModeManager $this_apply;
    int label;
    final /* synthetic */ AnchorPerfMonitorWidget this$0;

    public static final class a implements Action {
        public final /* synthetic */ AnchorPerfMonitorWidget$onInit$$inlined$apply$lambda$2 a;

        public a(AnchorPerfMonitorWidget$onInit$$inlined$apply$lambda$2 r1) {
            this.a = r1;
        }

        public final void run() {
            UsbManager r0 = UsbDeviceUtils.a;
            List r1 = UsbDeviceUtils.b();
            if (((ArrayList) r1).size() != 1) goto L5;
            String r2 = (String) CollectionsKt.first(r1);
        L6:
            AnchorPerfMonitorWidget.yq(this.a.this$0, r2);
            return;
        L5:
            r2 = "";
            goto L6
        }
    }

    public AnchorPerfMonitorWidget$onInit$$inlined$apply$lambda$2(SoundCardModeManager r1, Continuation r2, AnchorPerfMonitorWidget r3) {
        this.$this_apply = r1;
        this.this$0 = r3;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        return new AnchorPerfMonitorWidget$onInit$$inlined$apply$lambda$2(this.$this_apply, r4, this.this$0);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        if (this.$this_apply.a() == true) goto L15;
        long r2 = ((long) this.this$0.u.b()) * 1000;
        AnchorPerfMonitorWidget r6 = this.this$0;
        Disposable r3 = RxUtilKt.d(r2, r2).ignoreElements().subscribe(new a(this));
        this.this$0.m.add(r3);
        Unit r4 = Unit.INSTANCE;
        r6.o = r3;
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        UsbDeviceUtils r7 = UsbDeviceUtils.b;
        this.label = 1;
        if (r7.d(this) != r0) goto L12;
        return r0;
    }
}
