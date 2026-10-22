package jd2;

import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public final List<String> a;
    public Long b;
    public Long c;
    public String d;
    public String e;

    public d() {
        this(null);
    }

    public d(Object r3) {
        ArrayList r4 = new ArrayList();
        Intrinsics.checkNotNullParameter(r4, "chorusUsers");
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "leadOpenId");
        this.a = r4;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = BuildConfig.FLAVOR;
    }
}
