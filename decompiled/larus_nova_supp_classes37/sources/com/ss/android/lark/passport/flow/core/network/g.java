package com.ss.android.lark.passport.flow.core.network;

import com.bytedance.lark.rustclient.api.l;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public static final Regex b = null;
    public final l a;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PassportHttpMethod.values().length];
            r0[PassportHttpMethod.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[PassportHttpMethod.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[PassportHttpMethod.DELETE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[PassportHttpMethod.PUT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[PassportHttpMethod.PATCH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[PassportHttpMethod.HEAD.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[PassportHttpMethod.OPTIONS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    static {
        b = new Regex("^[!#$%&'*+.^_`|~0-9A-Za-z-]+$");
    }

    public g(l r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.a = r2;
    }
}
