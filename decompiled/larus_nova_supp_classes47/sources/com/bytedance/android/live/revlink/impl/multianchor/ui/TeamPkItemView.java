package com.bytedance.android.live.revlink.impl.multianchor.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.widget.VHeadView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/ui/TeamPkItemView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/revlink/impl/multianchor/ui/a;", "changeTeamSupportCallback", "", "setChangeTeamSupportCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TeamPkItemView extends FrameLayout {
    public final HSImageView a;
    public final HSImageView b;
    public final TextView c;
    public final TextView d;
    public final VHeadView e;
    public final View f;
    public final HSImageView g;
    public final TextView h;
    public a i;

    public TeamPkItemView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        LayoutInflater.from(getContext()).inflate(2131567496, this);
        a1.j(this, 1);
        this.a = findViewById(2131374961);
        this.b = findViewById(2131374960);
        this.c = (TextView) findViewById(2131390995);
        this.d = (TextView) findViewById(2131391507);
        this.e = findViewById(2131376107);
        this.f = findViewById(2131365473);
        this.g = findViewById(2131374965);
        this.h = (TextView) findViewById(2131390294);
    }

    public final void setChangeTeamSupportCallback(a r1) {
        this.i = r1;
    }

    public TeamPkItemView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        LayoutInflater.from(getContext()).inflate(2131567496, this);
        a1.j(this, 1);
        this.a = findViewById(2131374961);
        this.b = findViewById(2131374960);
        this.c = (TextView) findViewById(2131390995);
        this.d = (TextView) findViewById(2131391507);
        this.e = findViewById(2131376107);
        this.f = findViewById(2131365473);
        this.g = findViewById(2131374965);
        this.h = (TextView) findViewById(2131390294);
    }

    public TeamPkItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(getContext()).inflate(2131567496, this);
        a1.j(this, 1);
        this.a = findViewById(2131374961);
        this.b = findViewById(2131374960);
        this.c = (TextView) findViewById(2131390995);
        this.d = (TextView) findViewById(2131391507);
        this.e = findViewById(2131376107);
        this.f = findViewById(2131365473);
        this.g = findViewById(2131374965);
        this.h = (TextView) findViewById(2131390294);
    }
}
