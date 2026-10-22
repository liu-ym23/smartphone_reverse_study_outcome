package com.bytedance.ai.debugscene;

import com.byted.cast.sink.api.CastInfo;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.debugscene.AppletDebugTool$startApplet$1", f = "AppletDebugTool.kt", i = {1}, l = {271, 294}, m = "invokeSuspend", n = {"pageInfo"}, s = {"L$0"})
public final class AppletDebugTool$startApplet$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.BooleanRef $alignLeft;
    final /* synthetic */ String $appletName;
    final /* synthetic */ String $pageData;
    final /* synthetic */ String $pageName;
    final /* synthetic */ JavaOnlyMap $pageSettings;
    final /* synthetic */ PageType $pageType;
    final /* synthetic */ String $pageUrl;
    final /* synthetic */ boolean $pageUrlOnly;
    final /* synthetic */ Ref.DoubleRef $pos;
    final /* synthetic */ String $traceId;
    final /* synthetic */ Map<String, Object> $traceInfo;
    Object L$0;
    int label;
    final /* synthetic */ AppletDebugTool this$0;

    public AppletDebugTool$startApplet$1(String r1, String r10, String r11, boolean r12, String r13, PageType r14, JavaOnlyMap r15, Ref.DoubleRef r16, Ref.BooleanRef r17, Map<String, Object> r18, AppletDebugTool r19, String r110, Continuation<? super AppletDebugTool$startApplet$1> r111) {
        this.$appletName = r1;
        this.$pageName = r10;
        this.$pageData = r11;
        this.$pageUrlOnly = r12;
        this.$pageUrl = r13;
        this.$pageType = r14;
        this.$pageSettings = r15;
        this.$pos = r16;
        this.$alignLeft = r17;
        this.$traceInfo = r18;
        this.this$0 = r19;
        this.$traceId = r110;
        super(2, r111);
    }

    public final Continuation<Unit> create(Object r17, Continuation<?> r18) {
        return new AppletDebugTool$startApplet$1(this.$appletName, this.$pageName, this.$pageData, this.$pageUrlOnly, this.$pageUrl, this.$pageType, this.$pageSettings, this.$pos, this.$alignLeft, this.$traceInfo, this.this$0, this.$traceId, r18);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r27) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L10;
        if (r10 == 1) goto L9;
        if (r10 != 2) goto L8;
        PageInfo r11 = (PageInfo) this.L$0;
        ResultKt.throwOnFailure(r27);
        Object r12 = r27;
        final PageInfo r13 = r11;
    L59:
        if (((Applet) r12) == null) goto L63;
        r4.h r14 = r4.a.l;
        if (r14 == null) goto L65;
        Map<String, String> r15 = MapsKt.emptyMap();
        final AppletDebugTool r16 = this.this$0;
        final String r17 = this.$appletName;
        final String r18 = this.$traceId;
        final Map<String, Object> r19 = this.$traceInfo;
        r14.g(r15, new v1(r16, r17, r13, r18, r19));
    L65:
        return Unit.INSTANCE;
    L63:
        AIDebugManager r110 = AIDebugManager.a;
        final String r111 = this.$appletName;
        final AppletDebugTool r20 = this.this$0;
        final String r21 = this.$traceId;
        final Map<String, Object> r22 = this.$traceInfo;
        AIDebugManager.l(r110, r111, false, null, false, new w1(r20, r111, r13, r21, r22), null, CastInfo.TYPE_CAST_SUCCESS);
        goto L65
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r27);
        Object r23 = r27;
    L13:
        final AppletApplication r24 = (AppletApplication) r23;
        if (r24 == null) goto L20;
        r4.h r25 = r4.a.l;
        if (r25 == null) goto L19;
        Map<String, String> r26 = MapsKt.emptyMap();
        final String r28 = this.$pageUrl;
        r25.g(r26, new u1(r24, r28));
    L19:
        return Unit.INSTANCE;
    L20:
        String r29 = this.$pageName;
        String r30 = this.$pageData;
        JavaOnlyMap r31 = new JavaOnlyMap();
        Map<String, Object> r210 = null;
        if (this.$pageUrlOnly == false) goto L23;
        String r32 = this.$pageUrl;
    L24:
        PageInfo r33 = new PageInfo(r29, r30, r31, r32, this.$pageType, "", null, this.$pageSettings, "", this.$pos.element, this.$alignLeft.element, null, this.$traceInfo, this.$appletName, null, null, 51264, null);
        AIManager r34 = AIManager.a;
        String r35 = this.$appletName;
        AIDebugManager.a.getClass();
        Intrinsics.checkNotNullParameter(r35, "appKey");
        if (StringsKt.isBlank(r35) == true) goto L39;
        AIDebugManager.q();
        AIDebugManager.a r36 = AIDebugManager.m.get(r35);
        if (r36 != null) goto L30;
    L37:
        JSONObject r37 = AIDebugManager.l;
        if (r37 == null) goto L39;
        String r38 = r37.optString("app_key");
        Intrinsics.checkNotNull(r38);
        int r39 = 1;
        if ((!StringsKt.isBlank(r38)) == true) goto L46;
        r38 = null;
    L46:
        if (Intrinsics.areEqual(r38, r35) == false) goto L51;
        String r40 = r37.optString("version_tag");
        Intrinsics.checkNotNull(r40);
        if ((!StringsKt.isBlank(r40)) == false) goto L51;
    L52:
        if (r40 == null) goto L54;
        Pair[] r41 = new Pair[r39];
        r41[0] = TuplesKt.to("version_tag", r40);
        r210 = MapsKt.mutableMapOf(r41);
    L54:
        this.L$0 = r33;
        this.label = 2;
        r12 = r34.C(r35, r210, this);
        if (r12 != r1) goto L57;
        return r1;
    L57:
        r13 = r33;
    L51:
        r40 = null;
        goto L52
    L30:
        if (r36.b == true) goto L33;
        r36 = null;
    L33:
        if (r36 == null) goto L37;
        r40 = r36.c;
        if (r40 == null) goto L37;
    L40:
        r39 = 1;
    L39:
        r40 = null;
        goto L40
    L23:
        r32 = null;
        goto L24
    L10:
        ResultKt.throwOnFailure(r27);
        AppletAppManagerService r42 = AppletAppManagerService.INSTANCE;
        String r43 = this.$appletName;
        this.label = 1;
        r23 = r42.d(r43, this);
        if (r23 != r1) goto L13;
        return r1;
    }
}
