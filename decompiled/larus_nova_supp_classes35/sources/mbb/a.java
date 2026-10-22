package mbb;

import com.ss.android.lark.larkicon.IconScene;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Action {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ IconScene b;
    public final /* synthetic */ long c;

    public a(boolean r1, IconScene r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void run() {
        boolean r0 = c.a;
        c.j(this.a, this.b, true, this.c);
    }
}
