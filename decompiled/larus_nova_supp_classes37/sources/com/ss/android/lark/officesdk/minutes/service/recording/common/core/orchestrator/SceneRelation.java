package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/orchestrator/SceneRelation;", "", "<init>", "(Ljava/lang/String;I)V", "COEXIST", "INTERRUPT", "REJECT", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum SceneRelation extends Enum<SceneRelation> {
    public static final SceneRelation COEXIST = null;
    public static final SceneRelation INTERRUPT = null;
    public static final SceneRelation REJECT = null;
    public static final /* synthetic */ SceneRelation[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SceneRelation> getEntries() {
        return b;
    }

    static {
        SceneRelation r0 = new SceneRelation("COEXIST", 0);
        COEXIST = r0;
        SceneRelation r1 = new SceneRelation("INTERRUPT", 1);
        INTERRUPT = r1;
        SceneRelation r3 = new SceneRelation("REJECT", 2);
        REJECT = r3;
        SceneRelation[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static SceneRelation[] values() {
        return (SceneRelation[]) a.clone();
    }

    public static SceneRelation valueOf(String r1) {
        return (SceneRelation) r27.a.a(SceneRelation.class, r1);
    }

    public SceneRelation(String r1, int r2) {
        super(r1, r2);
    }
}
