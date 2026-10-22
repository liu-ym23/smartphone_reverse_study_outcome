package q20;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.browser.debug.mock.DebugLocalFragment;
import com.bytedance.android.live.browser.debug.mock.HybridHistoryListAdapter;
import com.bytedance.android.livesdk.LiveDialogFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ HybridHistoryListAdapter a;
    public final /* synthetic */ r20.a b;

    public d(HybridHistoryListAdapter r1, r20.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        FragmentActivity r6 = this.a.getContext();
        if (r6 == null) goto L6;
        int r0 = DebugLocalFragment.e;
        Uri r1 = this.b.c;
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r1, "originUri");
        Bundle r2 = new Bundle();
        DebugLocalFragment r3 = new DebugLocalFragment();
        r2.putParcelable("ARG_ORIGIN_URI", r1);
        r3.setArguments(r2);
        LiveDialogFragment.Companion.getClass();
        LiveDialogFragment.a.a(r6, r3);
        return;
    }
}
