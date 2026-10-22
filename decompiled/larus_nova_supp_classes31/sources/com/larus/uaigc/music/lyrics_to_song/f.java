package com.larus.uaigc.music.lyrics_to_song;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.music.widget.LyricsToSongCardView;
import com.larus.common_ui.widget.CircleProgressBarView;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.im.bean.message.block.MusicCreationContentList;
import com.larus.platform.service.e2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f extends com.larus.uaigc.music.lyrics_to_song.a {
    public final LyricsToSongCardView q;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "mContext");
        super(r4);
        LyricsToSongCardView r0 = new LyricsToSongCardView(r4);
        this.q = r0;
        addView(r0);
        if (e2.a.isPad() == false) goto L6;
        setMaxWidth(Math.min(getMaxWidth(), i5.y0(v19.c.b(2130971486, null, 2131167341))));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.uaigc.music.lyrics_to_song.a
    public final void n(Message r10, q0 r11, wc9.e r12, boolean r13, MusicCreationContentList r14, Fragment r15) {
        MusicCreationContent r16 = null;
        if (r10 == null) goto L10;
        IAIChatUgcAIGCService.Companion r0 = IAIChatUgcAIGCService.a;
        if (r11 == null) goto L7;
        q0.a r4 = r11.getProvider();
    L8:
        r0.Q(this, r10, r11, r4, true);
        goto L10
    L7:
        r4 = null;
    L10:
        if (r10 == null) goto L14;
        boolean r1 = true;
        if (com.larus.im.bean.message.a.k0(r10) != true) goto L14;
    L15:
        if (r1 == true) goto L17;
        int r2 = CircleProgressBarView.k;
        setPadding((int) CircleProgressBarView.a.a(this.q.getViewContext(), 10.0f), 0, 0, 0);
    L17:
        LyricsToSongCardView r3 = this.q;
        if (r11 == null) goto L20;
        q0.a r5 = r11.getProvider();
    L21:
        if (r14 == null) goto L25;
        Map r17 = r14.getContentMap();
        if (r17 == null) goto L25;
        r16 = (MusicCreationContent) r17.get("0");
    L25:
        MusicCreationContent r6 = r16;
        if (r11 == null) goto L33;
        Function0 r18 = r11.getHostFragment();
        if (r18 == null) goto L33;
        Fragment r19 = (Fragment) r18.invoke();
        if (r19 == null) goto L33;
        Fragment r7 = r19;
    L34:
        r3.i(r10, r5, r6, 0, "0", r7, new e(this));
        return;
    L33:
        r7 = r15;
        goto L34
    L20:
        r5 = null;
    L14:
        r1 = false;
        goto L15
    }
}
