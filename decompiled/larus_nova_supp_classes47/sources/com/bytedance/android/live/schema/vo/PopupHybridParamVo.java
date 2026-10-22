package com.bytedance.android.live.schema.vo;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.live.saas.middleware.alog.config.ALogDefaultConfig;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\"\u00101\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00107\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u00102\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\"\u0010:\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u00102\u001a\u0004\b;\u00104\"\u0004\b<\u00106R\"\u0010=\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u00102\u001a\u0004\b>\u00104\"\u0004\b?\u00106R\"\u0010@\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u00102\u001a\u0004\bA\u00104\"\u0004\bB\u00106R\"\u0010C\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u00102\u001a\u0004\bD\u00104\"\u0004\bE\u00106R\"\u0010F\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010\u0004\u001a\u0004\bG\u0010\u0006\"\u0004\bH\u0010\bR\"\u0010I\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010\u0004\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\bR\"\u0010L\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bL\u0010\u0004\u001a\u0004\bM\u0010\u0006\"\u0004\bN\u0010\bR\"\u0010O\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bO\u00102\u001a\u0004\bP\u00104\"\u0004\bQ\u00106R\"\u0010R\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010\u0004\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR\"\u0010U\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u0010\u0004\u001a\u0004\bV\u0010\u0006\"\u0004\bW\u0010\bR\"\u0010X\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bX\u0010\u0004\u001a\u0004\bY\u0010\u0006\"\u0004\b2\u0010\bR$\u0010[\u001a\u0004\u0018\u00010Z8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010a\u001a\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\ba\u00102\u001a\u0004\bb\u00104\"\u0004\bc\u00106R\"\u0010e\u001a\u00020d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\be\u0010A\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\"\u0010j\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bj\u0010\u0004\u001a\u0004\b\u0004\u0010\u0006\"\u0004\bk\u0010\b¨\u0006l"}, d2 = {"Lcom/bytedance/android/live/schema/vo/PopupHybridParamVo;", "Landroid/os/Parcelable;", "", "width", "I", "getWidth", "()I", "a0", "(I)V", "height", "getHeight", "setHeight", "horizontalWidth", "e", "setHorizontalWidth", "horizontalHeight", "c", "setHorizontalHeight", "horizontalHeightPercent", "d", "setHorizontalHeightPercent", "horizontalWidthPercent", "g", "setHorizontalWidthPercent", "margin", "k", "setMargin", "radius", "r", "R", "horizontalRadius", "getHorizontalRadius", "setHorizontalRadius", "radiusTopLeft", "z", "W", "radiusTopRight", "D", "Y", "radiusBottomRight", "t", "U", "radiusBottomLeft", "s", "S", "gravity", "a", "N", "", "useBottomClose", "Z", "L", "()Z", "setUseBottomClose", "(Z)V", "landScapeCustomHeight", "i", "setLandScapeCustomHeight", "landScapeCustomWidth", "j", "setLandScapeCustomWidth", "landScapeCustomGravity", "h", "setLandScapeCustomGravity", "showDim", "F", "setShowDim", "canceledOnTouchOutside", "getCanceledOnTouchOutside", "setCanceledOnTouchOutside", "heightPercent", "b", "setHeightPercent", "widthPercent", "M", "setWidthPercent", "rateHeight", "E", "setRateHeight", "enablePullUp", "getEnablePullUp", "setEnablePullUp", "upOffsetHeight", "J", "setUpOffsetHeight", "upHeightPercent", "getUpHeightPercent", "setUpHeightPercent", "usePlayerBottomHeight", "getUsePlayerBottomHeight", "", "upStatusBarBgColor", "Ljava/lang/String;", "K", "()Ljava/lang/String;", "setUpStatusBarBgColor", "(Ljava/lang/String;)V", "needAnimation", "q", "O", "", "maskAlpha", "o", "()F", "setMaskAlpha", "(F)V", "upCloseIconPosition", "setUpCloseIconPosition", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PopupHybridParamVo implements Parcelable {
    public static final Parcelable.Creator<PopupHybridParamVo> CREATOR = null;
    public int a;
    public final boolean b;
    public final String c;

    @SerializedName("mask_click_disable")
    private boolean canceledOnTouchOutside;
    public final String d;
    public String e;

    @SerializedName("up_full_screen")
    private boolean enablePullUp;
    public final boolean f;
    public final boolean g;

    @SerializedName("gravity")
    private int gravity;
    public final int h;

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
    public final boolean i;
    public LynxHybridParamVo j;
    public BaseHybridParamVo k;
    public final boolean l;

    @SerializedName("landScape_custom_gravity")
    private boolean landScapeCustomGravity;

    @SerializedName("landscape_custom_height")
    private boolean landScapeCustomHeight;

    @SerializedName("landScape_custom_width")
    private boolean landScapeCustomWidth;
    public final String m;

    @SerializedName("margin")
    private int margin;

    @SerializedName("mask_alpha")
    private float maskAlpha;

    @SerializedName("open_animate")
    private boolean needAnimation;

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

    @SerializedName("close_icon_position")
    private int upCloseIconPosition;

    @SerializedName("up_height_percent")
    private int upHeightPercent;

    @SerializedName("up_offset_height")
    private int upOffsetHeight;

    @SerializedName("up_status_bar_bg_color")
    private String upStatusBarBgColor;

    @SerializedName("use_bottom_close")
    private boolean useBottomClose;

    @SerializedName("use_player_bottom_height")
    private int usePlayerBottomHeight;

    @SerializedName("width")
    private int width;

    @SerializedName("width_percent")
    private int widthPercent;

    public static class a implements Parcelable.Creator<PopupHybridParamVo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PopupHybridParamVo createFromParcel(Parcel r50) {
            Intrinsics.checkNotNullParameter(r50, "in");
            int r3 = r50.readInt();
            int r4 = r50.readInt();
            int r5 = r50.readInt();
            int r6 = r50.readInt();
            int r7 = r50.readInt();
            int r8 = r50.readInt();
            int r9 = r50.readInt();
            int r10 = r50.readInt();
            int r12 = r50.readInt();
            int r13 = r50.readInt();
            int r14 = r50.readInt();
            int r15 = r50.readInt();
            int r16 = r50.readInt();
            int r17 = r50.readInt();
            if (r50.readInt() == 0) goto L5;
            boolean r19 = true;
        L7:
            if (r50.readInt() == 0) goto L9;
            boolean r20 = true;
        L11:
            if (r50.readInt() == 0) goto L13;
            boolean r22 = true;
        L15:
            if (r50.readInt() == 0) goto L17;
            boolean r23 = true;
        L19:
            if (r50.readInt() == 0) goto L21;
            boolean r24 = true;
        L22:
            int r25 = r50.readInt();
            if (r50.readInt() == 0) goto L25;
            boolean r26 = true;
        L27:
            if (r50.readInt() == 0) goto L29;
            boolean r27 = true;
        L30:
            int r28 = r50.readInt();
            int r29 = r50.readInt();
            int r210 = r50.readInt();
            if (r50.readInt() == 0) goto L33;
            boolean r30 = true;
        L34:
            int r32 = r50.readInt();
            int r33 = r50.readInt();
            int r34 = r50.readInt();
            String r35 = r50.readString();
            String r36 = r50.readString();
            String r37 = r50.readString();
            String r38 = r50.readString();
            if (r50.readInt() == 0) goto L37;
            boolean r39 = true;
        L39:
            if (r50.readInt() == 0) goto L41;
            boolean r310 = true;
        L43:
            if (r50.readInt() == 0) goto L45;
            boolean r40 = true;
        L46:
            float r42 = r50.readFloat();
            int r43 = r50.readInt();
            if (r50.readInt() == 0) goto L49;
            boolean r44 = true;
        L50:
            int r45 = r50.readInt();
            BaseHybridParamVo r46 = null;
            if (r50.readInt() == 0) goto L53;
            LynxHybridParamVo r47 = LynxHybridParamVo.CREATOR.createFromParcel(r50);
        L55:
            if (r50.readInt() == 0) goto L58;
            r46 = BaseHybridParamVo.CREATOR.createFromParcel(r50);
        L58:
            if (r50.readInt() == 0) goto L60;
            boolean r48 = true;
        L62:
            return new PopupHybridParamVo(r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r210, r30, r32, r33, r34, r35, r36, r37, r38, r39, r310, r40, r42, r43, r44, r45, r47, r46, r48, r50.readString());
        L60:
            r48 = false;
            goto L62
        L53:
            r47 = null;
            goto L55
        L49:
            r44 = false;
            goto L50
        L45:
            r40 = false;
            goto L46
        L41:
            r310 = false;
            goto L43
        L37:
            r39 = false;
            goto L39
        L33:
            r30 = false;
            goto L34
        L29:
            r27 = false;
            goto L30
        L25:
            r26 = false;
            goto L27
        L21:
            r24 = false;
            goto L22
        L17:
            r23 = false;
            goto L19
        L13:
            r22 = false;
            goto L15
        L9:
            r20 = false;
            goto L11
        L5:
            r19 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final PopupHybridParamVo[] newArray(int r1) {
            return new PopupHybridParamVo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public final void R() {
        this.radius = 0;
    }

    public final void S() {
        this.radiusBottomLeft = 0;
    }

    public final void U() {
        this.radiusBottomRight = 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeInt(this.width);
        r3.writeInt(this.height);
        r3.writeInt(this.horizontalWidth);
        r3.writeInt(this.horizontalHeight);
        r3.writeInt(this.horizontalHeightPercent);
        r3.writeInt(this.horizontalWidthPercent);
        r3.writeInt(this.margin);
        r3.writeInt(this.radius);
        r3.writeInt(this.horizontalRadius);
        r3.writeInt(this.radiusTopLeft);
        r3.writeInt(this.radiusTopRight);
        r3.writeInt(this.radiusBottomRight);
        r3.writeInt(this.radiusBottomLeft);
        r3.writeInt(this.gravity);
        r3.writeInt(this.useBottomClose ? 1 : 0);
        r3.writeInt(this.landScapeCustomHeight ? 1 : 0);
        r3.writeInt(this.landScapeCustomWidth ? 1 : 0);
        r3.writeInt(this.landScapeCustomGravity ? 1 : 0);
        r3.writeInt(this.showDim ? 1 : 0);
        r3.writeInt(this.a);
        r3.writeInt(this.b ? 1 : 0);
        r3.writeInt(this.canceledOnTouchOutside ? 1 : 0);
        r3.writeInt(this.heightPercent);
        r3.writeInt(this.widthPercent);
        r3.writeInt(this.rateHeight);
        r3.writeInt(this.enablePullUp ? 1 : 0);
        r3.writeInt(this.upOffsetHeight);
        r3.writeInt(this.upHeightPercent);
        r3.writeInt(this.usePlayerBottomHeight);
        r3.writeString(this.c);
        r3.writeString(this.upStatusBarBgColor);
        r3.writeString(this.d);
        r3.writeString(this.e);
        r3.writeInt(this.needAnimation ? 1 : 0);
        r3.writeInt(this.f ? 1 : 0);
        r3.writeInt(this.g ? 1 : 0);
        r3.writeFloat(this.maskAlpha);
        r3.writeInt(this.h);
        r3.writeInt(this.i ? 1 : 0);
        r3.writeInt(this.upCloseIconPosition);
        LynxHybridParamVo r5 = this.j;
        if (r5 == null) goto L5;
        r3.writeInt(1);
        r5.writeToParcel(r3, 0);
    L6:
        BaseHybridParamVo r6 = this.k;
        if (r6 == null) goto L9;
        r3.writeInt(1);
        r6.writeToParcel(r3, 0);
    L10:
        r3.writeInt(this.l ? 1 : 0);
        r3.writeString(this.m);
        return;
    L9:
        r3.writeInt(0);
        goto L10
    L5:
        r3.writeInt(0);
        goto L6
    }

    public final void N() {
        this.gravity = 80;
    }

    public final String toString() {
        return "PopupHybridParamVo(width=" + this.width + ", height=" + this.height + ", horizontalWidth=" + this.horizontalWidth + ", horizontalHeight=" + this.horizontalHeight + ",horizontalHeightPercent=" + this.horizontalHeightPercent + ", horizontalWidthPercent=" + this.horizontalWidthPercent + ", margin=" + this.margin + ", radius=" + this.radius + ", radiusTopLeft=" + this.radiusTopLeft + ", radiusTopRight=" + this.radiusTopRight + ", radiusBottomRight=" + this.radiusBottomRight + ", radiusBottomLeft=" + this.radiusBottomLeft + ", gravity=" + this.gravity + ", useBottomClose=" + this.useBottomClose + ", landScapeCustomHeight=" + this.landScapeCustomHeight + ", landScapeCustomWidth=" + this.landScapeCustomWidth + ", landScapeCustomGravity=" + this.landScapeCustomGravity + ", showDim=" + this.showDim + ", showDimForce=" + this.b + ", drawableBackgroundWidth=" + this.a + ", canceledOnTouchOutside=" + this.canceledOnTouchOutside + ", heightPercent=" + this.heightPercent + ", widthPercent=" + this.widthPercent + ", rateHeight=" + this.rateHeight + ", enablePullUp=" + this.enablePullUp + ", upOffsetHeight=" + this.upOffsetHeight + ", upStatusBarColor=" + this.c + ", upStatusBarBgColor=" + this.upStatusBarBgColor + ", extraData=" + this.d + ", popUpType=" + this.e + ", needAnimation=" + this.needAnimation + ", windowFloating=" + this.f + ", abandonCoordinate=" + this.g + ", maskAlpha=" + this.maskAlpha + ", closeType=" + this.h + ", closeIconPositionRight=" + this.i + ", upCloseIconPosition=" + this.upCloseIconPosition + ", autoShowNavBar=" + this.l + ", upHeightPercent=" + this.upHeightPercent + ", lynxHybridParamVo=" + this.j + ", commonHybridParam=" + this.k + "),showAnimationType=" + this.m;
    }

    public final int D() {
        return this.radiusTopRight;
    }

    public final int E() {
        return this.rateHeight;
    }

    public final boolean F() {
        return this.showDim;
    }

    public final int I() {
        return this.upCloseIconPosition;
    }

    public final int J() {
        return this.upOffsetHeight;
    }

    public final String K() {
        return this.upStatusBarBgColor;
    }

    public final boolean L() {
        return this.useBottomClose;
    }

    public final int M() {
        return this.widthPercent;
    }

    public final int a() {
        return this.gravity;
    }

    public final int b() {
        return this.heightPercent;
    }

    public final int c() {
        return this.horizontalHeight;
    }

    public final int d() {
        return this.horizontalHeightPercent;
    }

    public final int e() {
        return this.horizontalWidth;
    }

    public final int g() {
        return this.horizontalWidthPercent;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean h() {
        return this.landScapeCustomGravity;
    }

    public final boolean i() {
        return this.landScapeCustomHeight;
    }

    public final boolean j() {
        return this.landScapeCustomWidth;
    }

    public final int k() {
        return this.margin;
    }

    public final float o() {
        return this.maskAlpha;
    }

    public final boolean q() {
        return this.needAnimation;
    }

    public final int r() {
        return this.radius;
    }

    public final int s() {
        return this.radiusBottomLeft;
    }

    public final int t() {
        return this.radiusBottomRight;
    }

    public final int z() {
        return this.radiusTopLeft;
    }

    public final void O(boolean r1) {
        this.needAnimation = r1;
    }

    public final void W(int r1) {
        this.radiusTopLeft = r1;
    }

    public final void Y(int r1) {
        this.radiusTopRight = r1;
    }

    public final void Z(int r1) {
        this.usePlayerBottomHeight = r1;
    }

    public final void a0(int r1) {
        this.width = r1;
    }

    public /* synthetic */ PopupHybridParamVo(int r50, int r52, int r53, int r54, int r55, int r56, int r57, int r58, int r59, int r510, int r60, int r62, int r63, int r64, boolean r65, boolean r66, boolean r67, boolean r68, boolean r69, boolean r610, boolean r70, int r72, int r73, int r74, boolean r75, int r76, int r77, String r78, String r79, String r710, boolean r80, boolean r82, boolean r83, float r84, int r85, boolean r86, int r87, LynxHybridParamVo r88, BaseHybridParamVo r89, boolean r810, String r90, int r92, int r93) {
        if ((r92 & 1) == 0) goto L5;
        int r5 = 0;
    L7:
        if ((r92 & 2) == 0) goto L9;
        int r6 = 0;
    L11:
        if ((r92 & 4) == 0) goto L13;
        int r7 = 0;
    L15:
        if ((r92 & 8) == 0) goto L17;
        int r8 = 0;
    L19:
        if ((r92 & 16) == 0) goto L21;
        int r9 = 0;
    L23:
        if ((r92 & 32) == 0) goto L25;
        int r10 = 0;
    L27:
        if ((r92 & 64) == 0) goto L29;
        int r12 = 0;
    L31:
        if ((r92 & 128) == 0) goto L33;
        int r13 = 0;
    L35:
        if ((r92 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L37;
        int r14 = -1;
    L39:
        if ((r92 & 512) == 0) goto L41;
        int r15 = 0;
    L43:
        if ((r92 & 1024) == 0) goto L45;
        int r16 = 0;
    L47:
        if ((r92 & 2048) == 0) goto L49;
        int r17 = 0;
    L51:
        if ((r92 & 4096) == 0) goto L53;
        int r18 = 0;
    L55:
        if ((r92 & 8192) == 0) goto L57;
        int r19 = 0;
    L59:
        if ((r92 & 16384) == 0) goto L61;
        boolean r110 = false;
    L63:
        if ((32768 & r92) == 0) goto L65;
        boolean r20 = false;
    L67:
        if ((65536 & r92) == 0) goto L69;
        boolean r22 = false;
    L71:
        if ((131072 & r92) == 0) goto L73;
        boolean r23 = false;
    L75:
        if ((262144 & r92) == 0) goto L77;
        boolean r2 = true;
    L79:
        if ((r92 & 1048576) == 0) goto L81;
        boolean r25 = true;
    L83:
        if ((r92 & ALogDefaultConfig.ALOG_ZONE_SIZE) == 0) goto L85;
        boolean r26 = true;
    L87:
        if ((r92 & 4194304) == 0) goto L89;
        int r27 = 0;
    L91:
        if ((r92 & 8388608) == 0) goto L93;
        int r28 = 0;
    L95:
        if ((r92 & 16777216) == 0) goto L97;
        int r29 = -1;
    L99:
        if ((r92 & 33554432) == 0) goto L101;
        boolean r30 = false;
    L103:
        if ((r92 & 67108864) == 0) goto L105;
        int r32 = -1;
    L107:
        if ((134217728 & r92) == 0) goto L109;
        int r33 = 70;
    L111:
        if ((1073741824 & r92) == 0) goto L113;
        String r36 = null;
    L115:
        if ((r92 & Integer.MIN_VALUE) == 0) goto L117;
        String r0 = null;
    L119:
        if ((r93 & 1) == 0) goto L121;
        String r37 = "";
    L123:
        if ((r93 & 2) == 0) goto L125;
        boolean r38 = true;
    L127:
        if ((r93 & 4) == 0) goto L129;
        boolean r39 = true;
    L131:
        if ((r93 & 8) == 0) goto L133;
        boolean r40 = false;
    L135:
        if ((r93 & 16) == 0) goto L137;
        float r42 = 0.0f;
    L139:
        if ((r93 & 32) == 0) goto L141;
        int r43 = 0;
    L143:
        if ((r93 & 64) == 0) goto L145;
        boolean r44 = false;
    L147:
        if ((r93 & 128) == 0) goto L149;
        int r45 = 0;
    L151:
        if ((r93 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L153;
        LynxHybridParamVo r46 = null;
    L155:
        if ((r93 & 1024) == 0) goto L157;
        boolean r47 = false;
    L159:
        if ((r93 & 2048) == 0) goto L161;
        String r48 = "bottom";
    L162:
        this(r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19, r110, r20, r22, r23, r2, 0, r25, r26, r27, r28, r29, r30, r32, r33, 0, null, r36, r0, r37, r38, r39, r40, r42, r43, r44, r45, r46, r89, r47, r48);
        return;
    L161:
        r48 = r90;
        goto L162
    L157:
        r47 = r810;
        goto L159
    L153:
        r46 = r88;
        goto L155
    L149:
        r45 = r87;
        goto L151
    L145:
        r44 = r86;
        goto L147
    L141:
        r43 = r85;
        goto L143
    L137:
        r42 = r84;
        goto L139
    L133:
        r40 = r83;
        goto L135
    L129:
        r39 = r82;
        goto L131
    L125:
        r38 = r80;
        goto L127
    L121:
        r37 = r710;
        goto L123
    L117:
        r0 = r79;
        goto L119
    L113:
        r36 = r78;
        goto L115
    L109:
        r33 = r77;
        goto L111
    L105:
        r32 = r76;
        goto L107
    L101:
        r30 = r75;
        goto L103
    L97:
        r29 = r74;
        goto L99
    L93:
        r28 = r73;
        goto L95
    L89:
        r27 = r72;
        goto L91
    L85:
        r26 = r70;
        goto L87
    L81:
        r25 = r610;
        goto L83
    L77:
        r2 = r69;
        goto L79
    L73:
        r23 = r68;
        goto L75
    L69:
        r22 = r67;
        goto L71
    L65:
        r20 = r66;
        goto L67
    L61:
        r110 = r65;
        goto L63
    L57:
        r19 = r64;
        goto L59
    L53:
        r18 = r63;
        goto L55
    L49:
        r17 = r62;
        goto L51
    L45:
        r16 = r60;
        goto L47
    L41:
        r15 = r510;
        goto L43
    L37:
        r14 = r59;
        goto L39
    L33:
        r13 = r58;
        goto L35
    L29:
        r12 = r57;
        goto L31
    L25:
        r10 = r56;
        goto L27
    L21:
        r9 = r55;
        goto L23
    L17:
        r8 = r54;
        goto L19
    L13:
        r7 = r53;
        goto L15
    L9:
        r6 = r52;
        goto L11
    L5:
        r5 = r50;
        goto L7
    }

    public PopupHybridParamVo(int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r12, int r13, int r14, int r15, int r16, int r17, boolean r18, boolean r19, boolean r110, boolean r20, boolean r22, int r23, boolean r24, boolean r25, int r26, int r27, int r28, boolean r29, int r210, int r30, int r32, String r33, String r34, String r35, String r36, boolean r37, boolean r38, boolean r39, float r310, int r40, boolean r42, int r43, LynxHybridParamVo r44, BaseHybridParamVo r45, boolean r46, String r47) {
        this.width = r3;
        this.height = r4;
        this.horizontalWidth = r5;
        this.horizontalHeight = r6;
        this.horizontalHeightPercent = r7;
        this.horizontalWidthPercent = r8;
        this.margin = r9;
        this.radius = r10;
        this.horizontalRadius = r12;
        this.radiusTopLeft = r13;
        this.radiusTopRight = r14;
        this.radiusBottomRight = r15;
        this.radiusBottomLeft = r16;
        this.gravity = r17;
        this.useBottomClose = r18;
        this.landScapeCustomHeight = r19;
        this.landScapeCustomWidth = r110;
        this.landScapeCustomGravity = r20;
        this.showDim = r22;
        this.a = r23;
        this.b = r24;
        this.canceledOnTouchOutside = r25;
        this.heightPercent = r26;
        this.widthPercent = r27;
        this.rateHeight = r28;
        this.enablePullUp = r29;
        this.upOffsetHeight = r210;
        this.upHeightPercent = r30;
        this.usePlayerBottomHeight = r32;
        this.c = r33;
        this.upStatusBarBgColor = r34;
        this.d = r35;
        this.e = r36;
        this.needAnimation = r37;
        this.f = r38;
        this.g = r39;
        this.maskAlpha = r310;
        this.h = r40;
        this.i = r42;
        this.upCloseIconPosition = r43;
        this.j = r44;
        this.k = r45;
        this.l = r46;
        this.m = r47;
    }
}
