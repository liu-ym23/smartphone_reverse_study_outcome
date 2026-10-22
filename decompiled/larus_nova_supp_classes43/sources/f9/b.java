package f9;

import android.webkit.WebResourceResponse;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface b extends com.bytedance.android.annie.service.a {
    Map<String, String> getHeaderMap(String r1);

    String getHostGeckoCacheDir();

    List<String> getSafeJsbHostList();

    WebResourceResponse interceptRequest(String r1);

    void m1();

    void setCachePrefix(List<Pattern> r1);
}
