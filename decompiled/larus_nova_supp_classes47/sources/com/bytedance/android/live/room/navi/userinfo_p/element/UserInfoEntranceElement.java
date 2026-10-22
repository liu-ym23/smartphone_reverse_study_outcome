package com.bytedance.android.live.room.navi.userinfo_p.element;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement;
import com.bytedance.android.live.room.y;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.config.e51;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import j40.b1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/element/UserInfoEntranceElement;", "Lcom/bytedance/android/live/room/navi/userinfo_p/element/base/BaseElement;", "Ln91/a;", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoEntranceElement extends BaseElement implements n91.a {
    public View d;
    public ViewGroup e;
    public ViewGroup f;
    public ViewGroup g;
    public com.bytedance.android.live.profit.fansclub.o h;
    public final CompositeDisposable i;
    public final ViewGroup j;

    public static final class a implements Runnable {
        public final /* synthetic */ UserInfoEntranceElement a;

        public a(UserInfoEntranceElement r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UserInfoEntranceElement r0 = this.a;     // Catch: Throwable -> L10
            MiddlewareRoomContext r1 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r0.getDataCenter(), 0, 2);     // Catch: Throwable -> L10
            if (r1 == null) goto L7;
            com.bytedance.live.datacontext.j r2 = r1.getRevenueInstance();     // Catch: Throwable -> L10
            if (r2 == null) goto L7;
            com.bytedance.android.live.revenue.core.b r3 = (com.bytedance.android.live.revenue.core.b) r2.getValue();     // Catch: Throwable -> L10
        L8:
            int r4 = yt0.c.a;     // Catch: Throwable -> L10
            boolean r5 = com.bytedance.android.live.revenue.core.util.h.a;     // Catch: Throwable -> L10
            r0.h = (com.bytedance.android.live.profit.fansclub.o) com.bytedance.android.live.revenue.core.util.h.b(r3, com.bytedance.android.live.profit.fansclub.o.class);     // Catch: Throwable -> L10
            return;
        L7:
            r3 = null;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ UserInfoEntranceElement a;

        public b(UserInfoEntranceElement r1) {
            this.a = r1;
        }

        public final void a() {
            b1 r0 = b1.a;
            Boolean r2 = null;
            ViewGroup r3 = null;
            if (r0.getValue() != null) goto L5;
        L28:
            UserInfoEntranceElement r1 = this.a;
            if (r1.getContext() == null) goto L41;
            com.bytedance.android.live.profit.fansclub.o r4 = r1.h;
            if (r4 == null) goto L39;
            Context r5 = r1.getContext();
            DataCenter r6 = r1.getDataCenter();
            ViewGroup r7 = r1.j;
            m91.c r8 = r1.c;
            if (r8 == null) goto L36;
            r2 = Boolean.valueOf(r8.c());
        L36:
            r4.p1(r5, r6, r7, false, r2.booleanValue());
            return;
        L39:
            return;
        L41:
            return;
        L5:
            if (((e51) r0.getValue()).c() == false) goto L28;
            UserInfoEntranceElement r9 = this.a;
            if (r9.getContext() == null) goto L40;
            com.bytedance.android.live.profit.fansclub.o r10 = r9.h;
            if (r10 == null) goto L12;
            r10.ae(r9.getContext(), r9.getDataCenter(), r9.j, r9.d, r9.e, r9.f, r9.g);
        L12:
            com.bytedance.android.live.profit.fansclub.o r12 = r9.h;
            if (r12 == null) goto L15;
            View r13 = r12.e1();
        L16:
            r9.d = r13;
            com.bytedance.android.live.profit.fansclub.o r14 = r9.h;
            if (r14 == null) goto L19;
            ViewGroup r15 = r14.yl();
        L20:
            r9.e = r15;
            com.bytedance.android.live.profit.fansclub.o r16 = r9.h;
            if (r16 == null) goto L23;
            ViewGroup r17 = r16.D5();
        L24:
            r9.f = r17;
            com.bytedance.android.live.profit.fansclub.o r18 = r9.h;
            if (r18 == null) goto L27;
            r3 = r18.na();
        L27:
            r9.g = r3;
            return;
        L23:
            r17 = null;
            goto L24
        L19:
            r15 = null;
            goto L20
        L15:
            r13 = null;
            goto L16
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void h() {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void l(IRoom r1) {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void i() {
        if (MultiRoomConfig.INSTANCE.enableRev(Boolean.valueOf(z.e(getDataCenter(), false))) == false) goto L5;
        int r0 = y.a;
        y.a(getDataCenter(), this.i, "UserInfoEntranceElement#onLoad", new a(this));
        return;
    L5:
        this.h = yt0.c.c();
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void j() {
        this.i.clear();
        if (((e51) b1.a.getValue()).c() == true) goto L8;
        com.bytedance.android.live.profit.fansclub.o r0 = this.h;
        if (r0 == null) goto L7;
        r0.E5();
    L7:
        this.j.removeAllViews();
        ALogger.i("EntranceMVI", "On EntranceContainer Unload All Views.");
    L8:
        this.h = null;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void k() {
        int r0 = y.a;
        y.a(getDataCenter(), this.i, "UserInfoEntranceElement#onWidgetPrepareViewOnLoad", new b(this));
    }

    public UserInfoEntranceElement(m91.d r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "userInfoAbility");
        Intrinsics.checkNotNullParameter(r3, "mEntranceContainer");
        super(r2);
        this.j = r3;
        this.i = new CompositeDisposable();
    }
}
