package com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim;

import android.content.Context;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.SeatAnimManager;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.p;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.b;
import com.bytedance.android.live.liveinteract.voicechat.emoji.sound.EmojiSoundManager;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdk.message.model.za;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class SeatAnimEngineWrapper implements l {
    public SeatAnimManager a;
    public EmojiSoundManager b;
    public d c;
    public final CompositeDisposable d;
    public final DataCenter e;
    public final Context f;
    public final com.bytedance.android.live.pushstream.d g;

    public final void b() {
        this.d.clear();
        SeatAnimManager r0 = this.a;
        if (r0 == null) goto L5;
        ((LinkedHashMap) r0.a).clear();
    L5:
        d r1 = this.c;
        if (r1 == null) goto L8;
        r1.removeMessageListener(this);
    L8:
        EmojiSoundManager r2 = this.b;
        if (r2 == null) goto L12;
        r2.c();
        return;
    }

    public final void a() {
        Boolean r0 = m.i().isAnchor();
        if (r0 == null) goto L5;
        boolean r1 = r0.booleanValue();
    L6:
        this.a = new SeatAnimManager(SeatAnimEngineWrapper$attach$1.INSTANCE);
        this.b = new EmojiSoundManager(this.f, r1, this.g);
        d r2 = (d) this.e.get("data_message_manager");
        this.c = r2;
        if (r2 == null) goto L9;
        r2.addMessageListener(MessageType.LINK_MIC_DYNAMIC_EMOJI_MESSAGE.getKey(), this);
    L9:
        IKtvService r3 = k.f(IKtvService.class);
        if (r3 == null) goto L16;
        com.bytedance.live.datacontext.k r4 = r3.ktvComponentSingerChangedEvent();
        if (r4 == null) goto L16;
        Disposable r5 = r4.onEvent().subscribe(new a(this));
        if (r5 == null) goto L16;
        RxUtilKt.c(r5, this.d);
    L16:
        IKtvService r6 = k.f(IKtvService.class);
        if (r6 == null) goto L24;
        za r7 = r6.ktvCurrentSingerOrderInfo();
        if (r7 == null) goto L25;
        SeatAnimManager r8 = this.a;
        if (r8 == null) goto L26;
        r8.d(r7);
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void onMessage(tlc.d r3) {
        if ((r3 instanceof w8) == false) goto L29;
        w8 r4 = (w8) r3;
        if (r4.isThanksInteractEmoji() == false) goto L10;
        b.r0.getClass();
        if (b.C0101b.b() == true) goto L10;
        return;
    L10:
        if (r4.isFriendTreeInteractEmoji() == false) goto L13;
        return;
    L13:
        if (r4.isInteractEmoji() == false) goto L16;
        this.e.put("cmd_show_dynamic_emoji_in_comment", r4);
        return;
    L16:
        if (r4.isSoundEmoji() == false) goto L20;
        EmojiSoundManager r0 = this.b;
        if (r0 == null) goto L20;
        r0.d(r4);
    L20:
        b.r0.getClass();
        if (b.C0101b.b() == true) goto L23;
    L25:
        SeatAnimManager r1 = this.a;
        if (r1 == null) goto L31;
        int r2 = p.a;
        r1.b(p.a(ag1.b.a(r4)));
        return;
    L31:
        return;
    L23:
        if (r4.isThanksInteractEmoji() == false) goto L25;
        this.e.put("cmd_show_dynamic_emoji_in_comment", r4);
        goto L25
    }

    public SeatAnimEngineWrapper(int r1, DataCenter r2, Context r3, com.bytedance.android.live.pushstream.d r4) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.d = new CompositeDisposable();
    }
}
