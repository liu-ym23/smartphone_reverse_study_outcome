package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view;

import android.R;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.base.view.OpenPlatformTitleBar;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.PrivateMsgSettingDialog;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.ShelfManagementBusinessToolsAdapter;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.model.BusinessToolType;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.viewholder.BaseBusinessToolItemViewHolder;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.viewmodel.ShelfManagementViewModelV2;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.widget.x0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementActivityV2;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/viewmodel/ShelfManagementViewModelV2;", "T", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/businesstools/viewholder/BaseBusinessToolItemViewHolder$a;", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ShelfManagementActivityV2<T extends ShelfManagementViewModelV2> extends AppCompatActivity implements BaseBusinessToolItemViewHolder.a {
    public static final /* synthetic */ int g = 0;
    public Map<Integer, View> a;
    public final long b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public so0.a f;

    public static final class a implements ShelfManagementCardListAdapterV2.OnItemClickListener {
        public final /* synthetic */ ShelfManagementActivityV2 a;

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivityV2$a$a, reason: collision with other inner class name */
        public static final class DialogInterfaceOnClickListenerC0148a implements DialogInterface.OnClickListener {
            public static final DialogInterfaceOnClickListenerC0148a a = null;

            static {
                a = new DialogInterfaceOnClickListenerC0148a();
            }

            public DialogInterfaceOnClickListenerC0148a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r1, int r2) {
                r1.dismiss();
            }
        }

        public a(ShelfManagementActivityV2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementCardListAdapterV2.OnItemClickListener
        public final void a(ShelfCardInfo r5, ShelfManagementCardListAdapterV2.OnItemClickListener.ClickPosition r6, int r7) {
            Intrinsics.checkNotNullParameter(r5, "shelfCardInfo");
            Intrinsics.checkNotNullParameter(r6, "clickPosition");
            if (r6 != ShelfManagementCardListAdapterV2.OnItemClickListener.ClickPosition.REVIEW_REJECTED) goto L16;
            AppCompatActivity r8 = this.a;
            x0.d r9 = new x0.d();
            r9.b = r8;
            r9.a = 4;
            r9.c = r8.getString(2131921051);
            r9.d = r5.W();
            String r10 = this.a.getString(2131921050);
            DialogInterfaceOnClickListenerC0148a r11 = DialogInterfaceOnClickListenerC0148a.a;
            x0.c[] r0 = r9.g;
            x0.c r2 = r0[0];
            if (r2 != null) goto L7;
            r2 = new x0.c();
            r0[0] = r2;
        L7:
            r2.a = r10;
            r2.b = r11;
            x0.c r12 = r0[0];
            if (r12 != null) goto L10;
            r12 = new x0.c();
            r0[0] = r12;
        L10:
            r12.c = true;
            r9.k = true;
            r9.l = true;
            x0 r13 = new x0(r9.b, r9);
            if (DialogLancet.shouldBlockDialogShow(r13) == false) goto L41;
            DialogLancet.handleBlockedDialogShow(r13);
            return;
        L41:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L37
        L14:
            DialogLancet.beforeDialogShow(r13);
            r13.show();
            DialogLancet.afterDialogShow(r13);
            return;
        L16:
            if (r6 != ShelfManagementCardListAdapterV2.OnItemClickListener.ClickPosition.MORE) goto L35;
            int r14 = ShelfManagementCardMoreDialog.h;
            ShelfManagementActivityV2 r15 = this.a;
            Intrinsics.checkNotNullParameter(r15, "activity");
            Intrinsics.checkNotNullParameter(r5, "cardInfo");
            ShelfManagementCardMoreDialog r1 = new ShelfManagementCardMoreDialog();
            Bundle r3 = new Bundle();
            r3.putParcelable("card_info", r5);
            r3.putInt("card_position", r7);
            Unit r16 = Unit.INSTANCE;
            r1.setArguments(r3);
            FragmentManager r17 = r15.getSupportFragmentManager();
            LandscapeRestrictionOperation r18 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "ShelfManagementMoreDialog", r18);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r17, r1, r18) == false) goto L39;
        L22:
            OpenPlatformContext r19 = this.a.B1().a();
            if (r19 == null) goto L45;
            AnchorMiniAppAppLogContextService r20 = (AnchorMiniAppAppLogContextService) r19.getService(AnchorMiniAppAppLogContextService.class);
            if (r20 == null) goto L46;
            ShelfMicroAppInfo r21 = this.a.C1().getShelfAppInfo();
            if (r21 == null) goto L30;
            String r22 = r21.appId;
            if (r22 == null) goto L30;
        L31:
            Integer r23 = (Integer) this.a.C1().getPageCount().getValue();
            if (r23 != null) goto L34;
            r23 = 0;
        L34:
            r20.reportShelfSettingPageOperate(r22, "click_more", r23.intValue(), this.a.C1().getSelectedCount());
            return;
        L30:
            r22 = "";
            goto L31
        L46:
            return;
        L45:
            return;
        L39:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L38
        L21:
            r1.show(r17, "ShelfManagementMoreDialog");
            goto L22
        L35:
            this.a.C1().openCardLandingPage(r5);
        }
    }

    public static final class b implements ShelfManagementCardListAdapterV2.a {
        public final /* synthetic */ ShelfManagementActivityV2 a;

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementCardListAdapterV2.a
        public final void a() {
            OpenPlatformContext r0 = this.a.B1().a();
            if (r0 == null) goto L13;
            AnchorMiniAppAppLogContextService r1 = (AnchorMiniAppAppLogContextService) r0.getService(AnchorMiniAppAppLogContextService.class);
            if (r1 == null) goto L14;
            ShelfMicroAppInfo r2 = this.a.C1().getShelfAppInfo();
            if (r2 == null) goto L10;
            String r3 = r2.appId;
            if (r3 == null) goto L10;
        L11:
            r1.reportPageShelfBubblePush(r3, "sell_point_guide");
            return;
        L10:
            r3 = "";
            goto L11
        L14:
            return;
        }

        public b(ShelfManagementActivityV2 r1) {
            this.a = r1;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ShelfManagementActivityV2 a;

        public c(ShelfManagementActivityV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            List r7 = (List) r6;
            if (r7 == null) goto L18;
            ShelfManagementCardListAdapterV2 r0 = this.a.A1();
            r0.getClass();
            Intrinsics.checkNotNullParameter(r7, "value");
            ArrayList r1 = new ArrayList();
            r1.addAll(r7);
            Unit r8 = Unit.INSTANCE;
            r0.f = r1;
            r0.notifyDataSetChanged();
            ((CheckBox) this.a._$_findCachedViewById(2131385778)).setChecked(this.a.C1().isSelectedAll());
            int r9 = this.a.C1().getSelectedCount();
            TextView r2 = (TextView) this.a._$_findCachedViewById(2131364009);
            StringBuilder r3 = new StringBuilder();
            r3.append(s1.B(2131920937));
            if (r9 <= 0) goto L7;
            String r4 = "(" + r9 + ')';
        L8:
            r3.append(r4);
            r2.setText(r3.toString());
            TextView r5 = (TextView) this.a._$_findCachedViewById(2131364009);
            if (r9 <= 0) goto L11;
            int r10 = 2131108464;
        L12:
            r5.setTextColor(s1.h(r10));
            TextView r11 = (TextView) this.a._$_findCachedViewById(2131364009);
            if (r9 <= 0) goto L15;
            boolean r12 = true;
        L16:
            r11.setEnabled(r12);
            return;
        L15:
            r12 = false;
            goto L16
        L11:
            r10 = 2131107363;
            goto L12
        L7:
            r4 = "";
            goto L8
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ ShelfManagementActivityV2 a;

        public d(ShelfManagementActivityV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (((CheckBox) this.a._$_findCachedViewById(2131385778)).isChecked() == false) goto L5;
            this.a.C1().selectedAll();
            return;
        L5:
            this.a.C1().unselectedAll();
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ ShelfManagementActivityV2 a;

        public e(ShelfManagementActivityV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L6;
            this.a.finish();
            return;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ ShelfManagementActivityV2 a;

        public f(ShelfManagementActivityV2 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.C1().onPageFirstFrameShown();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ ShelfManagementActivityV2 a;

        public g(ShelfManagementActivityV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Integer r5 = (Integer) r4;
            if (r5 == null) goto L6;
            ((OpenPlatformTitleBar) this.a._$_findCachedViewById(2131388807)).setTitle("展示页(" + r5 + ')');
            return;
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ ShelfManagementActivityV2 a;

        public h(ShelfManagementActivityV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.finish();
        }
    }

    public static final class i implements View.OnClickListener {
        public final /* synthetic */ ShelfManagementActivityV2 a;

        public i(ShelfManagementActivityV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            OpenPlatformContext r10 = this.a.B1().a();
            String r0 = "";
            if (r10 == null) goto L17;
            AnchorMiniAppAppLogContextService r1 = (AnchorMiniAppAppLogContextService) r10.getService(AnchorMiniAppAppLogContextService.class);
            if (r1 == null) goto L17;
            ShelfMicroAppInfo r11 = this.a.C1().getShelfAppInfo();
            if (r11 == null) goto L12;
            String r12 = r11.appId;
            if (r12 == null) goto L12;
            String r2 = r12;
        L13:
            Integer r13 = (Integer) this.a.C1().getPageCount().getValue();
            if (r13 != null) goto L16;
            r13 = 0;
        L16:
            AnchorMiniAppAppLogContextService.reportShelfSettingPageOperate$default(r1, r2, "click_setting", r13.intValue(), 0, 8, null);
        L12:
            r2 = "";
        L17:
            int r14 = ShelfManagementSettingDialog.j;
            ShelfManagementActivityV2 r15 = this.a;
            Bundle r3 = new Bundle();
            ShelfMicroAppInfo r4 = this.a.C1().getShelfAppInfo();
            if (r4 == null) goto L21;
            String r5 = r4.appId;
            if (r5 == null) goto L21;
        L22:
            r3.putString("app_id", r5);
            List r6 = (List) this.a.C1().getShelfCardInfoList().getValue();
            if (r6 == null) goto L32;
            aq0.a r7 = (aq0.a) CollectionsKt.firstOrNull(r6);
            if (r7 == null) goto L32;
            ShelfCardInfo r8 = r7.a;
            if (r8 == null) goto L32;
            String r16 = r8.a0();
            if (r16 == null) goto L32;
            r0 = r16;
        L32:
            r3.putString("schema", r0);
            Unit r17 = Unit.INSTANCE;
            ShelfManagementSettingDialog.b.a(r15, r3);
            return;
        L21:
            r5 = "";
            goto L22
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivityV2$initView$14, reason: invalid class name */
    public static final class AnonymousClass14 implements View.OnClickListener {
        public final /* synthetic */ ShelfManagementActivityV2 a;

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivityV2$initView$14$a */
        public static final class a implements DialogInterface.OnClickListener {
            public final /* synthetic */ AnonymousClass14 a;

            public a(AnonymousClass14 r1) {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r4, int r5) {
                if (this.a.a.C1().isSelectedAll() == false) goto L14;
                OpenPlatformContext r6 = this.a.a.B1().a();
                if (r6 == null) goto L14;
                AnchorMiniAppAppLogContextService r7 = (AnchorMiniAppAppLogContextService) r6.getService(AnchorMiniAppAppLogContextService.class);
                if (r7 == null) goto L14;
                ShelfMicroAppInfo r0 = this.a.a.C1().getShelfAppInfo();
                if (r0 == null) goto L12;
                String r1 = r0.appId;
                if (r1 == null) goto L12;
            L13:
                r7.reportExitBindPushClick(r1, "all_delete", "cancel");
            L12:
                r1 = "";
            L14:
                r4.dismiss();
            }
        }

        public AnonymousClass14(ShelfManagementActivityV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            x0.b r6 = new x0.b(this.a, 7);
            if (this.a.C1().isSelectedAll() == false) goto L6;
            r6.a.c = s1.B(2131920885);
            r6.a.d = s1.B(2131920884);
        L9:
            r6.j(0, s1.B(2131920937), new AnonymousClass2(this));
            r6.j(1, s1.B(2131920891), new a(this));
            r6.setCornerRadius(16.0f);
            r6.k(0, true);
            r6.n();
            OpenPlatformContext r7 = this.a.B1().a();
            if (r7 == null) goto L20;
            AnchorMiniAppAppLogContextService r8 = (AnchorMiniAppAppLogContextService) r7.getService(AnchorMiniAppAppLogContextService.class);
            if (r8 == null) goto L21;
            ShelfMicroAppInfo r0 = this.a.C1().getShelfAppInfo();
            if (r0 == null) goto L17;
            String r1 = r0.appId;
            if (r1 == null) goto L17;
        L18:
            r8.reportExitBindPushShow(r1, "all_delete");
            return;
        L17:
            r1 = "";
            goto L18
        L21:
            return;
        L20:
            return;
        L6:
            if (this.a.C1().isSelectedExplainingCard() == false) goto L8;
            r6.a.c = s1.B(2131920888);
            r6.a.d = s1.B(2131920887);
            goto L9
        L8:
            r6.a.c = s1.B(2131920886);
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivityV2$initView$9, reason: invalid class name */
    public static final class AnonymousClass9 implements ShelfManagementCardListAdapterV2.c {
        public final /* synthetic */ ShelfManagementActivityV2 a;

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementCardListAdapterV2.c
        public final void a() {
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementCardListAdapterV2.c
        public final void c() {
            OpenPlatformContext r0 = this.a.B1().a();
            if (r0 == null) goto L16;
            AnchorMiniAppAppLogContextService r1 = (AnchorMiniAppAppLogContextService) r0.getService(AnchorMiniAppAppLogContextService.class);
            if (r1 == null) goto L17;
            ShelfMicroAppInfo r2 = this.a.C1().getShelfAppInfo();
            if (r2 == null) goto L10;
            String r3 = r2.appId;
            if (r3 == null) goto L10;
        L11:
            String r4 = r3;
            Integer r5 = (Integer) this.a.C1().getPageCount().getValue();
            if (r5 != null) goto L14;
            r5 = 0;
        L14:
            AnchorMiniAppAppLogContextService.reportShelfSettingPageOperate$default(r1, r4, "long_press_card", r5.intValue(), 0, 8, null);
            return;
        L10:
            r3 = "";
            goto L11
        L17:
            return;
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementCardListAdapterV2.c
        public final void g() {
            ShelfManagementViewModelV2 r1 = this.a.C1();
            List<aq0.a> r0 = this.a.A1().f;
            ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
            Iterator<T> r3 = r0.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            r2.add(((aq0.a) r3.next()).a);
            goto L4
        L6:
            ShelfManagementViewModelV2.saveSort$default(r1, r2, null, new ShelfManagementActivityV2$initView$9$onStopDrag$2(this), 2, null);
        }

        public AnonymousClass9(ShelfManagementActivityV2 r1) {
            this.a = r1;
        }
    }

    public static final class j implements Runnable {
        public final /* synthetic */ ShelfManagementActivityV2 a;

        public j(ShelfManagementActivityV2 r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v3, types: [android.app.Activity, com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivityV2] */
        public final void a() {
            if (((uc1) ee0.a.getValue()).u() != 1) goto L20;
            int r0 = xq0.a.a;
            com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.b.I3;
            if (((Boolean) r1.getValue()).booleanValue() == false) goto L21;
            ?? r2 = this.a;
            int r3 = ShelfManagementActivityV2.g;
            ((OpenPlatformTitleBar) r2._$_findCachedViewById(2131388807)).b(r2, 1, new ko0.f(r2.getString(2131920908), 3000, 0, 4));
            Boolean r4 = Boolean.FALSE;
            r1.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r1, r4);
            so0.a r5 = r2.f;
            if (r5 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
        L9:
            OpenPlatformContext r6 = r5.a();
            if (r6 == null) goto L22;
            AnchorMiniAppAppLogContextService r7 = (AnchorMiniAppAppLogContextService) r6.getService(AnchorMiniAppAppLogContextService.class);
            if (r7 == null) goto L23;
            ShelfMicroAppInfo r8 = r2.C1().getShelfAppInfo();
            if (r8 == null) goto L17;
            String r9 = r8.appId;
            if (r9 == null) goto L17;
        L18:
            r7.reportPageShelfBubblePush(r9, "real_time_data_show");
            return;
        L17:
            r9 = "";
            goto L18
        L23:
            return;
        L22:
            return;
        L21:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class k<T> implements Observer {
        public final /* synthetic */ ShelfManagementActivityV2 a;

        public k(ShelfManagementActivityV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Map r4 = (Map) r3;
            if ((!r4.isEmpty()) == false) goto L5;
            ((LinearLayout) this.a._$_findCachedViewById(2131364977)).setVisibility(0);
            ShelfManagementActivityV2.z1(this.a).y2(CollectionsKt.toList(r4.values()));
            return;
        L5:
            ((LinearLayout) this.a._$_findCachedViewById(2131364977)).setVisibility(8);
        }
    }

    public static final class l implements View.OnClickListener {
        public final /* synthetic */ ShelfManagementActivityV2 a;

        public l(ShelfManagementActivityV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.C1().newExplainCard();
        }
    }

    public static final class m implements ShelfManagementCardListAdapterV2.b {
        public final /* synthetic */ ShelfManagementActivityV2 a;

        public m(ShelfManagementActivityV2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementCardListAdapterV2.b
        public final void a(ShelfCardInfo r9, int r10) {
            Intrinsics.checkNotNullParameter(r9, "shelfCardInfo");
            OpenPlatformContext r0 = this.a.B1().a();
            if (r0 == null) goto L15;
            AnchorMiniAppAppLogContextService r1 = (AnchorMiniAppAppLogContextService) r0.getService(AnchorMiniAppAppLogContextService.class);
            if (r1 == null) goto L15;
            ShelfMicroAppInfo r2 = this.a.C1().getShelfAppInfo();
            if (r2 == null) goto L10;
            String r3 = r2.appId;
            if (r3 == null) goto L10;
        L11:
            String r4 = r3;
            Integer r5 = (Integer) this.a.C1().getPageCount().getValue();
            if (r5 != null) goto L14;
            r5 = 0;
        L14:
            AnchorMiniAppAppLogContextService.reportShelfSettingPageOperate$default(r1, r4, "click_set_card", r5.intValue(), 0, 8, null);
        L10:
            r3 = "";
        L15:
            this.a.C1().editExplainCard(r9, r10);
        }
    }

    public static final class n implements ShelfManagementCardListAdapterV2.d {
        public final /* synthetic */ ShelfManagementActivityV2 a;

        public n(ShelfManagementActivityV2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementCardListAdapterV2.d
        public final void a(int r2) {
            this.a.C1().selectCard(r2);
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementCardListAdapterV2.d
        public final void b(int r2) {
            this.a.C1().unselectCard(r2);
        }
    }

    public final ShelfManagementCardListAdapterV2 A1() {
        return (ShelfManagementCardListAdapterV2) this.d.getValue();
    }

    public final T C1() {
        return (T) this.c.getValue();
    }

    public abstract T D1();

    public final so0.a B1() {
        so0.a r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        return r0;
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
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

    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        long r0 = System.currentTimeMillis() - this.b;
        so0.a r2 = this.f;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L8:
        OpenPlatformContext r3 = r2.a();
        if (r3 == null) goto L19;
        AnchorMiniAppAppLogContextService r4 = (AnchorMiniAppAppLogContextService) r3.getService(AnchorMiniAppAppLogContextService.class);
        if (r4 == null) goto L20;
        ShelfMicroAppInfo r5 = C1().getShelfAppInfo();
        if (r5 == null) goto L16;
        String r6 = r5.appId;
        if (r6 == null) goto L16;
    L17:
        r4.reportShelfSettingPageStayDuration(r6, r0);
        return;
    L16:
        r6 = "";
        goto L17
    L20:
        return;
    }

    public ShelfManagementActivityV2() {
        this.a = new LinkedHashMap();
        this.b = System.currentTimeMillis();
        this.c = LazyKt.lazy(new ShelfManagementActivityV2$viewModel$2(this));
        this.d = LazyKt.lazy(new ShelfManagementActivityV2$adapter$2(this));
        this.e = LazyKt.lazy(new ShelfManagementActivityV2$businessToolsAdapter$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initView() {
        C1().getPageCount().observe(this, new g(this));
        ((OpenPlatformTitleBar) _$_findCachedViewById(2131388807)).setLeftIconDrawable(2131252526);
        ((OpenPlatformTitleBar) _$_findCachedViewById(2131388807)).setLeftIconVisibility(true);
        ((OpenPlatformTitleBar) _$_findCachedViewById(2131388807)).setOnLeftIconClickListener(new h(this));
        ((OpenPlatformTitleBar) _$_findCachedViewById(2131388807)).setRightIconDrawable(2131252549);
        ((OpenPlatformTitleBar) _$_findCachedViewById(2131388807)).setRightIconVisibility(true);
        ((OpenPlatformTitleBar) _$_findCachedViewById(2131388807)).setOnRightIconClickListener(new i(this));
        int r5 = 2;
        if (C1().getEnterTimes() != 2) goto L17;
        ((OpenPlatformTitleBar) _$_findCachedViewById(2131388807)).b(this, 1, new ko0.f(s1.B(2131920974), 0, 0, 6));
        so0.a r1 = this.f;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L7:
        OpenPlatformContext r2 = r1.a();
        if (r2 == null) goto L17;
        AnchorMiniAppAppLogContextService r3 = (AnchorMiniAppAppLogContextService) r2.getService(AnchorMiniAppAppLogContextService.class);
        if (r3 == null) goto L17;
        ShelfMicroAppInfo r6 = C1().getShelfAppInfo();
        if (r6 == null) goto L15;
        String r7 = r6.appId;
        if (r7 == null) goto L15;
    L16:
        r3.reportPageShelfBubblePush(r7, "auto_bind_guide");
    L15:
        r7 = "";
    L17:
        ((OpenPlatformTitleBar) _$_findCachedViewById(2131388807)).post(new j(this));
        _$_findCachedViewById(2131364978).setAdapter((ShelfManagementBusinessToolsAdapter) this.e.getValue());
        _$_findCachedViewById(2131364978).setLayoutManager(new GridLayoutManager(this, 2));
        C1().getBusinessToolsData().observe(this, new k(this));
        so0.a r0 = this.f;
        if (r0 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L20:
        OpenPlatformContext r4 = r0.a();
        if (r4 == null) goto L30;
        AnchorMiniAppAppLogContextService r8 = (AnchorMiniAppAppLogContextService) r4.getService(AnchorMiniAppAppLogContextService.class);
        if (r8 == null) goto L30;
        ShelfMicroAppInfo r9 = C1().getShelfAppInfo();
        if (r9 == null) goto L28;
        String r10 = r9.appId;
        if (r10 == null) goto L28;
    L29:
        r8.reportMpShow(r10, "shelf_setting_page");
    L28:
        r10 = "";
    L30:
        ((LinearLayout) _$_findCachedViewById(2131380754)).setOnClickListener(new l(this));
        HSImageView r11 = _$_findCachedViewById(2131363092);
        ShelfMicroAppInfo r12 = C1().getShelfAppInfo();
        if (r12 == null) goto L37;
        ImageModel r13 = r12.icon;
        if (r13 == null) goto L37;
        List r14 = r13.getUrls();
        if (r14 == null) goto L37;
        String r15 = (String) CollectionsKt.firstOrNull(r14);
    L38:
        ImageLoader.bindImage(r11, r15);
        TextView r16 = (TextView) _$_findCachedViewById(2131363102);
        ShelfMicroAppInfo r17 = C1().getShelfAppInfo();
        if (r17 == null) goto L41;
        String r18 = r17.name;
    L42:
        r16.setText(r18);
        ShelfManagementCardListAdapterV2 r19 = A1();
        m r20 = new m(this);
        r19.getClass();
        Intrinsics.checkNotNullParameter(r20, "listener");
        r19.a = r20;
        ShelfManagementCardListAdapterV2 r21 = A1();
        n r22 = new n(this);
        r21.getClass();
        Intrinsics.checkNotNullParameter(r22, "listener");
        r21.b = r22;
        ShelfManagementCardListAdapterV2 r23 = A1();
        AnonymousClass9 r24 = new AnonymousClass9(this);
        r23.getClass();
        Intrinsics.checkNotNullParameter(r24, "listener");
        r23.c = r24;
        ShelfManagementCardListAdapterV2 r25 = A1();
        a r26 = new a(this);
        r25.getClass();
        Intrinsics.checkNotNullParameter(r26, "listener");
        r25.d = r26;
        ShelfManagementCardListAdapterV2 r27 = A1();
        b r28 = new b(this);
        r27.getClass();
        Intrinsics.checkNotNullParameter(r28, "callback");
        r27.e = r28;
        _$_findCachedViewById(2131386213).setAdapter(A1());
        _$_findCachedViewById(2131386213).setLayoutManager(new LinearLayoutManager(this, 1, false));
        new ItemTouchHelper(new ShelfItemTouchHelperCallback(A1())).attachToRecyclerView(_$_findCachedViewById(2131386213));
        C1().getShelfCardInfoList().observe(this, new c(this));
        ((CheckBox) _$_findCachedViewById(2131385778)).setOnClickListener(new d(this));
        ((TextView) _$_findCachedViewById(2131364009)).setOnClickListener(new AnonymousClass14(this));
        C1().getFinish().observe(this, new e(this));
        ((FrameLayout) _$_findCachedViewById(2131364422)).post(new f(this));
        HashMap<String, zo0.f> r29 = zo0.g.a;
        zo0.f r30 = zo0.h.b(PerformanceScene.SHELF_MANAGEMENT_PAGE);
        int r31 = zo0.f.d;
        r30.l("view_created", null);
        so0.a r32 = this.f;
        if (r32 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L45:
        OpenPlatformContext r33 = r32.a();
        if (r33 != null) goto L48;
    L50:
        r5 = 1;
    L51:
        int r34 = no0.a.a;
        no0.a.d(1, r5, 3, "", "");
        return;
    L48:
        if (r33.isInLive() != true) goto L50;
    L41:
        r18 = null;
    L37:
        r15 = null;
        goto L38
    }

    public static View y1(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static final ShelfManagementBusinessToolsAdapter z1(ShelfManagementActivityV2 r0) {
        return (ShelfManagementBusinessToolsAdapter) r0.e.getValue();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.viewholder.BaseBusinessToolItemViewHolder.a
    public void E(bq0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        BusinessToolType r3 = r2.b();
        int r4 = com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.c.b[r3.ordinal()];
    }

    public View _$_findCachedViewById(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.viewholder.BaseBusinessToolItemViewHolder.a
    public void g1(bq0.a r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        BusinessToolType r0 = r3.b();
        if (com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.c.a[r0.ordinal()] == 1) goto L6;
        return;
    L6:
        if ((r3 instanceof bq0.c) == false) goto L14;
        int r1 = PrivateMsgSettingDialog.g;
        ShelfMicroAppInfo r2 = C1().getShelfAppInfo();
        if (r2 == null) goto L11;
        String r4 = r2.appId;
        if (r4 == null) goto L11;
    L12:
        bq0.c r5 = (bq0.c) r3;
        PrivateMsgSettingDialog.a.a(this, r4, r5.e, r5.f);
        return;
    L11:
        r4 = "";
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r7) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r7);
        int r8 = Build.VERSION.SDK_INT;
        if (r8 == 26) goto L13;
        setRequestedOrientation(1);
    L13:
        setContentView(2131565126);
        C1().recordEnterTimes();
        getIntent();
        C1().initData();
        if (getWindow() == null) goto L17;
        Window r0 = getWindow();
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        r0.addFlags(ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION);
        getWindow().clearFlags(67108864);
        getWindow().setStatusBarColor(s1.h(2131107100));
    L17:
        if (r8 < 23) goto L19;
        y1(getWindow()).setSystemUiVisibility(y1(getWindow()).getSystemUiVisibility() | 8192);
    L19:
        initView();
        if (C1().getEnterTimes() != 1) goto L22;
        int r9 = ShelfManagementIntroduceDialog.e;
        ShelfManagementIntroduceDialog.a.a(this);
    L22:
        so0.a r10 = this.f;
        if (r10 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L25:
        OpenPlatformContext r11 = r10.a();
        if (r11 == null) goto L67;
        AnchorMiniAppAppLogContextService r12 = (AnchorMiniAppAppLogContextService) r11.getService(AnchorMiniAppAppLogContextService.class);
        if (r12 == null) goto L68;
        ShelfMicroAppInfo r1 = C1().getShelfAppInfo();
        String r2 = "";
        if (r1 == null) goto L33;
        String r3 = r1.appId;
        if (r3 == null) goto L33;
    L34:
        Integer r4 = (Integer) C1().getPageCount().getValue();
        int r5 = 0;
        if (r4 != null) goto L37;
        r4 = 0;
    L37:
        int r6 = r4.intValue();
        String r13 = getIntent().getStringExtra("click_source");
        if (r13 == null) goto L41;
        r2 = r13;
    L41:
        List r14 = (List) C1().getShelfCardInfoList().getValue();
        if (r14 == null) goto L56;
        List r15 = r14;
        if ((r15 instanceof Collection) == true) goto L46;
    L48:
        Iterator r16 = r15.iterator();
    L50:
        if (r16.hasNext() == false) goto L56;
        if (r2.a(((aq0.a) r16.next()).a.b()) == false) goto L50;
        r5 = r5 + 1;
        if (r5 >= 0) goto L50;
        CollectionsKt.throwCountOverflow();
        goto L50
    L46:
        if (r15.isEmpty() == false) goto L48;
    L56:
        r12.reportShelfSettingPageShow(r3, r6, r2, r5);
        return;
    L33:
        r3 = "";
        goto L34
    L68:
        return;
    }

    public void onNewIntent(Intent r1) {
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(r1);
        C1().initData();
    }
}
