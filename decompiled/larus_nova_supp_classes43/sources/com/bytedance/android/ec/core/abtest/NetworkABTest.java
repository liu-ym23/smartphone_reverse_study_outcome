package com.bytedance.android.ec.core.abtest;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class NetworkABTest {
    public static final Lazy a = null;
    public static final AtomicBoolean b = null;
    public static final API c = null;
    public static final Lazy d = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\bb\u0018\u00002\u00020\u0001J?\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J?\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0014\b\u0001\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/core/abtest/NetworkABTest$API;", "", "getApi", "", "", com.bytedance.android.ec.core.event.a.KEY_URL, "query", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postApi", "body", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface API {
        @GET
        Object getApi(@Url String r1, @QueryMap Map<String, String> r10, Continuation<? super Map<String, ? extends Object>> r11);

        @POST
        Object postApi(@Url String r1, @Body Map<String, String> r10, Continuation<? super Map<String, ? extends Object>> r11);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/core/abtest/NetworkABTest$a;", "", "", "delayTime", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "", "performanceGet", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "performancePost", "e", "", "getSize", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "postSize", "f", "keySize", "c", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("delay_time")
        private final Long delayTime;

        @SerializedName("get_size")
        private final Integer getSize;

        @SerializedName("key_size")
        private final Integer keySize;

        @SerializedName("performance_get")
        private final String performanceGet;

        @SerializedName("performance_post")
        private final String performancePost;

        @SerializedName("post_size")
        private final Integer postSize;

        public a() {
            this(0);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof a) == false) goto L18;
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.delayTime, r11.delayTime) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.performanceGet, r11.performanceGet) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.performancePost, r11.performancePost) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.getSize, r11.getSize) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.postSize, r11.postSize) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.keySize, r11.keySize) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            Long r0 = this.delayTime;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r10 = r0.hashCode();
        L6:
            int r11 = r10 * 31;
            String r12 = this.performanceGet;
            if (r12 == null) goto L9;
            int r13 = r12.hashCode();
        L10:
            int r14 = (r11 + r13) * 31;
            String r15 = this.performancePost;
            if (r15 == null) goto L13;
            int r16 = r15.hashCode();
        L14:
            int r17 = (r14 + r16) * 31;
            Integer r18 = this.getSize;
            if (r18 == null) goto L17;
            int r19 = r18.hashCode();
        L18:
            int r20 = (r17 + r19) * 31;
            Integer r21 = this.postSize;
            if (r21 == null) goto L21;
            int r22 = r21.hashCode();
        L22:
            int r23 = (r20 + r22) * 31;
            Integer r24 = this.keySize;
            if (r24 == null) goto L26;
            r1 = r24.hashCode();
        L26:
            return r23 + r1;
        L21:
            r22 = 0;
            goto L22
        L17:
            r19 = 0;
            goto L18
        L13:
            r16 = 0;
            goto L14
        L9:
            r13 = 0;
            goto L10
        L5:
            r10 = 0;
            goto L6
        }

        public final String toString() {
            return "Config(delayTime=" + this.delayTime + ", performanceGet=" + this.performanceGet + ", performancePost=" + this.performancePost + ", getSize=" + this.getSize + ", postSize=" + this.postSize + ", keySize=" + this.keySize + ")";
        }

        public final Long a() {
            return this.delayTime;
        }

        public final Integer b() {
            return this.getSize;
        }

        public final Integer c() {
            return this.keySize;
        }

        public final String d() {
            return this.performanceGet;
        }

        public final String e() {
            return this.performancePost;
        }

        public final Integer f() {
            return this.postSize;
        }

        public a(int r1) {
            this.delayTime = null;
            this.performanceGet = null;
            this.performancePost = null;
            this.getSize = null;
            this.postSize = null;
            this.keySize = null;
        }
    }

    public NetworkABTest() {
    }

    static {
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.PUBLICATION;
        a = LazyKt.lazy(r0, NetworkABTest$config$2.INSTANCE);
        b = new AtomicBoolean(true);
        c = (API) n.a.create("https://ecom.snssdk.com", API.class);
        d = LazyKt.lazy(r0, NetworkABTest$enable$2.INSTANCE);
    }

    public static final a b() {
        return (a) a.getValue();
    }

    public static Object c(Continuation r10) {
        if (b.compareAndSet(true, false) == false) goto L5;
        Object r11 = BuildersKt.withContext(Dispatchers.getIO(), new NetworkABTest$onNetworkTest$2(null), r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r11;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public static final Map a(int r10, String r11) {
        if (r10 <= 0) goto L12;
        LinkedHashMap r0 = new LinkedHashMap();
        int r1 = 1;
        if (1 > r10) goto L10;
    L6:
        r0.put("empty_K" + r1, r11);
        if (r1 == r10) goto L10;
        r1 = r1 + 1;
    L10:
        return r0;
    L12:
        return MapsKt.emptyMap();
    }
}
