package dv1;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import f06.d;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final String[] g = null;
    public b a;
    public PthreadHandlerThreadV2 b;
    public Handler c;
    public final Set<String> d;
    public final Set<String> e;
    public final WeakReference<Context> f;

    /* JADX INFO: renamed from: dv1.a$a, reason: collision with other inner class name */
    public static final class C0380a {
    }

    static {
        g = new String[]{"screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap", "screenrecord", "screen_record", "screen-record", "screen record"};
    }

    public final boolean b() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 33) goto L11;
        Context r1 = this.f.get();
        if (r1 != null) goto L7;
    L9:
        return false;
    L7:
        if (ContextCompat.checkSelfPermission(r1, "android.permission.READ_MEDIA_VIDEO") != 0) goto L9;
        return true;
    L11:
        if (r0 < 30) goto L17;
        Context r2 = this.f.get();
        if (r2 == null) goto L9;
        if (ContextCompat.checkSelfPermission(r2, "android.permission.READ_EXTERNAL_STORAGE") != 0) goto L9;
        return true;
    L17:
        Context r3 = this.f.get();
        if (r3 == null) goto L9;
        if (ContextCompat.checkSelfPermission(r3, "android.permission.READ_EXTERNAL_STORAGE") != 0) goto L9;
        return true;
    }

    public a(WeakReference<Context> r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.f = r2;
        this.d = new HashSet();
        this.e = new HashSet();
    }

    public static Cursor a(ContentResolver r17, Uri r18, String[] r19) {
        f06.c r14 = new f06.c();
        Object[] r15 = {r18, r19, null, null, "date_added DESC"};
        f06.b r16 = new f06.b();
        d r0 = r14.b(240004, "android/content/ContentResolver", "query", r17, r15, "android.database.Cursor", r16);
        if (r0.a == false) goto L6;
        r14.a(240004, "android/content/ContentResolver", "query", r17, r15, null, r16, false);
        return (Cursor) r0.b;
    L6:
        Cursor r1 = r17.query(r18, r19, null, null, "date_added DESC");
        r14.a(240004, "android/content/ContentResolver", "query", r17, r15, r1, r16, true);
        return r1;
    }
}
