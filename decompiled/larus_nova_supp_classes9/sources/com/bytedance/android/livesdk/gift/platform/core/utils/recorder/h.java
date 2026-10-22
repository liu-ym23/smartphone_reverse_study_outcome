package com.bytedance.android.livesdk.gift.platform.core.utils.recorder;

import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    public String a;
    public String b;
    public final List<String> c;
    public d d;
    public String e;
    public boolean f;
    public long g;
    public String h;

    public h() {
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "msg");
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "extraInfo");
        this.e = BuildConfig.FLAVOR;
        this.f = false;
        this.g = 0;
        this.h = BuildConfig.FLAVOR;
        this.a = BuildConfig.FLAVOR;
        this.b = BuildConfig.FLAVOR;
        this.c = new ArrayList();
    }

    public final String toString() {
        return "s:" + this.c + ",m:" + this.e + ",gid:" + this.a + ",aid:" + this.b + ",bir:" + this.f + ",sc:" + this.g + ",ext:" + this.h + "; ";
    }
}
