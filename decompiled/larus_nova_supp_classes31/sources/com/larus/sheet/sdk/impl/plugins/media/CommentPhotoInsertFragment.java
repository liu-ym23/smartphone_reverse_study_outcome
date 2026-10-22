package com.larus.sheet.sdk.impl.plugins.media;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.config.CommentImageSelectorDismissReason;
import com.larus.camera.api.IFlowCamera;
import com.larus.photopicker.api.PhotoPicker;
import com.larus.platform.AlbumHelper;
import com.larus.platform.api.g3;
import com.larus.platform.model.MediaPickerUIMode;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.platform.service.k2;
import com.larus.sheet.sdk.impl.databinding.LarusCommentPhotoInsertLayoutBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 I2\u00020\u0001:\u0001IB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0014\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010$\u001a\u00020%2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020'H\u0016J\u001a\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010-\u001a\u00020'H\u0016J\b\u0010.\u001a\u00020'H\u0016J\b\u0010/\u001a\u00020'H\u0016J\b\u00100\u001a\u00020'H\u0016J\b\u00101\u001a\u00020'H\u0016J\b\u00102\u001a\u00020'H\u0016J\b\u00103\u001a\u00020'H\u0002J\b\u00104\u001a\u00020'H\u0002J\b\u00105\u001a\u00020'H\u0002J\b\u00106\u001a\u00020'H\u0002J\b\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u000208H\u0002J\b\u0010:\u001a\u00020\u0018H\u0002J0\u0010;\u001a\u00020'2\u001a\u0010<\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020?\u0012\u0006\u0012\u0004\u0018\u00010@0>0=2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@H\u0002J\u0015\u0010B\u001a\u00020'2\u0006\u0010C\u001a\u00020\u0016H\u0000¢\u0006\u0002\bDJ*\u0010E\u001a\b\u0012\u0004\u0012\u00020F0=2\u001a\u0010G\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020?\u0012\u0006\u0012\u0004\u0018\u00010@0>0=H\u0002J\u0012\u0010H\u001a\u0004\u0018\u00010?2\u0006\u0010(\u001a\u00020)H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/larus/sheet/sdk/impl/plugins/media/CommentPhotoInsertFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/sheet/sdk/impl/databinding/LarusCommentPhotoInsertLayoutBinding;", "bottomPhotoPickPage", "Lcom/larus/platform/api/IBottomPhotoPickerPage;", "photoAlbumFragment", "dialogLifecycle", "Lcom/bytedance/ee/bear/config/CommentImageSelectorDialogLifecycle;", "getDialogLifecycle$impl_mainlandRelease", "()Lcom/bytedance/ee/bear/config/CommentImageSelectorDialogLifecycle;", "setDialogLifecycle$impl_mainlandRelease", "(Lcom/bytedance/ee/bear/config/CommentImageSelectorDialogLifecycle;)V", "albumHelper", "Lcom/larus/platform/AlbumHelper;", "getAlbumHelper", "()Lcom/larus/platform/AlbumHelper;", "albumHelper$delegate", "Lkotlin/Lazy;", "dismissReason", "Lcom/bytedance/ee/bear/config/CommentImageSelectorDismissReason;", "hasPendingUpdateAlbumUI", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "addMaskOnBottomMenuAndBottomSheet", "Lcom/larus/common_ui/view/BottomOverlayView;", "sheet", "onCreateDialog", "Landroid/app/Dialog;", "onAttach", "", "context", "Landroid/content/Context;", "onStart", "onViewCreated", "view", "onResume", "onPause", "onStop", "onDestroy", "onDetach", "onDestroyView", "registerResultForAlbumMulti", "registerResultForCamera", "startCamera", "startAlbum", "resolvePanelHeight", "", "getMaxSelectImageCount", "isMultiPickEnabled", "onSelectCommentImages", "selectedImages", "", "Lkotlin/Pair;", "Landroid/net/Uri;", "", "clickFrom", "dismissWithReason", CustomFeedPlayerEvent.EXTRA_KEY_REASON, "dismissWithReason$impl_mainlandRelease", "getCommentImageList", "Lcom/bytedance/ee/bear/config/CommentSelectedImage;", "urlList", "getLatestPhotoUri", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CommentPhotoInsertFragment extends DialogFragment {
    public static final /* synthetic */ int k = 0;
    public LarusCommentPhotoInsertLayoutBinding d;
    public com.larus.platform.api.a0 e;
    public DialogFragment f;
    public ew4.d g;
    public final Lazy h;
    public CommentImageSelectorDismissReason i;
    public boolean j;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.sheet.sdk.impl.plugins.media.CommentPhotoInsertFragment$onCreateView$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.sheet.sdk.impl.plugins.media.CommentPhotoInsertFragment$onCreateView$1", f = "CommentPhotoInsertFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CommentPhotoInsertFragment this$0;

        /* JADX INFO: renamed from: com.larus.sheet.sdk.impl.plugins.media.CommentPhotoInsertFragment$onCreateView$1$a */
        public static final class a implements com.larus.platform.api.b0 {
            public final /* synthetic */ CommentPhotoInsertFragment a;

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
                this.a.U90(CommentImageSelectorDismissReason.ACTIVE_CLOSE);
            }

            public a(CommentPhotoInsertFragment r1) {
                this.a = r1;
            }
        }

        public AnonymousClass1(CommentPhotoInsertFragment r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r31) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L41;
            ResultKt.throwOnFailure(r31);
            CoroutineScope r0 = (CoroutineScope) this.L$0;
            CommentPhotoInsertFragment r1 = this.this$0;
            com.larus.platform.api.a0 r2 = null;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
            Context r4 = r1.getContext();     // Catch: Throwable -> L11
            if (r4 == null) goto L8;
            Uri r5 = CommentPhotoInsertFragment.T90(r1, r4);     // Catch: Throwable -> L11
        L9:
            Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L11
        L14:
            if (Result.exceptionOrNull-impl(r6) == null) goto L17;
            FLogger.a.d("CommentPhotoInsertFragment", "getLatestPhotoBitmap fail");
            r6 = null;
        L17:
            boolean r7 = false;
            if (r6 == null) goto L20;
            boolean r8 = true;
        L21:
            k2 r9 = k2.a;
            if (g3.a.d() == true) goto L25;
            String r10 = "no_permission";
        L24:
            final String r11 = r10;
            CommentPhotoInsertFragment r12 = this.this$0;
            int r13 = CommentPhotoInsertFragment.k;
            int r14 = RangesKt.coerceAtLeast(r12.X90() - ((Number) i5.C0.getValue()).intValue(), 0);
            if (this.this$0.isAdded() == false) goto L31;
            CommentPhotoInsertFragment r15 = this.this$0;
            PhotoPicker r16 = (PhotoPicker) ServiceManager.get().getService(PhotoPicker.class);
            if (r16 == null) goto L38;
            AlbumSettingConfig.a r17 = new AlbumSettingConfig.a();
            r17.g = Boxing.boxInt(ContextCompat.getColor(this.this$0.requireContext(), 2131103292));
            r17.d = this.this$0.V90();
            r17.e = false;
            r17.u = false;
            if (this.this$0.V90() <= 1) goto L37;
            r7 = true;
        L37:
            r17.c = r7;
            r17.h = 4;
            AlbumSettingConfig r18 = r17.a();
            kq9.e r19 = new kq9.e(null, null, 0, null, null, null, null, null, null, Boxing.boxBoolean(true), null, null, 3579);
            MediaPickerUIMode r110 = MediaPickerUIMode.COLLAPSED_BOTTOM_SHEET;
            final CommentPhotoInsertFragment r20 = this.this$0;
            r2 = r16.f(new hq9.b0(new k(r20), r18, r11, new l(r11, r20), r14, r19, new m(), new n(r20), r110, new a(r20), 122885));
        L38:
            r15.e = r2;
            Handler r21 = t0.a;
            final CommentPhotoInsertFragment r22 = this.this$0;
            r21.post(new o(r22));
            return Unit.INSTANCE;
        L31:
            return Unit.INSTANCE;
        L25:
            if (r8 == true) goto L27;
            r10 = "no_image";
            goto L24
        L27:
            r10 = "album_display";
            goto L24
        L20:
            r8 = false;
            goto L21
        L8:
            r5 = null;
        L11:
            th = move-exception;
            Result.Companion r23 = Result.Companion;
            r6 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L14
        L41:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.sheet.sdk.impl.plugins.media.CommentPhotoInsertFragment$onResume$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.sheet.sdk.impl.plugins.media.CommentPhotoInsertFragment$onResume$1", f = "CommentPhotoInsertFragment.kt", i = {}, l = {281}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CommentPhotoInsertFragment this$0;

        /* JADX INFO: renamed from: com.larus.sheet.sdk.impl.plugins.media.CommentPhotoInsertFragment$onResume$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.sheet.sdk.impl.plugins.media.CommentPhotoInsertFragment$onResume$1$1", f = "CommentPhotoInsertFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $type;
            int label;
            final /* synthetic */ CommentPhotoInsertFragment this$0;

            public C00281(CommentPhotoInsertFragment r1, String r2, Continuation<? super C00281> r3) {
                this.this$0 = r1;
                this.$type = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00281(this.this$0, this.$type, r4);
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

        public C01431(CommentPhotoInsertFragment r1, Continuation<? super C01431> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C01431 r0 = new C01431(this.this$0, r4);
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
            CommentPhotoInsertFragment r9 = this.this$0;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
            Context r4 = r9.getContext();     // Catch: Throwable -> L15
            if (r4 == null) goto L12;
            Uri r10 = CommentPhotoInsertFragment.T90(r9, r4);     // Catch: Throwable -> L15
        L13:
            Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L15
        L18:
            if (Result.exceptionOrNull-impl(r11) == null) goto L21;
            FLogger.a.d("CommentPhotoInsertFragment", "getLatestPhotoBitmap fail");
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
            C00281 r14 = new C00281(this.this$0, r13, null);
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

    public final void onDetach() {
        this.g.onDetach();
        super.onDetach();
    }

    public final void startCamera() {
        HashMap r0 = new HashMap();
        r0.put("chat_key", 0L);
        r0.put("click_from", "plus_panel");
        hx8.a r15 = new hx8.a("slides", "CAPTURE_MODE_PHOTO", null, r0, null, null, null, null, null, null, false, false, false, null, false, 0, false, null, null, false, 0, null, false, false, false, null, null, null, null, 1073738736);
        IFlowCamera r1 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r1 == null) goto L6;
        r1.r(this, r15, null);
        return;
    }

    public CommentPhotoInsertFragment() {
        ew4.d.a.getClass();
        this.g = ew4.d.a.b;
        this.h = LazyKt.lazy(new b());
        this.i = CommentImageSelectorDismissReason.UNKNOWN;
    }

    public final int V90() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        return 1;
    L5:
        return RangesKt.coerceAtLeast(r0.getInt("max_select_image_count"), 1);
    }

    public final int X90() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.getInt("init_height"));
    L6:
        FLogger.a.i("CommentPhotoInsertFragment", "resolvePanelHeight defaultHeight=" + r1);
        if (r1 != null) goto L11;
        return 0;
    L11:
        return r1.intValue();
    L5:
        r1 = null;
        goto L6
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onDestroy, photoAlbumFragmentAdded=");
        DialogFragment r2 = this.f;
        boolean r3 = true;
        if (r2 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        r1.append(r4);
        r1.append(", dismissReason=");
        r1.append(this.i);
        r0.i("CommentPhotoInsertFragment", r1.toString());
        DialogFragment r5 = this.f;
        if (r5 != null) goto L11;
    L13:
        r3 = false;
    L14:
        if (r3 == false) goto L23;
        DialogFragment r6 = this.f;
        if (r6 == null) goto L23;
        r6.dismissAllowingStateLoss();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r7 = DialogFragmentLancet.sLastShowStack;
        if (r7 == null) goto L23;
        com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L23:
        m0 r8 = m0.a;
        CommentImageSelectorDismissReason r9 = this.i;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        ew4.e r10 = m0.b;
        if (r10 == null) goto L33;
        m0.b = null;
        FLogger.a.i("SheetSelectMediaProvider", "onCommentSelectorDismiss, reason=" + r9);
        Function1 r11 = r10.d;
        if (r11 == null) goto L32;
        r11.invoke(r9);
        return;
    L32:
        return;
    L33:
        return;
    L11:
        if (r5.isAdded() != true) goto L13;
    L5:
        if (r2.isAdded() != true) goto L7;
        r4 = true;
        goto L8
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        this.g.onPause();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        this.g.onResume();
        DialogFragment r0 = this.f;
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.isAdded() != true) goto L7;
    L8:
        if (r2 == true) goto L10;
        return;
    L10:
        if (this.j == false) goto L15;
        this.j = false;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new C01431(this, null), 2, null);
        return;
    L15:
        return;
    L7:
        r2 = false;
        goto L8
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        r1.setBackgroundDrawable(new ColorDrawable(0));
        r1.setGravity(80);
        r1.setDimAmount(0.0f);
        S90(r1).setPadding(0, 0, 0, 0);
        r1.setLayout(-1, X90());
    L7:
        this.g.onStart();
    }

    public final void onStop() {
        super.onStop();
        this.g.onStop();
    }

    public static View S90(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void U90(CommentImageSelectorDismissReason r4) {
        Intrinsics.checkNotNullParameter(r4, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        FLogger.a.i("CommentPhotoInsertFragment", "dismissWithReason, reason=" + r4);
        this.i = r4;
        dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L12;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.onAttach(r2);
        this.g.b(X90());
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Dialog r4 = super.onCreateDialog(r3);
        Window r0 = r4.getWindow();
        if (r0 == null) goto L5;
        r0.setSoftInputMode(50);
    L5:
        this.g.a(r4);
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Uri T90(CommentPhotoInsertFragment r19, Context r20) {
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

    public final void W90(List<? extends Pair<? extends Uri, String>> r18, String r19) {
        if (r18.isEmpty() == false) goto L5;
        return;
    L5:
        FLogger.a.i("CommentPhotoInsertFragment", "onSelectCommentImages size=" + r18.size() + ", clickFrom=" + r19);
        U90(CommentImageSelectorDismissReason.ACTIVE_SELECT_SUCCESS);
        m0 r2 = m0.a;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r18.iterator();
    L6:
        ew4.f r5 = null;
        if (r4.hasNext() == false) goto L49;
        Pair r0 = (Pair) r4.next();
        Uri r6 = (Uri) r0.component1();
        String r1 = (String) r0.component2();
        if (r1 != null) goto L13;
        r1 = com.larus.office.base.utils.e.h(r6);
        if (r1 != null) goto L13;
    L47:
        if (r5 == null) goto L6;
        r3.add(r5);
    L13:
        String r9 = r1;
        Pair r7 = com.larus.office.base.utils.e.e(r6);
        Intrinsics.checkNotNullParameter(r6, "uri");
    L36:
        e = move-exception;
        FLogger.a.e("ImageUtil", "getPhotoId error: " + e);
    L38:
        Integer r8 = null;
    L39:
        String r10 = com.larus.office.base.utils.e.f(r6);
        if (r7 == null) goto L42;
        int r11 = ((Number) r7.getFirst()).intValue();
    L43:
        if (r7 == null) goto L45;
        int r12 = ((Number) r7.getSecond()).intValue();
    L46:
        r5 = new ew4.f(r8, r9, r10, r11, r12, com.larus.office.base.utils.e.d(r6), com.larus.office.base.utils.e.g(r6));
        goto L47
    L45:
        r12 = 0;
        goto L46
    L42:
        r11 = 0;
        goto L43
    L15:
        if (Intrinsics.areEqual("content", r6.getScheme()) == false) goto L38;
        Cursor r13 = com.larus.office.base.utils.e.a(com.larus.office.base.utils.e.b(), r6, new String[]{"_id"});     // Catch: Exception -> L36
        if (r13 == null) goto L38;
        Cursor r14 = r13;     // Catch: Exception -> L36
        Cursor r15 = r14;     // Catch: Throwable -> L29
        if (r15.moveToFirst() == false) goto L26;
        int r16 = r15.getColumnIndex("_id");     // Catch: Throwable -> L29
        if (r16 == (-1)) goto L26;
        Integer r17 = Integer.valueOf(r15.getInt(r16));     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r14, null);     // Catch: Exception -> L36
        r8 = r17;
    L26:
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r14, null);     // Catch: Exception -> L36
        goto L38
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);     // Catch: Exception -> L36
        throw th;     // Catch: Exception -> L36
    L49:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "images");
        ew4.e r21 = m0.b;
        if (r21 == null) goto L70;
        CommentImageSelectorDismissReason r22 = CommentImageSelectorDismissReason.ACTIVE_SELECT_SUCCESS;
        m0.b = null;
        FLogger.a.i("SheetSelectMediaProvider", "onCommentImageSelected, size=" + r3.size() + ", reason=" + r22);
        r21.c.invoke(r3);
        Function1 r23 = r21.d;
        if (r23 == null) goto L69;
        r23.invoke(r22);
        return;
    L69:
        return;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        final int r4 = X90();
        LarusCommentPhotoInsertLayoutBinding r5 = this.d;
        if (r5 == null) goto L9;
        LinearLayout r6 = r5.a;
        if (r6 == null) goto L9;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L9;
        r7.height = r4;
    L9:
        LarusCommentPhotoInsertLayoutBinding r8 = this.d;
        if (r8 == null) goto L16;
        LinearLayout r9 = r8.b;
        if (r9 == null) goto L16;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if (r10 == null) goto L16;
        r10.height = -2;
    L16:
        LarusCommentPhotoInsertLayoutBinding r11 = this.d;
        if (r11 == null) goto L21;
        LinearLayout r12 = r11.a;
        if (r12 == null) goto L21;
        r12.requestLayout();
    L21:
        LarusCommentPhotoInsertLayoutBinding r13 = this.d;
        if (r13 == null) goto L26;
        LinearLayout r14 = r13.b;
        if (r14 == null) goto L26;
        r14.requestLayout();
    L26:
        LarusCommentPhotoInsertLayoutBinding r15 = this.d;
        if (r15 == null) goto L31;
        LinearLayout r16 = r15.b;
        if (r16 == null) goto L31;
        r16.post(new e(this, r4));
    L31:
        LarusCommentPhotoInsertLayoutBinding r17 = this.d;
        if (r17 == null) goto L36;
        LinearLayout r18 = r17.c;
        if (r18 == null) goto L36;
        e1.d(r18, new f(this));
    L36:
        LarusCommentPhotoInsertLayoutBinding r19 = this.d;
        if (r19 == null) goto L42;
        LinearLayout r20 = r19.d;
        if (r20 == null) goto L43;
        e1.d(r20, new g(this));
        return;
    L43:
        return;
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        AlbumHelper r13 = (AlbumHelper) this.h.getValue();
        Function1<? super xp9.i, Unit> r14 = new com.larus.sheet.sdk.impl.plugins.media.a(this);
        Lazy<Handler> r0 = AlbumHelper.e;
        r13.e(this, "album_helper", r14);
        IFlowCamera r15 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r15 == null) goto L5;
        r15.m(this, new c(this), new d());
    L5:
        View r16 = r10.inflate(2131561915, null, false);
        int r17 = 2131369275;
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r16, 2131369275);
        if (r1 == null) goto L22;
        r17 = 2131369276;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r16, 2131369276);
        if (r2 == null) goto L22;
        r17 = 2131369277;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r16, 2131369277);
        if (r3 == null) goto L22;
        LinearLayout r18 = (LinearLayout) r16;
        if (((ImageView) ViewBindings.findChildViewById(r16, 2131377546)) != null) goto L14;
        r17 = 2131377546;
        goto L22
    L14:
        if (ViewBindings.findChildViewById(r16, 2131377547) == null) goto L19;
        this.d = new LarusCommentPhotoInsertLayoutBinding(r18, r1, r2, r3);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
        LarusCommentPhotoInsertLayoutBinding r19 = this.d;
        if (r19 != null) goto L18;
        return null;
    L18:
        return r19.a;
    L19:
        r17 = 2131377547;
    L22:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r17)));
    }
}
