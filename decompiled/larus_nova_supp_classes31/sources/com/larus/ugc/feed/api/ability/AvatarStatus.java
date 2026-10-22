package com.larus.ugc.feed.api.ability;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/ugc/feed/api/ability/AvatarStatus;", "", "rawValue", "", "<init>", "(Ljava/lang/String;II)V", "getRawValue", "()I", "Unknown", "NotCreated", "Creating", "Created", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum AvatarStatus extends Enum<AvatarStatus> {
    public static final a Companion = null;
    public static final AvatarStatus Created = null;
    public static final AvatarStatus Creating = null;
    public static final AvatarStatus NotCreated = null;
    public static final AvatarStatus Unknown = null;
    public static final /* synthetic */ AvatarStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int rawValue;

    public static EnumEntries<AvatarStatus> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.ugc.feed.api.ability.AvatarStatus$a] */
    static {
        AvatarStatus r0 = new AvatarStatus("Unknown", 0, -1);
        Unknown = r0;
        AvatarStatus r1 = new AvatarStatus("NotCreated", 1, 0);
        NotCreated = r1;
        AvatarStatus r3 = new AvatarStatus("Creating", 2, 1);
        Creating = r3;
        AvatarStatus r5 = new AvatarStatus("Created", 3, 2);
        Created = r5;
        AvatarStatus[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static AvatarStatus[] values() {
        return (AvatarStatus[]) a.clone();
    }

    public final int getRawValue() {
        return this.rawValue;
    }

    public static AvatarStatus valueOf(String r1) {
        return (AvatarStatus) r27.a.a(AvatarStatus.class, r1);
    }

    public AvatarStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.rawValue = r3;
    }
}
