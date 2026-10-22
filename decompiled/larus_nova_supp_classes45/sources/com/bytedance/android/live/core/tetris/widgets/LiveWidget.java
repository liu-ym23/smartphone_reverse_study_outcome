package com.bytedance.android.live.core.tetris.widgets;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.CommonLifecycleTransformer;
import com.bytedance.android.live.core.utils.rxutils.IoToUiTransformer;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AndroidLifecycleScopeProvider;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.livesdk.config.aw;
import com.bytedance.android.livesdk.config.i91;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.FirstScreenOptConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMemLeakConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.livesdk.preview.merge.AbsMergeWidget;
import com.bytedance.livesdk.preview.merge.PreviewViewHolderStatus;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@LiveWidgetRecord
public abstract class LiveWidget extends AbsMergeWidget implements tw2.b, z70.a {
    private static final String TAG = "LiveWidget";
    private CompositeDisposable compositeDisposable;
    private Map<String, String> extraInfo;
    protected boolean isAppBackground;
    private CommonLifecycleTransformer lifecycleTransformer;
    private PreviewState previewStatus;
    private Animator showAnimator;
    private IoToUiTransformer transformer;
    protected f widgetLifeCycleObserver;

    public static final enum PreviewState extends Enum<PreviewState> {
        public static final PreviewState CREATED = null;
        public static final PreviewState DESTORYED = null;
        public static final PreviewState LOADED = null;
        public static final PreviewState PAUSEED = null;
        public static final PreviewState RESUMED = null;
        public static final PreviewState STARTED = null;
        public static final PreviewState STOPED = null;
        public static final PreviewState UNLOAD = null;
        public static final /* synthetic */ PreviewState[] a = null;

