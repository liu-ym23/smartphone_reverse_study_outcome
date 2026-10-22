package com.bytedance.android.live.liveinteract.widget.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.ILinkDistributionSettingCallback;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/widget/widget/LinkDistributeSettingDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkDistributeSettingDialog extends CommonBottomDialog {
    public static final /* synthetic */ int i = 0;
    public final Lazy a;
    public final List<View> b;
    public final CompositeDisposable c;
    public final List<e> d;
    public final int e;
    public final String f;
    public final boolean g;
    public final ILinkDistributionSettingCallback h;

    public static final class a {
        public static String a() {
            ILinkmicAudienceSetting.LinkmicSettingStatus r0 = (ILinkmicAudienceSetting.LinkmicSettingStatus) b6.r.getValue();
            if (r0 == null) goto L9;
            int r1 = h.a[r0.ordinal()];
            if (r1 != 1) goto L8;
            return "mutual";
        L8:
            if (r1 != 2) goto L9;
            return "all";
        L9:
            return "none";
        }

        public static void b() {
            LinkedHashMap r0 = new LinkedHashMap();
            int r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
            if (r1 != 5) goto L5;
        L11:
            String r2 = "radio";
        L12:
            r0.put("function_type", r2);
            if (((Boolean) b6.q.getValue()).booleanValue() == false) goto L15;
            String r3 = "on";
        L16:
            r0.put("switch_status", r3);
            j0.l().sendLog("livesdk_guest_link_distribute_switch", r0, new Object[]{IRoom.class, am2.x.class});
            return;
        L15:
            r3 = "off";
            goto L16
        L5:
            if (r1 != 9) goto L7;
            r2 = "ktv";
            goto L12
        L7:
            if (r1 != 10) goto L11;
            r2 = "watch";
            goto L12
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LinkDistributeSettingDialog a;
        public final /* synthetic */ ILinkmicAudienceSetting.LinkmicSettingStatus b;

        public b(LinkDistributeSettingDialog r1, ILinkmicAudienceSetting.LinkmicSettingStatus r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            com.bytedance.android.live.network.response.a r7 = (com.bytedance.android.live.network.response.a) r6;
            com.bytedance.android.livesdk.sharedpref.e r8 = b6.r;
            ILinkmicAudienceSetting.LinkmicSettingStatus r0 = this.b;
            r8.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r8, r0);
            LinkDistributeSettingDialog r9 = this.a;
            int r1 = LinkDistributeSettingDialog.i;
            r9.getClass();
            LinkedHashMap r2 = new LinkedHashMap();
            int r3 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
            TalkRoomLogUtils.B0(r2, Integer.valueOf(r3), null, 4);
            TalkRoomLogUtils.I0(r2, r3);
            r2.put("selection", a.a());
            r2.put("request_page", r9.f);
            j0.l().sendLog("livesdk_guest_connection_distribution_popup_select", r2, new Object[]{IRoom.class, am2.x.class});
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Intrinsics.checkNotNullParameter(r3, "throwable");
            r3.printStackTrace();
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565583;
    }

    public final void M0() {
        List<e> r0 = this.d;
        j r1 = new j(this);
        Intrinsics.checkNotNullParameter(r0, "itemData");
        Intrinsics.checkNotNullParameter(r1, "listener");
        e.a r3 = new e.a();
        String r4 = s1.B(2131919501);
        Intrinsics.checkNotNullParameter(r4, "title");
        r3.b = r4;
        r3.c = 2131377980;
        Intrinsics.checkNotNullParameter(r1, "listener");
        r3.e = r1;
        r3.d = ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_DELEGATED_TO_EVERYONE.getValue();
        ArrayList r2 = (ArrayList) r0;
        r2.add(new e(r3));
        e.a r5 = new e.a();
        String r6 = s1.B(2131919502);
        Intrinsics.checkNotNullParameter(r6, "title");
        r5.b = r6;
        String r7 = s1.B(2131919503);
        Intrinsics.checkNotNullParameter(r7, "dec");
        r5.a = r7;
        r5.c = 2131377981;
        Intrinsics.checkNotNullParameter(r1, "listener");
        r5.e = r1;
        r5.d = ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OPEN.getValue();
        r2.add(new e(r5));
        e.a r8 = new e.a();
        String r9 = s1.B(2131919504);
        Intrinsics.checkNotNullParameter(r9, "title");
        r8.b = r9;
        String r10 = s1.B(2131919505);
        Intrinsics.checkNotNullParameter(r10, "dec");
        r8.a = r10;
        r8.c = 2131377982;
        r8.d = ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OFF.getValue();
        Intrinsics.checkNotNullParameter(r1, "listener");
        r8.e = r1;
        r2.add(new e(r8));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L18:
        if (this.g == false) goto L31;
        Window r1 = getWindow();
        if (r1 == null) goto L32;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        if (r2 == null) goto L24;
        r2.dimAmount = 0.0f;
    L24:
        r1.clearFlags(2);
        r1.setAttributes(r2);
        return;
    L32:
        return;
    L31:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r3 == null) goto L16;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L18
    }

    public final void N0(ILinkmicAudienceSetting.LinkmicSettingStatus r7) {
        Intrinsics.checkNotNullParameter(r7, "status");
        JSONArray r1 = new JSONArray();
        JSONObject r2 = new JSONObject();
        JSONObject r3 = new JSONObject();
        r3.put("status", r7.getValue());     // Catch: JSONException -> L5
        r2.put("key", ILinkmicAudienceSetting.LinkmicAudienceSettingKey.ENABLE_DELEGATED_TO_FRIENDS.getValue());     // Catch: JSONException -> L5
        r2.put("value", r3);     // Catch: JSONException -> L5
        r1.put(r2);     // Catch: JSONException -> L5
    L7:
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L10;
        IRoom r4 = (IRoom) r0.getValue();
    L11:
        if (r4 == null) goto L14;
        this.c.add(((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).updateAudienceSettings(r4.getId(), r1.toString()).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r7), c.a));
    L14:
        if (TextUtils.equals("privacy_settings", this.f) == false) goto L23;
        LinkedHashMap r5 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r5, null, null, 6);
        TalkRoomLogUtils.J0(r5);
        int r6 = i.a[r7.ordinal()];
        if (r6 != 1) goto L18;
        String r8 = "mutual";
    L22:
        r5.put("selection", r8);
        r5.put("request_page", this.f);
        j0.l().sendLog("livesdk_guest_connection_distribution_popup_select", r5, new Object[0]);
        goto L23
    L18:
        if (r6 == 2) goto L20;
        r8 = "none";
        goto L22
    L20:
        r8 = "all";
    L23:
        ILinkDistributionSettingCallback r9 = this.h;
        if (r9 == null) goto L29;
        r9.onStatusChanged(r7.getValue());
        return;
    L29:
        return;
    L10:
        r4 = null;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r9) {
        super.onCreate(r9);
        int r10 = c1.a;
        c1.b(getWindow(), 0, 14);
        Map r11 = (Map) vm2.d.T1.getValue(null, vm2.d.a[147(0x93, float:2.06E-43)]);
        if (r11 == null) goto L12;
        ((ImageView) findViewById(2131376357)).setVisibility(0);
        String r3 = (String) r11.get("title");
        if (r3 == null) goto L7;
        ((TextView) findViewById(2131390871)).setText(r3);
    L7:
        String r12 = (String) r11.get("rule_url");
        if (r12 == null) goto L12;
        ImageView r0 = (ImageView) findViewById(2131376357);
        if (r0 == null) goto L12;
        r0.setOnClickListener(new l(r12, this));
    L12:
        Iterator r13 = ((ArrayList) this.d).iterator();
    L14:
        if (r13.hasNext() == false) goto L42;
        e r1 = (e) r13.next();
        View r4 = LayoutInflater.from(getContext()).inflate(2131565768, null);
        r4.setId(r1.c);
        ((ViewGroup) this.a.getValue()).addView(r4);
        ((ArrayList) this.b).add(r4);
        r4.setOnClickListener(r1.e);
        TextView r5 = (TextView) r4.findViewById(2131390870);
        TextView r6 = (TextView) r4.findViewById(2131390869);
        if (TextUtils.isEmpty(r1.b) == false) goto L18;
        r5.setVisibility(8);
    L20:
        if (TextUtils.isEmpty(r1.a) == false) goto L23;
        if (r6 == null) goto L28;
        r6.setVisibility(8);
    L28:
        if (this.e != r1.d) goto L34;
        ImageView r7 = (ImageView) r4.findViewById(2131375834);
        if (r7 == null) goto L32;
        r7.setVisibility(0);
    L32:
        if (r7 == null) goto L34;
        r7.setImageResource(2131237694);
    L34:
        StringBuilder r8 = new StringBuilder();
        r8.append(r1.b);
        r8.append(r1.a);
        if (this.e != r1.d) goto L41;
        Resources r2 = getContext().getResources();
        if (r2 == null) goto L41;
        String r14 = r2.getString(2131915929);
        if (r14 == null) goto L41;
        r8.append(r14);
    L41:
        r4.setContentDescription(r8.toString());
        goto L14
    L23:
        if (r6 == null) goto L25;
        r6.setVisibility(0);
    L25:
        if (r6 == null) goto L28;
        r6.setText(r1.a);
        goto L28
    L18:
        r5.setVisibility(0);
        r5.setText(r1.b);
        goto L20
    L42:
        ((LinearLayout) findViewById(2131390497)).setOnClickListener(new k(this));
        if (this.g == false) goto L56;
        Window r15 = getWindow();
        if (r15 == null) goto L57;
        WindowManager.LayoutParams r16 = r15.getAttributes();
        if (r16 == null) goto L49;
        r16.dimAmount = 0.5f;
    L49:
        r15.addFlags(2);
        r15.setAttributes(r16);
        return;
    L57:
        return;
    }

    public LinkDistributeSettingDialog(Context r2, int r3, String r4, boolean r5, ILinkDistributionSettingCallback r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "from");
        super(r2);
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.a = LazyKt.lazy(new LinkDistributeSettingDialog$mItemContainer$2(this));
        this.b = new ArrayList();
        this.c = new CompositeDisposable();
        this.d = new ArrayList();
    }
}
