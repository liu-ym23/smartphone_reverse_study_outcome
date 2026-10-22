package com.larksuite.component.card.plugin.select;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$OptionsItemModel;
import com.larksuite.component.card.plugin.model.UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.ui.navigation.LKUIClearEditText;
import com.larksuite.component.ui.navigation.LKUISearchView;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.dialog.UDBaseListDialogBuilder;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.utils.f0;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.y0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    public static final class a implements TextWatcher {
        public final /* synthetic */ RecyclerView a;
        public final /* synthetic */ LinearLayout b;
        public final /* synthetic */ SelectMenuAdapter c;
        public final /* synthetic */ UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel d;
        public final /* synthetic */ String[] e;
        public final /* synthetic */ TextView f;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r2) {
            Intrinsics.checkNotNullParameter(r2, "s");
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r1, "s");
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r9, int r10, int r11, int r12) {
            Intrinsics.checkNotNullParameter(r9, "input");
            if (r9.length() != 0) goto L5;
            boolean r13 = true;
        L7:
            if (r13 == false) goto L9;
            this.a.setVisibility(0);
            this.b.setVisibility(8);
            SelectMenuAdapter r14 = this.c;
            ArrayList<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> r15 = this.d.options;
            r14.getClass();
            Intrinsics.checkNotNullParameter(r15, "<set-?>");
            r14.l = r15;
            SelectMenuAdapter r16 = this.c;
            int r17 = j.a;
            r16.A2(j.a(this.e));
            return;
        L9:
            int r19 = j.a;
            ArrayList<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> r110 = this.d.options;
            ArrayList r1 = new ArrayList();
            String[] r4 = null;
            if (f0.a(r9.toString()) == true) goto L21;
            int r2 = r110.size();
            int r5 = 0;
        L13:
            if (r5 >= r2) goto L19;
            if (StringsKt.contains$default(((UniversalCardShowSelectMenuPluginModel$OptionsItemModel) ListProtector.get(r110, r5)).text, r9, false, 2, null) == false) goto L17;
            r1.add(ListProtector.get(r110, r5));
        L17:
            r5 = r5 + 1;
            goto L13
        L19:
            if (r1.size() <= 0) goto L21;
        L22:
            int r111 = j.a;
            ArrayList<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> r112 = this.d.options;
            ArrayList r3 = new ArrayList();
            if (f0.a(r9.toString()) == true) goto L34;
            int r6 = r112.size();
            int r7 = 0;
        L26:
            if (r7 >= r6) goto L32;
            if (StringsKt.contains$default(((UniversalCardShowSelectMenuPluginModel$OptionsItemModel) ListProtector.get(r112, r7)).text, r9, false, 2, null) == false) goto L30;
            r3.add(((UniversalCardShowSelectMenuPluginModel$OptionsItemModel) ListProtector.get(r112, r7)).text);
        L30:
            r7 = r7 + 1;
            goto L26
        L32:
            if (r3.size() <= 0) goto L34;
            r4 = (String[]) r3.toArray(new String[0]);
        L34:
            if (r4 != null) goto L36;
            this.a.setVisibility(8);
            this.b.setVisibility(0);
            int r113 = j.a;
            TextView r114 = this.f;
            Intrinsics.checkNotNull(r114);
            String r115 = UIHelper.mustacheFormat(2131892028, "search_key", r9.toString());
            Intrinsics.checkNotNull(r115);
            int r116 = StringsKt.indexOf$default(r115, r9.toString(), 0, false, 6, null);
            r114.setText(y0.b(r115, r116, r9.length() + r116, r9.toString(), ContextCompat.getColor(r114.getContext(), 2131103456)));
            return;
        L36:
            this.a.setVisibility(0);
            this.b.setVisibility(8);
            if (r1 == null) goto L39;
            SelectMenuAdapter r20 = this.c;
            r20.getClass();
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r20.l = r1;
        L39:
            this.c.A2(j.a(r4));
            return;
        L21:
            r1 = null;
            goto L22
        L5:
            r13 = false;
            goto L7
        }

        public a(RecyclerView r1, LinearLayout r2, SelectMenuAdapter r3, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r4, String[] r5, TextView r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    static {
    }

    public j() {
    }

    public static final List a(String[] r5) {
        ArrayList r0 = new ArrayList();
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(new UDBaseListDialogBuilder.ListItemBuilder(r5[r2]).build());
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void c(LKEvent r12, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r13, final com.larksuite.component.card.plugin.d r14, com.larksuite.component.card.plugin.e r15) {
        Intrinsics.checkNotNullParameter(r12, "lkEvent");
        Intrinsics.checkNotNullParameter(r13, "request");
        Intrinsics.checkNotNullParameter(r14, "getImageKey");
        Intrinsics.checkNotNullParameter(r15, "onItemClick");
        ArrayList r0 = new ArrayList();
        ArrayList<String> r1 = r13.initialOptions;
        if (r1 == null) goto L5;
        String r2 = (String) CollectionsKt.getOrNull(r1, 0);
    L6:
        Iterator<T> r4 = r13.options.iterator();
    L8:
        if (r4.hasNext() == false) goto L14;
        UniversalCardShowSelectMenuPluginModel$OptionsItemModel r5 = (UniversalCardShowSelectMenuPluginModel$OptionsItemModel) r4.next();
        if (TextUtils.isEmpty(r5.text) == false) goto L12;
        r5.text = "";
    L12:
        r0.add(r5.text);
        r5.isSelected = y0.a(r2, r5.value);
        goto L8
    L14:
        if (r0.size() >= 8) goto L16;
        SelectMenuAdapter r3 = new SelectMenuAdapter(r12.getContext(), 2131568128, r14);
        ArrayList<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> r16 = r13.options;
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r3.l = r16;
        ((UDActionPanelBuilder) new UDActionPanelBuilder(r12.getContext()).items(r0).adapter(r3).itemClickListener(new n(r15, r13)).addActionButton(2131391775, 2131891960, null)).show();
        return;
    L16:
        Context r17 = r12.getContext();
        SelectMenuAdapter r9 = new SelectMenuAdapter(r17, 2131568125, new ShowSelectStaticMenuPanel$showFullScreenMenu$adapter$1(r14));
        ArrayList<UniversalCardShowSelectMenuPluginModel$OptionsItemModel> r19 = r13.options;
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r9.l = r19;
        String[] r10 = (String[]) r0.toArray(new String[0]);
        View r110 = LayoutInflater.from(r17).inflate(2131568127, null);
        View r7 = LayoutInflater.from(r17).inflate(2131559937, null);
        RecyclerView r8 = r7.findViewById(2131378559);
        if (r10.length <= Integer.MAX_VALUE) goto L22;
        if (r8 == null) goto L22;
        CenterSmoothScroller r6 = new CenterSmoothScroller(r17);
        r6.setTargetPosition(LKUIToast.DURATION_MAX);
        RecyclerView.LayoutManager r11 = r8.getLayoutManager();
        if (r11 == null) goto L22;
        r11.startSmoothScroll(r6);
    L22:
        com.larksuite.component.ui.dialog.i r20 = new com.larksuite.component.ui.dialog.i(r17);
        r20.n((CharSequence[]) Arrays.copyOf(r10, r10.length));
        r20.c.width(1.0f);
        r20.f(1.0f);
        r20.c.marginInDp(0);
        r20.c.headerLayout(r110);
        r20.c.contentLayout(r7);
        r20.c.rootLayoutRes(2131564286);
        r20.g(new l(r17));
        r20.g.adapter(r9);
        r20.f = new m(r15, r9);
        LKUIDialog r111 = r20.i();
        View r112 = r110.findViewById(2131366997);
        LKUISearchView r21 = (LKUISearchView) r110.findViewById(2131385804);
        r112.setOnClickListener(new k(r21, r111));
        r110.findViewById(2131367647).setVisibility(8);
        Intrinsics.checkNotNull(r21);
        Intrinsics.checkNotNull(r7);
        Intrinsics.checkNotNull(r8);
        b(r21, r7, r8, r9, r10, r13);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static void b(LKUISearchView r8, View r9, RecyclerView r10, SelectMenuAdapter r11, String[] r12, UniversalCardShowSelectMenuPluginModel$UniversalCardShowSelectMenuRequestModel r13) {
        Intrinsics.checkNotNullParameter(r8, "searchView");
        Intrinsics.checkNotNullParameter(r9, "contentView");
        Intrinsics.checkNotNullParameter(r10, "searchRv");
        Intrinsics.checkNotNullParameter(r11, "adapter");
        Intrinsics.checkNotNullParameter(r12, "textArray");
        Intrinsics.checkNotNullParameter(r13, "request");
        LinearLayout r3 = (LinearLayout) r9.findViewById(2131378676);
        TextView r7 = (TextView) r9.findViewById(2131390562);
        r8.setCancelEnabled(false);
        a r14 = new a(r10, r3, r11, r13, r12, r7);
        LKUIClearEditText r15 = r8.w;
        if (r15 == null) goto L6;
        r15.addTextChangedListener(r14);
        return;
    }
}
