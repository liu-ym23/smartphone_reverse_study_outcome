package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum CommentType extends Enum<CommentType> implements WireEnum {
    private static final /* synthetic */ CommentType[] $VALUES = null;
    public static final ProtoAdapter<CommentType> ADAPTER = null;
    public static final CommentType AddComment = null;
    public static final CommentType AddReply = null;
    public static final CommentType CommentTypeUnknown = null;
    public static final CommentType DeleteReply = null;
    public static final CommentType EditReply = null;
    public static final CommentType UpdateComment = null;
    private final int value;

    static {
        CommentType r0 = new CommentType("CommentTypeUnknown", 0, 0);
        CommentTypeUnknown = r0;
        CommentType r1 = new CommentType("AddComment", 1, 1);
        AddComment = r1;
        CommentType r3 = new CommentType("AddReply", 2, 2);
        AddReply = r3;
        CommentType r5 = new CommentType("EditReply", 3, 3);
        EditReply = r5;
        CommentType r7 = new CommentType("DeleteReply", 4, 4);
        DeleteReply = r7;
        CommentType r9 = new CommentType("UpdateComment", 5, 5);
        UpdateComment = r9;
        $VALUES = new CommentType[]{r0, r1, r3, r5, r7, r9};
        ADAPTER = ProtoAdapter.newEnumAdapter(CommentType.class);
    }

    public static CommentType[] values() {
        return (CommentType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static CommentType fromValue(int r1) {
        if (r1 == 0) goto L26;
        if (r1 == 1) goto L24;
        if (r1 == 2) goto L22;
        if (r1 == 3) goto L20;
        if (r1 == 4) goto L18;
        if (r1 == 5) goto L16;
        return null;
    L16:
        return UpdateComment;
    L18:
        return DeleteReply;
    L20:
        return EditReply;
    L22:
        return AddReply;
    L24:
        return AddComment;
    L26:
        return CommentTypeUnknown;
    }

    public static CommentType valueOf(String r1) {
        return (CommentType) a.a(CommentType.class, r1);
    }

    private CommentType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
