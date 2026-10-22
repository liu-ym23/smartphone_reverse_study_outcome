package com.bytedance.android.annie.api.data.subscribe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class BaseDataObsProvider<T> implements e<T> {
    public final Lazy a;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ BaseDataObsProvider<T> a;

        public a(BaseDataObsProvider<T> r1) {
            this.a = r1;
        }

        public final Object apply(Object r10) {
            h r11 = (h) r10;
            Intrinsics.checkNotNullParameter(r11, "it");
            BaseDataObsProvider<T> r0 = this.a;
            T r12 = r11.a;
            r0.getClass();
            if ((r12 instanceof JsonElement) == true) goto L10;
            if (r12 == null) goto L9;
            JsonElement r13 = d.b(r12);
            if (r13 == null) goto L9;
            return r13;
        L9:
            return new JsonObject();
        L10:
            return (JsonElement) r12;
        }
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ JsonElement a(String r1) {
        return f.a(this, r1);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ g c() {
        return f.e(this);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ char d() {
        return '.';
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ JsonElement e(String r1, String r10) {
        return f.b(this, r1, r10);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ JsonElement f(String r1, JsonElement r10) {
        return f.c(this, r1, r10);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.g
    public final /* synthetic */ JsonElement h(List r1, JsonElement r10) {
        return f.d(r1, r10);
    }

    public BaseDataObsProvider() {
        this.a = LazyKt.lazy(BaseDataObsProvider$subject$2.INSTANCE);
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.e
    public Pair<String, Observable<JsonElement>> b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "path");
        return new Pair(key(), ((PublishSubject) this.a.getValue()).map(new a(this)).subscribeOn(Schedulers.io()));
    }

    public final void i(T r10) {
        ((PublishSubject) this.a.getValue()).onNext(new h(r10));
    }
}
