package com.bytedance.android.live.liveinteract.plantform.camera;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface b {
    public static final a o0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static b a() {
            DataContext r0 = d.d("ISwitchCameraManager");
            if ((r0 instanceof SwitchCameraContext) == true) goto L5;
            r0 = null;
        L5:
            SwitchCameraContext r1 = (SwitchCameraContext) r0;
            if (r1 == null) goto L11;
            j<b> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (b) r2.getValue();
        L11:
            return null;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.camera.b$b, reason: collision with other inner class name */
    public static final class C0048b {
        public static /* synthetic */ void a(b r9, boolean r10, boolean r11, boolean r12, boolean r13, String r14, int r15) {
            if ((r15 & 4) == 0) goto L5;
            boolean r5 = false;
        L7:
            if ((r15 & 8) == 0) goto L9;
            boolean r6 = false;
        L10:
            r9.f(r10, r11, r5, r6, null, r14);
            return;
        L9:
            r6 = r13;
            goto L10
        L5:
            r5 = r12;
            goto L7
        }
    }

    static {
        o0 = a.a;
    }

    boolean a();

    void b(String r1, boolean r2);

    int c(String r1);

    boolean d(String r1);

    boolean e();

    void f(boolean r1, boolean r2, boolean r3, boolean r4, com.bytedance.android.live.liveinteract.plantform.camera.a r5, String r6);

    void g();
}
