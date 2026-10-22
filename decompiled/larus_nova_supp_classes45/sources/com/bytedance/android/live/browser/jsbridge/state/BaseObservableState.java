package com.bytedance.android.live.browser.jsbridge.state;

import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class BaseObservableState<T> extends com.bytedance.android.live.browser.jsbridge.state.a<T> implements i.b {
    public final Lazy c;
    public final boolean d;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ BaseObservableState a;

        public a(BaseObservableState r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            com.bytedance.android.live.browser.jsbridge.state.a.C0125a r4 = (com.bytedance.android.live.browser.jsbridge.state.a.C0125a) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            BaseObservableState r0 = this.a;
            T r5 = r4.a;
            r0.getClass();
            if ((r5 instanceof JsonElement) == true) goto L13;
            if (r5 == null) goto L12;
            Gson r1 = r0.a;
            if (r1 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("gson");
        L9:
            JsonElement r6 = GsonProtectorUtils.toJsonTree(r1, r5);
            if (r6 == null) goto L12;
            return r6;
        L12:
            return new JsonObject();
        L13:
            return (JsonElement) r5;
        }
    }

    public BaseObservableState() {
        this(false);
    }

    public abstract void i();

    public BaseObservableState(boolean r2) {
        super(0);
        this.d = r2;
        this.c = LazyKt.lazy(BaseObservableState$subject$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.browser.jsbridge.i.b
    public Observable<JsonElement> a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "keyParam");
        return ((PublishSubject) this.c.getValue()).map(new a(this)).subscribeOn(Schedulers.io());
    }

    public final void h(T r3) {
        ((PublishSubject) this.c.getValue()).onNext(new com.bytedance.android.live.browser.jsbridge.state.a.C0125a(r3));
    }
}
