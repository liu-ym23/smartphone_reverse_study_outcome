package com.bytedance.android.live.liveinteract.videotalk.emoji;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/emoji/DynamicEmojiDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DynamicEmojiDiffCallback extends DiffUtil.Callback {
    public final List<? extends TalkRoomBaseDynamicEmoji> a;
    public final List<? extends TalkRoomBaseDynamicEmoji> b;

    public final int getNewListSize() {
        return this.b.size();
    }

    public final int getOldListSize() {
        List<? extends TalkRoomBaseDynamicEmoji> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public DynamicEmojiDiffCallback(List<? extends TalkRoomBaseDynamicEmoji> r2, List<? extends TalkRoomBaseDynamicEmoji> r3) {
        Intrinsics.checkNotNullParameter(r3, "newDatas");
        this.a = r2;
        this.b = r3;
    }

    public final boolean areContentsTheSame(int r5, int r6) {
        List<? extends TalkRoomBaseDynamicEmoji> r0 = this.a;
        if (r0 == null) goto L5;
        TalkRoomBaseDynamicEmoji r7 = (TalkRoomBaseDynamicEmoji) ListProtector.get(r0, r5);
    L6:
        TalkRoomBaseDynamicEmoji r8 = (TalkRoomBaseDynamicEmoji) ListProtector.get(this.b, r6);
        if ((r7 instanceof com.bytedance.android.live.liveinteract.videotalk.emoji.model.q) == false) goto L12;
        if ((r8 instanceof com.bytedance.android.live.liveinteract.videotalk.emoji.model.q) == false) goto L12;
        return true;
    L12:
        if (r8 == null) goto L29;
        if (r7 == null) goto L29;
        if ((r7 instanceof com.bytedance.android.live.liveinteract.videotalk.emoji.model.q) == false) goto L18;
    L28:
        return false;
    L18:
        if ((r8 instanceof com.bytedance.android.live.liveinteract.videotalk.emoji.model.q) == true) goto L28;
        if (Intrinsics.areEqual(r7.emojiName, r8.emojiName) == false) goto L26;
        py.k r9 = r7.emojiImage();
        if (r9 == null) goto L26;
        if (r9.equalsOnlyUri(r8.emojiImage()) != true) goto L26;
        return true;
    L26:
        return false;
    L29:
        if (r8 == r7) goto L34;
        return false;
    L34:
        return true;
    L5:
        r7 = null;
        goto L6
    }

    public final boolean areItemsTheSame(int r6, int r7) {
        List<? extends TalkRoomBaseDynamicEmoji> r0 = this.a;
        if (r0 == null) goto L5;
        TalkRoomBaseDynamicEmoji r8 = (TalkRoomBaseDynamicEmoji) ListProtector.get(r0, r6);
    L6:
        TalkRoomBaseDynamicEmoji r9 = (TalkRoomBaseDynamicEmoji) ListProtector.get(this.b, r7);
        if (r9 == null) goto L21;
        if (r8 == null) goto L21;
        if (r8.type == r9.type) goto L14;
        return false;
    L14:
        if ((r8 instanceof com.bytedance.android.live.liveinteract.videotalk.emoji.model.q) == false) goto L16;
    L20:
        return true;
    L16:
        if ((r9 instanceof com.bytedance.android.live.liveinteract.videotalk.emoji.model.q) == true) goto L20;
        if (r8.emojiId == r9.emojiId) goto L20;
        return false;
    L21:
        if (r9 == r8) goto L25;
        return false;
    L25:
        return true;
    L5:
        r8 = null;
        goto L6
    }
}
