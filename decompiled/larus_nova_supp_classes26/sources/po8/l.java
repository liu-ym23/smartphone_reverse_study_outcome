package po8;

import com.larus.bmhome.chat.view.DislikeFeedbackDialogFragment;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l implements IIMCallback<Message> {
    public final /* synthetic */ DislikeFeedbackDialogFragment a;

    public final boolean mustInMain() {
        return true;
    }

    public l(DislikeFeedbackDialogFragment r1) {
        this.a = r1;
    }

    public final void onFailure(IIMError r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    public final void onSuccess(Object r3) {
        Message r4 = (Message) r3;
        Intrinsics.checkNotNullParameter(r4, "result");
        DislikeFeedbackDialogFragment r0 = this.a;
        Map r5 = r4.getExt();
        if (r5 == null) goto L5;
        String r6 = (String) r5.get("inner_log_id");
    L6:
        int r1 = DislikeFeedbackDialogFragment.g;
        r0.T90(r6);
        return;
    L5:
        r6 = null;
        goto L6
    }
}
