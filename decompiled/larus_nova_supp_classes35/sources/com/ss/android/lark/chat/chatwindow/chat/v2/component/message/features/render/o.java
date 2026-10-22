package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration.TopTipsDecoration;
import com.ss.android.lark.chat.entity.chat.BannerSetting;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.a0;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o implements TopTipsDecoration.b {
    public final /* synthetic */ MessageListRendererFeature a;

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration.TopTipsDecoration.b
    public final boolean a() {
        if (MessageListRendererFeature.F(this.a) == false) goto L5;
    L7:
        return false;
    L5:
        if (MessageListRendererFeature.m(this.a) == false) goto L7;
        return true;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.decoration.TopTipsDecoration.b
    public final CharSequence b() {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r0 = this.a.G();
        HashMap<String, String> r1 = null;
        if (r0 == null) goto L7;
        Chat r2 = r0.getCurrentChat();
        if (r2 == null) goto L7;
        BannerSetting r3 = r2.getBannerSetting();
    L9:
        if (this.a.K() == false) goto L14;
        if (r3 == null) goto L13;
        r1 = r3.getI18nNamesMap();
    L13:
        return a0.b(r1);
    L14:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.a r4 = this.a.G();
        if (r4 != null) goto L17;
        return BuildConfig.FLAVOR;
    L17:
        return UIHelper.getQuantityString(2131755054, r4.Fe());
    L7:
        r3 = null;
        goto L9
    }

    public o(MessageListRendererFeature r1) {
        this.a = r1;
    }
}
