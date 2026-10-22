package b3;

import android.content.Context;
import com.bytedance.ai.model.LynxWorkerRuntime;
import com.bytedance.ai.model.objects.Applet;
import com.lynx.tasm.LynxGroup;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final Context a;
    public final Applet b;
    public final LynxGroup c;
    public final LynxWorkerRuntime d;

    public a(Context r10, Applet r11, Map<String, Object> r12) {
        Intrinsics.checkNotNullParameter(r10, "appContext");
        Intrinsics.checkNotNullParameter(r11, "applet");
        this.a = r10;
        this.b = r11;
        LynxGroup.a r13 = new LynxGroup.a();
        r13.a = r11.o();
        r13.d = true;
        this.c = new LynxGroup(r13);
        this.d = new LynxWorkerRuntime(this.a, this.b, r12, this.c);
    }
}
