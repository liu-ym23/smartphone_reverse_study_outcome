package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.sys;

import android.content.Context;
import android.view.View;
import com.larksuite.component.universe_design.button.UDButton;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ UDButton a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public b(UDButton r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        BrowserDependency r5 = ChatCoreModule.a().getBrowserDependency();
        Context r0 = this.a.getContext();
        String r1 = this.b;
        if (r1 != null) goto L5;
        r1 = BuildConfig.FLAVOR;
    L5:
        r5.openUrl(r0, r1);
        String r6 = this.c;
        Lazy r2 = ChatHitPointNew.a;
        Intrinsics.checkNotNullParameter(r6, "buttonId");
        Map<String, Object> r3 = ChatParamUtils.e();
        if (r3 == null) goto L12;
        Map r7 = MapsKt.plus(r3, MapsKt.mapOf(new Pair[]{TuplesKt.to("click", r6), TuplesKt.to("target", "none")}));
        if (r7 == null) goto L13;
        ChatHitPointNew.d().sendEvent("im_chat_onboarding_click", new JSONObject(r7));
        return;
    L13:
        return;
    }
}
