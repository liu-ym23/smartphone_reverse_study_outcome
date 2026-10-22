package mab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.custom.repeat.entity.RruleListItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends BaseAdapter {
    public int a;
    public final Context b;
    public final ArrayList<RruleListItem> c;

    public final class a {
        public TextView a;
        public ImageView b;

        public a() {
        }
    }

    @Override // android.widget.Adapter
    public final long getItemId(int r3) {
        return r3;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int r2) {
        return ((RruleListItem) ListProtector.get(this.c, r2)).getDisplayText();
    }

    public e(List<RruleListItem> r2, int r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "rruleList");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.a = r3;
        this.b = r4;
        ArrayList<RruleListItem> r5 = new ArrayList();
        r5.addAll(r2);
        this.c = r5;
    }

    @Override // android.widget.Adapter
    public final View getView(int r5, View r6, ViewGroup r7) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        if (r6 != null) goto L5;
        a r8 = new a();
        View r9 = LayoutInflater.from(this.b).inflate(2131561582, null, true);
        r8.a = (TextView) r9.findViewById(2131391286);
        r8.b = (ImageView) r9.findViewById(2131376551);
        r9.setTag(r8);
    L6:
        TextView r0 = r8.a;
        if (r0 == null) goto L9;
        r0.setText(((RruleListItem) ListProtector.get(this.c, r5)).getDisplayText());
    L9:
        TextView r1 = r8.a;
        if (r1 == null) goto L12;
        r1.setTextColor(qab.c.a(this.b, 2131106622));
    L12:
        ImageView r2 = r8.b;
        if (r2 == null) goto L16;
        r2.setVisibility(8);
    L16:
        if (this.a != r5) goto L23;
        TextView r10 = r8.a;
        if (r10 == null) goto L20;
        r10.setTextColor(qab.c.a(this.b, 2131102121));
    L20:
        ImageView r11 = r8.b;
        if (r11 == null) goto L23;
        r11.setVisibility(0);
    L23:
        return r9;
    L5:
        Object r12 = r6.getTag();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.ss.android.lark.custom.repeat.adapter.RepeatAdapter.ViewHolder");
        a r13 = (a) r12;
        r9 = r6;
        r8 = r13;
        goto L6
    }
}
