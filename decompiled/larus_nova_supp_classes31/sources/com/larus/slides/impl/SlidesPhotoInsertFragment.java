package com.larus.slides.impl;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.camera.api.IFlowCamera;
import com.larus.photopicker.api.PhotoPicker;
import com.larus.platform.AlbumHelper;
import com.larus.platform.api.g3;
import com.larus.platform.model.MediaPickerUIMode;
import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.service.k2;
import com.larus.slides.biz.impl.databinding.LarusSlidesPhotoInsertLayoutBinding;
import com.larus.slides.sdk.api.media.ThumbType;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0002J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010\"\u001a\u00020\u001bH\u0016J\b\u0010#\u001a\u00020\u001bH\u0016J\b\u0010$\u001a\u00020\u001bH\u0002J\b\u0010%\u001a\u00020\u001bH\u0002J\b\u0010&\u001a\u00020\u001bH\u0002J\b\u0010'\u001a\u00020\u001bH\u0002J\b\u0010(\u001a\u00020)H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-H\u0002J*\u0010.\u001a\u00020\u001b2\b\u0010/\u001a\u0004\u0018\u00010+2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/larus/slides/impl/SlidesPhotoInsertFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/slides/biz/impl/databinding/LarusSlidesPhotoInsertLayoutBinding;", "bottomPhotoPickPage", "Lcom/larus/platform/api/IBottomPhotoPickerPage;", "photoAlbumFragment", "albumHelper", "Lcom/larus/platform/AlbumHelper;", "getAlbumHelper", "()Lcom/larus/platform/AlbumHelper;", "albumHelper$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "addMaskOnBottomMenuAndBottomSheet", "Lcom/larus/common_ui/view/BottomOverlayView;", "sheet", "onViewCreated", "", "view", "mobClickUploadEntranceInternal", "clickFrom", "", "hasPendingUpdateAlbumUI", "", "onResume", "onDestroy", "registerResultForAlbum", "registerResultForCamera", "startCamera", "startAlbum", "getBottomViewHeight", "", "getLatestPhotoUri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "onSelectLocalImageCallback", "uri", "imagePath", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SlidesPhotoInsertFragment extends DialogFragment {
    public static final /* synthetic */ int i = 0;
    public LarusSlidesPhotoInsertLayoutBinding d;
    public com.larus.platform.api.a0 e;
    public DialogFragment f;
    public final Lazy g;
    public boolean h;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.slides.impl.SlidesPhotoInsertFragment$onCreateView$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.slides.impl.SlidesPhotoInsertFragment$onCreateView$1", f = "SlidesPhotoInsertFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SlidesPhotoInsertFragment this$0;

        /* JADX INFO: renamed from: com.larus.slides.impl.SlidesPhotoInsertFragment$onCreateView$1$a */
        public static final class a implements com.larus.platform.api.b0 {
            public final /* synthetic */ SlidesPhotoInsertFragment a;

            @Override // com.larus.platform.api.b0
            public final void a(int r1) {
            }

            @Override // com.larus.platform.api.b0
            public final void b() {
            }

            @Override // com.larus.platform.api.b0
            public final boolean d() {
                return true;
            }

            @Override // com.larus.platform.api.b0
            public final void e(int r1) {
            }

            @Override // com.larus.platform.api.b0
            public final void f() {
            }

            @Override // com.larus.platform.api.b0
            public final void onPageShow() {
            }

            @Override // com.larus.platform.api.b0
            public final void c() {
                if ((this.a.getActivity() instanceof bx9.b) == false) goto L6;
                bx9.b r0 = this.a.getActivity();
                Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larus.slides.sdk.api.media.ISelectMediaBottomPage");
                r0.f();
                return;
            }

            public a(SlidesPhotoInsertFragment r1) {
                this.a = r1;
            }
        }

        public AnonymousClass1(SlidesPhotoInsertFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r27) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L37;
            ResultKt.throwOnFailure(r27);
            CoroutineScope r0 = (CoroutineScope) this.L$0;
            SlidesPhotoInsertFragment r1 = this.this$0;
            com.larus.platform.api.a0 r2 = null;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
            Context r4 = r1.getContext();     // Catch: Throwable -> L11
            if (r4 == null) goto L8;
            Uri r5 = SlidesPhotoInsertFragment.S90(r1, r4);     // Catch: Throwable -> L11
        L9:
            Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L11
        L14:
            if (Result.exceptionOrNull-impl(r6) == null) goto L18;
            FLogger.a.d("SlidesPhotoInsertFragment", "getLatestPhotoBitmap fail");
            r6 = null;
        L18:
            if (r6 == null) goto L20;
            boolean r7 = true;
        L21:
            k2 r8 = k2.a;
            boolean r9 = g3.a.d();
            FLogger.a.i("SlidesPhotoInsertFragment", "[showBottomAlbum] hasReadPermission:" + r9 + ", albumHasImage:" + r7);
            if (r9 == true) goto L25;
            String r10 = "no_permission";
        L24:
            final String r11 = r10;
            SlidesPhotoInsertFragment r12 = this.this$0;
            int r13 = SlidesPhotoInsertFragment.i;
            r12.getClass();
            int r14 = i5.U() - i5.i();
            if (this.this$0.isAdded() == false) goto L35;
            SlidesPhotoInsertFragment r15 = this.this$0;
            PhotoPicker r16 = (PhotoPicker) ServiceManager.get().getService(PhotoPicker.class);
            if (r16 == null) goto L33;
            AlbumSettingConfig.a r17 = new AlbumSettingConfig.a();
            r17.g = Boxing.boxInt(ContextCompat.getColor(this.this$0.requireContext(), 2131103292));
            r17.e = false;
            r17.c = false;
            r17.u = false;
            r17.h = 4;
            AlbumSettingConfig r18 = r17.a();
            kq9.e r19 = new kq9.e(null, null, 0, null, null, null, null, null, null, Boxing.boxBoolean(true), null, null, 3579);
            MediaPickerUIMode r110 = MediaPickerUIMode.COLLAPSED_BOTTOM_SHEET;
            final SlidesPhotoInsertFragment r20 = this.this$0;
            r2 = r16.f(new hq9.b0(new q0(r20), r18, r11, new r0(r11, r20), r14, r19, new s0(), new t0(r20), r110, new a(r20), 122885));
        L33:
            r15.e = r2;
            Handler r21 = com.larus.utils.t0.a;
            final SlidesPhotoInsertFragment r22 = this.this$0;
            r21.post(new u0(r22));
        L35:
            return Unit.INSTANCE;
        L25:
            if (r7 == true) goto L27;
            r10 = "no_image";
            goto L24
        L27:
            r10 = "album_display";
            goto L24
        L20:
            r7 = false;
            goto L21
        L8:
            r5 = null;
        L11:
            th = move-exception;
            Result.Companion r23 = Result.Companion;
            r6 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L14
        L37:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.slides.impl.SlidesPhotoInsertFragment$onResume$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.slides.impl.SlidesPhotoInsertFragment$onResume$1", f = "SlidesPhotoInsertFragment.kt", i = {}, l = {271}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SlidesPhotoInsertFragment this$0;

        /* JADX INFO: renamed from: com.larus.slides.impl.SlidesPhotoInsertFragment$onResume$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.slides.impl.SlidesPhotoInsertFragment$onResume$1$1", f = "SlidesPhotoInsertFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $type;
            int label;
            final /* synthetic */ SlidesPhotoInsertFragment this$0;

            public C00321(SlidesPhotoInsertFragment r1, String r2, Continuation<? super C00321> r3) {
                this.this$0 = r1;
                this.$type = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00321(this.this$0, this.$type, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L12;
                ResultKt.throwOnFailure(r2);
                if (this.this$0.isAdded() == false) goto L10;
                com.larus.platform.api.a0 r3 = this.this$0.e;
                if (r3 == null) goto L10;
                r3.cP(this.$type);
            L10:
                return Unit.INSTANCE;
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C01471(SlidesPhotoInsertFragment r1, Continuation<? super C01471> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C01471 r0 = new C01471(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L33:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            CoroutineScope r8 = (CoroutineScope) this.L$0;
            SlidesPhotoInsertFragment r9 = this.this$0;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
            Context r4 = r9.getContext();     // Catch: Throwable -> L15
            if (r4 == null) goto L12;
            Uri r10 = SlidesPhotoInsertFragment.S90(r9, r4);     // Catch: Throwable -> L15
        L13:
            Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L15
        L18:
            if (Result.exceptionOrNull-impl(r11) == null) goto L21;
            FLogger.a.d("SlidesPhotoInsertFragment", "getLatestPhotoBitmap fail");
            r11 = null;
        L21:
            if (r11 == null) goto L23;
            boolean r12 = true;
        L24:
            k2 r5 = k2.a;
            if (g3.a.d() == false) goto L33;
            if (r12 == true) goto L28;
            String r13 = "no_image";
        L29:
            MainCoroutineDispatcher r6 = Dispatchers.getMain();
            C00321 r14 = new C00321(this.this$0, r13, null);
            this.label = 1;
            if (BuildersKt.withContext(r6, r14, this) != r0) goto L33;
            return r0;
        L28:
            r13 = "album_display";
            goto L29
        L23:
            r12 = false;
            goto L24
        L12:
            r10 = null;
        L15:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            r11 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L18
        }
    }

    static {
    }

    public final void startCamera() {
        HashMap r4 = new HashMap();
        r4.put("chat_key", 0L);
        r4.put("click_from", "plus_panel");
        JSONObject r0 = new JSONObject();
        r0.put("is_ai_ppt", 1);
        r0.put("current_page", "camera");
        r0.put("canvas_type", "aippt_new");
        Bundle r1 = getArguments();
        if (r1 == null) goto L6;
        String r2 = r1.getString("presentation_id");
        if (r2 == null) goto L6;
    L10:
        r0.put("presentation_id", r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L13;
        String r5 = r3.getString("resource_id");
    L14:
        r0.put("resource_id", r5);
        Bundle r6 = getArguments();
        if (r6 == null) goto L17;
        Integer r7 = Integer.valueOf(r6.getInt("resource_type"));
    L18:
        r0.put("resource_type", r7);
        Bundle r8 = getArguments();
        if (r8 == null) goto L21;
        String r9 = r8.getString("artifact_meta_id");
    L22:
        r0.put("artifact_meta_id", r9);
        Bundle r10 = getArguments();
        if (r10 == null) goto L26;
        Object r11 = r10.getString("artifact_type");
        if (r11 == null) goto L26;
    L30:
        r0.put("artifact_type", r11);
        Bundle r12 = getArguments();
        if (r12 == null) goto L33;
        String r13 = r12.getString("aippt_task_id");
    L34:
        r0.put("aippt_task_id", r13);
        Unit r14 = Unit.INSTANCE;
        r4.put("extra_params", r0);
        hx8.a r15 = new hx8.a("slides", "CAPTURE_MODE_PHOTO", null, r4, null, null, null, null, null, null, false, false, false, null, false, 0, false, null, null, false, 0, null, false, false, false, null, null, null, null, 1073738736);
        IFlowCamera r16 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r16 == null) goto L38;
        r16.r(this, r15, null);
        return;
    L38:
        return;
    L33:
        r13 = null;
    L26:
        Bundle r17 = getArguments();
        if (r17 == null) goto L29;
        r11 = Integer.valueOf(r17.getInt("resource_type"));
        goto L30
    L29:
        r11 = null;
        goto L30
    L21:
        r9 = null;
        goto L22
    L17:
        r7 = null;
        goto L18
    L13:
        r5 = null;
    L6:
        Bundle r18 = getArguments();
        if (r18 == null) goto L9;
        r2 = r18.getString("resource_id");
        goto L10
    L9:
        r2 = null;
        goto L10
    }

    public SlidesPhotoInsertFragment() {
        this.g = LazyKt.lazy(new m0());
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        DialogFragment r0 = this.f;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L19;
        DialogFragment r2 = this.f;
        if (r2 == null) goto L20;
        r2.dismissAllowingStateLoss();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L21;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L5:
        if (r0.isAdded() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        DialogFragment r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0 == null) goto L9;
        boolean r2 = true;
        if (r0.isAdded() != true) goto L9;
    L10:
        if (r2 == true) goto L12;
        return;
    L12:
        if (this.h == false) goto L17;
        this.h = false;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new C01471(this, null), 2, null);
        return;
    L17:
        return;
    L9:
        r2 = false;
        goto L10
    }

    public final void T90(String r27) {
        Bundle r0 = getArguments();
        String r1 = null;
        if (r0 == null) goto L5;
        Integer r18 = Integer.valueOf(r0.getInt("resource_type"));
    L6:
        Bundle r2 = getArguments();
        if (r2 == null) goto L9;
        String r16 = r2.getString("presentation_id");
    L10:
        Bundle r3 = getArguments();
        if (r3 == null) goto L13;
        String r17 = r3.getString("resource_id");
    L14:
        Bundle r4 = getArguments();
        if (r4 == null) goto L17;
        String r19 = r4.getString("artifact_meta_id");
    L18:
        Bundle r5 = getArguments();
        if (r5 == null) goto L21;
        Integer r20 = Integer.valueOf(r5.getInt("artifact_type"));
    L22:
        Bundle r6 = getArguments();
        if (r6 == null) goto L25;
        r1 = r6.getString("aippt_task_id");
    L25:
        tx9.c0.H(null, r27, null, null, null, "aippt_new_detail", null, null, null, null, null, null, null, 0, r16, r17, r18, r19, r20, r1, "aippt_new", null, null, 31473629);
        return;
    L21:
        r20 = r18;
        goto L22
    L17:
        r19 = null;
        goto L18
    L13:
        r17 = null;
        goto L14
    L9:
        r16 = null;
        goto L10
    L5:
        r18 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Uri S90(SlidesPhotoInsertFragment r19, Context r20) {
        Uri r0 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] r3 = {"_id"};
        ContentResolver r16 = r20.getContentResolver();
        f06.c r17 = new f06.c();
        Object[] r5 = {r0, r3, null, null, "date_added DESC"};
        f06.b r18 = new f06.b();
        f06.d r1 = r17.b(240004, "android/content/ContentResolver", "query", r16, r5, "android.database.Cursor", r18);
        if (r1.a == false) goto L5;
        r17.a(240004, "android/content/ContentResolver", "query", r16, r5, null, r18, false);
        Cursor r2 = (Cursor) r1.b;
        Throwable r4 = null;
    L6:
        if (r2 == null) goto L21;
        Cursor r6 = r2;
        Cursor r7 = r6;     // Catch: Throwable -> L14
        if (r7.moveToFirst() == false) goto L12;
        Uri r8 = Uri.withAppendedPath(r0, String.valueOf(r7.getLong(r7.getColumnIndexOrThrow("_id"))));     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r6, r4);
        return r8;
    L12:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r6, r4);
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);
        throw th;
    L21:
        return r4;
    L5:
        r2 = r16.query(r0, r3, null, null, "date_added DESC");
        r4 = null;
        r17.a(240004, "android/content/ContentResolver", "query", r16, r5, r2, r18, true);
        goto L6
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        int r5 = i5.U();
        FLogger.a.i("SlidesPhotoInsertFragment", "Keyboard height: " + r5);
        LarusSlidesPhotoInsertLayoutBinding r6 = this.d;
        if (r6 == null) goto L7;
        LinearLayout r7 = r6.e;
        if (r7 == null) goto L7;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r8).height = r5;
    L7:
        LarusSlidesPhotoInsertLayoutBinding r9 = this.d;
        if (r9 == null) goto L14;
        LinearLayout r10 = r9.b;
        if (r10 == null) goto L14;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L14;
        r11.height = r5;
    L14:
        LarusSlidesPhotoInsertLayoutBinding r12 = this.d;
        if (r12 == null) goto L19;
        LinearLayout r13 = r12.c;
        if (r13 == null) goto L19;
        e1.d(r13, new k0(this));
    L19:
        LarusSlidesPhotoInsertLayoutBinding r14 = this.d;
        if (r14 == null) goto L25;
        LinearLayout r15 = r14.d;
        if (r15 == null) goto L26;
        e1.d(r15, new l0(this));
        return;
    L26:
        return;
    }

    public final void U90(Uri r15, String r16, String r17) {
        if (r15 != null) goto L4;
        return;
    L4:
        if ((getActivity() instanceof bx9.c) == false) goto L18;
        Pair r0 = com.larus.office.base.utils.e.e(r15);
        bx9.c r1 = getActivity();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.larus.slides.sdk.api.media.ISelectMediaBridge");
        bx9.c r2 = r1;
        String r3 = com.larus.office.base.utils.e.f(r15);
        String r4 = com.larus.office.base.utils.e.g(r15);
        long r5 = com.larus.office.base.utils.e.d(r15);
        StringBuilder r6 = new StringBuilder("docsource://");
        if (r16 != null) goto L8;
        String r7 = com.larus.office.base.utils.e.h(r15);
    L9:
        r6.append(r7);
        String r9 = r6.toString();
        int r8 = 0;
        if (r0 == null) goto L12;
        int r10 = ((Number) r0.getSecond()).intValue();
    L13:
        if (r0 == null) goto L15;
        r8 = ((Number) r0.getFirst()).intValue();
    L15:
        String r11 = UUID.randomUUID().toString();
        r2.J0(new ThumbType(r3, r4, null, Long.valueOf(r5), Integer.valueOf(r10), Integer.valueOf(r8), r9, r11, 4, null), r17);
        return;
    L12:
        r10 = 0;
        goto L13
    L8:
        r7 = r16;
        goto L9
    }

    public final View onCreateView(LayoutInflater r19, ViewGroup r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r19, "inflater");
        AlbumHelper r2 = (AlbumHelper) this.g.getValue();
        Function1<? super AlbumSelectItem, Unit> r3 = new j0(this);
        Lazy<Handler> r4 = AlbumHelper.e;
        r2.b(this, "album_helper", r3);
        IFlowCamera r5 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r5 == null) goto L5;
        r5.m(this, new h0(this), new i0());
    L5:
        View r1 = r19.inflate(2131563142, null, false);
        int r6 = 2131369275;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131369275);
        if (r7 == null) goto L22;
        r6 = 2131369276;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131369276);
        if (r8 == null) goto L22;
        r6 = 2131369277;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131369277);
        if (r9 == null) goto L22;
        LinearLayout r10 = (LinearLayout) r1;
        r6 = 2131369279;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131369279);
        if (r11 == null) goto L22;
        r6 = 2131377546;
        if (((ImageView) ViewBindings.findChildViewById(r1, 2131377546)) == null) goto L22;
        r6 = 2131377547;
        if (ViewBindings.findChildViewById(r1, 2131377547) == null) goto L22;
        this.d = new LarusSlidesPhotoInsertLayoutBinding(r10, r7, r8, r9, r10, r11);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
        LarusSlidesPhotoInsertLayoutBinding r12 = this.d;
        if (r12 != null) goto L20;
        return null;
    L20:
        return r12.a;
    L22:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r6)));
    }
}
