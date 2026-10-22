package com.bytedance.android.live.openplatform.impl.miniappanchor.sellingpoint;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductIntroductionInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductLabelInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductPriceInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.SellingPointApi;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementCard;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonProductIntroductionLayout;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonProductLabelLayout;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonProductPriceView;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.utils.t2;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0005\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/sellingpoint/ShelfManagementSellingPointSettingDialog;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "", "<init>", "()V", "a", "b", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShelfManagementSellingPointSettingDialog extends AppCompatDialogFragment {
    public static final /* synthetic */ int j = 0;
    public Map<Integer, View> d;
    public so0.a e;
    public ShelfCardInfo f;
    public int g;
    public boolean h;
    public boolean i;

    public static final class a {
    }

    public static final class b implements InputFilter {
        public b() {
        }

        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence r1, int r2, int r3, Spanned r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r1, "source");
            Intrinsics.checkNotNullParameter(r4, "dest");
            if (new Regex("[\\uD83C-\\uDBFF\\uDC00-\\uDFFF]+").containsMatchIn(r1) == false) goto L5;
            return "";
        L5:
            return null;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ShelfManagementSellingPointSettingDialog a;

        public c(ShelfManagementSellingPointSettingDialog r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((EditText) this.a.S90(2131371463)).requestFocus();     // Catch: Throwable -> L4 Exception -> L10
            t2.b(this.a.getContext(), (EditText) this.a.S90(2131371463));     // Catch: Throwable -> L4 Exception -> L10
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ ShelfManagementSellingPointSettingDialog a;

        public d(ShelfManagementSellingPointSettingDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ ShelfManagementSellingPointSettingDialog a;

        public e(ShelfManagementSellingPointSettingDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ShelfManagementSellingPointSettingDialog r3 = this.a;
            r3.i = true;
            r3.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L12;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ ShelfManagementSellingPointSettingDialog a;

        public f(ShelfManagementSellingPointSettingDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ShelfManagementSellingPointSettingDialog r3 = this.a;
            ShelfManagementSellingPointSettingDialog.T90(r3, ((EditText) r3.S90(2131371463)).getText().toString());
        }
    }

    static {
    }

    public final long V90() {
        so0.a r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r1 = r0.a();
        Long r2 = null;
        if (r1 != null) goto L8;
    L12:
        ShelfCardInfo r3 = this.f;
        if (r3 == null) goto L15;
        r2 = Long.valueOf(r3.O());
    L15:
        if (r2 != null) goto L19;
        return 0;
    L19:
        return r2.longValue();
    L8:
        if (r1.isInLive() != true) goto L12;
        ShelfCardInfo r4 = this.f;
        if (r4 == null) goto L15;
        r2 = Long.valueOf(r4.getCardId());
        goto L15
    }

    public ShelfManagementSellingPointSettingDialog() {
        new CompositeDisposable();
        this.d = new LinkedHashMap();
        this.g = -1;
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        so0.a r0 = (so0.a) ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().a.b.get();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.e = r0;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.d.clear();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        ((EditText) S90(2131371463)).post(new c(this));
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void U90(DialogInterface r7) {
        Intrinsics.checkNotNullParameter(r7, "dialog");
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r7);
        if (this.i == false) goto L5;
        xs2.b.a().post(new zp0.a());
    L5:
        long r0 = V90();
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r8 = AnchorMiniAppDataContext.a.a();
        String r2 = null;
        if (r8 == null) goto L10;
        i<HashMap<Long, String>> r9 = r8.getSellingPointEditCache();
        if (r9 == null) goto L10;
        HashMap r10 = (HashMap) r9.getValue();
    L11:
        ShelfCardInfo r3 = this.f;
        if (r3 == null) goto L14;
        r2 = r3.b();
    L14:
        if (r2 != null) goto L24;
        AnchorMiniAppDataContext r4 = AnchorMiniAppDataContext.a.a();
        if (r4 == null) goto L22;
        i<HashMap<Long, String>> r5 = r4.getSellingPointEditCache();
        if (r5 == null) goto L22;
        HashMap r6 = (HashMap) r5.getValue();
        if (r6 == null) goto L22;
        String r11 = (String) r6.put(Long.valueOf(V90()), ((EditText) S90(2131371463)).getText().toString());
    L22:
        if (r10 == null) goto L27;
        String r12 = (String) r10.put(Long.valueOf(r0), ((EditText) S90(2131371463)).getText().toString());
        return;
    L27:
        return;
    L24:
        if (r10 == null) goto L29;
        String r13 = (String) r10.remove(Long.valueOf(r0));
        return;
    L29:
        return;
    L10:
        r10 = null;
        goto L11
    }

    public final void W90(String r27) {
        xs2.b.a().post(new zp0.a());
        ShelfCardInfo r3 = this.f;
        if (r3 == null) goto L5;
        xs2.b.a().post(new zp0.c(ShelfCardInfo.g(r3, null, null, null, null, false, null, 0, 0, null, null, null, 0, r27, null, null, null, null, 0, 0, -268435457, 7), this.g));
    L5:
        t2.a(getContext(), (EditText) S90(2131371463));
        this.i = true;
        dismiss();     // Catch: Exception -> L8
    L12:
        so0.a r0 = this.e;
        if (r0 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L15:
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L34;
        AnchorMiniAppAppLogContextService r2 = (AnchorMiniAppAppLogContextService) r1.getService(AnchorMiniAppAppLogContextService.class);
        if (r2 == null) goto L35;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r4 = AnchorMiniAppDataContext.a.a();
        if (r4 == null) goto L29;
        n<ShelfInfo> r5 = r4.m618getShelfInfo();
        if (r5 == null) goto L29;
        ShelfInfo r6 = (ShelfInfo) r5.getValue();
        if (r6 == null) goto L29;
        ShelfMicroAppInfo r7 = r6.appInfo;
        if (r7 == null) goto L29;
        String r8 = r7.appId;
        if (r8 == null) goto L29;
    L30:
        r2.reportEditSellingPointResult(r8, true, r27.length(), "");
        return;
    L29:
        r8 = "";
        goto L30
    L35:
        return;
    L34:
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r9 = DialogFragmentLancet.sLastShowStack;
        if (r9 == null) goto L12;
        com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L12
    }

    public final void X90(String r7) {
        int r8 = r7.length();
        ((TextView) S90(2131365491)).setText(getString(2131920941, new Object[]{Integer.valueOf(r8), 15}));
        if (r8 <= 0) goto L12;
        if (r8 < 15) goto L8;
        TextView r9 = (TextView) S90(2131365491);
        if (r9 == null) goto L13;
        r9.setTextColor(ContextCompat.getColor(requireContext(), 2131107971));
        return;
    L13:
        return;
    L8:
        TextView r10 = (TextView) S90(2131365491);
        if (r10 == null) goto L15;
        r10.setTextColor(ContextCompat.getColor(requireContext(), 2131107372));
        return;
    L15:
        return;
    }

    public final void onActivityCreated(Bundle r3) {
        super/*androidx.fragment.app.DialogFragment*/.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        r5.setLayout(-1, -2);
        WindowManager.LayoutParams r0 = r5.getAttributes();
        r0.dimAmount = 1.0f;
        Unit r1 = Unit.INSTANCE;
        r5.setAttributes(r0);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r3) {
        setStyle(1, 2131954638);
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
        setCancelable(true);
        Bundle r4 = getArguments();
        if (r4 == null) goto L5;
        ShelfCardInfo r5 = (ShelfCardInfo) r4.getParcelable("card_info");
    L6:
        this.f = r5;
        Bundle r6 = getArguments();
        if (r6 == null) goto L9;
        int r7 = r6.getInt("card_position");
    L10:
        this.g = r7;
        so0.a r8 = this.e;
        if (r8 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L13:
        OpenPlatformContext r9 = r8.a();
        if (r9 == null) goto L30;
        AnchorMiniAppAppLogContextService r10 = (AnchorMiniAppAppLogContextService) r9.getService(AnchorMiniAppAppLogContextService.class);
        if (r10 == null) goto L31;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L27;
        n<ShelfInfo> r1 = r0.m618getShelfInfo();
        if (r1 == null) goto L27;
        ShelfInfo r2 = (ShelfInfo) r1.getValue();
        if (r2 == null) goto L27;
        ShelfMicroAppInfo r11 = r2.appInfo;
        if (r11 == null) goto L27;
        String r12 = r11.appId;
        if (r12 == null) goto L27;
    L28:
        r10.reportEditSellingPointPanelShow(r12);
        return;
    L27:
        r12 = "";
        goto L28
    L31:
        return;
    L30:
        return;
    L9:
        r7 = -1;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public final Dialog onCreateDialog(Bundle r4) {
        Dialog r5 = super.onCreateDialog(r4);
        Window r0 = r5.getWindow();
        if (r0 == null) goto L5;
        r0.setGravity(80);
        r0.setLayout(-1, -2);
        r0.setBackgroundDrawable(new ColorDrawable(0));
        r0.setSoftInputMode(21);
    L5:
        return r5;
    }

    public final void onDismiss(DialogInterface r2) {
        U90(r2);     // Catch: Throwable -> L5
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

    public static final void T90(ShelfManagementSellingPointSettingDialog r8, String r9) {
        r8.getClass();
        if (StringsKt.isBlank(r9) == false) goto L5;
        r8.W90("");
        return;
    L5:
        Lazy r0 = LiveOpenPlatformClient.c;
        SellingPointApi r1 = (SellingPointApi) LiveOpenPlatformClient.a.a().a(SellingPointApi.class);
        so0.a r2 = r8.e;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L8:
        OpenPlatformContext r3 = r2.a();
        long r4 = 0;
        if (r3 == null) goto L11;
        long r5 = r3.getRoomId();
    L12:
        ShelfCardInfo r6 = r8.f;
        if (r6 == null) goto L15;
        r4 = r6.getCardId();
    L15:
        r1.checkSellingPoint(r5, r4, r9).compose(RxUtil.rxSchedulerHelper()).subscribe(new wp0.a(r8, r9), wp0.b.a);
        return;
    L11:
        r5 = 0;
        goto L12
    }

    public final void onViewCreated(View r17, Bundle r18) {
        Intrinsics.checkNotNullParameter(r17, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r17, r18);
        ((ImageView) S90(2131363770)).setOnClickListener(new d(this));
        ((ImageView) S90(2131366984)).setOnClickListener(new e(this));
        ShelfCardInfo r1 = this.f;
        if (r1 == null) goto L5;
        String r2 = r1.b();
    L6:
        String r3 = "";
        if (r2 != null) goto L19;
        long r4 = V90();
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r5 = AnchorMiniAppDataContext.a.a();
        if (r5 == null) goto L14;
        i<HashMap<Long, String>> r6 = r5.getSellingPointEditCache();
        if (r6 == null) goto L14;
        HashMap r7 = (HashMap) r6.getValue();
    L15:
        if (r7 == null) goto L18;
        r2 = (String) r7.get(Long.valueOf(r4));
        if (r2 != null) goto L19;
    L18:
        r2 = "";
    L14:
        r7 = null;
    L19:
        ShelfCardInfo r8 = this.f;
        if (r8 == null) goto L81;
        ShelfManagementCard r9 = (ShelfManagementCard) S90(2131386214);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r8, "shelfCardInfo");
        ImageLoader.bindImage(r9.a(2131365170), r8.h());
        ((TextView) r9.a(2131365225)).setText(r8.i(null));
        boolean r10 = ((uc1) ee0.a.getValue()).s();
        if (r10 == false) goto L27;
        ((TextView) r9.a(2131385888)).setVisibility(0);
        TextView r11 = (TextView) r9.a(2131385888);
        String r12 = r8.b();
        if (r12 == null) goto L26;
        r3 = r12;
    L26:
        r11.setText(r3);
    L28:
        ProductInfo r13 = r8.getProductInfo();
        com.bytedance.android.live.openplatform.api.utils.a r14 = com.bytedance.android.live.openplatform.api.utils.a.a;
        if (r14.h() == false) goto L67;
        if (r13 == null) goto L67;
        if (r14.i() == false) goto L43;
        List<ProductIntroductionInfo> r15 = r13.introductionList;
        if (r15 != null) goto L36;
    L39:
        boolean r16 = true;
    L40:
        if (r16 == true) goto L43;
        CommonProductIntroductionLayout r19 = (CommonProductIntroductionLayout) r9.a(2131383168);
        List<ProductIntroductionInfo> r20 = r13.introductionList;
        Intrinsics.checkNotNull(r20);
        r19.r(r14.k(r20));
        ((CommonProductIntroductionLayout) r9.a(2131383168)).setVisibility(0);
        boolean r21 = true;
    L44:
        if (r10 == false) goto L48;
        if (r21 == false) goto L48;
        ((CommonProductLabelLayout) r9.a(2131383170)).setVisibility(8);
    L61:
        if (r14.e() == true) goto L63;
    L66:
        ((CommonProductPriceView) r9.a(2131383174)).setVisibility(8);
    L68:
        String r22 = r8.b();
        if (r22 != null) goto L71;
    L74:
        boolean r23 = true;
    L75:
        if (r23 == false) goto L81;
        ShelfManagementCard r24 = (ShelfManagementCard) S90(2131386214);
        if (r2.a(r2) == false) goto L79;
        String r25 = r2;
    L80:
        r24.getClass();
        Intrinsics.checkNotNullParameter(r25, "sellingPoint");
        ((TextView) r24.a(2131385888)).setText(r25);
        goto L81
    L79:
        r25 = s1.B(2131920946);
        goto L80
    L71:
        if (r22.length() == 0) goto L74;
        r23 = false;
        goto L75
    L63:
        if (r13.price == null) goto L66;
        CommonProductPriceView r26 = (CommonProductPriceView) r9.a(2131383174);
        ProductPriceInfo r27 = r13.price;
        Intrinsics.checkNotNull(r27);
        r26.b(r27);
        ((CommonProductPriceView) r9.a(2131383174)).setVisibility(0);
    L48:
        if (r14.j() == false) goto L59;
        List<ProductLabelInfo> r28 = r13.labelList;
        if (r28 != null) goto L52;
    L55:
        boolean r29 = true;
    L56:
        if (r29 == true) goto L59;
        CommonProductLabelLayout r30 = (CommonProductLabelLayout) r9.a(2131383170);
        List<ProductLabelInfo> r31 = r13.labelList;
        Intrinsics.checkNotNull(r31);
        r30.r(r14.l(r31));
        ((CommonProductLabelLayout) r9.a(2131383170)).setVisibility(0);
        goto L61
    L52:
        if (r28.isEmpty() == true) goto L55;
        r29 = false;
    L59:
        ((CommonProductLabelLayout) r9.a(2131383170)).setVisibility(8);
        goto L61
    L36:
        if (r15.isEmpty() == true) goto L39;
        r16 = false;
    L43:
        ((CommonProductIntroductionLayout) r9.a(2131383168)).setVisibility(8);
        r21 = false;
    L67:
        ((CommonProductIntroductionLayout) r9.a(2131383168)).setVisibility(8);
        ((CommonProductLabelLayout) r9.a(2131383170)).setVisibility(8);
        ((CommonProductPriceView) r9.a(2131383174)).setVisibility(8);
        goto L68
    L27:
        ((TextView) r9.a(2131385888)).setVisibility(8);
    L81:
        ((EditText) S90(2131371463)).setText(r2);
        ((EditText) S90(2131371463)).setFilters(new InputFilter[]{new InputFilter.LengthFilter(15), new b()});
        ((EditText) S90(2131371463)).setOnEditorActionListener(new wp0.c(this));
        ((EditText) S90(2131371463)).setOnFocusChangeListener(new wp0.d(this));
        ((EditText) S90(2131371463)).addTextChangedListener(new wp0.e(this));
        X90(r2);
        ((TextView) S90(2131385089)).setOnClickListener(new f(this));
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566965, r3, false);
    }
}
