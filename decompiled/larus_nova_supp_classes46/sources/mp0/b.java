package mp0;

import com.bytedance.android.live.network.annotation.PbRequest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final String a(long r3) {
        if (r3 != 2) goto L6;
        return "recently";
    L6:
        if (r3 != 3) goto L9;
        return "recommend";
    L9:
        if (r3 != (-1)) goto L11;
        return "search";
    L11:
        return PbRequest.SwitchType.OTHER;
    }
}
