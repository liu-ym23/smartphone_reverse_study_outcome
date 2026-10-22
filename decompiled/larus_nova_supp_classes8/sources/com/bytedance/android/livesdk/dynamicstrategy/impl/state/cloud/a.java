package com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.m;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.google.gson.annotations.SerializedName;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lu1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static volatile boolean a;
    public static volatile boolean b;
    public static volatile String c;
    public static volatile List<? extends m> d;
    public static final Map<String, m> e = null;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/state/cloud/a$a;", "", "", "version", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/m;", "factors", "Ljava/util/List;", "a", "()Ljava/util/List;", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0308a {

        @SerializedName("factors")
        private final List<m> factors;

        @SerializedName("version")
        private final String version;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof C0308a) == false) goto L10;
            C0308a r4 = (C0308a) r3;
            if (Intrinsics.areEqual(this.version, r4.version) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.factors, r4.factors) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.version;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            List<m> r4 = this.factors;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "CloudFactorData(version=" + this.version + ", factors=" + this.factors + ")";
        }

        public final List<m> a() {
            return this.factors;
        }

        public final String b() {
            return this.version;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0308a(String r2, List<? extends m> r3) {
            Intrinsics.checkNotNullParameter(r2, "version");
            this.version = r2;
            this.factors = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/state/cloud/a$b;", "", "", "version", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "", "factors", "Ljava/util/List;", "a", "()Ljava/util/List;", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("factors")
        private final List<byte[]> factors;

        @SerializedName("version")
        private final String version;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.version, r4.version) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.factors, r4.factors) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.version;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            List<byte[]> r4 = this.factors;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "CloudFactorPBData(version=" + this.version + ", factors=" + this.factors + ")";
        }

        public final List<byte[]> a() {
            return this.factors;
        }

        public final String b() {
            return this.version;
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "version");
            this.version = r2;
            this.factors = null;
        }
    }

    public static final class c<T> implements ObservableOnSubscribe {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void subscribe(ObservableEmitter<C0308a> r4) {
            Intrinsics.checkNotNullParameter(r4, "emitter");
            SharedPrefHelper r0 = SharedPrefHelper.c(s1.getContext(), "live_dynamic_cloud_state_pb");
            boolean r1 = a.a;
            String r2 = r0.j("cloud_state_data_pb", "{}");
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
            b r5 = (b) GsonHelper.get().fromJson(r2, b.class);     // Catch: Throwable -> L8
            if (r5 == null) goto L6;
            C0308a r6 = new C0308a(r5.b(), a.e(r5.a()));     // Catch: Throwable -> L8
        L11:
            r4.onNext(r6);
            r4.onComplete();
            return;
        L6:
            Result.constructor-impl(null);     // Catch: Throwable -> L8
        L10:
            r6 = new C0308a("", CollectionsKt.emptyList());
        L8:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L10
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r2) {
            C0308a r3 = (C0308a) r2;
            boolean r0 = a.a;
            if (a.a == true) goto L9;
            a.c = r3.b();
            List<m> r4 = r3.a();
            if (r4 != null) goto L7;
            r4 = CollectionsKt.emptyList();
        L7:
            a.d = r4;
            a.a = true;
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            int r0 = k.a;
            StringBuilder r1 = new StringBuilder("Init From Local PB Error ");
            if (r4 == null) goto L5;
            String r5 = r4.getMessage();
        L6:
            r1.append(r5);
            k.a(r1.toString());
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public a() {
    }

    static {
        c = "";
        d = CollectionsKt.emptyList();
        e = new LinkedHashMap();
    }

    public static List c() {
        if (a == true) goto L6;
        d();
    L6:
        if (e.isEmpty() == true) goto L21;
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = d.iterator();
    L10:
        if (r1.hasNext() == false) goto L14;
        m r2 = (m) r1.next();
        if (e.containsKey(r2.name) == true) goto L10;
        r0.add(r2);
        goto L10
    L14:
        r0.addAll(((LinkedHashMap) e).values());
        return r0;
    L21:
        return new ArrayList(d);
    }

    public static void d() {
        if (a == false) goto L5;
        return;
    L5:
        k.a("CloudFactorStore init");
        if (((Boolean) ku1.e.a.getValue()).booleanValue() == true) goto L8;
        String r0 = SharedPrefHelper.c(s1.getContext(), "live_dynamic_cloud_state").j("cloud_state_data", "{}");
        C0308a r1 = (C0308a) GsonHelper.get().fromJson(r0, C0308a.class);     // Catch: Exception -> L16
        if (r1 != null) goto L17;
        r1 = new C0308a("", CollectionsKt.emptyList());     // Catch: Exception -> L16
    L17:
        c = r1.b();
        List<m> r2 = r1.a();
        if (r2 != null) goto L20;
        r2 = CollectionsKt.emptyList();
    L20:
        d = r2;
        a = true;
        return;
    L16:
        r1 = new C0308a("", CollectionsKt.emptyList());
        goto L17
    L8:
        if (b == false) goto L10;
        return;
    L10:
        b = true;
        Observable.create(c.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(d.a, e.a);
    }

    public static final void b(String r2) {
        if (a == true) goto L5;
        d();
    L5:
        d = e(null);
        c = r2;
        SharedPrefHelper r0 = SharedPrefHelper.c(s1.getContext(), "live_dynamic_cloud_state_pb");
        b r1 = new b(r2);
        String r3 = GsonHelper.get().toJson(r1);     // Catch: Exception -> L8
    L9:
        r0.l("cloud_state_data_pb", r3);
        r0.a();
        SharedPrefHelper r4 = SharedPrefHelper.c(s1.getContext(), "live_dynamic_cloud_state");
        r4.l("cloud_state_data", "{}");
        r4.a();
        return;
    L8:
        r3 = "";
        goto L9
    }

    public static List e(List r7) {
        if (r7 == null) goto L9;
        am3.c r0 = jc1.k.n(IMiddlewareNetworkService.class).getProtoDecoder(m.class);
        ArrayList r1 = new ArrayList();
        am3.g r2 = new am3.g();
        Iterator r8 = r7.iterator();
    L5:
        if (r8.hasNext() == false) goto L7;
        byte[] r3 = (byte[]) r8.next();
        r2.l(new am3.b(r3), r3.length);
        r1.add(r0.decode(r2));
        goto L5
    L7:
        return r1;
    L9:
        return CollectionsKt.emptyList();
    }

    public static final void a(List r4, String r5) {
        if (a == true) goto L5;
        d();
    L5:
        int r0 = k.a;
        StringBuilder r1 = new StringBuilder("fetch global features: ");
        if (r4 != null) goto L8;
        List r2 = CollectionsKt.emptyList();
    L9:
        List r3 = r2;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r7 = r3.iterator();
    L11:
        if (r7.hasNext() == false) goto L13;
        r6.add(((m) r7.next()).name);
        goto L11
    L13:
        r1.append(TextUtils.join(",", r6));
        k.a(r1.toString());
        if (r4 != null) goto L16;
        r4 = CollectionsKt.emptyList();
    L16:
        d = r4;
        c = r5;
        SharedPrefHelper r8 = SharedPrefHelper.c(s1.getContext(), "live_dynamic_cloud_state");
        C0308a r9 = new C0308a(c, d);
        String r10 = GsonHelper.get().toJson(r9);     // Catch: Exception -> L19
    L20:
        r8.l("cloud_state_data", r10);
        r8.a();
        if (((Boolean) ku1.d.a.getValue()).booleanValue() == false) goto L27;
        SharedPrefHelper r11 = SharedPrefHelper.c(s1.getContext(), "live_dynamic_cloud_state_pb");
        r11.l("cloud_state_data_pb", "{}");
        r11.a();
        return;
    L27:
        return;
    L19:
        r10 = "";
        goto L20
    L8:
        r2 = r4;
        goto L9
    }
}
