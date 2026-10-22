package y31;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PKRecordViewHolder;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.livesdk.link.model.f2;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n extends me.drakeet.multitype.b<a, PKRecordViewHolder> {
    public final com.bytedance.android.live.revlink.impl.pk.utils.m b;
    public final x31.o c;
    public final x31.p d;

    public static final class a {
        public int a;
        public f2 b;
        public int c;
        public Integer d;
        public String e;
        public boolean f;
        public int g;
        public String h;
        public boolean i;

        public a() {
            this.a = 8;
            this.d = 0;
            this.e = "";
            this.i = true;
        }
    }

    public final void g(RecyclerView.ViewHolder r3) {
        PKRecordViewHolder r4 = (PKRecordViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        r4.e = null;
        CompositeDisposable r1 = r4.f;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        r4.f = null;
        ((PkTagsContainerView) ((RecyclerView.ViewHolder) r4).itemView.findViewById(2131388160)).c = 0;
    }

    public final void b(RecyclerView.ViewHolder r12, Object r13) {
        PKRecordViewHolder r0 = (PKRecordViewHolder) r12;
        a r14 = (a) r13;
        Intrinsics.checkNotNullParameter(r0, "holder");
        Intrinsics.checkNotNullParameter(r14, "item");
        r0.U3(r14.g, r14.h, r14.a, r14.b, r14.c, r14.d, r14.e, r14.f, r14.i);
        com.bytedance.android.live.revlink.impl.pk.utils.m r15 = this.b;
        if (r15 == null) goto L6;
        r15.b();
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        Intrinsics.checkNotNullParameter(r6, "parent");
        View r7 = r5.inflate(2131566361, r6, false);
        float r8 = s1.y() / s1.f(375.0f);
        if (r8 <= 1.0f) goto L6;
    L39:
        Unit r9 = Unit.INSTANCE;
        return new PKRecordViewHolder(r7, this.c, this.d);
    L6:
        if (r8 >= 0.6666667f) goto L8;
        r8 = 0.6666667f;
    L8:
        ViewGroup.LayoutParams r0 = r7.findViewById(2131384458).getLayoutParams();
        r0.width = (int) (s1.f(44.0f) * r8);
        r0.height = (int) (s1.f(24.0f) * r8);
        ((TextView) r7.findViewById(2131390387)).setTextSize(0, s1.f(10.0f) * r8);
        View r1 = r7.findViewById(2131374259);
        int r2 = (int) (s1.f(61.0f) * r8);
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        ViewGroup.LayoutParams r4 = null;
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == true) goto L11;
        r3 = null;
    L11:
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r3;
        if (r10 == null) goto L14;
        r10.leftMargin = r2;
    L14:
        View r12 = r7.findViewById(2131375817);
        int r13 = (int) (s1.f(5.0f) * r8);
        ViewGroup.LayoutParams r14 = r12.getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == true) goto L17;
        r14 = null;
    L17:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        if (r15 == null) goto L20;
        r15.leftMargin = r13;
    L20:
        View r16 = r7.findViewById(2131388160);
        int r17 = (int) (s1.f(4.0f) * r8);
        ViewGroup.LayoutParams r18 = r16.getLayoutParams();
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == true) goto L23;
        r18 = null;
    L23:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        if (r19 == null) goto L26;
        r19.leftMargin = r17;
    L26:
        View r20 = r7.findViewById(2131390808);
        int r22 = (int) (s1.f(8.0f) * r8);
        ViewGroup.LayoutParams r23 = r20.getLayoutParams();
        if ((r23 instanceof ViewGroup.MarginLayoutParams) == true) goto L29;
        r23 = null;
    L29:
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r23;
        if (r24 == null) goto L32;
        r24.rightMargin = r22;
    L32:
        View r25 = r7.findViewById(2131390608);
        int r26 = (int) (s1.f(16.0f) * r8);
        ViewGroup.LayoutParams r27 = r25.getLayoutParams();
        if ((r27 instanceof ViewGroup.MarginLayoutParams) == false) goto L36;
        r4 = r27;
    L36:
        ViewGroup.MarginLayoutParams r28 = (ViewGroup.MarginLayoutParams) r4;
        if (r28 == null) goto L39;
        r28.rightMargin = r26;
        goto L39
    }

    public n(com.bytedance.android.live.revlink.impl.pk.utils.m r2, x31.o r3, x31.p r4) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
