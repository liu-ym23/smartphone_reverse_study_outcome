package com.obric.miniapp.aibridge;

import android.app.Activity;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.RenderType;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.miniapp.sheet.MiniAppSheetHost;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016JE\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u000fH\u0000¢\u0006\u0002\b\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0006\u001a\u00020\u0007H\u0002JP\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\u001e\u0010 \u001a\u0004\u0018\u00010!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100#H\u0002J\u001e\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100#2\b\u0010\"\u001a\u0004\u0018\u00010\u001aH\u0002¨\u0006%"}, d2 = {"Lcom/obric/miniapp/aibridge/OpenSheetPageMethod;", "Lcom/obric/miniapp/aibridge/AbsOpenSheetPageMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsOpenSheetPageMethodIDL$OpenSheetPageParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsOpenSheetPageMethodIDL$OpenSheetPageResultModel;", "openSheetPage", "onSuccess", "Lkotlin/Function1;", "", "onFailure", "openSheetPage$impl_mainlandRelease", "resolveActivity", "Landroid/app/Activity;", "createPageInfo", "Lcom/bytedance/ai/model/objects/PageInfo;", "pageId", "pageData", "context", "Lcom/google/gson/JsonObject;", "botId", "pageSettings", "messageId", "replyFor", "packageName", "readableMapFrom", "", "source", "", "jsonObjectToStringMap", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenSheetPageMethod extends AbsOpenSheetPageMethodIDL {
    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static /* synthetic */ Unit b(Function1 r0, String r1) {
        return openSheetPage$lambda$7(r0, r1);
    }

    public static /* synthetic */ Unit c(Function1 r0, String r1) {
        return openSheetPage$lambda$8(r0, r1);
    }

    public static /* synthetic */ Unit d(f3.h r0, String r1) {
        return handle$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit e(f3.h r0, String r1) {
        return handle$lambda$1(r0, r1);
    }

    public OpenSheetPageMethod() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_miniapp_aibridge_OpenSheetPageMethod_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    private final Map<String, String> jsonObjectToStringMap(JsonObject r5) {
        if (r5 == null) goto L4;
        Map r0 = MapsKt.createMapBuilder();
        Iterator r6 = r5.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L18;
        Map.Entry r1 = (Map.Entry) r6.next();
        Intrinsics.checkNotNull(r1);
        String r2 = (String) r1.getKey();
        JsonElement r3 = (JsonElement) r1.getValue();
        if (r3.isJsonNull() == true) goto L7;
        Intrinsics.checkNotNull(r2);
        if (r3.isJsonPrimitive() == true) goto L13;
    L15:
        String r4 = r3.toString();
    L16:
        Intrinsics.checkNotNull(r4);
        r0.put(r2, r4);
        goto L7
    L13:
        if (r3.getAsJsonPrimitive().isString() == false) goto L15;
        r4 = r3.getAsString();
        goto L16
    L18:
        return MapsKt.build(r0);
    L4:
        return MapsKt.emptyMap();
    }

    private final Object readableMapFrom(Map<String, String> r8) {
        if (r8.isEmpty() == false) goto L5;
        return null;
    L5:
        Class r0 = INVOKESTATIC_com_obric_miniapp_aibridge_OpenSheetPageMethod_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.ai.bridge.utils.ConvertUtils");
        Method r3 = r0.getMethod("mapToReadableMap", new Class[]{Map.class});
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L8
        Object r5 = Result.constructor-impl(r3.invoke(null, new Object[]{r8}));     // Catch: Throwable -> L8
    L11:
        if (Result.exceptionOrNull-impl(r5) != null) goto L14;
        return r5;
    L14:
        return r3.invoke(r0.getField("INSTANCE").get(null), new Object[]{r8});
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    private final Activity resolveActivity(e3.d r1) {
        Activity r2 = r1.getOwnerActivity();
        if (r2 != null) goto L9;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r3 = AppletRuntimeManager.d;
        if (r3 != null) goto L10;
        return null;
    L10:
        return r3.currentActivity();
    L9:
        return r2;
    }

    private static final Unit handle$lambda$1(f3.h r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "viewId");
        Intrinsics.checkNotNullParameter(AbsOpenSheetPageMethodIDL.b.class, "<this>");
        AbsOpenSheetPageMethodIDL.b r0 = k3.c.a(AbsOpenSheetPageMethodIDL.b.class);
        r0.setViewId(r3);
        r2.b(r0, "");
        return Unit.INSTANCE;
    }

    private static final Unit handle$lambda$2(f3.h r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        f3.h.a.a(r2, r3, null, null, 14);
        return Unit.INSTANCE;
    }

    private static final Unit openSheetPage$lambda$7(Function1 r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "viewId");
        r1.invoke(r2);
        return Unit.INSTANCE;
    }

    private static final Unit openSheetPage$lambda$8(Function1 r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        r1.invoke(r2);
        return Unit.INSTANCE;
    }

    public void handle(e3.d r3, AbsOpenSheetPageMethodIDL.a r4, final f3.h<AbsOpenSheetPageMethodIDL.b> r5) {
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        openSheetPage$impl_mainlandRelease(r3, r4, new w(r5), new x(r5));
    }

    public /* bridge */ /* synthetic */ void handle(e3.d r1, ParamModel r2, f3.h r3) {
        handle(r1, (AbsOpenSheetPageMethodIDL.a) r2, r3);
    }

    public final void openSheetPage$impl_mainlandRelease(e3.d r18, AbsOpenSheetPageMethodIDL.a r19, final Function1<? super String, Unit> r20, final Function1<? super String, Unit> r21) {
        Intrinsics.checkNotNullParameter(r18, "bridgeContext");
        Intrinsics.checkNotNullParameter(r19, "params");
        Intrinsics.checkNotNullParameter(r20, "onSuccess");
        Intrinsics.checkNotNullParameter(r21, "onFailure");
        Activity r5 = resolveActivity(r18);
        if (r5 != null) goto L6;
        r21.invoke("No available activity context");
        return;
    L6:
        AppletRuntime r6 = (AppletRuntime) r18.d(AppletRuntime.class);
        if (r6 != null) goto L10;
        r21.invoke("Applet runtime not found");
        return;
    L10:
        k2.j r0 = (k2.j) r18.d(k2.j.class);
        JsonElement r3 = r19.getContext().get("botId");
        String r7 = null;
        if (r3 == null) goto L16;
        String r4 = r3.getAsString();
        if (r4 == null) goto L16;
    L15:
        String r12 = r4;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L39
        String r9 = r19.getPageId();     // Catch: Throwable -> L39
        String r10 = r19.getPageData();     // Catch: Throwable -> L39
        JsonObject r11 = r19.getContext();     // Catch: Throwable -> L39
        JsonObject r13 = r19.getPageSettings();     // Catch: Throwable -> L39
        if (r0 == null) goto L26;
        PageInfo r1 = r0.getPageInfo();     // Catch: Throwable -> L39
        if (r1 == null) goto L26;
        String r14 = r1.getMessageId();     // Catch: Throwable -> L39
    L27:
        JsonElement r2 = r19.getContext().get("replyFor");     // Catch: Throwable -> L39
        if (r2 == null) goto L33;
        String r15 = r2.getAsString();     // Catch: Throwable -> L39
        if (r15 == null) goto L33;
        String r16 = r15;
    L37:
        Object r17 = Result.constructor-impl(createPageInfo(r9, r10, r11, r12, r13, r14, r16, ((AIPackage) r6.h).b));     // Catch: Throwable -> L39
    L41:
        Throwable r22 = Result.exceptionOrNull-impl(r17);
        if (r22 != null) goto L49;
        PageInfo r23 = (PageInfo) r17;
        if (Intrinsics.areEqual(k2.n.b(r6.h, r23), RenderType.LYNX.getTypeName()) == true) goto L47;
        r21.invoke("openSheetPage only supports Lynx pages");
        return;
    L47:
        MiniAppSheetHost.Companion.open(r5, r6, r23, r19.getPageSettings(), r19.getSheetSettings(), new u(r20), new v(r21));
        return;
    L49:
        r21.invoke("create sheet page info failed: " + r22.getMessage());
        return;
    L33:
        JsonElement r24 = r19.getContext().get("questionId");     // Catch: Throwable -> L39
        if (r24 == null) goto L36;
        r7 = r24.getAsString();     // Catch: Throwable -> L39
    L36:
        r16 = r7;
    L26:
        r14 = null;
    L39:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L16:
        if (r0 == null) goto L18;
        r4 = r0.getBotId();
    L19:
        if (r4 != null) goto L15;
        r4 = r6.h.N;
        goto L15
    L18:
        r4 = null;
        goto L19
    }

    private final PageInfo createPageInfo(String r22, String r23, JsonObject r24, String r25, JsonObject r26, String r27, String r28, String r29) {
        Class r1 = INVOKESTATIC_com_obric_miniapp_aibridge_OpenSheetPageMethod_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.vmsdk.jsbridge.utils.ReadableMap");
        Object r2 = PageInfo.class.getDeclaredConstructor(new Class[]{String.class, String.class, r1, String.class, PageType.class, String.class, String.class, r1, String.class, Double.TYPE, Boolean.TYPE, String.class, Map.class, String.class, String.class, String.class}).newInstance(new Object[]{r22, r23, readableMapFrom(jsonObjectToStringMap(r24)), null, PageType.OTHER, r25, "", readableMapFrom(jsonObjectToStringMap(r26)), r27, Double.valueOf(0.5d), Boolean.FALSE, r28, null, r29, null, null});
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.ai.model.objects.PageInfo");
        return (PageInfo) r2;
    }
}
