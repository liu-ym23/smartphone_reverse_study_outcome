package com.larus.bmhome.upload.instant;

import com.larus.bmhome.rc.FileResourceMeta;
import com.larus.bmhome.rc.FlowResource;
import com.larus.bmhome.rc.FlowResourceMeta;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ImageResourceMeta;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.rc.ResourceFingerprintMeta;
import com.larus.bmhome.rc.ResourceInstantUploadInfo;
import com.larus.im.bean.message.Image;
import com.larus.platform.model.upload.FlowResourceType;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import mr9.j;
import mr9.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ImageInstantUploadFallbackRegister {
    public static final ImageInstantUploadFallbackRegister a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UploadDataType.values().length];
            r0[UploadDataType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[UploadDataType.FILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[UploadDataType.VIDEO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[UploadDataType.UNCLEAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
        a = new ImageInstantUploadFallbackRegister();
    }

    public ImageInstantUploadFallbackRegister() {
    }

    public static void c(CoroutineScope r39, j r40, l r41, String r42, boolean r43) {
        Intrinsics.checkNotNullParameter(r39, "scope");
        Intrinsics.checkNotNullParameter(r40, "param");
        Intrinsics.checkNotNullParameter(r41, "uploadResult");
        if (r40.o.a == false) goto L5;
        return;
    L5:
        if (r43 == false) goto L7;
    L9:
        ConcurrentHashMap<String, ResourceInstantUploadInfo> r3 = f.a;
        Intrinsics.checkNotNullParameter(r40, "param");
        String r1 = f.b(r40);
        if (r1 == null) goto L15;
        ResourceInstantUploadInfo r5 = f.a.remove(r1);
        if (r5 == null) goto L15;
        FLogger.a.d("ImageInstantUpload", "consume register info, key=" + r1 + ", info=" + f.d(r5));
    L16:
        if (r5 != null) goto L18;
        return;
    L18:
        String r7 = r41.a;
        if (r7 != null) goto L22;
        FLogger.a.e("ImageInstantUpload", "fallback register skipped, tosKey is null, identifier=" + r40.l);
        return;
    L22:
        String r0 = r40.l;
        if (r0 != null) goto L25;
    L35:
        FlowResourceScene r2 = FlowResourceScene.Unknown;
    L36:
        FlowResourceScene r4 = FlowResourceScene.Unknown;
        if (r2 == r4) goto L39;
    L38:
        r4 = r2;
    L86:
        ResourceFingerprintMeta r6 = r5.getFingerprintMeta();
        String r9 = com.larus.bmhome.rc.f.a(r5, r7);
        UploadDataType r10 = r40.c;
        int[] r11 = a.a;
        int r12 = r11[r10.ordinal()];
        if (r12 == 1) goto L98;
        if (r12 != 2) goto L90;
        FlowResourceType r13 = FlowResourceType.File;
    L99:
        Integer r14 = Integer.valueOf(r13.getValue());
        if (r6 == null) goto L102;
        String r15 = r6.getFileName();
    L103:
        if (r6 == null) goto L106;
        Long r8 = r6.getFileSize();
        if (r8 == null) goto L106;
    L107:
        Long r19 = r8;
        int r16 = r11[r40.c.ordinal()];
        if (r16 == 1) goto L112;
        if (r16 == 2) goto L111;
        FlowResourceMeta r17 = new FlowResourceMeta(null, null, null, null, null, null, 63, null);
    L113:
        FlowResource r18 = new FlowResource(r9, r14, com.larus.bmhome.rc.f.b(r17, r5, r40.t), r40.l);
        ms8.b.a.getClass();
        ms8.b.i(r40, "fallback_register");
        BuildersKt.launch$default(r39, null, null, new ImageInstantUploadFallbackRegister$registerAsync$1(r18, r40, r4, r7, null), 3, null);
        return;
    L111:
        r17 = new FlowResourceMeta(new FileResourceMeta(r15, null, r40.l, null, r19, null, 42, null), null, null, null, null, null, 62, null);
        goto L113
    L112:
        r17 = new FlowResourceMeta(null, new ImageResourceMeta(new Image(null, null, null, null, null, null, r40.l, null, null, null, null, null, null, null, 16319, null), null, 2, null), null, null, null, null, 61, null);
    L106:
        r8 = r40.t;
        goto L107
    L102:
        r15 = null;
        goto L103
    L90:
        if (r12 != 3) goto L92;
        r13 = FlowResourceType.Video;
        goto L99
    L92:
        if (r12 != 4) goto L95;
        r13 = FlowResourceType.Unknown;
        goto L99
    L95:
        throw new NoWhenBranchMatchedException();
    L98:
        r13 = FlowResourceType.Image;
        goto L99
    L39:
        ResourceFingerprintMeta r20 = r5.getFingerprintMeta();
        if (r20 == null) goto L43;
        String r21 = r20.getUploadScene();
        if (r21 == null) goto L43;
    L44:
        if (r21 == null) goto L86;
        switch(r21.hashCode()) {
            case -2087738074: goto L83;
            case -2075848634: goto L79;
            case -1081135658: goto L75;
            case -441098516: goto L72;
            case 438308459: goto L68;
            case 438318035: goto L64;
            case 438325036: goto L61;
            case 1061369290: goto L57;
            case 1099036979: goto L53;
            case 1621152701: goto L49;
            default: goto L86;
        };
    L49:
        if (r21.equals("CHAT_FILE_UPLOAD") == false) goto L86;
        r2 = FlowResourceScene.FileUpload;
        goto L38
    L53:
        if (r21.equals("O_SERVER") == false) goto L86;
        r2 = FlowResourceScene.O_Server;
        goto L38
    L57:
        if (r21.equals("O_MOBILE_TMP") == false) goto L86;
        r2 = FlowResourceScene.O_Mobile_Tmp;
        goto L38
    L61:
        if (r21.equals("CHAT_IMAGE_VLM") == false) goto L86;
    L85:
        r2 = FlowResourceScene.ImageVLM;
        goto L38
    L64:
        if (r21.equals("CHAT_IMAGE_OCR") == false) goto L86;
        r2 = FlowResourceScene.ImageOCR;
        goto L38
    L68:
        if (r21.equals("CHAT_IMAGE_EDU") == false) goto L86;
        r2 = FlowResourceScene.ImageEDU;
        goto L38
    L72:
        if (r21.equals("CHAT_DIRECT_IMAGE") == true) goto L85;
    L75:
        if (r21.equals("O_ASSISTANT_FEEDBACK") == false) goto L86;
        r2 = FlowResourceScene.O_ASSISTANT_FEEDBACK;
        goto L38
    L79:
        if (r21.equals("CHAT_ATTACHMENT_VIDEO") == false) goto L86;
        r2 = FlowResourceScene.VideoUpload;
        goto L38
    L83:
        if (r21.equals("CHAT_ATTACHMENT_IMAGE") == true) goto L85;
    L43:
        r21 = r42;
        goto L44
    L25:
        if (r0.length() <= 0) goto L27;
        boolean r22 = true;
    L28:
        if (r22 == true) goto L31;
        r0 = null;
    L31:
        if (r0 == null) goto L35;
        ResourceCenter.a.getClass();
        r2 = ResourceCenter.g(r0);
        if (r2 == null) goto L35;
    L27:
        r22 = false;
    L15:
        r5 = null;
        goto L16
    L7:
        if (Intrinsics.areEqual(z2.a.getImageInstantUploadConfig().b(), Boolean.TRUE) == true) goto L9;
    }

    public static final void a(ImageInstantUploadFallbackRegister r2, String r3, String r4, String r5, j r6, FlowResourceScene r7) {
        r2.getClass();
        FLogger.a.i("ImageInstantUpload", "fallback register success, identifier=" + r6.l + ", scene=" + r7 + ", registerUri=" + r4 + ", tosKey=" + r5 + ", resourceId=" + r3);
    }

    public static final void b(ImageInstantUploadFallbackRegister r2, j r3, FlowResourceScene r4, ResourceUploadError r5, String r6, Map r7) {
        r2.getClass();
        ms8.b r8 = ms8.b.a;
        Map r9 = MapsKt.plus(MapsKt.mapOf(new Pair[]{TuplesKt.to("resource_scene", r4.name()), TuplesKt.to("register_type", "fallback"), TuplesKt.to("api_name", "resource_register"), TuplesKt.to("api_path", "/alice/resource/register")}), r7);
        r8.getClass();
        ms8.b.b(r3, "fallback_register", "fail", r5, r9);
        FLogger.a.e("ImageInstantUpload", r6);
    }
}
