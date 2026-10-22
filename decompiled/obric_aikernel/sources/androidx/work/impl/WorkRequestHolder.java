package androidx.work.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkRequestHolder extends WorkRequest {
    public WorkRequestHolder(@NonNull UUID r10, @NonNull WorkSpec r11, @NonNull Set<String> r12) {
        super(r10, r11, r12);
    }
}
