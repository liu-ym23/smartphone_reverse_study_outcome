package com.larus.e_commerce.impl.applet.panel;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.base.api.ai.framework.model.PanelItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.applog.api.IApplog;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import o89.o;
import o89.p;
import o89.r;
import org.json.JSONObject;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \"2\u00020\u0001:\u0004\"#$%B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/e_commerce/impl/applet/panel/ECAppletPanel;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "scene", "", "items", "", "Lcom/bytedance/android/ec/base/api/ai/framework/model/PanelItem;", "extra", "", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)V", "firstItemAdapter", "Lcom/larus/e_commerce/impl/applet/panel/ECAppletPanel$MenuAdapter;", "secondItemAdapter", "thirdItemAdapter", "allItems", "reportedShowItemKeys", "", "mergeItems", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "refreshPanelHandler", "Lkotlin/Function0;", "refreshPanelItems", "reportNewVisibleItems", "setupContentView", "show", "dismiss", "adjustLayout", "Companion", "MenuAdapter", "MenuViewHolder", "HorizontalSpaceDecoration", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ECAppletPanel extends AppCompatDialog {
    public static final Lazy<uq9.f> i = null;
    public static final Map<String, List<String>> j = null;
    public final String a;
    public final List<PanelItem> b;
    public final c c;
    public final c d;
    public final c e;
    public List<PanelItem> f;
    public final Set<String> g;
    public final i h;

    public static final class a {
    }

    public static final class b extends RecyclerView.ItemDecoration {
        public final int a;

        public b(int r1) {
            this.a = r1;
        }

        public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
            Intrinsics.checkNotNullParameter(r2, "outRect");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "state");
            int r6 = r4.getChildAdapterPosition(r3);
            if (r6 != (-1)) goto L5;
            return;
        L5:
            if (r6 != 0) goto L7;
            int r7 = 0;
        L8:
            r2.left = r7;
            return;
        L7:
            r7 = this.a;
            goto L8
        }
    }

    public static final class c extends RecyclerView.Adapter<d> {
        public final String a;
        public final Function1<PanelItem, Unit> b;
        public final ArrayList<PanelItem> c;

        public static final class a<T> implements Comparator {
            public a() {
            }

            @Override // java.util.Comparator
            public final int compare(T r1, T r2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((PanelItem) r1).getOrder()), Integer.valueOf(((PanelItem) r2).getOrder()));
            }
        }

        public static final class b<T> implements Comparator {
            public final /* synthetic */ Comparator a;

            public b(a r1) {
                this.a = r1;
            }

            @Override // java.util.Comparator
            public final int compare(T r2, T r3) {
                int r0 = this.a.compare(r2, r3);
                if (r0 == 0) goto L6;
                return r0;
            L6:
                return ComparisonsKt.compareValues(((PanelItem) r2).getKey(), ((PanelItem) r3).getKey());
            }
        }

        public final int getItemCount() {
            return this.c.size();
        }

        public final void submit(List<PanelItem> r4) {
            Intrinsics.checkNotNullParameter(r4, "menuItems");
            this.c.clear();
            this.c.addAll(CollectionsKt.sortedWith(r4, new b(new a())));
            notifyDataSetChanged();
        }

        public c(String r2, Function1<? super PanelItem, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            Intrinsics.checkNotNullParameter(r3, "onClickItem");
            this.a = r2;
            this.b = r3;
            this.c = new ArrayList();
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
            final d r12 = (d) r10;
            Intrinsics.checkNotNullParameter(r12, "holder");
            final PanelItem r13 = (PanelItem) ListProtector.get(this.c, r11);
            r12.getClass();
            Intrinsics.checkNotNullParameter(r13, "item");
            String r0 = r13.getIconUrl();
            String r1 = r13.getIcon();
            if (r1 == null) goto L5;
            Integer r2 = r12.e.get(r1);
        L6:
            if (r0 != null) goto L8;
        L11:
            boolean r3 = true;
        L12:
            if (r3 == true) goto L31;
            r12.c.setTag(r0);
            r12.c.setImageDrawable(null);
            Context r4 = ((RecyclerView.ViewHolder) r12).itemView.getContext();
        L15:
            if ((r4 instanceof ContextWrapper) == false) goto L24;
            if ((r4 instanceof LifecycleOwner) == true) goto L18;
            Context r5 = ((ContextWrapper) r4).getBaseContext();
            if (r5 == r4) goto L26;
            r4 = r5;
        L26:
            LifecycleOwner r6 = null;
        L27:
            if (r6 == null) goto L34;
            LifecycleCoroutineScope r7 = LifecycleOwnerKt.getLifecycleScope(r6);
            if (r7 == null) goto L34;
            BuildersKt.launch$default(r7, null, null, new ECAppletPanel$MenuViewHolder$bind$1(r0, r12, null), 3, null);
        L34:
            r12.d.setText(r13.getTitle());
            ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new l(r12, r13));
            return;
        L18:
            r6 = (LifecycleOwner) r4;
            goto L27
        L24:
            if ((r4 instanceof LifecycleOwner) == false) goto L26;
            r6 = (LifecycleOwner) r4;
            goto L27
        L31:
            if (r2 == null) goto L33;
            r12.c.setImageResource(r2.intValue());
            goto L34
        L33:
            r12.c.setImageDrawable(null);
            goto L34
        L8:
            if (StringsKt.isBlank(r0) == true) goto L11;
            r3 = false;
            goto L12
        L5:
            r2 = null;
            goto L6
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562326, r3, false);
            Intrinsics.checkNotNull(r5);
            return new d(r5, this.a, this.b);
        }
    }

    public static final class d extends RecyclerView.ViewHolder {
        public final String a;
        public final Function1<PanelItem, Unit> b;
        public final ImageView c;
        public final TextView d;
        public final Map<String, Integer> e;

        public d(View r2, String r3, Function1<? super PanelItem, Unit> r4) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "scene");
            Intrinsics.checkNotNullParameter(r4, "onClickItem");
            super(r2);
            this.a = r3;
            this.b = r4;
            this.c = (ImageView) r2.findViewById(2131363167);
            this.d = (TextView) r2.findViewById(2131363168);
            this.e = MapsKt.mapOf(TuplesKt.to("customer_service", 2131240696));
        }
    }

    static {
        i = LazyKt.lazy(new com.larus.e_commerce.impl.applet.panel.a());
        j = MapsKt.mapOf(new Pair[]{TuplesKt.to("order_list", CollectionsKt.listOf("order_list")), TuplesKt.to("cart", CollectionsKt.listOf("cart")), TuplesKt.to("a1.b1734", CollectionsKt.listOf("a1.b1734"))});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.util.ArrayList] */
    public final List<PanelItem> L0() {
        q89.c r1 = p.a;
        Intrinsics.checkNotNullParameter(this.a, "scene");
        q89.c r2 = p.a;
        if (r2 == null) goto L25;
        q89.a r3 = r2.a();
        if (r3 == null) goto L25;
        List<q89.b> r4 = r3.b();
        if (r4 == null) goto L25;
        List r5 = CollectionsKt.filterNotNull(r4);
        if (r5 == null) goto L25;
        List r6 = r5;
        ?? r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r8 = r6.iterator();
        int r9 = 0;
    L12:
        if (r8.hasNext() == false) goto L26;
        Object r10 = r8.next();
        int r11 = r9 + 1;
        if (r9 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        q89.b r12 = (q89.b) r10;
        String r13 = r12.b();
        if (r13 != null) goto L19;
        String r14 = "";
    L20:
        String r15 = r12.e();
        if (r15 != null) goto L23;
        String r16 = "";
    L24:
        PanelItem r17 = new PanelItem(r14, r16, r9 - Integer.MIN_VALUE, null, r12.a(), r12.c(), 8, null);
        r17.setOnClickListener(new o(r12));
        r7.add(r17);
        r9 = r11;
        goto L12
    L23:
        r16 = r15;
        goto L24
    L19:
        r14 = r13;
    L26:
        if (r7 != 0) goto L28;
        r7 = CollectionsKt.emptyList();
    L28:
        Iterable r18 = (Iterable) r7;
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator r21 = r18.iterator();
    L30:
        if (r21.hasNext() == false) goto L32;
        r20.add(((PanelItem) r21.next()).getKey());
        goto L30
    L32:
        List<PanelItem> r22 = this.b;
        LinkedHashMap r23 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r22, 10)), 16));
        Iterator r24 = r22.iterator();
    L34:
        if (r24.hasNext() == false) goto L36;
        PanelItem r25 = (PanelItem) r24.next();
        Pair r26 = TuplesKt.to(r25.getKey(), r25);
        r23.put(r26.getFirst(), r26.getSecond());
        goto L34
    L36:
        Iterator r27 = r18.iterator();
    L38:
        if (r27.hasNext() == false) goto L46;
        PanelItem r28 = (PanelItem) r27.next();
        if (r23.containsKey(r28.getKey()) == false) goto L38;
        PanelItem r30 = (PanelItem) r23.get(r28.getKey());
        if (r30 == null) goto L44;
        PanelItem.OnClickListener r31 = r30.getOnClickListener();
    L45:
        r28.setOnClickListener(r31);
        goto L38
    L44:
        r31 = null;
        goto L45
    L46:
        List<String> r32 = j.get(this.a);
        if (r32 != null) goto L49;
        r32 = CollectionsKt.emptyList();
    L49:
        Collection r33 = (Collection) r7;
        List<PanelItem> r34 = this.b;
        ArrayList r35 = new ArrayList();
        Iterator r36 = r34.iterator();
    L51:
        if (r36.hasNext() == false) goto L55;
        Object r37 = r36.next();
        if ((!r20.contains(((PanelItem) r37).getKey())) == false) goto L51;
        r35.add(r37);
        goto L51
    L55:
        List r38 = CollectionsKt.plus(r33, r35);
        ArrayList r40 = new ArrayList();
        Iterator r41 = r38.iterator();
    L57:
        if (r41.hasNext() == false) goto L61;
        Object r42 = r41.next();
        if ((!r32.contains(((PanelItem) r42).getKey())) == false) goto L57;
        r40.add(r42);
        goto L57
    L61:
        return r40;
    L25:
        r7 = 0;
        goto L26
    }

    public final void M0() {
        List<PanelItem> r0 = this.f;
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        Iterator<T> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        PanelItem r2 = (PanelItem) r1.next();
        if (this.g.add(r2.getKey()) == false) goto L7;
        r r3 = r.a;
        String r4 = this.a;
        String r5 = r2.getKey();
        r3.getClass();
        IApplog.Companion r6 = IApplog.a;
        JSONObject r7 = new JSONObject();
        r7.putOpt(DoraObricDeviceHomeViewModel.PARAM_ENTER_FROM, r4);
        r7.putOpt("module_text", r5);
        r7.putOpt("btm", "a1.b88263.c0.d0");
        Unit r8 = Unit.INSTANCE;
        r6.reportEvent("tobsdk_livesdk_ecom_module_view", r7);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        int r0 = ad.a.a;
        ad.a.a(this, Boolean.FALSE);
        Handler r1 = DialogLancet.resolveDialogHandler(this);
        if (r1 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        q89.c r2 = p.a;
        i r3 = this.h;
        Intrinsics.checkNotNullParameter(r3, "handler");
        ((ArrayList) p.c).remove(r3);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r4 == null) goto L16;
        com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r1.getLooper()) goto L7;
        r1.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public final void J0() {
        RecyclerView r0 = findViewById(2131363141);
        if (r0 == null) goto L9;
        ViewGroup.LayoutParams r4 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r5 = (LinearLayout.LayoutParams) r4;
        if (this.c.getItemCount() != 0) goto L7;
        int r6 = 0;
    L8:
        r5.bottomMargin = r6;
        r0.setLayoutParams(r5);
        goto L9
    L7:
        r6 = c7.b(16);
    L9:
        RecyclerView r1 = findViewById(2131363142);
        if (r1 == null) goto L16;
        ViewGroup.LayoutParams r7 = r1.getLayoutParams();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r8 = (LinearLayout.LayoutParams) r7;
        if (this.d.getItemCount() != 0) goto L14;
        int r9 = 0;
    L15:
        r8.bottomMargin = r9;
        r1.setLayoutParams(r8);
        goto L16
    L14:
        r9 = c7.b(16);
    L16:
        RecyclerView r2 = findViewById(2131363143);
        if (r2 == null) goto L23;
        ViewGroup.LayoutParams r10 = r2.getLayoutParams();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r11 = (LinearLayout.LayoutParams) r10;
        if (this.e.getItemCount() != 0) goto L21;
        int r3 = 0;
    L22:
        r11.bottomMargin = r3;
        r2.setLayoutParams(r11);
        goto L23
    L21:
        r3 = c7.b(16);
    L23:
        View r12 = findViewById(2131363137);
        View r13 = findViewById(2131363138);
        if (this.d.getItemCount() <= 0) goto L27;
        if (r12 == null) goto L30;
        r12.setVisibility(0);
    L30:
        if (this.e.getItemCount() <= 0) goto L33;
        if (r13 == null) goto L36;
        r13.setVisibility(0);
        return;
    L36:
        return;
    L33:
        if (r13 == null) goto L38;
        r13.setVisibility(8);
        return;
    L38:
        return;
    L27:
        if (r12 == null) goto L30;
        r12.setVisibility(8);
        goto L30
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L13;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Window r0 = getWindow();
        if (r0 == null) goto L10;
        r0.setLayout(-1, -1);
    L10:
        int r1 = ad.a.a;
        BtmSDK.INSTANCE.getDepend().getClass();
        BtmHostDependManager.l(this, "a1.b88263", false);
        ad.a.b(this);
        r r2 = r.a;
        String r3 = this.a;
        r2.getClass();
        IApplog.Companion r4 = IApplog.a;
        JSONObject r5 = new JSONObject();
        r5.putOpt(DoraObricDeviceHomeViewModel.PARAM_ENTER_FROM, r3);
        r5.putOpt("btm", "a1.b88263.c0.d0");
        Unit r6 = Unit.INSTANCE;
        r4.reportEvent("tobsdk_livesdk_page_view", r5);
        M0();
        return;
    L13:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L6:
        DialogLancet.beforeDialogShow(this);
        super/*android.app.Dialog*/.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void I0(ECAppletPanel r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r9) {
        super.onCreate(r9);
        Window r10 = getWindow();
        if (r10 == null) goto L5;
        r10.setBackgroundDrawable(new ColorDrawable(0));
        r10.setGravity(80);
        r10.setSoftInputMode(48);
        r10.addFlags(Integer.MIN_VALUE);
        r10.setNavigationBarColor(0);
        r10.setStatusBarColor(0);
    L5:
        Window r11 = getWindow();
        if (r11 == null) goto L8;
        WindowCompat.setDecorFitsSystemWindows(r11, false);
    L8:
        setContentView(2131562325);
        View r12 = findViewById(2131363145);
        if (r12 == null) goto L42;
        View r1 = findViewById(2131363144);
        if (r1 == null) goto L42;
        TextView r2 = (TextView) findViewById(2131363147);
        View r3 = findViewById(2131363134);
        RecyclerView r4 = findViewById(2131363141);
        RecyclerView r5 = findViewById(2131363142);
        RecyclerView r6 = findViewById(2131363143);
        r12.setOnClickListener(new com.larus.e_commerce.impl.applet.panel.b(this));
        r1.setOnClickListener(new com.larus.e_commerce.impl.applet.panel.c());
        if (r3 == null) goto L17;
        r3.setOnClickListener(new com.larus.e_commerce.impl.applet.panel.d(this));
    L17:
        if (r2 == null) goto L29;
        q89.c r13 = p.a;
        if (r13 == null) goto L23;
        q89.a r14 = r13.a();
        if (r14 == null) goto L23;
        String r15 = r14.a();
    L24:
        if (r15 != null) goto L27;
        r15 = "更多工具";
    L27:
        r2.setText(r15);
    L23:
        r15 = null;
    L29:
        if (r4 == null) goto L33;
        r4.setLayoutManager(new LinearLayoutManager(r4.getContext(), 0, false));
        r4.setAdapter(this.c);
        if (r4.getItemDecorationCount() != 0) goto L33;
        Resources r7 = r4.getResources();
        r4.addItemDecoration(new b((int) (WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()).density * 12.0f)));
    L33:
        if (r5 == null) goto L37;
        r5.setLayoutManager(new LinearLayoutManager(r5.getContext(), 0, false));
        r5.setAdapter(this.d);
        if (r5.getItemDecorationCount() != 0) goto L37;
        Resources r8 = r5.getResources();
        r5.addItemDecoration(new b((int) (WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).density * 12.0f)));
    L37:
        if (r6 == null) goto L41;
        r6.setLayoutManager(new LinearLayoutManager(r6.getContext(), 0, false));
        r6.setAdapter(this.e);
        if (r6.getItemDecorationCount() != 0) goto L41;
        Resources r0 = r6.getResources();
        r6.addItemDecoration(new b((int) (WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density * 12.0f)));
    L41:
        J0();
        final int r16 = r1.getPaddingBottom();
        ViewCompat.setOnApplyWindowInsetsListener(r1, new e(r16));
        ViewCompat.requestApplyInsets(r1);
    L42:
        q89.c r17 = p.a;
        i r18 = this.h;
        Intrinsics.checkNotNullParameter(r18, "handler");
        ((ArrayList) p.c).add(r18);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12, types: [com.larus.e_commerce.impl.applet.panel.i] */
    public ECAppletPanel(Context r5, String r6, List r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "scene");
        Intrinsics.checkNotNullParameter(r7, "items");
        super(r5, 2131952462);
        this.a = r6;
        this.b = r7;
        this.c = new c(r6, new f(this));
        this.d = new c(r6, new g(this));
        this.e = new c(r6, new h(this));
        this.g = new LinkedHashSet();
        getDelegate().setLocalNightMode(1);
        supportRequestWindowFeature(1);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window r8 = getWindow();
        Intrinsics.checkNotNull(r8);
        WindowManager.LayoutParams r9 = r8.getAttributes();
        r9.dimAmount = 0.3f;
        r8.setAttributes(r9);
        List<PanelItem> r10 = L0();
        this.f = r10;
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L3:
        boolean r1 = false;
        if (r12.hasNext() == false) goto L10;
        Object r0 = r12.next();
        if (((PanelItem) r0).getLine() != 1) goto L8;
        r1 = true;
    L8:
        if (r1 == false) goto L3;
        r11.add(r0);
        goto L3
    L10:
        this.c.submit(r11);
        List<PanelItem> r13 = this.f;
        if (r13 == null) goto L22;
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L14:
        if (r15.hasNext() == false) goto L21;
        Object r2 = r15.next();
        if (((PanelItem) r2).getLine() != 2) goto L18;
        boolean r3 = true;
    L19:
        if (r3 == false) goto L14;
        r14.add(r2);
        goto L14
    L18:
        r3 = false;
        goto L19
    L21:
        this.d.submit(r14);
    L22:
        List<PanelItem> r16 = this.f;
        if (r16 == null) goto L34;
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = r16.iterator();
    L26:
        if (r18.hasNext() == false) goto L33;
        Object r4 = r18.next();
        if (((PanelItem) r4).getLine() != 3) goto L30;
        boolean r20 = true;
    L31:
        if (r20 == false) goto L26;
        r17.add(r4);
        goto L26
    L30:
        r20 = false;
        goto L31
    L33:
        this.e.submit(r17);
    L34:
        this.h = new i(this);
    }
}
