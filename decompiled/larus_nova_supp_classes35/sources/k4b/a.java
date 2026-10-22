package k4b;

import com.ss.android.lark.biz.im.api.ThreadTopic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Function1<f5b.b, Boolean> {
    public final ThreadTopic a;

    public a(ThreadTopic r2) {
        Intrinsics.checkNotNullParameter(r2, "threadTopic");
        this.a = r2;
    }

    public final Object invoke(Object r3) {
        Object r4 = (f5b.b) r3;
        Intrinsics.checkNotNullParameter(r4, "chatMessage");
        String r1 = null;
        if ((r4 instanceof y6b.c) == false) goto L5;
        y6b.c r5 = (y6b.c) r4;
    L6:
        if (r5 == null) goto L9;
        r1 = r5.Q1;
    L9:
        return Boolean.valueOf(Intrinsics.areEqual(r1, this.a.getId()));
    L5:
        r5 = null;
        goto L6
    }
}
