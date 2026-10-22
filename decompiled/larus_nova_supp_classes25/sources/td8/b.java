package td8;

import com.larus.bmhome.chat.component.list.pipeline.PipelineTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.PipelineTaskStageEnum;
import com.larus.bmhome.chat.component.list.pipeline.PipelineTaskType;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface b {

    public static final class a {

        /* JADX INFO: renamed from: td8.b$a$a, reason: collision with other inner class name */
        public static final class C0086a<T> implements Comparator {
            public C0086a() {
            }

            @Override // java.util.Comparator
            public final int compare(T r1, T r2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((PipelineTaskProvider) r1).order()), Integer.valueOf(((PipelineTaskProvider) r2).order()));
            }
        }

        public static List<c> a(b r7, d r8, PipelineTaskType r9) {
            Intrinsics.checkNotNullParameter(r8, "taskContext");
            Intrinsics.checkNotNullParameter(r9, "type");
            Set r0 = ServiceManager.get().getServices(PipelineTaskProvider.class, true);
            if (r0 != null) goto L5;
            r0 = SetsKt.emptySet();
        L5:
            ArrayList r1 = new ArrayList();
            Iterator r2 = r0.iterator();
        L7:
            if (r2.hasNext() == false) goto L16;
            Object r3 = r2.next();
            PipelineTaskProvider r4 = (PipelineTaskProvider) r3;
            if (r4.stage() == r7.stage()) goto L11;
        L13:
            boolean r5 = false;
        L14:
            if (r5 == false) goto L7;
            r1.add(r3);
            goto L7
        L11:
            if (r4.type() != r9) goto L13;
            r5 = true;
            goto L14
        L16:
            List r6 = CollectionsKt.sortedWith(r1, new C0086a());
            ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
            Iterator r11 = r6.iterator();
        L18:
            if (r11.hasNext() == false) goto L20;
            r10.add(((PipelineTaskProvider) r11.next()).a(r8));
            goto L18
        L20:
            FLogger r12 = FLogger.a;
            StringBuilder r13 = new StringBuilder();
            r13.append(r7.stage().name());
            r13.append('[');
            r13.append(r9.name());
            r13.append("] : ");
            ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
            Iterator r15 = r10.iterator();
        L22:
            if (r15.hasNext() == false) goto L24;
            r14.add(Reflection.getOrCreateKotlinClass(((c) r15.next()).getClass()).getSimpleName());
            goto L22
        L24:
            r13.append(r14);
            r12.d("Pipeline_IStage_collectTask", r13.toString());
            return CollectionsKt.toMutableList(r10);
        }
    }

    com.larus.bmhome.social.page.datasource.event.c<xc8.b> a(com.larus.bmhome.social.page.datasource.event.c<xc8.b> r1);

    void b();

    PipelineTaskStageEnum stage();
}
