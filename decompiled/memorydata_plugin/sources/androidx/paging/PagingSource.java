package androidx.paging;

import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u0002\"#B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0015\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0017H&¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u0010J+\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0014\u0010\u001f\u001a\u00020\u00102\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0014\u0010!\u001a\u00020\u00102\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u000fR\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Landroidx/paging/PagingSource;", "Key", "", "Value", "()V", "invalid", "", "getInvalid", "()Z", "invalidateCallbackCount", "", "getInvalidateCallbackCount$paging_common", "()I", "invalidateCallbackTracker", "Landroidx/paging/InvalidateCallbackTracker;", "Lkotlin/Function0;", "", "jumpingSupported", "getJumpingSupported", "keyReuseSupported", "getKeyReuseSupported", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Object;", "invalidate", "load", "Landroidx/paging/PagingSource$LoadResult;", TrackerImpl.PARAMS, "Landroidx/paging/PagingSource$LoadParams;", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerInvalidatedCallback", "onInvalidatedCallback", "unregisterInvalidatedCallback", "LoadParams", "LoadResult", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PagingSource<Key, Value> {
    private final InvalidateCallbackTracker<Function0<Unit>> invalidateCallbackTracker;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u0010*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0002:\u0004\u000f\u0010\u0011\u0012B\u0017\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00018\u0002X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0001\u0003\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Landroidx/paging/PagingSource$LoadParams;", "Key", "", "loadSize", "", "placeholdersEnabled", "", "(IZ)V", "key", "getKey", "()Ljava/lang/Object;", "getLoadSize", "()I", "getPlaceholdersEnabled", "()Z", "Append", "Companion", "Prepend", "Refresh", "Landroidx/paging/PagingSource$LoadParams$Append;", "Landroidx/paging/PagingSource$LoadParams$Prepend;", "Landroidx/paging/PagingSource$LoadParams$Refresh;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class LoadParams<Key> {
        public static final Companion Companion = null;
        private final int loadSize;
        private final boolean placeholdersEnabled;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000*\b\b\u0003\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00028\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0016\u0010\u0004\u001a\u00028\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/paging/PagingSource$LoadParams$Append;", "Key", "", "Landroidx/paging/PagingSource$LoadParams;", "key", "loadSize", "", "placeholdersEnabled", "", "(Ljava/lang/Object;IZ)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Append<Key> extends LoadParams<Key> {
            private final Key key;

            public Append(Key r2, int r3, boolean r4) {
                Intrinsics.checkNotNullParameter(r2, "key");
                super(r3, r4, null);
                this.key = r2;
            }

            @Override // androidx.paging.PagingSource.LoadParams
            public Key getKey() {
                return this.key;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0003\u0010\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u0001H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/paging/PagingSource$LoadParams$Companion;", "", "()V", "create", "Landroidx/paging/PagingSource$LoadParams;", "Key", "loadType", "Landroidx/paging/LoadType;", "key", "loadSize", "", "placeholdersEnabled", "", "(Landroidx/paging/LoadType;Ljava/lang/Object;IZ)Landroidx/paging/PagingSource$LoadParams;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

                static {
                    int[] r0 = new int[LoadType.values().length];
                    r0[LoadType.REFRESH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
                L11:
                    r0[LoadType.PREPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
                L15:
                    r0[LoadType.APPEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
                L6:
                    $EnumSwitchMapping$0 = r0;
                }
            }

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            public final <Key> LoadParams<Key> create(LoadType r2, Key r3, int r4, boolean r5) {
                Intrinsics.checkNotNullParameter(r2, "loadType");
                int r1 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
                if (r1 != 1) goto L5;
                Object r6 = new Refresh(r3, r4, r5);
            L20:
                return (LoadParams) ZeusTransformUtils.preCheckCast(r6, LoadParams.class, "com.obric.memorydata.plugin");
            L5:
                if (r1 != 2) goto L7;
                if (r3 == null) goto L17;
                r6 = new Prepend(r3, r4, r5);
                goto L20
            L17:
                throw new IllegalArgumentException("key cannot be null for prepend".toString());
            L7:
                if (r1 != 3) goto L13;
                if (r3 == null) goto L11;
                r6 = new Append(r3, r4, r5);
                goto L20
            L11:
                throw new IllegalArgumentException("key cannot be null for append".toString());
            L13:
                throw new NoWhenBranchMatchedException();
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000*\b\b\u0003\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00028\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0016\u0010\u0004\u001a\u00028\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/paging/PagingSource$LoadParams$Prepend;", "Key", "", "Landroidx/paging/PagingSource$LoadParams;", "key", "loadSize", "", "placeholdersEnabled", "", "(Ljava/lang/Object;IZ)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Prepend<Key> extends LoadParams<Key> {
            private final Key key;

            public Prepend(Key r2, int r3, boolean r4) {
                Intrinsics.checkNotNullParameter(r2, "key");
                super(r3, r4, null);
                this.key = r2;
            }

            @Override // androidx.paging.PagingSource.LoadParams
            public Key getKey() {
                return this.key;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000*\b\b\u0003\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00018\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/paging/PagingSource$LoadParams$Refresh;", "Key", "", "Landroidx/paging/PagingSource$LoadParams;", "key", "loadSize", "", "placeholdersEnabled", "", "(Ljava/lang/Object;IZ)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Refresh<Key> extends LoadParams<Key> {
            private final Key key;

            public Refresh(Key r2, int r3, boolean r4) {
                super(r3, r4, null);
                this.key = r2;
            }

            @Override // androidx.paging.PagingSource.LoadParams
            public Key getKey() {
                return this.key;
            }
        }

        static {
            Companion = new Companion(null);
        }

        private LoadParams(int r1, boolean r2) {
            this.loadSize = r1;
            this.placeholdersEnabled = r2;
        }

        public /* synthetic */ LoadParams(int r1, boolean r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        public abstract Key getKey();

        public final int getLoadSize() {
            return this.loadSize;
        }

        public final boolean getPlaceholdersEnabled() {
            return this.placeholdersEnabled;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0002:\u0003\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0004\u0082\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Landroidx/paging/PagingSource$LoadResult;", "Key", "", "Value", "()V", "Error", "Invalid", "Page", "Landroidx/paging/PagingSource$LoadResult$Error;", "Landroidx/paging/PagingSource$LoadResult$Invalid;", "Landroidx/paging/PagingSource$LoadResult$Page;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class LoadResult<Key, Value> {

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\b\b\u0004\u0010\u0001*\u00020\u0002*\b\b\u0005\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u0006HÆ\u0003J\u001f\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Landroidx/paging/PagingSource$LoadResult$Error;", "Key", "", "Value", "Landroidx/paging/PagingSource$LoadResult;", "throwable", "", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Error<Key, Value> extends LoadResult<Key, Value> {
            private final Throwable throwable;

            public Error(Throwable r2) {
                Intrinsics.checkNotNullParameter(r2, "throwable");
                super(null);
                this.throwable = r2;
            }

            public static /* synthetic */ Error copy$default(Error r0, Throwable r1, int r2, Object r3) {
                if ((r2 & 1) == 0) goto L6;
                r1 = r0.throwable;
            L6:
                return r0.copy(r1);
            }

            public final Throwable component1() {
                return this.throwable;
            }

            public final Error<Key, Value> copy(Throwable r1) {
                Intrinsics.checkNotNullParameter(r1, "throwable");
                return new Error(r1);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, Error.class) == true) goto L8;
                return false;
            L8:
                Error r6 = (Error) ZeusTransformUtils.preCheckCast(r5, Error.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.throwable, r6.throwable) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final Throwable getThrowable() {
                return this.throwable;
            }

            public int hashCode() {
                return this.throwable.hashCode();
            }

            public String toString() {
                return StringsKt.trimMargin$default("LoadResult.Error(\n                    |   throwable: " + this.throwable + "\n                    |) ", null, 1, null);
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\b\b\u0004\u0010\u0001*\u00020\u0002*\b\b\u0005\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Landroidx/paging/PagingSource$LoadResult$Invalid;", "Key", "", "Value", "Landroidx/paging/PagingSource$LoadResult;", "()V", "toString", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Invalid<Key, Value> extends LoadResult<Key, Value> {
            public Invalid() {
                super(null);
            }

            public String toString() {
                return "LoadResult.Invalid";
            }
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 '*\b\b\u0004\u0010\u0001*\u00020\u0002*\b\b\u0005\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005:\u0001'B)\b\u0016\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00050\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00018\u0004¢\u0006\u0002\u0010\nB;\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00050\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00018\u0004\u0012\b\b\u0003\u0010\u000b\u001a\u00020\f\u0012\b\b\u0003\u0010\r\u001a\u00020\f¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00050\u0007HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00018\u0004HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001a\u001a\u0004\u0018\u00018\u0004HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010\u001b\u001a\u00020\fHÆ\u0003J\t\u0010\u001c\u001a\u00020\fHÆ\u0003JV\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00050\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u00042\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\r\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\"\u001a\u00020\fHÖ\u0001J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00050$H\u0096\u0002J\b\u0010%\u001a\u00020&H\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0015\u0010\t\u001a\u0004\u0018\u00018\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\b\u001a\u0004\u0018\u00018\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015¨\u0006("}, d2 = {"Landroidx/paging/PagingSource$LoadResult$Page;", "Key", "", "Value", "Landroidx/paging/PagingSource$LoadResult;", "", "data", "", "prevKey", "nextKey", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;)V", "itemsBefore", "", "itemsAfter", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;II)V", "getData", "()Ljava/util/List;", "getItemsAfter", "()I", "getItemsBefore", "getNextKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getPrevKey", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;II)Landroidx/paging/PagingSource$LoadResult$Page;", "equals", "", "other", "hashCode", "iterator", "", "toString", "", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Page<Key, Value> extends LoadResult<Key, Value> implements Iterable<Value>, KMappedMarker {
            public static final int COUNT_UNDEFINED = Integer.MIN_VALUE;
            public static final Companion Companion = null;
            private static final Page EMPTY = null;
            private final List<Value> data;
            private final int itemsAfter;
            private final int itemsBefore;
            private final Key nextKey;
            private final Key prevKey;

            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r0\u0006\"\b\b\u0006\u0010\f*\u00020\u0001\"\b\b\u0007\u0010\r*\u00020\u0001H\u0000¢\u0006\u0002\b\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Landroidx/paging/PagingSource$LoadResult$Page$Companion;", "", "()V", "COUNT_UNDEFINED", "", "EMPTY", "Landroidx/paging/PagingSource$LoadResult$Page;", "", "getEMPTY$paging_common$annotations", "getEMPTY$paging_common", "()Landroidx/paging/PagingSource$LoadResult$Page;", "empty", "Key", "Value", "empty$paging_common", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                    this();
                }

                public static /* synthetic */ void getEMPTY$paging_common$annotations() {
                }

                public final <Key, Value> Page<Key, Value> empty$paging_common() {
                    Page<Key, Value> r1 = getEMPTY$paging_common();
                    Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.paging.PagingSource.LoadResult.Page<Key of androidx.paging.PagingSource.LoadResult.Page.Companion.empty, Value of androidx.paging.PagingSource.LoadResult.Page.Companion.empty>");
                    return r1;
                }

                public final Page getEMPTY$paging_common() {
                    return Page.access$getEMPTY$cp();
                }
            }

            static {
                Companion = new Companion(null);
                EMPTY = new Page(CollectionsKt.emptyList(), null, null, 0, 0);
            }

            public Page(List<? extends Value> r7, Key r8, Key r9) {
                List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r1, "data");
                this(r1, r8, r9, Integer.MIN_VALUE, Integer.MIN_VALUE);
            }

            public Page(List<? extends Value> r3, Key r4, Key r5, int r6, int r7) {
                List<Value> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r8, "data");
                super(null);
                this.data = r8;
                this.prevKey = r4;
                this.nextKey = r5;
                this.itemsBefore = r6;
                this.itemsAfter = r7;
                boolean r2 = false;
                if (r6 == Integer.MIN_VALUE) goto L7;
                if (r6 >= 0) goto L7;
                boolean r9 = false;
            L8:
                if (r9 == false) goto L17;
                if (r7 == Integer.MIN_VALUE) goto L11;
                if (r7 >= 0) goto L11;
            L12:
                if (r2 == false) goto L15;
                return;
            L15:
                throw new IllegalArgumentException("itemsAfter cannot be negative".toString());
            L11:
                r2 = true;
                goto L12
            L17:
                throw new IllegalArgumentException("itemsBefore cannot be negative".toString());
            L7:
                r9 = true;
                goto L8
            }

            public /* synthetic */ Page(List r7, Object r8, Object r9, int r10, int r11, int r12, DefaultConstructorMarker r13) {
                List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
                if ((r12 & 8) == 0) goto L5;
                int r4 = Integer.MIN_VALUE;
            L7:
                if ((r12 & 16) == 0) goto L9;
                int r5 = Integer.MIN_VALUE;
            L10:
                this(r1, r8, r9, r4, r5);
                return;
            L9:
                r5 = r11;
                goto L10
            L5:
                r4 = r10;
                goto L7
            }

            public static final /* synthetic */ Page access$getEMPTY$cp() {
                return EMPTY;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Page copy$default(Page r3, List r4, Object r5, Object r6, int r7, int r8, int r9, Object r10) {
                List<Value> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
                if ((r9 & 1) == 0) goto L6;
                r11 = r3.data;
            L6:
                if ((r9 & 2) == 0) goto L8;
                r5 = r3.prevKey;
            L8:
                Object r12 = r5;
                if ((r9 & 4) == 0) goto L11;
                r6 = r3.nextKey;
            L11:
                Object r0 = r6;
                if ((r9 & 8) == 0) goto L14;
                r7 = r3.itemsBefore;
            L14:
                int r1 = r7;
                if ((r9 & 16) == 0) goto L17;
                r8 = r3.itemsAfter;
            L17:
                List<Value> r13 = r11;
                return r3.copy(r13, r12, r0, r1, r8);
            }

            public final List<Value> component1() {
                return this.data;
            }

            public final Key component2() {
                return this.prevKey;
            }

            public final Key component3() {
                return this.nextKey;
            }

            public final int component4() {
                return this.itemsBefore;
            }

            public final int component5() {
                return this.itemsAfter;
            }

            public final Page<Key, Value> copy(List<? extends Value> r7, Key r8, Key r9, int r10, int r11) {
                List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r1, "data");
                return new Page(r1, r8, r9, r10, r11);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, Page.class) == true) goto L8;
                return false;
            L8:
                Page r6 = (Page) ZeusTransformUtils.preCheckCast(r5, Page.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.data, r6.data) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.prevKey, r6.prevKey) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.nextKey, r6.nextKey) == true) goto L18;
                return false;
            L18:
                if (this.itemsBefore == r6.itemsBefore) goto L21;
                return false;
            L21:
                if (this.itemsAfter == r6.itemsAfter) goto L23;
                return false;
            L23:
                return true;
            }

            public final List<Value> getData() {
                return this.data;
            }

            public final int getItemsAfter() {
                return this.itemsAfter;
            }

            public final int getItemsBefore() {
                return this.itemsBefore;
            }

            public final Key getNextKey() {
                return this.nextKey;
            }

            public final Key getPrevKey() {
                return this.prevKey;
            }

            public int hashCode() {
                int r0 = this.data.hashCode() * 31;
                Key r1 = this.prevKey;
                int r2 = 0;
                if (r1 != null) goto L5;
                int r3 = 0;
            L6:
                int r4 = (r0 + r3) * 31;
                Key r5 = this.nextKey;
                if (r5 == null) goto L11;
                r2 = r5.hashCode();
            L11:
                return ((((r4 + r2) * 31) + Integer.hashCode(this.itemsBefore)) * 31) + Integer.hashCode(this.itemsAfter);
            L5:
                r3 = r1.hashCode();
                goto L6
            }

            @Override // java.lang.Iterable
            public Iterator<Value> iterator() {
                return (Iterator) ZeusTransformUtils.preCheckCast(this.data.listIterator(), Iterator.class, "com.obric.memorydata.plugin");
            }

            public String toString() {
                return StringsKt.trimMargin$default("LoadResult.Page(\n                    |   data size: " + this.data.size() + "\n                    |   first Item: " + CollectionsKt.firstOrNull(this.data) + "\n                    |   last Item: " + CollectionsKt.lastOrNull(this.data) + "\n                    |   nextKey: " + this.nextKey + "\n                    |   prevKey: " + this.prevKey + "\n                    |   itemsBefore: " + this.itemsBefore + "\n                    |   itemsAfter: " + this.itemsAfter + "\n                    |) ", null, 1, null);
            }
        }

        private LoadResult() {
        }

        public /* synthetic */ LoadResult(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PagingSource() {
        this.invalidateCallbackTracker = new InvalidateCallbackTracker((Function1) ZeusTransformUtils.preCheckCast(PagingSource$invalidateCallbackTracker$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), null, 2, 0 == true ? 1 : 0);
    }

    public final boolean getInvalid() {
        return this.invalidateCallbackTracker.getInvalid$paging_common();
    }

    public final int getInvalidateCallbackCount$paging_common() {
        return this.invalidateCallbackTracker.callbackCount$paging_common();
    }

    public boolean getJumpingSupported() {
        return false;
    }

    public boolean getKeyReuseSupported() {
        return false;
    }

    public abstract Key getRefreshKey(PagingState<Key, Value> r1);

    public final void invalidate() {
        if (this.invalidateCallbackTracker.invalidate$paging_common() == false) goto L13;
        Logger r2 = LoggerKt.getLOGGER();
        boolean r3 = true;
        if (r2 != null) goto L7;
    L9:
        r3 = false;
    L10:
        if (r3 == false) goto L14;
        r2.log(3, "Invalidated PagingSource " + this, null);
        return;
    L14:
        return;
    L7:
        if (r2.isLoggable(3) != true) goto L9;
    }

    public abstract Object load(LoadParams<Key> r1, Continuation<? super LoadResult<Key, Value>> r2);

    public final void registerInvalidatedCallback(Function0<Unit> r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onInvalidatedCallback");
        this.invalidateCallbackTracker.registerInvalidatedCallback$paging_common(r4);
    }

    public final void unregisterInvalidatedCallback(Function0<Unit> r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onInvalidatedCallback");
        this.invalidateCallbackTracker.unregisterInvalidatedCallback$paging_common(r4);
    }
}
