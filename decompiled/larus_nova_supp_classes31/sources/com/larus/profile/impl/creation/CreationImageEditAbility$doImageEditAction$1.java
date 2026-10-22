package com.larus.profile.impl.creation;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.common.apphost.AppHost;
import com.larus.instruction.service.IInstructionService;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationImageEditAbility$doImageEditAction$1", f = "CreationImageEditAbility.kt", i = {0}, l = {119}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class CreationImageEditAbility$doImageEditAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CreationImageEditAbility this$0;

    public static final class a implements zs8.a {
        public final /* synthetic */ CreationImageEditAbility a;

        public final String Y1() {
            return null;
        }

        public final String a() {
            return null;
        }

        public final String c() {
            return null;
        }

        public final String d() {
            return null;
        }

        public final String e() {
            return null;
        }

        public final String f() {
            return null;
        }

        public final String g() {
            return null;
        }

        public final String getBotId() {
            return null;
        }

        public final String getChatType() {
            return null;
        }

        public final String getTemplateType() {
            return null;
        }

        public final String h() {
            return null;
        }

        public final String i() {
            return null;
        }

        public final String j() {
            return null;
        }

        public final String k() {
            return null;
        }

        public final boolean l() {
            return false;
        }

        public final String m() {
            return null;
        }

        public final String n() {
            return null;
        }

        public final String o() {
            return null;
        }

        public final String p() {
            return null;
        }

        public final String b() {
            fs9.h r0 = this.a.c.e;
            if (r0 == null) goto L6;
            String r1 = r0.a;
            if (r1 == null) goto L6;
            return r1;
        L6:
            return "";
        }

        public final String getClickFrom() {
            fs9.h r0 = this.a.c.e;
            if (r0 == null) goto L6;
            String r1 = r0.c;
            if (r1 == null) goto L6;
            return r1;
        L6:
            return "";
        }

        public final String getEnterMethod() {
            fs9.h r0 = this.a.c.e;
            if (r0 == null) goto L6;
            String r1 = r0.d;
            if (r1 == null) goto L6;
            return r1;
        L6:
            return "";
        }

        public a(CreationImageEditAbility r1) {
            this.a = r1;
        }
    }

    public CreationImageEditAbility$doImageEditAction$1(CreationImageEditAbility r1, Continuation<? super CreationImageEditAbility$doImageEditAction$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CreationImageEditAbility$doImageEditAction$1 r0 = new CreationImageEditAbility$doImageEditAction$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r39) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        CoroutineScope r1 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r39);
        Object r3 = r39;
    L18:
        com.larus.uaigc.api.s r4 = (com.larus.uaigc.api.s) ((com.larus.network.http.a) r3).b;
        if (r4 == null) goto L24;
        List<com.larus.uaigc.api.q> r5 = r4.a();
        if (r5 == null) goto L24;
        com.larus.uaigc.api.q r6 = (com.larus.uaigc.api.q) CollectionsKt.firstOrNull(r5);
    L23:
        com.larus.uaigc.api.q r8 = r6;
    L25:
        if (r8 == null) goto L27;
        String r7 = r8.c();
    L29:
        if (com.larus.utils.o0.d(r7) == false) goto L152;
        aq8.g r9 = new aq8.g(null, "0", String.valueOf(this.this$0.c.d), null, 9);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L33
        Object r11 = Result.constructor-impl(xt7.d.b.a(aq8.g.Companion.serializer(), r9));     // Catch: Throwable -> L33
    L36:
        if (Result.isFailure-impl(r11) == false) goto L38;
        r11 = null;
    L38:
        String r12 = (String) r11;
        if (r12 != null) goto L41;
        r12 = "";
    L41:
        com.larus.bmhome.actionbar.model.z0 r13 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(4);
        if (r13 == null) goto L152;
        com.larus.bmhome.actionbar.model.r r14 = r13.q;
        if (r14 == null) goto L152;
        CreationImageEditAbility r15 = this.this$0;
        IInstructionService.Companion r16 = IInstructionService.a;
        gq8.a r17 = gq8.a.a;
        Integer r18 = r14.a;
        r17.getClass();
        List r19 = IInstructionService.a.a(r16, r14, new com.larus.bmhome.view.actionbar.edit.d(gq8.a.b(r18, r12, null)), null, null, 12).b();
        if (r19 == null) goto L48;
        List r110 = CollectionsKt.toMutableList(r19);
    L49:
        List r20 = r14.b;
        if (r20 == null) goto L89;
        Iterator r21 = r20.iterator();
    L53:
        if (r21.hasNext() == false) goto L63;
        Object r22 = r21.next();
        Integer r111 = ((com.larus.bmhome.actionbar.model.u) r22).b;
        if (r111 != null) goto L58;
    L60:
        boolean r112 = false;
    L61:
        if (r112 == false) goto L53;
    L64:
        com.larus.bmhome.actionbar.model.u r23 = (com.larus.bmhome.actionbar.model.u) r22;
        if (r23 == null) goto L89;
        Integer r113 = r23.a;
        Integer r27 = Boxing.boxInt(14);
        fs9.g r24 = r15.c;
        String r114 = r7;
        List r36 = r110;
        MediaAttachment r115 = new MediaAttachment(r24.a, r114, new ImageUploadInfo(Boxing.boxLong(r24.b), Boxing.boxLong(r24.c)), null, null, null, null, null, null, null, null, null, 4088, null);
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L72
        ouc.v r26 = xt7.d.b;     // Catch: Throwable -> L72
        juc.c r28 = com.larus.bmhome.actionbar.model.m1.Companion.serializer();     // Catch: Throwable -> L72
        String r29 = r23.d;     // Catch: Throwable -> L72
        if (r29 != null) goto L70;
        r29 = "";
    L70:
        Object r30 = Result.constructor-impl((com.larus.bmhome.actionbar.model.m1) r26.c(r28, r29));     // Catch: Throwable -> L72
    L75:
        if (Result.isFailure-impl(r30) == false) goto L77;
        r30 = null;
    L77:
        com.larus.bmhome.actionbar.model.m1 r31 = (com.larus.bmhome.actionbar.model.m1) r30;
        if (r31 != null) goto L153;
        String r210 = null;
    L88:
        com.larus.bmhome.actionbar.model.u r32 = new com.larus.bmhome.actionbar.model.u(r113, r27, null, r210, null, null, null, 244);
    L90:
        List r33 = r36;
        if (r32 == null) goto L94;
        if (r33 == null) goto L94;
        Boxing.boxBoolean(r33.add(r32));
    L94:
        if (r33 == null) goto L152;
        Iterator r34 = r33.iterator();
    L97:
        if (r34.hasNext() == false) goto L107;
        Object r35 = r34.next();
        Integer r37 = ((com.larus.bmhome.actionbar.model.u) r35).b;
        if (r37 != null) goto L102;
    L104:
        boolean r38 = false;
    L105:
        if (r38 == false) goto L97;
    L108:
        com.larus.bmhome.actionbar.model.u r40 = (com.larus.bmhome.actionbar.model.u) r35;
        if (r40 == null) goto L152;
        List r41 = ((com.larus.bmhome.actionbar.model.b0) GsonProtectorUtils.fromJson(com.larus.bmhome.music.protocol.a.a, r40.d, com.larus.bmhome.actionbar.model.b0.class)).a;
        if (r41 == null) goto L152;
        Iterator r42 = r41.iterator();
    L114:
        if (r42.hasNext() == false) goto L125;
        Object r43 = r42.next();
        Integer r44 = ((com.larus.bmhome.actionbar.model.c0) r43).a;
        CreationImageEditAbility r116 = r15;
        int r117 = r116.c.d;
        if (r44 != null) goto L119;
    L121:
        boolean r45 = false;
    L122:
        if (r45 == true) goto L126;
        r15 = r116;
    L126:
        com.larus.bmhome.actionbar.model.c0 r46 = (com.larus.bmhome.actionbar.model.c0) r43;
        if (r46 == null) goto L152;
        String r47 = r46.c;
        if (r47 == null) goto L152;
        com.larus.bmhome.actionbar.model.p1 r48 = (com.larus.bmhome.actionbar.model.p1) GsonProtectorUtils.fromJson(com.larus.bmhome.music.protocol.a.a, r47, com.larus.bmhome.actionbar.model.p1.class);
        String r49 = "";
        r116.getClass();
        r49 = com.larus.bmhome.view.actionbar.custom.w2.a.a(com.larus.bmhome.view.actionbar.custom.e.a, "", r13.q, r33, r48, null, 0, null, 112);     // Catch: Exception -> L133
    L136:
        Gson r50 = HttpExtKt.f;
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L139
        com.larus.bmhome.instruction.c2 r119 = com.larus.bmhome.instruction.c2.a;     // Catch: Throwable -> L139
        Object r51 = Result.constructor-impl(r50.toJson(com.larus.bmhome.instruction.j.a.b(r14.a, "", r33, r14)));     // Catch: Throwable -> L139
    L142:
        if (Result.isFailure-impl(r51) == false) goto L144;
        r51 = null;
    L144:
        String r52 = (String) r51;
        com.larus.bmhome.instruction.c2 r120 = com.larus.bmhome.instruction.c2.a;
        String r53 = r13.b;
        if (r53 != null) goto L147;
        String r121 = "";
    L148:
        Map r122 = com.larus.bmhome.instruction.j.a.c(r120, r121, String.valueOf(r14.a), r52, false, null, null, 48);
        BuildersKt.launch$default(r116.b, null, null, new CreationImageEditAbility$doImageEditAction$1$1$3$2$1(r116, r7, r8, r48, r49, new a(r116), r33, r122, r14, r52, null), 3, null);
        goto L152
    L147:
        r121 = r53;
    L139:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r51 = Result.constructor-impl(ResultKt.createFailure(th));
    L133:
        e = move-exception;
        FLogger.a.e("InstructionComponent", "buildContent error = " + e.getMessage());
        if (AppHost.a.isDebug() == false) goto L136;
        throw new IllegalArgumentException("InstructionComponent, " + e.getMessage());
    L119:
        if (r44.intValue() != r117) goto L121;
        r45 = true;
        goto L122
    L125:
        r116 = r15;
        r43 = null;
        goto L126
    L102:
        if (r37.intValue() != 8) goto L104;
        r38 = true;
        goto L105
    L107:
        r35 = null;
        goto L108
    L153:
        Object r54 = Result.constructor-impl(xt7.d.b.a(com.larus.bmhome.actionbar.model.m1.Companion.serializer(), com.larus.bmhome.actionbar.model.m1.a(r31, r115)));     // Catch: Throwable -> L81
    L84:
        if (Result.isFailure-impl(r54) == false) goto L86;
        r54 = null;
    L86:
        r210 = (String) r54;
    L81:
        th = move-exception;
        Result.Companion r55 = Result.Companion;
        r54 = Result.constructor-impl(ResultKt.createFailure(th));
    L72:
        th = move-exception;
        Result.Companion r56 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L75
    L58:
        if (r111.intValue() != 14) goto L60;
        r112 = true;
        goto L61
    L63:
        r22 = null;
    L89:
        r36 = r110;
        r32 = null;
        goto L90
    L48:
        r110 = null;
    L33:
        th = move-exception;
        Result.Companion r57 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L152:
        return Unit.INSTANCE;
    L27:
        r7 = null;
    L24:
        r8 = null;
        goto L25
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r39);
        CoroutineScope r58 = (CoroutineScope) this.L$0;
        fs9.g r59 = this.this$0.c;
        if (r59.f == null) goto L15;
        FLogger.a.i("CreationImageEditAbility", "skip explainResourceUrls for drive image");
        fs9.g r60 = this.this$0.c;
        ic8.r r61 = r60.f;
        if (r61 == null) goto L13;
        String r62 = r61.a;
    L14:
        r6 = new com.larus.uaigc.api.q(r62, new com.larus.uaigc.api.p(new com.larus.uaigc.api.n(new com.larus.uaigc.api.m(Boxing.boxLong(r60.b), Boxing.boxLong(this.this$0.c.c)))), 9);
        goto L23
    L13:
        r62 = null;
        goto L14
    L15:
        List r63 = CollectionsKt.listOf(r59.a);
        this.L$0 = r58;
        this.label = 1;
        r3 = com.larus.uaigc.api.o.a(r63, true, this);
        if (r3 != r0) goto L18;
        return r0;
    }
}
