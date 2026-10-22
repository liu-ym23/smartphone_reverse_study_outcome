package obric.flow.miniappwidget;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lobric/flow/miniappwidget/MiniAppWidgetRuntimeValidity;", "", "VALID", "INVALID", "UNKNOWN", "MiniAppWidgetHost_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum MiniAppWidgetRuntimeValidity extends Enum<MiniAppWidgetRuntimeValidity> {
    public static final MiniAppWidgetRuntimeValidity INVALID = null;
    public static final MiniAppWidgetRuntimeValidity UNKNOWN = null;
    public static final MiniAppWidgetRuntimeValidity VALID = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MiniAppWidgetRuntimeValidity[] f20454a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f20455b = null;

    static {
        MiniAppWidgetRuntimeValidity r5 = new MiniAppWidgetRuntimeValidity("VALID", 0);
        VALID = r5;
        MiniAppWidgetRuntimeValidity r10 = new MiniAppWidgetRuntimeValidity("INVALID", 1);
        INVALID = r10;
        MiniAppWidgetRuntimeValidity r11 = new MiniAppWidgetRuntimeValidity("UNKNOWN", 2);
        UNKNOWN = r11;
        MiniAppWidgetRuntimeValidity[] r12 = {r5, r10, r11};
        f20454a = r12;
        f20455b = EnumEntriesKt.enumEntries(r12);
    }

    public static EnumEntries<MiniAppWidgetRuntimeValidity> getEntries() {
        return f20455b;
    }

    public static MiniAppWidgetRuntimeValidity valueOf(String r5) {
        return (MiniAppWidgetRuntimeValidity) Enum.valueOf(MiniAppWidgetRuntimeValidity.class, r5);
    }

    public static MiniAppWidgetRuntimeValidity[] values() {
        return (MiniAppWidgetRuntimeValidity[]) f20454a.clone();
    }
}
