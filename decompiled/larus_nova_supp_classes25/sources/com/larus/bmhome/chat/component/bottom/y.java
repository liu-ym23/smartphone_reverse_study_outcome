package com.larus.bmhome.chat.component.bottom;

import ai8.c;
import ai8.f;
import ai8.h;
import com.flow.kmp.common.util.i;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.MultiAttachmentInfo;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.model.n;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.platform.api.FlowDriveFileSendInfo;
import com.larus.utils.logger.FLogger;
import gd8.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.v0;
import wc9.e;
import wf9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class y implements Function1 {
    public final /* synthetic */ ChatBottomComponent a;

    public /* synthetic */ y(ChatBottomComponent r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v5 */
    public final Object invoke(Object r40) {
        ChatBottomComponent r1 = this.a;
        ICoreInputAbility.OnSendParams r2 = (ICoreInputAbility.OnSendParams) r40;
        int r3 = ChatBottomComponent.L0;
        Intrinsics.checkNotNullParameter(r2, "params");
        ChatBottomComponent$b r4 = r1.O;
        if (r4 == null) goto L145;
        List<String> r5 = r4.b;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L7:
        if (r7.hasNext() == false) goto L12;
        Object r8 = r7.next();
        if ((true ^ StringsKt.isBlank((String) r8)) == false) goto L7;
        r6.add(r8);
        goto L7
    L12:
        if (r6.isEmpty() == false) goto L14;
        FLogger.a.w("ChatBottomComponent", "send human merge forward skipped, empty subMsgIds");
        r1.m3(true);
        goto L145
    L14:
        ?? r9 = new ArrayList();
        String r12 = r4.a;
        ArrayList r10 = new ArrayList();
        Iterator r11 = r6.iterator();
    L16:
        if (r11.hasNext() == false) goto L21;
        Long r13 = StringsKt.toLongOrNull((String) r11.next());
        if (r13 == null) goto L16;
        r10.add(r13);
        goto L16
    L21:
        if (r10.size() == r6.size()) goto L24;
        FLogger.a.w("ChatBottomComponent", "build human merge forward skipped, invalid message ids=" + r6);
        r9 = CollectionsKt.emptyList();
    L23:
        ?? r14 = r9;
        if (r14.isEmpty() == false) goto L146;
        FLogger.a.w("ChatBottomComponent", "send human merge forward skipped, strategy is empty");
        goto L145
    L146:
        ConcurrentHashMap r15 = v0.a;
        String r16 = r4.d;
        String r17 = r4.e;
        int r18 = r4.f;
        Intrinsics.checkNotNullParameter(r6, "forwardMessageIds");
        Intrinsics.checkNotNullParameter(r17, "chatType");
        ArrayList r19 = new ArrayList();
        Iterator r110 = r6.iterator();
    L148:
        if (r110.hasNext() == false) goto L152;
        Object r111 = r110.next();
        if ((!StringsKt.isBlank((String) r111)) == false) goto L148;
        r19.add(r111);
        goto L148
    L152:
        v0.c r112 = new v0.c(v0.e(r17), r18, CollectionsKt.joinToString$default(r19, ",", null, null, 0, null, null, 62, null), r16);
        Iterable r20 = (Iterable) r14;
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r22 = r20.iterator();
    L154:
        if (r22.hasNext() == false) goto L156;
        r21.add(((ic8.w) r22.next()).b());
        goto L154
    L156:
        ConcurrentHashMap r23 = v0.a;
        Intrinsics.checkNotNullParameter(r21, "localMessageIds");
        Intrinsics.checkNotNullParameter(r112, "traceExt");
        Iterator r24 = r21.iterator();
    L158:
        if (r24.hasNext() == false) goto L167;
        String r25 = (String) r24.next();
        if (r25 == null) goto L158;
        if ((!StringsKt.isBlank(r25)) == true) goto L165;
        r25 = null;
    L165:
        if (r25 == null) goto L158;
        v0.a.put(r25, r112);
        goto L158
    L167:
        FLogger r26 = FLogger.a;
        StringBuilder r27 = new StringBuilder("register human merge forward trace, msgCount=");
        r27.append(r6.size());
        r27.append(", localMessageCount=");
        r27.append(r21.size());
        r27.append(", chatType=");
        r27.append(r112.d);
        r27.append(", hasForwardChatId=");
        String r28 = r4.d;
        if (r28 != null) goto L170;
    L173:
        boolean r38 = true;
    L174:
        r27.append(!r38);
        r26.i("ChatBottomComponent", r27.toString());
        g r113 = (g) r1.y.getValue();
        if (r113 == null) goto L195;
        com.larus.bmhome.chat.component.cvs.y r29 = r1.u0();
        if (r29 == null) goto L179;
        e r114 = r29.h();
    L180:
        MultiAttachmentInfo r30 = r2.getMultiAttachment();
        if (r30 == null) goto L184;
        String r31 = r30.getFromScene();
        if (r31 == null) goto L184;
    L193:
        String r115 = r31;
    L194:
        g.a.a(r113, r114, "message_forward", r14, r115, Boolean.TRUE, null, 32);
    L184:
        CustomMultiAttachmentInfo r32 = r2.getCustomMultiAttachment();
        if (r32 == null) goto L187;
        r31 = r32.getFromScene();
    L188:
        if (r31 != null) goto L193;
        AttachmentInfo r33 = r2.getAttachment();
        if (r33 == null) goto L192;
        r31 = r33.getFromScene();
        goto L193
    L192:
        r115 = null;
        goto L194
    L187:
        r31 = null;
        goto L188
    L179:
        r114 = null;
    L195:
        MultiAttachmentInfo r34 = r2.getMultiAttachment();
        if (r34 == null) goto L207;
        String r35 = r34.getLocalMsgId();
        if (r35 == null) goto L207;
        if ((!StringsKt.isBlank(r35)) == true) goto L203;
        r35 = null;
    L203:
        if (r35 == null) goto L207;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r36 = r1.f70();
        if (r36 == null) goto L207;
        r36.b2(r35);
    L207:
        n r37 = r1.D;
        if (r37 == null) goto L210;
        r37.q();
    L210:
        n r39 = r1.D;
        if (r39 == null) goto L213;
        r39.n();
    L213:
        n r41 = r1.D;
        if (r41 == null) goto L216;
        r41.i();
    L216:
        ICoreInputAbility r42 = r1.E3();
        if (r42 == null) goto L219;
        ICoreInputAbility.b.d(r42, "", false, false, null, null, false, 62);
    L219:
        r1.m3(true);
        boolean r43 = true;
    L221:
        return Boolean.valueOf(r43);
    L170:
        if (StringsKt.isBlank(r28) == true) goto L173;
        r38 = false;
        goto L174
    L24:
        int r44 = b.a;
        String r116 = i.a();
        Map<String, String> r45 = r2.messageExt;
        if (r45 == null) goto L28;
        Map r46 = MapsKt.toMutableMap(r45);
        if (r46 == null) goto L28;
    L29:
        Map r117 = r46;
        r117.put("use_content_block", "1");
        FlowDriveFileSendInfo r47 = r2.getDriveFileSendInfo();
        if (r47 == null) goto L47;
        JSONObject r118 = new JSONObject();
        String r119 = r47.getCollectionId();
        if (r119 == null) goto L35;
        r118.put("collection_id", r119);
    L35:
        String r48 = r47.getCollectionName();
        if (r48 == null) goto L38;
        r118.put("collection_name", r48);
    L38:
        String r49 = r47.getContentType();
        if (r49 == null) goto L41;
        r118.put("content_type", r49);
    L41:
        String r50 = r47.getContentSecType();
        if (r50 == null) goto L45;
        r118.put("content_sec_type", r50);
    L45:
        if (r118.length() <= 0) goto L47;
        Map r51 = MapsKt.mapOf(TuplesKt.to("drive_file_send_info", r118.toString()));
    L48:
        r9.add(new c(r10, 1, r12, r6.size(), r116, r117, r51, null, r2.chatPageContext));
        MultiAttachmentInfo r52 = r2.getMultiAttachment();
        if (r52 == null) goto L64;
        String r53 = r52.getLocalMsgId();
        if (r53 == null) goto L64;
        if ((!StringsKt.isBlank(r53)) == true) goto L56;
        r53 = null;
    L56:
        if (r53 == null) goto L64;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r54 = r1.f70();
        if (r54 == null) goto L64;
        NestedFileContent r210 = r54.b6(r53);
        if (r210 == null) goto L64;
        yc9.v0.g(r210);
        if (yc9.v0.h(r210) <= 0) goto L64;
        r9.add(new f(r210, r53, null, r2.getReferenceInfo(), r117, r51, false, null, r2.chatPageContext, null, 708));
    L64:
        CustomMultiAttachmentInfo r55 = r2.getCustomMultiAttachment();
        if (r55 == null) goto L71;
        NestedFileContent r211 = r55.getNestedFileContent();
        if (r211 == null) goto L71;
        yc9.v0.g(r211);
        if (yc9.v0.h(r211) <= 0) goto L71;
        r9.add(new f(r211, i.a(), null, r2.getReferenceInfo(), r117, r51, false, null, r2.chatPageContext, null, 708));
    L71:
        AttachmentInfo r56 = r2.getAttachment();
        if (r56 != null) goto L74;
    L133:
        String r57 = StringsKt.trim(r2.getContent()).toString();
        if ((!StringsKt.isBlank(r57)) == false) goto L136;
        String r212 = r57;
    L137:
        if (r212 == null) goto L23;
        String r58 = r2.textLocalMsgId;
        if (r58 != null) goto L141;
        r58 = i.a();
    L141:
        r9.add(new h(r212, r58, null, r2.getReferenceInfo(), r117, r51, false, false, r2.chatPageContext, null, 708));
        goto L23
    L136:
        r212 = null;
        goto L137
    L74:
        if (r56.isImage() == true) goto L77;
        r56 = null;
    L77:
        if (r56 == null) goto L133;
        String r213 = r56.getFilePath();
        String r214 = r56.getTosKey();
        Integer r59 = r56.getHeight();
        if (r59 == null) goto L81;
        int r60 = r59.intValue();
    L82:
        Integer r215 = Integer.valueOf(r60);
        Integer r61 = r56.getWidth();
        if (r61 == null) goto L85;
        int r62 = r61.intValue();
    L86:
        Integer r216 = Integer.valueOf(r62);
        String r217 = r56.getResourceId();
        String r218 = r56.getServerUrl();
        List<String> r63 = r2.attachmentLocalMsgIds;
        if (r63 == null) goto L90;
        String r64 = (String) CollectionsKt.firstOrNull(r63);
        if (r64 == null) goto L90;
    L91:
        String r219 = r64;
        ReferenceInfo r220 = r2.getReferenceInfo();
        ChatPageContext r65 = r2.chatPageContext;
        Boolean r310 = r56.getAiCreationImage();
        String r120 = r56.getPreviewUrl();
        if (r120 != null) goto L94;
    L102:
        Image r121 = r56.getImage();
        if (r121 == null) goto L115;
        ImageObj r122 = r121.previewImage;
        if (r122 == null) goto L115;
        r120 = r122.url;
        if (r120 == null) goto L115;
        if (r120.length() != 0) goto L111;
        boolean r311 = true;
    L113:
        if ((!r311) == false) goto L115;
    L116:
        if (r120 != null) goto L131;
        r120 = r56.getServerUrl();
        if (r120 != null) goto L120;
    L130:
        String r312 = null;
    L132:
        r9.add(new ai8.e(r213, r214, r215, r216, r217, r218, r219, r220, r117, r51, false, r65, r310, r312, 2112));
        goto L133
    L120:
        if (Intrinsics.areEqual(r56.getAiCreationImage(), Boolean.TRUE) == true) goto L122;
    L127:
        boolean r66 = false;
    L128:
        if (r66 == false) goto L130;
    L122:
        if (r120.length() != 0) goto L124;
        boolean r67 = true;
    L125:
        if (r67 == true) goto L127;
        r66 = true;
        goto L128
    L124:
        r67 = false;
    L131:
        r312 = r120;
        goto L132
    L111:
        r311 = false;
    L115:
        r120 = null;
        goto L116
    L94:
        if (r120.length() != 0) goto L96;
        boolean r313 = true;
    L98:
        if ((!r313) == true) goto L101;
        r120 = null;
    L101:
        if (r120 != null) goto L131;
    L96:
        r313 = false;
    L90:
        r64 = i.a();
        goto L91
    L85:
        r62 = 0;
        goto L86
    L81:
        r60 = 0;
    L47:
        r51 = null;
    L28:
        r46 = new LinkedHashMap();
    L145:
        r43 = false;
        goto L221
    }
}
