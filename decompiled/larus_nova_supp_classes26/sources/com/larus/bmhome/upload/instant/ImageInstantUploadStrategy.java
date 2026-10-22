package com.larus.bmhome.upload.instant;

import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.rc.ResourceFingerprintMeta;
import com.larus.bmhome.rc.ResourceInstantUploadInfo;
import com.larus.bmhome.rc.ResourceTargetMeta;
import com.larus.bmhome.upload.UploadImageMetaResolver;
import com.larus.bmhome.upload.sdk.api.model.UploadScene;
import com.larus.network.NetConnectionTypeProvider;
import com.larus.platform.model.upload.ResourceUploadFingerprintMeta;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.platform.model.upload.ResourceUploadTargetMeta;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.utils.logger.FLogger;
import hq9.u1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mr9.j;
import mr9.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ImageInstantUploadStrategy {
    public static final ImageInstantUploadStrategy a = null;

    static {
        a = new ImageInstantUploadStrategy();
    }

    public ImageInstantUploadStrategy() {
    }

    public static boolean d(ImageInstantUploadPreQueryResponse r3) {
        if (r3 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L35;
        String r4 = r3.getTargetUri();
        if (r4 != null) goto L12;
    L15:
        boolean r5 = true;
    L16:
        if (r5 == true) goto L36;
        String r6 = r3.getTargetResourceId();
        if (r6 != null) goto L20;
    L23:
        boolean r7 = true;
    L24:
        if (r7 == true) goto L37;
        String r8 = r3.getRegisterUri();
        if (r8 != null) goto L28;
    L31:
        boolean r9 = true;
    L32:
        if (r9 == true) goto L38;
        return true;
    L38:
        return false;
    L28:
        if (r8.length() == 0) goto L31;
        r9 = false;
        goto L32
    L37:
        return false;
    L20:
        if (r6.length() == 0) goto L23;
        r7 = false;
        goto L24
    L36:
        return false;
    L12:
        if (r4.length() == 0) goto L15;
        r5 = false;
        goto L16
    L35:
        return false;
    L5:
        if (r3.getHit() != true) goto L7;
        r2 = true;
        goto L8
    }

    public static List g(u1 r1) {
        List r2 = r1.j();
        if (r2 == null) goto L10;
        if ((!r2.isEmpty()) == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L10;
        return r2;
    L10:
        return u1.a;
    }

    public static List h(u1 r1) {
        List r2 = r1.k();
        if (r2 == null) goto L10;
        if ((!r2.isEmpty()) == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L10;
        return r2;
    L10:
        return u1.b;
    }

    public static String i(c r2) {
        return "value=" + r2.e + ", family=" + r2.a + ", digest=" + r2.b + ", schemaVersion=" + r2.c + ", definition=" + r2.d;
    }

    public static String j(ImageInstantUploadPreQueryRequest r4) {
        ResourceFingerprintMeta r5 = r4.getFingerprintMeta();
        StringBuilder r0 = new StringBuilder("originHash=");
        String r1 = null;
        if (r5 == null) goto L7;
        String r2 = r5.getOriginHash();
        if (r2 == null) goto L7;
        String r3 = StringsKt.take(r2, 12);
    L8:
        r0.append(r3);
        r0.append(", transformPolicyId=");
        if (r5 == null) goto L11;
        String r6 = r5.getTransformPolicyId();
    L12:
        r0.append(r6);
        r0.append(", policyFamily=");
        if (r5 == null) goto L15;
        String r7 = r5.getPolicyFamily();
    L16:
        r0.append(r7);
        r0.append(", policyDigest=");
        if (r5 == null) goto L19;
        String r8 = r5.getPolicyDigest();
    L20:
        r0.append(r8);
        r0.append(", policySchemaVersion=");
        if (r5 == null) goto L23;
        Integer r9 = r5.getPolicySchemaVersion();
    L24:
        r0.append(r9);
        r0.append(", policyDefinition=");
        if (r5 == null) goto L27;
        Map<String, String> r10 = r5.getPolicyDefinition();
    L28:
        r0.append(r10);
        r0.append(", fileSize=");
        if (r5 == null) goto L31;
        Long r11 = r5.getFileSize();
    L32:
        r0.append(r11);
        r0.append(", mimeType=");
        if (r5 == null) goto L35;
        String r12 = r5.getMimeType();
    L36:
        r0.append(r12);
        r0.append(", fileName=");
        if (r5 == null) goto L39;
        String r13 = r5.getFileName();
    L40:
        r0.append(r13);
        r0.append(", dataType=");
        if (r5 == null) goto L43;
        String r14 = r5.getDataType();
    L44:
        r0.append(r14);
        r0.append(", bizDomain=");
        if (r5 == null) goto L47;
        String r15 = r5.getBizDomain();
    L48:
        r0.append(r15);
        r0.append(", uploadScene=");
        if (r5 == null) goto L51;
        String r16 = r5.getUploadScene();
    L52:
        r0.append(r16);
        r0.append(", networkQuality=");
        if (r5 == null) goto L57;
        Map<String, String> r17 = r5.getPreCheckMeta();
        if (r17 == null) goto L57;
        String r18 = r17.get("network_quality");
    L58:
        r0.append(r18);
        r0.append(", resourceCenterEnabled=");
        if (r5 == null) goto L63;
        Map<String, String> r19 = r5.getPreCheckMeta();
        if (r19 == null) goto L63;
        r1 = r19.get("resource_center_enabled");
    L63:
        r0.append(r1);
        return r0.toString();
    L57:
        r18 = null;
        goto L58
    L51:
        r16 = null;
        goto L52
    L47:
        r15 = null;
        goto L48
    L43:
        r14 = null;
        goto L44
    L39:
        r13 = null;
        goto L40
    L35:
        r12 = null;
        goto L36
    L31:
        r11 = null;
        goto L32
    L27:
        r10 = null;
        goto L28
    L23:
        r9 = null;
        goto L24
    L19:
        r8 = null;
        goto L20
    L15:
        r7 = null;
        goto L16
    L11:
        r6 = null;
    L7:
        r3 = null;
        goto L8
    }

    public static String k(u1 r2) {
        return "enabled=" + r2.e() + ", enableSdk=" + r2.d() + ", enableFallbackRegister=" + r2.b() + ", preQueryPath=" + r2.i() + ", bizWhiteList=" + r2.a() + ", uploadSceneBlackList=" + g(r2) + ", uploadSourceSceneBlackList=" + h(r2) + ", policyFamilyWhiteList=" + r2.h() + ", maxOriginHashFileSize=" + r2.g() + ", failOpen=" + r2.f() + ", enableLog=" + r2.c();
    }

    public static String l(j r2) {
        return "scene=" + r2.b + ", dataType=" + r2.c + ", path=" + r2.a + ", pathIsUri=" + r2.g + ", originPath=" + r2.p + ", originPathIsUri=" + r2.q + ", uploadSourceScene=" + r2.s + ", uploaderIdentifier=" + r2.l + ", resourceCenterEnabled=" + r2.o.a + ", instantPolicy=" + r2.r;
    }

    public static void b(u1 r1, String r2) {
        if (Intrinsics.areEqual(r1.c(), Boolean.TRUE) == false) goto L6;
        FLogger.a.d("ImageInstantUpload", r2);
        return;
    }

    public static boolean e(List r5, String r6) {
        if (r5 != null) goto L4;
        r5 = CollectionsKt.emptyList();
    L4:
        List r7 = CollectionsKt.filterNotNull(r5);
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.iterator();
    L5:
        boolean r2 = false;
        if (r8.hasNext() == false) goto L13;
        Object r1 = r8.next();
        if (((String) r1).length() <= 0) goto L10;
        r2 = true;
    L10:
        if (r2 == false) goto L5;
        r0.add(r1);
        goto L5
    L13:
        if (r0.isEmpty() == true) goto L30;
        Iterator r9 = r0.iterator();
    L17:
        if (r9.hasNext() == false) goto L31;
        if (StringsKt.equals((String) r9.next(), r6, true) == false) goto L17;
        return true;
    L31:
        return false;
    L30:
        return false;
    }

    public static boolean f(List r5, String r6) {
        if (r5 != null) goto L4;
        r5 = CollectionsKt.emptyList();
    L4:
        List r7 = CollectionsKt.filterNotNull(r5);
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.iterator();
    L5:
        boolean r2 = false;
        if (r8.hasNext() == false) goto L13;
        Object r1 = r8.next();
        if (((String) r1).length() <= 0) goto L10;
        r2 = true;
    L10:
        if (r2 == false) goto L5;
        r0.add(r1);
        goto L5
    L13:
        if (r0.isEmpty() == false) goto L15;
    L25:
        return true;
    L15:
        if (r0.isEmpty() == true) goto L23;
        Iterator r9 = r0.iterator();
    L19:
        if (r9.hasNext() == false) goto L23;
        if (StringsKt.equals((String) r9.next(), r6, true) == false) goto L19;
        boolean r10 = true;
    L24:
        if (r10 == true) goto L25;
        return false;
    L23:
        r10 = false;
        goto L24
    }

    public static ResourceInstantUploadInfo m(ImageInstantUploadPreQueryRequest r8, ImageInstantUploadPreQueryResponse r9) {
        Boolean r1 = Boolean.TRUE;
        ResourceFingerprintMeta r10 = r8.getFingerprintMeta();
        String r2 = null;
        if (r9 == null) goto L27;
        String r3 = r9.getTargetUri();
        if (r3 == null) goto L27;
        boolean r5 = true;
        if (r3.length() <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L27;
        String r6 = r9.getTargetResourceId();
        if (r6 == null) goto L27;
        if (r6.length() > 0) goto L21;
        r5 = false;
    L21:
        if (r5 == true) goto L24;
        r6 = null;
    L24:
        if (r6 == null) goto L27;
        ResourceTargetMeta r7 = new ResourceTargetMeta(r3, r6);
    L28:
        if (r9 == null) goto L31;
        r2 = r9.getRegisterUri();
    L31:
        return new ResourceInstantUploadInfo(r1, r10, r7, r2);
    L9:
        r4 = false;
    L27:
        r7 = null;
        goto L28
    }

    public static String c(u1 r2, j r3, UploadScene r4) {
        Boolean r0 = r2.e();
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == true) goto L7;
        return "disabled";
    L7:
        if (Intrinsics.areEqual(r2.d(), r1) == true) goto L11;
        return "chain_disabled";
    L11:
        if (f(r2.a(), r3.b) == true) goto L15;
        return "biz_scene";
    L15:
        if (e(g(r2), r4.name()) == false) goto L19;
        return "upload_scene_blacklist";
    L19:
        if (e(h(r2), r3.s) == false) goto L22;
        return "upload_source_scene_blacklist";
    L22:
        return null;
    }

    public final Object n(ImageInstantUploadPreQueryResponse r31, j r32, ResourceInstantUploadInfo r33, Continuation<? super l> r34) {
        if ((r34 instanceof ImageInstantUploadStrategy$toResourceUploadResult$1) == false) goto L7;
        ImageInstantUploadStrategy$toResourceUploadResult$1 r2 = (ImageInstantUploadStrategy$toResourceUploadResult$1) r34;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        ResourceUploadTargetMeta r7 = null;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        String r0 = (String) r2.L$3;
        String r6 = (String) r2.L$2;
        String r8 = (String) r2.L$1;
        ResourceInstantUploadInfo r9 = (ResourceInstantUploadInfo) r2.L$0;
        ResultKt.throwOnFailure(r1);
        String r11 = r0;
        String r10 = r6;
        String r12 = r8;
    L30:
        mr9.d r13 = (mr9.d) r1;
        Boolean r14 = r9.getPreQueryHit();
        ResourceFingerprintMeta r15 = r9.getFingerprintMeta();
        if (r15 == null) goto L33;
        ResourceUploadFingerprintMeta r16 = new ResourceUploadFingerprintMeta(r15.getOriginHash(), r15.getTransformPolicyId(), r15.getPolicyFamily(), r15.getPolicyDigest(), r15.getPolicySchemaVersion(), r15.getPolicyDefinition(), r15.getFileSize(), r15.getMimeType(), r15.getFileName(), r15.getDataType(), r15.getBizDomain(), r15.getUploadScene(), r15.getPreCheckMeta());
    L34:
        ResourceTargetMeta r17 = r9.getTargetMeta();
        if (r17 == null) goto L38;
        r7 = new ResourceUploadTargetMeta(r17.getTargetUri(), r17.getTargetResourceId());
    L38:
        return new l(r12, r10, r11, r13, null, true, new ResourceUploadInstantInfo(r14, r16, r7, r9.getRegisterUri()), 16);
    L33:
        r16 = null;
        goto L34
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if (r31 != null) goto L17;
        return null;
    L17:
        String r18 = r31.getTargetUri();
        if (r18 != null) goto L20;
        return null;
    L20:
        String r19 = r31.getTargetResourceId();
        if (r19 != null) goto L23;
        return null;
    L23:
        String r20 = r31.getRegisterUri();
        UploadImageMetaResolver r21 = UploadImageMetaResolver.a;
        r2.L$0 = r33;
        r2.L$1 = r18;
        r2.L$2 = r20;
        r2.L$3 = r19;
        r2.label = 1;
        r21.getClass();
        if (r32.c == UploadDataType.IMAGE) goto L26;
        Object r22 = null;
    L27:
        if (r22 != r4) goto L29;
        return r4;
    L29:
        r11 = r19;
        r12 = r18;
        r9 = r33;
        r1 = r22;
        r10 = r20;
        goto L30
    L26:
        r22 = r21.b(r32, r2);
    L7:
        r2 = new ImageInstantUploadStrategy$toResourceUploadResult$1(this, r34);
        goto L8
    }

    public static ImageInstantUploadPreQueryRequest a(j r20, UploadScene r21, String r22, c r23, ImageInstantUploadHash.a r24) {
        ResourceCenter.a.getClass();
        String r4 = ResourceCenter.b;
        String r6 = r24.a;
        String r7 = r23.e;
        String r8 = r23.a;
        String r9 = r23.b;
        Integer r10 = r23.c;
        Map<String, String> r11 = r23.d;
        Long r12 = Boxing.boxLong(r24.b);
        Map<String, String> r1 = r23.d;
        if (r1 == null) goto L30;
        String r5 = r1.get("output_format");
        if (r5 != null) goto L7;
        r5 = r1.get("format_with_alpha");
    L7:
        if (r5 == null) goto L28;
        String r2 = r5.toLowerCase(Locale.ROOT);
        if (r2 != null) goto L11;
        String r3 = null;
    L29:
        String r13 = r3;
    L31:
        ImageInstantUploadHash.a.getClass();
        Intrinsics.checkNotNullParameter(r20, "param");
        String r14 = ImageInstantUploadHash.a(r20);
        Boolean r15 = r20.q;
        if (r15 == null) goto L34;
        boolean r16 = r15.booleanValue();
    L36:
        if (r16 == false) goto L38;
        String r17 = UriProtector.parse(r14).getLastPathSegment();
    L40:
        return new ImageInstantUploadPreQueryRequest(r4, r22, new ResourceFingerprintMeta(r6, r7, r8, r9, r10, r11, r12, r13, r17, r20.c.getType(), r20.b, r21.name(), MapsKt.mapOf(new Pair[]{TuplesKt.to("network_quality", String.valueOf(NetConnectionTypeProvider.a.getValue())), TuplesKt.to("resource_center_enabled", String.valueOf(r20.o.a))})));
    L38:
        r17 = StringsKt.substringAfterLast$default(StringsKt.substringAfterLast$default(r14, '/', null, 2, null), '\\', null, 2, null);
        goto L40
    L34:
        r16 = r20.g;
        goto L36
    L11:
        switch(r2.hashCode()) {
            case 105441: goto L25;
            case 111145: goto L21;
            case 3268712: goto L18;
            case 3645340: goto L14;
            default: goto L42;
        };
    L42:
        r3 = null;
        goto L29
    L14:
        if (r2.equals("webp") == false) goto L43;
        r3 = "image/webp";
        goto L29
    L43:
        r3 = null;
        goto L29
    L18:
        if (r2.equals("jpeg") == false) goto L44;
    L27:
        r3 = "image/jpeg";
        goto L29
    L44:
        r3 = null;
        goto L29
    L21:
        if (r2.equals("png") == false) goto L45;
        r3 = "image/png";
        goto L29
    L45:
        r3 = null;
        goto L29
    L25:
        if (r2.equals("jpg") == true) goto L27;
        r3 = null;
        goto L29
    L28:
        r3 = null;
        goto L29
    L30:
        r13 = null;
        goto L31
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 7 */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 36841. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final java.lang.Object o(mr9.j r89, com.larus.bmhome.upload.sdk.api.model.UploadScene r90, java.lang.String r91, hq9.u1 r92, kotlin.coroutines.Continuation<? super com.larus.bmhome.upload.instant.b> r93) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0000: MOVE (r1v0 ?? I:??[OBJECT, ARRAY]) = (r88v0 'this' com.larus.bmhome.upload.instant.ImageInstantUploadStrategy A[IMMUTABLE_TYPE, THIS]) A[DECLARE_VAR] (LINE:83886080) in method: com.larus.bmhome.upload.instant.ImageInstantUploadStrategy.o(mr9.j, com.larus.bmhome.upload.sdk.api.model.UploadScene, java.lang.String, hq9.u1, kotlin.coroutines.Continuation<? super com.larus.bmhome.upload.instant.b>):java.lang.Object, file: /private/tmp/nixiang/classes26.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 3684
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.larus.bmhome.upload.instant.ImageInstantUploadStrategy.o(mr9.j, com.larus.bmhome.upload.sdk.api.model.UploadScene, java.lang.String, hq9.u1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
