package com.bytedance.android.livesdk.dislike.layout;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nt1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/layout/IMMoreContactDescItemLayout;", "Landroid/widget/LinearLayout;", "Lnt1/c;", "vo", "", "update", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IMMoreContactDescItemLayout extends LinearLayout {
    public final TextView a;
    public final ImageView b;

    public IMMoreContactDescItemLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IMMoreContactDescItemLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void update(c r4) {
        Intrinsics.checkNotNullParameter(r4, "vo");
        ImageView r0 = this.b;
        if (r0 == null) goto L5;
        r0.setImageResource(r4.a);
    L5:
        TextView r1 = this.a;
        if (r1 == null) goto L8;
        r1.setText(getContext().getResources().getText(r4.b));
    L8:
        String r2 = r4.c;
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.length() <= 0) goto L13;
        boolean r3 = true;
    L14:
        if (r3 != true) goto L20;
        TextView r5 = this.a;
        if (r5 == null) goto L21;
        r5.setText(r4.c);
        return;
    L21:
        return;
    L20:
        return;
    L13:
        r3 = false;
        goto L14
    }

    public IMMoreContactDescItemLayout(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        View.inflate(r3, 2131565629, this);
        TextView r6 = (TextView) findViewById(2131368819);
        this.a = r6;
        this.b = (ImageView) findViewById(2131374718);
        if (r6 == null) goto L7;
        TextPaint r7 = r6.getPaint();
        if (r7 == null) goto L7;
        r7.setFakeBoldText(false);
    L7:
        setPadding(UtilityKotlinExtentionsKt.i(16), UtilityKotlinExtentionsKt.i(10), UtilityKotlinExtentionsKt.i(16), UtilityKotlinExtentionsKt.i(10));
        setGravity(16);
    }

    public /* synthetic */ IMMoreContactDescItemLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
