package cj;

import android.app.Activity;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f1189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1191c;
    public final PlatformType d;

    public b(a r5, bj.a r10) {
        Intrinsics.checkNotNullParameter(r5, "containerContext");
        Intrinsics.checkNotNullParameter(r10, "bridgeCall");
        this.f1189a = r5;
        this.f1190b = r5.f1186a;
        this.f1191c = r5.f1188c;
        this.d = r5.mo116a();
    }

    @Override // cj.e
    /* JADX INFO: renamed from: a */
    public final PlatformType mo116a() {
        return this.d;
    }

    @Override // cj.e
    /* JADX INFO: renamed from: b */
    public final String mo117b() {
        return this.f1191c;
    }

    @Override // cj.e
    /* JADX INFO: renamed from: c */
    public final Activity mo118c() {
        return this.f1189a.mo118c();
    }

    @Override // cj.e
    public final Object a(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        return this.f1189a.a(r5);
    }
}
