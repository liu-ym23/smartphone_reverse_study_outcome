package com.ss.android.lark.filedetail.impl.detail;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.FileUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.filedetail.impl.FileDetailFragment;
import com.ss.android.lark.filedetail.impl.open.FileOpenUtils;
import com.ss.android.lark.filedetail.impl.open.OpenFileParams;
import com.ss.android.lark.filedetailapi.container.IFileDetailPlugin;
import com.ss.android.lark.vfs.VFSFile;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p implements Runnable {
    public final /* synthetic */ FileContent a;
    public final /* synthetic */ FileTransmissionPresenter.b b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ OpenFileParams d;
    public final /* synthetic */ FileTransmissionPresenter e;

    public final void b() {
        if (this.a.isEncrypted() == true) goto L11;
        FileTransmissionPresenter.b r0 = this.b;
        if (r0 == null) goto L7;
        UICallbackExecutor.executeDelayed(((FileDetailFragment.c) r0).a.L, 300);
    L7:
        FileContent r1 = this.a;
        String r2 = r1.getFilePath();
        r1.getName();
        String r3 = sfb.c.a(r2);
        String r4 = FileOpenUtils.a(r3);
        VFSFile r5 = sfb.c.b().i(r3);
        if (TextUtils.isEmpty(r4) == true) goto L10;
        r1.setFilePath(r4);
        r5 = sfb.c.b().i(r4);
    L10:
        UICallbackExecutor.execute(new j(this, r1, r5));
        return;
    L11:
        FileContent r6 = this.a;
        String r7 = r6.getFilePath();
        String r8 = r6.getName();
        ((DecryptFileProcessor) DecryptFileProcessor.e.getValue()).a(this.e.l, r7, r8, new n(this, r6));
    }

    @Override // java.lang.Runnable
    public final void run() {
        b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public static void a(p r4, final FileContent r5, File r6) {
        String r0 = r4.e.n;
        String r1 = BuildConfig.FLAVOR;
        if (r0 != null) goto L5;
        r5.setMime(BuildConfig.FLAVOR);
    L7:
        if (com.ss.android.lark.filedetail.impl.open.c.b(r4.e.d(), r4.c, r5, r4.d) == false) goto L9;
        return;
    L9:
        if (r4.d.isSecret() == false) goto L26;
        final FileTransmissionPresenter r7 = r4.e;
        final OpenFileParams r8 = r4.d;
        r7.getClass();
        String r2 = r5.getFilePath();
        if (r2 == null) goto L14;
        r1 = r2;
    L14:
        Iterator r3 = ((ArrayList) FileDetailController.b).iterator();
    L16:
        if (r3.hasNext() == false) goto L25;
        IFileDetailPlugin r9 = (IFileDetailPlugin) r3.next();
        if ((r9 instanceof gfb.a) == true) goto L19;
        if (r9.canPreview(FileUtils.k(r1)) == false) goto L16;
        FileDetailController.c = r9;
        goto L25
    L19:
        FileUtils.k(r1);
        if (((gfb.a) r9).canPreview() == false) goto L16;
        FileDetailController.c = r9;
    L25:
        UICallbackExecutor.post(new h(r7, r5, r8));
        return;
    L26:
        r4.e.f(r4.c, r6, r5.getMime(), r4.e.i);
        return;
    L5:
        r5.setMime(r0);
        goto L7
    }

    public p(FileTransmissionPresenter r1, FileContent r2, FileDetailFragment.c r3, Context r4, OpenFileParams r5) {
        this.e = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
