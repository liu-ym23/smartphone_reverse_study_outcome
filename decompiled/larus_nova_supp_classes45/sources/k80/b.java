package k80;

import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ScopeProvider;
import io.reactivex.CompletableSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements ScopeProvider {
    public final View a;

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.ScopeProvider
    public final CompletableSource requestScope() {
        return new a(this.a);
    }

    public b(View r1) {
        this.a = r1;
    }
}
