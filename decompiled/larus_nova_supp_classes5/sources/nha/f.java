package nha;

import com.obric.assistant.trace.IObricTraceParam;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f implements cy7.b {

    public static final class a {
    }

    static {
    }

    public f() {
    }

    public final void intercept(String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r4, DBDefinition.NAME);
        if (r5 != null) goto L5;
        return;
    L5:
        int r0 = r4.hashCode();
        if (r0 == (-624136624)) goto L19;
        if (r0 == 1268229313) goto L16;
        if (r0 == 1633612112) goto L13;
        return;
    L13:
        if (r4.equals("send_message_response") == false) goto L25;
    L21:
        IObricTraceParam r1 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r1 == null) goto L26;
        int r2 = com.obric.assistant.reporter.utils.g.a;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.optString("action_bar_key", "");
        r1.c(r5, r4);
        return;
    L26:
        return;
    L25:
        return;
    L16:
        if (r4.equals("send_message_status") == true) goto L21;
        return;
    L19:
        if (r4.equals("send_message") == true) goto L21;
    }
}
