package b72;

import android.content.Context;
import android.graphics.Bitmap;
import io.reactivex.functions.Function;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T, R> implements Function {
    public final /* synthetic */ Context a;
    public final /* synthetic */ com.bytedance.android.live.base.model.message.h b;
    public final /* synthetic */ String c;

    public e(Context r1, com.bytedance.android.live.base.model.message.h r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object apply(Object r3) {
        Intrinsics.checkNotNullParameter((Bitmap) r3, "bitmap");
        int r4 = com.bytedance.android.livesdk.interactivity.api.expression.h.a;
        return TuplesKt.to(com.bytedance.android.livesdk.interactivity.api.expression.h.a(this.a, this.b, this.c), this.b);
    }
}
