package com.ss.android.lark.feed.export.event;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/feed/export/event/Event$Tag$TagTheme;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "GRAY", "BLUE", "INDIGO", "WATHET", "RAD", "GREEN", "ORANGE", "VIOLET", "PURPLE", "THROUGH", "LIME", "YELLOW", "CARMINE", "DARK_BLUE", "DARK_CARMINE", "DARK_RAD", "DARK_GRAY", "LIGHT_GRAY", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Event$Tag$TagTheme extends Enum<Event$Tag$TagTheme> {
    public static final Event$Tag$TagTheme BLUE = null;
    public static final Event$Tag$TagTheme CARMINE = null;
    public static final Event$Tag$TagTheme DARK_BLUE = null;
    public static final Event$Tag$TagTheme DARK_CARMINE = null;
    public static final Event$Tag$TagTheme DARK_GRAY = null;
    public static final Event$Tag$TagTheme DARK_RAD = null;
    public static final Event$Tag$TagTheme GRAY = null;
    public static final Event$Tag$TagTheme GREEN = null;
    public static final Event$Tag$TagTheme INDIGO = null;
    public static final Event$Tag$TagTheme LIGHT_GRAY = null;
    public static final Event$Tag$TagTheme LIME = null;
    public static final Event$Tag$TagTheme ORANGE = null;
    public static final Event$Tag$TagTheme PURPLE = null;
    public static final Event$Tag$TagTheme RAD = null;
    public static final Event$Tag$TagTheme THROUGH = null;
    public static final Event$Tag$TagTheme VIOLET = null;
    public static final Event$Tag$TagTheme WATHET = null;
    public static final Event$Tag$TagTheme YELLOW = null;
    public static final /* synthetic */ Event$Tag$TagTheme[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<Event$Tag$TagTheme> getEntries() {
        return b;
    }

    static {
        Event$Tag$TagTheme r0 = new Event$Tag$TagTheme("GRAY", 0);
        GRAY = r0;
        Event$Tag$TagTheme r1 = new Event$Tag$TagTheme("BLUE", 1);
        BLUE = r1;
        Event$Tag$TagTheme r3 = new Event$Tag$TagTheme("INDIGO", 2);
        INDIGO = r3;
        Event$Tag$TagTheme r5 = new Event$Tag$TagTheme("WATHET", 3);
        WATHET = r5;
        Event$Tag$TagTheme r7 = new Event$Tag$TagTheme("RAD", 4);
        RAD = r7;
        Event$Tag$TagTheme r9 = new Event$Tag$TagTheme("GREEN", 5);
        GREEN = r9;
        Event$Tag$TagTheme r11 = new Event$Tag$TagTheme("ORANGE", 6);
        ORANGE = r11;
        Event$Tag$TagTheme r13 = new Event$Tag$TagTheme("VIOLET", 7);
        VIOLET = r13;
        Event$Tag$TagTheme r15 = new Event$Tag$TagTheme("PURPLE", 8);
        PURPLE = r15;
        Event$Tag$TagTheme r14 = new Event$Tag$TagTheme("THROUGH", 9);
        THROUGH = r14;
        Event$Tag$TagTheme r12 = new Event$Tag$TagTheme("LIME", 10);
        LIME = r12;
        Event$Tag$TagTheme r10 = new Event$Tag$TagTheme("YELLOW", 11);
        YELLOW = r10;
        Event$Tag$TagTheme r8 = new Event$Tag$TagTheme("CARMINE", 12);
        CARMINE = r8;
        Event$Tag$TagTheme r6 = new Event$Tag$TagTheme("DARK_BLUE", 13);
        DARK_BLUE = r6;
        Event$Tag$TagTheme r4 = new Event$Tag$TagTheme("DARK_CARMINE", 14);
        DARK_CARMINE = r4;
        Event$Tag$TagTheme r2 = new Event$Tag$TagTheme("DARK_RAD", 15);
        DARK_RAD = r2;
        Event$Tag$TagTheme r16 = new Event$Tag$TagTheme("DARK_GRAY", 16);
        DARK_GRAY = r16;
        Event$Tag$TagTheme r17 = new Event$Tag$TagTheme("LIGHT_GRAY", 17);
        LIGHT_GRAY = r17;
        Event$Tag$TagTheme[] r18 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17};
        a = r18;
        b = EnumEntriesKt.enumEntries(r18);
    }

    public static Event$Tag$TagTheme[] values() {
        return (Event$Tag$TagTheme[]) a.clone();
    }

    public static Event$Tag$TagTheme valueOf(String r1) {
        return (Event$Tag$TagTheme) a.a(Event$Tag$TagTheme.class, r1);
    }

    public Event$Tag$TagTheme(String r1, int r2) {
        super(r1, r2);
    }
}
