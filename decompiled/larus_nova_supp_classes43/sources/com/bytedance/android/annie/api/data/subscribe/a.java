package com.bytedance.android.annie.api.data.subscribe;

import com.bytedance.android.live.browser.jsbridge.i;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class a<T> extends BaseDataObsProvider<T> {
    public final boolean b;

    /* JADX INFO: renamed from: com.bytedance.android.annie.api.data.subscribe.a$a, reason: collision with other inner class name */
    public static final class C0058a<T, R> implements Function {
        public final /* synthetic */ a<T> a;

        public C0058a(a<T> r1) {
            this.a = r1;
        }

        public final Object apply(Object r10) {
            this.a.getClass();
            if ((r10 instanceof JsonElement) == true) goto L10;
            if (r10 == null) goto L9;
            JsonElement r11 = d.b(r10);
            if (r11 == null) goto L9;
            return r11;
        L9:
            return new JsonObject();
        L10:
            return (JsonElement) r10;
        }
    }

    public a() {
        this(false);
    }

    public abstract Observable<T> j(String r1);

    public a(boolean r1) {
        this.b = r1;
    }

    @Override // com.bytedance.android.annie.api.data.subscribe.BaseDataObsProvider, com.bytedance.android.annie.api.data.subscribe.e
    public final Pair<String, Observable<JsonElement>> b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "path");
        StringBuilder r1 = new StringBuilder("room_message.");
        i.e.f r11 = i.e.f.b;
        r1.append(r10);
        String r12 = r1.toString();
        Observable<T> r13 = j(r10);
        if (r13 == null) goto L7;
        Observable r14 = r13.map(new C0058a(this));
        if (r14 == null) goto L7;
        Observable r15 = r14.subscribeOn(Schedulers.io());
    L9:
        return new Pair(r12, r15);
    L7:
        r15 = null;
        goto L9
    }
}
