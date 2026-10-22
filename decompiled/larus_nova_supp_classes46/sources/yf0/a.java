package yf0;

import android.app.Activity;
import com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkApplyListWidgetContract$View;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListType;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a extends f<BaseTalkApplyListWidgetContract$View> {
    public abstract void d();

    public abstract void e();

    public abstract void f(long r1);

    public abstract void g(boolean r1, String r2, long r3, String r5, int r6, boolean r7);

    public abstract void i();

    public abstract Pair<Integer, Integer> j();

    public abstract void k(Activity r1);

    public abstract void l(int r1, Function1<? super Integer, Unit> r2);

    public a(BaseTalkApplyListWidgetContract$View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
    }

    public static /* synthetic */ void h(a r8, boolean r9, String r10, long r11, String r13, int r14, int r15) {
        if ((r15 & 4) == 0) goto L5;
        r11 = 20;
    L5:
        long r3 = r11;
        if ((r15 & 8) == 0) goto L8;
        r13 = "";
    L8:
        String r5 = r13;
        if ((r15 & 16) == 0) goto L11;
        r14 = WaitingListType.UNKNOWN.ordinal();
    L11:
        r8.g(r9, r10, r3, r5, r14, false);
    }
}
