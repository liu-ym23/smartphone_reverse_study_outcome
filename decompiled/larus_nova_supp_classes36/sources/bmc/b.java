package bmc;

import android.text.TextUtils;
import com.ss.ugc.live.sdk.msg.data.SdkMessage;
import com.ss.ugc.live.sdk.msg.dispatch.f;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements f {
    public final f a;
    public final List<a> b;

    @Override // com.ss.ugc.live.sdk.msg.dispatch.f
    public final d a(SdkMessage r5) {
        Intrinsics.checkNotNullParameter(r5, "sdkMessage");
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (TextUtils.equals(r5.method, ((a) r1).kM()) == false) goto L4;
    L9:
        a r2 = (a) r1;
        if (r2 == null) goto L13;
        return r2.a(r5);
    L13:
        return this.a.a(r5);
    L8:
        r1 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(f r2, List<? extends a> r3) {
        Intrinsics.checkNotNullParameter(r2, "defaultDecoder");
        Intrinsics.checkNotNullParameter(r3, "messagePlugins");
        this.a = r2;
        this.b = r3;
    }
}
