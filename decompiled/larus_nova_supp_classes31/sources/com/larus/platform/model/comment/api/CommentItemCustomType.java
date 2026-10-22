package com.larus.platform.model.comment.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/model/comment/api/CommentItemCustomType;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "FAIL", "EMPTY", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum CommentItemCustomType extends Enum<CommentItemCustomType> {
    public static final CommentItemCustomType EMPTY = null;
    public static final CommentItemCustomType FAIL = null;
    public static final CommentItemCustomType LOADING = null;
    public static final /* synthetic */ CommentItemCustomType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CommentItemCustomType> getEntries() {
        return b;
    }

    static {
        CommentItemCustomType r0 = new CommentItemCustomType("LOADING", 0);
        LOADING = r0;
        CommentItemCustomType r1 = new CommentItemCustomType("FAIL", 1);
        FAIL = r1;
        CommentItemCustomType r3 = new CommentItemCustomType("EMPTY", 2);
        EMPTY = r3;
        CommentItemCustomType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static CommentItemCustomType[] values() {
        return (CommentItemCustomType[]) a.clone();
    }

    public static CommentItemCustomType valueOf(String r1) {
        return (CommentItemCustomType) a.a(CommentItemCustomType.class, r1);
    }

    public CommentItemCustomType(String r1, int r2) {
        super(r1, r2);
    }
}
