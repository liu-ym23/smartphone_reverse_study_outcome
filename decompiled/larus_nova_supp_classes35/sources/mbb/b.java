package mbb;

import com.ss.android.lark.larkicon.IconScene;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ IconScene b;
    public final /* synthetic */ long c;

    public b(boolean r1, IconScene r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r8) {
        boolean r0 = c.a;
        c.i(this.a, this.b, false, this.c, ((Throwable) r8).getMessage());
    }
}
