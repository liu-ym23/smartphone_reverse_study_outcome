package com.ss.android.lark.officesdk.minutes.service.fileupload;

import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.google.gson.reflect.TypeToken;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadDeleteReason;
import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadErrorCode;
import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadTaskEventOrigin;
import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadTaskState;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.fileupload.network.response.MmFileUploadPrepareResponse;
import com.ss.android.lark.officesdk.minutes.service.fileupload.network.response.MmFileUploadQuotaResponse;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpBaseResp;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.officesdk.minutes.service.foundation.userscope.MinutesUCCImpl;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmNetworkUtils;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.MmD1204RecordingEventTracker;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.signinsdk_api.base.NetworkErrorResult;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.profile.v2.entity.BaseField;
import com.ss.android.lark.utils.e0;
import com.ss.android.lark.utils.y;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import kotlinx.coroutines.sync.MutexImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmMinutesFileUploadSessionManager {
    public static final Set<String> u = null;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final MmMinutesFileUploadBusinessTracker b;
    public final yub.a c;
    public final String d;
    public final com.ss.android.lark.officesdk.minutes.service.fileupload.c e;
    public final com.ss.android.lark.officesdk.minutes.service.fileupload.e f;
    public final MutexImpl g;
    public volatile CoroutineScope h;
    public final CompletableJob i;
    public final CoroutineScope j;
    public Job k;
    public Job l;
    public volatile boolean m;
    public final k n;
    public final MutableSharedFlow<eub.c> o;
    public final LinkedHashMap<String, e> p;
    public final HashMap<String, String> q;
    public boolean r;
    public boolean s;
    public volatile Context t;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager$2", f = "MmMinutesFileUploadSessionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MmMinutesFileUploadSessionManager this$0;

        public AnonymousClass2(MmMinutesFileUploadSessionManager r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r2);
            if (this.this$0.m == false) goto L8;
            lvb.a.e(this.this$0.d, "init: skip lifecycle observer registration after release");
            return Unit.INSTANCE;
        L8:
            MmMinutesFileUploadSessionManager r3 = this.this$0;
            r3.c.b(r3.n);
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/fileupload/MmMinutesFileUploadSessionManager$PendingResumeActionType;", "", "<init>", "(Ljava/lang/String;I)V", "RESTART_PIPELINE", "RESUME_DRIVE_UPLOAD", "COMPLETE_AFTER_DRIVE_UPLOADED", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum PendingResumeActionType extends Enum<PendingResumeActionType> {
        public static final PendingResumeActionType COMPLETE_AFTER_DRIVE_UPLOADED = null;
        public static final PendingResumeActionType RESTART_PIPELINE = null;
        public static final PendingResumeActionType RESUME_DRIVE_UPLOAD = null;
        public static final /* synthetic */ PendingResumeActionType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PendingResumeActionType> getEntries() {
            return b;
        }

        static {
            PendingResumeActionType r0 = new PendingResumeActionType("RESTART_PIPELINE", 0);
            RESTART_PIPELINE = r0;
            PendingResumeActionType r1 = new PendingResumeActionType("RESUME_DRIVE_UPLOAD", 1);
            RESUME_DRIVE_UPLOAD = r1;
            PendingResumeActionType r3 = new PendingResumeActionType("COMPLETE_AFTER_DRIVE_UPLOADED", 2);
            COMPLETE_AFTER_DRIVE_UPLOADED = r3;
            PendingResumeActionType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static PendingResumeActionType[] values() {
            return (PendingResumeActionType[]) a.clone();
        }

        public static PendingResumeActionType valueOf(String r1) {
            return (PendingResumeActionType) r27.a.a(PendingResumeActionType.class, r1);
        }

        public PendingResumeActionType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/fileupload/MmMinutesFileUploadSessionManager$RestartPipelineException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "reason", "", "<init>", "(Ljava/lang/String;)V", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class RestartPipelineException extends RuntimeException {
        public RestartPipelineException(String r2) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            super(r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final List<String> e;
        public final MmRecordingSource f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
        }

        public final String toString() {
            return "FinishUploadData(uploadToken=" + this.a + ", objectToken=" + this.b + ", vhId=" + this.c + ", uploadId=" + this.d + ", uploadedFileTokens=" + this.e + ", source=" + this.f + ')';
        }

        public b(String r2, String r3, String r4, String r5, List<String> r6, MmRecordingSource r7) {
            Intrinsics.checkNotNullParameter(r2, "uploadToken");
            Intrinsics.checkNotNullParameter(r3, "objectToken");
            Intrinsics.checkNotNullParameter(r4, "vhId");
            Intrinsics.checkNotNullParameter(r5, "uploadId");
            Intrinsics.checkNotNullParameter(r6, "uploadedFileTokens");
            Intrinsics.checkNotNullParameter(r7, "source");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public static final class c {
        public final String a;
        public final PendingResumeActionType b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "PendingResumeAction(taskId=" + this.a + ", type=" + this.b + ')';
        }

        public final PendingResumeActionType getType() {
            return this.b;
        }

        public c(String r2, PendingResumeActionType r3) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
            Intrinsics.checkNotNullParameter(r3, "type");
            this.a = r2;
            this.b = r3;
        }
    }

    public static abstract class d {

        public static final class a extends d {
            public final h.a.C0013a a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Failed(failure=" + this.a + ')';
            }

            public a(h.a.C0013a r2) {
                Intrinsics.checkNotNullParameter(r2, "failure");
                this.a = r2;
            }
        }

        public static final class b extends d {
            public final File a;
            public final long b;

            public final boolean equals(Object r8) {
                if (this != r8) goto L6;
                return true;
            L6:
                if ((r8 instanceof b) == true) goto L8;
                return false;
            L8:
                b r9 = (b) r8;
                if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
                return false;
            L12:
                if (this.b == r9.b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r0 = this.a.hashCode() * 31;
                long r1 = this.b;
                return r0 + ((int) (r1 ^ (r1 >>> 32)));
            }

            public final String toString() {
                return "Ready(oggFile=" + this.a + ", oggLength=" + this.b + ')';
            }

            public b(File r2, long r3) {
                Intrinsics.checkNotNullParameter(r2, "oggFile");
                this.a = r2;
                this.b = r3;
            }
        }

        public d() {
        }
    }

    public static final class e {
        public eub.f a;
        public final z0<eub.g> b;
        public final boolean c;
        public String d;
        public final List<String> e;
        public final Map<String, Boolean> f;
        public final Map<String, Long> g;
        public final Map<String, Long> h;
        public final Map<String, String> i;
        public final Map<String, Integer> j;
        public final Map<String, Integer> k;
        public final Set<String> l;
        public long m;
        public long n;
        public int o;
        public List<String> p;
        public int q;
        public CompletableDeferred<Unit> r;
        public boolean s;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof e) == true) goto L8;
            return false;
        L8:
            e r6 = (e) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "TaskHolder(param=" + this.a + ", statusFlow=" + this.b + ", restoredFromStorage=" + this.c + ')';
        }

        public final c f() {
            eub.g r0 = (eub.g) this.b.getValue();
            MmMinutesFileUploadTaskState r1 = r0.a;
            boolean r5 = false;
            if (r1 != MmMinutesFileUploadTaskState.UploadCompleted) goto L6;
        L16:
            boolean r2 = false;
        L69:
            if (r2 == true) goto L71;
            return null;
        L71:
            String r3 = this.a.a;
            eub.b r4 = ((eub.g) this.b.getValue()).g;
            if (r4 == null) goto L84;
            MmMinutesFileUploadErrorCode r6 = r4.a;
            if (r6 == null) goto L84;
            if (this.q >= 3) goto L84;
            if (r6 != MmMinutesFileUploadErrorCode.DRIVE_UPLOAD_REQUEST_ERROR) goto L82;
        L83:
            boolean r7 = true;
        L85:
            if (r7 == false) goto L89;
            lvb.a.e("MmMinutesFileUploadSM", "resumeActionWhenRestart: restart pipeline for drive failure. taskId=" + r3 + ", error=" + ((eub.g) this.b.getValue()).g);
            e(true);
            return new c(r3, PendingResumeActionType.RESTART_PIPELINE);
        L89:
            if (((ArrayList) this.e).isEmpty() == false) goto L92;
            e(true);
            return new c(r3, PendingResumeActionType.RESTART_PIPELINE);
        L92:
            List<String> r8 = this.e;
            if ((r8 instanceof Collection) == true) goto L95;
        L97:
            Iterator<T> r9 = r8.iterator();
        L99:
            if (r9.hasNext() == false) goto L96;
            if (Intrinsics.areEqual(((LinkedHashMap) this.f).get((String) r9.next()), Boolean.TRUE) == true) goto L99;
        L102:
            if (r5 == false) goto L105;
            return new c(r3, PendingResumeActionType.COMPLETE_AFTER_DRIVE_UPLOADED);
        L105:
            return new c(r3, PendingResumeActionType.RESUME_DRIVE_UPLOAD);
        L96:
            r5 = true;
            goto L102
        L95:
            if (r8.isEmpty() == false) goto L97;
        L82:
            if (r6 == MmMinutesFileUploadErrorCode.DRIVE_PUSH_CALLBACK_ERROR) goto L83;
        L84:
            r7 = false;
            goto L85
        L6:
            if (r1 != MmMinutesFileUploadTaskState.Interrupted) goto L8;
        L11:
            boolean r10 = true;
        L12:
            if (r10 == false) goto L14;
            eub.b r11 = r0.g;
            if (r11 == null) goto L20;
            MmMinutesFileUploadErrorCode r12 = r11.a;
        L22:
            if (r12 != MmMinutesFileUploadErrorCode.FINISH_REQUEST_ERROR) goto L24;
        L27:
            boolean r13 = true;
        L28:
            if (r13 == true) goto L16;
            if (r11 == null) goto L32;
            MmMinutesFileUploadErrorCode r14 = r11.a;
        L34:
            if (this.q >= 3) goto L36;
        L40:
            boolean r15 = false;
        L41:
            if (r15 == true) goto L16;
            if (this.d.length() <= 0) goto L46;
            boolean r16 = true;
        L47:
            if (r16 == false) goto L52;
            if (((ArrayList) this.e).isEmpty() == true) goto L50;
        L15:
            r2 = true;
            goto L69
        L50:
            this.d = "";
            goto L15
        L52:
            if (((ArrayList) this.e).isEmpty() == false) goto L61;
            eub.b r17 = r0.g;
            if (r17 == null) goto L56;
            MmMinutesFileUploadErrorCode r18 = r17.a;
        L58:
            if (r18 != MmMinutesFileUploadErrorCode.PREPARE_REQUEST_ERROR) goto L61;
        L56:
            r18 = null;
        L61:
            if (((ArrayList) this.e).isEmpty() == false) goto L16;
            eub.b r19 = r0.g;
            if (r19 == null) goto L65;
            MmMinutesFileUploadErrorCode r20 = r19.a;
        L67:
            if (r20 != MmMinutesFileUploadErrorCode.NETWORK_ERROR) goto L16;
        L65:
            r20 = null;
            goto L67
        L46:
            r16 = false;
            goto L47
        L36:
            if (r14 != MmMinutesFileUploadErrorCode.DRIVE_UPLOAD_REQUEST_ERROR) goto L38;
        L39:
            r15 = true;
            goto L41
        L38:
            if (r14 != MmMinutesFileUploadErrorCode.DRIVE_PUSH_CALLBACK_ERROR) goto L40;
        L32:
            r14 = null;
            goto L34
        L24:
            if (r12 == MmMinutesFileUploadErrorCode.ALREADY_UPLOAD) goto L27;
            r13 = false;
            goto L28
        L20:
            r12 = null;
            goto L22
        L14:
            if (r1 == MmMinutesFileUploadTaskState.Idle) goto L16;
        L8:
            if (r0.g != null) goto L11;
            r10 = false;
            goto L12
        }

        public final eub.f a() {
            return this.a;
        }

        public final List<String> b() {
            return this.e;
        }

        public final boolean c(String r4) {
            Intrinsics.checkNotNullParameter(r4, "uploadTaskId");
            if (r4.length() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            return true;
        L8:
            if (((ArrayList) this.e).contains(r4) == true) goto L13;
            return false;
        L13:
            return true;
        L5:
            r0 = false;
            goto L6
        }

        public final c d(boolean r11) {
            this.p = CollectionsKt.emptyList();
            String r0 = this.a.a;
            MmMinutesFileUploadTaskState r1 = ((eub.g) this.b.getValue()).h;
            boolean r4 = false;
            if (r11 == true) goto L65;
            eub.g r6 = (eub.g) this.b.getValue();
            if (this.d.length() <= 0) goto L7;
            boolean r7 = true;
        L8:
            if (r7 == true) goto L10;
        L60:
            boolean r8 = false;
        L61:
            if (r8 == false) goto L65;
            z0<eub.g> r12 = this.b;
            int r5 = n.a;
            r12.setValue(n.a((eub.g) r12.getValue(), new n.a.C0014a(MmMinutesFileUploadTaskState.DriveAllUploaded)));
            lvb.a.e("MmMinutesFileUploadSM", "manualRetryAction: complete after drive uploaded. taskId=" + r0 + ", lastState=" + r1);
            return new c(r0, PendingResumeActionType.COMPLETE_AFTER_DRIVE_UPLOADED);
        L10:
            if (r6.d.length() <= 0) goto L12;
            boolean r9 = true;
        L13:
            if (r9 == false) goto L60;
            if (r6.e.length() <= 0) goto L17;
            boolean r10 = true;
        L18:
            if (r10 == false) goto L60;
            if (r6.f.length() <= 0) goto L22;
            boolean r13 = true;
        L23:
            if (r13 == false) goto L60;
            if ((!((ArrayList) this.e).isEmpty()) == false) goto L60;
            List<String> r14 = this.e;
            if ((r14 instanceof Collection) == true) goto L29;
        L31:
            Iterator r15 = ((ArrayList) r14).iterator();
        L33:
            if (r15.hasNext() == false) goto L37;
            if (Intrinsics.areEqual(((LinkedHashMap) this.f).get((String) r15.next()), Boolean.TRUE) == true) goto L33;
            boolean r16 = false;
        L38:
            if (r16 == false) goto L60;
            List<String> r17 = this.e;
            if ((r17 instanceof Collection) == true) goto L42;
        L44:
            Iterator r18 = ((ArrayList) r17).iterator();
        L46:
            if (r18.hasNext() == false) goto L57;
            CharSequence r19 = (CharSequence) ((LinkedHashMap) this.i).get((String) r18.next());
            if (r19 != null) goto L50;
        L53:
            boolean r20 = true;
        L55:
            if ((!r20) == true) goto L46;
            boolean r21 = false;
        L58:
            if (r21 == false) goto L60;
            r8 = true;
            goto L61
        L50:
            if (r19.length() == 0) goto L53;
            r20 = false;
        L57:
            r21 = true;
            goto L58
        L42:
            if (((ArrayList) r17).isEmpty() == false) goto L44;
        L37:
            r16 = true;
            goto L38
        L29:
            if (((ArrayList) r14).isEmpty() == false) goto L31;
        L22:
            r13 = false;
            goto L23
        L17:
            r10 = false;
            goto L18
        L12:
            r9 = false;
            goto L13
        L7:
            r7 = false;
        L65:
            if (r11 == false) goto L67;
        L90:
            lvb.a.e("MmMinutesFileUploadSM", "manualRetryAction: restart pipeline. taskId=" + r0 + ", uploadTaskIds=" + this.e + ", lastState=" + r1 + ", restartFromInit=" + r11);
            e(true);
            return new c(r0, PendingResumeActionType.RESTART_PIPELINE);
        L67:
            if (this.d.length() <= 0) goto L69;
            boolean r22 = true;
        L70:
            if (r22 == true) goto L72;
        L87:
            if (r4 == false) goto L90;
            z0<eub.g> r110 = this.b;
            int r23 = n.a;
            r110.setValue(n.a((eub.g) r110.getValue(), new n.a.C0014a(MmMinutesFileUploadTaskState.Uploading)));
            lvb.a.e("MmMinutesFileUploadSM", "manualRetryAction: resume drive upload. taskId=" + r0 + ", uploadTaskIds=" + this.e + ", lastState=" + r1);
            return new c(r0, PendingResumeActionType.RESUME_DRIVE_UPLOAD);
        L72:
            if ((!((ArrayList) this.e).isEmpty()) == false) goto L87;
            List<String> r24 = this.e;
            if ((r24 instanceof Collection) == true) goto L76;
        L78:
            Iterator r25 = ((ArrayList) r24).iterator();
        L80:
            if (r25.hasNext() == false) goto L84;
            if ((!Intrinsics.areEqual(((LinkedHashMap) this.f).get((String) r25.next()), Boolean.TRUE)) == false) goto L80;
            boolean r26 = true;
        L85:
            if (r26 == false) goto L87;
            r4 = true;
        L84:
            r26 = false;
            goto L85
        L76:
            if (((ArrayList) r24).isEmpty() == false) goto L78;
        L69:
            r22 = false;
            goto L70
        }

        public final void e(boolean r3) {
            this.p = CollectionsKt.toList(this.e);
            this.d = "";
            if (r3 == false) goto L7;
            CompletableDeferred<Unit> r4 = this.r;
            if (r4 == null) goto L7;
            Job.DefaultImpls.cancel$default(r4, null, 1, null);
        L7:
            this.r = null;
            ((ArrayList) this.e).clear();
            ((LinkedHashMap) this.f).clear();
            ((LinkedHashMap) this.g).clear();
            ((LinkedHashMap) this.h).clear();
            ((LinkedHashMap) this.i).clear();
            ((LinkedHashMap) this.j).clear();
            ((LinkedHashMap) this.k).clear();
            this.l.clear();
            this.m = 0;
            this.n = 0;
            this.o = 0;
            z0<eub.g> r5 = this.b;
            int r0 = n.a;
            r5.setValue(n.a((eub.g) r5.getValue(), n.a.c.a));
        }

        public final void g(CompletableDeferred<Unit> r1) {
            this.r = r1;
        }

        public e(eub.f r2, StateFlowImpl r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "param");
            Intrinsics.checkNotNullParameter(r3, "statusFlow");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = "";
            this.e = new ArrayList();
            this.f = new LinkedHashMap();
            this.g = new LinkedHashMap();
            this.h = new LinkedHashMap();
            this.i = new LinkedHashMap();
            this.j = new LinkedHashMap();
            this.k = new LinkedHashMap();
            this.l = new LinkedHashSet();
            this.p = CollectionsKt.emptyList();
        }
    }

    public static final class f {
        public final eub.f a;
        public final eub.g b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof f) == true) goto L8;
            return false;
        L8:
            f r6 = (f) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "TaskSnapshot(param=" + this.a + ", status=" + this.b + ')';
        }

        public f(eub.f r2, eub.g r3) {
            Intrinsics.checkNotNullParameter(r2, "param");
            Intrinsics.checkNotNullParameter(r3, "status");
            this.a = r2;
            this.b = r3;
        }
    }

    public /* synthetic */ class g {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[PendingResumeActionType.values().length];
            r0[PendingResumeActionType.RESTART_PIPELINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L55:
            r0[PendingResumeActionType.RESUME_DRIVE_UPLOAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L65:
            r0[PendingResumeActionType.COMPLETE_AFTER_DRIVE_UPLOADED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L8:
            a = r0;
            int[] r1 = new int[MmMinutesFileUploadDeleteReason.values().length];
            r1[MmMinutesFileUploadDeleteReason.DELETE_BY_USER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L59:
            r1[MmMinutesFileUploadDeleteReason.DUPLICATE_IN_SERVER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L67:
            r1[MmMinutesFileUploadDeleteReason.ACCOUNT_CHANGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L39:
            r1[MmMinutesFileUploadDeleteReason.OTHERS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L14:
            b = r1;
            int[] r2 = new int[MmMinutesFileUploadTaskState.values().length];
            r2[MmMinutesFileUploadTaskState.Init.ordinal()] = 1;     // Catch: NoSuchFieldError -> L31
        L61:
            r2[MmMinutesFileUploadTaskState.PreCheckSuccess.ordinal()] = 2;     // Catch: NoSuchFieldError -> L32
        L41:
            r2[MmMinutesFileUploadTaskState.QuotaReady.ordinal()] = 3;     // Catch: NoSuchFieldError -> L33
        L43:
            r2[MmMinutesFileUploadTaskState.Uploading.ordinal()] = 4;     // Catch: NoSuchFieldError -> L34
        L53:
            r2[MmMinutesFileUploadTaskState.DriveAllUploaded.ordinal()] = 5;     // Catch: NoSuchFieldError -> L35
        L63:
            r2[MmMinutesFileUploadTaskState.UploadCompleted.ordinal()] = 6;     // Catch: NoSuchFieldError -> L36
        L45:
            r2[MmMinutesFileUploadTaskState.Interrupted.ordinal()] = 7;     // Catch: NoSuchFieldError -> L37
        L57:
            r2[MmMinutesFileUploadTaskState.Idle.ordinal()] = 8;     // Catch: NoSuchFieldError -> L38
            return;
        }
    }

    static {
        u = SetsKt.setOf(new String[]{"legacy_source", "sync_task_id", "transfer_type", "retry_flag", "record_index", "is_last_record", "hardware_file_ids", "hardware_device_ids", "prepare_name", "file_unique_id_list", "offline_line_index", "doubao_biz_info"});
    }

    public final void A() {
        r("restorePendingTasks", new MmMinutesFileUploadSessionManager$restorePendingTasks$1(this, null));
    }

    public final void C() {
        r("resumePendingUploads", new MmMinutesFileUploadSessionManager$resumePendingUploads$1(this, null));
    }

    public final boolean E() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r0 = Result.constructor-impl(Boolean.valueOf(Intrinsics.areEqual(((LinkedHashMap) this.a.getFeatureService().a(CollectionsKt.listOf("vc.minutes.fileupload.rollback_when_drive_fail"), false)).get("vc.minutes.fileupload.rollback_when_drive_fail"), Boolean.TRUE)));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.exceptionOrNull-impl(r0);
        if (r2 == null) goto L10;
        lvb.a.b(this.d, "shouldRollbackWhenDriveFail failed: " + r2);
    L10:
        Boolean r3 = Boolean.FALSE;
        if (Result.isFailure-impl(r0) == false) goto L14;
        r0 = r3;
    L14:
        return ((Boolean) r0).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final boolean F() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r0 = Result.constructor-impl(Boolean.valueOf(Intrinsics.areEqual(((LinkedHashMap) this.a.getFeatureService().a(CollectionsKt.listOf("vc.file_transcription.file_transcription_duration"), false)).get("vc.file_transcription.file_transcription_duration"), Boolean.TRUE)));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.exceptionOrNull-impl(r0);
        if (r2 == null) goto L10;
        lvb.a.b(this.d, "shouldSkipUploadSizeDurationCheck failed: " + r2);
    L10:
        Boolean r3 = Boolean.FALSE;
        if (Result.isFailure-impl(r0) == false) goto L14;
        r0 = r3;
    L14:
        return ((Boolean) r0).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final void w() {
        com.ss.android.lark.officesdk.minutes.service.fileupload.e r1 = this.f;
        Collection<e> r2 = this.p.values();
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        e r5 = (e) r4.next();
        r5.getClass();
        Iterator r22 = r4;
        ArrayList r21 = r3;
        r21.add(new o(r5.a, (eub.g) r5.b.getValue(), r5.d, CollectionsKt.toList(r5.e), new HashMap(r5.f), new HashMap(r5.g), new HashMap(r5.h), new HashMap(r5.i), r5.m, r5.n, r5.o, r5.q));
        r3 = r21;
        r1 = r1;
        r4 = r22;
        goto L4
    L6:
        com.ss.android.lark.officesdk.minutes.service.fileupload.e r20 = r1;
        ArrayList r0 = r3;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r0, "list");
        String r6 = e0.c(r0);
        if (r6 != null) goto L9;
        r6 = "[]";
    L9:
        r20.a.H().putString("minutes_file_upload_tasks_v1", r6);
    }

    public final void x() {
        if (this.m == false) goto L5;
        return;
    L5:
        this.m = true;
        com.ss.android.lark.officesdk.minutes.service.fileupload.c r1 = this.e;
        monitor-enter(r1);
    L24:
        th = move-exception;
        throw th;
    L8:
        if (r1.c.isEmpty() == false) goto L11;
        monitor-exit(r1);
    L13:
        CoroutineScope r2 = this.h;
        this.h = null;
        lvb.a.a(this.d, "release: tasks=" + this.p.size() + ", uploadMappings=" + this.q.size());
        Job r3 = this.l;
        if (r3 == null) goto L16;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L16:
        this.l = null;
        BuildersKt.launch$default(this.j, null, null, new MmMinutesFileUploadSessionManager$release$1(this, null), 3, null);
        this.o.tryEmit(eub.c.C0137c.a);
        Job r4 = this.k;
        if (r4 == null) goto L19;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L19:
        this.k = null;
        if (r2 == null) goto L22;
        CoroutineScopeKt.cancel$default(r2, null, 1, null);
    L22:
        this.p.clear();
        this.q.clear();
        this.r = false;
        this.s = false;
        return;
    L11:
        r1.c.clear();     // Catch: Throwable -> L24
        r1.b.release();     // Catch: Throwable -> L24
        monitor-exit(r1);
        goto L13
    }

    public final void z() {
        com.ss.android.lark.officesdk.minutes.service.fileupload.e r0 = this.f;
        String r1 = r0.a.H().getString("minutes_file_upload_tasks_v1", null);
        boolean r2 = false;
        if (r1 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L53;
        List r3 = CollectionsKt.emptyList();
    L37:
        lvb.a.e(this.d, "restoreFromLocalLocked: storedCount=" + r3.size());
        Iterator r4 = r3.iterator();
    L39:
        if (r4.hasNext() == false) goto L50;
        o r6 = (o) r4.next();
        String r7 = r6.a.a;
        if (StringsKt.isBlank(r7) == true) goto L39;
        eub.g r8 = r6.b;
        if (r8.a == MmMinutesFileUploadTaskState.UploadCompleted) goto L44;
        e r9 = new e(r6.a, j1.a(r8), true);
        String r10 = r6.c;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r9.d = r10;
        ((ArrayList) r9.e).addAll(r6.d);
        r9.f.putAll(r6.e);
        r9.g.putAll(r6.f);
        r9.h.putAll(r6.g);
        r9.i.putAll(r6.h);
        r9.n = r6.j;
        r9.m = r6.i;
        r9.o = r6.k;
        r9.q = r6.l;
        this.p.put(r7, r9);
        Iterator<T> r11 = r6.d.iterator();
    L47:
        if (r11.hasNext() == false) goto L49;
        this.q.put((String) r11.next(), r7);
        goto L47
    L49:
        lvb.a.e(this.d, "restoreFromLocalLocked: restored taskId=" + r7 + ", uploadTaskIds=" + r6.d + ", state=" + r6.b.a);
        goto L39
    L44:
        int r12 = m.a;
        m.a(r6.a);
        lvb.a.e(this.d, "restoreFromLocalLocked: skip completed taskId=" + r7);
        r2 = true;
        goto L39
    L50:
        if (r2 == false) goto L69;
        w();
        return;
    L69:
        return;
    L53:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L28
        List r14 = (List) e0.b(r1, new com.ss.android.lark.officesdk.minutes.service.fileupload.f().getType());     // Catch: Throwable -> L28
        if (r14 != null) goto L14;
        r14 = CollectionsKt.emptyList();     // Catch: Throwable -> L28
    L14:
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L28
        Iterator r16 = r14.iterator();     // Catch: Throwable -> L28
    L16:
        if (r16.hasNext() == false) goto L21;
        o r17 = com.ss.android.lark.officesdk.minutes.service.fileupload.e.b((o) r16.next());     // Catch: Throwable -> L28
        if (r17 == null) goto L16;
        r15.add(r17);     // Catch: Throwable -> L28
        goto L16
    L21:
        if (r15.size() == r14.size()) goto L26;
        Intrinsics.checkNotNullParameter(r15, "list");     // Catch: Throwable -> L28
        String r18 = e0.c(r15);     // Catch: Throwable -> L28
        if (r18 != null) goto L25;
        r18 = "[]";
    L25:
        r0.a.H().putString("minutes_file_upload_tasks_v1", r18);     // Catch: Throwable -> L28
    L26:
        Object r19 = Result.constructor-impl(r15);     // Catch: Throwable -> L28
    L30:
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 == null) goto L33;
        lvb.a.b("MmMinutesFileUploadLocalStorage", "loadAll failed: err=" + r20.getClass().getSimpleName() + ", msg=" + r20.getMessage());
    L33:
        List r21 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r19) == false) goto L36;
        r19 = r21;
    L36:
        r3 = (List) r19;
    L28:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L5:
        if (r1.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    public static eub.e I(MmFileUploadQuotaResponse r7) {
        return new eub.e(r7.getHasQuota(), r7.isAdmin(), r7.getNoQuotaNotice(), r7.getBillUrl(), r7.getDenyType());
    }

    public static final List b(MmMinutesFileUploadSessionManager r4) {
        if (r4.r == true) goto L15;
        r4.r = true;
        Collection<e> r5 = r4.p.values();
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        Object r1 = r6.next();
        if (((e) r1).c == false) goto L7;
        r0.add(r1);
        goto L7
    L11:
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L13:
        if (r2.hasNext() == false) goto L22;
        e r3 = (e) r2.next();
        r7.add(new f(r3.a, (eub.g) r3.b.getValue()));
        goto L13
    L22:
        return r7;
    L15:
        return CollectionsKt.emptyList();
    }

    public static String h(eub.f r7) {
        MmRecordingSource r0 = r7.b;
        boolean r2 = false;
        if (r0 != MmRecordingSource.FEISHU_HARDWARE_RECORDER) goto L5;
    L10:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L14;
        return null;
    L14:
        JSONObject r3 = new JSONObject();
        String r4 = r7.e;
        if (r4 != null) goto L17;
    L25:
        String r5 = r7.f;
        if (r5 != null) goto L28;
    L36:
        String r6 = r7.g;
        if (r6 != null) goto L39;
    L47:
        String r8 = r7.h.get("file_unique_id_list");
        if (r8 != null) goto L50;
    L58:
        String r9 = r7.h.get("offline_line_index");
        if (r9 == null) goto L70;
        if (r9.length() <= 0) goto L63;
        boolean r10 = true;
    L64:
        if (r10 == true) goto L67;
        r9 = null;
    L67:
        if (r9 == null) goto L70;
        r3.put("offline_line_index", r9);
        goto L70
    L63:
        r10 = false;
    L70:
        if (r3.length() <= 0) goto L72;
        r2 = true;
    L72:
        if (r2 == true) goto L75;
        r3 = null;
    L75:
        if (r3 != null) goto L77;
        return null;
    L77:
        return r3.toString();
    L50:
        if (r8.length() <= 0) goto L52;
        boolean r11 = true;
    L53:
        if (r11 == true) goto L56;
        r8 = null;
    L56:
        if (r8 == null) goto L58;
        r3.put("file_unique_id_list", r8);
        goto L58
    L52:
        r11 = false;
        goto L53
    L39:
        if (r6.length() <= 0) goto L41;
        boolean r12 = true;
    L42:
        if (r12 == true) goto L45;
        r6 = null;
    L45:
        if (r6 == null) goto L47;
        r3.put("start_time_zone_offset", r6);
        goto L47
    L41:
        r12 = false;
        goto L42
    L28:
        if (r5.length() <= 0) goto L30;
        boolean r13 = true;
    L31:
        if (r13 == true) goto L34;
        r5 = null;
    L34:
        if (r5 == null) goto L36;
        r3.put("realtime_recording_stop_ms", r5);
        goto L36
    L30:
        r13 = false;
        goto L31
    L17:
        if (r4.length() <= 0) goto L19;
        boolean r14 = true;
    L20:
        if (r14 == true) goto L23;
        r4 = null;
    L23:
        if (r4 == null) goto L25;
        r3.put("realtime_recording_start_ms", r4);
        goto L25
    L19:
        r14 = false;
        goto L20
    L5:
        if (r0 == MmRecordingSource.FEISHU_HARDWARE_D1204) goto L10;
        if (r0 == MmRecordingSource.FEISHU_HARDWARE_D1204_CASE) goto L10;
        r1 = false;
        goto L12
    }

    public static boolean q(eub.f r2) {
        MmRecordingSource r0 = r2.b;
        if (r0 == MmRecordingSource.FEISHU_HARDWARE_D1204) goto L7;
        if (r0 == MmRecordingSource.FEISHU_HARDWARE_D1204_CASE) goto L7;
    L11:
        return false;
    L7:
        if (Intrinsics.areEqual(r2.h.get("offline_local_recording"), "true") == false) goto L11;
        if ((!StringsKt.isBlank(r2.d)) == false) goto L11;
        return true;
    }

    public static String s(String r4) {
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return "";
    L10:
        if (r4.length() > 10) goto L14;
        return StringsKt.repeat("*", r4.length());
    L14:
        return StringsKt.take(r4, 4) + StringsKt.repeat("*", (r4.length() - 4) - 6) + StringsKt.takeLast(r4, 6);
    L5:
        r0 = false;
        goto L6
    }

    public final void B(String r4) {
        fub.a r0 = this.a.C();
        if (r0 != null) goto L6;
        lvb.a.b(this.d, "resumeExistingUploads: drive uploader is null, taskId=" + r4);
        return;
    L6:
        r("resumeExistingUploads", new MmMinutesFileUploadSessionManager$resumeExistingUploads$1(this, r4, r0, null));
    }

    public final String n(eub.f r18) {
        eub.d r2 = (eub.d) CollectionsKt.firstOrNull(r18.c);
        String r3 = "";
        if (r2 != null) goto L5;
        return "";
    L5:
        boolean r5 = true;
        if (r2.a.length() <= 0) goto L8;
        boolean r4 = true;
    L9:
        Closeable r7 = null;
        byte[] r8 = null;
        r8 = null;
        Closeable r9 = null;
        byte[] r10 = null;
        r10 = null;
        if (r4 == false) goto L34;
        int r6 = com.ss.android.lark.officesdk.minutes.service.fileupload.a.a;
        String r11 = r2.a;
        Intrinsics.checkNotNullParameter(r11, AppbrandHostConstants.Schema_RESERVED_FIELD.PATH);
        InputStream r12 = VFSFiles.b.j(com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.c(r11));     // Catch: Throwable -> L67
        if (r12 != null) goto L69;
    L22:
        if (r8 != null) goto L24;
        com.larksuite.framework.utils.d.b(new Closeable[]{r12});
    L28:
        String r13 = this.d;
        StringBuilder r14 = new StringBuilder("computeFileHeader: use localPath, taskId=");
        r14.append(r18.a);
        r14.append(", fileName=");
        r14.append(r2.c);
        r14.append(", headerEmpty=");
        if (r3.length() == 0) goto L32;
        r5 = false;
    L32:
        r14.append(r5);
        lvb.a.a(r13, r14.toString());
        return r3;
    L24:
        r3 = StringsKt.replace$default(Base64.encodeToString(r8, 0), "\n", "", false, 4, null);     // Catch: Throwable -> L26
        com.larksuite.framework.utils.d.b(new Closeable[]{r12});
    L26:
        r9 = r12;
        goto L27
    L69:
        byte[] r15 = new byte[512];     // Catch: Throwable -> L26
        int r16 = 0;
    L16:
        if (r16 >= 512) goto L21;
        int r17 = r12.read(r15, r16, 512 - r16);     // Catch: Throwable -> L26
        if (r17 <= 0) goto L22;
        r16 = r16 + r17;
        goto L16
    L21:
        r8 = r15;
    L27:
        com.larksuite.framework.utils.d.b(new Closeable[]{r9});
        goto L28
    L34:
        Context r19 = this.t;
        if (r19 != null) goto L38;
        return "";
    L38:
        if (r2.b.length() <= 0) goto L40;
        boolean r110 = true;
    L41:
        if (r110 == false) goto L65;
        int r111 = com.ss.android.lark.officesdk.minutes.service.fileupload.a.a;
        String r112 = r2.b;
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r112, "uriStr");
        InputStream r20 = ContentResolverWrapper.openInputStream(r19.getContentResolver(), Uri.parse(r112));     // Catch: Throwable -> L68
        if (r20 != null) goto L73;
    L53:
        if (r10 != null) goto L55;
        com.larksuite.framework.utils.d.b(new Closeable[]{r20});
    L59:
        String r21 = this.d;
        StringBuilder r22 = new StringBuilder("computeFileHeader: use uri, taskId=");
        r22.append(r18.a);
        r22.append(", fileName=");
        r22.append(r2.c);
        r22.append(", headerEmpty=");
        if (r3.length() == 0) goto L63;
        r5 = false;
    L63:
        r22.append(r5);
        lvb.a.a(r21, r22.toString());
        return r3;
    L55:
        r3 = StringsKt.replace$default(Base64.encodeToString(r10, 0), "\n", "", false, 4, null);     // Catch: Throwable -> L57
        com.larksuite.framework.utils.d.b(new Closeable[]{r20});
    L57:
        r7 = r20;
        goto L58
    L73:
        byte[] r113 = new byte[512];     // Catch: Throwable -> L57
        int r114 = 0;
    L47:
        if (r114 >= 512) goto L52;
        int r115 = r20.read(r113, r114, 512 - r114);     // Catch: Throwable -> L57
        if (r115 <= 0) goto L53;
        r114 = r114 + r115;
        goto L47
    L52:
        r10 = r113;
    L58:
        com.larksuite.framework.utils.d.b(new Closeable[]{r7});
        goto L59
    L65:
        lvb.a.a(this.d, "computeFileHeader: no valid source, taskId=" + r18.a + ", fileName=" + r2.c);
        return "";
    L40:
        r110 = false;
        goto L41
    L8:
        r4 = false;
        goto L9
    }

    public final void o(String r3) {
        r("enqueueRun", new MmMinutesFileUploadSessionManager$enqueueRun$1(this, r3, null));
    }

    public final Integer u(String r5) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        JSONObject r6 = new JSONObject(r5).optJSONObject("error");     // Catch: Throwable -> L15
        if (r6 == null) goto L9;
        boolean r3 = true;
        if (r6.has("id") != true) goto L9;
    L10:
        if (r3 == false) goto L12;
        Integer r7 = Integer.valueOf(JSONObjectProtectorUtils.getInt(r6, "id"));     // Catch: Throwable -> L15
    L13:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L15
    L17:
        Throwable r2 = Result.exceptionOrNull-impl(r8);
        if (r2 != null) goto L20;
        r0 = r8;
    L22:
        return (Integer) r0;
    L20:
        lvb.a.b(this.d, "parseUploadErrorCode failed: " + r2.getMessage());
        goto L22
    L12:
        r7 = null;
    L9:
        r3 = false;
    L15:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    public final String v(String r6) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L25
        JSONObject r2 = new JSONObject(r6);     // Catch: Throwable -> L25
        JSONObject r7 = r2.optJSONObject("error");     // Catch: Throwable -> L25
        boolean r3 = false;
        if (r7 == null) goto L15;
        JSONObject r8 = r7.optJSONObject("localizedMessage");     // Catch: Throwable -> L25
        if (r8 == null) goto L15;
        String r9 = r8.optString("message");     // Catch: Throwable -> L25
        if (r9 == null) goto L15;
        if (r9.length() <= 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L15;
    L16:
        if (r9 != null) goto L23;
        r9 = r2.optString("msg");     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L25
        if (r9.length() <= 0) goto L20;
        r3 = true;
    L20:
        if (r3 == true) goto L23;
        r9 = null;
    L23:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L25
    L27:
        Throwable r5 = Result.exceptionOrNull-impl(r10);
        if (r5 != null) goto L30;
        r0 = r10;
    L32:
        return (String) r0;
    L30:
        lvb.a.b(this.d, "parseUploadErrorMessage failed: " + r5.getMessage());
        goto L32
    L12:
        r4 = false;
    L15:
        r9 = null;
    L25:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    }

    public MmMinutesFileUploadSessionManager(MinutesUCCImpl r8, com.ss.android.lark.officesdk.minutes.service.fileupload.b r9) {
        MmMinutesFileUploadBusinessTracker r0 = new MmMinutesFileUploadBusinessTracker();
        yub.d r1 = yub.d.a;
        Intrinsics.checkNotNullParameter(r8, "userComponentContext");
        Intrinsics.checkNotNullParameter(r0, "tracker");
        Intrinsics.checkNotNullParameter(r1, "appLifecycle");
        Intrinsics.checkNotNullParameter(r9, "foregroundConfig");
        this.a = r8;
        this.b = r0;
        this.c = r1;
        String r2 = "MmMinutesFileUploadSM_" + hashCode();
        this.d = r2;
        this.e = new com.ss.android.lark.officesdk.minutes.service.fileupload.c(r9, new l(this));
        this.f = new com.ss.android.lark.officesdk.minutes.service.fileupload.e(r8);
        this.g = kotlinx.coroutines.sync.b.a();
        this.h = CoroutineScopeKt.CoroutineScope(MMCoroutines.b("mm_minutes_file_upload").plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        CompletableJob r10 = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.i = r10;
        CoroutineScope r3 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(r10));
        this.j = r3;
        this.n = new k(this);
        MutableSharedFlow<eub.c> r11 = SharedFlowKt.MutableSharedFlow$default(128, 64, null, 4, null);
        this.o = r11;
        kotlinx.coroutines.flow.e.a(r11);
        this.p = new LinkedHashMap();
        this.q = new HashMap();
        CoroutineScope r12 = this.h;
        if (r12 == null) goto L5;
        lvb.a.e(r2, "init: fileUploadScope=" + System.identityHashCode(r12));
        Object r4 = MmNetworkUtils.a;
        this.k = MmNetworkUtils.c("minutes_file_upload", r12, 1000, new MmMinutesFileUploadSessionManager$1$1(this));
    L6:
        BuildersKt.launch$default(r3, null, null, new AnonymousClass2(this, null), 3, null);
        return;
    L5:
        lvb.a.b(r2, "init: fileUploadScope is null");
        goto L6
    }

    public static ErrorResult i(int r4, String r5) {
        Exception r0 = new Exception("unknown error");
        ErrorResult r1 = new ErrorResult(0);
        ErrorResult.access$002(r1, 200);
        ErrorResult.access$102(r1, NetworkErrorResult.UNKNOWN_BIZ_CODE);
        ErrorResult.access$202(r1, r4);
        ErrorResult.access$302(r1, r0);
        ErrorResult.access$402(r1, "");
        ErrorResult.access$502(r1, "");
        ErrorResult.access$602(r1, r5);
        ErrorResult.access$702(r1, "");
        ErrorResult.access$802(r1, 0);
        ErrorResult.access$902(r1, null);
        ErrorResult.access$1002(r1, null);
        ErrorResult.access$1102(r1, null);
        return r1;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:423:0x0c49 -> B:486:0x0c4e). Please report as a decompilation issue!!! */
    public final Object D(String r33, Continuation<? super Unit> r34) {
        if ((r34 instanceof MmMinutesFileUploadSessionManager$runTask$1) == false) goto L7;
        MmMinutesFileUploadSessionManager$runTask$1 r1 = (MmMinutesFileUploadSessionManager$runTask$1) r34;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        MmMinutesFileUploadSessionManager$runTask$1 r8 = r1;
        Object r0 = r8.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String r6 = "parseUploadServerResponse: request=";
        String r14 = ", source=";
        String r15 = ", fileSize=";
        String r3 = ", msg=";
        String r18 = "";
        switch(r8.label) {
            case 0: goto L46;
            case 1: goto L45;
            case 2: goto L44;
            case 3: goto L43;
            case 4: goto L42;
            case 5: goto L41;
            case 6: goto L40;
            case 7: goto L39;
            case 8: goto L38;
            case 9: goto L37;
            case 10: goto L36;
            case 11: goto L35;
            case 12: goto L34;
            case 13: goto L33;
            case 14: goto L32;
            case 15: goto L31;
            case 16: goto L30;
            case 17: goto L29;
            case 18: goto L28;
            case 19: goto L27;
            case 20: goto L26;
            case 21: goto L25;
            case 22: goto L24;
            case 23: goto L23;
            case 24: goto L22;
            case 25: goto L21;
            case 26: goto L20;
            case 27: goto L14;
            case 28: goto L13;
            case 29: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r0);
    L449:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r0);
    L455:
        return Unit.INSTANCE;
    L14:
        String r4 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: RestartPipelineException -> L18
        MmMinutesFileUploadSessionManager r7 = this;
    L445:
        r8.L$0 = null;
        r8.label = 29;
        if (r7.m(r4, r8) != r11) goto L449;
        return r11;
    L18:
        e = e;
        r7 = this;
    L451:
        lvb.a.e(r7.d, "runTask: restart pipeline after drive callback. taskId=" + r4 + ", reason=" + e.getMessage());
        r8.L$0 = null;
        r8.L$1 = null;
        r8.L$2 = null;
        r8.L$3 = null;
        r8.label = 28;
        if (r7.D(r4, r8) != r11) goto L455;
        return r11;
    L20:
        kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) r8.L$3;
        Deferred r9 = (CompletableDeferred) r8.L$2;
        List r10 = (List) r8.L$1;
        String r12 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
        Deferred r13 = r9;
        r7 = this;
        kotlinx.coroutines.sync.a r16 = r5;
        r4 = r12;
    L483:
        e r17 = r7.p.get(r4);     // Catch: Throwable -> L456
        if (r17 == null) goto L440;
        r17.g(r13);     // Catch: Throwable -> L456
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L456
    L440:
        r7.w();     // Catch: Throwable -> L456
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L456
        r16.unlock(null);
        lvb.a.e(r7.d, "runTask: waiting drive uploads complete. taskId=" + r4 + ", uploadTaskIds=" + r10);
        r8.L$0 = r4;     // Catch: RestartPipelineException -> L450
        r8.L$1 = null;     // Catch: RestartPipelineException -> L450
        r8.L$2 = null;     // Catch: RestartPipelineException -> L450
        r8.L$3 = null;     // Catch: RestartPipelineException -> L450
        r8.label = 27;     // Catch: RestartPipelineException -> L450
        if (r13.await(r8) != r11) goto L445;
        return r11;
    L450:
        e = e;
    L456:
        th = move-exception;
        r16.unlock(null);
        throw th;
    L21:
        kotlinx.coroutines.sync.a r21 = (kotlinx.coroutines.sync.a) r8.L$8;
        final Ref.ObjectRef r22 = (Ref.ObjectRef) r8.L$7;
        Iterator<eub.d> r23 = (Iterator) r8.L$6;
        List r24 = (List) r8.L$5;
        eub.g r25 = (eub.g) r8.L$4;
        fub.a r26 = (fub.a) r8.L$3;
        String r110 = (String) r8.L$2;
        Ref.ObjectRef r111 = (Ref.ObjectRef) r8.L$1;
        String r27 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
        eub.g r28 = r25;
        List r29 = r24;
        String r30 = r27;
        r7 = this;
    L486:
        e r31 = r7.p.get(r30);     // Catch: Throwable -> L430
        if (r31 == null) goto L428;
        ((ArrayList) r31.b()).add(r22.element);     // Catch: Throwable -> L430
        r7.q.put((String) r22.element, r30);     // Catch: Throwable -> L430
        r7.w();     // Catch: Throwable -> L430
    L428:
        Unit r32 = Unit.INSTANCE;     // Catch: Throwable -> L430
        r21.unlock(null);
        String r35 = r110;
        String r36 = r18;
    L398:
        if (r23.hasNext() == false) goto L433;
        eub.d r37 = r23.next();
        fub.c r112 = k(r37, r35, ((eub.f) r111.element).c());
        String r113 = r7.d;
        Iterator<eub.d> r38 = r23;
        StringBuilder r114 = new StringBuilder("runTask: create drive upload. taskId=");
        r114.append(r30);
        r114.append(", fileName=");
        String r115 = r35;
        r114.append(r37.b());
        r114.append(r15);
        r114.append(r37.c());
        r114.append(", uriEmpty=");
        if (r37.e().length() != 0) goto L402;
        boolean r39 = true;
    L403:
        r114.append(r39);
        r114.append(", localPathEmpty=");
        if (r37.d().length() != 0) goto L406;
        boolean r40 = true;
    L407:
        r114.append(r40);
        r114.append(", uploadRequest=");
        r114.append(r112);
        lvb.a.e(r113, r114.toString());
        r22 = new Ref.ObjectRef();
        r22.element = r36;
        r7.b.i((eub.f) r111.element, r28);
        String r41 = r26.q0(r112, r7.j(r30, new MmMinutesFileUploadSessionManager$runTask$createdUploadTaskId$1(r22)));
        if (r41 != null) goto L410;
        r41 = r36;
    L410:
        r22.element = r41;
        lvb.a.e(r7.d, "runTask: drive upload created. taskId=" + r30 + ", fileName=" + r37.b() + ", uploadTaskId=" + ((String) r22.element));
        if (((CharSequence) r22.element).length() != 0) goto L413;
        boolean r42 = true;
    L414:
        if (r42 == false) goto L420;
        lvb.a.b(r7.d, "runTask: drive upload create failed, empty uploadTaskId, taskId=" + r30);
        MmMinutesFileUploadErrorCode r210 = MmMinutesFileUploadErrorCode.DRIVE_UPLOAD_REQUEST_ERROR;
        r8.L$0 = null;
        r8.L$1 = null;
        r8.L$2 = null;
        r8.L$3 = null;
        r8.L$4 = null;
        r8.L$5 = null;
        r8.L$6 = null;
        r8.L$7 = null;
        r8.L$8 = null;
        r8.label = 24;
        if (P(r7, r30, r210, "upload task id empty", null, null, null, r8, 56) != r11) goto L419;
        return r11;
    L419:
        return Unit.INSTANCE;
    L420:
        r7.b.j((eub.f) r111.element, r28);
        r29.add(r22.element);
        kotlinx.coroutines.sync.a r43 = r7.g;
        r8.L$0 = r30;
        r8.L$1 = r111;
        r8.L$2 = r115;
        r8.L$3 = r26;
        r8.L$4 = r28;
        r8.L$5 = r29;
        r8.L$6 = r38;
        r8.L$7 = r22;
        r8.L$8 = r43;
        r8.label = 25;
        if (r43.a(null, r8) != r11) goto L423;
        return r11;
    L423:
        r18 = r36;
        r21 = r43;
        r110 = r115;
        r23 = r38;
        goto L486
    L413:
        r42 = false;
        goto L414
    L406:
        r40 = false;
        goto L407
    L402:
        r39 = false;
        goto L403
    L433:
        r13 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        kotlinx.coroutines.sync.a r44 = r7.g;
        r8.L$0 = r30;
        r8.L$1 = r29;
        r8.L$2 = r13;
        r8.L$3 = r44;
        r8.L$4 = null;
        r8.L$5 = null;
        r8.L$6 = null;
        r8.L$7 = null;
        r8.L$8 = null;
        r8.label = 26;
        if (r44.a(null, r8) != r11) goto L436;
        return r11;
    L436:
        r16 = r44;
        r4 = r30;
        r10 = r29;
    L430:
        th = move-exception;
        r21.unlock(null);
        throw th;
    L22:
        ResultKt.throwOnFailure(r0);
        goto L419
    L23:
        fub.a r45 = (fub.a) r8.L$3;
        r35 = (String) r8.L$2;
        Ref.ObjectRef r46 = (Ref.ObjectRef) r8.L$1;
        r30 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
        String r47 = ", fileSize=";
    L393:
        r28 = (eub.g) r0;
        if (r28 != null) goto L396;
        r28 = new eub.g(null, null, 255);
    L396:
        r29 = new ArrayList();
        r111 = r46;
        r23 = ((eub.f) r46.element).d().iterator();
        r15 = r47;
        r7 = this;
        r26 = r45;
        r36 = "";
        goto L398
    L24:
        r45 = (fub.a) r8.L$3;
        r35 = (String) r8.L$2;
        r46 = (Ref.ObjectRef) r8.L$1;
        r30 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
        r47 = ", fileSize=";
    L390:
        r8.L$0 = r30;
        r8.L$1 = r46;
        r8.L$2 = r35;
        r8.L$3 = r45;
        r8.label = 23;
        r0 = p(r30, r8);
        if (r0 != r11) goto L393;
        return r11;
    L25:
        ResultKt.throwOnFailure(r0);
    L385:
        return Unit.INSTANCE;
    L26:
        String r48 = (String) r8.L$2;
        Ref.ObjectRef r49 = (Ref.ObjectRef) r8.L$1;
        String r50 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
        Ref.ObjectRef r51 = r49;
        String r52 = r50;
        r47 = ", fileSize=";
    L379:
        fub.a r53 = this.a.C();
        if (r53 != null) goto L386;
        MmMinutesFileUploadErrorCode r54 = MmMinutesFileUploadErrorCode.DRIVE_UPLOAD_REQUEST_ERROR;
        r8.L$0 = null;
        r8.L$1 = null;
        r8.L$2 = null;
        r8.label = 21;
        if (P(this, r52, r54, "recording file uploader service missing", null, null, null, r8, 56) != r11) goto L385;
        return r11;
    L386:
        MmMinutesFileUploadTaskState r55 = MmMinutesFileUploadTaskState.Uploading;
        r8.L$0 = r52;
        r8.L$1 = r51;
        r8.L$2 = r48;
        r8.L$3 = r53;
        r8.label = 22;
        if (L(r52, r55, r8) != r11) goto L389;
        return r11;
    L389:
        r30 = r52;
        r35 = r48;
        r45 = r53;
        r46 = r51;
        goto L390
    L27:
        r48 = (String) r8.L$2;
        Ref.ObjectRef r56 = (Ref.ObjectRef) r8.L$1;
        String r57 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
        r47 = ", fileSize=";
    L371:
        eub.g r58 = (eub.g) r0;
        if (r58 == null) goto L374;
        MutableSharedFlow<eub.c> r59 = this.o;
        eub.c.d r60 = new eub.c.d(r57, (eub.f) r56.element, r58);
        r8.L$0 = r57;
        r8.L$1 = r56;
        r8.L$2 = r48;
        r8.label = 20;
        if (r59.emit(r60, r8) != r11) goto L378;
        return r11;
    L378:
        r51 = r56;
        r52 = r57;
        goto L379
    L374:
        return Unit.INSTANCE;
    L28:
        ResultKt.throwOnFailure(r0);
    L463:
        return Unit.INSTANCE;
    L29:
        ResultKt.throwOnFailure(r0);
    L316:
        return Unit.INSTANCE;
    L30:
        ResultKt.throwOnFailure(r0);
    L306:
        return Unit.INSTANCE;
    L31:
        ResultKt.throwOnFailure(r0);
    L256:
        return Unit.INSTANCE;
    L32:
        Ref.ObjectRef r61 = (Ref.ObjectRef) r8.L$1;
        String r62 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
        Object r63 = ((Result) r0).unbox-impl();
        r3 = ", msg=";
        String r310 = ", uploadErrorCode=";
        String r311 = "parseUploadServerResponse: request=";
        String r116 = r62;
        String r211 = " response parse error";
        r47 = ", fileSize=";
        Ref.ObjectRef r64 = r61;
    L251:
        if (Result.isFailure-impl(r63) == false) goto L258;
        Throwable r65 = Result.exceptionOrNull-impl(r63);
        MmMinutesFileUploadErrorCode r66 = MmMinutesFileUploadErrorCode.PREPARE_REQUEST_ERROR;
        r8.L$0 = null;
        r8.L$1 = null;
        r8.label = 15;
        if (R(r116, r66, "prepare error", r65, r8) != r11) goto L256;
        return r11;
    L258:
        if (Result.isFailure-impl(r63) == false) goto L260;
        r63 = null;
    L260:
        String r67 = (String) r63;
        if (r67 != null) goto L476;
        r67 = "";
    L476:
        Type[] r68 = new Type[1];     // Catch: Exception -> L283
        r68[0] = MmFileUploadPrepareResponse.class;     // Catch: Exception -> L281
        MmHttpBaseResp r69 = (MmHttpBaseResp) e0.b(r67, TypeToken.getParameterized(MmHttpBaseResp.class, r68).getType());     // Catch: Exception -> L281
        if (r69 != null) goto L270;
        Object r70 = Result.constructor-impl(ResultKt.createFailure(i(-1, "prepare" + r211)));     // Catch: Exception -> L281
    L287:
        if (Result.isFailure-impl(r70) == false) goto L318;
        ErrorResult r71 = Result.exceptionOrNull-impl(r70);
        if ((r71 instanceof ErrorResult) == false) goto L291;
        ErrorResult r72 = r71;
    L292:
        if (r72 != null) goto L294;
    L296:
        boolean r73 = false;
    L297:
        if (r73 == false) goto L307;
        if (r71 == null) goto L301;
        String r74 = r71.getMessage();
        if (r74 == null) goto L301;
    L302:
        r8.L$0 = null;
        r8.L$1 = null;
        r8.label = 16;
        if (N(r116, r74, r71, r8) != r11) goto L306;
        return r11;
    L301:
        r74 = "duplicate in server";
        goto L302
    L307:
        MmMinutesFileUploadErrorCode r75 = MmMinutesFileUploadErrorCode.PREPARE_REQUEST_ERROR;
        if (r71 == null) goto L311;
        String r76 = r71.getMessage();
        if (r76 == null) goto L311;
    L312:
        r8.L$0 = null;
        r8.L$1 = null;
        r8.label = 17;
        if (P(this, r116, r75, r76, r71, null, null, r8, 48) != r11) goto L316;
        return r11;
    L311:
        r76 = "prepare error";
        goto L312
    L294:
        if (r72.getStatus() != 1000131008) goto L296;
        r73 = true;
        goto L297
    L291:
        r72 = null;
        goto L292
    L318:
        if (Result.isFailure-impl(r70) == false) goto L320;
        r70 = null;
    L320:
        MmFileUploadPrepareResponse r77 = (MmFileUploadPrepareResponse) r70;
        if (r77 == null) goto L323;
        String r78 = r77.getObjectToken();
    L324:
        if (r78 != null) goto L326;
        String r79 = "";
    L327:
        if (r77 == null) goto L329;
        String r80 = r77.getVhId();
    L330:
        if (r80 != null) goto L332;
        String r117 = "";
    L333:
        if (r77 == null) goto L335;
        String r81 = r77.getUploadId();
    L336:
        if (r81 != null) goto L338;
        String r82 = "";
    L339:
        String r83 = this.d;
        StringBuilder r84 = new StringBuilder("runTask: prepare response. taskId=");
        r84.append(r116);
        r84.append(", objectTokenEmpty=");
        if (r79.length() != 0) goto L342;
        boolean r85 = true;
    L343:
        r84.append(r85);
        r84.append(", vhIdEmpty=");
        if (r117.length() != 0) goto L346;
        boolean r86 = true;
    L347:
        r84.append(r86);
        r84.append(", uploadIdEmpty=");
        if (r82.length() != 0) goto L350;
        boolean r87 = true;
    L351:
        r84.append(r87);
        lvb.a.e(r83, r84.toString());
        if (r79.length() != 0) goto L354;
        boolean r88 = true;
    L355:
        if (r88 == false) goto L357;
    L459:
        MmMinutesFileUploadErrorCode r89 = MmMinutesFileUploadErrorCode.PREPARE_REQUEST_ERROR;
        r8.L$0 = null;
        r8.L$1 = null;
        r8.label = 18;
        if (P(this, r116, r89, "prepare resp invalid", null, null, null, r8, 56) != r11) goto L463;
        return r11;
    L357:
        if (r117.length() != 0) goto L359;
        boolean r90 = true;
    L360:
        if (r90 == true) goto L459;
        if (r82.length() != 0) goto L364;
        boolean r91 = true;
    L365:
        if (r91 == true) goto L459;
        this.b.e((eub.f) r64.element, r79);
        r8.L$0 = r116;
        r8.L$1 = r64;
        r8.L$2 = r117;
        r8.label = 19;
        r0 = M(r116, r79, r117, r82, r8);
        if (r0 != r11) goto L370;
        return r11;
    L370:
        r56 = r64;
        r57 = r116;
        r48 = r117;
        goto L371
    L364:
        r91 = false;
        goto L365
    L359:
        r90 = false;
        goto L360
    L354:
        r88 = false;
        goto L355
    L350:
        r87 = false;
        goto L351
    L346:
        r86 = false;
        goto L347
    L342:
        r85 = false;
        goto L343
    L338:
        r82 = r81;
        goto L339
    L335:
        r81 = null;
        goto L336
    L332:
        r117 = r80;
        goto L333
    L329:
        r80 = null;
        goto L330
    L326:
        r79 = r78;
        goto L327
    L323:
        r78 = null;
        goto L324
    L270:
        if (r69.getCode() != 0) goto L272;
        r70 = Result.constructor-impl(r69.getData());     // Catch: Exception -> L281
        goto L287
    L272:
        Integer r92 = u(r67);     // Catch: Exception -> L281
        if (r92 == null) goto L275;
        int r93 = r92.intValue();     // Catch: Exception -> L281
    L276:
        String r94 = v(r67);     // Catch: Exception -> L281
        if (r94 != null) goto L279;
        r94 = r69.getMsg();     // Catch: Exception -> L281
    L279:
        lvb.a.b(this.d, r311 + "prepare, code=" + r69.getCode() + r310 + r93 + r3 + r94);     // Catch: Exception -> L281
        r70 = Result.constructor-impl(ResultKt.createFailure(i(r93, r94)));     // Catch: Exception -> L281
        goto L287
    L275:
        r93 = r69.getCode();     // Catch: Exception -> L281
    L281:
        e = e;
    L285:
        lvb.a.b(this.d, "parseUploadServerResponse failed: request=prepare, err=" + e.getMessage());
        Result.Companion r95 = Result.Companion;
        r70 = Result.constructor-impl(ResultKt.createFailure(i(-1, "prepare response parse error")));
    L283:
        e = e;
        goto L285
    L33:
        ResultKt.throwOnFailure(r0);
    L211:
        return Unit.INSTANCE;
    L34:
        long r96 = r8.J$0;
        String r97 = (String) r8.L$2;
        Ref.ObjectRef r118 = (Ref.ObjectRef) r8.L$1;
        String r98 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
        String r212 = r97;
        r3 = ", msg=";
        String r99 = r98;
        Ref.ObjectRef r100 = r118;
        r211 = " response parse error";
        r14 = ", source=";
        r15 = ", fileSize=";
        r6 = "parseUploadServerResponse: request=";
        String r101 = ", uploadErrorCode=";
    L198:
        String r213 = n((eub.f) r100.element);
        String r102 = this.d;
        StringBuilder r103 = new StringBuilder("runTask: fileHeader computed. taskId=");
        r103.append(r99);
        r103.append(", headerEmpty=");
        if (r213.length() != 0) goto L201;
        boolean r104 = true;
    L202:
        r103.append(r104);
        lvb.a.e(r102, r103.toString());
        if (r213.length() != 0) goto L205;
        boolean r105 = true;
    L206:
        if (r105 == false) goto L212;
        MmMinutesFileUploadErrorCode r106 = MmMinutesFileUploadErrorCode.PREPARE_REQUEST_ERROR;
        r8.L$0 = null;
        r8.L$1 = null;
        r8.L$2 = null;
        r8.label = 13;
        if (P(this, r99, r106, "file_header empty", null, null, null, r8, 56) != r11) goto L211;
        return r11;
    L212:
        String r107 = ((eub.f) r100.element).c().get("prepare_name");
        if (r107 != null) goto L215;
    L222:
        eub.d r108 = (eub.d) CollectionsKt.firstOrNull(((eub.f) r100.element).d());
        if (r108 == null) goto L225;
        r107 = r108.b();
    L226:
        String r109 = String.valueOf(r96);
        String r119 = ((eub.f) r100.element).e();
        MmRecordingSource r120 = ((eub.f) r100.element).b;
        if (r120 != MmRecordingSource.FEISHU_HARDWARE_RECORDER) goto L229;
    L234:
        boolean r121 = true;
    L235:
        if (r121 == true) goto L237;
    L242:
        boolean r122 = false;
    L243:
        if (r122 == true) goto L246;
        r119 = null;
    L246:
        String r123 = h((eub.f) r100.element);
        String r124 = ((eub.f) r100.element).b();
        String r125 = ((eub.f) r100.element).c().get("hardware_file_ids");
        String r126 = ((eub.f) r100.element).c().get("hardware_device_ids");
        r310 = r101;
        String r127 = ((eub.f) r100.element).c().get("file_unique_id_list");
        String r128 = ((eub.f) r100.element).c().get("offline_line_index");
        r311 = r6;
        xub.c r129 = new xub.c(r107, r109, r213, r212, r119, r123, r124, ((eub.f) r100.element).f());
        String r130 = this.d;
        StringBuilder r131 = new StringBuilder("runTask: request prepare. taskId=");
        r131.append(r99);
        r131.append(r14);
        r131.append(((eub.f) r100.element).f());
        r131.append(", recordUuid=");
        r131.append(((eub.f) r100.element).e());
        r131.append(", uploadUniqueId=");
        r131.append(r119);
        r131.append(", hardwareFileIds=");
        r131.append(r125);
        r131.append(", hardwareDeviceIds=");
        r131.append(r126);
        r131.append(", fileUniqueIdList=");
        r131.append(r127);
        r131.append(", offlineLineIndex=");
        r131.append(r128);
        r131.append(", name=");
        r131.append(r107);
        r47 = r15;
        r131.append(r47);
        r131.append(r109);
        r131.append(", extData=");
        r131.append(r123);
        r131.append(", doubaoBizInfo=");
        r131.append(r124);
        lvb.a.e(r130, r131.toString());
        this.b.d((eub.f) r100.element);
        MmMockAwareRequestService r132 = this.a.M();
        r8.L$0 = r99;
        r8.L$1 = r100;
        r8.L$2 = null;
        r8.label = 14;
        r63 = r132.c(String.class, r129, r8);
        r11 = r11;
        if (r63 != r11) goto L249;
        return r11;
    L249:
        r64 = r100;
        r116 = r99;
        goto L251
    L237:
        if (r119.length() <= 0) goto L239;
        boolean r133 = true;
    L240:
        if (r133 == false) goto L242;
        r122 = true;
        goto L243
    L239:
        r133 = false;
        goto L240
    L229:
        if (r120 == MmRecordingSource.FEISHU_HARDWARE_D1204) goto L234;
        if (r120 == MmRecordingSource.FEISHU_HARDWARE_D1204_CASE) goto L234;
        r121 = false;
        goto L235
    L225:
        r107 = "";
        goto L226
    L215:
        if (r107.length() <= 0) goto L217;
        boolean r134 = true;
    L218:
        if (r134 == true) goto L221;
        r107 = null;
    L221:
        if (r107 != null) goto L226;
    L217:
        r134 = false;
        goto L218
    L205:
        r105 = false;
        goto L206
    L201:
        r104 = false;
        goto L202
    L35:
        r96 = r8.J$0;
        kotlinx.coroutines.sync.a r135 = (kotlinx.coroutines.sync.a) r8.L$3;
        String r136 = (String) r8.L$2;
        Ref.ObjectRef r137 = (Ref.ObjectRef) r8.L$1;
        String r138 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
        r211 = " response parse error";
        r14 = ", source=";
        r15 = ", fileSize=";
        kotlinx.coroutines.sync.a r139 = r135;
        String r140 = r136;
        r101 = ", uploadErrorCode=";
        Ref.ObjectRef r141 = r137;
        r6 = "parseUploadServerResponse: request=";
    L488:
        e r142 = this.p.get(r138);     // Catch: Throwable -> L464
        if (r142 == null) goto L193;
        Intrinsics.checkNotNullParameter(r140, "<set-?>");     // Catch: Throwable -> L464
        r142.d = r140;     // Catch: Throwable -> L464
        Unit r143 = Unit.INSTANCE;     // Catch: Throwable -> L464
    L193:
        w();     // Catch: Throwable -> L464
        Unit r144 = Unit.INSTANCE;     // Catch: Throwable -> L464
        r139.unlock(null);
        this.b.g((eub.f) r141.element);
        MmMinutesFileUploadTaskState r145 = MmMinutesFileUploadTaskState.QuotaReady;
        r8.L$0 = r138;
        r8.L$1 = r141;
        r8.L$2 = r140;
        r8.L$3 = null;
        r8.J$0 = r96;
        r8.label = 12;
        if (L(r138, r145, r8) != r11) goto L197;
        return r11;
    L197:
        r99 = r138;
        r100 = r141;
        r212 = r140;
    L464:
        th = move-exception;
        r139.unlock(null);
        throw th;
    L36:
        ResultKt.throwOnFailure(r0);
    L185:
        return Unit.INSTANCE;
    L37:
        ResultKt.throwOnFailure(r0);
    L175:
        return Unit.INSTANCE;
    L38:
        ResultKt.throwOnFailure(r0);
    L152:
        return Unit.INSTANCE;
    L39:
        ResultKt.throwOnFailure(r0);
    L142:
        return Unit.INSTANCE;
    L40:
        ResultKt.throwOnFailure(r0);
    L96:
        return Unit.INSTANCE;
    L41:
        long r146 = r8.J$0;
        Ref.ObjectRef r147 = (Ref.ObjectRef) r8.L$1;
        String r148 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
        Object r149 = ((Result) r0).unbox-impl();
        r6 = "parseUploadServerResponse: request=";
        String r150 = ", uploadErrorCode=";
        r141 = r147;
        long r151 = r146;
        String r152 = r148;
    L91:
        if (Result.isFailure-impl(r149) == false) goto L98;
        Throwable r153 = Result.exceptionOrNull-impl(r149);
        MmMinutesFileUploadErrorCode r154 = MmMinutesFileUploadErrorCode.QUOTA_REQUEST_ERROR;
        r8.L$0 = null;
        r8.L$1 = null;
        r8.label = 6;
        if (R(r152, r154, "quota error", r153, r8) != r11) goto L96;
        return r11;
    L98:
        if (Result.isFailure-impl(r149) == false) goto L100;
        r149 = null;
    L100:
        String r155 = (String) r149;
        if (r155 != null) goto L485;
        r155 = "";
    L485:
        MmHttpBaseResp r156 = (MmHttpBaseResp) e0.b(r155, TypeToken.getParameterized(MmHttpBaseResp.class, new Type[]{MmFileUploadQuotaResponse.class}).getType());     // Catch: Exception -> L128
        if (r156 != null) goto L108;
        Object r157 = Result.constructor-impl(ResultKt.createFailure(i(-1, "quota response parse error")));     // Catch: Exception -> L128
    L110:
        r211 = " response parse error";
        r101 = r150;
    L132:
        if (Result.isFailure-impl(r157) == false) goto L144;
        Throwable r158 = Result.exceptionOrNull-impl(r157);
        MmMinutesFileUploadErrorCode r159 = MmMinutesFileUploadErrorCode.QUOTA_REQUEST_ERROR;
        if (r158 == null) goto L137;
        String r160 = r158.getMessage();
        if (r160 == null) goto L137;
    L138:
        r8.L$0 = null;
        r8.L$1 = null;
        r8.label = 7;
        if (P(this, r152, r159, r160, r158, null, null, r8, 48) != r11) goto L142;
        return r11;
    L137:
        r160 = "quota error";
        goto L138
    L144:
        if (Result.isFailure-impl(r157) == false) goto L146;
        r157 = null;
    L146:
        MmFileUploadQuotaResponse r161 = (MmFileUploadQuotaResponse) r157;
        if (r161 != null) goto L153;
        MmMinutesFileUploadErrorCode r162 = MmMinutesFileUploadErrorCode.QUOTA_REQUEST_ERROR;
        r8.L$0 = null;
        r8.L$1 = null;
        r8.label = 8;
        if (P(this, r152, r162, "quota resp invalid", null, null, null, r8, 56) != r11) goto L152;
        return r11;
    L153:
        boolean r163 = Intrinsics.areEqual(r161.getHasQuota(), Boxing.boxBoolean(true));
        HashMap<String, String> r164 = r161.getUploadTokenMap();
        if (r164 == null) goto L161;
        Set<Map.Entry<String, String>> r165 = r164.entrySet();
        if (r165 == null) goto L161;
        Map.Entry r166 = (Map.Entry) CollectionsKt.firstOrNull(r165);
        if (r166 == null) goto L161;
        r140 = (String) r166.getValue();
        if (r140 == null) goto L161;
    L162:
        String r167 = this.d;
        StringBuilder r168 = new StringBuilder("runTask: quota response. taskId=");
        r168.append(r152);
        r168.append(", hasQuota=");
        r168.append(r163);
        r168.append(", uploadTokenEmpty=");
        if (r140.length() != 0) goto L165;
        boolean r169 = true;
    L166:
        r168.append(r169);
        r168.append(", noQuotaNotice=");
        r168.append(r161.getNoQuotaNotice());
        lvb.a.e(r167, r168.toString());
        if (r163 == true) goto L177;
        MmMinutesFileUploadErrorCode r170 = MmMinutesFileUploadErrorCode.NO_QUOTA;
        String r171 = r161.getNoQuotaNotice();
        if (r171 != null) goto L171;
        r171 = "no quota";
    L171:
        eub.e r172 = I(r161);
        r8.L$0 = null;
        r8.L$1 = null;
        r8.label = 9;
        if (P(this, r152, r170, r171, null, null, r172, r8, 24) != r11) goto L175;
        return r11;
    L177:
        if (r140.length() != 0) goto L179;
        boolean r173 = true;
    L180:
        if (r173 == false) goto L186;
        MmMinutesFileUploadErrorCode r174 = MmMinutesFileUploadErrorCode.QUOTA_REQUEST_ERROR;
        r8.L$0 = null;
        r8.L$1 = null;
        r8.label = 10;
        if (P(this, r152, r174, "uploadToken empty", null, null, null, r8, 56) != r11) goto L185;
        return r11;
    L186:
        kotlinx.coroutines.sync.a r175 = this.g;
        r8.L$0 = r152;
        r8.L$1 = r141;
        r8.L$2 = r140;
        r8.L$3 = r175;
        r8.J$0 = r151;
        r8.label = 11;
        if (r175.a(null, r8) != r11) goto L189;
        return r11;
    L189:
        r139 = r175;
        r138 = r152;
        r96 = r151;
        goto L488
    L179:
        r173 = false;
        goto L180
    L165:
        r169 = false;
    L161:
        r140 = "";
        goto L162
    L108:
        if (r156.getCode() != 0) goto L111;
        r157 = Result.constructor-impl(r156.getData());     // Catch: Exception -> L128
        goto L110
    L111:
        Integer r176 = u(r155);     // Catch: Exception -> L128
        if (r176 == null) goto L114;
        int r177 = r176.intValue();     // Catch: Exception -> L128
    L115:
        String r178 = v(r155);     // Catch: Exception -> L128
        if (r178 != null) goto L118;
        r178 = r156.getMsg();     // Catch: Exception -> L128
    L118:
        String r179 = this.d;     // Catch: Exception -> L128
        r211 = " response parse error";
        StringBuilder r180 = new StringBuilder();     // Catch: Exception -> L126
        r180.append(r6);     // Catch: Exception -> L126
        r180.append("quota");     // Catch: Exception -> L126
        r180.append(", code=");     // Catch: Exception -> L126
        r180.append(r156.getCode());     // Catch: Exception -> L126
        r101 = r150;
        r180.append(r101);     // Catch: Exception -> L124
        r180.append(r177);     // Catch: Exception -> L124
        r180.append(", msg=");     // Catch: Exception -> L124
        r180.append(r178);     // Catch: Exception -> L124
        lvb.a.b(r179, r180.toString());     // Catch: Exception -> L124
        r157 = Result.constructor-impl(ResultKt.createFailure(i(r177, r178)));     // Catch: Exception -> L124
    L124:
        e = e;
    L130:
        lvb.a.b(this.d, "parseUploadServerResponse failed: request=quota, err=" + e.getMessage());
        Result.Companion r181 = Result.Companion;
        r157 = Result.constructor-impl(ResultKt.createFailure(i(-1, "quota response parse error")));
    L126:
        e = e;
    L127:
        r101 = r150;
        goto L130
    L114:
        r177 = r156.getCode();     // Catch: Exception -> L128
    L128:
        e = e;
        r211 = " response parse error";
        goto L127
    L42:
        Ref.ObjectRef r182 = (Ref.ObjectRef) r8.L$1;
        r152 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
        r6 = "parseUploadServerResponse: request=";
        r150 = ", uploadErrorCode=";
    L82:
        Iterator<T> r183 = ((eub.f) r182.element).d().iterator();
        r151 = 0;
    L84:
        if (r183.hasNext() == false) goto L86;
        r151 = r151 + ((eub.d) r183.next()).c();
        goto L84
    L86:
        String r184 = ((eub.f) r182.element).g() + '_' + r151;
        lvb.a.e(this.d, "runTask: request quota. taskId=" + r152 + ", fileInfoStr=" + r184);
        this.b.f((eub.f) r182.element);
        MmMockAwareRequestService r185 = this.a.M();
        xub.a r186 = new xub.a(r184, ((eub.f) r182.element).f());
        r8.L$0 = r152;
        r8.L$1 = r182;
        r8.J$0 = r151;
        r8.label = 5;
        r149 = r185.c(String.class, r186, r8);
        if (r149 != r11) goto L89;
        return r11;
    L89:
        r141 = r182;
        goto L91
    L43:
        ResultKt.throwOnFailure(r0);
    L77:
        return Unit.INSTANCE;
    L44:
        Ref.ObjectRef r187 = (Ref.ObjectRef) r8.L$2;
        Ref.ObjectRef r188 = (Ref.ObjectRef) r8.L$1;
        String r189 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
        r150 = ", uploadErrorCode=";
    L67:
        eub.f r190 = (eub.f) r0;
        if (r190 == null) goto L70;
        r187.element = r190;
        i r191 = i.a;
        eub.f r192 = (eub.f) r188.element;
        boolean r193 = F();
        r191.getClass();
        i.a r194 = i.a(r192, r193);
        if (r194.a() == MmMinutesFileUploadErrorCode.SUCCESS) goto L78;
        lvb.a.b(this.d, "runTask: preCheck failed. taskId=" + r189 + ", code=" + r194.a() + ", msg=" + r194.b());
        MmMinutesFileUploadErrorCode r195 = r194.a();
        String r196 = r194.b();
        r8.L$0 = null;
        r8.L$1 = null;
        r8.L$2 = null;
        r8.label = 3;
        if (P(this, r189, r195, r196, null, null, null, r8, 56) != r11) goto L77;
        return r11;
    L78:
        MmMinutesFileUploadTaskState r197 = MmMinutesFileUploadTaskState.PreCheckSuccess;
        r8.L$0 = r189;
        r8.L$1 = r188;
        r8.L$2 = null;
        r8.label = 4;
        if (L(r189, r197, r8) != r11) goto L81;
        return r11;
    L81:
        r182 = r188;
        r152 = r189;
        goto L82
    L70:
        return Unit.INSTANCE;
    L45:
        Ref.ObjectRef r198 = (Ref.ObjectRef) r8.L$3;
        kotlinx.coroutines.sync.a r199 = (kotlinx.coroutines.sync.a) r8.L$2;
        Ref.ObjectRef r200 = (Ref.ObjectRef) r8.L$1;
        String r201 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
        String r202 = r201;
    L478:
        e r203 = this.p.get(r202);     // Catch: Throwable -> L467
        if (r203 == null) goto L54;
        eub.f r204 = r203.a();     // Catch: Throwable -> L467
    L55:
        r199.unlock(null);
        if (r204 == null) goto L58;
        r198.element = r204;
        String r205 = this.d;
        StringBuilder r206 = new StringBuilder("runTask: snapshot taskId=");
        r206.append(r202);
        r206.append(", fileCount=");
        r206.append(((eub.f) r200.element).d().size());
        r206.append(", totalDeclaredSize=");
        Iterator<T> r207 = ((eub.f) r200.element).d().iterator();
        r150 = ", uploadErrorCode=";
        long r208 = 0;
    L61:
        if (r207.hasNext() == false) goto L63;
        r208 = r208 + ((eub.d) r207.next()).c();
        goto L61
    L63:
        r206.append(r208);
        r206.append(", source=");
        r206.append(((eub.f) r200.element).f());
        r206.append(", extraKeys=");
        r206.append(((eub.f) r200.element).c().keySet());
        lvb.a.e(r205, r206.toString());
        eub.f r209 = (eub.f) r200.element;
        r8.L$0 = r202;
        r8.L$1 = r200;
        r8.L$2 = r200;
        r8.L$3 = null;
        r8.label = 2;
        Object r214 = t(r202, r209, r8);
        if (r214 != r11) goto L66;
        return r11;
    L66:
        r188 = r200;
        r189 = r202;
        r0 = r214;
        r187 = r188;
        goto L67
    L58:
        return Unit.INSTANCE;
    L54:
        r204 = null;
    L467:
        th = move-exception;
        r199.unlock(null);
        throw th;
    L46:
        ResultKt.throwOnFailure(r0);
        r198 = new Ref.ObjectRef();
        r199 = this.g;
        r202 = r33;
        r8.L$0 = r202;
        r8.L$1 = r198;
        r8.L$2 = r199;
        r8.L$3 = r198;
        r8.label = 1;
        if (r199.a(null, r8) != r11) goto L49;
        return r11;
    L49:
        r200 = r198;
        goto L478
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r1 = new MmMinutesFileUploadSessionManager$runTask$1(this, r34);
        goto L8
    }

    public final Object G(eub.h r32, Continuation<? super String> r33) {
        eub.h r1 = r32;
        if ((r33 instanceof MmMinutesFileUploadSessionManager$submitRawOpusFile$1) == false) goto L7;
        MmMinutesFileUploadSessionManager$submitRawOpusFile$1 r3 = (MmMinutesFileUploadSessionManager$submitRawOpusFile$1) r33;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L18;
        if (r6 == 1) goto L17;
        if (r6 == 2) goto L16;
        if (r6 != 3) goto L15;
        ResultKt.throwOnFailure(r2);
    L49:
        return r2;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r2);
        return null;
    L17:
        r1 = (eub.h) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L21:
        d r7 = (d) r2;
        if ((r7 instanceof d.b) == false) goto L51;
        d.b r8 = (d.b) r7;
        File r9 = r8.a;
        long r10 = r1.g;
        if (r10 <= 0) goto L26;
    L25:
        long r18 = r10;
        MmRecordingSource r11 = r1.b;
        List r23 = CollectionsKt.listOf(new eub.d(r9.getAbsolutePath(), null, r9.getName(), r8.b, r18, 0, 34));
        String r12 = r1.h;
        String r13 = r1.i;
        String r14 = r1.j;
        String r15 = r1.k;
        String r16 = r1.l;
        if (r16 != null) goto L43;
    L45:
        String r29 = null;
    L46:
        eub.f r17 = new eub.f(null, r11, r23, r12, r13, r14, r15, null, r29, 129);
        r3.L$0 = null;
        r3.label = 3;
        r2 = H(r17, r3);
        if (r2 != r5) goto L49;
        return r5;
    L43:
        if ((true ^ StringsKt.isBlank(r16)) == false) goto L45;
        r29 = r16;
        goto L46
    L26:
        String r19 = r1.i;
        if (r19 == null) goto L29;
        Long r20 = StringsKt.toLongOrNull(r19);
    L30:
        String r110 = r1.j;
        if (r110 == null) goto L33;
        Long r111 = StringsKt.toLongOrNull(r110);
    L34:
        if (r20 == null) goto L39;
        if (r111 == null) goto L39;
        if (r111.longValue() <= r20.longValue()) goto L39;
        r10 = r111.longValue() - r20.longValue();
    L39:
        r10 = 1;
        goto L25
    L33:
        r111 = null;
        goto L34
    L29:
        r20 = null;
        goto L30
    L51:
        if ((r7 instanceof d.a) == false) goto L61;
        String r21 = this.d;
        StringBuilder r22 = new StringBuilder("submitRawOpusFile: mux failed, code=");
        d.a r24 = (d.a) r7;
        r22.append(r24.a.a);
        r22.append(", msg=");
        r22.append(r24.a.b);
        lvb.a.b(r21, r22.toString());
        h.a.C0013a r25 = r24.a;
        MmMinutesFileUploadErrorCode r26 = r25.a;
        String r27 = r25.b;
        r3.L$0 = null;
        r3.label = 2;
        String r28 = UUID.randomUUID().toString();
        eub.b r112 = new eub.b(r26, r27, null, 12);
        Object r30 = this.o.emit(new eub.c.g(r28, new eub.f(r28, r1.b, null, r1.h, null, null, null, null, null, BaseField.FIELD_TYPE_NAME_CARD_PHONE), r112, new eub.g(MmMinutesFileUploadTaskState.Interrupted, r112, 190)), r3);
        if (r30 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L56;
        r30 = Unit.INSTANCE;
    L56:
        if (r30 != r5) goto L58;
        return r5;
    L58:
        return null;
    L61:
        throw new NoWhenBranchMatchedException();
    L18:
        ResultKt.throwOnFailure(r2);
        lvb.a.e(this.d, "submitRawOpusFile: source=" + r1.b + ", recordUuid=" + r1.h + ", rawOpusPath=" + r1.a);
        String r31 = this.a.getCurrentUserId();
        ExecutorCoroutineDispatcher r34 = MMCoroutines.a();
        MmMinutesFileUploadSessionManager$submitRawOpusFile$muxOutcome$1 r113 = new MmMinutesFileUploadSessionManager$submitRawOpusFile$muxOutcome$1(r31, r1, null);
        r3.L$0 = r1;
        r3.label = 1;
        r2 = BuildersKt.withContext(r34, r113, r3);
        if (r2 != r5) goto L21;
        return r5;
    L7:
        r3 = new MmMinutesFileUploadSessionManager$submitRawOpusFile$1(this, r33);
        goto L8
    }

    public final Object H(eub.f r12, Continuation<? super String> r13) {
        if ((r13 instanceof MmMinutesFileUploadSessionManager$submitTask$1) == false) goto L7;
        MmMinutesFileUploadSessionManager$submitTask$1 r0 = (MmMinutesFileUploadSessionManager$submitTask$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        String r15 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L59:
        o(r15);
        return r15;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        kotlinx.coroutines.sync.a r16 = (kotlinx.coroutines.sync.a) r0.L$2;
        eub.f r4 = (eub.f) r0.L$1;
        String r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
        kotlinx.coroutines.sync.a r17 = r16;
        r15 = r5;
    L64:
    L61:
        th = move-exception;
        r17.unlock(null);
        throw th;
    L27:
        if (this.p.containsKey(r15) == false) goto L30;
        r17.unlock(null);
        return null;
    L30:
        this.p.put(r15, new e(r4, j1.a(new eub.g(MmMinutesFileUploadTaskState.Init, null, 254)), false));     // Catch: Throwable -> L61
        w();     // Catch: Throwable -> L61
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L61
        r17.unlock(null);
        lvb.a.e(this.d, "submitTask: taskId=" + r15 + ", fileCount=" + r4.c.size() + ", source=" + r4.b + ", recordUuid=" + r4.d);
        MmMinutesFileUploadBusinessTracker r18 = this.b;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r4, "param");
        if (MmMinutesFileUploadBusinessTracker.c(r4) == false) goto L56;
        JSONObject r7 = r18.a(r4).put("upload_result", "-1");
        String r8 = r4.h.get("legacy_source");
        if (r8 != null) goto L37;
    L54:
        String r9 = "entrance_hardware";
    L55:
        JSONObject r10 = r7.put("current_step", r9);
        Intrinsics.checkNotNull(r10);
        MmMinutesFileUploadBusinessTracker.m("vc_minutes_file_upload_dev", r10);
        r18.l(r4, "-1", null);
        r18.l(r4, "1", null);
        goto L56
    L37:
        switch(r8.hashCode()) {
            case -872157608: goto L51;
            case -842104834: goto L47;
            case 140075801: goto L43;
            case 1542118678: goto L39;
            default: goto L54;
        };
    L39:
        r9 = "entrance_share";
        if (r8.equals("entrance_share") == false) goto L54;
    L43:
        if (r8.equals("upload_onboarding") == false) goto L54;
        r9 = "entrance_boarding";
        goto L55
    L47:
        if (r8.equals("minutes_list") == false) goto L54;
        r9 = "entrance_action";
        goto L55
    L51:
        if (r8.equals("minutes_list_landing_page") == false) goto L54;
        r9 = "entrance_landing";
    L56:
        MutableSharedFlow<eub.c> r19 = this.o;
        eub.c.a r11 = new eub.c.a(r15, r4, MmMinutesFileUploadTaskEventOrigin.CREATED);
        r0.L$0 = r15;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 2;
        if (r19.emit(r11, r0) != r2) goto L59;
        return r2;
    L16:
        ResultKt.throwOnFailure(r14);
        lvb.a.e(this.d, "submitTask: " + r12);
        String r110 = r12.a;
        if ((!StringsKt.isBlank(r110)) == true) goto L20;
        r110 = null;
    L20:
        if (r110 != null) goto L22;
        r110 = UUID.randomUUID().toString();
    L22:
        r4 = eub.f.a(r12, r110, null, null, 510);
        kotlinx.coroutines.sync.a r111 = this.g;
        r0.L$0 = r110;
        r0.L$1 = r4;
        r0.L$2 = r111;
        r0.label = 1;
        if (r111.a(null, r0) != r2) goto L25;
        return r2;
    L25:
        String r112 = r110;
        r17 = r111;
        r15 = r112;
    L7:
        r0 = new MmMinutesFileUploadSessionManager$submitTask$1(this, r13);
        goto L8
    }

    public final MmMinutesFileUploadSessionManager$buildUploadCallback$1 j(String r2, Function0 r3) {
        return new MmMinutesFileUploadSessionManager$buildUploadCallback$1(r3, this, r2);
    }

    public final Object m(String r33, Continuation<? super Unit> r34) {
        if ((r34 instanceof MmMinutesFileUploadSessionManager$completeUploadAfterDriveUploaded$1) == false) goto L7;
        MmMinutesFileUploadSessionManager$completeUploadAfterDriveUploaded$1 r1 = (MmMinutesFileUploadSessionManager$completeUploadAfterDriveUploaded$1) r34;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        MmMinutesFileUploadSessionManager$completeUploadAfterDriveUploaded$1 r8 = r1;
        Object r0 = r8.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r8.label) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r0);
    L177:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r0);
    L172:
        return Unit.INSTANCE;
    L14:
        ResultKt.throwOnFailure(r0);
    L135:
        return Unit.INSTANCE;
    L15:
        String r3 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
        Object r4 = ((Result) r0).unbox-impl();
        String r6 = r3;
    L129:
        lvb.a.e(this.d, "completeUploadAfterDriveUploaded: finish response. taskId=" + r6 + ", resp=" + Result.toString-impl(r4));
        if (Result.isFailure-impl(r4) == false) goto L137;
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        MmMinutesFileUploadErrorCode r7 = MmMinutesFileUploadErrorCode.FINISH_REQUEST_ERROR;
        r8.L$0 = null;
        r8.label = 9;
        if (R(r6, r7, "finish error", r5, r8) != r11) goto L135;
        return r11;
    L137:
        if (Result.isFailure-impl(r4) == false) goto L139;
        r4 = null;
    L139:
        String r9 = (String) r4;
        if (r9 != null) goto L199;
        r9 = "";
    L199:
        MmHttpBaseResp r10 = (MmHttpBaseResp) e0.b(r9, TypeToken.getParameterized(MmHttpBaseResp.class, new Type[]{String.class}).getType());     // Catch: Exception -> L159
        if (r10 != null) goto L148;
        Object r12 = Result.constructor-impl(ResultKt.createFailure(i(-1, "finish response parse error")));     // Catch: Exception -> L159
    L162:
        if (Result.isFailure-impl(r12) == false) goto L173;
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L167;
        String r14 = r13.getMessage();
        if (r14 == null) goto L167;
    L168:
        r8.L$0 = null;
        r8.label = 10;
        if (Q(r6, r13, r14, r8) != r11) goto L172;
        return r11;
    L167:
        r14 = "finish error";
        goto L168
    L173:
        lvb.a.e(this.d, "completeUploadAfterDriveUploaded: finish success. taskId=" + r6);
        MmMinutesFileUploadTaskState r15 = MmMinutesFileUploadTaskState.UploadCompleted;
        r8.L$0 = null;
        r8.label = 11;
        if (L(r6, r15, r8) != r11) goto L177;
        return r11;
    L148:
        if (r10.getCode() != 0) goto L150;
        r12 = Result.constructor-impl(r10.getData());     // Catch: Exception -> L159
        goto L162
    L150:
        Integer r16 = u(r9);     // Catch: Exception -> L159
        if (r16 == null) goto L153;
        int r17 = r16.intValue();     // Catch: Exception -> L159
    L154:
        String r18 = v(r9);     // Catch: Exception -> L159
        if (r18 != null) goto L157;
        r18 = r10.getMsg();     // Catch: Exception -> L159
    L157:
        lvb.a.b(this.d, "parseUploadServerResponse: request=finish, code=" + r10.getCode() + ", uploadErrorCode=" + r17 + ", msg=" + r18);     // Catch: Exception -> L159
        r12 = Result.constructor-impl(ResultKt.createFailure(i(r17, r18)));     // Catch: Exception -> L159
        goto L162
    L153:
        r17 = r10.getCode();     // Catch: Exception -> L159
    L159:
        e = move-exception;
        lvb.a.b(this.d, "parseUploadServerResponse failed: request=finish, err=" + e.getMessage());
        Result.Companion r19 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(i(-1, "finish response parse error")));
        goto L162
    L16:
        ResultKt.throwOnFailure(r0);
    L182:
        return Unit.INSTANCE;
    L17:
        ResultKt.throwOnFailure(r0);
    L187:
        return Unit.INSTANCE;
    L18:
        eub.f r20 = (eub.f) r8.L$2;
        b r21 = (b) r8.L$1;
        r6 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
    L86:
        eub.g r22 = (eub.g) r0;
        if (r20 == null) goto L90;
        if (r22 == null) goto L90;
        MmMinutesFileUploadBusinessTracker r110 = this.b;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r20, "param");
        Intrinsics.checkNotNullParameter(r22, "status");
        MmMinutesFileUploadBusinessTracker.p(r110, r20, "uploading", "1", null, r22.d, 8);
    L90:
        String r111 = this.d;
        StringBuilder r112 = new StringBuilder("completeUploadAfterDriveUploaded: collected uploaded tokens. taskId=");
        r112.append(r6);
        r112.append(", tokenCount=");
        if (r21 == null) goto L95;
        List<String> r113 = r21.e;
        if (r113 == null) goto L95;
        int r114 = r113.size();
    L96:
        r112.append(r114);
        lvb.a.e(r111, r112.toString());
        if (r21 != null) goto L99;
    L183:
        MmMinutesFileUploadErrorCode r23 = MmMinutesFileUploadErrorCode.FINISH_REQUEST_ERROR;
        r8.L$0 = null;
        r8.L$1 = null;
        r8.L$2 = null;
        r8.label = 6;
        if (P(this, r6, r23, "uploaded file tokens invalid", null, null, null, r8, 56) != r11) goto L187;
        return r11;
    L99:
        if (r21.e.isEmpty() == true) goto L183;
        if (r21.a.length() != 0) goto L104;
        boolean r115 = true;
    L105:
        if (r115 == false) goto L107;
    L178:
        MmMinutesFileUploadErrorCode r24 = MmMinutesFileUploadErrorCode.FINISH_REQUEST_ERROR;
        r8.L$0 = null;
        r8.L$1 = null;
        r8.L$2 = null;
        r8.label = 7;
        if (P(this, r6, r24, "finish params invalid", null, null, null, r8, 56) != r11) goto L182;
        return r11;
    L107:
        if (r21.b.length() != 0) goto L109;
        boolean r116 = true;
    L110:
        if (r116 == true) goto L178;
        if (r21.c.length() != 0) goto L114;
        boolean r117 = true;
    L115:
        if (r117 == true) goto L178;
        if (r21.d.length() != 0) goto L119;
        boolean r118 = true;
    L120:
        if (r118 == true) goto L178;
        String r29 = CollectionsKt.joinToString$default(r21.e, fyb.a.COMMA, null, null, 0, null, null, 62, null);
        lvb.a.e(this.d, "completeUploadAfterDriveUploaded: request finish. taskId=" + r6 + ", objectToken=" + s(r21.b) + ", uploadId=" + r21.d + ", vhId=" + r21.c + ", tokenCount=" + r21.e.size());
        if (r20 == null) goto L126;
        if (r22 == null) goto L126;
        MmMinutesFileUploadBusinessTracker r119 = this.b;
        r119.getClass();
        Intrinsics.checkNotNullParameter(r20, "param");
        Intrinsics.checkNotNullParameter(r22, "status");
        MmMinutesFileUploadBusinessTracker.p(r119, r20, "finish", "-1", null, r22.d, 8);
    L126:
        MmMockAwareRequestService r25 = this.a.M();
        xub.b r26 = new xub.b(r21.b, r21.d, r21.a, r21.c, r29, r21.f);
        r8.L$0 = r6;
        r8.L$1 = null;
        r8.L$2 = null;
        r8.label = 8;
        r4 = r25.c(String.class, r26, r8);
        if (r4 != r11) goto L129;
        return r11;
    L119:
        r118 = false;
        goto L120
    L114:
        r117 = false;
        goto L115
    L109:
        r116 = false;
        goto L110
    L104:
        r115 = false;
    L95:
        r114 = 0;
        goto L96
    L19:
        kotlinx.coroutines.sync.a r27 = (kotlinx.coroutines.sync.a) r8.L$2;
        r21 = (b) r8.L$1;
        r6 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
    L197:
        e r28 = this.p.get(r6);     // Catch: Throwable -> L188
        if (r28 == null) goto L81;
        eub.f r30 = r28.a;     // Catch: Throwable -> L188
    L82:
        r27.unlock(null);
        r8.L$0 = r6;
        r8.L$1 = r21;
        r8.L$2 = r30;
        r8.label = 5;
        Object r31 = p(r6, r8);
        if (r31 != r11) goto L85;
        return r11;
    L85:
        r20 = r30;
        r0 = r31;
        goto L86
    L81:
        r30 = null;
    L188:
        th = move-exception;
        r27.unlock(null);
        throw th;
    L20:
        kotlinx.coroutines.sync.a r32 = (kotlinx.coroutines.sync.a) r8.L$1;
        String r35 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
        r6 = r35;
    L200:
        e r36 = this.p.get(r6);     // Catch: Throwable -> L191
        if (r36 != null) goto L50;
        Unit r37 = Unit.INSTANCE;     // Catch: Throwable -> L191
        r32.unlock(null);
        return r37;
    L50:
        List<String> r38 = r36.e;     // Catch: Throwable -> L191
        ArrayList r39 = new ArrayList();     // Catch: Throwable -> L191
        Iterator r40 = ((ArrayList) r38).iterator();     // Catch: Throwable -> L191
    L52:
        if (r40.hasNext() == false) goto L57;
        String r41 = (String) ((LinkedHashMap) r36.i).get((String) r40.next());     // Catch: Throwable -> L191
        if (r41 == null) goto L52;
        r39.add(r41);     // Catch: Throwable -> L191
        goto L52
    L57:
        if (r39.size() == ((ArrayList) r36.e).size()) goto L59;
    L72:
        b r42 = null;
    L73:
        r32.unlock(null);
        r27 = this.g;
        r8.L$0 = r6;
        r8.L$1 = r42;
        r8.L$2 = r27;
        r8.label = 4;
        if (r27.a(null, r8) != r11) goto L76;
        return r11;
    L76:
        r21 = r42;
        goto L197
    L59:
        if (r39.isEmpty() == true) goto L67;
        Iterator r43 = r39.iterator();     // Catch: Throwable -> L191
    L63:
        if (r43.hasNext() == false) goto L67;
        if (StringsKt.isBlank((String) r43.next()) == false) goto L63;
        boolean r44 = true;
    L68:
        if (r44 == true) goto L72;
        eub.g r45 = (eub.g) r36.b.getValue();     // Catch: Throwable -> L191
        r42 = new b(r36.d, r45.d, r45.e, r45.f, r39, r36.a.b);     // Catch: Throwable -> L191
    L67:
        r44 = false;
    L191:
        th = move-exception;
        r32.unlock(null);
        throw th;
    L21:
        String r46 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
    L41:
        kotlinx.coroutines.sync.a r47 = this.g;
        r8.L$0 = r46;
        r8.L$1 = r47;
        r8.label = 3;
        if (r47.a(null, r8) != r11) goto L44;
        return r11;
    L44:
        r6 = r46;
        r32 = r47;
        goto L200
    L22:
        kotlinx.coroutines.sync.a r48 = (kotlinx.coroutines.sync.a) r8.L$1;
        String r49 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
        String r50 = r49;
    L201:
        e r51 = this.p.get(r50);     // Catch: Throwable -> L194
        if (r51 == null) goto L32;
        eub.f r52 = r51.a;     // Catch: Throwable -> L194
        if (r52 == null) goto L32;
        MmRecordingSource r53 = r52.b;     // Catch: Throwable -> L194
    L33:
        r48.unlock(null);
        if (r53 == null) goto L36;
        this.e.b(r50, r53);
        MmMinutesFileUploadTaskState r54 = MmMinutesFileUploadTaskState.DriveAllUploaded;
        r8.L$0 = r50;
        r8.L$1 = null;
        r8.label = 2;
        if (L(r50, r54, r8) != r11) goto L40;
        return r11;
    L40:
        r46 = r50;
        goto L41
    L36:
        return Unit.INSTANCE;
    L32:
        r53 = null;
    L194:
        th = move-exception;
        r48.unlock(null);
        throw th;
    L23:
        ResultKt.throwOnFailure(r0);
        r48 = this.g;
        r50 = r33;
        r8.L$0 = r50;
        r8.L$1 = r48;
        r8.label = 1;
        if (r48.a(null, r8) != r11) goto L201;
        return r11;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r1 = new MmMinutesFileUploadSessionManager$completeUploadAfterDriveUploaded$1(this, r34);
        goto L8
    }

    public final Object p(String r6, Continuation<? super eub.g> r7) {
        if ((r7 instanceof MmMinutesFileUploadSessionManager$getStatusSnapshot$1) == false) goto L7;
        MmMinutesFileUploadSessionManager$getStatusSnapshot$1 r0 = (MmMinutesFileUploadSessionManager$getStatusSnapshot$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        kotlinx.coroutines.sync.a r9 = (kotlinx.coroutines.sync.a) r0.L$1;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);
        kotlinx.coroutines.sync.a r10 = r9;
        r6 = r4;
    L29:
        e r11 = this.p.get(r6);     // Catch: Throwable -> L26
        if (r11 == null) goto L23;
        z0<eub.g> r12 = r11.b;     // Catch: Throwable -> L26
        if (r12 == null) goto L23;
        eub.g r13 = (eub.g) r12.getValue();     // Catch: Throwable -> L26
    L24:
        r10.unlock(null);
        return r13;
    L23:
        r13 = null;
    L26:
        th = move-exception;
        r10.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r10 = this.g;
        r0.L$0 = r6;
        r0.L$1 = r10;
        r0.label = 1;
        if (r10.a(null, r0) != r2) goto L29;
        return r2;
    L7:
        r0 = new MmMinutesFileUploadSessionManager$getStatusSnapshot$1(this, r7);
        goto L8
    }

    public final Job r(String r9, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r10) {
        if (this.m == false) goto L6;
        lvb.a.e(this.d, "launchFileUpload: skip after release, scene=".concat(r9));
        return null;
    L6:
        CoroutineScope r2 = this.h;
        if (r2 != null) goto L11;
        lvb.a.b(this.d, "launchFileUpload: scope is null, scene=" + r9 + ", manager=" + hashCode() + ", thread=" + ThreadMethodProxy.currentThread().getName());
        return null;
    L11:
        return BuildersKt.launch$default(r2, null, null, r10, 3, null);
    }

    public final Object y(String r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof MmMinutesFileUploadSessionManager$removeTaskAfterUploadCompleted$1) == false) goto L7;
        MmMinutesFileUploadSessionManager$removeTaskAfterUploadCompleted$1 r0 = (MmMinutesFileUploadSessionManager$removeTaskAfterUploadCompleted$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        kotlinx.coroutines.sync.a r10 = (kotlinx.coroutines.sync.a) r0.L$1;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r9);
        kotlinx.coroutines.sync.a r11 = r10;
        r7 = r4;
    L36:
        e r5 = this.p.remove(r7);     // Catch: Throwable -> L33
        if (r5 != null) goto L20;
        r5 = null;
    L28:
        r11.unlock(null);
        if (r5 == null) goto L31;
        int r12 = m.a;
        m.a(r5.a);
    L31:
        lvb.a.e(this.d, "removeTaskAfterUploadCompleted: taskId=" + r7);
        return Unit.INSTANCE;
    L20:
        Iterator r6 = ((ArrayList) r5.e).iterator();     // Catch: Throwable -> L33
    L22:
        if (r6.hasNext() == false) goto L24;
        this.q.remove((String) r6.next());     // Catch: Throwable -> L33
        goto L22
    L24:
        CompletableDeferred<Unit> r13 = r5.r;     // Catch: Throwable -> L33
        if (r13 == null) goto L27;
        Job.DefaultImpls.cancel$default(r13, null, 1, null);     // Catch: Throwable -> L33
    L27:
        w();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        r11.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        r11 = this.g;
        r0.L$0 = r7;
        r0.L$1 = r11;
        r0.label = 1;
        if (r11.a(null, r0) != r2) goto L36;
        return r2;
    L7:
        r0 = new MmMinutesFileUploadSessionManager$removeTaskAfterUploadCompleted$1(this, r8);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00b0 -> B:17:0x0060). Please report as a decompilation issue!!! */
    public static final Object a(MmMinutesFileUploadSessionManager r10, List r11, Continuation r12) {
        r10.getClass();
        if ((r12 instanceof MmMinutesFileUploadSessionManager$emitRestoredTaskSnapshots$1) == false) goto L7;
        MmMinutesFileUploadSessionManager$emitRestoredTaskSnapshots$1 r0 = (MmMinutesFileUploadSessionManager$emitRestoredTaskSnapshots$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        Iterator r14 = (Iterator) r0.L$1;
        List r4 = (List) r0.L$0;
        ResultKt.throwOnFailure(r13);
        Iterator r15 = r14;
        r11 = r4;
    L18:
        if (r15.hasNext() == false) goto L30;
        f r5 = (f) r15.next();
        String r6 = r5.a.a;
        if (StringsKt.isBlank(r6) == true) goto L18;
        MutableSharedFlow<eub.c> r7 = r10.o;
        eub.c.a r8 = new eub.c.a(r6, r5.a, MmMinutesFileUploadTaskEventOrigin.RESTORED);
        r0.L$0 = r11;
        r0.L$1 = r15;
        r0.L$2 = r5;
        r0.L$3 = r6;
        r0.label = 1;
        if (r7.emit(r8, r0) == r2) goto L36;
        List r9 = r11;
        String r16 = r6;
    L26:
        MutableSharedFlow<eub.c> r17 = r10.o;
        eub.c.f r18 = new eub.c.f(r16, r5.b);
        r0.L$0 = r9;
        r0.L$1 = r15;
        r0.L$2 = null;
        r0.L$3 = null;
        r0.label = 2;
        if (r17.emit(r18, r0) == r2) goto L37;
        r11 = r9;
        goto L18
    L37:
        return r2;
    L36:
        return r2;
    L30:
        lvb.a.e(r10.d, "emitRestoredTaskSnapshots: size=" + r11.size());
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r16 = (String) r0.L$3;
        r5 = (f) r0.L$2;
        Iterator r19 = (Iterator) r0.L$1;
        r9 = (List) r0.L$0;
        ResultKt.throwOnFailure(r13);
        r15 = r19;
        goto L26
    L16:
        ResultKt.throwOnFailure(r13);
        r15 = r11.iterator();
    L7:
        r0 = new MmMinutesFileUploadSessionManager$emitRestoredTaskSnapshots$1(r10, r12);
        goto L8
    }

    public static final Object c(MmMinutesFileUploadSessionManager r5, String r6, Continuation r7) {
        r5.getClass();
        if ((r7 instanceof MmMinutesFileUploadSessionManager$hasTrackedFailure$1) == false) goto L7;
        MmMinutesFileUploadSessionManager$hasTrackedFailure$1 r0 = (MmMinutesFileUploadSessionManager$hasTrackedFailure$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        kotlinx.coroutines.sync.a r9 = (kotlinx.coroutines.sync.a) r0.L$1;
        String r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);
        kotlinx.coroutines.sync.a r11 = r9;
        r6 = r10;
    L36:
        e r12 = r5.p.get(r6);     // Catch: Throwable -> L33
        if (r12 == null) goto L29;
        z0<eub.g> r13 = r12.b;     // Catch: Throwable -> L33
        if (r13 == null) goto L29;
        eub.g r14 = (eub.g) r13.getValue();     // Catch: Throwable -> L33
        if (r14 == null) goto L29;
        if (r14.a != MmMinutesFileUploadTaskState.Interrupted) goto L29;
        if (r14.g == null) goto L29;
    L30:
        r2 = Boxing.boxBoolean(r4);     // Catch: Throwable -> L33
        r11.unlock(null);
    L32:
        return r2;
    L29:
        r4 = false;
    L33:
        th = move-exception;
        r11.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r11 = r5.g;
        r0.L$0 = r6;
        r0.L$1 = r11;
        r0.label = 1;
        if (r11.a(null, r0) != r2) goto L36;
    L7:
        r0 = new MmMinutesFileUploadSessionManager$hasTrackedFailure$1(r5, r7);
        goto L8
    }

    public static final void f(MmMinutesFileUploadSessionManager r13, String r14, e r15) {
        int r0 = RangesKt.coerceAtLeast(((ArrayList) r15.e).size(), 1);
        int r2 = 0;
        if ((true ^ r15.j.isEmpty()) == false) goto L5;
        r2 = RangesKt.coerceIn((int) (((double) CollectionsKt.sumOfInt(((LinkedHashMap) r15.j).values())) / ((double) r0)), 0, 100);
    L5:
        eub.g r1 = eub.g.a((eub.g) r15.b.getValue(), null, RangesKt.coerceAtLeast(r2, ((eub.g) r15.b.getValue()).b), 0, null, null, null, null, null, 253);
        r15.b.setValue(r1);
        lvb.a.a(r13.d, "updateCombinedPercentProgressLocked: taskId=" + r14 + ", progress=" + r1.b + ", uploadTaskCount=" + r0);
        r13.o.tryEmit(new eub.c.f(r14, r1));
    }

    public static final void g(MmMinutesFileUploadSessionManager r22, String r23, e r24) {
        long r3 = CollectionsKt.sumOfLong(((LinkedHashMap) r24.h).values());
        long r5 = CollectionsKt.sumOfLong(((LinkedHashMap) r24.g).values());
        if (r3 <= 0) goto L5;
        int r10 = RangesKt.coerceIn((int) ((r5 / r3) * ((double) 100)), 0, 100);
    L6:
        long r11 = System.currentTimeMillis();
        long r13 = r24.n;
        if (r13 <= 0) goto L12;
        long r14 = r11 - r13;
        int r21 = r10;
        long r9 = r5 - r24.m;
        if (r14 <= 0) goto L11;
        int r7 = RangesKt.coerceAtLeast((int) ((r9 / 1024.0d) / (r14 / 1000.0d)), 0);
    L13:
        r24.n = r11;
        r24.m = r5;
        r24.o = r7;
        eub.g r8 = eub.g.a((eub.g) r24.b.getValue(), null, r21, r7, null, null, null, null, null, 249);
        r24.b.setValue(r8);
        lvb.a.a(r22.d, "updateCombinedProgressLocked: taskId=" + r23 + ", progress=" + r21 + ", speedKBps=" + r7 + ", transferred=" + r5 + ", totalSize=" + r3);
        r22.o.tryEmit(new eub.c.f(r23, r8));
        return;
    L11:
        r7 = r24.o;
        goto L13
    L12:
        r21 = r10;
        r7 = r24.o;
        goto L13
    L5:
        r10 = 0;
        goto L6
    }

    public static fub.c k(eub.d r10, String r11, Map r12) {
        String r0 = r10.a;
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        Object r3 = null;
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 != null) goto L12;
        r0 = r10.b;
    L12:
        String r5 = r0;
        String r6 = r10.c;
        Long r7 = Long.valueOf(r10.d);
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator r4 = r12.entrySet().iterator();
    L14:
        if (r4.hasNext() == false) goto L18;
        Map.Entry r8 = (Map.Entry) r4.next();
        if ((!u.contains((String) r8.getKey())) == false) goto L14;
        r2.put(r8.getKey(), r8.getValue());
        goto L14
    L18:
        Map r9 = MapsKt.toMutableMap(r2);
        String r13 = (String) r12.get("extra");
        if (r13 != null) goto L33;
    L30:
        JSONObject r14 = new JSONObject();
    L31:
        r14.put("artifact-type", 8);
        r14.put("index", r10.f);
        r9.put("extra", r14.toString());
        return new fub.c(r5, r6, r7, r11, r9);
    L33:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L22
        Object r16 = Result.constructor-impl(new JSONObject(r13));     // Catch: Throwable -> L22
    L25:
        if (Result.isFailure-impl(r16) == true) goto L28;
        r3 = r16;
    L28:
        r14 = (JSONObject) r3;
        if (r14 != null) goto L31;
    L22:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L5:
        r1 = false;
        goto L6
    }

    public final Object J(eub.f r5, eub.g r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof MmMinutesFileUploadSessionManager$trackD1204OfflineAudioFeatureStatus$1) == false) goto L7;
        MmMinutesFileUploadSessionManager$trackD1204OfflineAudioFeatureStatus$1 r0 = (MmMinutesFileUploadSessionManager$trackD1204OfflineAudioFeatureStatus$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L24
    L22:
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L30;
        lvb.a.b(this.d, "[audioFeatureStatus] offline signal failed, error=" + r10);
    L30:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r8);
        if (q(r5) == false) goto L18;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L24
        MmD1204RecordingEventTracker r12 = this.a.x();     // Catch: Throwable -> L24
        String r13 = r5.d;     // Catch: Throwable -> L24
        String r14 = r6.d;     // Catch: Throwable -> L24
        r0.label = 1;     // Catch: Throwable -> L24
        if (r12.c(r13, r14, r0) != r2) goto L22;
        return r2;
    L18:
        return Unit.INSTANCE;
    L24:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new MmMinutesFileUploadSessionManager$trackD1204OfflineAudioFeatureStatus$1(this, r7);
        goto L8
    }

    public final Object K(String r17, String r18, Continuation r19) {
        if ((r19 instanceof MmMinutesFileUploadSessionManager$tryRestartPipelineFromInit$1) == false) goto L7;
        MmMinutesFileUploadSessionManager$tryRestartPipelineFromInit$1 r3 = (MmMinutesFileUploadSessionManager$tryRestartPipelineFromInit$1) r19;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r0 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        boolean r2 = r3.Z$0;
        Ref.ObjectRef r7 = (Ref.ObjectRef) r3.L$2;
        String r8 = (String) r3.L$1;
        String r9 = (String) r3.L$0;
        ResultKt.throwOnFailure(r0);
    L50:
        Object r1 = r7.element;
        if (r1 == null) goto L53;
        Boxing.boxBoolean(((CompletableDeferred) r1).completeExceptionally(new RestartPipelineException(r8)));
    L56:
        return Boxing.boxBoolean(true);
    L53:
        if (r2 == false) goto L56;
        o(r9);
        goto L56
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r10 = r3.Z$0;
        kotlinx.coroutines.sync.a r11 = (kotlinx.coroutines.sync.a) r3.L$4;
        List r12 = (List) r3.L$3;
        Ref.ObjectRef r13 = (Ref.ObjectRef) r3.L$2;
        String r14 = (String) r3.L$1;
        String r15 = (String) r3.L$0;
        ResultKt.throwOnFailure(r0);
        Ref.ObjectRef r16 = r13;
        String r110 = r14;
    L60:
        e r111 = this.p.get(r15);     // Catch: Throwable -> L57
        if (r111 != null) goto L23;
        eub.g r20 = null;
        Object r21 = null;
    L33:
        r11.unlock(r21);
        if (r20 != null) goto L38;
        return Boxing.boxBoolean(false);
    L38:
        if (r12.isEmpty() == true) goto L46;
        fub.a r22 = this.a.C();
        Iterator r23 = r12.iterator();
    L42:
        if (r23.hasNext() == false) goto L46;
        String r24 = (String) r23.next();
        if (r22 == null) goto L42;
        r22.J0(r24);
    L46:
        MutableSharedFlow<eub.c> r25 = this.o;
        eub.c.f r26 = new eub.c.f(r15, r20);
        r3.L$0 = r15;
        r3.L$1 = r110;
        r3.L$2 = r16;
        r3.L$3 = null;
        r3.L$4 = null;
        r3.Z$0 = r10;
        r3.label = 2;
        if (r25.emit(r26, r3) != r5) goto L49;
        return r5;
    L49:
        r7 = r16;
        r2 = r10;
        r8 = r110;
        r9 = r15;
        goto L50
    L23:
        int r112 = r111.q;     // Catch: Throwable -> L57
        if (r112 < 3) goto L27;
        lvb.a.b(this.d, "tryRestartPipelineFromInit: exceed retry limit. taskId=" + r15 + ", reason=" + r110 + ", retryCount=" + r111.q);     // Catch: Throwable -> L57
        r20 = null;
    L32:
        r21 = null;
        goto L33
    L27:
        r111.q = r112 + 1;     // Catch: Throwable -> L57
        eub.f r27 = r111.a;     // Catch: Throwable -> L57
        eub.f r28 = eub.f.a(r27, null, null, MapsKt.plus(r27.h, TuplesKt.to("retry_flag", "auto")), 383);     // Catch: Throwable -> L57
        Intrinsics.checkNotNullParameter(r28, "<set-?>");     // Catch: Throwable -> L57
        r111.a = r28;     // Catch: Throwable -> L57
        r16.element = r111.r;     // Catch: Throwable -> L57
        r12.addAll(r111.e);     // Catch: Throwable -> L57
        Iterator r29 = r12.iterator();     // Catch: Throwable -> L57
    L29:
        if (r29.hasNext() == false) goto L31;
        this.q.remove((String) r29.next());     // Catch: Throwable -> L57
        goto L29
    L31:
        r111.e(false);     // Catch: Throwable -> L57
        r20 = (eub.g) r111.b.getValue();     // Catch: Throwable -> L57
        w();     // Catch: Throwable -> L57
        lvb.a.e(this.d, "tryRestartPipelineFromInit: scheduled. taskId=" + r15 + ", reason=" + r110 + ", retryCount=" + r111.q + ", cancelUploadTaskIds=" + r12);     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        r11.unlock(null);
        throw th;
    L16:
        ResultKt.throwOnFailure(r0);
        r16 = new Ref.ObjectRef();
        r12 = new ArrayList();
        r11 = this.g;
        r3.L$0 = r17;
        r110 = r18;
        r3.L$1 = r110;
        r3.L$2 = r16;
        r3.L$3 = r12;
        r3.L$4 = r11;
        r3.Z$0 = false;
        r3.label = 1;
        if (r11.a(null, r3) != r5) goto L19;
        return r5;
    L19:
        r15 = r17;
        r10 = false;
    L7:
        r3 = new MmMinutesFileUploadSessionManager$tryRestartPipelineFromInit$1(this, r19);
        goto L8
    }

    public final Object L(String r13, MmMinutesFileUploadTaskState r14, Continuation<? super Unit> r15) {
        if ((r15 instanceof MmMinutesFileUploadSessionManager$updateState$1) == false) goto L7;
        MmMinutesFileUploadSessionManager$updateState$1 r0 = (MmMinutesFileUploadSessionManager$updateState$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r0.label) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r16);
    L87:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r16);
    L79:
        return Unit.INSTANCE;
    L14:
        String r17 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L74:
        String r3 = r17;
    L75:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 5;
        if (y(r3, r0) != r2) goto L79;
        return r2;
    L15:
        eub.f r18 = (eub.f) r0.L$2;
        eub.g r19 = (eub.g) r0.L$1;
        r3 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);
        eub.f r110 = r18;
    L16:
        r17 = r3;
        MutableSharedFlow<eub.c> r4 = this.o;
        eub.c.i r5 = new eub.c.i(r17, r110, r19);
        r0.L$0 = r17;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 4;
        if (r4.emit(r5, r0) != r2) goto L74;
        return r2;
    L17:
        kotlinx.coroutines.sync.a r111 = (kotlinx.coroutines.sync.a) r0.L$2;
        r19 = (eub.g) r0.L$1;
        r3 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L92:
        e r112 = this.p.get(r3);     // Catch: Throwable -> L80
        if (r112 == null) goto L38;
        r110 = r112.a;     // Catch: Throwable -> L80
    L39:
        r111.unlock(null);
        if (r110 == null) goto L75;
        MmMinutesFileUploadBusinessTracker r113 = this.b;
        r113.getClass();
        Intrinsics.checkNotNullParameter(r110, "param");
        Intrinsics.checkNotNullParameter(r19, "status");
        MmMinutesFileUploadBusinessTracker.p(r113, r110, "finish", "1", null, r19.d, 8);
        String r6 = r19.d;
        if (r113.a.add(r110.a) == true) goto L44;
        lvb.a.e("MmMinutesFileUploadBusinessTracker", "[sendMinutesCreateStatusEvent] skip duplicate success, taskId=" + r110.a);
    L68:
        r113.n(r110, 2, null);
        r0.L$0 = r3;
        r0.L$1 = r19;
        r0.L$2 = r110;
        r0.label = 3;
        if (J(r110, r19, r0) != r2) goto L16;
        return r2;
    L44:
        JSONObject r7 = new JSONObject().put(AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN, y.b(r6));
        String r8 = r110.h.get("legacy_source");
        if (r8 == null) goto L64;
        switch(r8.hashCode()) {
            case -1212996844: goto L62;
            case -872157608: goto L58;
            case -842104834: goto L55;
            case 140075801: goto L52;
            case 1542118678: goto L49;
            default: goto L64;
        };
    L49:
        String r9 = "entrance_share";
        if (r8.equals("entrance_share") == false) goto L64;
    L67:
        JSONObject r10 = r7.put("from_source", r9).put("scene", "upload");
        Intrinsics.checkNotNull(r10);
        MmMinutesFileUploadBusinessTracker.m("vc_record_upload_minutes_create_status", r10);
        goto L68
    L52:
        r9 = "upload_onboarding";
        if (r8.equals("upload_onboarding") == true) goto L67;
    L55:
        r9 = "minutes_list";
        if (r8.equals("minutes_list") == true) goto L67;
    L58:
        r9 = "minutes_list_landing_page";
        if (r8.equals("minutes_list_landing_page") == true) goto L67;
    L62:
        if (r8.equals("hardware_offline_upload") == false) goto L64;
    L65:
        r9 = "hardware";
    L64:
        if (MmMinutesFileUploadBusinessTracker.c(r110) == true) goto L65;
        r9 = "unknown";
        goto L67
    L38:
        r110 = null;
    L80:
        th = move-exception;
        r111.unlock(null);
        throw th;
    L18:
        kotlinx.coroutines.sync.a r114 = (kotlinx.coroutines.sync.a) r0.L$2;
        r14 = (MmMinutesFileUploadTaskState) r0.L$1;
        String r11 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);
        kotlinx.coroutines.sync.a r115 = r114;
        r13 = r11;
    L91:
        e r12 = this.p.get(r13);     // Catch: Throwable -> L88
        if (r12 != null) goto L27;
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L88
        r115.unlock(null);
        return r116;
    L27:
        int r20 = n.a;     // Catch: Throwable -> L88
        eub.g r21 = n.a((eub.g) r12.b.getValue(), new n.a.C0014a(r14));     // Catch: Throwable -> L88
        r12.b.setValue(r21);     // Catch: Throwable -> L88
        w();     // Catch: Throwable -> L88
        r115.unlock(null);
        lvb.a.e(this.d, "updateState: taskId=" + r13 + ", state=" + r14);
        if (r14 != MmMinutesFileUploadTaskState.UploadCompleted) goto L83;
        this.e.a(r13);
        kotlinx.coroutines.sync.a r117 = this.g;
        r0.L$0 = r13;
        r0.L$1 = r21;
        r0.L$2 = r117;
        r0.label = 2;
        if (r117.a(null, r0) != r2) goto L33;
        return r2;
    L33:
        r3 = r13;
        r111 = r117;
        r19 = r21;
        goto L92
    L83:
        MutableSharedFlow<eub.c> r118 = this.o;
        eub.c.f r119 = new eub.c.f(r13, r21);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 6;
        if (r118.emit(r119, r0) != r2) goto L87;
        return r2;
    L88:
        th = move-exception;
        r115.unlock(null);
        throw th;
    L19:
        ResultKt.throwOnFailure(r16);
        r115 = this.g;
        r0.L$0 = r13;
        r0.L$1 = r14;
        r0.L$2 = r115;
        r0.label = 1;
        if (r115.a(null, r0) != r2) goto L91;
        return r2;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r0 = new MmMinutesFileUploadSessionManager$updateState$1(this, r15);
        goto L8
    }

    public final Object l(eub.f r5, String r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof MmMinutesFileUploadSessionManager$clearD1204AudioFeatureStatusMetadata$1) == false) goto L7;
        MmMinutesFileUploadSessionManager$clearD1204AudioFeatureStatusMetadata$1 r0 = (MmMinutesFileUploadSessionManager$clearD1204AudioFeatureStatusMetadata$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L25
    L23:
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L31;
        lvb.a.b(this.d, "[audioFeatureStatus] clear failed, reason=" + r6 + ", error=" + r10);
    L31:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r8);
        if (q(r5) == false) goto L19;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L25
        MmD1204RecordingEventTracker r12 = this.a.x();     // Catch: Throwable -> L25
        String r13 = r5.d;     // Catch: Throwable -> L25
        r0.L$0 = r6;     // Catch: Throwable -> L25
        r0.label = 1;     // Catch: Throwable -> L25
        if (r12.b(r13, r6, r0) != r2) goto L23;
        return r2;
    L19:
        return Unit.INSTANCE;
    L25:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new MmMinutesFileUploadSessionManager$clearD1204AudioFeatureStatusMetadata$1(this, r7);
        goto L8
    }

    public final Object t(String r27, eub.f r28, Continuation<? super eub.f> r29) {
        String r2 = r27;
        if ((r29 instanceof MmMinutesFileUploadSessionManager$normalizeUploadSourceFiles$1) == false) goto L7;
        MmMinutesFileUploadSessionManager$normalizeUploadSourceFiles$1 r3 = (MmMinutesFileUploadSessionManager$normalizeUploadSourceFiles$1) r29;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        MmMinutesFileUploadSessionManager$normalizeUploadSourceFiles$1 r8 = r3;
        Object r0 = r8.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r8.label;
        if (r5 == 0) goto L17;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        kotlinx.coroutines.sync.a r1 = (kotlinx.coroutines.sync.a) r8.L$2;
        eub.f r6 = (eub.f) r8.L$1;
        String r7 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
        eub.f r9 = r6;
        r2 = r7;
    L118:
        e r10 = this.p.get(r2);     // Catch: Throwable -> L104
        if (r10 == null) goto L102;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");     // Catch: Throwable -> L104
        r10.a = r9;     // Catch: Throwable -> L104
    L102:
        w();     // Catch: Throwable -> L104
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L104
        r1.unlock(null);
    L107:
        return r9;
    L104:
        th = move-exception;
        r1.unlock(null);
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r0);
        return null;
    L17:
        ResultKt.throwOnFailure(r0);
        int r13 = m.a;
        Context r14 = this.t;
        String r15 = this.a.getCurrentUserId();
        Intrinsics.checkNotNullParameter(r15, "userId");
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r28, "param");
        ArrayList r16 = new ArrayList();
        Iterator r17 = r28.c.iterator();
        boolean r18 = false;
        int r19 = 0;
    L19:
        if (r17.hasNext() == false) goto L81;
        int r110 = r19 + 1;
        eub.d r20 = (eub.d) r17.next();
        if (r20.a.length() <= 0) goto L23;
        boolean r111 = true;
    L24:
        if (r111 == false) goto L27;
        r16.add(r20);
        Context r24 = r14;
        Object r23 = r11;
    L80:
        r17 = r17;
        r15 = r15;
        r19 = r110;
        r11 = r23;
        r14 = r24;
        goto L19
    L27:
        if (r20.b.length() != 0) goto L29;
        boolean r21 = true;
    L30:
        if (r21 == true) goto L31;
        if (r14 == null) goto L35;
        long r112 = System.currentTimeMillis();
        VFSFile r22 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.a(r15, "mmUpload");
        if (r22.exists() == true) goto L39;
        r22.mkdirs();
    L39:
        String r25 = r20.c;
        if (StringsKt.isBlank(r25) == false) goto L42;
        r25 = "upload_file";
    L42:
        r23 = r11;
        VFSFile r26 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.b(r22, r2 + '_' + r19 + '_' + new Regex("[\\\\/]+").replace(r25, "_"));
        InputStream r30 = ContentResolverWrapper.openInputStream(r14.getContentResolver(), UriProtector.parse(r20.b));     // Catch: Throwable -> L68
        if (r30 != null) goto L116;
        r24 = r14;
    L46:
        String r31 = "";
    L74:
        if (r31.length() != 0) goto L76;
        boolean r32 = true;
    L77:
        if (r32 == true) goto L78;
        r16.add(eub.d.a(r20, r31, 0, 62));
        r18 = true;
        goto L80
    L78:
        m.a r33 = new m.a(null, "copy uri file failed", 1);
    L85:
        r9 = r33.a;
        if (r9 != null) goto L94;
        String r34 = r33.b;
        if (r34 != null) goto L90;
        r34 = "normalize upload source failed";
    L90:
        lvb.a.b(this.d, "normalizeUploadSourceFiles failed: taskId=" + r2 + ", err=" + r34);
        MmMinutesFileUploadErrorCode r35 = MmMinutesFileUploadErrorCode.PRE_FILE_NOT_EXIST;
        r8.label = 1;
        Object r36 = r23;
        if (P(this, r27, r35, r34, null, null, null, r8, 56) != r36) goto L131;
        return r36;
    L131:
        return null;
    L94:
        Object r37 = r23;
        if (Intrinsics.areEqual(r9, r28) == true) goto L107;
        r1 = this.g;
        r8.L$0 = r2;
        r8.L$1 = r9;
        r8.L$2 = r1;
        r8.label = 2;
        if (r1.a(null, r8) != r37) goto L118;
        return r37;
    L76:
        r32 = false;
        goto L77
    L116:
        Intrinsics.checkNotNullParameter(r26, "file");     // Catch: Throwable -> L62
        com.ss.android.lark.vfs.h r113 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.a;     // Catch: Throwable -> L62
        OutputStream r114 = r113.s(r113.t(r26), false);     // Catch: Throwable -> L62
        r24 = r14;
        ByteStreamsKt.copyTo$default(r30, r114, 0, 2, null);     // Catch: Throwable -> L55
    L120:
        CloseableKt.closeFinally(r114, null);     // Catch: Throwable -> L53
        r30.close();     // Catch: Throwable -> L66
        String r38 = r26.getAbsolutePath();     // Catch: Throwable -> L66
        lvb.a.e("MmMinutesFileUploadSourceFileHelper", "copyUriToUploadLocalFile: taskId=" + r2 + ", fileName=" + r20.c + ", path=" + r38 + ", cost=" + (System.currentTimeMillis() - r112) + "ms");     // Catch: Throwable -> L66
        Intrinsics.checkNotNull(r38);     // Catch: Throwable -> L66
        r31 = r38;
    L66:
        th = th;
    L70:
        lvb.a.b("MmMinutesFileUploadSourceFileHelper", "copyUriToUploadLocalFile failed: taskId=" + r2 + ", fileName=" + r20.c + ", err=" + th.getClass().getSimpleName() + ", msg=" + th.getMessage());
        if (r26.exists() == false) goto L46;
        r26.delete();
    L55:
        th = move-exception;
        throw th;     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        CloseableKt.closeFinally(r114, th);     // Catch: Throwable -> L53
        throw th;     // Catch: Throwable -> L53
    L53:
        th = th;
    L64:
        r30.close();     // Catch: Throwable -> L66
        throw th;     // Catch: Throwable -> L66
    L62:
        th = th;
        r24 = r14;
    L68:
        th = th;
        r24 = r14;
        goto L70
    L35:
        r33 = new m.a(null, "context is null", 1);
    L32:
        r23 = r11;
        goto L85
    L31:
        r33 = new m.a(null, "file source empty", 1);
        goto L32
    L29:
        r21 = false;
        goto L30
    L23:
        r111 = false;
        goto L24
    L81:
        r23 = r11;
        if (r18 == true) goto L84;
        r33 = new m.a(r28, null, 2);
        goto L85
    L84:
        eub.f r39 = eub.f.a(r28, null, r16, null, 507);
        lvb.a.e("MmMinutesFileUploadSourceFileHelper", "normalizeUploadSourceFiles: copied uri sources. taskId=" + r2 + ", fileCount=" + r16.size());
        r33 = new m.a(r39, null, 2);
    L7:
        r3 = new MmMinutesFileUploadSessionManager$normalizeUploadSourceFiles$1(this, r29);
        goto L8
    }

    public static final Object d(MmMinutesFileUploadSessionManager r6, String r7, String r8, Continuation r9) {
        r6.getClass();
        if ((r9 instanceof MmMinutesFileUploadSessionManager$isStaleUploadTask$1) == false) goto L7;
        MmMinutesFileUploadSessionManager$isStaleUploadTask$1 r0 = (MmMinutesFileUploadSessionManager$isStaleUploadTask$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        kotlinx.coroutines.sync.a r11 = (kotlinx.coroutines.sync.a) r0.L$2;
        r8 = (String) r0.L$1;
        String r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r10);
        kotlinx.coroutines.sync.a r12 = r11;
        r7 = r5;
    L34:
        e r13 = r6.p.get(r7);     // Catch: Throwable -> L31
        if (r13 != null) goto L26;
    L28:
        Boolean r14 = Boxing.boxBoolean(r4);     // Catch: Throwable -> L31
        r12.unlock(null);
        return r14;
    L26:
        if (r13.c(r8) == true) goto L28;
        r4 = true;
    L31:
        th = move-exception;
        r12.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        if (r8.length() != 0) goto L17;
        boolean r15 = true;
    L18:
        if (r15 == true) goto L36;
        r12 = r6.g;
        r0.L$0 = r7;
        r0.L$1 = r8;
        r0.L$2 = r12;
        r0.label = 1;
        if (r12.a(null, r0) != r2) goto L34;
        return r2;
    L36:
        return Boxing.boxBoolean(false);
    L17:
        r15 = false;
    L7:
        r0 = new MmMinutesFileUploadSessionManager$isStaleUploadTask$1(r6, r9);
        goto L8
    }

    public final Object N(String r25, String r26, Throwable r27, Continuation<? super Unit> r28) {
        if ((r28 instanceof MmMinutesFileUploadSessionManager$updateToDuplicateInServer$1) == false) goto L7;
        MmMinutesFileUploadSessionManager$updateToDuplicateInServer$1 r2 = (MmMinutesFileUploadSessionManager$updateToDuplicateInServer$1) r28;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        ResultKt.throwOnFailure(r0);
    L54:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        eub.g r6 = (eub.g) r2.L$2;
        eub.f r7 = (eub.f) r2.L$1;
        String r8 = (String) r2.L$0;
        ResultKt.throwOnFailure(r0);
    L50:
        MutableSharedFlow<eub.c> r1 = this.o;
        eub.c.i r9 = new eub.c.i(r8, r7, r6);
        r2.L$0 = null;
        r2.L$1 = null;
        r2.L$2 = null;
        r2.label = 3;
        if (r1.emit(r9, r2) != r4) goto L54;
        return r4;
    L17:
        kotlinx.coroutines.sync.a r10 = (kotlinx.coroutines.sync.a) r2.L$3;
        Throwable r11 = (Throwable) r2.L$2;
        String r12 = (String) r2.L$1;
        String r13 = (String) r2.L$0;
        ResultKt.throwOnFailure(r0);
        Throwable r14 = r11;
        String r15 = r12;
    L58:
        e r16 = this.p.remove(r13);     // Catch: Throwable -> L55
        if (r16 != null) goto L27;
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L55
        r10.unlock(null);
        return r17;
    L27:
        Iterator r18 = ((ArrayList) r16.e).iterator();     // Catch: Throwable -> L55
    L29:
        if (r18.hasNext() == false) goto L31;
        this.q.remove((String) r18.next());     // Catch: Throwable -> L55
        goto L29
    L31:
        CompletableDeferred<Unit> r19 = r16.r;     // Catch: Throwable -> L55
        if (r19 == null) goto L34;
        Job.DefaultImpls.cancel$default(r19, null, 1, null);     // Catch: Throwable -> L55
    L34:
        MmMinutesFileUploadErrorCode r110 = MmMinutesFileUploadErrorCode.DUPLICATE_IN_SERVER;     // Catch: Throwable -> L55
        if ((r14 instanceof ErrorResult) == false) goto L37;
        ErrorResult r111 = (ErrorResult) r14;     // Catch: Throwable -> L55
    L38:
        if (r111 == null) goto L40;
        int r112 = r111.getStatus();     // Catch: Throwable -> L55
    L41:
        eub.b r20 = new eub.b(r110, r15, Boxing.boxInt(r112), 8);     // Catch: Throwable -> L55
        eub.g r113 = eub.g.a((eub.g) r16.b.getValue(), MmMinutesFileUploadTaskState.UploadCompleted, 0, 0, null, null, null, r20, null, 62);     // Catch: Throwable -> L55
        r16.b.setValue(r113);     // Catch: Throwable -> L55
        w();     // Catch: Throwable -> L55
        Triple r114 = new Triple(r16.a, r113, r20);     // Catch: Throwable -> L55
        r10.unlock(null);
        eub.f r21 = (eub.f) r114.component1();
        r6 = (eub.g) r114.component2();
        eub.b r22 = (eub.b) r114.component3();
        this.e.a(r13);
        m.a(r21);
        String r115 = this.d;
        StringBuilder r116 = new StringBuilder("updateToDuplicateInServer: taskId=");
        r116.append(r13);
        r116.append(", msg=");
        r116.append(r15);
        r116.append(", raw=");
        if (r14 == null) goto L45;
        String r23 = r14.getClass().getSimpleName();
    L46:
        r116.append(r23);
        r116.append(", rawCode=");
        r116.append(r22.c);
        lvb.a.e(r115, r116.toString());
        this.b.h(r21, r6, r22);
        r2.L$0 = r13;
        r2.L$1 = r21;
        r2.L$2 = r6;
        r2.L$3 = null;
        r2.label = 2;
        if (l(r21, "duplicate_in_server", r2) != r4) goto L49;
        return r4;
    L49:
        r7 = r21;
        r8 = r13;
        goto L50
    L45:
        r23 = null;
        goto L46
    L40:
        r112 = 1000131008;
        goto L41
    L37:
        r111 = null;
    L55:
        th = move-exception;
        r10.unlock(null);
        throw th;
    L18:
        ResultKt.throwOnFailure(r0);
        r10 = this.g;
        r2.L$0 = r25;
        r15 = r26;
        r2.L$1 = r15;
        r14 = r27;
        r2.L$2 = r14;
        r2.L$3 = r10;
        r2.label = 1;
        if (r10.a(null, r2) != r4) goto L21;
        return r4;
    L21:
        r13 = r25;
    L7:
        r2 = new MmMinutesFileUploadSessionManager$updateToDuplicateInServer$1(this, r28);
        goto L8
    }

    public final Object Q(String r18, Throwable r19, String r20, Continuation<? super Unit> r21) {
        String r0 = r18;
        Throwable r1 = r19;
        String r2 = r20;
        if ((r21 instanceof MmMinutesFileUploadSessionManager$updateToFinishError$1) == false) goto L7;
        MmMinutesFileUploadSessionManager$updateToFinishError$1 r4 = (MmMinutesFileUploadSessionManager$updateToFinishError$1) r21;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        MmMinutesFileUploadSessionManager$updateToFinishError$1 r7 = r4;
        Object r3 = r7.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r7.label;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 == 2) goto L18;
        if (r6 == 3) goto L17;
        if (r6 != 4) goto L16;
        ResultKt.throwOnFailure(r3);
    L75:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r3);
    L70:
        return Unit.INSTANCE;
    L18:
        MmMinutesFileUploadErrorCode r8 = (MmMinutesFileUploadErrorCode) r7.L$4;
        Integer r9 = (Integer) r7.L$3;
        r2 = (String) r7.L$2;
        Throwable r11 = (Throwable) r7.L$1;
        String r12 = (String) r7.L$0;
        ResultKt.throwOnFailure(r3);
        MmMinutesFileUploadErrorCode r14 = r8;
        r0 = r12;
        Integer r13 = r9;
        r1 = r11;
        Object r15 = r3;
    L65:
        if (((Boolean) r15).booleanValue() == false) goto L71;
        r7.L$0 = null;
        r7.L$1 = null;
        r7.L$2 = null;
        r7.L$3 = null;
        r7.L$4 = null;
        r7.label = 3;
        if (D(r0, r7) != r10) goto L70;
        return r10;
    L71:
        Throwable r16 = r1;
        Integer r17 = r13;
        String r22 = r2;
        r7.L$0 = null;
        r7.L$1 = null;
        r7.L$2 = null;
        r7.L$3 = null;
        r7.L$4 = null;
        r7.label = 4;
        if (P(this, r0, r14, r22, r16, r17, null, r7, 32) != r10) goto L75;
        return r10;
    L19:
        ResultKt.throwOnFailure(r3);
    L35:
        return Unit.INSTANCE;
    L20:
        ResultKt.throwOnFailure(r3);
        if ((r1 instanceof ErrorResult) == false) goto L23;
        ErrorResult r23 = (ErrorResult) r1;
    L24:
        if (r23 == null) goto L26;
        r13 = Boxing.boxInt(r23.getStatus());
    L27:
        if (r13 == null) goto L37;
        if (r13.intValue() != 1000131008) goto L37;
        r7.label = 1;
        if (N(r0, r2, r1, r7) != r10) goto L35;
        return r10;
    L37:
        if (r13 != null) goto L40;
    L42:
        if (r13 != null) goto L45;
    L47:
        r14 = MmMinutesFileUploadErrorCode.FINISH_REQUEST_ERROR;
    L48:
        lvb.a.e(this.d, "updateToFinishError: taskId=" + r0 + ", rawCode=" + r13 + ", errorCode=" + r14 + ", message=" + r2);
        if (r13 != null) goto L52;
    L53:
        if (r13 != null) goto L56;
    L58:
        boolean r24 = false;
    L60:
        if (r24 == false) goto L71;
        r7.L$0 = r0;
        r7.L$1 = r1;
        r7.L$2 = r2;
        r7.L$3 = r13;
        r7.L$4 = r14;
        r7.label = 2;
        r15 = K(r0, "finish_error_" + r13, r7);
        if (r15 != r10) goto L65;
        return r10;
    L56:
        if (r13.intValue() != 1000131002) goto L58;
    L59:
        r24 = true;
        goto L60
    L52:
        if (r13.intValue() == 1000131006) goto L59;
    L45:
        if (r13.intValue() != 1000131002) goto L47;
        r14 = MmMinutesFileUploadErrorCode.FINISH_REQUEST_ERROR;
        goto L48
    L40:
        if (r13.intValue() != 1000131006) goto L42;
        r14 = MmMinutesFileUploadErrorCode.ALREADY_UPLOAD;
        goto L48
    L26:
        r13 = null;
        goto L27
    L23:
        r23 = null;
    L7:
        r4 = new MmMinutesFileUploadSessionManager$updateToFinishError$1(this, r21);
        goto L8
    }

    public final Object M(String r23, String r24, String r25, String r26, Continuation<? super eub.g> r27) {
        if ((r27 instanceof MmMinutesFileUploadSessionManager$updateStatusFields$1) == false) goto L7;
        MmMinutesFileUploadSessionManager$updateStatusFields$1 r2 = (MmMinutesFileUploadSessionManager$updateStatusFields$1) r27;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        eub.g r6 = (eub.g) r2.L$0;
        ResultKt.throwOnFailure(r0);
        return r6;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        kotlinx.coroutines.sync.a r7 = (kotlinx.coroutines.sync.a) r2.L$4;
        String r8 = (String) r2.L$3;
        String r9 = (String) r2.L$2;
        String r10 = (String) r2.L$1;
        String r11 = (String) r2.L$0;
        ResultKt.throwOnFailure(r0);
        String r12 = r9;
        String r13 = r10;
    L33:
        e r1 = this.p.get(r11);     // Catch: Throwable -> L30
        if (r1 != null) goto L24;
        r7.unlock(null);
        return null;
    L24:
        eub.g r14 = eub.g.a((eub.g) r1.b.getValue(), null, 0, 0, r13, r12, r8, null, null, 135);     // Catch: Throwable -> L30
        r1.b.setValue(r14);     // Catch: Throwable -> L30
        w();     // Catch: Throwable -> L30
        r7.unlock(null);
        lvb.a.e(this.d, "updateStatusFields: taskId=" + r11 + ", objectToken=" + s(r13) + ", vhId=" + r12 + ", uploadId=" + r8);
        MutableSharedFlow<eub.c> r15 = this.o;
        eub.c.f r16 = new eub.c.f(r11, r14);
        r2.L$0 = r14;
        r2.L$1 = null;
        r2.L$2 = null;
        r2.L$3 = null;
        r2.L$4 = null;
        r2.label = 2;
        if (r15.emit(r16, r2) != r4) goto L29;
        return r4;
    L29:
        return r14;
    L30:
        th = move-exception;
        r7.unlock(null);
        throw th;
    L16:
        ResultKt.throwOnFailure(r0);
        r7 = this.g;
        r2.L$0 = r23;
        r13 = r24;
        r2.L$1 = r13;
        r12 = r25;
        r2.L$2 = r12;
        r2.L$3 = r26;
        r2.L$4 = r7;
        r2.label = 1;
        if (r7.a(null, r2) != r4) goto L19;
        return r4;
    L19:
        r8 = r26;
        r11 = r23;
    L7:
        r2 = new MmMinutesFileUploadSessionManager$updateStatusFields$1(this, r27);
        goto L8
    }

    public final Object R(String r14, MmMinutesFileUploadErrorCode r15, String r16, Throwable r17, ContinuationImpl r18) {
        String r3 = null;
        boolean r5 = true;
        if (r15 == MmMinutesFileUploadErrorCode.PREPARE_REQUEST_ERROR) goto L7;
        if (r15 == MmMinutesFileUploadErrorCode.FINISH_REQUEST_ERROR) goto L7;
    L26:
        if (r17 == null) goto L31;
        String r2 = r17.getMessage();
        if (r2 == null) goto L31;
        String r8 = r2;
    L32:
        boolean r4 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.c.a();
        int r10 = com.ss.android.lark.officesdk.minutes.service.fileupload.g.a;
        if (r17 != null) goto L36;
    L70:
        boolean r11 = false;
    L72:
        if (r11 == true) goto L76;
        if (r4 == true) goto L76;
        r5 = false;
    L76:
        if (r5 == false) goto L78;
        MmMinutesFileUploadErrorCode r6 = MmMinutesFileUploadErrorCode.NETWORK_ERROR;
    L79:
        String r7 = this.d;
        StringBuilder r12 = new StringBuilder("updateToRequestError: taskId=");
        r12.append(r14);
        r12.append(", requestErrorCode=");
        r12.append(r15);
        r12.append(", mappedCode=");
        r12.append(r6);
        r12.append(", isNetworkUnavailable=");
        r12.append(r4);
        r12.append(", raw=");
        if (r17 == null) goto L82;
        String r0 = r17.getClass().getSimpleName();
    L83:
        r12.append(r0);
        r12.append(", rawMessage=");
        if (r17 == null) goto L86;
        r3 = r17.getMessage();
    L86:
        r12.append(r3);
        lvb.a.e(r7, r12.toString());
        Object r1 = P(this, r14, r6, r8, r17, null, null, r18, 48);
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L90;
        return r1;
    L90:
        return Unit.INSTANCE;
    L82:
        r0 = null;
        goto L83
    L78:
        r6 = r15;
        goto L79
    L36:
        if ((r17 instanceof ErrorResult) == false) goto L38;
        ErrorResult r13 = (ErrorResult) r17;
    L39:
        if (r13 == null) goto L41;
        Integer r19 = Integer.valueOf(r13.getStatus());
    L42:
        String r110 = r17.getMessage();
        if (r110 != null) goto L45;
        r110 = "";
    L45:
        String r111 = r110.toLowerCase(Locale.ROOT);
        if (r19 == null) goto L51;
        if (r19.intValue() != 100052) goto L51;
    L71:
        r11 = true;
    L51:
        if (StringsKt.contains$default(r111, "code=100052", false, 2, null) == true) goto L71;
        if (StringsKt.contains$default(r111, "code=10003", false, 2, null) == true) goto L71;
        if (StringsKt.contains$default(r111, "code: 10003", false, 2, null) == true) goto L71;
        if (StringsKt.contains$default(r111, "code=10004", false, 2, null) == true) goto L61;
        if (StringsKt.contains$default(r111, "code: 10004", false, 2, null) == true) goto L61;
    L63:
        boolean r112 = false;
    L64:
        if (r112 == true) goto L71;
        if (StringsKt.contains$default(r111, "offline", false, 2, null) == true) goto L71;
        if (StringsKt.contains$default(r111, "network", false, 2, null) == false) goto L70;
    L61:
        if (StringsKt.contains$default(r111, "dozemode", false, 2, null) == false) goto L63;
        r112 = true;
        goto L64
    L41:
        r19 = null;
        goto L42
    L38:
        r13 = null;
    L31:
        r8 = r16;
    L7:
        if ((r17 instanceof ErrorResult) == false) goto L9;
        ErrorResult r9 = (ErrorResult) r17;
    L10:
        if (r9 != null) goto L12;
    L14:
        boolean r20 = false;
    L15:
        if (r20 == false) goto L26;
        if (r17 == null) goto L19;
        String r21 = r17.getMessage();
        if (r21 == null) goto L19;
    L20:
        Object r22 = N(r14, r21, r17, r18);
        if (r22 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        return r22;
    L24:
        return Unit.INSTANCE;
    L19:
        r21 = r16;
        goto L20
    L12:
        if (r9.getStatus() != 1000131008) goto L14;
        r20 = true;
        goto L15
    L9:
        r9 = null;
        goto L10
    }

    public static final Object e(MmMinutesFileUploadSessionManager r17, String r18, String r19, int r20, String r21, Continuation r22) {
        r17.getClass();
        if ((r22 instanceof MmMinutesFileUploadSessionManager$tryRetryDriveUpload$1) == false) goto L7;
        MmMinutesFileUploadSessionManager$tryRetryDriveUpload$1 r2 = (MmMinutesFileUploadSessionManager$tryRetryDriveUpload$1) r22;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        int r6 = r2.I$0;
        final String r7 = (String) r2.L$1;
        String r8 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L50:
        fub.a r9 = r17.a.C();
        if (r9 != null) goto L53;
        lvb.a.b(r17.d, "tryRetryDriveUpload: drive uploader is null, taskId=" + r8 + ", uploadTaskId=" + r7);
        return Boxing.boxBoolean(false);
    L53:
        boolean r10 = r9.W(r7, new MmMinutesFileUploadSessionManager$buildUploadCallback$1(new MmMinutesFileUploadSessionManager$tryRetryDriveUpload$resumed$1(r7), r17, r8));
        lvb.a.e(r17.d, "tryRetryDriveUpload: resume result. taskId=" + r8 + ", uploadTaskId=" + r7 + ", retryIndex=" + r6 + ", resumed=" + r10);
        return Boxing.boxBoolean(true);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r11 = r2.I$0;
        kotlinx.coroutines.sync.a r12 = (kotlinx.coroutines.sync.a) r2.L$3;
        String r13 = (String) r2.L$2;
        String r14 = (String) r2.L$1;
        String r15 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L59:
        e r16 = r17.p.get(r15);     // Catch: Throwable -> L56
        if (r16 != null) goto L30;
    L43:
        Integer r23 = null;
    L44:
        r12.unlock(null);
        if (r23 == null) goto L55;
        int r24 = r23.intValue();
        lvb.a.b(r17.d, "tryRetryDriveUpload: retry drive resume. taskId=" + r15 + ", uploadTaskId=" + r14 + ", retryIndex=" + r24 + ", code=" + r11 + ", message=" + r13);
        r2.L$0 = r15;
        r2.L$1 = r14;
        r2.L$2 = null;
        r2.L$3 = null;
        r2.I$0 = r24;
        r2.label = 2;
        if (DelayKt.delay(2000, r2) == r4) goto L65;
        r6 = r24;
        r7 = r14;
        r8 = r15;
        goto L50
    L65:
        return r4;
    L55:
        return Boxing.boxBoolean(false);
    L30:
        if (r16.c(r14) == false) goto L43;
        if (Intrinsics.areEqual(((LinkedHashMap) r16.f).get(r14), Boxing.boxBoolean(true)) == true) goto L43;
        Integer r25 = (Integer) ((LinkedHashMap) r16.k).get(r14);     // Catch: Throwable -> L56
        if (r25 == null) goto L37;
        int r26 = r25.intValue();     // Catch: Throwable -> L56
    L39:
        if (r26 >= 3) goto L43;
        int r27 = r26 + 1;     // Catch: Throwable -> L56
        r16.k.put(r14, Boxing.boxInt(r27));     // Catch: Throwable -> L56
        Intrinsics.checkNotNullParameter(r14, "uploadTaskId");     // Catch: Throwable -> L56
        r16.l.remove(r14);     // Catch: Throwable -> L56
        r17.w();     // Catch: Throwable -> L56
        r23 = Boxing.boxInt(r27);     // Catch: Throwable -> L56
        goto L44
    L37:
        r26 = 0;
    L56:
        th = move-exception;
        r12.unlock(null);
        throw th;
    L16:
        ResultKt.throwOnFailure(r1);
        if (r19.length() != 0) goto L19;
        boolean r28 = true;
    L20:
        if (r28 == true) goto L61;
        r12 = r17.g;
        r2.L$0 = r18;
        r2.L$1 = r19;
        r13 = r21;
        r2.L$2 = r13;
        r2.L$3 = r12;
        r2.I$0 = r20;
        r2.label = 1;
        if (r12.a(null, r2) == r4) goto L64;
        r15 = r18;
        r14 = r19;
        r11 = r20;
        goto L59
    L64:
        return r4;
    L61:
        return Boxing.boxBoolean(false);
    L19:
        r28 = false;
    L7:
        r2 = new MmMinutesFileUploadSessionManager$tryRetryDriveUpload$1(r17, r22);
        goto L8
    }

    public final Object O(String r19, MmMinutesFileUploadErrorCode r20, String r21, Throwable r22, Integer r23, eub.e r24, Continuation<? super Unit> r25) {
        if ((r25 instanceof MmMinutesFileUploadSessionManager$updateToError$1) == false) goto L7;
        MmMinutesFileUploadSessionManager$updateToError$1 r2 = (MmMinutesFileUploadSessionManager$updateToError$1) r25;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        ResultKt.throwOnFailure(r0);
    L50:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r0);
    L45:
        return Unit.INSTANCE;
    L17:
        kotlinx.coroutines.sync.a r6 = (kotlinx.coroutines.sync.a) r2.L$6;
        eub.e r9 = (eub.e) r2.L$5;
        Integer r10 = (Integer) r2.L$4;
        Throwable r11 = (Throwable) r2.L$3;
        String r12 = (String) r2.L$2;
        MmMinutesFileUploadErrorCode r13 = (MmMinutesFileUploadErrorCode) r2.L$1;
        String r14 = (String) r2.L$0;
        ResultKt.throwOnFailure(r0);
        eub.e r15 = r9;
        MmMinutesFileUploadErrorCode r16 = r13;
        Integer r17 = r10;
        String r18 = r12;
    L54:
        e r1 = this.p.get(r14);     // Catch: Throwable -> L51
        if (r1 != null) goto L27;
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L51
        r6.unlock(null);
        return r7;
    L27:
        eub.b r110 = new eub.b(r16, r18, r17, r15);     // Catch: Throwable -> L51
        int r111 = n.a;     // Catch: Throwable -> L51
        eub.g r8 = n.a((eub.g) r1.b.getValue(), new n.a.b(r110));     // Catch: Throwable -> L51
        r1.b.setValue(r8);     // Catch: Throwable -> L51
        w();     // Catch: Throwable -> L51
        Triple r112 = new Triple(r1.a, r8, r110);     // Catch: Throwable -> L51
        r6.unlock(null);
        eub.f r26 = (eub.f) r112.component1();
        eub.g r27 = (eub.g) r112.component2();
        eub.b r28 = (eub.b) r112.component3();
        this.e.a(r14);
        String r113 = this.d;
        StringBuilder r114 = new StringBuilder("updateToError: taskId=");
        r114.append(r14);
        r114.append(", code=");
        r114.append(r16);
        r114.append(", msg=");
        r114.append(r18);
        r114.append(", raw=");
        if (r11 == null) goto L31;
        String r29 = r11.getClass().getSimpleName();
    L32:
        r114.append(r29);
        r114.append(", rawCode=");
        r114.append(r17);
        r114.append(", rawMessage=");
        if (r11 == null) goto L35;
        String r30 = r11.getMessage();
    L36:
        r114.append(r30);
        lvb.a.b(r113, r114.toString());
        if (r16 != MmMinutesFileUploadErrorCode.NETWORK_ERROR) goto L39;
        boolean r31 = true;
    L40:
        if (r31 == false) goto L46;
        lvb.a.e(this.d, "updateToError: emit recoverable interrupt, taskId=" + r14 + ", code=" + r16);
        MutableSharedFlow<eub.c> r32 = this.o;
        eub.c.f r33 = new eub.c.f(r14, r27);
        r2.L$0 = null;
        r2.L$1 = null;
        r2.L$2 = null;
        r2.L$3 = null;
        r2.L$4 = null;
        r2.L$5 = null;
        r2.L$6 = null;
        r2.label = 2;
        if (r32.emit(r33, r2) != r4) goto L45;
        return r4;
    L46:
        this.b.h(r26, r27, r28);
        MutableSharedFlow<eub.c> r34 = this.o;
        eub.c.g r35 = new eub.c.g(r14, r26, r28, r27);
        r2.L$0 = null;
        r2.L$1 = null;
        r2.L$2 = null;
        r2.L$3 = null;
        r2.L$4 = null;
        r2.L$5 = null;
        r2.L$6 = null;
        r2.label = 3;
        if (r34.emit(r35, r2) != r4) goto L50;
        return r4;
    L39:
        r31 = false;
        goto L40
    L35:
        r30 = null;
        goto L36
    L31:
        r29 = null;
    L51:
        th = move-exception;
        r6.unlock(null);
        throw th;
    L18:
        ResultKt.throwOnFailure(r0);
        r6 = this.g;
        r2.L$0 = r19;
        r16 = r20;
        r2.L$1 = r16;
        r18 = r21;
        r2.L$2 = r18;
        r11 = r22;
        r2.L$3 = r11;
        r17 = r23;
        r2.L$4 = r17;
        r15 = r24;
        r2.L$5 = r15;
        r2.L$6 = r6;
        r2.label = 1;
        if (r6.a(null, r2) != r4) goto L21;
        return r4;
    L21:
        r14 = r19;
    L7:
        r2 = new MmMinutesFileUploadSessionManager$updateToError$1(this, r25);
        goto L8
    }

    public static /* synthetic */ Object P(MmMinutesFileUploadSessionManager r10, String r11, MmMinutesFileUploadErrorCode r12, String r13, Throwable r14, Integer r15, eub.e r16, Continuation r17, int r18) {
        if ((r18 & 8) == 0) goto L5;
        Throwable r6 = null;
    L7:
        if ((r18 & 16) != 0) goto L9;
        Integer r7 = r15;
    L18:
        if ((r18 & 32) == 0) goto L20;
        eub.e r8 = null;
    L22:
        return r10.O(r11, r12, r13, r6, r7, r8, r17);
    L20:
        r8 = r16;
        goto L22
    L9:
        if ((r6 instanceof ErrorResult) == false) goto L11;
        ErrorResult r0 = (ErrorResult) r6;
    L12:
        if (r0 == null) goto L14;
        Integer r1 = Integer.valueOf(r0.getStatus());
    L15:
        r7 = r1;
        goto L18
    L14:
        r1 = null;
        goto L15
    L11:
        r0 = null;
        goto L12
    L5:
        r6 = r14;
        goto L7
    }
}
