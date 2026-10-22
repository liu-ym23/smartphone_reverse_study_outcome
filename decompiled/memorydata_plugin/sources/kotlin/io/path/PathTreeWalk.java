package kotlin.io.path;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
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
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0002J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0096\u0002JB\u0010\u0018\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0018\u0010\u001f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0!\u0012\u0004\u0012\u00020\u00190 H\u0082H¢\u0006\u0002\u0010\"R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lkotlin/io/path/PathTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/nio/file/Path;", CommonConsts.APM_INNER_EVENT_COST_START, "options", "", "Lkotlin/io/path/PathWalkOption;", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)V", "followLinks", "", "getFollowLinks", "()Z", "includeDirectories", "getIncludeDirectories", "isBFS", "linkOptions", "Ljava/nio/file/LinkOption;", "getLinkOptions", "()[Ljava/nio/file/LinkOption;", "[Lkotlin/io/path/PathWalkOption;", "bfsIterator", "", "dfsIterator", "iterator", "yieldIfNeeded", "", "Lkotlin/sequences/SequenceScope;", "node", "Lkotlin/io/path/PathNode;", "entriesReader", "Lkotlin/io/path/DirectoryEntriesReader;", "entriesAction", "Lkotlin/Function1;", "", "(Lkotlin/sequences/SequenceScope;Lkotlin/io/path/PathNode;Lkotlin/io/path/DirectoryEntriesReader;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PathTreeWalk implements Sequence<Path> {
    private final PathWalkOption[] options;
    private final Path start;

    /* JADX INFO: renamed from: kotlin.io.path.PathTreeWalk$bfsIterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {192, 198}, m = "invokeSuspend", n = {"$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "queue", "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ PathTreeWalk this$0;

        AnonymousClass1(PathTreeWalk r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r5);
            r0.L$0 = r3;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(SequenceScope<? super Path> r3, Continuation<? super Unit> r4) {
            return invoke2((SequenceScope) ZeusTransformUtils.preCheckCast(r3, SequenceScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SequenceScope<? super Path> r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0163 -> B:11:0x00bc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0165 -> B:11:0x00bc). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            DirectoryEntriesReader r2 = (DirectoryEntriesReader) ZeusTransformUtils.preCheckCast(this.L$2, DirectoryEntriesReader.class, "com.obric.memorydata.plugin");
            ArrayDeque r6 = (ArrayDeque) ZeusTransformUtils.preCheckCast(this.L$1, ArrayDeque.class, "com.obric.memorydata.plugin");
            SequenceScope r7 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r14);
        L12:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L38;
            PathNode r15 = (PathNode) ZeusTransformUtils.preCheckCast(r6.removeFirst(), PathNode.class, "com.obric.memorydata.plugin");
            PathTreeWalk r8 = this.this$0;
            Path r9 = r15.getPath();
            if (r15.getParent() == null) goto L16;
            PathsKt.checkFileName(r9);
        L16:
            LinkOption[] r10 = PathTreeWalk.access$getLinkOptions(r8);
            LinkOption[] r11 = (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r10, r10.length), LinkOption[].class, "com.obric.memorydata.plugin");
            if (Files.isDirectory(r9, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r11, r11.length), LinkOption[].class, "com.obric.memorydata.plugin")) == true) goto L19;
            if (Files.exists(r9, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1), LinkOption[].class, "com.obric.memorydata.plugin")) == false) goto L12;
            Continuation<? super Unit> r16 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r7;
            this.L$1 = r6;
            this.L$2 = r2;
            this.L$3 = null;
            this.L$4 = null;
            this.L$5 = null;
            this.label = 2;
            if (r7.yield(r9, r16) != r0) goto L12;
            return r0;
        L19:
            if (PathTreeWalkKt.access$createsCycle(r15) == true) goto L31;
            if (PathTreeWalk.access$getIncludeDirectories(r8) == false) goto L27;
            Continuation<? super Unit> r12 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r7;
            this.L$1 = r6;
            this.L$2 = r2;
            this.L$3 = r15;
            this.L$4 = r8;
            this.L$5 = r9;
            this.label = 1;
            if (r7.yield(r9, r12) != r0) goto L25;
            return r0;
        L25:
            SequenceScope r13 = r7;
            PathNode r17 = r15;
            DirectoryEntriesReader r18 = r2;
            Path r3 = r9;
            ArrayDeque r19 = r6;
            PathTreeWalk r20 = r8;
        L26:
            r15 = r17;
            r7 = r13;
            ArrayDeque r110 = r19;
            r9 = r3;
            r2 = r18;
            r8 = r20;
            r6 = r110;
        L27:
            LinkOption[] r21 = PathTreeWalk.access$getLinkOptions(r8);
            LinkOption[] r22 = (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r21, r21.length), LinkOption[].class, "com.obric.memorydata.plugin");
            if (Files.isDirectory(r9, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r22, r22.length), LinkOption[].class, "com.obric.memorydata.plugin")) == false) goto L12;
            r6.addAll((Collection) ZeusTransformUtils.preCheckCast(r2.readEntries(r15), Collection.class, "com.obric.memorydata.plugin"));
            goto L12
        L31:
            throw new FileSystemLoopException(r9.toString());
        L38:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r3 = (Path) ZeusTransformUtils.preCheckCast(this.L$5, Path.class, "com.obric.memorydata.plugin");
            r20 = (PathTreeWalk) ZeusTransformUtils.preCheckCast(this.L$4, PathTreeWalk.class, "com.obric.memorydata.plugin");
            r17 = (PathNode) ZeusTransformUtils.preCheckCast(this.L$3, PathNode.class, "com.obric.memorydata.plugin");
            r18 = (DirectoryEntriesReader) ZeusTransformUtils.preCheckCast(this.L$2, DirectoryEntriesReader.class, "com.obric.memorydata.plugin");
            r19 = (ArrayDeque) ZeusTransformUtils.preCheckCast(this.L$1, ArrayDeque.class, "com.obric.memorydata.plugin");
            r13 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r14);
            goto L26
        L10:
            ResultKt.throwOnFailure(r14);
            SequenceScope r111 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
            ArrayDeque r4 = new ArrayDeque();
            DirectoryEntriesReader r23 = new DirectoryEntriesReader(PathTreeWalk.access$getFollowLinks(this.this$0));
            r4.addLast(new PathNode(PathTreeWalk.access$getStart$p(this.this$0), PathTreeWalkKt.access$keyOf(PathTreeWalk.access$getStart$p(this.this$0), PathTreeWalk.access$getLinkOptions(this.this$0)), null));
            r7 = r111;
            r6 = r4;
            r2 = r23;
            goto L12
        }
    }

    /* JADX INFO: renamed from: kotlin.io.path.PathTreeWalk$dfsIterator$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3}, l = {192, 198, 211, 217}, m = "invokeSuspend", n = {"$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader", "$this$iterator", "stack", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
    static final class C12521 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ PathTreeWalk this$0;

        C12521(PathTreeWalk r3, Continuation<? super C12521> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            C12521 r0 = new C12521(this.this$0, r5);
            r0.L$0 = r3;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(SequenceScope<? super Path> r3, Continuation<? super Unit> r4) {
            return invoke2((SequenceScope) ZeusTransformUtils.preCheckCast(r3, SequenceScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SequenceScope<? super Path> r3, Continuation<? super Unit> r4) {
            return ((C12521) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12521.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x02bc -> B:39:0x01f8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x02be -> B:39:0x01f8). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r18) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L14;
            if (r2 == 1) goto L13;
            if (r2 == 2) goto L12;
            if (r2 == 3) goto L11;
            if (r2 != 4) goto L10;
            DirectoryEntriesReader r3 = (DirectoryEntriesReader) ZeusTransformUtils.preCheckCast(this.L$2, DirectoryEntriesReader.class, "com.obric.memorydata.plugin");
            ArrayDeque r6 = (ArrayDeque) ZeusTransformUtils.preCheckCast(this.L$1, ArrayDeque.class, "com.obric.memorydata.plugin");
            SequenceScope r10 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r18);
        L40:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L70;
            Iterator<PathNode> r4 = ((PathNode) ZeusTransformUtils.preCheckCast(r6.last(), PathNode.class, "com.obric.memorydata.plugin")).getContentIterator();
            Intrinsics.checkNotNull(r4);
            if (r4.hasNext() == true) goto L43;
            r6.removeLast();
            goto L40
        L43:
            PathNode r5 = (PathNode) ZeusTransformUtils.preCheckCast(r4.next(), PathNode.class, "com.obric.memorydata.plugin");
            PathTreeWalk r11 = this.this$0;
            Path r12 = r5.getPath();
            if (r5.getParent() == null) goto L46;
            PathsKt.checkFileName(r12);
        L46:
            LinkOption[] r13 = PathTreeWalk.access$getLinkOptions(r11);
            LinkOption[] r14 = (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r13, r13.length), LinkOption[].class, "com.obric.memorydata.plugin");
            if (Files.isDirectory(r12, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r14, r14.length), LinkOption[].class, "com.obric.memorydata.plugin")) == true) goto L49;
            if (Files.exists(r12, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1), LinkOption[].class, "com.obric.memorydata.plugin")) == false) goto L40;
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r10;
            this.L$1 = r6;
            this.L$2 = r3;
            this.L$3 = null;
            this.L$4 = null;
            this.L$5 = null;
            this.label = 4;
            if (r10.yield(r12, r7) != r1) goto L40;
            return r1;
        L49:
            if (PathTreeWalkKt.access$createsCycle(r5) == true) goto L61;
            if (PathTreeWalk.access$getIncludeDirectories(r11) == false) goto L57;
            Continuation<? super Unit> r15 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r10;
            this.L$1 = r6;
            this.L$2 = r3;
            this.L$3 = r5;
            this.L$4 = r11;
            this.L$5 = r12;
            this.label = 3;
            if (r10.yield(r12, r15) != r1) goto L55;
            return r1;
        L55:
            SequenceScope r16 = r10;
            PathNode r17 = r5;
            DirectoryEntriesReader r19 = r3;
            Path r8 = r12;
            ArrayDeque r110 = r6;
            PathTreeWalk r9 = r11;
        L56:
            r5 = r17;
            r10 = r16;
            ArrayDeque r111 = r110;
            r12 = r8;
            r3 = r19;
            r11 = r9;
            r6 = r111;
        L57:
            LinkOption[] r112 = PathTreeWalk.access$getLinkOptions(r11);
            LinkOption[] r113 = (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r112, r112.length), LinkOption[].class, "com.obric.memorydata.plugin");
            if (Files.isDirectory(r12, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r113, r113.length), LinkOption[].class, "com.obric.memorydata.plugin")) == false) goto L40;
            r5.setContentIterator(r3.readEntries(r5).iterator());
            r6.addLast(r5);
            goto L40
        L61:
            throw new FileSystemLoopException(r12.toString());
        L70:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            r8 = (Path) ZeusTransformUtils.preCheckCast(this.L$5, Path.class, "com.obric.memorydata.plugin");
            r9 = (PathTreeWalk) ZeusTransformUtils.preCheckCast(this.L$4, PathTreeWalk.class, "com.obric.memorydata.plugin");
            r17 = (PathNode) ZeusTransformUtils.preCheckCast(this.L$3, PathNode.class, "com.obric.memorydata.plugin");
            r19 = (DirectoryEntriesReader) ZeusTransformUtils.preCheckCast(this.L$2, DirectoryEntriesReader.class, "com.obric.memorydata.plugin");
            r110 = (ArrayDeque) ZeusTransformUtils.preCheckCast(this.L$1, ArrayDeque.class, "com.obric.memorydata.plugin");
            r16 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r18);
            goto L56
        L12:
            r3 = (DirectoryEntriesReader) ZeusTransformUtils.preCheckCast(this.L$2, DirectoryEntriesReader.class, "com.obric.memorydata.plugin");
            r6 = (ArrayDeque) ZeusTransformUtils.preCheckCast(this.L$1, ArrayDeque.class, "com.obric.memorydata.plugin");
            r10 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r18);
            goto L40
        L13:
            Path r20 = (Path) ZeusTransformUtils.preCheckCast(this.L$5, Path.class, "com.obric.memorydata.plugin");
            PathTreeWalk r21 = (PathTreeWalk) ZeusTransformUtils.preCheckCast(this.L$4, PathTreeWalk.class, "com.obric.memorydata.plugin");
            PathNode r114 = (PathNode) ZeusTransformUtils.preCheckCast(this.L$3, PathNode.class, "com.obric.memorydata.plugin");
            DirectoryEntriesReader r115 = (DirectoryEntriesReader) ZeusTransformUtils.preCheckCast(this.L$2, DirectoryEntriesReader.class, "com.obric.memorydata.plugin");
            ArrayDeque r116 = (ArrayDeque) ZeusTransformUtils.preCheckCast(this.L$1, ArrayDeque.class, "com.obric.memorydata.plugin");
            SequenceScope r117 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r18);
        L27:
            Path r118 = r20;
            ArrayDeque r22 = r116;
            PathNode r119 = r114;
            r10 = r117;
            PathTreeWalk r120 = r21;
        L28:
            LinkOption[] r23 = PathTreeWalk.access$getLinkOptions(r120);
            LinkOption[] r24 = (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r23, r23.length), LinkOption[].class, "com.obric.memorydata.plugin");
            if (Files.isDirectory(r118, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r24, r24.length), LinkOption[].class, "com.obric.memorydata.plugin")) == false) goto L38;
            r119.setContentIterator(r115.readEntries(r119).iterator());
            r22.addLast(r119);
        L38:
            r6 = r22;
            r3 = r115;
            goto L40
        L14:
            ResultKt.throwOnFailure(r18);
            r10 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
            r22 = new ArrayDeque();
            r115 = new DirectoryEntriesReader(PathTreeWalk.access$getFollowLinks(this.this$0));
            r119 = new PathNode(PathTreeWalk.access$getStart$p(this.this$0), PathTreeWalkKt.access$keyOf(PathTreeWalk.access$getStart$p(this.this$0), PathTreeWalk.access$getLinkOptions(this.this$0)), null);
            r120 = this.this$0;
            r118 = r119.getPath();
            if (r119.getParent() == null) goto L17;
            PathsKt.checkFileName(r118);
        L17:
            LinkOption[] r121 = PathTreeWalk.access$getLinkOptions(r120);
            LinkOption[] r25 = (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r121, r121.length), LinkOption[].class, "com.obric.memorydata.plugin");
            if (Files.isDirectory(r118, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r25, r25.length), LinkOption[].class, "com.obric.memorydata.plugin")) == false) goto L34;
            if (PathTreeWalkKt.access$createsCycle(r119) == true) goto L32;
            if (PathTreeWalk.access$getIncludeDirectories(r120) == false) goto L28;
            Continuation<? super Unit> r26 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r10;
            this.L$1 = r22;
            this.L$2 = r115;
            this.L$3 = r119;
            this.L$4 = r120;
            this.L$5 = r118;
            this.label = 1;
            if (r10.yield(r118, r26) != r1) goto L26;
            return r1;
        L26:
            r21 = r120;
            r117 = r10;
            r114 = r119;
            r116 = r22;
            r20 = r118;
            goto L27
        L32:
            throw new FileSystemLoopException(r118.toString());
        L34:
            if (Files.exists(r118, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1), LinkOption[].class, "com.obric.memorydata.plugin")) == false) goto L38;
            Continuation<? super Unit> r27 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r10;
            this.L$1 = r22;
            this.L$2 = r115;
            this.label = 2;
            if (r10.yield(r118, r27) != r1) goto L38;
            return r1;
        }
    }

    public PathTreeWalk(Path r3, PathWalkOption[] r4) {
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, CommonConsts.APM_INNER_EVENT_COST_START);
        Intrinsics.checkNotNullParameter(r4, "options");
        this.start = r5;
        this.options = r4;
    }

    public static final /* synthetic */ boolean access$getFollowLinks(PathTreeWalk r0) {
        return r0.getFollowLinks();
    }

    public static final /* synthetic */ boolean access$getIncludeDirectories(PathTreeWalk r0) {
        return r0.getIncludeDirectories();
    }

    public static final /* synthetic */ LinkOption[] access$getLinkOptions(PathTreeWalk r0) {
        return r0.getLinkOptions();
    }

    public static final /* synthetic */ Path access$getStart$p(PathTreeWalk r0) {
        return r0.start;
    }

    private final Iterator<Path> bfsIterator() {
        return SequencesKt.iterator((Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"));
    }

    private final Iterator<Path> dfsIterator() {
        return SequencesKt.iterator((Function2) ZeusTransformUtils.preCheckCast(new C12521(this, null), Function2.class, "com.obric.memorydata.plugin"));
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

    private final Object yieldIfNeeded(SequenceScope<? super Path> r6, PathNode r7, DirectoryEntriesReader r8, Function1<? super List<PathNode>, Unit> r9, Continuation<? super Unit> r10) {
        Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        Path r0 = r7.getPath();
        if (r7.getParent() == null) goto L5;
        PathsKt.checkFileName(r0);
    L5:
        LinkOption[] r2 = access$getLinkOptions(this);
        LinkOption[] r3 = (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length), LinkOption[].class, "com.obric.memorydata.plugin");
        if (Files.isDirectory(r0, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), LinkOption[].class, "com.obric.memorydata.plugin")) == false) goto L18;
        if (PathTreeWalkKt.access$createsCycle(r7) == true) goto L16;
        if (access$getIncludeDirectories(this) == false) goto L12;
        InlineMarker.mark(0);
        r6.yield(r0, r12);
        InlineMarker.mark(1);
    L12:
        LinkOption[] r5 = access$getLinkOptions(this);
        LinkOption[] r13 = (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r5, r5.length), LinkOption[].class, "com.obric.memorydata.plugin");
        if (Files.isDirectory(r0, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r13, r13.length), LinkOption[].class, "com.obric.memorydata.plugin")) == false) goto L22;
        r11.invoke(r8.readEntries(r7));
    L22:
        return Unit.INSTANCE;
    L16:
        throw new FileSystemLoopException(r0.toString());
    L18:
        if (Files.exists(r0, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1), LinkOption[].class, "com.obric.memorydata.plugin")) == false) goto L22;
        InlineMarker.mark(0);
        r6.yield(r0, r12);
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
