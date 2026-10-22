package vt0;

import android.net.Uri;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r15, IBaseUser r16, long r17) {
        Intrinsics.checkNotNullParameter(r15, "origin");
        Intrinsics.checkNotNullParameter(r16, "anchor");
        Uri r2 = UriProtector.parse(r15);
        if (r2 == null) goto L11;
        String r5 = r2.getScheme();
        if (r5 == null) goto L11;
        if (r5.length() != 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 != true) goto L11;
    L19:
        return r15;
    L9:
        r6 = false;
    L11:
        if (r2 == null) goto L20;
        String r7 = r2.getHost();
        if (r7 == null) goto L20;
        if (r7.length() != 0) goto L17;
        boolean r8 = true;
    L18:
        if (r8 != true) goto L20;
    L17:
        r8 = false;
    L20:
        Uri.Builder r0 = r2.buildUpon().clearQuery();
        Iterator r9 = UriProtector.getQueryParameterNames(r2).iterator();
    L22:
        if (r9.hasNext() == false) goto L58;
        String r10 = (String) r9.next();
        String r12 = UriProtector.getQueryParameter(r2, r10);
        if (r12 == null) goto L22;
        if (r12.length() <= 0) goto L28;
        boolean r13 = true;
    L29:
        if (r13 != true) goto L22;
        if (Intrinsics.areEqual("url", r10) == false) goto L53;
        Uri r14 = UriProtector.parse(r12);
        String r18 = r16.getIdString();
        Intrinsics.checkNotNullParameter(r16, "$this$secUidExt");
        String r19 = r16.getCastSecUid();
        String r110 = "";
        if (r19 != null) goto L35;
        r19 = "";
    L35:
        String r111 = r16.getNickName();
        if (r111 != null) goto L38;
        r111 = "";
    L38:
        IMiddlewareUserService r112 = k.f(IMiddlewareUserService.class);
        if (r112 == null) goto L41;
        com.bytedance.android.livesdk.user.e r113 = r112.user();
    L42:
        if (r113 == null) goto L45;
        String r114 = r113.n();
        if (r114 == null) goto L45;
    L46:
        if (r113 == null) goto L51;
        String r115 = r113.a(r114);
        if (r115 == null) goto L51;
        r110 = r115;
    L51:
        r12 = r14.buildUpon().appendQueryParameter("room_id", String.valueOf(r17)).appendQueryParameter("anchor_id", r18.toString()).appendQueryParameter("user_id", r114).appendQueryParameter("sec_user_id", r110).appendQueryParameter("sec_anchor_id", r19).appendQueryParameter("anchor_name", r111).appendQueryParameter("dark_mode", DataType.TRUE).toString();
    L56:
        r0.appendQueryParameter(r10, r12);
    L45:
        r114 = DataType.FALSE;
        goto L46
    L41:
        r113 = null;
        goto L42
    L53:
        if (Intrinsics.areEqual("fallback_url", r10) == false) goto L56;
        r12 = a(r12, r16, r17);
        goto L56
    L28:
        r13 = false;
        goto L29
    L58:
        r0.appendQueryParameter("group_apply_enter_from", "live");
        r0.appendQueryParameter("group_apply_enter_method", "click_group_list");
        r0.appendQueryParameter("group_apply_room_id", String.valueOf(r17));
        return r0.toString();
    }
}
