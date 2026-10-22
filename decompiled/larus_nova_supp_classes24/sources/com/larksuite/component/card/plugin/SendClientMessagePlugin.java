package com.larksuite.component.card.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.component.card.monitor.UniversalCardMonitorData;
import com.larksuite.component.card.monitor.UniversalCardMonitorUtils;
import com.larksuite.component.card.plugin.model.UniversalCardSendClientMessagePluginModel$PlatformConfig;
import com.larksuite.component.card.plugin.model.UniversalCardSendClientMessagePluginModel$UniversalCardSendClientMessageRequestModel;
import com.larksuite.component.card.plugin.model.UniversalCardSendClientMessagePluginModel$UniversalCardSendClientMessageResponseModel;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.context.action.CardActionService;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.ApkUtil;
import com.larksuite.framework.utils.ICUUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.ss.android.lark.utils.UIHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0017J\u001c\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0010\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0013\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0002¨\u0006\u001f"}, d2 = {"Lcom/larksuite/component/card/plugin/SendClientMessagePlugin;", "Lcom/larksuite/component/card/plugin/OPPlugin;", "<init>", "()V", "sendClientMessage", "", "lkEvent", "Lcom/larksuite/framework/apiplugin/LKEvent;", "request", "Lcom/larksuite/component/card/plugin/model/UniversalCardSendClientMessagePluginModel$UniversalCardSendClientMessageRequestModel;", "invokeCallback", "Lcom/larksuite/framework/apiplugin/api/LKEventInvokeCallback;", "Lcom/larksuite/component/card/plugin/model/UniversalCardSendClientMessagePluginModel$UniversalCardSendClientMessageResponseModel;", "reportActionClick", "tag", "", "reportSuccess", "startActionTime", "", "reportError", "errorMsg", "showToast", "context", "Landroid/content/Context;", "content", "checkMinVersion", "", "minVersion", "versionMatch", "currentVersion", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class SendClientMessagePlugin extends OPPlugin {
    private static final String CHECK_LARK_VERSION_REGEX_PATTERN = "^(\\d+)\\.(\\d+)(\\.\\d+)?";
    public static final a Companion = null;
    private static final String ERROR_ACTION_IS_EXPIRED = "action is expired";
    private static final String ERROR_NO_HANDLER = "no handler";
    private static final String ERROR_PLATFORM_NOT_SUPPORT = "platform not support";
    private static final String ERROR_VERSION_NOT_MATCH = "version not match";
    private static final String TAG = "universalCardSendClientMessage";

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;

        public b(Context r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UDToast.show(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    public SendClientMessagePlugin() {
    }

    private final boolean checkMinVersion(String r5) {
        String r0 = ApkUtil.getAppVersionName(com.larksuite.framework.utils.b.a);
        Log.i(TAG, "checkMinVersion: currentVersion is " + r0 + ", minVersion is " + r5);
        Matcher r1 = PatternProtector.compile(CHECK_LARK_VERSION_REGEX_PATTERN).matcher(r0);
        if (r1.find() == false) goto L23;
        String r2 = r1.group();
        if (TextUtils.equals(r5, r2) == false) goto L7;
        return true;
    L7:
        boolean r3 = false;
        if (r5 != null) goto L10;
    L13:
        boolean r4 = true;
    L14:
        if (r4 == true) goto L23;
        if (r2 != null) goto L17;
    L18:
        r3 = true;
    L19:
        if (r3 == true) goto L23;
        return versionMatch(r2, r5);
    L17:
        if (r2.length() != 0) goto L19;
    L10:
        if (r5.length() == 0) goto L13;
        r4 = false;
    L23:
        return true;
    }

    private final void showToast(Context r2, String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        if (r2 == null) goto L13;
        mz7.b.a(new b(r2, r3));
        return;
    L13:
        return;
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    private final boolean versionMatch(String r7, String r8) {
        List r9 = new Regex("\\.").split(r7, 0);
        if (r9.isEmpty() == true) goto L13;
        ListIterator r0 = r9.listIterator(r9.size());
    L6:
        if (r0.hasPrevious() == false) goto L13;
        if (((String) r0.previous()).length() != 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L6;
        List r10 = CollectionsKt.take(r9, r0.nextIndex() + 1);
    L14:
        String[] r11 = (String[]) r10.toArray(new String[0]);
        List r12 = new Regex("\\.").split(r8, 0);
        if (r12.isEmpty() == true) goto L25;
        ListIterator r1 = r12.listIterator(r12.size());
    L18:
        if (r1.hasPrevious() == false) goto L25;
        if (((String) r1.previous()).length() != 0) goto L22;
        boolean r2 = true;
    L23:
        if (r2 == true) goto L18;
        List r13 = CollectionsKt.take(r12, r1.nextIndex() + 1);
    L26:
        String[] r14 = (String[]) r13.toArray(new String[0]);
        if (r11.length == r14.length) goto L29;
        return false;
    L29:
        int r3 = r11.length;
        int r5 = 0;
    L30:
        if (r5 >= r3) goto L37;
        int r6 = CastIntegerProtector.parseInt(r11[r5]);
        int r15 = CastIntegerProtector.parseInt(r14[r5]);
        if (r6 > r15) goto L37;
        if (r6 < r15) goto L52;
        r5 = r5 + 1;
        goto L30
    L52:
        return false;
    L37:
        return true;
    L22:
        r2 = false;
    L25:
        r13 = CollectionsKt.emptyList();
        goto L26
    L10:
        r4 = false;
    L13:
        r10 = CollectionsKt.emptyList();
        goto L14
    }

    public void reportActionClick(LKEvent r12, String r13) {
        String r0 = null;
        if (r12 == null) goto L5;
        Object r14 = r12.h;
    L7:
        if ((r14 instanceof ILynxBridgeContext) == false) goto L41;
        ILynxContainerContext r15 = ((ILynxBridgeContext) r14).getContainerContext();
        if (r15 == null) goto L13;
        Map r16 = r15.getBizExtra();
        if (r16 == null) goto L13;
        Object r17 = r16.get("card_share_data");
    L15:
        if ((r17 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L17;
        com.larksuite.component.card.cardcontainer.c r19 = (com.larksuite.component.card.cardcontainer.c) r17;
    L18:
        if (r19 == null) goto L22;
        CardData r1 = r19.b;
        if (r1 == null) goto L22;
        String r2 = r1.getVersion();
    L24:
        if (r19 == null) goto L28;
        CardContext r3 = r19.c;
        if (r3 == null) goto L28;
        UniversalCardMonitorData r5 = r3.getMonitorData();
    L29:
        if (r19 == null) goto L33;
        CardData r4 = r19.b;
        if (r4 == null) goto L33;
        r0 = r4.getCardID();
    L33:
        String r6 = r0;
        if (r19 == null) goto L38;
        CardData r110 = r19.b;
        if (r110 == null) goto L38;
        boolean r8 = r110.isStreamingMode();
    L39:
        com.larksuite.component.card.monitor.a.b(r2, "client_message", r13, r5, r6, null, r8, null, 160);
        return;
    L38:
        r8 = false;
    L28:
        r5 = null;
    L22:
        r2 = null;
        goto L24
    L17:
        r19 = null;
    L13:
        r17 = null;
        goto L15
    L41:
        return;
    L5:
        r14 = null;
        goto L7
    }

    public void reportError(LKEvent r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "errorMsg");
        UniversalCardMonitorData r0 = null;
        if (r5 == null) goto L5;
        Object r8 = r5.h;
    L7:
        if ((r8 instanceof ILynxBridgeContext) == false) goto L45;
        ILynxContainerContext r9 = ((ILynxBridgeContext) r8).getContainerContext();
        if (r9 == null) goto L13;
        Map r10 = r9.getBizExtra();
        if (r10 == null) goto L13;
        Object r11 = r10.get("card_share_data");
    L15:
        if ((r11 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L17;
        com.larksuite.component.card.cardcontainer.c r12 = (com.larksuite.component.card.cardcontainer.c) r11;
    L18:
        int r1 = UniversalCardMonitorUtils.a;
        if (r12 == null) goto L23;
        CardData r2 = r12.b;
        if (r2 == null) goto L23;
        String r3 = r2.getCardID();
    L24:
        if (r12 == null) goto L30;
        CardContext r4 = r12.c;
        if (r4 == null) goto L30;
        OPTrace r13 = r4.getRenderTrace();
        if (r13 == null) goto L30;
        OPTrace r14 = r13.subTrace();
    L31:
        if (r12 == null) goto L36;
        CardContext r15 = r12.c;
        if (r15 == null) goto L36;
        r0 = r15.getMonitorData();
    L36:
        if (TextUtils.isEmpty(r3) == true) goto L46;
        fyb.e r16 = com.larksuite.component.card.monitor.b.a;
        OPMonitor r17 = com.larksuite.component.card.monitor.b.c.a(ncb.c.n).addCategoryValue(CardActionService.CARD_ID, r3).addCategoryValue("error_msg", r6).addCategoryValue("component_tag", r7).tracing(r14);
        if (r0 != null) goto L41;
    L43:
        r17.flush();
        return;
    L41:
        if (r0.getMonitorCategoryMap() == null) goto L43;
        r17.addMap(r0.getMonitorCategoryMap());
        goto L43
    L46:
        return;
    L30:
        r14 = null;
    L23:
        r3 = null;
        goto L24
    L17:
        r12 = null;
    L13:
        r11 = null;
        goto L15
    L45:
        return;
    L5:
        r8 = null;
        goto L7
    }

    public void reportSuccess(LKEvent r6, long r7, String r9) {
        UniversalCardMonitorData r0 = null;
        if (r6 == null) goto L5;
        Object r8 = r6.h;
    L7:
        if ((r8 instanceof ILynxBridgeContext) == false) goto L46;
        ILynxContainerContext r10 = ((ILynxBridgeContext) r8).getContainerContext();
        if (r10 == null) goto L13;
        Map r11 = r10.getBizExtra();
        if (r11 == null) goto L13;
        Object r12 = r11.get("card_share_data");
    L15:
        if ((r12 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L17;
        com.larksuite.component.card.cardcontainer.c r13 = (com.larksuite.component.card.cardcontainer.c) r12;
    L18:
        int r1 = UniversalCardMonitorUtils.a;
        if (r13 == null) goto L23;
        CardData r2 = r13.b;
        if (r2 == null) goto L23;
        String r3 = r2.getCardID();
    L24:
        if (r13 == null) goto L30;
        CardContext r4 = r13.c;
        if (r4 == null) goto L30;
        OPTrace r5 = r4.getRenderTrace();
        if (r5 == null) goto L30;
        OPTrace r14 = r5.subTrace();
    L31:
        long r15 = System.currentTimeMillis() - r7;
        if (r13 == null) goto L37;
        CardContext r16 = r13.c;
        if (r16 == null) goto L37;
        r0 = r16.getMonitorData();
    L37:
        if (TextUtils.isEmpty(r3) == true) goto L47;
        fyb.e r17 = com.larksuite.component.card.monitor.b.a;
        OPMonitor r19 = com.larksuite.component.card.monitor.b.c.a(ncb.c.m).addCategoryValue(CardActionService.CARD_ID, r3).addCategoryValue("component_tag", r9).setDuration(r15).tracing(r14);
        if (r0 != null) goto L42;
    L44:
        r19.flush();
        return;
    L42:
        if (r0.getMonitorCategoryMap() == null) goto L44;
        r19.addMap(r0.getMonitorCategoryMap());
        goto L44
    L47:
        return;
    L30:
        r14 = null;
    L23:
        r3 = null;
        goto L24
    L17:
        r13 = null;
    L13:
        r12 = null;
        goto L15
    L46:
        return;
    L5:
        r8 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LKPluginFunction(async = true, eventName = {TAG})
    public void sendClientMessage(LKEvent r19, UniversalCardSendClientMessagePluginModel$UniversalCardSendClientMessageRequestModel r110, j18.f<UniversalCardSendClientMessagePluginModel$UniversalCardSendClientMessageResponseModel> r20) {
        Intrinsics.checkNotNullParameter(r110, "request");
        Intrinsics.checkNotNullParameter(r20, "invokeCallback");
        long r4 = System.currentTimeMillis();
        reportActionClick(r19, r110.tag);
        UniversalCardSendClientMessagePluginModel$PlatformConfig r6 = r110.platformConfig;
        boolean r8 = false;
        if (r6 != null) goto L5;
    L7:
        boolean r9 = false;
    L9:
        if (r9 == true) goto L21;
        if (r19 == null) goto L18;
        Context r5 = r19.getContext();
        if (r5 == null) goto L18;
        if (r6 == null) goto L16;
        String r7 = r6.fallbackToast;
        if (r7 == null) goto L16;
    L17:
        showToast(r5, r7);
    L16:
        r7 = r5.getString(2131892783);
    L18:
        reportError(r19, ERROR_PLATFORM_NOT_SUPPORT, r110.tag);
        r20.callback(new UniversalCardSendClientMessagePluginModel$UniversalCardSendClientMessageResponseModel());
        return;
    L21:
        if (checkMinVersion(r6.minVersion) == true) goto L28;
        if (r19 == null) goto L26;
        Context r10 = r19.getContext();
        if (r10 == null) goto L26;
        String r11 = UIHelper.getString(2131892784);
        ICUUtils.FormatArgsBuilder r12 = new ICUUtils.FormatArgsBuilder();
        r12.b("APP_DISPLAY_NAME", UIHelper.getAppName());
        showToast(r10, ICUUtils.icuFormat(r11, r12.a));
    L26:
        reportError(r19, ERROR_VERSION_NOT_MATCH, r110.tag);
        r20.callback(new UniversalCardSendClientMessagePluginModel$UniversalCardSendClientMessageResponseModel());
        return;
    L28:
        TimeUnit r13 = TimeUnit.MILLISECONDS;
        yy7.a r14 = ty7.a.a();
        if (r14 == null) goto L33;
        Long r15 = r14.getNtpTime();
        if (r15 == null) goto L33;
        long r16 = r15.longValue();
    L34:
        long r17 = r13.toSeconds(r16);
        long r111 = CastLongProtector.parseLong(r110.expiredTime);     // Catch: Exception -> L37
    L39:
        if (r111 > 0) goto L41;
    L49:
        com.larksuite.component.card.action.client.b r21 = com.larksuite.component.card.action.client.b.a;
        String r112 = r110.channel;
        Intrinsics.checkNotNullParameter(r112, "channel");
        Map<String, List<com.larksuite.component.card.action.client.c>> r113 = com.larksuite.component.card.action.client.b.b;
        List r114 = (List) ((LinkedHashMap) r113).get(r112);
        if (r114 == null) goto L52;
        r8 = !r114.isEmpty();
    L52:
        if (r8 == true) goto L62;
        if (r19 == null) goto L60;
        Context r22 = r19.getContext();
        if (r22 == null) goto L60;
        String r23 = r6.fallbackToast;
        if (r23 != null) goto L59;
        r23 = r22.getString(2131892783);
    L59:
        showToast(r22, r23);
    L60:
        reportError(r19, ERROR_NO_HANDLER, r110.tag);
        r20.callback(new UniversalCardSendClientMessagePluginModel$UniversalCardSendClientMessageResponseModel());
        return;
    L62:
        String r24 = r110.channel;
        JSONObject r25 = new JSONObject(r110.value);
        monitor-enter(r21);
        Intrinsics.checkNotNullParameter(r24, "channel");     // Catch: Throwable -> L78
        Intrinsics.checkNotNullParameter(r25, "eventParams");     // Catch: Throwable -> L78
        if (r113.containsKey(r24) == true) goto L68;
        monitor-exit(r21);
    L76:
        reportSuccess(r19, r4, r110.tag);
        r20.callback(new UniversalCardSendClientMessagePluginModel$UniversalCardSendClientMessageResponseModel());
        return;
    L68:
        List r26 = (List) ((LinkedHashMap) r113).get(r24);     // Catch: Throwable -> L78
        if (r26 == null) goto L75;
        Iterator r27 = r26.iterator();     // Catch: Throwable -> L78
    L72:
        if (r27.hasNext() == false) goto L75;
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new com.larksuite.component.card.action.client.a((com.larksuite.component.card.action.client.c) r27.next(), r25));     // Catch: Throwable -> L78
    L75:
        monitor-exit(r21);
    L78:
        th = move-exception;
        throw th;
    L41:
        if (r17 <= 0) goto L49;
        if (r111 > r17) goto L49;
        if (r19 == null) goto L46;
        Context r29 = r19.getContext();
    L47:
        showToast(r29, r110.expiredTips);
        reportError(r19, ERROR_ACTION_IS_EXPIRED, r110.tag);
        r20.callback(new UniversalCardSendClientMessagePluginModel$UniversalCardSendClientMessageResponseModel());
        return;
    L46:
        r29 = null;
    L37:
        r111 = 0;
    L33:
        r16 = System.currentTimeMillis();
        goto L34
    L5:
        if (r6.support != true) goto L7;
        r9 = true;
        goto L9
    }
}
