package com.larus.uaigc.spring.component;

import android.view.View;
import com.larus.platform.service.z2;
import com.larus.uaigc.lynx.pocket.PocketDataCache;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.spring.component.SpringMainVenueLynxComponent$initLynx$2", f = "SpringMainVenueLynxComponent.kt", i = {}, l = {566}, m = "invokeSuspend", n = {}, s = {})
final class SpringMainVenueLynxComponent$initLynx$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $containerView;
    int label;
    final /* synthetic */ SpringMainVenueLynxComponent this$0;

    public SpringMainVenueLynxComponent$initLynx$2(SpringMainVenueLynxComponent r1, View r2, Continuation<? super SpringMainVenueLynxComponent$initLynx$2> r3) {
        this.this$0 = r1;
        this.$containerView = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SpringMainVenueLynxComponent$initLynx$2(this.this$0, this.$containerView, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L17:
        if (((Boolean) r7).booleanValue() == false) goto L31;
        FLogger r8 = FLogger.a;
        r8.i("SpringMainVenueComponent", "[initLynx] inValid: false, refresh pocketPageData success");
        PocketDataCache.a.getClass();
        Map<String, ? extends Object> r3 = PocketDataCache.c();
        if (r3 != null) goto L21;
    L24:
        if (r2 == false) goto L26;
        r8.i("SpringMainVenueComponent", "[initLynx] inValid: false, refresh pocketPageData generate fail, use FE default pocketPageData");
    L27:
        SpringMainVenueLynxComponent r4 = this.this$0;
        int r5 = SpringMainVenueLynxComponent.P;
        r4.getClass();
        boolean r6 = z2.a.getZMainInputBoxShow();
        SpringMainVenueLynxComponent r9 = this.this$0;
        if (r3 != null) goto L30;
        r3 = MapsKt.emptyMap();
    L30:
        String r10 = r9.E3(r3, false, 0, r6 ? 1 : 0);
        r8.i("SpringMainVenueComponent", "[initLynx] inValid: false, refresh pocketPageData flow success, init pageDataJson generate = " + r10 + ", inputBoxShowSetting = " + (r6 ? 1 : 0));
        this.this$0.d4(this.$containerView, r10, false);
    L33:
        return Unit.INSTANCE;
    L26:
        this.this$0.K = r3;
        r8.i("SpringMainVenueComponent", "[initLynx] inValid: false, refresh pocketPageData generate success, refreshPocketResponseDict.size = " + ((ConcurrentHashMap) r3).size());
        goto L27
    L21:
        if (((ConcurrentHashMap) r3).isEmpty() == true) goto L24;
        r2 = false;
        goto L24
    L31:
        FLogger r11 = FLogger.a;
        r11.e("SpringMainVenueComponent", "[initLynx] inValid: false, refresh pocketPageData fail, use FE default pocketPageData");
        SpringMainVenueLynxComponent r12 = this.this$0;
        int r13 = SpringMainVenueLynxComponent.P;
        r12.getClass();
        String r14 = this.this$0.E3(MapsKt.emptyMap(), false, 0, z2.a.getZMainInputBoxShow() ? 1 : 0);
        r11.e("SpringMainVenueComponent", "[initLynx] inValid: false, refresh pocketPageData fail, empty pageDataJson generate = ".concat(r14));
        this.this$0.d4(this.$containerView, r14, false);
        goto L33
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        FLogger.a.i("SpringMainVenueComponent", "[initLynx] inValid: false, start to refresh pocketPageData");
        PocketDataCache r15 = PocketDataCache.a;
        SpringMainVenueLynxComponent r16 = this.this$0;
        int r17 = SpringMainVenueLynxComponent.P;
        a0a.b r18 = r16.G3();
        if (r18 == null) goto L12;
        String r19 = r18.b();
        if (r19 == null) goto L12;
    L13:
        this.label = 1;
        r15.getClass();
        r7 = PocketDataCache.f(1, r19, this);
        if (r7 != r0) goto L17;
        return r0;
    L12:
        r19 = "";
        goto L13
    }
}
