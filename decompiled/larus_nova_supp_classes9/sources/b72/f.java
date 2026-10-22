package b72;

import android.content.Context;
import io.reactivex.functions.Function;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T, R> implements Function {
    public final /* synthetic */ Context a;
    public final /* synthetic */ com.bytedance.android.live.base.model.message.h b;
    public final /* synthetic */ String c;

    public f(Context r1, com.bytedance.android.live.base.model.message.h r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r3) {
        Intrinsics.checkNotNullParameter((Throwable) r3, "it");
        int r4 = com.bytedance.android.livesdk.interactivity.api.expression.h.a;
        return TuplesKt.to(com.bytedance.android.livesdk.interactivity.api.expression.h.a(this.a, this.b, this.c), this.b);
    }
}
