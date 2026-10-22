package com.larus.bmhome.chat.component.showcase;

import android.content.Context;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.databinding.LarusCaseTitleLayoutBinding;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.showcase.Case;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g implements View.OnClickListener {
    public final /* synthetic */ ShowCaseTitleBar a;
    public final /* synthetic */ ChatCaseMessageComponent b;

    public /* synthetic */ g(ShowCaseTitleBar r1, ChatCaseMessageComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r113) {
        ShowCaseTitleBar r0 = this.a;
        ChatCaseMessageComponent r2 = this.b;
        int r3 = ChatCaseMessageComponent.z;
        int r4 = a.a;
        LarusCaseTitleLayoutBinding r1 = r0.getBinding();
        if (r1 == null) goto L109;
        View r5 = r1.a;
        if (r5 == null) goto L110;
        Case r6 = r2.mz(false);
        y r7 = (y) r2.v.getValue();
        String r8 = null;
        if (r7 == null) goto L14;
        BotModel r9 = r7.j0();
        if (r9 == null) goto L14;
        BotIconImage r10 = r9.getIconImage();
        if (r10 == null) goto L14;
        String r11 = r10.getOriginUrl();
    L15:
        ShareScene r12 = ShareScene.CASE;
        Intrinsics.checkNotNullParameter(r5, "shareContainer");
        Intrinsics.checkNotNullParameter(r12, "shareScene");
        if (r6 == null) goto L18;
        String r13 = r6.getShareLink();
    L20:
        if (o0.d(r13) == false) goto L87;
        if (r6 == null) goto L23;
        String r14 = r6.getTitle();
    L24:
        boolean r15 = true;
        if (r14 != null) goto L27;
    L30:
        boolean r16 = true;
    L31:
        if (r16 == false) goto L33;
        r14 = AppHost.a.getAppStringName();
    L33:
        String r17 = r14;
        Context r18 = r5.getContext();
        if (r18 == null) goto L37;
        String r19 = r18.getString(2131906766);
        if (r19 == null) goto L37;
    L38:
        String r110 = r19;
        if (z2.a.getShareConfig().p() == false) goto L72;
        ShareServiceDelegate r35 = ShareServiceDelegate.b;
        FragmentActivity r20 = r5.getContext();
        if ((r20 instanceof FragmentActivity) == false) goto L43;
        FragmentActivity r21 = r20;
    L44:
        if (r21 != null) goto L56;
        Context r22 = r5.getContext();
        if ((r22 instanceof ContextThemeWrapper) == false) goto L48;
        ContextThemeWrapper r23 = (ContextThemeWrapper) r22;
    L49:
        if (r23 == null) goto L51;
        Context r24 = r23.getBaseContext();
    L53:
        if ((r24 instanceof FragmentActivity) == false) goto L55;
        r21 = (FragmentActivity) r24;
        goto L56
    L55:
        FragmentActivity r36 = null;
    L57:
        if (r6 == null) goto L59;
        String r111 = r6.getShareLink();
    L60:
        Context r25 = r5.getContext();
        if (r25 == null) goto L63;
        String r112 = r25.getString(2131911195);
    L64:
        com.larus.bmhome.share.panel.b r26 = new com.larus.bmhome.share.panel.b(null, null, r111, r11, null, null, null, r17, r110, r112, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67107955);
        if (r6 == null) goto L67;
        String r64 = r6.getCaseId();
    L68:
        if (r6 == null) goto L70;
        String r65 = r6.getRequestId();
    L71:
        IShareService.a.g(r35, r36, r12, r26, new com.larus.bmhome.share.panel.h(null, null, null, "user_case_detail", null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r64, r65, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -805306385, -1, 1023), null, null, false, 240);
    L91:
        String r27 = r2.Y2();
        Case r28 = r2.mz(false);
        if (r28 == null) goto L94;
        r8 = r28.getRequestId();
    L94:
        String r29 = r2.h3();
        JSONObject r30 = new JSONObject();
        Intrinsics.checkNotNullParameter(r30, "params");
        r30.put("current_page", "user_case_detail");     // Catch: JSONException -> L103
        if (r29 == null) goto L98;
        r30.put("recommend_from", r29);     // Catch: JSONException -> L103
    L98:
        if (r8 == null) goto L100;
        r30.put("user_case_reco_request_id", r8);     // Catch: JSONException -> L103
    L100:
        if (r27 == null) goto L105;
        r30.put("user_case_item_id", r27);     // Catch: JSONException -> L103
    L105:
        TrackParams r31 = new TrackParams().merge(r30);
        by7.a r32 = new by7.a("click_share_user_case");
        r32.a.merge(r31);
        r32.b();
        return;
    L103:
        e = move-exception;
        FLogger.a.e("CaseTraceHelper", "error in CaseTraceHelper mobShareCaseClick " + e.getLocalizedMessage());
        goto L105
    L70:
        r65 = null;
        goto L71
    L67:
        r64 = null;
        goto L68
    L63:
        r112 = null;
        goto L64
    L59:
        r111 = null;
        goto L60
    L51:
        r24 = null;
        goto L53
    L48:
        r23 = null;
    L56:
        r36 = r21;
        goto L57
    L43:
        r21 = null;
        goto L44
    L72:
        Intent r33 = new Intent();
        r33.setAction("android.intent.action.SEND");
        if (r6 == null) goto L75;
        String r34 = r6.getShareLink();
    L76:
        r33.putExtra("android.intent.extra.TEXT", r34);
        if (r17 != null) goto L79;
    L82:
        if (r15 == true) goto L84;
        r33.putExtra("android.intent.extra.TITLE", r17);
    L84:
        r33.setType("text/plain");
        Intent r37 = Intent.createChooser(r33, null);
        Context r38 = r5.getContext();
        if (r38 == null) goto L91;
        r38.startActivity(r37);
        goto L91
    L79:
        if (r17.length() == 0) goto L82;
        r15 = false;
        goto L82
    L75:
        r34 = null;
    L37:
        r19 = "";
        goto L38
    L27:
        if (r14.length() == 0) goto L30;
        r16 = false;
        goto L31
    L23:
        r14 = null;
        goto L24
    L87:
        s r39 = s.a;
        Context r40 = r5.getContext();
        if (r40 == null) goto L91;
        r39.getClass();
        s.b(r40, 2131909342, false);
        goto L91
    L18:
        r13 = null;
    L14:
        r11 = null;
        goto L15
    L110:
        return;
    }
}
