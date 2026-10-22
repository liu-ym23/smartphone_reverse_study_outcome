package com.larus.uaigc.music.applet;

import com.larus.bmhome.chat.ChatParam;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l implements vp8.j {
    public final /* synthetic */ MusicAppletInstructionEditorComponent a;

    public final void a() {
    }

    public final ChatParam c() {
        return null;
    }

    public final void A1() {
        MusicAppletInstructionEditorComponent r0 = this.a;
        int r1 = MusicAppletInstructionEditorComponent.w;
        u1 r2 = (u1) r0.p.getValue();
        if (r2 == null) goto L6;
        r2.Ub();
        return;
    }

    public final List<com.larus.bmhome.actionbar.model.u> b() {
        com.larus.bmhome.view.actionbar.edit.b r0 = this.a.s;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    public final de8.c f1() {
        return s1a.d.a(this.a).a(de8.c.class);
    }

    public l(MusicAppletInstructionEditorComponent r1) {
        this.a = r1;
    }
}
