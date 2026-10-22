package py;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fR:\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lpy/a;", "Lvh7/c;", "", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getTypeMap", "()Ljava/util/Map;", "getTypeMap$annotations", "()V", "typeMap", "Companion", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface a extends vh7.c<a> {
    public static final C0262a Companion = null;
    public static final long mediaType = 1;

    /* JADX INFO: renamed from: py.a$a, reason: collision with other inner class name */
    public static final class C0262a {
        public static final /* synthetic */ C0262a a = null;

        public C0262a() {
        }

        static {
            a = new C0262a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = C0262a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "account_type_map")
    Map<Long, Boolean> getTypeMap();
}
