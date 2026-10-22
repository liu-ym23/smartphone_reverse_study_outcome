package com.ss.android.lark.officesdk.minutes.api.recording.common.external_audio;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/external_audio/ExternalAudioCodec;", "", "<init>", "(Ljava/lang/String;I)V", "OPUS", "UNKNOWN", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum ExternalAudioCodec extends Enum<ExternalAudioCodec> {
    public static final ExternalAudioCodec OPUS = null;
    public static final ExternalAudioCodec UNKNOWN = null;
    public static final /* synthetic */ ExternalAudioCodec[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ExternalAudioCodec> getEntries() {
        return b;
    }

    static {
        ExternalAudioCodec r0 = new ExternalAudioCodec("OPUS", 0);
        OPUS = r0;
        ExternalAudioCodec r1 = new ExternalAudioCodec("UNKNOWN", 1);
        UNKNOWN = r1;
        ExternalAudioCodec[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ExternalAudioCodec[] values() {
        return (ExternalAudioCodec[]) a.clone();
    }

    public static ExternalAudioCodec valueOf(String r1) {
        return (ExternalAudioCodec) a.a(ExternalAudioCodec.class, r1);
    }

    public ExternalAudioCodec(String r1, int r2) {
        super(r1, r2);
    }
}
