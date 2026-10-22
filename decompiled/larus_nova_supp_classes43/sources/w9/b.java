package w9;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements c {
    public b() {
    }

    @Override // w9.c
    public final boolean handleHttpSchema(Context r1, Uri r10, View r11, Map<String, String> r12) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, "uri");
        return false;
    }

    @Override // w9.c
    public final boolean j0(Context r1, Uri r10, View r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, "uri");
        return false;
    }

    @Override // w9.c
    public final void v1(Context r1, String r10, View r11, Map<String, String> r12) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }
}
