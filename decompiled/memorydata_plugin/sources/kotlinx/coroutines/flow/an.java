package kotlinx.coroutines.flow;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/flow/SharingStarted;", "", "command", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "Companion", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface an {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17422a = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/flow/SharingStarted$Companion;", "", "()V", "Eagerly", "Lkotlinx/coroutines/flow/SharingStarted;", "getEagerly", "()Lkotlinx/coroutines/flow/SharingStarted;", "Lazily", "getLazily", "WhileSubscribed", "stopTimeoutMillis", "", "replayExpirationMillis", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f17423a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final an f17424b = null;
        private static final an c = null;

        static {
            f17423a = new a();
            f17424b = (an) ZeusTransformUtils.preCheckCast(new ao(), an.class, "com.obric.memorydata.plugin");
            c = (an) ZeusTransformUtils.preCheckCast(new ap(), an.class, "com.obric.memorydata.plugin");
        }

        private a() {
        }

        public static /* synthetic */ an a(a r0, long r1, long r3, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = 0;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = Long.MAX_VALUE;
        L9:
            return r0.a(r1, r3);
        }

        public final an a() {
            return f17424b;
        }

        public final an a(long r1, long r3) {
            return (an) ZeusTransformUtils.preCheckCast(new aq(r1, r3), an.class, "com.obric.memorydata.plugin");
        }

        public final an b() {
            return c;
        }
    }

    static {
        f17422a = a.f17423a;
    }

    i<SharingCommand> a(ar<Integer> r1);
}
