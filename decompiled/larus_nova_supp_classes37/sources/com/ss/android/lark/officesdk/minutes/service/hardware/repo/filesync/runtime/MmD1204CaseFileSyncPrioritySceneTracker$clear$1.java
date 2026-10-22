package com.ss.android.lark.officesdk.minutes.service.hardware.repo.filesync.runtime;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class MmD1204CaseFileSyncPrioritySceneTracker$clear$1 extends Lambda implements Function0<String> {
    final /* synthetic */ String $reason;

    public MmD1204CaseFileSyncPrioritySceneTracker$clear$1(String r1) {
        this.$reason = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m240invoke() {
        return "reason=" + this.$reason;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m240invoke();
    }
}
