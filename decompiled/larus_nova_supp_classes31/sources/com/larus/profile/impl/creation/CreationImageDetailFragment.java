package com.larus.profile.impl.creation;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.bigimg.aibeautify.CommonAiBeautifyLayout;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.bigimg.download.ImageDownloadLoadingMgr;
import com.larus.bmhome.bigimg.template.CommonTemplateLayout;
import com.larus.bmhome.bigimg.widget.BottomCreationEditView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.common_ui.image.ImageAdapter;
import com.larus.bmhome.common_ui.image.ImageDetailFragment;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.tipoff.TipOffDialogParams;
import com.larus.bmhome.view.CreationOperateContainerView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.fragment.CommonSlideFragment;
import com.larus.common_ui.fragment.helper.EditPanelType;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.common_ui.widget.CommonAuthorInfoLayout;
import com.larus.community.api.ICommunityService;
import com.larus.im.bean.message.AICreationTaskDurationInfo;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.TplTagType;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.service.AccountService;
import com.larus.platform.spi.IAIChatService;
import com.larus.profile.api.ICreationService;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.uaigc.service.ICreationDetailImageEditService;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.uaigc.service.IUgcAIGCService$a;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ¿\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0006½\u0001¾\u0001¿\u0001B_\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016B\t\b\u0016¢\u0006\u0004\b\u0015\u0010\u0017J\b\u0010=\u001a\u00020>H\u0002J\u0014\u0010?\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010A\u001a\u00020\bH\u0002J\u0014\u0010B\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010A\u001a\u00020\bH\u0002J\u0012\u0010o\u001a\u00020>2\b\u0010p\u001a\u0004\u0018\u00010qH\u0002J\u0010\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020>H\u0002J\u0010\u0010u\u001a\u00020\u00112\u0006\u0010t\u001a\u00020>H\u0002J\b\u0010v\u001a\u00020\u0011H\u0002J\u0010\u0010w\u001a\u00020\u00112\u0006\u0010x\u001a\u00020yH\u0002J\b\u0010z\u001a\u00020FH\u0002J\u0015\u0010{\u001a\u00020\r2\b\u0010|\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010}J\u0015\u0010~\u001a\u00020\r2\b\u0010|\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010}J\b\u0010\u007f\u001a\u00020\u0011H\u0016J\t\u0010\u0080\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u0081\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u0082\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u0083\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u0084\u0001\u001a\u00020\u0011H\u0002J\u0014\u0010\u0085\u0001\u001a\u00020\u00112\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010sH\u0016J\t\u0010\u0087\u0001\u001a\u00020\u0011H\u0016J\u0012\u0010\u0088\u0001\u001a\u00020\u00112\u0007\u0010\u0089\u0001\u001a\u00020\u000bH\u0016J+\u0010\u008a\u0001\u001a\u0004\u0018\u00010F2\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\t\u0010\u008d\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010sH\u0016J\u001d\u0010\u008e\u0001\u001a\u00020\u00112\u0007\u0010\u008f\u0001\u001a\u00020F2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010sH\u0016J\t\u0010\u0090\u0001\u001a\u00020>H\u0002J\t\u0010\u0091\u0001\u001a\u00020>H\u0002J\t\u0010\u0092\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u0093\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u0094\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u0095\u0001\u001a\u00020\bH\u0002J\t\u0010\u0096\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u0097\u0001\u001a\u00020\u0011H\u0002J\u0011\u0010\u0098\u0001\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\bH\u0016J&\u0010\u0099\u0001\u001a\u00020\u00112\u0007\u0010\u009a\u0001\u001a\u00020\r2\t\b\u0002\u0010\u009b\u0001\u001a\u00020>2\u0007\u0010\u009c\u0001\u001a\u00020\rH\u0002J\u001c\u0010\u009d\u0001\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\b2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\rH\u0016J\u0011\u0010\u009f\u0001\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\bH\u0016J\u0011\u0010 \u0001\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\bH\u0016J\t\u0010¡\u0001\u001a\u00020\bH\u0016J\u0012\u0010¢\u0001\u001a\u00020\u00112\u0007\u0010£\u0001\u001a\u00020\bH\u0016J0\u0010¤\u0001\u001a\u00020\u00112\t\u0010¥\u0001\u001a\u0004\u0018\u00010\r2\u0007\u0010¦\u0001\u001a\u00020\r2\u0007\u0010§\u0001\u001a\u00020\r2\b\u0010¨\u0001\u001a\u00030©\u0001H\u0016J/\u0010ª\u0001\u001a\u00020\u00112\b\u0010«\u0001\u001a\u00030¬\u00012\u0007\u0010¦\u0001\u001a\u00020\r2\u0007\u0010§\u0001\u001a\u00020\r2\b\u0010¨\u0001\u001a\u00030©\u0001H\u0002J\u0011\u0010\u00ad\u0001\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\bH\u0002J\t\u0010®\u0001\u001a\u00020\u0011H\u0002J\t\u0010¯\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010°\u0001\u001a\u00020\u00112\u0007\u0010±\u0001\u001a\u00020\bH\u0002J\t\u0010²\u0001\u001a\u00020\u0011H\u0002J\t\u0010³\u0001\u001a\u00020\u0011H\u0016J\t\u0010´\u0001\u001a\u00020\u0011H\u0016J\u0011\u0010µ\u0001\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0003\u0010¶\u0001J\t\u0010·\u0001\u001a\u00020>H\u0016J\n\u0010¸\u0001\u001a\u00030¹\u0001H\u0016J\t\u0010º\u0001\u001a\u00020\u0011H\u0016J\t\u0010»\u0001\u001a\u00020\u0011H\u0016J\t\u0010¼\u0001\u001a\u00020\u0011H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010\u0014\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010E\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bG\u0010HR\u0016\u0010K\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010M\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010O\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010J\u001a\u0004\bP\u0010QR\u001b\u0010S\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010J\u001a\u0004\bT\u0010QR#\u0010V\u001a\n\u0012\u0004\u0012\u00020X\u0018\u00010W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010J\u001a\u0004\bY\u0010ZR\u001d\u0010\\\u001a\u0004\u0018\u00010X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010J\u001a\u0004\b]\u0010^R\u001d\u0010`\u001a\u0004\u0018\u00010X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010J\u001a\u0004\ba\u0010^R\u001b\u0010c\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010J\u001a\u0004\bd\u0010QR\u001b\u0010f\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bg\u0010J\u001a\u0004\bf\u0010QR\u001b\u0010h\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010J\u001a\u0004\bh\u0010QR\u001d\u0010j\u001a\u0004\u0018\u00010X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bl\u0010J\u001a\u0004\bk\u0010^R\u0010\u0010m\u001a\u0004\u0018\u00010nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006À\u0001"}, d2 = {"Lcom/larus/profile/impl/creation/CreationImageDetailFragment;", "Lcom/larus/bmhome/common_ui/image/ImageDetailFragment;", "Lcom/larus/profile/impl/creation/ICreationOperatorInterface;", "Lcom/larus/common_ui/fragment/helper/IContainerFunctionInterface;", "Lcom/larus/platform/api/creation/ICreationListener;", "transitionAdapter", "Lcom/larus/bmhome/common_ui/image/ImageAdapter;", "type", "", "userCreations", "", "Lcom/larus/platform/api/creation/UserCreation;", "visitId", "", "creationMode", "callback", "Lkotlin/Function0;", "", "creationPagerInitParams", "Lcom/larus/profile/api/model/CreationPagerInitParams;", "position", "<init>", "(Lcom/larus/bmhome/common_ui/image/ImageAdapter;ILjava/util/List;Ljava/lang/String;ILkotlin/jvm/functions/Function0;Lcom/larus/profile/api/model/CreationPagerInitParams;I)V", "()V", "getType", "()I", "getVisitId", "()Ljava/lang/String;", "getCreationMode", "getCallback", "()Lkotlin/jvm/functions/Function0;", "setCallback", "(Lkotlin/jvm/functions/Function0;)V", "getCreationPagerInitParams", "()Lcom/larus/profile/api/model/CreationPagerInitParams;", "setCreationPagerInitParams", "(Lcom/larus/profile/api/model/CreationPagerInitParams;)V", "getPosition", "loadedIndexList", "", "countTextView", "Landroid/widget/TextView;", "desTextVew", "authorTextVew", "bottomCreationEditView", "Lcom/larus/bmhome/bigimg/widget/BottomCreationEditView;", "downloadView", "Lcom/larus/bmhome/bigimg/download/CommonDownLoadLayout;", "aiBeautify", "Lcom/larus/bmhome/bigimg/aibeautify/CommonAiBeautifyLayout;", "promptButton", "Lcom/larus/bmhome/bigimg/template/CommonTemplateLayout;", "creationOperatorContainer", "Lcom/larus/bmhome/view/CreationOperateContainerView;", "creationTemplateComponent", "Lcom/larus/profile/impl/creation/CreationTemplateComponent;", "publishContainer", "Landroid/view/ViewGroup;", "privateButtonContainer", "bottomToolsContainer", "currentCreation", "shouldUseNoWatermark", "", "displayImageUrl", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "pos", "displayDownloadImageUrl", "currentCreationTaskId", "titleBar", "moreMenu", "Landroid/view/View;", "getMoreMenu", "()Landroid/view/View;", "moreMenu$delegate", "Lkotlin/Lazy;", "pickLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "pickSDKLauncher", "Landroid/content/Intent;", "hasCreateImageAbility", "getHasCreateImageAbility", "()Z", "hasCreateImageAbility$delegate", "hasCreateVideoAbility", "getHasCreateVideoAbility", "hasCreateVideoAbility$delegate", "mainBotActionBarList", "", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "getMainBotActionBarList", "()Ljava/util/List;", "mainBotActionBarList$delegate", "genImgInstructionItem", "getGenImgInstructionItem", "()Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "genImgInstructionItem$delegate", "detailEditInstructionItem", "getDetailEditInstructionItem", "detailEditInstructionItem$delegate", "hasDetailImageEditAbility", "getHasDetailImageEditAbility", "hasDetailImageEditAbility$delegate", "isShowCreateBottomView", "isShowCreateBottomView$delegate", "isShowCreateLeftView", "isShowCreateLeftView$delegate", "genVideoInstructionItem", "getGenVideoInstructionItem", "genVideoInstructionItem$delegate", "creationOperatorComponent", "Lcom/larus/profile/impl/creation/CreationOperatorComponent;", "shouldRetainCreationHomeMemoryForDetail", "activity", "Landroid/app/Activity;", "buildDetailEditExtraBundle", "Landroid/os/Bundle;", "retainAICreationHomeMemory", "dismissDetailBeforeAppletRouteIfNeeded", "initLauncher", "onAlbumPicked", "uri", "Landroid/net/Uri;", "buildMoreMenu", "getItemName", "private", "(Ljava/lang/Integer;)Ljava/lang/String;", "getCurrentStatus", "onResume", "onScroll", "onShareClick", "dismissExtraView", "showExtraView", "showOrDismissExtraView", "onCreate", "savedInstanceState", "onDestroy", "onPublishSuccess", "userCreation", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onViewCreated", "view", "shouldShowCreationDialogOnShare", "shouldShowCreationDialogOnDownload", "prefetchToCreationBitmapCache", "initView", "updatePromptButton", "getInitCreationButtonStatus", "toAiVideoEditPage", "toAiBeautifyPage", "downloadCreation", "saveBitmap", "imageUrl", "share", "creationId", "shareCreation", "source", "deleteWithPosition", "scrollToInitPostion", "getCurrentIndex", "onDoCreationAction", "action", "updateInfo", "uid", "des", "authorName", "count", "", "updateInfoByConfig", "bottomInfoConfig", "Lcom/larus/profile/api/model/BottomInfoConfig;", "updateIconStatus", "initButtonClickListener", "openSystemAlbum", "updateButtonStatus", TplTagType.STYLE, "setPrivateButtonBackground", "onMoreClick", "doSameStyle", "getExtraViewLayout", "()Ljava/lang/Integer;", "showEditPanel", "editPanelType", "Lcom/larus/common_ui/fragment/helper/EditPanelType;", "dismissFragment", "onDestroyView", "onSelected", "ImageShareCallback", "InitData", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationImageDetailFragment extends ImageDetailFragment implements g19.a, zp9.r {
    public static final /* synthetic */ int Y = 0;
    public CommonDownLoadLayout A;
    public CommonAiBeautifyLayout B;
    public CommonTemplateLayout C;
    public CreationOperateContainerView D;
    public u1 E;
    public ViewGroup F;
    public ViewGroup G;
    public ViewGroup H;
    public final UserCreation I;
    public String J;
    public ViewGroup K;
    public final Lazy L;
    public ActivityResultLauncher<String> M;
    public ActivityResultLauncher<Intent> N;
    public final Lazy O;
    public final Lazy P;
    public final Lazy Q;
    public final Lazy R;
    public final Lazy S;
    public final Lazy T;
    public final Lazy U;
    public final Lazy V;
    public final Lazy W;
    public CreationOperatorComponent X;
    public final int p;
    public final List<UserCreation> q;
    public final String r;
    public final int s;
    public final Function0<Unit> t;
    public final gs9.d u;
    public final Set<Integer> v;
    public TextView w;
    public TextView x;
    public TextView y;
    public BottomCreationEditView z;

    /* JADX INFO: renamed from: com.larus.profile.impl.creation.CreationImageDetailFragment$8, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.creation.CreationImageDetailFragment$8", f = "CreationImageDetailFragment.kt", i = {}, l = {338}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ CreationImageDetailFragment this$0;

        public AnonymousClass8(CreationImageDetailFragment r1, Continuation<? super AnonymousClass8> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass8(this.this$0, r3);
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
            CreationImageDetailFragment r2 = (CreationImageDetailFragment) this.L$0;
            ResultKt.throwOnFailure(r6);
        L21:
            Message r7 = (Message) r6;
            if (r7 == null) goto L28;
            List r8 = ap8.a.a(r7);
            if (r8 == null) goto L28;
            AICreationTaskDurationInfo r9 = (AICreationTaskDurationInfo) CollectionsKt.firstOrNull(r8);
            if (r9 == null) goto L28;
            String r10 = r9.taskId;
        L30:
            r2.J = r10;
            return Unit.INSTANCE;
        L28:
            CreationImageDetailFragment r11 = r2;
        L29:
            r2 = r11;
            r10 = null;
            goto L30
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            r11 = this.this$0;
            IChatRepoService r3 = RepoDispatcherDelegate.b.e();
            if (r3 == null) goto L29;
            UserCreation r4 = this.this$0.I;
            if (r4 == null) goto L16;
            CreationDynamicInfo r5 = r4.h;
            if (r5 == null) goto L16;
            String r12 = r5.d;
            if (r12 == null) goto L16;
        L17:
            this.L$0 = r11;
            this.label = 1;
            Object r13 = r3.E1(r12, this);
            if (r13 != r0) goto L20;
            return r0;
        L20:
            r2 = r11;
            r6 = r13;
        L16:
            r12 = "0";
            goto L17
        }
    }

    public static final class a {
    }

    public static final class b implements com.larus.bmhome.share.panel.d {
        public final String a;

        public final boolean d(String r1, String r2, Boolean r3) {
            return true;
        }

        public final void f() {
        }

        public final void onDismiss() {
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "creationId");
            this.a = r2;
        }

        public final void e(Function0<Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
        }

        public final boolean b(Context r22, DialogFragment r23, View r24, jr9.a r25) {
            Intrinsics.checkNotNullParameter(r25, "shareItemConfig");
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L34
            if (Intrinsics.areEqual(r25.b(), "report") == false) goto L30;
            IAIChatService.Companion r1 = IAIChatService.a;     // Catch: Throwable -> L34
            String r5 = this.a;     // Catch: Throwable -> L32
            Intrinsics.checkNotNullParameter(r5, "entityId");     // Catch: Throwable -> L32
            TipOffDialogParams r15 = new TipOffDialogParams(8, r5, null, null, "", "", 0, null, null, null, null, null, null, null, null);     // Catch: Throwable -> L32
            r15.g = 0;     // Catch: Throwable -> L32
            Fragment r2 = r1.g8(r15);     // Catch: Throwable -> L32
            if (r23 == null) goto L20;
            FragmentManager r3 = r23.getParentFragmentManager();     // Catch: Throwable -> L32
            if (r3 == null) goto L20;
            if ((r2 instanceof Fragment) == false) goto L14;
            Fragment r4 = r2;
        L15:
            LandscapeRestrictionOperation r6 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L32
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, null, r6);     // Catch: Throwable -> L32
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r4, r6) == true) goto L20;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L41 Throwable -> L32
        L19:
            r2.show(r3, null);     // Catch: Throwable -> L32
            goto L20
        L14:
            r4 = null;
        L20:
            if (r23 == null) goto L49;
            r23.dismiss();     // Catch: Exception -> L23 Throwable -> L32
        L51:
            return true;
        L23:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L32
            Throwable r7 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L32
            if (r7 == null) goto L50;
            com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L32
            return true;
        L50:
            return true;
        L49:
            return true;
        L30:
            Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L32
        L37:
            Throwable r9 = Result.exceptionOrNull-impl(r8);
            if (r9 == null) goto L40;
            FLogger.a.e("MusicShareApi", "Save music video error state ", r9);
        L40:
            return false;
        L32:
            th = th;
        L36:
            Result.Companion r10 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
        L34:
            th = th;
            goto L36
        }
    }

    public static final class c implements zs8.a {
        public final /* synthetic */ CreationImageDetailFragment a;

        public final String Y1() {
            return null;
        }

        public final String a() {
            return null;
        }

        public final String c() {
            return null;
        }

        public final String d() {
            return null;
        }

        public final String e() {
            return null;
        }

        public final String f() {
            return null;
        }

        public final String g() {
            return null;
        }

        public final String getBotId() {
            return null;
        }

        public final String getChatType() {
            return null;
        }

        public final String getClickFrom() {
            return "";
        }

        public final String getEnterMethod() {
            return "ai_edit_picture_detail";
        }

        public final String getTemplateType() {
            return null;
        }

        public final String i() {
            return null;
        }

        public final String j() {
            return null;
        }

        public final String k() {
            return null;
        }

        public final boolean l() {
            return false;
        }

        public final String m() {
            return null;
        }

        public final String n() {
            return null;
        }

        public final String o() {
            return null;
        }

        public final String p() {
            return null;
        }

        public final String b() {
            if (this.a.s != 2) goto L5;
            return "creation_private";
        L5:
            return "creation_list";
        }

        public final String h() {
            gs9.d r0 = this.a.u;
            if (r0 == null) goto L7;
            gs9.b r1 = r0.f;
            if (r1 == null) goto L7;
            return r1.g;
        L7:
            return null;
        }

        public c(CreationImageDetailFragment r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void Oh() {
    }

    public final void d70() {
        ia0(0, "detail_click");
    }

    public final boolean dc() {
        return true;
    }

    public CreationImageDetailFragment() {
        this(new ImageAdapter(), new ArrayList(), "", 0, null, 112);
        T90();     // Catch: IllegalStateException -> L5
        return;
    L5:
        FLogger.a.e("MusicPlayerDetailFragment", "fallback by dismiss failed");
    }

    public final void VT() {
        View r0 = ((ImageDetailFragment) this).k;
        if (r0 == null) goto L5;
        ViewExtKt.d(r0);
    L5:
        CreationGroupFragment r1 = getParentFragment();
        if ((r1 instanceof CreationGroupFragment) == false) goto L8;
        CreationGroupFragment r2 = r1;
    L9:
        if (r2 == null) goto L12;
        r2.ca0();
        return;
    L12:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final void Z90() {
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        String r3 = "";
        if (r1 == null) goto L8;
        r1.D0();
        com.larus.home.impl.sdk.b1 r2 = com.larus.home.impl.sdk.b1.a;
        r2.c("profile_private_canvas_download");
        String r4 = X90(0);
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        r2.d(r4);
    L8:
        ImageAdapter r5 = ((ImageDetailFragment) this).d;
        if (r5 == null) goto L13;
        List r6 = r5.b;
        if (r6 == null) goto L13;
        int r7 = r6.size();
    L14:
        if (r7 <= 0) goto L266;
        com.larus.platform.service.z2 r8 = com.larus.platform.service.z2.a;
        hq9.v1 r9 = r8.getCreationShareSettings().a();
        if (r9 != null) goto L19;
    L21:
        boolean r10 = false;
    L22:
        String r11 = null;
        if (r10 == false) goto L44;
        hq9.v1 r12 = r8.getCreationShareSettings().a();
        if (r12 != null) goto L27;
    L29:
        boolean r13 = false;
    L31:
        if (r13 == false) goto L37;
        List r14 = CollectionsKt.listOf(new Integer[]{2, 5, 4});
        UserCreation r15 = this.I;
        if (r15 == null) goto L35;
        Integer r16 = Integer.valueOf(r15.b);
    L36:
        boolean r17 = CollectionsKt.contains(r14, r16);
    L42:
        if (r17 == false) goto L44;
        boolean r18 = true;
    L45:
        if (r18 == false) goto L242;
        int r19 = x1.a;
        UserCreation r20 = this.I;
        gs9.d r21 = this.u;
        if (r21 == null) goto L49;
        gs9.b r22 = r21.f;
    L50:
        x1.b(r20, r22, "click_download");
        ChatControlTrace r23 = ChatControlTrace.b;
        r23.getClass();
        String r110 = r23.bb(ChatControlTrace.y);
        String r111 = r23.h(ChatControlTrace.y);
        UserCreation r24 = this.I;
        if (r24 != null) goto L53;
    L55:
        boolean r25 = false;
    L56:
        if (r24 == null) goto L58;
        Integer r26 = Integer.valueOf(r24.b);
    L59:
        UserCreation r27 = this.I;
        if (r27 == null) goto L62;
        String r28 = r27.a;
    L63:
        if (r27 == null) goto L65;
        String r29 = zp9.d.d(r27);
    L66:
        UserCreation r30 = this.I;
        if (r30 == null) goto L69;
        String r210 = zp9.d.b(r30);
    L70:
        UserCreation r31 = this.I;
        if (r31 == null) goto L75;
        UserCreationTrackParams r32 = r31.n;
        if (r32 == null) goto L75;
        String r211 = r32.a;
    L76:
        if (r31 == null) goto L80;
        UserCreationTrackParams r33 = r31.n;
        if (r33 == null) goto L80;
        String r34 = r33.d;
    L81:
        if (r31 == null) goto L85;
        UserCreationTrackParams r35 = r31.n;
        if (r35 == null) goto L85;
        String r36 = r35.f;
    L86:
        if (r31 == null) goto L90;
        UserCreationTrackParams r37 = r31.n;
        if (r37 == null) goto L90;
        String r38 = r37.e;
    L91:
        if (r31 == null) goto L95;
        UserCreationTrackParams r39 = r31.n;
        if (r39 == null) goto L95;
        String r112 = r39.g;
    L96:
        gs9.d r40 = this.u;
        if (r40 == null) goto L102;
        gs9.b r41 = r40.f;
        if (r41 == null) goto L102;
        String r42 = r41.g;
        if (r42 == null) goto L102;
    L106:
        String r212 = r42;
    L108:
        if (r40 == null) goto L112;
        gs9.b r43 = r40.f;
        if (r43 == null) goto L112;
        Boolean r310 = r43.c;
    L113:
        if (r31 == null) goto L115;
        String r53 = r31.a;
    L116:
        com.larus.bmhome.share.panel.h r44 = new com.larus.bmhome.share.panel.h(null, null, r110, "creation_detail", r111, r112, null, null, null, r25, r26, r28, r29, r210, r211, null, null, r212, r310, r34, r38, r36, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r53, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -16382073, -4097, 1023);
        Fragment r45 = getParentFragment();
        if (r45 == null) goto L262;
        FragmentManager r46 = r45.getFragmentManager();
        if (r46 == null) goto L263;
        UserCreation r47 = this.I;
        if (r47 == null) goto L123;
        ImageInfo r48 = i2.a(r47, ka0());
    L124:
        com.larus.bmhome.bigimg.n1 r49 = Y90(0);
        IFlowSdkDepend r50 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r50 == null) goto L264;
        r50.r0();
        com.larus.home.impl.sdk.e2 r51 = com.larus.home.impl.sdk.e2.a;
        if (r48 == null) goto L129;
        Image r113 = r48.c;
    L130:
        String r114 = i2.d(r113);
        if (r114 != null) goto L137;
        if (r49 == null) goto L134;
        r114 = r49.a;
    L135:
        if (r114 != null) goto L137;
        String r56 = "";
    L138:
        if (r48 == null) goto L140;
        Image r115 = r48.a;
    L141:
        String r116 = i2.d(r115);
        if (r116 != null) goto L148;
        if (r49 == null) goto L145;
        r116 = r49.c;
    L146:
        if (r116 != null) goto L148;
    L149:
        String r57 = r3;
        if (r48 == null) goto L152;
        Image r52 = r48.i;
    L153:
        String r54 = i2.d(r52);
        if (r54 != null) goto L158;
        if (r49 == null) goto L157;
        r54 = r49.d;
        goto L158
    L157:
        String r58 = null;
    L159:
        UserCreation r55 = this.I;
        if (r55 == null) goto L164;
        AuthorInfo r59 = r55.g;
        if (r59 == null) goto L164;
        String r60 = r59.b;
    L166:
        if (Intrinsics.areEqual(r60, AccountService.a.getUserId()) == false) goto L186;
        UserCreation r61 = this.I;
        if (r61 == null) goto L172;
        UserCreationRefContent r62 = r61.o;
        if (r62 == null) goto L172;
        boolean r63 = Intrinsics.areEqual(r62.b, Boolean.TRUE);
    L173:
        if (r63 == true) goto L186;
        UserCreation r64 = this.I;
        if (r64 == null) goto L186;
        UserCreationRefContent r65 = r64.o;
        if (r65 == null) goto L186;
        List<ImageInfo> r66 = r65.a();
        if (r66 == null) goto L186;
        ImageInfo r67 = (ImageInfo) CollectionsKt.getOrNull(r66, 0);
        if (r67 == null) goto L186;
        Image r68 = r67.c;
        if (r68 == null) goto L186;
        String r510 = r68.a;
    L187:
        ShareScene r69 = ShareScene.IMAGE_VIEWER_REPORT;
        long r70 = -1;
        if (r48 == null) goto L192;
        Image r117 = r48.a;
        if (r117 == null) goto L192;
        long r118 = r117.d;
    L197:
        long r610 = r118;
    L199:
        if (r48 == null) goto L204;
        Image r119 = r48.a;
        if (r119 == null) goto L204;
        r70 = r119.c;
    L203:
        long r611 = r70;
        UserCreation r71 = this.I;
        if (r71 == null) goto L212;
        String r72 = r71.a;
    L213:
        sq9.i r73 = new sq9.i("download", null, r72, 2);
        Map r612 = IUgcAIGCService.a.H(r71, null);
        if (r48 == null) goto L219;
        Image r74 = r48.a;
        if (r74 == null) goto L219;
        String r75 = r74.e;
        if (r75 == null) goto L219;
    L240:
        String r76 = r75;
    L241:
        r51.Z0(r46, new sq9.j(null, r56, r57, r58, r510, null, r44, r69, r611, r610, r73, r612, 0, null, null, null, r76, 61473));
        Unit r77 = Unit.INSTANCE;
        return;
    L219:
        if (r48 == null) goto L223;
        Image r78 = r48.c;
        if (r78 == null) goto L223;
        r75 = r78.e;
    L224:
        if (r75 != null) goto L240;
        if (r48 == null) goto L229;
        Image r79 = r48.b;
        if (r79 == null) goto L229;
        r75 = r79.e;
    L230:
        if (r75 != null) goto L240;
        if (r48 == null) goto L235;
        Image r80 = r48.i;
        if (r80 == null) goto L235;
        r75 = r80.e;
    L236:
        if (r75 != null) goto L240;
        if (r48 == null) goto L239;
        r11 = r48.e;
    L239:
        r76 = r11;
    L235:
        r75 = null;
    L229:
        r75 = null;
    L223:
        r75 = null;
        goto L224
    L212:
        r72 = null;
    L204:
        if (r49 == null) goto L206;
        Long r81 = r49.f;
    L207:
        if (r81 == null) goto L203;
        r70 = r81.longValue();
        goto L203
    L206:
        r81 = null;
    L192:
        if (r49 == null) goto L194;
        Long r120 = r49.g;
    L195:
        if (r120 == null) goto L198;
        r118 = r120.longValue();
        goto L197
    L198:
        r610 = -1;
        goto L199
    L194:
        r120 = null;
    L172:
        r63 = false;
    L186:
        r510 = null;
    L164:
        r60 = null;
    L158:
        r58 = r54;
        goto L159
    L152:
        r52 = null;
        goto L153
    L145:
        r116 = null;
    L148:
        r3 = r116;
        goto L149
    L140:
        r115 = null;
        goto L141
    L134:
        r114 = null;
    L137:
        r56 = r114;
        goto L138
    L129:
        r113 = null;
        goto L130
    L264:
        return;
    L123:
        r48 = null;
        goto L124
    L263:
        return;
    L262:
        return;
    L115:
        r53 = null;
    L112:
        r310 = null;
    L102:
        if (r40 == null) goto L107;
        gs9.b r82 = r40.f;
        if (r82 == null) goto L107;
        r42 = r82.b;
    L107:
        r212 = null;
    L95:
        r112 = null;
    L90:
        r38 = null;
    L85:
        r36 = null;
    L80:
        r34 = null;
    L75:
        r211 = null;
        goto L76
    L69:
        r210 = null;
        goto L70
    L65:
        r29 = null;
        goto L66
    L62:
        r28 = null;
        goto L63
    L58:
        r26 = null;
        goto L59
    L53:
        if (r24.b != 3) goto L55;
        r25 = true;
        goto L56
    L49:
        r22 = null;
        goto L50
    L242:
        int r83 = x1.a;
        UserCreation r84 = this.I;
        gs9.d r85 = this.u;
        if (r85 == null) goto L245;
        gs9.b r86 = r85.f;
    L246:
        x1.a(r84, r86);
        final String r87 = X90(0);
        if (r87 != null) goto L250;
        return;
    L250:
        if (Build.VERSION.SDK_INT <= 29) goto L252;
    L259:
        ha0(r87, false, String.valueOf(((UserCreation) ListProtector.get(this.q, 0)).a));
    L260:
        Unit r88 = Unit.INSTANCE;
        return;
    L252:
        if (ContextCompat.checkSelfPermission(requireContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L259;
        Context r89 = getContext();
        if ((r89 instanceof FragmentActivity) == false) goto L256;
        r11 = (FragmentActivity) r89;
    L256:
        if (r11 != null) goto L258;
        return;
    L258:
        com.larus.platform.service.i2.b.a(r11, CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE"), new j0(this, r87));
        goto L260
    L245:
        r86 = null;
        goto L246
    L35:
        r16 = null;
        goto L36
    L37:
        List r90 = CollectionsKt.listOf(new Integer[]{5, 4});
        UserCreation r91 = this.I;
        if (r91 == null) goto L40;
        Integer r92 = Integer.valueOf(r91.b);
    L41:
        r17 = CollectionsKt.contains(r90, r92);
        goto L42
    L40:
        r92 = null;
        goto L41
    L27:
        if (r12.f() != true) goto L29;
        r13 = true;
    L44:
        r18 = false;
        goto L45
    L19:
        if (r9.b() != true) goto L21;
        r10 = true;
        goto L22
    L266:
        return;
    L13:
        r7 = 0;
        goto L14
    }

    public final com.larus.bmhome.actionbar.model.z0 aa0() {
        return (com.larus.bmhome.actionbar.model.z0) this.S.getValue();
    }

    public final com.larus.bmhome.actionbar.model.z0 ba0() {
        return (com.larus.bmhome.actionbar.model.z0) this.R.getValue();
    }

    public final com.larus.bmhome.actionbar.model.z0 ca0() {
        return (com.larus.bmhome.actionbar.model.z0) this.W.getValue();
    }

    public final boolean da0() {
        return ((Boolean) this.P.getValue()).booleanValue();
    }

    public final boolean ea0() {
        return ((Boolean) this.T.getValue()).booleanValue();
    }

    public final boolean fa0() {
        return ((Boolean) this.U.getValue()).booleanValue();
    }

    public final boolean ja0() {
        com.larus.platform.service.z2 r0 = com.larus.platform.service.z2.a;
        hq9.v1 r1 = r0.getCreationShareSettings().a();
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L27;
        hq9.v1 r3 = r0.getCreationShareSettings().a();
        if (r3 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        Integer r5 = null;
        if (r4 == false) goto L21;
        List r6 = CollectionsKt.listOf(new Integer[]{2, 5, 4, 3});
        UserCreation r7 = this.I;
        if (r7 == null) goto L20;
        r5 = Integer.valueOf(r7.b);
    L20:
        boolean r8 = CollectionsKt.contains(r6, r5);
    L25:
        if (r8 == false) goto L27;
        return true;
    L21:
        List r9 = CollectionsKt.listOf(new Integer[]{5, 4, 3});
        UserCreation r10 = this.I;
        if (r10 == null) goto L24;
        r5 = Integer.valueOf(r10.b);
    L24:
        r8 = CollectionsKt.contains(r9, r5);
        goto L25
    L12:
        if (r3.f() != true) goto L14;
        r4 = true;
    L27:
        return false;
    L5:
        if (r1.e() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final boolean ka0() {
        String r0 = this.r;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.length() == 0) goto L8;
        return false;
    }

    public final void la0() {
        FragmentActivity r10 = getActivity();
        if (r10 != null) goto L5;
        return;
    L5:
        int r1 = com.larus.profile.impl.info.a.c;
        boolean r9 = com.larus.profile.impl.info.a.C0014a.a(getArguments(), r10).a;
        if (r9 == false) goto L8;
        T90();
    L8:
        Uri r2 = ((ImageDetailFragment) this).d.A2(((ImageDetailFragment) this).m);
        if (r2 == null) goto L11;
        String r3 = r2.toString();
    L12:
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        String r15 = r3;
        AuthModelDelegate r4 = AuthModelDelegate.b;
        com.larus.bmhome.chat.api.e0 r5 = (com.larus.bmhome.chat.api.e0) r4.e().getValue();
        if (r5 == null) goto L19;
        LaunchInfo r6 = r5.a;
        if (r6 == null) goto L19;
        String r7 = r6.Y();
    L20:
        com.larus.bmhome.chat.api.e0 r8 = (com.larus.bmhome.chat.api.e0) r4.e().getValue();
        if (r8 == null) goto L25;
        LaunchInfo r11 = r8.a;
        if (r11 == null) goto L25;
        String r12 = r11.W();
    L26:
        ChatParam r55 = new ChatParam(r7, r12, null, null, null, 252);
        int r13 = com.larus.uaigc.bean.chat.gallery.a.a;
        Intrinsics.checkNotNullParameter(r15, "previewUrl");
        boolean r14 = com.larus.uaigc.bean.chat.gallery.a.a(r10, new com.larus.uaigc.bean.chat.gallery.a.C0037a(r15, r15, ICreationDetailImageEditService.a.a(r15), W90(r9)), new d1(this), aa0(), r55, true, null, 416);
        if (r14 == true) goto L40;
        com.larus.bmhome.actionbar.model.z0 r16 = aa0();
        if (r16 == null) goto L35;
        com.larus.bmhome.actionbar.model.r r17 = r16.q;
        if (r17 == null) goto L35;
        boolean r18 = true;
        if (r17.f() != true) goto L35;
    L36:
        if (r18 == false) goto L40;
        com.larus.bmhome.actionbar.model.z0 r19 = aa0();
        if (r19 == null) goto L44;
        IUgcAIGCService.a.W(new ny9.b(false, r10, r19, r55, true, false, null, null, r15, null, null, null, null, null, null, null, null, null, null, false, false, new c1(this), null, W90(r9), false, null, null, null, false, null, true, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1084227871, 262143));
    L44:
        CreationImageDetailFragment r0 = this;
    L45:
        hy9.d r20 = IUgcAIGCService.a.j();
        Context r21 = getContext();
        if (r21 == null) goto L48;
        String r22 = r21.getString(2131906324);
    L49:
        com.larus.bmhome.actionbar.model.z0 r23 = aa0();
        if (r23 == null) goto L56;
        com.larus.bmhome.actionbar.model.r r24 = r23.q;
        if (r24 == null) goto L56;
        Integer r25 = r24.a;
        if (r25 == null) goto L56;
        String r110 = r25.toString();
    L57:
        com.larus.bmhome.actionbar.model.z0 r26 = aa0();
        if (r26 == null) goto L62;
        com.larus.bmhome.actionbar.model.r r27 = r26.q;
        if (r27 == null) goto L62;
        String r111 = r27.g;
    L64:
        if (r0.s != 2) goto L66;
        String r28 = "creation_private";
    L67:
        hy9.d.a.a(r20, r22, null, null, "picture_detail", "edit_entrance", null, null, r110, r111, r28, null, null, null, null, null, null, null, r0.J, null, null, null, 4062310);
        return;
    L66:
        r28 = "creation_list";
    L62:
        r111 = null;
    L56:
        r110 = null;
        goto L57
    L48:
        r22 = null;
    L35:
        r18 = false;
    L40:
        if (r14 == true) goto L44;
        r0 = this;
        CommonAiBeautifyLayout r29 = r0.B;
        if (r29 == null) goto L45;
        com.larus.utils.e1.o(r29);
    L25:
        r12 = null;
    L19:
        r7 = null;
        goto L20
    L11:
        r3 = null;
        goto L12
    }

    public final void ma0() {
        com.larus.bmhome.actionbar.model.z0 r1 = ca0();
        if (r1 == null) goto L7;
        com.larus.bmhome.actionbar.model.r r2 = r1.q;
        if (r2 == null) goto L7;
        boolean r3 = Intrinsics.areEqual(r2.h, Boolean.TRUE);
    L8:
        if (r3 == false) goto L57;
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L33;
        com.larus.bmhome.actionbar.model.z0 r5 = ca0();
        if (r5 == null) goto L33;
        int r6 = com.larus.profile.impl.info.a.c;
        boolean r7 = com.larus.profile.impl.info.a.C0014a.a(getArguments(), r4).a;
        if (r7 == false) goto L16;
        T90();
    L16:
        IUgcAIGCService.Companion r11 = IUgcAIGCService.a;
        AuthModelDelegate r8 = AuthModelDelegate.b;
        com.larus.bmhome.chat.api.e0 r9 = (com.larus.bmhome.chat.api.e0) r8.e().getValue();
        if (r9 == null) goto L21;
        LaunchInfo r10 = r9.a;
        if (r10 == null) goto L21;
        String r13 = r10.Y();
    L22:
        com.larus.bmhome.chat.api.e0 r12 = (com.larus.bmhome.chat.api.e0) r8.e().getValue();
        if (r12 == null) goto L27;
        LaunchInfo r14 = r12.a;
        if (r14 == null) goto L27;
        String r15 = r14.W();
    L28:
        ChatParam r16 = new ChatParam(r13, r15, null, null, null, 252);
        Uri r17 = ((ImageDetailFragment) this).d.A2(((ImageDetailFragment) this).m);
        if (r17 == null) goto L31;
        String r55 = r17.toString();
    L32:
        Bundle r26 = W90(r7);
        String r18 = r55;
        r11.W(new ny9.b(false, r4, r5, r16, true, false, null, null, r18, null, null, null, null, null, null, null, null, null, null, false, false, new c(this), null, r26, false, null, null, null, false, null, true, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1084227871, 262143));
        goto L33
    L31:
        r55 = null;
    L27:
        r15 = null;
    L21:
        r13 = null;
    L33:
        hy9.d r19 = IUgcAIGCService.a.j();
        Context r0 = getContext();
        if (r0 == null) goto L36;
        String r20 = r0.getString(2131906331);
    L37:
        com.larus.bmhome.actionbar.model.z0 r21 = ba0();
        if (r21 == null) goto L44;
        com.larus.bmhome.actionbar.model.r r22 = r21.q;
        if (r22 == null) goto L44;
        Integer r23 = r22.a;
        if (r23 == null) goto L44;
        String r24 = r23.toString();
    L45:
        com.larus.bmhome.actionbar.model.z0 r25 = ba0();
        if (r25 == null) goto L50;
        com.larus.bmhome.actionbar.model.r r27 = r25.q;
        if (r27 == null) goto L50;
        String r110 = r27.g;
    L52:
        if (this.s != 2) goto L54;
        String r111 = "creation_private";
    L55:
        hy9.d.a.a(r19, r20, null, null, "picture_detail", "single_function", null, null, r24, r110, r111, null, null, null, null, null, null, null, this.J, null, null, null, 4062310);
        return;
    L54:
        r111 = "creation_list";
    L50:
        r110 = null;
    L44:
        r24 = null;
        goto L45
    L36:
        r20 = null;
        goto L37
    L57:
        return;
    L7:
        r3 = false;
        goto L8
    }

    public final void o1() {
        ViewGroup r9 = this.K;
        if (r9 == null) goto L21;
        Balloon r0 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r9, (View) this.L.getValue(), false, null, null, null, null, 124);
        ViewGroup.LayoutParams r1 = ((View) this.L.getValue()).getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
    L8:
        if (r2 == null) goto L11;
        r2.setMarginEnd((-i5.Q()) + i5.r0());
    L11:
        Context r3 = getContext();
        if (r3 == null) goto L16;
        boolean r4 = true;
        if (com.larus.utils.i.h(r3) != true) goto L16;
    L17:
        if (r4 == false) goto L19;
        r0.x(r9, -r9.getMeasuredWidth(), -i5.Q());
        return;
    L19:
        r0.x(r9, r9.getMeasuredWidth(), -i5.Q());
        return;
    L16:
        r4 = false;
        goto L17
    L7:
        r2 = null;
        goto L8
    }

    public final void onDestroy() {
        ICommunityService.a.c1(this);
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public final void onResume() {
        super.onResume();
        UserCreation r1 = (UserCreation) CollectionsKt.firstOrNull(this.q);
        String r2 = null;
        if (r1 == null) goto L5;
        Integer r3 = r1.d;
    L6:
        boolean r4 = true;
        String r5 = "";
        if (r3 != null) goto L10;
    L12:
        if (r3 != null) goto L15;
    L17:
        String r6 = "";
    L18:
        UserCreation r7 = (UserCreation) CollectionsKt.firstOrNull(this.q);
        if (r7 == null) goto L21;
        Integer r8 = r7.d;
    L22:
        if (r8 != null) goto L25;
    L27:
        if (r8 != null) goto L30;
    L33:
        if (this.s != 2) goto L35;
        String r9 = "creation_private";
    L36:
        tx9.m0.c(r6, r5, "creation_detail", r9);
        CommonAiBeautifyLayout r10 = this.B;
        if (r10 != null) goto L39;
    L44:
        r4 = false;
    L45:
        if (r4 == false) goto L47;
    L50:
        hy9.d r11 = IUgcAIGCService.a.j();
        Context r12 = getContext();
        if (r12 == null) goto L53;
        String r13 = r12.getString(2131906324);
    L54:
        com.larus.bmhome.actionbar.model.z0 r14 = aa0();
        if (r14 == null) goto L61;
        com.larus.bmhome.actionbar.model.r r15 = r14.q;
        if (r15 == null) goto L61;
        Integer r16 = r15.a;
        if (r16 == null) goto L61;
        String r17 = r16.toString();
    L62:
        com.larus.bmhome.actionbar.model.z0 r18 = aa0();
        if (r18 == null) goto L67;
        com.larus.bmhome.actionbar.model.r r19 = r18.q;
        if (r19 == null) goto L67;
        String r110 = r19.g;
    L69:
        if (this.s != 2) goto L71;
        String r111 = "creation_private";
    L72:
        hy9.d.a.b(r11, r13, null, null, "picture_detail", "edit_entrance", null, null, r17, r110, r111, null, null, null, null, null, null, null, null, 1047654);
    L74:
        if (da0() == true) goto L76;
        return;
    L76:
        if (fa0() == false) goto L101;
        hy9.d r20 = IUgcAIGCService.a.j();
        Context r21 = getContext();
        if (r21 == null) goto L80;
        String r112 = r21.getString(2131906331);
    L81:
        com.larus.bmhome.actionbar.model.z0 r22 = ca0();
        if (r22 == null) goto L88;
        com.larus.bmhome.actionbar.model.r r23 = r22.q;
        if (r23 == null) goto L88;
        Integer r24 = r23.a;
        if (r24 == null) goto L88;
        String r113 = r24.toString();
    L89:
        com.larus.bmhome.actionbar.model.z0 r25 = ca0();
        if (r25 == null) goto L94;
        com.larus.bmhome.actionbar.model.r r26 = r25.q;
        if (r26 == null) goto L94;
        r2 = r26.g;
    L94:
        String r114 = r2;
        if (this.s != 2) goto L97;
        String r115 = "creation_private";
    L98:
        hy9.d.a.b(r20, r112, null, null, "picture_detail", "single_function", null, null, r113, r114, r115, null, null, null, null, null, null, null, null, 1047654);
        return;
    L97:
        r115 = "creation_list";
    L88:
        r113 = null;
        goto L89
    L80:
        r112 = null;
        goto L81
    L101:
        return;
    L71:
        r111 = "creation_list";
    L67:
        r110 = null;
    L61:
        r17 = null;
        goto L62
    L53:
        r13 = null;
        goto L54
    L47:
        if (ea0() == false) goto L74;
        if (fa0() == false) goto L74;
    L39:
        if (r10.getVisibility() != 0) goto L41;
        boolean r27 = true;
    L42:
        if (r27 != true) goto L44;
    L41:
        r27 = false;
        goto L42
    L35:
        r9 = "creation_list";
        goto L36
    L30:
        if (r8.intValue() != 1) goto L33;
        r5 = "1";
        goto L33
    L25:
        if (r8.intValue() != 2) goto L27;
        r5 = "0";
        goto L33
    L21:
        r8 = null;
        goto L22
    L15:
        if (r3.intValue() != 2) goto L17;
        r6 = "go_public";
        goto L18
    L10:
        if (r3.intValue() != 1) goto L12;
        r6 = "already_public";
        goto L18
    L5:
        r3 = null;
        goto L6
    }

    public final void T90() {
        CreationGroupFragment r0 = getParentFragment();
        if ((r0 instanceof CreationGroupFragment) == false) goto L5;
        CreationGroupFragment r1 = r0;
    L6:
        if (r1 == null) goto L9;
        CommonSlideFragment.S90(r1);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final Integer U90() {
        return 2131562861;
    }

    public final void u() {
        CreationGroupFragment r0 = getParentFragment();
        String r2 = null;
        if ((r0 instanceof CreationGroupFragment) == false) goto L5;
        CreationGroupFragment r1 = r0;
    L6:
        if (r1 == null) goto L8;
        Integer r3 = Integer.valueOf(r1.o);
    L10:
        if (ea0() == false) goto L37;
        hy9.d r6 = IUgcAIGCService.a.j();
        Context r4 = getContext();
        if (r4 == null) goto L14;
        String r7 = r4.getString(2131906324);
    L15:
        com.larus.bmhome.actionbar.model.z0 r5 = aa0();
        if (r5 == null) goto L22;
        com.larus.bmhome.actionbar.model.r r8 = r5.q;
        if (r8 == null) goto L22;
        Integer r9 = r8.a;
        if (r9 == null) goto L22;
        String r14 = r9.toString();
    L23:
        com.larus.bmhome.actionbar.model.z0 r10 = aa0();
        if (r10 == null) goto L28;
        com.larus.bmhome.actionbar.model.r r11 = r10.q;
        if (r11 == null) goto L28;
        String r15 = r11.g;
    L29:
        if (r3 != null) goto L32;
    L34:
        String r16 = "creation_list";
    L35:
        hy9.d.a.b(r6, r7, null, null, "picture_detail", "edit_entrance", null, null, r14, r15, r16, null, null, null, null, null, null, null, null, 1047654);
        goto L37
    L32:
        if (r3.intValue() != 2) goto L34;
        r16 = "creation_private";
    L28:
        r15 = null;
    L22:
        r14 = null;
        goto L23
    L14:
        r7 = null;
    L37:
        if (((Boolean) this.O.getValue()).booleanValue() == false) goto L112;
        IUgcAIGCService.Companion r12 = IUgcAIGCService.a;
        hy9.d r13 = r12.j();
        Context r17 = getContext();
        if (r17 == null) goto L41;
        String r18 = r17.getString(2131906330);
    L42:
        com.larus.bmhome.actionbar.model.z0 r19 = ba0();
        if (r19 == null) goto L49;
        com.larus.bmhome.actionbar.model.r r20 = r19.q;
        if (r20 == null) goto L49;
        Integer r21 = r20.a;
        if (r21 == null) goto L49;
        String r110 = r21.toString();
    L50:
        com.larus.bmhome.actionbar.model.z0 r22 = ba0();
        if (r22 == null) goto L55;
        com.larus.bmhome.actionbar.model.r r23 = r22.q;
        if (r23 == null) goto L55;
        String r111 = r23.g;
    L56:
        if (r3 != null) goto L59;
    L61:
        String r112 = "creation_list";
    L62:
        hy9.d.a.b(r13, r18, null, null, "picture_detail", "single_function", null, null, r110, r111, r112, null, null, null, null, null, null, null, null, 1047654);
        hy9.d r27 = r12.j();
        Context r24 = getContext();
        if (r24 == null) goto L65;
        String r28 = r24.getString(2131906326);
    L66:
        com.larus.bmhome.actionbar.model.z0 r25 = ba0();
        if (r25 == null) goto L73;
        com.larus.bmhome.actionbar.model.r r26 = r25.q;
        if (r26 == null) goto L73;
        Integer r29 = r26.a;
        if (r29 == null) goto L73;
        String r35 = r29.toString();
    L74:
        com.larus.bmhome.actionbar.model.z0 r30 = ba0();
        if (r30 == null) goto L79;
        com.larus.bmhome.actionbar.model.r r31 = r30.q;
        if (r31 == null) goto L79;
        String r36 = r31.g;
    L80:
        if (r3 != null) goto L83;
    L85:
        String r37 = "creation_list";
    L86:
        hy9.d.a.b(r27, r28, null, null, "picture_detail", "single_function", null, null, r35, r36, r37, null, null, null, null, null, null, null, null, 1047654);
        hy9.d r32 = r12.j();
        Context r33 = getContext();
        if (r33 == null) goto L89;
        String r34 = r33.getString(2131906329);
    L90:
        com.larus.bmhome.actionbar.model.z0 r38 = ba0();
        if (r38 == null) goto L97;
        com.larus.bmhome.actionbar.model.r r39 = r38.q;
        if (r39 == null) goto L97;
        Integer r40 = r39.a;
        if (r40 == null) goto L97;
        String r113 = r40.toString();
    L98:
        com.larus.bmhome.actionbar.model.z0 r41 = ba0();
        if (r41 == null) goto L103;
        com.larus.bmhome.actionbar.model.r r42 = r41.q;
        if (r42 == null) goto L103;
        String r114 = r42.g;
    L104:
        if (r3 != null) goto L107;
    L109:
        String r115 = "creation_list";
    L110:
        hy9.d.a.b(r32, r34, null, null, "picture_detail", "single_function", null, null, r113, r114, r115, null, null, null, null, null, null, null, null, 1047654);
        goto L112
    L107:
        if (r3.intValue() != 2) goto L109;
        r115 = "creation_private";
    L103:
        r114 = null;
    L97:
        r113 = null;
        goto L98
    L89:
        r34 = null;
        goto L90
    L83:
        if (r3.intValue() != 2) goto L85;
        r37 = "creation_private";
    L79:
        r36 = null;
    L73:
        r35 = null;
        goto L74
    L65:
        r28 = null;
        goto L66
    L59:
        if (r3.intValue() != 2) goto L61;
        r112 = "creation_private";
    L55:
        r111 = null;
    L49:
        r110 = null;
        goto L50
    L41:
        r18 = null;
    L112:
        if (da0() == false) goto L139;
        hy9.d r43 = IUgcAIGCService.a.j();
        Context r44 = getContext();
        if (r44 == null) goto L116;
        String r45 = r44.getString(2131906331);
    L117:
        com.larus.bmhome.actionbar.model.z0 r46 = ca0();
        if (r46 == null) goto L124;
        com.larus.bmhome.actionbar.model.r r47 = r46.q;
        if (r47 == null) goto L124;
        Integer r48 = r47.a;
        if (r48 == null) goto L124;
        String r116 = r48.toString();
    L125:
        com.larus.bmhome.actionbar.model.z0 r49 = ca0();
        if (r49 == null) goto L130;
        com.larus.bmhome.actionbar.model.r r50 = r49.q;
        if (r50 == null) goto L130;
        r2 = r50.g;
    L130:
        String r117 = r2;
        if (r3 != null) goto L134;
    L136:
        String r118 = "creation_list";
    L137:
        hy9.d.a.b(r43, r45, null, null, "picture_detail", "single_function", null, null, r116, r117, r118, null, null, null, null, null, null, null, null, 1047654);
        return;
    L134:
        if (r3.intValue() != 2) goto L136;
        r118 = "creation_private";
    L124:
        r116 = null;
        goto L125
    L116:
        r45 = null;
        goto L117
    L139:
        return;
    L8:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final EditPanelType SQ() {
        return EditPanelType.IMAGE;
    }

    public final int getType() {
        return this.p;
    }

    public final void onDestroyView() {
        super.onDestroyView();
    }

    public static Bundle W90(boolean r4) {
        Bundle r1 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("image_second_edit_scene", "generated_img_edit")});
        if (r4 == false) goto L5;
        r1.putBoolean("retain_ai_creation_home_memory", true);
    L5:
        return r1;
    }

    public final void FU(int r43) {
        String r2 = X90(((ImageDetailFragment) this).m);
        if (r2 != null) goto L10;
        Uri r3 = ((ImageDetailFragment) this).d.A2(((ImageDetailFragment) this).m);
        if (r3 == null) goto L7;
        r2 = r3.toString();
    L8:
        if (r2 != null) goto L10;
        r2 = "";
        goto L10
    L7:
        r2 = null;
    L10:
        String r5 = r2;
        UserCreation r4 = this.I;
        if (r4 == null) goto L13;
        ImageInfo r6 = i2.a(r4, ka0());
    L15:
        if (r43 != 1) goto L17;
        ma0();
        return;
    L17:
        if (r43 == 2) goto L142;
        long r7 = 0;
        if (r43 != 3) goto L21;
        Context r1 = getActivity();
        if (r1 == null) goto L149;
        ICreationService.Companion r8 = ICreationService.a;
        LifecycleCoroutineScope r14 = LifecycleOwnerKt.getLifecycleScope(this);
        if (r6 == null) goto L110;
        Image r9 = r6.c;
        if (r9 == null) goto L110;
        long r10 = r9.c;
    L111:
        if (r6 == null) goto L115;
        Image r11 = r6.c;
        if (r11 == null) goto L115;
        r7 = r11.d;
    L115:
        long r12 = r7;
        if (this.s != 2) goto L118;
        String r13 = "creation_private";
    L119:
        r8.e(r1, this, r14, new fs9.g(r5, r10, r12, 2, new fs9.h(r13), null, 32));
        hy9.d r19 = IUgcAIGCService.a.j();
        Context r15 = getContext();
        if (r15 == null) goto L122;
        String r20 = r15.getString(2131906326);
    L123:
        com.larus.bmhome.actionbar.model.z0 r16 = ba0();
        if (r16 == null) goto L130;
        com.larus.bmhome.actionbar.model.r r17 = r16.q;
        if (r17 == null) goto L130;
        Integer r18 = r17.a;
        if (r18 == null) goto L130;
        String r27 = r18.toString();
    L131:
        com.larus.bmhome.actionbar.model.z0 r21 = ba0();
        if (r21 == null) goto L136;
        com.larus.bmhome.actionbar.model.r r22 = r21.q;
        if (r22 == null) goto L136;
        String r28 = r22.g;
    L138:
        if (this.s != 2) goto L140;
        String r29 = "creation_private";
    L141:
        hy9.d.a.a(r19, r20, null, null, "picture_detail", "single_function", null, null, r27, r28, r29, null, null, null, null, null, null, null, this.J, null, null, null, 4062310);
        return;
    L140:
        r29 = "creation_list";
    L136:
        r28 = null;
    L130:
        r27 = null;
        goto L131
    L122:
        r20 = null;
        goto L123
    L118:
        r13 = "creation_list";
    L110:
        r10 = 0;
        goto L111
    L149:
        return;
    L21:
        if (r43 != 4) goto L23;
        Context r23 = getActivity();
        if (r23 == null) goto L147;
        ICreationService.Companion r24 = ICreationService.a;
        LifecycleCoroutineScope r110 = LifecycleOwnerKt.getLifecycleScope(this);
        if (r6 == null) goto L71;
        Image r25 = r6.c;
        if (r25 == null) goto L71;
        long r26 = r25.c;
    L72:
        if (r6 == null) goto L76;
        Image r30 = r6.c;
        if (r30 == null) goto L76;
        r7 = r30.d;
    L76:
        long r111 = r7;
        if (this.s != 2) goto L79;
        String r31 = "creation_private";
    L80:
        r24.e(r23, this, r110, new fs9.g(r5, r26, r111, 1, new fs9.h(r31), null, 32));
        hy9.d r112 = IUgcAIGCService.a.j();
        Context r32 = getContext();
        if (r32 == null) goto L83;
        String r210 = r32.getString(2131906330);
    L84:
        com.larus.bmhome.actionbar.model.z0 r33 = ba0();
        if (r33 == null) goto L91;
        com.larus.bmhome.actionbar.model.r r34 = r33.q;
        if (r34 == null) goto L91;
        Integer r35 = r34.a;
        if (r35 == null) goto L91;
        String r211 = r35.toString();
    L92:
        com.larus.bmhome.actionbar.model.z0 r36 = ba0();
        if (r36 == null) goto L97;
        com.larus.bmhome.actionbar.model.r r37 = r36.q;
        if (r37 == null) goto L97;
        String r212 = r37.g;
    L99:
        if (this.s != 2) goto L101;
        String r213 = "creation_private";
    L102:
        hy9.d.a.a(r112, r210, null, null, "picture_detail", "single_function", null, null, r211, r212, r213, null, null, null, null, null, null, null, this.J, null, null, null, 4062310);
        return;
    L101:
        r213 = "creation_list";
    L97:
        r212 = null;
    L91:
        r211 = null;
        goto L92
    L83:
        r210 = null;
        goto L84
    L79:
        r31 = "creation_list";
    L71:
        r26 = 0;
        goto L72
    L147:
        return;
    L23:
        if (r43 != 5) goto L152;
        Context r38 = getActivity();
        if (r38 == null) goto L145;
        ICreationService.Companion r113 = ICreationService.a;
        LifecycleCoroutineScope r114 = LifecycleOwnerKt.getLifecycleScope(this);
        if (r6 == null) goto L32;
        Image r39 = r6.c;
        if (r39 == null) goto L32;
        long r40 = r39.c;
    L33:
        if (r6 == null) goto L37;
        Image r41 = r6.c;
        if (r41 == null) goto L37;
        r7 = r41.d;
    L37:
        long r115 = r7;
        if (this.s != 2) goto L40;
        String r42 = "creation_private";
    L41:
        r113.e(r38, this, r114, new fs9.g(r5, r40, r115, 3, new fs9.h(r42), null, 32));
        hy9.d r116 = IUgcAIGCService.a.j();
        Context r44 = getContext();
        if (r44 == null) goto L44;
        String r214 = r44.getString(2131906329);
    L45:
        com.larus.bmhome.actionbar.model.z0 r45 = ba0();
        if (r45 == null) goto L52;
        com.larus.bmhome.actionbar.model.r r46 = r45.q;
        if (r46 == null) goto L52;
        Integer r47 = r46.a;
        if (r47 == null) goto L52;
        String r215 = r47.toString();
    L53:
        com.larus.bmhome.actionbar.model.z0 r48 = ba0();
        if (r48 == null) goto L58;
        com.larus.bmhome.actionbar.model.r r49 = r48.q;
        if (r49 == null) goto L58;
        String r216 = r49.g;
    L60:
        if (this.s != 2) goto L62;
        String r217 = "creation_private";
    L63:
        hy9.d.a.a(r116, r214, null, null, "picture_detail", "single_function", null, null, r215, r216, r217, null, null, null, null, null, null, null, this.J, null, null, null, 4062310);
        return;
    L62:
        r217 = "creation_list";
    L58:
        r216 = null;
    L52:
        r215 = null;
        goto L53
    L44:
        r214 = null;
        goto L45
    L40:
        r42 = "creation_list";
    L32:
        r40 = 0;
        goto L33
    L145:
        return;
    L152:
        return;
    L142:
        la0();
        return;
    L13:
        r6 = null;
        goto L15
    }

    @Override // zp9.r
    public final void X0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "creationId");
    }

    public final String X90(int r4) {
        com.larus.bmhome.bigimg.n1 r0 = Y90(r4);
        if (r0 == null) goto L13;
        String r1 = r0.c;
        if (r1 == null) goto L13;
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L13;
        return r1;
    L13:
        ImageAdapter r2 = ((ImageDetailFragment) this).d;
        if (r2 == null) goto L24;
        Uri r5 = r2.z2(r4);
        if (r5 == null) goto L25;
        String r6 = r5.toString();
        if (r6 != null) goto L20;
        return null;
    L20:
        if ((!StringsKt.isBlank(r6)) == true) goto L22;
        return null;
    L22:
        return r6;
    L25:
        return null;
    L24:
        return null;
    }

    public final com.larus.bmhome.bigimg.n1 Y90(int r2) {
        UserCreation r3 = (UserCreation) CollectionsKt.getOrNull(this.q, r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return e1.a(r3, ka0());
    }

    @Override // zp9.r
    public final void bZ(UserCreation r4) {
        Intrinsics.checkNotNullParameter(r4, "userCreation");
        String r0 = r4.a;
        if (r0 == null) goto L14;
        UserCreation r1 = this.I;
        if (r1 == null) goto L7;
        String r2 = r1.a;
    L9:
        if (Intrinsics.areEqual(r0, r2) == false) goto L15;
        FLogger.a.d("CreationImageDetailFragment", "onPublishSuccess, creationId: " + r4.a);
        CreationOperatorComponent r5 = this.X;
        if (r5 == null) goto L16;
        r5.f(2);
        return;
    L16:
        return;
    L15:
        return;
    L7:
        r2 = null;
        goto L9
    }

    public final void ga0(Uri r4) {
        FLogger.a.i("CreationImageDetailFragment", "onAlbumPicked, uri: " + r4);
        u1 r0 = this.E;
        if (r0 == null) goto L6;
        r0.c(r4.toString());
        return;
    }

    public final void na0(int r3) {
        if (r3 == ((ImageDetailFragment) this).m) goto L5;
        return;
    L5:
        CreationPagerFragment r0 = null;
        if (this.v.contains(Integer.valueOf(r3)) == true) goto L19;
        Fragment r4 = getParentFragment();
        if ((r4 instanceof CreationPagerFragment) == false) goto L11;
        r0 = (CreationPagerFragment) r4;
    L11:
        if (r0 == null) goto L13;
        r0.Z90(false);
    L13:
        CommonDownLoadLayout r1 = this.A;
        if (r1 == null) goto L16;
        r1.setLayoutEnable(false);
    L16:
        CommonAiBeautifyLayout r2 = this.B;
        if (r2 == null) goto L32;
        r2.setLayoutEnable(false);
        return;
    L32:
        return;
    L19:
        Fragment r5 = getParentFragment();
        if ((r5 instanceof CreationPagerFragment) == false) goto L23;
        r0 = (CreationPagerFragment) r5;
    L23:
        if (r0 == null) goto L25;
        r0.Z90(true);
    L25:
        CommonDownLoadLayout r6 = this.A;
        if (r6 == null) goto L28;
        r6.setLayoutEnable(true);
    L28:
        CommonAiBeautifyLayout r7 = this.B;
        if (r7 == null) goto L34;
        r7.setLayoutEnable(true);
        return;
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        ICommunityService.a.e1(this);
    }

    @Override // zp9.r
    public final void yE(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    public final void ia0(int r6, String r7) {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L6;
        r0.D0();
        com.larus.home.impl.sdk.b1.a.c("profile_private_share_save");
    L6:
        if (this.v.contains(Integer.valueOf(r6)) == true) goto L8;
        return;
    L8:
        if (r6 < 0) goto L40;
        ImageAdapter r1 = ((ImageDetailFragment) this).d;
        int r2 = 0;
        if (r1 == null) goto L14;
        List r3 = r1.b;
        if (r3 == null) goto L14;
        int r4 = r3.size();
    L15:
        if (r6 >= r4) goto L41;
        int r5 = x1.a;
        UserCreation r8 = this.I;
        gs9.d r9 = this.u;
        if (r9 == null) goto L20;
        gs9.b r10 = r9.f;
    L21:
        x1.b(r8, r10, null);
        ShareServiceDelegate r11 = ShareServiceDelegate.b;
        JSONObject r12 = new JSONObject();
        r12.put("click_method", r7);
        UserCreation r13 = this.I;
        if (r13 != null) goto L24;
    L26:
        int r14 = 0;
    L27:
        r12.put("is_replica_gen", r14);
        UserCreation r15 = this.I;
        if (r15 != null) goto L30;
    L32:
        r12.put("is_image_edit", r2);
        r11.w(r12);
        String r16 = X90(r6);
        if (r16 != null) goto L35;
        return;
    L35:
        IFlowSdkDepend r17 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r17 == null) goto L38;
        r17.D0();
        com.larus.home.impl.sdk.b1.a.d(r16);
    L38:
        ha0(r16, true, String.valueOf(((UserCreation) ListProtector.get(this.q, r6)).a));
        return;
    L30:
        if (r15.b != 4) goto L32;
        r2 = 1;
        goto L32
    L24:
        if (r13.b != 3) goto L26;
        r14 = 1;
        goto L27
    L20:
        r10 = null;
        goto L21
    L41:
        return;
    L14:
        r4 = 0;
        goto L15
    }

    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r13, r14);
        ViewGroup r15 = this.H;
        if (r15 == null) goto L5;
        com.larus.utils.i0.a.getClass();
        int r5 = com.larus.utils.i0.e() + i5.h();
        int r6 = r15.getPaddingStart();
        int r7 = r15.getPaddingTop();
        int r8 = r15.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r15.getClass().getSimpleName() + ",source:,start:" + r6 + ",top:" + r7 + ",end:" + r8 + ",bottom:" + r5);
        r15.setPaddingRelative(r6, r7, r8, r5);
    L5:
        ViewGroup r16 = this.K;
        if (r16 == null) goto L9;
        com.larus.utils.i0.a.getClass();
        int r9 = com.larus.utils.i0.g();
        int r10 = r16.getPaddingStart();
        int r11 = r16.getPaddingEnd();
        int r12 = r16.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + r16.getClass().getSimpleName() + ",source:,start:" + r10 + ",top:" + r9 + ",end:" + r11 + ",bottom:" + r12);
        r16.setPaddingRelative(r10, r9, r11, r12);
    L9:
        if (ja0() == false) goto L12;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationImageDetailFragment$prefetchToCreationBitmapCache$1(this, null), 3, null);
        return;
    }

    public final void ha0(String r83, boolean r84, String r85) {
        String r1 = null;
        if (r84 == false) goto L234;
        Context r3 = getContext();
        if (r3 == null) goto L240;
        ChatControlTrace r2 = ChatControlTrace.b;
        r2.getClass();
        String r9 = r2.bb(ChatControlTrace.y);
        String r11 = r2.h(ChatControlTrace.y);
        UserCreation r4 = this.I;
        if (r4 != null) goto L9;
    L11:
        boolean r16 = false;
    L12:
        if (r4 == null) goto L14;
        Integer r17 = Integer.valueOf(r4.b);
    L15:
        UserCreation r5 = this.I;
        if (r5 == null) goto L18;
        String r18 = r5.a;
    L19:
        if (r5 == null) goto L21;
        String r19 = zp9.d.d(r5);
    L22:
        UserCreation r6 = this.I;
        if (r6 == null) goto L25;
        String r20 = zp9.d.b(r6);
    L26:
        UserCreation r7 = this.I;
        if (r7 == null) goto L31;
        UserCreationTrackParams r8 = r7.n;
        if (r8 == null) goto L31;
        String r21 = r8.a;
    L32:
        if (r7 == null) goto L36;
        UserCreationTrackParams r10 = r7.n;
        if (r10 == null) goto L36;
        String r26 = r10.d;
    L37:
        if (r7 == null) goto L41;
        UserCreationTrackParams r12 = r7.n;
        if (r12 == null) goto L41;
        String r28 = r12.f;
    L42:
        if (r7 == null) goto L46;
        UserCreationTrackParams r13 = r7.n;
        if (r13 == null) goto L46;
        String r27 = r13.e;
    L47:
        if (r7 == null) goto L51;
        UserCreationTrackParams r14 = r7.n;
        if (r14 == null) goto L51;
        String r24 = r14.g;
    L52:
        gs9.d r15 = this.u;
        if (r15 == null) goto L58;
        gs9.b r22 = r15.f;
        if (r22 == null) goto L58;
        String r23 = r22.g;
        if (r23 == null) goto L58;
    L62:
        String r25 = r23;
    L64:
        if (r15 == null) goto L68;
        gs9.b r29 = r15.f;
        if (r29 == null) goto L68;
        Boolean r48 = r29.c;
    L69:
        if (r7 == null) goto L71;
        String r30 = r7.a;
    L72:
        com.larus.bmhome.share.panel.h r81 = new com.larus.bmhome.share.panel.h(null, null, r9, "creation_detail", r11, r24, null, null, null, r16, r17, r18, r19, r20, r21, null, null, r25, r48, r26, r27, r28, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r30, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -16382073, -4097, 1023);
        UserCreation r31 = this.I;
        if (r31 == null) goto L75;
        ImageInfo r32 = i2.a(r31, ka0());
    L77:
        if (ja0() == false) goto L205;
        Fragment r33 = getParentFragment();
        if (r33 == null) goto L241;
        FragmentManager r34 = r33.getFragmentManager();
        if (r34 == null) goto L242;
        com.larus.bmhome.bigimg.n1 r35 = Y90(((ImageDetailFragment) this).m);
        IFlowSdkDepend r36 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r36 == null) goto L243;
        r36.r0();
        com.larus.home.impl.sdk.e2 r37 = com.larus.home.impl.sdk.e2.a;
        if (r32 == null) goto L87;
        Image r38 = r32.c;
    L88:
        String r39 = i2.d(r38);
        if (r39 != null) goto L95;
        if (r35 == null) goto L92;
        r39 = r35.a;
    L93:
        if (r39 != null) goto L95;
        String r51 = "";
    L96:
        if (r32 == null) goto L98;
        Image r40 = r32.a;
    L99:
        String r41 = i2.d(r40);
        if (r41 != null) goto L106;
        if (r35 == null) goto L103;
        r41 = r35.c;
    L104:
        if (r41 != null) goto L106;
        String r52 = "";
    L107:
        if (r32 == null) goto L109;
        Image r42 = r32.i;
    L110:
        String r43 = i2.d(r42);
        if (r43 != null) goto L115;
        if (r35 == null) goto L114;
        r43 = r35.d;
        goto L115
    L114:
        String r53 = null;
    L116:
        UserCreation r44 = this.I;
        if (r44 == null) goto L121;
        AuthorInfo r45 = r44.g;
        if (r45 == null) goto L121;
        String r46 = r45.b;
    L123:
        if (Intrinsics.areEqual(r46, AccountService.a.getUserId()) == false) goto L149;
        UserCreation r47 = this.I;
        if (r47 == null) goto L129;
        UserCreationRefContent r49 = r47.o;
        if (r49 == null) goto L129;
        boolean r50 = Intrinsics.areEqual(r49.b, Boolean.TRUE);
    L130:
        if (r50 == true) goto L149;
        UserCreation r54 = this.I;
        if (r54 != null) goto L134;
    L136:
        boolean r55 = false;
    L137:
        if (r55 == true) goto L149;
        if (r54 == null) goto L149;
        UserCreationRefContent r56 = r54.o;
        if (r56 == null) goto L149;
        List<ImageInfo> r57 = r56.a();
        if (r57 == null) goto L149;
        ImageInfo r58 = (ImageInfo) CollectionsKt.getOrNull(r57, 0);
        if (r58 == null) goto L149;
        Image r59 = r58.c;
        if (r59 == null) goto L149;
        String r510 = r59.a;
    L150:
        ShareScene r511 = ShareScene.IMAGE_VIEWER_REPORT;
        long r60 = -1;
        if (r32 == null) goto L155;
        Image r61 = r32.a;
        if (r61 == null) goto L155;
        long r62 = r61.d;
    L160:
        long r63 = r62;
    L162:
        if (r32 == null) goto L167;
        Image r64 = r32.a;
        if (r64 == null) goto L167;
        r60 = r64.c;
    L166:
        long r512 = r60;
        UserCreation r65 = this.I;
        if (r65 == null) goto L175;
        String r513 = r65.a;
    L176:
        sq9.i r66 = new sq9.i("share", null, null, 6);
        Map r67 = IUgcAIGCService.a.H(r65, null);
        if (r32 == null) goto L182;
        Image r68 = r32.a;
        if (r68 == null) goto L182;
        String r69 = r68.e;
        if (r69 == null) goto L182;
    L203:
        String r610 = r69;
    L204:
        r37.Z0(r34, new sq9.j(r513, r51, r52, r53, r510, null, r81, r511, r512, r63, r66, r67, 0, null, null, null, r610, 61472));
        Unit r70 = Unit.INSTANCE;
        return;
    L182:
        if (r32 == null) goto L186;
        Image r71 = r32.c;
        if (r71 == null) goto L186;
        r69 = r71.e;
    L187:
        if (r69 != null) goto L203;
        if (r32 == null) goto L192;
        Image r72 = r32.b;
        if (r72 == null) goto L192;
        r69 = r72.e;
    L193:
        if (r69 != null) goto L203;
        if (r32 == null) goto L198;
        Image r73 = r32.i;
        if (r73 == null) goto L198;
        r69 = r73.e;
    L199:
        if (r69 != null) goto L203;
        if (r32 == null) goto L202;
        r1 = r32.e;
    L202:
        r610 = r1;
    L198:
        r69 = null;
    L192:
        r69 = null;
    L186:
        r69 = null;
        goto L187
    L175:
        r513 = null;
    L167:
        if (r35 == null) goto L169;
        Long r74 = r35.f;
    L170:
        if (r74 == null) goto L166;
        r60 = r74.longValue();
        goto L166
    L169:
        r74 = null;
    L155:
        if (r35 == null) goto L157;
        Long r75 = r35.g;
    L158:
        if (r75 == null) goto L161;
        r62 = r75.longValue();
        goto L160
    L161:
        r63 = -1;
        goto L162
    L157:
        r75 = null;
        goto L158
    L134:
        if (r54.b != 3) goto L136;
        r55 = true;
    L129:
        r50 = false;
    L149:
        r510 = null;
    L121:
        r46 = null;
    L115:
        r53 = r43;
        goto L116
    L109:
        r42 = null;
        goto L110
    L103:
        r41 = null;
    L106:
        r52 = r41;
        goto L107
    L98:
        r40 = null;
        goto L99
    L92:
        r39 = null;
    L95:
        r51 = r39;
        goto L96
    L87:
        r38 = null;
        goto L88
    L243:
        return;
    L242:
        return;
    L241:
        return;
    L205:
        IUgcAIGCService.Companion r76 = IUgcAIGCService.a;
        ShareScene r77 = ShareScene.IMAGE_VIEWER_REPORT;
        b r78 = new b(r85);
        UserCreation r79 = this.I;
        if (r32 == null) goto L211;
        Image r80 = r32.a;
        if (r80 == null) goto L211;
        String r82 = r80.e;
        if (r82 == null) goto L211;
    L232:
        String r110 = r82;
    L233:
        IUgcAIGCService$a.d(r76, r3, r83, r77, r78, r81, null, r79, r110, 352);
        Unit r86 = Unit.INSTANCE;
        return;
    L211:
        if (r32 == null) goto L215;
        Image r87 = r32.c;
        if (r87 == null) goto L215;
        r82 = r87.e;
    L216:
        if (r82 != null) goto L232;
        if (r32 == null) goto L221;
        Image r88 = r32.b;
        if (r88 == null) goto L221;
        r82 = r88.e;
    L222:
        if (r82 != null) goto L232;
        if (r32 == null) goto L227;
        Image r89 = r32.i;
        if (r89 == null) goto L227;
        r82 = r89.e;
    L228:
        if (r82 != null) goto L232;
        if (r32 == null) goto L231;
        r1 = r32.e;
    L231:
        r110 = r1;
    L227:
        r82 = null;
    L221:
        r82 = null;
    L215:
        r82 = null;
        goto L216
    L75:
        r32 = null;
        goto L77
    L71:
        r30 = null;
    L68:
        r48 = null;
    L58:
        if (r15 == null) goto L63;
        gs9.b r90 = r15.f;
        if (r90 == null) goto L63;
        r23 = r90.b;
    L63:
        r25 = null;
    L51:
        r24 = null;
    L46:
        r27 = null;
    L41:
        r28 = null;
    L36:
        r26 = null;
    L31:
        r21 = null;
        goto L32
    L25:
        r20 = null;
        goto L26
    L21:
        r19 = null;
        goto L22
    L18:
        r18 = null;
        goto L19
    L14:
        r17 = null;
        goto L15
    L9:
        if (r4.b != 3) goto L11;
        r16 = true;
        goto L12
    L240:
        return;
    L234:
        IFlowSdkDepend r91 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r91 == null) goto L238;
        r91.D0();
        com.larus.home.impl.sdk.b1 r92 = com.larus.home.impl.sdk.b1.a;
        r92.c("profile_private_canvas_download");
        r92.d(r83);
    L238:
        ImageDownloadLoadingMgr r93 = ImageDownloadLoadingMgr.a;
        ImageDownloadLoadingMgr.c(r83, IUgcAIGCService.a.H(this.I, null), new z(this), true, null, 36);
        Unit r94 = Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View onCreateView(LayoutInflater r24, ViewGroup r25, Bundle r26) {
        Intrinsics.checkNotNullParameter(r24, "inflater");
        View r1 = super.onCreateView(r24, r25, r26);
        FrameLayout r2 = ((ImageDetailFragment) this).i;
        if (r2 == null) goto L5;
        TextView r3 = (TextView) r2.findViewById(2131368005);
    L6:
        this.w = r3;
        FrameLayout r4 = ((ImageDetailFragment) this).i;
        if (r4 == null) goto L9;
        TextView r5 = (TextView) r4.findViewById(2131383382);
    L10:
        this.x = r5;
        FrameLayout r6 = ((ImageDetailFragment) this).i;
        if (r6 == null) goto L13;
        TextView r7 = (TextView) r6.findViewById(2131363578);
    L14:
        this.y = r7;
        FrameLayout r8 = ((ImageDetailFragment) this).i;
        if (r8 == null) goto L17;
        CommonDownLoadLayout r9 = (CommonDownLoadLayout) r8.findViewById(2131370179);
    L18:
        this.A = r9;
        FrameLayout r10 = ((ImageDetailFragment) this).i;
        if (r10 == null) goto L21;
        CommonAiBeautifyLayout r11 = (CommonAiBeautifyLayout) r10.findViewById(2131362380);
    L22:
        this.B = r11;
        FrameLayout r12 = ((ImageDetailFragment) this).i;
        if (r12 == null) goto L25;
        CommonTemplateLayout r13 = (CommonTemplateLayout) r12.findViewById(2131383377);
    L26:
        this.C = r13;
        UserCreation r14 = this.I;
        String r15 = "";
        if (r14 == null) goto L45;
        Boolean r16 = Boolean.valueOf(r14.b());
        if (r16.booleanValue() == true) goto L32;
        r16 = null;
    L32:
        if (r16 == null) goto L45;
        r16.booleanValue();
        CommonTemplateLayout r17 = this.C;
        if (r17 == null) goto L36;
        r17.setCustomIcon(2131243413);
    L36:
        CommonTemplateLayout r18 = this.C;
        if (r18 == null) goto L44;
        Context r19 = getContext();
        if (r19 == null) goto L42;
        String r20 = r19.getString(2131901253);
        if (r20 == null) goto L42;
    L43:
        r18.setCustomText(r20);
    L42:
        r20 = "";
    L44:
        r16.booleanValue();
    L65:
        RecyclerView r21 = ((ImageDetailFragment) this).h;
        int r22 = 2;
        if (r21 == null) goto L72;
        ViewGroup.LayoutParams r23 = r21.getLayoutParams();
        if (r23 == null) goto L71;
        FrameLayout.LayoutParams r27 = (FrameLayout.LayoutParams) r23;
        com.larus.utils.i0.a.getClass();
        r27.bottomMargin = ((((com.larus.utils.i0.e() + i5.h()) + i5.c0()) + i5.h()) - com.larus.utils.i0.g()) / 2;
        r21.setLayoutParams(r27);
        goto L72
    L71:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L72:
        FrameLayout r28 = ((ImageDetailFragment) this).i;
        if (r28 == null) goto L75;
        CreationOperateContainerView r29 = (CreationOperateContainerView) r28.findViewById(2131368277);
    L76:
        this.D = r29;
        FrameLayout r30 = ((ImageDetailFragment) this).i;
        if (r30 == null) goto L79;
        ViewGroup r31 = (ViewGroup) r30.findViewById(2131383028);
    L80:
        this.G = r31;
        FrameLayout r32 = ((ImageDetailFragment) this).i;
        if (r32 == null) goto L83;
        ViewGroup r33 = (ViewGroup) r32.findViewById(2131383424);
    L84:
        this.F = r33;
        FrameLayout r34 = ((ImageDetailFragment) this).i;
        if (r34 == null) goto L87;
        ViewGroup r35 = (ViewGroup) r34.findViewById(2131364544);
    L88:
        this.H = r35;
        if (r35 == null) goto L91;
        com.larus.utils.i0.a.getClass();
        int r110 = com.larus.utils.i0.e() + i5.h();
        int r111 = r35.getPaddingStart();
        int r112 = r35.getPaddingTop();
        int r113 = r35.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r35.getClass().getSimpleName() + ",source:,start:" + r111 + ",top:" + r112 + ",end:" + r113 + ",bottom:" + r110);
        r35.setPaddingRelative(r111, r112, r113, r110);
    L91:
        FrameLayout r36 = ((ImageDetailFragment) this).i;
        if (r36 == null) goto L94;
        BottomCreationEditView r37 = (BottomCreationEditView) r36.findViewById(2131364445);
    L95:
        this.z = r37;
        if (fa0() == false) goto L124;
        ViewGroup r38 = this.H;
        if (r38 == null) goto L100;
        com.larus.utils.e1.o(r38);
    L100:
        BottomCreationEditView r39 = this.z;
        if (r39 == null) goto L103;
        com.larus.utils.e1.x(r39);
    L103:
        BottomCreationEditView r40 = this.z;
        if (r40 == null) goto L106;
        com.larus.utils.i0.a.getClass();
        int r114 = com.larus.utils.i0.e() + i5.h();
        int r115 = r40.getPaddingStart();
        int r116 = r40.getPaddingTop();
        int r117 = r40.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:BottomCreationEditView,source:,start:" + r115 + ",top:" + r116 + ",end:" + r117 + ",bottom:" + r114);
        r40.setPaddingRelative(r115, r116, r117, r114);
    L106:
        BottomCreationEditView r41 = this.z;
        if (r41 == null) goto L130;
        LifecycleCoroutineScope r118 = LifecycleOwnerKt.getLifecycleScope(this);
        String r119 = String.valueOf(((ImageDetailFragment) this).d.z2(((ImageDetailFragment) this).m));
        UserCreation r42 = this.I;
        if (r42 == null) goto L111;
        Integer r43 = r42.d;
    L112:
        if (r43 != null) goto L115;
    L117:
        if (r43 != null) goto L120;
    L122:
        int r120 = 1;
    L123:
        r41.T5(r118, r119, r120, new b1(this), da0(), ea0());
        goto L130
    L120:
        if (r43.intValue() != 1) goto L122;
        r120 = 3;
        goto L123
    L115:
        if (r43.intValue() != 2) goto L117;
        r120 = 2;
        goto L123
    L111:
        r43 = null;
    L130:
        FrameLayout r44 = ((ImageDetailFragment) this).i;
        if (r44 == null) goto L133;
        ViewGroup r45 = (ViewGroup) r44.findViewById(2131388807);
    L134:
        this.K = r45;
        if (r45 == null) goto L137;
        r45.setBackgroundResource(R.color.transparent);
    L137:
        UserCreation r46 = this.I;
        if (r46 == null) goto L140;
        String r47 = r46.d();
    L141:
        UserCreation r48 = this.I;
        if (r48 == null) goto L147;
        AuthorInfo r49 = r48.g;
        if (r49 == null) goto L147;
        String r50 = r49.a;
        if (r50 == null) goto L147;
    L148:
        if (r48 == null) goto L152;
        Long r51 = r48.f;
        if (r51 == null) goto L152;
        long r52 = r51.longValue();
    L153:
        Intrinsics.checkNotNullParameter(r47, "des");
        Intrinsics.checkNotNullParameter(r50, "authorName");
        gs9.d r53 = this.u;
        if (r53 == null) goto L193;
        gs9.a r54 = r53.b;
        if (r54 == null) goto L193;
        FLogger.a.i("CreationImageDetailFragment", "bottomInfoConfig:" + r54);
        TextView r121 = this.x;
        if (r121 == null) goto L160;
        r121.setVisibility(0);
    L160:
        TextView r122 = this.x;
        if (r122 == null) goto L164;
        r122.setText(r47);
    L164:
        if (r54.a == false) goto L171;
        TextView r55 = this.y;
        if (r55 == null) goto L168;
        r55.setText("@".concat(r50));
    L168:
        TextView r56 = this.y;
        if (r56 == null) goto L174;
        r56.setVisibility(0);
    L174:
        StringBuilder r57 = new StringBuilder();
        TextView r58 = this.y;
        if (r58 != null) goto L177;
    L179:
        boolean r59 = false;
    L180:
        if (r59 == false) goto L182;
        r15 = " · ";
    L182:
        r57.append(r15);
        int r60 = CommonAuthorInfoLayout.c;
        r57.append(CommonAuthorInfoLayout.a.a(getContext(), r52));
        String r61 = r57.toString();
        if (r54.b == false) goto L190;
        TextView r62 = this.w;
        if (r62 == null) goto L187;
        r62.setVisibility(0);
    L187:
        TextView r63 = this.w;
        if (r63 == null) goto L193;
        r63.setText(r61);
        goto L193
    L190:
        TextView r64 = this.w;
        if (r64 == null) goto L193;
        r64.setVisibility(8);
        goto L193
    L177:
        if (r58.getVisibility() != 0) goto L179;
        r59 = true;
        goto L180
    L171:
        TextView r65 = this.y;
        if (r65 == null) goto L174;
        r65.setVisibility(8);
    L193:
        Uri r66 = ((ImageDetailFragment) this).d.z2(((ImageDetailFragment) this).m);
        if (r66 == null) goto L198;
        CommonDownLoadLayout r67 = this.A;
        if (r67 == null) goto L198;
        r67.S5(LifecycleOwnerKt.getLifecycleScope(this), new com.larus.bmhome.bigimg.download.d.a(r66.toString()));
    L198:
        com.larus.utils.e1.d(this.A, new k0(this));
        com.larus.utils.e1.d(this.B, new s0(this));
        CommonAiBeautifyLayout r68 = this.B;
        if (r68 != null) goto L201;
    L210:
        com.larus.utils.w0.e(this.C, j19.c.c(12));
        CommonTemplateLayout r69 = this.C;
        if (r69 == null) goto L219;
        Context r70 = getContext();
        if (r70 == null) goto L217;
        Resources r71 = r70.getResources();
        if (r71 == null) goto L217;
        Integer r72 = Integer.valueOf(r71.getColor(2131103298));
    L218:
        ViewGroup r73 = null;
        r69.setBackground(com.larus.utils.w0.b(r72, null, 0.2f, null, 8));
    L220:
        Context r74 = getContext();
        if (r74 != null) goto L223;
        r74 = AppHost.a.getApplication();
    L223:
        Context r123 = r74;
        CommonTemplateLayout r124 = this.C;
        if (fa0() == false) goto L229;
        BottomCreationEditView r75 = this.z;
        if (r75 == null) goto L228;
        ViewGroup r76 = (ViewGroup) r75.findViewById(2131383425);
    L230:
        ViewGroup r125 = r76;
    L231:
        CreationOperateContainerView r126 = this.D;
        UserCreation r77 = this.I;
        String r78 = this.J;
        LifecycleCoroutineScope r127 = LifecycleOwnerKt.getLifecycleScope(this);
        int r79 = this.s;
        j2 r80 = getParentFragment();
        Intrinsics.checkNotNull(r80, "null cannot be cast to non-null type com.larus.profile.impl.creation.ICreationDelegateInterface");
        this.X = new CreationOperatorComponent(r123, r124, r125, r126, r77, r127, r80, Integer.valueOf(r79), this.u, true, r78);
        Context r81 = getContext();
        if (r81 != null) goto L234;
        r81 = AppHost.a.getApplication();
    L234:
        Context r128 = r81;
        CommonTemplateLayout r129 = this.C;
        UserCreation r130 = this.I;
        LifecycleCoroutineScope r131 = LifecycleOwnerKt.getLifecycleScope(this);
        gs9.d r82 = this.u;
        if (r82 == null) goto L237;
        boolean r132 = r82.e;
    L238:
        if (r82 == null) goto L240;
        boolean r133 = r82.d;
    L241:
        if (r82 == null) goto L243;
        gs9.b r134 = r82.f;
    L244:
        this.E = new u1(r128, r129, r131, r130, r133, r132, r134);
        ImageAdapter r83 = ((ImageDetailFragment) this).d;
        r83.f = new t0(this);
        r83.j = new u0(this);
        r83.i = new v0(this);
        if (com.larus.utils.o0.d(this.r) == false) goto L249;
        CommonDownLoadLayout r84 = this.A;
        if (r84 == null) goto L249;
        com.larus.utils.e1.o(r84);
    L249:
        ViewGroup r85 = this.G;
        if (r85 == null) goto L252;
        com.larus.utils.e1.d(r85, new n0(this));
    L252:
        ViewGroup r86 = this.F;
        if (r86 == null) goto L255;
        com.larus.utils.e1.d(r86, new o0(this));
    L255:
        com.larus.utils.e1.d(this.C, new p0(this));
        if (com.larus.utils.o0.d(this.r) == false) goto L258;
        int r87 = 4;
    L275:
        if (getContext() == null) goto L282;
        CommonDownLoadLayout r88 = this.A;
        if (r88 == null) goto L279;
        r88.setBackgroundResource(2131238692);
    L279:
        CommonAiBeautifyLayout r89 = this.B;
        if (r89 == null) goto L282;
        r89.setBackgroundResource(2131238692);
    L282:
        u1 r90 = this.E;
        if (r90 == null) goto L285;
        r90.e(r87);
    L285:
        CreationOperatorComponent r91 = this.X;
        if (r91 == null) goto L288;
        r91.f(r87);
    L288:
        return r1;
    L258:
        UserCreation r92 = this.I;
        if (r92 == null) goto L261;
        Integer r93 = r92.d;
    L262:
        if (r93 != 0) goto L265;
    L267:
        if (r93 != 0) goto L270;
    L272:
        r22 = 0;
    L273:
        r87 = r22;
        goto L275
    L270:
        if (r93.intValue() != 1) goto L272;
    L265:
        if (r93.intValue() != 2) goto L267;
        r22 = 3;
        goto L273
    L261:
        r93 = r73;
        goto L262
    L243:
        r134 = r73;
        goto L244
    L240:
        r133 = false;
        goto L241
    L237:
        r132 = false;
        goto L238
    L228:
        r125 = r73;
        goto L231
    L229:
        r76 = this.G;
    L217:
        r72 = null;
        goto L218
    L219:
        r73 = null;
        goto L220
    L201:
        if (ea0() == true) goto L203;
    L205:
        boolean r94 = false;
    L206:
        if (r94 == false) goto L208;
        int r95 = 0;
    L209:
        r68.setVisibility(r95);
        goto L210
    L208:
        r95 = 8;
        goto L209
    L203:
        if (((Boolean) this.V.getValue()).booleanValue() == true) goto L205;
        r94 = true;
    L152:
        r52 = 0;
    L147:
        r50 = "";
        goto L148
    L140:
        r47 = "";
        goto L141
    L133:
        r45 = null;
        goto L134
    L124:
        BottomCreationEditView r96 = this.z;
        if (r96 == null) goto L127;
        com.larus.utils.e1.o(r96);
    L127:
        ViewGroup r97 = this.H;
        if (r97 == null) goto L130;
        com.larus.utils.e1.x(r97);
        goto L130
    L94:
        r37 = null;
        goto L95
    L87:
        r35 = null;
        goto L88
    L83:
        r33 = null;
        goto L84
    L79:
        r31 = null;
        goto L80
    L75:
        r29 = null;
    L45:
        CommonTemplateLayout r98 = this.C;
        if (r98 == null) goto L48;
        r98.a.c.setImageResource(2131242261);
        r98.a.b.setText(r98.getContext().getString(2131907247));
    L48:
        UserCreation r99 = this.I;
        if (r99 == null) goto L53;
        CreationDynamicInfo r100 = r99.h;
        if (r100 == null) goto L53;
        String r101 = r100.c;
    L55:
        if (com.larus.utils.o0.d(r101) == false) goto L65;
        CommonTemplateLayout r102 = this.C;
        if (r102 == null) goto L65;
        UserCreation r103 = this.I;
        if (r103 == null) goto L63;
        CreationDynamicInfo r104 = r103.h;
        if (r104 == null) goto L63;
        String r105 = r104.c;
    L64:
        r102.setCustomText(String.valueOf(r105));
    L63:
        r105 = null;
    L53:
        r101 = null;
        goto L55
    L25:
        r13 = null;
        goto L26
    L21:
        r11 = null;
        goto L22
    L17:
        r9 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    @Override // zp9.r
    public final void i20(UserCreation r1, long r2, long r4, String r6) {
        zp9.r.a.a(r1, r6);
    }

    public CreationImageDetailFragment(ImageAdapter r10, List r11, String r12, int r13, gs9.d r14, int r15) {
        if ((r15 & 16) == 0) goto L6;
        r13 = 2;
    L6:
        if ((r15 & 64) == 0) goto L8;
        r14 = null;
    L8:
        Intrinsics.checkNotNullParameter(r10, "transitionAdapter");
        Intrinsics.checkNotNullParameter(r11, "userCreations");
        r10.h = null;
        r10.l = true;
        List r1 = r11;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r4 = r1.iterator();
    L9:
        boolean r6 = false;
        if (r4.hasNext() == false) goto L17;
        UserCreation r5 = (UserCreation) r4.next();
        if (r12 != null) goto L14;
    L15:
        r6 = true;
    L16:
        r2.add(e1.a(r5, r6));
        goto L9
    L14:
        if (r12.length() != 0) goto L16;
    L17:
        List r3 = CollectionsKt.toMutableList(r2);
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r8 = r1.iterator();
    L19:
        if (r8.hasNext() == false) goto L54;
        UserCreation r9 = (UserCreation) r8.next();
        if (r12 != null) goto L23;
    L26:
        boolean r16 = true;
    L27:
        Intrinsics.checkNotNullParameter(r9, "<this>");
        ImageInfo r17 = i2.c(r9);
        ImageInfo r18 = i2.a(r9, r16);
        if (r16 == true) goto L30;
    L40:
        String r19 = null;
    L41:
        if (r19 != null) goto L53;
        if (r18 == null) goto L44;
        Image r20 = r18.b;
    L45:
        r19 = i2.d(r20);
        if (r19 != null) goto L53;
        if (r18 == null) goto L49;
        Image r21 = r18.c;
    L50:
        r19 = i2.d(r21);
        if (r19 != null) goto L53;
        r19 = r9.r();
        goto L53
    L49:
        r21 = null;
        goto L50
    L44:
        r20 = null;
    L53:
        r7.add(r19);
        goto L19
    L30:
        if (CreationNoWatermarkManager.a.D() == false) goto L40;
        if (r17 == null) goto L33;
        Image r22 = r17.j;
    L34:
        r19 = i2.d(r22);
        if (r19 != null) goto L41;
        if (r17 == null) goto L38;
        Image r23 = r17.b;
    L39:
        r19 = i2.d(r23);
        goto L41
    L38:
        r23 = null;
        goto L39
    L33:
        r22 = null;
        goto L34
    L23:
        if (r12.length() == 0) goto L26;
        r16 = false;
        goto L27
    L54:
        super(r10, r3, r7, new w0());
        this.p = 1;
        this.q = r11;
        this.r = r12;
        this.s = r13;
        this.t = null;
        this.u = r14;
        this.v = new LinkedHashSet();
        this.L = LazyKt.lazy(new a0(this));
        this.O = LazyKt.lazy(new b0());
        this.P = LazyKt.lazy(new c0());
        this.Q = LazyKt.lazy(new d0(this));
        this.R = LazyKt.lazy(new e0(this));
        this.S = LazyKt.lazy(new f0(this));
        this.T = LazyKt.lazy(new g0(this));
        this.U = LazyKt.lazy(new h0(this));
        this.V = LazyKt.lazy(new i0(this));
        this.W = LazyKt.lazy(new x0(this));
        Function1 r110 = new y0(this);
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r10.d = r110;
        r10.e = new z0(this);
        ((ImageDetailFragment) this).j = new a1(this);
        this.I = (UserCreation) CollectionsKt.firstOrNull(r11);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass8(this, null), 3, null);
        this.M = registerForActivityResult(new ActivityResultContracts.GetContent(), new l0(this));
        this.N = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new m0(this));
    }
}
