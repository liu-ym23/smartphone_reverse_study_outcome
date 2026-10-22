package rha;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.common_ui.widget.ShadowLayout;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.view.ObricIconSwipeUpView;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class n extends PopupWindow {
    public static final /* synthetic */ int q = 0;
    public final View a;
    public final AppCompatImageView b;
    public final z0 c;
    public final String d;
    public final String e;
    public final AtomicBoolean f;
    public rha.a g;
    public final LinearLayout h;
    public final LinearLayout i;
    public final ShadowLayout j;
    public final View k;
    public final ObricIconSwipeUpView l;
    public final Lazy m;
    public long n;
    public Function0<Unit> o;
    public final i p;

    public static final class a {
        public a() {
        }

        public static final long a(String r2) {
            int r0 = n.q;
            return CastLongProtector.parseLong(r2);
        L5:
            return 0;
        }
    }

    static {
        new a();
    }

    @Override // android.widget.PopupWindow
    @Deprecated(message = "use dismissManually() instead")
    public final void dismiss() {
    }

    public final Pair<Integer, Integer> b() {
        int r1 = 0;
        this.h.measure(0, 0);
        int r0 = this.h.getMeasuredHeight();
        int r2 = this.h.getMeasuredWidth();
        this.h.layout(0, 0, r2, r0);
        FLogger r3 = FLogger.a;
        r3.i("SecondaryMenuPopupWindow", "getPopupWindowPosition: popupHeight = " + r0 + ", popupWidth = " + r2);
        int[] r4 = new int[2];
        this.a.getLocationInWindow(r4);
        int r5 = r4[0];
        int r6 = r4[1];
        r3.i("SecondaryMenuPopupWindow", "getPopupWindowPosition: anchorX = " + r5 + ", anchorY = " + r6);
        View r7 = this.i;
    L3:
        if (r7 == null) goto L11;
        if (Intrinsics.areEqual(r7, this.h) == true) goto L11;
        r1 = r1 + r7.getLeft();
        Object r8 = r7.getParent();
        if ((r8 instanceof View) == true) goto L8;
        r7 = null;
        goto L3
    L8:
        r7 = (View) r8;
    L11:
        return new Pair(Integer.valueOf(r5 - r1), Integer.valueOf(r6 - r0));
    }

    public final void a() {
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [rha.i] */
    public n(LinearLayout r3, r r4, ViewGroup r5, View r6) {
        Intrinsics.checkNotNullParameter(r3, "contentView");
        Intrinsics.checkNotNullParameter(r4, "windowConfig");
        super(r3, -2, -2, true);
        this.a = r4.b;
        this.b = r4.c;
        this.c = r4.d;
        this.d = r4.e;
        this.e = r4.f;
        this.f = new AtomicBoolean(true);
        this.h = r3;
        this.i = (LinearLayout) r3.findViewById(2131379904);
        this.j = r3.findViewById(2131379926);
        this.k = r6;
        if (r5 == null) goto L5;
        ObricIconSwipeUpView r7 = (ObricIconSwipeUpView) r5.findViewById(2131381195);
    L6:
        this.l = r7;
        this.m = LazyKt.lazy(new h(this));
        this.p = new i(this);
        return;
    L5:
        r7 = null;
        goto L6
    }
}
