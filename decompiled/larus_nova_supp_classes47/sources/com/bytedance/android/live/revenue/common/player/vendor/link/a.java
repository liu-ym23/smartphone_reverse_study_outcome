package com.bytedance.android.live.revenue.common.player.vendor.link;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.bytedance.android.live.revenue.common.player.vendor.link.a$a, reason: collision with other inner class name */
    public static final class C0083a extends a {
        public final RectF a;

        public C0083a(RectF r2) {
            Intrinsics.checkNotNullParameter(r2, "playerArea");
            this.a = r2;
        }
    }

    public static final class b extends a {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public a() {
    }
}
