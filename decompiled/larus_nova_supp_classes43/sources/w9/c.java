package w9;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface c extends com.bytedance.android.annie.service.a {
    boolean handleHttpSchema(Context r1, Uri r10, View r11, Map<String, String> r12);

    boolean j0(Context r1, Uri r10, View r11, JSONObject r12);

    void v1(Context r1, String r10, View r11, Map<String, String> r12);
}
