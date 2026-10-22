package com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.revenue.platform.container.impl.d0;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMemLeakConfig;
import com.bytedance.android.scope.m;
import com.bytedance.ies.web.jsbridge2.q;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lynx.tasm.TemplateData;
import cy0.j;
import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements ih0.c, uh6.a {
    public final AtomicBoolean a;
    public Disposable b;
    public final BehaviorSubject<Boolean> c;
    public Boolean d;
    public final MultiLinkJsb2MethodFinder e;
    public final q f;
    public final boolean g;
    public final AnnieXLynxView h;
    public final ra.a i;
    public f j;

    public static final class a {
    }

    public static final class b<T> implements Predicate {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final boolean test(Object r2) {
            Boolean r3 = (Boolean) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return r3.booleanValue();
        }
    }

    static {
    }

    @Override // ih0.c
    public final void J() {
        ViewParent r0 = this.h.getParent();
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L9;
        r1.removeView(this.h);
        return;
    }

    public final void dispose() {
        this.b.dispose();
        if (this.a.getAndSet(true) == false) goto L5;
        return;
    L5:
        this.h.destroy();
    }

    @Override // ih0.c
    public final void f1() {
        if (((LiveMemLeakConfig) j1.a.getValue()).getOpenFixV2() == false) goto L6;
        this.j = null;
        this.h.setTag(2131362966, null);
        return;
    }

    public final boolean isDisposed() {
        return this.a.get();
    }

    @Override // ih0.c
    public final Completable onLoadSuccess() {
        return this.c.filter(b.a).firstOrError().ignoreElement();
    }

    @Override // ih0.c
    public final void r1() {
        this.b.dispose();
        cy0.e.a.getClass();
        j r0 = cy0.e.a.a;
        m.e.getClass();
        Object r1 = m.b(r0).a(Reflection.getOrCreateKotlinClass(uh6.b.class));
        Intrinsics.checkNotNull(r1);
        this.b = ((f80.a) r1).h(this, null);
    }

    @Override // ih0.c
    public final void release() {
        if (((LiveMemLeakConfig) j1.a.getValue()).getOpenFixV2() == false) goto L5;
        f1();
        J();
    L5:
        dispose();
    }

    @Override // ih0.c
    public final Boolean A() {
        return this.d;
    }

    @Override // ih0.c
    public final View S0() {
        return this.h;
    }

    @Override // ih0.c
    public final View getHybridView() {
        return this.h;
    }

    @Override // ih0.c
    public final void N(long r3) {
        this.h.E(this.i, Long.valueOf(r3));
    }

    @Override // ih0.c
    public final void updateData(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.h.updateData(TemplateData.fromMap(r2));
    }

    @Override // ih0.c
    public final void updateGlobalProps(Map<String, ? extends Object> r2) {
        this.h.updateGlobalProps(TemplateData.fromMap(r2));
    }

    public final void b(String r3, d0 r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "method");
        MultiLinkJsb2MethodFinder r0 = this.e;
        e r1 = new e(r4);
        int r5 = com.bytedance.android.live.lynx.api.a.d;
        r0.k(r3, r1, null);
    }

    public final void d(String r4, Object r5) {
        if (this.g == false) goto L10;
        if ((r5 instanceof JsonObject) == false) goto L7;
    L8:
        AnnieXLynxView r0 = this.h;
        int r2 = AnnieXLynxView.B;
        r0.O(r4, r5, true);
        return;
    L7:
        if ((r5 instanceof JsonArray) == true) goto L8;
    L10:
        if ((r5 instanceof JSONObject) == false) goto L12;
    L27:
        AnnieXLynxView r1 = this.h;
        int r3 = AnnieXLynxView.B;
        r1.O(r4, r5, true);
        return;
    L12:
        if ((r5 instanceof JSONArray) == true) goto L27;
        String r6 = this.f.a(r5);
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L17
        Object r8 = Result.constructor-impl(new JSONObject(r6));     // Catch: Throwable -> L17
    L20:
        if (Result.isSuccess-impl(r8) == false) goto L22;
        JSONObject r9 = (JSONObject) r8;
    L24:
        if (Result.exceptionOrNull-impl(r8) == null) goto L26;
        r9 = new JSONObject();
    L26:
        AnnieXLynxView r10 = this.h;
        int r11 = AnnieXLynxView.B;
        r10.O(r4, r9, true);
        return;
    L22:
        r9 = null;
    L17:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }

    @Override // ih0.c
    public final void h(Map r12, Map r13) {
        if (r12 == null) goto L8;
        TemplateData r0 = this.i.h;
        if (r0 == null) goto L6;
        r0.updateData(r12);
        TemplateData r14 = this.i.h;
    L7:
        ra.a r1 = this.i;
        ra.a r15 = ra.a.a(r1, null, null, null, null, null, r14, null, false, null, 32639);
    L9:
        ra.a r2 = r15;
        if (r13 == null) goto L16;
        TemplateData r16 = this.i.d;
        if (r16 == null) goto L14;
        r16.updateData(r13);
        TemplateData r17 = this.i.d;
    L15:
        r2 = ra.a.a(r2, null, null, r17, null, null, null, null, false, null, 32759);
        goto L16
    L14:
        r17 = TemplateData.fromMap(r13);
    L16:
        this.h.A(r2, null, new d(this));
        return;
    L6:
        r14 = TemplateData.fromMap(r12);
        goto L7
    L8:
        r15 = this.i;
        goto L9
    }

    @Override // ih0.c
    public final void registerMethod(String r4, com.bytedance.ies.web.jsbridge2.f.b r5) {
        Intrinsics.checkNotNullParameter(r4, "name");
        Intrinsics.checkNotNullParameter(r5, "methodProvider");
        ALogger.d("AnnieXCardImpl_MultiLink", "registerMethod, name: " + r4 + ", methodProvider: " + r5 + ", contextProviderFactory: " + ((m16.b) this.h.t(m16.b.class)));
        this.e.k(r4, r5, (m16.b) this.h.t(m16.b.class));
    }

    @Override // ih0.c
    public final void sendJsEvent(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "data");
        d(r2, r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ALogger.e("AnnieXCardImpl_MultiLink", "sendJsEvent error", e);
    }

    public c(AnnieXLynxView r5, ra.a r6, f r7) {
        Intrinsics.checkNotNullParameter(r5, "annieXLynxView");
        Intrinsics.checkNotNullParameter(r6, "lynxModel");
        this.h = r5;
        this.i = r6;
        this.j = r7;
        boolean r8 = false;
        this.a = new AtomicBoolean(false);
        this.b = Disposables.disposed();
        BehaviorSubject<Boolean> r9 = BehaviorSubject.create();
        this.c = r9;
        this.d = Boolean.FALSE;
        MultiLinkJsb2MethodFinder r0 = new MultiLinkJsb2MethodFinder();
        this.e = r0;
        this.f = Annie.getService$default(w8.c.class, null, 2, null).n1();
        r5.n(r0, 0);
        Boolean r10 = this.d;
        if (r10 == null) goto L6;
        r9.onNext(Boolean.valueOf(r10.booleanValue()));
    L6:
        if (MultiLinkLoadWidgetUtils.g() == true) goto L8;
    L10:
        this.g = r8;
        return;
    L8:
        if (h.W().gsonObjectOpt() == false) goto L10;
        r8 = true;
        goto L10
    }
}
