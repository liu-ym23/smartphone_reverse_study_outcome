package us1;

import android.text.TextUtils;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.plantform.model.b1;
import com.bytedance.android.livesdk.config.ff0;
import com.bytedance.android.livesdk.config.qb0;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e {
    public static boolean a;
    public static boolean b;
    public static boolean c;
    public static b1 d;
    public static String e;

    static {
        e = "";
    }

    public static boolean a(IRoom r4) {
        boolean r0 = b;
        if (r0 == false) goto L6;
        return false;
    L6:
        if (r0 == true) goto L17;
        if (r4 == null) goto L11;
        String r1 = r4.getAnchorAbValue("live_audience_linkmic_pre_apply_v2");
        if (r1 == null) goto L11;
    L13:
        if (TextUtils.equals("1", r1) == false) goto L15;
    L18:
        boolean r2 = true;
    L19:
        if (r2 == false) goto L21;
    L22:
        return true;
    L21:
        if (b(r4) == true) goto L22;
        return false;
    L15:
        if (qb0.a.getValue().booleanValue() == false) goto L17;
    L11:
        r1 = "";
    L17:
        r2 = false;
        goto L19
    }

    public static boolean b(IRoom r1) {
        if (b == false) goto L6;
        return false;
    L6:
        if (r1 == null) goto L9;
        String r2 = r1.getAnchorAbValue("live_audience_linkmic_pre_apply_v2");
        if (r2 == null) goto L9;
    L11:
        return TextUtils.equals("2", r2);
    L9:
        r2 = "";
        goto L11
    }

    public static boolean c(DataCenter r2, IRoom r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        if (r3 == null) goto L5;
        boolean r1 = r3.isPaidRoom();
    L6:
        if (r1 == true) goto L8;
    L10:
        if (r3 != null) goto L12;
    L22:
        if (r4 == false) goto L26;
        return ((Boolean) b6.d.getValue()).booleanValue();
    L26:
        return ((Boolean) r2.get("data_room_video_talk_integration_accept_audience_prepare_apply", Boolean.FALSE)).booleanValue();
    L12:
        if (r3.getLinkerDetail() == null) goto L22;
        z5 r5 = r3.getLinkerDetail();
        if (r5 == null) goto L16;
        Boolean r6 = Boolean.valueOf(r5.getAnchorAcceptAudiencePreApply());
    L17:
        if (r6 == null) goto L22;
        z5 r7 = r3.getLinkerDetail();
        if (r7 != null) goto L21;
        return false;
    L21:
        return r7.getAnchorAcceptAudiencePreApply();
    L16:
        r6 = null;
        goto L17
    L8:
        if (ff0.a.getValue().booleanValue() == true) goto L10;
        return false;
    L5:
        r1 = false;
        goto L6
    }
}
