package com.obric.assistant.cocreationreview.modules.omni;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/obric/assistant/cocreationreview/modules/omni/OmniTaskStatus;", NameKeys.UnloadStrategy_No_Strategy, "raw", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRaw", "()Ljava/lang/String;", "SUCCESS", "FAILED", "USER_STOPPED", "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OmniTaskStatus extends Enum<OmniTaskStatus> {
    public static final a Companion = null;
    public static final OmniTaskStatus FAILED = null;
    public static final OmniTaskStatus SUCCESS = null;
    public static final OmniTaskStatus USER_STOPPED = null;
    public static final /* synthetic */ OmniTaskStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String raw;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<OmniTaskStatus> getEntries() {
        return b;
    }

    static {
        OmniTaskStatus r0 = new OmniTaskStatus("SUCCESS", 0, "success");
        SUCCESS = r0;
        OmniTaskStatus r1 = new OmniTaskStatus("FAILED", 1, "failed");
        FAILED = r1;
        OmniTaskStatus r3 = new OmniTaskStatus("USER_STOPPED", 2, "user_stopped");
        USER_STOPPED = r3;
        OmniTaskStatus[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static OmniTaskStatus[] values() {
        return (OmniTaskStatus[]) a.clone();
    }

    public final String getRaw() {
        return this.raw;
    }

    public static OmniTaskStatus valueOf(String r1) {
        return (OmniTaskStatus) r27.a.a(OmniTaskStatus.class, r1);
    }

    public OmniTaskStatus(String r1, int r2, String r3) {
        super(r1, r2);
        this.raw = r3;
    }
}
