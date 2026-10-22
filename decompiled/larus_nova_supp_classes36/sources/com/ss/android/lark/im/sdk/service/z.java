package com.ss.android.lark.im.sdk.service;

import com.ss.android.lark.chat.entity.Channel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class z {
    public final Channel a;
    public final List<String> b;
    public final List<Long> c;
    public final int d;
    public final int e;
    public final String f;
    public final boolean g;

    public static final class a {
        public Channel a;
        public List<String> b;
        public List<Long> c;
        public int d;
        public int e;
        public String f;
        public boolean g;

        public a() {
        }

        public final void a(Channel r2) {
            Intrinsics.checkNotNullParameter(r2, "channel");
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.a = r2;
        }

        public final void b(List r2) {
            Intrinsics.checkNotNullParameter(r2, "messageIds");
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.b = r2;
        }
    }

    public z(a r3) {
        Channel r0 = r3.a;
        List<String> r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("channel");
        r0 = null;
    L6:
        this.a = r0;
        List<String> r2 = r3.b;
        if (r2 == null) goto L9;
        r1 = r2;
    L10:
        this.b = r1;
        this.c = r3.c;
        this.d = r3.d;
        this.e = r3.e;
        this.f = r3.f;
        this.g = r3.g;
        return;
    L9:
        Intrinsics.throwUninitializedPropertyAccessException("messageIds");
        goto L10
    }
}
