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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
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
import com.bytedance.android.live.openplatform.impl.base.view.OpenPlatformTitleBar;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.PrivateMsgSettingDialog;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.ShelfManagementBusinessToolsAdapter;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.model.BusinessToolType;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.viewholder.BaseBusinessToolItemViewHolder;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.viewmodel.ShelfManagementViewModel;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.viewmodel.preview.PreviewShelfManagementViewModel;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.android.livesdk.widget.x0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementActivity;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/viewmodel/ShelfManagementViewModel;", "T", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/businesstools/viewholder/BaseBusinessToolItemViewHolder$a;", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ShelfManagementActivity<T extends ShelfManagementViewModel> extends AppCompatActivity implements BaseBusinessToolItemViewHolder.a {
    public static final /* synthetic */ int f = 0;
    public Map<Integer, View> a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public so0.a e;

    public static final class a<T> implements Observer {
        public final /* synthetic */ ShelfManagementActivity a;

        public a(ShelfManagementActivity r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            List r6 = (List) r5;
            if (r6 == null) goto L10;
            ShelfManagementCardListAdapter r0 = this.a.z1();
            ArrayList r1 = new ArrayList();
            r1.addAll(r6);
            Unit r7 = Unit.INSTANCE;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "value");
            r0.f = r1;
            int r8 = r1.size();
            Boolean[] r2 = new Boolean[r8];
            int r3 = 0;
        L5:
            if (r3 >= r8) goto L7;
            r2[r3] = Boolean.FALSE;
            r3 = r3 + 1;
            goto L5
        L7:
            r0.g = r2;
            this.a.z1().notifyDataSetChanged();
            return;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ShelfManagementActivity a;

        public b(ShelfManagementActivity r1) {
            this.a = r1;
        }

        public final void onChanged(Object r13) {
            if (Intrinsics.areEqual((Boolean) r13, Boolean.TRUE) == false) goto L5;
            ((LinearLayout) this.a._$_findCachedViewById(2131364424)).setVisibility(8);
            ((LinearLayout) this.a._$_findCachedViewById(2131364423)).setVisibility(0);
            ShelfManagementCardListAdapter r14 = this.a.z1();
            r14.e = true;
            ArraysKt.fill$default(r14.g, Boolean.FALSE, 0, 0, 6, null);
            r14.notifyDataSetChanged();
            ((OpenPlatformTitleBar) this.a._$_findCachedViewById(2131388807)).setLeftIconVisibility(false);
            return;
        L5:
            ((LinearLayout) this.a._$_findCachedViewById(2131364424)).setVisibility(0);
            ((LinearLayout) this.a._$_findCachedViewById(2131364423)).setVisibility(8);
            ShelfManagementCardListAdapter r15 = this.a.z1();
            r15.e = false;
            ArraysKt.fill$default(r15.g, Boolean.FALSE, 0, 0, 6, null);
            r15.notifyDataSetChanged();
            ((OpenPlatformTitleBar) this.a._$_findCachedViewById(2131388807)).setLeftIconVisibility(true);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ShelfManagementActivity a;

        public c(ShelfManagementActivity r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            this.a.B1().startEditShelf();
            OpenPlatformContext r9 = this.a.A1().a();
            if (r9 == null) goto L16;
            AnchorMiniAppAppLogContextService r0 = (AnchorMiniAppAppLogContextService) r9.getService(AnchorMiniAppAppLogContextService.class);
            if (r0 == null) goto L17;
            ShelfMicroAppInfo r10 = this.a.B1().getShelfAppInfo();
            if (r10 == null) goto L10;
            String r11 = r10.appId;
            if (r11 == null) goto L10;
        L11:
            String r1 = r11;
            Integer r12 = (Integer) this.a.B1().getPageCount().getValue();
            if (r12 != null) goto L14;
            r12 = 0;
        L14:
            AnchorMiniAppAppLogContextService.reportShelfSettingPageOperate$default(r0, r1, "click_edit", r12.intValue(), 0, 8, null);
            return;
        L10:
            r11 = "";
            goto L11
        L17:
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ ShelfManagementActivity a;

        public d(ShelfManagementActivity r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            if (((CheckBox) this.a._$_findCachedViewById(2131385778)).isChecked() == false) goto L5;
            ShelfManagementCardListAdapter r8 = this.a.z1();
            ArraysKt.fill$default(r8.g, Boolean.TRUE, 0, 0, 6, null);
            r8.notifyDataSetChanged();
            this.a.B1().selectedAll();
            return;
        L5:
            ShelfManagementCardListAdapter r9 = this.a.z1();
            ArraysKt.fill$default(r9.g, Boolean.FALSE, 0, 0, 6, null);
            r9.notifyDataSetChanged();
            this.a.B1().unselectedAll();
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ ShelfManagementActivity a;

        public e(ShelfManagementActivity r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            Boolean[] r7 = (Boolean[]) r6;
            ((CheckBox) this.a._$_findCachedViewById(2131385778)).setChecked(this.a.B1().isSelectedAll());
            int r8 = this.a.B1().getSelectedCount();
            TextView r0 = (TextView) this.a._$_findCachedViewById(2131364009);
            StringBuilder r2 = new StringBuilder();
            r2.append(s1.B(2131920937));
            if (r8 <= 0) goto L5;
            String r3 = "(" + r8 + ')';
        L6:
            r2.append(r3);
            r0.setText(r2.toString());
            TextView r1 = (TextView) this.a._$_findCachedViewById(2131364009);
            if (r8 <= 0) goto L9;
            int r4 = 2131252541;
        L10:
            r1.setBackgroundResource(r4);
            TextView r5 = (TextView) this.a._$_findCachedViewById(2131364009);
            if (r8 <= 0) goto L13;
            boolean r9 = true;
        L14:
            r5.setEnabled(r9);
            return;
        L13:
            r9 = false;
            goto L14
        L9:
            r4 = 2131252551;
            goto L10
        L5:
            r3 = "";
            goto L6
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ ShelfManagementActivity a;

        public f(ShelfManagementActivity r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.B1().finishEditShelf();
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ ShelfManagementActivity a;

        public g(ShelfManagementActivity r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L6;
            this.a.finish();
            return;
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ ShelfManagementActivity a;

        public h(ShelfManagementActivity r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Integer r5 = (Integer) r4;
            if (r5 == null) goto L6;
            ((OpenPlatformTitleBar) this.a._$_findCachedViewById(2131388807)).setTitle("展示页(" + r5 + ')');
            return;
        }
    }

    public static final class i implements View.OnClickListener {
        public final /* synthetic */ ShelfManagementActivity a;

        public i(ShelfManagementActivity r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.finish();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivity$initView$16, reason: invalid class name */
    public static final class AnonymousClass16 implements View.OnClickListener {
        public final /* synthetic */ ShelfManagementActivity a;

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivity$initView$16$a */
        public static final class a implements DialogInterface.OnClickListener {
            public final /* synthetic */ AnonymousClass16 a;

            public a(AnonymousClass16 r1) {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r4, int r5) {
                if (this.a.a.B1().isSelectedAll() == false) goto L14;
                OpenPlatformContext r6 = this.a.a.A1().a();
                if (r6 == null) goto L14;
                AnchorMiniAppAppLogContextService r7 = (AnchorMiniAppAppLogContextService) r6.getService(AnchorMiniAppAppLogContextService.class);
                if (r7 == null) goto L14;
                ShelfMicroAppInfo r0 = this.a.a.B1().getShelfAppInfo();
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

        public AnonymousClass16(ShelfManagementActivity r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            x0.b r6 = new x0.b(this.a, 7);
            if (this.a.B1().isSelectedAll() == false) goto L9;
            r6.a.c = s1.B(2131920885);
            if (this.a.B1().isInLive() == false) goto L7;
            r6.a.d = s1.B(2131920884);
        L12:
            r6.j(0, s1.B(2131920937), new AnonymousClass2(this));
            r6.j(1, s1.B(2131920891), new a(this));
            r6.setCornerRadius(16.0f);
            r6.k(0, true);
            r6.n();
            OpenPlatformContext r7 = this.a.A1().a();
            if (r7 == null) goto L23;
            AnchorMiniAppAppLogContextService r8 = (AnchorMiniAppAppLogContextService) r7.getService(AnchorMiniAppAppLogContextService.class);
            if (r8 == null) goto L24;
            ShelfMicroAppInfo r0 = this.a.B1().getShelfAppInfo();
            if (r0 == null) goto L20;
            String r1 = r0.appId;
            if (r1 == null) goto L20;
        L21:
            r8.reportExitBindPushShow(r1, "all_delete");
            return;
        L20:
            r1 = "";
            goto L21
        L24:
            return;
        L23:
            return;
        L7:
            r6.a.d = s1.B(2131920883);
            goto L12
        L9:
            if (this.a.B1().isSelectedExplainingCard() == false) goto L11;
            r6.a.c = s1.B(2131920888);
            r6.a.d = s1.B(2131920887);
            goto L12
        L11:
            r6.a.c = s1.B(2131920886);
            goto L12
        }
    }

    public static final class j implements View.OnClickListener {
        public final /* synthetic */ ShelfManagementActivity a;

        public j(ShelfManagementActivity r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            OpenPlatformContext r10 = this.a.A1().a();
            String r0 = "";
            if (r10 == null) goto L17;
            AnchorMiniAppAppLogContextService r1 = (AnchorMiniAppAppLogContextService) r10.getService(AnchorMiniAppAppLogContextService.class);
            if (r1 == null) goto L17;
            ShelfMicroAppInfo r11 = this.a.B1().getShelfAppInfo();
            if (r11 == null) goto L12;
            String r12 = r11.appId;
            if (r12 == null) goto L12;
            String r2 = r12;
        L13:
            Integer r13 = (Integer) this.a.B1().getPageCount().getValue();
            if (r13 != null) goto L16;
            r13 = 0;
        L16:
            AnchorMiniAppAppLogContextService.reportShelfSettingPageOperate$default(r1, r2, "click_setting", r13.intValue(), 0, 8, null);
        L12:
            r2 = "";
        L17:
            int r14 = ShelfManagementSettingDialog.j;
            ShelfManagementActivity r15 = this.a;
            Bundle r3 = new Bundle();
            ShelfMicroAppInfo r4 = this.a.B1().getShelfAppInfo();
            if (r4 == null) goto L21;
            String r5 = r4.appId;
            if (r5 == null) goto L21;
        L22:
            r3.putString("app_id", r5);
            List r6 = (List) this.a.B1().getShelfCardInfo().getValue();
            if (r6 == null) goto L30;
            ShelfCardInfo r7 = (ShelfCardInfo) CollectionsKt.firstOrNull(r6);
            if (r7 == null) goto L30;
            String r8 = r7.a0();
            if (r8 == null) goto L30;
            r0 = r8;
        L30:
            r3.putString("schema", r0);
            Unit r16 = Unit.INSTANCE;
            ShelfManagementSettingDialog.b.a(r15, r3);
            return;
        L21:
            r5 = "";
            goto L22
        }
    }

    public static final class k implements Runnable {
        public final /* synthetic */ ShelfManagementActivity a;

        public k(ShelfManagementActivity r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v3, types: [android.app.Activity, com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivity] */
        public final void a() {
            if (((uc1) ee0.a.getValue()).u() != 1) goto L20;
            int r0 = xq0.a.a;
            com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.b.I3;
            if (((Boolean) r1.getValue()).booleanValue() == false) goto L21;
            ?? r2 = this.a;
            int r3 = ShelfManagementActivity.f;
            ((OpenPlatformTitleBar) r2._$_findCachedViewById(2131388807)).b(r2, 1, new ko0.f(r2.getString(2131920908), 3000, 0, 4));
            Boolean r4 = Boolean.FALSE;
            r1.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r1, r4);
            so0.a r5 = r2.e;
            if (r5 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
        L9:
            OpenPlatformContext r6 = r5.a();
            if (r6 == null) goto L22;
            AnchorMiniAppAppLogContextService r7 = (AnchorMiniAppAppLogContextService) r6.getService(AnchorMiniAppAppLogContextService.class);
            if (r7 == null) goto L23;
            ShelfMicroAppInfo r8 = r2.B1().getShelfAppInfo();
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

    public static final class l<T> implements Observer {
        public final /* synthetic */ ShelfManagementActivity a;

        public l(ShelfManagementActivity r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Map r4 = (Map) r3;
            if ((!r4.isEmpty()) == false) goto L5;
            ((LinearLayout) this.a._$_findCachedViewById(2131364977)).setVisibility(0);
            ((ShelfManagementBusinessToolsAdapter) this.a.d.getValue()).y2(CollectionsKt.toList(r4.values()));
            return;
        L5:
            ((LinearLayout) this.a._$_findCachedViewById(2131364977)).setVisibility(8);
        }
    }

    public static final class m implements View.OnClickListener {
        public final /* synthetic */ ShelfManagementActivity a;

        public m(ShelfManagementActivity r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.B1().newExplainCard();
        }
    }

    public static final class n implements ShelfManagementCardListAdapter.a {
        public final /* synthetic */ ShelfManagementActivity a;

        public n(ShelfManagementActivity r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementCardListAdapter.a
        public final void a(ShelfCardInfo r9) {
            Intrinsics.checkNotNullParameter(r9, "shelfCardInfo");
            OpenPlatformContext r0 = this.a.A1().a();
            if (r0 == null) goto L15;
            AnchorMiniAppAppLogContextService r1 = (AnchorMiniAppAppLogContextService) r0.getService(AnchorMiniAppAppLogContextService.class);
            if (r1 == null) goto L15;
            ShelfMicroAppInfo r2 = this.a.B1().getShelfAppInfo();
            if (r2 == null) goto L10;
            String r3 = r2.appId;
            if (r3 == null) goto L10;
        L11:
            String r4 = r3;
            Integer r5 = (Integer) this.a.B1().getPageCount().getValue();
            if (r5 != null) goto L14;
            r5 = 0;
        L14:
            AnchorMiniAppAppLogContextService.reportShelfSettingPageOperate$default(r1, r4, "click_set_card", r5.intValue(), 0, 8, null);
        L10:
            r3 = "";
        L15:
            this.a.B1().editExplainCard(r9);
        }
    }

    public static final class o implements ShelfManagementCardListAdapter.c {
        public final /* synthetic */ ShelfManagementActivity a;

        public o(ShelfManagementActivity r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementCardListAdapter.c
        public final void a(int r2) {
            this.a.B1().selectCard(r2);
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementCardListAdapter.c
        public final void b(int r2) {
            this.a.B1().unselectCard(r2);
        }
    }

    public static final class p implements ShelfManagementCardListAdapter.OnItemClickListener {
        public final /* synthetic */ ShelfManagementActivity a;

        public static final class a implements DialogInterface.OnClickListener {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r1, int r2) {
                r1.dismiss();
            }
        }

        public p(ShelfManagementActivity r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementCardListAdapter.OnItemClickListener
        public final void a(ShelfCardInfo r5, ShelfManagementCardListAdapter.OnItemClickListener.ClickPosition r6) {
            Intrinsics.checkNotNullParameter(r5, "shelfCardInfo");
            Intrinsics.checkNotNullParameter(r6, "clickPosition");
            if (r6 != ShelfManagementCardListAdapter.OnItemClickListener.ClickPosition.REVIEW_REJECTED) goto L15;
            AppCompatActivity r7 = this.a;
            x0.d r0 = new x0.d();
            r0.b = r7;
            r0.a = 4;
            r0.c = r7.getString(2131921051);
            r0.d = r5.Y();
            String r8 = this.a.getString(2131921050);
            a r9 = a.a;
            x0.c[] r1 = r0.g;
            x0.c r3 = r1[0];
            if (r3 != null) goto L7;
            r3 = new x0.c();
            r1[0] = r3;
        L7:
            r3.a = r8;
            r3.b = r9;
            x0.c r10 = r1[0];
            if (r10 != null) goto L10;
            r10 = new x0.c();
            r1[0] = r10;
        L10:
            r10.c = true;
            r0.k = true;
            r0.l = true;
            x0 r11 = new x0(r0.b, r0);
            if (DialogLancet.shouldBlockDialogShow(r11) == false) goto L18;
            DialogLancet.handleBlockedDialogShow(r11);
            return;
        L18:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
        L14:
            DialogLancet.beforeDialogShow(r11);
            r11.show();
            DialogLancet.afterDialogShow(r11);
            return;
        L15:
            this.a.B1().openCardLandingPage(r5);
        }
    }

    public final T B1() {
        return (T) this.b.getValue();
    }

    public abstract void C1(Intent r1);

    public abstract PreviewShelfManagementViewModel D1();

    public final ShelfManagementCardListAdapter z1() {
        return (ShelfManagementCardListAdapter) this.c.getValue();
    }

    public final so0.a A1() {
        so0.a r0 = this.e;
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
    }

    public ShelfManagementActivity() {
        this.a = new LinkedHashMap();
        this.b = LazyKt.lazy(new ShelfManagementActivity$viewModel$2(this));
        this.c = LazyKt.lazy(new ShelfManagementActivity$adapter$2(this));
        this.d = LazyKt.lazy(new ShelfManagementActivity$businessToolsAdapter$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initView() {
        B1().getPageCount().observe(this, new h(this));
        ((OpenPlatformTitleBar) _$_findCachedViewById(2131388807)).setLeftIconDrawable(2131252526);
        ((OpenPlatformTitleBar) _$_findCachedViewById(2131388807)).setLeftIconVisibility(true);
        ((OpenPlatformTitleBar) _$_findCachedViewById(2131388807)).setOnLeftIconClickListener(new i(this));
        ((OpenPlatformTitleBar) _$_findCachedViewById(2131388807)).setRightIconDrawable(2131252549);
        ((OpenPlatformTitleBar) _$_findCachedViewById(2131388807)).setRightIconVisibility(true);
        ((OpenPlatformTitleBar) _$_findCachedViewById(2131388807)).setOnRightIconClickListener(new j(this));
        String r3 = "";
        if (B1().getEnterTimes() != 2) goto L17;
        ((OpenPlatformTitleBar) _$_findCachedViewById(2131388807)).b(this, 1, new ko0.f(s1.B(2131920974), 0, 0, 6));
        so0.a r1 = this.e;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L7:
        OpenPlatformContext r2 = r1.a();
        if (r2 == null) goto L17;
        AnchorMiniAppAppLogContextService r4 = (AnchorMiniAppAppLogContextService) r2.getService(AnchorMiniAppAppLogContextService.class);
        if (r4 == null) goto L17;
        ShelfMicroAppInfo r6 = B1().getShelfAppInfo();
        if (r6 == null) goto L15;
        String r7 = r6.appId;
        if (r7 == null) goto L15;
    L16:
        r4.reportPageShelfBubblePush(r7, "auto_bind_guide");
    L15:
        r7 = "";
    L17:
        ((OpenPlatformTitleBar) _$_findCachedViewById(2131388807)).post(new k(this));
        _$_findCachedViewById(2131364978).setAdapter((ShelfManagementBusinessToolsAdapter) this.d.getValue());
        _$_findCachedViewById(2131364978).setLayoutManager(new GridLayoutManager(this, 2));
        B1().getBusinessToolsData().observe(this, new l(this));
        so0.a r0 = this.e;
        if (r0 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L20:
        OpenPlatformContext r5 = r0.a();
        if (r5 == null) goto L31;
        AnchorMiniAppAppLogContextService r8 = (AnchorMiniAppAppLogContextService) r5.getService(AnchorMiniAppAppLogContextService.class);
        if (r8 == null) goto L31;
        ShelfMicroAppInfo r9 = B1().getShelfAppInfo();
        if (r9 == null) goto L30;
        String r10 = r9.appId;
        if (r10 == null) goto L30;
        r3 = r10;
    L30:
        r8.reportMpShow(r3, "shelf_setting_page");
    L31:
        ((LinearLayout) _$_findCachedViewById(2131380754)).setOnClickListener(new m(this));
        HSImageView r11 = _$_findCachedViewById(2131363092);
        ShelfMicroAppInfo r12 = B1().getShelfAppInfo();
        String r13 = null;
        if (r12 == null) goto L38;
        ImageModel r14 = r12.icon;
        if (r14 == null) goto L38;
        List r15 = r14.getUrls();
        if (r15 == null) goto L38;
        String r16 = (String) CollectionsKt.firstOrNull(r15);
    L39:
        ImageLoader.bindImage(r11, r16);
        TextView r17 = (TextView) _$_findCachedViewById(2131363102);
        ShelfMicroAppInfo r18 = B1().getShelfAppInfo();
        if (r18 == null) goto L42;
        r13 = r18.name;
    L42:
        r17.setText(r13);
        ShelfManagementCardListAdapter r19 = z1();
        n r20 = new n(this);
        r19.getClass();
        Intrinsics.checkNotNullParameter(r20, "listener");
        r19.a = r20;
        ShelfManagementCardListAdapter r21 = z1();
        o r22 = new o(this);
        r21.getClass();
        Intrinsics.checkNotNullParameter(r22, "listener");
        r21.b = r22;
        ShelfManagementCardListAdapter r23 = z1();
        p r24 = new p(this);
        r23.getClass();
        Intrinsics.checkNotNullParameter(r24, "listener");
        r23.d = r24;
        _$_findCachedViewById(2131386213).setAdapter(z1());
        _$_findCachedViewById(2131386213).setLayoutManager(new LinearLayoutManager(this, 1, false));
        new ItemTouchHelper(new ShelfItemTouchHelperCallback(z1())).attachToRecyclerView(_$_findCachedViewById(2131386213));
        B1().getShelfCardInfo().observe(this, new a(this));
        B1().isEditing().observe(this, new b(this));
        ((TextView) _$_findCachedViewById(2131371391)).setOnClickListener(new c(this));
        ((CheckBox) _$_findCachedViewById(2131385778)).setOnClickListener(new d(this));
        B1().getSelectedList().observe(this, new e(this));
        ((TextView) _$_findCachedViewById(2131372569)).setOnClickListener(new f(this));
        ((TextView) _$_findCachedViewById(2131364009)).setOnClickListener(new AnonymousClass16(this));
        B1().getFinish().observe(this, new g(this));
        return;
    L38:
        r16 = null;
        goto L39
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

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.viewholder.BaseBusinessToolItemViewHolder.a
    public void E(bq0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        BusinessToolType r3 = r2.b();
        int r4 = com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.b.b[r3.ordinal()];
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
        if (com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.b.a[r0.ordinal()] == 1) goto L6;
        return;
    L6:
        if ((r3 instanceof bq0.c) == false) goto L14;
        int r1 = PrivateMsgSettingDialog.g;
        ShelfMicroAppInfo r2 = B1().getShelfAppInfo();
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
    public final void onCreate(Bundle r7) {
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
        setContentView(2131565125);
        B1().recordEnterTimes();
        C1(getIntent());
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
        if (B1().getEnterTimes() != 1) goto L22;
        int r9 = ShelfManagementIntroduceDialog.e;
        ShelfManagementIntroduceDialog.a.a(this);
    L22:
        so0.a r10 = this.e;
        if (r10 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L25:
        OpenPlatformContext r11 = r10.a();
        if (r11 == null) goto L45;
        AnchorMiniAppAppLogContextService r12 = (AnchorMiniAppAppLogContextService) r11.getService(AnchorMiniAppAppLogContextService.class);
        if (r12 == null) goto L46;
        ShelfMicroAppInfo r1 = B1().getShelfAppInfo();
        String r2 = "";
        if (r1 == null) goto L33;
        String r3 = r1.appId;
        if (r3 == null) goto L33;
    L34:
        Integer r4 = (Integer) B1().getPageCount().getValue();
        if (r4 != null) goto L37;
        r4 = 0;
    L37:
        int r5 = r4.intValue();
        String r6 = getIntent().getStringExtra("click_source");
        if (r6 == null) goto L41;
        r2 = r6;
    L41:
        r12.reportShelfSettingPageShow(r3, r5, r2, 0);
        return;
    L33:
        r3 = "";
        goto L34
    L46:
        return;
    }

    public void onNewIntent(Intent r1) {
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(r1);
        C1(r1);
    }
}
