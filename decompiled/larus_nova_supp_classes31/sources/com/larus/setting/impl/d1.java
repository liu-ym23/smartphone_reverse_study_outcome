package com.larus.setting.impl;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.setting.api.data.FlowSettingsScene;
import com.larus.setting.impl.databinding.LarusPageNotifySettingBinding;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class d1 implements Function1 {
    public final /* synthetic */ NotifySettingsFragment a;
    public final /* synthetic */ int b;
    public final /* synthetic */ LarusPageNotifySettingBinding c;

    public /* synthetic */ d1(NotifySettingsFragment r1, int r2, LarusPageNotifySettingBinding r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r11) {
        NotifySettingsFragment r0 = this.a;
        int r1 = this.b;
        LarusPageNotifySettingBinding r2 = this.c;
        List r12 = (List) r11;
        int r3 = NotifySettingsFragment.j;
        Intrinsics.checkNotNullParameter(r12, "sections");
        LarusPageNotifySettingBinding r4 = r0.e;
        if (r1 != r0.h) goto L16;
        if (r4 != r2) goto L16;
        Context r5 = r4.a.getContext();
        r4.b.removeAllViews();
        Iterator r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L19;
        zs9.c r6 = (zs9.c) r13.next();
        LinearLayout r7 = new LinearLayout(r5);
        r7.setOrientation(1);
        r7.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r7.setPadding(0, j19.c.c(8), 0, 0);
        TextView r8 = new TextView(r5);
        LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(-1, -2);
        r9.setMargins(0, 0, 0, j19.c.c(8));
        r8.setLayoutParams(r9);
        r8.setText(r6.b);
        r8.setTextSize(16.0f);
        r8.setTextColor(r5.getResources().getColor(2131103143));
        r8.setPadding(j19.c.c(4), 0, j19.c.c(4), 0);
        Intrinsics.checkNotNull(r5);
        ItemGroup r10 = new ItemGroup(r5);
        r10.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        Iterator<zs9.b> r14 = r6.c.iterator();
    L11:
        if (r14.hasNext() == false) goto L13;
        zs9.b r15 = r14.next();
        int r16 = et9.d.a;
        et9.d.a(FlowSettingsScene.NOTIFY, r10, r15);
        goto L11
    L13:
        r7.addView(r8);
        r7.addView(r10);
        r4.b.addView(r7);
        goto L8
    L19:
        return Unit.INSTANCE;
    L16:
        return Unit.INSTANCE;
    }
}
