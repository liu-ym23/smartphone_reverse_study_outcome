package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import com.bytedance.bdinstall.oaid.OaidModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class StartStopToken {
    private final WorkGenerationalId id;

    public StartStopToken(WorkGenerationalId r10) {
        Intrinsics.checkNotNullParameter(r10, OaidModel.KEY_ID);
        this.id = r10;
    }

    public final WorkGenerationalId getId() {
        return this.id;
    }
}
