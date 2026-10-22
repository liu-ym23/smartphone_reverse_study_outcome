package com.larus.bmhome.upload.instant;

import com.larus.bmhome.rc.ResourceFingerprintMeta;
import com.larus.bmhome.rc.ResourceInstantUploadInfo;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mr9.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public static final ConcurrentHashMap<String, ResourceInstantUploadInfo> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static void a(j r1) {
        Intrinsics.checkNotNullParameter(r1, "param");
        String r2 = b(r1);
        if (r2 != null) goto L5;
        return;
    L5:
        a.remove(r2);
    }

    public static String b(j r5) {
        String r0 = r5.l;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L14:
        UplinkFileEntity r6 = r5.o.c;
        if (r6 == null) goto L25;
        String r7 = r6.getFileIdentifier();
        if (r7 != null) goto L19;
        return null;
    L19:
        if (r7.length() <= 0) goto L21;
        r1 = true;
    L21:
        if (r1 == true) goto L23;
        return null;
    L23:
        return r7;
    L25:
        return null;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L14;
        return r0;
    L7:
        r4 = false;
        goto L8
    }

    public static String d(ResourceInstantUploadInfo r5) {
        ResourceFingerprintMeta r0 = r5.getFingerprintMeta();
        StringBuilder r1 = new StringBuilder("preQueryHit=");
        r1.append(r5.getPreQueryHit());
        r1.append(", originHash=");
        Map<String, String> r2 = null;
        if (r0 == null) goto L7;
        String r3 = r0.getOriginHash();
        if (r3 == null) goto L7;
        String r4 = StringsKt.take(r3, 12);
    L8:
        r1.append(r4);
        r1.append(", transformPolicyId=");
        if (r0 == null) goto L11;
        String r6 = r0.getTransformPolicyId();
    L12:
        r1.append(r6);
        r1.append(", policyFamily=");
        if (r0 == null) goto L15;
        String r7 = r0.getPolicyFamily();
    L16:
        r1.append(r7);
        r1.append(", policyDigest=");
        if (r0 == null) goto L19;
        String r8 = r0.getPolicyDigest();
    L20:
        r1.append(r8);
        r1.append(", policySchemaVersion=");
        if (r0 == null) goto L23;
        Integer r9 = r0.getPolicySchemaVersion();
    L24:
        r1.append(r9);
        r1.append(", policyDefinition=");
        if (r0 == null) goto L27;
        Map<String, String> r10 = r0.getPolicyDefinition();
    L28:
        r1.append(r10);
        r1.append(", fileSize=");
        if (r0 == null) goto L31;
        Long r11 = r0.getFileSize();
    L32:
        r1.append(r11);
        r1.append(", mimeType=");
        if (r0 == null) goto L35;
        String r12 = r0.getMimeType();
    L36:
        r1.append(r12);
        r1.append(", fileName=");
        if (r0 == null) goto L39;
        String r13 = r0.getFileName();
    L40:
        r1.append(r13);
        r1.append(", dataType=");
        if (r0 == null) goto L43;
        String r14 = r0.getDataType();
    L44:
        r1.append(r14);
        r1.append(", bizDomain=");
        if (r0 == null) goto L47;
        String r15 = r0.getBizDomain();
    L48:
        r1.append(r15);
        r1.append(", uploadScene=");
        if (r0 == null) goto L51;
        String r16 = r0.getUploadScene();
    L52:
        r1.append(r16);
        r1.append(", preCheckMeta=");
        if (r0 == null) goto L55;
        r2 = r0.getPreCheckMeta();
    L55:
        r1.append(r2);
        r1.append(", targetMeta=");
        r1.append(r5.getTargetMeta());
        r1.append(", registerUri=");
        r1.append(r5.getRegisterUri());
        return r1.toString();
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
        r4 = null;
        goto L8
    }

    public static void c(j r9, ImageInstantUploadPreQueryRequest r10) {
        Intrinsics.checkNotNullParameter(r9, "param");
        Intrinsics.checkNotNullParameter(r10, "request");
        String r11 = b(r9);
        if (r11 != null) goto L5;
        return;
    L5:
        ConcurrentHashMap<String, ResourceInstantUploadInfo> r0 = a;
        r0.put(r11, new ResourceInstantUploadInfo(Boolean.FALSE, r10.getFingerprintMeta(), null, null, 12, null));
        FLogger r12 = FLogger.a;
        StringBuilder r1 = new StringBuilder("record register info after miss, key=");
        r1.append(r11);
        r1.append(", info=");
        ResourceInstantUploadInfo r13 = r0.get(r11);
        if (r13 == null) goto L8;
        String r14 = d(r13);
    L9:
        r1.append(r14);
        r12.d("ImageInstantUpload", r1.toString());
        return;
    L8:
        r14 = null;
        goto L9
    }
}
