package g38;

import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c<T> implements SdkSender.IParser {
    public final /* synthetic */ Class<T> a;

    public c(Class<T> r1) {
        this.a = r1;
    }

    public final T parse(byte[] r2) {
        return (T) ProtoAdapter.get(this.a).decode(r2);
    }
}
