package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.message.model.f6;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j0 extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a implements vlc.l {
    public final CompositeDisposable b;
    public boolean c;

    public static final class a {
    }

    static {
    }

    public j0() {
        this.b = new CompositeDisposable();
        this.c = true;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        com.bytedance.android.livesdk.chatroom.t r0 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L7;
        r1.c(new VoiceAnchorGuideInfoHandler$attachMessage$1(this));
    L7:
        Disposable r2 = xs2.b.a().b(dh0.a.class).subscribe(new k0(this));
        if (r2 == null) goto L11;
        this.b.add(r2);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        com.bytedance.android.livesdk.chatroom.t r0 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L7;
        r1.c(new VoiceAnchorGuideInfoHandler$detachMessage$1(this));
    L7:
        this.b.clear();
    }

    public final boolean d(ILinkMicGuideMessageBridge r6) {
        if (vm2.c.i() == true) goto L5;
        return true;
    L5:
        List r0 = (List) a().f().getValue();
        if (r0 == null) goto L8;
        int r1 = r0.size();
    L10:
        if (r1 < r6.getAudienceLimit()) goto L14;
        ALogger.e("VoiceAnchorGuideInfoHandler", "intercept guide since online count hits limit");
        return true;
    L14:
        if (this.c == true) goto L17;
        ALogger.e("VoiceAnchorGuideInfoHandler", "intercept guide since message too often");
        return true;
    L17:
        com.bytedance.live.datacontext.m r2 = com.bytedance.android.live.liveinteract.api.utils.m.d().I1();
        if (r2 != null) goto L20;
    L23:
        Integer r3 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r3 != null) goto L27;
    L28:
        Integer r4 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r4 != null) goto L32;
    L34:
        boolean r5 = false;
    L36:
        if (r5 == false) goto L39;
        ALogger.e("VoiceAnchorGuideInfoHandler", "intercept guide since guest is not idle");
        return true;
    L39:
        f6 r7 = r6.getAnchorGuideInfo();
        if (r7 == null) goto L42;
        List r8 = r7.getInfoItems();
    L43:
        if (r8 == null) goto L52;
        f6 r9 = r6.getAnchorGuideInfo();
        if (r9 == null) goto L52;
        List r10 = r9.getInfoItems();
        if (r10 == null) goto L52;
        if (r10.size() != 3) goto L52;
        return false;
    L52:
        ALogger.e("VoiceAnchorGuideInfoHandler", "intercept guide since message not complete");
        return true;
    L42:
        r8 = null;
        goto L43
    L32:
        if (r4.intValue() != 2) goto L34;
    L35:
        r5 = true;
        goto L36
    L27:
        if (r3.intValue() == 1) goto L35;
    L20:
        if (((Boolean) r2.getValue()).booleanValue() != true) goto L23;
        ALogger.e("VoiceAnchorGuideInfoHandler", "intercept guide since in ktv mode");
        return true;
    L8:
        r1 = 0;
        goto L10
    }

    public final void onMessage(tlc.d r6) {
        if ((r6 instanceof ILinkMicGuideMessageBridge) == false) goto L17;
        ILinkMicGuideMessageBridge r7 = (ILinkMicGuideMessageBridge) r6;
        if (r7.getGuidelineType() != 0) goto L18;
        gh0.b.a("AudioAnchorGuide", "receive ILinkMicGuideMessageBridge", false);
        gh0.b.a("AudioAnchorGuide", "handleAudioGuideLineMsg, intercept = " + d(r7) + ", audienceLimit = " + r7.getAudienceLimit() + ", anchorGuideInfo = " + r7.getAnchorGuideInfo(), false);
        if (d(r7) == true) goto L20;
        int r0 = r7.getAudienceLimit();
        f6 r8 = r7.getAnchorGuideInfo();
        if (r8 != null) goto L12;
        return;
    L12:
        if (je0.d.D() == false) goto L14;
        int r1 = vm2.c.a().anchorRateLimit;
    L15:
        this.c = false;
        this.b.add(Observable.timer(r1, TimeUnit.SECONDS).subscribe(new l0(this, r1)));
        a().k1(new ch0.l(r0, r8));
        return;
    L14:
        r1 = vm2.c.a().audienceRateLimit;
        goto L15
    L20:
        return;
    L18:
        return;
    }
}
