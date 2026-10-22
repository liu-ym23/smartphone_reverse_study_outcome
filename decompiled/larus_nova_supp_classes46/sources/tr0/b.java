package tr0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends BaseAdapter {
    public final Context a;
    public final List<Integer> b;
    public final ur0.a c;

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
        if (r1.contains(Integer.valueOf(r3)) == true) goto L5;
        List<Integer> r2 = this.b;
        ArrayList r4 = (ArrayList) r2;
        r4.add(Integer.valueOf(r3));
    L5:
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int r2) {
        return ListProtector.get(this.b, r2);
    }

    public b(Context r2, ur0.a r3) {
        this.b = new ArrayList();
        this.a = r2;
        this.c = r3;
    }

    @Override // android.widget.Adapter
    public final View getView(int r3, View r4, ViewGroup r5) {
        if (r4 != null) goto L4;
        r4 = LayoutInflater.from(this.a).inflate(2131561660, null);
    L4:
        LinearLayout r6 = (LinearLayout) r4.findViewById(2131371701);
        final int r7 = ((Integer) ListProtector.get(this.b, r3)).intValue();
        r6.setOnClickListener(new a(this, r7));
        TextView r8 = (TextView) r4.findViewById(2131371712);
        ImageView r0 = (ImageView) r4.findViewById(2131371705);
        switch(r7) {
            case 0: goto L15;
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L16;
        };
    L7:
        r8.setText(2131922945);
        r0.setImageDrawable(s1.m(2131248479));
        goto L16
    L8:
        r8.setText(2131922479);
        r0.setImageDrawable(s1.m(2131247659));
        goto L16
    L9:
        r8.setText(2131916166);
        r0.setImageDrawable(s1.m(2131233786));
        goto L16
    L10:
        r8.setText(2131915019);
        r0.setImageDrawable(s1.m(2131231366));
        goto L16
    L11:
        r8.setText(2131921240);
        r0.setImageDrawable(s1.m(2131247186));
        goto L16
    L12:
        r8.setText(2131920332);
        r0.setImageDrawable(s1.m(2131243935));
        goto L16
    L13:
        r8.setText(2131922330);
        r0.setImageDrawable(s1.m(2131247512));
        goto L16
    L14:
        r8.setText(2131916455);
        r0.setImageDrawable(s1.m(2131256460));
        goto L16
    L15:
        r8.setText(2131915301);
        r0.setImageDrawable(s1.m(2131235806));
    L16:
        r8.setTextColor(-1);
        if (wr0.b.f(r7).isEmpty() == false) goto L19;
        r4.setVisibility(8);
    L19:
        return r4;
    }
}
