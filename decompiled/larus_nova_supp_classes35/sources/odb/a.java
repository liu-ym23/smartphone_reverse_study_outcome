package odb;

import com.ss.android.lark.featuregatingv2impl.entity.ErrorType;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public String a;
    public long b;
    public long c;
    public ErrorType d;
    public String e;
    public boolean f;

    public a() {
        this.a = BuildConfig.FLAVOR;
        this.d = ErrorType.NORMAL;
        this.e = BuildConfig.FLAVOR;
    }

    public final void a(ErrorType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }
}
