package com.obric.assistant.cocreationreview.modules.omni;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/cocreationreview/modules/omni/OmniTaskTriggerType;", NameKeys.UnloadStrategy_No_Strategy, "raw", NameKeys.UnloadStrategy_No_Strategy, "label", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getRaw", "()Ljava/lang/String;", "getLabel", "PROACTIVE", "AUTOMATIC", "MY_TASK", "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OmniTaskTriggerType extends Enum<OmniTaskTriggerType> {
    public static final OmniTaskTriggerType AUTOMATIC = null;
    public static final a Companion = null;
    public static final OmniTaskTriggerType MY_TASK = null;
    public static final OmniTaskTriggerType PROACTIVE = null;
    public static final /* synthetic */ OmniTaskTriggerType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String label;
    private final String raw;

    public static final class a {
        public a() {
        }

        public static OmniTaskTriggerType a(String r7) {
            Intrinsics.checkNotNullParameter(r7, "raw");
            OmniTaskTriggerType[] r0 = OmniTaskTriggerType.values();
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L13;
            OmniTaskTriggerType r4 = r0[r3];
            boolean r6 = true;
            if (Intrinsics.areEqual(r4.getRaw(), r7) == false) goto L7;
        L10:
            if (r6 == true) goto L14;
            r3 = r3 + 1;
        L14:
            if (r4 == null) goto L16;
            return r4;
        L16:
            return OmniTaskTriggerType.PROACTIVE;
        L7:
            if (StringsKt.equals(r4.name(), r7, true) == true) goto L10;
            r6 = false;
            goto L10
        L13:
            r4 = null;
            goto L14
        }
    }

    public static EnumEntries<OmniTaskTriggerType> getEntries() {
        return b;
    }

    static {
        OmniTaskTriggerType r0 = new OmniTaskTriggerType("PROACTIVE", 0, "proactive", "主动任务");
        PROACTIVE = r0;
        OmniTaskTriggerType r1 = new OmniTaskTriggerType("AUTOMATIC", 1, "automatic", "自动任务");
        AUTOMATIC = r1;
        OmniTaskTriggerType r3 = new OmniTaskTriggerType("MY_TASK", 2, "my_task", "我的任务");
        MY_TASK = r3;
        OmniTaskTriggerType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static OmniTaskTriggerType[] values() {
        return (OmniTaskTriggerType[]) a.clone();
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getRaw() {
        return this.raw;
    }

    public static OmniTaskTriggerType valueOf(String r1) {
        return (OmniTaskTriggerType) r27.a.a(OmniTaskTriggerType.class, r1);
    }

    public OmniTaskTriggerType(String r1, int r2, String r3, String r4) {
        super(r1, r2);
        this.raw = r3;
        this.label = r4;
    }
}
