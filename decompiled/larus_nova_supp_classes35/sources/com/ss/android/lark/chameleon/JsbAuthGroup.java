package com.ss.android.lark.chameleon;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chameleon/JsbAuthGroup;", "Ljava/io/Serializable;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "value", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Private", "Public", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum JsbAuthGroup extends Enum<JsbAuthGroup> implements Serializable {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ JsbAuthGroup[] $VALUES = null;
    public static final JsbAuthGroup Private = null;
    public static final JsbAuthGroup Public = null;

    private static final /* synthetic */ JsbAuthGroup[] $values() {
        return new JsbAuthGroup[]{Private, Public};
    }

    public static EnumEntries<JsbAuthGroup> getEntries() {
        return $ENTRIES;
    }

    static {
        Private = new JsbAuthGroup("Private", 0, "private");
        Public = new JsbAuthGroup("Public", 1, "public");
        JsbAuthGroup[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static JsbAuthGroup[] values() {
        return (JsbAuthGroup[]) $VALUES.clone();
    }

    public static JsbAuthGroup valueOf(String r1) {
        return (JsbAuthGroup) a.a(JsbAuthGroup.class, r1);
    }

    private JsbAuthGroup(String r1, int r2, String r3) {
        super(r1, r2);
    }
}
