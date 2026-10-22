package nha;

import com.obric.assistant.trace.IObricTraceParam;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d implements cy7.b {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    public final void intercept(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        if (r3 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r2, "input_function_switch") == false) goto L11;
        IObricTraceParam r4 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r4 == null) goto L12;
        r4.k(r3);
        return;
    L12:
        return;
    }
}
