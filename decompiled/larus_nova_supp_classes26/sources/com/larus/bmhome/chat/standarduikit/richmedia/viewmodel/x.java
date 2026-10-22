package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaItemAction;
import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaKind;
import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaOverlayAlignment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RichMediaKind.values().length];
            r0[RichMediaKind.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[RichMediaKind.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public static fn8.a a(RichMediaItemAction r8, RichMediaOverlayAlignment r9, int r10, boolean r11) {
        return new fn8.a(r8, r9, Integer.valueOf(r10), null, r11, 8);
    }
}
