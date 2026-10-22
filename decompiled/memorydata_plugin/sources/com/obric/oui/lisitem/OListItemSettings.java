package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010$\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0012\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010)H\u0007J\u000e\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020\u0010J\u000e\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020\u001eJ\u0018\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020\b2\b\b\u0002\u00103\u001a\u000204J\u000e\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020\bJ\u0010\u00107\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010)R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00068"}, d2 = {"Lcom/obric/oui/lisitem/OListItemSettings;", "Lcom/obric/oui/lisitem/OListItemGeneral;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "contentIconWidth", "", "contentImgBackground", "Lcom/obric/oui/layout/OUIFrameLayout;", "getContentImgBackground", "()Lcom/obric/oui/layout/OUIFrameLayout;", "setContentImgBackground", "(Lcom/obric/oui/layout/OUIFrameLayout;)V", "heightMode", "Lcom/obric/oui/lisitem/ListItemHeightMode;", "mTitleInfo", "Landroid/widget/FrameLayout;", "getMTitleInfo", "()Landroid/widget/FrameLayout;", "setMTitleInfo", "(Landroid/widget/FrameLayout;)V", "rootLayout", "Landroid/view/ViewGroup;", "settingsTrailingView", "Lcom/obric/oui/lisitem/SettingsTrailingView;", "getSettingsTrailingView", "()Lcom/obric/oui/lisitem/SettingsTrailingView;", EventBody.KEY_VALUE, "", "trailingTextString", "getTrailingTextString", "()Ljava/lang/String;", "setTrailingTextString", "(Ljava/lang/String;)V", "getContentDefaultOneChildWidth", "inflateContent", "", "setImageView", "drawable", "Landroid/graphics/drawable/Drawable;", "setListItemHeightMode", "mode", "setListItemSettingsEnabled", "enabled", "", "setTrailingText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "setTrailingTextMaxLines", "lineCount", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "setTrailingViewMinWidth", "minWidth", "showTrailingImageView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OListItemSettings extends OListItemGeneral {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f13983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OUIFrameLayout f13984b;
    private final ViewGroup c;
    private final SettingsTrailingView d;
    private String l;
    private int m;
    private ListItemHeightMode n;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13985a = null;

        static {
            int[] r0 = new int[ListItemHeightMode.values().length];
            r0[ListItemHeightMode.DEFAULT.ordinal()] = 1;
            r0[ListItemHeightMode.COMPACT.ordinal()] = 2;
            f13985a = r0;
        }
    }

    public OListItemSettings(Context r10, AttributeSet r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13);
        this.m = ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_listitem_content_width_large, "dimen", "oui_listitem_content_width_large"));
        this.n = ListItemHeightMode.DEFAULT;
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.ll_root, OaidModel.KEY_ID, "ll_root"));
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.ll_root)");
        this.c = (ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.memorydata.plugin");
        this.d = new SettingsTrailingView(r12, null, 0, 6, null);
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.title_info, OaidModel.KEY_ID, "title_info"));
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.title_info)");
        setMTitleInfo((FrameLayout) ZeusTransformUtils.preCheckCast(r1, FrameLayout.class, "com.obric.memorydata.plugin"));
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_content_img_background, OaidModel.KEY_ID, "iv_content_img_background"));
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.iv_content_img_background)");
        setContentImgBackground((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r2, OUIFrameLayout.class, "com.obric.memorydata.plugin"));
        TypedArray r14 = r12.obtainStyledAttributes(r13, R.styleable.OListItemGeneral);
        setTrailingTextString(r14.getString(ZeusTransformUtils.mapRes(R.styleable.OListItemGeneral_oui_list_item_trailing_text, "styleable", "OListItemGeneral_oui_list_item_trailing_text")));
        r14.recycle();
        if (getContentImage() == null) goto L6;
        getContentImgBackground().setVisibility(0);
        return;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public void a() {
        ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.o_listitem_settings, "layout", "o_listitem_settings"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral
    public int getContentDefaultOneChildWidth() {
        return this.m;
    }

    public final OUIFrameLayout getContentImgBackground() {
        OUIFrameLayout r0 = this.f13984b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentImgBackground");
        return null;
    }

    public final FrameLayout getMTitleInfo() {
        FrameLayout r0 = this.f13983a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTitleInfo");
        return null;
    }

    public final SettingsTrailingView getSettingsTrailingView() {
        return this.d;
    }

    public final String getTrailingTextString() {
        return this.l;
    }

    public final void setContentImgBackground(OUIFrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f13984b = r2;
    }

    @Deprecated(message = "use showTrailingImageView instead", replaceWith = @ReplaceWith(expression = "showTrailingImageView(drawable)", imports = {}))
    public final void setImageView(Drawable r1) {
        this.d.setTrailingImage(r1);
    }

    public final void setListItemHeightMode(ListItemHeightMode r7) {
        Intrinsics.checkNotNullParameter(r7, "mode");
        if (this.n != r7) goto L5;
        return;
    L5:
        int r0 = a.f13985a[r7.ordinal()];
        if (r0 != 1) goto L8;
        Resources r1 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        int r2 = R.dimen.oui_listitem_content_width_large;
        String r4 = "oui_listitem_content_width_large";
    L13:
        int r3 = r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(r2, "dimen", r4));
        this.c.setMinimumHeight(r3);
        getMClContent().setMinimumHeight(r3);
        getMClContent().setMinHeight(r3);
        ViewGroup.LayoutParams r5 = getMTrailingElement().getLayoutParams();
        if (r5 != null) goto L17;
    L21:
        this.m = r3;
        b();
        this.n = r7;
        return;
    L17:
        if (ZeusTransformUtils.instanceOf(r5, ConstraintLayout.LayoutParams.class) == false) goto L21;
        int r6 = (r3 - getMClContent().getPaddingTop()) - getMClContent().getPaddingBottom();
        if (r6 >= ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).matchConstraintMinHeight) goto L21;
        FrameLayout r8 = getMTrailingElement();
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).matchConstraintMinHeight = r6;
        r8.setLayoutParams(r5);
        goto L21
    L8:
        if (r0 != 2) goto L11;
        r1 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        r2 = R.dimen.oui_listitem_content_width_middle;
        r4 = "oui_listitem_content_width_middle";
        goto L13
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public final void setListItemSettingsEnabled(boolean r2) {
        setChangeAlphaWhenDisable(false);
        setEnabled(r2);
        if (r2 == false) goto L5;
        FrameLayout r3 = getMLeadingElement();
        float r0 = 1.0f;
    L6:
        r3.setAlpha(r0);
        getMClContent().setAlpha(r0);
        getMContentElement().setAlpha(r0);
        return;
    L5:
        r3 = getMLeadingElement();
        r0 = 0.3f;
        goto L6
    }

    public final void setMTitleInfo(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f13983a = r2;
    }

    public final void setTrailingText(String r2) {
        Intrinsics.checkNotNullParameter(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        this.d.setTrailingText(r2);
    }

    public final void setTrailingTextString(String r3) {
        this.l = r3;
        b();
        String r4 = this.l;
        if (r4 == null) goto L6;
        setTrailingText(r4);
    L6:
        setTrailingView((View) ZeusTransformUtils.preCheckCast(this.d, View.class, "com.obric.memorydata.plugin"));
    }

    public final void setTrailingViewMinWidth(int r4) {
        ViewGroup.LayoutParams r0 = getMTrailingElement().getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ConstraintLayout.LayoutParams.class) == false) goto L6;
        FrameLayout r3 = getMTrailingElement();
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).matchConstraintMinWidth = r4;
        r3.setLayoutParams(r0);
        return;
    }
}
