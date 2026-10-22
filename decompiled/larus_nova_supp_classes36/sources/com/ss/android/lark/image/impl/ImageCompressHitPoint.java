package com.ss.android.lark.image.impl;

import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import q5c.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00062\u00020\u00012\u00020\u0002:\u0002\u0005\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/image/impl/ImageCompressHitPoint;", "Lcom/ss/android/lark/statistics/base/BaseHitPoint;", "Lcom/ss/android/lark/statistics/base/IHitPoint;", "<init>", "()V", "Param", "Companion", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImageCompressHitPoint extends a {
    public static final int $stable = 0;
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jt\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/image/impl/ImageCompressHitPoint$Companion;", "", "<init>", "()V", "TAG", "", "EVENT_NAME_COMPRESS", "sendImageCompress", "", "biz", "Lcom/ss/android/lark/appreciablelib/Biz;", "scene", "Lcom/ss/android/lark/appreciablelib/Scene;", "totalCost", "isSuccess", "", "imageType", "resourceContentLength", "", "resourceWidth", "resourceHeight", "uploadContentLength", "uploadWidth", "uploadHeight", "resourceFrames", "errorCode", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final void sendImageCompress(Biz r7, Scene r8, String r9, boolean r10, String r11, long r12, long r14, long r16, long r18, long r20, long r22, long r24, long r26) {
            Intrinsics.checkNotNullParameter(r9, "totalCost");
            Intrinsics.checkNotNullParameter(r11, "imageType");
            JSONObject r2 = new JSONObject();
            if (r7 == null) goto L5;
            r2.put("biz", r7.getValue());
        L5:
            if (r8 == null) goto L7;
            r2.put("scene", r8.getValue());
        L7:
            r2.put("total_cost", r9).put("is_success", r10).put("error_code", r26).put("image_type", r11).put("resource_content_length", r12).put("resource_width", r14).put("resource_height", r16).put("resource_frames", r24).put("upload_content_length", r18).put("upload_width", r20).put("upload_height", r22);
            Log.d("ImageCompressHitPoint", r2.toString());
            Statistics.sendEvent("image_compress_dev", r2);
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    @JvmStatic
    public static final void sendImageCompress(Biz r22, Scene r23, String r24, boolean r25, String r26, long r27, long r29, long r31, long r33, long r35, long r37, long r39, long r41) {
        Companion.sendImageCompress(r22, r23, r24, r25, r26, r27, r29, r31, r33, r35, r37, r39, r41);
    }
}
