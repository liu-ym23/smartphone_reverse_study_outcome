package com.larus.canvas.feature.component.input;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.canvas.feature.ability.CanvasEditorEventType;
import com.larus.canvas.feature.ability.UpdateProgress;
import com.larus.canvas.feature.component.instruction.model.InstructionTabState;
import com.larus.canvas.feature.component.logic.n2;
import com.larus.canvas.feature.component.resultdisplay.image.CreationImagePagerComponent;
import com.larus.canvas.feature.host.CanvasHostUiPolicy;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.MaskUri;
import com.larus.canvas.service.bean.OptionItem;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020+H\u0016J\b\u0010-\u001a\u00020+H\u0016J$\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010'2\b\u00102\u001a\u0004\u0018\u00010)H\u0016J.\u00103\u001a\u00020+2\b\u00101\u001a\u0004\u0018\u00010'2\b\u00102\u001a\u0004\u0018\u00010)2\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u000205H\u0002J\u0018\u00107\u001a\u00020+2\u0006\u00104\u001a\u0002052\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010B\u001a\u00020+2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020+2\u0006\u0010C\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020+H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/larus/canvas/feature/component/input/CanvasGenImageInputEventReceiverComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/canvas/feature/component/input/ICanvasImageEditAbility;", "<init>", "()V", "canvasEditorAbility", "Lcom/larus/canvas/feature/ability/CreationCanvasEditorAbility;", "getCanvasEditorAbility", "()Lcom/larus/canvas/feature/ability/CreationCanvasEditorAbility;", "canvasEditorAbility$delegate", "Lkotlin/Lazy;", "genImagePlannerAbility", "Lcom/larus/canvas/feature/component/logic/IGenImagePlannerAbility;", "getGenImagePlannerAbility", "()Lcom/larus/canvas/feature/component/logic/IGenImagePlannerAbility;", "genImagePlannerAbility$delegate", "canvasContainerAbility", "Lcom/larus/canvas/feature/ability/CanvasContainerAbility;", "getCanvasContainerAbility", "()Lcom/larus/canvas/feature/ability/CanvasContainerAbility;", "canvasContainerAbility$delegate", "canvasInstructionAbility", "Lcom/larus/canvas/feature/ability/CanvasInstructionAbility;", "getCanvasInstructionAbility", "()Lcom/larus/canvas/feature/ability/CanvasInstructionAbility;", "canvasInstructionAbility$delegate", "argumentData", "Lcom/larus/canvas/feature/data/CanvasArgumentData;", "getArgumentData", "()Lcom/larus/canvas/feature/data/CanvasArgumentData;", "argumentData$delegate", "hostUiPolicy", "Lcom/larus/canvas/feature/host/CanvasHostUiPolicy;", "getHostUiPolicy", "()Lcom/larus/canvas/feature/host/CanvasHostUiPolicy;", "hostUiPolicy$delegate", "isWaitingResult", "", "handlingInstructionTab", "Lcom/larus/canvas/service/bean/InstructionTab;", "handlingOptionItem", "Lcom/larus/canvas/service/bean/OptionItem;", "onAttach", "", "onCreate", "onResume", "handleEraseClickEvent", "imageInfo", "Lcom/larus/bmhome/actionbar/model/MediaAttachment;", "instructionTab", "optionItem", "startGenerateImage", "prompt", "", "scene", "handleEventSelectorPanelStatusChange", "selectorPanelStatusChangeInfo", "Lcom/larus/canvas/feature/ability/SelectorPanelStatusChangeInfo;", "instructionHeight", "", "handleEventBottomInsetUpdate", "bottomInsetUpdateInfo", "Lcom/larus/canvas/feature/ability/BottomInsetUpdateInfo;", "handleContainerUIAction", "action", "Lcom/larus/canvas/feature/ability/CanvasContainerUIAction;", "handleImageRemoveData", "data", "Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;", "handleImageRemoveResult", "Landroid/os/Bundle;", "registerAppletImageRemoveResult", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasGenImageInputEventReceiverComponent extends BaseContentWidget implements b0 {
    public static final /* synthetic */ int w = 0;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public boolean s;
    public InstructionTab t;
    public OptionItem u;
    public int v;

    /* JADX INFO: renamed from: com.larus.canvas.feature.component.input.CanvasGenImageInputEventReceiverComponent$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.canvas.feature.component.input.CanvasGenImageInputEventReceiverComponent$onCreate$1", f = "CanvasGenImageInputEventReceiverComponent.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CanvasGenImageInputEventReceiverComponent this$0;

        /* JADX INFO: renamed from: com.larus.canvas.feature.component.input.CanvasGenImageInputEventReceiverComponent$onCreate$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ CanvasGenImageInputEventReceiverComponent a;

            public a(CanvasGenImageInputEventReceiverComponent r1) {
                this.a = r1;
            }

            public final Object emit(Object r3, Continuation r4) {
                fy8.c r5 = (fy8.c) r3;
                CanvasGenImageInputEventReceiverComponent r6 = this.a;
                int r0 = CanvasGenImageInputEventReceiverComponent.w;
                r6.getClass();
                if ((r5 instanceof fy8.c.a) == false) goto L17;
                r6.s = false;
                fy8.c.a r7 = (fy8.c.a) r5;
                if (366 != r7.b) goto L17;
                Intent r8 = r7.c;
                if (r8 == null) goto L17;
                Bundle r9 = r8.getExtras();
                if (r9 == null) goto L17;
                Serializable r10 = r9.getSerializable("image_edit_data.with_mask");
                if ((r10 instanceof ImageEditDataWithMask) == false) goto L13;
                ImageEditDataWithMask r11 = (ImageEditDataWithMask) r10;
            L14:
                if (r11 == null) goto L17;
                r6.Ss(r11);
                goto L17
            L13:
                r11 = null;
            L17:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(CanvasGenImageInputEventReceiverComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            fy8.b r6 = (fy8.b) this.this$0.o.getValue();
            if (r6 == null) goto L18;
            a1 r7 = r6.U4();
            if (r7 == null) goto L18;
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L16;
            return r0;
        L18:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.canvas.feature.component.input.CanvasGenImageInputEventReceiverComponent$onCreate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.canvas.feature.component.input.CanvasGenImageInputEventReceiverComponent$onCreate$2", f = "CanvasGenImageInputEventReceiverComponent.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CanvasGenImageInputEventReceiverComponent this$0;

        /* JADX INFO: renamed from: com.larus.canvas.feature.component.input.CanvasGenImageInputEventReceiverComponent$onCreate$2$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ CanvasGenImageInputEventReceiverComponent a;

            /* JADX INFO: renamed from: com.larus.canvas.feature.component.input.CanvasGenImageInputEventReceiverComponent$onCreate$2$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0087a {
                public static final /* synthetic */ int[] a = null;

                static {
                    int[] r0 = new int[CanvasEditorEventType.values().length];
                    r0[CanvasEditorEventType.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
                L35:
                    r0[CanvasEditorEventType.EVENT_CLICK_SEND_BUTTON.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
                L51:
                    r0[CanvasEditorEventType.EVENT_FINISH_SPEAK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
                L39:
                    r0[CanvasEditorEventType.EVENT_FINISH_PASTE_AND_SEND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
                L43:
                    r0[CanvasEditorEventType.EVENT_BOTTOM_INSET_UPDATE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
                L29:
                    r0[CanvasEditorEventType.EVENT_DROP_DOWN_BOX_SELECTED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
                L45:
                    r0[CanvasEditorEventType.EVENT_MSG_INSTRUCTION_TAB_CLICK.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
                L47:
                    r0[CanvasEditorEventType.EVENT_INSTRUCTION_TAB_SELECTED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
                L37:
                    r0[CanvasEditorEventType.EVENT_INSTRUCTION_RENDER_CHANGE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
                L41:
                    r0[CanvasEditorEventType.EVENT_INSTRUCTION_OPTION_CLICK.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
                L31:
                    r0[CanvasEditorEventType.EVENT_SELECTOR_PANEL_STATUS_CHANGE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
                L33:
                    r0[CanvasEditorEventType.EVENT_INSTRUCTION_TAB_UN_SELECTED.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
                L15:
                    a = r0;
                }
            }

            public a(CanvasGenImageInputEventReceiverComponent r1) {
                this.a = r1;
            }

            public final Object emit(Object r11, Continuation r12) {
                fy8.d r13 = (fy8.d) r11;
                int r1 = 0;
                switch(C0087a.a[r13.a.ordinal()]) {
                    case 1: goto L76;
                    case 2: goto L74;
                    case 3: goto L73;
                    case 4: goto L72;
                    case 5: goto L32;
                    case 6: goto L76;
                    case 7: goto L29;
                    case 8: goto L76;
                    case 9: goto L76;
                    case 10: goto L24;
                    case 11: goto L6;
                    case 12: goto L76;
                    default: goto L5;
                };
            L6:
                fy8.m r14 = r13.f;
                if (r14 == null) goto L76;
                CanvasGenImageInputEventReceiverComponent r0 = this.a;
                String r2 = r13.b;
                int r15 = CanvasGenImageInputEventReceiverComponent.w;
                r0.getClass();
                boolean r16 = r14.a;
                String r3 = r14.b;
                if (r16 == false) goto L15;
                if (StringsKt.isBlank(r2) == false) goto L13;
                String r17 = r2 + r3;
            L18:
                String r4 = r17;
                if (StringsKt.startsWith$default(r4, ",", false, 2, null) == false) goto L21;
                r4 = StringsKt.replaceFirst$default(r4, ",", "", false, 4, null);
            L21:
                fy8.i r18 = r0.Y2();
                if (r18 == null) goto L76;
                fy8.i.a.a(r18, r4, 28);
                goto L76
            L13:
                r17 = r2 + ", " + r3;
                goto L18
            L15:
                if (StringsKt.contains$default(r2, "," + r3, false, 2, null) == false) goto L17;
                r17 = StringsKt.replace$default(r2, "," + r3, "", false, 4, null);
                goto L18
            L17:
                r17 = StringsKt.replace$default(r2, r3, "", false, 4, null);
                goto L18
            L24:
                InstructionTab r19 = r13.c;
                if (r19 == null) goto L76;
                OptionItem r5 = r13.d;
                if (r5 == null) goto L76;
                CanvasGenImageInputEventReceiverComponent r6 = this.a;
                String r110 = r13.b;
                int r7 = CanvasGenImageInputEventReceiverComponent.w;
                r6.m3(r19, r5, r110, "router_auto_send");
                goto L76
            L29:
                InstructionTab r111 = r13.c;
                if (r111 == null) goto L76;
                CanvasGenImageInputEventReceiverComponent r8 = this.a;
                OptionItem r9 = r13.d;
                String r112 = r13.b;
                int r10 = CanvasGenImageInputEventReceiverComponent.w;
                r8.m3(r111, r9, r112, "router_auto_send");
                goto L76
            L32:
                fy8.a r113 = r13.e;
                if (r113 == null) goto L76;
                CanvasGenImageInputEventReceiverComponent r114 = this.a;
                int r20 = CanvasGenImageInputEventReceiverComponent.w;
                r114.getClass();
                UpdateProgress r21 = r113.a;
                if (r21 != UpdateProgress.UPDATE_START) goto L52;
                if (Intrinsics.areEqual(r113.c, Boolean.TRUE) == false) goto L45;
                fy8.i r115 = r114.Y2();
                if (r115 == null) goto L41;
                r115.fC(false);
            L41:
                fy8.h r116 = r114.h3();
                if (r116 == null) goto L44;
                r1 = r116.lG();
            L44:
                r114.v = r1;
            L48:
                fy8.h r117 = r114.h3();
                if (r117 == null) goto L76;
                r117.pw(-2);
                goto L76
            L45:
                fy8.i r118 = r114.Y2();
                if (r118 == null) goto L48;
                r118.fC(true);
                goto L48
            L52:
                if (r21 != UpdateProgress.UPDATING) goto L59;
                if (Intrinsics.areEqual(r113.c, Boolean.TRUE) == false) goto L76;
                fy8.h r22 = r114.h3();
                if (r22 == null) goto L76;
                int r119 = r114.v;
                int r23 = CreationImagePagerComponent.D;
                r22.pw((int) Math.max(0.0d, ((double) (r119 * (r23 - r113.b))) / ((double) r23)));
                goto L76
            L59:
                if (Intrinsics.areEqual(r113.c, Boolean.TRUE) == false) goto L66;
                fy8.i r120 = r114.Y2();
                if (r120 == null) goto L63;
                r120.fC(false);
            L63:
                fy8.h r121 = r114.h3();
                if (r121 == null) goto L76;
                r121.pw(0);
                goto L76
            L66:
                fy8.i r122 = r114.Y2();
                if (r122 == null) goto L69;
                r122.fC(true);
            L69:
                fy8.h r123 = r114.h3();
                if (r123 == null) goto L76;
                r123.pw(-2);
                goto L76
            L72:
                CanvasGenImageInputEventReceiverComponent r124 = this.a;
                InstructionTab r24 = r13.c;
                OptionItem r25 = r13.d;
                String r125 = r13.b;
                int r26 = CanvasGenImageInputEventReceiverComponent.w;
                r124.m3(r24, r25, r125, "keyboard");
                goto L76
            L73:
                CanvasGenImageInputEventReceiverComponent r126 = this.a;
                InstructionTab r27 = r13.c;
                OptionItem r28 = r13.d;
                String r127 = r13.b;
                int r29 = CanvasGenImageInputEventReceiverComponent.w;
                r126.m3(r27, r28, r127, "speak");
                goto L76
            L74:
                CanvasGenImageInputEventReceiverComponent r128 = this.a;
                InstructionTab r30 = r13.c;
                OptionItem r31 = r13.d;
                String r129 = r13.b;
                int r32 = CanvasGenImageInputEventReceiverComponent.w;
                r128.m3(r30, r31, r129, "keyboard");
                goto L76
            L5:
                throw new NoWhenBranchMatchedException();
            L76:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass2(CanvasGenImageInputEventReceiverComponent r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            CanvasGenImageInputEventReceiverComponent r6 = this.this$0;
            int r2 = CanvasGenImageInputEventReceiverComponent.w;
            fy8.i r7 = r6.Y2();
            if (r7 == null) goto L18;
            a1 r8 = r7.jY();
            if (r8 == null) goto L18;
            a r3 = new a(this.this$0);
            this.label = 1;
            if (r8.collect(r3, this) != r0) goto L16;
            return r0;
        L18:
            return Unit.INSTANCE;
        }
    }

    public final void onResume() {
        this.s = false;
    }

    public final fy8.i Y2() {
        return (fy8.i) this.m.getValue();
    }

    public final fy8.h h3() {
        return (fy8.h) this.p.getValue();
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentManager r2 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getParentFragmentManager();
        Intrinsics.checkNotNullParameter(this, "<this>");
        r2.setFragmentResultListener("ai_creation_applet_image_remove_result", com.larus.ui.arch.component.internal.attach.a.b(this, this), new g(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass2(this, null), 3, null);
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, b0.class);
    }

    public CanvasGenImageInputEventReceiverComponent() {
        this.m = LazyKt.lazy(new a(this));
        this.n = LazyKt.lazy(new b(this));
        this.o = LazyKt.lazy(new c(this));
        this.p = LazyKt.lazy(new d(this));
        this.q = LazyKt.lazy(new e(this));
        this.r = LazyKt.lazy(new f(this));
    }

    @Override // com.larus.canvas.feature.component.input.b0
    public final void Ss(ImageEditDataWithMask r41) {
        Intrinsics.checkNotNullParameter(r41, "data");
        String r8 = r41.getMaskImgFilePath();
        OptionItem r11 = this.u;
        if (r11 == null) goto L5;
        m3(this.t, OptionItem.copy$default(r11, 0, null, null, null, null, null, null, new MaskUri(null, null, null, null, null, r8, 31, null), null, null, null, null, null, null, null, 32639, null), null, "router_auto_send");
        return;
    L5:
        InstructionTab r12 = this.t;
        if (r12 == null) goto L12;
        OptionItem r20 = r12.getSingleOption();
        if (r20 == null) goto L10;
        OptionItem r21 = OptionItem.copy$default(r20, 0, null, null, null, null, null, null, new MaskUri(null, null, null, null, null, r8, 31, null), null, null, null, null, null, null, null, 32639, null);
    L11:
        m3(InstructionTab.copy$default(r12, null, null, null, null, null, null, null, r21, null, 383, null), this.u, null, "router_auto_send");
        return;
    L10:
        r21 = null;
        goto L11
    L12:
        fy8.h r1 = h3();
        if (r1 == null) goto L100;
        b1 r2 = r1.i70();
        if (r2 == null) goto L101;
        InstructionTabState r3 = (InstructionTabState) r2.getValue();
        if (r3 == null) goto L102;
        List<InstructionTab> r4 = r3.getInstructionTabList();
        if (r4 == null) goto L103;
        List<InstructionTab> r5 = r4;
        Iterator<T> r6 = r5.iterator();
    L22:
        if (r6.hasNext() == false) goto L39;
        Object r10 = r6.next();
        InstructionTab r7 = (InstructionTab) r10;
        Integer r9 = r7.getTabType();
        if (r9 != null) goto L27;
    L36:
        boolean r13 = false;
    L37:
        if (r13 == false) goto L22;
    L40:
        InstructionTab r14 = (InstructionTab) r10;
        if (r14 == null) goto L49;
        n2 r15 = (n2) this.n.getValue();
        if (r15 == null) goto L104;
        OptionItem r22 = r14.getSingleOption();
        if (r22 == null) goto L47;
        OptionItem r23 = OptionItem.copy$default(r22, 0, null, null, null, null, null, null, new MaskUri(null, null, null, null, null, r8, 31, null), null, null, null, null, null, null, null, 32639, null);
    L48:
        n2.a.a(r15, InstructionTab.copy$default(r14, null, null, null, null, null, null, null, r23, null, 383, null), null, false);
        return;
    L47:
        r23 = null;
        goto L48
    L104:
        return;
    L49:
        Iterator<T> r16 = r5.iterator();
    L51:
        if (r16.hasNext() == false) goto L61;
        Object r17 = r16.next();
        Integer r18 = ((InstructionTab) r17).getTabType();
        if (r18 != null) goto L56;
    L58:
        boolean r19 = false;
    L59:
        if (r19 == false) goto L51;
    L62:
        InstructionTab r24 = (InstructionTab) r17;
        if (r24 == null) goto L106;
        List<OptionItem> r25 = r24.getOptionList();
        if (r25 == null) goto L77;
        Iterator<T> r26 = r25.iterator();
    L68:
        if (r26.hasNext() == false) goto L75;
        Object r110 = r26.next();
        if (((OptionItem) r110).getId() != 3) goto L72;
        boolean r27 = true;
    L73:
        if (r27 == false) goto L68;
    L76:
        OptionItem r111 = (OptionItem) r110;
    L78:
        if (r111 == null) goto L107;
        n2 r112 = (n2) this.n.getValue();
        if (r112 == null) goto L108;
        n2.a.a(r112, r24, OptionItem.copy$default(r111, 0, null, null, null, null, null, null, new MaskUri(null, null, null, null, null, r8, 31, null), null, null, null, null, null, null, null, 32639, null), false);
        return;
    L108:
        return;
    L107:
        return;
    L72:
        r27 = false;
        goto L73
    L75:
        r110 = null;
        goto L76
    L77:
        r111 = null;
        goto L78
    L106:
        return;
    L56:
        if (r18.intValue() != 3) goto L58;
        r19 = true;
        goto L59
    L61:
        r17 = null;
        goto L62
    L27:
        if (r9.intValue() != 4) goto L36;
        OptionItem r28 = r7.getSingleOption();
        if (r28 != null) goto L31;
    L33:
        boolean r29 = false;
    L34:
        if (r29 == false) goto L36;
        r13 = true;
        goto L37
    L31:
        if (r28.getId() != 3) goto L33;
        r29 = true;
        goto L34
    L39:
        r10 = null;
        goto L40
    L103:
        return;
    L102:
        return;
    L101:
        return;
    }

    @Override // com.larus.canvas.feature.component.input.b0
    public final void h80(MediaAttachment r9, InstructionTab r10, OptionItem r11) {
        Intrinsics.checkNotNullParameter(r9, "imageInfo");
        this.t = r10;
        this.u = r11;
        this.s = true;
        boolean r4 = false;
        if (((CanvasHostUiPolicy) this.r.getValue()).a == false) goto L7;
        Bundle r1 = new Bundle();
        r1.putBoolean("ignore_image_size_check", true);
        r1.putSerializable("media_attachment", r9);
        if (ICreationWorkflowService.a.e0(getContext(), r1, false) == false) goto L7;
        return;
    L7:
        Context r2 = getContext();
        String r5 = null;
        if (r11 == null) goto L10;
        String r12 = r11.getRedirectSchema();
    L11:
        String r6 = "";
        if (r12 != null) goto L15;
        r12 = "";
    L15:
        if (r12.length() != 0) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == false) goto L32;
        if (r10 == null) goto L23;
        OptionItem r13 = r10.getSingleOption();
        if (r13 == null) goto L23;
        r5 = r13.getRedirectSchema();
    L23:
        if (r5 == null) goto L27;
        r6 = r5;
    L27:
        if (r6.length() != 0) goto L29;
        r4 = true;
    L29:
        if (r4 == false) goto L31;
        r12 = "sslocal://flow/image_edit/remove";
        goto L32
    L31:
        r12 = r6;
    L32:
        com.bytedance.router.i r14 = SmartRouter.buildRoute(r2, r12);
        r14.c.putExtra("ignore_image_size_check", true);
        r14.c.putExtra("media_attachment", r9);
        r14.d = 2130772343;
        r14.e = 2130772399;
        r14.e(70);
        return;
    L17:
        r7 = false;
        goto L18
    L10:
        r12 = null;
        goto L11
    }

    public final void m3(InstructionTab r8, OptionItem r9, String r10, String r11) {
        if (this.s == false) goto L5;
        return;
    L5:
        n2 r1 = (n2) this.n.getValue();
        if (r1 == null) goto L9;
        r1.h70(r8, r9, r10, false, r11);
        return;
    }
}
