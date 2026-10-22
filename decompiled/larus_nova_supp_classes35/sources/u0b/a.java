package u0b;

import android.app.Application;
import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.ResConfig;
import com.ss.android.lark.chameleon.ResGeckoConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResUtils;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.provider.interceptor.ChameleonAbsResInterceptor;
import com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import swb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class a {
    public final ChameleonDefaultResFetcher a;

    /* JADX INFO: renamed from: u0b.a$a, reason: collision with other inner class name */
    public static final class C0304a {
    }

    static {
    }

    public abstract com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d b(Context r1, ChameleonConfig r2, boolean r3, String r4);

    public abstract boolean d(Context r1, ChameleonConfig r2);

    public a() {
        this.a = new ChameleonDefaultResFetcher();
    }

    public final com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d a(Context r1, ChameleonConfig r2, boolean r3, String r4) {
        if (r3 == false) goto L4;
        VFSPath r5 = this.a.b(r2, r1, r4);
    L6:
        if (r2 == null) goto L10;
        ResConfig r6 = r2.getResConfig();
        if (r6 == null) goto L10;
        String r7 = r6.getResVersion();
    L12:
        return new com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d(r5, r7);
    L10:
        r7 = null;
        goto L12
    L4:
        r5 = this.a.a(r2, r1, r4);
        goto L6
    }

    public final com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d c(ChameleonConfig r10, VFSFile r11, String r12, String r13) throws IOException {
        Intrinsics.checkNotNullParameter(r11, "parent");
        Intrinsics.checkNotNullParameter(r12, Keys.API_RETURN_KEY_VERSION);
        Intrinsics.checkNotNullParameter(r13, "channel");
        int r0 = com.ss.android.lark.officesdk.utils.di.d.a;
        Application r1 = com.ss.android.lark.officesdk.utils.di.d.a.a();
        VFSPath r14 = r11.getVfsPath().subPath(r12);
        if (r10 == null) goto L12;
        ResConfig r2 = r10.getResConfig();
        if (r2 == null) goto L12;
        String r3 = r2.getOfflineZipName();
        if (r3 == null) goto L12;
        List r4 = StringsKt.split$default(r3, new String[]{"."}, false, 0, 6, null);
        if (r4 == null) goto L12;
        String r5 = (String) ListProtector.get(r4, 0);
        if (r5 == null) goto L12;
    L13:
        VFSPath r6 = r14.subPath(r5);
        j.e(ChameleonAbsResInterceptor.TAG, "getResourceInternal, res = " + r6.getRealPath());
        boolean r7 = g.a(r6);
        j.e(ChameleonAbsResInterceptor.TAG, "getResourceInternal, check completion = " + r7);
        if (r7 == true) goto L43;
        int r8 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.a;
        Intrinsics.checkNotNullParameter(r1, "context");
        j.e(ChameleonResUtils.TAG, "clearGeckoResourceByChannel, channel = ".concat(r13));
        if (r10 == null) goto L22;
        ResConfig r9 = r10.getResConfig();
        if (r9 == null) goto L22;
        ResGeckoConfig r15 = r9.getGeckoConfig();
        if (r15 == null) goto L22;
        String r16 = s0b.a.a(r1, r15);
    L23:
        boolean r17 = true;
        if (r16 != null) goto L26;
    L31:
        boolean r18 = false;
    L32:
        if (r18 == true) goto L34;
    L42:
        swb.j.g(r14);
        goto L43
    L34:
        if (r13.length() <= 0) goto L36;
        boolean r19 = true;
    L37:
        if (r19 == true) goto L40;
        r17 = false;
    L40:
        if (r17 == false) goto L42;
        swb.j.h(s0b.a.b().getVfsPath().subPath(r16).subPath(r13));
        goto L42
    L36:
        r19 = false;
        goto L37
    L26:
        if (r16.length() <= 0) goto L28;
        boolean r20 = true;
    L29:
        if (r20 != true) goto L31;
        r18 = true;
        goto L32
    L28:
        r20 = false;
    L22:
        r16 = null;
    L43:
        if (r7 == false) goto L46;
        return new com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d(r6, r12);
    L46:
        return a(r1, r10, false, null);
    L12:
        r5 = BuildConfig.FLAVOR;
        goto L13
    }
}
