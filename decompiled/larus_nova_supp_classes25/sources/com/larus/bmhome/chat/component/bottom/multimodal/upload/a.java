package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import android.net.Uri;
import androidx.collection.LruCache;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.chat.trace.g0;
import com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import ic8.m0;
import ic8.n0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yc9.l1;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public class a implements m {
    public final String a;
    public final UplinkFileEntity b;
    public final String c;
    public final String d;
    public final boolean e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final Boolean k;
    public final Boolean l;
    public final String m;
    public final ReferenceInfo n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final String t;
    public final long u;
    public final c v;
    public n0 w;
    public boolean x;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.multimodal.upload.a$a, reason: collision with other inner class name */
    public static final class C0052a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.m
    public void c(boolean r1) {
    }

    public void f() {
        c r0 = this.v;
        String r1 = this.a;
        String r2 = this.b.getFileIdentifier();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.b(r1, r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.m
    public void d(n0 r55) {
        Intrinsics.checkNotNullParameter(r55, "processResult");
        this.w = r55;
        ProcessFileResultCode r2 = r55.b;
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        String r8 = "";
        if (r3 == true) goto L55;
        LruCache r4 = ko8.a.a;
        String r9 = this.d;
        boolean r11 = this.e;
        boolean r13 = n1.d(this.b);
        boolean r14 = n1.a(this.b);
        boolean r15 = n1.e(this.b);
        String r5 = this.g;
        String r12 = this.h;
        String r10 = this.i;
        if (r55.b != ProcessFileResultCode.PREPARE_OVER_SIZE) goto L13;
        String r6 = "file over size";
    L14:
        m0 r7 = r55.a;
        if (r7 == null) goto L17;
        String r18 = r7.b;
    L18:
        sr9.b r16 = sr9.b.b;
        Uri r17 = this.b.getUri();
        if (r17 == null) goto L21;
        String r19 = r17.toString();
    L22:
        if (r19 != null) goto L24;
        r19 = "";
    L24:
        String r23 = r16.c(r19);
        Uri r20 = this.b.getUri();
        if (r20 == null) goto L27;
        String r21 = r20.toString();
    L28:
        if (r21 != null) goto L30;
        r21 = "";
    L30:
        String r24 = r16.f(r21);
        Uri r22 = this.b.getUri();
        if (r22 == null) goto L33;
        String r25 = r22.toString();
    L34:
        if (r25 == null) goto L37;
        r8 = r25;
    L37:
        String r26 = r16.h(r8);
        Boolean r27 = this.k;
        Boolean r28 = this.l;
        String r29 = this.m;
        ReferenceInfo r30 = this.n;
        if (r30 == null) goto L40;
        String r210 = r30.referencedMessageId;
    L41:
        String r31 = this.o;
        String r32 = this.p;
        String r110 = this.q;
        String r111 = this.r;
        long r211 = AppHost.a.getAppClock().currentTimeMillis() - this.u;
        m0 r1 = r55.a;
        if (r1 == null) goto L52;
        Long r33 = Long.valueOf(r1.c);
        if (r33.longValue() < 0) goto L46;
        boolean r112 = true;
    L47:
        if (r112 == true) goto L50;
        r33 = null;
    L50:
        if (r33 == null) goto L52;
        String r37 = r33.toString();
    L53:
        String r113 = r6;
        ko8.a.m(r9, null, r11, r113, r13, r14, r15, false, null, r18, r5, r12, r10, null, r23, r24, r26, r27, r28, r29, r210, r31, r32, r110, r111, null, null, Long.valueOf(r211), r37, this.s, this.t, 100671746);
        f();
        return;
    L46:
        r112 = false;
    L52:
        r37 = null;
        goto L53
    L40:
        r210 = null;
        goto L41
    L33:
        r25 = null;
        goto L34
    L27:
        r21 = null;
        goto L28
    L21:
        r19 = null;
        goto L22
    L17:
        r18 = null;
        goto L18
    L13:
        r6 = "copy error";
        goto L14
    L55:
        if (n1.d(this.b) == false) goto L97;
        UplinkEntityContent r34 = this.b.getUplinkEntityContent();
        if (r34 == null) goto L60;
        Image r35 = r34.getUplinkImageInfo();
        if (r35 == null) goto L60;
    L61:
        m0 r36 = r55.a;
        if (r36 == null) goto L64;
        String r212 = r36.m;
    L65:
        UplinkEntityContent r38 = this.b.getUplinkEntityContent();
        if (r38 == null) goto L176;
        m0 r39 = r55.a;
        if (r39 == null) goto L70;
        String r310 = r39.f;
    L71:
        if (r39 == null) goto L73;
        String r43 = r39.e;
    L74:
        if (r212 == null) goto L82;
        ImageObj r40 = r35.imageOri;
        if (r40 == null) goto L78;
        ImageObj r41 = ImageObj.copy$default(r40, null, 0, 0, null, r212, 15, null);
    L79:
        if (r41 == null) goto L82;
        ImageObj r42 = r41;
    L83:
        LinkedHashMap r44 = new LinkedHashMap();
        Map r45 = r35.ext;
        if (r45 == null) goto L86;
        r44.putAll(r45);
    L86:
        m0 r46 = r55.a;
        if (r46 != null) goto L89;
    L91:
        boolean r47 = false;
    L92:
        if (r47 == false) goto L94;
        String r48 = "1";
    L95:
        r44.put("is_marked", r48);
        r38.setUplinkImageInfo(Image.copy$default(r35, null, r310, null, r42, null, r43, null, r44, null, null, null, null, null, null, 16213, null));
        goto L176
    L94:
        r48 = "0";
        goto L95
    L89:
        if (r46.i != true) goto L91;
        r47 = true;
        goto L92
    L78:
        r41 = null;
    L82:
        r42 = r35.imageOri;
        goto L83
    L73:
        r43 = null;
        goto L74
    L70:
        r310 = null;
    L176:
        Uri r49 = this.b.getUri();
        if (r49 == null) goto L181;
        String r50 = r49.toString();
        if (r50 == null) goto L181;
        com.larus.utils.l.c(r50, "image_from_scene", this.f);
    L181:
        String r51 = this.b.getFileIdentifier();
        if (r51 == null) goto L185;
        r8 = r51;
    L185:
        Intrinsics.checkNotNullParameter(r8, "fileIdentifier");
        if (this.v.a(this.a, r8) == null) goto L188;
        boolean r52 = true;
    L189:
        if (r52 == false) goto L191;
        this.v.g(this.a, this.b);
        return;
    L191:
        this.v.c(this.a, this.b);
        return;
    L188:
        r52 = false;
        goto L189
    L64:
        r212 = null;
    L60:
        r35 = new Image(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        goto L61
    L97:
        if (n1.c(this.b) == false) goto L176;
        UplinkEntityContent r53 = this.b.getUplinkEntityContent();
        if (r53 == null) goto L102;
        UplinkFileInfo r54 = r53.getUplinkFileInfo();
        if (r54 == null) goto L102;
    L103:
        UplinkFileInfo r311 = r54;
        if (n1.e(this.b) == false) goto L133;
        UplinkEntityContent r56 = this.b.getUplinkEntityContent();
        if (r56 == null) goto L111;
        UplinkFileInfo r57 = r56.getUplinkFileInfo();
        if (r57 == null) goto L111;
        VideoExtension r58 = r57.getVideo();
        if (r58 == null) goto L111;
    L112:
        VideoExtension r312 = r58;
        m0 r59 = r55.a;
        if (r59 == null) goto L115;
        String r313 = r59.e;
    L116:
        com.larus.bmhome.upload.h r60 = com.larus.bmhome.upload.h.a;
        String r61 = this.b.getFileIdentifier();
        if (r61 != null) goto L119;
        r61 = "";
    L119:
        mr9.e r62 = r60.query(r61);
        if (r62 == null) goto L122;
        Image r314 = r62.a;
    L123:
        String r63 = this.b.getFileIdentifier();
        if (r63 != null) goto L126;
        r63 = "";
    L126:
        mr9.e r64 = r60.query(r63);
        if (r64 == null) goto L131;
        Long r65 = r64.d();
        if (r65 == null) goto L131;
        long r66 = r65.longValue();
    L132:
        VideoExtension r410 = VideoExtension.copy$default(r312, null, r313, r314, null, null, null, Float.valueOf(r66 / 1000.0f), null, null, null, 953, null);
    L134:
        UplinkEntityContent r67 = this.b.getUplinkEntityContent();
        if (r67 == null) goto L176;
        m0 r68 = r55.a;
        if (r68 == null) goto L148;
        String r69 = r68.b;
        if (r69 == null) goto L148;
        if ((!StringsKt.isBlank(r69)) == true) goto L144;
        r69 = null;
    L144:
        if (r69 == null) goto L148;
        String r315 = r69;
        String r70 = null;
    L157:
        m0 r71 = r55.a;
        if (r71 == null) goto L160;
        String r316 = r71.f;
    L161:
        if (r71 == null) goto L163;
        String r411 = r71.d;
    L164:
        if (r71 == null) goto L166;
        r70 = r71.e;
    L166:
        String r412 = r70;
        if (r71 == null) goto L169;
        long r72 = r71.c;
    L170:
        if (r71 == null) goto L173;
        Float r73 = r71.n;
        if (r73 == null) goto L173;
    L174:
        r67.setUplinkFileInfo(UplinkFileInfo.copy$default(r311, r315, null, r316, null, Long.valueOf(r72), null, r410, r411, r412, r73, 42, null));
    L173:
        r73 = r311.getDuration();
        goto L174
    L169:
        r72 = -1;
        goto L170
    L163:
        r411 = r70;
        goto L164
    L160:
        r316 = r70;
    L148:
        m0 r74 = r55.a;
        if (r74 == null) goto L153;
        String r75 = r74.e;
        if (r75 == null) goto L153;
        r70 = null;
        String r76 = StringsKt.substringAfterLast$default(r75, '/', null, 2, null);
    L154:
        if (r76 != null) goto L156;
        r315 = "";
        goto L157
    L156:
        r315 = r76;
    L153:
        r70 = null;
        r76 = null;
    L131:
        r66 = 0;
        goto L132
    L122:
        r314 = null;
        goto L123
    L115:
        r313 = null;
    L111:
        r58 = new VideoExtension(null, null, null, null, null, null, null, null, null, null, 1023, null);
        goto L112
    L133:
        r410 = null;
    L102:
        r54 = new UplinkFileInfo(null, null, null, null, null, null, null, null, null, null, 1023, null);
        goto L103
    L5:
        if (r2.isSuccess() != true) goto L7;
        r3 = true;
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.n
    public void a(long r5, String r7) {
        Intrinsics.checkNotNullParameter(r7, "fileIdentifier");
        FLogger.a.d("CommonFileUploadCallback", "multifile " + l1.a(this.b) + " 上传" + r5);
        int r6 = (int) r5;
        Intrinsics.checkNotNullParameter(r7, "fileIdentifier");
        c r8 = this.v;
        String r9 = this.a;
        String r0 = this.b.getFileIdentifier();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r8.f(r9, r0, r6);
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.n
    public void b(mr9.l r49, String r50) {
        Intrinsics.checkNotNullParameter(r49, "uploadResult");
        Intrinsics.checkNotNullParameter(r50, "fileIdentifier");
        n0 r3 = this.w;
        if (r3 == null) goto L7;
        m0 r4 = r3.a;
        if (r4 == null) goto L7;
        r4.h = r49.a;
    L7:
        LruCache r5 = ko8.a.a;
        String r6 = this.d;
        boolean r8 = this.e;
        boolean r10 = n1.d(this.b);
        boolean r11 = n1.a(this.b);
        boolean r12 = n1.e(this.b);
        String r14 = r49.a;
        String r15 = l1.a(this.b);
        String r7 = this.g;
        String r13 = this.h;
        String r9 = this.i;
        String r16 = this.j;
        sr9.b r17 = sr9.b.b;
        Uri r18 = this.b.getUri();
        if (r18 == null) goto L10;
        String r19 = r18.toString();
    L12:
        if (r19 != null) goto L14;
        r19 = "";
    L14:
        String r20 = r17.c(r19);
        Uri r21 = this.b.getUri();
        if (r21 == null) goto L17;
        String r22 = r21.toString();
    L18:
        if (r22 != null) goto L20;
        r22 = "";
    L20:
        String r23 = r17.f(r22);
        Uri r24 = this.b.getUri();
        if (r24 == null) goto L23;
        String r25 = r24.toString();
    L24:
        if (r25 != null) goto L26;
        r25 = "";
    L26:
        String r26 = r17.h(r25);
        Boolean r27 = this.k;
        Boolean r28 = this.l;
        String r110 = this.m;
        ReferenceInfo r29 = this.n;
        if (r29 == null) goto L29;
        String r210 = r29.referencedMessageId;
    L30:
        String r30 = this.o;
        String r111 = this.p;
        String r112 = this.q;
        String r113 = this.r;
        AppHost.Companion r39 = AppHost.a;
        long r211 = r39.getAppClock().currentTimeMillis() - this.u;
        n0 r1 = this.w;
        if (r1 == null) goto L43;
        m0 r2 = r1.a;
        if (r2 == null) goto L43;
        Long r31 = Long.valueOf(r2.c);
        if (r31.longValue() < 0) goto L37;
        boolean r32 = true;
    L38:
        if (r32 == true) goto L41;
        r31 = null;
    L41:
        if (r31 == null) goto L43;
        String r34 = r31.toString();
    L44:
        ko8.a.m(r6, null, r8, null, r10, r11, r12, true, r14, r15, r7, r13, r9, r16, r20, r23, r26, r27, r28, r110, r210, r30, r111, r112, r113, null, null, Long.valueOf(r211), r34, this.s, this.t, 100663306);
        if (this.x == false) goto L75;
        String r33 = this.d;
        String r35 = l1.a(this.b);
        boolean r36 = n1.d(this.b);
        n0 r37 = this.w;
        if (r37 == null) goto L51;
        m0 r38 = r37.a;
        if (r38 == null) goto L51;
        long r40 = r38.c;
    L52:
        long r114 = r40;
        if (r37 == null) goto L57;
        m0 r41 = r37.a;
        if (r41 == null) goto L57;
        String r115 = r41.f;
    L58:
        String r116 = this.a;
        String r117 = this.c;
        if (r37 == null) goto L63;
        m0 r42 = r37.a;
        if (r42 == null) goto L63;
        String r118 = r42.d;
    L64:
        IAIChatControlTraceService.a.ic(r33, r36, r35, r117, r116, r39.getAppClock().currentTimeMillis() - this.u, r115, r114, r118, "1");
        int r43 = MultimodalSendCostTrace.a;
        n0 r44 = this.w;
        if (r44 == null) goto L67;
        m0 r45 = r44.a;
    L68:
        MultimodalSendCostTrace.d(r50, r45);
        String r46 = g0.a;
        boolean r47 = n1.d(this.b);
        n0 r48 = this.w;
        if (r48 == null) goto L73;
        m0 r51 = r48.a;
        if (r51 == null) goto L73;
        long r52 = r51.c;
    L74:
        g0.a(r47, r52);
    L73:
        r52 = 0;
        goto L74
    L67:
        r45 = null;
    L63:
        r118 = null;
    L57:
        r115 = null;
    L51:
        r40 = -1;
    L75:
        FLogger.a.i("CommonFileUploadCallback", "multifile " + l1.a(this.b) + " 上传成功");
        Intrinsics.checkNotNullParameter(r50, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r49, "uploadResult");
        this.v.d(this.a, this.b, r50, r49, this.k, this.l);
        return;
    L37:
        r32 = false;
    L43:
        r34 = null;
        goto L44
    L29:
        r210 = null;
        goto L30
    L23:
        r25 = null;
        goto L24
    L17:
        r22 = null;
        goto L18
    L10:
        r19 = null;
        goto L12
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.n
    public void e(String r43, String r44, String r45) {
        Intrinsics.checkNotNullParameter(r44, "fileIdentifier");
        LruCache r1 = ko8.a.a;
        String r2 = this.d;
        boolean r3 = this.e;
        boolean r5 = n1.d(this.b);
        boolean r6 = n1.a(this.b);
        boolean r7 = n1.e(this.b);
        String r11 = this.g;
        String r10 = this.h;
        String r4 = this.i;
        String r16 = l1.a(this.b);
        sr9.b r8 = sr9.b.b;
        Uri r9 = this.b.getUri();
        if (r9 == null) goto L5;
        String r12 = r9.toString();
    L7:
        if (r12 != null) goto L9;
        r12 = "";
    L9:
        String r17 = r8.c(r12);
        Uri r13 = this.b.getUri();
        if (r13 == null) goto L12;
        String r14 = r13.toString();
    L13:
        if (r14 != null) goto L15;
        r14 = "";
    L15:
        String r18 = r8.f(r14);
        Uri r15 = this.b.getUri();
        if (r15 == null) goto L18;
        String r19 = r15.toString();
    L19:
        if (r19 != null) goto L21;
        r19 = "";
    L21:
        String r110 = r8.h(r19);
        Boolean r111 = this.k;
        Boolean r20 = this.l;
        String r21 = this.m;
        ReferenceInfo r22 = this.n;
        if (r22 == null) goto L24;
        String r23 = r22.referencedMessageId;
    L25:
        String r24 = this.o;
        String r112 = this.p;
        String r113 = this.q;
        String r114 = this.r;
        AppHost.Companion r35 = AppHost.a;
        long r25 = r35.getAppClock().currentTimeMillis() - this.u;
        n0 r26 = this.w;
        if (r26 == null) goto L38;
        m0 r27 = r26.a;
        if (r27 == null) goto L38;
        Long r28 = Long.valueOf(r27.c);
        if (r28.longValue() < 0) goto L32;
        boolean r29 = true;
    L33:
        if (r29 == true) goto L36;
        r28 = null;
    L36:
        if (r28 == null) goto L38;
        String r210 = r28.toString();
    L39:
        ko8.a.m(r2, null, r3, r43, r5, r6, r7, false, null, r16, r11, r10, r4, null, r17, r18, r110, r111, r20, r21, r23, r24, r112, r113, r114, null, null, Long.valueOf(r25), r210, this.s, this.t, 100671746);
        if (this.x == false) goto L64;
        String r30 = this.d;
        String r31 = l1.a(this.b);
        boolean r32 = n1.d(this.b);
        n0 r33 = this.w;
        if (r33 == null) goto L46;
        m0 r34 = r33.a;
        if (r34 == null) goto L46;
        long r36 = r34.c;
    L47:
        long r115 = r36;
        if (r33 == null) goto L52;
        m0 r37 = r33.a;
        if (r37 == null) goto L52;
        String r116 = r37.f;
    L53:
        String r38 = this.a;
        String r39 = this.c;
        if (r33 == null) goto L58;
        m0 r40 = r33.a;
        if (r40 == null) goto L58;
        String r117 = r40.d;
    L59:
        long r41 = r35.getAppClock().currentTimeMillis() - this.u;
        String r118 = r43;
        if (Intrinsics.areEqual(r118, "upload canceled") == false) goto L62;
        String r42 = "3";
    L63:
        IAIChatControlTraceService.a.ic(r30, r32, r31, r39, r38, r41, r116, r115, r117, r42);
    L65:
        FLogger.a.i("CommonFileUploadCallback", "multifile " + l1.a(this.b) + " 上传失败\n errMsg:" + r118);
        Intrinsics.checkNotNullParameter(r44, "fileIdentifier");
        c r46 = this.v;
        String r47 = this.a;
        String r48 = this.b.getFileIdentifier();
        if (r48 != null) goto L68;
        r48 = "";
    L68:
        r46.e(r47, r48);
        return;
    L62:
        r42 = "2";
    L58:
        r117 = null;
    L52:
        r116 = null;
    L46:
        r36 = -1;
        goto L47
    L64:
        r118 = r43;
        goto L65
    L32:
        r29 = false;
    L38:
        r210 = null;
        goto L39
    L24:
        r23 = null;
        goto L25
    L18:
        r19 = null;
        goto L19
    L12:
        r14 = null;
        goto L13
    L5:
        r12 = null;
        goto L7
    }

    public a(String r19, UplinkFileEntity r20, String r21, String r22, boolean r23, String r24, String r25, String r26, String r27, String r28, Boolean r29, Boolean r30, String r31, ReferenceInfo r32, String r33, String r34, String r35, String r36, String r37, String r38, c r39, int r40) {
        if ((r40 & 1024) == 0) goto L10;
        UplinkEntityContent r6 = r20.getUplinkEntityContent();
        if (r6 == null) goto L9;
        Image r7 = r6.getUplinkImageInfo();
        if (r7 == null) goto L9;
        Boolean r8 = r7.isMarked();
    L12:
        if ((r40 & 2048) == 0) goto L19;
        UplinkEntityContent r9 = r20.getUplinkEntityContent();
        if (r9 == null) goto L18;
        Image r10 = r9.getUplinkImageInfo();
        if (r10 == null) goto L18;
        Boolean r11 = r10.isCropped();
    L21:
        if ((r40 & 4096) == 0) goto L23;
        String r12 = null;
    L25:
        if ((r40 & 8192) == 0) goto L27;
        ReferenceInfo r13 = null;
    L29:
        if ((r40 & 16384) == 0) goto L31;
        String r14 = null;
    L33:
        if ((32768 & r40) == 0) goto L35;
        String r15 = null;
    L37:
        if ((65536 & r40) == 0) goto L39;
        String r16 = null;
    L41:
        if ((131072 & r40) == 0) goto L43;
        String r17 = null;
    L45:
        if ((262144 & r40) == 0) goto L47;
        String r18 = null;
    L49:
        if ((r40 & 524288) == 0) goto L51;
        String r41 = null;
    L53:
        if ((r40 & 1048576) == 0) goto L55;
        c r110 = null;
    L56:
        Intrinsics.checkNotNullParameter(r19, "localMsgId");
        Intrinsics.checkNotNullParameter(r20, "entity");
        this.a = r19;
        this.b = r20;
        this.c = r21;
        this.d = r22;
        this.e = r23;
        this.f = r24;
        this.g = r25;
        this.h = r26;
        this.i = r27;
        this.j = r28;
        this.k = r8;
        this.l = r11;
        this.m = r12;
        this.n = r13;
        this.o = r14;
        this.p = r15;
        this.q = r16;
        this.r = r17;
        this.s = r18;
        this.t = r41;
        this.u = AppHost.a.getAppClock().currentTimeMillis();
        if (r110 != null) goto L59;
        r110 = o.a;
    L59:
        this.v = r110;
        if (Intrinsics.areEqual(r24, "album") == false) goto L62;
        g0.a = r25;
    L62:
        String r1 = g0.a;
        g0.d = System.currentTimeMillis();
        this.x = true;
        return;
    L55:
        r110 = r39;
        goto L56
    L51:
        r41 = r38;
        goto L53
    L47:
        r18 = r37;
        goto L49
    L43:
        r17 = r36;
        goto L45
    L39:
        r16 = r35;
        goto L41
    L35:
        r15 = r34;
        goto L37
    L31:
        r14 = r33;
        goto L33
    L27:
        r13 = r32;
        goto L29
    L23:
        r12 = r31;
    L18:
        r11 = null;
        goto L21
    L19:
        r11 = r30;
    L9:
        r8 = null;
        goto L12
    L10:
        r8 = r29;
        goto L12
    }
}
