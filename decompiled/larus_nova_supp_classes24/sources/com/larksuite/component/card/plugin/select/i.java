package com.larksuite.component.card.plugin.select;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$OptionsItemModel;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.ui.navigation.LKUISearchView;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.framework.apiplugin.LKEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i {
    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void a(LKEvent r17, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r19, final com.larksuite.component.card.plugin.b r110, com.larksuite.component.card.plugin.c r20) {
        Intrinsics.checkNotNullParameter(r17, "lkEvent");
        Intrinsics.checkNotNullParameter(r19, "request");
        Intrinsics.checkNotNullParameter(r110, "getImageKey");
        Intrinsics.checkNotNullParameter(r20, "onMultiItemClick");
        ArrayList r2 = new ArrayList();
        ArrayList<String> r4 = r19.initialOptions;
        Iterator<T> r6 = r19.options.iterator();
    L3:
        boolean r8 = false;
        if (r6.hasNext() == false) goto L15;
        UniversalCardShowSelectMenuPluginModel$OptionsItemModel r7 = (UniversalCardShowSelectMenuPluginModel$OptionsItemModel) r6.next();
        if (TextUtils.isEmpty(r7.text) == false) goto L8;
        r7.text = "";
    L8:
        r2.add(r7.text);
        if (r4 == null) goto L13;
        if (r4.contains(r7.value) != true) goto L13;
        r8 = true;
    L13:
        r7.isSelected = r8;
        goto L3
    L15:
        if (r2.size() >= 8) goto L29;
        MultiSelectMenuAdapter r5 = new MultiSelectMenuAdapter(r17.getContext(), r110);
        ArrayList<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> r0 = r19.options;
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r5.l = r0;
        ArrayList r1 = new ArrayList();
        ArrayList<String> r9 = r19.initialOptions;
        if (r9 == null) goto L28;
        Iterator<T> r10 = r9.iterator();
    L20:
        if (r10.hasNext() == false) goto L28;
        String r14 = (String) r10.next();
        ArrayList<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> r15 = r19.options;
        ArrayList r11 = new ArrayList();
        Iterator<T> r16 = r15.iterator();
    L23:
        if (r16.hasNext() == false) goto L27;
        Object r12 = r16.next();
        if (((UniversalCardShowSelectMenuPluginModel$OptionsItemModel) r12).value.equals(r14) == false) goto L23;
        r11.add(r12);
        goto L23
    L27:
        r1.addAll(r11);
    L28:
        View r13 = LayoutInflater.from(r17.getContext()).inflate(2131568127, null);
        r08.a r3 = (r08.a) ((r08.a) ((r08.a) new r08.a(r17.getContext()).style(2131952044)).items(r2).autoDismiss(false)).rootLayoutRes(2131568121);
        r3.a = 500.0f;
        UDDialog r21 = ((r08.a) ((r08.a) r3.headerLayout(r13)).lifecycleCallback(new g())).adapter(r5).itemClickListener(new h(r19, r1, r5)).show();
        r13.findViewById(2131366997).setOnClickListener(new e(r21));
        r13.findViewById(2131367647).setOnClickListener(new f(r20, r1, r21));
        r13.findViewById(2131385804).setVisibility(8);
        return;
    L29:
        Context r22 = r17.getContext();
        MultiSelectMenuAdapter r23 = new MultiSelectMenuAdapter(r22, new ShowMultiSelectStaticMenuPanel$showMultiFullScreenMenu$adapter$1(r110));
        ArrayList<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> r24 = r19.options;
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        r23.l = r24;
        ArrayList r25 = new ArrayList();
        ArrayList<String> r26 = r19.initialOptions;
        if (r26 == null) goto L41;
        Iterator<T> r27 = r26.iterator();
    L33:
        if (r27.hasNext() == false) goto L41;
        String r29 = (String) r27.next();
        ArrayList<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> r30 = r19.options;
        ArrayList r111 = new ArrayList();
        Iterator<T> r31 = r30.iterator();
    L36:
        if (r31.hasNext() == false) goto L40;
        Object r112 = r31.next();
        if (((UniversalCardShowSelectMenuPluginModel$OptionsItemModel) r112).value.equals(r29) == false) goto L36;
        r111.add(r112);
        goto L36
    L40:
        r25.addAll(r111);
    L41:
        String[] r32 = (String[]) r2.toArray(new String[0]);
        View r33 = LayoutInflater.from(r22).inflate(2131568127, null);
        View r34 = LayoutInflater.from(r22).inflate(2131559937, null);
        RecyclerView r35 = r34.findViewById(2131378559);
        int r113 = j.a;
        if (r32.length <= Integer.MAX_VALUE) goto L47;
        if (r35 == null) goto L47;
        CenterSmoothScroller r114 = new CenterSmoothScroller(r22);
        r114.setTargetPosition(LKUIToast.DURATION_MAX);
        RecyclerView.LayoutManager r115 = r35.getLayoutManager();
        if (r115 == null) goto L47;
        r115.startSmoothScroll(r114);
    L47:
        com.larksuite.component.ui.dialog.i r116 = new com.larksuite.component.ui.dialog.i(r22);
        r116.n((CharSequence[]) Arrays.copyOf(r32, r32.length));
        r116.c.width(1.0f);
        r116.f(1.0f);
        r116.c.marginInDp(0);
        r116.c.headerLayout(r33);
        r116.c.contentLayout(r34);
        r116.c.rootLayoutRes(2131564286);
        r116.g(new c(r22));
        r116.c.autoDismiss(false);
        r116.g.adapter(r23);
        r116.f = new d(r23, r25);
        LKUIDialog r36 = r116.i();
        View r37 = r33.findViewById(2131366997);
        LKUISearchView r117 = (LKUISearchView) r33.findViewById(2131385804);
        r37.setOnClickListener(new a(r117, r36));
        r33.findViewById(2131367647).setOnClickListener(new b(r20, r25, r36));
        Intrinsics.checkNotNull(r117);
        Intrinsics.checkNotNull(r34);
        Intrinsics.checkNotNull(r35);
        j.b(r117, r34, r35, r23, r32, r19);
    }
}
