package h4a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.api.AppletService;
import com.bytedance.locallife.ILocalLifeService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.deeplink.api.IDeeplinkService;
import com.larus.im.FlowRuntime;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import com.larus.search.api.IBrowserService;
import com.larus.utils.logger.FLogger;
import com.lynx.devtoolwrapper.ScreenshotMode;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tx9.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j implements hx7.f {

    public static final class a {
    }

    static {
    }

    public j() {
    }

    private final Activity getActivity(Context r3) {
        if ((r3 instanceof Activity) == false) goto L5;
        Activity r0 = (Activity) r3;
    L6:
        if (r0 == null) goto L9;
        return r0;
    L9:
        if ((r3 instanceof MutableContextWrapper) == false) goto L11;
        MutableContextWrapper r4 = (MutableContextWrapper) r3;
    L12:
        if (r4 == null) goto L14;
        Context r5 = r4.getBaseContext();
    L16:
        if ((r5 instanceof Activity) == false) goto L18;
        Activity r6 = (Activity) r5;
    L19:
        if (r6 == null) goto L21;
        return r6;
    L21:
        return null;
    L18:
        r6 = null;
        goto L19
    L14:
        r5 = null;
        goto L16
    L11:
        r4 = null;
        goto L12
    L5:
        r0 = null;
        goto L6
    }

    public final boolean closeView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Activity r1 = null;
        if ((r4 instanceof Activity) == false) goto L5;
        Activity r0 = (Activity) r4;
    L7:
        if (r0 == null) goto L11;
        r0.finish();
        return true;
    L11:
        if ((r4 instanceof MutableContextWrapper) == false) goto L13;
        MutableContextWrapper r5 = (MutableContextWrapper) r4;
    L14:
        if (r5 == null) goto L16;
        Context r6 = r5.getBaseContext();
    L18:
        if ((r6 instanceof Activity) == false) goto L20;
        r1 = (Activity) r6;
    L20:
        if (r1 == null) goto L23;
        r1.finish();
        return true;
    L23:
        return false;
    L16:
        r6 = null;
        goto L18
    L13:
        r5 = null;
        goto L14
    L5:
        r0 = null;
        goto L7
    }

    public final boolean interceptClose(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        FragmentActivity r5 = getActivity(r4);
        if ((r5 instanceof FragmentActivity) == false) goto L13;
        AppletService r0 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L13;
        r5.onBackPressed();
        return true;
    L7:
        if (r0.g(r5) != true) goto L9;
        r1 = true;
    L13:
        return false;
    }

    public final boolean openSchema(String r12, Map<String, ? extends Object> r13, Context r14) {
        Intrinsics.checkNotNullParameter(r12, "schema");
        Intrinsics.checkNotNullParameter(r13, "extraInfo");
        Uri r15 = UriProtector.parse(r12);
        if (Intrinsics.areEqual(r15.getScheme(), "nova") == false) goto L22;
        String r0 = UriProtector.getQueryParameter(r15, "poiname");
        if (r0 != null) goto L7;
        r0 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        String r9 = r0;
        String r1 = UriProtector.getQueryParameter(r15, "lat");
        if (r1 == null) goto L10;
        Double r2 = Double.valueOf(CastDoubleProtector.parseDouble(r1));
    L11:
        String r3 = UriProtector.getQueryParameter(r15, "lon");
        if (r3 == null) goto L14;
        Double r4 = Double.valueOf(CastDoubleProtector.parseDouble(r3));
    L15:
        final String r5 = UriProtector.getQueryParameter(r15, "bot_id");
        final String r6 = UriProtector.getQueryParameter(r15, "message_id");
        final String r7 = UriProtector.getQueryParameter(r15, "conversation_id");
        if (r14 == null) goto L22;
        if (r2 == null) goto L22;
        if (r4 == null) goto L22;
        IAIChatService.a.y7(r14, r2.doubleValue(), r4.doubleValue(), r9, new i(r5, r6, r7));
        return true;
    L14:
        r4 = null;
        goto L15
    L10:
        r2 = null;
    L22:
        if (Intrinsics.areEqual(r15.getScheme(), "snssdk1128") == true) goto L24;
    L39:
        String r8 = UriProtector.parse(r12).getAuthority();
        if (r8 != null) goto L42;
        return false;
    L42:
        FLogger.a.d("RouterBridgeDependInjectImpl", "schema -> " + r12 + " , authority -> " + r8);
        switch(r8.hashCode()) {
            case -1932693274: goto L82;
            case -1772600516: goto L71;
            case -1411061670: goto L67;
            case -1001735703: goto L64;
            case -629412091: goto L61;
            case 3146030: goto L55;
            case 862922167: goto L52;
            case 1123375361: goto L49;
            case 1224424441: goto L46;
            default: goto L129;
        };
    L129:
        if (r14 != null) goto L131;
        r14 = AppHost.a.getApplication().getApplicationContext();
    L131:
        SmartRouter.buildRoute(r14, r12).d();
    L132:
        return true;
    L46:
        if (r8.equals("webview") == false) goto L129;
    L84:
        Activity r16 = getActivity(r14);
        if (r16 == null) goto L132;
        Uri r17 = UriProtector.parse(r12);
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r17, "use_bullet"), "1") == false) goto L90;
        qg9.a.d(r16, r17);
        return true;
    L90:
        if (r17 == null) goto L92;
        String r10 = UriProtector.getQueryParameter(r17, "use_anniex");
    L94:
        if (Intrinsics.areEqual(r10, "1") == true) goto L127;
        if (r17 == null) goto L97;
        String r11 = UriProtector.getQueryParameter(r17, "mix_container_type");
    L99:
        if (Intrinsics.areEqual(r11, "anniex") == true) goto L127;
        FlowRuntime.a().isOversea();
        Uri.Builder r18 = UriProtector.parse(UriProtector.getQueryParameter(r17, LynxEventReporter.PROP_NAME_URL)).buildUpon();
        Set r19 = UriProtector.getQueryParameterNames(r17);
        ArrayList r20 = new ArrayList();
        Iterator r21 = r19.iterator();
    L103:
        if (r21.hasNext() == false) goto L107;
        Object r22 = r21.next();
        if ((!Intrinsics.areEqual((String) r22, LynxEventReporter.PROP_NAME_URL)) == false) goto L103;
        r20.add(r22);
        goto L103
    L107:
        Iterator r23 = r20.iterator();
    L109:
        if (r23.hasNext() == false) goto L111;
        String r24 = (String) r23.next();
        r18.appendQueryParameter(r24, UriProtector.getQueryParameter(r17, r24));
        goto L109
    L111:
        if (r18 == null) goto L113;
        Uri r25 = r18.build();
    L114:
        String r26 = String.valueOf(r25);
        IBrowserService r27 = (IBrowserService) ServiceManager.get().getService(IBrowserService.class);
        if (r27 == null) goto L132;
        Bundle r28 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", r26)});
        Set r29 = UriProtector.getQueryParameterNames(r17);
        ArrayList r30 = new ArrayList();
        Iterator r31 = r29.iterator();
    L118:
        if (r31.hasNext() == false) goto L122;
        Object r32 = r31.next();
        if ((!Intrinsics.areEqual((String) r32, LynxEventReporter.PROP_NAME_URL)) == false) goto L118;
        r30.add(r32);
        goto L118
    L122:
        Iterator r110 = r30.iterator();
    L124:
        if (r110.hasNext() == false) goto L126;
        String r33 = (String) r110.next();
        r28.putString(r33, UriProtector.getQueryParameter(r17, r33));
        goto L124
    L126:
        Unit r111 = Unit.INSTANCE;
        r27.e(r16, r28, null);
        goto L132
    L113:
        r25 = null;
        goto L114
    L97:
        r11 = null;
    L127:
        qg9.a.b(r14, r17);
        return true;
    L92:
        r10 = null;
        goto L94
    L49:
        if (r8.equals("webview_native_nav") == true) goto L84;
    L52:
        if (r8.equals("lynx_page") == false) goto L129;
    L73:
        w1.a(r8, r15.toString(), "RouterBridgeDependInjectImpl", Boolean.valueOf(z2.a.h0()));
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r15, "is_life_poi"), "1") == false) goto L80;
        ILocalLifeService r112 = (ILocalLifeService) ServiceManager.get().getService(ILocalLifeService.class);
        if (r112 == null) goto L132;
        if (r14 != null) goto L79;
        r14 = AppHost.a.getApplication().getApplicationContext();
    L79:
        Intrinsics.checkNotNull(r14);
        r112.handleSchema(r14, r15);
        goto L132
    L80:
        qg9.a.e(r14, r15);
        goto L132
    L55:
        if (r8.equals("flow") == false) goto L129;
        IDeeplinkService r113 = (IDeeplinkService) ServiceManager.get().getService(IDeeplinkService.class);
        if (r113 == null) goto L132;
        Intrinsics.checkNotNull(r15);
        r113.i(r14, r15);
        goto L132
    L61:
        if (r8.equals("privacy_info") == false) goto L129;
    L69:
        SmartRouter.buildRoute(AppHost.a.getApplication().getApplicationContext(), r12).d();
        goto L132
    L64:
        if (r8.equals("lynxview_popup") == true) goto L73;
    L67:
        if (r8.equals("applet") == true) goto L69;
    L71:
        if (r8.equals(ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW) == true) goto L73;
    L82:
        if (r8.equals("webview_popup") == true) goto L84;
    L24:
        if ((r14 instanceof Activity) == false) goto L26;
        Activity r34 = (Activity) r14;
    L27:
        if (r34 == null) goto L39;
        Intent r35 = new Intent();
        r35.setAction("android.intent.action.VIEW");
        r35.setData(r15);
        r35.addCategory("android.intent.category.DEFAULT");
        r35.addCategory("android.intent.category.BROWSABLE");
        if (r35.resolveActivity(((Activity) r14).getPackageManager()) == null) goto L38;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L32
        r34.startActivity(r35);     // Catch: Throwable -> L32
        return true;
    L32:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r39 = Result.exceptionOrNull-impl(r38);
        if (r39 != null) goto L36;
        Result.box-impl(r38);
        goto L39
    L36:
        throw r39;
    L38:
        throw new Throwable("no app can handle this intent " + r15);
    L26:
        r34 = null;
        goto L27
    }
}
