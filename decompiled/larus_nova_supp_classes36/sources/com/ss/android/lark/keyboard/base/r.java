package com.ss.android.lark.keyboard.base;

import android.content.Context;
import android.net.Uri;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class r {
    public final Context a;
    public final boolean b;
    public final boolean c;
    public Long d;
    public Boolean e;
    public String f;
    public String g;
    public String h;
    public final String i;
    public final List<UplinkFileEntity> j;
    public final List<ChatAttachmentEntity> k;
    public final String l;
    public final String m;
    public Integer n;
    public Integer o;
    public String p;
    public Uri q;
    public boolean r;
    public xcb.a s;
    public final boolean t;
    public final RichText u;
    public final boolean v;
    public final Map<String, ResourceUploadInfo> w;

    public r() {
        this(null, false, false, null, null, null, false, null, null, 8388607);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
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
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (this.r == r6.r) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
        return false;
    L66:
        if (this.t == r6.t) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r6.u) == true) goto L72;
        return false;
    L72:
        if (this.v == r6.v) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r6.w) == true) goto L77;
        return false;
    L77:
        return true;
    }

    public final int hashCode() {
        Context r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        int r4 = 1231;
        if (this.b == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.c == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        Long r9 = this.d;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        Boolean r12 = this.e;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        String r15 = this.f;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        String r18 = this.g;
        if (r18 != null) goto L29;
        int r19 = 0;
    L30:
        int r20 = (r17 + r19) * 31;
        String r21 = this.h;
        if (r21 != null) goto L33;
        int r22 = 0;
    L34:
        int r23 = (r20 + r22) * 31;
        String r24 = this.i;
        if (r24 != null) goto L37;
        int r25 = 0;
    L38:
        int r26 = (r23 + r25) * 31;
        List<UplinkFileEntity> r27 = this.j;
        if (r27 != null) goto L41;
        int r28 = 0;
    L42:
        int r29 = (r26 + r28) * 31;
        List<ChatAttachmentEntity> r30 = this.k;
        if (r30 != null) goto L45;
        int r31 = 0;
    L46:
        int r32 = (r29 + r31) * 31;
        String r33 = this.l;
        if (r33 != null) goto L49;
        int r34 = 0;
    L50:
        int r35 = (r32 + r34) * 31;
        String r36 = this.m;
        if (r36 != null) goto L53;
        int r37 = 0;
    L54:
        int r38 = (r35 + r37) * 31;
        Integer r39 = this.n;
        if (r39 != null) goto L57;
        int r40 = 0;
    L58:
        int r41 = (r38 + r40) * 31;
        Integer r42 = this.o;
        if (r42 != null) goto L61;
        int r43 = 0;
    L62:
        int r44 = (r41 + r43) * 31;
        String r45 = this.p;
        if (r45 != null) goto L65;
        int r46 = 0;
    L66:
        int r47 = (r44 + r46) * 31;
        Uri r48 = this.q;
        if (r48 != null) goto L69;
        int r49 = 0;
    L70:
        int r50 = (r47 + r49) * 31;
        if (this.r == false) goto L73;
        int r51 = 1231;
    L74:
        int r52 = (r50 + r51) * 31;
        xcb.a r53 = this.s;
        if (r53 != null) goto L77;
        int r54 = 0;
    L78:
        int r55 = (r52 + r54) * 31;
        if (this.t == false) goto L81;
        int r56 = 1231;
    L82:
        int r57 = (r55 + r56) * 31;
        RichText r58 = this.u;
        if (r58 != null) goto L85;
        int r59 = 0;
    L86:
        int r60 = (r57 + r59) * 31;
        if (this.v == true) goto L90;
        r4 = 1237;
    L90:
        int r61 = (r60 + r4) * 31;
        Map<String, ResourceUploadInfo> r62 = this.w;
        if (r62 == null) goto L95;
        r1 = r62.hashCode();
    L95:
        return r61 + r1;
    L85:
        r59 = r58.hashCode();
        goto L86
    L81:
        r56 = 1237;
        goto L82
    L77:
        r54 = r53.hashCode();
        goto L78
    L73:
        r51 = 1237;
        goto L74
    L69:
        r49 = r48.hashCode();
        goto L70
    L65:
        r46 = r45.hashCode();
        goto L66
    L61:
        r43 = r42.hashCode();
        goto L62
    L57:
        r40 = r39.hashCode();
        goto L58
    L53:
        r37 = r36.hashCode();
        goto L54
    L49:
        r34 = r33.hashCode();
        goto L50
    L45:
        r31 = r30.hashCode();
        goto L46
    L41:
        r28 = r27.hashCode();
        goto L42
    L37:
        r25 = r24.hashCode();
        goto L38
    L33:
        r22 = r21.hashCode();
        goto L34
    L29:
        r19 = r18.hashCode();
        goto L30
    L25:
        r16 = r15.hashCode();
        goto L26
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "SendInfoExtraParam(context=" + this.a + ", isMentionDoubao=" + this.b + ", voiceTextPostProcess=" + this.c + ", sendWithQueueId=" + this.d + ", isLastInBatch=" + this.e + ", imageUploadId=" + this.f + ", fileUploadId=" + this.g + ", mediaUploadId=" + this.h + ", firstScreenImageUploadId=" + this.i + ", attachments=" + this.j + ", fileAttachments=" + this.k + ", rootMsgId=" + this.l + ", parentMsgId=" + this.m + ", imageWidth=" + this.n + ", imageHeight=" + this.o + ", resourcePath=" + this.p + ", uri=" + this.q + ", keepOrigin=" + this.r + ", urlPreviewEntityPbBundle=" + this.s + ", triggeredBySendButton=" + this.t + ", draftRichText=" + this.u + ", transmitToChat=" + this.v + ", resourceUploadInfoMap=" + this.w + ')';
    }

    public final Context getContext() {
        return this.a;
    }

    public r(Context r4, boolean r5, boolean r6, List r7, String r8, String r9, boolean r10, RichText r11, Map r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r5 = false;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r6 = false;
    L12:
        if ((r13 & 512) == 0) goto L15;
        r7 = null;
    L15:
        if ((r13 & 2048) == 0) goto L18;
        r8 = null;
    L18:
        if ((r13 & 4096) == 0) goto L21;
        r9 = null;
    L21:
        if ((524288 & r13) == 0) goto L24;
        r10 = false;
    L24:
        if ((1048576 & r13) == 0) goto L27;
        r11 = null;
    L27:
        if ((r13 & 4194304) == 0) goto L29;
        r12 = null;
    L29:
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = r7;
        this.k = null;
        this.l = r8;
        this.m = r9;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = false;
        this.s = null;
        this.t = r10;
        this.u = r11;
        this.v = false;
        this.w = r12;
    }
}
