package ofb;

import com.bytedance.lark.pb.media.v1.BrowseFolderResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a<T> implements SdkSender.IParser {
    public final /* synthetic */ nfb.b a;

    public a(nfb.b r1) {
        this.a = r1;
    }

    public final Object parse(byte[] r2) {
        b r0 = b.a;
        return b.b((BrowseFolderResponse) BrowseFolderResponse.ADAPTER.decode(r2), this.a.i);
    }
}
