package com.bytedance.android.live.core.tetris.widgets;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.componentx.utils.ObservableLifecycleDelegate;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livesdk.config.i91;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentManagerABHelper;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMemLeakConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.ies.sdk.widgets.perf.WidgetPerfManager;
import com.bytedance.ies.sdk.widgets.priority.GroupSchedule;
import com.bytedance.livesdk.preview.merge.AbsMergeWidget;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class RecyclableWidgetManager extends WidgetManager implements com.bytedance.livesdk.preview.merge.a {
    public static final a j = null;
    public c d;
    public e80.b e;
    public x70.b f;
    public final z g;
    public boolean h;
    public ObservableLifecycleDelegate i;

    public class a implements c {
        public a() {
        }

        @Override // com.bytedance.android.live.core.tetris.widgets.c
        public final <T extends com.bytedance.android.live.core.tetris.widgets.a> T a(Class<T> r2) {
            return r2.newInstance();
        L7:
            e = move-exception;
            throw new RuntimeException(e);
        L4:
            e = move-exception;
            throw new RuntimeException(e);
        }
    }

    static {
        j = new a();
    }

    public final void C60() {
        if ((this.d instanceof h) == true) goto L5;
        return;
    L5:
        Iterator r0 = ((WidgetManager) this).widgets.iterator();
    L7:
        if (r0.hasNext() == false) goto L21;
        LiveRecyclableWidget r1 = (Widget) r0.next();
        if ((r1 instanceof LiveRecyclableWidget) == false) goto L7;
        LiveRecyclableWidget r2 = r1;
        if (r2.isRecyclableOnRotation() == true) goto L7;
        h r3 = (h) this.d;
        Class<?> r4 = r2.getClass();
        if (r3.c == false) goto L18;
        WeakReference<com.bytedance.android.live.core.tetris.widgets.a> r5 = r3.b.remove(r4);
        if (r5 == null) goto L17;
        com.bytedance.android.live.core.tetris.widgets.a r6 = r5.get();
    L19:
        if (r6 == null) goto L7;
        r6.clearAfterDestroyed();
        goto L7
    L17:
        r6 = null;
        goto L19
    L18:
        r6 = r3.a.remove(r4);
        goto L19
    }

    public final WidgetManager createSubWidgetManager() {
        RecyclableWidgetManager r0 = ga0(this, ((WidgetManager) this).contentView);
        r0.setDataCenter(((WidgetManager) this).dataCenter);
        r0.setWidgetConfigHandler(((WidgetManager) this).widgetConfigHandler);
        r0.ia0(this.e);
        r0.d = h.c();
        r0.f = this.f;
        return r0;
    }

    public final Lifecycle getLifecycle() {
        if (ComponentManagerABHelper.INSTANCE.enableWidgetManagerLifecycleDelegate() == false) goto L10;
        if (this.i != null) goto L8;
        this.i = new ObservableLifecycleDelegate(super/*androidx.fragment.app.Fragment*/.getLifecycle());
    L8:
        return this.i;
    L10:
        return super/*androidx.fragment.app.Fragment*/.getLifecycle();
    }

    public final void onDestroy() {
        if (this.h == false) goto L5;
    L6:
        Fragment r0 = ((WidgetManager) this).parentFragment;
        if (r0 != null) goto L9;
    L11:
        super.onDestroy();
        return;
    L9:
        if (r0.getFragmentManager() == null) goto L11;
        ((WidgetManager) this).parentFragment.getFragmentManager().unregisterFragmentLifecycleCallbacks(((WidgetManager) this).parentDestroyedCallback);
        goto L11
    L5:
        if (((LiveMemLeakConfig) j1.a.getValue()).getOpenFixV1() == false) goto L11;
        goto L6
    }

    public RecyclableWidgetManager() {
        this.d = j;
        this.e = null;
        this.f = null;
        this.g = new z();
        this.h = false;
    }

    public static void V90(Widget r1) {
        if ((r1 instanceof AbsMergeWidget) == false) goto L6;
        ((AbsMergeWidget) r1).setLoadedEnvironment(AbsMergeWidget.MergeWidgetEnvironment.LIVE);
        return;
    }

    public final void ME(AbsMergeWidget r1) {
        unload(r1);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final <T extends com.bytedance.android.live.core.tetris.widgets.a> T W90(Class<T> r4) {
        DataCenter r0 = ((WidgetManager) this).dataCenter;
        if (r0 == null) goto L12;
        IRoom r1 = (IRoom) r0.get("data_room");
        if (MultiRoomConfig.INSTANCE.enableComponentCache(r1, ((WidgetManager) this).dataCenter) == false) goto L12;
        String r2 = (String) ((WidgetManager) this).dataCenter.get("data_room_unique_id", null);
        if (TextUtils.isEmpty(r2) == true) goto L10;
        com.bytedance.android.live.core.tetris.widgets.cache.c r3 = com.bytedance.android.live.core.tetris.widgets.cache.c.g.a();
        Class<? extends U> r5 = r4.asSubclass(LiveRecyclableWidget.class);
        Intrinsics.checkNotNullParameter(r2, "uniqueID");
        Intrinsics.checkNotNullParameter(r5, "clazz");
        return (T) r3.e.a(r3, r2, r5);
    L10:
        ALogger.i(WidgetManager.TAG, "enableComponentCache = true, uniqueID isEmpty");
    L12:
        return (T) this.d.a(r4);
    }

    public final void continueLoad(Widget r2) {
        super.continueLoad(r2);
        e80.b r0 = this.e;
        if (r0 == null) goto L6;
        r0.h(r2);
        return;
    }

    public final <T extends com.bytedance.android.live.core.tetris.widgets.a> T eW(Class<T> r2) {
        if (LiveRecyclableWidget.class.isAssignableFrom(r2) == false) goto L7;
        LiveRecyclableWidget r3 = (LiveRecyclableWidget) this.d.a(r2);
        r3.setMergeWidgetManager(this);
        return r3;
    L7:
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L11;
        return null;
    L11:
        throw new RuntimeException("loadMergeWidget  classType error in RecyclableWidgetManager");
    }

    public final void fW(AbsMergeWidget r1) {
        if (r1 == null) goto L5;
        r1.setMergeWidgetManager(this);
        V90(r1);
        load(r1);
        return;
    }

    public final void ia0(e80.b r3) {
        if (r3 == null) goto L14;
        boolean r1 = false;
        if (g.a() == false) goto L11;
        i91 r0 = g.c();
        if (r0 == null) goto L8;
        boolean r2 = r0.g();
    L9:
        if (r2 == false) goto L11;
        r1 = true;
        goto L11
    L8:
        r2 = false;
    L11:
        if (r1 == false) goto L15;
        this.e = r3;
        return;
    L15:
        return;
    }

    public final void mayInsertHandlerQueue(Runnable r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (k60.b.c() == false) goto L7;
        i0.d(r2);
        return;
    L7:
        i0.i(c50.b.b(((WidgetManager) this).dataCenter), r2);
    }

    public final void mayInsertHighPriorityHandlerQueue(Runnable r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (k60.b.c() == false) goto L7;
        i0.f(r2);
        return;
    L7:
        i0.i(c50.b.b(((WidgetManager) this).dataCenter), r2);
    }

    public final void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        C60();
    }

    public final void onLoadByAsync(Widget r3) {
        if ((r3 instanceof LiveRecyclableWidget) == false) goto L5;
        ((LiveRecyclableWidget) r3).setIsAsyncLoading(Boolean.TRUE);
    L5:
        z r0 = this.g;
        if (r0.b != null) goto L9;
        r0.a.add(r3);
        return;
    }

    public final void onLoadSuccessByAsync(Widget r3) {
        if ((r3 instanceof LiveRecyclableWidget) == false) goto L5;
        ((LiveRecyclableWidget) r3).setIsAsyncLoading(Boolean.FALSE);
    L5:
        z r0 = this.g;
        r0.a.remove(r3);
        if (r0.a.isEmpty() == false) goto L11;
        Runnable r4 = r0.b;
        if (r4 == null) goto L12;
        r4.run();
        r0.b = null;
        return;
    L12:
        return;
    }

    public static RecyclableWidgetManager ga0(Fragment r7, View r8) {
        RecyclableWidgetManager r6 = new RecyclableWidgetManager();
        r6.config(null, r7, r8, r7.getContext(), k60.b.e());
        return r6;
    }

    public static RecyclableWidgetManager ha0(FragmentActivity r7, View r8) {
        RecyclableWidgetManager r6 = new RecyclableWidgetManager();
        r6.config(r7, null, r8, r7, k60.b.e());
        return r6;
    }

    public final <T extends LiveRecyclableWidget> T X90(int r3, Class<T> r4) {
        return (T) Y90(r3, r4, true, null);
    }

    public final void ca0(int r3, Class r4) {
        Y90(r3, r4, false, null);
    }

    public final LiveRecyclableWidget aa0(Class r2, boolean r3, boolean r4) {
        ViewGroup r5 = (ViewGroup) ((WidgetManager) this).contentView.findViewById(2131364575);
        LiveRecyclableWidget r6 = (LiveRecyclableWidget) W90(r2);
        fa0(r5, r6, r3, null);
        return r6;
    }

    public void continueLoad(Widget r5, ViewGroup r6, View r7) {
        if (r5.containerView != null) goto L8;
        e80.b r8 = this.e;
        if (r8 == null) goto L22;
        r8.h(r5);
        return;
    L22:
        return;
    L8:
        if (r7 == null) goto L20;
        UIUtils.detachFromParent(r7);
    L20:
        super.continueLoad(r5, r6, r7);     // Catch: IllegalStateException -> L14
        e80.b r0 = this.e;     // Catch: IllegalStateException -> L14
        if (r0 == null) goto L23;
        r0.h(r5);     // Catch: IllegalStateException -> L14
        return;
    L23:
        return;
    L14:
        e = move-exception;
        StringBuilder r1 = new StringBuilder("contentView: ");
        r1.append(r7);
        r1.append('\n');
        if (r7 == null) goto L18;
        r1.append("real parent: ");
        r1.append(r7.getParent());
        r1.append('\n');
    L18:
        r1.append("target parent: ");
        r1.append(r6);
        r1.append("\nwidget: ");
        r1.append(r5.getClass().getName());
        throw new IllegalStateException(r1.toString(), e);
    }

    public final <T extends LiveRecyclableWidget> T ea0(Class<T> r3, boolean r4, boolean r5) {
        T r6 = (T) W90(r3);
        ALogger.i("【widget】", "load widget:" + r6.getClass().getCanonicalName() + "@" + r6.hashCode() + ", async: " + r4);
        r6.setWidgetCallback(((WidgetManager) this).widgetCallback);
        ((Widget) r6).context = ((WidgetManager) this).context;
        ((Widget) r6).dataCenter = ((WidgetManager) this).dataCenter;
        r6.setStatusAsync(r4);
        r6.setStatusRecycle(true);
        r6.setStatusHasUI(false);
        WidgetPerfManager.getInstance().onPerfStart(r6, "onLoad");
        WidgetManager.IWidgetConfigHandler r0 = ((WidgetManager) this).widgetConfigHandler;
        if (r0 == null) goto L5;
        r0.onLoad(r6);
    L5:
        GroupSchedule.getInstance().enqueueLoad(r6, new l(this, r6, r4, r5));
        return r6;
    }

    public final WidgetManager load(ViewGroup r2, Widget r3, boolean r4) {
        if ((r3 instanceof LiveRecyclableWidget) == false) goto L5;
        fa0(r2, (LiveRecyclableWidget) r3, r4, null);
    L9:
        return this;
    L5:
        e80.b r0 = this.e;
        if (r0 == null) goto L8;
        r0.d(r3);
    L8:
        V90(r3);
        super.load(r2, r3, r4);
        goto L9
    }

    public final WidgetManager load(int r2, Widget r3, boolean r4) {
        return load((ViewGroup) ((WidgetManager) this).contentView.findViewById(r2), r3, r4);
    }

    public static void U90(RecyclableWidgetManager r3, LiveRecyclableWidget r4, ViewGroup r5, View r6) {
        r3.getClass();
        WidgetPerfManager.getInstance().onPerfEnd(r4, "inflate");
        r3.onLoadSuccessByAsync(r4);
        if (r3.isRemoving() == false) goto L5;
        return;
    L5:
        if (r3.isDetached() == false) goto L7;
        return;
    L7:
        if (r3.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L9;
        return;
    L9:
        if (((Widget) r4).widgetCallback == ((WidgetManager) r3).widgetCallback) goto L11;
        ALogger.i("RecyclableWidgetManager", "abort load, opt: true");
        return;
    L11:
        if (r3.isAdded() == false) goto L13;
        r3.continueLoad(r4, r5, r6);
        return;
    L13:
        ALogger.i("RecyclableWidgetManager", "fragment is not add, so intercept");
    }

    public final <T extends LiveRecyclableWidget> T Y90(int r2, Class<T> r3, boolean r4, Object[] r5) {
        return (T) Z90((ViewGroup) ((WidgetManager) this).contentView.findViewById(r2), r3, r4, r5);
    }

    public final <T extends LiveRecyclableWidget> T Z90(ViewGroup r4, Class<T> r5, boolean r6, Object[] r7) {
        DataCenter r0 = ((WidgetManager) this).dataCenter;
        if (r0 == null) goto L7;
        IRoom r1 = (IRoom) r0.get("data_room");
        if (MultiRoomConfig.INSTANCE.enableComponentCache(r1, ((WidgetManager) this).dataCenter) == false) goto L7;
        T r8 = (T) W90(r5);
        fa0(r4, r8, r6, r7);
        return r8;
    L7:
        T r9 = (T) this.d.a(r5);
        fa0(r4, r9, r6, r7);
        return r9;
    }

    public final void ba0(int r2, Widget r3, boolean r4, boolean r5) {
        da0((ViewGroup) ((WidgetManager) this).contentView.findViewById(r2), r3, r4, r5);
    }

    public final void da0(ViewGroup r1, Widget r2, boolean r3, boolean r4) {
        if ((r2 instanceof LiveRecyclableWidget) == false) goto L5;
        fa0(r1, (LiveRecyclableWidget) r2, r3, null);
        return;
    L5:
        e80.b r5 = this.e;
        if (r5 == null) goto L8;
        r5.d(r2);
    L8:
        V90(r2);
        super.load(r1, r2, r3);
    }

    public final void fa0(ViewGroup r3, LiveRecyclableWidget r4, boolean r5, Object[] r6) {
        System.nanoTime();
        r4.getClass();
        ALogger.i("【widget】", "load widget:" + r4.getClass().getCanonicalName() + "@" + r4.hashCode() + ", async: " + r5);
        r4.setArgs(r6);
        r4.setWidgetCallback(((WidgetManager) this).widgetCallback);
        ((Widget) r4).context = ((WidgetManager) this).context;
        ((Widget) r4).dataCenter = ((WidgetManager) this).dataCenter;
        ((Widget) r4).containerView = r3;
        boolean r7 = false;
        r4.setMergeMode(false);
        r4.setStatusAsync(r5);
        r4.setStatusRecycle(true);
        if (r4.getLayoutId() == 0) goto L5;
        r7 = true;
    L5:
        r4.setStatusHasUI(r7);
        V90(r4);
        WidgetPerfManager.getInstance().onPerfStart(r4, "onLoad");
        WidgetManager.IWidgetConfigHandler r8 = ((WidgetManager) this).widgetConfigHandler;
        if (r8 == null) goto L8;
        r8.onLoad(r4);
    L8:
        ((WidgetManager) this).widgetViewGroupHashMap.put(r4, r3);
        GroupSchedule.getInstance().enqueueLoad(r4, new p(this, r3, r4, r5));
    }

    public final void li(ViewGroup r1, AbsMergeWidget r2, boolean r3, boolean r4) {
        if (r2 == null) goto L5;
        r2.setMergeWidgetManager(this);
    L5:
        if ((r2 instanceof LiveRecyclableWidget) == false) goto L7;
        fa0(r1, (LiveRecyclableWidget) r2, r3, null);
        return;
    L7:
        e80.b r5 = this.e;
        if (r5 == null) goto L10;
        r5.d(r2);
    L10:
        V90(r2);
        super.load(r1, r2, r3);
    }

    public final AbsMergeWidget Gq(ViewGroup r1, LiveRecyclableWidget r2, boolean r3, boolean r4, Object[] r5) {
        fa0(r1, r2, r3, r5);
        return r2;
    }
}
