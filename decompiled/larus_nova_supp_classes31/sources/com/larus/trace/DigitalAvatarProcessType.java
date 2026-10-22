package com.larus.trace;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0011"}, d2 = {"Lcom/larus/trace/DigitalAvatarProcessType;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "UNKNOWN", "BOTH_IMAGE_AND_VIDEO", "APPEND_VIDEO_ONLY", "APPEND_IMAGE_ONLY", "RE_UPLOAD_VIDEO", "RE_UPLOAD_IMAGE", "isNewCreate", "", "Companion", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum DigitalAvatarProcessType extends Enum<DigitalAvatarProcessType> {
    public static final DigitalAvatarProcessType APPEND_IMAGE_ONLY = null;
    public static final DigitalAvatarProcessType APPEND_VIDEO_ONLY = null;
    public static final DigitalAvatarProcessType BOTH_IMAGE_AND_VIDEO = null;
    public static final a Companion = null;
    public static final DigitalAvatarProcessType RE_UPLOAD_IMAGE = null;
    public static final DigitalAvatarProcessType RE_UPLOAD_VIDEO = null;
    public static final DigitalAvatarProcessType UNKNOWN = null;
    public static final /* synthetic */ DigitalAvatarProcessType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int id;

    public static EnumEntries<DigitalAvatarProcessType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.trace.DigitalAvatarProcessType$a] */
    static {
        DigitalAvatarProcessType r0 = new DigitalAvatarProcessType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        DigitalAvatarProcessType r1 = new DigitalAvatarProcessType("BOTH_IMAGE_AND_VIDEO", 1, 1);
        BOTH_IMAGE_AND_VIDEO = r1;
        DigitalAvatarProcessType r3 = new DigitalAvatarProcessType("APPEND_VIDEO_ONLY", 2, 2);
        APPEND_VIDEO_ONLY = r3;
        DigitalAvatarProcessType r5 = new DigitalAvatarProcessType("APPEND_IMAGE_ONLY", 3, 3);
        APPEND_IMAGE_ONLY = r5;
        DigitalAvatarProcessType r7 = new DigitalAvatarProcessType("RE_UPLOAD_VIDEO", 4, 4);
        RE_UPLOAD_VIDEO = r7;
        DigitalAvatarProcessType r9 = new DigitalAvatarProcessType("RE_UPLOAD_IMAGE", 5, 5);
        RE_UPLOAD_IMAGE = r9;
        DigitalAvatarProcessType[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new a();
    }

    public static DigitalAvatarProcessType[] values() {
        return (DigitalAvatarProcessType[]) a.clone();
    }

    public final boolean isNewCreate() {
        if (this != UNKNOWN) goto L5;
    L8:
        return true;
    L5:
        if (this == BOTH_IMAGE_AND_VIDEO) goto L8;
        return false;
    }

    public final int getId() {
        return this.id;
    }

    public static DigitalAvatarProcessType valueOf(String r1) {
        return (DigitalAvatarProcessType) r27.a.a(DigitalAvatarProcessType.class, r1);
    }

    public DigitalAvatarProcessType(String r1, int r2, int r3) {
        super(r1, r2);
        this.id = r3;
    }
}
