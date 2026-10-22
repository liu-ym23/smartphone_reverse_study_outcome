package eg;

import com.bytedance.android.ec.common.impl.sku.repository.api.SkuApi;
import com.bytedance.android.ec.common.impl.sku.repository.dto.AddCartResponse;
import com.bytedance.android.ec.common.impl.sku.repository.dto.SkuInfoResponseDTO;
import com.bytedance.android.ec.core.utils.g0;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import io.reactivex.Observable;
import jg.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: eg.a$a, reason: collision with other inner class name */
    public static final class C0155a {
    }

    static {
    }

    public a() {
    }

    public static Observable b(String r11, String r12, String r13, String r14, String r15, int r16, String r17, String r18, String r19) {
        Intrinsics.checkNotNullParameter(r11, "productId");
        Intrinsics.checkNotNullParameter(r12, "comboId");
        Intrinsics.checkNotNullParameter(r13, "comboNum");
        Intrinsics.checkNotNullParameter(r14, "extra");
        Intrinsics.checkNotNullParameter(r15, "channelId");
        SkuApi.a.getClass();
        SkuApi r1 = SkuApi.a.a;
        if (r1 == null) goto L7;
        Observable<String> r0 = r1.addShopCartNewString(r11, r12, r13, r14, r15, r16, r17, r18, r19);
        if (r0 == null) goto L7;
        return r0;
    L7:
        return Observable.error(new Exception("SkuApi.INSTANCE is null"));
    }

    public static Observable a(String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, int r31, String r32, String r33, String r34) {
        Intrinsics.checkNotNullParameter(r19, "campaignId");
        Intrinsics.checkNotNullParameter(r20, "productId");
        Intrinsics.checkNotNullParameter(r21, "originType");
        Intrinsics.checkNotNullParameter(r22, "originId");
        Intrinsics.checkNotNullParameter(r23, "comboId");
        Intrinsics.checkNotNullParameter(r24, "comboNum");
        Intrinsics.checkNotNullParameter(r25, "specDesc");
        Intrinsics.checkNotNullParameter(r26, "deviceId");
        Intrinsics.checkNotNullParameter(r27, "extra");
        Intrinsics.checkNotNullParameter(r28, "authorId");
        Intrinsics.checkNotNullParameter(r29, "secAuthorId");
        Intrinsics.checkNotNullParameter(r30, "channelId");
        SkuApi.a.getClass();
        SkuApi r1 = SkuApi.a.a;
        if (r1 == null) goto L7;
        Observable<AddCartResponse> r0 = r1.addShopCart(com.bytedance.android.ec.core.event.a.VALUE_NATIVE, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34);
        if (r0 == null) goto L7;
        return r0;
    L7:
        return Observable.error(new Exception("SkuApi.INSTANCE is null"));
    }

    public static /* synthetic */ Observable d(String r34, String r35, String r36, String r37, String r38, String r39, long r40, int r42, int r43, Integer r44, String r45, String r46, String r47, String r48, String r49, String r50, String r51, String r52, String r53, Integer r54, String r55, Integer r56, String r57, int r58) {
        if ((r58 & 2048) == 0) goto L5;
        String r15 = null;
    L7:
        if ((r58 & 8192) == 0) goto L9;
        String r17 = null;
    L11:
        if ((r58 & 16384) == 0) goto L13;
        String r18 = null;
    L15:
        if ((65536 & r58) == 0) goto L17;
        String r20 = null;
    L19:
        if ((131072 & r58) == 0) goto L21;
        String r21 = null;
    L23:
        if ((262144 & r58) == 0) goto L25;
        String r22 = null;
    L27:
        if ((1048576 & r58) == 0) goto L29;
        String r24 = null;
    L31:
        if ((2097152 & r58) == 0) goto L33;
        Integer r25 = 0;
    L35:
        if ((4194304 & r58) == 0) goto L37;
        Integer r26 = 0;
    L39:
        if ((8388608 & r58) == 0) goto L41;
        Integer r27 = 0;
    L43:
        if ((16777216 & r58) == 0) goto L45;
        Integer r28 = 2;
    L47:
        if ((33554432 & r58) == 0) goto L49;
        Long r29 = 0L;
    L51:
        if ((134217728 & r58) == 0) goto L53;
        String r31 = null;
    L55:
        if ((268435456 & r58) == 0) goto L57;
        Integer r32 = 0;
    L59:
        if ((r58 & 536870912) == 0) goto L61;
        String r33 = null;
    L63:
        return c(r34, r35, r36, r37, r38, r39, r40, r42, r43, r44, r45, r15, r47, r17, r18, null, r20, r21, r22, null, r24, r25, r26, r27, r28, r29, null, r31, r32, r33);
    L61:
        r33 = r57;
        goto L63
    L57:
        r32 = r56;
        goto L59
    L53:
        r31 = r55;
        goto L55
    L49:
        r29 = null;
        goto L51
    L45:
        r28 = null;
        goto L47
    L41:
        r27 = null;
        goto L43
    L37:
        r26 = null;
        goto L39
    L33:
        r25 = r54;
        goto L35
    L29:
        r24 = r53;
        goto L31
    L25:
        r22 = r52;
        goto L27
    L21:
        r21 = r51;
        goto L23
    L17:
        r20 = r50;
        goto L19
    L13:
        r18 = r49;
        goto L15
    L9:
        r17 = r48;
        goto L11
    L5:
        r15 = r46;
        goto L7
    }

    public static Observable c(String r34, String r35, String r36, String r37, String r38, String r39, long r40, int r42, int r43, Integer r44, String r45, String r46, String r47, String r48, String r49, String r50, String r51, String r52, String r53, String r54, String r55, Integer r56, Integer r57, Integer r58, Integer r59, Long r60, String r61, String r62, Integer r63, String r64) {
        Intrinsics.checkNotNullParameter(r34, "promotionId");
        SkuApi.a.getClass();
        SkuApi r1 = SkuApi.a.a;
        if (r1 == null) goto L11;
        if (g.a(r37) == false) goto L7;
        String r10 = r37;
    L8:
        int r0 = g0.a;
        Observable<SkuInfoResponseDTO> r11 = r1.getSkuInfo(r34, r35, r36, r10, r38, r39, r51, r40, r42, r43, r44, r45, r46, Integer.valueOf(g0.a(ECAppInfoService.e.getApplicationContext()) ? 1 : 0), r47, r48, r49, r50, r53, r52, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64);
        if (r11 == null) goto L11;
        return r11;
    L7:
        r10 = r36;
    L11:
        return Observable.error(new Exception("SkuApi.INSTANCE is null"));
    }
}
