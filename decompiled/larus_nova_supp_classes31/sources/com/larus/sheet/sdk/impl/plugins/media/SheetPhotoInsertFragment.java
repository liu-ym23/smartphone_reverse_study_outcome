package com.larus.sheet.sdk.impl.plugins.media;

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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.api.toolbar.media.impl.SelectedMediaItem;
import com.larus.camera.api.IFlowCamera;
import com.larus.office.base.plugins.media.BaseSelectMediaViewModel;
import com.larus.photopicker.api.PhotoPicker;
import com.larus.platform.AlbumHelper;
import com.larus.platform.api.g3;
import com.larus.platform.model.MediaPickerUIMode;
import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.service.k2;
import com.larus.sheet.sdk.impl.databinding.LarusSheetPhotoInsertLayoutBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0010H\u0002J\u001a\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\u0018H\u0016J\b\u0010&\u001a\u00020\u0018H\u0016J\b\u0010'\u001a\u00020\u0018H\u0016J\b\u0010(\u001a\u00020\u0018H\u0002J\b\u0010)\u001a\u00020\u0018H\u0002J\b\u0010*\u001a\u00020\u0018H\u0002J\b\u0010+\u001a\u00020\u0018H\u0002J\b\u0010,\u001a\u00020-H\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u000201H\u0002J*\u00102\u001a\u00020\u00182\b\u00103\u001a\u0004\u0018\u00010/2\n\b\u0002\u00104\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J*\u00105\u001a\b\u0012\u0004\u0012\u000207062\u001a\u00108\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020/\u0012\u0006\u0012\u0004\u0018\u00010 0906H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/larus/sheet/sdk/impl/plugins/media/SheetPhotoInsertFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/sheet/sdk/impl/databinding/LarusSheetPhotoInsertLayoutBinding;", "bottomPhotoPickPage", "Lcom/larus/platform/api/IBottomPhotoPickerPage;", "photoAlbumFragment", "albumHelper", "Lcom/larus/platform/AlbumHelper;", "getAlbumHelper", "()Lcom/larus/platform/AlbumHelper;", "albumHelper$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "", "addMaskOnBottomMenuAndBottomSheet", "Lcom/larus/common_ui/view/BottomOverlayView;", "sheet", "onViewCreated", "view", "mobClickUploadEntranceInternal", "clickFrom", "", "hasPendingUpdateAlbumUI", "", "onHiddenChanged", "hidden", "onResume", "onDestroy", "onDestroyView", "registerResultForAlbum", "registerResultForCamera", "startCamera", "startAlbum", "getBottomViewHeight", "", "getLatestPhotoUri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "onSelectLocalImageCallback", "uri", "imagePath", "getMediaList", "", "Lcom/bytedance/ee/bear/api/toolbar/media/impl/SelectedMediaItem;", "urlList", "Lkotlin/Pair;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SheetPhotoInsertFragment extends DialogFragment {
    public static final /* synthetic */ int i = 0;
    public LarusSheetPhotoInsertLayoutBinding d;
    public com.larus.platform.api.a0 e;
    public DialogFragment f;
    public final Lazy g;
    public boolean h;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.sheet.sdk.impl.plugins.media.SheetPhotoInsertFragment$onCreateView$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.sheet.sdk.impl.plugins.media.SheetPhotoInsertFragment$onCreateView$1", f = "SheetPhotoInsertFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SheetPhotoInsertFragment this$0;

        /* JADX INFO: renamed from: com.larus.sheet.sdk.impl.plugins.media.SheetPhotoInsertFragment$onCreateView$1$a */
        public static final class a implements com.larus.platform.api.b0 {
            public final /* synthetic */ SheetPhotoInsertFragment a;

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
                if ((this.a.getActivity() instanceof qw9.a) == false) goto L6;
                qw9.a r0 = this.a.getActivity();
                Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larus.sheet.sdk.api.media.ISelectMediaBottomPage");
                r0.f();
                return;
            }

            public a(SheetPhotoInsertFragment r1) {
                this.a = r1;
            }
        }

        public AnonymousClass1(SheetPhotoInsertFragment r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r29) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L41;
            ResultKt.throwOnFailure(r29);
            CoroutineScope r0 = (CoroutineScope) this.L$0;
            SheetPhotoInsertFragment r1 = this.this$0;
            com.larus.platform.api.a0 r2 = null;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
            Context r4 = r1.getContext();     // Catch: Throwable -> L11
            if (r4 == null) goto L8;
            Uri r5 = SheetPhotoInsertFragment.S90(r1, r4);     // Catch: Throwable -> L11
        L9:
            Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L11
        L14:
            if (Result.exceptionOrNull-impl(r6) == null) goto L18;
            FLogger.a.d("SheetPhotoInsertFragment", "getLatestPhotoBitmap fail");
            r6 = null;
        L18:
            if (r6 == null) goto L20;
            boolean r7 = true;
        L21:
            k2 r8 = k2.a;
            boolean r9 = g3.a.d();
            FLogger r10 = FLogger.a;
            r10.i("SheetPhotoInsertFragment", "[showBottomAlbum] hasReadPermission:" + r9 + ", albumHasImage:" + r7);
            if (r9 == true) goto L25;
            String r11 = "no_permission";
        L24:
            final String r12 = r11;
            Bundle r13 = this.this$0.getArguments();
            if (r13 == null) goto L31;
            int r14 = r13.getInt("init_height");
        L32:
            int r15 = RangesKt.coerceAtLeast(r14 - ((Number) i5.C0.getValue()).intValue(), 0);
            r10.i("SheetPhotoInsertFragment", "bottomPeekHeight: " + r15 + ", panelHeight: " + r14);
            if (this.this$0.isAdded() == false) goto L39;
            SheetPhotoInsertFragment r16 = this.this$0;
            PhotoPicker r17 = (PhotoPicker) ServiceManager.get().getService(PhotoPicker.class);
            if (r17 == null) goto L37;
            AlbumSettingConfig.a r18 = new AlbumSettingConfig.a();
            r18.g = Boxing.boxInt(ContextCompat.getColor(this.this$0.requireContext(), 2131103292));
            r18.e = false;
            r18.u = false;
            r18.c = false;
            r18.h = 4;
            AlbumSettingConfig r19 = r18.a();
            kq9.e r20 = new kq9.e(null, null, 0, null, null, null, null, null, null, Boxing.boxBoolean(true), null, null, 3579);
            MediaPickerUIMode r110 = MediaPickerUIMode.COLLAPSED_BOTTOM_SHEET;
            final SheetPhotoInsertFragment r21 = this.this$0;
            r2 = r17.f(new hq9.b0(new b0(r21), r19, r12, new c0(r12, r21), r15, r20, new d0(), new e0(r21), r110, new a(r21), 122885));
        L37:
            r16.e = r2;
            Handler r22 = t0.a;
            final SheetPhotoInsertFragment r23 = this.this$0;
            r22.post(new f0(r23));
        L39:
            return Unit.INSTANCE;
        L31:
            SheetPhotoInsertFragment r24 = this.this$0;
            int r25 = SheetPhotoInsertFragment.i;
            r24.getClass();
            r14 = i5.U();
            goto L32
        L25:
            if (r7 == true) goto L27;
            r11 = "no_image";
            goto L24
        L27:
            r11 = "album_display";
            goto L24
        L20:
            r7 = false;
            goto L21
        L8:
            r5 = null;
        L11:
            th = move-exception;
            Result.Companion r26 = Result.Companion;
            r6 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L14
        L41:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.sheet.sdk.impl.plugins.media.SheetPhotoInsertFragment$onResume$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.sheet.sdk.impl.plugins.media.SheetPhotoInsertFragment$onResume$1", f = "SheetPhotoInsertFragment.kt", i = {}, l = {299}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SheetPhotoInsertFragment this$0;

        /* JADX INFO: renamed from: com.larus.sheet.sdk.impl.plugins.media.SheetPhotoInsertFragment$onResume$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.sheet.sdk.impl.plugins.media.SheetPhotoInsertFragment$onResume$1$1", f = "SheetPhotoInsertFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $type;
            int label;
            final /* synthetic */ SheetPhotoInsertFragment this$0;

            public C00291(SheetPhotoInsertFragment r1, String r2, Continuation<? super C00291> r3) {
                this.this$0 = r1;
                this.$type = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00291(this.this$0, this.$type, r4);
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

        public C01441(SheetPhotoInsertFragment r1, Continuation<? super C01441> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C01441 r0 = new C01441(this.this$0, r4);
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
            SheetPhotoInsertFragment r9 = this.this$0;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
            Context r4 = r9.getContext();     // Catch: Throwable -> L15
            if (r4 == null) goto L12;
            Uri r10 = SheetPhotoInsertFragment.S90(r9, r4);     // Catch: Throwable -> L15
        L13:
            Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L15
        L18:
            if (Result.exceptionOrNull-impl(r11) == null) goto L21;
            FLogger.a.d("SheetPhotoInsertFragment", "getLatestPhotoBitmap fail");
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
            C00291 r14 = new C00291(this.this$0, r13, null);
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
        HashMap r0 = new HashMap();
        r0.put("chat_key", 0L);
        r0.put("click_from", "plus_panel");
        hx8.a r15 = new hx8.a("slides", "CAPTURE_MODE_PHOTO", null, r0, null, null, null, null, null, null, false, false, false, null, false, 0, false, null, null, false, 0, null, false, false, false, null, null, null, null, 1073738736);
        IFlowCamera r1 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r1 == null) goto L6;
        r1.r(this, r15, null);
        return;
    }

    public SheetPhotoInsertFragment() {
        this.g = LazyKt.lazy(new w());
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

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
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
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new C01441(this, null), 2, null);
        return;
    L17:
        return;
    L9:
        r2 = false;
        goto L10
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        getParentFragmentManager().setFragmentResultListener("sheet_panel_height", this, new v(this));
    }

    public final void onHiddenChanged(boolean r4) {
        super/*androidx.fragment.app.Fragment*/.onHiddenChanged(r4);
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onHiddenChanged: ");
        r1.append(r4);
        r1.append(", isAdded: ");
        com.larus.platform.api.a0 r2 = this.e;
        if (r2 == null) goto L7;
        Fragment r3 = r2.od();
        if (r3 == null) goto L7;
        Boolean r5 = Boolean.valueOf(r3.isAdded());
    L8:
        r1.append(r5);
        r0.d("SheetPhotoInsertFragment", r1.toString());
        boolean r6 = true;
        if (r4 == false) goto L22;
        com.larus.platform.api.a0 r7 = this.e;
        if (r7 == null) goto L17;
        Fragment r8 = r7.od();
        if (r8 == null) goto L17;
        if (r8.isAdded() != true) goto L17;
        boolean r9 = true;
    L18:
        if (r9 == false) goto L22;
        com.larus.platform.api.a0 r10 = this.e;
        if (r10 == null) goto L36;
        r10.Uw();
        return;
    L36:
        return;
    L17:
        r9 = false;
    L22:
        if (r4 == true) goto L38;
        com.larus.platform.api.a0 r11 = this.e;
        if (r11 == null) goto L30;
        Fragment r12 = r11.od();
        if (r12 == null) goto L30;
        if (r12.isAdded() != true) goto L30;
    L31:
        if (r6 == true) goto L39;
        com.larus.platform.api.a0 r13 = this.e;
        if (r13 == null) goto L40;
        r13.Bs(getChildFragmentManager(), "sheet_photo_insert_fragment");
        return;
    L40:
        return;
    L39:
        return;
    L30:
        r6 = false;
        goto L31
    L38:
        return;
    L7:
        r5 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Uri S90(SheetPhotoInsertFragment r19, Context r20) {
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
        Bundle r5 = getArguments();
        if (r5 == null) goto L5;
        int r6 = r5.getInt("init_height");
    L6:
        FLogger.a.i("SheetPhotoInsertFragment", "Keyboard height: " + r6);
        LarusSheetPhotoInsertLayoutBinding r7 = this.d;
        if (r7 == null) goto L13;
        LinearLayout r8 = r7.b;
        if (r8 == null) goto L13;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if (r9 == null) goto L13;
        r9.height = r6;
    L13:
        LarusSheetPhotoInsertLayoutBinding r10 = this.d;
        if (r10 == null) goto L18;
        LinearLayout r11 = r10.c;
        if (r11 == null) goto L18;
        e1.d(r11, new r(this));
    L18:
        LarusSheetPhotoInsertLayoutBinding r12 = this.d;
        if (r12 == null) goto L24;
        LinearLayout r13 = r12.d;
        if (r13 == null) goto L25;
        e1.d(r13, new s(this));
        return;
    L25:
        return;
    L24:
        return;
    L5:
        r6 = i5.U();
        goto L6
    }

    public final void T90(Uri r6, String r7, String r8) {
        if (r6 == null) goto L29;
        List r9 = CollectionsKt.listOf(TuplesKt.to(r6, r7));
        ArrayList r10 = new ArrayList();
        Iterator r11 = r9.iterator();
    L5:
        if (r11.hasNext() == false) goto L24;
        Pair r12 = (Pair) r11.next();
        Uri r0 = (Uri) r12.component1();
        String r13 = (String) r12.component2();
        SelectedMediaItem r1 = new SelectedMediaItem();
        r1.contentType = com.larus.office.base.utils.e.f(r0);
        r1.uuid = UUID.randomUUID().toString();
        StringBuilder r2 = new StringBuilder("docsource://");
        if (r13 != null) goto L9;
        r13 = com.larus.office.base.utils.e.h(r0);
    L9:
        r2.append(r13);
        String r14 = r2.toString();
        String r3 = "";
        if (r14 != null) goto L12;
        r14 = "";
    L12:
        r1.mediaFile = r14;
        Pair r15 = com.larus.office.base.utils.e.e(r0);
        int r4 = 0;
        if (r15 == null) goto L15;
        int r5 = ((Number) r15.getFirst()).intValue();
    L16:
        r1.width = r5;
        if (r15 == null) goto L19;
        r4 = ((Number) r15.getSecond()).intValue();
    L19:
        r1.height = r4;
        String r16 = com.larus.office.base.utils.e.g(r0);
        if (r16 == null) goto L23;
        r3 = r16;
    L23:
        r1.fileName = r3;
        r1.fileSize = com.larus.office.base.utils.e.d(r0);
        r10.add(r1);
        goto L5
    L15:
        r5 = 0;
        goto L16
    L24:
        BaseSelectMediaViewModel r17 = com.bytedance.ee.bear.browser.plugin.q.a(this, BaseSelectMediaViewModel.class);
        r17.onSelectMedia(r10);
        r17.hideContainer();
        return;
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        AlbumHelper r13 = (AlbumHelper) this.g.getValue();
        Function1<? super AlbumSelectItem, Unit> r14 = new x(this);
        Lazy<Handler> r0 = AlbumHelper.e;
        r13.b(this, "album_helper", r14);
        IFlowCamera r15 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r15 == null) goto L5;
        r15.m(this, new t(this), new u());
    L5:
        View r16 = r10.inflate(2131563131, null, false);
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
        this.d = new LarusSheetPhotoInsertLayoutBinding(r18, r1, r2, r3);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
        LarusSheetPhotoInsertLayoutBinding r19 = this.d;
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
