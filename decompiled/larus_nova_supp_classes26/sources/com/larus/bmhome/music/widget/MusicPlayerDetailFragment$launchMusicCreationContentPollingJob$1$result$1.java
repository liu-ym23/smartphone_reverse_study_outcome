package com.larus.bmhome.music.widget;

import com.larus.bmhome.chat.resp.MessageList;
import com.larus.bmhome.music.protocol.MusicMessageFetchApi;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/chat/resp/MessageList;", "Lcom/larus/bmhome/music/protocol/MusicMessageFetchApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.widget.MusicPlayerDetailFragment$launchMusicCreationContentPollingJob$1$result$1", f = "MusicPlayerDetailFragment.kt", i = {0}, l = {903, 909}, m = "invokeSuspend", n = {"$this$safeCall"}, s = {"L$0"})
public final class MusicPlayerDetailFragment$launchMusicCreationContentPollingJob$1$result$1 extends SuspendLambda implements Function2<MusicMessageFetchApi, Continuation<? super BizResponse<MessageList>>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MusicPlayerDetailFragment this$0;

    public MusicPlayerDetailFragment$launchMusicCreationContentPollingJob$1$result$1(MusicPlayerDetailFragment r1, Continuation<? super MusicPlayerDetailFragment$launchMusicCreationContentPollingJob$1$result$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MusicPlayerDetailFragment$launchMusicCreationContentPollingJob$1$result$1 r0 = new MusicPlayerDetailFragment$launchMusicCreationContentPollingJob$1$result$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(MusicMessageFetchApi r1, Continuation<? super BizResponse<MessageList>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((MusicMessageFetchApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L16:
        return r8;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        MusicMessageFetchApi r2 = (MusicMessageFetchApi) this.L$0;
        ResultKt.throwOnFailure(r8);
    L13:
        com.larus.bmhome.music.protocol.b r6 = new com.larus.bmhome.music.protocol.b(this.this$0.d.getConversationId(), this.this$0.d.getServerIndex(), 1);
        this.L$0 = null;
        this.label = 2;
        r8 = r2.fetchMessageListForMusic(r6, this);
        if (r8 != r0) goto L16;
        return r0;
    L10:
        ResultKt.throwOnFailure(r8);
        r2 = (MusicMessageFetchApi) this.L$0;
        this.L$0 = r2;
        this.label = 1;
        if (DelayKt.delay(2000, this) != r0) goto L13;
        return r0;
    }
}
