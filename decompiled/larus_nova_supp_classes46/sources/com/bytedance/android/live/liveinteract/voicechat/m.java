package com.bytedance.android.live.liveinteract.voicechat;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.multilink.external.api.core.type.AckFromSource;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.interact.r1;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ VoiceChatMuteManager a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ long e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ MediaOperation.a h;

    public m(VoiceChatMuteManager r1, String r2, int r3, String r4, long r5, boolean r7, boolean r8, MediaOperation.a r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }

    public final void accept(Object r8) {
        com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
        if (Intrinsics.areEqual(jc1.k.n(IMiddlewareUserService.class).user().n(), this.b) == true) goto L5;
    L7:
        VoiceChatMuteManager r0 = this.a;
        r0.a = false;
        dn0.c r1 = (dn0.c) r0.v.getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
        if (r1 == null) goto L10;
        r1.Z(this.b, ((r1) r9.data).getAckMessage(), AckFromSource.VOICE_CHAT_SILENCE_API);
    L10:
        String r2 = this.b;
        String r3 = this.d;
        r1 r4 = (r1) r9.data;
        String r5 = null;
        if (r4 == null) goto L15;
        List r6 = r4.getLinkedUsers();
        if (r6 == null) goto L15;
        String r7 = je0.d.g0(r6);
    L16:
        r1 r10 = (r1) r9.data;
        if (r10 == null) goto L21;
        Map r11 = r10.getLinkerContentMap();
        if (r11 == null) goto L21;
        r5 = r11.toString();
    L21:
        x.w0(r2, r3, r7, r5);
        if (Intrinsics.areEqual(this.b, je0.d.b0()) == false) goto L24;
        this.a.s.put("data_self_is_silenced", Boolean.TRUE);
    L24:
        InteractLinkFullLinkMonitor.X(this.b, System.currentTimeMillis() - this.e, r9.logId);
        r1 r12 = (r1) r9.data;
        if (r12 == null) goto L30;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r13 = r12.getLinkedUsers();
        if (r13 == null) goto L30;
        this.a.r.S4(r13, ((r1) r9.data).getClientUiInfo(), ((r1) r9.data).getVersion(), "silence " + this.d);
    L30:
        if (this.f == false) goto L33;
        return;
    L33:
        if (this.g == false) goto L35;
        this.a.t.G4(true, this.d);
        this.a.f.postValue(Boolean.TRUE);
    L35:
        Iterator<VoiceChatMuteManager.a> r14 = this.a.d.iterator();
    L37:
        if (r14.hasNext() == false) goto L39;
        r14.next().V(this.b);
        goto L37
    L39:
        MediaOperation.a r15 = this.h;
        if (r15 == null) goto L44;
        r15.onSuccess();
        return;
    L44:
        return;
    L15:
        r7 = null;
        goto L16
    L5:
        if (this.c != 0) goto L7;
        com.bytedance.android.live.liveinteract.linksecurity.c.o(com.bytedance.android.live.liveinteract.linksecurity.c.g);
        goto L7
    }
}
