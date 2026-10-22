package com.bytedance.android.livesdk.interactivity.api.comment.keyboard;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/keyboard/HintType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "ANCHOR_CUSTOM_TOPIC", "COMMENT_TOPIC", "NORMAL", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum HintType extends Enum<HintType> {
    public static final HintType ANCHOR_CUSTOM_TOPIC = null;
    public static final HintType COMMENT_TOPIC = null;
    public static final HintType NORMAL = null;
    public static final /* synthetic */ HintType[] a = null;
    private final String typeName;

    static {
        HintType r1 = new HintType("ANCHOR_CUSTOM_TOPIC", 0, "anchor_custom_topic");
        ANCHOR_CUSTOM_TOPIC = r1;
        HintType r2 = new HintType("COMMENT_TOPIC", 1, "comment_topic");
        COMMENT_TOPIC = r2;
        HintType r3 = new HintType("NORMAL", 2, "normal");
        NORMAL = r3;
        a = new HintType[]{r1, r2, r3};
    }

    public static HintType valueOf(String r1) {
        return (HintType) a.a(HintType.class, r1);
    }

    public static HintType[] values() {
        return (HintType[]) a.clone();
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public HintType(String r1, int r2, String r3) {
        super(r1, r2);
        this.typeName = r3;
    }
}
