package vmb;

import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.feed.shared.page.s;
import com.ss.android.lark.feed.shared.page.t;
import com.ss.android.lark.feed.shared.page.u;
import com.ss.android.lark.flow.feed.page.FlowMixedFeedFragment;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.passportc.api.m;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@OfficeSDKUserScope
public final class b extends c0c.c implements a {
    public final l b;
    public final t c;
    public final u d;
    public final com.ss.android.lark.flow.feed.data.a e;

    @Override // vmb.a
    public final String t() {
        return ((c0c.c) this).a.getUser().userId;
    }

    @Override // vmb.a
    public final com.ss.android.lark.flow.feed.data.a Q() {
        return this.e;
    }

    @Override // vmb.a
    public final l w() {
        return this.b;
    }

    @Override // vmb.a
    public final s M(FlowMixedFeedFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "storeOwner");
        s r3 = this.c.a(r2);
        r3.setFilterDoubaoConversation(false);
        return r3;
    }

    @Override // vmb.a
    public final s t0(ViewModelStoreOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "storeOwner");
        return this.d.a(r2);
    }

    @Inject
    public b(m r2, l r3, t r4, u r5, com.ss.android.lark.flow.feed.data.a r6) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        Intrinsics.checkNotNullParameter(r3, "rustClient");
        Intrinsics.checkNotNullParameter(r4, "feedItemsViewModelFactory");
        Intrinsics.checkNotNullParameter(r5, "feedSidebarItemsViewModelFactory");
        Intrinsics.checkNotNullParameter(r6, "doubaoFeedMigrateStatus");
        super(r2);
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
