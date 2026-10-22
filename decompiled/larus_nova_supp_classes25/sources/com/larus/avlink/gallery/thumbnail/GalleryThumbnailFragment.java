package com.larus.avlink.gallery.thumbnail;

import android.R;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.avlink.gallery.AlbumUtils;
import com.larus.avlink.gallery.model.ThumbnailMetadata;
import com.larus.avlink.gallery.view.GridSpacingItemDecoration;
import com.larus.avlink.gallery.view.RecyclerViewSwipeMultiSelectHelper;
import com.larus.avlink.gallery.viewmodel.ThumbnailViewModel;
import com.larus.avlink.impl.databinding.LarusFragmentGalleryDetailBinding;
import com.larus.avlink.n1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonVerticalDialog;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012*\u0001'\b\u0007\u0018\u0000 d2\u00020\u00012\u00020\u0002:\u0003defB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u001eJ&\u0010+\u001a\u0004\u0018\u00010\u000e2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u001a\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020\u000e2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00104\u001a\u00020*H\u0002J\b\u00105\u001a\u00020*H\u0002J\b\u00106\u001a\u00020\u0016H\u0016J\b\u00107\u001a\u00020*H\u0016J\b\u00108\u001a\u00020*H\u0002J\b\u00109\u001a\u00020*H\u0002J\u0010\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u00020\u0019H\u0002J\u0010\u0010<\u001a\u00020*2\u0006\u0010=\u001a\u00020%H\u0002J\b\u0010>\u001a\u00020*H\u0002J\b\u0010?\u001a\u00020*H\u0002J\u0018\u0010@\u001a\u00020*2\u0006\u0010A\u001a\u00020\u00162\u0006\u0010B\u001a\u00020\u0016H\u0002J\b\u0010C\u001a\u00020*H\u0002J\b\u0010D\u001a\u00020*H\u0002J\b\u0010E\u001a\u00020*H\u0002J\u0010\u0010F\u001a\u00020*2\u0006\u0010G\u001a\u00020\u0016H\u0002J\b\u0010H\u001a\u00020*H\u0002J\b\u0010I\u001a\u00020*H\u0002J\b\u0010J\u001a\u00020\u0019H\u0002J\"\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u00162\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010OH\u0002J\u000e\u0010P\u001a\u00020*H\u0082@¢\u0006\u0002\u0010QJ\u0016\u0010R\u001a\u00020*2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020U0TH\u0002J\b\u0010V\u001a\u00020*H\u0002J\b\u0010W\u001a\u00020*H\u0016J\b\u0010X\u001a\u00020*H\u0016J\b\u0010Y\u001a\u00020*H\u0016J\b\u0010Z\u001a\u00020*H\u0016J\u0010\u0010[\u001a\u00020*2\u0006\u0010\\\u001a\u00020\u0016H\u0016J\u0010\u0010]\u001a\u00020*2\u0006\u0010\\\u001a\u00020\u0016H\u0016J\b\u0010^\u001a\u00020*H\u0016J\b\u0010_\u001a\u00020*H\u0002J\u0010\u0010`\u001a\u00020*2\u0006\u0010a\u001a\u00020\u0016H\u0002J\u0018\u0010b\u001a\u00020*2\u0006\u0010a\u001a\u00020\u00162\u0006\u0010c\u001a\u00020\u0016H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(¨\u0006g"}, d2 = {"Lcom/larus/avlink/gallery/thumbnail/GalleryThumbnailFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/larus/avlink/gallery/viewmodel/ThumbnailDataChangeListener;", "<init>", "()V", "binding", "Lcom/larus/avlink/impl/databinding/LarusFragmentGalleryDetailBinding;", "viewModel", "Lcom/larus/avlink/gallery/viewmodel/ThumbnailViewModel;", "adapter", "Lcom/larus/avlink/gallery/thumbnail/ThumbnailListAdapter;", "syncBtn", "Landroid/widget/TextView;", "deleteBtn", "Landroid/view/View;", "cancelSelectBtn", "syncNumberText", "albumStateListener", "Lcom/larus/avlink/gallery/thumbnail/FlowAlbumCountChangeListener;", "sceneStateChangeListener", "Lcom/larus/avlink/common/SceneStateChangeListener;", "currentImageCount", "", "currentVideoCount", "isDeleteInProgress", "", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "isDismissRequested", "listener", "Lcom/larus/avlink/gallery/thumbnail/GalleryThumbnailListener;", "swipeMultiSelectHelper", "Lcom/larus/avlink/gallery/view/RecyclerViewSwipeMultiSelectHelper;", "swipeSelectionState", "Lcom/larus/avlink/gallery/thumbnail/GalleryThumbnailFragment$SwipeSelectionState;", "dismissDragEnabled", "defaultDimAmount", "", "bottomSheetCallback", "com/larus/avlink/gallery/thumbnail/GalleryThumbnailFragment$bottomSheetCallback$1", "Lcom/larus/avlink/gallery/thumbnail/GalleryThumbnailFragment$bottomSheetCallback$1;", "setListener", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initViewModel", "initView", "getTheme", "dismiss", "initBottomSheetDialog", "setupBottomSheetDismissHotZone", "setBottomSheetDragEnabled", "enabled", "applyWindowDimAmount", "dimAmount", "setupObservers", "observeAlbumStateChanges", "updateSyncNumberText", "imageCount", "videoCount", "showWarningBanner", "updateSyncButtonText", "updateDeleteButtonState", "updateBottomContainerAlpha", "selectedCount", "updateSelectBtn", "handleSyncButtonClick", "checkStorageSpace", "createDeleteConfirmDialog", "Landroidx/fragment/app/DialogFragment;", "deleteCount", "onConfirm", "Lkotlin/Function0;", "handleDeleteButtonClick", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performDelete", "selectedItems", "", "Lcom/larus/avlink/gallery/model/ThumbnailMetadata;", "restoreDeleteButton", "onStart", "onStop", "onResume", "onDataRefreshed", "onThumbnailDeleted", "count", "onThumbnailSynced", "onDestroyView", "setupSwipeMultiSelection", "beginSwipeSelection", "anchorPosition", "applySwipeSelection", "currentPosition", "Companion", "SwipeSelectionState", "SwipeSelectionMode", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class GalleryThumbnailFragment extends BottomSheetDialogFragment implements com.larus.avlink.gallery.viewmodel.d {
    public static final /* synthetic */ int x = 0;
    public LarusFragmentGalleryDetailBinding d;
    public ThumbnailViewModel e;
    public ThumbnailListAdapter f;
    public TextView g;
    public ConstraintLayout h;
    public TextView i;
    public TextView j;
    public e0 k;
    public g0 l;
    public int m;
    public int n;
    public boolean o;
    public BottomSheetBehavior<?> p;
    public boolean q;
    public h0 r;
    public RecyclerViewSwipeMultiSelectHelper s;
    public b t;
    public boolean u;
    public float v;
    public final d w;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/avlink/gallery/thumbnail/GalleryThumbnailFragment$SwipeSelectionMode;", "", "<init>", "(Ljava/lang/String;I)V", "ADD", "REMOVE", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum SwipeSelectionMode extends Enum<SwipeSelectionMode> {
        public static final SwipeSelectionMode ADD = null;
        public static final SwipeSelectionMode REMOVE = null;
        public static final /* synthetic */ SwipeSelectionMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<SwipeSelectionMode> getEntries() {
            return b;
        }

        static {
            SwipeSelectionMode r0 = new SwipeSelectionMode("ADD", 0);
            ADD = r0;
            SwipeSelectionMode r1 = new SwipeSelectionMode("REMOVE", 1);
            REMOVE = r1;
            SwipeSelectionMode[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static SwipeSelectionMode[] values() {
            return (SwipeSelectionMode[]) a.clone();
        }

        public static SwipeSelectionMode valueOf(String r1) {
            return (SwipeSelectionMode) r27.a.a(SwipeSelectionMode.class, r1);
        }

        public SwipeSelectionMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final Set<ThumbnailMetadata> b;
        public final SwipeSelectionMode c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "SwipeSelectionState(anchorPosition=" + this.a + ", initialSelectedItems=" + this.b + ", mode=" + this.c + ')';
        }

        public b(int r2, Set<ThumbnailMetadata> r3, SwipeSelectionMode r4) {
            Intrinsics.checkNotNullParameter(r3, "initialSelectedItems");
            Intrinsics.checkNotNullParameter(r4, "mode");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SwipeSelectionMode.values().length];
            r0[SwipeSelectionMode.ADD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[SwipeSelectionMode.REMOVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class d extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ GalleryThumbnailFragment a;

        public d(GalleryThumbnailFragment r1) {
            this.a = r1;
        }

        public final void onSlide(View r4, float r5) {
            Intrinsics.checkNotNullParameter(r4, "bottomSheet");
            GalleryThumbnailFragment r6 = this.a;
            if (r6.u == true) goto L5;
            return;
        L5:
            if (r6.q == true) goto L22;
            r6.V90(r6.v * RangesKt.coerceIn(r5, 0.0f, 1.0f));
            if (r5 < 0.3f) goto L17;
            return;
        L17:
            this.a.dismiss();     // Catch: Exception -> L12
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r7 = DialogFragmentLancet.sLastShowStack;
            if (r7 == null) goto L21;
            com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L21:
            return;
        }

        public final void onStateChanged(View r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "bottomSheet");
            if (r4 != 5) goto L7;
            GalleryThumbnailFragment r5 = this.a;
            int r6 = GalleryThumbnailFragment.x;
            r5.V90(0.0f);
            GalleryThumbnailFragment r7 = this.a;
            r7.q = true;
            GalleryThumbnailFragment.S90(r7);
            return;
        L7:
            if (r4 != 3) goto L9;
            GalleryThumbnailFragment r0 = this.a;
            r0.V90(r0.v);
        L9:
            GalleryThumbnailFragment r1 = this.a;
            BottomSheetBehavior<?> r2 = r1.p;
            if (r2 != null) goto L13;
            return;
        L13:
            if (r1.u == false) goto L15;
            return;
        L15:
            if (r4 != 4) goto L19;
            r2.setState(3);
            return;
        }
    }

    public static final class e implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public e(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.gallery.thumbnail.GalleryThumbnailFragment$onResume$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.thumbnail.GalleryThumbnailFragment$onResume$1", f = "GalleryThumbnailFragment.kt", i = {}, l = {836}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GalleryThumbnailFragment this$0;

        public AnonymousClass1(GalleryThumbnailFragment r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            if (this.this$0.isAdded() == false) goto L17;
            FLogger.a.d("GalleryThumbnailFragment", "Secondary refresh triggered after onResume delay");
            ThumbnailViewModel r7 = this.this$0.e;
            if (r7 == null) goto L17;
            r7.refreshThumbnailList(true);
        L17:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            this.label = 1;
            if (DelayKt.delay(500, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    @Override // com.larus.avlink.gallery.viewmodel.d
    public final void VO() {
    }

    public final int getTheme() {
        return 2131954367;
    }

    public final void onDestroyView() {
        this.p = null;
        this.q = false;
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        RecyclerViewSwipeMultiSelectHelper r1 = this.s;
        if (r1 == null) goto L5;
        r1.b();
        r1.a.removeOnItemTouchListener(r1);
        r1.a();
    L5:
        this.s = null;
        this.t = null;
        e0 r2 = this.k;
        if (r2 == null) goto L8;
        ThumbnailManager r3 = ThumbnailManager.a;
        ThumbnailManager.p(r2);
    L8:
        g0 r4 = this.l;
        if (r4 == null) goto L11;
        b98.b.e(r4);
    L11:
        this.d = null;
        ThumbnailManager.n = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.ArrayList] */
    public final void W90() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        boolean r1 = true;
        if (r0 == null) goto L9;
        DeviceService r2 = r0.device();
        if (r2 == null) goto L9;
        if (r2.u() != 2) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L19;
        LarusFragmentGalleryDetailBinding r4 = this.d;
        if (r4 == null) goto L47;
        ConstraintLayout r5 = r4.a;
        if (r5 == null) goto L48;
        Context r6 = r5.getContext();
        if (r6 == null) goto L49;
        t19.s.a.g(r6, 2131902105, false);
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L19:
        ThumbnailViewModel r7 = this.e;
        if (r7 == null) goto L27;
        List<ThumbnailMetadata> r8 = r7.m29getSelectedItems();
        if (r8 == null) goto L27;
        List<ThumbnailMetadata> r9 = r8;
        ?? r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r11 = r9.iterator();
    L25:
        if (r11.hasNext() == false) goto L29;
        r10.add(Long.valueOf(((ThumbnailMetadata) r11.next()).getImageUuid()));
    L29:
        if (r10.isEmpty() == false) goto L32;
        FLogger.a.i("GalleryThumbnailFragment", "No thumbnails selected");
        return;
    L32:
        int r12 = AlbumUtils.a;
        StatFs r13 = new StatFs(Environment.getDataDirectory().getPath());
        if ((r13.getAvailableBlocksLong() * r13.getBlockSizeLong()) >= 524288000) goto L42;
        LarusFragmentGalleryDetailBinding r14 = this.d;
        if (r14 == null) goto L41;
        ConstraintLayout r15 = r14.a;
        if (r15 == null) goto L41;
        Context r16 = r15.getContext();
        if (r16 == null) goto L41;
        t19.s.a.g(r16, 2131902148, false);
    L41:
        r1 = false;
    L42:
        if (r1 == true) goto L44;
        return;
    L44:
        FLogger.a.i("GalleryThumbnailFragment", "Starting sync for " + r10.size() + " thumbnails, exiting fragment");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GalleryThumbnailFragment$handleSyncButtonClick$2(this, r10, null), 3, null);
        return;
    L27:
        r10 = CollectionsKt.emptyList();
    L9:
        r3 = false;
        goto L10
    }

    public final void X90() {
        FLogger.a.i("GalleryThumbnailFragment", "showWarningBanner");
        TextView r0 = this.j;
        if (r0 == null) goto L5;
        r0.setText(AppHost.a.getApplication().getString(2131902127));
    L5:
        Drawable r1 = ContextCompat.getDrawable(AppHost.a.getApplication(), 2131243219);
        TextView r2 = this.j;
        if (r2 == null) goto L8;
        r2.setCompoundDrawablesWithIntrinsicBounds(null, null, r1, null);
    L8:
        TextView r3 = this.j;
        if (r3 == null) goto L11;
        r3.setCompoundDrawablePadding(i5.r0());
    L11:
        TextView r4 = this.j;
        if (r4 == null) goto L25;
        int r5 = 0;
        if (r4 == null) goto L16;
        int r6 = r4.getPaddingLeft();
    L17:
        TextView r7 = this.j;
        if (r7 == null) goto L20;
        int r8 = r7.getPaddingTop();
    L21:
        int r9 = i5.q();
        TextView r10 = this.j;
        if (r10 == null) goto L24;
        r5 = r10.getPaddingBottom();
    L24:
        r4.setPadding(r6, r8, r9, r5);
        goto L25
    L20:
        r8 = 0;
        goto L21
    L16:
        r6 = 0;
    L25:
        TextView r11 = this.j;
        if (r11 == null) goto L29;
        r11.setOnClickListener(new com.larus.avlink.gallery.thumbnail.b());
        return;
    }

    public final void Y90() {
        ThumbnailViewModel r0 = this.e;
        boolean r1 = false;
        if (r0 == null) goto L9;
        LiveData<Integer> r2 = r0.getSelectedCount();
        if (r2 == null) goto L9;
        Integer r3 = (Integer) r2.getValue();
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L10:
        ConstraintLayout r5 = this.h;
        if (r5 == null) goto L15;
        if (r4 <= 0) goto L14;
        r1 = true;
    L14:
        r5.setEnabled(r1);
    L15:
        if (r4 != 0) goto L17;
        float r6 = 0.3f;
    L18:
        LarusFragmentGalleryDetailBinding r7 = this.d;
        if (r7 == null) goto L24;
        ConstraintLayout r8 = r7.c;
        if (r8 == null) goto L25;
        r8.setAlpha(r6);
        return;
    L25:
        return;
    L24:
        return;
    L17:
        r6 = 1.0f;
    L9:
        r4 = 0;
        goto L10
    }

    public final void Z90() {
        ThumbnailViewModel r0 = this.e;
        if (r0 == null) goto L9;
        LiveData<Boolean> r1 = r0.isAllSelected();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        boolean r3 = r2.booleanValue();
    L10:
        TextView r4 = this.i;
        if (r4 == null) goto L18;
        Application r5 = AppHost.a.getApplication();
        if (r3 == false) goto L15;
        int r6 = 2131902104;
    L16:
        r4.setText(r5.getString(r6));
        return;
    L15:
        r6 = 2131902133;
        goto L16
    L18:
        return;
    L9:
        r3 = false;
        goto L10
    }

    public final void aa0() {
        ThumbnailViewModel r0 = this.e;
        boolean r1 = false;
        if (r0 == null) goto L9;
        LiveData<Integer> r2 = r0.getSelectedCount();
        if (r2 == null) goto L9;
        Integer r3 = (Integer) r2.getValue();
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L10:
        ThumbnailViewModel r5 = this.e;
        if (r5 == null) goto L13;
        int r6 = r5.getThumbnailCount();
    L14:
        String r7 = AppHost.a.getApplication().getString(2131902147);
        if (r4 == 0) goto L18;
        r7 = r7 + 65288 + r4 + 65289;
    L18:
        TextView r8 = this.g;
        if (r8 == null) goto L21;
        r8.setText(r7);
    L21:
        TextView r9 = this.g;
        if (r9 == null) goto L28;
        if (r6 <= 0) goto L26;
        if (r4 <= 0) goto L26;
        r1 = true;
    L26:
        r9.setEnabled(r1);
        return;
    L28:
        return;
    L13:
        r6 = 0;
    L9:
        r4 = 0;
        goto L10
    }

    public final void dismiss() {
        if (this.q == false) goto L5;
        return;
    L5:
        this.q = true;
        BottomSheetBehavior<?> r0 = this.p;
        if (r0 != null) goto L8;
        S90(this);
        return;
    L8:
        if (r0.getState() != 5) goto L10;
        S90(this);
        return;
    L10:
        r0.setState(5);
    }

    public GalleryThumbnailFragment() {
        this.w = new d(this);
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        FLogger.a.i("GalleryThumbnailFragment", "Fragment resumed, refreshing thumbnail list with force");
        ThumbnailViewModel r0 = this.e;
        if (r0 == null) goto L5;
        r0.refreshThumbnailList(true);
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        ThumbnailViewModel.Companion.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        if (ThumbnailViewModel.access$getDataChangeListeners$cp().contains(this) == true) goto L5;
        ThumbnailViewModel.access$getDataChangeListeners$cp().add(this);
        FLogger.a.i("ThumbnailViewModel", "Registered data change listener, total: " + ThumbnailViewModel.access$getDataChangeListeners$cp().size());
    L5:
        FLogger.a.i("GalleryThumbnailFragment", "Registered data change listener");
    }

    public final void onStop() {
        super/*androidx.fragment.app.DialogFragment*/.onStop();
        ThumbnailViewModel.Companion.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        ThumbnailViewModel.access$getDataChangeListeners$cp().remove(this);
        FLogger r0 = FLogger.a;
        r0.i("ThumbnailViewModel", "Unregistered data change listener, total: " + ThumbnailViewModel.access$getDataChangeListeners$cp().size());
        r0.i("GalleryThumbnailFragment", "Unregistered data change listener");
    }

    public static void S90(BottomSheetDialogFragment r1) {
        super/*androidx.fragment.app.DialogFragment*/.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.larus.avlink.gallery.viewmodel.d
    public final void HZ(int r4) {
        FLogger.a.i("GalleryThumbnailFragment", "Thumbnail deleted notification: " + r4 + " items");
    }

    public final void V90(float r4) {
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        r1.setDimAmount(RangesKt.coerceIn(r4, 0.0f, this.v));
        return;
    L9:
        return;
    }

    @Override // com.larus.avlink.gallery.viewmodel.d
    public final void cQ(int r4) {
        FLogger.a.i("GalleryThumbnailFragment", "Thumbnail synced notification: " + r4 + " items");
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.larus.avlink.gallery.thumbnail.s] */
    public static final Object T90(final GalleryThumbnailFragment r7, Continuation r8) {
        r7.getClass();
        if ((r8 instanceof GalleryThumbnailFragment$handleDeleteButtonClick$1) == false) goto L7;
        GalleryThumbnailFragment$handleDeleteButtonClick$1 r0 = (GalleryThumbnailFragment$handleDeleteButtonClick$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L17:
        Integer r10 = (Integer) r9;
        if (r10 != null) goto L21;
    L22:
        LarusFragmentGalleryDetailBinding r11 = r7.d;
        if (r11 == null) goto L45;
        ConstraintLayout r12 = r11.a;
        if (r12 == null) goto L45;
        Context r13 = r12.getContext();
        if (r13 == null) goto L45;
        t19.s.a.g(r13, 2131902105, false);
    L45:
        return Unit.INSTANCE;
    L21:
        if (r10.intValue() != 2) goto L22;
        ThumbnailViewModel r14 = r7.e;
        if (r14 == null) goto L34;
        final List<ThumbnailMetadata> r15 = r14.m29getSelectedItems();
        if (r15 == null) goto L34;
    L35:
        int r4 = r15.size();
        ?? r5 = new s(r7, r15);
        String r16 = r7.getString(2131902090);
        Intrinsics.checkNotNullParameter(r16, "title");
        String r6 = r7.getString(2131902095);
        Intrinsics.checkNotNullParameter(r6, "message");
        a0 r17 = new a0(r4, r5);
        AppHost.Companion r18 = AppHost.a;
        String r19 = r18.getApplication().getString(2131902172);
        Intrinsics.checkNotNullParameter(r17, "listener");
        b0 r20 = new b0(r7);
        String r21 = r18.getApplication().getString(2131902171);
        Intrinsics.checkNotNullParameter(r20, "listener");
        CommonVerticalDialog r22 = new CommonVerticalDialog();
        r22.e = r16;
        r22.f = r6;
        r22.g = r19;
        r22.h = r17;
        r22.i = r21;
        r22.k = -7829368;
        r22.j = r20;
        FragmentManager r23 = r7.getParentFragmentManager();
        LandscapeRestrictionOperation r24 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r22, "DeleteConfirmDialog", r24);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r23, r22, r24) == true) goto L41;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L42
    L39:
        r22.show(r23, "DeleteConfirmDialog");
    L41:
        return Unit.INSTANCE;
    L34:
        r15 = CollectionsKt.emptyList();
        goto L35
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        CoroutineDispatcher r25 = Dispatchers.getIO();
        GalleryThumbnailFragment$handleDeleteButtonClick$doraState$1 r26 = new GalleryThumbnailFragment$handleDeleteButtonClick$doraState$1(null);
        r0.label = 1;
        r9 = BuildersKt.withContext(r25, r26, r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new GalleryThumbnailFragment$handleDeleteButtonClick$1(r7, r8);
        goto L8
    }

    public final void U90(int r6, int r7) {
        b r0 = this.t;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.a == r6) goto L8;
        return;
    L8:
        ThumbnailListAdapter r8 = this.f;
        if (r8 == null) goto L41;
        List r9 = r8.getCurrentList();
        if (r9 != null) goto L14;
        return;
    L14:
        if (r9.isEmpty() == false) goto L16;
        return;
    L16:
        int r1 = Math.min(r0.a, r7);
        int r10 = Math.max(r0.a, r7);
        boolean r3 = false;
        if (r1 >= 0) goto L19;
    L21:
        boolean r4 = false;
    L22:
        if (r4 == false) goto L42;
        if (r10 >= 0) goto L25;
    L27:
        if (r3 == false) goto L45;
        Set r11 = CollectionsKt.toSet(r9.subList(r1, r10 + 1));
        Set<ThumbnailMetadata> r12 = CollectionsKt.toMutableSet(r0.b);
        SwipeSelectionMode r2 = r0.c;
        int r5 = c.a[r2.ordinal()];
        if (r5 != 1) goto L32;
        r12.addAll(r11);
    L37:
        ThumbnailViewModel r13 = this.e;
        if (r13 == null) goto L43;
        r13.applySelection(r12);
        return;
    L43:
        return;
    L32:
        if (r5 != 2) goto L35;
        r12.removeAll(r11);
        goto L37
    L35:
        throw new NoWhenBranchMatchedException();
    L45:
        return;
    L25:
        if (r10 >= r9.size()) goto L27;
        r3 = true;
        goto L27
    L42:
        return;
    L19:
        if (r1 >= r9.size()) goto L21;
        r4 = true;
        goto L22
    }

    public final void ba0(int r6, int r7) {
        n1.d("GalleryThumbnailFragment", "updateSyncNumberText: imageCount=" + r6 + ", videoCount=" + r7);
        int r0 = i5.r0();
        if (r6 != 0) goto L7;
        if (r7 != 0) goto L7;
        String r8 = "没有媒体未同步";
    L12:
        TextView r9 = this.j;
        if (r9 == null) goto L15;
        r9.setText(r8);
    L15:
        Drawable r10 = ContextCompat.getDrawable(AppHost.a.getApplication(), 2131240821);
        TextView r11 = this.j;
        if (r11 == null) goto L18;
        r11.setCompoundDrawablesWithIntrinsicBounds(r10, null, null, null);
    L18:
        TextView r12 = this.j;
        if (r12 == null) goto L21;
        r12.setCompoundDrawablePadding(r0);
    L21:
        TextView r13 = this.j;
        if (r13 == null) goto L31;
        if (r13 == null) goto L25;
        int r14 = r13.getPaddingTop();
    L26:
        TextView r1 = this.j;
        if (r1 == null) goto L29;
        int r2 = r1.getPaddingBottom();
    L30:
        r13.setPadding(0, r14, 0, r2);
        goto L31
    L29:
        r2 = 0;
        goto L30
    L25:
        r14 = 0;
    L31:
        TextView r15 = this.j;
        if (r15 == null) goto L35;
        r15.setOnClickListener(null);
        return;
    L35:
        return;
    L7:
        if (r6 != 0) goto L9;
        r8 = AppHost.a.getApplication().getString(2131902154, new Object[]{Integer.valueOf(r7)});
        goto L12
    L9:
        if (r7 != 0) goto L11;
        r8 = AppHost.a.getApplication().getString(2131902152, new Object[]{Integer.valueOf(r6)});
        goto L12
    L11:
        r8 = AppHost.a.getApplication().getString(2131902151, new Object[]{Integer.valueOf(r6), Integer.valueOf(r7)});
        goto L12
    }

    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r13, r14);
        this.e = (ThumbnailViewModel) new ViewModelProvider(this).get(ThumbnailViewModel.class);
        BottomSheetDialog r15 = getDialog();
        if ((r15 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r16 = r15;
    L6:
        if (r16 == null) goto L8;
        View r17 = r16.findViewById(2131368870);
    L9:
        int r1 = com.larus.utils.m0.a;
        int r2 = com.larus.utils.m0.a(getContext());
        com.larus.utils.i0.a.getClass();
        int r3 = (r2 - com.larus.utils.i0.g()) - com.larus.utils.i0.e();
        if (r17 == null) goto L18;
        ViewGroup.LayoutParams r4 = r17.getLayoutParams();
        r4.height = r3;
        r17.setLayoutParams(r4);
        r17.setBackgroundResource(R.color.transparent);
        Window r18 = r16.getWindow();
        if (r18 == null) goto L16;
        WindowManager.LayoutParams r19 = r18.getAttributes();
        if (r19 == null) goto L16;
        float r110 = r19.dimAmount;
    L17:
        this.v = r110;
        V90(r110);
        BottomSheetBehavior<?> r111 = BottomSheetBehavior.from(r17);
        r111.setState(3);
        r111.setPeekHeight(0);
        r111.setHideable(true);
        r111.setSkipCollapsed(true);
        r111.setBottomSheetCallback(this.w);
        this.p = r111;
    L16:
        r110 = 0.0f;
    L18:
        LarusFragmentGalleryDetailBinding r112 = this.d;
        if (r112 == null) goto L23;
        ConstraintLayout r113 = r112.d;
        if (r113 == null) goto L23;
        r113.setOnTouchListener(new l(this));
    L23:
        LarusFragmentGalleryDetailBinding r114 = this.d;
        if (r114 == null) goto L28;
        RecyclerView r115 = r114.b;
        if (r115 == null) goto L28;
        r115.setOnTouchListener(new n(this));
    L28:
        LarusFragmentGalleryDetailBinding r116 = this.d;
        if (r116 == null) goto L44;
        ConstraintLayout r117 = r116.d;
        if (r117 == null) goto L44;
        ImageView r118 = (ImageView) r117.findViewWithTag("close_icon");
        if (r118 != null) goto L38;
        View r119 = r117.getChildAt(0);
        if ((r119 instanceof ImageView) == false) goto L37;
        r118 = (ImageView) r119;
        goto L38
    L37:
        r118 = null;
    L38:
        if (r118 == null) goto L40;
        r118.setImageResource(2131241051);
    L40:
        if (r118 == null) goto L42;
        r118.setColorFilter(ContextCompat.getColor(r117.getContext(), 2131103136));
    L42:
        if (r118 == null) goto L44;
        r118.setOnClickListener(new w(this));
    L44:
        LarusFragmentGalleryDetailBinding r120 = this.d;
        if (r120 == null) goto L56;
        ConstraintLayout r121 = r120.d;
        if (r121 == null) goto L56;
        View r122 = r121.getChildAt(2);
        if ((r122 instanceof TextView) == false) goto L51;
        TextView r123 = (TextView) r122;
    L52:
        this.i = r123;
        if (r123 == null) goto L55;
        r123.setOnClickListener(new x(this));
    L55:
        Z90();
        goto L56
    L51:
        r123 = null;
    L56:
        LarusFragmentGalleryDetailBinding r124 = this.d;
        if (r124 == null) goto L61;
        ConstraintLayout r125 = r124.a;
        if (r125 == null) goto L61;
        TextView r126 = (TextView) r125.findViewById(2131387961);
    L62:
        this.j = r126;
        LarusFragmentGalleryDetailBinding r127 = this.d;
        if (r127 == null) goto L67;
        RecyclerView r128 = r127.b;
        if (r128 == null) goto L67;
        r128.setLayoutManager(new GridLayoutManager(r128.getContext(), 3));
        r128.setItemAnimator(null);
        r128.setNestedScrollingEnabled(false);
        ThumbnailListAdapter r129 = new ThumbnailListAdapter(new c0(this, r128));
        this.f = r129;
        r128.setAdapter(r129);
        r128.addItemDecoration(new GridSpacingItemDecoration(i5.z(), Boolean.FALSE));
    L67:
        LarusFragmentGalleryDetailBinding r130 = this.d;
        if (r130 == null) goto L76;
        RecyclerView r5 = r130.b;
        if (r5 == null) goto L76;
        RecyclerViewSwipeMultiSelectHelper r131 = this.s;
        if (r131 == null) goto L75;
        r131.b();
        r131.a.removeOnItemTouchListener(r131);
        r131.a();
    L75:
        this.s = new RecyclerViewSwipeMultiSelectHelper(r5, new o(this), new GalleryThumbnailFragment$setupSwipeMultiSelection$2(this), new GalleryThumbnailFragment$setupSwipeMultiSelection$3(this), new p(this), null, null);
    L76:
        TextView r132 = this.g;
        if (r132 == null) goto L79;
        r132.setOnClickListener(new y(this));
    L79:
        LarusFragmentGalleryDetailBinding r133 = this.d;
        if (r133 == null) goto L90;
        ConstraintLayout r134 = r133.c;
        if (r134 == null) goto L90;
        ConstraintLayout r135 = r134.getChildAt(0);
        if ((r135 instanceof ConstraintLayout) == false) goto L86;
        ConstraintLayout r136 = r135;
    L87:
        if (r136 == null) goto L89;
        r136.setOnClickListener(new z(this));
    L89:
        this.h = r136;
        goto L90
    L86:
        r136 = null;
    L90:
        aa0();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), Dispatchers.getMain(), null, new GalleryThumbnailFragment$initView$6(this, null), 2, null);
        Y90();
        ThumbnailViewModel r137 = this.e;
        if (r137 == null) goto L95;
        LiveData<List<ThumbnailMetadata>> r138 = r137.getThumbnailList();
        if (r138 == null) goto L95;
        r138.observe(getViewLifecycleOwner(), new e(new com.larus.avlink.gallery.thumbnail.c(this)));
    L95:
        ThumbnailViewModel r139 = this.e;
        if (r139 == null) goto L100;
        LiveData<Set<ThumbnailMetadata>> r140 = r139.getSelectedItems();
        if (r140 == null) goto L100;
        r140.observe(getViewLifecycleOwner(), new e(new com.larus.avlink.gallery.thumbnail.d(this)));
    L100:
        ThumbnailViewModel r141 = this.e;
        if (r141 == null) goto L105;
        LiveData<Integer> r142 = r141.getSelectedCount();
        if (r142 == null) goto L105;
        r142.observe(getViewLifecycleOwner(), new e(new com.larus.avlink.gallery.thumbnail.e(this)));
    L105:
        ThumbnailViewModel r143 = this.e;
        if (r143 == null) goto L110;
        LiveData<Boolean> r144 = r143.isSelectionMode();
        if (r144 == null) goto L110;
        r144.observe(getViewLifecycleOwner(), new e(new f(this)));
    L110:
        ThumbnailViewModel r145 = this.e;
        if (r145 == null) goto L115;
        LiveData<Boolean> r146 = r145.isAllSelected();
        if (r146 == null) goto L115;
        r146.observe(getViewLifecycleOwner(), new e(new g(this)));
    L115:
        ThumbnailViewModel r147 = this.e;
        if (r147 == null) goto L120;
        LiveData<String> r148 = r147.getErrorMessage();
        if (r148 == null) goto L120;
        r148.observe(getViewLifecycleOwner(), new e(new h(this)));
    L120:
        ThumbnailViewModel r149 = this.e;
        if (r149 == null) goto L125;
        LiveData<List<Long>> r150 = r149.getDeleteCompleteEvent();
        if (r150 == null) goto L125;
        r150.observe(getViewLifecycleOwner(), new e(new i(this)));
    L125:
        ThumbnailViewModel r151 = this.e;
        if (r151 == null) goto L130;
        LiveData<Integer> r152 = r151.getSyncCompleteEvent();
        if (r152 == null) goto L130;
        r152.observe(getViewLifecycleOwner(), new e(new j(this)));
    L130:
        e0 r153 = new e0(this);
        this.k = r153;
        ThumbnailManager r154 = ThumbnailManager.a;
        ThumbnailManager.g(r153);
        g0 r155 = new g0(this);
        this.l = r155;
        b98.b.c(r155);
        ThumbnailManager.s("fragment");
        ThumbnailManager.n = new m(this);
        return;
    L61:
        r126 = null;
        goto L62
    L8:
        r17 = null;
        goto L9
    L5:
        r16 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        ConstraintLayout r10 = r7.inflate(2131562396, r8, false);
        int r11 = 2131362469;
        RecyclerView r2 = ViewBindings.findChildViewById(r10, 2131362469);
        if (r2 == null) goto L25;
        r11 = 2131364437;
        ConstraintLayout r3 = ViewBindings.findChildViewById(r10, 2131364437);
        if (r3 == null) goto L25;
        r11 = 2131366975;
        if (((ImageView) ViewBindings.findChildViewById(r10, 2131366975)) == null) goto L25;
        r11 = 2131368785;
        if (ViewBindings.findChildViewById(r10, 2131368785) == null) goto L25;
        r11 = 2131368779;
        if (((ImageView) ViewBindings.findChildViewById(r10, 2131368779)) == null) goto L25;
        r11 = 2131368798;
        if (((TextView) ViewBindings.findChildViewById(r10, 2131368798)) == null) goto L25;
        r11 = 2131385777;
        if (((TextView) ViewBindings.findChildViewById(r10, 2131385777)) == null) goto L25;
        r11 = 2131387232;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r10, 2131387232);
        if (r12 == null) goto L25;
        r11 = 2131387961;
        if (((TextView) ViewBindings.findChildViewById(r10, 2131387961)) == null) goto L25;
        r11 = 2131389138;
        ConstraintLayout r5 = ViewBindings.findChildViewById(r10, 2131389138);
        if (r5 == null) goto L25;
        ConstraintLayout r13 = r10;
        this.d = new LarusFragmentGalleryDetailBinding(r13, r2, r3, r12, r5);
        this.g = r12;
        return r13;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
