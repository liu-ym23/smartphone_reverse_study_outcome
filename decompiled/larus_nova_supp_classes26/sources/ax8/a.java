package ax8;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.applog.api.IApplog;
import com.larus.bmhome.share.panel.ShareType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uniqueTag");
        return "Caijing-Pay-" + r2;
    }

    public static final String b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "originSchema");
        Uri r0 = UriProtector.parse(r6);
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r0, "mix_container_type"), "anniex") == true) goto L11;
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r0, "use_anniex"), "1") == true) goto L11;
        Intrinsics.checkNotNullParameter(r6, ShareType.URL);
        IApplog r2 = (IApplog) ServiceManager.get().getService(IApplog.class);
        if (r2 == null) goto L9;
        JSONObject r4 = new JSONObject();
        r4.put("scheme", r6);
        Unit r7 = Unit.INSTANCE;
        r2.reportEvent("cj_fe_scheme_error", r4);
    L9:
        r0 = r0.buildUpon().appendQueryParameter("mix_container_type", "anniex").build();
    L11:
        return r0.toString();
    }
}
