package u01;

import android.view.View;
import com.bytedance.android.livesdkapi.feed.IFeedViewState;
import com.bytedance.android.livesdkapi.feed.IPkFeedView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements IPkFeedView {
    public final qc0.c a;

    public final String getPkExpandType() {
        this.a.getPkExpandType();
        return "";
    }

    public final String getProgressAnimUrl() {
        this.a.getProgressAnimUrl();
        return null;
    }

    public final View getTeamTaskExtendView() {
        this.a.getTeamTaskExtendView();
        return null;
    }

    public final IFeedViewState getViewState() {
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r0 = this.a.getViewState();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new a(r0);
    }

    public i(qc0.c r2) {
        Intrinsics.checkNotNullParameter(r2, "real");
        this.a = r2;
    }
}
