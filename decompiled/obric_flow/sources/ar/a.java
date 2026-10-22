package ar;

import android.support.v4.media.c;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import b3.h;
import c.f;
import com.bytedance.ai.applet.components.page.RenderFragment;
import com.bytedance.ai.bridge.method.phoneNum.GetPhoneNumberDialog;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ai.bridge.utils.ConvertUtils;
import com.bytedance.ai.model.n;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.model.p;
import com.bytedance.ai.monitor.timeline.OpenFrom;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.gson.JsonObject;
import com.obric.clockwidgets.ClockWidgetConfigActivity;
import com.obric.common.oui.R$id;
import com.obric.flow.cardlistpage.ui.popup.WidgetLayer;
import com.obric.flow.cardlistpage.ui.settings.CardFeedSettingsActivity;
import com.obric.oui.banner.BannerAdapter;
import com.obric.oui.chip.v2.OChip;
import com.obric.oui.dropdown.ODropdownTrigger;
import com.obric.oui.forms.OLineInputView;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.zte.miboard.cards.common.views.CardFooter;
import com.zte.miboard.cards.express.login.LoginNumberActivity;
import h3.b;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import m1.i;
import nr.e;
import v0.d;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f714b;

    public /* synthetic */ a(Object r5, int r10) {
        this.f713a = r10;
        this.f714b = r5;
    }

    /* JADX WARN: Type inference failed for: r0v41, types: [com.bytedance.ai.model.widgets.a, w0.l] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r33) {
        boolean r5 = true;
        Object r10 = this.f714b;
        switch(this.f713a) {
            case 0: goto L192;
            case 1: goto L190;
            case 2: goto L188;
            case 3: goto L186;
            case 4: goto L182;
            case 5: goto L180;
            case 6: goto L178;
            case 7: goto L176;
            case 8: goto L52;
            case 9: goto L50;
            case 10: goto L48;
            case 11: goto L46;
            case 12: goto L44;
            case 13: goto L42;
            case 14: goto L40;
            case 15: goto L31;
            case 16: goto L23;
            case 17: goto L21;
            case 18: goto L19;
            case 19: goto L17;
            case 20: goto L15;
            case 21: goto L13;
            case 22: goto L8;
            default: goto L4;
        };
    L4:
        ?? r11 = ((d) r10).f22506k;
        if (r11 == 0) goto L199;
        r11.n();
        return;
    L199:
        return;
    L8:
        e r12 = (e) r10;
        Intrinsics.checkNotNullParameter(r12, "this$0");
        if (r12.e == null) goto L200;
        r12.g();
        return;
    L200:
        return;
    L13:
        ((b) ((k3.b) r10).d).invoke();
        return;
    L15:
        ((LoginNumberActivity) r10).onClick(r33);
        return;
    L17:
        ((CardFooter) r10).a(r33);
        return;
    L19:
        int r13 = OSearchBar.f14271y;
        OSearchBar r14 = (OSearchBar) r10;
        Intrinsics.checkNotNullParameter(r14, "this$0");
        r14.f14273i.setText("");
        return;
    L21:
        int r15 = OLineInputView.V;
        OLineInputView r16 = (OLineInputView) r10;
        Intrinsics.checkNotNullParameter(r16, "this$0");
        r16.F.getClass();
        r16.setText("");
        r16.F.getClass();
        return;
    L23:
        KProperty[] r17 = ODropdownTrigger.f13185p;
        ODropdownTrigger r18 = (ODropdownTrigger) r10;
        Intrinsics.checkNotNullParameter(r18, "this$0");
        if (r18.getDropdownActivity() != null) goto L27;
        Intrinsics.checkNotNullParameter("ODropdownTrigger", "tag");
        Intrinsics.checkNotNullParameter("no activity for popup showing", "msg");
        Log.e("ODropdownTrigger", "no activity for popup showing", null);
        return;
    L27:
        if (r18.getDropdownActivity() == null) goto L202;
        r18.setActive(true);
        return;
    L202:
        return;
    L31:
        BannerAdapter r19 = (BannerAdapter) r10;
        Intrinsics.checkNotNullParameter(r19, "this$0");
        Object r20 = r33.getTag(R$id.banner_pos_key);
        if (r20 == null) goto L39;
        int r21 = ((Integer) r20).intValue();
        c r22 = r19.d;
        if (r22 == null) goto L203;
        r22.h((com.obric.oui.banner.d) r19.f.get(r21), r21);
        return;
    L203:
        return;
    L39:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L40:
        com.obric.flow.cardlistpage.ui.settings.e r23 = (com.obric.flow.cardlistpage.ui.settings.e) r10;
        Intrinsics.checkNotNullParameter(r23, "$item");
        r23.d.invoke();
        return;
    L42:
        com.obric.flow.cardlistpage.ui.settings.d r24 = (com.obric.flow.cardlistpage.ui.settings.d) r10;
        Intrinsics.checkNotNullParameter(r24, "$item");
        r24.f11826b.invoke();
        return;
    L44:
        int r25 = CardFeedSettingsActivity.f11819t;
        CardFeedSettingsActivity r26 = (CardFeedSettingsActivity) r10;
        Intrinsics.checkNotNullParameter(r26, "this$0");
        r26.finish();
        return;
    L46:
        int r27 = WidgetLayer.f11798l;
        WidgetLayer r28 = (WidgetLayer) r10;
        Intrinsics.checkNotNullParameter(r28, "this$0");
        r28.b(true);
        return;
    L48:
        int r29 = ClockWidgetConfigActivity.e;
        ClockWidgetConfigActivity r30 = (ClockWidgetConfigActivity) r10;
        Intrinsics.checkNotNullParameter(r30, "this$0");
        r30.finish();
        return;
    L50:
        MaterialDatePicker.b((MaterialDatePicker) r10, r33);
        return;
    L52:
        AppletWidgetContainer r31 = (AppletWidgetContainer) r10;
        if (r31.B == null) goto L172;
        Log.d("AppletWidgetContainer", "open default page");
        LinkedHashMap r32 = new LinkedHashMap();
        r32.put("launchFrom", "doubao_widget");
        LinkedHashMap r34 = new LinkedHashMap();
        Widget r35 = r31.f2996y;
        if (r35 == null) goto L59;
        String r36 = r35.f2259b;
        if (r36 == null) goto L59;
        r34.put("appletId", r36);
    L59:
        String r37 = r31.B;
        if (r37 == null) goto L62;
        r34.put("pageId", r37);
    L62:
        r34.put("pageType", OpenPageMethod.APP_FULL);
        r34.put("pageSettings", r32);
        Lazy r38 = p.f2292a;
        Intrinsics.checkNotNullParameter(r34, "data");
        Object r39 = r34.get("appletId");
        if ((r39 instanceof String) == false) goto L65;
        String r40 = (String) r39;
    L66:
        Object r110 = r34.get("pageId");
        if ((r110 instanceof String) == false) goto L69;
        String r111 = (String) r110;
    L70:
        Object r112 = r34.get("pageData");
        if ((r112 instanceof String) == false) goto L73;
        String r113 = (String) r112;
    L74:
        if (r113 != null) goto L82;
        Object r114 = r34.get("originData");
        if ((r114 instanceof Map) == false) goto L78;
        Map r115 = (Map) r114;
    L79:
        if (r115 == null) goto L81;
        r113 = (String) r115.get("pageData");
        goto L82
    L81:
        r113 = null;
        goto L82
    L78:
        r115 = null;
    L82:
        Object r41 = r34.get("pageType");
        if ((r41 instanceof String) == false) goto L85;
        String r42 = (String) r41;
    L87:
        if (r42 != null) goto L89;
        r42 = OpenPageMethod.APP_POPUP;
    L89:
        Object r116 = r34.get("pageSettings");
        if ((r116 instanceof Map) == false) goto L92;
        Map r117 = (Map) r116;
    L93:
        if (r117 != null) goto L95;
        r117 = new LinkedHashMap();
    L95:
        Object r118 = r34.get("conversationId");
        if ((r118 instanceof String) == false) goto L98;
        String r119 = (String) r118;
    L100:
        if (r119 != null) goto L102;
        String r310 = "SYSTEM_CVS_ID";
    L103:
        Object r120 = r34.get("context");
        if ((r120 instanceof Map) == false) goto L106;
        Map<String, String> r121 = (Map) r120;
    L107:
        if (r121 != null) goto L109;
        r121 = new LinkedHashMap();
    L109:
        String r122 = r121.get("botId");
        if (r122 != null) goto L117;
        Object r43 = r34.get("botId");
        if ((r43 instanceof String) == false) goto L114;
        String r44 = (String) r43;
    L115:
        if (r44 != null) goto L118;
        r44 = "SYSTEM_CVS_ID";
    L118:
        if (r40 != null) goto L120;
        return;
    L120:
        if (r40.length() == 0) goto L208;
        if (r111 != null) goto L124;
        return;
    L124:
        if (r111.length() == 0) goto L209;
        b3.p r45 = h.f841a;
        Intrinsics.checkNotNullParameter("api", "prefix");
        StringBuilder r46 = androidx.constraintlayout.motion.widget.a.D(r40, "appletId", r111, "pageId", "api_");
        r46.append(r40);
        r46.append('_');
        r46.append(r111);
        r46.append('_');
        r46.append(UUID.randomUUID());
        String r47 = r46.toString();
        if (Intrinsics.areEqual(r42, OpenPageMethod.APP_FULL) == true) goto L133;
        if (Intrinsics.areEqual(r42, OpenPageMethod.APP_POPUP) == true) goto L133;
        r5 = false;
    L133:
        if (r5 == false) goto L135;
        OpenFrom[] r48 = OpenFrom.f2394a;
        h.b(r47, r111, r42, "native");
        LinkedHashMap r49 = new LinkedHashMap();
        r49.put("trace_id", r47);
        r49.put("eventName", "applet_page_timeline_full");
    L136:
        int r123 = r42.hashCode();
        double r124 = 0.5d;
        if (r123 == 3154575) goto L162;
        if (r123 == 106852524) goto L157;
        if (r123 == 2010122246) goto L144;
    L164:
        PageType r50 = PageType.FULL_PAGE;
    L160:
        double r210 = 0.5d;
        boolean r211 = false;
        PageType r125 = r50;
    L166:
        if (r113 != null) goto L168;
        r113 = "";
    L168:
        PageInfo r51 = new PageInfo(r111, r113, ConvertUtils.INSTANCE.mapToReadableMap(r121), null, r125, r44, null, new JavaOnlyMap(r117), null, r210, r211, null, r49, r40, null, null, 51520, null);
        if (r5 == false) goto L171;
        h.h(r47, "applet_page_timeline_full");
    L171:
        p.e(r40, r310, r44, null, r49, new n(0, r47, r5, r51), 24);
        return;
    L144:
        if (r42.equals(OpenPageMethod.APP_FLOATING) == false) goto L164;
        String r52 = (String) r117.get(OpenPageMethod.KEY_POS);
        if (r52 == null) goto L151;
        Double r53 = StringsKt.toDoubleOrNull(r52);
        if (r53 == null) goto L151;
        r124 = r53.doubleValue();
    L151:
        String r54 = (String) r117.get(OpenPageMethod.KEY_ALIGN);
        if (r54 == null) goto L154;
        boolean r55 = Intrinsics.areEqual(r54, OpenPageMethod.ALIGN_LEFT);
    L155:
        r211 = r55;
        r210 = r124;
        r125 = PageType.FLOATING_VIEW;
        goto L166
    L154:
        r55 = false;
        goto L155
    L157:
        if (r42.equals(OpenPageMethod.APP_POPUP) == false) goto L164;
        r50 = PageType.POPUP_PAGE;
        goto L160
    L162:
        if (r42.equals(OpenPageMethod.APP_FULL) == false) goto L164;
        r50 = PageType.FULL_PAGE;
        goto L160
    L135:
        r49 = null;
        goto L136
    L209:
        return;
    L208:
        return;
    L114:
        r44 = null;
        goto L115
    L117:
        r44 = r122;
        goto L118
    L106:
        r121 = null;
        goto L107
    L102:
        r310 = r119;
        goto L103
    L98:
        r119 = null;
        goto L100
    L92:
        r117 = null;
        goto L93
    L85:
        r42 = null;
        goto L87
    L73:
        r113 = null;
        goto L74
    L69:
        r111 = null;
        goto L70
    L65:
        r40 = null;
        goto L66
    L172:
        i r56 = r31.f3025l;
        if (r56 == null) goto L207;
        JsonObject r57 = new JsonObject();
        Unit r58 = Unit.INSTANCE;
        r56.e("widgetTitleClicked", r57);
        return;
    L207:
        return;
    L176:
        int r59 = GetPhoneNumberDialog.g;
        ((com.bytedance.ai.bridge.method.phoneNum.c) r10).invoke();
        return;
    L178:
        int r60 = GetPhoneNumberDialog.g;
        ((com.bytedance.ai.bridge.method.phoneNum.b) r10).invoke();
        return;
    L180:
        ((com.bytedance.ai.applet.login.c) r10).a();
        return;
    L182:
        FragmentActivity r61 = ((RenderFragment) r10).getActivity();
        if (r61 == null) goto L210;
        r61.finish();
        return;
    L210:
        return;
    L186:
        int r62 = c.n.s;
        ((c.n) r10).finish();
        return;
    L188:
        ((f) r10).onClick(r33);
        return;
    L190:
        ((c.e) r10).onClick(r33);
        return;
    L192:
        int r63 = OChip.f12331z;
        OChip r64 = (OChip) r10;
        Intrinsics.checkNotNullParameter(r64, "this$0");
        if (r64.isEnabled() == false) goto L211;
        View.OnClickListener r65 = r64.f12346w;
        if (r65 == null) goto L212;
        r65.onClick(r64.f12336l);
        return;
    L212:
        return;
    }
}
