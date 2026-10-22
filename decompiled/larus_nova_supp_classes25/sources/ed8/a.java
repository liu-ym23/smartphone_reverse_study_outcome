package ed8;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.larus.bmhome.chat.cell.view.AbstractMessageBoxContainerView;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c;
import v19.c7;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a implements Function1 {
    public final /* synthetic */ AbstractMessageBoxContainerView a;
    public final /* synthetic */ i b;

    public /* synthetic */ a(AbstractMessageBoxContainerView r1, i r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r18) {
        AbstractMessageBoxContainerView r1 = this.a;
        i r2 = this.b;
        boolean r3 = ((Boolean) r18).booleanValue();
        TextView r4 = r1.d;
        TextView r6 = null;
        if (r4 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("longMessageExpandView");
        r4 = null;
    L6:
        if (r3 == false) goto L8;
        int r9 = 0;
    L9:
        r4.setVisibility(r9);
        if (r3 == false) goto L72;
        Drawable r5 = r2.getBackground();
        if ((r5 instanceof ColorDrawable) == false) goto L16;
        Integer r7 = Integer.valueOf(((ColorDrawable) r5).getColor());
    L24:
        if (r2.getBoxType() != 1) goto L26;
        int r8 = c.b(2130972123, r2.getContext(), 2131103203);
    L27:
        if (r7 != null) goto L29;
    L37:
        int r10 = ContextCompat.getColor(r2.getContext(), r8);
    L39:
        if (r2.getBoxType() != 1) goto L41;
        boolean r11 = true;
    L42:
        IFlowThemeConfigProvider r12 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r12 == null) goto L55;
        Integer r13 = Integer.valueOf(r10);
        if (r11 == false) goto L47;
        ThemeColorKey r14 = ThemeColorKey.MESSAGE_BUBBLE_COLOR;
    L48:
        ThemeColorKey r15 = r14;
        ThemeConfigScene r16 = ThemeConfigScene.CHAT;
        if (r11 == false) goto L51;
        AdaptThemeFeatureKey r17 = AdaptThemeFeatureKey.SEND_MESSAGE_BUBBLE;
    L52:
        AdaptThemeFeatureKey r19 = r17;
        boolean r20 = h.a;
        Integer r21 = r12.f(r13, r15, r16, r19, Boolean.valueOf(h.b(r2.getContext())));
        if (r21 == null) goto L55;
        r10 = r21.intValue();
        goto L55
    L51:
        r17 = AdaptThemeFeatureKey.RECEIVE_MESSAGE_BUBBLE;
        goto L52
    L47:
        r14 = ThemeColorKey.MESSAGE_RECEIVE_BUBBLE_COLOR;
    L55:
        int[] r110 = new int[13];
        int r111 = 0;
    L57:
        if (r111 >= 13) goto L59;
        r110[r111] = ColorUtils.setAlphaComponent(r10, RangesKt.coerceAtMost((r111 * 255) / 5, 255));
        r111 = r111 + 1;
        goto L57
    L59:
        TextView r22 = r1.d;
        if (r22 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("longMessageExpandView");
        r22 = null;
    L62:
        GradientDrawable r23 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, r110);
        float r112 = c7.b(16);
        r23.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, r112, r112, r112, r112});
        r22.setBackground(r23);
        TextView r24 = r1.d;
        if (r24 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("longMessageExpandView");
    L67:
        if (r2.getBoxType() != 1) goto L69;
        int r25 = -1;
    L70:
        r6.setTextColor(r25);
        goto L72
    L69:
        r25 = ContextCompat.getColor(r1.getContext(), c.b(2130972081, r1.getContext(), 2131103143));
        goto L70
    L65:
        r6 = r24;
        goto L67
    L41:
        r11 = false;
        goto L42
    L29:
        if (Color.alpha(r7.intValue()) <= 0) goto L31;
        boolean r113 = true;
    L32:
        if (r113 == true) goto L35;
        r7 = null;
    L35:
        if (r7 == null) goto L37;
        r10 = r7.intValue();
        goto L39
    L31:
        r113 = false;
        goto L32
    L26:
        r8 = c.b(2130970533, r2.getContext(), 2131102542);
        goto L27
    L16:
        if ((r5 instanceof GradientDrawable) == true) goto L18;
    L22:
        r7 = null;
        goto L24
    L18:
        if (Build.VERSION.SDK_INT < 24) goto L22;
        ColorStateList r26 = ((GradientDrawable) r5).getColor();
        if (r26 == null) goto L22;
        r7 = Integer.valueOf(r26.getDefaultColor());
    L72:
        return Unit.INSTANCE;
    L8:
        r9 = 8;
        goto L9
    }
}
