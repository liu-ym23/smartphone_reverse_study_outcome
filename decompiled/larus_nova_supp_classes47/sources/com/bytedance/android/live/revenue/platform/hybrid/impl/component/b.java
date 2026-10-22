package com.bytedance.android.live.revenue.platform.hybrid.impl.component;

import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.revenue.common.j;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class b<VIEW extends View> extends j implements xy0.a<VIEW> {
    public final IHybridComponent b;

    @Override // xy0.a
    public final void load() {
        load(null, null);
    }

    @Override // com.bytedance.android.live.revenue.common.j
    public final void d() {
        this.b.release();
    }

    @Override // xy0.a
    public VIEW getHybridView() {
        VIEW r0 = (VIEW) this.b.getHybridView();
        if ((r0 instanceof View) == true) goto L6;
        return null;
    L6:
        return r0;
    }

    @Override // xy0.a
    public HybridType o() {
        IHybridComponent.HybridType r0 = this.b.hybridType();
        int r1 = a.a[r0.ordinal()];
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L8;
        return HybridType.LYNX;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return HybridType.H5;
    }

    public b(IHybridComponent r2) {
        Intrinsics.checkNotNullParameter(r2, "originalIComponent");
        this.b = r2;
    }

    @Override // xy0.a
    public final void load(String r2) {
        load(r2, null);
    }

    @Override // xy0.a
    public void updateData(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        this.b.updateData(r2);
    }

    @Override // xy0.a
    public void updateGlobalProps(Map<String, ? extends Object> r2) {
        this.b.updateGlobalProps(r2);
    }

    @Override // xy0.a
    public final void load(String r2, Map<String, ? extends Object> r3) {
        this.b.load(r2, r3);
    }

    @Override // xy0.a, wy0.e
    public void registerMethod(String r2, com.bytedance.ies.web.jsbridge2.f.b r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "methodProvider");
        this.b.registerMethod(r2, r3);
    }

    @Override // xy0.a, wy0.e
    public final void sendJsEvent(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        this.b.sendJsEvent(r2, r3);
    }

    @Override // xy0.a
    public void updateScreenMetrics(int r1, int r2) {
        throw new IllegalStateException("not implemented".toString());
    }

    @Override // xy0.a, wy0.e
    public void registerMethod(String r2, g<?, ?> r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "method");
        this.b.registerMethod(r2, r3);
    }
}
