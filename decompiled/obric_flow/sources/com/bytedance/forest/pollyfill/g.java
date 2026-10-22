package com.bytedance.forest.pollyfill;

import com.bytedance.forest.model.w;
import com.bytedance.geckox.logger.DefaultLogger;
import com.bytedance.geckox.logger.GeckoLogger;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends AbsDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f4511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f4512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w f4513c;
    public final /* synthetic */ File d;
    public final /* synthetic */ a e;
    public final /* synthetic */ CountDownLatch f;
    public final /* synthetic */ String g;

    public g(i r5, Ref.ObjectRef r10, w r11, File r12, a r13, CountDownLatch r14, String r15) {
        this.f4511a = r5;
        this.f4512b = r10;
        this.f4513c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2, types: [com.bytedance.forest.pollyfill.a] */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.ss.android.socialbase.downloader.exception.BaseException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [T] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void a(DownloadInfo r11, BaseException r12) {
        if (Logger.a(r11) == false) goto L10;
        if (r11 == null) goto L10;
        String r5 = r11.f15808b;
        if (r12 == 0) goto L8;
        String r10 = r12.f15602b;
    L9:
        Logger.a("AbsDownloadListener", r11.l(), r11.P, "onFailed", androidx.constraintlayout.motion.widget.a.p("Name: ", r5, " because of : ", r10), false);
        goto L10
    L8:
        r10 = "unkown";
    L10:
        HashMap r13 = null;
        if (r11 == null) goto L13;
        ?? r14 = Integer.valueOf(r11.l());
    L14:
        this.f4512b.element = r14;
        if (r12 == 0) goto L20;
        com.bytedance.forest.model.c r15 = this.f4513c.s;
        r15.f4362c = r12.f15601a;
        if ((r12 instanceof DownloadHttpException) == false) goto L19;
        r15.d = ((DownloadHttpException) r12).d;
    L19:
        r15.f4367l = r12.f15602b;
    L20:
        StringBuilder r16 = new StringBuilder("download failed, httpHeaders:");
        if (r11 == null) goto L23;
        r13 = r11.f15807a1;
    L23:
        r16.append(r13);
        String r17 = r16.toString();
        CopyOnWriteArrayList r18 = GeckoLogger.f4756a;
        if (r18.size() != 0) goto L26;
        GeckoLogger.f4757b.a("res-downloaderdepend", r17, r12);
    L30:
        if (r12 != 0) goto L33;
        r12 = new Exception();
    L33:
        this.e.c(true, r12);
        this.f.countDown();
        return;
    L26:
        Iterator r19 = r18.iterator();
    L28:
        if (r19.hasNext() == false) goto L30;
        ((DefaultLogger) ((com.bytedance.geckox.logger.Logger) r19.next())).a("res-downloaderdepend", r17, r12);
        goto L28
    L13:
        r14 = 0;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void d(DownloadInfo r10) {
        super.d(r10);
        if (r10 == null) goto L5;
        T r11 = Integer.valueOf(r10.l());
    L6:
        this.f4512b.element = r11;
        this.e.f4502j.f4430b = true;
        com.bytedance.forest.utils.d.c(this.f4511a.f4518a.g, 3, "res-downloaderdepend", null, null, new DownloadDepender$fetchFile$absDownloadListener$1$onPause$1(this), 28);
        return;
    L5:
        r11 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void g(DownloadInfo r5) {
        super.g(r5);
        if (r5 == null) goto L5;
        T r10 = Integer.valueOf(r5.l());
    L6:
        this.f4512b.element = r10;
        this.e.a();
        this.f.countDown();
        return;
    L5:
        r10 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void l(DownloadInfo r10) {
        if (Logger.a(r10) == false) goto L6;
        if (r10 == null) goto L6;
        Logger.a("AbsDownloadListener", r10.l(), r10.P, "onSuccessed", "Name: " + r10.f15808b + " " + r10.U, false);
    L6:
        if (r10 == null) goto L8;
        T r5 = Integer.valueOf(r10.l());
    L9:
        this.f4512b.element = r5;
        JSONObject r11 = i.f4516b;
        File r12 = this.d;
        i r13 = this.f4511a;
        w r14 = this.f4513c;
        boolean r15 = r13.d(r14, r12);
        a r16 = this.e;
        if (r15 == false) goto L12;
        r13.f4518a.b(new String[]{"cdn_download_finish"});
        r13.c(r14, r16, r10);
    L13:
        this.f.countDown();
        return;
    L12:
        r16.c(true, new IOException("fetch succeeded but file not exists"));
        goto L13
    L8:
        r5 = 0;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void m(DownloadInfo r5) {
        super.m(r5);
        if (r5 == null) goto L5;
        T r10 = Integer.valueOf(r5.l());
    L6:
        this.f4512b.element = r10;
        this.f4511a.f4518a.b(new String[]{"cdn_download_internal_start"});
        return;
    L5:
        r10 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener
    public final void a(DownloadInfo r5) {
        super.a(r5);
        Ref.ObjectRef r10 = this.f4512b;
        if (r5 == null) goto L5;
        T r11 = Integer.valueOf(r5.l());
    L6:
        r10.element = r11;
        a r12 = this.e;
        r12.f4519a = FetchTask$State.f;
        r12.d = null;
        this.f.countDown();
        return;
    L5:
        r11 = 0;
        goto L6
    }
}
