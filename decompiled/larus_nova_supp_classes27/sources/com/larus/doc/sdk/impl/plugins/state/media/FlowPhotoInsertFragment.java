package com.larus.doc.sdk.impl.plugins.state.media;

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
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ee.bear.api.toolbar.media.impl.SelectedMediaItem;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider;
import com.bytedance.ee.docsdk.impl.utils.keyboard.utils.HardKeyboardUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.camera.api.IFlowCamera;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.OutputParam;
import com.larus.doc.sdk.impl.databinding.LarusDocPhotoInsertLayoutBinding;
import com.larus.doc.sdk.impl.generalbiz.common.DocSdkVersion;
import com.larus.doc.sdk.impl.generalbiz.state.media.FileConst;
import com.larus.doc.sdk.impl.generalbiz.state.media.SelectMediaViewModel;
import com.larus.doc.sdk.impl.generalbiz.state.media.SelectedMediaItemV1;
import com.larus.doc.sdk.impl.generalbiz.state.model.DocToolbarItemId;
import com.larus.doc.sdk.impl.generalbiz.state.model.FlowDocStateViewModel;
import com.larus.photopicker.api.PhotoPicker;
import com.larus.platform.AlbumHelper;
import com.larus.platform.api.a0;
import com.larus.platform.api.g3;
import com.larus.platform.model.MediaPickerUIMode;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.service.k2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginViewModelProviders;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.b0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0016\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\u001a\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010&\u001a\u00020 H\u0016J\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020 H\u0016J\b\u0010*\u001a\u00020\u0015H\u0016J\b\u0010+\u001a\u00020 H\u0002J\b\u0010,\u001a\u00020 H\u0002J\b\u0010-\u001a\u00020 H\u0002J\b\u0010.\u001a\u00020/H\u0002J\u0012\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u000203H\u0002J*\u00104\u001a\b\u0012\u0004\u0012\u0002050\"2\u001a\u00106\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u000201\u0012\u0006\u0012\u0004\u0018\u00010\n070\"H\u0002J*\u00108\u001a\b\u0012\u0004\u0012\u00020#0\"2\u001a\u00106\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u000201\u0012\u0006\u0012\u0004\u0018\u00010\n070\"H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/larus/doc/sdk/impl/plugins/state/media/FlowPhotoInsertFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/bytedance/ee/bear/api/registry/ToolbarDismissKeyboardHandler;", "<init>", "()V", "binding", "Lcom/larus/doc/sdk/impl/databinding/LarusDocPhotoInsertLayoutBinding;", "docSdkVersion", "Lcom/larus/doc/sdk/impl/generalbiz/common/DocSdkVersion;", "docLogicKey", "", "bottomPhotoPickPage", "Lcom/larus/platform/api/IBottomPhotoPickerPage;", "photoAlbumFragment", "albumHelper", "Lcom/larus/platform/AlbumHelper;", "getAlbumHelper", "()Lcom/larus/platform/AlbumHelper;", "albumHelper$delegate", "Lkotlin/Lazy;", "hasPendingUpdateAlbumUI", "", "suppressKeyboardOnDismiss", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onSelectMedia", "", "mediaItemList", "", "Lcom/bytedance/ee/bear/api/toolbar/media/impl/SelectedMediaItem;", "onViewCreated", "view", "onResume", "getSelectMediaViewModel", "Lcom/larus/doc/sdk/impl/generalbiz/state/media/SelectMediaViewModel;", "onDestroy", "shouldHandleKeyboardOnDismiss", "registerResultForMultiFileSelect", "registerResultForCamera", "startCamera", "getKeyboardHeight", "", "getLatestPhotoUri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "getMediaListV1", "Lcom/larus/doc/sdk/impl/generalbiz/state/media/SelectedMediaItemV1;", "urlList", "Lkotlin/Pair;", "getMediaListV2", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowPhotoInsertFragment extends DialogFragment implements an4.c {
    public static final Companion Companion = null;
    private static final String FRAGMENT_TAG = "photo_insert_fragment";
    public static final String KEY_DOC_LOGIC_KEY = "doc_logic_key";
    public static final String KEY_DOC_SDK_VERSION = "doc_sdk_version";
    private static final String TAG = "PhotoInsertFragment";
    private final Lazy albumHelper$delegate;
    private LarusDocPhotoInsertLayoutBinding binding;
    private a0 bottomPhotoPickPage;
    private String docLogicKey;
    private DocSdkVersion docSdkVersion;
    private boolean hasPendingUpdateAlbumUI;
    private DialogFragment photoAlbumFragment;
    private boolean suppressKeyboardOnDismiss;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/larus/doc/sdk/impl/plugins/state/media/FlowPhotoInsertFragment$Companion;", "", "<init>", "()V", "TAG", "", "FRAGMENT_TAG", "KEY_DOC_SDK_VERSION", "KEY_DOC_LOGIC_KEY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[DocSdkVersion.values().length];
            r0[DocSdkVersion.V1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[DocSdkVersion.V2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.doc.sdk.impl.plugins.state.media.FlowPhotoInsertFragment$onCreateView$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.doc.sdk.impl.plugins.state.media.FlowPhotoInsertFragment$onCreateView$1", f = "FlowPhotoInsertFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FlowPhotoInsertFragment this$0;

        /* JADX INFO: renamed from: com.larus.doc.sdk.impl.plugins.state.media.FlowPhotoInsertFragment$onCreateView$1$WhenMappings */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[DocSdkVersion.values().length];
                r0[DocSdkVersion.V1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[DocSdkVersion.V2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                $EnumSwitchMapping$0 = r0;
            }
        }

        public AnonymousClass1(FlowPhotoInsertFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public static /* synthetic */ Unit a() {
            return invokeSuspend$lambda$11$lambda$10();
        }

        public static /* synthetic */ void c(FlowPhotoInsertFragment r0) {
            invokeSuspend$lambda$11(r0);
        }

        public static /* synthetic */ Unit e(String r0, FlowPhotoInsertFragment r1) {
            return invokeSuspend$lambda$7(r0, r1);
        }

        public static /* synthetic */ Unit g() {
            return invokeSuspend$lambda$8();
        }

        public static /* synthetic */ Unit j(FlowPhotoInsertFragment r0, xp9.i r1) {
            return invokeSuspend$lambda$5(r0, r1);
        }

        public static /* synthetic */ Unit k(FlowPhotoInsertFragment r0) {
            return invokeSuspend$lambda$9(r0);
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

        private static final Unit invokeSuspend$lambda$11$lambda$10() {
            return Unit.INSTANCE;
        }

        private static final Unit invokeSuspend$lambda$8() {
            return Unit.INSTANCE;
        }

        public static void INVOKEVIRTUAL_com_larus_doc_sdk_impl_plugins_state_media_FlowPhotoInsertFragment$onCreateView$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(DialogFragment r1) {
            r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r2 = DialogFragmentLancet.sLastShowStack;
            if (r2 == null) goto L11;
            com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        private static final void invokeSuspend$lambda$11(FlowPhotoInsertFragment r24) {
            if (r24.isAdded() == false) goto L19;
            a0 r0 = FlowPhotoInsertFragment.access$getBottomPhotoPickPage$p(r24);
            if (r0 == null) goto L7;
            r0.Bs(r24.getChildFragmentManager(), FlowPhotoInsertFragment.FRAGMENT_TAG);
        L7:
            a0 r1 = FlowPhotoInsertFragment.access$getBottomPhotoPickPage$p(r24);
            if (r1 == null) goto L10;
            Fragment r2 = r1.od();
        L12:
            if ((r2 instanceof DialogFragment) == false) goto L14;
            DialogFragment r3 = (DialogFragment) r2;
        L15:
            FlowPhotoInsertFragment.access$setPhotoAlbumFragment$p(r24, r3);
            PhotoPicker r4 = (PhotoPicker) ServiceManager.get().getService(PhotoPicker.class);
            if (r4 == null) goto L20;
            FragmentManager r5 = r24.getChildFragmentManager();
            int r6 = i5.y0(v19.c.b(2130971546, null, 2131167462));
            int r7 = i5.y0(v19.c.b(2130971163, null, 2131166696));
            Boolean r17 = Boolean.FALSE;
            Integer r10 = Integer.valueOf(r6);
            Boolean r11 = Boolean.TRUE;
            r4.A(r5, new kq9.m(r17, r17, 4, r17, r10, r11, r17, Integer.valueOf(r7), r17, new i(), r11, r17, r11, null, r11, r17, null, 303616), FlowPhotoInsertFragment.FRAGMENT_TAG);
            return;
        L20:
            return;
        L14:
            r3 = null;
            goto L15
        L10:
            r2 = null;
            goto L12
        }

        private static final Unit invokeSuspend$lambda$9(FlowPhotoInsertFragment r0) {
            FragmentActivity r1 = r0.getActivity();
            if (r1 == null) goto L6;
            r1.finish();
        L6:
            return Unit.INSTANCE;
        }

        public final Object invokeSuspend(Object r27) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L37;
            ResultKt.throwOnFailure(r27);
            FlowPhotoInsertFragment r0 = this.this$0;
            a0 r2 = null;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
            Context r4 = r0.getContext();     // Catch: Throwable -> L11
            if (r4 == null) goto L8;
            Uri r1 = FlowPhotoInsertFragment.access$getLatestPhotoUri(r0, r4);     // Catch: Throwable -> L11
        L9:
            Object r5 = Result.constructor-impl(r1);     // Catch: Throwable -> L11
        L14:
            if (Result.exceptionOrNull-impl(r5) == null) goto L18;
            FLogger.a.d(FlowPhotoInsertFragment.TAG, "getLatestPhotoBitmap fail");
            r5 = null;
        L18:
            if (r5 == null) goto L20;
            boolean r6 = true;
        L21:
            k2 r7 = k2.a;
            boolean r8 = g3.a.d();
            FLogger.a.i(FlowPhotoInsertFragment.TAG, "[showBottomAlbum] hasReadPermission:" + r8 + ", albumHasImage:" + r6);
            if (r8 == true) goto L25;
            String r9 = "no_permission";
        L24:
            final String r10 = r9;
            int r11 = FlowPhotoInsertFragment.access$getKeyboardHeight(this.this$0) - ((Number) i5.A0.getValue()).intValue();
            if (this.this$0.isAdded() == false) goto L35;
            FlowPhotoInsertFragment r12 = this.this$0;
            PhotoPicker r13 = (PhotoPicker) ServiceManager.get().getService(PhotoPicker.class);
            if (r13 == null) goto L33;
            AlbumSettingConfig.a r14 = new AlbumSettingConfig.a();
            r14.g = Boxing.boxInt(ContextCompat.getColor(this.this$0.requireContext(), 2131103292));
            r14.d = 10;
            r14.c = true;
            r14.e = false;
            r14.u = false;
            r14.h = 4;
            AlbumSettingConfig r15 = r14.a();
            kq9.e r16 = new kq9.e(null, null, 0, null, null, null, null, null, null, Boxing.boxBoolean(true), null, null, 3579);
            MediaPickerUIMode r17 = MediaPickerUIMode.COLLAPSED_BOTTOM_SHEET;
            final FlowPhotoInsertFragment r18 = this.this$0;
            r2 = r13.f(new b0(new j(r18), r15, r10, new k(r10, r18), r11, r16, new l(), new m(r18), r17, null, 122885));
        L33:
            FlowPhotoInsertFragment.access$setBottomPhotoPickPage$p(r12, r2);
            Handler r20 = t0.a;
            final FlowPhotoInsertFragment r21 = this.this$0;
            r20.post(new n(r21));
        L35:
            return Unit.INSTANCE;
        L25:
            if (r6 == true) goto L27;
            r9 = "no_image";
            goto L24
        L27:
            r9 = "album_display";
            goto L24
        L20:
            r6 = false;
            goto L21
        L8:
            r1 = null;
        L11:
            th = move-exception;
            Result.Companion r22 = Result.Companion;
            r5 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L14
        L37:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        private static final Unit invokeSuspend$lambda$5(FlowPhotoInsertFragment r7, xp9.i r8) {
            List<SelectedMediaItemV1> r0 = CollectionsKt.emptyList();
            List r1 = CollectionsKt.emptyList();
            DocSdkVersion r2 = FlowPhotoInsertFragment.access$getDocSdkVersion$p(r7);
            int r3 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
            if (r3 == 1) goto L12;
            if (r3 != 2) goto L11;
            List r9 = r8.a;
            ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
            Iterator r10 = r9.iterator();
        L7:
            if (r10.hasNext() == false) goto L9;
            r4.add(TuplesKt.to((Uri) r10.next(), null));
            goto L7
        L9:
            r1 = FlowPhotoInsertFragment.access$getMediaListV2(r7, r4);
        L17:
            DialogFragment r11 = FlowPhotoInsertFragment.access$getPhotoAlbumFragment$p(r7);
            if (r11 == null) goto L20;
            INVOKEVIRTUAL_com_larus_doc_sdk_impl_plugins_state_media_FlowPhotoInsertFragment$onCreateView$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r11);
        L20:
            FlowPhotoInsertFragment.access$setPhotoAlbumFragment$p(r7, null);
            FlowPhotoInsertFragment.access$setBottomPhotoPickPage$p(r7, null);
            DocSdkVersion r12 = FlowPhotoInsertFragment.access$getDocSdkVersion$p(r7);
            int r13 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
            if (r13 == 1) goto L26;
            if (r13 != 2) goto L25;
            FlowPhotoInsertFragment.access$onSelectMedia(r7, r1);
        L27:
            ((FlowDocStateViewModel) PluginViewModelProviders.viewModel(r7, FlowDocStateViewModel.class)).toggleToolbarItemState(DocToolbarItemId.INSTANCE.getALL(), FlowPhotoInsertFragment.access$getDocLogicKey$p(r7));
            return Unit.INSTANCE;
        L25:
            throw new NoWhenBranchMatchedException();
        L26:
            FlowPhotoInsertFragment.access$getSelectMediaViewModel(r7).onSelectMediaV1(r0);
            goto L27
        L11:
            throw new NoWhenBranchMatchedException();
        L12:
            List r14 = r8.a;
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
            Iterator r15 = r14.iterator();
        L14:
            if (r15.hasNext() == false) goto L16;
            r5.add(TuplesKt.to((Uri) r15.next(), null));
            goto L14
        L16:
            r0 = FlowPhotoInsertFragment.access$getMediaListV1(r7, r5);
            goto L17
        }

        private static final Unit invokeSuspend$lambda$7(String r1, FlowPhotoInsertFragment r2) {
            if (Intrinsics.areEqual(r1, "no_permission") == false) goto L8;
            FragmentActivity r3 = r2.getActivity();
            if (r3 == null) goto L11;
            FlowPhotoInsertFragment.access$setHasPendingUpdateAlbumUI$p(r2, true);
            k2 r4 = k2.a;
            g3.a.c(r3);
        L11:
            return Unit.INSTANCE;
        L8:
            if (Intrinsics.areEqual(r1, "no_image") == false) goto L11;
            FlowPhotoInsertFragment.access$getSelectMediaViewModel(r2).onPrepareInsertImage();
            FlowPhotoInsertFragment.access$startCamera(r2);
            goto L11
        }
    }

    /* JADX INFO: renamed from: com.larus.doc.sdk.impl.plugins.state.media.FlowPhotoInsertFragment$onResume$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.doc.sdk.impl.plugins.state.media.FlowPhotoInsertFragment$onResume$1", f = "FlowPhotoInsertFragment.kt", i = {}, l = {277}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FlowPhotoInsertFragment this$0;

        /* JADX INFO: renamed from: com.larus.doc.sdk.impl.plugins.state.media.FlowPhotoInsertFragment$onResume$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.doc.sdk.impl.plugins.state.media.FlowPhotoInsertFragment$onResume$1$1", f = "FlowPhotoInsertFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $type;
            int label;
            final /* synthetic */ FlowPhotoInsertFragment this$0;

            public C00251(FlowPhotoInsertFragment r1, String r2, Continuation<? super C00251> r3) {
                this.this$0 = r1;
                this.$type = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00251(this.this$0, this.$type, r4);
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
                a0 r3 = FlowPhotoInsertFragment.access$getBottomPhotoPickPage$p(this.this$0);
                if (r3 == null) goto L10;
                r3.cP(this.$type);
            L10:
                return Unit.INSTANCE;
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C01661(FlowPhotoInsertFragment r1, Continuation<? super C01661> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01661(this.this$0, r3);
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
            FlowPhotoInsertFragment r8 = this.this$0;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
            Context r4 = r8.getContext();     // Catch: Throwable -> L15
            if (r4 == null) goto L12;
            Uri r9 = FlowPhotoInsertFragment.access$getLatestPhotoUri(r8, r4);     // Catch: Throwable -> L15
        L13:
            Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L15
        L18:
            if (Result.exceptionOrNull-impl(r10) == null) goto L21;
            FLogger.a.d(FlowPhotoInsertFragment.TAG, "getLatestPhotoBitmap fail");
            r10 = null;
        L21:
            if (r10 == null) goto L23;
            boolean r11 = true;
        L24:
            k2 r5 = k2.a;
            if (g3.a.d() == false) goto L33;
            if (r11 == true) goto L28;
            String r12 = "no_image";
        L29:
            MainCoroutineDispatcher r6 = Dispatchers.getMain();
            C00251 r13 = new C00251(this.this$0, r12, null);
            this.label = 1;
            if (BuildersKt.withContext(r6, r13, this) != r0) goto L33;
            return r0;
        L28:
            r12 = "album_display";
            goto L29
        L23:
            r11 = false;
            goto L24
        L12:
            r9 = null;
        L15:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            r10 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L18
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ Unit S90() {
        return onViewCreated$lambda$6$lambda$5();
    }

    public static /* synthetic */ AlbumHelper T90() {
        return albumHelper_delegate$lambda$0();
    }

    public static /* synthetic */ void U90(FlowPhotoInsertFragment r0, View r1) {
        onViewCreated$lambda$6(r0, r1);
    }

    public static /* synthetic */ void V90(FlowPhotoInsertFragment r0, View r1) {
        onViewCreated$lambda$3(r0, r1);
    }

    public static /* synthetic */ Unit W90() {
        return registerResultForCamera$lambda$11();
    }

    public static /* synthetic */ Unit X90() {
        return onViewCreated$lambda$6$lambda$4();
    }

    public static /* synthetic */ Unit Y90(FlowPhotoInsertFragment r0, CameraOutputContext r1) {
        return registerResultForCamera$lambda$10(r0, r1);
    }

    public static /* synthetic */ Unit Z90(FlowPhotoInsertFragment r0, xp9.i r1) {
        return registerResultForMultiFileSelect$lambda$9(r0, r1);
    }

    private static final AlbumHelper albumHelper_delegate$lambda$0() {
        return new AlbumHelper();
    }

    private final AlbumHelper getAlbumHelper() {
        return (AlbumHelper) this.albumHelper$delegate.getValue();
    }

    private final SelectMediaViewModel getSelectMediaViewModel() {
        DocSdkVersion r0 = this.docSdkVersion;
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 != 1) goto L5;
        SelectMediaViewModel r2 = (SelectMediaViewModel) PluginViewModelProviders.viewModel(this, SelectMediaViewModel.class);
    L10:
        Intrinsics.checkNotNull(r2);
        return r2;
    L5:
        if (r1 != 2) goto L8;
        r2 = (SelectMediaViewModel) q.a(this, SelectMediaViewModel.class);
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    private final void registerResultForCamera() {
        IFlowCamera r0 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r0 == null) goto L6;
        r0.m(this, new e(this), new f());
        return;
    }

    private static final Unit registerResultForCamera$lambda$11() {
        FLogger.a.e(TAG, "Take picture failed");
        return Unit.INSTANCE;
    }

    private final void startCamera() {
        HashMap r0 = new HashMap();
        r0.put("chat_key", 0L);
        JSONObject r1 = new JSONObject();
        r1.put("is_ai_doc", 1);
        Unit r2 = Unit.INSTANCE;
        r0.put("extra_params", r1);
        hx8.a r15 = new hx8.a("doc", "CAPTURE_MODE_PHOTO", null, r0, null, null, null, null, null, null, false, false, false, null, false, 0, false, null, null, false, 0, null, false, false, false, null, null, null, null, 1073738736);
        IFlowCamera r3 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r3 == null) goto L6;
        r3.r(this, r15, null);
        return;
    }

    public boolean shouldHandleKeyboardOnDismiss() {
        return !this.suppressKeyboardOnDismiss;
    }

    public FlowPhotoInsertFragment() {
        this.docSdkVersion = DocSdkVersion.V1;
        this.docLogicKey = "default_doc_logic_key";
        this.albumHelper$delegate = LazyKt.lazy(new b());
    }

    private final int getKeyboardHeight() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (HardKeyboardUtils.hasHardKeyboard(r0) == false) goto L11;
        int r1 = r0.getResources().getConfiguration().orientation;
        if (this.docSdkVersion != DocSdkVersion.V1) goto L17;
        return KeyboardHeightProvider.Factory.get(r0).keyBoardRawHeightWithOrientation(r1);
    L17:
        return pcb.a.a.b(r0).keyBoardRawHeightWithOrientation(r1);
    L11:
        if (this.docSdkVersion != DocSdkVersion.V1) goto L19;
        return KeyboardHeightProvider.Factory.get(r0).keyBoardRawHeight();
    L19:
        return pcb.a.a.b(r0).keyBoardRawHeight();
    }

    private final void registerResultForMultiFileSelect() {
        AlbumHelper r0 = getAlbumHelper();
        Function1 r1 = new a(this);
        Lazy r2 = AlbumHelper.e;
        r0.e(this, "album_helper", r1);
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        DialogFragment r0 = this.photoAlbumFragment;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L12;
        DialogFragment r2 = this.photoAlbumFragment;
        if (r2 == null) goto L13;
        INVOKEVIRTUAL_com_larus_doc_sdk_impl_plugins_state_media_FlowPhotoInsertFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r2);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r0.isAdded() != true) goto L7;
        r1 = true;
        goto L7
    }

    public void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        DialogFragment r0 = this.photoAlbumFragment;
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
        if (this.hasPendingUpdateAlbumUI == false) goto L17;
        this.hasPendingUpdateAlbumUI = false;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new C01661(this, null), 2, null);
        return;
    L17:
        return;
    L9:
        r2 = false;
        goto L10
    }

    private static final Unit onViewCreated$lambda$6$lambda$4() {
        return Unit.INSTANCE;
    }

    private static final Unit onViewCreated$lambda$6$lambda$5() {
        return Unit.INSTANCE;
    }

    public static void INVOKEVIRTUAL_com_larus_doc_sdk_impl_plugins_state_media_FlowPhotoInsertFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(DialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static final /* synthetic */ a0 access$getBottomPhotoPickPage$p(FlowPhotoInsertFragment r0) {
        return r0.bottomPhotoPickPage;
    }

    public static final /* synthetic */ String access$getDocLogicKey$p(FlowPhotoInsertFragment r0) {
        return r0.docLogicKey;
    }

    public static final /* synthetic */ DocSdkVersion access$getDocSdkVersion$p(FlowPhotoInsertFragment r0) {
        return r0.docSdkVersion;
    }

    public static final /* synthetic */ int access$getKeyboardHeight(FlowPhotoInsertFragment r0) {
        return r0.getKeyboardHeight();
    }

    public static final /* synthetic */ DialogFragment access$getPhotoAlbumFragment$p(FlowPhotoInsertFragment r0) {
        return r0.photoAlbumFragment;
    }

    public static final /* synthetic */ SelectMediaViewModel access$getSelectMediaViewModel(FlowPhotoInsertFragment r0) {
        return r0.getSelectMediaViewModel();
    }

    public static final /* synthetic */ void access$startCamera(FlowPhotoInsertFragment r0) {
        r0.startCamera();
    }

    private final Uri getLatestPhotoUri(Context r9) {
        Uri r6 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver r0 = r9.getContentResolver();
        Cursor r10 = com_larus_doc_sdk_impl_plugins_state_media_FlowPhotoInsertFragment_android_content_ContentResolver_query(r0, r6, new String[]{"_id"}, null, null, "date_added DESC");
        if (r10 == null) goto L17;
        Cursor r11 = r10;
        Cursor r1 = r11;     // Catch: Throwable -> L12
        if (r1.moveToFirst() == false) goto L10;
        Uri r2 = Uri.withAppendedPath(r6, String.valueOf(r1.getLong(r1.getColumnIndexOrThrow("_id"))));     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r11, null);
        return r2;
    L10:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r11, null);
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L17:
        return null;
    }

    private final List<SelectedMediaItemV1> getMediaListV1(List<? extends Pair<? extends Uri, String>> r8) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L23;
        Pair r1 = (Pair) r9.next();
        Uri r2 = (Uri) r1.component1();
        String r3 = (String) r1.component2();
        SelectedMediaItemV1 r4 = new SelectedMediaItemV1();
        r4.setContentType(com.larus.office.base.utils.e.f(r2));
        r4.setUuid(UUID.randomUUID().toString());
        StringBuilder r5 = new StringBuilder(FileConst.DOC_PREFIX_URL);
        if (r3 != null) goto L8;
        r3 = com.larus.office.base.utils.e.h(r2);
    L8:
        r5.append(r3);
        String r6 = r5.toString();
        String r7 = "";
        if (r6 != null) goto L11;
        r6 = "";
    L11:
        r4.setMediaFile(r6);
        Pair r10 = com.larus.office.base.utils.e.e(r2);
        int r11 = 0;
        if (r10 == null) goto L14;
        int r12 = ((Number) r10.getFirst()).intValue();
    L15:
        r4.setWidth(r12);
        if (r10 == null) goto L18;
        r11 = ((Number) r10.getSecond()).intValue();
    L18:
        r4.setHeight(r11);
        String r13 = com.larus.office.base.utils.e.g(r2);
        if (r13 == null) goto L22;
        r7 = r13;
    L22:
        r4.setFileName(r7);
        r4.setFileSize(com.larus.office.base.utils.e.d(r2));
        r0.add(r4);
        goto L4
    L14:
        r12 = 0;
        goto L15
    L23:
        return r0;
    }

    private final List<SelectedMediaItem> getMediaListV2(List<? extends Pair<? extends Uri, String>> r8) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L23;
        Pair r1 = (Pair) r9.next();
        Uri r2 = (Uri) r1.component1();
        String r3 = (String) r1.component2();
        SelectedMediaItem r4 = new SelectedMediaItem();
        r4.contentType = com.larus.office.base.utils.e.f(r2);
        r4.uuid = UUID.randomUUID().toString();
        StringBuilder r5 = new StringBuilder(FileConst.DOC_PREFIX_URL);
        if (r3 != null) goto L8;
        r3 = com.larus.office.base.utils.e.h(r2);
    L8:
        r5.append(r3);
        String r6 = r5.toString();
        String r7 = "";
        if (r6 != null) goto L11;
        r6 = "";
    L11:
        r4.mediaFile = r6;
        Pair r10 = com.larus.office.base.utils.e.e(r2);
        int r11 = 0;
        if (r10 == null) goto L14;
        int r12 = ((Number) r10.getFirst()).intValue();
    L15:
        r4.width = r12;
        if (r10 == null) goto L18;
        r11 = ((Number) r10.getSecond()).intValue();
    L18:
        r4.height = r11;
        String r13 = com.larus.office.base.utils.e.g(r2);
        if (r13 == null) goto L22;
        r7 = r13;
    L22:
        r4.fileName = r7;
        r4.fileSize = com.larus.office.base.utils.e.d(r2);
        r0.add(r4);
        goto L4
    L14:
        r12 = 0;
        goto L15
    L23:
        return r0;
    }

    private final void onSelectMedia(List<? extends SelectedMediaItem> r2) {
        this.suppressKeyboardOnDismiss = true;
        SelectMediaViewModel r0 = (SelectMediaViewModel) q.a(this, SelectMediaViewModel.class);
        r0.onSelectMedia(r2);
        r0.hideContainer();
    }

    public static final /* synthetic */ Uri access$getLatestPhotoUri(FlowPhotoInsertFragment r0, Context r1) {
        return r0.getLatestPhotoUri(r1);
    }

    public static final /* synthetic */ List access$getMediaListV1(FlowPhotoInsertFragment r0, List r1) {
        return r0.getMediaListV1(r1);
    }

    public static final /* synthetic */ List access$getMediaListV2(FlowPhotoInsertFragment r0, List r1) {
        return r0.getMediaListV2(r1);
    }

    public static final /* synthetic */ void access$onSelectMedia(FlowPhotoInsertFragment r0, List r1) {
        r0.onSelectMedia(r1);
    }

    public static final /* synthetic */ void access$setBottomPhotoPickPage$p(FlowPhotoInsertFragment r0, a0 r1) {
        r0.bottomPhotoPickPage = r1;
    }

    public static final /* synthetic */ void access$setHasPendingUpdateAlbumUI$p(FlowPhotoInsertFragment r0, boolean r1) {
        r0.hasPendingUpdateAlbumUI = r1;
    }

    public static final /* synthetic */ void access$setPhotoAlbumFragment$p(FlowPhotoInsertFragment r0, DialogFragment r1) {
        r0.photoAlbumFragment = r1;
    }

    private static final void onViewCreated$lambda$3(FlowPhotoInsertFragment r0, View r1) {
        r0.getSelectMediaViewModel().onPrepareInsertImage();
        r0.startCamera();
    }

    private static final void onViewCreated$lambda$6(FlowPhotoInsertFragment r14, View r15) {
        AlbumHelper r0 = r14.getAlbumHelper();
        AlbumSettingConfig.a r16 = new AlbumSettingConfig.a();
        r16.g = Integer.valueOf(ContextCompat.getColor(r14.requireContext(), 2131103292));
        r16.d = 10;
        r16.e = false;
        r16.h = 4;
        r16.c = true;
        AlbumHelper.f(r0, r14, r16.a(), new c(), new d(), null, null, 0, null, null, null, null, null, 3072);
    }

    private static final Unit registerResultForCamera$lambda$10(FlowPhotoInsertFragment r7, CameraOutputContext r8) {
        Intrinsics.checkNotNullParameter(r8, "result");
        List r9 = r8.getOutputParamList();
        if (r9 == null) goto L7;
        OutputParam r10 = (OutputParam) CollectionsKt.firstOrNull(r9);
        if (r10 == null) goto L7;
        String r11 = r10.getPath();
    L8:
        if (r11 != null) goto L10;
        r11 = "";
    L10:
        FLogger.a.e(TAG, "Take picture succeed path:".concat(r11));
        List<SelectedMediaItemV1> r0 = CollectionsKt.emptyList();
        List<SelectedMediaItem> r1 = CollectionsKt.emptyList();
        Uri r2 = Uri.fromFile(new PolarisFileWrapper(r11));
        DocSdkVersion r3 = r7.docSdkVersion;
        int[] r4 = WhenMappings.$EnumSwitchMapping$0;
        int r5 = r4[r3.ordinal()];
        if (r5 == 1) goto L16;
        if (r5 != 2) goto L15;
        r1 = r7.getMediaListV2(CollectionsKt.listOf(TuplesKt.to(r2, r11)));
    L17:
        DialogFragment r12 = r7.photoAlbumFragment;
        if (r12 == null) goto L20;
        INVOKEVIRTUAL_com_larus_doc_sdk_impl_plugins_state_media_FlowPhotoInsertFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r12);
    L20:
        int r13 = r4[r7.docSdkVersion.ordinal()];
        if (r13 == 1) goto L26;
        if (r13 != 2) goto L25;
        r7.onSelectMedia(r1);
    L27:
        ((FlowDocStateViewModel) PluginViewModelProviders.viewModel(r7, FlowDocStateViewModel.class)).toggleToolbarItemState(DocToolbarItemId.INSTANCE.getALL(), r7.docLogicKey);
        return Unit.INSTANCE;
    L25:
        throw new NoWhenBranchMatchedException();
    L26:
        r7.getSelectMediaViewModel().onSelectMediaV1(r0);
        goto L27
    L15:
        throw new NoWhenBranchMatchedException();
    L16:
        r0 = r7.getMediaListV1(CollectionsKt.listOf(TuplesKt.to(r2, r11)));
    L7:
        r11 = null;
        goto L8
    }

    private static final Unit registerResultForMultiFileSelect$lambda$9(FlowPhotoInsertFragment r7, xp9.i r8) {
        Intrinsics.checkNotNullParameter(r8, "multiConfig");
        List<SelectedMediaItemV1> r0 = CollectionsKt.emptyList();
        List<SelectedMediaItem> r1 = CollectionsKt.emptyList();
        DocSdkVersion r2 = r7.docSdkVersion;
        int r3 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r3 == 1) goto L12;
        if (r3 != 2) goto L11;
        List r9 = r8.a;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r10 = r9.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        r4.add(TuplesKt.to((Uri) r10.next(), null));
        goto L7
    L9:
        r1 = r7.getMediaListV2(r4);
    L17:
        DialogFragment r11 = r7.photoAlbumFragment;
        if (r11 == null) goto L20;
        INVOKEVIRTUAL_com_larus_doc_sdk_impl_plugins_state_media_FlowPhotoInsertFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r11);
    L20:
        DocSdkVersion r12 = r7.docSdkVersion;
        int r13 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
        if (r13 == 1) goto L26;
        if (r13 != 2) goto L25;
        r7.onSelectMedia(r1);
    L27:
        ((FlowDocStateViewModel) PluginViewModelProviders.viewModel(r7, FlowDocStateViewModel.class)).toggleToolbarItemState(DocToolbarItemId.INSTANCE.getALL(), r7.docLogicKey);
        return Unit.INSTANCE;
    L25:
        throw new NoWhenBranchMatchedException();
    L26:
        r7.getSelectMediaViewModel().onSelectMediaV1(r0);
        goto L27
    L11:
        throw new NoWhenBranchMatchedException();
    L12:
        List r14 = r8.a;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r15 = r14.iterator();
    L14:
        if (r15.hasNext() == false) goto L16;
        r5.add(TuplesKt.to((Uri) r15.next(), null));
        goto L14
    L16:
        r0 = r7.getMediaListV1(r5);
        goto L17
    }

    public void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        int r5 = getKeyboardHeight();
        FLogger.a.i(TAG, "Keyboard height: " + r5);
        LarusDocPhotoInsertLayoutBinding r6 = this.binding;
        if (r6 == null) goto L7;
        LinearLayout r7 = r6.docBottomPhotoSelectContainer;
        if (r7 == null) goto L7;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r8).height = r5;
    L7:
        LarusDocPhotoInsertLayoutBinding r9 = this.binding;
        if (r9 == null) goto L14;
        LinearLayout r10 = r9.docBottomMenuContainer;
        if (r10 == null) goto L14;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L14;
        r11.height = r5;
    L14:
        LarusDocPhotoInsertLayoutBinding r12 = this.binding;
        if (r12 == null) goto L19;
        LinearLayout r13 = r12.docBottomMenuItemCamera;
        if (r13 == null) goto L19;
        r13.setOnClickListener(new g(this));
    L19:
        LarusDocPhotoInsertLayoutBinding r14 = this.binding;
        if (r14 == null) goto L25;
        LinearLayout r15 = r14.docBottomMenuItemPhoto;
        if (r15 == null) goto L26;
        r15.setOnClickListener(new h(this));
        return;
    L26:
        return;
    }

    public View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        registerResultForMultiFileSelect();
        registerResultForCamera();
        this.suppressKeyboardOnDismiss = false;
        this.binding = LarusDocPhotoInsertLayoutBinding.inflate(r7, null, false);
        Bundle r10 = getArguments();
        if (r10 == null) goto L5;
        Serializable r11 = r10.getSerializable(KEY_DOC_SDK_VERSION);
    L7:
        if ((r11 instanceof DocSdkVersion) == false) goto L9;
        DocSdkVersion r12 = (DocSdkVersion) r11;
    L10:
        if (r12 != null) goto L12;
        r12 = DocSdkVersion.V1;
    L12:
        this.docSdkVersion = r12;
        Bundle r13 = getArguments();
        if (r13 == null) goto L16;
        String r14 = r13.getString(KEY_DOC_LOGIC_KEY);
        if (r14 == null) goto L16;
    L17:
        this.docLogicKey = r14;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
        LarusDocPhotoInsertLayoutBinding r15 = this.binding;
        if (r15 != null) goto L20;
        return null;
    L20:
        return r15.m43getRoot();
    L16:
        r14 = "default_doc_logic_key";
        goto L17
    L9:
        r12 = null;
        goto L10
    L5:
        r11 = null;
        goto L7
    }

    private static Cursor com_larus_doc_sdk_impl_plugins_state_media_FlowPhotoInsertFragment_android_content_ContentResolver_query(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17, String r18) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r14, r15, r16, r17, r18};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r13, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r12 = r13.query(r14, r15, r16, r17, r18);
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, r12, r10, true);
        return r12;
    }
}
