package com.bytedance.android.live.room.share.jsbridge;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareParams;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m extends LiveWebShareCallback {
    public final /* synthetic */ LiveWebShareCallback a;
    public final /* synthetic */ Room b;
    public final /* synthetic */ LiveWebShareParams c;
    public final /* synthetic */ HashMap d;
    public final /* synthetic */ k e;

    public final void onDialogDismiss() {
        this.a.onDialogDismiss();
    }

    public final void onPreShare() {
        this.a.onPreShare();
    }

    public final void onRefresh() {
        y6.d r0 = this.e.a;
        if (r0 == null) goto L6;
        r0.fZ();
        return;
    }

    public final void onChannelShare(String r2) {
        this.a.onChannelShare(r2);
    }

    public final void onContactSelect(boolean r2) {
        this.a.onContactSelect(r2);
    }

    public final void onFail(Throwable r2) {
        this.a.onFail(r2);
        ALogger.e("SharePanelMethod", r2);
    }

    public final void onSuccess(String r12, String r13) {
        this.a.onSuccess(r12, r13);
        if (r12 == "chat_merge") goto L10;
        k r0 = this.e;
        Room r1 = this.b;
        if (r1 != null) goto L7;
        String r2 = "";
    L8:
        k.j(r0, 0, r12, r2);
        k.k(this.e, this.b, r12, r13, "URL", this.c);
        k.l(this.e, r12, r13, this.d);
        return;
    L7:
        r2 = r1.getLabels();
        goto L8
    }

    public final void onSuccessWithExtra(String r10, String r12, Map<String, List<String>> r13) {
        this.a.onSuccessWithExtra(r10, r12, r13);
        if (com.bytedance.android.live.room.share.util.d.a(r10, r13) == false) goto L5;
        return;
    L5:
        k r14 = this.e;
        Room r0 = this.b;
        if (r0 != null) goto L8;
        String r1 = "";
    L9:
        k.j(r14, 0, r10, r1);
        k.k(this.e, this.b, r10, r12, "URL", this.c);
        return;
    L8:
        r1 = r0.getLabels();
        goto L9
    }

    public m(k r1, LiveWebShareCallback r2, Room r3, LiveWebShareParams r4, HashMap r5) {
        this.e = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
