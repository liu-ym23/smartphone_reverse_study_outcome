package ar8;

import android.os.Bundle;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.search.api.model.SchemaSuffixMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public c() {
    }

    public static Bundle a(String r3, SchemaSuffixMap r4) {
        Intrinsics.checkNotNullParameter(r3, "jumpUrl");
        Bundle r0 = new Bundle();
        r0.putString("link_url", r3);
        r0.putString("hide_title_bar", "1");
        r0.putString("is_not_full_page", "1");
        r0.putString("is_show_progress_bar", TriggerSendLoading.NO_LOADING);
        Map r5 = r4.getMap();
        if (r5 == null) goto L7;
        boolean r2 = true;
        if ((!r5.isEmpty()) != true) goto L7;
    L8:
        if (r2 == false) goto L10;
        r0.putString("need_schema_premix", "1");
        r0.putSerializable("schema_suffix_map", r4);
    L10:
        r0.putString("is_show_center_progress_bar", "1");
        return r0;
    L7:
        r2 = false;
        goto L8
    }
}
