package ie8;

import com.larus.im.bean.message.Message;
import ei9.f;
import kc8.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class a implements f {
    public final Message a;
    public final int b;
    public y c;

    public int a() {
        return this.b;
    }

    public a(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.a = r2;
        this.b = 1;
    }
}
