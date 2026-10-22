package uqa;

import android.app.Activity;
import android.app.Application;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.message.util.ToolUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqa.c;
import mqa.g;
import mqa.h;
import mqa.i;
import nqa.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public final Application a;
    public C0031a b;
    public final PolarisFileWrapper c;

    /* JADX INFO: renamed from: uqa.a$a, reason: collision with other inner class name */
    public class C0031a implements Application.ActivityLifecycleCallbacks {
        public final Application a;
        public h b;
        public final /* synthetic */ a c;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r1, Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r1) {
        }

        public C0031a(a r1, Application r2) {
            this.c = r1;
            this.a = r2;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r8, Bundle r9) {
            boolean r0 = true;
            Field r1 = Activity.class.getDeclaredField("mReferrer");     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
            r1.setAccessible(true);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
            String r2 = (String) r1.get(r8);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        L11:
            if (Build.VERSION.SDK_INT < 22) goto L18;
            if (a.a(r2, r8) == true) goto L18;
            Uri r3 = r8.getReferrer();
            if (r3 == null) goto L18;
            r2 = r3.getHost();
        L18:
            if (a.a(r2, r8) == true) goto L21;
            r2 = r8.getCallingPackage();
        L21:
            if (a.a(r2, r8) == true) goto L27;
            r2 = r8.getPackageManager().getNameForUid(Binder.getCallingUid());     // Catch: Exception -> L24
        L24:
            e = move-exception;
            e.printStackTrace();
        L27:
            if (Logger.debug() == false) goto L29;
            Logger.d("ActivityAliveTracker", "startActivity = " + r8.getComponentName().getClassName() + ", referrer = " + r2);
        L29:
            boolean r4 = false;
            if (this.b != null) goto L32;
            boolean r10 = false;
        L36:
            List r5 = vqa.a.a;
            String r6 = r8.getComponentName().getClassName();
            Iterator r7 = ((ArrayList) vqa.a.a).iterator();
        L38:
            if (r7.hasNext() == false) goto L44;
            String r11 = (String) r7.next();
            if (StringUtils.equal(r6, r11) == true) goto L43;
            if (r6.contains(r11) == false) goto L38;
        L43:
            boolean r12 = true;
        L45:
            if (r12 == false) goto L79;
            return;
        L79:
        L54:
            e = move-exception;
            e.printStackTrace();
        L56:
            if (r10 == false) goto L59;
            this.a.unregisterActivityLifecycleCallbacks(this);
            return;
        L59:
            if (r4 == false) goto L75;
            i r13 = new i();
            r13.a = ToolUtils.currentTimeMillis();
            r13.f = r8.getIntent();
            r13.g = r2;
            r13.b = ToolUtils.getCurProcessName(r8);
            r13.h = vqa.a.a(r8);
            r13.e = 4;
            Application r14 = this.a;
            if (g.c != null) goto L73;
            monitor-enter(g.class);
        L69:
            th = move-exception;
            throw th;
        L65:
            if (g.c != null) goto L67;
            g.c = new g(r14);     // Catch: Throwable -> L69
        L67:
            monitor-exit(g.class);     // Catch: Throwable -> L69
        L73:
            if (g.c.a().a == false) goto L75;
            b r15 = new b();
            r15.b = r13.a().toString();
            r15.c = -1;
            ThreadPlus.submitRunnable(new a(this, r15));
        L75:
            this.a.unregisterActivityLifecycleCallbacks(this);
            return;
        L48:
            if (this.c.c.exists() == true) goto L52;
            if (this.c.c.createNewFile() == false) goto L52;
        L53:
            r4 = r0;
        L52:
            r0 = false;
            goto L53
        L44:
            r12 = false;
            goto L45
        L32:
            if (a.a(r2, r8) == false) goto L34;
            c r16 = this.b.a;
            i r17 = r16.g;
            r17.g = r2;
            ThreadPlus.submitRunnable(new mqa.b(r16, r17.a().toString()));
        L34:
            this.b = null;
            r10 = true;
        L5:
            e = move-exception;
            e.printStackTrace();
        L9:
            r2 = null;
        L7:
            e = move-exception;
            e.printStackTrace();
            goto L9
        }
    }

    public a(Application r2, boolean r3) {
        this.a = r2;
        this.c = new PolarisFileWrapper(r2.getFilesDir(), "process_activity.lock");
    }

    public static boolean a(String r1, Activity r2) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(r1, r2.getPackageName()) == true) goto L7;
        return true;
    }
}
