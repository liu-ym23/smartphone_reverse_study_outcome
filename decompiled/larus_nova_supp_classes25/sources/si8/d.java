package si8;

import com.larus.bmhome.chat.search.ArticleInfo;
import com.larus.bmhome.chat.search.MoreInfo;
import com.larus.bmhome.chat.search.SkeletonInfo;
import com.larus.bmhome.chat.search.VideoInfo;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oi8.k;
import pi8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d implements pi8.a {
    public d() {
    }

    @Override // pi8.a
    public final o a(k r37, oi8.c r38) {
        k r0 = r37;
        Intrinsics.checkNotNullParameter(r0, "originData");
        int r1 = com.larus.bmhome.chat.search.a.a;
        Intrinsics.checkNotNullParameter(r0, "data");
        List<ArticleInfo> r2 = null;
        if (r38 == null) goto L86;
        Integer r4 = r38.a();
        if (r4 != null) goto L9;
    L20:
        Integer r5 = r38.a();
        if (r5 != null) goto L24;
    L35:
        Integer r6 = r38.a();
        if (r6 != null) goto L39;
    L50:
        Integer r7 = r38.a();
        if (r7 == null) goto L86;
        if (r7.intValue() != 5) goto L86;
        Integer r8 = r38.b();
        if (r8 == null) goto L86;
        if (r8.intValue() != 2) goto L86;
        com.larus.bmhome.chat.search.b r9 = r37.e();
        if (r9 == null) goto L72;
        com.larus.bmhome.chat.search.b.c r10 = r9.e();
        if (r10 == null) goto L72;
        List<ArticleInfo> r11 = r10.a();
        if (r11 == null) goto L72;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L68:
        if (r13.hasNext() == false) goto L73;
        Object r14 = r13.next();
        if (o0.d(((ArticleInfo) r14).getImageUrl()) == false) goto L68;
        r12.add(r14);
    L73:
        com.larus.bmhome.chat.search.b r15 = r37.e();
        if (r15 == null) goto L84;
        com.larus.bmhome.chat.search.b r16 = r37.e();
        if (r16 == null) goto L82;
        List r17 = r12;
        if (r16.e() == null) goto L82;
        if (r12 != null) goto L81;
        r17 = CollectionsKt.emptyList();
    L81:
        com.larus.bmhome.chat.search.b.c r18 = new com.larus.bmhome.chat.search.b.c(r17);
    L83:
        com.larus.bmhome.chat.search.b r19 = com.larus.bmhome.chat.search.b.a(r15, r18, 29);
    L85:
        r0 = k.a(r0, r19);
    L82:
        r18 = null;
        goto L83
    L84:
        r19 = null;
    L72:
        r12 = null;
        goto L73
    L39:
        if (r6.intValue() != 4) goto L50;
        Integer r20 = r38.b();
        if (r20 == null) goto L50;
        if (r20.intValue() != 3) goto L50;
        com.larus.bmhome.chat.search.b r21 = r37.e();
        if (r21 == null) goto L48;
        com.larus.bmhome.chat.search.b r22 = com.larus.bmhome.chat.search.b.a(r21, null, 29);
    L49:
        r0 = k.a(r0, r22);
        goto L86
    L48:
        r22 = null;
        goto L49
    L24:
        if (r5.intValue() != 1) goto L35;
        Integer r23 = r38.b();
        if (r23 == null) goto L35;
        if (r23.intValue() != 3) goto L35;
        com.larus.bmhome.chat.search.b r24 = r37.e();
        if (r24 == null) goto L33;
        com.larus.bmhome.chat.search.b r25 = com.larus.bmhome.chat.search.b.a(r24, null, 29);
    L34:
        r0 = k.a(r0, r25);
        goto L86
    L33:
        r25 = null;
        goto L34
    L9:
        if (r4.intValue() != 1) goto L20;
        Integer r26 = r38.b();
        if (r26 == null) goto L20;
        if (r26.intValue() != 1) goto L20;
        com.larus.bmhome.chat.search.b r27 = r37.e();
        if (r27 == null) goto L18;
        com.larus.bmhome.chat.search.b r28 = com.larus.bmhome.chat.search.b.a(r27, null, 30);
    L19:
        r0 = k.a(r0, r28);
        goto L86
    L18:
        r28 = null;
    L86:
        com.larus.bmhome.chat.search.b r29 = r0.e();
        if (r29 == null) goto L91;
        com.larus.bmhome.chat.search.b.d r30 = r29.f();
        if (r30 == null) goto L91;
        List<VideoInfo> r31 = r30.a();
    L92:
        List<VideoInfo> r32 = r31;
        int r33 = 0;
        if (r32 != null) goto L95;
    L98:
        boolean r34 = true;
    L99:
        com.larus.bmhome.chat.search.b r35 = r0.e();
        if (r35 == null) goto L104;
        com.larus.bmhome.chat.search.b.c r36 = r35.e();
        if (r36 == null) goto L104;
        List<ArticleInfo> r39 = r36.a();
    L105:
        List<ArticleInfo> r40 = r39;
        if (r40 != null) goto L108;
    L111:
        boolean r41 = true;
    L112:
        if (r34 == false) goto L116;
        if (r41 == false) goto L116;
        boolean r42 = false;
    L117:
        ArrayList r43 = new ArrayList();
        if (r34 == false) goto L123;
        if (r41 == false) goto L123;
    L121:
        if (r33 >= 3) goto L163;
        r43.add(new SkeletonInfo("search_skeleton_item_" + r33));
        r33 = r33 + 1;
    L163:
        MoreInfo r3 = r0.c();
        if (r3 == null) goto L167;
        r43.add(r3);
    L167:
        return new o(r43, r42);
    L123:
        if (r34 == false) goto L132;
        com.larus.bmhome.chat.search.b r44 = r0.e();
        if (r44 == null) goto L129;
        com.larus.bmhome.chat.search.b.c r45 = r44.e();
        if (r45 == null) goto L129;
        r2 = r45.a();
    L129:
        if (r2 != null) goto L131;
        r2 = CollectionsKt.emptyList();
    L131:
        r43.addAll(r2);
        goto L163
    L132:
        if (r41 == false) goto L146;
        com.larus.bmhome.chat.search.b r46 = r0.e();
        if (r46 == null) goto L163;
        com.larus.bmhome.chat.search.b.d r47 = r46.f();
        if (r47 == null) goto L163;
        List<VideoInfo> r48 = r47.a();
        if (r48 == null) goto L163;
        Iterator<T> r49 = r48.iterator();
    L141:
        if (r49.hasNext() == false) goto L163;
        Object r50 = r49.next();
        int r51 = r33 + 1;
        if (r33 >= 0) goto L145;
        CollectionsKt.throwIndexOverflow();
    L145:
        VideoInfo r52 = VideoInfo.copy$default((VideoInfo) r50, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777215, null);
        r52.setVideoInfoList(new ArrayList(r48));
        r52.setVideoIndex(r33);
        r43.add(r52);
        r33 = r51;
        goto L141
    L146:
        com.larus.bmhome.chat.search.b r53 = r0.e();
        if (r53 == null) goto L155;
        com.larus.bmhome.chat.search.b.d r54 = r53.f();
        if (r54 == null) goto L155;
        List<VideoInfo> r55 = r54.a();
        if (r55 == null) goto L155;
        VideoInfo r56 = (VideoInfo) CollectionsKt.firstOrNull(r55);
        if (r56 == null) goto L155;
        ArrayList r57 = new ArrayList();
        VideoInfo r58 = VideoInfo.copy$default(r56, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777215, null);
        r58.setVideoInfoList(null);
        r57.add(r58);
        r57.addAll(r55.subList(1, r55.size()));
        r56.setVideoInfoList(r57);
        r43.add(r56);
    L155:
        com.larus.bmhome.chat.search.b r59 = r0.e();
        if (r59 == null) goto L160;
        com.larus.bmhome.chat.search.b.c r60 = r59.e();
        if (r60 == null) goto L160;
        r2 = r60.a();
    L160:
        if (r2 != null) goto L162;
        r2 = CollectionsKt.emptyList();
    L162:
        r43.addAll(r2);
    L116:
        r42 = true;
        goto L117
    L108:
        if (r40.isEmpty() == true) goto L111;
        r41 = false;
    L104:
        r39 = null;
        goto L105
    L95:
        if (r32.isEmpty() == true) goto L98;
        r34 = false;
    L91:
        r31 = null;
        goto L92
    }
}
