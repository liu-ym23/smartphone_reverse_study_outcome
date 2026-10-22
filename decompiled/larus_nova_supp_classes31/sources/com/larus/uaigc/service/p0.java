package com.larus.uaigc.service;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.platform.model.upload.ResourceUploadError;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p0 {
    public static final /* synthetic */ int x = 0;
    public final com.larus.bmhome.resource.access.x a;
    public final ResourceMediaType b;
    public final com.larus.bmhome.resource.access.j0 c;
    public final String d;
    public final String e;
    public final String f;
    public final mr9.h g;
    public final Boolean h;
    public final CountDownLatch i;
    public final String j;
    public final String k;
    public final String l;
    public final Function1<mr9.k, Unit> m;
    public final Function1<mr9.l, Unit> n;
    public final Function1<ResourceUploadError, Unit> o;
    public final Boolean p;
    public final Boolean q;
    public final Boolean r;
    public final Map<String, String> s;
    public final Map<String, String> t;
    public final com.larus.bmhome.resource.access.d0 u;
    public final boolean v;
    public final CoroutineScope w;

    public static final class a {
        public a() {
        }

        public static p0 a(com.larus.bmhome.resource.access.j0 r28, String r29, String r30, String r31, Map r32, int r33) {
            int r1 = p0.x;
            String r6 = "bot_chat";
            if ((r33 & 4) == 0) goto L5;
            String r7 = UUID.randomUUID().toString();
        L7:
            if ((r33 & 8) == 0) goto L9;
            String r8 = "canvas";
        L11:
            if ((r33 & 16) == 0) goto L13;
            String r13 = "ai_beautify";
        L15:
            if ((r33 & 32) == 0) goto L17;
            String r14 = "canvas";
        L19:
            if ((r33 & 64) == 0) goto L21;
            Map r2 = MapsKt.emptyMap();
        L23:
            if ((r33 & 128) == 0) goto L25;
            Map r5 = MapsKt.emptyMap();
        L27:
            if ((r33 & 256) == 0) goto L29;
            com.larus.bmhome.resource.access.d0 r0 = new com.larus.bmhome.resource.access.d0(null, null);
        L30:
            Intrinsics.checkNotNullParameter(r28, "resourceInput");
            Intrinsics.checkNotNullParameter("bot_chat", "uploadBizScene");
            Intrinsics.checkNotNullParameter(r7, "fileIdentifier");
            Intrinsics.checkNotNullParameter(r13, "uploadSourceScene");
            Intrinsics.checkNotNullParameter(r2, "extraExt");
            Intrinsics.checkNotNullParameter(r5, "runtimeExt");
            Intrinsics.checkNotNullParameter(r0, "timeoutConfig");
            com.larus.bmhome.resource.access.x r3 = f.b;
            ResourceMediaType r4 = ResourceMediaType.IMAGE;
            CountDownLatch r9 = new CountDownLatch(1);
            mr9.h r10 = null;
            Boolean r20 = Boolean.TRUE;
            String r17 = null;
            return new p0(r3, r4, r28, r6, r7, r8, r10, r20, r9, r17, r13, r14, r17, r17, r17, r20, r20, r20, r2, r5, r0, false, null, 4223552);
        L29:
            r0 = null;
            goto L30
        L25:
            r5 = r32;
            goto L27
        L21:
            r2 = null;
            goto L23
        L17:
            r14 = r31;
            goto L19
        L13:
            r13 = null;
            goto L15
        L9:
            r8 = r30;
            goto L11
        L5:
            r7 = r29;
            goto L7
        }

        public static /* synthetic */ p0 f(com.larus.bmhome.resource.access.j0 r20, String r21, mr9.h r22, CountDownLatch r23, String r24, Boolean r25, Map r26, LifecycleCoroutineScope r27, int r28) {
            com.larus.bmhome.resource.access.d0 r1 = g.b;
            if ((r28 & 4) == 0) goto L5;
            String r4 = UUID.randomUUID().toString();
        L7:
            if ((r28 & 8) == 0) goto L9;
            String r5 = null;
        L11:
            if ((r28 & 16) == 0) goto L13;
            mr9.h r2 = new mr9.h(false, null, null, 31);
        L15:
            if ((r28 & 64) == 0) goto L17;
            CountDownLatch r8 = null;
        L19:
            if ((r28 & 128) == 0) goto L21;
            String r9 = null;
        L23:
            if ((r28 & 256) == 0) goto L25;
            String r10 = "ai_creation";
        L27:
            if ((r28 & 512) == 0) goto L29;
            String r11 = null;
        L31:
            if ((r28 & 1024) == 0) goto L33;
            Function1 r12 = new d0();
        L35:
            if ((r28 & 2048) == 0) goto L37;
            Function1 r13 = new g0();
        L39:
            if ((r28 & 4096) == 0) goto L41;
            Function1 r14 = new h0();
        L43:
            if ((r28 & 8192) == 0) goto L45;
            Boolean r15 = Boolean.FALSE;
        L47:
            if ((r28 & 16384) == 0) goto L49;
            Map r16 = MapsKt.emptyMap();
        L51:
            if ((32768 & r28) == 0) goto L53;
            r1 = new com.larus.bmhome.resource.access.d0(null, null);
        L53:
            com.larus.bmhome.resource.access.d0 r17 = r1;
            if ((65536 & r28) == 0) goto L56;
            boolean r18 = true;
        L58:
            if ((r28 & 131072) == 0) goto L60;
            LifecycleCoroutineScope r19 = null;
        L62:
            return e(r20, r4, r5, r2, true, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
        L60:
            r19 = r27;
            goto L62
        L56:
            r18 = false;
            goto L58
        L49:
            r16 = r26;
            goto L51
        L45:
            r15 = r25;
            goto L47
        L41:
            r14 = null;
            goto L43
        L37:
            r13 = null;
            goto L39
        L33:
            r12 = null;
            goto L35
        L29:
            r11 = "video";
            goto L31
        L25:
            r10 = null;
            goto L27
        L21:
            r9 = r24;
            goto L23
        L17:
            r8 = r23;
            goto L19
        L13:
            r2 = r22;
            goto L15
        L9:
            r5 = "creation_video";
            goto L11
        L5:
            r4 = r21;
            goto L7
        }

        public static p0 c(String r26, String r27, ic8.m0 r28, mr9.h r29, boolean r30, CountDownLatch r31, String r32, String r33, String r34, Function1 r35, Function1 r36, Function1 r37, Boolean r38, com.larus.bmhome.resource.access.d0 r39, LifecycleCoroutineScope r40, int r41) {
            int r1 = p0.x;
            if ((r41 & 4) == 0) goto L5;
            String r3 = UUID.randomUUID().toString();
        L7:
            if ((r41 & 16) == 0) goto L9;
            ic8.m0 r2 = null;
        L11:
            if ((r41 & 32) == 0) goto L13;
            mr9.h r5 = new mr9.h(false, null, null, 31);
        L15:
            if ((r41 & 64) == 0) goto L17;
            boolean r7 = false;
        L19:
            if ((r41 & 128) == 0) goto L21;
            CountDownLatch r8 = null;
        L23:
            if ((r41 & 256) == 0) goto L25;
            String r9 = null;
        L27:
            if ((r41 & 512) == 0) goto L29;
            String r10 = "ai_creation";
        L31:
            if ((r41 & 1024) == 0) goto L33;
            String r11 = null;
        L35:
            if ((r41 & 2048) == 0) goto L37;
            Function1 r12 = new l0();
        L39:
            if ((r41 & 4096) == 0) goto L41;
            Function1 r13 = new m0();
        L43:
            if ((r41 & 8192) == 0) goto L45;
            Function1 r14 = new n0();
        L47:
            if ((r41 & 16384) == 0) goto L49;
            Boolean r15 = null;
        L51:
            if ((r41 & 32768) == 0) goto L53;
            Boolean r16 = Boolean.TRUE;
        L55:
            if ((r41 & 65536) == 0) goto L57;
            Boolean r17 = Boolean.TRUE;
        L59:
            if ((r41 & 131072) == 0) goto L61;
            Map r4 = MapsKt.emptyMap();
        L63:
            if ((r41 & 262144) == 0) goto L65;
            com.larus.bmhome.resource.access.d0 r6 = new com.larus.bmhome.resource.access.d0(null, null);
        L66:
            boolean r19 = true;
            if ((r41 & 524288) == 0) goto L69;
            boolean r20 = true;
        L71:
            if ((r41 & 1048576) == 0) goto L73;
            LifecycleCoroutineScope r21 = null;
        L74:
            Boolean r310 = r15;
            Intrinsics.checkNotNullParameter(r26, "localPath");
            Intrinsics.checkNotNullParameter("bot_chat", "uploadBizScene");
            Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
            Intrinsics.checkNotNullParameter(r5, "resourceCenterUploadParam");
            Intrinsics.checkNotNullParameter(r10, "uploadSourceScene");
            Intrinsics.checkNotNullParameter(r12, "processCallback");
            Intrinsics.checkNotNullParameter(r13, "successCallback");
            Intrinsics.checkNotNullParameter(r14, "failedCallback");
            Intrinsics.checkNotNullParameter(r4, "extraExt");
            Intrinsics.checkNotNullParameter(r6, "timeoutConfig");
            if (r2 == null) goto L77;
            String r22 = r2.a;
        L78:
            if (r2 == null) goto L80;
            String r0 = r2.a;
        L81:
            if (r0 != null) goto L83;
        L95:
            String r18 = null;
        L97:
            if (Intrinsics.areEqual(r18, "content") == false) goto L99;
        L102:
            boolean r23 = true;
        L103:
            Boolean r24 = Boolean.valueOf(r23);
            Function1 r311 = r14;
            if (r2 == null) goto L111;
            Long r25 = Long.valueOf(r2.c);
            if (r25.longValue() >= 0) goto L109;
            r19 = false;
        L109:
            if (r19 == false) goto L111;
            Long r110 = r25;
        L112:
            if (r2 == null) goto L114;
            mr9.c r111 = r2.l;
        L115:
            com.larus.bmhome.resource.access.d0 r112 = r6;
            return b(new com.larus.bmhome.resource.access.j0.b(r26, r22, r24, r110, r111), r3, null, r5, r7, r8, r9, r10, r11, r12, r13, r311, r310, r16, r17, r4, null, r112, r20, r21, 131072);
        L114:
            r111 = null;
        L111:
            r110 = null;
            goto L112
        L99:
            if (Intrinsics.areEqual(r18, "file") == true) goto L102;
            r23 = false;
            goto L103
        L83:
            if ((!StringsKt.isBlank(r0)) == true) goto L86;
            r0 = null;
        L86:
            if (r0 == null) goto L95;
            Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L89
            Object r43 = Result.constructor-impl(UriProtector.parse(r0).getScheme());     // Catch: Throwable -> L89
        L92:
            if (Result.isFailure-impl(r43) == false) goto L94;
            r43 = null;
        L94:
            r18 = (String) r43;
        L89:
            th = move-exception;
            Result.Companion r44 = Result.Companion;
            r43 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L92
        L80:
            r0 = null;
            goto L81
        L77:
            r22 = null;
            goto L78
        L73:
            r21 = r40;
            goto L74
        L69:
            r20 = false;
            goto L71
        L65:
            r6 = r39;
            goto L66
        L61:
            r4 = null;
            goto L63
        L57:
            r17 = null;
            goto L59
        L53:
            r16 = null;
            goto L55
        L49:
            r15 = r38;
            goto L51
        L45:
            r14 = r37;
            goto L47
        L41:
            r13 = r36;
            goto L43
        L37:
            r12 = r35;
            goto L39
        L33:
            r11 = r34;
            goto L35
        L29:
            r10 = r33;
            goto L31
        L25:
            r9 = r32;
            goto L27
        L21:
            r8 = r31;
            goto L23
        L17:
            r7 = r30;
            goto L19
        L13:
            r5 = r29;
            goto L15
        L9:
            r2 = r28;
            goto L11
        L5:
            r3 = r27;
            goto L7
        }

        public static p0 d(String r22, String r23, String r24, mr9.h r25, boolean r26, CountDownLatch r27, String r28, String r29, Function1 r30, Function1 r31, Function1 r32, Boolean r33, Map r34, com.larus.bmhome.resource.access.d0 r35, LifecycleCoroutineScope r36, int r37) {
            int r1 = p0.x;
            if ((r37 & 4) == 0) goto L5;
            String r3 = UUID.randomUUID().toString();
        L7:
            if ((r37 & 8) == 0) goto L9;
            String r4 = null;
        L11:
            if ((r37 & 16) == 0) goto L13;
            mr9.h r2 = new mr9.h(false, null, null, 31);
        L15:
            if ((r37 & 32) == 0) goto L17;
            boolean r6 = true;
        L19:
            if ((r37 & 64) == 0) goto L21;
            CountDownLatch r8 = null;
        L23:
            if ((r37 & 128) == 0) goto L25;
            String r9 = null;
        L27:
            if ((r37 & 256) == 0) goto L29;
            String r10 = "ai_creation";
        L31:
            if ((r37 & 512) == 0) goto L33;
            String r11 = null;
        L35:
            if ((r37 & 1024) == 0) goto L37;
            Function1 r12 = new o0();
        L39:
            if ((r37 & 2048) == 0) goto L41;
            Function1 r13 = new e0();
        L43:
            if ((r37 & 4096) == 0) goto L45;
            Function1 r14 = new f0();
        L47:
            if ((r37 & 8192) == 0) goto L49;
            Boolean r15 = Boolean.FALSE;
        L51:
            if ((r37 & 16384) == 0) goto L53;
            Map r5 = MapsKt.emptyMap();
        L55:
            if ((r37 & 32768) == 0) goto L57;
            com.larus.bmhome.resource.access.d0 r7 = new com.larus.bmhome.resource.access.d0(null, null);
        L59:
            if ((r37 & 65536) == 0) goto L61;
            boolean r17 = true;
        L63:
            if ((r37 & 131072) == 0) goto L65;
            LifecycleCoroutineScope r18 = null;
        L66:
            Intrinsics.checkNotNullParameter(r22, "localPath");
            Intrinsics.checkNotNullParameter("", "uploadBizScene");
            Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
            Intrinsics.checkNotNullParameter(r2, "resourceCenterUploadParam");
            Intrinsics.checkNotNullParameter(r10, "uploadSourceScene");
            Intrinsics.checkNotNullParameter(r12, "processCallback");
            Intrinsics.checkNotNullParameter(r13, "successCallback");
            Intrinsics.checkNotNullParameter(r14, "failedCallback");
            Intrinsics.checkNotNullParameter(r5, "extraExt");
            Intrinsics.checkNotNullParameter(r7, "timeoutConfig");
            Map r0 = r5;
            return e(new com.larus.bmhome.resource.access.j0.b(r22, null, null, null, 30), r3, r4, r2, r6, r8, r9, r10, r11, r12, r13, r14, r15, r0, r7, r17, r18);
        L65:
            r18 = r36;
            goto L66
        L61:
            r17 = false;
            goto L63
        L57:
            r7 = r35;
            goto L59
        L53:
            r5 = r34;
            goto L55
        L49:
            r15 = r33;
            goto L51
        L45:
            r14 = r32;
            goto L47
        L41:
            r13 = r31;
            goto L43
        L37:
            r12 = r30;
            goto L39
        L33:
            r11 = r29;
            goto L35
        L29:
            r10 = null;
            goto L31
        L25:
            r9 = r28;
            goto L27
        L21:
            r8 = r27;
            goto L23
        L17:
            r6 = r26;
            goto L19
        L13:
            r2 = r25;
            goto L15
        L9:
            r4 = r24;
            goto L11
        L5:
            r3 = r23;
            goto L7
        }

        public static p0 e(com.larus.bmhome.resource.access.j0 r26, String r27, String r28, mr9.h r29, boolean r30, CountDownLatch r31, String r32, String r33, String r34, Function1 r35, Function1 r36, Function1 r37, Boolean r38, Map r39, com.larus.bmhome.resource.access.d0 r40, boolean r41, CoroutineScope r42) {
            Intrinsics.checkNotNullParameter(r26, "resourceInput");
            Intrinsics.checkNotNullParameter("", "uploadBizScene");
            Intrinsics.checkNotNullParameter(r27, "fileIdentifier");
            Intrinsics.checkNotNullParameter(r29, "resourceCenterUploadParam");
            Intrinsics.checkNotNullParameter(r33, "uploadSourceScene");
            Intrinsics.checkNotNullParameter(r35, "processCallback");
            Intrinsics.checkNotNullParameter(r36, "successCallback");
            Intrinsics.checkNotNullParameter(r37, "failedCallback");
            Intrinsics.checkNotNullParameter(r39, "extraExt");
            Intrinsics.checkNotNullParameter(r40, "timeoutConfig");
            com.larus.bmhome.resource.access.x r1 = f.c;
            ResourceMediaType r2 = ResourceMediaType.VIDEO;
            Boolean r8 = Boolean.valueOf(r30);
            Boolean r18 = Boolean.FALSE;
            return new p0(r1, r2, r26, "", r27, r28, r29, r8, r31, r32, r33, r34, r35, r36, r37, r38, r18, r18, r39, null, r40, r41, r42, 524288);
        }

        public static p0 b(com.larus.bmhome.resource.access.j0 r26, String r27, String r28, mr9.h r29, boolean r30, CountDownLatch r31, String r32, String r33, String r34, Function1 r35, Function1 r36, Function1 r37, Boolean r38, Boolean r39, Boolean r40, Map r41, Map r42, com.larus.bmhome.resource.access.d0 r43, boolean r44, CoroutineScope r45, int r46) {
            int r1 = p0.x;
            if ((r46 & 4) == 0) goto L5;
            String r7 = UUID.randomUUID().toString();
        L7:
            if ((r46 & 8) == 0) goto L9;
            String r8 = null;
        L11:
            if ((r46 & 16) == 0) goto L13;
            mr9.h r9 = new mr9.h(false, null, null, 31);
        L15:
            if ((r46 & 32) == 0) goto L17;
            boolean r2 = false;
        L19:
            if ((r46 & 64) == 0) goto L21;
            CountDownLatch r11 = null;
        L23:
            if ((r46 & 128) == 0) goto L25;
            String r12 = null;
        L27:
            if ((r46 & 256) == 0) goto L29;
            String r13 = "ai_creation";
        L31:
            if ((r46 & 512) == 0) goto L33;
            String r14 = null;
        L35:
            if ((r46 & 1024) == 0) goto L37;
            Function1 r15 = new i0();
        L39:
            if ((r46 & 2048) == 0) goto L41;
            Function1 r5 = new j0();
        L43:
            if ((r46 & 4096) == 0) goto L45;
            Function1 r10 = new k0();
        L47:
            if ((r46 & 8192) == 0) goto L49;
            Boolean r18 = null;
        L51:
            if ((r46 & 16384) == 0) goto L53;
            Boolean r19 = Boolean.TRUE;
        L55:
            if ((32768 & r46) == 0) goto L57;
            Boolean r20 = Boolean.TRUE;
        L59:
            if ((65536 & r46) == 0) goto L61;
            Map r4 = MapsKt.emptyMap();
        L63:
            if ((131072 & r46) == 0) goto L65;
            Map r3 = MapsKt.emptyMap();
        L67:
            if ((r46 & 262144) == 0) goto L69;
            com.larus.bmhome.resource.access.d0 r16 = new com.larus.bmhome.resource.access.d0(null, null);
        L71:
            if ((r46 & 524288) == 0) goto L73;
            boolean r24 = true;
        L75:
            if ((r46 & 1048576) == 0) goto L77;
            CoroutineScope r25 = null;
        L78:
            Intrinsics.checkNotNullParameter(r26, "resourceInput");
            Intrinsics.checkNotNullParameter("bot_chat", "uploadBizScene");
            Intrinsics.checkNotNullParameter(r7, "fileIdentifier");
            Intrinsics.checkNotNullParameter(r9, "resourceCenterUploadParam");
            Intrinsics.checkNotNullParameter(r13, "uploadSourceScene");
            Intrinsics.checkNotNullParameter(r15, "processCallback");
            Intrinsics.checkNotNullParameter(r5, "successCallback");
            Intrinsics.checkNotNullParameter(r10, "failedCallback");
            Intrinsics.checkNotNullParameter(r4, "extraExt");
            Intrinsics.checkNotNullParameter(r3, "runtimeExt");
            Intrinsics.checkNotNullParameter(r16, "timeoutConfig");
            Map r21 = r4;
            com.larus.bmhome.resource.access.d0 r23 = r16;
            return new p0(f.a, ResourceMediaType.IMAGE, r26, "bot_chat", r7, r8, r9, Boolean.valueOf(r2), r11, r12, r13, r14, r15, r5, r10, r18, r19, r20, r21, r3, r23, r24, r25);
        L77:
            r25 = r45;
            goto L78
        L73:
            r24 = r44;
            goto L75
        L69:
            r16 = r43;
            goto L71
        L65:
            r3 = r42;
            goto L67
        L61:
            r4 = r41;
            goto L63
        L57:
            r20 = r40;
            goto L59
        L53:
            r19 = r39;
            goto L55
        L49:
            r18 = r38;
            goto L51
        L45:
            r10 = r37;
            goto L47
        L41:
            r5 = r36;
            goto L43
        L37:
            r15 = r35;
            goto L39
        L33:
            r14 = r34;
            goto L35
        L29:
            r13 = r33;
            goto L31
        L25:
            r12 = r32;
            goto L27
        L21:
            r11 = r31;
            goto L23
        L17:
            r2 = r30;
            goto L19
        L13:
            r9 = r29;
            goto L15
        L9:
            r8 = r28;
            goto L11
        L5:
            r7 = r27;
            goto L7
        }
    }

    static {
        new a();
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p0) == true) goto L8;
        return false;
    L8:
        p0 r6 = (p0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
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
        if (this.v == r6.v) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r6.w) == true) goto L77;
        return false;
    L77:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        String r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.g.hashCode()) * 31;
        Boolean r5 = this.h;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        CountDownLatch r8 = this.i;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.j;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((r10 + r12) * 31) + this.k.hashCode()) * 31;
        String r14 = this.l;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (((((((r13 + r15) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31;
        Boolean r17 = this.p;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Boolean r20 = this.q;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Boolean r23 = this.r;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (((((((r22 + r24) * 31) + this.s.hashCode()) * 31) + this.t.hashCode()) * 31) + this.u.hashCode()) * 31;
        if (this.v == false) goto L37;
        int r26 = 1231;
    L38:
        int r27 = (r25 + r26) * 31;
        CoroutineScope r28 = this.w;
        if (r28 == null) goto L43;
        r2 = r28.hashCode();
    L43:
        return r27 + r2;
    L37:
        r26 = 1237;
        goto L38
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
        return "ResourceAccessSubmitRequest(scene=" + this.a + ", mediaType=" + this.b + ", resourceInput=" + this.c + ", uploadBizScene=" + this.d + ", fileIdentifier=" + this.e + ", bizScope=" + this.f + ", resourceCenterUploadParam=" + this.g + ", limitUploaderCount=" + this.h + ", latch=" + this.i + ", fileExtension=" + this.j + ", uploadSourceScene=" + this.k + ", preprocessSubScene=" + this.l + ", processCallback=" + this.m + ", successCallback=" + this.n + ", failedCallback=" + this.o + ", enablePreprocess=" + this.p + ", enableLocalDetect=" + this.q + ", enableReview=" + this.r + ", extraExt=" + this.s + ", runtimeExt=" + this.t + ", timeoutConfig=" + this.u + ", enableCallbackBridge=" + this.v + ", observerScope=" + this.w + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p0(com.larus.bmhome.resource.access.x r16, ResourceMediaType r17, com.larus.bmhome.resource.access.j0 r18, String r19, String r20, String r21, mr9.h r22, Boolean r23, CountDownLatch r24, String r25, String r26, String r27, Function1<? super mr9.k, Unit> r28, Function1<? super mr9.l, Unit> r29, Function1<? super ResourceUploadError, Unit> r30, Boolean r31, Boolean r32, Boolean r33, Map<String, String> r34, Map<String, String> r35, com.larus.bmhome.resource.access.d0 r36, boolean r37, CoroutineScope r38) {
        Intrinsics.checkNotNullParameter(r16, "scene");
        Intrinsics.checkNotNullParameter(r17, "mediaType");
        Intrinsics.checkNotNullParameter(r18, "resourceInput");
        Intrinsics.checkNotNullParameter(r19, "uploadBizScene");
        Intrinsics.checkNotNullParameter(r20, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r22, "resourceCenterUploadParam");
        Intrinsics.checkNotNullParameter(r26, "uploadSourceScene");
        Intrinsics.checkNotNullParameter(r28, "processCallback");
        Intrinsics.checkNotNullParameter(r29, "successCallback");
        Intrinsics.checkNotNullParameter(r30, "failedCallback");
        Intrinsics.checkNotNullParameter(r34, "extraExt");
        Intrinsics.checkNotNullParameter(r35, "runtimeExt");
        Intrinsics.checkNotNullParameter(r36, "timeoutConfig");
        this.a = r16;
        this.b = r17;
        this.c = r18;
        this.d = r19;
        this.e = r20;
        this.f = r21;
        this.g = r22;
        this.h = r23;
        this.i = r24;
        this.j = r25;
        this.k = r26;
        this.l = r27;
        this.m = r28;
        this.n = r29;
        this.o = r30;
        this.p = r31;
        this.q = r32;
        this.r = r33;
        this.s = r34;
        this.t = r35;
        this.u = r36;
        this.v = r37;
        this.w = r38;
    }

    public /* synthetic */ p0(com.larus.bmhome.resource.access.x r27, ResourceMediaType r28, com.larus.bmhome.resource.access.j0 r29, String r30, String r31, String r32, mr9.h r33, Boolean r34, CountDownLatch r35, String r36, String r37, String r38, Function1 r39, Function1 r40, Function1 r41, Boolean r42, Boolean r43, Boolean r44, Map r45, Map r46, com.larus.bmhome.resource.access.d0 r47, boolean r48, CoroutineScope r49, int r50) {
        if ((r50 & 16) == 0) goto L5;
        String r7 = UUID.randomUUID().toString();
    L7:
        if ((r50 & 32) == 0) goto L9;
        String r8 = null;
    L11:
        if ((r50 & 64) == 0) goto L13;
        mr9.h r9 = new mr9.h(false, null, null, 31);
    L15:
        if ((r50 & 128) == 0) goto L17;
        Boolean r10 = null;
    L19:
        if ((r50 & 256) == 0) goto L21;
        CountDownLatch r11 = null;
    L23:
        if ((r50 & 512) == 0) goto L25;
        String r12 = null;
    L27:
        if ((r50 & 1024) == 0) goto L29;
        String r13 = "ai_creation";
    L31:
        if ((r50 & 2048) == 0) goto L33;
        String r14 = null;
    L35:
        if ((r50 & 4096) == 0) goto L37;
        Function1 r15 = new a0();
    L39:
        if ((r50 & 8192) == 0) goto L41;
        Function1 r16 = new b0();
    L43:
        if ((r50 & 16384) == 0) goto L45;
        Function1 r17 = new c0();
    L47:
        if ((32768 & r50) == 0) goto L49;
        Boolean r18 = null;
    L51:
        if ((65536 & r50) == 0) goto L53;
        Boolean r19 = null;
    L55:
        if ((131072 & r50) == 0) goto L57;
        Boolean r20 = null;
    L59:
        if ((262144 & r50) == 0) goto L61;
        Map r21 = MapsKt.emptyMap();
    L63:
        if ((524288 & r50) == 0) goto L65;
        Map r22 = MapsKt.emptyMap();
    L67:
        if ((1048576 & r50) == 0) goto L69;
        com.larus.bmhome.resource.access.d0 r23 = new com.larus.bmhome.resource.access.d0(null, null);
    L71:
        if ((2097152 & r50) == 0) goto L73;
        boolean r24 = true;
    L75:
        if ((r50 & 4194304) == 0) goto L77;
        CoroutineScope r25 = null;
    L78:
        this(r27, r28, r29, r30, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
        return;
    L77:
        r25 = r49;
        goto L78
    L73:
        r24 = r48;
        goto L75
    L69:
        r23 = r47;
        goto L71
    L65:
        r22 = r46;
        goto L67
    L61:
        r21 = r45;
        goto L63
    L57:
        r20 = r44;
        goto L59
    L53:
        r19 = r43;
        goto L55
    L49:
        r18 = r42;
        goto L51
    L45:
        r17 = r41;
        goto L47
    L41:
        r16 = r40;
        goto L43
    L37:
        r15 = r39;
        goto L39
    L33:
        r14 = r38;
        goto L35
    L29:
        r13 = r37;
        goto L31
    L25:
        r12 = r36;
        goto L27
    L21:
        r11 = r35;
        goto L23
    L17:
        r10 = r34;
        goto L19
    L13:
        r9 = r33;
        goto L15
    L9:
        r8 = r32;
        goto L11
    L5:
        r7 = r31;
        goto L7
    }
}
