package com.ss.android.lark.officesdk.minutes.ui.record.recording.language;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public /* synthetic */ class MmRecordingLanguageSettingView$showChoosePage$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public MmRecordingLanguageSettingView$showChoosePage$1(Object r8) {
        super(0, r8, MmRecordingLanguageSettingView.class, "showSpokenLanguagePage", "showSpokenLanguagePage()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m494invoke() {
        MmRecordingLanguageSettingView r0 = (MmRecordingLanguageSettingView) ((CallableReference) this).receiver;
        MmRecordingSpokenLanguageView r1 = r0.e;
        if (r1 != null) goto L5;
        r1 = new MmRecordingSpokenLanguageView(r0.getContext(), r0.a, r0.b, new MmRecordingLanguageSettingView$showSpokenLanguagePage$1(r0));
        r0.e = r1;
    L5:
        r0.b(r1);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m494invoke();
        return Unit.INSTANCE;
    }
}
