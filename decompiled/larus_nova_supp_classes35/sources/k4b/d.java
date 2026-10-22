package k4b;

import com.ss.android.lark.chat.entity.message.Pin;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements Function1<f5b.b, Boolean> {
    public final String a;

    public d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "chatterId");
        this.a = r2;
    }

    public final Object invoke(Object r2) {
        f5b.b r3 = (f5b.b) r2;
        Intrinsics.checkNotNullParameter(r3, "chatMessage");
        Pin r4 = r3.getPin();
        if (r4 == null) goto L8;
        if (Intrinsics.areEqual(r4.getOperatorId(), this.a) == false) goto L8;
        return Boolean.TRUE;
    L8:
        return Boolean.FALSE;
    }
}
