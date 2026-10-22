package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Deferred;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy$ServerSearchStrategy$startSearch$1$1", f = "UserSearchAndMatchStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UserSearchAndMatchStrategy$ServerSearchStrategy$startSearch$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Deferred<? extends Unit>>, Object> {
    final /* synthetic */ String $dummyUserid;
    final /* synthetic */ UserSearchAndMatchStrategy.c $this_apply;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UserSearchAndMatchStrategy.ServerSearchStrategy this$0;
    final /* synthetic */ UserSearchAndMatchStrategy this$1;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy$ServerSearchStrategy$startSearch$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy$ServerSearchStrategy$startSearch$1$1$1", f = "UserSearchAndMatchStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $dummyUserid;
        final /* synthetic */ UserSearchAndMatchStrategy.c $this_apply;
        int label;
        final /* synthetic */ UserSearchAndMatchStrategy this$0;
        final /* synthetic */ UserSearchAndMatchStrategy.ServerSearchStrategy this$1;

        public AnonymousClass1(UserSearchAndMatchStrategy r1, UserSearchAndMatchStrategy.c r2, String r3, UserSearchAndMatchStrategy.ServerSearchStrategy r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$this_apply = r2;
            this.$dummyUserid = r3;
            this.this$1 = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$this_apply, this.$dummyUserid, this.this$1, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L22;
            ResultKt.throwOnFailure(r6);
            ChatChatter r7 = (ChatChatter) this.this$0.e.invoke(this.$this_apply.b, this.$dummyUserid);
            if (r7 == null) goto L10;
            UserSearchAndMatchStrategy.ServerSearchStrategy r0 = this.this$1;
            if (r7.isBot() == true) goto L9;
            r0.b = r7;
        L9:
            Log.i(r0.h, "[syncGetChatChatter] name length:" + r7.getLocalizedName().length());
        L10:
            Object r8 = this.this$0.f.invoke(this.$this_apply.b, this.$dummyUserid);
            UserSearchAndMatchStrategy.ServerSearchStrategy r1 = this.this$1;
            UserSearchAndMatchStrategy r2 = this.this$0;
            String r3 = this.$dummyUserid;
            UserSearchAndMatchStrategy.c r4 = this.$this_apply;
            boolean r9 = ((Boolean) r8).booleanValue();
            ChatChatter r5 = r1.b;
            if (r5 != null) goto L13;
        L19:
            Log.i(r1.h, "[syncCheckUserIsInChat]" + r3 + " is in " + r4.b + ':' + r9);
            UserSearchAndMatchStrategy.ServerSearchStrategy r10 = this.this$1;
            UserSearchAndMatchStrategy.SearchStatus r11 = UserSearchAndMatchStrategy.SearchStatus.NET_SEARCH_FINISH;
            r10.getClass();
            Intrinsics.checkNotNullParameter(r11, "<set-?>");
            r10.c = r11;
            return Unit.INSTANCE;
        L13:
            if (r2.h == true) goto L17;
            if (r9 == true) goto L17;
            boolean r12 = true;
        L18:
            r5.setOutChatUser(r12);
        L17:
            r12 = false;
            goto L18
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public UserSearchAndMatchStrategy$ServerSearchStrategy$startSearch$1$1(UserSearchAndMatchStrategy.ServerSearchStrategy r1, String r2, UserSearchAndMatchStrategy.c r3, UserSearchAndMatchStrategy r4, Continuation<? super UserSearchAndMatchStrategy$ServerSearchStrategy$startSearch$1$1> r5) {
        this.this$0 = r1;
        this.$dummyUserid = r2;
        this.$this_apply = r3;
        this.this$1 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        UserSearchAndMatchStrategy$ServerSearchStrategy$startSearch$1$1 r6 = new UserSearchAndMatchStrategy$ServerSearchStrategy$startSearch$1$1(this.this$0, this.$dummyUserid, this.$this_apply, this.this$1, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Deferred<Unit>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r0 = (CoroutineScope) this.L$0;
        Log.i(this.this$0.h, "[execute][searchUser]userId:" + this.$dummyUserid + " requestId:" + this.$this_apply.d);
        Deferred r11 = BuildersKt.async$default(r0, null, null, new AnonymousClass1(this.this$1, this.$this_apply, this.$dummyUserid, this.this$0, null), 3, null);
        ((ArrayList) this.this$0.d).add(r11);
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
