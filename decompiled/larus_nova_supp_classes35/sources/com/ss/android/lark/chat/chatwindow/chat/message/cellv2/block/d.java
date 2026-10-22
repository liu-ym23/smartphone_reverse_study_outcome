package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.text.TextUtils;
import com.larksuite.framework.ui.BasePopupWindow;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.chat.chatwindow.chat.model.preload.v2.AudioResourceLoadTask;
import com.ss.android.lark.chatbase.view.LarkPlayModeTip;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.message.MessageHitPoint;
import com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.AudioWaveBar;
import com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.PlayControlBar;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements PlayControlBar.a {
    public final /* synthetic */ AudioContentVO a;
    public final /* synthetic */ AudioContentBlock b;
    public final /* synthetic */ n2b.d c;
    public final /* synthetic */ y6b.a<AudioContentVO> d;

    public final void a() {
        if (TextUtils.isEmpty(this.a.t) == true) goto L10;
        AudioContentBlock.h(this.b, this.c.a.n, true);
        AudioWaveBar r0 = this.b.i;
        if (r0 == null) goto L7;
        r0.setWaveBytes(this.a.v);
    L7:
        AudioWaveBar r1 = this.b.i;
        if (r1 == null) goto L10;
        r1.setDurationText(this.c.a.n.getDurationText());
    L10:
        com.ss.android.lark.audio.opus.e.d().g();
        MessageHitPoint.a.a().sendEvent("audio_play_drag", null);
    }

    public final void b() {
        boolean r1 = false;
        if (TextUtils.isEmpty(this.a.t) == true) goto L5;
        AudioContentBlock.h(this.b, this.c.a.n, false);
    L5:
        this.a.u = (int) this.c.a.n.getProgress();
        float r0 = this.a.u / 100.0f;
        if (com.ss.android.lark.audio.opus.e.d().f(this.a.t) == false) goto L14;
        com.ss.android.lark.audio.opus.e.d().j(r0);
        if (r0 != 1.0f) goto L10;
        r1 = true;
    L10:
        if (r1 == false) goto L12;
        com.ss.android.lark.audio.opus.e.d().m(true);
        c3b.a.a();
        return;
    L12:
        com.ss.android.lark.audio.opus.e.d().i();
        return;
    L14:
        if (r0 != 1.0f) goto L16;
        r1 = true;
    L16:
        if (r1 == false) goto L18;
        this.c.a.n.setProgress(0.0f);
        return;
    L18:
        onPlay();
    }

    public final void onPlay() {
        c3b.a.InterfaceC0015a r0 = c3b.a.a;
        if (c3b.a.b(this.b.getContext()) == true) goto L5;
        return;
    L5:
        boolean r1 = e1c.d.m;
        e1c.d.b.a.n(AudioResourceLoadTask.class, this.d.getId());
        String r2 = tob.a.a;
        tob.a.e(this.a.g(), this.d.getId(), this.a.h());
        Log.d("AudioContentBlock", "onPlay:" + this.a.t);
        if (TextUtils.isEmpty(this.a.t) == false) goto L22;
        this.c.a.n.stopPlay();
        AudioContentBlock r3 = this.b;
        y6b.a<AudioContentVO> r4 = this.d;
        r3.getClass();
        AudioContentVO r5 = r4.b();
        Log.d("AudioContentBlock", "prepareAudio");
        Log.i("AudioContentBlock", "click audio msg, id:" + r4.getId());
        v4b.d r6 = r3.e;
        if (r6 == null) goto L12;
        boolean r7 = true;
        if (r6.h != true) goto L12;
    L13:
        if (r7 == true) goto L28;
        mya.c r8 = r3.c.j5().b(mya.c.class);
        if (r8 == null) goto L18;
        r5.h();
        r4.getId();
        r8.r();
        return;
    L18:
        b3b.f r9 = r3.k;
        if (r9 == null) goto L27;
        r9.z0(r5.h(), r4.getId());
        return;
    L27:
        return;
    L28:
        return;
    L12:
        r7 = false;
        goto L13
    L22:
        Lazy<LarkPlayModeTip> r10 = LarkPlayModeTip.a;
        LarkPlayModeTip.a.b(this.b.getContext());
        PlayControlBar r11 = this.c.a.n;
        com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a.a r12 = r11.g;
        if (r12 == null) goto L29;
        r12.a(r11);
        return;
    }

    public final void onPause() {
        com.ss.android.lark.audio.opus.e.d().g();
        c3b.a.a();
    }

    public final void onProgressChanged(int r4) {
        AudioContentBlock r0 = this.b;
        AudioWaveBar r1 = r0.i;
        BasePopupWindow r2 = r0.j;
        if (r2 == null) goto L7;
        boolean r3 = true;
        if (r2.isShowing() != true) goto L7;
    L8:
        if (r3 == false) goto L11;
        if (r1 == null) goto L11;
        r1.setProgress(r4);
        r1.setDurationText(this.c.a.n.getDurationText());
    L11:
        this.a.u = r4;
        return;
    L7:
        r3 = false;
        goto L8
    }

    public d(AudioContentVO r1, AudioContentBlock r2, n2b.d r3, y6b.a<AudioContentVO> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
