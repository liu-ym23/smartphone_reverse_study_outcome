package com.ss.android.lark.framework.assembly.imageqrcode;

import android.app.Activity;
import android.graphics.Bitmap;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.biz.core.api.VEBaseScanResult;
import com.ss.android.lark.biz.core.api.VEScanStrategy;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.imageqrcode.QRCodeResultInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.qrcode.ui.h;
import com.ss.android.lark.videosend.tools.VideoTools;
import com.ss.android.lark.videosend.tools.f;
import dxa.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mlb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(mlb.a.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0016¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/framework/assembly/imageqrcode/ImageQRCodeDependency;", "Lcom/ss/android/lark/imageqrcode/IImageQRCodeDependency;", "<init>", "()V", "decodeQRCode", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/imageqrcode/QRCodeResultInfo;", "Lkotlin/collections/ArrayList;", "bitmap", "Landroid/graphics/Bitmap;", "Lcom/ss/android/lark/biz/core/api/VEScanResult;", "imagePath", "", "openResultPage", "", "activity", "Landroid/app/Activity;", "result", "Companion", "imageqrcode-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImageQRCodeDependency implements mlb.a {
    public static final a Companion = null;
    private static final String TAG = "ImageQRCodeDependency";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ImageQRCodeDependency() {
    }

    @Override // mlb.a
    public ArrayList<QRCodeResultInfo> decodeQRCode(Bitmap r11) {
        Intrinsics.checkNotNullParameter(r11, "bitmap");
        ArrayList<QRCodeResultInfo> r0 = new ArrayList();
        a2c.a r1 = z1c.a.a;
        h r2 = h.c.a;
        if (r2.g.booleanValue() == false) goto L5;
        ArrayList r12 = h.g(r2.d(new h.b(r11), r11, VEScanStrategy.HW_SCAN), r11);
    L6:
        List r13 = CollectionsKt.filterNotNull(r12);
        if (r13 == null) goto L12;
        Iterator r14 = r13.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        VEBaseScanResult r3 = (VEBaseScanResult) r14.next();
        r0.add(new QRCodeResultInfo(r3.getContent(), r3.getLeft(), r3.getTop(), r3.getRight(), r3.getBottom(), r3.getBaseCodeType().getValue()));
    L12:
        return r0;
    L5:
        r12 = h.g(r2.d(new h.b(r11), r11, VEScanStrategy.DEFAULT), r11);
        goto L6
    }

    @Override // mlb.a
    public g decodeQRCode(String r3) {
        Intrinsics.checkNotNullParameter(r3, "imagePath");
        a2c.a r1 = z1c.a.a;
        Intrinsics.checkNotNullParameter(r3, "imagePath");
        VideoTools.checkToInitSDK();
        h r0 = h.c.a;
        r0.getClass();
        if (f.e == false) goto L6;
        return h.e(r0.i(r3));
    L6:
        return h.c(new h.d(r3));
    }

    @Override // mlb.a
    public void openResultPage(Activity r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "result");
        if (r4.isFinishing() == false) goto L5;
    L8:
        Log.e(TAG, "openResultPage, activity is invalid");
        return;
    L5:
        if (r4.isDestroyed() == true) goto L8;
        Log.i(TAG, "openResultPage, result:".concat(b.d(r5)));
        a2c.a r0 = z1c.a.a;
        z1c.a.a.a(r5, r4);
    }
}
