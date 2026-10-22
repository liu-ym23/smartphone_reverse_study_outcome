package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewStub;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.perf.OpenPlatformPerformanceReportService;
import com.bytedance.android.live.openplatform.impl.base.view.OpenPlatformTitleBar;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.RecyclerViewScrollReportHelper;
import com.bytedance.android.live.openplatform.impl.miniappanchor.explaincard.AnchorExplainCardContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.BaseAnchorShelfDisplayViewModel;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u0005B\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/view/BaseAnchorShelfDisplayDialog;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonShelfDisplayDialog;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/viewmodel/BaseAnchorShelfDisplayViewModel;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/view/AnchorShelfDisplayItemViewHolder$c;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/view/AnchorShelfDisplayItemViewHolder$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseAnchorShelfDisplayDialog extends CommonShelfDisplayDialog<BaseAnchorShelfDisplayViewModel> implements AnchorShelfDisplayItemViewHolder.c, AnchorShelfDisplayItemViewHolder.b, Observer<KVData> {
    public static final /* synthetic */ int n = 0;
    public Map<Integer, View> j;
    public so0.a k;
    public long l;
    public RecyclerViewScrollReportHelper<Object> m;

    public static final class a implements RecyclerViewScrollReportHelper.a<Object> {
        public final /* synthetic */ BaseAnchorShelfDisplayDialog a;

        public a(BaseAnchorShelfDisplayDialog r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.RecyclerViewScrollReportHelper.a
        public final void a(Object r5, int r6) {
            Intrinsics.checkNotNullParameter(r5, "data");
            if ((r5 instanceof com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a) == true) goto L6;
            return;
        L6:
            if (v.a() == false) goto L8;
            int r7 = qo0.a.a;
            qo0.a.c("AnchorShelfDisplayDialog", "do anchor shelf display list show report, title: " + ((com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a) r5).a.i(null));
        L8:
            OpenPlatformContext r8 = this.a.ca0().a();
            if (r8 == null) goto L25;
            AnchorMiniAppAppLogContextService r9 = (AnchorMiniAppAppLogContextService) r8.getService(AnchorMiniAppAppLogContextService.class);
            if (r9 == null) goto L26;
            ShelfMicroAppInfo r0 = (ShelfMicroAppInfo) this.a.W90().getShelfMicroAppInfo().getValue();
            String r1 = "";
            if (r0 == null) goto L16;
            String r2 = r0.appId;
            if (r2 == null) goto L16;
        L17:
            Bundle r3 = this.a.getArguments();
            if (r3 == null) goto L23;
            String r4 = r3.getString("click_source");
            if (r4 == null) goto L23;
            r1 = r4;
        L23:
            r9.reportAnchorShelfDisplayDialogCardShow(r2, r1, ((com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a) r5).a);
            return;
        L16:
            r2 = "";
            goto L17
        L26:
            return;
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.RecyclerViewScrollReportHelper.a
        public final boolean b(Object r4, Object r5) {
            Intrinsics.checkNotNullParameter(r4, "newVisibleData");
            Intrinsics.checkNotNullParameter(r5, "oldVisibleData");
            if ((r4 instanceof com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a) == true) goto L5;
        L10:
            return true;
        L5:
            if ((r5 instanceof com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a) == true) goto L7;
        L9:
            return false;
        L7:
            if (((com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a) r4).getCardId() != ((com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a) r5).getCardId()) goto L9;
            goto L9
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ BaseAnchorShelfDisplayDialog a;

        public b(BaseAnchorShelfDisplayDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            List<? extends Object> r4 = (List) r3;
            BaseAnchorShelfDisplayDialog r0 = this.a;
            int r1 = BaseAnchorShelfDisplayDialog.n;
            r0.V90().a = r4;
            this.a.V90().notifyDataSetChanged();
            RecyclerViewScrollReportHelper<Object> r2 = this.a.m;
            if (r2 == null) goto L6;
            r2.d(r4);
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ BaseAnchorShelfDisplayDialog a;

        public c(BaseAnchorShelfDisplayDialog r1) {
            this.a = r1;
        }

        public final void a() {
            OpenPlatformContext r0 = this.a.ca0().a();
            if (r0 != null) goto L5;
        L7:
            BaseAnchorShelfDisplayDialog r1 = this.a;
            so0.a r2 = r1.k;
            if (r2 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
        L10:
            OpenPlatformContext r3 = r2.a();
            RecyclerView.ViewHolder r4 = null;
            if (r3 == null) goto L13;
            AnchorExplainCardContextService r5 = (AnchorExplainCardContextService) r3.getService(AnchorExplainCardContextService.class);
        L14:
            if (r5 != null) goto L16;
            return;
        L16:
            if (r5.a == true) goto L42;
            int r6 = xq0.a.a;
            com.bytedance.android.livesdk.sharedpref.e r7 = com.bytedance.android.livesdk.sharedpref.b.E3;
            if (((Boolean) r7.getValue()).booleanValue() == false) goto L43;
            com.bytedance.android.livesdk.sharedpref.f.d(r7, Boolean.FALSE);
            qo0.a.c("CommonShelfDisplayDialog", "show anchor shelf display dialog explain guide");
            RecyclerView.ViewHolder r8 = r1.T90(2131386216).findViewHolderForLayoutPosition(0);
            if ((r8 instanceof AnchorShelfDisplayItemViewHolder) == false) goto L23;
            r4 = r8;
        L23:
            AnchorShelfDisplayItemViewHolder r9 = (AnchorShelfDisplayItemViewHolder) r4;
            FragmentActivity r10 = r1.getActivity();
            if (r10 == null) goto L44;
            if (r9 == null) goto L27;
            ko0.f r11 = new ko0.f(r10.getString(2131921085), 3000, 0, 4);
            Intrinsics.checkNotNullParameter(r10, "activity");
            Intrinsics.checkNotNullParameter(r11, "info");
            c90.a.a r12 = new c90.a.a(r10);
            r12.a(r11.a);
            r12.e = r11.b;
            new c90.a(r12).i(r9.f, 3, true);
        L27:
            so0.a r13 = r1.k;
            if (r13 != null) goto L30;
            Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
        L30:
            OpenPlatformContext r14 = r13.a();
            if (r14 == null) goto L45;
            AnchorMiniAppAppLogContextService r15 = (AnchorMiniAppAppLogContextService) r14.getService(AnchorMiniAppAppLogContextService.class);
            if (r15 == null) goto L46;
            ShelfMicroAppInfo r16 = (ShelfMicroAppInfo) r1.W90().getShelfMicroAppInfo().getValue();
            if (r16 == null) goto L38;
            String r17 = r16.appId;
            if (r17 == null) goto L38;
        L39:
            r15.reportPageShelfBubblePush(r17, "click_explanation_guide");
            return;
        L38:
            r17 = "";
            goto L39
        L46:
            return;
        L45:
            return;
        L44:
            return;
        L43:
            return;
        L42:
            return;
        L13:
            r5 = null;
            goto L14
        L5:
            if (((OpenPlatformPerformanceReportService) r0.getService(OpenPlatformPerformanceReportService.class)) == null) goto L7;
            OpenPlatformPerformanceReportService.j(true);
            goto L7
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

    public static final class d implements DialogInterface.OnClickListener {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final void S90() {
        this.j.clear();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final int U90() {
        return UtilityKotlinExtentionsKt.i(((uc1) ee0.a.getValue()).r());
    }

    public final so0.a ca0() {
        so0.a r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        return r0;
    }

    public final void ea0() {
        if (this.l == (-1)) goto L25;
        so0.a r0 = this.k;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L7:
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L23;
        AnchorMiniAppAppLogContextService r2 = (AnchorMiniAppAppLogContextService) r1.getService(AnchorMiniAppAppLogContextService.class);
        if (r2 == null) goto L23;
        ShelfMicroAppInfo r3 = (ShelfMicroAppInfo) W90().getShelfMicroAppInfo().getValue();
        String r4 = "";
        if (r3 == null) goto L15;
        String r5 = r3.appId;
        if (r5 == null) goto L15;
    L16:
        Bundle r6 = getArguments();
        if (r6 == null) goto L22;
        String r7 = r6.getString("click_source");
        if (r7 == null) goto L22;
        r4 = r7;
    L22:
        r2.reportAnchorShelfDisplayDialogShowDuration(r5, r4, SystemClock.uptimeMillis() - this.l);
    L15:
        r5 = "";
    L23:
        this.l = -1;
        return;
    }

    public BaseAnchorShelfDisplayDialog() {
        this.j = new LinkedHashMap();
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        so0.a r0 = (so0.a) ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().a.b.get();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.k = r0;
    }

    public void da0() {
        V90().z2(com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade.d.class, new com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade.b());
        V90().z2(com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a.class, new com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.b(this, this));
        this.m = new RecyclerViewScrollReportHelper(T90(2131386216), 1, 2, new a(this));
        W90().getDisplayItemInfoList().observe(this, new b(this));
        T90(2131386216).post(new c(this));
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final void initView() {
        super.initView();
        boolean r2 = true;
        if (((uc1) ee0.a.getValue()).u() != 1) goto L8;
        View r0 = this.f;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L7:
        r0.setBackgroundResource(2131249196);
    L12:
        OpenPlatformTitleBar r1 = (OpenPlatformTitleBar) T90(2131388807);
        r1.setRightTvText(s1.B(2131920973));
        r1.setRightTvVisibility(true);
        r1.setOnRightTvClickListener(new h(this));
        d71.c r3 = jc1.k.n(IMsgWindowService.class).cardRecorder();
        so0.a r4 = this.k;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L15:
        OpenPlatformContext r5 = r4.a();
        Object r6 = null;
        if (r5 == null) goto L18;
        DataCenter r7 = r5.getDataCenter();
    L19:
        boolean r8 = r3.a(r7, 33, MsgWindowPosition.TOP_RIGHT);
        String r9 = "";
        if (r8 == false) goto L46;
        int r10 = xq0.a.a;
        com.bytedance.android.livesdk.sharedpref.e r11 = com.bytedance.android.livesdk.sharedpref.b.J3;
        if (((Boolean) r11.getValue()).booleanValue() == false) goto L46;
        OpenPlatformTitleBar r12 = (OpenPlatformTitleBar) T90(2131388807);
        so0.a r13 = this.k;
        if (r13 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L26:
        OpenPlatformContext r14 = r13.a();
        if (r14 == null) goto L29;
        Context r15 = r14.getContext();
    L31:
        if ((r15 instanceof Activity) == true) goto L33;
        r15 = null;
    L33:
        r12.b((Activity) r15, 2, new ko0.f(getString(2131921089), 3000, 0, 4));
        com.bytedance.android.livesdk.sharedpref.f.d(r11, Boolean.FALSE);
        so0.a r16 = this.k;
        if (r16 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L36:
        OpenPlatformContext r17 = r16.a();
        if (r17 == null) goto L46;
        AnchorMiniAppAppLogContextService r18 = (AnchorMiniAppAppLogContextService) r17.getService(AnchorMiniAppAppLogContextService.class);
        if (r18 == null) goto L46;
        ShelfMicroAppInfo r19 = (ShelfMicroAppInfo) W90().getShelfMicroAppInfo().getValue();
        if (r19 == null) goto L44;
        String r20 = r19.appId;
        if (r20 == null) goto L44;
    L45:
        r18.reportPageShelfBubblePush(r20, "key_info_card_guide");
    L44:
        r20 = "";
        goto L45
    L29:
        r15 = null;
    L46:
        W90().getShelfMicroAppInfo().observe(this, new j(this));
        W90().getCouponEntranceInfo().observe(this, new l(this));
        da0();
        so0.a r21 = this.k;
        if (r21 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L49:
        OpenPlatformContext r22 = r21.a();
        if (r22 == null) goto L85;
        AnchorMiniAppAppLogContextService r23 = (AnchorMiniAppAppLogContextService) r22.getService(AnchorMiniAppAppLogContextService.class);
        if (r23 == null) goto L86;
        ShelfMicroAppInfo r24 = (ShelfMicroAppInfo) W90().getShelfMicroAppInfo().getValue();
        if (r24 == null) goto L57;
        String r25 = r24.appId;
        if (r25 == null) goto L57;
    L58:
        Bundle r26 = getArguments();
        if (r26 == null) goto L64;
        String r27 = r26.getString("click_source");
        if (r27 == null) goto L64;
        r9 = r27;
    L64:
        List r28 = (List) W90().getShelfCardInfoList().getValue();
        if (r28 == null) goto L67;
        int r29 = r28.size();
    L68:
        List r30 = (List) W90().getShelfCardInfoList().getValue();
        if (r30 == null) goto L77;
        Iterator r31 = r30.iterator();
    L72:
        if (r31.hasNext() == false) goto L76;
        Object r32 = r31.next();
        if (((ShelfCardInfo) r32).v0() == false) goto L72;
        r6 = r32;
    L76:
        r6 = (ShelfCardInfo) r6;
    L77:
        if (r6 != null) goto L80;
        r2 = false;
    L80:
        r23.reportAnchorShelfDisplayDialogShow(r25, r9, r29, r2);
        return;
    L67:
        r29 = 0;
    L57:
        r25 = "";
        goto L58
    L86:
        return;
    L85:
        return;
    L18:
        r7 = null;
        goto L19
    L8:
        View r33 = this.f;
        if (r33 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L11:
        r33.setBackgroundResource(2131250108);
        goto L12
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (Intrinsics.areEqual(com.bytedance.android.live.core.utils.a.d(), getContext()) == false) goto L6;
        this.l = SystemClock.uptimeMillis();
        return;
    }

    public final void onStop() {
        super/*androidx.fragment.app.DialogFragment*/.onStop();
        ea0();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final View T90(int r3) {
        if (this.j != null) goto L5;
        this.j = new LinkedHashMap();
    L5:
        View r0 = this.j.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.j.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final View Y90(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        ViewStub r3 = (ViewStub) r2.findViewById(2131389242);
        r3.setLayoutResource(2131566969);
        return r3.inflate();
    }

    public final void ba0(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        super.onDismiss(r3);
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.b.D3;
        if (((Boolean) r4.getValue()).booleanValue() == false) goto L25;
        com.bytedance.android.livesdk.sharedpref.f.d(r4, Boolean.FALSE);
        so0.a r5 = this.k;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L7:
        OpenPlatformContext r6 = r5.a();
        if (r6 == null) goto L23;
        AnchorMiniAppAppLogContextService r7 = (AnchorMiniAppAppLogContextService) r6.getService(AnchorMiniAppAppLogContextService.class);
        if (r7 == null) goto L23;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L21;
        n<ShelfInfo> r1 = r0.m618getShelfInfo();
        if (r1 == null) goto L21;
        ShelfInfo r2 = (ShelfInfo) r1.getValue();
        if (r2 == null) goto L21;
        ShelfMicroAppInfo r8 = r2.appInfo;
        if (r8 == null) goto L21;
        String r9 = r8.appId;
        if (r9 == null) goto L21;
    L22:
        r7.reportPageShelfBubblePush(r9, "in_live_guide");
    L21:
        r9 = "";
    L23:
        W90().showToolbarTips();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.AnchorShelfDisplayItemViewHolder.b
    public final void gw(com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a r6) {
        Intrinsics.checkNotNullParameter(r6, "cardInfo");
        Context r0 = getContext();
        x0.d r1 = new x0.d();
        r1.b = r0;
        r1.a = 4;
        r1.c = getString(2131921051);
        r1.d = r6.a.W();
        String r7 = getString(2131921050);
        d r2 = d.a;
        x0.c[] r3 = r1.g;
        x0.c r4 = r3[0];
        if (r4 != null) goto L5;
        r4 = new x0.c();
        r3[0] = r4;
    L5:
        r4.a = r7;
        r4.b = r2;
        x0.c r8 = r3[0];
        if (r8 != null) goto L8;
        r8 = new x0.c();
        r3[0] = r8;
    L8:
        r8.c = true;
        r1.k = true;
        r1.l = true;
        x0 r9 = new x0(r1.b, r1);
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(r9);
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L12:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 == null) goto L5;
        String r5 = r4.getKey();
    L6:
        if (r5 != null) goto L9;
        return;
    L9:
        if (r5.hashCode() == (-1973549549)) goto L12;
        return;
    L12:
        if (r5.equals("cmd_live_shelf_display_dialog_dismiss") == false) goto L22;
        dismissAllowingStateLoss();     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L23;
        com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L23:
        return;
    L22:
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final void onDismiss(DialogInterface r2) {
        ba0(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.AnchorShelfDisplayItemViewHolder.b
    public final void tW(com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a r5) {
        Intrinsics.checkNotNullParameter(r5, "cardInfo");
        SchemaInfo.a r0 = new SchemaInfo.a(r5.a.a0());
        String r6 = r5.a.i0();
        if (r6 != null) goto L5;
    L10:
        SchemaInfo r7 = r0.c();
        if (r7 == null) goto L14;
        String r8 = r7.h();
        if (r8 == null) goto L14;
    L15:
        BaseAnchorShelfDisplayViewModel.openMiniAppLandingPage$default(W90(), r8, false, 2, null);
        return;
    L14:
        r8 = "";
        goto L15
    L5:
        if ((!StringsKt.isBlank(r6)) == true) goto L8;
        r6 = null;
    L8:
        if (r6 == null) goto L10;
        r0.g(r6);
        goto L10
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.AnchorShelfDisplayItemViewHolder.c
    public void l50(int r3, long r4) {
        if (r3 != 1) goto L5;
        so0.a r5 = this.k;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L19:
        OpenPlatformContext r6 = r5.a();
        if (r6 == null) goto L24;
        AnchorMiniAppAppLogContextService r7 = (AnchorMiniAppAppLogContextService) r6.getService(AnchorMiniAppAppLogContextService.class);
        if (r7 == null) goto L24;
        r7.reportAnchorStartExplain(false);
    L24:
        W90().startExplain(r4);
        return;
    L5:
        if (r3 != 2) goto L27;
        so0.a r8 = this.k;
        if (r8 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L10:
        OpenPlatformContext r9 = r8.a();
        if (r9 == null) goto L15;
        AnchorMiniAppAppLogContextService r10 = (AnchorMiniAppAppLogContextService) r9.getService(AnchorMiniAppAppLogContextService.class);
        if (r10 == null) goto L15;
        r10.reportAnchorCancelExplain();
    L15:
        W90().cancelExplain(r4);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        so0.a r5 = this.k;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r6 = r5.a();
        if (r6 == null) goto L10;
        DataCenter r7 = r6.getDataCenter();
        if (r7 == null) goto L10;
        r7.observe("cmd_live_shelf_display_dialog_dismiss", this);
    L10:
        so0.a r8 = this.k;
        if (r8 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L13:
        OpenPlatformContext r9 = r8.a();
        int r0 = 1;
        if (r9 != null) goto L16;
    L18:
        int r10 = no0.a.a;
        no0.a.d(2, r0, 4, "", "");
        return;
    L16:
        if (r9.isInLive() != true) goto L18;
        r0 = 2;
        goto L18
    }
}
