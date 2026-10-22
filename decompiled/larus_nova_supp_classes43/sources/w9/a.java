package w9;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.annie.Annie;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements c {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // w9.c
    public final boolean handleHttpSchema(Context r10, Uri r11, View r12, Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "uri");
        return ((c) Annie.getService$default(c.class, null, 2, null)).handleHttpSchema(r10, r11, r12, r13);
    }

    @Override // w9.c
    public final boolean j0(Context r10, Uri r11, View r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "uri");
        return ((c) Annie.getService$default(c.class, null, 2, null)).j0(r10, r11, r12, r13);
    }

    @Override // w9.c
    public final void v1(Context r10, String r11, View r12, Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        ((c) Annie.getService$default(c.class, null, 2, null)).v1(r10, r11, r12, r13);
    }
}
