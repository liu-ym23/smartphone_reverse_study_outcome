package kotlinx.coroutines;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0018B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/CoroutineId;", "Lkotlinx/coroutines/ThreadContextElement;", "", "Lkotlin/coroutines/AbstractCoroutineContextElement;", OaidModel.KEY_ID, "", "(J)V", "getId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "toString", "updateThreadContext", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class aj extends AbstractCoroutineContextElement implements cv<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17208a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f17209b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineId$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineId;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class a implements CoroutineContext.Key<aj> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f17208a = new a(null);
    }

    public aj(long r4) {
        super((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(f17208a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));
        this.f17209b = r4;
    }

    public final long a() {
        return this.f17209b;
    }

    public String a(CoroutineContext r10) {
        ak r11 = (ak) ZeusTransformUtils.preCheckCast(((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r10, CoroutineContext.class, "com.obric.memorydata.plugin")).get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(ak.f17210a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), ak.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L6;
        String r12 = r11.a();
        if (r12 == null) goto L6;
    L7:
        Thread r0 = Thread.currentThread();
        String r2 = r0.getName();
        int r1 = StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), " @", 0, false, 6, null);
        if (r1 >= 0) goto L10;
        r1 = r2.length();
    L10:
        StringBuilder r4 = new StringBuilder((r12.length() + r1) + 10);
        String r3 = r2.substring(0, r1);
        Intrinsics.checkNotNullExpressionValue(r3, "substring(...)");
        r4.append(r3);
        r4.append(" @");
        r4.append(r12);
        r4.append('#');
        r4.append(this.f17209b);
        String r9 = r4.toString();
        Intrinsics.checkNotNullExpressionValue(r9, "toString(...)");
        r0.setName(r9);
        return r2;
    L6:
        r12 = "coroutine";
        goto L7
    }

    @Override // kotlinx.coroutines.cv
    public /* synthetic */ void a(CoroutineContext r3, String r4) {
        a2((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(CoroutineContext r2, String r3) {
        CoroutineContext r1 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin");
        Thread.currentThread().setName(r3);
    }

    @Override // kotlinx.coroutines.cv
    public /* synthetic */ String b(CoroutineContext r3) {
        return a((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, aj.class) == true) goto L8;
        return false;
    L8:
        aj r8 = (aj) ZeusTransformUtils.preCheckCast(r7, aj.class, "com.obric.memorydata.plugin");
        if (this.f17209b == r8.f17209b) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return Long.hashCode(this.f17209b);
    }

    public String toString() {
        return "CoroutineId(" + this.f17209b + ')';
    }
}
