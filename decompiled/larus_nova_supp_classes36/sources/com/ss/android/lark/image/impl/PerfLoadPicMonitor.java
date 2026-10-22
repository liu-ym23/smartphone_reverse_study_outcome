package com.ss.android.lark.image.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bumptech.glide.load.engine.GlideException;
import com.bytedance.lark.pb.basic.v1.Trace;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.appcontext.applifecycle.a0;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.a;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.entity.PassThroughImage;
import com.ss.android.lark.image.entity.ReactionImage;
import com.ss.android.lark.image.entity.VideoImage;
import com.ss.android.lark.image.impl.preload.ImagePreloadManager;
import com.ss.android.lark.image.impl.preload.PreloadResult;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.perf.BasePerfMonitor;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.LarkContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import rkb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001b\u001c\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ.\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001c\u0010\u0015\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/image/impl/PerfLoadPicMonitor;", "Lcom/ss/android/lark/monitor/perf/BasePerfMonitor;", "<init>", "()V", "mShowImageCostData", "Lcom/ss/android/lark/image/impl/PerfLoadPicMonitor$ShowImageCostData;", "start", "", "params", "Lcom/ss/android/lark/image/entity/ListenerParams;", "model", "", "end", "trace", "Lcom/bytedance/lark/pb/basic/v1/Trace;", "resource", "dataSource", "Lcom/ss/android/lark/image/api/DataSource;", "onException", "errorResult", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "getLoadType", "Lcom/ss/android/lark/image/entity/ListenerParams$LoadType;", "getResourceSize", "", "getImageType", "", "ShowImageCostData", "Companion", "MonitorRequestListener", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class PerfLoadPicMonitor extends BasePerfMonitor {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private ShowImageCostData mShowImageCostData;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/image/impl/PerfLoadPicMonitor$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_UNKNOWN_ERROR_CODE", "", "getErrorResult", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "model", "getTrace", "Lcom/bytedance/lark/pb/basic/v1/Trace;", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Trace getTrace(Object r2) {
            if ((r2 instanceof EncryptImage) == false) goto L6;
            return ((EncryptImage) r2).getTrace();
        L6:
            if ((r2 instanceof PassThroughImage) == true) goto L11;
            return null;
        L11:
            return ((PassThroughImage) r2).getTrace();
        }

        public final ErrorResult getErrorResult(Exception r3, Object r4) {
            if ((r4 instanceof EncryptImage) == false) goto L6;
            ErrorResult r5 = ((EncryptImage) r4).getErrorResult();
        L12:
            if (r5 != null) goto L19;
            r5 = new ErrorResult(r3);
            if (r3 != null) goto L16;
        L18:
            r5.setErrorCode(701005);
            Log.e("PerfLoadPicMonitor", "getErrorResult, exception is:" + r3);
            goto L19
        L16:
            if ((r3 instanceof GlideException) == false) goto L18;
            r5.setErrorCode(((GlideException) r3).getErrorCode());
        L19:
            return r5;
        L6:
            if ((r4 instanceof PassThroughImage) == false) goto L9;
            r5 = ((PassThroughImage) r4).getErrorResult();
            goto L12
        L9:
            if ((r4 instanceof AvatarImage) == false) goto L11;
            r5 = ((AvatarImage) r4).getErrorResult();
            goto L12
        L11:
            r5 = null;
            goto L12
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J<\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0016J>\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\nH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/image/impl/PerfLoadPicMonitor$MonitorRequestListener;", "Lcom/ss/android/lark/image/api/RequestListener;", "", "listenerParams", "Lcom/ss/android/lark/image/entity/ListenerParams;", "<init>", "(Lcom/ss/android/lark/image/entity/ListenerParams;)V", "monitor", "Lcom/ss/android/lark/image/impl/PerfLoadPicMonitor;", "onLoadFailed", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "model", "target", "Lcom/ss/android/lark/image/api/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/ss/android/lark/image/api/DataSource;", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class MonitorRequestListener implements g<Object, Object> {
        private final ListenerParams listenerParams;
        private final PerfLoadPicMonitor monitor;

        public MonitorRequestListener(ListenerParams r3) {
            this.listenerParams = r3;
            PerfLoadPicMonitor r0 = new PerfLoadPicMonitor();
            this.monitor = r0;
            if (r3 == null) goto L6;
            r0.start(r3, null);
            return;
        }

        @Override // rkb.g
        public boolean onLoadFailed(Exception r1, Object r2, Target<Object> r3, boolean r4) {
            this.monitor.onException(PerfLoadPicMonitor.Companion.getErrorResult(r1, r2), r2);
            ListenerParams r5 = this.listenerParams;
            if (r5 == null) goto L9;
            ListenerParams.b r6 = r5.h;
            if (r6 == null) goto L10;
            r6.a(r1);
            return false;
        L10:
            return false;
        L9:
            return false;
        }

        @Override // rkb.g
        public boolean onResourceReady(Object r2, Object r3, Target<Object> r4, DataSource r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r5, "dataSource");
            this.monitor.end(PerfLoadPicMonitor.Companion.getTrace(r3), r2, r5, r3);
            ListenerParams r7 = this.listenerParams;
            if (r7 == null) goto L9;
            ListenerParams.b r8 = r7.h;
            if (r8 == null) goto L10;
            r8.b(r2, r3, r5, r6);
            return false;
        L10:
            return false;
        L9:
            return false;
        }
    }

    @Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\b\u0001\u0018\u0000 E2\u00020\u0001:\u0001EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010)J\u001a\u0010*\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u0002012\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u000204H\u0016J \u00105\u001a\u00020&2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u000207H\u0016J\u0010\u0010:\u001a\u0002012\u0006\u00103\u001a\u000204H\u0016J\u001e\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020)0<2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u001e\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020)0<2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0014\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020)0<H\u0002J&\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020)0@2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010A\u001a\u00020\u0005H\u0002J\u001c\u0010B\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00072\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0012\u0010C\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0014\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020)0<H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006F"}, d2 = {"Lcom/ss/android/lark/image/impl/PerfLoadPicMonitor$ShowImageCostData;", "Lcom/ss/android/lark/monitor/perf/BasePerfMonitor$TimePerfData;", "<init>", "()V", "appreciableKey", "", "listenerParams", "Lcom/ss/android/lark/image/entity/ListenerParams;", "preloadResult", "Lcom/ss/android/lark/image/impl/preload/PreloadResult;", "resourceSize", "", "getResourceSize", "()J", "setResourceSize", "(J)V", "colorSpace", "colorType", "timeAfterAppStart", "timeAfterForeground", "loadType", "Lcom/ss/android/lark/image/entity/ListenerParams$LoadType;", "getLoadType", "()Lcom/ss/android/lark/image/entity/ListenerParams$LoadType;", "setLoadType", "(Lcom/ss/android/lark/image/entity/ListenerParams$LoadType;)V", "imageType", "getImageType", "()Ljava/lang/String;", "setImageType", "(Ljava/lang/String;)V", "trace", "Lcom/bytedance/lark/pb/basic/v1/Trace;", "getTrace", "()Lcom/bytedance/lark/pb/basic/v1/Trace;", "setTrace", "(Lcom/bytedance/lark/pb/basic/v1/Trace;)V", "start", "", "params", "model", "", "end", "errorResult", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "executeReportTask", "reportTask", "Ljava/lang/Runnable;", "isMuteReport", "", "getEventName", "platformType", "", "generateData", "metrics", "Lorg/json/JSONObject;", "category", "extra", "needReport", "getLatencyDetail", "", "getClientLatency", "getExtraCategory", "getExtraMetric", "", "imageKey", "getImageKey", "getImageKeyByModel", "getSpanCost", "Companion", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class ShowImageCostData extends BasePerfMonitor.b {
        public static final int $stable = 0;
        public static final Companion Companion = null;
        private String appreciableKey;
        private String colorSpace;
        private String colorType;
        private String imageType;
        private ListenerParams listenerParams;
        private ListenerParams.LoadType loadType;
        private PreloadResult preloadResult;
        private long resourceSize;
        private long timeAfterAppStart;
        private long timeAfterForeground;
        private Trace trace;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/image/impl/PerfLoadPicMonitor$ShowImageCostData$Companion;", "", "<init>", "()V", "EVENT_NAME_IMAGE_EMPTY_COST", "", "METRIC_KEY_LATENCY", "CATEGORY_KEY_SCENE", "CATEGORY_KEY_BIZ_SCENE", "EXTRA_KEY_TO_STARTUP", "EXTRA_KEY_TO_FOREGROUND", "EXTRA_METRIC_RESOURCE_CONTENT_LENGTH", "EXTRA_CATEGORY_FROM_TYPE", "EXTRA_CATEGORY_IMAGE_TYPE", "EXTRA_CATEGORY_CHAT_TYPE", "EXTRA_CATEGORY_LOAD_TYPE", "EXTRA_CATEGORY_COLOR_SPACE", "EXTRA_CATEGORY_COLOR_TYPE", "EXTRA_METRIC_RESOURCE_WIDTH", "EXTRA_METRIC_RESOURCE_HEIGHT", "EXTRA_METRIC_RESOURCE_FRAMES", "EXTRA_METRIC_LOAD_WIDTH", "EXTRA_METRIC_LOAD_HEIGHT", "EXTRA_METRIC_MESSAGE_ID", "EXTRA_METRIC_IMAGE_KEY", "EXTRA_METRIC_MEDIA_IS_ORIGIN_TYPE", "EXTRA_METRIC_RESOURCE_HASH", "EXTRA_METRIC_FORMAT_HEADER", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
            $stable = 8;
        }

        @Override // com.ss.android.lark.monitor.perf.BasePerfMonitor.a
        public String getEventName(int r1) {
            return "user_image_empty_cost";
        }

        @Override // com.ss.android.lark.monitor.perf.BasePerfMonitor.b, com.ss.android.lark.monitor.perf.BasePerfMonitor.a
        public boolean needReport(int r1) {
            return false;
        }

        private final Map<String, Object> getExtraCategory() {
            HashMap r0 = new HashMap();
            ListenerParams r1 = this.listenerParams;
            if (r1 == null) goto L5;
            r0.put("from_type", Integer.valueOf(r1.k.getValue()));
            r0.put("chat_type", Integer.valueOf(r1.l.getValue()));
            r0.put("load_type", Integer.valueOf(this.loadType.getValue()));
            r0.put("image_type", this.imageType);
            r0.put("color_type", this.colorType);
            r0.put("color_space", this.colorSpace);
        L5:
            PreloadResult r2 = this.preloadResult;
            if (r2 == null) goto L8;
            r0.put("preload_result", r2.getState().getValue());
            r0.put("preloading_duration", Integer.valueOf(r2.getPreloadingDuration()));
            r0.put("preload_scene", r2.getScene());
        L8:
            return r0;
        }

        private final Map<String, Object> getSpanCost() {
            HashMap r0 = new HashMap();
            Trace r1 = this.trace;
            if (r1 == null) goto L15;
            Iterator r2 = r1.spans.iterator();
        L6:
            if (r2.hasNext() == false) goto L15;
            Trace.Span r3 = (Trace.Span) r2.next();
            if (TextUtils.isEmpty(r3.name) == true) goto L6;
            Long r4 = r3.duration_millis;
            if (r4 == null) goto L6;
            r0.put(r3.name, r4);
            if (CollectionUtils.isEmpty(r3.attributes) == true) goto L6;
            r0.putAll(r3.attributes);
        L15:
            return r0;
        }

        public ShowImageCostData() {
            this.colorSpace = ListenerParams.ColorSpace.UNKNOWN.getValue();
            this.colorType = ListenerParams.ColorType.UNKNOWN.getValue();
            this.loadType = ListenerParams.LoadType.UNKNOWN;
            this.imageType = ImageUtils.ImageType.TYPE_UNKNOWN.getValue();
        }

        public final long getResourceSize() {
            return this.resourceSize;
        }

        public static final /* synthetic */ String access$getAppreciableKey$p(ShowImageCostData r0) {
            return r0.appreciableKey;
        }

        public static final /* synthetic */ Map access$getExtraCategory(ShowImageCostData r0) {
            return r0.getExtraCategory();
        }

        public static final /* synthetic */ ListenerParams access$getListenerParams$p(ShowImageCostData r0) {
            return r0.listenerParams;
        }

        private final void executeReportTask(Runnable r3) {
            ListenerParams r0 = this.listenerParams;
            if (r0 == null) goto L5;
            ListenerParams.FromType r1 = r0.k;
        L7:
            if (r1 == ListenerParams.FromType.AVATAR) goto L9;
        L11:
            CoreThreadPool.getDefault().getCachedThreadPool().execute(r3);
            return;
        L9:
            if (AvatarMonitorExecutor.INSTANCE.tryExecute(r3) == false) goto L11;
            return;
        L5:
            r1 = null;
            goto L7
        }

        private final Map<String, Object> getClientLatency(Object r9) {
            HashMap r0 = new HashMap();
            if ((r9 instanceof EncryptImage) == false) goto L9;
            EncryptImage r10 = (EncryptImage) r9;
            r0.put("send_req_waiting_cost", Long.valueOf(r10.getWaitTime()));
            if (r10.getDecodeStartTime() <= 0) goto L7;
            r0.put("decode_cost", Long.valueOf(System.currentTimeMillis() - r10.getDecodeStartTime()));
        L7:
            r0.put("decrypt_cost", Long.valueOf(r10.getDecryptTime()));
        L13:
            return r0;
        L9:
            if ((r9 instanceof AvatarImage) == false) goto L13;
            AvatarImage r11 = (AvatarImage) r9;
            r0.put("send_req_waiting_cost", Long.valueOf(r11.getWaitTime()));
            if (r11.getDecodeStartTime() <= 0) goto L13;
            r0.put("decode_cost", Long.valueOf(System.currentTimeMillis() - r11.getDecodeStartTime()));
            goto L13
        }

        private final String getImageKeyByModel(Object r9) {
            if ((r9 instanceof EncryptImage) == false) goto L6;
            return "image:" + ((EncryptImage) r9).getEncryptKey();
        L6:
            if ((r9 instanceof AvatarImage) == false) goto L9;
            return "avatar:" + ((AvatarImage) r9).getKey();
        L9:
            if ((r9 instanceof ReactionImage) == false) goto L12;
            return "reaction:" + ((ReactionImage) r9).getReactionKey();
        L12:
            if ((r9 instanceof PassThroughImage) == false) goto L15;
            return "passthrough:" + ((PassThroughImage) r9).getImageKey();
        L15:
            if ((r9 instanceof VideoImage) == false) goto L21;
            StringBuilder r0 = new StringBuilder("video:");
            VideoImage r10 = (VideoImage) r9;
            String r1 = r10.getPath();
            if (r1 == null) goto L19;
            String r11 = r1.substring(0, StringsKt.lastIndexOf$default(r10.getPath(), "/", 0, false, 6, null));
        L20:
            r0.append(r11);
            return r0.toString();
        L19:
            r11 = null;
            goto L20
        L21:
            return "other scene";
        }

        private final Map<String, Object> getLatencyDetail(Object r3) {
            HashMap r0 = new HashMap();
            r0.putAll(getSpanCost());
            r0.putAll(getClientLatency(r3));
            return r0;
        }

        private final boolean isMuteReport(ListenerParams.LoadType r5) {
            boolean r0 = !DevEnvUtil.isDebugMode(LarkContext.getApplication());
            a r2 = (a) ApiUtils.getApi(a.class);
            ListenerParams r3 = this.listenerParams;
            if (r3 == null) goto L7;
            ListenerParams.FromType r4 = r3.k;
            if (r4 == null) goto L7;
            int r6 = r4.getValue();
        L8:
            boolean r7 = !r2.isReportImageLoad(r6, r5.getValue());
            if (r0 == false) goto L12;
            if (r7 == false) goto L12;
            return true;
        L12:
            return false;
        L7:
            r6 = 1;
            goto L8
        }

        public final void setImageType(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.imageType = r2;
        }

        public final void setLoadType(ListenerParams.LoadType r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.loadType = r2;
        }

        public final void setResourceSize(long r1) {
            this.resourceSize = r1;
        }

        public final void setTrace(Trace r1) {
            this.trace = r1;
        }

        public static final /* synthetic */ Map access$getLatencyDetail(ShowImageCostData r0, Object r1) {
            return r0.getLatencyDetail(r1);
        }

        private final Map<String, Object> getExtraMetric(Object r6, String r7) {
            HashMap r0 = new HashMap();
            r0.put("resource_content_length", Long.valueOf(this.resourceSize));
            ListenerParams r1 = this.listenerParams;
            if (r1 == null) goto L18;
            r0.put("resource_width", Integer.valueOf(r1.e));
            r0.put("resource_height", Integer.valueOf(r1.f));
            r0.put("resource_frames", Integer.valueOf(r1.g));
            r0.put("load_width", Integer.valueOf(r1.c));
            r0.put("load_height", Integer.valueOf(r1.d));
            if ((r6 instanceof EncryptImage) == false) goto L14;
            EncryptImage r8 = (EncryptImage) r6;
            String r2 = r8.getResourceHash();
            String r3 = "";
            if (r2 != null) goto L9;
            r2 = "";
        L9:
            r0.put("resource_hash", r2);
            String r9 = r8.getFormatHeader();
            if (r9 == null) goto L13;
            r3 = r9;
        L13:
            r0.put("format_header", r3);
        L14:
            String r10 = r1.n;
            if (r10 == null) goto L17;
            r0.put("message_id", r10);
        L17:
            r0.put("media_is_origin_type", Boolean.valueOf(r1.p));
        L18:
            r0.put("image_key", r7);
            return r0;
        }

        private final String getImageKey(ListenerParams r2, Object r3) {
            if (r2 == null) goto L4;
            String r4 = r2.o;
        L5:
            if (r4 != null) goto L7;
        L10:
            boolean r0 = true;
        L11:
            if (r0 == true) goto L13;
            return r4;
        L13:
            return getImageKeyByModel(r3);
        L7:
            if (r4.length() == 0) goto L10;
            r0 = false;
            goto L11
        L4:
            r4 = null;
            goto L5
        }

        public final void end(final ErrorResult r2, final Object r3) {
            super.end();
            if (r2 == null) goto L5;
        L7:
            executeReportTask(new PerfLoadPicMonitor$ShowImageCostData$end$reportTask$1(this, r3, r2));
            return;
        L5:
            if (isMuteReport(this.loadType) == false) goto L7;
        }

        public final void start(ListenerParams r7, Object r8) {
            Intrinsics.checkNotNullParameter(r7, "params");
            super.start();
            this.listenerParams = r7;
            String r9 = getImageKey(r7, r8);
            ListenerParams r0 = this.listenerParams;
            if (r0 == null) goto L5;
            ListenerParams.FromType r1 = r0.k;
        L7:
            if (r1 == ListenerParams.FromType.AVATAR) goto L9;
            this.preloadResult = ImagePreloadManager.getResult(r9);
        L9:
            long r2 = SystemClock.elapsedRealtime();
            int r10 = a0.b;
            this.timeAfterAppStart = r2 - (SystemClock.elapsedRealtime() - 0);
            this.timeAfterForeground = SystemClock.elapsedRealtime() - (SystemClock.elapsedRealtime() - a0.a);
            this.appreciableKey = AppreciableKit.Companion.getInstance().start(r7.i, r7.j, Event.image_load, r7.m, true);
            return;
        L5:
            r1 = null;
            goto L7
        }

        public static final /* synthetic */ Map access$getExtraMetric(ShowImageCostData r0, Object r1, String r2) {
            return r0.getExtraMetric(r1, r2);
        }

        public static final /* synthetic */ String access$getImageKey(ShowImageCostData r0, ListenerParams r1, Object r2) {
            return r0.getImageKey(r1, r2);
        }

        @Override // com.ss.android.lark.monitor.perf.BasePerfMonitor.b, com.ss.android.lark.monitor.perf.BasePerfMonitor.a
        public void generateData(JSONObject r4, JSONObject r5, JSONObject r6) {
            Intrinsics.checkNotNullParameter(r4, "metrics");
            Intrinsics.checkNotNullParameter(r5, "category");
            Intrinsics.checkNotNullParameter(r6, "extra");
            r4.put("latency", this.costInMillis);     // Catch: JSONException -> L7
            r6.put("since_startup", this.timeAfterAppStart);     // Catch: JSONException -> L7
            r6.put("since_latest_enter_foreground", this.timeAfterForeground);     // Catch: JSONException -> L7
            ListenerParams r7 = this.listenerParams;     // Catch: JSONException -> L7
            if (r7 == null) goto L12;
            r5.put("scene", r7.j.getValue());     // Catch: JSONException -> L7
            r5.put("biz_scene", r7.j.getValue());     // Catch: JSONException -> L7
            return;
        L12:
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[DataSource.values().length];
            r0[DataSource.LOCAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[DataSource.REMOTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[DataSource.DATA_DISK_CACHE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[DataSource.RESOURCE_DISK_CACHE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[DataSource.MEMORY_CACHE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public PerfLoadPicMonitor() {
    }

    private final String getImageType(Object r2) {
        if ((r2 instanceof EncryptImage) == false) goto L6;
        String r3 = ((EncryptImage) r2).getImageType();
    L12:
        if (r3 == null) goto L14;
        return r3;
    L14:
        return ImageUtils.ImageType.TYPE_UNKNOWN.getValue();
    L6:
        if ((r2 instanceof AvatarImage) == false) goto L9;
        r3 = ((AvatarImage) r2).getImageType();
        goto L12
    L9:
        if ((r2 instanceof PassThroughImage) == false) goto L11;
        r3 = ((PassThroughImage) r2).getImageType();
        goto L12
    L11:
        r3 = ImageUtils.ImageType.TYPE_UNKNOWN.getValue();
        goto L12
    }

    private final long getResourceSize(Object r3) {
        if ((r3 instanceof EncryptImage) == false) goto L6;
        return ((EncryptImage) r3).getResourceSize();
    L6:
        if ((r3 instanceof AvatarImage) == false) goto L9;
        return ((AvatarImage) r3).getResourceSize();
    L9:
        if ((r3 instanceof PassThroughImage) == true) goto L15;
        return 0;
    L15:
        return ((PassThroughImage) r3).getResourceSize();
    }

    private final ListenerParams.LoadType getLoadType(DataSource r3, Object r4) {
        if (r3 != null) goto L5;
        int r5 = -1;
    L6:
        if (r5 == (-1)) goto L27;
        if (r5 == 1) goto L23;
        if (r5 == 2) goto L30;
        if (r5 == 3) goto L29;
        if (r5 == 4) goto L29;
        if (r5 != 5) goto L19;
        return ListenerParams.LoadType.MEMORY_CACHE;
    L19:
        throw new NoWhenBranchMatchedException();
    L29:
        return ListenerParams.LoadType.DISK_CACHE;
    L30:
        return ListenerParams.LoadType.NET;
    L23:
        if ((r4 instanceof AvatarImage) == false) goto L32;
        return ListenerParams.LoadType.NET;
    L32:
        return ListenerParams.LoadType.DISK_CACHE;
    L27:
        return ListenerParams.LoadType.UNKNOWN;
    L5:
        r5 = WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
        goto L6
    }

    public final void onException(ErrorResult r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "errorResult");
        ShowImageCostData r0 = this.mShowImageCostData;
        if (r0 != null) goto L5;
        return;
    L5:
        this.mShowImageCostData = null;
        r0.setImageType(getImageType(r4));
        r0.end(r3, r4);
    }

    public final void start(ListenerParams r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        if (this.mShowImageCostData != null) goto L5;
        this.mShowImageCostData = new ShowImageCostData();
    L5:
        ShowImageCostData r0 = this.mShowImageCostData;
        if (r0 == null) goto L9;
        r0.start(r2, r3);
        return;
    }

    public final void end(Trace r7, Object r8, DataSource r9, Object r10) {
        ShowImageCostData r0 = this.mShowImageCostData;
        if (r0 == null) goto L19;
        r0.setTrace(r7);
        r0.setLoadType(getLoadType(r9, r10));
        r0.setImageType(getImageType(r10));
        r0.setResourceSize(getResourceSize(r10));
        if (r0.getResourceSize() == 0) goto L7;
    L11:
        r0.end(null, r10);
        if (r0.isValid() == false) goto L19;
        if (r0.needReport(2) == false) goto L17;
        BasePerfMonitor.reportToTea(r0);
    L17:
        if (r0.needReport(1) == false) goto L19;
        BasePerfMonitor.reportToSlardar(r0);
        goto L19
    L7:
        if ((r8 instanceof BitmapDrawable) == false) goto L11;
        Bitmap r11 = ((BitmapDrawable) r8).getBitmap();
        if (r11 == null) goto L11;
        r0.setResourceSize(r11.getWidth() * r11.getHeight());
    L19:
        this.mShowImageCostData = null;
    }
}
