package com.bytedance.android.live.core.tetris.widgets;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.livesdk.preview.merge.AbsMergeWidget;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class LiveRecyclableWidget extends LiveWidget implements a {
    public static final String ALOG_TAG_WIDGET = "ttlive_widget";
    private final String TAG;
    private boolean alive;
    private Object[] args;
    private boolean clearAfterDestroyed;
    private boolean initialized;
    private boolean onAsyncLoading;
    private boolean recyclable;

    public String getNitaTag() {
        return "";
    }

    public void handleRoomVisible() {
    }

    public boolean isRecyclableOnRotation() {
        return true;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public final void onCreate() {
        this.alive = true;
        super.onCreate();
        if (this.initialized == true) goto L13;
        onInit(this.args);
        f r1 = this.widgetLifeCycleObserver;
        if (r1 == null) goto L12;
        List<? extends e80.a> r2 = r1.a;
        if (r2 == null) goto L12;
        Iterator<T> r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        ((e80.a) r3.next()).g(r1.b);
    L12:
        this.initialized = true;
    L13:
        onLoad(this.args);
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L16;
        handleRoomVisible();
    L16:
        f r0 = this.widgetLifeCycleObserver;
        if (r0 == null) goto L33;
        List<? extends e80.a> r4 = r0.a;
        if (r4 == null) goto L24;
        Iterator<T> r5 = r4.iterator();
    L22:
        if (r5.hasNext() == false) goto L24;
        ((e80.a) r5.next()).onLoad(r0.b);
    L24:
        Widget r6 = r0.b;
        if (r6 == null) goto L27;
        DataCenter r7 = r6.dataCenter;
    L28:
        if (r7 != null) goto L34;
        f.a("onLoad");
        return;
    L34:
        return;
    L27:
        r7 = null;
        goto L28
    }

    public abstract void onInit(Object[] r1);

    public abstract void onLoad(Object[] r1);

    public abstract void onUnload();

    @Override // com.bytedance.android.live.core.tetris.widgets.a
    public final void setRecyclable() {
        this.recyclable = true;
    }

    public void slideRecyclerListToEnd() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.a
    public final void clearAfterDestroyed() {
        if (this.alive == false) goto L6;
        this.clearAfterDestroyed = true;
        return;
    L6:
        if (((Widget) this).isDestroyed == false) goto L10;
        onClear();
        return;
    }

    public boolean isScreenPortrait() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return ((Boolean) r0.get("data_is_portrait", Boolean.FALSE)).booleanValue();
    }

    public void onClear() {
        f r0 = this.widgetLifeCycleObserver;
        if (r0 == null) goto L10;
        List<? extends e80.a> r1 = r0.a;
        if (r1 == null) goto L12;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        ((e80.a) r2.next()).a(r0.b);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public LiveRecyclableWidget() {
        this.TAG = getClass().getSimpleName();
        this.recyclable = false;
    }

    public boolean isScreenLandscape() {
        return !isScreenPortrait();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public void onDestroy() {
        if (getLoadedEnvironment() == AbsMergeWidget.MergeWidgetEnvironment.PREVIEW) goto L36;
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L12;
        ViewGroup r1 = ((Widget) this).containerView;
        if (r1 == null) goto L12;
        r1.removeView(r0);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        ALogger.e(ALOG_TAG_WIDGET, getClass().getSimpleName().concat(" destroy crash."), e);
    L12:
        releaseSubWidgetManager();
    L36:
        onUnload();     // Catch: Exception -> L23
        f r2 = this.widgetLifeCycleObserver;     // Catch: Exception -> L23
        if (r2 == null) goto L25;
        List<? extends e80.a> r3 = r2.a;     // Catch: Exception -> L23
        if (r3 == null) goto L25;
        Iterator<T> r4 = r3.iterator();     // Catch: Exception -> L23
    L20:
        if (r4.hasNext() == false) goto L25;
        ((e80.a) r4.next()).j(r2.b);     // Catch: Exception -> L23
    L25:
        super.onDestroy();
        ((Widget) this).dataCenter = null;
        if (getLoadedEnvironment() == AbsMergeWidget.MergeWidgetEnvironment.PREVIEW) goto L28;
        ((Widget) this).containerView = null;
        setWidgetCallback(null);
        this.args = null;
        ((Widget) this).context = null;
    L28:
        this.alive = false;
        if (this.clearAfterDestroyed == false) goto L31;
    L32:
        onClear();
        this.initialized = false;
        return;
    L31:
        if (this.recyclable == false) goto L32;
        return;
    L23:
        e = move-exception;
        SafetyGuard.a(null, e, "LiveRecyclableWidget onUnload error");
        goto L25
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public void onMergeUnLoad() {
        super.onMergeUnLoad();
        if (getLoadedEnvironment() != AbsMergeWidget.MergeWidgetEnvironment.PREVIEW) goto L16;
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L12;
        ViewGroup r1 = ((Widget) this).containerView;
        if (r1 == null) goto L12;
        r1.removeView(r0);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        ALogger.e(ALOG_TAG_WIDGET, getClass().getSimpleName().concat(" destroy crash."), e);
    L12:
        releaseSubWidgetManager();
        ((Widget) this).containerView = null;
        setWidgetCallback(null);
        this.args = null;
        ((Widget) this).context = null;
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.a
    public final boolean isAlive() {
        return this.alive;
    }

    public boolean isAsyncLoading() {
        return this.onAsyncLoading;
    }

    public final boolean isInitialized() {
        return this.initialized;
    }

    public Boolean recylerViewIsBottom() {
        return Boolean.FALSE;
    }

    public void enqueueRunnableToMainThread(Runnable r2) {
        if (k60.b.a() == false) goto L5;
        i0.i(c50.b.b(((Widget) this).dataCenter), r2);
        return;
    L5:
        r2.run();
    }

    public final void setArgs(Object[] r1) {
        this.args = r1;
    }

    public void setIsAsyncLoading(Boolean r1) {
        this.onAsyncLoading = r1.booleanValue();
    }
}
