package h5;

import com.bytedance.ai.model.objects.AppletSettings;
import com.bytedance.ai.model.objects.Icons;
import com.bytedance.ai.model.objects.MainInitData;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.model.objects.PermissionDetail;
import com.bytedance.ai.model.objects.Plugin;
import com.bytedance.ai.model.objects.ServiceInfo;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/ai/model/objects/DataConverter$toList$listType$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends String>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/ai/model/objects/DataConverter$toPage$listType$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/ai/model/objects/Page;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends Page>> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/ai/model/objects/DataConverter$toPermissions$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "Lcom/bytedance/ai/model/objects/PermissionDetail;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends TypeToken<Map<String, ? extends PermissionDetail>> {
        public c() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/ai/model/objects/DataConverter$toPlugin$listType$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/ai/model/objects/Plugin;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d extends TypeToken<List<? extends Plugin>> {
        public d() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/ai/model/objects/DataConverter$toServiceInfo$listType$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/ai/model/objects/ServiceInfo;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e extends TypeToken<List<? extends ServiceInfo>> {
        public e() {
        }
    }

    public h() {
    }

    public static Icons a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "json");
        Lazy r0 = com.bytedance.ai.applet.base.gson.e.a;
        return (Icons) com.bytedance.ai.applet.base.gson.e.a(r1, Icons.class);
    }

    public static List b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "json");
        Type r0 = new a().getType();
        Lazy r1 = com.bytedance.ai.applet.base.gson.e.a;
        Intrinsics.checkNotNull(r0);
        return (List) com.bytedance.ai.applet.base.gson.e.b(r10, r0);
    }

    public static MainInitData c(String r1) {
        Lazy r0 = com.bytedance.ai.applet.base.gson.e.a;
        return (MainInitData) com.bytedance.ai.applet.base.gson.e.a(r1, MainInitData.class);
    }

    public static List d(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        Type r0 = new b().getType();
        Lazy r1 = com.bytedance.ai.applet.base.gson.e.a;
        Intrinsics.checkNotNull(r0);
        return (List) com.bytedance.ai.applet.base.gson.e.b(r10, r0);
    }

    public static Map e(String r10) {
        Type r0 = new c().getType();
        Lazy r1 = com.bytedance.ai.applet.base.gson.e.a;
        Intrinsics.checkNotNull(r0);
        return (Map) com.bytedance.ai.applet.base.gson.e.b(r10, r0);
    }

    public static List f(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        Type r0 = new d().getType();
        Lazy r1 = com.bytedance.ai.applet.base.gson.e.a;
        Intrinsics.checkNotNull(r0);
        return (List) com.bytedance.ai.applet.base.gson.e.b(r10, r0);
    }

    public static List g(String r10) {
        Type r0 = new e().getType();
        Lazy r1 = com.bytedance.ai.applet.base.gson.e.a;
        Intrinsics.checkNotNull(r0);
        return (List) com.bytedance.ai.applet.base.gson.e.b(r10, r0);
    }

    public static AppletSettings h(String r1) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return null;
    L11:
        Lazy r10 = com.bytedance.ai.applet.base.gson.e.a;
        return (AppletSettings) com.bytedance.ai.applet.base.gson.e.a(r1, AppletSettings.class);
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }
}
