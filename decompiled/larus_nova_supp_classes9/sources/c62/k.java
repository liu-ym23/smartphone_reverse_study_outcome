package c62;

import com.bytedance.bdlocation.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k<T> implements h80.d {
    public final /* synthetic */ d a;

    public k(d r1) {
        this.a = r1;
    }

    public final Object get() {
        String r0 = this.a.p;
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0;
    }
}
