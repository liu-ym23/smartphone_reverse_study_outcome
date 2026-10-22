package com.bytedance.ai.lite.view;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.ai.bridge.utils.ConvertUtils;
import com.bytedance.ai.lynx.AppletLynxViewApi;
import com.bytedance.ai.lynx.g;
import com.bytedance.ai.lynx.r;
import com.bytedance.ai.resource.AppletResourceTool;
import com.bytedance.applet.impl.e2;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.ThreadStrategyForRendering;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends com.bytedance.ai.lite.view.b {
    public static final /* synthetic */ int g = 0;
    public g a;
    public final String b;
    public e5.a c;
    public JavaOnlyMap d;
    public boolean e;
    public final b f;

    /* JADX INFO: renamed from: com.bytedance.ai.lite.view.a$a, reason: collision with other inner class name */
    public static final class C0041a {
    }

    public static final class b implements r {
        public final /* synthetic */ a a;

        @Override // com.bytedance.ai.lynx.r
        public final void onDetachedFromWindow(g r1) {
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onPageUpdate(g r1) {
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onTimingUpdate(g r1, Map<String, Object> r10, Map<String, Long> r11, String r12) {
        }

        public b(a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onFirstScreen(g r10) {
            a r11 = this.a;
            JavaOnlyMap r0 = r11.d;
            if (r0 == null) goto L8;
            g r12 = r11.a;
            if (r12 == null) goto L9;
            r12.updateData(r0);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onRuntimeReady(g r1) {
            e5.a r10 = this.a.c;
            if (r10 == null) goto L6;
            r10.onRuntimeReady();
            return;
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onLoadUriSuccess(Uri r1, g r10) {
            a r11 = this.a;
            r11.e = true;
            e5.a r12 = r11.c;
            if (r12 == null) goto L6;
            r12.onLoadSuccess();
            return;
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onPageStart(g r1, String r10) {
            e5.a r11 = this.a.c;
            if (r11 == null) goto L6;
            r11.onLoadStart();
            return;
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onReceivedError(g r10, LynxError r11) {
            if (r11 == null) goto L6;
            boolean r0 = true;
            if (r11.isFatal() != true) goto L6;
        L7:
            if (r0 == false) goto L12;
            e5.a r12 = this.a.c;
            if (r12 == null) goto L13;
            r12.b(new Throwable(r11.toString()));
            return;
        L13:
            return;
        L12:
            return;
        L6:
            r0 = false;
            goto L7
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onTimingSetup(g r1, Map<String, Object> r10) {
            e5.a r11 = this.a.c;
            if (r11 == null) goto L6;
            r11.a();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ai.lite.view.b
    public final void a() {
        com.bytedance.ai.utils.g.a.i("LiteLynxView", "destroy " + this);
        AppletResourceTool r0 = AppletResourceTool.a;
        String r1 = this.b;
        r0.getClass();
        AppletResourceTool.a(r1);
        g r10 = this.a;
        if (r10 == null) goto L6;
        r10.destroy();
        return;
    }

    public a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        this.b = AppletResourceTool.s(AppletResourceTool.a);
        this.f = new b(this);
    }

    @Override // com.bytedance.ai.lite.view.b
    public final void b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "renderData");
        com.bytedance.ai.utils.g.a.i("LiteLynxView", "updateData " + this + ' ' + this.a + " loadSuccess=" + this.e + ' ' + r10);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.constructor-impl(ConvertUtils.INSTANCE.convertJSONObject2JavaOnlyMap(new JSONObject(r10)));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r11) == false) goto L10;
        r11 = null;
    L10:
        JavaOnlyMap r12 = (JavaOnlyMap) r11;
        if (this.e == true) goto L14;
        this.d = r12;
        return;
    L14:
        g r1 = this.a;
        if (r1 == null) goto L20;
        r1.updateData(r12);
        return;
    L20:
        return;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v13, types: [android.view.View, com.bytedance.ai.lynx.g] */
    public final void c(String r23, e2 r24, String r25) {
        Intrinsics.checkNotNullParameter(r23, "templateUrl");
        com.bytedance.ai.utils.g r10 = com.bytedance.ai.utils.g.a;
        r10.i("LiteLynxView", "loadTemplate " + this + ' ' + r23);
        if (r23.length() != 0) goto L5;
        boolean r11 = true;
    L7:
        if (r11 == false) goto L10;
        Intrinsics.checkNotNullParameter(new Throwable("empty templateUrl"), "e");
        return;
    L10:
        this.c = r24;
        Uri r12 = UriProtector.parse(r23);
        int r13 = c.a;
        Intrinsics.checkNotNull(r12);
        Intrinsics.checkNotNullParameter(r12, "uri");
        boolean r14 = r12.getBooleanQueryParameter("enable_canvas", false);
        boolean r15 = r12.getBooleanQueryParameter("enable_code_cache", false);
        boolean r16 = r12.getBooleanQueryParameter("enable_dynamic_v8", false);
        String r17 = UriProtector.getQueryParameter(r12, "group");
        String r18 = "";
        if (r17 != null) goto L13;
        r17 = "";
    L13:
        LynxGroup.a r19 = new LynxGroup.a();
        r19.d = r14;
        r19.a = r17;
        r19.e = r16;
        String r20 = UriProtector.getQueryParameter(r12, "lynx_preset_height");
        String r110 = UriProtector.getQueryParameter(r12, "lynx_preset_width");
        if (r110 != null) goto L19;
        if (r20 != null) goto L19;
        int r21 = 0;
        int r111 = 0;
    L25:
        String r112 = UriProtector.getQueryParameter(r12, "preset_safe_point");
        if (r112 == null) goto L33;
        Integer r113 = StringsKt.toIntOrNull(r112);
        if (r113 == null) goto L33;
        if (r113.intValue() != 1) goto L33;
        boolean r114 = true;
    L34:
        String r115 = UriProtector.getQueryParameter(r12, "thread_strategy");
        if (r115 == null) goto L37;
        Integer r116 = Integer.valueOf(CastIntegerProtector.parseInt(r115));
    L38:
        ThreadStrategyForRendering r117 = ThreadStrategyForRendering.ALL_ON_UI;
        int r22 = r117.id();
        if (r116 != null) goto L42;
    L44:
        ThreadStrategyForRendering r26 = ThreadStrategyForRendering.MOST_ON_TASM;
        int r118 = r26.id();
        if (r116 != null) goto L48;
    L50:
        ThreadStrategyForRendering r27 = ThreadStrategyForRendering.PART_ON_LAYOUT;
        int r28 = r27.id();
        if (r116 != null) goto L54;
    L56:
        r27 = ThreadStrategyForRendering.MULTI_THREADS;
        int r29 = r27.id();
        if (r116 != null) goto L60;
    L62:
        r26 = r117;
    L63:
        String r30 = UriProtector.getQueryParameter(r12, "air_strict_mode");
        if (r30 == null) goto L71;
        Integer r31 = StringsKt.toIntOrNull(r30);
        if (r31 == null) goto L71;
        if (r31.intValue() != 1) goto L71;
        boolean r32 = true;
    L72:
        LynxViewBuilder r119 = LynxView.builder();
        r119.setLynxGroup(LynxGroup.Create(r19));
        r119.setEnableUserCodeCache(r15);
        r119.setPresetMeasuredSpec(r111, r21);
        r119.setEnableLayoutSafepoint(r114);
        r119.setThreadStrategyForRendering(r26);
        r119.setEnableAirStrictMode(r32);
        int r33 = AppletLynxViewApi.a;
        Context r120 = getContext();
        h2.a r34 = f2.b.c;
        if (r34 == null) goto L76;
        String r35 = r34.m;
        if (r35 == null) goto L76;
    L77:
        ?? r36 = AppletLynxViewApi.a(r120, r35, this.b, null, r119, null, null, 96);
        this.a = r36;
        addView(r36);
        String r37 = UriProtector.getQueryParameter(r12, "surl");
        if (r37 == null) goto L81;
        r18 = r37;
    L81:
        Uri r38 = UriProtector.parse(r18);
        int r39 = g5.a.a;
        if (g5.a.a(r38.getHost()) == true) goto L85;
        r10.e("LiteLynxView", "loadTemplate host=" + r12.getHost() + " is not acceptable");
        Intrinsics.checkNotNullParameter(new Throwable("host not acceptable"), "e");
        return;
    L85:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new LiteLynxView$loadTemplate$1(this, r23, r25, null), 3, null);
        return;
    L76:
        r35 = "";
    L71:
        r32 = false;
        goto L72
    L60:
        if (r116.intValue() != r29) goto L62;
    L55:
        r117 = r27;
        goto L62
    L54:
        if (r116.intValue() != r28) goto L56;
    L48:
        if (r116.intValue() != r118) goto L50;
    L42:
        if (r116.intValue() != r22) goto L44;
    L37:
        r116 = null;
    L33:
        r114 = false;
    L19:
        if (r110 == null) goto L21;
        r111 = View.MeasureSpec.makeMeasureSpec(CastIntegerProtector.parseInt(r110), 1073741824);
    L22:
        if (r20 == null) goto L24;
        r21 = View.MeasureSpec.makeMeasureSpec(CastIntegerProtector.parseInt(r20), 1073741824);
        goto L25
    L24:
        r21 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L25
    L21:
        r111 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L22
    L5:
        r11 = false;
        goto L7
    }
}
