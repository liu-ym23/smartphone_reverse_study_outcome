package zq0;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdk.utils.l3;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends FrameLayout {
    public LinearLayout a;
    public final int b;

    public final int getContainerHeight() {
        return this.b;
    }

    public a(Context r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, null, 0);
        this.b = r8;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        HSImageView r9 = new HSImageView(getContext());
        r9.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r9.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r9.setBackgroundResource(2131252504);
        IUserService r2 = k.f(IUserService.class);
        if (r2 == null) goto L10;
        f r3 = r2.user();
        if (r3 == null) goto L10;
        IUser r4 = r3.b();
        if (r4 == null) goto L10;
        ImageLoader.bindImage(r9, r4.getAvatarThumb(), new l3(12, 1.0f, null));
        addView(r9);
    L10:
        Unit r10 = Unit.INSTANCE;
        View r11 = new View(getContext());
        r11.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r11.setBackgroundResource(2131249538);
        addView(r11);
        LinearLayout r12 = new LinearLayout(getContext());
        r12.setOrientation(1);
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-2, -2);
        r5.gravity = 1;
        if (r8 <= 0) goto L13;
        int r13 = r8 / 3;
    L14:
        r5.topMargin = r13;
        r12.setLayoutParams(r5);
        r12.setGravity(1);
        addView(r12);
        this.a = r12;
        TextView r14 = new TextView(getContext());
        r14.setText("小游戏投屏中");
        r14.setTextSize(14.0f);
        r14.setTextColor(-1);
        r14.setAlpha(0.8f);
        r14.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        r14.setGravity(17);
        LinearLayout r1 = this.a;
        if (r1 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("textContainer");
    L17:
        r1.addView(r14);
        TextView r15 = new TextView(getContext());
        r15.setText("观众视角当前为游戏画面");
        r15.setTextSize(12.0f);
        r15.setTextColor(-1);
        r15.setAlpha(0.5f);
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.topMargin = UtilityKotlinExtentionsKt.i(4);
        r15.setLayoutParams(r0);
        r15.setGravity(17);
        LinearLayout r16 = this.a;
        if (r16 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("textContainer");
    L20:
        r16.addView(r15);
        return;
    L13:
        r13 = UtilityKotlinExtentionsKt.i(120);
        goto L14
    }
}
