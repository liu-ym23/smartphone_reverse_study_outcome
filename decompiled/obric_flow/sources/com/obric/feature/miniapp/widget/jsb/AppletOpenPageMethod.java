package com.obric.feature.miniapp.widget.jsb;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.method.net.e;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.bytedance.ai.ex.widget.WidgetRenderService;
import com.bytedance.ai.model.p;
import com.bytedance.ai.resource.core.db.b;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.feature.miniapp.widget.MiniAppHostView;
import com.obric.feature.miniapp.widget.MiniAppWidgetManagerWrapper;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import k5.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import m1.j;
import n1.c;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ-\u0010\"\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016¢\u0006\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/obric/feature/miniapp/widget/jsb/AppletOpenPageMethod;", "Lcom/obric/feature/miniapp/widget/jsb/AbsAppletOpenPageMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Landroid/os/Bundle;", "args", "", "appletId", "pageId", "", "openPage", "(Ln1/c;Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Z", "Lcom/obric/feature/miniapp/widget/MiniAppHostView;", "resolveHostView", "(Ln1/c;)Lcom/obric/feature/miniapp/widget/MiniAppHostView;", "Landroid/content/Context;", "resolveNavigationContext", "(Ln1/c;)Landroid/content/Context;", "", "", "normalizeConversationContext", "(Ljava/util/Map;)V", "Lcom/google/gson/JsonObject;", "source", "", "jsonObjectToStringMap", "(Lcom/google/gson/JsonObject;)Ljava/util/Map;", "Lcom/obric/feature/miniapp/widget/jsb/AbsAppletOpenPageMethodIDL$OpenPageParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/obric/feature/miniapp/widget/jsb/AbsAppletOpenPageMethodIDL$OpenPageResultModel;", "callback", "handle", "(Ln1/c;Lcom/obric/feature/miniapp/widget/jsb/AbsAppletOpenPageMethodIDL$OpenPageParamModel;Lo1/f;)V", "Companion", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppletOpenPageMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppletOpenPageMethod.kt\ncom/obric/feature/miniapp/widget/jsb/AppletOpenPageMethod\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,224:1\n1#2:225\n216#3,2:226\n1863#4,2:228\n*S KotlinDebug\n*F\n+ 1 AppletOpenPageMethod.kt\ncom/obric/feature/miniapp/widget/jsb/AppletOpenPageMethod\n*L\n101#1:226,2\n209#1:228,2\n*E\n"})
public final class AppletOpenPageMethod extends AbsAppletOpenPageMethodIDL {
    public static final Companion Companion = null;
    private static final String TAG = "OMiniApp-AppletOpenPage";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/feature/miniapp/widget/jsb/AppletOpenPageMethod$Companion;", "", "<init>", "()V", "TAG", "", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.feature.miniapp.widget.jsb.AppletOpenPageMethod$openPage$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.feature.miniapp.widget.jsb.AppletOpenPageMethod$openPage$2", f = "AppletOpenPageMethod.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Bundle $args;
        final /* synthetic */ Context $navigationContext;
        int label;

