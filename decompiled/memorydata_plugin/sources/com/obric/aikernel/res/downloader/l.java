package com.obric.aikernel.res.downloader;

import android.content.Context;
import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonObject;
import com.obric.aikernel.res.PackageResourceManager;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0001)B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u0014\u001a\u00020\u0015H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0015H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0018\u001a\u00020\u0019H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0011\u0010\u001c\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u001d\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J-\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u0010%J\u0011\u0010&\u001a\u00020\u0015H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010'\u001a\u00020\u0015H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010(\u001a\u00020\u0015H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lcom/obric/aikernel/res/downloader/GeneralDownloadTask;", "Lcom/obric/aikernel/res/downloader/IDownloadTask;", "file", "Lcom/obric/aikernel/res/downloader/DownloadTask$FileInfo;", "config", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "downloadListener", "Lcom/ss/android/socialbase/downloader/depend/IDownloadListener;", "monitorDepend", "Lcom/ss/android/socialbase/downloader/depend/IDownloadMonitorDepend;", "(Lcom/obric/aikernel/res/downloader/DownloadTask$FileInfo;Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;Lcom/ss/android/socialbase/downloader/depend/IDownloadListener;Lcom/ss/android/socialbase/downloader/depend/IDownloadMonitorDepend;)V", "downloadTask", "Lcom/ss/android/socialbase/downloader/model/DownloadTask;", "kotlin.jvm.PlatformType", "downloader", "Lcom/ss/android/socialbase/downloader/downloader/Downloader;", "getDownloader", "()Lcom/ss/android/socialbase/downloader/downloader/Downloader;", "downloader$delegate", "Lkotlin/Lazy;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finish", "getDownloadInfos", "Lcom/google/gson/JsonObject;", "getId", "", "getProgress", "getStatus", "isDownloaded", "", "logDownloadAction", "action", "", "status", "downloaded", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "pause", "resume", CommonConsts.APM_INNER_EVENT_COST_START, "Companion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class l implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6028a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j.b f6029b;
    private final PackageResourceManager.PresmConfig c;
    private final IDownloadListener d;
    private final IDownloadMonitorDepend e;
    private final DownloadTask f;
    private final Lazy g;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/aikernel/res/downloader/GeneralDownloadTask$Companion;", "", "()V", "TAG", "", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f6028a = new a(null);
    }

    public l(j.b r4, PackageResourceManager.PresmConfig r5, IDownloadListener r6, IDownloadMonitorDepend r7) {
        IDownloadListener r8 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r6, IDownloadListener.class, "com.obric.memorydata.plugin");
        IDownloadMonitorDepend r9 = (IDownloadMonitorDepend) ZeusTransformUtils.wrapperContextForParams(r7, IDownloadMonitorDepend.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "file");
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter(r8, "downloadListener");
        Intrinsics.checkNotNullParameter(r9, "monitorDepend");
        this.f6029b = r4;
        this.c = r5;
        this.d = r8;
        this.e = r9;
        l r10 = (l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.memorydata.plugin");
        JSONObject r11 = new JSONObject();
        JSONObject r12 = new JSONObject();
        r12.put("segment_max_kb", 2048);
        r12.put("segment_mode", 1);
        r11.put("segment_config", r12);
        com.obric.aikernel.runtime.utils.d.f6216a.a("GeneralDownloadTask", "getDownloadTask: new download info for " + r10.f6029b.c());
        DownloadTask r13 = Downloader.with((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).name(r10.f6029b.a()).url(r10.f6029b.c()).savePath(r10.f6029b.d()).tempPath(r10.f6029b.e()).retryCount(r10.f6029b.h()).md5(r10.f6029b.b()).onlyWifi(r10.f6029b.g()).subThreadListener(r10.d).monitorDepend(r10.e).needCurrentProcess(true).autoResumed(true);
        r13.downloadSetting(r11);
        this.f = r13;
        this.g = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new GeneralDownloadTask$downloader$2(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ PackageResourceManager.PresmConfig a(l r0) {
        return r0.c;
    }

    static /* synthetic */ void a(l r1, String r2, Integer r3, Boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.a(r2, r3, r4);
    }

    private final void a(String r10, Integer r11, Boolean r12) {
        f r8 = m.a(this.f6029b.d(), this.f6029b.a(), this.f6029b.e());
        com.obric.aikernel.runtime.utils.d.f6216a.a("GeneralDownloadTask", m.a(r10, this.f6029b, a(), r11, r12, r8));
    }

    private final Downloader c() {
        return (Downloader) ZeusTransformUtils.preCheckCast(this.g.getValue(), Downloader.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aikernel.res.downloader.n
    public int a() {
        return this.f.getDownloadId();
    }

    @Override // com.obric.aikernel.res.downloader.n
    public Object a(Continuation<? super Unit> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        a(this, CommonConsts.APM_INNER_EVENT_COST_START, null, null, 6, null);
        this.f.asyncDownload(null);
        return Unit.INSTANCE;
    }

    @Override // com.obric.aikernel.res.downloader.n
    public Object b(Continuation<? super Unit> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, GeneralDownloadTask$resume$1.class) == false) goto L7;
        GeneralDownloadTask$resume$1 r0 = (GeneralDownloadTask$resume$1) ZeusTransformUtils.preCheckCast(r11, GeneralDownloadTask$resume$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        l this = (l) ZeusTransformUtils.preCheckCast(r0.L$0, l.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
    L17:
        int r13 = ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).intValue();
        boolean r1 = m.a(r13);
        Integer r5 = Boxing.boxInt(r13);
        if (r1 == false) goto L20;
        a(this, "restart", r5, null, 4, null);
        this.c().restart(this.a());
    L22:
        return Unit.INSTANCE;
    L20:
        a(this, "resume", r5, null, 4, null);
        this.c().resume(this.a());
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        r0.L$0 = this;
        r0.label = 1;
        r12 = f(r0);
        if (r12 != r2) goto L17;
        return r2;
    L7:
        r0 = new GeneralDownloadTask$resume$1(this, r11);
        goto L8
    }

    @Override // com.obric.aikernel.res.downloader.n
    public boolean b() {
        return new File(this.f6029b.d(), this.f6029b.a()).exists();
    }

    @Override // com.obric.aikernel.res.downloader.n
    public Object c(Continuation<? super Unit> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, GeneralDownloadTask$pause$1.class) == false) goto L7;
        GeneralDownloadTask$pause$1 r0 = (GeneralDownloadTask$pause$1) ZeusTransformUtils.preCheckCast(r11, GeneralDownloadTask$pause$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        l this = (l) ZeusTransformUtils.preCheckCast(r0.L$0, l.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
    L17:
        int r13 = ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r13 != (-3)) goto L20;
    L24:
        this.c().pause(this.a());
        return Unit.INSTANCE;
    L20:
        if (r13 == (-1)) goto L24;
        if (r13 == (-4)) goto L24;
        a(this, "pause", Boxing.boxInt(r13), null, 4, null);
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        r0.L$0 = this;
        r0.label = 1;
        r12 = f(r0);
        if (r12 != r2) goto L17;
        return r2;
    L7:
        r0 = new GeneralDownloadTask$pause$1(this, r11);
        goto L8
    }

    @Override // com.obric.aikernel.res.downloader.n
    public Object d(Continuation<? super Unit> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        c().cancel(a(), false);
        return Unit.INSTANCE;
    }

    @Override // com.obric.aikernel.res.downloader.n
    public Object e(Continuation<? super Unit> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        a(this, "finish", null, Boxing.boxBoolean(b()), 2, null);
        return Unit.INSTANCE;
    }

    @Override // com.obric.aikernel.res.downloader.n
    public Object f(Continuation<? super Integer> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return Boxing.boxInt(c().getStatus(a()));
    }

    @Override // com.obric.aikernel.res.downloader.n
    public Object g(Continuation<? super Integer> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return Boxing.boxInt(this.f.getDownloadInfo().getDownloadProcess());
    }

    @Override // com.obric.aikernel.res.downloader.n
    public Object h(Continuation<? super JsonObject> r11) {
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, GeneralDownloadTask$getDownloadInfos$1.class) == false) goto L7;
        GeneralDownloadTask$getDownloadInfos$1 r0 = (GeneralDownloadTask$getDownloadInfos$1) ZeusTransformUtils.preCheckCast(r12, GeneralDownloadTask$getDownloadInfos$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r5 = "downloading";
        boolean r6 = false;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        JsonObject r10 = (JsonObject) ZeusTransformUtils.preCheckCast(r0.L$3, JsonObject.class, "com.obric.memorydata.plugin");
        r5 = (String) ZeusTransformUtils.preCheckCast(r0.L$2, String.class, "com.obric.memorydata.plugin");
        JsonObject r4 = (JsonObject) ZeusTransformUtils.preCheckCast(r0.L$1, JsonObject.class, "com.obric.memorydata.plugin");
        JsonObject r1 = (JsonObject) ZeusTransformUtils.preCheckCast(r0.L$0, JsonObject.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);
    L25:
        if (((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).intValue() != 4) goto L27;
        r6 = true;
    L27:
        r10.addProperty(r5, Boxing.boxBoolean(r6));
        r4.addProperty("missingDownloadInfo", Boxing.boxBoolean(true));
        return r1;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        DownloadInfo r14 = this.f.getDownloadInfo();
        if (r14 == null) goto L20;
        JsonObject r15 = new JsonObject();
        r15.addProperty(ActivityLifecycle.NAME, r14.getName());
        r15.addProperty("speed", (Number) ZeusTransformUtils.preCheckCast(Boxing.boxDouble(r14.getDownloadSpeed()), Number.class, "com.obric.memorydata.plugin"));
        if (r14.getStatus() != 4) goto L19;
        r6 = true;
    L19:
        r15.addProperty("downloading", Boxing.boxBoolean(r6));
        return r15;
    L20:
        JsonObject r16 = new JsonObject();
        r16.addProperty(ActivityLifecycle.NAME, this.f6029b.a());
        r16.addProperty("speed", (Number) ZeusTransformUtils.preCheckCast(Boxing.boxInt(0), Number.class, "com.obric.memorydata.plugin"));
        r0.L$0 = r16;
        r0.L$1 = r16;
        r0.L$2 = "downloading";
        r0.L$3 = r16;
        r0.label = 1;
        Object r17 = f(r0);
        if (r17 != r2) goto L23;
        return r2;
    L23:
        r1 = r16;
        r4 = r1;
        r13 = r17;
        r10 = r4;
    L7:
        r0 = new GeneralDownloadTask$getDownloadInfos$1(this, r12);
        goto L8
    }
}
