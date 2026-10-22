package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "K", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {417, 418, 420}, m = "invokeSuspend", n = {"$this$produce", "keys", "$this$produce", "keys", "e", "$this$produce", "keys", "k"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
final class ChannelsKt__DeprecatedKt$distinctBy$1<E> extends SuspendLambda implements Function2<w<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<E, Continuation<? super K>, Object> $selector;
    final /* synthetic */ y<E> $this_distinctBy;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    ChannelsKt__DeprecatedKt$distinctBy$1(y<? extends E> r3, Function2<? super E, ? super Continuation<? super K>, ? extends Object> r4, Continuation<? super ChannelsKt__DeprecatedKt$distinctBy$1> r5) {
        y<E> r6 = (y) ZeusTransformUtils.wrapperContextForParams(r3, y.class, "com.obric.memorydata.plugin");
        Function2<E, Continuation<? super K>, Object> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$this_distinctBy = r6;
        this.$selector = r7;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        ChannelsKt__DeprecatedKt$distinctBy$1 r0 = new ChannelsKt__DeprecatedKt$distinctBy$1(this.$this_distinctBy, this.$selector, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
        return invoke((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(w<? super E> r3, Continuation<? super Unit> r4) {
        return ((ChannelsKt__DeprecatedKt$distinctBy$1) ZeusTransformUtils.preCheckCast(create((w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ChannelsKt__DeprecatedKt$distinctBy$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v17, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, kotlinx.coroutines.channels.w] */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00ee -> B:29:0x0117). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0109 -> B:28:0x010b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1<E> for r11v3 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r11.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L8;
        java.lang.Object r1 = r11.L$3;
        java.lang.Object r6 = r11.L$2;
        java.lang.Object r6 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.channels.k.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.k<E> r6 = (kotlinx.coroutines.channels.k) r6;
        java.lang.Object r7 = r11.L$1;
        java.lang.Object r7 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r7, java.util.HashSet.class, "com.obric.memorydata.plugin");
        java.util.HashSet r7 = (java.util.HashSet) r7;
        java.lang.Object r8 = r11.L$0;
        java.lang.Object r8 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r8, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.w r8 = (kotlinx.coroutines.channels.w) r8;
        kotlin.ResultKt.throwOnFailure(r12);
        ?? r8 = r8;
    L28:
        java.lang.Object r12 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r7, java.util.Collection.class, "com.obric.memorydata.plugin");
        ?? r12 = (java.util.Collection) r12;
        r12.add(r1);
        kotlinx.coroutines.channels.k<E> r1 = r6;
        ?? r8 = r8;
    L29:
        java.util.HashSet r6 = r7;
        ?? r7 = r8;
    L13:
        java.lang.Object r12 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r11, kotlin.coroutines.Continuation.class, "com.obric.memorydata.plugin");
        kotlin.coroutines.Continuation<? super java.lang.Boolean> r12 = (kotlin.coroutines.Continuation) r12;
        r11.L$0 = r7;
        r11.L$1 = r6;
        r11.L$2 = r1;
        r11.L$3 = null;
        r11.label = 1;
        r12 = r1.a(r12);
        ?? r7 = r7;
        if (r12 != r0) goto L16;
        return r0;
    L16:
        java.lang.Object r12 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r12, java.lang.Boolean.class, "com.obric.memorydata.plugin");
        java.lang.Boolean r12 = (java.lang.Boolean) r12;
        boolean r12 = r12.booleanValue();
        if (r12 == false) goto L30;
        E r12 = r1.a();
        kotlin.jvm.functions.Function2 r8 = r11.$selector;
        r11.L$0 = r7;
        r11.L$1 = r6;
        r11.L$2 = r1;
        r11.L$3 = r12;
        r11.label = 2;
        java.lang.Object r11 = (kotlin.coroutines.Continuation<? super K>) r11;
        java.lang.Object r8 = r8.invoke(r12, r11);
        if (r8 != r0) goto L21;
        return r0;
    L21:
        java.util.HashSet r10 = r6;
        java.lang.Object r6 = r12;
        r12 = r8;
        ?? r8 = r7;
        r7 = r10;
    L22:
        boolean r9 = r7.contains(r12);
        r8 = r8;
        if (r9 == true) goto L29;
        java.lang.Object r9 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r11, kotlin.coroutines.Continuation.class, "com.obric.memorydata.plugin");
        kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9;
        r11.L$0 = r8;
        r11.L$1 = r7;
        r11.L$2 = r1;
        r11.L$3 = r12;
        r11.label = 3;
        java.lang.Object r6 = r8.send(r6, r9);
        if (r6 != r0) goto L27;
        return r0;
    L27:
        r6 = r1;
        r1 = r12;
        r8 = r8;
        goto L28
    L30:
        kotlin.Unit r11 = kotlin.Unit.INSTANCE;
        return r11;
    L8:
        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r11;
    L10:
        java.lang.Object r1 = r11.L$3;
        java.lang.Object r6 = r11.L$2;
        java.lang.Object r6 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.channels.k.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.k<E> r6 = (kotlinx.coroutines.channels.k) r6;
        java.lang.Object r7 = r11.L$1;
        java.lang.Object r7 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r7, java.util.HashSet.class, "com.obric.memorydata.plugin");
        r7 = (java.util.HashSet) r7;
        java.lang.Object r8 = r11.L$0;
        java.lang.Object r8 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r8, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.w r8 = (kotlinx.coroutines.channels.w) r8;
        kotlin.ResultKt.throwOnFailure(r12);
        r6 = r1;
        r1 = r6;
        r8 = r8;
        goto L22
    L11:
        java.lang.Object r1 = r11.L$2;
        java.lang.Object r1 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.channels.k.class, "com.obric.memorydata.plugin");
        r1 = (kotlinx.coroutines.channels.k) r1;
        java.lang.Object r6 = r11.L$1;
        java.lang.Object r6 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r6, java.util.HashSet.class, "com.obric.memorydata.plugin");
        r6 = (java.util.HashSet) r6;
        java.lang.Object r7 = r11.L$0;
        java.lang.Object r7 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.w r7 = (kotlinx.coroutines.channels.w) r7;
        kotlin.ResultKt.throwOnFailure(r12);
        r7 = r7;
        goto L16
    L12:
        kotlin.ResultKt.throwOnFailure(r12);
        java.lang.Object r12 = r11.L$0;
        java.lang.Object r12 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r12, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.w r12 = (kotlinx.coroutines.channels.w) r12;
        java.util.HashSet r1 = new java.util.HashSet();
        kotlinx.coroutines.channels.y<E> r6 = r11.$this_distinctBy;
        kotlinx.coroutines.channels.k<E> r6 = r6.l();
        r7 = r12;
        r6 = r1;
        r1 = r6;
        goto L13
    }
}
