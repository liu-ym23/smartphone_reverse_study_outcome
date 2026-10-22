package vg8;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larus.bmhome.chat.ChatBubbleParams;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.widget.handler.w;
import com.larus.bmhome.chat.list.cell.text.markdown.MarkwonStructReuseUtil$removeForsetiMarkwonStructCacheOnDestroy$1;
import com.larus.business.markdown.impl.markwon.MarkwonStruct;
import com.larus.common.apphost.AppHost;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o {
    public static final o a = null;
    public static final vg8.a<LruCache<String, Pair<MarkwonStruct, MarkwonStruct>>> b = null;
    public static final WeakHashMap<Fragment, LruCache<String, Pair<MarkwonStruct, MarkwonStruct>>> c = null;
    public static final Lazy d = null;

    public static final class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r1, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
            vg8.a<LruCache<String, Pair<MarkwonStruct, MarkwonStruct>>> r2 = o.b;     // Catch: Throwable -> L5
            r2.getClass();     // Catch: Throwable -> L5
            Intrinsics.checkNotNullParameter(r3, "activity");     // Catch: Throwable -> L5
            r2.a.remove(r3);     // Catch: Throwable -> L5
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Result.Companion r0 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public o() {
    }

    static {
        a = new o();
        AppHost.a.getApplication().registerActivityLifecycleCallbacks(new a());
        b = new vg8.a();
        c = new WeakHashMap();
        d = LazyKt.lazy(new n());
    }

    private final Activity getActivity(Context r2) {
    L3:
        if ((r2 instanceof ContextWrapper) == false) goto L9;
        if ((r2 instanceof Activity) == true) goto L7;
        r2 = ((ContextWrapper) r2).getBaseContext();
        goto L3
    L7:
        return (Activity) r2;
    L9:
        return null;
    }

    public final MarkwonStruct a(Context r9, fh8.l r10, lw8.d r11, int r12, String r13, fh8.f r14) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "markdownRenderConfig");
        Intrinsics.checkNotNullParameter(r11, "customMarkDownInfo");
        Intrinsics.checkNotNullParameter(r14, "commonInputData");
        if (r13 != null) goto L5;
        return null;
    L5:
        w.a.getClass();
        Map r1 = w.a(r14);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        q0 r15 = r14.q;     // Catch: Throwable -> L14
        if (r15 == null) goto L11;
        Function0<Fragment> r16 = r15.getHostFragment();     // Catch: Throwable -> L14
        if (r16 == null) goto L11;
        Fragment r17 = (Fragment) r16.invoke();     // Catch: Throwable -> L14
    L12:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r18) == false) goto L19;
        r18 = null;
    L19:
        final xe8.a r19 = (Fragment) r18;
        if (r19 != null) goto L23;
    L35:
        r19 = null;
    L37:
        if (r19 != null) goto L94;
        Activity r110 = getActivity(r9);
        if (r110 != null) goto L59;
        return null;
    L59:
        vg8.a<LruCache<String, Pair<MarkwonStruct, MarkwonStruct>>> r4 = b;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r110, "activity");
        LruCache<String, Pair<MarkwonStruct, MarkwonStruct>> r6 = r4.a.get(r110);
        if (r6 != null) goto L62;
        r6 = new LruCache(5);
        Intrinsics.checkNotNullParameter(r110, "activity");
        r4.a.put(r110, r6);
    L62:
        LruCache<String, Pair<MarkwonStruct, MarkwonStruct>> r111 = r6;
        String r112 = "source:" + r13 + "-width:" + r12;
        Pair r3 = (Pair) r111.get(r112);
        boolean r113 = !r10.b;
        if (r113 == false) goto L68;
        if (r3 == null) goto L66;
        MarkwonStruct r5 = (MarkwonStruct) r3.getSecond();
    L67:
        if (r5 != null) goto L68;
    L73:
        gw8.c r7 = (gw8.c) d.getValue();
        if (r7 == null) goto L76;
        lw8.h r20 = r7.createCacheMarkwonStruct(r9, Integer.valueOf(r12), r11, r1, r113);
    L78:
        if ((r20 instanceof MarkwonStruct) == false) goto L80;
        MarkwonStruct r21 = (MarkwonStruct) r20;
    L81:
        if (r113 == false) goto L83;
        Pair r114 = new Pair(null, r21);
    L84:
        r3 = r114;
        r111.put(r112, r3);
    L85:
        if (r113 == false) goto L88;
        if (r3 == null) goto L90;
        MarkwonStruct r22 = (MarkwonStruct) r3.getSecond();
    L91:
        if (r22 == null) goto L98;
        r22.f = r1;
        r22.e = Integer.valueOf(r12);
        return r22;
    L98:
        return null;
    L90:
        r22 = null;
        goto L91
    L88:
        if (r3 == null) goto L90;
        r22 = (MarkwonStruct) r3.getFirst();
        goto L91
    L83:
        r114 = new Pair(r21, null);
        goto L84
    L80:
        r21 = null;
        goto L81
    L76:
        r20 = null;
        goto L78
    L66:
        r5 = null;
    L68:
        if (r113 == true) goto L85;
        if (r3 == null) goto L71;
        MarkwonStruct r8 = (MarkwonStruct) r3.getFirst();
    L72:
        if (r8 != null) goto L85;
    L71:
        r8 = null;
        goto L72
    L94:
        Object r23 = Result.constructor-impl(r19.getViewLifecycleOwner());     // Catch: Throwable -> L40
    L43:
        if (Result.isFailure-impl(r23) == false) goto L45;
        r23 = null;
    L45:
        LifecycleOwner r24 = (LifecycleOwner) r23;
        if (r24 != null) goto L49;
    L50:
        r6 = null;
    L54:
        if (r6 != null) goto L62;
        return null;
    L49:
        if (r24.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L50;
        WeakHashMap<Fragment, LruCache<String, Pair<MarkwonStruct, MarkwonStruct>>> r25 = c;
        r6 = r25.get(r19);
        if (r6 != null) goto L54;
        r6 = new LruCache(5);
        r25.put(r19, r6);
        r24.getLifecycle().addObserver(new MarkwonStructReuseUtil$removeForsetiMarkwonStructCacheOnDestroy$1(r19));
    L40:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L43
    L23:
        if ((r19 instanceof xe8.a) == false) goto L25;
        xe8.a r27 = r19;
    L26:
        if (r27 == null) goto L32;
        ChatBubbleParams r28 = r27.Mz();
        if (r28 == null) goto L32;
        if (r28.b != true) goto L32;
        boolean r29 = true;
    L33:
        if (r29 == false) goto L35;
    L32:
        r29 = false;
        goto L33
    L25:
        r27 = null;
    L11:
        r17 = null;
    L14:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
