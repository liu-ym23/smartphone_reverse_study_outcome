package fx1;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ c a;
    public final /* synthetic */ Function0 b;

    public b(c r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r4) {
        Boolean r5 = (Boolean) r4;
        this.a.d("首帧状态回调：" + r5, new Pair[0]);
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L6;
        this.b.invoke();
        return;
    }
}
