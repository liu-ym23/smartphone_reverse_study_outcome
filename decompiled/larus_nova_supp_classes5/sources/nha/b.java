package nha;

import com.obric.assistant.trace.IObricTraceParam;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b implements cy7.b {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public final void intercept(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, DBDefinition.NAME);
        if (r3 != null) goto L6;
        return;
    L6:
        switch(r2.hashCode()) {
            case -1704990083: goto L21;
            case -777411915: goto L18;
            case -777013775: goto L15;
            case 231485884: goto L12;
            case 2079889074: goto L9;
            default: goto L29;
        };
    L29:
        return;
    L9:
        if (r2.equals("click_upload_file_entrance") == false) goto L30;
    L23:
        IObricTraceParam r4 = (IObricTraceParam) ServiceManager.get().getService(IObricTraceParam.class);
        if (r4 == null) goto L28;
        r4.i(r3);
        return;
    L28:
        return;
    L30:
        return;
    L12:
        if (r2.equals("click_camera") == true) goto L23;
        return;
    L15:
        if (r2.equals("click_plus") == true) goto L23;
        return;
    L18:
        if (r2.equals("click_call") == true) goto L23;
        return;
    L21:
        if (r2.equals("click_upload_entrance") == true) goto L23;
    }
}
