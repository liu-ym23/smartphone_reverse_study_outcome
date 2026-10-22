package g4;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final Map<String, InterfaceC0159b> a = null;

    public static class a implements InterfaceC0159b {
        public a() {
        }
    }

    /* JADX INFO: renamed from: g4.b$b, reason: collision with other inner class name */
    public interface InterfaceC0159b {
        Intent b(Context r1);
    }

    public static final class c extends a {
        public c() {
        }

        @Override // g4.b.InterfaceC0159b
        public final Intent b(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            ComponentName r0 = new ComponentName("com.android.settings", "com.android.settings.applications.InstalledAppDetails");
            Intent r1 = new Intent();
            r1.setComponent(r0);
            r1.setData(Uri.fromParts("package", r10.getPackageName(), null));
            r1.setFlags(268435456);
            return r1;
        }
    }

    static {
        a = MapsKt.mapOf(TuplesKt.to("meizu", new c()));
    }
}
