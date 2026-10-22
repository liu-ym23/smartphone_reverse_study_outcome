package com.larus.business.debug.base.livetutor;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.os.StrictMode;
import androidx.core.content.FileProvider;
import androidx.lifecycle.ViewModel;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.business.debug.api.RTCDebugInfo;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u000f"}, d2 = {"Lcom/larus/business/debug/base/livetutor/RTCDebugViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "shareToLark", "", "activity", "Landroid/app/Activity;", "pathList", "", "", "collectAndShareAudio", "rtcInfo", "Lcom/larus/business/debug/api/RTCDebugInfo;", "collectAndShareRTCLog", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RTCDebugViewModel extends ViewModel {

    /* JADX INFO: renamed from: com.larus.business.debug.base.livetutor.RTCDebugViewModel$collectAndShareAudio$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.business.debug.base.livetutor.RTCDebugViewModel$collectAndShareAudio$1", f = "RTCDebugViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ RTCDebugInfo $rtcInfo;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RTCDebugViewModel this$0;

        public AnonymousClass1(Activity r1, RTCDebugInfo r2, RTCDebugViewModel r3, Continuation<? super AnonymousClass1> r4) {
            this.$activity = r1;
            this.$rtcInfo = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$activity, this.$rtcInfo, this.this$0, r6);
            r0.L$0 = r5;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L22;
            ResultKt.throwOnFailure(r10);
            CoroutineScope r11 = (CoroutineScope) this.L$0;
            Activity r12 = this.$activity;
            RTCDebugInfo r2 = this.$rtcInfo;
            RTCDebugViewModel r3 = this.this$0;
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L14
            PolarisFileWrapper r5 = new PolarisFileWrapper(r12.getFilesDir(), "share/cache");     // Catch: Throwable -> L14
            r5.mkdirs();     // Catch: Throwable -> L14
            File r6 = r12.getFilesDir();     // Catch: Throwable -> L14
            StringBuilder r7 = new StringBuilder("rtc_test_");     // Catch: Throwable -> L14
            String r1 = null;
            if (r2 == null) goto L8;
            String r8 = r2.getBotID();     // Catch: Throwable -> L14
        L9:
            r7.append(r8);     // Catch: Throwable -> L14
            new PolarisFileWrapper(r6, r7.toString());     // Catch: Throwable -> L14
            String r9 = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.getDefault()).format(new Date());     // Catch: Throwable -> L14
            StringBuilder r13 = new StringBuilder("rtc-audio-dump-");     // Catch: Throwable -> L14
            r13.append(r9);     // Catch: Throwable -> L14
            r13.append('-');     // Catch: Throwable -> L14
            if (r2 == null) goto L12;
            r1 = r2.getBotID();     // Catch: Throwable -> L14
        L12:
            r13.append(r1);     // Catch: Throwable -> L14
            r13.append(".zip");     // Catch: Throwable -> L14
            RTCDebugViewModel.access$shareToLark(r3, r12, CollectionsKt.listOf(new PolarisFileWrapper(r5, r13.toString()).getAbsolutePath()));     // Catch: Throwable -> L14
            Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
        L16:
            Throwable r15 = Result.exceptionOrNull-impl(r14);
            if (r15 == null) goto L20;
            FLogger.a.e("ProjectMode", "share log error", r15);
        L20:
            return Unit.INSTANCE;
        L8:
            r8 = null;
        L14:
            th = move-exception;
            Result.Companion r0 = Result.Companion;
            r14 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L16
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.business.debug.base.livetutor.RTCDebugViewModel$collectAndShareRTCLog$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.business.debug.base.livetutor.RTCDebugViewModel$collectAndShareRTCLog$1", f = "RTCDebugViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RTCDebugViewModel this$0;

        public C02221(Activity r1, RTCDebugViewModel r2, Continuation<? super C02221> r3) {
            this.$activity = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            C02221 r0 = new C02221(this.$activity, this.this$0, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r15) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L36;
            ResultKt.throwOnFailure(r15);
            CoroutineScope r16 = (CoroutineScope) this.L$0;
            Activity r17 = this.$activity;
            RTCDebugViewModel r0 = this.this$0;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L28
            PolarisFileWrapper r2 = new PolarisFileWrapper(r17.getFilesDir(), "share/cache");     // Catch: Throwable -> L28
            r2.mkdirs();     // Catch: Throwable -> L28
            PolarisFileWrapper r3 = new PolarisFileWrapper(r17.getFilesDir(), "rtc_log/bytertc_log/Logs");     // Catch: Throwable -> L28
            long r4 = System.currentTimeMillis() - ((long) 3600000);     // Catch: Throwable -> L28
            File[] r5 = r3.listFiles();     // Catch: Throwable -> L28
            boolean r6 = false;
            if (r5 == null) goto L18;
            ArrayList r7 = new ArrayList();     // Catch: Throwable -> L28
            int r8 = r5.length;     // Catch: Throwable -> L28
            int r9 = 0;
        L8:
            if (r9 >= r8) goto L19;
            File r10 = r5[r9];     // Catch: Throwable -> L28
            if (r10.isFile() == true) goto L12;
        L14:
            boolean r11 = false;
        L15:
            if (r11 == false) goto L17;
            r7.add(r10);     // Catch: Throwable -> L28
        L17:
            r9 = r9 + 1;     // Catch: Throwable -> L28
            goto L8
        L12:
            if (r10.lastModified() < r4) goto L14;
            r11 = true;
        L19:
            if (r7 != null) goto L21;
        L23:
            if (r6 == false) goto L25;
            RTCDebugViewModel.access$shareToLark(r0, r17, CollectionsKt.listOf(new PolarisFileWrapper(r2, "rtc-engine-log-" + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.getDefault()).format(new Date()) + ".zip").getAbsolutePath()));     // Catch: Throwable -> L28
        L26:
            Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L28
        L30:
            Throwable r19 = Result.exceptionOrNull-impl(r18);
            if (r19 == null) goto L34;
            FLogger.a.e("ProjectMode", "share log error", r19);
        L34:
            return Unit.INSTANCE;
        L25:
            s.j(s.a, AppHost.a.getApplication().getApplicationContext(), "无日志", null, false, 28);     // Catch: Throwable -> L28
            goto L26
        L21:
            if ((!r7.isEmpty()) != true) goto L23;
            r6 = true;
            goto L23
        L18:
            r7 = null;
        L28:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r18 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L30
        L36:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public RTCDebugViewModel() {
    }

    private final void shareToLark(Activity r6, List<String> r7) {
        StrictMode.VmPolicy.Builder r0 = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(r0.build());
        r0.detectFileUriExposure();
        ArrayList<? extends Parcelable> r1 = new ArrayList();
        Iterator<T> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L14;
        String r2 = (String) r8.next();
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L4;
        Uri r4 = FileProvider.getUriForFile(r6, r6.getPackageName() + ".fileprovider", new PolarisFileWrapper(r2));
        r6.grantUriPermission("com.ss.android.lark", r4, 1);
        r1.add(r4);
        goto L4
    L8:
        if (r2.length() == 0) goto L11;
        r3 = false;
        goto L12
    L14:
        Intent r9 = new Intent("android.intent.action.SEND_MULTIPLE");
        r9.setFlags(268435456);
        r9.putParcelableArrayListExtra("android.intent.extra.STREAM", r1);
        r9.setType("*/*");
        r6.startActivity(Intent.createChooser(r9, ShareChannel.SHARE));
    }

    public final void collectAndShareAudio(Activity r8, RTCDebugInfo r9) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AnonymousClass1(r8, r9, this, null), 2, null);
    }

    public final void collectAndShareRTCLog(Activity r7, RTCDebugInfo r8) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C02221(r7, this, null), 2, null);
    }

    public static final /* synthetic */ void access$shareToLark(RTCDebugViewModel r0, Activity r1, List r2) {
        r0.shareToLark(r1, r2);
    }
}
