package com.obric.oui.titlebar.optimize;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.c.a.b;
import com.obric.oui.c.c;
import com.obric.oui.common.util.h;
import com.obric.oui.text.OBaseTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0019\u0018\u0000 v2\u00020\u0001:\u0001vB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010H\u001a\u00020IH\u0002J\u000e\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020\u0010J(\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020\u00102\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u00072\b\b\u0002\u0010O\u001a\u00020\u0007J\u0016\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020\u00102\u0006\u0010N\u001a\u00020\u0007J\u001e\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020\u00102\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u0007J\u000e\u0010P\u001a\u00020I2\u0006\u0010K\u001a\u00020\u0010J(\u0010P\u001a\u00020I2\u0006\u0010K\u001a\u00020\u00102\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u00072\b\b\u0002\u0010Q\u001a\u00020\u0007J\b\u0010R\u001a\u00020IH\u0002J\u0010\u0010S\u001a\u00020I2\u0006\u0010T\u001a\u00020;H\u0002J\u0018\u0010U\u001a\u00020M2\u0006\u0010K\u001a\u00020\u00102\u0006\u0010V\u001a\u00020\nH\u0002J\b\u0010W\u001a\u00020MH\u0002J\b\u0010X\u001a\u00020,H\u0003J\b\u0010Y\u001a\u00020,H\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\u00102\u0006\u0010N\u001a\u00020\u0007J\u0010\u0010[\u001a\u0004\u0018\u00010\u00102\u0006\u0010N\u001a\u00020\u0007J\"\u0010\\\u001a\u0004\u0018\u00010\u00102\u0006\u0010N\u001a\u00020\u00072\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010^H\u0002J\u0018\u0010_\u001a\u00020\u00072\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010^H\u0002J\u0006\u0010`\u001a\u00020\nJ\u0006\u0010a\u001a\u00020\nJ\u0018\u0010b\u001a\u00020\n2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010^H\u0002J\u0006\u0010c\u001a\u00020IJ\u0006\u0010d\u001a\u00020IJ\u0010\u0010e\u001a\u00020I2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010f\u001a\u00020\nH\u0002J\u0018\u0010g\u001a\u00020I2\u0006\u0010h\u001a\u00020\u00072\u0006\u0010i\u001a\u00020\u0007H\u0014J\u0006\u0010j\u001a\u00020IJ\u0006\u0010k\u001a\u00020IJ\b\u0010l\u001a\u00020IH\u0002J\b\u0010m\u001a\u00020IH\u0002J\u000e\u0010n\u001a\u00020I2\u0006\u0010N\u001a\u00020\u0007J\u000e\u0010o\u001a\u00020I2\u0006\u0010N\u001a\u00020\u0007J\u0012\u0010p\u001a\u00020I2\b\u0010q\u001a\u0004\u0018\u00010;H\u0002J\u000e\u0010r\u001a\u00020I2\u0006\u0010s\u001a\u00020\u0007J\u0012\u0010r\u001a\u00020I2\b\u0010q\u001a\u0004\u0018\u00010;H\u0002J\u0018\u0010t\u001a\u00020I2\u0006\u0010K\u001a\u00020\u00102\u0006\u0010u\u001a\u00020MH\u0002J\u0010\u0010t\u001a\u00020I2\b\u0010K\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\"\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010$R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00106\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b7\u0010\rR\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0012R(\u0010<\u001a\u0004\u0018\u00010;2\b\u0010:\u001a\u0004\u0018\u00010;@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010.R(\u0010C\u001a\u0004\u0018\u00010;2\b\u0010:\u001a\u0004\u0018\u00010;@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010>\"\u0004\bE\u0010@R\u0014\u0010F\u001a\u00020,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010.¨\u0006w"}, d2 = {"Lcom/obric/oui/titlebar/optimize/OCTitleBar;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "autoAdjustTitleSpace", "", "leftViewCount", "getLeftViewCount", "()I", "leftViewListOrCreate", "", "Landroid/view/View;", "getLeftViewListOrCreate", "()Ljava/util/List;", "mCenterView", "getMCenterView", "()Landroid/view/View;", "setMCenterView", "(Landroid/view/View;)V", "mLeftActionBack", "Lcom/obric/oui/button/OButton;", "getMLeftActionBack", "()Lcom/obric/oui/button/OButton;", "setMLeftActionBack", "(Lcom/obric/oui/button/OButton;)V", "mLeftLastView", "getMLeftLastView", "setMLeftLastView", "mLeftViewList", "getMLeftViewList", "setMLeftViewList", "(Ljava/util/List;)V", "mRightLastView", "getMRightLastView", "setMRightLastView", "mRightViewList", "getMRightViewList", "setMRightViewList", "mSubTitleView", "Landroid/widget/TextView;", "getMSubTitleView", "()Landroid/widget/TextView;", "setMSubTitleView", "(Landroid/widget/TextView;)V", "mTitleView", "getMTitleView", "setMTitleView", "onGlobalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "rightViewCount", "getRightViewCount", "rightViewListOrCreate", "getRightViewListOrCreate", EventBody.KEY_VALUE, "", "subTitleText", "getSubTitleText", "()Ljava/lang/String;", "setSubTitleText", "(Ljava/lang/String;)V", "subtitleViewOrCreate", "getSubtitleViewOrCreate", "titleText", "getTitleText", "setTitleText", "titleViewOrCreate", "getTitleViewOrCreate", "addGlobalLayoutListener", "", "addLeftView", "view", "layoutParams", "Landroid/widget/RelativeLayout$LayoutParams;", "index", "marginLeft", "addRightView", "marginRight", "adjustTitlePosition", "adjustTitleViewSpace", MemoryInfoSectionEditActivity.KIND_SCENE, "findLayoutParams", "centerView", "generateCenterViewLayoutParams", "generateSubTitleView", "generateTitleView", "getLeftViewByIndex", "getRightViewByIndex", "getViewByIndex", Constants.KEY_LIST, "", "getViewCount", "hasLeftView", "hasRightView", "hasView", "hideAllLeftView", "hideAllRightView", "initAttrs", "isNeedListenGlobalLayout", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "removeAllLeftViews", "removeAllRightViews", "removeCenterView", "removeGlobalLayoutListener", "removeLeftView", "removeRightView", "setCenterSubText", "title", "setCenterText", "resId", "setCenterView", TrackerImpl.PARAMS, "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCTitleBar extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14799a = null;
    private static final int n = 0;
    private static final int o = 0;
    private static final int p = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14800b;
    private View c;
    private View d;
    private View e;
    private List<View> f;
    private List<View> g;
    private OButton h;
    private TextView i;
    private String j;
    private TextView k;
    private String l;
    private final ViewTreeObserver.OnGlobalLayoutListener m;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u000e\u0010\u000f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/titlebar/optimize/OCTitleBar$Companion;", "", "()V", "BACK_ICON_RES", "", "getBACK_ICON_RES", "()I", "SUB_TITLE_TEXT_COLOR", "getSUB_TITLE_TEXT_COLOR", "SUB_TITLE_TEXT_SIZE", "", "TAG", "", "TITLE_TEXT_COLOR", "getTITLE_TEXT_COLOR", "TITLE_TEXT_SIZE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14799a = new a(null);
        n = ZeusTransformUtils.mapRes(R.drawable.o_ic_titlebar_back, "drawable", "o_ic_titlebar_back");
        o = ZeusTransformUtils.mapRes(R.color.oui_text_1, TypedValues.Custom.S_COLOR, "oui_text_1");
        p = ZeusTransformUtils.mapRes(R.color.oui_text_3b, TypedValues.Custom.S_COLOR, "oui_text_3b");
    }

    public OCTitleBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OCTitleBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OCTitleBar(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.m = new $$Lambda$OCTitleBar$nvgZ01JE4_UlLhjXzjVrn5R5CZ0(this);
        if (r7 == null) goto L6;
        a(r7);
    L6:
        if (c() == false) goto L9;
        a();
        return;
    }

    public /* synthetic */ OCTitleBar(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final int a(List<? extends View> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r7 = 0;
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.size() <= 0) goto L18;
        int r1 = r5.size();
        int r2 = 0;
    L7:
        if (r7 >= r1) goto L13;
        int r3 = r7 + 1;
        if (((View) ZeusTransformUtils.preCheckCast(r5.get(r7), View.class, "com.obric.memorydata.plugin")).getVisibility() == 8) goto L11;
        r2 = r2 + 1;
    L11:
        r7 = r3;
        goto L7
    L13:
        return r2;
    L18:
        return 0;
    }

    private final RelativeLayout.LayoutParams a(View r3, boolean r4) {
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r5, RelativeLayout.LayoutParams.class) == false) goto L6;
        Object r2 = ZeusTransformUtils.preCheckCast(r5, RelativeLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L10:
        return (RelativeLayout.LayoutParams) r2;
    L6:
        if (r4 == false) goto L8;
        ViewGroup.LayoutParams r6 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(h(), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
    L9:
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        r2 = ZeusTransformUtils.preCheckCast(r6, RelativeLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        goto L10
    L8:
        r6 = generateDefaultLayoutParams();
        goto L9
    }

    private final void a() {
        getViewTreeObserver().addOnGlobalLayoutListener(this.m);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        b.a("OCTitleBar", "addGlobalLayoutListener: ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void a(AttributeSet r7) {
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        TypedArray r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme().obtainStyledAttributes(r8, R.styleable.OCTitleBar, 0, 0);
        int r0 = r9.getInt(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_title_pos, "styleable", "OCTitleBar_oui_title_pos"), com.obric.oui.titlebar.OCTitleBar.TitlePosition.FIXED_CENTER.getValue());
        com.obric.oui.titlebar.OCTitleBar.TitlePosition r1 = com.obric.oui.titlebar.OCTitleBar.TitlePosition.values()[r0];
        String r2 = r9.getString(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_title_text, "styleable", "OCTitleBar_oui_title_text"));
        if (r2 == null) goto L6;
        setCenterText(r2);
    L6:
        if (r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_useBackIcon, "styleable", "OCTitleBar_oui_useBackIcon"), true) == false) goto L8;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        OButton r4 = com.obric.oui.titlebar.optimize.a.a(this, r3);
        r4.setButtonSourceBitmap(n);
        setMLeftActionBack(r4);
        a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"));
    L8:
        String r5 = r9.getString(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_sub_title_text, "styleable", "OCTitleBar_oui_sub_title_text"));
        if (r5 == null) goto L11;
        setCenterSubText(r5);
    L11:
        this.f14800b = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_autoAdjustTitleSpace, "styleable", "OCTitleBar_oui_autoAdjustTitleSpace"), true);
        int r10 = (int) ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_p_title_bar_default, "dimen", "oui_p_title_bar_default"));
        setPadding(r10, 0, r10, 0);
    }

    private final void a(View r3, RelativeLayout.LayoutParams r4) {
        if (Intrinsics.areEqual(this.c, r3) == false) goto L5;
        return;
    L5:
        e();
        this.c = r3;
        addView(r3, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    }

    private static final void a(OCTitleBar r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.b();
        if (r1.c() == true) goto L5;
        return;
    L5:
        r1.a("OnGlobalLayoutListener");
    }

    private final void a(String r9) {
        Rect r0 = new Rect();
        Rect r1 = new Rect();
        List<View> r2 = this.f;
        if (r2 == null) goto L9;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        View r4 = (View) ZeusTransformUtils.preCheckCast(r3.next(), View.class, "com.obric.memorydata.plugin");
        Rect r5 = new Rect();
        r4.getGlobalVisibleRect(r5);
        r0.union(r5.left, r5.top, r5.right, r5.bottom);
    L9:
        List<View> r6 = this.g;
        if (r6 == null) goto L17;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r7.hasNext() == false) goto L17;
        View r8 = (View) ZeusTransformUtils.preCheckCast(r7.next(), View.class, "com.obric.memorydata.plugin");
        Rect r10 = new Rect();
        r8.getGlobalVisibleRect(r10);
        r1.union(r10.left, r10.top, r10.right, r10.bottom);
    L17:
        if (r0.isEmpty() == false) goto L19;
        int r11 = 0;
    L20:
        int r12 = RangesKt.coerceAtLeast(r11, 0);
        if (r1.isEmpty() == false) goto L23;
        int r13 = 0;
    L24:
        int r14 = RangesKt.coerceAtLeast(r13, 0);
        int r15 = Math.max(r12, r14);
        b.b("OCTitleBar", "adjustTitleViewSpace, scene: " + r9 + ", leftSpace: " + r12 + ", rightSpace: " + r14 + ", leftViewRectF: " + r0 + ", rightViewRectF: " + r1 + ", width: " + getWidth() + ", height: " + getHeight());
        if (r15 <= 0) goto L55;
        c r16 = c.f13403a;
        TextView r17 = this.i;
        ViewGroup.LayoutParams r18 = null;
        if (r17 != null) goto L29;
        ViewGroup.LayoutParams r19 = null;
    L30:
        if (r19 != null) goto L33;
    L31:
        r19 = null;
    L34:
        RelativeLayout.LayoutParams r20 = (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r19, RelativeLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L38;
        r20.leftMargin = r15;
        r20.rightMargin = r15;
    L38:
        c r21 = c.f13403a;
        TextView r22 = this.k;
        if (r22 != null) goto L41;
        ViewGroup.LayoutParams r23 = null;
    L42:
        if (r23 != null) goto L45;
    L47:
        RelativeLayout.LayoutParams r24 = (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r18, RelativeLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        if (r24 == null) goto L51;
        r24.leftMargin = r15;
        r24.rightMargin = r15;
    L51:
        requestLayout();
        return;
    L45:
        if (ZeusTransformUtils.instanceOf(r23, RelativeLayout.LayoutParams.class) == false) goto L47;
        r18 = r23;
        goto L47
    L41:
        r23 = r22.getLayoutParams();
        goto L42
    L33:
        if (ZeusTransformUtils.instanceOf(r19, RelativeLayout.LayoutParams.class) == false) goto L31;
    L29:
        r19 = r17.getLayoutParams();
        goto L30
    L55:
        return;
    L23:
        r13 = getWidth() - r1.left;
        goto L24
    L19:
        r11 = r0.right;
        goto L20
    }

    private final void b() {
        getViewTreeObserver().removeOnGlobalLayoutListener(this.m);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        b.a("OCTitleBar", "removeGlobalLayoutListener: ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final boolean c() {
        return this.f14800b;
    }

    private final void d() {
        TextView r0 = this.i;
        if (r0 != null) goto L6;
        return;
    L6:
        if (getMSubTitleView() == null) goto L14;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r2 = (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, RelativeLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r2.removeRule(13);
        r2.addRule(14);
        r2.topMargin = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 9);
        if (ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getConfiguration().fontScale <= 1.0f) goto L15;
        r2.topMargin = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 6);
        TextView r3 = getMSubTitleView();
        if (r3 == null) goto L17;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r5 = (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r4, RelativeLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r5.topMargin = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 31);
        return;
    L17:
        return;
    L15:
        return;
    }

    private final void e() {
        View r0 = this.c;
        if (r0 == null) goto L6;
        removeView(r0);
        this.c = null;
        return;
    }

    private final TextView f() {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        OBaseTextView r6 = new OBaseTextView(r1, null, 0, 6, null);
        r6.setMaxLines(1);
        r6.setEllipsize(TextUtils.TruncateAt.END);
        r6.setTextAppearance(ZeusTransformUtils.mapRes(R.style.Title_Title_M_Thick, "style", "Title_Title_M_Thick"));
        r6.setTextColor(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getColor(o));
        return (TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.memorydata.plugin");
    }

    private final TextView g() {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        OBaseTextView r6 = new OBaseTextView(r1, null, 0, 6, null);
        r6.setMaxLines(1);
        r6.setEllipsize(TextUtils.TruncateAt.END);
        r6.setTextAppearance(ZeusTransformUtils.mapRes(R.style.Label_M, "style", "Label_M"));
        r6.setTextColor(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getColor(p));
        return (TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.memorydata.plugin");
    }

    private final List<View> getLeftViewListOrCreate() {
        if (this.f != null) goto L5;
        this.f = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    L5:
        List<View> r3 = this.f;
        Intrinsics.checkNotNull(r3);
        return r3;
    }

    private final List<View> getRightViewListOrCreate() {
        if (this.g != null) goto L5;
        this.g = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    L5:
        List<View> r3 = this.g;
        Intrinsics.checkNotNull(r3);
        return r3;
    }

    private final TextView getSubtitleViewOrCreate() {
        TextView r0 = this.k;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        this.k = g();
        ViewGroup.LayoutParams r1 = generateDefaultLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r2 = (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, RelativeLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r2.addRule(14);
        r2.topMargin = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 30);
        addView((View) ZeusTransformUtils.preCheckCast(this.k, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        TextView r4 = this.k;
        Intrinsics.checkNotNull(r4);
        return r4;
    }

    private final TextView getTitleViewOrCreate() {
        View r0 = this.c;
        if (r0 == null) goto L8;
        TextView r1 = this.i;
        if (r0 != r1) goto L8;
    L6:
        Intrinsics.checkNotNull(r1);
        return r1;
    L8:
        if (this.i != null) goto L11;
        this.i = f();
    L11:
        if (this.c == null) goto L13;
        e();
    L13:
        addView((View) ZeusTransformUtils.preCheckCast(this.i, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(h(), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        this.c = (View) ZeusTransformUtils.preCheckCast(this.i, View.class, "com.obric.memorydata.plugin");
        r1 = this.i;
        goto L6
    }

    private final RelativeLayout.LayoutParams h() {
        ViewGroup.LayoutParams r2 = generateDefaultLayoutParams();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r3 = (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2, RelativeLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r3.addRule(13);
        return r3;
    }

    public static /* synthetic */ void lambda$nvgZ01JE4_UlLhjXzjVrn5R5CZ0(OCTitleBar r0) {
        a(r0);
    }

    private final void setCenterSubText(String r4) {
        getSubtitleViewOrCreate().setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
        d();
    }

    private final void setCenterText(String r3) {
        getTitleViewOrCreate().setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public final void a(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        a(r4, a(r4, false), getLeftViewCount(), 0);
    }

    public final void a(View r6, RelativeLayout.LayoutParams r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "layoutParams");
        r7.alignWithParent = true;
        r7.leftMargin = r9;
        r6.setId(View.generateViewId());
        if (this.d != null) goto L5;
        r8 = 0;
        r7.addRule(9);
    L15:
        r7.addRule(15);
        List<View> r10 = this.f;
        if (r10 == null) goto L19;
        Intrinsics.checkNotNull(r10);
        if (r8 == r10.size()) goto L19;
    L20:
        getLeftViewListOrCreate().add(r8, r6);
        addView(r6, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L19:
        this.d = r6;
        goto L20
    L5:
        if (r8 < 0) goto L14;
        List<View> r11 = this.f;
        Intrinsics.checkNotNull(r11);
        if (r8 >= r11.size()) goto L14;
        if (r8 != 0) goto L12;
        r7.addRule(9);
        List<View> r3 = this.f;
        Intrinsics.checkNotNull(r3);
        ViewGroup.LayoutParams r4 = ((View) ZeusTransformUtils.preCheckCast(r3.get(r8), View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r12 = (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r4, RelativeLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r12.removeRule(9);
    L13:
        r12.addRule(1, r6.getId());
        goto L15
    L12:
        List<View> r1 = this.f;
        Intrinsics.checkNotNull(r1);
        View r2 = (View) ZeusTransformUtils.preCheckCast(r1.get(r8 - 1), View.class, "com.obric.memorydata.plugin");
        List<View> r5 = this.f;
        Intrinsics.checkNotNull(r5);
        View r13 = (View) ZeusTransformUtils.preCheckCast(r5.get(r8), View.class, "com.obric.memorydata.plugin");
        r7.addRule(1, r2.getId());
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        Objects.requireNonNull(r14, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        r12 = (RelativeLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r14, RelativeLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L14:
        List<View> r15 = this.f;
        Intrinsics.checkNotNull(r15);
        r8 = r15.size();
        View r16 = this.d;
        Intrinsics.checkNotNull(r16);
        r7.addRule(1, r16.getId());
        goto L15
    }

    public final int getLeftViewCount() {
        return a(this.f);
    }

    public final View getMCenterView() {
        return this.c;
    }

    public final OButton getMLeftActionBack() {
        return this.h;
    }

    public final View getMLeftLastView() {
        return this.d;
    }

    public final List<View> getMLeftViewList() {
        return this.f;
    }

    public final View getMRightLastView() {
        return this.e;
    }

    public final List<View> getMRightViewList() {
        return this.g;
    }

    public final TextView getMSubTitleView() {
        return this.k;
    }

    public final TextView getMTitleView() {
        return this.i;
    }

    public final int getRightViewCount() {
        return a(this.g);
    }

    public final String getSubTitleText() {
        return this.l;
    }

    public final String getTitleText() {
        return this.j;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int r4, int r5) {
        super.onMeasure(r4, View.MeasureSpec.makeMeasureSpec((int) ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_h_title_bar_window, "dimen", "oui_h_title_bar_window")), 1073741824));
    }

    public final void setCenterText(int r4) {
        setCenterText(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(r4));
    }

    public final void setCenterView(View r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        a(r2, a(r2, true));
    }

    public final void setMCenterView(View r1) {
        this.c = r1;
    }

    public final void setMLeftActionBack(OButton r1) {
        this.h = r1;
    }

    public final void setMLeftLastView(View r1) {
        this.d = r1;
    }

    public final void setMLeftViewList(List<View> r3) {
        this.f = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setMRightLastView(View r1) {
        this.e = r1;
    }

    public final void setMRightViewList(List<View> r3) {
        this.g = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setMSubTitleView(TextView r1) {
        this.k = r1;
    }

    public final void setMTitleView(TextView r1) {
        this.i = r1;
    }

    public final void setSubTitleText(String r1) {
        this.l = r1;
        setCenterSubText(r1);
    }

    public final void setTitleText(String r1) {
        this.j = r1;
        setCenterText(r1);
    }
}
