package com.larus.audioplayer.api.news;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/audioplayer/api/news/UrlAudioLoadState;", "", "<init>", "(Ljava/lang/String;I)V", "PLAYABLE", "STALLED", "ERROR", "UNKNOWN", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UrlAudioLoadState extends Enum<UrlAudioLoadState> {
    public static final UrlAudioLoadState ERROR = null;
    public static final UrlAudioLoadState PLAYABLE = null;
    public static final UrlAudioLoadState STALLED = null;
    public static final UrlAudioLoadState UNKNOWN = null;
    public static final /* synthetic */ UrlAudioLoadState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UrlAudioLoadState> getEntries() {
        return b;
    }

    static {
        UrlAudioLoadState r0 = new UrlAudioLoadState("PLAYABLE", 0);
        PLAYABLE = r0;
        UrlAudioLoadState r1 = new UrlAudioLoadState("STALLED", 1);
        STALLED = r1;
        UrlAudioLoadState r3 = new UrlAudioLoadState("ERROR", 2);
        ERROR = r3;
        UrlAudioLoadState r5 = new UrlAudioLoadState("UNKNOWN", 3);
        UNKNOWN = r5;
        UrlAudioLoadState[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static UrlAudioLoadState[] values() {
        return (UrlAudioLoadState[]) a.clone();
    }

    public static UrlAudioLoadState valueOf(String r1) {
        return (UrlAudioLoadState) a.a(UrlAudioLoadState.class, r1);
    }

    public UrlAudioLoadState(String r1, int r2) {
        super(r1, r2);
    }
}
