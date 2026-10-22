package com.bytedance.ai.applet.moa;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.ViewGroup;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.debug.IAISDKDebugService$DebugMode;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.WidgetInfo;
import com.bytedance.ai.widget.WidgetManager;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaLoginPanelPresenter$show$2", f = "MoaLoginPanelPresenter.kt", i = {0, 0, 0}, l = {51}, m = "invokeSuspend", n = {com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY, "drawer", "widgetManager"}, s = {"L$0", "L$1", "L$2"})
public final class MoaLoginPanelPresenter$show$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ o $context;
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ u2.j $relatedData;
    final /* synthetic */ MoaLoginPanelType $type;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MoaLoginPanelPresenter this$0;

    public MoaLoginPanelPresenter$show$2(MoaLoginPanelPresenter r1, o r10, u2.j r11, MoaLoginPanelType r12, Function0<Unit> r13, Continuation<? super MoaLoginPanelPresenter$show$2> r14) {
        this.this$0 = r1;
        this.$context = r10;
        this.$relatedData = r11;
        this.$type = r12;
        this.$onDismiss = r13;
        super(2, r14);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MoaLoginPanelPresenter$show$2(this.this$0, this.$context, this.$relatedData, this.$type, this.$onDismiss, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<Unit>> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12, types: [com.bytedance.ai.widget.WidgetManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24, types: [l2.a] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v28, types: [l2.a] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r5v13, types: [com.bytedance.ai.applet.login.f] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    public final Object invokeSuspend(Object r46) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L14;
        if (r10 != 1) goto L13;
        ?? r11 = (l2.a) this.L$2;
        com.bytedance.ai.applet.login.f r12 = (com.bytedance.ai.applet.login.f) this.L$1;
        Activity r13 = (Activity) this.L$0;
        ResultKt.throwOnFailure(r46);     // Catch: Exception -> L8 CancellationException -> L10
        Object r1 = r46;
        MoaLoginPanelPresenter$show$2 r14 = this;
        String r41 = "Failed to build MOA login widget";
        r11 = r11;
        r12 = r12;
    L118:
        com.bytedance.ai.widget.contianer.h r15 = (com.bytedance.ai.widget.contianer.h) r1;     // Catch: Exception -> L120 CancellationException -> L122
        String r16 = r41;
        ?? r17 = r11;
        ?? r18 = r12;
    L129:
        if (r15 != null) goto L132;
        r18.e();
        Result.Companion r19 = Result.Companion;
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r16))));
    L132:
        r14.this$0.b();
        r14.this$0.a = r18;
        r18.a(r17, r15);
        r18.b(r13);
        r18.d(r14.$onDismiss);
        Result.Companion r20 = Result.Companion;
        return Result.box-impl(Result.constructor-impl(Unit.INSTANCE));
    L120:
        e = e;
    L128:
        r16 = r41;
        com.bytedance.ai.utils.g.a.e("MoaLoginPanelPresenter", r16, e);
        r15 = null;
        r17 = r11;
        r18 = r12;
    L122:
        e = move-exception;
        throw e;
    L10:
        e = move-exception;
        throw e;
    L8:
        e = e;
        r14 = this;
        r41 = "Failed to build MOA login widget";
        goto L128
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r46);
        MoaLoginPanelPresenter r21 = this.this$0;
        WeakReference<Context> r22 = this.$context.d;
        if (r22 == null) goto L17;
        Context r23 = r22.get();
    L18:
        int r24 = MoaLoginPanelPresenter.b;
        r21.getClass();
    L20:
        if ((r23 instanceof ContextWrapper) == false) goto L26;
        if ((r23 instanceof Activity) == true) goto L23;
        r23 = ((ContextWrapper) r23).getBaseContext();
        goto L20
    L23:
        Activity r25 = (Activity) r23;
    L29:
        if (r25 != null) goto L38;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r26 = AppletRuntimeManager.d;
        if (r26 == null) goto L33;
        Activity r27 = r26.currentActivity();
    L34:
        if (r27 != null) goto L37;
        Result.Companion r28 = Result.Companion;
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("Current activity is unavailable"))));
    L37:
        r25 = r27;
        goto L38
    L33:
        r27 = null;
    L38:
        com.bytedance.ai.applet.login.f r29 = new com.bytedance.ai.applet.login.f(r25);
        ViewGroup r110 = r29.c;
        if (r110 != null) goto L42;
        Result.Companion r30 = Result.Companion;
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("Login drawer content is unavailable"))));
    L42:
        MoaLoginPanelPresenter r31 = this.this$0;
        o r32 = this.$context;
        u2.j r33 = this.$relatedData;
        MoaLoginPanelType r111 = this.$type;
        r31.getClass();
        u2.e r34 = r32.a;
        String r112 = r34.d();
        if (r112 != null) goto L45;
        String r210 = "";
    L46:
        String r113 = r32.b.b;
        int r114 = MoaLoginPanelPresenter.b.a[r111.ordinal()];
        r41 = "Failed to build MOA login widget";
        Activity r44 = r25;
        if (r114 != 1) goto L49;
        u2.e r211 = r34;
        String r35 = r211.e();
        if (r35 != null) goto L83;
        r35 = "";
    L83:
        String r115 = r211.c();
        if (r115 != null) goto L86;
        r115 = "";
    L86:
        String r36 = r33.d();
        Pair[] r116 = new Pair[5];
        r116[0] = TuplesKt.to("type", "agreePrivacyAuthorization");
        r116[1] = TuplesKt.to("currentPage", "chat");
        r116[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.VALUE_BRAND, MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, r35), TuplesKt.to("logo", r115)}));
        Pair[] r37 = new Pair[2];
        com.bytedance.ai.utils.l r38 = com.bytedance.ai.utils.l.a;
        String r39 = com.bytedance.ai.utils.l.e(r38, "larus_appEntry_chatCard_title_agreePolicy");
        if (r39 != null) goto L89;
        r39 = "隐私协议提示";
    L89:
        r37[0] = TuplesKt.to("title", r39);
        if (r36 != null) goto L92;
        r36 = "感谢您使用" + r35 + "，当您点击同意开始使用本产品服务时，即表示您理解并同意";
    L92:
        r37[1] = TuplesKt.to("description", r36);
        r116[3] = TuplesKt.to("content", MapsKt.mapOf(r37));
        Pair[] r40 = new Pair[2];
        String r42 = com.bytedance.ai.utils.l.e(r38, "larus_appEntry_chatCard_title_btn_agree");
        if (r42 != null) goto L95;
        r42 = "同意并继续";
    L95:
        r40[0] = TuplesKt.to("primary", MapsKt.mapOf(TuplesKt.to("text", r42)));
        String r43 = com.bytedance.ai.utils.l.e(r38, "larus_appEntry_chatCard_title_btn_notNow");
        if (r43 != null) goto L98;
        r43 = "暂不同意";
    L98:
        r40[1] = TuplesKt.to("secondary", MapsKt.mapOf(TuplesKt.to("text", r43)));
        r116[4] = TuplesKt.to("buttons", MapsKt.mapOf(r40));
        Map r45 = MapsKt.mapOf(r116);
    L100:
        if (IAISDKDebugService.a.getDebugMode() != IAISDKDebugService$DebugMode.SCAN_PREVIEW) goto L102;
        String r310 = r211.g();
    L103:
        h5.k r47 = new h5.k(r113, r32.c, null, null, null, new WidgetInfo(r210, "mcp-privacy-login-card", com.bytedance.ai.applet.base.gson.e.c(r45), null, null, null, null, null, null, null, "1", null, null, r310, 7160, null), r110, MoaLoginPanelPresenter.c.a, 0, null, null, false, null, null, 61440);
        r11 = WidgetManager.h.b();
        if (r11 != 0) goto L107;
        Result.Companion r48 = Result.Companion;
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("Widget manager is unavailable"))));
    L107:
        r14 = this;
        String r49 = r14.$context.a.d();     // Catch: CancellationException -> L122 Exception -> L126
        if (r49 != null) goto L112;
        r49 = "";
    L112:
        r13 = r44;
        r14.L$0 = r13;     // Catch: CancellationException -> L122 Exception -> L124
        r12 = r29;
        r14.L$1 = r12;     // Catch: Exception -> L120 CancellationException -> L122
        r14.L$2 = r11;     // Catch: Exception -> L120 CancellationException -> L122
        r14.label = 1;     // Catch: Exception -> L120 CancellationException -> L122
        r1 = r11.i(r47, r49, "mcp-privacy-login-card", r14);     // Catch: Exception -> L120 CancellationException -> L122
        r11 = r11;
        r12 = r12;
        if (r1 != r0) goto L118;
        return r0;
    L124:
        e = e;
        r12 = r29;
    L126:
        e = e;
        r12 = r29;
        r13 = r44;
        goto L128
    L102:
        r310 = null;
        goto L103
    L49:
        if (r114 != 2) goto L79;
        String r117 = r34.e();
        if (r117 != null) goto L53;
        r117 = "";
    L53:
        String r118 = r34.c();
        r211 = r34;
        if (r118 != null) goto L56;
        r118 = "";
    L56:
        Pair[] r50 = new Pair[7];
        r50[0] = TuplesKt.to("type", "getPhoneNumber");
        r50[1] = TuplesKt.to("currentPage", "chat");
        r50[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.VALUE_BRAND, MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, r117), TuplesKt.to("logo", r118)}));
        Pair[] r51 = new Pair[2];
        com.bytedance.ai.utils.l r52 = com.bytedance.ai.utils.l.a;
        String r53 = com.bytedance.ai.utils.l.e(r52, "larus_appEntry_bottomSheet_Title_phoneNo_cn");
        if (r53 != null) goto L59;
        r53 = "申请获取并验证你的手机号";
    L59:
        r51[0] = TuplesKt.to("title", r53);
        String r54 = r33.b();
        if (r54 != null) goto L62;
        r54 = "用于登录或注册" + r117 + "账户";
    L62:
        r51[1] = TuplesKt.to("description", r54);
        r50[3] = TuplesKt.to("content", MapsKt.mapOf(r51));
        Pair[] r55 = new Pair[3];
        Pair[] r56 = new Pair[3];
        String r57 = r33.c();
        if (r57 != null) goto L65;
        r57 = "";
    L65:
        r56[0] = TuplesKt.to("text", r57);
        r56[1] = TuplesKt.to("loadingText", "登录中...");
        String r58 = com.bytedance.ai.utils.l.e(r52, "larus_appEntry_bottomSheet_optionDesc_linkedNo_cn");
        if (r58 != null) goto L68;
        r58 = "豆包绑定号码";
    L68:
        r56[2] = TuplesKt.to("subtext", r58);
        r55[0] = TuplesKt.to("primary", MapsKt.mapOf(r56));
        String r59 = com.bytedance.ai.utils.l.e(r52, "larus_appEntry_bottomSheet_option_more");
        if (r59 != null) goto L71;
        r59 = "其他登录方式";
    L71:
        r55[1] = TuplesKt.to("other", MapsKt.mapOf(TuplesKt.to("text", r59)));
        String r60 = com.bytedance.ai.utils.l.e(r52, "larus_appEntry_bottomSheet_option_notNow");
        if (r60 != null) goto L74;
        r60 = "暂不登录";
    L74:
        r55[2] = TuplesKt.to("secondary", MapsKt.mapOf(TuplesKt.to("text", r60)));
        r50[4] = TuplesKt.to("buttons", MapsKt.mapOf(r55));
        r50[5] = TuplesKt.to("agreement", MapsKt.mapOf(TuplesKt.to("text", CollectionsKt.listOf(new Map[]{MapsKt.mapOf(TuplesKt.to("text", "已阅读并同意" + r117 + 30340)), MapsKt.mapOf(new Pair[]{TuplesKt.to("text", "服务协议"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, MoaLoginPanelPresenter.a(r33.f()))}), MapsKt.mapOf(TuplesKt.to("text", "和")), MapsKt.mapOf(new Pair[]{TuplesKt.to("text", "隐私政策"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, MoaLoginPanelPresenter.a(r33.e()))})}))));
        String r61 = com.bytedance.ai.utils.l.e(r52, "larus_appEntry_toast_agreeTerms");
        if (r61 != null) goto L77;
        r61 = "需同意相关服务协议和隐私政策";
    L77:
        r50[6] = TuplesKt.to("warningToast", r61);
        r45 = MapsKt.mapOf(r50);
        goto L100
    L79:
        throw new NoWhenBranchMatchedException();
    L45:
        r210 = r112;
        goto L46
    L26:
        if ((r23 instanceof Activity) == false) goto L28;
        r25 = (Activity) r23;
        goto L29
    L28:
        r25 = null;
        goto L29
    L17:
        r23 = null;
        goto L18
    }
}
