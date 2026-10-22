package com.ss.android.lark.officesdk.minutes.ui.record.recording;

import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.host.d;
import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model.MmRecordingFloatDismissReason;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class MmRecordingUiController$interruptRecordingUi$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $recordingId;

    public MmRecordingUiController$interruptRecordingUi$1(String r1) {
        this.$recordingId = r1;
        super(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.app.Activity, com.ss.android.lark.officesdk.minutes.ui.record.recording.MmBaseRecordingActivity] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.List] */
    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m420invoke() {
        List<WeakReference<MmBaseRecordingActivity>> r0 = b.b.remove(this.$recordingId);
        if (r0 == null) goto L10;
        ?? r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        MmBaseRecordingActivity r3 = (MmBaseRecordingActivity) ((WeakReference) r2.next()).get();
        if (r3 == null) goto L6;
        r1.add(r3);
    L11:
        if (r1 != 0) goto L13;
        r1 = CollectionsKt.emptyList();
    L13:
        Iterator r4 = ((Iterable) r1).iterator();
    L15:
        if (r4.hasNext() == false) goto L21;
        ?? r5 = (MmBaseRecordingActivity) r4.next();
        if (r5.isFinishing() == true) goto L15;
        if (r5.isDestroyed() == true) goto L15;
        r5.finish();
        goto L15
    L21:
        d r6 = com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.a.a;
        com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.a.c(this.$recordingId, MmRecordingFloatDismissReason.RECORDING_INTERRUPTED);
        return;
    L10:
        r1 = 0;
        goto L11
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m420invoke();
        return Unit.INSTANCE;
    }
}
