package hz;

import com.bytedance.android.live.base.model.proto._ProtoDecoders_LIVEBASE;
import com.bytedance.android.live.base.model.proto._ProtoDecoders_LIVESDKAPI;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static final Map<Class, am3.c> a = null;

    static {
        HashMap r0 = new HashMap();
        a = r0;
        f.a(r0);
        new _ProtoDecoders_LIVESDKAPI().inject(r0);
        i.a(r0);
        new _ProtoDecoders_LIVEBASE().inject(r0);
    }
}
