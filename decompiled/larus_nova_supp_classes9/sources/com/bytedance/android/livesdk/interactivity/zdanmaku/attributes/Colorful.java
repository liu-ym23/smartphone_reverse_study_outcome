package com.bytedance.android.livesdk.interactivity.zdanmaku.attributes;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import nf6.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/attributes/Colorful;", BuildConfig.FLAVOR, "Lnf6/a;", "Single", "Multi", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Colorful extends Enum<Colorful> implements a {
    public static final Colorful Multi = null;
    public static final Colorful Single = null;
    public static final /* synthetic */ Colorful[] a = null;

    static {
        Colorful r1 = new Colorful("Single", 0);
        Single = r1;
        Colorful r2 = new Colorful("Multi", 1);
        Multi = r2;
        a = new Colorful[]{r1, r2};
    }

    public static Colorful valueOf(String r1) {
        return (Colorful) r27.a.a(Colorful.class, r1);
    }

    public static Colorful[] values() {
        return (Colorful[]) a.clone();
    }

    public Colorful(String r1, int r2) {
        super(r1, r2);
    }
}
