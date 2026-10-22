package com.obric.widget.host.runtime;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.obric.widget.host.WidgetPerfReporter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.e;
import kotlinx.coroutines.z;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0001.B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0013J \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016H\u0086@¢\u0006\u0004\b\u001a\u0010\u0010J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0015\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u001c\u0010\u0019J\"\u0010\u001e\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010 R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010!R\u001c\u0010#\u001a\n \"*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetCatalogManager;", "", "Landroid/content/Context;", "context", "", "hostId", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lcom/obric/widget/host/WidgetPerfReporter;", "perfReporter", "Lcom/obric/widget/host/runtime/WidgetRuntimeClient;", "runtimeClient", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lkotlinx/coroutines/CoroutineScope;Lcom/obric/widget/host/WidgetPerfReporter;Lcom/obric/widget/host/runtime/WidgetRuntimeClient;)V", "", "awaitInit", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshCatalog", "init", "()V", "refreshCatalogSync", "appletId", "", "Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;", "getWidgets", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppletIds", "Lcom/obric/widget/host/runtime/WidgetAppletInfo;", "getAppletInfo", "widgetId", "getWidgetInfo", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/obric/widget/host/runtime/WidgetRuntimeClient;", "kotlin.jvm.PlatformType", "appContext", "Landroid/content/Context;", "Lkotlinx/coroutines/sync/a;", "mutex", "Lkotlinx/coroutines/sync/a;", "Ljava/util/LinkedHashMap;", "appletInfos", "Ljava/util/LinkedHashMap;", "Lkotlinx/coroutines/Job;", "initJob", "Lkotlinx/coroutines/Job;", "Companion", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWidgetCatalogManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetCatalogManager.kt\ncom/obric/widget/host/runtime/WidgetCatalogManager\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,120:1\n116#2,8:121\n125#2,2:135\n116#2,11:137\n116#2,11:148\n116#2,8:160\n125#2,2:172\n1368#3:129\n1454#3,5:130\n1557#3:168\n1628#3,3:169\n1#4:159\n*S KotlinDebug\n*F\n+ 1 WidgetCatalogManager.kt\ncom/obric/widget/host/runtime/WidgetCatalogManager\n*L\n62#1:121,8\n62#1:135,2\n73#1:137,11\n80#1:148,11\n106#1:160,8\n106#1:172,2\n66#1:129\n66#1:130,5\n108#1:168\n108#1:169,3\n*E\n"})
public final class WidgetCatalogManager {
    public static final Companion Companion = null;
    private static final String TAG = "OWidgetCatalogManager";
    private final Context appContext;
    private final LinkedHashMap<String, WidgetAppletInfo> appletInfos;
    private Job initJob;
    private final kotlinx.coroutines.sync.a mutex;
    private final WidgetRuntimeClient runtimeClient;
    private final CoroutineScope scope;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetCatalogManager$Companion;", "", "<init>", "()V", "TAG", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetCatalogManager$awaitInit$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetCatalogManager$awaitInit$2", f = "WidgetCatalogManager.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ WidgetCatalogManager this$0;

