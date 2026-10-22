package com.bytedance.ai.applet.app.view;

import android.content.Context;
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u0001:\u0005\u001b\u001c\u001d\u001e\u001fBA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0006\u0010\u0016\u001a\u00020\u0013J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0016J$\u0010\u0019\u001a\u00020\u00132\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\b\u0010\u001a\u001a\u00020\u0013H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ai/applet/app/view/AppletActionSheetDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "header", "Lcom/bytedance/ai/applet/app/view/AppletActionSheetDialog$Header;", "firstRowMenuItems", "", "Lcom/bytedance/ai/applet/app/view/MenuItem;", "secondRowMenuItems", "onMenuItemClickListener", "Lcom/bytedance/ai/applet/app/view/OnMenuItemClickListener;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ai/applet/app/view/AppletActionSheetDialog$Header;Ljava/util/List;Ljava/util/List;Lcom/bytedance/ai/applet/app/view/OnMenuItemClickListener;)V", "originalContext", "firstRowMenuAdapter", "Lcom/bytedance/ai/applet/app/view/AppletActionSheetDialog$MenuAdapter;", "secondRowMenuAdapter", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "refreshTheme", "setupContentView", "show", "setMenuItems", "adjustLayout", "Header", "Companion", "MenuAdapter", "MenuViewHolder", "HorizontalSpaceDecoration", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletActionSheetDialog extends AppCompatDialog {
    public static final /* synthetic */ int f = 0;
    public final b a;
    public final n b;
    public final Context c;
    public final d d;
    public final d e;

    public static final class a {
        public static AppletActionSheetDialog a(AppletAppActivity r10, b r11, List r12, List r13, n r14) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r12, "firstRowMenuItems");
            Intrinsics.checkNotNullParameter(r13, "secondRowMenuItems");
            Intrinsics.checkNotNullParameter(r14, "onMenuItemClickListener");
            AppletActionSheetDialog r0 = new AppletActionSheetDialog(r10, r11, r12, r13, r14);
            if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L9;
            DialogLancet.handleBlockedDialogShow(r0);
        L7:
            return r0;
        L9:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            DialogLancet.beforeDialogShow(r0);
            r0.show();
            DialogLancet.afterDialogShow(r0);
            goto L7
        }
    }

    public static final class b {
        public final Integer a;
        public final String b;
        public final String c;
        public final String d;
        public final Function0<Unit> e;

        public b() {
            this(null, null, null, null, 31);
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r11.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            Integer r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r10 = 0;
        L6:
            int r11 = r10 * 31;
            String r12 = this.b;
            if (r12 != null) goto L9;
            int r13 = 0;
        L10:
            int r14 = (r11 + r13) * 31;
            String r15 = this.c;
            if (r15 != null) goto L13;
            int r16 = 0;
        L14:
            int r17 = (r14 + r16) * 31;
            String r18 = this.d;
            if (r18 != null) goto L17;
            int r19 = 0;
        L18:
            int r20 = (r17 + r19) * 31;
            Function0<Unit> r21 = this.e;
            if (r21 == null) goto L23;
            r1 = r21.hashCode();
        L23:
            return r20 + r1;
        L17:
            r19 = r18.hashCode();
            goto L18
        L13:
            r16 = r15.hashCode();
            goto L14
        L9:
            r13 = r12.hashCode();
            goto L10
        L5:
            r10 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Header(iconRes=" + this.a + ", iconUrl=" + this.b + ", title=" + this.c + ", subtitle=" + this.d + ", onHeaderClick=" + this.e + ')';
        }

        public b(Integer r10, String r11, String r12, String r13, int r14) {
            if ((r14 & 1) == 0) goto L6;
            r10 = null;
        L6:
            if ((r14 & 2) == 0) goto L9;
            r11 = null;
        L9:
            if ((r14 & 4) == 0) goto L12;
            r12 = null;
        L12:
            if ((r14 & 8) == 0) goto L14;
            r13 = null;
        L14:
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = null;
        }
    }

    public static final class c extends RecyclerView.ItemDecoration {
        public final int a;

        public c(int r1) {
            this.a = r1;
        }

        public final void getItemOffsets(Rect r10, View r11, RecyclerView r12, RecyclerView.State r13) {
            Intrinsics.checkNotNullParameter(r10, "outRect");
            Intrinsics.checkNotNullParameter(r11, "view");
            Intrinsics.checkNotNullParameter(r12, "parent");
            Intrinsics.checkNotNullParameter(r13, "state");
            int r14 = r12.getChildAdapterPosition(r11);
            if (r14 != (-1)) goto L5;
            return;
        L5:
            if (r14 != 0) goto L7;
            int r15 = 0;
        L8:
            r10.left = r15;
            return;
        L7:
            r15 = this.a;
            goto L8
        }
    }

    public static final class d extends RecyclerView.Adapter<e> {
        public final Function1<m, Unit> a;
        public final ArrayList<m> b;

        public static final class a<T> implements Comparator {
            public a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T r1, T r10) {
                return ComparisonsKt.compareValues(Integer.valueOf(((m) r1).e), Integer.valueOf(((m) r10).e));
            }
        }

        public static final class b<T> implements Comparator {
            public final /* synthetic */ Comparator a;

            public b(a r1) {
                this.a = r1;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T r10, T r11) {
                int r0 = this.a.compare(r10, r11);
                if (r0 == 0) goto L6;
                return r0;
            L6:
                return ComparisonsKt.compareValues(Integer.valueOf(((m) r10).a), Integer.valueOf(((m) r11).a));
            }
        }

        public final int getItemCount() {
            return this.b.size();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(Function1<? super m, Unit> r10) {
            Intrinsics.checkNotNullParameter(r10, "onItemClick");
            this.a = r10;
            this.b = new ArrayList();
        }

        public final void submit(List<m> r10) {
            Intrinsics.checkNotNullParameter(r10, "menuItems");
            this.b.clear();
            this.b.addAll(CollectionsKt.sortedWith(r10, new b(new a())));
            notifyDataSetChanged();
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r12, int r13) {
            final e r14 = (e) r12;
            Intrinsics.checkNotNullParameter(r14, "holder");
            final m r15 = (m) ListProtector.get(this.b, r13);
            r14.getClass();
            Intrinsics.checkNotNullParameter(r15, "item");
            Integer r0 = r15.c;
            boolean r1 = false;
            if (r0 == null) goto L5;
            r14.b.setImageResource(r0.intValue());
        L19:
            String r10 = r15.h;
            if (r10 != null) goto L22;
        L23:
            r1 = true;
        L25:
            if (r1 == true) goto L31;
            String r11 = r15.h;
            r14.d.setTag(r11);
            r14.d.setBackgroundResource(2131231869);
            LifecycleOwner r16 = ViewTreeLifecycleOwner.get(((RecyclerView.ViewHolder) r14).itemView);
            if (r16 == null) goto L35;
            LifecycleCoroutineScope r17 = LifecycleOwnerKt.getLifecycleScope(r16);
            if (r17 == null) goto L35;
            BuildersKt.launch$default(r17, null, null, new AppletActionSheetDialog$MenuViewHolder$bind$2(r11, r14, null), 3, null);
        L35:
            r14.c.setText(r15.b);
            Integer r18 = r15.j;
            if (r18 == null) goto L38;
            r14.c.setTextColor(r18.intValue());
        L39:
            ((RecyclerView.ViewHolder) r14).itemView.setEnabled(r15.f);
            View r19 = ((RecyclerView.ViewHolder) r14).itemView;
            if (r15.f == false) goto L42;
            float r20 = 1.0f;
        L43:
            r19.setAlpha(r20);
            ((RecyclerView.ViewHolder) r14).itemView.setOnClickListener(new h(r15, r14));
            return;
        L42:
            r20 = 0.4f;
            goto L43
        L38:
            r14.c.setTextColor(ContextCompat.getColor(((RecyclerView.ViewHolder) r14).itemView.getContext(), 2131100386));
            goto L39
        L31:
            Integer r21 = r15.g;
            if (r21 == null) goto L34;
            r14.d.setBackgroundResource(r21.intValue());
            goto L35
        L34:
            r14.d.setBackgroundResource(2131231869);
            goto L35
        L22:
            if (StringsKt.isBlank(r10) == false) goto L25;
        L5:
            String r22 = r15.d;
            if (r22 != null) goto L8;
        L11:
            boolean r23 = true;
        L12:
            if (r23 == true) goto L18;
            String r24 = r15.d;
            r14.b.setTag(r24);
            r14.b.setImageDrawable(null);
            LifecycleOwner r25 = ViewTreeLifecycleOwner.get(((RecyclerView.ViewHolder) r14).itemView);
            if (r25 == null) goto L19;
            LifecycleCoroutineScope r26 = LifecycleOwnerKt.getLifecycleScope(r25);
            if (r26 == null) goto L19;
            BuildersKt.launch$default(r26, null, null, new AppletActionSheetDialog$MenuViewHolder$bind$1(r24, r14, null), 3, null);
            goto L19
        L18:
            r14.b.setImageDrawable(null);
            goto L19
        L8:
            if (StringsKt.isBlank(r22) == true) goto L11;
            r23 = false;
            goto L12
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "parent");
            View r12 = LayoutInflater.from(r10.getContext()).inflate(2131558718, r10, false);
            Intrinsics.checkNotNull(r12);
            return new e(r12, this.a);
        }
    }

    public static final class e extends RecyclerView.ViewHolder {
        public final Function1<m, Unit> a;
        public final ImageView b;
        public final TextView c;
        public final FrameLayout d;

        /* JADX WARN: Multi-variable type inference failed */
        public e(View r10, Function1<? super m, Unit> r11) {
            Intrinsics.checkNotNullParameter(r10, "itemView");
            Intrinsics.checkNotNullParameter(r11, "onItemClick");
            super(r10);
            this.a = r11;
            this.b = (ImageView) r10.findViewById(2131363167);
            this.c = (TextView) r10.findViewById(2131363168);
            this.d = (FrameLayout) r10.findViewById(2131363166);
        }
    }

    static {
    }

    public final void M0() {
        setContentView(2131558713);
        View r1 = findViewById(2131363145);
        if (r1 != null) goto L5;
        return;
    L5:
        View r10 = findViewById(2131363144);
        if (r10 != null) goto L8;
        return;
    L8:
        SimpleDraweeView r11 = findViewById(2131363139);
        TextView r12 = (TextView) findViewById(2131363147);
        TextView r13 = (TextView) findViewById(2131363146);
        View r14 = findViewById(2131363135);
        View r15 = findViewById(2131363136);
        View r16 = findViewById(2131363133);
        View r17 = findViewById(2131363134);
        RecyclerView r18 = findViewById(2131363141);
        RecyclerView r19 = findViewById(2131363142);
        r1.setOnClickListener(new com.bytedance.ai.applet.app.view.a(this));
        r10.setOnClickListener(new com.bytedance.ai.applet.app.view.b());
        if (r17 == null) goto L11;
        r17.setOnClickListener(new com.bytedance.ai.applet.app.view.c(this));
    L11:
        final b r20 = this.a;
        int r110 = 8;
        if (r20 != null) goto L17;
        if (r14 == null) goto L15;
        r14.setVisibility(8);
    L15:
        if (r15 == null) goto L57;
        r15.setVisibility(8);
    L57:
        if (r18 == null) goto L61;
        r18.setLayoutManager(new LinearLayoutManager(r18.getContext(), 0, false));
        r18.setAdapter(this.d);
        if (r18.getItemDecorationCount() != 0) goto L61;
        Resources r21 = r18.getResources();
        r18.addItemDecoration(new c((int) (WindowDisplayMetricsOverride.apply(r21, r21.getDisplayMetrics()).density * 4.0f)));
    L61:
        if (r19 == null) goto L65;
        r19.setLayoutManager(new LinearLayoutManager(r19.getContext(), 0, false));
        r19.setAdapter(this.e);
        if (r19.getItemDecorationCount() != 0) goto L65;
        Resources r22 = r19.getResources();
        r19.addItemDecoration(new c((int) (WindowDisplayMetricsOverride.apply(r22, r22.getDisplayMetrics()).density * 4.0f)));
    L65:
        J0();
        final int r23 = r10.getPaddingBottom();
        ViewCompat.setOnApplyWindowInsetsListener(r10, new com.bytedance.ai.applet.app.view.e(r23));
        ViewCompat.requestApplyInsets(r10);
        return;
    L17:
        if (r11 == null) goto L38;
        String r111 = r20.b;
        if (r111 != null) goto L21;
    L24:
        boolean r112 = true;
    L25:
        if (r112 == true) goto L35;
        String r113 = r20.b;
        r11.setVisibility(0);
        r11.setTag(r113);
        LifecycleOwner r114 = this.c;
        if ((r114 instanceof LifecycleOwner) == false) goto L29;
        LifecycleOwner r115 = r114;
    L30:
        if (r115 == null) goto L38;
        LifecycleCoroutineScope r116 = LifecycleOwnerKt.getLifecycleScope(r115);
        if (r116 == null) goto L38;
        BuildersKt.launch$default(r116, null, null, new AppletActionSheetDialog$setupContentView$4$1$1(r113, r11, r20, null), 3, null);
        goto L38
    L29:
        r115 = null;
        goto L30
    L35:
        if (r20.a == null) goto L37;
        r11.setVisibility(0);
        r11.setActualImageResource(r20.a.intValue());
        goto L38
    L37:
        r11.setVisibility(8);
        goto L38
    L21:
        if (StringsKt.isBlank(r111) == true) goto L24;
        r112 = false;
    L38:
        if (r12 == null) goto L40;
        r12.setText(r20.c);
    L40:
        if (r13 == null) goto L43;
        r13.setText(r20.d);
    L43:
        if (r20.e == null) goto L45;
        boolean r24 = true;
    L46:
        if (r16 == null) goto L50;
        if (r24 == false) goto L49;
        r110 = 0;
    L49:
        r16.setVisibility(r110);
    L50:
        if (r14 == null) goto L52;
        r14.setClickable(r24);
    L52:
        if (r14 == null) goto L54;
        r14.setFocusable(r24);
    L54:
        if (r14 == null) goto L57;
        r14.setOnClickListener(new com.bytedance.ai.applet.app.view.d(r20));
        goto L57
    L45:
        r24 = false;
        goto L46
    }

    public final void J0() {
        RecyclerView r0 = findViewById(2131363141);
        int r1 = 0;
        if (r0 == null) goto L9;
        ViewGroup.LayoutParams r10 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r11 = (LinearLayout.LayoutParams) r10;
        if (this.d.getItemCount() != 0) goto L7;
        int r12 = 0;
    L8:
        r11.bottomMargin = r12;
        r0.setLayoutParams(r11);
        goto L9
    L7:
        r12 = n2.a.a(12);
    L9:
        RecyclerView r13 = findViewById(2131363142);
        if (r13 == null) goto L17;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r15 = (LinearLayout.LayoutParams) r14;
        if (this.e.getItemCount() == 0) goto L15;
        r1 = n2.a.a(12);
    L15:
        r15.bottomMargin = r1;
        r13.setLayoutParams(r15);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void L0() {
        if (isShowing() == false) goto L18;
        Window r0 = getWindow();
        boolean r1 = false;
        if (r0 == null) goto L15;
        View r10 = r0.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r11 = ThreadMethodProxy.currentThread();
        if (r11 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r11, "getDecorView");
    L11:
        if (r10 == null) goto L15;
        if (r10.isAttachedToWindow() != true) goto L15;
        r1 = true;
    L15:
        if (r1 == false) goto L19;
        M0();
        return;
    L19:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Window r0 = getWindow();
        if (r0 == null) goto L14;
        r0.setLayout(-1, -1);
        return;
    L14:
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        DialogLancet.beforeDialogShow(this);
        super/*android.app.Dialog*/.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void I0(AppletActionSheetDialog r10) {
        Handler r0 = DialogLancet.resolveDialogHandler(r10);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r10);
        r10.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r10);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r10);
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
        r0.post(DialogLancet.createDismissRunnable(r10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        Window r11 = getWindow();
        if (r11 == null) goto L5;
        r11.setBackgroundDrawable(new ColorDrawable(0));
        r11.setGravity(80);
        r11.setSoftInputMode(48);
        r11.addFlags(Integer.MIN_VALUE);
        r11.setNavigationBarColor(0);
        r11.setStatusBarColor(0);
    L5:
        Window r12 = getWindow();
        if (r12 == null) goto L8;
        WindowCompat.setDecorFitsSystemWindows(r12, false);
    L8:
        M0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppletActionSheetDialog(AppletAppActivity r10, b r11, List r12, List r13, n r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r12, "firstRowMenuItems");
        Intrinsics.checkNotNullParameter(r13, "secondRowMenuItems");
        Intrinsics.checkNotNullParameter(r14, "onMenuItemClickListener");
        super(r10, 2131951619);
        this.a = r11;
        this.b = r14;
        this.c = r10;
        d r15 = new d(new f(this));
        this.d = r15;
        d r16 = new d(new g(this));
        this.e = r16;
        supportRequestWindowFeature(1);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window r17 = getWindow();
        Intrinsics.checkNotNull(r17);
        WindowManager.LayoutParams r0 = r17.getAttributes();
        r0.dimAmount = 0.3f;
        r17.setAttributes(r0);
        r15.submit(r12);
        r16.submit(r13);
    }
}
