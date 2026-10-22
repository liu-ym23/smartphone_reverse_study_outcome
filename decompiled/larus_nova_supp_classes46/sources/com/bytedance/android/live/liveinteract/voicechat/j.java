package com.bytedance.android.live.liveinteract.voicechat;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.livesdk.chatroom.model.interact.c2;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ VoiceChatMuteManager a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;

    public j(VoiceChatMuteManager r1, String r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r9) {
        com.bytedance.android.live.network.response.e r10 = (com.bytedance.android.live.network.response.e) r9;
        VoiceChatMuteManager r0 = this.a;
        r0.b = false;
        InteractLinkFullLinkMonitor.p0(this.b, System.currentTimeMillis() - r0.h, r10.logId);
        String r1 = this.b;
        c2 r2 = (c2) r10.data;
        String r3 = null;
        if (r2 == null) goto L7;
        List r4 = r2.getLinkedUsers();
        if (r4 == null) goto L7;
        String r5 = je0.d.g0(r4);
    L8:
        c2 r6 = (c2) r10.data;
        if (r6 == null) goto L13;
        Map r7 = r6.getLinkerContentMap();
        if (r7 == null) goto L13;
        r3 = r7.toString();
    L13:
        x.D0(r1, "ktv_forceUnSilence", r5, r3);
        this.a.t.G4(false, "force UnSilence");
        MutableLiveData<Boolean> r8 = this.a.f;
        Boolean r11 = Boolean.FALSE;
        r8.postValue(r11);
        this.a.s.put("data_self_is_silenced", r11);
        c2 r12 = (c2) r10.data;
        if (r12 == null) goto L18;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r13 = r12.getLinkedUsers();
        if (r13 == null) goto L18;
        this.a.r.S4(r13, ((c2) r10.data).getClientUiInfo(), ((c2) r10.data).getVersion(), "ktv forceUnSilence");
    L18:
        ALogger.i("voice_chat", "forceUnSilence success");
        if (this.c == false) goto L22;
        f2.b(2131919326, 0);
        return;
    L22:
        return;
    L7:
        r5 = null;
        goto L8
    }
}
