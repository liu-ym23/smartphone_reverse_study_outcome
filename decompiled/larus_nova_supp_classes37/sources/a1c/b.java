package a1c;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.ttvideoengine.utils.TTVideoEngineLogListener;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements TTVideoEngineLogListener {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public final void consoleLog(String r4) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L7:
        if (r0 == false) goto L10;
        Log.i("LarkTTVideoEngineLogListener", "ENGINE_LOG_" + r4);
        return;
    L10:
        return;
    L5:
        if (new Regex(AppbrandHostConstants.SCHEMA_INSPECT.SESSION).containsMatchIn(r4) == true) goto L7;
        r0 = true;
        goto L7
    }
}
