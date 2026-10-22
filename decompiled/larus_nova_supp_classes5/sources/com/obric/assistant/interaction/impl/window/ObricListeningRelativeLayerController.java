package com.obric.assistant.interaction.impl.window;

import aba.a;
import aba.b;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.runtime.surface.ObricRootSurfaceEvent;
import com.obric.assistant.voice.IObricVoiceService;
import hba.e;
import hba.f;
import hba.g;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0002CDB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u000eJ\u0006\u0010$\u001a\u00020 J\u0010\u0010%\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u001cH\u0016J\"\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020 H\u0016J\u0010\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\u000eH\u0016J(\u00102\u001a\u00020'2\u0006\u0010-\u001a\u00020.2\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u0016H\u0002J\b\u00106\u001a\u00020'H\u0002J\u0010\u00107\u001a\u00020 2\u0006\u00105\u001a\u00020\u0016H\u0002J\u0010\u00108\u001a\u00020 2\u0006\u0010!\u001a\u00020\bH\u0002J\u0012\u00109\u001a\u00020'2\b\u00104\u001a\u0004\u0018\u00010\u0012H\u0002J\u000e\u0010:\u001a\u0004\u0018\u00010\u0016*\u00020\u0014H\u0002J\b\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u00020 H\u0002J\u0012\u0010>\u001a\u00020 2\b\b\u0002\u0010?\u001a\u00020'H\u0002J\u0010\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u00020'H\u0002J\b\u0010B\u001a\u00020 H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ObricListeningRelativeLayerController;", "Lcom/obric/assistant/activation/presentation/contract/surface/ObricChildListeningSurfaceListener;", "Lcom/obric/assistant/activation/presentation/runtime/surface/ObricRootSurfaceListener;", "<init>", "()V", "voiceService", "Lcom/obric/assistant/voice/IObricVoiceService;", "decorView", "Landroid/view/View;", "rootObservation", "Lcom/obric/assistant/activation/presentation/runtime/surface/ObricRootSurfaceObservation;", "preDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "source", "", "mainWindowType", "", "mainRoot", "Landroid/view/SurfaceControl;", "snapshot", "Lcom/obric/assistant/activation/presentation/contract/surface/ObricChildListeningSurfaceSnapshot;", "linkedKey", "Lcom/obric/assistant/interaction/impl/window/ObricListeningRelativeLayerController$SurfaceKey;", "linkedChildRoot", "linkedMainRoot", "lastBlockedKey", "pendingRemovalKey", "pendingRemovalCompletion", "Ljava/lang/Runnable;", "mainHandler", "Landroid/os/Handler;", "prepareForShow", "", "view", "windowType", "showSource", "reset", "onChildListeningSurfaceChanged", "prepareForChildListeningSurfaceRemoval", "", "onReadyToRemove", "onRootSurfaceAvailable", "surface", "event", "Lcom/obric/assistant/activation/presentation/runtime/surface/ObricRootSurfaceEvent;", "transaction", "Landroid/view/SurfaceControl$Transaction;", "onRootSurfaceDestroyed", "onRootSurfaceUnavailable", "reason", "appendRelativeLayer", "currentMainRoot", "childRoot", "key", "queueRelativeLayerOnDrawIfReady", "acknowledgeLinked", "installPreDrawBarrier", "isCompatibleCurrentSurface", "surfaceKey", "mainExecutor", "Ljava/util/concurrent/Executor;", "finishPendingRemoval", "clearLinkedRelativeLayer", "preferOnDraw", "resetDialog", "completePendingRemoval", "releaseChildLink", "SurfaceKey", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricListeningRelativeLayerController implements a, f {
    private static final Companion Companion = null;
    public static final String TAG = "SVA-ObricListeningDebug";
    private View decorView;
    private SurfaceKey lastBlockedKey;
    private SurfaceControl linkedChildRoot;
    private SurfaceKey linkedKey;
    private SurfaceControl linkedMainRoot;
    private final Handler mainHandler;
    private SurfaceControl mainRoot;
    private int mainWindowType;
    private Runnable pendingRemovalCompletion;
    private SurfaceKey pendingRemovalKey;
    private ViewTreeObserver.OnPreDrawListener preDrawListener;
    private g rootObservation;
    private b snapshot;
    private String source;
    private IObricVoiceService voiceService;

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(ObricListeningRelativeLayerController r0, Runnable r1) {
        mainExecutor$lambda$10(r0, r1);
    }

    public static /* synthetic */ boolean b(ObricListeningRelativeLayerController r0) {
        return installPreDrawBarrier$lambda$9(r0);
    }

    public static /* synthetic */ void c(ObricListeningRelativeLayerController r0, SurfaceKey r1) {
        prepareForChildListeningSurfaceRemoval$lambda$2(r0, r1);
    }

    public static /* synthetic */ void d(Runnable r0, Runnable r1) {
        prepareForChildListeningSurfaceRemoval$lambda$1(r0, r1);
    }

    public static /* synthetic */ void e(ObricListeningRelativeLayerController r0, SurfaceKey r1) {
        appendRelativeLayer$lambda$4$lambda$3(r0, r1);
    }

    public static /* synthetic */ void f(ObricListeningRelativeLayerController r0, SurfaceKey r1) {
        queueRelativeLayerOnDrawIfReady$lambda$6(r0, r1);
    }

    public void onRootSurfaceDestroyed() {
        clearLinkedRelativeLayer(false);
        releaseChildLink();
        this.mainRoot = null;
        this.linkedKey = null;
        this.lastBlockedKey = null;
        finishPendingRemoval();
    }

    public final void reset() {
        resetDialog(true);
        IObricVoiceService r0 = this.voiceService;
        if (r0 == null) goto L5;
        r0.k(this);
    L5:
        this.voiceService = null;
        this.snapshot = b.f;
    }

    private final void finishPendingRemoval() {
        Runnable r0 = this.pendingRemovalCompletion;
        this.pendingRemovalKey = null;
        this.pendingRemovalCompletion = null;
        if (r0 == null) goto L6;
        r0.run();
        return;
    }

    private final Executor mainExecutor() {
        return new s(this);
    }

    private final boolean queueRelativeLayerOnDrawIfReady() {
        View r3 = this.decorView;
        if (r3 != null) goto L5;
        return false;
    L5:
        SurfaceControl r5 = this.mainRoot;
        if (r5 != null) goto L8;
        return false;
    L8:
        b r6 = this.snapshot;
        SurfaceControl r7 = r6.e;
        if (r7 != null) goto L11;
        return false;
    L11:
        SurfaceKey r8 = surfaceKey(r6);
        if (r8 != null) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.linkedKey, r8) == false) goto L19;
        return true;
    L19:
        if (isCompatibleCurrentSurface(r7) == true) goto L21;
        return false;
    L21:
        SurfaceControl.Transaction r9 = new SurfaceControl.Transaction();
        e.a.getClass();     // Catch: Throwable -> L30 RuntimeException -> L32
        if (e.b(r9, r7, r5) == true) goto L26;
        r9.close();
        return false;
    L26:
        r9.addTransactionCommittedListener(mainExecutor(), new t(this, r8));     // Catch: Throwable -> L30 RuntimeException -> L32
        boolean r4 = e.d(r3, r9);     // Catch: Throwable -> L30 RuntimeException -> L32
        if (r4 == false) goto L29;
        this.linkedKey = r8;     // Catch: Throwable -> L30 RuntimeException -> L32
        this.linkedChildRoot = r7;     // Catch: Throwable -> L30 RuntimeException -> L32
        this.linkedMainRoot = r5;     // Catch: Throwable -> L30 RuntimeException -> L32
        this.lastBlockedKey = null;     // Catch: Throwable -> L30 RuntimeException -> L32
        FLogger.a.i(TAG, "link_queued: side=main stage=surface path=on_draw generation=" + r8.getGeneration() + " source=" + this.source);     // Catch: Throwable -> L30 RuntimeException -> L32
    L29:
        r9.close();
        return r4;
    L32:
        e = move-exception;
        FLogger.a.w(TAG, "link_failed: side=main stage=surface path=on_draw error=".concat(e.getClass().getSimpleName()));     // Catch: Throwable -> L30
        r9.close();
        return false;
    L30:
        th = move-exception;
        r9.close();
        throw th;
    }

    private final void releaseChildLink() {
        SurfaceKey r0 = surfaceKey(this.snapshot);
        if (r0 != null) goto L5;
        return;
    L5:
        IObricVoiceService r1 = this.voiceService;
        if (r1 == null) goto L9;
        r1.o(r0.getGeneration());
        return;
    }

    public ObricListeningRelativeLayerController() {
        this.source = "unknown";
        this.snapshot = b.f;
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    private final void acknowledgeLinked(SurfaceKey r7) {
        if (Intrinsics.areEqual(this.linkedKey, r7) == true) goto L5;
    L13:
        FLogger.a.i(TAG, "link_commit_drop: side=main stage=surface generation=" + r7.getGeneration() + " current=" + surfaceKey(this.snapshot) + " source=" + this.source);
        return;
    L5:
        if (Intrinsics.areEqual(surfaceKey(this.snapshot), r7) == false) goto L13;
        if (this.mainRoot == null) goto L13;
        FLogger.a.i(TAG, "link_committed: side=main stage=surface generation=" + r7.getGeneration() + " current=" + surfaceKey(this.snapshot) + " source=" + this.source);
        IObricVoiceService r0 = this.voiceService;
        if (r0 == null) goto L15;
        r0.c(r7.getGeneration());
        return;
    }

    private final void clearLinkedRelativeLayer(boolean r6) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.lang.String r0 = "clear_failed: side=main stage=surface error="
            android.view.SurfaceControl r1 = r5.linkedMainRoot
            if (r1 != 0) goto L7
            return
        L7:
            hba.e r2 = hba.e.a
            r2.getClass()
            boolean r2 = hba.e.e(r1)
            r3 = 0
            if (r2 != 0) goto L1a
            r5.linkedMainRoot = r3
            r5.linkedChildRoot = r3
            r5.linkedKey = r3
            return
        L1a:
            android.view.SurfaceControl$Transaction r2 = new android.view.SurfaceControl$Transaction
            r2.<init>()
            boolean r1 = hba.e.c(r2, r1)     // Catch: java.lang.Throwable -> L39 java.lang.RuntimeException -> L3b
            if (r1 != 0) goto L29
            r2.close()
            return
        L29:
            r1 = 0
            if (r6 == 0) goto L41
            android.view.View r6 = r5.decorView     // Catch: java.lang.Throwable -> L39 java.lang.RuntimeException -> L3b
            r4 = 1
            if (r6 == 0) goto L3d
            boolean r6 = hba.e.d(r6, r2)     // Catch: java.lang.Throwable -> L39 java.lang.RuntimeException -> L3b
            if (r6 != r4) goto L3d
            r6 = 1
            goto L3e
        L39:
            r6 = move-exception
            goto L76
        L3b:
            r6 = move-exception
            goto L4d
        L3d:
            r6 = 0
        L3e:
            if (r6 == 0) goto L41
            r1 = 1
        L41:
            if (r1 != 0) goto L46
            r2.apply()     // Catch: java.lang.Throwable -> L39 java.lang.RuntimeException -> L3b
        L46:
            r5.linkedMainRoot = r3     // Catch: java.lang.Throwable -> L39 java.lang.RuntimeException -> L3b
            r5.linkedChildRoot = r3     // Catch: java.lang.Throwable -> L39 java.lang.RuntimeException -> L3b
            r5.linkedKey = r3     // Catch: java.lang.Throwable -> L39 java.lang.RuntimeException -> L3b
            goto L72
        L4d:
            com.larus.utils.logger.FLogger r1 = com.larus.utils.logger.FLogger.a     // Catch: java.lang.Throwable -> L39
            java.lang.String r3 = "SVA-ObricListeningDebug"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L39
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L39
            java.lang.Class r6 = r6.getClass()     // Catch: java.lang.Throwable -> L39
            java.lang.String r6 = r6.getSimpleName()     // Catch: java.lang.Throwable -> L39
            r4.append(r6)     // Catch: java.lang.Throwable -> L39
            java.lang.String r6 = " source="
            r4.append(r6)     // Catch: java.lang.Throwable -> L39
            java.lang.String r6 = r5.source     // Catch: java.lang.Throwable -> L39
            r4.append(r6)     // Catch: java.lang.Throwable -> L39
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L39
            r1.w(r3, r6)     // Catch: java.lang.Throwable -> L39
        L72:
            r2.close()
            return
        L76:
            r2.close()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.assistant.interaction.impl.window.ObricListeningRelativeLayerController.clearLinkedRelativeLayer(boolean):void");
    }

    private final void installPreDrawBarrier(View r4) {
        ViewTreeObserver.OnPreDrawListener r0 = this.preDrawListener;
        if (r0 == null) goto L10;
        ViewTreeObserver r1 = r4.getViewTreeObserver();
        if (r1.isAlive() == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L10;
        r1.removeOnPreDrawListener(r0);
    L10:
        u r2 = new u(this);
        this.preDrawListener = r2;
        r4.getViewTreeObserver().addOnPreDrawListener(r2);
    }

    private static final boolean installPreDrawBarrier$lambda$9(ObricListeningRelativeLayerController r7) {
        SurfaceKey r0 = r7.surfaceKey(r7.snapshot);
        b r1 = r7.snapshot;
        boolean r2 = r1.d;
        int r3 = r1.a;
        SurfaceKey r4 = r7.linkedKey;
        if (r4 == null) goto L5;
        Integer r5 = Integer.valueOf(r4.getGeneration());
    L6:
        boolean r6 = ObricListeningRelativeLayerControllerKt.shouldAllowListeningMainDraw(r2, r3, r5);
        if (r6 == false) goto L9;
    L15:
        if (r6 == true) goto L17;
    L19:
        return r6;
    L17:
        if (r7.lastBlockedKey == null) goto L19;
        FLogger.a.i(TAG, "barrier_release: side=main stage=surface generation=" + r7.snapshot.a + " source=" + r7.source);
        r7.lastBlockedKey = null;
        goto L19
    L9:
        if (Intrinsics.areEqual(r7.lastBlockedKey, r0) == true) goto L15;
        r7.lastBlockedKey = r0;
        FLogger r8 = FLogger.a;
        StringBuilder r9 = new StringBuilder("barrier_block: side=main stage=surface generation=");
        r9.append(r7.snapshot.a);
        r9.append(" hasChild=");
        if (r7.snapshot.e == null) goto L13;
        boolean r10 = true;
    L14:
        r9.append(r10);
        r9.append(" source=");
        r9.append(r7.source);
        r8.i(TAG, r9.toString());
        goto L19
    L13:
        r10 = false;
        goto L14
    L5:
        r5 = null;
        goto L6
    }

    private final boolean isCompatibleCurrentSurface(SurfaceControl r4) {
        View r0 = this.decorView;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (this.snapshot.d == false) goto L20;
        e.a.getClass();
        if (e.e(r4) == false) goto L23;
        Display r5 = r0.getDisplay();
        if (r5 == null) goto L13;
        int r6 = r5.getDisplayId();
    L14:
        b r1 = this.snapshot;
        if (r1.b == r6) goto L17;
        return false;
    L17:
        if (r1.c != this.mainWindowType) goto L22;
        return true;
    L22:
        return false;
    L13:
        r6 = 0;
        goto L14
    L23:
        return false;
    L20:
        return false;
    }

    private final void resetDialog(boolean r4) {
        if (r4 == false) goto L4;
        finishPendingRemoval();
    L4:
        clearLinkedRelativeLayer(false);
        releaseChildLink();
        g r5 = this.rootObservation;
        if (r5 == null) goto L7;
        r5.close();
    L7:
        this.rootObservation = null;
        ViewTreeObserver.OnPreDrawListener r0 = this.preDrawListener;
        if (r0 == null) goto L19;
        View r1 = this.decorView;
        if (r1 == null) goto L19;
        ViewTreeObserver r2 = r1.getViewTreeObserver();
        if (r2 == null) goto L19;
        if (r2.isAlive() == true) goto L17;
        r2 = null;
    L17:
        if (r2 == null) goto L19;
        r2.removeOnPreDrawListener(r0);
    L19:
        this.preDrawListener = null;
        this.decorView = null;
        this.mainRoot = null;
        this.linkedKey = null;
        this.linkedChildRoot = null;
        this.linkedMainRoot = null;
        this.lastBlockedKey = null;
    }

    private final SurfaceKey surfaceKey(b r2) {
        int r3 = r2.a;
        if (r3 >= 0) goto L7;
        return null;
    L7:
        return new SurfaceKey(r3);
    }

    public void onChildListeningSurfaceChanged(b r5) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L23;
        SurfaceKey r0 = surfaceKey(this.snapshot);
        this.snapshot = r5;
        SurfaceKey r1 = surfaceKey(r5);
        SurfaceKey r2 = this.linkedKey;
        if (r2 == null) goto L10;
        if (Intrinsics.areEqual(r2, r1) == true) goto L10;
        this.linkedKey = null;
    L10:
        if (Intrinsics.areEqual(r0, r1) == true) goto L13;
        this.lastBlockedKey = null;
    L13:
        if (r5.d == true) goto L18;
        clearLinkedRelativeLayer$default(this, false, 1, null);
        finishPendingRemoval();
        View r6 = this.decorView;
        if (r6 == null) goto L24;
        r6.invalidate();
        return;
    L24:
        return;
    L18:
        queueRelativeLayerOnDrawIfReady();
        View r7 = this.decorView;
        if (r7 == null) goto L25;
        r7.invalidate();
        return;
    L25:
        return;
    L23:
        throw new IllegalStateException("Check failed.".toString());
    }

    public void onRootSurfaceUnavailable(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        clearLinkedRelativeLayer(false);
        this.mainRoot = null;
        this.linkedKey = null;
        FLogger.a.w(TAG, "observe_unavailable: side=main stage=surface reason=" + r4 + " source=" + this.source);
        View r5 = this.decorView;
        if (r5 == null) goto L6;
        r5.invalidate();
        return;
    }

    private static final void appendRelativeLayer$lambda$4$lambda$3(ObricListeningRelativeLayerController r0, SurfaceKey r1) {
        r0.acknowledgeLinked(r1);
    }

    private static final void mainExecutor$lambda$10(ObricListeningRelativeLayerController r3, Runnable r4) {
        View r0 = r3.decorView;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r4.run();
        return;
    L5:
        if (r0 != null) goto L7;
    L9:
        r3.mainHandler.post(r4);
        return;
    L7:
        if (r0.isAttachedToWindow() == false) goto L9;
        r0.post(r4);
    }

    private static final void prepareForChildListeningSurfaceRemoval$lambda$1(Runnable r0, Runnable r1) {
        if (r0 == null) goto L4;
        r0.run();
    L4:
        r1.run();
    }

    private static final void prepareForChildListeningSurfaceRemoval$lambda$2(ObricListeningRelativeLayerController r3, SurfaceKey r4) {
        if (Intrinsics.areEqual(r3.pendingRemovalKey, r4) == true) goto L5;
        return;
    L5:
        FLogger.a.i(TAG, "unlink_committed: side=main stage=surface generation=" + r4.getGeneration() + " source=" + r3.source);
        r3.linkedKey = null;
        r3.linkedChildRoot = null;
        r3.linkedMainRoot = null;
        r3.finishPendingRemoval();
    }

    private static final void queueRelativeLayerOnDrawIfReady$lambda$6(ObricListeningRelativeLayerController r0, SurfaceKey r1) {
        r0.acknowledgeLinked(r1);
    }

    public boolean prepareForChildListeningSurfaceRemoval(b r13, Runnable r14) {
        Intrinsics.checkNotNullParameter(r13, "snapshot");
        Intrinsics.checkNotNullParameter(r14, "onReadyToRemove");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L63;
        SurfaceKey r15 = surfaceKey(r13);
        if (r15 != null) goto L7;
        return false;
    L7:
        View r4 = this.decorView;
        if (r4 != null) goto L10;
        return false;
    L10:
        SurfaceControl r5 = this.mainRoot;
        if (r5 != null) goto L13;
        return false;
    L13:
        SurfaceControl r6 = this.linkedChildRoot;
        if (r6 != null) goto L16;
        return false;
    L16:
        SurfaceControl r7 = this.linkedMainRoot;
        if (r7 != null) goto L19;
        return false;
    L19:
        int r8 = this.snapshot.a;
        SurfaceKey r9 = this.linkedKey;
        if (r9 == null) goto L22;
        Integer r10 = Integer.valueOf(r9.getGeneration());
    L24:
        if (ObricListeningRelativeLayerControllerKt.isExactLinkedSurface(r8, r10, r15.getGeneration()) == false) goto L61;
        if (r5 != r7) goto L61;
        e.a.getClass();
        if (e.e(r5) == false) goto L61;
        if (e.e(r6) == false) goto L61;
        if (e.e(r7) == false) goto L61;
        SurfaceKey r11 = this.pendingRemovalKey;
        if (r11 != null) goto L36;
        SurfaceControl.Transaction r12 = new SurfaceControl.Transaction();
        this.pendingRemovalKey = r15;     // Catch: Throwable -> L53 RuntimeException -> L55
        this.pendingRemovalCompletion = r14;     // Catch: Throwable -> L53 RuntimeException -> L55
        r12.setAlpha(r6, 0.0f);     // Catch: Throwable -> L53 RuntimeException -> L55
        if (e.c(r12, r7) == true) goto L46;
        this.pendingRemovalKey = null;     // Catch: Throwable -> L53 RuntimeException -> L55
        this.pendingRemovalCompletion = null;     // Catch: Throwable -> L53 RuntimeException -> L55
        r12.close();
        return false;
    L46:
        r12.addTransactionCommittedListener(mainExecutor(), new w(this, r15));     // Catch: Throwable -> L53 RuntimeException -> L55
        if (e.d(r4, r12) == true) goto L51;
        this.pendingRemovalKey = null;     // Catch: Throwable -> L53 RuntimeException -> L55
        this.pendingRemovalCompletion = null;     // Catch: Throwable -> L53 RuntimeException -> L55
        r12.close();
        return false;
    L51:
        r4.invalidate();     // Catch: Throwable -> L53 RuntimeException -> L55
        FLogger.a.i(TAG, "unlink_queued: side=main stage=surface path=on_draw generation=" + r15.getGeneration() + " source=" + this.source);     // Catch: Throwable -> L53 RuntimeException -> L55
        r12.close();
        return true;
    L53:
        th = move-exception;
        r12.close();
        throw th;
    L55:
        e = move-exception;
        this.pendingRemovalKey = null;     // Catch: Throwable -> L53
        this.pendingRemovalCompletion = null;     // Catch: Throwable -> L53
        FLogger.a.w(TAG, "unlink_failed: side=main stage=surface generation=" + r15.getGeneration() + " error=" + e.getClass().getSimpleName());     // Catch: Throwable -> L53
        r12.close();
        return false;
    L36:
        if (Intrinsics.areEqual(r11, r15) == true) goto L38;
        return false;
    L38:
        this.pendingRemovalCompletion = new v(this.pendingRemovalCompletion, r14);
        return true;
    L61:
        return false;
    L22:
        r10 = null;
        goto L24
    L63:
        throw new IllegalStateException("Check failed.".toString());
    }

    public void onRootSurfaceAvailable(SurfaceControl r4, ObricRootSurfaceEvent r5, SurfaceControl.Transaction r6) {
        Intrinsics.checkNotNullParameter(r4, "surface");
        Intrinsics.checkNotNullParameter(r5, "event");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L19;
        this.mainRoot = r4;
        this.linkedKey = null;
        b r0 = this.snapshot;
        SurfaceControl r1 = r0.e;
        if (r1 != null) goto L7;
        return;
    L7:
        SurfaceKey r2 = surfaceKey(r0);
        if (r2 != null) goto L11;
        return;
    L11:
        if (isCompatibleCurrentSurface(r1) == true) goto L13;
        return;
    L13:
        if (r6 == null) goto L15;
        boolean r7 = appendRelativeLayer(r6, r4, r1, r2);
    L16:
        FLogger.a.i(TAG, "root: side=main stage=surface source=" + r5 + " relationQueued=" + r7 + " generation=" + r2.getGeneration() + " showSource=" + this.source);
        return;
    L15:
        r7 = queueRelativeLayerOnDrawIfReady();
        goto L16
    L19:
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void prepareForShow(View r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r5, "showSource");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L20;
        this.source = r5;
        this.mainWindowType = r4;
        if (this.decorView == r3) goto L7;
        resetDialog(true);
        this.decorView = r3;
        e.a.getClass();
        this.rootObservation = e.f(r3, this);
    L7:
        installPreDrawBarrier(r3);
        if (this.voiceService != null) goto L17;
        IObricVoiceService.a.getClass();
        IObricVoiceService r6 = IObricVoiceService.a.a();
        this.voiceService = r6;
        if (r6 == null) goto L13;
        b r7 = r6.p();
        if (r7 == null) goto L13;
    L14:
        this.snapshot = r7;
        IObricVoiceService r8 = this.voiceService;
        if (r8 == null) goto L17;
        r8.l(this);
    L13:
        r7 = b.f;
    L17:
        r3.invalidate();
        return;
    L20:
        throw new IllegalStateException("listening relative-layer must run on main thread".toString());
    }

    private final boolean appendRelativeLayer(SurfaceControl.Transaction r5, SurfaceControl r6, SurfaceControl r7, SurfaceKey r8) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        e.a.getClass();     // Catch: Throwable -> L9
        if (e.b(r5, r7, r6) == true) goto L7;
        return false;
    L7:
        r5.addTransactionCommittedListener(mainExecutor(), new x(this, r8));     // Catch: Throwable -> L9
        this.linkedKey = r8;     // Catch: Throwable -> L9
        this.linkedChildRoot = r7;     // Catch: Throwable -> L9
        this.linkedMainRoot = r6;     // Catch: Throwable -> L9
        this.lastBlockedKey = null;     // Catch: Throwable -> L9
        FLogger.a.i(TAG, "link_queued: side=main stage=surface path=callback generation=" + r8.getGeneration() + " source=" + this.source);     // Catch: Throwable -> L9
        Object r9 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L9
    L11:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L16;
        FLogger.a.w(TAG, "link_failed: side=main stage=surface path=callback error=".concat(r10.getClass().getSimpleName()));
        r9 = Boolean.FALSE;
    L16:
        return ((Boolean) r9).booleanValue();
    L9:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public static /* synthetic */ void clearLinkedRelativeLayer$default(ObricListeningRelativeLayerController r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.clearLinkedRelativeLayer(r1);
    }
}
