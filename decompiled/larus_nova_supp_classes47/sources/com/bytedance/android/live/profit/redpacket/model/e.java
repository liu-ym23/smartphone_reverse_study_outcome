package com.bytedance.android.live.profit.redpacket.model;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/model/e;", "", "message", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "c", "(Ljava/lang/Object;)V", "api", "a", "setApi", "<init>", "()V", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.luckyBox.LuckyBoxLazyLoadParams")
public final class e {
    public static final a a = null;

    @SerializedName("api")
    private Object api;

    @SerializedName("message")
    private Object message;

    public static final class a implements uh7.c.b<e> {
        public a() {
        }

        public final void a() {
            a r0 = e.a;
        }

        public final boolean b(KClass<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "type");
            return Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(e.class), r2);
        }

        public static JsonObject f(e r1, uh7.c.a r2) {
            Intrinsics.checkNotNullParameter(r1, "obj");
            Intrinsics.checkNotNullParameter(r2, "context");
            return uh7.c.b.a.a(r1, r2);
        }

        public final /* bridge */ /* synthetic */ JsonObject e(Object r1, uh7.c.a r2) {
            return f((e) r1, r2);
        }

        public final void c(com.bytedance.tools.kcp.modelx.runtime.protobuf.b r3, Object r4, uh7.c.a r5) {
            e r6 = (e) r4;
            Intrinsics.checkNotNullParameter(r3, "$this$writeProtobuf");
            Intrinsics.checkNotNullParameter(r6, "obj");
            Intrinsics.checkNotNullParameter(r5, "context");
            Object r7 = r6.b();
            Object r1 = null;
            if ((r7 instanceof byte[]) == true) goto L5;
            r7 = null;
        L5:
            byte[] r8 = (byte[]) r7;
            if (r8 == null) goto L8;
            r3.b(r8, 1);
        L8:
            Object r9 = r6.a();
            if ((r9 instanceof byte[]) == false) goto L12;
            r1 = r9;
        L12:
            byte[] r2 = (byte[]) r1;
            if (r2 == null) goto L16;
            r3.b(r2, 2);
            return;
        }

        public final Object d(KClass r4, JsonObject r5, uh7.c.a r6) {
            Intrinsics.checkNotNullParameter(r4, "type");
            Intrinsics.checkNotNullParameter(r5, "jsonObject");
            Intrinsics.checkNotNullParameter(r6, "context");
            Intrinsics.checkNotNullParameter(r4, "type");
            Intrinsics.checkNotNullParameter(r5, "jsonObject");
            Intrinsics.checkNotNullParameter(r6, "context");
            return (e) r6.a(r5, r4);
        }
    }

    static {
        a = new a();
    }

    public e() {
    }

    public final Object a() {
        return this.api;
    }

    public final Object b() {
        return this.message;
    }

    public final void c(Object r1) {
        this.message = r1;
    }
}
