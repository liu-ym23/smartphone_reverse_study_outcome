package a6b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.o0;
import com.ss.android.lark.chat.message.menu.v2.adapter.binder.CategoryTitleHolder;
import com.ss.android.lark.chat.message.menu.v2.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements e<zya.a, CategoryTitleHolder> {
    public c() {
    }

    @Override // a6b.e
    public final /* synthetic */ void b(j0 r1) {
    }

    @Override // a6b.e
    public final RecyclerView.ViewHolder a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r5 = o0.a(r4).inflate(2131561616, r4, false);
        Intrinsics.checkNotNull(r5);
        return new CategoryTitleHolder(r5);
    }

    @Override // a6b.e
    public final void c(RecyclerView.ViewHolder r2, zya.e r3) {
        CategoryTitleHolder r4 = (CategoryTitleHolder) r2;
        zya.a r5 = (zya.a) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "itemData");
        TextView r6 = r4.a;
        r5.getClass();
        r6.setText(null);
    }
}