        public AnonymousClass2(WidgetCatalogManager r5, Continuation<? super AnonymousClass2> r10) {
            this.this$0 = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            return new AnonymousClass2(this.this$0, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            WidgetCatalogManager r12 = this.this$0;
            this.label = 1;
            if (WidgetCatalogManager.access$refreshCatalog(r12, this) != r10) goto L12;
            return r10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetCatalogManager$getAppletIds$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetCatalogManager", f = "WidgetCatalogManager.kt", i = {0, 1, 1}, l = {72, 126}, m = "getAppletIds", n = {"this", "this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0", "L$1"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WidgetCatalogManager this$0;

        public AnonymousClass1(WidgetCatalogManager r5, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getAppletIds(this);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetCatalogManager$getAppletInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetCatalogManager", f = "WidgetCatalogManager.kt", i = {0, 0, 1, 1, 1}, l = {79, 126}, m = "getAppletInfo", n = {"this", "appletId", "this", "appletId", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    public static final class C01931 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WidgetCatalogManager this$0;

        public C01931(WidgetCatalogManager r5, Continuation<? super C01931> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getAppletInfo(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetCatalogManager$getWidgetInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetCatalogManager", f = "WidgetCatalogManager.kt", i = {0}, l = {86}, m = "getWidgetInfo", n = {"widgetId"}, s = {"L$0"})
    public static final class C01941 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WidgetCatalogManager this$0;

        public C01941(WidgetCatalogManager r5, Continuation<? super C01941> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getWidgetInfo(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetCatalogManager$getWidgets$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetCatalogManager", f = "WidgetCatalogManager.kt", i = {0, 0, 1, 1, 1}, l = {61, 126}, m = "getWidgets", n = {"this", "appletId", "this", "appletId", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    public static final class C01951 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WidgetCatalogManager this$0;

        public C01951(WidgetCatalogManager r5, Continuation<? super C01951> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getWidgets(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetCatalogManager$init$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetCatalogManager$init$1", f = "WidgetCatalogManager.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ WidgetCatalogManager this$0;

        public C01961(WidgetCatalogManager r5, Continuation<? super C01961> r10) {
            this.this$0 = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            return new C01961(this.this$0, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            WidgetCatalogManager r12 = this.this$0;
            this.label = 1;
            if (WidgetCatalogManager.access$refreshCatalog(r12, this) != r10) goto L12;
            return r10;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((C01961) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetCatalogManager$refreshCatalog$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetCatalogManager", f = "WidgetCatalogManager.kt", i = {0, 0, 0, 0}, l = {126}, m = "refreshCatalog", n = {"this", "$this$refreshCatalog_u24lambda_u247", "queried", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
    public static final class C01971 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WidgetCatalogManager this$0;

        public C01971(WidgetCatalogManager r5, Continuation<? super C01971> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return WidgetCatalogManager.access$refreshCatalog(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetCatalogManager$refreshCatalogSync$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetCatalogManager$refreshCatalogSync$1", f = "WidgetCatalogManager.kt", i = {}, l = {47, 51, 55}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ WidgetCatalogManager this$0;

        /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetCatalogManager$refreshCatalogSync$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetCatalogManager$refreshCatalogSync$1$1", f = "WidgetCatalogManager.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ WidgetCatalogManager this$0;

            public C00181(WidgetCatalogManager r5, Continuation<? super C00181> r10) {
                this.this$0 = r5;
                super(2, r10);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
                return new C00181(this.this$0, r10);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
                return invoke2(r5, r10);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r5) {
                Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r11 = this.label;
                if (r11 == 0) goto L8;
                if (r11 != 1) goto L7;
                ResultKt.throwOnFailure(r5);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                WidgetCatalogManager r12 = this.this$0;
                this.label = 1;
                if (WidgetCatalogManager.access$refreshCatalog(r12, this) != r10) goto L12;
                return r10;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
                return ((C00181) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetCatalogManager$refreshCatalogSync$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetCatalogManager$refreshCatalogSync$1$2", f = "WidgetCatalogManager.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ WidgetCatalogManager this$0;

            public AnonymousClass2(WidgetCatalogManager r5, Continuation<? super AnonymousClass2> r10) {
                this.this$0 = r5;
                super(2, r10);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
                return new AnonymousClass2(this.this$0, r10);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
                return invoke2(r5, r10);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r5) {
                Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r11 = this.label;
                if (r11 == 0) goto L8;
                if (r11 != 1) goto L7;
                ResultKt.throwOnFailure(r5);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                WidgetCatalogManager r12 = this.this$0;
                this.label = 1;
                if (WidgetCatalogManager.access$refreshCatalog(r12, this) != r10) goto L12;
                return r10;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
                return ((AnonymousClass2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
            }
        }

        public C01981(WidgetCatalogManager r5, Continuation<? super C01981> r10) {
            this.this$0 = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            return new C01981(this.this$0, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L11;
            if (r11 == 1) goto L10;
            if (r11 == 2) goto L10;
            if (r11 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r10);
        L25:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r10);
            Job r12 = WidgetCatalogManager.access$getInitJob$p(this.this$0);
            if (r12 != null) goto L17;
            z r13 = Dispatchers.getIO();
            C00181 r14 = new C00181(this.this$0, null);
            this.label = 1;
            if (BuildersKt.withContext(r13, r14, this) != r5) goto L25;
            return r5;
        L17:
            if (r12.isCompleted() == false) goto L21;
            z r15 = Dispatchers.getIO();
            AnonymousClass2 r16 = new AnonymousClass2(this.this$0, null);
            this.label = 2;
            if (BuildersKt.withContext(r15, r16, this) != r5) goto L25;
            return r5;
        L21:
            this.label = 3;
            if (r12.join(this) != r5) goto L25;
            return r5;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((C01981) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WidgetCatalogManager(Context r5, String r10, CoroutineScope r11, WidgetPerfReporter r12, WidgetRuntimeClient r13) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "hostId");
        Intrinsics.checkNotNullParameter(r11, "scope");
        Intrinsics.checkNotNullParameter(r12, "perfReporter");
        Intrinsics.checkNotNullParameter(r13, "runtimeClient");
        this.scope = r11;
        this.runtimeClient = r13;
        this.appContext = r5.getApplicationContext();
        this.mutex = e.a();
        this.appletInfos = new LinkedHashMap();
    }

    public static final /* synthetic */ Object access$awaitInit(WidgetCatalogManager r5, Continuation r10) {
        return r5.awaitInit(r10);
    }

    public static final /* synthetic */ Job access$getInitJob$p(WidgetCatalogManager r5) {
        return r5.initJob;
    }

    public static final /* synthetic */ Object access$refreshCatalog(WidgetCatalogManager r5, Continuation r10) {
        return r5.refreshCatalog(r10);
    }

    private final Object awaitInit(Continuation<? super Unit> r5) {
        Job r10 = this.initJob;
        if (r10 != null) goto L9;
        Object r11 = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(this, null), r5);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r11;
    L8:
        return Unit.INSTANCE;
    L9:
        Object r12 = r10.join(r5);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r12;
    L13:
        return Unit.INSTANCE;
    }

    private final Object refreshCatalog(Continuation<? super Unit> r11) {
        if ((r11 instanceof C01971) == false) goto L7;
        C01971 r5 = (C01971) r11;
        int r10 = r5.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r12 = r5.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r5.label;
        if (r14 == 0) goto L18;
        if (r14 != 1) goto L17;
        kotlinx.coroutines.sync.a r15 = (kotlinx.coroutines.sync.a) r5.L$3;
        List<WidgetAppletInfo> r16 = (List) r5.L$2;
        WidgetCatalogManager r17 = (WidgetCatalogManager) r5.L$1;
        WidgetCatalogManager r18 = (WidgetCatalogManager) r5.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L14
        kotlinx.coroutines.sync.a r19 = r15;
        WidgetCatalogManager this = r17;
    L43:
        this.appletInfos.clear();     // Catch: Throwable -> L28
        LinkedHashMap<String, WidgetAppletInfo> r20 = this.appletInfos;     // Catch: Throwable -> L28
        ArrayList r21 = new ArrayList(CollectionsKt.h(r16));     // Catch: Throwable -> L28
        Iterator<T> r22 = r16.iterator();     // Catch: Throwable -> L28
    L26:
        if (r22.hasNext() == false) goto L30;
        WidgetAppletInfo r23 = (WidgetAppletInfo) r22.next();     // Catch: Throwable -> L28
        r21.add(TuplesKt.to(r23.getAppletId(), r23));     // Catch: Throwable -> L28
        goto L26
    L30:
        MapsKt.putAll(r20, r21);     // Catch: Throwable -> L28
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L28
        ((kotlinx.coroutines.sync.d) r19).d(null);     // Catch: Throwable -> L14
        Object r110 = Result.m124constructorimpl(Boxing.boxInt(Log.d(TAG, "refreshCatalog: package=" + this.appContext.getPackageName() + ", applets=" + r16.size())));     // Catch: Throwable -> L14
    L38:
        Throwable r111 = Result.m127exceptionOrNullimpl(r110);
        if (r111 == null) goto L42;
        Log.w(TAG, "refreshCatalog failed: package=" + r18.appContext.getPackageName(), r111);
    L42:
        return Unit.INSTANCE;
    L28:
        th = move-exception;
        ((kotlinx.coroutines.sync.d) r19).d(null);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        Throwable th2 = th;
    L37:
        Result.Companion r112 = Result.Companion;
        r110 = Result.m124constructorimpl(ResultKt.createFailure(th2));
        goto L38
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r12);
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L35
        List<WidgetAppletInfo> r114 = this.runtimeClient.queryMiniAppInfos(2);     // Catch: Throwable -> L35
        kotlinx.coroutines.sync.a r25 = this.mutex;     // Catch: Throwable -> L35
        r5.L$0 = this;     // Catch: Throwable -> L35
        r5.L$1 = this;     // Catch: Throwable -> L35
        r5.L$2 = r114;     // Catch: Throwable -> L35
        r5.L$3 = r25;     // Catch: Throwable -> L35
        r5.label = 1;     // Catch: Throwable -> L35
        kotlinx.coroutines.sync.d r26 = (kotlinx.coroutines.sync.d) r25;     // Catch: Throwable -> L35
        if (r26.c(r5) != r13) goto L22;
        return r13;
    L22:
        r18 = this;
        r16 = r114;
        r19 = r26;
    L35:
        th = move-exception;
        r18 = this;
        th2 = th;
    L7:
        r5 = new C01971(this, r11);
        goto L8
    }

    public final Object getAppletIds(Continuation<? super List<String>> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r5 = (AnonymousClass1) r10;
        int r11 = r5.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r5.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r5.label;
        if (r14 == 0) goto L16;
        if (r14 == 1) goto L15;
        if (r14 != 2) goto L14;
        kotlinx.coroutines.sync.a r15 = (kotlinx.coroutines.sync.a) r5.L$1;
        WidgetCatalogManager r16 = (WidgetCatalogManager) r5.L$0;
        ResultKt.throwOnFailure(r12);
    L30:
        List r17 = CollectionsKt.toList(r16.appletInfos.keySet());     // Catch: Throwable -> L27
        ((kotlinx.coroutines.sync.d) r15).d(null);
        return r17;
    L27:
        th = move-exception;
        ((kotlinx.coroutines.sync.d) r15).d(null);
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        WidgetCatalogManager this = (WidgetCatalogManager) r5.L$0;
        ResultKt.throwOnFailure(r12);
    L19:
        kotlinx.coroutines.sync.a r18 = this.mutex;
        r5.L$0 = this;
        r5.L$1 = r18;
        r5.label = 2;
        kotlinx.coroutines.sync.d r19 = (kotlinx.coroutines.sync.d) r18;
        if (r19.c(r5) != r13) goto L22;
        return r13;
    L22:
        r16 = this;
        r15 = r19;
        goto L30
    L16:
        ResultKt.throwOnFailure(r12);
        r5.L$0 = this;
        r5.label = 1;
        if (awaitInit(r5) != r13) goto L19;
        return r13;
    L7:
        r5 = new AnonymousClass1(this, r10);
        goto L8
    }

    public final Object getAppletInfo(String r10, Continuation<? super WidgetAppletInfo> r11) {
        if ((r11 instanceof C01931) == false) goto L7;
        C01931 r5 = (C01931) r11;
        int r12 = r5.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.label;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        kotlinx.coroutines.sync.a r16 = (kotlinx.coroutines.sync.a) r5.L$2;
        r10 = (String) r5.L$1;
        WidgetCatalogManager r17 = (WidgetCatalogManager) r5.L$0;
        ResultKt.throwOnFailure(r13);
    L30:
        WidgetAppletInfo r18 = r17.appletInfos.get(r10);     // Catch: Throwable -> L27
        ((kotlinx.coroutines.sync.d) r16).d(null);
        return r18;
    L27:
        th = move-exception;
        ((kotlinx.coroutines.sync.d) r16).d(null);
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (String) r5.L$1;
        WidgetCatalogManager this = (WidgetCatalogManager) r5.L$0;
        ResultKt.throwOnFailure(r13);
    L19:
        kotlinx.coroutines.sync.a r19 = this.mutex;
        r5.L$0 = this;
        r5.L$1 = r10;
        r5.L$2 = r19;
        r5.label = 2;
        kotlinx.coroutines.sync.d r20 = (kotlinx.coroutines.sync.d) r19;
        if (r20.c(r5) != r14) goto L22;
        return r14;
    L22:
        r17 = this;
        r16 = r20;
        goto L30
    L16:
        ResultKt.throwOnFailure(r13);
        r5.L$0 = this;
        r5.L$1 = r10;
        r5.label = 1;
        if (awaitInit(r5) != r14) goto L19;
        return r14;
    L7:
        r5 = new C01931(this, r11);
        goto L8
    }

    public final Object getWidgetInfo(String r5, String r10, Continuation<? super WidgetDefinitionMetadata> r11) {
        if ((r11 instanceof C01941) == false) goto L7;
        C01941 r12 = (C01941) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r10 = (String) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L17:
        WidgetAppletInfo r17 = (WidgetAppletInfo) r14;
        Object r18 = null;
        if (r17 == null) goto L32;
        List<WidgetDefinitionMetadata> r19 = r17.getWidgets();
        if (r19 == null) goto L33;
        Iterator<T> r20 = r19.iterator();
    L23:
        if (r20.hasNext() == false) goto L28;
        Object r21 = r20.next();
        if (Intrinsics.areEqual(((WidgetDefinitionMetadata) r21).getWidgetId(), r10) == false) goto L23;
        r18 = r21;
    L28:
        return (WidgetDefinitionMetadata) r18;
    L33:
        return null;
    L32:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        r12.L$0 = r10;
        r12.label = 1;
        r14 = getAppletInfo(r5, r12);
        if (r14 != r15) goto L17;
        return r15;
    L7:
        r12 = new C01941(this, r11);
        goto L8
    }

    public final Object getWidgets(String r10, Continuation<? super List<WidgetDefinitionMetadata>> r11) {
        if ((r11 instanceof C01951) == false) goto L7;
        C01951 r5 = (C01951) r11;
        int r12 = r5.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.label;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        kotlinx.coroutines.sync.a r16 = (kotlinx.coroutines.sync.a) r5.L$2;
        r10 = (String) r5.L$1;
        WidgetCatalogManager r17 = (WidgetCatalogManager) r5.L$0;
        ResultKt.throwOnFailure(r13);
    L46:
        if (r10 == null) goto L33;
        WidgetAppletInfo r18 = r17.appletInfos.get(r10);     // Catch: Throwable -> L30
        if (r18 == null) goto L32;
        List<WidgetDefinitionMetadata> r19 = r18.getWidgets();     // Catch: Throwable -> L30
        if (r19 == null) goto L32;
    L42:
        ((kotlinx.coroutines.sync.d) r16).d(null);
        return r19;
    L32:
        r19 = CollectionsKt.emptyList();     // Catch: Throwable -> L30
        goto L42
    L33:
        Collection<WidgetAppletInfo> r20 = r17.appletInfos.values();     // Catch: Throwable -> L30
        ArrayList r21 = new ArrayList();     // Catch: Throwable -> L30
        Iterator<T> r22 = r20.iterator();     // Catch: Throwable -> L30
    L35:
        if (r22.hasNext() == false) goto L41;
        List<WidgetDefinitionMetadata> r23 = ((WidgetAppletInfo) r22.next()).getWidgets();     // Catch: Throwable -> L30
        if (r23 != null) goto L39;
        r23 = CollectionsKt.emptyList();     // Catch: Throwable -> L30
    L39:
        CollectionsKt.a(r21, r23);     // Catch: Throwable -> L30
        goto L35
    L41:
        r19 = r21;
    L30:
        th = move-exception;
        ((kotlinx.coroutines.sync.d) r16).d(null);
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (String) r5.L$1;
        WidgetCatalogManager this = (WidgetCatalogManager) r5.L$0;
        ResultKt.throwOnFailure(r13);
    L19:
        kotlinx.coroutines.sync.a r24 = this.mutex;
        r5.L$0 = this;
        r5.L$1 = r10;
        r5.L$2 = r24;
        r5.label = 2;
        kotlinx.coroutines.sync.d r25 = (kotlinx.coroutines.sync.d) r24;
        if (r25.c(r5) != r14) goto L22;
        return r14;
    L22:
        r17 = this;
        r16 = r25;
        goto L46
    L16:
        ResultKt.throwOnFailure(r13);
        r5.L$0 = this;
        r5.L$1 = r10;
        r5.label = 1;
        if (awaitInit(r5) != r14) goto L19;
        return r14;
    L7:
        r5 = new C01951(this, r11);
        goto L8
    }

    public final void init() {
        if (this.initJob == null) goto L5;
        return;
    L5:
        this.initJob = BuildersKt.launch$default(this.scope, null, CoroutineStart.LAZY, new C01961(this, null), 1, null);
    }

    public final void refreshCatalogSync() {
        BuildersKt.runBlocking$default(null, new C01981(this, null), 1, null);
    }

    public /* synthetic */ WidgetCatalogManager(Context r10, String r11, CoroutineScope r12, WidgetPerfReporter r13, WidgetRuntimeClient r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 8) == 0) goto L6;
        r13 = WidgetPerfReporter.Companion.getNO_OP();
    L6:
        if ((r15 & 16) == 0) goto L8;
        Uri r5 = null;
        WidgetPerfReporter r17 = r13;
        r14 = new WidgetRuntimeClient(r10.getApplicationContext(), r11, r17, r5, 8, null);
    L8:
        WidgetPerfReporter r18 = r13;
        this(r10, r11, r12, r18, r14);
    }
}
