package com.bytedance.android.annie.scheme.vo.refactor;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.annie.scheme.convert.HybridTypeNew;
import com.bytedance.android.ec.core.utils.FontWeight;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b3\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b%\b\u0007\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\"\u00103\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\"\u00107\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010=\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u00108\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<R\"\u0010@\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u00108\u001a\u0004\bA\u0010:\"\u0004\bB\u0010<R\"\u0010C\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u00108\u001a\u0004\bD\u0010:\"\u0004\bE\u0010<R\"\u0010F\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u00108\u001a\u0004\bG\u0010:\"\u0004\bH\u0010<R\"\u0010I\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u00108\u001a\u0004\bJ\u0010:\"\u0004\bK\u0010<R\"\u0010L\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bL\u00108\u001a\u0004\bM\u0010:\"\u0004\bN\u0010<R\"\u0010O\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bO\u0010\u0004\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\bR\"\u0010R\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010\u0004\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR\"\u0010U\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u0010\u0004\u001a\u0004\bV\u0010\u0006\"\u0004\bW\u0010\bR\"\u0010X\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bX\u00108\u001a\u0004\bY\u0010:\"\u0004\bZ\u0010<R\"\u0010[\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u00108\u001a\u0004\b\\\u0010:\"\u0004\b]\u0010<R\"\u0010^\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b^\u00108\u001a\u0004\b_\u0010:\"\u0004\b`\u0010<R\"\u0010a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\ba\u0010\u0004\u001a\u0004\bb\u0010\u0006\"\u0004\bc\u0010\bR\"\u0010d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bd\u0010\u0004\u001a\u0004\be\u0010\u0006\"\u0004\bf\u0010\bR\"\u0010g\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bg\u0010\u0004\u001a\u0004\bh\u0010\u0006\"\u0004\bi\u0010\bR$\u0010k\u001a\u0004\u0018\u00010j8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010q\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bq\u0010\u0004\u001a\u0004\br\u0010\u0006\"\u0004\bs\u0010\bR$\u0010t\u001a\u0004\u0018\u00010j8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bt\u0010l\u001a\u0004\bu\u0010n\"\u0004\bv\u0010pR\"\u0010w\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bw\u00108\u001a\u0004\bx\u0010:\"\u0004\by\u0010<R\"\u0010z\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bz\u00108\u001a\u0004\b{\u0010:\"\u0004\b|\u0010<R\"\u0010}\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b}\u00108\u001a\u0004\b~\u0010:\"\u0004\b\u007f\u0010<R*\u0010\u0081\u0001\u001a\u00030\u0080\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R(\u0010\u0087\u0001\u001a\u0004\u0018\u00010j8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010l\u001a\u0005\b\u0088\u0001\u0010n\"\u0005\b\u0089\u0001\u0010pR&\u0010\u008a\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008a\u0001\u0010\u0004\u001a\u0005\b\u008b\u0001\u0010\u0006\"\u0005\b\u008c\u0001\u0010\bR&\u0010\u008d\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010\u0004\u001a\u0005\b\u008e\u0001\u0010\u0006\"\u0005\b\u008f\u0001\u0010\bR&\u0010\u0090\u0001\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0090\u0001\u00108\u001a\u0005\b\u0091\u0001\u0010:\"\u0005\b\u0092\u0001\u0010<R&\u0010\u0093\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0093\u0001\u0010\u0004\u001a\u0005\b\u0094\u0001\u0010\u0006\"\u0005\b\u0095\u0001\u0010\bR&\u0010\u0096\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0096\u0001\u0010\u0004\u001a\u0005\b\u0097\u0001\u0010\u0006\"\u0005\b\u0098\u0001\u0010\bR&\u0010\u0099\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0099\u0001\u0010\u0004\u001a\u0005\b\u009a\u0001\u0010\u0006\"\u0005\b\u009b\u0001\u0010\bR&\u0010\u009c\u0001\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009c\u0001\u00108\u001a\u0005\b\u009d\u0001\u0010:\"\u0005\b\u009e\u0001\u0010<R&\u0010\u009f\u0001\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009f\u0001\u00108\u001a\u0005\b \u0001\u0010:\"\u0005\b¡\u0001\u0010<R&\u0010¢\u0001\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¢\u0001\u00108\u001a\u0005\b£\u0001\u0010:\"\u0005\b¤\u0001\u0010<¨\u0006¥\u0001"}, d2 = {"Lcom/bytedance/android/annie/scheme/vo/refactor/PopupHybridParamVoNew;", "Lcom/bytedance/android/annie/scheme/vo/refactor/FragmentParamVoNew;", "", "width", "I", "getWidth", "()I", "v4", "(I)V", "height", "getHeight", "N3", "horizontalWidth", "Y2", "S3", "horizontalHeight", "V2", "P3", "horizontalHeightPercent", "W2", "Q3", "horizontalWidthPercent", "Z2", "T3", "horizontalRadius", "X2", "R3", "margin", "d3", "X3", "marginBottom", "getMarginBottom", "Y3", "marginRight", "getMarginRight", "Z3", "radius", "l3", "f4", "radiusTopLeft", "o3", "i4", "radiusTopRight", "p3", "j4", "radiusBottomRight", "n3", "h4", "radiusBottomLeft", "m3", "g4", "gravity", "T2", "M3", "", "useBottomClose", "Z", "y3", "()Z", "s4", "(Z)V", "landScapeCustomHeight", "b3", "V3", "landScapeCustomWidth", "c3", "W3", "landScapeCustomGravity", "a3", "U3", "showDim", "r3", "l4", "showDimForce", "s3", "m4", "canceledOnTouchOutside", "P2", "J3", "heightPercent", "U2", "O3", "widthPercent", "B3", "w4", "rateHeight", "q3", "k4", "useRealScreenHeight", "A3", "u4", "enablePullUp", "S2", "L3", "disableNestedChildScroll", "R2", "K3", "upOffsetHeight", "v3", "p4", "usePlayerBottomHeight", "z3", "t4", "padUsePlayerBottomHeight", "i3", "c4", "", "upStatusBarBgColor", "Ljava/lang/String;", "w3", "()Ljava/lang/String;", "q4", "(Ljava/lang/String;)V", "isAlreadyAdaptationUi", "F3", "I3", "popUpType", "j3", "d4", "needAnimation", "g3", "b4", "windowFloating", "C3", "x4", "abandonCoordinate", "N2", "G3", "", "maskAlpha", "F", "e3", "()F", "a4", "(F)V", "maskBgColor", "f3", "setMaskBgColor", "upCloseIconPosition", "t3", "n4", "upHeightPercent", "u3", "o4", "upTransStatusBar", "x3", "r4", "xOffset", "D3", "y4", "yOffset", "E3", "z4", "pullDownHeight", "k3", "e4", "allowingStateLoss", "O2", "H3", "delayOpen", "Q2", "setDelayOpen", "padUsePhoneSize", "h3", "setPadUsePhoneSize", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class PopupHybridParamVoNew extends FragmentParamVoNew {
    public static final Parcelable.Creator<PopupHybridParamVoNew> CREATOR = null;

    @SerializedName("abandon_coordinate")
    private boolean abandonCoordinate;

    @SerializedName("allowing_state_loss")
    private boolean allowingStateLoss;

    @SerializedName("mask_click_disable")
    private boolean canceledOnTouchOutside;

    @SerializedName("delay_open")
    private boolean delayOpen;

    @SerializedName("disable_nested_child_scroll")
    private boolean disableNestedChildScroll;

    @SerializedName("up_full_screen")
    private boolean enablePullUp;

    @SerializedName("gravity")
    private int gravity;

    @SerializedName("height")
    private int height;

    @SerializedName("height_percent")
    private int heightPercent;

    @SerializedName("horizontal_height")
    private int horizontalHeight;

    @SerializedName("horizontal_height_percent")
    private int horizontalHeightPercent;

    @SerializedName("horizontal_radius")
    private int horizontalRadius;

    @SerializedName("horizontal_width")
    private int horizontalWidth;

    @SerializedName("horizontal_width_percent")
    private int horizontalWidthPercent;

    @SerializedName("is_already_adaptation_ui")
    private int isAlreadyAdaptationUi;

    @SerializedName("landScape_custom_gravity")
    private boolean landScapeCustomGravity;

    @SerializedName("landscape_custom_height")
    private boolean landScapeCustomHeight;

    @SerializedName("landScape_custom_width")
    private boolean landScapeCustomWidth;

    @SerializedName("margin")
    private int margin;

    @SerializedName("margin_bottom")
    private int marginBottom;

    @SerializedName("margin_right")
    private int marginRight;

    @SerializedName("mask_alpha")
    private float maskAlpha;

    @SerializedName("mask_bg_color")
    private String maskBgColor;

    @SerializedName("open_animate")
    private boolean needAnimation;

    @SerializedName("pad_use_phone_size")
    private boolean padUsePhoneSize;

    @SerializedName("pad_use_player_bottom_height")
    private int padUsePlayerBottomHeight;

    @SerializedName("popup_type")
    private String popUpType;

    @SerializedName("pull_down_height")
    private int pullDownHeight;

    @SerializedName("radius")
    private int radius;

    @SerializedName("radius_bottom_left")
    private int radiusBottomLeft;

    @SerializedName("radius_bottom_right")
    private int radiusBottomRight;

    @SerializedName("radius_top_left")
    private int radiusTopLeft;

    @SerializedName("radius_top_right")
    private int radiusTopRight;

    @SerializedName("rate_height")
    private int rateHeight;

    @SerializedName("show_dim")
    private boolean showDim;

    @SerializedName("show_dim_force")
    private boolean showDimForce;

    @SerializedName("close_icon_position")
    private int upCloseIconPosition;

    @SerializedName("up_height_percent")
    private int upHeightPercent;

    @SerializedName("up_offset_height")
    private int upOffsetHeight;

    @SerializedName("up_status_bar_bg_color")
    private String upStatusBarBgColor;

    @SerializedName("up_trans_status_bar")
    private boolean upTransStatusBar;

    @SerializedName("use_bottom_close")
    private boolean useBottomClose;

    @SerializedName("use_player_bottom_height")
    private int usePlayerBottomHeight;

    @SerializedName("use_real_screen_height")
    private boolean useRealScreenHeight;

    @SerializedName("width")
    private int width;

    @SerializedName("width_percent")
    private int widthPercent;

    @SerializedName("window_floating")
    private boolean windowFloating;

    @SerializedName("x_offset")
    private int xOffset;

    @SerializedName("y_offset")
    private int yOffset;

    public static final class a implements Parcelable.Creator<PopupHybridParamVoNew> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PopupHybridParamVoNew createFromParcel(Parcel r54) {
            Intrinsics.checkNotNullParameter(r54, "parcel");
            int r10 = r54.readInt();
            int r11 = r54.readInt();
            int r12 = r54.readInt();
            int r13 = r54.readInt();
            int r14 = r54.readInt();
            int r15 = r54.readInt();
            int r16 = r54.readInt();
            int r17 = r54.readInt();
            int r18 = r54.readInt();
            int r19 = r54.readInt();
            int r110 = r54.readInt();
            int r111 = r54.readInt();
            int r112 = r54.readInt();
            int r113 = r54.readInt();
            int r114 = r54.readInt();
            int r115 = r54.readInt();
            if (r54.readInt() == 0) goto L5;
            boolean r116 = true;
        L7:
            if (r54.readInt() == 0) goto L9;
            boolean r21 = true;
        L11:
            if (r54.readInt() == 0) goto L13;
            boolean r22 = true;
        L15:
            if (r54.readInt() == 0) goto L17;
            boolean r23 = true;
        L19:
            if (r54.readInt() == 0) goto L21;
            boolean r24 = true;
        L23:
            if (r54.readInt() == 0) goto L25;
            boolean r25 = true;
        L27:
            if (r54.readInt() == 0) goto L29;
            boolean r26 = true;
        L30:
            int r27 = r54.readInt();
            int r28 = r54.readInt();
            int r29 = r54.readInt();
            if (r54.readInt() == 0) goto L33;
            boolean r30 = true;
        L35:
            if (r54.readInt() == 0) goto L37;
            boolean r31 = true;
        L39:
            if (r54.readInt() == 0) goto L41;
            boolean r32 = true;
        L42:
            int r33 = r54.readInt();
            int r34 = r54.readInt();
            int r35 = r54.readInt();
            String r36 = r54.readString();
            int r37 = r54.readInt();
            String r38 = r54.readString();
            if (r54.readInt() == 0) goto L45;
            boolean r39 = true;
        L47:
            if (r54.readInt() == 0) goto L49;
            boolean r40 = true;
        L51:
            if (r54.readInt() == 0) goto L53;
            boolean r41 = true;
        L54:
            float r42 = r54.readFloat();
            String r43 = r54.readString();
            int r44 = r54.readInt();
            int r45 = r54.readInt();
            if (r54.readInt() == 0) goto L57;
            boolean r46 = true;
        L58:
            int r47 = r54.readInt();
            int r48 = r54.readInt();
            int r49 = r54.readInt();
            if (r54.readInt() == 0) goto L61;
            boolean r50 = true;
        L63:
            if (r54.readInt() == 0) goto L65;
            boolean r51 = true;
        L67:
            if (r54.readInt() == 0) goto L69;
            boolean r52 = true;
        L71:
            return new PopupHybridParamVoNew(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52);
        L69:
            r52 = false;
            goto L71
        L65:
            r51 = false;
            goto L67
        L61:
            r50 = false;
            goto L63
        L57:
            r46 = false;
            goto L58
        L53:
            r41 = false;
            goto L54
        L49:
            r40 = false;
            goto L51
        L45:
            r39 = false;
            goto L47
        L41:
            r32 = false;
            goto L42
        L37:
            r31 = false;
            goto L39
        L33:
            r30 = false;
            goto L35
        L29:
            r26 = false;
            goto L30
        L25:
            r25 = false;
            goto L27
        L21:
            r24 = false;
            goto L23
        L17:
            r23 = false;
            goto L19
        L13:
            r22 = false;
            goto L15
        L9:
            r21 = false;
            goto L11
        L5:
            r116 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final PopupHybridParamVoNew[] newArray(int r1) {
            return new PopupHybridParamVoNew[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public PopupHybridParamVoNew() {
        this(0);
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.HybridSchemaParam, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.FragmentParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.HybridSchemaParam, android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r10) {
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeInt(this.width);
        r1.writeInt(this.height);
        r1.writeInt(this.horizontalWidth);
        r1.writeInt(this.horizontalHeight);
        r1.writeInt(this.horizontalHeightPercent);
        r1.writeInt(this.horizontalWidthPercent);
        r1.writeInt(this.horizontalRadius);
        r1.writeInt(this.margin);
        r1.writeInt(this.marginBottom);
        r1.writeInt(this.marginRight);
        r1.writeInt(this.radius);
        r1.writeInt(this.radiusTopLeft);
        r1.writeInt(this.radiusTopRight);
        r1.writeInt(this.radiusBottomRight);
        r1.writeInt(this.radiusBottomLeft);
        r1.writeInt(this.gravity);
        r1.writeInt(this.useBottomClose ? 1 : 0);
        r1.writeInt(this.landScapeCustomHeight ? 1 : 0);
        r1.writeInt(this.landScapeCustomWidth ? 1 : 0);
        r1.writeInt(this.landScapeCustomGravity ? 1 : 0);
        r1.writeInt(this.showDim ? 1 : 0);
        r1.writeInt(this.showDimForce ? 1 : 0);
        r1.writeInt(this.canceledOnTouchOutside ? 1 : 0);
        r1.writeInt(this.heightPercent);
        r1.writeInt(this.widthPercent);
        r1.writeInt(this.rateHeight);
        r1.writeInt(this.useRealScreenHeight ? 1 : 0);
        r1.writeInt(this.enablePullUp ? 1 : 0);
        r1.writeInt(this.disableNestedChildScroll ? 1 : 0);
        r1.writeInt(this.upOffsetHeight);
        r1.writeInt(this.usePlayerBottomHeight);
        r1.writeInt(this.padUsePlayerBottomHeight);
        r1.writeString(this.upStatusBarBgColor);
        r1.writeInt(this.isAlreadyAdaptationUi);
        r1.writeString(this.popUpType);
        r1.writeInt(this.needAnimation ? 1 : 0);
        r1.writeInt(this.windowFloating ? 1 : 0);
        r1.writeInt(this.abandonCoordinate ? 1 : 0);
        r1.writeFloat(this.maskAlpha);
        r1.writeString(this.maskBgColor);
        r1.writeInt(this.upCloseIconPosition);
        r1.writeInt(this.upHeightPercent);
        r1.writeInt(this.upTransStatusBar ? 1 : 0);
        r1.writeInt(this.xOffset);
        r1.writeInt(this.yOffset);
        r1.writeInt(this.pullDownHeight);
        r1.writeInt(this.allowingStateLoss ? 1 : 0);
        r1.writeInt(this.delayOpen ? 1 : 0);
        r1.writeInt(this.padUsePhoneSize ? 1 : 0);
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.FragmentParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew
    public final String toString() {
        return super.toString() + "\nPopupHybridParamVo(width=" + this.width + ", height=" + this.height + ", horizontalWidth=" + this.horizontalWidth + ", horizontalHeight=" + this.horizontalHeight + ", horizontalHeightPercent=" + this.horizontalHeightPercent + ", horizontalWidthPercent=" + this.horizontalWidthPercent + ", horizontalRadius=" + this.horizontalRadius + ", margin=" + this.margin + ", marginBottom=" + this.marginBottom + ", marginRight=" + this.marginRight + ", radius=" + this.radius + ", radiusTopLeft=" + this.radiusTopLeft + ", radiusTopRight=" + this.radiusTopRight + ", radiusBottomRight=" + this.radiusBottomRight + ", radiusBottomLeft=" + this.radiusBottomLeft + ", gravity=" + this.gravity + ", useBottomClose=" + this.useBottomClose + ", landScapeCustomHeight=" + this.landScapeCustomHeight + ", landScapeCustomWidth=" + this.landScapeCustomWidth + ", landScapeCustomGravity=" + this.landScapeCustomGravity + ", showDim=" + this.showDim + ", showDimForce=" + this.showDimForce + ", canceledOnTouchOutside=" + this.canceledOnTouchOutside + ", heightPercent=" + this.heightPercent + ", widthPercent=" + this.widthPercent + ", rateHeight=" + this.rateHeight + ", useRealScreenHeight=" + this.useRealScreenHeight + ", enablePullUp=" + this.enablePullUp + ", disableNestedChildScroll=" + this.disableNestedChildScroll + ", upOffsetHeight=" + this.upOffsetHeight + ", usePlayerBottomHeight=" + this.usePlayerBottomHeight + ", padUsePlayerBottomHeight=" + this.padUsePlayerBottomHeight + ", upStatusBarBgColor=" + this.upStatusBarBgColor + ", isAlreadyAdaptationUi=" + this.isAlreadyAdaptationUi + ", popUpType=" + this.popUpType + ", needAnimation=" + this.needAnimation + ", windowFloating=" + this.windowFloating + ", abandonCoordinate=" + this.abandonCoordinate + ", maskAlpha=" + this.maskAlpha + ", upCloseIconPosition=" + this.upCloseIconPosition + ", upHeightPercent=" + this.upHeightPercent + ", upTransStatusBar=" + this.upTransStatusBar + ", xOffset=" + this.xOffset + ", yOffset=" + this.yOffset + ", pullDownHeight=" + this.pullDownHeight + ", delayOpen=" + this.delayOpen + ", padUsePhoneSize=" + this.padUsePhoneSize + "})";
    }

    public final boolean A3() {
        return this.useRealScreenHeight;
    }

    public final int B3() {
        return this.widthPercent;
    }

    public final boolean C3() {
        return this.windowFloating;
    }

    public final int D3() {
        return this.xOffset;
    }

    public final int E3() {
        return this.yOffset;
    }

    public final int F3() {
        return this.isAlreadyAdaptationUi;
    }

    public final boolean N2() {
        return this.abandonCoordinate;
    }

    public final boolean O2() {
        return this.allowingStateLoss;
    }

    public final boolean P2() {
        return this.canceledOnTouchOutside;
    }

    public final boolean Q2() {
        return this.delayOpen;
    }

    public final boolean R2() {
        return this.disableNestedChildScroll;
    }

    public final boolean S2() {
        return this.enablePullUp;
    }

    public final int T2() {
        return this.gravity;
    }

    public final int U2() {
        return this.heightPercent;
    }

    public final int V2() {
        return this.horizontalHeight;
    }

    public final int W2() {
        return this.horizontalHeightPercent;
    }

    public final int X2() {
        return this.horizontalRadius;
    }

    public final int Y2() {
        return this.horizontalWidth;
    }

    public final int Z2() {
        return this.horizontalWidthPercent;
    }

    public final boolean a3() {
        return this.landScapeCustomGravity;
    }

    public final boolean b3() {
        return this.landScapeCustomHeight;
    }

    public final boolean c3() {
        return this.landScapeCustomWidth;
    }

    public final int d3() {
        return this.margin;
    }

    public final float e3() {
        return this.maskAlpha;
    }

    public final String f3() {
        return this.maskBgColor;
    }

    public final boolean g3() {
        return this.needAnimation;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getMarginBottom() {
        return this.marginBottom;
    }

    public final int getMarginRight() {
        return this.marginRight;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean h3() {
        return this.padUsePhoneSize;
    }

    public final int i3() {
        return this.padUsePlayerBottomHeight;
    }

    public final String j3() {
        return this.popUpType;
    }

    public final int k3() {
        return this.pullDownHeight;
    }

    public final int l3() {
        return this.radius;
    }

    public final int m3() {
        return this.radiusBottomLeft;
    }

    public final int n3() {
        return this.radiusBottomRight;
    }

    public final int o3() {
        return this.radiusTopLeft;
    }

    public final int p3() {
        return this.radiusTopRight;
    }

    public final int q3() {
        return this.rateHeight;
    }

    public final boolean r3() {
        return this.showDim;
    }

    public final boolean s3() {
        return this.showDimForce;
    }

    public final int t3() {
        return this.upCloseIconPosition;
    }

    public final int u3() {
        return this.upHeightPercent;
    }

    public final int v3() {
        return this.upOffsetHeight;
    }

    public final String w3() {
        return this.upStatusBarBgColor;
    }

    public final boolean x3() {
        return this.upTransStatusBar;
    }

    public final boolean y3() {
        return this.useBottomClose;
    }

    public final int z3() {
        return this.usePlayerBottomHeight;
    }

    public /* synthetic */ PopupHybridParamVoNew(int r51) {
        this(FontWeight.WEIGHT_300, 400, 0, 0, 0, 0, -1, 0, 0, 0, 8, 0, 0, 0, 0, 17, false, false, false, false, false, false, true, 0, 0, -1, false, false, false, -1, 0, 0, "", 0, "", true, true, false, 0.0f, "", 0, 0, false, 0, 0, 0, false, false, false);
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.FragmentParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew
    public final void F(u8.a r51) {
        super.F(r51);
        v8.a r1 = this.T;
        if (r1 != null) goto L5;
        return;
    L5:
        if (((Number) r1.b("use_host", 0)).intValue() != 1) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == false) goto L10;
        BaseHybridParamVoNew.HybridType r11 = BaseHybridParamVoNew.HybridType.HOST_H5;
    L11:
        HybridTypeNew r12 = r51.d;
        if (r12 != null) goto L14;
    L16:
        int r13 = ((Number) r1.b("radius", 8)).intValue();
        int r14 = ((Number) r1.b("radius_top_right", 0)).intValue();
        int r15 = ((Number) r1.b("radius_top_left", 0)).intValue();
        int r16 = ((Number) r1.b("radius_bottom_right", 0)).intValue();
        int r17 = ((Number) r1.b("radius_bottom_left", 0)).intValue();
        int r18 = ((Number) r1.b("radius_enable_each", 0)).intValue();
        int r19 = ((Number) r1.b("height", 400)).intValue();
        int r110 = ((Number) r1.b("width", Integer.valueOf(FontWeight.WEIGHT_300))).intValue();
        int r111 = ((Number) r1.b("margin", 0)).intValue();
        int r112 = ((Number) r1.b("margin_bottom", 0)).intValue();
        int r20 = ((Number) r1.b("margin_right", 0)).intValue();
        int r21 = ((Number) r1.b("height_percent", 0)).intValue();
        int r113 = ((Number) r1.b("width_percent", 0)).intValue();
        int r114 = ((Number) r1.b("horizontal_height", 0)).intValue();
        int r22 = ((Number) r1.b("horizontal_width", 0)).intValue();
        int r23 = ((Number) r1.b("horizontal_height_percent", 0)).intValue();
        int r24 = ((Number) r1.b("horizontal_width_percent", 0)).intValue();
        int r25 = ((Number) r1.b("horizontal_radius", -1)).intValue();
        float r26 = ((Number) r1.b("mask_alpha", Float.valueOf(0.0f))).floatValue();
        String r115 = (String) r1.b("mask_bg_color", "");
        if (((Number) r1.b("show_dim", 0)).intValue() != 1) goto L19;
        boolean r27 = true;
    L20:
        boolean r28 = r27;
        if (((Number) r1.b("show_mask", 0)).intValue() != 1) goto L23;
        boolean r116 = true;
    L24:
        boolean r29 = r116;
        if (((Number) r1.b("mask_click_disable", 0)).intValue() != 0) goto L27;
        boolean r117 = true;
    L28:
        boolean r210 = r117;
        if (((Number) r1.b("disable_outside_click_close", 0)).intValue() != 0) goto L31;
        boolean r30 = true;
    L32:
        boolean r31 = r30;
        if (((Number) r1.b("open_animate", 1)).intValue() != 1) goto L35;
        boolean r32 = true;
    L36:
        String r118 = (String) r1.b("show_from", "");
        boolean r33 = r32;
        String r34 = (String) r1.b("transition_animation", "auto");
        if (((Number) r1.b("landscape_custom_gravity", 0)).intValue() != 1) goto L39;
        boolean r35 = true;
    L40:
        boolean r36 = r35;
        if (((Number) r1.b("landscape_custom_height", 0)).intValue() != 1) goto L43;
        boolean r37 = true;
    L44:
        boolean r38 = r37;
        int r39 = ((Number) r1.b("rate_height", -1)).intValue();
        String r40 = (String) r1.b("up_status_bar_bg_color", "");
        if (((Number) r1.b("landscape_custom_width", 0)).intValue() != 1) goto L47;
        boolean r41 = true;
    L48:
        boolean r310 = r41;
        if (((Number) r1.b("up_full_screen", 0)).intValue() != 1) goto L51;
        boolean r42 = true;
    L52:
        boolean r311 = r42;
        int r43 = ((Number) r1.b("up_offset_height", -1)).intValue();
        if (((Number) r1.b("disable_nested_child_scroll", 0)).intValue() != 1) goto L55;
        boolean r44 = true;
    L56:
        boolean r312 = r44;
        int r45 = ((Number) r1.b("close_icon_position", 0)).intValue();
        if (((Number) r1.b("window_floating", 1)).intValue() != 1) goto L59;
        boolean r46 = true;
    L60:
        boolean r47 = r46;
        if (((Number) r1.b("use_real_screen_height", 0)).intValue() != 1) goto L63;
        boolean r48 = true;
    L64:
        boolean r49 = r48;
        int r50 = ((Number) r1.b("up_height_percent", 0)).intValue();
        if (((Number) r1.b("up_trans_status_bar", 0)).intValue() != 1) goto L67;
        boolean r52 = true;
    L68:
        boolean r410 = r52;
        int r53 = ((Number) r1.b("is_already_adaptation_ui", 0)).intValue();
        if (((Number) r1.b("allowing_state_loss", 0)).intValue() != 1) goto L71;
        boolean r54 = true;
    L72:
        boolean r411 = r54;
        if (((Number) r1.b("delay_open", 0)).intValue() != 1) goto L75;
        boolean r55 = true;
    L76:
        boolean r412 = r55;
        if (((Number) r1.b("abandon_coordinate", 0)).intValue() != 1) goto L79;
        boolean r56 = true;
    L80:
        boolean r413 = r56;
        int r57 = ((Number) r1.b("pull_down_height", 0)).intValue();
        if (((Number) r1.b("pad_use_phone_size", 0)).intValue() != 1) goto L83;
        boolean r58 = true;
    L84:
        u2(r11);
        B2(true);
        this.width = r110;
        this.height = r19;
        this.margin = r111;
        this.horizontalWidth = r22;
        this.horizontalHeight = r114;
        this.horizontalHeightPercent = r23;
        this.horizontalWidthPercent = r24;
        this.horizontalRadius = r25;
        this.radius = r13;
        if (r18 != 1) goto L87;
        this.radiusTopLeft = r15;
        this.radiusTopRight = r14;
        this.radiusBottomRight = r16;
        this.radiusBottomLeft = r17;
    L87:
        this.gravity = 17;
        this.rateHeight = r39;
        this.useRealScreenHeight = r49;
        this.upStatusBarBgColor = r40;
        this.enablePullUp = r311;
        this.upOffsetHeight = r43;
        this.disableNestedChildScroll = r312;
        this.upCloseIconPosition = r45;
        this.landScapeCustomWidth = r310;
        this.heightPercent = r21;
        this.widthPercent = r113;
        if (StringsKt.isBlank(r118) == false) goto L90;
        String r119 = r34;
    L91:
        this.popUpType = r119;
        if (r33 == true) goto L94;
    L98:
        boolean r59 = false;
    L99:
        this.needAnimation = r59;
        this.landScapeCustomGravity = r36;
        this.landScapeCustomHeight = r38;
        this.maskAlpha = r26;
        this.maskBgColor = v8.a.a(r115);
        if (r28 == true) goto L104;
        if (r29 == true) goto L104;
        boolean r60 = false;
    L105:
        this.showDim = r60;
        if (r28 == true) goto L110;
        if (r29 == true) goto L110;
        boolean r61 = false;
    L111:
        this.showDimForce = r61;
        this.windowFloating = r47;
        if (r210 == false) goto L115;
        if (r31 == false) goto L115;
        boolean r62 = true;
    L116:
        this.canceledOnTouchOutside = r62;
        this.upHeightPercent = r50;
        this.upTransStatusBar = r410;
        this.isAlreadyAdaptationUi = r53;
        this.marginBottom = r112;
        this.marginRight = r20;
        this.abandonCoordinate = r413;
        this.pullDownHeight = r57;
        this.allowingStateLoss = r411;
        this.delayOpen = r412;
        this.padUsePhoneSize = r58;
        return;
    L115:
        r62 = false;
    L110:
        r61 = true;
    L104:
        r60 = true;
        goto L105
    L94:
        if (Intrinsics.areEqual(r34, "none") == true) goto L98;
        if (StringsKt.isBlank(r115) == false) goto L98;
        r59 = true;
        goto L99
    L90:
        r119 = r118;
        goto L91
    L83:
        r58 = false;
        goto L84
    L79:
        r56 = false;
        goto L80
    L75:
        r55 = false;
        goto L76
    L71:
        r54 = false;
        goto L72
    L67:
        r52 = false;
        goto L68
    L63:
        r48 = false;
        goto L64
    L59:
        r46 = false;
        goto L60
    L55:
        r44 = false;
        goto L56
    L51:
        r42 = false;
        goto L52
    L47:
        r41 = false;
        goto L48
    L43:
        r37 = false;
        goto L44
    L39:
        r35 = false;
        goto L40
    L35:
        r32 = false;
        goto L36
    L31:
        r30 = false;
        goto L32
    L27:
        r117 = false;
        goto L28
    L23:
        r116 = false;
        goto L24
    L19:
        r27 = false;
        goto L20
    L14:
        if (r12 != HybridTypeNew.Lynx) goto L16;
        r11 = BaseHybridParamVoNew.HybridType.LYNX;
        goto L16
    L10:
        r11 = BaseHybridParamVoNew.HybridType.H5;
        goto L11
    L7:
        r10 = false;
        goto L8
    }

    public final void G3(boolean r1) {
        this.abandonCoordinate = r1;
    }

    public final void H3(boolean r1) {
        this.allowingStateLoss = r1;
    }

    public final void I3(int r1) {
        this.isAlreadyAdaptationUi = r1;
    }

    public final void J3(boolean r1) {
        this.canceledOnTouchOutside = r1;
    }

    public final void K3(boolean r1) {
        this.disableNestedChildScroll = r1;
    }

    public final void L3(boolean r1) {
        this.enablePullUp = r1;
    }

    public final void M3(int r1) {
        this.gravity = r1;
    }

    public final void N3(int r1) {
        this.height = r1;
    }

    public final void O3(int r1) {
        this.heightPercent = r1;
    }

    public final void P3(int r1) {
        this.horizontalHeight = r1;
    }

    public final void Q3(int r1) {
        this.horizontalHeightPercent = r1;
    }

    public final void R3(int r1) {
        this.horizontalRadius = r1;
    }

    public final void S3(int r1) {
        this.horizontalWidth = r1;
    }

    public final void T3(int r1) {
        this.horizontalWidthPercent = r1;
    }

    public final void U3(boolean r1) {
        this.landScapeCustomGravity = r1;
    }

    public final void V3(boolean r1) {
        this.landScapeCustomHeight = r1;
    }

    public final void W3(boolean r1) {
        this.landScapeCustomWidth = r1;
    }

    public final void X3(int r1) {
        this.margin = r1;
    }

    public final void Y3(int r1) {
        this.marginBottom = r1;
    }

    public final void Z3(int r1) {
        this.marginRight = r1;
    }

    public final void a4(float r1) {
        this.maskAlpha = r1;
    }

    public final void b4(boolean r1) {
        this.needAnimation = r1;
    }

    public final void c4(int r1) {
        this.padUsePlayerBottomHeight = r1;
    }

    public final void d4(String r1) {
        this.popUpType = r1;
    }

    public final void e4(int r1) {
        this.pullDownHeight = r1;
    }

    public final void f4(int r1) {
        this.radius = r1;
    }

    public final void g4(int r1) {
        this.radiusBottomLeft = r1;
    }

    public final void h4(int r1) {
        this.radiusBottomRight = r1;
    }

    public final void i4(int r1) {
        this.radiusTopLeft = r1;
    }

    public final void j4(int r1) {
        this.radiusTopRight = r1;
    }

    public final void k4(int r1) {
        this.rateHeight = r1;
    }

    public final void l4(boolean r1) {
        this.showDim = r1;
    }

    public final void m4(boolean r1) {
        this.showDimForce = r1;
    }

    public final void n4(int r1) {
        this.upCloseIconPosition = r1;
    }

    public final void o4(int r1) {
        this.upHeightPercent = r1;
    }

    public final void p4(int r1) {
        this.upOffsetHeight = r1;
    }

    public final void q4(String r1) {
        this.upStatusBarBgColor = r1;
    }

    public final void r4(boolean r1) {
        this.upTransStatusBar = r1;
    }

    public final void s4(boolean r1) {
        this.useBottomClose = r1;
    }

    public final void t4(int r1) {
        this.usePlayerBottomHeight = r1;
    }

    public final void u4(boolean r1) {
        this.useRealScreenHeight = r1;
    }

    public final void v4(int r1) {
        this.width = r1;
    }

    public final void w4(int r1) {
        this.widthPercent = r1;
    }

    public final void x4(boolean r1) {
        this.windowFloating = r1;
    }

    public final void y4(int r1) {
        this.xOffset = r1;
    }

    public final void z4(int r1) {
        this.yOffset = r1;
    }

    public PopupHybridParamVoNew(int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r110, int r111, int r112, int r113, int r114, int r115, boolean r116, boolean r20, boolean r21, boolean r22, boolean r23, boolean r24, boolean r25, int r26, int r27, int r28, boolean r29, boolean r30, boolean r31, int r32, int r33, int r34, String r35, int r36, String r37, boolean r38, boolean r39, boolean r40, float r41, String r42, int r43, int r44, boolean r45, int r46, int r47, int r48, boolean r49, boolean r50, boolean r51) {
        super(0);
        this.width = r10;
        this.height = r11;
        this.horizontalWidth = r12;
        this.horizontalHeight = r13;
        this.horizontalHeightPercent = r14;
        this.horizontalWidthPercent = r15;
        this.horizontalRadius = r16;
        this.margin = r17;
        this.marginBottom = r18;
        this.marginRight = r19;
        this.radius = r110;
        this.radiusTopLeft = r111;
        this.radiusTopRight = r112;
        this.radiusBottomRight = r113;
        this.radiusBottomLeft = r114;
        this.gravity = r115;
        this.useBottomClose = r116;
        this.landScapeCustomHeight = r20;
        this.landScapeCustomWidth = r21;
        this.landScapeCustomGravity = r22;
        this.showDim = r23;
        this.showDimForce = r24;
        this.canceledOnTouchOutside = r25;
        this.heightPercent = r26;
        this.widthPercent = r27;
        this.rateHeight = r28;
        this.useRealScreenHeight = r29;
        this.enablePullUp = r30;
        this.disableNestedChildScroll = r31;
        this.upOffsetHeight = r32;
        this.usePlayerBottomHeight = r33;
        this.padUsePlayerBottomHeight = r34;
        this.upStatusBarBgColor = r35;
        this.isAlreadyAdaptationUi = r36;
        this.popUpType = r37;
        this.needAnimation = r38;
        this.windowFloating = r39;
        this.abandonCoordinate = r40;
        this.maskAlpha = r41;
        this.maskBgColor = r42;
        this.upCloseIconPosition = r43;
        this.upHeightPercent = r44;
        this.upTransStatusBar = r45;
        this.xOffset = r46;
        this.yOffset = r47;
        this.pullDownHeight = r48;
        this.allowingStateLoss = r49;
        this.delayOpen = r50;
        this.padUsePhoneSize = r51;
    }
}
