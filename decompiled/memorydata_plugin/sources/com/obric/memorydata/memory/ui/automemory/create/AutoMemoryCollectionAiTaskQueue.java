package com.obric.memorydata.memory.ui.automemory.create;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.MemoryRuleEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.channels.i;
import kotlinx.coroutines.channels.l;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.da;
import okhttp3.HttpUrl;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002MNB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\u0017J\u0016\u0010 \u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\nH\u0082@¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u0017H\u0002J\u000e\u0010#\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u001aH\u0002J\u0016\u0010'\u001a\u00020(2\u0006\u0010&\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010)J\u0016\u0010*\u001a\u00020(2\u0006\u0010&\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010)J\u0016\u0010+\u001a\u00020(2\u0006\u0010&\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010)J<\u0010,\u001a\u0004\u0018\u0001H-\"\u0004\b\u0000\u0010-2\u0006\u0010.\u001a\u00020/2\u001c\u00100\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H-02\u0012\u0006\u0012\u0004\u0018\u00010\u000101H\u0082@¢\u0006\u0002\u00103J\u0016\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u00106J\u001e\u00107\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u00109J\u0018\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0005H\u0002J4\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020?2\u0014\b\u0002\u0010B\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020C01H\u0082@¢\u0006\u0002\u0010DJ\u000e\u0010E\u001a\u00020?H\u0082@¢\u0006\u0002\u0010$J.\u0010F\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010IJ\u000e\u0010J\u001a\b\u0012\u0004\u0012\u00020\u001a0KH\u0002J\b\u0010L\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCollectionAiTaskQueue;", "", "<init>", "()V", "TAG", "", "STORE_KEY_PENDING", "MAX_RETRY_PER_RUN", "", "TASK_TIMEOUT_SEC", "", "TASK_TIMEOUT_EXTRA_MS", "RETRY_LATER_MS", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "getStore", "()Lcom/obric/memorydata/middleware/api/store/IStore;", "store$delegate", "Lkotlin/Lazy;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "signal", "Lkotlinx/coroutines/channels/Channel;", "", "taskQueue", "Ljava/util/PriorityQueue;", "Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCollectionAiTaskQueue$PendingTask;", "worker", "Lkotlinx/coroutines/Job;", "enqueueRewriteAndRecommend", "ruleId", "resumePendingTask", "enqueue", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureWorker", "runOneOrWait", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retryLater", "task", "processRuleGenerator", "", "(Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCollectionAiTaskQueue$PendingTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processRewrite", "processRecommend", "retryTask", ExifInterface.GPS_DIRECTION_TRUE, "stage", "Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCollectionAiTaskQueue$Stage;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCollectionAiTaskQueue$Stage;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runRuleRewrite", Params.CONTENT, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runRecommendPackages", "appNames", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveAppLabel", "pm", "Landroid/content/pm/PackageManager;", "pkg", "runAlgoTask", "Lorg/json/JSONObject;", ActivityLifecycle.NAME, "input", "configure", "Lcom/obric/memorydata/task/impl/TaskRequest$Builder;", "(Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runRuleGeneratorTask", "updateRule", "title", "appPackages", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readPendingTasksFromStore", "", "savePendingTasksToStore", "PendingTask", "Stage", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryCollectionAiTaskQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AutoMemoryCollectionAiTaskQueue f10615a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f10616b = null;
    private static final al c = null;
    private static final i<Unit> d = null;
    private static final PriorityQueue<a> e = null;
    private static bx f;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCollectionAiTaskQueue$Stage;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "RULEGENERATOR", "REWRITE", "RECOMMEND", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Stage extends Enum<Stage> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Stage[] $VALUES = null;
        public static final a Companion = null;
        public static final Stage RECOMMEND = null;
        public static final Stage REWRITE = null;
        public static final Stage RULEGENERATOR = null;
        private final String value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCollectionAiTaskQueue$Stage$Companion;", "", "<init>", "()V", "from", "Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCollectionAiTaskQueue$Stage;", EventBody.KEY_VALUE, "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }

            public final Stage a(String r5) {
                Intrinsics.checkNotNullParameter(r5, EventBody.KEY_VALUE);
                Stage[] r4 = Stage.values();
                int r0 = r4.length;
                int r1 = 0;
            L3:
                if (r1 >= r0) goto L8;
                Stage r2 = r4[r1];
                if (Intrinsics.areEqual(r2.getValue(), r5) == true) goto L12;
                r1 = r1 + 1;
                goto L3
            L12:
                return r2;
            L8:
                return null;
            }
        }

        private static final /* synthetic */ Stage[] $values() {
            return new Stage[]{RULEGENERATOR, REWRITE, RECOMMEND};
        }

        static {
            RULEGENERATOR = new Stage("RULEGENERATOR", 0, "rule_generator");
            REWRITE = new Stage("REWRITE", 1, "rewrite");
            RECOMMEND = new Stage("RECOMMEND", 2, "recommend");
            Stage[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
            Companion = new a(null);
        }

        private Stage(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static EnumEntries<Stage> getEntries() {
            return $ENTRIES;
        }

        public static Stage valueOf(String r2) {
            return (Stage) ZeusTransformUtils.preCheckCast(Enum.valueOf(Stage.class, r2), Stage.class, "com.obric.memorydata.plugin");
        }

        public static Stage[] values() {
            return (Stage[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Stage[].class, "com.obric.memorydata.plugin");
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0007HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u0018¨\u0006'"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCollectionAiTaskQueue$PendingTask;", "", "ruleId", "", "stage", "Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCollectionAiTaskQueue$Stage;", "stageRetryCount", "", "nextAtMs", "version", "<init>", "(JLcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCollectionAiTaskQueue$Stage;IJJ)V", "getRuleId", "()J", "getStage", "()Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCollectionAiTaskQueue$Stage;", "setStage", "(Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCollectionAiTaskQueue$Stage;)V", "getStageRetryCount", "()I", "setStageRetryCount", "(I)V", "getNextAtMs", "setNextAtMs", "(J)V", "getVersion", "setVersion", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f10617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Stage f10618b;
        private int c;
        private long d;
        private long e;

        public a(long r2, Stage r4, int r5, long r6, long r8) {
            Intrinsics.checkNotNullParameter(r4, "stage");
            this.f10617a = r2;
            this.f10618b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r8;
        }

        public /* synthetic */ a(long r11, Stage r13, int r14, long r15, long r17, int r19, DefaultConstructorMarker r20) {
            if ((r19 & 4) == 0) goto L5;
            int r5 = 0;
        L7:
            if ((r19 & 8) == 0) goto L9;
            long r6 = 0;
        L11:
            if ((r19 & 16) == 0) goto L13;
            long r8 = 0;
        L14:
            this(r11, r13, r5, r6, r8);
            return;
        L13:
            r8 = r17;
            goto L14
        L9:
            r6 = r15;
            goto L11
        L5:
            r5 = r14;
            goto L7
        }

        public final long a() {
            return this.f10617a;
        }

        public final void a(int r1) {
            this.c = r1;
        }

        public final void a(long r1) {
            this.d = r1;
        }

        public final void a(Stage r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.f10618b = r2;
        }

        public final Stage b() {
            return this.f10618b;
        }

        public final void b(long r1) {
            this.e = r1;
        }

        public final int c() {
            return this.c;
        }

        public final long d() {
            return this.d;
        }

        public final long e() {
            return this.e;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.memorydata.plugin");
            if (this.f10617a == r10.f10617a) goto L12;
            return false;
        L12:
            if (this.f10618b == r10.f10618b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L21;
            return false;
        L21:
            if (this.e == r10.e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((Long.hashCode(this.f10617a) * 31) + this.f10618b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e);
        }

        public String toString() {
            return "PendingTask(ruleId=" + this.f10617a + ", stage=" + this.f10618b + ", stageRetryCount=" + this.c + ", nextAtMs=" + this.d + ", version=" + this.e + ')';
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10619a = null;

        static {
            int[] r0 = new int[Stage.values().length];
            r0[Stage.REWRITE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Stage.RECOMMEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Stage.RULEGENERATOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f10619a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.memorydata.plugin")).d()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin")).d()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class d<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f10620a;

        public d(Comparator r3) {
            this.f10620a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r1 = this.f10620a.compare(r2, r3);
            if (r1 == 0) goto L6;
            return r1;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f10615a = new AutoMemoryCollectionAiTaskQueue();
        f10616b = LazyKt.lazy($$Lambda$AutoMemoryCollectionAiTaskQueue$A6IOaSmFtgO6bSpmUjQdYDKXk4.INSTANCE);
        c = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        d = l.a(-1, null, null, 6, null);
        e = new PriorityQueue((Comparator) ZeusTransformUtils.preCheckCast(new d((Comparator) ZeusTransformUtils.preCheckCast(new c(), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin"));
    }

    private AutoMemoryCollectionAiTaskQueue() {
    }

    private static final TaskRequest.Builder a(TaskRequest.Builder r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return r1;
    }

    private final Object a(long r10, String r12, String r13, String r14, Continuation<? super Unit> r15) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryCollectionAiTaskQueue", "updateRule,ruleId:" + r10 + ",title:" + r12, false, 4, null);
        Object r11 = kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionAiTaskQueue$updateRule$2(r10, r12, r13, r14, null), Function2.class, "com.obric.memorydata.plugin"), r9);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    private final Object a(long r13, Continuation<? super Unit> r15) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (r13 <= 0) goto L22;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(e, Iterable.class, "com.obric.memorydata.plugin");
        boolean r3 = true;
        if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L7;
    L9:
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L8;
        if (((a) ZeusTransformUtils.preCheckCast(r2.next(), a.class, "com.obric.memorydata.plugin")).a() != r13) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L11;
    L17:
        if (r3 == true) goto L22;
        e.add(new a(r13, Stage.REWRITE, 0, System.currentTimeMillis(), 0, 20, null));
        d();
        d.mo54trySendJP2dKIU(Unit.INSTANCE);
        return Unit.INSTANCE;
    L15:
        r4 = false;
    L8:
        r3 = false;
        goto L17
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
    L22:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x010e -> B:35:0x0114). Please report as a decompilation issue!!! */
    private final <T> Object a(Stage r11, Function1<? super Continuation<? super T>, ? extends Object> r12, Continuation<? super T> r13) {
        Function1 r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, AutoMemoryCollectionAiTaskQueue$retryTask$1.class) == false) goto L7;
        AutoMemoryCollectionAiTaskQueue$retryTask$1 r0 = (AutoMemoryCollectionAiTaskQueue$retryTask$1) ZeusTransformUtils.preCheckCast(r15, AutoMemoryCollectionAiTaskQueue$retryTask$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        int r17 = r0.I$1;
        int r18 = r0.I$0;
        Function1 r3 = (Function1) ZeusTransformUtils.preCheckCast(r0.L$1, Function1.class, "com.obric.memorydata.plugin");
        Stage r1 = (Stage) ZeusTransformUtils.preCheckCast(r0.L$0, Stage.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);
        int r19 = r18;
        Stage r110 = r1;
        AutoMemoryCollectionAiTaskQueue$retryTask$1 r4 = r0;
        Object r5 = r16;
        Function1 r111 = r3;
    L35:
        int r112 = r17 + 1;
    L21:
        if (r112 < r19) goto L38;
        return null;
    L38:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L26
        r4.L$0 = r110;     // Catch: Throwable -> L26
        r4.L$1 = r111;     // Catch: Throwable -> L26
        r4.I$0 = r19;     // Catch: Throwable -> L26
        r4.I$1 = r112;     // Catch: Throwable -> L26
        r4.I$2 = r112;     // Catch: Throwable -> L26
        r4.label = 1;     // Catch: Throwable -> L26
        r10 = r111.invoke(r4);     // Catch: Throwable -> L26
        if (r10 != r5) goto L25;
        return r5;
    L25:
        return r10;
    L26:
        th = move-exception;
        Function1 r7 = r111;
        r16 = r5;
        r0 = r4;
        Stage r8 = r110;
        int r113 = r112;
        int r9 = r19;
        Throwable th = th;
    L28:
        Result.Companion r20 = Result.Companion;
        Throwable r114 = Result.m1424exceptionOrNullimpl(Result.m1421constructorimpl(ResultKt.createFailure(th)));
        if (r114 == null) goto L31;
        RunLog.INSTANCE.error("AutoMemoryCollectionAiTaskQueue", "task failed(stage=" + r8 + "), retry=" + (r112 + 1) + "/3", r114);
    L31:
        r0.L$0 = r8;
        r0.L$1 = r7;
        r0.I$0 = r9;
        r0.I$1 = r113;
        r0.label = 2;
        if (au.a((1 << r112) * 1000, r0) != r16) goto L34;
        return r16;
    L34:
        r17 = r113;
        r110 = r8;
        r19 = r9;
        r4 = r0;
        r5 = r16;
        r111 = r7;
        goto L35
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r112 = r0.I$2;
        r113 = r0.I$1;
        r9 = r0.I$0;
        r7 = (Function1) ZeusTransformUtils.preCheckCast(r0.L$1, Function1.class, "com.obric.memorydata.plugin");
        r8 = (Stage) ZeusTransformUtils.preCheckCast(r0.L$0, Stage.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L18
    L18:
        th = th;
        goto L28
    L20:
        ResultKt.throwOnFailure(r10);
        r19 = 3;
        r110 = r11;
        r112 = 0;
        r4 = r0;
        r5 = r16;
        r111 = r14;
    L7:
        r0 = new AutoMemoryCollectionAiTaskQueue$retryTask$1(this, r15);
        goto L8
    }

    private final Object a(a r12, Continuation<? super Boolean> r13) {
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, AutoMemoryCollectionAiTaskQueue$processRuleGenerator$1.class) == false) goto L7;
        AutoMemoryCollectionAiTaskQueue$processRuleGenerator$1 r0 = (AutoMemoryCollectionAiTaskQueue$processRuleGenerator$1) ZeusTransformUtils.preCheckCast(r14, AutoMemoryCollectionAiTaskQueue$processRuleGenerator$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
    L17:
        Boolean r11 = (Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L20;
        boolean r16 = r11.booleanValue();
    L22:
        return Boxing.boxBoolean(r16);
    L20:
        r16 = false;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryCollectionAiTaskQueue", "start processRuleGenerator ruleId:" + r12.a(), false, 4, null);
        Stage r17 = Stage.RULEGENERATOR;
        Function1 r18 = (Function1) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionAiTaskQueue$processRuleGenerator$2(null), Function1.class, "com.obric.memorydata.plugin");
        r0.label = 1;
        r15 = a(r17, r18, r0);
        if (r15 != r2) goto L17;
        return r2;
    L7:
        r0 = new AutoMemoryCollectionAiTaskQueue$processRuleGenerator$1(this, r14);
        goto L8
    }

    public static final /* synthetic */ Object a(AutoMemoryCollectionAiTaskQueue r2, long r3, Continuation r5) {
        return r2.a(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(AutoMemoryCollectionAiTaskQueue r2, Stage r3, Function1 r4, Continuation r5) {
        return r2.a(r3, (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(AutoMemoryCollectionAiTaskQueue r2, a r3, Continuation r4) {
        return r2.a(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(AutoMemoryCollectionAiTaskQueue r2, String r3, String r4, Continuation r5) {
        return r2.a(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(AutoMemoryCollectionAiTaskQueue r2, String r3, Continuation r4) {
        return r2.a(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Object a(AutoMemoryCollectionAiTaskQueue r1, String r2, JSONObject r3, Function1 r4, Continuation r5, int r6, Object r7) {
        Function1<? super TaskRequest.Builder, ? extends TaskRequest.Builder> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Continuation<? super JSONObject> r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r8 = $$Lambda$AutoMemoryCollectionAiTaskQueue$YHmNv2jH22q_1vktLF4YCNTb9U.INSTANCE;
    L6:
        return r1.a(r2, r3, r8, r9);
    }

    public static final /* synthetic */ Object a(AutoMemoryCollectionAiTaskQueue r2, Continuation r3) {
        return r2.a((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(String r12, String r13, Continuation<? super String> r14) {
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, AutoMemoryCollectionAiTaskQueue$runRecommendPackages$1.class) == false) goto L7;
        AutoMemoryCollectionAiTaskQueue$runRecommendPackages$1 r0 = (AutoMemoryCollectionAiTaskQueue$runRecommendPackages$1) ZeusTransformUtils.preCheckCast(r15, AutoMemoryCollectionAiTaskQueue$runRecommendPackages$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        AutoMemoryCollectionAiTaskQueue$runRecommendPackages$1 r6 = r0;
        Object r16 = r6.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r6.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
    L17:
        String r11 = ((JSONObject) ZeusTransformUtils.preCheckCast(r16, JSONObject.class, "com.obric.memorydata.plugin")).optString("app_names");
        if (r11 != null) goto L21;
        r11 = "";
    L21:
        return SequencesKt.joinToString$default(SequencesKt.distinct(SequencesKt.filter(SequencesKt.map(StringsKt.splitToSequence$default((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{','}, false, 0, 6, null), $$Lambda$AutoMemoryCollectionAiTaskQueue$KFruB8LHFVzhYReVlJwXhehKE.INSTANCE), $$Lambda$AutoMemoryCollectionAiTaskQueue$tHkaoN1pJIoftspl7ezCNAuML3s.INSTANCE)), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        JSONObject r4 = new JSONObject();
        r4.put(ChatMessage.TYPE_QUERY, r12);
        r4.put("app_names", r13);
        Unit r17 = Unit.INSTANCE;
        r6.label = 1;
        r16 = a(this, "auto_memory_pro_recommend_apps", r4, null, r6, 4, null);
        if (r16 != r1) goto L17;
        return r1;
    L7:
        r0 = new AutoMemoryCollectionAiTaskQueue$runRecommendPackages$1(this, r15);
        goto L8
    }

    private final Object a(String r10, Continuation<? super String> r11) {
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, AutoMemoryCollectionAiTaskQueue$runRuleRewrite$1.class) == false) goto L7;
        AutoMemoryCollectionAiTaskQueue$runRuleRewrite$1 r0 = (AutoMemoryCollectionAiTaskQueue$runRuleRewrite$1) ZeusTransformUtils.preCheckCast(r12, AutoMemoryCollectionAiTaskQueue$runRuleRewrite$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        AutoMemoryCollectionAiTaskQueue$runRuleRewrite$1 r6 = r0;
        Object r13 = r6.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r6.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L17:
        String r9 = ((JSONObject) ZeusTransformUtils.preCheckCast(r13, JSONObject.class, "com.obric.memorydata.plugin")).optString("rewrite_query");
        if (r9 != null) goto L21;
        return "";
    L21:
        return r9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        JSONObject r4 = new JSONObject();
        r4.put(ChatMessage.TYPE_QUERY, r10);
        Unit r14 = Unit.INSTANCE;
        r6.label = 1;
        r13 = a(this, "auto_memory_pro_rule_rewrite", r4, null, r6, 4, null);
        if (r13 != r1) goto L17;
        return r1;
    L7:
        r0 = new AutoMemoryCollectionAiTaskQueue$runRuleRewrite$1(this, r12);
        goto L8
    }

    private final Object a(String r8, JSONObject r9, Function1<? super TaskRequest.Builder, ? extends TaskRequest.Builder> r10, Continuation<? super JSONObject> r11) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryCollectionAiTaskQueue", "start runAlgoTask name:" + r8, false, 4, null);
        return da.a(12000, (Function2) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionAiTaskQueue$runAlgoTask$3(r8, r9, r7, null), Function2.class, "com.obric.memorydata.plugin"), r12);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00fb -> B:33:0x016f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x01f7 -> B:77:0x0290). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0212 -> B:55:0x0217). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0259 -> B:78:0x029c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x028d -> B:77:0x0290). Please report as a decompilation issue!!! */
    private final Object a(Continuation<? super Unit> r22) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AutoMemoryCollectionAiTaskQueue$runOneOrWait$1.class) == false) goto L7;
        AutoMemoryCollectionAiTaskQueue$runOneOrWait$1 r3 = (AutoMemoryCollectionAiTaskQueue$runOneOrWait$1) ZeusTransformUtils.preCheckCast(r1, AutoMemoryCollectionAiTaskQueue$runOneOrWait$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
        AutoMemoryCollectionAiTaskQueue r4 = this;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r3.label) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L13;
            case 8: goto L13;
            default: goto L11;
        };
    L12:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r3.L$1, a.class, "com.obric.memorydata.plugin");
        AutoMemoryCollectionAiTaskQueue r0 = (AutoMemoryCollectionAiTaskQueue) ZeusTransformUtils.preCheckCast(r3.L$0, AutoMemoryCollectionAiTaskQueue.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
    L56:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L67;
        r6.a(Stage.RULEGENERATOR);
        r3.L$0 = r0;
        r3.L$1 = r6;
        r3.label = 7;
        r2 = r0.a(r6, r3);
        if (r2 != r5) goto L77;
        return r5;
    L77:
        boolean r7 = ((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L78:
        a r20 = r6;
        r4 = r0;
        if (r7 == false) goto L80;
    L33:
        PriorityQueue<a> r8 = e;
        a r9 = (a) ZeusTransformUtils.preCheckCast(r8.peek(), a.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L37;
    L19:
        a r10 = (a) ZeusTransformUtils.preCheckCast(e.peek(), a.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L26;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryCollectionAiTaskQueue", "taskQueue is empty ", false, 4, null);
        i<Unit> r11 = d;
        r3.L$0 = null;
        r3.L$1 = null;
        r3.label = 1;
        if (r11.a(r3) != r5) goto L25;
        return r5;
    L25:
        return Unit.INSTANCE;
    L26:
        long r12 = RangesKt.coerceAtLeast(r10.d() - System.currentTimeMillis(), 0);
        if (r12 <= 0) goto L33;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryCollectionAiTaskQueue", "firstTask need wait " + r12, false, 4, null);
        kotlinx.coroutines.selects.l r13 = new kotlinx.coroutines.selects.l(r3.getContext());
        kotlinx.coroutines.selects.c r14 = (kotlinx.coroutines.selects.c) ZeusTransformUtils.preCheckCast(r13, kotlinx.coroutines.selects.c.class, "com.obric.memorydata.plugin");
        r14.a(b().j(), (Function2) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionAiTaskQueue$runOneOrWait$2$1(null), Function2.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.selects.b.a(r14, r12, (Function1) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionAiTaskQueue$runOneOrWait$2$2(null), Function1.class, "com.obric.memorydata.plugin"));
        r3.L$0 = null;
        r3.L$1 = null;
        r3.label = 2;
        if (r13.a(r3) != r5) goto L32;
        return r5;
    L32:
        return Unit.INSTANCE;
    L37:
        if (r9.d() > System.currentTimeMillis()) goto L19;
        a r15 = (a) ZeusTransformUtils.preCheckCast(r8.poll(), a.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L19;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryCollectionAiTaskQueue", "run task id:" + r15.a() + ",stage:" + r15.b(), false, 4, null);
        int r16 = b.f10619a[r15.b().ordinal()];
        if (r16 == 1) goto L61;
        if (r16 == 2) goto L51;
        if (r16 != 3) goto L50;
        r3.L$0 = r4;
        r3.L$1 = r15;
        r3.label = 8;
        r2 = r4.a(r15, r3);
        if (r2 != r5) goto L48;
        return r5;
    L48:
        AutoMemoryCollectionAiTaskQueue r21 = r4;
        r6 = r15;
        r0 = r21;
        goto L77
    L50:
        throw new NoWhenBranchMatchedException();
    L51:
        r3.L$0 = r4;
        r3.L$1 = r15;
        r3.label = 6;
        r2 = r4.c(r15, r3);
        if (r2 != r5) goto L54;
        return r5;
    L54:
        AutoMemoryCollectionAiTaskQueue r23 = r4;
        r6 = r15;
        r0 = r23;
        goto L56
    L61:
        r3.L$0 = r4;
        r3.L$1 = r15;
        r3.label = 3;
        r2 = r4.b(r15, r3);
        if (r2 != r5) goto L64;
        return r5;
    L64:
        AutoMemoryCollectionAiTaskQueue r24 = r4;
        r6 = r15;
        r0 = r24;
    L66:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L67;
        r6.a(Stage.RECOMMEND);
        r3.L$0 = r0;
        r3.L$1 = r6;
        r3.label = 4;
        r2 = r0.c(r6, r3);
        if (r2 != r5) goto L72;
        return r5;
    L72:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L67;
        r6.a(Stage.RULEGENERATOR);
        r3.L$0 = r0;
        r3.L$1 = r6;
        r3.label = 5;
        r2 = r0.a(r6, r3);
        if (r2 != r5) goto L77;
        return r5;
    L80:
        r4.a(r20);
    L67:
        r7 = false;
        goto L78
    L13:
        r6 = (a) ZeusTransformUtils.preCheckCast(r3.L$1, a.class, "com.obric.memorydata.plugin");
        r0 = (AutoMemoryCollectionAiTaskQueue) ZeusTransformUtils.preCheckCast(r3.L$0, AutoMemoryCollectionAiTaskQueue.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        goto L77
    L14:
        r6 = (a) ZeusTransformUtils.preCheckCast(r3.L$1, a.class, "com.obric.memorydata.plugin");
        r0 = (AutoMemoryCollectionAiTaskQueue) ZeusTransformUtils.preCheckCast(r3.L$0, AutoMemoryCollectionAiTaskQueue.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        goto L72
    L15:
        r6 = (a) ZeusTransformUtils.preCheckCast(r3.L$1, a.class, "com.obric.memorydata.plugin");
        r0 = (AutoMemoryCollectionAiTaskQueue) ZeusTransformUtils.preCheckCast(r3.L$0, AutoMemoryCollectionAiTaskQueue.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        goto L66
    L16:
        ResultKt.throwOnFailure(r2);
        goto L32
    L17:
        ResultKt.throwOnFailure(r2);
        goto L25
    L18:
        ResultKt.throwOnFailure(r2);
        goto L19
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r4 = this;
        r3 = new AutoMemoryCollectionAiTaskQueue$runOneOrWait$1(r4, r1);
        goto L8
    }

    private final String a(PackageManager r4, String r5) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        AutoMemoryCollectionAiTaskQueue r3 = (AutoMemoryCollectionAiTaskQueue) ZeusTransformUtils.preCheckCast(this, AutoMemoryCollectionAiTaskQueue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        ApplicationInfo r6 = r4.getApplicationInfo(r5, 0);     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r6, "getApplicationInfo(...)");     // Catch: Throwable -> L14
        CharSequence r7 = r4.getApplicationLabel(r6);     // Catch: Throwable -> L14
        if (r7 == null) goto L6;
        String r8 = r7.toString();     // Catch: Throwable -> L14
    L7:
        if (r8 != null) goto L9;
        r8 = "";
    L9:
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        boolean r10 = StringsKt.isBlank(r9);     // Catch: Throwable -> L14
        CharSequence r11 = r9;
        if (r10 == false) goto L12;
        r11 = r5;
    L12:
        Object r12 = Result.m1421constructorimpl((String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
    L16:
        Throwable r13 = Result.m1424exceptionOrNullimpl(r12);
        if (r13 != null) goto L19;
        Object r14 = r12;
    L23:
        return (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.memorydata.plugin");
    L19:
        r14 = r5;
        if (ZeusTransformUtils.instanceOf(r13, PackageManager.NameNotFoundException.class) == true) goto L23;
        RunLog.INSTANCE.warn("AutoMemoryCollectionAiTaskQueue", "getApplicationLabel failed, pkg=" + r5, r13);
        r14 = r5;
        goto L23
    L6:
        r8 = null;
    L14:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    private static final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    public static final /* synthetic */ List a(AutoMemoryCollectionAiTaskQueue r0) {
        return r0.e();
    }

    public static final /* synthetic */ PriorityQueue a() {
        return e;
    }

    private static final Sequence a(Map r2, Set r3, String r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, AnnotatedPrivateKey.LABEL);
        String r7 = (String) ZeusTransformUtils.preCheckCast(r5.get(r4), String.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L6;
        return SequencesKt.sequenceOf(new String[]{r7});
    L6:
        if (r6.contains(r4) == false) goto L9;
        return SequencesKt.sequenceOf(new String[]{r4});
    L9:
        return SequencesKt.emptySequence();
    }

    private final void a(a r9) {
        if (r9.e() <= 1) goto L7;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        int r4 = 4;
        Object r5 = null;
        String r1 = "AutoMemoryCollectionAiTaskQueue";
        String r2 = "retry later more then 1 time ";
    L5:
        IRunLog.a.a(r0, r1, r2, r3, r4, r5);
        return;
    L7:
        r9.a(r9.c() + 1);
        r9.a(System.currentTimeMillis() + 60000);
        r9.b(r9.e() + 1);
        e.add(r9);
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r2 = "task fail 3 time，retry later:" + r9.a() + ",stage:" + r9.b() + ",time:" + r9.d();
        r3 = false;
        r4 = 4;
        r5 = null;
        r1 = "AutoMemoryCollectionAiTaskQueue";
        goto L5
    }

    private static final TaskRequest.Builder b(TaskRequest.Builder r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        return (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r3.setConditions(new Condition[]{Condition.NETWORK_AVAILABLE, Condition.SCREEN_ON_OR_CHARGE}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.KEEP_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
    }

    private final Object b(a r19, Continuation<? super Boolean> r20) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AutoMemoryCollectionAiTaskQueue$processRewrite$1.class) == false) goto L7;
        AutoMemoryCollectionAiTaskQueue$processRewrite$1 r3 = (AutoMemoryCollectionAiTaskQueue$processRewrite$1) ZeusTransformUtils.preCheckCast(r1, AutoMemoryCollectionAiTaskQueue$processRewrite$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        AutoMemoryCollectionAiTaskQueue$processRewrite$1 r10 = r3;
        Object r2 = r10.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r10.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        ResultKt.throwOnFailure(r2);
    L36:
        return Boxing.boxBoolean(true);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        MemoryRuleEntity r0 = (MemoryRuleEntity) ZeusTransformUtils.preCheckCast(r10.L$2, MemoryRuleEntity.class, "com.obric.memorydata.plugin");
        a r6 = (a) ZeusTransformUtils.preCheckCast(r10.L$1, a.class, "com.obric.memorydata.plugin");
        AutoMemoryCollectionAiTaskQueue r7 = (AutoMemoryCollectionAiTaskQueue) ZeusTransformUtils.preCheckCast(r10.L$0, AutoMemoryCollectionAiTaskQueue.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
    L24:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L29;
        return Boxing.boxBoolean(false);
    L29:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L36;
        if (Intrinsics.areEqual(r8, r0.getContent()) == true) goto L36;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryCollectionAiTaskQueue", "processRewrite ruleId:" + r6.a() + ",title:" + r0.getTitle(), false, 4, null);
        long r9 = r6.a();
        String r11 = r0.getTitle();
        String r12 = r0.getAppPackages();
        r10.L$0 = null;
        r10.L$1 = null;
        r10.L$2 = null;
        r10.label = 2;
        if (r7.a(r9, r11, r8, r12, r10) != r4) goto L36;
        return r4;
    L16:
        ResultKt.throwOnFailure(r2);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryCollectionAiTaskQueue", "start processRewrite ruleId:" + r19.a(), false, 4, null);
        MemoryRuleEntity r13 = (MemoryRuleEntity) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().queryById(r19.a()), MemoryRuleEntity.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L19;
        Stage r14 = Stage.REWRITE;
        Function1 r15 = (Function1) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionAiTaskQueue$processRewrite$rewritten$1(r13, null), Function1.class, "com.obric.memorydata.plugin");
        r10.L$0 = this;
        r10.L$1 = r19;
        r10.L$2 = r13;
        r10.label = 1;
        Object r16 = a(r14, r15, r10);
        if (r16 != r4) goto L23;
        return r4;
    L23:
        r7 = this;
        r0 = r13;
        r2 = r16;
        r6 = r19;
        goto L24
    L19:
        return Boxing.boxBoolean(true);
    L7:
        r3 = new AutoMemoryCollectionAiTaskQueue$processRewrite$1(this, r1);
        goto L8
    }

    public static final /* synthetic */ Object b(AutoMemoryCollectionAiTaskQueue r2, a r3, Continuation r4) {
        return r2.b(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object b(AutoMemoryCollectionAiTaskQueue r2, Continuation r3) {
        return r2.b((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object b(Continuation<? super JSONObject> r4) {
        Continuation<? super JSONObject> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return a("auto_memory_pro_rule_generator", new JSONObject(), $$Lambda$AutoMemoryCollectionAiTaskQueue$cEnBNz7mXZ3ysu8vCAWD7ByCss.INSTANCE, r5);
    }

    public static final /* synthetic */ i b() {
        return d;
    }

    public static final /* synthetic */ void b(AutoMemoryCollectionAiTaskQueue r0) {
        r0.d();
    }

    private static final boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return !StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    private final IStore c() {
        return (IStore) ZeusTransformUtils.preCheckCast(f10616b.getValue(), IStore.class, "com.obric.memorydata.plugin");
    }

    private final Object c(a r25, Continuation<? super Boolean> r26) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r26, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AutoMemoryCollectionAiTaskQueue$processRecommend$1.class) == false) goto L7;
        AutoMemoryCollectionAiTaskQueue$processRecommend$1 r3 = (AutoMemoryCollectionAiTaskQueue$processRecommend$1) ZeusTransformUtils.preCheckCast(r1, AutoMemoryCollectionAiTaskQueue$processRecommend$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        AutoMemoryCollectionAiTaskQueue$processRecommend$1 r10 = r3;
        Object r2 = r10.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r10.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        ResultKt.throwOnFailure(r2);
    L42:
        return Boxing.boxBoolean(true);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        final Map r0 = (Map) ZeusTransformUtils.preCheckCast(r10.L$4, Map.class, "com.obric.memorydata.plugin");
        final Set<String> r6 = (Set) ZeusTransformUtils.preCheckCast(r10.L$3, Set.class, "com.obric.memorydata.plugin");
        MemoryRuleEntity r8 = (MemoryRuleEntity) ZeusTransformUtils.preCheckCast(r10.L$2, MemoryRuleEntity.class, "com.obric.memorydata.plugin");
        a r9 = (a) ZeusTransformUtils.preCheckCast(r10.L$1, a.class, "com.obric.memorydata.plugin");
        AutoMemoryCollectionAiTaskQueue r12 = (AutoMemoryCollectionAiTaskQueue) ZeusTransformUtils.preCheckCast(r10.L$0, AutoMemoryCollectionAiTaskQueue.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        a r13 = r9;
    L32:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L35;
        String r11 = SequencesKt.joinToString$default(SequencesKt.distinct(SequencesKt.flatMap(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{','}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$AutoMemoryCollectionAiTaskQueue$9HFHtL1a_3gP99JTZOBSV7kG4.INSTANCE), $$Lambda$AutoMemoryCollectionAiTaskQueue$RYsfIdGa7hC2vFv7FsCq6YdvGWI.INSTANCE), new $$Lambda$AutoMemoryCollectionAiTaskQueue$t1_q0bWcIFp3MZOY_j5eoqvQqQ(r0, r6))), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L42;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryCollectionAiTaskQueue", "processRecommend ruleId:" + r13.a() + ",title:" + r8.getTitle() + ",labels:" + r7 + ",packages:" + r11, false, 4, null);
        long r14 = r13.a();
        String r15 = r8.getTitle();
        String r16 = r8.getContent();
        r10.L$0 = null;
        r10.L$1 = null;
        r10.L$2 = null;
        r10.L$3 = null;
        r10.L$4 = null;
        r10.label = 2;
        if (r12.a(r14, r15, r16, r11, r10) != r4) goto L42;
        return r4;
    L35:
        return Boxing.boxBoolean(false);
    L16:
        ResultKt.throwOnFailure(r2);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryCollectionAiTaskQueue", "start processRecommend ruleId:" + r25.a(), false, 4, null);
        r8 = (MemoryRuleEntity) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().queryById(r25.a()), MemoryRuleEntity.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L19;
        r6 = g.f10670a.a();
        if (r6.isEmpty() == true) goto L23;
        PackageManager r17 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager();
        Sequence r18 = SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$AutoMemoryCollectionAiTaskQueue$0buuBvQU73O24M820IiLJ3IhoHI.INSTANCE), $$Lambda$AutoMemoryCollectionAiTaskQueue$IDLeYUG8xS5ZqLAnwBmsGJenca0.INSTANCE);
        Map r19 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r20 = r18.iterator();
    L26:
        if (r20.hasNext() == false) goto L28;
        Object r110 = r20.next();
        String r111 = (String) ZeusTransformUtils.preCheckCast(r110, String.class, "com.obric.memorydata.plugin");
        AutoMemoryCollectionAiTaskQueue r112 = f10615a;
        Intrinsics.checkNotNull(r17);
        r19.put(r112.a(r17, r111), (String) ZeusTransformUtils.preCheckCast(r110, String.class, "com.obric.memorydata.plugin"));
        goto L26
    L28:
        String r21 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r19.keySet(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        Stage r22 = Stage.RECOMMEND;
        Function1 r23 = (Function1) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionAiTaskQueue$processRecommend$recommendedLabels$1(r8, r21, null), Function1.class, "com.obric.memorydata.plugin");
        r10.L$0 = this;
        r13 = r25;
        r10.L$1 = r13;
        r10.L$2 = r8;
        r10.L$3 = r6;
        r10.L$4 = r19;
        r10.label = 1;
        r2 = a(r22, r23, r10);
        if (r2 != r4) goto L31;
        return r4;
    L31:
        r12 = this;
        r0 = r19;
        goto L32
    L23:
        return Boxing.boxBoolean(true);
    L19:
        return Boxing.boxBoolean(true);
    L7:
        r3 = new AutoMemoryCollectionAiTaskQueue$processRecommend$1(this, r1);
        goto L8
    }

    public static final /* synthetic */ Object c(AutoMemoryCollectionAiTaskQueue r2, a r3, Continuation r4) {
        return r2.c(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private static final String c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    private final void d() {
        bx r7 = f;
        boolean r0 = true;
        if (r7 != null) goto L5;
    L7:
        r0 = false;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        f = kotlinx.coroutines.i.a(c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionAiTaskQueue$ensureWorker$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L5:
        if (r7.a() != true) goto L7;
        goto L7
    }

    private static final boolean d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return !StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    private static final String e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    private final List<a> e() {
        String r0 = c().getString("auto_memory_pro_pending_rule_ai_tasks", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        AutoMemoryCollectionAiTaskQueue r3 = (AutoMemoryCollectionAiTaskQueue) ZeusTransformUtils.preCheckCast(this, AutoMemoryCollectionAiTaskQueue.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r1 = Result.m1421constructorimpl(new JSONArray(r0));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r1) == false) goto L10;
        r1 = null;
    L10:
        JSONArray r4 = (JSONArray) ZeusTransformUtils.preCheckCast(r1, JSONArray.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L13;
        r4 = new JSONArray();
    L13:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r4.length()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L15:
        if (r7.hasNext() == false) goto L30;
        JSONObject r8 = r4.optJSONObject(((IntIterator) ZeusTransformUtils.preCheckCast(r7, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        if (r8 != null) goto L19;
    L18:
        a r9 = null;
    L27:
        if (r9 == null) goto L15;
        r6.add(r9);
        goto L15
    L19:
        long r21 = r8.optLong("ruleId", 0);
        Stage.a r10 = Stage.Companion;
        String r11 = r8.optString("stage");
        Intrinsics.checkNotNullExpressionValue(r11, "optString(...)");
        Stage r13 = r10.a(r11);
        if (r13 == null) goto L18;
        r9 = new a(r21, r13, 0, 0, 0, 28, null);
        if (r21 <= 0) goto L25;
        boolean r12 = true;
    L26:
        if (r12 == false) goto L18;
    L25:
        r12 = false;
        goto L26
    L30:
        return (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private static final IStore f() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
    }

    private static final boolean f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return !StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ String lambda$0buuBvQU73O24M820IiLJ3IhoHI(String r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$9HFHtL1a_3gP99JTZOBS-V-7kG4, reason: not valid java name */
    public static /* synthetic */ String m788lambda$9HFHtL1a_3gP99JTZOBSV7kG4(String r0) {
        return c(r0);
    }

    /* JADX INFO: renamed from: lambda$A6IOaSmFtgO6bSpmUjQdYDKX-k4, reason: not valid java name */
    public static /* synthetic */ IStore m789lambda$A6IOaSmFtgO6bSpmUjQdYDKXk4() {
        return f();
    }

    public static /* synthetic */ boolean lambda$IDLeYUG8xS5ZqLAnwBmsGJenca0(String r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$KF-ruB8LHFVzhYReVlJwXh-ehKE, reason: not valid java name */
    public static /* synthetic */ String m790lambda$KFruB8LHFVzhYReVlJwXhehKE(String r0) {
        return e(r0);
    }

    public static /* synthetic */ boolean lambda$RYsfIdGa7hC2vFv7FsCq6YdvGWI(String r0) {
        return d(r0);
    }

    /* JADX INFO: renamed from: lambda$YHmNv2jH2-2q_1vktLF4YCNTb9U, reason: not valid java name */
    public static /* synthetic */ TaskRequest.Builder m791lambda$YHmNv2jH22q_1vktLF4YCNTb9U(TaskRequest.Builder r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$cEnBNz7mXZ3ysu8vCAWD7-ByCss, reason: not valid java name */
    public static /* synthetic */ TaskRequest.Builder m792lambda$cEnBNz7mXZ3ysu8vCAWD7ByCss(TaskRequest.Builder r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$t1_q0bWc-IFp3MZOY_j5eoqvQqQ, reason: not valid java name */
    public static /* synthetic */ Sequence m793lambda$t1_q0bWcIFp3MZOY_j5eoqvQqQ(Map r0, Set r1, String r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$tHkaoN1pJIoftspl7ezCNAuML3s(String r0) {
        return f(r0);
    }

    public final void a(long r7) {
        kotlinx.coroutines.i.a(c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionAiTaskQueue$enqueueRewriteAndRecommend$1(r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
