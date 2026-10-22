package v7;

import androidx.annotation.MainThread;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.model.InitPeriod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class c implements m7.a {
    public c() {
    }

    @Override // m7.a
    @MainThread
    public void a(InitPeriod r10) {
        Intrinsics.checkNotNullParameter(r10, "initPeriod");
        InitScheduler.onPeriodStart(r10);
        InitScheduler.onPeriodEnd(r10);
    }
}
