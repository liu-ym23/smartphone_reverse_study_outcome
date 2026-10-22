package nwb;

import com.ss.android.lark.chat.component.task.SetLoginChatterTask;
import com.ss.android.lark.passportc.ffi.KmpOfflineTask;
import com.ss.android.lark.passportc.ffi.KmpOnlineTask;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f implements com.ss.android.lark.passportc.task.g {
    public final Set<b> a;

    @Override // com.ss.android.lark.passportc.task.g
    public final List<j0c.b> f() {
        j0c.b r1 = KmpOfflineTask.a;
        j0c.b r2 = jjb.e.d;
        j0c.b r3 = eeb.c.c;
        return CollectionsKt.listOf(new j0c.b[]{KmpOfflineTask.a, jjb.e.d, eeb.c.c});
    }

    @Override // com.ss.android.lark.passportc.task.g
    public final List<j0c.b> b() {
        j0c.b r0 = com.ss.android.lark.passportc.task.h.c;
        return CollectionsKt.listOf(com.ss.android.lark.passportc.task.h.c);
    }

    @Override // com.ss.android.lark.passportc.task.g
    public final List<j0c.b> g() {
        j0c.b r1 = i.a;
        j0c.b r2 = jjb.h.m;
        j0c.b r3 = h.a;
        j0c.b r4 = com.ss.android.lark.passportc.task.h.c;
        j0c.b r5 = KmpOnlineTask.a;
        j0c.b r6 = zoc.b.b;
        j0c.b r7 = SetLoginChatterTask.b;
        j0c.b r8 = wjb.a.a;
        List<j0c.b> r0 = CollectionsKt.mutableListOf(new j0c.b[]{i.a, jjb.h.m, h.a, com.ss.android.lark.passportc.task.h.c, KmpOnlineTask.a, zoc.b.b, SetLoginChatterTask.b, wjb.a.a});
        Iterator<T> r9 = this.a.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r0.addAll(((b) r9.next()).a());
        goto L4
    L6:
        return r0;
    }

    @Override // com.ss.android.lark.passportc.task.g
    public final List<j0c.b> a() {
        return CollectionsKt.emptyList();
    }

    @Inject
    public f(Set<b> r2) {
        Intrinsics.checkNotNullParameter(r2, "taskOrderInjectors");
        this.a = r2;
    }
}
