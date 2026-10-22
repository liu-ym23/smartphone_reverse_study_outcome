package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/channels/TickerMode;", "", "FIXED_PERIOD", "FIXED_DELAY", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum TickerMode extends Enum<TickerMode> {
    public static final TickerMode FIXED_DELAY = null;
    public static final TickerMode FIXED_PERIOD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TickerMode[] f18777a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f18778b = null;

    static {
        TickerMode r5 = new TickerMode("FIXED_PERIOD", 0);
        FIXED_PERIOD = r5;
        TickerMode r10 = new TickerMode("FIXED_DELAY", 1);
        FIXED_DELAY = r10;
        TickerMode[] r11 = {r5, r10};
        f18777a = r11;
        f18778b = EnumEntriesKt.enumEntries(r11);
    }

    public static EnumEntries<TickerMode> getEntries() {
        return f18778b;
    }

    public static TickerMode valueOf(String r5) {
        return (TickerMode) Enum.valueOf(TickerMode.class, r5);
    }

    public static TickerMode[] values() {
        return (TickerMode[]) f18777a.clone();
    }
}
