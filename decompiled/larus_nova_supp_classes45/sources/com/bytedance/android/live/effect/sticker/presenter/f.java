package com.bytedance.android.live.effect.sticker.presenter;

import android.text.TextUtils;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.ss.android.ugc.effectmanager.DownloadableModelSupport;
import com.ss.android.ugc.effectmanager.EffectManager;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IEffectDownloadProgressListener;
import com.ss.android.ugc.effectmanager.effect.listener.IIsTagNeedUpdatedListener;
import com.ss.android.ugc.effectmanager.effect.listener.IUpdateTagListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class f implements com.bytedance.android.live.effect.api.k {
    public final EffectManager a;
    public final List<com.bytedance.android.live.effect.api.k.f> b;
    public final List<String> c;

    public class a implements IEffectDownloadProgressListener {
        public final /* synthetic */ String a;
        public final /* synthetic */ com.bytedance.android.live.effect.api.k.f b;
        public final /* synthetic */ f c;

        public final void onStart(Effect r1) {
        }

        public final void onSuccess(Object r5) {
            final Effect r6 = (Effect) r5;
            ExecutorService r0 = TTExecutors.getNormalExecutor();
            final String r1 = this.a;
            final com.bytedance.android.live.effect.api.k.f r2 = this.b;
            r0.submit(new com.bytedance.android.live.effect.sticker.presenter.a(this, r6, r1, r2));
        }

        public final void onFail(Effect r6, final ExceptionResult r7) {
            this.c.a.deleteEffect(r6);
            final Sticker r8 = com.bytedance.android.live.effect.sticker.d.b(r6);
            r8.setDownloading(false);
            Iterator r0 = ((ArrayList) this.c.b).iterator();
        L4:
            if (r0.hasNext() == false) goto L7;
            final com.bytedance.android.live.effect.api.k.f r1 = (com.bytedance.android.live.effect.api.k.f) r0.next();
            Scheduler r2 = AndroidSchedulers.mainThread();
            final String r3 = this.a;
            r2.scheduleDirect(new b(r1, r3, r8, r7));
            goto L4
        L7:
            if (this.b == null) goto L11;
            Scheduler r4 = AndroidSchedulers.mainThread();
            final com.bytedance.android.live.effect.api.k.f r5 = this.b;
            final String r9 = this.a;
            r4.scheduleDirect(new c(r5, r9, r8, r7));
            return;
        }

        public a(f r1, String r2, com.bytedance.android.live.effect.api.k.f r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }

        public final void onProgress(Effect r2, int r3, long r4) {
            com.bytedance.android.live.effect.api.k.f r5 = this.b;
            if ((r5 instanceof com.bytedance.android.live.effect.api.k.g) == false) goto L6;
            ((com.bytedance.android.live.effect.api.k.g) r5).onProgress(r3, r4);
            return;
        }
    }

    public f(LiveEffectContextFactoryDelegate$Type r1) {
        this.a = com.bytedance.android.live.effect.api.u.a(r1).getEffectManager();
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final boolean e(Effect r3) {
        if (r3 != null) goto L6;
        return true;
    L6:
        if (DownloadableModelSupport.isInitialized() == false) goto L10;
        return DownloadableModelSupport.getInstance().isEffectReady(this.a, r3);
    L10:
        return this.a.isEffectDownloaded(r3);
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final boolean q(Sticker r3) {
        if (r3 != null) goto L6;
        return true;
    L6:
        if (DownloadableModelSupport.isInitialized() == false) goto L10;
        return DownloadableModelSupport.getInstance().isEffectReady(this.a, com.bytedance.android.live.effect.sticker.d.a(r3));
    L10:
        return this.a.isEffectDownloaded(com.bytedance.android.live.effect.sticker.d.a(r3));
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void b(String r3, String r4, IIsTagNeedUpdatedListener r5) {
        if (this.a == null) goto L11;
        if (r3 == null) goto L11;
        if (r4 == null) goto L11;
        if (TextUtils.equals("NULL", r4.toUpperCase()) == true) goto L11;
        this.a.isTagUpdated(r3, r4, r5);
        return;
    L11:
        r5.onTagNeedNotUpdate();
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void g(String r4, Sticker r5, com.bytedance.android.live.effect.api.k.f r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getEffect() != null) goto L6;
        return;
    L6:
        if (r5.getEffect().getFileUrl() != null) goto L8;
        return;
    L8:
        if (r5.getEffect().getFileUrl().getUrlList() != null) goto L10;
        return;
    L10:
        if (r5.getEffect().getFileUrl().getUrlList().isEmpty() == false) goto L13;
        return;
    L13:
        if (q(r5) == false) goto L15;
        return;
    L15:
        r5.getUnzipPath();
        this.a.fetchEffect(com.bytedance.android.live.effect.sticker.d.a(r5), new a(this, r4, r6));
        r5.setDownloading(true);
        Iterator r0 = ((ArrayList) this.b).iterator();
    L17:
        if (r0.hasNext() == false) goto L19;
        ((com.bytedance.android.live.effect.api.k.f) r0.next()).Z(r4, r5);
        goto L17
    L19:
        if (r6 == null) goto L27;
        r6.Z(r4, r5);
        return;
    }

    @Override // com.bytedance.android.live.effect.api.k
    public final void n(String r2, String r3, IUpdateTagListener r4) {
        EffectManager r0 = this.a;
        if (r0 == null) goto L8;
        if (r2 == null) goto L9;
        if (r3 == null) goto L10;
        r0.updateTag(r2, r3, r4);
        return;
    L10:
        return;
    L9:
        return;
    }
}
