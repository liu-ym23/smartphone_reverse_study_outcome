package bgb;

import android.widget.FrameLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.flow.bottomsheet.biz.replyinthread.ReplyInThreadFrameFragment;
import com.ss.android.lark.flow.replyinthread.pages.FlowReplyInThreadFragment;
import com.ss.android.lark.replyinthread.pages.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ ReplyInThreadFrameFragment a;

    public b(ReplyInThreadFrameFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        f r6 = (f) r5;
        ReplyInThreadFrameFragment r0 = this.a;
        Intrinsics.checkNotNull(r6);
        int r1 = ReplyInThreadFrameFragment.q;
        FlowReplyInThreadFragment r2 = r0.V90();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "pageInfo");
        r2.p = r6;
        r0.V90().setArguments(r0.getArguments());
        FragmentTransaction r7 = r0.getChildFragmentManager().beginTransaction();
        FlowReplyInThreadFragment r3 = r0.V90();
        FrameLayout r4 = r0.m;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("container");
        r4 = null;
    L5:
        int r8 = r4.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r7, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, r8) == true) goto L9;
        r7.add(r8, r3, null);
    L9:
        r7.commitAllowingStateLoss();
    }
}
