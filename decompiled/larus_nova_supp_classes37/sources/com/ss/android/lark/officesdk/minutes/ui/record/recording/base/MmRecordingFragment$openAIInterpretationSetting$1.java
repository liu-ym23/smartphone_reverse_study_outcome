package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class MmRecordingFragment$openAIInterpretationSetting$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MmRecordingFragment this$0;

    public static final class a implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ MmRecordingFragment b;

        public a(View r1, MmRecordingFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.a.getVisibility() != 0) goto L9;
            this.b.ja0().dispatchEvent(g.c.a);     // Catch: Throwable -> L6
            return;
        }
    }

    public MmRecordingFragment$openAIInterpretationSetting$1(MmRecordingFragment r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m468invoke() {
        if (MmRecordingFragment.da0(this.this$0) == false) goto L20;
        com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.controller.a r0 = this.this$0.q;
        if (r0 == null) goto L8;
        View r1 = r0.e();
        if (r1 == null) goto L8;
    L12:
        if (r1 == null) goto L17;
        View r2 = r1.findViewById(2131375895);
        if (r2 == null) goto L17;
        r1 = r2;
    L17:
        if (r1 == null) goto L21;
        r1.postDelayed(new a(r1, this.this$0), 100);
        return;
    L21:
        return;
    L8:
        mwb.e r3 = this.this$0.o;
        if (r3 == null) goto L11;
        r1 = r3.c;
        goto L12
    L11:
        r1 = null;
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m468invoke();
        return Unit.INSTANCE;
    }
}
