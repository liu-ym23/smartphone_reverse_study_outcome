package com.ss.android.lark.inline.ai.api;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/MentionType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "USER", "DOCUMENT", "ALL", "DEFAULT", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum MentionType extends Enum<MentionType> {
    public static final MentionType ALL = null;
    public static final MentionType DEFAULT = null;
    public static final MentionType DOCUMENT = null;
    public static final MentionType USER = null;
    public static final /* synthetic */ MentionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<MentionType> getEntries() {
        return b;
    }

    static {
        MentionType r0 = new MentionType("USER", 0, "user");
        USER = r0;
        MentionType r1 = new MentionType("DOCUMENT", 1, "document");
        DOCUMENT = r1;
        MentionType r2 = new MentionType("ALL", 2, "all");
        ALL = r2;
        MentionType r4 = new MentionType("DEFAULT", 3, LocationHitPoint$ResultType.DEFAULT);
        DEFAULT = r4;
        MentionType[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static MentionType[] values() {
        return (MentionType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static MentionType valueOf(String r1) {
        return (MentionType) a.a(MentionType.class, r1);
    }

    public MentionType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
