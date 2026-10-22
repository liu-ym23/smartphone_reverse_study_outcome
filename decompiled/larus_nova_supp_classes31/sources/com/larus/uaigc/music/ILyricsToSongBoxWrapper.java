package com.larus.uaigc.music;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.MusicCreationContentList;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.uaigc.music.lyrics_to_song.f;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&JH\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&¨\u0006\u0014"}, d2 = {"Lcom/larus/uaigc/music/ILyricsToSongBoxWrapper;", "", "getBoxView", "Landroid/view/View;", "context", "Landroid/content/Context;", "bindDataForCell", "", "data", "Lcom/larus/im/bean/message/Message;", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", SlashMentionConfig.MENTION_CONTENT_CONVERSATION, "Lcom/larus/im/bean/conversation/Conversation;", "isShareMode", "", "musicCreationContent", "Lcom/larus/im/bean/message/block/MusicCreationContentList;", "hostFragment", "Landroidx/fragment/app/Fragment;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface ILyricsToSongBoxWrapper {
    void a(Message r1, q0 r2, e r3, boolean r4, MusicCreationContentList r5, Fragment r6);

    f b(Context r1);
}
