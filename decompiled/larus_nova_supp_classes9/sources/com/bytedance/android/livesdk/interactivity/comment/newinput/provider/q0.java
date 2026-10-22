package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q0 implements Runnable {
    public final /* synthetic */ MarkHighlightController.HighlightViewAdapter.HighlightPreviewViewHolder a;
    public final /* synthetic */ Ref.FloatRef b;

    public q0(MarkHighlightController.HighlightViewAdapter.HighlightPreviewViewHolder r1, Ref.FloatRef r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        int r0 = ((RecyclerView.ViewHolder) this.a).itemView.getHeight();
        int r1 = (int) (r0 * this.b.element);
        this.a.d.getLayoutParams().width = r1;
        ViewGroup.LayoutParams r2 = this.a.a.getLayoutParams();
        r2.width = r1;
        r2.height = r0;
        this.a.a.setLayoutParams(r2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
