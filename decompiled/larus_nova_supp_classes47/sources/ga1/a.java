package ga1;

import android.net.Uri;
import android.os.Parcelable;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public a() {
    }

    public final Parcelable a(ia1.b r35, boolean r36) {
        ja1.a r1 = r35.d;
        if (r1 != null) goto L5;
        r1 = new ja1.a(r35.b, r35.a, r35.c);
    L5:
        String r2 = r35.a;
        if (r2 != null) goto L8;
        r2 = (String) r1.a("url", "");
    L8:
        String r29 = r2;
        String r18 = (String) r1.a("status_bar_color", "");
        String r28 = (String) r1.a("inject_json_url", "");
        String r19 = (String) r1.a("status_bar_bg_color", "");
        boolean r4 = false;
        int r26 = ((Number) r1.a("request_code", 0)).intValue();
        String r3 = (String) r1.a("enter_from", "");
        String r5 = (String) r1.a("is_out_url", "");
        String r22 = (String) r1.a("is_out_scene", "");
        int r23 = ((Number) r1.a("bundle_web_view_background_color", -1)).intValue();
        String r24 = (String) r1.a("web_bg_color", "");
        String r9 = (String) r1.a("pull_down_indicator_color", "");
        int r7 = ((Number) r1.a("pull_down_height", 0)).intValue();
        boolean r16 = ((Boolean) r1.a("is_fullScreen", Boolean.FALSE)).booleanValue();
        String r25 = (String) r1.a("title", "");
        if (((Number) r1.a("pull_down_indicator_not_show", 0)).intValue() != 1) goto L11;
        boolean r10 = true;
    L13:
        if (((Number) r1.a("hide_loading", 1)).intValue() != 1) goto L15;
        boolean r27 = true;
    L17:
        if (((Number) r1.a("show_close", 0)).intValue() != 1) goto L19;
        boolean r12 = true;
    L21:
        if (((Number) r1.a("hide_system_video_poster", 0)).intValue() != 1) goto L23;
        boolean r13 = true;
    L25:
        if (((Number) r1.a("hide_status_bar", 0)).intValue() != 1) goto L27;
        boolean r6 = true;
    L29:
        if (((Number) r1.a("hide_nav_bar", 0)).intValue() != 1) goto L31;
        boolean r15 = true;
    L33:
        if (((Number) r1.a("enable_share", 0)).intValue() != 1) goto L35;
        boolean r14 = true;
    L37:
        if (((Number) r1.a("show_back", 0)).intValue() != 1) goto L39;
        boolean r17 = true;
    L41:
        if (((Number) r1.a("trans_status_bar", 0)).intValue() != 1) goto L43;
        boolean r210 = true;
    L45:
        if (((Number) r1.a("pull_down_close", 0)).intValue() != 1) goto L47;
        boolean r8 = true;
    L49:
        if (((Number) r1.a("forbid_right_back", 0)).intValue() != 1) goto L51;
        boolean r20 = true;
    L52:
        boolean r30 = r15;
        if (((Number) r1.a("support_exchange_theme", 0)).intValue() != 1) goto L55;
        boolean r32 = true;
    L56:
        Uri r0 = r35.b;
        if (r0 == null) goto L60;
        String r33 = r0.toString();
        if (r33 == null) goto L60;
    L62:
        if (Intrinsics.areEqual("is_from_out_scene", r5) == false) goto L64;
    L65:
        r4 = true;
    L66:
        boolean r34 = r6;
        boolean r37 = r8;
        boolean r38 = r10;
        boolean r110 = r13;
        boolean r111 = r17;
        boolean r112 = r20;
        boolean r113 = r210;
        return new BaseHybridParamVo(r34, r37, r7, r38, r9, r110, r12, r111, r14, r112, r30, r16, r113, r18, r19, Boolean.valueOf(r4), r22, r25, r23, r24, r27, r26, r32, r28, r29, r33, 483342, 0);
    L64:
        if (Intrinsics.areEqual("deeplink", r3) == false) goto L66;
    L60:
        r33 = "";
        goto L62
    L55:
        r32 = false;
        goto L56
    L51:
        r20 = false;
        goto L52
    L47:
        r8 = false;
        goto L49
    L43:
        r210 = false;
        goto L45
    L39:
        r17 = false;
        goto L41
    L35:
        r14 = false;
        goto L37
    L31:
        r15 = false;
        goto L33
    L27:
        r6 = false;
        goto L29
    L23:
        r13 = false;
        goto L25
    L19:
        r12 = false;
        goto L21
    L15:
        r27 = false;
        goto L17
    L11:
        r10 = false;
        goto L13
    }
}
