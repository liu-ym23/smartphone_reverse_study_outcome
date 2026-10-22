package dg;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.impl.sku.presenter.ButtonPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends QUIModule {
    public final View l;

    public final List<QUIModule> i() {
        return null;
    }

    public final QIPresenter h() {
        Fragment r1 = a().i();
        if (r1 == null) goto L7;
        return new ButtonPresenter(r1);
    L7:
        throw new IllegalStateException("Required value was null.".toString());
    }

    public b(View r10) {
        Intrinsics.checkNotNullParameter(r10, "rootView");
        super(2131372843, null);
        this.l = r10;
    }

    public final View f(Context r1, ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }
}
