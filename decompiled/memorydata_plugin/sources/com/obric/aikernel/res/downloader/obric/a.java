package com.obric.aikernel.res.downloader.obric;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.download.BindCallback;
import com.obric.download.DownloadConfig;
import com.obric.download.DownloadListener;
import com.obric.download.DownloadManager;
import com.obric.download.L;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0002\u0007\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u00102\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H\u00100\u0012¢\u0006\u0002\b\u0013H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u001a\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/obric/aikernel/res/downloader/obric/ObricDownloadManager;", "", "()V", "EXTERNAL_ROOT", "", "TAG", "bindCallback", "com/obric/aikernel/res/downloader/obric/ObricDownloadManager$bindCallback$1", "Lcom/obric/aikernel/res/downloader/obric/ObricDownloadManager$bindCallback$1;", "downloadListener", "com/obric/aikernel/res/downloader/obric/ObricDownloadManager$downloadListener$1", "Lcom/obric/aikernel/res/downloader/obric/ObricDownloadManager$downloadListener$1;", "manager", "Lkotlinx/coroutines/CompletableDeferred;", "Lcom/obric/download/DownloadManager;", "execute", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "presmConfig", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6030a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static w<DownloadManager> f6031b;
    private static final C0257a c = null;
    private static final b d = null;

    /* JADX INFO: renamed from: com.obric.aikernel.res.downloader.obric.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/obric/aikernel/res/downloader/obric/ObricDownloadManager$bindCallback$1", "Lcom/obric/download/BindCallback;", "onServiceConnected", "", "onServiceDisconnected", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0257a implements BindCallback {
        C0257a() {
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0016"}, d2 = {"com/obric/aikernel/res/downloader/obric/ObricDownloadManager$downloadListener$1", "Lcom/obric/download/DownloadListener;", "onDownloadCancel", "", "info", "Lcom/obric/download/base/DownloadInfo;", "onDownloadFailed", "errorCode", "", DTraitConstant.ERROR, "", "onDownloadFinish", "onDownloadPause", "onDownloadPending", "onDownloadStart", "onDownloading", "onExtraInfoUpdate", "onFirstStart", "entity", "onFirstSuccess", "onRetry", "onRetryDelay", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements DownloadListener {
        b() {
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/obric/aikernel/res/downloader/obric/ObricDownloadManager$init$1", "Lcom/obric/download/L$Logger;", "writeLog", "", LocationMonitorConst.TAG, "", "level", "", NotificationCompat.CATEGORY_MESSAGE, "e", "", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements L.Logger {
        c() {
        }
    }

    static {
        f6030a = new a();
        c = new C0257a();
        d = new b();
    }

    private a() {
    }

    public final <T> Object a(Function1<? super DownloadManager, ? extends T> r7, Continuation<? super T> r8) {
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, ObricDownloadManager$execute$1.class) == false) goto L7;
        ObricDownloadManager$execute$1 r0 = (ObricDownloadManager$execute$1) ZeusTransformUtils.preCheckCast(r10, ObricDownloadManager$execute$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r9 = (Function1) ZeusTransformUtils.preCheckCast(r0.L$0, Function1.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
    L22:
        DownloadManager r12 = (DownloadManager) ZeusTransformUtils.preCheckCast(r6, DownloadManager.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L25;
        return null;
    L25:
        return r9.invoke(r12);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        if (f6031b != null) goto L17;
        f6031b = y.a(null, 1, null);
        DownloadManager r13 = DownloadManager.Companion.getInstance();
        r13.registerDownloadListener((DownloadListener) ZeusTransformUtils.preCheckCast(d, DownloadListener.class, "com.obric.memorydata.plugin"));
        r13.bindService((BindCallback) ZeusTransformUtils.preCheckCast(c, BindCallback.class, "com.obric.memorydata.plugin"));
    L17:
        w<DownloadManager> r14 = f6031b;
        if (r14 == null) goto L26;
        r0.L$0 = r9;
        r0.label = 1;
        r6 = r14.a(r0);
        if (r6 != r11) goto L22;
        return r11;
    L26:
        return null;
    L7:
        r0 = new ObricDownloadManager$execute$1(this, r10);
        goto L8
    }

    public final void a(PackageResourceManager.PresmConfig r5) {
        Intrinsics.checkNotNullParameter(r5, "presmConfig");
        L.setImpl((L.Logger) ZeusTransformUtils.preCheckCast(new c(), L.Logger.class, "com.obric.memorydata.plugin"));
        DownloadConfig.Builder r4 = new DownloadConfig.Builder();
        String r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName();
        Intrinsics.checkNotNullExpressionValue(r0, "presmConfig.context.packageName");
        DownloadConfig.Builder r6 = r4.setPkgName(r0).setConcurrentNum(r5.getParallelDownloadNum());
        String r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName();
        Intrinsics.checkNotNullExpressionValue(r1, "presmConfig.context.packageName");
        DownloadConfig r7 = r6.setClientPkgName(r1).build();
        DownloadManager.Companion.init((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r7);
    }
}
