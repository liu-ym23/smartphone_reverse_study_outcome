package ga1;

import android.os.Parcelable;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.live.schema.vo.LynxHybridParamVo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public e() {
    }

    public final Parcelable a(ia1.b r12, boolean r13) {
        ja1.a r0 = r12.d;
        if (r0 != null) goto L5;
        r0 = new ja1.a(r12.b, r12.a, r12.c);
    L5:
        if (r13 == false) goto L8;
        BaseHybridParamVo r14 = null;
    L7:
        BaseHybridParamVo r7 = r14;
        BaseHybridParamVo.HybridType r15 = BaseHybridParamVo.HybridType.LYNX;
        if (r7 == null) goto L12;
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r7.a = r15;
    L12:
        String r16 = (String) r0.a("fallback_url", "");
        boolean r2 = false;
        if (((Number) r0.a("abandon_coordinate", 0)).intValue() != 1) goto L15;
        boolean r5 = true;
    L17:
        if (((Number) r0.a("is_slide_center", 0)).intValue() != 1) goto L19;
        boolean r6 = true;
    L20:
        String r17 = (String) r0.a("bundle_fallback_url", "");
        int r4 = ((Number) r0.a("lynx_thread", 0)).intValue();
        if (((Number) r0.a("enable_lynx_bg", 0)).intValue() != 1) goto L23;
        boolean r1 = true;
    L25:
        if (r16.length() != 0) goto L27;
        r2 = true;
    L27:
        if (r2 == false) goto L29;
        String r3 = r17;
    L31:
        return new LynxHybridParamVo(r3, r4, r1, r5, r6, r7, 8);
    L29:
        r3 = r16;
        goto L31
    L23:
        r1 = false;
        goto L25
    L19:
        r6 = false;
        goto L20
    L15:
        r5 = false;
        goto L17
    L8:
        r14 = com.bytedance.android.live.schema.helper.a.a(r12.a, r12.b, r12.c, r0);
        goto L7
    }
}
