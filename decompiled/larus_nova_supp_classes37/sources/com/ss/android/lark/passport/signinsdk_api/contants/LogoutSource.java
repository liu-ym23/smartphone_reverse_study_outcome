package com.ss.android.lark.passport.signinsdk_api.contants;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/contants/LogoutSource;", "", "value", "", "des", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getValue", "()I", "getDes", "()Ljava/lang/String;", "SETTING", "EXTERNAL", "Companion", "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum LogoutSource extends Enum<LogoutSource> {
    public static final a Companion = null;
    public static final LogoutSource EXTERNAL = null;
    public static final LogoutSource SETTING = null;
    public static final Lazy<LogoutSource[]> a = null;
    public static final List<LogoutSource> b = null;
    public static final /* synthetic */ LogoutSource[] c = null;
    public static final /* synthetic */ EnumEntries d = null;
    private final String des;
    private final int value;

    public static EnumEntries<LogoutSource> getEntries() {
        return d;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [com.ss.android.lark.passport.signinsdk_api.contants.LogoutSource$a] */
    static {
        LogoutSource r0 = new LogoutSource("SETTING", 0, 1, "from setting");
        SETTING = r0;
        LogoutSource r1 = new LogoutSource("EXTERNAL", 1, 2, "from external");
        EXTERNAL = r1;
        LogoutSource[] r4 = {r0, r1};
        c = r4;
        d = EnumEntriesKt.enumEntries(r4);
        Companion = new a();
        a = LazyKt.lazy(LogoutSource$Companion$values$2.INSTANCE);
        b = CollectionsKt.listOf(new LogoutSource[]{r0, r1});
    }

    public static LogoutSource[] values() {
        return (LogoutSource[]) c.clone();
    }

    public static final /* synthetic */ List access$getActiveLogoutSource$cp() {
        return b;
    }

    public static final /* synthetic */ Lazy access$getValues$delegate$cp() {
        return a;
    }

    public final String getDes() {
        return this.des;
    }

    public final int getValue() {
        return this.value;
    }

    public static LogoutSource valueOf(String r1) {
        return (LogoutSource) r27.a.a(LogoutSource.class, r1);
    }

    public LogoutSource(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.value = r3;
        this.des = r4;
    }
}
