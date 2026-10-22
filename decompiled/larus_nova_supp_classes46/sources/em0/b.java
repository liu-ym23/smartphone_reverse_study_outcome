package em0;

import com.bytedance.android.live.messagewindow.framework.context.CardContext;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.ies.sdk.widgets.DataCenter;
import d71.c;
import d71.d;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements c {
    public static final b a = null;

    public b() {
    }

    static {
        a = new b();
    }

    public final boolean b(DataCenter r2, MsgWindowPosition r3) {
        Intrinsics.checkNotNullParameter(r3, "position");
        CardContext.Companion.getClass();
        com.bytedance.android.live.messagewindow.framework.context.c r4 = CardContext.a.a(r2);
        if (r4 == null) goto L11;
        d<v61.a, d71.b> r5 = r4.recordManager(r3);
        if (r5 == null) goto L11;
        Collection r6 = r5.a();
        if (r6 == null) goto L11;
        if (r6.isEmpty() == true) goto L11;
        return true;
    L11:
        return false;
    }

    public final boolean a(DataCenter r2, Object r3, MsgWindowPosition r4) {
        Intrinsics.checkNotNullParameter(r3, "identity");
        Intrinsics.checkNotNullParameter(r4, "position");
        CardContext.Companion.getClass();
        com.bytedance.android.live.messagewindow.framework.context.c r5 = CardContext.a.a(r2);
        if (r5 == null) goto L9;
        d<v61.a, d71.b> r6 = r5.recordManager(r4);
        if (r6 == null) goto L9;
        if (r6.q(r3) != true) goto L9;
        return true;
    L9:
        return false;
    }
}
