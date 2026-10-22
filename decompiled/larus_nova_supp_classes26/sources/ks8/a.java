package ks8;

import com.larus.bmhome.upload.sdk.api.model.AuthMode;
import com.larus.bmhome.upload.sdk.api.model.RegisterPolicy;
import com.larus.bmhome.upload.sdk.api.model.RoutePolicy;
import com.larus.bmhome.upload.sdk.api.model.UploadEngineType;
import com.larus.bmhome.upload.sdk.api.model.UploadMediaType;
import com.larus.bmhome.upload.sdk.api.model.UploadScene;
import is8.g;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements b {

    /* JADX INFO: renamed from: ks8.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0114a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;
        public static final /* synthetic */ int[] d = null;

        static {
            int[] r0 = new int[RoutePolicy.values().length];
            r0[RoutePolicy.ForceResourceCenter.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L78:
            r0[RoutePolicy.ForceUploadAuthToken.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L94:
            r0[RoutePolicy.Auto.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L8:
            a = r0;
            int[] r1 = new int[UploadMediaType.values().length];
            r1[UploadMediaType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L82:
            r1[UploadMediaType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L96:
            r1[UploadMediaType.FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L12:
            b = r1;
            int[] r2 = new int[RegisterPolicy.values().length];
            r2[RegisterPolicy.ForceEnable.ordinal()] = 1;     // Catch: NoSuchFieldError -> L38
        L72:
            r2[RegisterPolicy.Disabled.ordinal()] = 2;     // Catch: NoSuchFieldError -> L39
        L84:
            r2[RegisterPolicy.Auto.ordinal()] = 3;     // Catch: NoSuchFieldError -> L40
        L16:
            c = r2;
            int[] r3 = new int[UploadScene.values().length];
            r3[UploadScene.CHAT_DIRECT_IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L41
        L76:
            r3[UploadScene.CHAT_ATTACHMENT_IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L42
        L88:
            r3[UploadScene.CHAT_ATTACHMENT_VIDEO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L43
        L54:
            r3[UploadScene.CHAT_IMAGE_VLM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L44
        L62:
            r3[UploadScene.CHAT_IMAGE_OCR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L45
        L92:
            r3[UploadScene.CHAT_IMAGE_EDU.ordinal()] = 6;     // Catch: NoSuchFieldError -> L46
        L56:
            r3[UploadScene.CHAT_FILE_UPLOAD.ordinal()] = 7;     // Catch: NoSuchFieldError -> L47
        L68:
            r3[UploadScene.CREATION_USER_VIDEO.ordinal()] = 8;     // Catch: NoSuchFieldError -> L48
        L74:
            r3[UploadScene.SPRING_MAIN_VENUE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L49
        L90:
            r3[UploadScene.O_SERVER.ordinal()] = 10;     // Catch: NoSuchFieldError -> L50
        L66:
            r3[UploadScene.O_MOBILE_TMP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L51
        L80:
            r3[UploadScene.O_ASSISTANT_FEEDBACK.ordinal()] = 12;     // Catch: NoSuchFieldError -> L52
        L86:
            r3[UploadScene.UNKNOWN.ordinal()] = 13;     // Catch: NoSuchFieldError -> L53
        L30:
            d = r3;
        }
    }

    public a() {
    }

    @Override // ks8.b
    public final is8.a a(g r11) {
        Intrinsics.checkNotNullParameter(r11, "request");
        UploadScene r7 = r11.c.b;
        RoutePolicy r0 = r11.d.b;
        int r1 = C0114a.a[r0.ordinal()];
        if (r1 == 1) goto L22;
        if (r1 == 2) goto L21;
        if (r1 != 3) goto L20;
        UploadMediaType r2 = r11.b;
        switch(C0114a.d[r7.ordinal()]) {
            case 1: goto L17;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L16;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L16;
            case 8: goto L16;
            case 9: goto L16;
            case 10: goto L16;
            case 11: goto L16;
            case 12: goto L15;
            case 13: goto L12;
            default: goto L9;
        };
    L15:
        AuthMode r3 = AuthMode.ResourceCenterPrepareUpload;
    L23:
        UploadMediaType r4 = r11.b;
        int r5 = C0114a.b[r4.ordinal()];
        if (r5 == 1) goto L31;
        if (r5 == 2) goto L30;
        if (r5 != 3) goto L29;
        UploadEngineType r6 = UploadEngineType.FILE;
    L32:
        boolean r8 = false;
        if (r3 != AuthMode.ResourceCenterPrepareUpload) goto L35;
        boolean r9 = true;
    L36:
        RegisterPolicy r10 = r11.d.c;
        int r12 = C0114a.c[r10.ordinal()];
        if (r12 == 1) goto L44;
        if (r12 == 2) goto L43;
        if (r12 != 3) goto L42;
        boolean r13 = r9;
    L46:
        if (r11.b == UploadMediaType.IMAGE) goto L49;
        r8 = true;
    L49:
        return new is8.a(r3, r6, r13, r8, r9, r7);
    L42:
        throw new NoWhenBranchMatchedException();
    L43:
        r13 = false;
        goto L46
    L44:
        r13 = true;
        goto L46
    L35:
        r9 = false;
        goto L36
    L29:
        throw new NoWhenBranchMatchedException();
    L30:
        r6 = UploadEngineType.VIDEO;
        goto L32
    L31:
        r6 = UploadEngineType.IMAGE;
        goto L32
    L16:
        r3 = AuthMode.ResourceCenterPrepareUpload;
        goto L23
    L17:
        r3 = AuthMode.UploadAuthToken;
        goto L23
    L9:
        if (r2 != UploadMediaType.VIDEO) goto L18;
        r3 = AuthMode.ResourceCenterPrepareUpload;
        goto L23
    L18:
        r3 = AuthMode.UploadAuthToken;
        goto L23
    L12:
        if (r2 != UploadMediaType.VIDEO) goto L14;
        r3 = AuthMode.ResourceCenterPrepareUpload;
        goto L23
    L14:
        r3 = AuthMode.UploadAuthToken;
        goto L23
    L20:
        throw new NoWhenBranchMatchedException();
    L21:
        r3 = AuthMode.UploadAuthToken;
        goto L23
    L22:
        r3 = AuthMode.ResourceCenterPrepareUpload;
        goto L23
    }
}
