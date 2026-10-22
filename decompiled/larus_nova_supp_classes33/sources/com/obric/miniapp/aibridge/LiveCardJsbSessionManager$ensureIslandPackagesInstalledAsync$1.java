package com.obric.miniapp.aibridge;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.aibridge.LiveCardJsbSessionManager$ensureIslandPackagesInstalledAsync$1", f = "LiveCardJsbMethods.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LiveCardJsbSessionManager$ensureIslandPackagesInstalledAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $pkgs;
    final /* synthetic */ String $sessionKey;
    final /* synthetic */ String $tag;
    private /* synthetic */ Object L$0;
    int label;

    public LiveCardJsbSessionManager$ensureIslandPackagesInstalledAsync$1(List<String> r1, String r2, String r3, Continuation<? super LiveCardJsbSessionManager$ensureIslandPackagesInstalledAsync$1> r4) {
        this.$pkgs = r1;
        this.$sessionKey = r2;
        this.$tag = r3;
        super(2, r4);
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        LiveCardJsbSessionManager$ensureIslandPackagesInstalledAsync$1 r0 = new LiveCardJsbSessionManager$ensureIslandPackagesInstalledAsync$1(this.$pkgs, this.$sessionKey, this.$tag, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_miniapp_aibridge_LiveCardJsbSessionManager$ensureIslandPackagesInstalledAsync$1_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
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

    public final Object invokeSuspend(Object r17) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L159;
        ResultKt.throwOnFailure(r17);
        CoroutineScope r0 = (CoroutineScope) this.L$0;
        List<String> r4 = this.$pkgs;
        String r5 = this.$sessionKey;
        String r6 = this.$tag;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L151
        Class r7 = INVOKESTATIC_com_obric_miniapp_aibridge_LiveCardJsbSessionManager$ensureIslandPackagesInstalledAsync$1_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.ai.settings.AISDKSettingConfigManager");     // Catch: Throwable -> L151
        Object r8 = null;
        boolean r9 = true;
        Field r2 = r7.getDeclaredField("INSTANCE");     // Catch: Throwable -> L9
        r2.setAccessible(true);     // Catch: Throwable -> L9
        Object r3 = Result.constructor-impl(r2.get(null));     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r3) == false) goto L14;
        Object r10 = null;
    L15:
        Field[] r11 = r7.getDeclaredFields();     // Catch: Throwable -> L151
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L151
        int r13 = r11.length;     // Catch: Throwable -> L151
        int r14 = 0;
    L16:
        if (r14 >= r13) goto L27;
        Field r15 = r11[r14];     // Catch: Throwable -> L151
        if (StringsKt.contains(r15.getName(), "PRE_INSTALL", true) == false) goto L20;
    L23:
        boolean r16 = true;
    L24:
        if (r16 == false) goto L26;
        r12.add(r15);     // Catch: Throwable -> L151
    L26:
        r14 = r14 + 1;     // Catch: Throwable -> L151
        goto L16
    L20:
        if (StringsKt.contains(r15.getName(), "DOWNLOAD", true) == true) goto L23;
        r16 = false;
        goto L24
    L27:
        Iterator r18 = r12.iterator();     // Catch: Throwable -> L151
    L29:
        if (r18.hasNext() == false) goto L97;
        Field r19 = (Field) r18.next();     // Catch: Throwable -> L151
        r19.setAccessible(r9);     // Catch: Throwable -> L151
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L37
        if (Modifier.isStatic(r19.getModifiers()) == false) goto L34;
        Object r20 = r19.get(r8);     // Catch: Throwable -> L37
    L35:
        Object r21 = Result.constructor-impl(r20);     // Catch: Throwable -> L37
    L40:
        if (Result.isFailure-impl(r21) == false) goto L42;
        Object r111 = r8;
    L43:
        if (r111 == null) goto L29;
        Class<?> r22 = r111.getClass();     // Catch: Throwable -> L151
        Method[] r112 = r22.getMethods();     // Catch: Throwable -> L151
        int r113 = r112.length;     // Catch: Throwable -> L151
        int r114 = 0;
    L46:
        if (r114 >= r113) goto L59;
        Method r115 = r112[r114];     // Catch: Throwable -> L151
        if (Intrinsics.areEqual(r115.getName(), "getValue") == true) goto L50;
    L55:
        boolean r23 = false;
    L56:
        if (r23 == true) goto L60;
        r114 = r114 + 1;     // Catch: Throwable -> L151
    L60:
        Method[] r24 = r22.getMethods();     // Catch: Throwable -> L151
        int r25 = r24.length;     // Catch: Throwable -> L151
        int r26 = 0;
    L61:
        if (r26 >= r25) goto L72;
        Method r116 = r24[r26];     // Catch: Throwable -> L151
        if (Intrinsics.areEqual(r116.getName(), "setValue") == true) goto L66;
    L68:
        boolean r117 = false;
    L69:
        if (r117 == true) goto L73;
        r26 = r26 + 1;
    L73:
        if (r115 == null) goto L96;
        if (r116 == null) goto L96;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L78
        Object r28 = Result.constructor-impl(r115.invoke(r111, new Object[0]));     // Catch: Throwable -> L78
    L81:
        if (Result.isFailure-impl(r28) == false) goto L84;
        r28 = null;
    L84:
        if ((r28 instanceof Collection) == false) goto L96;
        ArrayList r29 = new ArrayList();     // Catch: Throwable -> L151
        Iterator r30 = ((Iterable) r28).iterator();     // Catch: Throwable -> L151
    L87:
        if (r30.hasNext() == false) goto L91;
        Object r31 = r30.next();     // Catch: Throwable -> L151
        if ((r31 instanceof String) == false) goto L87;
        r29.add(r31);     // Catch: Throwable -> L151
        goto L87
    L91:
        List r32 = CollectionsKt.distinct(CollectionsKt.plus(r29, r4));     // Catch: Throwable -> L151
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L94
        Result.constructor-impl(r116.invoke(r111, new Object[]{r32}));     // Catch: Throwable -> L94
    L94:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L151
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L151
    L78:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L151
        r28 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L151
    L96:
        r8 = null;
        r9 = true;
        goto L29
    L66:
        if (r116.getParameterTypes().length != 1) goto L68;
        r117 = true;
        goto L69
    L72:
        r116 = null;
        goto L73
    L50:
        if (r115.getParameterTypes().length != 0) goto L52;
        boolean r36 = true;
    L53:
        if (r36 == false) goto L55;
        r23 = true;
        goto L56
    L52:
        r36 = false;
        goto L53
    L59:
        r115 = null;
        goto L60
    L42:
        r111 = r21;
        goto L43
    L34:
        r20 = r19.get(r10);     // Catch: Throwable -> L37
        goto L35
    L37:
        th = move-exception;
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L151
        r21 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L151
        goto L40
    L97:
        Class r37 = INVOKESTATIC_com_obric_miniapp_aibridge_LiveCardJsbSessionManager$ensureIslandPackagesInstalledAsync$1_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.ai.resource.AIManager");     // Catch: Throwable -> L151
        Method[] r38 = r37.getMethods();     // Catch: Throwable -> L151
        int r39 = r38.length;     // Catch: Throwable -> L151
        int r40 = 0;
    L98:
        if (r40 >= r39) goto L111;
        Method r41 = r38[r40];     // Catch: Throwable -> L151
        if (Intrinsics.areEqual(r41.getName(), "updateAllAIPackages") == true) goto L102;
    L107:
        boolean r119 = false;
    L108:
        if (r119 == true) goto L112;
        r40 = r40 + 1;
    L112:
        if (r41 != null) goto L166;
        LiveCardJsbSessionManager.a.getClass();     // Catch: Throwable -> L151
        LiveCardJsbSessionManager.n("show.ensurePackages", r5, r6, "updateAllAIPackages not found");     // Catch: Throwable -> L151
    L149:
        Object r42 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L151
    L153:
        String r43 = this.$sessionKey;
        String r44 = this.$tag;
        Throwable r45 = Result.exceptionOrNull-impl(r42);
        if (r45 == null) goto L157;
        FLogger.a.w("LiveCardJSB", "ensureIslandPackagesInstalledAsync failed", r45);
        LiveCardJsbSessionManager r46 = LiveCardJsbSessionManager.a;
        String r47 = "err=".concat(r45.getClass().getSimpleName());
        r46.getClass();
        LiveCardJsbSessionManager.l("show.ensurePackages", r43, r44, r47, r45);
    L157:
        return Unit.INSTANCE;
    L166:
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L119
        Field r49 = r37.getDeclaredField("INSTANCE");     // Catch: Throwable -> L119
        r49.setAccessible(true);     // Catch: Throwable -> L117
        Object r50 = Result.constructor-impl(r49.get(null));     // Catch: Throwable -> L117
    L122:
        Object r51 = r50;
        if (Result.isFailure-impl(r51) == false) goto L168;
        r51 = null;
    L168:
        Object r52 = Result.constructor-impl(r41.invoke(null, new Object[0]));     // Catch: Throwable -> L128
    L131:
        if (Result.isSuccess-impl(r52) == true) goto L142;
        Object r53 = Result.constructor-impl(r41.invoke(r51, new Object[0]));     // Catch: Throwable -> L135
    L138:
        if (Result.isSuccess-impl(r53) == true) goto L142;
        boolean r54 = false;
    L143:
        LiveCardJsbSessionManager r55 = LiveCardJsbSessionManager.a;     // Catch: Throwable -> L151
        StringBuilder r56 = new StringBuilder();     // Catch: Throwable -> L151
        r56.append("triggerUpdateAll=");     // Catch: Throwable -> L151
        if (r54 == false) goto L146;
        boolean r57 = true;
    L147:
        r56.append(r57);     // Catch: Throwable -> L151
        String r58 = r56.toString();     // Catch: Throwable -> L151
        r55.getClass();     // Catch: Throwable -> L151
        LiveCardJsbSessionManager.n("show.ensurePackages", r5, r6, r58);     // Catch: Throwable -> L151
        goto L149
    L146:
        r57 = false;
    L135:
        th = move-exception;
        Result.Companion r59 = Result.Companion;     // Catch: Throwable -> L151
        r53 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L151
    L142:
        r54 = true;
    L128:
        th = move-exception;
        Result.Companion r60 = Result.Companion;     // Catch: Throwable -> L151
        r52 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L151
    L117:
        th = th;
    L121:
        Result.Companion r61 = Result.Companion;     // Catch: Throwable -> L151
        r50 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L151
    L119:
        th = th;
        goto L121
    L102:
        if (r41.getParameterTypes().length != 0) goto L104;
        boolean r120 = true;
    L105:
        if (r120 == false) goto L107;
        r119 = true;
        goto L108
    L104:
        r120 = false;
        goto L105
    L111:
        r41 = null;
        goto L112
    L14:
        r10 = r3;
    L9:
        th = move-exception;
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L151
        r3 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L151
    L151:
        th = move-exception;
        Result.Companion r62 = Result.Companion;
        r42 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L153
    L159:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
