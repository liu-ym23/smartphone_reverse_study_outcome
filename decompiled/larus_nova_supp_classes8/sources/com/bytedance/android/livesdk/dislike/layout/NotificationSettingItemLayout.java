package com.bytedance.android.livesdk.dislike.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nt1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/layout/NotificationSettingItemLayout;", "Landroid/widget/LinearLayout;", "Lnt1/b;", "vo", "", "update", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NotificationSettingItemLayout extends LinearLayout {
    public final TextView a;
    public final ImageView b;
    public final ImageView c;

    public NotificationSettingItemLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        View.inflate(getContext(), 2131565676, this);
        setOrientation(1);
        this.a = (TextView) findViewById(2131368819);
        this.b = (ImageView) findViewById(2131374718);
        this.c = (ImageView) findViewById(2131381049);
    }

    public final void update(b r4) {
        Intrinsics.checkNotNullParameter(r4, "vo");
        ImageView r0 = this.b;
        if (r0 == null) goto L5;
        r0.setImageResource(r4.a);
    L5:
        TextView r1 = this.a;
        if (r1 == null) goto L9;
        r1.setText(getContext().getResources().getText(r4.b));
    L9:
        if (r4.c == false) goto L14;
        ImageView r2 = this.c;
        if (r2 == null) goto L14;
        r2.setVisibility(0);
    L14:
        if (r4.c == false) goto L16;
        String r5 = "已选中";
    L17:
        StringBuilder r3 = new StringBuilder();
        TextView r6 = this.a;
        if (r6 == null) goto L20;
        CharSequence r7 = r6.getText();
    L21:
        r3.append(r7);
        r3.append(' ');
        r3.append(r5);
        setContentDescription(r3.toString());
        return;
    L20:
        r7 = null;
        goto L21
    L16:
        r5 = "未选中";
        goto L17
    }

    public NotificationSettingItemLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        View.inflate(getContext(), 2131565676, this);
        setOrientation(1);
        this.a = (TextView) findViewById(2131368819);
        this.b = (ImageView) findViewById(2131374718);
        this.c = (ImageView) findViewById(2131381049);
    }

    public NotificationSettingItemLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View.inflate(getContext(), 2131565676, this);
        setOrientation(1);
        this.a = (TextView) findViewById(2131368819);
        this.b = (ImageView) findViewById(2131374718);
        this.c = (ImageView) findViewById(2131381049);
    }
}
