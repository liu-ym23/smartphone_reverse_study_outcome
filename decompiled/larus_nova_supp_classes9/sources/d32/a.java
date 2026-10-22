package d32;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.api.commentcontrol.utils.CommentControlSwitchHelper;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements Consumer {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final void accept(Object r6) {
        Response r7 = (Response) r6;
        if (r7 == null) goto L17;
        com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.a r8 = (com.bytedance.android.livesdk.interactivity.api.commentcontrol.model.a) ((BaseResponse) r7).data;
        if (r8 != null) goto L7;
        return;
    L7:
        if (CommentControlSwitchHelper.b() != 0) goto L12;
        CommentControlSwitchHelper.BaseDisplayText r0 = CommentControlSwitchHelper.c;
        if (r0 == null) goto L19;
        r0.updateBaseDisplayText(r8);
        return;
    L19:
        return;
    L12:
        if (CommentControlSwitchHelper.b() != 1) goto L21;
        CommentControlSwitchHelper.AdvancedDisplayText r1 = CommentControlSwitchHelper.d;
        if (r1 == null) goto L22;
        r1.updateAdvancedDisplayText(r8);
        return;
    L22:
        return;
    L21:
        return;
    }
}
