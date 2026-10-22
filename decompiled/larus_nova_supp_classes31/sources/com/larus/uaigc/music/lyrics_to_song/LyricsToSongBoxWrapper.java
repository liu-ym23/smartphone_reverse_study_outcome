package com.larus.uaigc.music.lyrics_to_song;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.MusicCreationContentList;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.uaigc.music.ILyricsToSongBoxWrapper;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016JB\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/uaigc/music/lyrics_to_song/LyricsToSongBoxWrapper;", "Lcom/larus/uaigc/music/ILyricsToSongBoxWrapper;", "<init>", "()V", "view", "Lcom/larus/uaigc/music/lyrics_to_song/LyricsToSongBox;", "getBoxView", "Landroid/view/View;", "context", "Landroid/content/Context;", "bindDataForCell", "", "data", "Lcom/larus/im/bean/message/Message;", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", SlashMentionConfig.MENTION_CONTENT_CONVERSATION, "Lcom/larus/im/bean/conversation/Conversation;", "isShareMode", "", "musicCreationContent", "Lcom/larus/im/bean/message/block/MusicCreationContentList;", "hostFragment", "Landroidx/fragment/app/Fragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class LyricsToSongBoxWrapper implements ILyricsToSongBoxWrapper {
    public f a;

    public LyricsToSongBoxWrapper() {
    }

    @Override // com.larus.uaigc.music.ILyricsToSongBoxWrapper
    public final f b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        f r0 = this.a;
        if (r0 != null) goto L7;
        f r1 = new f(r2);
        this.a = r1;
        return r1;
    L7:
        return r0;
    }

    @Override // com.larus.uaigc.music.ILyricsToSongBoxWrapper
    public final void a(Message r8, q0 r9, wc9.e r10, boolean r11, MusicCreationContentList r12, Fragment r13) {
        f r0 = this.a;
        if (r0 == null) goto L25;
        if (r13 != null) goto L21;
        Object r14 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        if (r9 == null) goto L11;
        Function0 r2 = r9.getHostFragment();     // Catch: Throwable -> L14
        if (r2 == null) goto L11;
        Fragment r3 = (Fragment) r2.invoke();     // Catch: Throwable -> L14
    L12:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r4) == true) goto L20;
        r14 = r4;
    L20:
        r13 = (Fragment) r14;
    L11:
        r3 = null;
    L14:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L21:
        r0.n(r8, r9, r10, r11, r12, r13);
        return;
    }
}
