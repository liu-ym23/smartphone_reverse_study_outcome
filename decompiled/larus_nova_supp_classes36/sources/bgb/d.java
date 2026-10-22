package bgb;

import androidx.lifecycle.Observer;
import com.ss.android.lark.bottomsheet.fragment.BottomSheetFrameFragment;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.bottomsheet.BottomSheetViewModel;
import com.ss.android.lark.flow.bottomsheet.biz.replyinthread.ReplyInThreadFrameFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ ReplyInThreadFrameFragment a;

    public d(ReplyInThreadFrameFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        if (((Boolean) r3).booleanValue() == false) goto L6;
        ReplyInThreadFrameFragment r4 = this.a;
        int r0 = ReplyInThreadFrameFragment.q;
        ((BottomSheetViewModel) ((BottomSheetFrameFragment) r4).g.getValue()).getState().observe(this.a.getViewLifecycleOwner(), c.a);
        return;
    }
}
