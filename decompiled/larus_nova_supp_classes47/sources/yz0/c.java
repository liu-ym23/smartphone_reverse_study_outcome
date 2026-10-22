package yz0;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lyz0/c;", "", "", "orientationType", "I", "getOrientationType", "()I", "a", "(I)V", "<init>", "()V", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.room.GetOrientationResponse")
public final class c {
    public static final /* synthetic */ int a = 0;

    @SerializedName("orientation_type")
    private int orientationType;

    public static final class a {
    }

    static {
    }

    public c() {
        this.orientationType = 1;
    }

    public final void a(int r1) {
        this.orientationType = r1;
    }
}
