package ac2;

import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l implements com.ss.ugc.live.sdk.msg.network.n {
    public final Type a;

    public l(Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.a = r2;
    }

    public final Object decode(byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "payload");
        if (Intrinsics.areEqual(this.a, String.class) == false) goto L7;
        return new String(r3, Charsets.UTF_8);
    L7:
        if (Intrinsics.areEqual(this.a, am3.f.class) == true) goto L9;
        Object r0 = new j(this.a).decode(r3);
        if (r0 != null) goto L14;
        ByteArrayInputStream r1 = new ByteArrayInputStream(r3);
        Gson r4 = jc1.k.n(IMiddlewareNetworkService.class).provideNetworkGson();
        return GsonProtectorUtils.fromJson(r4, r4.newJsonReader(new InputStreamReader(r1)), this.a);
    L14:
        return r0;
    L9:
        return new am3.b(r3);
    }
}
