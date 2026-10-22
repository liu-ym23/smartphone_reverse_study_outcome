package nwb;

import com.ss.android.lark.chat.component.task.SetLoginChatterTask;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class c implements b {
    @Inject
    public c() {
    }

    @Override // nwb.b
    public final List<j0c.b> a() {
        j0c.b r1 = zoc.b.b;
        j0c.b r2 = SetLoginChatterTask.b;
        return CollectionsKt.listOf(new j0c.b[]{zoc.b.b, SetLoginChatterTask.b});
    }
}
