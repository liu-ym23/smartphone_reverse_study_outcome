package com.larus.audioplayer.api.news;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/audioplayer/api/news/UrlAudioPlayStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PREPARE", "PLAYING", "PAUSED", "STOPPED", "ERROR", "FINISH", "UNKNOWN", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum UrlAudioPlayStatus extends Enum<UrlAudioPlayStatus> {
    public static final UrlAudioPlayStatus ERROR = null;
    public static final UrlAudioPlayStatus FINISH = null;
    public static final UrlAudioPlayStatus PAUSED = null;
    public static final UrlAudioPlayStatus PLAYING = null;
    public static final UrlAudioPlayStatus PREPARE = null;
    public static final UrlAudioPlayStatus STOPPED = null;
    public static final UrlAudioPlayStatus UNKNOWN = null;
    public static final /* synthetic */ UrlAudioPlayStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<UrlAudioPlayStatus> getEntries() {
        return b;
    }

    static {
        UrlAudioPlayStatus r0 = new UrlAudioPlayStatus("PREPARE", 0, "prepare");
        PREPARE = r0;
        UrlAudioPlayStatus r1 = new UrlAudioPlayStatus("PLAYING", 1, "playing");
        PLAYING = r1;
        UrlAudioPlayStatus r2 = new UrlAudioPlayStatus("PAUSED", 2, "paused");
        PAUSED = r2;
        UrlAudioPlayStatus r4 = new UrlAudioPlayStatus("STOPPED", 3, "stopped");
        STOPPED = r4;
        UrlAudioPlayStatus r6 = new UrlAudioPlayStatus("ERROR", 4, "error");
        ERROR = r6;
        UrlAudioPlayStatus r8 = new UrlAudioPlayStatus("FINISH", 5, "finish");
        FINISH = r8;
        UrlAudioPlayStatus r10 = new UrlAudioPlayStatus("UNKNOWN", 6, "unknown");
        UNKNOWN = r10;
        UrlAudioPlayStatus[] r12 = {r0, r1, r2, r4, r6, r8, r10};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static UrlAudioPlayStatus[] values() {
        return (UrlAudioPlayStatus[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static UrlAudioPlayStatus valueOf(String r1) {
        return (UrlAudioPlayStatus) a.a(UrlAudioPlayStatus.class, r1);
    }

    public UrlAudioPlayStatus(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
