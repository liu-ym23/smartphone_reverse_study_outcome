package com.obric.memorydata.memory.review.trace;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0004)*+,B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\fJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\nJ\u0014\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\fJ\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J \u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#H\u0002J\u0012\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\f*\u00020\bH\u0002J\u0010\u0010%\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0014\u0010&\u001a\u00020'*\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore;", "", "rootDirProvider", "Lkotlin/Function0;", "Ljava/io/File;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "writeViewTrees", "Lorg/json/JSONArray;", "logId", "", "observationIds", "", "", "viewTrees", "expandReportData", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$ExpandResult;", "reportData", "maxViewTreeFileBytes", "deleteFiles", "", "fileNames", "fileNamesFrom", "array", "readStoredBatch", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$StoredViewTreeBatchReadResult;", "file", "parseAlignedBatch", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$StoredViewTreeBatch;", "alignedJson", "Lorg/json/JSONObject;", "readFailure", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$StoredViewTreeBatchReadResult$Failure;", "operation", "error", "", "toStringListPreservingEmpty", "buildFileName", "isInDir", "", "rootDir", "StoredViewTreeBatch", "StoredViewTreeBatchReadResult", "ExpandResult", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10498a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<File> f10499b;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$Companion;", "", "<init>", "()V", "KEY_FORMAT", "", "KEY_OBSERVATION_IDS", "FORMAT_OBSERVATION_ALIGNED_V1", "default", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private static final File b() {
            return new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "memory_trace_report/viewtree");
        }

        public static /* synthetic */ File lambda$lpdg_NBpZyPpRfrRdf3slnrLZyA() {
            return b();
        }

        public final k a() {
            return new k($$Lambda$k$a$lpdg_NBpZyPpRfrRdf3slnrLZyA.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$ExpandResult;", "", "<init>", "()V", "Success", "MissingFile", "ReadError", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$ExpandResult$MissingFile;", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$ExpandResult$ReadError;", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$ExpandResult$Success;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class b {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$ExpandResult$MissingFile;", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$ExpandResult;", "fileNames", "", "", "<init>", "(Ljava/util/List;)V", "getFileNames", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final List<String> f10500a;

            public a(List<String> r3) {
                List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r4, "fileNames");
                super(null);
                this.f10500a = r4;
            }

            public final List<String> a() {
                return this.f10500a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f10500a, r6.f10500a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f10500a.hashCode();
            }

            public String toString() {
                return "MissingFile(fileNames=" + this.f10500a + ')';
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.memory.review.trace.k$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$ExpandResult$ReadError;", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$ExpandResult;", "fileNames", "", "", "failedFilePath", "operation", "errorType", "errorMessage", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFileNames", "()Ljava/util/List;", "getFailedFilePath", "()Ljava/lang/String;", "getOperation", "getErrorType", "getErrorMessage", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0515b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final List<String> f10501a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f10502b;
            private final String c;
            private final String d;
            private final String e;

            public C0515b(List<String> r3, String r4, String r5, String r6, String r7) {
                List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r8, "fileNames");
                Intrinsics.checkNotNullParameter(r4, "failedFilePath");
                Intrinsics.checkNotNullParameter(r5, "operation");
                Intrinsics.checkNotNullParameter(r6, "errorType");
                Intrinsics.checkNotNullParameter(r7, "errorMessage");
                super(null);
                this.f10501a = r8;
                this.f10502b = r4;
                this.c = r5;
                this.d = r6;
                this.e = r7;
            }

            public final List<String> a() {
                return this.f10501a;
            }

            public final String b() {
                return this.f10502b;
            }

            public final String c() {
                return this.c;
            }

            public final String d() {
                return this.d;
            }

            public final String e() {
                return this.e;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0515b.class) == true) goto L8;
                return false;
            L8:
                C0515b r6 = (C0515b) ZeusTransformUtils.preCheckCast(r5, C0515b.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f10501a, r6.f10501a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f10502b, r6.f10502b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
                return false;
            L23:
                return true;
            }

            public int hashCode() {
                return (((((((this.f10501a.hashCode() * 31) + this.f10502b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
            }

            public String toString() {
                return "ReadError(fileNames=" + this.f10501a + ", failedFilePath=" + this.f10502b + ", operation=" + this.c + ", errorType=" + this.d + ", errorMessage=" + this.e + ')';
            }
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$ExpandResult$Success;", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$ExpandResult;", "reportData", "Lorg/json/JSONObject;", "fileNames", "", "", "skippedViewTreeFileCount", "", "skippedViewTreeFileBytes", "", "<init>", "(Lorg/json/JSONObject;Ljava/util/List;IJ)V", "getReportData", "()Lorg/json/JSONObject;", "getFileNames", "()Ljava/util/List;", "getSkippedViewTreeFileCount", "()I", "getSkippedViewTreeFileBytes", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final JSONObject f10503a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final List<String> f10504b;
            private final int c;
            private final long d;

            public c(JSONObject r3, List<String> r4, int r5, long r6) {
                List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, "reportData");
                Intrinsics.checkNotNullParameter(r7, "fileNames");
                super(null);
                this.f10503a = r3;
                this.f10504b = r7;
                this.c = r5;
                this.d = r6;
            }

            public /* synthetic */ c(JSONObject r7, List r8, int r9, long r10, int r12, DefaultConstructorMarker r13) {
                List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
                if ((r12 & 4) == 0) goto L5;
                r9 = 0;
            L5:
                int r3 = r9;
                if ((r12 & 8) == 0) goto L8;
                r10 = 0;
            L8:
                this(r7, r2, r3, r10);
            }

            public final JSONObject a() {
                return this.f10503a;
            }

            public final int b() {
                return this.c;
            }

            public final long c() {
                return this.d;
            }

            public boolean equals(Object r7) {
                if (this != r7) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r7, c.class) == true) goto L8;
                return false;
            L8:
                c r8 = (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f10503a, r8.f10503a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f10504b, r8.f10504b) == true) goto L15;
                return false;
            L15:
                if (this.c == r8.c) goto L18;
                return false;
            L18:
                if (this.d == r8.d) goto L20;
                return false;
            L20:
                return true;
            }

            public int hashCode() {
                return (((((this.f10503a.hashCode() * 31) + this.f10504b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + Long.hashCode(this.d);
            }

            public String toString() {
                return "Success(reportData=" + this.f10503a + ", fileNames=" + this.f10504b + ", skippedViewTreeFileCount=" + this.c + ", skippedViewTreeFileBytes=" + this.d + ')';
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$StoredViewTreeBatch;", "", "observationIds", "", "", "viewTrees", "", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getObservationIds", "()Ljava/util/List;", "getViewTrees", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<Long> f10505a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<String> f10506b;

        public c(List<Long> r3, List<String> r4) {
            List<Long> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "viewTrees");
            this.f10505a = r5;
            this.f10506b = r6;
        }

        public final List<Long> a() {
            return this.f10505a;
        }

        public final List<String> b() {
            return this.f10506b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10505a, r6.f10505a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f10506b, r6.f10506b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            List<Long> r0 = this.f10505a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.f10506b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "StoredViewTreeBatch(observationIds=" + this.f10505a + ", viewTrees=" + this.f10506b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$StoredViewTreeBatchReadResult;", "", "<init>", "()V", "Success", "Failure", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$StoredViewTreeBatchReadResult$Failure;", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$StoredViewTreeBatchReadResult$Success;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static abstract class d {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$StoredViewTreeBatchReadResult$Failure;", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$StoredViewTreeBatchReadResult;", Params.FILE_PATH, "", "operation", "errorType", "errorMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFilePath", "()Ljava/lang/String;", "getOperation", "getErrorType", "getErrorMessage", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f10507a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f10508b;
            private final String c;
            private final String d;

            public a(String r2, String r3, String r4, String r5) {
                Intrinsics.checkNotNullParameter(r2, Params.FILE_PATH);
                Intrinsics.checkNotNullParameter(r3, "operation");
                Intrinsics.checkNotNullParameter(r4, "errorType");
                Intrinsics.checkNotNullParameter(r5, "errorMessage");
                super(null);
                this.f10507a = r2;
                this.f10508b = r3;
                this.c = r4;
                this.d = r5;
            }

            public final String a() {
                return this.f10507a;
            }

            public final String b() {
                return this.f10508b;
            }

            public final String c() {
                return this.c;
            }

            public final String d() {
                return this.d;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f10507a, r6.f10507a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f10508b, r6.f10508b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
                return false;
            L20:
                return true;
            }

            public int hashCode() {
                return (((((this.f10507a.hashCode() * 31) + this.f10508b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
            }

            public String toString() {
                return "Failure(filePath=" + this.f10507a + ", operation=" + this.f10508b + ", errorType=" + this.c + ", errorMessage=" + this.d + ')';
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$StoredViewTreeBatchReadResult$Success;", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$StoredViewTreeBatchReadResult;", "batch", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$StoredViewTreeBatch;", "<init>", "(Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$StoredViewTreeBatch;)V", "getBatch", "()Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportViewTreeFileStore$StoredViewTreeBatch;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class b extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final c f10509a;

            public b(c r2) {
                Intrinsics.checkNotNullParameter(r2, "batch");
                super(null);
                this.f10509a = r2;
            }

            public final c a() {
                return this.f10509a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
                return false;
            L8:
                b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f10509a, r6.f10509a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f10509a.hashCode();
            }

            public String toString() {
                return "Success(batch=" + this.f10509a + ')';
            }
        }

        private d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10498a = new a(null);
    }

    public k(Function0<? extends File> r3) {
        Function0<File> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "rootDirProvider");
        this.f10499b = r4;
    }

    private final c a(JSONObject r11) {
        JSONArray r0 = r11.optJSONArray("observationIds");
        if (r0 == null) goto L39;
        JSONArray r12 = r11.optJSONArray("viewTrees");
        if (r12 == null) goto L37;
        boolean r3 = true;
        if (r0.length() != r12.length()) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L35;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r0.length()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r2.iterator();
    L13:
        if (r5.hasNext() == false) goto L15;
        r4.add(Long.valueOf(r0.optLong(((IntIterator) ZeusTransformUtils.preCheckCast(r5, IntIterator.class, "com.obric.memorydata.plugin")).nextInt(), -1)));
        goto L13
    L15:
        List r6 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L18;
    L20:
        Iterator r8 = r7.iterator();
    L22:
        if (r8.hasNext() == false) goto L29;
        if (((Number) ZeusTransformUtils.preCheckCast(r8.next(), Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L26;
        boolean r9 = true;
    L27:
        if (r9 == true) goto L22;
        r3 = false;
        goto L29
    L26:
        r9 = false;
    L29:
        if (r3 == false) goto L33;
        return new c(r6, b(r12));
    L33:
        throw new IllegalArgumentException("observationIds must be positive".toString());
    L18:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L20;
    L35:
        throw new IllegalArgumentException("observationIds and viewTrees size mismatch".toString());
    L9:
        r1 = false;
        goto L10
    L37:
        throw new IllegalArgumentException("missing viewTrees".toString());
    L39:
        throw new IllegalArgumentException("missing observationIds".toString());
    }

    private final d.a a(File r5, String r6, Throwable r7) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r7.getClass().getSimpleName(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r4) == false) goto L5;
        r4 = r7.getClass().getName();
    L5:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
        String r0 = r7.getMessage();
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        RunLog.INSTANCE.error("MemoryTraceFileStore", "ViewTree file " + r6 + " failed, path=" + r5.getPath() + ", errorType=" + r8 + ", errorMessage=" + r0, r7);
        String r9 = r5.getPath();
        Intrinsics.checkNotNullExpressionValue(r9, "getPath(...)");
        Intrinsics.checkNotNull(r8);
        return new d.a(r9, r6, r8, r0);
    }

    private final d a(File r7) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        k r3 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r4 = Result.m1421constructorimpl(FilesKt.readText(r7, Charsets.UTF_8));     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r4);
        if (r5 != null) goto L33;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L24
        k r0 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        Character r9 = StringsKt.firstOrNull((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trimStart((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L24
        if (r9 != null) goto L14;
    L17:
        if (r9 == null) goto L23;
        if (r9.charValue() != '[') goto L23;
        c r1 = new c(null, r0.b(new JSONArray(r6)));     // Catch: Throwable -> L24
    L21:
        Object r10 = Result.m1421constructorimpl(r1);     // Catch: Throwable -> L24
    L26:
        Throwable r11 = Result.m1424exceptionOrNullimpl(r10);
        if (r11 != null) goto L29;
        Object r12 = ZeusTransformUtils.preCheckCast(new d.b((c) ZeusTransformUtils.preCheckCast(r10, c.class, "com.obric.memorydata.plugin")), d.class, "com.obric.memorydata.plugin");
    L31:
        return (d) r12;
    L29:
        r12 = ZeusTransformUtils.preCheckCast(a(r7, "parse", r11), d.class, "com.obric.memorydata.plugin");
    L23:
        throw new IllegalStateException("unsupported ViewTree file JSON root".toString());     // Catch: Throwable -> L24
    L14:
        if (r9.charValue() != '{') goto L17;
        r1 = r0.a(new JSONObject(r6));     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L26
    L33:
        return (d) ZeusTransformUtils.preCheckCast(a(r7, "read", r5), d.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final List<String> a(JSONArray r6) {
        if (r6 == null) goto L4;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r6.length()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L7:
        if (r7.hasNext() == false) goto L18;
        JSONObject r2 = r6.optJSONObject(((IntIterator) ZeusTransformUtils.preCheckCast(r7, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        String r3 = null;
        if (r2 == null) goto L15;
        String r4 = r2.optString("fileName");
        if (r4 == null) goto L15;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L15;
        r3 = r4;
    L15:
        if (r3 == null) goto L7;
        r0.add(r3);
        goto L7
    L18:
        return CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L4:
        return CollectionsKt.emptyList();
    }

    private final boolean a(File r3, File r4) {
        if (Intrinsics.areEqual(r3.getPath(), r4.getPath()) == true) goto L6;
        String r2 = r3.getPath();
        Intrinsics.checkNotNullExpressionValue(r2, "getPath(...)");
        if (StringsKt.startsWith$default(r2, r4.getPath() + File.separator, false, 2, null) == true) goto L6;
        return false;
    L6:
        return true;
    }

    private final String b(String r3) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(new Regex("[^A-Za-z0-9_-]").replace((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), "_"), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r2) == false) goto L6;
        r2 = "unknown";
    L6:
        return ((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin")) + '_' + System.currentTimeMillis() + '_' + UUID.randomUUID() + ".json";
    }

    private final List<String> b(JSONArray r5) {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r5.length()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        Object r2 = r5.opt(((IntIterator) ZeusTransformUtils.preCheckCast(r6, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        if (r2 != null) goto L8;
    L11:
        String r3 = "";
    L12:
        r0.add(r3);
        goto L4
    L8:
        if (Intrinsics.areEqual(r2, JSONObject.NULL) == true) goto L11;
        r3 = r2.toString();
        goto L12
    L14:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    public final b a(String r21, long r22) {
        Intrinsics.checkNotNullParameter(r21, "reportData");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        k r1 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r2 = Result.m1421constructorimpl(new JSONObject(r21));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r2) == false) goto L10;
        r2 = null;
    L10:
        JSONObject r5 = (JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L15;
        JSONObject r7 = new JSONObject().put("raw", r21);
        Intrinsics.checkNotNullExpressionValue(r7, "put(...)");
        Object r3 = new b.c(r7, CollectionsKt.emptyList(), 0, 0, 12, null);
    L14:
        return (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin");
    L15:
        JSONArray r4 = r5.optJSONArray("viewTreeFiles");
        if (r4 != null) goto L18;
        r4 = new JSONArray();
    L18:
        List<String> r8 = a(r4);
        File r6 = ((File) ZeusTransformUtils.preCheckCast(this.f10499b.invoke(), File.class, "com.obric.memorydata.plugin")).getCanonicalFile();
        LinkedHashMap r9 = new LinkedHashMap();
        List r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L20:
        if (r13.hasNext() == false) goto L30;
        File r14 = new File(r6, (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin")).getCanonicalFile();
        Intrinsics.checkNotNull(r14);
        Intrinsics.checkNotNull(r6);
        if (a(r14, r6) == false) goto L29;
        if (r14.exists() == false) goto L29;
        if (r14.isFile() == false) goto L29;
        r12.add(r14);
    L29:
        r3 = new b.a(r8);
        goto L14
    L30:
        List r15 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        long r17 = 0;
    L32:
        if (r16.hasNext() == false) goto L38;
        long r18 = RangesKt.coerceAtLeast(((File) ZeusTransformUtils.preCheckCast(r16.next(), File.class, "com.obric.memorydata.plugin")).length(), 0);
        if (r17 > (Long.MAX_VALUE - r18)) goto L35;
        r17 = r17 + r18;
        goto L32
    L35:
        r17 = Long.MAX_VALUE;
        goto L32
    L38:
        if (r17 <= r22) goto L40;
        boolean r19 = true;
    L41:
        if (r19 == true) goto L71;
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L44:
        if (r20.hasNext() == false) goto L71;
        File r23 = (File) ZeusTransformUtils.preCheckCast(r20.next(), File.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r23);
        d r24 = a(r23);
        if (ZeusTransformUtils.instanceOf(r24, d.b.class) == false) goto L67;
        c r25 = ((d.b) ZeusTransformUtils.preCheckCast(r24, d.b.class, "com.obric.memorydata.plugin")).a();
        if (r25.a() != null) goto L51;
        r10.addAll((Collection) ZeusTransformUtils.preCheckCast(r25.b(), Collection.class, "com.obric.memorydata.plugin"));
    L65:
        r20 = r20;
        goto L44
    L51:
        Iterator r26 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.zip((Iterable) ZeusTransformUtils.preCheckCast(r25.a(), Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r25.b(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L53:
        if (r26.hasNext() == false) goto L65;
        Pair r110 = (Pair) ZeusTransformUtils.preCheckCast(r26.next(), Pair.class, "com.obric.memorydata.plugin");
        long r111 = ((Number) ZeusTransformUtils.preCheckCast(r110.component1(), Number.class, "com.obric.memorydata.plugin")).longValue();
        String r112 = (String) ZeusTransformUtils.preCheckCast(r110.component2(), String.class, "com.obric.memorydata.plugin");
        Iterator r27 = r20;
        String r28 = (String) ZeusTransformUtils.preCheckCast(r9.get(Long.valueOf(r111)), String.class, "com.obric.memorydata.plugin");
        if (r28 == null) goto L63;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r28, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L64;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r112, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L63;
    L64:
        r20 = r27;
    L63:
        ((Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.memorydata.plugin")).put(Long.valueOf(r111), r112);
        goto L64
    L67:
        if (ZeusTransformUtils.instanceOf(r24, d.a.class) == false) goto L70;
        r3 = new b.C0515b(r8, ((d.a) ZeusTransformUtils.preCheckCast(r24, d.a.class, "com.obric.memorydata.plugin")).a(), ((d.a) ZeusTransformUtils.preCheckCast(r24, d.a.class, "com.obric.memorydata.plugin")).b(), ((d.a) ZeusTransformUtils.preCheckCast(r24, d.a.class, "com.obric.memorydata.plugin")).c(), ((d.a) ZeusTransformUtils.preCheckCast(r24, d.a.class, "com.obric.memorydata.plugin")).d());
        goto L14
    L70:
        throw new NoWhenBranchMatchedException();
    L71:
        JSONArray r29 = r5.optJSONArray("viewTrees");
        if (r29 == null) goto L74;
        r10.addAll((Collection) ZeusTransformUtils.preCheckCast(b(r29), Collection.class, "com.obric.memorydata.plugin"));
    L74:
        r5.remove("viewTreeFiles");
        JSONArray r30 = r5.optJSONArray("observations");
        if (r30 != null) goto L77;
    L92:
        long r113 = r17;
        JSONArray r31 = new JSONArray();
        Collection r32 = r9.values();
        Intrinsics.checkNotNullExpressionValue(r32, "<get-values>(...)");
        Iterator r33 = ((Iterable) ZeusTransformUtils.preCheckCast(r32, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L94:
        if (r33.hasNext() == false) goto L96;
        r31.put((String) ZeusTransformUtils.preCheckCast(r33.next(), String.class, "com.obric.memorydata.plugin"));
        goto L94
    L96:
        Iterator r34 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L98:
        if (r34.hasNext() == false) goto L101;
        r31.put((String) ZeusTransformUtils.preCheckCast(r34.next(), String.class, "com.obric.memorydata.plugin"));
        goto L98
    L101:
        if (r31.length() <= 0) goto L104;
        r5.put("viewTrees", r31);
    L104:
        if (r19 == false) goto L106;
        int r35 = r8.size();
    L107:
        if (r19 == false) goto L109;
        long r36 = r113;
    L110:
        r3 = new b.c(r5, r8, r35, r36);
        goto L14
    L109:
        r36 = 0;
        goto L110
    L106:
        r35 = 0;
        goto L107
    L77:
        if (r30.length() <= 0) goto L92;
        JSONArray r37 = new JSONArray();
        int r38 = r30.length();
        int r114 = 0;
        int r115 = 0;
    L79:
        if (r114 >= r38) goto L91;
        JSONObject r116 = r30.optJSONObject(r114);
        long r117 = r17;
        long r118 = -1;
        if (r116 == null) goto L83;
        r118 = r116.optLong(OaidModel.KEY_ID, -1);
    L83:
        String r119 = (String) ZeusTransformUtils.preCheckCast(r9.get(Long.valueOf(r118)), String.class, "com.obric.memorydata.plugin");
        if (r119 != null) goto L90;
        if (r115 >= r10.size()) goto L89;
        String r120 = (String) ZeusTransformUtils.preCheckCast(r10.get(r115), String.class, "com.obric.memorydata.plugin");
        r115 = r115 + 1;
        r119 = r120;
        goto L90
    L89:
        r119 = "";
    L90:
        r37.put(r119);
        r114 = r114 + 1;
        r17 = r117;
        goto L79
    L91:
        r113 = r17;
        r5.put("viewTrees", r37);
        goto L104
    L40:
        r19 = false;
    L5:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final JSONArray a(String r12, List<Long> r13, List<String> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "logId");
        Intrinsics.checkNotNullParameter(r15, "observationIds");
        Intrinsics.checkNotNullParameter(r16, "viewTrees");
        int r5 = 0;
        if (r15.size() != r16.size()) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L56;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L10;
    L12:
        Iterator r6 = r4.iterator();
    L14:
        if (r6.hasNext() == false) goto L11;
        if (((Number) ZeusTransformUtils.preCheckCast(r6.next(), Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == true) goto L14;
        boolean r8 = false;
    L21:
        if (r8 == false) goto L54;
        if (r15.isEmpty() == true) goto L25;
        File r9 = this.f10499b.invoke();
        ((File) ZeusTransformUtils.preCheckCast(r9, File.class, "com.obric.memorydata.plugin")).mkdirs();
        File r10 = (File) ZeusTransformUtils.preCheckCast(r9, File.class, "com.obric.memorydata.plugin");
        JSONArray r11 = new JSONArray();
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L28:
        if (r17.hasNext() == false) goto L30;
        r11.put(((Number) ZeusTransformUtils.preCheckCast(r17.next(), Number.class, "com.obric.memorydata.plugin")).longValue());
        goto L28
    L30:
        JSONArray r18 = new JSONArray();
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L32:
        if (r19.hasNext() == false) goto L34;
        r18.put((String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.memorydata.plugin"));
        goto L32
    L34:
        String r110 = new JSONObject().put("format", "observation_aligned_v1").put("observationIds", r11).put("viewTrees", r18).toString();
        Intrinsics.checkNotNullExpressionValue(r110, "toString(...)");
        File r111 = new File(r10, b(r12)).getCanonicalFile();
        Intrinsics.checkNotNull(r111);
        File r0 = r10.getCanonicalFile();
        Intrinsics.checkNotNullExpressionValue(r0, "getCanonicalFile(...)");
        if (a(r111, r0) == false) goto L52;
        FilesKt.writeText(r111, r110, Charsets.UTF_8);
        JSONArray r112 = new JSONArray();
        JSONObject r113 = new JSONObject().put("fileName", r111.getName()).put(CommonConsts.COUNT_TYPE, r16.size());
        Iterable r114 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r114, Collection.class) == true) goto L39;
    L41:
        Iterator r115 = r114.iterator();
    L43:
        if (r115.hasNext() == false) goto L49;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r115.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L43;
        r5 = r5 + 1;
        if (r5 >= 0) goto L43;
        CollectionsKt.throwCountOverflow();
    L49:
        JSONObject r116 = r113.put("nonEmptyCount", r5);
        byte[] r117 = r110.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r117, "getBytes(...)");
        JSONArray r118 = r112.put(r116.put("bytes", r117.length));
        Intrinsics.checkNotNullExpressionValue(r118, "put(...)");
        return r118;
    L39:
        if (((Collection) ZeusTransformUtils.preCheckCast(r114, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L41;
    L52:
        throw new IllegalArgumentException("invalid memory trace viewTree file path".toString());
    L25:
        return new JSONArray();
    L54:
        throw new IllegalArgumentException("observationIds must be positive".toString());
    L18:
        r7 = false;
    L11:
        r8 = true;
        goto L21
    L10:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L12;
    L56:
        throw new IllegalArgumentException("observationIds and viewTrees must have the same size".toString());
    L5:
        r3 = false;
        goto L6
    }

    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "reportData");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        k r2 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r4 = Result.m1421constructorimpl(new JSONObject(r3));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r4) == false) goto L10;
        r4 = null;
    L10:
        JSONObject r5 = (JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L13;
        return;
    L13:
        a(a(r5.optJSONArray("viewTreeFiles")));
        return;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final void a(List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "fileNames");
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        File r1 = ((File) ZeusTransformUtils.preCheckCast(this.f10499b.invoke(), File.class, "com.obric.memorydata.plugin")).getCanonicalFile();
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r8.hasNext() == false) goto L25;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L11
        k r5 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        Object r9 = Result.m1421constructorimpl(new File(r1, r3).getCanonicalFile());     // Catch: Throwable -> L11
    L14:
        if (Result.m1427isFailureimpl(r9) == false) goto L16;
        r9 = null;
    L16:
        File r10 = (File) ZeusTransformUtils.preCheckCast(r9, File.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L7;
        Intrinsics.checkNotNull(r1);
        if (a(r10, r1) == false) goto L7;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L23
        k r12 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        Result.m1421constructorimpl(Boolean.valueOf(r10.delete()));     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L11:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
