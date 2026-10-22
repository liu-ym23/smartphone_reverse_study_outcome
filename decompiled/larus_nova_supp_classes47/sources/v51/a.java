package v51;

import com.bytedance.android.scope.l;
import com.bytedance.android.scope.o;
import e33.k;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;
import o51.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements o {
    public h a;
    public final b b;

    public final void onStart() {
        String r2 = null;
        jy0.b.c("xuzr_log", "AnchorCoreLaunchService onStart", null, 4);
        b r0 = this.b;
        Intrinsics.checkNotNullParameter(r0, "streamInteractScope");
        h r1 = new h(r0);
        Intrinsics.checkNotNullParameter(r1, "scope");
        Object r3 = k.a;
        if (r1.e != r3) goto L6;
        r2 = "context";
    L35:
        if (r2 != null) goto L39;
        this.a = r1;
        l.a(r1);
        return;
    L39:
        throw new UninitializedPropertyAccessException(r2);
    L6:
        if (r1.f != r3) goto L9;
        r2 = "dynamicLayoutClient";
        goto L35
    L9:
        if (r1.g != r3) goto L12;
        r2 = "linkInternalDataSet";
        goto L35
    L12:
        if (r1.h != r3) goto L15;
        r2 = "linkInstanceService";
        goto L35
    L15:
        if (r1.i != r3) goto L18;
        r2 = "anchorRtcManager";
        goto L35
    L18:
        if (r1.j != r3) goto L21;
        r2 = "linkOutManager";
        goto L35
    L21:
        if (r1.k != r3) goto L24;
        r2 = "revLinkHostService";
        goto L35
    L24:
        if (r1.l != r3) goto L27;
        r2 = "linkDataScope";
        goto L35
    L27:
        if (r1.m != r3) goto L30;
        r2 = "revenueInstance";
        goto L35
    L30:
        if (r1.n != r3) goto L33;
        r2 = "revenueInstanceExt";
        goto L35
    L33:
        if (r1.o != r3) goto L35;
        r2 = "roomInstance";
        goto L35
    }

    public final void onStop() {
        jy0.b.c("xuzr_log", "AnchorCoreLaunchService onStop", null, 4);
        h r0 = this.a;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.link.utils.a.c(r0);
    L5:
        this.a = null;
    }

    public a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "streamInteractScope");
        this.b = r2;
    }
}
