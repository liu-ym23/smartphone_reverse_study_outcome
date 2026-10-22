package com.larus.camera.api.vlm;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/camera/api/vlm/VLMIntentScene;", "", "<init>", "(Ljava/lang/String;I)V", "COMMON", "QUESTION_SOLVING", "HOMEWORK_CORRECTION", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VLMIntentScene extends Enum<VLMIntentScene> {
    public static final VLMIntentScene COMMON = null;
    public static final VLMIntentScene HOMEWORK_CORRECTION = null;
    public static final VLMIntentScene QUESTION_SOLVING = null;
    public static final /* synthetic */ VLMIntentScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<VLMIntentScene> getEntries() {
        return b;
    }

    static {
        VLMIntentScene r0 = new VLMIntentScene("COMMON", 0);
        COMMON = r0;
        VLMIntentScene r1 = new VLMIntentScene("QUESTION_SOLVING", 1);
        QUESTION_SOLVING = r1;
        VLMIntentScene r3 = new VLMIntentScene("HOMEWORK_CORRECTION", 2);
        HOMEWORK_CORRECTION = r3;
        VLMIntentScene[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static VLMIntentScene[] values() {
        return (VLMIntentScene[]) a.clone();
    }

    public static VLMIntentScene valueOf(String r1) {
        return (VLMIntentScene) a.a(VLMIntentScene.class, r1);
    }

    public VLMIntentScene(String r1, int r2) {
        super(r1, r2);
    }
}
