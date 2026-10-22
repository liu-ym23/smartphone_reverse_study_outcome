package whb;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.flow.replyinthread.FlowReplyInThreadContainerFragment;
import com.ss.android.lark.flow.replyinthread.pages.FlowReplyInThreadFragment;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.replyinthread.pages.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ FlowReplyInThreadContainerFragment a;

    public b(FlowReplyInThreadContainerFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        f r7 = (f) r6;
        FlowReplyInThreadContainerFragment r0 = this.a;
        Intrinsics.checkNotNull(r7);
        int r1 = FlowReplyInThreadContainerFragment.i;
        FlowReplyInThreadFragment r2 = r0.g;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mFragment");
        r2 = null;
    L6:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r7, "pageInfo");
        r2.p = r7;
        Log.i("FlowReplyInThreadContainer", "setup content Fragment");
        Fragment r8 = r0.g;
        if (r8 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mFragment");
        r8 = null;
    L10:
        r8.setArguments(r0.getArguments());
        FragmentTransaction r9 = r0.getChildFragmentManager().beginTransaction();
        Fragment r3 = r0.g;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFragment");
        r3 = null;
    L15:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r9, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131373275) == true) goto L18;
        r9.add(2131373275, r3, null);
    L18:
        r9.commitAllowingStateLoss();
    }
}
