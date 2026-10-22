package com.obric.aikernel.res.task;

import android.content.Context;
import android.content.Intent;
import android.system.Os;
import com.bytedance.apm.util.f;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.runtime.utils.d;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.al;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u000b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0011\u0010\u0010\u001a\u00020\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/obric/aikernel/res/task/StorageCleanerDaemon;", "", "ctx", "Lcom/obric/aikernel/res/PrmContext;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lcom/obric/aikernel/res/PrmContext;Lkotlinx/coroutines/CoroutineScope;)V", "lastCheckMills", "", "Ljava/lang/Long;", "receiver", "com/obric/aikernel/res/task/StorageCleanerDaemon$receiver$1", "Lcom/obric/aikernel/res/task/StorageCleanerDaemon$receiver$1;", "destroy", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "tryClean", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6101a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PrmContext f6102b;
    private final al c;
    private Long d;
    private final C0267b e;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n¨\u0006\u0012"}, d2 = {"Lcom/obric/aikernel/res/task/StorageCleanerDaemon$Companion;", "", "()V", "getLastUseTime", "", f.f1488a, "", "(Ljava/lang/String;)Ljava/lang/Long;", "loggerUsage", "config", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "meetCleanThreshold", "", "printUsageTimes", "", "src", "infoFile", "Ljava/io/File;", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final Long a(String r3) {
            File r2 = new File(r3);
            if (r2.exists() == true) goto L13;
            File r4 = r2.getParentFile();
            if (r4 != null) goto L8;
            return null;
        L8:
            if (r4.exists() == false) goto L10;
            Long r5 = Long.valueOf(Os.stat(r4.getPath()).st_atime);
        L12:
            return r5;
        L10:
            r5 = (Long) ZeusTransformUtils.preCheckCast(null, Long.class, "com.obric.memorydata.plugin");
            goto L12
        L13:
            return Long.valueOf(Os.stat(r3).st_atime);
        }

        private final String a(String r11, PackageResourceManager.PresmConfig r12) {
            long r2 = 1000;
            long r0 = System.currentTimeMillis() / r2;
            Long r10 = a(r11);
            if (r10 == null) goto L5;
            long r4 = r10.longValue();
        L6:
            long r1 = r0 - r4;
            StringBuilder r13 = new StringBuilder().append(r11).append(" needClean:");
            if (r1 <= ((Number) ZeusTransformUtils.preCheckCast(r12.getAppConfig().getAutoCleanResourceInterval().invoke(), Number.class, "com.obric.memorydata.plugin")).longValue()) goto L9;
            boolean r14 = true;
        L11:
            return r13.append(r14).append(' ').append(Duration.m2796toStringimpl(DurationKt.toDuration(r1, DurationUnit.SECONDS))).append('/').append(Duration.m2796toStringimpl(DurationKt.toDuration(((Number) ZeusTransformUtils.preCheckCast(r12.getAppConfig().getAutoCleanResourceInterval().invoke(), Number.class, "com.obric.memorydata.plugin")).longValue(), DurationUnit.SECONDS))).append(" lastUsage:").append(SimpleDateFormat.getInstance().format(Long.valueOf(r4 * r2))).append(' ').toString();
        L9:
            r14 = false;
            goto L11
        L5:
            r4 = r0;
            goto L6
        }

        public final void a(String r7, File r8, PackageResourceManager.PresmConfig r9) {
            Intrinsics.checkNotNullParameter(r7, "src");
            Intrinsics.checkNotNullParameter(r8, "infoFile");
            Intrinsics.checkNotNullParameter(r9, "config");
            File r0 = new File(r7);
            if (r0.exists() == false) goto L11;
            FilesKt.appendText$default(r8, a(r7, r9), null, 2, null);
            if (r0.isDirectory() == false) goto L13;
            String[] r6 = r0.list();
            if (r6 == null) goto L14;
            int r1 = 0;
            int r2 = r6.length;
        L9:
            if (r1 >= r2) goto L15;
            b.f6101a.a(r7 + '/' + r6[r1], r8, r9);
            r1 = r1 + 1;
            goto L9
        L15:
            return;
        L14:
            return;
        L13:
            return;
        }

        public final boolean a(PackageResourceManager.PresmConfig r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, "config");
            Intrinsics.checkNotNullParameter(r8, f.f1488a);
            long r2 = 1000;
            long r0 = ((Number) ZeusTransformUtils.preCheckCast(r7.getAppConfig().getAutoCleanResourceInterval().invoke(), Number.class, "com.obric.memorydata.plugin")).longValue() / r2;
            long r4 = System.currentTimeMillis() / r2;
            Long r6 = a(r8);
            if (r6 == null) goto L5;
            long r9 = r6.longValue();
        L6:
            long r5 = r4 - r9;
            if (r5 <= r0) goto L9;
            boolean r1 = true;
        L10:
            d.f6216a.a(PackageResourceManager.TAG, "needClean " + r1 + ' ' + r5 + '-' + r9 + ' ' + r8);
            return r1;
        L9:
            r1 = false;
            goto L10
        L5:
            r9 = r4;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.res.task.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/aikernel/res/task/StorageCleanerDaemon$receiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0267b extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f6103a;

        C0267b(b r1) {
            this.f6103a = r1;
        }

        public void onReceive(Context r8, Intent r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
            i.a(b.c(this.f6103a), null, null, (Function2) ZeusTransformUtils.preCheckCast(new StorageCleanerDaemon$receiver$1$onReceive$1(this.f6103a, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        }
    }

    static {
        f6101a = new a(null);
    }

    public b(PrmContext r3, al r4) {
        al r5 = (al) ZeusTransformUtils.wrapperContextForParams(r4, al.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "ctx");
        Intrinsics.checkNotNullParameter(r5, "scope");
        this.f6102b = r3;
        this.c = r5;
        this.e = new C0267b(this);
    }

    public static final /* synthetic */ PrmContext a(b r0) {
        return r0.f6102b;
    }

    public static final /* synthetic */ Object a(b r2, Continuation r3) {
        return r2.a((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(Continuation<? super Unit> r14) {
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, StorageCleanerDaemon$tryClean$1.class) == false) goto L7;
        StorageCleanerDaemon$tryClean$1 r0 = (StorageCleanerDaemon$tryClean$1) ZeusTransformUtils.preCheckCast(r15, StorageCleanerDaemon$tryClean$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r16);
    L36:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r4 = r0.J$0;
        File r13 = (File) ZeusTransformUtils.preCheckCast(r0.L$1, File.class, "com.obric.memorydata.plugin");
        b r1 = (b) ZeusTransformUtils.preCheckCast(r0.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r16);
        File r17 = r13;
        b this = r1;
    L31:
        this.d = Boxing.boxLong(r4);
        com.obric.aikernel.res.utils.a.f6155a.b(r17, String.valueOf(r4));
        goto L36
    L16:
        ResultKt.throwOnFailure(r16);
        r17 = new File(this.f6102b.getConfig().getRootDir(), "cleaner_last_check");
        if (this.d == null) goto L19;
    L21:
        long r7 = System.currentTimeMillis();
        long r9 = ((Number) ZeusTransformUtils.preCheckCast(this.f6102b.getConfig().getAppConfig().getAutoCleanResourceInterval().invoke(), Number.class, "com.obric.memorydata.plugin")).longValue() / ((long) 3);
        Long r5 = this.d;
        if (r5 == null) goto L24;
        long r11 = r5.longValue();
    L26:
        if ((r7 - r11) <= r9) goto L32;
        PrmContext r6 = this.f6102b;
        r0.L$0 = this;
        r0.L$1 = r17;
        r0.J$0 = r7;
        r0.label = 1;
        if (PrmContext.clean$default(r6, false, r0, 1, null) != r2) goto L30;
        return r2;
    L30:
        r4 = r7;
        goto L31
    L32:
        PrmContext r18 = this.f6102b;
        r0.label = 2;
        if (r18.clean(false, r0) != r2) goto L36;
        return r2;
    L24:
        r11 = 0;
        goto L26
    L19:
        if (r17.exists() == false) goto L21;
        this.d = StringsKt.toLongOrNull(FilesKt.readText$default(r17, null, 1, null));
    L7:
        r0 = new StorageCleanerDaemon$tryClean$1(this, r15);
        goto L8
    }

    public static final /* synthetic */ C0267b b(b r0) {
        return r0.e;
    }

    public static final /* synthetic */ al c(b r0) {
        return r0.c;
    }

    public final void a() {
        i.a(this.c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new StorageCleanerDaemon$init$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
