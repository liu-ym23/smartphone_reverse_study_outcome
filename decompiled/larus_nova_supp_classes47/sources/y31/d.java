package y31;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.NewPkRecordViewHolder;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.livesdk.link.model.f2;
import com.bytedance.android.livesdk.link.model.h4;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends me.drakeet.multitype.b<a, NewPkRecordViewHolder> {
    public final com.bytedance.android.live.revlink.impl.pk.utils.m b;
    public final x31.o c;
    public final x31.p d;

    public static final class a {
        public int a;
        public f2 b;
        public int c;
        public Integer d;
        public String e;
        public int f;
        public String g;
        public h4 h;
        public int i;
        public JSONObject j;
        public Function1<? super Boolean, Unit> k;
        public int l;

        public a() {
            this.a = 8;
            this.d = 0;
            this.e = "";
            this.l = -1;
        }
    }

    public final void g(RecyclerView.ViewHolder r3) {
        NewPkRecordViewHolder r4 = (NewPkRecordViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        r4.f = null;
        CompositeDisposable r1 = r4.g;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        r4.g = null;
        ((PkTagsContainerView) ((RecyclerView.ViewHolder) r4).itemView.findViewById(2131388160)).c = 0;
    }

    public final void b(RecyclerView.ViewHolder r10, Object r12) {
        NewPkRecordViewHolder r0 = (NewPkRecordViewHolder) r10;
        a r8 = (a) r12;
        Intrinsics.checkNotNullParameter(r0, "holder");
        Intrinsics.checkNotNullParameter(r8, "item");
        r0.U3(r8.f, r8.g, r8.a, r8.b, r8.c, r8.d, r8.e, r8);
        com.bytedance.android.live.revlink.impl.pk.utils.m r13 = this.b;
        if (r13 == null) goto L6;
        r13.b();
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new NewPkRecordViewHolder(r4.inflate(2131566362, r5, false), this.c, this.d);
    }

    public d(com.bytedance.android.live.revlink.impl.pk.utils.m r2, x31.o r3, x31.p r4) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
