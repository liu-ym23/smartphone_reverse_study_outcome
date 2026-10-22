package com.obric.assistant.agent;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemGroupTitle;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextDescView;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL;
import com.obric.aiagent.assistant.idl.bean.IntentDebugReport;
import com.obric.aivoice.core.data.NameKeys;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003Jw\u0010\r\u001a\u00020\u000e2#\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00102#\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00102#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010H\u0016Jw\u0010\u0019\u001a\u00020\u000e2#\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00102#\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00102#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010H\u0016J\u007f\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052#\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00102#\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00102#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010H\u0002J+\u0010\u001e\u001a\u00020\u000e2!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u000e0\u0010H\u0016J \u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0005J\u0016\u0010'\u001a\u00020(2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0005J\u001a\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0005H\u0016J\u001a\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0005H\u0016J\n\u0010.\u001a\u0004\u0018\u00010/H\u0002J\b\u00100\u001a\u000201H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u00062"}, d2 = {"Lcom/obric/assistant/agent/ObricAgentServiceImpl;", "Lcom/obric/assistant/agent/IObricAgentApi;", "<init>", "()V", "TAG", NameKeys.UnloadStrategy_No_Strategy, "kotlin.jvm.PlatformType", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope$delegate", "Lkotlin/Lazy;", "screenShot", NameKeys.UnloadStrategy_No_Strategy, "bitmapCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", EasyGoDbTable.Server.NAME, "bitmap", "uriCallback", "Landroid/net/Uri;", "errorCallback", "error", "screenShotForScreenPerception", "createScreenshotCallback", "Lcom/obric/aiagent/assistant/idl/IScreenshotCallbackIDL;", "source", LynxResourceModule.URI_KEY, "webUrl", "callback", LynxEventReporter.PROP_NAME_URL, "createItem", "Lcom/larus/bmhome/view/item/ItemTextDescView;", "context", "Landroid/content/Context;", "label", "value", "createArrowItem", "Lcom/larus/bmhome/view/item/ItemTextArrow;", "supplyDebugItemGroup", "Landroid/widget/LinearLayout;", "messageId", "supplyDebugItemTitle", "Landroidx/appcompat/widget/AppCompatTextView;", "getAgentAppIntentIDL", "Lcom/obric/aiagent/assistant/idl/IAgentAppIntentIDL;", "isFocusedWindowSecure", NameKeys.UnloadStrategy_No_Strategy, "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAgentServiceImpl implements IObricAgentApi {
    public final String a;
    public final Lazy b;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class d() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.view.WindowManagerGlobal");
    }

    public ObricAgentServiceImpl() {
        this.a = "ObricAgentServiceImpl";
        this.b = LazyKt.lazy(new b());
    }

    public static ItemTextArrow e(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "label");
        ItemTextArrow r0 = new ItemTextArrow(r2);
        r0.setText(r3);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r0.setBackgroundResource(2131239212);
        return r0;
    }

    @Override // com.obric.assistant.agent.IObricAgentApi
    public final LinearLayout b(final Context r9, final String r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "messageId");
        IAgentAppIntentIDL r0 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        String r1 = null;
        if (r0 == null) goto L5;
        final IntentDebugReport r2 = r0.getIntentExecution(r10);
    L6:
        ItemGroup r3 = new ItemGroup(r9);
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-1, -2);
        r4.bottomMargin = r9.getResources().getDimensionPixelSize(2131166020);
        r3.setLayoutParams(r4);
        if (r2 == null) goto L9;
        Integer r5 = r2.i();
    L10:
        if (r5 != null) goto L13;
    L15:
        if (r5 != null) goto L18;
    L20:
        if (r5 != null) goto L23;
    L25:
        String r6 = "COMPLETE";
    L26:
        if (r2 == null) goto L28;
        String r7 = r2.c();
    L29:
        if (r7 != null) goto L31;
    L53:
        String r8 = "SUCCESS";
    L54:
        ItemTextArrow r11 = e(r9, "Intent Parameters");
        r11.setOnClickListener(new c(r9, r2, r10));
        ItemTextArrow r12 = e(r9, "PC Search Result");
        r12.setOnClickListener(new d(r9, r2, r10));
        if (r2 == null) goto L57;
        String r13 = r2.j();
    L58:
        r3.addView(f(r9, "Is App Intent", r13));
        if (r2 == null) goto L61;
        String r14 = r2.e();
    L62:
        r3.addView(f(r9, "Intent Domain", r14));
        if (r2 == null) goto L65;
        String r15 = r2.g();
    L66:
        r3.addView(f(r9, "Intent Name", r15));
        r3.addView(r11);
        r3.addView(r12);
        r3.addView(f(r9, "Engine Result Code", r8));
        if (r2 == null) goto L69;
        String r16 = r2.b();
    L70:
        r3.addView(f(r9, "Total_Cost Time", r16));
        if (r2 == null) goto L73;
        r1 = r2.a();
    L73:
        r3.addView(f(r9, "Action Result", r1));
        r3.addView(f(r9, "ResultCode", r6));
        return r3;
    L69:
        r16 = null;
        goto L70
    L65:
        r15 = null;
        goto L66
    L61:
        r14 = null;
        goto L62
    L57:
        r13 = null;
        goto L58
    L31:
        switch(r7.hashCode()) {
            case 43095659: goto L50;
            case 43095660: goto L46;
            case 43095661: goto L42;
            case 43095662: goto L38;
            case 43095663: goto L34;
            default: goto L53;
        };
    L34:
        if (r7.equals("-2004") == false) goto L53;
        r8 = "PARAMS_MISS_ERROR";
        goto L54
    L38:
        if (r7.equals("-2003") == false) goto L53;
        r8 = "ACTION_EXECUTE_ERROR";
        goto L54
    L42:
        if (r7.equals("-2002") == false) goto L53;
        r8 = "INTENT_EXECUTE_ERROR";
        goto L54
    L46:
        if (r7.equals("-2001") == false) goto L53;
        r8 = "JOB_PARSE_ERROR";
        goto L54
    L50:
        if (r7.equals("-2000") == false) goto L53;
        r8 = "DISPATCH_ERROR";
        goto L54
    L28:
        r7 = null;
        goto L29
    L23:
        if (r5.intValue() != 3) goto L25;
        r6 = "INTERRUPT";
        goto L26
    L18:
        if (r5.intValue() != 2) goto L20;
        r6 = "TIME_OUT";
        goto L26
    L13:
        if (r5.intValue() != 1) goto L15;
        r6 = "FAIL";
        goto L26
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.obric.assistant.agent.IObricAgentApi
    public final AppCompatTextView c(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        ItemGroupTitle r4 = new ItemGroupTitle(r2);
        r4.setText("AppIntent Info");
        r4.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        return r4;
    }

    public static ItemTextDescView f(Context r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "label");
        ItemTextDescView r0 = new ItemTextDescView(r1);
        r0.setText(r2);
        if (r3 != null) goto L6;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        r0.setDescText(r3);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r0.setBackgroundResource(2131239212);
        return r0;
    }

    @Override // com.obric.assistant.agent.IObricAgentApi
    public final void a(final Function1<? super Bitmap, Unit> r8, final Function1<? super Uri, Unit> r9, final Function1<? super String, Unit> r10) {
        FLogger.a.d(this.a, "screenShotByScreenshotIntent");
        boolean r0 = false;
        Object r1 = d().getDeclaredMethod("getWindowManagerService", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L5
        Object r2 = r1.getClass().getDeclaredMethod("focusedWindowIsSecure", new Class[0]).invoke(r1, new Object[0]);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L5
        r0 = ((Boolean) r2).booleanValue();     // Catch: Exception -> L5
    L6:
        if (r0 == false) goto L9;
        FLogger.a.d(this.a, "screenShotByScreenshotIntent: focused window is not secure");
        r10.invoke(AppHost.a.getApplication().getApplicationContext().getString(2131912067));
        return;
    L9:
        final String r3 = "screenShotByScreenshotIntent";
        IScreenshotCallbackIDL.Stub r6 = new ObricAgentServiceImpl$createScreenshotCallback$1(r8, this, r3, r9, r10);
        IAgentAppIntentIDL r11 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r11 == null) goto L15;
        r11.takeScreenshot(r6);
        return;
    L15:
        return;
    L5:
        FLogger.a.d(this.a, "isFocusedWindowSecure get error, focusWindowIsSecure now is false");
        goto L6
    }
}
