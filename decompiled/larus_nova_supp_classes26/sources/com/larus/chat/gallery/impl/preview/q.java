package com.larus.chat.gallery.impl.preview;

import com.larus.chat.gallery.api.PreviewScene;
import com.larus.platform.model.chat.h0;
import com.larus.platform.service.z2;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PreviewScene.values().length];
            r0[PreviewScene.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r0[PreviewScene.SEARCH_IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r0[PreviewScene.PRIVATE_ALBUM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r0[PreviewScene.CLOUD_DRIVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[PreviewScene.CREATION_CARD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r0[PreviewScene.CREATION_RECORD.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r0[PreviewScene.ALBUM.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r0[PreviewScene.ATTACHMENT_PANEL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r0[PreviewScene.CAMERA_RESULT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            a = r0;
        }
    }

    static {
    }

    public static boolean a(PreviewScene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        h0 r0 = z2.a.getNewPreviewConfig();
        switch(a.a[r2.ordinal()]) {
            case 1: goto L12;
            case 2: goto L16;
            case 3: goto L23;
            case 4: goto L23;
            case 5: goto L16;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L19;
            default: goto L5;
        };
    L16:
        return false;
    L5:
        throw new NoWhenBranchMatchedException();
    L19:
        return uy8.b.b("camera_result");
    L20:
        return uy8.b.b("attachment");
    L21:
        return uy8.b.b("album");
    L22:
        return r0.b.a;
    L23:
        return r0.c.a;
    L12:
        if (r0.c.a == false) goto L14;
    L17:
        return true;
    L14:
        if (r0.a.a == false) goto L16;
        goto L16
    }

    public static boolean b(PreviewScene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        switch(a.a[r2.ordinal()]) {
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L10;
            case 8: goto L10;
            case 9: goto L10;
            default: goto L5;
        };
    L7:
        return false;
    L5:
        throw new NoWhenBranchMatchedException();
    L10:
        return a(r2);
    L9:
        return z2.a.getNewPreviewConfig().c.a;
    }
}
