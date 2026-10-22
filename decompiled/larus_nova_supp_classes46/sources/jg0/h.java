package jg0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.viewbinder.MultiLinkPreOnlineViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h extends g<tf0.e> {
    public Context d;
    public final DataCenter e;
    public final g<MultiLinkGuestViewBinder.a> f;
    public final g<MultiLinkNormalEmptyViewBinder.a> g;
    public final g<MultiLinkSpecialViewBinder.a> h;
    public final g<MultiLinkPreOnlineViewBinder.a> i;

    public static final class a implements Runnable {
        public final /* synthetic */ h a;
        public final /* synthetic */ int b;

        public a(h r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DataCenter r0 = this.a.e;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.put("data_dynamic_island_layout_seat_update", Integer.valueOf(this.b));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    @Override // jg0.g, jg0.f
    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.a(r2);
        this.d = r2;
    }

    @Override // jg0.g, jg0.f
    public final /* bridge */ /* synthetic */ void d(Object r1, int r2) {
        v((tf0.e) r1, r2);
    }

    @Override // jg0.g
    public final void v(tf0.e r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "itemData");
        ViewGroup r0 = this.b;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        onDetach();
        ((ArrayList) this.a).clear();
        if ((r4 instanceof MultiLinkGuestViewBinder.a) == false) goto L9;
        f r1 = this.f;
    L18:
        if (r1 != null) goto L20;
        return;
    L20:
        Context r2 = this.d;
        Intrinsics.checkNotNull(r2);
        r1.a(r2);
        b(r1);
        View r3 = r1.l();
        ViewGroup r6 = this.b;
        if (r6 == null) goto L23;
        r6.addView(r3);
    L23:
        Context r7 = this.d;
        Intrinsics.checkNotNull(r7);
        r1.j(r7);
        AndroidSchedulers.mainThread().scheduleDirect(new a(this, r5));
        super.v(r4, r5);
        return;
    L9:
        if ((r4 instanceof MultiLinkNormalEmptyViewBinder.a) == false) goto L12;
        r1 = this.g;
        goto L18
    L12:
        if ((r4 instanceof MultiLinkSpecialViewBinder.a) == false) goto L15;
        r1 = this.h;
        goto L18
    L15:
        if ((r4 instanceof MultiLinkPreOnlineViewBinder.a) == false) goto L17;
        r1 = this.i;
        goto L18
    L17:
        r1 = null;
        goto L18
    }

    @Override // jg0.g, jg0.f
    public final /* bridge */ /* synthetic */ void k(Object r1, int r2, Bundle r3) {
        w((tf0.e) r1, r2, r3);
    }

    @Override // jg0.g
    public final void w(tf0.e r4, int r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "itemData");
        Intrinsics.checkNotNullParameter(r6, "payload");
        if ((r4 instanceof MultiLinkGuestViewBinder.a) == false) goto L6;
        Object r0 = this.f;
    L16:
        if ((!Intrinsics.areEqual((f) CollectionsKt.getOrNull(this.a, 0), r0)) == false) goto L18;
        v(r4, r5);
        return;
    L18:
        super.w(r4, r5, r6);
        return;
    L6:
        if ((r4 instanceof MultiLinkNormalEmptyViewBinder.a) == false) goto L9;
        r0 = this.g;
        goto L16
    L9:
        if ((r4 instanceof MultiLinkSpecialViewBinder.a) == false) goto L12;
        r0 = this.h;
        goto L16
    L12:
        if ((r4 instanceof MultiLinkPreOnlineViewBinder.a) == false) goto L14;
        r0 = this.i;
        goto L16
    L14:
        r0 = null;
        goto L16
    }

    public h(ViewGroup r2, DataCenter r3, g<MultiLinkGuestViewBinder.a> r4, g<MultiLinkNormalEmptyViewBinder.a> r5, g<MultiLinkSpecialViewBinder.a> r6, g<MultiLinkPreOnlineViewBinder.a> r7) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Intrinsics.checkNotNullParameter(r4, "guestLayer");
        Intrinsics.checkNotNullParameter(r5, "emptyLayer");
        Intrinsics.checkNotNullParameter(r6, "specialItemLayer");
        Intrinsics.checkNotNullParameter(r7, "preOnlineLayer");
        super(r2);
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
    }
}
