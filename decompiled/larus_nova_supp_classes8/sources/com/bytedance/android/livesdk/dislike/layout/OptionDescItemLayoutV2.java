package com.bytedance.android.livesdk.dislike.layout;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.livesdk.sharedpref.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nt1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/layout/OptionDescItemLayoutV2;", "Landroid/widget/LinearLayout;", "Lnt1/c;", "vo", "", "update", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OptionDescItemLayoutV2 extends LinearLayout {
    public final TextView a;
    public final ImageView b;
    public final ImageView c;
    public String d;

    public static final class a {
    }

    static {
    }

    public OptionDescItemLayoutV2(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.d = "";
        View.inflate(getContext(), 2131565632, this);
        setOrientation(1);
        setGravity(17);
        TextView r0 = (TextView) findViewById(2131368819);
        this.a = r0;
        this.b = (ImageView) findViewById(2131374718);
        this.c = (ImageView) findViewById(2131376544);
        if (r0 == null) goto L7;
        TextPaint r1 = r0.getPaint();
        if (r1 == null) goto L7;
        r1.setFakeBoldText(true);
    L7:
        setBackgroundResource(2131249494);
    }

    public final void update(c r7) {
        Intrinsics.checkNotNullParameter(r7, "vo");
        ImageModel r0 = r7.g;
        if (r0 == null) goto L5;
        ImageUtil.loadImage(this.b, r0, 0);
    L8:
        TextView r1 = this.a;
        if (r1 != null) goto L51;
    L14:
        String r2 = r7.c;
        boolean r3 = true;
        if (r2 != null) goto L17;
    L24:
        TextView r4 = this.a;
        if (r4 == null) goto L53;
        CharSequence r5 = r4.getText();
        if (r5 == null) goto L54;
        String r6 = r5.toString();
        if (r6 != null) goto L32;
        return;
    L32:
        if (r7.f == false) goto L34;
    L39:
        if (r3 == false) goto L44;
        ImageView r8 = this.c;
        if (r8 == null) goto L43;
        r8.setVisibility(0);
    L43:
        this.d = r6;
    L48:
        if (r7.e == false) goto L55;
        setVisibility(4);
        return;
    L55:
        return;
    L44:
        ImageView r9 = this.c;
        if (r9 == null) goto L48;
        r9.setVisibility(8);
        goto L48
    L34:
        if (r7.d == false) goto L38;
        String r10 = "long_press_dot_".concat(r6);
        Boolean r11 = Boolean.FALSE;
        if (Intrinsics.areEqual((Boolean) new e(r10, r11).getValue(), r11) == true) goto L39;
    L38:
        r3 = false;
        goto L39
    L54:
        return;
    L53:
        return;
    L17:
        if (r2.length() <= 0) goto L19;
        boolean r12 = true;
    L20:
        if (r12 != true) goto L24;
        TextView r13 = this.a;
        if (r13 == null) goto L24;
        r13.setText(r7.c);
        goto L24
    L19:
        r12 = false;
        goto L20
    L51:
        CharSequence r14 = getContext().getResources().getText(r7.b);     // Catch: Exception -> L12
    L13:
        r1.setText(r14);
    L12:
        r14 = "";
        goto L13
    L5:
        ImageView r15 = this.b;
        if (r15 == null) goto L8;
        r15.setImageResource(r7.a);
        goto L8
    }

    public OptionDescItemLayoutV2(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.d = "";
        View.inflate(getContext(), 2131565632, this);
        setOrientation(1);
        setGravity(17);
        TextView r4 = (TextView) findViewById(2131368819);
        this.a = r4;
        this.b = (ImageView) findViewById(2131374718);
        this.c = (ImageView) findViewById(2131376544);
        if (r4 == null) goto L7;
        TextPaint r5 = r4.getPaint();
        if (r5 == null) goto L7;
        r5.setFakeBoldText(true);
    L7:
        setBackgroundResource(2131249494);
    }

    public OptionDescItemLayoutV2(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = "";
        View.inflate(getContext(), 2131565632, this);
        setOrientation(1);
        setGravity(17);
        TextView r5 = (TextView) findViewById(2131368819);
        this.a = r5;
        this.b = (ImageView) findViewById(2131374718);
        this.c = (ImageView) findViewById(2131376544);
        if (r5 == null) goto L7;
        TextPaint r6 = r5.getPaint();
        if (r6 == null) goto L7;
        r6.setFakeBoldText(true);
    L7:
        setBackgroundResource(2131249494);
    }
}
