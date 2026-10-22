package bz9;

import android.util.Size;
import com.larus.im.bean.message.Cover;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.ImagePlaceHolder;
import com.larus.im.bean.message.VideoData;
import com.larus.im.bean.message.VideoPlaceHolder;
import com.larus.platform.api.f3$a;
import com.larus.platform.service.e2;
import com.larus.uaigc.chat.markdown.image.MDImageScrollWidget;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int c() {
        if (((Boolean) MDImageScrollWidget.y.getValue()).booleanValue() == false) goto L8;
        e2 r0 = e2.a;
        if (r0.g() == r0.f()) goto L8;
        return (int) (f3$a.a() / 3.3f);
    L8:
        return i5.a0();
    }

    public static Size b(CreationItem r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Integer r0 = r4.type;
        int r1 = 0;
        if (r0 != null) goto L6;
    L35:
        if (r0 == null) goto L76;
        if (r0.intValue() != 2) goto L76;
        VideoData r2 = r4.video;
        if (r2 == null) goto L46;
        Cover r3 = r2.cover;
        if (r3 == null) goto L46;
        ImageObj r7 = r3.imagePreview;
        if (r7 == null) goto L46;
        int r8 = r7.width;
    L47:
        if (r2 == null) goto L53;
        Cover r9 = r2.cover;
        if (r9 == null) goto L53;
        ImageObj r10 = r9.imagePreview;
        if (r10 == null) goto L53;
        int r11 = r10.height;
    L54:
        if (r8 <= 0) goto L59;
        if (r11 <= 0) goto L59;
        int r12 = r8;
    L58:
        int r13 = r12;
        r1 = r11;
    L74:
        return a(r5, r6, r13, r1, r4.type);
    L59:
        if (r2 == null) goto L65;
        VideoPlaceHolder r14 = r2.placeholder;
        if (r14 == null) goto L65;
        Long r15 = r14.width;
        if (r15 == null) goto L65;
        r13 = (int) r15.longValue();
    L66:
        VideoData r16 = r4.video;
        if (r16 == null) goto L74;
        VideoPlaceHolder r17 = r16.placeholder;
        if (r17 == null) goto L74;
        Long r18 = r17.height;
        if (r18 == null) goto L74;
        r1 = (int) r18.longValue();
    L65:
        r13 = 0;
    L53:
        r11 = 0;
    L46:
        r8 = 0;
    L76:
        return new Size(0, 0);
    L6:
        if (r0.intValue() != 1) goto L35;
        ImageData r19 = r4.image;
        if (r19 == null) goto L14;
        ImagePlaceHolder r20 = r19.placeholder;
        if (r20 == null) goto L14;
        Long r21 = r20.width;
        if (r21 == null) goto L14;
        r12 = (int) r21.longValue();
    L15:
        ImageData r22 = r4.image;
        if (r22 == null) goto L22;
        ImagePlaceHolder r23 = r22.placeholder;
        if (r23 == null) goto L22;
        Long r24 = r23.height;
        if (r24 == null) goto L22;
        r11 = (int) r24.longValue();
    L23:
        if (r12 <= 0) goto L25;
        if (r11 > 0) goto L58;
    L25:
        ImageData r25 = r4.image;
        if (r25 == null) goto L30;
        ImageObj r26 = r25.imageOrigin;
        if (r26 == null) goto L30;
        r13 = r26.width;
    L31:
        if (r25 == null) goto L74;
        ImageObj r27 = r25.imageOrigin;
        if (r27 == null) goto L74;
        r1 = r27.height;
    L30:
        r13 = 0;
    L22:
        r11 = 0;
    L14:
        r12 = 0;
        goto L15
    }

    public static Size a(int r2, int r3, int r4, int r5, Integer r6) {
        if (r4 <= 0) goto L29;
        if (r5 <= 0) goto L29;
        float r7 = r5 / r4;
        if (r7 <= 1.7777778f) goto L7;
        r7 = 1.7777778f;
    L7:
        if (r6 != null) goto L10;
    L12:
        float r8 = 0.5625f;
    L14:
        if (r7 >= r8) goto L17;
        r7 = r8;
    L17:
        if (r3 <= 1) goto L19;
        int r9 = RangesKt.coerceAtMost((int) (((double) r2) * 0.8d), c());
    L20:
        int r10 = RangesKt.coerceAtMost(r2, c());
        if (r7 <= 1.0f) goto L25;
        int r11 = (int) (r10 / r7);
        if (r11 >= r9) goto L25;
        r9 = r11;
    L27:
        return new Size(r9, r10);
    L25:
        r10 = (int) (r9 * r7);
        goto L27
    L19:
        r9 = RangesKt.coerceAtMost(r2, c());
        goto L20
    L10:
        if (r6.intValue() != 2) goto L12;
        r8 = 0.42857143f;
    L29:
        return new Size(0, 0);
    }
}
