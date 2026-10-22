package com.bytedance.android.live.revlink.impl.multianchor.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rB\u001d\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\f\u0010\u0010B%\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\f\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/ui/MultiAnchorLinkInfoTopSubView;", "Landroid/widget/FrameLayout;", "", "supportClose", "", "setSupportClose", "supportGender", "setSupportGender", "startPk", "setStartPk", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorLinkInfoTopSubView extends FrameLayout {
    public TextView a;
    public final com.bytedance.android.live.revlink.impl.multianchor.service.d b;
    public final IRoom c;

    public final void setSupportClose(boolean r1) {
    }

    public final void setSupportGender(boolean r1) {
    }

    public final void a() {
        View r0 = LayoutInflater.from(getContext()).inflate(2131567784, this, true);
        VHeadView r1 = r0.findViewById(2131376107);
        VHeadView r2 = r0.findViewById(2131376019);
        TextView r3 = (TextView) r0.findViewById(2131391507);
        ImageView r4 = (ImageView) r0.findViewById(2131376374);
        VHeadView r5 = r0.findViewById(2131376272);
        TextView r6 = (TextView) r0.findViewById(2131390995);
        this.a = (TextView) r0.findViewById(2131391630);
    }

    public MultiAnchorLinkInfoTopSubView(Context r2) {
        Intrinsics.checkNotNull(r2);
        super(r2);
        this.b = com.bytedance.android.live.revlink.impl.global.b.z();
        f80.b r3 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        Intrinsics.checkNotNull(r3);
        this.c = ((yz0.k) r3).getRoom();
        a();
    }

    public final void setStartPk(boolean r2) {
        if (r2 == false) goto L4;
        TextView r3 = this.a;
        Intrinsics.checkNotNull(r3);
        r3.setText(2131914819);
        return;
    L4:
        TextView r4 = this.a;
        Intrinsics.checkNotNull(r4);
        r4.setText(2131914842);
    }

    public MultiAnchorLinkInfoTopSubView(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNull(r1);
        super(r1, r2);
        this.b = com.bytedance.android.live.revlink.impl.global.b.z();
        f80.b r3 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        Intrinsics.checkNotNull(r3);
        this.c = ((yz0.k) r3).getRoom();
        a();
    }

    public MultiAnchorLinkInfoTopSubView(Context r1, AttributeSet r2, int r3) {
        Intrinsics.checkNotNull(r1);
        super(r1, r2, r3);
        this.b = com.bytedance.android.live.revlink.impl.global.b.z();
        f80.b r4 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        Intrinsics.checkNotNull(r4);
        this.c = ((yz0.k) r4).getRoom();
        a();
    }
}
