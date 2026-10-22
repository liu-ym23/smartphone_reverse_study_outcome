package com.larus.uaigc.helper;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/uaigc/helper/CreationCacheStage;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PREPROCESS_REUSE_CHECKED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
final enum CreationCacheStage extends Enum<CreationCacheStage> {
    public static final CreationCacheStage PREPROCESS_REUSE_CHECKED = null;
    public static final /* synthetic */ CreationCacheStage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<CreationCacheStage> getEntries() {
        return b;
    }

    static {
        CreationCacheStage r0 = new CreationCacheStage();
        PREPROCESS_REUSE_CHECKED = r0;
        CreationCacheStage[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public CreationCacheStage() {
        super("PREPROCESS_REUSE_CHECKED", 0);
        this.value = "preprocess_reuse_checked";
    }

    public static CreationCacheStage[] values() {
        return (CreationCacheStage[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static CreationCacheStage valueOf(String r1) {
        return (CreationCacheStage) r27.a.a(CreationCacheStage.class, r1);
    }
}
