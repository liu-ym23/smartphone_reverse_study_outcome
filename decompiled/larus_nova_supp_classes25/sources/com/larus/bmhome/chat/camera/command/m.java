package com.larus.bmhome.chat.camera.command;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionData;
import com.larus.platform.model.action.SuggestedActionKey;
import com.larus.platform.model.action.SuggestedActionScene;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v43 */
    /* JADX WARN: Type inference failed for: r6v46 */
    /* JADX WARN: Type inference failed for: r6v47 */
    /* JADX WARN: Type inference failed for: r6v48, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v49 */
    /* JADX WARN: Type inference failed for: r6v50 */
    public static List a(SuggestedActionData r25, SuggestedActionScene r26, iq9.e r27, boolean r28, Function1 r29, String r30) {
        List r4 = null;
        if (r25 == null) goto L18;
        List r5 = r25.get(r26);
        if (r5 == null) goto L18;
        ?? r6 = new ArrayList();
        r6.addAll(r5);
        if (r28 == true) goto L19;
        Iterator r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L19;
        SuggestedAction r8 = (SuggestedAction) r7.next();
        if (r8 == null) goto L14;
        String r9 = r8.getSuggestedActionKey();
    L16:
        if (Intrinsics.areEqual(r9, SuggestedActionKey.AIBeautify.getValue()) == false) goto L10;
        r7.remove();
        goto L10
    L14:
        r9 = null;
    L19:
        if (r6 == 0) goto L25;
        if (r29 == null) goto L26;
        List r2 = (List) r29.invoke(r6);
        if (r2 == null) goto L26;
        r6 = r2;
    L26:
        ?? r10 = r6;
        r10 = r6;
        if (r26 != SuggestedActionScene.AttachmentAreaSingleFile) goto L72;
        if (r30 == null) goto L72;
        if (r6 == 0) goto L71;
        ArrayList r3 = new ArrayList();
        r3.addAll((Collection) r6);
        Iterator r11 = r3.iterator();
    L32:
        if (r11.hasNext() == false) goto L70;
        SuggestedAction r12 = (SuggestedAction) r11.next();
        if (r12 == null) goto L36;
        List r13 = r12.getDisplayExtList();
    L37:
        FLogger.a.d("CameraSuggestedActionListBuilder", "filterBlockFileMimeType[" + r30 + "] displayExtList=" + GsonProtectorUtils.toJson(new Gson(), r13));
        List r14 = r13;
        if (r14 != null) goto L40;
    L43:
        boolean r15 = true;
    L44:
        if (r15 == true) goto L32;
        List r16 = r13;
        if ((r16 instanceof Collection) == true) goto L48;
    L50:
        Iterator r17 = r16.iterator();
    L52:
        if (r17.hasNext() == false) goto L67;
        String r18 = (String) r17.next();
        if (r18 != null) goto L56;
    L59:
        boolean r19 = true;
    L60:
        if (r19 == false) goto L62;
    L64:
        boolean r110 = false;
    L65:
        if (r110 == false) goto L52;
        boolean r20 = true;
    L68:
        if (r20 == true) goto L32;
        r11.remove();
        goto L32
    L62:
        if (StringsKt.equals(r18, r30, true) == false) goto L64;
        r110 = true;
        goto L65
    L56:
        if (r18.length() == 0) goto L59;
        r19 = false;
    L67:
        r20 = false;
        goto L68
    L48:
        if (r16.isEmpty() == false) goto L50;
    L40:
        if (r14.isEmpty() == true) goto L43;
        r15 = false;
        goto L44
    L36:
        r13 = null;
        goto L37
    L70:
        r10 = r3;
        goto L72
    L71:
        r10 = 0;
    L72:
        if (r10 == 0) goto L74;
        r4 = CollectionsKt.filterNotNull((Iterable) r10);
    L74:
        FLogger.a.d("CameraSuggestedActionListBuilder", "handleSuggestedActionOperations scene: " + r26 + ", suggestedActions: " + r4 + ", suggestedActionOperations: " + r27);
        if (r27 == null) goto L293;
        List r21 = r27.a();
        if (r21 != null) goto L79;
    L82:
        boolean r22 = true;
    L83:
        if (r22 == true) goto L294;
        List r23 = r27.b();
        if (r23 != null) goto L88;
    L91:
        boolean r24 = true;
    L92:
        if (r24 == true) goto L101;
        List r31 = r27.b();
        if (r31 != null) goto L96;
    L98:
        boolean r0 = false;
    L99:
        if (r0 == true) goto L101;
        return r4;
    L96:
        if (r31.contains(r26) != true) goto L98;
        r0 = true;
    L101:
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        if (r4 == null) goto L105;
        Object r32 = CollectionsKt.toMutableList(r4);
        if (r32 == null) goto L105;
    L106:
        r1.element = r32;
        List r33 = r27.a();
        if (r33 == null) goto L219;
        List r34 = CollectionsKt.filterNotNull(r33);
        if (r34 == null) goto L219;
        Iterator r35 = r34.iterator();
    L112:
        if (r35.hasNext() == false) goto L219;
        com.larus.platform.model.action.a.f r36 = (com.larus.platform.model.action.a) r35.next();
        if ((r36 instanceof com.larus.platform.model.action.a.a) == true) goto L115;
        if ((r36 instanceof com.larus.platform.model.action.a.b) == true) goto L129;
        if ((r36 instanceof com.larus.platform.model.action.a.d) == true) goto L143;
        if ((r36 instanceof com.larus.platform.model.action.a.c) == true) goto L152;
        if ((r36 instanceof com.larus.platform.model.action.a.e) == true) goto L164;
        if ((r36 instanceof com.larus.platform.model.action.a.f) == false) goto L217;
        FLogger r37 = FLogger.a;
        StringBuilder r38 = new StringBuilder("SetMessageExt ");
        com.larus.platform.model.action.a.f r39 = r36;
        r38.append(r39.a());
        r37.i("CameraSuggestedActionListBuilder", r38.toString());
        Iterator r40 = ((Iterable) r1.element).iterator();
        int r41 = 0;
    L193:
        if (r40.hasNext() == false) goto L112;
        Object r42 = r40.next();
        int r43 = r41 + 1;
        if (r41 >= 0) goto L197;
        CollectionsKt.throwIndexOverflow();
    L197:
        SuggestedAction r111 = (SuggestedAction) r42;
        if (r111.getMsgExt() != null) goto L200;
        ListProtector.set((List) r1.element, r41, SuggestedAction.copy$default(r111, null, 0, 0, null, false, null, null, null, null, null, null, new LinkedHashMap(), 2047, null));
    L200:
        Map r44 = r39.a();
        if (r44 == null) goto L215;
        Iterator r45 = r44.entrySet().iterator();
    L204:
        if (r45.hasNext() == false) goto L215;
        Map.Entry r112 = (Map.Entry) r45.next();
        Map r113 = ((SuggestedAction) ListProtector.get((List) r1.element, r41)).getMsgExt();
        if (r113 != null) goto L208;
    L210:
        boolean r114 = false;
    L211:
        if (r114 == true) goto L204;
        Map r115 = ((SuggestedAction) ListProtector.get((List) r1.element, r41)).getMsgExt();
        if (r115 == null) goto L204;
        String r116 = (String) r115.put(r112.getKey(), r112.getValue());
        goto L204
    L208:
        if (r113.containsKey(r112.getKey()) != true) goto L210;
        r114 = true;
    L215:
        r41 = r43;
        goto L193
    L217:
        throw new NoWhenBranchMatchedException();
    L164:
        FLogger r46 = FLogger.a;
        StringBuilder r47 = new StringBuilder("SetEventExtra ");
        com.larus.platform.model.action.a.e r48 = (com.larus.platform.model.action.a.e) r36;
        r47.append(r48.a());
        r46.i("CameraSuggestedActionListBuilder", r47.toString());
        Iterator r49 = ((Iterable) r1.element).iterator();
        int r50 = 0;
    L166:
        if (r49.hasNext() == false) goto L112;
        Object r51 = r49.next();
        int r52 = r50 + 1;
        if (r50 >= 0) goto L170;
        CollectionsKt.throwIndexOverflow();
    L170:
        SuggestedAction r117 = (SuggestedAction) r51;
        if (r117.getEventExtra() != null) goto L173;
        ListProtector.set((List) r1.element, r50, SuggestedAction.copy$default(r117, null, 0, 0, null, false, null, null, null, null, new LinkedHashMap(), null, null, 3583, null));
    L173:
        Map r53 = r48.a();
        if (r53 == null) goto L188;
        Iterator r54 = r53.entrySet().iterator();
    L177:
        if (r54.hasNext() == false) goto L188;
        Map.Entry r118 = (Map.Entry) r54.next();
        Map r119 = ((SuggestedAction) ListProtector.get((List) r1.element, r50)).getEventExtra();
        if (r119 != null) goto L181;
    L183:
        boolean r120 = false;
    L184:
        if (r120 == true) goto L177;
        Map r121 = ((SuggestedAction) ListProtector.get((List) r1.element, r50)).getEventExtra();
        if (r121 == null) goto L177;
        String r122 = (String) r121.put(r118.getKey(), r118.getValue());
        goto L177
    L181:
        if (r119.containsKey(r118.getKey()) != true) goto L183;
        r120 = true;
    L188:
        r50 = r52;
        goto L166
    L152:
        Iterator r55 = ((Iterable) r1.element).iterator();
        int r56 = 0;
    L154:
        if (r55.hasNext() == false) goto L112;
        Object r57 = r55.next();
        int r58 = r56 + 1;
        if (r56 >= 0) goto L158;
        CollectionsKt.throwIndexOverflow();
    L158:
        SuggestedAction r59 = (SuggestedAction) r57;
        com.larus.platform.model.action.a.c r123 = (com.larus.platform.model.action.a.c) r36;
        if (((Boolean) r123.a.invoke(r59)).booleanValue() == false) goto L161;
        ListProtector.set((List) r1.element, r56, r123.b.invoke(r59));
        FLogger.a.i("CameraSuggestedActionListBuilder", "Modify result: " + ListProtector.get((List) r1.element, r56));
    L161:
        r56 = r58;
        goto L154
    L143:
        Iterable r60 = (Iterable) r1.element;
        ArrayList r61 = new ArrayList();
        Iterator r62 = r60.iterator();
    L145:
        if (r62.hasNext() == false) goto L149;
        Object r63 = r62.next();
        if ((!((Boolean) ((com.larus.platform.model.action.a.d) r36).a.invoke((SuggestedAction) r63)).booleanValue()) == false) goto L145;
        r61.add(r63);
        goto L145
    L149:
        r1.element = CollectionsKt.toMutableList(r61);
        FLogger.a.i("CameraSuggestedActionListBuilder", "Remove result size: " + ((List) r1.element).size());
        goto L112
    L129:
        FLogger r64 = FLogger.a;
        StringBuilder r65 = new StringBuilder("Insert last: ");
        com.larus.platform.model.action.a.b r66 = (com.larus.platform.model.action.a.b) r36;
        r65.append(r66.b());
        r65.append(", deDup = ");
        r65.append(r66.a());
        r65.append(", current size: ");
        r65.append(((List) r1.element).size());
        r64.i("CameraSuggestedActionListBuilder", r65.toString());
        SuggestedAction r67 = r66.b();
        if (r67 == null) goto L112;
        if (r66.a() == false) goto L140;
        Iterable r68 = (Iterable) r1.element;
        ArrayList r69 = new ArrayList();
        Iterator r70 = r68.iterator();
    L135:
        if (r70.hasNext() == false) goto L139;
        Object r71 = r70.next();
        if ((!Intrinsics.areEqual(((SuggestedAction) r71).getDisplayName(), r67.getDisplayName())) == false) goto L135;
        r69.add(r71);
        goto L135
    L139:
        r1.element = CollectionsKt.toMutableList(r69);
    L140:
        ((List) r1.element).add(r67);
        goto L112
    L115:
        FLogger r72 = FLogger.a;
        StringBuilder r73 = new StringBuilder("Insert first: ");
        com.larus.platform.model.action.a.a r74 = (com.larus.platform.model.action.a.a) r36;
        r73.append(r74.b());
        r73.append(", deDup = ");
        r73.append(r74.a());
        r73.append(", current size: ");
        r73.append(((List) r1.element).size());
        r72.i("CameraSuggestedActionListBuilder", r73.toString());
        SuggestedAction r75 = r74.b();
        if (r75 == null) goto L112;
        if (r74.a() == false) goto L126;
        Iterable r76 = (Iterable) r1.element;
        ArrayList r77 = new ArrayList();
        Iterator r78 = r76.iterator();
    L121:
        if (r78.hasNext() == false) goto L125;
        Object r79 = r78.next();
        if ((!Intrinsics.areEqual(((SuggestedAction) r79).getDisplayName(), r75.getDisplayName())) == false) goto L121;
        r77.add(r79);
        goto L121
    L125:
        r1.element = CollectionsKt.toMutableList(r77);
    L126:
        ListProtector.add((List) r1.element, 0, r75);
    L219:
        return (List) r1.element;
    L105:
        r32 = new ArrayList();
        goto L106
    L88:
        if (r23.isEmpty() == true) goto L91;
        r24 = false;
        goto L92
    L294:
        return r4;
    L79:
        if (r21.isEmpty() == true) goto L82;
        r22 = false;
        goto L83
    L293:
        return r4;
    L25:
        r6 = 0;
    L18:
        r6 = 0;
        goto L19
    }
}
