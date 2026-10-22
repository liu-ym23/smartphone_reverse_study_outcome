package com.ss.android.lark.integrator.ccm.im;

import android.content.Intent;
import android.view.View;
import com.bytedance.ee.bear.lark.dependency.y;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.ccm_api.ICCMApi;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.keyboard.biz.plus.PlusKBPlugin;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import d5b.c;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import z5c.p3;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements d5b.a {
    public final Chat a;
    public c b;
    public final String c;

    /* JADX INFO: renamed from: com.ss.android.lark.integrator.ccm.im.a$a, reason: collision with other inner class name */
    public static final class C0115a {
    }

    static {
    }

    public final void b() {
    }

    public final void c() {
    }

    public final int e() {
        return 19;
    }

    public final int getIconId() {
        return 2131235882;
    }

    public final /* synthetic */ void showRedDot() {
    }

    public final String getName() {
        c r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("plusMenuItem");
        r0 = null;
    L6:
        return r0.getActivity().getString(2131886813);
    }

    public final boolean isVisible() {
        boolean r2 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("im.chatgroup.more_collaborativelist");
        ICCMApi r3 = (ICCMApi) ApiUtils.getApi(ICCMApi.class);
        if (r3 == null) goto L28;
        r3.checkAndInit();
    L28:
        boolean r4 = ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1().hasBenefit("base_create_base");     // Catch: Throwable -> L8
        Log.i("CollaborativePlusItem", "unbundle benefit: baseEnable = " + r4);     // Catch: Throwable -> L8
    L10:
        boolean r0 = this.a.isSecret();
        boolean r1 = this.a.isCrossWithKa();
        boolean r5 = this.a.isP2PChat();
        boolean r6 = this.a.isSuper();
        boolean r7 = this.a.isOnCall();
        Chat r8 = this.a;
        if (r8 != null) goto L13;
    L17:
        boolean r9 = false;
    L18:
        if (r2 == false) goto L30;
        if (r4 == false) goto L31;
        if (r0 == true) goto L32;
        if (r1 == true) goto L33;
        if (r5 == true) goto L34;
        if (r6 == true) goto L35;
        if (r7 == true) goto L36;
        if (r9 == true) goto L37;
        return true;
    L37:
        return false;
    L36:
        return false;
    L35:
        return false;
    L34:
        return false;
    L33:
        return false;
    L32:
        return false;
    L31:
        return false;
    L30:
        return false;
    L13:
        if (Chat.Role.MEMBER == r8.getRole()) goto L17;
        if (r8.getHasVCChatPermission() == false) goto L17;
        r9 = true;
    L8:
        th = move-exception;
        Log.e("CollaborativePlusItem", "get BenefitManagerAPI failed, disable CollaborativePlusItem.", th);
        r4 = false;
        goto L10
    }

    public a(Chat r2) {
        Intrinsics.checkNotNullParameter(r2, "chat");
        this.a = r2;
        this.c = r2.getId();
    }

    public final void d(PlusKBPlugin r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        this.b = r2;
    }

    public final void onClick(View r12) {
        Intrinsics.checkNotNullParameter(r12, "view");
        int r13 = CollaborativeDomainUtils.a;
        String r14 = this.c;
        Intrinsics.checkNotNullParameter(r14, "chatId");
        CollaborativeDomainUtils.CollaborativePagePath r0 = (CollaborativeDomainUtils.CollaborativePagePath) SettingManager.getInstance().get(CollaborativeDomainUtils.CollaborativePagePath.class);
        if (r0 == null) goto L5;
        String r1 = r0.getPath();
    L6:
        boolean r2 = false;
        if (r1 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L15;
        r1 = "/automation/config?pageKey=groupNote";
    L15:
        Map r15 = MapsKt.mapOf(TuplesKt.to("chat_id", r14));
        ArrayList r5 = new ArrayList(r15.size());
        Iterator r16 = r15.entrySet().iterator();
    L17:
        if (r16.hasNext() == false) goto L19;
        Map.Entry r6 = (Map.Entry) r16.next();
        r5.add(URLEncoder.encode((String) r6.getKey(), "utf-8") + '=' + URLEncoder.encode((String) r6.getValue(), "utf-8"));
        goto L17
    L19:
        Iterator r17 = r5.iterator();
        if (r17.hasNext() == false) goto L54;
        Object r7 = r17.next();
    L23:
        if (r17.hasNext() == false) goto L25;
        r7 = ((String) r7) + '&' + ((String) r17.next());
        goto L23
    L25:
        String r8 = (String) r7;
        StringBuilder r18 = new StringBuilder("https://");
        String r9 = jcb.b.c().a("group_more_collaborativelist");
        if (r9 != null) goto L28;
    L31:
        boolean r10 = true;
    L32:
        if (r10 == false) goto L34;
        r9 = "feishu.cn";
    L34:
        User r11 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r11 == null) goto L37;
        String r19 = r11.getTenantCode();
    L38:
        if (r19 != null) goto L40;
    L41:
        r2 = true;
    L42:
        if (r2 == false) goto L44;
        String r3 = "www." + r9;
    L45:
        r18.append(r3);
        r18.append(r1);
        r18.append('&');
        r18.append(r8);
        String r110 = r18.toString();
        Log.i("CollaborativePlusItem", "open url: " + (("https://" + jcb.b.c().a("applink") + "/client/web_url/open?lk_animation_mode=1&lk_navigation_mode=1&url=") + URLEncoder.encode(r110, "utf-8")));
        y r111 = (y) LarkContext.spiByDwarf(y.class);
        if (r111 == null) goto L51;
        c r20 = this.b;
        if (r20 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("plusMenuItem");
        r20 = null;
    L50:
        r20.getActivity();
        r111.a();
    L51:
        s5c.a r112 = r.c3.a("group_running_list");
        s5c.a r21 = p3.s.a("im_group_running_list_set_view");
        Statistics.sendEvent("im_chat_input_plus_click", d.b.b(r112, r21).plus(ChatParamUtils.b(this.a, null, 6)).toJson());
        return;
    L44:
        r3 = r19 + '.' + r9;
        goto L45
    L40:
        if (r19.length() != 0) goto L42;
    L37:
        r19 = null;
        goto L38
    L28:
        if (r9.length() == 0) goto L31;
        r10 = false;
        goto L32
    L54:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    L9:
        if (r1.length() == 0) goto L12;
        r4 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final boolean a(Intent r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "data");
        return false;
    }
}
