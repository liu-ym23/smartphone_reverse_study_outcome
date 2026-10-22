package mx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.simple.SimpleViewHolder;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class m extends me.drakeet.multitype.b<o, RecyclerView.ViewHolder> {
    public final boolean b;

    public static final class a implements Runnable {
        public final /* synthetic */ m a;
        public final /* synthetic */ RecyclerView.ViewHolder b;
        public final /* synthetic */ o c;

        public a(m r1, RecyclerView.ViewHolder r2, o r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            m r0 = this.a;     // Catch: Throwable -> L4
            RecyclerView.ViewHolder r1 = this.b;     // Catch: Throwable -> L4
            o r2 = this.c;     // Catch: Throwable -> L4
            r0.getClass();     // Catch: Throwable -> L4
            m.i(r1, r2);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public m(boolean r1) {
        this.b = r1;
    }

    public static void i(RecyclerView.ViewHolder r5, o r6) {
        View r7 = r5.itemView;
        ViewGroup.LayoutParams r0 = r7.getLayoutParams();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        ViewGroup.LayoutParams r1 = null;
    L8:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        if (r2 == null) goto L11;
        r2.setMargins(s1.f(r6.d.left), s1.f(r6.d.top), s1.f(r6.d.right), s1.f(r6.d.bottom));
    L11:
        r7.setLayoutParams(r0);
        return;
    L7:
        r1 = r0;
        goto L8
    }

    public /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r1, Object r2) {
        h(r1, (o) r2);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new SimpleViewHolder(new TextView(r3.getContext()));
    }

    public void h(RecyclerView.ViewHolder r4, o r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        View r0 = r4.itemView;
        if (r0 == null) goto L14;
        TextView r1 = (TextView) r0;
        if (this.b == false) goto L7;
        r1.setTextColor(s1.h(2131107300));
    L8:
        r1.setTextSize(1, r5.c);
        r1.setText(r5.a);
        if (r1.getLayoutParams() == null) goto L11;
        i(r4, r5);
        return;
    L11:
        r1.post(new a(this, r4, r5));
        return;
    L7:
        r1.setTextColor(s1.h(r5.b));
        goto L8
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }
}
