package cm8;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.platform.IFlowSdkDepend;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import va8.p;
import va8.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e implements cm8.a {
    public final fh8.f a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;

    public static final class a implements Function0<p> {
        public final /* synthetic */ AttachReceiver a;

        public a(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(p.class));
        }
    }

    public static final class b implements Function0<x> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(x.class));
        }
    }

    @Override // cm8.a
    public final Long O() {
        x r0 = (x) this.d.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r0.O());
    }

    @Override // cm8.a
    public final Boolean W() {
        x r0 = (x) this.d.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r0.W());
    }

    @Override // cm8.a
    public final String Z0() {
        fh8.f r0 = this.a;
        if (r0 == null) goto L7;
        Function0 r1 = r0.C;
        if (r1 == null) goto L7;
        return (String) r1.invoke();
    L7:
        return null;
    }

    @Override // cm8.a
    public final boolean a1() {
        fh8.f r0 = this.a;
        if (r0 == null) goto L7;
        Function0 r1 = r0.m;
        if (r1 == null) goto L7;
        Fragment r2 = (Fragment) r1.invoke();
    L8:
        if (r2 == null) goto L10;
        return true;
    L10:
        return false;
    L7:
        r2 = null;
        goto L8
    }

    @Override // cm8.a
    public final com.larus.bmhome.chat.exposure.a b1() {
        p r0 = (p) this.c.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.vQ();
    }

    @Override // cm8.a
    public final int c1() {
        fh8.f r0 = this.a;
        if (r0 == null) goto L7;
        Integer r1 = r0.l;
        if (r1 == null) goto L7;
        return r1.intValue();
    L7:
        return -1;
    }

    @Override // cm8.a
    public final Boolean d1() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L5;
        r0.r();
        return Boolean.valueOf(mc9.a.a.h());
    L5:
        return null;
    }

    @Override // cm8.a
    public final Long e1() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L5;
        r0.r();
        return Long.valueOf(mc9.a.a.g());
    L5:
        return null;
    }

    @Override // cm8.a
    public final Fragment getFragment() {
        fh8.f r0 = this.a;
        if (r0 == null) goto L8;
        Function0 r1 = r0.m;
        if (r1 == null) goto L8;
        Fragment r2 = (Fragment) r1.invoke();
        if (r2 == null) goto L8;
        return r2;
    L8:
        fh8.f r3 = this.a;
        if (r3 == null) goto L11;
        RecyclerView.Adapter r4 = r3.p;
    L13:
        if ((r4 instanceof ry8.d) == false) goto L15;
        ry8.d r5 = (ry8.d) r4;
    L16:
        if (r5 == null) goto L19;
        return r5.f();
    L19:
        return null;
    L15:
        r5 = null;
        goto L16
    L11:
        r4 = null;
        goto L13
    }

    @Override // cm8.a
    public final String m() {
        fh8.f r0 = this.a;
        if (r0 == null) goto L7;
        Function0 r1 = r0.B;
        if (r1 == null) goto L7;
        return (String) r1.invoke();
    L7:
        return null;
    }

    public e(fh8.f r1) {
        this.a = r1;
        this.b = LazyKt.lazy(new cm8.b(this));
        this.c = LazyKt.lazy(new c(this));
        this.d = LazyKt.lazy(new d(this));
    }
}
