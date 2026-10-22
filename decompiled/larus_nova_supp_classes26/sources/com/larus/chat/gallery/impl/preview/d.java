package com.larus.chat.gallery.impl.preview;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PreviewChromeKind.values().length];
            r0[PreviewChromeKind.LEGACY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[PreviewChromeKind.MEDIA_SOURCE_V4.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }
}