        public AnonymousClass2(Context r5, Bundle r10, Continuation<? super AnonymousClass2> r11) {
            this.$navigationContext = r5;
            this.$args = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            return new AnonymousClass2(this.$navigationContext, this.$args, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Boolean> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L9;
            if (r11 != 1) goto L8;
            ResultKt.throwOnFailure(r5);
            return r5;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
            MiniAppWidgetManagerWrapper r12 = MiniAppWidgetManagerWrapper.INSTANCE;
            Context r13 = this.$navigationContext;
            Bundle r14 = this.$args;
            this.label = 1;
            Object r15 = r12.openMiniApp(r13, r14, this);
            if (r15 != r10) goto L12;
            return r10;
        L12:
            return r15;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Boolean> r10) {
            return ((AnonymousClass2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AppletOpenPageMethod() {
    }

    public static /* synthetic */ Unit b(Ref.BooleanRef r5) {
        return openPage$lambda$15$lambda$13(r5);
    }

    public static /* synthetic */ Unit c(Ref.ObjectRef r5, String r10) {
        return openPage$lambda$15$lambda$14(r5, r10);
    }

    private final Map<String, String> jsonObjectToStringMap(JsonObject r5) {
        if (r5 == null) goto L4;
        Map r10 = MapsKt.createMapBuilder();
        Iterator<T> r11 = r5.entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L18;
        Map.Entry r12 = (Map.Entry) r11.next();
        Intrinsics.checkNotNull(r12);
        String r13 = (String) r12.getKey();
        JsonElement r14 = (JsonElement) r12.getValue();
        if (r14.isJsonNull() == true) goto L7;
        Intrinsics.checkNotNull(r13);
        if (r14.isJsonPrimitive() == true) goto L13;
    L15:
        String r15 = r14.toString();
    L16:
        Intrinsics.checkNotNull(r15);
        r10.put(r13, r15);
        goto L7
    L13:
        if (r14.getAsJsonPrimitive().isString() == false) goto L15;
        r15 = r14.getAsString();
        goto L16
    L18:
        return MapsKt.build(r10);
    L4:
        return MapsKt.emptyMap();
    }

    private final void normalizeConversationContext(Map<String, String> r5) {
        String r10 = p.h("SYSTEM_CVS_ID");
        if (StringsKt.isBlank(r10) == false) goto L6;
        r10 = null;
    L6:
        if (r10 != null) goto L8;
        r10 = "SYSTEM_CVS_ID";
    L8:
        String r11 = r5.get("conversationId");
        if (r11 != null) goto L11;
    L15:
        r5.put("conversationId", "SYSTEM_CVS_ID");
    L16:
        String r12 = r5.get("botId");
        if (r12 != null) goto L19;
    L25:
        r5.put("botId", r10);
        return;
    L19:
        if (StringsKt.isBlank(r12) == true) goto L25;
        if (Intrinsics.areEqual(r12, WidgetRenderService.COMPACT_BOT_ID) == true) goto L25;
        return;
    L11:
        if (StringsKt.isBlank(r11) == true) goto L15;
        if (Intrinsics.areEqual(r11, WidgetRenderService.COMPACT_CONVERSATION_ID) == false) goto L16;
        goto L15
    }

    private final boolean openPage(c r10, Bundle r11, String r12, String r13) {
        MiniAppHostView r5 = resolveHostView(r10);
        if (r5 == null) goto L9;
        Ref.BooleanRef r14 = new Ref.BooleanRef();
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        r5.openPage(r11, new b(r14, 2), new e(r15, 6));
        if (r14.element == true) goto L8;
        Object r16 = r15.element;
        StringBuilder r17 = androidx.constraintlayout.motion.widget.a.y("openPage hostView failed appletId=", r12, " pageId=", r13, ": ");
        r17.append(r16);
        Log.w(TAG, r17.toString());
    L8:
        return r14.element;
    L9:
        Context r18 = resolveNavigationContext(r10);
        if (r18 != null) goto L14;
        Log.w(TAG, "openPage missing navigation context appletId=" + r12 + " pageId=" + r13);
        return false;
    L14:
        return ((Boolean) BuildersKt.runBlocking$default(null, new AnonymousClass2(r18, r11, null), 1, null)).booleanValue();
    }

    private static final Unit openPage$lambda$15$lambda$13(Ref.BooleanRef r5) {
        Intrinsics.checkNotNullParameter(r5, "$hostSuccess");
        r5.element = true;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Unit openPage$lambda$15$lambda$14(Ref.ObjectRef r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "$hostFailure");
        Intrinsics.checkNotNullParameter(r10, ST.IMPLICIT_ARG_NAME);
        r5.element = r10;
        return Unit.INSTANCE;
    }

    private final MiniAppHostView resolveHostView(c r5) {
        View r10 = ((n1.a) r5).a();
        Object r11 = null;
        if (r10 == null) goto L13;
    L4:
        if (r10 == null) goto L13;
        if ((r10 instanceof MiniAppHostView) == true) goto L7;
        Object r12 = r10.getParent();
        if ((r12 instanceof View) == true) goto L10;
        r10 = null;
        goto L4
    L10:
        r10 = (View) r12;
        goto L4
    L7:
        r11 = r10;
    L13:
        return (MiniAppHostView) r11;
    }

    private final Context resolveNavigationContext(c r5) {
        Activity r10 = ((n1.a) r5).d();
        if (r10 == null) goto L5;
        return r10;
    L5:
        t0.b r11 = p.f2294c;
        if (r11 == null) goto L8;
        Activity r12 = r11.currentActivity();
    L9:
        if (r12 == null) goto L11;
        return r12;
    L11:
        IHostContextDepend r13 = d.f18600a;
        if (r13 != null) goto L14;
        return null;
    L14:
        return r13.getApplication();
    L8:
        r12 = null;
        goto L9
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsAppletOpenPageMethodIDL.OpenPageParamModel) r10, r11);
    }

    public void handle(c r13, AbsAppletOpenPageMethodIDL.OpenPageParamModel r14, f r15) {
        Intrinsics.checkNotNullParameter(r13, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r15, "callback");
        JsonElement r5 = r14.getContext().get("appletId");
        JsonObject r10 = null;
        if (r5 != null) goto L5;
    L11:
        j r11 = (j) ((n1.a) r13).b(j.class);
        if (r11 == null) goto L14;
        String r12 = r11.b();
    L15:
        if (r12 != null) goto L17;
    L57:
        r15.a("openPage missing appletId");
        return;
    L17:
        if (StringsKt.isBlank(r12) == true) goto L57;
        Map<String, String> r16 = MapsKt.toMutableMap(jsonObjectToStringMap(r14.getContext()));
        normalizeConversationContext(r16);
        Bundle r17 = new Bundle();
        r17.putString("appletId", r12);
        r17.putString("pageId", r14.getPageId());
        r17.putString("pageId", r14.getPageId());
        String r18 = r14.getMode();
        if (r18 != null) goto L23;
        r18 = "";
    L23:
        if (StringsKt.isBlank(r18) == false) goto L25;
        r18 = OpenPageMethod.APP_FULL;
    L25:
        r17.putString("pageType", r18);
        JsonObject r19 = new JsonObject();
        Iterator<Map.Entry<String, String>> r20 = r16.entrySet().iterator();
    L27:
        if (r20.hasNext() == false) goto L29;
        Map.Entry<String, String> r110 = r20.next();
        r19.addProperty(r110.getKey(), r110.getValue());
        goto L27
    L29:
        Unit r21 = Unit.INSTANCE;
        r17.putString("context", r19.toString());
        String r22 = r14.getPageData();
        if (r22 != null) goto L32;
    L37:
        JsonObject r23 = r14.getPageSettings();
        if (r23 != null) goto L40;
    L59:
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L47
        if (openPage(r13, r17, r12, r14.getPageId()) == true) goto L49;
        Log.w(TAG, "openPage failed appletId=" + r12 + " pageId=" + r14.getPageId() + " context=" + r16);     // Catch: Throwable -> L47
        r15.a("openPage failed");     // Catch: Throwable -> L47
    L50:
        Object r111 = Result.m124constructorimpl(r21);     // Catch: Throwable -> L47
    L53:
        Throwable r112 = Result.m127exceptionOrNullimpl(r111);
        if (r112 == null) goto L62;
        StringBuilder r113 = androidx.constraintlayout.motion.widget.a.y("openPage exception appletId=", r12, " pageId=", r14.getPageId(), " context=");
        r113.append(r16);
        Log.e(TAG, r113.toString(), r112);
        r15.a("openPage failed: " + r112.getMessage());
        return;
    L62:
        return;
    L49:
        Log.i(TAG, "openPage success appletId=" + r12 + " pageId=" + r14.getPageId() + " context=" + r16);     // Catch: Throwable -> L47
        Intrinsics.checkNotNullParameter(AbsAppletOpenPageMethodIDL.OpenPageResultModel.class, "<this>");     // Catch: Throwable -> L47
        BaseModel r114 = com.lynx.tasm.behavior.ui.utils.e.c(AbsAppletOpenPageMethodIDL.OpenPageResultModel.class);     // Catch: Throwable -> L47
        ((AbsAppletOpenPageMethodIDL.OpenPageResultModel) r114).setViewId(UUID.randomUUID().toString());     // Catch: Throwable -> L47
        r15.b((ResultModel) r114, "");     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r111 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L53
    L40:
        if (r23.isJsonNull() == true) goto L42;
        r10 = r23;
    L42:
        if (r10 == null) goto L59;
        r17.putString("pageSettings", r10.toString());
        goto L59
    L32:
        if (StringsKt.isBlank(r22) == false) goto L35;
        r22 = null;
    L35:
        if (r22 == null) goto L37;
        r17.putString("pageData", r22);
        goto L37
    L14:
        r12 = null;
        goto L15
    L5:
        if (r5.isJsonNull() == false) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L11;
        r12 = r5.getAsString();
        if (r12 != null) goto L15;
        goto L11
    }
}
