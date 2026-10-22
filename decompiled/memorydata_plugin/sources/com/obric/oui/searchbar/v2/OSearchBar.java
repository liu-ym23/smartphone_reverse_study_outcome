package com.obric.oui.searchbar.v2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.c.a.b;
import com.obric.oui.c.i;
import com.obric.oui.color.d;
import com.obric.oui.common.style.f;
import com.obric.oui.common.style.k;
import com.obric.oui.common.util.o;
import com.obric.oui.forms.OEditText;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.c;
import com.obric.oui.material.h;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001fB\u001b\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\rH\u0016J\u0010\u00106\u001a\u0002042\u0006\u00107\u001a\u00020\nH\u0016J\b\u00108\u001a\u0004\u0018\u000109J\b\u0010:\u001a\u0004\u0018\u00010;J\b\u0010<\u001a\u0004\u0018\u00010;J\u0006\u0010=\u001a\u00020>J\u0018\u0010?\u001a\u0002042\u0006\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020\rH\u0016J\u0012\u0010D\u001a\u0002042\b\u0010E\u001a\u0004\u0018\u00010FH\u0014J\u0012\u0010G\u001a\u0004\u0018\u0001092\u0006\u0010H\u001a\u00020\nH\u0002J\u0012\u0010I\u001a\u0002042\b\u0010J\u001a\u0004\u0018\u00010;H\u0016J\u000e\u0010K\u001a\u0002042\u0006\u0010L\u001a\u00020\rJ\u0010\u0010M\u001a\u0002042\b\u0010N\u001a\u0004\u0018\u000109J\u0010\u0010O\u001a\u0002042\u0006\u0010P\u001a\u00020\rH\u0016J\u000e\u0010Q\u001a\u0002042\u0006\u0010R\u001a\u00020SJ\u0010\u0010T\u001a\u0002042\b\u0010J\u001a\u0004\u0018\u00010;J\u0010\u0010U\u001a\u0002042\b\u0010J\u001a\u0004\u0018\u00010;J\u000e\u0010V\u001a\u0002042\u0006\u0010W\u001a\u00020(J\u0010\u0010X\u001a\u0002042\u0006\u0010Y\u001a\u00020\nH\u0016J\u0010\u0010Z\u001a\u0002042\u0006\u0010 \u001a\u00020\rH\u0016J\b\u0010[\u001a\u000204H\u0002J\b\u0010\\\u001a\u000204H\u0002J\u0010\u0010]\u001a\u0002042\u0006\u0010^\u001a\u00020_H\u0002J\u001a\u0010`\u001a\u0002042\u0006\u0010a\u001a\u00020_2\b\b\u0002\u0010b\u001a\u00020\rH\u0002J\b\u0010c\u001a\u000204H\u0002J\u0014\u0010d\u001a\u000204*\u00020;2\u0006\u0010e\u001a\u00020\nH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0018\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010,\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/obric/oui/searchbar/v2/OSearchBar;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/MaterialOwner;", "Lcom/obric/oui/common/style/ODynamicThemeWidget;", "originContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bgColor", "", "bgColorResting", "canShowClear", "", "clearAction", "Landroid/widget/ImageView;", "clearActionContainer", "Landroid/view/ViewGroup;", "currentMaterials", "", "Lcom/obric/oui/material/MaterialConfig;", "[Lcom/obric/oui/material/MaterialConfig;", "currentTheme", "getCurrentTheme", "()I", "setCurrentTheme", "(I)V", "enabledMaterial", "inputView", "Lcom/obric/oui/forms/OEditText;", "getInputView", "()Lcom/obric/oui/forms/OEditText;", "isBackdropView", "()Z", "setBackdropView", "(Z)V", "leftContainer", "Landroid/widget/FrameLayout;", "materialSrcType", "materialToken", "", "materialTokenResting", "materialsActive", "materialsResting", "rightContainer", "searchBarContainer", "Lcom/obric/oui/layout/OUILinearLayout;", "shadowsNormal", "", "Lcom/obric/oui/common/style/Shadow;", "shadowsResting", "applyContentMaterial", "", "apply", "applyDynamicTheme", "themeStyle", "getEllipsize", "Landroid/text/TextUtils$TruncateAt;", "getPostfixView", "Landroid/view/View;", "getPrefixView", "getText", "", "initShadows", "context", "typedArray", "Landroid/content/res/TypedArray;", "isDarkTheme", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "parseEllipsize", EventBody.KEY_VALUE, "setBackdropTarget", "view", "setCanShowClear", "show", "setEllipsize", "where", "setEnabled", "enabled", "setOnInputFocusChange", "onFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "setPostfixView", "setPrefixView", "setText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "updateBackdropSrcType", "srcType", "updateBackdropTargetType", "updateClear", "updateInputViewPadding", "updateMaterials", "state", "Lcom/obric/oui/searchbar/v2/OSearchBar$Companion$SearchBarState;", "updateShadows", "currentState", "showShadow", "updateStateInternal", "updateViewWidth", "newWidth", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSearchBar extends OUIFrameLayout implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f14414a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OUILinearLayout f14415b;
    private boolean c;
    private final OEditText d;
    private final FrameLayout e;
    private final FrameLayout f;
    private final ViewGroup g;
    private final ImageView h;
    private boolean i;
    private List<k> j;
    private List<k> k;
    private int l;
    private int m;
    private boolean n;
    private String o;
    private String p;
    private c[] q;
    private c[] r;
    private c[] s;
    private int t;
    private int u;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/searchbar/v2/OSearchBar$Companion;", "", "()V", "TAG", "", "SearchBarState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/searchbar/v2/OSearchBar$Companion$SearchBarState;", "", "(Ljava/lang/String;I)V", "RESTING", "ACTIVE", "VALUE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum SearchBarState extends Enum<SearchBarState> {
            private static final /* synthetic */ SearchBarState[] $VALUES = null;
            public static final SearchBarState ACTIVE = null;
            public static final SearchBarState RESTING = null;
            public static final SearchBarState VALUE = null;

            private static final /* synthetic */ SearchBarState[] $values() {
                return new SearchBarState[]{RESTING, ACTIVE, VALUE};
            }

            static {
                RESTING = new SearchBarState("RESTING", 0);
                ACTIVE = new SearchBarState("ACTIVE", 1);
                VALUE = new SearchBarState("VALUE", 2);
                $VALUES = $values();
            }

            private SearchBarState(String r1, int r2) {
                super(r1, r2);
            }

            public static SearchBarState valueOf(String r2) {
                return (SearchBarState) ZeusTransformUtils.preCheckCast(Enum.valueOf(SearchBarState.class, r2), SearchBarState.class, "com.obric.memorydata.plugin");
            }

            public static SearchBarState[] values() {
                return (SearchBarState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SearchBarState[].class, "com.obric.memorydata.plugin");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14416a = null;

        static {
            int[] r0 = new int[Companion.SearchBarState.values().length];
            r0[Companion.SearchBarState.RESTING.ordinal()] = 1;
            r0[Companion.SearchBarState.ACTIVE.ordinal()] = 2;
            r0[Companion.SearchBarState.VALUE.ordinal()] = 3;
            f14416a = r0;
        }
    }

    static {
        f14414a = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OSearchBar(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "originContext");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public OSearchBar(Context r25, AttributeSet r26) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r25, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r26, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "originContext");
        super(r1, r9, 0, null, 12, null);
        this.c = true;
        this.i = true;
        this.t = -1;
        FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.o_widget_search_bar_v2, "layout", "o_widget_search_bar_v2"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        setChangeAlphaWhenPress(false);
        if (l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")) == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.n = r3;
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.searchbar_container, OaidModel.KEY_ID, "searchbar_container"));
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.searchbar_container)");
        this.f14415b = (OUILinearLayout) ZeusTransformUtils.preCheckCast(r4, OUILinearLayout.class, "com.obric.memorydata.plugin");
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.input_view, OaidModel.KEY_ID, "input_view"));
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.input_view)");
        OEditText r6 = (OEditText) ZeusTransformUtils.preCheckCast(r5, OEditText.class, "com.obric.memorydata.plugin");
        this.d = r6;
        r6.onOnTouchEvent$OUI_standardRelease((Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Function1.class, "com.obric.memorydata.plugin"));
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.left_container, OaidModel.KEY_ID, "left_container"));
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.left_container)");
        FrameLayout r8 = (FrameLayout) ZeusTransformUtils.preCheckCast(r7, FrameLayout.class, "com.obric.memorydata.plugin");
        this.e = r8;
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.right_container, OaidModel.KEY_ID, "right_container"));
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.right_container)");
        FrameLayout r11 = (FrameLayout) ZeusTransformUtils.preCheckCast(r10, FrameLayout.class, "com.obric.memorydata.plugin");
        this.f = r11;
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.clear_action_container, OaidModel.KEY_ID, "clear_action_container"));
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.clear_action_container)");
        ViewGroup r13 = (ViewGroup) ZeusTransformUtils.preCheckCast(r12, ViewGroup.class, "com.obric.memorydata.plugin");
        this.g = r13;
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.clear_action, OaidModel.KEY_ID, "clear_action"));
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.clear_action)");
        ImageView r15 = (ImageView) ZeusTransformUtils.preCheckCast(r14, ImageView.class, "com.obric.memorydata.plugin");
        this.h = r15;
        Context r16 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r16, "context");
        int[] r17 = R.styleable.OSearchBar;
        Intrinsics.checkNotNullExpressionValue(r17, "OSearchBar");
        TypedArray r18 = r16.obtainStyledAttributes(r9, r17, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r18, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        OUILinearLayout r19 = null;
        this.l = r18.getColor(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_widgetBgColor, "styleable", "OSearchBar_oui_widgetBgColor"), ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_searchbar_bg, TypedValues.Custom.S_COLOR, "oui_searchbar_bg"), null));
        this.m = r18.getColor(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_widgetBgColorResting, "styleable", "OSearchBar_oui_widgetBgColorResting"), ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_searchbar_bg_resting, TypedValues.Custom.S_COLOR, "oui_searchbar_bg_resting"), null));
        getInputView().setTextColor(r18.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_widgetTextColor, "styleable", "OSearchBar_oui_widgetTextColor")));
        ColorStateList r0 = r18.getColorStateList(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_widgetTextColorHint, "styleable", "OSearchBar_oui_widgetTextColorHint"));
        getInputView().setHintTextColor(r0);
        r15.setImageTintList(r0);
        getInputView().setHint((CharSequence) ZeusTransformUtils.preCheckCast(r18.getString(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_android_hint, "styleable", "OSearchBar_android_hint")), CharSequence.class, "com.obric.memorydata.plugin"));
        getInputView().setText((CharSequence) ZeusTransformUtils.preCheckCast(r18.getString(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_android_text, "styleable", "OSearchBar_android_text")), CharSequence.class, "com.obric.memorydata.plugin"));
        if (r18.hasValue(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_android_ellipsize, "styleable", "OSearchBar_android_ellipsize")) == false) goto L11;
        int r2 = 0;
        setEllipsize(a(r18.getInt(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_android_ellipsize, "styleable", "OSearchBar_android_ellipsize"), 0)));
    L12:
        int r20 = r18.getLayoutDimension(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_android_layout_height, "styleable", "OSearchBar_android_layout_height"), r2);
        if (r20 > 0) goto L15;
        b.e("OSearchBar", Intrinsics.stringPlus("searchBarHeight must be greater than 0, ", Integer.valueOf(r20)));
    L15:
        int r21 = r18.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_search_postfixView, "styleable", "OSearchBar_oui_search_postfixView"), r2);
        if (r21 == 0) goto L18;
        FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r21, (ViewGroup) ZeusTransformUtils.preCheckCast(r11, ViewGroup.class, "com.obric.memorydata.plugin"));
        o.a((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"));
    L18:
        int r22 = r18.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_search_prefixView, "styleable", "OSearchBar_oui_search_prefixView"), ZeusTransformUtils.mapRes(R.layout.o_widget_search_bar_prefix_v2, "layout", "o_widget_search_bar_prefix_v2"));
        if (r22 == 0) goto L21;
        FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r22, (ViewGroup) ZeusTransformUtils.preCheckCast(r8, ViewGroup.class, "com.obric.memorydata.plugin"));
        o.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"));
        a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), r20);
    L21:
        a((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.memorydata.plugin"), r20);
        r13.setOnClickListener(new $$Lambda$OSearchBar$y11qD1Qcr1WhoBcRJtqKQ8jAu4(this));
        Context r23 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r23, "context");
        a(r23, r18);
        if (this.n == false) goto L24;
        this.t = r18.getInt(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_widgetMaterialSrcType, "styleable", "OSearchBar_oui_widgetMaterialSrcType"), -1);
        this.n = r18.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_widgetEnableMaterial, "styleable", "OSearchBar_oui_widgetEnableMaterial"), false);
    L24:
        boolean r24 = a();
        if (this.n == false) goto L52;
        String r27 = r18.getString(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_widgetMaterial, "styleable", "OSearchBar_oui_widgetMaterial"));
        this.p = r27;
        if (r27 != null) goto L29;
        this.p = ZeusTransformUtils.getResources(r18, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.oui_material_bg_floating, TypedValues.Custom.S_STRING, "oui_material_bg_floating"));
    L29:
        this.o = r18.getString(ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_widgetMaterialResting, "styleable", "OSearchBar_oui_widgetMaterialResting"));
        this.q = MaterialToken.parseSet(this.p, !r24);
        String r28 = this.o;
        if (r28 == null) goto L32;
        c[] r29 = MaterialToken.parseSet(r28, !r24);
    L33:
        this.r = r29;
        if (r29 != null) goto L36;
        r29 = this.q;
    L36:
        this.s = r29;
        if (r29 != null) goto L39;
        Unit r30 = null;
    L50:
        if (r30 != null) goto L52;
        this.n = false;
        goto L52
    L39:
        setBackground(null);
        int r31 = this.t;
        if (r31 != (-1)) goto L43;
        r31 = 2;
    L43:
        int r210 = r31;
        OUILinearLayout r32 = this.f14415b;
        if (r32 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r32 = null;
    L46:
        GradientDrawable r33 = new GradientDrawable();
        r33.setShape(0);
        r33.setCornerRadius(com.obric.oui.common.util.h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 99));
        r33.setColor(0);
        r32.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r33, Drawable.class, "com.obric.memorydata.plugin"));
        OUILinearLayout r34 = this.f14415b;
        if (r34 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r34 = null;
    L49:
        l.a((View) ZeusTransformUtils.preCheckCast(r34, View.class, "com.obric.memorydata.plugin"), r29, false, r210, null, 10, null);
        r30 = Unit.INSTANCE;
        goto L50
    L32:
        r29 = null;
    L52:
        r18.recycle();
        if ((!a()) == false) goto L58;
        OUILinearLayout r35 = this.f14415b;
        if (r35 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r35 = null;
    L57:
        Resources r36 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        int r37 = R.color.oui_basic_fill_element_2_light;
        String r38 = "oui_basic_fill_element_2_light";
    L62:
        r35.setOverridePressColor(r36.getColor(ZeusTransformUtils.mapRes(r37, TypedValues.Custom.S_COLOR, r38)));
        OUILinearLayout r39 = this.f14415b;
        if (r39 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
    L66:
        r19.refreshColors("OSearchBar");
        r6.onTextChanged$OUI_standardRelease((Function4) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this), Function4.class, "com.obric.memorydata.plugin"));
        r6.onFocusChange$OUI_standardRelease((Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this), Function1.class, "com.obric.memorydata.plugin"));
        b();
        d();
        return;
    L65:
        r19 = r39;
        goto L66
    L58:
        r35 = this.f14415b;
        if (r35 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r35 = null;
    L61:
        r36 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        r37 = R.color.oui_basic_fill_element_2_dark;
        r38 = "oui_basic_fill_element_2_dark";
        goto L62
    L11:
        r2 = 0;
        goto L12
    L5:
        if (OMaterialHelper.d() == false) goto L7;
        r3 = true;
        goto L8
    }

    public /* synthetic */ OSearchBar(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    private final TextUtils.TruncateAt a(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L17;
        return null;
    L17:
        return TextUtils.TruncateAt.MARQUEE;
    L18:
        return TextUtils.TruncateAt.END;
    L19:
        return TextUtils.TruncateAt.MIDDLE;
    L15:
        return TextUtils.TruncateAt.START;
    }

    public static final /* synthetic */ OUILinearLayout a(OSearchBar r0) {
        return r0.f14415b;
    }

    private final void a(Context r4, TypedArray r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        List<k> r0 = f.a(r6, r5, ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_widgetShadowNormal, "styleable", "OSearchBar_oui_widgetShadowNormal"));
        if (r0 == null) goto L5;
        this.j = r0;
    L5:
        List<k> r7 = f.a(r6, r5, ZeusTransformUtils.mapRes(R.styleable.OSearchBar_oui_widgetShadowResting, "styleable", "OSearchBar_oui_widgetShadowResting"));
        if (r7 == null) goto L9;
        this.k = r7;
        return;
    }

    private final void a(View r1, int r2) {
        if (r2 > 0) goto L5;
        b.e("OSearchBar", Intrinsics.stringPlus("newWidth must be greater than 0, ", Integer.valueOf(r2)));
        return;
    L5:
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        r0.width = r2;
        r1.setLayoutParams(r0);
    }

    private final void a(Companion.SearchBarState r8) {
        if (this.n == true) goto L6;
        return;
    L6:
        if (r8 != Companion.SearchBarState.RESTING) goto L9;
        c[] r9 = this.r;
        if (r9 == null) goto L9;
    L10:
        c[] r1 = r9;
        this.s = r1;
        if (r1 == null) goto L22;
        int r10 = this.t;
        if (r10 != (-1)) goto L17;
        r10 = 2;
    L17:
        int r3 = r10;
        OUILinearLayout r7 = this.f14415b;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r7 = null;
    L20:
        l.a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"), r1, false, r3, null, 10, null);
        return;
    L22:
        return;
    L9:
        r9 = this.q;
        goto L10
    }

    private final void a(Companion.SearchBarState r5, boolean r6) {
        if (this.j != null) goto L6;
        setShadow(k.f13496b, k.f13496b, false);
        return;
    L6:
        int r0 = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 99);
        setShadowCornerRadius(r0);
        OUILinearLayout r3 = this.f14415b;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r3 = null;
    L9:
        r3.setRadius(r0);
        if (r6 == true) goto L12;
    L18:
        k r7 = k.f13496b;
        k r8 = k.f13496b;
    L19:
        setShadow(r7, r8, true);
        return;
    L12:
        if (a.f14416a[r5.ordinal()] != 1) goto L16;
        List<k> r9 = this.k;
        if (r9 == null) goto L18;
        Intrinsics.checkNotNull(r9);
        r7 = (k) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r9, 0), k.class, "com.obric.memorydata.plugin");
        List<k> r10 = this.k;
    L17:
        Intrinsics.checkNotNull(r10);
        r8 = (k) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r10, 1), k.class, "com.obric.memorydata.plugin");
        goto L19
    L16:
        List<k> r11 = this.j;
        Intrinsics.checkNotNull(r11);
        r7 = (k) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r11, 0), k.class, "com.obric.memorydata.plugin");
        r10 = this.j;
        goto L17
    }

    private static final void a(OSearchBar r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.d.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void a(OSearchBar r0, Companion.SearchBarState r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.a(r1, r2);
    }

    private final void b() {
        if (this.d.hasFocus() == false) goto L5;
        Companion.SearchBarState r0 = Companion.SearchBarState.ACTIVE;
    L15:
        int r3 = a.f14416a[r0.ordinal()];
        if (r3 == 1) goto L34;
        if (r3 == 2) goto L27;
        if (r3 == 3) goto L22;
    L41:
        a(r0);
        return;
    L22:
        if (this.n == true) goto L32;
        OUILinearLayout r4 = this.f14415b;
        if (r4 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r4 = null;
    L31:
        r4.setBackgroundColor(this.l);
    L32:
        this.e.setSelected(true);
    L40:
        a(this, r0, false, 2, null);
        goto L41
    L27:
        if (this.n == true) goto L32;
        r4 = this.f14415b;
        if (r4 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r4 = null;
        goto L31
    L34:
        if (this.n == true) goto L39;
        OUILinearLayout r1 = this.f14415b;
        if (r1 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r1 = null;
    L38:
        r1.setBackgroundColor(this.m);
    L39:
        this.e.setSelected(false);
        goto L40
    L5:
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(this.d.getText(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L14;
        r0 = Companion.SearchBarState.RESTING;
        goto L15
    L14:
        r0 = Companion.SearchBarState.VALUE;
        goto L15
    L8:
        if (r2.length() == 0) goto L11;
        r5 = false;
        goto L12
    }

    public static final /* synthetic */ void b(OSearchBar r0) {
        r0.c();
    }

    private final void c() {
        int r1 = 8;
        boolean r2 = true;
        if (this.i == true) goto L6;
        ViewGroup r0 = this.g;
    L5:
        r0.setVisibility(r1);
        if (((View) ZeusTransformUtils.preCheckCast(this.g, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L18;
        boolean r3 = true;
    L19:
        if (r3 == false) goto L22;
        o.b((View) ZeusTransformUtils.preCheckCast(this.f, View.class, "com.obric.memorydata.plugin"));
    L27:
        d();
        return;
    L22:
        if (((ViewGroup) ZeusTransformUtils.preCheckCast(this.f, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount() != 0) goto L25;
        r2 = false;
    L25:
        if (r2 == false) goto L27;
        o.a((View) ZeusTransformUtils.preCheckCast(this.f, View.class, "com.obric.memorydata.plugin"));
        goto L27
    L18:
        r3 = false;
        goto L19
    L6:
        r0 = this.g;
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(this.d.getText(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == true) goto L5;
        r1 = 0;
        goto L5
    L9:
        if (r5.length() == 0) goto L12;
        r6 = false;
        goto L13
    }

    public static final /* synthetic */ void c(OSearchBar r0) {
        r0.b();
    }

    private final void d() {
        if (this.e.getVisibility() != 0) goto L5;
        int r0 = 0;
    L6:
        boolean r4 = true;
        if (((View) ZeusTransformUtils.preCheckCast(this.g, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
    L18:
        int r1 = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0);
    L19:
        this.d.setPaddingRelative(r0, 0, r1, 0);
        return;
    L12:
        if (((View) ZeusTransformUtils.preCheckCast(this.f, View.class, "com.obric.memorydata.plugin")).getVisibility() == 0) goto L15;
        r4 = false;
    L15:
        if (r4 == true) goto L18;
        r1 = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8);
        goto L19
    L9:
        r3 = false;
        goto L10
    L5:
        r0 = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12);
        goto L6
    }

    /* JADX INFO: renamed from: lambda$y11qD1Qcr1Who-BcRJtqKQ8jAu4, reason: not valid java name */
    public static /* synthetic */ void m1356lambda$y11qD1Qcr1WhoBcRJtqKQ8jAu4(OSearchBar r0, View r1) {
        a(r0, r1);
    }

    public boolean a() {
        int r0 = this.l;
        if (r0 != 0) goto L7;
        return i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
    L7:
        if (this.u != 2) goto L9;
    L12:
        return true;
    L9:
        if (d.a(r0) == true) goto L12;
        return false;
    }

    @Override // com.obric.oui.material.h
    public void b(int r3) {
        this.t = r3;
        OUILinearLayout r2 = this.f14415b;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        r2 = null;
    L5:
        l.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"), r3);
    }

    public final int getCurrentTheme() {
        return this.u;
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.d.getEllipsize();
    }

    public final OEditText getInputView() {
        return this.d;
    }

    public final View getPostfixView() {
        if (((ViewGroup) ZeusTransformUtils.preCheckCast(this.f, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return null;
    L10:
        return this.f.getChildAt(0);
    L5:
        r0 = false;
        goto L6
    }

    public final View getPrefixView() {
        if (((ViewGroup) ZeusTransformUtils.preCheckCast(this.e, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return null;
    L10:
        return this.e.getChildAt(0);
    L5:
        r0 = false;
        goto L6
    }

    public final CharSequence getText() {
        Editable r2 = this.d.getText();
        if (r2 != null) goto L5;
        Object r3 = ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
    L7:
        return (CharSequence) r3;
    L5:
        r3 = ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        goto L7
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        this.q = MaterialToken.parseSet(this.p, !i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")));
        String r4 = this.o;
        if (r4 == null) goto L5;
        c[] r5 = MaterialToken.parseSet(r4, !i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")));
    L6:
        this.r = r5;
        b();
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.obric.oui.material.h
    public void setBackdropTarget(View r3) {
        l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r3);
    }

    public final void setBackdropView(boolean r1) {
        this.c = r1;
    }

    public final void setCanShowClear(boolean r1) {
        this.i = r1;
        c();
    }

    public final void setCurrentTheme(int r1) {
        this.u = r1;
    }

    public final void setEllipsize(TextUtils.TruncateAt r1) {
        this.d.setEllipsize(r1);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r2) {
        this.d.setEnabled(r2);
        super.setEnabled(r2);
    }

    public final void setOnInputFocusChange(View.OnFocusChangeListener r3) {
        View.OnFocusChangeListener r4 = (View.OnFocusChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnFocusChangeListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onFocusChangeListener");
        this.d.setOnFocusChangeListener(r4);
    }

    public final void setPostfixView(View r3) {
        this.f.removeAllViews();
        if (r3 != null) goto L5;
        o.b((View) ZeusTransformUtils.preCheckCast(this.f, View.class, "com.obric.memorydata.plugin"));
    L6:
        d();
        return;
    L5:
        this.f.addView(r3);
        o.a((View) ZeusTransformUtils.preCheckCast(this.f, View.class, "com.obric.memorydata.plugin"));
        goto L6
    }

    public final void setPrefixView(View r3) {
        this.e.removeAllViews();
        if (r3 != null) goto L5;
        o.b((View) ZeusTransformUtils.preCheckCast(this.e, View.class, "com.obric.memorydata.plugin"));
    L6:
        d();
        return;
    L5:
        r3.setDuplicateParentStateEnabled(true);
        this.e.addView(r3);
        o.a((View) ZeusTransformUtils.preCheckCast(this.e, View.class, "com.obric.memorydata.plugin"));
        goto L6
    }

    public final void setText(String r3) {
        Intrinsics.checkNotNullParameter(r3, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        this.d.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }
}
