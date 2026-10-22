package com.bytedance.android.livesdk.dislike;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\t\u001a\u00020\u00072#\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002J\u0010\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/LongPressGuideView;", "Landroid/widget/RelativeLayout;", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", LiveEndPageData.TAG_NAME, "v", "", "cb", "setClickCallback", "", "desc", "setDesc", "", "resId", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LongPressGuideView extends RelativeLayout {
    public TextView a;
    public Function1<? super View, Unit> b;

    public LongPressGuideView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LongPressGuideView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setClickCallback(Function1<? super View, Unit> r1) {
        this.b = r1;
    }

    public final void setDesc(int r3) {
        TextView r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("descView");
    L5:
        r0.setText(r3);
    }

    public final void setDesc(CharSequence r3) {
        TextView r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("descView");
    L5:
        r0.setText(r3);
    }

    public LongPressGuideView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        RelativeLayout.inflate(r2, 2131566713, this);
        this.a = (TextView) findViewById(2131390479);
        setOnClickListener(new s(this));
    }

    public /* synthetic */ LongPressGuideView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
