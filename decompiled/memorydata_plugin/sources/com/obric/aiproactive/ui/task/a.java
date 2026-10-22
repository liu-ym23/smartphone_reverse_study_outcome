package com.obric.aiproactive.ui.task;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.aiproactive.api.b;
import com.obric.aiproactive.api.c;
import com.obric.aiproactive.api.n;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B-\u0012$\b\u0002\u0010\u0002\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ*\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0002R,\u0010\u0002\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/obric/aiproactive/ui/task/ProactiveTaskExecutor;", "", "queryExecutor", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "execute", "context", "Landroid/content/Context;", NotificationCompat.CATEGORY_RECOMMENDATION, "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "(Landroid/content/Context;Lcom/obric/aiproactive/api/ProactiveRecommendationDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "overrideQuery", "(Landroid/content/Context;Lcom/obric/aiproactive/api/ProactiveRecommendationDto;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractPresetQuery", "resolveQuery", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0316a f6867a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2<String, Continuation<? super Boolean>, Object> f6868b;

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.task.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/ui/task/ProactiveTaskExecutor$Companion;", "", "<init>", "()V", "TAG", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0316a {
        private C0316a() {
        }

        public /* synthetic */ C0316a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f6867a = new C0316a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public a(Function2<? super String, ? super Continuation<? super Boolean>, ? extends Object> r3) {
        Function2<String, Continuation<? super Boolean>, Object> r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "queryExecutor");
        this.f6868b = r4;
    }

    public /* synthetic */ a(Function2 r2, int r3, DefaultConstructorMarker r4) {
        Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = (Function2) ZeusTransformUtils.preCheckCast(new ProactiveTaskExecutor$1(null), Function2.class, "com.obric.memorydata.plugin");
    L5:
        this(r5);
    }

    private final String a(ProactiveRecommendationDto r6) {
        if (Intrinsics.areEqual(r6.getType(), AutoMemoryViewModel.SOURCE_AI_PROACTIVE) == false) goto L51;
        n r5 = c.b(r6.getActionCondition());
        if (r5 == null) goto L16;
        String r7 = r5.c();
        if (r7 == null) goto L16;
        String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r8 == null) goto L16;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L14;
        r8 = null;
    L14:
        if (r8 == null) goto L16;
        return r8;
    L16:
        if (r5 == null) goto L18;
        String r9 = r5.a();
    L19:
        List<b> r10 = c.a(r9);
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L21:
        if (r11.hasNext() == false) goto L28;
        Object r3 = r11.next();
        if (((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin")).c() != 0) goto L25;
        boolean r4 = true;
    L26:
        if (r4 == false) goto L21;
    L29:
        b r12 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L41;
        String r13 = r12.b();
        if (r13 == null) goto L41;
        String r14 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r14 == null) goto L41;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L39;
        r14 = null;
    L39:
        if (r14 == null) goto L41;
        return r14;
    L41:
        b r15 = (b) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r10), b.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L65;
        String r16 = r15.b();
        if (r16 == null) goto L66;
        String r17 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r17 != null) goto L48;
        return null;
    L48:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L50;
        return null;
    L50:
        return r17;
    L66:
        return null;
    L65:
        return null;
    L25:
        r4 = false;
        goto L26
    L28:
        r3 = null;
        goto L29
    L18:
        r9 = null;
        goto L19
    L51:
        String r18 = r6.getActionExecuteInstruction();
        if (r18 == null) goto L69;
        String r19 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r19 != null) goto L56;
        return null;
    L56:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L58;
        return null;
    L58:
        return r19;
    L69:
        return null;
    }

    public final Object a(Context r12, ProactiveRecommendationDto r13, String r14, Continuation<? super Boolean> r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        Continuation r17 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r17, ProactiveTaskExecutor$execute$2.class) == false) goto L7;
        ProactiveTaskExecutor$execute$2 r18 = (ProactiveTaskExecutor$execute$2) ZeusTransformUtils.preCheckCast(r17, ProactiveTaskExecutor$execute$2.class, "com.obric.memorydata.plugin");
        if ((r18.label & Integer.MIN_VALUE) == 0) goto L7;
        r18.label -= Integer.MIN_VALUE;
    L8:
        Object r19 = r18.result;
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r18.label;
        boolean r4 = true;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        r13 = (ProactiveRecommendationDto) ZeusTransformUtils.preCheckCast(r18.L$0, ProactiveRecommendationDto.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L14
    L42:
        boolean r11 = ((Boolean) ZeusTransformUtils.preCheckCast(r19, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Throwable -> L14
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        StringBuilder r110 = new StringBuilder().append("[Executor] tryActiveAiProactiveAssistantQuery id=").append(r13.getRecommendId()).append(" accepted=");     // Catch: Throwable -> L14
        if (r11 == false) goto L45;
        boolean r111 = true;
    L46:
        IRunLog.a.a(r5, "ProactiveTaskExecutor", r110.append(r111).toString(), false, 4, null);     // Catch: Throwable -> L14
        if (r11 == true) goto L50;
        r4 = false;
    L50:
        Object r112 = Result.m1421constructorimpl(Boxing.boxBoolean(r4));     // Catch: Throwable -> L14
    L53:
        Throwable r113 = Result.m1424exceptionOrNullimpl(r112);
        if (r113 == null) goto L60;
        RunLog.INSTANCE.error("ProactiveTaskExecutor", "[Executor] execute failed id=" + r13.getRecommendId(), r113);
        return Boxing.boxBoolean(false);
    L60:
        return r112;
    L45:
        r111 = false;
        goto L46
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r19);
        if (r14 == null) goto L27;
        String r114 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r114 == null) goto L27;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r114, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L26;
        r114 = null;
    L26:
        if (r114 == null) goto L27;
    L31:
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = new StringBuilder().append("[Executor] execute id=").append(r13.getRecommendId()).append(" override=");
        CharSequence r115 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin");
        if (r115 != null) goto L34;
    L37:
        boolean r116 = true;
    L38:
        IRunLog.a.a(r6, "ProactiveTaskExecutor", r3.append(!r116).append(" queryLen=").append(r114.length()).append(" queryPreview=").append(StringsKt.take(r114, 30)).toString(), false, 4, null);
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L14
        Function2<String, Continuation<? super Boolean>, Object> r118 = ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin")).f6868b;     // Catch: Throwable -> L14
        r18.L$0 = r13;     // Catch: Throwable -> L14
        r18.label = 1;     // Catch: Throwable -> L14
        r19 = r118.invoke(r114, r18);     // Catch: Throwable -> L14
        if (r19 != r0) goto L42;
        return r0;
    L34:
        if (StringsKt.isBlank(r115) == true) goto L37;
        r116 = false;
    L27:
        r114 = a(r13);
        if (r114 != null) goto L31;
        return Boxing.boxBoolean(false);
    L14:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r112 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L7:
        r18 = new ProactiveTaskExecutor$execute$2(this, r17);
        goto L8
    }

    public final Object a(Context r3, ProactiveRecommendationDto r4, Continuation<? super Boolean> r5) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, null, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
