package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.data.activityemoji.EffectiveActivityEmojiGroup;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m<T> implements Comparator {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r4, Object r5) {
        return (((EffectiveActivityEmojiGroup) r4).getStartTime() > ((EffectiveActivityEmojiGroup) r5).getStartTime() ? 1 : (((EffectiveActivityEmojiGroup) r4).getStartTime() == ((EffectiveActivityEmojiGroup) r5).getStartTime() ? 0 : -1));
    }
}
