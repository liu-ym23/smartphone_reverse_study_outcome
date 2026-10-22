package xib;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.ss.android.lark.forwardv3.recentforward.RecentForwardAdapterV3;
import com.ss.android.lark.forwardv3.recentforward.viewholder.RecentForwardViewHolder;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class e<Data extends SearchBaseInfo> extends a<Data, RecentForwardViewHolder> {
    public final RecentForwardAdapterV3.b b;
    public final RecentForwardAdapterV3.a c;

    public abstract void b(SearchBaseInfo r1, RecentForwardViewHolder r2);

    public e(RecentForwardAdapterV3.b r2, RecentForwardAdapterV3.a r3) {
        Intrinsics.checkNotNullParameter(r2, "itemClickHandler");
        Intrinsics.checkNotNullParameter(r3, "onItemBusinessConsumeClickListener");
        this.b = r2;
        this.c = r3;
    }

    public final void a(int r5, Data r6, RecentForwardViewHolder r7) {
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r7, "holder");
        TextView r2 = r7.d;
        if (r2 == null) goto L5;
        r2.setText(r6.getTitle());
    L5:
        UDCheckBox r3 = r7.c;
        if (r3 != null) goto L8;
    L12:
        UDCheckBox r4 = r7.c;
        if (r4 == null) goto L15;
        r4.setChecked(r6.isSelected());
    L15:
        b(r6, r7);
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r7, "holder");
        LinearLayout r8 = r7.f;
        if (r8 == null) goto L19;
        r8.setOnClickListener(new d(this, r6, r5));
        return;
    L19:
        return;
    L8:
        if (this.a == false) goto L10;
        int r9 = 0;
    L11:
        r3.setVisibility(r9);
        goto L12
    L10:
        r9 = 8;
        goto L11
    }

    public final void c(SearchBaseInfo r3, RecentForwardViewHolder r4, List r5) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "payloads");
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L17;
        if (Intrinsics.areEqual(r6.next(), "view_checkbox") == false) goto L4;
        UDCheckBox r0 = r4.c;
        if (r0 != null) goto L10;
    L14:
        UDCheckBox r1 = r4.c;
        if (r1 == null) goto L4;
        r1.setChecked(r3.isSelected());
        goto L4
    L10:
        if (this.a == false) goto L12;
        int r2 = 0;
    L13:
        r0.setVisibility(r2);
        goto L14
    L12:
        r2 = 8;
        goto L13
    }
}
