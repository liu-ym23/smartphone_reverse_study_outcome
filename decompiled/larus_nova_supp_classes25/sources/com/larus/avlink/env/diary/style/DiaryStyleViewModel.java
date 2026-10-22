package com.larus.avlink.env.diary.style;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.env.diary.style.api.DoraEnvObserveDiaryStyleApi;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.model.FlowDoraSubBizType;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005J\u0006\u0010*\u001a\u00020'J\u0015\u0010+\u001a\u00020'2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020\tH\u0002J\u0006\u0010.\u001a\u00020'J\u0010\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020\u000fH\u0002J\u0010\u00103\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0002J\u0006\u00104\u001a\u00020'J\u000e\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020\u0005JI\u00107\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00052)\u00109\u001a%\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b;\u0012\b\b(\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020'0:J\"\u0010=\u001a\u00020'2\u0006\u00100\u001a\u00020\u000f2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020'0>JX\u0010?\u001a\u00020'2\u0006\u00106\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u000528\u00109\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b;\u0012\b\b(\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b;\u0012\b\b(\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020'0:R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\t0\t0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u001a0\u001a0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u001c\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u001a0\u001a0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u0016¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0016\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u0016¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018¨\u0006B"}, d2 = {"Lcom/larus/avlink/env/diary/style/DiaryStyleViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "TAG", "", "defaultCustomStyleNameRegex", "Lkotlin/text/Regex;", "defaultMaxCount", "", "productId", "Ljava/lang/Integer;", "_styles", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/avlink/env/diary/style/DiaryStyleItem;", "_maxCount", "kotlin.jvm.PlatformType", "_styleListData", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/larus/avlink/env/diary/style/DiaryStyleListUiData;", "styleListData", "Landroidx/lifecycle/LiveData;", "getStyleListData", "()Landroidx/lifecycle/LiveData;", "_isRefreshing", "", "isRefreshing", "_isLoading", "isLoading", "_scrollToBottom", "", "scrollToBottom", "getScrollToBottom", "_addStyleDraft", "Lcom/larus/avlink/env/diary/style/DiaryStyleViewModel$AddStyleDraft;", "addStyleDraft", "getAddStyleDraft", "updateAddStyleDraft", "", "name", "prompt", "clearAddStyleDraft", "setProductId", "(Ljava/lang/Integer;)V", "getDoraSubBiz", "loadStyles", "mapStyleInfoToItem", "styleInfo", "Lcom/larus/avlink/env/diary/style/api/DiaryStyleInfo;", "createAddButtonItem", "resolveStyleName", "refresh", "selectStyle", "styleId", "addCustomStyle", "requestId", "onResult", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "errorCode", "deleteStyle", "Lkotlin/Function1;", "updateCustomStyle", "result", "AddStyleDraft", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DiaryStyleViewModel extends ViewModel {
    public static final int $stable = 8;
    private final String TAG;
    private final MutableLiveData<a> _addStyleDraft;
    private final MutableLiveData<Boolean> _isLoading;
    private final MutableLiveData<Boolean> _isRefreshing;
    private final MutableLiveData<Integer> _maxCount;
    private final MutableLiveData<Long> _scrollToBottom;
    private final MediatorLiveData<f0> _styleListData;
    private final MutableLiveData<List<e0>> _styles;
    private final LiveData<a> addStyleDraft;
    private final Regex defaultCustomStyleNameRegex;
    private final int defaultMaxCount;
    private final LiveData<Boolean> isLoading;
    private final LiveData<Boolean> isRefreshing;
    private Integer productId;
    private final LiveData<Long> scrollToBottom;
    private final LiveData<f0> styleListData;

    public static final class a {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
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
            return "AddStyleDraft(name=" + this.a + ", prompt=" + this.b + ')';
        }

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "prompt");
            this.a = r2;
            this.b = r3;
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.style.DiaryStyleViewModel$addCustomStyle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.diary.style.DiaryStyleViewModel$addCustomStyle$1", f = "DiaryStyleViewModel.kt", i = {}, l = {245}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $name;
        final /* synthetic */ Function2<e0, Long, Unit> $onResult;
        final /* synthetic */ String $prompt;
        final /* synthetic */ String $requestId;
        int label;
        final /* synthetic */ DiaryStyleViewModel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(DiaryStyleViewModel r1, String r2, Function2<? super e0, ? super Long, Unit> r3, String r4, String r5, Continuation<? super AnonymousClass1> r6) {
            this.this$0 = r1;
            this.$name = r2;
            this.$onResult = r3;
            this.$prompt = r4;
            this.$requestId = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.this$0, this.$name, this.$onResult, this.$prompt, this.$requestId, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = this.label;
            if (r3 == 0) goto L9;
            if (r3 != 1) goto L8;
            ResultKt.throwOnFailure(r13);     // Catch: Exception -> L52
        L13:
            dm9.a.b r14 = (dm9.a) r13;     // Catch: Exception -> L52
            if ((r14 instanceof dm9.a.b) == false) goto L48;
            if (r14.a.getCode() != 0) goto L46;
            FLogger r0 = FLogger.a;     // Catch: Exception -> L52
            r0.i(DiaryStyleViewModel.access$getTAG$p(this.this$0), "addCustomStyle success: " + this.$name);     // Catch: Exception -> L52
            m98.e r15 = (m98.e) r14.a.getData();     // Catch: Exception -> L52
            if (r15 == null) goto L20;
            m98.b r16 = r15.a();     // Catch: Exception -> L52
        L21:
            if (r16 == null) goto L23;
            e0 r17 = DiaryStyleViewModel.access$mapStyleInfoToItem(this.this$0, r16);     // Catch: Exception -> L52
        L24:
            if (r17 != null) goto L27;
            this.$onResult.invoke(null, Boxing.boxLong(0));     // Catch: Exception -> L52
            r0.e(DiaryStyleViewModel.access$getTAG$p(this.this$0), "addCustomStyle failed: newItem is null");     // Catch: Exception -> L52
            return Unit.INSTANCE;
        L27:
            this.$onResult.invoke(r17, Boxing.boxLong(0));     // Catch: Exception -> L52
            List r1 = (List) DiaryStyleViewModel.access$get_styles$p(this.this$0).getValue();     // Catch: Exception -> L52
            if (r1 != null) goto L30;
            r1 = CollectionsKt.emptyList();     // Catch: Exception -> L52
        L30:
            List r4 = r1;     // Catch: Exception -> L52
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));     // Catch: Exception -> L52
            Iterator r6 = r4.iterator();     // Catch: Exception -> L52
        L32:
            if (r6.hasNext() == false) goto L34;
            r5.add(e0.a((e0) r6.next(), null, null, false, false, 239));     // Catch: Exception -> L52
            goto L32
        L34:
            List r7 = CollectionsKt.toMutableList(r5);     // Catch: Exception -> L52
            Iterator r8 = r7.iterator();     // Catch: Exception -> L52
            int r9 = 0;
        L36:
            if (r8.hasNext() == false) goto L41;
            if (((e0) r8.next()).g == true) goto L42;
            r9 = r9 + 1;     // Catch: Exception -> L52
        L42:
            if (r9 >= 0) goto L45;
            r9 = r7.size();     // Catch: Exception -> L52
        L45:
            ListProtector.add(r7, r9, r17);     // Catch: Exception -> L52
            DiaryStyleViewModel.access$get_styles$p(this.this$0).setValue(CollectionsKt.toMutableList(r7));     // Catch: Exception -> L52
            DiaryStyleViewModel.access$get_scrollToBottom$p(this.this$0).setValue(Boxing.boxLong(System.currentTimeMillis()));     // Catch: Exception -> L52
        L55:
            return Unit.INSTANCE;
        L41:
            r9 = -1;
            goto L42
        L23:
            r17 = null;
            goto L24
        L20:
            r16 = null;
            goto L21
        L46:
            this.$onResult.invoke(null, Boxing.boxLong(r14.a.getCode()));     // Catch: Exception -> L52
            FLogger.a.e(DiaryStyleViewModel.access$getTAG$p(this.this$0), "addCustomStyle failed: code=" + r14.a.getCode() + ", msg=" + r14.a.getMsg());     // Catch: Exception -> L52
            goto L55
        L48:
            if ((r14 instanceof dm9.a.a) == false) goto L51;
            this.$onResult.invoke(null, Boxing.boxLong(0));     // Catch: Exception -> L52
            FLogger.a.e(DiaryStyleViewModel.access$getTAG$p(this.this$0), "addCustomStyle error: " + ((dm9.a.a) r14).b);     // Catch: Exception -> L52
            goto L55
        L51:
            throw new NoWhenBranchMatchedException();     // Catch: Exception -> L52
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r13);
            String r10 = DiaryStyleViewModel.access$resolveStyleName(this.this$0, this.$name);     // Catch: Exception -> L52
            DoraEnvObserveDiaryStyleApi.a r18 = DoraEnvObserveDiaryStyleApi.a;     // Catch: Exception -> L52
            DiaryStyleViewModel$addCustomStyle$1$result$1 r11 = new DiaryStyleViewModel$addCustomStyle$1$result$1(this.this$0, this.$prompt, r10, this.$requestId, null);     // Catch: Exception -> L52
            this.label = 1;     // Catch: Exception -> L52
            r18.getClass();     // Catch: Exception -> L52
            r13 = DoraEnvObserveDiaryStyleApi.a.a(r11, this);     // Catch: Exception -> L52
            if (r13 != r2) goto L13;
            return r2;
        L52:
            e = move-exception;
            FLogger.a.e(DiaryStyleViewModel.access$getTAG$p(this.this$0), "addCustomStyle error: " + e.getMessage(), e);
            goto L55
        }
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.style.DiaryStyleViewModel$deleteStyle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.diary.style.DiaryStyleViewModel$deleteStyle$1", f = "DiaryStyleViewModel.kt", i = {}, l = {307}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $onResult;
        final /* synthetic */ e0 $styleInfo;
        int label;
        final /* synthetic */ DiaryStyleViewModel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C01051(DiaryStyleViewModel r1, e0 r2, Function1<? super Boolean, Unit> r3, Continuation<? super C01051> r4) {
            this.this$0 = r1;
            this.$styleInfo = r2;
            this.$onResult = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01051(this.this$0, this.$styleInfo, this.$onResult, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r15) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L9;
            if (r2 != 1) goto L8;
            ResultKt.throwOnFailure(r15);     // Catch: Exception -> L72
        L13:
            dm9.a.b r16 = (dm9.a) r15;     // Catch: Exception -> L72
            if ((r16 instanceof dm9.a.b) == false) goto L68;
            if (r16.a.getCode() != 0) goto L66;
            List r17 = (List) DiaryStyleViewModel.access$get_styles$p(this.this$0).getValue();     // Catch: Exception -> L72
            if (r17 == null) goto L20;
            e0 r0 = this.$styleInfo;     // Catch: Exception -> L72
            ArrayList r3 = new ArrayList();     // Catch: Exception -> L72
            Iterator r18 = r17.iterator();     // Catch: Exception -> L72
        L23:
            if (r18.hasNext() == false) goto L33;
            Object r4 = r18.next();     // Catch: Exception -> L72
            e0 r6 = (e0) r4;     // Catch: Exception -> L72
            if (Intrinsics.areEqual(r6.a, r0.a) == true) goto L27;
        L30:
            boolean r7 = true;
        L31:
            if (r7 == false) goto L23;
            r3.add(r4);     // Catch: Exception -> L72
            goto L23
        L27:
            if (r6.h != r0.h) goto L30;
            r7 = false;
            goto L31
        L33:
            e0 r19 = this.$styleInfo;     // Catch: Exception -> L72
            if (r19.f == true) goto L36;
        L38:
            boolean r110 = false;
        L39:
            if (r110 == false) goto L65;
            Iterator r111 = r3.iterator();     // Catch: Exception -> L72
            int r5 = 0;
        L42:
            if (r111.hasNext() == false) goto L47;
            if ((!((e0) r111.next()).g) == true) goto L48;
            r5 = r5 + 1;     // Catch: Exception -> L72
        L48:
            if (r5 < 0) goto L65;
            ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));     // Catch: Exception -> L72
            Iterator r8 = r3.iterator();     // Catch: Exception -> L72
            int r9 = 0;
        L51:
            if (r8.hasNext() == false) goto L64;
            Object r10 = r8.next();     // Catch: Exception -> L72
            int r11 = r9 + 1;     // Catch: Exception -> L72
            if (r9 >= 0) goto L55;
            CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L72
        L55:
            e0 r12 = (e0) r10;     // Catch: Exception -> L72
            if (r12.g == false) goto L59;
            e0 r13 = e0.a(r12, null, null, false, false, 239);     // Catch: Exception -> L72
        L63:
            r112.add(r13);     // Catch: Exception -> L72
            r9 = r11;
            goto L51
        L59:
            if (r9 != r5) goto L61;
            boolean r14 = true;
        L62:
            r13 = e0.a(r12, null, null, r14, false, 239);     // Catch: Exception -> L72
            goto L63
        L61:
            r14 = false;
            goto L62
        L64:
            r3 = r112;
            goto L65
        L47:
            r5 = -1;
        L65:
            DiaryStyleViewModel.access$get_styles$p(this.this$0).setValue(r3);     // Catch: Exception -> L72
            this.$onResult.invoke(Boxing.boxBoolean(true));     // Catch: Exception -> L72
            FLogger.a.i(DiaryStyleViewModel.access$getTAG$p(this.this$0), "deleteStyle success: " + this.$styleInfo + ".id");     // Catch: Exception -> L72
        L75:
            return Unit.INSTANCE;
        L36:
            if (r19.e == false) goto L38;
            r110 = true;
            goto L39
        L20:
            return Unit.INSTANCE;
        L66:
            this.$onResult.invoke(Boxing.boxBoolean(false));     // Catch: Exception -> L72
            FLogger.a.e(DiaryStyleViewModel.access$getTAG$p(this.this$0), "deleteStyle failed: code=" + r16.a.getCode() + ", msg=" + r16.a.getMsg());     // Catch: Exception -> L72
            goto L75
        L68:
            if ((r16 instanceof dm9.a.a) == false) goto L71;
            this.$onResult.invoke(Boxing.boxBoolean(false));     // Catch: Exception -> L72
            FLogger.a.e(DiaryStyleViewModel.access$getTAG$p(this.this$0), "deleteStyle error: " + ((dm9.a.a) r16).b);     // Catch: Exception -> L72
            goto L75
        L71:
            throw new NoWhenBranchMatchedException();     // Catch: Exception -> L72
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r15);
            DoraEnvObserveDiaryStyleApi.a r113 = DoraEnvObserveDiaryStyleApi.a;     // Catch: Exception -> L72
            DiaryStyleViewModel$deleteStyle$1$result$1 r20 = new DiaryStyleViewModel$deleteStyle$1$result$1(this.this$0, this.$styleInfo, null);     // Catch: Exception -> L72
            this.label = 1;     // Catch: Exception -> L72
            r113.getClass();     // Catch: Exception -> L72
            r15 = DoraEnvObserveDiaryStyleApi.a.a(r20, this);     // Catch: Exception -> L72
            if (r15 != r1) goto L13;
            return r1;
        L72:
            e = move-exception;
            this.$onResult.invoke(Boxing.boxBoolean(false));
            FLogger.a.e(DiaryStyleViewModel.access$getTAG$p(this.this$0), "deleteStyle error: " + e.getMessage(), e);
            goto L75
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.style.DiaryStyleViewModel$loadStyles$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.diary.style.DiaryStyleViewModel$loadStyles$1", f = "DiaryStyleViewModel.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DiaryStyleViewModel this$0;

        public C01061(DiaryStyleViewModel r1, Continuation<? super C01061> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01061(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L35 Exception -> L37
        L13:
            dm9.a.b r9 = (dm9.a) r8;     // Catch: Throwable -> L35 Exception -> L37
            if ((r9 instanceof dm9.a.b) == false) goto L31;
            m98.c r10 = (m98.c) r9.a.getData();     // Catch: Throwable -> L35 Exception -> L37
            if (r10 == null) goto L19;
            List<m98.b> r2 = r10.b();     // Catch: Throwable -> L35 Exception -> L37
            if (r2 == null) goto L19;
        L20:
            MutableLiveData r3 = DiaryStyleViewModel.access$get_maxCount$p(this.this$0);     // Catch: Throwable -> L35 Exception -> L37
            if (r10 == null) goto L24;
            Integer r11 = r10.a();     // Catch: Throwable -> L35 Exception -> L37
            if (r11 == null) goto L24;
        L25:
            r3.setValue(r11);     // Catch: Throwable -> L35 Exception -> L37
            List r12 = CollectionsKt.filterNotNull(r2);     // Catch: Throwable -> L35 Exception -> L37
            DiaryStyleViewModel r4 = this.this$0;     // Catch: Throwable -> L35 Exception -> L37
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));     // Catch: Throwable -> L35 Exception -> L37
            Iterator r13 = r12.iterator();     // Catch: Throwable -> L35 Exception -> L37
        L27:
            if (r13.hasNext() == false) goto L29;
            r5.add(DiaryStyleViewModel.access$mapStyleInfoToItem(r4, (m98.b) r13.next()));     // Catch: Throwable -> L35 Exception -> L37
            goto L27
        L29:
            List r14 = CollectionsKt.toMutableList(r5);     // Catch: Throwable -> L35 Exception -> L37
            r14.add(DiaryStyleViewModel.access$createAddButtonItem(this.this$0));     // Catch: Throwable -> L35 Exception -> L37
            DiaryStyleViewModel.access$get_styles$p(this.this$0).setValue(r14);     // Catch: Throwable -> L35 Exception -> L37
            FLogger.a.i(DiaryStyleViewModel.access$getTAG$p(this.this$0), "loadStyles success: " + r14.size() + " styles");     // Catch: Throwable -> L35 Exception -> L37
        L39:
            DiaryStyleViewModel.access$get_isLoading$p(this.this$0).setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L24:
            r11 = Boxing.boxInt(DiaryStyleViewModel.access$getDefaultMaxCount$p(this.this$0));     // Catch: Throwable -> L35 Exception -> L37
        L19:
            r2 = CollectionsKt.emptyList();     // Catch: Throwable -> L35 Exception -> L37
            goto L20
        L31:
            if ((r9 instanceof dm9.a.a) == false) goto L34;
            FLogger.a.e(DiaryStyleViewModel.access$getTAG$p(this.this$0), "loadStyles error: " + ((dm9.a.a) r9).b);     // Catch: Throwable -> L35 Exception -> L37
            DiaryStyleViewModel.access$get_styles$p(this.this$0).setValue(CollectionsKt.listOf(DiaryStyleViewModel.access$createAddButtonItem(this.this$0)));     // Catch: Throwable -> L35 Exception -> L37
            goto L39
        L34:
            throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L35 Exception -> L37
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r8);
            DiaryStyleViewModel.access$get_isLoading$p(this.this$0).setValue(Boxing.boxBoolean(true));
            DoraEnvObserveDiaryStyleApi.a r15 = DoraEnvObserveDiaryStyleApi.a;     // Catch: Throwable -> L35 Exception -> L37
            DiaryStyleViewModel$loadStyles$1$result$1 r6 = new DiaryStyleViewModel$loadStyles$1$result$1(this.this$0, null);     // Catch: Throwable -> L35 Exception -> L37
            this.label = 1;     // Catch: Throwable -> L35 Exception -> L37
            r15.getClass();     // Catch: Throwable -> L35 Exception -> L37
            r8 = DoraEnvObserveDiaryStyleApi.a.a(r6, this);     // Catch: Throwable -> L35 Exception -> L37
            if (r8 != r0) goto L13;
            return r0;
        L37:
            e = move-exception;
            FLogger.a.e(DiaryStyleViewModel.access$getTAG$p(this.this$0), "loadStyles error: " + e.getMessage(), e);     // Catch: Throwable -> L35
            DiaryStyleViewModel.access$get_styles$p(this.this$0).setValue(CollectionsKt.listOf(DiaryStyleViewModel.access$createAddButtonItem(this.this$0)));     // Catch: Throwable -> L35
        L35:
            th = move-exception;
            DiaryStyleViewModel.access$get_isLoading$p(this.this$0).setValue(Boxing.boxBoolean(false));
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.style.DiaryStyleViewModel$refresh$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.diary.style.DiaryStyleViewModel$refresh$1", f = "DiaryStyleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DiaryStyleViewModel this$0;

        public C01071(DiaryStyleViewModel r1, Continuation<? super C01071> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01071(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r3);
            DiaryStyleViewModel.access$get_isRefreshing$p(this.this$0).setValue(Boxing.boxBoolean(true));
            this.this$0.loadStyles();     // Catch: Throwable -> L8
            DiaryStyleViewModel.access$get_isRefreshing$p(this.this$0).setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L8:
            th = move-exception;
            DiaryStyleViewModel.access$get_isRefreshing$p(this.this$0).setValue(Boxing.boxBoolean(false));
            throw th;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.style.DiaryStyleViewModel$selectStyle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.diary.style.DiaryStyleViewModel$selectStyle$1", f = "DiaryStyleViewModel.kt", i = {0}, l = {197}, m = "invokeSuspend", n = {"currentList"}, s = {"L$0"})
    public static final class C01081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $styleId;
        Object L$0;
        int label;
        final /* synthetic */ DiaryStyleViewModel this$0;

        public C01081(DiaryStyleViewModel r1, String r2, Continuation<? super C01081> r3) {
            this.this$0 = r1;
            this.$styleId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01081(this.this$0, this.$styleId, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 != 1) goto L9;
            List r2 = (List) this.L$0;
            ResultKt.throwOnFailure(r11);     // Catch: Exception -> L45
        L30:
            dm9.a.b r12 = (dm9.a) r11;     // Catch: Exception -> L45
            if ((r12 instanceof dm9.a.b) == false) goto L41;
            if (r12.a.getCode() != 0) goto L39;
            List r3 = r2;     // Catch: Exception -> L45
            String r13 = this.$styleId;     // Catch: Exception -> L45
            ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));     // Catch: Exception -> L45
            Iterator r5 = r3.iterator();     // Catch: Exception -> L45
        L36:
            if (r5.hasNext() == false) goto L38;
            e0 r6 = (e0) r5.next();     // Catch: Exception -> L45
            r4.add(e0.a(r6, null, null, Intrinsics.areEqual(r6.a, r13), false, 239));     // Catch: Exception -> L45
            goto L36
        L38:
            DiaryStyleViewModel.access$get_styles$p(this.this$0).setValue(r4);     // Catch: Exception -> L45
            FLogger.a.i(DiaryStyleViewModel.access$getTAG$p(this.this$0), "selectStyle success: " + this.$styleId);     // Catch: Exception -> L45
        L48:
            return Unit.INSTANCE;
        L39:
            FLogger.a.e(DiaryStyleViewModel.access$getTAG$p(this.this$0), "selectStyle failed: code=" + r12.a.getCode() + ", msg=" + r12.a.getMsg());     // Catch: Exception -> L45
            goto L48
        L41:
            if ((r12 instanceof dm9.a.a) == false) goto L44;
            FLogger.a.e(DiaryStyleViewModel.access$getTAG$p(this.this$0), "selectStyle error: " + ((dm9.a.a) r12).b);     // Catch: Exception -> L45
            goto L48
        L44:
            throw new NoWhenBranchMatchedException();     // Catch: Exception -> L45
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r11);
            List r14 = (List) DiaryStyleViewModel.access$get_styles$p(this.this$0).getValue();     // Catch: Exception -> L45
            if (r14 == null) goto L14;
            String r7 = this.$styleId;     // Catch: Exception -> L45
            Iterator r8 = r14.iterator();     // Catch: Exception -> L45
        L17:
            if (r8.hasNext() == false) goto L21;
            Object r9 = r8.next();     // Catch: Exception -> L45
            if (Intrinsics.areEqual(((e0) r9).a, r7) == false) goto L17;
        L22:
            e0 r10 = (e0) r9;     // Catch: Exception -> L45
            if (r10 == null) goto L25;
            DoraEnvObserveDiaryStyleApi.a r15 = DoraEnvObserveDiaryStyleApi.a;     // Catch: Exception -> L45
            DiaryStyleViewModel$selectStyle$1$result$1 r16 = new DiaryStyleViewModel$selectStyle$1$result$1(this.this$0, r10, null);     // Catch: Exception -> L45
            this.L$0 = r14;     // Catch: Exception -> L45
            this.label = 1;     // Catch: Exception -> L45
            r15.getClass();     // Catch: Exception -> L45
            Object r17 = DoraEnvObserveDiaryStyleApi.a.a(r16, this);     // Catch: Exception -> L45
            if (r17 != r0) goto L29;
            return r0;
        L29:
            r2 = r14;
            r11 = r17;
            goto L30
        L25:
            return Unit.INSTANCE;
        L21:
            r9 = null;
            goto L22
        L14:
            return Unit.INSTANCE;
        L45:
            e = move-exception;
            FLogger.a.e(DiaryStyleViewModel.access$getTAG$p(this.this$0), "selectStyle error: " + e.getMessage(), e);
            goto L48
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.style.DiaryStyleViewModel$updateCustomStyle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.diary.style.DiaryStyleViewModel$updateCustomStyle$1", f = "DiaryStyleViewModel.kt", i = {0, 0}, l = {377}, m = "invokeSuspend", n = {"currentList", "resolvedName"}, s = {"L$0", "L$1"})
    public static final class C01091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $name;
        final /* synthetic */ Function2<e0, Long, Unit> $onResult;
        final /* synthetic */ String $prompt;
        final /* synthetic */ String $styleId;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ DiaryStyleViewModel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C01091(DiaryStyleViewModel r1, String r2, String r3, String r4, Function2<? super e0, ? super Long, Unit> r5, Continuation<? super C01091> r6) {
            this.this$0 = r1;
            this.$name = r2;
            this.$styleId = r3;
            this.$prompt = r4;
            this.$onResult = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            C01091 r7 = new C01091(this.this$0, this.$name, this.$styleId, this.$prompt, this.$onResult, r10);
            r7.L$0 = r9;
            return r7;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r19) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L10;
            if (r2 != 1) goto L9;
            String r1 = (String) this.L$1;
            List r3 = (List) this.L$0;
            ResultKt.throwOnFailure(r19);     // Catch: Exception -> L60
            Object r4 = r19;
            String r8 = r1;
        L29:
            dm9.a.b r5 = (dm9.a) r4;     // Catch: Exception -> L60
            if ((r5 instanceof dm9.a.b) == false) goto L56;
            if (r5.a.getCode() != 0) goto L54;
            FLogger r6 = FLogger.a;     // Catch: Exception -> L60
            r6.i(DiaryStyleViewModel.access$getTAG$p(this.this$0), "updateCustomStyle success: " + this.$styleId);     // Catch: Exception -> L60
            m98.g r7 = (m98.g) r5.a.getData();     // Catch: Exception -> L60
            if (r7 == null) goto L36;
            m98.b r9 = r7.a();     // Catch: Exception -> L60
        L37:
            if (r9 == null) goto L41;
            e0 r10 = DiaryStyleViewModel.access$mapStyleInfoToItem(this.this$0, r9);     // Catch: Exception -> L60
            if (r10 == null) goto L41;
            e0 r11 = e0.a(r10, r8, this.$prompt, true, true, DoraCallStateCode.DORA_NEW_USER_GUIDE);     // Catch: Exception -> L60
        L42:
            if (r11 != null) goto L45;
            this.$onResult.invoke(null, Boxing.boxLong(0));     // Catch: Exception -> L60
            r6.e(DiaryStyleViewModel.access$getTAG$p(this.this$0), "updateCustomStyle failed: updatedItem is null");     // Catch: Exception -> L60
            return Unit.INSTANCE;
        L45:
            this.$onResult.invoke(r11, Boxing.boxLong(0));     // Catch: Exception -> L60
            List r12 = r3;     // Catch: Exception -> L60
            String r13 = this.$styleId;     // Catch: Exception -> L60
            ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));     // Catch: Exception -> L60
            Iterator r15 = r12.iterator();     // Catch: Exception -> L60
        L47:
            if (r15.hasNext() == false) goto L53;
            e0 r16 = (e0) r15.next();     // Catch: Exception -> L60
            if (Intrinsics.areEqual(r16.a, r13) == false) goto L51;
            e0 r17 = r11;
        L52:
            r14.add(r17);     // Catch: Exception -> L60
            goto L47
        L51:
            r17 = e0.a(r16, null, null, false, false, 239);     // Catch: Exception -> L60
            goto L52
        L53:
            DiaryStyleViewModel.access$get_styles$p(this.this$0).setValue(r14);     // Catch: Exception -> L60
        L63:
            return Unit.INSTANCE;
        L41:
            r11 = null;
            goto L42
        L36:
            r9 = null;
            goto L37
        L54:
            this.$onResult.invoke(null, Boxing.boxLong(r5.a.getCode()));     // Catch: Exception -> L60
            FLogger.a.e(DiaryStyleViewModel.access$getTAG$p(this.this$0), "updateCustomStyle failed: code=" + r5.a.getCode() + ", msg=" + r5.a.getMsg());     // Catch: Exception -> L60
            goto L63
        L56:
            if ((r5 instanceof dm9.a.a) == false) goto L59;
            this.$onResult.invoke(null, Boxing.boxLong(0));     // Catch: Exception -> L60
            FLogger.a.e(DiaryStyleViewModel.access$getTAG$p(this.this$0), "updateCustomStyle error: " + ((dm9.a.a) r5).b);     // Catch: Exception -> L60
            goto L63
        L59:
            throw new NoWhenBranchMatchedException();     // Catch: Exception -> L60
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r19);
            CoroutineScope r18 = (CoroutineScope) this.L$0;
            r3 = (List) DiaryStyleViewModel.access$get_styles$p(this.this$0).getValue();     // Catch: Exception -> L60
            if (r3 != null) goto L15;
            this.$onResult.invoke(null, Boxing.boxLong(0));     // Catch: Exception -> L60
            return Unit.INSTANCE;
        L15:
            r8 = DiaryStyleViewModel.access$resolveStyleName(this.this$0, this.$name);     // Catch: Exception -> L60
            String r110 = this.$styleId;     // Catch: Exception -> L60
            Iterator r20 = r3.iterator();     // Catch: Exception -> L60
        L17:
            if (r20.hasNext() == false) goto L21;
            Object r111 = r20.next();     // Catch: Exception -> L60
            if (Intrinsics.areEqual(((e0) r111).a, r110) == false) goto L17;
        L22:
            e0 r112 = (e0) r111;     // Catch: Exception -> L60
            if (r112 != null) goto L26;
            this.$onResult.invoke(null, Boxing.boxLong(0));     // Catch: Exception -> L60
            return Unit.INSTANCE;
        L26:
            DoraEnvObserveDiaryStyleApi.a r21 = DoraEnvObserveDiaryStyleApi.a;     // Catch: Exception -> L60
            DiaryStyleViewModel$updateCustomStyle$1$result$1 r113 = new DiaryStyleViewModel$updateCustomStyle$1$result$1(this.this$0, this.$prompt, r8, this.$styleId, r112, null);     // Catch: Exception -> L60
            this.L$0 = r3;     // Catch: Exception -> L60
            this.L$1 = r8;     // Catch: Exception -> L60
            this.label = 1;     // Catch: Exception -> L60
            r21.getClass();     // Catch: Exception -> L60
            r4 = DoraEnvObserveDiaryStyleApi.a.a(r113, this);     // Catch: Exception -> L60
            if (r4 != r0) goto L29;
            return r0;
        L21:
            r111 = null;
        L60:
            e = move-exception;
            this.$onResult.invoke(null, Boxing.boxLong(0));
            FLogger.a.e(DiaryStyleViewModel.access$getTAG$p(this.this$0), "updateCustomStyle error: " + e.getMessage(), e);
            goto L63
        }
    }

    public static /* synthetic */ boolean Mo(e0 r0) {
        return resolveStyleName$lambda$3(r0);
    }

    public static /* synthetic */ Integer No(DiaryStyleViewModel r0, e0 r1) {
        return resolveStyleName$lambda$4(r0, r1);
    }

    public static /* synthetic */ Unit Oo(MediatorLiveData r0, DiaryStyleViewModel r1, List r2) {
        return _styleListData$lambda$2$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ Unit yo(MediatorLiveData r0, DiaryStyleViewModel r1, Integer r2) {
        return _styleListData$lambda$2$lambda$1(r0, r1, r2);
    }

    private final e0 createAddButtonItem() {
        return new e0("add_button", "", "", null, false, false, true, DoraCallStateCode.ENV_OBSERVE_USER_TIMER_END);
    }

    private final int getDoraSubBiz() {
        FlowDoraSubBizType.a r0 = FlowDoraSubBizType.Companion;
        Integer r1 = this.productId;
        r0.getClass();
        return FlowDoraSubBizType.a.b(r1);
    }

    public final void clearAddStyleDraft() {
        this._addStyleDraft.setValue(null);
    }

    public DiaryStyleViewModel() {
        this.TAG = "DiaryStyleViewModel";
        this.defaultCustomStyleNameRegex = new Regex("^自定义风格 (\\d+)$");
        this.defaultMaxCount = 30;
        MutableLiveData<List<e0>> r1 = new MutableLiveData();
        this._styles = r1;
        MutableLiveData<Integer> r2 = new MutableLiveData(30);
        this._maxCount = r2;
        final MediatorLiveData<f0> r3 = new MediatorLiveData();
        r3.setValue(new f0(CollectionsKt.emptyList(), 30));
        r3.addSource(r1, new b(new g0(r3, this)));
        r3.addSource(r2, new b(new h0(r3, this)));
        this._styleListData = r3;
        this.styleListData = r3;
        Boolean r4 = Boolean.FALSE;
        MutableLiveData<Boolean> r0 = new MutableLiveData(r4);
        this._isRefreshing = r0;
        this.isRefreshing = r0;
        MutableLiveData<Boolean> r5 = new MutableLiveData(r4);
        this._isLoading = r5;
        this.isLoading = r5;
        MutableLiveData<Long> r6 = new MutableLiveData();
        this._scrollToBottom = r6;
        this.scrollToBottom = r6;
        MutableLiveData<a> r7 = new MutableLiveData(null);
        this._addStyleDraft = r7;
        this.addStyleDraft = r7;
    }

    public final void loadStyles() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01061(this, null), 3, null);
    }

    public final void refresh() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01071(this, null), 3, null);
    }

    public final LiveData<a> getAddStyleDraft() {
        return this.addStyleDraft;
    }

    public final LiveData<Long> getScrollToBottom() {
        return this.scrollToBottom;
    }

    public final LiveData<f0> getStyleListData() {
        return this.styleListData;
    }

    public final LiveData<Boolean> isLoading() {
        return this.isLoading;
    }

    public final LiveData<Boolean> isRefreshing() {
        return this.isRefreshing;
    }

    public static final /* synthetic */ e0 access$createAddButtonItem(DiaryStyleViewModel r0) {
        return r0.createAddButtonItem();
    }

    public static final /* synthetic */ int access$getDefaultMaxCount$p(DiaryStyleViewModel r0) {
        return r0.defaultMaxCount;
    }

    public static final /* synthetic */ int access$getDoraSubBiz(DiaryStyleViewModel r0) {
        return r0.getDoraSubBiz();
    }

    public static final /* synthetic */ String access$getTAG$p(DiaryStyleViewModel r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ MutableLiveData access$get_isLoading$p(DiaryStyleViewModel r0) {
        return r0._isLoading;
    }

    public static final /* synthetic */ MutableLiveData access$get_isRefreshing$p(DiaryStyleViewModel r0) {
        return r0._isRefreshing;
    }

    public static final /* synthetic */ MutableLiveData access$get_maxCount$p(DiaryStyleViewModel r0) {
        return r0._maxCount;
    }

    public static final /* synthetic */ MutableLiveData access$get_scrollToBottom$p(DiaryStyleViewModel r0) {
        return r0._scrollToBottom;
    }

    public static final /* synthetic */ MutableLiveData access$get_styles$p(DiaryStyleViewModel r0) {
        return r0._styles;
    }

    private final e0 mapStyleInfoToItem(m98.b r11) {
        String r0 = r11.b();
        if (r0 != null) goto L5;
        String r2 = "";
    L6:
        String r1 = r11.d();
        if (r1 != null) goto L9;
        String r3 = "";
    L10:
        String r4 = r11.e();
        if (r4 != null) goto L13;
        String r5 = "";
    L14:
        String r6 = r11.a();
        boolean r7 = Intrinsics.areEqual(r11.f(), Boolean.TRUE);
        Integer r12 = r11.c();
        if (r12 != null) goto L18;
    L20:
        boolean r13 = false;
    L22:
        return new e0(r2, r3, r5, r6, r7, r13, false, 192);
    L18:
        if (r12.intValue() != 1) goto L20;
        r13 = true;
        goto L22
    L13:
        r5 = r4;
        goto L14
    L9:
        r3 = r1;
        goto L10
    L5:
        r2 = r0;
        goto L6
    }

    private final String resolveStyleName(String r3) {
        if ((!StringsKt.isBlank(r3)) == false) goto L5;
        return r3;
    L5:
        List r4 = (List) this._styles.getValue();
        if (r4 != null) goto L8;
        r4 = CollectionsKt.emptyList();
    L8:
        Integer r5 = (Integer) SequencesKt.maxOrNull(SequencesKt.mapNotNull(SequencesKt.filterNot(CollectionsKt.asSequence(r4), new i0()), new j0(this)));
        if (r5 == null) goto L11;
        int r6 = r5.intValue();
    L13:
        return "自定义风格 " + (r6 + 1);
    L11:
        r6 = 0;
        goto L13
    }

    private static final boolean resolveStyleName$lambda$3(e0 r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return r1.g;
    }

    public final void selectStyle(String r8) {
        Intrinsics.checkNotNullParameter(r8, "styleId");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01081(this, r8, null), 3, null);
    }

    public final void setProductId(Integer r2) {
        if (Intrinsics.areEqual(this.productId, r2) == false) goto L13;
        Collection r0 = (Collection) this._styles.getValue();
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        return;
    L7:
        if (r0.isEmpty() == true) goto L10;
        r1 = false;
    L13:
        this.productId = r2;
        loadStyles();
    }

    public static final /* synthetic */ e0 access$mapStyleInfoToItem(DiaryStyleViewModel r0, m98.b r1) {
        return r0.mapStyleInfoToItem(r1);
    }

    public static final /* synthetic */ String access$resolveStyleName(DiaryStyleViewModel r0, String r1) {
        return r0.resolveStyleName(r1);
    }

    private static final Integer resolveStyleName$lambda$4(DiaryStyleViewModel r1, e0 r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        MatchResult r3 = r1.defaultCustomStyleNameRegex.matchEntire(StringsKt.trim(r2.b).toString());
        if (r3 == null) goto L9;
        List r4 = r3.getGroupValues();
        if (r4 == null) goto L9;
        String r5 = (String) CollectionsKt.getOrNull(r4, 1);
        if (r5 == null) goto L9;
        return StringsKt.toIntOrNull(r5);
    L9:
        return null;
    }

    public final void deleteStyle(e0 r8, Function1<? super Boolean, Unit> r9) {
        Intrinsics.checkNotNullParameter(r8, "styleInfo");
        Intrinsics.checkNotNullParameter(r9, "onResult");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01051(this, r8, r9, null), 3, null);
    }

    public final void updateAddStyleDraft(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "prompt");
        this._addStyleDraft.setValue(new a(r3, r4));
    }

    private static final Unit _styleListData$lambda$2$lambda$0(MediatorLiveData r2, DiaryStyleViewModel r3, List r4) {
        if (r4 != null) goto L5;
        r4 = CollectionsKt.emptyList();
    L5:
        Integer r1 = (Integer) r3._maxCount.getValue();
        if (r1 == null) goto L8;
        int r5 = r1.intValue();
    L9:
        r2.setValue(new f0(r4, r5));
        return Unit.INSTANCE;
    L8:
        r5 = r3.defaultMaxCount;
        goto L9
    }

    private static final Unit _styleListData$lambda$2$lambda$1(MediatorLiveData r2, DiaryStyleViewModel r3, Integer r4) {
        List r1 = (List) r3._styles.getValue();
        if (r1 != null) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        if (r4 == null) goto L7;
        int r5 = r4.intValue();
    L8:
        r2.setValue(new f0(r1, r5));
        return Unit.INSTANCE;
    L7:
        r5 = r3.defaultMaxCount;
        goto L8
    }

    public final void addCustomStyle(String r12, String r13, String r14, Function2<? super e0, ? super Long, Unit> r15) {
        Intrinsics.checkNotNullParameter(r12, "name");
        Intrinsics.checkNotNullParameter(r13, "prompt");
        Intrinsics.checkNotNullParameter(r14, "requestId");
        Intrinsics.checkNotNullParameter(r15, "onResult");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r12, r15, r13, r14, null), 3, null);
    }

    public final void updateCustomStyle(String r12, String r13, String r14, Function2<? super e0, ? super Long, Unit> r15) {
        Intrinsics.checkNotNullParameter(r12, "styleId");
        Intrinsics.checkNotNullParameter(r13, "name");
        Intrinsics.checkNotNullParameter(r14, "prompt");
        Intrinsics.checkNotNullParameter(r15, "onResult");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01091(this, r13, r12, r14, r15, null), 3, null);
    }
}
