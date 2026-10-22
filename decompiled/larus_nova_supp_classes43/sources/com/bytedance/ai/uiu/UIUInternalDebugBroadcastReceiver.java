package com.bytedance.ai.uiu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.uiu.objects.ConversionScene;
import com.bytedance.ai.uiu.objects.PageSetting;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/uiu/UIUInternalDebugBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "KEY_UIU_CONTEXT_TEST_FLAG", "UIU_CONTEXT_TEST_FLAG_FOR_TOP", "UIU_CONTEXT_TEST_FLAG_FOR_ALL", "KEY_UIU_OPERATIONS_CARDID", "KEY_UIU_OPERATIONS_DATA", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UIUInternalDebugBroadcastReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int g = 0;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public static final class a {
    }

    static {
    }

    public UIUInternalDebugBroadcastReceiver() {
        this.a = UIUInternalDebugBroadcastReceiver.class.getName();
        this.b = "flag";
        this.c = "top";
        this.d = "all";
        this.e = "cardId";
        this.f = "data";
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r10, Intent r11) {
        if (r11 == null) goto L52;
        String r12 = r11.getAction();
        if (r12 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r12, "com.bytedance.applet.TEST_UIU_CONTEXT") == false) goto L27;
        com.bytedance.ai.utils.g r13 = com.bytedance.ai.utils.g.a;
        r13.d(this.a, "ACTION_TEST_UIU_CONTEXT.");
        String r14 = r11.getStringExtra(this.b);
        if (r14 != null) goto L49;
        r14 = this.c;
    L49:
    L24:
        e = move-exception;
        com.bytedance.ai.utils.g.a.d(this.a, "UIU test uiu context e=" + e);
        Unit r15 = Unit.INSTANCE;
        return;
    L11:
        if (Intrinsics.areEqual(r14, this.c) == false) goto L20;
        AppletRuntimeManager.INSTANCE.getClass();     // Catch: Exception -> L24
        com.bytedance.ai.model.widgets.c r16 = AppletRuntimeManager.c();     // Catch: Exception -> L24
        if (r16 == null) goto L48;
        PageInfo r17 = r16.getPageInfo();     // Catch: Exception -> L24
        if (r17 == null) goto L48;
        final String r18 = r17.getMessageId();     // Catch: Exception -> L24
        if (r18 == null) goto L48;
        com.bytedance.ai.uiu.a r19 = com.bytedance.ai.uiu.a.a;     // Catch: Exception -> L24
        com.bytedance.ai.uiu.a.f(r18, new c(this, r18));     // Catch: Exception -> L24
    L48:
        return;
    L20:
        if (Intrinsics.areEqual(r14, this.d) == false) goto L22;
        final ConversionScene r20 = m.a();     // Catch: Exception -> L24
        com.bytedance.ai.uiu.a r21 = com.bytedance.ai.uiu.a.a;     // Catch: Exception -> L24
        com.bytedance.ai.uiu.a.e(r20, PageSetting.ALL_PAGE, new d(this, r20));     // Catch: Exception -> L24
        goto L48
    L22:
        r13.d(this.a, "Unknown context test flag");     // Catch: Exception -> L24
        Unit r22 = Unit.INSTANCE;     // Catch: Exception -> L24
        goto L48
    L27:
        if (Intrinsics.areEqual(r12, "com.bytedance.applet.TEST_UIU_OPERATIONS") == false) goto L55;
        com.bytedance.ai.utils.g r23 = com.bytedance.ai.utils.g.a;
        r23.d(this.a, "ACTION_TEST_UIU_OPERATIONS.");
        String r0 = r11.getStringExtra(this.e);
        String r24 = r11.getStringExtra(this.f);
        if (r24 != null) goto L47;
        r24 = "";
    L47:
        String r1 = g.a;     // Catch: Exception -> L44
        if (r0 != null) goto L39;
        AppletRuntimeManager.INSTANCE.getClass();     // Catch: Exception -> L44
        com.bytedance.ai.model.widgets.c r25 = AppletRuntimeManager.c();     // Catch: Exception -> L44
        if (r25 == null) goto L38;
        PageInfo r26 = r25.getPageInfo();     // Catch: Exception -> L44
        if (r26 == null) goto L38;
        r0 = r26.getMessageId();     // Catch: Exception -> L44
    L38:
        r0 = null;
    L39:
        u5.c r27 = g.a(r24, r0);     // Catch: Exception -> L44
        if (r27 != null) goto L42;
        r23.d(this.a, "Parse data error");     // Catch: Exception -> L44
        return;
    L42:
        com.bytedance.ai.uiu.a r28 = com.bytedance.ai.uiu.a.a;     // Catch: Exception -> L44
        String r29 = r27.a;     // Catch: Exception -> L44
        Intrinsics.checkNotNull(r29);     // Catch: Exception -> L44
        com.bytedance.ai.uiu.a.g(r29, r27.b, new e(this));     // Catch: Exception -> L44
        return;
    L44:
        e = move-exception;
        com.bytedance.ai.utils.g.a.d(this.a, "UIU test view operation e=" + e);
        Unit r30 = Unit.INSTANCE;
        return;
    L55:
        return;
    }
}
