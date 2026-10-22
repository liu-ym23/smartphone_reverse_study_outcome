package nha;

import com.obric.assistant.trace.IObricTraceParam;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a implements cy7.b {

    /* JADX INFO: renamed from: nha.a$a, reason: collision with other inner class name */
    public static final class C0026a {
    }

    static {
    }

    public a() {
    }

    public final void intercept(String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, DBDefinition.NAME);
        if (r4 != null) goto L5;
        return;
    L5:
        int r0 = r3.hashCode();
        if (r0 == (-1739677286)) goto L25;
        if (r0 == (-1579666261)) goto L19;
        if (r0 == 1374191827) goto L13;
        return;
    L13:
        if (r3.equals("action_bar_option_click") == false) goto L37;
        IObricTraceParam r5 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r5 == null) goto L31;
        r5.e(r4);
        return;
    L31:
        return;
    L37:
        return;
    L19:
        if (r3.equals("chat_action_bar_show") == false) goto L38;
        IObricTraceParam r6 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r6 == null) goto L33;
        r6.o(r4);
        return;
    L33:
        return;
    L38:
        return;
    L25:
        if (r3.equals("chat_action_bar_click") == false) goto L39;
        IObricTraceParam r7 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r7 == null) goto L35;
        r7.l(r4);
        r7.o(r4);
        return;
    L35:
        return;
    }
}
