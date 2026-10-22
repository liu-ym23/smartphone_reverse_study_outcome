package com.obric.assistant.activation.presentation.runtime.manager;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/assistant/activation/presentation/runtime/manager/ActivationSource;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "AI_KEY", "VOICE", "BREATH", "POWER_KEY", "POWER_KEY_TERMINAL", "runtime_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActivationSource extends Enum<ActivationSource> {
    public static final ActivationSource AI_KEY = null;
    public static final ActivationSource BREATH = null;
    public static final ActivationSource POWER_KEY = null;
    public static final ActivationSource POWER_KEY_TERMINAL = null;
    public static final ActivationSource VOICE = null;
    public static final /* synthetic */ ActivationSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ActivationSource> getEntries() {
        return b;
    }

    static {
        ActivationSource r0 = new ActivationSource("AI_KEY", 0);
        AI_KEY = r0;
        ActivationSource r1 = new ActivationSource("VOICE", 1);
        VOICE = r1;
        ActivationSource r3 = new ActivationSource("BREATH", 2);
        BREATH = r3;
        ActivationSource r5 = new ActivationSource("POWER_KEY", 3);
        POWER_KEY = r5;
        ActivationSource r7 = new ActivationSource("POWER_KEY_TERMINAL", 4);
        POWER_KEY_TERMINAL = r7;
        ActivationSource[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static ActivationSource[] values() {
        return (ActivationSource[]) a.clone();
    }

    public static ActivationSource valueOf(String r1) {
        return (ActivationSource) r27.a.a(ActivationSource.class, r1);
    }

    public ActivationSource(String r1, int r2) {
        super(r1, r2);
    }
}
