package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u0016*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\u0016BC\b\u0000\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f0\u000b¢\u0006\u0002\u0010\rJ\u0015\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fH\u0000¢\u0006\u0002\b\u0015R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Landroidx/paging/PagingData;", ExifInterface.GPS_DIRECTION_TRUE, "", "flow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PageEvent;", "uiReceiver", "Landroidx/paging/UiReceiver;", "hintReceiver", "Landroidx/paging/HintReceiver;", "cachedPageEvent", "Lkotlin/Function0;", "Landroidx/paging/PageEvent$Insert;", "(Lkotlinx/coroutines/flow/Flow;Landroidx/paging/UiReceiver;Landroidx/paging/HintReceiver;Lkotlin/jvm/functions/Function0;)V", "getFlow$paging_common", "()Lkotlinx/coroutines/flow/Flow;", "getHintReceiver$paging_common", "()Landroidx/paging/HintReceiver;", "getUiReceiver$paging_common", "()Landroidx/paging/UiReceiver;", "cachedEvent", "cachedEvent$paging_common", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PagingData<T> {
    public static final Companion Companion = null;
    private static final HintReceiver NOOP_HINT_RECEIVER = null;
    private static final UiReceiver NOOP_UI_RECEIVER = null;
    private final Function0<PageEvent.Insert<T>> cachedPageEvent;
    private final i<PageEvent<T>> flow;
    private final HintReceiver hintReceiver;
    private final UiReceiver uiReceiver;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\b\b\u0001\u0010\r*\u00020\u0001H\u0007J,\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\b\b\u0001\u0010\r*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007J&\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\b\b\u0001\u0010\r*\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\r0\u0013H\u0007J:\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\b\b\u0001\u0010\r*\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\r0\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Landroidx/paging/PagingData$Companion;", "", "()V", "NOOP_HINT_RECEIVER", "Landroidx/paging/HintReceiver;", "getNOOP_HINT_RECEIVER$paging_common", "()Landroidx/paging/HintReceiver;", "NOOP_UI_RECEIVER", "Landroidx/paging/UiReceiver;", "getNOOP_UI_RECEIVER$paging_common", "()Landroidx/paging/UiReceiver;", "empty", "Landroidx/paging/PagingData;", ExifInterface.GPS_DIRECTION_TRUE, "sourceLoadStates", "Landroidx/paging/LoadStates;", "mediatorLoadStates", "from", "data", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ PagingData empty$default(Companion r0, LoadStates r1, LoadStates r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = null;
        L6:
            return r0.empty(r1, r2);
        }

        public static /* synthetic */ PagingData from$default(Companion r1, List r2, LoadStates r3, LoadStates r4, int r5, Object r6) {
            List<? extends T> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            if ((r5 & 4) == 0) goto L6;
            r4 = null;
        L6:
            return r1.from(r7, r3, r4);
        }

        @JvmStatic
        public final <T> PagingData<T> empty() {
            return new PagingData(k.a(new PageEvent.StaticList(CollectionsKt.emptyList(), null, null)), getNOOP_UI_RECEIVER$paging_common(), getNOOP_HINT_RECEIVER$paging_common(), null, 8, null);
        }

        @JvmStatic
        public final <T> PagingData<T> empty(LoadStates r3) {
            Intrinsics.checkNotNullParameter(r3, "sourceLoadStates");
            return empty$default(this, r3, null, 2, null);
        }

        @JvmStatic
        public final <T> PagingData<T> empty(LoadStates r9, LoadStates r10) {
            Intrinsics.checkNotNullParameter(r9, "sourceLoadStates");
            return new PagingData(k.a(new PageEvent.StaticList(CollectionsKt.emptyList(), r9, r10)), getNOOP_UI_RECEIVER$paging_common(), getNOOP_HINT_RECEIVER$paging_common(), null, 8, null);
        }

        @JvmStatic
        public final <T> PagingData<T> from(List<? extends T> r6) {
            final List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "data");
            return new PagingData(k.a(new PageEvent.StaticList(r7, null, null)), getNOOP_UI_RECEIVER$paging_common(), getNOOP_HINT_RECEIVER$paging_common(), (Function0) ZeusTransformUtils.preCheckCast(new PagingData$Companion$from$1(r7), Function0.class, "com.obric.memorydata.plugin"));
        }

        @JvmStatic
        public final <T> PagingData<T> from(List<? extends T> r7, LoadStates r8) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "data");
            Intrinsics.checkNotNullParameter(r8, "sourceLoadStates");
            return from$default(this, r1, r8, null, 4, null);
        }

        @JvmStatic
        public final <T> PagingData<T> from(List<? extends T> r6, final LoadStates r7, final LoadStates r8) {
            final List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r9, "data");
            Intrinsics.checkNotNullParameter(r7, "sourceLoadStates");
            return new PagingData(k.a(new PageEvent.StaticList(r9, r7, r8)), getNOOP_UI_RECEIVER$paging_common(), getNOOP_HINT_RECEIVER$paging_common(), (Function0) ZeusTransformUtils.preCheckCast(new PagingData$Companion$from$2(r9, r7, r8), Function0.class, "com.obric.memorydata.plugin"));
        }

        public final HintReceiver getNOOP_HINT_RECEIVER$paging_common() {
            return PagingData.access$getNOOP_HINT_RECEIVER$cp();
        }

        public final UiReceiver getNOOP_UI_RECEIVER$paging_common() {
            return PagingData.access$getNOOP_UI_RECEIVER$cp();
        }
    }

    static {
        Companion = new Companion(null);
        NOOP_UI_RECEIVER = (UiReceiver) ZeusTransformUtils.preCheckCast(new PagingData$Companion$NOOP_UI_RECEIVER$1(), UiReceiver.class, "com.obric.memorydata.plugin");
        NOOP_HINT_RECEIVER = (HintReceiver) ZeusTransformUtils.preCheckCast(new PagingData$Companion$NOOP_HINT_RECEIVER$1(), HintReceiver.class, "com.obric.memorydata.plugin");
    }

    public PagingData(i<? extends PageEvent<T>> r3, UiReceiver r4, HintReceiver r5, Function0<PageEvent.Insert<T>> r6) {
        i<PageEvent<T>> r7 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        UiReceiver r8 = (UiReceiver) ZeusTransformUtils.wrapperContextForParams(r4, UiReceiver.class, "com.obric.memorydata.plugin");
        HintReceiver r9 = (HintReceiver) ZeusTransformUtils.wrapperContextForParams(r5, HintReceiver.class, "com.obric.memorydata.plugin");
        Function0<PageEvent.Insert<T>> r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "flow");
        Intrinsics.checkNotNullParameter(r8, "uiReceiver");
        Intrinsics.checkNotNullParameter(r9, "hintReceiver");
        Intrinsics.checkNotNullParameter(r10, "cachedPageEvent");
        this.flow = r7;
        this.uiReceiver = r8;
        this.hintReceiver = r9;
        this.cachedPageEvent = r10;
    }

    public /* synthetic */ PagingData(i r2, UiReceiver r3, HintReceiver r4, Function0 r5, int r6, DefaultConstructorMarker r7) {
        i r8 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.memorydata.plugin");
        UiReceiver r9 = (UiReceiver) ZeusTransformUtils.wrapperContextForParams(r3, UiReceiver.class, "com.obric.memorydata.plugin");
        HintReceiver r10 = (HintReceiver) ZeusTransformUtils.wrapperContextForParams(r4, HintReceiver.class, "com.obric.memorydata.plugin");
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        if ((r6 & 8) == 0) goto L5;
        r11 = (Function0) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
    L5:
        this(r8, r9, r10, r11);
    }

    public static final /* synthetic */ HintReceiver access$getNOOP_HINT_RECEIVER$cp() {
        return NOOP_HINT_RECEIVER;
    }

    public static final /* synthetic */ UiReceiver access$getNOOP_UI_RECEIVER$cp() {
        return NOOP_UI_RECEIVER;
    }

    @JvmStatic
    public static final <T> PagingData<T> empty() {
        return Companion.empty();
    }

    @JvmStatic
    public static final <T> PagingData<T> empty(LoadStates r1) {
        return Companion.empty(r1);
    }

    @JvmStatic
    public static final <T> PagingData<T> empty(LoadStates r1, LoadStates r2) {
        return Companion.empty(r1, r2);
    }

    @JvmStatic
    public static final <T> PagingData<T> from(List<? extends T> r2) {
        List<? extends T> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        return Companion.from(r3);
    }

    @JvmStatic
    public static final <T> PagingData<T> from(List<? extends T> r2, LoadStates r3) {
        List<? extends T> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        return Companion.from(r4, r3);
    }

    @JvmStatic
    public static final <T> PagingData<T> from(List<? extends T> r2, LoadStates r3, LoadStates r4) {
        List<? extends T> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        return Companion.from(r5, r3, r4);
    }

    public final PageEvent.Insert<T> cachedEvent$paging_common() {
        return (PageEvent.Insert) ZeusTransformUtils.preCheckCast(this.cachedPageEvent.invoke(), PageEvent.Insert.class, "com.obric.memorydata.plugin");
    }

    public final i<PageEvent<T>> getFlow$paging_common() {
        return this.flow;
    }

    public final HintReceiver getHintReceiver$paging_common() {
        return this.hintReceiver;
    }

    public final UiReceiver getUiReceiver$paging_common() {
        return this.uiReceiver;
    }
}
