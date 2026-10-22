package com.larus.uaigc.music;

import android.content.Context;
import android.widget.FrameLayout;
import com.google.gson.Gson;
import com.larus.bmhome.chat.api.IMusicService;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.uaigc.music.widget.LyricsToSongTemplatePlayerView;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/uaigc/music/MusicService;", "Lcom/larus/bmhome/chat/api/IMusicService;", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "createLyricsToSongTemplatePlayerView", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "bindSonTemplatePlayerData", "", "musicPlayerView", "musicData", "", "position", "", "currentPage", "showFrom", "rebind", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MusicService implements IMusicService {
    public final Gson a;

    public MusicService() {
        this.a = new Gson();
    }

    public final LyricsToSongTemplatePlayerView a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        LyricsToSongTemplatePlayerView r0 = new LyricsToSongTemplatePlayerView(r5, null, 6, 0);
        r0.d();
        return r0;
    }

    public final void b(FrameLayout r8, String r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "musicPlayerView");
        Intrinsics.checkNotNullParameter(r9, "musicData");
        Intrinsics.checkNotNullParameter(r11, "currentPage");
        Intrinsics.checkNotNullParameter("click_creation_list", "showFrom");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.constructor-impl((MusicCreationContent) this.a.fromJson(r9, MusicCreationContent.class));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r12) == false) goto L10;
        r12 = null;
    L10:
        LyricsToSongTemplatePlayerView r1 = (LyricsToSongTemplatePlayerView) r8;
        LyricsToSongTemplatePlayerView.c(r1, (MusicCreationContent) r12, r10, r11, "click_creation_list", null, 16);
        return;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
