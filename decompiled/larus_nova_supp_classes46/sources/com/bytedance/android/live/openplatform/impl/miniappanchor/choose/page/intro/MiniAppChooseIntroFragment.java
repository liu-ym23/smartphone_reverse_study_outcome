package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.intro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.broadcastgame.api.model.response.MiniAppEntrancePermissionResponse;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.c;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import lp0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/intro/MiniAppChooseIntroFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppChooseIntroFragment extends BaseFragment {
    public static final /* synthetic */ int i = 0;
    public Map<Integer, View> d;
    public lp0.a e;
    public final MiniAppEntrancePermissionResponse f;
    public String g;
    public String h;

    public static final class a {
    }

    static {
    }

    public final Map<String, String> T90() {
        HashMap r0 = new HashMap();
        r0.put("_param_for_special", "micro_app");
        MiniAppEntrancePermissionResponse r1 = this.f;
        if (r1 != null) goto L5;
    L7:
        String r2 = "not";
    L8:
        r0.put("panel_type", r2);
        r0.put("live_type", this.g);
        r0.put("anchor_id", this.h);
        r0.put("is_partner", "0");
        if (b.d(this.e) == false) goto L11;
        String r3 = "in_live";
    L12:
        r0.put("live_status", r3);
        return r0;
    L11:
        r3 = "before_live";
        goto L12
    L5:
        if (r1.getPermit() != true) goto L7;
        r2 = "satisfied";
        goto L8
    }

    public MiniAppChooseIntroFragment() {
        this.d = new LinkedHashMap();
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L7;
        n<MiniAppEntrancePermissionResponse> r1 = r0.getEntranceInfo();
        if (r1 == null) goto L7;
        MiniAppEntrancePermissionResponse r2 = (MiniAppEntrancePermissionResponse) r1.getValue();
    L8:
        this.f = r2;
        this.g = "";
        this.h = "0";
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
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

    public final void onCreate(Bundle r3) {
        Object r0 = "0";
        super.onCreate(r3);
        c r4 = b.c(this.e);
        if (r4 == null) goto L6;
        String r5 = r4.b;
        if (r5 == null) goto L6;
    L7:
        this.g = r5;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L17
        IUserService r7 = k.f(IUserService.class);     // Catch: Throwable -> L17
        if (r7 == null) goto L14;
        f r8 = r7.user();     // Catch: Throwable -> L17
        if (r8 == null) goto L14;
        String r9 = r8.n();     // Catch: Throwable -> L17
        if (r9 == null) goto L14;
    L15:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r10) == true) goto L23;
        r0 = r10;
    L23:
        this.h = (String) r0;
        return;
    L14:
        r9 = "0";
    L17:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L6:
        r5 = "";
        goto L7
    }

    public final void onViewCreated(View r17, Bundle r18) {
        Intrinsics.checkNotNullParameter(r17, "view");
        super.onViewCreated(r17, r18);
        SimpleDraweeView r1 = S90(2131375153);
        MiniAppEntrancePermissionResponse r2 = this.f;
        if (r2 == null) goto L5;
        String r3 = r2.getIntroImgUrl();
    L6:
        r1.setImageURI(r3);
        MiniAppEntrancePermissionResponse r4 = this.f;
        if (r4 != null) goto L9;
    L11:
        MiniAppEntrancePermissionResponse r5 = this.f;
        if (r5 == null) goto L16;
        List r6 = r5.getIntroInfo();
        if (r6 == null) goto L16;
        int r7 = r6.size();
    L18:
        if (1 > r7) goto L61;
        int r8 = 1;
    L20:
        TextView r9 = new TextView(getContext());
        r9.setText(String.valueOf(r8) + ".   ");
        r9.setId(r8);
        r9.setTextSize(12.0f);
        r9.setTextColor(ColorProtector.parseColor("#161823"));
        r9.setAlpha(0.75f);
        if (r8 != r7) goto L23;
        r9.setPadding(s1.f(12.0f), 0, 0, s1.f(18.0f));
    L24:
        TextView r13 = new TextView(getContext());
        MiniAppEntrancePermissionResponse r14 = this.f;
        if (r14 == null) goto L33;
        List r15 = r14.getIntroInfo();
        if (r15 == null) goto L33;
        MiniAppEntrancePermissionResponse.PermissionThresholdInfo r16 = (MiniAppEntrancePermissionResponse.PermissionThresholdInfo) ListProtector.get(r15, r8 - 1);
        if (r16 == null) goto L33;
        String r19 = r16.getDesc();
        if (r19 == null) goto L33;
    L34:
        r13.setText(r19);
        r13.setTextSize(12.0f);
        r13.setTextColor(ColorProtector.parseColor("#161823"));
        r13.setAlpha(0.75f);
        if (r8 != r7) goto L37;
        r13.setPadding(0, 0, 0, s1.f(18.0f));
    L38:
        TextView r110 = new TextView(getContext());
        MiniAppEntrancePermissionResponse r111 = this.f;
        if (r111 == null) goto L47;
        List r112 = r111.getIntroInfo();
        if (r112 == null) goto L47;
        MiniAppEntrancePermissionResponse.PermissionThresholdInfo r10 = (MiniAppEntrancePermissionResponse.PermissionThresholdInfo) ListProtector.get(r112, r8 - 1);
        if (r10 == null) goto L47;
        String r11 = r10.getStatus();
        if (r11 == null) goto L47;
    L48:
        r110.setText(r11);
        r110.setTextSize(12.0f);
        r110.setGravity(5);
        if ((!Intrinsics.areEqual(r110.getText(), "已满足")) == false) goto L51;
        r110.setTextColor(ColorProtector.parseColor("#161823"));
    L52:
        r110.setAlpha(0.75f);
        if (r8 != r7) goto L55;
        r110.setPadding(0, 0, s1.f(12.0f), s1.f(18.0f));
    L56:
        RelativeLayout.LayoutParams r12 = new RelativeLayout.LayoutParams(-2, -2);
        r12.addRule(9, -1);
        r12.addRule(10, -1);
        r9.setLayoutParams(r12);
        RelativeLayout.LayoutParams r20 = new RelativeLayout.LayoutParams(-1, -2);
        r20.width = s1.f(216.0f);
        r20.addRule(1, r9.getId());
        r13.setLayoutParams(r20);
        RelativeLayout.LayoutParams r21 = new RelativeLayout.LayoutParams(-1, -2);
        r21.width = s1.f(90.0f);
        r21.addRule(11, -1);
        r21.addRule(10, -1);
        r110.setLayoutParams(r21);
        RelativeLayout r22 = new RelativeLayout(getContext());
        r22.addView(r9);
        r22.addView(r13);
        r22.addView(r110);
        LinearLayout r23 = (LinearLayout) S90(2131391969);
        if (r23 == null) goto L59;
        r23.addView(r22, new LinearLayout.LayoutParams(-1, -2));
    L59:
        if (r8 == r7) goto L61;
        r8 = r8 + 1;
        goto L20
    L55:
        r110.setPadding(0, 0, s1.f(12.0f), s1.f(12.0f));
        goto L56
    L51:
        r110.setTextColor(ColorProtector.parseColor("#161823"));
    L47:
        r11 = "";
        goto L48
    L37:
        r13.setPadding(0, 0, 0, s1.f(12.0f));
    L33:
        r19 = "";
        goto L34
    L23:
        r9.setPadding(s1.f(12.0f), 0, 0, s1.f(12.0f));
    L61:
        TextView r24 = (TextView) S90(2131364765);
        if (r24 == null) goto L64;
        r24.setOnClickListener(new gp0.a(this));
    L64:
        u.l().sendLog("livesdk_live_introduce_panel_show", T90(), new Object[0]);
        if (b.d(this.e) == false) goto L67;
        int r25 = 2;
    L68:
        int r26 = no0.a.a;
        no0.a.d(1, r25, 1, "", "introduce");
        mp0.a r27 = b.a(this.e);
        if (r27 == null) goto L73;
        mp0.a.c(r27, "success", null, "intro", 6);
        return;
    L73:
        return;
    L67:
        r25 = 1;
    L16:
        r7 = 0;
        goto L18
    L9:
        if (r4.getPermit() != true) goto L11;
        ((TextView) S90(2131364764)).setVisibility(8);
        ((TextView) S90(2131364765)).setVisibility(0);
        goto L11
    L5:
        r3 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566936, r3, false);
    }
}
