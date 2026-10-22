package zjb;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class b {

    @SerializedName("guideList")
    private Map<String, xjb.b> guideList;

    public b() {
        this.guideList = new HashMap();
    }

    public final void a(Map<String, xjb.b> r1) {
        this.guideList = r1;
    }
}
