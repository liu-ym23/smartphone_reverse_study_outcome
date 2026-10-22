package com.bytedance.ai.uiu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.p;
import com.bytedance.ai.uiu.objects.ConversionScene;
import com.bytedance.ai.uiu.objects.PageSetting;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/uiu/UIUInternalDebugBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UIUInternalDebugBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2823c;
    public final String d;
    public final String e;
    public final String f;

    public UIUInternalDebugBroadcastReceiver() {
        this.f2821a = UIUInternalDebugBroadcastReceiver.class.getName();
        this.f2822b = "flag";
        this.f2823c = "top";
        this.d = "all";
        this.e = "cardId";
        this.f = "data";
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r13, Intent r14) {
        if (r14 == null) goto L72;
        String r15 = r14.getAction();
        if (r15 == null) goto L73;
        boolean r5 = Intrinsics.areEqual(r15, "com.bytedance.applet.TEST_UIU_CONTEXT");
        String r10 = this.f2821a;
        if (r5 == false) goto L39;
        Intrinsics.checkNotNullParameter(r10, "tag");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L10;
        r16.d(r10, "ACTION_TEST_UIU_CONTEXT.");
    L10:
        String r17 = r14.getStringExtra(this.f2822b);
        String r18 = this.f2823c;
        if (r17 != null) goto L69;
        r17 = r18;
    L69:
    L23:
        e = move-exception;
        String r12 = "UIU test uiu context e=" + e;
        Intrinsics.checkNotNullParameter(r10, "tag");
        t0.d r19 = com.bytedance.ai.utils.c.f2846a;
        if (r19 == null) goto L37;
        r19.d(r10, r12);
    L37:
        Unit r110 = Unit.INSTANCE;
        return;
    L14:
        if (Intrinsics.areEqual(r17, r18) == false) goto L26;
        com.bytedance.ai.model.widgets.a r111 = p.b();     // Catch: Exception -> L23
        if (r111 == null) goto L74;
        PageInfo r112 = r111.f2330b;     // Catch: Exception -> L23
        if (r112 == null) goto L75;
        String r113 = r112.getMessageId();     // Catch: Exception -> L23
        if (r113 == null) goto L76;
        com.bytedance.ai.model.widgets.d r114 = new com.bytedance.ai.model.widgets.d(7, this, r113);     // Catch: Exception -> L23
        Intrinsics.checkNotNullParameter(r113, "cardId");     // Catch: Exception -> L23
        Intrinsics.checkNotNullParameter(r114, "callback");     // Catch: Exception -> L23
        BuildersKt.launch$default(h0.a(Dispatchers.getMain()), null, null, new UIUContextManager$getTargetPagesUiContext$2(r114, r113, null), 3, null);     // Catch: Exception -> L23
        return;
    L76:
        return;
    L75:
        return;
    L74:
        return;
    L26:
        if (Intrinsics.areEqual(r17, this.d) == false) goto L29;
        ConversionScene r115 = c.a();     // Catch: Exception -> L23
        PageSetting r116 = PageSetting.ALL_PAGE;     // Catch: Exception -> L23
        com.bytedance.ai.model.widgets.d r11 = new com.bytedance.ai.model.widgets.d(8, this, r115);     // Catch: Exception -> L23
        Intrinsics.checkNotNullParameter(r115, "csvScene");     // Catch: Exception -> L23
        Intrinsics.checkNotNullParameter(r116, "pageSetting");     // Catch: Exception -> L23
        Intrinsics.checkNotNullParameter(r11, "callback");     // Catch: Exception -> L23
        BuildersKt.launch$default(h0.a(Dispatchers.getMain()), null, null, new UIUContextManager$getTargetPagesUiContext$1(r115, r116, r11, null), 3, null);     // Catch: Exception -> L23
        return;
    L29:
        Intrinsics.checkNotNullParameter(r10, "tag");     // Catch: Exception -> L23
        t0.d r117 = com.bytedance.ai.utils.c.f2846a;     // Catch: Exception -> L23
        if (r117 == null) goto L32;
        r117.d(r10, "Unknown context test flag");     // Catch: Exception -> L23
    L32:
        Unit r118 = Unit.INSTANCE;     // Catch: Exception -> L23
        return;
    L39:
        if (Intrinsics.areEqual(r15, "com.bytedance.applet.TEST_UIU_OPERATIONS") == false) goto L78;
        Intrinsics.checkNotNullParameter(r10, "tag");
        t0.d r119 = com.bytedance.ai.utils.c.f2846a;
        if (r119 == null) goto L43;
        r119.d(r10, "ACTION_TEST_UIU_OPERATIONS.");
    L43:
        String r120 = r14.getStringExtra(this.e);
        String r121 = r14.getStringExtra(this.f);
        if (r121 != null) goto L70;
        r121 = "";
    L70:
        Regex r20 = d.f2828a;     // Catch: Exception -> L53
        if (r120 != null) goto L56;
        com.bytedance.ai.model.widgets.a r122 = p.b();     // Catch: Exception -> L53
        if (r122 == null) goto L55;
        PageInfo r123 = r122.f2330b;     // Catch: Exception -> L53
        if (r123 == null) goto L55;
        r120 = r123.getMessageId();     // Catch: Exception -> L53
    L55:
        r120 = null;
    L56:
        g3.c r124 = d.a(r121, r120);     // Catch: Exception -> L53
        if (r124 != null) goto L62;
        Intrinsics.checkNotNullParameter(r10, "tag");     // Catch: Exception -> L53
        t0.d r125 = com.bytedance.ai.utils.c.f2846a;     // Catch: Exception -> L53
        if (r125 == null) goto L71;
        r125.d(r10, "Parse data error");     // Catch: Exception -> L53
        return;
    L71:
        return;
    L62:
        String r126 = r124.f17026a;     // Catch: Exception -> L53
        Intrinsics.checkNotNull(r126);     // Catch: Exception -> L53
        List r127 = r124.f17027b;     // Catch: Exception -> L53
        com.bytedance.ai.bridge.method.net.e r21 = new com.bytedance.ai.bridge.method.net.e(this, 4);     // Catch: Exception -> L53
        Intrinsics.checkNotNullParameter(r126, "cardId");     // Catch: Exception -> L53
        Intrinsics.checkNotNullParameter(r127, "uiOperations");     // Catch: Exception -> L53
        Intrinsics.checkNotNullParameter(r21, "callback");     // Catch: Exception -> L53
        BuildersKt.launch$default(h0.a(Dispatchers.getMain()), null, null, new UIUContextManager$performUIOperations$2(r21, r126, r127, null), 3, null);     // Catch: Exception -> L53
        return;
    L53:
        e = move-exception;
        String r128 = "UIU test view operation e=" + e;
        Intrinsics.checkNotNullParameter(r10, "tag");
        t0.d r129 = com.bytedance.ai.utils.c.f2846a;
        if (r129 == null) goto L67;
        r129.d(r10, r128);
    L67:
        Unit r130 = Unit.INSTANCE;
        return;
    L78:
        return;
    L73:
        return;
    }
}
