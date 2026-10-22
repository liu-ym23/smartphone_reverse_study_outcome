package com.larus.uaigc.instruction;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.CreationReferenceMediaType;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.actionbar.model.VideoUploadInfo;
import com.larus.bmhome.actionbar.model.f2;
import com.larus.bmhome.actionbar.model.l1;
import com.larus.bmhome.actionbar.model.w0;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.bmhome.view.resourcebar.bean.ItemStatus;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AudioResource;
import com.larus.platform.api.creation.Resource;
import com.larus.platform.api.creation.VideoResource;
import com.larus.platform.creation.CreationMultiReferenceLogEvent;
import com.larus.platform.model.creation.ResourceExt;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.bean.createpage.component.mediacontainer.CreationReferenceAttachmentType;
import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.larus.uaigc.helper.CreationImageUploadPolicy;
import com.larus.uaigc.impl.databinding.LarusLayoutActionBarEditorWidgetAttachmentSelectorBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import ic8.m0;
import ic8.n0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.GroupingKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;
import tx9.l3;
import v19.i5;
import wa8.d1;
import wa8.g1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u009a\u00012\u00020\u0001:\u0002\u009a\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010$\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\"\u0010(\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020%H\u0002J\b\u0010-\u001a\u00020%H\u0002J\b\u0010.\u001a\u00020%H\u0002J\b\u0010/\u001a\u00020%H\u0002J\b\u00100\u001a\u00020%H\u0002J\b\u00101\u001a\u00020%H\u0002J\u0010\u00102\u001a\u00020%2\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020%2\u0006\u00103\u001a\u000204H\u0002J\b\u00106\u001a\u0004\u0018\u000107J\u0006\u00108\u001a\u000209J\b\u0010:\u001a\u0004\u0018\u00010+J\u0016\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0013j\b\u0012\u0004\u0012\u00020\u000b`\u0015J\u0018\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020?0>0=J\u0018\u0010@\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0013j\b\u0012\u0004\u0012\u00020\u000b`\u0015H\u0002J\b\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020%H\u0016J\b\u0010D\u001a\u00020%H\u0002J\u0016\u0010E\u001a\u00020%2\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010GJ\u0018\u0010I\u001a\u00020%2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010GH\u0002J\u001e\u0010K\u001a\u00020%2\u0006\u0010L\u001a\u00020H2\u0006\u0010M\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020%H\u0002J \u0010P\u001a\u00020%2\u000e\u0010Q\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010G2\u0006\u0010S\u001a\u00020BH\u0002J>\u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020R2\u0006\u0010S\u001a\u00020B2\u0006\u0010V\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020B2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00140YH\u0002J\u0010\u0010Z\u001a\u00020B2\u0006\u0010[\u001a\u00020\u0014H\u0002J\u0016\u0010\\\u001a\u00020%2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00140GH\u0002J\f\u0010]\u001a\u00020^*\u000209H\u0002J\u0018\u0010_\u001a\u00020%2\u000e\u0010`\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010GH\u0002J\u0018\u0010a\u001a\u00020%2\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020c\u0018\u00010GH\u0002J\u0010\u0010d\u001a\u00020B2\u0006\u0010e\u001a\u00020\u000bH\u0002J\b\u0010f\u001a\u00020\u0014H\u0002J\n\u0010g\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010h\u001a\u00020\u000bH\u0002J\u008d\u0001\u0010i\u001a\u0086\u0001\u0012\u0004\u0012\u00020\u000b\u00128\u00126\u0012\u0013\u0012\u00110\u0011¢\u0006\f\bl\u0012\b\bm\u0012\u0004\b\b(n\u0012\u0013\u0012\u00110o¢\u0006\f\bl\u0012\b\bm\u0012\u0004\b\b(p\u0012\u0004\u0012\u00020q0kj\u0002`r0jjB\u0012\u0004\u0012\u00020\u000b\u00128\u00126\u0012\u0013\u0012\u00110\u0011¢\u0006\f\bl\u0012\b\bm\u0012\u0004\b\b(n\u0012\u0013\u0012\u00110o¢\u0006\f\bl\u0012\b\bm\u0012\u0004\b\b(p\u0012\u0004\u0012\u00020q0kj\u0002`r`sH\u0002J<\u0010t\u001a6\u0012\u0013\u0012\u00110\u0011¢\u0006\f\bl\u0012\b\bm\u0012\u0004\b\b(n\u0012\u0013\u0012\u00110o¢\u0006\f\bl\u0012\b\bm\u0012\u0004\b\b(p\u0012\u0004\u0012\u00020q0kj\u0002`rH\u0002J\b\u0010u\u001a\u00020vH\u0002J\u0018\u0010w\u001a\u00020%2\u0006\u0010x\u001a\u00020+2\u0006\u0010y\u001a\u00020zH\u0002J&\u0010{\u001a\u00020%2\b\b\u0002\u0010|\u001a\u00020B2\b\b\u0002\u0010}\u001a\u00020\u000b2\b\b\u0002\u0010~\u001a\u00020BH\u0002J\u0018\u0010\u007f\u001a\u00020%2\u0006\u0010x\u001a\u00020+2\u0006\u0010y\u001a\u00020zH\u0002J\u0019\u0010\u0080\u0001\u001a\u00020%2\u0006\u0010x\u001a\u00020+2\u0006\u0010y\u001a\u00020zH\u0002J\t\u0010\u0081\u0001\u001a\u00020%H\u0002J\f\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0002J\t\u0010\u0084\u0001\u001a\u00020\u000bH\u0002J\u0012\u0010\u0085\u0001\u001a\u00020\u000b2\u0007\u0010\u0086\u0001\u001a\u00020BH\u0002J\t\u0010\u0087\u0001\u001a\u00020\u000bH\u0002J\u0011\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001*\u00030\u008a\u0001H\u0002J\u0019\u0010\u008b\u0001\u001a\u00020%2\u0006\u0010x\u001a\u00020+2\u0006\u0010y\u001a\u00020zH\u0002J\u0019\u0010\u008c\u0001\u001a\u00020%2\u0006\u0010x\u001a\u00020+2\u0006\u0010y\u001a\u00020zH\u0002J\t\u0010\u008d\u0001\u001a\u00020%H\u0002J\t\u0010\u008e\u0001\u001a\u00020%H\u0002J\t\u0010\u008f\u0001\u001a\u00020%H\u0002J\t\u0010\u0090\u0001\u001a\u00020%H\u0002J\t\u0010\u0091\u0001\u001a\u00020%H\u0002J\u0019\u0010\u0092\u0001\u001a\u00020%2\u0006\u0010x\u001a\u00020+2\u0006\u0010y\u001a\u00020zH\u0002J\u0007\u0010\u0093\u0001\u001a\u00020%J\r\u0010\u0094\u0001\u001a\u00020B*\u00020\u0014H\u0002J\u000f\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140GH\u0002J-\u0010\u0096\u0001\u001a\u00020\u0014*\u00020\u00142\u000b\b\u0002\u0010\u0097\u0001\u001a\u0004\u0018\u00010+2\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010BH\u0002¢\u0006\u0003\u0010\u0099\u0001R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006\u009b\u0001"}, d2 = {"Lcom/larus/uaigc/instruction/MultiAttachmentSelectorWidget;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "controller", "Lcom/larus/uaigc/instruction/MultiAttachmentSelectorController;", "getController", "()Lcom/larus/uaigc/instruction/MultiAttachmentSelectorController;", "creationUploadPicNumber", "", "getCreationUploadPicNumber", "()I", "resourceBarOperator", "Lcom/larus/bmhome/view/resourcebar/bean/IResourceItemOperator;", "resourceConfig", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "resourceItemList", "Ljava/util/ArrayList;", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "Lkotlin/collections/ArrayList;", "multiAttachmentSelectorAbility", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMultiAttachmentSelectorAbility;", "creationEditorAbility", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "argumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "hitPointData", "Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "binding", "Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetAttachmentSelectorBinding;", "currentCreationReferenceCapabilityState", "Lcom/larus/bmhome/actionbar/model/CreationReferenceCapabilityState;", "getCurrentCreationReferenceCapabilityState", "()Lcom/larus/bmhome/actionbar/model/CreationReferenceCapabilityState;", "init", "", "attrs", "Landroid/util/AttributeSet;", "findResourceItem", "Lkotlin/Pair;", "resourceKey", "", "registerOnClearAndSetPassedImageUrlListRegister", "registerOnAlbumResult", "autoSelectOriginalRatio", "registerUpdateUIStateHandler", "registerOnUploadAvatarImage", "registerOnDeleteAvatarImage", "bindFragment", "fragment", "Landroidx/fragment/app/Fragment;", "initParams", "getCurrentNestedFileContent", "Lcom/larus/im/bean/message/NestedFileContent;", "getCreationReferenceAttachmentSnapshot", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachmentSnapshot;", "getCurrentNestedFileLocalMessageId", "getCurrentAvatarSubscriptIndex", "getAllAttachmentLiveDataStatus", "Landroidx/lifecycle/LiveData;", "", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/MultiMediaSelectorStatus;", "getToolsResourceItemIndex", "hasAvatarItem", "", "onBindView", "buildResourceBarItems", "setPassedImageAlbumPaths", "list", "", "Landroid/net/Uri;", "handlePassedImageAlbumPathsToResourceItems", "passedImageAlbumPaths", "handlePassedImageAlbumPathToResourceItem", "uri", "mediaMaxNum", "(Landroid/net/Uri;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finishPassedImageAlbumPathsRestore", "handlePassedImageUrlListToResourceItems", "passUrlImageList", "Lcom/larus/platform/model/creation/ResourceExt;", "isPrivate", "handlePassedImageUrlToResourceItem", "resource", "serverOrder", "isPrefilledImage", "restoredItems", "", "canRestorePassedResource", "resourceItem", "finishPassedImageUrlRestore", "toCreationMultiReferenceLogSummary", "Lcom/larus/platform/creation/CreationMultiReferenceLogSummary;", "handlePassedAvatarImageUrlListToResourceItems", "passAvatarImageUrlList", "handleAttachmentListToResourceItems", "attachmentList", "Lcom/larus/bmhome/actionbar/model/MediaAttachment;", "checkAndHandleAvatarAttachments", "index", "buildAddHolderBean", "buildPlaceHolderBean", "getMediaMaxNum", "createCustomRenderMap", "Ljava/util/HashMap;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "config", "Landroid/view/ViewGroup;", "parent", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder;", "Lcom/larus/bmhome/view/resourcebar/bean/CustomResourceViewHolderBuilder;", "Lkotlin/collections/HashMap;", "createCustomEmptyResourceViewHolderBuilder", "createBaseResourceCallback", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder$Callback;", "handleClickAvatar", "key", "v", "Landroid/view/View;", "handleOpenAlbumCore", "forceSelectSingle", "replaceIndex", "isReplace", "handleClickOpen", "handleClickPlaceholder", "mobSlidesGenerateImage", "getSlidesMobConfig", "Lcom/larus/platform/model/slides/SlidesMobConfig;", "getCurrentNum", "getCurrentVideoNum", "countsAvatarAsVideo", "getCurrentImageNum", "toCreationReferenceMediaType", "Lcom/larus/bmhome/actionbar/model/CreationReferenceMediaType;", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceType;", "handleClickReUpLink", "handleClickEventRemove", "handleResourceItemCountChange", "setRealResourceIndex", "setSubscriptVisible", "checkFirstRefItemVisible", "tryRefreshFirstRefItem", "handleClickEventAdd", "fillAttachmentList", "isToolsItem", "getRealRefImgItem", "clone", "newKey", "newShowSubscription", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MultiAttachmentSelectorWidget extends AbsInstructionWidget {
    public static final /* synthetic */ int m = 0;
    public mt8.a f;
    public ResourceBarConfig g;
    public final ArrayList<ResourceItemBean> h;
    public ry9.h i;
    public ys8.a j;
    public ny9.s k;
    public LarusLayoutActionBarEditorWidgetAttachmentSelectorBinding l;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ResourceType.values().length];
            r0[ResourceType.VIDEO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ResourceType.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ResourceType.AVATAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ResourceType.AUDIO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c implements Grouping<CreationReferenceMediaType, CreationReferenceMediaType> {
        public final /* synthetic */ Iterable a;

        public final Iterator<CreationReferenceMediaType> sourceIterator() {
            return this.a.iterator();
        }

        public c(Iterable r1) {
            this.a = r1;
        }

        public final CreationReferenceMediaType keyOf(CreationReferenceMediaType r1) {
            return r1;
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

    static {
    }

    public static ResourceItemBean V6() {
        return new ResourceItemBean(null, null, null, null, null, null, 0, null, false, ResourceType.ADD, 0, 0, 0, 0, false, false, false, false, 0, null, 1048063, null);
    }

    private final int getCreationUploadPicNumber() {
        return l3.e(PollingConfigService.a.f("cre_upl_pic_num"), 0);
    }

    private final w0 getCurrentCreationReferenceCapabilityState() {
        ys8.a r0 = this.j;
        if (r0 == null) goto L7;
        w0 r1 = r0.yn();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return w0.b.a;
    }

    private final int getCurrentImageNum() {
        ArrayList<ResourceItemBean> r0 = this.h;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<ResourceItemBean> r1 = r0.iterator();
        int r2 = 0;
    L9:
        if (r1.hasNext() == false) goto L21;
        ResourceItemBean r3 = r1.next();
        if (C7(r3) == false) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == false) goto L9;
        r2 = r2 + 1;
        if (r2 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L13:
        if (r3.getResourceType() != ResourceType.IMAGE) goto L15;
        r4 = true;
        goto L16
    L21:
        return r2;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return 0;
    }

    private final int getCurrentNum() {
        Iterator<ResourceItemBean> r0 = this.h.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L10;
        ResourceItemBean r2 = r0.next();
        if (C7(r2) == true) goto L4;
        if (r2.getResourceType() == ResourceType.AVATAR) goto L4;
        r1 = r1 + 1;
        goto L4
    L10:
        return r1;
    }

    private final List<ResourceItemBean> getRealRefImgItem() {
        ArrayList<ResourceItemBean> r0 = this.h;
        ArrayList r1 = new ArrayList();
        Iterator<ResourceItemBean> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        ResourceItemBean r3 = r2.next();
        ResourceItemBean r4 = r3;
        if (C7(r4) == false) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        if (ResourceType.AVATAR == r4.getResourceType()) goto L10;
        r5 = true;
        goto L11
    L13:
        return r1;
    }

    private final lr9.a getSlidesMobConfig() {
        ny9.s r0 = this.k;
        if (r0 == null) goto L7;
        Bundle r1 = r0.a;
        if (r1 == null) goto L7;
        String r2 = r1.getString("slides_mob_config", "");
    L8:
        if (r2 != null) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == false) goto L17;
        return null;
    L17:
        return (lr9.a) GsonProtectorUtils.fromJson(new Gson(), r2, lr9.a.class);
    L10:
        if (r2.length() == 0) goto L13;
        r3 = false;
    L7:
        r2 = null;
        goto L8
    }

    private final ArrayList<Integer> getToolsResourceItemIndex() {
        ArrayList<Integer> r0 = new ArrayList();
        Iterator<ResourceItemBean> r1 = this.h.iterator();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L12;
        ResourceItemBean r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (C7(r3) == false) goto L11;
        r0.add(Integer.valueOf(r2));
    L11:
        r2 = r4;
        goto L4
    L12:
        CollectionsKt.sortDescending(r0);
        return r0;
    }

    public final void E7() {
        ny9.s r1 = this.k;
        String r2 = null;
        if (r1 == null) goto L5;
        Bundle r3 = r1.a;
    L6:
        if (r3 == null) goto L8;
        String r4 = r3.getString("open_from", "");
    L10:
        if (Intrinsics.areEqual(r4, "slides") == false) goto L35;
        lr9.a r5 = getSlidesMobConfig();
        if (r5 == null) goto L14;
        String r18 = r5.e();
    L15:
        if (r5 == null) goto L17;
        String r19 = r5.f();
    L18:
        if (r5 == null) goto L20;
        Integer r20 = r5.g();
    L21:
        if (r5 == null) goto L23;
        String r21 = r5.b();
    L24:
        if (r5 == null) goto L27;
        Integer r6 = r5.c();
        if (r6 == null) goto L27;
    L29:
        Integer r22 = r6;
    L31:
        if (r5 == null) goto L33;
        r2 = r5.a();
    L33:
        tx9.c0.H(null, "image_generate_page", null, null, null, "aippt_new_detail", null, null, null, null, null, null, null, 0, r18, r19, r20, r21, r22, r2, "aippt_new", null, null, 31473629);
        return;
    L27:
        if (r5 == null) goto L30;
        r6 = r5.g();
        goto L29
    L30:
        r22 = null;
        goto L31
    L23:
        r21 = null;
        goto L24
    L20:
        r20 = null;
        goto L21
    L17:
        r19 = null;
        goto L18
    L14:
        r18 = null;
        goto L15
    L35:
        return;
    L8:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void H7() {
        Iterator<T> r0 = this.h.iterator();
    L3:
        boolean r2 = true;
        if (r0.hasNext() == false) goto L6;
        ((ResourceItemBean) r0.next()).setShowSubscriptView(true);
        goto L3
    L6:
        List<ResourceItemBean> r1 = getRealRefImgItem();
        if ((!r1.isEmpty()) == false) goto L15;
        ResourceItemBean r3 = (ResourceItemBean) ListProtector.get(r1, 0);
        if (r1.size() != 1) goto L12;
        r2 = false;
    L12:
        r3.setShowSubscriptView(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y5() {
        HashMap r6 = new HashMap();
        r6.put(Integer.valueOf(ResourceType.CUSTOM.getValue()), new c0(this));
        boolean r3 = false;
        this.g = new ResourceBarConfig(Mode.EDIT, false, 0, 0, r6, null, 44, null);
        this.f = InputViewCreatorDelegate.b.e(getContext());
        LarusLayoutActionBarEditorWidgetAttachmentSelectorBinding r1 = this.l;
        boolean r4 = true;
        if (r1 == null) goto L23;
        r1.c.removeAllViews();
        FrameLayout r5 = r1.c;
        mt8.a r7 = this.f;
        if (r7 == null) goto L7;
        View r8 = r7.getView();
    L8:
        r5.addView(r8);
        com.larus.bmhome.actionbar.model.u r9 = getInstructionItem();
        if (r9 == null) goto L11;
        boolean r10 = Intrinsics.areEqual(r9.f, Boolean.TRUE);
    L12:
        if (r10 == true) goto L22;
        y r11 = getController();
        if (r11 != null) goto L16;
    L18:
        boolean r12 = false;
    L19:
        if (r12 == true) goto L22;
        e1.o(r1.b);
        goto L23
    L16:
        if (r11.w != true) goto L18;
        r12 = true;
    L22:
        e1.x(r1.b);
        goto L23
    L11:
        r10 = false;
        goto L12
    L7:
        r8 = null;
    L23:
        ResourceBarConfig r2 = this.g;
        if (r2 == null) goto L280;
        y r13 = getController();
        if (r13 == null) goto L28;
        com.larus.bmhome.actionbar.model.v r14 = r13.l;
    L29:
        if (r14 == null) goto L31;
        List r15 = r14.c;
    L32:
        if (r15 != null) goto L34;
    L36:
        boolean r16 = false;
    L37:
        y r17 = getController();
        if (r17 == null) goto L44;
        ArrayList<ResourceExt> r18 = r17.o;
        if (r18 == null) goto L44;
        if ((!r18.isEmpty()) != true) goto L44;
        boolean r19 = true;
    L45:
        y r20 = getController();
        if (r20 == null) goto L52;
        ArrayList<String> r21 = r20.q;
        if (r21 == null) goto L52;
        if ((!r21.isEmpty()) != true) goto L52;
        boolean r22 = true;
    L53:
        y r23 = getController();
        if (r23 == null) goto L60;
        ArrayList<Uri> r24 = r23.s;
        if (r24 == null) goto L60;
        if ((!r24.isEmpty()) != true) goto L60;
        boolean r25 = true;
    L62:
        if (this.h.isEmpty() == false) goto L68;
        if (r16 == true) goto L68;
        if (r19 == true) goto L68;
        if (r25 == true) goto L68;
        if (r22 == true) goto L68;
        boolean r110 = true;
    L69:
        if (r110 == false) goto L73;
        ResourceItemBean r26 = W6();
        if (r26 == null) goto L277;
        this.h.add(r26);
    L277:
        mt8.a r27 = this.f;
        if (r27 == null) goto L280;
        r27.b(r2, this.h, new e0(this));
        goto L280
    L73:
        if (r16 == false) goto L218;
        if (r15 == null) goto L215;
        Iterator r28 = r15.iterator();
        int r29 = 0;
    L77:
        if (r28.hasNext() == false) goto L215;
        Object r111 = r28.next();
        int r112 = r29 + 1;
        if (r29 >= 0) goto L81;
        CollectionsKt.throwIndexOverflow();
    L81:
        MediaAttachment r113 = (MediaAttachment) r111;
        if (getCurrentNum() < getMediaMaxNum()) goto L84;
    L83:
        r28 = r28;
    L214:
        r29 = r112;
        r28 = r28;
        r4 = true;
        goto L77
    L84:
        y r114 = getController();
        if (r114 == null) goto L87;
        ArrayList<Integer> r115 = r114.r;
    L88:
        if (r115 != null) goto L90;
    L92:
        boolean r116 = false;
    L93:
        if (r116 == true) goto L96;
    L118:
        boolean r30 = false;
    L119:
        if (r30 == true) goto L83;
        Intrinsics.checkNotNullParameter(r113, "<this>");
        if (r113.getImageUploadInfo() != null) goto L124;
        Image r117 = null;
    L136:
        Intrinsics.checkNotNullParameter(r113, "<this>");
        VideoUploadInfo r31 = r113.getVideoUploadInfo();
        if (r31 != null) goto L139;
        r28 = r28;
        mt8.b r37 = null;
    L175:
        String r32 = UUID.randomUUID().toString();
        ItemStatus r39 = ItemStatus.UPLINKING;
        if (r37 == null) goto L178;
        ResourceType r33 = ResourceType.VIDEO;
    L179:
        ResourceItemBean r34 = new ResourceItemBean(r32, null, "", "", r117, r37, 0, r39, false, r33, i5.w0(), 0, 0, 0, false, false, false, false, 0, null, 1046786, null);
        this.h.add(r34);
        ry9.h r35 = this.i;
        if (r35 == null) goto L183;
        r35.ew(r34);
    L183:
        if (r34.getResourceType() != ResourceType.VIDEO) goto L187;
        ry9.h r36 = this.i;
        if (r36 == null) goto L214;
        r36.Ke(r32, r113, false);
        goto L214
    L187:
        if (r117 == null) goto L192;
        ImageObj r38 = r117.imageThumb;
        if (r38 == null) goto L192;
        String r40 = r38.url;
        if (r40 == null) goto L192;
    L193:
        y r41 = getController();
        if (r41 == null) goto L198;
        HashMap<String, String> r42 = r41.p;
        if (r42 == null) goto L198;
        String r210 = r42.get(r40);
    L199:
        ry9.h r43 = this.i;
        if (r43 == null) goto L214;
        String r44 = r113.getIdentifier();
        if (r44 != null) goto L204;
        String r211 = "";
    L205:
        String r45 = r113.getResourceId();
        if (r45 != null) goto L208;
        String r212 = "";
    L209:
        String r46 = r113.getLocalFilePath();
        if (r46 != null) goto L212;
        String r213 = "";
    L213:
        ry9.h.a.b(r43, r32, r40, r211, r212, r213, false, false, r210, 96);
        goto L214
    L212:
        r213 = r46;
        goto L213
    L208:
        r212 = r45;
        goto L209
    L204:
        r211 = r44;
    L198:
        r210 = null;
    L192:
        r40 = "";
        goto L193
    L178:
        r33 = ResourceType.IMAGE;
        goto L179
    L139:
        f2 r118 = r31.getCover();
        if (r118 == null) goto L142;
        String r119 = r118.b;
    L143:
        if (r119 == null) goto L152;
        PolarisFileWrapper r47 = new PolarisFileWrapper(r119);
        if (r119.length() <= 0) goto L147;
        boolean r120 = true;
    L148:
        if (r120 == false) goto L152;
        if (r47.exists() == false) goto L152;
        ImFileUtil.a.getClass();
        String r121 = ImFileUtil.g(r47);
    L153:
        String r122 = UUID.randomUUID().toString();
        if (r118 == null) goto L156;
        String r310 = r118.a;
    L157:
        Image r48 = new Image(r122, r121, new ImageObj(r310, 0, 0, null, null, 30, null), null, null, r119, null, null, null, null, null, null, null, null, 16344, null);
        VideoUploadInfo r49 = r113.getVideoUploadInfo();
        if (r49 == null) goto L162;
        Double r50 = r49.getDuration();
        if (r50 == null) goto L162;
        float r410 = (float) r50.doubleValue();
    L163:
        String r411 = r113.getLocalFilePath();
        if (r118 == null) goto L168;
        Integer r51 = r118.d;
        if (r51 == null) goto L168;
        int r412 = r51.intValue();
    L169:
        if (r118 == null) goto L173;
        Integer r52 = r118.c;
        if (r52 == null) goto L173;
        int r413 = r52.intValue();
    L174:
        r37 = new mt8.b(r48, r410, r412, r413, r411, r31.getVid(), "", null, null, 384);
    L173:
        r413 = 0;
    L168:
        r412 = 0;
    L162:
        r410 = 0.0f;
        goto L163
    L156:
        r310 = null;
        goto L157
    L147:
        r120 = false;
    L152:
        r121 = "";
        goto L153
    L142:
        r119 = null;
        goto L143
    L124:
        String r123 = r113.getLocalFilePath();
        if (r123 == null) goto L134;
        PolarisFileWrapper r124 = new PolarisFileWrapper(r123);
        if (r123.length() <= 0) goto L129;
        boolean r125 = true;
    L130:
        if (r125 == false) goto L134;
        if (r124.exists() == false) goto L134;
        ImFileUtil.a.getClass();
        String r126 = ImFileUtil.g(r124);
    L135:
        r117 = new Image(UUID.randomUUID().toString(), r126, new ImageObj(r113.getUrl(), 0, 0, null, null, 30, null), null, null, r113.getLocalFilePath(), r113.getIdentifier(), null, null, null, null, null, null, null, 16280, null);
        goto L136
    L129:
        r125 = false;
    L134:
        r126 = "";
        goto L135
    L96:
        if (r115.contains(Integer.valueOf(r29)) == false) goto L118;
        DigitalAvatarInfoManager.a.getClass();
        if (DigitalAvatarInfoManager.i() == false) goto L105;
        String r53 = DigitalAvatarInfoManager.e();
        if (r53 == null) goto L111;
        ry9.h r127 = this.i;
        if (r127 == null) goto L111;
        r127.JZ(r53);
    L111:
        ys8.a r54 = this.j;
        if (r54 == null) goto L114;
        r54.wr(false);
    L114:
        com.larus.bmhome.view.actionbar.edit.c r55 = getViewModel();
        if (r55 == null) goto L117;
        r55.setChosenAvatarInstructionStatus(r4);
    L117:
        r30 = true;
        goto L119
    L105:
        if (DigitalAvatarInfoManager.h() == false) goto L111;
        String r56 = (String) DigitalAvatarInfoManager.b.getValue();
        if (r56 == null) goto L111;
        ry9.h r128 = this.i;
        if (r128 == null) goto L111;
        r128.JZ(r56);
        goto L111
    L90:
        if ((r115.isEmpty() ^ r4) != r4) goto L92;
        r116 = true;
        goto L93
    L87:
        r115 = null;
    L215:
        com.larus.bmhome.view.actionbar.edit.c r57 = getViewModel();
        if (r57 == null) goto L218;
        r57.setOriginalRatioEnable(true);
    L218:
        if (r22 == false) goto L258;
        y r58 = getController();
        if (r58 == null) goto L222;
        ArrayList<String> r59 = r58.q;
    L223:
        com.larus.bmhome.view.actionbar.edit.c r60 = getViewModel();
        if (r60 == null) goto L228;
        i1 r61 = r60.getInstructionSelectMenuPosition();
        if (r61 == null) goto L228;
        int r62 = ((Number) r61.getValue()).intValue();
    L229:
        ys8.a r63 = this.j;
        if (r63 != null) goto L232;
    L234:
        boolean r64 = false;
    L235:
        if (r64 == false) goto L258;
        int r65 = getMediaMaxNum();
        if (r59 == null) goto L255;
        Iterator<T> r66 = r59.iterator();
        int r67 = 0;
    L241:
        if (r66.hasNext() == false) goto L255;
        Object r68 = r66.next();
        int r69 = r67 + 1;
        if (r67 >= 0) goto L245;
        CollectionsKt.throwIndexOverflow();
    L245:
        String r70 = (String) r68;
        if ((this.h.size() - 1) >= r65) goto L254;
        ry9.h r71 = this.i;
        if (r71 == null) goto L251;
        r71.JZ(r70);
    L251:
        ys8.a r72 = this.j;
        if (r72 == null) goto L254;
        r72.wr(false);
    L254:
        r67 = r69;
    L255:
        com.larus.bmhome.view.actionbar.edit.c r73 = getViewModel();
        if (r73 == null) goto L258;
        r73.setChosenAvatarInstructionStatus(true);
        goto L258
    L232:
        if (r63.dk(r62) != true) goto L234;
        r64 = true;
    L228:
        r62 = 0;
        goto L229
    L222:
        r59 = null;
    L258:
        if (r19 == false) goto L268;
        y r74 = getController();
        if (r74 == null) goto L262;
        ArrayList<ResourceExt> r75 = r74.o;
    L263:
        y r76 = getController();
        if (r76 == null) goto L266;
        boolean r77 = r76.t;
    L267:
        r7(r75, r77);
        goto L268
    L266:
        r77 = false;
        goto L267
    L262:
        r75 = null;
    L268:
        if (r25 == false) goto L276;
        y r78 = getController();
        if (r78 == null) goto L272;
        ArrayList<Uri> r79 = r78.s;
    L273:
        CoroutineScope r80 = getComponentScope();
        if (r80 == null) goto L276;
        BuildersKt.launch$default(r80, null, null, new MultiAttachmentSelectorWidget$handlePassedImageAlbumPathsToResourceItems$1(this, r79, null), 3, null);
        goto L276
    L272:
        r79 = null;
    L276:
        w7();
    L68:
        r110 = false;
    L60:
        r25 = false;
    L52:
        r22 = false;
    L44:
        r19 = false;
        goto L45
    L34:
        if ((!r15.isEmpty()) != true) goto L36;
        r16 = true;
        goto L37
    L31:
        r15 = null;
        goto L32
    L28:
        r14 = null;
    L280:
        y r81 = getController();
        if (r81 != null) goto L283;
    L285:
        if (r3 == false) goto L291;
        LarusLayoutActionBarEditorWidgetAttachmentSelectorBinding r82 = this.l;
        if (r82 == null) goto L307;
        View r83 = r82.d;
        if (r83 == null) goto L308;
        e1.x(r83);
        return;
    L308:
        return;
    L307:
        return;
    L291:
        LarusLayoutActionBarEditorWidgetAttachmentSelectorBinding r84 = this.l;
        if (r84 == null) goto L310;
        View r85 = r84.d;
        if (r85 == null) goto L311;
        e1.o(r85);
        return;
    L311:
        return;
    L310:
        return;
    L283:
        if (r81.v != true) goto L285;
        r3 = true;
        goto L285
    }

    public final LiveData<Map<String, ry9.k>> getAllAttachmentLiveDataStatus() {
        ry9.h r0 = this.i;
        if (r0 == null) goto L7;
        LiveData<Map<String, ry9.k>> r1 = r0.ja();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new MediatorLiveData(MapsKt.emptyMap());
    }

    public final ry9.d getCreationReferenceAttachmentSnapshot() {
        ry9.h r0 = this.i;
        if (r0 == null) goto L7;
        ry9.d r1 = r0.yH(this.h);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ry9.d(0);
    }

    public final ArrayList<Integer> getCurrentAvatarSubscriptIndex() {
        ArrayList<Integer> r0 = new ArrayList();
        Iterator<T> r1 = this.h.iterator();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L12;
        Object r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((ResourceItemBean) r3).getResourceType() != ResourceType.AVATAR) goto L11;
        r0.add(Integer.valueOf(r2));
    L11:
        r2 = r4;
        goto L4
    L12:
        return r0;
    }

    public final NestedFileContent getCurrentNestedFileContent() {
        ry9.h r0 = this.i;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.V20(this.h);
    }

    public final String getCurrentNestedFileLocalMessageId() {
        ry9.h r0 = this.i;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.J6();
    }

    public final boolean y7() {
        ArrayList<ResourceItemBean> r0 = this.h;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L23;
        if (((ResourceItemBean) r1.next()).getResourceType() != ResourceType.AVATAR) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L9;
        return true;
    L13:
        r2 = false;
        goto L14
    L23:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    }

    private final y getController() {
        return (y) getController();
    }

    private final int getMediaMaxNum() {
        w0.a r0 = getCurrentCreationReferenceCapabilityState();
        int r2 = 0;
        if ((r0 instanceof w0.a) == false) goto L9;
        Integer r1 = r0.a.c();
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.intValue();
    L9:
        if (Intrinsics.areEqual(r0, w0.b.a) == false) goto L35;
        ny9.s r3 = this.k;
        if (r3 == null) goto L15;
        Bundle r4 = r3.a;
        if (r4 == null) goto L15;
        String r5 = r4.getString("open_from", "");
    L17:
        if (Intrinsics.areEqual(r5, "slides") == false) goto L30;
        ny9.s r6 = this.k;
        if (r6 == null) goto L26;
        Bundle r7 = r6.a;
        if (r7 == null) goto L26;
        y r8 = getController();
        if (r8 == null) goto L37;
        r2 = r8.n;
    L37:
        return r7.getInt("max_select_image_count", r2);
    L26:
        y r9 = getController();
        if (r9 != null) goto L29;
        return 0;
    L29:
        return r9.n;
    L30:
        y r10 = getController();
        if (r10 != null) goto L33;
        return 0;
    L33:
        return r10.n;
    L15:
        r5 = null;
        goto L17
    L35:
        throw new NoWhenBranchMatchedException();
    }

    public final void G7() {
        Iterator<T> r0 = getRealRefImgItem().iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ((ResourceItemBean) r2).setSubscriptIndex(r3);
        r1 = r3;
        goto L4
    }

    public final void N6() {
        com.larus.bmhome.view.actionbar.edit.c r0 = getViewModel();
        if (r0 == null) goto L59;
        i1 r1 = r0.getInstructionSelectMenuPosition();
        if (r1 == null) goto L60;
        int r2 = ((Number) r1.getValue()).intValue();
        com.larus.bmhome.view.actionbar.edit.c r3 = getViewModel();
        if (r3 == null) goto L61;
        com.larus.bmhome.actionbar.model.r r4 = r3.getCurrentInstructionConf();
        if (r4 == null) goto L62;
        com.larus.bmhome.actionbar.model.y r5 = r4.i;
        if (r5 == null) goto L63;
        ArrayList r6 = r5.a;
        if (r6 == null) goto L64;
        if (r2 >= 0) goto L16;
        return;
    L16:
        if (r2 >= r6.size()) goto L66;
        com.larus.bmhome.actionbar.model.r r7 = ((z0) ListProtector.get(r6, r2)).q;
        Long r8 = null;
        if (r7 == null) goto L20;
        Integer r9 = r7.a;
    L21:
        boolean r10 = true;
        if (r9 != null) goto L25;
    L44:
        if (r9 != null) goto L47;
        return;
    L47:
        if (r9.intValue() != 18) goto L67;
        ys8.a r11 = this.j;
        if (r11 != null) goto L51;
    L53:
        r10 = false;
    L54:
        if (r10 == true) goto L68;
        com.larus.bmhome.view.actionbar.edit.c r12 = getViewModel();
        if (r12 == null) goto L69;
        r12.selectRatio(18, IAIChatUgcAIGCService.a.R());
        return;
    L69:
        return;
    L68:
        return;
    L51:
        if (r11.Wm() != true) goto L53;
    L67:
        return;
    L25:
        if (r9.intValue() != 4) goto L44;
        com.larus.bmhome.view.actionbar.edit.c r13 = getViewModel();
        if (r13 != null) goto L29;
    L31:
        boolean r14 = false;
    L32:
        if (r14 == true) goto L44;
        com.larus.bmhome.view.actionbar.edit.c r15 = getViewModel();
        if (r15 == null) goto L38;
        Map r16 = r15.getSelectedClickRatioIdRegistry();
        if (r16 == null) goto L38;
        r8 = (Long) r16.get(4);
    L38:
        if (r8 != null) goto L40;
    L41:
        com.larus.bmhome.view.actionbar.edit.c r17 = getViewModel();
        if (r17 == null) goto L44;
        r17.selectRatio(4, IAIChatUgcAIGCService.a.R());
        goto L44
    L40:
        if (r8.longValue() != IAIChatUgcAIGCService.a.R()) goto L44;
    L29:
        if (r13.getRatioCanBeEmpty() != true) goto L31;
        r14 = true;
        goto L32
    L20:
        r9 = null;
        goto L21
    L66:
        return;
    L64:
        return;
    L63:
        return;
    L62:
        return;
    L61:
        return;
    L60:
        return;
    }

    public final ResourceItemBean W6() {
        y r0 = getController();
        if (r0 == null) goto L5;
        com.larus.bmhome.actionbar.model.v r1 = r0.l;
    L6:
        if (r1 == null) goto L11;
        l1 r2 = r1.b;
        if (r2 == null) goto L11;
        HashMap r3 = new HashMap();
        r3.put("key_multi_media_placeholder", r2);
        return new ResourceItemBean(null, null, null, null, null, null, 0, null, false, ResourceType.CUSTOM, 0, 0, 0, 0, false, false, false, false, 0, r3, 523775, null);
    L11:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    public final void l7() {
        y r0 = getController();
        if (r0 == null) goto L60;
        com.larus.bmhome.actionbar.model.v r1 = r0.l;
        if (r1 == null) goto L61;
        ArrayList r2 = new ArrayList();
        Iterator<ResourceItemBean> r3 = this.h.iterator();
    L8:
        if (r3.hasNext() == false) goto L40;
        ResourceItemBean r4 = r3.next();
        if (C7(r4) == true) goto L8;
        String r5 = r4.getKey();
        ry9.h r6 = this.i;
        if (r6 == null) goto L8;
        ry9.k r7 = r6.Q00(r5);
        if (r7 == null) goto L8;
        ry9.j r8 = r7.b;
        ry9.i r9 = r8.a();
        if ((r8 instanceof ry9.j.c) == false) goto L8;
        if (r9 == null) goto L8;
        boolean r10 = r9 instanceof ry9.i.a;
        if (r10 == true) goto L23;
        if ((r9 instanceof ry9.i.b) == false) goto L8;
    L23:
        MediaAttachment r11 = null;
        if (r10 == false) goto L26;
        ry9.i.a r12 = (ry9.i.a) r9;
    L28:
        if ((r9 instanceof ry9.i.b) == false) goto L30;
        ry9.i.b r13 = (ry9.i.b) r9;
    L31:
        if (r12 == null) goto L36;
        MediaAttachment r14 = r12.a;
        if (r14 == null) goto L36;
        r11 = r14;
    L38:
        if (r11 == null) goto L8;
        r2.add(r11);
    L36:
        if (r13 == null) goto L38;
        r11 = r13.a;
        goto L38
    L30:
        r13 = null;
        goto L31
    L26:
        r12 = null;
        goto L28
    L40:
        r1.c = r2;
        return;
    L61:
        return;
    }

    public final void w7() {
        y r0 = getController();
        Boolean r1 = null;
        boolean r2 = false;
        if (r0 == null) goto L5;
        int r3 = r0.n;
    L14:
        w0.a r4 = getCurrentCreationReferenceCapabilityState();
        boolean r5 = r4 instanceof w0.a;
        if (r5 == false) goto L21;
        Integer r6 = r4.a.c();
        if (r6 == null) goto L19;
        r3 = r6.intValue();
    L27:
        if (r3 >= 0) goto L30;
        return;
    L30:
        if (r5 == false) goto L50;
        Iterator<T> r7 = getToolsResourceItemIndex().iterator();
    L33:
        if (r7.hasNext() == false) goto L35;
        ListProtector.remove(this.h, ((Number) r7.next()).intValue());
        goto L33
    L35:
        ArrayList<ResourceItemBean> r8 = this.h;
        ArrayList r9 = new ArrayList();
        Iterator<ResourceItemBean> r10 = r8.iterator();
    L37:
        if (r10.hasNext() == false) goto L41;
        CreationReferenceMediaType r11 = J7(r10.next().getResourceType());
        if (r11 == null) goto L37;
        r9.add(r11);
        goto L37
    L41:
        Map r12 = GroupingKt.eachCount(new c(r9));
        w0.a r13 = r4;
        if (r13.a.b(CreationReferenceMediaType.IMAGE, r12) == false) goto L44;
    L47:
        boolean r14 = true;
    L48:
        r1 = Boolean.valueOf(r14);
    L52:
        if (Intrinsics.areEqual(r1, Boolean.FALSE) == false) goto L60;
        com.larus.bmhome.view.actionbar.edit.c r15 = getViewModel();
        if (r15 == null) goto L56;
        r15.updateAttachmentResources(this.h);
    L56:
        mt8.a r16 = this.f;
        if (r16 == null) goto L104;
        r16.e(this.h);
        return;
    L104:
        return;
    L60:
        int r17 = getCurrentNum();
        if (r17 != 0) goto L72;
        Iterator<T> r18 = getToolsResourceItemIndex().iterator();
    L64:
        if (r18.hasNext() == false) goto L67;
        ListProtector.remove(this.h, ((Number) r18.next()).intValue());
        goto L64
    L67:
        if (y7() == true) goto L71;
        ResourceItemBean r19 = W6();
        if (r19 == null) goto L87;
        this.h.add(r19);
    L87:
        com.larus.bmhome.view.actionbar.edit.c r20 = getViewModel();
        if (r20 == null) goto L105;
        r20.updateAttachmentResources(this.h);
        return;
    L105:
        return;
    L71:
        this.h.add(V6());
        goto L87
    L72:
        if (r1 == null) goto L75;
        r2 = r1.booleanValue();
    L77:
        if (r2 == false) goto L83;
        Iterator<T> r21 = getToolsResourceItemIndex().iterator();
    L80:
        if (r21.hasNext() == false) goto L82;
        ListProtector.remove(this.h, ((Number) r21.next()).intValue());
        goto L80
    L82:
        this.h.add(V6());
        goto L87
    L83:
        Iterator<T> r22 = getToolsResourceItemIndex().iterator();
    L85:
        if (r22.hasNext() == false) goto L87;
        ListProtector.remove(this.h, ((Number) r22.next()).intValue());
        goto L85
    L75:
        if ((r3 - r17) <= 0) goto L77;
        r2 = true;
        goto L77
    L44:
        if (r13.a.b(CreationReferenceMediaType.VIDEO, r12) == true) goto L47;
        r14 = false;
        goto L48
    L50:
        if (Intrinsics.areEqual(r4, w0.b.a) == true) goto L52;
        throw new NoWhenBranchMatchedException();
    L19:
        r3 = 0;
        goto L27
    L21:
        if (Intrinsics.areEqual(r4, w0.b.a) == false) goto L94;
        if (getCreationUploadPicNumber() <= 0) goto L27;
        if (getCreationUploadPicNumber() >= r3) goto L27;
        r3 = getCreationUploadPicNumber();
        goto L27
    L94:
        throw new NoWhenBranchMatchedException();
    L5:
        y r23 = getController();
        if (r23 == null) goto L10;
        com.larus.bmhome.actionbar.model.v r24 = r23.l;
        if (r24 == null) goto L10;
        Integer r25 = r24.a;
    L11:
        if (r25 == null) goto L13;
        r3 = r25.intValue();
        goto L14
    L13:
        r3 = 0;
    L10:
        r25 = null;
        goto L11
    }

    public MultiAttachmentSelectorWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        this.h = new ArrayList();
    }

    public static boolean C7(ResourceItemBean r2) {
        if (r2.getResourceType() != ResourceType.ADD) goto L5;
    L8:
        return true;
    L5:
        if (r2.getResourceType() == ResourceType.CUSTOM) goto L8;
        return false;
    }

    public static final void H6(MultiAttachmentSelectorWidget r3) {
        ResourceItemBean r0 = (ResourceItemBean) CollectionsKt.firstOrNull(r3.getRealRefImgItem());
        if (r0 == null) goto L5;
        ResourceItemBean r1 = f7(r3, r0, Boolean.TRUE, 1);
    L7:
        if (r3.getRealRefImgItem().size() <= 1) goto L13;
        if (r1 == null) goto L14;
        mt8.a r4 = r3.f;
        if (r4 == null) goto L15;
        r4.f(r1);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public static final /* synthetic */ y n6(MultiAttachmentSelectorWidget r0) {
        return r0.getController();
    }

    public static final /* synthetic */ w0 o6(MultiAttachmentSelectorWidget r0) {
        return r0.getCurrentCreationReferenceCapabilityState();
    }

    public static final /* synthetic */ int s6(MultiAttachmentSelectorWidget r0) {
        return r0.getMediaMaxNum();
    }

    public static final /* synthetic */ List u6(MultiAttachmentSelectorWidget r0) {
        return r0.getRealRefImgItem();
    }

    public final CreationReferenceMediaType J7(ResourceType r5) {
        int r6 = b.a[r5.ordinal()];
        boolean r0 = true;
        if (r6 == 1) goto L28;
        if (r6 == 2) goto L32;
        if (r6 != 3) goto L9;
        CreationReferenceMediaType r7 = CreationReferenceMediaType.VIDEO;
        w0.a r1 = getCurrentCreationReferenceCapabilityState();
        if ((r1 instanceof w0.a) == false) goto L15;
        w0.a r2 = r1;
    L17:
        if (r2 == null) goto L23;
        d1 r3 = r2.a;
        if (r3 == null) goto L23;
        if (r3.a(r7) != true) goto L23;
    L24:
        if (r0 == true) goto L31;
        return null;
    L31:
        return r7;
    L23:
        r0 = false;
        goto L24
    L15:
        r2 = null;
        goto L17
    L9:
        if (r6 == 4) goto L29;
        return null;
    L29:
        return CreationReferenceMediaType.AUDIO;
    L32:
        return CreationReferenceMediaType.IMAGE;
    L28:
        return CreationReferenceMediaType.VIDEO;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.larus.uaigc.instruction.b0] */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.larus.uaigc.instruction.z] */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.larus.uaigc.instruction.a0] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void R5(Fragment r14) {
        Intrinsics.checkNotNullParameter(r14, "fragment");
        Intrinsics.checkNotNullParameter(r14, "fragment");
        ((AbsInstructionWidget) this).a = r14;
        this.i = (ry9.h) s1a.a.g(r14).getAbility(ry9.h.class);
        this.j = s1a.a.g(r14).getAbility(ys8.a.class);
        ny9.u r0 = (ny9.u) s1a.a.g(r14).a(ny9.u.class);
        this.k = (ny9.s) s1a.a.g(r14).a(ny9.s.class);
        ry9.h r15 = this.i;
        if (r15 == 0) goto L5;
        r15.OI(new a0(this));
    L5:
        CoroutineScope r1 = getComponentScope();
        if (r1 == null) goto L8;
        BuildersKt.launch$default(r1, null, null, new MultiAttachmentSelectorWidget$registerUpdateUIStateHandler$1(this, null), 3, null);
    L8:
        CoroutineScope r7 = getComponentScope();
        if (r7 == null) goto L11;
        BuildersKt.launch$default(r7, null, null, new MultiAttachmentSelectorWidget$registerOnClearAndSetPassedImageUrlListRegister$1(this, null), 3, null);
    L11:
        ry9.h r16 = this.i;
        if (r16 == 0) goto L14;
        r16.IR(new z(this));
    L14:
        ry9.h r17 = this.i;
        if (r17 == 0) goto L18;
        r17.tE(new b0(this));
        return;
    }

    public final void setPassedImageAlbumPaths(List<? extends Uri> r7) {
        CoroutineScope r0 = getComponentScope();
        if (r0 == null) goto L6;
        BuildersKt.launch$default(r0, null, null, new MultiAttachmentSelectorWidget$handlePassedImageAlbumPathsToResourceItems$1(this, r7, null), 3, null);
        return;
    }

    public static Unit i6(MultiAttachmentSelectorWidget r5, ry9.a r6) {
        Intrinsics.checkNotNullParameter(r6, "config");
        ArrayList<ResourceItemBean> r0 = r6.a;
        if ((!r0.isEmpty()) == false) goto L29;
        int r7 = r6.c;
        if (r7 >= 0) goto L7;
    L19:
        Iterator<T> r8 = r5.getToolsResourceItemIndex().iterator();
    L21:
        if (r8.hasNext() == false) goto L23;
        ListProtector.remove(r5.h, ((Number) r8.next()).intValue());
        goto L21
    L23:
        r5.h.addAll(r0);
        r5.w7();
    L24:
        mt8.a r9 = r5.f;
        if (r9 == null) goto L27;
        r9.e(r5.h);
    L27:
        r5.N6();
        goto L29
    L7:
        if (r7 >= r5.h.size()) goto L19;
        ResourceItemBean r1 = (ResourceItemBean) ListProtector.get(r5.h, r7);
        ry9.h r2 = r5.i;
        if (r2 == null) goto L16;
        String r3 = r1.getKey();
        Image r4 = r1.getImage();
        if (r4 == null) goto L14;
        String r10 = r4.localResPath;
        if (r10 == null) goto L14;
    L15:
        r2.w60(r3, r10, null);
    L14:
        r10 = "";
    L16:
        ListProtector.set(r5.h, r7, CollectionsKt.first(r0));
        com.larus.bmhome.view.actionbar.edit.c r11 = r5.getViewModel();
        if (r11 == null) goto L24;
        r11.updateAttachmentResources(r5.h);
    L29:
        return Unit.INSTANCE;
    }

    public static Unit k6(MultiAttachmentSelectorWidget r5, ResourceItemBean r6) {
        Intrinsics.checkNotNullParameter(r6, "resourceItemBean");
        Iterator<T> r0 = r5.getToolsResourceItemIndex().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        int r1 = ((Number) r0.next()).intValue();
        ListProtector.remove(r5.h, r1);
        goto L4
    L6:
        Iterator<ResourceItemBean> r2 = r5.h.iterator();
    L8:
        if (r2.hasNext() == false) goto L15;
        ResourceItemBean r3 = r2.next();
        if (r3.getResourceType() != ResourceType.AVATAR) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L8;
    L16:
        ResourceItemBean r7 = r3;
        if (r7 == null) goto L19;
        r5.h.remove(r7);
    L19:
        ListProtector.add(r5.h, 0, r6);
        r5.w7();
        mt8.a r8 = r5.f;
        if (r8 == null) goto L22;
        r8.e(r5.h);
    L22:
        r5.N6();
        return Unit.INSTANCE;
    L12:
        r4 = false;
        goto L13
    L15:
        r3 = null;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        LayoutInflater.from(r3).inflate(2131562710, this);
        int r5 = 2131364451;
        View r6 = ViewBindings.findChildViewById(this, 2131364451);
        if (r6 == null) goto L11;
        r5 = 2131384425;
        FrameLayout r0 = (FrameLayout) ViewBindings.findChildViewById(this, 2131384425);
        if (r0 == null) goto L11;
        r5 = 2131389146;
        View r1 = ViewBindings.findChildViewById(this, 2131389146);
        if (r1 == null) goto L11;
        this.l = new LarusLayoutActionBarEditorWidgetAttachmentSelectorBinding(this, r6, r0, r1);
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v28 */
    public final void r7(List<ResourceExt> r52, boolean r53) {
        int r12 = getMediaMaxNum();
        ny9.s r1 = this.k;
        String r13 = "is_prefilled_image";
        char r14 = 0;
        int r15 = 1;
        if (r1 == null) goto L10;
        Bundle r2 = r1.a;
        if (r2 == null) goto L7;
        boolean r3 = r2.getBoolean("is_prefilled_image", false);
    L8:
        if (r3 != true) goto L10;
        boolean r16 = true;
    L11:
        ArrayList r10 = new ArrayList();
        if (r52 == null) goto L340;
        Iterator<T> r17 = r52.iterator();
        int r4 = 0;
    L15:
        if (r17.hasNext() == false) goto L340;
        Object r5 = r17.next();
        int r18 = r4 + 1;
        if (r4 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        ResourceExt r6 = (ResourceExt) r5;
        if ((getCurrentCreationReferenceCapabilityState() instanceof w0.b) == true) goto L22;
    L24:
        HashMap r7 = new HashMap();
        if (r16 == false) goto L27;
        boolean r8 = false;
    L33:
        r7.put("ext_show_re_select_layout", Boolean.valueOf(r8));
        r7.put(r13, Boolean.valueOf(r16));
        r7.put("ext_creation_reference_do_same", Boolean.TRUE);
        Integer r9 = Integer.valueOf(r4);
        Intrinsics.checkNotNullParameter(r7, "ext");
        if (r6 == null) goto L38;
        Resource r11 = r6.a;
        if (r11 == null) goto L38;
        Integer r19 = r11.a;
    L40:
        if (r19 != null) goto L43;
    L133:
        String r42 = "";
        if (r19 != null) goto L137;
    L139:
        boolean r20 = false;
    L140:
        if (r6 == null) goto L188;
        Resource r21 = r6.a;
        if (r21 == null) goto L146;
        VideoResource r22 = r21.c;
        if (r22 == null) goto L146;
        ImageInfo r23 = r22.h;
    L147:
        if (r53 == false) goto L150;
        if (r23 == null) goto L157;
        com.larus.platform.api.Image r24 = r23.h;
    L159:
        if (r24 == null) goto L161;
        String r31 = r24.a;
    L162:
        Image r25 = new Image(null, null, new ImageObj(r31, 0, 0, null, null, 30, null), null, null, null, null, null, null, null, null, null, null, null, 16378, null);
        Resource r26 = r6.a;
        if (r26 == null) goto L169;
        VideoResource r27 = r26.c;
        if (r27 == null) goto L169;
        Double r28 = r27.d;
        if (r28 == null) goto L169;
        float r29 = (float) r28.doubleValue();
    L170:
        Resource r30 = r6.a;
        if (r30 == null) goto L175;
        VideoResource r32 = r30.c;
        if (r32 == null) goto L175;
        String r210 = r32.a;
    L177:
        if (r30 == null) goto L181;
        VideoResource r33 = r30.c;
        if (r33 == null) goto L181;
        String r211 = r33.f;
    L182:
        if (r30 == null) goto L186;
        VideoResource r34 = r30.c;
        if (r34 == null) goto L186;
        String r212 = r34.b;
    L187:
        mt8.b r35 = new mt8.b(r25, r29, 0, 0, null, r210, "", r211, r212, 16);
    L189:
        if (r6 == null) goto L222;
        if (r53 == false) goto L196;
        Resource r36 = r6.a;
        if (r36 == null) goto L208;
        ImageInfo r37 = r36.b;
        if (r37 == null) goto L208;
        com.larus.platform.api.Image r38 = r37.h;
    L209:
        String r213 = UUID.randomUUID().toString();
        if (r38 == null) goto L213;
        String r39 = r38.a;
        if (r39 == null) goto L213;
    L214:
        String r44 = r39;
        if (r38 == null) goto L217;
        int r45 = (int) r38.c;
    L218:
        if (r38 == null) goto L220;
        int r46 = (int) r38.d;
    L221:
        Image r40 = new Image(r213, null, new ImageObj(r44, r45, r46, null, null, 24, null), null, null, null, null, null, null, null, null, null, null, null, 16378, null);
    L223:
        String r214 = UUID.randomUUID().toString();
        ItemStatus r215 = ItemStatus.UPLINKING;
        if (r20 == false) goto L226;
        ResourceType r41 = ResourceType.VIDEO;
    L227:
        ResourceType r216 = r41;
        if (r20 == false) goto L230;
        Image r217 = null;
    L231:
        if (r20 == false) goto L233;
        mt8.b r218 = r35;
    L234:
        ResourceItemBean r43 = new ResourceItemBean(r214, null, null, null, r217, r218, 0, r215, false, r216, i5.w0(), 0, 0, 0, false, false, false, false, 0, r7, 522510, null);
    L235:
        w0.a r47 = getCurrentCreationReferenceCapabilityState();
        if ((r47 instanceof w0.a) == false) goto L238;
        w0.a r48 = r47;
    L239:
        if (r48 == null) goto L252;
        d1 r49 = r48.a;
        if (r49 == null) goto L252;
        CreationReferenceMediaType r50 = J7(r43.getResourceType());
        if (r50 != null) goto L245;
        boolean r51 = false;
    L253:
        if (r51 == false) goto L266;
        if (r16 == true) goto L257;
    L259:
        String r54 = r43.getKey();
        this.h.add(r43);
        r10.add(r43);
        ry9.h r55 = this.i;
        if (r55 == null) goto L262;
        r55.ew(r43);
    L262:
        int r56 = b.a[r43.getResourceType().ordinal()];
        if (r56 != 1) goto L265;
        ArrayList r57 = r10;
        ry9.h r58 = this.i;
        if (r58 == null) goto L338;
        if (r6 == null) goto L297;
        Resource r59 = r6.a;
        if (r59 == null) goto L297;
        VideoResource r60 = r59.c;
    L298:
        if (r60 == null) goto L300;
        ImageInfo r61 = r60.h;
    L301:
        if (r53 == false) goto L304;
        if (r61 == null) goto L311;
        com.larus.platform.api.Image r62 = r61.h;
    L313:
        if (r60 == null) goto L315;
        String r219 = r60.a;
    L317:
        if (r60 == null) goto L319;
        String r63 = r60.a;
    L320:
        if (r62 == null) goto L322;
        String r64 = r62.a;
    L323:
        if (r62 == null) goto L325;
        Integer r110 = Integer.valueOf((int) r62.c);
    L326:
        if (r62 == null) goto L328;
        Integer r65 = Integer.valueOf((int) r62.d);
    L329:
        f2 r111 = new f2(r64, null, r65, r110);
        if (r60 == null) goto L332;
        Double r66 = r60.d;
    L333:
        VideoUploadInfo r67 = new VideoUploadInfo(r63, r111, r66);
        if (r60 == null) goto L336;
        String r220 = r60.a;
    L337:
        r58.Ke(r54, new MediaAttachment(null, r219, null, r67, null, r220, "", null, null, null, null, null, 3973, null), r53);
    L339:
        r12 = r12;
        r13 = r13;
        r4 = r18;
        r14 = 0;
        r15 = 1;
        r10 = r57;
        goto L15
    L336:
        r220 = null;
        goto L337
    L332:
        r66 = null;
        goto L333
    L328:
        r65 = null;
        goto L329
    L325:
        r110 = null;
        goto L326
    L322:
        r64 = null;
        goto L323
    L319:
        r63 = null;
        goto L320
    L315:
        r219 = null;
    L311:
        r62 = null;
        goto L313
    L304:
        if (r61 == null) goto L309;
        com.larus.platform.api.Image r68 = r61.b;
        if (r68 == null) goto L309;
        r62 = r68;
    L309:
        if (r61 == null) goto L311;
        r62 = r61.a;
        goto L313
    L300:
        r61 = null;
    L297:
        r60 = null;
    L338:
        r12 = r12;
        r13 = r13;
        goto L339
    L265:
        if (r56 != 2) goto L266;
        if (r53 == false) goto L277;
        Resource r69 = r6.a;
        if (r69 == null) goto L279;
        ImageInfo r70 = r69.b;
        if (r70 == null) goto L279;
        com.larus.platform.api.Image r71 = r70.h;
        if (r71 == null) goto L279;
        String r72 = r71.a;
        if (r72 == null) goto L279;
    L280:
        String r73 = r72;
    L281:
        y r74 = getController();
        if (r74 == null) goto L286;
        HashMap<String, String> r75 = r74.p;
        if (r75 == null) goto L286;
        String r76 = r75.get(r73);
    L287:
        ry9.h r77 = this.i;
        if (r77 == null) goto L290;
        r57 = r10;
        ry9.h.a.b(r77, r54, r73, "", "", "", r53, false, r76, 64);
        goto L338
    L290:
        r57 = r10;
    L286:
        r76 = null;
    L279:
        r73 = r42;
        goto L281
    L277:
        r72 = sq9.g.e(r6);
        if (r72 != null) goto L280;
    L257:
        if (r43.getResourceType() != ResourceType.IMAGE) goto L259;
        r43.setStatus(ItemStatus.SUCCESS);
    L266:
        r57 = r10;
        r12 = r12;
        r13 = r13;
        goto L339
    L245:
        ArrayList<ResourceItemBean> r78 = this.h;
        ArrayList r79 = new ArrayList();
        Iterator<ResourceItemBean> r80 = r78.iterator();
    L247:
        if (r80.hasNext() == false) goto L251;
        CreationReferenceMediaType r81 = J7(r80.next().getResourceType());
        if (r81 == null) goto L247;
        r79.add(r81);
        goto L247
    L251:
        r51 = r49.b(r50, GroupingKt.eachCount(new d0(r79)));
    L252:
        r51 = true;
        goto L253
    L238:
        r48 = null;
        goto L239
    L233:
        r218 = null;
        goto L234
    L230:
        r217 = r40;
        goto L231
    L226:
        r41 = ResourceType.IMAGE;
        goto L227
    L220:
        r46 = 0;
        goto L221
    L217:
        r45 = 0;
    L213:
        r39 = r6.b;
    L208:
        r38 = null;
        goto L209
    L196:
        Resource r82 = r6.a;
        if (r82 == null) goto L204;
        ImageInfo r83 = r82.b;
        if (r83 == null) goto L204;
        com.larus.platform.api.Image r84 = r83.b;
        if (r84 == null) goto L204;
        r38 = r84;
    L204:
        if (r82 == null) goto L208;
        ImageInfo r85 = r82.b;
        if (r85 == null) goto L208;
        r38 = r85.a;
        goto L209
    L222:
        r40 = null;
    L186:
        r212 = null;
    L181:
        r211 = null;
    L175:
        r210 = null;
    L169:
        r29 = 0.0f;
        goto L170
    L161:
        r31 = null;
    L157:
        r24 = null;
        goto L159
    L150:
        if (r23 == null) goto L155;
        com.larus.platform.api.Image r86 = r23.b;
        if (r86 == null) goto L155;
        r24 = r86;
    L155:
        if (r23 == null) goto L157;
        r24 = r23.a;
    L146:
        r23 = null;
        goto L147
    L188:
        r35 = null;
        goto L189
    L137:
        if (r19.intValue() != 2) goto L139;
        r20 = true;
        goto L140
    L43:
        if (r19.intValue() != 3) goto L133;
        if (r6 == null) goto L48;
        Resource r87 = r6.a;
        if (r87 == null) goto L48;
        AudioResource r88 = r87.d;
    L49:
        String r89 = UUID.randomUUID().toString();
        if (r88 == null) goto L61;
        String r90 = r88.a;
        if (r90 == null) goto L61;
        String r91 = StringsKt.trim(r90).toString();
        if (r91 == null) goto L61;
        if (r91.length() <= 0) goto L58;
        boolean r112 = true;
    L59:
        if (r112 == false) goto L61;
    L62:
        if (r88 == null) goto L77;
        String r92 = r88.c;
        if (r92 == null) goto L77;
        String r93 = StringsKt.trim(r92).toString();
        if (r93 == null) goto L77;
        r42 = "";
        char[] r94 = new char[r15];
        r94[r14] = '.';
        String r95 = StringsKt.trimStart(r93, r94);
        if (r95 == null) goto L78;
        String r96 = r95.toLowerCase(Locale.ROOT);
        if (r96 == null) goto L78;
        if (r96.length() <= 0) goto L74;
        boolean r97 = true;
    L75:
        if (r97 == false) goto L78;
    L79:
        if (r88 == null) goto L93;
        String r98 = r88.e;
        if (r98 == null) goto L93;
        String r99 = StringsKt.trim(r98).toString();
        if (r99 == null) goto L93;
        if (r99.length() <= 0) goto L87;
        boolean r113 = true;
    L88:
        if (r113 == true) goto L91;
        r99 = null;
    L91:
        if (r99 == null) goto L93;
    L94:
        String r221 = r99;
        if (r96 != null) goto L97;
        String r100 = r42;
    L98:
        String r114 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r100.toLowerCase(Locale.ROOT));
        if (r114 != null) goto L101;
        r114 = "audio/*";
    L101:
        String r222 = r114;
        r7.put("ext_show_re_select_layout", Boolean.FALSE);
        r7.put("ext_audio_identifier", r89);
        if (r91 == null) goto L104;
        r7.put("ext_audio_vid", r91);
    L104:
        if (r88 == null) goto L113;
        String r101 = r88.b;
        if (r101 == null) goto L113;
        if ((!StringsKt.isBlank(r101)) == true) goto L111;
        r101 = null;
    L111:
        if (r101 == null) goto L113;
        r7.put("ext_audio_video_model", r101);
    L113:
        if (r96 == null) goto L115;
        r7.put("ext_audio_type", r96);
    L115:
        if (r88 == null) goto L119;
        Double r102 = r88.d;
        if (r102 == null) goto L119;
        r7.put("ext_audio_duration_seconds", Double.valueOf(r102.doubleValue()));
    L119:
        r7.put("ext_audio_is_private", Boolean.valueOf(r53));
        if (r9 == null) goto L122;
        r7.put("ext_audio_server_order", Integer.valueOf(r9.intValue()));
    L122:
        if (r91 == null) goto L124;
        boolean r103 = true;
    L126:
        if (r103 == false) goto L128;
        int r223 = 100;
    L129:
        if (r103 == false) goto L131;
        ItemStatus r104 = ItemStatus.SUCCESS;
    L132:
        r43 = new ResourceItemBean(r89, r221, r100, r222, null, null, r223, r104, false, ResourceType.AUDIO, i5.y(), 0, 0, 0, false, false, false, false, 0, r7, 522544, null);
        goto L235
    L131:
        r104 = ItemStatus.UPLINK_FAILED;
        goto L132
    L128:
        r223 = 0;
        goto L129
    L124:
        r103 = false;
        goto L126
    L97:
        r100 = r96;
        goto L98
    L87:
        r113 = false;
    L93:
        r99 = "audio";
        goto L94
    L74:
        r97 = false;
    L78:
        r96 = null;
    L77:
        r42 = "";
        goto L78
    L58:
        r112 = false;
    L61:
        r91 = null;
    L48:
        r88 = null;
    L38:
        r19 = null;
        goto L40
    L27:
        ny9.s r105 = this.k;
        if (r105 == null) goto L32;
        Bundle r106 = r105.a;
        if (r106 == null) goto L32;
        r8 = r106.getBoolean("is_show_reselect", r15);
    L32:
        r8 = true;
        goto L33
    L22:
        if (getCurrentNum() < r12) goto L24;
    L340:
        ArrayList r510 = r10;
        if ((getCurrentCreationReferenceCapabilityState() instanceof w0.a) == true) goto L343;
    L454:
        com.larus.bmhome.view.actionbar.edit.c r107 = getViewModel();
        if (r107 == null) goto L532;
        ArrayList<ResourceItemBean> r108 = this.h;
        if ((r108 instanceof Collection) == true) goto L459;
    L461:
        Iterator<ResourceItemBean> r109 = r108.iterator();
    L463:
        if (r109.hasNext() == false) goto L473;
        ResourceItemBean r115 = r109.next();
        if (r115.getResourceType() != ResourceType.IMAGE) goto L467;
    L470:
        boolean r116 = true;
    L471:
        if (r116 == false) goto L463;
        boolean r117 = true;
    L474:
        r107.setOriginalRatioEnable(r117);
        return;
    L467:
        if (r115.getResourceType() == ResourceType.VIDEO) goto L470;
        r116 = false;
    L473:
        r117 = false;
        goto L474
    L459:
        if (r108.isEmpty() == false) goto L461;
    L532:
        return;
    L343:
        if ((!r510.isEmpty()) == false) goto L454;
        Set<String> r118 = cq9.b.a;
        CreationMultiReferenceLogEvent r119 = CreationMultiReferenceLogEvent.DO_SAME_RESTORED;
        Boolean r120 = Boolean.TRUE;
        ry9.h r121 = this.i;
        if (r121 == null) goto L452;
        ry9.d r122 = r121.yH(r510);
        if (r122 == null) goto L452;
        List<ry9.c> r123 = r122.a;
        if ((r123 instanceof Collection) == true) goto L351;
    L353:
        Iterator<T> r124 = r123.iterator();
        int r125 = 0;
    L355:
        if (r124.hasNext() == false) goto L364;
        if (((ry9.c) r124.next()).getType() != CreationReferenceAttachmentType.IMAGE) goto L359;
        boolean r126 = true;
    L360:
        if (r126 == false) goto L355;
        r125 = r125 + 1;
        if (r125 >= 0) goto L355;
        CollectionsKt.throwCountOverflow();
        goto L355
    L359:
        r126 = false;
        goto L360
    L364:
        int r127 = r125;
    L365:
        List<ry9.c> r128 = r122.a;
        if ((r128 instanceof Collection) == true) goto L368;
    L370:
        Iterator<T> r129 = r128.iterator();
        int r130 = 0;
    L372:
        if (r129.hasNext() == false) goto L381;
        if (((ry9.c) r129.next()).getType() != CreationReferenceAttachmentType.VIDEO) goto L376;
        boolean r131 = true;
    L377:
        if (r131 == false) goto L372;
        r130 = r130 + 1;
        if (r130 >= 0) goto L372;
        CollectionsKt.throwCountOverflow();
        goto L372
    L376:
        r131 = false;
        goto L377
    L381:
        int r132 = r130;
    L382:
        List<ry9.c> r133 = r122.a;
        if ((r133 instanceof Collection) == true) goto L385;
    L387:
        Iterator<T> r134 = r133.iterator();
        int r135 = 0;
    L389:
        if (r134.hasNext() == false) goto L398;
        if (((ry9.c) r134.next()).getType() != CreationReferenceAttachmentType.AUDIO) goto L393;
        boolean r136 = true;
    L394:
        if (r136 == false) goto L389;
        r135 = r135 + 1;
        if (r135 >= 0) goto L389;
        CollectionsKt.throwCountOverflow();
        goto L389
    L393:
        r136 = false;
        goto L394
    L398:
        int r137 = r135;
    L399:
        List<ry9.c> r138 = r122.a;
        if ((r138 instanceof Collection) == true) goto L402;
    L404:
        Iterator<T> r139 = r138.iterator();
        int r140 = 0;
    L406:
        if (r139.hasNext() == false) goto L415;
        if (((ry9.c) r139.next()).getType() != CreationReferenceAttachmentType.UNKNOWN) goto L410;
        boolean r141 = true;
    L411:
        if (r141 == false) goto L406;
        r140 = r140 + 1;
        if (r140 >= 0) goto L406;
        CollectionsKt.throwCountOverflow();
        goto L406
    L410:
        r141 = false;
        goto L411
    L415:
        int r142 = r140;
    L416:
        List<ry9.c> r143 = r122.a;
        ArrayList r144 = new ArrayList();
        Iterator<T> r145 = r143.iterator();
    L418:
        if (r145.hasNext() == false) goto L425;
        Object r146 = r145.next();
        if (((ry9.c) r146).getType() != CreationReferenceAttachmentType.VIDEO) goto L422;
        boolean r147 = true;
    L423:
        if (r147 == false) goto L418;
        r144.add(r146);
        goto L418
    L422:
        r147 = false;
        goto L423
    L425:
        Iterator r148 = r144.iterator();
        double r149 = 0.0d;
    L427:
        if (r148.hasNext() == false) goto L433;
        Double r150 = ((ry9.c) r148.next()).j;
        if (r150 == null) goto L431;
        double r151 = r150.doubleValue();
    L432:
        r149 = r149 + r151;
        goto L427
    L431:
        r151 = 0.0d;
        goto L432
    L433:
        List<ry9.c> r152 = r122.a;
        ArrayList r153 = new ArrayList();
        Iterator r154 = r152.iterator();
    L435:
        if (r154.hasNext() == false) goto L443;
        Object r155 = r154.next();
        Iterator r156 = r154;
        if (((ry9.c) r155).getType() != CreationReferenceAttachmentType.AUDIO) goto L439;
        boolean r157 = true;
    L440:
        if (r157 == false) goto L442;
        r153.add(r155);
    L442:
        r154 = r156;
        goto L435
    L439:
        r157 = false;
        goto L440
    L443:
        Iterator r158 = r153.iterator();
        double r159 = 0.0d;
    L445:
        if (r158.hasNext() == false) goto L451;
        Double r160 = ((ry9.c) r158.next()).j;
        if (r160 == null) goto L449;
        double r161 = r160.doubleValue();
    L450:
        r159 = r159 + r161;
        goto L445
    L449:
        r161 = 0.0d;
        goto L450
    L451:
        cq9.a r162 = new cq9.a(r127, r132, r137, r142, r149, r159, Integer.valueOf(r122.a.size()));
    L453:
        cq9.b.a(r119, r120, "do_same", "ref_resources", r162, null, null, null, 976);
        goto L454
    L402:
        if (r138.isEmpty() == false) goto L404;
        r142 = 0;
        goto L416
    L385:
        if (r133.isEmpty() == false) goto L387;
        r137 = 0;
        goto L399
    L368:
        if (r128.isEmpty() == false) goto L370;
        r132 = 0;
        goto L382
    L351:
        if (r123.isEmpty() == false) goto L353;
        r127 = 0;
    L452:
        r162 = null;
        goto L453
    L7:
        r3 = false;
    L10:
        r16 = false;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o7(boolean r17, int r18, boolean r19) {
        int r1 = getCurrentNum();
        int r2 = getMediaMaxNum();
        int r5 = r2 - r1;
        FLogger.a.i("MultiAttachmentSelectorWidget", "[handleOpenAlbum] attachmentMaxNum = " + r2 + ", currentNum = " + r1 + ", remainNum = " + r5 + ", forceSelectSingle = " + r17);
        if (r2 <= 0) goto L92;
        if (r5 > 0) goto L8;
        if (r17 == false) goto L92;
        if (r19 == false) goto L92;
    L8:
        w0.a r3 = getCurrentCreationReferenceCapabilityState();
        ResourceType r7 = null;
        if ((r3 instanceof w0.a) == false) goto L11;
        w0.a r4 = r3;
    L12:
        if (r4 == null) goto L14;
        d1 r6 = r4.a;
    L15:
        if (r6 == null) goto L88;
        Integer r8 = r6.c();
        if (r8 == null) goto L111;
        int r9 = r8.intValue();
        boolean r10 = r6.a(CreationReferenceMediaType.VIDEO);
        Iterator<ResourceItemBean> r11 = this.h.iterator();
        boolean r12 = false;
        int r13 = 0;
    L20:
        if (r11.hasNext() == false) goto L29;
        ResourceItemBean r14 = r11.next();
        if (C7(r14) == true) goto L20;
        if (r14.getResourceType() == ResourceType.VIDEO) goto L28;
        if (r10 == false) goto L20;
        if (r14.getResourceType() != ResourceType.AVATAR) goto L20;
    L28:
        r13 = r13 + 1;
        goto L20
    L29:
        int r15 = getCurrentImageNum();
        int r16 = 1;
        if (r10 == true) goto L32;
    L34:
        int r20 = 0;
    L35:
        int r21 = RangesKt.coerceAtLeast(r9 - (r1 + r20), 0);
        CreationReferenceMediaType r22 = CreationReferenceMediaType.VIDEO;
        g1 r110 = r6.d(r22);
        if (r110 == null) goto L46;
        Integer r111 = r110.b;
        if (r111 == null) goto L46;
        r111.intValue();
        if (r6.a(r22) == true) goto L43;
        r111 = null;
    L43:
        if (r111 == null) goto L46;
        int r112 = r111.intValue();
    L49:
        CreationReferenceMediaType r113 = CreationReferenceMediaType.IMAGE;
        g1 r114 = r6.d(r113);
        if (r114 == null) goto L60;
        Integer r115 = r114.b;
        if (r115 == null) goto L60;
        r115.intValue();
        if (r6.a(r113) == true) goto L57;
        r115 = null;
    L57:
        if (r115 == null) goto L60;
        r9 = r115.intValue();
    L63:
        int r116 = RangesKt.coerceAtLeast(r112 - r13, 0);
        int r23 = Math.min(r21, RangesKt.coerceAtLeast(r9 - r15, 0) + r116);
        if (r23 > 0) goto L67;
        if (r17 == true) goto L67;
        return;
    L67:
        ResourceItemBean r24 = (ResourceItemBean) CollectionsKt.getOrNull(this.h, r18);
        if (r17 == false) goto L76;
        if (r24 == null) goto L72;
        r7 = r24.getResourceType();
    L72:
        if (r7 != ResourceType.VIDEO) goto L76;
        if (r6.a(r22) == false) goto L76;
        r12 = true;
    L76:
        ry9.h r25 = this.i;
        if (r25 == null) goto L112;
        if (r17 == false) goto L80;
        r23 = 1;
    L80:
        if (r12 == true) goto L86;
        if (r17 == false) goto L84;
        int r26 = RangesKt.coerceAtMost(r116, 1);
    L85:
        r16 = r26;
        goto L86
    L84:
        r26 = RangesKt.coerceAtMost(r116, r21);
    L86:
        r25.YL(r23, r17, r18, r16, getCreationReferenceAttachmentSnapshot());
        return;
    L112:
        return;
    L60:
        if (r6.a(r113) == true) goto L63;
        r9 = 0;
    L46:
        if (r6.a(r22) == false) goto L48;
        r112 = r9;
        goto L49
    L48:
        r112 = 0;
        goto L49
    L32:
        if (y7() == false) goto L34;
        r20 = 1;
        goto L35
    L111:
        return;
    L88:
        ry9.h r27 = this.i;
        if (r27 == null) goto L113;
        ry9.h.a.a(r27, r5, r17, r18, 56);
        return;
    L113:
        return;
    L14:
        r6 = null;
        goto L15
    L11:
        r4 = null;
    L92:
        y r28 = getController();
        if (r28 == null) goto L96;
        String r29 = r28.x;
        if (r29 == null) goto L96;
    L98:
        if (o0.d(r29) == false) goto L114;
        t19.s r30 = t19.s.a;
        Context r31 = getContext();
        r30.getClass();
        t19.s.t(r31, r29);
        return;
    L114:
        return;
    L96:
        r29 = "";
        goto L98
    }

    public static final Object C6(MultiAttachmentSelectorWidget r49, Uri r50, int r51, Continuation r52) {
        r49.getClass();
        if ((r52 instanceof MultiAttachmentSelectorWidget$handlePassedImageAlbumPathToResourceItem$1) == false) goto L7;
        MultiAttachmentSelectorWidget$handlePassedImageAlbumPathToResourceItem$1 r3 = (MultiAttachmentSelectorWidget$handlePassedImageAlbumPathToResourceItem$1) r52;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r9 = true;
        if (r6 == 0) goto L18;
        if (r6 == 1) goto L17;
        if (r6 == 2) goto L16;
        if (r6 != 3) goto L15;
        ResultKt.throwOnFailure(r2);
    L85:
        n0 r7 = (n0) r2;
        m0 r1 = r7.a;
        if (r1 == null) goto L102;
        String r8 = r1.e;
        if (r8 == null) goto L102;
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        r10.element = "";
        ImFileUtil r11 = ImFileUtil.a;
        PolarisFileWrapper r12 = new PolarisFileWrapper(r8);
        r11.getClass();
        String r13 = ImFileUtil.g(r12);
        if (r13 == null) goto L93;
        r10.element = r13;
    L93:
        String r14 = UUID.randomUUID().toString();
        String r29 = StringsKt.substringAfterLast$default(r8, '.', null, 2, null);
        String r15 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(StringsKt.substringAfterLast$default(r8, '.', null, 2, null));
        if (r15 != null) goto L96;
        String r30 = "";
    L97:
        r49.h.add(new ResourceItemBean(r14, null, r29, r30, new Image(UUID.randomUUID().toString(), (String) r10.element, null, null, null, r8, null, null, null, null, null, null, null, null, 16348, null), null, 0, ItemStatus.UPLINKING, false, ResourceType.IMAGE, i5.w0(), 0, 0, 0, false, false, false, false, 0, null, 1046818, null));
        ry9.h r0 = r49.i;
        if (r0 == null) goto L118;
        r0.uz(r14, r8, r7.a);
    L118:
        return Unit.INSTANCE;
    L96:
        r30 = r15;
    L102:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r2);
    L116:
        return Unit.INSTANCE;
    L17:
        ResultKt.throwOnFailure(r2);
    L114:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r2);
        if (r49.h.size() >= r51) goto L110;
        w0.a r16 = r49.getCurrentCreationReferenceCapabilityState();
        if ((r16 instanceof w0.a) == false) goto L48;
        ResourceItemBean r17 = com.larus.uaigc.helper.o0.c(r50, null);
        if (r17 == null) goto L111;
        CreationReferenceMediaType r18 = r49.J7(r17.getResourceType());
        if (r18 == null) goto L112;
        ArrayList<ResourceItemBean> r19 = r49.h;
        ArrayList r20 = new ArrayList();
        Iterator<ResourceItemBean> r21 = r19.iterator();
    L31:
        if (r21.hasNext() == false) goto L36;
        CreationReferenceMediaType r22 = r49.J7(r21.next().getResourceType());
        if (r22 == null) goto L31;
        r20.add(r22);
        goto L31
    L36:
        if (r16.a.b(r18, GroupingKt.eachCount(new h0(r20))) == false) goto L113;
        r49.h.add(r17);
        ry9.h r23 = r49.i;
        if (r23 == null) goto L41;
        r23.ew(r17);
    L41:
        ry9.h r24 = r49.i;
        if (r24 == null) goto L114;
        r3.label = 1;
        if (r24.BM(r17, r3) != r5) goto L114;
        return r5;
    L113:
        return Unit.INSTANCE;
    L112:
        return Unit.INSTANCE;
    L111:
        return Unit.INSTANCE;
    L48:
        if (Intrinsics.areEqual(r16, w0.b.a) == false) goto L104;
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L82;
        ResourceItemBean r25 = com.larus.uaigc.helper.o0.c(r50, null);
        if (r25 != null) goto L55;
        return Unit.INSTANCE;
    L55:
        if (b.a[r25.getResourceType().ordinal()] != 1) goto L65;
        r49.h.add(r25);
        ry9.h r26 = r49.i;
        if (r26 == null) goto L59;
        r26.ew(r25);
    L59:
        ry9.h r27 = r49.i;
        if (r27 == null) goto L116;
        r3.label = 2;
        if (r27.BM(r25, r3) != r5) goto L116;
        return r5;
    L65:
        Image r28 = r25.getImage();
        if (r28 == null) goto L68;
        String r31 = r28.localResPath;
    L69:
        if (r31 != null) goto L71;
    L74:
        if (r9 == true) goto L82;
        r49.h.add(r25);
        ry9.h r32 = r49.i;
        if (r32 == null) goto L78;
        r32.ew(r25);
    L78:
        ry9.h r33 = r49.i;
        if (r33 == null) goto L117;
        r33.uz(r25.getKey(), r31, null);
    L117:
        return Unit.INSTANCE;
    L71:
        if (StringsKt.isBlank(r31) == true) goto L74;
        r9 = false;
        goto L74
    L68:
        r31 = null;
    L82:
        CreationImageUploadPolicy r34 = CreationImageUploadPolicy.a;
        r3.label = 3;
        r2 = r34.a(r50, "ai_creation", null, r3);
        if (r2 != r5) goto L85;
        return r5;
    L104:
        throw new NoWhenBranchMatchedException();
    L110:
        return Unit.INSTANCE;
    L7:
        r3 = new MultiAttachmentSelectorWidget$handlePassedImageAlbumPathToResourceItem$1(r49, r52);
        goto L8
    }

    public static ResourceItemBean f7(MultiAttachmentSelectorWidget r23, ResourceItemBean r24, Boolean r25, int r26) {
        if ((r26 & 2) == 0) goto L5;
        Boolean r0 = null;
    L6:
        String r2 = r24.getKey();
        String r3 = r24.getTitle();
        String r4 = r24.getFileSuffixes();
        String r5 = r24.getMimeType();
        Image r6 = r24.getImage();
        mt8.b r7 = r24.getVideo();
        int r8 = r24.getUpLinkProgress();
        ItemStatus r9 = r24.getStatus();
        boolean r10 = r24.isExpire();
        ResourceType r11 = r24.getResourceType();
        int r12 = r24.getItemWidth();
        int r13 = r24.getItemHeight();
        int r14 = r24.getPaddingTop();
        int r15 = r24.getPaddingBottom();
        boolean r16 = r24.getShowEditImageBtn();
        boolean r17 = r24.getShowEditVideoBtn();
        if (r0 == null) goto L9;
        boolean r1 = r0.booleanValue();
    L11:
        return new ResourceItemBean(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r1, r24.getImmersiveStyle(), r24.getSubscriptIndex(), r24.getExt());
    L9:
        r1 = r24.getShowSubscriptView();
        goto L11
    L5:
        r0 = r25;
        goto L6
    }
}
