package com.obric.aiagent.platform.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/obric/aiagent/platform/depend/IBuildContext;", "", "getBuildId", "", "getBuildTime", "", "getBranchId", "getCommitId", "getBuildVariant", "Companion", "platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5950a = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/obric/aiagent/platform/depend/IBuildContext$Companion;", "Lcom/obric/aiagent/platform/depend/IBuildContext;", "<init>", "()V", "impl", "getImpl", "()Lcom/obric/aiagent/platform/depend/IBuildContext;", "impl$delegate", "Lkotlin/Lazy;", "getBuildId", "", "getBuildTime", "", "getBranchId", "getCommitId", "getBuildVariant", "platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ a f5951b = null;
        private static final Lazy<b> c = null;

        static {
            f5951b = new a();
            c = LazyKt.lazy($$Lambda$b$a$9UDhPuVkGbp4U7cvg9Qg_TwToYg.INSTANCE);
        }

        private a() {
        }

        private final b b() {
            return (b) ZeusTransformUtils.preCheckCast(c.getValue(), b.class, "com.obric.memorydata.plugin");
        }

        private static final b c() {
            com.obric.aiagent.platform.b r0 = com.obric.aiagent.platform.a.f5946a.a();
            if (r0 == null) goto L7;
            b r1 = r0.b();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return (b) ZeusTransformUtils.preCheckCast(com.ss.android.ugc.aweme.framework.services.f.a().a(b.class), b.class, "com.obric.memorydata.plugin");
        }

        public static /* synthetic */ b lambda$9UDhPuVkGbp4U7cvg9Qg_TwToYg() {
            return c();
        }

        @Override // com.obric.aiagent.platform.a.b
        public String a() {
            b r0 = b();
            if (r0 == null) goto L5;
            String r1 = r0.a();
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
        f5950a = a.f5951b;
    }

    String a();
}
