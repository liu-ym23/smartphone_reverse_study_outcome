package e0;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f8553a;

    static class a implements b {
        a() {
        }

        @Override // e0.f.b
        public void a(String r10, String r11, Object... r12) {
            if (r12 != null) goto L4;
        L7:
            Log.w(r10, r11);
            return;
        L4:
            if (r12.length == 0) goto L7;
            r11 = String.format(r11, r12);
            goto L7
        }

        @Override // e0.f.b
        public void b(String r10, String r11, Object... r12) {
            if (r12 != null) goto L4;
        L7:
            Log.i(r10, r11);
            return;
        L4:
            if (r12.length == 0) goto L7;
            r11 = String.format(r11, r12);
            goto L7
        }

        @Override // e0.f.b
        public void c(String r10, String r11, Object... r12) {
            if (r12 != null) goto L4;
        L7:
            Log.e(r10, r11);
            return;
        L4:
            if (r12.length == 0) goto L7;
            r11 = String.format(r11, r12);
            goto L7
        }
    }

    public interface b {
        void a(String r10, String r11, Object... r12);

        void b(String r10, String r11, Object... r12);

        void c(String r10, String r11, Object... r12);
    }

    static {
        f8553a = new a();
    }
}
