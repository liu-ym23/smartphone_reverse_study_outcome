package com.obric.assistant;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/ObricOmniLockscreenStateServiceImpl$OmniPageEntry;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "CHAT_PAGE", "OMNI_DETAIL_PAGE", "VIRTUAL_SCREEN_PAGE", "WINDOW_PAGE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricOmniLockscreenStateServiceImpl$OmniPageEntry extends Enum<ObricOmniLockscreenStateServiceImpl$OmniPageEntry> {
    public static final ObricOmniLockscreenStateServiceImpl$OmniPageEntry CHAT_PAGE = null;
    public static final ObricOmniLockscreenStateServiceImpl$OmniPageEntry OMNI_DETAIL_PAGE = null;
    public static final ObricOmniLockscreenStateServiceImpl$OmniPageEntry VIRTUAL_SCREEN_PAGE = null;
    public static final ObricOmniLockscreenStateServiceImpl$OmniPageEntry WINDOW_PAGE = null;
    public static final /* synthetic */ ObricOmniLockscreenStateServiceImpl$OmniPageEntry[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ObricOmniLockscreenStateServiceImpl$OmniPageEntry> getEntries() {
        return b;
    }

    static {
        ObricOmniLockscreenStateServiceImpl$OmniPageEntry r0 = new ObricOmniLockscreenStateServiceImpl$OmniPageEntry("CHAT_PAGE", 0);
        CHAT_PAGE = r0;
        ObricOmniLockscreenStateServiceImpl$OmniPageEntry r1 = new ObricOmniLockscreenStateServiceImpl$OmniPageEntry("OMNI_DETAIL_PAGE", 1);
        OMNI_DETAIL_PAGE = r1;
        ObricOmniLockscreenStateServiceImpl$OmniPageEntry r3 = new ObricOmniLockscreenStateServiceImpl$OmniPageEntry("VIRTUAL_SCREEN_PAGE", 2);
        VIRTUAL_SCREEN_PAGE = r3;
        ObricOmniLockscreenStateServiceImpl$OmniPageEntry r5 = new ObricOmniLockscreenStateServiceImpl$OmniPageEntry("WINDOW_PAGE", 3);
        WINDOW_PAGE = r5;
        ObricOmniLockscreenStateServiceImpl$OmniPageEntry[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ObricOmniLockscreenStateServiceImpl$OmniPageEntry[] values() {
        return (ObricOmniLockscreenStateServiceImpl$OmniPageEntry[]) a.clone();
    }

    public static ObricOmniLockscreenStateServiceImpl$OmniPageEntry valueOf(String r1) {
        return (ObricOmniLockscreenStateServiceImpl$OmniPageEntry) r27.a.a(ObricOmniLockscreenStateServiceImpl$OmniPageEntry.class, r1);
    }

    public ObricOmniLockscreenStateServiceImpl$OmniPageEntry(String r1, int r2) {
        super(r1, r2);
    }
}
