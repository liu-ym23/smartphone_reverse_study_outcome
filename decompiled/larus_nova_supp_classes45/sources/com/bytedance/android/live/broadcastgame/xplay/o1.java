package com.bytedance.android.live.broadcastgame.xplay;

import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.openplatform.behavior.ToolbarInteractPlayControlBehavior;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.miniplay.SupportLiveScene;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o1 implements g, com.bytedance.android.scope.o {
    public final a a;
    public List<b> b;
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 c;
    public final ToolbarInteractPlayControlBehavior d;
    public final CompositeDisposable e;
    public final SparseArray<String> f;
    public final com.bytedance.android.live.broadcastgame.api.xplay.p g;
    public final XplayInternalContext h;

    public static final class a {
        public boolean a;
        public boolean b;

        public a() {
            this.a = false;
            this.b = false;
        }
    }

    public static final class b {
        public final ToolbarButton a;
        public final boolean b;
        public final boolean c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L12;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public final int hashCode() {
            ToolbarButton r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            int r2 = r1 * 31;
            boolean r3 = this.b;
            ?? r4 = 1;
            ?? r5 = r3;
            if (r3 == false) goto L9;
            r5 = 1;
        L9:
            int r6 = (r2 + r5) * 31;
            boolean r7 = this.c;
            if (r7 == true) goto L14;
            r4 = r7;
        L14:
            return r6 + r4;
        L5:
            r1 = 0;
            goto L6
        }

        public final String toString() {
            return "ToolbarButtonConfig(button=" + this.a + ", disableInGame=" + this.b + ", disableInCleanMode=" + this.c + ")";
        }

        public b(ToolbarButton r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "button");
            this.a = r2;
            this.b = r3;
            this.c = true;
        }
    }

    public final void onStart() {
        boolean r1 = false;
        if (this.g.h.m.contains(Integer.valueOf(SupportLiveScene.VIDEO_CHAT_ROOM.getValue())) == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        int r3 = p1.a[this.g.f.ordinal()];
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        List<b> r2 = CollectionsKt.emptyList();
    L18:
        this.b = r2;
        ToolbarInteractPlayControlBehavior r4 = this.d;
        if (((XplayScene) this.h.getCurrentScene().getValue()) != XplayScene.RevenueLink) goto L21;
        r1 = true;
    L21:
        r4.e = r1;
        ToolbarInteractPlayControlBehavior r5 = this.d;
        com.bytedance.android.live.broadcastgame.api.xplay.s r6 = this.g.j;
        if (r6 == null) goto L24;
        String r7 = r6.a;
    L25:
        r5.f = r7;
        this.c.k(ToolbarButton.INTERACT_PLAY, r5);
        a r8 = this.a;
        r8.a = true;
        d(this, r8);
        c(this, this.a);
        return;
    L24:
        r7 = null;
        goto L25
    L15:
        throw new NoWhenBranchMatchedException();
    L16:
        r2 = CollectionsKt.listOf(new b(ToolbarButton.BROADCAST_EFFECT, false));
        goto L18
    L17:
        boolean r9 = !r0;
        r2 = CollectionsKt.listOf(new b[]{new b(ToolbarButton.PK, true), new b(ToolbarButton.INTERACTION, r9), new b(ToolbarButton.INTERACTION_ROOM, r9), new b(ToolbarButton.BROADCAST_EFFECT, false)});
        goto L18
    L5:
        if (this.g.h.m.contains(Integer.valueOf(SupportLiveScene.VIDEO_EQUAL_CHAT_ROOM.getValue())) == true) goto L8;
        r0 = false;
        goto L9
    }

    public final void onStop() {
        this.c.d(ToolbarButton.INTERACT_PLAY, this.d);
        a r0 = this.a;
        r0.a = false;
        r0.b = false;
        d(this, r0);
        c(this, this.a);
        this.e.clear();
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.g
    public final void a(boolean r2) {
        a r0 = this.a;
        r0.b = r2;
        d(this, r0);
        c(this, this.a);
    }

    public final String f(int r3) {
        String r0 = this.f.get(r3);
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r1 = com.bytedance.android.live.core.utils.s1.B(r3);
        this.f.put(r3, r1);
        return r1;
    }

    public o1(com.bytedance.android.live.broadcastgame.api.xplay.p r2, XplayInternalContext r3) {
        Intrinsics.checkNotNullParameter(r2, "newEnv");
        Intrinsics.checkNotNullParameter(r3, "xplayInternalContext");
        this.g = r2;
        this.h = r3;
        this.a = new a();
        this.b = CollectionsKt.emptyList();
        this.c = y3.m(r2.i);
        this.d = new ToolbarInteractPlayControlBehavior();
        this.e = new CompositeDisposable();
        this.f = new SparseArray();
    }

    public static final void c(o1 r4, a r5) {
        r4.getClass();
        if (r5.b == false) goto L13;
        ToolbarInteractPlayControlBehavior r6 = r4.d;
        View r7 = r6.a;
        if (r7 == null) goto L18;
        View r8 = r7.findViewById(2131382384);
        if (r8 == null) goto L20;
        ObjectAnimator r9 = ObjectAnimator.ofFloat(r8, View.SCALE_X, new float[]{1.0f, 0.85f});
        r6.c = r9;
        if (r9 == null) goto L12;
        r9.setDuration(200);
    L12:
        RxUtilKt.c(RxUtilKt.h(Observable.interval(0, 3, TimeUnit.SECONDS)).subscribe(new com.bytedance.android.live.broadcastgame.openplatform.behavior.d(r6)), r6.d);
        return;
    L20:
        return;
    L18:
        return;
    L13:
        ToolbarInteractPlayControlBehavior r11 = r4.d;
        ObjectAnimator r12 = r11.c;
        if (r12 == null) goto L16;
        r12.cancel();
    L16:
        r11.c = null;
        r11.d.clear();
    }

    public static final void d(o1 r8, a r9) {
        Iterator<T> r0 = r8.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L35;
        b r1 = (b) r0.next();
        if (r9.b == true) goto L8;
    L10:
        String r2 = "";
        boolean r5 = true;
    L11:
        if (r5 == false) goto L18;
        if (r9.a == false) goto L18;
        if (r1.b == false) goto L18;
        r2 = r8.f(2131923512);
        r5 = false;
    L18:
        if (r1.c == true) goto L20;
    L32:
        if (r5 == true) goto L33;
        r8.c.l(r1.a.extended(), r2);
        goto L4
    L33:
        r8.c.h(r1.a.extended());
        goto L4
    L20:
        if (r1.b == false) goto L32;
        if (TextUtils.isEmpty(r1.a.getTitleStr()) == false) goto L30;
        int r3 = p1.b[r1.a.ordinal()];
        if (r3 != 1) goto L26;
        String r4 = r8.f(2131919626);
    L31:
        StringCompanionObject r6 = StringCompanionObject.INSTANCE;
        r2 = String.format(r8.f(2131923511), Arrays.copyOf(new Object[]{r4}, 1));
        goto L32
    L26:
        if (r3 == 2) goto L28;
        r4 = "此功能";
        goto L31
    L28:
        r4 = r8.f(2131919433);
        goto L31
    L30:
        r4 = r1.a.getTitleStr();
        goto L31
    L8:
        if (r1.c == false) goto L10;
        r2 = r8.f(2131923510);
        r5 = false;
        goto L11
    }
}
