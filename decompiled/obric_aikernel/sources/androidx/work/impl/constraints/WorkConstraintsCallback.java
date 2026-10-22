package androidx.work.impl.constraints;

import androidx.work.impl.model.WorkSpec;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface WorkConstraintsCallback {
    void onAllConstraintsMet(List<WorkSpec> r10);

    void onAllConstraintsNotMet(List<WorkSpec> r10);
}
