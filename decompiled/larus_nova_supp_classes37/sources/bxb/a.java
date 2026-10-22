package bxb;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import dxb.m;
import dxb.t;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static boolean f;
    public final cxb.a a;
    public boolean b;
    public int c;
    public String d;
    public boolean e;

    /* JADX INFO: renamed from: bxb.a$a, reason: collision with other inner class name */
    public static final class C0002a {
    }

    static {
    }

    public a(OfficeWebView r2) {
        Intrinsics.checkNotNullParameter(r2, "mDependency");
        this.a = r2;
        this.d = "";
        this.e = !f;
        f = false;
    }

    public final void a(Uri r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "endPoint");
        int r1 = t.a;
        boolean r2 = this.e;
        cxb.a r3 = this.a;
        Intrinsics.checkNotNullParameter(r3, "dependency");
        Intrinsics.checkNotNullParameter(r6, "endPoint");
        Lazy<Handler> r0 = ThreadUtil.a;
        ThreadUtil.a.b(new m(r3, r2, r6, r5));
    }

    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "endPoint");
        if (TextUtils.isEmpty(r2) == true) goto L5;
        Uri r4 = UriProtector.parse(r2);
    L6:
        a(r4, r3);
        return;
    L5:
        r4 = null;
        goto L6
    }
}
