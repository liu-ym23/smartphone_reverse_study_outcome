package com.larus.photopicker.v2.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.viewbinding.ViewBindings;
import com.ixigua.lib.track.TrackParams;
import com.larus.chat.gallery.api.PreviewMediaType;
import com.larus.chat.gallery.api.PreviewSelectionLimit;
import com.larus.chat.gallery.api.PreviewSendFailureReason;
import com.larus.chat.gallery.api.SelectResultReason;
import com.larus.chat.gallery.api.r;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.InjectInputContainer;
import com.larus.photopicker.v2.impl.data.ContentResolverMediaSource;
import com.larus.photopicker.v2.impl.data.MediaRepositoryImpl;
import com.larus.photopicker.v2.impl.data.model.LazyLoadConfig;
import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentGalleryBinding;
import com.larus.photopicker.v2.impl.injectinput.InjectInputCoordinator$addFragmentSafely$1;
import com.larus.photopicker.v2.impl.injectinput.InjectInputCoordinator$registerInjectInputLifecycleCallbacks$callbacks$1;
import com.larus.photopicker.v2.impl.model.MediaGalleryUIConfig;
import com.larus.photopicker.v2.impl.model.MediaNonUISettings;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaMobViewModel;
import com.larus.photopicker.v2.impl.viewmodel.UnSelectableToastType;
import com.larus.platform.api.g3;
import com.larus.platform.model.MediaPickerUIMode;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.AttachmentSource;
import com.larus.platform.model.preview.ResourceRef;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.trace.tracknode.a$a;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0002]^B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020'H\u0016J\u0012\u0010+\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J&\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u001a\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020/2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u00106\u001a\u00020'H\u0002J\b\u00107\u001a\u00020'H\u0016J\b\u00108\u001a\u00020'H\u0016J\b\u00109\u001a\u00020'H\u0016J\u0015\u0010:\u001a\u00020'2\u0006\u0010;\u001a\u00020$H\u0000¢\u0006\u0002\b<J\u0015\u0010=\u001a\u00020'2\u0006\u0010>\u001a\u00020?H\u0000¢\u0006\u0002\b@J\u001b\u0010A\u001a\u00020$2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020D0CH\u0000¢\u0006\u0002\bEJ\u0015\u0010F\u001a\u00020'2\u0006\u0010G\u001a\u00020!H\u0000¢\u0006\u0002\bHJ\b\u0010I\u001a\u00020$H\u0016J\b\u0010J\u001a\u00020$H\u0002J\f\u0010K\u001a\u00020L*\u00020MH\u0002J\u0018\u0010N\u001a\b\u0012\u0004\u0012\u00020L0C2\b\u0010O\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010P\u001a\u00020'2\u0006\u0010Q\u001a\u00020$H\u0002J\u0010\u0010R\u001a\u00020'2\u0006\u0010S\u001a\u00020?H\u0002J(\u0010T\u001a\u00020'2\b\u0010U\u001a\u0004\u0018\u00010V2\u0016\b\u0002\u0010W\u001a\u0010\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020'\u0018\u00010XJ\u0006\u0010Y\u001a\u00020'J\u0018\u0010Z\u001a\u00020'2\u000e\u0010[\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0CH\u0002J\b\u0010\\\u001a\u00020'H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/larus/photopicker/v2/impl/MediaGalleryFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/bmhome/injectinput/IInjectInputPhotoPickerPage;", "<init>", "()V", "uiConfig", "Lcom/larus/photopicker/v2/impl/model/MediaGalleryUIConfig;", "lazyLoadConfig", "Lcom/larus/photopicker/v2/impl/data/model/LazyLoadConfig;", "binding", "Lcom/larus/photopicker/v2/impl/databinding/LarusFragmentGalleryBinding;", "bottomSheetViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/BottomSheetViewModel;", "getBottomSheetViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/BottomSheetViewModel;", "bottomSheetViewModel$delegate", "Lkotlin/Lazy;", "mobViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/MediaMobViewModel;", "getMobViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/MediaMobViewModel;", "mobViewModel$delegate", "mediaGalleryViewModel", "Lcom/larus/photopicker/v2/impl/viewmodel/MediaGalleryLiveDataViewModel;", "getMediaGalleryViewModel", "()Lcom/larus/photopicker/v2/impl/viewmodel/MediaGalleryLiveDataViewModel;", "mediaGalleryViewModel$delegate", "injectInputCoordinator", "Lcom/larus/photopicker/v2/impl/injectinput/InjectInputCoordinator;", "nonUiSettings", "Lcom/larus/photopicker/v2/impl/model/MediaNonUISettings;", "lastDispatchedSelectedItems", "", "", "Lcom/larus/platform/model/album/AlbumSelectionEventItem;", "autoLogEnterPage", "", "getCurrentPageName", "fillTrackParams", "", "params", "Lcom/ixigua/lib/track/TrackParams;", "logEnterPage", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "observeSelectionChanges", "onDestroyView", "onStop", "onDestroy", "updateForceSinglePick", "forceSinglePick", "updateForceSinglePick$impl_mainlandRelease", "updateMaxSelectCount", "maxSelectCount", "", "updateMaxSelectCount$impl_mainlandRelease", "appendInputAttachments", "attachments", "", "Lcom/larus/platform/model/preview/AttachmentSnapshot;", "appendInputAttachments$impl_mainlandRelease", "updateDisplayType", "type", "updateDisplayType$impl_mainlandRelease", "isInjectInputAlbumShowing", "tryOpenUnifiedPreview", "toPreviewMediaItem", "Lcom/larus/chat/gallery/api/PreviewMediaItem;", "Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "buildAlbumPreviewItems", "coordinator", "checkPermission", "injectInputEnabled", "setBottomSheetHeight", "bottomMenuTotalHeight", "removeSelectedItemByUri", "uri", "Landroid/net/Uri;", "onRemoved", "Lkotlin/Function1;", "clearAllSelectedItems", "refreshMediaDataAndSelectNewItem", "uriList", "scrollToTop", "Companion", "AlbumGroupAccess", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaGalleryFragment extends TraceFragment implements op8.h {
    public static final /* synthetic */ int n = 0;
    public MediaGalleryUIConfig e;
    public LazyLoadConfig f;
    public LarusFragmentGalleryBinding g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public np9.g k;
    public MediaNonUISettings l;
    public Map<String, kq9.d> m;

    public final class a extends com.larus.chat.gallery.api.a {
        public final np9.g c;
        public final String d;
        public final Boolean e;
        public final String f;
        public final LinkedHashSet<Function1<List<AttachmentSnapshot>, Unit>> g;
        public final q0 h;
        public final /* synthetic */ MediaGalleryFragment i;

        /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.MediaGalleryFragment$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0003a {
            public static final /* synthetic */ int[] a = null;
            public static final /* synthetic */ int[] b = null;

            static {
                int[] r0 = new int[UnSelectableToastType.values().length];
                r0[UnSelectableToastType.IMAGE_LIMIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[UnSelectableToastType.DEFAULT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L6:
                a = r0;
                int[] r1 = new int[PreviewMediaType.values().length];
                r1[PreviewMediaType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
            L21:
                r1[PreviewMediaType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
            L9:
                b = r1;
            }
        }

        public final List<AttachmentSnapshot> Qa() {
            MediaGalleryFragment r0 = this.i;
            int r1 = MediaGalleryFragment.n;
            Set r2 = (Set) r0.Y90().getSelectionManager().g.getValue();
            if (r2 != null) goto L5;
            r2 = SetsKt.emptySet();
        L5:
            Set r3 = r2;
            ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
            Iterator r5 = r3.iterator();
        L7:
            if (r5.hasNext() == false) goto L9;
            r4.add(((op9.d) r5.next()).a.b.toString());
            goto L7
        L9:
            Set r6 = CollectionsKt.toSet(r4);
            List<com.larus.chat.gallery.api.o> r7 = d();
            ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator r9 = ((ArrayList) r7).iterator();
        L11:
            if (r9.hasNext() == false) goto L13;
            r8.add(((com.larus.chat.gallery.api.o) r9.next()).b);
            goto L11
        L13:
            Set r10 = CollectionsKt.toSet(r8);
            MediaGalleryFragment r11 = this.i;
            ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
            Iterator r13 = r3.iterator();
            int r14 = 0;
        L15:
            if (r13.hasNext() == false) goto L20;
            Object r15 = r13.next();
            int r16 = r14 + 1;
            if (r14 >= 0) goto L19;
            CollectionsKt.throwIndexOverflow();
        L19:
            r11.getClass();
            r12.add(com.larus.chat.gallery.api.p.a(MediaGalleryFragment.ba0((op9.d) r15), AttachmentSource.LOCAL_ALBUM, r14));
            r14 = r16;
            goto L15
        L20:
            np9.g r17 = this.c;
            if (r17 != null) goto L23;
        L25:
            boolean r18 = false;
        L26:
            if (r18 == false) goto L70;
            op8.b r19 = r17.f();
            if (r19 == null) goto L30;
            List r20 = r19.b;
        L31:
            if (r20 != null) goto L33;
            r20 = CollectionsKt.emptyList();
        L33:
            ArrayList r21 = new ArrayList();
            Iterator r22 = r20.iterator();
        L35:
            if (r22.hasNext() == false) goto L48;
            Object r23 = r22.next();
            AttachmentSnapshot r24 = (AttachmentSnapshot) r23;
            if (uy8.b.c() == false) goto L45;
            String r25 = com.larus.bmhome.chat.component.bottom.attachment.d1.c(r24);
            if (CollectionsKt.contains(r10, r25) == false) goto L45;
            if (CollectionsKt.contains(r6, r25) == true) goto L45;
            boolean r26 = false;
        L46:
            if (r26 == false) goto L35;
            r21.add(r23);
        L45:
            r26 = true;
            goto L46
        L48:
            ArrayList r27 = new ArrayList();
            LinkedHashSet r28 = new LinkedHashSet();
            LinkedHashSet r29 = new LinkedHashSet();
            Iterator r30 = r21.iterator();
        L50:
            if (r30.hasNext() == false) goto L52;
            y(r28, r29, r27, (AttachmentSnapshot) r30.next());
            goto L50
        L52:
            Iterator r31 = r12.iterator();
        L54:
            if (r31.hasNext() == false) goto L57;
            y(r28, r29, r27, (AttachmentSnapshot) r31.next());
            goto L54
        L57:
            return r27;
        L30:
            r20 = null;
            goto L31
        L70:
            return r12;
        L23:
            if (r17.c() != true) goto L25;
            r18 = true;
            goto L26
        }

        public final String a() {
            np9.g r0 = this.c;
            if (r0 == null) goto L7;
            op8.b r1 = r0.f();
            if (r1 == null) goto L7;
            String r2 = r1.a;
        L8:
            if (r2 != null) goto L11;
            return "";
        L11:
            return r2;
        L7:
            r2 = null;
            goto L8
        }

        public final List<com.larus.chat.gallery.api.o> d() {
            MediaGalleryFragment r0 = this.i;
            np9.g r1 = this.c;
            int r2 = MediaGalleryFragment.n;
            return r0.V90(r1);
        }

        public final boolean g() {
            MediaGalleryFragment r0 = this.i;
            int r1 = MediaGalleryFragment.n;
            if (r0.Y90().isInjectInputMode() == false) goto L13;
            np9.g r2 = this.c;
            if (r2 != null) goto L7;
        L9:
            boolean r3 = false;
        L10:
            if (r3 == false) goto L14;
            return true;
        L14:
            return false;
        L7:
            if (r2.c() != true) goto L9;
            r3 = true;
            goto L10
        L13:
            return false;
        }

        public final void u() {
            np9.g r0 = this.c;
            if (r0 == null) goto L8;
            q0 r1 = this.h;
            Intrinsics.checkNotNullParameter(r1, "listener");
            op8.d r2 = r0.a();
            if (r2 == null) goto L8;
            r2.dJ(r1);
        L8:
            if (this.i.isAdded() == true) goto L10;
            return;
        L10:
            if (this.i.getView() == null) goto L16;
            MediaGalleryFragment r3 = this.i;
            int r4 = MediaGalleryFragment.n;
            if (Intrinsics.areEqual(r3.Y90().getShowPreviewFragment().getValue(), Boolean.TRUE) == false) goto L17;
            this.i.Y90().getShowPreviewFragment().setValue(Boolean.FALSE);
            return;
        L17:
            return;
        }

        public final boolean A() {
            if (uy8.b.c() == false) goto L13;
            np9.g r0 = this.c;
            if (r0 != null) goto L7;
        L9:
            boolean r1 = false;
        L10:
            if (r1 == false) goto L14;
            return true;
        L14:
            return false;
        L7:
            if (r0.c() != true) goto L9;
            r1 = true;
            goto L10
        L13:
            return false;
        }

        public final com.larus.chat.gallery.api.l getCapability() {
            boolean r6 = g();
            np9.g r0 = this.c;
            if (r0 == null) goto L7;
            boolean r3 = true;
            if (r0.c() != true) goto L7;
        L9:
            return new com.larus.chat.gallery.api.l(r6, true, r3, false, r6, r6, false);
        L7:
            r3 = false;
            goto L9
        }

        public final String k() {
            return this.f;
        }

        public final Boolean n() {
            return this.e;
        }

        public final String o() {
            return this.d;
        }

        public final boolean Oa(String r4) {
            Intrinsics.checkNotNullParameter(r4, "itemKey");
            Long r5 = StringsKt.toLongOrNull(r4);
            if (r5 == null) goto L6;
            long r0 = r5.longValue();
            MediaGalleryFragment r6 = this.i;
            int r2 = MediaGalleryFragment.n;
            return r6.Y90().getSelectionManager().g(r0);
        L6:
            return false;
        }

        public final void b(Function1<? super List<AttachmentSnapshot>, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.g.remove(r2);
        }

        public final PreviewSelectionLimit e(String r9) {
            Intrinsics.checkNotNullParameter(r9, "itemKey");
            Long r10 = StringsKt.toLongOrNull(r9);
            if (r10 == null) goto L35;
            long r1 = r10.longValue();
            MediaGalleryFragment r11 = this.i;
            int r3 = MediaGalleryFragment.n;
            List r12 = (List) r11.Y90().getCurrentPreviewItems().getValue();
            if (r12 != null) goto L7;
            r12 = CollectionsKt.emptyList();
        L7:
            Iterator r13 = r12.iterator();
        L9:
            if (r13.hasNext() == false) goto L16;
            Object r4 = r13.next();
            if (((op9.d) r4).a.a != r1) goto L13;
            boolean r5 = true;
        L14:
            if (r5 == false) goto L9;
        L17:
            op9.d r6 = (op9.d) r4;
            if (r6 != null) goto L20;
            return null;
        L20:
            com.larus.photopicker.v2.impl.viewmodel.e r14 = this.i.Y90().getSelectionManager().j(r6);
            if (r14 != null) goto L23;
            return null;
        L23:
            int r2 = r14.b;
            int r15 = C0003a.a[r14.getType().ordinal()];
            if (r15 != 1) goto L26;
            PreviewSelectionLimit.MediaScope r16 = PreviewSelectionLimit.MediaScope.IMAGE_ONLY;
        L34:
            return new PreviewSelectionLimit(r2, r16);
        L26:
            if (r15 == 2) goto L29;
            return null;
        L29:
            if (this.i.e.g == false) goto L31;
            r16 = PreviewSelectionLimit.MediaScope.IMAGE_AND_VIDEO;
            goto L34
        L31:
            r16 = PreviewSelectionLimit.MediaScope.IMAGE_ONLY;
            goto L34
        L13:
            r5 = false;
            goto L14
        L16:
            r4 = null;
            goto L17
        L35:
            return null;
        }

        public final void f(Function1<? super List<AttachmentSnapshot>, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.g.add(r2);
            r2.invoke(Qa());
        }

        public final com.larus.chat.gallery.api.v m(com.larus.chat.gallery.api.w r17) {
            Intrinsics.checkNotNullParameter(r17, "snapshot");
            if (g() == true) goto L6;
            e0.c("MediaGalleryFragment", "AlbumPreviewMediaSession send skipped: input bridge unavailable");
            int r0 = com.larus.chat.gallery.api.v.d;
            return com.larus.chat.gallery.api.v.a.a(PreviewSendFailureReason.HOST_UNAVAILABLE);
        L6:
            List<AttachmentSnapshot> r2 = Qa();
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
            Iterator<T> r3 = r2.iterator();
        L8:
            if (r3.hasNext() == false) goto L10;
            r5.add(((AttachmentSnapshot) r3.next()).getStableId());
            goto L8
        L10:
            List r4 = r17.a;
            ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
            Iterator r6 = r4.iterator();
        L12:
            if (r6.hasNext() == false) goto L15;
            r7.add(((AttachmentSnapshot) r6.next()).getStableId());
            goto L12
        L15:
            if (Intrinsics.areEqual(r5, r7) == true) goto L18;
            int r1 = com.larus.chat.gallery.api.v.d;
            return com.larus.chat.gallery.api.v.a.a(PreviewSendFailureReason.NOT_SENDABLE);
        L18:
            np9.g r8 = this.c;
            if (r8 == null) goto L28;
            op8.b r15 = new op8.b(r17.b, r17.a, r17.c, r17.d, r17.e, r17.f, r17.g);
            Intrinsics.checkNotNullParameter(r15, "snapshot");
            op8.d r9 = r8.a();
            if (r9 != null) goto L23;
        L25:
            boolean r10 = false;
        L26:
            if (r10 != true) goto L28;
            boolean r11 = true;
        L29:
            if (r11 == true) goto L33;
            e0.c("MediaGalleryFragment", "AlbumPreviewMediaSession send skipped: input bridge unavailable");
            int r12 = com.larus.chat.gallery.api.v.d;
            return com.larus.chat.gallery.api.v.a.a(PreviewSendFailureReason.HOST_UNAVAILABLE);
        L33:
            return new com.larus.chat.gallery.api.v(true, null, 6);
        L23:
            if (r9.nU(r15) != true) goto L25;
            r10 = true;
        L28:
            r11 = false;
            goto L29
        }

        public final boolean q(r r29) {
            Intrinsics.checkNotNullParameter(r29, "mutation");
            boolean r3 = true;
            if ((r29 instanceof r.a) == false) goto L18;
            r.a r1 = (r.a) r29;
            if ((!r1.a.isEmpty()) == false) goto L14;
            np9.g r2 = this.c;
            if (r2 != null) goto L9;
        L11:
            boolean r4 = false;
        L12:
            if (r4 == false) goto L14;
        L15:
            if (r3 == false) goto L90;
            z("owner_append");
            return r3;
        L90:
            return r3;
        L9:
            if (r2.b(new op8.a.a(r1.a)) != true) goto L11;
            r4 = true;
        L14:
            r3 = false;
            goto L15
        L18:
            if ((r29 instanceof r.b) == false) goto L81;
            r.b r5 = (r.b) r29;
            boolean r6 = Oa(r5.a);
            Object r7 = null;
            String r8 = null;
            if (A() == true) goto L47;
            if (r6 == true) goto L27;
            com.larus.chat.gallery.api.a0 r9 = Pa(r5.a, true);
            if (r9.a == true) goto L25;
        L26:
            return false;
        L25:
            if (r9.b == false) goto L26;
        L27:
            String r10 = r5.a;
            AttachmentSnapshot r11 = r5.b;
            Intrinsics.checkNotNullParameter(r10, "originStableId");
            Intrinsics.checkNotNullParameter(r11, "edited");
            Iterator r12 = ((ArrayList) d()).iterator();
        L29:
            if (r12.hasNext() == false) goto L33;
            Object r13 = r12.next();
            if (Intrinsics.areEqual(((com.larus.chat.gallery.api.o) r13).a, r10) == false) goto L29;
        L34:
            com.larus.chat.gallery.api.o r14 = (com.larus.chat.gallery.api.o) r13;
            if (r14 == null) goto L37;
            r8 = r14.b;
        L37:
            np9.g r15 = this.c;
            if (r15 != null) goto L40;
        L42:
            boolean r16 = false;
        L43:
            if (r16 == true) goto L46;
            if (r6 == true) goto L46;
            Pa(r5.a, false);
        L46:
            return r16;
        L40:
            if (r15.b(new op8.a.d(r10, r8, AttachmentSnapshot.copy$default(r11, r10, null, null, null, null, null, null, null, null, null, null, 0, null, null, 0, null, null, 131070, null))) != true) goto L42;
            r16 = true;
            goto L43
        L33:
            r13 = null;
            goto L34
        L47:
            Long r17 = StringsKt.toLongOrNull(r5.a);
            if (r17 == null) goto L78;
            long r18 = r17.longValue();
            MediaGalleryFragment r19 = this.i;
            int r20 = MediaGalleryFragment.n;
            List r21 = (List) r19.Y90().getCurrentPreviewItems().getValue();
            if (r21 != null) goto L52;
            r21 = CollectionsKt.emptyList();
        L52:
            Iterator r22 = r21.iterator();
        L54:
            if (r22.hasNext() == false) goto L61;
            Object r23 = r22.next();
            if (((op9.d) r23).a.a != r18) goto L58;
            boolean r24 = true;
        L59:
            if (r24 == false) goto L54;
            r7 = r23;
            goto L61
        L58:
            r24 = false;
        L61:
            op9.d r25 = (op9.d) r7;
            if (r25 != null) goto L64;
            return false;
        L64:
            if (r6 == true) goto L69;
            if (w(r5.a) == true) goto L69;
            return false;
        L69:
            if (x(r5.a, r25, r5.b) == true) goto L71;
            return false;
        L71:
            if (r6 == true) goto L76;
            if (this.i.Y90().setSelectionImmediately(r25, true) == true) goto L76;
            return false;
        L76:
            return true;
        L78:
            return false;
        L81:
            throw new NoWhenBranchMatchedException();
        }

        public final PreviewSelectionLimit r(PreviewMediaType r8) {
            Intrinsics.checkNotNullParameter(r8, "mediaType");
            MediaGalleryFragment r0 = this.i;
            int r1 = MediaGalleryFragment.n;
            com.larus.photopicker.v2.impl.viewmodel.d r2 = r0.Y90().getSelectionManager();
            int r9 = C0003a.b[r8.ordinal()];
            if (r9 == 1) goto L8;
            if (r9 != 2) goto L7;
            MediaType r10 = MediaType.VIDEO;
        L9:
            r2.getClass();
            Intrinsics.checkNotNullParameter(r10, "type");
            Set<op9.d> r3 = (Set) r2.f.getValue();
            if (r3 != null) goto L13;
        L30:
            com.larus.photopicker.v2.impl.viewmodel.e r11 = null;
        L31:
            if (r11 != null) goto L33;
            return null;
        L33:
            int r4 = r11.b;
            int r12 = C0003a.a[r11.getType().ordinal()];
            if (r12 == 1) goto L41;
            if (r12 == 2) goto L38;
            return null;
        L38:
            if (this.i.e.g == false) goto L40;
            PreviewSelectionLimit.MediaScope r13 = PreviewSelectionLimit.MediaScope.IMAGE_AND_VIDEO;
        L43:
            return new PreviewSelectionLimit(r4, r13);
        L40:
            r13 = PreviewSelectionLimit.MediaScope.IMAGE_ONLY;
            goto L43
        L41:
            r13 = PreviewSelectionLimit.MediaScope.IMAGE_ONLY;
            goto L43
        L13:
            if (r2.m != null) goto L30;
            if (r2.l == false) goto L20;
            if (r2.a == 1) goto L30;
        L20:
            if (r2.c == true) goto L22;
        L24:
            r11 = new com.larus.photopicker.v2.impl.viewmodel.e(UnSelectableToastType.DEFAULT, r2.a);
            if (r3.size() < r2.i()) goto L27;
            boolean r5 = true;
        L28:
            if (r5 == false) goto L30;
        L27:
            r5 = false;
            goto L28
        L22:
            if (r2.b == false) goto L24;
            r11 = r2.h(r10, r3);
            goto L31
        L7:
            throw new NoWhenBranchMatchedException();
        L8:
            r10 = MediaType.IMAGE;
            goto L9
        }

        public final boolean s(String r4) {
            Intrinsics.checkNotNullParameter(r4, "text");
            np9.g r0 = this.c;
            if (r0 != null) goto L5;
            return false;
        L5:
            if (r0.b(new op8.a.e(r4)) != true) goto L9;
            return true;
        L9:
            return false;
        }

        public final boolean w(String r8) {
            Intrinsics.checkNotNullParameter(r8, "itemKey");
            Long r9 = StringsKt.toLongOrNull(r8);
            if (r9 == null) goto L22;
            long r1 = r9.longValue();
            MediaGalleryFragment r10 = this.i;
            int r3 = MediaGalleryFragment.n;
            List r11 = (List) r10.Y90().getCurrentPreviewItems().getValue();
            if (r11 != null) goto L7;
            r11 = CollectionsKt.emptyList();
        L7:
            Iterator r12 = r11.iterator();
        L9:
            if (r12.hasNext() == false) goto L16;
            Object r4 = r12.next();
            if (((op9.d) r4).a.a != r1) goto L13;
            boolean r5 = true;
        L14:
            if (r5 == false) goto L9;
        L17:
            op9.d r6 = (op9.d) r4;
            if (r6 != null) goto L21;
            return false;
        L21:
            return this.i.Y90().getSelectionManager().a(r6);
        L13:
            r5 = false;
            goto L14
        L16:
            r4 = null;
            goto L17
        L22:
            return false;
        }

        public final void z(String r12) {
            List<AttachmentSnapshot> r9 = Qa();
            int r0 = e0.a;
            e0.d("MediaGalleryFragment", "album_selected_strip owner: reason=" + r12 + ", emittedCount=" + r9.size() + ", emittedKeys=" + CollectionsKt.joinToString$default(r9, null, null, null, 0, null, new s0(), 31, null));
            Iterator r13 = CollectionsKt.toList(this.g).iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            ((Function1) r13.next()).invoke(r9);
            goto L4
        }

        /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.photopicker.v2.impl.q0, java.lang.Object, kotlin.jvm.functions.Function1] */
        public a(MediaGalleryFragment r5, np9.g r6) {
            this.i = r5;
            this.c = r6;
            String r0 = r5.e.w;
            if ((!StringsKt.isBlank(r0)) == true) goto L6;
            r0 = null;
        L6:
            this.d = r0;
            MediaGalleryUIConfig r1 = r5.e;
            this.e = r1.z;
            kq9.b.c(r1.x);
            if (r0 != null) goto L9;
            r0 = ((com.larus.chat.gallery.api.a) this).a;
        L9:
            this.f = r0;
            this.g = new LinkedHashSet();
            ?? r2 = new q0(this);
            this.h = r2;
            r5.Y90().getSelectionManager().g.observe(r5.getViewLifecycleOwner(), new d(new r0(this)));
            if (r6 == null) goto L15;
            Intrinsics.checkNotNullParameter(r2, "listener");
            op8.d r7 = r6.a();
            if (r7 == null) goto L16;
            r7.zN(r2);
            return;
        L16:
            return;
        }

        public final com.larus.chat.gallery.api.a0 Pa(String r28, boolean r29) {
            Intrinsics.checkNotNullParameter(r28, "itemKey");
            Long r1 = StringsKt.toLongOrNull(r28);
            if (r1 == null) goto L88;
            long r13 = r1.longValue();
            MediaGalleryFragment r2 = this.i;
            int r4 = MediaGalleryFragment.n;
            boolean r12 = r2.Y90().getSelectionManager().g(r13);
            List r3 = (List) this.i.Y90().getCurrentPreviewItems().getValue();
            if (r3 != null) goto L7;
            r3 = CollectionsKt.emptyList();
        L7:
            Iterator r5 = r3.iterator();
        L9:
            if (r5.hasNext() == false) goto L16;
            Object r6 = r5.next();
            if (((op9.d) r6).a.a != r13) goto L13;
            boolean r7 = true;
        L14:
            if (r7 == false) goto L9;
        L17:
            op9.d r9 = (op9.d) r6;
            if (r9 != null) goto L21;
            int r8 = com.larus.chat.gallery.api.a0.d;
            return com.larus.chat.gallery.api.a0.a.a(r12, SelectResultReason.ITEM_NOT_FOUND);
        L21:
            if (r12 != r29) goto L31;
            if (r29 == true) goto L30;
            if (A() == false) goto L30;
            if (x(r28, r9, null) == true) goto L30;
            int r10 = com.larus.chat.gallery.api.a0.d;
            return com.larus.chat.gallery.api.a0.a.a(false, SelectResultReason.REJECTED);
        L30:
            return new com.larus.chat.gallery.api.a0(true, r29, SelectResultReason.OK);
        L31:
            if (r29 == true) goto L33;
        L36:
            if (r29 == false) goto L38;
        L63:
            String r11 = r28;
            op9.d r14 = r9;
            AttachmentSnapshot r23 = null;
            boolean r24 = r12;
            long r25 = r13;
        L65:
            if (A() == false) goto L77;
            this.i.getClass();
            com.larus.chat.gallery.api.o r15 = MediaGalleryFragment.ba0(r14);
            AttachmentSource r16 = AttachmentSource.LOCAL_ALBUM;
            Set r17 = (Set) this.i.Y90().getSelectionManager().g.getValue();
            if (r17 != null) goto L69;
            r17 = SetsKt.emptySet();
        L69:
            AttachmentSnapshot r18 = com.larus.chat.gallery.api.p.a(r15, r16, r17.size());
            boolean r19 = r29;
            if (r19 == true) goto L74;
            r18 = r23;
        L74:
            if (x(r11, r14, r18) == true) goto L78;
            int r20 = com.larus.chat.gallery.api.a0.d;
            return com.larus.chat.gallery.api.a0.a.a(r24, SelectResultReason.REJECTED);
        L78:
            boolean r21 = this.i.Y90().setSelectionImmediately(r14, r19);
            boolean r22 = this.i.Y90().getSelectionManager().g(r25);
            if (r21 == false) goto L82;
            if (r22 != r19) goto L82;
            return new com.larus.chat.gallery.api.a0(true, r19, SelectResultReason.OK);
        L82:
            int r26 = com.larus.chat.gallery.api.a0.d;
            if (r19 == false) goto L85;
            SelectResultReason r27 = SelectResultReason.LIMIT_REACHED;
        L87:
            return com.larus.chat.gallery.api.a0.a.a(r22, r27);
        L85:
            r27 = SelectResultReason.NOT_SUPPORTED;
            goto L87
        L77:
            r19 = r29;
            goto L78
        L38:
            if (A() == true) goto L63;
            np9.g r30 = this.c;
            if (r30 == null) goto L63;
            op8.b r31 = r30.f();
            if (r31 == null) goto L63;
            List r32 = r31.b;
            if (r32 == null) goto L63;
            Iterator r33 = r32.iterator();
        L47:
            if (r33.hasNext() == false) goto L56;
            Object r34 = r33.next();
            AttachmentSnapshot r35 = (AttachmentSnapshot) r34;
            if (Intrinsics.areEqual(r35.getStableId(), r28) == true) goto L51;
        L53:
            boolean r36 = false;
        L54:
            if (r36 == false) goto L47;
        L57:
            AttachmentSnapshot r37 = (AttachmentSnapshot) r34;
            if (r37 == null) goto L63;
            MediaGalleryFragment r38 = this.i;
            int r39 = MediaGalleryFragment.n;
            r38.getClass();
            r23 = null;
            r24 = r12;
            r25 = r13;
            AttachmentSnapshot r40 = AttachmentSnapshot.copy$default(com.larus.chat.gallery.api.p.a(MediaGalleryFragment.ba0(r9), AttachmentSource.LOCAL_ALBUM, r37.getSelectedOrder()), r28, null, null, null, null, null, null, null, null, null, null, 0, null, null, 0, null, null, 122878, null);
            np9.g r41 = this.c;
            if (r41 == null) goto L62;
            r14 = r9;
            r11 = r28;
            r41.b(new op8.a.d(r11, r14.a.b.toString(), r40));
            goto L65
        L62:
            r11 = r28;
            r14 = r9;
            goto L65
        L51:
            if (r35.getEditState() == null) goto L53;
            r36 = true;
            goto L54
        L56:
            r34 = null;
            goto L57
        L33:
            if (w(r28) == true) goto L36;
            int r42 = com.larus.chat.gallery.api.a0.d;
            return com.larus.chat.gallery.api.a0.a.a(false, SelectResultReason.LIMIT_REACHED);
        L13:
            r7 = false;
            goto L14
        L16:
            r6 = null;
            goto L17
        L88:
            int r43 = com.larus.chat.gallery.api.a0.d;
            return com.larus.chat.gallery.api.a0.a.a(false, SelectResultReason.ITEM_NOT_FOUND);
        }

        public final boolean x(String r6, op9.d r7, AttachmentSnapshot r8) {
            np9.g r0 = this.c;
            boolean r1 = false;
            if (r0 != null) goto L5;
        L7:
            boolean r9 = false;
        L8:
            if (r9 == false) goto L19;
            np9.g r2 = this.c;
            if (r2 == null) goto L19;
            Uri r10 = r7.a.b;
            if (r8 == null) goto L14;
            r1 = true;
        L14:
            Intrinsics.checkNotNullParameter(r10, "uri");
            if (r1 == false) goto L17;
            Set<? extends Uri> r11 = SetsKt.plus(r2.j, r10);
        L18:
            r2.j = r11;
            r2.l = null;
            goto L19
        L17:
            r11 = SetsKt.minus(r2.j, r10);
        L19:
            return r9;
        L5:
            if (r0.b(new op8.a.b(r6, r7.a.b.toString(), r8)) != true) goto L7;
            r9 = true;
            goto L8
        }

        public static final void y(Set<String> r27, Set<String> r28, List<AttachmentSnapshot> r29, AttachmentSnapshot r30) {
            String r3 = null;
            if (uy8.b.c() == false) goto L5;
            String r2 = com.larus.bmhome.chat.component.bottom.attachment.d1.c(r30);
        L10:
            if (r27.contains(r30.getStableId()) == false) goto L12;
            return;
        L12:
            if (r2 != null) goto L14;
        L17:
            boolean r5 = true;
        L18:
            if (r5 == false) goto L20;
        L22:
            ArrayList r6 = (ArrayList) r29;
            r6.add(AttachmentSnapshot.copy$default(r30, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, r6.size(), null, null, 114687, null));
            r27.add(r30.getStableId());
            if (r2 != null) goto L25;
            return;
        L25:
            if ((!StringsKt.isBlank(r2)) == false) goto L27;
            r3 = r2;
        L27:
            if (r3 == null) goto L32;
            r28.add(r3);
            return;
        L32:
            return;
        L20:
            if (r28.contains(r2) == false) goto L22;
            return;
        L14:
            if (StringsKt.isBlank(r2) == true) goto L17;
            r5 = false;
            goto L18
        L5:
            ResourceRef r4 = r30.effectiveRef();
            if (r4 == null) goto L8;
            r2 = r4.getUri();
            goto L10
        L8:
            r2 = null;
            goto L10
        }
    }

    public static final class b {
        public static MediaGalleryFragment a(MediaGalleryUIConfig r3, LazyLoadConfig r4, MediaNonUISettings r5) {
            Intrinsics.checkNotNullParameter(r3, "uiConfig");
            Intrinsics.checkNotNullParameter(r4, "lazyLoadConfig");
            Intrinsics.checkNotNullParameter(r5, "nonUiSettings");
            MediaGalleryFragment r0 = new MediaGalleryFragment();
            Bundle r1 = new Bundle();
            r1.putParcelable("ui_config", r3);
            r1.putParcelable("lazy_load_config", r4);
            r1.putParcelable("non_ui_settings", r5);
            r0.setArguments(r1);
            return r0;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[UnSelectableToastType.values().length];
            r0[UnSelectableToastType.VIDEO_LIMIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[UnSelectableToastType.IMAGE_LIMIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L29:
            r0[UnSelectableToastType.DEFAULT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L23:
            r0[UnSelectableToastType.VIDEO_DURATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L8:
            a = r0;
            int[] r1 = new int[MediaType.values().length];
            r1[MediaType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L25:
            r1[MediaType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L11:
            b = r1;
        }
    }

    public static final class d implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public d(Function1 r2) {
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

    public static final class e implements Function0<BottomSheetViewModel> {
        public final /* synthetic */ Fragment a;
        public final /* synthetic */ Class b;

        public e(Fragment r1, Class r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object invoke() {
            int r0 = e0.a;
            Fragment r1 = e0.a(this.a, this.b);
            if (r1 != null) goto L5;
            return null;
        L5:
            Fragment r2 = this.a;
            final t0 r3 = new t0(r1);
            u0 r4 = new u0(r2);
            return (ViewModel) FragmentViewModelLazyKt.createViewModelLazy(r2, Reflection.getOrCreateKotlinClass(BottomSheetViewModel.class), new MediaGalleryFragment$special$$inlined$findViewModel$1$3(r3), r4).getValue();
        }
    }

    static {
    }

    public final String k() {
        return "album";
    }

    public final boolean S0() {
        np9.g r0 = this.k;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.S0() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean S90() {
        if (this.e.e != MediaPickerUIMode.NORMAL) goto L5;
        return true;
    L5:
        return false;
    }

    public final void T90() {
        if (AppHost.a.isTestChannel() == true) goto L5;
    L7:
        kq9.e r0 = lp9.d.a;
        if (r0 == null) goto L10;
        String r1 = r0.f;
    L12:
        if (com.larus.utils.o0.d("album") == true) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r1, "camera_slide_album_click") == false) goto L16;
        return;
    L16:
        if (Intrinsics.areEqual(r1, "chat_album_preview_click") == true) goto L35;
        kq9.e r2 = lp9.d.a;
        if (r2 == null) goto L20;
        String r23 = r2.e;
    L21:
        String r15 = Z90().getActualEnterMethod();
        String r57 = Z90().getActualClickFrom();
        kq9.e r3 = lp9.d.a;
        if (r3 == null) goto L24;
        String r7 = r3.a;
    L25:
        if (r3 == null) goto L27;
        String r10 = r3.d;
    L28:
        if (r3 == null) goto L30;
        String r45 = r3.i;
    L31:
        tx9.a1.c(r7, null, null, r10, null, null, null, null, r15, null, null, null, null, null, null, "album", r23, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r45, null, null, null, null, null, this, null, null, null, null, null, r57, null, -1573923, -17039361, 5);
        return;
    L30:
        r45 = null;
        goto L31
    L27:
        r10 = null;
        goto L28
    L24:
        r7 = null;
        goto L25
    L20:
        r23 = null;
        goto L21
    L35:
        return;
    L10:
        r1 = null;
        goto L12
    L5:
        if ((getActivity() instanceof PhotoPickerActivityV2) == false) goto L7;
        t19.s.j(t19.s.a, getContext(), "current use New Album", null, false, 28);
        goto L7
    }

    public final BottomSheetViewModel X90() {
        return (BottomSheetViewModel) this.h.getValue();
    }

    public final MediaGalleryLiveDataViewModel Y90() {
        return (MediaGalleryLiveDataViewModel) this.j.getValue();
    }

    public final MediaMobViewModel Z90() {
        return (MediaMobViewModel) this.i.getValue();
    }

    public final void onDestroy() {
        Map<String, Integer> r0 = kq9.b.a;
        kq9.b.b(this.e.w);
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        ((LinkedHashMap) ((gx8.a) pp9.i.a()).a.b).clear();
    }

    public final void onDestroyView() {
        e0.d("MediaGalleryFragment", "onDestroyView");
        np9.g r0 = this.k;
        if (r0 == null) goto L8;
        op8.k r3 = s1a.a.g(r0.a).a(op8.k.class);
        if (r3 == null) goto L7;
        r3.c = false;
    L7:
        e0.d(r0.g, "onDestroyView");
        r0.h();
        r0.i = null;
        r0.j = SetsKt.emptySet();
        r0.k = false;
        r0.l = null;
        r0.m = false;
        r0.n = false;
        r0.o = false;
    L8:
        this.k = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public MediaGalleryFragment() {
        Parcelable.Creator<MediaGalleryUIConfig> r0 = MediaGalleryUIConfig.CREATOR;
        this.e = MediaGalleryUIConfig.G.a();
        Parcelable.Creator<LazyLoadConfig> r1 = LazyLoadConfig.CREATOR;
        this.f = LazyLoadConfig.e;
        int r2 = e0.a;
        this.h = LazyKt.lazy(new e(this, c0.class));
        d0 r3 = new d0(this, c0.class);
        this.i = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaMobViewModel.class), new Injection$provideViewModel$$inlined$viewModels$default$1(r3), new Injection$provideViewModel$$inlined$viewModels$default$2(r3, this));
        final Function0<Fragment> r4 = new MediaGalleryFragment$special$$inlined$viewModels$default$1(this);
        this.j = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaGalleryLiveDataViewModel.class), new MediaGalleryFragment$special$$inlined$viewModels$default$2(r4), new MediaGalleryFragment$special$$inlined$viewModels$default$3(r4, this));
        Parcelable.Creator<MediaNonUISettings> r5 = MediaNonUISettings.CREATOR;
        this.l = MediaNonUISettings.f;
        this.m = MapsKt.emptyMap();
    }

    public final void onStop() {
        super/*androidx.fragment.app.Fragment*/.onStop();
        if (Y90().isInjectInputMode() == true) goto L5;
        return;
    L5:
        if (uy8.b.c() == false) goto L13;
        np9.g r0 = this.k;
        if (r0 == null) goto L14;
        op8.g r1 = r0.i;
        if (r1 == null) goto L15;
        r1.c3();
        return;
    L15:
        return;
    L14:
        return;
    }

    public static com.larus.chat.gallery.api.o ba0(op9.d r11) {
        String r1 = String.valueOf(r11.a.a);
        String r2 = r11.a.b.toString();
        if (r11.a.getType() != MediaType.VIDEO) goto L5;
        PreviewMediaType r0 = PreviewMediaType.VIDEO;
    L6:
        mp9.c r12 = r11.a;
        return new com.larus.chat.gallery.api.o(r1, r2, r0, null, r12.j, r12.k, r12.i, 8);
    L5:
        r0 = PreviewMediaType.IMAGE;
        goto L6
    }

    public final boolean U90(List<AttachmentSnapshot> r31) {
        Intrinsics.checkNotNullParameter(r31, "attachments");
        if (((ArrayList) r31).isEmpty() == false) goto L5;
        return true;
    L5:
        np9.g r3 = this.k;
        int r4 = 0;
        if (r3 != null) goto L8;
        return false;
    L8:
        op8.b r5 = r3.f();
        if (r5 == null) goto L63;
        List r6 = r5.b;
        if (r6 == null) goto L63;
        List r7 = r6;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L14:
        if (r9.hasNext() == false) goto L16;
        r8.add(((AttachmentSnapshot) r9.next()).getStableId());
        goto L14
    L16:
        Set r10 = CollectionsKt.toSet(r8);
        ArrayList r11 = new ArrayList();
        Iterator r12 = r7.iterator();
    L17:
        String r13 = null;
        if (r12.hasNext() == false) goto L27;
        AttachmentSnapshot r14 = (AttachmentSnapshot) r12.next();
        String r15 = com.larus.bmhome.chat.component.bottom.attachment.d1.c(r14);
        if (r15 != null) goto L24;
        ResourceRef r16 = r14.effectiveRef();
        if (r16 == null) goto L25;
        r13 = r16.getUri();
    L25:
        if (r13 == null) goto L17;
        r11.add(r13);
        goto L17
    L24:
        r13 = r15;
        goto L25
    L27:
        Set r17 = CollectionsKt.toSet(r11);
        ArrayList r18 = new ArrayList();
        Iterator<T> r0 = r31.iterator();
    L29:
        if (r0.hasNext() == false) goto L51;
        Object r19 = r0.next();
        AttachmentSnapshot r110 = (AttachmentSnapshot) r19;
        String r111 = com.larus.bmhome.chat.component.bottom.attachment.d1.c(r110);
        if (r111 != null) goto L37;
        ResourceRef r112 = r110.effectiveRef();
        if (r112 == null) goto L35;
        r111 = r112.getUri();
        goto L37
    L35:
        r111 = null;
    L37:
        if (r10.contains(r110.getStableId()) == true) goto L48;
        if (r111 != null) goto L40;
    L43:
        boolean r113 = true;
    L44:
        if (r113 == false) goto L46;
    L47:
        boolean r114 = true;
    L49:
        if (r114 == false) goto L29;
        r18.add(r19);
        goto L29
    L46:
        if (r17.contains(r111) == true) goto L48;
    L40:
        if (StringsKt.isBlank(r111) == true) goto L43;
        r113 = false;
    L48:
        r114 = false;
        goto L49
    L51:
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator r20 = r18.iterator();
    L53:
        if (r20.hasNext() == false) goto L59;
        Object r21 = r20.next();
        int r22 = r4 + 1;
        if (r4 >= 0) goto L57;
        CollectionsKt.throwIndexOverflow();
    L57:
        r1.add(AttachmentSnapshot.copy$default((AttachmentSnapshot) r21, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, r6.size() + r4, null, null, 114687, null));
        r4 = r22;
        goto L53
    L59:
        if (r1.isEmpty() == false) goto L62;
        return true;
    L62:
        return r3.b(new op8.a.a(r1));
    L63:
        return false;
    }

    public final List<com.larus.chat.gallery.api.o> V90(np9.g r15) {
        List r0 = (List) Y90().getCurrentPreviewItems().getValue();
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        List r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L10;
        r2.add(ba0((op9.d) r3.next()));
        goto L7
    L10:
        if (uy8.b.c() == true) goto L13;
        return r2;
    L13:
        if (r15 == null) goto L17;
        op8.b r16 = r15.f();
        if (r16 == null) goto L17;
        List r17 = r16.b;
    L18:
        if (r17 != null) goto L20;
        r17 = CollectionsKt.emptyList();
    L20:
        ArrayList r4 = new ArrayList();
        Iterator r18 = r17.iterator();
    L21:
        boolean r5 = false;
        if (r18.hasNext() == false) goto L28;
        Object r6 = r18.next();
        if (((AttachmentSnapshot) r6).getEditState() == null) goto L26;
        r5 = true;
    L26:
        if (r5 == false) goto L21;
        r4.add(r6);
        goto L21
    L28:
        ArrayList r19 = new ArrayList();
        Iterator r7 = r4.iterator();
    L30:
        if (r7.hasNext() == false) goto L37;
        AttachmentSnapshot r8 = (AttachmentSnapshot) r7.next();
        String r9 = com.larus.bmhome.chat.component.bottom.attachment.d1.c(r8);
        if (r9 != null) goto L34;
        Pair r10 = null;
    L35:
        if (r10 == null) goto L30;
        r19.add(r10);
        goto L30
    L34:
        r10 = TuplesKt.to(r9, r8);
        goto L35
    L37:
        Map r110 = MapsKt.toMap(r19);
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r12 = r2.iterator();
    L39:
        if (r12.hasNext() == false) goto L73;
        com.larus.chat.gallery.api.o r13 = (com.larus.chat.gallery.api.o) r12.next();
        AttachmentSnapshot r14 = (AttachmentSnapshot) r110.get(r13.b);
        if (r14 == null) goto L72;
        ResourceRef r20 = r14.effectiveRef();
        if (r20 == null) goto L72;
        String r21 = r20.getUri();
        ResourceRef r22 = r14.getThumbRef();
        if (r22 == null) goto L50;
        String r23 = r22.getUri();
        if (r23 == null) goto L50;
    L51:
        String r111 = r23;
        Integer r24 = Integer.valueOf(r20.getWidth());
        if (r24.intValue() <= 0) goto L54;
        boolean r112 = true;
    L55:
        if (r112 == true) goto L58;
        r24 = null;
    L58:
        if (r24 == null) goto L60;
        int r25 = r24.intValue();
    L61:
        int r113 = r25;
        Integer r26 = Integer.valueOf(r20.getHeight());
        if (r26.intValue() <= 0) goto L64;
        boolean r27 = true;
    L65:
        if (r27 == true) goto L68;
        r26 = null;
    L68:
        if (r26 == null) goto L70;
        int r28 = r26.intValue();
    L71:
        r13 = com.larus.chat.gallery.api.o.a(r13, null, r21, r111, r113, r28, 69);
        goto L72
    L70:
        r28 = r13.f;
        goto L71
    L64:
        r27 = false;
        goto L65
    L60:
        r25 = r13.e;
        goto L61
    L54:
        r112 = false;
    L50:
        r23 = r20.getUri();
    L72:
        r11.add(r13);
        goto L39
    L73:
        return r11;
    L17:
        r17 = null;
        goto L18
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [np9.d] */
    /* JADX WARN: Type inference failed for: r3v18, types: [androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks, com.larus.photopicker.v2.impl.injectinput.InjectInputCoordinator$registerInjectInputLifecycleCallbacks$callbacks$1] */
    public final void W90(boolean r12) {
        int r0 = e0.a;
        e0.d("MediaGalleryFragment", "check permission, displayType=" + Y90().getUiConfig().f);
        LarusFragmentGalleryBinding r1 = this.g;
        op8.g r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        String r3 = Y90().getUiConfig().f;
        int r4 = r3.hashCode();
        if (r4 == (-195585267)) goto L133;
        if (r4 == 984352093) goto L120;
        if (r4 == 1426874098) goto L13;
        return;
    L13:
        if (r3.equals("album_display") == true) goto L16;
        return;
    L16:
        if (this.e.e != MediaPickerUIMode.INVISIBLE_BOTTOM_SHEET) goto L21;
        com.larus.platform.service.k2 r5 = com.larus.platform.service.k2.a;
        if (g3.a.d() == true) goto L21;
        e0.d("MediaGalleryFragment", "no permission in camera bottom sheet");
        return;
    L21:
        MediaGalleryLiveDataViewModel.initFastMediaItems$default(Y90(), 0, 1, null);
        com.larus.utils.e1.o(r1.b);
        BottomSheetViewModel r6 = X90();
        if (r6 == null) goto L24;
        r6.requestDisallowInterceptTouchEvent(false);
    L24:
        if (r12 == false) goto L148;
        final np9.g r13 = this.k;
        if (r13 == null) goto L113;
        e0.d(r13.g, "setupIfNeeded");
        Fragment r7 = r13.a;
    L28:
        if (r7 == null) goto L47;
        Bundle r8 = r7.getArguments();
        if (r8 != null) goto L32;
    L34:
        boolean r9 = false;
    L35:
        if (r9 == true) goto L36;
        r7 = r7.getParentFragment();
        goto L28
    L36:
        op8.k r10 = s1a.a.g(r7).a(op8.k.class);
        if (r10 == null) goto L39;
        Fragment r11 = r10.a();
    L40:
        if (r11 != null) goto L44;
        int r14 = e0.a;
        e0.d(r13.g, "quick album input owner unavailable; closing restored child");
        BottomSheetViewModel r15 = r13.c;
        if (r15 == null) goto L113;
        r15.closeBottomSheet();
        goto L113
    L44:
        s1a.a.g(r13.a).n(r10, op8.k.class);
        goto L47
    L39:
        r11 = null;
        goto L40
    L32:
        if (r8.getBoolean("quick_album_requires_live_input_owner") != true) goto L34;
        r9 = true;
    L47:
        if (r13.m == false) goto L49;
        int r16 = e0.a;
        e0.d(r13.g, "setupIfNeeded hasSetupInjectInput");
        goto L113
    L49:
        r13.m = true;
        kq9.e r17 = lp9.d.a;
        if (r17 == null) goto L52;
        String r18 = r17.a;
    L53:
        String r19 = "";
        if (r18 != null) goto L56;
        r18 = "";
    L56:
        if (r17 == null) goto L58;
        String r20 = r17.f;
    L59:
        if (r20 != null) goto L61;
        r20 = "";
    L61:
        if (r17 == null) goto L63;
        String r21 = r17.b;
    L64:
        if (r21 != null) goto L66;
        r21 = "";
    L66:
        op8.i r22 = (op8.i) r13.h.getValue();
        if (r22 == null) goto L91;
        Boolean r23 = Boolean.TRUE;
        LinkedHashMap r24 = new LinkedHashMap();
        r24.put("conversation_id", r21);
        r24.put("click_from", r20);
        r24.put("current_page", "album");
        r24.put("enter_method", "album");
        r24.put("bot_id", r18);
        String r25 = r13.e;
        if (r25 == null) goto L71;
        String r26 = (String) r24.put("suggested_action_provider", r25);
    L71:
        String r27 = r13.d.getUiConfig().s;
        if (r27 == null) goto L74;
        String r28 = (String) r24.put("inject_input_initial_text", r27);
    L74:
        String r29 = r13.d.getUiConfig().t;
        if (r29 == null) goto L77;
        String r30 = (String) r24.put("inject_input_initial_attachment_snapshot_id", r29);
    L77:
        r24.put("inject_input_initial_source_node_id", r13.d.getUiConfig().u);
        r24.put("inject_input_mobile_preview_host_enabled", String.valueOf(r13.d.getUiConfig().A));
        r24.put("inject_input_album_node_id", r13.d.getUiConfig().w);
        Boolean r31 = r13.d.getUiConfig().z;
        if (r31 == null) goto L80;
        String r32 = (String) r24.put("USE_UNIFIED_MEDIA_CANVAS", String.valueOf(r31.booleanValue()));
    L80:
        String r33 = r13.d.getUiConfig().x;
        if (kq9.b.c(r33) == true) goto L84;
        r33 = null;
    L84:
        if (r33 == null) goto L87;
        r19 = r33;
    L87:
        r24.put("inject_input_upstream_album_node_id", r19);
        r24.put("inject_input_hide_album_entrance", String.valueOf(r13.d.getUiConfig().C));
        List<String> r34 = r13.d.getUiConfig().v;
        if ((!r34.isEmpty()) == false) goto L90;
        r24.put("inject_input_initial_attachment_uris", new JSONArray(r34).toString());
    L90:
        Unit r35 = Unit.INSTANCE;
        final Fragment r36 = r22.b(r23, "inject_input_photo_picker", r24);
    L92:
        if (r36 == null) goto L112;
        final int r37 = r13.b.c.getId();
        if (r13.a.isAdded() == false) goto L100;
        FragmentTransaction r38 = r13.a.getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r38, r36, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, r37) == true) goto L99;
        r38 = r38.add(r37, r36);
    L99:
        r38.commitAllowingStateLoss();
    L102:
        if ((r36 instanceof op8.g) == false) goto L104;
        r2 = (op8.g) r36;
    L104:
        if (r2 == null) goto L112;
        if (r36.isAdded() == true) goto L109;
    L111:
        r13.h();
        FragmentManager r39 = r13.a.getChildFragmentManager();
        ?? r40 = new InjectInputCoordinator$registerInjectInputLifecycleCallbacks$callbacks$1(r36, r13);
        r39.registerFragmentLifecycleCallbacks(r40, false);
        r13.p = r40;
        r13.q = r39;
        goto L112
    L109:
        if (r36.getView() == null) goto L111;
        r13.e(r2);
        goto L112
    L100:
        r13.a.getViewLifecycleOwner().getLifecycle().addObserver(new InjectInputCoordinator$addFragmentSafely$1(r13, r36, r37));
    L112:
        InjectInputContainer r41 = r13.b.c;
        Function0 r42 = new np9.a(r13);
        r41.getClass();
        Intrinsics.checkNotNullParameter(r42, "block");
        r41.b = r42;
        InjectInputContainer r43 = r13.b.c;
        Function0 r44 = new np9.b(r13);
        r43.getClass();
        Intrinsics.checkNotNullParameter(r44, "block");
        r43.c = r44;
        com.larus.utils.e1.d(r13.b.f, new np9.c(r13));
        goto L113
    L91:
        r36 = null;
        goto L92
    L63:
        r21 = null;
        goto L64
    L58:
        r20 = null;
        goto L59
    L52:
        r18 = null;
    L113:
        final np9.g r110 = this.k;
        if (r110 == null) goto L149;
        LifecycleOwner r45 = getViewLifecycleOwner();
        Intrinsics.checkNotNullParameter(r45, "viewLifecycleOwner");
        if (r110.n == false) goto L118;
        int r46 = e0.a;
        e0.d(r110.g, "bindSelectionSync hasBindSelectionSync");
        return;
    L118:
        r110.n = true;
        Set<? extends Uri> r47 = CollectionsKt.toSet(r110.d.initialSelectionUris());
        r110.j = r47;
        r110.k = !r47.isEmpty();
        r110.d.getSelectionManager().g.observe(r45, new np9.g.b(new np9.d(r110)));
        return;
    L149:
        return;
    L148:
        return;
    L120:
        if (r3.equals("no_image") == false) goto L157;
        aa0(Y90().getUiConfig().i);
        com.larus.utils.e1.x(r1.b);
        com.larus.utils.e1.d(r1.d, new n0(this));
        TextView r111 = r1.e;
        Context r48 = getContext();
        if (r48 == null) goto L125;
        String r49 = r48.getString(2131899732);
    L126:
        r111.setText(r49);
        TextView r112 = r1.d;
        Context r50 = getContext();
        if (r50 == null) goto L129;
        r2 = r50.getString(2131899731);
    L129:
        r112.setText(r2);
        BottomSheetViewModel r113 = X90();
        if (r113 == null) goto L152;
        r113.requestDisallowInterceptTouchEvent(true);
        return;
    L152:
        return;
    L125:
        r49 = null;
        goto L126
    L157:
        return;
    L133:
        if (r3.equals("no_permission") == false) goto L158;
        aa0(Y90().getUiConfig().i);
        com.larus.utils.e1.x(r1.b);
        com.larus.utils.e1.d(r1.d, new o0(this));
        TextView r114 = r1.e;
        Context r51 = getContext();
        if (r51 == null) goto L138;
        String r52 = r51.getString(2131899730);
    L139:
        r114.setText(r52);
        TextView r115 = r1.d;
        Context r53 = getContext();
        if (r53 == null) goto L142;
        r2 = r53.getString(2131899729);
    L142:
        r115.setText(r2);
        BottomSheetViewModel r116 = X90();
        if (r116 == null) goto L154;
        r116.requestDisallowInterceptTouchEvent(true);
        return;
    L154:
        return;
    L138:
        r52 = null;
        goto L139
    }

    public final void aa0(int r4) {
        if (r4 <= 0) goto L12;
        LarusFragmentGalleryBinding r0 = this.g;
        LarusFragmentGalleryBinding r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L6:
        ViewGroup.LayoutParams r2 = r0.b.getLayoutParams();
        r2.height = r4;
        LarusFragmentGalleryBinding r5 = this.g;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L10:
        r1.b.setLayoutParams(r2);
        return;
    L9:
        r1 = r5;
        goto L10
    }

    public final void ca0(String r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Y90().setUiConfig(MediaGalleryUIConfig.a(Y90().getUiConfig(), 0, false, r5, -33));
        W90(Y90().isInjectInputMode());
    }

    public final void da0(boolean r3) {
        int r0 = e0.a;
        e0.d("MediaGalleryFragment", "updateForceSinglePick: " + r3);
        Y90().updateForceSinglePick(r3);
        MediaGalleryLiveDataViewModel r1 = Y90();
        if (Y90().isInjectInputMode() == false) goto L6;
        if (r3 == false) goto L6;
        boolean r4 = true;
    L7:
        r1.setAllowReplaceWhenSingle(r4);
        return;
    L6:
        r4 = false;
        goto L7
    }

    public final void fillTrackParams(TrackParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        a$a.a(this, r3);
        r3.put("if_support_multi", Integer.valueOf(!this.e.d ? 1 : 0));
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L7;
        MediaGalleryUIConfig r4 = (MediaGalleryUIConfig) r3.getParcelable("ui_config");
        if (r4 == null) goto L7;
        this.e = r4;
    L7:
        Bundle r5 = getArguments();
        if (r5 == null) goto L12;
        LazyLoadConfig r6 = (LazyLoadConfig) r5.getParcelable("lazy_load_config");
        if (r6 == null) goto L12;
        this.f = r6;
    L12:
        Bundle r7 = getArguments();
        if (r7 == null) goto L17;
        MediaNonUISettings r8 = (MediaNonUISettings) r7.getParcelable("non_ui_settings");
        if (r8 == null) goto L17;
        this.l = r8;
    L17:
        Map<String, Integer> r9 = kq9.b.a;
        kq9.b.a(this.e.w);
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.photopicker.v2.impl.f0] */
    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r13, r14);
        int r15 = e0.a;
        e0.d("MediaGalleryFragment", "onViewCreated: [" + this.e.e + ']');
        Y90().init(new MediaRepositoryImpl(new ContentResolverMediaSource(AppHost.a.getApplication().getApplicationContext(), this.f), this.f), this.f, this.e, this.l);
        Z90().init("album", this.e);
        MediaMobViewModel r16 = Z90();
        boolean r1 = false;
        if (this.e.e == MediaPickerUIMode.NORMAL) goto L5;
        boolean r17 = true;
    L6:
        r16.mobPhotoPickerPageShow(r17, getParentFragment() instanceof BottomPhotoPickerFragmentV3);
        boolean r18 = this.e.q;
        LarusFragmentGalleryBinding r0 = this.g;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        LarusFragmentGalleryBinding r5 = null;
    L10:
        this.k = new np9.g(this, r5, X90(), Y90(), this.e.r, new f0(this));
        Y90().setInjectInputMode(r18);
        MediaGalleryLiveDataViewModel r19 = Y90();
        if (r18 == true) goto L13;
    L15:
        r19.setAllowReplaceWhenSingle(r1);
        Intent r110 = requireActivity().getIntent();
        if (r110 == null) goto L28;
        final String r111 = r110.getStringExtra("extra.album.selection.session.id");
        if (r111 == null) goto L28;
        if ((!StringsKt.isBlank(r111)) == true) goto L23;
        r111 = null;
    L23:
        if (r111 == null) goto L28;
        if (this.e.d == true) goto L28;
        this.m = MapsKt.emptyMap();
        Y90().getSelectionManager().g.observe(getViewLifecycleOwner(), new d(new p0(this, r111)));
    L28:
        FragmentTransaction r112 = getChildFragmentManager().beginTransaction();
        LarusFragmentGalleryBinding r2 = this.g;
        if (r2 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L31:
        int r3 = r2.g.getId();
        MediaSelectorFragment r4 = new MediaSelectorFragment();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r112, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r3) == true) goto L35;
        r112 = r112.replace(r3, r4);
    L35:
        r112.commitAllowingStateLoss();
        W90(r18);
        Y90().getShowPreviewFragment().observe(getViewLifecycleOwner(), new d(new h0(this)));
        Y90().getSelectionManager().j.observe(getViewLifecycleOwner(), new d(new i0(this)));
        Y90().getSelectionManager().k.observe(getViewLifecycleOwner(), new d(new j0()));
        BottomSheetViewModel r113 = X90();
        if (r113 == null) goto L40;
        MutableLiveData<Boolean> r114 = r113.getOnBackPressed();
        if (r114 == null) goto L40;
        r114.observe(getViewLifecycleOwner(), new d(new k0(this)));
    L40:
        BottomSheetViewModel r115 = X90();
        if (r115 == null) goto L45;
        MutableLiveData<List<op9.d>> r116 = r115.getSelectedResult();
        if (r116 == null) goto L45;
        r116.observe(getViewLifecycleOwner(), new d(new l0(this)));
    L45:
        BottomSheetViewModel r117 = X90();
        if (r117 == null) goto L51;
        MutableLiveData<Integer> r118 = r117.getBottomSheetOnStateChanged();
        if (r118 == null) goto L52;
        r118.observe(getViewLifecycleOwner(), new d(new m0(this)));
        return;
    L52:
        return;
    L51:
        return;
    L13:
        if (this.e.d == false) goto L15;
        r1 = true;
        goto L15
    L9:
        r5 = r0;
        goto L10
    L5:
        r17 = false;
        goto L6
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        View r13 = r10.inflate(2131562395, r11, false);
        int r14 = 2131362462;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r13, 2131362462);
        if (r2 == null) goto L19;
        r14 = 2131367767;
        InjectInputContainer r3 = ViewBindings.findChildViewById(r13, 2131367767);
        if (r3 == null) goto L19;
        r14 = 2131374104;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r13, 2131374104);
        if (r4 == null) goto L19;
        r14 = 2131374145;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r13, 2131374145);
        if (r5 == null) goto L19;
        r14 = 2131375434;
        View r6 = ViewBindings.findChildViewById(r13, 2131375434);
        if (r6 == null) goto L19;
        r14 = 2131379823;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r13, 2131379823);
        if (r7 == null) goto L19;
        r14 = 2131382912;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(r13, 2131382912);
        if (r8 == null) goto L19;
        LarusFragmentGalleryBinding r15 = new LarusFragmentGalleryBinding((FrameLayout) r13, r2, r3, r4, r5, r6, r7, r8);
        this.g = r15;
        return r15.a;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
