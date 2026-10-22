package com.obric.assistant.actionbar.statemanager.interfaces;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/actionbar/statemanager/interfaces/ObricTaskInfoType;", NameKeys.UnloadStrategy_No_Strategy, "infoType", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getInfoType", "()Ljava/lang/String;", "TYPE_OAUTO", "TYPE_COMPLEX_TASK", "TYPE_ONNI_QUERY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricTaskInfoType extends Enum<ObricTaskInfoType> {

    @Deprecated(message = "use omni")
    public static final ObricTaskInfoType TYPE_COMPLEX_TASK = null;

    @Deprecated(message = "use omni")
    public static final ObricTaskInfoType TYPE_OAUTO = null;
    public static final ObricTaskInfoType TYPE_ONNI_QUERY = null;
    public static final /* synthetic */ ObricTaskInfoType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String infoType;

    public static EnumEntries<ObricTaskInfoType> getEntries() {
        return b;
    }

    static {
        ObricTaskInfoType r0 = new ObricTaskInfoType("TYPE_OAUTO", 0, "oauto_info");
        TYPE_OAUTO = r0;
        ObricTaskInfoType r1 = new ObricTaskInfoType("TYPE_COMPLEX_TASK", 1, "example_query");
        TYPE_COMPLEX_TASK = r1;
        ObricTaskInfoType r2 = new ObricTaskInfoType("TYPE_ONNI_QUERY", 2, "example_omni_query");
        TYPE_ONNI_QUERY = r2;
        ObricTaskInfoType[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static ObricTaskInfoType[] values() {
        return (ObricTaskInfoType[]) a.clone();
    }

    public final String getInfoType() {
        return this.infoType;
    }

    public static ObricTaskInfoType valueOf(String r1) {
        return (ObricTaskInfoType) a.a(ObricTaskInfoType.class, r1);
    }

    public ObricTaskInfoType(String r1, int r2, String r3) {
        super(r1, r2);
        this.infoType = r3;
    }
}
