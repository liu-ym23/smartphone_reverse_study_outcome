package com.larus.doc.sdk.impl.generalbiz.common;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/common/DocSdkVersion;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "V1", "V2", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DocSdkVersion extends Enum<DocSdkVersion> implements Serializable {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DocSdkVersion[] $VALUES = null;
    public static final DocSdkVersion V1 = null;
    public static final DocSdkVersion V2 = null;

    private static final /* synthetic */ DocSdkVersion[] $values() {
        return new DocSdkVersion[]{V1, V2};
    }

    public static EnumEntries<DocSdkVersion> getEntries() {
        return $ENTRIES;
    }

    static {
        V1 = new DocSdkVersion("V1", 0);
        V2 = new DocSdkVersion("V2", 1);
        DocSdkVersion[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static DocSdkVersion[] values() {
        return (DocSdkVersion[]) $VALUES.clone();
    }

    public static DocSdkVersion valueOf(String r1) {
        return (DocSdkVersion) a.a(DocSdkVersion.class, r1);
    }

    private DocSdkVersion(String r1, int r2) {
        super(r1, r2);
    }
}
