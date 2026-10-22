package c62;

import com.bytedance.android.livesdk.config.yn0;
import com.bytedance.android.livesdk.interactivity.common.utils.LimitQueue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements vlc.b {
    public final LimitQueue a;
    public final Function1<tlc.d, Boolean> b;
    public final Function1<tlc.d, Unit> c;

    public final boolean onMessage(tlc.d r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (((Boolean) this.b.invoke(r3)).booleanValue() == false) goto L9;
        this.a.add(r3);
        return true;
    L9:
        return false;
    }

    public a(Function1<? super tlc.d, Boolean> r2, Function1<? super tlc.d, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "needBufferCallback");
        Intrinsics.checkNotNullParameter(r3, "dispatchCallback");
        this.b = r2;
        this.c = r3;
        this.a = new LimitQueue(((Integer) yn0.a.getValue()).intValue());
    }
}
