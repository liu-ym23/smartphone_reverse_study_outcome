package com.larus.bmhome.chat.model.strategy.block;

import android.app.Application;
import android.text.TextUtils;
import androidx.collection.LruCache;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.bean.ChatUserContextParam;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.strategy.ChatSendUtils;
import com.larus.bmhome.chat.model.strategy.PPTOptionType;
import com.larus.bmhome.chat.model.strategy.h0;
import com.larus.bmhome.chat.model.strategy.i0;
import com.larus.bmhome.chat.trace.appreciable.CommonParamManager;
import com.larus.bmhome.instruction.core.model.ActionBarInstructionKey;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.AgentTaskParam;
import com.larus.im.bean.message.AgentTaskParamChange;
import com.larus.im.bean.message.ChatAbility;
import com.larus.im.bean.message.ChatAbilityActionBar;
import com.larus.im.bean.message.ChatAbilityType;
import com.larus.im.bean.message.ChatEntryOption;
import com.larus.im.bean.message.ChatEntrySourceType;
import com.larus.im.bean.message.ChatLite;
import com.larus.im.bean.message.ChatQueryOption;
import com.larus.im.bean.message.ClientMeta;
import com.larus.im.bean.message.ClientOption;
import com.larus.im.bean.message.ContextParam;
import com.larus.im.bean.message.ContextType;
import com.larus.im.bean.message.ConversationInitExt;
import com.larus.im.bean.message.ConversationInitOption;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.GeneralTaskParam;
import com.larus.im.bean.message.GuiContext;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageContent;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageRequestType;
import com.larus.im.bean.message.MessageRequestV2;
import com.larus.im.bean.message.MessageSpecificExtra;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.ModelConfig;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.RequestMessage;
import com.larus.im.bean.message.SelectedSkill;
import com.larus.im.bean.message.TextContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UserContext;
import com.larus.im.bean.message.block.AttachmentBlock;
import com.larus.im.bean.message.block.AttachmentItem;
import com.larus.im.bean.message.block.AttachmentItemUploadStatus;
import com.larus.im.bean.message.block.AttachmentType;
import com.larus.im.bean.message.block.BizMergeForwardBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.ImageMeta;
import com.larus.im.bean.message.block.ReferenceBlock;
import com.larus.im.bean.message.block.ReferenceText;
import com.larus.im.bean.message.block.ReferenceTextOption;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.im.bean.message.block.UploadImage;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.AccountService;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import yc9.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d0 {
    public static final d0 a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ContextType.values().length];
            r0[ContextType.ContextType_Doc.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[ContextType.ContextType_Excel.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[ContextType.ContextType_Ppt.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ContextType.ContextType_Lark_Im.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[ContextType.ContextType_Lark_Minutes.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[ContextType.ContextType_Lark_Wiki.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[ContextType.ContextType_Resource.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[ContextType.ContextType_Base.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/larus/bmhome/chat/model/strategy/block/MessageRequestConverter$buildMessageRequestV2$chatQueryOption$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class b extends TypeToken<Map<String, ? extends Object>> {
        public b() {
        }
    }

    public d0() {
    }

    static {
        a = new d0();
        new Gson();
    }

    public static Block c(List r86) {
        return new Block(BlockType.BLOCK_TYPE_ATTACHMENT.getValue(), UUID.randomUUID().toString(), null, new BlockContent(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new AttachmentBlock(r86), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -134217729, -1, 31, null), false, null, null, null, 244, null);
    }

    public static List d(String r18) {
        if (r18 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L12;
        return null;
    L12:
        return CollectionsKt.listOf(new UserContext(ContextType.ContextType_DeliveryAddress.getValue(), new ContextParam(null, null, null, null, null, null, null, r18, null, null, null, 1919, null)));
    L4:
        if (r18.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static List k(String r12) {
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L53
        if (r12 != null) goto L6;
    L52:
        return null;
    L6:
        if ((!StringsKt.isBlank(r12)) == true) goto L9;
        r12 = null;
    L9:
        if (r12 == null) goto L52;
        JSONArray r3 = new JSONArray(r12);     // Catch: Throwable -> L53
        List r13 = CollectionsKt.createListBuilder();     // Catch: Throwable -> L53
        int r4 = r3.length();     // Catch: Throwable -> L53
        int r6 = 0;
    L12:
        if (r6 >= r4) goto L46;
        JSONObject r7 = r3.optJSONObject(r6);     // Catch: Throwable -> L53
        if (r7 == null) goto L45;
        String r8 = r7.optString("name");     // Catch: Throwable -> L53
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L53
        if ((!StringsKt.isBlank(r8)) == true) goto L20;
        r8 = null;
    L20:
        String r9 = r7.optString("path");     // Catch: Throwable -> L53
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L53
        if ((!StringsKt.isBlank(r9)) == true) goto L25;
        r9 = null;
    L25:
        if (r7.has("skill_type") == true) goto L27;
    L29:
        boolean r10 = false;
    L30:
        if (r10 == false) goto L32;
        JSONObject r11 = r7;
    L33:
        if (r11 == null) goto L35;
        Integer r14 = Integer.valueOf(r11.optInt("skill_type"));     // Catch: Throwable -> L53
    L36:
        String r15 = r7.optString("skill_id");     // Catch: Throwable -> L53
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L53
        if ((!StringsKt.isBlank(r15)) == true) goto L40;
        r15 = null;
    L40:
        if (r8 != null) goto L44;
        if (r9 != null) goto L44;
        if (r14 != null) goto L44;
        if (r15 == null) goto L45;
    L44:
        r13.add(new SelectedSkill(r8, r9, r14, r15));     // Catch: Throwable -> L53
        goto L45
    L35:
        r14 = null;
        goto L36
    L32:
        r11 = null;
        goto L33
    L27:
        if (r7.isNull("skill_type") == true) goto L29;
        r10 = true;
    L45:
        r6 = r6 + 1;     // Catch: Throwable -> L53
        goto L12
    L46:
        List r16 = CollectionsKt.build(r13);     // Catch: Throwable -> L53
        if ((!r16.isEmpty()) == true) goto L50;
        r16 = null;
    L50:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L53
    L56:
        if (Result.exceptionOrNull-impl(r17) == null) goto L59;
        FLogger.a.w("MessageRequestConverter", "[parseSkillSelections] parse failed");
    L59:
        if (Result.isFailure-impl(r17) == true) goto L63;
        r1 = r17;
    L63:
        return (List) r1;
    L53:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L56
    }

    public static List o(MessageRequestV2 r51) {
        Intrinsics.checkNotNullParameter(r51, "<this>");
        List r0 = r51.getRequestMessages();
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L30;
        RequestMessage r3 = (RequestMessage) r1.next();
        LinkedHashMap r15 = new LinkedHashMap();
        Map r4 = r3.getBizExt();
        if (r4 == null) goto L19;
        Iterator r5 = r4.entrySet().iterator();
    L9:
        if (r5.hasNext() == false) goto L19;
        Map.Entry r6 = (Map.Entry) r5.next();
        String r7 = (String) r6.getKey();
        String r8 = (String) r6.getValue();
        if (r8 != null) goto L13;
    L16:
        boolean r9 = true;
    L17:
        if (r9 == true) goto L9;
        r15.put(r7, r8);
        goto L9
    L13:
        if (r8.length() == 0) goto L16;
        r9 = false;
    L19:
        String r10 = r51.getClientMeta().getConversationId();
        String r11 = AccountService.a.getUserId();
        int r12 = r3.getMessageStatusLocal();
        MessageSpecificExtra r13 = r3.getSpecificExtra();
        if (r13 == null) goto L24;
        Integer r14 = r13.getBeforeContentType();
        if (r14 == null) goto L24;
        int r25 = r14.intValue();
    L25:
        List r29 = r3.getContentBlock();
        Boolean r16 = r3.getSourceFromAsr();
        if (r16 == null) goto L28;
        boolean r49 = r16.booleanValue();
    L29:
        Map r18 = r51.getExt();
        String r19 = r3.getLocalMessageId();
        String r36 = r3.getReplyId();
        String r39 = r3.getBizContentType();
        List r28 = r3.getSuggestQuestion();
        List r37 = r3.getTags();
        int r17 = r25;
        boolean r26 = r49;
        r2.add(new Message(r10, null, r11, 1, r12, null, r17, true, r3.getBrief(), null, r29, null, null, r18, r19, null, -1, 0, r26, null, null, r28, r15, null, null, 0, false, 0, r36, r37, false, r39, null, AppHost.a.getAppClock().currentTimeMillis() / ((long) 1000), null, null, null, 1335532066, 29, null));
        goto L4
    L28:
        r49 = false;
    L24:
        r25 = 9999;
        goto L25
    L30:
        return r2;
    }

    public static List a(List r21, List r22) {
        List r0 = r22;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return r21;
    L11:
        List r2 = r22;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L13:
        if (r4.hasNext() == false) goto L15;
        GuiContext r13 = (GuiContext) r4.next();
        r3.add(new UserContext(ContextType.ContextType_Gui.getValue(), new ContextParam(null, null, null, null, null, null, null, null, null, r13, null, 1535, null)));
        goto L13
    L15:
        if (r21 != null) goto L17;
        List r5 = CollectionsKt.emptyList();
    L19:
        return CollectionsKt.plus(r5, r3);
    L17:
        r5 = r21;
        goto L19
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static List b(List r4, List r5) {
        List r0 = r4;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L21;
        List r6 = r5;
        if (r6 != null) goto L14;
    L17:
        if (r1 == false) goto L20;
        return r4;
    L20:
        return CollectionsKt.plus(r0, r5);
    L14:
        if (r6.isEmpty() == true) goto L17;
        r1 = false;
        goto L17
    L21:
        return r5;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    public static UserContext f(ContextType r15, String r16) {
        if (r16 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        return null;
    L12:
        switch(a.a[r15.ordinal()]) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            default: goto L13;
        };
    L13:
        return null;
    L14:
        ContextParam r14 = new ContextParam(null, null, null, r16, null, null, null, null, null, null, null, 2039, null);
    L23:
        return new UserContext(r15.getValue(), r14);
    L15:
        r14 = new ContextParam(null, null, null, null, null, null, null, null, null, null, r16, 1023, null);
        goto L23
    L16:
        r14 = new ContextParam(null, null, null, null, null, null, null, null, r16, null, null, 1791, null);
        goto L23
    L17:
        r14 = new ContextParam(null, null, null, null, null, r16, null, null, null, null, null, 2015, null);
        goto L23
    L18:
        r14 = new ContextParam(null, null, null, null, r16, null, null, null, null, null, null, 2031, null);
        goto L23
    L19:
        r14 = new ContextParam(null, null, r16, null, null, null, null, null, null, null, null, 2043, null);
        goto L23
    L20:
        r14 = new ContextParam(null, r16, null, null, null, null, null, null, null, null, null, 2045, null);
        goto L23
    L21:
        r14 = new ContextParam(r16, null, null, null, null, null, null, null, null, null, null, 2046, null);
        goto L23
    L4:
        if (r16.length() == 0) goto L7;
        r0 = false;
        goto L9
    }

    public static List g(List r7, ChatPageContext r8) {
        if (r7 == null) goto L5;
        return r7;
    L5:
        if (r8 != null) goto L7;
        return null;
    L7:
        ChatUserContextParam r9 = r8.getUserContextParam();
        if (r9 == null) goto L21;
        ContextType[] r0 = ContextType.values();
        int r1 = r0.length;
        int r3 = 0;
    L11:
        if (r3 >= r1) goto L19;
        ContextType r4 = r0[r3];
        if (r4.getValue() != r9.getType()) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == true) goto L20;
        r3 = r3 + 1;
    L20:
        if (r4 == null) goto L21;
        UserContext r10 = f(r4, r9.getContext());
    L23:
        if (r10 != null) goto L25;
        return null;
    L25:
        return CollectionsKt.listOf(r10);
    L15:
        r5 = false;
        goto L16
    L19:
        r4 = null;
    L21:
        r10 = null;
        goto L23
    }

    public static boolean i(Map r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "key");
        if (Intrinsics.areEqual((String) r2.get(r3), "1") == false) goto L5;
        return true;
    L5:
        String r4 = (String) r2.get(r3);
        if (r4 == null) goto L10;
        Boolean r5 = StringsKt.toBooleanStrictOrNull(r4);
        if (r5 == null) goto L10;
        return r5.booleanValue();
    L10:
        return false;
    }

    public static String j(String r4, Function2 r5) {
        Iterable r6 = h0.a(r4);     // Catch: Exception -> L4
    L6:
        ki8.b r0 = new ki8.b(0);
        Iterator r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L15;
        i0 r1 = (i0) r7.next();
        int r2 = r1.g;
        if (r2 == PPTOptionType.PAGE_SIZE.getType()) goto L11;
        if (r2 != PPTOptionType.TEMPLATE.getType()) goto L8;
        r5.invoke(r1.d, r1.e);
        r0.b(r1.d);
        goto L8
    L11:
        r0.a(new ki8.c(r1.b, r1.c));
        goto L8
    L15:
        ki8.a r8 = new ki8.a(r0, 1);
        ChatSendUtils.a.getClass();
        return GsonProtectorUtils.toJson(ChatSendUtils.n(), r8);
    L4:
        e = move-exception;
        FLogger.a.e("MessageRequestConverter", "getPPTAbilityParams error", e);
        com.larus.platform.service.g.a.ensureNotReachHere(e);
        r6 = new ArrayList();
        goto L6
    }

    public static String l(Map r0, String r1) {
        String r2 = (String) r0.remove(r1);
        if (r2 != null) goto L5;
    L7:
        return null;
    L5:
        if ((!StringsKt.isBlank(r2)) == false) goto L7;
        return r2;
    }

    public static ConversationInitExt h(Map r9, ReplyOption r10, ModelItemIdentity r11) {
        String r6 = (String) r9.get("conversation_agent_task_params");
        if (Intrinsics.areEqual(r9.get("need_conversation_init_ext"), "1") == false) goto L15;
        r9.remove("need_conversation_init_ext");
        r9.remove("conversation_agent_task_params");
        String r12 = r11.getKey();
        String r13 = r10.getModeId();
        Integer r14 = r10.getReasoningEffort();
        if (r14 == null) goto L7;
        String r15 = r14.toString();
    L8:
        if (r6 != null) goto L10;
    L12:
        r6 = null;
    L18:
        return new ConversationInitExt(r12, r13, r15, r6);
    L10:
        if ((!StringsKt.isBlank(r6)) == false) goto L12;
    L7:
        r15 = null;
        goto L8
    L15:
        if (o0.d(r6) == false) goto L19;
        r9.remove("conversation_agent_task_params");
        return new ConversationInitExt(null, null, null, r6, 7, null);
    L19:
        return null;
    }

    public static f0 m(ic8.w r25, String r26, int r27) {
        Intrinsics.checkNotNullParameter(r25, "<this>");
        Intrinsics.checkNotNullParameter(r26, "conversationId");
        boolean r2 = false;
        if ((r25 instanceof ai8.b) == false) goto L5;
    L8:
        boolean r13 = true;
    L9:
        ReferenceInfo r1 = r25.T6();
        if (r1 == null) goto L13;
        r2 = com.flow.kmp.common.util.f.a(r1.referencedMessageId);
    L13:
        if (r2 == true) goto L16;
        r1 = null;
    L16:
        ReferenceInfo r12 = r1;
        Map<String, String> r3 = r25.f();
        if (r3 == null) goto L20;
        Map r4 = MapsKt.toMutableMap(r3);
        if (r4 == null) goto L20;
    L21:
        Pair<String, String> r5 = r25.h();
        if (r5 == null) goto L24;
        r4.put(r5.getFirst(), r5.getSecond());
    L24:
        String r6 = AccountService.a.getUserId();
        int r7 = r25.contentType();
        String r8 = r25.content();
        String r16 = r25.g();
        String r9 = r25.b();
        MessageRequestType r10 = r25.d();
        MessageStatus r11 = r25.i();
        if (r11 != null) goto L27;
        r11 = MessageStatus.MessageStatus_AVAILABLE;
    L27:
        Map<String, String> r15 = r25.a();
        Map r20 = r4;
        return new f0(r26, r10, r6, 1, r7, r8, r9, null, r27, r12, r13, null, r15, r16, null, null, null, r20, null, null, r11, 498715328);
    L20:
        r4 = new LinkedHashMap();
        goto L21
    L5:
        if ((r25 instanceof ai8.a) == true) goto L8;
        r13 = false;
        goto L9
    }

    public static ic8.w p(Message r22, boolean r23, boolean r24, String r25, String r26, Map r27, Map r28, ChatPageContext r29) {
        Intrinsics.checkNotNullParameter(r22, "<this>");
        ReferenceInfo r11 = com.larus.bmhome.chat.bean.d.b1(r22);
        String r4 = "";
        Object r5 = null;
        if (r22.getContentType() != 1) goto L27;
        if (r25 != null) goto L6;
        String r0 = com.larus.bmhome.chat.bean.d.H(r22);
        if (r0 == null) goto L25;
    L24:
        r4 = r0;
    L25:
        ic8.w r1 = new ai8.h(r4, r26, r22.getMessageStatus(), r11, r27, r28, r23, r24, r29, null, 512);
    L167:
        return r1;
    L6:
        if (StringsKt.isBlank(r25) == false) goto L147;
    L16:
        TextContent r6 = (TextContent) r5;
        if (r6 == null) goto L25;
        r0 = r6.text;
        if (r0 != null) goto L24;
    L147:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L10
        Object r3 = Result.constructor-impl(HttpExtKt.f.fromJson(r25, TextContent.class));     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r3) == true) goto L16;
        r5 = r3;
    L10:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L27:
        if (r22.getContentType() != 6) goto L62;
        List r8 = com.larus.bmhome.chat.bean.d.g(r22).imageList;
        if (r8 == null) goto L31;
        Image r9 = (Image) CollectionsKt.getOrNull(r8, 0);
    L33:
        if (r9 == null) goto L35;
        String r10 = r9.localResPath;
    L36:
        if (r10 == null) goto L39;
        r4 = r10;
    L39:
        if (r9 == null) goto L41;
        String r12 = r9.key;
    L42:
        if (r9 == null) goto L46;
        ImageObj r13 = r9.imageOri;
        if (r13 == null) goto L46;
        Integer r14 = Integer.valueOf(r13.height);
    L47:
        if (r9 == null) goto L51;
        ImageObj r15 = r9.imageOri;
        if (r15 == null) goto L51;
        Integer r16 = Integer.valueOf(r15.width);
    L52:
        if (r9 == null) goto L54;
        String r17 = r9.resourceId;
    L55:
        if (r9 == null) goto L59;
        ImageObj r18 = r9.imageOri;
        if (r18 == null) goto L59;
        String r19 = r18.url;
    L166:
        return new ai8.e(r4, r12, r14, r16, r17, r19, r26, r11, r27, r28, r23, r29, null, null, 24640);
    L59:
        r19 = null;
        goto L166
    L54:
        r17 = null;
    L51:
        r16 = null;
    L46:
        r14 = null;
        goto L47
    L41:
        r12 = null;
        goto L42
    L35:
        r10 = null;
        goto L36
    L31:
        r9 = null;
        goto L33
    L62:
        if (lr8.c.a(r22) == false) goto L72;
        NestedFileContent r20 = com.larus.bmhome.chat.bean.d.f(r22);
        List r21 = r20.getEntities();
        if (r21 == null) goto L69;
        Iterator r30 = r21.iterator();
    L67:
        if (r30.hasNext() == false) goto L69;
        ((UplinkFileEntity) r30.next()).setFileParsedStatus(Integer.valueOf(FileParseState.SUCCESS.getValue()));
    L69:
        r1 = new ai8.f(r20, r26, null, r11, r27, r28, r23, null, r29, null, 644);
        goto L167
    L72:
        if (r22.isNewBlockType() == false) goto L143;
        int r31 = c.a;
        Intrinsics.checkNotNullParameter(r22, "<this>");
        ReferenceInfo r110 = com.larus.bmhome.chat.bean.d.b1(r22);
        List r32 = r22.getContentBlock();
        if (r32 != null) goto L76;
        r32 = CollectionsKt.emptyList();
    L76:
        List r111 = r32;
        List r33 = r111;
        Iterator r34 = r33.iterator();
    L78:
        if (r34.hasNext() == false) goto L85;
        Object r35 = r34.next();
        if (((Block) r35).getBlockType() != BlockType.BLOCK_TYPE_TEXT.getValue()) goto L82;
        boolean r112 = true;
    L83:
        if (r112 == false) goto L78;
    L87:
        if (((Block) r35) == null) goto L111;
        FLogger.a.i("BlockWebCompat", "convert message content type 9999 to SendTextStrategy");
        if (r25 != null) goto L91;
        String r36 = com.larus.bmhome.chat.bean.d.H(r22);
        if (r36 == null) goto L110;
    L109:
        r4 = r36;
    L110:
        r1 = new ai8.h(r4, r26, null, r110, r27, r28, r23, r24, r29, null, 516);
        goto L167
    L91:
        if (StringsKt.isBlank(r25) == false) goto L145;
    L101:
        TextContent r37 = (TextContent) r5;
        if (r37 == null) goto L110;
        r36 = r37.text;
        if (r36 != null) goto L109;
    L145:
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L95
        Object r39 = Result.constructor-impl(HttpExtKt.f.fromJson(r25, TextContent.class));     // Catch: Throwable -> L95
    L98:
        if (Result.isFailure-impl(r39) == true) goto L101;
        r5 = r39;
    L95:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r39 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L98
    L111:
        Iterator r41 = r33.iterator();
    L113:
        if (r41.hasNext() == false) goto L120;
        BlockContent r42 = ((Block) r41.next()).getContent();
        if (r42 == null) goto L117;
        BizMergeForwardBlock r43 = r42.getBizMergeForwardBlock();
    L118:
        if (r43 == null) goto L113;
    L121:
        if (r43 == null) goto L123;
        FLogger.a.i("BlockWebCompat", "convert message content type 9999 to SendRawBlockStrategy");
        r1 = new ai8.g(r111, r43.getBrief(), r26, r27, r28, null, r29);
        goto L167
    L123:
        Iterator r44 = r33.iterator();
    L125:
        if (r44.hasNext() == false) goto L132;
        Object r45 = r44.next();
        if (((Block) r45).getBlockType() != BlockType.BLOCK_TYPE_ATTACHMENT.getValue()) goto L129;
        boolean r46 = true;
    L130:
        if (r46 == false) goto L125;
    L134:
        if (((Block) r45) == null) goto L142;
        FLogger.a.i("BlockWebCompat", "convert message content type 9999 to SendAttachmentStrategy");
        NestedFileContent r113 = com.larus.bmhome.chat.bean.d.f(r22);
        List r47 = r113.getEntities();
        if (r47 == null) goto L141;
        Iterator r48 = r47.iterator();
    L139:
        if (r48.hasNext() == false) goto L141;
        ((UplinkFileEntity) r48.next()).setFileParsedStatus(Integer.valueOf(FileParseState.SUCCESS.getValue()));
    L141:
        r1 = new ai8.f(r113, r26, null, r110, r27, r28, r23, null, r29, null, 644);
        goto L167
    L142:
        FLogger.a.e("BlockWebCompat", "convert message content type 9999 to strategy failed, supported block not found");
        t19.s r49 = t19.s.a;
        Application r50 = AppHost.a.getApplication();
        r49.getClass();
        t19.s.b(r50, 2131910343, false);
        return null;
    L129:
        r46 = false;
        goto L130
    L132:
        r45 = null;
        goto L134
    L117:
        r43 = null;
        goto L118
    L120:
        r43 = null;
        goto L121
    L82:
        r112 = false;
        goto L83
    L85:
        r35 = null;
        goto L87
    L143:
        FLogger.a.e("MessageRequestConverter", "unsupported content type: " + r22.getContentType());
        t19.s r51 = t19.s.a;
        Application r52 = AppHost.a.getApplication();
        r51.getClass();
        t19.s.b(r52, 2131910343, false);
        return null;
    }

    public static MessageRequestV2 n(d0 r124, String r125, List r126, String r127, String r128, String r129, int r130, Map r131, boolean r132, int r133) {
        if ((r133 & 4) == 0) goto L5;
        String r8 = null;
    L7:
        if ((r133 & 8) == 0) goto L9;
        String r9 = null;
    L11:
        if ((r133 & 16) == 0) goto L13;
        String r10 = null;
    L15:
        if ((r133 & 32) == 0) goto L17;
        int r2 = -1;
    L19:
        if ((r133 & 64) == 0) goto L21;
        Map r29 = null;
    L23:
        if ((r133 & 128) == 0) goto L25;
        boolean r30 = false;
    L26:
        r124.getClass();
        Intrinsics.checkNotNullParameter(r125, "conversationId");
        Intrinsics.checkNotNullParameter(r126, "strategies");
        ic8.w r6 = (ic8.w) CollectionsKt.first(r126);
        Map<String, String> r0 = r6.a();
        if (r0 == null) goto L30;
        Map r1 = MapsKt.toMutableMap(r0);
        if (r1 == null) goto L30;
    L31:
        Map r7 = r1;
        ic8.w r3 = (ic8.w) CollectionsKt.firstOrNull(r126);
        String r12 = "MessageRequestConverter";
        if ((r3 instanceof ai8.c) == true) goto L37;
        List r4 = r126;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r5 = r4.iterator();
    L35:
        if (r5.hasNext() == false) goto L62;
        r11.add(CollectionsKt.listOf((ic8.w) r5.next()));
    L62:
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r14 = r11.iterator();
    L64:
        if (r14.hasNext() == false) goto L232;
        List r15 = (List) r14.next();
        ic8.w r16 = (ic8.w) CollectionsKt.first(r15);
        List r17 = r15;
        ArrayList r18 = new ArrayList();
        Iterator r19 = r17.iterator();
    L67:
        if (r19.hasNext() == false) goto L177;
        ic8.w r20 = (ic8.w) r19.next();
        a.getClass();
        Iterator r1210 = r14;
        if ((r20 instanceof ai8.h) == false) goto L71;
    L155:
        String r49 = r8;
        String r48 = r9;
        String r31 = r10;
        r19 = r19;
        int r110 = BlockType.BLOCK_TYPE_TEXT.getValue();
        String r111 = UUID.randomUUID().toString();
        String r21 = r20.content();
        if (r21 != null) goto L158;
    L161:
        boolean r22 = true;
    L162:
        if (r22 == false) goto L257;
    L170:
        Object r23 = null;
    L171:
        TextContent r24 = (TextContent) r23;
        if (r24 == null) goto L174;
        String r25 = r24.text;
    L175:
        List<Block> r26 = CollectionsKt.listOf(new Block(r110, r111, null, new BlockContent(new TextBlock(r25, null, null, null, 0, 30, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, -1, 31, null), false, null, null, null, 244, null));
    L176:
        CollectionsKt.addAll(r18, r26);
        r14 = r1210;
        r19 = r19;
        r10 = r31;
        r9 = r48;
        r8 = r49;
        goto L67
    L174:
        r25 = null;
        goto L175
    L257:
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L166
        r23 = Result.constructor-impl(HttpExtKt.f.fromJson(r21, TextContent.class));     // Catch: Throwable -> L166
    L169:
        if (Result.isFailure-impl(r23) == false) goto L171;
    L166:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L169
    L158:
        if (StringsKt.isBlank(r21) == true) goto L161;
        r22 = false;
        goto L162
    L71:
        if ((r20 instanceof ai8.b) == true) goto L155;
        if ((r20 instanceof ai8.f) == false) goto L89;
        ai8.f r32 = (ai8.f) r20;
        NestedFileContent r33 = CreationNoWatermarkManager.a.b0(r32.a);
        if (r33 != null) goto L78;
        r33 = r32.a;
    L78:
        List r34 = r33.getEntities();
        if (r34 == null) goto L86;
        ArrayList r35 = new ArrayList();
        Iterator r36 = r34.iterator();
    L82:
        if (r36.hasNext() == false) goto L87;
        AttachmentItem r37 = ic8.h.a((UplinkFileEntity) r36.next());
        if (r37 == null) goto L82;
        r35.add(r37);
    L87:
        r26 = CollectionsKt.listOf(c(r35));
        r49 = r8;
        r48 = r9;
        r31 = r10;
        r19 = r19;
        goto L176
    L86:
        r35 = null;
        goto L87
    L89:
        if ((r20 instanceof ai8.e) == false) goto L144;
        String r38 = ((ai8.e) r20).content();
        if (r38 != null) goto L93;
    L96:
        boolean r39 = true;
    L97:
        if (r39 == false) goto L259;
    L105:
        Object r40 = null;
    L106:
        ImageContent r41 = (ImageContent) r40;
        if (r41 == null) goto L119;
        List r42 = r41.imageList;
        if (r42 == null) goto L119;
        List r43 = r42;
        ArrayList r44 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r43, 10));
        Iterator r45 = r43.iterator();
    L112:
        if (r45.hasNext() == false) goto L118;
        Image r46 = (Image) r45.next();
        Iterator r134 = r45;
        String r310 = r10;
        Image r47 = (Image) CreationNoWatermarkManager.a.S(r46, new String[]{r46.key, r46.identifier}).a;
        if (r47 == null) goto L117;
        r46 = r47;
    L117:
        r44.add(r46);
        r45 = r134;
        r10 = r310;
        goto L112
    L118:
        r31 = r10;
    L120:
        if (r44 == null) goto L142;
        ArrayList r50 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r44, 10));
        Iterator r51 = r44.iterator();
    L123:
        if (r51.hasNext() == false) goto L141;
        Image r112 = (Image) r51.next();
        Intrinsics.checkNotNullParameter(r112, "<this>");
        int r311 = AttachmentType.AttachmentTypeImage.getValue();
        String r52 = r112.identifier;
        Iterator r135 = r51;
        String r53 = r112.key;
        String r410 = r9;
        ImageObj r54 = r112.imageThumb;
        if (r54 == null) goto L127;
        ImageMeta r113 = ic8.h.c(r54);
    L128:
        ImageObj r55 = r112.imageOri;
        if (r55 == null) goto L131;
        ImageMeta r114 = ic8.h.c(r55);
    L132:
        ImageObj r56 = r112.previewImage;
        if (r56 == null) goto L135;
        ImageMeta r210 = ic8.h.c(r56);
    L136:
        String r57 = r112.md5;
        String r411 = r8;
        ImageObj r58 = r112.imageOriRaw;
        if (r58 == null) goto L139;
        ImageMeta r211 = ic8.h.c(r58);
    L140:
        r50.add(new AttachmentItem(r311, r52, new UploadImage(r53, r113, r114, r210, r57, r211, r112.aiCreationImage), null, null, null, null, 0, 0, 0, AttachmentItemUploadStatus.AttachmentItemUploadStatusSuccess.getValue(), null, null, 7160, null));
        r51 = r135;
        r9 = r410;
        r8 = r411;
        goto L123
    L139:
        r211 = null;
        goto L140
    L135:
        r210 = null;
        goto L136
    L131:
        r114 = null;
        goto L132
    L127:
        r113 = null;
        goto L128
    L141:
        r49 = r8;
        r48 = r9;
    L143:
        r26 = CollectionsKt.listOf(c(r50));
        goto L176
    L142:
        r49 = r8;
        r48 = r9;
        r50 = null;
    L119:
        r31 = r10;
        r44 = null;
        goto L120
    L259:
        Result.Companion r59 = Result.Companion;     // Catch: Throwable -> L101
        r40 = Result.constructor-impl(HttpExtKt.f.fromJson(r38, ImageContent.class));     // Catch: Throwable -> L101
    L104:
        if (Result.isFailure-impl(r40) == false) goto L106;
    L101:
        th = move-exception;
        Result.Companion r60 = Result.Companion;
        r40 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L104
    L93:
        if (StringsKt.isBlank(r38) == true) goto L96;
        r39 = false;
        goto L97
    L144:
        r49 = r8;
        r48 = r9;
        r31 = r10;
        r19 = r19;
        if ((r20 instanceof ai8.c) == false) goto L151;
        int r115 = BlockType.BLOCK_TYPE_BIZ_MERGE_FORWARD.getValue();
        ai8.c r61 = (ai8.c) r20;
        String r62 = r61.e;
        if (r62 != null) goto L149;
        r62 = UUID.randomUUID().toString();
    L149:
        r26 = CollectionsKt.listOf(new Block(r115, r62, null, new BlockContent(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new BizMergeForwardBlock(r61.a, Integer.valueOf(r61.b), r61.c, Long.valueOf(r61.d), null, null, null, null, 240, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1048577, 31, null), true, null, null, null, 228, null));
        goto L176
    L151:
        if ((r20 instanceof ai8.g) == false) goto L154;
        r26 = ((ai8.g) r20).a;
        goto L176
    L154:
        FLogger.a.e(r12, "unsupported send message strategy: " + r20);
        t19.s r63 = t19.s.a;
        Application r64 = AppHost.a.getApplication();
        r63.getClass();
        t19.s.b(r64, 2131910343, false);
        r26 = CollectionsKt.emptyList();
        goto L176
    L177:
        Iterator r1211 = r14;
        String r412 = r8;
        String r413 = r9;
        String r312 = r10;
        List r65 = CollectionsKt.toMutableList(r18);
        d0 r66 = a;
        ReferenceInfo r67 = r16.T6();
        String r116 = (String) r7.get("reference_text");
        r66.getClass();
        if (r67 == null) goto L193;
        int r117 = BlockType.BLOCK_TYPE_REFERENCE.getValue();
        String r118 = UUID.randomUUID().toString();
        String r119 = r67.displayContent;
        String r120 = r67.referencedMessageId;
        Map r121 = r67.ext;
        if (r121 == null) goto L182;
        String r68 = (String) r121.get("ref_icon_key");
    L183:
        ReferenceText r69 = new ReferenceText(r119, r120, r68);
        Map r122 = r67.ext;
        if (r122 == null) goto L186;
        String r123 = (String) r122.get("ref_msg_is_self");
    L187:
        Map r136 = r67.ext;
        if (r136 == null) goto L190;
        String r137 = (String) r136.get("deep_research_phase");
    L191:
        r65.add(new Block(r117, r118, null, new BlockContent(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new ReferenceBlock(6, r67.referencedMessageId, r67.getReplyId(), r69, new ReferenceTextOption(r123, r137)), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -268435457, -1, 31, null), false, null, null, null, 244, null));
    L195:
        LinkedHashMap r70 = new LinkedHashMap();
        Iterator r71 = r17.iterator();
    L197:
        if (r71.hasNext() == false) goto L205;
        ic8.w r72 = (ic8.w) r71.next();
        Map<String, String> r73 = r72.f();
        if (r73 == null) goto L201;
        r70.putAll(r73);
    L201:
        Pair<String, String> r74 = r72.h();
        if (r74 == null) goto L197;
        r70.put(r74.getFirst(), r74.getSecond());
        goto L197
    L205:
        if ((!r70.isEmpty()) == false) goto L207;
        LinkedHashMap r138 = r70;
    L208:
        String r75 = r16.b();
        ReferenceInfo r139 = r16.T6();
        MessageStatus r76 = r16.i();
        if (r76 == null) goto L211;
        int r77 = r76.value;
    L212:
        int r212 = r77;
        Integer r78 = Integer.valueOf(r16.contentType());
        Map<String, String> r140 = r16.a();
        if (r140 == null) goto L215;
        String r141 = r140.get("send_message_scene");
    L216:
        MessageSpecificExtra r79 = new MessageSpecificExtra(r78, r141, r16.e());
        String r142 = AccountService.a.getUserId();
        if ((r16 instanceof ai8.c) == false) goto L220;
        String r80 = ((ai8.c) r16).c;
    L222:
        String r213 = r80;
    L225:
        if ((r16 instanceof ai8.b) == false) goto L227;
    L230:
        boolean r81 = true;
    L231:
        r13.add(new RequestMessage(r75, r65, null, r138, r142, 1, Boolean.valueOf(r81), r139, r16.g(), null, null, r213, r2, r212, r79, 1540, null));
        r14 = r1211;
        r12 = r12;
        r10 = r312;
        r9 = r413;
        r8 = r412;
        goto L64
    L227:
        if ((r16 instanceof ai8.a) == true) goto L230;
        r81 = false;
        goto L231
    L220:
        if ((r16 instanceof ai8.g) == false) goto L223;
        r80 = ((ai8.g) r16).b;
        goto L222
    L223:
        r213 = null;
        goto L225
    L215:
        r141 = null;
        goto L216
    L211:
        r77 = MessageStatus.MessageStatus_AVAILABLE.value;
        goto L212
    L207:
        r138 = null;
        goto L208
    L190:
        r137 = null;
        goto L191
    L186:
        r123 = null;
        goto L187
    L182:
        r68 = null;
        goto L183
    L193:
        if (o0.d(r116) == false) goto L195;
        r65.add(new Block(BlockType.BLOCK_TYPE_REFERENCE.getValue(), UUID.randomUUID().toString(), null, new BlockContent(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new ReferenceBlock(6, null, null, new ReferenceText(r116, null, null, 4, null), null, 6, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -268435457, -1, 31, null), false, null, null, null, 244, null));
        goto L195
    L232:
        String r414 = r8;
        String r415 = r9;
        String r313 = r10;
        List r82 = r126;
        if ((r82 instanceof Collection) == true) goto L235;
    L237:
        Iterator r83 = r82.iterator();
    L239:
        if (r83.hasNext() == false) goto L248;
        ic8.w r84 = (ic8.w) r83.next();
        if ((r84 instanceof ai8.h) == true) goto L243;
    L245:
        boolean r143 = false;
    L246:
        if (r143 == false) goto L239;
        boolean r144 = true;
    L249:
        MessageRequestType r85 = r6.d();
        ChatPageContext r145 = r6.N();
        ReferenceInfo r86 = r6.T6();
        if (r86 == null) goto L254;
        Map r87 = r86.ext;
        if (r87 == null) goto L254;
        String r146 = (String) r87.get("general_task_param");
    L256:
        return e(r85, r125, r13, r7, r414, r415, r313, r144, r146, r145, r29, r30);
    L254:
        r146 = null;
        goto L256
    L243:
        if (((ai8.h) r84).h == false) goto L245;
        r143 = true;
    L248:
        r144 = false;
        goto L249
    L235:
        if (r82.isEmpty() == false) goto L237;
    L37:
        List r147 = r126;
        List r148 = CollectionsKt.drop(r147, 1);
        ArrayList r88 = new ArrayList();
        Iterator r149 = r148.iterator();
    L39:
        if (r149.hasNext() == false) goto L51;
        Object r89 = r149.next();
        ic8.w r150 = (ic8.w) r89;
        if ((r150 instanceof ai8.f) == false) goto L43;
    L46:
        boolean r151 = true;
    L47:
        if (r151 == false) goto L51;
        r88.add(r89);
        goto L39
    L43:
        if ((r150 instanceof ai8.e) == true) goto L46;
        r151 = false;
    L51:
        if (r88.isEmpty() == false) goto L57;
        ArrayList r90 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r147, 10));
        Iterator r91 = r147.iterator();
    L54:
        if (r91.hasNext() == false) goto L56;
        r90.add(CollectionsKt.listOf((ic8.w) r91.next()));
        goto L54
    L56:
        r11 = r90;
        goto L62
    L57:
        FLogger.a.i("MessageRequestConverter", "combine human merge forward attachments, attachmentSize=" + r88.size());
        ArrayList r92 = new ArrayList();
        r92.add(CollectionsKt.plus(CollectionsKt.listOf(r3), r88));
        Iterator r93 = CollectionsKt.drop(r147, r88.size() + 1).iterator();
    L59:
        if (r93.hasNext() == false) goto L61;
        r92.add(CollectionsKt.listOf((ic8.w) r93.next()));
        goto L59
    L61:
        r11 = r92;
    L30:
        r1 = new LinkedHashMap();
        goto L31
    L25:
        r30 = r132;
        goto L26
    L21:
        r29 = r131;
        goto L23
    L17:
        r2 = r130;
        goto L19
    L13:
        r10 = r129;
        goto L15
    L9:
        r9 = r128;
        goto L11
    L5:
        r8 = r127;
        goto L7
    }

    public static MessageRequestV2 e(MessageRequestType r91, String r92, final List r93, Map r94, String r95, String r96, String r97, boolean r99, String r910, ChatPageContext r100, Map r101, boolean r102) {
        ClientMeta r3 = new ClientMeta(r96, r92, r95, null, null, null, ClientMetaPermissionHelper.a(r102), r97, null, 0, 824, null);
        String r0 = (String) r94.remove("edit_query_id");
        if (r0 != null) goto L5;
    L13:
        List r21 = null;
    L14:
        String r1 = (String) r94.get("general_task_param");
        if (r1 != null) goto L17;
    L24:
        if (r910 != null) goto L26;
    L31:
        r1 = null;
    L32:
        if (r1 == null) goto L48;
        zd9.h.a.getClass();
        GeneralTaskParam r22 = (GeneralTaskParam) zd9.h.a(r1, GeneralTaskParam.class);
        if (r22 == null) goto L41;
        Integer r2 = r22.getAction();
        if (r2 == null) goto L41;
        if (r2.intValue() != 1) goto L41;
        boolean r4 = true;
    L42:
        if (r4 == false) goto L49;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r93, 10));
        Iterator r9 = r93.iterator();
    L45:
        if (r9.hasNext() == false) goto L47;
        RequestMessage r10 = (RequestMessage) r9.next();
        r5.add(wf9.b.a());
        goto L45
    L47:
        r22 = GeneralTaskParam.copy$default(r22, null, null, null, r5, null, null, null, null, null, null, null, null, null, false, null, null, 65527, null);
    L49:
        com.larus.bmhome.instruction.c r6 = com.larus.bmhome.instruction.c.a;
        if (r95 != null) goto L52;
        String r11 = "";
    L53:
        ReplyOption r12 = r6.a(r11, ActiveSwitchType.DEEPTHINK.getValue());
        ModelItemIdentity r13 = r12.getModel();
        if (r22 != null) goto L58;
        Object r7 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
        if (com.larus.bmhome.view.actionbar.custom.cache.e.i(r12) == false) goto L58;
        r22 = new GeneralTaskParam(null, null, null, null, 1, null, null, null, null, null, null, null, null, false, null, null, 65519, null);
    L58:
        String r8 = (String) r94.get("task_skill_local_temp_runtime_type");
        if (r8 == null) goto L61;
        Integer r14 = StringsKt.toIntOrNull(r8);
    L713:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L82
        String r16 = (String) r94.get("task_skill_local_temp_selected_skills");     // Catch: Throwable -> L82
        if (r16 != null) goto L65;
    L79:
        List r17 = null;
    L80:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L82
    L85:
        if (Result.isFailure-impl(r18) == false) goto L87;
        r18 = null;
    L87:
        List r19 = (List) r18;
        List r110 = k((String) r94.get("task_skill_local_temp_local_selected_skills"));
        String r111 = (String) r94.get("task_skill_local_temp_client_options");
        if (r111 != null) goto L90;
    L98:
        ClientOption r112 = null;
    L99:
        String r113 = (String) r94.get("task_workspace");
        if (r113 != null) goto L102;
    L104:
        r113 = null;
    L105:
        String r114 = (String) r94.get("task_sandbox_auth_type");
        if (r114 == null) goto L116;
        Integer r115 = StringsKt.toIntOrNull(r114);
        if (r115 == null) goto L116;
        int r20 = r115.intValue();
        if (r20 < 0) goto L113;
        if (r20 >= 3) goto L113;
        boolean r23 = true;
    L114:
        if (r23 == false) goto L116;
    L117:
        boolean r24 = Intrinsics.areEqual(r94.remove("task_sandbox_auth_type_changed"), "1");
        String r25 = (String) r94.get("dispatch_controller_mobile_did");
        if (r25 == null) goto L123;
        if ((!StringsKt.isBlank(r25)) == false) goto L123;
    L124:
        String r26 = (String) r94.get("dispatch_controller_mobile_platform");
        if (r26 != null) goto L127;
    L129:
        r26 = null;
    L130:
        if (r14 != null) goto L170;
        List r116 = r19;
        if (r116 != null) goto L134;
    L137:
        boolean r117 = true;
    L138:
        if (r117 == false) goto L170;
        List r118 = r110;
        if (r118 != null) goto L142;
    L145:
        boolean r119 = true;
    L146:
        if (r119 == false) goto L170;
        if (r112 != null) goto L170;
        if (r113 != null) goto L150;
    L153:
        boolean r120 = true;
    L154:
        if (r120 == false) goto L170;
        if (r115 != null) goto L170;
        if (r25 != null) goto L158;
    L161:
        boolean r121 = true;
    L162:
        if (r121 == false) goto L170;
        if (r26 != null) goto L165;
    L168:
        boolean r122 = true;
    L169:
        if (r122 == false) goto L170;
    L213:
        String r39 = (String) r94.remove("task_project_id");
        if (r39 == null) goto L218;
        if (r22 != null) goto L217;
        r22 = new GeneralTaskParam(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, 65535, null);
    L217:
        r22 = GeneralTaskParam.copy$default(r22, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, r39, 32767, null);
    L218:
        String r27 = (String) r94.get("task_skill_local_temp_agent_task_param_change");
        if (r27 != null) goto L221;
    L226:
        GeneralTaskParam r28 = null;
    L227:
        if (r28 == null) goto L236;
        AgentTaskParam r29 = r28.getAgentTaskParam();
        if (r29 == null) goto L236;
        Integer r30 = r29.getRuntimeType();
        if (r30 == null) goto L236;
        if (r30.intValue() != 1) goto L236;
        boolean r31 = true;
    L237:
        if (r31 == true) goto L239;
    L241:
        boolean r32 = false;
    L242:
        if (r28 == null) goto L262;
        Object r123 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
        if (com.larus.bmhome.view.actionbar.custom.cache.e.i(r12) == true) goto L246;
        if (r32 == false) goto L262;
    L246:
        AgentTaskParam r33 = r28.getAgentTaskParam();
        AgentTaskParamChange r124 = r28.getAgentTaskParamChange();
        if (r22 != null) goto L249;
        GeneralTaskParam r53 = new GeneralTaskParam(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, 65535, null);
    L250:
        boolean r67 = r28.getNeedModifyConversation();
        if (r33 != null) goto L255;
        if (r22 == null) goto L254;
        r33 = r22.getAgentTaskParam();
        goto L255
    L254:
        AgentTaskParam r68 = null;
    L256:
        if (r124 != null) goto L260;
        if (r22 == null) goto L259;
        r124 = r22.getAgentTaskParamChange();
        goto L260
    L259:
        AgentTaskParamChange r66 = null;
    L261:
        r22 = GeneralTaskParam.copy$default(r53, null, null, null, null, null, null, null, null, null, null, null, null, r66, r67, r68, null, 36863, null);
    L260:
        r66 = r124;
    L255:
        r68 = r33;
        goto L256
    L249:
        r53 = r22;
    L262:
        GeneralTaskParam r210 = r22;
        r94.remove("task_skill_local_temp_agent_task_param_change");
        if (r210 == null) goto L282;
        AgentTaskParam r34 = r210.getAgentTaskParam();
        if (r34 == null) goto L282;
        Integer r35 = r34.getSandboxAuthType();
        if (r35 == null) goto L282;
        int r36 = r35.intValue();
        if (r36 >= 0) goto L271;
    L273:
        boolean r37 = false;
    L274:
        if (r37 == true) goto L277;
        r35 = null;
    L277:
        if (r35 == null) goto L282;
        int r38 = r35.intValue();
        ClientOption r40 = r210.getClientOption();
        if (r40 != null) goto L281;
        r40 = new ClientOption(null, false, null, null, null, null, null, null, null, 511, null);
    L281:
        r210 = GeneralTaskParam.copy$default(r210, null, null, null, null, null, ClientOption.copy$default(r40, null, false, null, null, null, null, Integer.valueOf(r38), null, null, 447, null), null, null, null, null, null, null, null, false, null, null, 65503, null);
        Unit r41 = Unit.INSTANCE;
        goto L282
    L271:
        if (r36 >= 3) goto L273;
        r37 = true;
    L282:
        if (r24 == false) goto L290;
        if (r210 == null) goto L286;
        AgentTaskParamChange r42 = r210.getAgentTaskParamChange();
        if (r42 == null) goto L286;
    L287:
        if (r210 != null) goto L289;
        r210 = new GeneralTaskParam(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, 65535, null);
    L289:
        GeneralTaskParam r310 = GeneralTaskParam.copy$default(r210, null, null, null, null, null, null, null, null, null, null, null, null, r42.copy(r42.getRuntimeChanged(), r42.getDeviceChanged(), true), false, null, null, 61439, null);
    L292:
        if (r310 == null) goto L342;
        JSONObject r43 = new JSONObject();
        String r44 = r310.getProjectId();
        if (r44 == null) goto L296;
        r43.put("project_id", r44);
    L296:
        r43.put("need_modify_conversation", r310.getNeedModifyConversation());
        Integer r45 = r310.getAction();
        if (r45 == null) goto L299;
        r43.put("action", r45.intValue());
    L299:
        Integer r46 = r310.getSourceType();
        if (r46 == null) goto L302;
        r43.put("source_type", r46.intValue());
    L302:
        String r47 = r310.getTaskId();
        if (r47 == null) goto L305;
        r43.put("task_id", r47);
    L305:
        List r48 = r310.getThreadLocalMessageIds();
        if (r48 == null) goto L308;
        r43.put("thread_local_message_id", r48);
    L308:
        String r49 = r310.getThreadId();
        if (r49 == null) goto L311;
        r43.put("thread_id", r49);
    L311:
        String r50 = r310.getDispatchControllerAppid();
        if (r50 == null) goto L314;
        r43.put("dispatch_controller_appid", r50);
    L314:
        AgentTaskParam r51 = r310.getAgentTaskParam();
        if (r51 == null) goto L338;
        JSONObject r52 = new JSONObject();
        Integer r125 = r51.getRuntimeType();
        if (r125 == null) goto L319;
        r52.put("runtime_type", r125.intValue());
    L319:
        String r126 = r51.getDeviceName();
        if (r126 == null) goto L322;
        r52.put("device_name", r126);
    L322:
        String r127 = r51.getFolderName();
        if (r127 == null) goto L325;
        r52.put("folder_name", r127);
    L325:
        String r128 = r51.getWorkspace();
        if (r128 == null) goto L328;
        r52.put("workspace", r128);
    L328:
        String r129 = r51.getLocalDeviceId();
        if (r129 == null) goto L331;
        r52.put("local_device_id", r129);
    L331:
        String r130 = r51.getLocalAppId();
        if (r130 == null) goto L334;
        r52.put("local_app_id", r130);
    L334:
        Integer r54 = r51.getSandboxAuthType();
        if (r54 == null) goto L337;
        r52.put("sandbox_auth_type", r54.intValue());
        Unit r55 = Unit.INSTANCE;
    L337:
        Unit r56 = Unit.INSTANCE;
        r43.put("agent_task_param", r52);
    L338:
        AgentTaskParamChange r57 = r310.getAgentTaskParamChange();
        if (r57 == null) goto L341;
        JSONObject r58 = new JSONObject();
        r58.put("runtime_changed", r57.getRuntimeChanged());
        r58.put("device_changed", r57.getDeviceChanged());
        r58.put("sandbox_auth_type_changed", r57.getSandboxAuthTypeChanged());
        Unit r59 = Unit.INSTANCE;
        r43.put("agent_task_param_change", r58);
    L341:
        r94.put("general_task_param", r43.toString());
    L342:
        String r60 = (String) r94.get("applet_follow_up_data");
        if (r60 == null) goto L345;
        r94.remove("applet_follow_up_data");
        String r311 = r60;
    L347:
        if (TextUtils.isEmpty((CharSequence) r94.get("conversation_init_option")) == false) goto L349;
        ConversationInitOption r61 = null;
    L350:
        String r62 = (String) r94.get("project_id");
        if (r62 != null) goto L353;
    L358:
        String r211 = null;
    L359:
        if (r211 != null) goto L361;
        ConversationInitOption r312 = r61;
    L364:
        if (r100 == null) goto L366;
        Map<String, String> r63 = r100.getBizExt();
    L367:
        if (r63 != null) goto L369;
        r63 = MapsKt.emptyMap();
    L369:
        Map r64 = MapsKt.toMutableMap(r63);
        String r65 = r13.getKey();
        if (r65 != null) goto L372;
        r65 = "";
    L372:
        r64.put("model_item_key", r65);
        Object r69 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
        r64.put("provider_id", com.larus.bmhome.view.actionbar.custom.cache.e.g(r13));
        String r70 = r12.getModeId();
        if (r70 != null) goto L375;
        r70 = "";
    L375:
        r64.put("mode_id", r70);
        Integer r71 = r12.getReasoningEffort();
        if (r71 == null) goto L379;
        String r72 = r71.toString();
        if (r72 == null) goto L379;
    L380:
        r64.put("reasoning_effort", r72);
        if (r100 == null) goto L394;
        String r73 = r100.getConversationMode();
        if (r73 == null) goto L394;
        if (r73.length() <= 0) goto L387;
        boolean r131 = true;
    L388:
        if (r131 == true) goto L391;
        r73 = null;
    L391:
        if (r73 == null) goto L394;
        String r74 = (String) r64.put("conversation_mode", r73);
        goto L394
    L387:
        r131 = false;
    L394:
        if (com.larus.bmhome.view.actionbar.custom.cache.e.i(r12) == true) goto L396;
    L400:
        String r75 = (String) r94.get("send_message_scene");
        String r76 = (String) r94.get("create_time_ms");
        if (r76 == null) goto L405;
        Long r77 = StringsKt.toLongOrNull(r76);
        if (r77 == null) goto L405;
        long r78 = r77.longValue();
    L406:
        String r132 = (String) r94.get("collection_id");
        boolean r133 = Intrinsics.areEqual(r94.get("is_audio"), "true");
        boolean r134 = Intrinsics.areEqual(r94.get("answer_with_suggest"), "1");
        String r79 = (String) r94.remove("o_force_agent_mode");
        if (r79 == null) goto L411;
        Integer r80 = StringsKt.toIntOrNull(r79);
        if (r80 == null) goto L411;
        int r81 = r80.intValue();
    L412:
        int r212 = r81;
        String r213 = r12.getModeId();
        boolean r313 = Intrinsics.areEqual(r94.get("tts"), "1");
        String r82 = (String) r94.get("need_deep_think");
        if (r82 == null) goto L417;
        Integer r83 = StringsKt.toIntOrNull(r82);
        if (r83 == null) goto L417;
        int r314 = r83.intValue();
    L418:
        ModelConfig r84 = new ModelConfig(r13.getKey(), com.larus.bmhome.view.actionbar.custom.cache.e.f(r13), r12.getReasoningEffort());
        boolean r85 = Intrinsics.areEqual(r94.get("from_suggest"), "1");
        boolean r315 = Intrinsics.areEqual(r94.get("click_clear_context"), "true");
        String r316 = (String) r94.get("select_text_action");
        String r317 = (String) r94.get("prompt_modification");
        ConversationInitExt r410 = h(r94, r12, r13);
        String r86 = (String) r94.get("pocket_map");
        if (r86 != null) goto L421;
    L431:
        Object r87 = null;
    L433:
        if ((r87 instanceof String) == false) goto L435;
        String r88 = (String) r87;
    L436:
        if (r88 == null) goto L438;
        zd9.h.a.getClass();
        ChatLite r411 = (ChatLite) zd9.h.a(r88, ChatLite.class);
    L439:
        String r89 = (String) r94.get("permission_interact");
        if (r89 == null) goto L444;
        Integer r90 = StringsKt.toIntOrNull(r89);
        if (r90 == null) goto L444;
        int r103 = r90.intValue();
    L445:
        String r135 = (String) r94.get("is_from_click_option");
        if (r135 == null) goto L450;
        Boolean r136 = StringsKt.toBooleanStrictOrNull(r135);
        if (r136 == null) goto L450;
        boolean r412 = r136.booleanValue();
    L451:
        String r137 = (String) r94.get("is_from_click_softlink");
        if (r137 == null) goto L456;
        Boolean r138 = StringsKt.toBooleanStrictOrNull(r137);
        if (r138 == null) goto L456;
        boolean r413 = r138.booleanValue();
    L457:
        String r139 = (String) r94.get("bubble_resend_local_temp_upgrade_ext");
        if (r139 == null) goto L466;
        if ((!StringsKt.isBlank(r139)) == true) goto L463;
        r139 = null;
    L463:
        if (r139 == null) goto L466;
        Map r414 = com.flow.kmp.common.util.k.d(r139);
    L467:
        String r140 = (String) r94.get("chat_entry_source");
        if (r140 == null) goto L472;
        Integer r141 = StringsKt.toIntOrNull(r140);
        if (r141 == null) goto L472;
        int r142 = r141.intValue();
    L473:
        int r143 = r142;
        boolean r144 = i(r94, "is_first_open_in_source_page");
        boolean r145 = i(r94, "is_chat_flow_collapsed");
        String r146 = (String) r94.get("origin_message_id");
        if (r146 != null) goto L476;
    L481:
        String r147 = null;
    L482:
        ChatEntryOption r415 = new ChatEntryOption(r143, r144, r145, r147, r64);
        String r148 = (String) r94.get("biz_task_id");
        if (r148 != null) goto L485;
    L490:
        String r416 = null;
    L491:
        String r149 = (String) r94.get("miniapp_appkey");
        if (r149 != null) goto L494;
    L499:
        String r417 = null;
    L500:
        ChatQueryOption r150 = new ChatQueryOption(r75, r78, r132, r133, r134, Integer.valueOf(r212), r213, r313, r314, r85, r315, r21, false, null, false, null, null, r99, false, 0, 0, r316, r317, r312, r410, r411, r310, Integer.valueOf(r103), r412, r311, null, r413, r414, r84, r101, r415, r416, r417, r64, 1075703808, 0, null);
        List r104 = d(l(r94, "delivery_address"));
        if (r94.get("action_bar_key") == null) goto L503;
    L538:
        String r105 = (String) r94.get("action_bar_key");
        if (r105 != null) goto L541;
        r105 = "coco_instruction";
    L541:
        String r106 = (String) r94.get(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION);
        if (r106 != null) goto L715;
        r106 = "";
    L715:
        com.larus.bmhome.actionbar.model.r r107 = (com.larus.bmhome.actionbar.model.r) xt7.d.b().c(com.larus.bmhome.actionbar.model.r.Companion.serializer(), r106);     // Catch: Exception -> L547
        Integer r108 = r107.d();     // Catch: Exception -> L710
    L549:
        if (r108 == null) goto L551;
        int r109 = r108.intValue();
    L552:
        if (r109 == 0) goto L584;
        switch(r109) {
            case 1: goto L582;
            case 2: goto L581;
            case 3: goto L580;
            case 4: goto L579;
            case 5: goto L578;
            case 6: goto L577;
            case 7: goto L576;
            case 8: goto L575;
            case 9: goto L574;
            case 10: goto L554;
            case 11: goto L573;
            case 12: goto L572;
            case 13: goto L571;
            case 14: goto L570;
            case 15: goto L569;
            case 16: goto L568;
            case 17: goto L554;
            case 18: goto L567;
            case 19: goto L566;
            case 20: goto L565;
            case 21: goto L564;
            case 22: goto L563;
            case 23: goto L562;
            case 24: goto L561;
            case 25: goto L560;
            case 26: goto L554;
            case 27: goto L559;
            case 28: goto L558;
            case 29: goto L557;
            case 30: goto L556;
            case 31: goto L554;
            case 32: goto L554;
            case 33: goto L554;
            case 34: goto L555;
            default: goto L554;
        };
    L554:
        ChatAbilityType r151 = ChatAbilityType.ChatAbilityType_Unknown;
    L663:
        if (r151 != ChatAbilityType.SKILL_PPT_GENERATION) goto L673;
        if (r107 == null) goto L671;
        List<com.larus.bmhome.actionbar.model.u> r152 = r107.c();
        if (r152 == null) goto L671;
        com.larus.bmhome.actionbar.model.u r153 = (com.larus.bmhome.actionbar.model.u) CollectionsKt.firstOrNull(r152);
        if (r153 == null) goto L671;
        String r154 = r153.c();
        if (r154 == null) goto L671;
    L672:
        String r155 = j(r154, new b0(r93));
    L674:
        FLogger.a.d("MessageRequestConverter", "get chatAbility type=" + r151.getValue() + ", params=" + r155);
        ChatAbility r156 = new ChatAbility(r151.getValue(), r155);
    L534:
        ChatAbility r157 = r156;
    L675:
        List r158 = CollectionsKt.listOf(new String[]{"action_bar_key", "action_bar_instruction_type", ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION, "suggested_chat_ability", "chat_entry_source", "is_first_open_in_source_page", "is_chat_flow_collapsed", "biz_task_id", "miniapp_appkey", "task_skill_local_temp_runtime_type", "task_skill_local_temp_selected_skills", "task_skill_local_temp_local_selected_skills", "task_skill_local_temp_client_options", "bubble_resend_local_temp_upgrade_ext", "dispatch_controller_mobile_did", "dispatch_controller_mobile_platform", "task_workspace", "task_sandbox_auth_type", "task_sandbox_auth_type_changed", "target_device_id", "target_app_id", "send_command", "select_project_id"});
        if (r157 != null) goto L681;
        String r159 = (String) r94.get("suggested_chat_ability");
        if (o0.d(r159) == false) goto L680;
        r157 = (ChatAbility) GsonProtectorUtils.fromJson(new Gson(), r159, ChatAbility.class);
    L680:
        Unit r160 = Unit.INSTANCE;
    L682:
        ChatAbility r161 = r157;
        UserContext r162 = f(ContextType.ContextType_Resource, l(r94, "office_resource_context"));
        if (r162 == null) goto L685;
        List r163 = CollectionsKt.listOf(r162);
    L686:
        List r164 = b(r104, r163);
        UserContext r165 = f(ContextType.ContextType_Base, l(r94, "office_base_context"));
        if (r165 == null) goto L689;
        List r166 = CollectionsKt.listOf(r165);
    L690:
        List r167 = b(r164, r166);
        if (r100 == null) goto L693;
        List<GuiContext> r168 = r100.getGuiContext();
    L694:
        List r169 = a(r167, r168);
        FLogger.a.i("MessageRequestConverter", "NHY DEBUG sendMessage chatQueryOption: " + r150);
        List r170 = g(r169, r100);
        LruCache r171 = CommonParamManager.a;
        ArrayList r172 = new ArrayList();
        Iterator r173 = r93.iterator();
    L696:
        if (r173.hasNext() == false) goto L709;
        String r174 = ((RequestMessage) r173.next()).getLocalMessageId();
        if (r174 != null) goto L700;
    L705:
        r174 = null;
    L706:
        if (r174 == null) goto L696;
        r172.add(r174);
        goto L696
    L700:
        if (r174.length() <= 0) goto L702;
        boolean r175 = true;
    L703:
        if (r175 == false) goto L705;
    L702:
        r175 = false;
        goto L703
    L709:
        return new MessageRequestV2(r91, r3, r93, r150, r161, r94, r158, r170, CommonParamManager.a(r172, r150.getAgentMode(), r150.getSendMessageScene()));
    L693:
        r168 = null;
        goto L694
    L689:
        r166 = null;
        goto L690
    L685:
        r163 = null;
        goto L686
    L681:
        r94.remove("suggested_chat_ability");
    L671:
        r154 = "";
        goto L672
    L673:
        ChatAbilityActionBar r176 = new ChatAbilityActionBar(r105, r109, r106);
        ChatSendUtils.a.getClass();
        r155 = GsonProtectorUtils.toJson(ChatSendUtils.n(), r176);
        goto L674
    L555:
        r151 = ChatAbilityType.SKILL_SHEET_GENERATION;
        goto L663
    L556:
        r151 = ChatAbilityType.SKILL_PPT_GENERATION;
        goto L663
    L557:
        r151 = ChatAbilityType.SKILL_HOMEWORK_CORRECTION;
        goto L663
    L558:
        r151 = ChatAbilityType.SKILL_CREATION_MERGE;
        goto L663
    L559:
        r151 = ChatAbilityType.SKILL_AI_PODCAST_NEW;
        goto L663
    L560:
        r151 = ChatAbilityType.SKILL_RECORD;
        goto L663
    L561:
        r151 = ChatAbilityType.SKILL_PHOTO_ANIMATION;
        goto L663
    L562:
        r151 = ChatAbilityType.SKILL_COLLEGE_ENTRANCE_EXAM;
        goto L663
    L563:
        r151 = ChatAbilityType.SKILL_VIDEO_UNDERSTANDING;
        goto L663
    L564:
        r151 = ChatAbilityType.SKILL_IN_DEPTH_RESEARCH;
        goto L663
    L565:
        r151 = ChatAbilityType.SKILL_HEALTH_CONSULTATION_NEW;
        goto L663
    L566:
        r151 = ChatAbilityType.SKILL_CONTINUOUS_VOICE;
        goto L663
    L567:
        r151 = ChatAbilityType.SKILL_VIDEO_GENERATION;
        goto L663
    L568:
        r151 = ChatAbilityType.SKILL_AI_IMAGE_EDITING;
        goto L663
    L569:
        r151 = ChatAbilityType.SKILL_REMINDER_FIRST;
        goto L663
    L570:
        r151 = ChatAbilityType.SKILL_HEALTH_CONSULTATION;
        goto L663
    L571:
        r151 = ChatAbilityType.SKILL_ORAL_CALCULATION_CORRECTION;
        goto L663
    L572:
        r151 = ChatAbilityType.SKILL_COMPOSITION_CORRECTION;
        goto L663
    L573:
        r151 = ChatAbilityType.SKILL_AI_PHOTO;
        goto L663
    L574:
        r151 = ChatAbilityType.SKILL_WEB_PAGE_READING;
        goto L663
    L575:
        r151 = ChatAbilityType.SKILL_DOCUMENT_READING;
        goto L663
    L576:
        r151 = ChatAbilityType.SKILL_PROBLEM_SOLVING;
        goto L663
    L577:
        r151 = ChatAbilityType.SKILL_SEARCH;
        goto L663
    L578:
        r151 = ChatAbilityType.SKILL_TRANSLATION;
        goto L663
    L579:
        r151 = ChatAbilityType.SKILL_IMAGE_GENERATION;
        goto L663
    L580:
        r151 = ChatAbilityType.SKILL_REPLY_ASSISTANCE;
        goto L663
    L581:
        r151 = ChatAbilityType.SKILL_WRITING_ASSISTANCE;
        goto L663
    L582:
        r151 = ChatAbilityType.SKILL_MUSIC_GENERATION;
        goto L663
    L584:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_CALL.getKey()) == false) goto L587;
        r151 = ChatAbilityType.SKILL_CALL;
        goto L663
    L587:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_NEWS_ACTIONBAR_NAME.getKey()) == false) goto L590;
        r151 = ChatAbilityType.SKILL_NEWS_ACTIONBAR_NAME;
        goto L663
    L590:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_HEALTH_CONSULTATION.getKey()) == false) goto L593;
        r151 = ChatAbilityType.SKILL_HEALTH_CONSULTATION;
        goto L663
    L593:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_MUSIC_RANDOM_PLAY.getKey()) == false) goto L596;
        r151 = ChatAbilityType.SKILL_MUSIC_RANDOM_PLAY;
        goto L663
    L596:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_RECORD.getKey()) == false) goto L599;
        r151 = ChatAbilityType.SKILL_RECORD;
        goto L663
    L599:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_AI_SIMUL_INTERPRET.getKey()) == false) goto L602;
        r151 = ChatAbilityType.SKILL_SIMULTANEOUS_INTERPRETATION;
        goto L663
    L602:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_CALL_ENGLISH_LEARNING.getKey()) == false) goto L605;
        r151 = ChatAbilityType.SKILL_CALL_ENGLISH_LEARNING;
        goto L663
    L605:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_CALL_IDIOM.getKey()) == false) goto L608;
        r151 = ChatAbilityType.SKILL_CALL_IDIOM;
        goto L663
    L608:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_CALL_INTERVIEW.getKey()) == false) goto L611;
        r151 = ChatAbilityType.SKILL_CALL_INTERVIEW;
        goto L663
    L611:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_CALL_TREE_HOLE.getKey()) == false) goto L614;
        r151 = ChatAbilityType.SKILL_CALL_TREE_HOLE;
        goto L663
    L614:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_COMMAND.getKey()) == false) goto L617;
        r151 = ChatAbilityType.SKILL_COMMAND;
        goto L663
    L617:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_DAILY_NEWS.getKey()) == false) goto L620;
        r151 = ChatAbilityType.SKILL_DAILY_NEWS;
        goto L663
    L620:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_OLYMPIC_DAILY_CARD.getKey()) == false) goto L623;
        r151 = ChatAbilityType.SKILL_OLYMPIC_DAILY_CARD;
        goto L663
    L623:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_SPEAKER.getKey()) == false) goto L626;
        r151 = ChatAbilityType.SKILL_SPEAKER;
        goto L663
    L626:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COMPLEX_SEARCH.getKey()) == false) goto L629;
        r151 = ChatAbilityType.SKILL_COMPLEX_SEARCH;
        goto L663
    L629:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_LISTEN_PODCAST.getKey()) == false) goto L632;
        r151 = ChatAbilityType.SKILL_LISTEN_PODCAST;
        goto L663
    L632:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_CALL_VIDEO.getKey()) == false) goto L635;
        r151 = ChatAbilityType.SKILL_CALL_VIDEO;
        goto L663
    L635:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.CREATION_TEMPLATE_AIGENING.getKey()) == false) goto L638;
        r151 = ChatAbilityType.SKILL_CREATION_TEMPLATE_AIGENIMG;
        goto L663
    L638:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.CREATION_TEMPLATE_AIREPLICA.getKey()) == false) goto L641;
        r151 = ChatAbilityType.SKILL_CREATION_TEMPLATE_AIREPLICA;
        goto L663
    L641:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_DEEP_THINKING.getKey()) == false) goto L644;
        r151 = ChatAbilityType.SKILL_DEEP_THINKING;
        goto L663
    L644:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_SINGER.getKey()) == false) goto L647;
        r151 = ChatAbilityType.SKILL_SINGER;
        goto L663
    L647:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_INMATE.getKey()) == false) goto L650;
        r151 = ChatAbilityType.SKILL_INMATE;
        goto L663
    L650:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_ENGLISH_LEARNING.getKey()) == false) goto L653;
        r151 = ChatAbilityType.SKILL_ENGLISH_LEARNING;
        goto L663
    L653:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_PODCAST_GENERATION.getKey()) == false) goto L656;
        r151 = ChatAbilityType.SKILL_PODCAST_GENERATION;
        goto L663
    L656:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_ECOM_ASSISTANT.getKey()) == false) goto L659;
        r151 = ChatAbilityType.SKILL_ECOM_ASSISTANT;
        goto L663
    L659:
        if (Intrinsics.areEqual(r105, ActionBarInstructionKey.COCO_TRAVEL_ASK_DOUBAO.getKey()) == false) goto L661;
        r151 = ChatAbilityType.SKILL_COCO_TRAVEL_ASK_DOUBAO;
        goto L663
    L661:
        r151 = ChatAbilityType.ChatAbilityType_Unknown;
        goto L663
    L551:
        r109 = 0;
    L548:
        FLogger.a.e("MessageRequestConverter", "parse instruction failed: ".concat(r106));
        r108 = null;
    L547:
        r107 = null;
        goto L548
    L503:
        if (r94.get(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION) != null) goto L538;
        if (o0.d((String) r94.get("doc_ref_block_info")) == false) goto L513;
        String r177 = (String) r94.get("doc_ref_block_info");
        FLogger.a.i("MessageRequestConverter", "Got doc ref info: " + r177);
        r94.remove("doc_ref_block_info");
        UserContext r178 = f(ContextType.ContextType_Doc, r177);
        if (r178 == null) goto L510;
        List r179 = CollectionsKt.listOf(r178);
    L511:
        r104 = b(r104, r179);
        r157 = new ChatAbility(ChatAbilityType.SKILL_WRITING.getValue(), r177);
        goto L675
    L510:
        r179 = null;
        goto L511
    L513:
        if (o0.d((String) r94.get("office_ref_block_info")) == false) goto L520;
        String r180 = (String) r94.get("office_ref_block_info");
        FLogger.a.i("MessageRequestConverter", "Got doc ref info: " + r180);
        r94.remove("office_ref_block_info");
        UserContext r181 = f(ContextType.ContextType_Ppt, r180);
        if (r181 == null) goto L517;
        List r182 = CollectionsKt.listOf(r181);
    L518:
        r104 = b(r104, r182);
        r157 = new ChatAbility(ChatAbilityType.SKILL_PPT_GENERATION.getValue(), r180);
        goto L675
    L517:
        r182 = null;
        goto L518
    L520:
        if (o0.d((String) r94.get("office_sheet_ref_block_info")) == false) goto L527;
        String r183 = (String) r94.get("office_sheet_ref_block_info");
        FLogger.a.i("MessageRequestConverter", "Got doc ref info: " + r183);
        r94.remove("office_sheet_ref_block_info");
        UserContext r184 = f(ContextType.ContextType_Excel, r183);
        if (r184 == null) goto L524;
        List r185 = CollectionsKt.listOf(r184);
    L525:
        r104 = b(r104, r185);
        r157 = new ChatAbility(ChatAbilityType.SKILL_SHEET_GENERATION.getValue(), r183);
        goto L675
    L524:
        r185 = null;
        goto L525
    L527:
        if (o0.d((String) r94.get("camera_ppt_instruction_items_selected_template")) == false) goto L536;
        String r186 = (String) r94.get("camera_ppt_instruction_items_selected_template");
        if (r186 != null) goto L532;
        r186 = "";
    L532:
        if (o0.d(r186) == false) goto L535;
        String r187 = j(r186, new c0(r93));
        FLogger.a.d("MessageRequestConverter", "get camera_ppt_instruction_items_selected_template abilityParams=" + r187);
        r156 = new ChatAbility(ChatAbilityType.SKILL_PPT_GENERATION.getValue(), r187);
        goto L534
    L535:
        FLogger.a.d("MessageRequestConverter", "get camera_ppt_instruction_items_selected_template null");
    L537:
        r157 = null;
        goto L675
    L536:
        FLogger.a.d("MessageRequestConverter", "get chatAbility null");
        goto L537
    L494:
        if (r149.length() <= 0) goto L496;
        boolean r188 = true;
    L497:
        if (r188 == false) goto L499;
        r417 = r149;
        goto L500
    L496:
        r188 = false;
        goto L497
    L485:
        if (r148.length() <= 0) goto L487;
        boolean r189 = true;
    L488:
        if (r189 == false) goto L490;
        r416 = r148;
        goto L491
    L487:
        r189 = false;
        goto L488
    L476:
        if (r146.length() <= 0) goto L478;
        boolean r190 = true;
    L479:
        if (r190 == false) goto L481;
        r147 = r146;
        goto L482
    L478:
        r190 = false;
    L472:
        r142 = ChatEntrySourceType.ChatEntrySourceType_Default.getValue();
    L466:
        r414 = null;
    L456:
        r413 = false;
    L450:
        r412 = false;
    L444:
        r103 = 0;
        goto L445
    L438:
        r411 = null;
        goto L439
    L435:
        r88 = null;
        goto L436
    L421:
        if (r86.length() <= 0) goto L423;
        boolean r191 = true;
    L424:
        if (r191 == true) goto L427;
        r86 = null;
    L427:
        if (r86 == null) goto L431;
        zd9.h r192 = zd9.h.a;
        Type r193 = new b().getType();
        r192.getClass();
        Map r194 = (Map) zd9.h.b(r86, r193);
        if (r194 == null) goto L431;
        r87 = r194.get("ext");
        goto L433
    L423:
        r191 = false;
    L417:
        r314 = 0;
    L411:
        r81 = com.larus.bmhome.view.actionbar.custom.cache.e.c(r12);
    L405:
        r78 = 0;
        goto L406
    L396:
        if (o0.d((String) r94.get("target_device_id")) == false) goto L398;
        String r195 = "local";
    L399:
        r64.put("computer_type", r195);
        r64.put("computer_status", "online");
        goto L400
    L398:
        r195 = "cloud";
    L379:
        r72 = "";
        goto L380
    L366:
        r63 = null;
        goto L367
    L361:
        if (r61 != null) goto L363;
        r61 = new ConversationInitOption(null, false, null, null, 15, null);
    L363:
        r312 = ConversationInitOption.copy$default(r61, null, false, null, r211, 7, null);
        goto L364
    L353:
        if (r62.length() <= 0) goto L355;
        boolean r196 = true;
    L356:
        if (r196 == false) goto L358;
        r211 = r62;
        goto L359
    L355:
        r196 = false;
        goto L356
    L349:
        zd9.h r197 = zd9.h.a;
        String r198 = (String) r94.get("conversation_init_option");
        r197.getClass();
        r61 = (ConversationInitOption) zd9.h.a(r198, ConversationInitOption.class);
        goto L350
    L345:
        r311 = null;
    L286:
        r42 = new AgentTaskParamChange(false, false, false, 7, null);
        goto L287
    L290:
        r310 = r210;
        goto L292
    L239:
        if (r28.getNeedModifyConversation() == false) goto L241;
        r32 = true;
    L236:
        r31 = false;
        goto L237
    L221:
        if ((!StringsKt.isBlank(r27)) == true) goto L224;
        r27 = null;
    L224:
        if (r27 == null) goto L226;
        zd9.h.a.getClass();
        r28 = (GeneralTaskParam) zd9.h.a(r27, GeneralTaskParam.class);
        goto L227
    L165:
        if (r26.length() == 0) goto L168;
        r122 = false;
        goto L169
    L158:
        if (r25.length() == 0) goto L161;
        r121 = false;
        goto L162
    L150:
        if (r113.length() == 0) goto L153;
        r120 = false;
        goto L154
    L142:
        if (r118.isEmpty() == true) goto L145;
        r119 = false;
        goto L146
    L134:
        if (r116.isEmpty() == true) goto L137;
        r117 = false;
    L170:
        if (r112 != null) goto L176;
        if (r22 == null) goto L173;
        r112 = r22.getClientOption();
    L174:
        if (r112 != null) goto L176;
        r112 = new ClientOption(null, false, null, null, null, null, null, null, null, 511, null);
        goto L176
    L173:
        r112 = null;
    L176:
        ClientOption r318 = r112;
        if (r22 != null) goto L179;
        GeneralTaskParam r710 = new GeneralTaskParam(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, 65535, null);
    L180:
        if (r14 != null) goto L184;
        if (r22 == null) goto L183;
        r14 = r22.getRuntimeType();
        goto L184
    L183:
        Integer r711 = null;
    L185:
        if (r19 != null) goto L189;
        if (r22 == null) goto L188;
        r19 = r22.getSelectedSkills();
        goto L189
    L188:
        List r810 = null;
    L190:
        if (r110 != null) goto L194;
        if (r22 == null) goto L193;
        r110 = r22.getSkillSelections();
        goto L194
    L193:
        List r811 = null;
    L196:
        if (r113 != null) goto L198;
        r113 = r318.getWorkspace();
    L198:
        String r418 = r113;
        if (r115 != null) goto L201;
        r115 = r318.getSandboxAuthType();
    L201:
        ClientOption r712 = ClientOption.copy$default(r318, null, false, null, null, null, r418, r115, null, null, 415, null);
        if (r25 != null) goto L206;
        if (r22 == null) goto L205;
        r25 = r22.getDispatchControllerMobileDid();
        goto L206
    L205:
        String r812 = null;
    L207:
        if (r26 != null) goto L211;
        if (r22 == null) goto L210;
        r26 = r22.getDispatchControllerMobilePlatform();
        goto L211
    L210:
        String r813 = null;
    L212:
        r22 = GeneralTaskParam.copy$default(r710, null, null, null, null, null, r712, r711, r810, r811, r812, r813, null, null, false, null, null, 63519, null);
    L211:
        r813 = r26;
    L206:
        r812 = r25;
    L194:
        r811 = r110;
    L189:
        r810 = r19;
    L184:
        r711 = r14;
        goto L185
    L179:
        r710 = r22;
        goto L180
    L127:
        if ((!StringsKt.isBlank(r26)) == false) goto L129;
    L123:
        r25 = null;
    L113:
        r23 = false;
    L116:
        r115 = null;
        goto L117
    L102:
        if ((!StringsKt.isBlank(r113)) == false) goto L104;
    L90:
        if (r111.length() <= 0) goto L92;
        boolean r199 = true;
    L93:
        if (r199 == true) goto L96;
        r111 = null;
    L96:
        if (r111 == null) goto L98;
        zd9.h.a.getClass();
        r112 = (ClientOption) zd9.h.a(r111, ClientOption.class);
        goto L99
    L92:
        r199 = false;
        goto L93
    L65:
        if (r16.length() <= 0) goto L67;
        boolean r1100 = true;
    L68:
        if (r1100 == true) goto L71;
        r16 = null;
    L71:
        if (r16 == null) goto L79;
        Sequence r200 = StringsKt.lineSequence(r16);     // Catch: Throwable -> L82
        if (r200 == null) goto L79;
        Sequence r201 = SequencesKt.map(r200, new z());     // Catch: Throwable -> L82
        if (r201 == null) goto L79;
        Sequence r202 = SequencesKt.filter(r201, new a0());     // Catch: Throwable -> L82
        if (r202 == null) goto L79;
        r17 = SequencesKt.toList(r202);     // Catch: Throwable -> L82
        goto L80
    L67:
        r1100 = false;
    L82:
        th = move-exception;
        Result.Companion r1101 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L85
    L61:
        r14 = null;
        goto L713
    L52:
        r11 = r95;
    L41:
        r4 = false;
        goto L42
    L48:
        r22 = null;
        goto L49
    L26:
        if (r910.length() <= 0) goto L28;
        boolean r203 = true;
    L29:
        if (r203 == false) goto L31;
        r1 = r910;
        goto L32
    L28:
        r203 = false;
        goto L29
    L17:
        if (r1.length() <= 0) goto L19;
        boolean r204 = true;
    L20:
        if (r204 == true) goto L23;
        r1 = null;
    L23:
        if (r1 != null) goto L32;
    L19:
        r204 = false;
        goto L20
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r205 = true;
    L8:
        if (r205 == false) goto L10;
        String r206 = r0;
    L11:
        if (r206 == null) goto L13;
        r21 = StringsKt.split$default(r206, new String[]{","}, false, 0, 6, null);
        goto L14
    L10:
        r206 = null;
        goto L11
    L7:
        r205 = false;
        goto L8
    }
}
