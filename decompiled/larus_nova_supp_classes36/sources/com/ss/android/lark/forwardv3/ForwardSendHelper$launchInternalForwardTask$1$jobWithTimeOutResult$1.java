package com.ss.android.lark.forwardv3;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.MergeFowardMessageType;
import com.bytedance.lark.pb.im.v1.BatchTransmitRequest;
import com.bytedance.lark.pb.im.v1.MergeForwardMessagesRequest;
import com.bytedance.lark.pb.im.v1.TransmitRequest;
import com.bytedance.lark.pb.im.v1.TransmitTarget;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.configuration.IShareContent;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.data.services.ForwardSendServices;
import com.ss.android.lark.forwardv3.data.services.ForwardSendServices$putMergeForwardMessage$callback$1;
import com.ss.android.lark.forwardv3.data.services.ForwardSendServices$putOneByOneForwardMessage$callback$1;
import com.ss.android.lark.forwardv3.data.services.ForwardSendServices$putSingleForwardMessage$callback$1;
import com.ss.android.lark.forwardv3.messageforward.MergeMessageForwardContent;
import com.ss.android.lark.forwardv3.messageforward.OneByOneMessageForwardContent;
import com.ss.android.lark.forwardv3.messageforward.SingleMessageForwardContent;
import com.ss.android.lark.forwardv3.utils.Constants$ForwardTargetType;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.forwardv3.ForwardSendHelper$launchInternalForwardTask$1$jobWithTimeOutResult$1", f = "ForwardSendHelper.kt", i = {}, l = {312}, m = "invokeSuspend", n = {}, s = {})
public final class ForwardSendHelper$launchInternalForwardTask$1$jobWithTimeOutResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ List<SearchBaseInfo> $items;
    final /* synthetic */ String $note;
    final /* synthetic */ y.a $resultCallback;
    final /* synthetic */ RichText $richText;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ y this$0;

    public ForwardSendHelper$launchInternalForwardTask$1$jobWithTimeOutResult$1(y r1, List<? extends SearchBaseInfo> r2, Context r3, RichText r4, String r5, y.a r6, Continuation<? super ForwardSendHelper$launchInternalForwardTask$1$jobWithTimeOutResult$1> r7) {
        this.this$0 = r1;
        this.$items = r2;
        this.$context = r3;
        this.$richText = r4;
        this.$note = r5;
        this.$resultCallback = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ForwardSendHelper$launchInternalForwardTask$1$jobWithTimeOutResult$1(this.this$0, this.$items, this.$context, this.$richText, this.$note, this.$resultCallback, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r27) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        y.a r3 = (y.a) this.L$5;
        String r4 = (String) this.L$4;
        RichText r5 = (RichText) this.L$3;
        Context r6 = (Context) this.L$2;
        List r7 = (List) this.L$1;
        y r8 = (y) this.L$0;
        ResultKt.throwOnFailure(r27);
        return r27;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r27);
        final y r9 = this.this$0;
        final List<SearchBaseInfo> r10 = this.$items;
        final Context r11 = this.$context;
        final RichText r12 = this.$richText;
        final String r13 = this.$note;
        final y.a r14 = this.$resultCallback;
        this.L$0 = r9;
        this.L$1 = r10;
        this.L$2 = r11;
        this.L$3 = r12;
        this.L$4 = r13;
        this.L$5 = r14;
        this.label = 1;
        final kotlinx.coroutines.j r15 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r15.C();
        final IGetDataCallback<rib.d> r16 = new ForwardSendHelper$launchInternalForwardTask$1$jobWithTimeOutResult$1$1$forwardContentCallbackInner$1(r15, r14, r10);
        r9.getClass();
        if (y.d(r10) == false) goto L31;
        final OnForwardContentListener r17 = r9.c;
        if (r17 != null) goto L13;
        r17 = r9.a.getForwardContentListener();
    L13:
        r9.a.getForwardNoteListener();
        Log.i("NewForward", "start handleAiKnowledgeItems target size: " + r10.size() + '}');
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r10.iterator();
    L15:
        if (r19.hasNext() == false) goto L24;
        Object r20 = r19.next();
        if (((SearchBaseInfo) r20).getType() != 26) goto L19;
        boolean r21 = true;
    L20:
        if (r21 == false) goto L15;
        r18.add(r20);
        goto L15
    L19:
        r21 = false;
        goto L20
    L24:
        if ((!r18.isEmpty()) == false) goto L30;
        ForwardV3ViewModel r22 = r9.a;
        if (r12 == null) goto L28;
        String r23 = r12.getInnerText();
    L29:
        r22.requestAiKnowledgeData(r23, new ForwardSendHelper$handleAiKnowledgeItems$1(r11, r17, r16, r9));
        goto L31
    L28:
        r23 = null;
        goto L29
    L30:
        Log.i("NewForward", "no ai knowledge item to handle");
    L31:
        ArrayList r24 = new ArrayList();
        ArrayList r25 = new ArrayList();
        Iterator<T> r26 = r10.iterator();
    L33:
        if (r26.hasNext() == false) goto L42;
        Object r28 = r26.next();
        if (((SearchBaseInfo) r28).getType() != 26) goto L37;
        boolean r29 = true;
    L38:
        if (r29 == true) goto L39;
        r25.add(r28);
        goto L33
    L39:
        r24.add(r28);
        goto L33
    L37:
        r29 = false;
        goto L38
    L42:
        if ((!((List) new Pair(r24, r25).component2()).isEmpty()) == true) goto L47;
        boolean r30 = com.ss.android.lark.forwardv3.utils.b.a("core.forward.to_knowledge_ai", false);
        Log.i("FGUtils", "FG key: core.forward.to_knowledge_ai: " + r30);
        if (r30 == false) goto L47;
        Object r110 = r1;
        kotlinx.coroutines.j r210 = r15;
    L123:
        Object r0 = r210.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L126;
        DebugProbesKt.probeCoroutineSuspended(this);
    L126:
        Object r31 = r110;
        if (r0 != r31) goto L145;
        return r31;
    L145:
        return r0;
    L47:
        IForwardContent r32 = r9.a.getForwardContent();
        if ((r32 instanceof SingleMessageForwardContent) == false) goto L75;
        Log.i("NewForward", "forward single message");
        Message r33 = r9.a.getSourceMessage();
        if (r33 == null) goto L74;
        SingleMessageForwardContent r34 = (SingleMessageForwardContent) r32;
        boolean r111 = !TextUtils.isEmpty(r34.c);
        int r112 = ForwardSendServices.a;
        if (r111 == false) goto L54;
        String r35 = r34.c;
    L55:
        IGetDataCallback<rib.d> r113 = r16;
        final List<ForwardTargetBaseInfoNew> r36 = r9.a.getForwardTargets();
        String r37 = r34.b;
        r110 = r1;
        if (y.d(r9.d) == false) goto L58;
        r113 = null;
    L58:
        final OnForwardContentListener r38 = y.b(r9);
        final oib.d r39 = y.c(r9);
        Intrinsics.checkNotNullParameter(r35, "id");
        Intrinsics.checkNotNullParameter(r36, "targets");
        Intrinsics.checkNotNullParameter(r13, "note");
        Intrinsics.checkNotNullParameter(r12, "richText");
        StringBuilder r40 = new StringBuilder("start forward single message\n");
        if (r111 == false) goto L61;
        r40.append("favorite id is: " + r35 + '\n');
    L62:
        Iterator r41 = r36.iterator();
    L64:
        if (r41.hasNext() == false) goto L66;
        ForwardTargetBaseInfoNew r114 = (ForwardTargetBaseInfoNew) r41.next();
        StringBuilder r115 = new StringBuilder("target id is: ");
        Iterator r116 = r41;
        r115.append(r114.a);
        r115.append(", type is: ");
        Constants$ForwardTargetType.a r42 = Constants$ForwardTargetType.Companion;
        int r117 = r114.getType();
        r42.getClass();
        r115.append(Constants$ForwardTargetType.a.a(r117));
        r115.append('\n');
        r40.append(r115.toString());
        r41 = r116;
        goto L64
    L66:
        Log.i("ForwardSendServices", r40.toString());
        final LinkedHashMap r43 = new LinkedHashMap();
        LinkedHashMap r44 = new LinkedHashMap();
        final ArrayList r118 = new ArrayList();
        ForwardSendServices.e(r43, r44, r118, r36);
        List r45 = CollectionsKt.toList(r43.keySet());
        TransmitRequest.Builder r46 = new TransmitRequest.Builder().id(r35).chat_ids(r45).thread_targets(CollectionsKt.toList(r44.values()));
        if (r111 == false) goto L69;
        TransmitRequest.Type r47 = TransmitRequest.Type.FAVORITE;
    L70:
        TransmitRequest.Builder r48 = r46.type(r47);
        if (r37 != null) goto L73;
        r37 = "";
    L73:
        TransmitRequest.Builder r49 = r48.origin_merge_forward_id(r37);
        SdkSender.IParser r50 = com.ss.android.lark.forwardv3.data.services.e.a;
        final IGetDataCallback<rib.d> r119 = r113;
        SdkSender.asynSendRequestNonWrap(Command.TRANSMIT, r49, new ForwardSendServices$putSingleForwardMessage$callback$1(r11, r13, r12, r43, r118, r39, r38, r36, r119), r50);
        r210 = r15;
        goto L123
    L69:
        r47 = TransmitRequest.Type.MESSAGE;
        goto L70
    L61:
        r40.append("message id is: " + r35 + '\n');
        goto L62
    L54:
        r35 = r33.getId();
        goto L55
    L74:
        r110 = r1;
        r15.resumeWith(Result.constructor-impl(null));
        Unit r51 = Unit.INSTANCE;
        r210 = r15;
        goto L123
    L75:
        r110 = r1;
        IGetDataCallback<rib.d> r120 = r16;
        r210 = r15;
        if ((r32 instanceof MergeMessageForwardContent) == false) goto L94;
        Log.i("NewForward", "forward merge message");
        int r52 = ForwardSendServices.a;
        MergeMessageForwardContent r53 = (MergeMessageForwardContent) r32;
        ArrayList<String> r54 = r53.c;
        final List<ForwardTargetBaseInfoNew> r121 = r9.a.getForwardTargets();
        String r55 = r53.d;
        boolean r122 = r53.e;
        String r123 = r53.f;
        boolean r56 = r53.g;
        String r57 = r53.b;
        if (y.d(r9.d) == false) goto L80;
        r120 = null;
    L80:
        final OnForwardContentListener r211 = y.b(r9);
        final oib.d r58 = y.c(r9);
        Intrinsics.checkNotNullParameter(r54, "messageIds");
        Intrinsics.checkNotNullParameter(r121, "targets");
        Intrinsics.checkNotNullParameter(r55, "quasiTitle");
        Intrinsics.checkNotNullParameter(r123, "threadId");
        Intrinsics.checkNotNullParameter(r57, "originMergeForwardId");
        Intrinsics.checkNotNullParameter(r13, "note");
        Intrinsics.checkNotNullParameter(r12, "richText");
        StringBuilder r59 = new StringBuilder("start forward merge message\n");
        Iterator<T> r60 = r54.iterator();
    L82:
        if (r60.hasNext() == false) goto L84;
        r59.append("messageId: " + ((String) r60.next()));
        goto L82
    L84:
        Iterator<T> r61 = r121.iterator();
    L86:
        if (r61.hasNext() == false) goto L88;
        ForwardTargetBaseInfoNew r62 = (ForwardTargetBaseInfoNew) r61.next();
        StringBuilder r63 = new StringBuilder("target id is: ");
        r63.append(r62.a);
        r63.append(", type is: ");
        Constants$ForwardTargetType.a r124 = Constants$ForwardTargetType.Companion;
        int r64 = r62.getType();
        r124.getClass();
        r63.append(Constants$ForwardTargetType.a.a(r64));
        r63.append('\n');
        r59.append(r63.toString());
        goto L86
    L88:
        Log.i("ForwardSendServices", r59.toString());
        final LinkedHashMap r65 = new LinkedHashMap();
        LinkedHashMap r66 = new LinkedHashMap();
        final ArrayList r67 = new ArrayList();
        ForwardSendServices.e(r65, r66, r67, r121);
        List r68 = CollectionsKt.toList(r65.keySet());
        List r69 = CollectionsKt.toList(r66.values());
        MergeForwardMessagesRequest.Builder r70 = new MergeForwardMessagesRequest.Builder().message_ids(r54).chat_ids(r68).quasi_title(r55);
        if (r122 == false) goto L91;
        MergeFowardMessageType r71 = MergeFowardMessageType.MERGE_THREAD;
    L92:
        MergeForwardMessagesRequest.Builder r72 = r70.type(r71).thread_id(r123).limited(Boolean.valueOf(r56)).thread_targets(r69).origin_merge_forward_id(r57);
        SdkSender.IParser r73 = com.ss.android.lark.forwardv3.data.services.c.a;
        final IGetDataCallback<rib.d> r125 = r120;
        SdkSender.asynSendRequestNonWrap(Command.MERGE_FORWARD_MESSAGES, r72, new ForwardSendServices$putMergeForwardMessage$callback$1(r11, r13, r12, r65, r67, r58, r211, r121, r125), r73);
        Unit r74 = Unit.INSTANCE;
        goto L123
    L91:
        r71 = MergeFowardMessageType.MERGE_MESSAGE;
        goto L92
    L94:
        if ((r32 instanceof OneByOneMessageForwardContent) == false) goto L112;
        Log.i("NewForward", "forward one by one message");
        int r75 = ForwardSendServices.a;
        OneByOneMessageForwardContent r76 = (OneByOneMessageForwardContent) r32;
        ArrayList<String> r77 = r76.c;
        List<ForwardTargetBaseInfoNew> r126 = r9.a.getForwardTargets();
        String r78 = r76.b;
        if (y.d(r9.d) == false) goto L98;
        r120 = null;
    L98:
        final OnForwardContentListener r127 = y.b(r9);
        final oib.d r79 = y.c(r9);
        Intrinsics.checkNotNullParameter(r77, "messageIds");
        Intrinsics.checkNotNullParameter(r126, "targets");
        Intrinsics.checkNotNullParameter(r78, "originMergeForwardId");
        Intrinsics.checkNotNullParameter(r13, "note");
        Intrinsics.checkNotNullParameter(r12, "richText");
        StringBuilder r80 = new StringBuilder("start forward one by one message\n");
        Iterator<T> r81 = r77.iterator();
    L100:
        if (r81.hasNext() == false) goto L102;
        r80.append("messageId: " + ((String) r81.next()));
        goto L100
    L102:
        Iterator<T> r82 = r126.iterator();
    L104:
        if (r82.hasNext() == false) goto L106;
        ForwardTargetBaseInfoNew r83 = (ForwardTargetBaseInfoNew) r82.next();
        StringBuilder r84 = new StringBuilder("target id is: ");
        r84.append(r83.a);
        r84.append(", type is: ");
        Constants$ForwardTargetType.a r128 = Constants$ForwardTargetType.Companion;
        int r85 = r83.getType();
        r128.getClass();
        r84.append(Constants$ForwardTargetType.a.a(r85));
        r84.append('\n');
        r80.append(r84.toString());
        goto L104
    L106:
        Log.i("ForwardSendServices", r80.toString());
        final ArrayList r86 = new ArrayList();
        ArrayList r87 = new ArrayList();
        Iterator r88 = ((LinkedHashMap) ForwardSendServices.d(r126, true)).entrySet().iterator();
    L108:
        if (r88.hasNext() == false) goto L110;
        Map.Entry r89 = (Map.Entry) r88.next();
        TransmitTarget r90 = new TransmitTarget.Builder().chat_id(((com.ss.android.lark.forwardv3.data.services.g) r89.getValue()).a).build();
        r86.add(((com.ss.android.lark.forwardv3.data.services.g) r89.getValue()).a);
        Intrinsics.checkNotNull(r90);
        r87.add(r90);
        goto L108
    L110:
        BatchTransmitRequest.Builder r91 = new BatchTransmitRequest.Builder().message_ids(r77).targets(r87).origin_merge_forward_id(r78);
        SdkSender.IParser r92 = com.ss.android.lark.forwardv3.data.services.d.a;
        final IGetDataCallback<rib.d> r93 = r120;
        SdkSender.asynSendRequestNonWrap(Command.BATCH_TRANSMIT, r91, new ForwardSendServices$putOneByOneForwardMessage$callback$1(r11, r86, r127, r93, r13, r12, r79), r92);
        Unit r94 = Unit.INSTANCE;
        goto L123
    L112:
        if ((r32 instanceof IShareContent) == false) goto L118;
        Log.i("NewForward", "forward common share");
        ForwardV3ViewModel r95 = r9.a;
        if (y.d(r9.d) == false) goto L116;
        IGetDataCallback<rib.d> r96 = null;
    L117:
        r95.performShareForward(r11, r13, r12, r96);
        Unit r97 = Unit.INSTANCE;
        goto L123
    L116:
        r96 = r120;
        goto L117
    L118:
        Log.i("NewForward", "forward common message");
        ForwardV3ViewModel r98 = r9.a;
        if (y.d(r9.d) == false) goto L121;
        IGetDataCallback<rib.d> r99 = null;
    L122:
        r98.performForward(r11, r13, r12, r99);
        Unit r100 = Unit.INSTANCE;
        goto L123
    L121:
        r99 = r120;
        goto L122
    }
}
