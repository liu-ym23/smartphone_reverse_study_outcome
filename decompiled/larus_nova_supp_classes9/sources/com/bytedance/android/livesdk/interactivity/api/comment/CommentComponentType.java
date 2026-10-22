package com.bytedance.android.livesdk.interactivity.api.comment;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/CommentComponentType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "Draft", "Tip", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommentComponentType extends Enum<CommentComponentType> {
    public static final CommentComponentType Draft = null;
    public static final CommentComponentType Tip = null;
    public static final /* synthetic */ CommentComponentType[] a = null;
    private final String type;

    static {
        CommentComponentType r1 = new CommentComponentType("Draft", 0, "draft");
        Draft = r1;
        CommentComponentType r2 = new CommentComponentType("Tip", 1, "tip");
        Tip = r2;
        a = new CommentComponentType[]{r1, r2};
    }

    public static CommentComponentType valueOf(String r1) {
        return (CommentComponentType) a.a(CommentComponentType.class, r1);
    }

    public static CommentComponentType[] values() {
        return (CommentComponentType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public CommentComponentType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
