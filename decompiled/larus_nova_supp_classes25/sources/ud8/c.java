package ud8;

import com.larus.bmhome.social.userchat.model.b0;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import td8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements td8.c {
    public final d a;

    public static final class a {
    }

    static {
    }

    public c(d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
    }

    @Override // td8.c
    public final boolean a(int r1, xc8.b r2, xc8.b r3, List<? extends xc8.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "input");
        return this.a.k();
    }

    @Override // td8.c
    public final List<xc8.b> b(int r4, xc8.b r5, xc8.b r6, List<xc8.b> r7) {
        Intrinsics.checkNotNullParameter(r6, "current");
        Intrinsics.checkNotNullParameter(r7, "input");
        FLogger.a.i("Pipeline_List_ImmerseCutTask", "start ImmerseCutTask, start input size is " + r7.size());
        Iterator<xc8.b> r8 = r7.iterator();
        int r0 = 0;
    L4:
        if (r8.hasNext() == false) goto L14;
        xc8.b r1 = r8.next();
        if (com.larus.bmhome.chat.bean.d.G0(r1.getMessage()) == true) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L15;
        r0 = r0 + 1;
    L15:
        if (r0 < 0) goto L18;
        List<xc8.b> r9 = r7.subList(0, r0 + 1);
        FLogger.a.i("Pipeline_List_ImmerseCutTask", "end ImmerseCutTask, end result size is " + r9.size() + ", lastSelfMessageIndex is " + r0);
        return r9;
    L18:
        FLogger.a.i("Pipeline_List_ImmerseCutTask", "end ImmerseCutTask, no any immerse cut");
        return r7;
    L8:
        if (b0.f(r1.getMessage()) == true) goto L10;
        r2 = true;
        goto L11
    L14:
        r0 = -1;
        goto L15
    }
}
