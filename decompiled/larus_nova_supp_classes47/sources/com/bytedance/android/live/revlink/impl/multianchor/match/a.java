package com.bytedance.android.live.revlink.impl.multianchor.match;

import com.bytedance.android.live.revlink.impl.pk.vm.linkout.p;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j8;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.match.a$a, reason: collision with other inner class name */
    public static final class C0145a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(a r7, af2.a r8, int r9, boolean r10, int r12, Function1 r13, int r14) {
            if ((r14 & 2) == 0) goto L5;
            int r2 = 4;
        L7:
            if ((r14 & 4) == 0) goto L9;
            boolean r3 = false;
        L11:
            if ((r14 & 8) == 0) goto L13;
            int r4 = 0;
        L15:
            if ((r14 & 16) == 0) goto L17;
            String r5 = "";
        L19:
            if ((r14 & 32) == 0) goto L21;
            Function1 r6 = null;
        L22:
            r7.Ib(r8, r2, r3, r4, r5, r6);
            return;
        L21:
            r6 = r13;
            goto L22
        L17:
            r5 = null;
            goto L19
        L13:
            r4 = r12;
            goto L15
        L9:
            r3 = r10;
            goto L11
        L5:
            r2 = r9;
            goto L7
        }
    }

    void Bd();

    long Bj();

    b0 Dl();

    void Ib(af2.a r1, int r2, boolean r3, int r4, String r5, Function1<? super p, Unit> r6);

    void Jo(j8 r1);

    boolean Qd();

    void Wd();

    boolean Yj();

    Map<String, String> bb();

    void fl(int r1, i6 r2);

    ArrayList<g.b> getListeners();

    long hj();

    boolean isMatching();

    void ni(int r1, String r2);

    boolean po();

    void y8(String r1);
}
