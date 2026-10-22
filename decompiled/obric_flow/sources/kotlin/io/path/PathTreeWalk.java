package kotlin.io.path;

import cn.nubia.neopush.commons.Constant;
import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
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

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0002J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0096\u0002JB\u0010\u0018\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0018\u0010\u001f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0!\u0012\u0004\u0012\u00020\u00190 H\u0082H¢\u0006\u0002\u0010\"R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lkotlin/io/path/PathTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/nio/file/Path;", "start", "options", "", "Lkotlin/io/path/PathWalkOption;", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)V", "followLinks", "", "getFollowLinks", "()Z", "includeDirectories", "getIncludeDirectories", "isBFS", "linkOptions", "Ljava/nio/file/LinkOption;", "getLinkOptions", "()[Ljava/nio/file/LinkOption;", "[Lkotlin/io/path/PathWalkOption;", "bfsIterator", "", "dfsIterator", "iterator", "yieldIfNeeded", "", "Lkotlin/sequences/SequenceScope;", "node", "Lkotlin/io/path/PathNode;", "entriesReader", "Lkotlin/io/path/DirectoryEntriesReader;", "entriesAction", "Lkotlin/Function1;", "", "(Lkotlin/sequences/SequenceScope;Lkotlin/io/path/PathNode;Lkotlin/io/path/DirectoryEntriesReader;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
@ExperimentalPathApi
public final class PathTreeWalk implements Sequence<Path> {
    private final PathWalkOption[] options;
    private final Path start;

    /* JADX INFO: renamed from: kotlin.io.path.PathTreeWalk$bfsIterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {192, 198}, m = "invokeSuspend", n = {"$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "queue", "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
    @SourceDebugExtension({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$bfsIterator$1\n+ 2 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk\n*L\n1#1,181:1\n45#2,19:182\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$bfsIterator$1\n*L\n102#1:182,19\n*E\n"})
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ PathTreeWalk this$0;

        public AnonymousClass1(PathTreeWalk r5, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            AnonymousClass1 r11 = new AnonymousClass1(this.this$0, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(SequenceScope<? super Path> r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00f5 -> B:11:0x007d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00f7 -> B:11:0x007d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.label;
            if (r10 == 0) goto L10;
            if (r10 == 1) goto L9;
            if (r10 != 2) goto L8;
            DirectoryEntriesReader r11 = (DirectoryEntriesReader) this.L$2;
            ArrayDeque r12 = (ArrayDeque) this.L$1;
            SequenceScope r14 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r13);
        L12:
            if (r12.isEmpty() == true) goto L38;
            PathNode r15 = (PathNode) r12.removeFirst();
            PathTreeWalk r16 = this.this$0;
            Path r17 = r15.getPath();
            if (r15.getParent() == null) goto L16;
            PathsKt__PathRecursiveFunctionsKt.checkFileName(r17);
        L16:
            LinkOption[] r18 = PathTreeWalk.access$getLinkOptions(r16);
            LinkOption[] r19 = (LinkOption[]) Arrays.copyOf(r18, r18.length);
            if (Files.isDirectory(r17, (LinkOption[]) Arrays.copyOf(r19, r19.length)) == true) goto L19;
            if (Files.exists(r17, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == false) goto L12;
            this.L$0 = r14;
            this.L$1 = r12;
            this.L$2 = r11;
            this.L$3 = null;
            this.L$4 = null;
            this.L$5 = null;
            this.label = 2;
            if (r14.yield(r17, this) != r5) goto L12;
            return r5;
        L19:
            if (PathTreeWalkKt.access$createsCycle(r15) == true) goto L31;
            if (PathTreeWalk.access$getIncludeDirectories(r16) == false) goto L27;
            this.L$0 = r14;
            this.L$1 = r12;
            this.L$2 = r11;
            this.L$3 = r15;
            this.L$4 = r16;
            this.L$5 = r17;
            this.label = 1;
            if (r14.yield(r17, this) != r5) goto L25;
            return r5;
        L25:
            SequenceScope r20 = r14;
            PathNode r21 = r15;
            DirectoryEntriesReader r22 = r11;
            Path r23 = r17;
            ArrayDeque r24 = r12;
            PathTreeWalk r25 = r16;
        L26:
            r15 = r21;
            r14 = r20;
            ArrayDeque r110 = r24;
            r17 = r23;
            r11 = r22;
            r16 = r25;
            r12 = r110;
        L27:
            LinkOption[] r26 = PathTreeWalk.access$getLinkOptions(r16);
            LinkOption[] r27 = (LinkOption[]) Arrays.copyOf(r26, r26.length);
            if (Files.isDirectory(r17, (LinkOption[]) Arrays.copyOf(r27, r27.length)) == false) goto L12;
            r12.addAll(r11.readEntries(r15));
            goto L12
        L31:
            throw new FileSystemLoopException(r17.toString());
        L38:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r23 = (Path) this.L$5;
            r25 = (PathTreeWalk) this.L$4;
            r21 = (PathNode) this.L$3;
            r22 = (DirectoryEntriesReader) this.L$2;
            r24 = (ArrayDeque) this.L$1;
            r20 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r13);
            goto L26
        L10:
            ResultKt.throwOnFailure(r13);
            SequenceScope r111 = (SequenceScope) this.L$0;
            ArrayDeque r28 = new ArrayDeque();
            DirectoryEntriesReader r29 = new DirectoryEntriesReader(PathTreeWalk.access$getFollowLinks(this.this$0));
            r28.addLast(new PathNode(PathTreeWalk.access$getStart$p(this.this$0), PathTreeWalkKt.access$keyOf(PathTreeWalk.access$getStart$p(this.this$0), PathTreeWalk.access$getLinkOptions(this.this$0)), null));
            r14 = r111;
            r12 = r28;
            r11 = r29;
            goto L12
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SequenceScope<? super Path> r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: kotlin.io.path.PathTreeWalk$dfsIterator$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3}, l = {192, 198, 211, Constant.SDK_VERSION}, m = "invokeSuspend", n = {"$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader", "$this$iterator", "stack", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
    @SourceDebugExtension({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$dfsIterator$1\n+ 2 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk\n*L\n1#1,181:1\n45#2,19:182\n45#2,19:201\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$dfsIterator$1\n*L\n71#1:182,19\n82#1:201,19\n*E\n"})
    public static final class C02191 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ PathTreeWalk this$0;

        public C02191(PathTreeWalk r5, Continuation<? super C02191> r10) {
            this.this$0 = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            C02191 r11 = new C02191(this.this$0, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(SequenceScope<? super Path> r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x01d0 -> B:39:0x0145). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x01d2 -> B:39:0x0145). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r15) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.label;
            if (r10 == 0) goto L14;
            if (r10 == 1) goto L13;
            if (r10 == 2) goto L12;
            if (r10 == 3) goto L11;
            if (r10 == 4) goto L12;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            Path r11 = (Path) this.L$5;
            PathTreeWalk r12 = (PathTreeWalk) this.L$4;
            PathNode r13 = (PathNode) this.L$3;
            DirectoryEntriesReader r14 = (DirectoryEntriesReader) this.L$2;
            ArrayDeque r16 = (ArrayDeque) this.L$1;
            SequenceScope r17 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r15);
        L56:
            PathNode r18 = r13;
            SequenceScope r19 = r17;
            ArrayDeque r110 = r16;
            Path r20 = r11;
            DirectoryEntriesReader r21 = r14;
            PathTreeWalk r22 = r12;
            ArrayDeque r23 = r110;
        L57:
            LinkOption[] r24 = PathTreeWalk.access$getLinkOptions(r22);
            LinkOption[] r25 = (LinkOption[]) Arrays.copyOf(r24, r24.length);
            if (Files.isDirectory(r20, (LinkOption[]) Arrays.copyOf(r25, r25.length)) == false) goto L40;
            r18.setContentIterator(r21.readEntries(r18).iterator());
            r23.addLast(r18);
        L40:
            if (r23.isEmpty() == true) goto L69;
            Iterator<PathNode> r111 = ((PathNode) r23.last()).getContentIterator();
            Intrinsics.checkNotNull(r111);
            if (r111.hasNext() == true) goto L43;
            r23.removeLast();
            goto L40
        L43:
            r18 = r111.next();
            r22 = this.this$0;
            r20 = r18.getPath();
            if (r18.getParent() == null) goto L46;
            PathsKt__PathRecursiveFunctionsKt.checkFileName(r20);
        L46:
            LinkOption[] r112 = PathTreeWalk.access$getLinkOptions(r22);
            LinkOption[] r113 = (LinkOption[]) Arrays.copyOf(r112, r112.length);
            if (Files.isDirectory(r20, (LinkOption[]) Arrays.copyOf(r113, r113.length)) == true) goto L49;
            if (Files.exists(r20, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == false) goto L40;
            this.L$0 = r19;
            this.L$1 = r23;
            this.L$2 = r21;
            this.L$3 = null;
            this.L$4 = null;
            this.L$5 = null;
            this.label = 4;
            if (r19.yield(r20, this) != r5) goto L40;
            return r5;
        L49:
            if (PathTreeWalkKt.access$createsCycle(r18) == true) goto L61;
            if (PathTreeWalk.access$getIncludeDirectories(r22) == false) goto L57;
            this.L$0 = r19;
            this.L$1 = r23;
            this.L$2 = r21;
            this.L$3 = r18;
            this.L$4 = r22;
            this.L$5 = r20;
            this.label = 3;
            if (r19.yield(r20, this) != r5) goto L55;
            return r5;
        L55:
            r17 = r19;
            r13 = r18;
            r14 = r21;
            r11 = r20;
            r16 = r23;
            r12 = r22;
            goto L56
        L61:
            throw new FileSystemLoopException(r20.toString());
        L69:
            return Unit.INSTANCE;
        L12:
            r21 = (DirectoryEntriesReader) this.L$2;
            r23 = (ArrayDeque) this.L$1;
            r19 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r15);
            goto L40
        L13:
            Path r26 = (Path) this.L$5;
            PathTreeWalk r27 = (PathTreeWalk) this.L$4;
            PathNode r28 = (PathNode) this.L$3;
            DirectoryEntriesReader r29 = (DirectoryEntriesReader) this.L$2;
            ArrayDeque r30 = (ArrayDeque) this.L$1;
            SequenceScope r114 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r15);
        L27:
            ArrayDeque r115 = r30;
            PathTreeWalk r31 = r27;
            SequenceScope r116 = r114;
            Path r117 = r26;
            r21 = r29;
            PathNode r32 = r28;
            r19 = r116;
        L28:
            LinkOption[] r33 = PathTreeWalk.access$getLinkOptions(r31);
            LinkOption[] r34 = (LinkOption[]) Arrays.copyOf(r33, r33.length);
            if (Files.isDirectory(r117, (LinkOption[]) Arrays.copyOf(r34, r34.length)) == false) goto L31;
            r32.setContentIterator(r21.readEntries(r32).iterator());
            r115.addLast(r32);
        L31:
            r23 = r115;
            goto L40
        L14:
            ResultKt.throwOnFailure(r15);
            r19 = (SequenceScope) this.L$0;
            r115 = new ArrayDeque();
            r21 = new DirectoryEntriesReader(PathTreeWalk.access$getFollowLinks(this.this$0));
            r32 = new PathNode(PathTreeWalk.access$getStart$p(this.this$0), PathTreeWalkKt.access$keyOf(PathTreeWalk.access$getStart$p(this.this$0), PathTreeWalk.access$getLinkOptions(this.this$0)), null);
            r31 = this.this$0;
            r117 = r32.getPath();
            if (r32.getParent() == null) goto L17;
            PathsKt__PathRecursiveFunctionsKt.checkFileName(r117);
        L17:
            LinkOption[] r118 = PathTreeWalk.access$getLinkOptions(r31);
            LinkOption[] r119 = (LinkOption[]) Arrays.copyOf(r118, r118.length);
            if (Files.isDirectory(r117, (LinkOption[]) Arrays.copyOf(r119, r119.length)) == false) goto L35;
            if (PathTreeWalkKt.access$createsCycle(r32) == true) goto L33;
            if (PathTreeWalk.access$getIncludeDirectories(r31) == false) goto L28;
            this.L$0 = r19;
            this.L$1 = r115;
            this.L$2 = r21;
            this.L$3 = r32;
            this.L$4 = r31;
            this.L$5 = r117;
            this.label = 1;
            if (r19.yield(r117, this) != r5) goto L26;
            return r5;
        L26:
            r27 = r31;
            r30 = r115;
            r29 = r21;
            r26 = r117;
            r114 = r19;
            r28 = r32;
            goto L27
        L33:
            throw new FileSystemLoopException(r117.toString());
        L35:
            if (Files.exists(r117, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == false) goto L31;
            this.L$0 = r19;
            this.L$1 = r115;
            this.L$2 = r21;
            this.label = 2;
            if (r19.yield(r117, this) != r5) goto L31;
            return r5;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SequenceScope<? super Path> r5, Continuation<? super Unit> r10) {
            return ((C02191) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public PathTreeWalk(Path r5, PathWalkOption[] r10) {
        Intrinsics.checkNotNullParameter(r5, "start");
        Intrinsics.checkNotNullParameter(r10, "options");
        this.start = r5;
        this.options = r10;
    }

    public static final /* synthetic */ boolean access$getFollowLinks(PathTreeWalk r5) {
        return r5.getFollowLinks();
    }

    public static final /* synthetic */ boolean access$getIncludeDirectories(PathTreeWalk r5) {
        return r5.getIncludeDirectories();
    }

    public static final /* synthetic */ LinkOption[] access$getLinkOptions(PathTreeWalk r5) {
        return r5.getLinkOptions();
    }

    public static final /* synthetic */ Path access$getStart$p(PathTreeWalk r5) {
        return r5.start;
    }

    private final Iterator<Path> bfsIterator() {
        return SequencesKt.iterator(new AnonymousClass1(this, null));
    }

    private final Iterator<Path> dfsIterator() {
        return SequencesKt.iterator(new C02191(this, null));
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

    private final Object yieldIfNeeded(SequenceScope<? super Path> r5, PathNode r10, DirectoryEntriesReader r11, Function1<? super List<PathNode>, Unit> r12, Continuation<? super Unit> r13) {
        Path r14 = r10.getPath();
        if (r10.getParent() == null) goto L5;
        PathsKt__PathRecursiveFunctionsKt.checkFileName(r14);
    L5:
        LinkOption[] r15 = access$getLinkOptions(this);
        LinkOption[] r16 = (LinkOption[]) Arrays.copyOf(r15, r15.length);
        if (Files.isDirectory(r14, (LinkOption[]) Arrays.copyOf(r16, r16.length)) == false) goto L18;
        if (PathTreeWalkKt.access$createsCycle(r10) == true) goto L16;
        if (access$getIncludeDirectories(this) == false) goto L12;
        InlineMarker.mark(0);
        r5.yield(r14, r13);
        InlineMarker.mark(1);
    L12:
        LinkOption[] r17 = access$getLinkOptions(this);
        LinkOption[] r18 = (LinkOption[]) Arrays.copyOf(r17, r17.length);
        if (Files.isDirectory(r14, (LinkOption[]) Arrays.copyOf(r18, r18.length)) == false) goto L22;
        r12.invoke(r11.readEntries(r10));
    L22:
        return Unit.INSTANCE;
    L16:
        throw new FileSystemLoopException(r14.toString());
    L18:
        if (Files.exists(r14, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == false) goto L22;
        InlineMarker.mark(0);
        r5.yield(r14, r13);
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
