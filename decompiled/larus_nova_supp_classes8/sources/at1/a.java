package at1;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public final Context a;
    public final DataCenter b;
    public final JSONObject c;

    public final Context getContext() {
        return this.a;
    }

    public a(Context r2, DataCenter r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
