package com.bytedance.android.live.room.navi.userinfo_p.widget.ecom;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement;
import com.bytedance.android.live.room.navi.userinfo_p.mvi.UserInfoDataSource;
import com.bytedance.android.live.room.navi.userinfo_p.presenter.UserInfoAvatarPresenter;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.UserInfoVM;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import m91.d;
import n91.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ECUserInfoElementManager {
    public final List<BaseElement> a;
    public d b;
    public UserInfoDataSource c;
    public Disposable d;
    public aa1.a e;
    public UserInfoAvatarPresenter f;
    public final b g;
    public final MiddlewareRoomRecyclableWidget h;
    public final ViewGroup i;

    public static final class a {
    }

    public static final class b implements c {
        public final /* synthetic */ ECUserInfoElementManager a;

        @Override // n91.c
        public final View getContentView() {
            return ((Widget) this.a.h).contentView;
        }

        public b(ECUserInfoElementManager r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final synchronized aa1.a a() {
        monitor-enter(this);
        aa1.a r1 = this.e;     // Catch: Throwable -> L16
        if (r1 != null) goto L14;
        Pair r2 = com.bytedance.live.datacontext.d.a(ECUserInfoElementManager$getUserInfoViewModel$1.INSTANCE);     // Catch: Throwable -> L16
        aa1.a r3 = (aa1.a) r2.getFirst();     // Catch: Throwable -> L16
        this.e = r3;     // Catch: Throwable -> L16
        if (r3 == null) goto L9;
        UserInfoVM.Companion.getClass();     // Catch: Throwable -> L16
        UserInfoVM.b.a(r3);     // Catch: Throwable -> L16
    L9:
        this.d = (Disposable) r2.getSecond();     // Catch: Throwable -> L16
        ALogger.d("ECUserInfoElementManager", "[" + this + "] create new userInfoViewMode:[" + this.e + ']');     // Catch: Throwable -> L16
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

    public final void b() {
        d r0 = this.b;
        if (r0 == null) goto L12;
        r0.e.getElementInteractVm().registerService(c.class, this.g);
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

    public ECUserInfoElementManager(MiddlewareRoomRecyclableWidget r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        Intrinsics.checkNotNullParameter(r3, "mEntranceContainer");
        this.h = r2;
        this.i = r3;
        this.a = new ArrayList();
        this.g = new b(this);
    }
}
