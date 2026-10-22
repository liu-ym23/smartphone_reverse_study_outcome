package com.bytedance.android.live.adapter.binding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.r3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.drakeet.multitype.b;
import mx.l;
import rm3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class SwitchSettingItemBinder<T extends l> extends b<T, SwitchSettingViewHolder> {
    public Function1<? super SwitchSettingViewHolder, Unit> b;
    public final boolean c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ l a;
        public final /* synthetic */ SwitchSettingViewHolder b;

        public a(l r1, SwitchSettingViewHolder r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            l r6 = this.a;
            if (r6.i == false) goto L5;
            boolean r7 = !this.b.d.isChecked();
            if (this.a.b(r7) == true) goto L11;
            this.b.d.setChecked(r7);
        L11:
            this.a.c(this.b, r7);
            return;
        L5:
            if ((!StringsKt.isBlank(r6.j)) == false) goto L13;
            String r8 = c.a;
            c.g(s1.getContext(), this.a.j, 0, true, 16);
            return;
        }
    }

    public SwitchSettingItemBinder(boolean r1) {
        this.c = r1;
    }

    public /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r1, Object r2) {
        h((SwitchSettingViewHolder) r1, (l) r2);
    }

    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder d(LayoutInflater r1, ViewGroup r2) {
        return i(r1, r2);
    }

    public void h(SwitchSettingViewHolder r6, final T r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "item");
        ALogger.d("SwitchSettingItem", r7.e + ", check: " + r7.l + ", holder: " + r6.hashCode());
        r7.e();
        r6.T3(r7);
        final LiveSwitchButton r0 = r6.d;
        r0.setOnCheckedChangeListener(null);
        r0.setOnClickListener(null);
        r6.d.setChecked(r7.l);
        if (r7.i == false) goto L5;
        float r1 = 1.0f;
    L6:
        r0.setAlpha(r1);
        r6.f.setVisibility(8);
        View.OnClickListener r2 = r7.f();
        if (r2 == null) goto L9;
        r6.f.setVisibility(0);
        r6.f.setOnClickListener(r2);
    L9:
        TextView r3 = r6.e;
        if (r3 == null) goto L12;
        r3.setVisibility(8);
    L12:
        r6.d.setOnClickListener(new a(r7, r6));
        if (this.c == false) goto L26;
        TextView r4 = r6.a;
        if (r4 == null) goto L17;
        r4.setTextColor(s1.h(2131107294));
    L17:
        TextView r5 = r6.b;
        if (r5 == null) goto L20;
        r5.setTextColor(s1.h(2131107300));
    L20:
        TextView r8 = r6.e;
        if (r8 == null) goto L23;
        r8.setTextColor(s1.h(2131107300));
    L23:
        LiveSwitchButton r9 = r6.d;
        if (r9 == null) goto L26;
        r9.setSwitchBackgroundColor(s1.h(2131107301));
    L26:
        ((RecyclerView.ViewHolder) r6).itemView.setFocusable(true);
        ((RecyclerView.ViewHolder) r6).itemView.setClickable(true);
        r3.e(((RecyclerView.ViewHolder) r6).itemView, new SwitchSettingItemBinder$onBindViewHolder$4(r7, r0));
        return;
    L5:
        r1 = 0.5f;
        goto L6
    }

    public SwitchSettingViewHolder i(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        SwitchSettingViewHolder r5 = new SwitchSettingViewHolder(r3.inflate(2131567939, r4, false));
        r5.d.setEnableEffect(false);
        Function1<? super SwitchSettingViewHolder, Unit> r6 = this.b;
        if (r6 == null) goto L5;
        Unit r7 = (Unit) r6.invoke(r5);
    L5:
        return r5;
    }
}
