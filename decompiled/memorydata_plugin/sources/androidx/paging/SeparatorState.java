package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.ss.bduploader.BDNetworkSpeedTest;
import com.ss.bduploader.UploadKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u0002H\u00012\u00020\u0002B^\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012L\u0010\u0006\u001aH\b\u0001\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;2\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00010;J%\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000>2\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00010>H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010?J%\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000A2\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00010AH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010BJ%\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000>2\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00010DH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010EJ%\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000>2\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00010GH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010HJ&\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00030%\"\b\b\u0002\u0010\u0003*\u00020\u00022\f\u0010J\u001a\b\u0012\u0004\u0012\u0002H\u00030%H\u0002J\u0016\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000A*\b\u0012\u0004\u0012\u00028\u00010AJ\"\u0010L\u001a\u00020\u000f\"\b\b\u0002\u0010\u0003*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00030A2\u0006\u0010\u0004\u001a\u00020\u0005J\"\u0010M\u001a\u00020\u000f\"\b\b\u0002\u0010\u0003*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00030A2\u0006\u0010\u0004\u001a\u00020\u0005R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\\\u0010\u0006\u001aH\b\u0001\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010%0$¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\u0011\u00101\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0011\"\u0004\b7\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u00109\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006N"}, d2 = {"Landroidx/paging/SeparatorState;", "R", "", ExifInterface.GPS_DIRECTION_TRUE, "terminalSeparatorType", "Landroidx/paging/TerminalSeparatorType;", "generator", "Lkotlin/Function3;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "before", "after", "Lkotlin/coroutines/Continuation;", "(Landroidx/paging/TerminalSeparatorType;Lkotlin/jvm/functions/Function3;)V", "endTerminalSeparatorDeferred", "", "getEndTerminalSeparatorDeferred", "()Z", "setEndTerminalSeparatorDeferred", "(Z)V", "footerAdded", "getFooterAdded", "setFooterAdded", "getGenerator", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "headerAdded", "getHeaderAdded", "setHeaderAdded", "mediatorStates", "Landroidx/paging/LoadStates;", "getMediatorStates", "()Landroidx/paging/LoadStates;", "setMediatorStates", "(Landroidx/paging/LoadStates;)V", "pageStash", "", "Landroidx/paging/TransformablePage;", "getPageStash", "()Ljava/util/List;", "placeholdersAfter", "", "getPlaceholdersAfter", "()I", "setPlaceholdersAfter", "(I)V", "placeholdersBefore", "getPlaceholdersBefore", "setPlaceholdersBefore", "sourceStates", "Landroidx/paging/MutableLoadStateCollection;", "getSourceStates", "()Landroidx/paging/MutableLoadStateCollection;", "startTerminalSeparatorDeferred", "getStartTerminalSeparatorDeferred", "setStartTerminalSeparatorDeferred", "getTerminalSeparatorType", "()Landroidx/paging/TerminalSeparatorType;", "onDrop", "Landroidx/paging/PageEvent$Drop;", "event", "onEvent", "Landroidx/paging/PageEvent;", "(Landroidx/paging/PageEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onInsert", "Landroidx/paging/PageEvent$Insert;", "(Landroidx/paging/PageEvent$Insert;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onLoadStateUpdate", "Landroidx/paging/PageEvent$LoadStateUpdate;", "(Landroidx/paging/PageEvent$LoadStateUpdate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onStaticList", "Landroidx/paging/PageEvent$StaticList;", "(Landroidx/paging/PageEvent$StaticList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformablePageToStash", "originalPage", "asRType", "terminatesEnd", "terminatesStart", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SeparatorState<R, T extends R> {
    private boolean endTerminalSeparatorDeferred;
    private boolean footerAdded;
    private final Function3<T, T, Continuation<? super R>, Object> generator;
    private boolean headerAdded;
    private LoadStates mediatorStates;
    private final List<TransformablePage<T>> pageStash;
    private int placeholdersAfter;
    private int placeholdersBefore;
    private final MutableLoadStateCollection sourceStates;
    private boolean startTerminalSeparatorDeferred;
    private final TerminalSeparatorType terminalSeparatorType;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[TerminalSeparatorType.values().length];
            r0[TerminalSeparatorType.FULLY_COMPLETE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[TerminalSeparatorType.SOURCE_COMPLETE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.SeparatorState$onEvent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.SeparatorState", f = "Separators.kt", i = {0, 1, 2}, l = {Constants.UPLOAD_DISASTER_ESCAPE, 216, 217}, m = "onEvent", n = {"this", "this", "this"}, s = {"L$0", "L$0", "L$0"})
    static final class C09661 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeparatorState<R, T> this$0;

        C09661(SeparatorState<R, T> r3, Continuation<? super C09661> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.onEvent(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: androidx.paging.SeparatorState$onInsert$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.SeparatorState", f = "Separators.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9}, l = {307, 370, 382, 388, 400, 409, BDNetworkSpeedTest.KeyIsEnableIntelligentSpeedTest, UploadKeys.KeyIsEnd2EndEncryptionPublicKey, 453, 464}, m = "onInsert", n = {"this", "event", "this", "event", "outList", "stashOutList", "firstNonEmptyPage", "firstNonEmptyPageIndex", "lastNonEmptyPage", "lastNonEmptyPageIndex", "pageAfter", "eventTerminatesEnd", "eventEmpty", "this", "event", "outList", "stashOutList", "firstNonEmptyPage", "firstNonEmptyPageIndex", "lastNonEmptyPage", "lastNonEmptyPageIndex", "eventTerminatesEnd", "eventEmpty", "pageIndex", "this", "event", "outList", "stashOutList", "firstNonEmptyPage", "firstNonEmptyPageIndex", "lastNonEmptyPage", "lastNonEmptyPageIndex", "lastStash", "eventTerminatesEnd", "eventEmpty", "this", "event", "outList", "stashOutList", "firstNonEmptyPageIndex", "lastNonEmptyPage", "lastNonEmptyPageIndex", "eventTerminatesEnd", "eventEmpty", "this", "event", "outList", "stashOutList", "lastNonEmptyPage", "lastNonEmptyPageIndex", "iterator$iv", "page", "pageBefore", "eventTerminatesEnd", "eventEmpty", "this", "event", "outList", "stashOutList", "lastNonEmptyPage", "lastNonEmptyPageIndex", "iterator$iv", "page", "pageBefore", "eventTerminatesEnd", "eventEmpty", "this", "event", "outList", "stashOutList", "lastNonEmptyPage", "lastNonEmptyPageIndex", "pageAfter", "eventTerminatesEnd", "eventEmpty", "this", "event", "outList", "stashOutList", "lastNonEmptyPage", "eventTerminatesEnd", "eventEmpty", "pageIndex", "this", "event", "outList", "stashOutList", "pageBefore"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class C09671 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeparatorState<R, T> this$0;

        C09671(SeparatorState<R, T> r3, Continuation<? super C09671> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.onInsert(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: androidx.paging.SeparatorState$onStaticList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.SeparatorState", f = "Separators.kt", i = {0, 0, 0, 0, 0}, l = {564}, m = "onStaticList", n = {"this", "event", "data", "item", "i"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
    static final class C09681 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeparatorState<R, T> this$0;

        C09681(SeparatorState<R, T> r3, Continuation<? super C09681> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.onStaticList(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    public SeparatorState(TerminalSeparatorType r3, Function3<? super T, ? super T, ? super Continuation<? super R>, ? extends Object> r4) {
        Function3<T, T, Continuation<? super R>, Object> r5 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "terminalSeparatorType");
        Intrinsics.checkNotNullParameter(r5, "generator");
        this.terminalSeparatorType = r3;
        this.generator = r5;
        this.pageStash = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.sourceStates = new MutableLoadStateCollection();
    }

    private final <T> TransformablePage<T> transformablePageToStash(TransformablePage<T> r10) {
        int[] r0 = r10.getOriginalPageOffsets();
        List r2 = CollectionsKt.listOf(new Object[]{CollectionsKt.first(r10.getData()), CollectionsKt.last(r10.getData())});
        int r3 = r10.getHintOriginalPageOffset();
        Integer[] r1 = new Integer[2];
        List<Integer> r6 = r10.getHintOriginalIndices();
        if (r6 == null) goto L5;
        int r7 = ((Number) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r6), Number.class, "com.obric.memorydata.plugin")).intValue();
    L6:
        r1[0] = Integer.valueOf(r7);
        List<Integer> r4 = r10.getHintOriginalIndices();
        if (r4 == null) goto L9;
        int r11 = ((Number) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r4), Number.class, "com.obric.memorydata.plugin")).intValue();
    L10:
        r1[1] = Integer.valueOf(r11);
        return new TransformablePage(r0, r2, r3, CollectionsKt.listOf(r1));
    L9:
        r11 = CollectionsKt.getLastIndex(r10.getData());
        goto L10
    L5:
        r7 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PageEvent.Insert<R> asRType(PageEvent.Insert<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1;
    }

    public final boolean getEndTerminalSeparatorDeferred() {
        return this.endTerminalSeparatorDeferred;
    }

    public final boolean getFooterAdded() {
        return this.footerAdded;
    }

    public final Function3<T, T, Continuation<? super R>, Object> getGenerator() {
        return this.generator;
    }

    public final boolean getHeaderAdded() {
        return this.headerAdded;
    }

    public final LoadStates getMediatorStates() {
        return this.mediatorStates;
    }

    public final List<TransformablePage<T>> getPageStash() {
        return this.pageStash;
    }

    public final int getPlaceholdersAfter() {
        return this.placeholdersAfter;
    }

    public final int getPlaceholdersBefore() {
        return this.placeholdersBefore;
    }

    public final MutableLoadStateCollection getSourceStates() {
        return this.sourceStates;
    }

    public final boolean getStartTerminalSeparatorDeferred() {
        return this.startTerminalSeparatorDeferred;
    }

    public final TerminalSeparatorType getTerminalSeparatorType() {
        return this.terminalSeparatorType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PageEvent.Drop<R> onDrop(PageEvent.Drop<T> r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        this.sourceStates.set(r6.getLoadType(), (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin"));
        if (r6.getLoadType() != LoadType.PREPEND) goto L6;
        this.placeholdersBefore = r6.getPlaceholdersRemaining();
        this.headerAdded = false;
    L9:
        if (this.pageStash.isEmpty() == true) goto L11;
    L14:
        final IntRange r0 = new IntRange(r6.getMinPageOffset(), r6.getMaxPageOffset());
        CollectionsKt.removeAll(this.pageStash, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r0), Function1.class, "com.obric.memorydata.plugin"));
        return r6;
    L11:
        if (r6.getLoadType() != LoadType.PREPEND) goto L13;
        this.startTerminalSeparatorDeferred = false;
        goto L14
    L13:
        this.endTerminalSeparatorDeferred = false;
        goto L14
    L6:
        if (r6.getLoadType() != LoadType.APPEND) goto L9;
        this.placeholdersAfter = r6.getPlaceholdersRemaining();
        this.footerAdded = false;
        goto L9
    }

    public final Object onEvent(PageEvent<T> r9, Continuation<? super PageEvent<R>> r10) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, C09661.class) == false) goto L7;
        C09661 r1 = (C09661) ZeusTransformUtils.preCheckCast(r11, C09661.class, "com.obric.memorydata.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L17;
        if (r4 == 1) goto L16;
        if (r4 == 2) goto L16;
        if (r4 == 3) goto L16;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        SeparatorState<R, T> this = (SeparatorState) ZeusTransformUtils.preCheckCast(r1.L$0, SeparatorState.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
    L22:
        Object r13 = ZeusTransformUtils.preCheckCast(r12, PageEvent.class, "com.obric.memorydata.plugin");
    L23:
        PageEvent r14 = (PageEvent) r13;
        if (this.endTerminalSeparatorDeferred == false) goto L45;
        if (this.pageStash.isEmpty() == true) goto L45;
        throw new IllegalStateException("deferred endTerm, page stash should be empty".toString());
    L45:
        if (this.startTerminalSeparatorDeferred == true) goto L47;
    L51:
        return r14;
    L47:
        if (this.pageStash.isEmpty() == true) goto L51;
        throw new IllegalStateException("deferred startTerm, page stash should be empty".toString());
    L17:
        ResultKt.throwOnFailure(r12);
        if (ZeusTransformUtils.instanceOf(r9, PageEvent.Insert.class) == false) goto L25;
        PageEvent.Insert<T> r15 = (PageEvent.Insert) ZeusTransformUtils.preCheckCast(r9, PageEvent.Insert.class, "com.obric.memorydata.plugin");
        r1.L$0 = this;
        r1.label = 1;
        r12 = onInsert(r15, r1);
        if (r12 != r3) goto L22;
        return r3;
    L25:
        if (ZeusTransformUtils.instanceOf(r9, PageEvent.Drop.class) == false) goto L28;
        r13 = ZeusTransformUtils.preCheckCast(onDrop((PageEvent.Drop) ZeusTransformUtils.preCheckCast(r9, PageEvent.Drop.class, "com.obric.memorydata.plugin")), PageEvent.class, "com.obric.memorydata.plugin");
        goto L23
    L28:
        if (ZeusTransformUtils.instanceOf(r9, PageEvent.LoadStateUpdate.class) == false) goto L33;
        PageEvent.LoadStateUpdate<T> r16 = (PageEvent.LoadStateUpdate) ZeusTransformUtils.preCheckCast(r9, PageEvent.LoadStateUpdate.class, "com.obric.memorydata.plugin");
        r1.L$0 = this;
        r1.label = 2;
        r12 = onLoadStateUpdate(r16, r1);
        if (r12 != r3) goto L22;
        return r3;
    L33:
        if (ZeusTransformUtils.instanceOf(r9, PageEvent.StaticList.class) == false) goto L53;
        PageEvent.StaticList<T> r17 = (PageEvent.StaticList) ZeusTransformUtils.preCheckCast(r9, PageEvent.StaticList.class, "com.obric.memorydata.plugin");
        r1.L$0 = this;
        r1.label = 3;
        r12 = onStaticList(r17, r1);
        if (r12 != r3) goto L22;
        return r3;
    L53:
        throw new NoWhenBranchMatchedException();
    L7:
        r1 = new C09661(this, r11);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [boolean, int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:135:0x06b5 -> B:136:0x06c0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:190:0x091b -> B:191:0x0925). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:214:0x0a34 -> B:215:0x0a35). Please report as a decompilation issue!!! */
    public final Object onInsert(PageEvent.Insert<T> r26, Continuation<? super PageEvent.Insert<R>> r27) {
        SeparatorState<R, T> r0 = this;
        PageEvent.Insert<T> r1 = r26;
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r27, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, C09671.class) == false) goto L7;
        C09671 r5 = (C09671) ZeusTransformUtils.preCheckCast(r3, C09671.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r5.label) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            default: goto L11;
        };
    L12:
        List r2 = (List) ZeusTransformUtils.preCheckCast(r5.L$5, List.class, "com.obric.memorydata.plugin");
        TransformablePage r7 = (TransformablePage) ZeusTransformUtils.preCheckCast(r5.L$4, TransformablePage.class, "com.obric.memorydata.plugin");
        ArrayList r8 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$3, ArrayList.class, "com.obric.memorydata.plugin");
        ArrayList r9 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$2, ArrayList.class, "com.obric.memorydata.plugin");
        PageEvent.Insert<T> r10 = (PageEvent.Insert) ZeusTransformUtils.preCheckCast(r5.L$1, PageEvent.Insert.class, "com.obric.memorydata.plugin");
        SeparatorState<R, T> r11 = (SeparatorState) ZeusTransformUtils.preCheckCast(r5.L$0, SeparatorState.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        List r15 = r2;
        TransformablePage r17 = r7;
        Object r16 = r4;
        String r12 = "com.obric.memorydata.plugin";
    L234:
        int r19 = r17.getHintOriginalPageOffset();
        List<Integer> r13 = r17.getHintOriginalIndices();
        if (r13 == null) goto L237;
        int r14 = ((Number) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r13), Number.class, r12)).intValue();
    L238:
        SeparatorsKt.addSeparatorPage(r15, r16, r17, null, r19, r14);
        ArrayList r18 = r9;
    L239:
        r11.endTerminalSeparatorDeferred = false;
        r11.startTerminalSeparatorDeferred = false;
        if (r10.getLoadType() != LoadType.APPEND) goto L242;
        r11.pageStash.addAll((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, r12));
    L243:
        LoadType r110 = r10.getLoadType();
        r10.getPages();
        return new PageEvent.Insert(r110, (List) ZeusTransformUtils.preCheckCast(r18, List.class, r12), r10.getPlaceholdersBefore(), r10.getPlaceholdersAfter(), r10.getSourceLoadStates(), r10.getMediatorLoadStates(), null);
    L242:
        r11.pageStash.addAll(0, (Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, r12));
        goto L243
    L237:
        r14 = CollectionsKt.getLastIndex(r17.getData());
        goto L238
    L13:
        int r20 = r5.I$2;
        int r21 = r5.I$1;
        int r22 = r5.I$0;
        boolean r111 = r5.Z$0;
        ArrayList r112 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$5, ArrayList.class, "com.obric.memorydata.plugin");
        TransformablePage r113 = (TransformablePage) ZeusTransformUtils.preCheckCast(r5.L$4, TransformablePage.class, "com.obric.memorydata.plugin");
        ArrayList r114 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$3, ArrayList.class, "com.obric.memorydata.plugin");
        ArrayList r23 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$2, ArrayList.class, "com.obric.memorydata.plugin");
        PageEvent.Insert<T> r115 = (PageEvent.Insert) ZeusTransformUtils.preCheckCast(r5.L$1, PageEvent.Insert.class, "com.obric.memorydata.plugin");
        r11 = (SeparatorState) ZeusTransformUtils.preCheckCast(r5.L$0, SeparatorState.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        int r24 = r20;
        r12 = "com.obric.memorydata.plugin";
    L215:
        r112.add(r4);
        if (r21 == r24) goto L218;
        r21 = r21 + 1;
        r112 = r23;
    L211:
        TransformablePage r25 = (TransformablePage) ZeusTransformUtils.preCheckCast(r115.getPages().get(r21), TransformablePage.class, r12);
        Function3<T, T, Continuation<? super R>, Object> r28 = r11.generator;
        r5.L$0 = r11;
        r5.L$1 = r115;
        r5.L$2 = r112;
        r5.L$3 = r114;
        r5.L$4 = r113;
        r5.L$5 = r112;
        r5.L$6 = null;
        r5.L$7 = null;
        r5.L$8 = null;
        r5.L$9 = null;
        r5.Z$0 = r111;
        r5.I$0 = r22;
        r5.I$1 = r21;
        r5.I$2 = r24;
        r5.label = 9;
        r4 = SeparatorsKt.insertInternalSeparators(r25, r28, r5);
        if (r4 != r6) goto L214;
        return r6;
    L214:
        r23 = r112;
        goto L215
    L218:
        Object r29 = r6;
        r10 = r115;
        boolean r30 = r111;
        TransformablePage r116 = r113;
        r8 = r114;
        r18 = r23;
    L223:
        if (r30 == false) goto L239;
        if (r11.footerAdded == true) goto L239;
        r11.footerAdded = true;
        if (r22 == 0) goto L229;
        TransformablePage r31 = (TransformablePage) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r11.pageStash), TransformablePage.class, r12);
    L230:
        List r32 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, r12);
        Function3<T, T, Continuation<? super R>, Object> r33 = r11.generator;
        Object r34 = CollectionsKt.last(r31.getData());
        r5.L$0 = r11;
        r5.L$1 = r10;
        r5.L$2 = r18;
        r5.L$3 = r8;
        r5.L$4 = r31;
        r5.L$5 = r32;
        r5.L$6 = null;
        r5.L$7 = null;
        r5.L$8 = null;
        r5.L$9 = null;
        r5.label = 10;
        Object r35 = r33.invoke((T) r34, null, r5);
        if (r35 != r29) goto L233;
        return r29;
    L233:
        r17 = r31;
        r15 = r32;
        r16 = r35;
        r9 = r18;
        goto L234
    L229:
        Intrinsics.checkNotNull(r116);
        r31 = r116;
        goto L230
    L14:
        int r36 = r5.I$0;
        boolean r37 = r5.Z$0;
        TransformablePage r38 = (TransformablePage) ZeusTransformUtils.preCheckCast(r5.L$6, TransformablePage.class, "com.obric.memorydata.plugin");
        Integer r39 = (Integer) ZeusTransformUtils.preCheckCast(r5.L$5, Integer.class, "com.obric.memorydata.plugin");
        TransformablePage r117 = (TransformablePage) ZeusTransformUtils.preCheckCast(r5.L$4, TransformablePage.class, "com.obric.memorydata.plugin");
        ArrayList r118 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$3, ArrayList.class, "com.obric.memorydata.plugin");
        ArrayList r119 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$2, ArrayList.class, "com.obric.memorydata.plugin");
        PageEvent.Insert<T> r120 = (PageEvent.Insert) ZeusTransformUtils.preCheckCast(r5.L$1, PageEvent.Insert.class, "com.obric.memorydata.plugin");
        r11 = (SeparatorState) ZeusTransformUtils.preCheckCast(r5.L$0, SeparatorState.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        Object r40 = r4;
        Integer r41 = r39;
        ArrayList r121 = r118;
        ArrayList r122 = r119;
        PageEvent.Insert<T> r123 = r120;
        TransformablePage r124 = r38;
        r22 = r36;
        r12 = "com.obric.memorydata.plugin";
        TransformablePage r42 = r117;
    L203:
        List r43 = (List) ZeusTransformUtils.preCheckCast(r122, List.class, r12);
        int r125 = r42.getHintOriginalPageOffset();
        List<Integer> r126 = r42.getHintOriginalIndices();
        if (r126 == null) goto L206;
        int r127 = ((Number) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r126), Number.class, r12)).intValue();
    L207:
        int r128 = r127;
        r116 = r42;
        SeparatorsKt.addSeparatorPage(r43, r40, r116, r124, r125, r128);
        Integer r44 = r41;
        ArrayList r129 = r121;
        r112 = r122;
        PageEvent.Insert<T> r130 = r123;
    L208:
        r30 = r37;
        r21 = r44.intValue() + 1;
        r24 = CollectionsKt.getLastIndex(r130.getPages());
        if (r21 > r24) goto L219;
        r114 = r129;
        r111 = r30;
        PageEvent.Insert<T> r210 = r130;
        r113 = r116;
        r115 = r210;
        goto L211
    L219:
        r29 = r6;
        r8 = r129;
        r18 = r112;
        r10 = r130;
        goto L223
    L206:
        r127 = CollectionsKt.getLastIndex(r42.getData());
        goto L207
    L15:
        int r45 = r5.I$0;
        r37 = r5.Z$0;
        ArrayList r46 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$9, ArrayList.class, "com.obric.memorydata.plugin");
        TransformablePage<T> r47 = (TransformablePage) ZeusTransformUtils.preCheckCast(r5.L$8, TransformablePage.class, "com.obric.memorydata.plugin");
        TransformablePage<T> r131 = (TransformablePage) ZeusTransformUtils.preCheckCast(r5.L$7, TransformablePage.class, "com.obric.memorydata.plugin");
        Iterator r132 = (Iterator) ZeusTransformUtils.preCheckCast(r5.L$6, Iterator.class, "com.obric.memorydata.plugin");
        Integer r133 = (Integer) ZeusTransformUtils.preCheckCast(r5.L$5, Integer.class, "com.obric.memorydata.plugin");
        TransformablePage r134 = (TransformablePage) ZeusTransformUtils.preCheckCast(r5.L$4, TransformablePage.class, "com.obric.memorydata.plugin");
        ArrayList r135 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$3, ArrayList.class, "com.obric.memorydata.plugin");
        ArrayList r48 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$2, ArrayList.class, "com.obric.memorydata.plugin");
        PageEvent.Insert<T> r49 = (PageEvent.Insert) ZeusTransformUtils.preCheckCast(r5.L$1, PageEvent.Insert.class, "com.obric.memorydata.plugin");
        r11 = (SeparatorState) ZeusTransformUtils.preCheckCast(r5.L$0, SeparatorState.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        PageEvent.Insert<T> r136 = r49;
        r12 = "com.obric.memorydata.plugin";
        int r50 = r45;
        r112 = r48;
        Iterator r51 = r132;
        r129 = r135;
        Integer r137 = r133;
    L191:
        r46.add(r4);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r131.getData(), Collection.class, r12)).isEmpty()) == false) goto L194;
        r47 = r131;
    L194:
        r22 = r50;
        Object r52 = r47;
        r116 = r134;
        r44 = r137;
        r130 = r136;
    L159:
        if (r51.hasNext() == false) goto L196;
        TransformablePage<T> r53 = (TransformablePage) ZeusTransformUtils.preCheckCast(r51.next(), TransformablePage.class, r12);
        TransformablePage<T> r54 = (TransformablePage) ZeusTransformUtils.preCheckCast(r52, TransformablePage.class, r12);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r53.getData(), Collection.class, r12)).isEmpty()) == false) goto L183;
        Function3<T, T, Continuation<? super R>, Object> r138 = r11.generator;
        Object r139 = CollectionsKt.last(r54.getData());
        String r140 = r12;
        Object r55 = CollectionsKt.first(r53.getData());
        r5.L$0 = r11;
        r5.L$1 = r130;
        r5.L$2 = r112;
        r5.L$3 = r129;
        r5.L$4 = r116;
        r5.L$5 = r44;
        r5.L$6 = r51;
        r5.L$7 = r53;
        r5.L$8 = r54;
        r5.L$9 = null;
        r5.Z$0 = r37;
        r5.I$0 = r22;
        r5.label = 6;
        Object r56 = r138.invoke((T) r139, (T) r55, r5);
        if (r56 != r6) goto L165;
        return r6;
    L165:
        int r57 = r22;
        r137 = r44;
        TransformablePage r141 = r116;
        ArrayList r142 = r129;
        ArrayList r58 = r112;
        PageEvent.Insert<T> r211 = r130;
        TransformablePage<T> r143 = r53;
        TransformablePage<T> r144 = r54;
        Object r145 = r6;
        Iterator r146 = r51;
        Object r59 = r56;
    L17:
        C09671 r60 = r5;
        String r61 = r140;
        List r62 = (List) ZeusTransformUtils.preCheckCast(r58, List.class, r61);
        if (r211.getLoadType() != LoadType.PREPEND) goto L169;
        int r63 = r144.getHintOriginalPageOffset();
    L170:
        int r147 = r63;
        if (r211.getLoadType() != LoadType.PREPEND) goto L176;
        List<Integer> r64 = r144.getHintOriginalIndices();
        if (r64 == null) goto L175;
        Object r65 = CollectionsKt.last(r64);
    L179:
        int r66 = ((Number) ZeusTransformUtils.preCheckCast(r65, Number.class, r61)).intValue();
    L180:
        int r212 = r66;
    L182:
        int r213 = r57;
        r12 = r61;
        ArrayList r148 = r58;
        SeparatorsKt.addSeparatorPage(r62, r59, r144, r143, r147, r212);
        r22 = r213;
        r5 = r60;
        r6 = r145;
        r47 = r144;
        r131 = r143;
        Iterator r149 = r146;
        ArrayList r67 = r142;
        r112 = r148;
        r130 = r211;
    L185:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r131.getData(), Collection.class, r12)).isEmpty()) == false) goto L187;
        r67.add(r11.transformablePageToStash(r131));
    L187:
        Function3<T, T, Continuation<? super R>, Object> r68 = r11.generator;
        r5.L$0 = r11;
        r5.L$1 = r130;
        r5.L$2 = r112;
        r5.L$3 = r67;
        r5.L$4 = r141;
        r5.L$5 = r137;
        r5.L$6 = r149;
        r5.L$7 = r131;
        r5.L$8 = r47;
        r5.L$9 = r112;
        r5.Z$0 = r37;
        r5.I$0 = r22;
        r5.label = 7;
        Object r69 = SeparatorsKt.insertInternalSeparators(r131, r68, r5);
        if (r69 != r6) goto L190;
        return r6;
    L190:
        r51 = r149;
        r129 = r67;
        r4 = r69;
        r50 = r22;
        r46 = r112;
        TransformablePage r214 = r141;
        r136 = r130;
        r134 = r214;
        goto L191
    L175:
        r66 = CollectionsKt.getLastIndex(r144.getData());
        goto L180
    L176:
        List<Integer> r70 = r143.getHintOriginalIndices();
        if (r70 == null) goto L181;
        r65 = CollectionsKt.first(r70);
        goto L179
    L181:
        r212 = 0;
        goto L182
    L169:
        r63 = r143.getHintOriginalPageOffset();
        goto L170
    L183:
        r137 = r44;
        r141 = r116;
        r67 = r129;
        r131 = r53;
        r47 = r54;
        r149 = r51;
        goto L185
    L196:
        if (r130.getLoadType() != LoadType.PREPEND) goto L208;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11.pageStash, Collection.class, r12)).isEmpty()) == false) goto L208;
        TransformablePage r71 = (TransformablePage) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r11.pageStash), TransformablePage.class, r12);
        Function3<T, T, Continuation<? super R>, Object> r72 = r11.generator;
        Intrinsics.checkNotNull(r116);
        Object r73 = CollectionsKt.last(r116.getData());
        Object r150 = CollectionsKt.first(r71.getData());
        r5.L$0 = r11;
        r5.L$1 = r130;
        r5.L$2 = r112;
        r5.L$3 = r129;
        r5.L$4 = r116;
        r5.L$5 = r44;
        r5.L$6 = r71;
        r5.L$7 = null;
        r5.L$8 = null;
        r5.L$9 = null;
        r5.Z$0 = r37;
        r5.I$0 = r22;
        r5.label = 8;
        Object r74 = r72.invoke((T) r73, (T) r150, r5);
        if (r74 != r6) goto L202;
        return r6;
    L202:
        r40 = r74;
        r42 = r116;
        r121 = r129;
        r122 = r112;
        r123 = r130;
        r124 = r71;
        r41 = r44;
        goto L203
    L16:
        r57 = r5.I$0;
        r37 = r5.Z$0;
        TransformablePage<T> r75 = (TransformablePage) ZeusTransformUtils.preCheckCast(r5.L$8, TransformablePage.class, "com.obric.memorydata.plugin");
        TransformablePage<T> r76 = (TransformablePage) ZeusTransformUtils.preCheckCast(r5.L$7, TransformablePage.class, "com.obric.memorydata.plugin");
        Iterator r77 = (Iterator) ZeusTransformUtils.preCheckCast(r5.L$6, Iterator.class, "com.obric.memorydata.plugin");
        Integer r151 = (Integer) ZeusTransformUtils.preCheckCast(r5.L$5, Integer.class, "com.obric.memorydata.plugin");
        TransformablePage r152 = (TransformablePage) ZeusTransformUtils.preCheckCast(r5.L$4, TransformablePage.class, "com.obric.memorydata.plugin");
        ArrayList r153 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$3, ArrayList.class, "com.obric.memorydata.plugin");
        ArrayList r154 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$2, ArrayList.class, "com.obric.memorydata.plugin");
        PageEvent.Insert<T> r155 = (PageEvent.Insert) ZeusTransformUtils.preCheckCast(r5.L$1, PageEvent.Insert.class, "com.obric.memorydata.plugin");
        r11 = (SeparatorState) ZeusTransformUtils.preCheckCast(r5.L$0, SeparatorState.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        r140 = "com.obric.memorydata.plugin";
        r141 = r152;
        r142 = r153;
        r211 = r155;
        r59 = r4;
        r144 = r75;
        r143 = r76;
        r137 = r151;
        r58 = r154;
        r145 = r6;
        r146 = r77;
        goto L17
    L18:
        int r78 = r5.I$0;
        r37 = r5.Z$0;
        ArrayList r79 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$7, ArrayList.class, "com.obric.memorydata.plugin");
        r44 = (Integer) ZeusTransformUtils.preCheckCast(r5.L$6, Integer.class, "com.obric.memorydata.plugin");
        TransformablePage r80 = (TransformablePage) ZeusTransformUtils.preCheckCast(r5.L$5, TransformablePage.class, "com.obric.memorydata.plugin");
        Integer r156 = (Integer) ZeusTransformUtils.preCheckCast(r5.L$4, Integer.class, "com.obric.memorydata.plugin");
        r129 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$3, ArrayList.class, "com.obric.memorydata.plugin");
        r112 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$2, ArrayList.class, "com.obric.memorydata.plugin");
        PageEvent.Insert<T> r157 = (PageEvent.Insert) ZeusTransformUtils.preCheckCast(r5.L$1, PageEvent.Insert.class, "com.obric.memorydata.plugin");
        r11 = (SeparatorState) ZeusTransformUtils.preCheckCast(r5.L$0, SeparatorState.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        PageEvent.Insert<T> r158 = r157;
        ArrayList r159 = r79;
        r22 = r78;
        r12 = "com.obric.memorydata.plugin";
    L155:
        r159.add(r4);
        List<TransformablePage<T>> r81 = r158.getPages();
        int r82 = r156.intValue();
        Intrinsics.checkNotNull(r44);
        Iterator r83 = ((Iterable) ZeusTransformUtils.preCheckCast(r81.subList(r82, r44.intValue() + 1), Iterable.class, r12)).iterator();
        if (r83.hasNext() == false) goto L221;
        r52 = r83.next();
        r116 = r80;
        r130 = r158;
        r51 = r83;
        goto L159
    L221:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    L19:
        int r84 = r5.I$0;
        boolean r85 = r5.Z$0;
        TransformablePage r86 = (TransformablePage) ZeusTransformUtils.preCheckCast(r5.L$8, TransformablePage.class, "com.obric.memorydata.plugin");
        Integer r87 = (Integer) ZeusTransformUtils.preCheckCast(r5.L$7, Integer.class, "com.obric.memorydata.plugin");
        TransformablePage r88 = (TransformablePage) ZeusTransformUtils.preCheckCast(r5.L$6, TransformablePage.class, "com.obric.memorydata.plugin");
        Integer r160 = (Integer) ZeusTransformUtils.preCheckCast(r5.L$5, Integer.class, "com.obric.memorydata.plugin");
        TransformablePage<T> r161 = (TransformablePage) ZeusTransformUtils.preCheckCast(r5.L$4, TransformablePage.class, "com.obric.memorydata.plugin");
        ArrayList r162 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$3, ArrayList.class, "com.obric.memorydata.plugin");
        r159 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$2, ArrayList.class, "com.obric.memorydata.plugin");
        PageEvent.Insert<T> r163 = (PageEvent.Insert) ZeusTransformUtils.preCheckCast(r5.L$1, PageEvent.Insert.class, "com.obric.memorydata.plugin");
        r11 = (SeparatorState) ZeusTransformUtils.preCheckCast(r5.L$0, SeparatorState.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        TransformablePage<T> r164 = r161;
        ArrayList r165 = r162;
        PageEvent.Insert<T> r166 = r163;
        Integer r167 = r160;
        TransformablePage r168 = r86;
        r22 = r84;
        r12 = "com.obric.memorydata.plugin";
        TransformablePage r89 = r88;
        Object r90 = r4;
        Integer r91 = r87;
    L145:
        List r92 = (List) ZeusTransformUtils.preCheckCast(r159, List.class, r12);
        int r169 = r164.getHintOriginalPageOffset();
        List<Integer> r170 = r164.getHintOriginalIndices();
        if (r170 == null) goto L148;
        int r93 = ((Number) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r170), Number.class, r12)).intValue();
    L149:
        SeparatorsKt.addSeparatorPage(r92, r90, r168, r164, r169, r93);
        r37 = r85;
        r44 = r91;
        r80 = r89;
        r156 = r167;
        r129 = r165;
        r158 = r166;
        r159 = r159;
    L151:
        Intrinsics.checkNotNull(r164);
        r129.add(r11.transformablePageToStash(r164));
        Function3<T, T, Continuation<? super R>, Object> r94 = r11.generator;
        r5.L$0 = r11;
        r5.L$1 = r158;
        r5.L$2 = r159;
        r5.L$3 = r129;
        r5.L$4 = r156;
        r5.L$5 = r80;
        r5.L$6 = r44;
        r5.L$7 = r159;
        r5.L$8 = null;
        r5.L$9 = null;
        r5.Z$0 = r37;
        r5.I$0 = r22;
        r5.label = 5;
        r4 = SeparatorsKt.insertInternalSeparators(r164, r94, r5);
        if (r4 != r6) goto L154;
        return r6;
    L154:
        r112 = r159;
        goto L155
    L148:
        r93 = 0;
        goto L149
    L20:
        int r95 = r5.I$2;
        int r96 = r5.I$1;
        r22 = r5.I$0;
        boolean r97 = r5.Z$0;
        ArrayList r98 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$8, ArrayList.class, "com.obric.memorydata.plugin");
        Integer r171 = (Integer) ZeusTransformUtils.preCheckCast(r5.L$7, Integer.class, "com.obric.memorydata.plugin");
        TransformablePage r172 = (TransformablePage) ZeusTransformUtils.preCheckCast(r5.L$6, TransformablePage.class, "com.obric.memorydata.plugin");
        Integer r173 = (Integer) ZeusTransformUtils.preCheckCast(r5.L$5, Integer.class, "com.obric.memorydata.plugin");
        TransformablePage<T> r174 = (TransformablePage) ZeusTransformUtils.preCheckCast(r5.L$4, TransformablePage.class, "com.obric.memorydata.plugin");
        ArrayList r175 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$3, ArrayList.class, "com.obric.memorydata.plugin");
        ArrayList r99 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$2, ArrayList.class, "com.obric.memorydata.plugin");
        PageEvent.Insert<T> r100 = (PageEvent.Insert) ZeusTransformUtils.preCheckCast(r5.L$1, PageEvent.Insert.class, "com.obric.memorydata.plugin");
        r11 = (SeparatorState) ZeusTransformUtils.preCheckCast(r5.L$0, SeparatorState.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        PageEvent.Insert<T> r176 = r100;
        r12 = "com.obric.memorydata.plugin";
        Integer r177 = r171;
        r156 = r173;
        ArrayList r178 = r175;
        int r101 = r95;
        ArrayList r179 = r99;
    L136:
        r98.add(r4);
        r96 = r96 + 1;
        r30 = r97;
        r80 = r172;
        TransformablePage<T> r180 = r174;
        r159 = r179;
        r158 = r176;
        Integer r102 = r177;
    L131:
        if (r96 >= r101) goto L137;
        Object r181 = r6;
        TransformablePage r103 = (TransformablePage) ZeusTransformUtils.preCheckCast(r158.getPages().get(r96), TransformablePage.class, r12);
        Function3<T, T, Continuation<? super R>, Object> r182 = r11.generator;
        r5.L$0 = r11;
        r5.L$1 = r158;
        r5.L$2 = r159;
        r5.L$3 = r178;
        r5.L$4 = r180;
        r5.L$5 = r156;
        r5.L$6 = r80;
        r5.L$7 = r102;
        r5.L$8 = r159;
        r177 = r102;
        r5.L$9 = null;
        r5.Z$0 = r30;
        r5.I$0 = r22;
        r5.I$1 = r96;
        r5.I$2 = r101;
        r5.label = 3;
        Object r104 = SeparatorsKt.insertInternalSeparators(r103, r182, r5);
        if (r104 != r181) goto L135;
        return r181;
    L135:
        r176 = r158;
        r179 = r159;
        r174 = r180;
        r172 = r80;
        r98 = r179;
        r97 = r30;
        r4 = r104;
        r6 = r181;
        goto L136
    L137:
        Integer r183 = r102;
        Object r105 = r6;
        if (r158.getLoadType() == LoadType.APPEND) goto L140;
    L150:
        r37 = r30;
        r6 = r105;
        r164 = r180;
        r129 = r178;
        r44 = r183;
        r11 = r11;
        goto L151
    L140:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11.pageStash, Collection.class, r12)).isEmpty()) == false) goto L150;
        TransformablePage r106 = (TransformablePage) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r11.pageStash), TransformablePage.class, r12);
        Function3<T, T, Continuation<? super R>, Object> r107 = r11.generator;
        Object r108 = CollectionsKt.last(r106.getData());
        Intrinsics.checkNotNull(r180);
        Object r184 = CollectionsKt.first(r180.getData());
        r5.L$0 = r11;
        r5.L$1 = r158;
        r5.L$2 = r159;
        r5.L$3 = r178;
        r5.L$4 = r180;
        r5.L$5 = r156;
        r5.L$6 = r80;
        SeparatorState<R, T> r185 = r11;
        r5.L$7 = r183;
        r5.L$8 = r106;
        r5.L$9 = null;
        r5.Z$0 = r30;
        r5.I$0 = r22;
        r5.label = 4;
        Object r109 = r107.invoke((T) r108, (T) r184, r5);
        if (r109 != r105) goto L144;
        return r105;
    L144:
        r6 = r105;
        r89 = r80;
        r164 = r180;
        r166 = r158;
        r90 = r109;
        r85 = r30;
        r167 = r156;
        r168 = r106;
        r91 = r183;
        r11 = r185;
        r165 = r178;
        goto L145
    L21:
        int r186 = r5.I$0;
        boolean r187 = r5.Z$0;
        List r188 = (List) ZeusTransformUtils.preCheckCast(r5.L$9, List.class, "com.obric.memorydata.plugin");
        TransformablePage<T> r189 = (TransformablePage) ZeusTransformUtils.preCheckCast(r5.L$8, TransformablePage.class, "com.obric.memorydata.plugin");
        Integer r190 = (Integer) ZeusTransformUtils.preCheckCast(r5.L$7, Integer.class, "com.obric.memorydata.plugin");
        TransformablePage r191 = (TransformablePage) ZeusTransformUtils.preCheckCast(r5.L$6, TransformablePage.class, "com.obric.memorydata.plugin");
        Integer r192 = (Integer) ZeusTransformUtils.preCheckCast(r5.L$5, Integer.class, "com.obric.memorydata.plugin");
        TransformablePage<T> r193 = (TransformablePage) ZeusTransformUtils.preCheckCast(r5.L$4, TransformablePage.class, "com.obric.memorydata.plugin");
        ArrayList r194 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$3, ArrayList.class, "com.obric.memorydata.plugin");
        ArrayList r195 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.L$2, ArrayList.class, "com.obric.memorydata.plugin");
        PageEvent.Insert<T> r196 = (PageEvent.Insert) ZeusTransformUtils.preCheckCast(r5.L$1, PageEvent.Insert.class, "com.obric.memorydata.plugin");
        r11 = (SeparatorState) ZeusTransformUtils.preCheckCast(r5.L$0, SeparatorState.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        TransformablePage r197 = r191;
        TransformablePage<T> r198 = r193;
        ArrayList r199 = r194;
        ArrayList r215 = r195;
        Integer r1100 = r192;
        TransformablePage<T> r1101 = r189;
        List r200 = r188;
        r22 = r186;
        Object r201 = r4;
        Integer r202 = r190;
    L123:
        int r1102 = r1101.getHintOriginalPageOffset();
        List<Integer> r1103 = r1101.getHintOriginalIndices();
        if (r1103 == null) goto L126;
        r12 = "com.obric.memorydata.plugin";
        int r1104 = ((Number) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r1103), Number.class, r12)).intValue();
    L127:
        SeparatorsKt.addSeparatorPage(r200, r201, null, r1101, r1102, r1104);
        Integer r1105 = r202;
        r116 = r197;
        Integer r203 = r1100;
        TransformablePage<T> r204 = r198;
        ArrayList r1106 = r199;
        r18 = r215;
        r30 = r187;
        r1 = r196;
    L129:
        if (r22 != 0) goto L222;
        Intrinsics.checkNotNull(r203);
        r101 = r203.intValue();
        r178 = r1106;
        r159 = r18;
        r158 = r1;
        r96 = 0;
        Integer r216 = r1105;
        r180 = r204;
        r102 = r216;
        TransformablePage r217 = r116;
        r156 = r203;
        r80 = r217;
        goto L131
    L222:
        r10 = r1;
        r29 = r6;
        r8 = r1106;
        goto L223
    L126:
        r12 = r4;
        r1104 = 0;
        goto L127
    L22:
        PageEvent.Insert<T> r205 = (PageEvent.Insert) ZeusTransformUtils.preCheckCast(r5.L$1, PageEvent.Insert.class, "com.obric.memorydata.plugin");
        SeparatorState<R, T> r206 = (SeparatorState) ZeusTransformUtils.preCheckCast(r5.L$0, SeparatorState.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        Object r207 = r4;
        int r208 = 1;
        ?? r209 = 0;
        r1 = r205;
        r0 = r206;
    L81:
        r0.endTerminalSeparatorDeferred = r209;
        r0.startTerminalSeparatorDeferred = r209;
        r0.headerAdded = r208;
        r0.footerAdded = r208;
        if (r207 == null) goto L256;
        LoadType r218 = r1.getLoadType();
        r1.getPages();
        int[] r219 = new int[r208];
        r219[r209] = r209;
        return new PageEvent.Insert(r218, CollectionsKt.listOf(SeparatorsKt.separatorPage(r207, r219, r209, r209)), r1.getPlaceholdersBefore(), r1.getPlaceholdersAfter(), r1.getSourceLoadStates(), r1.getMediatorLoadStates(), null);
    L256:
        return r0.asRType(r1);
    L23:
        ResultKt.throwOnFailure(r4);
        boolean r220 = r0.terminatesStart(r1, r0.terminalSeparatorType);
        r30 = r0.terminatesEnd(r1, r0.terminalSeparatorType);
        Iterable r221 = (Iterable) ZeusTransformUtils.preCheckCast(r26.getPages(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r221, Collection.class) == true) goto L26;
    L28:
        Iterator r222 = r221.iterator();
    L30:
        if (r222.hasNext() == false) goto L27;
        if (((TransformablePage) ZeusTransformUtils.preCheckCast(r222.next(), TransformablePage.class, "com.obric.memorydata.plugin")).getData().isEmpty() == true) goto L30;
        r22 = 0;
    L35:
        if (r0.headerAdded == true) goto L37;
    L41:
        boolean r223 = true;
    L42:
        if (r223 == false) goto L248;
        if (r0.footerAdded == true) goto L46;
    L50:
        boolean r224 = true;
    L51:
        if (r224 == false) goto L246;
        r0.sourceStates.set(r26.getSourceLoadStates());
        r0.mediatorStates = r26.getMediatorLoadStates();
        if (r26.getLoadType() == LoadType.APPEND) goto L56;
        r0.placeholdersBefore = r26.getPlaceholdersBefore();
    L56:
        if (r26.getLoadType() == LoadType.PREPEND) goto L58;
        r0.placeholdersAfter = r26.getPlaceholdersAfter();
    L58:
        if (r22 == 0) goto L97;
        if (r220 == true) goto L64;
        if (r30 == true) goto L64;
        return asRType(r26);
    L64:
        if (r0.headerAdded == false) goto L70;
        if (r0.footerAdded == false) goto L70;
        return asRType(r26);
    L70:
        if (r0.pageStash.isEmpty() == false) goto L97;
        if (r220 == false) goto L86;
        if (r30 == false) goto L86;
        if (r0.headerAdded == true) goto L86;
        if (r0.footerAdded == true) goto L86;
        Function3<T, T, Continuation<? super R>, Object> r225 = r0.generator;
        r5.L$0 = r0;
        r5.L$1 = r1;
        r208 = 1;
        r5.label = 1;
        r207 = r225.invoke(null, null, r5);
        if (r207 != r6) goto L80;
        return r6;
    L80:
        r209 = 0;
    L86:
        if (r30 == true) goto L88;
    L90:
        boolean r226 = true;
    L91:
        if (r220 == false) goto L96;
        if (r0.headerAdded == true) goto L96;
        r0.startTerminalSeparatorDeferred = r226;
    L96:
        return asRType(r26);
    L88:
        if (r0.footerAdded == true) goto L90;
        r226 = true;
        r0.endTerminalSeparatorDeferred = true;
    L97:
        r18 = new ArrayList(r26.getPages().size());
        r1106 = new ArrayList(r26.getPages().size());
        if (r22 != 0) goto L111;
        int r227 = 0;
    L101:
        if (r227 >= CollectionsKt.getLastIndex(r26.getPages())) goto L105;
        if (((TransformablePage) ZeusTransformUtils.preCheckCast(r26.getPages().get(r227), TransformablePage.class, "com.obric.memorydata.plugin")).getData().isEmpty() == false) goto L105;
        r227 = r227 + 1;
    L105:
        r203 = Boxing.boxInt(r227);
        r204 = (TransformablePage) ZeusTransformUtils.preCheckCast(r26.getPages().get(r227), TransformablePage.class, "com.obric.memorydata.plugin");
        int r1107 = CollectionsKt.getLastIndex(r26.getPages());
    L106:
        if (r1107 <= 0) goto L110;
        if (((TransformablePage) ZeusTransformUtils.preCheckCast(r26.getPages().get(r1107), TransformablePage.class, "com.obric.memorydata.plugin")).getData().isEmpty() == false) goto L110;
        r1107 = r1107 - 1;
    L110:
        r1105 = Boxing.boxInt(r1107);
        r116 = (TransformablePage) ZeusTransformUtils.preCheckCast(r26.getPages().get(r1107), TransformablePage.class, "com.obric.memorydata.plugin");
    L112:
        if (r220 == true) goto L114;
    L128:
        r12 = "com.obric.memorydata.plugin";
        r11 = this;
        goto L129
    L114:
        if (r0.headerAdded == true) goto L128;
        r0.headerAdded = true;
        if (r22 == 0) goto L118;
        TransformablePage<T> r228 = (TransformablePage) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r0.pageStash), TransformablePage.class, "com.obric.memorydata.plugin");
    L119:
        List r1108 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin");
        Function3<T, T, Continuation<? super R>, Object> r1109 = r0.generator;
        Object r229 = CollectionsKt.first(r228.getData());
        r5.L$0 = r0;
        r5.L$1 = r1;
        r5.L$2 = r18;
        r5.L$3 = r1106;
        r5.L$4 = r204;
        r5.L$5 = r203;
        r5.L$6 = r116;
        r5.L$7 = r1105;
        r5.L$8 = r228;
        r5.L$9 = r1108;
        r5.Z$0 = r30;
        r5.I$0 = r22;
        r5.label = 2;
        Object r230 = r1109.invoke(null, (T) r229, r5);
        if (r230 != r6) goto L122;
        return r6;
    L122:
        r196 = r1;
        r187 = r30;
        r198 = r204;
        r202 = r1105;
        r200 = r1108;
        r199 = r1106;
        r215 = r18;
        r1101 = r228;
        r1100 = r203;
        r11 = this;
        r201 = r230;
        r197 = r116;
        goto L123
    L118:
        Intrinsics.checkNotNull(r204);
        r228 = r204;
        goto L119
    L111:
        r204 = null;
        r203 = null;
        r116 = null;
        r1105 = null;
        goto L112
    L246:
        throw new IllegalArgumentException("Additional append event after append state is done".toString());
    L46:
        if (r26.getLoadType() != LoadType.APPEND) goto L50;
        if (r22 != 0) goto L50;
        r224 = false;
        goto L51
    L248:
        throw new IllegalArgumentException("Additional prepend event after prepend state is done".toString());
    L37:
        if (r26.getLoadType() != LoadType.PREPEND) goto L41;
        if (r22 != 0) goto L41;
        r223 = false;
    L27:
        r22 = 1;
        goto L35
    L26:
        if (((Collection) ZeusTransformUtils.preCheckCast(r221, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L28;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r5 = new C09671(r0, r3);
        goto L8
    }

    public final Object onLoadStateUpdate(PageEvent.LoadStateUpdate<T> r7, Continuation<? super PageEvent<R>> r8) {
        Continuation<? super PageEvent.Insert<R>> r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        LoadStates r0 = this.mediatorStates;
        if (Intrinsics.areEqual(this.sourceStates.snapshot(), r7.getSource()) == true) goto L5;
    L8:
        this.sourceStates.set(r7.getSource());
        this.mediatorStates = r7.getMediator();
        LoadState r4 = null;
        if (r7.getMediator() == null) goto L20;
        if (r7.getMediator().getPrepend().getEndOfPaginationReached() == false) goto L20;
        if (r0 == null) goto L14;
        LoadState r2 = r0.getPrepend();
    L16:
        if (Intrinsics.areEqual(r2, r7.getMediator().getPrepend()) == true) goto L20;
        return onInsert(PageEvent.Insert.Companion.Prepend(CollectionsKt.emptyList(), this.placeholdersBefore, r7.getSource(), r7.getMediator()), r9);
    L14:
        r2 = null;
    L20:
        if (r7.getMediator() != null) goto L22;
    L29:
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.SeparatorState>");
        return (PageEvent) ZeusTransformUtils.preCheckCast(r7, PageEvent.class, "com.obric.memorydata.plugin");
    L22:
        if (r7.getMediator().getAppend().getEndOfPaginationReached() == false) goto L29;
        if (r0 == null) goto L26;
        r4 = r0.getAppend();
    L26:
        if (Intrinsics.areEqual(r4, r7.getMediator().getAppend()) == true) goto L29;
        return onInsert(PageEvent.Insert.Companion.Append(CollectionsKt.emptyList(), this.placeholdersAfter, r7.getSource(), r7.getMediator()), r9);
    L5:
        if (Intrinsics.areEqual(r0, r7.getMediator()) == false) goto L8;
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.SeparatorState>");
        return (PageEvent) ZeusTransformUtils.preCheckCast(r7, PageEvent.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00b1 -> B:21:0x00b6). Please report as a decompilation issue!!! */
    public final Object onStaticList(PageEvent.StaticList<T> r11, Continuation<? super PageEvent<R>> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, C09681.class) == false) goto L7;
        C09681 r0 = (C09681) ZeusTransformUtils.preCheckCast(r13, C09681.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r10 = r0.I$1;
        int r15 = r0.I$0;
        Object r4 = r0.L$3;
        List r5 = (List) ZeusTransformUtils.preCheckCast(r0.L$2, List.class, "com.obric.memorydata.plugin");
        PageEvent.StaticList<T> r6 = (PageEvent.StaticList) ZeusTransformUtils.preCheckCast(r0.L$1, PageEvent.StaticList.class, "com.obric.memorydata.plugin");
        SeparatorState<R, T> r1 = (SeparatorState) ZeusTransformUtils.preCheckCast(r0.L$0, SeparatorState.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);
        int r7 = r10;
        SeparatorState<R, T> this = r1;
    L21:
        if (r14 == null) goto L23;
        r5.add(r14);
    L23:
        if (r4 == null) goto L25;
        r5.add(r4);
    L25:
        if (r15 == r7) goto L27;
        int r8 = r7;
        int r9 = r15 + 1;
        r11 = r6;
    L17:
        Object r16 = CollectionsKt.getOrNull(r11.getData(), r9 - 1);
        Object r17 = CollectionsKt.getOrNull(r11.getData(), r9);
        Function3<T, T, Continuation<? super R>, Object> r18 = this.generator;
        r0.L$0 = this;
        r0.L$1 = r11;
        r0.L$2 = r5;
        r0.L$3 = r17;
        r0.I$0 = r9;
        r0.I$1 = r8;
        r0.label = 1;
        r14 = r18.invoke((T) r16, (T) r17, r0);
        if (r14 != r2) goto L20;
        return r2;
    L20:
        r6 = r11;
        r15 = r9;
        r7 = r8;
        r4 = r17;
        goto L21
    L27:
        List r19 = r5;
        r11 = r6;
    L29:
        return new PageEvent.StaticList(r19, r11.getSourceLoadStates(), r11.getMediatorLoadStates());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        r19 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r9 = 0;
        r8 = r11.getData().size();
        if (r8 < 0) goto L29;
        r5 = r19;
    L7:
        r0 = new C09681(this, r13);
        goto L8
    }

    public final void setEndTerminalSeparatorDeferred(boolean r1) {
        this.endTerminalSeparatorDeferred = r1;
    }

    public final void setFooterAdded(boolean r1) {
        this.footerAdded = r1;
    }

    public final void setHeaderAdded(boolean r1) {
        this.headerAdded = r1;
    }

    public final void setMediatorStates(LoadStates r1) {
        this.mediatorStates = r1;
    }

    public final void setPlaceholdersAfter(int r1) {
        this.placeholdersAfter = r1;
    }

    public final void setPlaceholdersBefore(int r1) {
        this.placeholdersBefore = r1;
    }

    public final void setStartTerminalSeparatorDeferred(boolean r1) {
        this.startTerminalSeparatorDeferred = r1;
    }

    public final <T> boolean terminatesEnd(PageEvent.Insert<T> r3, TerminalSeparatorType r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "terminalSeparatorType");
        if (r3.getLoadType() == LoadType.PREPEND) goto L5;
        int r2 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        if (r2 == 1) goto L14;
        if (r2 != 2) goto L12;
        return r3.getSourceLoadStates().getAppend().getEndOfPaginationReached();
    L12:
        throw new NoWhenBranchMatchedException();
    L14:
        if (r3.getSourceLoadStates().getAppend().getEndOfPaginationReached() == false) goto L27;
        LoadStates r5 = r3.getMediatorLoadStates();
        if (r5 == null) goto L22;
        LoadState r6 = r5.getAppend();
        if (r6 == null) goto L22;
        if (r6.getEndOfPaginationReached() == true) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == false) goto L25;
        return false;
    L25:
        return true;
    L22:
        r7 = false;
        goto L23
    L27:
        return false;
    L5:
        return this.endTerminalSeparatorDeferred;
    }

    public final <T> boolean terminatesStart(PageEvent.Insert<T> r3, TerminalSeparatorType r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "terminalSeparatorType");
        if (r3.getLoadType() == LoadType.APPEND) goto L5;
        int r2 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        if (r2 == 1) goto L14;
        if (r2 != 2) goto L12;
        return r3.getSourceLoadStates().getPrepend().getEndOfPaginationReached();
    L12:
        throw new NoWhenBranchMatchedException();
    L14:
        if (r3.getSourceLoadStates().getPrepend().getEndOfPaginationReached() == false) goto L27;
        LoadStates r5 = r3.getMediatorLoadStates();
        if (r5 == null) goto L22;
        LoadState r6 = r5.getPrepend();
        if (r6 == null) goto L22;
        if (r6.getEndOfPaginationReached() == true) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == false) goto L25;
        return false;
    L25:
        return true;
    L22:
        r7 = false;
        goto L23
    L27:
        return false;
    L5:
        return this.startTerminalSeparatorDeferred;
    }
}
