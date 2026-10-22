package com.ss.android.lark.officesdk.minutes.api.recording.common.external_audio;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/external_audio/ExternalAudioSourceMode;", "", "<init>", "(Ljava/lang/String;I)V", "PCM_PULL", "PCM_PUSH", "ENCODED_PULL", "ENCODED_PUSH", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum ExternalAudioSourceMode extends Enum<ExternalAudioSourceMode> {
    public static final ExternalAudioSourceMode ENCODED_PULL = null;
    public static final ExternalAudioSourceMode ENCODED_PUSH = null;
    public static final ExternalAudioSourceMode PCM_PULL = null;
    public static final ExternalAudioSourceMode PCM_PUSH = null;
    public static final /* synthetic */ ExternalAudioSourceMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ExternalAudioSourceMode> getEntries() {
        return b;
    }

    static {
        ExternalAudioSourceMode r0 = new ExternalAudioSourceMode("PCM_PULL", 0);
        PCM_PULL = r0;
        ExternalAudioSourceMode r1 = new ExternalAudioSourceMode("PCM_PUSH", 1);
        PCM_PUSH = r1;
        ExternalAudioSourceMode r3 = new ExternalAudioSourceMode("ENCODED_PULL", 2);
        ENCODED_PULL = r3;
        ExternalAudioSourceMode r5 = new ExternalAudioSourceMode("ENCODED_PUSH", 3);
        ENCODED_PUSH = r5;
        ExternalAudioSourceMode[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ExternalAudioSourceMode[] values() {
        return (ExternalAudioSourceMode[]) a.clone();
    }

    public static ExternalAudioSourceMode valueOf(String r1) {
        return (ExternalAudioSourceMode) a.a(ExternalAudioSourceMode.class, r1);
    }

    public ExternalAudioSourceMode(String r1, int r2) {
        super(r1, r2);
    }
}
