package h82;

import com.bytedance.android.livesdk.interactivity.interactive.dialog.VSMsgBoardPortraitInputDialog;
import com.bytedance.android.livesdkapi.interact.RefreshVSMessageBoardDataEvent;
import io.reactivex.functions.Consumer;
import j82.e;
import j82.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ VSMsgBoardPortraitInputDialog a;
    public final /* synthetic */ e b;
    public final /* synthetic */ j82.a c;
    public final /* synthetic */ f d;
    public final /* synthetic */ j82.c e;

    public a(VSMsgBoardPortraitInputDialog r1, e r2, j82.a r3, f r4, j82.c r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r2) {
        RefreshVSMessageBoardDataEvent r3 = (RefreshVSMessageBoardDataEvent) r2;
        e r4 = this.b;
        if (r4 == null) goto L5;
        r4.i();
    L5:
        j82.a r5 = this.c;
        if (r5 == null) goto L8;
        r5.f(this.a.v);
    L8:
        f r6 = this.d;
        if (r6 == null) goto L11;
        r6.h(this.a.v);
    L11:
        j82.c r7 = this.e;
        if (r7 == null) goto L15;
        r7.n(this.a.v);
        return;
    }
}
