package com.larus.photopicker.v2.impl.viewmodel;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.photopicker.v2.impl.data.model.LazyLoadConfig;
import com.larus.photopicker.v2.impl.e0;
import com.larus.photopicker.v2.impl.model.EntryMode;
import com.larus.photopicker.v2.impl.model.MediaGalleryUIConfig;
import com.larus.photopicker.v2.impl.model.MediaNonUISettings;
import com.larus.photopicker.v2.impl.model.MediaTab;
import com.larus.platform.model.album.CreationReferenceAlbumConfig;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.InputDraftSnapshot;
import com.larus.platform.model.preview.ResourceRef;
import com.larus.platform.model.preview.ResourceRefKind;
import com.tencent.open.log.TraceLevel;
import dr9.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import pp9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b,\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010Q\u001a\u00020R2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\f\u0010S\u001a\b\u0012\u0004\u0012\u00020T0\u001cJ\b\u0010U\u001a\u00020RH\u0002J\u0006\u0010V\u001a\u000202J\u000e\u0010W\u001a\u00020R2\u0006\u0010X\u001a\u000202J\u0006\u0010Y\u001a\u000202J\u000e\u0010Z\u001a\u00020R2\u0006\u0010X\u001a\u000202J(\u0010[\u001a\u00020R2\b\u0010\\\u001a\u0004\u0018\u00010T2\u0016\b\u0002\u0010]\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020R\u0018\u00010^J4\u0010_\u001a\u00020R2\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u0002020^2\u0016\b\u0002\u0010]\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020R\u0018\u00010^H\u0002J\u0010\u0010a\u001a\u00020R2\b\b\u0002\u0010b\u001a\u00020cJ\u0006\u0010d\u001a\u00020RJ\u0006\u0010e\u001a\u00020RJ\u0018\u0010f\u001a\u0004\u0018\u00010g2\u0006\u0010h\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010iJ\u000e\u0010j\u001a\u0002022\u0006\u0010k\u001a\u00020gJ\u0006\u0010l\u001a\u00020RJ\u000e\u0010m\u001a\u00020R2\u0006\u0010n\u001a\u00020cJ\u000e\u0010o\u001a\u00020R2\u0006\u0010p\u001a\u00020&J\u0006\u0010q\u001a\u00020&J\u0006\u0010r\u001a\u000202J\u000e\u0010s\u001a\u00020R2\u0006\u0010t\u001a\u00020,J\u000e\u0010u\u001a\u00020R2\u0006\u0010v\u001a\u000202J\u000e\u0010w\u001a\u00020R2\u0006\u0010x\u001a\u00020(J\u0016\u0010y\u001a\u0002022\u0006\u0010x\u001a\u00020(2\u0006\u0010z\u001a\u000202J\u0006\u0010{\u001a\u00020RJ\u0006\u0010|\u001a\u00020RJ\u0016\u0010}\u001a\u00020R2\u0006\u0010k\u001a\u00020(2\u0006\u0010~\u001a\u00020,J\u0016\u0010\u007f\u001a\u00020R2\u0006\u0010k\u001a\u00020(2\u0006\u0010~\u001a\u00020,J\u000f\u0010\u0080\u0001\u001a\u00020,2\u0006\u0010k\u001a\u00020(J\u0010\u0010\u0081\u0001\u001a\u00020R2\u0007\u0010\u0082\u0001\u001a\u00020&J2\u0010\u0083\u0001\u001a\u00020R2\u0007\u0010\u0084\u0001\u001a\u00020\u001d2\u0006\u0010x\u001a\u00020(2\u0007\u0010\u0085\u0001\u001a\u0002022\r\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020(0\u001cH\u0002J\u001e\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020(0\u001c2\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020g0\u001cH\u0002J)\u0010\u0089\u0001\u001a\u00020R2\u0006\u0010x\u001a\u00020(2\u0007\u0010\u0085\u0001\u001a\u0002022\r\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020(0\u001cH\u0002J>\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020(0\u001c2\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020(0\u001c2\u0006\u0010x\u001a\u00020(2\u0007\u0010\u0085\u0001\u001a\u0002022\r\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020(0\u001cH\u0002J)\u0010\u008b\u0001\u001a\u00020,2\r\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020(0\u001c2\u0006\u0010k\u001a\u00020(2\u0007\u0010\u008d\u0001\u001a\u00020,H\u0002J#\u0010\u008e\u0001\u001a\u00020R2\u0007\u0010\u008f\u0001\u001a\u00020\u00052\u0006\u0010k\u001a\u00020(2\u0007\u0010\u0090\u0001\u001a\u00020,H\u0002J,\u0010\u0083\u0001\u001a\u00020R2\u0007\u0010\u0084\u0001\u001a\u00020\u001d2\u0006\u0010x\u001a\u00020(2\u0007\u0010\u0085\u0001\u001a\u0002022\u0007\u0010\u0091\u0001\u001a\u00020,H\u0002J\u0012\u0010\u0092\u0001\u001a\u00020R2\u0007\u0010\u0084\u0001\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u001c0\u001f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000207X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u0002020\u001b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001d\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u001c0\u001b¢\u0006\b\n\u0000\u001a\u0004\b@\u0010>R#\u0010A\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020,0B0\u001b¢\u0006\b\n\u0000\u001a\u0004\bC\u0010>R\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u001b¢\u0006\b\n\u0000\u001a\u0004\bF\u0010>R\u0017\u0010G\u001a\b\u0012\u0004\u0012\u0002020\u001b¢\u0006\b\n\u0000\u001a\u0004\bH\u0010>R\u0011\u0010I\u001a\u00020J¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u000e\u0010M\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010N\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0004\n\u0002\u0010OR\u000e\u0010P\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0093\u0001"}, d2 = {"Lcom/larus/photopicker/v2/impl/viewmodel/MediaGalleryLiveDataViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "TAG", "", "mediaRepository", "Lcom/larus/photopicker/v2/impl/data/MediaRepository;", "uiConfig", "Lcom/larus/photopicker/v2/impl/model/MediaGalleryUIConfig;", "getUiConfig", "()Lcom/larus/photopicker/v2/impl/model/MediaGalleryUIConfig;", "setUiConfig", "(Lcom/larus/photopicker/v2/impl/model/MediaGalleryUIConfig;)V", "nonUiSettings", "Lcom/larus/photopicker/v2/impl/model/MediaNonUISettings;", "getNonUiSettings", "()Lcom/larus/photopicker/v2/impl/model/MediaNonUISettings;", "setNonUiSettings", "(Lcom/larus/photopicker/v2/impl/model/MediaNonUISettings;)V", "lazyLoadConfig", "Lcom/larus/photopicker/v2/impl/data/model/LazyLoadConfig;", "getLazyLoadConfig", "()Lcom/larus/photopicker/v2/impl/data/model/LazyLoadConfig;", "setLazyLoadConfig", "(Lcom/larus/photopicker/v2/impl/data/model/LazyLoadConfig;)V", "_folders", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/photopicker/v2/impl/model/UIMediaFolder;", "folders", "Landroidx/lifecycle/LiveData;", "getFolders", "()Landroidx/lifecycle/LiveData;", "_currentFolder", "currentFolder", "getCurrentFolder", "currentTab", "Lcom/larus/photopicker/v2/impl/model/MediaTab;", "_fastMediaItems", "Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "fastMediaItems", "getFastMediaItems", "curPreviewPosition", "", "getCurPreviewPosition", "()I", "setCurPreviewPosition", "(I)V", "isNeedAnimWhenEnterPreview", "", "()Z", "setNeedAnimWhenEnterPreview", "(Z)V", "enterPreviewPageEntryMode", "Lcom/larus/photopicker/v2/impl/model/EntryMode;", "getEnterPreviewPageEntryMode", "()Lcom/larus/photopicker/v2/impl/model/EntryMode;", "setEnterPreviewPageEntryMode", "(Lcom/larus/photopicker/v2/impl/model/EntryMode;)V", "showPreviewFragment", "getShowPreviewFragment", "()Landroidx/lifecycle/MutableLiveData;", "currentPreviewItems", "getCurrentPreviewItems", "enterOrExitPreviewPage", "Lkotlin/Pair;", "getEnterOrExitPreviewPage", "capturePositionViewRect", "Lcom/larus/photopicker/v2/impl/model/EnterExitAnimationData;", "getCapturePositionViewRect", "closeTitleFolder", "getCloseTitleFolder", "selectionManager", "Lcom/larus/photopicker/v2/impl/viewmodel/SelectionManager;", "getSelectionManager", "()Lcom/larus/photopicker/v2/impl/viewmodel/SelectionManager;", "injectInputMode", "maxSelectCountBeforeForceSingle", "Ljava/lang/Integer;", "initialSelectionRestoreCompleted", "init", "", "initialSelectionUris", "Landroid/net/Uri;", "restoreInitialSelection", "isInitialSelectionRestoreCompleted", "setInjectInputMode", "enabled", "isInjectInputMode", "setAllowReplaceWhenSingle", "removeSelectionByUri", "uri", "onRemoved", "Lkotlin/Function1;", "removeSelectionByPredicate", "predicate", "initFastMediaItems", "delayDuration", "", "initMediaFolders", "refreshMediaFoldersAfterPermissionChange", "queryMediaItem", "Lcom/larus/photopicker/v2/impl/data/model/MediaItem;", "uriString", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertMediaItemAndSelect", "mediaItem", "setFirstFolder", "setCurrentFolder", "folderId", "setCurrentTab", "tab", "getCurrentTab", "canShowTabs", "updateMaxSelectCount", "maxSelectCount", "updateForceSinglePick", "forceSinglePick", "toggleSelection", "curSelectedMediaItem", "setSelectionImmediately", "selected", "clearSelection", "closeTitleFolderEntrance", "enterPreviewMediaPage", "position", "enterPreviewMediaPageFromBottomSelector", "getCurMediaItemPositionInPreview", "loadMore", "mediaTab", "refreshCurFolderSelectedStatus", "curFolder", "isSelected", "selectedSnapshot", "buildFastUIMediaItems", "mediaItems", "refreshFastMediaSelectedStatus", "refreshMediaItemsSelectedStatus", "resolvePreviewPosition", "previewItems", "fallbackPosition", "reportCurrentFolderNotReady", "action", "fastMediaSize", "selectionOrder", "refreshFolderSelectableByType", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaGalleryLiveDataViewModel extends ViewModel {
    private final String TAG;
    private final MutableLiveData<op9.c> _currentFolder;
    private final MutableLiveData<List<op9.d>> _fastMediaItems;
    private final MutableLiveData<List<op9.c>> _folders;
    private final MutableLiveData<op9.a> capturePositionViewRect;
    private final MutableLiveData<Boolean> closeTitleFolder;
    private int curPreviewPosition;
    private final LiveData<op9.c> currentFolder;
    private final MutableLiveData<List<op9.d>> currentPreviewItems;
    private MediaTab currentTab;
    private final MutableLiveData<Pair<Boolean, Integer>> enterOrExitPreviewPage;
    private EntryMode enterPreviewPageEntryMode;
    private final LiveData<List<op9.d>> fastMediaItems;
    private final LiveData<List<op9.c>> folders;
    private boolean initialSelectionRestoreCompleted;
    private boolean injectInputMode;
    private boolean isNeedAnimWhenEnterPreview;
    private LazyLoadConfig lazyLoadConfig;
    private Integer maxSelectCountBeforeForceSingle;
    private com.larus.photopicker.v2.impl.data.d mediaRepository;
    private MediaNonUISettings nonUiSettings;
    private final d selectionManager;
    private final MutableLiveData<Boolean> showPreviewFragment;
    private MediaGalleryUIConfig uiConfig;

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(b r2) {
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

    /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$clearSelection$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$clearSelection$1", f = "MediaGalleryLiveDataViewModel.kt", i = {}, l = {494}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

        /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$clearSelection$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$clearSelection$1$2", f = "MediaGalleryLiveDataViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ op9.c $curFolder;
            final /* synthetic */ Set<op9.d> $curSelectedItems;
            int label;
            final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

            public AnonymousClass2(MediaGalleryLiveDataViewModel r1, op9.c r2, Set<op9.d> r3, Continuation<? super AnonymousClass2> r4) {
                this.this$0 = r1;
                this.$curFolder = r2;
                this.$curSelectedItems = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new AnonymousClass2(this.this$0, this.$curFolder, this.$curSelectedItems, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r10) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L20;
                ResultKt.throwOnFailure(r10);
                List r11 = (List) MediaGalleryLiveDataViewModel.access$get_folders$p(this.this$0).getValue();
                if (r11 == null) goto L18;
                op9.c r0 = this.$curFolder;
                Set<op9.d> r1 = this.$curSelectedItems;
                MediaGalleryLiveDataViewModel r2 = this.this$0;
                Iterator r12 = r11.iterator();
            L8:
                if (r12.hasNext() == false) goto L18;
                op9.c r3 = (op9.c) r12.next();
                if (r3.a == r0.a) goto L8;
                Iterator<T> r4 = r1.iterator();
            L14:
                if (r4.hasNext() == false) goto L16;
                MediaGalleryLiveDataViewModel.access$refreshCurFolderSelectedStatus(r2, r3, (op9.d) r4.next(), false, 0);
                goto L14
            L16:
                MediaGalleryLiveDataViewModel.access$refreshFolderSelectableByType(r2, r3);
            L18:
                return Unit.INSTANCE;
            L20:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(MediaGalleryLiveDataViewModel r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L28:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            op9.c r9 = (op9.c) MediaGalleryLiveDataViewModel.access$get_currentFolder$p(this.this$0).getValue();
            if (r9 == null) goto L11;
            Set r2 = (Set) this.this$0.getSelectionManager().g.getValue();
            if (r2 == null) goto L15;
            MediaGalleryLiveDataViewModel r4 = this.this$0;
            Iterator r3 = r2.iterator();
        L18:
            if (r3.hasNext() == false) goto L20;
            MediaGalleryLiveDataViewModel.access$refreshCurFolderSelectedStatus(r4, r9, (op9.d) r3.next(), false, 0);
            goto L18
        L20:
            d r5 = this.this$0.getSelectionManager();
            r5.getClass();
            e0.d("SelectionManager", "clearSelection");
            r5.f.setValue(new LinkedHashSet());
            r5.h.setValue(Boolean.TRUE);
            String r6 = MediaGalleryLiveDataViewModel.access$getTAG$p(this.this$0);
            StringBuilder r7 = new StringBuilder("clearSelection, curFolder=");
            mp9.b r10 = r9.b;
            if (r10 == null) goto L23;
            String r11 = r10.b;
        L24:
            r7.append(r11);
            e0.d(r6, r7.toString());
            MediaGalleryLiveDataViewModel.access$refreshFolderSelectableByType(this.this$0, r9);
            MediaGalleryLiveDataViewModel.access$get_currentFolder$p(this.this$0).postValue(r9);
            CoroutineDispatcher r12 = Dispatchers.getDefault();
            AnonymousClass2 r13 = new AnonymousClass2(this.this$0, r9, r2, null);
            this.label = 1;
            if (BuildersKt.withContext(r12, r13, this) != r0) goto L28;
            return r0;
        L23:
            r11 = null;
            goto L24
        L15:
            return Unit.INSTANCE;
        L11:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$initFastMediaItems$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$initFastMediaItems$1", f = "MediaGalleryLiveDataViewModel.kt", i = {0, 1}, l = {254, 258, 261}, m = "invokeSuspend", n = {"repository", "repository"}, s = {"L$0", "L$0"})
    public static final class C00891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayDuration;
        Object L$0;
        int label;
        final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

        public C00891(MediaGalleryLiveDataViewModel r1, long r2, Continuation<? super C00891> r4) {
            this.this$0 = r1;
            this.$delayDuration = r2;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C00891(this.this$0, this.$delayDuration, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r10);
        L27:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            com.larus.photopicker.v2.impl.data.d r2 = (com.larus.photopicker.v2.impl.data.d) this.L$0;
            ResultKt.throwOnFailure(r10);
        L23:
            int r11 = e0.a;
            e0.d(MediaGalleryLiveDataViewModel.access$getTAG$p(this.this$0), "[" + MediaGalleryLiveDataViewModel.access$getCurrentTab$p(this.this$0) + "] start initMediaFolders loadFolders");
            List<MediaTab> r12 = this.this$0.getUiConfig().a;
            this.L$0 = null;
            this.label = 3;
            if (r2.e(r12, this) != r0) goto L27;
            return r0;
        L11:
            r2 = (com.larus.photopicker.v2.impl.data.d) this.L$0;
            ResultKt.throwOnFailure(r10);
        L20:
            MediaGalleryLiveDataViewModel.access$get_fastMediaItems$p(this.this$0).setValue(MediaGalleryLiveDataViewModel.access$buildFastUIMediaItems(this.this$0, (List) r10));
            long r5 = this.$delayDuration;
            this.L$0 = r2;
            this.label = 2;
            if (DelayKt.delay(r5, this) != r0) goto L23;
            return r0;
        L12:
            ResultKt.throwOnFailure(r10);
            com.larus.photopicker.v2.impl.data.d r13 = MediaGalleryLiveDataViewModel.access$getMediaRepository$p(this.this$0);
            if (r13 == null) goto L15;
            int r3 = e0.a;
            e0.d(MediaGalleryLiveDataViewModel.access$getTAG$p(this.this$0), "[" + MediaGalleryLiveDataViewModel.access$getCurrentTab$p(this.this$0) + "] start initFastMediaItems loadFolders");
            int r4 = this.this$0.getLazyLoadConfig().c;
            List<MediaTab> r6 = this.this$0.getUiConfig().a;
            this.L$0 = r13;
            this.label = 1;
            Object r7 = r13.f(1, r4, r6, this);
            if (r7 != r0) goto L19;
            return r0;
        L19:
            r2 = r13;
            r10 = r7;
            goto L20
        L15:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$initMediaFolders$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$initMediaFolders$1", f = "MediaGalleryLiveDataViewModel.kt", i = {}, l = {271}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

        public C00901(MediaGalleryLiveDataViewModel r1, Continuation<? super C00901> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C00901(this.this$0, r3);
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
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            com.larus.photopicker.v2.impl.data.d r7 = MediaGalleryLiveDataViewModel.access$getMediaRepository$p(this.this$0);
            if (r7 == null) goto L11;
            int r2 = e0.a;
            e0.d(MediaGalleryLiveDataViewModel.access$getTAG$p(this.this$0), "[" + MediaGalleryLiveDataViewModel.access$getCurrentTab$p(this.this$0) + "] initMediaFolders: loadFolders");
            List<MediaTab> r3 = this.this$0.getUiConfig().a;
            this.label = 1;
            if (r7.e(r3, this) != r0) goto L16;
            return r0;
        L11:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$loadMore$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$loadMore$1", f = "MediaGalleryLiveDataViewModel.kt", i = {0, 0, 1, 1}, l = {570, 576, 579}, m = "invokeSuspend", n = {"repository", "filter", "repository", "filter"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class C00911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MediaTab $mediaTab;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

        public C00911(MediaGalleryLiveDataViewModel r1, MediaTab r2, Continuation<? super C00911> r3) {
            this.this$0 = r1;
            this.$mediaTab = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C00911(this.this$0, this.$mediaTab, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r11);
        L43:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            mp9.a r2 = (mp9.a) this.L$1;
            com.larus.photopicker.v2.impl.data.d r3 = (com.larus.photopicker.v2.impl.data.d) this.L$0;
            ResultKt.throwOnFailure(r11);
        L39:
            int r12 = ((Number) r11).intValue();
            int r6 = e0.a;
            e0.d(MediaGalleryLiveDataViewModel.access$getTAG$p(this.this$0), "4.loadMore: Load next page, curPage: " + r12);
            int r4 = this.this$0.getLazyLoadConfig().b;
            this.L$0 = null;
            this.L$1 = null;
            this.label = 3;
            if (r3.i(r12 + 1, r4, r2, this) != r0) goto L43;
            return r0;
        L11:
            r2 = (mp9.a) this.L$1;
            com.larus.photopicker.v2.impl.data.d r7 = (com.larus.photopicker.v2.impl.data.d) this.L$0;
            ResultKt.throwOnFailure(r11);
        L32:
            if (((Boolean) r11).booleanValue() == true) goto L35;
            int r13 = e0.a;
            e0.d(MediaGalleryLiveDataViewModel.access$getTAG$p(this.this$0), "3.loadMore: No more items");
            return Unit.INSTANCE;
        L35:
            this.L$0 = r7;
            this.L$1 = r2;
            this.label = 2;
            r11 = r7.b(r2, this);
            if (r11 != r0) goto L38;
            return r0;
        L38:
            r3 = r7;
            goto L39
        L12:
            ResultKt.throwOnFailure(r11);
            com.larus.photopicker.v2.impl.data.d r14 = MediaGalleryLiveDataViewModel.access$getMediaRepository$p(this.this$0);
            if (r14 == null) goto L15;
            op9.c r5 = (op9.c) MediaGalleryLiveDataViewModel.access$get_currentFolder$p(this.this$0).getValue();
            if (r5 == null) goto L19;
            Long r8 = Boxing.boxLong(r5.a);
        L20:
            if (r8 != null) goto L23;
            int r15 = e0.a;
            e0.d(MediaGalleryLiveDataViewModel.access$getTAG$p(this.this$0), "2.loadMore: Folder has not been initialized, don't need to loadMore");
            return Unit.INSTANCE;
        L23:
            op9.c r9 = (op9.c) MediaGalleryLiveDataViewModel.access$get_currentFolder$p(this.this$0).getValue();
            if (r9 == null) goto L26;
            Long r10 = Boxing.boxLong(r9.a);
        L27:
            r2 = new mp9.a(r10, this.$mediaTab);
            this.L$0 = r14;
            this.L$1 = r2;
            this.label = 1;
            Object r16 = r14.d(r2, this);
            if (r16 != r0) goto L30;
            return r0;
        L30:
            r7 = r14;
            r11 = r16;
            goto L32
        L26:
            r10 = null;
            goto L27
        L19:
            r8 = null;
            goto L20
        L15:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$refreshMediaFoldersAfterPermissionChange$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$refreshMediaFoldersAfterPermissionChange$1", f = "MediaGalleryLiveDataViewModel.kt", i = {0, 0}, l = {285, 291}, m = "invokeSuspend", n = {"repository", "destination$iv$iv"}, s = {"L$0", "L$1"})
    public static final class C00921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

        public C00921(MediaGalleryLiveDataViewModel r1, Continuation<? super C00921> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C00921(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00a2 -> B:27:0x00aa). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r14);
        L58:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Long r2 = (Long) this.L$3;
            Iterator r5 = (Iterator) this.L$2;
            Collection r6 = (Collection) this.L$1;
            com.larus.photopicker.v2.impl.data.d r7 = (com.larus.photopicker.v2.impl.data.d) this.L$0;
            ResultKt.throwOnFailure(r14);
            com.larus.photopicker.v2.impl.data.d r8 = r7;
            Collection r9 = r6;
            Iterator r10 = r5;
            Long r11 = r2;
            Object r3 = r0;
            C00921 r4 = this;
        L27:
            if (r14 != null) goto L29;
            boolean r15 = true;
        L30:
            if (r15 == true) goto L33;
            r11 = null;
        L33:
            if (r11 == null) goto L35;
            r9.add(r11);
        L35:
            C00921 r16 = r4;
            r0 = r3;
            Iterator r12 = r10;
            Collection r13 = r9;
            com.larus.photopicker.v2.impl.data.d r17 = r8;
        L22:
            if (r12.hasNext() == false) goto L36;
            op9.d r18 = (op9.d) r12.next();
            String r19 = r18.a.b.toString();
            Long r20 = Boxing.boxLong(r18.a.a);
            r20.longValue();
            r16.L$0 = r17;
            r16.L$1 = r13;
            r16.L$2 = r12;
            r16.L$3 = r20;
            r16.label = 1;
            Object r21 = r17.a(r19, r16);
            if (r21 != r0) goto L26;
            return r0;
        L26:
            Object r110 = r0;
            r4 = r16;
            r14 = r21;
            r8 = r17;
            r9 = r13;
            r10 = r12;
            r11 = r20;
            r3 = r110;
            goto L27
        L36:
            Set r22 = CollectionsKt.toSet((List) r13);
            if ((true ^ r22.isEmpty()) == false) goto L54;
            int r23 = e0.a;
            e0.d(MediaGalleryLiveDataViewModel.access$getTAG$p(r16.this$0), "Remove inaccessible selections after permission change: " + r22);
            d r24 = r16.this$0.getSelectionManager();
            r24.getClass();
            Intrinsics.checkNotNullParameter(r22, "mediaItemIds");
            if (r22.isEmpty() == true) goto L54;
            Set r25 = (Set) r24.f.getValue();
            if (r25 == null) goto L54;
            ArrayList r26 = new ArrayList();
            Iterator r27 = r25.iterator();
        L46:
            if (r27.hasNext() == false) goto L50;
            Object r28 = r27.next();
            if (r22.contains(Long.valueOf(((op9.d) r28).a.a)) == true) goto L46;
            r26.add(r28);
            goto L46
        L50:
            LinkedHashSet r29 = (LinkedHashSet) CollectionsKt.toCollection(r26, new LinkedHashSet());
            if (r29.size() == r25.size()) goto L54;
            int r30 = e0.a;
            e0.d("SelectionManager", "removeSelectionsByIds: " + r22);
            r24.f.setValue(r29);
            r24.n();
        L54:
            List<MediaTab> r31 = r16.this$0.getUiConfig().a;
            r16.L$0 = null;
            r16.L$1 = null;
            r16.L$2 = null;
            r16.L$3 = null;
            r16.label = 2;
            if (r17.e(r31, r16) != r0) goto L58;
            return r0;
        L29:
            r15 = false;
            goto L30
        L10:
            ResultKt.throwOnFailure(r14);
            com.larus.photopicker.v2.impl.data.d r111 = MediaGalleryLiveDataViewModel.access$getMediaRepository$p(this.this$0);
            if (r111 == null) goto L13;
            Set r32 = (Set) this.this$0.getSelectionManager().g.getValue();
            if (r32 == null) goto L17;
            List r33 = CollectionsKt.toList(r32);
        L18:
            if (r33 != null) goto L20;
            r33 = CollectionsKt.emptyList();
        L20:
            r17 = r111;
            r13 = new ArrayList();
            r16 = this;
            r12 = r33.iterator();
            goto L22
        L17:
            r33 = null;
            goto L18
        L13:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$removeSelectionByPredicate$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$removeSelectionByPredicate$1", f = "MediaGalleryLiveDataViewModel.kt", i = {0}, l = {237}, m = "invokeSuspend", n = {"targetItem"}, s = {"L$0"})
    public static final class C00931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<op9.d, Unit> $onRemoved;
        final /* synthetic */ Function1<op9.d, Boolean> $predicate;
        Object L$0;
        int label;
        final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

        /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$removeSelectionByPredicate$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$removeSelectionByPredicate$1$1", f = "MediaGalleryLiveDataViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ op9.c $curFolder;
            final /* synthetic */ List<op9.d> $selectedSnapshot;
            final /* synthetic */ op9.d $targetItem;
            int label;
            final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

            public C00041(MediaGalleryLiveDataViewModel r1, op9.c r2, op9.d r3, List<op9.d> r4, Continuation<? super C00041> r5) {
                this.this$0 = r1;
                this.$curFolder = r2;
                this.$targetItem = r3;
                this.$selectedSnapshot = r4;
                super(2, r5);
            }

            public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
                return new C00041(this.this$0, this.$curFolder, this.$targetItem, this.$selectedSnapshot, r8);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r11) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L17;
                ResultKt.throwOnFailure(r11);
                List r12 = (List) MediaGalleryLiveDataViewModel.access$get_folders$p(this.this$0).getValue();
                if (r12 == null) goto L14;
                op9.c r0 = this.$curFolder;
                MediaGalleryLiveDataViewModel r1 = this.this$0;
                op9.d r2 = this.$targetItem;
                List<op9.d> r3 = this.$selectedSnapshot;
                Iterator r13 = r12.iterator();
            L8:
                if (r13.hasNext() == false) goto L23;
                op9.c r4 = (op9.c) r13.next();
                if (r4.a == r0.a) goto L8;
                MediaGalleryLiveDataViewModel.access$refreshCurFolderSelectedStatus(r1, r4, r2, false, r3);
                MediaGalleryLiveDataViewModel.access$refreshFolderSelectableByType(r1, r4);
                goto L8
            L23:
                return Unit.INSTANCE;
            L14:
                return null;
            L17:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C00931(MediaGalleryLiveDataViewModel r1, Function1<? super op9.d, Boolean> r2, Function1<? super op9.d, Unit> r3, Continuation<? super C00931> r4) {
            this.this$0 = r1;
            this.$predicate = r2;
            this.$onRemoved = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C00931(this.this$0, this.$predicate, this.$onRemoved, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            op9.d r2 = (op9.d) this.L$0;
            ResultKt.throwOnFailure(r11);
        L37:
            Function1<op9.d, Unit> r12 = this.$onRemoved;
            if (r12 == null) goto L41;
            r12.invoke(r2);
        L41:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            Set r13 = (Set) this.this$0.getSelectionManager().g.getValue();
            if (r13 == null) goto L12;
            List r14 = CollectionsKt.toList(r13);
            if (r14 == null) goto L12;
        L13:
            Function1<op9.d, Boolean> r3 = this.$predicate;
            Iterator r15 = r14.iterator();
        L15:
            if (r15.hasNext() == false) goto L19;
            Object r4 = r15.next();
            if (((Boolean) r3.invoke(r4)).booleanValue() == false) goto L15;
        L20:
            op9.d r16 = (op9.d) r4;
            if (r16 == null) goto L23;
            op9.c r6 = (op9.c) MediaGalleryLiveDataViewModel.access$get_currentFolder$p(this.this$0).getValue();
            if (r6 == null) goto L27;
            this.this$0.getSelectionManager().l(r16);
            Set r5 = (Set) this.this$0.getSelectionManager().g.getValue();
            if (r5 == null) goto L32;
            List r7 = CollectionsKt.toList(r5);
            if (r7 == null) goto L32;
        L33:
            List r8 = r7;
            MediaGalleryLiveDataViewModel.access$refreshCurFolderSelectedStatus(this.this$0, r6, r16, false, r8);
            MediaGalleryLiveDataViewModel.access$refreshFolderSelectableByType(this.this$0, r6);
            MediaGalleryLiveDataViewModel.access$get_currentFolder$p(this.this$0).postValue(r6);
            CoroutineDispatcher r9 = Dispatchers.getDefault();
            C00041 r10 = new C00041(this.this$0, r6, r16, r8, null);
            this.L$0 = r16;
            this.label = 1;
            if (BuildersKt.withContext(r9, r10, this) != r0) goto L36;
            return r0;
        L36:
            r2 = r16;
        L32:
            r7 = CollectionsKt.emptyList();
            goto L33
        L27:
            return Unit.INSTANCE;
        L23:
            return Unit.INSTANCE;
        L19:
            r4 = null;
        L12:
            r14 = CollectionsKt.emptyList();
            goto L13
        }
    }

    /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$restoreInitialSelection$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$restoreInitialSelection$1", f = "MediaGalleryLiveDataViewModel.kt", i = {0, 0}, l = {190}, m = "invokeSuspend", n = {"repository", "destination$iv$iv"}, s = {"L$0", "L$1"})
    public static final class C00941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Uri> $initialUris;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C00941(MediaGalleryLiveDataViewModel r1, List<? extends Uri> r2, Continuation<? super C00941> r3) {
            this.this$0 = r1;
            this.$initialUris = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C00941(this.this$0, this.$initialUris, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0062 -> B:17:0x0069). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            int r2 = 0;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Iterator r3 = (Iterator) this.L$2;
            Collection r4 = (Collection) this.L$1;
            com.larus.photopicker.v2.impl.data.d r5 = (com.larus.photopicker.v2.impl.data.d) this.L$0;
            ResultKt.throwOnFailure(r13);
            com.larus.photopicker.v2.impl.data.d r6 = r5;
            Collection r7 = r4;
            Iterator r8 = r3;
            Object r9 = r0;
            C00941 r10 = this;
        L17:
            mp9.c r14 = (mp9.c) r13;
            if (r14 == null) goto L40;
            op9.d r15 = op9.e.c(r14, false, 0);
        L22:
            if (r15 == null) goto L24;
            r7.add(r15);
        L24:
            C00941 r16 = r10;
            r0 = r9;
            Iterator r11 = r8;
            Collection r12 = r7;
            com.larus.photopicker.v2.impl.data.d r17 = r6;
        L10:
            if (r11.hasNext() == false) goto L25;
            Uri r18 = (Uri) r11.next();
            if (r17 == null) goto L21;
            String r19 = r18.toString();
            r16.L$0 = r17;
            r16.L$1 = r12;
            r16.L$2 = r11;
            r16.label = 1;
            Object r20 = r17.a(r19, r16);
            if (r20 != r0) goto L16;
            return r0;
        L16:
            Object r110 = r0;
            r10 = r16;
            r13 = r20;
            r6 = r17;
            r7 = r12;
            r8 = r11;
            r9 = r110;
            goto L17
        L21:
            Object r111 = r0;
            r10 = r16;
            r15 = null;
            r6 = r17;
            r7 = r12;
            r8 = r11;
            r9 = r111;
            goto L22
        L25:
            List r21 = (List) r12;
            MediaGalleryLiveDataViewModel.access$setInitialSelectionRestoreCompleted$p(r16.this$0, true);
            d r112 = r16.this$0.getSelectionManager();
            r112.getClass();
            Intrinsics.checkNotNullParameter(r21, "items");
            HashSet r22 = new HashSet();
            ArrayList r23 = new ArrayList();
            Iterator r24 = r21.iterator();
        L27:
            if (r24.hasNext() == false) goto L31;
            Object r25 = r24.next();
            if (r22.add(Long.valueOf(((op9.d) r25).a.a)) == false) goto L27;
            r23.add(r25);
            goto L27
        L31:
            ArrayList r26 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
            Iterator r27 = r23.iterator();
        L33:
            if (r27.hasNext() == false) goto L38;
            Object r28 = r27.next();
            int r113 = r2 + 1;
            if (r2 >= 0) goto L37;
            CollectionsKt.throwIndexOverflow();
        L37:
            r26.add(op9.d.a((op9.d) r28, null, true, r113, false, 25));
            r2 = r113;
            goto L33
        L38:
            r112.f.setValue((LinkedHashSet) CollectionsKt.toCollection(r26, new LinkedHashSet()));
            r112.n();
            return Unit.INSTANCE;
        L40:
            r10 = r10;
            r15 = null;
            r6 = r6;
            r7 = r7;
            r8 = r8;
            r9 = r9;
            goto L22
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            com.larus.photopicker.v2.impl.data.d r114 = MediaGalleryLiveDataViewModel.access$getMediaRepository$p(this.this$0);
            List<Uri> r29 = this.$initialUris;
            r12 = new ArrayList();
            r11 = r29.iterator();
            r17 = r114;
            r16 = this;
            goto L10
        }
    }

    /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$setSelectionImmediately$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$setSelectionImmediately$1", f = "MediaGalleryLiveDataViewModel.kt", i = {}, l = {466}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ op9.c $curFolder;
        final /* synthetic */ op9.d $curSelectedMediaItem;
        final /* synthetic */ boolean $isSelected;
        final /* synthetic */ List<op9.d> $selectedSnapshot;
        int label;
        final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

        /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$setSelectionImmediately$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$setSelectionImmediately$1$1", f = "MediaGalleryLiveDataViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ op9.c $curFolder;
            final /* synthetic */ op9.d $curSelectedMediaItem;
            final /* synthetic */ boolean $isSelected;
            final /* synthetic */ List<op9.d> $selectedSnapshot;
            int label;
            final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

            public C00051(MediaGalleryLiveDataViewModel r1, op9.c r2, op9.d r3, boolean r4, List<op9.d> r5, Continuation<? super C00051> r6) {
                this.this$0 = r1;
                this.$curFolder = r2;
                this.$curSelectedMediaItem = r3;
                this.$isSelected = r4;
                this.$selectedSnapshot = r5;
                super(2, r6);
            }

            public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
                return new C00051(this.this$0, this.$curFolder, this.$curSelectedMediaItem, this.$isSelected, this.$selectedSnapshot, r9);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r12) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L16;
                ResultKt.throwOnFailure(r12);
                List r13 = (List) MediaGalleryLiveDataViewModel.access$get_folders$p(this.this$0).getValue();
                if (r13 == null) goto L14;
                op9.c r0 = this.$curFolder;
                MediaGalleryLiveDataViewModel r1 = this.this$0;
                op9.d r2 = this.$curSelectedMediaItem;
                boolean r3 = this.$isSelected;
                List<op9.d> r4 = this.$selectedSnapshot;
                Iterator r14 = r13.iterator();
            L8:
                if (r14.hasNext() == false) goto L14;
                op9.c r5 = (op9.c) r14.next();
                if (r5.a == r0.a) goto L8;
                MediaGalleryLiveDataViewModel.access$refreshCurFolderSelectedStatus(r1, r5, r2, r3, r4);
                MediaGalleryLiveDataViewModel.access$refreshFolderSelectableByType(r1, r5);
            L14:
                return Unit.INSTANCE;
            L16:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C00951(MediaGalleryLiveDataViewModel r1, op9.c r2, op9.d r3, boolean r4, List<op9.d> r5, Continuation<? super C00951> r6) {
            this.this$0 = r1;
            this.$curFolder = r2;
            this.$curSelectedMediaItem = r3;
            this.$isSelected = r4;
            this.$selectedSnapshot = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new C00951(this.this$0, this.$curFolder, this.$curSelectedMediaItem, this.$isSelected, this.$selectedSnapshot, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            CoroutineDispatcher r12 = Dispatchers.getDefault();
            C00051 r2 = new C00051(this.this$0, this.$curFolder, this.$curSelectedMediaItem, this.$isSelected, this.$selectedSnapshot, null);
            this.label = 1;
            if (BuildersKt.withContext(r12, r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$updateForceSinglePick$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$updateForceSinglePick$1", f = "MediaGalleryLiveDataViewModel.kt", i = {0}, l = {400}, m = "invokeSuspend", n = {"keep"}, s = {"L$0"})
    public static final class C00961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $forceSinglePick;
        Object L$0;
        int label;
        final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

        /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$updateForceSinglePick$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$updateForceSinglePick$1$2", f = "MediaGalleryLiveDataViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ op9.c $curFolder;
            final /* synthetic */ List<op9.d> $selectedSnapshot;
            int label;
            final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

            public AnonymousClass2(MediaGalleryLiveDataViewModel r1, op9.c r2, List<op9.d> r3, Continuation<? super AnonymousClass2> r4) {
                this.this$0 = r1;
                this.$curFolder = r2;
                this.$selectedSnapshot = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new AnonymousClass2(this.this$0, this.$curFolder, this.$selectedSnapshot, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r10) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L20;
                ResultKt.throwOnFailure(r10);
                List r11 = (List) MediaGalleryLiveDataViewModel.access$get_folders$p(this.this$0).getValue();
                if (r11 == null) goto L17;
                op9.c r0 = this.$curFolder;
                List<op9.d> r1 = this.$selectedSnapshot;
                MediaGalleryLiveDataViewModel r2 = this.this$0;
                Iterator r12 = r11.iterator();
            L8:
                if (r12.hasNext() == false) goto L26;
                op9.c r3 = (op9.c) r12.next();
                if (r3.a == r0.a) goto L8;
                Iterator<T> r4 = r1.iterator();
            L14:
                if (r4.hasNext() == false) goto L8;
                MediaGalleryLiveDataViewModel.access$refreshCurFolderSelectedStatus(r2, r3, (op9.d) r4.next(), false, 0);
                goto L14
            L26:
                return Unit.INSTANCE;
            L17:
                return null;
            L20:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C00961(MediaGalleryLiveDataViewModel r1, boolean r2, Continuation<? super C00961> r3) {
            this.this$0 = r1;
            this.$forceSinglePick = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C00961(this.this$0, this.$forceSinglePick, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            op9.d r2 = (op9.d) this.L$0;
            ResultKt.throwOnFailure(r10);
        L31:
            op9.d r3 = r2;
        L32:
            d r11 = this.this$0.getSelectionManager();
            r11.getClass();
            e0.d("SelectionManager", "clearSelection");
            r11.f.setValue(new LinkedHashSet());
            r11.h.setValue(Boolean.TRUE);
            this.this$0.toggleSelection(r3);
        L39:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            MediaGalleryLiveDataViewModel r12 = this.this$0;
            r12.setUiConfig(MediaGalleryUIConfig.a(r12.getUiConfig(), 0, this.$forceSinglePick, null, -9));
            Set r13 = (Set) this.this$0.getSelectionManager().g.getValue();
            if (r13 == null) goto L11;
            List r14 = CollectionsKt.toList(r13);
        L12:
            if (r14 != null) goto L15;
            r14 = CollectionsKt.emptyList();
        L15:
            if (this.$forceSinglePick == true) goto L17;
            Integer r15 = MediaGalleryLiveDataViewModel.access$getMaxSelectCountBeforeForceSingle$p(this.this$0);
            if (r15 == null) goto L36;
            int r16 = r15.intValue();
        L37:
            MediaGalleryLiveDataViewModel.access$setMaxSelectCountBeforeForceSingle$p(this.this$0, null);
            this.this$0.getSelectionManager().m(r16);
            goto L39
        L36:
            r16 = this.this$0.getUiConfig().c;
            goto L37
        L17:
            if (MediaGalleryLiveDataViewModel.access$getMaxSelectCountBeforeForceSingle$p(this.this$0) != null) goto L19;
            MediaGalleryLiveDataViewModel r4 = this.this$0;
            MediaGalleryLiveDataViewModel.access$setMaxSelectCountBeforeForceSingle$p(r4, Boxing.boxInt(r4.getUiConfig().c));
        L19:
            this.this$0.getSelectionManager().m(1);
            if (r14.size() <= 1) goto L39;
            r3 = (op9.d) CollectionsKt.last(r14);
            op9.c r5 = (op9.c) MediaGalleryLiveDataViewModel.access$get_currentFolder$p(this.this$0).getValue();
            if (r5 == null) goto L32;
            MediaGalleryLiveDataViewModel r7 = this.this$0;
            Iterator r6 = r14.iterator();
        L25:
            if (r6.hasNext() == false) goto L27;
            MediaGalleryLiveDataViewModel.access$refreshCurFolderSelectedStatus(r7, r5, (op9.d) r6.next(), false, 0);
            goto L25
        L27:
            MediaGalleryLiveDataViewModel.access$get_currentFolder$p(this.this$0).postValue(r5);
            CoroutineDispatcher r8 = Dispatchers.getDefault();
            AnonymousClass2 r9 = new AnonymousClass2(this.this$0, r5, r14, null);
            this.L$0 = r3;
            this.label = 1;
            if (BuildersKt.withContext(r8, r9, this) != r0) goto L30;
            return r0;
        L30:
            r2 = r3;
            goto L31
        L11:
            r14 = null;
            goto L12
        }
    }

    public static /* synthetic */ Unit Mo(MediaGalleryLiveDataViewModel r0, MediaGalleryUIConfig r1, List r2) {
        return init$lambda$9(r0, r1, r2);
    }

    public static /* synthetic */ boolean yo(Uri r0, op9.d r1) {
        return removeSelectionByUri$lambda$14(r0, r1);
    }

    public final boolean canShowTabs() {
        if (this.uiConfig.a.size() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void closeTitleFolderEntrance() {
        this.closeTitleFolder.setValue(Boolean.TRUE);
    }

    public final List<Uri> initialSelectionUris() {
        g r0 = g.a;
        InputDraftSnapshot r1 = g.d(this.uiConfig.t);
        if (r1 == null) goto L5;
        List<AttachmentSnapshot> r2 = r1.getAttachments();
    L6:
        if (r2 != null) goto L8;
        r2 = CollectionsKt.emptyList();
    L8:
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L33;
        AttachmentSnapshot r5 = (AttachmentSnapshot) r4.next();
        String r6 = r5.getExtra().get("preview_attachment_source_media_uri");
        boolean r7 = true;
        if (r6 != null) goto L14;
    L19:
        ResourceRef r8 = r5.effectiveRef();
        if (r8 != null) goto L22;
    L30:
        r6 = null;
    L31:
        if (r6 == null) goto L10;
        r3.add(r6);
        goto L10
    L22:
        if (r8.getKind() == ResourceRefKind.LOCAL_URI) goto L25;
        r7 = false;
    L25:
        if (r7 == true) goto L28;
        r8 = null;
    L28:
        if (r8 == null) goto L30;
        r6 = r8.getUri();
        goto L31
    L14:
        if ((!StringsKt.isBlank(r6)) == true) goto L17;
        r6 = null;
    L17:
        if (r6 == null) goto L19;
    L33:
        List r9 = CollectionsKt.plus(r3, this.uiConfig.v);
        ArrayList r10 = new ArrayList();
        Iterator r11 = r9.iterator();
    L35:
        if (r11.hasNext() == false) goto L48;
        String r12 = (String) r11.next();
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L39
        Object r14 = Result.constructor-impl(UriProtector.parse(r12));     // Catch: Throwable -> L39
    L42:
        if (Result.isFailure-impl(r14) == false) goto L44;
        r14 = null;
    L44:
        Uri r15 = (Uri) r14;
        if (r15 == null) goto L35;
        r10.add(r15);
    L39:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L42
    L48:
        return CollectionsKt.distinct(r10);
    L5:
        r2 = null;
        goto L6
    }

    public final void setFirstFolder() {
        List r0 = (List) this._folders.getValue();
        if (r0 == null) goto L12;
        op9.c r1 = (op9.c) CollectionsKt.firstOrNull(r0);
        if (r1 == null) goto L13;
        int r2 = e0.a;
        String r3 = this.TAG;
        StringBuilder r4 = new StringBuilder("setFirstFolder: ");
        mp9.b r5 = r1.b;
        if (r5 == null) goto L9;
        String r6 = r5.b;
    L10:
        r4.append(r6);
        e0.d(r3, r4.toString());
        refreshFolderSelectableByType(r1);
        this._currentFolder.setValue(r1);
        return;
    L9:
        r6 = null;
        goto L10
    L13:
        return;
    }

    public MediaGalleryLiveDataViewModel() {
        this.TAG = "MediaGalleryLiveDataViewModel";
        this.uiConfig = MediaGalleryUIConfig.G.a();
        this.nonUiSettings = MediaNonUISettings.f;
        this.lazyLoadConfig = LazyLoadConfig.e;
        MutableLiveData<List<op9.c>> r0 = new MutableLiveData(CollectionsKt.emptyList());
        this._folders = r0;
        this.folders = r0;
        MutableLiveData<op9.c> r1 = new MutableLiveData();
        this._currentFolder = r1;
        this.currentFolder = r1;
        this.currentTab = MediaTab.ALL;
        MutableLiveData<List<op9.d>> r2 = new MutableLiveData();
        this._fastMediaItems = r2;
        this.fastMediaItems = r2;
        this.enterPreviewPageEntryMode = EntryMode.INIT;
        this.showPreviewFragment = new MutableLiveData();
        this.currentPreviewItems = new MutableLiveData();
        this.enterOrExitPreviewPage = new MutableLiveData();
        this.capturePositionViewRect = new MutableLiveData();
        this.closeTitleFolder = new MutableLiveData();
        this.selectionManager = new d();
        this.initialSelectionRestoreCompleted = true;
    }

    private final void restoreInitialSelection() {
        List<Uri> r0 = initialSelectionUris();
        if (r0.isEmpty() == false) goto L6;
        this.initialSelectionRestoreCompleted = true;
        return;
    L6:
        this.initialSelectionRestoreCompleted = false;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C00941(this, r0, null), 3, null);
    }

    public final void clearSelection() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final void initMediaFolders() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C00901(this, null), 3, null);
    }

    public final void refreshMediaFoldersAfterPermissionChange() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C00921(this, null), 3, null);
    }

    public final MutableLiveData<op9.a> getCapturePositionViewRect() {
        return this.capturePositionViewRect;
    }

    public final MutableLiveData<Boolean> getCloseTitleFolder() {
        return this.closeTitleFolder;
    }

    public final int getCurPreviewPosition() {
        return this.curPreviewPosition;
    }

    public final LiveData<op9.c> getCurrentFolder() {
        return this.currentFolder;
    }

    public final MutableLiveData<List<op9.d>> getCurrentPreviewItems() {
        return this.currentPreviewItems;
    }

    public final MediaTab getCurrentTab() {
        return this.currentTab;
    }

    public final MutableLiveData<Pair<Boolean, Integer>> getEnterOrExitPreviewPage() {
        return this.enterOrExitPreviewPage;
    }

    public final EntryMode getEnterPreviewPageEntryMode() {
        return this.enterPreviewPageEntryMode;
    }

    public final LiveData<List<op9.d>> getFastMediaItems() {
        return this.fastMediaItems;
    }

    public final LiveData<List<op9.c>> getFolders() {
        return this.folders;
    }

    public final LazyLoadConfig getLazyLoadConfig() {
        return this.lazyLoadConfig;
    }

    public final MediaNonUISettings getNonUiSettings() {
        return this.nonUiSettings;
    }

    public final d getSelectionManager() {
        return this.selectionManager;
    }

    public final MutableLiveData<Boolean> getShowPreviewFragment() {
        return this.showPreviewFragment;
    }

    public final MediaGalleryUIConfig getUiConfig() {
        return this.uiConfig;
    }

    public final boolean isInitialSelectionRestoreCompleted() {
        return this.initialSelectionRestoreCompleted;
    }

    public final boolean isInjectInputMode() {
        return this.injectInputMode;
    }

    public final boolean isNeedAnimWhenEnterPreview() {
        return this.isNeedAnimWhenEnterPreview;
    }

    public static final /* synthetic */ MediaTab access$getCurrentTab$p(MediaGalleryLiveDataViewModel r0) {
        return r0.currentTab;
    }

    public static final /* synthetic */ Integer access$getMaxSelectCountBeforeForceSingle$p(MediaGalleryLiveDataViewModel r0) {
        return r0.maxSelectCountBeforeForceSingle;
    }

    public static final /* synthetic */ com.larus.photopicker.v2.impl.data.d access$getMediaRepository$p(MediaGalleryLiveDataViewModel r0) {
        return r0.mediaRepository;
    }

    public static final /* synthetic */ String access$getTAG$p(MediaGalleryLiveDataViewModel r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ MutableLiveData access$get_currentFolder$p(MediaGalleryLiveDataViewModel r0) {
        return r0._currentFolder;
    }

    public static final /* synthetic */ MutableLiveData access$get_fastMediaItems$p(MediaGalleryLiveDataViewModel r0) {
        return r0._fastMediaItems;
    }

    public static final /* synthetic */ MutableLiveData access$get_folders$p(MediaGalleryLiveDataViewModel r0) {
        return r0._folders;
    }

    private final List<op9.d> buildFastUIMediaItems(List<mp9.c> r13) {
        if (r13.isEmpty() == true) goto L5;
        Set r0 = (Set) this.selectionManager.g.getValue();
        if (r0 == null) goto L16;
        Set r1 = r0;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r2 = r1.iterator();
        int r4 = 0;
    L10:
        if (r2.hasNext() == false) goto L15;
        Object r5 = r2.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        r3.add(TuplesKt.to(Long.valueOf(((op9.d) r5).a.a), Integer.valueOf(r6)));
        r4 = r6;
        goto L10
    L15:
        Map r7 = MapsKt.toMap(r3);
    L17:
        if (r7 != null) goto L19;
        r7 = MapsKt.emptyMap();
    L19:
        List<mp9.c> r14 = r13;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r15 = r14.iterator();
    L21:
        if (r15.hasNext() == false) goto L30;
        mp9.c r9 = (mp9.c) r15.next();
        Integer r10 = (Integer) r7.get(Long.valueOf(r9.a));
        if (r10 == null) goto L25;
        int r11 = r10.intValue();
    L26:
        if (r11 <= 0) goto L28;
        boolean r12 = true;
    L29:
        op9.d r16 = op9.e.c(r9, r12, r11);
        r8.add(op9.d.a(r16, null, false, 0, this.selectionManager.f(r16), 15));
        goto L21
    L28:
        r12 = false;
        goto L29
    L25:
        r11 = 0;
        goto L26
    L30:
        return r8;
    L16:
        r7 = null;
        goto L17
    L5:
        return CollectionsKt.emptyList();
    }

    private final void refreshFolderSelectableByType(op9.c r13) {
        Iterator<T> r0 = this.uiConfig.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L19;
        MediaTab r1 = (MediaTab) r0.next();
        List<op9.d> r2 = r13.c.get(r1);
        if (r2 == null) goto L4;
        if (r2.isEmpty() == true) goto L4;
        List<op9.d> r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
        boolean r6 = false;
    L12:
        if (r5.hasNext() == false) goto L17;
        op9.d r7 = (op9.d) r5.next();
        boolean r10 = this.selectionManager.f(r7);
        if (r7.e == r10) goto L16;
        r7 = op9.d.a(r7, null, false, 0, r10, 15);
        r6 = true;
    L16:
        r4.add(r7);
        goto L12
    L17:
        if (r6 == false) goto L4;
        r13.c.put(r1, r4);
        goto L4
    }

    public final int getCurMediaItemPositionInPreview(op9.d r10) {
        Intrinsics.checkNotNullParameter(r10, "mediaItem");
        List r0 = (List) this.currentPreviewItems.getValue();
        if (r0 == null) goto L14;
        Iterator r1 = r0.iterator();
        int r3 = 0;
    L6:
        if (r1.hasNext() == false) goto L18;
        if (((op9.d) r1.next()).a.a != r10.a.a) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L17;
        r3 = r3 + 1;
        goto L6
    L17:
        return r3;
    L10:
        r4 = false;
        goto L11
    L18:
        return -1;
    L14:
        return -1;
    }

    public final void initFastMediaItems(long r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C00891(this, r7, null), 3, null);
    }

    public final boolean insertMediaItemAndSelect(mp9.c r19) {
        Intrinsics.checkNotNullParameter(r19, "mediaItem");
        List r2 = (List) this._folders.getValue();
        if (r2 == null) goto L102;
        op9.c r3 = (op9.c) CollectionsKt.firstOrNull(r2);
        if (r3 == null) goto L102;
        long r4 = r3.a;
        op9.c r5 = (op9.c) this._currentFolder.getValue();
        if (r5 != null) goto L9;
    L11:
        boolean r6 = false;
    L12:
        if (r6 == true) goto L14;
        setFirstFolder();
    L14:
        MediaTab r7 = (MediaTab) CollectionsKt.firstOrNull(this.uiConfig.a);
        if (r7 != null) goto L17;
        r7 = MediaTab.ALL;
    L17:
        op9.c r8 = (op9.c) this._currentFolder.getValue();
        if (r8 != null) goto L20;
        return false;
    L20:
        List<op9.d> r9 = r8.c.get(r7);
        if (r9 != null) goto L23;
        r9 = CollectionsKt.emptyList();
    L23:
        Iterator<T> r10 = r9.iterator();
    L24:
        Object r11 = null;
        if (r10.hasNext() == false) goto L35;
        Object r12 = r10.next();
        mp9.c r13 = ((op9.d) r12).a;
        if (r13.a != r19.a) goto L29;
    L32:
        boolean r14 = true;
    L33:
        if (r14 == false) goto L24;
    L36:
        op9.d r15 = (op9.d) r12;
        if (r15 != null) goto L39;
        com.larus.photopicker.v2.impl.data.d r16 = this.mediaRepository;
        if (r16 != null) goto L45;
        return false;
    L45:
        List<mp9.b> r17 = r16.h(r19);
        if (r17 != null) goto L48;
        return false;
    L48:
        List r18 = (List) this._folders.getValue();
        if (r18 != null) goto L51;
        r18 = CollectionsKt.emptyList();
    L51:
        List<mp9.b> r20 = r17;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r21 = r20.iterator();
    L53:
        if (r21.hasNext() == false) goto L66;
        mp9.b r111 = (mp9.b) r21.next();
        Iterator r112 = r18.iterator();
    L56:
        if (r112.hasNext() == false) goto L64;
        Object r113 = r112.next();
        Iterator r114 = r21;
        if (((op9.c) r113).a != r111.a) goto L60;
        boolean r22 = true;
    L61:
        if (r22 == true) goto L65;
        r21 = r114;
    L65:
        r110.add(op9.e.b(r111, (op9.c) r113, this.selectionManager));
        r21 = r114;
        goto L53
    L60:
        r22 = false;
        goto L61
    L64:
        r114 = r21;
        r113 = null;
        goto L65
    L66:
        this._folders.setValue(r110);
        Iterator r23 = r110.iterator();
    L68:
        if (r23.hasNext() == false) goto L75;
        Object r24 = r23.next();
        if (((op9.c) r24).a != r4) goto L72;
        boolean r25 = true;
    L73:
        if (r25 == false) goto L68;
    L76:
        op9.c r26 = (op9.c) r24;
        if (r26 != null) goto L80;
        return true;
    L80:
        this._currentFolder.setValue(r26);
        List<op9.d> r27 = r26.c.get(r7);
        if (r27 != null) goto L83;
        r27 = CollectionsKt.emptyList();
    L83:
        Iterator<T> r28 = r27.iterator();
    L85:
        if (r28.hasNext() == false) goto L95;
        Object r29 = r28.next();
        mp9.c r30 = ((op9.d) r29).a;
        if (r30.a != r19.a) goto L89;
    L92:
        boolean r31 = true;
    L93:
        if (r31 == false) goto L85;
        r11 = r29;
        goto L95
    L89:
        if (Intrinsics.areEqual(r30.b, r19.b) == true) goto L92;
        r31 = false;
    L95:
        op9.d r32 = (op9.d) r11;
        if (r32 != null) goto L98;
        return true;
    L98:
        if (this.selectionManager.g(r32.a.a) == true) goto L123;
        toggleSelection(r32);
        return true;
    L123:
        return true;
    L72:
        r25 = false;
        goto L73
    L75:
        r24 = null;
        goto L76
    L39:
        if (this.selectionManager.g(r15.a.a) == true) goto L41;
        toggleSelection(r15);
    L41:
        return true;
    L29:
        if (Intrinsics.areEqual(r13.b, r19.b) == true) goto L32;
        r14 = false;
        goto L33
    L35:
        r12 = null;
        goto L36
    L9:
        if (r5.a != r4) goto L11;
        r6 = true;
    L102:
        return false;
    }

    public final void loadMore(MediaTab r11) {
        Intrinsics.checkNotNullParameter(r11, "mediaTab");
        int r0 = e0.a;
        String r1 = this.TAG;
        StringBuilder r2 = new StringBuilder("1.loadMore curFolder: ");
        op9.c r3 = (op9.c) this._currentFolder.getValue();
        if (r3 == null) goto L7;
        mp9.b r4 = r3.b;
        if (r4 == null) goto L7;
        String r5 = r4.b;
    L8:
        r2.append(r5);
        r2.append(", curTab: ");
        r2.append(this.currentTab);
        r2.append(", curMediaTab: ");
        r2.append(r11);
        r2.append(", curMediaList: ");
        op9.c r6 = (op9.c) this._currentFolder.getValue();
        if (r6 == null) goto L15;
        Map<MediaTab, List<op9.d>> r7 = r6.c;
        if (r7 == null) goto L15;
        List<op9.d> r8 = r7.get(this.currentTab);
        if (r8 == null) goto L15;
        Integer r9 = Integer.valueOf(r8.size());
    L16:
        r2.append(r9);
        e0.d(r1, r2.toString());
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C00911(this, r11, null), 3, null);
        return;
    L15:
        r9 = null;
    L7:
        r5 = null;
        goto L8
    }

    public final void setAllowReplaceWhenSingle(boolean r4) {
        d r0 = this.selectionManager;
        r0.getClass();
        int r1 = e0.a;
        e0.d("SelectionManager", "setAllowReplaceWhenSingle: enable: " + r4);
        r0.l = r4;
        if (r4 == false) goto L6;
        r0.h.setValue(Boolean.TRUE);
        return;
    }

    public final void setCurPreviewPosition(int r1) {
        this.curPreviewPosition = r1;
    }

    public final void setCurrentFolder(long r7) {
        List r0 = (List) this._folders.getValue();
        if (r0 == null) goto L26;
        Iterator r1 = r0.iterator();
    L5:
        String r2 = null;
        if (r1.hasNext() == false) goto L13;
        Object r3 = r1.next();
        if (((op9.c) r3).a != r7) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L5;
    L14:
        op9.c r5 = (op9.c) r3;
        if (r5 == null) goto L27;
        int r8 = e0.a;
        String r9 = this.TAG;
        StringBuilder r10 = new StringBuilder("setCurrentFolder: ");
        mp9.b r6 = r5.b;
        if (r6 == null) goto L19;
        r2 = r6.b;
    L19:
        r10.append(r2);
        e0.d(r9, r10.toString());
        refreshFolderSelectableByType(r5);
        this._currentFolder.setValue(r5);
        return;
    L27:
        return;
    L10:
        r4 = false;
        goto L11
    L13:
        r3 = null;
        goto L14
    }

    public final void setCurrentTab(MediaTab r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        this.currentTab = r2;
    }

    public final void setEnterPreviewPageEntryMode(EntryMode r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterPreviewPageEntryMode = r2;
    }

    public final void setInjectInputMode(boolean r1) {
        this.injectInputMode = r1;
    }

    public final void setLazyLoadConfig(LazyLoadConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.lazyLoadConfig = r2;
    }

    public final void setNeedAnimWhenEnterPreview(boolean r1) {
        this.isNeedAnimWhenEnterPreview = r1;
    }

    public final void setNonUiSettings(MediaNonUISettings r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.nonUiSettings = r2;
    }

    public final void setUiConfig(MediaGalleryUIConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.uiConfig = r2;
    }

    public final void toggleSelection(op9.d r4) {
        Intrinsics.checkNotNullParameter(r4, "curSelectedMediaItem");
        setSelectionImmediately(r4, !this.selectionManager.g(r4.a.a));
    }

    public final void updateForceSinglePick(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C00961(this, r7, null), 3, null);
    }

    public final void updateMaxSelectCount(int r5) {
        MediaGalleryUIConfig r0 = MediaGalleryUIConfig.a(this.uiConfig, r5, false, null, -5);
        this.uiConfig = r0;
        if (r0.d == false) goto L5;
        this.maxSelectCountBeforeForceSingle = Integer.valueOf(r5);
        this.selectionManager.m(1);
    L6:
        op9.c r6 = (op9.c) this._currentFolder.getValue();
        if (r6 == null) goto L10;
        refreshFolderSelectableByType(r6);
        this._currentFolder.setValue(r6);
        return;
    L10:
        return;
    L5:
        this.selectionManager.m(r5);
        goto L6
    }

    public static final /* synthetic */ List access$buildFastUIMediaItems(MediaGalleryLiveDataViewModel r0, List r1) {
        return r0.buildFastUIMediaItems(r1);
    }

    public static final /* synthetic */ void access$refreshFolderSelectableByType(MediaGalleryLiveDataViewModel r0, op9.c r1) {
        r0.refreshFolderSelectableByType(r1);
    }

    public static final /* synthetic */ void access$setInitialSelectionRestoreCompleted$p(MediaGalleryLiveDataViewModel r0, boolean r1) {
        r0.initialSelectionRestoreCompleted = r1;
    }

    public static final /* synthetic */ void access$setMaxSelectCountBeforeForceSingle$p(MediaGalleryLiveDataViewModel r0, Integer r1) {
        r0.maxSelectCountBeforeForceSingle = r1;
    }

    private final void removeSelectionByPredicate(Function1<? super op9.d, Boolean> r7, Function1<? super op9.d, Unit> r8) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C00931(this, r7, r8, null), 3, null);
    }

    private static final boolean removeSelectionByUri$lambda$14(Uri r1, op9.d r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        if (Intrinsics.areEqual(r2.a.b, r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r2.a.b.toString(), r1.toString()) == true) goto L8;
        return false;
    }

    public final void enterPreviewMediaPage(op9.d r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "mediaItem");
        op9.c r0 = (op9.c) this._currentFolder.getValue();
        List<op9.d> r1 = null;
        if (r0 == null) goto L7;
        Map<MediaTab, List<op9.d>> r2 = r0.c;
        if (r2 == null) goto L7;
        List<op9.d> r3 = r2.get(this.currentTab);
    L8:
        if (r3 != null) goto L10;
        r3 = CollectionsKt.emptyList();
    L10:
        List<op9.d> r4 = (List) this._fastMediaItems.getValue();
        if (r4 != null) goto L14;
        r4 = CollectionsKt.emptyList();
    L14:
        if ((!r3.isEmpty()) == false) goto L16;
        List<op9.d> r5 = r3;
    L17:
        if (r5 == null) goto L19;
        r1 = r5;
    L22:
        List<op9.d> r6 = r1;
        if (r6 != null) goto L25;
    L28:
        boolean r9 = true;
    L29:
        if (r9 == false) goto L33;
        int r10 = e0.a;
        e0.c(this.TAG, "enterPreviewMediaPage preview list is null or empty, position: " + r8);
        return;
    L33:
        if (r3.isEmpty() == false) goto L35;
        int r11 = e0.a;
        e0.d(this.TAG, "enterPreviewMediaPage fallback fastMediaItems, position=" + r8 + ", fastSize=" + r4.size());
        reportCurrentFolderNotReady("enter_preview", r7, r4.size());
    L35:
        this.enterPreviewPageEntryMode = EntryMode.NORMAL;
        this.currentPreviewItems.setValue(r1);
        this.curPreviewPosition = resolvePreviewPosition(r1, r7, r8);
        this.isNeedAnimWhenEnterPreview = true;
        this.showPreviewFragment.setValue(Boolean.TRUE);
        return;
    L25:
        if (r6.isEmpty() == true) goto L28;
        r9 = false;
        goto L29
    L19:
        if ((!r4.isEmpty()) == false) goto L22;
        r1 = r4;
        goto L22
    L16:
        r5 = null;
    L7:
        r3 = null;
        goto L8
    }

    public final void enterPreviewMediaPageFromBottomSelector(op9.d r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "mediaItem");
        Set r5 = (Set) this.selectionManager.g.getValue();
        if (r5 == null) goto L6;
        List r6 = CollectionsKt.toList(r5);
        if (r6 == null) goto L6;
    L8:
        if (r6.isEmpty() == false) goto L11;
        int r7 = e0.a;
        e0.c(this.TAG, "enterPreviewMediaPageFromBottomSelector preview list is null or empty, position: " + r4);
        return;
    L11:
        this.enterPreviewPageEntryMode = EntryMode.BOTTOM;
        this.currentPreviewItems.setValue(r6);
        this.curPreviewPosition = r4;
        this.isNeedAnimWhenEnterPreview = true;
        this.showPreviewFragment.setValue(Boolean.TRUE);
        return;
    L6:
        r6 = CollectionsKt.emptyList();
        goto L8
    }

    public final Object queryMediaItem(String r2, Continuation<? super mp9.c> r3) {
        com.larus.photopicker.v2.impl.data.d r0 = this.mediaRepository;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r2, r3);
    }

    public final void removeSelectionByUri(final Uri r2, Function1<? super op9.d, Unit> r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r2, Uri.EMPTY) == true) goto L9;
        removeSelectionByPredicate(new com.larus.photopicker.v2.impl.viewmodel.a(r2), r3);
        return;
    }

    public final boolean setSelectionImmediately(op9.d r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r16, "curSelectedMediaItem");
        if (this.selectionManager.g(r16.a.a) != r17) goto L6;
        return true;
    L6:
        if (r17 == true) goto L8;
    L10:
        boolean r4 = this.selectionManager.l(r16);
        if (r4 == r17) goto L13;
        return false;
    L13:
        Set r0 = (Set) this.selectionManager.g.getValue();
        if (r0 == null) goto L16;
        List<op9.d> r1 = CollectionsKt.toList(r0);
    L17:
        if (r1 != null) goto L19;
        r1 = CollectionsKt.emptyList();
    L19:
        List<op9.d> r5 = r1;
        op9.c r2 = (op9.c) this._currentFolder.getValue();
        if (r2 != null) goto L26;
        refreshFastMediaSelectedStatus(r16, r4, r5);
        List r3 = (List) this._fastMediaItems.getValue();
        if (r3 != null) goto L24;
        r3 = CollectionsKt.emptyList();
    L24:
        reportCurrentFolderNotReady("set_selection_immediately", r16, r3.size());
        return true;
    L26:
        refreshCurFolderSelectedStatus(r2, r16, r4, r5);
        refreshFolderSelectableByType(r2);
        this._currentFolder.setValue(r2);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C00951(this, r2, r16, r4, r5, null), 3, null);
        return true;
    L16:
        r1 = null;
        goto L17
    L8:
        if (this.selectionManager.a(r16) == true) goto L10;
        return false;
    }

    private static final Unit init$lambda$9(MediaGalleryLiveDataViewModel r16, MediaGalleryUIConfig r17, List r18) {
        int r1 = e0.a;
        e0.d(r16.TAG, "1. Repository folder change, total " + r18.size() + " folders");
        List r2 = (List) r16._folders.getValue();
        if (r2 != null) goto L5;
        r2 = CollectionsKt.emptyList();
    L5:
        Object r5 = null;
        if (r2.isEmpty() == false) goto L11;
        e0.d(r16.TAG, "2.1 Full update folders");
        Intrinsics.checkNotNull(r18);
        List r3 = r18;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r6 = r3.iterator();
    L9:
        if (r6.hasNext() == false) goto L58;
        r4.add(op9.e.b((mp9.b) r6.next(), null, r16.selectionManager));
    L58:
        if ((!r4.isEmpty()) == false) goto L83;
        op9.c r7 = (op9.c) r16._currentFolder.getValue();
        if (r7 == null) goto L62;
        long r8 = r7.a;
    L63:
        int r9 = e0.a;
        String r10 = r16.TAG;
        StringBuilder r11 = new StringBuilder("3. [Start]Update current folder=");
        r11.append(r8);
        r11.append(", ");
        op9.c r12 = (op9.c) r16._currentFolder.getValue();
        if (r12 == null) goto L68;
        mp9.b r13 = r12.b;
        if (r13 == null) goto L68;
        String r14 = r13.b;
    L69:
        r11.append(r14);
        e0.d(r10, r11.toString());
        Iterator r15 = r4.iterator();
    L71:
        if (r15.hasNext() == false) goto L78;
        Object r19 = r15.next();
        if (((op9.c) r19).a != r8) goto L75;
        boolean r20 = true;
    L76:
        if (r20 == false) goto L71;
        r5 = r19;
        goto L78
    L75:
        r20 = false;
    L78:
        op9.c r21 = (op9.c) r5;
        if (r21 != null) goto L81;
        int r22 = e0.a;
        e0.c(r16.TAG, "3.2 [End]Update current folder=" + r8 + ", not found, maybe deleted");
        r21 = (op9.c) CollectionsKt.first(r4);
    L81:
        int r23 = e0.a;
        e0.d(r16.TAG, "3.1 [End]Update current folder=" + r8 + ", " + r21.b.b);
        r16.refreshFolderSelectableByType(r21);
        r16._currentFolder.setValue(r21);
        r16._folders.setValue(r4);
    L68:
        r14 = null;
        goto L69
    L62:
        r8 = ((op9.c) CollectionsKt.first(r4)).a;
    L83:
        return Unit.INSTANCE;
    L11:
        e0.d(r16.TAG, "2.2 Diff update folders");
        Intrinsics.checkNotNull(r18);
        List r24 = r18;
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
        Iterator r26 = r24.iterator();
    L13:
        if (r26.hasNext() == false) goto L56;
        mp9.b r27 = (mp9.b) r26.next();
        Iterator r28 = r2.iterator();
    L16:
        if (r28.hasNext() == false) goto L23;
        Object r110 = r28.next();
        if (((op9.c) r110).a != r27.a) goto L20;
        boolean r111 = true;
    L21:
        if (r111 == false) goto L16;
    L24:
        op9.c r112 = (op9.c) r110;
        if (r112 != null) goto L27;
        r112 = op9.e.b(r27, null, r16.selectionManager);
    L55:
        r25.add(r112);
        goto L13
    L27:
        List<MediaTab> r113 = r17.a;
        if ((r113 instanceof Collection) == true) goto L30;
    L32:
        Iterator<T> r114 = r113.iterator();
    L34:
        if (r114.hasNext() == false) goto L52;
        MediaTab r115 = (MediaTab) r114.next();
        List<mp9.c> r116 = r27.f.get(r115);
        if (r116 != null) goto L38;
        r116 = CollectionsKt.emptyList();
    L38:
        List<mp9.c> r117 = r116;
        ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator<T> r119 = r117.iterator();
    L40:
        if (r119.hasNext() == false) goto L42;
        r118.add(Long.valueOf(((mp9.c) r119.next()).a));
        goto L40
    L42:
        List<op9.d> r29 = r112.c.get(r115);
        if (r29 != null) goto L45;
        r29 = CollectionsKt.emptyList();
    L45:
        List<op9.d> r30 = r29;
        ArrayList r31 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r30, 10));
        Iterator<T> r32 = r30.iterator();
    L47:
        if (r32.hasNext() == false) goto L50;
        r31.add(Long.valueOf(((op9.d) r32.next()).a.a));
        goto L47
    L50:
        if ((!Intrinsics.areEqual(r118, r31)) == false) goto L34;
        boolean r33 = true;
    L53:
        if (r33 == false) goto L55;
        r112 = op9.e.b(r27, r112, r16.selectionManager);
    L52:
        r33 = false;
        goto L53
    L30:
        if (r113.isEmpty() == false) goto L32;
    L20:
        r111 = false;
        goto L21
    L23:
        r110 = null;
        goto L24
    L56:
        r4 = r25;
        goto L58
    }

    private final void refreshFastMediaSelectedStatus(op9.d r3, boolean r4, List<op9.d> r5) {
        MutableLiveData<List<op9.d>> r0 = this._fastMediaItems;
        List<op9.d> r1 = (List) r0.getValue();
        if (r1 != null) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        r0.setValue(refreshMediaItemsSelectedStatus(r1, r3, r4, r5));
        List<op9.d> r2 = (List) this.currentPreviewItems.getValue();
        if (r2 != null) goto L8;
        return;
    L8:
        if ((!r2.isEmpty()) == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L15;
        this.currentPreviewItems.setValue(refreshMediaItemsSelectedStatus(r2, r3, r4, r5));
        return;
    }

    private final void reportCurrentFolderNotReady(String r4, op9.d r5, int r6) {
        Lazy r0 = i.a;
        JSONObject r1 = new JSONObject();
        r1.put("is_success", 1);
        r1.put("data_type", "current_folder_not_ready");
        r1.put("action", r4);
        r1.put("fast_media_size", r6);
        r1.put("media_id", r5.a.a);
        r1.put("tab", this.currentTab.getMobName());
        i.b(r1);
    }

    private final int resolvePreviewPosition(List<op9.d> r9, op9.d r10, int r11) {
        Iterator<op9.d> r0 = r9.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L12;
        if (r0.next().a.a != r10.a.a) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L13;
        r2 = r2 + 1;
    L13:
        if (r2 < 0) goto L16;
        return r2;
    L16:
        return RangesKt.coerceIn(r11, 0, CollectionsKt.getLastIndex(r9));
    L8:
        r3 = false;
        goto L9
    L12:
        r2 = -1;
        goto L13
    }

    public static /* synthetic */ void initFastMediaItems$default(MediaGalleryLiveDataViewModel r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = 300;
    L5:
        r0.initFastMediaItems(r1);
    }

    private final void refreshCurFolderSelectedStatus(op9.c r20, op9.d r21, boolean r22, int r23) {
        com.larus.photopicker.v2.impl.data.d r8 = this.mediaRepository;
        if (r8 != null) goto L5;
        return;
    L5:
        Iterator<T> r9 = this.uiConfig.a.iterator();
    L7:
        if (r9.hasNext() == false) goto L21;
        MediaTab r10 = (MediaTab) r9.next();
        List<op9.d> r11 = r20.c.get(r10);
        if (r11 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == true) goto L7;
        int r3 = r8.c(r20.a, r10, r21.a.a);
        if (r3 < 0) goto L7;
        List<op9.d> r4 = CollectionsKt.toMutableList(r11);
        ListProtector.set(r4, r3, op9.d.a((op9.d) ListProtector.get(r4, r3), null, r22, r23, false, 25));
        r20.c.put(r10, r4);
        goto L7
    L11:
        if (r11.isEmpty() == true) goto L14;
        r2 = false;
        goto L15
    }

    private final List<op9.d> refreshMediaItemsSelectedStatus(List<op9.d> r15, op9.d r16, boolean r17, List<op9.d> r18) {
        if (r15.isEmpty() == false) goto L5;
        return r15;
    L5:
        List<op9.d> r0 = r18;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
        int r4 = 0;
    L7:
        if (r2.hasNext() == false) goto L12;
        Object r5 = r2.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        r1.add(TuplesKt.to(Long.valueOf(((op9.d) r5).a.a), Integer.valueOf(r6)));
        r4 = r6;
        goto L7
    L12:
        Map r3 = MapsKt.toMap(r1);
        List<op9.d> r7 = r15;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r9 = r7.iterator();
        boolean r10 = false;
    L14:
        if (r9.hasNext() == false) goto L50;
        op9.d r11 = (op9.d) r9.next();
        Integer r12 = (Integer) r3.get(Long.valueOf(r11.a.a));
        if (r12 == null) goto L18;
        int r13 = r12.intValue();
    L20:
        if (r13 > 0) goto L27;
        if (r11.a.a != r16.a.a) goto L25;
        if (r17 == true) goto L27;
    L25:
        boolean r14 = false;
    L28:
        if (r14 == false) goto L40;
        Integer r19 = Integer.valueOf(r13);
        if (r19.intValue() <= 0) goto L32;
        boolean r20 = true;
    L33:
        if (r20 == true) goto L36;
        r19 = null;
    L36:
        if (r19 == null) goto L38;
        int r21 = r19.intValue();
    L39:
        int r22 = r21;
    L41:
        boolean r110 = this.selectionManager.f(r11);
        if (r11.b == r14) goto L44;
    L47:
        r11 = op9.d.a(r11, null, r14, r22, r110, 9);
        r10 = true;
    L48:
        r8.add(r11);
        goto L14
    L44:
        if (r11.c != r22) goto L47;
        if (r11.e == r110) goto L48;
    L38:
        r21 = r18.size();
        goto L39
    L32:
        r20 = false;
        goto L33
    L40:
        r22 = 0;
    L27:
        r14 = true;
        goto L28
    L18:
        r13 = 0;
        goto L20
    L50:
        if (r10 == false) goto L53;
        return r8;
    L53:
        return r15;
    }

    /* JADX WARN: Type inference failed for: r10v5, types: [com.larus.photopicker.v2.impl.viewmodel.b] */
    public final void init(com.larus.photopicker.v2.impl.data.d r9, LazyLoadConfig r10, final MediaGalleryUIConfig r11, MediaNonUISettings r12) {
        Intrinsics.checkNotNullParameter(r9, "mediaRepository");
        Intrinsics.checkNotNullParameter(r10, "lazyLoadConfig");
        Intrinsics.checkNotNullParameter(r11, "uiConfig");
        Intrinsics.checkNotNullParameter(r12, "nonUiSettings");
        this.mediaRepository = r9;
        this.lazyLoadConfig = r10;
        this.uiConfig = r11;
        this.nonUiSettings = r12;
        Iterator<T> r13 = r11.a.iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        Object r0 = r13.next();
        if (((MediaTab) r0).getId() != r11.F) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L4;
    L12:
        MediaTab r2 = (MediaTab) r0;
        if (r2 != null) goto L17;
        r2 = (MediaTab) CollectionsKt.firstOrNull(r11.a);
        if (r2 != null) goto L17;
        r2 = MediaTab.ALL;
    L17:
        this.currentTab = r2;
        d r14 = this.selectionManager;
        int r3 = r11.c;
        boolean r4 = r11.g;
        boolean r5 = r12.a;
        int r6 = r12.b;
        CreationReferenceAlbumConfig r7 = r12.c;
        long r8 = r12.d;
        r14.getClass();
        int r15 = e0.a;
        e0.d("SelectionManager", "init: maxSelectCount: " + r3 + ", isSupportVideo: " + r4 + ", enableSeparateMediaSelection: " + r5 + ", maxSelectVideoCount: " + r6 + ", maxVideoDuration: " + r8);
        r14.a = r3;
        r14.b = r4;
        r14.c = r5;
        r14.d = r6;
        r14.m = r7;
        r14.e = r8;
        r14.n();
        restoreInitialSelection();
        r9.g().observeForever(new a(new b(this, r11)));
        return;
    L8:
        r1 = false;
        goto L9
    L11:
        r0 = null;
        goto L12
    }

    private final void refreshCurFolderSelectedStatus(op9.c r2, op9.d r3, boolean r4, List<op9.d> r5) {
        int r0 = 0;
        if (r4 == true) goto L5;
        refreshCurFolderSelectedStatus(r2, r3, false, 0);
    L5:
        Iterator<T> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L12;
        Object r7 = r6.next();
        int r8 = r0 + 1;
        if (r0 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        refreshCurFolderSelectedStatus(r2, (op9.d) r7, true, r8);
        r0 = r8;
        goto L7
    }

    public static final /* synthetic */ void access$refreshCurFolderSelectedStatus(MediaGalleryLiveDataViewModel r0, op9.c r1, op9.d r2, boolean r3, int r4) {
        r0.refreshCurFolderSelectedStatus(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void removeSelectionByPredicate$default(MediaGalleryLiveDataViewModel r0, Function1 r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.removeSelectionByPredicate(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void removeSelectionByUri$default(MediaGalleryLiveDataViewModel r0, Uri r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.removeSelectionByUri(r1, r2);
    }

    public static final /* synthetic */ void access$refreshCurFolderSelectedStatus(MediaGalleryLiveDataViewModel r0, op9.c r1, op9.d r2, boolean r3, List r4) {
        r0.refreshCurFolderSelectedStatus(r1, r2, r3, r4);
    }
}
