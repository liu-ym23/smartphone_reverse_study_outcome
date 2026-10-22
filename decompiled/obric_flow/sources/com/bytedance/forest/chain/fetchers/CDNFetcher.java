package com.bytedance.forest.chain.fetchers;

import android.os.AsyncTask;
import androidx.annotation.Keep;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.ErrorInfo$Type;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.w;
import com.bytedance.forest.utils.p;
import com.bytedance.forest.utils.q;
import java.io.File;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J3\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/forest/chain/fetchers/CDNFetcher;", "Lcom/bytedance/forest/chain/fetchers/ResourceFetcher;", "Lcom/bytedance/forest/Forest;", "forest", "<init>", "(Lcom/bytedance/forest/Forest;)V", "Lcom/bytedance/forest/model/Request;", "request", "Lcom/bytedance/forest/model/w;", "response", "Lkotlin/Function1;", "", "callback", "doFetch", "(Lcom/bytedance/forest/model/Request;Lcom/bytedance/forest/model/w;Lkotlin/jvm/functions/Function1;)V", "fetchSync", "(Lcom/bytedance/forest/model/Request;Lcom/bytedance/forest/model/w;)V", "fetchAsync", "cancel", "()V", "Lcom/bytedance/forest/pollyfill/j;", "fetchTask", "Lcom/bytedance/forest/pollyfill/j;", "Companion", "com/bytedance/forest/chain/fetchers/c", "forest_release"}, k = 1, mv = {1, 4, 0})
public final class CDNFetcher extends ResourceFetcher {
    public static final c Companion = null;
    public static final String DIR_NAME = "rl_resource_offline";
    public static final String TAG = "CDNFetcher";
    private com.bytedance.forest.pollyfill.j fetchTask;

    static {
        Companion = new c();
    }

    public CDNFetcher(Forest r5) {
        super(r5);
    }

    public static final /* synthetic */ void access$doFetch(CDNFetcher r5, Request r10, w r11, Function1 r12) {
        r5.doFetch(r10, r11, r12);
    }

    private final void doFetch(Request r12, final w r13, final Function1<? super w, Unit> r14) {
        boolean r5 = true;
        if (StringsKt.isBlank(r12.getUrl()) == false) goto L6;
        com.bytedance.forest.model.c r11 = r13.s;
        ErrorInfo$Type r15 = ErrorInfo$Type.e;
        r11.getClass();
        r11.f4360a += r11.a(r15, 1, "CDN Url Blank");
        r14.invoke(r13);
        return;
    L6:
        File r10 = new File(getForest().getApplication().getCacheDir(), DIR_NAME);
        if (r10.exists() == true) goto L10;
        r10.mkdirs();
    L10:
        if (r12.getUri$forest_release().isHierarchical() == true) goto L13;
        com.bytedance.forest.model.c r16 = r13.s;
        ErrorInfo$Type r17 = ErrorInfo$Type.e;
        r16.getClass();
        r16.f4360a += r16.a(r17, 2, "cdn Url is not Hierarchical");
        r14.invoke(r13);
        return;
    L13:
        getContext$forest_release().b(new String[]{"cdn_start"});
        Lazy r18 = com.bytedance.forest.pollyfill.b.f4507a;
        getForest();
        com.bytedance.forest.utils.e r19 = getContext$forest_release();
        com.bytedance.forest.pollyfill.m r110 = r12.getNetDepender$forest_release();
        Function1<Boolean, Unit> r20 = new AnonymousClass1(r13, r14);
        Request r21 = r13.f4441q;
        if (r21.getOnlyLocal() == false) goto L16;
    L21:
        if (r5 == true) goto L23;
    L25:
        com.bytedance.forest.pollyfill.a r111 = new com.bytedance.forest.pollyfill.a(r20, r13, r21, r110, r5, r19, r13, r19);
        r110.a(r13, r111, r5);
        com.bytedance.forest.pollyfill.a r112 = r111;
    L26:
        this.fetchTask = r112;
        return;
    L23:
        if (r21.getOnlyOnline() == false) goto L25;
        ErrorInfo$Type r113 = ErrorInfo$Type.e;
        com.bytedance.forest.model.c r114 = r13.s;
        r114.getClass();
        r114.f4360a += r114.a(r113, 3, "only local or disable cdn cache");
        r20.invoke(Boolean.FALSE);
        r112 = null;
        goto L26
    L16:
        if (q.b() == true) goto L18;
    L20:
        r5 = false;
        goto L21
    L18:
        if (r21.isASync() == true) goto L20;
        goto L20
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void cancel() {
        com.bytedance.forest.pollyfill.j r5 = this.fetchTask;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.f4520b == true) goto L10;
        r5.g.f4441q.getNetDepender$forest_release().b(r5);
        r5.a();
        return;
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void fetchAsync(final Request r10, final w r11, final Function1<? super w, Unit> r12) {
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 4, TAG, "start to fetchAsync from cdn", true, null, "cdn_total_start", 16);
        getContext$forest_release().b(new String[]{"cdn_total_start", "cdn_switch_thread_start"});
        com.bytedance.forest.utils.g r5 = q.f4656a;
        p r13 = new p(new C01741(this, r10, r11, r12));
        AsyncTask.THREAD_POOL_EXECUTOR.execute(r13);
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void fetchSync(Request r10, w r11) {
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 4, TAG, "start to fetchSync from cdn", true, null, "cdn_total_start", 16);
        getContext$forest_release().b(new String[]{"cdn_total_start"});
        doFetch(r10, r11, new C01751(this));
    }
}
