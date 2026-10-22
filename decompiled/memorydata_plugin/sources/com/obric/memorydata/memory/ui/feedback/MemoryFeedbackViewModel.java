package com.obric.memorydata.memory.ui.feedback;

import android.content.Context;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.NetworkUtils;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.ad;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ai;
import kotlinx.coroutines.flow.ak;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 (2\u00020\u0001:\u0002()B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0019J8\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u001e\b\u0002\u0010\u001f\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0015\u0018\u00010 JO\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u001c\u0010\u001f\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0015\u0018\u00010 2\u0010\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"H\u0000¢\u0006\u0002\b$J\b\u0010%\u001a\u00020&H\u0002J\u0014\u0010'\u001a\u00020\u0019*\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0015H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006*"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackUiState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "_events", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackViewModel$SubmitEvent;", "events", "Lkotlinx/coroutines/flow/SharedFlow;", "getEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "loadOptions", "", "optionResIds", "", "", "selectOption", AnnotatedPrivateKey.LABEL, "", "setInputText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, LocationMonitorConst.SUBMIT, "sceneTitleResId", "extraText", "customFilePathListProvider", "Lkotlin/Function1;", "odpReportDataProvider", "Lkotlin/Function0;", "Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackOdpReportData;", "submit$memory_obricRelease", "hasNetwork", "", "describeCustomFiles", "Companion", "SubmitEvent", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryFeedbackViewModel extends ViewModel {
    public static final a Companion = null;
    private static final int ERR_CODE_NOT_AGREED_LICENSE = 1001;
    private static final String KEY_FEEDBACK_ERROR_CODE = "error_code";
    private static final String KEY_FEEDBACK_ERROR_MSG = "error_msg";
    private static final String KEY_FEEDBACK_SUCCESS = "success";
    private static final String TAG = "MemoryFeedbackVM";
    private final ad<b> _events;
    private final ae<o> _state;
    private final ai<b> events;
    private final ar<o> state;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackViewModel$Companion;", "", "<init>", "()V", "TAG", "", "KEY_FEEDBACK_SUCCESS", "KEY_FEEDBACK_ERROR_MSG", "KEY_FEEDBACK_ERROR_CODE", "ERR_CODE_NOT_AGREED_LICENSE", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackViewModel$SubmitEvent;", "", "Success", "Failure", "Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackViewModel$SubmitEvent$Failure;", "Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackViewModel$SubmitEvent$Success;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface b {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackViewModel$SubmitEvent$Failure;", "Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackViewModel$SubmitEvent;", "message", "", "goReportActivity", "", "<init>", "(Ljava/lang/String;Z)V", "getMessage", "()Ljava/lang/String;", "getGoReportActivity", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f10925a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final boolean f10926b;

            public a(String r2, boolean r3) {
                Intrinsics.checkNotNullParameter(r2, "message");
                this.f10925a = r2;
                this.f10926b = r3;
            }

            public final String a() {
                return this.f10925a;
            }

            public final boolean b() {
                return this.f10926b;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f10925a, r6.f10925a) == true) goto L12;
                return false;
            L12:
                if (this.f10926b == r6.f10926b) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.f10925a.hashCode() * 31) + Boolean.hashCode(this.f10926b);
            }

            public String toString() {
                return "Failure(message=" + this.f10925a + ", goReportActivity=" + this.f10926b + ')';
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.feedback.MemoryFeedbackViewModel$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackViewModel$SubmitEvent$Success;", "Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackViewModel$SubmitEvent;", "<init>", "()V", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0558b implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0558b f10927a = null;

            static {
                f10927a = new C0558b();
            }

            private C0558b() {
            }
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.feedback.MemoryFeedbackViewModel$loadOptions$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.feedback.MemoryFeedbackViewModel$loadOptions$2", f = "MemoryFeedbackViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Integer> $optionResIds;
        int label;
        final /* synthetic */ MemoryFeedbackViewModel this$0;

        AnonymousClass2(List<Integer> r3, MemoryFeedbackViewModel r4, Continuation<? super AnonymousClass2> r5) {
            List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$optionResIds = r6;
            this.this$0 = r4;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$optionResIds, this.this$0, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r9);
            Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(this.$optionResIds, Iterable.class, "com.obric.memorydata.plugin");
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r11 = r10.iterator();
        L6:
            if (r11.hasNext() == false) goto L8;
            r0.add(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(((Number) ZeusTransformUtils.preCheckCast(r11.next(), Number.class, "com.obric.memorydata.plugin")).intValue()));
            goto L6
        L8:
            List r12 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
            Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r3 = r1.iterator();
        L10:
            if (r3.hasNext() == false) goto L12;
            String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNull(r4);
            r2.add(new d(r4, false));
            goto L10
        L12:
            List r5 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
            RunLog.INSTANCE.debug(MemoryFeedbackViewModel.TAG, "loadOptions finish, count=" + r5.size() + ", labels=" + r12);
            ae r8 = MemoryFeedbackViewModel.access$get_state$p(this.this$0);
        L13:
            Object r13 = r8.c();
            if (r8.a(r13, o.a((o) ZeusTransformUtils.preCheckCast(r13, o.class, "com.obric.memorydata.plugin"), r5, null, false, 2, null)) == false) goto L13;
            return Unit.INSTANCE;
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.feedback.MemoryFeedbackViewModel$submit$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.feedback.MemoryFeedbackViewModel$submit$2", f = "MemoryFeedbackViewModel.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
    static final class C11502 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, List<String>> $customFilePathListProvider;
        final /* synthetic */ String $extraText;
        final /* synthetic */ Function0<h> $odpReportDataProvider;
        final /* synthetic */ int $sceneTitleResId;
        final /* synthetic */ List<String> $selected;
        final /* synthetic */ String $text;
        int label;
        final /* synthetic */ MemoryFeedbackViewModel this$0;

        C11502(MemoryFeedbackViewModel r3, List<String> r4, int r5, String r6, String r7, Function1<? super String, ? extends List<String>> r8, Function0<h> r9, Continuation<? super C11502> r10) {
            List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Function1<String, List<String>> r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
            Function0<h> r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
            Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$selected = r11;
            this.$sceneTitleResId = r5;
            this.$text = r6;
            this.$extraText = r7;
            this.$customFilePathListProvider = r12;
            this.$odpReportDataProvider = r13;
            super(2, r14);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11502(this.this$0, this.$selected, this.$sceneTitleResId, this.$text, this.$extraText, this.$customFilePathListProvider, this.$odpReportDataProvider, r9), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11502) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11502.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r26) {
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = this.label;
            if (r3 == 0) goto L11;
            if (r3 != 1) goto L10;
            ResultKt.throwOnFailure(r26);     // Catch: Throwable -> L7
            Object r0 = r26;
            String r17 = "memory_feedback_submit_failed";
        L39:
            Bundle r1 = (Bundle) ZeusTransformUtils.preCheckCast(r0, Bundle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L79
            if (r1 == null) goto L42;
            boolean r4 = r1.getBoolean("success", false);     // Catch: Throwable -> L79
        L43:
            Integer r5 = null;
            if (r1 == null) goto L46;
            String r6 = r1.getString(MemoryFeedbackViewModel.KEY_FEEDBACK_ERROR_MSG, "");     // Catch: Throwable -> L79
        L47:
            if (r1 == null) goto L49;
            r5 = Boxing.boxInt(r1.getInt("error_code"));     // Catch: Throwable -> L79
        L49:
            IRunLog r10 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L79
            StringBuilder r7 = new StringBuilder().append("submit feedback result, success=");     // Catch: Throwable -> L79
            if (r4 == false) goto L52;
            boolean r8 = true;
        L53:
            StringBuilder r9 = r7.append(r8).append(", errCode=").append(r5);     // Catch: Throwable -> L79
            String r11 = ", errorMsg=";
            IRunLog.a.a(r10, MemoryFeedbackViewModel.TAG, r9.append(", errorMsg=").append(r6).toString(), false, 4, null);     // Catch: Throwable -> L79
            if (r5 != null) goto L57;
        L97:
            if (r4 == true) goto L72;
            ad r12 = MemoryFeedbackViewModel.access$get_events$p(this.this$0);     // Catch: Throwable -> L79
            String r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_feedback_submit_failed, TypedValues.Custom.S_STRING, r17));     // Catch: Throwable -> L77
            Intrinsics.checkNotNullExpressionValue(r13, "getString(...)");     // Catch: Throwable -> L77
            r12.a(new b.a(r13, false));     // Catch: Throwable -> L77
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L77
            ae r15 = MemoryFeedbackViewModel.access$get_state$p(this.this$0);
        L68:
            Object r16 = r15.c();
            if (r15.a(r16, o.a((o) ZeusTransformUtils.preCheckCast(r16, o.class, "com.obric.memorydata.plugin"), null, null, false, 3, null)) == false) goto L68;
            return r14;
        L72:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryFeedbackViewModel.TAG, "submit feedback success", false, 4, null);     // Catch: Throwable -> L77
            MemoryFeedbackViewModel.access$get_events$p(this.this$0).a(b.C0558b.f10927a);     // Catch: Throwable -> L77
            ae r18 = MemoryFeedbackViewModel.access$get_state$p(this.this$0);
        L74:
            Object r19 = r18.c();
            if (r18.a(r19, o.a((o) ZeusTransformUtils.preCheckCast(r19, o.class, "com.obric.memorydata.plugin"), null, null, false, 3, null)) == false) goto L74;
        L86:
            return Unit.INSTANCE;
        L77:
            th = th;
        L93:
            RunLog.INSTANCE.error(MemoryFeedbackViewModel.TAG, "submit feedback error", th);     // Catch: Throwable -> L87
            ad r20 = MemoryFeedbackViewModel.access$get_events$p(this.this$0);     // Catch: Throwable -> L87
            String r21 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_feedback_submit_failed, TypedValues.Custom.S_STRING, r11));     // Catch: Throwable -> L87
            Intrinsics.checkNotNullExpressionValue(r21, "getString(...)");     // Catch: Throwable -> L87
            r20.a(new b.a(r21, false));     // Catch: Throwable -> L87
            ae r22 = MemoryFeedbackViewModel.access$get_state$p(this.this$0);
        L83:
            Object r23 = r22.c();
            if (r22.a(r23, o.a((o) ZeusTransformUtils.preCheckCast(r23, o.class, "com.obric.memorydata.plugin"), null, null, false, 3, null)) == false) goto L83;
        L87:
            th = move-exception;
            ae r24 = MemoryFeedbackViewModel.access$get_state$p(this.this$0);
        L89:
            Object r25 = r24.c();
            if (r24.a(r25, o.a((o) ZeusTransformUtils.preCheckCast(r25, o.class, "com.obric.memorydata.plugin"), null, null, false, 3, null)) == false) goto L89;
            throw th;
        L57:
            if (r5.intValue() != 1001) goto L97;
            ad r27 = MemoryFeedbackViewModel.access$get_events$p(this.this$0);     // Catch: Throwable -> L79
            String r28 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_feedback_not_agreed_license, TypedValues.Custom.S_STRING, "memory_feedback_not_agreed_license"));     // Catch: Throwable -> L79
            Intrinsics.checkNotNullExpressionValue(r28, "getString(...)");     // Catch: Throwable -> L79
            r27.a(new b.a(r28, true));     // Catch: Throwable -> L79
            Unit r29 = Unit.INSTANCE;     // Catch: Throwable -> L79
            ae r30 = MemoryFeedbackViewModel.access$get_state$p(this.this$0);
        L60:
            Object r31 = r30.c();
            if (r30.a(r31, o.a((o) ZeusTransformUtils.preCheckCast(r31, o.class, "com.obric.memorydata.plugin"), null, null, false, 3, null)) == false) goto L60;
            return r29;
        L52:
            r8 = false;
            goto L53
        L46:
            r6 = null;
            goto L47
        L42:
            r4 = false;
            goto L43
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r26);
            if (MemoryFeedbackViewModel.access$hasNetwork(this.this$0) == true) goto L19;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryFeedbackViewModel.TAG, "submit feedback failed, no network", null, 4, null);     // Catch: Throwable -> L7
            ad r32 = MemoryFeedbackViewModel.access$get_events$p(this.this$0);     // Catch: Throwable -> L7
            String r33 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_feedback_no_network, TypedValues.Custom.S_STRING, "memory_feedback_no_network"));     // Catch: Throwable -> L7
            Intrinsics.checkNotNullExpressionValue(r33, "getString(...)");     // Catch: Throwable -> L7
            r32.a(new b.a(r33, false));     // Catch: Throwable -> L7
            Unit r34 = Unit.INSTANCE;     // Catch: Throwable -> L7
            ae r35 = MemoryFeedbackViewModel.access$get_state$p(this.this$0);
        L16:
            Object r36 = r35.c();
            if (r35.a(r36, o.a((o) ZeusTransformUtils.preCheckCast(r36, o.class, "com.obric.memorydata.plugin"), null, null, false, 3, null)) == false) goto L16;
            return r34;
        L19:
            String r37 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_feedback_none, TypedValues.Custom.S_STRING, "memory_feedback_none"));     // Catch: Throwable -> L7
            Intrinsics.checkNotNullExpressionValue(r37, "getString(...)");     // Catch: Throwable -> L7
            String r110 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_feedback_label_prefix, TypedValues.Custom.S_STRING, "memory_feedback_label_prefix"));     // Catch: Throwable -> L7
            Intrinsics.checkNotNullExpressionValue(r110, "getString(...)");     // Catch: Throwable -> L7
            String r111 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_feedback_problem_prefix, TypedValues.Custom.S_STRING, "memory_feedback_problem_prefix"));     // Catch: Throwable -> L7
            Intrinsics.checkNotNullExpressionValue(r111, "getString(...)");     // Catch: Throwable -> L7
            String r112 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_feedback_extra_prefix, TypedValues.Custom.S_STRING, "memory_feedback_extra_prefix"));     // Catch: Throwable -> L7
            Intrinsics.checkNotNullExpressionValue(r112, "getString(...)");     // Catch: Throwable -> L7
            if ((!((Collection) ZeusTransformUtils.preCheckCast(this.$selected, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L22;
            r37 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(this.$selected, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("、", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);     // Catch: Throwable -> L7
        L22:
            int r113 = this.$sceneTitleResId;     // Catch: Throwable -> L7
            String r114 = this.$text;     // Catch: Throwable -> L7
            String r115 = this.$extraText;     // Catch: Throwable -> L7
            StringBuilder r38 = new StringBuilder();     // Catch: Throwable -> L7
            r17 = "memory_feedback_submit_failed";
            r38.append(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(r113));     // Catch: Throwable -> L79
            r38.append("\n").append(r110).append(r37);     // Catch: Throwable -> L79
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r114, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L27;
            r38.append("\n").append(r111).append(r114);     // Catch: Throwable -> L79
        L27:
            CharSequence r39 = (CharSequence) ZeusTransformUtils.preCheckCast(r115, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L79
            if (r39 != null) goto L30;
        L33:
            boolean r40 = true;
        L34:
            if (r40 == true) goto L36;
            r38.append("\n").append(r112).append(r115);     // Catch: Throwable -> L79
        L36:
            String r41 = r38.toString();     // Catch: Throwable -> L79
            Intrinsics.checkNotNullExpressionValue(r41, "toString(...)");     // Catch: Throwable -> L79
            CoroutineContext r42 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L79
            Function2 r43 = (Function2) ZeusTransformUtils.preCheckCast(new MemoryFeedbackViewModel$submit$2$result$1(this.$customFilePathListProvider, r41, this.this$0, this.$odpReportDataProvider, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L79
            Continuation r44 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L79
            this.label = 1;     // Catch: Throwable -> L79
            r0 = kotlinx.coroutines.i.a(r42, r43, r44);     // Catch: Throwable -> L79
            if (r0 != r2) goto L39;
            return r2;
        L30:
            if (StringsKt.isBlank(r39) == true) goto L33;
            r40 = false;
        L79:
            th = th;
            r11 = r17;
        L7:
            th = th;
            r11 = "memory_feedback_submit_failed";
            goto L93
        }
    }

    static {
        Companion = new a(null);
    }

    public MemoryFeedbackViewModel() {
        ae<o> r0 = at.a(new o(null, null, false, 7, null));
        this._state = r0;
        this.state = kotlinx.coroutines.flow.k.a(r0);
        ad<b> r1 = ak.a(0, 1, null, 5, null);
        this._events = r1;
        this.events = (ai) ZeusTransformUtils.preCheckCast(r1, ai.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ String access$describeCustomFiles(MemoryFeedbackViewModel r2, List r3) {
        return r2.describeCustomFiles((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ ad access$get_events$p(MemoryFeedbackViewModel r0) {
        return r0._events;
    }

    public static final /* synthetic */ ae access$get_state$p(MemoryFeedbackViewModel r0) {
        return r0._state;
    }

    public static final /* synthetic */ boolean access$hasNetwork(MemoryFeedbackViewModel r0) {
        return r0.hasNetwork();
    }

    private final String describeCustomFiles(List<String> r11) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == false) goto L13;
        return "empty";
    L13:
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("; ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$MemoryFeedbackViewModel$m_fdkVOibZ1G7T10Aer2es7OHNQ.INSTANCE, 30, null);
    L5:
        if (r12.isEmpty() == true) goto L8;
        r13 = false;
        goto L9
    }

    private static final CharSequence describeCustomFiles$lambda$7(String r3) {
        Intrinsics.checkNotNullParameter(r3, "path");
        File r0 = new File(r3);
        return (CharSequence) ZeusTransformUtils.preCheckCast(r3 + "(exists=" + r0.exists() + ", isFile=" + r0.isFile() + ", isDirectory=" + r0.isDirectory() + ", size=" + r0.length() + ", canRead=" + r0.canRead() + ')', CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final boolean hasNetwork() {
        return NetworkUtils.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ CharSequence lambda$m_fdkVOibZ1G7T10Aer2es7OHNQ(String r0) {
        return describeCustomFiles$lambda$7(r0);
    }

    public static /* synthetic */ void submit$default(MemoryFeedbackViewModel r1, int r2, String r3, Function1 r4, int r5, Object r6) {
        Function1<? super String, ? extends List<String>> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r7 = null;
    L5:
        r1.submit(r2, r3, r7);
    }

    public final ai<b> getEvents() {
        return this.events;
    }

    public final ar<o> getState() {
        return this.state;
    }

    public final void loadOptions(List<Integer> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "optionResIds");
        RunLog.INSTANCE.debug(TAG, "loadOptions begin");
        ae<o> r0 = this._state;
    L3:
        o r2 = r0.c();
        if (r0.a(r2, o.a((o) ZeusTransformUtils.preCheckCast(r2, o.class, "com.obric.memorydata.plugin"), null, null, true, 3, null)) == false) goto L3;
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r12, this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void selectOption(String r10) {
        Intrinsics.checkNotNullParameter(r10, AnnotatedPrivateKey.LABEL);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(((o) ZeusTransformUtils.preCheckCast(this._state.c(), o.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r2.next(), d.class, "com.obric.memorydata.plugin");
        r1.add(d.a(r3, null, Intrinsics.areEqual(r3.a(), r10), 1, null));
        goto L4
    L6:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        ae<o> r9 = this._state;
    L7:
        o r5 = r9.c();
        if (r9.a(r5, o.a((o) ZeusTransformUtils.preCheckCast(r5, o.class, "com.obric.memorydata.plugin"), r4, null, false, 6, null)) == false) goto L7;
        RunLog.INSTANCE.debug(TAG, "selectOption label=" + r10);
    }

    public final void setInputText(String r9) {
        Intrinsics.checkNotNullParameter(r9, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        ae<o> r8 = this._state;
    L3:
        o r0 = r8.c();
        if (r8.a(r0, o.a((o) ZeusTransformUtils.preCheckCast(r0, o.class, "com.obric.memorydata.plugin"), null, r9, false, 5, null)) == false) goto L3;
        RunLog.INSTANCE.debug(TAG, "setInputText length=" + r9.length());
    }

    public final void submit(int r3, String r4, Function1<? super String, ? extends List<String>> r5) {
        submit$memory_obricRelease(r3, r4, (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin"), null);
    }

    public final void submit$memory_obricRelease(int r17, String r18, Function1<? super String, ? extends List<String>> r19, Function0<h> r20) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r19, Function1.class, "com.obric.memorydata.plugin");
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r20, Function0.class, "com.obric.memorydata.plugin");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(((o) ZeusTransformUtils.preCheckCast(this._state.c(), o.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r3 = r1.next();
        if (((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin")).b() == false) goto L4;
        r2.add(r3);
        goto L4
    L8:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r4.iterator();
    L10:
        if (r8.hasNext() == false) goto L12;
        r5.add(((d) ZeusTransformUtils.preCheckCast(r8.next(), d.class, "com.obric.memorydata.plugin")).a());
        goto L10
    L12:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        String r10 = ((o) ZeusTransformUtils.preCheckCast(this._state.c(), o.class, "com.obric.memorydata.plugin")).b();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "submit feedback begin, selected=" + r9 + ", textLength=" + r10.length(), false, 4, null);
        ae<o> r11 = this._state;
    L13:
        o r12 = r11.c();
        if (r11.a(r12, o.a((o) ZeusTransformUtils.preCheckCast(r12, o.class, "com.obric.memorydata.plugin"), null, null, true, 3, null)) == false) goto L13;
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11502(this, r9, r17, r10, r18, r6, r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
