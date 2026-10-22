package com.bytedance.android.livesdk.interactivity.api.comment.event;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/event/QuickCommentTypeEnum;", BuildConfig.FLAVOR, "QUICK_COMMENT_MATCH", "QUICK_COMMENT_FIXED", "QUICK_COMMENT_OGC_FIXED", "DEFAULT", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum QuickCommentTypeEnum extends Enum<QuickCommentTypeEnum> {
    public static final QuickCommentTypeEnum DEFAULT = null;
    public static final QuickCommentTypeEnum QUICK_COMMENT_FIXED = null;
    public static final QuickCommentTypeEnum QUICK_COMMENT_MATCH = null;
    public static final QuickCommentTypeEnum QUICK_COMMENT_OGC_FIXED = null;
    public static final /* synthetic */ QuickCommentTypeEnum[] a = null;

    static {
        QuickCommentTypeEnum r1 = new QuickCommentTypeEnum("QUICK_COMMENT_MATCH", 0);
        QUICK_COMMENT_MATCH = r1;
        QuickCommentTypeEnum r2 = new QuickCommentTypeEnum("QUICK_COMMENT_FIXED", 1);
        QUICK_COMMENT_FIXED = r2;
        QuickCommentTypeEnum r3 = new QuickCommentTypeEnum("QUICK_COMMENT_OGC_FIXED", 2);
        QUICK_COMMENT_OGC_FIXED = r3;
        QuickCommentTypeEnum r4 = new QuickCommentTypeEnum("DEFAULT", 3);
        DEFAULT = r4;
        a = new QuickCommentTypeEnum[]{r1, r2, r3, r4};
    }

    public static QuickCommentTypeEnum valueOf(String r1) {
        return (QuickCommentTypeEnum) a.a(QuickCommentTypeEnum.class, r1);
    }

    public static QuickCommentTypeEnum[] values() {
        return (QuickCommentTypeEnum[]) a.clone();
    }

    public QuickCommentTypeEnum(String r1, int r2) {
        super(r1, r2);
    }
}
