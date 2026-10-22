package com.ss.android.lark.officesdk.minutes.ui.record.recording.language;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ MmRecordingLanguageChooseView a;

    public a(MmRecordingLanguageChooseView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        Function0<Unit> r2 = this.a.b;
        if (r2 == null) goto L6;
        r2.invoke();
        return;
    }
}
