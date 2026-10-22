package com.ss.android.lark.filedetail.impl.detail;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.constant.ChatFromType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FileHitPointUtil {
    public static final Lazy a = null;

    public static final class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;

        public final void a() {
            Lazy r0 = FileHitPointUtil.a;
            if (FileHitPointUtil.b(this.a).length() != 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L10;
            FileHitPointUtil.a(this.b);
            return;
        L10:
            return;
        L5:
            r1 = false;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(int r1, String r2, FileContent r3, String r4) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;

        public final void a() {
            Lazy r0 = FileHitPointUtil.a;
            if (FileHitPointUtil.b(this.a).length() != 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L10;
            FileHitPointUtil.a(this.b);
            return;
        L10:
            return;
        L5:
            r1 = false;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(int r1, String r2, FileContent r3, String r4) {
            this.a = r1;
            this.b = r2;
        }
    }

    public FileHitPointUtil() {
    }

    public static final String b(int r0) {
        switch(r0) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L5;
            case 6: goto L4;
            default: goto L3;
        };
    L3:
        return BuildConfig.FLAVOR;
    L4:
        return "favorites";
    L5:
        return "pin";
    L6:
        return ChatFromType.SEARCH;
    L7:
        return "chat_history";
    L8:
        return "thread";
    L9:
        return "main";
    }

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, FileHitPointUtil$chatDependency$2.INSTANCE);
    }

    public static final Chat a(String r0) {
        if (r0 == null) goto L6;
        ((hfb.b.d) a.getValue()).b();
        return null;
    L6:
        return null;
    }

    @JvmStatic
    public static final void c(String r2, FileContent r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "fileContent");
        Intrinsics.checkNotNullParameter(r5, "method");
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new a(r4, r2, r3, r5));
    }

    @JvmStatic
    public static final void d(String r1, FileContent r2, int r3, FileDownloadState r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "fileContent");
        Intrinsics.checkNotNullParameter(r4, "state");
        Intrinsics.checkNotNullParameter(r5, "method");
        if (r4 == FileDownloadState.DOWNLOADING) goto L5;
        return;
    L5:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new b(r3, r1, r2, r5));
    }
}
