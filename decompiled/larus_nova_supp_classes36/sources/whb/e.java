package whb;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;
import com.ss.android.lark.flow.replyinthread.FlowReplyInThreadActivity;
import com.ss.android.lark.flow.replyinthread.Hilt_FlowReplyInThreadActivity;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements OnContextAvailableListener {
    public final /* synthetic */ Hilt_FlowReplyInThreadActivity a;

    public e(Hilt_FlowReplyInThreadActivity r1) {
        this.a = r1;
    }

    public final void onContextAvailable(Context r2) {
        Hilt_FlowReplyInThreadActivity r3 = this.a;
        if (r3.a == true) goto L6;
        r3.a = true;
        ((a) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(r3)).provideComponent()).f1((FlowReplyInThreadActivity) UnsafeCasts.unsafeCast(r3));
        return;
    }
}
