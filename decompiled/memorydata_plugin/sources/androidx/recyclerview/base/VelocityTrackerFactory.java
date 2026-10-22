package androidx.recyclerview.base;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/recyclerview/base/VelocityTrackerFactory;", "", "()V", "Companion", "OUIRecyclerViewX_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VelocityTrackerFactory {
    public static final Companion Companion = null;
    public static final int VELOCITY_TRACKER_IMPL_OPTIMIZED = 2;
    public static final int VELOCITY_TRACKER_IMPL_SYSTEM = 1;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/recyclerview/base/VelocityTrackerFactory$Companion;", "", "()V", "VELOCITY_TRACKER_IMPL_OPTIMIZED", "", "VELOCITY_TRACKER_IMPL_SYSTEM", "create", "Landroidx/recyclerview/base/VelocityTracker;", "context", "Landroid/content/Context;", "impl", "OUIRecyclerViewX_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final VelocityTracker create(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "context");
            return create(r4, 1);
        }

        @JvmStatic
        public final VelocityTracker create(Context r2, int r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "context");
            if (r3 != 1) goto L5;
            Object r4 = ZeusTransformUtils.preCheckCast(new SystemVelocityTrackerAdapter(), VelocityTracker.class, "com.obric.memorydata.plugin");
        L8:
            return (VelocityTracker) r4;
        L5:
            if (r3 != 2) goto L10;
            r4 = ZeusTransformUtils.preCheckCast(new FluidVelocityTracker(r1), VelocityTracker.class, "com.obric.memorydata.plugin");
            goto L8
        L10:
            throw new RuntimeException("impl is not supported");
        }
    }

    static {
        Companion = new Companion(null);
    }

    private VelocityTrackerFactory() {
    }

    @JvmStatic
    public static final VelocityTracker create(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return Companion.create(r3);
    }

    @JvmStatic
    public static final VelocityTracker create(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return Companion.create(r4, r3);
    }
}
