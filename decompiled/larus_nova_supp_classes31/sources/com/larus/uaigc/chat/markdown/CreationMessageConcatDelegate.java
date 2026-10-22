package com.larus.uaigc.chat.markdown;

import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.im.bean.IMMetaInfo;
import com.larus.im.bean.message.TextTagInfo;
import com.larus.platform.spi.IAIChatMessageConcatDelegate;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import dp8.b;
import dp8.d;
import dz9.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zd9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b*\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006\u000f"}, d2 = {"Lcom/larus/uaigc/chat/markdown/CreationMessageConcatDelegate;", "Lcom/larus/platform/spi/IAIChatMessageConcatDelegate;", "<init>", "()V", "contentType", "", "concatContent", "", "curContent", "newContent", "addNewTextTags", "", "Lcom/larus/im/bean/message/TextTagInfo;", "newTags", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationMessageConcatDelegate implements IAIChatMessageConcatDelegate {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public CreationMessageConcatDelegate() {
    }

    public final void contentType() {
    }

    public final String a(String r18, String r19) {
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("curContent length: ");
        if (r18 == null) goto L5;
        Integer r5 = Integer.valueOf(r18.length());
    L6:
        r3.append(r5);
        r3.append(", newContent length: ");
        if (r19 == null) goto L9;
        Integer r6 = Integer.valueOf(r19.length());
    L10:
        r3.append(r6);
        r2.d("CreationMessageConcatDelegate", r3.toString());
        if (r19 != null) goto L13;
        return r18;
    L13:
        CreationMsgContentData r0 = b.a(r18, new d());
        CreationMsgContentData r1 = b.a(r19, new d());
        if (r1 == null) goto L16;
        String r4 = r1.text;
    L17:
        String r7 = "";
        if (r4 != null) goto L20;
        r4 = "";
    L20:
        if (r1 == null) goto L24;
        List r8 = r1.textTags;
        if (r8 == null) goto L24;
        List r9 = CollectionsKt.filterNotNull(r8);
    L25:
        if (r9 != null) goto L27;
        r9 = CollectionsKt.emptyList();
    L27:
        if (r1 == null) goto L31;
        CreationInfo r10 = r1.creationInfo;
        if (r10 == null) goto L31;
        Integer r11 = r10.layoutType;
    L32:
        boolean r12 = true;
        if (r11 == null) goto L61;
        CreationInfo r13 = r1.creationInfo;
        if (r13 == null) goto L42;
        Integer r14 = r13.layoutType;
        if (r14 == null) goto L42;
        if (r14.intValue() != (-1)) goto L42;
        boolean r15 = true;
    L43:
        if (r15 == true) goto L61;
        CreationInfo r16 = r1.creationInfo;
        if (r16 == null) goto L65;
        Integer r17 = r16.layoutType;
        if (r17 == null) goto L65;
        int r110 = r17.intValue();
        if (r0 == null) goto L55;
        CreationInfo r111 = r0.creationInfo;
        if (r111 == null) goto L55;
        Integer r112 = r111.layoutType;
        if (r112 == null) goto L55;
    L57:
        if (r110 == r112.intValue()) goto L59;
        boolean r113 = true;
    L60:
        Integer r114 = r17;
    L67:
        if (r113 == true) goto L82;
        if (r1 == null) goto L72;
        CreationInfo r20 = r1.creationInfo;
        if (r20 == null) goto L72;
        boolean r21 = Intrinsics.areEqual(r20.needRefreshCreationContent, Boolean.TRUE);
    L73:
        if (r21 == true) goto L82;
        if (r0 == null) goto L78;
        String r22 = r0.text;
    L79:
        if (r22 != null) goto L81;
        r22 = "";
    L81:
        r4 = r22.concat(r4);
    L83:
        if (r113 == true) goto L141;
        if (r1 == null) goto L88;
        CreationInfo r23 = r1.creationInfo;
        if (r23 == null) goto L88;
        boolean r24 = Intrinsics.areEqual(r23.needRefreshCreationContent, Boolean.TRUE);
    L89:
        if (r24 == true) goto L141;
        if (r0 == null) goto L95;
        List r25 = r0.textTags;
        if (r25 == null) goto L95;
        List r26 = CollectionsKt.filterNotNull(r25);
    L96:
        if (r26 != null) goto L99;
        r26 = CollectionsKt.emptyList();
    L99:
        if (r9.isEmpty() == false) goto L101;
    L100:
        r9 = r26;
        goto L141
    L101:
        List r27 = r26;
        ArrayList r28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
        Iterator r29 = r27.iterator();
    L103:
        if (r29.hasNext() == false) goto L109;
        TextTagInfo r115 = (TextTagInfo) r29.next();
        wc8.b r116 = wc8.b.a;
        IMMetaInfo.InsertTextReference r117 = wc8.b.f(r115.tagInfo, new dz9.b());
        if (r117 == null) goto L107;
        Integer r118 = r117.getPos();
    L108:
        r28.add(TuplesKt.to(r118, r115));
        goto L103
    L107:
        r118 = null;
        goto L108
    L109:
        LinkedHashMap r30 = new LinkedHashMap();
        Iterator r31 = r28.iterator();
    L111:
        if (r31.hasNext() == false) goto L116;
        Object r119 = r31.next();
        Integer r120 = (Integer) ((Pair) r119).getFirst();
        Object r121 = r30.get(r120);
        if (r121 != null) goto L115;
        r121 = new ArrayList();
        r30.put(r120, r121);
    L115:
        ((List) r121).add(r119);
        goto L111
    L116:
        Map r32 = MapsKt.toMutableMap(r30);
        if ((!r32.isEmpty()) == false) goto L136;
        ArrayList r122 = new ArrayList();
        Iterator r33 = r9.iterator();
    L120:
        if (r33.hasNext() == false) goto L132;
        TextTagInfo r123 = (TextTagInfo) r33.next();
        wc8.b r124 = wc8.b.a;
        IMMetaInfo.InsertTextReference r125 = wc8.b.f(r123.tagInfo, new c());
        if (r125 != null) goto L124;
    L129:
        Integer r126 = null;
    L130:
        if (r126 == null) goto L120;
        r122.add(r126);
        goto L120
    L124:
        if (Intrinsics.areEqual(r125.getCanReplace(), Boolean.TRUE) == true) goto L127;
        r125 = null;
    L127:
        if (r125 == null) goto L129;
        r126 = r125.getPos();
        goto L130
    L132:
        Iterator r34 = r122.iterator();
    L134:
        if (r34.hasNext() == false) goto L136;
        r32.remove(Integer.valueOf(((Number) r34.next()).intValue()));
    L136:
        List r35 = CollectionsKt.flatten(r32.values());
        ArrayList r36 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r35, 10));
        Iterator r37 = r35.iterator();
    L138:
        if (r37.hasNext() == false) goto L140;
        r36.add((TextTagInfo) ((Pair) r37.next()).getSecond());
        goto L138
    L140:
        r26 = CollectionsKt.toMutableList(r36);
        r26.addAll(r9);
    L95:
        r26 = null;
    L88:
        r24 = false;
    L141:
        if (r1 == null) goto L234;
        CreationInfo r38 = r1.creationInfo;
        if (r38 != null) goto L147;
        if (r0 == null) goto L146;
        CreationInfo r127 = r0.creationInfo;
    L148:
        if (r127 == null) goto L216;
        if (r38 == null) goto L151;
        String r39 = r38.taskGroupId;
    L152:
        if (r39 != null) goto L155;
        r39 = "";
    L155:
        if (r39.length() != 0) goto L157;
        boolean r40 = true;
    L158:
        if (r40 == false) goto L164;
        if (r0 == null) goto L163;
        CreationInfo r41 = r0.creationInfo;
        if (r41 == null) goto L163;
        r39 = r41.taskGroupId;
    L163:
        String r128 = null;
    L165:
        if (r0 == null) goto L169;
        CreationInfo r42 = r0.creationInfo;
        if (r42 == null) goto L169;
        Map r43 = r42.taskInfo;
    L170:
        if (r43 != null) goto L172;
        r43 = MapsKt.emptyMap();
    L172:
        Map r129 = MapsKt.toMutableMap(r43);
        CreationInfo r44 = r1.creationInfo;
        if (r44 == null) goto L175;
        Map r45 = r44.taskInfo;
    L176:
        if (r45 != null) goto L178;
        r45 = MapsKt.emptyMap();
    L178:
        r129.putAll(r45);
        Unit r46 = Unit.INSTANCE;
        CreationInfo r47 = r1.creationInfo;
        if (r47 == null) goto L181;
        String r48 = r47.supportVersion;
    L182:
        if (r48 == null) goto L186;
        r7 = r48;
    L186:
        if (r7.length() != 0) goto L188;
        boolean r49 = true;
    L189:
        if (r49 == false) goto L196;
        if (r0 == null) goto L194;
        CreationInfo r50 = r0.creationInfo;
        if (r50 == null) goto L194;
        String r51 = r50.supportVersion;
    L195:
        String r130 = r51;
    L197:
        CreationInfo r52 = r1.creationInfo;
        if (r52 == null) goto L200;
        boolean r53 = Intrinsics.areEqual(r52.needRefreshCreationContent, Boolean.TRUE);
    L201:
        if (r53 == true) goto L215;
        CreationInfo r54 = r1.creationInfo;
        if (r54 == null) goto L205;
        Map r55 = r54.taskInfo;
    L206:
        if (r55 != null) goto L208;
    L211:
        boolean r56 = true;
    L212:
        if (r56 == false) goto L215;
        r12 = false;
        goto L215
    L208:
        if (r55.isEmpty() == true) goto L211;
        r56 = false;
        goto L212
    L205:
        r55 = null;
    L215:
        CreationInfo r57 = r127.copy(r114, r128, r129, r130, Boolean.valueOf(r12));
    L217:
        CreationMsgContentData r58 = r1.copy(r4, r9, r57);
        if (r58 == null) goto L235;
        h.a.getClass();
        return h.c(r58);
    L235:
        return null;
    L200:
        r53 = false;
    L194:
        r51 = null;
        goto L195
    L196:
        r130 = r7;
        goto L197
    L188:
        r49 = false;
        goto L189
    L181:
        r48 = null;
        goto L182
    L175:
        r45 = null;
    L169:
        r43 = null;
    L164:
        r128 = r39;
        goto L165
    L157:
        r40 = false;
        goto L158
    L151:
        r39 = null;
        goto L152
    L216:
        r57 = null;
        goto L217
    L146:
        r127 = null;
        goto L148
    L147:
        r127 = r38;
        goto L148
    L234:
        return null;
    L78:
        r22 = null;
    L72:
        r21 = false;
    L82:
        r2.e("CreationMessageConcatDelegate", "delete old text");
        goto L83
    L59:
        r113 = false;
    L55:
        r112 = -1;
    L65:
        Integer r59 = null;
    L66:
        r114 = r59;
        r113 = false;
    L42:
        r15 = false;
    L61:
        if (r0 == null) goto L65;
        CreationInfo r60 = r0.creationInfo;
        if (r60 == null) goto L65;
        r59 = r60.layoutType;
    L31:
        r11 = null;
    L24:
        r9 = null;
        goto L25
    L16:
        r4 = null;
        goto L17
    L9:
        r6 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }
}
