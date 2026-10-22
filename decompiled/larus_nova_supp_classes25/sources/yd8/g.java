package yd8;

import com.larus.bmhome.chat.component.list.pipeline.PipelineTaskStageEnum;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g implements td8.b {
    public final td8.d a;
    public final Lazy b;
    public final Lazy c;

    public static final class a {
    }

    static {
    }

    @Override // td8.b
    public final void b() {
    }

    @Override // td8.b
    public final PipelineTaskStageEnum stage() {
        return PipelineTaskStageEnum.UPDATE;
    }

    public g(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
        this.b = LazyKt.lazy(new e(this));
        this.c = LazyKt.lazy(new f(this));
    }

    @Override // td8.b
    public final com.larus.bmhome.social.page.datasource.event.c<xc8.b> a(com.larus.bmhome.social.page.datasource.event.c<xc8.b> r13) {
        Intrinsics.checkNotNullParameter(r13, "input");
        List r0 = CollectionsKt.toMutableList(r13.a);
        FLogger.a.i("Pipeline_List_UpdateStage", "start UpdateStage, origin version is " + r13.b + ", origin size is " + r13.a.size());
        Iterator r1 = ((List) this.b.getValue()).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0 = td8.c.a.b((td8.c) r1.next(), 0, r0, 7);
        goto L4
    L6:
        Iterator r2 = ((List) this.c.getValue()).iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        Object r3 = r2.next();
        if (td8.c.a.a((td8.c) r3, 0, null, null, r0, 7) == false) goto L8;
    L13:
        td8.c r4 = (td8.c) r3;
        if (r4 == null) goto L16;
        r0 = td8.c.a.b(r4, 0, r0, 7);
    L16:
        com.larus.bmhome.social.page.datasource.event.c<xc8.b> r14 = com.larus.bmhome.social.page.datasource.event.c.a(r13, r0, 0, null, null, 14);
        FLogger.a.i("Pipeline_List_UpdateStage", "end UpdateStage, end version is " + r14.b + ", end size is " + r14.a.size());
        return r14;
    L12:
        r3 = null;
        goto L13
    }
}
