package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/aiinterpretation/HeadsetPromptSource;", "", "<init>", "(Ljava/lang/String;I)V", "AI_ENABLED", "AUDIO_SAVE_CHANGED", "AUDIO_ROUTE_CHANGED", "PLAYBACK_VOLUME_CHANGED", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum HeadsetPromptSource extends Enum<HeadsetPromptSource> {
    public static final HeadsetPromptSource AI_ENABLED = null;
    public static final HeadsetPromptSource AUDIO_ROUTE_CHANGED = null;
    public static final HeadsetPromptSource AUDIO_SAVE_CHANGED = null;
    public static final HeadsetPromptSource PLAYBACK_VOLUME_CHANGED = null;
    public static final /* synthetic */ HeadsetPromptSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<HeadsetPromptSource> getEntries() {
        return b;
    }

    static {
        HeadsetPromptSource r0 = new HeadsetPromptSource("AI_ENABLED", 0);
        AI_ENABLED = r0;
        HeadsetPromptSource r1 = new HeadsetPromptSource("AUDIO_SAVE_CHANGED", 1);
        AUDIO_SAVE_CHANGED = r1;
        HeadsetPromptSource r3 = new HeadsetPromptSource("AUDIO_ROUTE_CHANGED", 2);
        AUDIO_ROUTE_CHANGED = r3;
        HeadsetPromptSource r5 = new HeadsetPromptSource("PLAYBACK_VOLUME_CHANGED", 3);
        PLAYBACK_VOLUME_CHANGED = r5;
        HeadsetPromptSource[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static HeadsetPromptSource[] values() {
        return (HeadsetPromptSource[]) a.clone();
    }

    public static HeadsetPromptSource valueOf(String r1) {
        return (HeadsetPromptSource) r27.a.a(HeadsetPromptSource.class, r1);
    }

    public HeadsetPromptSource(String r1, int r2) {
        super(r1, r2);
    }
}
