package ccb;

import com.ss.android.lark.chat.entity.chatter.ChatterSensitiveInfo;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public String a;
    public Map<String, ChatterSensitiveInfo> b;

    public static final class a {
        public String a;
        public Map<String, ChatterSensitiveInfo> b;

        public a() {
            this.a = BuildConfig.FLAVOR;
            this.b = MapsKt.emptyMap();
        }
    }

    public b() {
        this.a = BuildConfig.FLAVOR;
        this.b = MapsKt.emptyMap();
    }
}
