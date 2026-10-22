package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.net.Uri;
import android.text.Spannable;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.i2;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.api.entity.SpannableType;
import com.bytedance.android.livesdk.interactivity.textmessage.utils.PSInteractionMsgClickUtil;
import com.bytedance.android.livesdk.message.model.h7;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i extends com.bytedance.android.livesdk.interactivity.api.entity.f<h7> implements o {
    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Spannable f() {
        String r0 = this.b.getContent();
        SpannableType r1 = SpannableType.NORMAL;
        int r2 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        return i0.b(r0, i0.a(2131107646));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final tb2.d w() {
        tb2.d r0 = new tb2.d();
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(this.b.getContent()));
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return this.b.getUser();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final boolean E(g52.c r10) {
        Lazy r0 = PSInteractionMsgClickUtil.a;
        boolean r1 = this.e;
        h7 r2 = this.b;
        boolean r3 = false;
        if (r1 == true) goto L75;
        if (r2 == null) goto L75;
        if (((Boolean) PSInteractionMsgClickUtil.a.getValue()).booleanValue() == false) goto L75;
        if (PSInteractionMsgClickUtil.c(r10) == false) goto L75;
        if (PSInteractionMsgClickUtil.b(r2) == false) goto L75;
        if (((fc2.h) PSInteractionMsgClickUtil.d.getValue()).a() == false) goto L75;
        Uri.Builder r4 = null;
        if ((r2 instanceof u3) == true) goto L19;
        r2 = null;
    L19:
        u3 r5 = (u3) r2;
        if (r5 == null) goto L24;
        IPublicAreaCommon r6 = r5.getOrInitPublicAreaCommon();
        if (r6 == null) goto L24;
        String r7 = r6.getDefaultClickSchemaUrl();
    L25:
        if (r7 != null) goto L27;
    L30:
        boolean r8 = true;
    L31:
        if (r8 == true) goto L75;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L35
        Object r11 = Result.constructor-impl(UriProtector.parse(r7));     // Catch: Throwable -> L35
    L38:
        if (Result.isFailure-impl(r11) == false) goto L40;
        r11 = null;
    L40:
        Uri r13 = (Uri) r11;
        if (r13 == null) goto L75;
        IMiddlewareUserService r14 = jc1.k.f(IMiddlewareUserService.class);
        if (r14 == null) goto L49;
        com.bytedance.android.livesdk.user.e r15 = r14.user();
        if (r15 == null) goto L49;
        String r16 = r15.n();
        if (r16 == null) goto L49;
    L50:
        String r17 = UriProtector.getQueryParameter(r13, "url_query");
        if (r17 != null) goto L53;
    L56:
        boolean r18 = true;
    L58:
        if (r18 == false) goto L61;
        r17 = "user_id=".concat(r16);
    L63:
        Uri r19 = i2.e(r13, "url_query");
        if (r19 == null) goto L68;
        Uri.Builder r20 = r19.buildUpon();
        if (r20 == null) goto L68;
        r4 = r20.appendQueryParameter("url_query", r17);
    L68:
        if (r4 == null) goto L75;
        Uri r21 = r4.build();
        if (r21 == null) goto L75;
        String r23 = r21.toString();
        if (r23 == null) goto L75;
        ALogger.i("PSInteractionMsgClickUtil", "onClickFansClubMsg, url = ".concat(r23));
        r3 = PSInteractionMsgClickUtil.e(r23);
        goto L75
    L61:
        if (StringsKt.contains$default(r17, "user_id=", false, 2, null) == true) goto L63;
        r17 = r17 + "&user_id=" + r16;
        goto L63
    L53:
        if (r17.length() == 0) goto L56;
        r18 = false;
    L49:
        r16 = BuildConfig.FLAVOR;
    L35:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L27:
        if (r7.length() == 0) goto L30;
        r8 = false;
    L24:
        r7 = null;
    L75:
        if (r3 == false) goto L81;
        if (PSInteractionMsgClickUtil.b(this.b) == false) goto L79;
        PSInteractionMsgClickUtil.f("fansclub", "others", this.e);
    L79:
        return true;
    L81:
        return super.E(r10);
    }

    public i(h7 r1, MessageSceneType r2) {
        super(r1, r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.textmessage.model.o
    public final boolean b(IBaseUser r1, ReportObject r2, boolean r3) {
        if (PSInteractionMsgClickUtil.b(this.b) == false) goto L6;
        PSInteractionMsgClickUtil.f("fansclub", "audience_name", this.e);
    L6:
        return super.E(null);
    }
}
