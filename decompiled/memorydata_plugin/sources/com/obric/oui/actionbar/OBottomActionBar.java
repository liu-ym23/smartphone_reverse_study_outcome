package com.obric.oui.actionbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.c.c;
import com.obric.oui.divider.ODivider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "请根据设计稿，使用 v2 包下的对应样式的 OBottomActionBar(Floating/NormalHorizontal/NormalVertical) 代替")
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001:\u000245B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u0010\u001b\u001a\u00020\u00182\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u0010\u001c\u001a\u00020\u00182\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J0\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0016H\u0014J\u0018\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0016H\u0014J\u0018\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010)\u001a\u00020\u0018H\u0002J\u0010\u0010*\u001a\u00020\u00182\b\u0010+\u001a\u0004\u0018\u00010\u0011JC\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u001f2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u0001012\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u000101¢\u0006\u0002\u00103R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/obric/oui/actionbar/OBottomActionBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "actionButtons", "", "Lcom/obric/oui/button/OButton;", "contentView", "Landroid/view/View;", "dividerView", "Lcom/obric/oui/divider/ODivider;", "onClickListener", "Lcom/obric/oui/actionbar/OBottomActionBar$OnBottomButtonClickListener;", "rootView", "Landroid/widget/LinearLayout;", "getButton", "index", "", "initButtons", "", "config", "Lcom/obric/oui/actionbar/OBottomActionBar$OBABConfig;", "initImgButton", "initNormalButton", "onLayout", "changed", "", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "performButtonClick", "button", "resetLayoutStatus", "setBottomButtonClickListener", "l", "updateStyle", "hasDivider", "buttonStyle", "lastPrimary", "buttonTexts", "", "buttonImgIds", "(ZLjava/lang/String;Z[Ljava/lang/String;[Ljava/lang/Integer;)V", "OBABConfig", "OnBottomButtonClickListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OBottomActionBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13275b;
    private final LinearLayout c;
    private final ODivider d;
    private b e;
    private List<OButton> f;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bHÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\bHÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/actionbar/OBottomActionBar$OBABConfig;", "", "hasDivider", "", "lastPrimary", "buttonStyle", "", "buttonTexts", "", "buttonImgIds", "", "(ZZLjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getButtonImgIds", "()Ljava/util/List;", "getButtonStyle", "()Ljava/lang/String;", "getButtonTexts", "getHasDivider", "()Z", "getLastPrimary", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f13276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f13277b;
        private final String c;
        private final List<String> d;
        private final List<Integer> e;

        public a(boolean r3, boolean r4, String r5, List<String> r6, List<Integer> r7) {
            List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            List<Integer> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "buttonStyle");
            this.f13276a = r3;
            this.f13277b = r4;
            this.c = r5;
            this.d = r8;
            this.e = r9;
        }

        public final boolean a() {
            return this.f13276a;
        }

        public final boolean b() {
            return this.f13277b;
        }

        public final String c() {
            return this.c;
        }

        public final List<String> d() {
            return this.d;
        }

        public final List<Integer> e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f13276a == r6.f13276a) goto L12;
            return false;
        L12:
            if (this.f13277b == r6.f13277b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8 */
        public int hashCode() {
            boolean r0 = this.f13276a;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.f13277b;
            if (r4 == true) goto L9;
            r1 = r4;
        L9:
            int r5 = (((r3 + r1) * 31) + this.c.hashCode()) * 31;
            List<String> r6 = this.d;
            int r7 = 0;
            if (r6 != null) goto L12;
            int r8 = 0;
        L13:
            int r9 = (r5 + r8) * 31;
            List<Integer> r10 = this.e;
            if (r10 == null) goto L18;
            r7 = r10.hashCode();
        L18:
            return r9 + r7;
        L12:
            r8 = r6.hashCode();
            goto L13
        }

        public String toString() {
            return "OBABConfig(hasDivider=" + this.f13276a + ", lastPrimary=" + this.f13277b + ", buttonStyle=" + this.c + ", buttonTexts=" + this.d + ", buttonImgIds=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/actionbar/OBottomActionBar$OnBottomButtonClickListener;", "", "onClick", "", "button", "Landroid/view/View;", "index", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface b {
        void a(View r1, int r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OBottomActionBar(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public OBottomActionBar(Context r11, AttributeSet r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14);
        this.f13274a = "OBottomActionBar";
        FrameLayout.inflate(r13, ZeusTransformUtils.mapRes(R.layout.o_widget_bottom_action_bar, "layout", "o_widget_bottom_action_bar"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"));
        setBackgroundColor(ContextCompat.getColor(r13, ZeusTransformUtils.mapRes(R.color.Transparent, TypedValues.Custom.S_COLOR, "Transparent")));
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.root_layout, OaidModel.KEY_ID, "root_layout"));
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.root_layout)");
        this.c = (LinearLayout) ZeusTransformUtils.preCheckCast(r0, LinearLayout.class, "com.obric.memorydata.plugin");
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.top_divider, OaidModel.KEY_ID, "top_divider"));
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.top_divider)");
        this.d = (ODivider) ZeusTransformUtils.preCheckCast(r1, ODivider.class, "com.obric.memorydata.plugin");
        TypedArray r15 = r13.getTheme().obtainStyledAttributes(r14, R.styleable.OBottomActionBar, 0, 0);
        boolean r5 = r15.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_hasDivider, "styleable", "OBottomActionBar_oui_hasDivider"), true);
        boolean r6 = r15.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_buttonLastPrimary, "styleable", "OBottomActionBar_oui_buttonLastPrimary"), false);
        String r16 = r15.getString(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_buttonStyle, "styleable", "OBottomActionBar_oui_buttonStyle"));
        int r3 = r15.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_buttonTexts, "styleable", "OBottomActionBar_oui_buttonTexts"), 0);
        int r2 = r15.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_buttonImgIds, "styleable", "OBottomActionBar_oui_buttonImgIds"), 0);
        if (r3 != 0) goto L5;
        List r8 = null;
    L6:
        if (r2 != 0) goto L8;
        List r9 = null;
    L12:
        if (r16 != null) goto L14;
        r16 = "l1";
    L14:
        a r17 = new a(r5, r6, r16, r8, r9);
        r15.recycle();
        a(r17);
        return;
    L8:
        TypedArray r4 = ZeusTransformUtils.getResources(r15, "com.obric.memorydata.plugin").obtainTypedArray(r2);
        Intrinsics.checkNotNullExpressionValue(r4, "resources.obtainTypedArray(buttonImg)");
        ArrayList r7 = new ArrayList();
        int r10 = r4.length();
        int r18 = 0;
    L9:
        if (r18 >= r10) goto L11;
        r7.add(Integer.valueOf(r4.getResourceId(r18, 0)));
        r18 = r18 + 1;
        goto L9
    L11:
        List r19 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin"));
        r4.recycle();
        r9 = r19;
        goto L12
    L5:
        String[] r20 = ZeusTransformUtils.getResources(r15, "com.obric.memorydata.plugin").getStringArray(r3);
        Intrinsics.checkNotNullExpressionValue(r20, "resources.getStringArray(buttonResourceId)");
        r8 = ArraysKt.toMutableList(r20);
        goto L6
    }

    public /* synthetic */ OBottomActionBar(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    private final void a(View r1, int r2) {
        b r0 = this.e;
        if (r0 == null) goto L7;
        r0.a(r1, r2);
        return;
    }

    private final void a(a r20) {
        String r2 = r20.c();
        int r3 = r2.hashCode();
        if (r3 != (-1612256902)) goto L5;
        Object r17 = "img";
        if (r2.equals("l1-primary") == false) goto L41;
        this.f13275b = FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.o_widget_bottom_action_bar_l1_primary, "layout", "o_widget_bottom_action_bar_l1_primary"), null);
        this.c.addView(this.f13275b, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_L1_primary, OaidModel.KEY_ID, "action_button_L1_primary"));
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.action_button_L1_primary)");
        List<OButton> r1 = CollectionsKt.mutableListOf(new OButton[]{(OButton) ZeusTransformUtils.preCheckCast(r4, OButton.class, "com.obric.memorydata.plugin")});
    L39:
        this.f = r1;
    L41:
        if (r20.c().compareTo(r17) != 0) goto L43;
        b(this.f, r20);
    L44:
        boolean r5 = r20.a();
        ODivider r0 = this.d;
        if (r5 == false) goto L47;
        int r6 = 0;
    L48:
        r0.setVisibility(r6);
        return;
    L47:
        r6 = 8;
        goto L48
    L43:
        a(this.f, r20);
        goto L44
    L5:
        if (r3 == 3397) goto L31;
        r17 = "img";
        if (r3 == 104387) goto L28;
        if (r3 == 678742426) goto L24;
        if (r3 == 3428) goto L20;
        if (r3 != 3429) goto L41;
        if (r2.equals("m2") == false) goto L41;
        this.f13275b = FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.o_widget_bottom_action_bar_m2, "layout", "o_widget_bottom_action_bar_m2"), null);
        this.c.addView(this.f13275b, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_m20, OaidModel.KEY_ID, "action_button_m20"));
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.action_button_m20)");
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_m21, OaidModel.KEY_ID, "action_button_m21"));
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.action_button_m21)");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_m22, OaidModel.KEY_ID, "action_button_m22"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.action_button_m22)");
        r1 = CollectionsKt.mutableListOf(new OButton[]{(OButton) ZeusTransformUtils.preCheckCast(r7, OButton.class, "com.obric.memorydata.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r8, OButton.class, "com.obric.memorydata.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r9, OButton.class, "com.obric.memorydata.plugin")});
        goto L39
    L20:
        if (r2.equals("m1") == false) goto L41;
        this.f13275b = FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.o_widget_bottom_action_bar_m1, "layout", "o_widget_bottom_action_bar_m1"), null);
        this.c.addView(this.f13275b, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_0, OaidModel.KEY_ID, "action_button_0"));
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.action_button_0)");
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_1, OaidModel.KEY_ID, "action_button_1"));
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.action_button_1)");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_2, OaidModel.KEY_ID, "action_button_2"));
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.action_button_2)");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_3, OaidModel.KEY_ID, "action_button_3"));
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.action_button_3)");
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_4, OaidModel.KEY_ID, "action_button_4"));
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.action_button_4)");
        r1 = CollectionsKt.mutableListOf(new OButton[]{(OButton) ZeusTransformUtils.preCheckCast(r10, OButton.class, "com.obric.memorydata.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r11, OButton.class, "com.obric.memorydata.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r12, OButton.class, "com.obric.memorydata.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r13, OButton.class, "com.obric.memorydata.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r14, OButton.class, "com.obric.memorydata.plugin")});
        goto L39
    L24:
        if (r2.equals("m2-primary") == false) goto L41;
        this.f13275b = FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.o_widget_bottom_action_bar_m2_primary, "layout", "o_widget_bottom_action_bar_m2_primary"), null);
        this.c.addView(this.f13275b, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_m2_primary0, OaidModel.KEY_ID, "action_button_m2_primary0"));
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.action_button_m2_primary0)");
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_m2_primary1, OaidModel.KEY_ID, "action_button_m2_primary1"));
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.action_button_m2_primary1)");
        r1 = CollectionsKt.mutableListOf(new OButton[]{(OButton) ZeusTransformUtils.preCheckCast(r15, OButton.class, "com.obric.memorydata.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r16, OButton.class, "com.obric.memorydata.plugin")});
        goto L39
    L28:
        if (r2.equals(r17) == true) goto L30;
        r17 = r17;
        goto L41
    L30:
        r17 = r17;
        this.f13275b = FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.o_widget_bottom_action_bar_img, "layout", "o_widget_bottom_action_bar_img"), null);
        this.c.addView(this.f13275b, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        View r18 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_0, OaidModel.KEY_ID, "action_button_0"));
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.action_button_0)");
        View r19 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_1, OaidModel.KEY_ID, "action_button_1"));
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.action_button_1)");
        View r21 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_2, OaidModel.KEY_ID, "action_button_2"));
        Intrinsics.checkNotNullExpressionValue(r21, "findViewById(R.id.action_button_2)");
        View r22 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_3, OaidModel.KEY_ID, "action_button_3"));
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.action_button_3)");
        View r23 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_4, OaidModel.KEY_ID, "action_button_4"));
        Intrinsics.checkNotNullExpressionValue(r23, "findViewById(R.id.action_button_4)");
        View r24 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_5, OaidModel.KEY_ID, "action_button_5"));
        Intrinsics.checkNotNullExpressionValue(r24, "findViewById(R.id.action_button_5)");
        r1 = CollectionsKt.mutableListOf(new OButton[]{(OButton) ZeusTransformUtils.preCheckCast(r18, OButton.class, "com.obric.memorydata.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r19, OButton.class, "com.obric.memorydata.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r21, OButton.class, "com.obric.memorydata.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r22, OButton.class, "com.obric.memorydata.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r23, OButton.class, "com.obric.memorydata.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r24, OButton.class, "com.obric.memorydata.plugin")});
        goto L39
    L31:
        r17 = "img";
        if (r2.equals("l1") == false) goto L41;
        this.f13275b = FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.layout.o_widget_bottom_action_bar_l1, "layout", "o_widget_bottom_action_bar_l1"), null);
        this.c.addView(this.f13275b, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        View r25 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_L10, OaidModel.KEY_ID, "action_button_L10"));
        Intrinsics.checkNotNullExpressionValue(r25, "findViewById(R.id.action_button_L10)");
        View r26 = findViewById(ZeusTransformUtils.mapRes(R.id.action_button_L11, OaidModel.KEY_ID, "action_button_L11"));
        Intrinsics.checkNotNullExpressionValue(r26, "findViewById(R.id.action_button_L11)");
        r1 = CollectionsKt.mutableListOf(new OButton[]{(OButton) ZeusTransformUtils.preCheckCast(r25, OButton.class, "com.obric.memorydata.plugin"), (OButton) ZeusTransformUtils.preCheckCast(r26, OButton.class, "com.obric.memorydata.plugin")});
        goto L39
    }

    private static final void a(OBottomActionBar r1, int r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullExpressionValue(r3, "it");
        r1.a(r3, r2);
    }

    private final void a(List<OButton> r10, a r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L5;
        return;
    L5:
        final int r3 = 0;
        if (r11.d() == null) goto L13;
        int r0 = Math.min(r11.d().size(), r12.size());
        if (r11.d().size() <= r12.size()) goto L10;
        Log.e(this.f13274a, Intrinsics.stringPlus("Exceeded the maximum number of buttons Max is ", Integer.valueOf(r12.size())));
    L10:
        int r4 = r0 - 1;
        int r5 = 0;
    L11:
        if (r5 >= r0) goto L14;
        ((OButton) ZeusTransformUtils.preCheckCast(r12.get(r5), OButton.class, "com.obric.memorydata.plugin")).setVisibility(0);
        ((OButton) ZeusTransformUtils.preCheckCast(r12.get(r5), OButton.class, "com.obric.memorydata.plugin")).setText((CharSequence) ZeusTransformUtils.preCheckCast(r11.d().get(r5), CharSequence.class, "com.obric.memorydata.plugin"));
        r5 = r5 + 1;
    L14:
        if (r4 != (-1)) goto L17;
        r4 = r12.size() - 1;
    L17:
        if (r11.b() == false) goto L27;
        ((OButton) ZeusTransformUtils.preCheckCast(r12.get(r4), OButton.class, "com.obric.memorydata.plugin")).setBackgroundColor(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_accent_bg_high_contrast, TypedValues.Custom.S_COLOR, "oui_accent_bg_high_contrast")));
        ((OButton) ZeusTransformUtils.preCheckCast(r12.get(r4), OButton.class, "com.obric.memorydata.plugin")).setTextColor(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_on_accent_default, TypedValues.Custom.S_COLOR, "oui_on_accent_default")));
        c r13 = c.f13403a;
        Object r14 = r12.get(r4);
        if (r14 != null) goto L22;
    L20:
        r14 = null;
    L23:
        com.obric.oui.common.style.a r15 = (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(r14, com.obric.oui.common.style.a.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L27;
        r15.refreshColors(this.f13274a);
        goto L27
    L22:
        if (ZeusTransformUtils.instanceOf(r14, com.obric.oui.common.style.a.class) == false) goto L20;
    L27:
        if (r4 < 0) goto L32;
    L28:
        int r16 = r3 + 1;
        ((OButton) ZeusTransformUtils.preCheckCast(r12.get(r3), OButton.class, "com.obric.memorydata.plugin")).setOnClickListener(new $$Lambda$OBottomActionBar$fCRb5LalbjdpRfvH6CPnJadwYpE(this, r3));
        if (r3 == r4) goto L35;
        r3 = r16;
        goto L28
    L35:
        return;
    L32:
        return;
    L13:
        r4 = -1;
        goto L14
    }

    private static final void b(OBottomActionBar r1, int r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullExpressionValue(r3, "it");
        r1.a(r3, r2);
    }

    private final void b(List<OButton> r10, a r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L5;
        return;
    L5:
        final int r3 = 0;
        if (r11.e() == null) goto L13;
        int r0 = Math.min(r11.e().size(), r12.size());
        if (r11.e().size() <= r12.size()) goto L10;
        Log.e(this.f13274a, Intrinsics.stringPlus("Exceeded the maximum number of buttons Max is ", Integer.valueOf(r12.size())));
    L10:
        int r4 = r0 - 1;
        int r5 = 0;
    L11:
        if (r5 >= r0) goto L14;
        ((OButton) ZeusTransformUtils.preCheckCast(r12.get(r5), OButton.class, "com.obric.memorydata.plugin")).setVisibility(0);
        ((OButton) ZeusTransformUtils.preCheckCast(r12.get(r5), OButton.class, "com.obric.memorydata.plugin")).setButtonSourceBitmap(((Number) ZeusTransformUtils.preCheckCast(r11.e().get(r5), Number.class, "com.obric.memorydata.plugin")).intValue());
        r5 = r5 + 1;
    L14:
        if (r4 != (-1)) goto L16;
        r4 = r12.size() - 1;
    L16:
        if (r4 < 0) goto L21;
    L17:
        int r13 = r3 + 1;
        ((OButton) ZeusTransformUtils.preCheckCast(r12.get(r3), OButton.class, "com.obric.memorydata.plugin")).setOnClickListener(new $$Lambda$OBottomActionBar$s5vsOvoHdeunqEEHL8J2ybEhcA(this, r3));
        if (r3 == r4) goto L24;
        r3 = r13;
        goto L17
    L24:
        return;
    L21:
        return;
    L13:
        r4 = -1;
        goto L14
    }

    public static /* synthetic */ void lambda$fCRb5LalbjdpRfvH6CPnJadwYpE(OBottomActionBar r0, int r1, View r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$s5vsOvoHdeunqEEHL-8J2ybEhcA, reason: not valid java name */
    public static /* synthetic */ void m1253lambda$s5vsOvoHdeunqEEHL8J2ybEhcA(OBottomActionBar r0, int r1, View r2) {
        b(r0, r1, r2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public final void setBottomButtonClickListener(b r3) {
        this.e = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }
}
