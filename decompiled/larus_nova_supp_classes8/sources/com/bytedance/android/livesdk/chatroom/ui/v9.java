package com.bytedance.android.livesdk.chatroom.ui;

import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.platformplayer.layout.LivePlayerWidget;
import com.bytedance.android.livesdk.config.ih0;
import com.bytedance.android.livesdk.config.kd1;
import com.bytedance.android.livesdk.config.kh0;
import com.bytedance.android.livesdk.config.pd1;
import com.bytedance.android.livesdk.config.up0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.model.CropSeiData;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.livesdkapi.view.IVideoViewCropper;
import com.bytedance.android.livesdkapi.view.SurfaceRenderView;
import com.bytedance.android.livesdkapi.view.TextureRenderView;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v9 implements IVideoViewCropper {
    public final String a;
    public final float b;
    public boolean c;
    public int d;
    public int e;
    public CropSeiData f;
    public String g;
    public final IVideoViewCropper.CropCallback h;
    public boolean i;
    public final IRenderView j;

    public final void onSurfaceTextureUpdated(long r1) {
    }

    public static boolean b() {
        boolean r0 = com.bytedance.android.live.revenue.core.util.h.a;
        if (com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).getMultiAnchorService().c().getDeviceType() != DeviceType.NORMAL_MOBILE) goto L5;
        return true;
    L5:
        return false;
    }

    public final Pair<Integer, Integer> getOriginVideoInfo() {
        return new Pair(Integer.valueOf(this.d), Integer.valueOf(this.e));
    }

    public final boolean isInteract() {
        String r3 = this.g;     // Catch: Exception -> L28
        if (r3 == null) goto L6;
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L28
        JSONObject r4 = LiveSeiUtil.c(r3);     // Catch: Exception -> L28
    L8:
        if (r4.has("info") == false) goto L19;
        if (r4.has("source") == false) goto L19;
        if (TextUtils.equals(r4.optString("source"), "zego") == false) goto L19;
        Object r0 = r4.get("info");     // Catch: Exception -> L28
        if (r0 == null) goto L17;
        r4 = (JSONObject) r0;     // Catch: Exception -> L28
        goto L19
    L17:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");     // Catch: Exception -> L28
    L19:
        if (r4.has("app_data") == false) goto L26;
        String r1 = JSONObjectProtectorUtils.getString(r4, "app_data");     // Catch: Exception -> L28
        int r2 = new JSONObject(new Regex("\\\\").replace(r1, "")).optInt("ver");     // Catch: Exception -> L28
        if (r2 != 2) goto L24;
    L25:
        return true;
    L24:
        if (r2 != 6) goto L26;
    L6:
        r4 = new JSONObject(this.g);     // Catch: Exception -> L28
    L26:
        return false;
    }

    public final CropSeiData currentCropSeiData() {
        return this.f;
    }

    public final void onOrientationChanged(boolean r2) {
        this.i = r2;
        exitVideoViewCrop(false, true);
    }

    public v9(LivePlayerWidget.n r2, IRenderView r3) {
        Intrinsics.checkNotNullParameter(r2, "cropCallback");
        Intrinsics.checkNotNullParameter(r3, "renderView");
        this.h = r2;
        this.i = true;
        this.j = r3;
        this.a = "VideoViewCropper";
        LocalTestManager.a(new Class[]{wy.a.class});
        this.b = pd1.a.getValue().floatValue() + 0.17f;
    }

    public final void exitVideoViewCrop(boolean r5, boolean r6) {
        if (r6 == false) goto L6;
        this.f = null;
    L6:
        if (this.c == true) goto L9;
        return;
    L9:
        if (up0.a.getValue().booleanValue() == true) goto L11;
    L17:
        TextureRenderView r7 = this.j;
        if ((r7 instanceof TextureRenderView) == false) goto L23;
        this.c = false;
        r7.setTransform(null);
        this.h.onCropStateChanged(false);
        if (r5 == false) goto L30;
        this.h.resizeViewByCropper(false, 0, 0);
        return;
    L30:
        return;
    L23:
        if ((r7 instanceof SurfaceView) == false) goto L32;
        this.c = false;
        ((SurfaceView) r7).setScaleX(1.0f);
        this.j.setScaleY(1.0f);
        this.h.onCropStateChanged(false);
        if (r5 == false) goto L33;
        this.h.resizeViewByCropper(false, 0, 0);
        return;
    L33:
        return;
    L32:
        return;
    L11:
        if (b() == false) goto L17;
        View r8 = this.j;
        if ((r8 instanceof View) == false) goto L17;
        this.c = false;
        r8.setScaleX(1.0f);
        this.j.setScaleY(1.0f);
        this.h.onCropStateChanged(false);
        if (r5 == false) goto L28;
        this.h.resizeViewByCropper(false, 0, 0);
        return;
    }

    public final void a(CropSeiData r11, JSONObject r12, boolean r13) {
        if ((!Intrinsics.areEqual(r11, this.f)) == true) goto L5;
        if (r13 == true) goto L5;
        return;
    L5:
        this.f = r11;
        this.d = r11.strideW;
        this.e = r11.strideH;
        boolean r0 = false;
        if (r11.isLegalCropSei() == true) goto L10;
        exitVideoViewCrop(true, false);
        Logger.d(this.a, "handleCropData, newCropSei is not crop :" + r11);
        return;
    L10:
        if (up0.a.getValue().booleanValue() == true) goto L12;
    L19:
        TextureRenderView r14 = this.j;
        if ((r14 instanceof TextureRenderView) == false) goto L43;
        TextureRenderView r15 = r14;
        Logger.d(this.a, "cropBySEI :" + r11);
        int r2 = com.bytedance.android.live.core.utils.s1.w();
        int r3 = com.bytedance.android.live.core.utils.s1.y();
        if (r2 <= r3) goto L24;
        float r4 = r3;
        float r5 = (r11.cropH * r4) / r11.cropW;
    L25:
        float r6 = r11.strideW / r11.cropW;
        float r7 = r11.strideH / r11.cropH;
        if (PadConfigUtils.c() == true) goto L49;
    L40:
        Matrix r16 = new Matrix();
        float r1 = (r11.cropX / r11.cropW) * r4;
        float r8 = r5 * (r11.cropY / r11.cropH);
        r16.preScale(r6, r7);
        r16.postTranslate(-r1, -r8);
        Logger.d(this.a, ",cropBySEI setTransform:" + r16.toString() + "translateX=" + r1 + ",showWidth=" + r4 + "");
        this.c = true;
        r15.setTransform(r16);
    L41:
        this.h.resizeViewByCropper(true, r11.cropW, r11.cropH);
        this.h.onCropStateChanged(true);
        return;
    L49:
        if (r12.has("app_data") == false) goto L38;
        JSONObject r9 = new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r12, "app_data"), ""));     // Catch: JSONException -> L37
        if (r9.has("ver") == false) goto L38;
        if (r9.optInt("ver") != 2) goto L38;
        r0 = true;
    L38:
        if (r0 == false) goto L40;
        Matrix r17 = new Matrix();
        float r10 = r4 * (r11.cropX / r11.cropW);
        float r18 = r5 * (r11.cropY / r11.cropH);
        r17.preScale(r6, r7);
        r17.postTranslate(-r10, -r18);
        this.c = true;
        r15.setTransform(r17);
        goto L41
    L24:
        r5 = r2;
        r4 = (r11.cropW * r5) / r11.cropH;
        goto L25
    L43:
        if ((r14 instanceof SurfaceRenderView) == false) goto L54;
        SurfaceView r19 = (SurfaceView) r14;
        Logger.d(this.a, "cropBySEI :" + r11);
        float r110 = ((float) r11.strideW) / ((float) r11.cropW);
        float r20 = ((float) r11.strideH) / ((float) r11.cropH);
        this.c = true;
        if (ih0.a.getValue().booleanValue() == false) goto L47;
        r19.setPivotX(r19.getWidth() / 2.0f);
        r19.setPivotY(r19.getHeight() / 2.0f);
    L47:
        r19.setScaleX(r110);
        r19.setScaleY(r20);
        Logger.d(this.a, "crop scaleX " + r19.getScaleX() + "; scaleY " + r19.getScaleY());
        this.h.resizeViewByCropper(true, r11.cropW, r11.cropH);
        this.h.onCropStateChanged(true);
        return;
    L54:
        return;
    L12:
        if (b() == false) goto L19;
        View r111 = this.j;
        if ((r111 instanceof View) == false) goto L19;
        View r112 = r111;
        Logger.d(this.a, "cropView :" + r11);
        float r113 = RangesKt.coerceAtLeast(((float) r11.strideW) / ((float) r11.cropW), ((float) r11.strideH) / ((float) r11.cropH));
        this.c = true;
        if (ih0.a.getValue().booleanValue() == false) goto L18;
        r112.setPivotX(r112.getWidth() / 2.0f);
        r112.setPivotY(r112.getHeight() / 2.0f);
    L18:
        r112.setScaleX(r113);
        r112.setScaleY(r113);
        Logger.d(this.a, "crop scaleX " + r112.getScaleX() + "; scaleY " + r112.getScaleY());
        this.h.resizeViewByCropper(true, r11.cropW, r11.cropH);
        this.h.onCropStateChanged(true);
    }

    public final void onSeiUpdate(long r6, String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "seiStr");
        IRenderView r0 = this.j;
        if ((r0 instanceof TextureRenderView) == true) goto L7;
        if ((r0 instanceof SurfaceView) == true) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L12;
        return;
    L12:
        LiveSeiUtil.i.getClass();
        if (LiveSeiUtil.b(r8) == false) goto L15;
    L17:
        Intrinsics.checkNotNullParameter(r8, "sei");
        Intrinsics.checkNotNullParameter(r8, "sei");
        if (StringsKt.contains$default(r8, "TTLiveSDK_Android", false, 2, null) == false) goto L20;
    L25:
        boolean r2 = true;
    L26:
        if (r2 == false) goto L28;
    L33:
        boolean r3 = true;
    L34:
        if (r3 == false) goto L36;
    L68:
        this.g = r8;     // Catch: JSONException -> L66
        JSONObject r10 = LiveSeiUtil.c(r8);     // Catch: JSONException -> L66
        if (r10.has("live_crop") == true) goto L42;
        exitVideoViewCrop(true, true);     // Catch: JSONException -> L66
        return;
    L42:
        CropSeiData r7 = CropSeiData.parseCropSei(r10.optJSONObject("live_crop"));     // Catch: JSONException -> L66
        if (r7 != null) goto L47;
        exitVideoViewCrop(true, true);     // Catch: JSONException -> L66
        return;
    L47:
        if (this.h.supportCrop() == true) goto L52;
        exitVideoViewCrop(true, false);     // Catch: JSONException -> L66
        if (((Boolean) com.bytedance.android.live.core.setting.s3.a.getValue()).booleanValue() == true) goto L69;
        this.f = r7;     // Catch: JSONException -> L66
        return;
    L69:
        return;
    L52:
        float r4 = r7.cropY / r7.strideH;     // Catch: JSONException -> L66
        if (kd1.a.getValue().booleanValue() == true) goto L58;
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;     // Catch: JSONException -> L66
        if (Intrinsics.areEqual(String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r4)}, 1)), String.valueOf(this.b)) == false) goto L58;
        exitVideoViewCrop(true, true);     // Catch: JSONException -> L66
        return;
    L58:
        IRenderView r11 = this.j;     // Catch: JSONException -> L66
        if ((r11 instanceof SurfaceRenderView) == false) goto L62;
        a(r7, r10, r9);     // Catch: JSONException -> L66
        ALogger.e(this.a, "onVideoFrameMetaData, render view is surfaceRenderView");     // Catch: JSONException -> L66
        return;
    L62:
        if ((r11 instanceof TextureRenderView) == false) goto L64;
        a(r7, r10, r9);     // Catch: JSONException -> L66
        return;
    L64:
        ALogger.e(this.a, "onVideoFrameMetaData, illegal renderView:" + this.j);     // Catch: JSONException -> L66
        return;
    L66:
        exitVideoViewCrop(true, true);
        return;
    L36:
        if (kh0.a.getValue().booleanValue() == false) goto L68;
        return;
    L28:
        if (StringsKt.contains$default(r8, "\\\"ver\\\":2", false, 2, null) == true) goto L33;
        if (StringsKt.contains$default(r8, "\\\"ver\\\":6", false, 2, null) == true) goto L33;
        r3 = false;
        goto L34
    L20:
        if (StringsKt.contains$default(r8, "TTLiveSDK_IOS", false, 2, null) == true) goto L25;
        if (StringsKt.contains$default(r8, "TTLiveSDK_Windows", false, 2, null) == true) goto L25;
        r2 = false;
        goto L26
    L15:
        if (kh0.a.getValue().booleanValue() == false) goto L17;
        return;
    L7:
        if (this.i == false) goto L9;
        r1 = true;
        goto L10
    }
}
