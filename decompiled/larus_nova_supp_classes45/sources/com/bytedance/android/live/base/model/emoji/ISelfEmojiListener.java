package com.bytedance.android.live.base.model.emoji;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface ISelfEmojiListener {
    void onAddSelfEmojis(List<SelfEmoji> r1, boolean r2, String r3);

    void onDeleteSelfEmojis(List<SelfEmoji> r1, boolean r2, String r3);

    void onGetSelfEmojis(List<SelfEmoji> r1);
}
