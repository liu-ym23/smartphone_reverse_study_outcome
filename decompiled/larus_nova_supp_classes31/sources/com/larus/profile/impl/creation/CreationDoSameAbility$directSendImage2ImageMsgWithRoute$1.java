package com.larus.profile.impl.creation;

import android.os.Bundle;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1", f = "CreationDoSameAbility.kt", i = {0, 0, 1, 3}, l = {2727, 2732, 2769, 2775, 2776, 2784}, m = "invokeSuspend", n = {"entities", "job2", "entities", "sendConfig"}, s = {"L$0", "L$1", "L$0", "L$0"})
final class CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionBarCreationType;
    final /* synthetic */ sq9.p $doSameInitParams;
    final /* synthetic */ String $fileLocalPath;
    final /* synthetic */ Map<String, String> $messageExt;
    final /* synthetic */ Function1<Bundle, Unit> $openRoute;
    final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $targetActionBarItem;
    final /* synthetic */ UserCreation $userCreation;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CreationDoSameAbility this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1(sq9.p r1, CreationDoSameAbility r2, UserCreation r3, com.larus.bmhome.actionbar.model.z0 r4, Map<String, String> r5, String r6, String r7, Function1<? super Bundle, Unit> r8, Continuation<? super CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1> r9) {
        this.$doSameInitParams = r1;
        this.this$0 = r2;
        this.$userCreation = r3;
        this.$targetActionBarItem = r4;
        this.$messageExt = r5;
        this.$actionBarCreationType = r6;
        this.$fileLocalPath = r7;
        this.$openRoute = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1 r10 = new CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1(this.$doSameInitParams, this.this$0, this.$userCreation, this.$targetActionBarItem, this.$messageExt, this.$actionBarCreationType, this.$fileLocalPath, this.$openRoute, r13);
        r10.L$0 = r12;
        return r10;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r54) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(this.label) {
            case 0: goto L11;
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        ResultKt.throwOnFailure(r54);
    L122:
        return Unit.INSTANCE;
    L7:
        final CreationSendMessageConfig r0 = (CreationSendMessageConfig) this.L$0;
        ResultKt.throwOnFailure(r54);
    L115:
        final CreationDoSameAbility r1 = this.this$0;
        final Function1<Bundle, Unit> r2 = this.$openRoute;
        Function0 r3 = new n(r2, r1, r0);
        this.L$0 = null;
        this.label = 5;
        if (CreationDoSameAbility.h(r1, "directSendImage2ImageMsgWithRoute open", r3, this) != r7) goto L122;
        return r7;
    L8:
        ResultKt.throwOnFailure(r54);
        Object r4 = r54;
    L112:
        r0 = (CreationSendMessageConfig) r4;
        CreationDoSameAbility r5 = this.this$0;
        this.L$0 = r0;
        this.label = 4;
        if (CreationDoSameAbility.e(r5, r0, this) != r7) goto L115;
        return r7;
    L9:
        List r6 = (List) this.L$0;
        ResultKt.throwOnFailure(r54);
        List r10 = r6;
        Object r8 = r54;
    L25:
        UplinkFileEntity r9 = (UplinkFileEntity) r8;
        if (r9 == null) goto L28;
        Boxing.boxBoolean(r10.add(r9));
    L28:
        CustomMultiAttachmentInfo r43 = new CustomMultiAttachmentInfo("album", this.$doSameInitParams.c, new NestedFileContent(r10, null, false, null, 14, null), false, false, false, false, null, 248, null);
        CreationDoSameAbility r11 = this.this$0;
        UserCreation r12 = this.$userCreation;
        sq9.p r13 = this.$doSameInitParams;
        int r14 = CreationDoSameAbility.f;
        r11.getClass();
        String r15 = CreationDoSameAbility.j(r12, r13);
        if (r15 != null) goto L31;
        String r17 = "";
    L32:
        com.larus.bmhome.actionbar.model.z0 r16 = this.$targetActionBarItem;
        if (r16 == null) goto L39;
        com.larus.bmhome.actionbar.model.r r18 = r16.q;
        if (r18 == null) goto L39;
        Integer r19 = r18.a;
        if (r19 == null) goto L39;
        int r25 = r19.intValue();
    L40:
        com.larus.bmhome.instruction.c2 r20 = com.larus.bmhome.instruction.c2.a;
        com.larus.bmhome.actionbar.model.z0 r21 = this.$targetActionBarItem;
        if (r21 == null) goto L43;
        String r22 = r21.b;
    L44:
        if (r22 != null) goto L46;
        r22 = "";
    L46:
        if (r21 == null) goto L52;
        com.larus.bmhome.actionbar.model.r r23 = r21.q;
        if (r23 == null) goto L52;
        Integer r24 = r23.a;
        if (r24 == null) goto L52;
        String r26 = r24.toString();
    L53:
        if (r26 != null) goto L55;
        r26 = "";
    L55:
        com.larus.bmhome.actionbar.model.z0 r27 = this.$targetActionBarItem;
        if (r27 == null) goto L60;
        com.larus.bmhome.actionbar.model.r r110 = r27.q;
        if (r110 == null) goto L60;
        Integer r111 = r110.a;
    L61:
        if (r27 == null) goto L90;
        com.larus.bmhome.actionbar.model.r r28 = r27.q;
        if (r28 == null) goto L90;
        com.larus.bmhome.actionbar.model.y r29 = r28.i;
        if (r29 == null) goto L90;
        ArrayList r30 = r29.a;
        if (r30 == null) goto L90;
        com.larus.bmhome.actionbar.model.z0 r31 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.firstOrNull(r30);
        if (r31 == null) goto L90;
        com.larus.bmhome.actionbar.model.r r32 = r31.q;
        if (r32 == null) goto L90;
        List r33 = r32.b;
        if (r33 == null) goto L90;
        Iterator r34 = r33.iterator();
    L76:
        if (r34.hasNext() == false) goto L86;
        Object r112 = r34.next();
        Integer r113 = ((com.larus.bmhome.actionbar.model.u) r112).b;
        if (r113 != null) goto L81;
    L83:
        boolean r114 = false;
    L84:
        if (r114 == false) goto L76;
    L87:
        com.larus.bmhome.actionbar.model.u r115 = (com.larus.bmhome.actionbar.model.u) r112;
        if (r115 == null) goto L90;
        List r116 = CollectionsKt.listOf(r115);
    L91:
        com.larus.bmhome.actionbar.model.z0 r35 = this.$targetActionBarItem;
        if (r35 == null) goto L94;
        com.larus.bmhome.actionbar.model.r r117 = r35.q;
    L95:
        com.larus.bmhome.actionbar.model.r r36 = r20.a(r111, r17, r116, r117, 0);
        if (r36 == null) goto L98;
        String r118 = HttpExtKt.p(r36);
    L99:
        Map<String, String> r119 = this.$messageExt;
        com.larus.bmhome.actionbar.model.z0 r37 = this.$targetActionBarItem;
        if (r37 == null) goto L102;
        Long r120 = r37.a;
    L103:
        Map r210 = r20.b(r22, r26, r118, false, r119, r120);
        sq9.p r38 = this.$doSameInitParams;
        String r39 = r38.c;
        if (r39 != null) goto L106;
        String r310 = "";
    L107:
        final ICoreInputAbility.OnSendParams r40 = new ICoreInputAbility.OnSendParams(r17, "", null, null, null, r210, null, null, r25, false, null, false, false, false, null, null, null, null, false, r310, this.$messageExt, null, null, null, r38.b, null, r43, null, null, null, null, null, null, -85459264, 1, null);
        this.this$0.getClass();
        if (CreationDoSameAbility.r() == false) goto L118;
        CreationDoSameAbility r41 = this.this$0;
        sq9.p r42 = this.$doSameInitParams;
        UserCreation r44 = this.$userCreation;
        String r45 = this.$actionBarCreationType;
        this.L$0 = null;
        this.label = 3;
        r4 = CreationDoSameAbility.c(r41, r40, r42, r44, r45, this);
        if (r4 != r7) goto L112;
        return r7;
    L118:
        CreationDoSameAbility r46 = this.this$0;
        final Function1<Bundle, Unit> r47 = this.$openRoute;
        Function0 r48 = new o(r47, r40);
        this.L$0 = null;
        this.label = 6;
        if (CreationDoSameAbility.h(r46, "directSendImage2ImageMsgWithRoute legacyOpen", r48, this) != r7) goto L122;
        return r7;
    L106:
        r310 = r39;
        goto L107
    L102:
        r120 = null;
        goto L103
    L98:
        r118 = null;
        goto L99
    L94:
        r117 = null;
        goto L95
    L81:
        if (r113.intValue() != 15) goto L83;
        r114 = true;
        goto L84
    L86:
        r112 = null;
    L90:
        r116 = null;
    L60:
        r111 = null;
    L52:
        r26 = null;
        goto L53
    L43:
        r22 = null;
    L39:
        r25 = 0;
        goto L40
    L31:
        r17 = r15;
        goto L32
    L10:
        Deferred r49 = (Deferred) this.L$1;
        List r50 = (List) this.L$0;
        ResultKt.throwOnFailure(r54);
        Deferred r51 = r49;
        Object r52 = r54;
    L14:
        UplinkFileEntity r53 = (UplinkFileEntity) r52;
        if (r53 == null) goto L17;
    L19:
        if (r53 == null) goto L21;
        Boxing.boxBoolean(r50.add(r53));
    L21:
        this.L$0 = r50;
        this.L$1 = null;
        this.label = 2;
        r8 = r51.await(this);
        if (r8 != r7) goto L24;
        return r7;
    L24:
        r10 = r50;
        goto L25
    L17:
        if (Intrinsics.areEqual(this.$doSameInitParams.l, DoSameQuickMenuType.REPLACE_PIC) == false) goto L19;
        FLogger.a.w("CreationDoSameAbility", "directSendImage2ImageMsgWithRoute stop, replace pic resource empty");
        goto L122
    L11:
        ResultKt.throwOnFailure(r54);
        CoroutineScope r55 = (CoroutineScope) this.L$0;
        r50 = new ArrayList();
        Deferred r121 = BuildersKt.async$default(r55, null, null, new CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1$job1$1(this.$doSameInitParams, this.$userCreation, this.this$0, null), 3, null);
        r51 = BuildersKt.async$default(r55, null, null, new CreationDoSameAbility$directSendImage2ImageMsgWithRoute$1$job2$1(this.$fileLocalPath, null), 3, null);
        this.L$0 = r50;
        this.L$1 = r51;
        this.label = 1;
        r52 = r121.await(this);
        if (r52 != r7) goto L14;
        return r7;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
