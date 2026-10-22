package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\b\u0016\u0018\u0000 q2\u00020\u0001:\u0002qrB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0007J\u000e\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KJ\u0016\u0010L\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u0007J\u000e\u0010O\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0007J\u000e\u0010P\u001a\u00020\u001c2\u0006\u0010G\u001a\u00020\u0007J\u000e\u0010Q\u001a\u00020I2\u0006\u0010J\u001a\u00020KJ\u001e\u0010R\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\u0007J\u0016\u0010U\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\nJ\u0016\u0010V\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\nJ\u0016\u0010W\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\nJ\u0016\u0010X\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\nJ\u0016\u0010Y\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\nJ\u0006\u0010Z\u001a\u00020\u0015J\u0010\u0010[\u001a\u00020I2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\\\u001a\u00020I2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J0\u0010]\u001a\u00020I2\u0006\u0010^\u001a\u0002062\u0006\u0010_\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u0007H\u0014J\u0018\u0010c\u001a\u00020I2\u0006\u0010d\u001a\u00020\u00072\u0006\u0010e\u001a\u00020\u0007H\u0014J\u0006\u0010f\u001a\u00020IJ\b\u0010g\u001a\u00020IH\u0002J\u0006\u0010h\u001a\u00020IJ\u0006\u0010i\u001a\u00020IJ\u000e\u0010j\u001a\u00020I2\u0006\u0010k\u001a\u00020\u0007J\u000e\u0010j\u001a\u00020I2\u0006\u0010l\u001a\u00020<J\u000e\u0010m\u001a\u00020I2\u0006\u0010n\u001a\u00020\u0007J\u0006\u0010o\u001a\u00020IJ\u0006\u0010p\u001a\u00020IR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0001X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0001X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\"X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R$\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020,@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0011\u00102\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00107\u001a\u0002062\u0006\u0010+\u001a\u000206@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R(\u0010=\u001a\u0004\u0018\u00010<2\b\u0010+\u001a\u0004\u0018\u00010<@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR(\u0010B\u001a\u0004\u0018\u00010<2\b\u0010+\u001a\u0004\u0018\u00010<@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010?\"\u0004\bD\u0010A¨\u0006s"}, d2 = {"Lcom/obric/oui/titlebar/OCTitleBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fixedCenterTitleContainer", "Landroid/view/ViewGroup;", "getFixedCenterTitleContainer", "()Landroid/view/ViewGroup;", "setFixedCenterTitleContainer", "(Landroid/view/ViewGroup;)V", "mCenterContainer", "getMCenterContainer", "()Landroid/widget/FrameLayout;", "setMCenterContainer", "(Landroid/widget/FrameLayout;)V", "mCenterTitleView", "Landroid/widget/TextView;", "mFixedCenterContainer", "getMFixedCenterContainer", "setMFixedCenterContainer", "mFixedCenterSubTitleView", "mFixedCenterTitleView", "mLeftActionBack", "Lcom/obric/oui/button/OButton;", "getMLeftActionBack", "()Lcom/obric/oui/button/OButton;", "setMLeftActionBack", "(Lcom/obric/oui/button/OButton;)V", "mLeftContainer", "Landroid/widget/LinearLayout;", "getMLeftContainer", "()Landroid/widget/LinearLayout;", "setMLeftContainer", "(Landroid/widget/LinearLayout;)V", "mLeftTitleView", "mRightContainer", "getMRightContainer", "setMRightContainer", EventBody.KEY_VALUE, "Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "mTitlePosition", "getMTitlePosition", "()Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "setMTitlePosition", "(Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;)V", "mTitleView", "getMTitleView", "()Landroid/widget/TextView;", "minCenterTitleWidth", "", "showLeftBack", "getShowLeftBack", "()Z", "setShowLeftBack", "(Z)V", "", "subTitleText", "getSubTitleText", "()Ljava/lang/String;", "setSubTitleText", "(Ljava/lang/String;)V", "titleText", "getTitleText", "setTitleText", "addLeftImageView", "Landroid/widget/ImageView;", "drawableId", "addLeftView", "", "view", "Landroid/view/View;", "addRightButton", "style", "stringId", "addRightImageView", "addRightTransButton", "addRightView", "createButton", "root", "layoutResId", "createNeutralButton", "createPrimaryButton", "createPrimaryLightButton", "createTransButton", "createTransIconButton", "getTitleView", CommonConsts.APM_INNER_EVENT_COST_INIT, "initAttrs", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshTitleView", "refreshTitleViewIfNeeded", "removeAllLeftViews", "removeAllRightViews", "setCenterText", "resId", "title", "setMinCenterTitleWidth", "minWidth", "startTitleMarquee", "stopTitleMarquee", "Companion", "TitlePosition", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OCTitleBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14729a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f14730b;
    public LinearLayout c;
    public FrameLayout d;
    public FrameLayout e;
    public ViewGroup f;
    public OButton g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private int l;
    private boolean m;
    private String n;
    private String o;
    private TitlePosition p;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/titlebar/OCTitleBar$TitlePosition;", "", EventBody.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "FIXED_CENTER", "FLOW_WITH_ACTION", "LEFT_IN_ACTION", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum TitlePosition extends Enum<TitlePosition> {
        private static final /* synthetic */ TitlePosition[] $VALUES = null;
        public static final TitlePosition FIXED_CENTER = null;
        public static final TitlePosition FLOW_WITH_ACTION = null;
        public static final TitlePosition LEFT_IN_ACTION = null;
        private final int value;

        private static final /* synthetic */ TitlePosition[] $values() {
            return new TitlePosition[]{FIXED_CENTER, FLOW_WITH_ACTION, LEFT_IN_ACTION};
        }

        static {
            FIXED_CENTER = new TitlePosition("FIXED_CENTER", 0, 0);
            FLOW_WITH_ACTION = new TitlePosition("FLOW_WITH_ACTION", 1, 1);
            LEFT_IN_ACTION = new TitlePosition("LEFT_IN_ACTION", 2, 2);
            $VALUES = $values();
        }

        private TitlePosition(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static TitlePosition valueOf(String r2) {
            return (TitlePosition) ZeusTransformUtils.preCheckCast(Enum.valueOf(TitlePosition.class, r2), TitlePosition.class, "com.obric.memorydata.plugin");
        }

        public static TitlePosition[] values() {
            return (TitlePosition[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TitlePosition[].class, "com.obric.memorydata.plugin");
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/oui/titlebar/OCTitleBar$Companion;", "", "()V", "STYLE_HIGHLIGHT_BLUE", "", "STYLE_NORMAL", "STYLE_PRIMARY_BLUE", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14731a = null;

        static {
            int[] r0 = new int[TitlePosition.values().length];
            r0[TitlePosition.FIXED_CENTER.ordinal()] = 1;
            r0[TitlePosition.FLOW_WITH_ACTION.ordinal()] = 2;
            r0[TitlePosition.LEFT_IN_ACTION.ordinal()] = 3;
            f14731a = r0;
        }
    }

    static {
        f14729a = new a(null);
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
        this.l = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 70);
        this.m = true;
        this.p = TitlePosition.FIXED_CENTER;
        a(r6);
        if (r7 == null) goto L6;
        a(r7);
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

    private final void a() {
        TextView r2 = null;
        if (this.p != TitlePosition.LEFT_IN_ACTION) goto L10;
        TextView r3 = this.i;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L8:
        r2.requestLayout();
        return;
    L7:
        r2 = r3;
        goto L8
    L10:
        if (this.p != TitlePosition.FIXED_CENTER) goto L21;
        TextView r0 = this.j;
        if (r0 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r0 = null;
    L14:
        r0.requestLayout();
        TextView r1 = this.k;
        if (r1 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L18:
        r2.requestLayout();
        getMFixedCenterContainer().requestLayout();
        return;
    L17:
        r2 = r1;
        goto L18
    }

    private final void a(Context r5) {
        FrameLayout.inflate((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.o_title_bar_container, "layout", "o_title_bar_container"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.center_title, OaidModel.KEY_ID, "center_title"));
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.center_title)");
        this.h = (TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.memorydata.plugin");
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.left_title, OaidModel.KEY_ID, "left_title"));
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.left_title)");
        this.i = (TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.memorydata.plugin");
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.ll_left_action_container, OaidModel.KEY_ID, "ll_left_action_container"));
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.ll_left_action_container)");
        setMLeftContainer((LinearLayout) ZeusTransformUtils.preCheckCast(r8, LinearLayout.class, "com.obric.memorydata.plugin"));
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.ll_right_action_container, OaidModel.KEY_ID, "ll_right_action_container"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.ll_right_action_container)");
        setMRightContainer((LinearLayout) ZeusTransformUtils.preCheckCast(r9, LinearLayout.class, "com.obric.memorydata.plugin"));
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.fl_center_action_container, OaidModel.KEY_ID, "fl_center_action_container"));
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.fl_center_action_container)");
        setMCenterContainer((FrameLayout) ZeusTransformUtils.preCheckCast(r10, FrameLayout.class, "com.obric.memorydata.plugin"));
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.fl_fixed_center_action_container, OaidModel.KEY_ID, "fl_fixed_center_action_container"));
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.fl_fix…_center_action_container)");
        setMFixedCenterContainer((FrameLayout) ZeusTransformUtils.preCheckCast(r11, FrameLayout.class, "com.obric.memorydata.plugin"));
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.fixed_center_title, OaidModel.KEY_ID, "fixed_center_title"));
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.fixed_center_title)");
        this.j = (TextView) ZeusTransformUtils.preCheckCast(r12, TextView.class, "com.obric.memorydata.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.left_action_back, OaidModel.KEY_ID, "left_action_back"));
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.left_action_back)");
        setMLeftActionBack((OButton) ZeusTransformUtils.preCheckCast(r13, OButton.class, "com.obric.memorydata.plugin"));
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.fixed_center_sub_title, OaidModel.KEY_ID, "fixed_center_sub_title"));
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.fixed_center_sub_title)");
        this.k = (TextView) ZeusTransformUtils.preCheckCast(r14, TextView.class, "com.obric.memorydata.plugin");
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.fixed_center_title_container, OaidModel.KEY_ID, "fixed_center_title_container"));
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.fixed_center_title_container)");
        setFixedCenterTitleContainer((ViewGroup) ZeusTransformUtils.preCheckCast(r15, ViewGroup.class, "com.obric.memorydata.plugin"));
    }

    private final void a(AttributeSet r5) {
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        TypedArray r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme().obtainStyledAttributes(r6, R.styleable.OCTitleBar, 0, 0);
        int r1 = r7.getInt(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_title_pos, "styleable", "OCTitleBar_oui_title_pos"), TitlePosition.FIXED_CENTER.getValue());     // Catch: Throwable -> L6
        setMTitlePosition(TitlePosition.values()[r1]);     // Catch: Throwable -> L6
        setTitleText(r7.getString(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_title_text, "styleable", "OCTitleBar_oui_title_text")));     // Catch: Throwable -> L6
        setShowLeftBack(r7.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_useBackIcon, "styleable", "OCTitleBar_oui_useBackIcon"), true));     // Catch: Throwable -> L6
        setSubTitleText(r7.getString(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_sub_title_text, "styleable", "OCTitleBar_oui_sub_title_text")));     // Catch: Throwable -> L6
        r7.recycle();
        return;
    L6:
        th = move-exception;
        r7.recycle();
        throw th;
    }

    /* JADX INFO: renamed from: lambda$-Pk24BIuKqRC_mXJCv2Ml0bgcfM, reason: not valid java name */
    public static /* synthetic */ void m1383lambda$Pk24BIuKqRC_mXJCv2Ml0bgcfM(OCTitleBar r0) {
        m1384setMinCenterTitleWidth$lambda1(r0);
    }

    /* JADX INFO: renamed from: setMinCenterTitleWidth$lambda-1, reason: not valid java name */
    private static final void m1384setMinCenterTitleWidth$lambda1(OCTitleBar r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.a();
    }

    public final OButton a(int r5) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        OButton r4 = a(r0, (ViewGroup) ZeusTransformUtils.preCheckCast(getMRightContainer(), ViewGroup.class, "com.obric.memorydata.plugin"));
        r4.setButtonSourceBitmap(r5);
        return r4;
    }

    public final OButton a(Context r4, ViewGroup r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r5, "root");
        return a(r6, r5, ZeusTransformUtils.mapRes(R.layout.o_widget_titlebar_trans_button, "layout", "o_widget_titlebar_trans_button"));
    }

    public final OButton a(Context r5, ViewGroup r6, int r7) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "root");
        if (((OButton) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.btn_titlebar, OaidModel.KEY_ID, "btn_titlebar")), OButton.class, "com.obric.memorydata.plugin")) != null) goto L5;
        View r8 = FrameLayout.inflate(r4, r7, r6).findViewById(ZeusTransformUtils.mapRes(R.id.btn_titlebar, OaidModel.KEY_ID, "btn_titlebar"));
        Intrinsics.checkNotNull(r8);
        return (OButton) ZeusTransformUtils.preCheckCast(r8, OButton.class, "com.obric.memorydata.plugin");
    L5:
        View r9 = ZeusTransformUtils.inflate(LayoutInflater.from(r4), r7, r6, false, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r9, "null cannot be cast to non-null type com.obric.oui.button.OButton");
        OButton r10 = (OButton) ZeusTransformUtils.preCheckCast(r9, OButton.class, "com.obric.memorydata.plugin");
        r10.setId(-1);
        r6.addView((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"));
        return r10;
    }

    public final ViewGroup getFixedCenterTitleContainer() {
        ViewGroup r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("fixedCenterTitleContainer");
        return null;
    }

    public final FrameLayout getMCenterContainer() {
        FrameLayout r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
        return null;
    }

    public final FrameLayout getMFixedCenterContainer() {
        FrameLayout r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterContainer");
        return null;
    }

    public final OButton getMLeftActionBack() {
        OButton r0 = this.g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
        return null;
    }

    public final LinearLayout getMLeftContainer() {
        LinearLayout r0 = this.f14730b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
        return null;
    }

    public final LinearLayout getMRightContainer() {
        LinearLayout r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
        return null;
    }

    public final TitlePosition getMTitlePosition() {
        return this.p;
    }

    public final TextView getMTitleView() {
        TitlePosition r0 = this.p;
        int r1 = b.f14731a[r0.ordinal()];
        if (r1 != 1) goto L5;
        TextView r3 = this.j;
        if (r3 != null) goto L21;
        String r4 = "mFixedCenterTitleView";
    L19:
        Intrinsics.throwUninitializedPropertyAccessException(r4);
        return null;
    L21:
        return r3;
    L5:
        if (r1 != 2) goto L7;
        r3 = this.h;
        if (r3 != null) goto L21;
        r4 = "mCenterTitleView";
        goto L19
    L7:
        if (r1 != 3) goto L12;
        r3 = this.i;
        if (r3 != null) goto L21;
        r4 = "mLeftTitleView";
        goto L19
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getShowLeftBack() {
        return this.m;
    }

    public final String getSubTitleText() {
        return this.n;
    }

    public final String getTitleText() {
        return this.o;
    }

    public final TextView getTitleView() {
        return getMTitleView();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r7, int r8) {
        super.onMeasure(r7, r8);
        int r0 = 0;
        TextView r2 = null;
        if (this.p != TitlePosition.LEFT_IN_ACTION) goto L35;
        TextView r9 = this.i;
        if (r9 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r9 = null;
    L7:
        int r3 = ((getMeasuredWidth() - getMRightContainer().getMeasuredWidth()) - getMLeftContainer().getPaddingLeft()) - getMLeftContainer().getPaddingRight();
        TextView r4 = this.i;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r4 = null;
    L10:
        ViewGroup.LayoutParams r5 = ((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.MarginLayoutParams.class) == true) goto L13;
        r5 = null;
    L13:
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L16;
        int r10 = r6.rightMargin;
    L17:
        int r11 = r3 - r10;
        TextView r12 = this.i;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r12 = null;
    L20:
        ViewGroup.LayoutParams r13 = ((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r13, ViewGroup.MarginLayoutParams.class) == true) goto L23;
        r13 = null;
    L23:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r13, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L26;
        r0 = r1.rightMargin;
    L26:
        int r14 = r11 - r0;
        TextView r15 = this.i;
        if (r15 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r15 = null;
    L29:
        int r16 = r14 - r15.getPaddingLeft();
        TextView r17 = this.i;
        if (r17 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L33:
        r9.setMaxWidth(r16 - r2.getPaddingRight());
        return;
    L32:
        r2 = r17;
        goto L33
    L16:
        r10 = 0;
        goto L17
    L35:
        if (this.p == TitlePosition.FIXED_CENTER) goto L37;
        return;
    L37:
        if (getMLeftContainer().getVisibility() != 0) goto L46;
        int r18 = getMLeftContainer().getMeasuredWidth();
        ViewGroup.LayoutParams r19 = ((View) ZeusTransformUtils.preCheckCast(getMLeftContainer(), View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r19, ViewGroup.MarginLayoutParams.class) == true) goto L41;
        r19 = null;
    L41:
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r19, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L44;
        int r21 = r20.leftMargin;
    L45:
        int r22 = r18 + r21;
    L48:
        if (getMRightContainer().getVisibility() != 0) goto L57;
        int r23 = getMRightContainer().getMeasuredWidth();
        ViewGroup.LayoutParams r24 = ((View) ZeusTransformUtils.preCheckCast(getMRightContainer(), View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r24, ViewGroup.MarginLayoutParams.class) == true) goto L52;
        r24 = null;
    L52:
        ViewGroup.MarginLayoutParams r25 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r24, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r25 == null) goto L55;
        int r26 = r25.rightMargin;
    L56:
        int r27 = r23 + r26;
    L58:
        int r28 = Math.max(r22, r27);
        if (getMFixedCenterContainer().getVisibility() != 0) goto L96;
        ViewGroup.LayoutParams r29 = ((View) ZeusTransformUtils.preCheckCast(getMFixedCenterContainer(), View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r29, ViewGroup.MarginLayoutParams.class) == true) goto L63;
        r29 = null;
    L63:
        ViewGroup.MarginLayoutParams r30 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r29, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r30 == null) goto L66;
        int r31 = r30.leftMargin;
    L67:
        ViewGroup.LayoutParams r32 = ((View) ZeusTransformUtils.preCheckCast(getMFixedCenterContainer(), View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r32, ViewGroup.MarginLayoutParams.class) == true) goto L70;
        r32 = null;
    L70:
        ViewGroup.MarginLayoutParams r33 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r32, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r33 == null) goto L73;
        r0 = r33.rightMargin;
    L73:
        int r34 = Math.max((getMeasuredWidth() - (r28 * 2)) - (r31 + r0), this.l);
        TextView r35 = this.j;
        if (r35 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r35 = null;
    L76:
        TextView r36 = this.j;
        if (r36 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r36 = null;
    L79:
        int r37 = r36.getPaddingLeft() + r34;
        TextView r38 = this.j;
        if (r38 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r38 = null;
    L82:
        r35.setMaxWidth(r37 + r38.getPaddingRight());
        TextView r39 = this.k;
        if (r39 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r39 = null;
    L85:
        TextView r40 = this.k;
        if (r40 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r40 = null;
    L88:
        int r41 = r34 + r40.getPaddingLeft();
        TextView r42 = this.k;
        if (r42 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L92:
        r39.setMaxWidth(r41 + r2.getPaddingRight());
        return;
    L91:
        r2 = r42;
        goto L92
    L66:
        r31 = 0;
        goto L67
    L96:
        return;
    L55:
        r26 = 0;
        goto L56
    L57:
        r27 = 0;
        goto L58
    L44:
        r21 = 0;
        goto L45
    L46:
        r22 = 0;
        goto L48
    }

    public final void setCenterText(int r2) {
        String r3 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "resources.getString(resId)");
        setTitleText(r3);
    }

    public final void setCenterText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "title");
        setTitleText(r2);
    }

    public final void setFixedCenterTitleContainer(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public final void setMCenterContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setMFixedCenterContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public final void setMLeftActionBack(OButton r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    public final void setMLeftContainer(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f14730b = r2;
    }

    public final void setMRightContainer(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setMTitlePosition(TitlePosition r8) {
        Intrinsics.checkNotNullParameter(r8, EventBody.KEY_VALUE);
        this.p = r8;
        int r9 = b.f14731a[r8.ordinal()];
        TextView r6 = null;
        if (r9 != 1) goto L5;
        TextView r10 = this.j;
        if (r10 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r10 = null;
    L32:
        r10.setVisibility(0);
        TextView r11 = this.h;
        if (r11 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r11 = null;
    L35:
        r11.setVisibility(8);
        TextView r12 = this.i;
        if (r12 != null) goto L38;
    L37:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L39:
        r6.setVisibility(8);
    L40:
        getMTitleView().setText((CharSequence) ZeusTransformUtils.preCheckCast(this.o, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L38:
        r6 = r12;
        goto L39
    L5:
        if (r9 != 2) goto L7;
        TextView r13 = this.j;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r13 = null;
    L23:
        r13.setVisibility(8);
        TextView r14 = this.h;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r14 = null;
    L26:
        r14.setVisibility(0);
        r12 = this.i;
        if (r12 != null) goto L38;
    L7:
        if (r9 != 3) goto L40;
        TextView r15 = this.j;
        if (r15 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r15 = null;
    L12:
        r15.setVisibility(8);
        TextView r16 = this.h;
        if (r16 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r16 = null;
    L15:
        r16.setVisibility(8);
        TextView r17 = this.i;
        if (r17 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L19:
        r6.setVisibility(0);
        setShowLeftBack(false);
        goto L40
    L18:
        r6 = r17;
        goto L19
    }

    public final void setMinCenterTitleWidth(int r3) {
        this.l = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r3);
        post(new $$Lambda$OCTitleBar$Pk24BIuKqRC_mXJCv2Ml0bgcfM(this));
    }

    public final void setShowLeftBack(boolean r3) {
        this.m = r3;
        OButton r0 = getMLeftActionBack();
        if (r3 == false) goto L5;
        int r4 = 0;
    L6:
        r0.setVisibility(r4);
        if (this.p != TitlePosition.LEFT_IN_ACTION) goto L10;
        getMLeftActionBack().setVisibility(8);
        return;
    L10:
        return;
    L5:
        r4 = 8;
        goto L6
    }

    public final void setSubTitleText(String r6) {
        this.n = r6;
        TextView r1 = null;
        if (r6 != null) goto L9;
        TextView r5 = this.k;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L8:
        r1.setVisibility(8);
        return;
    L7:
        r1 = r5;
        goto L8
    L9:
        TextView r2 = this.k;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r2 = null;
    L12:
        r2.setVisibility(0);
        TextView r3 = this.k;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r3 = null;
    L15:
        r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration().fontScale <= 1.0f) goto L25;
        TextView r7 = this.j;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r7 = null;
    L20:
        r7.setTextSize(1, 16.0f);
        TextView r8 = this.k;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L24:
        r1.setTextSize(1, 12.0f);
        goto L25
    L23:
        r1 = r8;
    L25:
        a();
    }

    public final void setTitleText(String r4) {
        this.o = r4;
        if (r4 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
        a();
    }
}
