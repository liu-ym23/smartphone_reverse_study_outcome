package l9;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Typeface;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.room.writer.DaoWriter;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.model.Resources;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.map.api.monitor.MapMonitor;
import com.lynx.tasm.behavior.LynxContext;
import com.obric.oui.image.OImageShape;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile u f19582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f19583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f19584c;

    public static Activity a(Context r5) {
    L15:
    L8:
        e = move-exception;
        mn.h.g("default_handle", e);
        return null;
    L3:
        if ((r5 instanceof ContextWrapper) == false) goto L19;
        if ((r5 instanceof Activity) == true) goto L6;
        r5 = ((ContextWrapper) r5).getBaseContext();     // Catch: Exception -> L8
        goto L15
    L6:
        return (Activity) r5;
    L19:
        return null;
    }

    public static Typeface b(LynxContext r10, byte[] r11) {
        String r5 = ".lynx-font" + Process.myPid() + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + Process.myTid() + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD;
        int r12 = 0;
    L4:
        if (r12 >= 100) goto L10;
        File r13 = new File(r10.getCacheDir(), r5 + r12);
        if (r13.createNewFile() == false) goto L9;
    L11:
        if (r13 != null) goto L28;
        return null;
    L28:
    L23:
        r13.delete();
        return null;
    L20:
        th = move-exception;
        r13.delete();
        throw th;
    L14:
        if (i(r13, r11) == true) goto L17;
        r13.delete();
        return null;
    L17:
        Typeface r14 = Typeface.createFromFile(r13.getPath());     // Catch: Throwable -> L20 RuntimeException -> L23
        r13.delete();
        return r14;
    L9:
        r12 = r12 + 1;
        goto L4
    L10:
        r13 = null;
        goto L11
    }

    public static com.bytedance.ies.argus.repository.a c() {
        return (com.bytedance.ies.argus.repository.a) com.bytedance.ies.argus.repository.a.d.getValue();
    }

    public static StringBuilder d(String r5, Exception r10) {
        MapMonitor.a(r10);
        return new StringBuilder(r5);
    }

    public static u e() {
        if (f19582a != null) goto L6;
        j();
    L6:
        return f19582a;
    }

    public static void f() {
        long r5 = System.currentTimeMillis();
        if ((r5 - f19584c) <= 15000) goto L15;
        File r10 = Environment.getDataDirectory();
        if (r10 != null) goto L13;
    L10:
        long r11 = -1;
    L11:
        f19583b = (int) (r11 / ((long) 1048576));
        f19584c = r5;
        return;
    L13:
        StatFs r12 = new StatFs(r10.getPath());     // Catch: IllegalArgumentException -> L8
        r11 = r12.getBlockSizeLong() * r12.getAvailableBlocksLong();
    L8:
        e = move-exception;
        GeckoLogger.b("getAvailableSize error: " + e);
        goto L10
    }

    public static final void g(FrameLayout r5, s3.b r10, String r11, View r12, Context r13) {
        Intrinsics.checkNotNullParameter(r11, "currentBid");
        Intrinsics.checkNotNullParameter(r12, "defaultTitleBar");
        if (r5 != null) goto L6;
        return;
    L6:
        if (xq.b.k() == false) goto L23;
        if (r10 == null) goto L13;
        rd.b r14 = r10.getSchemaData();
        if (r14 == null) goto L13;
        Boolean r15 = (Boolean) new vd.a(r14, "enable_third_party_web_ui", Boolean.FALSE).f22372b;
        if (r15 == null) goto L13;
        boolean r16 = r15.booleanValue();
    L14:
        if (r16 == false) goto L23;
        if (r10 == null) goto L23;
        if (r13 == null) goto L23;
        tc.c r17 = tc.c.f22119c;
        if (tc.c.f22119c.a(com.bytedance.android.anniex.base.service.g.class, r11) == null) goto L23;
        throw new ClassCastException();
    L13:
        r16 = false;
    L23:
        ViewParent r18 = r12.getParent();
        if (r18 != null) goto L26;
    L28:
        r5.addView(r12);
        return;
    L26:
        if ((r18 instanceof ViewGroup) == false) goto L28;
        ((ViewGroup) r18).removeView(r12);
        goto L28
    }

    public static boolean h(PrepareMeta r10) {
        f();
        if (f19583b >= 30) goto L6;
        return false;
    L6:
        if (r10.getIgnoreStorage() == false) goto L8;
        return true;
    L8:
        String r5 = r10.getAccessKey();
        String r11 = r10.getChannel();
        List<String> r12 = r10.getGroups();
        boolean r13 = com.bytedance.geckox.utils.a.a(r5, r11);
        if (r10.getUpdateWithPatch() == false) goto L12;
        if (r13 == false) goto L12;
        return true;
    L12:
        Pair r14 = df.b.f16647h.b();
        int r15 = ((Number) r14.getFirst()).intValue();
        int r16 = ((Number) r14.getSecond()).intValue();
        if (r15 > 0) goto L15;
    L22:
        if (r16 > 0) goto L24;
    L31:
        return true;
    L24:
        if (f19583b >= r16) goto L31;
        Resources r17 = (Resources) df.b.f16645b.get(r5);
        if (r17 == null) goto L31;
        if (r17.isHit$geckox_noasanRelease(r12, r11) != true) goto L31;
        return false;
    L15:
        if (f19583b >= r15) goto L22;
        Resources r18 = (Resources) df.b.f16644a.get(r5);
        if (r18 != null) goto L19;
    L21:
        return false;
    L19:
        if (r18.isHit$geckox_noasanRelease(r12, r11) != true) goto L21;
        return true;
    }

    public static boolean i(File r5, byte[] r10) {
        FileOutputStream r11 = null;
        FileOutputStream r12 = new FileOutputStream(r5);     // Catch: Throwable -> L11 Exception -> L21
        r12.write(r10);     // Catch: Throwable -> L8 Exception -> L10
        r12.flush();     // Catch: Throwable -> L8 Exception -> L10
    L23:
        r12.close();     // Catch: Exception -> L19
    L7:
        return true;
    L10:
        r11 = r12;
    L8:
        th = th;
        r11 = r12;
    L12:
        if (r11 != null) goto L25;
    L14:
        throw th;
    L25:
        r11.close();     // Catch: Exception -> L20
        goto L14
    L11:
        th = th;
    L15:
        if (r11 == null) goto L33;
        r11.close();     // Catch: Exception -> L22
        return false;
    L34:
        return false;
    L33:
        return false;
    }

    public static s j() {
        if (f19582a != null) goto L16;
        monitor-enter(o.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f19582a != null) goto L11;
        f19582a = new u();     // Catch: Throwable -> L9
        f19582a.f19594a.start();     // Catch: Throwable -> L9
    L11:
        monitor-exit(o.class);     // Catch: Throwable -> L9
    L16:
        return f19582a.f19594a;
    }

    public static final int k(int r5) {
        float r10 = r5;
        org.koin.core.a r11 = su.a.f22013b;
        if (r11 == null) goto L7;
        return (int) ((r10 * ((iu.d) r11.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(iu.d.class), null)).getApplication().getResources().getDisplayMetrics().density) + 0.5f);
    L7:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    public static final float l(OImageShape r5, float r10, float r11) {
        Intrinsics.checkNotNullParameter(r5, "shape");
        int r12 = sr.d.f22003a[r5.ordinal()];
        if (r12 != 1) goto L5;
        return r10;
    L5:
        if (r12 != 2) goto L8;
        return r11;
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
