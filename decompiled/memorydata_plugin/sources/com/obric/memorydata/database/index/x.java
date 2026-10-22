package com.obric.memorydata.database.index;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00062\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/database/index/FirstCompletionWaitMs;", "", "<init>", "()V", "Observed", "Invalid", "Companion", "Lcom/obric/memorydata/database/index/FirstCompletionWaitMs$Invalid;", "Lcom/obric/memorydata/database/index/FirstCompletionWaitMs$Observed;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9446a = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/database/index/FirstCompletionWaitMs$Companion;", "", "<init>", "()V", "fromRawMs", "Lcom/obric/memorydata/database/index/FirstCompletionWaitMs;", EventBody.KEY_VALUE, "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final x a(long r3) {
            q r2 = q.f9432a.a(r3);
            if (r2 == null) goto L5;
            Object r4 = new c(r2.a(), null);
        L7:
            return (x) ZeusTransformUtils.preCheckCast(r4, x.class, "com.obric.memorydata.plugin");
        L5:
            r4 = b.f9447b;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/database/index/FirstCompletionWaitMs$Invalid;", "Lcom/obric/memorydata/database/index/FirstCompletionWaitMs;", "<init>", "()V", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends x {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f9447b = null;

        static {
            f9447b = new b();
        }

        private b() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/database/index/FirstCompletionWaitMs$Observed;", "Lcom/obric/memorydata/database/index/FirstCompletionWaitMs;", "duration", "Lcom/obric/memorydata/database/index/DurationMs;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDuration-Zcv5Jww", "()J", "J", "component1", "component1-Zcv5Jww", "copy", "copy-wXbnSwU", "(J)Lcom/obric/memorydata/database/index/FirstCompletionWaitMs$Observed;", "equals", "", "other", "", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends x {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f9448b;

        private c(long r2) {
            super(null);
            this.f9448b = r2;
        }

        public /* synthetic */ c(long r1, DefaultConstructorMarker r3) {
            this(r1);
        }

        public final long a() {
            return this.f9448b;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, c.class) == true) goto L8;
            return false;
        L8:
            c r8 = (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.memorydata.plugin");
            if (q.a(this.f9448b, r8.f9448b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return q.b(this.f9448b);
        }

        public String toString() {
            return "Observed(duration=" + q.a(this.f9448b) + ')';
        }
    }

    static {
        f9446a = new a(null);
    }

    private x() {
    }

    public /* synthetic */ x(DefaultConstructorMarker r1) {
        this();
    }
}
