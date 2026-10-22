package com.bytedance.android.live.schema.helper;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.android.live.schema.convert.HybridType;
import com.bytedance.android.live.schema.convert.HybridUiType;
import com.bytedance.android.live.schema.convert.PopupGraType;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.live.schema.vo.LynxHybridParamVo;
import com.bytedance.android.live.schema.vo.PopupHybridParamVo;
import com.bytedance.android.live.schema.vo.WebHybridParamVo;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final PopupHybridParamVo b(String r2, Uri r3, Bundle r4) {
        Parcelable r1 = null;
        Parcelable r5 = ka1.b.a(new ia1.b(r2, r3, r4, null), new ia1.a(HybridType.COMMON, HybridUiType.POPUP), false);
        if ((r5 instanceof PopupHybridParamVo) == false) goto L7;
        r1 = r5;
    L7:
        return (PopupHybridParamVo) r1;
    }

    @JvmStatic
    public static final PopupHybridParamVo d(String r3, Uri r4, Bundle r5) {
        Parcelable r1 = null;
        Parcelable r6 = ka1.b.a(new ia1.b(r3, r4, r5, null), new ia1.a(HybridType.Lynx, HybridUiType.POPUP, PopupGraType.OTHER), false);
        if ((r6 instanceof PopupHybridParamVo) == false) goto L7;
        r1 = r6;
    L7:
        return (PopupHybridParamVo) r1;
    }

    @JvmStatic
    public static final PopupHybridParamVo e(String r3, Uri r4, Bundle r5) {
        Parcelable r1 = null;
        Parcelable r6 = ka1.b.a(new ia1.b(r3, r4, r5, null), new ia1.a(HybridType.H5, HybridUiType.POPUP, PopupGraType.BOTTOM), false);
        if ((r6 instanceof PopupHybridParamVo) == false) goto L7;
        r1 = r6;
    L7:
        return (PopupHybridParamVo) r1;
    }

    @JvmStatic
    public static final WebHybridParamVo f(String r3, Uri r4, Bundle r5) {
        Parcelable r1 = null;
        Parcelable r6 = ka1.b.a(new ia1.b(r3, r4, r5, null), new ia1.a(HybridType.H5, HybridUiType.FULLSCREEN, PopupGraType.OTHER), false);
        if ((r6 instanceof WebHybridParamVo) == false) goto L7;
        r1 = r6;
    L7:
        return (WebHybridParamVo) r1;
    }

    @JvmStatic
    public static final BaseHybridParamVo a(String r1, Uri r2, Bundle r3, ja1.a r4) {
        Parcelable r5 = ka1.b.a(new ia1.b(r1, r2, r3, r4), new ia1.a(HybridType.COMMON, HybridUiType.FULLSCREEN), false);
        if ((r5 instanceof BaseHybridParamVo) == true) goto L6;
        r5 = null;
    L6:
        return (BaseHybridParamVo) r5;
    }

    @JvmStatic
    public static final LynxHybridParamVo c(String r1, Uri r2, Bundle r3, ja1.a r4, boolean r5) {
        Parcelable r6 = ka1.b.a(new ia1.b(r1, r2, r3, r4), new ia1.a(HybridType.Lynx, HybridUiType.FULLSCREEN, PopupGraType.OTHER), r5);
        if ((r6 instanceof LynxHybridParamVo) == true) goto L6;
        r6 = null;
    L6:
        return (LynxHybridParamVo) r6;
    }
}
