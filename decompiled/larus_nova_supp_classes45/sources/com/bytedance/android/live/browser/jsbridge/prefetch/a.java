package com.bytedance.android.live.browser.jsbridge.prefetch;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.livesdk.config.hj0;
import com.bytedance.android.livesdk.config.l7;
import com.bytedance.ies.tools.prefetch.PrefetchProcess;
import com.bytedance.ies.tools.prefetch.w;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.lynx.tasm.LynxView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public JSONObject a;
    public View b;
    public final CompositeDisposable c;
    public final c d;
    public w e;
    public final LivePrefetchProcessor f;
    public final com.bytedance.android.live.browser.w g;

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.prefetch.a$a, reason: collision with other inner class name */
    public static final class C0120a<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ JSONObject b;

        public C0120a(a r1, JSONObject r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            JSONObject r3 = (JSONObject) r2;
            this.a.finishWithResult(this.b);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            a r0 = this.a;
            r0.finishWithFailure((Throwable) r2);
        }
    }

    public static final class c extends com.bytedance.ies.tools.prefetch.m.a {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
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
        public final void b(com.bytedance.ies.tools.prefetch.i.b r7) {
            Intrinsics.checkNotNullParameter(r7, "response");
            boolean r1 = false;
            if ((r7 instanceof PrefetchNetworkExecutorImpl.MultiFormatResponse.a) == false) goto L21;
            JSONObject r8 = (JSONObject) ((PrefetchNetworkExecutorImpl.MultiFormatResponse.a) r7).g.getValue();
            JSONObject r0 = this.a.a;
            if (r0 == null) goto L7;
            r1 = true;
        L7:
            if (r1 == false) goto L20;
            JSONObject r2 = r0.optJSONObject("_filter_keys");
            String r3 = r0.optString("process_name", null);
            if (r2 != null) goto L17;
            a r4 = this.a;
            View r5 = r4.b;
            if (r3 == null) goto L16;
            if (r5 == null) goto L16;
            Object r6 = r4.g.map2TemplateData(UtilsKt.g(r8), r3);
            if (r6 == null) goto L16;
            this.a.g.updateData(r5, r6, true);
        L16:
            this.a.j(r8);
            return;
        L17:
            this.a.c.add(Observable.fromCallable(new com.bytedance.android.live.browser.jsbridge.prefetch.b(this, r8, r2, r3)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.browser.jsbridge.prefetch.c(this), new d(this)));
            return;
        L20:
            throw new IllegalStateException("params shouldn't be null".toString());
        L21:
            PrefetchNetworkExecutorImpl.MultiFormatResponse.b r9 = (PrefetchNetworkExecutorImpl.MultiFormatResponse.b) r7;
            JSONObject r11 = this.a.a;
            if (r11 == null) goto L24;
            r1 = true;
        L24:
            if (r1 == false) goto L34;
            String r12 = r11.optString("process_name", null);
            a r13 = this.a;
            View r14 = r13.b;
            if (r12 == null) goto L31;
            if (r14 == null) goto L31;
            Object r15 = r13.g.map2TemplateData(UtilsKt.g((JSONObject) r9.g.getValue()), r12);
            if (r15 == null) goto L31;
            this.a.g.updateData(r14, r15, true);
        L31:
            this.a.j((JSONObject) r9.g.getValue());
            return;
        L34:
            throw new IllegalStateException("params shouldn't be null".toString());
        }

        public final void onFailed(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "throwable");
            this.a.finishWithFailure(r2);
        }
    }

    public final void onTerminate() {
        w r0 = this.e;
        if (r0 == null) goto L7;
        PrefetchProcess r1 = r0.a;
        if (r1 == null) goto L7;
        r1.a.remove(r0);
    L7:
        this.c.clear();
    }

    public final void j(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "response");
        if (((Boolean) hj0.a.getValue()).booleanValue() == false) goto L9;
        JSONObject r0 = this.a;
        if (r0 == null) goto L9;
        if (r0.optInt("async_callback", 0) != 1) goto L9;
        this.c.add(Observable.just(r4).subscribeOn(Schedulers.io()).subscribe(new C0120a(this, r4), new b(this)));
        return;
    L9:
        finishWithResult(r4);
    }

    public a(LivePrefetchProcessor r2, com.bytedance.android.live.browser.w r3) {
        Intrinsics.checkNotNullParameter(r2, "processor");
        Intrinsics.checkNotNullParameter(r3, "lynxService");
        this.f = r2;
        this.g = r3;
        this.c = new CompositeDisposable();
        this.d = new c(this);
    }

    public final void invoke(Object r3, CallContext r4) {
        JSONObject r5 = (JSONObject) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.a = r5;
        LynxView r6 = r4.d;
        this.b = r6;
        if ((r6 instanceof WebView) == false) goto L6;
        x46.a r7 = this.f.c(((WebView) r6).getUrl());
    L8:
        if (r7 == null) goto L18;
        w r1 = new w(r7, this.d);
        this.e = r1;
        if (r5.optInt("force_fetch", 0) != 1) goto L12;
    L15:
        r1.c(r5);
        return;
    L12:
        if (((Boolean) l7.a.getValue()).booleanValue() == false) goto L15;
        r1.b(r5);
        return;
    L18:
        throw new IllegalStateException("Failed to create method stub.".toString());
    L6:
        if ((r6 instanceof LynxView) == false) goto L19;
        r7 = this.f.c(r6.getTemplateUrl());
        goto L8
    L19:
        StringBuilder r8 = new StringBuilder("Unknown hybrid view class: ");
        if (r6 == null) goto L22;
        Class<?> r9 = r6.getClass();
    L23:
        r8.append(r9);
        r8.append(". Failed to obtain url.");
        throw new IllegalStateException(r8.toString().toString());
    L22:
        r9 = null;
        goto L23
    }
}
