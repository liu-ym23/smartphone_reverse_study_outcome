package b72;

import android.widget.EditText;
import com.bytedance.android.live.core.widget.j;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ EditText c;

    public g(String r1, String r2, EditText r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r5) {
        Pair r6 = (Pair) r5;
        j r0 = (j) r6.component1();
        com.bytedance.android.live.base.model.message.h r7 = (com.bytedance.android.live.base.model.message.h) r6.component2();
        int r1 = c.a;
        c.b(r0, r7, this.a, this.b, this.c);
    }
}
