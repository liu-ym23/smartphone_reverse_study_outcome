package e38;

import com.bytedance.lark.pb.basic.v1.Command;
import com.squareup.wire.Message;
import com.ss.android.lark.sdk.g;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c<T extends Message<?, ?>> extends com.larksuite.rucket.impl.base.push.a<T> {
    public final Command d;

    @Override // com.larksuite.rucket.impl.base.push.a
    public final void b() {
        Map<Command, g.b> r0 = a.a;
        Command r1 = this.d;
        if (r1 == null) goto L6;
        ((ConcurrentHashMap) a.a).put(r1, this);
        return;
    }

    @Override // com.larksuite.rucket.impl.base.push.a
    public final void c() {
        Map<Command, g.b> r0 = a.a;
        Command r1 = this.d;
        if (r1 == null) goto L7;
        ((ConcurrentHashMap) a.a).remove(r1);
        return;
    }

    public c(Command r2, Class<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "command");
        Intrinsics.checkNotNullParameter(r3, "responseClazz");
        super(r3);
        this.d = r2;
    }
}
