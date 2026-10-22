package com.bytedance.android.ec.core.hybrid.widgets;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import ch.b;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.ec.sdk.plugin.e;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0007R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR%\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/widgets/LynxTaskBanner;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/LifecycleObserver;", "", "onDestroy", "", "a", "Ljava/lang/String;", "getContainerID", "()Ljava/lang/String;", "containerID", "", "", "g", "Ljava/util/Map;", "getInitData", "()Ljava/util/Map;", "initData", "h", "Landroid/widget/FrameLayout;", "getViewGroup", "()Landroid/widget/FrameLayout;", "viewGroup", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxTaskBanner extends FrameLayout implements LifecycleObserver {
    public static final Map<String, LynxTaskBanner> i = null;
    public final String a;
    public l b;
    public String c;
    public String d;
    public final CompositeDisposable e;
    public boolean f;
    public final Map<String, Object> g;
    public final FrameLayout h;

    public static final class a {
        public static String a(Context r10, Map r11, FrameLayout r12) {
            if (r10 != null) goto L5;
            return "context should not be null";
        L5:
            if (r11 != null) goto L8;
            return "params should not be null";
        L8:
            LynxTaskBanner r0 = new LynxTaskBanner(r10, r11, r12);
            Object r13 = r0.g.get("task_enter_from");
            Object r14 = null;
            if ((r13 instanceof String) == true) goto L11;
            r13 = null;
        L11:
            r0.c = (String) r13;
            Object r15 = r0.g.get("task_type");
            if ((r15 instanceof String) == true) goto L14;
            r15 = null;
        L14:
            r0.d = (String) r15;
            Object r16 = r0.g.get("task_request_params");
            if ((r16 instanceof JSONObject) == false) goto L18;
            r14 = r16;
        L18:
            JSONObject r17 = (JSONObject) r14;
            if (r17 != null) goto L29;
            String r18 = r0.d;
            if (r18 != null) goto L23;
        L26:
            boolean r19 = true;
        L27:
            if (r19 == false) goto L29;
            return "task_request_params or task_type should not be empty";
        L23:
            if (r18.length() == 0) goto L26;
            r19 = false;
        L29:
            CompositeDisposable r20 = r0.e;
            ECLynxTaskBannerApi r21 = (ECLynxTaskBannerApi) n.a.create("https://aweme.snssdk.com", ECLynxTaskBannerApi.class);
            ECLynxTaskBannerApi.a.getClass();
            LinkedHashMap r1 = new LinkedHashMap();
            r1.put("taskType", r0.d);
            r1.put("bizID", r0.c);
            r1.put(com.bytedance.android.ec.core.event.a.KEY_USER_ID, r.a.getCurrentUserId());
            if (r17 == null) goto L35;
            Iterator<String> r22 = r17.keys();
        L33:
            if (r22.hasNext() == false) goto L35;
            String r23 = r22.next();
            r1.put(r23, r17.optString(r23));
        L35:
            Unit r24 = Unit.INSTANCE;
            r20.add(r21.getFloatWindowDetail("https://lianmengapi.snssdk.com/ecom/activity/biz_mesh_api/get_floating_window_detail/", r1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ch.a(r0), b.a));
            return r0.a;
        }
    }

    static {
        i = new LinkedHashMap();
    }

    public final void b() {
        if (this.f == false) goto L5;
        return;
    L5:
        l r0 = this.b;
        if (r0 == null) goto L8;
        r0.release();
    L8:
        LifecycleOwner r1 = null;
        this.b = null;
        this.e.dispose();
        FrameLayout r10 = this.h;
        if (r10 == null) goto L11;
        r10.removeView(this);
    L23:
        removeAllViews();
        LifecycleOwner r11 = getContext();
        if ((r11 instanceof LifecycleOwner) == false) goto L27;
        r1 = r11;
    L27:
        LifecycleOwner r12 = r1;
        if (r12 == null) goto L32;
        Lifecycle r13 = r12.getLifecycle();
        if (r13 == null) goto L32;
        r13.removeObserver(this);
    L32:
        this.f = true;
        return;
    L11:
        Activity r14 = e.getActivity(getContext());
        if (r14 == null) goto L16;
        Window r15 = r14.getWindow();
        if (r15 == null) goto L16;
        View r16 = a(r15);
    L18:
        if ((r16 instanceof ViewGroup) == true) goto L20;
        r16 = null;
    L20:
        ViewGroup r17 = (ViewGroup) r16;
        if (r17 == null) goto L23;
        r17.removeView(this);
    L16:
        r16 = null;
        goto L18
    }

    public final String getContainerID() {
        return this.a;
    }

    public final Map<String, Object> getInitData() {
        return this.g;
    }

    public final FrameLayout getViewGroup() {
        return this.h;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        b();
    }

    public static View a(Window r10) {
        View r11 = r10.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r11;
    }

    public LynxTaskBanner(Context r12, Map<String, ? extends Object> r13, FrameLayout r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "initData");
        super(r12);
        this.g = r13;
        this.h = r14;
        String r0 = UUID.randomUUID().toString();
        this.a = r0;
        this.e = new CompositeDisposable();
        Object r15 = r13.get("frame");
        View r10 = null;
        if ((r15 instanceof JSONObject) == true) goto L5;
        r15 = null;
    L5:
        JSONObject r16 = (JSONObject) r15;
        if ((r12 instanceof FragmentActivity) == false) goto L29;
        FragmentActivity r1 = (FragmentActivity) r12;
        r1.getLifecycle().addObserver(this);
        View r11 = a(r1.getWindow());
        if ((r11 instanceof FrameLayout) == false) goto L11;
        r10 = r11;
    L11:
        FrameLayout r17 = (FrameLayout) r10;
        if (r17 == null) goto L30;
        int r18 = -2;
        if (r16 == null) goto L23;
        double r19 = r16.optDouble("width", 0.0d);
        double r20 = 0;
        if (r19 < r20) goto L18;
        int r110 = vf4.a.b(Double.valueOf(r19));
    L19:
        double r21 = r16.optDouble("height", 0.0d);
        if (r21 < r20) goto L22;
        r18 = vf4.a.b(Double.valueOf(r21));
    L22:
        FrameLayout.LayoutParams r22 = new FrameLayout.LayoutParams(r110, r18);
        r22.gravity = 51;
        r22.setMargins(vf4.a.b(Double.valueOf(r16.optDouble("x", 0.0d))), vf4.a.b(Double.valueOf(r16.optDouble("y", 0.0d))), 0, 0);
    L24:
        if (r14 == null) goto L26;
        r14.addView(this, r22);
    L27:
        i.put(r0, this);
        return;
    L26:
        r17.addView(this, r22);
        goto L27
    L18:
        r110 = -2;
        goto L19
    L23:
        r22 = new FrameLayout.LayoutParams(-2, -2);
        r22.gravity = 83;
        r22.setMargins(vf4.a.a(r12, 0.0f), 0, 0, vf4.a.a(r12, 106.0f));
        goto L24
    L30:
        return;
    }
}
