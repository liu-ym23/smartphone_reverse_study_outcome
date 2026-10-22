package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model;

import com.bytedance.common.utility.NetworkUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
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
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Deferred;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy$ClientSearchStrategy$startSearch$1$1", f = "UserSearchAndMatchStrategy.kt", i = {0}, l = {469}, m = "invokeSuspend", n = {"$this$async"}, s = {"L$0"})
public final class UserSearchAndMatchStrategy$ClientSearchStrategy$startSearch$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Deferred<? extends Unit>>, Object> {
    final /* synthetic */ UserSearchAndMatchStrategy.c $this_apply;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UserSearchAndMatchStrategy.ClientSearchStrategy this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy$ClientSearchStrategy$startSearch$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy$ClientSearchStrategy$startSearch$1$1$1", f = "UserSearchAndMatchStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UserSearchAndMatchStrategy.c $this_apply;
        int label;
        final /* synthetic */ UserSearchAndMatchStrategy.ClientSearchStrategy this$0;

        public AnonymousClass1(UserSearchAndMatchStrategy.ClientSearchStrategy r1, UserSearchAndMatchStrategy.c r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$this_apply = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$this_apply, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L16;
            ResultKt.throwOnFailure(r6);
            UserSearchAndMatchStrategy.ClientSearchStrategy r7 = this.this$0;
            UserSearchAndMatchStrategy.c r0 = this.$this_apply;
            String r1 = r0.a;
            String r2 = r0.b;
            String r3 = r0.d;
            ccb.d r4 = (ccb.d) r7.i.d.invoke(r2, r1, r3, Boolean.TRUE);
            if (r4 == null) goto L7;
            r7.f(r4, true);
        L7:
            monitor-enter(r7);
            UserSearchAndMatchStrategy.SearchStatus r5 = UserSearchAndMatchStrategy.SearchStatus.NET_SEARCH_FINISH;     // Catch: Throwable -> L12
            Intrinsics.checkNotNullParameter(r5, "<set-?>");     // Catch: Throwable -> L12
            r7.c = r5;     // Catch: Throwable -> L12
            monitor-exit(r7);
            return Unit.INSTANCE;
        L12:
            th = move-exception;
            throw th;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy$ClientSearchStrategy$startSearch$1$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy$ClientSearchStrategy$startSearch$1$1$3", f = "UserSearchAndMatchStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UserSearchAndMatchStrategy.c $this_apply;
        int label;
        final /* synthetic */ UserSearchAndMatchStrategy.ClientSearchStrategy this$0;

        public AnonymousClass3(UserSearchAndMatchStrategy.ClientSearchStrategy r1, UserSearchAndMatchStrategy.c r2, Continuation<? super AnonymousClass3> r3) {
            this.this$0 = r1;
            this.$this_apply = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass3(this.this$0, this.$this_apply, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L16;
            ResultKt.throwOnFailure(r6);
            UserSearchAndMatchStrategy.ClientSearchStrategy r7 = this.this$0;
            UserSearchAndMatchStrategy.c r0 = this.$this_apply;
            String r1 = r0.a;
            String r2 = r0.b;
            String r3 = r0.d;
            ccb.d r4 = (ccb.d) r7.i.d.invoke(r2, r1, r3, Boolean.FALSE);
            if (r4 == null) goto L7;
            r7.f(r4, false);
        L7:
            monitor-enter(r7);
            UserSearchAndMatchStrategy.SearchStatus r5 = UserSearchAndMatchStrategy.SearchStatus.LOCAL_SEARCH_FINISH;     // Catch: Throwable -> L12
            Intrinsics.checkNotNullParameter(r5, "<set-?>");     // Catch: Throwable -> L12
            r7.c = r5;     // Catch: Throwable -> L12
            monitor-exit(r7);
            return Unit.INSTANCE;
        L12:
            th = move-exception;
            throw th;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public UserSearchAndMatchStrategy$ClientSearchStrategy$startSearch$1$1(UserSearchAndMatchStrategy.ClientSearchStrategy r1, UserSearchAndMatchStrategy.c r2, Continuation<? super UserSearchAndMatchStrategy$ClientSearchStrategy$startSearch$1$1> r3) {
        this.this$0 = r1;
        this.$this_apply = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        UserSearchAndMatchStrategy$ClientSearchStrategy$startSearch$1$1 r0 = new UserSearchAndMatchStrategy$ClientSearchStrategy$startSearch$1$1(this.this$0, this.$this_apply, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Deferred<Unit>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r11);
        CoroutineScope r3 = r2;
    L16:
        Deferred r12 = BuildersKt.async$default(r3, null, null, new AnonymousClass3(this.this$0, this.$this_apply, null), 3, null);
        UserSearchAndMatchStrategy.ClientSearchStrategy r4 = this.this$0;
        Log.i(r4.h, "[execute][searchUser]add deferred local search task");
        ((ArrayList) r4.d).add(r12);
        return r12;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        Log.i(this.this$0.h, "[execute][searchUser]chatId:" + this.$this_apply.b + " requestId:" + this.$this_apply.d);
        Deferred r5 = BuildersKt.async$default(r13, null, null, new AnonymousClass1(this.this$0, this.$this_apply, null), 3, null);
        UserSearchAndMatchStrategy.ClientSearchStrategy r6 = this.this$0;
        Log.i(r6.h, "[execute][searchUser]add deferred net search task");
        ((ArrayList) r6.d).add(r5);
        if (NetworkUtils.isNetworkAvailableFast(UIHelper.getContext()) == false) goto L11;
        long r7 = 500;
    L12:
        this.L$0 = r13;
        this.label = 1;
        if (DelayKt.delay(r7, this) != r0) goto L15;
        return r0;
    L15:
        r3 = r13;
        goto L16
    L11:
        r7 = 300;
        goto L12
    }
}
