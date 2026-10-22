package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.trace.TraceCons;
import com.obric.memorydata.plugin.R;
import com.obric.oui.c.i;
import com.obric.oui.common.util.h;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u00020\u00152\b\b\u0001\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ8\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001aJ\u0012\u0010%\u001a\u00020\u00152\b\b\u0001\u0010&\u001a\u00020\u001aH\u0002R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0004\n\u0002\b\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexPopupWindowController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "TAG$1", "popupContainerView", "Landroid/view/View;", "popupImageView", "Landroid/widget/ImageView;", "popupTextView", "Landroid/widget/TextView;", "popupWindow", "Landroid/widget/PopupWindow;", "getPopupWindow", "()Landroid/widget/PopupWindow;", "setPopupWindow", "(Landroid/widget/PopupWindow;)V", "hidePopup", "", "isShowing", "", "setStyle", "textColor", "", TraceCons.METRIC_BACKGROUND, "Landroid/graphics/drawable/Drawable;", "showPopup", "anchorView", "letter", "bitmap", "Landroid/graphics/Bitmap;", "x", "centerY", "minTop", "updatePopupImageTint", "tintColor", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13919a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f13920b;
    private final String c;
    private PopupWindow d;
    private View e;
    private TextView f;
    private ImageView g;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexPopupWindowController$Companion;", "", "()V", "DEFAULT_ELEVATION_DP", "", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f13919a = new a(null);
    }

    public d(Context r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        Context r13 = ZeusTransformUtils.wrapperContext(r12, "com.obric.memorydata.plugin");
        this.f13920b = r13;
        this.c = "OIndexPopupWindowLayout";
        View r0 = ZeusTransformUtils.inflate(LayoutInflater.from(r13), ZeusTransformUtils.mapRes(R.layout.o_index_scrollbar_popup_circle, "layout", "o_index_scrollbar_popup_circle"), null, "com.obric.memorydata.plugin");
        this.e = r0.findViewById(ZeusTransformUtils.mapRes(R.id.popup_container, OaidModel.KEY_ID, "popup_container"));
        this.g = (ImageView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.popup_img, OaidModel.KEY_ID, "popup_img")), ImageView.class, "com.obric.memorydata.plugin");
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.popup_text, OaidModel.KEY_ID, "popup_text")), TextView.class, "com.obric.memorydata.plugin");
        this.f = r2;
        if (r2 == null) goto L7;
        a(r2.getCurrentTextColor());
    L7:
        if (ZeusTransformUtils.instanceOf(this.e, OUILinearLayout.class) == false) goto L14;
        View r4 = this.e;
        if (r4 == null) goto L14;
        ((OUILinearLayout) ZeusTransformUtils.preCheckCast(r4, OUILinearLayout.class, "com.obric.memorydata.plugin")).setEnableShadowWidthRadius(true);
        if (l.a(r13) == false) goto L14;
        OUILinearLayout r14 = (OUILinearLayout) ZeusTransformUtils.preCheckCast(r4, OUILinearLayout.class, "com.obric.memorydata.plugin");
        GradientDrawable r3 = new GradientDrawable();
        r3.setShape(1);
        r3.setSize(h.a(r4, 48), h.a(r4, 48));
        r3.setColor(0);
        r14.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r3, Drawable.class, "com.obric.memorydata.plugin"));
        ((OUILinearLayout) ZeusTransformUtils.preCheckCast(r4, OUILinearLayout.class, "com.obric.memorydata.plugin")).setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        l.a(r4, (com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Popup.invoke(Boolean.valueOf(!i.a(r4))), com.obric.oui.material.c[].class, "com.obric.memorydata.plugin"), false, null, 6, null);
    L14:
        this.d = new PopupWindow(r0, -2, -2, false);
    }

    private final void a(int r2) {
        ImageView r1 = this.g;
        if (r1 == null) goto L7;
        r1.setColorFilter(r2, PorterDuff.Mode.SRC_IN);
        return;
    }

    public final void a() {
        PopupWindow r0 = this.d;
        boolean r1 = false;
        if (r0 != null) goto L6;
    L8:
        if (r1 == false) goto L14;
        PopupWindow r3 = this.d;
        if (r3 == null) goto L15;
        r3.dismiss();
        return;
    L15:
        return;
    L14:
        return;
    L6:
        if (r0.isShowing() != true) goto L8;
        r1 = true;
        goto L8
    }

    public final void a(View r5, String r6, Bitmap r7, int r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r5, "anchorView");
        Intrinsics.checkNotNullParameter(r6, "letter");
        if (r7 != null) goto L16;
        TextView r11 = this.f;
        if (r11 == null) goto L8;
        r11.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"));
    L8:
        ImageView r12 = this.g;
        if (r12 == null) goto L12;
        r12.setVisibility(8);
    L12:
        TextView r13 = this.f;
        if (r13 == null) goto L28;
        r13.setVisibility(0);
    L28:
        PopupWindow r14 = this.d;
        if (r14 != null) goto L33;
        String r4 = this.c;
        String r15 = "showPopup skipped: popupWindow is null.";
    L31:
        com.obric.oui.c.a.b.d(r4, r15);
        return;
    L33:
        View r16 = r14.getContentView();
        if (r16 != null) goto L37;
        r4 = ((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin")).c;
        r15 = "showPopup skipped: contentView is null.";
        goto L31
    L37:
        if (r5.isAttachedToWindow() == true) goto L39;
        r4 = this.c;
        r15 = "showPopup skipped: anchorView is not attached to window.";
        goto L31
    L39:
        int r17 = RangesKt.coerceAtLeast(r9 - (r16.getMeasuredHeight() / 2), r10);
        if (r14.isShowing() == true) goto L42;
        r14.setElevation(h.a(r5, 45.0f));
        r14.showAtLocation(r5, 0, r8, r17);
        r16.setElevation(0.0f);
        return;
    L42:
        r14.update(r8, r17, -2, -2);
        return;
    L16:
        TextView r18 = this.f;
        if (r18 == null) goto L20;
        r18.setVisibility(8);
    L20:
        ImageView r19 = this.g;
        if (r19 == null) goto L24;
        r19.setVisibility(0);
    L24:
        ImageView r20 = this.g;
        if (r20 == null) goto L28;
        r20.setImageBitmap(r7);
        goto L28
    }

    public final boolean b() {
        PopupWindow r2 = this.d;
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.isShowing() == true) goto L8;
        return false;
    L8:
        return true;
    }
}
