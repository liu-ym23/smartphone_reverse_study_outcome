package ia2;

import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.k;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder.QuickAbilityBaseViewHolder;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements a {
    public boolean a;
    public RecyclerView b;
    public final List<b> c;
    public final DataCenter d;
    public final k e;
    public final CompositeDisposable f;

    @Override // ia2.a
    public final String getAnchorId() {
        String r0 = z.o(this.d).getAnchorId();
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0;
    }

    @Override // ia2.a
    public final WeakReference<DataCenter> getDataCenter() {
        return this.e.getDataCenter();
    }

    @Override // ia2.a
    public final long getRoomId() {
        return z.o(this.d).getRoomId();
    }

    @Override // ia2.a
    public final boolean isMessageListEmpty() {
        return this.e.b();
    }

    @Override // ia2.a
    public final CompositeDisposable getCompositeDisposable() {
        return this.f;
    }

    public final void b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "source");
        if (this.e.a() == true) goto L5;
        return;
    L5:
        int r0 = ga2.d.a;
        ga2.d.a("QuickAbilityViewManager.reportShowLog, source: ".concat(r6));
        RecyclerView r7 = this.b;
        if (r7 == null) goto L8;
        RecyclerView.LayoutManager r8 = r7.getLayoutManager();
    L10:
        if ((r8 instanceof LinearLayoutManager) == true) goto L12;
        r8 = null;
    L12:
        LinearLayoutManager r9 = (LinearLayoutManager) r8;
        if (r9 == null) goto L39;
        int r1 = r9.findFirstVisibleItemPosition();
        int r10 = r9.findLastVisibleItemPosition();
        if (r1 == (-1)) goto L35;
        if (r10 == (-1)) goto L35;
        Iterator r2 = ((ArrayList) this.c).iterator();
    L20:
        if (r2.hasNext() == false) goto L22;
        ((b) r2.next()).c = true;
        goto L20
    L22:
        if (r1 > r10) goto L40;
    L23:
        RecyclerView r3 = this.b;
        if (r3 == null) goto L26;
        RecyclerView.ViewHolder r4 = r3.findViewHolderForAdapterPosition(r1);
    L28:
        if ((r4 instanceof QuickAbilityBaseViewHolder) == true) goto L30;
        r4 = null;
    L30:
        QuickAbilityBaseViewHolder r5 = (QuickAbilityBaseViewHolder) r4;
        if (r5 == null) goto L33;
        r5.T3(this.d);
    L33:
        if (r1 == r10) goto L41;
        r1 = r1 + 1;
        goto L23
    L41:
        return;
    L26:
        r4 = null;
        goto L28
    L40:
        return;
    L35:
        ga2.d.a("QuickAbilityViewManager.reportShowLog, first=" + r1 + ", last=" + r10);
        return;
    L39:
        return;
    L8:
        r8 = null;
        goto L10
    }

    public final void a(ViewGroup r2, boolean r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        RecyclerView r0 = this.b;
        if (r0 == null) goto L7;
        ViewGroup r1 = UtilityKotlinExtentionsKt.p(r0);
    L9:
        if (Intrinsics.areEqual(r1, r2) == false) goto L11;
        return;
    L11:
        RecyclerView r4 = this.b;
        if (r4 == null) goto L14;
        UtilityKotlinExtentionsKt.q(r4);
    L14:
        r2.addView(this.b);
        this.a = r3;
        Iterator r5 = ((ArrayList) this.c).iterator();
    L16:
        if (r5.hasNext() == false) goto L18;
        ((b) r5.next()).d = r3;
        goto L16
    L18:
        RecyclerView r6 = this.b;
        if (r6 == null) goto L25;
        RecyclerView.Adapter r7 = r6.getAdapter();
        if (r7 == null) goto L26;
        r7.notifyDataSetChanged();
        return;
    L26:
        return;
    L25:
        return;
    L7:
        r1 = null;
        goto L9
    }

    public e(DataCenter r2, k r3, CompositeDisposable r4) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "envProvider");
        Intrinsics.checkNotNullParameter(r4, "cd");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.c = new ArrayList();
    }
}
