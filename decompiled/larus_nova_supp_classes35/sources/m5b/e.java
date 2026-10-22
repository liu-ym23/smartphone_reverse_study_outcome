package m5b;

import android.content.Context;
import android.net.Uri;
import com.bytedance.lark.pb.basic.v1.File;
import com.ss.android.lark.biz.im.api.k;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public final List<File> A;
    public final boolean B;
    public k C;
    public final Context a;
    public boolean b;
    public final boolean c;
    public Long d;
    public Boolean e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public String j;
    public String k;
    public final Integer l;
    public final Integer m;
    public final String n;
    public final Uri o;
    public String p;
    public Boolean q;
    public Boolean r;
    public Message s;
    public com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo t;
    public String u;
    public Integer v;
    public String w;
    public MonitorMessageSendCallback x;
    public final boolean y;
    public xcb.a z;

    public e() {
        this(null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, 536870911);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
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
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r6.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r6.u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r6.v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r6.w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r6.x) == true) goto L81;
        return false;
    L81:
        if (this.y == r6.y) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.z, r6.z) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r6.A) == true) goto L90;
        return false;
    L90:
        if (this.B == r6.B) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.C, r6.C) == true) goto L95;
        return false;
    L95:
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
        String r27 = this.j;
        if (r27 != null) goto L41;
        int r28 = 0;
    L42:
        int r29 = (r26 + r28) * 31;
        String r30 = this.k;
        if (r30 != null) goto L45;
        int r31 = 0;
    L46:
        int r32 = (r29 + r31) * 31;
        Integer r33 = this.l;
        if (r33 != null) goto L49;
        int r34 = 0;
    L50:
        int r35 = (r32 + r34) * 31;
        Integer r36 = this.m;
        if (r36 != null) goto L53;
        int r37 = 0;
    L54:
        int r38 = (r35 + r37) * 31;
        String r39 = this.n;
        if (r39 != null) goto L57;
        int r40 = 0;
    L58:
        int r41 = (r38 + r40) * 31;
        Uri r42 = this.o;
        if (r42 != null) goto L61;
        int r43 = 0;
    L62:
        int r44 = (r41 + r43) * 31;
        String r45 = this.p;
        if (r45 != null) goto L65;
        int r46 = 0;
    L66:
        int r47 = (r44 + r46) * 31;
        Boolean r48 = this.q;
        if (r48 != null) goto L69;
        int r49 = 0;
    L70:
        int r50 = (r47 + r49) * 31;
        Boolean r51 = this.r;
        if (r51 != null) goto L73;
        int r52 = 0;
    L74:
        int r53 = (r50 + r52) * 31;
        Message r54 = this.s;
        if (r54 != null) goto L77;
        int r55 = 0;
    L78:
        int r56 = (r53 + r55) * 31;
        com.bytedance.lark.pb.basic.v1.Message.PartialReplyInfo r57 = this.t;
        if (r57 != null) goto L81;
        int r58 = 0;
    L82:
        int r59 = (r56 + r58) * 31;
        String r60 = this.u;
        if (r60 != null) goto L85;
        int r61 = 0;
    L86:
        int r62 = (r59 + r61) * 31;
        Integer r63 = this.v;
        if (r63 != null) goto L89;
        int r64 = 0;
    L90:
        int r65 = (r62 + r64) * 31;
        String r66 = this.w;
        if (r66 != null) goto L93;
        int r67 = 0;
    L94:
        int r68 = (r65 + r67) * 31;
        MonitorMessageSendCallback r69 = this.x;
        if (r69 != null) goto L97;
        int r70 = 0;
    L98:
        int r71 = (r68 + r70) * 31;
        if (this.y == false) goto L101;
        int r72 = 1231;
    L102:
        int r73 = (r71 + r72) * 31;
        xcb.a r74 = this.z;
        if (r74 != null) goto L105;
        int r75 = 0;
    L106:
        int r76 = (r73 + r75) * 31;
        List<File> r77 = this.A;
        if (r77 != null) goto L109;
        int r78 = 0;
    L110:
        int r79 = (r76 + r78) * 31;
        if (this.B == true) goto L114;
        r4 = 1237;
    L114:
        int r80 = (r79 + r4) * 31;
        k r81 = this.C;
        if (r81 == null) goto L119;
        r1 = r81.hashCode();
    L119:
        return r80 + r1;
    L109:
        r78 = r77.hashCode();
        goto L110
    L105:
        r75 = r74.hashCode();
        goto L106
    L101:
        r72 = 1237;
        goto L102
    L97:
        r70 = r69.hashCode();
        goto L98
    L93:
        r67 = r66.hashCode();
        goto L94
    L89:
        r64 = r63.hashCode();
        goto L90
    L85:
        r61 = r60.hashCode();
        goto L86
    L81:
        r58 = r57.hashCode();
        goto L82
    L77:
        r55 = r54.hashCode();
        goto L78
    L73:
        r52 = r51.hashCode();
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
        return "SendInfoExtraParam(context=" + this.a + ", isMentionDoubao=" + this.b + ", voiceTextPostProcess=" + this.c + ", sendWithQueueId=" + this.d + ", isLastInBatch=" + this.e + ", imageUpload=" + this.f + ", fileUploadId=" + this.g + ", mediaUploadId=" + this.h + ", firstScreenImageUploadId=" + this.i + ", rootMsgId=" + this.j + ", parentMsgId=" + this.k + ", imageWidth=" + this.l + ", imageHeight=" + this.m + ", resourcePath=" + this.n + ", uri=" + this.o + ", threadId=" + this.p + ", isReplyInThread=" + this.q + ", isNotifyed=" + this.r + ", message=" + this.s + ", partialReplyInfo=" + this.t + ", cid=" + this.u + ", audioDuration=" + this.v + ", audioFileName=" + this.w + ", sendCallback=" + this.x + ", keepOrigin=" + this.y + ", urlPreviewEntityPbBundle=" + this.z + ", fileAttachments=" + this.A + ", transmitToChat=" + this.B + ", doubaoResource=" + this.C + ')';
    }

    public final Context getContext() {
        return this.a;
    }

    public e(Context r21, boolean r22, boolean r23, Long r24, Boolean r25, String r26, String r27, String r28, String r29, String r30, String r31, Integer r32, Integer r33, String r34, Uri r35, boolean r36, xcb.a r37, List r38, boolean r39, int r40) {
        if ((r40 & 1) == 0) goto L5;
        Context r2 = null;
    L7:
        if ((r40 & 2) == 0) goto L9;
        boolean r4 = false;
    L11:
        if ((r40 & 4) == 0) goto L13;
        boolean r6 = false;
    L15:
        if ((r40 & 8) == 0) goto L17;
        Long r7 = null;
    L19:
        if ((r40 & 16) == 0) goto L21;
        Boolean r8 = null;
    L23:
        if ((r40 & 32) == 0) goto L25;
        String r9 = null;
    L27:
        if ((r40 & 64) == 0) goto L29;
        String r10 = null;
    L31:
        if ((r40 & 128) == 0) goto L33;
        String r11 = null;
    L35:
        if ((r40 & 256) == 0) goto L37;
        String r12 = null;
    L39:
        if ((r40 & 512) == 0) goto L41;
        String r13 = null;
    L43:
        if ((r40 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L45;
        String r14 = null;
    L47:
        if ((r40 & 2048) == 0) goto L49;
        Integer r15 = null;
    L51:
        if ((r40 & 4096) == 0) goto L53;
        Integer r5 = null;
    L55:
        if ((r40 & 8192) == 0) goto L57;
        String r3 = null;
    L58:
        String r210 = r3;
        if ((r40 & 16384) == 0) goto L61;
        Uri r16 = null;
    L63:
        if ((r40 & 16777216) == 0) goto L65;
        boolean r17 = false;
    L67:
        if ((r40 & 33554432) == 0) goto L69;
        xcb.a r18 = null;
    L71:
        if ((r40 & 67108864) == 0) goto L73;
        List r19 = null;
    L75:
        if ((r40 & 134217728) == 0) goto L77;
        boolean r1 = false;
    L78:
        this.a = r2;
        this.b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
        this.m = r5;
        this.n = r210;
        this.o = r16;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = r17;
        this.z = r18;
        this.A = r19;
        this.B = r1;
        this.C = null;
        return;
    L77:
        r1 = r39;
        goto L78
    L73:
        r19 = r38;
        goto L75
    L69:
        r18 = r37;
        goto L71
    L65:
        r17 = r36;
        goto L67
    L61:
        r16 = r35;
        goto L63
    L57:
        r3 = r34;
        goto L58
    L53:
        r5 = r33;
        goto L55
    L49:
        r15 = r32;
        goto L51
    L45:
        r14 = r31;
        goto L47
    L41:
        r13 = r30;
        goto L43
    L37:
        r12 = r29;
        goto L39
    L33:
        r11 = r28;
        goto L35
    L29:
        r10 = r27;
        goto L31
    L25:
        r9 = r26;
        goto L27
    L21:
        r8 = r25;
        goto L23
    L17:
        r7 = r24;
        goto L19
    L13:
        r6 = r23;
        goto L15
    L9:
        r4 = r22;
        goto L11
    L5:
        r2 = r21;
        goto L7
    }
}
