package kz0;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkz0/a;", "", "value", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.foundation.LinkMicState")
public final class a {

    @SerializedName("value")
    private final Object value;

    public a() {
        this(0);
    }

    public a(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.value = r2;
    }

    public /* synthetic */ a(int r1) {
        this(new JsonObject());
    }
}
