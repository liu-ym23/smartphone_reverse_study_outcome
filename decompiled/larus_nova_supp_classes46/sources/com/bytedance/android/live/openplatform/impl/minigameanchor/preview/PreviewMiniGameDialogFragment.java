package com.bytedance.android.live.openplatform.impl.minigameanchor.preview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.broadcast.api.model.OpenPlatformMgInfoModel;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformMgAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.minigameanchor.applog.AnchorMiniGameAppLogContextService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdk.widget.x0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import cr0.c;
import cr0.d;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/preview/PreviewMiniGameDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewMiniGameDialogFragment extends LiveDialogFragment implements View.OnClickListener {
    public Map<Integer, View> d;
    public OpenPlatformContext e;
    public OpenPlatformMgInfoModel f;
    public vo0.a g;

    public static final class a {
    }

    public static final class b implements LiveBottomSheetDialog.k {
        public final /* synthetic */ PreviewMiniGameDialogFragment a;

        public b(PreviewMiniGameDialogFragment r1) {
            this.a = r1;
        }

        public final void a(boolean r4) {
            if (r4 == false) goto L9;
            OpenPlatformContext r5 = this.a.e;
            if (r5 == null) goto L10;
            AnchorMiniGameAppLogContextService r6 = (AnchorMiniGameAppLogContextService) r5.getService(AnchorMiniGameAppLogContextService.class);
            if (r6 == null) goto L11;
            HashMap<String, String> r0 = new HashMap();
            r0.put("screen_split_rate", "0.3");
            r0.put("click_type", "others");
            Unit r1 = Unit.INSTANCE;
            r6.reportPreviewMgAppLog("livesdk_takepage_mg_landingpage_click", r0);
            return;
        L11:
            return;
        L10:
            return;
        }
    }

    static {
    }

    public PreviewMiniGameDialogFragment() {
        this.d = new LinkedHashMap();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
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

    public final void onActivityCreated(Bundle r3) {
        Dialog r0 = getDialog();
        super.onActivityCreated(r3);
        if (r0 == null) goto L8;
        Window r4 = r0.getWindow();
        if (r4 == null) goto L9;
        r4.setGravity(80);
        r4.setLayout(-1, -2);
        r4.setBackgroundDrawable(new ColorDrawable(0));
        r4.getAttributes().windowAnimations = 2131954623;
        return;
    L9:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        if (r9 == null) goto L4;
        Integer r10 = Integer.valueOf(r9.getId());
    L6:
        if (r10 != null) goto L9;
    L21:
        if (r10 != null) goto L24;
        return;
    L24:
        if (r10.intValue() != 2131371865) goto L41;
        x0.b r11 = new x0.b(getContext(), 4);
        x0.d r4 = r11.a;
        r4.k = false;
        r4.l = false;
        r11.m(2131920986);
        r11.l(2131920983);
        r11.i(0, 2131920984, new c(this));
        r11.i(1, 2131920982, new d(this));
        r11.k(0, true);
        r11.n();
        OpenPlatformContext r12 = this.e;
        if (r12 == null) goto L30;
        AnchorMiniGameAppLogContextService r13 = (AnchorMiniGameAppLogContextService) r12.getService(AnchorMiniGameAppLogContextService.class);
        if (r13 == null) goto L30;
        HashMap<String, String> r5 = new HashMap();
        r5.put("screen_split_rate", "0.3");
        Unit r6 = Unit.INSTANCE;
        r13.reportPreviewMgAppLog("livesdk_takepage_mg_remove_pop_show", r5);
    L30:
        OpenPlatformContext r14 = this.e;
        if (r14 == null) goto L42;
        AnchorMiniGameAppLogContextService r15 = (AnchorMiniGameAppLogContextService) r14.getService(AnchorMiniGameAppLogContextService.class);
        if (r15 == null) goto L43;
        HashMap<String, String> r7 = new HashMap();
        r7.put("screen_split_rate", "0.3");
        r7.put("click_type", "remove");
        Unit r0 = Unit.INSTANCE;
        r15.reportPreviewMgAppLog("livesdk_takepage_mg_landingpage_click", r7);
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L9:
        if (r10.intValue() != 2131366993) goto L21;
        dismissAllowingStateLoss();     // Catch: Exception -> L12
    L16:
        OpenPlatformContext r16 = this.e;
        if (r16 == null) goto L38;
        AnchorMiniGameAppLogContextService r17 = (AnchorMiniGameAppLogContextService) r16.getService(AnchorMiniGameAppLogContextService.class);
        if (r17 == null) goto L39;
        HashMap<String, String> r8 = new HashMap();
        r8.put("screen_split_rate", "0.3");
        r8.put("click_type", "close");
        Unit r1 = Unit.INSTANCE;
        r17.reportPreviewMgAppLog("livesdk_takepage_mg_landingpage_click", r8);
        return;
    L39:
        return;
    L38:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r18 = DialogFragmentLancet.sLastShowStack;
        if (r18 == null) goto L16;
        com.bytedance.crash.d.d(r18, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L16
    L4:
        r10 = null;
        goto L6
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Context r0 = getContext();
        if (r0 == null) goto L13;
        LiveBottomSheetDialog r4 = new LiveBottomSheetDialog(r0, getTheme());
        Window r1 = r4.getWindow();
        if (r1 == null) goto L7;
        r1.setGravity(80);
    L7:
        Window r2 = r4.getWindow();
        if (r2 == null) goto L10;
        r2.setDimAmount(0.0f);
    L10:
        r4.setCanceledOnTouchOutside(true);
        r4.setNeedHookBottomSheetInterceptEvent(true);
        r4.setLiveBottomSheetOutsideListener(new b(this));
        return r4;
    L13:
        return super.onCreateDialog(r3);
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        ImageView r7 = (ImageView) S90(2131366993);
        if (r7 == null) goto L5;
        r7.setOnClickListener(this);
    L5:
        TextView r8 = (TextView) S90(2131371865);
        if (r8 == null) goto L8;
        r8.setOnClickListener(this);
    L8:
        OpenPlatformMgInfoModel r9 = this.f;
        OpenPlatformContext r10 = null;
        if (r9 == null) goto L11;
        String r11 = r9.getTaskSource();
    L13:
        if (Intrinsics.areEqual(r11, "star") == false) goto L17;
        Context r12 = getContext();
        if (r12 == null) goto L21;
        int r0 = 2131921002;
    L20:
        String r13 = r12.getString(r0);
    L22:
        TextView r1 = (TextView) S90(2131388278);
        if (r1 == null) goto L29;
        Context r2 = getContext();
        if (r2 == null) goto L27;
        String r14 = r2.getString(2131921000, new Object[]{r13});
    L28:
        r1.setText(r14);
        goto L29
    L27:
        r14 = null;
    L29:
        HSImageView r15 = S90(2131373444);
        if (r15 == null) goto L36;
        OpenPlatformMgInfoModel r3 = this.f;
        if (r3 == null) goto L34;
        String r4 = r3.getAppIcon();
    L35:
        r15.setImageURI(r4);
        goto L36
    L34:
        r4 = null;
    L36:
        TextView r16 = (TextView) S90(2131373445);
        if (r16 == null) goto L43;
        OpenPlatformMgInfoModel r17 = this.f;
        if (r17 == null) goto L41;
        String r18 = r17.getAppName();
    L42:
        r16.setText(r18);
        goto L43
    L41:
        r18 = null;
    L43:
        TextView r19 = (TextView) S90(2131373450);
        if (r19 == null) goto L50;
        OpenPlatformMgInfoModel r20 = this.f;
        if (r20 == null) goto L48;
        String r21 = r20.getGameSummary();
    L49:
        r19.setText(r21);
        goto L50
    L48:
        r21 = null;
    L50:
        OpenPlatformMgAnchorServiceImpl.Companion.getClass();
        po0.a.b r22 = (po0.a.b) OpenPlatformMgAnchorServiceImpl.access$getDiComponent$cp();
        r22.getClass();
        vo0.a r23 = (vo0.a) r22.a.e.get();
        this.g = r23;
        if (r23 == null) goto L53;
        r10 = r23.a();
    L53:
        this.e = r10;
        OpenPlatformContext r24 = this.e;
        if (r24 == null) goto L59;
        AnchorMiniGameAppLogContextService r25 = (AnchorMiniGameAppLogContextService) r24.getService(AnchorMiniGameAppLogContextService.class);
        if (r25 == null) goto L60;
        HashMap<String, String> r26 = new HashMap();
        r26.put("screen_split_rate", "0.3");
        Unit r27 = Unit.INSTANCE;
        r25.reportPreviewMgAppLog("livesdk_takepage_mg_landingpage_show", r26);
        return;
    L60:
        return;
    L59:
        return;
    L21:
        r13 = null;
        goto L22
    L17:
        r12 = getContext();
        if (r12 == null) goto L21;
        r0 = 2131921001;
        goto L20
    L11:
        r11 = null;
        goto L13
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131567167, r3, false);
    }
}
