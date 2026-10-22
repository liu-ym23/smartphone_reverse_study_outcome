package bla;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.miniapp.view.MiniAppFragment;
import e3.d;
import hx7.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r4.b;
import r4.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a implements f, j {
    public static final f c = null;
    public static final j d = null;
    public static final List<f> e = null;
    public final boolean a;
    public final WeakReference<MiniAppFragment> b;

    /* JADX INFO: renamed from: bla.a$a, reason: collision with other inner class name */
    public static final class C0003a {
    }

    public final b provideRouteOpenExceptionHandler(d r1) {
        return null;
    }

    static {
        Map r0 = com.ivy.ivykit.api.bridge.b.a;
        c = (f) com.ivy.ivykit.api.bridge.b.a(f.class);
        d = r4.a.j;
        e = new ArrayList();
    }

    public final Boolean a(Context r4) {
        MiniAppFragment r0 = this.b.get();
        if (r0 != null) goto L5;
    L21:
        return null;
    L5:
        if (this.a == false) goto L11;
        if (Intrinsics.areEqual(r0.getActivity(), r4) == false) goto L21;
        r0.close();
        return Boolean.TRUE;
    L11:
        if ((r4 instanceof FragmentActivity) == false) goto L13;
        FragmentActivity r5 = (FragmentActivity) r4;
    L14:
        if (r5 == null) goto L21;
        FragmentManager r6 = r5.getSupportFragmentManager();
        if (r6.getBackStackEntryCount() <= 1) goto L18;
        r6.popBackStackImmediate();
    L20:
        return Boolean.TRUE;
    L18:
        r0.close();
        goto L20
    L13:
        r5 = null;
        goto L14
    }

    public final boolean closeView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Boolean r0 = a(r2);
        if (r0 != null) goto L13;
        f r1 = c;
        if (r1 == null) goto L8;
        Boolean r3 = Boolean.valueOf(r1.closeView(r2));
    L9:
        if (r3 != null) goto L14;
        return false;
    L14:
        return r3.booleanValue();
    L8:
        r3 = null;
        goto L9
    L13:
        return r0.booleanValue();
    }

    public final boolean interceptClose(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return false;
    }

    public final List<b> provideRouteOpenHandlerList(d r1) {
        return CollectionsKt.emptyList();
    }

    public a(MiniAppFragment r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "appletFragment");
        this.a = r3;
        this.b = new WeakReference(r2);
        Map r4 = com.ivy.ivykit.api.bridge.b.a;
        com.ivy.ivykit.api.bridge.b.b(f.class, this);
        IHostContextDepend r5 = r4.a.a;
        Intrinsics.checkNotNullParameter(this, "hostRouterDepend");
        r4.a.j = this;
        ListProtector.add(e, 0, this);
    }

    public final boolean closeView(d r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Activity r0 = r3.getOwnerActivity();
        if (r0 != null) goto L5;
        return false;
    L5:
        Boolean r1 = a(r0);
        if (r1 != null) goto L15;
        j r2 = d;
        if (r2 == null) goto L11;
        Boolean r6 = Boolean.valueOf(r2.closeView(r3, r4, r5));
    L12:
        if (r6 != null) goto L14;
        return false;
    L14:
        return r6.booleanValue();
    L11:
        r6 = null;
        goto L12
    L15:
        return r1.booleanValue();
    }

    public final boolean openSchema(String r2, Map<String, ? extends Object> r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter(r3, "extraInfo");
        f r0 = c;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.openSchema(r2, r3, r4);
    }

    public final boolean openSchema(d r1, String r2, Map<String, ? extends Object> r3, Context r4) {
        return j.a.b(this, r1, r2, r3, r4);
    }
}
