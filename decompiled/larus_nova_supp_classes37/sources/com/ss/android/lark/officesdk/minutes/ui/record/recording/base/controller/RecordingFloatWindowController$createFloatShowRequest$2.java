package com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class RecordingFloatWindowController$createFloatShowRequest$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ MmRecordingSession $session;

    public RecordingFloatWindowController$createFloatShowRequest$2(MmRecordingSession r1) {
        this.$session = r1;
        super(0);
    }

    public final Boolean invoke() {
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r0 = this.$session.g();
        boolean r1 = false;
        if (r0 == null) goto L8;
        if (r0.a() != true) goto L8;
        r1 = true;
    L8:
        return Boolean.valueOf(r1);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m488invoke() {
        return invoke();
    }
}
