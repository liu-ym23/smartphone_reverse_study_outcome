package com.ss.android.lark.image.impl.resource;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.entity.ReactionImage;
import com.ss.android.lark.image.impl.ImageErrorRecord;
import com.ss.android.lark.image.impl.PerfLoadPicHitPoint;
import com.ss.android.lark.image.impl.PerfLoadPicMonitor;
import com.ss.android.lark.image.impl.steam.SteamImageLoadTraceReporter;
import com.ss.android.lark.image.utils.b;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Locale;
import rkb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ResourceGlideListener<TranscodeType> implements g<Object, TranscodeType> {
    private final ListenerParams mParams;
    private PerfLoadPicHitPoint mPerfLoadPicHitPoint;
    private PerfLoadPicMonitor mPerfLoadPicMonitor;

    private String getImageId(Object r2) {
        if ((r2 instanceof AvatarImage) == false) goto L7;
        return ((AvatarImage) r2).getImageId();
    L7:
        if ((r2 instanceof EncryptImage) == false) goto L11;
        return ((EncryptImage) r2).getEncryptKey();
    L11:
        if ((r2 instanceof ReactionImage) == false) goto L15;
        return ((ReactionImage) r2).getReactionKey();
    L15:
        return String.valueOf(r2.hashCode());
    }

    public ResourceGlideListener(ListenerParams r3, Object r4) {
        this.mParams = r3;
        if (r3.a == false) goto L6;
        PerfLoadPicHitPoint r0 = new PerfLoadPicHitPoint();
        this.mPerfLoadPicHitPoint = r0;
        r0.startLoadPic(r3.b);
    L6:
        if (this.mPerfLoadPicMonitor != null) goto L8;
        this.mPerfLoadPicMonitor = new PerfLoadPicMonitor();
    L8:
        this.mPerfLoadPicMonitor.start(r3, r4);
    }

    @Override // rkb.g
    public boolean onLoadFailed(Exception r4, Object r5, Target<TranscodeType> r6, boolean r7) {
        Log.e("ResourceGlideListener", "load image failed, e:" + r4 + ", model:" + r5 + ", isFirstResource:" + r7);
        if ((r5 instanceof EncryptImage) == false) goto L5;
        ImageErrorRecord.INSTANCE.record(((EncryptImage) r5).getEncryptKey(), PerfLoadPicMonitor.Companion.getErrorResult(r4, r5));
    L5:
        ListenerParams.b r0 = this.mParams.h;
        if (r0 == null) goto L8;
        r0.a(r4);
    L8:
        SteamImageLoadTraceReporter.INSTANCE.glideError(r4, r5);
        ErrorResult r1 = PerfLoadPicMonitor.Companion.getErrorResult(r4, r5);
        if (b.a(LarkContext.getApplication(), r1) == false) goto L11;
        this.mPerfLoadPicMonitor.onException(r1, r5);
    L11:
        ImageLog.e(String.format(Locale.ROOT, "onException(%s, %s, %s, %s)", new Object[]{r4, r5, r6, Boolean.valueOf(r7)}));
        ImageLog.d("Glide onException thread = " + ThreadMethodProxy.currentThread());
        return false;
    }

    @Override // rkb.g
    public boolean onResourceReady(TranscodeType r3, Object r4, Target<TranscodeType> r5, DataSource r6, boolean r7) {
        ListenerParams.b r8 = this.mParams.h;
        if (r8 == null) goto L6;
        r8.b(r3, r4, r6, r7);
    L6:
        if (this.mParams.a == false) goto L8;
        PerfLoadPicHitPoint r9 = this.mPerfLoadPicHitPoint;
        String r10 = getImageId(r4);
        ListenerParams r0 = this.mParams;
        r9.loadPicSuccess(r10, r0.c, r0.d);
    L8:
        SteamImageLoadTraceReporter r11 = SteamImageLoadTraceReporter.INSTANCE;
        r11.remove(r11.getEncryptImageKeyByModel(r4));
        this.mPerfLoadPicMonitor.end(PerfLoadPicMonitor.Companion.getTrace(r4), r3, r6, r4);
        return false;
    }
}
