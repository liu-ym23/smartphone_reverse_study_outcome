package com.ss.android.lark.forseti.util.animation;

import com.ss.android.lark.api.bean.ForsetiChainType;
import com.ss.android.lark.api.bean.ForsetiMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.forseti.util.animation.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0067a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ForsetiMode.values().length];
            r0[ForsetiMode.Compact.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L12:
            r0[ForsetiMode.Regular.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L5:
            a = r0;
            int[] r1 = new int[ForsetiChainType.values().length];
            r1[ForsetiChainType.TYPE_NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L7:
            b = r1;
        }
    }

    static {
    }
}
