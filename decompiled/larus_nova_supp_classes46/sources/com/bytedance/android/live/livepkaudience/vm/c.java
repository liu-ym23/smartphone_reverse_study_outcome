package com.bytedance.android.live.livepkaudience.vm;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface c {
    public static final a A0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static c a() {
            DataContext r0 = d.d("ILinkPkSwitchCameraManager");
            if ((r0 instanceof LinkPkSwitchCameraContext) == true) goto L5;
            r0 = null;
        L5:
            LinkPkSwitchCameraContext r1 = (LinkPkSwitchCameraContext) r0;
            if (r1 == null) goto L11;
            j<c> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (c) r2.getValue();
        L11:
            return null;
        }
    }

    public static final class b {
        public static /* synthetic */ void a(c r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15, int r16) {
            if ((r16 & 4) == 0) goto L5;
            boolean r5 = false;
        L7:
            if ((r16 & 8) == 0) goto L9;
            boolean r6 = false;
        L11:
            if ((r16 & 32) == 0) goto L13;
            boolean r8 = false;
        L14:
            r10.f(r11, r12, r5, r6, false, r8, null);
            return;
        L13:
            r8 = r15;
            goto L14
        L9:
            r6 = r14;
            goto L11
        L5:
            r5 = r13;
            goto L7
        }
    }

    static {
        A0 = a.a;
    }

    boolean a();

    void b(String r1, boolean r2);

    int c(String r1);

    boolean d(String r1);

    boolean e();

    void f(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, com.bytedance.android.live.livepkaudience.vm.a r7);
}
