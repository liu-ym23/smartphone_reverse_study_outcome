package com.bytedance.android.live.revenue.platform.hybrid.impl.component;

import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.android.annie.container.dialog.BaseDialogFragment;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.web.jsbridge2.g;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class d<VIEW extends View> extends b<VIEW> {
    public static final a d = null;
    public final BaseHybridComponent c;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static BaseHybridComponent a(IHybridComponent r2) {
            if ((r2 instanceof BaseHybridComponent) == false) goto L6;
            return (BaseHybridComponent) r2;
        L6:
            if ((r2 instanceof HybridCard) == false) goto L11;
            IHybridComponent r3 = ((HybridCard) r2).getMCurrentHybridComponent();
            if (r3 != null) goto L29;
        L26:
            return null;
        L29:
            return a(r3);
        L11:
            if ((r2 instanceof BaseDialogFragment) == false) goto L16;
            HybridFragment r4 = ((BaseDialogFragment) r2).f;
            if (r4 == null) goto L26;
            return a(r4);
        L16:
            if ((r2 instanceof HybridDialog) == false) goto L21;
            IHybridComponent r5 = ((HybridDialog) r2).getHybridComponent();
            if (r5 == null) goto L26;
            return a(r5);
        L21:
            if ((r2 instanceof HybridFragment) == false) goto L25;
            IHybridComponent r6 = ((HybridFragment) r2).getHybridComponent();
            if (r6 == null) goto L26;
            return a(r6);
        L25:
            LocalTestManager.a(new Class[]{wy.a.class});
            goto L26
        }

        @JvmStatic
        public static d b(IHybridComponent r2) {
            Intrinsics.checkNotNullParameter(r2, "component");
            BaseHybridComponent r0 = a(r2);
            if (r0 == null) goto L13;
            IHybridComponent.HybridType r3 = r2.hybridType();
            int r4 = c.a[r3.ordinal()];
            if (r4 != 1) goto L7;
            Function1 r5 = BaseHybridComponent$Companion$tryConvert$1.INSTANCE;
        L15:
            return (d) r5.invoke(r0);
        L7:
            if (r4 != 2) goto L10;
            r5 = BaseHybridComponent$Companion$tryConvert$2.INSTANCE;
            goto L15
        L10:
            throw new NoWhenBranchMatchedException();
        L13:
            return null;
        }
    }

    static {
        d = new a();
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.impl.component.b, xy0.a
    public final VIEW getHybridView() {
        return (VIEW) this.c.getHybridView();
    }

    public d(BaseHybridComponent r2) {
        Intrinsics.checkNotNullParameter(r2, "originalComponent");
        super(r2);
        this.c = r2;
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.impl.component.b, xy0.a
    public final void updateData(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        this.c.updateData(r2);
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.impl.component.b, xy0.a
    public final void updateGlobalProps(Map<String, ? extends Object> r2) {
        this.c.updateGlobalProps(r2);
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.impl.component.b, xy0.a, wy0.e
    public final void registerMethod(String r2, com.bytedance.ies.web.jsbridge2.f.b r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "methodProvider");
        this.c.registerMethod(r2, r3);
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.impl.component.b, xy0.a
    public final void updateScreenMetrics(int r2, int r3) {
        this.c.updateScreenMetrics(r2, r3);
    }

    @Override // com.bytedance.android.live.revenue.platform.hybrid.impl.component.b, xy0.a, wy0.e
    public final void registerMethod(String r2, g<?, ?> r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "method");
        this.c.registerMethod(r2, r3);
    }
}
