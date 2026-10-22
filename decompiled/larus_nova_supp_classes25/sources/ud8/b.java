package ud8;

import com.larus.bmhome.chat.component.list.pipeline.PipelineTaskStageEnum;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import td8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b implements td8.b {
    public final d a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    @Override // td8.b
    public final void b() {
    }

    @Override // td8.b
    public final PipelineTaskStageEnum stage() {
        return PipelineTaskStageEnum.DELETE;
    }

    public b(d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
        this.b = LazyKt.lazy(new ud8.a(this));
    }

    @Override // td8.b
    public final com.larus.bmhome.social.page.datasource.event.c<xc8.b> a(com.larus.bmhome.social.page.datasource.event.c<xc8.b> r16) {
        Intrinsics.checkNotNullParameter(r16, "input");
        List r1 = r16.a;
        FLogger.a.i("Pipeline_List_DeleteStage", "start DeleteStage, start input version is " + r16.b + ", start input size is " + r16.a.size());
        Iterator r2 = ((List) this.b.getValue()).iterator();
        boolean r4 = false;
    L4:
        if (r2.hasNext() == false) goto L8;
        td8.c r5 = (td8.c) r2.next();
        if (td8.c.a.a(r5, 0, null, null, r1, 7) == false) goto L4;
        r1 = td8.c.a.b(r5, 0, CollectionsKt.toMutableList(r1), 7);
        r4 = true;
        goto L4
    L8:
        if (r4 == false) goto L10;
        com.larus.bmhome.social.page.datasource.event.c<xc8.b> r0 = com.larus.bmhome.social.page.datasource.event.c.a(r16, new ArrayList(r1), -1, CollectionsKt.listOf(new com.larus.bmhome.social.page.datasource.event.b.d(false)), null, 8);
        FLogger.a.i("Pipeline_List_DeleteStage", "end DeleteStage, end result version is " + r0.b + ", end result size is " + r0.a.size());
        return r0;
    L10:
        FLogger.a.i("Pipeline_List_DeleteStage", "end DeleteStage, no any cut ");
        return r16;
    }
}
