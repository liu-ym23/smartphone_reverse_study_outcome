package com.bytedance.android.livesdk.interactivity.comment.record.guide;

import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a implements c {
    public final CompositeDisposable a;

    @Override // com.bytedance.android.livesdk.interactivity.comment.record.guide.c
    public void a(RecordGuideContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.record.guide.c
    public final void onDialogDismiss() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.record.guide.c
    public void b() {
        this.a.clear();
    }

    public a() {
        this.a = new CompositeDisposable();
    }
}
