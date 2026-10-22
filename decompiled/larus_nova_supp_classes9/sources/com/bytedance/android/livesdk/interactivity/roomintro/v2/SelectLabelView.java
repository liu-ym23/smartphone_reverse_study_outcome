package com.bytedance.android.livesdk.interactivity.roomintro.v2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R(\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/roomintro/v2/SelectLabelView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomIntroLabel;", "<set-?>", "d", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomIntroLabel;", "getLabel", "()Lcom/bytedance/android/livesdkapi/depend/model/live/RoomIntroLabel;", "label", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SelectLabelView extends FrameLayout {
    public final View a;
    public final ImageView b;
    public final TextView c;
    public RoomIntroLabel d;
    public boolean e;

    public static final class a {
    }

    static {
    }

    public SelectLabelView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SelectLabelView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final RoomIntroLabel getLabel() {
        return this.d;
    }

    public final void a(boolean r4) {
        this.e = r4;
        Drawable r0 = null;
        if (r4 == false) goto L32;
        ImageView r5 = this.b;
        if (r5 == null) goto L7;
        a1.p(r5, UtilityKotlinExtentionsKt.i(14));
    L7:
        ImageView r6 = this.b;
        if (r6 == null) goto L10;
        a1.k(r6, UtilityKotlinExtentionsKt.i(14));
    L10:
        ImageView r7 = this.b;
        if (r7 == null) goto L13;
        r7.setImageResource(2131250146);
    L13:
        TextView r8 = this.c;
        if (r8 == null) goto L16;
        r8.setTextColor(s1.h(2131107733));
    L16:
        View r9 = this.a;
        if (r9 == null) goto L19;
        Drawable r10 = r9.getBackground();
    L21:
        if ((r10 instanceof GradientDrawable) == false) goto L24;
        r0 = r10;
    L24:
        GradientDrawable r1 = (GradientDrawable) r0;
        if (r1 == null) goto L27;
        r1.mutate();
    L27:
        if (r1 == null) goto L29;
        r1.setColor(s1.h(2131107732));
    L29:
        View r11 = this.a;
        if (r11 == null) goto L61;
        r11.setBackground(r1);
        return;
    L61:
        return;
    L19:
        r10 = null;
        goto L21
    L32:
        ImageView r13 = this.b;
        if (r13 == null) goto L35;
        a1.p(r13, UtilityKotlinExtentionsKt.i(12));
    L35:
        ImageView r14 = this.b;
        if (r14 == null) goto L38;
        a1.k(r14, UtilityKotlinExtentionsKt.i(12));
    L38:
        ImageView r15 = this.b;
        if (r15 == null) goto L41;
        r15.setImageResource(2131250143);
    L41:
        TextView r16 = this.c;
        if (r16 == null) goto L44;
        r16.setTextColor(s1.h(2131107731));
    L44:
        View r17 = this.a;
        if (r17 == null) goto L47;
        Drawable r18 = r17.getBackground();
    L49:
        if ((r18 instanceof GradientDrawable) == false) goto L52;
        r0 = r18;
    L52:
        GradientDrawable r2 = (GradientDrawable) r0;
        if (r2 == null) goto L55;
        r2.mutate();
    L55:
        if (r2 == null) goto L57;
        r2.setColor(s1.h(2131107730));
    L57:
        View r19 = this.a;
        if (r19 == null) goto L63;
        r19.setBackground(r2);
        return;
    L63:
        return;
    L47:
        r18 = null;
        goto L49
    }

    public SelectLabelView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131567441, this, true);
        this.a = findViewById(2131375835);
        this.b = (ImageView) findViewById(2131375773);
        this.c = (TextView) findViewById(2131375863);
    }

    public /* synthetic */ SelectLabelView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
