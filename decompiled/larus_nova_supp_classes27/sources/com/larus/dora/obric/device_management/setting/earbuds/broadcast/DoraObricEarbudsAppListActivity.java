package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.nl.AppListItem;
import com.larus.dora.impl.nl.DoraUserSettingsManager;
import com.larus.dora.impl.nl.NLAppListViewModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.oui.forms.OEditText;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 .2\u00020\u0001:\u0002-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0014H\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0014J\b\u0010\u0019\u001a\u00020\u0014H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\u0014H\u0002J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020\u000fH\u0002J\b\u0010)\u001a\u00020\u0014H\u0002J\f\u0010*\u001a\u00020\u001b*\u00020\u001bH\u0002J\b\u0010+\u001a\u00020\u001bH\u0002J\b\u0010,\u001a\u00020\u001bH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsAppListActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "viewModel", "Lcom/larus/dora/impl/nl/NLAppListViewModel;", "getViewModel", "()Lcom/larus/dora/impl/nl/NLAppListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsAppListActivity$EarbudsAppListAdapter;", "searchBar", "Lcom/obric/oui/searchbar/v2/OSearchBar;", "emptyView", "Lcom/obric/oui/status/OPageStatus;", "isSearching", "", "enterPageTraced", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onStop", "onDestroy", "getBackgroundResource", "", "setupObserver", "buildPage", "Landroid/view/View;", "buildTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "buildContent", "cancelSearch", "hideKeyboard", "buildSearchBarContainer", "context", "Landroid/content/Context;", "buildSearchBar", "buildEmptyView", "traceEnterPage", "dp", "resolveBackgroundColor", "resolvePrimaryTextColor", "EarbudsAppListAdapter", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsAppListActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int m = 0;
    public final ViewModelLazy g;
    public final EarbudsAppListAdapter h;
    public OSearchBar i;
    public OPageStatus j;
    public boolean k;
    public boolean l;

    public final class EarbudsAppListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public Function1<? super AppListItem, Unit> a;
        public List<? extends AppListItem> b;
        public final /* synthetic */ DoraObricEarbudsAppListActivity c;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsAppListActivity$EarbudsAppListAdapter$FooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsAppListActivity$EarbudsAppListAdapter;Landroid/view/View;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class FooterViewHolder extends RecyclerView.ViewHolder {
            public FooterViewHolder(View r2) {
                Intrinsics.checkNotNullParameter(r2, "itemView");
                super(r2);
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsAppListActivity$EarbudsAppListAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Lcom/obric/oui/sectiontitlebar/OSectionTitleBar;", "<init>", "(Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsAppListActivity$EarbudsAppListAdapter;Lcom/obric/oui/sectiontitlebar/OSectionTitleBar;)V", "bind", "", "header", "Lcom/larus/dora/impl/nl/AppListItem$Header;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class HeaderViewHolder extends RecyclerView.ViewHolder {
            public HeaderViewHolder(OSectionTitleBar r2) {
                Intrinsics.checkNotNullParameter(r2, "itemView");
                super(r2);
            }
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\f\u0010\u0013\u001a\u00020\u000f*\u00020\u0003H\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\f\u0010\u0017\u001a\u00020\u000f*\u00020\u0003H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsAppListActivity$EarbudsAppListAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Lcom/obric/oui/lisitem/OCardListItem;", "<init>", "(Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsAppListActivity$EarbudsAppListAdapter;Lcom/obric/oui/lisitem/OCardListItem;)V", "currentItem", "Lcom/larus/dora/impl/nl/AppListItem$Item;", "boundIconUrl", "", "appIconView", "Lcom/obric/oui/image/OImageAppIcon;", "actionButton", "Landroid/widget/ImageView;", "bind", "", "item", "buildActionButton", "buildAppIcon", "attachAppIconView", "bindAppIcon", "appInfo", "Lcom/larus/dora/impl/network/NLAppInfo;", "applyItemStyle", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class ItemViewHolder extends RecyclerView.ViewHolder {
            public static final /* synthetic */ int f = 0;
            public AppListItem.c a;
            public String b;
            public final OImageAppIcon c;
            public final ImageView d;
            public final /* synthetic */ EarbudsAppListAdapter e;

            public /* synthetic */ class a {
                public static final /* synthetic */ int[] a = null;

                static {
                    int[] r0 = new int[AppListItem.BackgroundType.values().length];
                    r0[AppListItem.BackgroundType.FIRST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
                L13:
                    r0[AppListItem.BackgroundType.MIDDLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
                L19:
                    r0[AppListItem.BackgroundType.LAST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
                L15:
                    r0[AppListItem.BackgroundType.DEFAULT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
                L7:
                    a = r0;
                }
            }

            public ItemViewHolder(final EarbudsAppListAdapter r9, OCardListItem r10) {
                Intrinsics.checkNotNullParameter(r10, "itemView");
                this.e = r9;
                super(r10);
                OImageAppIcon r0 = vma.e.a(((RecyclerView.ViewHolder) this).itemView.getContext(), 2131953059, new x());
                this.c = r0;
                ImageView r1 = new ImageView(((RecyclerView.ViewHolder) this).itemView.getContext());
                DoraObricEarbudsAppListActivity r2 = r9.c;
                int r4 = DoraObricEarbudsAppListActivity.m;
                r1.setLayoutParams(new FrameLayout.LayoutParams(r2.N1(32), r2.N1(32), 17));
                r1.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                com.larus.utils.e1.d(r1, new v(this, r9));
                this.d = r1;
                r10.setCardType(0);
                r10.setShowCardBg(true);
                r10.n(false);
                r10.p(true);
                ViewParent r3 = r10.getIconView().getParent();
                ViewGroup r6 = null;
                if ((r3 instanceof FrameLayout) == false) goto L5;
                FrameLayout r5 = (FrameLayout) r3;
            L6:
                if (r5 == null) goto L16;
                r10.getIconView().setVisibility(8);
                if (r0.getParent() == r5) goto L16;
                ViewParent r7 = r0.getParent();
                if ((r7 instanceof ViewGroup) == false) goto L13;
                r6 = (ViewGroup) r7;
            L13:
                if (r6 == null) goto L15;
                r6.removeView(r0);
            L15:
                r5.addView(r0, new FrameLayout.LayoutParams(r0.getLayoutParams().width, r0.getLayoutParams().height, 17));
            L16:
                r10.s(true);
                r10.q(false);
                r10.r(false);
                r10.o(false);
                r10.setCustomEndView(r1);
                r10.m(true);
                return;
            L5:
                r5 = null;
                goto L6
            }
        }

        public final int getItemCount() {
            return this.b.size();
        }

        public EarbudsAppListAdapter(DoraObricEarbudsAppListActivity r1) {
            this.c = r1;
            this.b = CollectionsKt.emptyList();
        }

        public final int getItemViewType(int r2) {
            AppListItem r3 = (AppListItem) ListProtector.get(this.b, r2);
            if ((r3 instanceof AppListItem.b) == false) goto L6;
            return 0;
        L6:
            if ((r3 instanceof AppListItem.c) == false) goto L9;
            return 1;
        L9:
            if ((r3 instanceof AppListItem.a) == false) goto L13;
            return 2;
        L13:
            throw new NoWhenBranchMatchedException();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
            Intrinsics.checkNotNullParameter(r9, "holder");
            if ((r9 instanceof HeaderViewHolder) == false) goto L6;
            HeaderViewHolder r11 = (HeaderViewHolder) r9;
            Object r12 = ListProtector.get(this.b, r10);
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.larus.dora.impl.nl.AppListItem.Header");
            AppListItem.b r13 = (AppListItem.b) r12;
            r11.getClass();
            Intrinsics.checkNotNullParameter(r13, "header");
            OSectionTitleBar r14 = ((RecyclerView.ViewHolder) r11).itemView;
            Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.obric.oui.sectiontitlebar.OSectionTitleBar");
            OSectionTitleBar r15 = r14;
            r15.setTitleText(r13.a);
            r15.b(false);
            r15.a(false);
            return;
        L6:
            if ((r9 instanceof ItemViewHolder) == false) goto L64;
            final ItemViewHolder r16 = (ItemViewHolder) r9;
            Object r17 = ListProtector.get(this.b, r10);
            Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type com.larus.dora.impl.nl.AppListItem.Item");
            AppListItem.c r18 = (AppListItem.c) r17;
            r16.getClass();
            Intrinsics.checkNotNullParameter(r18, "item");
            r16.a = r18;
            OCardListItem r0 = ((RecyclerView.ViewHolder) r16).itemView;
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.oui.lisitem.OCardListItem");
            OCardListItem r1 = r0;
            int r2 = ItemViewHolder.a.a[r18.b.ordinal()];
            if (r2 == 1) goto L17;
            int r5 = 2;
            if (r2 == 2) goto L18;
            r5 = 3;
            if (r2 == 3) goto L18;
            if (r2 != 4) goto L16;
            r5 = 0;
            goto L18
        L16:
            throw new NoWhenBranchMatchedException();
        L18:
            OCardListItem.h(r1, r5);
            r1.setTitle(r18.c.c());
            r1.s(true);
            ViewGroup.LayoutParams r3 = r1.getCardContainer().getLayoutParams();
            String r6 = null;
            if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
            ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        L22:
            if (r4 == null) goto L24;
            r4.setMargins(0, 0, 0, 0);
            r4.setMarginStart(0);
            r4.setMarginEnd(0);
            r1.getCardContainer().setLayoutParams(r4);
        L24:
            OUICardConstraintLayout r7 = r1.getContentContainer();
            DoraObricEarbudsAppListActivity r8 = r16.e.c;
            int r20 = DoraObricEarbudsAppListActivity.m;
            r7.setPadding(0, 0, r8.N1(4), 0);
            r1.getTitleContainer().setGravity(16);
            r1.getTitleContainer().setPadding(r16.e.c.N1(0), r16.e.c.N1(8), r16.e.c.N1(8), r16.e.c.N1(8));
            com.larus.dora.impl.network.s r21 = r18.c;
            r16.c.setImageResource(2131240506);
            String r22 = r21.d();
            if (r22 != null) goto L27;
        L32:
            final String r23 = r21.b();
            if (com.larus.utils.o0.d(r23) == true) goto L36;
            r23 = null;
        L36:
            if (r23 != null) goto L46;
            boolean r24 = v19.h.a;
            if (v19.h.a(null) == false) goto L42;
            com.larus.dora.impl.network.g0 r25 = DoraUserSettingsManager.c.d();
            if (r25 == null) goto L45;
            r6 = r25.b();
        L45:
            r23 = r6;
            goto L46
        L42:
            com.larus.dora.impl.network.g0 r26 = DoraUserSettingsManager.c.d();
            if (r26 == null) goto L45;
            r6 = r26.c();
        L46:
            r16.b = r23;
            if (com.larus.utils.o0.d(r23) == false) goto L50;
            ImageLoaderKt.o(r23, "tag_dora_nl_app_list_image", r16.c, new w(r16, r23), null, 112);
        L50:
            ImageView r27 = r16.d;
            FlowCommonAppCompatActivity r28 = r16.e.c;
            if (r18.a == false) goto L53;
            int r30 = 2131240515;
        L54:
            r27.setImageResource(r30);
            if (r18.a == false) goto L57;
            int r31 = 2131898867;
        L58:
            String r32 = r28.getString(r31);
            StringBuilder r33 = new StringBuilder();
            String r110 = r18.c.c();
            if (r110 != null) goto L61;
            r110 = "";
        L61:
            r33.append(r110);
            r33.append(' ');
            r33.append(r32);
            r27.setContentDescription(r33.toString());
            return;
        L57:
            r31 = 2131902336;
            goto L58
        L53:
            r30 = 2131240514;
            goto L54
        L27:
            if ((!StringsKt.isBlank(r22)) == true) goto L30;
            r22 = null;
        L30:
            if (r22 == null) goto L32;
            r16.c.setImagePackageName(r22);
            goto L32
        L21:
            r4 = null;
            goto L22
        L17:
            r5 = 1;
            goto L18
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
            Intrinsics.checkNotNullParameter(r5, "parent");
            Context r7 = r5.getContext();
            if (r6 != 0) goto L5;
            Intrinsics.checkNotNull(r7);
            return new HeaderViewHolder(new OSectionTitleBar(r7, null, 6, 0));
        L5:
            if (r6 != 1) goto L7;
            Intrinsics.checkNotNull(r7);
            return new ItemViewHolder(this, new OCardListItem(r7, null, 6, 0));
        L7:
            if (r6 != 2) goto L10;
            return new FooterViewHolder(new View(r7));
        L10:
            throw new IllegalArgumentException("Invalid view type");
        }
    }

    public static final class a {
    }

    static {
    }

    public final int C1() {
        return 2131102535;
    }

    public final NLAppListViewModel O1() {
        return (NLAppListViewModel) this.g.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void hideKeyboard() {
        Object r0 = getSystemService("input_method");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager r1 = (InputMethodManager) r0;
        OSearchBar r2 = this.i;
        if (r2 == null) goto L5;
        IBinder r3 = r2.getWindowToken();
    L6:
        r1.hideSoftInputFromWindow(r3, 0);
        OSearchBar r4 = this.i;
        if (r4 == null) goto L12;
        OEditText r5 = r4.getInputView();
        if (r5 == null) goto L13;
        r5.clearFocus();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DoraObricEarbudsAppListActivity.class.getName()));
    L5:
        this.h.a = null;
        this.i = null;
        this.j = null;
        super.onDestroy();
    }

    public DoraObricEarbudsAppListActivity() {
        Function0<ViewModelProvider.Factory> r0 = new DoraObricEarbudsAppListActivity$special$$inlined$viewModels$default$1(this);
        final Function0 r5 = null;
        this.g = new ViewModelLazy(Reflection.getOrCreateKotlinClass(NLAppListViewModel.class), new DoraObricEarbudsAppListActivity$special$$inlined$viewModels$default$2(this), r0, new DoraObricEarbudsAppListActivity$special$$inlined$viewModels$default$3(r5, this));
        this.h = new EarbudsAppListAdapter(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(DoraObricEarbudsAppListActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onResume() {
        super.onResume();
        if (this.l == true) goto L19;
        String r0 = getIntent().getStringExtra("extra_current_page");
        if (r0 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        int r1 = j49.a.a;
        j49.a.e();
    L17:
        this.l = true;
        return;
    L13:
        DoraBuryPointManager r4 = DoraBuryPointManager.a;
        Pair[] r5 = new Pair[2];
        r5[0] = TuplesKt.to("current_page", r0);
        String r2 = getIntent().getStringExtra("extra_previous_page");
        if (r2 != null) goto L16;
        r2 = "";
    L16:
        r5[1] = TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, r2);
        r4.L("enter_page", MapsKt.mapOf(r5));
        goto L17
    L7:
        if (r0.length() == 0) goto L10;
        r3 = false;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        O1().saveChangedAppList();
        hideKeyboard();
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public final int N1(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r17) {
        if (com.larus.platform.service.z2.a.enableGlobalActivityTheme() == false) goto L7;
        v19.f.a(getTheme());     // Catch: Throwable -> L14
    L7:
        if (v19.f.f(this) == false) goto L9;
        v19.f.c(getTheme());     // Catch: Throwable -> L14
    L9:
        super.onCreate(r17);
        EarbudsAppListAdapter r1 = this.h;
        r1.a = new u(this);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricEarbudsAppListActivity$setupObserver$2(this, null), 3, null);
        LinearLayout r2 = new LinearLayout(this);
        r2.setOrientation(1);
        r2.setClipChildren(false);
        r2.setClipToPadding(false);
        r2.setBackgroundColor(v19.c.a(2130970531, this, 2131102535));
        OFloatingTitleBar r7 = new OFloatingTitleBar(this, null, 6, 0);
        com.larus.dora.obric.utils.c.a(r7);
        r7.setBackgroundColor(v19.c.a(2130970531, this, 2131102535));
        r7.setCenterTitle(getString(2131902259));
        r7.setCenterTitleColor(v19.c.a(2130972079, this, 2131103136));
        r7.R(false);
        OFloatingTitleBar.k(r7, null, 6).setOnClickListener(new t(this));
        r2.addView(r7, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout r8 = new LinearLayout(this);
        r8.setOrientation(1);
        r8.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrameLayout r3 = new FrameLayout(this);
        r3.setPadding(N1(12), N1(8), N1(12), N1(8));
        OSearchBar r9 = getLayoutInflater().inflate(2131562253, null, false);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.obric.oui.searchbar.v2.OSearchBar");
        OSearchBar r10 = r9;
        this.i = r10;
        r10.setLayoutParams(new ViewGroup.LayoutParams(-1, N1(40)));
        OEditText r11 = r10.getInputView();
        if (r11 == null) goto L12;
        r11.setHint(getString(2131909084));
        r11.setHintTextColor(v19.c.a(2130972081, this, 2131103143));
        r11.setTextColor(v19.c.a(2130972079, this, 2131103136));
        r11.setTextSize(2, 16.0f);
        r11.addTextChangedListener(new y(this));
    L12:
        r3.addView(r10, new FrameLayout.LayoutParams(-1, N1(40)));
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-1, N1(56));
        r4.topMargin = N1(8);
        Unit r5 = Unit.INSTANCE;
        r8.addView(r3, r4);
        FrameLayout r6 = new FrameLayout(this);
        RecyclerView r12 = new RecyclerView(this);
        r12.setLayoutManager(new LinearLayoutManager(this));
        r12.setAdapter(this.h);
        r12.setOverScrollMode(2);
        r12.setPadding(N1(16), N1(8), N1(16), N1(24));
        r12.setClipToPadding(false);
        r12.addOnScrollListener(new DoraObricEarbudsAppListActivity$buildContent$appList$1$1(this));
        r6.addView(r12, new FrameLayout.LayoutParams(-1, -1));
        OPageStatus r13 = new OPageStatus(this, null, 6, 0);
        r13.setType(0);
        r13.setGravity(17);
        r13.setMessage(getString(2131902237));
        r13.a(false);
        r13.setVisibility(8);
        r6.addView(r13, new FrameLayout.LayoutParams(-1, -1));
        this.j = r13;
        r8.addView(r6, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        r2.addView(r8, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        setContentView(r2);
        getWindow().setSoftInputMode(16);
    }
}
