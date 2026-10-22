package com.bytedance.android.live.core.tetris.widgets;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.utils.NitaInflateUtil;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.ies.sdk.widgets.perf.WidgetPerfManager;
import com.bytedance.ies.sdk.widgets.priority.ContinueLoadTask;
import com.bytedance.ies.sdk.widgets.priority.GroupSchedule;
import com.bytedance.ies.sdk.widgets.priority.ILoadTask;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p implements ILoadTask<Object> {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ LiveRecyclableWidget b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ WidgetManager.LoadCallback e;
    public final /* synthetic */ RecyclableWidgetManager f;

    public final Object run() {
        final RecyclableWidgetManager r0 = this.f;
        final ViewGroup r1 = this.a;
        final Widget r2 = this.b;
        boolean r3 = this.c;
        boolean r4 = this.d;
        RecyclableWidgetManager.a r5 = RecyclableWidgetManager.j;
        Context r6 = ((WidgetManager) r0).context;
        if ((r6 instanceof Activity) == false) goto L5;
        Activity r7 = (Activity) r6;
    L6:
        e80.b r8 = r0.e;
        if (r8 == null) goto L10;
        r8.d(r2);
    L10:
        if (r2.isInitialized() == true) goto L83;
        boolean r9 = true;
        if (r2.getLayoutId() != 0) goto L28;
    L68:
        if (r3 == false) goto L77;
        k60.a r11 = k60.b.a;
        if (r11.mEnable == true) goto L72;
    L74:
        r9 = false;
    L75:
        if (r9 == false) goto L77;
        i0.i(c50.b.b(r2.dataCenter), new i(r0, r2, r1));
    L78:
        WidgetPerfManager.getInstance().onPerfEnd(r2, "onLoad");
        WidgetManager.LoadCallback r12 = this.e;
        if (r12 == null) goto L81;
        r12.onLoaded(r2);
    L81:
        return r2;
    L72:
        if (r11.mEnableAsyncV2 == false) goto L74;
    L77:
        GroupSchedule.getInstance().enqueueContinueLoad(r2, new s(r0, r2, r1));
        goto L78
    L28:
        if (r2.getLayoutView() != null) goto L68;
        String r13 = r2.getNitaTag();
        int r14 = r2.getLayoutId();
        Lazy r15 = NitaInflateUtil.a;
        Intrinsics.checkNotNullParameter(r13, "nitaTag");
        if (r13.length() == 0) goto L34;
        r9 = false;
    L34:
        if (r9 == true) goto L39;
        IMiddlewareHostBusiness r16 = (IMiddlewareHostBusiness) NitaInflateUtil.a.getValue();
        if (r16 == null) goto L39;
        boolean r17 = r16.hasCachedView(r13, r14);
    L40:
        if (r17 == false) goto L46;
        if (r7 == null) goto L46;
        View r18 = r2.contentView;
        if (r18 != null) goto L45;
        r18 = NitaInflateUtil.a(r2.getLayoutId(), r2.getNitaTag(), r7, r1, false);
    L45:
        GroupSchedule.getInstance().enqueueContinueLoad(r2, new t(r0, r2, r1, r18));
    L46:
        if (r3 == false) goto L51;
        WidgetPerfManager.getInstance().onPerfStart(r2, "inflate");
        r0.onLoadByAsync(r2);
        if (r2.contentView != null) goto L50;
        ((WidgetManager) r0).asyncLayoutInflater.inflate(r2.getLayoutId(), r1, new j(r0, r2, r1));
        goto L78
    L50:
        ContinueLoadTask r19 = new ContinueLoadTask(r2, new v(r0, r2, r1));
        i0.i(c50.b.b(r2.dataCenter), r19);
        goto L78
    L51:
        x70.b r21 = r0.f;
        if (r21 != null) goto L54;
    L64:
        View r22 = r2.contentView;
        if (r22 != null) goto L67;
        WidgetPerfManager.getInstance().onPerfStart(r2, "inflate");
        r22 = ((WidgetManager) r0).syncLayoutInflater.inflate(r2.getLayoutId(), r1, false);
        WidgetPerfManager.getInstance().onPerfEnd(r2, "inflate");
    L67:
        GroupSchedule.getInstance().enqueueContinueLoad(r2, new k(r0, r2, r1, r22));
        goto L78
    L54:
        if (r21.a(r2.getLayoutId()) == false) goto L64;
        if (r0.isRemoving() == true) goto L78;
        if (r0.isDetached() == true) goto L78;
        if (r0.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L78;
        if (((WidgetManager) r0).widgetCallback.getWidgetManager() != r0) goto L78;
        GroupSchedule.getInstance().enqueueContinueLoad(r2, new w(r0, r2, r1));
    L39:
        r17 = false;
        goto L40
    L83:
    L22:
        e = move-exception;
        throw new RuntimeException(((WidgetManager) r0).syncLayoutInflater.getContext().getResources().getClass().getName(), e);
    L12:
        if (k60.b.a() == false) goto L20;
        if (r3 == false) goto L20;
        WidgetPerfManager.getInstance().onPerfStart(r2, "inflate");     // Catch: Exception -> L22
        r0.onLoadByAsync(r2);     // Catch: Exception -> L22
        ContinueLoadTask r23 = new ContinueLoadTask(r2, new q(r0, r2, r1));     // Catch: Exception -> L22
        if (k60.b.c() == true) goto L17;
        i0.i(c50.b.b(r2.dataCenter), r23);     // Catch: Exception -> L22
    L82:
        goto L78
    L17:
        if (r4 == false) goto L19;
        i0.f(r23);     // Catch: Exception -> L22
        goto L82
    L19:
        i0.d(r23);     // Catch: Exception -> L22
    L20:
        GroupSchedule.getInstance().enqueueContinueLoad(r2, new r(r0, r2, r1));     // Catch: Exception -> L22
        goto L82
    L5:
        r7 = null;
        goto L6
    }

    public p(RecyclableWidgetManager r1, ViewGroup r2, LiveRecyclableWidget r3, boolean r4) {
        this.f = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = false;
        this.e = null;
    }
}
