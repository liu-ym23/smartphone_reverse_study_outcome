package com.bytedance.android.livesdk.interactivity.medialink.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\u000b\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/ui/MediaMultiMicPanelIcon;", "Landroid/widget/LinearLayout;", BuildConfig.FLAVOR, "drawableId", BuildConfig.FLAVOR, "setIcon", BuildConfig.FLAVOR, "desc", "setDesc", "Lkotlin/Function0;", "onClick", "setOnClick", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiMicPanelIcon extends LinearLayout {
    public final ImageView a;
    public final TextView b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.invoke();
        }
    }

    public MediaMultiMicPanelIcon(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MediaMultiMicPanelIcon(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setDesc(String r2) {
        Intrinsics.checkNotNullParameter(r2, "desc");
        TextView r0 = this.b;
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    public final void setIcon(int r2) {
        ImageView r0 = this.a;
        if (r0 == null) goto L6;
        r0.setImageResource(r2);
        return;
    }

    public final void setOnClick(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "onClick");
        ImageView r0 = this.a;
        if (r0 == null) goto L6;
        r0.setOnClickListener(new a(r3));
        return;
    }

    public MediaMultiMicPanelIcon(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View r5 = LayoutInflater.from(r2).inflate(2131566919, this, true);
        TextView r6 = null;
        if (r5 == null) goto L5;
        ImageView r7 = (ImageView) r5.findViewById(2131389671);
    L6:
        this.a = r7;
        if (r5 == null) goto L9;
        r6 = (TextView) r5.findViewById(2131389669);
    L9:
        this.b = r6;
        return;
    L5:
        r7 = null;
        goto L6
    }

    public /* synthetic */ MediaMultiMicPanelIcon(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
