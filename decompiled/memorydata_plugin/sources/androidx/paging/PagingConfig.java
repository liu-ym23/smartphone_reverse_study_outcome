package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bBA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0003\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/paging/PagingConfig;", "", "pageSize", "", "prefetchDistance", "enablePlaceholders", "", "initialLoadSize", "maxSize", "jumpThreshold", "(IIZIII)V", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PagingConfig {
    public static final Companion Companion = null;
    public static final int DEFAULT_INITIAL_PAGE_MULTIPLIER = 3;
    public static final int MAX_SIZE_UNBOUNDED = Integer.MAX_VALUE;
    public final boolean enablePlaceholders;
    public final int initialLoadSize;
    public final int jumpThreshold;
    public final int maxSize;
    public final int pageSize;
    public final int prefetchDistance;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002¨\u0006\u0007"}, d2 = {"Landroidx/paging/PagingConfig$Companion;", "", "()V", "DEFAULT_INITIAL_PAGE_MULTIPLIER", "", "MAX_SIZE_UNBOUNDED", "getMAX_SIZE_UNBOUNDED$annotations", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ void getMAX_SIZE_UNBOUNDED$annotations() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PagingConfig(int r10) {
        this(r10, 0, false, 0, 0, 0, 62, null);
    }

    public PagingConfig(int r10, int r11) {
        this(r10, r11, false, 0, 0, 0, 60, null);
    }

    public PagingConfig(int r10, int r11, boolean r12) {
        this(r10, r11, r12, 0, 0, 0, 56, null);
    }

    public PagingConfig(int r10, int r11, boolean r12, int r13) {
        this(r10, r11, r12, r13, 0, 0, 48, null);
    }

    public PagingConfig(int r10, int r11, boolean r12, int r13, int r14) {
        this(r10, r11, r12, r13, r14, 0, 32, null);
    }

    public PagingConfig(int r1, int r2, boolean r3, int r4, int r5, int r6) {
        this.pageSize = r1;
        this.prefetchDistance = r2;
        this.enablePlaceholders = r3;
        this.initialLoadSize = r4;
        this.maxSize = r5;
        this.jumpThreshold = r6;
        if (r3 == true) goto L9;
        if (r2 != 0) goto L9;
        throw new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in PagingData, so either placeholders must be enabled, or prefetch distance must be > 0.");
    L9:
        if (r5 == Integer.MAX_VALUE) goto L16;
        if (r5 >= ((r2 * 2) + r1)) goto L16;
        throw new IllegalArgumentException("Maximum size must be at least pageSize + 2*prefetchDist, pageSize=" + r1 + ", prefetchDist=" + r2 + ", maxSize=" + r5);
    L16:
        if (r6 == Integer.MIN_VALUE) goto L20;
        if (r6 > 0) goto L20;
        boolean r0 = false;
    L21:
        if (r0 == false) goto L24;
        return;
    L24:
        throw new IllegalArgumentException("jumpThreshold must be positive to enable jumps or COUNT_UNDEFINED to disable jumping.".toString());
    L20:
        r0 = true;
        goto L21
    }

    public /* synthetic */ PagingConfig(int r8, int r9, boolean r10, int r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L5;
        int r2 = r8;
    L7:
        if ((r14 & 4) == 0) goto L9;
        r10 = true;
    L9:
        boolean r3 = r10;
        if ((r14 & 8) == 0) goto L12;
        r11 = r8 * 3;
    L12:
        int r4 = r11;
        if ((r14 & 16) == 0) goto L15;
        r12 = Integer.MAX_VALUE;
    L15:
        int r5 = r12;
        if ((r14 & 32) == 0) goto L18;
        r13 = Integer.MIN_VALUE;
    L18:
        this(r8, r2, r3, r4, r5, r13);
        return;
    L5:
        r2 = r9;
        goto L7
    }
}
