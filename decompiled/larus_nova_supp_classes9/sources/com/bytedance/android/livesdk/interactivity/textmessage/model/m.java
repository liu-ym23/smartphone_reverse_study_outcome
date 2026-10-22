package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.graphics.drawable.BitmapDrawable;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.webkit.URLUtil;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.interactivity.api.entity.SpannableType;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m extends com.bytedance.android.livesdk.interactivity.api.entity.f<o7> {
    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Spannable f() {
        String r1 = null;
        String r2 = gm2.q.b(this.b.getFromUser());     // Catch: Exception -> L7
        String r3 = this.b.getBaseMessage().getDescribe();     // Catch: Exception -> L7
        if (r3.startsWith(r2.concat(":")) == false) goto L10;
        r1 = r3.substring(r2.length() + 1);     // Catch: Exception -> L7
    L10:
        if (TextUtils.isEmpty(r1) == false) goto L13;
        r1 = this.b.getBaseMessage().getDescribe();
    L13:
        if (TextUtils.isEmpty(r1) == true) goto L15;
        r1 = r1 + " ";
    L15:
        String r7 = e();
        IBaseUser r4 = this.b.getFromUser();
        SpannableType r0 = SpannableType.GAME;
        return i0.c(r4, " ", r1, com.bytedance.android.livesdk.interactivity.textmessage.utils.h.b(r0, this.e, this.i), com.bytedance.android.livesdk.interactivity.textmessage.utils.h.a(r0, this.e), r7);
    L7:
        e = move-exception;
        ALogger.e("GiftTextMessage", e);
        goto L10
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final int k() {
        return com.bytedance.android.livesdk.interactivity.textmessage.utils.h.a(SpannableType.DISPLAY_TEXT, this.e);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final int r() {
        return com.bytedance.android.livesdk.interactivity.textmessage.utils.h.b(SpannableType.DISPLAY_TEXT, this.e, this.i);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final tb2.d w() {
        tb2.d r0 = new tb2.d();
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(this.b.getFromUser(), null, false, this.e));
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(" "));
        String r2 = gm2.q.b(this.b.getFromUser());     // Catch: Exception -> L7
        String r3 = this.b.getBaseMessage().getDescribe();     // Catch: Exception -> L7
        if (r3.startsWith(r2.concat(":")) == false) goto L9;
        String r1 = r3.substring(r2.length() + 1);     // Catch: Exception -> L7
    L11:
        if (TextUtils.isEmpty(r1) == false) goto L13;
        r1 = this.b.getBaseMessage().getDescribe();
    L13:
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(r1));
        return r0;
    L9:
        r1 = BuildConfig.FLAVOR;
    L7:
        e = move-exception;
        ALogger.e("GiftTextMessage", e);
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return this.b.getFromUser();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Spannable q() {
        Spannable r0 = super.q();
        h1 r1 = this.b.getGift();
        if (r1 == null) goto L5;
        py.k r2 = r1.getImage();
    L9:
        if (r2 != null) goto L11;
    L17:
        return r0;
    L11:
        if (r2.getUrls() == null) goto L17;
        if (r2.getUrls().isEmpty() == true) goto L17;
        String r3 = (String) ListProtector.get(r2.getUrls(), 0);
        if (URLUtil.isNetworkUrl(r3) == false) goto L17;
        ImageSpan r4 = new ImageSpan(new BitmapDrawable(), r3);
        int r5 = r0.length();
        r0.setSpan(r4, r5 - 1, r5, 33);
        goto L17
    L5:
        boolean r6 = com.bytedance.android.live.revenue.core.util.h.a;
        h2 r7 = com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).findLiteGiftById(this.b.getGiftId());
        if (r7 == null) goto L8;
        r2 = r7.getImage();
        goto L9
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final void i(HashMap<String, String> r3) {
        r3.put("gift_id", String.valueOf(this.b.getGiftId()));
    }

    public m(o7 r2, MessageSceneType r3) {
        super(r2, r3, 0);
    }
}
