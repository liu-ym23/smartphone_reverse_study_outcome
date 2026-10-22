package androidx.lifecycle;

import android.app.Application;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class AndroidViewModel extends ViewModel {
    private final Application application;

    public AndroidViewModel(Application r10) {
        Intrinsics.checkNotNullParameter(r10, "application");
        this.application = r10;
    }

    public <T extends Application> T getApplication() {
        T r10 = (T) this.application;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return r10;
    }
}
