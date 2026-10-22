package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.android.live.browser.jsbridge.state.StateObserver;
import com.bytedance.android.live.browser.jsbridge.state.StateObservingService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "__getCurrentState")
public final class e4 extends com.bytedance.ies.web.jsbridge2.f<a, String> {

    @Inject
    public StateObservingService a;
    public Disposable b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/e4$a;", "", "", "", "keys", "Ljava/util/List;", "a", "()Ljava/util/List;", "setKeys", "(Ljava/util/List;)V", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("keys")
        private List<String> keys;

        public a() {
        }

        public final List<String> a() {
            return this.keys;
        }
    }

    public final void onTerminate() {
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.b = null;
    }

    public e4() {
        BrowserServiceImpl.Companion.getClass();
        s20.a r0 = ((s20.b) BrowserServiceImpl.access$getDiComponent$cp()).a();
        Gson r1 = (Gson) r0.a.i.get();
        this.a = (StateObservingService) r0.a.j.get();
    }

    public final void invoke(Object r3, CallContext r4) {
        a r5 = (a) r3;
        Intrinsics.checkNotNullParameter(r5, "param");
        Intrinsics.checkNotNullParameter(r4, "callContext");
        StateObserver.a r6 = StateObserver.h;
        StateObservingService r7 = this.a;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stateObservingService");
    L5:
        JSONArray r0 = new JSONArray();
        List<String> r8 = r5.a();
        if (r8 == null) goto L11;
        Iterator<T> r9 = r8.iterator();
    L9:
        if (r9.hasNext() == false) goto L11;
        r0.put((String) r9.next());
    L11:
        Unit r11 = Unit.INSTANCE;
        Observable r12 = Observable.just(StateObserver.Companion.a(r7, r0));
        int r13 = com.bytedance.revenue.platform.api.core.rx.p.a;
        this.b = r12.observeOn(Schedulers.io()).map(f4.a).subscribe(new g4(this), new h4(this));
    }
}
