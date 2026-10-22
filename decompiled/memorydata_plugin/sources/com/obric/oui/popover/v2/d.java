package com.obric.oui.popover.v2;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.popover.v2.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b9\b\u0016\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\n\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0014J\n\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0016J\n\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0016J\u000f\u0010\u0089\u0001\u001a\u00028\u0000H\u0014¢\u0006\u0003\u0010\u008a\u0001J\u0016\u0010\u008b\u0001\u001a\u00028\u00002\u0007\u0010\u008c\u0001\u001a\u00020\n¢\u0006\u0003\u0010\u008d\u0001J\u0016\u0010\u008e\u0001\u001a\u00028\u00002\u0007\u0010\u008c\u0001\u001a\u00020\n¢\u0006\u0003\u0010\u008d\u0001J\u0018\u0010\u008f\u0001\u001a\u00028\u00002\t\b\u0001\u0010\u0090\u0001\u001a\u00020\u0013¢\u0006\u0003\u0010\u0091\u0001J\u0016\u0010\u0092\u0001\u001a\u00028\u00002\u0007\u0010\u0093\u0001\u001a\u00020\u0013¢\u0006\u0003\u0010\u0091\u0001J\u0016\u0010\u0094\u0001\u001a\u00028\u00002\u0007\u0010\u0095\u0001\u001a\u00020\u0013¢\u0006\u0003\u0010\u0091\u0001J\u0016\u0010\u0096\u0001\u001a\u00028\u00002\u0007\u0010\u0097\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001J\u0016\u0010\u0099\u0001\u001a\u00028\u00002\u0007\u0010\u009a\u0001\u001a\u00020\u0013¢\u0006\u0003\u0010\u0091\u0001J\u0016\u0010\u009b\u0001\u001a\u00028\u00002\u0007\u0010\u009c\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001J\u0016\u0010\u009d\u0001\u001a\u00028\u00002\u0007\u0010\u009c\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001J\u0016\u0010\u009e\u0001\u001a\u00028\u00002\u0007\u0010\u009f\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001J\u0016\u0010 \u0001\u001a\u00028\u00002\u0007\u0010¡\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001J\u0016\u0010¢\u0001\u001a\u00028\u00002\u0007\u0010£\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001J(\u0010¤\u0001\u001a\u00028\u00002\u0019\u0010¥\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0D0C¢\u0006\u0003\u0010¦\u0001J\u0016\u0010§\u0001\u001a\u00028\u00002\u0007\u0010¨\u0001\u001a\u00020%¢\u0006\u0003\u0010©\u0001J\u0016\u0010ª\u0001\u001a\u00028\u00002\u0007\u0010¨\u0001\u001a\u00020Q¢\u0006\u0003\u0010«\u0001J\u0016\u0010¬\u0001\u001a\u00028\u00002\u0007\u0010¨\u0001\u001a\u00020i¢\u0006\u0003\u0010\u00ad\u0001J\u0016\u0010®\u0001\u001a\u00028\u00002\u0007\u0010¯\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001J\u0016\u0010°\u0001\u001a\u00028\u00002\u0007\u0010\u0097\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001J\u0017\u0010\u007f\u001a\u00028\u00002\t\b\u0001\u0010±\u0001\u001a\u00020\u0013¢\u0006\u0003\u0010\u0091\u0001J\u0016\u0010²\u0001\u001a\u00028\u00002\u0007\u0010³\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001J\u0016\u0010´\u0001\u001a\u00028\u00002\u0007\u0010µ\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001J\u0018\u0010¶\u0001\u001a\u00028\u00002\t\b\u0001\u0010\u0090\u0001\u001a\u00020\u0013¢\u0006\u0003\u0010\u0091\u0001J\u0016\u0010·\u0001\u001a\u00028\u00002\u0007\u0010¸\u0001\u001a\u00020]¢\u0006\u0003\u0010¹\u0001J\u0016\u0010º\u0001\u001a\u00028\u00002\u0007\u0010»\u0001\u001a\u00020o¢\u0006\u0003\u0010¼\u0001J\u0016\u0010½\u0001\u001a\u00028\u00002\u0007\u0010¾\u0001\u001a\u00020\u0013¢\u0006\u0003\u0010\u0091\u0001J\u0016\u0010¿\u0001\u001a\u00028\u00002\u0007\u0010¾\u0001\u001a\u00020\u0013¢\u0006\u0003\u0010\u0091\u0001J\u0016\u0010\u0080\u0001\u001a\u00028\u00002\u0007\u0010À\u0001\u001a\u00020\u001f¢\u0006\u0003\u0010\u0098\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R\u001a\u0010-\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010!\"\u0004\b/\u0010#R\u001a\u00100\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010!\"\u0004\b2\u0010#R\u001a\u00103\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010!\"\u0004\b5\u0010#R\u001a\u00106\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010!\"\u0004\b8\u0010#R\u001a\u00109\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0015\"\u0004\b;\u0010\u0017R\u001a\u0010<\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0015\"\u0004\b>\u0010\u0017R\u001a\u0010?\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010!\"\u0004\bA\u0010#R,\u0010B\u001a\u0014\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0D0CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010!\"\u0004\bL\u0010#R\u001a\u0010M\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010!\"\u0004\bO\u0010#R\u001c\u0010P\u001a\u0004\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001a\u0010V\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010!\"\u0004\bX\u0010#R\u001a\u0010Y\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010!\"\u0004\b[\u0010#R\u001a\u0010\\\u001a\u00020]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001e\u0010b\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0015\"\u0004\bd\u0010\u0017R\u001a\u0010e\u001a\u00020]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010_\"\u0004\bg\u0010aR\u001c\u0010h\u001a\u0004\u0018\u00010iX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001c\u0010n\u001a\u0004\u0018\u00010oX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001a\u0010t\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\u0015\"\u0004\bv\u0010\u0017R\u001a\u0010w\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u0015\"\u0004\by\u0010\u0017R\u001a\u0010z\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0015\"\u0004\b|\u0010\u0017R\u001e\u0010}\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u0015\"\u0004\b\u007f\u0010\u0017R\u001d\u0010\u0080\u0001\u001a\u00020\u001fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010!\"\u0005\b\u0082\u0001\u0010#¨\u0006Á\u0001"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", ExifInterface.GPS_DIRECTION_TRUE, "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "mAnimTime", "", "getMAnimTime", "()J", "setMAnimTime", "(J)V", "mAutoDismissDelayMillis", "getMAutoDismissDelayMillis", "setMAutoDismissDelayMillis", "mBgColor", "", "getMBgColor", "()I", "setMBgColor", "(I)V", "mBorderColor", "getMBorderColor", "setMBorderColor", "mBorderWidth", "getMBorderWidth", "setMBorderWidth", "mCoverPreviousWhenStacked", "", "getMCoverPreviousWhenStacked", "()Z", "setMCoverPreviousWhenStacked", "(Z)V", "mDismissListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;", "getMDismissListener", "()Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;", "setMDismissListener", "(Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;)V", "mDisplayOrientation", "getMDisplayOrientation", "setMDisplayOrientation", "mEnableBackPressDismiss", "getMEnableBackPressDismiss", "setMEnableBackPressDismiss", "mEnableBubbleMaterial", "getMEnableBubbleMaterial", "setMEnableBubbleMaterial", "mFocusable", "getMFocusable", "setMFocusable", "mGetLocationInWindow", "getMGetLocationInWindow", "setMGetLocationInWindow", "mGravity", "getMGravity", "setMGravity", "mHeight", "getMHeight", "setMHeight", "mHideVirtualKey", "getMHideVirtualKey", "setMHideVirtualKey", "mMaterials", "Lkotlin/Function1;", "", "Lcom/obric/oui/material/MaterialConfig;", "getMMaterials", "()Lkotlin/jvm/functions/Function1;", "setMMaterials", "(Lkotlin/jvm/functions/Function1;)V", "mOutsideTouchable", "getMOutsideTouchable", "setMOutsideTouchable", "mShadowEnabled", "getMShadowEnabled", "setMShadowEnabled", "mShowListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;", "getMShowListener", "()Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;", "setMShowListener", "(Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;)V", "mShowWithAnimation", "getMShowWithAnimation", "setMShowWithAnimation", "mSpacingForShadow", "getMSpacingForShadow", "setMSpacingForShadow", "mStackAlphaPrevious", "", "getMStackAlphaPrevious", "()F", "setMStackAlphaPrevious", "(F)V", "mStackCoverColor", "getMStackCoverColor", "setMStackCoverColor", "mStackScalePrevious", "getMStackScalePrevious", "setMStackScalePrevious", "mStartDismissListener", "Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;", "getMStartDismissListener", "()Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;", "setMStartDismissListener", "(Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;)V", "mView", "Landroid/view/View;", "getMView", "()Landroid/view/View;", "setMView", "(Landroid/view/View;)V", "mWidth", "getMWidth", "setMWidth", "mXOffset", "getMXOffset", "setMXOffset", "mYOffset", "getMYOffset", "setMYOffset", "shadowStyle", "getShadowStyle", "setShadowStyle", "transparentBg", "getTransparentBg", "setTransparentBg", "asPopoverBuilder", "Lcom/obric/oui/popover/v2/OPopover$Builder;", "build", "Lcom/obric/oui/popover/v2/OPopover;", "buildModal", "Lcom/obric/oui/popover/v2/OPopoverModal;", "self", "()Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "setAnimTime", OaidModel.KEY_TIME, "(J)Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "setAutoDismissDelayMillis", "setBgColor", TypedValues.Custom.S_COLOR, "(I)Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "setBorderColor", "borderColor", "setBorderWidth", "borderWidth", "setCoverPreviousWhenStacked", "enabled", "(Z)Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "setDisplayOrientation", "orientation", "setEnableBackPressDismiss", "enable", "setEnableBubbleMaterial", "setFocusable", "focusable", "setGetLocationInWindow", "getLocationInWindow", "setHideVirtualKey", "hide", "setMaterials", "materials", "(Lkotlin/jvm/functions/Function1;)Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "setOnDismissListener", "listener", "(Lcom/obric/oui/popover/v2/OPopover$OnBubbleDismissListener;)Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "setOnShowListener", "(Lcom/obric/oui/popover/v2/OPopover$OnBubbleShowListener;)Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "setOnStartDismissListener", "(Lcom/obric/oui/popover/v2/OPopover$OnBubbleStartDismissListener;)Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "setOutSideTouchable", "touchable", "setPopoverShadowEnabled", "shadowStyleRes", "setShowWithAnim", "withAnim", "setSpacingForShadow", "spacingForShadow", "setStackCoverColor", "setStackScalePrevious", "scale", "(F)Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "setView", "view", "(Landroid/view/View;)Lcom/obric/oui/popover/v2/OPopoverBuilderDelegate;", "setXOffset", TypedValues.CycleType.S_WAVE_OFFSET, "setYOffset", "transparent", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class d<T extends d<T>> {
    private boolean A;
    private Function1<? super Boolean, com.obric.oui.material.c[]> B;
    private boolean C;
    private int D;
    private float E;
    private float F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f14364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14365b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private int g;
    private int h;
    private long i;
    private long j;
    private View k;
    private int l;
    private int m;
    private a.e n;
    private a.c o;
    private a.d p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;
    private boolean z;

    public d(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Context r6 = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.f14364a = r6;
        this.e = ContextCompat.getColor(r6, ZeusTransformUtils.mapRes(R.color.oui_toast_background, TypedValues.Custom.S_COLOR, "oui_toast_background"));
        this.i = 800;
        this.j = Long.MIN_VALUE;
        this.q = true;
        this.s = true;
        this.w = true;
        this.x = true;
        this.y = ZeusTransformUtils.mapRes(R.style.OUIShadow_Oui_Shadow_Regular, "style", "OUIShadow_Oui_Shadow_Regular");
        this.A = true;
        this.B = MaterialToken.OUI_Bg_Popup;
        this.C = true;
        this.D = Color.parseColor("#08000000");
        this.E = 0.3f;
        this.F = 0.98f;
    }

    public final boolean A() {
        return this.C;
    }

    public final int B() {
        return this.D;
    }

    public final float C() {
        return this.E;
    }

    public final float D() {
        return this.F;
    }

    public T E() {
        return (T) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");
    }

    public a F() {
        return new a(G());
    }

    public a.C0765a G() {
        return (a.C0765a) ZeusTransformUtils.preCheckCast(this, a.C0765a.class, "com.obric.memorydata.plugin");
    }

    public final T a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.k = r2;
        return (T) E();
    }

    public final T a(boolean r1) {
        this.x = r1;
        return (T) E();
    }

    public final boolean a() {
        return this.f14365b;
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return this.d;
    }

    public final int d() {
        return this.e;
    }

    public final boolean e() {
        return this.f;
    }

    public final int f() {
        return this.g;
    }

    public final int g() {
        return this.h;
    }

    public final Context getContext() {
        return this.f14364a;
    }

    public final long h() {
        return this.i;
    }

    public final long i() {
        return this.j;
    }

    public final View j() {
        return this.k;
    }

    public final int k() {
        return this.l;
    }

    public final int l() {
        return this.m;
    }

    public final a.e m() {
        return this.n;
    }

    public final a.c n() {
        return this.o;
    }

    public final a.d o() {
        return this.p;
    }

    public final boolean p() {
        return this.q;
    }

    public final boolean q() {
        return this.r;
    }

    public final int r() {
        return this.t;
    }

    public final int s() {
        return this.u;
    }

    public final boolean t() {
        return this.v;
    }

    public final boolean u() {
        return this.w;
    }

    public final boolean v() {
        return this.x;
    }

    public final int w() {
        return this.y;
    }

    public final boolean x() {
        return this.z;
    }

    public final boolean y() {
        return this.A;
    }

    public final Function1<Boolean, com.obric.oui.material.c[]> z() {
        return this.B;
    }
}
