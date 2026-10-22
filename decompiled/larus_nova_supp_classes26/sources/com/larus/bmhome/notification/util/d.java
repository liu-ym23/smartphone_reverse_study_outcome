package com.larus.bmhome.notification.util;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import by7.h;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.bmhome.chat.resp.Button;
import com.larus.bmhome.chat.resp.CommonNoticeData;
import com.larus.bmhome.chat.resp.Notice;
import com.larus.bmhome.chat.resp.NoticeType;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.notification.NotifyTabFragment;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService$a;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.platform.api.b3;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.c2;
import com.larus.platform.service.z1;
import com.larus.platform.service.z2;
import com.larus.search.api.IBrowserService;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(final NotifyTabFragment r26, final Uri r27, final Notice r28) {
        String r3 = r27.getPath();
        String r5 = null;
        if (r3 == null) goto L147;
        boolean r9 = true;
        String r15 = "";
        switch(r3.hashCode()) {
            case -1522611280: goto L144;
            case -820439300: goto L105;
            case -743035355: goto L102;
            case -1718630: goto L88;
            case 40804888: goto L84;
            case 46457863: goto L80;
            case 318402703: goto L76;
            case 1454970128: goto L56;
            case 1485328767: goto L52;
            case 1532131562: goto L38;
            case 1687555364: goto L25;
            case 1725881911: goto L8;
            default: goto L147;
        };
    L8:
        if (r3.equals("/dialog") == false) goto L147;
        String r0 = UriProtector.getQueryParameter(r27, "title");
        String r2 = UriProtector.getQueryParameter(r27, "body");
        Context r4 = r26.getContext();
        if (r4 == null) goto L157;
        CommonDialog.a r6 = new CommonDialog.a();
        if (r0 != null) goto L15;
        r0 = "";
    L15:
        Intrinsics.checkNotNullParameter(r0, "title");
        r6.a = r0;
        String r16 = r15;
        if (r2 == null) goto L19;
        r16 = r2;
    L19:
        Intrinsics.checkNotNullParameter(r16, "message");
        r6.i = r16;
        String r1 = r4.getString(2131900186);
        Intrinsics.checkNotNullParameter(r1, "confirmText");
        r6.l = r1;
        CommonDialog r7 = r6.b(ContextCompat.getColor(r4, 2131103203));
        FragmentManager r8 = r26.getChildFragmentManager();
        LandscapeRestrictionOperation r10 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r7, null, r10);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r7, r10) == true) goto L179;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L152
    L23:
        r7.show(r8, null);
        return;
    L179:
        return;
    L157:
        return;
    L25:
        if (r3.equals("/subscription_detail") == false) goto L147;
        c2 r11 = c2.a;
        if (r11.a() == false) goto L33;
        Context r12 = r26.getContext();
        if (r12 == null) goto L159;
        i r13 = SmartRouter.buildRoute(r12, r27.toString());
        r13.d = 2130772401;
        r13.e = 2130772399;
        r13.d();
        return;
    L159:
        return;
    L33:
        if (z2.a.enableSubscription() == false) goto L161;
        FragmentActivity r14 = r26.getActivity();
        if (r14 == null) goto L162;
        r11.b(r14, "notification");
        return;
    L162:
        return;
    L161:
        return;
    L38:
        if (r3.equals("/webview") == false) goto L147;
        String r17 = UriProtector.getQueryParameter(r27, ShareType.URL);
        String r18 = r15;
        if (r17 == null) goto L45;
        r18 = r17;
    L45:
        if (o0.d(r18) == false) goto L164;
        View r19 = r26.getView();
        if (r19 == null) goto L165;
        IBrowserService r20 = (IBrowserService) ServiceManager.get().getService(IBrowserService.class);
        if (r20 == null) goto L166;
        r20.i(r19, BundleKt.bundleOf(new Pair[]{TuplesKt.to("link_url", r18)}), null);
        return;
    L166:
        return;
    L165:
        return;
    L164:
        return;
    L52:
        if (r3.equals("/commerce_credit_info") == false) goto L147;
        i r21 = SmartRouter.buildRoute(r26.getContext(), ((Uri) l0.a(r27, new b(r27, r26))).toString());
        r21.c.putExtra("ignore_side_bar", "1");
        r21.d = 2130772401;
        r21.e = 2130772399;
        r21.d();
        return;
    L56:
        if (r3.equals("/share") == false) goto L147;
        String r22 = UriProtector.getQueryParameter(r27, "share_url");
        if (r22 != null) goto L61;
        String r110 = "";
    L62:
        String r23 = UriProtector.getQueryParameter(r27, "title");
        if (r23 != null) goto L65;
        String r111 = "";
    L66:
        String r24 = UriProtector.getQueryParameter(r27, "sub_title");
        if (r24 != null) goto L69;
        String r25 = "";
    L71:
        if ((!StringsKt.isBlank(r110)) == false) goto L169;
        Context r112 = r26.getContext();
        if (r112 == null) goto L170;
        IShareService$a.c(ShareServiceDelegate.b, r112, r110, r111, r25, ShareScene.NOTICE_LIST, null, null, null, 480);
        return;
    L170:
        return;
    L169:
        return;
    L69:
        r25 = r24;
        goto L71
    L65:
        r111 = r23;
        goto L66
    L61:
        r110 = r22;
        goto L62
    L76:
        if (r3.equals("/profile_edit") == false) goto L147;
        i r29 = SmartRouter.buildRoute(r26.getContext(), "//flow/profile_edit");
        r29.c.putExtras(BundleKt.bundleOf(new Pair[]{TuplesKt.to("enter_from", "notify")}));
        r29.d = 2130772401;
        r29.e = 2130772399;
        r29.d();
        return;
    L80:
        if (r3.equals("/chat") == false) goto L147;
        i r30 = SmartRouter.buildRoute(r26.getContext(), ((Uri) l0.a(r27, new c(r27, r26, r28))).toString());
        r30.c.putExtra("ignore_side_bar", "1");
        r30.d = 2130772401;
        r30.e = 2130772399;
        r30.d();
        return;
    L84:
        if (r3.equals("/chat_setting") == false) goto L147;
        i r31 = SmartRouter.buildRoute(r26.getContext(), r27.toString());
        r31.d = 2130772401;
        r31.e = 2130772399;
        r31.d();
        return;
    L88:
        if (r3.equals("/profile") == false) goto L147;
        String r32 = UriProtector.getQueryParameter(r27, "user_id");
        String r113 = r15;
        if (r32 == null) goto L93;
        r113 = r32;
    L93:
        z1 r33 = z1.a;
        if (r28 == null) goto L96;
        String r34 = r28.getNoticeTypeStr();
    L97:
        if (r28 == null) goto L99;
        String r35 = r28.getNoticeTypeStr();
    L100:
        b3.a.b(r26, r113, null, null, r34, r35, false, UriProtector.getQueryParameter(r27, "landing_tab"), 76);
        return;
    L99:
        r35 = null;
        goto L100
    L96:
        r34 = null;
        goto L97
    L102:
        if (r3.equals("/alice/user/ban_appeal") == false) goto L147;
    L108:
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == false) goto L142;
        JSONObject r36 = new JSONObject();
        if (r28 != null) goto L112;
    L114:
        boolean r37 = false;
    L115:
        if (r37 == false) goto L117;
        r36.put("user_id", AccountService.a.getSecUserId());
    L141:
        FLogger.a.i("NotifyTabSchemaUtils", "submitBannedAppeal uri=" + r27 + " body=" + r36);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r26), null, null, new NotifyTabSchemaUtils$submitBannedAppeal$1(r27, r36, r26, null), 3, null);
        return;
    L117:
        if (r28 != null) goto L119;
    L121:
        r9 = false;
    L122:
        if (r9 == false) goto L141;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L135
        CommonNoticeData r39 = r28.getCommonNoticeData();     // Catch: Throwable -> L135
        if (r39 == null) goto L129;
        Button r40 = r39.getRightButton();     // Catch: Throwable -> L135
        if (r40 == null) goto L129;
        String r41 = r40.getContent();     // Catch: Throwable -> L135
        if (r41 == null) goto L129;
    L130:
        Object r42 = new JSONObject(r41).opt("conv_id");     // Catch: Throwable -> L135
        if (r42 != null) goto L133;
        r42 = "";
    L133:
        Object r43 = Result.constructor-impl(r42);     // Catch: Throwable -> L135
    L137:
        Object r114 = r15;
        if (Result.exceptionOrNull-impl(r43) != null) goto L140;
        r114 = r43;
    L140:
        r36.put(MusicAppletPage.KEY_CONVERSATION_ID, r114.toString());
    L129:
        r41 = "";
    L135:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        r43 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L137
    L119:
        if (r28.getNoticeType() != NoticeType.ReportConv.getType()) goto L121;
    L112:
        if (r28.getNoticeType() != NoticeType.ReportUser.getType()) goto L114;
        r37 = true;
        goto L115
    L142:
        s r45 = s.a;
        Context r46 = r26.getContext();
        r45.getClass();
        s.b(r46, 2131906741, false);
        return;
    L105:
        if (r3.equals("/alice/safety/conversation/appeal") == true) goto L108;
    L144:
        if (r3.equals("/bot_update") == false) goto L147;
        FLogger.a.i("NotifyTabSchemaUtils", "handleBotUpdate, uri: " + r27);
        i r47 = SmartRouter.buildRoute(r26.getContext(), r27.toString());
        r47.d = 2130772400;
        r47.e = 2130772399;
        r47.d();
        return;
    L147:
        FLogger.a.i("NotifyTabSchemaUtils", "unknown path = " + r3);
        i r48 = SmartRouter.buildRoute(r26.getContext(), r27.toString());
        r48.d = 2130772401;
        r48.e = 2130772399;
        Bundle r49 = BundleKt.bundleOf();
        if (r28 == null) goto L150;
        r5 = r28.getNoticeTypeStr();
    L150:
        r49.putString("from_notice_type", r5);
        h.k(r49, r26);
        r48.c.putExtras(r49);
        r48.d();
    }
}
