package mg;

import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final CoroutineScope a(QViewModel r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$viewModelScope");
        CoroutineScope r1 = (CoroutineScope) r10.getTag("QViewModel.JOB_KEY");
        if (r1 == null) goto L6;
        return r1;
    L6:
        return (CoroutineScope) r10.setTagIfAbsent("QViewModel.JOB_KEY", new a(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain())));
    }
}
