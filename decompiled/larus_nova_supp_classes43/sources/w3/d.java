package w3;

import android.app.Activity;
import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import androidx.core.content.ContextCompat;
import com.bytedance.ai.utils.g;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.google.gson.JsonObject;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import f2.k;
import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final d a = null;
    public static final Object b = null;
    public static Context c;
    public static c d;
    public static c e;
    public static String f;
    public static long g;
    public static final String[] h = null;

    public static final class a {
        public static final a a = null;
        public static WeakReference<Activity> b;
        public static Object c;
        public static Class<?> d;

        static {
            a = new a();
        }

        public a() {
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r10 = Class.forName("android.app.Activity$ScreenCaptureCallback");     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("android.app.Activity$ScreenCaptureCallback");     // Catch: Throwable -> L8
        L7:
            return r10;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("android.app.Activity$ScreenCaptureCallback");
        L12:
            throw th;
        L34:
            Class<?> r11 = Class.forName("android.app.Activity$ScreenCaptureCallback");     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("android.app.Activity$ScreenCaptureCallback");     // Catch: Throwable -> L17
        L16:
            return r11;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("android.app.Activity$ScreenCaptureCallback");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("android.app.Activity$ScreenCaptureCallback");
        }

        public static void b(Activity r10) {
            if (Build.VERSION.SDK_INT < 34) goto L28;
            if (r10 == null) goto L30;
            WeakReference<Activity> r0 = b;
            if (r0 == null) goto L9;
            Activity r1 = r0.get();
        L10:
            if (r1 == r10) goto L12;
        L14:
            c(null);
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L17
            Class<?> r12 = a();     // Catch: Throwable -> L17
            Object r13 = Proxy.newProxyInstance(r12.getClassLoader(), new Class[]{r12}, new w3.c());     // Catch: Throwable -> L17
            Activity.class.getMethod("registerScreenCaptureCallback", new Class[]{Executor.class, r12}).invoke(r10, new Object[]{r10.getMainExecutor(), r13});     // Catch: Throwable -> L17
            b = new WeakReference(r10);     // Catch: Throwable -> L17
            c = r13;     // Catch: Throwable -> L17
            d = r12;     // Catch: Throwable -> L17
            Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
        L20:
            if (Result.isSuccess-impl(r14) == false) goto L22;
            Unit r15 = (Unit) r14;
            g.a.i("UserCaptureScreenEventHelper", "android screen capture callback registered");
        L22:
            Throwable r16 = Result.exceptionOrNull-impl(r14);
            if (r16 == null) goto L29;
            g.a.w("UserCaptureScreenEventHelper", "register android screen capture callback failed", r16);
            return;
        L29:
            return;
        L17:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            r14 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L20
        L12:
            if (c == null) goto L14;
            return;
        L9:
            r1 = null;
            goto L10
        L30:
            return;
        }

        public static void c(Activity r10) {
            WeakReference<Activity> r0 = b;
            if (r0 == null) goto L5;
            Activity r1 = r0.get();
        L6:
            if (r10 == null) goto L9;
            if (r1 == r10) goto L9;
            return;
        L9:
            Object r11 = c;
            Class<?> r12 = d;
            if (r1 == null) goto L23;
            if (r11 == null) goto L23;
            if (r12 == null) goto L23;
            Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L15
            Object r14 = Result.constructor-impl(Activity.class.getMethod("unregisterScreenCaptureCallback", new Class[]{r12}).invoke(r1, new Object[]{r11}));     // Catch: Throwable -> L15
        L18:
            if (Result.isSuccess-impl(r14) == false) goto L20;
            g.a.i("UserCaptureScreenEventHelper", "android screen capture callback unregistered");
        L20:
            Throwable r15 = Result.exceptionOrNull-impl(r14);
            if (r15 == null) goto L23;
            g.a.w("UserCaptureScreenEventHelper", "unregister android screen capture callback failed", r15);
        L15:
            th = move-exception;
            Result.Companion r16 = Result.Companion;
            r14 = Result.constructor-impl(ResultKt.createFailure(th));
        L23:
            b = null;
            c = null;
            d = null;
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class b {
        public final Uri a;
        public final long b;
        public final String c;
        public final String d;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "MediaImageSnapshot(uri=" + this.a + ", dateAdded=" + this.b + ", path=" + this.c + ')';
        }

        public b(Uri r10, long r11, String r12) {
            Intrinsics.checkNotNullParameter(r10, "uri");
            Intrinsics.checkNotNullParameter(r12, "path");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r10.toString();
        }
    }

    public static final class c extends ContentObserver {
        public final Uri a;
        public final WeakReference<Context> b;
        public boolean c;

        @Override // android.database.ContentObserver
        public final void onChange(boolean r20) {
            super.onChange(r20);
            Context r0 = this.b.get();
            if (r0 != null) goto L5;
            return;
        L5:
            int r10 = Build.VERSION.SDK_INT;
            if (r10 < 33) goto L8;
            String r11 = "android.permission.READ_MEDIA_IMAGES";
        L10:
            if (ContextCompat.checkSelfPermission(r0, r11) != 0) goto L12;
            boolean r12 = true;
        L14:
            if (r12 == false) goto L16;
            Uri r13 = this.a;
            List r14 = CollectionsKt.mutableListOf(new String[]{"_id", "date_added", "_display_name"});
            if (r10 < 29) goto L22;
            r14.add("relative_path");
        L105:
            Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L74
            Cursor r1 = a(r0.getContentResolver(), r13, (String[]) r14.toArray(new String[0]));     // Catch: Throwable -> L74
            if (r1 == null) goto L71;
            Cursor r16 = r1;     // Catch: Throwable -> L74
            Cursor r17 = r16;     // Catch: Throwable -> L64
            if (r17.moveToFirst() == true) goto L30;
            b r18 = null;
        L62:
            CloseableKt.closeFinally(r16, null);     // Catch: Throwable -> L74
        L72:
            Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L74
        L76:
            Throwable r21 = Result.exceptionOrNull-impl(r19);
            if (r21 == null) goto L80;
            g.a.w("UserCaptureScreenEventHelper", "queryLatestImage failed, uri=" + r13, r21);
        L80:
            if (Result.isFailure-impl(r19) == false) goto L82;
            r19 = null;
        L82:
            b r22 = (b) r19;
            if (r22 != null) goto L85;
            return;
        L85:
            long r23 = System.currentTimeMillis() - (r22.b * 1000);
            if ((-6000) <= r23) goto L88;
        L90:
            boolean r24 = false;
        L91:
            if (r24 == false) goto L111;
            String r25 = r22.c.toLowerCase(Locale.ROOT);
            String[] r26 = d.h;
            int r27 = r26.length;
            int r28 = 0;
        L93:
            if (r28 >= r27) goto L98;
            if (StringsKt.contains$default(r25, r26[r28], false, 2, null) == true) goto L96;
            r28 = r28 + 1;
            goto L93
        L96:
            boolean r29 = true;
        L99:
            if (r29 == false) goto L112;
            d.a(d.a, r22.d);
            return;
        L112:
            return;
        L98:
            r29 = false;
            goto L99
        L111:
            return;
        L88:
            if (r23 >= 6001) goto L90;
            r24 = true;
            goto L91
        L30:
            int r30 = r17.getColumnIndex("_id");     // Catch: Throwable -> L64
            long r110 = 0;
            if (r30 < 0) goto L33;
            long r31 = r17.getLong(r30);     // Catch: Throwable -> L64
        L34:
            int r32 = r17.getColumnIndex("date_added");     // Catch: Throwable -> L64
            if (r32 < 0) goto L37;
            r110 = r17.getLong(r32);     // Catch: Throwable -> L64
        L37:
            long r33 = r110;
            int r34 = r17.getColumnIndex("_display_name");     // Catch: Throwable -> L64
            if (r34 < 0) goto L41;
            String r35 = r17.getString(r34);     // Catch: Throwable -> L64
        L42:
            String r111 = "";
            if (r35 != null) goto L45;
            r35 = "";
        L45:
            if (r10 < 29) goto L54;
            int r36 = r17.getColumnIndex("relative_path");     // Catch: Throwable -> L64
            if (r36 < 0) goto L49;
            String r37 = r17.getString(r36);     // Catch: Throwable -> L64
        L50:
            if (r37 == null) goto L53;
            r111 = r37;
        L53:
            r111 = r111.concat(r35);     // Catch: Throwable -> L64
        L61:
            r18 = new b(ContentUris.withAppendedId(r13, r31), r33, r111);     // Catch: Throwable -> L64
        L49:
            r37 = null;
            goto L50
        L54:
            int r38 = r17.getColumnIndex("_data");     // Catch: Throwable -> L64
            if (r38 < 0) goto L57;
            String r39 = r17.getString(r38);     // Catch: Throwable -> L64
        L58:
            if (r39 == null) goto L61;
            r111 = r39;
            goto L61
        L57:
            r39 = null;
            goto L58
        L41:
            r35 = null;
            goto L42
        L33:
            r31 = 0;
        L64:
            th = move-exception;
            throw th;     // Catch: Throwable -> L67
        L67:
            th = move-exception;
            CloseableKt.closeFinally(r16, th);     // Catch: Throwable -> L74
            throw th;     // Catch: Throwable -> L74
        L71:
            r18 = null;
        L74:
            th = move-exception;
            Result.Companion r40 = Result.Companion;
            r19 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L76
        L22:
            r14.add("_data");
            goto L105
        L16:
            if (this.c == true) goto L110;
            g.a.w("UserCaptureScreenEventHelper", "screen capture content observer skipped: missing image read permission");
            this.c = true;
            return;
        L110:
            return;
        L12:
            r12 = false;
            goto L14
        L8:
            r11 = "android.permission.READ_EXTERNAL_STORAGE";
            goto L10
        }

        public c(Uri r10, WeakReference<Context> r11) {
            Intrinsics.checkNotNullParameter(r10, "uri");
            Intrinsics.checkNotNullParameter(r11, "context");
            super(new Handler(Looper.getMainLooper()));
            this.a = r10;
            this.b = r11;
        }

        public static Cursor a(ContentResolver r17, Uri r18, String[] r19) {
            f06.c r14 = new f06.c();
            Object[] r15 = {r18, r19, null, null, "date_added DESC"};
            f06.b r16 = new f06.b();
            f06.d r0 = r14.b(240004, "android/content/ContentResolver", "query", r17, r15, "android.database.Cursor", r16);
            if (r0.a == false) goto L6;
            r14.a(240004, "android/content/ContentResolver", "query", r17, r15, null, r16, false);
            return (Cursor) r0.b;
        L6:
            Cursor r1 = r17.query(r18, r19, null, null, "date_added DESC");
            r14.a(240004, "android/content/ContentResolver", "query", r17, r15, r1, r16, true);
            return r1;
        }
    }

    public d() {
    }

    static {
        a = new d();
        b = new Object();
        h = new String[]{"screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap", "截屏", "截图"};
    }

    public static void c() {
        Context r0 = k.a().getApplicationContext();
        Object r1 = b;
        monitor-enter(r1);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (c == null) goto L8;
        monitor-exit(r1);
        return;
    L8:
        c = r0;     // Catch: Throwable -> L21
        d r10 = a;     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L21
        r10.getClass();     // Catch: Throwable -> L21
        b(r0);     // Catch: Throwable -> L21
        if (Build.VERSION.SDK_INT >= 34) goto L12;
    L18:
        a r11 = a.a;     // Catch: Throwable -> L21
        Activity r12 = k.b();     // Catch: Throwable -> L21
        r11.getClass();     // Catch: Throwable -> L21
        a.b(r12);     // Catch: Throwable -> L21
        g.a.i("UserCaptureScreenEventHelper", "start monitoring success");     // Catch: Throwable -> L21
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r1);
        return;
    L12:
        if ((r0 instanceof Application) == false) goto L14;
        Application r14 = (Application) r0;     // Catch: Throwable -> L21
    L15:
        if (r14 == null) goto L18;
        r14.registerActivityLifecycleCallbacks(new e());     // Catch: Throwable -> L21
        goto L18
    L14:
        r14 = null;
        goto L15
    }

    public static void b(Context r10) {
        if (Build.VERSION.SDK_INT <= 28) goto L5;
        boolean r0 = true;
    L6:
        d = new c(MediaStore.Images.Media.INTERNAL_CONTENT_URI, new WeakReference(r10));
        e = new c(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new WeakReference(r10));
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        ContentResolver r11 = r10.getContentResolver();     // Catch: Throwable -> L16
        Uri r12 = MediaStore.Images.Media.INTERNAL_CONTENT_URI;     // Catch: Throwable -> L16
        c r13 = d;     // Catch: Throwable -> L16
        if (r13 == null) goto L14;
        r11.registerContentObserver(r12, r0, r13);     // Catch: Throwable -> L16
        ContentResolver r14 = r10.getContentResolver();     // Catch: Throwable -> L16
        Uri r15 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;     // Catch: Throwable -> L16
        c r16 = e;     // Catch: Throwable -> L16
        if (r16 == null) goto L14;
        r14.registerContentObserver(r15, r0, r16);     // Catch: Throwable -> L16
    L14:
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L19:
        if (Result.isSuccess-impl(r17) == false) goto L21;
        Unit r18 = (Unit) r17;
        g.a.i("UserCaptureScreenEventHelper", "content observers registered");
    L21:
        Throwable r19 = Result.exceptionOrNull-impl(r17);
        if (r19 == null) goto L27;
        g.a.w("UserCaptureScreenEventHelper", "registerContentObservers failed", r19);
        return;
    L27:
        return;
    L16:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L5:
        r0 = false;
        goto L6
    }

    public static final void a(d r10, String r11) {
        r10.getClass();
        long r0 = System.currentTimeMillis();
        Object r12 = b;
        monitor-enter(r12);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(f, r11) == false) goto L7;
    L12:
        monitor-exit(r12);
        return;
    L7:
        if ((r0 - g) < 1000) goto L12;
        f = r11;     // Catch: Throwable -> L14
        g = r0;     // Catch: Throwable -> L14
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r12);
        g.a.i("UserCaptureScreenEventHelper", "publish user capture screen event");
        Lazy r14 = l3.d.a;
        l3.d.c(new l3.a("doubao.onUserCaptureScreen", new JsonObject(), 4));
    }
}
