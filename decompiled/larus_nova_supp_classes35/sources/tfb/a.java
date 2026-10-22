package tfb;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.floating.enums.ShowPattern;
import com.ss.android.lark.floating.widget.appfloat.AppFloatManager;
import com.ss.android.lark.floating.widget.appfloat.TouchUtils;
import com.ss.android.lark.log.Log;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import wfb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final b a = null;
    public static final AtomicBoolean b = null;
    public static c c;

    /* JADX INFO: renamed from: tfb.a$a, reason: collision with other inner class name */
    public static final class C0302a implements g {
        public final Context a;
        public final vfb.a b;

        /* JADX INFO: renamed from: tfb.a$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0303a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ShowPattern.values().length];
                r0[ShowPattern.CURRENT_ACTIVITY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[ShowPattern.FOREGROUND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[ShowPattern.BACKGROUND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[ShowPattern.ALL_TIME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        public final void c() {
            if (FeatureGatingModule.getFeatureGatingService().isEnable("core.appfloat.windowsize_refactor") == false) goto L9;
            xfb.g r0 = xfb.g.e;
            if (r0 != null) goto L8;
            r0 = new xfb.g();
            xfb.g.e = r0;
        L8:
            r0.a();
        L9:
            com.ss.android.lark.floating.widget.appfloat.c r1 = com.ss.android.lark.floating.widget.appfloat.c.a;
            Context r2 = this.a;
            vfb.a r3 = this.b;
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "config");
            String r4 = r3.d;
            if (r4 != null) goto L12;
            r4 = "default";
        L12:
            r3.d = r4;
            Map<String, AppFloatManager> r5 = com.ss.android.lark.floating.widget.appfloat.c.b;
            if ((!r5.containsKey(r4)) == false) goto L33;
            String r6 = r3.d;
            if (r6 == null) goto L29;
            AppFloatManager r7 = new AppFloatManager(r2.getApplicationContext(), r3);
            r7.f = new TouchUtils(r7.a, r7.b);     // Catch: Exception -> L20
            r7.g();     // Catch: Exception -> L20
            r7.a();     // Catch: Exception -> L20
            r7.b.k = true;     // Catch: Exception -> L20
            Unit r8 = Unit.INSTANCE;     // Catch: Exception -> L20
        L28:
            r5.put(r6, r7);
        L20:
            e = move-exception;
            r7.b.getClass();
            wfb.a r9 = r7.b.B;
            if (r9 == null) goto L28;
            wfb.a.C0318a r10 = r9.a();
            if (r10 == null) goto L28;
            Function3<? super Boolean, ? super String, ? super View, Unit> r11 = r10.a;
            if (r11 == null) goto L28;
            r11.invoke(Boolean.FALSE, String.valueOf(e), null);
            Unit r12 = Unit.INSTANCE;
        L29:
            Unit r13 = Unit.INSTANCE;
            return;
        }

        public C0302a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            this.a = r2;
            this.b = new vfb.a(null);
        }

        @Override // wfb.g
        public final void a(boolean r1) {
            if (r1 == false) goto L4;
            c();
            return;
        L4:
            b("No permission exception. You need to turn on overlay permissions.");
        }

        public final void b(String r4) {
            this.b.getClass();
            wfb.a r0 = this.b.B;
            if (r0 == null) goto L9;
            wfb.a.C0318a r1 = r0.a();
            if (r1 == null) goto L9;
            Function3<? super Boolean, ? super String, ? super View, Unit> r2 = r1.a;
            if (r2 == null) goto L9;
            r2.invoke(Boolean.FALSE, r4, null);
        L9:
            Log.w(r4);
            int r3 = r4.hashCode();
            if (r3 == 324317221) goto L23;
            if (r3 == 832581388) goto L20;
            if (r3 == 952571600) goto L17;
            return;
        L17:
            if (r4.equals("Uninitialized exception. You need to initialize in the application.") == true) goto L26;
            return;
        L26:
            throw new RuntimeException(r4);
        L20:
            if (r4.equals("No layout exception. You need to set up the layout file.") == true) goto L26;
            return;
        L23:
            if (r4.equals("Context exception. Activity float need to pass in a activity context.") == true) goto L26;
        }
    }

    public static final class b {
        @JvmStatic
        public final void update() {
            update(null);
        }

        public b() {
        }

        @JvmStatic
        public static Pair a(String r1) {
            Intrinsics.checkNotNullParameter(r1, "tag");
            com.ss.android.lark.floating.widget.appfloat.c r0 = com.ss.android.lark.floating.widget.appfloat.c.a;
            AppFloatManager r2 = com.ss.android.lark.floating.widget.appfloat.c.a(r1);
            if (r2 != null) goto L5;
        L8:
            return null;
        L5:
            if (r2.d == null) goto L8;
            return TuplesKt.to(Integer.valueOf(((WindowManager.LayoutParams) r2.e().a).x), Integer.valueOf(((WindowManager.LayoutParams) r2.e().a).y));
        }

        @JvmStatic
        public final void update(String r2) {
            com.ss.android.lark.floating.widget.appfloat.c.a.update(r2);
        }
    }

    public interface c {
    }

    @JvmStatic
    public static final void update() {
        a.update();
    }

    @JvmStatic
    public static final void update(String r1) {
        a.update(r1);
    }

    static {
        a = new b();
        b = new AtomicBoolean();
    }
}
