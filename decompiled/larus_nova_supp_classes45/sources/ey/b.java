package ey;

import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerLeaveContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static final int a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$toLeaveSource");
        switch(r1.hashCode()) {
            case -1440118544: goto L38;
            case -1250551599: goto L34;
            case -1250551592: goto L31;
            case -1221226623: goto L28;
            case -413114405: goto L24;
            case -265223428: goto L21;
            case 406337293: goto L18;
            case 842434370: goto L15;
            case 850524161: goto L12;
            case 896262826: goto L9;
            case 1668666719: goto L6;
            default: goto L42;
        };
    L6:
        if (r1.equals("ceiling_view_leave") == false) goto L42;
        return 3;
    L9:
        if (r1.equals("rtc_error") == false) goto L42;
        return 4;
    L12:
        if (r1.equals("unusual_leave") == false) goto L42;
        return 5;
    L15:
        if (r1.equals("unusual_close") == false) goto L42;
        return 5;
    L18:
        if (r1.equals("rtc_start_error") == false) goto L42;
        return 4;
    L21:
        if (r1.equals("random_link_finish") == false) goto L42;
        return 4;
    L24:
        if (r1.equals("close_icon_disconnect") == false) goto L42;
        return 3;
    L28:
        if (r1.equals("leave_for_random") == false) goto L42;
        return 4;
    L31:
        if (r1.equals("receive_link_message_9") == false) goto L42;
        return 4;
    L34:
        if (r1.equals("receive_link_message_2") == false) goto L42;
        return 5;
    L38:
        if (r1.equals("leave_for_apply") == false) goto L42;
        return 4;
    L42:
        return LinkerLeaveContent.LeaveSource.AnchorLeaveSourceUnknown.ordinal();
    }
}
