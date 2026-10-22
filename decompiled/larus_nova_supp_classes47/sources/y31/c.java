package y31;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.LinkRecordViewHolder;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.livesdk.link.model.o5;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends me.drakeet.multitype.b<a, LinkRecordViewHolder> {
    public final x31.b b;
    public final x31.c c;

    public static final class a {
        public int a;
        public o5 b;
        public int c;
        public boolean d;
        public int e;
        public String f;

        public a() {
            this.a = 8;
        }
    }

    public final void g(RecyclerView.ViewHolder r3) {
        LinkRecordViewHolder r4 = (LinkRecordViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        r4.e = null;
        CompositeDisposable r1 = r4.f;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        r4.f = null;
        ((PkTagsContainerView) ((RecyclerView.ViewHolder) r4).itemView.findViewById(2131388160)).c = 0;
    }

    public c(x31.b r2, x31.c r3) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b = r2;
        this.c = r3;
    }

    public final void b(RecyclerView.ViewHolder r8, Object r9) {
        LinkRecordViewHolder r0 = (LinkRecordViewHolder) r8;
        a r10 = (a) r9;
        Intrinsics.checkNotNullParameter(r0, "holder");
        Intrinsics.checkNotNullParameter(r10, "item");
        r0.U3(r10.e, r10.f, r10.a, r10.b, r10.c, r10.d);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        Intrinsics.checkNotNullParameter(r6, "parent");
        View r7 = r5.inflate(2131566315, r6, false);
        float r8 = s1.y() / s1.f(375.0f);
        if (r8 <= 1.0f) goto L6;
    L27:
        Unit r9 = Unit.INSTANCE;
        return new LinkRecordViewHolder(r7, this.b, this.c);
    L6:
        if (r8 >= 0.6666667f) goto L8;
        r8 = 0.6666667f;
    L8:
        View r0 = r7.findViewById(2131374259);
        int r1 = (int) (s1.f(16.0f) * r8);
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        ViewGroup.LayoutParams r3 = null;
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L11;
        r2 = null;
    L11:
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r2;
        if (r4 == null) goto L14;
        r4.leftMargin = r1;
    L14:
        View r10 = r7.findViewById(2131375817);
        int r12 = (int) (s1.f(5.0f) * r8);
        ViewGroup.LayoutParams r13 = r10.getLayoutParams();
        if ((r13 instanceof ViewGroup.MarginLayoutParams) == true) goto L17;
        r13 = null;
    L17:
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r13;
        if (r14 == null) goto L20;
        r14.leftMargin = r12;
    L20:
        View r15 = r7.findViewById(2131388160);
        int r16 = (int) (s1.f(4.0f) * r8);
        ViewGroup.LayoutParams r17 = r15.getLayoutParams();
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
        r3 = r17;
    L24:
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r3;
        if (r18 == null) goto L27;
        r18.leftMargin = r16;
        goto L27
    }
}
