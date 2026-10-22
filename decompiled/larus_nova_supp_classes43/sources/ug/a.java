package ug;

import com.bytedance.android.ec.core.event.eventdumper.model.DumpedEvent;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final LinkedList<DumpedEvent> a;

    /* JADX INFO: renamed from: ug.a$a, reason: collision with other inner class name */
    public static final class C0204a {
    }

    static {
    }

    public a() {
        this.a = new LinkedList();
    }

    public final void a(DumpedEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "dumpedEvent");
        if (this.a.size() < 200) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.a.remove(0);
    L8:
        this.a.add(r10);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
