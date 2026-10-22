package com.obric.memorydata.datatransport.excel;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.dao.EvaluationSourceDataDao;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.bu;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.ba;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.i;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.datatransport.excel.ExcelProcessUtils$exportDataToExcel$1", f = "ExcelProcessUtils.kt", i = {}, l = {321, 328}, m = "invokeSuspend", n = {}, s = {})
final class ExcelProcessUtils$exportDataToExcel$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ ExcelMode $excelMode;
    int label;

    /* JADX INFO: renamed from: com.obric.memorydata.datatransport.excel.ExcelProcessUtils$exportDataToExcel$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.datatransport.excel.ExcelProcessUtils$exportDataToExcel$1$3", f = "ExcelProcessUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass3((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            ba.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "Excel file has been written to /storage/emulated/0/Download/Memory端到端评测集.xlsx", 0, 4, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.datatransport.excel.ExcelProcessUtils$exportDataToExcel$1$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.datatransport.excel.ExcelProcessUtils$exportDataToExcel$1$4", f = "ExcelProcessUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ IllegalStateException $e;
        int label;

        AnonymousClass4(IllegalStateException r3, Continuation<? super AnonymousClass4> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$e = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this.$e, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass4) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass4.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r7);
            ba.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "Download目录下同名文件过多，创建失败", 0, 4, null);
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ExcelProcessUtils", "Failed to write file: " + this.$e.getMessage(), null, 4, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9727a = null;

        static {
            int[] r0 = new int[ExcelMode.values().length];
            r0[ExcelMode.PARTITIONED_TABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[ExcelMode.SLM_FINETUNE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[ExcelMode.WHOLE_TABLE_ACCESSIBILITY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ExcelMode.EVALUATION_PERSONAL_CONTEXT_OLD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[ExcelMode.EVALUATION_PERSONAL_CONTEXT_EXTEND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[ExcelMode.EVALUATION_PERSONAL_CONTEXT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[ExcelMode.EVALUATION_PERSONAL_CONTEXT_DB_DATASET.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[ExcelMode.WHOLE_TABLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f9727a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((bu) ZeusTransformUtils.preCheckCast(r2, bu.class, "com.obric.memorydata.plugin")).c()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((bu) ZeusTransformUtils.preCheckCast(r3, bu.class, "com.obric.memorydata.plugin")).c()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    ExcelProcessUtils$exportDataToExcel$1(ExcelMode r3, Continuation<? super ExcelProcessUtils$exportDataToExcel$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$excelMode = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ExcelProcessUtils$exportDataToExcel$1(this.$excelMode, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ExcelProcessUtils$exportDataToExcel$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ExcelProcessUtils$exportDataToExcel$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r33) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        int r5 = 1;
        if (r0 == 0) goto L13;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r33);
    L126:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r33);     // Catch: IllegalStateException -> L11
        goto L126
    L13:
        ResultKt.throwOnFailure(r33);
        com.obric.memorydata.datatransport.excel.a r7 = new com.obric.memorydata.datatransport.excel.a(this.$excelMode);
        EvaluationSourceDataDao r1 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getEvaluationSourceDataDao();
        int r9 = 0;
        switch(a.f9727a[this.$excelMode.ordinal()]) {
            case 1: goto L25;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L16;
            default: goto L15;
        };
    L15:
        List<bu> r8 = r1.queryAll();
    L24:
        List r10 = CollectionsKt.listOf(r8);
    L39:
        if (r10.isEmpty() == true) goto L41;
        XSSFWorkbook r11 = new XSSFWorkbook();
        switch(a.f9727a[this.$excelMode.ordinal()]) {
            case 2: goto L55;
            case 3: goto L54;
            case 4: goto L47;
            case 5: goto L47;
            case 6: goto L46;
            case 7: goto L45;
            default: goto L44;
        };
    L44:
        List r3 = CollectionsKt.mutableListOf(new String[]{"session_id", "message_index", OaidModel.KEY_TIME, "user_type", "data_id", "message_content", "response_a", "response_b", "有效问题？(0,1,2)", "大模型使用？(0,1,2)", "A优于B？(2,1,0,-1,-2)", "GSB原因", "备注", "search_text", "检索得分(-2~3)", "检索得分原因", "session_type", "original_data", "user_index", "ground_truth", "ground_truth_reason"});
    L56:
        List r12 = r3;
    L57:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        ExcelMode r13 = this.$excelMode;
        Iterator r14 = r4.iterator();
        int r6 = 0;
    L59:
        if (r14.hasNext() == false) goto L90;
        Object r15 = r14.next();
        int r16 = r6 + 1;
        if (r6 >= 0) goto L63;
        CollectionsKt.throwIndexOverflow();
    L63:
        List r17 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
        if (a.f9727a[r13.ordinal()] != r5) goto L70;
        bu r18 = (bu) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r17, r9), bu.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L68;
        int r19 = r18.t();
    L69:
        String r20 = "USER-" + r19;
    L71:
        XSSFSheet r21 = r11.createSheet(r20);
        XSSFRow r110 = r21.createRow(r9);
        HashMap r111 = new HashMap();
        int r22 = ((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).size();
        int r23 = 0;
    L72:
        if (r23 >= r22) goto L74;
        r110.createCell(r23).setCellValue((String) ZeusTransformUtils.preCheckCast(r12.get(r23), String.class, "com.obric.memorydata.plugin"));
        ((Map) ZeusTransformUtils.preCheckCast(r111, Map.class, "com.obric.memorydata.plugin")).put(r12.get(r23), Boxing.boxInt(r23));
        r23 = r23 + 1;
        r13 = r13;
        r22 = r22;
        goto L72
    L74:
        ExcelMode r112 = r13;
        Iterator r24 = CollectionsKt.withIndex((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L76:
        if (r24.hasNext() == false) goto L89;
        IndexedValue r25 = (IndexedValue) ZeusTransformUtils.preCheckCast(r24.next(), IndexedValue.class, "com.obric.memorydata.plugin");
        int r26 = r25.component1();
        bu r27 = (bu) ZeusTransformUtils.preCheckCast(r25.component2(), bu.class, "com.obric.memorydata.plugin");
        XSSFRow r28 = r21.createRow(r26 + 1);
        Iterator r29 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r113 = 0;
    L79:
        if (r29.hasNext() == false) goto L76;
        Object r30 = r29.next();
        int r114 = r113 + 1;
        if (r113 >= 0) goto L83;
        CollectionsKt.throwIndexOverflow();
    L83:
        Iterator r210 = r24;
        String r31 = (String) ZeusTransformUtils.preCheckCast(r30, String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r28);     // Catch: Exception -> L86
        r7.a(r31, r27, (Row) ZeusTransformUtils.preCheckCast(r28, Row.class, "com.obric.memorydata.plugin"), r113);     // Catch: Exception -> L86
    L88:
        r113 = r114;
        r24 = r210;
        r21 = r21;
        r28 = r28;
        r7 = r7;
    L86:
        e = move-exception;
        RunLog.INSTANCE.debug("ExcelProcessUtils", "handle column error: " + r31 + ", columnIndex: " + r113 + '\n' + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));
        goto L88
    L89:
        r6 = r16;
        r13 = r112;
        r5 = 1;
        r9 = 0;
        goto L59
    L68:
        r19 = r9;
        goto L69
    L70:
        r20 = "数据集";
        goto L71
    L90:
        ContentResolver r32 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
        ContentValues r34 = new ContentValues();
        ExcelMode r35 = this.$excelMode;
        String r36 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMdd_HHmm"));
        String r37 = "Memory_PersonalContext评测集_";
        switch(a.f9727a[r35.ordinal()]) {
            case 1: goto L99;
            case 2: goto L98;
            case 3: goto L97;
            case 4: goto L96;
            case 5: goto L96;
            case 6: goto L95;
            case 7: goto L94;
            case 8: goto L93;
            default: goto L92;
        };
    L92:
        StringBuilder r38 = new StringBuilder();
        r37 = "Memory数据集_";
    L100:
        r34.put("_display_name", r38.append(r37).append(r36).append(".xlsx").toString());
        r34.put("mime_type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        r34.put("relative_path", Environment.DIRECTORY_DOWNLOADS);
        Uri r39 = ZeusProviderTransform.insert(r32, MediaStore.Downloads.EXTERNAL_CONTENT_URI, r34, "com.obric.memorydata.plugin");     // Catch: IllegalStateException -> L11
        if (r39 == null) goto L119;
        Closeable r40 = (Closeable) ZeusTransformUtils.preCheckCast(r32.openOutputStream(r39), Closeable.class, "com.obric.memorydata.plugin");     // Catch: IllegalStateException -> L11
        OutputStream r41 = (OutputStream) ZeusTransformUtils.preCheckCast(r40, OutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L112
        r11.write(r41);     // Catch: Throwable -> L112
        if (r41 == null) goto L107;
        r41.flush();     // Catch: Throwable -> L112
    L107:
        if (r41 == null) goto L110;
        r41.close();     // Catch: Throwable -> L112
        Unit r42 = Unit.INSTANCE;     // Catch: Throwable -> L112
    L110:
        CloseableKt.closeFinally(r40, null);     // Catch: IllegalStateException -> L11
    L112:
        th = move-exception;
        throw th;     // Catch: Throwable -> L115
    L115:
        th = move-exception;
        CloseableKt.closeFinally(r40, th);     // Catch: IllegalStateException -> L11
        throw th;     // Catch: IllegalStateException -> L11
    L119:
        CoroutineContext r43 = (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: IllegalStateException -> L11
        Function2 r44 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(null), Function2.class, "com.obric.memorydata.plugin");     // Catch: IllegalStateException -> L11
        Continuation r45 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: IllegalStateException -> L11
        this.label = 1;     // Catch: IllegalStateException -> L11
        if (i.a(r43, r44, r45) != r2) goto L126;
        return r2;
    L93:
        r38 = new StringBuilder();
        r37 = "Memory端到端评测集_整表_";
        goto L100
    L94:
        r38 = new StringBuilder();
        r37 = "Memory_PersonalContext_DB导出数据集_";
        goto L100
    L95:
        r38 = new StringBuilder();
        goto L100
    L96:
        r38 = new StringBuilder();
        goto L100
    L97:
        r38 = new StringBuilder();
        r37 = "Memory无障碍采集数据_";
        goto L100
    L98:
        r38 = new StringBuilder();
        r37 = "Memory数据集_Finetune_";
        goto L100
    L99:
        r38 = new StringBuilder();
        r37 = "Memory端到端评测集_分表_";
        goto L100
    L45:
        r3 = CollectionsKt.mutableListOf(new String[]{"type", "typeDesc", "evaluationId", "createTime", ChatMessage.TYPE_QUERY, TypedValues.AttributesType.S_TARGET, "data", "备注", EventBody.KEY_CATEGORY, "session_type"});
        goto L56
    L46:
        r3 = CollectionsKt.mutableListOf(new String[]{ChatMessage.TYPE_QUERY, "targetEvaluationIds", "quResult", "resultEvaluationIds", "resultList", "resultEntities", "precision", "recall", LocationMonitorConst.ACCURACY, "f1Score", "evaluationResult", "queryTimeCost", "searchControlParams", "resultCode", WsConstants.KEY_EXTRA, "queries", "searchControlParams", "备注", "session_type"});
        goto L56
    L47:
        r12 = CollectionsKt.mutableListOf(new String[]{"createTime", "typeDesc", "data", ChatMessage.TYPE_QUERY, "lastModifiedTime", OaidModel.KEY_ID, "dependencies", "type", "user_index", "备注"});
        Iterator r46 = ((Iterable) ZeusTransformUtils.preCheckCast(r1.queryBySessionType(SessionType.PERSONAL_CONTEXT_TEST_QUERY.getValue()), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r115 = 0;
    L49:
        if (r46.hasNext() == false) goto L57;
        Object r116 = r46.next();
        int r117 = r115 + 1;
        if (r115 >= 0) goto L53;
        CollectionsKt.throwIndexOverflow();
    L53:
        r12.add("Query" + r117 + "-\n" + ((bu) ZeusTransformUtils.preCheckCast(r116, bu.class, "com.obric.memorydata.plugin")).d());
        r115 = r117;
        goto L49
    L54:
        r3 = CollectionsKt.mutableListOf(new String[]{OaidModel.KEY_TIME, "eventName", "activityName", "className", "allTextInfo", "viewTreeInfo", "description", "operateNodeInfo", "备注", "hasScreenshot", ObricMemoryConstants.KEY_PACKAGE_NAME});
        goto L56
    L55:
        r3 = CollectionsKt.mutableListOf(new String[]{OaidModel.KEY_TIME, "data_id", "botId", Ext.KEY_REQUEST, ChatMessage.TYPE_RESPONSE, "备注"});
        goto L56
    L41:
        return Unit.INSTANCE;
    L16:
        List<String> r47 = CollectionsKt.listOf(new String[]{SessionType.PERSONAL_CONTEXT_EVALUATION_DATA.getValue(), SessionType.PERSONAL_CONTEXT_TEST_QUERY.getValue()});
    L18:
        r8 = r1.queryBySessionTypes(r47);
        goto L24
    L17:
        r47 = CollectionsKt.listOf(new String[]{SessionType.EVALUATION_PERSONAL_CONTEXT_FINAL_RESULT_RATE.getValue(), SessionType.EVALUATION_PERSONAL_CONTEXT_QUERY_RESULT.getValue()});
        goto L18
    L19:
        SessionType r48 = SessionType.EVALUATION_PERSONAL_CONTEXT_EXTEND;
    L23:
        r8 = r1.queryBySessionType(r48.getValue());
        goto L24
    L20:
        r48 = SessionType.EVALUATION_PERSONAL_CONTEXT_OLD;
        goto L23
    L21:
        r48 = SessionType.ACCESSIBILITY_EVENT;
        goto L23
    L22:
        r48 = SessionType.FINE_TUNE;
        goto L23
    L25:
        Integer r49 = r1.queryMaxUserIndex();
        if (r49 == null) goto L28;
        int r50 = r49.intValue();
    L29:
        List r118 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r50 < 0) goto L37;
        int r119 = 0;
    L32:
        List<bu> r120 = r1.queryByUserIndex(r119);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r120, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L35;
        r118.add(r120);
    L35:
        if (r119 == r50) goto L37;
        r119 = r119 + 1;
    L37:
        r10 = r118;
        goto L39
    L28:
        r50 = 0;
    L11:
        e = move-exception;
        CoroutineContext r51 = (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r52 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(e, null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r53 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 2;
        if (i.a(r51, r52, r53) != r2) goto L126;
        return r2;
    }
}
