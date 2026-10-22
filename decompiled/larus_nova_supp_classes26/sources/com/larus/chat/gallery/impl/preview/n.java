package com.larus.chat.gallery.impl.preview;

import com.larus.chat.gallery.api.PreviewScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class n {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[PreviewScene.values().length];
        r0[PreviewScene.ALBUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L13:
        r0[PreviewScene.ATTACHMENT_PANEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L19:
        r0[PreviewScene.CAMERA_RESULT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L15:
        r0[PreviewScene.CLOUD_DRIVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L7:
        a = r0;
    }
}
