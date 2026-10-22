package com.larus.voice_setting.voice.base;

import android.view.View;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.VoiceItemAdapter;
import com.larus.voice_setting.voice.o2;
import com.larus.voice_setting.voice.u2;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q0 implements u2 {
    public final /* synthetic */ PublicVoiceListFragment a;

    @Override // com.larus.voice_setting.voice.u2
    public final boolean a(o2 r1) {
        return false;
    }

    @Override // com.larus.voice_setting.voice.u2
    public final void c(o2 r1, View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
    }

    @Override // com.larus.voice_setting.voice.u2
    public final boolean d(o2 r1) {
        return false;
    }

    public q0(PublicVoiceListFragment r1) {
        this.a = r1;
    }

    @Override // com.larus.voice_setting.voice.u2
    public final void b(o2 r6, View r7) {
        Intrinsics.checkNotNullParameter(r7, "itemView");
        if (r6 != null) goto L5;
        return;
    L5:
        PublicVoiceListFragment r8 = this.a;
        int r0 = PublicVoiceListFragment.C;
        r8.getClass();
        SpeakerVoice r9 = r6.a;
        if (r9 == null) goto L32;
        VoiceItemAdapter r1 = r8.ia0();
        Object r2 = null;
        if (r1 == null) goto L22;
        List<o2> r3 = r1.a;
        if (r3 == null) goto L22;
        Iterator<T> r4 = r3.iterator();
    L14:
        if (r4.hasNext() == false) goto L21;
        Object r5 = r4.next();
        if (((o2) r5).b != 20) goto L18;
        boolean r10 = true;
    L19:
        if (r10 == false) goto L14;
        r2 = r5;
        goto L21
    L18:
        r10 = false;
    L21:
        r2 = (o2) r2;
    L22:
        if (r2 == null) goto L24;
        FLogger.a.i(r8.z, "[clickItem] selecting other item, voice: " + r9);
        return;
    L24:
        FLogger.a.i(r8.z, "voice clicked: " + r9);
        r8.ca0(r9);
        return;
    }
}
