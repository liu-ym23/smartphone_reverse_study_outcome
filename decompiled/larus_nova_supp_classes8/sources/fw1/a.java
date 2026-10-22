package fw1;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.DoubleBallSwipeRefreshLayout;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.SwipeRefreshLayout;
import com.bytedance.android.livesdkapi.drawer.ILiveDoubleBallSwipeRefreshLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements ILiveDoubleBallSwipeRefreshLayout {
    public final DoubleBallSwipeRefreshLayout a;

    /* JADX INFO: renamed from: fw1.a$a, reason: collision with other inner class name */
    public static final class C0386a implements SwipeRefreshLayout.f {
        public final /* synthetic */ ILiveDoubleBallSwipeRefreshLayout.OnRefreshListener a;

        public C0386a(ILiveDoubleBallSwipeRefreshLayout.OnRefreshListener r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.ui.pullrefresh.SwipeRefreshLayout.f
        public final void onRefresh() {
            ILiveDoubleBallSwipeRefreshLayout.OnRefreshListener r0 = this.a;
            if (r0 == null) goto L6;
            r0.onRefresh();
            return;
        }
    }

    public final boolean isRefreshing() {
        return this.a.c;
    }

    public final ViewGroup getView() {
        return this.a;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = new DoubleBallSwipeRefreshLayout(r2);
    }

    public final void setEnabledPull(boolean r2) {
        this.a.setEnabled(r2);
    }

    public final void setOnRefreshListener(ILiveDoubleBallSwipeRefreshLayout.OnRefreshListener r3) {
        this.a.setOnRefreshListener(new C0386a(r3));
    }

    public final void setRefreshing(boolean r2) {
        this.a.setRefreshing(r2);
    }
}
