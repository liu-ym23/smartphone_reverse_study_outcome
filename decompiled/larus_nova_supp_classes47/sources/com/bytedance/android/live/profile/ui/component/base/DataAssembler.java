package com.bytedance.android.live.profile.ui.component.base;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.ui.base.g;
import com.bytedance.android.live.profile.ui.base.l;
import com.bytedance.android.live.profile.ui.component.base.b;
import com.bytedance.android.live.profile.ui.component.view.ProfileButtonView;
import com.bytedance.android.live.profile.ui.util.i;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.business.depend.largefont.IHostLargeFontService;
import com.bytedance.android.livesdk.m;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class DataAssembler<T extends b> implements g {
    public final Lazy a;
    public final ArrayList<T> b;
    public com.bytedance.android.live.profile.ui.component.base.a<T> c;
    public final List<c<T>> d;
    public final l e;
    public final ViewGroup f;

    public static final class a extends vt0.b {
        public final /* synthetic */ DataAssembler d;
        public final /* synthetic */ NewProfileUser e;
        public final /* synthetic */ b f;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // vt0.b
        public final void a(View r4) {
            Intrinsics.checkNotNullParameter(r4, "v");
            this.d.n(r4, this.e, this.f);
        }

        public a(DataAssembler r1, NewProfileUser r2, b r3) {
            this.d = r1;
            this.e = r2;
            this.f = r3;
        }
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r1) {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void e(ProfileSkin r1) {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void f() {
    }

    public abstract View k(T r1, NewProfileUser r2);

    public ViewGroup.LayoutParams l(int r1, T r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        return null;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public void onComponentDestroy() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public abstract /* synthetic */ void update(NewProfileUser r1);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3 */
    public final void a(NewProfileUser r10) {
        Intrinsics.checkNotNullParameter(r10, "user");
        this.f.removeAllViews();
        ((ArrayList) this.d).clear();
        Iterator<T> r0 = this.b.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L12;
        T r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        T r4 = r2;
        ?? r5 = j(r1, r4, r10);
        m(r5, r4, r10);
        List<c<T>> r6 = this.d;
        int r7 = r4.getType();
        if ((r5 instanceof e) == true) goto L11;
        r5 = 0;
    L11:
        ArrayList r8 = (ArrayList) r6;
        r8.add(new c(r7, r1, r4, (e) r5));
        r1 = r3;
        goto L4
    }

    public final void c(ArrayList<g> r4) {
        Intrinsics.checkNotNullParameter(r4, "list");
        d r0 = (d) this.a.getValue();
        if (r0 == null) goto L5;
        new ArrayList(this.b);
        List r1 = r0.b();
        this.b.clear();
        this.b.addAll(r1);
    L5:
        r4.add(this);
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public void d(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r2, "user");
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public void g(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        a(r2);
    }

    public final void h(b r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        this.b.add(r2);
    }

    public DataAssembler(l r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "hostInterface");
        Intrinsics.checkNotNullParameter(r3, "container");
        this.e = r2;
        this.f = r3;
        this.a = LazyKt.lazy(new DataAssembler$dataHandler$2(this));
        this.b = new ArrayList();
        this.d = new ArrayList();
    }

    public final void i(b r2, Function0 r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, FileUtils.FILTER);
        if (((Boolean) r3.invoke()).booleanValue() == false) goto L10;
        d r4 = (d) this.a.getValue();
        if (r4 != null) goto L7;
    L8:
        this.b.add(r2);
        return;
    L7:
        if (r4.a() == true) goto L8;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void m(View r1, b r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r3, "user");
        if (r1 != 0) goto L5;
        return;
    L5:
        if ((r1 instanceof e) == false) goto L19;
        ((e) r1).c(r2, r3);     // Catch: Exception -> L11
        ProfileSkin r4 = r3.mProfileSkin;     // Catch: Exception -> L11
        if (r4 == null) goto L9;
        ((e) r1).d(r2, r4);     // Catch: Exception -> L11
    L9:
        ((e) r1).e(r2);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        if (v.a() == true) goto L15;
        ALogger.e(NewProfileInfoViewModel.TAG, "DataAssembler-" + e);
        return;
    L15:
        throw e;
    }

    public final View j(int r4, T r5, NewProfileUser r6) {
        Intrinsics.checkNotNullParameter(r5, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r6, "user");
        ViewGroup.LayoutParams r7 = l(r4, r5);
        View r0 = k(r5, r6);
        if (r0 == null) goto L17;
        if (r7 == null) goto L6;
        this.f.addView(r0, r7);
    L8:
        if ((r0 instanceof ProfileButtonView) == false) goto L16;
        int r8 = i.a;
        if (m.c() == false) goto L16;
        IMiddlewareHostBusiness r9 = k.f(IMiddlewareHostBusiness.class);
        if (r9 == null) goto L16;
        IHostLargeFontService r10 = r9.getLiveLargeFontService();
        if (r10 == null) goto L16;
        r10.noZoomAll((ViewGroup) r0, 0);
    L16:
        r0.setOnClickListener(new a(this, r6, r5));
        goto L17
    L6:
        this.f.addView(r0);
    L17:
        return r0;
    }

    public final void n(View r2, NewProfileUser r3, T r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, Constants.Keys.DATA);
        com.bytedance.android.live.profile.ui.component.base.a<T> r0 = this.c;
        if (r0 == null) goto L6;
        r0.a(r2, r3, r4);
        return;
    }
}
