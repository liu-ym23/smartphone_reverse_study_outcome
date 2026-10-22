package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftEffectConfigurationDialog$adapter$1 extends BaseAdapter {
    public final List<i> a;
    public final Lazy b;
    public final /* synthetic */ GiftEffectConfigurationDialog c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.f;
            if (r2 == null) goto L6;
            Unit r3 = (Unit) r2.invoke();
            return;
        }
    }

    public static final class b implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ i a;
        public final /* synthetic */ Switch b;

        public b(i r1, Switch r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r1, boolean r2) {
            if (r1.isPressed() == false) goto L6;
            this.a.d.invoke(this.b);
            return;
        }
    }

    @Override // android.widget.Adapter
    public final long getItemId(int r3) {
        return r3;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.a.size();
    }

    public GiftEffectConfigurationDialog$adapter$1(GiftEffectConfigurationDialog r1) {
        this.c = r1;
        n r2 = r1.d;
        if (r2 == null) goto L6;
        List<i> r3 = r2.a();
        if (r3 == null) goto L6;
    L7:
        this.a = r3;
        this.b = LazyKt.lazy(new GiftEffectConfigurationDialog$adapter$1$inflater$2(this));
        return;
    L6:
        r3 = CollectionsKt.emptyList();
        goto L7
    }

    @Override // android.widget.Adapter
    public final Object getItem(int r2) {
        return ListProtector.get(this.a, r2);
    }

    @Override // android.widget.Adapter
    public final View getView(int r5, View r6, ViewGroup r7) {
        boolean r0 = false;
        if (r6 != null) goto L5;
        r6 = ((LayoutInflater) this.b.getValue()).inflate(2131565238, r7, false);
    L5:
        i r8 = (i) ListProtector.get(this.a, r5);
        TextView r9 = (TextView) r6.findViewById(2131373695);
        ImageView r1 = (ImageView) r6.findViewById(2131375291);
        Switch r2 = (Switch) r6.findViewById(2131373693);
        r9.setText(r8.b);
        if (r8.g.length() <= 0) goto L8;
        r0 = true;
    L8:
        if (r0 == false) goto L11;
        r1.setContentDescription(r8.g);
    L11:
        if (r8.e == false) goto L13;
        UtilityKotlinExtentionsKt.w(r1);
        r1.setOnClickListener(new a(r8));
    L14:
        r2.setOnCheckedChangeListener(null);
        r8.c.invoke(r2);
        r2.setOnCheckedChangeListener(new b(r8, r2));
        r2.setTrackDrawable(s1.m(2131250338));
        return r6;
    L13:
        UtilityKotlinExtentionsKt.t(r1);
        goto L14
    }
}
