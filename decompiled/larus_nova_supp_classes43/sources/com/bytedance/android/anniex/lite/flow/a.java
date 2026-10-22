package com.bytedance.android.anniex.lite.flow;

import com.bytedance.ies.bullet.service.base.utils.KitType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.anniex.lite.flow.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0095a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[KitType.values().length];
            r0[KitType.WEB.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[KitType.LYNX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }
}
