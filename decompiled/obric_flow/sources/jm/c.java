package jm;

import ai.j0;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.resource.core.AIPackageDeployment;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.ies.bullet.core.container.e;
import com.bytedance.sdk.xbridge.cn.auth.g;
import com.bytedance.sdk.xbridge.cn.platform.lynx.XBridgeLynxModule;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.l0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.UByte;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import ul.d;
import wc.f;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Handler f18357a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f18358b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static d f18359c;

    public static Handler a() {
        if (f18357a != null) goto L16;
        monitor-enter(c.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f18357a != null) goto L11;
        f18357a = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L9
    L11:
        monitor-exit(c.class);     // Catch: Throwable -> L9
    L16:
        return f18357a;
    }

    public static com.bytedance.ies.argus.base.a b() {
        return (com.bytedance.ies.argus.base.a) com.bytedance.ies.argus.base.a.f5012b.getValue();
    }

    public static com.bytedance.sdk.xbridge.cn.platform.lynx.a c(FragmentActivity r10, b4.c r11, l0 r12) {
        String r5 = "webcast";
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "lynxModel");
        Intrinsics.checkNotNullParameter(r12, "lynxViewBuilder");
        TraceEvent.c("XBridgeHelper:getLynxBridge");
    L10:
        th = move-exception;
        TraceEvent.a(0, "XBridgeHelper:getLynxBridge");
        throw th;
    L4:
        if (Intrinsics.areEqual(r11.f861c, "webcast") == true) goto L7;
        r5 = "";
    L7:
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r13 = new com.bytedance.sdk.xbridge.cn.platform.lynx.a(r10, r11.f);     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r12, "lynxViewBuilder");     // Catch: Throwable -> L10
        r12.a(XBridgeLynxModule.class, r13, "bridge");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r5, "<set-?>");     // Catch: Throwable -> L10
        r13.f7360k = r5;     // Catch: Throwable -> L10
        TraceEvent.a(0, "XBridgeHelper:getLynxBridge");
        return r13;
    }

    public static String d(File r10, String r11) {
        MessageDigest r12 = MessageDigest.getInstance(r11);     // Catch: NoSuchAlgorithmException -> L35
        FileInputStream r5 = new FileInputStream(r10);     // Catch: FileNotFoundException -> L33
        byte[] r13 = new byte[8192];     // Catch: Throwable -> L11 IOException -> L24
        int r14 = r5.read(r13);     // Catch: Throwable -> L11 IOException -> L24
    L8:
        int r15 = 0;
        if (r14 <= 0) goto L13;
        r12.update(r13, 0, r14);     // Catch: Throwable -> L11 IOException -> L24
        r14 = r5.read(r13);     // Catch: Throwable -> L11 IOException -> L24
        goto L8
    L13:
        byte[] r16 = r12.digest();     // Catch: Throwable -> L11 IOException -> L24
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L11 IOException -> L24
        int r18 = r16.length;     // Catch: Throwable -> L11 IOException -> L24
    L14:
        if (r15 >= r18) goto L19;
        int r19 = r16[r15] & UByte.MAX_VALUE;     // Catch: Throwable -> L11 IOException -> L24
        if (r19 >= 16) goto L18;
        r17.append("0");     // Catch: Throwable -> L11 IOException -> L24
    L18:
        r17.append(Integer.toHexString(r19));     // Catch: Throwable -> L11 IOException -> L24
        r15 = r15 + 1;     // Catch: Throwable -> L11 IOException -> L24
        goto L14
    L19:
        String r20 = r17.toString();     // Catch: Throwable -> L11 IOException -> L24
    L42:
        r5.close();     // Catch: IOException -> L22
        return r20;
    L22:
        com.bytedance.ies.bullet.base.utils.logger.a.d("XPredefine", "Exception on closing input stream", null, 12);
        return r20;
    L11:
        th = move-exception;
        r5.close();     // Catch: IOException -> L31
    L32:
        throw th;
    L31:
        int r110 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("XPredefine", "Exception on closing input stream", null, 12);
    L24:
        com.bytedance.ies.bullet.base.utils.logger.a.d("XPredefine", "Unable to process file ", null, 12);     // Catch: Throwable -> L11
        r5.close();     // Catch: IOException -> L27
    L28:
        return null;
    L27:
        int r21 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.d("XPredefine", "Exception on closing input stream", null, 12);
    L33:
        com.bytedance.ies.bullet.base.utils.logger.a.d("XPredefine", "Exception while getting FileInputStream", null, 12);
    L34:
        return null;
    }

    public static void e(b4.c r11, AnnieXLynxView r12, com.bytedance.sdk.xbridge.cn.platform.lynx.a r13) {
        int r5 = 13;
        Intrinsics.checkNotNullParameter(r13, "lynxBdxBridge");
        Intrinsics.checkNotNullParameter(r12, "view");
        Intrinsics.checkNotNullParameter(r11, "lynxModel");
        if (Intrinsics.areEqual(r11.f861c, "Loki") == true) goto L5;
        LinkedHashMap r10 = com.bytedance.android.anniex.monitor.c.f3335a;
        com.bytedance.android.anniex.monitor.c.u(r11.f);
    L5:
        r13.s(r12);
        Context r14 = r12.getContext();
        rb.b r15 = new rb.b();
        Intrinsics.checkNotNullParameter(Context.class, "clazz");
        r15.b(Context.class, new rb.a(r14));
        Intrinsics.checkNotNullParameter(LynxView.class, "clazz");
        r15.b(LynxView.class, new rb.a(r12));
        f r16 = new f(12);
        Intrinsics.checkNotNullParameter(de.d.class, "clazz");
        r15.b(de.d.class, new rb.a(r16));
        com.bytedance.frameworks.baselib.network.http.cronet.b r17 = new com.bytedance.frameworks.baselib.network.http.cronet.b(r5);
        Intrinsics.checkNotNullParameter(de.b.class, "clazz");
        r15.b(de.b.class, new rb.a(r17));
        r13.i(rb.b.class, r15);
        com.bytedance.android.anniex.assemble.a.b(p3.d.class, r11.f861c);
        r13.i(kj.b.class, new uj.a());
        g r18 = new g(r5);
        com.bytedance.sdk.xbridge.cn.platform.lynx.c r19 = r13.t();
        r19.getClass();
        Intrinsics.checkNotNullParameter(kj.c.class, "clazz");
        r19.d.put(kj.c.class, new cj.c(r18));
        rb.b r20 = (rb.b) r13.t().a(rb.b.class);
        if (r20 == null) goto L15;
        String r21 = r11.f861c;
        if (((Boolean) com.bytedance.android.anniex.lite.utils.a.f3257a.getValue()).booleanValue() == false) goto L10;
        com.bytedance.android.anniex.assemble.a.b(p3.c.class, r21);
    L12:
        com.bytedance.ies.bullet.service.base.c r22 = new com.bytedance.ies.bullet.service.base.c(r5);
        Intrinsics.checkNotNullParameter(ee.a.class, "clazz");
        r20.b(ee.a.class, new rb.a(r22, 0));
        Intrinsics.checkNotNullParameter(kj.c.class, "clazz");
        r20.b(kj.c.class, new rb.a(r18, 0));
        o3.b r23 = new o3.b(r11, r12, r13);
        Intrinsics.checkNotNullParameter(e.class, "clazz");
        r20.b(e.class, new rb.a(r23, 0));
        goto L15
    L10:
        com.bytedance.android.anniex.assemble.a.b(p3.c.class, r21);
        tc.c r24 = tc.c.f22119c;
        if (tc.c.f22119c.a(p3.c.class, r21) == null) goto L12;
        throw new ClassCastException();
    L15:
        tc.c r25 = tc.c.f22119c;
        pb.a r26 = (pb.a) tc.c.f22119c.a(pb.a.class, r11.f861c);
        if (r26 == null) goto L38;
        rb.b r27 = (rb.b) r13.t().a(rb.b.class);
        if (r27 == null) goto L20;
        List r28 = r26.c(r27);
    L21:
        if (r28 == null) goto L27;
        Iterator r29 = r28.iterator();
    L24:
        if (r29.hasNext() == false) goto L27;
        r13.g((h) r29.next());
    L27:
        if ((r26 instanceof com.ivy.ivykit.plugin.impl.jsb.c) == false) goto L38;
        com.ivy.ivykit.plugin.impl.jsb.c r30 = (com.ivy.ivykit.plugin.impl.jsb.c) r26;
        rb.b r31 = (rb.b) r13.t().a(rb.b.class);
        if (r31 != null) goto L31;
        r31 = new rb.b();
    L31:
        Intrinsics.checkNotNullParameter(r31, "providerFactory");
        if (Intrinsics.areEqual(r11.f860b.getQueryParameter("enable_annie_jsb_for_common"), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L38;
        rb.b r32 = (rb.b) r13.t().a(rb.b.class);
        if (r32 != null) goto L36;
        r32 = new rb.b();
    L36:
        com.bytedance.android.anniex.utils.e.d(r11, r12, r13, r32);
        goto L38
    L20:
        r28 = null;
    L38:
        if (xq.b.e() == false) goto L49;
        tc.c r110 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r111 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r111 == null) goto L46;
        com.bytedance.ies.bullet.service.base.d r112 = (com.bytedance.ies.bullet.service.base.d) r111.f6163b.getValue();
        if (r112 == null) goto L46;
        ArrayList r113 = r112.f5966h;
        r13.f7366q = Boolean.FALSE;
        r13.f7365p = r113;
    L46:
        if (Intrinsics.areEqual(r11.f861c, "webcast") == false) goto L49;
        List r114 = CollectionsKt.listOf(new com.bytedance.sdk.xbridge.cn.optimize.c(SetsKt.hashSetOf(new String[]{"bdx_thread_opt_all_schema"}), SetsKt.hashSetOf(new String[]{"sendLogV3", "setStorage"}), 26));
        r13.f7366q = Boolean.TRUE;
        r13.f7365p = r114;
    L49:
        if (Intrinsics.areEqual(r11.f861c, "Loki") == true) goto L53;
        LinkedHashMap r115 = com.bytedance.android.anniex.monitor.c.f3335a;
        com.bytedance.android.anniex.monitor.c.w(r11.f);
        return;
    }

    public static void f(AIPackageDeployment.AIPackageDeploymentItem r5, StringBuilder r10, String r11) {
        r10.append(r5.getPackageName());
        r10.append(r11);
    }

    public static void g(String r5, com.bytedance.sdk.xbridge.cn.platform.lynx.a r10) {
        Intrinsics.checkNotNullParameter(r5, "bid");
        if (r10 == null) goto L17;
        com.bytedance.sdk.xbridge.cn.platform.lynx.c r11 = r10.t();
        if (r11 == null) goto L18;
        rb.b r12 = (rb.b) r11.a(rb.b.class);
        if (r12 == null) goto L19;
        com.bytedance.android.anniex.assemble.a.b(p3.c.class, r5);
        if (((Boolean) com.bytedance.android.anniex.lite.utils.a.f3257a.getValue()).booleanValue() == true) goto L15;
        tc.c r13 = tc.c.f22119c;
        if (tc.c.f22119c.a(p3.c.class, r5) == null) goto L15;
        throw new ClassCastException();
    L15:
        r12.f21717a.clear();
        return;
    L19:
        return;
    L18:
        return;
    }

    public static boolean h(Context r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, "tag");
        if (com.bytedance.android.anniex.container.ui.c.f3195c == true) goto L29;
        com.bytedance.android.anniex.container.ui.c.f3195c = true;
        ConcurrentHashMap r12 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r13 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r13 == null) goto L11;
        xc.d r14 = (xc.d) r13.a(xc.d.class);
        if (r14 == null) goto L11;
        Boolean r15 = r14.Q();
        if (r15 == null) goto L11;
        boolean r16 = r15.booleanValue();
    L13:
        if (r16 == false) goto L20;
        com.bytedance.android.anniex.assemble.a.b(p3.c.class, r10);
        tc.c r17 = tc.c.f22119c;
        if (tc.c.f22119c.a(p3.c.class, r10) != null) goto L19;
        com.bytedance.ies.bullet.base.utils.logger.a.g(r11, "initAnnieXCardBizEnv failed", null, 12);
        return false;
    L19:
        throw new ClassCastException();
    L20:
        if (r5 != null) goto L23;
        com.bytedance.ies.bullet.base.utils.logger.a.g(r11, "BulletSdk.ensureDefaultBidReady failed, message = context is null", null, 12);
        return false;
    L23:
        com.bytedance.android.anniex.assemble.a.f3108a.a(r5);
        com.bytedance.ies.bullet.base.b.a(r5);     // Catch: Throwable -> L26
        com.bytedance.ies.bullet.base.utils.logger.a.g(r11, "BulletSdk.ensureDefaultBidReady success", null, 12);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        int r18 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g(r11, "BulletSdk.ensureDefaultBidReady failed, message = " + th.getMessage(), null, 12);
        return false;
    L11:
        r16 = true;
    L29:
        return true;
    }

    public static boolean i() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L6;
        return true;
    L6:
        return false;
    }

    public static int j(long r5, long r10) {
        if (r5 >= r10) goto L6;
        return -1;
    L6:
        if (r5 <= r10) goto L9;
        return 1;
    L9:
        return 0;
    }

    public static boolean k(Comparable r5, Object r10) {
        if (r10 != null) goto L7;
        if (r5 != null) goto L11;
        return true;
    L11:
        return false;
    L7:
        if (r5 != null) goto L10;
        return false;
    L10:
        return r10.equals(r5);
    }

    public static long l(long r5, long r10) {
        if (r5 < 0) goto L6;
        return r5 / r10;
    L6:
        return ((r5 + 1) / r10) - 1;
    }

    public static int m(int r5) {
        return ((r5 % 7) + 7) % 7;
    }

    public static int n(int r5, long r10) {
        long r11 = r5;
        return (int) (((r10 % r11) + r11) % r11);
    }

    public static long o(long r5, long r10) {
        return ((r5 % r10) + r10) % r10;
    }

    public static void p(Object r5, String r10) {
        if (r5 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(r10.concat(" must not be null"));
    }

    public static int q(int r5, int r10) {
        int r11 = r5 + r10;
        if ((r5 ^ r11) < 0) goto L5;
    L9:
        return r11;
    L5:
        if ((r5 ^ r10) < 0) goto L9;
        throw new ArithmeticException(j0.f(r5, r10, "Addition overflows an int: ", " + "));
    }

    public static long r(long r10, long r11) {
        long r5 = r10 + r11;
        if ((r10 ^ r5) < 0) goto L5;
    L9:
        return r5;
    L5:
        if ((r10 ^ r11) < 0) goto L9;
        StringBuilder r12 = j0.t(r10, "Addition overflows a long: ", " + ");
        r12.append(r11);
        throw new ArithmeticException(r12.toString());
    }

    public static int s(int r5, int r10) {
        long r11 = ((long) r5) * ((long) r10);
        if (r11 < (-2147483648L)) goto L9;
        if (r11 > 2147483647L) goto L9;
        return (int) r11;
    L9:
        throw new ArithmeticException(j0.f(r5, r10, "Multiplication overflows an int: ", " * "));
    }

    public static long t(int r10, long r11) {
        if (r10 == (-1)) goto L16;
        if (r10 != 0) goto L6;
        return 0;
    L6:
        if (r10 == 1) goto L12;
        long r5 = r10;
        long r12 = r11 * r5;
        if ((r12 / r5) != r11) goto L11;
        return r12;
    L11:
        throw new ArithmeticException("Multiplication overflows a long: " + r11 + " * " + r10);
    L12:
        return r11;
    L16:
        if (r11 == Long.MIN_VALUE) goto L20;
        return -r11;
    L20:
        throw new ArithmeticException("Multiplication overflows a long: " + r11 + " * " + r10);
    }

    public static long u(long r10, long r11) {
        if (r11 != 1) goto L6;
        return r10;
    L6:
        if (r10 != 1) goto L9;
        return r11;
    L9:
        if (r10 != 0) goto L11;
    L26:
        return 0;
    L11:
        if (r11 == 0) goto L26;
        long r5 = r10 * r11;
        if ((r5 / r11) == r10) goto L16;
    L24:
        StringBuilder r12 = j0.t(r10, "Multiplication overflows a long: ", " * ");
        r12.append(r11);
        throw new ArithmeticException(r12.toString());
    L16:
        if (r10 != Long.MIN_VALUE) goto L20;
        if (r11 == (-1)) goto L24;
    L20:
        if (r11 == Long.MIN_VALUE) goto L22;
    L23:
        return r5;
    L22:
        if (r10 == (-1)) goto L24;
        goto L23
    }

    public static int v(int r5, int r10) {
        int r11 = r5 - r10;
        if ((r5 ^ r11) < 0) goto L5;
    L9:
        return r11;
    L5:
        if ((r5 ^ r10) >= 0) goto L9;
        throw new ArithmeticException(j0.f(r5, r10, "Subtraction overflows an int: ", " - "));
    }

    public static long w(long r10, long r11) {
        long r5 = r10 - r11;
        if ((r10 ^ r5) < 0) goto L5;
    L9:
        return r5;
    L5:
        if ((r10 ^ r11) >= 0) goto L9;
        StringBuilder r12 = j0.t(r10, "Subtraction overflows a long: ", " - ");
        r12.append(r11);
        throw new ArithmeticException(r12.toString());
    }

    public static int x(long r5) {
        if (r5 > 2147483647L) goto L9;
        if (r5 < (-2147483648L)) goto L9;
        return (int) r5;
    L9:
        throw new ArithmeticException(androidx.constraintlayout.motion.widget.a.j(r5, "Calculation overflows an int: "));
    }
}
