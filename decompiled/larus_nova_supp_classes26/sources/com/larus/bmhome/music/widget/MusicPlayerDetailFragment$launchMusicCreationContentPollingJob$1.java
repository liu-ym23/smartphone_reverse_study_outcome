package com.larus.bmhome.music.widget;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.resp.MessageList;
import com.larus.bmhome.music.protocol.MusicMessageFetchApi;
import com.larus.im.bean.IMMsg;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.im.bean.message.block.MusicCreationContentList;
import com.larus.network.FlowHttpConnection;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.widget.MusicPlayerDetailFragment$launchMusicCreationContentPollingJob$1", f = "MusicPlayerDetailFragment.kt", i = {}, l = {902}, m = "invokeSuspend", n = {}, s = {})
final class MusicPlayerDetailFragment$launchMusicCreationContentPollingJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MusicPlayerDetailFragment this$0;

    public MusicPlayerDetailFragment$launchMusicCreationContentPollingJob$1(MusicPlayerDetailFragment r1, Continuation<? super MusicPlayerDetailFragment$launchMusicCreationContentPollingJob$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MusicPlayerDetailFragment$launchMusicCreationContentPollingJob$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0044 -> B:15:0x0048). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
        Object r2 = r0;
        MusicPlayerDetailFragment$launchMusicCreationContentPollingJob$1 r3 = this;
    L15:
        dm9.a.b r16 = (dm9.a) r15;
        if ((r16 instanceof dm9.a.b) == false) goto L81;
        dm9.a.b r17 = r16;
        MessageList r4 = (MessageList) r17.a.getData();
        if (r4 == null) goto L83;
        List r5 = r4.getMessageList();
        if (r5 == null) goto L83;
        List r6 = CollectionsKt.filterNotNull(r5);
        if (r6 == null) goto L83;
        IMMsg r7 = (IMMsg) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L83;
        MusicPlayerDetailFragment r8 = r3.this$0;
        FLogger r9 = FLogger.a;
        r9.i("MusicPlayerDetailFragment", "[fetchMessageListForMusic] isSuccess=" + r17.a.isSuccess() + ", content=" + r7.a());
        Integer r10 = r7.b();
        String r11 = "";
        if (r10 != null) goto L29;
    L38:
        if (r10 != null) goto L41;
    L61:
        if (r10 != null) goto L64;
    L79:
        r9.e("MusicPlayerDetailFragment", "[fetchMessageListForMusic] e: fault content type un noticed");
        Unit r18 = Unit.INSTANCE;
        goto L83
    L64:
        if (r10.intValue() != 9999) goto L79;
        MusicCreationContentList r12 = n2.a(r7.a());
        if (r12 == null) goto L83;
        Map r13 = r12.getContentMap();
        if (r13 == null) goto L83;
        MusicCreationContent r14 = r8.p;
        if (r14 == null) goto L74;
        ad9.b r19 = r14.getPlayList();
        if (r19 == null) goto L74;
        String r20 = r19.getItemId();
    L75:
        MusicCreationContent r21 = (MusicCreationContent) r13.get(r20);
        if (r21 == null) goto L83;
        r9.d("MusicPlayerDetailFragment", "[fetchMessageListForMusic] by block, currentTaskId=" + r20 + ", content=" + r21);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r8.getViewLifecycleOwner()), null, null, new MusicPlayerDetailFragment$launchMusicCreationContentPollingJob$1$1$3(r8, r21, null), 3, null);
    L74:
        r20 = null;
        goto L75
    L41:
        if (r10.intValue() != 72) goto L61;
        String r22 = r7.i();
        if (r22 != null) goto L45;
        r22 = "";
    L45:
        String r23 = r7.a();
        if (r23 == null) goto L49;
        r11 = r23;
    L49:
        Map r24 = com.larus.bmhome.music.protocol.a.b(r22, r11).getContentMap();
        if (r24 == null) goto L83;
        MusicCreationContent r25 = r8.p;
        if (r25 == null) goto L56;
        ad9.b r26 = r25.getPlayList();
        if (r26 == null) goto L56;
        String r27 = r26.getItemId();
    L57:
        MusicCreationContent r28 = (MusicCreationContent) r24.get(r27);
        if (r28 == null) goto L83;
        r9.d("MusicPlayerDetailFragment", "[fetchMessageListForMusic] by list, currentTaskId=" + r27 + ", content=" + r28);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r8.getViewLifecycleOwner()), null, null, new MusicPlayerDetailFragment$launchMusicCreationContentPollingJob$1$1$2$1(r8, r28, null), 3, null);
    L56:
        r27 = null;
        goto L57
    L29:
        if (r10.intValue() != 70) goto L38;
        MusicCreationContent.b r110 = MusicCreationContent.Companion;
        String r29 = r7.a();
        if (r29 == null) goto L34;
        r11 = r29;
    L34:
        Function1 r30 = new c2();
        r110.getClass();
        MusicCreationContent r111 = MusicCreationContent.b.a(r11, r30);
        if (r111 == null) goto L83;
        r9.d("MusicPlayerDetailFragment", "[fetchMessageListForMusic] content=" + r111);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r8.getViewLifecycleOwner()), null, null, new MusicPlayerDetailFragment$launchMusicCreationContentPollingJob$1$1$1(r8, r111, null), 3, null);
    L83:
        MusicPlayerDetailFragment$launchMusicCreationContentPollingJob$1 r112 = r3;
        r0 = r2;
    L9:
        MusicPlayerDetailFragment r31 = r112.this$0;
        if (r31.t == true) goto L85;
        MusicMessageFetchApi.a r32 = MusicMessageFetchApi.a;
        MusicPlayerDetailFragment$launchMusicCreationContentPollingJob$1$result$1 r33 = new MusicPlayerDetailFragment$launchMusicCreationContentPollingJob$1$result$1(r31, null);
        r112.label = 1;
        r32.getClass();
        FlowHttpConnection r34 = FlowHttpConnection.a;
        Object r35 = FlowHttpConnection.g("Basic", MusicMessageFetchApi.class, r33, false, null, null, null, r112, 248);
        if (r35 != r0) goto L14;
        return r0;
    L14:
        Object r113 = r0;
        r3 = r112;
        r15 = r35;
        r2 = r113;
        goto L15
    L85:
        return Unit.INSTANCE;
    L81:
        if ((r16 instanceof dm9.a.a) == false) goto L83;
        FLogger.a.e("MusicPlayerDetailFragment", "[fetchMessageListForMusic] e:" + ((dm9.a.a) r16).c);
        goto L83
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        r112 = this;
        goto L9
    }
}
