package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.event;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/event/SubtitleSource;", "", "desc", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "PULL_TO_REFRESH", "NETWORK_RECONNECT", "LANGUAGE_CHANGE", "BILINGUAL_SWITCH", "DEFAULT", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum SubtitleSource extends Enum<SubtitleSource> {
    public static final SubtitleSource BILINGUAL_SWITCH = null;
    public static final SubtitleSource DEFAULT = null;
    public static final SubtitleSource LANGUAGE_CHANGE = null;
    public static final SubtitleSource NETWORK_RECONNECT = null;
    public static final SubtitleSource PULL_TO_REFRESH = null;
    public static final /* synthetic */ SubtitleSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String desc;

    public static EnumEntries<SubtitleSource> getEntries() {
        return b;
    }

    static {
        SubtitleSource r0 = new SubtitleSource("PULL_TO_REFRESH", 0, "pull_to_refresh");
        PULL_TO_REFRESH = r0;
        SubtitleSource r1 = new SubtitleSource("NETWORK_RECONNECT", 1, "network_reconnect");
        NETWORK_RECONNECT = r1;
        SubtitleSource r2 = new SubtitleSource("LANGUAGE_CHANGE", 2, "language_change");
        LANGUAGE_CHANGE = r2;
        SubtitleSource r4 = new SubtitleSource("BILINGUAL_SWITCH", 3, "bilingual_switch");
        BILINGUAL_SWITCH = r4;
        SubtitleSource r6 = new SubtitleSource("DEFAULT", 4, "default");
        DEFAULT = r6;
        SubtitleSource[] r8 = {r0, r1, r2, r4, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static SubtitleSource[] values() {
        return (SubtitleSource[]) a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public static SubtitleSource valueOf(String r1) {
        return (SubtitleSource) a.a(SubtitleSource.class, r1);
    }

    public SubtitleSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.desc = r3;
    }
}
