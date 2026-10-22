package com.obric.oui.coachmark;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 T2\u00020\u0001:\u0002STB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010(\u001a\u00020)2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u000eH\u0002J\b\u0010,\u001a\u00020\u0010H\u0002J\b\u0010-\u001a\u00020\u000eH\u0002J\u0010\u0010.\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u000100J\u000e\u00101\u001a\u00020)2\u0006\u00102\u001a\u00020\nJ\u0010\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020\u0007H\u0016J\u000e\u00105\u001a\u00020)2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\u0010J/\u00108\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;H\u0007¢\u0006\u0002\u0010<J\u0010\u0010=\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u000100J\u0010\u0010>\u001a\u00020)2\b\u0010?\u001a\u0004\u0018\u00010@J\u0010\u0010A\u001a\u00020)2\b\u0010B\u001a\u0004\u0018\u00010CJ\u0010\u0010D\u001a\u00020)2\b\u0010B\u001a\u0004\u0018\u00010CJ\u0010\u0010E\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u000100J\u0010\u0010F\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u000100J\u000e\u0010G\u001a\u00020)2\u0006\u0010H\u001a\u00020\u000eJ\u000e\u0010I\u001a\u00020)2\u0006\u0010'\u001a\u00020\u000eJ\b\u0010J\u001a\u00020)H\u0002J\b\u0010K\u001a\u00020)H\u0002J\b\u0010L\u001a\u00020)H\u0002J\b\u0010M\u001a\u00020)H\u0002J\b\u0010N\u001a\u00020)H\u0002J\b\u0010O\u001a\u00020)H\u0002J\b\u0010P\u001a\u00020)H\u0002J\u0010\u0010Q\u001a\u00020)2\u0006\u0010R\u001a\u00020\u000eH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkTipView;", "Lcom/obric/oui/layout/OUILinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionType", "Lcom/obric/oui/coachmark/OCoachmarkTipView$ActionType;", "backgroundColor", "Ljava/lang/Integer;", "closable", "", "customCornerRadius", "", "Ljava/lang/Float;", "descText", "Lcom/obric/oui/text/OTextView;", "hasXmlBackground", "inlineAction", "Lcom/obric/oui/button/OButton;", "inlineContainer", "Landroid/view/View;", "inlineDismiss", "Lcom/obric/oui/button/OIconButton;", "inlineIcon", "Landroid/widget/ImageView;", "inlineText", "multiAction", "multiActions", "multiContainer", "multiDismiss", "multiIcon", "multiLeadingRow", "Landroid/widget/LinearLayout;", "multiTextGroup", "showIcon", "singleLine", "applyAttributes", "", "applyPadding", "multiLine", "effectiveCornerRadius", "isMultiLine", "setActionText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "setActionType", "type", "setBackgroundColor", TypedValues.Custom.S_COLOR, "setClosable", "setCornerRadius", "radius", "setDescription", "maxLines", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "(Ljava/lang/CharSequence;Ljava/lang/Integer;Landroid/text/TextUtils$TruncateAt;)V", "setDismissText", "setIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "setOnActionClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOnDismissClickListener", "setPrimaryButtonText", "setSecondaryButtonText", "setShowIcon", "show", "setSingleLine", "updateActionButtonStyle", "updateBackground", "updateIconVisibility", "updateInlineActions", "updateLayout", "updateLeadingVisibility", "updateMultiActions", "updateMultiLeadingAlignment", "hasActions", "ActionType", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCoachmarkTipView extends OUILinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13459a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f13460b;
    private final ImageView c;
    private final OTextView d;
    private final OButton e;
    private final OIconButton f;
    private final View g;
    private final LinearLayout h;
    private final ImageView i;
    private final View j;
    private final OTextView k;
    private final View l;
    private final OButton m;
    private final OButton n;
    private boolean o;
    private boolean p;
    private ActionType q;
    private boolean r;
    private Integer s;
    private boolean t;
    private Float u;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkTipView$ActionType;", "", EventBody.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "PRIMARY", "NEUTRAL", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ActionType extends Enum<ActionType> {
        private static final /* synthetic */ ActionType[] $VALUES = null;
        public static final a Companion = null;
        public static final ActionType NEUTRAL = null;
        public static final ActionType PRIMARY = null;
        private final int value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkTipView$ActionType$Companion;", "", "()V", "fromValue", "Lcom/obric/oui/coachmark/OCoachmarkTipView$ActionType;", EventBody.KEY_VALUE, "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }

            public final ActionType a(int r6) {
                ActionType[] r5 = ActionType.values();
                int r0 = r5.length;
                int r2 = 0;
            L3:
                if (r2 >= r0) goto L11;
                ActionType r3 = r5[r2];
                if (r3.getValue() != r6) goto L7;
                boolean r4 = true;
            L8:
                if (r4 == true) goto L12;
                r2 = r2 + 1;
            L12:
                if (r3 == null) goto L14;
                return r3;
            L14:
                return ActionType.PRIMARY;
            L7:
                r4 = false;
                goto L8
            L11:
                r3 = null;
                goto L12
            }
        }

        private static final /* synthetic */ ActionType[] $values() {
            return new ActionType[]{PRIMARY, NEUTRAL};
        }

        static {
            PRIMARY = new ActionType("PRIMARY", 0, 0);
            NEUTRAL = new ActionType("NEUTRAL", 1, 1);
            $VALUES = $values();
            Companion = new a(null);
        }

        private ActionType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static ActionType valueOf(String r2) {
            return (ActionType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ActionType.class, r2), ActionType.class, "com.obric.memorydata.plugin");
        }

        public static ActionType[] values() {
            return (ActionType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ActionType[].class, "com.obric.memorydata.plugin");
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/coachmark/OCoachmarkTipView$Companion;", "", "()V", "MULTI_LINE_RADIUS_DP", "", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
        public static final /* synthetic */ int[] f13461a = null;

        static {
            int[] r0 = new int[ActionType.values().length];
            r0[ActionType.PRIMARY.ordinal()] = 1;
            r0[ActionType.NEUTRAL.ordinal()] = 2;
            f13461a = r0;
        }
    }

    static {
        f13459a = new a(null);
    }

    public OCoachmarkTipView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OCoachmarkTipView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OCoachmarkTipView(Context r10, AttributeSet r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r12, null, 8, null);
        this.o = true;
        this.q = ActionType.PRIMARY;
        setOrientation(1);
        ZeusTransformUtils.inflate(LayoutInflater.from(r13), ZeusTransformUtils.mapRes(R.layout.o_coachmark_tip, "layout", "o_coachmark_tip"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), true, "com.obric.memorydata.plugin");
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.inline_container, OaidModel.KEY_ID, "inline_container"));
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.inline_container)");
        this.f13460b = r15;
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_inline_icon, OaidModel.KEY_ID, "iv_inline_icon"));
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.iv_inline_icon)");
        this.c = (ImageView) ZeusTransformUtils.preCheckCast(r16, ImageView.class, "com.obric.memorydata.plugin");
        View r17 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_inline_text, OaidModel.KEY_ID, "tv_inline_text"));
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.tv_inline_text)");
        this.d = (OTextView) ZeusTransformUtils.preCheckCast(r17, OTextView.class, "com.obric.memorydata.plugin");
        View r18 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_inline_action, OaidModel.KEY_ID, "btn_inline_action"));
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.btn_inline_action)");
        this.e = (OButton) ZeusTransformUtils.preCheckCast(r18, OButton.class, "com.obric.memorydata.plugin");
        View r19 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_inline_dismiss, OaidModel.KEY_ID, "btn_inline_dismiss"));
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.btn_inline_dismiss)");
        this.f = (OIconButton) ZeusTransformUtils.preCheckCast(r19, OIconButton.class, "com.obric.memorydata.plugin");
        View r110 = findViewById(ZeusTransformUtils.mapRes(R.id.multi_container, OaidModel.KEY_ID, "multi_container"));
        Intrinsics.checkNotNullExpressionValue(r110, "findViewById(R.id.multi_container)");
        this.g = r110;
        View r111 = findViewById(ZeusTransformUtils.mapRes(R.id.multi_leading_row, OaidModel.KEY_ID, "multi_leading_row"));
        Intrinsics.checkNotNullExpressionValue(r111, "findViewById(R.id.multi_leading_row)");
        this.h = (LinearLayout) ZeusTransformUtils.preCheckCast(r111, LinearLayout.class, "com.obric.memorydata.plugin");
        View r112 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_multi_icon, OaidModel.KEY_ID, "iv_multi_icon"));
        Intrinsics.checkNotNullExpressionValue(r112, "findViewById(R.id.iv_multi_icon)");
        this.i = (ImageView) ZeusTransformUtils.preCheckCast(r112, ImageView.class, "com.obric.memorydata.plugin");
        View r113 = findViewById(ZeusTransformUtils.mapRes(R.id.multi_text_group, OaidModel.KEY_ID, "multi_text_group"));
        Intrinsics.checkNotNullExpressionValue(r113, "findViewById(R.id.multi_text_group)");
        this.j = r113;
        View r114 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_desc, OaidModel.KEY_ID, "tv_desc"));
        Intrinsics.checkNotNullExpressionValue(r114, "findViewById(R.id.tv_desc)");
        this.k = (OTextView) ZeusTransformUtils.preCheckCast(r114, OTextView.class, "com.obric.memorydata.plugin");
        View r115 = findViewById(ZeusTransformUtils.mapRes(R.id.multi_actions, OaidModel.KEY_ID, "multi_actions"));
        Intrinsics.checkNotNullExpressionValue(r115, "findViewById(R.id.multi_actions)");
        this.l = r115;
        View r116 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_multi_dismiss, OaidModel.KEY_ID, "btn_multi_dismiss"));
        Intrinsics.checkNotNullExpressionValue(r116, "findViewById(R.id.btn_multi_dismiss)");
        this.m = (OButton) ZeusTransformUtils.preCheckCast(r116, OButton.class, "com.obric.memorydata.plugin");
        View r117 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_multi_action, OaidModel.KEY_ID, "btn_multi_action"));
        Intrinsics.checkNotNullExpressionValue(r117, "findViewById(R.id.btn_multi_action)");
        this.n = (OButton) ZeusTransformUtils.preCheckCast(r117, OButton.class, "com.obric.memorydata.plugin");
        a(r14, r12);
    }

    public /* synthetic */ OCoachmarkTipView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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
        Integer r0 = this.s;
        if (r0 != null) goto L5;
        int r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_fill_element_2, TypedValues.Custom.S_COLOR, "oui_fill_element_2"));
    L7:
        if (this.s == null) goto L9;
    L11:
        float r2 = b();
        GradientDrawable r3 = new GradientDrawable();
        r3.setShape(0);
        r3.setColor(r1);
        r3.setCornerRadius(r2);
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r3, Drawable.class, "com.obric.memorydata.plugin"));
        return;
    L9:
        if (this.t == false) goto L11;
        return;
    L5:
        r1 = r0.intValue();
        goto L7
    }

    private final void a(AttributeSet r6, int r7) {
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L6;
    L4:
        a();
        d();
        return;
    L6:
        TypedArray r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r8, R.styleable.OCoachmarkTip, r7, 0);
        this.o = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipShowIcon, "styleable", "OCoachmarkTip_oui_cmTipShowIcon"), true);
        this.p = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipClosable, "styleable", "OCoachmarkTip_oui_cmTipClosable"), false);
        this.r = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipSingleLine, "styleable", "OCoachmarkTip_oui_cmTipSingleLine"), false);
        this.q = ActionType.Companion.a(r9.getInt(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipActionType, "styleable", "OCoachmarkTip_oui_cmTipActionType"), ActionType.PRIMARY.getValue()));
        this.t = r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_android_background, "styleable", "OCoachmarkTip_android_background"));
        CharSequence r10 = r9.getText(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_android_text, "styleable", "OCoachmarkTip_android_text"));
        if (r10 == null) goto L10;
        this.d.setText(r10);
        this.k.setText(r10);
    L10:
        String r11 = r9.getString(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipActionText, "styleable", "OCoachmarkTip_oui_cmTipActionText"));
        this.e.setText((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"));
        this.n.setText((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"));
        String r12 = r9.getString(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipDismissText, "styleable", "OCoachmarkTip_oui_cmTipDismissText"));
        this.m.setText((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"));
        Drawable r13 = r9.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_android_src, "styleable", "OCoachmarkTip_android_src"));
        if (r13 == null) goto L14;
        this.c.setImageDrawable(r13);
        this.i.setImageDrawable(r13);
    L14:
        String r14 = r9.getString(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipPrimaryButtonText, "styleable", "OCoachmarkTip_oui_cmTipPrimaryButtonText"));
        if (r14 == null) goto L18;
        this.e.setText((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"));
        this.n.setText((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"));
    L18:
        String r15 = r9.getString(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipSecondaryButtonText, "styleable", "OCoachmarkTip_oui_cmTipSecondaryButtonText"));
        if (r15 == null) goto L23;
        this.m.setText((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"));
    L23:
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipBackgroundColor, "styleable", "OCoachmarkTip_oui_cmTipBackgroundColor")) == false) goto L26;
        this.s = Integer.valueOf(r9.getColor(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipBackgroundColor, "styleable", "OCoachmarkTip_oui_cmTipBackgroundColor"), 0));
    L26:
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipCornerRadius, "styleable", "OCoachmarkTip_oui_cmTipCornerRadius")) == false) goto L28;
        this.u = Float.valueOf(r9.getDimension(ZeusTransformUtils.mapRes(R.styleable.OCoachmarkTip_oui_cmTipCornerRadius, "styleable", "OCoachmarkTip_oui_cmTipCornerRadius"), 0.0f));
    L28:
        r9.recycle();
        goto L4
    }

    public static /* synthetic */ void a(OCoachmarkTipView r1, CharSequence r2, Integer r3, TextUtils.TruncateAt r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.a(r7, r3, r4);
    }

    private final void a(boolean r7) {
        Pair r0 = TuplesKt.to(Boolean.valueOf(this.o), Boolean.valueOf(r7));
        if (Intrinsics.areEqual(r0, TuplesKt.to(true, true)) == false) goto L6;
        int r1 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16);
    L10:
        if (r7 == false) goto L12;
        setPaddingRelative(r1, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16));
        setMinimumHeight(0);
        return;
    L12:
        setPaddingRelative(r1, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8));
        setMinimumHeight(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 48));
        return;
    L6:
        if (Intrinsics.areEqual(r0, TuplesKt.to(true, false)) == false) goto L8;
        View r2 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        int r3 = 12;
    L9:
        r1 = h.a(r2, r3);
        goto L10
    L8:
        r2 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        r3 = 20;
        goto L9
    }

    private final float b() {
        Float r0 = this.u;
        if (r0 != null) goto L10;
        if (c() == false) goto L7;
        View r2 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        int r1 = 20;
    L11:
        return h.b(r2, r1);
    L7:
        r2 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        r1 = 28;
        goto L11
    L10:
        return r0.floatValue();
    }

    private final void b(boolean r2) {
        if (r2 == false) goto L4;
        int r3 = 48;
    L6:
        if (this.h.getGravity() == r3) goto L9;
        this.h.setGravity(r3);
        return;
    L9:
        return;
    L4:
        r3 = 16;
        goto L6
    }

    private final boolean c() {
        return !this.r;
    }

    private final void d() {
        boolean r0 = c();
        o.a(this.f13460b, !r0);
        o.a(this.g, r0);
        a(r0);
        if (r0 == false) goto L5;
        int r1 = 48;
    L6:
        setGravity(r1);
        h();
        e();
        f();
        g();
        i();
        return;
    L5:
        r1 = 16;
        goto L6
    }

    private final void e() {
        if (c() == false) goto L5;
        return;
    L5:
        CharSequence r0 = this.e.getText();
        boolean r1 = false;
        if (r0 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        boolean r3 = !r2;
        View r4 = (View) ZeusTransformUtils.preCheckCast(this.e, View.class, "com.obric.memorydata.plugin");
        if (r3 == true) goto L15;
    L17:
        o.a(r4, r1);
        o.a((View) ZeusTransformUtils.preCheckCast(this.f, View.class, "com.obric.memorydata.plugin"), this.p);
        return;
    L15:
        if (this.p == true) goto L17;
        r1 = true;
        goto L17
    L8:
        if (StringsKt.isBlank(r0) == true) goto L11;
        r2 = false;
        goto L12
    }

    private final void f() {
        if (c() == true) goto L5;
        return;
    L5:
        CharSequence r0 = this.m.getText();
        int r1 = 0;
        boolean r2 = true;
        if (r0 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        boolean r4 = !r3;
        CharSequence r5 = this.n.getText();
        if (r5 != null) goto L15;
    L18:
        boolean r6 = true;
    L19:
        boolean r7 = !r6;
        if (r4 == true) goto L24;
        if (r7 == true) goto L24;
        r2 = false;
    L24:
        o.a(this.l, r2);
        View r8 = this.l;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r10 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r2 == false) goto L27;
        int r12 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8);
    L28:
        r11.topMargin = r12;
        r8.setLayoutParams(r10);
        b(r2);
        o.a((View) ZeusTransformUtils.preCheckCast(this.m, View.class, "com.obric.memorydata.plugin"), r4);
        o.a((View) ZeusTransformUtils.preCheckCast(this.n, View.class, "com.obric.memorydata.plugin"), r7);
        View r13 = (View) ZeusTransformUtils.preCheckCast(this.n, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        Objects.requireNonNull(r14, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r15 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r14, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r15, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (this.m.getVisibility() != 0) goto L31;
        r1 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12);
    L31:
        r16.setMarginStart(r1);
        r13.setLayoutParams(r15);
        return;
    L27:
        r12 = 0;
        goto L28
    L15:
        if (StringsKt.isBlank(r5) == true) goto L18;
        r6 = false;
        goto L19
    L8:
        if (StringsKt.isBlank(r0) == true) goto L11;
        r3 = false;
        goto L12
    }

    private final void g() {
        if (c() == true) goto L5;
        return;
    L5:
        o.a((View) ZeusTransformUtils.preCheckCast(this.i, View.class, "com.obric.memorydata.plugin"), this.o);
        View r0 = this.j;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r2 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (this.o == false) goto L8;
        int r5 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8);
    L9:
        r3.setMarginStart(r5);
        r0.setLayoutParams(r2);
        return;
    L8:
        r5 = 0;
        goto L9
    }

    private final void h() {
        boolean r0 = c();
        View r1 = (View) ZeusTransformUtils.preCheckCast(this.c, View.class, "com.obric.memorydata.plugin");
        int r4 = 0;
        if (this.o == false) goto L6;
        if (r0 == true) goto L6;
        boolean r2 = true;
    L7:
        o.a(r1, r2);
        View r3 = (View) ZeusTransformUtils.preCheckCast(this.d, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r6 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (this.o == false) goto L11;
        if (r0 == true) goto L11;
        r4 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8);
    L11:
        r7.setMarginStart(r4);
        r3.setLayoutParams(r6);
        return;
    L6:
        r2 = false;
        goto L7
    }

    private final void i() {
        ActionType r0 = this.q;
        int r1 = b.f13461a[r0.ordinal()];
        if (r1 != 1) goto L5;
        int r2 = R.color.oui_accent_6_bg;
        String r3 = "oui_accent_6_bg";
    L10:
        int r4 = ZeusTransformUtils.mapRes(r2, TypedValues.Custom.S_COLOR, r3);
        int r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getColor(r4);
        this.e.setTextColor(r5);
        this.n.setTextColor(r5);
        return;
    L5:
        if (r1 != 2) goto L8;
        r2 = R.color.oui_basic_text_1;
        r3 = "oui_basic_text_1";
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void a(CharSequence r3, Integer r4, TextUtils.TruncateAt r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.d.setText(r6);
        this.k.setText(r6);
        if (r4 == null) goto L6;
        int r7 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue();
        this.d.setMaxLines(r7);
        this.k.setMaxLines(r7);
    L6:
        if (r5 == null) goto L9;
        this.d.setEllipsize(r5);
        this.k.setEllipsize(r5);
    L9:
        if (r6 != null) goto L11;
    L14:
        boolean r8 = true;
    L15:
        if (r8 == false) goto L20;
        com.obric.oui.c.a.b r9 = com.obric.oui.c.a.b.f13400a;
        if (r9.a(8) == true) goto L20;
        r9.a().a("OCoachmarkTipView", 8, "Description is empty.", null);
    L20:
        d();
        return;
    L11:
        if (StringsKt.isBlank(r6) == true) goto L14;
        r8 = false;
        goto L15
    }

    public final void setActionText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.e.setText(r4);
        this.n.setText(r4);
        d();
    }

    public final void setActionType(ActionType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        if (this.q == r2) goto L6;
        this.q = r2;
        i();
        return;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r1) {
        this.s = Integer.valueOf(r1);
        a();
    }

    public final void setClosable(boolean r2) {
        if (this.p == r2) goto L6;
        this.p = r2;
        d();
        return;
    }

    public final void setCornerRadius(float r1) {
        this.u = Float.valueOf(r1);
        a();
    }

    public final void setDescription(CharSequence r7) {
        a(this, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin"), null, null, 6, null);
    }

    public final void setDismissText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.m.setText(r4);
        d();
    }

    public final void setIcon(Drawable r2) {
        this.c.setImageDrawable(r2);
        this.i.setImageDrawable(r2);
        d();
    }

    public final void setOnActionClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        this.e.setOnClickListener(r4);
        this.n.setOnClickListener(r4);
    }

    public final void setOnDismissClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        this.f.setOnClickListener(r4);
        this.m.setOnClickListener(r4);
    }

    public final void setPrimaryButtonText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.e.setText(r4);
        this.n.setText(r4);
        d();
    }

    public final void setSecondaryButtonText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.m.setText(r4);
        d();
    }

    public final void setShowIcon(boolean r2) {
        if (this.o == r2) goto L6;
        this.o = r2;
        d();
        return;
    }

    public final void setSingleLine(boolean r2) {
        if (this.r == r2) goto L6;
        this.r = r2;
        a();
        d();
        return;
    }
}
