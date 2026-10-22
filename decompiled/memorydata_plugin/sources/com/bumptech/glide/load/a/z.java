package com.bumptech.glide.load.a;

import android.net.Uri;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class z<Data> implements o<Uri, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f655a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o<h, Data> f656b;

    public static class a implements p<Uri, InputStream> {
        public a() {
        }

        @Override // com.bumptech.glide.load.a.p
        public o<Uri, InputStream> a(s r3) {
            return new z(r3.a(h.class, InputStream.class));
        }
    }

    static {
        f655a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", LocationInfoConst.HTTPS})));
    }

    public z(o<h, Data> r3) {
        this.f656b = (o) ZeusTransformUtils.wrapperContextForParams(r3, o.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public o.a<Data> a2(Uri r2, int r3, int r4, com.bumptech.glide.load.e r5) {
        h r0 = new h(r2.toString());
        return this.f656b.a(r0, r3, r4, r5);
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ o.a a(Uri r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Uri r1) {
        return f655a.contains(r1.getScheme());
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ boolean a(Uri r3) {
        return a2((Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.memorydata.plugin"));
    }
}
