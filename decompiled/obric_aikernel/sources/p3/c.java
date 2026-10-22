package p3;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f12319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f12320b;

    private static class a implements b {
        a() {
        }

        @Override // p3.c.b
        public void a(@Nullable Throwable r10, @NonNull String r11, @NonNull Object... r12) {
            b(String.format(r11, r12) + '\n' + Log.getStackTraceString(r10), new Object[0]);
        }

        @Override // p3.c.b
        public void b(@NonNull String r10, @NonNull Object... r11) {
            if (e.f12324a == false) goto L5;
        L7:
            String r12 = String.format(r10, r11);
            if (r12.length() >= 4000) goto L10;
            Log.d(SlardarSettingsConstants.PERF_KEY_MEMORY, r12);
            return;
        L10:
            String[] r13 = r12.split("\n", -1);
            int r14 = r13.length;
            int r15 = 0;
        L11:
            if (r15 >= r14) goto L15;
            Log.d(SlardarSettingsConstants.PERF_KEY_MEMORY, r13[r15]);
            r15 = r15 + 1;
            goto L11
        L15:
            return;
        L5:
            if (c.a() == true) goto L7;
        }
    }

    public interface b {
        void a(@Nullable Throwable r10, @NonNull String r11, @NonNull Object... r12);

        void b(@NonNull String r10, @NonNull Object... r11);
    }

    static {
        f12319a = new a();
    }

    static /* synthetic */ boolean a() {
        return f12320b;
    }

    public static void b(@Nullable Throwable r10, @NonNull String r11, @NonNull Object... r12) {
        b r13 = f12319a;
        if (r13 == null) goto L9;
        r13.a(r10, r11, r12);
        return;
    L9:
        Log.d("guozhimemory", String.format(r11, r12));     // Catch: Exception -> L8
        return;
    }

    public static void c(@NonNull String r10, @NonNull Object... r11) {
        b r12 = f12319a;
        if (r12 == null) goto L9;
        r12.b(r10, r11);
        return;
    L9:
        Log.i("guozhimemory", String.format(r10, r11));     // Catch: Exception -> L8
        return;
    }
}
