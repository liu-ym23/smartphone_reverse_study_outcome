package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import com.bytedance.bdinstall.oaid.OaidModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class StartStopTokens {
    private final Object lock;
    private final Map<WorkGenerationalId, StartStopToken> runs;

    public StartStopTokens() {
        this.lock = new Object();
        this.runs = new LinkedHashMap();
    }

    public final boolean contains(WorkGenerationalId r10) {
        Intrinsics.checkNotNullParameter(r10, OaidModel.KEY_ID);
        Object r11 = this.lock;
        monitor-enter(r11);
        boolean r12 = this.runs.containsKey(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public final StartStopToken remove(WorkGenerationalId r10) {
        Intrinsics.checkNotNullParameter(r10, OaidModel.KEY_ID);
        Object r11 = this.lock;
        monitor-enter(r11);
        StartStopToken r12 = this.runs.remove(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public final StartStopToken remove(WorkSpec r10) {
        Intrinsics.checkNotNullParameter(r10, "spec");
        return remove(WorkSpecKt.generationalId(r10));
    }

    public final List<StartStopToken> remove(String r10) {
        Intrinsics.checkNotNullParameter(r10, "workSpecId");
        Object r11 = this.lock;
        monitor-enter(r11);
        Map<WorkGenerationalId, StartStopToken> r12 = this.runs;     // Catch: Throwable -> L17
        LinkedHashMap r13 = new LinkedHashMap();     // Catch: Throwable -> L17
        Iterator<Map.Entry<WorkGenerationalId, StartStopToken>> r14 = r12.entrySet().iterator();     // Catch: Throwable -> L17
    L6:
        if (r14.hasNext() == false) goto L10;
        Map.Entry<WorkGenerationalId, StartStopToken> r15 = r14.next();     // Catch: Throwable -> L17
        if (Intrinsics.areEqual(r15.getKey().getWorkSpecId(), r10) == false) goto L6;
        r13.put(r15.getKey(), r15.getValue());     // Catch: Throwable -> L17
        goto L6
    L10:
        Iterator r16 = r13.keySet().iterator();     // Catch: Throwable -> L17
    L12:
        if (r16.hasNext() == false) goto L14;
        WorkGenerationalId r17 = (WorkGenerationalId) r16.next();     // Catch: Throwable -> L17
        this.runs.remove(r17);     // Catch: Throwable -> L17
        goto L12
    L14:
        List<StartStopToken> r18 = CollectionsKt.toList(r13.values());     // Catch: Throwable -> L17
        monitor-exit(r11);
        return r18;
    L17:
        th = move-exception;
        throw th;
    }

    public final StartStopToken tokenFor(WorkGenerationalId r10) {
        Intrinsics.checkNotNullParameter(r10, OaidModel.KEY_ID);
        Object r11 = this.lock;
        monitor-enter(r11);
        Map<WorkGenerationalId, StartStopToken> r12 = this.runs;     // Catch: Throwable -> L10
        StartStopToken r13 = r12.get(r10);     // Catch: Throwable -> L10
        if (r13 != null) goto L7;
        r13 = new StartStopToken(r10);     // Catch: Throwable -> L10
        r12.put(r10, r13);     // Catch: Throwable -> L10
    L7:
        StartStopToken r14 = r13;     // Catch: Throwable -> L10
        monitor-exit(r11);
        return r14;
    L10:
        th = move-exception;
        throw th;
    }

    public final StartStopToken tokenFor(WorkSpec r10) {
        Intrinsics.checkNotNullParameter(r10, "spec");
        return tokenFor(WorkSpecKt.generationalId(r10));
    }
}
