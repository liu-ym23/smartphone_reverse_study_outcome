package wd8;

import com.larus.bmhome.chat.component.list.pipeline.PipelineTaskStageEnum;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import td8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements td8.b {
    public final d a;
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
        return PipelineTaskStageEnum.FINAL_FILTER;
    }

    public c(d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
        this.b = LazyKt.lazy(new wd8.a(this));
        this.c = LazyKt.lazy(new b(this));
    }

    @Override // td8.b
    public final com.larus.bmhome.social.page.datasource.event.c<xc8.b> a(com.larus.bmhome.social.page.datasource.event.c<xc8.b> r16) {
        Intrinsics.checkNotNullParameter(r16, "input");
        List r2 = r16.a;
        FLogger.a.i("Pipeline_List_FinalFilterStage", "start FinalFilterStage, origin version is " + r16.b + ", origin size is " + r16.a.size());
        Iterator r3 = ((List) this.b.getValue()).iterator();
        boolean r5 = false;
    L4:
        if (r3.hasNext() == false) goto L8;
        td8.c r6 = (td8.c) r3.next();
        if (td8.c.a.a(r6, 0, null, null, r2, 7) == false) goto L4;
        r2 = td8.c.a.b(r6, 0, CollectionsKt.toMutableList(r2), 7);
        r5 = true;
        goto L4
    L8:
        td8.c r4 = (td8.c) this.c.getValue();
        if (r4 == null) goto L13;
        List r7 = td8.c.a.b(r4, -1, CollectionsKt.toMutableList(r2), 6);
        if (Intrinsics.areEqual(r7, r2) == true) goto L13;
        r2 = r7;
        r5 = true;
    L13:
        if (r5 == true) goto L16;
        FLogger.a.i("Pipeline_List_FinalFilterStage", "end FinalFilterStage, no filter");
        return r16;
    L16:
        com.larus.bmhome.social.page.datasource.event.c<xc8.b> r1 = com.larus.bmhome.social.page.datasource.event.c.a(r16, r2, 0, null, null, 14);
        FLogger.a.i("Pipeline_List_FinalFilterStage", "end FinalFilterStage, end version is " + r1.b + ", end size is " + r1.a.size());
        return r1;
    }
}
