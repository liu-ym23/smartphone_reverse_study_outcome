package m02;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.resources.j;
import com.bytedance.android.live.core.resources.k;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public static final i02.g b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "filePath");
        String r4 = b.b(b.a(r3));
        if (r4 != null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == true) goto L18;
        return (i02.g) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r4, i02.g.class);
    L13:
        e = move-exception;
        jy0.b.c("VideoGiftView", null, e, 2);
        return null;
    L18:
        return null;
    L5:
        if (r4.length() == 0) goto L8;
        r0 = false;
        goto L10
    }

    public static final int c(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return 0;
    L11:
        i02.g r4 = b(r3);
        i02.g.b r2 = null;
        if (PadConfigUtils.c() == false) goto L18;
        if (r4 == null) goto L15;
        i02.g.b r5 = r4.portrait;
    L16:
        if (r5 == null) goto L18;
        return r4.portrait.videoHeight;
    L15:
        r5 = null;
    L18:
        if (r4 == null) goto L20;
        i02.g.b r6 = r4.landscape;
    L21:
        if (r6 != null) goto L23;
    L25:
        if (r4 == null) goto L27;
        r2 = r4.portrait;
    L27:
        if (r2 != null) goto L29;
        return 0;
    L29:
        if (e5.n() == false) goto L31;
        return 0;
    L31:
        return r4.portrait.videoHeight;
    L23:
        if (e5.n() == false) goto L25;
        return r4.landscape.videoHeight;
    L20:
        r6 = null;
        goto L21
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static final int d(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return 0;
    L11:
        i02.g r4 = b(r3);
        i02.g.b r2 = null;
        if (PadConfigUtils.c() == false) goto L18;
        if (r4 == null) goto L15;
        i02.g.b r5 = r4.portrait;
    L16:
        if (r5 == null) goto L18;
        return r4.portrait.videoWidth;
    L15:
        r5 = null;
    L18:
        if (r4 == null) goto L20;
        i02.g.b r6 = r4.landscape;
    L21:
        if (r6 != null) goto L23;
    L25:
        if (r4 == null) goto L27;
        r2 = r4.portrait;
    L27:
        if (r2 != null) goto L29;
        return 0;
    L29:
        if (e5.n() == false) goto L31;
        return 0;
    L31:
        return r4.portrait.videoWidth;
    L23:
        if (e5.n() == false) goto L25;
        return r4.landscape.videoWidth;
    L20:
        r6 = null;
        goto L21
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static final int a(Long r7, String r8) {
        if (r7 == null) goto L53;
        boolean r1 = true;
        if (r8 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L53;
        com.bytedance.android.live.core.resources.e r9 = ((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).G1(r7.longValue());
        if (r9 != null) goto L16;
        return -1;
    L16:
        String r4 = r9.getMD5();
        if (r4 != null) goto L19;
    L22:
        boolean r5 = true;
    L24:
        if (r5 == true) goto L28;
        String r6 = r9.getMD5();
        Intrinsics.checkNotNull(r6);
        if (StringsKt.contains$default(r8, r6, false, 2, null) == false) goto L28;
        return 0;
    L28:
        j r10 = r9.getH265ResourceModel();
        if (r10 == null) goto L41;
        String r11 = r10.getMd5();
        if (r11 != null) goto L33;
    L36:
        boolean r13 = true;
    L37:
        if (r13 == true) goto L41;
        if (StringsKt.contains$default(r8, r10.getMd5(), false, 2, null) == false) goto L41;
        return 1;
    L33:
        if (r11.length() == 0) goto L36;
        r13 = false;
    L41:
        k r14 = r9.getH265SuperResourceModel();
        if (r14 == null) goto L53;
        String r15 = r14.getMd5();
        if (r15 != null) goto L46;
    L49:
        if (r1 == true) goto L53;
        if (StringsKt.contains$default(r8, r14.getMd5(), false, 2, null) == false) goto L53;
        return 2;
    L46:
        if (r15.length() == 0) goto L49;
        r1 = false;
        goto L49
    L19:
        if (r4.length() == 0) goto L22;
        r5 = false;
        goto L24
    L7:
        if (r8.length() == 0) goto L10;
        r3 = false;
    L53:
        return -1;
    }
}
