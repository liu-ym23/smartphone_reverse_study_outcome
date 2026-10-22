package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u0002\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J-\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Landroidx/paging/RemoteMediator;", "Key", "", "Value", "()V", "initialize", "Landroidx/paging/RemoteMediator$InitializeAction;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Landroidx/paging/RemoteMediator$MediatorResult;", "loadType", "Landroidx/paging/LoadType;", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/LoadType;Landroidx/paging/PagingState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "InitializeAction", "MediatorResult", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class RemoteMediator<Key, Value> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/paging/RemoteMediator$InitializeAction;", "", "(Ljava/lang/String;I)V", "LAUNCH_INITIAL_REFRESH", "SKIP_INITIAL_REFRESH", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum InitializeAction extends Enum<InitializeAction> {
        private static final /* synthetic */ InitializeAction[] $VALUES = null;
        public static final InitializeAction LAUNCH_INITIAL_REFRESH = null;
        public static final InitializeAction SKIP_INITIAL_REFRESH = null;

        private static final /* synthetic */ InitializeAction[] $values() {
            return new InitializeAction[]{LAUNCH_INITIAL_REFRESH, SKIP_INITIAL_REFRESH};
        }

        static {
            LAUNCH_INITIAL_REFRESH = new InitializeAction("LAUNCH_INITIAL_REFRESH", 0);
            SKIP_INITIAL_REFRESH = new InitializeAction("SKIP_INITIAL_REFRESH", 1);
            $VALUES = $values();
        }

        private InitializeAction(String r1, int r2) {
            super(r1, r2);
        }

        public static InitializeAction valueOf(String r2) {
            return (InitializeAction) ZeusTransformUtils.preCheckCast(Enum.valueOf(InitializeAction.class, r2), InitializeAction.class, "com.obric.memorydata.plugin");
        }

        public static InitializeAction[] values() {
            return (InitializeAction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), InitializeAction[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Landroidx/paging/RemoteMediator$MediatorResult;", "", "()V", "Error", "Success", "Landroidx/paging/RemoteMediator$MediatorResult$Error;", "Landroidx/paging/RemoteMediator$MediatorResult$Success;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class MediatorResult {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/paging/RemoteMediator$MediatorResult$Error;", "Landroidx/paging/RemoteMediator$MediatorResult;", "throwable", "", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Error extends MediatorResult {
            private final Throwable throwable;

            public Error(Throwable r2) {
                Intrinsics.checkNotNullParameter(r2, "throwable");
                super(null);
                this.throwable = r2;
            }

            public final Throwable getThrowable() {
                return this.throwable;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/paging/RemoteMediator$MediatorResult$Success;", "Landroidx/paging/RemoteMediator$MediatorResult;", "endOfPaginationReached", "", "(Z)V", "()Z", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Success extends MediatorResult {
            private final boolean endOfPaginationReached;

            public Success(boolean r2) {
                super(null);
                this.endOfPaginationReached = r2;
            }

            public final boolean endOfPaginationReached() {
                return this.endOfPaginationReached;
            }
        }

        private MediatorResult() {
        }

        public /* synthetic */ MediatorResult(DefaultConstructorMarker r1) {
            this();
        }
    }

    public RemoteMediator() {
    }

    static /* synthetic */ <Key, Value> Object initialize$suspendImpl(RemoteMediator<Key, Value> r1, Continuation<? super InitializeAction> r2) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin");
        return InitializeAction.LAUNCH_INITIAL_REFRESH;
    }

    public Object initialize(Continuation<? super InitializeAction> r3) {
        return initialize$suspendImpl(this, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public abstract Object load(LoadType r1, PagingState<Key, Value> r2, Continuation<? super MediatorResult> r3);
}
