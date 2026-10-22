package kotlinx.coroutines;

import kotlin.PublishedApi;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes3.dex */
@PublishedApi
@IgnoreJRERequirement
public final class j0 extends AbstractCoroutineContextElement implements r2<String> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f10599g = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f10600c;

    public static final class a implements CoroutineContext.Key<j0> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        f10599g = new a(null);
    }

    public j0(long r10) {
        super(f10599g);
        this.f10600c = r10;
    }

    @Override // kotlinx.coroutines.r2
    public /* bridge */ /* synthetic */ void F(CoroutineContext r10, String r11) {
        d0(r10, r11);
    }

    @Override // kotlinx.coroutines.r2
    public /* bridge */ /* synthetic */ String X(CoroutineContext r10) {
        return e0(r10);
    }

    public final long c0() {
        return this.f10600c;
    }

    public void d0(CoroutineContext r10, String r11) {
        Thread.currentThread().setName(r11);
    }

    public String e0(CoroutineContext r10) {
        k0 r11 = (k0) r10.get(k0.f10604g);
        if (r11 == null) goto L6;
        String r12 = r11.c0();
        if (r12 == null) goto L6;
    L7:
        Thread r13 = Thread.currentThread();
        String r14 = r13.getName();
        int r15 = StringsKt.lastIndexOf$default(r14, " @", 0, false, 6, null);
        if (r15 >= 0) goto L10;
        r15 = r14.length();
    L10:
        StringBuilder r16 = new StringBuilder((r12.length() + r15) + 10);
        String r17 = r14.substring(0, r15);
        Intrinsics.checkNotNullExpressionValue(r17, "this as java.lang.String…ing(startIndex, endIndex)");
        r16.append(r17);
        r16.append(" @");
        r16.append(r12);
        r16.append('#');
        r16.append(this.f10600c);
        String r18 = r16.toString();
        Intrinsics.checkNotNullExpressionValue(r18, "StringBuilder(capacity).…builderAction).toString()");
        r13.setName(r18);
        return r14;
    L6:
        r12 = "coroutine";
        goto L7
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof j0) == true) goto L9;
        return false;
    L9:
        if (this.f10600c == ((j0) r10).f10600c) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return Long.hashCode(this.f10600c);
    }

    public String toString() {
        return "CoroutineId(" + this.f10600c + ')';
    }
}
