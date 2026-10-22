package com.bytedance.android.live.core.tetris.template.loader;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.core.tetris.componentx.utils.ObservableLifecycleRegistry;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import h70.b;
import j70.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k70.c;
import k70.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import z70.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005J\b\u0010\u0007\u001a\u00020\u0006H\u0017J\b\u0010\b\u001a\u00020\u0006H\u0017J\b\u0010\t\u001a\u00020\u0006H\u0017J\b\u0010\n\u001a\u00020\u0006H\u0017J\b\u0010\u000b\u001a\u00020\u0006H\u0017J\b\u0010\f\u001a\u00020\u0006H\u0017¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/core/tetris/template/loader/TemplateLoader;", "Lh70/b;", "T", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/LifecycleObserver;", "Lz70/a;", "", "onCreate", "onStart", "onResume", "onPause", "onStop", "onDestroy", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class TemplateLoader<T extends b> implements LifecycleOwnerCompat, LifecycleObserver, a {
    public final List<Element<?>> a;
    public c b;
    public T c;
    public d d;
    public final ObservableLifecycleRegistry e;
    public ConstraintLayout f;
    public Map<String, String> g;
    public com.bytedance.android.live.core.tetris.componentx.component.b h;
    public final j70.c i;

    public abstract a80.a<T> a(T r1);

    public abstract String b(T r1);

    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        this.e.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        T r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L5:
        a80.a<T> r1 = a(r0);
        if (r1 == null) goto L123;
        T r3 = this.c;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L10:
        z70.b r4 = r3.a;
        if (r4 == null) goto L17;
        T r5 = this.c;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L16:
        if (r4.j(r1.o(r5).b) == false) goto L123;
    L17:
        T r6 = this.c;
        if (r6 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L21:
        if (r1.d(r6) == false) goto L123;
        ConstraintLayout r7 = this.f;
        if (r7 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L26:
        Intrinsics.checkNotNullParameter(r1, "config");
        Intrinsics.checkNotNullParameter(r7, "rootView");
        r7.removeAllViews();
        c r8 = this.b;
        if (r8 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("elementFactory");
    L29:
        T r9 = this.c;
        if (r9 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L32:
        Element<?> r11 = r8.a(r1.o(r9), r1.p());
        j70.c r12 = this.i;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r11.e = r12;
        com.bytedance.android.live.core.tetris.componentx.component.b r13 = this.h;
        if (r13 == null) goto L35;
        r13.a(r11);
    L35:
        ((ArrayList) this.a).add(r11);
        Map<String, String> r14 = r1.a;
        if (r14 == null) goto L41;
        Map<String, String> r15 = r11.g;
        if (r15 != null) goto L40;
        r15 = new LinkedHashMap();
    L40:
        r15.putAll(r14);
        r11.setExtraInfo(r15);
    L41:
        T r16 = this.c;
        if (r16 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L44:
        View r17 = r11.c(r16.getContext(), r7);
        if (r17 == null) goto L121;
        if (r17.getId() != (-1)) goto L49;
        r17.setId(ViewCompat.generateViewId());
    L49:
        r7.addView(r17);
        r11.b = r17;
        ConstraintSet r18 = new ConstraintSet();
        r18.clone(r7);
        int r19 = r17.getId();
        T r21 = this.c;
        if (r21 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L52:
        ElementConstraint r110 = r1.m(r21);
        float r22 = r110.l;
        float r23 = 0;
        if (r22 >= r23) goto L56;
        r18.constrainWidth(r19, (int) r22);
    L59:
        float r24 = r110.m;
        if (r24 >= r23) goto L63;
        r18.constrainHeight(r19, (int) r24);
    L66:
        Iterator r111 = ((ArrayList) r110.j).iterator();
    L68:
        if (r111.hasNext() == false) goto L86;
        ElementConstraint.c r25 = (ElementConstraint.c) r111.next();
        ElementConstraint.a r112 = r25.b;
        if (r112.a == false) goto L76;
        float r113 = r25.d;
        if (r113 == 0.0f) goto L74;
        r18.connect(r19, r25.a, 0, r25.c, s1.f(r113));
        goto L68
    L74:
        r18.connect(r19, r25.a, 0, r25.c, r25.e);
        goto L68
    L76:
        if (r112.b == false) goto L78;
        r18.connect(r19, r25.a, -1, r25.c);
        goto L68
    L78:
        StringBuilder r26 = new StringBuilder("坑位内的布局只支持相对父View的布局,");
        T r27 = this.c;
        if (r27 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L81:
        r26.append(r1.o(r27));
        r26.append("的位置关系依赖了父View以外的View,请检查");
        String r28 = r26.toString();
        if (v.a() == false) goto L68;
        throw new RuntimeException(r28);
    L86:
        int r2 = r110.i;
        if (r2 != (-1)) goto L89;
        r18.setVisibility(r19, r17.getVisibility());
    L90:
        r17.setPadding((int) r110.c, (int) r110.e, (int) r110.d, (int) r110.f);
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L96
        float r31 = r110.k;     // Catch: Throwable -> L96
        if (r31 == 0.0f) goto L94;
        r18.setTranslationX(r19, s1.f(r31));     // Catch: Throwable -> L96
    L94:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L96
    L99:
        if ((r17 instanceof ViewGroup) == false) goto L101;
        ViewGroup r32 = (ViewGroup) r17;
        r32.setClipChildren(r110.g);
        r32.setClipToPadding(r110.h);
    L101:
        Integer r33 = 0;
        if (r33.intValue() == 0) goto L104;
        boolean r34 = true;
    L105:
        if (r34 == true) goto L108;
        r33 = null;
    L108:
        if (r33 == null) goto L136;
        r17.setBackgroundResource(r33.intValue());
    L136:
        r18.applyTo(r7);     // Catch: ClassCastException -> L112
    L113:
        com.bytedance.android.live.core.tetris.componentx.component.b r35 = this.h;
        if (r35 == null) goto L116;
        r35.f(r11);
    L116:
        getLifecycle().addObserver(r11);
        d r36 = this.d;
        if (r36 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("elementGroup");
    L119:
        r36.b(r11);
        z70.c.a("template element added, func_id = " + r11.d.b);
        return;
    L112:
        LocalTestManager.a(new Class[]{wy.a.class});
        goto L113
    L104:
        r34 = false;
    L96:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L99
    L89:
        r18.setVisibility(r19, r2);
        r110.i = -1;
        goto L90
    L63:
        if (r24 <= r23) goto L65;
        r18.constrainHeight(r19, s1.f(r24));
        goto L66
    L65:
        r18.constrainHeight(r19, r110.b);
        goto L66
    L56:
        if (r22 <= r23) goto L58;
        r18.constrainWidth(r19, s1.f(r22));
        goto L59
    L58:
        r18.constrainWidth(r19, r110.a);
        goto L59
    L121:
        throw new IllegalStateException("buildView here shouldn't be null.");
    L123:
        if (r1 == null) goto L131;
        T r38 = this.c;
        if (r38 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L127:
        f r39 = r1.o(r38);
        if (r39 == null) goto L131;
        String r41 = r39.b;
        if (r41 == null) goto L131;
    L132:
        z70.c.a("config can not load, func_id = ".concat(r41));
        return;
    L131:
        r41 = "null";
        goto L132
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.e.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.g = null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        this.e.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        this.e.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        this.e.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        this.e.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public final Lifecycle getLifecycleCompat() {
        return this.e;
    }

    public TemplateLoader(j70.c r2) {
        Intrinsics.checkNotNullParameter(r2, "containerType");
        this.i = r2;
        this.a = new ArrayList();
        this.e = new ObservableLifecycleRegistry(this);
    }

    @Override // z70.a
    public final void setExtraInfo(Map<String, String> r2) {
        Map<String, String> r0 = this.g;
        if (r0 != null) goto L5;
        this.g = r2;
        return;
    L5:
        r0.putAll(r2);
    }
}
