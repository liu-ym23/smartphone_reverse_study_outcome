package com.larus.chat.gallery.impl.preview;

import com.larus.chat.gallery.api.PreviewScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[PreviewChromeKind.values().length];
            r0[PreviewChromeKind.MEDIA_SOURCE_V4.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[PreviewChromeKind.LEGACY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L6:
            a = r0;
            int[] r1 = new int[PreviewScene.values().length];
            r1[PreviewScene.ALBUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L29:
            r1[PreviewScene.ATTACHMENT_PANEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L23:
            r1[PreviewScene.CAMERA_RESULT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L25:
            r1[PreviewScene.CLOUD_DRIVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L11:
            b = r1;
        }
    }

    static {
    }
}
