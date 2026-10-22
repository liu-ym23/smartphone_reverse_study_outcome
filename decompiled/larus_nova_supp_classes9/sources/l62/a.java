package l62;

import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.bdlocation.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T extends BaseMessage> {
    public long a;
    public String b;
    public long c;

    public final String toString() {
        return "assetId = " + this.a;
    }

    public a() {
        this.b = BuildConfig.FLAVOR;
    }
}
