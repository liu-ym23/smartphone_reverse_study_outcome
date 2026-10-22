package androidx.work.impl.workers;

import android.os.Build;
import androidx.work.Logger;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.model.WorkTagDao;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class DiagnosticsWorkerKt {
    private static final String TAG = null;

    static {
        String r10 = Logger.tagWithPrefix("DiagnosticsWrkr");
        Intrinsics.checkNotNullExpressionValue(r10, "tagWithPrefix(\"DiagnosticsWrkr\")");
        TAG = r10;
    }

    public static final /* synthetic */ String access$getTAG$p() {
        return TAG;
    }

    public static final /* synthetic */ String access$workSpecRows(WorkNameDao r10, WorkTagDao r11, SystemIdInfoDao r12, List r13) {
        return workSpecRows(r10, r11, r12, r13);
    }

    private static final String workSpecRow(WorkSpec r10, String r11, Integer r12, String r13) {
        return '\n' + r10.id + "\t " + r10.workerClassName + "\t " + r12 + "\t " + r10.state.name() + "\t " + r11 + "\t " + r13 + '\t';
    }

    private static final String workSpecRows(WorkNameDao r18, WorkTagDao r19, SystemIdInfoDao r20, List<WorkSpec> r21) {
        StringBuilder r10 = new StringBuilder();
        if (Build.VERSION.SDK_INT < 23) goto L5;
        String r11 = "Job Id";
    L6:
        r10.append("\n Id \t Class Name\t " + r11 + "\t State\t Unique Name\t Tags\t");
        Iterator<T> r12 = r21.iterator();
    L8:
        if (r12.hasNext() == false) goto L14;
        WorkSpec r13 = (WorkSpec) r12.next();
        SystemIdInfo r14 = r20.getSystemIdInfo(WorkSpecKt.generationalId(r13));
        if (r14 == null) goto L12;
        Integer r15 = Integer.valueOf(r14.systemId);
    L13:
        r10.append(workSpecRow(r13, CollectionsKt.joinToString$default(r18.getNamesForWorkSpecId(r13.id), ",", null, null, 0, null, null, 62, null), r15, CollectionsKt.joinToString$default(r19.getTagsForWorkSpecId(r13.id), ",", null, null, 0, null, null, 62, null)));
        goto L8
    L12:
        r15 = null;
        goto L13
    L14:
        String r16 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r16, "StringBuilder().apply(builderAction).toString()");
        return r16;
    L5:
        r11 = "Alarm Id";
        goto L6
    }
}
