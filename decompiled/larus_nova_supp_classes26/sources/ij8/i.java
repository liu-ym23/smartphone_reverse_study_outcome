package ij8;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.bmhome.chat.standarduikit.clarification.view.InteractionAskAttachmentView;
import com.larus.bmhome.chat.standarduikit.clarification.view.InteractionAskOptionView;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.im.bean.message.block.InteractionAskOption;
import com.larus.mainbot.impl.databinding.LarusInteractionAskBlockViewBinding;
import com.larus.utils.e1;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i extends LinearLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;

    public static final class a {
    }

    static {
    }

    private final InteractionAskAttachmentView getAttachmentView() {
        return (InteractionAskAttachmentView) this.f.getValue();
    }

    private final LarusInteractionAskBlockViewBinding getBinding() {
        return (LarusInteractionAskBlockViewBinding) this.a.getValue();
    }

    private final LinearLayout getCardContainer() {
        return (LinearLayout) this.b.getValue();
    }

    private final AppCompatImageView getCloseView() {
        return (AppCompatImageView) this.d.getValue();
    }

    private final LinearLayout getOptionContainer() {
        return (LinearLayout) this.e.getValue();
    }

    private final TextView getTitleView() {
        return (TextView) this.c.getValue();
    }

    public i(final Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6);
        this.a = LazyKt.lazy(new ij8.a(r6, this));
        this.b = LazyKt.lazy(new b(this));
        this.c = LazyKt.lazy(new c(this));
        this.d = LazyKt.lazy(new d(this));
        this.e = LazyKt.lazy(new e(this));
        this.f = LazyKt.lazy(new f(this));
        setOrientation(1);
        setGravity(80);
        setClipToOutline(false);
        setBackground(null);
        getCardContainer().setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        LinearLayout r1 = getCardContainer();
        GradientDrawable r2 = new GradientDrawable();
        r2.setShape(0);
        float r3 = c7.c(16);
        r2.setCornerRadii(new float[]{r3, r3, r3, r3, 0.0f, 0.0f, 0.0f, 0.0f});
        r2.setColor(v19.c.a(2130970534, getContext(), 2131102545));
        r1.setBackground(r2);
    }

    public static InteractionAskAttachmentView a(i r0) {
        return r0.getBinding().b;
    }

    public static TextView b(i r0) {
        return r0.getBinding().f;
    }

    public static LinearLayout c(i r0) {
        return r0.getBinding().c;
    }

    public static LinearLayout d(i r0) {
        return r0.getBinding().e;
    }

    public static AppCompatImageView e(i r0) {
        return r0.getBinding().d;
    }

    public final void f(p r17, final jj8.h.a r18) {
        Intrinsics.checkNotNullParameter(r17, "input");
        Intrinsics.checkNotNullParameter(r18, "output");
        TextView r2 = getTitleView();
        if (r17.b != 2) goto L5;
        String r3 = r17.a;
        SpannableStringBuilder r7 = new SpannableStringBuilder();
        ForegroundColorSpan r8 = new ForegroundColorSpan(v19.c.a(2130972081, getContext(), 2131103143));
        int r9 = r7.length();
        r7.append(getContext().getString(2131901028));
        r7.setSpan(r8, r9, r7.length(), 17);
        StyleSpan r10 = new StyleSpan(1);
        int r11 = r7.length();
        r7.append(r3);
        r7.setSpan(r10, r11, r7.length(), 17);
        SpannedString r4 = new SpannedString(r7);
    L6:
        r2.setText(r4);
        AppCompatImageView r5 = getCloseView();
        if (r17.j == false) goto L9;
        int r6 = 0;
    L10:
        r5.setVisibility(r6);
        getCloseView().setOnClickListener(new g(r18));
        getOptionContainer().removeAllViews();
        Iterator<T> r12 = r17.c.iterator();
        int r13 = 0;
    L12:
        if (r12.hasNext() == false) goto L42;
        Object r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        InteractionAskOption r16 = (InteractionAskOption) r14;
        int r19 = r17.b;
        if (r19 == 1) goto L21;
        if (r19 == 2) goto L21;
        boolean r20 = false;
    L22:
        InteractionAskOptionView r110 = new InteractionAskOptionView(getContext(), null, 6, 0);
        r110.e(r13, r16);
        if (r20 == true) goto L25;
    L27:
        boolean r21 = false;
    L28:
        r110.d = r20;
        if (r20 == false) goto L32;
        if (r21 == false) goto L32;
        boolean r22 = true;
    L33:
        r110.c = r22;
        r110.setSelected(r22);
        r110.f();
        r110.setOnOptionClickListener(new h(r18));
        if (r13 != CollectionsKt.getLastIndex(r17.c)) goto L36;
        boolean r23 = true;
    L37:
        LinearLayout r24 = new LinearLayout(getContext());
        r24.setOrientation(1);
        r24.addView(r110, new LinearLayout.LayoutParams(-1, -2));
        if (r23 == true) goto L40;
        View r25 = new View(r24.getContext());
        r25.setBackgroundColor(v19.c.a(2130972087, getContext(), 2131103162));
        r24.addView(r25, new LinearLayout.LayoutParams(-1, r24.getContext().getResources().getDimensionPixelSize(v19.c.b(2130971137, null, 2131166644))));
    L40:
        getOptionContainer().addView(r24, new LinearLayout.LayoutParams(-1, -2));
        r13 = r15;
        goto L12
    L36:
        r23 = false;
    L32:
        r22 = false;
        goto L33
    L25:
        if (CollectionsKt.contains(r17.d, r16.getOptionId()) == false) goto L27;
        r21 = true;
    L21:
        r20 = true;
        goto L22
    L42:
        if (r17.g == false) goto L44;
    L47:
        e1.o(getOptionContainer());
    L48:
        InteractionAskAttachmentView r26 = getAttachmentView();
        List<ResourceItemBean> r0 = r17.i;
        BaseResourceViewHolder.a r1 = r18.b();
        int r27 = InteractionAskAttachmentView.b;
        r26.a(r0, r1, new ResourceBarConfig(Mode.EDIT, true, 0, 0, null, null, 60, null));
        return;
    L44:
        if (r17.c.isEmpty() == true) goto L47;
        e1.x(getOptionContainer());
        goto L48
    L9:
        r6 = 8;
        goto L10
    L5:
        String r28 = r17.a;
        SpannableStringBuilder r29 = new SpannableStringBuilder();
        StyleSpan r30 = new StyleSpan(1);
        int r31 = r29.length();
        r29.append(r28);
        r29.setSpan(r30, r31, r29.length(), 17);
        r4 = new SpannedString(r29);
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r6, int r7) {
        int r0 = Math.min(MathKt.roundToInt(com.larus.utils.i.c(getContext()) * 0.7f), getContext().getResources().getDimensionPixelSize(v19.c.b(2130971493, null, 2131167355)));
        int r1 = View.MeasureSpec.getMode(r7);
        int r8 = View.MeasureSpec.getSize(r7);
        if (r1 == 0) goto L6;
        r0 = Math.min(r0, r8);
    L6:
        super.onMeasure(r6, View.MeasureSpec.makeMeasureSpec(r0, Integer.MIN_VALUE));
    }
}
