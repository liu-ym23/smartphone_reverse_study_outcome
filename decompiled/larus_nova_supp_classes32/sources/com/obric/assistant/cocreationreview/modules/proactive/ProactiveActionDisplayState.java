package com.obric.assistant.cocreationreview.modules.proactive;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/cocreationreview/modules/proactive/ProactiveActionDisplayState;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "ADOPTED", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ProactiveActionDisplayState extends Enum<ProactiveActionDisplayState> {
    public static final ProactiveActionDisplayState ADOPTED = null;
    public static final ProactiveActionDisplayState DEFAULT = null;
    public static final /* synthetic */ ProactiveActionDisplayState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ProactiveActionDisplayState> getEntries() {
        return b;
    }

    static {
        ProactiveActionDisplayState r0 = new ProactiveActionDisplayState("DEFAULT", 0);
        DEFAULT = r0;
        ProactiveActionDisplayState r1 = new ProactiveActionDisplayState("ADOPTED", 1);
        ADOPTED = r1;
        ProactiveActionDisplayState[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ProactiveActionDisplayState[] values() {
        return (ProactiveActionDisplayState[]) a.clone();
    }

    public static ProactiveActionDisplayState valueOf(String r1) {
        return (ProactiveActionDisplayState) r27.a.a(ProactiveActionDisplayState.class, r1);
    }

    public ProactiveActionDisplayState(String r1, int r2) {
        super(r1, r2);
    }
}
