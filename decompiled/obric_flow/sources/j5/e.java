package j5;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import x4.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f18241a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap f18242b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f18243c = null;

    static {
        f18241a = b.f18235a;
        f18242b = new LinkedHashMap();
        f18243c = new Handler(Looper.getMainLooper());
    }

    public static x4.d a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        f18241a.getClass();
        f r10 = b.i(r5);
        if (r10 == null) goto L16;
        String r11 = r10.f18244a;
        if (Intrinsics.areEqual(r11, "lynx") == false) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L15;
        d r13 = (d) f18242b.get(r11);
        if (r13 == null) goto L14;
        return r13.a((View) r10.f18245b.get());
    L14:
        return new x4.d(new h());
    L15:
        d5.b.e("ContainerStandardApi", "getUnifyInfo, type not register");
        Unit r14 = Unit.INSTANCE;
    L17:
        if (r14 != null) goto L20;
        d5.b.e("ContainerStandardApi", "getUnifyInfo, attachedView is null");
    L20:
        return new x4.d(new h());
    L7:
        r12 = Intrinsics.areEqual(r11, "web");
        goto L8
    L16:
        r14 = null;
        goto L17
    }

    public static void b(String r5, f r10) {
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        Intrinsics.checkNotNullParameter(r10, "ct");
        StringBuilder r11 = new StringBuilder("attach [");
        r11.append(r5);
        r11.append("] containerType:");
        String r12 = r10.f18244a;
        r11.append(r12);
        d5.b.f("ContainerStandardApi", r11.toString());
        f18241a.getClass();
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        Intrinsics.checkNotNullParameter(r10, "ct");
        b.e.put(r5, r10);
        WeakHashMap r13 = b.f;     // Catch: Throwable -> L8
        WeakReference r14 = r10.f18245b;
        a r15 = (a) r13.get((View) r14.get());     // Catch: Throwable -> L8
        if (r15 == null) goto L10;
        r15.a(r5);     // Catch: Throwable -> L8
    L10:
        r13.remove((View) r14.get());     // Catch: Throwable -> L8
    L13:
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        Intrinsics.checkNotNullParameter("container_id", "field");
        Intrinsics.checkNotNullParameter(r5, "value");
        b.c(r5).put("container_id", r5);
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        Intrinsics.checkNotNullParameter("container_type", "field");
        Intrinsics.checkNotNullParameter(r12, "value");
        b.c(r5).put("container_type", r12);
        return;
    L8:
        th = move-exception;
        mn.h.g("default_handle", th);
        goto L13
    }

    public static void c(String r5, String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "field");
        int r12 = r10.hashCode();
        b r13 = f18241a;
        switch(r12) {
            case -1573000044: goto L30;
            case -907987551: goto L27;
            case -245775970: goto L24;
            case -77002359: goto L21;
            case 97555: goto L18;
            case 351608024: goto L15;
            case 855478153: goto L12;
            case 946461684: goto L9;
            case 2138439450: goto L6;
            default: goto L31;
        };
    L31:
        r13.getClass();
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        Intrinsics.checkNotNullParameter(r10, "field");
        Intrinsics.checkNotNullParameter(r11, "value");
        b.h(r5).put(r10, r11);
    L33:
        r13.getClass();
        f r14 = b.i(r5);
        if (r14 == null) goto L39;
        d r15 = (d) f18242b.get(r14.f18244a);
        if (r15 == null) goto L40;
        View r16 = (View) r14.f18245b.get();
        r15.a(r10, r11);
        return;
    L40:
        return;
    L39:
        return;
    L6:
        if (r10.equals("container_version") == false) goto L31;
    L32:
        r13.getClass();
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        Intrinsics.checkNotNullParameter(r10, "field");
        Intrinsics.checkNotNullParameter(r11, "value");
        b.c(r5).put(r10, r11);
        goto L33
    L9:
        if (r10.equals("core_view_type") == true) goto L32;
    L12:
        if (r10.equals("container_name") == true) goto L32;
    L15:
        if (r10.equals("version") == true) goto L32;
    L18:
        if (r10.equals("biz") == true) goto L32;
    L21:
        if (r10.equals("client_component") == true) goto L32;
    L24:
        if (r10.equals("template_res_type") == true) goto L32;
    L27:
        if (r10.equals("schema") == true) goto L32;
    L30:
        if (r10.equals("view_type") == true) goto L32;
        goto L31
    }

    public static void d(String r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        StringBuilder r12 = androidx.constraintlayout.motion.widget.a.D(r10, "field", r11, "value", "collectString [monitorId:");
        f8.b.e(r12, r5, "][field:", r10, "][value:");
        r12.append(r11);
        r12.append(']');
        d5.b.f("ContainerStandardApi", r12.toString());
        c(r5, r10, r11);
    }
}
