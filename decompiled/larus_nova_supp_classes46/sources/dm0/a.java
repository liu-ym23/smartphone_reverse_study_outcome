package dm0;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.messagewindow.builder.card.CardMountingsBuilder;
import com.bytedance.android.live.room.api.messagewindow.constraint.CardConstraint;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v61.d;
import x61.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends v61.a {
    public final CardMountingsBuilder.ContainerBuilder m;
    public final CardMountingsBuilder.b n;
    public final CardMountingsBuilder.d o;
    public final d p;
    public final MsgWindowPosition q;
    public CardConstraint r;

    /* JADX INFO: renamed from: dm0.a$a, reason: collision with other inner class name */
    public static final class C0199a {
    }

    static {
    }

    public final boolean C() {
        return false;
    }

    public final void I() {
        ALogger.d("MountingsCard", "onCreate");
        Function0 r0 = this.n.a;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke();
    L5:
        ArrayList r2 = (ArrayList) this.o.b;
        if ((!r2.isEmpty()) == true) goto L9;
        r2 = null;
    L9:
        if (r2 == null) goto L14;
        Iterator r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        i((t71.a) r3.next());
    L14:
        this.o.getClass();
    }

    public final void K() {
        ALogger.d("MountingsCard", "onHide");
        Function0 r0 = this.n.c;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke();
        return;
    }

    public final void L() {
        ALogger.d("MountingsCard", "onShow");
        Function0 r0 = this.n.b;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke();
        return;
    }

    public final void M() {
        ALogger.d("MountingsCard", "onStart");
        this.n.getClass();
    }

    public final h<?, ?> content() {
        ALogger.d("MountingsCard", "getContent");
        return (h) this.m.a.invoke();
    }

    public final void J() {
        super.J();
        ALogger.d("MountingsCard", "onDestroy");
        Function0 r0 = this.n.d;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke();
        return;
    }

    public final boolean isShowingWindow() {
        return isShowing();
    }

    public final d B() {
        return this.p;
    }

    public final void dismissWindow() {
        dismiss();
    }

    public final MsgWindowPosition getPosition() {
        return this.q;
    }

    public final void showWindow() {
        show();
    }

    public final CardConstraint y() {
        return this.r;
    }

    public a(com.bytedance.android.live.room.api.messagewindow.builder.card.a r4) {
        Intrinsics.checkNotNullParameter(r4, "mountings");
        DataCenter r0 = r4.a;
        Object r1 = r4.b;
        int r2 = r4.c;
        r4.getContext();
        super(r0, r1, r2);
        CardMountingsBuilder.ContainerBuilder r3 = new CardMountingsBuilder.ContainerBuilder();
        r4.f.invoke(r3);
        this.m = r3;
        Intrinsics.checkNotNullParameter(this, "card");
        CardMountingsBuilder.b r5 = new CardMountingsBuilder.b(this);
        r4.g.invoke(r5);
        this.n = r5;
        CardMountingsBuilder.d r6 = new CardMountingsBuilder.d();
        r4.h.invoke(r6);
        this.o = r6;
        CardMountingsBuilder.a r7 = new CardMountingsBuilder.a();
        r4.i.invoke(r7);
        this.p = new d(0);
        this.q = r4.e;
        this.r = r3.b;
    }

    public final void N(View r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r2, "container");
        ALogger.d("MountingsCard", "onViewCreated");
        this.m.getClass();
    }

    public final void O(CardConstraint r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.r = r2;
    }
}
