package qea;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pea.c;
import pea.k;
import pea.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a implements l {
    public final c a;

    /* JADX INFO: renamed from: qea.a$a, reason: collision with other inner class name */
    public static final class C0066a {
    }

    static {
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "GRSmallCollapseTemplate(picInfo=" + this.a + ')';
    }

    @Override // pea.l
    public final Bundle getActions() {
        return new Bundle();
    }

    @Override // pea.l
    public final Bundle getPics() {
        Bundle r0 = new Bundle();
        r0.putParcelable(this.a.b, Icon.createWithResource(AppHost.a.getApplication().getApplicationContext(), this.a.c));
        FLogger.a.d("GRSmallCollapseTemplate", "getPics: " + r0);
        return r0;
    }

    @Override // pea.l
    public final JSONObject toJSONObject() {
        JSONObject r0 = new JSONObject();
        r0.put("picInfo", this.a.a());
        return r0;
    }

    public a(c r2) {
        Intrinsics.checkNotNullParameter(r2, "picInfo");
        this.a = r2;
    }

    @Override // pea.l
    public final k create(Boolean r3) {
        return new k("com.obric.island_assistant:gr_common_small_collapse_template", this, r3);
    }
}
