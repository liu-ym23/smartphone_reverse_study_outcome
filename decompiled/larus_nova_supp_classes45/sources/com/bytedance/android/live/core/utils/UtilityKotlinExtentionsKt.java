package com.bytedance.android.live.core.utils;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class UtilityKotlinExtentionsKt {
    public static final Handler a = null;

    public static final class a<T> implements ObservableOnSubscribe {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ r b;

        public a(Function1 r1, r r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(ObservableEmitter<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            this.a.invoke(this.b);
        }
    }

    public final class b implements Runnable {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        a = new Handler(Looper.getMainLooper());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.ActivityThread");
    }

    private static final Context getContext() {
        Context r0 = TTMiddlewareLiveSDK.getContext();
        if (r0 != null) goto L12;
        r0 = null;
        Object r1 = a().getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L13
        if ((r1 instanceof Application) == true) goto L8;
        r1 = null;
    L8:
        r0 = (Application) r1;     // Catch: Throwable -> L13
    L10:
        Intrinsics.checkNotNull(r0);
    L12:
        return r0.getApplicationContext();
    }

    public static void f(View r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$fadeWhenTouch");
        r4.setOnTouchListener(new l2(r4, 0.5f, 200));
    }

    public static final Sequence<View> g(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$children");
        return SequencesKt.sequence(new UtilityKotlinExtentionsKt$children$1(r2, null));
    }

    public static final float h(float r2) {
        Resources r0 = getContext().getResources();
        return (WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density * r2) + 0.5f;
    }

    public static final int i(int r0) {
        return (int) h(r0);
    }

    public static final float j(float r2) {
        Resources r0 = getContext().getResources();
        return (r2 / WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f;
    }

    public static final int k(int r0) {
        return (int) j(r0);
    }

    public static final List<Pair<String, String>> l(Uri r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$getQueriesList");
        Set r0 = UriProtector.getQueryParameterNames(r4);
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        String r3 = (String) r2.next();
        String r5 = UriProtector.getQueryParameter(r4, r3);
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        r1.add(TuplesKt.to(r3, r5));
        goto L4
    L9:
        return r1;
    }

    public static final float m(float r2) {
        Resources r0 = getContext().getResources();
        return TypedValue.applyDimension(2, r2, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    public static final boolean n(py.k r2) {
        if (r2 == null) goto L14;
        List<String> r3 = r2.getUrls();
        if (r3 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == true) goto L14;
        return false;
    L7:
        if (r3.isEmpty() == true) goto L10;
        r4 = false;
    L14:
        return true;
    }

    public static final <V> JSONObject o(Pair<String, ? extends V>... r5) {
        Intrinsics.checkNotNullParameter(r5, "pairs");
        JSONObject r0 = new JSONObject();
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        Pair<String, ? extends V> r3 = r5[r2];
        r0.put((String) r3.getFirst(), r3.getSecond());
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public static final ViewGroup p(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$parentView");
        ViewParent r2 = r1.getParent();
        if ((r2 instanceof ViewGroup) == true) goto L6;
        r2 = null;
    L6:
        return (ViewGroup) r2;
    }

    public static final void q(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$removeFromParent");
        ViewGroup r0 = p(r1);
        if (r0 == null) goto L6;
        r0.removeView(r1);
        Unit r2 = Unit.INSTANCE;
        return;
    }

    public static final void t(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$setVisibilityGone");
        UIUtils.setViewVisibility(r1, 8);
    }

    public static final void u(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$setVisibilityInVisible");
        UIUtils.setViewVisibility(r1, 4);
    }

    public static final void w(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$setVisibilityVisible");
        UIUtils.setViewVisibility(r1, 0);
    }

    public static final void x(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$setVisibilityVisibleAlpha");
        r1.setAlpha(1.0f);
    }

    public static Function0 y(final Function0 r4) {
        Intrinsics.checkNotNullParameter(r4, "block");
        final Ref.LongRef r0 = new Ref.LongRef();
        r0.element = 0;
        final long r2 = 500;
        return new UtilityKotlinExtentionsKt$throttle$1(r2, r0, r4);
    }

    public static final void A(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$visibleOrInvisible");
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 4;
        goto L6
    }

    public static final <T> void b(T r2, Function1<? super r<T>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "task");
        Observable.create(new a(r3, new r(new WeakReference(r2)))).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe();
    }

    public static final void d(View r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$fadeIn");
        w(r1);
        r1.animate().alpha(1.0f).setDuration(r2).start();
    }

    public static final void e(View r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$fadeOut");
        r2.animate().alpha(0.0f).setDuration(r3).withEndAction(new k2(r2)).start();
    }

    public static final void v(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$setVisibilitySimple");
        if (r2 == false) goto L5;
        UIUtils.setViewVisibility(r1, 0);
        return;
    L5:
        UIUtils.setViewVisibility(r1, 8);
    }

    public static final void z(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$visibleOrGone");
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public static final void c(Collection r1, ToolbarButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$ensureItemExistence");
        if (r1.contains(r2) == true) goto L6;
        if (r3 == false) goto L6;
        r1.add(r2);
        return;
    L6:
        if (r3 == true) goto L10;
        r1.remove(r2);
        return;
    }

    public static final void r(long r3, boolean r5, boolean r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r7, "action");
        if (r3 <= 0) goto L5;
        a.postDelayed(new b(r7), r3);
        return;
    L5:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L8;
        if (r6 == true) goto L8;
        r7.invoke();
        return;
    L8:
        if (r5 == false) goto L10;
        a.postAtTime(new b(r7), 2);
        return;
    L10:
        a.post(new b(r7));
    }

    public static /* synthetic */ void s(long r2, boolean r4, boolean r5, Function0 r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = false;
    L9:
        if ((r7 & 4) == 0) goto L11;
        r5 = false;
    L11:
        r(r2, r4, r5, r6);
    }
}
