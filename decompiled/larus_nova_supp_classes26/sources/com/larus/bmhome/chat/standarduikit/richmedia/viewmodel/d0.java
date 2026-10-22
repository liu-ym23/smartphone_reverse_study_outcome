package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Cover;
import com.larus.im.bean.message.CreationGenDetail;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.ImagePlaceHolder;
import com.larus.im.bean.message.VideoData;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.RichMediaItem;
import com.larus.im.bean.message.block.RichMediaLayoutBlock;
import com.larus.im.bean.message.block.RichMediaType;
import com.larus.im.bean.message.block.SearchImageItem;
import com.larus.im.bean.message.block.SearchVideoItem;
import com.larus.platform.model.video.business.EnterVideoMethod;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d0 {
    public final e0 a;
    public final f0 b;
    public final List<fn8.c> c;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final String g;
        public final String h;
        public final boolean i;
        public final boolean j;
        public final List<Integer> k;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
            return false;
        L41:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            String r1 = this.e;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.g;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.h;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            int r14 = 1231;
            if (this.i == false) goto L21;
            int r15 = 1231;
        L22:
            int r16 = (r13 + r15) * 31;
            if (this.j == true) goto L26;
            r14 = 1237;
        L26:
            int r17 = (r16 + r14) * 31;
            List<Integer> r18 = this.k;
            if (r18 == null) goto L31;
            r2 = r18.hashCode();
        L31:
            return r17 + r2;
        L21:
            r15 = 1237;
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "CreationTrackParams(position=" + this.a + ", cardId=" + this.b + ", cardType=" + this.c + ", moduleSource=" + this.d + ", picId=" + this.e + ", videoId=" + this.f + ", requestId=" + this.g + ", creationTaskId=" + this.h + ", isReplicaGen=" + this.i + ", isImageEdit=" + this.j + ", imageResolution=" + this.k + ')';
        }

        public b(int r3, String r4, String r5, String r6, String r7, String r8, String r9, boolean r10, boolean r11, List r12) {
            Intrinsics.checkNotNullParameter(r4, "cardId");
            Intrinsics.checkNotNullParameter(r5, "cardType");
            Intrinsics.checkNotNullParameter("slideshow", "moduleSource");
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = "slideshow";
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
        }
    }

    public static final class c {
        public final String a;
        public final String b;
        public final int c;
        public final int d;
        public final String e;
        public final String f;
        public final String g;
        public final List<Integer> h;
        public final String i;
        public final String j;
        public final i0 k;

        public c() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
            return false;
        L41:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (((((r3 + r5) * 31) + this.c) * 31) + this.d) * 31;
            String r7 = this.e;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.f;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.g;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            List<Integer> r16 = this.h;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r18 = (r15 + r17) * 31;
            String r19 = this.i;
            if (r19 != null) goto L29;
            int r20 = 0;
        L30:
            int r21 = (r18 + r20) * 31;
            String r22 = this.j;
            if (r22 != null) goto L33;
            int r23 = 0;
        L34:
            int r24 = (r21 + r23) * 31;
            i0 r25 = this.k;
            if (r25 == null) goto L39;
            r1 = r25.hashCode();
        L39:
            return r24 + r1;
        L33:
            r23 = r22.hashCode();
            goto L34
        L29:
            r20 = r19.hashCode();
            goto L30
        L25:
            r17 = r16.hashCode();
            goto L26
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "MixedRichMediaShowParams(messageId=" + this.a + ", cardId=" + this.b + ", cardPosition=" + this.c + ", cardSubPosition=" + this.d + ", cardType=" + this.e + ", replyId=" + this.f + ", moduleSource=" + this.g + ", imageResolution=" + this.h + ", richMediaType=" + this.i + ", creationTaskId=" + this.j + ", traceContext=" + this.k + ')';
        }

        public c(String r3, String r4, int r5, int r6, String r7, String r8, String r9, List r10, String r11, String r12, i0 r13, int r14) {
            if ((r14 & 128) == 0) goto L6;
            r10 = null;
        L6:
            if ((r14 & 256) == 0) goto L9;
            r11 = null;
        L9:
            if ((r14 & 512) == 0) goto L12;
            r12 = null;
        L12:
            if ((r14 & 1024) == 0) goto L14;
            r13 = null;
        L14:
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r11;
            this.j = r12;
            this.k = r13;
        }
    }

    public static final class d {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final List<Integer> g;
        public final String h;
        public final String i;
        public final String j;
        public final String k;
        public final Map<String, Object> l;

        public d() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.l, r6.l) == true) goto L44;
            return false;
        L44:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            String r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.d;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.e;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.f;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            List<Integer> r14 = this.g;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.h;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            String r20 = this.i;
            if (r20 != null) goto L29;
            int r21 = 0;
        L30:
            int r22 = (r19 + r21) * 31;
            String r23 = this.j;
            if (r23 != null) goto L33;
            int r24 = 0;
        L34:
            int r25 = (r22 + r24) * 31;
            String r26 = this.k;
            if (r26 == null) goto L39;
            r2 = r26.hashCode();
        L39:
            return ((r25 + r2) * 31) + this.l.hashCode();
        L33:
            r24 = r23.hashCode();
            goto L34
        L29:
            r21 = r20.hashCode();
            goto L30
        L25:
            r18 = r17.hashCode();
            goto L26
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "SearchTrackParams(cardId=" + this.a + ", cardType=" + this.b + ", picId=" + this.c + ", moduleSource=" + this.d + ", videoId=" + this.e + ", slideMode=" + this.f + ", imageResolution=" + this.g + ", toolName=" + this.h + ", docId=" + this.i + ", hostEnterFrom=" + this.j + ", searchId=" + this.k + ", eventExtra=" + this.l + ')';
        }

        public d(String r4, String r5, String r6, String r7, String r8, List r9, String r10, String r11, String r12, String r13, Map r14, int r15) {
            if ((r15 & 4) == 0) goto L6;
            r6 = null;
        L6:
            if ((r15 & 8) == 0) goto L8;
            String r0 = null;
        L10:
            if ((r15 & 16) == 0) goto L13;
            r7 = null;
        L13:
            if ((r15 & 32) == 0) goto L16;
            r8 = null;
        L16:
            if ((r15 & 64) == 0) goto L19;
            r9 = null;
        L19:
            if ((r15 & 128) == 0) goto L22;
            r10 = null;
        L22:
            if ((r15 & 256) == 0) goto L25;
            r11 = null;
        L25:
            if ((r15 & 512) == 0) goto L28;
            r12 = null;
        L28:
            if ((r15 & 1024) == 0) goto L30;
            r13 = null;
        L30:
            Intrinsics.checkNotNullParameter(r4, "cardId");
            Intrinsics.checkNotNullParameter(r5, "cardType");
            Intrinsics.checkNotNullParameter(r14, "eventExtra");
            this.a = r4;
            this.b = r5;
            this.c = r6;
            this.d = r0;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r11;
            this.j = r12;
            this.k = r13;
            this.l = r14;
            return;
        L8:
            r0 = "slideshow";
            goto L10
        }
    }

    static {
    }

    public final String a() {
        f0 r0 = this.b;
        if (r0 == null) goto L7;
        String r1 = r0.getBotId();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return this.a.a.getSenderId();
    }

    public final String b() {
        Map r0 = this.a.a.getExt();
        if (r0 == null) goto L7;
        String r1 = (String) r0.get("rich_media_type");
        if (r1 == null) goto L7;
        return r1;
    L7:
        List r2 = com.larus.im.bean.message.a.d(this.a.a);
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L20;
        Block r5 = (Block) r4.next();
        BlockContent r6 = r5.getContent();
        if (r6 == null) goto L13;
        RichMediaLayoutBlock r7 = r6.getRichMediaLayoutBlock();
    L15:
        if (r5.getBlockType() != BlockType.BLOCK_TYPE_RICH_MEDIA_LAYOUT.getValue()) goto L18;
        if (r7 == null) goto L18;
        List r8 = r7.richMediaItem;
    L19:
        CollectionsKt.addAll(r3, r8);
    L18:
        r8 = CollectionsKt.emptyList();
        goto L19
    L13:
        r7 = null;
        goto L15
    L20:
        boolean r9 = r3.isEmpty();
        List<RichMediaItem> r10 = r3;
        if (r9 == false) goto L23;
        r10 = this.a.d;
    L23:
        List<RichMediaItem> r11 = r10;
        boolean r12 = true;
        if ((!r11.isEmpty()) == false) goto L44;
        List<RichMediaItem> r13 = r11;
        if ((r13 instanceof Collection) == true) goto L28;
    L30:
        Iterator r14 = r13.iterator();
    L32:
        if (r14.hasNext() == false) goto L42;
        Integer r15 = ((RichMediaItem) r14.next()).type;
        int r16 = RichMediaType.SEARCH_IMAGE.getValue();
        if (r15 != null) goto L37;
    L39:
        boolean r17 = false;
    L40:
        if (r17 == true) goto L32;
        r12 = false;
        goto L42
    L37:
        if (r15.intValue() != r16) goto L39;
        r17 = true;
    L42:
        if (r12 == false) goto L44;
        return "only_picture";
    L28:
        if (r13.isEmpty() == false) goto L30;
    L44:
        return "mixed_picture";
    }

    public static void g(c r4) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.putOpt(MusicAppletPage.KEY_MESSAGE_ID, r4.a);
        r1.putOpt("card_id", r4.b);
        r1.putOpt("card_position", Integer.valueOf(r4.c));
        r1.putOpt("card_sub_position", Integer.valueOf(r4.d));
        r1.putOpt("card_type", r4.e);
        r1.putOpt("reply_id", r4.f);
        r1.putOpt("module_source", r4.g);
        ri8.c r2 = ri8.c.a;
        r1.putOpt("image_resolution", ri8.c.a(r4.h));
        r1.putOpt("rich_media_type", r4.i);
        r1.putOpt("creation_task_id", r4.j);
        i0 r5 = r4.k;
        if (r5 == null) goto L5;
        r5.a(r1);
    L5:
        Unit r6 = Unit.INSTANCE;
        r0.reportEvent("mixed_richmedia_show", r1);
    }

    public final d e(fn8.c r15) {
        LinkedHashMap r11 = new LinkedHashMap();
        String r0 = this.a.b;
        if (r0 == null) goto L5;
        r11.put("block_id", r0);
    L5:
        r11.put("loading_type", "normal");
        fn8.b r1 = r15.h;
        if ((r1 instanceof fn8.b.d) == false) goto L37;
        SearchImageItem r2 = ((fn8.b.d) r1).a;
        String r3 = r2.itemId;
        if (r3 == null) goto L10;
        r11.put("item_id", r3);
    L10:
        Long r4 = r2.id;
        if (r4 == null) goto L14;
        String r5 = r4.toString();
        if (r5 == null) goto L14;
    L17:
        Long r16 = r2.id;
        if (r16 == null) goto L21;
        String r17 = r16.toString();
        if (r17 == null) goto L21;
    L22:
        String r6 = r17;
        Integer[] r18 = new Integer[2];
        Integer r7 = r2.originWidth;
        int r8 = 0;
        if (r7 != null) goto L27;
        r7 = r2.width;
        if (r7 != null) goto L27;
        int r9 = 0;
    L29:
        r18[0] = Integer.valueOf(r9);
        Integer r10 = r2.originHeight;
        if (r10 != null) goto L34;
        r10 = r2.height;
        if (r10 != null) goto L34;
    L35:
        r18[1] = Integer.valueOf(r8);
        return new d(r5, "picture", r6, null, null, CollectionsKt.listOf(r18), r2.imageSource, r2.docId, null, r2.searchId, r11, 560);
    L34:
        r8 = r10.intValue();
    L27:
        r9 = r7.intValue();
    L21:
        r17 = r2.itemId;
    L14:
        r5 = r2.itemId;
        if (r5 != null) goto L17;
        r5 = r15.a;
        goto L17
    L37:
        if ((r1 instanceof fn8.b.e) == false) goto L50;
        SearchVideoItem r12 = ((fn8.b.e) r1).a;
        String r13 = r12.itemId;
        if (r13 == null) goto L41;
        r11.put("item_id", r13);
    L41:
        Long r14 = r12.id;
        if (r14 == null) goto L45;
        String r19 = r14.toString();
        if (r19 == null) goto L45;
    L48:
        String r20 = r12.itemId;
        String r21 = EnterVideoMethod.FLOW_CLICK_MIXED_VIDEO_CARD.getValue();
        return new d(r19, "video", null, r20, "normal_video", null, null, r12.itemId, r21, r12.searchId, r11, 196);
    L45:
        r19 = r12.itemId;
        if (r19 != null) goto L48;
        r19 = r15.a;
        goto L48
    L50:
        if ((r1 instanceof fn8.b.a) == false) goto L52;
    L58:
        return null;
    L52:
        if ((r1 instanceof fn8.b.C0108b) == true) goto L58;
        if ((r1 instanceof fn8.b.c) == true) goto L58;
        throw new NoWhenBranchMatchedException();
    }

    public final b c(CreationItem r19, int r20) {
        Integer r3 = r19.type;
        if (r3 != null) goto L6;
    L7:
        Integer r4 = r19.type;
        if (r4 != null) goto L11;
    L12:
        return null;
    L11:
        if (r4.intValue() != 2) goto L12;
    L13:
        List<RichMediaItem> r7 = this.a.d;
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r7.iterator();
    L15:
        if (r9.hasNext() == false) goto L19;
        CreationItem r10 = ((RichMediaItem) r9.next()).creation;
        if (r10 == null) goto L15;
        r8.add(r10);
        goto L15
    L19:
        Iterator r11 = r8.iterator();
        int r12 = 0;
        int r13 = 0;
    L21:
        if (r11.hasNext() == false) goto L86;
        CreationItem r14 = (CreationItem) r11.next();
        if (Intrinsics.areEqual(r14, r19) == false) goto L26;
        boolean r15 = true;
    L83:
        if (r15 == true) goto L87;
        r13 = r13 + 1;
    L87:
        if (r13 < 0) goto L89;
        int r16 = r13 + 1;
    L103:
        String r17 = r19.id;
        if (r17 != null) goto L155;
        Integer r18 = r19.type;
        if (r18 != null) goto L109;
    L123:
        if (r18 != null) goto L126;
    L154:
        String r2 = "creation-" + r20;
    L156:
        Integer r21 = r19.type;
        if (r21 != null) goto L160;
    L162:
        String r22 = "video";
    L163:
        String r110 = r22;
        Integer r23 = r19.type;
        if (r23 != null) goto L167;
    L171:
        if (r23 != null) goto L174;
    L193:
        String r111 = null;
    L194:
        VideoData r24 = r19.video;
        if (r24 == null) goto L197;
        String r112 = r24.vid;
    L198:
        Integer r25 = r19.type;
        if (r25 != null) goto L202;
    L206:
        String r113 = null;
    L207:
        String r114 = r19.id;
        CreationGenDetail r26 = r19.genDetail;
        if (r26 == null) goto L215;
        Integer r27 = r26.taskType;
        if (r27 == null) goto L215;
        if (r27.intValue() != 5) goto L215;
        boolean r115 = true;
    L216:
        CreationGenDetail r28 = r19.genDetail;
        if (r28 == null) goto L224;
        Integer r29 = r28.taskType;
        if (r29 == null) goto L224;
        if (r29.intValue() != 7) goto L224;
        boolean r5 = true;
    L225:
        Integer r30 = r19.type;
        if (r30 != null) goto L229;
    L254:
        List r116 = null;
    L256:
        return new b(r16, r2, r110, r111, r112, r113, r114, r115, r5, r116);
    L229:
        if (r30.intValue() != 1) goto L254;
        Integer[] r6 = new Integer[2];
        ImageData r31 = r19.image;
        if (r31 == null) goto L235;
        ImageObj r32 = r31.imageOrigin;
        if (r32 == null) goto L235;
        int r33 = r32.width;
    L242:
        r6[0] = Integer.valueOf(r33);
        ImageData r1 = r19.image;
        if (r1 == null) goto L247;
        ImageObj r34 = r1.imageOrigin;
        if (r34 == null) goto L247;
        r12 = r34.height;
    L253:
        r6[1] = Integer.valueOf(r12);
        r116 = CollectionsKt.listOf(r6);
    L247:
        if (r1 == null) goto L253;
        ImagePlaceHolder r35 = r1.placeholder;
        if (r35 == null) goto L253;
        Long r36 = r35.height;
        if (r36 == null) goto L253;
        r12 = (int) r36.longValue();
    L235:
        if (r31 == null) goto L241;
        ImagePlaceHolder r37 = r31.placeholder;
        if (r37 == null) goto L241;
        Long r38 = r37.width;
        if (r38 == null) goto L241;
        r33 = (int) r38.longValue();
    L241:
        r33 = 0;
    L224:
        r5 = false;
    L215:
        r115 = false;
        goto L216
    L202:
        if (r25.intValue() != 1) goto L206;
        ImageData r39 = r19.image;
        if (r39 == null) goto L206;
        r113 = r39.requestId;
        goto L207
    L197:
        r112 = null;
        goto L198
    L174:
        if (r23.intValue() != 2) goto L193;
        VideoData r40 = r19.video;
        if (r40 == null) goto L189;
        Cover r41 = r40.cover;
        if (r41 == null) goto L189;
        String r42 = r41.key;
        if (r42 == null) goto L189;
        if (r42.length() <= 0) goto L184;
        boolean r117 = true;
    L185:
        if (r117 == true) goto L188;
        r42 = null;
    L188:
        if (r42 == null) goto L189;
    L192:
        r111 = r42;
        goto L194
    L184:
        r117 = false;
    L189:
        VideoData r43 = r19.video;
        if (r43 == null) goto L193;
        r42 = r43.vid;
        goto L192
    L167:
        if (r23.intValue() != 1) goto L171;
        ImageData r44 = r19.image;
        if (r44 == null) goto L193;
        r42 = r44.key;
        goto L192
    L160:
        if (r21.intValue() != 1) goto L162;
        r22 = "picture";
        goto L163
    L126:
        if (r18.intValue() != 2) goto L154;
        VideoData r45 = r19.video;
        if (r45 == null) goto L139;
        r17 = r45.vid;
        if (r17 == null) goto L139;
        if (r17.length() <= 0) goto L134;
        boolean r118 = true;
    L135:
        if (r118 == true) goto L138;
        r17 = null;
    L138:
        if (r17 != null) goto L155;
    L134:
        r118 = false;
    L139:
        VideoData r46 = r19.video;
        if (r46 == null) goto L151;
        Cover r47 = r46.cover;
        if (r47 == null) goto L151;
        r17 = r47.key;
        if (r17 == null) goto L151;
        if (r17.length() <= 0) goto L148;
        boolean r119 = true;
    L149:
        if (r119 == false) goto L151;
    L152:
        if (r17 != null) goto L155;
        r2 = "creation-video-" + r20;
        goto L156
    L148:
        r119 = false;
    L151:
        r17 = null;
        goto L152
    L109:
        if (r18.intValue() != 1) goto L123;
        ImageData r48 = r19.image;
        if (r48 == null) goto L122;
        r17 = r48.key;
        if (r17 == null) goto L122;
        if (r17.length() <= 0) goto L117;
        boolean r120 = true;
    L118:
        if (r120 == true) goto L121;
        r17 = null;
    L121:
        if (r17 != null) goto L155;
    L117:
        r120 = false;
    L122:
        r2 = "creation-image-" + r20;
    L155:
        r2 = r17;
        goto L156
    L89:
        List r49 = CollectionsKt.take(this.c, r20 + 1);
        if ((r49 instanceof Collection) == true) goto L92;
    L94:
        Iterator r50 = r49.iterator();
        int r51 = 0;
    L96:
        if (r50.hasNext() == false) goto L102;
        if ((((fn8.c) r50.next()).h instanceof fn8.b.a) == false) goto L96;
        r51 = r51 + 1;
        if (r51 >= 0) goto L96;
        CollectionsKt.throwCountOverflow();
    L102:
        r16 = RangesKt.coerceAtLeast(r51, 1);
        goto L103
    L92:
        if (r49.isEmpty() == false) goto L94;
        r51 = 0;
        goto L102
    L26:
        if (Intrinsics.areEqual(r14.type, r19.type) == false) goto L82;
        String r121 = r14.id;
        if (r121 != null) goto L31;
    L39:
        Integer r122 = r14.type;
        if (r122 != null) goto L43;
    L61:
        if (r122 == null) goto L82;
        if (r122.intValue() != 2) goto L82;
        VideoData r123 = r14.video;
        if (r123 == null) goto L82;
        String r124 = r123.vid;
        if (r124 == null) goto L82;
        if (r124.length() <= 0) goto L72;
        boolean r125 = true;
    L73:
        if (r125 == true) goto L76;
        r124 = null;
    L76:
        if (r124 == null) goto L82;
        VideoData r126 = r19.video;
        if (r126 == null) goto L80;
        String r127 = r126.vid;
    L81:
        r15 = Intrinsics.areEqual(r124, r127);
        goto L83
    L80:
        r127 = null;
        goto L81
    L72:
        r125 = false;
        goto L73
    L43:
        if (r122.intValue() != 1) goto L61;
        ImageData r128 = r14.image;
        if (r128 == null) goto L82;
        String r129 = r128.key;
        if (r129 == null) goto L82;
        if (r129.length() <= 0) goto L51;
        boolean r130 = true;
    L52:
        if (r130 == true) goto L55;
        r129 = null;
    L55:
        if (r129 == null) goto L82;
        ImageData r131 = r19.image;
        if (r131 == null) goto L59;
        String r132 = r131.key;
    L60:
        r15 = Intrinsics.areEqual(r129, r132);
        goto L83
    L59:
        r132 = null;
        goto L60
    L51:
        r130 = false;
        goto L52
    L31:
        if (r121.length() <= 0) goto L33;
        boolean r133 = true;
    L34:
        if (r133 == true) goto L37;
        r121 = null;
    L37:
        if (r121 == null) goto L39;
        r15 = Intrinsics.areEqual(r121, r19.id);
        goto L83
    L33:
        r133 = false;
    L82:
        r15 = false;
        goto L83
    L86:
        r13 = -1;
        goto L87
    L6:
        if (r3.intValue() == 1) goto L13;
        goto L7
    }

    public final i0 f(fn8.c r3, int r4) {
        e0 r0 = this.a;
        return j0.b(r3, r0.a, r0.b, r4 + 1);
    }

    public d0(e0 r2, f0 r3, List<fn8.c> r4) {
        Intrinsics.checkNotNullParameter(r2, "vmData");
        Intrinsics.checkNotNullParameter(r4, "items");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static c d(b r14, String r15, String r16, int r17, int r18, i0 r19) {
        return new c(r15, r14.b, r17, r18, r14.c, r16, r14.d, r14.k, null, r14.h, r19, 256);
    }
}
