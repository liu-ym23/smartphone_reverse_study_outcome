package com.obric.assistant.cocreationreview;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/cocreationreview/Vote;", NameKeys.UnloadStrategy_No_Strategy, "raw", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRaw", "()Ljava/lang/String;", "UP", "DOWN", "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Vote extends Enum<Vote> {
    public static final a Companion = null;
    public static final Vote DOWN = null;
    public static final Vote UP = null;
    public static final /* synthetic */ Vote[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String raw;

    public static final class a {
        public a() {
        }

        public static Vote a(String r5) {
            Vote[] r0 = Vote.values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            Vote r3 = r0[r2];
            if (Intrinsics.areEqual(r3.getRaw(), r5) == true) goto L12;
            r2 = r2 + 1;
            goto L3
        L12:
            return r3;
        L8:
            return null;
        }
    }

    public static EnumEntries<Vote> getEntries() {
        return b;
    }

    static {
        Vote r0 = new Vote("UP", 0, "up");
        UP = r0;
        Vote r1 = new Vote("DOWN", 1, "down");
        DOWN = r1;
        Vote[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
        Companion = new a();
    }

    public static Vote[] values() {
        return (Vote[]) a.clone();
    }

    public final String getRaw() {
        return this.raw;
    }

    public static Vote valueOf(String r1) {
        return (Vote) r27.a.a(Vote.class, r1);
    }

    public Vote(String r1, int r2, String r3) {
        super(r1, r2);
        this.raw = r3;
    }
}
