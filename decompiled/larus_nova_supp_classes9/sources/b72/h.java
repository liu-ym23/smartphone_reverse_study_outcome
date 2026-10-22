package b72;

import android.content.Context;
import android.widget.EditText;
import com.bytedance.android.live.core.widget.j;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ com.bytedance.android.live.base.model.message.h a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ EditText e;

    public h(com.bytedance.android.live.base.model.message.h r1, Context r2, String r3, String r4, EditText r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r5) {
        com.bytedance.android.livesdk.interactivity.comment.utils.g.a("input guide chat failed due to " + ((Throwable) r5).getMessage() + ", guide chat id: " + this.a.b());
        int r6 = com.bytedance.android.livesdk.interactivity.api.expression.h.a;
        j r7 = com.bytedance.android.livesdk.interactivity.api.expression.h.a(this.b, this.a, this.c);
        int r0 = c.a;
        c.b(r7, this.a, this.c, this.d, this.e);
    }
}
