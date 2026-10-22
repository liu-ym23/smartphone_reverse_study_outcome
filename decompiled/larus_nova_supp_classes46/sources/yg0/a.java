package yg0;

import com.bytedance.android.live.liveinteract.plantform.commonwindow.k;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements on0.a {
    public final /* synthetic */ Triple a;
    public final /* synthetic */ Pair b;
    public final /* synthetic */ ClientUIInfo c;
    public final /* synthetic */ k d;

    @Override // on0.a
    public final void b(pn0.d r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        this.d.onFailed();
    }

    @Override // on0.a
    public final void a(pn0.d r3, pn0.e r4) {
        Intrinsics.checkNotNullParameter(r3, "localRequest");
        Intrinsics.checkNotNullParameter(r4, "localResponse");
        int r5 = ah0.a.a;
        m r6 = ah0.a.a(r4.a);
        ln0.a r0 = h.a;
        r6.d = h.b(r4.a, this.a, this.b);
        ClientUIInfo r7 = this.c;
        if (r7 == null) goto L5;
        List<Integer> r8 = r7.getUiFeatureList();
    L6:
        r6.e = r8;
        this.d.a(r6);
        return;
    L5:
        r8 = null;
        goto L6
    }

    public a(Triple r1, Pair r2, ClientUIInfo r3, k r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
