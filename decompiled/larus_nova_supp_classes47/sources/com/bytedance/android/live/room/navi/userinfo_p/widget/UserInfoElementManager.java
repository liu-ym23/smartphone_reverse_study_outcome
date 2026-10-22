package com.bytedance.android.live.room.navi.userinfo_p.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.navi.userinfo_p.element.UserInfoAnimElement;
import com.bytedance.android.live.room.navi.userinfo_p.element.UserInfoAvatarElement;
import com.bytedance.android.live.room.navi.userinfo_p.element.UserInfoBasicElement;
import com.bytedance.android.live.room.navi.userinfo_p.element.UserInfoEntranceElement;
import com.bytedance.android.live.room.navi.userinfo_p.element.UserInfoFlipTabElement;
import com.bytedance.android.live.room.navi.userinfo_p.element.UserInfoMiddleElement;
import com.bytedance.android.live.room.navi.userinfo_p.element.UserInfoPopupElement;
import com.bytedance.android.live.room.navi.userinfo_p.element.UserinfoWidthServiceElement;
import com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement;
import com.bytedance.android.live.room.navi.userinfo_p.mvi.UserInfoDataSource;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.UserInfoVM;
import com.bytedance.android.live.room.y;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import m91.d;
import n91.c;
import z91.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class UserInfoElementManager {
    public final List<BaseElement> a;
    public d b;
    public UserInfoDataSource c;
    public Disposable d;
    public aa1.a e;
    public final b f;
    public final MiddlewareRoomRecyclableWidget g;

    public static final class a {
    }

    public static final class b implements c {
        public final /* synthetic */ UserInfoElementManager a;

        @Override // n91.c
        public final View getContentView() {
            return ((Widget) this.a.g).contentView;
        }

        public b(UserInfoElementManager r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void a() {
        ALogger.d("UserInfoElementManager", "clearElements");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((BaseElement) r0.next()).f();
        goto L4
    L6:
        ((ArrayList) this.a).clear();
    }

    public final synchronized aa1.a d() {
        monitor-enter(this);
        aa1.a r1 = this.e;     // Catch: Throwable -> L16
        if (r1 != null) goto L14;
        Pair r2 = com.bytedance.live.datacontext.d.a(UserInfoElementManager$getUserInfoViewModel$1.INSTANCE);     // Catch: Throwable -> L16
        aa1.a r3 = (aa1.a) r2.getFirst();     // Catch: Throwable -> L16
        this.e = r3;     // Catch: Throwable -> L16
        if (r3 == null) goto L9;
        UserInfoVM.Companion.getClass();     // Catch: Throwable -> L16
        UserInfoVM.b.a(r3);     // Catch: Throwable -> L16
    L9:
        this.d = (Disposable) r2.getSecond();     // Catch: Throwable -> L16
        ALogger.d("UserInfoElementManager", "[" + this + "] create new userInfoViewMode:[" + this.e + ']');     // Catch: Throwable -> L16
        Object r0 = r2.getFirst();     // Catch: Throwable -> L16
        if (r0 == null) goto L13;
        r1 = (aa1.a) r0;     // Catch: Throwable -> L16
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.room.navi.userinfo_p.viewmodel.base.IUserInfoVM");     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return r1;
    L16:
        th = move-exception;
        throw th;
    }

    public final void e() {
        d r0 = this.b;
        if (r0 == null) goto L12;
        r0.e.getElementInteractVm().registerService(c.class, this.f);
        Iterator r1 = ((ArrayList) this.a).iterator();
    L6:
        if (r1.hasNext() == false) goto L20;
        m91.c r2 = (BaseElement) r1.next();
        if ((r2 instanceof n91.b) == false) goto L6;
        Pair<Class<? extends n91.a>, n91.a> r3 = ((n91.b) r2).a();
        if (r3 == null) goto L6;
        r0.e.getElementInteractVm().registerService((Class) r3.getFirst(), (n91.a) r3.getSecond());
        goto L6
    L20:
        return;
    }

    public final void f() {
        ALogger.d("UserInfoElementManager", "onWidgetInit");
        MiddlewareRoomRecyclableWidget r3 = this.g;
        Fragment r4 = ((Widget) r3).widgetCallback.getWidgetManager().parentFragment;
        MiddlewareRoomRecyclableWidget r1 = this.g;
        d r0 = new d(r3, r4, ((Widget) r1).dataCenter, r1.getRoomContext(), d(), ((Widget) this.g).isViewValid);
        List<BaseElement> r2 = this.a;
        ArrayList r5 = (ArrayList) r2;
        r5.addAll(b(r0));
        Unit r6 = Unit.INSTANCE;
        this.b = r0;
        e();
        d r7 = this.b;
        Intrinsics.checkNotNull(r7);
        this.c = new UserInfoDataSource(r7);
        Iterator r8 = ((ArrayList) this.a).iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        ((BaseElement) r8.next()).h();
        goto L4
    }

    public final void g() {
        ALogger.d("UserInfoElementManager", "onWidgetLoad");
        if (this.b != null) goto L5;
        MiddlewareRoomRecyclableWidget r3 = this.g;
        Fragment r4 = ((Widget) r3).widgetCallback.getWidgetManager().parentFragment;
        MiddlewareRoomRecyclableWidget r2 = this.g;
        d r1 = new d(r3, r4, ((Widget) r2).dataCenter, r2.getRoomContext(), d(), ((Widget) this.g).isViewValid);
        List<BaseElement> r5 = this.a;
        ArrayList r6 = (ArrayList) r5;
        r6.addAll(b(r1));
        Unit r7 = Unit.INSTANCE;
        this.b = r1;
    L5:
        d r8 = this.b;
        Intrinsics.checkNotNull(r8);
        if (Intrinsics.areEqual(r8.c, ((Widget) this.g).dataCenter) == false) goto L8;
        ALogger.d("UserInfoElementManager", "widgetAbility!!.dataCenter == widget.dataCenter");
    L9:
        d r0 = this.b;
        if (r0 == null) goto L12;
        MiddlewareRoomRecyclableWidget r9 = this.g;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r0.a = r9;
        Fragment r10 = ((Widget) this.g).widgetCallback.getWidgetManager().parentFragment;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r0.b = r10;
        DataCenter r12 = ((Widget) this.g).dataCenter;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r0.c = r12;
        r0.d = this.g.getRoomContext();
        aa1.a r13 = d();
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r0.e = r13;
    L12:
        e();
        UserInfoDataSource r14 = this.c;
        if (r14 == null) goto L15;
        int r15 = y.a;
        y.a(r14.h.getDataCenter(), r14.b, "UserInfoDataSource", new l(r14));
    L15:
        Iterator r16 = ((ArrayList) this.a).iterator();
    L17:
        if (r16.hasNext() == false) goto L19;
        ((BaseElement) r16.next()).i();
        goto L17
    L19:
        DataCenter r17 = ((Widget) this.g).dataCenter;
        if (r17 == null) goto L26;
        o81.a r18 = com.bytedance.android.live.room.navi.userinfo_p.viewmodel.a.a(r17);
        if (r18 == null) goto L27;
        r18.notifyWidgetLoad();
        return;
    L27:
        return;
    L26:
        return;
    L8:
        ALogger.d("UserInfoElementManager", "not equal");
        goto L9
    }

    public final void h() {
        ALogger.d("UserInfoElementManager", "onWidgetUnload");
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((BaseElement) r0.next()).j();
        goto L4
    L6:
        DataCenter r1 = ((Widget) this.g).dataCenter;
        if (r1 == null) goto L11;
        o81.a r2 = com.bytedance.android.live.room.navi.userinfo_p.viewmodel.a.a(r1);
        if (r2 == null) goto L11;
        r2.notifyWidgetUnload();
    L11:
        UserInfoDataSource r3 = this.c;
        if (r3 == null) goto L14;
        r3.b.clear();
        r3.d = false;
        r3.f = false;
        r3.h.getDataCenter().removeObserver(r3);
    L14:
        this.e = null;
        Disposable r4 = this.d;
        if (r4 == null) goto L17;
        r4.dispose();
    L17:
        this.d = null;
    }

    public final void i() {
        ALogger.d("UserInfoElementManager", "onWidgetPrepareViewOnLoad");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((BaseElement) r0.next()).k();
        goto L4
    L6:
        DataCenter r1 = ((Widget) this.g).dataCenter;
        if (r1 == null) goto L13;
        o81.a r2 = com.bytedance.android.live.room.navi.userinfo_p.viewmodel.a.a(r1);
        if (r2 == null) goto L14;
        r2.notifyWidgetViewPrepared();
        return;
    L14:
        return;
    }

    public UserInfoElementManager(MiddlewareRoomRecyclableWidget r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        this.g = r2;
        this.a = new ArrayList();
        this.f = new b(this);
    }

    public final Collection b(d r12) {
        ArrayList r0 = new ArrayList();
        r0.add(new UserInfoBasicElement(r12, (ViewGroup) c(2131362578)));
        if (((Boolean) g81.b.a.getValue()).booleanValue() == false) goto L16;
        ViewGroup r6 = (ViewGroup) c(2131378754);
        View r7 = c(2131371703);
        if (r6 == null) goto L15;
        if (r7 == null) goto L15;
        if (r12.isAnchor() == false) goto L15;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if ((r8 instanceof RelativeLayout.LayoutParams) == true) goto L12;
        r8 = null;
    L12:
        RelativeLayout.LayoutParams r9 = (RelativeLayout.LayoutParams) r8;
        if (r9 == null) goto L15;
        r9.addRule(1, r6.getId());
        r9.addRule(17, r6.getId());
        r7.setLayoutParams(r9);
    L15:
        r0.add(new UserInfoFlipTabElement(r12, (ViewGroup) c(2131378754), (ViewGroup) c(2131362271)));
    L17:
        r0.add(new UserInfoEntranceElement(r12, (ViewGroup) c(2131371703)));
        r0.add(new UserInfoAnimElement(r12, (FrameLayout) c(2131392023), c(2131362578)));
        r0.add(new UserInfoAvatarElement(r12, c(2131374209), c(2131376083), c(2131380733)));
        r0.add(new UserInfoPopupElement(r12, c(2131374209)));
        r0.add(new UserinfoWidthServiceElement(r12, c(2131380608)));
        return r0;
    L16:
        r0.add(new UserInfoMiddleElement(r12, (ViewGroup) c(2131380608), (ViewGroup) c(2131362271), (TextView) c(2131388307)));
        goto L17
    }

    public final <T extends View> T c(int r2) {
        return (T) this.g.findViewById(r2);
    }

    public final void j(IRoom r3) {
        ALogger.d("UserInfoElementManager", "onWidgetRoomEntered");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((BaseElement) r0.next()).l(r3);
        goto L4
    L6:
        DataCenter r1 = ((Widget) this.g).dataCenter;
        if (r1 == null) goto L13;
        o81.a r2 = com.bytedance.android.live.room.navi.userinfo_p.viewmodel.a.a(r1);
        if (r2 == null) goto L14;
        r2.notifyWidgetRoomEnter(r3);
        return;
    L14:
        return;
    }
}
