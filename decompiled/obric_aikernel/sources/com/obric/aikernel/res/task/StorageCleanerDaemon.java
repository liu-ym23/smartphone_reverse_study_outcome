package com.obric.aikernel.res.task;

import android.system.Os;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.runtime.utils.d;
import java.io.File;
import java.text.SimpleDateFormat;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class StorageCleanerDaemon {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f5102e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PrmContext f5103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l0 f5104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Long f5105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StorageCleanerDaemon$receiver$1 f5106d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        private final Long a(String r10) {
            File r11 = new File(r10);
            if (r11.exists() == true) goto L11;
            File r12 = r11.getParentFile();
            if (r12 != null) goto L8;
            return null;
        L8:
            if (r12.exists() == true) goto L10;
            return null;
        L10:
            return Long.valueOf(Os.stat(r12.getPath()).st_atime);
        L11:
            return Long.valueOf(Os.stat(r10).st_atime);
        }

        private final String b(String r10, PackageResourceManager.PresmConfig r11) {
            long r12 = 1000;
            long r13 = System.currentTimeMillis() / r12;
            Long r14 = a(r10);
            if (r14 == null) goto L5;
            long r15 = r14.longValue();
        L6:
            long r16 = r13 - r15;
            StringBuilder r17 = new StringBuilder();
            r17.append(r10);
            r17.append(" needClean:");
            if (r16 <= r11.getAppConfig().getAutoCleanResourceInterval().invoke().longValue()) goto L9;
            boolean r18 = true;
        L10:
            r17.append(r18);
            r17.append(' ');
            DurationUnit r19 = DurationUnit.SECONDS;
            r17.append(Duration.m1433toStringimpl(DurationKt.toDuration(r16, r19)));
            r17.append('/');
            r17.append(Duration.m1433toStringimpl(DurationKt.toDuration(r11.getAppConfig().getAutoCleanResourceInterval().invoke().longValue(), r19)));
            r17.append(" lastUsage:");
            r17.append(SimpleDateFormat.getInstance().format(Long.valueOf(r15 * r12)));
            r17.append(' ');
            return r17.toString();
        L9:
            r18 = false;
            goto L10
        L5:
            r15 = r13;
            goto L6
        }

        public final boolean c(PackageResourceManager.PresmConfig r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "config");
            Intrinsics.checkNotNullParameter(r11, "f");
            long r12 = 1000;
            long r13 = r10.getAppConfig().getAutoCleanResourceInterval().invoke().longValue() / r12;
            long r14 = System.currentTimeMillis() / r12;
            Long r15 = a(r11);
            if (r15 == null) goto L5;
            long r16 = r15.longValue();
        L6:
            long r17 = r14 - r16;
            if (r17 <= r13) goto L9;
            boolean r18 = true;
        L10:
            d.f5417a.d(PackageResourceManager.TAG, "needClean " + r18 + ' ' + r17 + '-' + r16 + ' ' + r11);
            return r18;
        L9:
            r18 = false;
            goto L10
        L5:
            r16 = r14;
            goto L6
        }

        public final void d(String r10, File r11, PackageResourceManager.PresmConfig r12) {
            Intrinsics.checkNotNullParameter(r10, "src");
            Intrinsics.checkNotNullParameter(r11, "infoFile");
            Intrinsics.checkNotNullParameter(r12, "config");
            File r13 = new File(r10);
            if (r13.exists() == false) goto L11;
            FilesKt.appendText$default(r11, b(r10, r12), null, 2, null);
            if (r13.isDirectory() == false) goto L13;
            String[] r14 = r13.list();
            if (r14 == null) goto L14;
            int r15 = 0;
            int r16 = r14.length;
        L9:
            if (r15 >= r16) goto L15;
            String r17 = r14[r15];
            StorageCleanerDaemon.f5102e.d(r10 + '/' + r17, r11, r12);
            r15 = r15 + 1;
            goto L9
        L15:
            return;
        L14:
            return;
        L13:
            return;
        }
    }

    static {
        f5102e = new a(null);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.obric.aikernel.res.task.StorageCleanerDaemon$receiver$1] */
    public StorageCleanerDaemon(PrmContext r10, l0 r11) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        Intrinsics.checkNotNullParameter(r11, "scope");
        this.f5103a = r10;
        this.f5104b = r11;
        this.f5106d = new StorageCleanerDaemon$receiver$1(this);
    }

    public static final /* synthetic */ PrmContext a(StorageCleanerDaemon r10) {
        return r10.f5103a;
    }

    public static final /* synthetic */ StorageCleanerDaemon$receiver$1 b(StorageCleanerDaemon r10) {
        return r10.f5106d;
    }

    public static final /* synthetic */ l0 c(StorageCleanerDaemon r10) {
        return r10.f5104b;
    }

    public static final /* synthetic */ Object d(StorageCleanerDaemon r10, Continuation r11) {
        return r10.f(r11);
    }

    private final Object f(Continuation<? super Unit> r13) {
        if ((r13 instanceof StorageCleanerDaemon$tryClean$1) == false) goto L7;
        StorageCleanerDaemon$tryClean$1 r10 = (StorageCleanerDaemon$tryClean$1) r13;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r14 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r10.label;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        ResultKt.throwOnFailure(r14);
    L36:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r16 = r10.J$0;
        File r17 = (File) r10.L$1;
        StorageCleanerDaemon r18 = (StorageCleanerDaemon) r10.L$0;
        ResultKt.throwOnFailure(r14);
        File r19 = r17;
        StorageCleanerDaemon this = r18;
    L31:
        this.f5105c = Boxing.boxLong(r16);
        com.obric.aikernel.res.utils.a.f5222a.k(r19, String.valueOf(r16));
        goto L36
    L16:
        ResultKt.throwOnFailure(r14);
        r19 = new File(this.f5103a.getConfig().getRootDir(), "cleaner_last_check");
        if (this.f5105c == null) goto L19;
    L21:
        long r20 = System.currentTimeMillis();
        long r21 = this.f5103a.getConfig().getAppConfig().getAutoCleanResourceInterval().invoke().longValue() / ((long) 3);
        Long r22 = this.f5105c;
        if (r22 == null) goto L24;
        long r110 = r22.longValue();
    L26:
        if ((r20 - r110) <= r21) goto L32;
        PrmContext r23 = this.f5103a;
        r10.L$0 = this;
        r10.L$1 = r19;
        r10.J$0 = r20;
        r10.label = 1;
        if (PrmContext.clean$default(r23, false, r10, 1, null) != r12) goto L30;
        return r12;
    L30:
        r16 = r20;
        goto L31
    L32:
        PrmContext r111 = this.f5103a;
        r10.label = 2;
        if (r111.clean(false, r10) != r12) goto L36;
        return r12;
    L24:
        r110 = 0;
        goto L26
    L19:
        if (r19.exists() == false) goto L21;
        this.f5105c = StringsKt.toLongOrNull(FilesKt.readText$default(r19, null, 1, null));
    L7:
        r10 = new StorageCleanerDaemon$tryClean$1(this, r13);
        goto L8
    }

    public final void e() {
        h.d(this.f5104b, null, null, new StorageCleanerDaemon$init$1(this, null), 3, null);
    }
}
