package com.ss.android.lark.reaction.service.impl;

import android.os.SystemClock;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.im.v1.CreateReactionRequest;
import com.bytedance.lark.pb.im.v1.CreateReactionResponse;
import com.bytedance.lark.pb.im.v1.DeleteReactionRequest;
import com.bytedance.lark.pb.im.v1.DeleteReactionResponse;
import com.bytedance.lark.pb.im.v1.GetEmojiPanelRequest;
import com.bytedance.lark.pb.im.v1.GetEmojiPanelResponse;
import com.bytedance.lark.pb.im.v1.GetUserMRUReactionsRequest;
import com.bytedance.lark.pb.im.v1.GetUserMRUReactionsResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.pb.reactions.UpdateUserRecentlyUsedReactionRequest;
import com.ss.android.lark.pb.reactions.UpdateUserRecentlyUsedReactionResponse;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import qsb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@UserScope
public final class ReactionService2 extends c0c.c implements m2c.b {
    public final l b;

    public static final class a {
    }

    static {
    }

    @Override // m2c.b
    public final List<String> N(final boolean r15) {
        Log.i("ReactionService2", "getMRUReactionList, local: " + r15);
        final long r2 = SystemClock.elapsedRealtime();
        if (r15 == false) goto L5;
        SyncDataStrategy r0 = SyncDataStrategy.LOCAL;
    L6:
        GetUserMRUReactionsRequest.Builder r6 = new GetUserMRUReactionsRequest.Builder().sync_data_strategy(r0);
        l r1 = this.b;
        Intrinsics.checkNotNull(r6);
        GetUserMRUReactionsResponse r3 = (GetUserMRUReactionsResponse) t.c(r1.h(new com.bytedance.lark.rustclient.api.d(r6, GetUserMRUReactionsResponse.ADAPTER, Command.GET_USER_MRU_REACTIONS, null, null, null, null, 248)).execute(), new ReactionService2$getMRUReactionList$1(r2, r15));
        if (r3 == null) goto L11;
        Log.i("ReactionService2", "getMRUReactionList success, local: " + r15);
        long r9 = SystemClock.elapsedRealtime() - r2;
        int r4 = qsb.c.a;
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new f(r15, null, r9, 0));
        ArrayList r16 = new ArrayList();
        List r5 = r3.user_mru_reactions;
        if (r5 == null) goto L13;
        r16.addAll(r5);
        return r16;
    L13:
        return r16;
    L11:
        return null;
    L5:
        r0 = SyncDataStrategy.FORCE_SERVER;
        goto L6
    }

    @Inject
    public ReactionService2(m r2, l r3) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        Intrinsics.checkNotNullParameter(r3, "rustClient");
        super(r2);
        this.b = r3;
    }

    @Override // m2c.b
    public final void o7(final boolean r12, final ReactionOrderService2$fetchEmojiPanelData$2 r13) {
        Log.i("ReactionService2", "getEmojiPanelData, local: " + r12);
        if (r12 == false) goto L5;
        SyncDataStrategy r0 = SyncDataStrategy.LOCAL;
    L6:
        GetEmojiPanelRequest.Builder r3 = new GetEmojiPanelRequest.Builder().sync_data_strategy(r0);
        l r1 = this.b;
        Intrinsics.checkNotNull(r3);
        t.a(r1.h(new com.bytedance.lark.rustclient.api.d(r3, GetEmojiPanelResponse.ADAPTER, Command.GET_EMOJI_PANEL, null, null, null, null, 248)).a(), new ReactionService2$getEmojiPanelData$1(r12, r13), new ReactionService2$getEmojiPanelData$2(r12, r13), new ReactionService2$getEmojiPanelData$3(r12, r13));
        return;
    L5:
        r0 = SyncDataStrategy.FORCE_SERVER;
        goto L6
    }

    @Override // m2c.b
    public final void q(final String r12, final IGetDataCallback<Integer> r13) {
        Intrinsics.checkNotNullParameter(r12, "reactionKey");
        Log.i("ReactionService2", "putReactionPassThrough, key: " + r12);
        UpdateUserRecentlyUsedReactionRequest.Builder r2 = new UpdateUserRecentlyUsedReactionRequest.Builder().reaction_key(r12);
        l r0 = this.b;
        Intrinsics.checkNotNull(r2);
        t.a(r0.h(new com.bytedance.lark.rustclient.api.d(r2, UpdateUserRecentlyUsedReactionResponse.ADAPTER, Command.POST_GATEWAY, null, null, com.ss.android.lark.pb.improto.Command.UPDATE_USER_RECENTLY_USED_EMOJI, null, 184)).a(), new ReactionService2$putReactionPassThrough$1(r12, r13), new ReactionService2$putReactionPassThrough$2(r12, r13), new ReactionService2$putReactionPassThrough$3(r12, r13));
    }

    @Override // m2c.b
    public final void Ya(final String r11, final String r12, boolean r13, final IGetDataCallback<Integer> r14) {
        Intrinsics.checkNotNullParameter(r11, "msgId");
        Intrinsics.checkNotNullParameter(r12, "reactionType");
        if (r13 == false) goto L5;
        Log.i("ReactionService2", "deleteReaction, msgId: " + r11 + ", key: " + r12);
        DeleteReactionRequest.Builder r1 = new DeleteReactionRequest.Builder().message_id(r11).type(r12);
        l r15 = this.b;
        Intrinsics.checkNotNull(r1);
        t.a(r15.h(new com.bytedance.lark.rustclient.api.d(r1, DeleteReactionResponse.ADAPTER, Command.DELETE_REACTION, null, null, null, null, 248)).a(), new ReactionService2$deleteReaction$1(r11, r12, r14), new ReactionService2$deleteReaction$2(r11, r12, r14), new ReactionService2$deleteReaction$3(r11, r12, r14));
        return;
    L5:
        Log.i("ReactionService2", "addReaction, msgId: " + r11 + ", key: " + r12);
        CreateReactionRequest.Builder r2 = new CreateReactionRequest.Builder().message_id(r11).type(r12);
        l r16 = this.b;
        Intrinsics.checkNotNull(r2);
        t.a(r16.h(new com.bytedance.lark.rustclient.api.d(r2, CreateReactionResponse.ADAPTER, Command.CREATE_REACTION, null, null, null, null, 248)).a(), new ReactionService2$addReaction$1(r11, r12, this, r14), new ReactionService2$addReaction$2(r11, r12, r14), new ReactionService2$addReaction$3(r11, r12, r14));
    }
}
