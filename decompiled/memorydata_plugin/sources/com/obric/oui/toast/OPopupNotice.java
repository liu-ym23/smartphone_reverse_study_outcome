package com.obric.oui.toast;

import android.app.Activity;
import android.view.View;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u00020\u0001:\u0007\u001c\u001d\u001e\u001f !\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0002\u001a\u00020\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007J\u0006\u0010\u0018\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\u0001J\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/oui/toast/OPopupNotice;", "", "builder", "Lcom/obric/oui/toast/OPopupNotice$Builder;", "(Lcom/obric/oui/toast/OPopupNotice$Builder;)V", "contentDescOfContentView", "", "contentView", "Landroid/view/View;", "dismissByAPI", "", "innerHeightOfPopV", "", "mTimer", "Lcom/obric/oui/toast/OPopupNotice$Timer;", "popupWindow", "Landroid/widget/PopupWindow;", "computeCountdownInterval", "", "duration", "hide", "", InfoRequestQPSOptTraceLogger.REASON, "Lcom/obric/oui/toast/OPopupNotice$HideReason;", "isShowing", "originImpl", "originView", "show", "Builder", "Callback", "Companion", "HideCallback", "HideReason", "PopupOutlineProvider", "Timer", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopupNotice {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14801a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f14802b = 0;
    private static final int c = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/toast/OPopupNotice$HideReason;", "", "(Ljava/lang/String;I)V", "HIDE_AUTO", "HIDE_MANUAL", "HIDE_CONFLICT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum HideReason extends Enum<HideReason> {
        private static final /* synthetic */ HideReason[] $VALUES = null;
        public static final HideReason HIDE_AUTO = null;
        public static final HideReason HIDE_CONFLICT = null;
        public static final HideReason HIDE_MANUAL = null;

        private static final /* synthetic */ HideReason[] $values() {
            return new HideReason[]{HIDE_AUTO, HIDE_MANUAL, HIDE_CONFLICT};
        }

        static {
            HIDE_AUTO = new HideReason("HIDE_AUTO", 0);
            HIDE_MANUAL = new HideReason("HIDE_MANUAL", 1);
            HIDE_CONFLICT = new HideReason("HIDE_CONFLICT", 2);
            $VALUES = $values();
        }

        private HideReason(String r1, int r2) {
            super(r1, r2);
        }

        public static HideReason valueOf(String r2) {
            return (HideReason) ZeusTransformUtils.preCheckCast(Enum.valueOf(HideReason.class, r2), HideReason.class, "com.obric.memorydata.plugin");
        }

        public static HideReason[] values() {
            return (HideReason[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HideReason[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0007\u0010\u0096\u0001\u001a\u00020MJ$\u0010\t\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00062\t\b\u0002\u0010\u0090\u0001\u001a\u00020\f2\t\b\u0002\u0010\u0097\u0001\u001a\u00020\fJ\u0011\u0010\u001c\u001a\u00020\u00002\t\b\u0001\u0010\u0098\u0001\u001a\u00020\fJ\u0011\u0010R\u001a\u00020\u00002\t\b\u0001\u0010\u0098\u0001\u001a\u00020\fJ\u0011\u0010f\u001a\u00020\u00002\t\b\u0001\u0010\u0099\u0001\u001a\u00020\fJ.\u0010m\u001a\u00020\u00002\u0006\u0010k\u001a\u00020\u00062\t\b\u0002\u0010\u0090\u0001\u001a\u00020\f2\t\b\u0002\u0010\u0093\u0001\u001a\u00020\f2\b\b\u0002\u0010:\u001a\u00020\fJ\u0011\u0010z\u001a\u00020\u00002\t\b\u0001\u0010\u0098\u0001\u001a\u00020\fJ\u0012\u0010\u0084\u0001\u001a\u00020\u00002\t\b\u0001\u0010\u0099\u0001\u001a\u00020\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR-\u0010\u001e\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020 \u0018\u00010\u001f¢\u0006\u0002\b!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0015\"\u0004\b.\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0015\"\u0004\b9\u0010\u0017R\u001a\u0010:\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>R\u001c\u0010B\u001a\u0004\u0018\u00010CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0015\"\u0004\bI\u0010\u0017R\u001a\u0010J\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0015\"\u0004\bK\u0010\u0017R(\u0010L\u001a\u0010\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010#\"\u0004\bO\u0010%R\u001c\u0010P\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u001b\"\u0004\bR\u0010\u001dR-\u0010S\u001a\u0015\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020 \u0018\u00010\u001f¢\u0006\u0002\b!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010#\"\u0004\bV\u0010%R\u001c\u0010W\u001a\u0004\u0018\u00010XX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R-\u0010]\u001a\u0015\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020 \u0018\u00010\u001f¢\u0006\u0002\b!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010#\"\u0004\b`\u0010%R-\u0010a\u001a\u0015\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020 \u0018\u00010\u001f¢\u0006\u0002\b!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010#\"\u0004\bc\u0010%R\u001c\u0010d\u001a\u0004\u0018\u00010XX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010Z\"\u0004\bf\u0010\\R\u001c\u0010g\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\b\"\u0004\bi\u0010\nR(\u0010k\u001a\u0004\u0018\u00010\u00062\b\u0010j\u001a\u0004\u0018\u00010\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\b\"\u0004\bm\u0010\nR-\u0010n\u001a\u0015\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020 \u0018\u00010\u001f¢\u0006\u0002\b!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010#\"\u0004\bp\u0010%R\"\u0010r\u001a\u0004\u0018\u00010M2\b\u0010q\u001a\u0004\u0018\u00010M@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bs\u0010tR(\u0010u\u001a\u0010\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010#\"\u0004\bw\u0010%R\u001c\u0010x\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u001b\"\u0004\bz\u0010\u001dR-\u0010{\u001a\u0015\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020 \u0018\u00010\u001f¢\u0006\u0002\b!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010#\"\u0004\b}\u0010%R/\u0010~\u001a\u0015\u0012\u0004\u0012\u00020\u007f\u0012\u0004\u0012\u00020 \u0018\u00010\u001f¢\u0006\u0002\b!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010#\"\u0005\b\u0081\u0001\u0010%R\u001f\u0010\u0082\u0001\u001a\u0004\u0018\u00010XX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010Z\"\u0005\b\u0084\u0001\u0010\\R\u0016\u0010\u0085\u0001\u001a\t\u0012\u0004\u0012\u00020 0\u0086\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0087\u0001\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010\u0015\"\u0005\b\u0089\u0001\u0010\u0017R\u001d\u0010\u008a\u0001\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010\u0015\"\u0005\b\u008c\u0001\u0010\u0017R\u001d\u0010\u008d\u0001\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010<\"\u0005\b\u008f\u0001\u0010>R\u001d\u0010\u0090\u0001\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010<\"\u0005\b\u0092\u0001\u0010>R\u001d\u0010\u0093\u0001\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010<\"\u0005\b\u0095\u0001\u0010>¨\u0006\u009a\u0001"}, d2 = {"Lcom/obric/oui/toast/OPopupNotice$Builder;", "", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "anchorView", "Landroid/view/View;", "getAnchorView", "()Landroid/view/View;", "setAnchorView", "(Landroid/view/View;)V", "animationStyle", "", "getAnimationStyle", "()Ljava/lang/Integer;", "setAnimationStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "autoSwitchDayNight", "", "getAutoSwitchDayNight", "()Z", "setAutoSwitchDayNight", "(Z)V", TraceCons.METRIC_BACKGROUND, "Landroid/graphics/drawable/Drawable;", "getBackground", "()Landroid/graphics/drawable/Drawable;", "setBackground", "(Landroid/graphics/drawable/Drawable;)V", "backgroundAttrs", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "getBackgroundAttrs", "()Lkotlin/jvm/functions/Function1;", "setBackgroundAttrs", "(Lkotlin/jvm/functions/Function1;)V", "callback", "Lcom/obric/oui/toast/OPopupNotice$Callback;", "getCallback", "()Lcom/obric/oui/toast/OPopupNotice$Callback;", "setCallback", "(Lcom/obric/oui/toast/OPopupNotice$Callback;)V", "closeLastNotice", "getCloseLastNotice", "setCloseLastNotice", "getContext$OUI_standardRelease", "()Landroid/app/Activity;", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "enableAutoDismiss", "getEnableAutoDismiss", "setEnableAutoDismiss", "gravity", "getGravity", "()I", "setGravity", "(I)V", "height", "getHeight", "setHeight", "hideCallback", "Lcom/obric/oui/toast/OPopupNotice$HideCallback;", "getHideCallback", "()Lcom/obric/oui/toast/OPopupNotice$HideCallback;", "setHideCallback", "(Lcom/obric/oui/toast/OPopupNotice$HideCallback;)V", "isFocusable", "setFocusable", "isOutsideTouchable", "setOutsideTouchable", "leftAction", "Lcom/obric/oui/toast/OPopupNotice;", "getLeftAction", "setLeftAction", "leftIcon", "getLeftIcon", "setLeftIcon", "leftIconAttrs", "Landroid/widget/ImageView;", "getLeftIconAttrs", "setLeftIconAttrs", "leftSubTitle", "", "getLeftSubTitle", "()Ljava/lang/String;", "setLeftSubTitle", "(Ljava/lang/String;)V", "leftSubTitleAttrs", "Landroid/widget/TextView;", "getLeftSubTitleAttrs", "setLeftSubTitleAttrs", "leftTextAttrs", "getLeftTextAttrs", "setLeftTextAttrs", "leftTitle", "getLeftTitle", "setLeftTitle", "leftView", "getLeftView", "setLeftView", EventBody.KEY_VALUE, "parentView", "getParentView", "setParentView", "popViewClickAction", "getPopViewClickAction", "setPopViewClickAction", "<set-?>", "popupNoticeDelegate", "getPopupNoticeDelegate", "()Lcom/obric/oui/toast/OPopupNotice;", "rightAction", "getRightAction", "setRightAction", "rightIcon", "getRightIcon", "setRightIcon", "rightIconAttrs", "getRightIconAttrs", "setRightIconAttrs", "rightTextAttrs", "Lcom/obric/oui/button/OButton;", "getRightTextAttrs", "setRightTextAttrs", "rightTitle", "getRightTitle", "setRightTitle", "setDefaultAnchorView", "Lkotlin/Function0;", "useButtonStyleAtEnd", "getUseButtonStyleAtEnd", "setUseButtonStyleAtEnd", "useDefaultAnchorView", "getUseDefaultAnchorView", "setUseDefaultAnchorView", "width", "getWidth", "setWidth", "xOffset", "getXOffset", "setXOffset", "yOffset", "getYOffset", "setYOffset", "build", "yOffsetBottom", "drawable", "title", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Activity f14803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private View f14804b;
        private int c;

        public final Activity a() {
            return this.f14803a;
        }

        public final void a(int r1) {
            this.c = r1;
        }

        public final void a(View r1) {
            this.f14804b = r1;
        }

        public final int b() {
            return this.c;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0002\b\u0018H\u0087\bø\u0001\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/toast/OPopupNotice$Companion;", "", "()V", "DEFAULT_ANCHOR_GRAVITY", "", "DEFAULT_CONOR_RADIUS_DP", "DEFAULT_LEFT_VIEW_SIZE_DP", "DEFAULT_SHOW_DURATION", "", "DUX_BOTTOM_NOTICE_LARGE_WINDOW_WIDTH_IN_DP", "DUX_BOTTOM_NOTICE_SMALL_WINDOW_WIDTH_IN_DP", "MAX_WIDTH_IN_DP", "TAG", "", "lastPopupNoticeRef", "Ljava/lang/ref/WeakReference;", "Lcom/obric/oui/toast/OPopupNotice;", "build", "context", "Landroid/app/Activity;", "builderReceiver", "Lkotlin/Function1;", "Lcom/obric/oui/toast/OPopupNotice$Builder;", "", "Lkotlin/ExtensionFunctionType;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14801a = new b(null);
        f14802b = 12;
        c = 24;
    }
}
