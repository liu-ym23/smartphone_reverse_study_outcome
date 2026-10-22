package com.ss.android.lark.framework.assembly.sp;

import android.app.Application;
import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.launch.task.ILaunchTask;
import com.larksuite.framework.launch.task.LaunchMode;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.SpDefaultSpConfigProviderImpl;
import com.ss.android.lark.diskmanage.storage.KAFileEncryptFileSystem;
import com.ss.android.lark.diskmanage.storage.d;
import com.ss.android.lark.e;
import com.ss.android.lark.framework.assembly.logger.InitLogTask;
import com.ss.android.lark.g;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.FileAccessCompatManager;
import com.ss.android.lark.vfs.FileSystemManager;
import com.ss.android.lark.vfs.VFS;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00152\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0015B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0003J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u001c\u0010\u0010\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00130\u00120\u0011H\u0014J\n\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/framework/assembly/sp/InitUniStoreTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "", "<init>", "()V", "lastUid", "", "mUserListApi", "Lcom/ss/android/lark/passport_user/api/container/ILarkUserListApi;", "execute", "", "context", "Landroid/content/Context;", "initKVStorage", "initFileStorage", "getCurrentUserId", "getBuiltInDependency", "", "Ljava/lang/Class;", "Lcom/larksuite/framework/launch/task/ILaunchTask;", "getUserListApi", "Companion", "sp-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InitUniStoreTask extends AbstractLaunchTask<Object> {
    public String c;
    public yzb.b d;

    public static final class a {
    }

    static {
    }

    public final List<Class<? extends ILaunchTask<?>>> i() {
        ArrayList r0 = new ArrayList();
        r0.add(InitLogTask.class);
        return r0;
    }

    @Inject
    public InitUniStoreTask() {
    }

    public static final String j(InitUniStoreTask r2) {
        r2.getClass();
        int r0 = h28.a.a;
        String r1 = "";
        if (LaunchMode.UNAUTHORIZED != null) goto L6;
        String r3 = "";
    L12:
        if (r3 == null) goto L16;
        r1 = r3;
    L16:
        if (Intrinsics.areEqual(r1, r2.c) == true) goto L18;
        r2.c = r1;
        Log.i("InitUniStoreTask", "kv storage getUserId=".concat(r1));
    L18:
        return r1;
    L6:
        if (r2.d != null) goto L8;
        r2.d = (yzb.b) LarkContext.spiByDwarf(yzb.b.class);
    L8:
        yzb.b r4 = r2.d;
        if (r4 == null) goto L11;
        r3 = r4.c();
        goto L12
    L11:
        r3 = null;
        goto L12
    }

    public final void a(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        LarkKVStorage r1 = LarkKVStorage.a;
        c r2 = new c(this);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r2, "config");
        com.ss.android.lark.storage.b r3 = new com.ss.android.lark.storage.b(r2);
        g.a r4 = g.a;
        SpDefaultSpConfigProviderImpl r5 = (com.ss.android.lark.b) ClaymoreServiceLoader.loadFirstOrNull(com.ss.android.lark.b.class);
        if (r5 != null) goto L5;
        r5 = new SpDefaultSpConfigProviderImpl();
    L5:
        e r7 = r5.getSpConfig();
        if (r6 == null) goto L10;
        g.a = r3;
        g5c.b r8 = r7.a;
        Log.i("SpInit", "init sp creator: " + r8.type());
        r8.init(r6);
        g5c.c.a = r8;
        int r9 = com.lark.kmp.storage.e.a;
        Intrinsics.checkNotNullParameter(r6, "context");
        r6.getApplicationContext();
        com.ss.android.lark.storage.monitor.b.a.getClass();
        Intrinsics.checkNotNullParameter(r6, "context");
        com.ss.android.lark.storage.monitor.b.d = r6;
        com.ss.android.lark.framework.assembly.sp.a r0 = new com.ss.android.lark.framework.assembly.sp.a();
        Intrinsics.checkNotNullParameter(r0, "reporter");
        com.ss.android.lark.storage.monitor.b.b = r0;
        ExecutorService r10 = CoreThreadPool.getDefault().getCachedThreadPool();
        Intrinsics.checkNotNullParameter(r10, "handler");
        com.ss.android.lark.storage.monitor.b.c = r10;
        b r11 = new b(this);
        Application r12 = LarkFileStorage.a;
        Intrinsics.checkNotNullParameter(r11, "config");
        LarkFileStorage.b = r11;
        FileAccessCompatManager r13 = (FileAccessCompatManager) VFS.a.getValue();
        com.suite.lark.platform.component.storage.file.a r14 = new com.suite.lark.platform.component.storage.file.a();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "fileAccessCompat");
        FileAccessCompatManager.a r15 = (FileAccessCompatManager.a) r13.a.getValue();
        r15.getClass();
        Intrinsics.checkNotNullParameter(r14, "accessCompat");
        r15.b = r14;
        FileSystemManager.a r16 = FileSystemManager.a();
        r16.c(d.f(r6));
        r16.a(new KAFileEncryptFileSystem.KAFileEncryptFileSystemFactory(false, 1, null));
        r16.b(true);
        Log.i("InitUniStoreTask", "init unify storage success");
        return;
    L10:
        throw new IllegalArgumentException("context should not be null");
    }
}
