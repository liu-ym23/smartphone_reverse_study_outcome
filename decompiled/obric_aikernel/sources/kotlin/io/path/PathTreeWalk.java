package kotlin.io.path;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.fragment.BuildConfig;
import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes2.dex */
@ExperimentalPathApi
public final class PathTreeWalk implements Sequence<Path> {
    private final PathWalkOption[] options;
    private final Path start;

    /* JADX INFO: renamed from: kotlin.io.path.PathTreeWalk$bfsIterator$1, reason: invalid class name */
    @DebugMetadata(c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {184, BuildConfig.VERSION_CODE}, m = "invokeSuspend", n = {"$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "queue", "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
    @SourceDebugExtension({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$bfsIterator$1\n+ 2 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk\n*L\n1#1,177:1\n45#2,15:178\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$bfsIterator$1\n*L\n98#1:178,15\n*E\n"})
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ PathTreeWalk this$0;

        AnonymousClass1(PathTreeWalk r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.this$0, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super Path> r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SequenceScope<? super Path> r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00ed -> B:11:0x007d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00ef -> B:11:0x007d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L10;
            if (r11 == 1) goto L9;
            if (r11 != 2) goto L8;
            DirectoryEntriesReader r12 = (DirectoryEntriesReader) this.L$2;
            ArrayDeque r14 = (ArrayDeque) this.L$1;
            SequenceScope r15 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r13);
        L12:
            if ((!r14.isEmpty()) == false) goto L35;
            PathNode r16 = (PathNode) r14.removeFirst();
            PathTreeWalk r17 = this.this$0;
            Path r18 = r16.getPath();
            LinkOption[] r19 = PathTreeWalk.access$getLinkOptions(r17);
            LinkOption[] r20 = (LinkOption[]) Arrays.copyOf(r19, r19.length);
            if (Files.isDirectory(r18, (LinkOption[]) Arrays.copyOf(r20, r20.length)) == true) goto L16;
            if (Files.exists(r18, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == false) goto L12;
            this.L$0 = r15;
            this.L$1 = r14;
            this.L$2 = r12;
            this.L$3 = null;
            this.L$4 = null;
            this.L$5 = null;
            this.label = 2;
            if (r15.yield(r18, this) != r10) goto L12;
            return r10;
        L16:
            if (PathTreeWalkKt.access$createsCycle(r16) == true) goto L28;
            if (PathTreeWalk.access$getIncludeDirectories(r17) == false) goto L24;
            this.L$0 = r15;
            this.L$1 = r14;
            this.L$2 = r12;
            this.L$3 = r16;
            this.L$4 = r17;
            this.L$5 = r18;
            this.label = 1;
            if (r15.yield(r18, this) != r10) goto L22;
            return r10;
        L22:
            SequenceScope r21 = r15;
            PathNode r22 = r16;
            DirectoryEntriesReader r23 = r12;
            Path r24 = r18;
            ArrayDeque r25 = r14;
            PathTreeWalk r26 = r17;
        L23:
            r16 = r22;
            r15 = r21;
            ArrayDeque r110 = r25;
            r18 = r24;
            r12 = r23;
            r17 = r26;
            r14 = r110;
        L24:
            LinkOption[] r27 = PathTreeWalk.access$getLinkOptions(r17);
            LinkOption[] r28 = (LinkOption[]) Arrays.copyOf(r27, r27.length);
            if (Files.isDirectory(r18, (LinkOption[]) Arrays.copyOf(r28, r28.length)) == false) goto L12;
            r14.addAll(r12.readEntries(r16));
            goto L12
        L28:
            throw new FileSystemLoopException(r18.toString());
        L35:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r24 = (Path) this.L$5;
            r26 = (PathTreeWalk) this.L$4;
            r22 = (PathNode) this.L$3;
            r23 = (DirectoryEntriesReader) this.L$2;
            r25 = (ArrayDeque) this.L$1;
            r21 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r13);
            goto L23
        L10:
            ResultKt.throwOnFailure(r13);
            SequenceScope r111 = (SequenceScope) this.L$0;
            ArrayDeque r29 = new ArrayDeque();
            DirectoryEntriesReader r30 = new DirectoryEntriesReader(PathTreeWalk.access$getFollowLinks(this.this$0));
            r29.addLast(new PathNode(PathTreeWalk.access$getStart$p(this.this$0), PathTreeWalkKt.access$keyOf(PathTreeWalk.access$getStart$p(this.this$0), PathTreeWalk.access$getLinkOptions(this.this$0)), null));
            r15 = r111;
            r14 = r29;
            r12 = r30;
            goto L12
        }
    }

    /* JADX INFO: renamed from: kotlin.io.path.PathTreeWalk$dfsIterator$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3}, l = {184, BuildConfig.VERSION_CODE, 199, 205}, m = "invokeSuspend", n = {"$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader", "$this$iterator", "stack", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
    @SourceDebugExtension({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$dfsIterator$1\n+ 2 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk\n*L\n1#1,177:1\n45#2,15:178\n45#2,15:193\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$dfsIterator$1\n*L\n67#1:178,15\n78#1:193,15\n*E\n"})
    static final class C04071 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ PathTreeWalk this$0;

        C04071(PathTreeWalk r10, Continuation<? super C04071> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            C04071 r12 = new C04071(this.this$0, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super Path> r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SequenceScope<? super Path> r10, Continuation<? super Unit> r11) {
            return ((C04071) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01c9 -> B:36:0x013c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x01cb -> B:36:0x013c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r19) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L14;
            if (r11 == 1) goto L13;
            if (r11 == 2) goto L12;
            if (r11 == 3) goto L11;
            if (r11 == 4) goto L12;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            Path r12 = (Path) this.L$5;
            PathTreeWalk r13 = (PathTreeWalk) this.L$4;
            PathNode r14 = (PathNode) this.L$3;
            DirectoryEntriesReader r15 = (DirectoryEntriesReader) this.L$2;
            ArrayDeque r16 = (ArrayDeque) this.L$1;
            SequenceScope r17 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r19);
        L50:
            SequenceScope r18 = r17;
            Path r110 = r12;
            DirectoryEntriesReader r20 = r15;
            PathNode r111 = r14;
            SequenceScope r21 = r18;
            ArrayDeque r112 = r16;
            PathTreeWalk r113 = r13;
            ArrayDeque r22 = r112;
        L51:
            LinkOption[] r114 = PathTreeWalk.access$getLinkOptions(r113);
            LinkOption[] r115 = (LinkOption[]) Arrays.copyOf(r114, r114.length);
            if (Files.isDirectory(r110, (LinkOption[]) Arrays.copyOf(r115, r115.length)) == false) goto L37;
            r111.setContentIterator(r20.readEntries(r111).iterator());
            r22.addLast(r111);
        L37:
            if ((!r22.isEmpty()) == false) goto L63;
            Iterator<PathNode> r116 = ((PathNode) r22.last()).getContentIterator();
            Intrinsics.checkNotNull(r116);
            if (r116.hasNext() == true) goto L40;
            r22.removeLast();
            goto L37
        L40:
            r111 = r116.next();
            r113 = this.this$0;
            r110 = r111.getPath();
            LinkOption[] r117 = PathTreeWalk.access$getLinkOptions(r113);
            LinkOption[] r118 = (LinkOption[]) Arrays.copyOf(r117, r117.length);
            if (Files.isDirectory(r110, (LinkOption[]) Arrays.copyOf(r118, r118.length)) == true) goto L43;
            if (Files.exists(r110, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == false) goto L37;
            this.L$0 = r21;
            this.L$1 = r22;
            this.L$2 = r20;
            this.L$3 = null;
            this.L$4 = null;
            this.L$5 = null;
            this.label = 4;
            if (r21.yield(r110, this) != r10) goto L37;
            return r10;
        L43:
            if (PathTreeWalkKt.access$createsCycle(r111) == true) goto L55;
            if (PathTreeWalk.access$getIncludeDirectories(r113) == false) goto L51;
            this.L$0 = r21;
            this.L$1 = r22;
            this.L$2 = r20;
            this.L$3 = r111;
            this.L$4 = r113;
            this.L$5 = r110;
            this.label = 3;
            if (r21.yield(r110, this) != r10) goto L49;
            return r10;
        L49:
            r15 = r20;
            r12 = r110;
            r17 = r21;
            r14 = r111;
            r16 = r22;
            r13 = r113;
            goto L50
        L55:
            throw new FileSystemLoopException(r110.toString());
        L63:
            return Unit.INSTANCE;
        L12:
            r20 = (DirectoryEntriesReader) this.L$2;
            r22 = (ArrayDeque) this.L$1;
            r21 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r19);
            goto L37
        L13:
            Path r23 = (Path) this.L$5;
            PathTreeWalk r24 = (PathTreeWalk) this.L$4;
            PathNode r25 = (PathNode) this.L$3;
            DirectoryEntriesReader r119 = (DirectoryEntriesReader) this.L$2;
            ArrayDeque r120 = (ArrayDeque) this.L$1;
            SequenceScope r121 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r19);
        L24:
            Path r122 = r23;
            ArrayDeque r26 = r120;
            PathNode r123 = r25;
            r21 = r121;
            PathTreeWalk r124 = r24;
        L25:
            LinkOption[] r27 = PathTreeWalk.access$getLinkOptions(r124);
            LinkOption[] r28 = (LinkOption[]) Arrays.copyOf(r27, r27.length);
            if (Files.isDirectory(r122, (LinkOption[]) Arrays.copyOf(r28, r28.length)) == false) goto L35;
            r123.setContentIterator(r119.readEntries(r123).iterator());
            r26.addLast(r123);
        L35:
            r22 = r26;
            r20 = r119;
            goto L37
        L14:
            ResultKt.throwOnFailure(r19);
            r21 = (SequenceScope) this.L$0;
            r26 = new ArrayDeque();
            r119 = new DirectoryEntriesReader(PathTreeWalk.access$getFollowLinks(this.this$0));
            r123 = new PathNode(PathTreeWalk.access$getStart$p(this.this$0), PathTreeWalkKt.access$keyOf(PathTreeWalk.access$getStart$p(this.this$0), PathTreeWalk.access$getLinkOptions(this.this$0)), null);
            r124 = this.this$0;
            r122 = r123.getPath();
            LinkOption[] r125 = PathTreeWalk.access$getLinkOptions(r124);
            LinkOption[] r126 = (LinkOption[]) Arrays.copyOf(r125, r125.length);
            if (Files.isDirectory(r122, (LinkOption[]) Arrays.copyOf(r126, r126.length)) == false) goto L31;
            if (PathTreeWalkKt.access$createsCycle(r123) == true) goto L29;
            if (PathTreeWalk.access$getIncludeDirectories(r124) == false) goto L25;
            this.L$0 = r21;
            this.L$1 = r26;
            this.L$2 = r119;
            this.L$3 = r123;
            this.L$4 = r124;
            this.L$5 = r122;
            this.label = 1;
            if (r21.yield(r122, this) != r10) goto L23;
            return r10;
        L23:
            r24 = r124;
            r121 = r21;
            r25 = r123;
            r120 = r26;
            r23 = r122;
            goto L24
        L29:
            throw new FileSystemLoopException(r122.toString());
        L31:
            if (Files.exists(r122, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == false) goto L35;
            this.L$0 = r21;
            this.L$1 = r26;
            this.L$2 = r119;
            this.label = 2;
            if (r21.yield(r122, this) != r10) goto L35;
            return r10;
        }
    }

    public PathTreeWalk(Path r10, PathWalkOption[] r11) {
        Intrinsics.checkNotNullParameter(r10, CommonConsts.APM_INNER_EVENT_COST_START);
        Intrinsics.checkNotNullParameter(r11, "options");
        this.start = r10;
        this.options = r11;
    }

    public static final /* synthetic */ boolean access$getFollowLinks(PathTreeWalk r10) {
        return r10.getFollowLinks();
    }

    public static final /* synthetic */ boolean access$getIncludeDirectories(PathTreeWalk r10) {
        return r10.getIncludeDirectories();
    }

    public static final /* synthetic */ LinkOption[] access$getLinkOptions(PathTreeWalk r10) {
        return r10.getLinkOptions();
    }

    public static final /* synthetic */ Path access$getStart$p(PathTreeWalk r10) {
        return r10.start;
    }

    private final Iterator<Path> bfsIterator() {
        return SequencesKt.iterator(new AnonymousClass1(this, null));
    }

    private final Iterator<Path> dfsIterator() {
        return SequencesKt.iterator(new C04071(this, null));
    }

    private final boolean getFollowLinks() {
        return ArraysKt.contains(this.options, PathWalkOption.FOLLOW_LINKS);
    }

    private final boolean getIncludeDirectories() {
        return ArraysKt.contains(this.options, PathWalkOption.INCLUDE_DIRECTORIES);
    }

    private final LinkOption[] getLinkOptions() {
        return LinkFollowing.INSTANCE.toLinkOptions(getFollowLinks());
    }

    private final boolean isBFS() {
        return ArraysKt.contains(this.options, PathWalkOption.BREADTH_FIRST);
    }

    private final Object yieldIfNeeded(SequenceScope<? super Path> r10, PathNode r11, DirectoryEntriesReader r12, Function1<? super List<PathNode>, Unit> r13, Continuation<? super Unit> r14) {
        Path r15 = r11.getPath();
        LinkOption[] r16 = access$getLinkOptions(this);
        LinkOption[] r17 = (LinkOption[]) Arrays.copyOf(r16, r16.length);
        if (Files.isDirectory(r15, (LinkOption[]) Arrays.copyOf(r17, r17.length)) == false) goto L15;
        if (PathTreeWalkKt.access$createsCycle(r11) == true) goto L13;
        if (access$getIncludeDirectories(this) == false) goto L9;
        InlineMarker.mark(0);
        r10.yield(r15, r14);
        InlineMarker.mark(1);
    L9:
        LinkOption[] r18 = access$getLinkOptions(this);
        LinkOption[] r19 = (LinkOption[]) Arrays.copyOf(r18, r18.length);
        if (Files.isDirectory(r15, (LinkOption[]) Arrays.copyOf(r19, r19.length)) == false) goto L19;
        r13.invoke(r12.readEntries(r11));
    L19:
        return Unit.INSTANCE;
    L13:
        throw new FileSystemLoopException(r15.toString());
    L15:
        if (Files.exists(r15, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == false) goto L19;
        InlineMarker.mark(0);
        r10.yield(r15, r14);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<Path> iterator() {
        if (isBFS() == false) goto L6;
        return bfsIterator();
    L6:
        return dfsIterator();
    }
}
