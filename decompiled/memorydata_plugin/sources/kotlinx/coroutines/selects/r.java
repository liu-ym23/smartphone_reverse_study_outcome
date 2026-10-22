package kotlinx.coroutines.selects;

import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0000H\u0091@¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0002J0\u0010\r\u001a\u00020\f*\u00020\u000e2\u001c\u0010\u000f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0010H\u0096\u0002¢\u0006\u0002\u0010\u0013JB\u0010\r\u001a\u00020\f\"\u0004\b\u0001\u0010\u0014*\b\u0012\u0004\u0012\u0002H\u00140\u00152\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0016H\u0096\u0002¢\u0006\u0002\u0010\u0017JV\u0010\r\u001a\u00020\f\"\u0004\b\u0001\u0010\u0018\"\u0004\b\u0002\u0010\u0014*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00140\u00192\u0006\u0010\u001a\u001a\u0002H\u00182\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0016H\u0096\u0002¢\u0006\u0002\u0010\u001bR\u001e\u0010\u0006\u001a\u0012\u0012\u000e\u0012\f0\bR\b\u0012\u0004\u0012\u00028\u00000\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/selects/UnbiasedSelectImplementation;", "R", "Lkotlinx/coroutines/selects/SelectImplementation;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "clausesToRegister", "", "Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "doSelect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shuffleAndRegisterClauses", "", "invoke", "Lkotlinx/coroutines/selects/SelectClause0;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", com.tom_roush.pdfbox.pdmodel.a.d.i.m, "Lkotlinx/coroutines/selects/SelectClause2;", AutoTestConstant.PARAM, "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class r<R> extends l<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<l<R>.a> f17645a;

    static /* synthetic */ <R> Object a(r<R> r2, Continuation<? super R> r3) {
        Continuation<? super R> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        r2.b();
        return super.a(r4);
    }

    private final void b() {
        Collections.shuffle(this.f17645a);     // Catch: Throwable -> L10
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f17645a, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L10
    L5:
        if (r1.hasNext() == false) goto L8;
        l.a r2 = (l.a) ZeusTransformUtils.preCheckCast(r1.next(), l.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        l.a((l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.memorydata.plugin"), r2, false, 1, null);     // Catch: Throwable -> L10
        goto L5
    L8:
        this.f17645a.clear();
        return;
    L10:
        th = move-exception;
        this.f17645a.clear();
        throw th;
    }

    @Override // kotlinx.coroutines.selects.l
    public Object a(Continuation<? super R> r3) {
        return a(this, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.coroutines.selects.l, kotlinx.coroutines.selects.c
    public void a(f r11, Function1<? super Continuation<? super R>, ? extends Object> r12) {
        f r13 = (f) ZeusTransformUtils.wrapperContextForParams(r11, f.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        ((Collection) ZeusTransformUtils.preCheckCast(this.f17645a, Collection.class, "com.obric.memorydata.plugin")).add(new l.a((l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.memorydata.plugin"), r13.a(), r13.b(), r13.c(), o.a(), r8, r13.d()));
    }

    @Override // kotlinx.coroutines.selects.l, kotlinx.coroutines.selects.c
    public <Q> void a(h<? extends Q> r11, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> r12) {
        h r13 = (h) ZeusTransformUtils.wrapperContextForParams(r11, h.class, "com.obric.memorydata.plugin");
        Function2 r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r12, Function2.class, "com.obric.memorydata.plugin");
        ((Collection) ZeusTransformUtils.preCheckCast(this.f17645a, Collection.class, "com.obric.memorydata.plugin")).add(new l.a((l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.memorydata.plugin"), r13.a(), r13.b(), r13.c(), null, r8, r13.d()));
    }
}
