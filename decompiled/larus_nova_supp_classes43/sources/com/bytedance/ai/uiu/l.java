package com.bytedance.ai.uiu;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.uiu.objects.ConversionScene;
import com.bytedance.ai.uiu.objects.PageSetting;
import com.bytedance.ai.uiu.objects.UIUContextPluginParams;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l {
    public final String a;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PageSetting.values().length];
            r0[PageSetting.ALL_PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[PageSetting.LAST_PAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[PageSetting.TARGET_PAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public l() {
        this.a = l.class.getName();
    }

    public final String b(String r10) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        JSONObject r11 = sx7.a.a(r10);     // Catch: Throwable -> L9
        if (r11 == null) goto L6;
        String r12 = JSONObjectProtectorUtils.getString(r11, "data");     // Catch: Throwable -> L9
    L7:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L9
    L11:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L15;
        com.bytedance.ai.utils.g.a.d(this.a, "Parse origin data e=" + r14);
    L15:
        if (Result.isFailure-impl(r13) == false) goto L17;
        r13 = null;
    L17:
        String r15 = (String) r13;
        if (r15 == null) goto L42;
        JSONObject r16 = sx7.a.a(r15);     // Catch: Throwable -> L25
        if (r16 == null) goto L22;
        String r17 = JSONObjectProtectorUtils.getString(r16, "pluginParams");     // Catch: Throwable -> L25
    L23:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L25
    L27:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L31;
        com.bytedance.ai.utils.g.a.d(this.a, "Parse origin pluginParams e=" + r19);
    L31:
        if (Result.isFailure-impl(r18) == true) goto L34;
        r0 = r18;
    L34:
        String r20 = (String) r0;
        if (r20 != null) goto L43;
        return "";
    L43:
        return r20;
    L22:
        r17 = null;
    L25:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L42:
        return null;
    L6:
        r12 = null;
    L9:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void a(String r10, String r11, String r12, String r13, String r14, final com.bytedance.applet.event.b r15) {
        Intrinsics.checkNotNullParameter(r10, "botId");
        Intrinsics.checkNotNullParameter(r11, BdpAwemeConstant.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r12, "csvId");
        Intrinsics.checkNotNullParameter(r13, "apiName");
        Intrinsics.checkNotNullParameter(r14, "param");
        Intrinsics.checkNotNullParameter(r15, "uiUAppActionCallback");
        ConversionScene r16 = m.a();
        com.bytedance.ai.utils.g r17 = com.bytedance.ai.utils.g.a;
        r17.d(this.a, "Action process for apiName=" + r13 + ", param=" + r14 + ", csvScene=" + r16);
        if (Intrinsics.areEqual(r13, "system_ui_understanding_plugin.system_do_view_operations_tool") == false) goto L13;
        u5.c r18 = g.a(b(r14), null);
        if (r18 != null) goto L9;
        JSONObject r19 = new JSONObject();
        r19.put(com.bytedance.android.ec.core.event.a.KEY_RESULT, "false");
        Unit r20 = Unit.INSTANCE;
        r15.invoke(0, "false", com.bytedance.ai.uiu.b.a(r19.toString()));
        return;
    L9:
        if (com.bytedance.ai.utils.f.g(r18.a) == false) goto L11;
        com.bytedance.ai.uiu.a r21 = com.bytedance.ai.uiu.a.a;
        String r22 = r18.a;
        Intrinsics.checkNotNull(r22);
        com.bytedance.ai.uiu.a.g(r22, r18.b, new h(r15));
        return;
    L11:
        com.bytedance.ai.uiu.a r23 = com.bytedance.ai.uiu.a.a;
        List<u5.a> r24 = r18.b;
        Function1 r25 = new i(r15);
        Intrinsics.checkNotNullParameter(r24, "uiOperations");
        Intrinsics.checkNotNullParameter(r25, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new UIUContextManager$performUIOperations$1(r25, r24, null), 3, null);
        return;
    L13:
        if (Intrinsics.areEqual(r13, "system_ui_understanding_plugin.system_get_uiu_context_tool") == false) goto L32;
        String r26 = b(r14);
        Lazy r110 = com.bytedance.ai.applet.base.gson.e.a;
        UIUContextPluginParams r27 = (UIUContextPluginParams) com.bytedance.ai.applet.base.gson.e.a(r26, UIUContextPluginParams.class);
        if (r27.getPageSetting() != null) goto L17;
        r27.setPageSetting(PageSetting.ALL_PAGE);
    L17:
        PageSetting r111 = r27.getPageSetting();
        if (r111 != null) goto L20;
        int r112 = -1;
    L22:
        if (r112 != 1) goto L24;
    L31:
        com.bytedance.ai.uiu.a r28 = com.bytedance.ai.uiu.a.a;
        PageSetting r29 = r27.getPageSetting();
        Intrinsics.checkNotNull(r29);
        com.bytedance.ai.uiu.a.e(r16, r29, new j(r15));
        return;
    L24:
        if (r112 == 2) goto L31;
        if (r112 == 3) goto L28;
        r17.d(this.a, "Unknown page setting=" + r27.getPageSetting());
        return;
    L28:
        String r30 = r27.getCardId();
        if (r30 == null) goto L37;
        com.bytedance.ai.uiu.a r31 = com.bytedance.ai.uiu.a.a;
        com.bytedance.ai.uiu.a.f(r30, new k(r15));
        return;
    L37:
        return;
    L20:
        r112 = b.a[r111.ordinal()];
        goto L22
    L32:
        r17.d(this.a, "Unknown uiu process api name");
    }
}
