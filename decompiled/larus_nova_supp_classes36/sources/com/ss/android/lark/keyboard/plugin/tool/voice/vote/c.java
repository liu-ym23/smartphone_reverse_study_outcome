package com.ss.android.lark.keyboard.plugin.tool.voice.vote;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ DownVoteReasonAdapter.b a;
    public final /* synthetic */ DownVoteReasonAdapter b;
    public final /* synthetic */ DownVoteReasonAdapter.DownVoteReasonViewHolder c;
    public final /* synthetic */ int d;

    public static final class a implements Runnable {
        public final /* synthetic */ DownVoteReasonAdapter a;

        public a(DownVoteReasonAdapter r1) {
            this.a = r1;
        }

        public final void a() {
            List<DownVoteReasonAdapter.b> r0 = this.a.b;
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            Object r3 = r2.next();
            if (((DownVoteReasonAdapter.b) r3).c == false) goto L4;
            r1.add(r3);
            goto L4
        L8:
            int r4 = r1.size();
            Function1<Integer, Unit> r5 = this.a.a;
            if (r5 == null) goto L17;
            r5.invoke(Integer.valueOf(r4));
            return;
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

    public c(DownVoteReasonAdapter.b r1, DownVoteReasonAdapter r2, DownVoteReasonAdapter.DownVoteReasonViewHolder r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        DownVoteReasonAdapter.b r0 = this.a;
        boolean r1 = !r0.c;
        r0.c = r1;
        DownVoteReasonAdapter r2 = this.b;
        AppCompatTextView r3 = this.c.a;
        int r4 = DownVoteReasonAdapter.c;
        r2.getClass();
        DownVoteReasonAdapter.y2(r3, r1);
        this.b.notifyItemChanged(this.d);
        r5.post(new a(this.b));
    }
}
