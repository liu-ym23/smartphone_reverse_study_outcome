package com.larus.bmhome.upload.sdk;

import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenterPostUploadSupport;
import com.larus.bmhome.rc.ResourceRegisterData;
import com.larus.bmhome.rc.ResourceRegisterTraceError;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.upload.FlowResourceType;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mr9.j;
import mr9.k;
import mr9.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ResourceCenterRegisterPostAction implements hs8.c {

    public static final class a {
    }

    static {
    }

    public ResourceCenterRegisterPostAction() {
    }

    @Override // hs8.c
    public final boolean a(is8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "route");
        return r2.c;
    }

    @Override // hs8.c
    public final Object b(hs8.d r46, Continuation<? super hs8.d> r47) {
        if ((r47 instanceof ResourceCenterRegisterPostAction$execute$1) == false) goto L7;
        ResourceCenterRegisterPostAction$execute$1 r2 = (ResourceCenterRegisterPostAction$execute$1) r47;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        ResourceCenterRegisterPostAction$execute$1 r12 = r2;
        Object r1 = r12.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r12.label;
        String r15 = "fail";
        String r11 = "resource_register";
        Object r19 = "register_type";
        String r10 = "resource_scene";
        if (r5 == 0) goto L22;
        if (r5 != 1) goto L21;
        FlowResourceScene r6 = (FlowResourceScene) r12.L$5;
        String r0 = (String) r12.L$4;
        l r7 = (l) r12.L$3;
        j r8 = (j) r12.L$2;
        String r9 = (String) r12.L$1;
        hs8.d r13 = (hs8.d) r12.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L14 ResourceUploadError -> L16 ResourceRegisterTraceError -> L18
        FlowResourceScene r14 = r6;
        Object r16 = "api_path";
        Object r17 = "/alice/resource/register";
        String r35 = "resource_scene";
        String r36 = "resource_register";
        r19 = r19;
        char r23 = 1;
        char r26 = 0;
        String r18 = r0;
        Object r20 = r1;
        Object r21 = "api_name";
        l r22 = r7;
    L170:
        ResourceRegisterData r24 = (ResourceRegisterData) r20;     // Catch: Throwable -> L114 ResourceUploadError -> L122 ResourceRegisterTraceError -> L125
        Function1 r25 = r8.u;     // Catch: Throwable -> L114 ResourceUploadError -> L116 ResourceRegisterTraceError -> L119
        if (r25 != null) goto L183;
    L60:
        ms8.b r37 = ms8.b.a;     // Catch: Throwable -> L114 ResourceUploadError -> L122 ResourceRegisterTraceError -> L125
        Pair[] r27 = new Pair[4];     // Catch: Throwable -> L114 ResourceUploadError -> L122 ResourceRegisterTraceError -> L125
        r10 = r35;
        r27[r26] = TuplesKt.to(r10, r14.name());     // Catch: Throwable -> L107 ResourceUploadError -> L109 ResourceRegisterTraceError -> L111
        r19 = r19;
        r27[r23] = TuplesKt.to(r19, "normal_after_upload");     // Catch: Throwable -> L99 ResourceUploadError -> L102 ResourceRegisterTraceError -> L105
        r11 = r36;
        r15 = "fail";
        r27[2] = TuplesKt.to(r21, r11);     // Catch: Throwable -> L87 ResourceUploadError -> L89 ResourceRegisterTraceError -> L91
        r16 = r16;
        r17 = r17;
        r27[3] = TuplesKt.to(r16, r17);     // Catch: Throwable -> L79 ResourceUploadError -> L85 ResourceRegisterTraceError -> L91
    L177:
        ms8.b.c(r37, r8, "resource_register", "success", null, MapsKt.mapOf(r27), 8);     // Catch: Throwable -> L79 ResourceUploadError -> L81 ResourceRegisterTraceError -> L83
        ResourceRegisterData r28 = (ResourceRegisterData) r20;     // Catch: Throwable -> L79 ResourceUploadError -> L81 ResourceRegisterTraceError -> L83
        String r29 = r28.getResourceId();
        String r30 = r28.getAliasName();
        FLogger.a.i("ResourceCenterPostAction", "[register] success, identifier=" + r9 + ", tosKey=" + r18 + ", resourceId=" + r29 + ", aliasName=" + r30 + ", scene=" + r14);
        ConcurrentHashMap<String, j> r31 = g.a;
        l r32 = l.a(r22, null, r30, r29, 121);
        Intrinsics.checkNotNullParameter(r9, "identifier");
        Intrinsics.checkNotNullParameter(r32, "result");
        g.c.put(r9, r32);
        Map<String, String> r33 = r13.e;
        Pair[] r34 = new Pair[2];
        r34[r26] = TuplesKt.to(r10, r14.name());
        if (r29 != null) goto L76;
        String r38 = "";
    L77:
        r34[r23] = TuplesKt.to("resource_id", r38);
        Map r39 = MapsKt.plus(r33, MapsKt.mapOf(r34));
        is8.g r40 = r13.a;
        is8.a r41 = r13.b;
        hs8.a r42 = r13.c;
        Intrinsics.checkNotNullParameter(r40, "request");
        Intrinsics.checkNotNullParameter(r41, "route");
        Intrinsics.checkNotNullParameter(r42, "engineResult");
        Intrinsics.checkNotNullParameter(r39, "attributes");
        return new hs8.d(r40, r41, r42, r29, r39);
    L76:
        r38 = r29;
        goto L77
    L81:
        e = e;
    L118:
        j r43 = r8;
    L145:
        FlowResourceScene r44 = r14;
        r8 = r43;
    L146:
        r14 = r44;
    L124:
        String r45 = r15;
    L158:
        ms8.b r48 = ms8.b.a;
        Pair[] r49 = new Pair[4];
        r49[r26] = TuplesKt.to(r10, r14.name());
        r49[r23] = TuplesKt.to(r19, "normal_after_upload");
        r49[2] = TuplesKt.to(r21, r11);
        r49[3] = TuplesKt.to(r16, r17);
        Map r50 = MapsKt.mapOf(r49);
        r48.getClass();
        ms8.b.b(r8, r11, r45, e, r50);
        throw e;
    L83:
        e = e;
    L127:
        FlowResourceScene r51 = r14;
    L135:
        r14 = r51;
    L136:
        String r52 = r15;
    L163:
        ms8.b r53 = ms8.b.a;
        ResourceUploadError r54 = e.getUploadError();
        Pair[] r55 = new Pair[2];
        r55[r26] = TuplesKt.to(r10, r14.name());
        r55[r23] = TuplesKt.to(r19, "normal_after_upload");
        Map r56 = MapsKt.plus(MapsKt.mapOf(r55), e.getTraceExtra());
        r53.getClass();
        ms8.b.b(r8, r11, r52, r54, r56);
        throw e.getUploadError();
    L85:
        e = e;
    L79:
        th = th;
    L121:
        r6 = r14;
    L150:
        String r57 = th.getMessage();
        if (r57 != null) goto L153;
        r57 = "";
    L153:
        ResourceUploadError r58 = new ResourceUploadError("upload_resource_register_error", r57);
        ms8.b r59 = ms8.b.a;
        Pair[] r60 = new Pair[6];
        r60[r26] = TuplesKt.to(r10, r6.name());
        r60[r23] = TuplesKt.to(r19, "normal_after_upload");
        r60[2] = TuplesKt.to(r21, r11);
        r60[3] = TuplesKt.to(r16, r17);
        r60[4] = TuplesKt.to("error_type", "exception");
        r60[5] = TuplesKt.to("fail_reason", "exception");
        Map r61 = MapsKt.mapOf(r60);
        r59.getClass();
        ms8.b.b(r8, r11, r15, r58, r61);
        throw r58;
    L91:
        e = e;
    L89:
        e = e;
    L90:
        r16 = r16;
        r17 = r17;
    L87:
        th = th;
    L88:
        r16 = r16;
        r17 = r17;
        goto L121
    L95:
        e = e;
        r15 = "fail";
    L97:
        e = e;
        r15 = "fail";
    L93:
        th = th;
        r15 = "fail";
        goto L88
    L105:
        e = e;
        r15 = "fail";
        r11 = r36;
    L102:
        e = e;
    L104:
        r11 = r36;
    L99:
        th = th;
    L101:
        r11 = r36;
        goto L121
    L109:
        e = e;
        r19 = r19;
    L111:
        e = e;
    L113:
        r11 = r36;
    L107:
        th = th;
        r19 = r19;
        goto L101
    L183:
        r25.invoke("register_finished");     // Catch: Throwable -> L54 ResourceUploadError -> L56 ResourceRegisterTraceError -> L58
    L58:
        e = e;
        r52 = "fail";
        r19 = r19;
        r10 = r35;
        r11 = r36;
    L56:
        e = e;
        r45 = "fail";
        r16 = r16;
        r17 = r17;
        r19 = r19;
        r10 = r35;
        r11 = r36;
    L54:
        th = th;
        r6 = r14;
        r15 = "fail";
        r16 = r16;
        r17 = r17;
        r19 = r19;
        r10 = r35;
        r11 = r36;
        goto L150
    L116:
        e = e;
        r15 = "fail";
        r16 = r16;
        r17 = r17;
        r19 = r19;
        r10 = r35;
        r11 = r36;
    L119:
        e = e;
        r15 = "fail";
        r19 = r19;
        r10 = r35;
        r11 = r36;
    L114:
        th = th;
        r19 = r19;
        r10 = r35;
    L122:
        e = e;
        r19 = r19;
        r10 = r35;
    L125:
        e = e;
        r10 = r35;
        goto L113
    L18:
        e = e;
        r14 = r6;
        r52 = "fail";
        r19 = r19;
        r23 = 1;
        r26 = 0;
    L16:
        e = e;
        r14 = r6;
        r21 = "api_name";
        r17 = "/alice/resource/register";
        r45 = "fail";
        r23 = 1;
        r26 = 0;
        r16 = "api_path";
        r19 = r19;
    L14:
        th = th;
        r21 = "api_name";
        r17 = "/alice/resource/register";
        r15 = "fail";
        r23 = 1;
        r26 = 0;
        r16 = "api_path";
        r19 = r19;
        goto L150
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        ResultKt.throwOnFailure(r1);
        String r62 = r46.a.c.f;
        ConcurrentHashMap<String, j> r63 = g.a;
        Intrinsics.checkNotNullParameter(r62, "identifier");
        j r64 = g.a.get(r62);
        if (r64 != null) goto L25;
        return r46;
    L25:
        Intrinsics.checkNotNullParameter(r62, "identifier");
        l r65 = g.c.get(r62);
        if (r65 != null) goto L28;
        return r46;
    L28:
        String r66 = r65.a;
        if (r66 != null) goto L31;
        return r46;
    L31:
        r14 = e.a(r46.a, r64.l);
        r64.o.e.invoke();
        Function1 r67 = r64.u;
        if (r67 == null) goto L34;
        r67.invoke("register_started");
    L34:
        r10 = "resource_scene";
        r64.e.invoke(new k(Boxing.boxLong(99), false));
        ms8.b.a.getClass();
        ms8.b.i(r64, "resource_register");
        ResourceCenterPostUploadSupport r68 = ResourceCenterPostUploadSupport.a;     // Catch: Throwable -> L137 ResourceUploadError -> L155 ResourceRegisterTraceError -> L160
        mr9.h r69 = r64.o;     // Catch: Throwable -> L137 ResourceUploadError -> L143 ResourceRegisterTraceError -> L147
        UplinkFileEntity r70 = r69.c;     // Catch: Throwable -> L137 ResourceUploadError -> L143 ResourceRegisterTraceError -> L147
        ResourceAttachmentExtra r71 = r69.b;     // Catch: Throwable -> L137 ResourceUploadError -> L143 ResourceRegisterTraceError -> L147
        FlowResourceScene.Companion.getClass();     // Catch: Throwable -> L137 ResourceUploadError -> L139 ResourceRegisterTraceError -> L141
        String r210 = FlowResourceScene.a.b(r14);     // Catch: Throwable -> L137 ResourceUploadError -> L139 ResourceRegisterTraceError -> L141
        String r72 = r64.l;     // Catch: Throwable -> L137 ResourceUploadError -> L143 ResourceRegisterTraceError -> L147
        FlowResourceType r211 = com.larus.bmhome.upload.a.a(r64);     // Catch: Throwable -> L137 ResourceUploadError -> L139 ResourceRegisterTraceError -> L141
        Long r110 = r64.t;     // Catch: Throwable -> L137 ResourceUploadError -> L143 ResourceRegisterTraceError -> L147
    L43:
        r12.L$0 = r46;     // Catch: Throwable -> L137 ResourceUploadError -> L139 ResourceRegisterTraceError -> L141
        r12.L$1 = r62;     // Catch: Throwable -> L137 ResourceUploadError -> L139 ResourceRegisterTraceError -> L141
        r12.L$2 = r64;     // Catch: Throwable -> L137 ResourceUploadError -> L139 ResourceRegisterTraceError -> L141
        r12.L$3 = r65;     // Catch: Throwable -> L137 ResourceUploadError -> L139 ResourceRegisterTraceError -> L141
        r12.L$4 = r66;     // Catch: Throwable -> L137 ResourceUploadError -> L139 ResourceRegisterTraceError -> L141
        r12.L$5 = r14;     // Catch: Throwable -> L137 ResourceUploadError -> L139 ResourceRegisterTraceError -> L141
        r12.label = 1;     // Catch: Throwable -> L137 ResourceUploadError -> L139 ResourceRegisterTraceError -> L141
        r21 = "api_name";
        r16 = "api_path";
        r17 = "/alice/resource/register";
        r23 = 1;
        j r212 = r64;
        r26 = 0;
        r19 = r19;
        r35 = r10;
        r36 = "resource_register";
        r20 = ResourceCenterPostUploadSupport.b(r65, r70, r71, r210, r72, r211, null, r110, r12, 64);     // Catch: Throwable -> L128 ResourceUploadError -> L130 ResourceRegisterTraceError -> L132
        if (r20 != r4) goto L48;
        return r4;
    L48:
        r13 = r46;
        r18 = r66;
        r22 = r65;
        r8 = r212;
        r9 = r62;
        goto L170
    L132:
        e = e;
        r19 = r19;
        r10 = r35;
        r11 = r36;
    L134:
        r51 = r14;
        r8 = r212;
    L130:
        e = e;
        r16 = r16;
        r17 = r17;
        r19 = r19;
        r10 = r35;
        r11 = r36;
        r45 = "fail";
    L157:
        r8 = r212;
    L128:
        th = th;
        r16 = r16;
        r17 = r17;
        r19 = r19;
        r10 = r35;
        r11 = r36;
    L149:
        r6 = r14;
        r8 = r212;
        goto L150
    L139:
        e = e;
        r15 = "fail";
        r19 = r19;
        r21 = "api_name";
        r16 = "api_path";
        r10 = r10;
        r17 = "/alice/resource/register";
        r23 = 1;
        r26 = 0;
        r44 = r14;
        r8 = r64;
    L141:
        e = e;
        r23 = 1;
        r26 = 0;
        r52 = "fail";
    L162:
        r8 = r64;
    L147:
        e = e;
        r212 = r64;
        r19 = r19;
        r10 = r10;
        r23 = 1;
        r26 = 0;
    L143:
        e = e;
        r15 = "fail";
        r19 = r19;
        r21 = "api_name";
        r16 = "api_path";
        r10 = r10;
        r17 = "/alice/resource/register";
        r23 = 1;
        r26 = 0;
        r43 = r64;
        goto L145
    L137:
        th = th;
        r19 = r19;
        r21 = "api_name";
        r16 = "api_path";
        r10 = r10;
        r17 = "/alice/resource/register";
        r23 = 1;
        r26 = 0;
        r212 = r64;
    L155:
        e = e;
        r45 = "fail";
        r19 = r19;
        r21 = "api_name";
        r16 = "api_path";
        r10 = r10;
        r17 = "/alice/resource/register";
        r23 = 1;
        r26 = 0;
        r212 = r64;
    L160:
        e = e;
        r52 = "fail";
        r23 = 1;
        r26 = 0;
    L7:
        r2 = new ResourceCenterRegisterPostAction$execute$1(this, r47);
        goto L8
    }
}
