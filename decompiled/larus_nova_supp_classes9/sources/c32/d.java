package c32;

import android.text.Spannable;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class d {
    public transient Spannable a;

    @SerializedName("action_type")
    public int actionType;

    @SerializedName("association_display_text")
    public a5 associationDisplayText;
    public boolean b;
    public String c;
    public long d;
    public boolean e;

    @SerializedName("extra_map")
    public Map<String, String> extraMap;

    @SerializedName("schema_url")
    public String schemaUrl;

    @SerializedName("tracking_info")
    public Map<String, String> trackMap;

    public final String a() {
        Map<String, String> r0 = this.extraMap;
        if (r0 != null) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        String r1 = r0.get("result_type");
        if (r1 != null) goto L9;
        return BuildConfig.FLAVOR;
    L9:
        return r1;
    }

    public d() {
        this.b = false;
        this.c = null;
        this.d = 0;
        this.e = false;
    }
}
