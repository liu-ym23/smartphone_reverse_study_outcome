package com.larus.platform.model.comment.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/model/comment/api/CommentScrollToIndexType;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", "CURRENT", "NONE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum CommentScrollToIndexType extends Enum<CommentScrollToIndexType> {
    public static final CommentScrollToIndexType CURRENT = null;
    public static final CommentScrollToIndexType NONE = null;
    public static final CommentScrollToIndexType TOP = null;
    public static final /* synthetic */ CommentScrollToIndexType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CommentScrollToIndexType> getEntries() {
        return b;
    }

    static {
        CommentScrollToIndexType r0 = new CommentScrollToIndexType("TOP", 0);
        TOP = r0;
        CommentScrollToIndexType r1 = new CommentScrollToIndexType("CURRENT", 1);
        CURRENT = r1;
        CommentScrollToIndexType r3 = new CommentScrollToIndexType("NONE", 2);
        NONE = r3;
        CommentScrollToIndexType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static CommentScrollToIndexType[] values() {
        return (CommentScrollToIndexType[]) a.clone();
    }

    public static CommentScrollToIndexType valueOf(String r1) {
        return (CommentScrollToIndexType) a.a(CommentScrollToIndexType.class, r1);
    }

    public CommentScrollToIndexType(String r1, int r2) {
        super(r1, r2);
    }
}
