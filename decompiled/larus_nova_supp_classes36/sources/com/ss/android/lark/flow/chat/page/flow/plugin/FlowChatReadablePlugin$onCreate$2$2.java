package com.ss.android.lark.flow.chat.page.flow.plugin;

import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.BaseStrangerRelationViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.StrangerBannerType;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.w;
import com.ss.android.lark.flow.chat.component.banner.IFlowBottomBannerComponent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.impl.preload.ImagePreloadConfig;
import com.ss.android.lark.log.Log;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.page.flow.plugin.FlowChatReadablePlugin$onCreate$2$2", f = "FlowChatReadablePlugin.kt", i = {}, l = {ImagePreloadConfig.DEFAULT_CPU_LIMIT}, m = "invokeSuspend", n = {}, s = {})
public final class FlowChatReadablePlugin$onCreate$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ i7b.a $initData;
    final /* synthetic */ BaseStrangerRelationViewModel $it;
    int label;
    final /* synthetic */ FlowChatReadablePlugin this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ FlowChatReadablePlugin a;
        public final /* synthetic */ i7b.a b;

        public a(FlowChatReadablePlugin r1, i7b.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r5, Continuation r6) {
            StrangerBannerType r7 = (StrangerBannerType) r5;
            Log.i("FlowChatReadablePlugin", "collect banner type: " + r7);
            FlowChatReadablePlugin r8 = this.a;
            i7b.a r0 = this.b;
            IFlowBottomBannerComponent r1 = r8.i;
            if (r1 == null) goto L22;
            if (r7 != StrangerBannerType.NONE) goto L8;
        L20:
            r1.U20();
            goto L22
        L8:
            if (r7 == StrangerBannerType.UNKNOWN) goto L20;
            int r2 = FlowChatReadablePlugin.b.a[r7.ordinal()];
            if (r2 != 1) goto L13;
            FlowRelationshipBanner.d r3 = new FlowRelationshipBanner.d(FlowRelationshipBanner.Type.STRANGER);
        L17:
            r1.lq(r3);
            r1.getRootView().post(new f(r8));
            com.ss.android.lark.chat.chatwindow.chat.v2.component.c r9 = r8.g;
            if (r9 == null) goto L22;
            m4b.a.a(r0.f, r0.g, w.a(r9).getUserId(), r7);
            goto L22
        L13:
            if (r2 != 2) goto L22;
            r3 = new FlowRelationshipBanner.d(FlowRelationshipBanner.Type.BLOCK);
        L22:
            return Unit.INSTANCE;
        }
    }

    public FlowChatReadablePlugin$onCreate$2$2(BaseStrangerRelationViewModel r1, FlowChatReadablePlugin r2, i7b.a r3, Continuation<? super FlowChatReadablePlugin$onCreate$2$2> r4) {
        this.$it = r1;
        this.this$0 = r2;
        this.$initData = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new FlowChatReadablePlugin$onCreate$2$2(this.$it, this.this$0, this.$initData, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        z0 r7 = this.$it.getBannerFlow();
        a r2 = new a(this.this$0, this.$initData);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
