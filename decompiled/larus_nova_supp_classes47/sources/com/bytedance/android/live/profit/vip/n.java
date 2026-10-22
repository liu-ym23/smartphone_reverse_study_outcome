package com.bytedance.android.live.profit.vip;

import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n implements com.bytedance.android.scope.o, yz0.m {
    public final cy0.f a;
    public final yz0.k b;

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    @Override // yz0.m
    public final void i() {
        kv0.b r0 = new kv0.b(this.a);
        Intrinsics.checkNotNullParameter(r0, "scope");
        Object r1 = e33.k.a;
        if (r0.e != r1) goto L6;
        String r2 = "revenueInstance";
    L12:
        if (r2 != null) goto L16;
        com.bytedance.android.scope.l.a(r0);
        return;
    L16:
        throw new UninitializedPropertyAccessException(r2);
    L6:
        if (r0.f != r1) goto L9;
        r2 = "revenueInstanceExt";
        goto L12
    L9:
        if (r0.g != r1) goto L11;
        r2 = "roomInstance";
        goto L12
    L11:
        r2 = null;
        goto L12
    }

    public final void onStart() {
        IRoom r0 = this.b.getRoom();
        if (((Boolean) o.b.getValue(null, o.a[0])).booleanValue() == true) goto L6;
        return;
    L6:
        if (r0.getVisibilityRange() != 5) goto L13;
        FragmentActivity r1 = ContextUtil.contextToFragmentActivity(this.b.getContext());
        if (r1 == null) goto L14;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L15;
        r2.setFlags(8192, 8192);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void onStop() {
        if (this.b.getRoom().getVisibilityRange() != 5) goto L10;
        FragmentActivity r0 = ContextUtil.contextToFragmentActivity(this.b.getContext());
        if (r0 == null) goto L11;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L12;
        r1.clearFlags(8192);
        return;
    L12:
        return;
    L11:
        return;
    }

    public n(cy0.f r2, yz0.k r3) {
        Intrinsics.checkNotNullParameter(r2, "instScope");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        this.a = r2;
        this.b = r3;
    }
}
