package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.e3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class k {
    public final String a;

    public static final class a extends k {
        public a() {
            super("ShowLink");
        }
    }

    public static final class b extends k {
        public b() {
            super("ShowPenal");
        }
    }

    public static final class c extends k {
        public final e3 b;
        public final c3 c;

        public c(e3 r2, c3 r3) {
            super("ShowPk");
            this.b = r2;
            this.c = r3;
        }
    }

    public k(String r1) {
        this.a = r1;
    }
}
