package slb;

import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h {
    public final String a;
    public final String b;
    public final transient Function2<String, String, Unit> c;
    public final ArrayList<m> d;
    public final boolean e;

    public h() {
        throw null;
    }

    public final String toString() {
        return "OperateButton(key='" + this.a + "', text='" + this.b + "', callback=" + this.c + ", promptGroups=" + this.d + ')';
    }

    public h(String r2, String r3, Function2 r4) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r3, "text");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = null;
        this.e = false;
    }
}
