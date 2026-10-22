package com.bytedance.android.ec.common.api.usertracker;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/common/api/usertracker/PostActionType;", "", "", "type", "I", "getType", "()I", "DO", "START_DURATION", "END_DURATION", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final enum PostActionType extends Enum<PostActionType> {
    public static final PostActionType DO = null;
    public static final PostActionType END_DURATION = null;
    public static final PostActionType START_DURATION = null;
    public static final /* synthetic */ PostActionType[] a = null;
    private final int type;

    static {
        PostActionType r1 = new PostActionType("DO", 0, 0);
        DO = r1;
        PostActionType r10 = new PostActionType("START_DURATION", 1, 1);
        START_DURATION = r10;
        PostActionType r11 = new PostActionType("END_DURATION", 2, 2);
        END_DURATION = r11;
        a = new PostActionType[]{r1, r10, r11};
    }

    public static PostActionType valueOf(String r1) {
        return (PostActionType) a.a(PostActionType.class, r1);
    }

    public static PostActionType[] values() {
        return (PostActionType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public PostActionType(String r1, int r10, int r11) {
        super(r1, r10);
        this.type = r11;
    }
}
