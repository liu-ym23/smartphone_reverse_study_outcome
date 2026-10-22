package com.larus.slides.sdk.api.orientation;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/slides/sdk/api/orientation/SlidesStates;", "", "states", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStates", "()Ljava/lang/String;", "EMPTY", "NORMAL", "GENERATING", "READ_ONLY", "PRESENTATION", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum SlidesStates extends Enum<SlidesStates> {
    public static final SlidesStates EMPTY = null;
    public static final SlidesStates GENERATING = null;
    public static final SlidesStates NORMAL = null;
    public static final SlidesStates PRESENTATION = null;
    public static final SlidesStates READ_ONLY = null;
    public static final /* synthetic */ SlidesStates[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String states;

    public static EnumEntries<SlidesStates> getEntries() {
        return b;
    }

    static {
        SlidesStates r0 = new SlidesStates("EMPTY", 0, "empty");
        EMPTY = r0;
        SlidesStates r1 = new SlidesStates("NORMAL", 1, "normal");
        NORMAL = r1;
        SlidesStates r2 = new SlidesStates("GENERATING", 2, "generating");
        GENERATING = r2;
        SlidesStates r4 = new SlidesStates("READ_ONLY", 3, "read_only");
        READ_ONLY = r4;
        SlidesStates r6 = new SlidesStates("PRESENTATION", 4, "presentation");
        PRESENTATION = r6;
        SlidesStates[] r8 = {r0, r1, r2, r4, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static SlidesStates[] values() {
        return (SlidesStates[]) a.clone();
    }

    public final String getStates() {
        return this.states;
    }

    public static SlidesStates valueOf(String r1) {
        return (SlidesStates) a.a(SlidesStates.class, r1);
    }

    public SlidesStates(String r1, int r2, String r3) {
        super(r1, r2);
        this.states = r3;
    }
}
