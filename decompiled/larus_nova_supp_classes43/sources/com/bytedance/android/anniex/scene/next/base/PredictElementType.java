package com.bytedance.android.anniex.scene.next.base;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/anniex/scene/next/base/PredictElementType;", "", "", a.KEY_LUBAN_TAG, "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "SceneId", "SceneRepeat", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum PredictElementType extends Enum<PredictElementType> {
    public static final PredictElementType SceneId = null;
    public static final PredictElementType SceneRepeat = null;
    public static final /* synthetic */ PredictElementType[] a = null;
    private final String tag;

    public static PredictElementType valueOf(String r1) {
        return (PredictElementType) r27.a.a(PredictElementType.class, r1);
    }

    public static PredictElementType[] values() {
        return (PredictElementType[]) a.clone();
    }

    static {
        PredictElementType r0 = new PredictElementType("SceneId", 0, "SceneId");
        SceneId = r0;
        PredictElementType r1 = new PredictElementType("SceneRepeat", 1, "SceneRepeat");
        SceneRepeat = r1;
        a = new PredictElementType[]{r0, r1};
    }

    public final String getTag() {
        return this.tag;
    }

    public PredictElementType(String r1, int r10, String r11) {
        super(r1, r10);
        this.tag = r11;
    }
}
