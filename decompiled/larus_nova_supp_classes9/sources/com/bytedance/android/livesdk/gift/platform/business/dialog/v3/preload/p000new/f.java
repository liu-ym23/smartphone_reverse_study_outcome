package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new;

import com.bytedance.bdlocation.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class f {
    public final Object a;
    public final GiftPreloadResType b;

    public static final class a extends f {
        public static final a c = null;

        static {
            c = new a();
        }

        public a() {
            super(BuildConfig.FLAVOR, GiftPreloadResType.ANNIE_LYNX_MODEL);
        }
    }

    public static final class b extends f {
        public b(int r2) {
            super(Integer.valueOf(r2), GiftPreloadResType.GIFT_PANEL_VIEW);
        }
    }

    public static final class c extends f {
        public static final c c = null;

        static {
            c = new c();
        }

        public c() {
            super(BuildConfig.FLAVOR, GiftPreloadResType.ICON_ANIMATOR_URI);
        }
    }

    public static final class d extends f {
        public static final d c = null;

        static {
            c = new d();
        }

        public d() {
            super(BuildConfig.FLAVOR, GiftPreloadResType.ITEM_LIST_DATA);
        }
    }

    public f(Object r1, GiftPreloadResType r2) {
        this.a = r1;
        this.b = r2;
    }
}
