package com.obric.assistant.activation.presentation.contract;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/assistant/activation/presentation/contract/ObricListeningVisualMode;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "HIDDEN", "LOADING", "CLICK_TALK", "PRESS_TALK", "contract_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricListeningVisualMode extends Enum<ObricListeningVisualMode> {
    public static final ObricListeningVisualMode CLICK_TALK = null;
    public static final ObricListeningVisualMode HIDDEN = null;
    public static final ObricListeningVisualMode LOADING = null;
    public static final ObricListeningVisualMode PRESS_TALK = null;
    public static final /* synthetic */ ObricListeningVisualMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ObricListeningVisualMode> getEntries() {
        return b;
    }

    static {
        ObricListeningVisualMode r0 = new ObricListeningVisualMode("HIDDEN", 0);
        HIDDEN = r0;
        ObricListeningVisualMode r1 = new ObricListeningVisualMode("LOADING", 1);
        LOADING = r1;
        ObricListeningVisualMode r3 = new ObricListeningVisualMode("CLICK_TALK", 2);
        CLICK_TALK = r3;
        ObricListeningVisualMode r5 = new ObricListeningVisualMode("PRESS_TALK", 3);
        PRESS_TALK = r5;
        ObricListeningVisualMode[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ObricListeningVisualMode[] values() {
        return (ObricListeningVisualMode[]) a.clone();
    }

    public static ObricListeningVisualMode valueOf(String r1) {
        return (ObricListeningVisualMode) a.a(ObricListeningVisualMode.class, r1);
    }

    public ObricListeningVisualMode(String r1, int r2) {
        super(r1, r2);
    }
}
