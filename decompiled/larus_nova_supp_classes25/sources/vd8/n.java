package vd8;

import com.larus.bmhome.chat.component.list.pipeline.PipelineTaskStageEnum;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n implements td8.b {
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
        return PipelineTaskStageEnum.DIRECT_ADD;
    }

    public n(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
        this.b = LazyKt.lazy(new l(this));
        this.c = LazyKt.lazy(new m(this));
    }

    @Override // td8.b
    public final com.larus.bmhome.social.page.datasource.event.c<xc8.b> a(com.larus.bmhome.social.page.datasource.event.c<xc8.b> r16) {
        Intrinsics.checkNotNullParameter(r16, "input");
        List r2 = CollectionsKt.toMutableList(r16.a);
        FLogger.a.i("Pipeline_List_DirectAddStage", "start DirectAddStage, origin version is " + r16.b + ", origin size is " + r16.a.size());
        Iterator r3 = ((List) this.c.getValue()).iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        td8.c r4 = (td8.c) r3.next();
        if (td8.c.a.a(r4, 0, null, null, r2, 7) == false) goto L4;
        r2 = td8.c.a.b(r4, 0, r2, 7);
        goto L4
    L9:
        if (td8.c.a.a((k) this.b.getValue(), 0, null, null, null, 15) == false) goto L11;
        com.larus.bmhome.social.page.datasource.event.c<xc8.b> r1 = com.larus.bmhome.social.page.datasource.event.c.a(r16, td8.c.a.b((k) this.b.getValue(), 0, r2, 7), -1, CollectionsKt.listOf(new com.larus.bmhome.social.page.datasource.event.b.d(false)), null, 8);
    L12:
        FLogger.a.i("Pipeline_List_DirectAddStage", "end DirectAddStage, end version is " + r1.b + ", end size is " + r1.a.size());
        return r1;
    L11:
        r1 = com.larus.bmhome.social.page.datasource.event.c.a(r16, r2, 0, null, null, 14);
        goto L12
    }
}
