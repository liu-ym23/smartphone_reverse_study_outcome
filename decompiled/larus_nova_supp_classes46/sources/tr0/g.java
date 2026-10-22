package tr0;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import sr0.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends BaseAdapter {
    public final Context a;
    public final List<Integer> b;
    public final ur0.b c;
    public int d;

    @Override // android.widget.Adapter
    public final long getItemId(int r3) {
        return r3;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return ((ArrayList) this.b).size();
    }

    public final void a(int r3) {
        List<Integer> r0 = this.b;
        ArrayList r1 = (ArrayList) r0;
        if (r1.contains(Integer.valueOf(r3)) == true) goto L6;
        List<Integer> r2 = this.b;
        ArrayList r4 = (ArrayList) r2;
        r4.add(Integer.valueOf(r3));
        notifyDataSetChanged();
        return;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int r2) {
        return (Integer) ListProtector.get(this.b, r2);
    }

    public g(Context r2, i r3) {
        this.b = new ArrayList();
        this.d = 0;
        this.a = r2;
        this.c = r3;
    }

    @Override // android.widget.Adapter
    public final View getView(final int r3, View r4, ViewGroup r5) {
        if (r4 != null) goto L4;
        r4 = LayoutInflater.from(this.a).inflate(2131561658, null);
    L4:
        Button r6 = (Button) r4.findViewById(2131365041);
        String r0 = wr0.b.h(((Integer) ListProtector.get(this.b, r3)).intValue()).get("data_performance_title");
        if (r6 != null) goto L7;
    L10:
        return r4;
    L7:
        if (TextUtils.isEmpty(r0) == true) goto L10;
        r6.setText(r0);
        r6.setOnClickListener(new f(this, r3));
        goto L10
    }
}
