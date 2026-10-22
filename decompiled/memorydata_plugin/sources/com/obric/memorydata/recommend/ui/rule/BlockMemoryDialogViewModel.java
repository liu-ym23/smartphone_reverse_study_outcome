package com.obric.memorydata.recommend.ui.rule;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.obric.memorydata.database.entity.BlockMemoryContentEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.settings.l;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u001d2\u00020\u0001:\u0005\u001d\u001e\u001f !B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\u001a\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u000eH\u0002J\u0006\u0010\u001c\u001a\u00020\fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\""}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$BlockMemoryState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "extractExclusionRules", "", "content", "", "handleExtractResult", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "validateContent", "oldContent", "handleValidationResult", "saveBlockedContent", "handleExclusionRulesError", BlockMemoryDialogViewModel.CODE, "", "message", "handleValidateContentError", "validatedContent", "clean", "Companion", "LoadingResult", "ExclusionRulesState", "ValidateContentState", "BlockMemoryState", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BlockMemoryDialogViewModel extends ViewModel {
    private static final String CODE = "code";
    private static final String CONTENT = "content";
    public static final b Companion = null;
    private static final int ERROR_CODE = 1000;
    private static final String EXTRACT_EXCLUSION_RULES = "extract_exclusion_rules";
    public static final int LLM_ERROR_CONTENT_FILTER = 2;
    private static final String MEMORY_PRIVACY_TASK = "memory_privacy";
    private static final String MSG = "msg";
    private static final String OLD_CONTENT = "old_content";
    private static final String OPERATION_TYPE = "operation_type";
    private static final String RESULT = "result";
    private static final String RISK_REFERENCE = "bypass_risk_reference";
    public static final int SUCCESS_CODE = 0;
    private static final String TAG = "BlockMemoryDialogViewModel";
    private static final String VALIDATE_CONTENT = "validate_content";
    private final ae<a> _state;
    private final ar<a> state;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$BlockMemoryState;", "", "exclusionRules", "Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$ExclusionRulesState;", "validateContent", "Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$ValidateContentState;", "<init>", "(Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$ExclusionRulesState;Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$ValidateContentState;)V", "getExclusionRules", "()Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$ExclusionRulesState;", "getValidateContent", "()Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$ValidateContentState;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f12717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e f12718b;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public a(c r2, e r3) {
            Intrinsics.checkNotNullParameter(r2, "exclusionRules");
            Intrinsics.checkNotNullParameter(r3, "validateContent");
            this.f12717a = r2;
            this.f12718b = r3;
        }

        public /* synthetic */ a(c r8, e r9, int r10, DefaultConstructorMarker r11) {
            if ((r10 & 1) == 0) goto L6;
            r8 = new c(false, null, null, null, 15, null);
        L6:
            if ((r10 & 2) == 0) goto L8;
            r9 = new e(false, null, null, false, 15, null);
        L8:
            this(r8, r9);
        }

        public static /* synthetic */ a a(a r0, c r1, e r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.f12717a;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.f12718b;
        L9:
            return r0.a(r1, r2);
        }

        public final a a(c r1, e r2) {
            Intrinsics.checkNotNullParameter(r1, "exclusionRules");
            Intrinsics.checkNotNullParameter(r2, "validateContent");
            return new a(r1, r2);
        }

        public final c a() {
            return this.f12717a;
        }

        public final e b() {
            return this.f12718b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12717a, r6.f12717a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f12718b, r6.f12718b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f12717a.hashCode() * 31) + this.f12718b.hashCode();
        }

        public String toString() {
            return "BlockMemoryState(exclusionRules=" + this.f12717a + ", validateContent=" + this.f12718b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$Companion;", "", "<init>", "()V", "TAG", "", "MEMORY_PRIVACY_TASK", "OPERATION_TYPE", "CODE", "MSG", "CONTENT", "OLD_CONTENT", "RESULT", "RISK_REFERENCE", "EXTRACT_EXCLUSION_RULES", "VALIDATE_CONTENT", "ERROR_CODE", "", "LLM_ERROR_CONTENT_FILTER", "SUCCESS_CODE", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$ExclusionRulesState;", "", "isLoading", "", "sourceContent", "", "extraContent", BlockMemoryDialogViewModel.RESULT, "Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$LoadingResult;", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$LoadingResult;)V", "()Z", "getSourceContent", "()Ljava/lang/String;", "getExtraContent", "getResult", "()Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$LoadingResult;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f12719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f12720b;
        private final String c;
        private final d d;

        public c() {
            this(false, null, null, null, 15, null);
        }

        public c(boolean r2, String r3, String r4, d r5) {
            Intrinsics.checkNotNullParameter(r3, "sourceContent");
            Intrinsics.checkNotNullParameter(r4, "extraContent");
            this.f12719a = r2;
            this.f12720b = r3;
            this.c = r4;
            this.d = r5;
        }

        public /* synthetic */ c(boolean r2, String r3, String r4, d r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = false;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = "";
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = "";
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = null;
        L14:
            this(r2, r3, r4, r5);
        }

        public static /* synthetic */ c a(c r0, boolean r1, String r2, String r3, d r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.f12719a;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.f12720b;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.c;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.d;
        L15:
            return r0.a(r1, r2, r3, r4);
        }

        public final c a(boolean r1, String r2, String r3, d r4) {
            Intrinsics.checkNotNullParameter(r2, "sourceContent");
            Intrinsics.checkNotNullParameter(r3, "extraContent");
            return new c(r1, r2, r3, r4);
        }

        public final boolean a() {
            return this.f12719a;
        }

        public final String b() {
            return this.f12720b;
        }

        public final String c() {
            return this.c;
        }

        public final d d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (this.f12719a == r6.f12719a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f12720b, r6.f12720b) == true) goto L15;
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
            int r0 = ((((Boolean.hashCode(this.f12719a) * 31) + this.f12720b.hashCode()) * 31) + this.c.hashCode()) * 31;
            d r2 = this.d;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "ExclusionRulesState(isLoading=" + this.f12719a + ", sourceContent=" + this.f12720b + ", extraContent=" + this.c + ", result=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$LoadingResult;", "", BlockMemoryDialogViewModel.CODE, "", "message", "", "<init>", "(ILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f12722b;

        /* JADX WARN: Multi-variable type inference failed */
        public d() {
            this(0, null, 3, 0 == true ? 1 : 0);
        }

        public d(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "message");
            this.f12721a = r2;
            this.f12722b = r3;
        }

        public /* synthetic */ d(int r1, String r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = 0;
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = "";
        L8:
            this(r1, r2);
        }

        public final int a() {
            return this.f12721a;
        }

        public final String b() {
            return this.f12722b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
            if (this.f12721a == r6.f12721a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f12722b, r6.f12722b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f12721a) * 31) + this.f12722b.hashCode();
        }

        public String toString() {
            return "LoadingResult(code=" + this.f12721a + ", message=" + this.f12722b + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$ValidateContentState;", "", "isLoading", "", BlockMemoryDialogViewModel.RESULT, "Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$LoadingResult;", "lastValidatedContent", "", "isSafe", "<init>", "(ZLcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$LoadingResult;Ljava/lang/String;Z)V", "()Z", "getResult", "()Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$LoadingResult;", "getLastValidatedContent", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f12723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f12724b;
        private final String c;
        private final boolean d;

        public e() {
            this(false, null, null, false, 15, null);
        }

        public e(boolean r2, d r3, String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r4, "lastValidatedContent");
            this.f12723a = r2;
            this.f12724b = r3;
            this.c = r4;
            this.d = r5;
        }

        public /* synthetic */ e(boolean r2, d r3, String r4, boolean r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = false;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = "";
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = false;
        L14:
            this(r2, r3, r4, r5);
        }

        public static /* synthetic */ e a(e r0, boolean r1, d r2, String r3, boolean r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.f12723a;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.f12724b;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.c;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.d;
        L15:
            return r0.a(r1, r2, r3, r4);
        }

        public final e a(boolean r1, d r2, String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "lastValidatedContent");
            return new e(r1, r2, r3, r4);
        }

        public final boolean a() {
            return this.f12723a;
        }

        public final d b() {
            return this.f12724b;
        }

        public final String c() {
            return this.c;
        }

        public final boolean d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
            if (this.f12723a == r6.f12723a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f12724b, r6.f12724b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = Boolean.hashCode(this.f12723a) * 31;
            d r1 = this.f12724b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((((r0 + r2) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d);
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "ValidateContentState(isLoading=" + this.f12723a + ", result=" + this.f12724b + ", lastValidatedContent=" + this.c + ", isSafe=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$extractExclusionRules$taskRequest$2", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f implements com.obric.memorydata.task.scheduler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BlockMemoryDialogViewModel f12725a;

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f12726a = null;

            static {
                int[] r0 = new int[TaskInfo.State.values().length];
                r0[TaskInfo.State.SUCCEEDED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[TaskInfo.State.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f12726a = r0;
            }
        }

        f(BlockMemoryDialogViewModel r1) {
            this.f12725a = r1;
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r8) {
            Intrinsics.checkNotNullParameter(r8, "taskInfo");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), BlockMemoryDialogViewModel.TAG, "extractExclusionRules statue: " + r8.c(), false, 4, null);
            int r0 = a.f12726a[r8.c().ordinal()];
            if (r0 != 1) goto L5;
            BlockMemoryDialogViewModel.access$handleExtractResult(this.f12725a, r8);
            return;
        L5:
            if (r0 != 2) goto L11;
            BlockMemoryDialogViewModel.access$handleExclusionRulesError(this.f12725a, 1000, "task fail");
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$validateContent$taskRequest$2", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g implements com.obric.memorydata.task.scheduler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BlockMemoryDialogViewModel f12727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f12728b;

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f12729a = null;

            static {
                int[] r0 = new int[TaskInfo.State.values().length];
                r0[TaskInfo.State.SUCCEEDED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[TaskInfo.State.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f12729a = r0;
            }
        }

        g(BlockMemoryDialogViewModel r1, String r2) {
            this.f12727a = r1;
            this.f12728b = r2;
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r8) {
            Intrinsics.checkNotNullParameter(r8, "taskInfo");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), BlockMemoryDialogViewModel.TAG, "内容验证任务状态更新: " + r8.c(), false, 4, null);
            int r0 = a.f12729a[r8.c().ordinal()];
            if (r0 != 1) goto L5;
            BlockMemoryDialogViewModel.access$handleValidationResult(this.f12727a, r8, this.f12728b);
            return;
        L5:
            if (r0 != 2) goto L11;
            BlockMemoryDialogViewModel.handleValidateContentError$default(this.f12727a, 1000, null, 2, null);
            return;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.ui.rule.BlockMemoryDialogViewModel$validateContent$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.recommend.ui.rule.BlockMemoryDialogViewModel$validateContent$2", f = "BlockMemoryDialogViewModel.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BlockMemoryDialogViewModel this$0;

        AnonymousClass2(BlockMemoryDialogViewModel r3, Continuation<? super AnonymousClass2> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L11:
            ae r11 = BlockMemoryDialogViewModel.access$get_state$p(this.this$0);
        L12:
            Object r13 = r11.c();
            a r2 = (a) ZeusTransformUtils.preCheckCast(r13, a.class, "com.obric.memorydata.plugin");
            if (r11.a(r13, a.a(r2, null, e.a(r2.b(), false, null, null, false, 14, null), 1, null)) == false) goto L12;
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            Continuation r14 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (au.a(100, r14) != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new b(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BlockMemoryDialogViewModel() {
        Object[] r1 = 0 == true ? 1 : 0;
        ae<a> r0 = at.a(new a(null, r1, 3, 0 == true ? 1 : 0));
        this._state = r0;
        this.state = k.a(r0);
    }

    public static final /* synthetic */ ae access$get_state$p(BlockMemoryDialogViewModel r0) {
        return r0._state;
    }

    public static final /* synthetic */ void access$handleExclusionRulesError(BlockMemoryDialogViewModel r0, int r1, String r2) {
        r0.handleExclusionRulesError(r1, r2);
    }

    public static final /* synthetic */ void access$handleExtractResult(BlockMemoryDialogViewModel r0, TaskInfo r1) {
        r0.handleExtractResult(r1);
    }

    public static final /* synthetic */ void access$handleValidationResult(BlockMemoryDialogViewModel r0, TaskInfo r1, String r2) {
        r0.handleValidationResult(r1, r2);
    }

    private final void handleExclusionRulesError(int r10, String r11) {
        ae<a> r9 = this._state;
    L3:
        a r0 = r9.c();
        a r1 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        if (r9.a(r0, a.a(r1, c.a(r1.a(), false, null, null, new d(r10, r11), 6, null), null, 2, null)) == false) goto L3;
    }

    private final void handleExtractResult(TaskInfo r14) {
        JSONObject r15 = r14.e().getOutput();     // Catch: Exception -> L12
        int r4 = r15.optInt(CODE, 1000);     // Catch: Exception -> L12
        String r12 = r15.optString("content", "");     // Catch: Exception -> L12
        String r0 = r15.optString("msg", "");     // Catch: Exception -> L12
        RunLog.INSTANCE.debug(TAG, "extractExclusionRules completed code=" + r4 + " hasContent=" + r15.has("content"));     // Catch: Exception -> L12
        if (r15.has("content") == false) goto L10;
        if (r4 != 0) goto L10;
        ae<a> r16 = this._state;     // Catch: Exception -> L12
    L7:
        a r2 = r16.c();     // Catch: Exception -> L12
        a r5 = (a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        c r6 = r5.a();     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r12);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L12
        if (r16.a(r2, a.a(r5, c.a(r6, false, null, r12, new d(0, r0), 2, null), null, 2, null)) == false) goto L7;
    L14:
        return;
    L10:
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L12
        handleExclusionRulesError(r4, r0);     // Catch: Exception -> L12
    L12:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[code=block_rule_extract_result_failed] 处理提取结果失败", null, 4, null);
        handleExclusionRulesError(1000, "处理提取结果失败");
    }

    private final void handleValidateContentError(int r11, String r12) {
        ae<a> r10 = this._state;
    L3:
        a r0 = r10.c();
        a r1 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r11 != 2) goto L6;
        Triple r4 = new Triple(false, r12, ZeusTransformUtils.getResources(r3, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.screen_memory_block_dialog_validate_error_tip, TypedValues.Custom.S_STRING, "screen_memory_block_dialog_validate_error_tip")));
    L7:
        boolean r5 = ((Boolean) ZeusTransformUtils.preCheckCast(r4.component1(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.component2(), String.class, "com.obric.memorydata.plugin");
        Object r7 = r4.component3();
        Intrinsics.checkNotNullExpressionValue(r7, "component3(...)");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");
        if (r10.a(r0, a.a(r1, null, r1.b().a(false, new d(r11, r2), r6, r5), 1, null)) == false) goto L3;
        return;
    L6:
        r4 = new Triple(Boolean.valueOf(r1.b().d()), "", ZeusTransformUtils.getResources(r3, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.screen_memory_block_dialog_network_error_tip, TypedValues.Custom.S_STRING, "screen_memory_block_dialog_network_error_tip")));
        goto L7
    }

    static /* synthetic */ void handleValidateContentError$default(BlockMemoryDialogViewModel r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = "";
    L5:
        r0.handleValidateContentError(r1, r2);
    }

    private final void handleValidationResult(TaskInfo r14, String r15) {
        JSONObject r16 = r14.e().getOutput();     // Catch: Exception -> L31
        int r5 = r16.optInt(CODE, 1000);     // Catch: Exception -> L31
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "内容验证完成 code=" + r5 + " hasContent=" + r16.has("content"), false, 4, null);     // Catch: Exception -> L31
        if (r5 == 0) goto L7;
        handleValidateContentError(r5, r15);     // Catch: Exception -> L31
        return;
    L7:
        JSONObject r17 = r16.optJSONObject("content");     // Catch: Exception -> L31
        if (r17 != null) goto L11;
        handleValidateContentError(1000, r15);     // Catch: Exception -> L31
        return;
    L11:
        boolean r1 = r17.optBoolean(RESULT, false);     // Catch: Exception -> L31
        String r8 = "";
        if (r1 == true) goto L27;
        String r9 = r17.optString(RISK_REFERENCE, "");     // Catch: Exception -> L31
        Intrinsics.checkNotNullExpressionValue(r9, "optString(...)");     // Catch: Exception -> L31
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L18;
        boolean r10 = true;
    L20:
        if (r10 == false) goto L26;
        String r18 = r17.optString(RISK_REFERENCE, "");     // Catch: Exception -> L31
        if (r18.length() <= 15) goto L24;
        StringBuilder r0 = new StringBuilder();     // Catch: Exception -> L31
        Intrinsics.checkNotNull(r18);     // Catch: Exception -> L31
        String r19 = r18.substring(0, 15);     // Catch: Exception -> L31
        Intrinsics.checkNotNullExpressionValue(r19, "substring(...)");     // Catch: Exception -> L31
        r18 = r0.append(r19).append("...").toString();     // Catch: Exception -> L31
    L24:
        r8 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.screen_memory_block_dialog_validate_risk_reference_tip, TypedValues.Custom.S_STRING, "screen_memory_block_dialog_validate_risk_reference_tip"), new Object[]{r18});     // Catch: Exception -> L31
    L25:
        Intrinsics.checkNotNull(r8);     // Catch: Exception -> L31
        goto L27
    L26:
        r8 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.screen_memory_block_dialog_validate_error_tip, TypedValues.Custom.S_STRING, "screen_memory_block_dialog_validate_error_tip"));     // Catch: Exception -> L31
        goto L25
    L18:
        r10 = false;
    L27:
        ae<a> r110 = this._state;     // Catch: Exception -> L31
    L28:
        a r2 = r110.c();     // Catch: Exception -> L31
        a r11 = (a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L31
        if (r110.a(r2, a.a(r11, null, r11.b().a(false, new d(r5, r8), r15, r1), 1, null)) == false) goto L28;
        return;
    L31:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[code=block_rule_validation_result_failed] 处理验证结果失败", null, 4, null);
        handleValidateContentError$default(this, 1000, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void clean() {
        ae<a> r3 = this._state;
        Object[] r1 = 0 == true ? 1 : 0;
        r3.b(new a(null, r1, 3, 0 == true ? 1 : 0));
    }

    public final void extractExclusionRules(String r14) {
        Intrinsics.checkNotNullParameter(r14, "content");
        ae<a> r1 = this._state;
    L3:
        a r2 = r1.c();
        if (r1.a(r2, a.a((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.memorydata.plugin"), new c(true, r14, null, null, 4, null), null, 2, null)) == false) goto L3;
        TaskRequest.Builder r3 = new TaskRequest.Builder(MEMORY_PRIVACY_TASK);
        JSONObject r4 = new JSONObject();
        r4.put(OPERATION_TYPE, EXTRACT_EXCLUSION_RULES);
        r4.put("content", r14);
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r3.setInputParam(r4), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new f(this), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }

    public final ar<a> getState() {
        return this.state;
    }

    public final void saveBlockedContent(String r13) {
        Intrinsics.checkNotNullParameter(r13, "content");
        long r7 = System.currentTimeMillis();     // Catch: Exception -> L6
        long r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getBlockMemoryContentDao().insert(new BlockMemoryContentEntity(0, r13, r7, r7, 1, null));     // Catch: Exception -> L6
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "has saved blocked memory content id=" + r0, false, 4, null);
        l.f12612a.a(r0);
        return;
    L6:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[code=blocked_memory_rule_save_failed] save blocked memory content failed", null, 4, null);
    }

    public final void validateContent(String r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "content");
        if (Intrinsics.areEqual(r13, ((a) ZeusTransformUtils.preCheckCast(this._state.c(), a.class, "com.obric.memorydata.plugin")).b().c()) == false) goto L9;
        ae<a> r1 = this._state;
    L5:
        a r15 = r1.c();
        a r16 = (a) ZeusTransformUtils.preCheckCast(r15, a.class, "com.obric.memorydata.plugin");
        if (r1.a(r15, a.a(r16, null, e.a(r16.b(), true, null, null, false, 14, null), 1, null)) == false) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "内容已验证过且相同，跳过验证", false, 4, null);
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        return;
    L9:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "验证内容合法性", false, 4, null);
        ae<a> r2 = this._state;
    L10:
        a r5 = r2.c();
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (r2.a(r5, a.a(r6, null, r6.b().a(true, null, "", false), 1, null)) == false) goto L10;
        TaskRequest.Builder r3 = new TaskRequest.Builder(MEMORY_PRIVACY_TASK);
        JSONObject r4 = new JSONObject();
        r4.put(OPERATION_TYPE, VALIDATE_CONTENT);
        r4.put("content", r13);
        if (r14 != null) goto L15;
        r14 = "";
    L15:
        r4.put(OLD_CONTENT, r14);
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r3.setInputParam(r4), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new g(this, r13), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }
}
