package b01;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lb01/c;", "", "", "type", "I", "getType", "()I", Constants.Keys.DATA, "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "live-kmp-platform-dynamic-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.foundation.ClientSettingResponse")
public final class c {

    @SerializedName(Constants.Keys.DATA)
    private final Object data;

    @SerializedName("type")
    private final int type;

    public final int getType() {
        return this.type;
    }

    public c(int r2, JsonElement r3) {
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        this.type = r2;
        this.data = r3;
    }
}
