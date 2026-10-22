package j9;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r11, View r12, String r13, String r14, JSONObject r15, JSONObject r16, JSONObject r17, JSONObject r18, int r19, int r20) {
            if ((r20 & 64) == 0) goto L5;
            JSONObject r10 = null;
        L6:
            r11.b(r12, r13, r14, r15, r16, r17, r10, r19, null);
            return;
        L5:
            r10 = r18;
            goto L6
        }
    }

    /* JADX INFO: renamed from: j9.b$b, reason: collision with other inner class name */
    public static final class C0169b implements b {
        public static final C0169b a = null;

        static {
            a = new C0169b();
        }

        public C0169b() {
        }

        @Override // j9.b
        public final void a(View r1, String r10, String r11, JSONObject r12, JSONObject r13, JSONObject r14, int r15) {
            Intrinsics.checkNotNullParameter(r1, "view");
        }

        @Override // j9.b
        public final void b(View r1, String r10, String r11, JSONObject r12, JSONObject r13, JSONObject r14, JSONObject r15, int r16, String r17) {
        }
    }

    void a(View r1, String r10, String r11, JSONObject r12, JSONObject r13, JSONObject r14, int r15);

    void b(View r1, String r10, String r11, JSONObject r12, JSONObject r13, JSONObject r14, JSONObject r15, int r16, String r17);
}
