package u82;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.chatroom.interact.model.m0;
import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaLinkContext;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaAnchorLinkUserListContract$View;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ h a;

    public f(h r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        BaseResponse r5 = (BaseResponse) r4;
        Intrinsics.checkNotNullParameter(r5, "rivalsListsDataResponse");
        MediaAnchorLinkUserListContract$View r0 = (MediaAnchorLinkUserListContract$View) this.a.c;
        if (r0 == null) goto L21;
        m0 r1 = (m0) r5.data;
        com.bytedance.android.live.anchorlink.network.model.c r2 = r5.extra;
        r0.Z90(r1);
        com.bytedance.android.live.anchorlink.network.model.c r6 = r5.extra;
        w82.a r3 = null;
        if (r6 == null) goto L11;
        com.bytedance.android.live.anchorlink.network.model.b r7 = r6.a();
        if (r7 == null) goto L11;
        Map r8 = r7.a();
        if (r8 == null) goto L11;
        String r9 = (String) r8.get(1L);
    L12:
        MediaLinkContext r10 = MediaLinkContext.Companion.getContext();
        if (r10 == null) goto L17;
        com.bytedance.live.datacontext.i<w82.a> r11 = r10.getLogParams();
        if (r11 == null) goto L17;
        r3 = (w82.a) r11.getValue();
    L17:
        if (r9 == null) goto L22;
        if (r3 == null) goto L23;
        r3.a = r9;
        return;
    L23:
        return;
    L22:
        return;
    L11:
        r9 = null;
        goto L12
    }
}
