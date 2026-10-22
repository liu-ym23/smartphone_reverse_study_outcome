package com.bytedance.android.live.emoji.api;

import android.graphics.drawable.Drawable;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&J\u0010\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&J\b\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/emoji/api/IAwemeEmojiProxy;", "Lcom/bytedance/android/live/base/IService;", "getRealDrawable", "Landroid/graphics/drawable/Drawable;", "emojiText", "", "getRecommendEmojiList", "", "Lcom/bytedance/android/livehostapi/business/model/emoji/BaseEmoji;", "loadAllBaseEmoji", "preloadOnlineEmoji", "", "updateRecentEmoji", "liveemoji-api_release"}, k = 1, mv = {1, 4, 3})
public interface IAwemeEmojiProxy extends IService {
    Drawable getRealDrawable(String r1);

    List<BaseEmoji> getRecommendEmojiList();

    List<BaseEmoji> loadAllBaseEmoji();

    void preloadOnlineEmoji();

    void updateRecentEmoji(String r1);
}
