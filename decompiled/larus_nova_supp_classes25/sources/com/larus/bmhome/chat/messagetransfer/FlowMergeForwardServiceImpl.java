package com.larus.bmhome.chat.messagetransfer;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.b4;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.t2;
import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageTag;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.TextContent;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.AttachmentType;
import com.larus.im.bean.message.block.BizMergeForwardBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.GenImageBlock;
import com.larus.im.bean.message.block.ImageAnalysisBlock;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.platform.model.CollectionDetail;
import com.larus.platform.model.MessageCollection;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;
import tx9.v0;
import vd9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J$\u0010\u0015\u001a\u00020\u00162\b\u0010\r\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0002J\u0015\u0010\u0018\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0019J\u001a\u0010\u0018\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0015\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0000¢\u0006\u0002\b J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0002¨\u0006$"}, d2 = {"Lcom/larus/bmhome/chat/messagetransfer/FlowMergeForwardServiceImpl;", "Lcom/larus/bmhome/chat/messagetransfer/IFlowMergeForwardService;", "<init>", "()V", "getDoubaoMessageDisplayText", "", "context", "Landroid/content/Context;", "payload", "", "deleteLocalDoubaoMessage", "", "openDoubaoMergeForwardPage", "request", "Lcom/larus/bmhome/chat/messagetransfer/FlowDoubaoMergeForwardRequest;", "prepareAskDoubao", "Lcom/larus/bmhome/chat/messagetransfer/FlowAskDoubaoResult;", "Lcom/larus/bmhome/chat/messagetransfer/FlowHumanMergeForwardRequest;", "fallbackTitle", "releasePreparedAskDoubao", "result", "buildAskDoubaoBundle", "Landroid/os/Bundle;", "messageCacheKey", "buildHumanMergeForwardPayload", "buildHumanMergeForwardPayload$impl_mainlandRelease", "buildPreviewCollection", "Lcom/larus/platform/model/MessageCollection;", "convertPayloadToFlowMessage", "Lcom/larus/im/bean/message/Message;", "normalizePreviewMessage", "message", "normalizePreviewMessage$impl_mainlandRelease", "normalizedChatType", "chatType", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class FlowMergeForwardServiceImpl implements IFlowMergeForwardService {

    public static final class a {
    }

    public static final class b implements IIMCallback<List<? extends Message>> {
        public b() {
        }

        public final boolean mustInMain() {
            return !y0.a();
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.w("FlowMergeForwardService", "deleteLocalDoubaoMessage failed, code=" + r4.getCode());
        }

        public final void onSuccess(Object r4) {
            List r5 = (List) r4;
            Intrinsics.checkNotNullParameter(r5, "result");
            FLogger.a.i("FlowMergeForwardService", "deleteLocalDoubaoMessage success, size=" + r5.size());
        }
    }

    static {
    }

    public FlowMergeForwardServiceImpl() {
    }

    public static Message f(byte[] r5) {
        if (r5.length != 0) goto L5;
        boolean r0 = true;
    L6:
        Object r1 = null;
        if (r0 == false) goto L22;
        return null;
    L22:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        Object r6 = Result.constructor-impl((Message) BuildersKt.runBlocking(Dispatchers.getIO(), new FlowMergeForwardServiceImpl$convertPayloadToFlowMessage$1$1(r5, null)));     // Catch: Throwable -> L11
    L13:
        Throwable r3 = Result.exceptionOrNull-impl(r6);
        if (r3 == null) goto L17;
        FLogger.a.e("FlowMergeForwardService", "convert host message payload failed", r3);
    L17:
        if (Result.isFailure-impl(r6) == true) goto L21;
        r1 = r6;
    L21:
        return (Message) r1;
    L11:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.bmhome.chat.messagetransfer.IFlowMergeForwardService
    public final String b(d r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        ConcurrentHashMap<String, String> r0 = b4.a;
        String r4 = r3.c;
        if (r4 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r4)) == true) goto L8;
        r4 = null;
    L8:
        if (r4 != null) goto L10;
        return null;
    L10:
        return b4.a.remove(r4);
    }

    @Override // com.larus.bmhome.chat.messagetransfer.IFlowMergeForwardService
    public final boolean d(byte[] r9) {
        Intrinsics.checkNotNullParameter(r9, "payload");
        Message r10 = f(r9);
        if (r10 != null) goto L5;
        return false;
    L5:
        String r2 = r10.getConversationId();
        if (r2 != null) goto L8;
        return false;
    L8:
        com.larus.im.d.e().h(r2, CollectionsKt.listOf(r10), false, false, false, new b());
        return true;
    }

    @Override // com.larus.bmhome.chat.messagetransfer.IFlowMergeForwardService
    public final d a(f r21, String r22) {
        String r2 = r22;
        Intrinsics.checkNotNullParameter(r2, "fallbackTitle");
        FLogger r1 = FLogger.a;
        StringBuilder r3 = new StringBuilder("prepare ask doubao, msgCount=");
        boolean r4 = false;
        if (r21 == null) goto L7;
        List<String> r5 = r21.c;
        if (r5 == null) goto L7;
        int r6 = r5.size();
    L8:
        r3.append(r6);
        r3.append(", hasHostMessageRef=");
        String r7 = null;
        if (r21 == null) goto L11;
        String r8 = r21.b;
    L13:
        if (r8 != null) goto L15;
    L18:
        boolean r9 = true;
    L19:
        r3.append(!r9);
        r1.i("FlowMergeForwardService", r3.toString());
        if (r21 == null) goto L28;
        ConcurrentHashMap r10 = v0.a;
        List<String> r11 = r21.c;
        String r12 = r21.d;
        String r13 = v0.e(r21.e);
        int r14 = r21.f;
        Intrinsics.checkNotNullParameter(r11, "forwardMessageIds");
        Intrinsics.checkNotNullParameter(r13, "chatType");
        String r15 = v0.e(r13);
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r11.iterator();
    L23:
        if (r17.hasNext() == false) goto L27;
        Object r18 = r17.next();
        if ((!StringsKt.isBlank((String) r18)) == false) goto L23;
        r16.add(r18);
        goto L23
    L27:
        v0.c r19 = new v0.c(r15, r14, CollectionsKt.joinToString$default(r16, ",", null, null, 0, null, null, 62, null), r12);
        JSONObject r20 = new JSONObject();
        r20.put("enter_method", r19.a);
        r20.put("scene", r19.b);
        r20.put("current_page", r19.c);
        r20.put("chat_type", r19.d);
        v0.a(r20, r19);
        by7.a r23 = new by7.a("click_ask_doubao");
        r23.a.merge(new TrackParams().merge(r20));
        r23.b();
    L28:
        ConcurrentHashMap<String, String> r24 = b4.a;
        if (r21 == null) goto L31;
        String r25 = r21.b;
    L32:
        if (r25 != null) goto L34;
    L40:
        String r26 = null;
    L41:
        Bundle r27 = new Bundle();
        AuthModelDelegate r28 = AuthModelDelegate.b;
        wc9.e r110 = (wc9.e) r28.y().getValue();
        if (r110 != null) goto L45;
        r110 = (wc9.e) r28.u().getValue();
    L45:
        if (r110 == null) goto L62;
        r27.putString("argConversationId", r110.a);
        String r111 = r110.c;
        if (r111 != null) goto L49;
    L55:
        r27.putString("argChatTitle", r2);
        e0 r29 = (e0) r28.e().getValue();
        if (r29 == null) goto L62;
        LaunchInfo r30 = r29.a;
        if (r30 == null) goto L62;
        String r31 = r30.W();
        if (r31 == null) goto L62;
        r27.putString("argBotId", r31);
        goto L62
    L49:
        if ((!StringsKt.isBlank(r111)) == true) goto L52;
        r111 = null;
    L52:
        if (r111 == null) goto L55;
        r2 = r111;
    L62:
        if (r21 == null) goto L73;
        List<String> r32 = r21.c;
        if (r32 == null) goto L73;
        String r33 = (String) CollectionsKt.firstOrNull(r32);
        if (r33 == null) goto L73;
        if ((!StringsKt.isBlank(r33)) == true) goto L71;
        r33 = null;
    L71:
        if (r33 == null) goto L73;
        r27.putString("message_id", r33);
    L73:
        if (r21 == null) goto L97;
        if (r21.c.isEmpty() == false) goto L77;
        FLogger.a.w("FlowMergeForwardService", "build ask doubao payload with empty subMessageIds");
    L77:
        FLogger r34 = FLogger.a;
        StringBuilder r35 = new StringBuilder("build ask doubao payload, msgCount=");
        r35.append(r21.c.size());
        r35.append(", hasCacheKey=");
        if (r26 == null) goto L80;
        r4 = true;
    L80:
        r35.append(r4);
        r34.i("FlowMergeForwardService", r35.toString());
        JSONArray r36 = new JSONArray();
        Iterator<T> r37 = r21.c.iterator();
    L82:
        if (r37.hasNext() == false) goto L84;
        r36.put((String) r37.next());
        goto L82
    L84:
        JSONObject r38 = new JSONObject();
        String r39 = (String) CollectionsKt.firstOrNull(r21.c);
        if (r39 != null) goto L87;
        r39 = "";
    L87:
        r38.put("messageId", r39);
        r38.put("title", r21.a);
        r38.put("subMsgIds", r36);
        if (r26 == null) goto L90;
        r38.put("messageCacheKey", r26);
    L90:
        String r40 = r21.d;
        if ((!StringsKt.isBlank(r40)) == false) goto L93;
        r7 = r40;
    L93:
        if (r7 == null) goto L95;
        r38.put("forwardChatId", r7);
    L95:
        r38.put("chatType", v0.e(r21.e));
        r38.put("isLarkMsg", r21.f);
        r27.putString("human_merge_forward_info", r38.toString());
    L97:
        return new d(r27.getString("argConversationId"), r27, r26);
    L34:
        if ((!StringsKt.isBlank(r25)) == true) goto L37;
        r25 = null;
    L37:
        if (r25 == null) goto L40;
        r26 = UUID.randomUUID().toString();
        b4.a.put(r26, r25);
        goto L41
    L31:
        r25 = null;
        goto L32
    L15:
        if (StringsKt.isBlank(r8) == true) goto L18;
        r9 = false;
        goto L19
    L11:
        r8 = null;
    L7:
        r6 = 0;
        goto L8
    }

    @Override // com.larus.bmhome.chat.messagetransfer.IFlowMergeForwardService
    public final boolean c(FragmentActivity r54, e r55) {
        Intrinsics.checkNotNullParameter(r54, "context");
        Intrinsics.checkNotNullParameter(r55, "request");
        List<byte[]> r2 = r55.d;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Message r5 = f((byte[]) r4.next());
        if (r5 == null) goto L4;
        r3.add(r5);
        goto L4
    L8:
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r7 = r3.iterator();
    L9:
        String r8 = null;
        if (r7.hasNext() == false) goto L26;
        Message r9 = (Message) r7.next();
        Intrinsics.checkNotNullParameter(r9, "message");
        if (r9.getUserType() == 1) goto L14;
        Message r10 = Message.copy$default(r9, null, null, null, 0, 21, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -17, 31, null);
    L24:
        r6.add(r10);
        goto L9
    L14:
        String r11 = AccountService.a.getUserId();
        if ((true ^ StringsKt.isBlank(r11)) == false) goto L17;
        r8 = r11;
    L17:
        Map r12 = r9.getExt();
        if (r12 != null) goto L20;
        r12 = MapsKt.emptyMap();
    L20:
        Map r13 = MapsKt.toMutableMap(r12);
        r13.put("case_scene", "detail");
        if (r8 != null) goto L23;
        r8 = r9.getSenderId();
    L23:
        r10 = Message.copy$default(r9, null, null, r8, 0, 11, null, 0, false, null, null, null, null, null, r13, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -8213, 31, null);
        goto L24
    L26:
        if (r6.isEmpty() == false) goto L28;
        MessageCollection r14 = null;
    L33:
        int r15 = 0;
        if (r14 != null) goto L37;
        FLogger.a.w("FlowMergeForwardService", "openDoubaoMergeForwardPage failed, empty sub messages, hostMessageId=" + r55.c);
        return false;
    L37:
        ConcurrentHashMap<String, MessageCollection> r16 = t2.a;
        String r17 = r55.b;
        Intrinsics.checkNotNullParameter(r14, "collection");
        String r18 = r14.getCollectionId();
        if (r18 != null) goto L41;
        r18 = "";
    L41:
        if (StringsKt.isBlank(r18) == false) goto L43;
        r18 = "doubao_forward_" + System.currentTimeMillis();
    L43:
        t2.a.put(r18, MessageCollection.copy$default(r14, r18, null, null, null, null, null, null, null, null, null, null, null, 4094, null));
        if (r17 != null) goto L46;
    L50:
        com.bytedance.router.i r0 = SmartRouter.buildRoute(r54, "//flow/chat_page");
        r0.c.putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("preview_collection_id", r18), TuplesKt.to("preview_collection_readonly", Boolean.TRUE), TuplesKt.to("argChatTitle", r55.a), TuplesKt.to("as_container", "READONLY_FORWARD_DETAIL"), TuplesKt.to("is_need_fixed_bottom_tab", Boolean.FALSE), TuplesKt.to("ignore_side_bar", "1")}));
        r0.d();
        StringBuilder r1 = new StringBuilder("openDoubaoMergeForwardPage as readonly collection, hostMessageId=");
        r1.append(r55.c);
        r1.append(", collectionId=");
        r1.append(r18);
        r1.append(", count=");
        List r19 = r14.getCollectionDetails();
        if (r19 == null) goto L53;
        r15 = r19.size();
    L53:
        r1.append(r15);
        r1.append(", hasTitle=");
        r1.append(!StringsKt.isBlank(r55.a));
        r1.append(", titleLength=");
        r1.append(r55.a.length());
        String r20 = r1.toString();
        if (StringsKt.isBlank(r55.a) == false) goto L56;
        FLogger.a.w("FlowMergeForwardService", r20);
    L57:
        return true;
    L56:
        FLogger.a.i("FlowMergeForwardService", r20);
        goto L57
    L46:
        if ((!StringsKt.isBlank(r17)) == false) goto L48;
        r8 = r17;
    L48:
        if (r8 == null) goto L50;
        t2.b.put(r18, r8);
        goto L50
    L28:
        String r110 = "doubao_forward_" + r55.c;
        String r111 = r55.a;
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r22 = r6.iterator();
    L30:
        if (r22.hasNext() == false) goto L32;
        Message r23 = (Message) r22.next();
        r21.add(new CollectionDetail(r23.getMessageId(), null, 2, GsonProtectorUtils.toJson(new Gson(), r23), null, 18, null));
        goto L30
    L32:
        r14 = new MessageCollection(r110, r111, null, null, null, null, 2, null, null, null, r21, null, 3004, null);
        goto L33
    }

    @Override // com.larus.bmhome.chat.messagetransfer.IFlowMergeForwardService
    public final String e(Context r25, byte[] r26) {
        Intrinsics.checkNotNullParameter(r25, "context");
        Intrinsics.checkNotNullParameter(r26, "payload");
        Message r2 = f(r26);
        if (r2 != null) goto L5;
        return null;
    L5:
        Set<Integer> r4 = com.larus.bmhome.chat.messagetransfer.a.a;
        Intrinsics.checkNotNullParameter(r25, "context");
        String r1 = r25.getString(2131906312);
        List r5 = r2.getContentBlock();
        if (r5 != null) goto L8;
        r5 = CollectionsKt.emptyList();
    L8:
        List r6 = r5;
        if (r6.isEmpty() == false) goto L11;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r6 = r.a(r2);
    L11:
        List r7 = r6;
        if ((r7 instanceof Collection) == true) goto L14;
    L16:
        Iterator r8 = r7.iterator();
    L18:
        if (r8.hasNext() == false) goto L31;
        Block r9 = (Block) r8.next();
        if (r9.getBlockType() == BlockType.BLOCK_TYPE_BIZ_MERGE_FORWARD.getValue()) goto L28;
        BlockContent r10 = r9.getContent();
        if (r10 == null) goto L24;
        BizMergeForwardBlock r11 = r10.getBizMergeForwardBlock();
    L25:
        if (r11 != null) goto L28;
        boolean r12 = false;
    L29:
        if (r12 == false) goto L18;
        boolean r13 = true;
    L32:
        char r14 = ']';
        if (r13 == true) goto L249;
        int r15 = r2.getContentType();
        Set<Integer> r16 = com.larus.bmhome.chat.messagetransfer.a.a;
        int r17 = 2131900779;
        int r18 = 2131900784;
        int r19 = 2131905683;
        int r110 = 2131900789;
        int r111 = 2131900783;
        if (r15 == 9999) goto L38;
    L172:
        String r20 = com.larus.bmhome.chat.messagetransfer.a.e(r2.getBrief());
        if (r20 != null) goto L252;
        r20 = com.larus.bmhome.chat.messagetransfer.a.e(com.larus.im.bean.message.a.O(r2));
        if (r20 != null) goto L181;
        r20 = com.larus.bmhome.chat.messagetransfer.a.e(com.larus.im.bean.message.a.B(r2));
        if (r20 != null) goto L181;
        r20 = "";
    L181:
        if (lr8.c.a(r2) == false) goto L190;
        NestedFileContent r3 = com.larus.bmhome.chat.bean.d.f(r2);
        int r21 = yc9.v0.h(r3);
        int r22 = yc9.v0.c(r3);
        int r23 = yc9.v0.e(r3);
        if (r21 != r22) goto L185;
        int r112 = 2131900783;
    L253:
        return "[" + r25.getString(r112) + ']';
    L185:
        if (r21 != r23) goto L187;
        r112 = 2131900789;
        goto L253
    L187:
        r112 = 2131905683;
        goto L253
    L190:
        if (r2.getContentType() == 800) goto L192;
    L194:
        int r24 = r2.getContentType();
        if (r24 == 50) goto L240;
        if (r24 == 51) goto L264;
        if (r24 == 60) goto L264;
        if (r24 == 1001) goto L233;
        if (r24 == 2021) goto L262;
        if (r24 == 9999) goto L226;
        switch(r24) {
            case 1: goto L233;
            case 2: goto L213;
            case 3: goto L259;
            case 4: goto L257;
            case 5: goto L262;
            case 6: goto L256;
            case 7: goto L255;
            case 8: goto L264;
            case 9: goto L262;
            default: goto L206;
        };
    L206:
        switch(r24) {
            case 70: goto L259;
            case 71: goto L259;
            case 72: goto L259;
            default: goto L208;
        };
    L208:
        if (r20.length() != 0) goto L222;
        boolean r27 = true;
    L223:
        if (r27 == false) goto L252;
        return com.larus.bmhome.chat.messagetransfer.a.a(r25, r2, r1);
    L222:
        r27 = false;
        goto L223
    L213:
        Intrinsics.checkNotNullParameter(r2, "<this>");
        MessageTag.a r28 = MessageTag.Companion;
        List r29 = r2.getTags();
        r28.getClass();
        if (MessageTag.a.b(r29) == MessageTag.MessageTag_Unknown) goto L216;
        boolean r30 = true;
    L217:
        if (r30 == false) goto L219;
        int r31 = 2131900777;
    L258:
        return r25.getString(r31);
    L219:
        r31 = 2131900787;
        goto L258
    L216:
        r30 = false;
        goto L217
    L255:
        return "[" + r25.getString(2131905683) + ']';
    L256:
        return "[" + r25.getString(2131900783) + ']';
    L257:
        return r25.getString(2131900784);
    L259:
        return r25.getString(2131900786);
    L226:
        if (r20.length() != 0) goto L228;
        boolean r32 = true;
    L229:
        if (r32 == false) goto L252;
        return com.larus.bmhome.chat.messagetransfer.a.a(r25, r2, r1);
    L228:
        r32 = false;
    L262:
        return r25.getString(2131900789);
    L233:
        if (r20.length() != 0) goto L235;
        boolean r33 = true;
    L236:
        if (r33 == false) goto L252;
        return com.larus.bmhome.chat.messagetransfer.a.a(r25, r2, r1);
    L235:
        r33 = false;
    L264:
        return r25.getString(2131900779);
    L240:
        return r25.getString(2131900785);
    L192:
        if (Intrinsics.areEqual(r2.getBizContentType(), "dora_record") == false) goto L194;
        return r25.getString(2131907355);
    L252:
        return r20;
    L38:
        if ((!com.larus.im.bean.message.a.k(r2).isEmpty()) == false) goto L172;
        List r34 = com.larus.im.bean.message.a.A(r2);
        ArrayList r113 = new ArrayList();
        Iterator r35 = ((ArrayList) r34).iterator();
    L41:
        if (r35.hasNext() == false) goto L158;
        Block r36 = (Block) r35.next();
        String r37 = "[" + r25.getString(r111) + r14;
        String r38 = "[" + r25.getString(r110) + r14;
        String r114 = "[" + r25.getString(r18) + r14;
        String r115 = "[" + r25.getString(r19) + r14;
        String r116 = "[" + r25.getString(r17) + r14;
        if (r36.getBlockType() != BlockType.BLOCK_TYPE_TEXT.getValue()) goto L57;
        BlockContent r39 = r36.getContent();
        if (r39 == null) goto L50;
        TextBlock r40 = r39.getTextBlock();
        if (r40 == null) goto L50;
        r37 = r40.text;
        if (r37 == null) goto L50;
    L153:
        r38 = r37;
    L154:
        String r41 = com.larus.bmhome.chat.messagetransfer.a.e(r38);
        if (r41 == null) goto L157;
        r113.add(r41);
    L157:
        r14 = ']';
        r17 = 2131900779;
        r18 = 2131900784;
        r19 = 2131905683;
        r110 = 2131900789;
        r111 = 2131900783;
    L50:
        BlockContent r42 = r36.getContent();
        if (r42 == null) goto L148;
        TextBlock r43 = r42.getTextBlock();
        if (r43 == null) goto L148;
        r37 = r43.summary;
    L148:
        r38 = null;
        goto L154
    L57:
        if (com.larus.bmhome.chat.messagetransfer.a.a.contains(Integer.valueOf(r36.getBlockType())) == true) goto L75;
        BlockContent r117 = r36.getContent();
        if (r117 == null) goto L61;
        String r118 = r117.getImageBlock();
    L62:
        if (r118 != null) goto L75;
        BlockContent r119 = r36.getContent();
        if (r119 == null) goto L66;
        GenImageBlock r120 = r119.getGenImageBlock();
    L67:
        if (r120 != null) goto L75;
        BlockContent r121 = r36.getContent();
        if (r121 == null) goto L71;
        ImageAnalysisBlock r122 = r121.getImageAnalysisBlock();
    L72:
        if (r122 != null) goto L75;
        boolean r123 = false;
    L76:
        if (r123 == true) goto L153;
        if (com.larus.bmhome.chat.messagetransfer.a.d(r36, new AttachmentType[]{AttachmentType.AttachmentTypeImage}) == true) goto L153;
        int r124 = r36.getBlockType();
        BlockType r125 = BlockType.BLOCK_TYPE_CREATION;
        if (r124 != r125.getValue()) goto L99;
        BlockContent r44 = r36.getContent();
        if (r44 == null) goto L95;
        CreationBlock r45 = r44.getCreationBlock();
        if (r45 == null) goto L95;
        List r46 = r45.creations;
        if (r46 == null) goto L95;
        CreationItem r47 = (CreationItem) CollectionsKt.firstOrNull(r46);
        if (r47 == null) goto L95;
        Integer r48 = r47.type;
        if (r48 == null) goto L95;
        if (r48.intValue() != 1) goto L95;
        boolean r49 = true;
    L96:
        if (r49 == false) goto L99;
    L95:
        r49 = false;
    L99:
        if (r36.getBlockType() == BlockType.BLOCK_TYPE_VIDEO_READER.getValue()) goto L154;
        if (com.larus.bmhome.chat.messagetransfer.a.d(r36, new AttachmentType[]{AttachmentType.AttachmentTypeVideo}) == true) goto L154;
        if (r36.getBlockType() != r125.getValue()) goto L122;
        BlockContent r50 = r36.getContent();
        if (r50 == null) goto L118;
        CreationBlock r51 = r50.getCreationBlock();
        if (r51 == null) goto L118;
        List r52 = r51.creations;
        if (r52 == null) goto L118;
        CreationItem r53 = (CreationItem) CollectionsKt.firstOrNull(r52);
        if (r53 == null) goto L118;
        Integer r54 = r53.type;
        if (r54 == null) goto L118;
        if (r54.intValue() != 2) goto L118;
        boolean r55 = true;
    L119:
        if (r55 == false) goto L122;
    L118:
        r55 = false;
    L122:
        if (SetsKt.setOf(new Integer[]{Integer.valueOf(BlockType.BLOCK_TYPE_LINK.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_LINKER_READER.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_RESEARCH_WEBPAGE.getValue())}).contains(Integer.valueOf(r36.getBlockType())) == true) goto L151;
        if (com.larus.bmhome.chat.messagetransfer.a.d(r36, new AttachmentType[]{AttachmentType.AttachmentTypeLink}) == true) goto L151;
        if (SetsKt.setOf(new Integer[]{Integer.valueOf(BlockType.BLOCK_TYPE_FILE.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_ATTACHMENT.getValue())}).contains(Integer.valueOf(r36.getBlockType())) == true) goto L149;
        Set<Integer> r56 = com.larus.bmhome.chat.messagetransfer.a.b;
        BlockContent r57 = r36.getContent();
        if (r57 == null) goto L133;
        ArtifactBlock r58 = r57.getDocBlock();
        if (r58 == null) goto L133;
        Integer r59 = r58.getResourceType();
    L135:
        if (CollectionsKt.contains(r56, r59) == true) goto L149;
        if (com.larus.bmhome.chat.messagetransfer.a.d(r36, new AttachmentType[]{AttachmentType.AttachmentTypeFile, AttachmentType.AttachmentTypeLarkDoc}) == true) goto L149;
        if (SetsKt.setOf(new Integer[]{Integer.valueOf(BlockType.BLOCK_TYPE_ARTIFACT.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_TASK_CARD.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_GENERIC_TOOL.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_LYNX.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_SEARCH_RICH_MEDIA.getValue())}).contains(Integer.valueOf(r36.getBlockType())) == false) goto L143;
    L147:
        r38 = r116;
        goto L154
    L143:
        if (r36.getBlockType() != BlockType.BLOCK_TYPE_CODE.getValue()) goto L146;
        r37 = "[" + r25.getString(2131900780) + ']';
        goto L153
    L146:
        if (SetsKt.setOf(new Integer[]{Integer.valueOf(BlockType.BLOCK_TYPE_CLIENT_LOCAL_PODCAST.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_WIDGET.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_MEMORY.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_BLOCK_RESEARCH_CARD.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_BANNER.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_SEARCH_QUERY.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_SEARCH_RESULT.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_LOCAL_LIFE.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_BLOCK_RESEARCH.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_RESEARCH_STATUS.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_SEARCH_QUERY_RESULT.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_ROUTE_PLAN.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_REFERENCE.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_ARTIFACT_OP.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_GUI_TOOL.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_COMPUTER_USE_TOOL_RESULT.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_BROWSER_CONTROL.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_PERMISSION_APPLY.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_QUICK_REPLY.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_SNIPPET_ACTION_CARD.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_COMMON_BUTTON_V2.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_BIZ_MERGE_FORWARD.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_SPRING_LYNX.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_END_BUTTON.getValue())}).contains(Integer.valueOf(r36.getBlockType())) == false) goto L148;
    L133:
        r59 = null;
    L149:
        r38 = r115;
    L151:
        r38 = r114;
        goto L154
    L71:
        r122 = null;
        goto L72
    L66:
        r120 = null;
        goto L67
    L61:
        r118 = null;
    L75:
        r123 = true;
        goto L76
    L158:
        String r60 = com.larus.bmhome.chat.messagetransfer.a.e(CollectionsKt.joinToString$default(r113, "", null, null, 0, null, null, 62, null));
        if (r60 != null) goto L250;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        TextContent r61 = r.b(r2);
        if (r61 == null) goto L168;
        ouc.b r62 = r61.getImages();
        if (r62 == null) goto L168;
        if ((!r62.isEmpty()) != true) goto L168;
        boolean r63 = true;
    L169:
        if (r63 == false) goto L251;
        r1 = "[" + r25.getString(2131900783) + ']';
    L251:
        return r1;
    L168:
        r63 = false;
        goto L169
    L250:
        return r60;
    L249:
        return "[" + r25.getString(2131906311) + ']';
    L24:
        r11 = null;
    L28:
        r12 = true;
    L31:
        r13 = false;
        goto L32
    L14:
        if (r7.isEmpty() == false) goto L16;
        goto L16
    }
}
