package a6b;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.chat.message.menu.v2.adapter.binder.ContentMessageActionViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends a {
    @Override // a6b.a
    public final int d() {
        return 2131561617;
    }

    @Override // a6b.a
    public final String e() {
        return "GridContentAdapterBinder";
    }

    public d() {
    }

    @Override // a6b.a, a6b.e
    public final /* bridge */ /* synthetic */ void c(RecyclerView.ViewHolder r1, zya.e r2) {
        f((ContentMessageActionViewHolder) r1, (zya.b) r2);
    }

    @Override // a6b.a
    public final void f(ContentMessageActionViewHolder r2, zya.b r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "itemData");
        super.f(r2, r3);
        zya.c r4 = r3.l;
        if (r4 != null) goto L5;
        return;
    L5:
        r2.d.setTextSize(r4.a);
    }
}
