package com.larus.profile.impl;

import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.utils.a4;
import com.larus.profile.impl.viewmodel.ProfileInfoViewModel;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.ProfileBotListFragment$initRecyclerView$1$1$onUpdateCreateScene$1", f = "ProfileBotListFragment.kt", i = {}, l = {435}, m = "invokeSuspend", n = {}, s = {})
public final class ProfileBotListFragment$initRecyclerView$1$1$onUpdateCreateScene$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $position;
    final /* synthetic */ fs9.n $profileBot;
    int label;
    final /* synthetic */ ProfileBotListFragment this$0;

    public ProfileBotListFragment$initRecyclerView$1$1$onUpdateCreateScene$1(fs9.n r1, ProfileBotListFragment r2, int r3, Continuation<? super ProfileBotListFragment$initRecyclerView$1$1$onUpdateCreateScene$1> r4) {
        this.$profileBot = r1;
        this.this$0 = r2;
        this.$position = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ProfileBotListFragment$initRecyclerView$1$1$onUpdateCreateScene$1(this.$profileBot, this.this$0, this.$position, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r2 = "";
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L22:
        if (((Boolean) r7).booleanValue() == true) goto L35;
        BotStatusCacheDelegate r8 = BotStatusCacheDelegate.b;
        String r3 = this.$profileBot.e();
        if (r3 == null) goto L27;
        r2 = r3;
    L27:
        r8.d(r2, true);
        if (this.this$0.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L30;
    L31:
        ProfileBotListAdapter r9 = this.this$0.k;
        if (r9 == null) goto L35;
        r9.notifyItemChanged(this.$position);
        goto L35
    L30:
        if (this.this$0.getLifecycle().getCurrentState() == Lifecycle.State.STARTED) goto L31;
    L35:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        a4.a.getClass();
        a4.a(a4.b);
        BotStatusCacheDelegate r10 = BotStatusCacheDelegate.b;
        String r4 = this.$profileBot.e();
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        r10.d(r4, false);
        if (this.this$0.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L14;
    L15:
        ProfileBotListAdapter r11 = this.this$0.k;
        if (r11 == null) goto L18;
        r11.notifyDataSetChanged();
    L18:
        ProfileInfoViewModel r12 = (ProfileInfoViewModel) this.this$0.s.getValue();
        fs9.n r5 = this.$profileBot;
        this.label = 1;
        r7 = r12.updateCreateScene(r5, this);
        if (r7 != r0) goto L22;
        return r0;
    L14:
        if (this.this$0.getLifecycle().getCurrentState() != Lifecycle.State.STARTED) goto L18;
        goto L15
    }
}
