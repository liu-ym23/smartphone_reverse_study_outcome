package com.larus.sheet.sdk.api.orientation;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/sheet/sdk/api/orientation/TitleBarStates;", "", "states", "", "<init>", "(Ljava/lang/String;II)V", "getStates", "()I", "VISIBLE", "GONE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum TitleBarStates extends Enum<TitleBarStates> {
    public static final TitleBarStates GONE = null;
    public static final TitleBarStates VISIBLE = null;
    public static final /* synthetic */ TitleBarStates[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int states;

    public static EnumEntries<TitleBarStates> getEntries() {
        return b;
    }

    static {
        TitleBarStates r0 = new TitleBarStates("VISIBLE", 0, 1);
        VISIBLE = r0;
        TitleBarStates r1 = new TitleBarStates("GONE", 1, 0);
        GONE = r1;
        TitleBarStates[] r4 = {r0, r1};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static TitleBarStates[] values() {
        return (TitleBarStates[]) a.clone();
    }

    public final int getStates() {
        return this.states;
    }

    public static TitleBarStates valueOf(String r1) {
        return (TitleBarStates) a.a(TitleBarStates.class, r1);
    }

    public TitleBarStates(String r1, int r2, int r3) {
        super(r1, r2);
        this.states = r3;
    }
}
