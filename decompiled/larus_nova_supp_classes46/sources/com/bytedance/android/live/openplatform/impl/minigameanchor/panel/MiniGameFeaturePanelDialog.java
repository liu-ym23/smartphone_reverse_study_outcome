package com.bytedance.android.live.openplatform.impl.minigameanchor.panel;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.broadcast.api.model.OpenPlatformMgInfoModel;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformMgAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.minigameanchor.applog.AnchorMiniGameAppLogContextService;
import com.bytedance.android.live.profit.lottery.LotteryState;
import com.bytedance.android.live.profit.lottery.i;
import com.bytedance.android.live.profit.lottery.l;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/panel/MiniGameFeaturePanelDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Landroid/view/View$OnClickListener;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniGameFeaturePanelDialog extends LiveDialogFragment implements View.OnClickListener, Observer<KVData> {
    public Map<Integer, View> d;
    public OpenPlatformContext e;
    public final OpenPlatformMgInfoModel f;
    public LiveMiniGameFeaturePanelViewModel g;
    public vo0.a h;

    public static final class a {
    }

    public static final class b implements LiveBottomSheetDialog.k {
        public final /* synthetic */ MiniGameFeaturePanelDialog a;

        public b(MiniGameFeaturePanelDialog r1) {
            this.a = r1;
        }

        public final void a(boolean r4) {
            if (r4 == false) goto L19;
            OpenPlatformContext r5 = this.a.e;
            if (r5 == null) goto L20;
            AnchorMiniGameAppLogContextService r6 = (AnchorMiniGameAppLogContextService) r5.getService(AnchorMiniGameAppLogContextService.class);
            if (r6 == null) goto L21;
            HashMap<String, String> r0 = new HashMap();
            r0.put("screen_split_rate", "0.3");
            r0.put("click_type", "others");
            LiveMiniGameFeaturePanelViewModel r1 = this.a.g;
            if (r1 == null) goto L12;
            LiveData<Boolean> r2 = r1.getExplainStatus();
            if (r2 == null) goto L12;
            Boolean r3 = (Boolean) r2.getValue();
        L14:
            if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L16;
            r0.put("landingpage_type", "explain");
        L17:
            Unit r7 = Unit.INSTANCE;
            r6.reportLiveRoomMgAppLog("livesdk_anchor_mg_landingpage_click", r0);
            return;
        L16:
            r0.put("landingpage_type", "unexplained");
        L12:
            r3 = null;
            goto L14
        L21:
            return;
        L20:
            return;
        }
    }

    static {
    }

    public MiniGameFeaturePanelDialog() {
        this.d = new LinkedHashMap();
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r0 = AnchorMiniGameDataContext.a.a();
        if (r0 == null) goto L7;
        n<OpenPlatformMgInfoModel> r1 = r0.getOpenPlatformMg();
        if (r1 == null) goto L7;
        OpenPlatformMgInfoModel r2 = (OpenPlatformMgInfoModel) r1.getValue();
    L8:
        this.f = r2;
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    public static void S90(MiniGameFeaturePanelDialog r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final View T90(int r3) {
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

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 == null) goto L13;
        String r5 = r4.getKey();
        if (r5.hashCode() == (-1677062600)) goto L9;
        return;
    L9:
        if (r5.equals("cmd_anchor_broadcast_end") == false) goto L12;
        S90(this);
        return;
    L12:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        Boolean r0 = null;
        if (r13 == null) goto L5;
        Integer r14 = Integer.valueOf(r13.getId());
    L7:
        if (r14 == null) goto L26;
        if (r14.intValue() != 2131366993) goto L26;
        S90(this);
        OpenPlatformContext r15 = this.e;
        if (r15 == null) goto L128;
        AnchorMiniGameAppLogContextService r16 = (AnchorMiniGameAppLogContextService) r15.getService(AnchorMiniGameAppLogContextService.class);
        if (r16 == null) goto L129;
        HashMap<String, String> r8 = new HashMap();
        r8.put("screen_split_rate", "0.3");
        r8.put("click_type", "close");
        LiveMiniGameFeaturePanelViewModel r3 = this.g;
        if (r3 == null) goto L21;
        LiveData<Boolean> r4 = r3.getExplainStatus();
        if (r4 == null) goto L21;
        r0 = (Boolean) r4.getValue();
    L21:
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L23;
        r8.put("landingpage_type", "explain");
    L24:
        Unit r1 = Unit.INSTANCE;
        r16.reportLiveRoomMgAppLog("livesdk_anchor_mg_landingpage_click", r8);
        return;
    L23:
        r8.put("landingpage_type", "unexplained");
        goto L24
    L129:
        return;
    L128:
        return;
    L26:
        if (r14 != null) goto L29;
    L49:
        if (r14 != null) goto L52;
    L76:
        if (r14 != null) goto L79;
        return;
    L79:
        if (r14.intValue() != 2131379204) goto L140;
        LiveMiniGameFeaturePanelViewModel r17 = this.g;
        if (r17 == null) goto L113;
        LiveData<yq0.e> r18 = r17.getLotteryConfig();
        if (r18 == null) goto L113;
        yq0.e r19 = (yq0.e) r18.getValue();
        if (r19 == null) goto L113;
        String r110 = r19.d();
        if (r110 == null) goto L113;
        i r10 = yt0.c.f();
        if (r10 == null) goto L95;
        n r11 = r10.getCurrentLottery();
        if (r11 == null) goto L95;
        com.bytedance.android.live.profit.lottery.g r12 = (com.bytedance.android.live.profit.lottery.g) r11.getValue();
        if (r12 == null) goto L95;
        LotteryState r111 = r12.getState();
    L96:
        if (r111 != null) goto L98;
    L105:
        ILiveService r112 = TTLiveService.getLiveService();
        if (r112 == null) goto L108;
        Boolean r113 = Boolean.valueOf(r112.handleSchema(getContext(), UriProtector.parse(r110)));
    L110:
        if ((!Intrinsics.areEqual(r113, Boolean.TRUE)) == false) goto L112;
        x8.a.d("MiniGameFeaturePanelDialog", "open minigame lottery failed", false);
    L112:
        S90(this);
        goto L113
    L108:
        r113 = null;
        goto L110
    L98:
        if (l.b(r111) == true) goto L105;
        i r114 = yt0.c.f();
        if (r114 == null) goto L112;
        k r115 = r114.getOnToolbarButtonClick();
        if (r115 == null) goto L112;
        r115.post(Unit.INSTANCE);
    L95:
        r111 = null;
    L113:
        OpenPlatformContext r116 = this.e;
        if (r116 == null) goto L141;
        AnchorMiniGameAppLogContextService r117 = (AnchorMiniGameAppLogContextService) r116.getService(AnchorMiniGameAppLogContextService.class);
        if (r117 == null) goto L142;
        HashMap<String, String> r9 = new HashMap();
        r9.put("screen_split_rate", "0.3");
        r9.put("click_type", "lottery");
        LiveMiniGameFeaturePanelViewModel r5 = this.g;
        if (r5 == null) goto L123;
        LiveData<Boolean> r6 = r5.getExplainStatus();
        if (r6 == null) goto L123;
        r0 = (Boolean) r6.getValue();
    L123:
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L125;
        r9.put("landingpage_type", "explain");
    L126:
        Unit r2 = Unit.INSTANCE;
        r117.reportLiveRoomMgAppLog("livesdk_anchor_mg_landingpage_click", r9);
        return;
    L125:
        r9.put("landingpage_type", "unexplained");
        goto L126
    L142:
        return;
    L141:
        return;
    L140:
        return;
    L52:
        if (r14.intValue() != 2131387051) goto L76;
        LiveMiniGameFeaturePanelViewModel r118 = this.g;
        if (r118 == null) goto L59;
        LiveData<Boolean> r119 = r118.getExplainStatus();
        if (r119 == null) goto L59;
        r0 = (Boolean) r119.getValue();
    L59:
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L68;
        LiveMiniGameFeaturePanelViewModel r120 = this.g;
        if (r120 == null) goto L63;
        r120.deleteExplainCard();
    L63:
        OpenPlatformContext r121 = this.e;
        if (r121 == null) goto L134;
        AnchorMiniGameAppLogContextService r122 = (AnchorMiniGameAppLogContextService) r121.getService(AnchorMiniGameAppLogContextService.class);
        if (r122 == null) goto L135;
        HashMap<String, String> r7 = new HashMap();
        r7.put("screen_split_rate", "0.3");
        r7.put("click_type", "live_card");
        r7.put("landingpage_type", "explain");
        Unit r20 = Unit.INSTANCE;
        r122.reportLiveRoomMgAppLog("livesdk_anchor_mg_landingpage_click", r7);
        return;
    L135:
        return;
    L134:
        return;
    L68:
        LiveMiniGameFeaturePanelViewModel r123 = this.g;
        if (r123 == null) goto L71;
        r123.setExplainCard();
    L71:
        OpenPlatformContext r124 = this.e;
        if (r124 == null) goto L137;
        AnchorMiniGameAppLogContextService r125 = (AnchorMiniGameAppLogContextService) r124.getService(AnchorMiniGameAppLogContextService.class);
        if (r125 == null) goto L138;
        HashMap<String, String> r21 = new HashMap();
        r21.put("screen_split_rate", "0.3");
        r21.put("click_type", "live_card");
        r21.put("landingpage_type", "unexplained");
        Unit r22 = Unit.INSTANCE;
        r125.reportLiveRoomMgAppLog("livesdk_anchor_mg_landingpage_click", r21);
        return;
    L138:
        return;
    L137:
        return;
    L29:
        if (r14.intValue() != 2131371865) goto L49;
        x0.b r126 = new x0.b(getContext(), 4);
        x0.d r127 = r126.a;
        r127.k = false;
        r127.l = false;
        r126.m(2131920986);
        r126.l(2131920991);
        r126.i(0, 2131920984, new f(this));
        r126.i(1, 2131920982, new g(this));
        r126.k(0, true);
        r126.n();
        OpenPlatformContext r128 = this.e;
        if (r128 == null) goto L35;
        AnchorMiniGameAppLogContextService r129 = (AnchorMiniGameAppLogContextService) r128.getService(AnchorMiniGameAppLogContextService.class);
        if (r129 == null) goto L35;
        HashMap<String, String> r23 = new HashMap();
        r23.put("screen_split_rate", "0.3");
        Unit r24 = Unit.INSTANCE;
        r129.reportLiveRoomMgAppLog("livesdk_anchor_mg_remove_pop_show", r23);
    L35:
        OpenPlatformContext r130 = this.e;
        if (r130 == null) goto L131;
        AnchorMiniGameAppLogContextService r131 = (AnchorMiniGameAppLogContextService) r130.getService(AnchorMiniGameAppLogContextService.class);
        if (r131 == null) goto L132;
        HashMap<String, String> r25 = new HashMap();
        r25.put("screen_split_rate", "0.3");
        r25.put("click_type", "remove");
        LiveMiniGameFeaturePanelViewModel r26 = this.g;
        if (r26 == null) goto L45;
        LiveData<Boolean> r27 = r26.getExplainStatus();
        if (r27 == null) goto L45;
        r0 = (Boolean) r27.getValue();
    L45:
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L47;
        r25.put("landingpage_type", "explain");
    L48:
        Unit r28 = Unit.INSTANCE;
        r131.reportLiveRoomMgAppLog("livesdk_anchor_mg_landingpage_click", r25);
        return;
    L47:
        r25.put("landingpage_type", "unexplained");
        goto L48
    L132:
        return;
    L131:
        return;
    L5:
        r14 = null;
        goto L7
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954751);
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

    public static final String U90(MiniGameFeaturePanelDialog r9, long r10) {
        r9.getClass();
        long r0 = 1000;
        if (r10 < r0) goto L13;
        long r2 = 10000;
        if (r10 >= r2) goto L9;
        return new StringBuilder(String.valueOf(r10)).insert(1, ",").toString();
    L9:
        if ((r10 % r2) >= r0) goto L11;
        StringBuilder r11 = new StringBuilder();
        r11.append((int) (r10 / r2));
        r11.append('w');
        return r11.toString();
    L11:
        StringBuilder r1 = new StringBuilder();
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;
        r1.append(String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(r10 / 10000)}, 1)));
        r1.append('w');
        return r1.toString();
    L13:
        return String.valueOf(r10);
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        ImageView r6 = (ImageView) T90(2131366993);
        if (r6 == null) goto L5;
        r6.setOnClickListener(this);
    L5:
        TextView r7 = (TextView) T90(2131371865);
        if (r7 == null) goto L8;
        r7.setOnClickListener(this);
    L8:
        Button r8 = (Button) T90(2131387051);
        if (r8 == null) goto L11;
        r8.setOnClickListener(this);
    L11:
        Button r9 = (Button) T90(2131379204);
        if (r9 == null) goto L14;
        r9.setOnClickListener(this);
    L14:
        HSImageView r10 = T90(2131373444);
        Boolean r11 = null;
        if (r10 == null) goto L21;
        OpenPlatformMgInfoModel r0 = this.f;
        if (r0 == null) goto L19;
        String r1 = r0.getAppIcon();
    L20:
        r10.setImageURI(r1);
        goto L21
    L19:
        r1 = null;
    L21:
        TextView r12 = (TextView) T90(2131373445);
        if (r12 == null) goto L28;
        OpenPlatformMgInfoModel r2 = this.f;
        if (r2 == null) goto L26;
        String r3 = r2.getAppName();
    L27:
        r12.setText(r3);
        goto L28
    L26:
        r3 = null;
    L28:
        TextView r13 = (TextView) T90(2131373450);
        if (r13 == null) goto L35;
        OpenPlatformMgInfoModel r14 = this.f;
        if (r14 == null) goto L33;
        String r15 = r14.getGameSummary();
    L34:
        r13.setText(r15);
        goto L35
    L33:
        r15 = null;
    L35:
        OpenPlatformMgAnchorServiceImpl.Companion.getClass();
        po0.a.b r16 = (po0.a.b) OpenPlatformMgAnchorServiceImpl.access$getDiComponent$cp();
        r16.getClass();
        vo0.a r17 = (vo0.a) r16.a.e.get();
        this.h = r17;
        if (r17 == null) goto L38;
        OpenPlatformContext r18 = r17.a();
    L39:
        this.e = r18;
        if (this.g == null) goto L42;
    L50:
        LiveMiniGameFeaturePanelViewModel r19 = this.g;
        if (r19 == null) goto L55;
        LiveData<Boolean> r20 = r19.getEnableExplain();
        if (r20 == null) goto L55;
        r20.observe(this, new com.bytedance.android.live.openplatform.impl.minigameanchor.panel.a(this));
    L55:
        LiveMiniGameFeaturePanelViewModel r21 = this.g;
        if (r21 == null) goto L60;
        LiveData<Boolean> r22 = r21.getExplainStatus();
        if (r22 == null) goto L60;
        r22.observe(this, new com.bytedance.android.live.openplatform.impl.minigameanchor.panel.b(this));
    L60:
        LiveMiniGameFeaturePanelViewModel r23 = this.g;
        if (r23 == null) goto L65;
        LiveData<yq0.e> r24 = r23.getLotteryConfig();
        if (r24 == null) goto L65;
        r24.observe(this, new c(this));
    L65:
        LiveMiniGameFeaturePanelViewModel r25 = this.g;
        if (r25 == null) goto L70;
        LiveData<Boolean> r26 = r25.getExitMountStatus();
        if (r26 == null) goto L70;
        r26.observe(this, new d(this));
    L70:
        LiveMiniGameFeaturePanelViewModel r27 = this.g;
        if (r27 == null) goto L75;
        LiveData<yq0.d> r28 = r27.getRealTimeData();
        if (r28 == null) goto L75;
        r28.observe(this, new e(this));
    L75:
        OpenPlatformContext r29 = this.e;
        if (r29 == null) goto L80;
        DataCenter r30 = r29.getDataCenter();
        if (r30 == null) goto L80;
        r30.observe("cmd_anchor_broadcast_end", this);
    L80:
        OpenPlatformContext r31 = this.e;
        if (r31 == null) goto L85;
        LiveMiniGameFeaturePanelViewModel r32 = this.g;
        if (r32 == null) goto L85;
        r32.initData(r31);
    L85:
        OpenPlatformContext r33 = this.e;
        if (r33 == null) goto L100;
        AnchorMiniGameAppLogContextService r34 = (AnchorMiniGameAppLogContextService) r33.getService(AnchorMiniGameAppLogContextService.class);
        if (r34 == null) goto L101;
        HashMap<String, String> r35 = new HashMap();
        r35.put("screen_split_rate", "0.3");
        LiveMiniGameFeaturePanelViewModel r36 = this.g;
        if (r36 == null) goto L95;
        LiveData<Boolean> r37 = r36.getExplainStatus();
        if (r37 == null) goto L95;
        r11 = (Boolean) r37.getValue();
    L95:
        if (Intrinsics.areEqual(r11, Boolean.TRUE) == false) goto L97;
        r35.put("landingpage_type", "explain");
    L98:
        Unit r38 = Unit.INSTANCE;
        r34.reportLiveRoomMgAppLog("livesdk_anchor_mg_landingpage_show", r35);
        return;
    L97:
        r35.put("landingpage_type", "unexplained");
        goto L98
    L101:
        return;
    L100:
        return;
    L42:
        if ((getActivity() instanceof FragmentActivity) == false) goto L48;
        FragmentActivity r39 = getActivity();
        if (r39 == null) goto L47;
        LiveMiniGameFeaturePanelViewModel r40 = (LiveMiniGameFeaturePanelViewModel) ViewModelProviders.of(r39).get(LiveMiniGameFeaturePanelViewModel.class);
    L49:
        this.g = r40;
        goto L50
    L47:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L48:
        r40 = (LiveMiniGameFeaturePanelViewModel) ViewModelProviders.of(this).get(LiveMiniGameFeaturePanelViewModel.class);
        goto L49
    L38:
        r18 = null;
        goto L39
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131567106, r3, false);
    }
}