        static {
            PreviewState r0 = new PreviewState("LOADED", 0);
            LOADED = r0;
            PreviewState r1 = new PreviewState("CREATED", 1);
            CREATED = r1;
            PreviewState r3 = new PreviewState("STARTED", 2);
            STARTED = r3;
            PreviewState r5 = new PreviewState("RESUMED", 3);
            RESUMED = r5;
            PreviewState r7 = new PreviewState("PAUSEED", 4);
            PAUSEED = r7;
            PreviewState r9 = new PreviewState("STOPED", 5);
            STOPED = r9;
            PreviewState r11 = new PreviewState("DESTORYED", 6);
            DESTORYED = r11;
            PreviewState r13 = new PreviewState("UNLOAD", 7);
            UNLOAD = r13;
            a = new PreviewState[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        public static PreviewState[] values() {
            return (PreviewState[]) a.clone();
        }

        public static PreviewState valueOf(String r1) {
            return (PreviewState) r27.a.a(PreviewState.class, r1);
        }

        public PreviewState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public class a implements Consumer<y> {
        public final /* synthetic */ LiveWidget a;

        public a(LiveWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) throws Exception {
            y r5 = (y) r4;
            int r0 = r5.b;     // Catch: Exception -> L11
            if (r0 != 16) goto L7;
            LiveWidget r1 = this.a;     // Catch: Exception -> L11
            r1.isAppBackground = r5.a;     // Catch: Exception -> L11
        L7:
            if (r5.a == false) goto L9;
            this.a.onEnterClear(r0);     // Catch: Exception -> L11
            return;
        L9:
            this.a.onExitClear(r0);     // Catch: Exception -> L11
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public class b implements Predicate<y> {
        public final /* synthetic */ LiveWidget a;

        public b(LiveWidget r1) {
            this.a = r1;
        }

        public final boolean test(Object r3) throws Exception {
            y r4 = (y) r3;
            if ((r4.b & this.a.supportClearScene()) != r4.b) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public Map<String, Object> getEnvData() {
        return null;
    }

    public String getSpm() {
        return "";
    }

    public boolean isIgnored() {
        return false;
    }

    public boolean isInnerPreviewNeedUnbind() {
        return false;
    }

    public boolean isPreviewWidget() {
        return false;
    }

    public void onMergeHolderSelect() {
    }

    public void onMergeHolderUnSelect() {
    }

    public Animator startShowAnimation() {
        return null;
    }

    public int supportClearScene() {
        return 0;
    }

    private void doMergePause() {
        PreviewState r0 = this.previewStatus;
        if (r0 != PreviewState.RESUMED) goto L6;
        onPause();
        onStop();
        return;
    L6:
        if (r0 != PreviewState.STARTED) goto L8;
    L9:
        onStop();
        return;
    L8:
        if (r0 == PreviewState.PAUSEED) goto L9;
    }

    private void doMergeResume() {
        PreviewState r0 = this.previewStatus;
        if (r0 != PreviewState.CREATED) goto L5;
    L12:
        onStart();
        onResume();
        return;
    L5:
        if (r0 == PreviewState.STOPED) goto L12;
        if (r0 != PreviewState.STARTED) goto L10;
    L11:
        onResume();
        return;
    L10:
        if (r0 == PreviewState.PAUSEED) goto L11;
    }

    public final <T> AutoDisposeConverter<T> activityAutoDispose() {
        return AutoDispose.bind(((Widget) this).context);
    }

    public final <T> AutoDisposeConverter<T> activityAutoDisposeWithTransformer() {
        if (this.transformer != null) goto L6;
        this.transformer = new IoToUiTransformer();
    L6:
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(((Widget) this).context, Lifecycle.Event.ON_DESTROY), this.transformer);
    }

    public final <T> AutoDisposeConverter<T> autoDisposeWithTransformer() {
        if (this.transformer != null) goto L6;
        this.transformer = new IoToUiTransformer();
    L6:
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this, Lifecycle.Event.ON_DESTROY), this.transformer);
    }

    public Map<String, Object> getPropertyParams() {
        HashMap r0 = new HashMap();
        r0.put("uni_key", Integer.valueOf(hashCode()));
        return r0;
    }

    public void onCreate() {
        CompositeDisposable r0 = this.compositeDisposable;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        CompositeDisposable r1 = new CompositeDisposable();
        this.compositeDisposable = r1;
        this.lifecycleTransformer = new CommonLifecycleTransformer(r1);
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onCreate();     // Catch: Exception -> L8
    L10:
        this.showAnimator = startShowAnimation();
        registerClearScreen();
        int r2 = f.c;
        boolean r3 = false;
        if (g.a() == false) goto L18;
        i91 r4 = g.c();
        if (r4 == null) goto L15;
        boolean r5 = r4.f();
    L16:
        if (r5 == false) goto L18;
        r3 = true;
        goto L18
    L15:
        r5 = false;
    L18:
        List<? extends e80.a> r6 = null;
        if (r3 == false) goto L21;
        f r7 = new f(this);
    L22:
        this.widgetLifeCycleObserver = r7;
        if (r7 == null) goto L35;
        Widget r8 = r7.b;
        if (r8 == null) goto L29;
        DataCenter r9 = r8.dataCenter;
        if (r9 == null) goto L29;
        r6 = (List) r9.get("data_live_widget_lifecycle_observers", null);
    L29:
        r7.a = r6;
        if (r6 == null) goto L35;
        Iterator<T> r11 = r6.iterator();
    L33:
        if (r11.hasNext() == false) goto L35;
        ((e80.a) r11.next()).l(r7.b);
    L35:
        this.previewStatus = PreviewState.CREATED;
        return;
    L21:
        r7 = null;
    L8:
        e = move-exception;
        ALogger.e(TAG, e);
        goto L10
    }

    public void releaseSubWidgetManager() {
        if (((Widget) this).subWidgetManager == null) goto L11;
        Widget.WidgetCallback r0 = ((Widget) this).widgetCallback;
        if (r0 == null) goto L11;
        if (r0.getWidgetManager() == null) goto L11;
        if (((Widget) this).widgetCallback.getWidgetManager().getHost() == null) goto L11;
        ((Widget) this).widgetCallback.getWidgetManager().getChildFragmentManager().beginTransaction().remove(((Widget) this).subWidgetManager).commitNowAllowingStateLoss();
    L11:
        ((Widget) this).subWidgetManager = null;
    }

    public LiveWidget() {
        this.isAppBackground = false;
        this.previewStatus = PreviewState.UNLOAD;
        this.extraInfo = null;
    }

    private void registerClearScreen() {
        if (supportClearScene() == 0) goto L14;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L7;
        boolean r1 = ((Boolean) r0.get("enable_rxjava_async", Boolean.FALSE)).booleanValue();
    L8:
        Observable r2 = xs2.b.a().b(y.class).filter(new b(this));
        if (r1 == false) goto L11;
        Scheduler r3 = Schedulers.io();
    L12:
        Disposable r4 = r2.subscribeOn(r3).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        this.compositeDisposable.add(r4);
        return;
    L11:
        r3 = AndroidSchedulers.mainThread();
        goto L12
    L7:
        r1 = false;
        goto L8
    }

    public final <T> AutoDisposeConverter<T> autoDispose() {
        return AutoDispose.bind(this);
    }

    public void onDestroy() {
        super.onDestroy();     // Catch: Exception -> L4
    L6:
        CompositeDisposable r0 = this.compositeDisposable;
        if (r0 == null) goto L10;
        r0.dispose();
    L10:
        if (getLoadedEnvironment() == AbsMergeWidget.MergeWidgetEnvironment.PREVIEW) goto L12;
        ((Widget) this).subWidgetManager = null;
        this.extraInfo = null;
    L12:
        Animator r1 = this.showAnimator;
        if (r1 != null) goto L15;
    L18:
        f r2 = this.widgetLifeCycleObserver;
        if (r2 == null) goto L26;
        List<? extends e80.a> r3 = r2.a;
        if (r3 == null) goto L26;
        Iterator<T> r4 = r3.iterator();
    L24:
        if (r4.hasNext() == false) goto L26;
        ((e80.a) r4.next()).onDestroy(r2.b);
    L26:
        this.widgetLifeCycleObserver = null;
        this.previewStatus = PreviewState.DESTORYED;
        if (getLoadedEnvironment() != AbsMergeWidget.MergeWidgetEnvironment.PREVIEW) goto L29;
        return;
    L29:
        if (((LiveMemLeakConfig) j1.a.getValue()).getFixWidgetCallback() == false) goto L36;
        setWidgetCallback(x.a);
        return;
    L36:
        return;
    L15:
        if (r1.isRunning() == false) goto L17;
        this.showAnimator.cancel();
    L17:
        this.showAnimator.removeAllListeners();
        this.showAnimator = null;
    L4:
        e = move-exception;
        ALogger.e(TAG, e);
        goto L6
    }

    public void onMergeLoad() {
        super.onMergeLoad();
        this.previewStatus = PreviewState.LOADED;
    }

    public void onMergeUnLoad() {
        super.onMergeUnLoad();
        this.previewStatus = PreviewState.UNLOAD;
        if (getLoadedEnvironment() != AbsMergeWidget.MergeWidgetEnvironment.PREVIEW) goto L8;
        ((Widget) this).subWidgetManager = null;
        this.extraInfo = null;
        if (((LiveMemLeakConfig) j1.a.getValue()).getFixWidgetCallback() == false) goto L9;
        setWidgetCallback(x.a);
        return;
    L9:
        return;
    }

    public void onPause() {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onPause();     // Catch: Exception -> L4
    L6:
        f r0 = this.widgetLifeCycleObserver;
        if (r0 == null) goto L14;
        List<? extends e80.a> r1 = r0.a;
        if (r1 == null) goto L14;
        Iterator<T> r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        ((e80.a) r2.next()).i(r0.b);
    L14:
        this.previewStatus = PreviewState.PAUSEED;
        return;
    L4:
        e = move-exception;
        ALogger.e(TAG, e);
        goto L6
    }

    public void onResume() {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onResume();     // Catch: Exception -> L4
    L6:
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onResume();
        f r0 = this.widgetLifeCycleObserver;
        if (r0 == null) goto L20;
        List<? extends e80.a> r1 = r0.a;
        if (r1 == null) goto L14;
        Iterator<T> r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        ((e80.a) r2.next()).b(r0.b);
    L14:
        Widget r3 = r0.b;
        if (r3 == null) goto L17;
        DataCenter r4 = r3.dataCenter;
    L18:
        if (r4 != null) goto L20;
        f.a("onResume");
        goto L20
    L17:
        r4 = null;
    L20:
        this.previewStatus = PreviewState.RESUMED;
        return;
    L4:
        e = move-exception;
        ALogger.e(TAG, e);
        goto L6
    }

    public void onStart() {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onStart();     // Catch: Exception -> L4
    L6:
        f r0 = this.widgetLifeCycleObserver;
        if (r0 == null) goto L14;
        List<? extends e80.a> r1 = r0.a;
        if (r1 == null) goto L14;
        Iterator<T> r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        ((e80.a) r2.next()).e(r0.b);
    L14:
        this.previewStatus = PreviewState.STARTED;
        return;
    L4:
        e = move-exception;
        ALogger.e(TAG, e);
        goto L6
    }

    public void onStop() {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onStop();     // Catch: Exception -> L4
    L6:
        f r0 = this.widgetLifeCycleObserver;
        if (r0 == null) goto L14;
        List<? extends e80.a> r1 = r0.a;
        if (r1 == null) goto L14;
        Iterator<T> r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        ((e80.a) r2.next()).c(r0.b);
    L14:
        this.previewStatus = PreviewState.STOPED;
        return;
    L4:
        e = move-exception;
        ALogger.e(TAG, e);
        goto L6
    }

    public final <T> CommonLifecycleTransformer<T> getAutoUnbindTransformer() {
        return this.lifecycleTransformer;
    }

    public Context getContext() {
        return ((Widget) this).context;
    }

    public DataCenter getDataCenter() {
        return ((Widget) this).dataCenter;
    }

    public Map<String, String> getExtraInfo() {
        return this.extraInfo;
    }

    public final <T extends View> T findViewById(int r2) {
        return (T) ((Widget) this).contentView.findViewById(r2);
    }

    public void handleLifeEvent(com.bytedance.livesdk.preview.event.b r3) {
        ALogger.i(TAG, "event: " + r3 + " previewStatus = " + this.previewStatus.name());
        PreviewState r0 = this.previewStatus;
        if (r0 != PreviewState.UNLOAD) goto L6;
        return;
    L6:
        if ((r3 instanceof com.bytedance.livesdk.preview.event.b.g) == false) goto L11;
        if (r0 == PreviewState.LOADED) goto L11;
        onDestroy();
    L11:
        if (((AbsMergeWidget) this).mergeContext.getViewHolderStatus() != PreviewViewHolderStatus.UN_BIND) goto L14;
        return;
    L14:
        if ((r3 instanceof com.bytedance.livesdk.preview.event.b.a) == false) goto L17;
        onCreate();
        return;
    L17:
        if ((r3 instanceof com.bytedance.livesdk.preview.event.b.f) == false) goto L20;
        onMergeHolderSelect();
        doMergeResume();
        return;
    L20:
        if ((r3 instanceof com.bytedance.livesdk.preview.event.b.e) == false) goto L23;
        doMergeResume();
        return;
    L23:
        if ((r3 instanceof com.bytedance.livesdk.preview.event.b.c) == false) goto L29;
        doMergePause();
        return;
    }

    public void onEnterClear(int r6) {
        f r1 = this.widgetLifeCycleObserver;
        if (r1 == null) goto L19;
        List<? extends e80.a> r2 = r1.a;
        if (r2 == null) goto L17;
        Iterator<T> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L17;
        ((e80.a) r3.next()).k(r1.b);
    L17:
    L14:
        e = move-exception;
        ALogger.e("IClearScreen", "onEnterClear:" + e);
        return;
    L11:
        if (this.widgetLifeCycleObserver.b == null) goto L20;
        ALogger.i("IClearScreen", this.widgetLifeCycleObserver.b.getWidgetTag() + "_onEnterClear_" + r6);     // Catch: NullPointerException -> L14
        return;
    L20:
        return;
    }

    public void onExitClear(int r6) {
        f r1 = this.widgetLifeCycleObserver;
        if (r1 == null) goto L19;
        List<? extends e80.a> r2 = r1.a;
        if (r2 == null) goto L17;
        Iterator<T> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L17;
        ((e80.a) r3.next()).f(r1.b);
    L17:
    L14:
        e = move-exception;
        ALogger.e("IClearScreen", "onExitClear:" + e);
        return;
    L11:
        if (this.widgetLifeCycleObserver.b == null) goto L20;
        ALogger.i("IClearScreen", this.widgetLifeCycleObserver.b.getWidgetTag() + "_onExitClear_" + r6);     // Catch: NullPointerException -> L14
        return;
    L20:
        return;
    }

    @Override // z70.a
    public void setExtraInfo(Map<String, String> r3) {
        Map<String, String> r0 = this.extraInfo;
        if (r0 != null) goto L5;
        this.extraInfo = r3;
    L6:
        HashMap<String, String> r4 = j70.p.a;
        Map<String, String> r5 = this.extraInfo;
        Intrinsics.checkNotNullParameter(this, "widget");
        if (((FirstScreenOptConfig) aw.a.getValue()).getRecord_widget() == false) goto L14;
        if (r5 == null) goto L10;
        String r6 = r5.get("widget_level");
    L11:
        if (r6 == null) goto L15;
        String r1 = getClass().getSimpleName();
        String r7 = j70.p.a.put(r1, r6);
        return;
    L15:
        return;
    L10:
        r6 = null;
        goto L11
    L14:
        return;
    L5:
        r0.putAll(r3);
        goto L6
    }
}
