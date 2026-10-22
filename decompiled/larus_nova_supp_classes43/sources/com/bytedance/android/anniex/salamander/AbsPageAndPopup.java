package com.bytedance.android.anniex.salamander;

import android.R;
import android.app.Activity;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.ies.bullet.ui.common.Orientation;
import com.bytedance.salamander.anniex.AnnieXBaseViewModel;
import com.bytedance.salamander.anniex.AnnieXSLEngineType;
import com.bytedance.salamander.anniex.AnnieXWebEngine;
import com.bytedance.salamander.anniex.ScreenOrientation;
import com.bytedance.salamander.anniex.f;
import com.bytedance.salamander.anniex.g3;
import com.bytedance.salamander.anniex.j;
import com.bytedance.salamander.anniex.o;
import com.bytedance.salamander.anniex.r0;
import com.bytedance.salamander.anniex.v4;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import t36.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class AbsPageAndPopup {
    public static final /* synthetic */ int t = 0;
    public final Activity a;
    public final String b;
    public final String c;
    public final String d;
    public int e;
    public ia.c f;
    public f g;
    public j h;
    public AnnieXBaseViewModel i;
    public ViewGroup j;
    public m16.b k;
    public Uri l;
    public final Lazy m;
    public final Lazy n;
    public Function1<? super Boolean, Unit> o;
    public Orientation p;
    public final Function1<Boolean, Unit> q;
    public final Lazy r;
    public final Lazy s;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[AnnieXSLEngineType.values().length];
            r0[AnnieXSLEngineType.lynx.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[AnnieXSLEngineType.web.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L6:
            a = r0;
            int[] r1 = new int[Orientation.values().length];
            r1[Orientation.PORTRAIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r1[Orientation.LANDSCAPE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L9:
            b = r1;
        }
    }

    static {
    }

    public void i() {
    }

    public final ia.c c() {
        ia.c r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("container");
        return null;
    }

    public final v36.a d() {
        return (v36.a) this.n.getValue();
    }

    public final int e() {
        if (((WindowInsetsCompat) this.s.getValue()) == null) goto L10;
        WindowInsetsCompat r0 = (WindowInsetsCompat) this.s.getValue();
        if (r0 == null) goto L10;
        if (r0.isVisible(WindowInsetsCompat.Type.navigationBars()) != true) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        return 0;
    L13:
        WindowInsetsCompat r10 = (WindowInsetsCompat) this.s.getValue();
        if (r10 == null) goto L19;
        Insets r11 = r10.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r11 != null) goto L18;
        return 0;
    L18:
        return r11.bottom;
    L19:
        return 0;
    L10:
        r1 = false;
        goto L11
    }

    public final f f() {
        f r0 = this.g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("props");
        return null;
    }

    public final d g() {
        return (d) this.m.getValue();
    }

    public final AnnieXBaseViewModel h() {
        AnnieXBaseViewModel r0 = this.i;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void l() {
        AnnieXWebEngine r10 = null;
        AnnieXContainerManager.removeContainerById$default(AnnieXContainerManager.INSTANCE, this.c, false, 2, null);
        AnnieXSLEngineType r0 = f().b;
        int r1 = b.a[r0.ordinal()];
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L23;
        AnnieXWebEngine r11 = h().a().a();
        if ((r11 instanceof AnnieXWebEngine) == false) goto L9;
        r10 = r11;
    L9:
        if (r10 == null) goto L19;
        AnnieXWebKit r12 = r10.c;
        if (r12 == null) goto L20;
        r12.o(this.a);
        return;
    L20:
        return;
    L19:
        return;
    L23:
        return;
    L13:
        AnnieXWebEngine r13 = h().a().b();
        if ((r13 instanceof AnnieXLynxView) == false) goto L16;
        r10 = (AnnieXLynxView) r13;
    L16:
        if (r10 == null) goto L22;
        r10.K(this.a);
        return;
    }

    public final Activity getActivity() {
        return this.a;
    }

    public final void j(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        Enum[] r0 = Orientation.values();
        int r1 = r0.length;
        int r11 = 0;
    L4:
        if (r11 >= r1) goto L12;
        Enum r12 = r0[r11];
        if (r12.ordinal() != r10.orientation) goto L8;
        boolean r13 = true;
    L9:
        if (r13 == true) goto L13;
        r11 = r11 + 1;
    L13:
        if (r12 != null) goto L16;
        r12 = Orientation.UNKNOWN;
    L16:
        if (r12 == this.p) goto L34;
        r0 r14 = h();
        if ((r14 instanceof r0) == false) goto L20;
        r0 r15 = r14;
    L21:
        if (r15 == null) goto L31;
        int r16 = b.b[r12.ordinal()];
        if (r16 != 1) goto L25;
        int r17 = v4.a;
        Intrinsics.checkNotNullParameter(ScreenOrientation.PORTRAIT, "newState");
        v4.a.a();
        throw null;
    L25:
        if (r16 == 2) goto L27;
        this.p = r12;
        goto L31
    L27:
        int r18 = v4.a;
        Intrinsics.checkNotNullParameter(ScreenOrientation.LANDSCAPE, "newState");
        v4.a.a();
        throw null;
    L31:
        ConcurrentHashMap<String, Object> r19 = com.bytedance.android.anniex.ability.f.a;
        Activity r110 = this.a;
        if (r110 == null) goto L34;
        com.bytedance.android.anniex.ability.f.c.remove(Integer.valueOf(r110.hashCode()));
        goto L34
    L20:
        r15 = null;
    L34:
        AnnieXRuntime.b().getClass();
        return;
    L8:
        r13 = false;
        goto L9
    L12:
        r12 = null;
        goto L13
    }

    public void k(Bundle r10) {
        com.bytedance.android.anniex.assemble.a r11 = com.bytedance.android.anniex.assemble.a.a;
        com.bytedance.android.anniex.assemble.a.d(this.a.getApplication());
        int r12 = b.a[f().b.ordinal()];
        m16.b r1 = null;
        if (r12 != 1) goto L5;
        Object r13 = h().a().b();
        if ((r13 instanceof AnnieXLynxView) == false) goto L19;
        AnnieXLynxView r14 = (AnnieXLynxView) r13;
    L20:
        if (r14 == null) goto L22;
        r1 = r14.getBridgeContextProviderFactory$anniex_release();
    L22:
        this.k = r1;
        return;
    L19:
        r14 = null;
        goto L20
    L5:
        if (r12 != 2) goto L25;
        AnnieXWebEngine r15 = h().a().a();
        if ((r15 instanceof AnnieXWebEngine) == false) goto L10;
        AnnieXWebEngine r16 = r15;
    L11:
        if (r16 == null) goto L15;
        AnnieXWebKit r17 = r16.c;
        if (r17 == null) goto L15;
        r1 = r17.D;
    L15:
        this.k = r1;
        return;
    L10:
        r16 = null;
        goto L11
    }

    public static final void a(AbsPageAndPopup r10, int r11) {
        ViewGroup.LayoutParams r12 = null;
        if (r10.f().b == AnnieXSLEngineType.lynx) goto L33;
        j r0 = r10.h;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("commonUISchema");
        r0 = null;
    L9:
        int r1 = r0.j;
        if (r1 > (-1)) goto L33;
        boolean r13 = true;
        if ((r10.c() instanceof ua.c) == false) goto L30;
        j r14 = r10.h;
        if (r14 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("commonUISchema");
        r14 = null;
    L19:
        if (r14.k == true) goto L27;
        j r15 = r10.h;
        if (r15 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("commonUISchema");
        r15 = null;
    L25:
        if (r15.b() != true) goto L33;
    L27:
        if (r1 != (-2)) goto L33;
    L34:
        if (r13 == false) goto L75;
        j r16 = r10.h;
        if (r16 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("commonUISchema");
        r16 = null;
    L41:
        if (r16.h == true) goto L76;
        ViewGroup r17 = r10.j;
        if (r17 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("parentViewGroup");
        r17 = null;
    L47:
        View r18 = r17.getRootView();
        int r19 = r18.getHeight();
        int r20 = r19 - r11;
        if (r20 == r10.e) goto L72;
        View r21 = r18.findViewById(R.id.content);
        if ((r21 instanceof ViewGroup) == false) goto L52;
        ViewGroup r22 = (ViewGroup) r21;
    L54:
        if ((r10.c() instanceof ua.d) == true) goto L56;
    L63:
        if (r22 == null) goto L65;
        r12 = r22.getLayoutParams();
    L65:
        if (r12 != null) goto L67;
        return;
    L67:
        if (r11 <= (r19 / 4)) goto L69;
        r12.height = r20;
    L70:
        r22.requestLayout();
        r10.e = r20;
        return;
    L69:
        r12.height = r19;
        goto L70
    L56:
        if (AnnieXContainerManager.isTopContainer(r10.c()) == false) goto L63;
        if (r11 != 0) goto L60;
        if (r22 == null) goto L62;
        r22.scrollTo(0, 0);
    L62:
        r10.e = r20;
        return;
    L60:
        if (r22 == null) goto L62;
        r22.scrollBy(0, r11 - r10.e());
        goto L62
    L52:
        r22 = null;
        goto L54
    L72:
        return;
    L76:
        return;
    L75:
        return;
    L30:
        if ((r10.c() instanceof ua.d) == false) goto L33;
        if (r1 == (-1)) goto L34;
    L33:
        r13 = false;
        goto L34
    }

    public void m(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        AnnieXSLEngineType r12 = f().b;
        int r13 = b.a[r12.ordinal()];
        AnnieXWebEngine r0 = null;
        if (r13 != 1) goto L5;
        AnnieXWebEngine r14 = h().a().b();
        if ((r14 instanceof AnnieXLynxView) == false) goto L17;
        r0 = (AnnieXLynxView) r14;
    L17:
        if (r0 == null) goto L19;
        r0.o(this.a);
    L19:
        i();
        return;
    L5:
        if (r13 != 2) goto L19;
        AnnieXWebEngine r15 = h().a().a();
        if ((r15 instanceof AnnieXWebEngine) == false) goto L10;
        r0 = r15;
    L10:
        if (r0 == null) goto L19;
        AnnieXWebKit r16 = r0.c;
        if (r16 == null) goto L19;
        r16.c(this.a);
        goto L19
    }

    public static final void b(AbsPageAndPopup r10, boolean r11, int r12) {
        r10.getClass();
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("visible", Boolean.valueOf(r11));
        r0.put("height", Integer.valueOf(r12));
        AnnieXBaseViewModel r13 = r10.h();
        r13.getClass();
        Intrinsics.checkNotNullParameter("H5_keyboardStatusChange", "eventName");
        Intrinsics.checkNotNullParameter(r0, "params");
        o r14 = r13.a();
        r14.getClass();
        Intrinsics.checkNotNullParameter("H5_keyboardStatusChange", "eventName");
        Intrinsics.checkNotNullParameter(r0, "params");
        g3 r15 = r14.a;
        g3 r16 = null;
        if (r15 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_engine");
        r15 = null;
    L5:
        r15.sendEvent("H5_keyboardStatusChange", r0);
        AnnieXBaseViewModel r17 = r10.h();
        r17.getClass();
        Intrinsics.checkNotNullParameter("keyboardStatusChange", "eventName");
        Intrinsics.checkNotNullParameter(r0, "params");
        o r18 = r17.a();
        r18.getClass();
        Intrinsics.checkNotNullParameter("keyboardStatusChange", "eventName");
        Intrinsics.checkNotNullParameter(r0, "params");
        g3 r19 = r18.a;
        if (r19 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("_engine");
    L9:
        r16.sendEvent("keyboardStatusChange", r0);
        return;
    L8:
        r16 = r19;
        goto L9
    }

    public AbsPageAndPopup(Activity r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "currentBid");
        Intrinsics.checkNotNullParameter(r12, "containerId");
        Intrinsics.checkNotNullParameter(r13, "currentSchema");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.m = LazyKt.lazy(new AbsPageAndPopup$schemaData$2(this));
        this.n = LazyKt.lazy(new AbsPageAndPopup$containerModel$2(this));
        this.p = Orientation.UNKNOWN;
        this.q = new AbsPageAndPopup$onSoftInputChangeListener$1(this);
        this.r = LazyKt.lazy(new AbsPageAndPopup$decorView$2(this));
        this.s = LazyKt.lazy(new AbsPageAndPopup$windowInsetsCompat$2(this));
    }
}
