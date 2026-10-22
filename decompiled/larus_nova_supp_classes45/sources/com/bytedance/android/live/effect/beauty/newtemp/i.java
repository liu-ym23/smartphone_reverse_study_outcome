package com.bytedance.android.live.effect.beauty.newtemp;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.j;
import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i {
    public static final LiveEffectContextFactoryDelegate$Type a = null;
    public static final a b = null;

    static {
        a = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        b = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r6v20, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v5 */
    public static void a(List r24) {
        Intrinsics.checkNotNullParameter(r24, "list");
        List<String> r1 = LiveEffectContext.h;
        j r2 = LiveEffectContext.a.a(a).b();
        List<Sticker> r3 = r2.g().b;
        ArrayList<Sticker> r4 = ((com.bytedance.android.live.effect.beauty.makeups.d) r2.f()).a;
        List<Sticker> r5 = r2.m().b;
        StringBuilder r6 = new StringBuilder("assembleSubItems, beauty = ");
        CopyOnWriteArrayList r7 = (CopyOnWriteArrayList) r3;
        r6.append(r7.size());
        r6.append(", makeup = ");
        r6.append(r4.size());
        r6.append(", filter = ");
        ArrayList r8 = (ArrayList) r5;
        r6.append(r8.size());
        ALogger.i("ttlive_inspiration_panel", r6.toString());
        Iterator r0 = r24.iterator();
    L4:
        if (r0.hasNext() == false) goto L151;
        Sticker r9 = (Sticker) r0.next();
        Intrinsics.checkNotNullParameter(r9, "sticker");
        Intrinsics.checkNotNullParameter(r7, "beautyList");
        Intrinsics.checkNotNullParameter(r4, "makeupList");
        Intrinsics.checkNotNullParameter(r8, "filterList");
        ?? r11 = r9.getComposerConfigList();
        if (r11.isEmpty() == false) goto L8;
        Iterator r22 = r0;
    L150:
        r0 = r22;
        goto L4
    L8:
        Iterable r12 = (Iterable) r11;
        Iterator r13 = r12.iterator();
    L9:
        Object r14 = null;
        if (r13.hasNext() == false) goto L14;
        Object r15 = r13.next();
        if (Intrinsics.areEqual(((Sticker.ComposerConfig) r15).getType(), "MAKEUP") == false) goto L9;
    L16:
        if (r15 == null) goto L23;
        r11 = new ArrayList();
        Iterator r16 = r12.iterator();
    L19:
        if (r16.hasNext() == false) goto L23;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((Sticker.ComposerConfig) r17).getType(), "FILTER") == true) goto L19;
        r11.add(r17);
    L23:
        LinkedHashSet r18 = new LinkedHashSet();
        if ((!r9.getSubItemStickerList().isEmpty()) == false) goto L26;
        r18.addAll(r9.getSubItemStickerList());
    L26:
        LinkedHashMap r19 = new LinkedHashMap();
        Iterator r110 = r18.iterator();
    L27:
        ?? r111 = 0;
        if (r110.hasNext() == false) goto L39;
        Object r112 = r110.next();
        LocalSubStickerItem r113 = (LocalSubStickerItem) r112;
        if (Intrinsics.areEqual(r113.getType(), "MAKEUP") == false) goto L32;
    L35:
        boolean r114 = true;
    L36:
        if (r114 == false) goto L27;
    L40:
        if (r112 == null) goto L42;
        boolean r115 = true;
    L43:
        Iterator r21 = ((Iterable) r11).iterator();
    L45:
        if (r21.hasNext() == false) goto L149;
        Sticker.ComposerConfig r116 = (Sticker.ComposerConfig) r21.next();
        String r117 = r116.getName();
        if (r117.length() != 0) goto L49;
        boolean r118 = true;
    L50:
        if (r118 == false) goto L52;
        Iterator r23 = r0;
        Iterator r25 = r21;
    L148:
        r0 = r23;
        r21 = r25;
        r14 = null;
        r111 = 0;
        goto L45
    L52:
        r23 = r0;
        r25 = r21;
        if (StringsKt.contains$default(r117, "#", r111, 2, r14) == false) goto L58;
        List r26 = StringsKt.split$default(r117, new String[]{"#"}, false, 0, 6, null);
        if (r26.size() < 2) goto L148;
        r116.setType((String) ListProtector.get(r26, r111));
        r116.setName((String) ListProtector.get(r26, 1));
    L58:
        String r27 = r116.getName();
        LocalSubStickerItem r28 = new LocalSubStickerItem();
        r28.setType(r116.getType());
        r28.setResId(r27);
        r28.setTag(r116.getTag());
        if ((!Intrinsics.areEqual(r28.getType(), "MAKEUP")) == false) goto L64;
        if (r18.contains(r28) == true) goto L148;
    L64:
        if (Intrinsics.areEqual(r28.getType(), "MAKEUP") == false) goto L81;
        Iterator r119 = r18.iterator();
    L67:
        if (r119.hasNext() == false) goto L77;
        Object r120 = r119.next();
        LocalSubStickerItem r121 = (LocalSubStickerItem) r120;
        if (Intrinsics.areEqual(r121.getTag(), r28.getTag()) == true) goto L71;
    L73:
        boolean r122 = false;
    L74:
        if (r122 == false) goto L67;
    L78:
        if (r120 == null) goto L81;
    L71:
        if (Intrinsics.areEqual(r121.getResId(), r28.getResId()) == false) goto L73;
        r122 = true;
        goto L74
    L77:
        r120 = null;
    L81:
        if (Intrinsics.areEqual(r28.getType(), "BEAUTY") == false) goto L98;
        Iterator r123 = r7.iterator();
    L84:
        if (r123.hasNext() == false) goto L88;
        Object r124 = r123.next();
        if (Intrinsics.areEqual(((Sticker) r124).getResourceId(), r27) == false) goto L84;
    L89:
        r28.setMappingSticker((Sticker) r124);
        if (r28.getMappingSticker() == null) goto L96;
        r28.getConfigList().add(r116);
        StringBuilder r125 = new StringBuilder("assembleSubItem, add beauty item, ");
        r125.append(r27);
        r125.append(' ');
        Sticker r29 = r28.getMappingSticker();
        if (r29 == null) goto L94;
        String r31 = r29.getName();
    L95:
        r125.append(r31);
        ALogger.i("ttlive_inspiration_panel", r125.toString());
        r18.add(r28);
        goto L148
    L94:
        r31 = null;
        goto L95
    L96:
        ALogger.i("ttlive_inspiration_panel", "assembleSubItem, not find beauty, " + r27);
        goto L148
    L88:
        r124 = null;
        goto L89
    L98:
        if (Intrinsics.areEqual(r28.getType(), "MAKEUP") == false) goto L129;
        if (r19.get(r27) != null) goto L117;
        if (r115 == true) goto L116;
        Iterator<Sticker> r126 = r4.iterator();
    L104:
        if (r126.hasNext() == false) goto L108;
        Sticker r127 = r126.next();
        if (Intrinsics.areEqual(r127.getResourceId(), r27) == false) goto L104;
    L109:
        r28.setMappingSticker(r127);
        if (r28.getMappingSticker() == null) goto L148;
        r28.getConfigList().add(r116);
        r19.put(r27, r28);
        StringBuilder r128 = new StringBuilder("assembleSubItem, add makeup item, ");
        r128.append(r27);
        r128.append(' ');
        Sticker r32 = r28.getMappingSticker();
        if (r32 == null) goto L114;
        String r33 = r32.getName();
    L115:
        r128.append(r33);
        ALogger.i("ttlive_inspiration_panel", r128.toString());
        r18.add(r28);
    L146:
        r115 = true;
        goto L148
    L114:
        r33 = null;
        goto L115
    L108:
        r127 = null;
        goto L109
    L116:
        ALogger.i("ttlive_inspiration_panel", "assembleSubItem, not find makeup, " + r27);
        goto L148
    L117:
        StringBuilder r34 = new StringBuilder("assembleSubItem, add makeup config, ");
        r34.append(r27);
        r34.append(' ');
        LocalSubStickerItem r129 = (LocalSubStickerItem) r19.get(r27);
        if (r129 == null) goto L122;
        Sticker r130 = r129.getMappingSticker();
        if (r130 == null) goto L122;
        String r131 = r130.getName();
    L123:
        r34.append(r131);
        ALogger.i("ttlive_inspiration_panel", r34.toString());
        LocalSubStickerItem r35 = (LocalSubStickerItem) r19.get(r27);
        if (r35 == null) goto L148;
        ArrayList r36 = r35.getConfigList();
        if (r36 == null) goto L148;
        r36.add(r116);
    L122:
        r131 = null;
        goto L123
    L129:
        if (Intrinsics.areEqual(r28.getType(), "FILTER") == false) goto L148;
        Iterator r132 = r8.iterator();
    L132:
        if (r132.hasNext() == false) goto L136;
        Object r133 = r132.next();
        if (Intrinsics.areEqual(((Sticker) r133).getResourceId(), r27) == false) goto L132;
    L137:
        r28.setMappingSticker((Sticker) r133);
        if (r115 == false) goto L140;
    L147:
        ALogger.i("ttlive_inspiration_panel", "assembleSubItem, not find filter, " + r27);
        goto L148
    L140:
        if (r28.getMappingSticker() == null) goto L147;
        r28.getConfigList().add(r116);
        StringBuilder r134 = new StringBuilder("assembleSubItem, add filter item, ");
        r134.append(r27);
        r134.append(' ');
        Sticker r37 = r28.getMappingSticker();
        if (r37 == null) goto L144;
        String r38 = r37.getName();
    L145:
        r134.append(r38);
        ALogger.i("ttlive_inspiration_panel", r134.toString());
        r18.add(r28);
        goto L146
    L144:
        r38 = null;
        goto L145
    L136:
        r133 = null;
        goto L137
    L49:
        r118 = false;
        goto L50
    L149:
        r22 = r0;
        r9.setSubItemStickerList(CollectionsKt.toList(r18));
        goto L150
    L42:
        r115 = false;
        goto L43
    L32:
        if (Intrinsics.areEqual(r113.getType(), "FILTER") == true) goto L35;
        r114 = false;
        goto L36
    L39:
        r112 = null;
        goto L40
    L14:
        r15 = null;
        goto L16
    }
}
