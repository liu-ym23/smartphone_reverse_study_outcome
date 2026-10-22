package r18;

import android.text.TextUtils;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static String b(Object r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        String r0 = r1.getClass().getCanonicalName();
        if (r0 == null) goto L8;
        return r0;
    L8:
        return r1.getClass().getName();
    }

    public static String c(LKBaseResponseModel r3) {
        if (r3 != null) goto L7;
        Log.i("PluginUtils", "responseModel is null");
        return null;
    L7:
        if (r3.getApiErrCode() != null) goto L11;
        Log.i("PluginUtils", "apiErrCode in responseModel is null");
        return null;
    L11:
        if (TextUtils.isEmpty(r3.getCustomErrMsg()) == true) goto L15;
        Log.i("PluginUtils", "customErrMsg in responseModel is valid:" + r3.getCustomErrMsg());
        return r3.getCustomErrMsg();
    L15:
        return r3.getApiErrCode().b;
    }

    public static void a(JSONObject r4, LKBaseResponseModel r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.findRemovedParams() != null) goto L6;
        return;
    L6:
        if (r5.findRemovedParams().isEmpty() == true) goto L20;
        Iterator<String> r0 = r5.findRemovedParams().iterator();
    L9:
        if (r0.hasNext() == false) goto L21;
        String r1 = r0.next();
        if (r4.has(r1) == false) goto L9;
        r4.remove(r1);
        Log.i("PluginUtils", "check & remove params for : " + r5 + " key : " + r1);
        goto L9
    L21:
        return;
    }
}
