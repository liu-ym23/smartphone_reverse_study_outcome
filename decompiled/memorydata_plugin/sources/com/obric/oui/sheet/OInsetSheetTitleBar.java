package com.obric.oui.sheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
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
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0016\u0018\u0000 j2\u00020\u0001:\u0002jkB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0007J\u0016\u0010G\u001a\u00020 2\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0007J\u000e\u0010J\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0007J\u000e\u0010K\u001a\u00020 2\u0006\u0010F\u001a\u00020\u0007J\u000e\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OJ\u001e\u0010P\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0007J\u0016\u0010T\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020RJ\u0016\u0010U\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020RJ\u0016\u0010V\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020RJ\u0016\u0010W\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020RJ\u0006\u0010X\u001a\u00020\u0016J\u0010\u0010Y\u001a\u00020M2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010Z\u001a\u00020M2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J0\u0010[\u001a\u00020M2\u0006\u0010\\\u001a\u0002082\u0006\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u0007H\u0014J\u0018\u0010a\u001a\u00020M2\u0006\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0007H\u0014J\u0006\u0010d\u001a\u00020MJ\u0006\u0010e\u001a\u00020MJ\u000e\u0010f\u001a\u00020M2\u0006\u0010g\u001a\u00020\u0007J\u000e\u0010f\u001a\u00020M2\u0006\u0010h\u001a\u00020\nJ\u0006\u0010i\u001a\u00020MR(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0001X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0001X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u000e\u0010\u001d\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020&X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R$\u00100\u001a\u00020/2\u0006\u0010\t\u001a\u00020/@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0011\u00105\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b6\u00107R$\u00109\u001a\u0002082\u0006\u0010\t\u001a\u000208@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R(\u0010>\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000fR(\u0010A\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010\u000f¨\u0006l"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheetTitleBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", EventBody.KEY_VALUE, "", "desText", "getDesText", "()Ljava/lang/String;", "setDesText", "(Ljava/lang/String;)V", "mCenterContainer", "getMCenterContainer", "()Landroid/widget/FrameLayout;", "setMCenterContainer", "(Landroid/widget/FrameLayout;)V", "mCenterTitleView", "Landroid/widget/TextView;", "mDesContainerView", "mDesTextView", "Lcom/obric/oui/text/OTextView;", "mFixedCenterContainer", "getMFixedCenterContainer", "setMFixedCenterContainer", "mFixedCenterSubTitleView", "mFixedCenterTitleView", "mLeftActionBack", "Lcom/obric/oui/button/OButton;", "getMLeftActionBack", "()Lcom/obric/oui/button/OButton;", "setMLeftActionBack", "(Lcom/obric/oui/button/OButton;)V", "mLeftContainer", "Landroid/widget/LinearLayout;", "getMLeftContainer", "()Landroid/widget/LinearLayout;", "setMLeftContainer", "(Landroid/widget/LinearLayout;)V", "mLeftTitleView", "mRightContainer", "getMRightContainer", "setMRightContainer", "Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", "mTitlePosition", "getMTitlePosition", "()Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", "setMTitlePosition", "(Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;)V", "mTitleView", "getMTitleView", "()Landroid/widget/TextView;", "", "showLeftBack", "getShowLeftBack", "()Z", "setShowLeftBack", "(Z)V", "subTitleText", "getSubTitleText", "setSubTitleText", "titleText", "getTitleText", "setTitleText", "addLeftImageView", "Landroid/widget/ImageView;", "drawableId", "addRightButton", "style", "stringId", "addRightImageView", "addRightTransButton", "addRightView", "", "view", "Landroid/view/View;", "createButton", "root", "Landroid/view/ViewGroup;", "layoutResId", "createNeutralButton", "createPrimaryLightButton", "createTransButton", "createUnderstatedButton", "getTitleView", CommonConsts.APM_INNER_EVENT_COST_INIT, "initAttrs", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "removeAllLeftViews", "removeAllRightViews", "setCenterText", "resId", "title", "sheetTitleBarStyle", "Companion", "TitlePosition", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OInsetSheetTitleBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14469a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f14470b;
    public LinearLayout c;
    public FrameLayout d;
    public FrameLayout e;
    public OButton f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private FrameLayout k;
    private OTextView l;
    private boolean m;
    private String n;
    private String o;
    private String p;
    private TitlePosition q;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheetTitleBar$TitlePosition;", "", EventBody.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "FIXED_CENTER", "FLOW_WITH_ACTION", "LEFT_IN_ACTION", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheetTitleBar$Companion;", "", "()V", "STYLE_AREA_ONLY_ICON", "", "STYLE_BACK", "STYLE_CUSTOM_BACKGROUND", "STYLE_DELETE", "STYLE_HIGHLIGHT_BLUE", "STYLE_HIGHLIGHT_RED", "STYLE_MIX", "STYLE_NORMAL", "STYLE_NORMAL_WITH_ICON", "STYLE_SEARCH", "STYLE_SETTING", "STYLE_TNT_3_BLUE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
        public static final /* synthetic */ int[] f14471a = null;

        static {
            int[] r0 = new int[TitlePosition.values().length];
            r0[TitlePosition.FIXED_CENTER.ordinal()] = 1;
            r0[TitlePosition.FLOW_WITH_ACTION.ordinal()] = 2;
            r0[TitlePosition.LEFT_IN_ACTION.ordinal()] = 3;
            f14471a = r0;
        }
    }

    static {
        f14469a = new a(null);
    }

    public OInsetSheetTitleBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OInsetSheetTitleBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OInsetSheetTitleBar(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.m = true;
        this.q = TitlePosition.FIXED_CENTER;
        a(r6);
        if (r7 == null) goto L6;
        a(r7);
        return;
    }

    public /* synthetic */ OInsetSheetTitleBar(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    private final void a(Context r5) {
        FrameLayout.inflate((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.o_sheet_title_bar_container, "layout", "o_sheet_title_bar_container"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.center_title, OaidModel.KEY_ID, "center_title"));
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.center_title)");
        this.g = (TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.memorydata.plugin");
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.left_title, OaidModel.KEY_ID, "left_title"));
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.left_title)");
        this.h = (TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.memorydata.plugin");
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
        this.i = (TextView) ZeusTransformUtils.preCheckCast(r12, TextView.class, "com.obric.memorydata.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.left_action_back, OaidModel.KEY_ID, "left_action_back"));
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.left_action_back)");
        setMLeftActionBack((OButton) ZeusTransformUtils.preCheckCast(r13, OButton.class, "com.obric.memorydata.plugin"));
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.fixed_center_sub_title, OaidModel.KEY_ID, "fixed_center_sub_title"));
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.fixed_center_sub_title)");
        this.j = (TextView) ZeusTransformUtils.preCheckCast(r14, TextView.class, "com.obric.memorydata.plugin");
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.sheet_title_bar_des, OaidModel.KEY_ID, "sheet_title_bar_des"));
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.sheet_title_bar_des)");
        this.k = (FrameLayout) ZeusTransformUtils.preCheckCast(r15, FrameLayout.class, "com.obric.memorydata.plugin");
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.sheet_title_bar_des_text, OaidModel.KEY_ID, "sheet_title_bar_des_text"));
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.sheet_title_bar_des_text)");
        OTextView r17 = (OTextView) ZeusTransformUtils.preCheckCast(r16, OTextView.class, "com.obric.memorydata.plugin");
        this.l = r17;
        if (r17 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDesTextView");
        r17 = null;
    L5:
        r17.setEnableAutoAlignLeft(true);
    }

    private final void a(AttributeSet r5) {
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        TypedArray r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme().obtainStyledAttributes(r6, R.styleable.OCTitleBar, 0, 0);
        int r1 = r7.getInt(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_title_pos, "styleable", "OCTitleBar_oui_title_pos"), TitlePosition.FIXED_CENTER.getValue());     // Catch: Throwable -> L6
        setMTitlePosition(TitlePosition.values()[r1]);     // Catch: Throwable -> L6
        setTitleText(r7.getString(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_title_text, "styleable", "OCTitleBar_oui_title_text")));     // Catch: Throwable -> L6
        setDesText(r7.getString(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_title_des_text, "styleable", "OCTitleBar_oui_title_des_text")));     // Catch: Throwable -> L6
        setShowLeftBack(r7.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_useBackIcon, "styleable", "OCTitleBar_oui_useBackIcon"), true));     // Catch: Throwable -> L6
        setSubTitleText(r7.getString(ZeusTransformUtils.mapRes(R.styleable.OCTitleBar_oui_sub_title_text, "styleable", "OCTitleBar_oui_sub_title_text")));     // Catch: Throwable -> L6
        r7.recycle();
        return;
    L6:
        th = move-exception;
        r7.recycle();
        throw th;
    }

    public final String getDesText() {
        return this.p;
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
        OButton r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
        return null;
    }

    public final LinearLayout getMLeftContainer() {
        LinearLayout r0 = this.f14470b;
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
        return this.q;
    }

    public final TextView getMTitleView() {
        TitlePosition r0 = this.q;
        int r1 = b.f14471a[r0.ordinal()];
        if (r1 != 1) goto L5;
        TextView r3 = this.i;
        if (r3 != null) goto L21;
        String r4 = "mFixedCenterTitleView";
    L19:
        Intrinsics.throwUninitializedPropertyAccessException(r4);
        return null;
    L21:
        return r3;
    L5:
        if (r1 != 2) goto L7;
        r3 = this.g;
        if (r3 != null) goto L21;
        r4 = "mCenterTitleView";
        goto L19
    L7:
        if (r1 != 3) goto L12;
        r3 = this.h;
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
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
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

    public final void setDesText(String r6) {
        this.p = r6;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        OTextView r4 = null;
        FrameLayout r5 = null;
        if (r1 == false) goto L16;
        FrameLayout r7 = this.k;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mDesContainerView");
    L15:
        r5.setVisibility(8);
        return;
    L14:
        r5 = r7;
        goto L15
    L16:
        FrameLayout r2 = this.k;
        if (r2 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mDesContainerView");
        r2 = null;
    L19:
        r2.setVisibility(0);
        OTextView r8 = this.l;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mDesTextView");
    L23:
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L22:
        r4 = r8;
        goto L23
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
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
        this.f = r2;
    }

    public final void setMLeftContainer(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f14470b = r2;
    }

    public final void setMRightContainer(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setMTitlePosition(TitlePosition r8) {
        Intrinsics.checkNotNullParameter(r8, EventBody.KEY_VALUE);
        this.q = r8;
        int r9 = b.f14471a[r8.ordinal()];
        TextView r6 = null;
        if (r9 != 1) goto L5;
        TextView r10 = this.i;
        if (r10 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r10 = null;
    L32:
        r10.setVisibility(0);
        TextView r11 = this.g;
        if (r11 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r11 = null;
    L35:
        r11.setVisibility(8);
        TextView r12 = this.h;
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
        TextView r13 = this.i;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r13 = null;
    L23:
        r13.setVisibility(8);
        TextView r14 = this.g;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r14 = null;
    L26:
        r14.setVisibility(0);
        r12 = this.h;
        if (r12 != null) goto L38;
    L7:
        if (r9 != 3) goto L40;
        TextView r15 = this.i;
        if (r15 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r15 = null;
    L12:
        r15.setVisibility(8);
        TextView r16 = this.g;
        if (r16 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r16 = null;
    L15:
        r16.setVisibility(8);
        TextView r17 = this.h;
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

    public final void setShowLeftBack(boolean r3) {
        this.m = r3;
        OButton r0 = getMLeftActionBack();
        if (r3 == false) goto L5;
        int r4 = 0;
    L6:
        r0.setVisibility(r4);
        if (this.q != TitlePosition.LEFT_IN_ACTION) goto L10;
        getMLeftActionBack().setVisibility(8);
        return;
    L10:
        return;
    L5:
        r4 = 8;
        goto L6
    }

    public final void setSubTitleText(String r5) {
        this.n = r5;
        TextView r0 = null;
        if (r5 != null) goto L9;
        TextView r4 = this.j;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L8:
        r0.setVisibility(8);
        return;
    L7:
        r0 = r4;
        goto L8
    L9:
        TextView r2 = this.j;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r2 = null;
    L12:
        r2.setVisibility(0);
        TextView r6 = this.j;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L16:
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L15:
        r0 = r6;
        goto L16
    }

    public final void setTitleText(String r3) {
        this.o = r3;
        if (r3 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }
}
