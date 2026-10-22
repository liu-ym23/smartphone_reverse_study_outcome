package com.larus.camera.impl.ui.component.result.general;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResult;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.camera.api.params.CameraResultOutOpenParams;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.FlowCameraImpl;
import com.larus.camera.impl.databinding.LarusLayoutViewSuggestedActionComponentBinding;
import com.larus.camera.impl.entity.EduResultMode;
import com.larus.camera.impl.entity.ResultSuggestType;
import com.larus.camera.impl.result.CameraResultFirstFlow;
import com.larus.camera.impl.ui.activity.CameraResultFirstActivity;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import com.larus.common_ui.view.SuggestedActionBar;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.action.InstructionConfig;
import com.larus.platform.model.action.InstructionRedirectType;
import com.larus.platform.model.action.RedirectionCfg;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionData;
import com.larus.platform.model.action.SuggestedActionKey;
import com.larus.platform.model.action.SuggestedActionScene;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.chat.ObricChatSPIServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ResultSuggestedActionComponent extends com.larus.camera.impl.ui.arch.b {
    public static final /* synthetic */ int w = 0;
    public LarusLayoutViewSuggestedActionComponentBinding m;
    public List<SuggestedAction> n;
    public ResultSuggestType o;
    public List<SuggestedActionBar.c> p;
    public String q;
    public String r;
    public int s;
    public boolean t;
    public boolean u;
    public int v;

    public static final class a {
    }

    public final class b implements SuggestedActionBar.a {
        public final String a;
        public final String b;
        public final List<SuggestedAction> c;
        public final /* synthetic */ ResultSuggestedActionComponent d;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[CameraResultFirstFlow.CreationPageReturnResult.values().length];
                r0[CameraResultFirstFlow.CreationPageReturnResult.RESULT_FIRST_COMPLETED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[CameraResultFirstFlow.CreationPageReturnResult.RESULT_FIRST_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[CameraResultFirstFlow.CreationPageReturnResult.NOT_RESULT_FIRST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public final void c(CameraResultViewModel r14, ActivityResult r15) {
            CameraResultOutOpenParams r1 = null;
            if (r15.getResultCode() == (-1)) goto L9;
            ex8.b r16 = this.d.u();
            if (r16 != null) goto L7;
            return;
        L7:
            r16.a(this.b, 11, null);
            return;
        L9:
            Intent r0 = r15.getData();
            if (r0 != null) goto L12;
            r0 = new Intent();
        L12:
            boolean r4 = false;
            if (r0.getBooleanExtra("creation_message_sent", false) == false) goto L42;
            Context r3 = this.d.getContext();
            if ((r3 instanceof Activity) == false) goto L17;
            Activity r5 = (Activity) r3;
        L18:
            if (r5 == null) goto L40;
            String r9 = r0.getStringExtra("argConversationId");
            CameraResultFirstFlow.a.getClass();
            if ((r5 instanceof CameraResultFirstActivity) == false) goto L31;
            int r2 = a.a[CameraResultFirstFlow.d(r5, r9).ordinal()];
            if (r2 == 1) goto L30;
            if (r2 == 2) goto L29;
            if (r2 == 3) goto L40;
            throw new NoWhenBranchMatchedException();
        L29:
            FLogger.a.e("ResultSuggestedActionComponent", "complete sent result-first creation message failed");
            r14.closePage();
        L39:
            r4 = true;
            goto L40
        L30:
            r14.closePage();
            goto L39
        L31:
            com.larus.camera.impl.result.a.a.getClass();
            if (com.larus.camera.impl.result.a.e(r5) == false) goto L40;
            if (com.larus.camera.impl.result.a.b(r5, r9) == false) goto L37;
            r14.setResult(500000, new Intent());
        L38:
            r14.closePage();
            goto L39
        L37:
            FLogger.a.e("ResultSuggestedActionComponent", "complete sent capture-first creation message failed");
            r14.setResult(-1, r0);
        L40:
            if (r4 == false) goto L42;
            return;
        L17:
            r5 = null;
        L42:
            CameraResultFirstFlow r6 = CameraResultFirstFlow.a;
            Context r7 = this.d.getContext();
            if ((r7 instanceof Activity) == false) goto L45;
            Activity r8 = (Activity) r7;
        L46:
            r6.getClass();
            if (r8 == null) goto L64;
            Intent r10 = r8.getIntent();
            if (r10 == null) goto L64;
            String r11 = r10.getStringExtra("extra_camera_result_first_command_session_id");
            if (r11 != null) goto L54;
            CameraResultFirstFlow.CreationPageReturnResult r12 = CameraResultFirstFlow.CreationPageReturnResult.NOT_RESULT_FIRST;
        L65:
            int r13 = a.a[r12.ordinal()];
            if (r13 == 1) goto L73;
            if (r13 == 2) goto L72;
            if (r13 != 3) goto L71;
            r14.setResult(r15.getResultCode(), r0);
            r14.closePage();
            return;
        L71:
            throw new NoWhenBranchMatchedException();
        L72:
            FLogger.a.e("ResultSuggestedActionComponent", "complete result-first creation page return failed");
            r14.closePage();
            return;
        L73:
            r14.closePage();
            return;
        L54:
            Serializable r17 = r10.getSerializableExtra("KEY_OPEN_CAMERA_RESULT_PAGE_OUT_OPEN_PARAMS");
            if ((r17 instanceof CameraResultOutOpenParams) == false) goto L57;
            r1 = (CameraResultOutOpenParams) r17;
        L57:
            CameraResultFirstFlow.h(r11);
            Bundle r18 = r0.getExtras();
            if (r18 != null) goto L60;
            FLogger.a.e("CameraResultFirstFlow", "creation page result extras missing");
            r12 = CameraResultFirstFlow.CreationPageReturnResult.RESULT_FIRST_FAILED;
            goto L65
        L60:
            ConcurrentHashMap r19 = com.larus.bmhome.chat.camera.command.k.a;
            Intrinsics.checkNotNullParameter(r18, "resultBundle");
            long r20 = System.currentTimeMillis();
            ConcurrentHashMap r21 = com.larus.bmhome.chat.camera.command.k.a;
            CollectionsKt.removeAll(r21.entrySet(), new com.larus.bmhome.chat.camera.command.j(r20));
            String r22 = UUID.randomUUID().toString();
            r21.put(r22, new com.larus.bmhome.chat.camera.command.t.b(new Bundle(r18), System.currentTimeMillis()));
            if (CameraResultFirstFlow.g(r22, r1, "creation") == false) goto L63;
            r12 = CameraResultFirstFlow.CreationPageReturnResult.RESULT_FIRST_COMPLETED;
            goto L65
        L63:
            r12 = CameraResultFirstFlow.CreationPageReturnResult.RESULT_FIRST_FAILED;
        L64:
            r12 = CameraResultFirstFlow.CreationPageReturnResult.NOT_RESULT_FIRST;
            goto L65
        L45:
            r8 = null;
            goto L46
        }

        public b(ResultSuggestedActionComponent r2, String r3, String r4, List<SuggestedAction> r5) {
            Intrinsics.checkNotNullParameter(r3, "bizScene");
            Intrinsics.checkNotNullParameter(r4, "cameraScene");
            this.d = r2;
            this.a = r3;
            this.b = r4;
            this.c = r5;
        }

        public final void a(String r8, int r9, int r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r8, "key");
            final CameraResultViewModel r12 = (CameraResultViewModel) com.larus.camera.impl.ui.arch.b.e(this.d).a();
            if (r12 != null) goto L5;
            return;
        L5:
            List<SuggestedAction> r13 = this.c;
            String r0 = null;
            if (r13 == null) goto L15;
            Iterator<T> r14 = r13.iterator();
        L9:
            if (r14.hasNext() == false) goto L13;
            Object r1 = r14.next();
            if (Intrinsics.areEqual(((SuggestedAction) r1).getSuggestedActionKey(), r8) == false) goto L9;
        L14:
            SuggestedAction r2 = (SuggestedAction) r1;
        L16:
            int r15 = -1;
            if (r2 == null) goto L21;
            List<SuggestedAction> r3 = this.c;
            if (r3 == null) goto L21;
            r15 = r3.indexOf(r2);
        L21:
            final ex8.b r4 = this.d.u();
            boolean r5 = false;
            if (r4 != null) goto L39;
            if (Intrinsics.areEqual(r8, SuggestedActionKey.AIBeautify.getValue()) == false) goto L26;
            return;
        L26:
            if (Intrinsics.areEqual(r8, SuggestedActionKey.AIVideoGenerate.getValue()) == true) goto L63;
            if (r2 == null) goto L30;
            r0 = r2.getDisplayName();
        L30:
            if (r0 != null) goto L33;
            r0 = "";
        L33:
            if (r0.length() <= 0) goto L35;
            r5 = true;
        L35:
            if (r5 == false) goto L62;
            r12.onComplete(new Pair(r0, 1), "suggest_onClick_no_listener");
            return;
        L62:
            return;
        L63:
            return;
        L39:
            if (Intrinsics.areEqual(r8, SuggestedActionKey.AIBeautify.getValue()) == false) goto L42;
            r12.getParamAlbumUrlOrBitmapPath(new z(r12, r4, this));
        L56:
            r4.a(this.b, 4, CollectionsKt.listOf(new Serializable[]{r2, Integer.valueOf(r15), Boolean.valueOf(r11), this.a, ResultSuggestedActionComponent.p(this.d)}));
            return;
        L42:
            if (Intrinsics.areEqual(r8, SuggestedActionKey.AIVideoGenerate.getValue()) == false) goto L55;
            if (r2 == null) goto L51;
            RedirectionCfg r16 = r2.getRedirectionCfg();
            if (r16 == null) goto L51;
            InstructionConfig r17 = r16.getInstructionConfig();
            if (r17 == null) goto L51;
            if (r17.getRedirectionType() != InstructionRedirectType.SendMessage.getValue()) goto L51;
            boolean r18 = true;
        L52:
            if (r18 == false) goto L54;
            r4.a(this.b, 3, r2);
            CameraResultViewModel.onComplete$default(r12, null, "suggest_video_generate", 1, null);
            goto L56
        L54:
            r12.getParamAlbumUrlOrBitmapPath(new a0(r12, r4, this));
        L51:
            r18 = false;
            goto L52
        L55:
            r4.a(this.b, 3, r2);
            CameraResultViewModel.onComplete$default(r12, null, "suggest_onClick", 1, null);
            goto L56
        L13:
            r1 = null;
            goto L14
        L15:
            r2 = null;
            goto L16
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void b(String r5, int r6, int r7, boolean r8) {
            Intrinsics.checkNotNullParameter(r5, "key");
            List<SuggestedAction> r9 = this.c;
            Object r10 = null;
            if (r9 == null) goto L11;
            Iterator<T> r11 = r9.iterator();
        L6:
            if (r11.hasNext() == false) goto L10;
            Object r0 = r11.next();
            if (Intrinsics.areEqual(((SuggestedAction) r0).getSuggestedActionKey(), r5) == false) goto L6;
            r10 = r0;
        L10:
            r10 = (SuggestedAction) r10;
        L11:
            if (r10 == null) goto L15;
            List<SuggestedAction> r12 = this.c;
            if (r12 == null) goto L15;
            int r13 = r12.indexOf(r10);
        L16:
            ex8.b r14 = this.d.u();
            if (r14 == null) goto L23;
            r14.a(this.b, 5, CollectionsKt.listOf(new Serializable[]{r10, Integer.valueOf(r13), Boolean.valueOf(r8), this.a, ResultSuggestedActionComponent.p(this.d)}));
            return;
        L23:
            return;
        L15:
            r13 = -1;
            goto L16
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ResultSuggestType.values().length];
            r0[ResultSuggestType.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[ResultSuggestType.HOMEWORK_CORRECTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[ResultSuggestType.PHOTO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[ResultSuggestType.EDU_SINGLE_QUESTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[ResultSuggestType.EDU_MULTI_QUESTION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
    }

    public ResultSuggestedActionComponent() {
        super(com.larus.camera.impl.ui.arch.c.c, 1);
        this.n = CollectionsKt.emptyList();
        this.p = CollectionsKt.emptyList();
        this.q = "";
        this.r = "";
        this.v = -1;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final void m() {
        FLogger.a.i("ResultSuggestedActionComponent", "[onViewCreated] component instantiated and view created");
        CameraResultViewModel r0 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        BaseCameraViewModel.tryAdaptBottomLine$default(r0, h(2131367728), 0, null, 6, null);
        x(false);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getResultSuggestType(), new ResultSuggestedActionComponent$onViewCreated$1(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getInFreeInputMode(), new ResultSuggestedActionComponent$onViewCreated$2(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.previewThumbListDeleteStateFlow(), new ResultSuggestedActionComponent$onViewCreated$3(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getCaptureAppendComplete(), new ResultSuggestedActionComponent$onViewCreated$4(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.previewThumbListStateFlow(), new ResultSuggestedActionComponent$onViewCreated$5(this, null)), k());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getSuggestedActionBarDimmed(), new ResultSuggestedActionComponent$onViewCreated$6(this, null)), k());
        if (r0.enableResultDetect() == false) goto L8;
        com.larus.utils.e1.o(t());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r0.getResultDetectionStatus(), new ResultSuggestedActionComponent$onViewCreated$7(this, null)), k());
    L8:
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.w(new kotlinx.coroutines.flow.v0(r0.isInDrawingMode(), r0.isInCropMode(), new ResultSuggestedActionComponent$onViewCreated$8(null)), Dispatchers.getMain()), new ResultSuggestedActionComponent$onViewCreated$9(this, null)), k());
        MutableSharedFlow<com.larus.camera.impl.utils.eventbus.g> r1 = com.larus.camera.impl.utils.eventbus.c.a;
        CoroutineScope r2 = k();
        final kotlinx.coroutines.flow.a1 r3 = com.larus.camera.impl.utils.eventbus.c.b;
        Flow<Object> r4 = new ResultSuggestedActionComponent$subscribeToChangeSuggestedActionPosition$$inlined$subscribe$1(r3);
        kotlinx.coroutines.flow.g1.a.getClass();
        kotlinx.coroutines.flow.h1 r5 = kotlinx.coroutines.flow.g1.a.b;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.D(r4, r2, r5, 0), new ResultSuggestedActionComponent$subscribeToChangeSuggestedActionPosition$$inlined$subscribe$2(null, this)), r2);
        CoroutineScope r6 = k();
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.D(new ResultSuggestedActionComponent$subscribeToChangeSuggestedActionVisibility$$inlined$subscribe$1(r3), r6, r5, 0), new ResultSuggestedActionComponent$subscribeToChangeSuggestedActionVisibility$$inlined$subscribe$2(null, this)), r6);
        CoroutineScope r7 = k();
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.D(new ResultSuggestedActionComponent$subscribeToChangeSuggestedActionSuppressedForInputText$$inlined$subscribe$1(r3), r7, r5, 0), new ResultSuggestedActionComponent$subscribeToChangeSuggestedActionSuppressedForInputText$$inlined$subscribe$2(null, this)), r7);
        CoroutineScope r8 = k();
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.D(new ResultSuggestedActionComponent$subscribeToInvokeSuggestedAction$$inlined$subscribe$1(r3), r8, r5, 0), new ResultSuggestedActionComponent$subscribeToInvokeSuggestedAction$$inlined$subscribe$2(null, this)), r8);
        CoroutineScope r9 = k();
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.D(new ResultSuggestedActionComponent$subscribeToInputStatus$$inlined$subscribe$1(r3), r9, r5, 0), new ResultSuggestedActionComponent$subscribeToInputStatus$$inlined$subscribe$2(null, this)), r9);
        CoroutineScope r10 = k();
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.D(new ResultSuggestedActionComponent$subscribeToInputStatus$$inlined$subscribe$3(r3), r10, r5, 0), new ResultSuggestedActionComponent$subscribeToInputStatus$$inlined$subscribe$4(null, this)), r10);
        yx8.a r11 = yx8.c.a;
        if (Intrinsics.areEqual(yx8.c.a, yx8.a.d.b) == true) goto L12;
        com.larus.utils.e1.o(t());
        return;
    L12:
        if (v() == true) goto L16;
        w(false);
        return;
    }

    public final SuggestedActionBar t() {
        LarusLayoutViewSuggestedActionComponentBinding r0 = this.m;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L6:
        return r0.b;
    }

    public final boolean v() {
        CameraResultViewModel r0 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L12;
        if (r0.currentPreviewIsVideo() == false) goto L12;
    L15:
        return true;
    L12:
        if (this.n.isEmpty() == true) goto L15;
        if (this.o == ResultSuggestType.NONE) goto L15;
        return false;
    L5:
        if (CameraResultViewModel.shouldUseUnifiedPreviewFramework$default(r0, null, 1, null) != true) goto L7;
        r3 = true;
        goto L8
    }

    public final ex8.b u() {
        Context r0 = getContext();
        if ((r0 instanceof Activity) == false) goto L5;
        Activity r1 = (Activity) r0;
    L6:
        CameraResultFirstFlow.a.getClass();
        boolean r3 = true;
        if ((r1 instanceof CameraResultFirstActivity) == false) goto L23;
        if (r1 == null) goto L12;
        Intent r2 = r1.getIntent();
        if (r2 == null) goto L12;
        String r4 = r2.getStringExtra("extra_camera_result_first_command_session_id");
    L13:
        if (r4 != null) goto L15;
    L18:
        if (r3 == true) goto L51;
        CameraResultFirstFlow.a r5 = CameraResultFirstFlow.c.get(r4);
        if (r5 != null) goto L48;
        return null;
    L48:
        return r5.j;
    L51:
        return null;
    L15:
        if (r4.length() == 0) goto L18;
        r3 = false;
    L12:
        r4 = null;
        goto L13
    L23:
        com.larus.camera.impl.result.a.a.getClass();
        if (com.larus.camera.impl.result.a.e(r1) == false) goto L46;
        if (r1 == null) goto L29;
        Intent r6 = r1.getIntent();
        if (r6 == null) goto L29;
        Serializable r7 = r6.getSerializableExtra("CAMERA_INPUT_PARAM");
    L31:
        if ((r7 instanceof InputParam) == false) goto L33;
        InputParam r8 = (InputParam) r7;
    L34:
        String r9 = com.larus.camera.impl.result.a.d(r8);
        if (r9 != null) goto L37;
    L40:
        if (r3 == true) goto L52;
        CameraResultFirstFlow.a r10 = com.larus.camera.impl.result.a.b.get(r9);
        if (r10 != null) goto L50;
        return null;
    L50:
        return r10.j;
    L52:
        return null;
    L37:
        if (r9.length() == 0) goto L40;
        r3 = false;
        goto L40
    L33:
        r8 = null;
    L29:
        r7 = null;
        goto L31
    L46:
        return FlowCameraImpl.c;
    L5:
        r1 = null;
        goto L6
    }

    public static final String p(ResultSuggestedActionComponent r5) {
        CameraResultViewModel r0 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) r5.e.getValue()).a();
        if (r0 == null) goto L7;
        kotlinx.coroutines.flow.i1<px8.b> r1 = r0.getEduResultTabState();
        if (r1 == null) goto L7;
        px8.b r2 = (px8.b) r1.getValue();
    L8:
        boolean r3 = false;
        if (r2 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == true) goto L16;
    L20:
        if (r3 == false) goto L23;
        return "picture_mode";
    L23:
        return null;
    L16:
        if (r2.b != EduResultMode.PHOTO) goto L20;
        if (r5.o != ResultSuggestType.PHOTO) goto L20;
        r3 = true;
        goto L20
    L11:
        if (r2.c != true) goto L13;
        r4 = true;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r2) {
        CameraContainer.b r3 = super.f(r2);
        ((FrameLayout.LayoutParams) r3).width = -1;
        ((FrameLayout.LayoutParams) r3).height = -1;
        return r3;
    }

    public final List<SuggestedActionBar.c> r(List<SuggestedAction> r14) {
        List<SuggestedAction> r15 = r14;
        if ((r15 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r0 = r15.iterator();
    L9:
        if (r0.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((SuggestedAction) r0.next()).getSuggestedActionKey(), SuggestedActionKey.AIBeautify.getValue()) == false) goto L9;
        boolean r1 = true;
    L14:
        CameraResultViewModel r3 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r3 == null) goto L17;
        r3.updateHasAccessToAIBeauty(r1);
    L17:
        if (r3 == null) goto L19;
        String r2 = r3.getSuggestionPrefix();
    L21:
        if (r2 != null) goto L23;
        r2 = "";
    L23:
        ArrayList r4 = new ArrayList();
        Iterator<T> r16 = r15.iterator();
    L25:
        if (r16.hasNext() == false) goto L35;
        Object r5 = r16.next();
        if (Intrinsics.areEqual(((SuggestedAction) r5).getSuggestedActionKey(), SuggestedActionKey.AIBeautify.getValue()) == true) goto L29;
    L32:
        boolean r6 = true;
    L33:
        if (r6 == false) goto L25;
        r4.add(r5);
        goto L25
    L29:
        if (z2.a.enableTopBeautyButton() == false) goto L32;
        r6 = false;
        goto L33
    L35:
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r7 = r4.iterator();
    L37:
        if (r7.hasNext() == false) goto L46;
        SuggestedAction r8 = (SuggestedAction) r7.next();
        String r9 = r8.getSuggestedActionKey();
        if (r9 != null) goto L41;
        String r10 = "";
    L42:
        String r11 = r8.getDisplayName();
        if (r11 != null) goto L45;
        r11 = "";
    L45:
        r17.add(new SuggestedActionBar.c(r10, 0, r2.concat(r11), false, false, 250));
        goto L37
    L41:
        r10 = r9;
        goto L42
    L46:
        ArrayList r12 = new ArrayList();
        Iterator r18 = r17.iterator();
    L48:
        if (r18.hasNext() == false) goto L55;
        Object r13 = r18.next();
        SuggestedActionBar.c r19 = (SuggestedActionBar.c) r13;
        IFlowSdkDepend r20 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r20 == null) goto L53;
        r20.v();
    L53:
        if ((!CollectionsKt.emptyList().contains(r19.a)) == false) goto L48;
        r12.add(r13);
        goto L48
    L55:
        return r12;
    L19:
        r2 = null;
    L13:
        r1 = false;
        goto L14
    L5:
        if (r15.isEmpty() == false) goto L7;
        goto L7
    }

    public final List<SuggestedAction> s(List<SuggestedAction> r5) {
        ResultSuggestType r0 = this.o;
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 4) goto L9;
        String r2 = SuggestedActionKey.EduSolveQuestionSingle.getValue();
    L13:
        ArrayList r3 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L15:
        if (r6.hasNext() == false) goto L19;
        Object r4 = r6.next();
        if (Intrinsics.areEqual(((SuggestedAction) r4).getSuggestedActionKey(), r2) == false) goto L15;
        r3.add(r4);
        goto L15
    L19:
        return r3;
    L9:
        if (r1 == 5) goto L11;
        return r5;
    L11:
        r2 = SuggestedActionKey.EduSolveQuestionMulti.getValue();
        goto L13
    L5:
        r1 = c.a[r0.ordinal()];
        goto L7
    }

    public final void w(boolean r6) {
        CameraResultViewModel r0 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        yx8.a r1 = yx8.c.a;
        boolean r3 = false;
        if ((!Intrinsics.areEqual(yx8.c.a, yx8.a.d.b)) == true) goto L8;
    L11:
        boolean r2 = true;
    L13:
        if (com.larus.camera.impl.utils.w.a() == true) goto L15;
    L20:
        boolean r4 = true;
    L21:
        if (r2 == false) goto L35;
        if (r4 == true) goto L24;
        return;
    L24:
        if (this.u == false) goto L26;
        return;
    L26:
        if (v() == true) goto L38;
        if (r6 == true) goto L29;
    L33:
        com.larus.utils.e1.x(t());
        return;
    L29:
        if (t().getVisibility() != 0) goto L31;
        r3 = true;
    L31:
        if (r3 == true) goto L33;
        t().g = true;
        t().c();
        return;
    L38:
        return;
    L35:
        return;
    L15:
        if (r0.enableResultDetect() == false) goto L20;
        if ((r0.getResultDetectionStatus().getValue() instanceof n.a) == true) goto L20;
        r4 = false;
        goto L21
    L8:
        if (this.t == true) goto L11;
        r2 = false;
        goto L13
    }

    public final void x(boolean r21) {
        CameraResultViewModel r0 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L5;
        return;
    L5:
        String r6 = r0.getCameraData().getScene();
        ICameraEventExt r1 = r0.getCameraData().getEventExt();
        String r2 = "";
        if (r1 == null) goto L13;
        JSONObject r3 = r1.enterPageEventExt();
        if (r3 == null) goto L13;
        String r4 = r3.optString("enter_method");
        if (r4 == null) goto L13;
        String r5 = r4;
    L14:
        ICameraEventExt r7 = r0.getCameraData().getEventExt();
        if (r7 == null) goto L19;
        JSONObject r8 = r7.enterCameraEventExt();
        if (r8 == null) goto L19;
        int r9 = r8.optInt("action_bar_instruction_type");
    L20:
        ResultSuggestType r10 = this.o;
        if (r10 != null) goto L23;
        int r11 = -1;
    L25:
        if (r11 == (-1)) goto L41;
        if (r11 != 1) goto L28;
        this.s++;
        this.n = CollectionsKt.emptyList();
        this.p = CollectionsKt.emptyList();
        this.v = -1;
        com.larus.utils.e1.o(t());
        return;
    L28:
        if (r11 != 2) goto L30;
    L53:
        int r12 = 9;
    L59:
        this.v = r12;
        int r13 = this.s + 1;
        this.s = r13;
        List r14 = null;
        if (r0.currentResultContainsVideo(r21) == false) goto L63;
        List<SuggestedAction> r15 = CollectionsKt.emptyList();
    L82:
        this.n = r15;
        if (r15.isEmpty() == true) goto L85;
    L125:
        List<SuggestedActionBar.c> r16 = r(this.n);
        if (((ArrayList) r16).isEmpty() == false) goto L128;
        FLogger.a.i("ResultSuggestedActionComponent", "updateSuggestedActionInfo, barItems is empty");
        com.larus.utils.e1.o(t());
        return;
    L128:
        FLogger.a.i("ResultSuggestedActionComponent", "updateSuggestedActionInfo, barItems is not empty deleteWhenContainsVideo" + r21);
        if (r21 == false) goto L131;
        w(false);
    L131:
        q(r16, r5, r6);
        return;
    L85:
        if (r0.shouldUseSuggestedActionCacheAsDefault() == false) goto L125;
        if (r12 == 1) goto L94;
        if (r12 == 12) goto L93;
        switch(r12) {
            case 8: goto L92;
            case 9: goto L91;
            case 10: goto L90;
            default: goto L89;
        };
    L89:
        SuggestedActionScene r17 = SuggestedActionScene.PreviewArea;
    L95:
        InputParam r18 = r0.getInputParam();
        if (r18 == null) goto L98;
        String r19 = r18.getBotId();
    L99:
        if (r19 != null) goto L101;
    L104:
        boolean r20 = true;
    L105:
        if (r20 == false) goto L107;
        List<SuggestedAction> r22 = CollectionsKt.emptyList();
    L114:
        if ((!r22.isEmpty()) == false) goto L120;
        FLogger r23 = FLogger.a;
        StringBuilder r110 = new StringBuilder("updateSuggestedActionInfo fallback from cache, botId=");
        if (r19 == null) goto L119;
        r2 = r19;
    L119:
        r110.append(r2);
        r110.append(", scene=");
        r110.append(r17);
        r110.append(", size=");
        r110.append(r22.size());
        r23.i("ResultSuggestedActionComponent", r110.toString());
        this.n = r22;
        goto L125
    L120:
        FLogger r24 = FLogger.a;
        StringBuilder r25 = new StringBuilder("updateSuggestedActionInfo cache miss, botId=");
        if (r19 == null) goto L124;
        r2 = r19;
    L124:
        r25.append(r2);
        r25.append(", scene=");
        r25.append(r17);
        r24.i("ResultSuggestedActionComponent", r25.toString());
        goto L125
    L107:
        SuggestedActionData r26 = bc8.e.a.b(r19);
        if (r26 == null) goto L110;
        r14 = r26.get(r17);
    L110:
        if (r14 != null) goto L112;
        r14 = CollectionsKt.emptyList();
    L112:
        r22 = CollectionsKt.filterNotNull(r14);
        goto L114
    L101:
        if (r19.length() == 0) goto L104;
        r20 = false;
        goto L105
    L98:
        r19 = null;
        goto L99
    L90:
        r17 = SuggestedActionScene.PPTGenerationSingleImg;
        goto L95
    L91:
        r17 = SuggestedActionScene.HomeworkCorrectionCamera;
        goto L95
    L92:
        r17 = SuggestedActionScene.AttachmentAreaMultiImg;
        goto L95
    L93:
        r17 = SuggestedActionScene.EduSolveQuestionCamera;
        goto L95
    L94:
        r17 = SuggestedActionScene.PreviewArea;
        goto L95
    L63:
        if (Intrinsics.areEqual(r6, "prompt_direct_send") == false) goto L65;
        r15 = CollectionsKt.emptyList();
        goto L82
    L65:
        ex8.b r27 = u();
        if (r27 == null) goto L68;
        Object r28 = r27.a(r6, r12, r5);
    L70:
        if ((r28 instanceof Deferred) == false) goto L76;
        if (ObricChatSPIServiceDelegate.b.j() == false) goto L76;
        BuildersKt.launch$default(k(), null, null, new ResultSuggestedActionComponent$updateSuggestedAsync$1(r13, this, r28, r21, r5, r6, null), 3, null);
        return;
    L76:
        if ((r28 instanceof List) == false) goto L78;
        List<SuggestedAction> r29 = (List) r28;
    L79:
        if (r29 != null) goto L81;
        r29 = CollectionsKt.emptyList();
    L81:
        r15 = s(r29);
        goto L82
    L78:
        r29 = null;
        goto L79
    L68:
        r28 = null;
        goto L70
    L30:
        if (r11 != 3) goto L32;
    L57:
        r12 = 1;
        goto L59
    L32:
        if (r11 != 4) goto L34;
    L38:
        r12 = 12;
        goto L59
    L34:
        if (r11 == 5) goto L38;
        throw new NoWhenBranchMatchedException();
    L41:
        com.larus.camera.impl.ui.viewmodel.t r30 = com.larus.camera.impl.ui.viewmodel.t.a;
        if (com.larus.camera.impl.ui.viewmodel.t.e() <= 1) goto L44;
    L58:
        r12 = 8;
        goto L59
    L44:
        if (this.v != (-1)) goto L52;
        List<OutputParam> r31 = r0.getOriginMultiOutputParamList();
        if (r31 == null) goto L48;
        int r32 = r31.size();
    L49:
        if (r32 <= 1) goto L52;
    L48:
        r32 = 0;
    L52:
        if (CollectionsKt.listOf(new String[]{"edu_photo_search", "edu_homework_correct"}).contains(r6) == true) goto L53;
        int r33 = od8.h0.a;
        if (od8.h0.f(Integer.valueOf(r9)) == false) goto L57;
        r12 = 10;
        goto L59
    L23:
        r11 = c.a[r10.ordinal()];
    L19:
        r9 = -1;
    L13:
        r5 = "";
        goto L14
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        ConstraintLayout r6 = r4.inflate(2131562924, r5, false);
        int r7 = 2131364481;
        if (ViewBindings.findChildViewById(r6, 2131364481) == null) goto L16;
        ConstraintLayout r8 = r6;
        if (ViewBindings.findChildViewById(r6, 2131373056) == null) goto L14;
        SuggestedActionBar r1 = ViewBindings.findChildViewById(r6, 2131387698);
        if (r1 != null) goto L9;
        r7 = 2131387698;
        goto L16
    L9:
        if (ViewBindings.findChildViewById(r6, 2131389181) == null) goto L12;
        this.m = new LarusLayoutViewSuggestedActionComponentBinding(r8, r1);
        return r8;
    L12:
        r7 = 2131389181;
        goto L16
    L14:
        r7 = 2131373056;
    L16:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }

    public final void q(List<SuggestedActionBar.c> r6, String r7, String r8) {
        this.p = r6;
        this.q = r7;
        this.r = r8;
        CameraResultViewModel r0 = (CameraResultViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r0 != null) goto L6;
        return;
    L6:
        if (((Boolean) r0.isInDrawingMode().getValue()).booleanValue() == false) goto L8;
    L12:
        SuggestedActionBar r1 = t();
        b r3 = new b(this, r7, r8, this.n);
        if (((Boolean) r0.getInFreeInputMode().getValue()).booleanValue() == false) goto L15;
        int r9 = 2131238808;
    L16:
        r1.e(r6, r3, false, Integer.valueOf(r9));
        return;
    L15:
        r9 = 2131238805;
        goto L16
    L8:
        if (((Boolean) r0.isInCropMode().getValue()).booleanValue() == true) goto L12;
        if (v() == true) goto L12;
        w(false);
        goto L12
    }
}
