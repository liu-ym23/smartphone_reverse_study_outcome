package f38;

import com.squareup.wire.Message;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.sdk.g;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a<T extends Message<?, ?>> extends com.larksuite.rucket.impl.base.push.a<T> {
    public final Command d;

    @Override // com.larksuite.rucket.impl.base.push.a
    public final void b() {
        Map<com.bytedance.lark.pb.basic.v1.Command, g.b> r0 = e38.a.a;
        Command r1 = this.d;
        if (r1 == null) goto L6;
        ((ConcurrentHashMap) e38.a.b).put(r1, this);
        return;
    }

    @Override // com.larksuite.rucket.impl.base.push.a
    public final void c() {
        Map<com.bytedance.lark.pb.basic.v1.Command, g.b> r0 = e38.a.a;
        Command r1 = this.d;
        if (r1 == null) goto L7;
        ((ConcurrentHashMap) e38.a.b).remove(r1);
        return;
    }

    public a(Command r2, Class<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "command");
        Intrinsics.checkNotNullParameter(r3, "responseClazz");
        super(r3);
        this.d = r2;
    }
}
