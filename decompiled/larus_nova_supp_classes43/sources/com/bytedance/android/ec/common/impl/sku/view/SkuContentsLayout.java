package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.model.sku.BlankObject;
import com.bytedance.android.ec.model.sku.ContentInfo;
import com.bytedance.android.ec.model.sku.ImageObject;
import com.bytedance.android.ec.model.sku.TextObject;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/view/SkuContentsLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuContentsLayout extends LinearLayout {
    public final List<ContentInfo> a;

    public SkuContentsLayout(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public SkuContentsLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    public SkuContentsLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.a = new ArrayList();
    }

    public final void a(List<ContentInfo> r13, int r14, SkuViewModel r15) {
        Intrinsics.checkNotNullParameter(r13, "contents");
        Intrinsics.checkNotNullParameter(r15, "viewModel");
        Iterator<T> r16 = r13.iterator();
        int r1 = 0;
    L3:
        SimpleDraweeView r10 = null;
        if (r16.hasNext() == false) goto L53;
        ContentInfo r11 = (ContentInfo) r16.next();
        ImageObject r12 = r11.getImageObject();
        if (r12 == null) goto L21;
        List r17 = r12.getUrlList();
        if (r17 == null) goto L21;
        String r18 = (String) CollectionsKt.firstOrNull(r17);
        if (r18 == null) goto L21;
        SimpleDraweeView r19 = new SimpleDraweeView(getContext());
        r19.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        r19.setImageURI(r18);
        Integer r20 = r12.getWidth();
        if (r20 == null) goto L15;
        int r21 = vf4.a.b(r20);
    L16:
        Integer r22 = r12.getHeight();
        if (r22 == null) goto L19;
        int r23 = vf4.a.b(r22);
    L20:
        LinearLayout.LayoutParams r24 = new LinearLayout.LayoutParams(r21, r23);
        r24.gravity = 16;
        r19.setLayoutParams(r24);
    L22:
        TextObject r25 = r11.getTextObject();
        if (r25 == null) goto L43;
        r19 = new TextView(getContext());
        String r26 = r25.getText();
        if (r26 == null) goto L42;
        r19.setText(r26);
        String r27 = r25.getFontColor();
        if (r27 != null) goto L70;
    L31:
        Integer r28 = r25.getFontSize();
        if (r28 == null) goto L34;
        r19.setTextSize(r28.intValue());
    L34:
        Boolean r29 = r25.getBold();
        if (r29 != null) goto L37;
    L41:
        r19.setGravity(16);
        r19.setSingleLine();
        LinearLayout.LayoutParams r30 = new LinearLayout.LayoutParams(-2, -2);
        r30.gravity = 16;
        r19.setLayoutParams(r30);
        goto L43
    L37:
        if (r29.booleanValue() == false) goto L39;
        Typeface r31 = Typeface.DEFAULT_BOLD;
    L40:
        r19.setTypeface(r31);
        goto L41
    L39:
        r31 = Typeface.DEFAULT;
        goto L40
    L70:
        r19.setTextColor(Color.parseColor(r27));     // Catch: Exception -> L30
        goto L31
    L42:
        r19 = null;
    L43:
        BlankObject r32 = r11.getBlankObject();
        if (r32 == null) goto L49;
        SimpleDraweeView r33 = new View(getContext());
        vf4.a.b(0);
        Integer r34 = r32.getWidth();
        if (r34 == null) goto L48;
        r33.setLayoutParams(new LinearLayout.LayoutParams(vf4.a.b(Integer.valueOf(r34.intValue())), vf4.a.b(2)));
        r10 = r33;
    L48:
        r19 = r10;
    L49:
        if (r19 == null) goto L3;
        r19.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        if ((r19.getMeasuredWidth() + r1) >= r14) goto L3;
        addView(r19);
        r1 = r1 + r19.getMeasuredWidth();
        ((ArrayList) this.a).add(r11);
        goto L3
    L19:
        r23 = -1;
        goto L20
    L15:
        r21 = -2;
    L21:
        r19 = null;
        goto L22
    L53:
        Iterator r110 = ((ArrayList) this.a).iterator();
    L55:
        if (r110.hasNext() == false) goto L68;
        ContentInfo r111 = (ContentInfo) r110.next();
        Map r35 = r111.getShowEventTrack();
        if (r35 == null) goto L59;
        String r36 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r35, "show_service_code", null);
    L61:
        if (jg.g.a(r36) == false) goto L55;
        List<String> r37 = r15.getShowServiceCodeList();
        Map r112 = r111.getShowEventTrack();
        if (r112 == null) goto L66;
        String r113 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r112, "show_service_code", null);
        if (r113 == null) goto L66;
    L67:
        r37.add(r113);
    L66:
        r113 = "";
        goto L67
    L59:
        r36 = null;
        goto L61
    L68:
        SkuViewModel.doSkuEventAction$default(r15, "sku_panel_module_show", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_NAME, "service_info")}, null, null, null, 28, null);
    }

    public /* synthetic */ SkuContentsLayout(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
