package sc;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import ge.l;
import he.i;
import he.j;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ sc.a f12084a;

    public static final class a extends j implements l<ub.b<View>, xd.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12085a = null;

        static {
            f12085a = new a();
        }

        public a() {
            super(1);
        }

        @Override // ge.l
        public final xd.j invoke(ub.b<View> r8) {
            i.f(r8, "it");
            return xd.j.f13877a;
        }
    }

    public b(sc.a r8) {
        this.f12084a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        sc.a r8 = this.f12084a;
        RadiusLayout r10 = r8.a();
        Window r11 = r8.getWindow();
        Context r12 = r8.getContext();
        i.e(r12, "context");
        Resources r13 = r12.getResources();
        i.e(r13, "context.resources");
        if ((r13.getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L8;
        float r15 = 0.5f;
    L9:
        ub.b r16 = ec.a.f(r10, r11, true, r15);
        ub.b.a(r16, null, null, a.f12085a, 3);
        r16.b();
        return;
    L8:
        r15 = 0.16f;
        goto L9
    L5:
        r14 = false;
        goto L6
    }
}
