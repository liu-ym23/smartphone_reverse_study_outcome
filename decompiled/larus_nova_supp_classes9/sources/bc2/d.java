package bc2;

import com.bytedance.android.livesdkapi.ws.LiveWsMessage;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tlc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final f b(LiveWsMessage r13) {
        if (r13 != null) goto L5;
        return null;
    L5:
        ArrayList r6 = new ArrayList();
        if (r13.getMsgHeaders() == null) goto L12;
        Iterator r0 = r13.getMsgHeaders().iterator();
    L9:
        if (r0.hasNext() == false) goto L12;
        LiveWsMessage.MsgHeader r1 = (LiveWsMessage.MsgHeader) r0.next();
        r6.add(new com.ss.ugc.live.sdk.msg.network.d(r1.getKey(), r1.getValue()));
    L12:
        return new f(r13.getService(), r13.getMethod(), r13.getPayloadType(), r13.getPayloadEncoding(), r13.getPayload(), r6, r13.getLogId(), r13.getSeqId());
    }

    public static tlc.d a(vlc.d r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$getLatestWRDSMessage");
        Intrinsics.checkNotNullParameter(r3, "messageMethod");
        if ((r2 instanceof xlc.a) == true) goto L5;
        r2 = null;
    L5:
        xlc.a r4 = (xlc.a) r2;
        if (r4 == null) goto L8;
        tlc.d r5 = r4.e(r3, null);
    L10:
        if ((r5 instanceof tlc.d) == true) goto L13;
        return null;
    L13:
        return r5;
    L8:
        r5 = null;
        goto L10
    }
}
