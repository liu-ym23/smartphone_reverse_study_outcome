package com.larus.bmhome.upload.sdk;

import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.upload.sdk.api.model.UploadScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UploadScene.values().length];
            r0[UploadScene.CHAT_FILE_UPLOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r0[UploadScene.CHAT_IMAGE_VLM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r0[UploadScene.CHAT_IMAGE_OCR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r0[UploadScene.CHAT_IMAGE_EDU.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r0[UploadScene.CHAT_DIRECT_IMAGE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r0[UploadScene.CHAT_ATTACHMENT_IMAGE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r0[UploadScene.CHAT_ATTACHMENT_VIDEO.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r0[UploadScene.CREATION_USER_VIDEO.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r0[UploadScene.SPRING_MAIN_VENUE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r0[UploadScene.O_SERVER.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r0[UploadScene.O_MOBILE_TMP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r0[UploadScene.O_ASSISTANT_FEEDBACK.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            a = r0;
        }
    }

    public static final FlowResourceScene a(is8.g r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "request");
        if (r2 != null) goto L5;
    L15:
        FlowResourceScene r3 = FlowResourceScene.Unknown;
    L16:
        FlowResourceScene r0 = FlowResourceScene.Unknown;
        if (r3 == r0) goto L19;
        return r3;
    L19:
        UploadScene r4 = r1.c.b;
        switch(a.a[r4.ordinal()]) {
            case 1: goto L34;
            case 2: goto L45;
            case 3: goto L44;
            case 4: goto L43;
            case 5: goto L42;
            case 6: goto L41;
            case 7: goto L40;
            case 8: goto L39;
            case 9: goto L38;
            case 10: goto L37;
            case 11: goto L36;
            case 12: goto L35;
            default: goto L46;
        };
    L46:
        return r0;
    L35:
        return FlowResourceScene.O_ASSISTANT_FEEDBACK;
    L36:
        return FlowResourceScene.O_Mobile_Tmp;
    L37:
        return FlowResourceScene.O_Server;
    L38:
        return FlowResourceScene.SpringMainVenue;
    L39:
        return FlowResourceScene.CreationUserVideo;
    L40:
        return FlowResourceScene.VideoUpload;
    L41:
        return FlowResourceScene.ImageVLM;
    L42:
        return FlowResourceScene.ImageVLM;
    L43:
        return FlowResourceScene.ImageEDU;
    L44:
        return FlowResourceScene.ImageOCR;
    L45:
        return FlowResourceScene.ImageVLM;
    L34:
        return FlowResourceScene.FileUpload;
    L5:
        if (r2.length() <= 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L15;
        ResourceCenter.a.getClass();
        r3 = ResourceCenter.g(r2);
        if (r3 == null) goto L15;
    L7:
        r5 = false;
        goto L8
    }
}
