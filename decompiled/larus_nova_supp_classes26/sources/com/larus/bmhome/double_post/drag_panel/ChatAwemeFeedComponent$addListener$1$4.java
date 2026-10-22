package com.larus.bmhome.double_post.drag_panel;

import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.bmhome.double_post.fragment.AwemeDoublePostFragment;
import com.larus.bmhome.setting.UserSettingCacheManager;
import com.larus.bmhome.video.SortRequestType;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.double_post.drag_panel.ChatAwemeFeedComponent$addListener$1$4", f = "ChatAwemeFeedComponent.kt", i = {}, l = {590}, m = "invokeSuspend", n = {}, s = {})
final class ChatAwemeFeedComponent$addListener$1$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatAwemeFeedComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ChatAwemeFeedComponent a;

        public a(ChatAwemeFeedComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            if (((UserConfigKey) r4) != UserConfigKey.RELATED_VIDEO) goto L18;
            UserSettingCacheManager.a.getClass();
            boolean r6 = UserSettingCacheManager.i();
            AwemeDoublePostFragment r7 = this.a.q;
            r7.q = Boolean.valueOf(r6);
            if (Intrinsics.areEqual(Boxing.boxBoolean(r6), this.a.O) == false) goto L8;
            return Unit.INSTANCE;
        L8:
            if (Intrinsics.areEqual(this.a.O, Boxing.boxBoolean(true)) == false) goto L14;
            ChatAwemeFeedComponent.C3(this.a, false, 6);
            AwemeDoublePostFragment r8 = this.a.q;
            if (r8.p == false) goto L16;
            r8.o = true;
            r8.V90();
        L16:
            ChatAwemeFeedComponent r9 = this.a;
            r9.O = Boxing.boxBoolean(r6);
            goto L18
        L14:
            if (Intrinsics.areEqual(this.a.O, Boxing.boxBoolean(false)) == false) goto L16;
            this.a.q.aa0(SortRequestType.UserPullRefresh, true);
        L18:
            return Unit.INSTANCE;
        }
    }

    public ChatAwemeFeedComponent$addListener$1$4(ChatAwemeFeedComponent r1, Continuation<? super ChatAwemeFeedComponent$addListener$1$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatAwemeFeedComponent$addListener$1$4(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        AwemeDoublePostFragment r6 = this.this$0.q;
        UserSettingCacheManager.a.getClass();
        r6.q = Boolean.valueOf(UserSettingCacheManager.i());
        MutableSharedFlow r7 = UserSettingCacheManager.e;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
