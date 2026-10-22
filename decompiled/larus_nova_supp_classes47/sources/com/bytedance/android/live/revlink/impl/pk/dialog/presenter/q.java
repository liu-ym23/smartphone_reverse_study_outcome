package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractPkBanContract$View;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkBanListFragment;
import com.bytedance.android.livesdk.link.model.j3;
import com.bytedance.android.livesdk.link.model.k3;
import com.bytedance.android.livesdk.link.model.u0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q extends x31.r {
    public String d;
    public long e;
    public boolean f;
    public Disposable g;
    public boolean h;
    public final Lazy i;
    public final int j;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ q a;

        public b(q r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            ExtraResponse r7 = (ExtraResponse) r6;
            if (r7 == null) goto L31;
            k3 r0 = (k3) r7.data;
            if (r0 == null) goto L32;
            q r1 = this.a;
            j3 r2 = r0.getList();
            boolean r3 = false;
            if (r2 == null) goto L22;
            List r4 = r2.getList();
            if (r4 == null) goto L22;
            if (r4.isEmpty() == true) goto L22;
            j3 r5 = r0.getList();
            if (r5 == null) goto L22;
            String r8 = r5.getNextCursor();
            if (r8 == null) goto L22;
            if (r8.length() != 0) goto L19;
            boolean r9 = true;
        L20:
            if (r9 == true) goto L22;
            r3 = true;
            goto L22
        L19:
            r9 = false;
        L22:
            r1.f = r3;
            q r10 = this.a;
            j3 r12 = r0.getList();
            if (r12 == null) goto L26;
            String r13 = r12.getNextCursor();
            if (r13 == null) goto L26;
        L27:
            r10.d = r13;
            InteractPkBanContract$View r14 = (InteractPkBanContract$View) this.a.c;
            if (r14 == null) goto L33;
            r14.ca0((k3) r7.data);
            return;
        L33:
            return;
        L26:
            r13 = "";
            goto L27
        L32:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ q a;

        public c(q r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            q r0 = this.a;
            r0.d((Throwable) r2);
            InteractPkBanContract$View r3 = (InteractPkBanContract$View) this.a.c;
            if (r3 == null) goto L6;
            r3.ba0();
            return;
        }
    }

    static {
    }

    @Override // x31.r
    public final void e() {
        f(this.d, false);
    }

    @Override // x31.r
    public final void h() {
        this.d = "";
        this.e = 20;
        this.f = true;
        Disposable r0 = this.g;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public q(InteractPkBanListFragment r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.j = r3;
        this.d = "";
        this.e = 20;
        this.f = true;
        this.i = LazyKt.lazy(InteractPkBanListPresenter$mRoom$2.INSTANCE);
    }

    @Override // x31.r
    public final void f(String r10, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "cursor");
        if (r12 == false) goto L5;
        h();
    L5:
        IRoom r13 = (IRoom) this.i.getValue();
        if (r13 != null) goto L8;
        return;
    L8:
        if (this.f == false) goto L24;
        r31.a r1 = r31.b.a(r31.a.a);
        long r2 = r13.getId();
        IBaseUser r0 = r13.getOwner();
        if (r0 == null) goto L12;
        Intrinsics.checkNotNullParameter(r0, "$this$secUidExt");
        r0.getCastSecUid();
    L12:
        IBaseUser r14 = r13.getOwner();
        Disposable r3 = null;
        if (r14 == null) goto L15;
        String r4 = iz.a.a(r14);
    L16:
        Observable r15 = r1.w(r2, r4, r10, this.e, this.j);
        if (r15 == null) goto L21;
        ObservableSubscribeProxy r16 = (ObservableSubscribeProxy) r15.as(c());
        if (r16 == null) goto L21;
        r3 = r16.subscribe(new b(this), new c(this));
    L21:
        this.g = r3;
        return;
    L15:
        r4 = null;
        goto L16
    }

    @Override // x31.r
    public final void g(u0 r9, Function0 r10) {
        Intrinsics.checkNotNullParameter(r9, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r10, "onSuccess");
        if (this.h == false) goto L5;
        return;
    L5:
        IRoom r0 = (IRoom) this.i.getValue();
        if (r0 == null) goto L24;
        this.h = true;
        HashMap r7 = new HashMap();
        if (this.j != 1) goto L10;
        String r1 = "invite_reject_permanent";
        int r6 = 12;
    L11:
        r7.put(r1, Boolean.FALSE);
        String r2 = r9.getUserId();
        if (r2 != null) goto L14;
        r2 = "";
    L14:
        r7.put("rival_anchor_id", r2);
        r31.a r3 = r31.b.a(r31.a.a);
        long r4 = r0.getId();
        IBaseUser r5 = r0.getOwner();
        if (r5 == null) goto L17;
        Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
        String r8 = r5.getCastSecUid();
    L18:
        Observable<ExtraResponse<Object, Extra>> r12 = r3.N(r4, r8, r6, r7);
        if (r12 == null) goto L25;
        ObservableSubscribeProxy r13 = (ObservableSubscribeProxy) r12.as(c());
        if (r13 == null) goto L26;
        r13.subscribe(new r(this, r9, r10), new s(this, r9, r10));
        return;
    L26:
        return;
    L25:
        return;
    L17:
        r8 = null;
        goto L18
    L10:
        r1 = "invite_reject_temporary";
        r6 = 11;
        goto L11
    }
}
