package iqb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.location.dto.POIInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends BaseAdapter {
    public final Context a;
    public List<POIInfo> b;

    /* JADX INFO: renamed from: iqb.a$a, reason: collision with other inner class name */
    public static final class C0279a {
        public TextView a;
        public TextView b;
        public ImageView c;

        public C0279a() {
        }
    }

    @Override // android.widget.Adapter
    public final long getItemId(int r3) {
        return r3;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.b.size();
    }

    public final POIInfo a(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < this.b.size()) goto L7;
        return null;
    L7:
        return (POIInfo) ListProtector.get(this.b, r2);
    }

    public final void b(List<POIInfo> r2) {
        this.b = new ArrayList(r2);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int r1) {
        return Integer.valueOf(r1);
    }

    public a(Context r2, List<POIInfo> r3) {
        new ArrayList();
        this.a = r2;
        this.b = r3;
    }

    @Override // android.widget.Adapter
    public final View getView(int r5, View r6, ViewGroup r7) {
        if (r6 != null) goto L5;
        r6 = LayoutInflater.from(this.a).inflate(2131563585, r7, false);
        C0279a r8 = new C0279a();
        r8.a = (TextView) r6.findViewById(2131390907);
        r8.c = (ImageView) r6.findViewById(2131376381);
        r8.b = (TextView) r6.findViewById(2131390906);
        r6.setTag(r8);
    L6:
        POIInfo r9 = (POIInfo) ListProtector.get(this.b, r5);
        r8.a.setText(r9.getLocationName());
        r8.b.setText(r9.getLocationAddress());
        ImageView r1 = r8.c;
        if (r9.getIsCurrent() == false) goto L9;
        int r2 = 0;
    L10:
        r1.setVisibility(r2);
        if (TextUtils.isEmpty(r9.getLocationAddress()) == false) goto L13;
        r8.b.setVisibility(8);
    L15:
        if (r9.getIsSelfDefine() == true) goto L17;
    L19:
        Context r10 = this.a;
        Drawable r11 = UDIconUtils.getIconDrawable(r10, 2131255042, UIUtils.getColor(r10, 2131108721));
    L20:
        if (r11 == null) goto L22;
        int r3 = UIUtils.dp2px(this.a, 16.0f);
        r11.setBounds(0, 0, r3, r3);
    L22:
        r8.a.setCompoundDrawables(r11, null, null, null);
        return r6;
    L17:
        if (r9.getIsCurrent() == true) goto L19;
        r11 = this.a.getResources().getDrawable(2131243876);
        goto L20
    L13:
        r8.b.setVisibility(0);
        goto L15
    L9:
        r2 = 8;
        goto L10
    L5:
        r8 = (C0279a) r6.getTag();
        goto L6
    }
}
