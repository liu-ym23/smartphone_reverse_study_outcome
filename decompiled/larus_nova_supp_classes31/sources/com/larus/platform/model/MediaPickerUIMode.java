package com.larus.platform.model;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/model/MediaPickerUIMode;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "COLLAPSED_BOTTOM_SHEET", "INVISIBLE_BOTTOM_SHEET", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum MediaPickerUIMode extends Enum<MediaPickerUIMode> {
    public static final MediaPickerUIMode COLLAPSED_BOTTOM_SHEET = null;
    public static final MediaPickerUIMode INVISIBLE_BOTTOM_SHEET = null;
    public static final MediaPickerUIMode NORMAL = null;
    public static final /* synthetic */ MediaPickerUIMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MediaPickerUIMode> getEntries() {
        return b;
    }

    static {
        MediaPickerUIMode r0 = new MediaPickerUIMode("NORMAL", 0);
        NORMAL = r0;
        MediaPickerUIMode r1 = new MediaPickerUIMode("COLLAPSED_BOTTOM_SHEET", 1);
        COLLAPSED_BOTTOM_SHEET = r1;
        MediaPickerUIMode r3 = new MediaPickerUIMode("INVISIBLE_BOTTOM_SHEET", 2);
        INVISIBLE_BOTTOM_SHEET = r3;
        MediaPickerUIMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MediaPickerUIMode[] values() {
        return (MediaPickerUIMode[]) a.clone();
    }

    public static MediaPickerUIMode valueOf(String r1) {
        return (MediaPickerUIMode) a.a(MediaPickerUIMode.class, r1);
    }

    public MediaPickerUIMode(String r1, int r2) {
        super(r1, r2);
    }
}
