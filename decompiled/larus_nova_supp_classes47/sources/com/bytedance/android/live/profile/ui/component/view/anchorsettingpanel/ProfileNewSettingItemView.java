package com.bytedance.android.live.profile.ui.component.view.anchorsettingpanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/anchorsettingpanel/ProfileNewSettingItemView;", "Landroid/widget/FrameLayout;", "", "isChecked", "", "setCheckState", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProfileNewSettingItemView extends FrameLayout {
    public boolean a;
    public ImageView b;
    public ImageView c;
    public TextView d;

    public static final class a {
    }

    static {
    }

    public ProfileNewSettingItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProfileNewSettingItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setCheckState(boolean r3) {
        this.a = r3;
        if (r3 == false) goto L13;
        ImageView r4 = this.c;
        if (r4 == null) goto L7;
        r4.setVisibility(0);
    L7:
        ImageView r5 = this.b;
        if (r5 == null) goto L10;
        r5.setVisibility(8);
    L10:
        TextView r6 = this.d;
        if (r6 == null) goto L23;
        r6.setTextColor(ColorProtector.parseColor("#161823"));
        return;
    L23:
        return;
    L13:
        ImageView r7 = this.c;
        if (r7 == null) goto L16;
        r7.setVisibility(8);
    L16:
        ImageView r8 = this.b;
        if (r8 == null) goto L19;
        r8.setVisibility(0);
    L19:
        TextView r9 = this.d;
        if (r9 == null) goto L25;
        r9.setTextColor(ColorProtector.parseColor("#80161823"));
        return;
    }

    public ProfileNewSettingItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(getContext()).inflate(2131567172, this, true);
        this.b = (ImageView) findViewById(2131391844);
        this.c = (ImageView) findViewById(2131365662);
        this.d = (TextView) findViewById(2131375863);
    }

    public /* synthetic */ ProfileNewSettingItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
