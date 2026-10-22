package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.ViewGroup;
import com.ss.android.lark.picker.base.view.ItemViewType;
import h18.f;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapSaveHelper$tryLoadMap$1", f = "MmRecordingMapSaveHelper.kt", i = {3, 3, 4, 4, 5, 5, 5, 6, 6}, l = {123, 124, 131, 150, 153, 162, 165}, m = "invokeSuspend", n = {"containerContext", "isDarkMode", "containerContext", "isDarkMode", "containerContext", "isDarkMode", "currentModeSuccess", "isDarkMode", "currentModeSuccess"}, s = {"L$0", "Z$0", "L$0", "Z$0", "L$0", "Z$0", "I$0", "Z$0", "I$0"})
public final class MmRecordingMapSaveHelper$tryLoadMap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ViewGroup $container;
    final /* synthetic */ Application $context;
    final /* synthetic */ String $from;
    final /* synthetic */ Double $latitude;
    final /* synthetic */ boolean $locationChanged;
    final /* synthetic */ Double $longitude;
    int I$0;
    Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ MmRecordingMapSaveHelper this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapSaveHelper$tryLoadMap$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapSaveHelper$tryLoadMap$1$1", f = "MmRecordingMapSaveHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Application $context;
        int label;
        final /* synthetic */ MmRecordingMapSaveHelper this$0;

        public AnonymousClass1(Application r1, MmRecordingMapSaveHelper r2, Continuation<? super AnonymousClass1> r3) {
            this.$context = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$context, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            MmRecordingMapUtilKt.b(this.$context, this.this$0.c, "MmRecordingMapSaveHelper.tryLoadMap.locationChanged");
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MmRecordingMapSaveHelper$tryLoadMap$1(boolean r1, Application r2, MmRecordingMapSaveHelper r3, String r4, ViewGroup r5, Double r6, Double r7, Continuation<? super MmRecordingMapSaveHelper$tryLoadMap$1> r8) {
        this.$locationChanged = r1;
        this.$context = r2;
        this.this$0 = r3;
        this.$from = r4;
        this.$container = r5;
        this.$latitude = r6;
        this.$longitude = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MmRecordingMapSaveHelper$tryLoadMap$1(this.$locationChanged, this.$context, this.this$0, this.$from, this.$container, this.$latitude, this.$longitude, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v50, types: [int] */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r0v58 */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r0v62 */
    /* JADX WARN: Type inference failed for: r0v63 */
    /* JADX WARN: Type inference failed for: r0v64 */
    /* JADX WARN: Type inference failed for: r0v65 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v34 */
    public final Object invokeSuspend(Object r17) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r13 = false;
        switch(this.label) {
            case 0: goto L14;
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        int r0 = this.I$0;
        boolean r1 = this.Z$0;
        ResultKt.throwOnFailure(r17);
        boolean r15 = r1;
        Object r2 = r17;
        ?? r3 = r0;
    L78:
        boolean r4 = ((Boolean) r2).booleanValue();
        ?? r5 = r3;
    L79:
        this.this$0.g = null;
        this.$container.removeAllViews();
        this.$container.setVisibility(8);
        String r6 = this.this$0.c;
        StringBuilder r7 = new StringBuilder("[tryLoadMap] finish, from=");
        r7.append(this.$from);
        r7.append(", currIsDark=");
        r7.append(r15);
        r7.append(", currentModeSuccess=");
        if (r5 == 0) goto L82;
        r13 = true;
    L82:
        r7.append(r13);
        r7.append(", oppositeModeSuccess=");
        r7.append(r4);
        lvb.a.e(r6, r7.toString());
        if (r5 == 0) goto L88;
        if (r4 == false) goto L88;
        MmRecordingMapSaveHelper.b r8 = this.this$0.l;
        if (r8 == null) goto L92;
        r8.a();
    L92:
        return Unit.INSTANCE;
    L88:
        MmRecordingMapSaveHelper.b r9 = this.this$0.l;
        if (r9 == null) goto L92;
        r9.b();
        goto L92
    L7:
        int r10 = this.I$0;
        boolean r12 = this.Z$0;
        Context r14 = (Context) this.L$0;
        ResultKt.throwOnFailure(r17);
        r15 = r12;
        Context r16 = r14;
        Object r18 = r17;
        ?? r19 = r10;
    L73:
        if (((Boolean) r18).booleanValue() == false) goto L75;
        r4 = true;
        r5 = r19;
        goto L79
    L75:
        this.L$0 = null;
        this.Z$0 = r15;
        this.I$0 = r19;
        this.label = 7;
        r2 = MmRecordingMapSaveHelper.a(this.this$0, r16, this.$container, this.$latitude.doubleValue(), this.$longitude.doubleValue(), !r15, this);
        r3 = r19;
        if (r2 != r11) goto L78;
        return r11;
    L8:
        boolean r20 = this.Z$0;
        Context r21 = (Context) this.L$0;
        ResultKt.throwOnFailure(r17);
        Context r110 = r21;
        Object r22 = r17;
    L67:
        ?? r23 = ((Boolean) r22).booleanValue();
    L68:
        this.L$0 = r110;
        this.Z$0 = r20;
        this.I$0 = r23;
        this.label = 6;
        r18 = MmRecordingMapUtilKt.d(this.$context, !r20, this);
        if (r18 != r11) goto L71;
        return r11;
    L71:
        r16 = r110;
        r15 = r20;
        r19 = r23;
        goto L73
    L9:
        r20 = this.Z$0;
        Context r24 = (Context) this.L$0;
        ResultKt.throwOnFailure(r17);
        Object r25 = r17;
    L10:
        r110 = r24;
        if (((Boolean) r25).booleanValue() == false) goto L64;
        r23 = 1;
        goto L68
    L64:
        MmRecordingMapSaveHelper r26 = this.this$0;
        ViewGroup r27 = this.$container;
        double r28 = this.$latitude.doubleValue();
        double r29 = this.$longitude.doubleValue();
        this.L$0 = r110;
        this.Z$0 = r20;
        this.label = 5;
        r22 = MmRecordingMapSaveHelper.a(r26, r110, r27, r28, r29, r20, this);
        if (r22 != r11) goto L67;
        return r11;
    L11:
        ResultKt.throwOnFailure(r17);
    L33:
        r24 = this.$container.getContext();
        if (r24 != null) goto L38;
        lvb.a.b(this.this$0.c, "[tryLoadMap] container context is null, from=" + this.$from);
        return Unit.INSTANCE;
    L38:
        if ((r24 instanceof Activity) == false) goto L58;
        MmRecordingMapSaveHelper r30 = this.this$0;
        Activity r31 = (Activity) r24;
        int r32 = MmRecordingMapSaveHelper.m;
        r30.getClass();
        if (r31.isFinishing() == false) goto L42;
    L53:
        lvb.a.e(r30.c, "[checkActivity] activity is null or isFinishing or isRestricted");
    L54:
        boolean r33 = false;
    L55:
        if (r33 == true) goto L58;
        lvb.a.e(this.this$0.c, "[tryLoadMap] activity is not valid, from=" + this.$from);
        return Unit.INSTANCE;
    L42:
        if (r31.isRestricted() == true) goto L53;
    L48:
        e = move-exception;
        lvb.a.e(r30.c, "[checkActivity] Error=" + e.getMessage());
    L52:
        r33 = true;
    L50:
        e = move-exception;
        lvb.a.e(r30.c, "[checkActivity] Exception=" + e.getMessage());
        goto L52
    L45:
        if (r31.isDestroyed() == false) goto L52;
        lvb.a.e(r30.c, "[checkActivity] activity is destroyed");     // Catch: Error -> L48 Exception -> L50
    L58:
        this.$container.setVisibility(0);
        r20 = f.a(r24);
        Application r34 = this.$context;
        this.L$0 = r24;
        this.Z$0 = r20;
        this.label = 4;
        r25 = MmRecordingMapUtilKt.d(r34, r20, this);
        if (r25 != r11) goto L10;
        return r11;
    L12:
        ResultKt.throwOnFailure(r17);
        Object r35 = r17;
    L25:
        if (((Boolean) r35).booleanValue() == false) goto L29;
        lvb.a.e(this.this$0.c, "[tryLoadMap] file exist, from=" + this.$from);
        return Unit.INSTANCE;
    L29:
        if (this.$locationChanged == false) goto L33;
        CoroutineDispatcher r36 = Dispatchers.getIO();
        AnonymousClass1 r37 = new AnonymousClass1(this.$context, this.this$0, null);
        this.label = 3;
        if (BuildersKt.withContext(r36, r37, this) != r11) goto L33;
        return r11;
    L13:
        ResultKt.throwOnFailure(r17);
        Object r38 = r17;
    L20:
        if (((Boolean) r38).booleanValue() == false) goto L29;
        Application r39 = this.$context;
        this.label = 2;
        r35 = MmRecordingMapUtilKt.d(r39, false, this);
        if (r35 != r11) goto L25;
        return r11;
    L14:
        ResultKt.throwOnFailure(r17);
        if (this.$locationChanged == true) goto L29;
        Application r40 = this.$context;
        this.label = 1;
        r38 = MmRecordingMapUtilKt.d(r40, true, this);
        if (r38 != r11) goto L20;
        return r11;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
