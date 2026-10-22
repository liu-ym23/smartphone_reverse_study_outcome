package com.bytedance.android.livesdk.interactivity.roomintro.v2;

import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Comparator<T> {
    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        return ComparisonsKt.compareValues(Long.valueOf(((RoomIntroLabel) r3).getShowOrder()), Long.valueOf(((RoomIntroLabel) r4).getShowOrder()));
    }
}
