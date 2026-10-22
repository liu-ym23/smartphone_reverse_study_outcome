package com.bytedance.android.live.liveinteract.voicechat;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.livesdk.chatroom.model.interact.c2;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ VoiceChatMuteManager a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ MediaOperation.a f;

    public p(VoiceChatMuteManager r1, String r2, String r3, boolean r4, boolean r5, MediaOperation.a r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void accept(Object r9) {
        com.bytedance.android.live.network.response.e r10 = (com.bytedance.android.live.network.response.e) r9;
        VoiceChatMuteManager r0 = this.a;
        r0.b = false;
        InteractLinkFullLinkMonitor.p0(this.b, System.currentTimeMillis() - r0.h, r10.logId);
        String r1 = this.b;
        String r2 = this.c;
        c2 r3 = (c2) r10.data;
        String r4 = null;
        if (r3 == null) goto L7;
        List r5 = r3.getLinkedUsers();
        if (r5 == null) goto L7;
        String r6 = je0.d.g0(r5);
    L8:
        c2 r7 = (c2) r10.data;
        if (r7 == null) goto L13;
        Map r8 = r7.getLinkerContentMap();
        if (r8 == null) goto L13;
        r4 = r8.toString();
    L13:
        x.D0(r1, r2, r6, r4);
        if (Intrinsics.areEqual(this.b, je0.d.b0()) == false) goto L16;
        this.a.s.put("data_self_is_silenced", Boolean.FALSE);
    L16:
        c2 r11 = (c2) r10.data;
        if (r11 == null) goto L22;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r12 = r11.getLinkedUsers();
        if (r12 == null) goto L22;
        this.a.r.S4(r12, ((c2) r10.data).getClientUiInfo(), ((c2) r10.data).getVersion(), "unSilence " + this.c);
    L22:
        if (this.d == false) goto L25;
        return;
    L25:
        if (this.e == false) goto L27;
        this.a.t.G4(false, this.c);
        this.a.f.postValue(Boolean.FALSE);
    L27:
        Iterator<VoiceChatMuteManager.a> r13 = this.a.d.iterator();
    L29:
        if (r13.hasNext() == false) goto L31;
        r13.next().C(this.b);
        goto L29
    L31:
        MediaOperation.a r14 = this.f;
        if (r14 == null) goto L36;
        r14.onSuccess();
        return;
    L36:
        return;
    L7:
        r6 = null;
        goto L8
    }
}
