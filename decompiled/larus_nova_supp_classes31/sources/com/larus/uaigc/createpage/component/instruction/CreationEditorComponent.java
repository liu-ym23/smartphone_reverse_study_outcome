package com.larus.uaigc.createpage.component.instruction;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.collection.LruCache;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.router.SmartRouter;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.InstructionInputManager;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.community.ICreationPageService;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.instruction.service.IInstructionService;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.CustomInputInitData;
import com.larus.platform.api.g3;
import com.larus.platform.creation.CreationMultiReferenceLogEvent;
import com.larus.platform.creation.CreationMultiReferenceProtocolState;
import com.larus.platform.creation.CreationMultiReferenceRuleResult;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.platform.model.KmpInstructionCoreOptConfig;
import com.larus.platform.model.creation.ResourceExt;
import com.larus.platform.model.video.VideoPortraitConfig;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.bean.createpage.component.mediacontainer.CreationReferenceAttachmentType;
import com.larus.uaigc.bean.createpage.component.mediacontainer.CreationReferenceAttachmentViolation;
import com.larus.uaigc.createpage.CreationHalfChatFragment;
import com.larus.uaigc.createpage.CreationHostUiPolicy;
import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.larus.uaigc.createpage.component.helper.AlbumHelperKt;
import com.larus.uaigc.instruction.MultiAttachmentSelectorWidget;
import com.larus.uaigc.service.CreationDoSameNotifyInfo;
import com.larus.uaigc.service.ICreationNotifyService;
import com.larus.uaigc.service.ICreationReportService;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import tx9.l3;
import tx9.u3;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000í\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u000b*\u0003O\u009b\u0001\b\u0016\u0018\u0000 \u008c\u00042\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0002\u008c\u0004B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u009f\u0001\u001a\u00020E*\u00020)H\u0002J\t\u0010£\u0001\u001a\u00020EH\u0016J\u000b\u0010¥\u0001\u001a\u0004\u0018\u00010CH\u0016J\u000b\u0010Ð\u0001\u001a\u0004\u0018\u00010\u0011H\u0002J\n\u0010Ñ\u0001\u001a\u00030Ò\u0001H\u0016J\n\u0010Ó\u0001\u001a\u00030Ò\u0001H\u0016J\n\u0010Ô\u0001\u001a\u00030Ò\u0001H\u0002J\n\u0010Õ\u0001\u001a\u00030Ò\u0001H\u0016J&\u0010Ö\u0001\u001a\u00030Ò\u00012\b\u0010×\u0001\u001a\u00030Ø\u00012\u0007\u0010Ù\u0001\u001a\u00020\u000b2\u0007\u0010Ú\u0001\u001a\u00020CH\u0016J\"\u0010Û\u0001\u001a\u00030Ò\u00012\n\u0010×\u0001\u001a\u0005\u0018\u00010Ü\u00012\n\u0010Ý\u0001\u001a\u0005\u0018\u00010Þ\u0001H\u0016Jb\u0010ß\u0001\u001a\u00030Ò\u00012\u0007\u0010à\u0001\u001a\u00020A2\t\u0010á\u0001\u001a\u0004\u0018\u00010;2\u0007\u0010â\u0001\u001a\u00020\u000b2\t\u0010ã\u0001\u001a\u0004\u0018\u00010C2\n\u0010ä\u0001\u001a\u0005\u0018\u00010å\u00012\t\u0010æ\u0001\u001a\u0004\u0018\u00010\u000b2\u0011\u0010ç\u0001\u001a\f\u0012\u0005\u0012\u00030Ò\u0001\u0018\u00010è\u0001H\u0016¢\u0006\u0003\u0010é\u0001J\u0014\u0010ê\u0001\u001a\u00030Ò\u00012\b\u0010ë\u0001\u001a\u00030ì\u0001H\u0016J\t\u0010í\u0001\u001a\u00020\u000bH\u0016J\n\u0010î\u0001\u001a\u00030Ò\u0001H\u0016J\t\u0010ï\u0001\u001a\u00020\u000bH\u0016J\n\u0010ð\u0001\u001a\u00030Ò\u0001H\u0016J\n\u0010ñ\u0001\u001a\u00030Ò\u0001H\u0016J\n\u0010ò\u0001\u001a\u00030ó\u0001H\u0014J\n\u0010ô\u0001\u001a\u00030Ò\u0001H\u0002J\u000b\u0010õ\u0001\u001a\u0004\u0018\u00010)H\u0003J\u0013\u0010ö\u0001\u001a\u00030Ò\u00012\u0007\u0010÷\u0001\u001a\u00020AH\u0002J\n\u0010ø\u0001\u001a\u00030Ò\u0001H\u0004J\u0012\u0010ù\u0001\u001a\u00020E2\u0007\u0010ú\u0001\u001a\u00020\u000bH\u0016J\n\u0010û\u0001\u001a\u00030Ò\u0001H\u0002J\u001e\u0010ü\u0001\u001a\u00030Ò\u00012\b\u0010ý\u0001\u001a\u00030þ\u00012\b\u0010ÿ\u0001\u001a\u00030¸\u0001H\u0002J\u001a\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u000b2\u0007\u0010à\u0001\u001a\u00020AH\u0002¢\u0006\u0003\u0010\u0081\u0002J\f\u0010\u0082\u0002\u001a\u0005\u0018\u00010\u0083\u0002H\u0016J\t\u0010\u0084\u0002\u001a\u00020?H\u0016J\t\u0010\u0085\u0002\u001a\u00020EH\u0002J\u001d\u0010\u0086\u0002\u001a\u00020E2\u0007\u0010\u0087\u0002\u001a\u00020>2\t\b\u0002\u0010\u0088\u0002\u001a\u00020EH\u0002J\u001b\u0010\u0089\u0002\u001a\u00020E2\u0007\u0010\u008a\u0002\u001a\u00020\u000b2\u0007\u0010\u008b\u0002\u001a\u00020\u000bH\u0002J\u0012\u0010\u008c\u0002\u001a\u00020E2\u0007\u0010\u008d\u0002\u001a\u00020AH\u0002JJ\u0010\u008e\u0002\u001a\u00030Ò\u00012\u0007\u0010\u008f\u0002\u001a\u00020C2\u0007\u0010\u0090\u0002\u001a\u00020C2\t\u0010\u0091\u0002\u001a\u0004\u0018\u00010C2\b\u0010\u0092\u0002\u001a\u00030\u0093\u00022\n\u0010\u0094\u0002\u001a\u0005\u0018\u00010\u0095\u00022\u000b\b\u0002\u0010\u0096\u0002\u001a\u0004\u0018\u00010CH\u0002J\u000f\u0010\u0097\u0002\u001a\u00030\u0098\u0002*\u00030\u0093\u0002H\u0002J\"\u0010\u0099\u0002\u001a\u00020E2\n\u0010\u0094\u0002\u001a\u0005\u0018\u00010\u0095\u00022\u000b\b\u0002\u0010\u009a\u0002\u001a\u0004\u0018\u00010CH\u0002J\t\u0010\u009b\u0002\u001a\u00020EH\u0016J\t\u0010\u009c\u0002\u001a\u00020EH\u0002J\t\u0010\u009d\u0002\u001a\u00020EH\u0016J\t\u0010\u009e\u0002\u001a\u00020EH\u0016J(\u0010§\u0002\u001a\u00030Ò\u00012\u0007\u0010ú\u0001\u001a\u00020\u000b2\b\u0010ÿ\u0001\u001a\u00030¸\u00012\t\b\u0002\u0010¨\u0002\u001a\u00020EH\u0014J\u001a\u0010©\u0002\u001a\u00020E2\t\u0010ª\u0002\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0003\u0010«\u0002J\n\u0010¯\u0002\u001a\u00030Ò\u0001H\u0014J\u0014\u0010°\u0002\u001a\u00030Ò\u00012\b\u0010±\u0002\u001a\u00030²\u0002H\u0002J\n\u0010³\u0002\u001a\u00030Ò\u0001H\u0002J\u0013\u0010´\u0002\u001a\u00030Ò\u00012\u0007\u0010µ\u0002\u001a\u00020)H\u0016J\r\u0010¶\u0002\u001a\u00020;*\u00020;H\u0002J\n\u0010·\u0002\u001a\u00030Ò\u0001H\u0002J\n\u0010¸\u0002\u001a\u00030Ò\u0001H\u0002J5\u0010¼\u0002\u001a\u00030½\u00022)\u0010¾\u0002\u001a$\u0012\u0016\u0012\u00140\u000b¢\u0006\u000f\bÀ\u0002\u0012\n\bÁ\u0002\u0012\u0005\b\b(Â\u0002\u0012\u0007\u0012\u0005\u0018\u00010Ò\u00010¿\u0002H\u0002J\u0014\u0010Ã\u0002\u001a\u0004\u0018\u00010C2\u0007\u0010ú\u0001\u001a\u00020\u000bH\u0016J\t\u0010Ä\u0002\u001a\u00020\u000bH\u0016J\t\u0010Å\u0002\u001a\u00020EH\u0016JE\u0010Æ\u0002\u001a\u00030Ò\u00012\u0007\u0010Ç\u0002\u001a\u00020A2\u0007\u0010â\u0001\u001a\u00020\u000b2\u000b\b\u0002\u0010ã\u0001\u001a\u0004\u0018\u00010C2\f\b\u0002\u0010ä\u0001\u001a\u0005\u0018\u00010å\u00012\f\b\u0002\u0010È\u0002\u001a\u0005\u0018\u00010É\u0002H\u0002J\u0012\u0010Ê\u0002\u001a\u00020E2\u0007\u0010Ç\u0002\u001a\u00020AH\u0002J\u0012\u0010Ë\u0002\u001a\u00020C2\u0007\u0010÷\u0001\u001a\u00020AH\u0002J\u0013\u0010Ì\u0002\u001a\u00030Ò\u00012\u0007\u0010Í\u0002\u001a\u00020EH\u0002J\u001c\u0010Î\u0002\u001a\u00030Ò\u00012\u0007\u0010Í\u0002\u001a\u00020E2\u0007\u0010Ï\u0002\u001a\u00020EH\u0002J\n\u0010Ð\u0002\u001a\u00030Ò\u0001H\u0002J\t\u0010Ñ\u0002\u001a\u00020EH\u0016J\t\u0010Ò\u0002\u001a\u00020EH\u0016J\n\u0010Ó\u0002\u001a\u00030Ò\u0001H\u0016J\n\u0010Ô\u0002\u001a\u00030Ò\u0001H\u0016J\n\u0010Õ\u0002\u001a\u00030Ò\u0001H\u0016J\t\u0010Ö\u0002\u001a\u00020CH\u0016J\t\u0010×\u0002\u001a\u00020EH\u0016J\t\u0010Ø\u0002\u001a\u00020\u000bH\u0016J\u0013\u0010Ù\u0002\u001a\u00030Ò\u00012\u0007\u0010Ú\u0002\u001a\u00020CH\u0016J\t\u0010Û\u0002\u001a\u00020EH\u0016J\t\u0010Ü\u0002\u001a\u00020EH\u0016J\t\u0010Ý\u0002\u001a\u00020EH\u0002J\u0013\u0010Þ\u0002\u001a\f\u0012\u0005\u0012\u00030à\u0002\u0018\u00010ß\u0002H\u0016J\u0011\u0010á\u0002\u001a\u0004\u0018\u00010>H\u0016¢\u0006\u0003\u0010â\u0002J\u001b\u0010ã\u0002\u001a\u00030Ò\u00012\u000f\u0010ä\u0002\u001a\n\u0012\u0005\u0012\u00030à\u00020ß\u0002H\u0016J\u001a\u0010å\u0002\u001a\u00030Ò\u00012\u000e\u0010æ\u0002\u001a\t\u0012\u0004\u0012\u00020E0è\u0001H\u0016J\u0013\u0010í\u0002\u001a\f\u0012\u0005\u0012\u00030à\u0002\u0018\u00010ß\u0002H\u0016J\u001c\u0010î\u0002\u001a\u00030Ò\u00012\u0007\u0010÷\u0001\u001a\u00020A2\u0007\u0010ï\u0002\u001a\u00020EH\u0002J\f\u0010ð\u0002\u001a\u0005\u0018\u00010ñ\u0002H\u0016J\t\u0010ò\u0002\u001a\u00020EH\u0002J\u001f\u0010ó\u0002\u001a\u00030Ò\u00012\u0007\u0010ô\u0002\u001a\u00020\u000b2\n\u0010õ\u0002\u001a\u0005\u0018\u00010«\u0001H\u0002J\u0012\u0010ö\u0002\u001a\u00020E2\u0007\u0010÷\u0002\u001a\u00020CH\u0016J\u0012\u0010ø\u0002\u001a\u00020C2\u0007\u0010ù\u0002\u001a\u00020CH\u0016J\u0012\u0010ú\u0002\u001a\u00020C2\u0007\u0010ù\u0002\u001a\u00020CH\u0002J\u0016\u0010û\u0002\u001a\u0004\u0018\u00010;2\t\u0010ü\u0002\u001a\u0004\u0018\u00010CH\u0016J\t\u0010ý\u0002\u001a\u00020EH\u0016J\u0013\u0010þ\u0002\u001a\u00030Ò\u00012\u0007\u0010ÿ\u0002\u001a\u00020EH\u0016J\u0013\u0010\u0080\u0003\u001a\u00030Ò\u00012\u0007\u0010ÿ\u0002\u001a\u00020EH\u0016J\f\u0010\u0081\u0003\u001a\u0005\u0018\u00010\u0082\u0003H\u0016J\u000b\u0010\u0083\u0003\u001a\u0004\u0018\u00010CH\u0016J\f\u0010\u0084\u0003\u001a\u0005\u0018\u00010\u0082\u0003H\u0016J\u0019\u0010\u0085\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u000b0Yj\b\u0012\u0004\u0012\u00020\u000b`[H\u0016J\u000b\u0010û\u0002\u001a\u0004\u0018\u00010;H\u0016J\u000b\u0010\u0086\u0003\u001a\u0004\u0018\u00010CH\u0016J\t\u0010\u0087\u0003\u001a\u00020EH\u0016J\u001d\u0010\u0088\u0003\u001a\u0004\u0018\u00010C2\u0007\u0010ù\u0002\u001a\u00020C2\u0007\u0010\u0089\u0003\u001a\u00020EH\u0016J\u0013\u0010\u008a\u0003\u001a\u00030Ò\u00012\u0007\u0010\u008b\u0003\u001a\u00020>H\u0016J\u001c\u0010\u008a\u0003\u001a\u00030Ò\u00012\u0007\u0010\u008c\u0003\u001a\u00020\u000b2\u0007\u0010\u008b\u0003\u001a\u00020>H\u0016J\u001c\u0010\u008d\u0003\u001a\u00030Ò\u00012\u0007\u0010\u008c\u0003\u001a\u00020\u000b2\u0007\u0010\u008b\u0003\u001a\u00020>H\u0016J\u001c\u0010\u008e\u0003\u001a\u00030Ò\u00012\u0007\u0010\u008c\u0003\u001a\u00020\u000b2\u0007\u0010\u008b\u0003\u001a\u00020>H\u0016J\u0013\u0010\u008f\u0003\u001a\u00030\u0090\u00032\u0007\u0010\u0091\u0003\u001a\u00020>H\u0016J\t\u0010\u0092\u0003\u001a\u00020CH\u0016J\n\u0010\u0093\u0003\u001a\u00030Ò\u0001H\u0016J(\u0010\u0094\u0003\u001a\u00030Ò\u00012\u0007\u0010\u0095\u0003\u001a\u00020\u000b2\u0007\u0010ô\u0002\u001a\u00020\u000b2\n\u0010õ\u0002\u001a\u0005\u0018\u00010«\u0001H\u0016J\n\u0010\u0096\u0003\u001a\u00030Ò\u0001H\u0002J\u0016\u0010\u0097\u0003\u001a\u00030Ò\u00012\n\u0010õ\u0002\u001a\u0005\u0018\u00010«\u0001H\u0002J\u0016\u0010\u0098\u0003\u001a\u00030Ò\u00012\n\u0010õ\u0002\u001a\u0005\u0018\u00010«\u0001H\u0016J\u0016\u0010\u0099\u0003\u001a\u00030Ò\u00012\n\u0010õ\u0002\u001a\u0005\u0018\u00010«\u0001H\u0016J\n\u0010\u009a\u0003\u001a\u00030Ò\u0001H\u0002J\u0014\u0010\u009b\u0003\u001a\u00030Ò\u00012\b\u0010õ\u0002\u001a\u00030É\u0002H\u0002J\u000b\u0010\u009c\u0003\u001a\u0004\u0018\u00010CH\u0002J\n\u0010\u009d\u0003\u001a\u00030Ò\u0001H\u0002J\u0013\u0010\u009e\u0003\u001a\u00030Ò\u00012\u0007\u0010\u009f\u0003\u001a\u00020EH\u0016J\n\u0010 \u0003\u001a\u00030Ò\u0001H\u0016J\n\u0010¡\u0003\u001a\u00030Ò\u0001H\u0002J\n\u0010¢\u0003\u001a\u00030Ò\u0001H\u0002J\n\u0010£\u0003\u001a\u00030Ò\u0001H\u0002J\n\u0010¤\u0003\u001a\u00030Ò\u0001H\u0002J\n\u0010¥\u0003\u001a\u00030Ò\u0001H\u0002J\u001a\u0010¦\u0003\u001a\u00030Ò\u00012\u000e\u0010§\u0003\u001a\t\u0012\u0004\u0012\u00020A0ß\u0002H\u0002J\n\u0010¨\u0003\u001a\u00030Ò\u0001H\u0002J\u001a\u0010©\u0003\u001a\u00030Ò\u00012\u000e\u0010§\u0003\u001a\t\u0012\u0004\u0012\u00020A0ß\u0002H\u0002J0\u0010ª\u0003\u001a\u00030Ò\u00012\u000e\u0010«\u0003\u001a\t\u0012\u0004\u0012\u00020A0ß\u00022\t\b\u0002\u0010¬\u0003\u001a\u00020E2\t\b\u0002\u0010\u00ad\u0003\u001a\u00020EH\u0002J\n\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u000b\u0010®\u0003\u001a\u0004\u0018\u00010;H\u0002J\u000b\u0010¯\u0003\u001a\u0004\u0018\u00010CH\u0002J\n\u0010°\u0003\u001a\u00030å\u0001H\u0002J\u0011\u0010±\u0003\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0003\u0010²\u0003J\n\u0010³\u0003\u001a\u00030Ò\u0001H\u0002J\u0011\u0010´\u0003\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0003\u0010²\u0003J\u000f\u0010µ\u0003\u001a\u0004\u0018\u00010;*\u00020;H\u0002J\u001f\u0010¶\u0003\u001a\u0004\u0018\u00010A*\t\u0012\u0004\u0012\u00020A0ß\u00022\u0007\u0010·\u0003\u001a\u00020AH\u0002J\u001f\u0010¸\u0003\u001a\u0004\u0018\u00010A*\t\u0012\u0004\u0012\u00020A0ß\u00022\u0007\u0010·\u0003\u001a\u00020AH\u0002J\r\u0010¹\u0003\u001a\u00020E*\u00020;H\u0002J\u001f\u0010º\u0003\u001a\u0004\u0018\u00010A*\t\u0012\u0004\u0012\u00020A0ß\u00022\u0007\u0010·\u0003\u001a\u00020AH\u0002J\u0012\u0010»\u0003\u001a\u00020E2\u0007\u0010·\u0003\u001a\u00020AH\u0002J\r\u0010¼\u0003\u001a\u00020E*\u00020;H\u0002J\r\u0010½\u0003\u001a\u00020C*\u00020;H\u0002J\u0014\u0010¾\u0003\u001a\u00020C*\t\u0012\u0004\u0012\u00020A0ß\u0002H\u0002J\r\u0010¿\u0003\u001a\u00020C*\u00020AH\u0002J\t\u0010À\u0003\u001a\u00020CH\u0002J!\u0010Á\u0003\u001a\u00030Ò\u00012\u0015\u0010Â\u0003\u001a\u0010\u0012\u0004\u0012\u00020C\u0012\u0005\u0012\u00030Ä\u00030Ã\u0003H\u0002J\t\u0010Å\u0003\u001a\u00020EH\u0002J!\u0010Æ\u0003\u001a\u00030Ò\u00012\u0015\u0010Â\u0003\u001a\u0010\u0012\u0004\u0012\u00020C\u0012\u0005\u0012\u00030Ä\u00030Ã\u0003H\u0014J8\u0010Ç\u0003\u001a\u00030Ò\u00012\b\u0010È\u0003\u001a\u00030¯\u00012\t\b\u0002\u0010É\u0003\u001a\u00020E2\u0017\b\u0002\u0010Ê\u0003\u001a\u0010\u0012\u0004\u0012\u00020C\u0012\u0005\u0012\u00030Ä\u00030Ã\u0003H\u0002J-\u0010Ë\u0003\u001a\u00030Ò\u00012\b\u0010È\u0003\u001a\u00030¯\u00012\u0017\b\u0002\u0010Ê\u0003\u001a\u0010\u0012\u0004\u0012\u00020C\u0012\u0005\u0012\u00030Ä\u00030Ã\u0003H\u0002J\t\u0010Ì\u0003\u001a\u00020EH\u0002J\t\u0010Í\u0003\u001a\u00020EH\u0002J\t\u0010Î\u0003\u001a\u00020EH\u0002J\t\u0010Ï\u0003\u001a\u00020EH\u0014J\u0012\u0010Ð\u0003\u001a\u00020E2\u0007\u0010Ñ\u0003\u001a\u00020EH\u0002J\t\u0010Ò\u0003\u001a\u00020EH\u0002J\t\u0010Ï\u0002\u001a\u00020EH\u0002J\u0013\u0010Ó\u0003\u001a\u00030Ò\u00012\u0007\u0010ÿ\u0002\u001a\u00020EH\u0004J\n\u0010Ô\u0003\u001a\u00030Ò\u0001H\u0016J\n\u0010Õ\u0003\u001a\u00030Ò\u0001H\u0016J\u0010\u0010Ö\u0003\u001a\u00030Ò\u0001H\u0000¢\u0006\u0003\b×\u0003J\n\u0010Ø\u0003\u001a\u00030Ò\u0001H\u0002J\u0013\u0010Ù\u0003\u001a\u00030Ò\u00012\u0007\u0010Ú\u0003\u001a\u00020\u000bH\u0016J\u001c\u0010Ù\u0003\u001a\u00030Ò\u00012\u0007\u0010Ú\u0003\u001a\u00020\u000b2\u0007\u0010Û\u0003\u001a\u00020EH\u0002J\u0013\u0010Ü\u0003\u001a\u00030Ò\u00012\u0007\u0010Ú\u0003\u001a\u00020\u000bH\u0016J*\u0010Ý\u0003\u001a\u00030Ò\u00012\u0007\u0010Þ\u0003\u001a\u00020C2\u0015\u0010Ê\u0003\u001a\u0010\u0012\u0004\u0012\u00020C\u0012\u0005\u0012\u00030Ä\u00030Ã\u0003H\u0002J\t\u0010ß\u0003\u001a\u00020EH\u0002J,\u0010à\u0003\u001a\u00020E2\u0007\u0010Þ\u0003\u001a\u00020C2\n\u0010á\u0003\u001a\u0005\u0018\u00010â\u00032\f\b\u0002\u0010ã\u0003\u001a\u0005\u0018\u00010Þ\u0001H\u0002J\f\u0010ä\u0003\u001a\u0005\u0018\u00010å\u0003H\u0002J\n\u0010æ\u0003\u001a\u00030Ò\u0001H\u0002J\u0012\u0010ç\u0003\u001a\u00020E2\u0007\u0010Þ\u0003\u001a\u00020CH\u0002J\u0015\u0010è\u0003\u001a\u00030Ò\u00012\t\b\u0002\u0010é\u0003\u001a\u00020EH\u0002JW\u0010ê\u0003\u001a\u00030Ò\u00012\u0011\u0010ë\u0003\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010«\u00010è\u00012\u0007\u0010\u0095\u0003\u001a\u00020\u000b2\u000b\b\u0002\u0010ì\u0003\u001a\u0004\u0018\u00010\u000b2\u000b\b\u0002\u0010í\u0003\u001a\u0004\u0018\u00010\u000b2\u000f\u0010î\u0003\u001a\n\u0012\u0005\u0012\u00030Ò\u00010è\u0001H\u0002¢\u0006\u0003\u0010ï\u0003J\u0015\u0010ð\u0003\u001a\u00030Ò\u00012\t\b\u0002\u0010é\u0003\u001a\u00020EH\u0002J\u0014\u0010ñ\u0003\u001a\u00030Ò\u00012\b\u0010ò\u0003\u001a\u00030Þ\u0001H\u0002J!\u0010ó\u0003\u001a\u00030Ò\u00012\t\u0010ô\u0003\u001a\u0004\u0018\u00010C2\n\u0010õ\u0003\u001a\u0005\u0018\u00010É\u0002H\u0002J\u0017\u0010ö\u0003\u001a\u0005\u0018\u00010ñ\u00022\t\u0010ô\u0003\u001a\u0004\u0018\u00010CH\u0002J\u0013\u0010÷\u0003\u001a\u00030Ò\u00012\u0007\u0010÷\u0003\u001a\u00020CH\u0002J\u0013\u0010ø\u0003\u001a\u00030Ò\u00012\u0007\u0010ø\u0003\u001a\u00020CH\u0002J\u0013\u0010ù\u0003\u001a\u00030Ò\u00012\u0007\u0010ú\u0003\u001a\u00020\u000bH\u0002J\u0016\u0010û\u0003\u001a\u00030Ò\u00012\n\u0010ü\u0003\u001a\u0005\u0018\u00010ý\u0003H\u0002J\u0017\u0010þ\u0003\u001a\u0004\u0018\u00010C2\n\u0010ÿ\u0003\u001a\u0005\u0018\u00010\u0080\u0004H\u0002J\u001f\u0010\u0083\u0004\u001a\u00030Ò\u00012\u0013\u0010õ\u0002\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020E0=H\u0002J\u000b\u0010\u0084\u0004\u001a\u0004\u0018\u00010CH\u0016J\t\u0010\u0085\u0004\u001a\u00020EH\u0016J\t\u0010\u0086\u0004\u001a\u00020EH\u0016J\t\u0010\u0087\u0004\u001a\u00020EH\u0016J\t\u0010\u0088\u0004\u001a\u00020\u000bH\u0002J\u001d\u0010\u0089\u0004\u001a\u00030Ò\u00012\u000b\b\u0002\u0010\u008a\u0004\u001a\u0004\u0018\u00010>H\u0002¢\u0006\u0003\u0010\u008b\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b/\u00100R\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00102\u001a\u0004\b5\u00106R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010<\u001a\u0010\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010H\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010IR\u000e\u0010J\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010K\u001a\u0010\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020M\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u00020OX\u0082\u0004¢\u0006\u0004\n\u0002\u0010PR\u0010\u0010Q\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010WX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010X\u001a\u0012\u0012\u0004\u0012\u00020Z0Yj\b\u0012\u0004\u0012\u00020Z`[X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010]\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020)0^j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020)`_X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010`\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020C0^j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020C`_X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010c\u001a\u0004\u0018\u00010d8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\bg\u00102\u001a\u0004\be\u0010fR\u001d\u0010h\u001a\u0004\u0018\u00010i8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\bl\u00102\u001a\u0004\bj\u0010kR\u001d\u0010m\u001a\u0004\u0018\u00010n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bq\u00102\u001a\u0004\bo\u0010pR\u001d\u0010r\u001a\u0004\u0018\u00010s8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bv\u00102\u001a\u0004\bt\u0010uR\u001d\u0010w\u001a\u0004\u0018\u00010x8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b{\u00102\u001a\u0004\by\u0010zR\u001e\u0010|\u001a\u0004\u0018\u00010}8BX\u0082\u0084\u0002¢\u0006\r\n\u0005\b\u0080\u0001\u00102\u001a\u0004\b~\u0010\u007fR\"\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0085\u0001\u00102\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\"\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u00018DX\u0084\u0084\u0002¢\u0006\u000f\n\u0005\b\u008a\u0001\u00102\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\"\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008f\u0001\u00102\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\"\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0094\u0001\u00102\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\"\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0099\u0001\u00102\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R \u0010\u009a\u0001\u001a\u00030\u009b\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009e\u0001\u00102\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u000f\u0010 \u0001\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¡\u0001\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¢\u0001\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010¤\u0001\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¦\u0001\u001a\u00030§\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010¨\u0001\u001a\u000b\u0012\u0004\u0012\u00020C\u0018\u00010©\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010ª\u0001\u001a\f\u0012\u0005\u0012\u00030«\u0001\u0018\u00010©\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010¬\u0001\u001a\u000b\u0012\u0004\u0012\u00020C\u0018\u00010©\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u00ad\u0001\u001a\f\u0012\u0005\u0012\u00030«\u0001\u0018\u00010©\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010®\u0001\u001a\u0005\u0018\u00010¯\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010²\u0001\u001a\u00030³\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¶\u0001\u00102\u001a\u0006\b´\u0001\u0010µ\u0001R\"\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R\u001f\u0010½\u0001\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¿\u0001\u00102\u001a\u0006\b½\u0001\u0010¾\u0001R\u001f\u0010À\u0001\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÂ\u0001\u00102\u001a\u0006\bÁ\u0001\u0010¾\u0001R\u0016\u0010Ã\u0001\u001a\t\u0012\u0004\u0012\u00020E0Ä\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010Å\u0001\u001a\t\u0012\u0004\u0012\u00020E0Æ\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bÇ\u0001\u0010È\u0001R\u000f\u0010É\u0001\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ê\u0001\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ë\u0001\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ì\u0001\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Í\u0001\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010Î\u0001\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0005\n\u0003\u0010Ï\u0001R!\u0010\u009f\u0002\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010 \u00020Æ\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¡\u0002\u0010È\u0001R\u001f\u0010¢\u0002\u001a\n\u0012\u0005\u0012\u00030¤\u00020£\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b¥\u0002\u0010¦\u0002R\u001f\u0010¬\u0002\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b®\u0002\u00102\u001a\u0006\b\u00ad\u0002\u0010¾\u0001R \u0010¹\u0002\u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b»\u0002\u00102\u001a\u0005\bº\u0002\u0010#R<\u0010è\u0002\u001a\u000b\u0012\u0004\u0012\u00020E\u0018\u00010è\u00012\u0010\u0010ç\u0002\u001a\u000b\u0012\u0004\u0012\u00020E\u0018\u00010è\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bé\u0002\u0010ê\u0002\"\u0006\bë\u0002\u0010ì\u0002R\u0016\u0010\u0081\u0004\u001a\t\u0012\u0004\u0012\u00020!0\u0082\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u008d\u0004"}, d2 = {"Lcom/larus/uaigc/createpage/component/instruction/CreationEditorComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "<init>", "()V", "llWidgetContainer", "Landroid/widget/LinearLayout;", "getLlWidgetContainer", "()Landroid/widget/LinearLayout;", "creationUploadPicNumber", "", "getCreationUploadPicNumber", "()I", "inputEditorContainerViewStub", "Landroid/view/ViewStub;", "inputEditorContainer", "Landroid/view/ViewGroup;", "getInputEditorContainer", "()Landroid/view/ViewGroup;", "editorTitle", "Landroid/widget/TextView;", "getEditorTitle", "()Landroid/widget/TextView;", "componentScrollContainer", "Landroid/widget/ScrollView;", "getComponentScrollContainer", "()Landroid/widget/ScrollView;", "editorTitleArrow", "Landroid/widget/ImageView;", "getEditorTitleArrow", "()Landroid/widget/ImageView;", "editorTitleContentContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getEditorTitleContentContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "editorIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getEditorIcon", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "editorCloseBtn", "Landroid/view/View;", "getEditorCloseBtn", "()Landroid/view/View;", "instructionTitleView", "instructionEditorViewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "getInstructionEditorViewModel", "()Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "instructionEditorViewModel$delegate", "Lkotlin/Lazy;", "actionBarRedDotCacheHelper", "Lcom/larus/bmhome/view/actionbar/custom/cache/IActionBarRedDotCacheHelper;", "getActionBarRedDotCacheHelper", "()Lcom/larus/bmhome/view/actionbar/custom/cache/IActionBarRedDotCacheHelper;", "actionBarRedDotCacheHelper$delegate", "virtualInstructionEditorFactory", "Lcom/larus/uaigc/factory/IVirtualInstructionEditorFactory;", "instructionConf", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionConf;", "lastLoggedCreationReferenceCapability", "Lkotlin/Pair;", "", "Lcom/larus/bmhome/actionbar/model/CreationReferenceCapabilityState;", "currentActionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "currentActionBarConfigSignature", "", "hasPendingInstructionRefreshState", "", "pendingInstructionDefaultStateConf", "pendingInstructionDefaultParams", "pendingSelectInstructionType", "Ljava/lang/Integer;", "hasRegisteredActionBarChangeListener", "dynamicActionBarAdapter", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/view/actionbar/BaseActionBarHolder;", "actionBarChangeListener", "com/larus/uaigc/createpage/component/instruction/CreationEditorComponent$actionBarChangeListener$1", "Lcom/larus/uaigc/createpage/component/instruction/CreationEditorComponent$actionBarChangeListener$1;", "editorContainer", "actionBarContainer", "actionBarList", "Landroidx/recyclerview/widget/RecyclerView;", "inputAreaAboveDivider", "instructionBizAdapterFactory", "Lcom/larus/bmhome/instruction/biz/IInstructionBizAdapterFactory;", "tabList", "Ljava/util/ArrayList;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "Lkotlin/collections/ArrayList;", "tabSelectionListenerRegistered", "multiTabViewMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "multiTabNameMap", "tabMemoryKeva", "Lcom/bytedance/keva/Keva;", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "multiAttachmentSelectorAbility", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMultiAttachmentSelectorAbility;", "getMultiAttachmentSelectorAbility", "()Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMultiAttachmentSelectorAbility;", "multiAttachmentSelectorAbility$delegate", "creationInputAbility", "Lcom/larus/uaigc/bean/createpage/component/input/CreationIInputAbility;", "getCreationInputAbility", "()Lcom/larus/uaigc/bean/createpage/component/input/CreationIInputAbility;", "creationInputAbility$delegate", "mediaSelectorContainerAbility", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMediaSelectorContainerAbility;", "getMediaSelectorContainerAbility", "()Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMediaSelectorContainerAbility;", "mediaSelectorContainerAbility$delegate", "imageSelectorAbility", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/imageselector/IImageSelectorAbility;", "getImageSelectorAbility", "()Lcom/larus/uaigc/bean/createpage/component/mediacontainer/imageselector/IImageSelectorAbility;", "imageSelectorAbility$delegate", "templateFeedAbility", "Lcom/larus/uaigc/bean/createpage/component/templatefeed/ITemplateFeedAbility;", "getTemplateFeedAbility", "()Lcom/larus/uaigc/bean/createpage/component/templatefeed/ITemplateFeedAbility;", "templateFeedAbility$delegate", "argumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "argumentData$delegate", "hitPointData", "Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "getHitPointData", "()Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "hitPointData$delegate", "imgInspirationAbility", "Lcom/larus/uaigc/bean/createpage/component/inspiration/IImgInspirationListAbility;", "getImgInspirationAbility", "()Lcom/larus/uaigc/bean/createpage/component/inspiration/IImgInspirationListAbility;", "imgInspirationAbility$delegate", "digitalAvatarAbility", "Lcom/larus/uaigc/bean/createpage/component/digitalavatar/IDigitalAvatarAbility;", "getDigitalAvatarAbility", "()Lcom/larus/uaigc/bean/createpage/component/digitalavatar/IDigitalAvatarAbility;", "digitalAvatarAbility$delegate", "instructionEditorInputDepend", "com/larus/uaigc/createpage/component/instruction/CreationEditorComponent$instructionEditorInputDepend$2$1", "getInstructionEditorInputDepend", "()Lcom/larus/uaigc/createpage/component/instruction/CreationEditorComponent$instructionEditorInputDepend$2$1;", "instructionEditorInputDepend$delegate", "hasHorizontalScrollAncestor", "disableResetMsgInstruction", "disableResetImgInspirePrompt", "selectedTemplateString", "isInstructionHidden", "sendScene", "getSendScene", "displayFrame", "Landroid/graphics/Rect;", "pickLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "pickSDKLauncher", "Landroid/content/Intent;", "pickLauncherForSchema", "pickSDKLauncherForSchema", "chosenMsgInstructionForLaterSendMsg", "Lcom/larus/bmhome/actionbar/model/MsgInstructionItem;", "pendingFeatureDialogDismissShowImeRunnable", "Ljava/lang/Runnable;", "actionBarShowTipCache", "Lcom/larus/bmhome/view/actionbar/custom/IActionBarShowTipCache;", "getActionBarShowTipCache", "()Lcom/larus/bmhome/view/actionbar/custom/IActionBarShowTipCache;", "actionBarShowTipCache$delegate", "mMultiTabViewCollector", "Lcom/larus/bmhome/instrution/MultiTabViewCollector;", "getMMultiTabViewCollector", "()Lcom/larus/bmhome/instrution/MultiTabViewCollector;", "setMMultiTabViewCollector", "(Lcom/larus/bmhome/instrution/MultiTabViewCollector;)V", "isDarkMode", "()Z", "isDarkMode$delegate", "enableAvatarCombineCreation", "getEnableAvatarCombineCreation", "enableAvatarCombineCreation$delegate", "_editorContainerVisibleFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "editorContainerVisibleFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getEditorContainerVisibleFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "hasShownReplicaComponent", "hasReplicaClick", "hasReplicaCancel", "isApplyingProgrammaticTabSelection", "isRestoringDoSameVideoModel", "disposableAvatarCreatedFormat", "Ljava/lang/Boolean;", "initInputEditorContainerView", "onAttach", "", "onCreate", "initInstructionBizAdapter", "resetImageStyleList", "onDigitalAvatarTemplateChoose", "templateInfo", "Lcom/larus/bmhome/avatar/api/DigitalAvatarTemplate;", "position", "enterFrom", "onVideoTemplateChoose", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "localImagePath", "Landroid/net/Uri;", "onActionBarInstructionChanged", "actionBarItem", "instructionDefaultStateConf", "openFrom", "autoSendPrompt", "instructionExtraData", "Lcom/larus/bmhome/instruction/core/model/InstructionExtraData;", "selectInstructionType", "onInstructionCallback", "Lkotlin/Function0;", "(Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Lcom/larus/bmhome/actionbar/model/ActionBarInstructionConf;ILjava/lang/String;Lcom/larus/bmhome/instruction/core/model/InstructionExtraData;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "onMusicTemplateSelected", "template", "Lcom/larus/bmhome/instruction/core/model/music/MusicGenTemplate;", "getInputMaxHeight", "measureInstructionScrollHeight", "currentInstructionType", "updateInputMaxHeight", "closeInstructionEditor", "createInstructionEditorViewFactory", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewFactory;", "buildNormalInstructionEditor", "getInnerInstructionTitle", "openInstructionEditor", "item", "buildMultiTabInstructionEditor", "checkTabWithAvatarMode", "index", "restoreAvatarImageIfNeed", "fillAttachmentAreaInstruction", "menuConf", "Lcom/larus/bmhome/actionbar/model/ActionBarMenuConf;", "multiTabViewCollector", "resolveDefaultAttachmentMaxCount", "(Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;)Ljava/lang/Integer;", "currentSelectedVideoModelExtInfo", "Lcom/larus/bmhome/actionbar/model/VideoModelExtInfo;", "currentCreationReferenceCapabilityState", "usesCreationReferenceCompatibilityValidation", "shouldRejectVideoModelSelection", "targetOptionId", "showFeedback", "shouldRejectTabSwitch", "previousIndex", "targetIndex", "shouldRejectImageTabSwitch", "targetActionBarItem", "logReferenceSwitchChecks", "scene", "source", "modelKey", "snapshot", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachmentSnapshot;", "violation", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachmentViolation;", "violationReason", "toCreationMultiReferenceLogSummary", "Lcom/larus/platform/creation/CreationMultiReferenceLogSummary;", "rejectReferenceSwitchIfNeeded", "serverDisplayText", "canSelectAvatarReference", "isCreationVideoReferenceScene", "isVideoModelV2Selected", "isI2vCanChooseRatio", "selectVideoModelFlow", "Lcom/larus/bmhome/view/actionbar/edit/SelectedModelInfo;", "getSelectVideoModelFlow", "selectDurationFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/larus/bmhome/view/actionbar/edit/SelectedDurationInfo;", "getSelectDurationFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "replaceEditorInstruction", "needSetHint", "isMultiTabInstructionType", "instructionConfType", "(Ljava/lang/Integer;)Z", "delayInflateEditorPanel", "getDelayInflateEditorPanel", "delayInflateEditorPanel$delegate", "resetInstructionEditorFactoryAndSetHint", "setTransientInputHint", "hint", "", "onViewCreatedLogic", "onViewCreated", "view", "buildFinalActionbarInstructionConf", "setUpDynamicActionBar", "setUpConstantActionBar", "refImageAddItemView", "getRefImageAddItemView", "refImageAddItemView$delegate", "createActionBarClickCallback", "Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "onRedDotMiss", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bindingAdapterPosition", "getDefaultHint", "getCurrentSelectTabIndex", "isInVideoTab", "handleInstructionForm", "targetInstruction", "bizArgs", "Landroid/os/Bundle;", "interceptAvatarInstructionFrom", "getEnterIndependentPageClickFrom", "updateRefImageAddItemVisibility", "visible", "updateInstructionPanelVisibility", "isImageVideoMixSkill", "tryReportReplicaShow", "isInstructionOpen", "checkInstructionValid", "resetMsgInstruction", "resetImgInspiration", "clearInputComponentFocus", "getAiGenTypeMobValue", "isLyricsAiGen", "lyricsTab", "setInputTextOnClickSend", "text", "isUploadingReferenceImage", "imageGenReadyToSend", "isActionBarTypeGenImage", "getCurImageList", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "getDefaultSelectedImageStyleId", "()Ljava/lang/Long;", "refreshImageListSelectorWithMore", "imageList", "setRatioDropDownSelectorClickInterceptor", "interceptor", "value", "videoModelDropDownSelectorClickInterceptor", "getVideoModelDropDownSelectorClickInterceptor", "()Lkotlin/jvm/functions/Function0;", "setVideoModelDropDownSelectorClickInterceptor", "(Lkotlin/jvm/functions/Function0;)V", "getRatioOptionList", "initInstructionEditor", "isCustom", "getReferenceImageInfo", "Lcom/larus/bmhome/view/AttachmentInfo;", "isHalfInstructionFragment", "setCreationPageResult", "resultCode", "data", "checkMusicInstructionInputNotLegal", "input", "buildSendMessageContent", "userInput", "replaceUserInput", "getCurrentInstructionConf", "userInputContent", "isInstructionInputSendReady", "setOriginalRatioEnable", "enable", "setEnableResetTemplateCacheAfterDetach", "getCurrentNestedFileContent", "Lcom/larus/im/bean/message/NestedFileContent;", "getCurrentNestedFileLocalMessageId", "forceGetCurrentNestedFileContent", "getCurrentAvatarSubscriptIndex", "getCurrentMenuHint", "enableTransparentInputBackground", "getActionBarInstructionParam", "forceMediaData", "selectRatio", "id", "parentInstructionType", "selectModel", "selectDoSameModel", "resolveDoSameVideoModelId", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/DoSameVideoModelResolution;", "requestedId", "getSelectedTemplateString", "clearSelectedTemplateString", "handleActivityResult", "requestCode", "openDoSameResultChat", "handleReGenDigitalAvatarResult", "handleUploadDigitalAvatarResult", "handleDeleteDigitalAvatarResult", "initLaunchers", "handleImageRemoveResult", "instructionHint", "initPassedTemplateInfo", "tryReportReplicaButtonClick", "isActiveClick", "tryReportReplicaButtonCancel", "bindObservers", "observerInstructionEditor", "registerActionBarConfigRefreshListener", "unregisterActionBarConfigRefreshListener", "refreshActionBarConfigFromRemote", "refreshCurrentCreationInstructionIfNeeded", "actionBarConfList", "rebuildInstructionEditorForActionBarRefresh", "refreshDynamicActionBarItemsIfNeeded", "submitDynamicActionBarList", "itemList", "scrollToStart", "forceRebind", "resolveInstructionDefaultStateConf", "resolveInstructionDefaultParams", "buildInstructionExtraDataForRefresh", "resolveSelectInstructionType", "()Ljava/lang/Integer;", "clearPendingInstructionRefreshState", "currentSelectedInstructionType", "buildRefreshDefaultStateConf", "findLatestItemForCurrentInstruction", "currentItem", "findLatestDynamicActionBarItem", "hasAvailableInstructionPayload", "resolveLatestItemForRefresh", "isCurrentMixInstruction", "isAvailableMixPayload", "actionBarConfigSignature", "dynamicActionBarConfigSignature", "actionBarItemConfigSignature", "getTabType", "updateCoreInputByAttachmentsStatus", "statusMap", "", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/MultiMediaSelectorStatus;", "isEnableEditVideo", "updateSendStatus", "handleSendMessage", "instructionItem", "enableSend", "multiMediaMap", "handleSystemAlbumFlow", "handlePrivateImage", "showAttachmentFailureToast", "handlePrivateMultiAttachment", "shouldUseCreationSendMessageFlow", "shouldBlockMultiAttachmentPreprocessing", "isParsingAttachment", "canHandoffMultiAttachmentPreprocessing", "enableInputArea", "onDestroy", "onFragmentViewDestroyed", "cancelPendingFeatureDialogDismissShowIme", "cancelPendingFeatureDialogDismissShowIme$impl_mainlandRelease", "postFeatureDialogDismissShowIme", "selectCurrentTabOfSubInstructionType", "instructionType", "validateReferenceCompatibility", "selectDoSameTabOfSubInstructionType", "handleMsgInstructionRedirectSchema", "schema", "shouldEnableCompactFragmentForseti", "tryOpenImageRemoveInHost", "mediaAttachment", "Lcom/larus/bmhome/actionbar/model/MediaAttachment;", "inputImageUri", "buildImageRemoveCreationSendConfig", "Lcom/larus/uaigc/bean/createpage/CreationSendMessageConfig;", "registerImageRemoveAppletResultListener", "isImageRemoveSchema", "openSystemAlbumAndReport", "fromSchema", "openRouteForResultInHalfPage", "buildIntent", "enterAnim", "exitAnim", "fallback", "(Lkotlin/jvm/functions/Function0;ILjava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "openSystemAlbum", "onAlbumSelected", "uri", "finishAndSendMessages", "localPath", "bundle", "buildLocalAttachmentInfo", "onFeatureOptionSelected", "onFeatureOptionUnSelected", "switchInputStatus", "status", "onImageTemplateSelected", "instructionPhotoTemplateWrapper", "Lcom/larus/bmhome/view/actionbar/edit/InstructionPhotoTemplateWrapper;", "getRefImageUrl", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "hasShownEditorComponent", "", "handleComponentVisibilityChange", "getCurrentPageName", "isAvatarCreationImageMode", "isAvatarCreationVideoMode", "isVideoCreationMode", "findVideoGenMenuPosition", "jumpToCreateOrCompleteAvatar", "targetInstructionItemId", "(Ljava/lang/Long;)V", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public class CreationEditorComponent extends BaseContentWidget implements ys8.a {
    public static final /* synthetic */ int g2 = 0;
    public ListAdapter<com.larus.bmhome.actionbar.model.z0, BaseActionBarHolder> A;
    public final c B;
    public LinearLayout C;
    public ConstraintLayout D;
    public RecyclerView E;
    public View F;
    public vp8.i G;
    public final kotlinx.coroutines.flow.b1 G1;
    public final ArrayList<TabLayout.Tab> H;
    public final Rect H0;
    public boolean H1;
    public boolean I;
    public final HashMap<Integer, View> J;
    public final HashMap<Integer, String> K;
    public final Keva L;
    public ActivityResultLauncher<String> L0;
    public boolean L1;
    public final Lazy M;
    public boolean M1;
    public final Lazy N;
    public final Lazy O;
    public final Lazy P;
    public ActivityResultLauncher<Intent> P0;
    public boolean P1;
    public final Lazy Q;
    public boolean Q1;
    public final Lazy R;
    public final Lazy S;
    public Boolean S1;
    public final Lazy T;
    public final Lazy T1;
    public final Lazy U;
    public final Lazy V;
    public ActivityResultLauncher<String> V0;
    public final Lazy V1;
    public final Lazy W;
    public final Lazy X;
    public boolean Y;
    public boolean Z;
    public ActivityResultLauncher<Intent> b1;
    public final Set<ConstraintLayout> b2;
    public com.larus.bmhome.actionbar.model.p1 g1;
    public p h1;
    public String k0;
    public final Lazy k1;
    public ViewStub m;
    public ViewGroup n;
    public View o;
    public final Lazy p;
    public String p0;
    public hq8.a p1;
    public final Lazy q;
    public uz9.a r;
    public com.larus.bmhome.actionbar.model.r s;
    public Pair<Long, ? extends com.larus.bmhome.actionbar.model.w0> t;
    public com.larus.bmhome.actionbar.model.z0 u;
    public String v;
    public final Lazy v1;
    public boolean w;
    public com.larus.bmhome.actionbar.model.r x;
    public final Lazy x1;
    public Integer y;
    public final StateFlowImpl y1;
    public boolean z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ResourceType.values().length];
            r0[ResourceType.VIDEO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ResourceType.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ResourceType.AVATAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c implements com.larus.bmhome.chat.a {
        public final /* synthetic */ CreationEditorComponent a;

        public final void a() {
            final CreationEditorComponent r0 = this.a;
            int r1 = CreationEditorComponent.g2;
            ny9.s r2 = r0.W3();
            if (r2 == null) goto L8;
            ChatParam r3 = r2.c();
            if (r3 == null) goto L8;
            String r4 = r3.b;
            if (r4 == null) goto L8;
        L14:
            IActionBarService r5 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
            if (r5 == null) goto L18;
            r5.d(LifecycleOwnerKt.getLifecycleScope(r0), r4, new p0(r0));
            return;
        L18:
            return;
        L8:
            com.larus.bmhome.chat.api.e0 r6 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
            if (r6 == null) goto L13;
            LaunchInfo r7 = r6.a;
            if (r7 == null) goto L13;
            r4 = r7.W();
        L13:
            r4 = null;
            goto L14
        }

        public c(CreationEditorComponent r1) {
            this.a = r1;
        }
    }

    public static final class d implements TabLayout.OnTabSelectedListener {
        public final /* synthetic */ CreationEditorComponent a;
        public final /* synthetic */ hq8.a b;

        public final void onTabReselected(TabLayout.Tab r1) {
        }

        public final void onTabUnselected(TabLayout.Tab r1) {
        }

        public final void onTabSelected(TabLayout.Tab r14) {
            String r0 = null;
            if (r14 == null) goto L5;
            Object r15 = r14.getTag();
        L6:
            int r16 = l3.e(r15, -1);
            if (r16 < 0) goto L90;
            CreationEditorComponent r1 = this.a;
            int r2 = CreationEditorComponent.g2;
            int r3 = ((Number) r1.i4().getInstructionSelectMenuPosition().getValue()).intValue();
            if (this.a.U5(r3, r16) == false) goto L14;
            TabLayout.Tab r17 = (TabLayout.Tab) CollectionsKt.getOrNull(this.a.H, r3);
            if (r17 == null) goto L89;
            r17.select();
            return;
        L89:
            return;
        L14:
            this.a.L.storeInt("creation_tab_key_tab_index", r16);
            this.a.i4().selectInstructionMenu(r16);
            uz9.a r4 = this.a.r;
            if (r4 == null) goto L17;
            r4.q(r16);
        L17:
            this.a.w5(r16, this.b, true);
            if ((this.a.yn() instanceof com.larus.bmhome.actionbar.model.w0.a) == true) goto L22;
            ry9.h r5 = this.a.l4();
            if (r5 == null) goto L22;
            r5.Nn();
        L22:
            ry9.h r6 = this.a.l4();
            if (r6 == null) goto L26;
            r6.vB();
        L26:
            if (this.a.dk(r16) == true) goto L35;
            ry9.h r7 = this.a.l4();
            if (r7 == null) goto L56;
            ry9.h r8 = this.a.l4();
            if (r8 == null) goto L33;
            String r9 = r8.yC();
            if (r9 == null) goto L33;
        L34:
            r7.lu(r9);
        L33:
            r9 = "";
        L56:
            uz9.a r10 = this.a.r;
            if (r10 == null) goto L62;
            Map r11 = (Map) r10.o().getValue();
            if (r11 == null) goto L62;
            CreationEditorComponent.m3(this.a, r11);
        L62:
            if (r16 != 0) goto L64;
            String r12 = "video";
            String r13 = "pic";
        L65:
            hy9.d r18 = ICreationReportService.a.j();
            String r19 = this.a.k();
            ny9.u r110 = this.a.d4();
            if (r110 == null) goto L68;
            String r20 = r110.getEnterMethod();
        L69:
            ny9.s r111 = this.a.W3();
            if (r111 == null) goto L75;
            ChatParam r112 = r111.c();
            if (r112 == null) goto L75;
            String r113 = r112.b;
            if (r113 == null) goto L75;
        L78:
            String r21 = r113;
        L80:
            ny9.u r114 = this.a.d4();
            if (r114 == null) goto L83;
            String r22 = r114.m();
        L84:
            ny9.u r115 = this.a.d4();
            if (r115 == null) goto L87;
            r0 = r115.i();
        L87:
            r18.a(r12, r13, r20, r21, r22, r0, null, null, r19);
            return;
        L83:
            r22 = null;
        L75:
            ny9.u r116 = this.a.d4();
            if (r116 == null) goto L79;
            r113 = r116.getBotId();
            goto L78
        L79:
            r21 = null;
            goto L80
        L68:
            r20 = null;
            goto L69
        L64:
            r13 = "video";
            r12 = "pic";
            goto L65
        L35:
            CreationEditorComponent r23 = this.a;
            if (((Boolean) r23.i4().getChosenAvatarInstructionStatus().getValue()).booleanValue() == false) goto L56;
            ry9.h r24 = r23.l4();
            if (r24 == null) goto L40;
            String r25 = r24.yC();
        L41:
            if (r25 != null) goto L56;
            DigitalAvatarInfoManager.a.getClass();
            if (DigitalAvatarInfoManager.h() == false) goto L50;
            String r26 = (String) DigitalAvatarInfoManager.b.getValue();
            if (r26 == null) goto L50;
            ry9.h r27 = r23.l4();
            if (r27 == null) goto L50;
            r27.JZ(r26);
        L50:
            if (DigitalAvatarInfoManager.i() == false) goto L56;
            String r28 = DigitalAvatarInfoManager.e();
            if (r28 == null) goto L56;
            ry9.h r29 = r23.l4();
            if (r29 == null) goto L56;
            r29.JZ(r28);
            goto L56
        L40:
            r25 = null;
            goto L41
        L90:
            return;
        L5:
            r15 = null;
            goto L6
        }

        public d(CreationEditorComponent r1, hq8.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e implements com.larus.bmhome.view.actionbar.edit.n, com.larus.bmhome.view.actionbar.edit.a {
        public final /* synthetic */ CreationEditorComponent a;

        public final String b() {
            va8.o r0 = this.a.X3();
            if (r0 == null) goto L5;
            String r1 = r0.u7();
        L6:
            if (r1 != null) goto L9;
            return "";
        L9:
            return r1;
        L5:
            r1 = null;
            goto L6
        }

        public e(CreationEditorComponent r1) {
            this.a = r1;
        }

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "clickCommand");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [android.widget.LinearLayout] */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v8, types: [android.view.ViewGroup] */
        /* JADX WARN: Type inference failed for: r6v2, types: [android.view.View] */
        public final View c(ConstraintLayout r6) {
            Intrinsics.checkNotNullParameter(r6, "defaultAnchorView");
            hq8.a r0 = this.a.p1;
            boolean r1 = false;
            ConstraintLayout r2 = null;
            if (r0 == null) goto L17;
            FrameLayout r3 = r0.f;
            if (r3 == null) goto L17;
            if (r3.isAttachedToWindow() == true) goto L9;
        L11:
            boolean r4 = false;
        L12:
            if (r4 == true) goto L15;
            r3 = null;
        L15:
            if (r3 == null) goto L17;
            return r3;
        L9:
            if (r3.getWidth() <= 0) goto L11;
            r4 = true;
        L17:
            ny9.s r5 = this.a.W3();
            if (r5 != null) goto L20;
        L22:
            boolean r7 = false;
        L23:
            if (r7 == true) goto L34;
            this.a.getClass();
            Object r8 = r6.getParent();
        L26:
            if ((r8 instanceof View) == false) goto L31;
            if ((r8 instanceof HorizontalScrollView) == true) goto L29;
            r8 = ((View) r8).getParent();
            goto L26
        L29:
            boolean r9 = true;
        L32:
            if (r9 == true) goto L34;
            return null;
        L31:
            r9 = false;
        L34:
            ?? r10 = this.a.h4();
            if (r10 != 0) goto L37;
        L47:
            r10 = this.a.C;
            if (r10 != 0) goto L50;
        L57:
            r10 = 0;
        L58:
            if (r10 != 0) goto L74;
            ConstraintLayout r11 = this.a.D;
            if (r11 != null) goto L63;
        L69:
            if (r2 != null) goto L71;
            return r6;
        L71:
            return r2;
        L63:
            if (r11.isAttachedToWindow() == true) goto L65;
        L67:
            if (r1 == false) goto L69;
            r2 = r11;
            goto L69
        L65:
            if (r11.getWidth() <= 0) goto L67;
            r1 = true;
        L74:
            return r10;
        L50:
            if (r10.isAttachedToWindow() == true) goto L52;
        L54:
            boolean r12 = false;
        L55:
            if (r12 == false) goto L57;
        L52:
            if (r10.getWidth() <= 0) goto L54;
            r12 = true;
            goto L55
        L37:
            if (r10.isAttachedToWindow() == true) goto L39;
        L41:
            boolean r13 = false;
        L42:
            if (r13 == true) goto L45;
            r10 = 0;
        L45:
            if (r10 == 0) goto L47;
        L39:
            if (r10.getWidth() <= 0) goto L41;
            r13 = true;
            goto L42
        L20:
            if (r5.a() != true) goto L22;
            r7 = true;
            goto L23
        }
    }

    public static final class f implements View.OnLayoutChangeListener {
        public final /* synthetic */ CreationEditorComponent a;

        public f(CreationEditorComponent r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            CreationEditorComponent r10 = this.a;
            int r11 = CreationEditorComponent.g2;
            LinearLayout r12 = r10.j4();
            if (r12 == null) goto L5;
            int r13 = r12.getMeasuredHeight();
        L6:
            ScrollView r14 = this.a.Z3();
            if (r14 == null) goto L10;
            r14.scrollBy(0, r13);
            return;
        L10:
            return;
        L5:
            r13 = 0;
            goto L6
        }
    }

    public static final class g implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public g(x1 r2) {
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

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$onViewCreated$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$onViewCreated$2", f = "CreationEditorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CreationEditorComponent this$0;

        public AnonymousClass2(CreationEditorComponent r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            CreationEditorComponent r3 = this.this$0;
            int r0 = CreationEditorComponent.g2;
            r3.i5();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public void r6(Map<String, ry9.k> r2) {
        Intrinsics.checkNotNullParameter(r2, "statusMap");
    }

    public final boolean z0() {
        return true;
    }

    public final void A1() {
        FLogger.a.i("CreationEditorComponent", "closeInstructionEditor");
        C3();
        ICoreInputAbility r0 = a4();
        if (r0 == null) goto L5;
        r0.qp(false);
    L5:
        py9.a r1 = c4();
        if (r1 == null) goto L9;
        r1.Gj();
        return;
    }

    public final void A2() {
        if (this.z == false) goto L7;
        this.z = false;
        CopyOnWriteArraySet r0 = InstructionInputManager.a;
        c r1 = this.B;
        Intrinsics.checkNotNullParameter(r1, "actionbarChangeListener");
        InstructionInputManager.a.remove(r1);
        return;
    }

    public final void B3() {
        com.larus.bmhome.actionbar.model.z0 r2 = E3();
        if (r2 != null) goto L5;
        return;
    L5:
        com.larus.bmhome.actionbar.model.r r1 = this.s;
        if (r1 == null) goto L155;
        com.larus.bmhome.actionbar.model.y r10 = r1.i;
        if (r10 == null) goto L157;
        com.larus.bmhome.view.actionbar.edit.c r3 = i4();
        r3.setCurrentInstructionConfig(r1);
        ny9.s r4 = W3();
        if (r4 == null) goto L13;
        String r5 = r4.w();
    L15:
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        String r6 = String.valueOf(r1.a);
        String r7 = r1.g;
        if (r7 != null) goto L20;
        r7 = "";
    L20:
        r3.setActionBarName(r5, r6, r7);
        ny9.s r8 = W3();
        if (r8 == null) goto L25;
        ChatParam r9 = r8.c();
        if (r9 == null) goto L25;
        r3.bindChatParam(r9);
    L25:
        com.larus.bmhome.actionbar.model.r r13 = E5();
        com.larus.bmhome.view.actionbar.edit.c r11 = i4();
        aq8.e r12 = z3();
        if (this.w == false) goto L28;
        Integer r14 = this.y;
    L31:
        Integer r15 = r14;
    L33:
        com.larus.bmhome.view.actionbar.edit.c.a.a(r11, r2, r13, 5, null, r12, r15, null, 72);
        LinearLayout r16 = this.C;
        if (r16 == null) goto L156;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$buildMultiTabInstructionEditor$2$1(this, null), 3, null);
        if (R4() == false) goto L39;
        LinearLayout r17 = j4();
        if (r17 == null) goto L39;
    L40:
        int r18 = r17.getPaddingStart();
        int r19 = r17.getPaddingEnd();
        int r20 = r17.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + r17.getClass().getSimpleName() + ",source:,start:" + r18 + ",top:0,end:" + r19 + ",bottom:" + r20);
        r17.setPaddingRelative(r18, 0, r19, r20);
        this.I = false;
        this.H.clear();
        hq8.a r21 = IInstructionService.a.c(getContext());
        this.p1 = r21;
        IFlowSdkDepend r22 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r22 == null) goto L47;
        r22.H();
        VideoPortraitConfig r23 = com.larus.home.impl.sdk.l1.a.a();
        if (r23 == null) goto L47;
        if (r23.getEnableEditVideo() != true) goto L47;
        boolean r24 = true;
    L48:
        boolean r25 = yn() instanceof com.larus.bmhome.actionbar.model.w0.a;
        if (r24 == true) goto L52;
        if (r25 == true) goto L52;
        Q3(r10, r21);
    L52:
        uz9.a r26 = this.r;
        if (r26 == null) goto L55;
        r26.a.clear();
        r26.b = null;
    L55:
        r16.removeAllViews();
        ArrayList r27 = r10.a;
        if (r27 == null) goto L73;
        Iterator r28 = r27.iterator();
        int r29 = 0;
    L59:
        if (r28.hasNext() == false) goto L73;
        Object r110 = r28.next();
        int r111 = r29 + 1;
        if (r29 >= 0) goto L63;
        CollectionsKt.throwIndexOverflow();
    L63:
        com.larus.bmhome.actionbar.model.z0 r112 = (com.larus.bmhome.actionbar.model.z0) r110;
        TabLayout.Tab r113 = r21.b.newTab();
        r113.setText(r112.e);
        HashMap<Integer, String> r30 = this.K;
        Integer r31 = Integer.valueOf(r29);
        String r32 = r112.e;
        if (r32 != null) goto L66;
        r32 = "";
    L66:
        r30.put(r31, r32);
        r113.setTag(Integer.valueOf(r29));
        this.H.add(r113);
        r21.b.addTab(r113);
        r21.b.setElevation(1.0f);
        com.larus.bmhome.view.actionbar.edit.b r33 = D3();
        uz9.a r34 = this.r;
        if (r34 == null) goto L69;
        Intrinsics.checkNotNullParameter(r33, "factory");
        r34.a.add(r33);
    L69:
        LinearLayout r35 = new LinearLayout(getContext());
        r35.setOrientation(1);
        r35.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        com.larus.bmhome.actionbar.model.r r36 = r112.q;
        if (r36 == null) goto L72;
        com.larus.bmhome.view.actionbar.edit.b.a.a(r33, r36, r35, i4(), null, null, (e) this.X.getValue(), new com.larus.bmhome.view.actionbar.edit.d(i4().getInstructionDefaultParams()), null, true, null, 640);
        r33.onViewShow();
        i4().updateInputBoxPlaceHolder(r29, r36.c);
    L72:
        this.J.put(Integer.valueOf(r29), r35);
        r29 = r111;
    L73:
        if (r13 == null) goto L108;
        com.larus.bmhome.actionbar.model.y r37 = r13.i;
        if (r37 == null) goto L108;
        ArrayList r38 = r37.a;
        if (r38 == null) goto L108;
        com.larus.bmhome.actionbar.model.z0 r39 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.firstOrNull(r38);
        if (r39 == null) goto L108;
        com.larus.bmhome.actionbar.model.r r40 = r39.q;
        if (r40 == null) goto L83;
        Integer r41 = r40.a;
    L84:
        ArrayList r42 = r10.a;
        if (r42 == null) goto L100;
        Iterator r43 = r42.iterator();
        int r44 = 0;
        int r114 = -1;
    L88:
        if (r43.hasNext() == false) goto L101;
        Object r45 = r43.next();
        int r46 = r44 + 1;
        if (r44 >= 0) goto L92;
        CollectionsKt.throwIndexOverflow();
    L92:
        com.larus.bmhome.actionbar.model.r r47 = ((com.larus.bmhome.actionbar.model.z0) r45).q;
        if (r47 == null) goto L95;
        Integer r48 = r47.a;
    L97:
        if (Intrinsics.areEqual(r48, r41) == false) goto L99;
        r114 = r44;
    L99:
        r44 = r46;
        goto L88
    L95:
        r48 = null;
    L101:
        if (r114 < 0) goto L108;
        if (r114 >= this.H.size()) goto L108;
        ((TabLayout.Tab) ListProtector.get(this.H, r114)).select();
        uz9.a r49 = this.r;
        if (r49 == null) goto L107;
        r49.q(r114);
    L107:
        w5(r114, r21, false);
        i4().selectInstructionMenu(r114);
        boolean r50 = true;
    L109:
        if (r50 == true) goto L134;
        com.larus.bmhome.actionbar.model.r r51 = this.s;
        if (r51 == null) goto L113;
        Boolean r115 = r51.d;
    L115:
        if (Intrinsics.areEqual(r115, Boolean.TRUE) == false) goto L130;
        int r52 = this.L.getInt("creation_tab_key_tab_index", -1);
        if (r52 >= 0) goto L119;
    L125:
        ((TabLayout.Tab) CollectionsKt.first(this.H)).select();
        uz9.a r53 = this.r;
        if (r53 == null) goto L128;
        r53.q(0);
    L128:
        w5(0, r21, false);
        r52 = 0;
    L129:
        i4().selectInstructionMenu(r52);
        goto L134
    L119:
        if (r52 >= this.H.size()) goto L125;
        ((TabLayout.Tab) ListProtector.get(this.H, r52)).select();
        uz9.a r54 = this.r;
        if (r54 == null) goto L124;
        r54.q(r52);
    L124:
        w5(r52, r21, false);
        goto L129
    L130:
        ((TabLayout.Tab) CollectionsKt.first(this.H)).select();
        uz9.a r55 = this.r;
        boolean r56 = false;
        if (r55 == null) goto L133;
        r55.q(0);
    L133:
        w5(0, r21, false);
        i4().selectInstructionMenu(0);
    L135:
        Integer r57 = this.y;
        if (this.w == false) goto L139;
        if (r57 == null) goto L139;
        I5(r57.intValue(), r56);
    L144:
        if (r24 == true) goto L146;
        if (r25 == true) goto L146;
    L147:
        com.larus.utils.e1.d(r21.d, new m1(this));
        r21.b.addOnTabSelectedListener(new d(this, r21));
        this.I = true;
        r17.addView(r21.a);
        return;
    L146:
        Q3(r10, r21);
    L139:
        ny9.s r58 = W3();
        if (r58 == null) goto L144;
        Integer r59 = r58.u();
        if (r59 == null) goto L144;
        I5(r59.intValue(), r56);
        goto L144
    L113:
        r115 = null;
    L134:
        r56 = false;
        goto L135
    L100:
        r114 = -1;
        goto L101
    L83:
        r41 = null;
    L108:
        r50 = false;
    L47:
        r24 = false;
    L39:
        r17 = r16;
        goto L40
    L156:
        return;
    L28:
        ny9.s r60 = W3();
        if (r60 == null) goto L32;
        r14 = r60.u();
        goto L31
    L32:
        r15 = null;
        goto L33
    L13:
        r5 = null;
        goto L15
    L157:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.ArrayList] */
    public final boolean B4() {
        sy9.a r0 = (sy9.a) this.R.getValue();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L12;
        String r2 = getContext().getString(2131910630);
        t19.s r3 = t19.s.a;
        Application r4 = AppHost.a.getApplication();
        r3.getClass();
        t19.s.t(r4, r2);
        u3.c("replace_image_reference", r2);
        return true;
    L12:
        ry9.h r5 = l4();
        if (r5 == null) goto L26;
        LiveData<Map<String, ry9.k>> r6 = r5.ja();
        if (r6 == null) goto L26;
        Map r7 = (Map) r6.getValue();
        if (r7 == null) goto L26;
        Collection r8 = r7.values();
        if (r8 == null) goto L26;
        List r9 = new ArrayList();
        Iterator r10 = r8.iterator();
    L22:
        if (r10.hasNext() == false) goto L27;
        Object r11 = r10.next();
        if (((ry9.k) r11).d == false) goto L22;
        r9.add(r11);
    L27:
        if (r9 != 0) goto L30;
        r9 = CollectionsKt.emptyList();
    L30:
        if (r9.isEmpty() == false) goto L32;
        boolean r12 = false;
    L62:
        if (r12 == false) goto L64;
        return true;
    L64:
        ry9.h r13 = l4();
        if (r13 != null) goto L67;
    L69:
        boolean r14 = false;
    L71:
        if (R5(r14) == false) goto L74;
        t19.s r15 = t19.s.a;
        Application r16 = AppHost.a.getApplication();
        r15.getClass();
        t19.s.s(r16, 2131899641);
        return true;
    L74:
        return false;
    L67:
        if (r13.jb() != true) goto L69;
        r14 = true;
        goto L71
    L32:
        List r17 = (List) i4().getAttachmentResources().getValue();
        Iterator r18 = r9.iterator();
        boolean r19 = false;
        boolean r20 = false;
    L34:
        if (r18.hasNext() == false) goto L54;
        ry9.k r21 = (ry9.k) r18.next();
        if (r17 == null) goto L47;
        Iterator r110 = r17.iterator();
    L39:
        if (r110.hasNext() == false) goto L43;
        Object r111 = r110.next();
        if (Intrinsics.areEqual(((ResourceItemBean) r111).getKey(), r21.a) == false) goto L39;
    L44:
        ResourceItemBean r112 = (ResourceItemBean) r111;
        if (r112 == null) goto L47;
        ResourceType r22 = r112.getResourceType();
    L48:
        if (r22 != null) goto L50;
        int r23 = -1;
    L51:
        if (r23 == 1) goto L52;
        r20 = true;
        goto L34
    L52:
        r19 = true;
        goto L34
    L50:
        r23 = b.a[r22.ordinal()];
        goto L51
    L43:
        r111 = null;
    L47:
        r22 = null;
        goto L48
    L54:
        String r24 = "replace_video_reference";
        if (r19 == false) goto L58;
        if (r20 == false) goto L58;
        String r25 = getContext().getString(2131901231);
    L61:
        t19.s r26 = t19.s.a;
        Application r27 = AppHost.a.getApplication();
        r26.getClass();
        t19.s.t(r27, r25);
        u3.c(r24, r25);
        r12 = true;
    L58:
        if (r19 == false) goto L60;
        r25 = getContext().getString(2131899489);
        goto L61
    L60:
        r25 = getContext().getString(2131910630);
        r24 = "replace_image_reference";
    L26:
        r9 = 0;
        goto L27
    L5:
        if (r0.As() != true) goto L7;
        r1 = true;
        goto L9
    }

    public final void C3() {
        p r0 = this.h1;
        if (r0 == null) goto L5;
        F2().removeCallbacks(r0);
    L5:
        this.h1 = null;
    }

    public final com.larus.bmhome.view.actionbar.edit.b D3() {
        IInstructionService.Companion r0 = IInstructionService.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        return IInstructionService.a.a(r0, null, null, com.larus.ui.arch.component.internal.attach.a.b(this, this), this, 3);
    }

    public final com.larus.bmhome.actionbar.model.z0 E3() {
        com.larus.bmhome.actionbar.model.z0 r0 = this.u;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ny9.s r1 = W3();
        String r2 = null;
        if (r1 == null) goto L14;
        com.larus.bmhome.actionbar.model.z0 r3 = r1.f();
        if (r3 == null) goto L15;
        this.u = r3;
        com.larus.bmhome.actionbar.model.r r4 = r3.q;
        if (r4 == null) goto L12;
        r2 = p3(r4);
    L12:
        this.v = r2;
        return r3;
    L15:
        return null;
    L14:
        return null;
    }

    public final com.larus.bmhome.actionbar.model.r E5() {
        if (this.w == true) goto L5;
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        Gson r2 = HttpExtKt.f;     // Catch: Throwable -> L15
        ny9.s r3 = W3();     // Catch: Throwable -> L15
        if (r3 == null) goto L12;
        Bundle r4 = r3.a;     // Catch: Throwable -> L15
        if (r4 == null) goto L12;
        String r5 = r4.getString("template_instruction_conf");     // Catch: Throwable -> L15
    L13:
        Object r6 = Result.constructor-impl((com.larus.bmhome.actionbar.model.r) r2.fromJson(r5, com.larus.bmhome.actionbar.model.r.class));     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r6) == true) goto L22;
        r0 = r6;
    L22:
        return (com.larus.bmhome.actionbar.model.r) r0;
    L12:
        r5 = null;
    L15:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L5:
        return this.x;
    }

    public final String J6() {
        uz9.a r0 = this.r;
        MultiAttachmentSelectorWidget r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.p() == false) goto L15;
        com.larus.uaigc.instruction.y r2 = r0.c;
        if (r2 == null) goto L16;
        MultiAttachmentSelectorWidget r3 = r2.m;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L13:
        return r1.getCurrentNestedFileLocalMessageId();
    L11:
        r1 = r3;
        goto L13
    L16:
        return null;
    L15:
        return null;
    }

    public final void JI() {
        FLogger.a.i("CreationEditorComponent", "handleDeleteDigitalAvatarResult");
        ry9.h r0 = l4();
        if (r0 == null) goto L10;
        ry9.h r1 = l4();
        if (r1 == null) goto L8;
        String r2 = r1.yC();
        if (r2 == null) goto L8;
    L9:
        r0.lu(r2);
    L8:
        r2 = "";
    L10:
        i4().setChosenAvatarInstructionStatus(false);
    }

    public final void M70() {
        if (this.Y == false) goto L5;
        return;
    L5:
        this.g1 = null;
        i4().setChosenMsgInstruction(null);
    }

    public final boolean P0() {
        vp8.i r0 = this.G;
        if (r0 == null) goto L7;
        Boolean r1 = r0.P0();
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return false;
    }

    public final int S4() {
        com.larus.bmhome.actionbar.model.r r0 = this.s;
        Integer r1 = G3();
        if (r1 != null) goto L8;
        ny9.s r2 = W3();
        if (r2 == null) goto L7;
        r1 = r2.u();
        goto L8
    L7:
        r1 = null;
    L8:
        int r3 = -1;
        if (r0 == null) goto L28;
        com.larus.bmhome.actionbar.model.y r4 = r0.i;
        if (r4 == null) goto L28;
        ArrayList r5 = r4.a;
        if (r5 == null) goto L28;
        Iterator r6 = r5.iterator();
        int r7 = 0;
    L16:
        if (r6.hasNext() == false) goto L28;
        Object r8 = r6.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        com.larus.bmhome.actionbar.model.r r10 = ((com.larus.bmhome.actionbar.model.z0) r8).q;
        if (r10 == null) goto L23;
        Integer r11 = r10.a;
    L25:
        if (Intrinsics.areEqual(r1, r11) == false) goto L27;
        r3 = r7;
    L27:
        r7 = r9;
        goto L16
    L23:
        r11 = null;
    L28:
        if (r3 < 0) goto L31;
        return r3;
    L31:
        return ((Number) i4().getInstructionSelectMenuPosition().getValue()).intValue();
    }

    public final NestedFileContent T() {
        uz9.a r0 = this.r;
        if (r0 != null) goto L5;
    L9:
        return null;
    L5:
        if (r0.p() == false) goto L9;
        com.larus.uaigc.instruction.y r1 = r0.c;
        if (r1 == null) goto L9;
        return r1.T();
    }

    public final void T1() {
        uz9.a r0 = this.r;
        if (r0 == null) goto L6;
        r0.T1();
        return;
    }

    public boolean V5() {
        int r0 = CreationHostUiPolicy.f;
        ny9.s r1 = W3();
        if (r1 == null) goto L5;
        Bundle r2 = r1.a;
    L7:
        if (CreationHostUiPolicy.a.a(r2).a == true) goto L12;
        ICreationPageService.a.getClass();
        if (ICreationPageService.a.a() == true) goto L12;
        return false;
    L12:
        return true;
    L5:
        r2 = null;
        goto L7
    }

    public final ny9.s W3() {
        return (ny9.s) this.T.getValue();
    }

    public final void W5() {
        t19.s r0 = t19.s.a;
        Application r1 = AppHost.a.getApplication();
        String r2 = getContext().getString(2131899639);
        r0.getClass();
        t19.s.t(r1, r2);
    }

    public final NestedFileContent Wd() {
        uz9.a r0 = this.r;
        if (r0 == null) goto L7;
        com.larus.uaigc.instruction.y r1 = r0.c;
        if (r1 == null) goto L7;
        return r1.T();
    L7:
        return null;
    }

    public final int X1() {
        vp8.i r0 = this.G;
        if (r0 == null) goto L7;
        Integer r1 = r0.X1();
        if (r1 == null) goto L7;
        return r1.intValue();
    L7:
        return 0;
    }

    public final va8.o X3() {
        return (va8.o) this.N.getValue();
    }

    public final ICoreInputAbility a4() {
        return (ICoreInputAbility) this.M.getValue();
    }

    public final String c0() {
        vp8.i r0 = this.G;
        if (r0 == null) goto L6;
        String r1 = r0.c0();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final py9.a c4() {
        return (py9.a) this.P.getValue();
    }

    public final ny9.u d4() {
        return (ny9.u) this.U.getValue();
    }

    public final qy9.a e4() {
        return (qy9.a) this.V.getValue();
    }

    public final ViewGroup h4() {
        if (this.n != null) goto L21;
        ViewGroup r1 = null;
        if (R4() == true) goto L8;
    L19:
        this.n = r1;
        goto L21
    L8:
        if (T4() == true) goto L19;
        ViewStub r0 = this.m;
        if (r0 == null) goto L19;
        this.m = null;
        View r2 = r0.inflate();
        if (r2 == null) goto L15;
        com.larus.utils.e1.o(r2);
    L17:
        if ((r2 instanceof ViewGroup) == false) goto L19;
        r1 = (ViewGroup) r2;
        goto L19
    L15:
        r2 = null;
    L21:
        return this.n;
    }

    public final void h60() {
        if (this.Z == false) goto L5;
        return;
    L5:
        i4().setChosenImgInspirePrompt(null);
    }

    public final com.larus.bmhome.view.actionbar.edit.c i4() {
        return (com.larus.bmhome.view.actionbar.edit.c) this.p.getValue();
    }

    public final void i5() {
        this.m = (ViewStub) F2().findViewById(2131375368);
        this.C = (LinearLayout) F2().findViewById(2131375333);
        this.D = F2().findViewById(2131362044);
        this.E = F2().findViewById(2131362041);
        if (R4() == false) goto L5;
        ViewExtKt.n(F2(), null, null, new k(this), 3);
    L8:
        LinearLayout r1 = this.C;
        if (r1 == null) goto L13;
        vp8.i r4 = this.G;
        if (r4 == null) goto L13;
        r4.b(r1);
    L13:
        this.F = F2().findViewById(2131369229);
        com.larus.bmhome.actionbar.model.z0 r2 = E3();
        this.u = r2;
        if (r2 == null) goto L16;
        com.larus.bmhome.actionbar.model.r r3 = r2.q;
    L17:
        this.s = r3;
        if (r3 == null) goto L20;
        String r5 = p3(r3);
    L21:
        this.v = r5;
        y5();
        this.w = false;
        this.x = null;
        this.y = null;
        uz9.a r6 = this.r;
        if (r6 != null) goto L24;
    L26:
        boolean r7 = false;
    L27:
        if (r7 == false) goto L32;
        View r8 = this.F;
        if (r8 == null) goto L32;
        r8.setVisibility(0);
    L32:
        if (R4() == false) goto L39;
        ViewGroup r9 = h4();
        if (r9 == null) goto L36;
        com.larus.utils.e1.x(r9);
        r9.setBackgroundResource(v19.c.b(2130970697, getContext(), 2131239177));
    L42:
        va8.o r10 = X3();
        if (r10 == null) goto L45;
        r10.G60(v19.c.b(2130970688, getContext(), 2131239146));
    L45:
        AlbumHelperKt.g(LifecycleOwnerKt.getLifecycleScope(this), null, new CreationEditorComponent$observerInstructionEditor$1(this, null), 3);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new CreationEditorComponent$observerInstructionEditor$2(this, null), 2, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new CreationEditorComponent$observerInstructionEditor$3(this, null), 2, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$observerInstructionEditor$4(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$observerInstructionEditor$5(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$observerInstructionEditor$6(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$observerInstructionEditor$7(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$observerInstructionEditor$8(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$observerInstructionEditor$9(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$observerInstructionEditor$10(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$observerInstructionEditor$11(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$observerInstructionEditor$12(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$observerInstructionEditor$13(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$observerInstructionEditor$14(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$observerInstructionEditor$15(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$observerInstructionEditor$16(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$observerInstructionEditor$17(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$observerInstructionEditor$18(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$observerInstructionEditor$19(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$observerInstructionEditor$20(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$observerInstructionEditor$21(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$observerInstructionEditor$22(this, null), 3, null);
        if (this.z == true) goto L49;
        this.z = true;
        CopyOnWriteArraySet r11 = InstructionInputManager.a;
        c r12 = this.B;
        Intrinsics.checkNotNullParameter(r12, "actionbarChangeListener");
        InstructionInputManager.a.add(r12);
    L49:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$bindObservers$1(this, null), 3, null);
        vp8.i r13 = this.G;
        if (r13 == null) goto L52;
        r13.d(i4());
    L52:
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new CreationEditorComponent$initPassedTemplateInfo$1(this, null));
        return;
    L36:
        LinearLayout r14 = this.C;
        if (r14 == null) goto L42;
        r14.setBackgroundResource(v19.c.b(2130970697, getContext(), 2131239177));
        goto L42
    L39:
        LinearLayout r15 = this.C;
        if (r15 == null) goto L42;
        r15.setBackgroundResource(v19.c.b(2130970697, getContext(), 2131239177));
        goto L42
    L24:
        if (r6.l() != true) goto L26;
        r7 = true;
        goto L27
    L20:
        r5 = null;
        goto L21
    L16:
        r3 = null;
        goto L17
    L5:
        LinearLayout r16 = this.C;
        if (r16 == null) goto L8;
        int r17 = c7.b(12);
        int r18 = r16.getPaddingStart();
        int r19 = r16.getPaddingEnd();
        int r20 = r16.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + r16.getClass().getSimpleName() + ",source:,start:" + r18 + ",top:" + r17 + ",end:" + r19 + ",bottom:" + r20);
        r16.setPaddingRelative(r18, r17, r19, r20);
        goto L8
    }

    public final ry9.g k4() {
        return (ry9.g) this.Q.getValue();
    }

    public final ry9.h l4() {
        return (ry9.h) this.O.getValue();
    }

    public final ArrayList<Integer> mr() {
        uz9.a r0 = this.r;
        if (r0 == null) goto L16;
        if (r0.p() == false) goto L19;
        com.larus.uaigc.instruction.y r1 = r0.c;
        if (r1 == null) goto L18;
        MultiAttachmentSelectorWidget r2 = r1.m;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
        r2 = null;
    L11:
        ArrayList<Integer> r3 = r2.getCurrentAvatarSubscriptIndex();
        if (r3 == null) goto L18;
        return r3;
    L18:
        return new ArrayList();
    L19:
        return new ArrayList();
    L16:
        return new ArrayList();
    }

    public final String p4() {
        com.larus.bmhome.actionbar.model.r r0 = this.s;
        boolean r1 = false;
        if (r0 == null) goto L10;
        Integer r2 = r0.a;
        if (r2 == null) goto L10;
        if (r2.intValue() != 28) goto L10;
        r1 = true;
    L10:
        if (r1 == true) goto L12;
        return "no_tab";
    L12:
        if (((Number) i4().getInstructionSelectMenuPosition().getValue()).intValue() != 0) goto L14;
        return "pic";
    L14:
        return "video";
    }

    public final void pV() {
        this.k0 = "";
    }

    public final uy9.a q4() {
        return (uy9.a) this.S.getValue();
    }

    public final boolean w4() {
        uz9.a r0 = this.r;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.a();
    }

    public void y5() {
        uz9.a r1 = this.r;
        if (r1 == null) goto L5;
        r1.a.clear();
        r1.b = null;
    L5:
        com.larus.bmhome.actionbar.model.r r2 = this.s;
        if (r2 == null) goto L8;
        Integer r3 = r2.a;
    L9:
        boolean r4 = true;
        if (V4(r3) == false) goto L12;
        B3();
    L228:
        Integer r5 = i4().getInstructionType();
        if (r5 != null) goto L232;
    L233:
        if (r3 != null) goto L236;
    L237:
        String r6 = i4().getInstructionInputBoxHint();
        if (r6 != null) goto L240;
        return;
    L240:
        if (r6.length() > 0) goto L243;
        r4 = false;
    L243:
        if (r4 == false) goto L245;
        CharSequence r7 = r6;
    L246:
        if (r7 == null) goto L262;
        Q5(r7);
        return;
    L262:
        return;
    L245:
        r7 = null;
        goto L246
    L236:
        if (r3.intValue() != 28) goto L237;
        return;
    L232:
        if (r5.intValue() != 1) goto L233;
        return;
    L12:
        com.larus.bmhome.actionbar.model.z0 r8 = E3();
        if (((Boolean) this.T1.getValue()).booleanValue() == true) goto L17;
        uz9.a r9 = this.r;
        if (r9 == null) goto L17;
        com.larus.bmhome.view.actionbar.edit.b r10 = D3();
        FLogger.a.d("CreationEditorComponent", "truly instructionEditorFactory:".concat(r10.getClass().getSimpleName()));
        Intrinsics.checkNotNullParameter(r10, "factory");
        r9.a.add(r10);
    L17:
        if (r8 == null) goto L228;
        if (R4() == false) goto L88;
        ny9.s r11 = W3();
        if (r11 == null) goto L23;
        boolean r12 = r11.z();
    L24:
        FLogger.a.i("CreationEditorComponent", "initInstructionEditor");
        com.larus.bmhome.actionbar.model.r r13 = r8.q;
        if (r13 == null) goto L88;
        if (r12 == false) goto L29;
        String r14 = getContext().getString(2131901253);
    L32:
        ViewGroup r15 = h4();
        if (r15 == null) goto L35;
        TextView r16 = (TextView) r15.findViewById(2131362053);
    L36:
        if (r16 == null) goto L38;
        r16.setText(r14);
    L38:
        ViewGroup r17 = h4();
        if (r17 == null) goto L41;
        ImageView r18 = (ImageView) r17.findViewById(2131374662);
    L42:
        if (r18 == null) goto L44;
        com.larus.utils.e1.o(r18);
    L44:
        ViewGroup r19 = h4();
        if (r19 == null) goto L47;
        ConstraintLayout r20 = r19.findViewById(2131388849);
    L48:
        if (r20 == null) goto L50;
        r20.setClickable(false);
    L50:
        vp8.i r21 = this.G;
        if (r21 == null) goto L53;
        Boolean r22 = Boolean.valueOf(r21.g(r13));
    L55:
        if (Intrinsics.areEqual(r22, Boolean.TRUE) == true) goto L88;
        if (r12 == false) goto L68;
        ViewGroup r23 = h4();
        if (r23 == null) goto L62;
        SimpleDraweeView r24 = r23.findViewById(2131374716);
    L63:
        if (r24 == null) goto L82;
        GenericDraweeHierarchy r25 = r24.getHierarchy();
        if (r25 == null) goto L82;
        r25.setPlaceholderImage(v19.c.b(2130972306, getContext(), 2131243413));
    L82:
        ViewGroup r26 = h4();
        if (r26 == null) goto L85;
        View r27 = r26.findViewById(2131366952);
    L86:
        if (r27 == null) goto L88;
        com.larus.utils.e1.d(r27, new h1(this));
        goto L88
    L85:
        r27 = null;
        goto L86
    L62:
        r24 = null;
        goto L63
    L68:
        if (((Boolean) this.v1.getValue()).booleanValue() == false) goto L72;
        com.larus.bmhome.actionbar.model.g1 r28 = r8.d;
        if (r28 != null) goto L74;
    L75:
        String r29 = null;
    L76:
        ViewGroup r30 = h4();
        if (r30 == null) goto L79;
        SimpleDraweeView r31 = r30.findViewById(2131374716);
    L80:
        if (r31 == null) goto L82;
        ImageLoaderKt.y(r31, r29, "custom_actionbar_icon_instruction", new w0(), 4);
        goto L82
    L79:
        r31 = null;
    L74:
        r29 = r28.b;
        goto L76
    L72:
        r28 = r8.c;
        if (r28 == null) goto L75;
    L53:
        r22 = null;
        goto L55
    L47:
        r20 = null;
        goto L48
    L41:
        r18 = null;
        goto L42
    L35:
        r16 = null;
        goto L36
    L29:
        if (com.larus.utils.o0.d(r8.h) == false) goto L31;
        r14 = r8.h;
        goto L32
    L31:
        r14 = r8.e;
        goto L32
    L23:
        r12 = false;
    L88:
        com.larus.bmhome.actionbar.model.r r32 = this.s;
        if (r32 == null) goto L228;
        LinearLayout r110 = this.C;
        if (r110 == null) goto L209;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$buildNormalInstructionEditor$2$1$1$1(this, null), 3, null);
        com.larus.bmhome.view.actionbar.edit.c.a.a(i4(), r8, E5(), 5, null, z3(), null, null, 104);
        if (R4() == false) goto L96;
        LinearLayout r33 = j4();
        if (r33 == null) goto L96;
    L97:
        ny9.s r34 = W3();
        if (r34 != null) goto L100;
    L102:
        boolean r35 = false;
    L103:
        if (r35 == false) goto L105;
        LinearLayout r111 = null;
    L106:
        if (r111 == null) goto L108;
        r111.removeAllViews();
    L108:
        uz9.a r36 = this.r;
        if (r36 != null) goto L111;
    L206:
        qy9.a r37 = e4();
        if (r37 == null) goto L209;
        r37.lk(r33);
        goto L209
    L111:
        if (((oy9.a) this.W.getValue()) == null) goto L143;
        List r38 = r32.b;
        if (r38 == null) goto L134;
        List r39 = r38;
        if ((r39 instanceof Collection) == true) goto L117;
    L119:
        Iterator r40 = r39.iterator();
    L121:
        if (r40.hasNext() == false) goto L131;
        Integer r112 = ((com.larus.bmhome.actionbar.model.u) r40.next()).b;
        if (r112 != null) goto L126;
    L128:
        boolean r113 = false;
    L129:
        if (r113 == false) goto L121;
        boolean r41 = true;
    L132:
        if (r41 != true) goto L134;
        boolean r42 = true;
    L135:
        if (r42 == true) goto L143;
        com.larus.bmhome.actionbar.model.u r43 = new com.larus.bmhome.actionbar.model.u(null, 12, null, xt7.d.b.a(com.larus.bmhome.actionbar.model.e.Companion.serializer(), new com.larus.bmhome.actionbar.model.e(CollectionsKt.listOf(new com.larus.bmhome.actionbar.model.f(0, null, null, null, null, null, 255)), 27)), null, null, null, 245);
        List r44 = r32.b;
        if (r44 == null) goto L140;
        List r45 = CollectionsKt.toMutableList(r44);
        if (r45 == null) goto L140;
    L141:
        r45.add(r43);
        r32.b = r45;
    L140:
        r45 = new ArrayList();
        goto L141
    L126:
        if (r112.intValue() != 12) goto L128;
        r113 = true;
    L131:
        r41 = false;
        goto L132
    L117:
        if (r39.isEmpty() == false) goto L119;
    L134:
        r42 = false;
    L143:
        if (q4() == null) goto L181;
        ny9.s r46 = W3();
        if (r46 != null) goto L147;
    L149:
        boolean r47 = false;
    L150:
        if (r47 == false) goto L181;
        List r48 = r32.b;
        if (r48 == null) goto L173;
        List r49 = r48;
        if ((r49 instanceof Collection) == true) goto L156;
    L158:
        Iterator r50 = r49.iterator();
    L160:
        if (r50.hasNext() == false) goto L170;
        Integer r51 = ((com.larus.bmhome.actionbar.model.u) r50.next()).b;
        if (r51 != null) goto L165;
    L167:
        boolean r52 = false;
    L168:
        if (r52 == false) goto L160;
        boolean r53 = true;
    L171:
        if (r53 != true) goto L173;
        boolean r54 = true;
    L174:
        if (r54 == true) goto L181;
        com.larus.bmhome.actionbar.model.u r55 = new com.larus.bmhome.actionbar.model.u(null, 11, null, xt7.d.b.a(com.larus.bmhome.actionbar.model.n.Companion.serializer(), new com.larus.bmhome.actionbar.model.n(CollectionsKt.listOf(new com.larus.bmhome.actionbar.model.w(null, null, null, null, 0, null, null, 8388607)), 30)), null, null, null, 245);
        List r56 = r32.b;
        if (r56 == null) goto L179;
        List r57 = CollectionsKt.toMutableList(r56);
        if (r57 == null) goto L179;
    L180:
        r57.add(r55);
        r32.b = r57;
    L179:
        r57 = new ArrayList();
        goto L180
    L165:
        if (r51.intValue() != 11) goto L167;
        r52 = true;
    L170:
        r53 = false;
        goto L171
    L156:
        if (r49.isEmpty() == false) goto L158;
    L173:
        r54 = false;
        goto L174
    L147:
        if (r46.B() != true) goto L149;
        r47 = true;
    L181:
        com.larus.bmhome.view.actionbar.edit.c r114 = i4();
        r114.setCurrentInstructionConfig(r32);
        ny9.s r58 = W3();
        if (r58 == null) goto L184;
        String r59 = r58.w();
    L185:
        String r60 = "";
        if (r59 != null) goto L188;
        r59 = "";
    L188:
        String r61 = String.valueOf(r32.a);
        String r62 = r32.g;
        if (r62 == null) goto L192;
        r60 = r62;
    L192:
        r114.setActionBarName(r59, r61, r60);
        ny9.s r63 = W3();
        if (r63 == null) goto L197;
        ChatParam r64 = r63.c();
        if (r64 == null) goto L197;
        r114.bindChatParam(r64);
    L197:
        Unit r65 = Unit.INSTANCE;
        if (R4() == false) goto L200;
        ActivityResultLauncher<String> r115 = this.L0;
    L202:
        if (R4() == false) goto L204;
        ActivityResultLauncher<Intent> r116 = this.P0;
    L205:
        com.larus.bmhome.view.actionbar.edit.b.a.a(r36, r32, r111, r114, r115, r116, (e) this.X.getValue(), new com.larus.bmhome.view.actionbar.edit.d(i4().getInstructionDefaultParams()), null, false, null, 896);
        goto L206
    L204:
        r116 = null;
        goto L205
    L200:
        r115 = null;
        goto L202
    L184:
        r59 = null;
        goto L185
    L105:
        r111 = r33;
        goto L106
    L100:
        if (r34.z() != true) goto L102;
        r35 = true;
    L96:
        r33 = r110;
    L209:
        uz9.a r66 = this.r;
        if (r66 == null) goto L212;
        r66.onViewShow();
    L212:
        ry9.g r67 = k4();
        if (r67 == null) goto L217;
        kotlinx.coroutines.flow.i1<ry9.j> r68 = r67.D20();
        if (r68 == null) goto L217;
        ry9.j r69 = (ry9.j) r68.getValue();
    L219:
        if ((r69 instanceof ry9.j.h) == false) goto L228;
        ny9.s r70 = W3();
        if (r70 != null) goto L223;
    L225:
        boolean r71 = false;
    L226:
        if (r71 == false) goto L228;
        i4().selectRatio(0);
        goto L228
    L223:
        if (r70.B() != true) goto L225;
        r71 = true;
    L217:
        r69 = null;
        goto L219
    L8:
        r3 = null;
        goto L9
    }

    public final com.larus.bmhome.actionbar.model.w0 yn() {
        com.larus.bmhome.actionbar.model.r r0 = this.s;
        boolean r1 = false;
        if (r0 == null) goto L10;
        Integer r2 = r0.a;
        if (r2 == null) goto L10;
        if (r2.intValue() != 18) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
    L14:
        r1 = true;
    L15:
        if (r1 == false) goto L17;
        Long r4 = i4().getSelectedVideoModelId();
        if (r4 == null) goto L21;
        long r5 = r4.longValue();
    L22:
        com.larus.bmhome.actionbar.model.r r6 = this.s;
        if (r6 == null) goto L29;
        com.larus.bmhome.actionbar.model.y r7 = r6.i;
        if (r7 == null) goto L29;
        com.larus.bmhome.actionbar.model.w0 r8 = r7.a(r5);
        if (r8 == null) goto L29;
    L30:
        Pair<Long, ? extends com.larus.bmhome.actionbar.model.w0> r9 = TuplesKt.to(Long.valueOf(r5), r8);
        if (Intrinsics.areEqual(this.t, r9) == true) goto L57;
        this.t = r9;
        Set<String> r10 = cq9.b.a;
        CreationMultiReferenceLogEvent r11 = CreationMultiReferenceLogEvent.RULE_PARSED;
        Boolean r12 = Boolean.valueOf(true ^ (r8 instanceof com.larus.bmhome.actionbar.model.w0.b));
        String.valueOf(r5);
        boolean r13 = r8 instanceof com.larus.bmhome.actionbar.model.w0.a;
        if (r13 == false) goto L37;
        CreationMultiReferenceProtocolState r14 = CreationMultiReferenceProtocolState.AVAILABLE;
    L35:
        CreationMultiReferenceProtocolState r15 = r14;
        if (r13 == false) goto L43;
        CreationMultiReferenceRuleResult r16 = CreationMultiReferenceRuleResult.PASS;
    L46:
        if (Intrinsics.areEqual(r8, com.larus.bmhome.actionbar.model.w0.b.a) == false) goto L48;
        String r17 = "default_attachment_flow";
    L50:
        cq9.b.a(r11, r12, "video_creation", "model_input_rule_selector", null, r15, r16, r17, 544);
        goto L57
    L48:
        if (r13 == false) goto L52;
        r17 = null;
        goto L50
    L52:
        throw new NoWhenBranchMatchedException();
    L43:
        if (Intrinsics.areEqual(r8, com.larus.bmhome.actionbar.model.w0.b.a) == false) goto L54;
        r16 = null;
        goto L46
    L54:
        throw new NoWhenBranchMatchedException();
    L37:
        if (Intrinsics.areEqual(r8, com.larus.bmhome.actionbar.model.w0.b.a) == false) goto L56;
        r14 = CreationMultiReferenceProtocolState.LEGACY;
        goto L35
    L56:
        throw new NoWhenBranchMatchedException();
    L57:
        return r8;
    L29:
        r8 = com.larus.bmhome.actionbar.model.w0.b.a;
        goto L30
    L21:
        r5 = 0;
        goto L22
    L17:
        return com.larus.bmhome.actionbar.model.w0.b.a;
    L13:
        if (isInVideoTab() == false) goto L15;
    L10:
        r3 = false;
        goto L11
    }

    public final aq8.e z3() {
        String r4 = null;
        if (this.w == true) goto L11;
        ny9.s r0 = W3();
        if (r0 == null) goto L11;
        Bundle r1 = r0.a;
        if (r1 == null) goto L11;
        r4 = r1.getString("actionbar_instruction_default_params");
    L11:
        return new aq8.e(null, null, null, r4, null, this.w, null, null, null, null, 983);
    }

    public CreationEditorComponent() {
        this.p = LazyKt.lazy(new m(this));
        this.q = LazyKt.lazy(new x());
        this.B = new c(this);
        this.H = new ArrayList();
        this.J = new HashMap();
        this.K = new HashMap();
        this.L = Keva.getRepo("creation_tab_memory_repo", 0);
        this.M = LazyKt.lazy(new y(this));
        this.N = LazyKt.lazy(new z(this));
        this.O = LazyKt.lazy(new b0(this));
        this.P = LazyKt.lazy(new c0(this));
        this.Q = LazyKt.lazy(new d0(this));
        this.R = LazyKt.lazy(new e0(this));
        this.S = LazyKt.lazy(new f0(this));
        this.T = LazyKt.lazy(new g0(this));
        this.U = LazyKt.lazy(new n(this));
        this.V = LazyKt.lazy(new o(this));
        this.W = LazyKt.lazy(new q(this));
        this.X = LazyKt.lazy(LazyThreadSafetyMode.NONE, new r(this));
        this.k0 = "";
        this.H0 = new Rect();
        this.k1 = LazyKt.lazy(new s());
        this.v1 = LazyKt.lazy(new t(this));
        this.x1 = LazyKt.lazy(new u());
        Boolean r0 = Boolean.FALSE;
        StateFlowImpl r1 = kotlinx.coroutines.flow.j1.a(r0);
        this.y1 = r1;
        this.G1 = kotlinx.coroutines.flow.e.b(r1);
        this.S1 = r0;
        this.T1 = LazyKt.lazy(new v(this));
        this.V1 = LazyKt.lazy(new w(this));
        this.b2 = new LinkedHashSet();
    }

    public final boolean A80() {
        com.larus.bmhome.actionbar.model.w0.a r0 = yn();
        if (Intrinsics.areEqual(r0, com.larus.bmhome.actionbar.model.w0.b.a) == false) goto L6;
        return true;
    L6:
        if ((r0 instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L17;
        wa8.d1 r1 = r0.a;
        uz9.a r2 = this.r;
        if (r2 == null) goto L15;
        ry9.d r3 = r2.n();
        DigitalAvatarInfoManager.a.getClass();
        ey9.a r4 = DigitalAvatarInfoManager.f();
        if (r4 == null) goto L12;
        Double r5 = Double.valueOf(r4.c());
    L13:
        ry9.d r6 = ry9.d.a(r3, 1, r5);
        CreationReferenceAttachmentViolation r7 = ry9.e.b(r1, r6);
        i4().getSelectedVideoModelId();
        f5(this, "avatar_selection", "avatar_selector", r6, r7);
        return !s5(r7, r1.a);
    L12:
        r5 = null;
        goto L13
    L15:
        return true;
    L17:
        throw new NoWhenBranchMatchedException();
    }

    public final Integer G3() {
        int r0 = ((Number) i4().getInstructionSelectMenuPosition().getValue()).intValue();
        com.larus.bmhome.actionbar.model.r r1 = this.s;
        if (r1 == null) goto L16;
        com.larus.bmhome.actionbar.model.y r2 = r1.i;
        if (r2 == null) goto L16;
        ArrayList r3 = r2.a;
        if (r3 == null) goto L16;
        com.larus.bmhome.actionbar.model.z0 r4 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.getOrNull(r3, r0);
        if (r4 == null) goto L16;
        com.larus.bmhome.actionbar.model.r r5 = r4.q;
        if (r5 == null) goto L16;
        Integer r6 = r5.a;
        if (r6 == null) goto L16;
        return Integer.valueOf(r6.intValue());
    L16:
        com.larus.bmhome.actionbar.model.r r7 = i4().getCurrentInstructionConf();
        if (r7 == null) goto L22;
        Integer r8 = r7.a;
        if (r8 == null) goto L22;
        return Integer.valueOf(r8.intValue());
    L22:
        ny9.s r9 = W3();
        if (r9 != null) goto L27;
        return null;
    L27:
        return r9.u();
    }

    public final int M4() {
        com.larus.bmhome.actionbar.model.r r0 = i4().getCurrentInstructionConf();
        if (r0 == null) goto L5;
        Integer r1 = r0.a;
    L6:
        if (r1 == null) goto L12;
        if (r1.intValue() != 1) goto L12;
        return i5.B();
    L12:
        return i5.j();
    L5:
        r1 = null;
        goto L6
    }

    public final boolean Pz() {
        int r0 = ((Number) i4().getInstructionSelectMenuPosition().getValue()).intValue();
        com.larus.bmhome.actionbar.model.r r1 = i4().getCurrentInstructionConf();
        if (r1 == null) goto L9;
        com.larus.bmhome.actionbar.model.y r2 = r1.i;
        if (r2 == null) goto L9;
        ArrayList r3 = r2.a;
        if (r3 == null) goto L9;
        com.larus.bmhome.actionbar.model.z0 r4 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.getOrNull(r3, r0);
    L11:
        if (r4 == null) goto L21;
        com.larus.bmhome.actionbar.model.r r5 = r4.q;
        if (r5 == null) goto L22;
        Integer r6 = r5.a;
        if (r6 != null) goto L18;
        return false;
    L18:
        if (r6.intValue() != 18) goto L23;
        return true;
    L23:
        return false;
    L22:
        return false;
    L21:
        return false;
    L9:
        r4 = null;
        goto L11
    }

    public final int Q1() {
        com.larus.bmhome.view.actionbar.edit.c r0 = i4();
        if (r0 == null) goto L7;
        Integer r1 = r0.getInstructionType();
        if (r1 == null) goto L7;
        return r1.intValue();
    L7:
        return 0;
    }

    public final boolean R4() {
        if ((getContext() instanceof ny9.i) == true) goto L8;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if ((com.larus.ui.arch.component.internal.attach.a.b(this, this) instanceof ny9.i) == true) goto L8;
        return false;
    L8:
        return true;
    }

    public final void S7() {
        com.larus.bmhome.view.actionbar.edit.c r0 = i4();
        if (r0 == null) goto L7;
        com.larus.bmhome.actionbar.model.r r1 = r0.getCurrentInstructionConf();
        if (r1 == null) goto L7;
        Integer r2 = r1.a;
    L8:
        if (r2 != null) goto L11;
    L15:
        va8.o r3 = X3();
        if (r3 == null) goto L21;
        r3.c70(i5.j());
        return;
    L21:
        return;
    L11:
        if (r2.intValue() != 1) goto L15;
        va8.o r4 = X3();
        if (r4 == null) goto L19;
        r4.c70(i5.B());
        return;
    L19:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final boolean T4() {
        com.larus.bmhome.actionbar.model.z0 r0 = E3();
        if (r0 == null) goto L13;
        com.larus.bmhome.actionbar.model.r r1 = r0.q;
        if (r1 == null) goto L14;
        Integer r2 = r1.a;
        if (r2 != null) goto L10;
        return false;
    L10:
        if (r2.intValue() != 28) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L13:
        return false;
    }

    public final boolean T5() {
        ny9.s r0 = W3();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.a() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean Wm() {
        Long r0 = i4().getSelectedVideoModelId();
        long r1 = 0;
        if (r0 == null) goto L5;
        long r3 = r0.longValue();
    L6:
        com.larus.bmhome.actionbar.model.r r2 = this.s;
        boolean r5 = true;
        if (r2 == null) goto L49;
        com.larus.bmhome.actionbar.model.y r4 = r2.i;
        if (r4 == null) goto L49;
        Object r7 = r4.d;
        monitor-enter(r7);
        com.larus.bmhome.actionbar.model.h r6 = r4.c();     // Catch: Throwable -> L46
        monitor-exit(r7);
        Boolean r8 = null;
        if (r6 == null) goto L44;
        List r9 = r6.e;
        if (r9 == null) goto L44;
        Iterator r10 = r9.iterator();
    L20:
        if (r10.hasNext() == false) goto L30;
        Object r11 = r10.next();
        Long r12 = ((com.larus.bmhome.actionbar.model.w) r11).a;
        if (r12 != null) goto L25;
    L27:
        boolean r13 = false;
    L28:
        if (r13 == false) goto L20;
    L31:
        com.larus.bmhome.actionbar.model.w r14 = (com.larus.bmhome.actionbar.model.w) r11;
        if (r14 == null) goto L44;
        Map r15 = r14.q;
        if (r15 == null) goto L44;
        String r16 = (String) r15.get("i2v_can_choose_ratio");
        if (r16 == null) goto L44;
        if (Intrinsics.areEqual(r16, "1") == false) goto L42;
        Boolean r17 = Boolean.TRUE;
    L40:
        r8 = r17;
        goto L44
    L42:
        if (Intrinsics.areEqual(r16, "0") == false) goto L44;
        r17 = Boolean.FALSE;
        goto L40
    L25:
        if (r12.longValue() != r3) goto L27;
        r13 = true;
        goto L28
    L30:
        r11 = null;
    L44:
        if (r8 == null) goto L49;
        return r8.booleanValue();
    L46:
        th = move-exception;
        throw th;
    L49:
        Long r18 = i4().getSelectedVideoModelId();
        if (r18 == null) goto L53;
        r1 = r18.longValue();
    L53:
        if (r1 == 4) goto L57;
        r5 = false;
    L57:
        return r5;
    L5:
        r3 = 0;
        goto L6
    }

    public final ScrollView Z3() {
        ViewGroup r0 = h4();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (ScrollView) r0.findViewById(2131367612);
    }

    public final void c6() {
        if (R4() == true) goto L5;
        return;
    L5:
        ScrollView r0 = Z3();
        int r1 = 0;
        if (r0 == null) goto L10;
        boolean r2 = true;
        if (r0.isAttachedToWindow() != true) goto L10;
    L11:
        if (r2 == false) goto L39;
        F2().getWindowVisibleDisplayFrame(this.H0);
        va8.o r3 = X3();
        if (r3 == null) goto L17;
        Integer r4 = r3.hH();
        if (r4 == null) goto L17;
        int r5 = r4.intValue();
    L18:
        Rect r6 = this.H0;
        int r7 = (((r6.bottom - r6.top) - r5) - i5.h0()) - i5.J();
        LinearLayout r8 = j4();
        if (r8 == null) goto L21;
        r1 = r8.getMeasuredHeight();
    L21:
        if (r7 >= r1) goto L27;
        ScrollView r9 = Z3();
        if (r9 == null) goto L32;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if (r10 == null) goto L32;
        r10.height = r7;
    L32:
        ScrollView r11 = Z3();
        if (r11 == null) goto L35;
        r11.addOnLayoutChangeListener(new f(this));
    L35:
        ScrollView r12 = Z3();
        if (r12 == null) goto L40;
        r12.requestLayout();
        return;
    L40:
        return;
    L27:
        ScrollView r13 = Z3();
        if (r13 == null) goto L32;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L32;
        r14.height = -2;
    L17:
        r5 = 0;
        goto L18
    L39:
        return;
    L10:
        r2 = false;
        goto L11
    }

    public final List<com.larus.bmhome.actionbar.model.w> getCurImageList() {
        return i4().getCurImageList();
    }

    public final com.larus.bmhome.actionbar.model.r getCurrentInstructionConf() {
        return i4().getCurrentInstructionConf();
    }

    public final Long getDefaultSelectedImageStyleId() {
        return i4().getDefaultSelectedImageStyleId();
    }

    public final List<com.larus.bmhome.actionbar.model.w> getRatioOptionList() {
        return i4().getRatioOptionList();
    }

    public final kotlinx.coroutines.flow.d1<com.larus.bmhome.view.actionbar.edit.o> getSelectDurationFlow() {
        return i4().getSelectDurationFlow();
    }

    public final kotlinx.coroutines.flow.i1<com.larus.bmhome.view.actionbar.edit.p> getSelectVideoModelFlow() {
        return i4().getSelectVideoModelFlow();
    }

    public final boolean i3() {
        com.larus.bmhome.view.actionbar.edit.c r0 = i4();
        if (r0 == null) goto L10;
        kotlinx.coroutines.flow.i1 r1 = r0.getInstructionReferenceImageUploadStatus();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (((Number) r1.getValue()).intValue() != 1) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final boolean isInVideoTab() {
        return i4().isInVideoTab();
    }

    public final LinearLayout j4() {
        ViewGroup r0 = h4();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (LinearLayout) r0.findViewById(2131378935);
    }

    public final String k() {
        uy9.a r0 = q4();
        if (r0 == null) goto L5;
        r0.Rq();
        String r1 = "template_page";
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L21;
        if (R4() == false) goto L21;
        ny9.s r3 = W3();
        if (r3 == null) goto L22;
        Bundle r4 = r3.a;
        if (r4 == null) goto L23;
        r1 = r4.getString("previous_page_name");
        goto L21
    L23:
        return null;
    L22:
        return null;
    L21:
        return r1;
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final boolean lv() {
        if (Pz() == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) i4().getChosenAvatarInstructionStatus().getValue()).booleanValue() == false) goto L7;
        return true;
    }

    public final AttachmentInfo n4() {
        return i4().getInstructionReferenceImage();
    }

    public final void o6() {
        int r0 = S4();
        if (dk(r0) == true) goto L6;
        r0 = 0;
    L6:
        hy9.d r3 = ICreationReportService.a.j();
        ny9.u r1 = d4();
        String r4 = null;
        if (r1 == null) goto L9;
        String r2 = r1.r();
    L10:
        ny9.u r5 = d4();
        if (r5 == null) goto L13;
        String r6 = r5.a();
    L14:
        ny9.u r7 = d4();
        if (r7 == null) goto L17;
        String r8 = r7.m();
    L18:
        ny9.u r9 = d4();
        if (r9 == null) goto L21;
        r4 = r9.c();
    L21:
        String r10 = r4;
        if (r0 != 0) goto L24;
        String r11 = this.K.get(0);
    L28:
        r3.f(r2, r6, r8, r10, r11);
        return;
    L24:
        if (r0 == 1) goto L26;
        r11 = "";
        goto L28
    L26:
        r11 = this.K.get(1);
        goto L28
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r2 = null;
        goto L10
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        i4().setVideoModelSelectionInterceptor(new j0(this));
        k1a.b.b(this, new k0(this));
        i4().setCreationActionBar(Boolean.TRUE);
    }

    public final void onDestroy() {
        i4().setVideoModelSelectionInterceptor(null);
        if (this.z == false) goto L6;
        this.z = false;
        CopyOnWriteArraySet r0 = InstructionInputManager.a;
        c r1 = this.B;
        Intrinsics.checkNotNullParameter(r1, "actionbarChangeListener");
        InstructionInputManager.a.remove(r1);
    L6:
        C3();
        vp8.i r2 = this.G;
        if (r2 == null) goto L10;
        r2.onDestroy();
        return;
    }

    public final boolean pE() {
        int r0 = ((Number) i4().getInstructionSelectMenuPosition().getValue()).intValue();
        com.larus.bmhome.actionbar.model.r r1 = i4().getCurrentInstructionConf();
        if (r1 == null) goto L9;
        com.larus.bmhome.actionbar.model.y r2 = r1.i;
        if (r2 == null) goto L9;
        ArrayList r3 = r2.a;
        if (r3 == null) goto L9;
        com.larus.bmhome.actionbar.model.z0 r4 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.getOrNull(r3, r0);
    L11:
        if (r4 == null) goto L20;
        com.larus.bmhome.actionbar.model.r r5 = r4.q;
        if (r5 == null) goto L20;
        Integer r6 = r5.a;
        if (r6 == null) goto L20;
        if (r6.intValue() != 4) goto L20;
        boolean r7 = true;
    L21:
        if (r7 == true) goto L23;
    L25:
        return false;
    L23:
        if (((Boolean) i4().getChosenAvatarInstructionStatus().getValue()).booleanValue() == false) goto L25;
        return true;
    L20:
        r7 = false;
    L9:
        r4 = null;
        goto L11
    }

    public final boolean qo() {
        Boolean r0 = i4().getActionBarInstructionInputSendReadyState();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public final com.larus.bmhome.actionbar.model.e2 tQ() {
        Long r0 = i4().getSelectedVideoModelId();
        if (r0 == null) goto L5;
        long r1 = r0.longValue();
    L6:
        com.larus.bmhome.actionbar.model.r r2 = this.s;
        if (r2 == null) goto L11;
        com.larus.bmhome.actionbar.model.y r3 = r2.i;
        if (r3 == null) goto L11;
        return r3.d(r1);
    L11:
        return null;
    L5:
        r1 = 0;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [com.larus.uaigc.createpage.component.instruction.h0] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.larus.uaigc.createpage.component.instruction.i0] */
    public final void y2() {
        ny9.s r0 = W3();
        String r1 = null;
        if (r0 == null) goto L5;
        Boolean r2 = (Boolean) r0.h.getValue();
    L6:
        this.S1 = r2;
        w1 r3 = new w1(this);
        vp8.i r4 = IAIChatUgcAIGCService.a.M();
        this.G = r4;
        if (r4 != null) goto L9;
    L42:
        vp8.i r5 = this.G;
        if (r5 == null) goto L45;
        r5.onAttach();
    L45:
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, ys8.a.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.larus.ui.arch.component.internal.attach.a.b(this, this);
        uz9.a r6 = new uz9.a();
        FLogger.a.d("CreationEditorComponent", "truly VirtualInstructionEditorFactory:".concat(uz9.a.class.getSimpleName()));
        this.r = r6;
        return;
    L9:
        if (T4() == false) goto L21;
        r4.a(new DigitalAvatarInstructionBizAdapter(this, r3, "chat_action_bar"));
        r4.a(new com.larus.uaigc.music.b(this, r3));
        ny9.u r7 = d4();
        if (r7 == null) goto L13;
        String r8 = r7.b();
    L15:
        if (com.larus.utils.o0.d(r8) == false) goto L19;
        ny9.u r9 = d4();
        if (r9 == null) goto L20;
        r1 = r9.b();
    L20:
        r4.a(new com.larus.uaigc.createpage.component.instruction.d(this, r1, "template_page"));
        r4.a(new t2(this, r1, new h0(this), new i0(this)));
        goto L21
    L19:
        LruCache r10 = ko8.a.a;
        r1 = ko8.a.h(ko8.a.e);
        goto L20
    L13:
        r8 = null;
    L21:
        com.larus.bmhome.actionbar.model.r r11 = this.s;
        boolean r12 = false;
        if (r11 == null) goto L29;
        Integer r13 = r11.a;
        if (r13 == null) goto L29;
        if (r13.intValue() != 1) goto L29;
        boolean r14 = true;
    L30:
        if (r14 == false) goto L32;
        r4.a(new com.larus.uaigc.music.b(this, r3));
    L32:
        com.larus.bmhome.actionbar.model.r r15 = this.s;
        if (r15 == null) goto L40;
        Integer r16 = r15.a;
        if (r16 == null) goto L40;
        if (r16.intValue() != 11) goto L40;
        r12 = true;
    L40:
        if (r12 == false) goto L42;
        r4.a(new DigitalAvatarInstructionBizAdapter(this, r3, "5tab_create_pannel"));
    L29:
        r14 = false;
        goto L30
    L5:
        r2 = null;
        goto L6
    }

    public final kotlinx.coroutines.flow.b1 tP() {
        return this.G1;
    }

    public final String xh() {
        return this.p0;
    }

    public final String zQ() {
        return this.k0;
    }

    public static View Y2(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static String p3(com.larus.bmhome.actionbar.model.r r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(xt7.d.b.a(com.larus.bmhome.actionbar.model.r.Companion.serializer(), r2));     // Catch: Throwable -> L4
    L7:
        if (Result.exceptionOrNull-impl(r1) == null) goto L11;
        r1 = r2.toString();
    L11:
        return (String) r1;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static Integer z5(com.larus.bmhome.actionbar.model.z0 r5) {
        com.larus.bmhome.actionbar.model.r r6 = r5.q;
        if (r6 == null) goto L41;
        List r7 = r6.b;
        if (r7 == null) goto L41;
        Iterator r8 = r7.iterator();
    L7:
        int r2 = 0;
        if (r8.hasNext() == false) goto L18;
        Object r1 = r8.next();
        Integer r3 = ((com.larus.bmhome.actionbar.model.u) r1).b;
        if (r3 != null) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == false) goto L7;
    L19:
        com.larus.bmhome.actionbar.model.u r9 = (com.larus.bmhome.actionbar.model.u) r1;
        if (r9 == null) goto L41;
        String r10 = r9.d;
        if (r10 == null) goto L41;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L25
        Object r12 = Result.constructor-impl((com.larus.bmhome.actionbar.model.v) xt7.d.b.c(com.larus.bmhome.actionbar.model.v.Companion.serializer(), r10));     // Catch: Throwable -> L25
    L28:
        if (Result.isFailure-impl(r12) == false) goto L30;
        r12 = null;
    L30:
        com.larus.bmhome.actionbar.model.v r13 = (com.larus.bmhome.actionbar.model.v) r12;
        if (r13 != null) goto L33;
        return null;
    L33:
        PollingConfigService r0 = PollingConfigService.a;
        if (l3.e(r0.f("cre_upl_pic_num"), 0) > 0) goto L49;
        Integer r14 = r13.a;
        if (r14 == null) goto L40;
        r2 = r14.intValue();
    L40:
        return Integer.valueOf(r2);
    L49:
        return Integer.valueOf(l3.e(r0.f("cre_upl_pic_num"), 0));
    L25:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L13:
        if (r3.intValue() != 15) goto L15;
        r4 = true;
        goto L16
    L18:
        r1 = null;
    L41:
        return null;
    }

    public final void A8(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        vp8.i r0 = this.G;
        if (r0 == null) goto L6;
        r0.f(r2);
        return;
    }

    public final boolean G4(com.larus.bmhome.actionbar.model.z0 r11) {
        com.larus.bmhome.actionbar.model.r r0 = r11.q;
        if (r0 == null) goto L5;
        Integer r1 = r0.a;
    L7:
        if (r1 != null) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r1 != null) goto L16;
    L18:
        boolean r2 = false;
    L19:
        if (r4 == true) goto L23;
        if (r2 == true) goto L23;
        boolean r5 = false;
    L25:
        if (((Boolean) this.x1.getValue()).booleanValue() == false) goto L129;
        if (r5 == false) goto L129;
        DigitalAvatarInfoManager.a.getClass();
        if (DigitalAvatarInfoManager.g() == true) goto L31;
        W4(r11.a);
        return true;
    L31:
        if (r2 == true) goto L33;
    L36:
        com.larus.bmhome.actionbar.model.r r6 = this.s;
        if (r6 == null) goto L67;
        com.larus.bmhome.actionbar.model.y r7 = r6.i;
        if (r7 == null) goto L67;
        ArrayList r8 = r7.a;
        if (r8 == null) goto L67;
        Iterator r9 = r8.iterator();
        int r10 = 0;
    L44:
        if (r9.hasNext() == false) goto L67;
        com.larus.bmhome.actionbar.model.z0 r12 = (com.larus.bmhome.actionbar.model.z0) r9.next();
        if (r4 == false) goto L55;
        com.larus.bmhome.actionbar.model.r r13 = r12.q;
        if (r13 == null) goto L63;
        Integer r14 = r13.a;
        if (r14 == null) goto L63;
        if (r14.intValue() != 4) goto L63;
    L62:
        boolean r15 = true;
    L64:
        if (r15 == true) goto L68;
        r10 = r10 + 1;
    L68:
        if (r10 > (-1)) goto L70;
    L73:
        int r16 = ((Number) i4().getInstructionSelectMenuPosition().getValue()).intValue();
    L74:
        com.larus.bmhome.actionbar.model.r r17 = this.s;
        if (r17 == null) goto L85;
        com.larus.bmhome.actionbar.model.y r18 = r17.i;
        if (r18 == null) goto L85;
        ArrayList r19 = r18.a;
        if (r19 == null) goto L85;
        com.larus.bmhome.actionbar.model.z0 r20 = (com.larus.bmhome.actionbar.model.z0) ListProtector.get(r19, r10);
        if (r20 == null) goto L85;
        com.larus.bmhome.actionbar.model.r r21 = r20.q;
        if (r21 == null) goto L85;
        Integer r22 = r21.a;
    L86:
        if (r22 == null) goto L89;
        I5(r22.intValue(), true);
    L89:
        if (((Number) i4().getInstructionSelectMenuPosition().getValue()).intValue() != r16) goto L93;
        ICoreInputAbility r23 = a4();
        if (r23 == null) goto L93;
        r23.g2(1, true);
    L93:
        com.larus.bmhome.actionbar.model.r r110 = r11.q;
        if (r110 == null) goto L100;
        com.larus.bmhome.actionbar.model.j1 r111 = r110.e;
        if (r111 == null) goto L100;
        String r112 = r111.v;
        if (r112 == null) goto L100;
        Long r113 = StringsKt.toLongOrNull(r112);
    L101:
        if (r113 == null) goto L106;
        if (r22 == null) goto L106;
        if (Intrinsics.areEqual(G3(), r22) == false) goto L106;
        i4().selectModel(r22.intValue(), r113.longValue());
    L106:
        if (r2 == true) goto L108;
    L110:
        DigitalAvatarInfoManager.a.getClass();
        if (DigitalAvatarInfoManager.i() == false) goto L116;
        ry9.h r114 = l4();
        if (r114 == null) goto L120;
        r114.JZ(DigitalAvatarInfoManager.e());
    L120:
        wr(false);
        if (DigitalAvatarInfoManager.g() == true) goto L123;
        i4().setChosenAvatarInstructionStatus(false);
    L124:
        ICoreInputAbility r115 = a4();
        if (r115 == null) goto L127;
        ICoreInputAbility.b.e(r115, "inner handleInstructionForm", null, false, 6);
    L127:
        i4().onInputHintChanged(O3(r16), "inner handleInstructionForm");
        return true;
    L123:
        i4().setChosenAvatarInstructionStatus(true);
        goto L124
    L116:
        if (DigitalAvatarInfoManager.h() == false) goto L120;
        ry9.h r116 = l4();
        if (r116 == null) goto L120;
        r116.JZ((String) DigitalAvatarInfoManager.b.getValue());
        goto L120
    L108:
        if (A80() == true) goto L110;
        return true;
    L100:
        r113 = null;
    L85:
        r22 = null;
        goto L86
    L70:
        if ((r10 + 1) > this.H.size()) goto L73;
        r16 = r10;
    L63:
        r15 = false;
        goto L64
    L55:
        com.larus.bmhome.actionbar.model.r r24 = r12.q;
        if (r24 == null) goto L63;
        Integer r25 = r24.a;
        if (r25 == null) goto L63;
        if (r25.intValue() != 18) goto L63;
    L67:
        r10 = -1;
        goto L68
    L33:
        if (DigitalAvatarInfoManager.j() == false) goto L36;
        W4(r11.a);
        return true;
    L129:
        return false;
    L23:
        r5 = true;
        goto L25
    L16:
        if (r1.intValue() != 32) goto L18;
        r2 = true;
        goto L19
    L10:
        if (r1.intValue() != 11) goto L12;
        r4 = true;
        goto L13
    L5:
        r1 = null;
        goto L7
    }

    public final void H3(boolean r4) {
        ICoreInputAbility r0 = a4();
        if (r0 == null) goto L14;
        va8.o r1 = X3();
        if (r1 == null) goto L7;
        r1.SB(r4);
    L7:
        va8.o r2 = X3();
        if (r2 == null) goto L11;
        r2.qG(r4);
    L11:
        if (r0.Rp() != 2) goto L15;
        r0.setEnabled(r4);
        return;
    L15:
        return;
    }

    public final String O3(int r3) {
        com.larus.bmhome.view.actionbar.edit.c r0 = i4();
        uz9.a r1 = this.r;
        if (r1 == null) goto L7;
        Integer r2 = r1.j();
        if (r2 == null) goto L7;
        int r4 = r2.intValue();
    L9:
        return r0.getHintStr(r3, r4);
    L7:
        r4 = 0;
        goto L9
    }

    public final void Q5(CharSequence r2) {
        ICoreInputAbility r0 = a4();
        if (r0 == null) goto L6;
        r0.Yk(r2);
        return;
    }

    public final boolean R5(boolean r7) {
        int r0 = com.larus.uaigc.createpage.component.input.a.a;
        com.larus.uaigc.helper.f.a.getClass();
        boolean r1 = com.larus.uaigc.helper.f.a();
        boolean r2 = V5();
        boolean r3 = Intrinsics.areEqual(com.larus.uaigc.helper.f.c().d(), Boolean.TRUE);
        ry9.h r4 = l4();
        if (r4 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r7 == false) goto L17;
        if (r1 == false) goto L12;
        if (r2 == false) goto L12;
        boolean r8 = true;
    L13:
        if (r8 == true) goto L17;
        if (r3 == false) goto L19;
        if (r5 == false) goto L17;
        return true;
    L19:
        return true;
    L12:
        r8 = false;
    L17:
        return false;
    L5:
        if (r4.Wb() != true) goto L7;
        r5 = true;
        goto L8
    }

    public final boolean V4(Integer r4) {
        if (r4 != null) goto L6;
    L8:
        boolean r5 = false;
    L9:
        com.larus.bmhome.actionbar.model.r r2 = this.s;
        if (r2 == null) goto L14;
        com.larus.bmhome.actionbar.model.y r3 = r2.i;
        if (r3 == null) goto L14;
        ArrayList r6 = r3.a;
    L15:
        if (r6 != null) goto L17;
    L19:
        boolean r7 = false;
    L20:
        if (r5 == false) goto L24;
        if (r7 == false) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L17:
        if (r6.size() <= 1) goto L19;
        r7 = true;
    L14:
        r6 = null;
        goto L15
    L6:
        if (r4.intValue() != 28) goto L8;
        r5 = true;
        goto L9
    }

    public final void W4(Long r14) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        uy9.a r2 = null;
        if (r1 == null) goto L7;
        t1a.b r3 = s1a.a.g(r1);
        if (r3 == null) goto L7;
        ny9.s r4 = (ny9.s) r3.a(ny9.s.class);
    L8:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if (r0 == null) goto L13;
        t1a.b r5 = s1a.a.g(r0);
        if (r5 == null) goto L13;
        r2 = (uy9.a) r5.getAbility(uy9.a.class);
    L13:
        uy9.a r6 = r2;
        LifecycleCoroutineScope r7 = LifecycleOwnerKt.getLifecycleScope(this);
        if (r7 == null) goto L17;
        BuildersKt.launch$default(r7, null, null, new CreationEditorComponent$jumpToCreateOrCompleteAvatar$1(r4, this, r6, r14, null), 3, null);
        return;
    L17:
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final ys8.b Xx(long r5) {
        com.larus.bmhome.actionbar.model.r r0 = this.s;
        boolean r1 = false;
        if (r0 == null) goto L10;
        Integer r2 = r0.a;
        if (r2 == null) goto L10;
        if (r2.intValue() != 28) goto L10;
        r1 = true;
    L10:
        if (r1 == false) goto L12;
        com.larus.bmhome.actionbar.model.r r3 = this.s;
        if (r3 == null) goto L42;
        com.larus.bmhome.actionbar.model.y r4 = r3.i;
        if (r4 == null) goto L42;
        Object r6 = r4.d;
        monitor-enter(r6);
        com.larus.bmhome.actionbar.model.h r7 = r4.c();     // Catch: Throwable -> L38
        String r8 = null;
        if (r7 == null) goto L24;
        Long r9 = wa8.k0.b(r7, r5);     // Catch: Throwable -> L38
    L25:
        monitor-exit(r6);
        if (r9 != null) goto L45;
        com.larus.bmhome.actionbar.model.w0.a r10 = r4.a(r5);
        if ((r10 instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L31;
        com.larus.bmhome.actionbar.model.w0.a r11 = r10;
    L32:
        if (r11 == null) goto L37;
        wa8.d1 r12 = r11.a;
        if (r12 == null) goto L37;
        r8 = r12.a;
    L37:
        return new ys8.b.c(r8);
    L31:
        r11 = null;
        goto L32
    L45:
        return new ys8.b.a(r9.longValue());
    L24:
        r9 = null;
    L38:
        th = move-exception;
        throw th;
    L42:
        return ys8.b.b.a;
    L12:
        return ys8.b.b.a;
    }

    public final void b00(int r2) {
        I5(r2, false);
    }

    public final void c00(int r2) {
        I5(r2, true);
    }

    public final boolean dk(int r8) {
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        com.larus.bmhome.actionbar.model.r r1 = this.s;
        Object r4 = null;
        if (r1 == null) goto L66;
        com.larus.bmhome.actionbar.model.y r2 = r1.i;
        if (r2 == null) goto L66;
        ArrayList r3 = r2.a;
        if (r3 == null) goto L66;
        com.larus.bmhome.actionbar.model.z0 r9 = (com.larus.bmhome.actionbar.model.z0) ListProtector.get(r3, r8);
        if (r9 == null) goto L66;
        com.larus.bmhome.actionbar.model.r r10 = r9.q;
        if (r10 == null) goto L28;
        List r11 = r10.b;
        if (r11 == null) goto L28;
        Iterator r12 = r11.iterator();
    L16:
        if (r12.hasNext() == false) goto L26;
        Object r5 = r12.next();
        Integer r6 = ((com.larus.bmhome.actionbar.model.u) r5).b;
        if (r6 != null) goto L21;
    L23:
        boolean r7 = false;
    L24:
        if (r7 == false) goto L16;
    L27:
        com.larus.bmhome.actionbar.model.u r13 = (com.larus.bmhome.actionbar.model.u) r5;
    L29:
        r0.element = r13;
        goto L66
    L21:
        if (r6.intValue() != 8) goto L23;
        r7 = true;
        goto L24
    L26:
        r5 = null;
    L28:
        r13 = null;
    L66:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L38
        ouc.v r15 = xt7.d.b;     // Catch: Throwable -> L38
        juc.c r16 = com.larus.bmhome.actionbar.model.b0.Companion.serializer();     // Catch: Throwable -> L38
        com.larus.bmhome.actionbar.model.u r17 = (com.larus.bmhome.actionbar.model.u) r0.element;     // Catch: Throwable -> L38
        if (r17 == null) goto L33;
        String r18 = r17.d;     // Catch: Throwable -> L38
    L34:
        if (r18 != null) goto L36;
        r18 = "";
    L36:
        Object r19 = Result.constructor-impl((com.larus.bmhome.actionbar.model.b0) r15.c(r16, r18));     // Catch: Throwable -> L38
    L41:
        if (Result.isFailure-impl(r19) == true) goto L44;
        r4 = r19;
    L44:
        com.larus.bmhome.actionbar.model.b0 r20 = (com.larus.bmhome.actionbar.model.b0) r4;
        if (r20 == null) goto L78;
        List r21 = r20.a;
        if (r21 == null) goto L79;
        List r22 = r21;
        if ((r22 instanceof Collection) == true) goto L51;
    L53:
        Iterator r23 = r22.iterator();
    L55:
        if (r23.hasNext() == false) goto L62;
        if (((com.larus.bmhome.actionbar.model.c0) r23.next()).b != 8) goto L59;
        boolean r24 = true;
    L60:
        if (r24 == false) goto L55;
        boolean r25 = true;
    L63:
        if (r25 != true) goto L80;
        return true;
    L80:
        return false;
    L59:
        r24 = false;
    L62:
        r25 = false;
        goto L63
    L51:
        if (r22.isEmpty() == false) goto L53;
    L79:
        return false;
    L78:
        return false;
    L33:
        r18 = null;
    L38:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    }

    public final void h5(Uri r9) {
        ny9.s r0 = W3();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L16;
        i4().setOriginalRatioEnable(true);
        Long r2 = i4().getSelectedRatioId();
        if (r2 == null) goto L12;
        long r3 = r2.longValue();
    L14:
        if (r3 >= 0) goto L16;
        selectRatio(0);
        goto L16
    L12:
        r3 = -1;
    L16:
        ICoreInputAbility r4 = a4();
        if (r4 == null) goto L19;
        r4.qp(false);
    L19:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new CreationEditorComponent$onAlbumSelected$1(r9, this, null), 2, null);
        return;
    L5:
        if (r0.B() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void j6(int r4) {
        FLogger.a.i("CreationEditorComponent", "status:" + r4);
        ICoreInputAbility r0 = a4();
        if (r0 == null) goto L6;
        r0.g2(r4, true);
        return;
    }

    public final void mI(Intent r11) {
        if (r11 == null) goto L5;
        String r1 = r11.getStringExtra("ipa_main_url");
    L6:
        if (r11 == null) goto L8;
        Long r12 = Long.valueOf(r11.getLongExtra("target_instruction_item_id", 0));
    L9:
        ny9.s r2 = W3();
        if (r2 == null) goto L21;
        List r3 = (List) r2.d.getValue();
        if (r3 == null) goto L21;
        Iterator r4 = r3.iterator();
    L15:
        if (r4.hasNext() == false) goto L19;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.z0) r5).a, r12) == false) goto L15;
    L20:
        com.larus.bmhome.actionbar.model.z0 r6 = (com.larus.bmhome.actionbar.model.z0) r5;
    L22:
        FLogger.a.i("CreationEditorComponent", "handleUploadDigitalAvatarResult ipaMainUrl = " + r1);
        if (r1 == null) goto L32;
        this.S1 = Boolean.TRUE;
        ry9.h r13 = l4();
        if (r13 == null) goto L27;
        r13.JZ(r1);
    L27:
        i4().setChosenAvatarInstructionStatus(true);
        wr(false);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$handleUploadDigitalAvatarResult$1$1(this, r6, null), 3, null);
        return;
    L32:
        return;
    L19:
        r5 = null;
    L21:
        r6 = null;
        goto L22
    L8:
        r12 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public void onViewCreated(View r8) {
        Intrinsics.checkNotNullParameter(r8, "view");
        if (R4() == false) goto L5;
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.L0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).registerForActivityResult(new ActivityResultContracts.GetContent(), new n1(this));
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.P0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new com.larus.uaigc.createpage.component.instruction.f(this));
    L6:
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.V0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).registerForActivityResult(new ActivityResultContracts.GetContent(), new i(this));
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.b1 = com.larus.ui.arch.component.internal.attach.a.b(this, this).registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new j(this));
        if (((Boolean) this.T1.getValue()).booleanValue() == false) goto L12;
        uz9.a r9 = this.r;
        if (r9 == null) goto L11;
        com.larus.bmhome.view.actionbar.edit.b r0 = D3();
        FLogger.a.d("CreationEditorComponent", "truly instructionEditorFactory:".concat(r0.getClass().getSimpleName()));
        Intrinsics.checkNotNullParameter(r0, "factory");
        r9.a.add(r0);
    L11:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new AnonymousClass2(this, null), 2, null);
        return;
    L12:
        i5();
        return;
    L5:
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.L0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).registerForActivityResult(new ActivityResultContracts.GetContent(), new com.larus.uaigc.createpage.component.instruction.g(this));
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.P0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new h(this));
        goto L6
    }

    public final void q5(final boolean r29) {
        com.larus.platform.service.k2 r0 = com.larus.platform.service.k2.a;
        g3.a.a(null, s1a.a.getActivity(this), false, null, false, new l(this, r29), 29);
        ny9.s r1 = W3();
        String r2 = null;
        if (r1 == null) goto L5;
        com.larus.bmhome.actionbar.model.z0 r3 = r1.f();
    L6:
        ny9.u r4 = d4();
        if (r4 == null) goto L9;
        String r5 = r4.getBotId();
    L10:
        ny9.u r6 = d4();
        if (r6 == null) goto L13;
        String r8 = r6.getChatType();
    L14:
        ny9.u r7 = d4();
        if (r7 == null) goto L17;
        String r9 = r7.r();
    L18:
        ny9.u r10 = d4();
        if (r10 == null) goto L21;
        String r11 = r10.getEnterMethod();
    L22:
        if (r3 == null) goto L28;
        com.larus.bmhome.actionbar.model.r r12 = r3.q;
        if (r12 == null) goto L28;
        Integer r13 = r12.a;
        if (r13 == null) goto L28;
        String r14 = r13.toString();
    L29:
        if (r3 == null) goto L33;
        com.larus.bmhome.actionbar.model.r r15 = r3.q;
        if (r15 == null) goto L33;
        r2 = r15.g;
    L33:
        tx9.c0.H(r5, r9, r11, null, r8, null, null, r14, r2, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, 33554024);
        return;
    L28:
        r14 = null;
        goto L29
    L21:
        r11 = null;
        goto L22
    L17:
        r9 = null;
        goto L18
    L13:
        r8 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void refreshImageListSelectorWithMore(List<com.larus.bmhome.actionbar.model.w> r2) {
        Intrinsics.checkNotNullParameter(r2, "imageList");
        i4().refreshImageListSelectorWithMore(r2);
    }

    public final void selectRatio(long r2) {
        i4().selectRatio(r2);
    }

    public final void setEnableResetTemplateCacheAfterDetach(boolean r2) {
        i4().setEnableResetTemplateCacheAfterDetach(false);
    }

    public final void setOriginalRatioEnable(boolean r2) {
        i4().setOriginalRatioEnable(true);
    }

    public final void setRatioDropDownSelectorClickInterceptor(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        i4().setRatioDropDownSelectorClickInterceptor(r2);
    }

    public final void setVideoModelDropDownSelectorClickInterceptor(Function0<Boolean> r2) {
        i4().setVideoModelDropDownSelectorClickInterceptor(r2);
    }

    public final void wr(boolean r9) {
        if (this.L1 == true) goto L24;
        hy9.d r1 = ICreationReportService.a.j();
        ny9.u r0 = d4();
        if (r0 == null) goto L7;
        String r3 = r0.a();
    L8:
        ny9.u r2 = d4();
        if (r2 == null) goto L11;
        String r4 = r2.m();
    L12:
        ny9.u r5 = d4();
        if (r5 == null) goto L15;
        String r6 = r5.c();
    L16:
        int r7 = S4();
        if (r7 == 0) goto L21;
        if (r7 == 1) goto L20;
        String r8 = "";
    L22:
        r1.d(r9 ? 1 : 0, r3, r4, r6, r8);
        this.L1 = true;
        return;
    L20:
        r8 = this.K.get(1);
        goto L22
    L21:
        r8 = this.K.get(0);
        goto L22
    L15:
        r6 = null;
        goto L16
    L11:
        r4 = null;
        goto L12
    L7:
        r3 = null;
        goto L8
    }

    public final boolean x(String r2) {
        Intrinsics.checkNotNullParameter(r2, "input");
        vp8.i r0 = this.G;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.x(r2);
    }

    public final String x5(String r7) {
        ny9.s r0 = W3();
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.z() != true) goto L7;
    L8:
        if (r2 == false) goto L38;
        ny9.s r1 = W3();
        Integer r3 = null;
        if (r1 == null) goto L13;
        CustomInputInitData r4 = r1.g();
    L14:
        ny9.s r5 = W3();
        if (r5 == null) goto L17;
        String r6 = r5.q();
    L18:
        Intrinsics.checkNotNullParameter(r7, "userInputText");
        if (r6 == null) goto L39;
        if (r4 == null) goto L23;
        Integer r8 = r4.c();
    L24:
        if (r4 == null) goto L26;
        r3 = r4.a();
    L26:
        if (r8 == null) goto L37;
        if (r3 == null) goto L37;
        if (r8.intValue() < 0) goto L37;
        if (r3.intValue() > r6.length()) goto L37;
        if (r8.intValue() > r3.intValue()) goto L37;
        r6 = r6.substring(0, r8.intValue()) + r7 + r6.substring(r3.intValue());
    L37:
        return r6;
    L23:
        r8 = null;
        goto L24
    L39:
        return r7;
    L17:
        r6 = null;
        goto L18
    L13:
        r4 = null;
        goto L14
    L38:
        return r7;
    L7:
        r2 = false;
        goto L8
    }

    public final String y6(String r10) {
        Intrinsics.checkNotNullParameter(r10, "userInput");
        ry9.h r0 = l4();
        com.larus.bmhome.instruction.d2 r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.yC();
    L7:
        if (com.larus.utils.o0.d(r2) == true) goto L9;
    L12:
        this.S1 = Boolean.FALSE;
        return IAIChatUgcAIGCService.a.e0().f(x5(r10), i4(), this.r, i4().getChosenMsgInstruction(), i4().getChosenImgInspirePrompt(), r1);
    L9:
        if (Intrinsics.areEqual(this.S1, Boolean.TRUE) == false) goto L11;
        r1 = com.larus.bmhome.instruction.d2.a;
        goto L12
    L11:
        r1 = com.larus.bmhome.instruction.e2.a;
        goto L12
    L5:
        r2 = null;
        goto L7
    }

    public static final void h3(CreationEditorComponent r25, Pair r26) {
        Set<ConstraintLayout> r1 = r25.b2;
        monitor-enter(r1);
    L75:
        th = move-exception;
        throw th;
    L5:
        if ((((ConstraintLayout) r26.getFirst()) instanceof com.larus.uaigc.creation.e) == true) goto L7;
    L72:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L75
        monitor-exit(r1);
        return;
    L7:
        if (((Boolean) r26.getSecond()).booleanValue() == false) goto L72;
        if (r25.b2.contains(r26.getFirst()) == true) goto L72;
        r25.b2.add((ConstraintLayout) r26.getFirst());     // Catch: Throwable -> L75
        Object r2 = r26.getFirst();     // Catch: Throwable -> L75
        String r4 = null;
        if ((r2 instanceof com.larus.uaigc.creation.e) == false) goto L13;
        com.larus.uaigc.creation.e r3 = (com.larus.uaigc.creation.e) r2;     // Catch: Throwable -> L75
    L14:
        if (r3 == null) goto L72;
        ny9.u r5 = r25.d4();     // Catch: Throwable -> L75
        if (r5 == null) goto L18;
        String r6 = r5.b();     // Catch: Throwable -> L75
    L20:
        if (com.larus.utils.o0.d(r6) == false) goto L25;
        ny9.u r7 = r25.d4();     // Catch: Throwable -> L75
        if (r7 == null) goto L24;
        String r8 = r7.b();     // Catch: Throwable -> L75
    L26:
        String r15 = r8;
    L28:
        if (r3.getMultiItemType() == 8) goto L30;
    L32:
        hy9.d r9 = ICreationReportService.a.j();     // Catch: Throwable -> L75
        String r10 = r3.getButtonName();     // Catch: Throwable -> L75
        Integer r11 = r3.getImageEditFunctionId();     // Catch: Throwable -> L75
        if (r11 == null) goto L35;
        String r12 = r11.toString();     // Catch: Throwable -> L75
    L36:
        ny9.u r13 = r25.d4();     // Catch: Throwable -> L75
        if (r13 == null) goto L39;
        String r14 = r13.r();     // Catch: Throwable -> L75
    L40:
        ny9.u r16 = r25.d4();     // Catch: Throwable -> L75
        if (r16 == null) goto L43;
        String r17 = r16.getBotId();     // Catch: Throwable -> L75
    L44:
        String r19 = r25.k();     // Catch: Throwable -> L75
        uy9.a r18 = r25.q4();     // Catch: Throwable -> L75
        if (r18 == null) goto L47;
        String r20 = r18.PG();     // Catch: Throwable -> L75
    L48:
        String r110 = r25.p4();     // Catch: Throwable -> L75
        ny9.u r21 = r25.d4();     // Catch: Throwable -> L75
        if (r21 == null) goto L51;
        String r111 = r21.getEnterMethod();     // Catch: Throwable -> L75
    L52:
        ny9.u r22 = r25.d4();     // Catch: Throwable -> L75
        if (r22 == null) goto L55;
        String r112 = r22.m();     // Catch: Throwable -> L75
    L56:
        ny9.u r23 = r25.d4();     // Catch: Throwable -> L75
        if (r23 == null) goto L59;
        String r113 = r23.i();     // Catch: Throwable -> L75
    L60:
        ny9.u r24 = r25.d4();     // Catch: Throwable -> L75
        if (r24 == null) goto L63;
        String r27 = r24.e();     // Catch: Throwable -> L75
    L64:
        ny9.u r28 = r25.d4();     // Catch: Throwable -> L75
        if (r28 == null) goto L67;
        String r29 = r28.n();     // Catch: Throwable -> L75
    L68:
        ny9.u r30 = r25.d4();     // Catch: Throwable -> L75
        if (r30 == null) goto L71;
        r4 = r30.k();     // Catch: Throwable -> L75
    L71:
        hy9.d.a.b(r9, r10, null, r12, r14, "single_function", r17, r111, r112, r113, r15, null, null, r110, r19, r20, r27, r29, r4, 789506);     // Catch: Throwable -> L75
        goto L72
    L67:
        r29 = null;
        goto L68
    L63:
        r27 = null;
        goto L64
    L59:
        r113 = null;
        goto L60
    L55:
        r112 = null;
        goto L56
    L51:
        r111 = null;
        goto L52
    L47:
        r20 = null;
        goto L48
    L43:
        r17 = null;
        goto L44
    L39:
        r14 = null;
        goto L40
    L35:
        r12 = null;
        goto L36
    L30:
        if (r25.H1 == true) goto L32;
        r25.o6();     // Catch: Throwable -> L75
        r25.H1 = true;     // Catch: Throwable -> L75
        goto L72
    L24:
        r15 = null;
        goto L28
    L25:
        LruCache r31 = ko8.a.a;     // Catch: Throwable -> L75
        r8 = ko8.a.h(ko8.a.e);     // Catch: Throwable -> L75
        goto L26
    L18:
        r6 = null;
        goto L20
    L13:
        r3 = null;
        goto L14
    }

    public static final void m3(final CreationEditorComponent r30, Map r31) {
        r30.getClass();
        final Ref.IntRef r1 = new Ref.IntRef();
        final Ref.IntRef r2 = new Ref.IntRef();
        List r3 = (List) r30.i4().getAttachmentResources().getValue();
        Iterator r4 = r31.values().iterator();
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r4.hasNext() == false) goto L63;
        ry9.k r15 = (ry9.k) r4.next();
        ry9.j r5 = r15.b;
        Iterator r20 = r4;
        if ((r5 instanceof ry9.j.b) == true) goto L31;
        if ((r5 instanceof ry9.j.c) == false) goto L11;
        r11 = r11 + 1;
        goto L31
    L11:
        if ((r5 instanceof ry9.j.f) == false) goto L14;
        r7 = r7 + 1;
        goto L31
    L14:
        if ((r5 instanceof ry9.j.h) == false) goto L17;
        r10 = r10 + 1;
        goto L31
    L17:
        if ((r5 instanceof ry9.j.d) == false) goto L20;
        r8 = r8 + 1;
        goto L31
    L20:
        if ((r5 instanceof ry9.j.e) == false) goto L23;
        r6 = r6 + 1;
        goto L31
    L23:
        if ((r5 instanceof ry9.j.g) == false) goto L26;
        r9 = r9 + 1;
        goto L31
    L26:
        if ((r5 instanceof ry9.j.a) == false) goto L29;
        r12 = r12 + 1;
        goto L31
    L29:
        throw new NoWhenBranchMatchedException();
    L31:
        if (r15.d == false) goto L60;
        r13 = r13 + 1;
        if (r3 == null) goto L43;
        Iterator r16 = r3.iterator();
    L36:
        if (r16.hasNext() == false) goto L41;
        Object r21 = r16.next();
        Iterator r22 = r16;
        if (Intrinsics.areEqual(((ResourceItemBean) r21).getKey(), r15.a) == true) goto L42;
        r16 = r22;
    L42:
        ResourceItemBean r23 = (ResourceItemBean) r21;
    L44:
        if (r23 == null) goto L46;
        ResourceType r17 = r23.getResourceType();
    L47:
        if (r17 != null) goto L49;
        int r18 = -1;
    L51:
        if (r18 != 1) goto L53;
        r2.element++;
        goto L60
    L53:
        if (r18 != 2) goto L55;
    L57:
        r1.element++;
        goto L60
    L55:
        if (r18 == 3) goto L57;
        r1.element++;
        goto L60
    L49:
        r18 = b.a[r17.ordinal()];
        goto L51
    L46:
        r17 = null;
        goto L47
    L41:
        r21 = null;
        goto L42
    L43:
        r23 = null;
    L60:
        if (r15.e == false) goto L62;
        r14 = r14 + 1;
    L62:
        r4 = r20;
        goto L4
    L63:
        FLogger.a.i("CreationEditorComponent", "[updateCoreInputByAttachmentStatus] parseFailCount = " + r6 + ", uploadFailCount = " + r7 + ", inspectFail = " + r8 + ", uploadSuccessCount = " + r9 + ", uploadingCount = " + r10 + ", successCount = " + r11 + ", compressingCount = " + r12 + ", privateCount = " + r13);
        int r19 = r31.size();
        ArrayList r24 = new ArrayList();
        if (r19 <= 1) goto L66;
        int r25 = 3;
        r24.add(3);
    L67:
        if (r14 <= 0) goto L76;
        Integer[] r110 = new Integer[r25];
        r110[0] = Integer.valueOf(r25);
        r110[1] = 2;
        r110[2] = 1;
        Iterator r26 = CollectionsKt.arrayListOf(r110).iterator();
    L70:
        if (r26.hasNext() == false) goto L76;
        int r111 = ((Number) r26.next()).intValue();
        Iterator r112 = r26;
        if (r24.contains(Integer.valueOf(r111)) == true) goto L74;
        r24.add(Integer.valueOf(r111));
    L74:
        r26 = r112;
    L76:
        int r27 = ((Number) r30.i4().getInstructionSelectMenuPosition().getValue()).intValue();
        com.larus.bmhome.actionbar.model.r r113 = r30.i4().getCurrentInstructionConf();
        if (r113 == null) goto L83;
        com.larus.bmhome.actionbar.model.y r114 = r113.i;
        if (r114 == null) goto L83;
        ArrayList r115 = r114.a;
        if (r115 == null) goto L83;
        int r116 = r115.size();
    L84:
        if (r27 < 0) goto L87;
        if (r27 >= r116) goto L87;
        boolean r117 = true;
    L88:
        if (r117 == false) goto L121;
        com.larus.bmhome.actionbar.model.r r28 = r30.i4().getCurrentInstructionConf();
        if (r28 == null) goto L121;
        com.larus.bmhome.actionbar.model.y r29 = r28.i;
        if (r29 == null) goto L121;
        ArrayList r32 = r29.a;
        if (r32 == null) goto L121;
        com.larus.bmhome.actionbar.model.z0 r33 = (com.larus.bmhome.actionbar.model.z0) ListProtector.get(r32, r27);
        if (r33 == null) goto L121;
        com.larus.bmhome.actionbar.model.r r118 = r33.q;
        if (r118 == null) goto L105;
        Integer r119 = r118.a;
        if (r119 == null) goto L105;
        int r210 = r27;
        if (r119.intValue() != 18) goto L106;
        boolean r34 = true;
    L107:
        com.larus.bmhome.actionbar.model.r r35 = r33.q;
        if (r35 == null) goto L115;
        Integer r36 = r35.a;
        if (r36 == null) goto L115;
        if (r36.intValue() != 4) goto L115;
        boolean r37 = true;
    L116:
        if (r37 == false) goto L120;
        if (r10 > 0) goto L119;
        if (r9 <= 0) goto L120;
    L119:
        r34 = true;
    L120:
        boolean r211 = r34;
    L123:
        if (r31.isEmpty() == false) goto L130;
        com.larus.bmhome.view.actionbar.edit.c.a.b(r30.i4(), false, false, false, r24, false, false, 0, 116);
        va8.o r38 = r30.X3();
        if (r38 == null) goto L127;
        r38.Y4(1.0f);
    L127:
        ICoreInputAbility r39 = r30.a4();
        if (r39 == null) goto L195;
        r39.iN(new r0(r30));
    L195:
        if (r210 < 0) goto L199;
        int r40 = r210;
        if (r40 >= r116) goto L200;
        boolean r41 = true;
    L201:
        if (r41 == false) goto L266;
        com.larus.bmhome.actionbar.model.r r42 = r30.i4().getCurrentInstructionConf();
        if (r42 == null) goto L266;
        com.larus.bmhome.actionbar.model.y r43 = r42.i;
        if (r43 == null) goto L266;
        ArrayList r44 = r43.a;
        if (r44 == null) goto L266;
        com.larus.bmhome.actionbar.model.z0 r45 = (com.larus.bmhome.actionbar.model.z0) ListProtector.get(r44, r40);
        if (r45 == null) goto L266;
        com.larus.bmhome.actionbar.model.r r46 = r45.q;
        if (r46 == null) goto L218;
        Integer r47 = r46.a;
        if (r47 == null) goto L218;
        if (r47.intValue() != 18) goto L218;
        boolean r48 = true;
    L219:
        if (r48 == false) goto L266;
        if (r30.Wm() == true) goto L266;
        if (r3 == 0) goto L244;
        List r49 = r3;
        if ((r49 instanceof Collection) == true) goto L226;
    L228:
        Iterator r50 = r49.iterator();
    L230:
        if (r50.hasNext() == false) goto L240;
        ResourceItemBean r51 = (ResourceItemBean) r50.next();
        if (r51.getResourceType() != ResourceType.IMAGE) goto L234;
    L237:
        boolean r52 = true;
    L238:
        if (r52 == false) goto L230;
        boolean r53 = true;
    L241:
        boolean r54 = true;
        if (r53 != true) goto L245;
        boolean r120 = true;
    L246:
        if (r120 == false) goto L266;
        if ((r31.isEmpty() ^ r54) == false) goto L266;
        if (r31.isEmpty() == false) goto L252;
        int r55 = 0;
    L264:
        if (r55 != 0) goto L266;
        r30.i4().selectRatio(18, IAIChatUgcAIGCService.a.R());
        goto L266
    L252:
        Iterator r56 = r31.entrySet().iterator();
        r55 = 0;
    L254:
        if (r56.hasNext() == false) goto L264;
        Map.Entry r57 = (Map.Entry) r56.next();
        if (((ry9.k) r57.getValue()).e == false) goto L258;
    L261:
        boolean r58 = true;
    L262:
        if (r58 == false) goto L254;
        r55 = r55 + 1;
        goto L254
    L258:
        if (Intrinsics.areEqual(((ry9.k) r57.getValue()).b, ry9.j.b.b) == true) goto L261;
        r58 = false;
    L245:
        r120 = false;
        goto L246
    L234:
        if (r51.getResourceType() == ResourceType.VIDEO) goto L237;
        r52 = false;
    L240:
        r53 = false;
        goto L241
    L226:
        if (r49.isEmpty() == false) goto L228;
    L244:
        r54 = true;
    L218:
        r48 = false;
    L266:
        com.larus.bmhome.view.actionbar.edit.c r59 = r30.i4();
        if ((!r31.isEmpty()) == false) goto L293;
        if (r3 == 0) goto L290;
        List r60 = r3;
        if ((r60 instanceof Collection) == true) goto L272;
    L274:
        Iterator r61 = r60.iterator();
    L276:
        if (r61.hasNext() == false) goto L286;
        ResourceItemBean r62 = (ResourceItemBean) r61.next();
        if (r62.getResourceType() != ResourceType.IMAGE) goto L280;
    L283:
        boolean r63 = true;
    L284:
        if (r63 == false) goto L276;
        boolean r64 = true;
        boolean r65 = true;
    L287:
        if (r65 != r64) goto L290;
        boolean r66 = true;
    L291:
        if (r66 == false) goto L293;
        boolean r67 = true;
    L294:
        r59.setOriginalRatioEnable(r67);
        r30.r6(r31);
        return;
    L280:
        if (r62.getResourceType() == ResourceType.VIDEO) goto L283;
        r63 = false;
    L286:
        r64 = true;
        r65 = false;
        goto L287
    L272:
        if (r60.isEmpty() == false) goto L274;
    L290:
        r66 = false;
    L293:
        r67 = false;
    L200:
        r41 = false;
        goto L201
    L199:
        r40 = r210;
        goto L200
    L130:
        if (r12 <= 0) goto L132;
        boolean r68 = true;
    L134:
        if (r30.R5(r68) == false) goto L141;
        va8.o r69 = r30.X3();
        if (r69 == null) goto L138;
        r69.Y4(0.3f);
    L138:
        ICoreInputAbility r70 = r30.a4();
        if (r70 == null) goto L195;
        r70.iN(new s0());
        goto L195
    L141:
        if (r6 <= 0) goto L152;
        com.larus.bmhome.view.actionbar.edit.c r212 = r30.i4();
        if (r14 <= 0) goto L145;
        boolean r213 = true;
    L146:
        com.larus.bmhome.view.actionbar.edit.c.a.b(r212, true, false, false, r24, false, r213, r11 - r14, 20);
        va8.o r71 = r30.X3();
        if (r71 == null) goto L149;
        r71.Y4(1.0f);
    L149:
        ICoreInputAbility r72 = r30.a4();
        if (r72 == null) goto L195;
        r72.iN(new t0(r30));
        goto L195
    L145:
        r213 = false;
        goto L146
    L152:
        if (r7 > 0) goto L189;
        if (r8 > 0) goto L189;
        if (r12 > 0) goto L179;
        if (r10 > 0) goto L179;
        if (r9 > 0) goto L179;
        if (r13 <= 0) goto L166;
        com.larus.bmhome.view.actionbar.edit.c.a.b(r30.i4(), true, true, false, r24, r211, false, 0, 100);
        va8.o r73 = r30.X3();
        if (r73 == null) goto L163;
        r73.Y4(1.0f);
    L163:
        ICoreInputAbility r74 = r30.a4();
        if (r74 == null) goto L195;
        r74.iN(new x0(r2, r1, r30));
        goto L195
    L166:
        if (r14 <= 0) goto L173;
        com.larus.bmhome.view.actionbar.edit.c.a.b(r30.i4(), true, true, false, r24, r211, true, r11 - r14, 4);
        va8.o r75 = r30.X3();
        if (r75 == null) goto L170;
        r75.Y4(1.0f);
    L170:
        ICoreInputAbility r76 = r30.a4();
        if (r76 == null) goto L195;
        r76.iN(new y0(r30));
        goto L195
    L173:
        com.larus.bmhome.view.actionbar.edit.c.a.b(r30.i4(), true, true, false, r24, r211, false, 0, 100);
        va8.o r77 = r30.X3();
        if (r77 == null) goto L176;
        r77.Y4(1.0f);
    L176:
        ICoreInputAbility r78 = r30.a4();
        if (r78 == null) goto L195;
        r78.iN(new z0(r30));
    L179:
        com.larus.bmhome.view.actionbar.edit.c r214 = r30.i4();
        if (r14 <= 0) goto L182;
        boolean r215 = true;
    L183:
        com.larus.bmhome.view.actionbar.edit.c.a.b(r214, true, false, false, r24, false, r215, r11 - r14, 4);
        va8.o r79 = r30.X3();
        if (r79 == null) goto L186;
        r79.Y4(1.0f);
    L186:
        ICoreInputAbility r80 = r30.a4();
        if (r80 == null) goto L195;
        r80.iN(new v0(r30));
        goto L195
    L182:
        r215 = false;
    L189:
        com.larus.bmhome.view.actionbar.edit.c.a.b(r30.i4(), true, false, true, r24, false, false, 0, 96);
        va8.o r81 = r30.X3();
        if (r81 == null) goto L192;
        r81.Y4(1.0f);
    L192:
        ICoreInputAbility r82 = r30.a4();
        if (r82 == null) goto L195;
        r82.iN(new u0(r30));
        goto L195
    L132:
        r68 = false;
    L115:
        r37 = false;
    L106:
        r34 = false;
    L105:
        r210 = r27;
    L121:
        r210 = r27;
        r211 = false;
    L87:
        r117 = false;
    L83:
        r116 = 0;
        goto L84
    L66:
        r25 = 3;
        goto L67
    }

    public static boolean s5(CreationReferenceAttachmentViolation r3, String r4) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r4 != null) goto L8;
    L13:
        FLogger.a.i("CreationEditorComponent", "reference switch rejected, violation=" + r3.name());
        return true;
    L8:
        if ((!StringsKt.isBlank(r4)) == true) goto L11;
        r4 = null;
    L11:
        if (r4 == null) goto L13;
        t19.s r1 = t19.s.a;
        Application r2 = AppHost.a.getApplication();
        r1.getClass();
        t19.s.t(r2, r4);
        u3.c("materials_exceed_model_limit", r4);
        goto L13
    }

    public final void GX(int r3, long r4) {
        this.Q1 = true;
        i4().selectModel(r3, r4);     // Catch: Throwable -> L6
        this.Q1 = false;
        return;
    L6:
        th = move-exception;
        this.Q1 = false;
        throw th;
    }

    public final void Gk(TemplateInfo$TemplateInfo r2, Uri r3) {
        i4().onInstructionImageTemplateSelected(r2, r3);
    }

    public final void I5(int r8, boolean r9) {
        com.larus.bmhome.actionbar.model.r r0 = this.s;
        if (r0 == null) goto L10;
        Integer r3 = r0.a;
        if (r3 == null) goto L10;
        if (r3.intValue() != 28) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L13;
        return;
    L13:
        com.larus.bmhome.actionbar.model.y r1 = r0.i;
        int r5 = -1;
        if (r1 == null) goto L35;
        ArrayList r2 = r1.a;
        if (r2 == null) goto L35;
        Iterator r6 = r2.iterator();
        int r7 = 0;
    L19:
        if (r6.hasNext() == false) goto L35;
        Object r10 = r6.next();
        int r11 = r7 + 1;
        if (r7 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        com.larus.bmhome.actionbar.model.r r12 = ((com.larus.bmhome.actionbar.model.z0) r10).q;
        if (r12 == null) goto L31;
        Integer r13 = r12.a;
        if (r13 == null) goto L31;
        if (r13.intValue() != r8) goto L31;
        boolean r14 = true;
    L32:
        if (r14 == false) goto L34;
        r5 = r7;
    L34:
        r7 = r11;
    L31:
        r14 = false;
    L35:
        if (r5 >= 0) goto L37;
    L39:
        boolean r15 = false;
    L40:
        if (r15 == false) goto L70;
        hq8.a r16 = this.p1;
        if (r16 != null) goto L44;
        return;
    L44:
        if (this.I == false) goto L54;
        if (r9 == false) goto L47;
        ((TabLayout.Tab) ListProtector.get(this.H, r5)).select();
        return;
    L47:
        this.P1 = true;
        this.H.get(r5).select();     // Catch: Throwable -> L51
        this.P1 = false;
        return;
    L51:
        th = move-exception;
        this.P1 = false;
        throw th;
    L54:
        int r17 = ((Number) i4().getInstructionSelectMenuPosition().getValue()).intValue();
        if (r9 == true) goto L57;
    L59:
        ((TabLayout.Tab) ListProtector.get(this.H, r5)).select();
        uz9.a r18 = this.r;
        if (r18 == null) goto L62;
        r18.q(r5);
    L62:
        w5(r5, r16, false);
        i4().selectInstructionMenu(r5);
        return;
    L57:
        if (U5(r17, r5) == false) goto L59;
        return;
    L70:
        return;
    L37:
        if (r5 >= this.H.size()) goto L39;
        r15 = true;
    L10:
        r4 = false;
        goto L11
    }

    public final void Q3(com.larus.bmhome.actionbar.model.y r19, hq8.a r20) {
        com.larus.bmhome.actionbar.model.r r0 = this.s;
        if (r0 == null) goto L34;
        com.larus.bmhome.actionbar.model.y r1 = r0.i;
        if (r1 == null) goto L34;
        ArrayList r2 = r1.a;
        if (r2 == null) goto L34;
        Iterator r3 = r2.iterator();
        com.larus.bmhome.actionbar.model.u r7 = null;
        boolean r8 = true;
    L10:
        if (r3.hasNext() == false) goto L35;
        com.larus.bmhome.actionbar.model.r r9 = ((com.larus.bmhome.actionbar.model.z0) r3.next()).q;
        if (r9 == null) goto L29;
        List r10 = r9.b;
        if (r10 == null) goto L29;
        Iterator r11 = r10.iterator();
    L17:
        if (r11.hasNext() == false) goto L27;
        Object r12 = r11.next();
        Integer r13 = ((com.larus.bmhome.actionbar.model.u) r12).b;
        if (r13 != null) goto L22;
    L24:
        boolean r14 = false;
    L25:
        if (r14 == false) goto L17;
    L28:
        com.larus.bmhome.actionbar.model.u r15 = (com.larus.bmhome.actionbar.model.u) r12;
    L30:
        if (r15 == null) goto L31;
        if (r7 != null) goto L10;
        r7 = r15;
        goto L10
    L31:
        r8 = false;
        goto L10
    L22:
        if (r13.intValue() != 15) goto L24;
        r14 = true;
        goto L25
    L27:
        r12 = null;
    L29:
        r15 = null;
    L35:
        if (r8 == false) goto L196;
        if (r7 == null) goto L196;
        ArrayList r4 = r19.a;
        if (r4 == null) goto L48;
        Iterator r5 = r4.iterator();
        int r16 = 0;
    L42:
        if (r5.hasNext() == false) goto L49;
        Integer r17 = z5((com.larus.bmhome.actionbar.model.z0) r5.next());
        if (r17 == null) goto L42;
        int r18 = r17.intValue();
        if (r18 <= r16) goto L42;
        r16 = r18;
    L49:
        r20.e.removeAllViews();
        uz9.a r21 = this.r;
        if (r21 == null) goto L154;
        Context r110 = getContext();
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r111 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        Intrinsics.checkNotNullParameter(this, "<this>");
        LifecycleCoroutineScope r112 = LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        e r113 = (e) this.X.getValue();
        com.larus.bmhome.actionbar.model.r r6 = i4().getInstructionRebuildStateConf();
        if (r6 == null) goto L62;
        com.larus.bmhome.actionbar.model.y r22 = r6.i;
        if (r22 == null) goto L62;
        ArrayList r23 = r22.a;
        if (r23 == null) goto L62;
        com.larus.bmhome.actionbar.model.z0 r24 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.firstOrNull(r23);
        if (r24 == null) goto L62;
        com.larus.bmhome.actionbar.model.r r25 = r24.q;
        if (r25 == null) goto L62;
        Integer r114 = r25.a;
    L63:
        com.larus.bmhome.view.actionbar.edit.c r115 = i4();
        com.larus.bmhome.view.actionbar.edit.d r26 = new com.larus.bmhome.view.actionbar.edit.d(i4().getInstructionDefaultParams());
        ny9.s r27 = W3();
        if (r27 == null) goto L70;
        Bundle r28 = r27.a;
        if (r28 == null) goto L69;
        ArrayList<ResourceExt> r29 = r28.getParcelableArrayList("ref_image_url_list");
        if (r29 == null) goto L69;
    L71:
        ArrayList<ResourceExt> r30 = r29;
        ny9.s r31 = W3();
        if (r31 == null) goto L78;
        Bundle r32 = r31.a;
        if (r32 == null) goto L77;
        ArrayList<String> r33 = r32.getStringArrayList("avatar_image_url_list");
        if (r33 == null) goto L77;
    L79:
        ArrayList<String> r34 = r33;
        ny9.s r35 = W3();
        if (r35 == null) goto L86;
        Bundle r36 = r35.a;
        if (r36 == null) goto L85;
        ArrayList<Integer> r37 = r36.getIntegerArrayList("white_tee_index_list");
        if (r37 == null) goto L85;
    L87:
        ArrayList<Integer> r38 = r37;
        ny9.s r39 = W3();
        if (r39 == null) goto L125;
        ArrayList r40 = new ArrayList();
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L122
        Bundle r41 = r39.a;     // Catch: Throwable -> L122
        if (r41 == null) goto L96;
        Fragment r117 = r111;
        ArrayList<String> r42 = r41.getStringArrayList("ref_image_album_path_list");     // Catch: Throwable -> L94
    L97:
        if (r42 == null) goto L102;
        com.larus.bmhome.view.actionbar.edit.d r118 = r26;
        if ((!r42.isEmpty()) != true) goto L103;
        boolean r43 = true;
    L198:
        if (r43 == false) goto L112;
        Iterator<T> r44 = r42.iterator();     // Catch: Throwable -> L120
    L107:
        if (r44.hasNext() == false) goto L111;
        String r45 = (String) r44.next();     // Catch: Throwable -> L120
        if (r45 == null) goto L107;
        r40.add(UriProtector.parse(r45));     // Catch: Throwable -> L120
        goto L107
    L111:
        Unit r46 = Unit.INSTANCE;     // Catch: Throwable -> L120
    L118:
        Result.constructor-impl(r46);     // Catch: Throwable -> L120
    L126:
        ny9.s r47 = W3();
        if (r47 == null) goto L131;
        Bundle r48 = r47.a;
        if (r48 == null) goto L131;
        boolean r49 = r48.getBoolean("is_private_image", false);
    L132:
        Intrinsics.checkNotNullParameter(r110, "context");
        Intrinsics.checkNotNullParameter(r30, "passedResourceList");
        Intrinsics.checkNotNullParameter(r34, "passedAvatarImageUrlList");
        Intrinsics.checkNotNullParameter(r38, "passedWhiteTeeIndexList");
        Intrinsics.checkNotNullParameter(r40, "passedImageAlbumPaths");
        if (r21.d == true) goto L135;
        com.larus.uaigc.instruction.y r119 = new com.larus.uaigc.instruction.y();
        ((up8.b) r119).d = r112;
        ((up8.b) r119).e = r113;
        ((up8.b) r119).g = r114;
        r119.n = r16;
        r119.la(r30);
        Intrinsics.checkNotNullParameter(r34, "avatarImageUrlList");
        r119.q.clear();
        r119.q.addAll(r34);
        Intrinsics.checkNotNullParameter(r38, "whiteTeeIndexList");
        r119.r.clear();
        r119.r.addAll(r38);
        r119.t = r49;
        Intrinsics.checkNotNullParameter(r40, "imageAlbumPaths");
        r119.s.clear();
        r119.s.addAll(r40);
        up8.d.a.a(r119, r7, r115, r118);
        r21.c = r119;
        r21.d = true;
    L138:
        com.larus.uaigc.instruction.y r50 = r21.c;
        if (r50 == null) goto L144;
        Intrinsics.checkNotNullParameter(r110, "context");
        AbsInstructionWidget r51 = r50.m;
        if (r51 != null) goto L145;
        r51 = r50.d(r110, r117);
    L145:
        if (r51 == null) goto L153;
        ViewParent r52 = r51.getParent();
        if ((r52 instanceof ViewGroup) == false) goto L149;
        ViewGroup r53 = (ViewGroup) r52;
    L150:
        if (r53 == null) goto L152;
        r53.removeView(r51);
    L152:
        hq8.a r54 = r20;
        r54.e.addView(r51);
    L155:
        ry9.h r55 = l4();
        if (r55 == null) goto L159;
        r55.Lp(r16);
    L159:
        if (((KmpInstructionCoreOptConfig) h38.b.a.getValue()).getEnable() == false) goto L189;
        ArrayList r56 = r19.a;
        if (r56 != null) goto L163;
    L165:
        boolean r57 = false;
    L166:
        if (r57 == false) goto L189;
        ArrayList r58 = r19.a;
        if (r58 != null) goto L170;
    L186:
        boolean r59 = false;
    L187:
        if (r59 == false) goto L189;
        boolean r60 = true;
    L190:
        FLogger.a.i("CreationEditorComponent", "fillAttachmentAreaInstruction, kmpTakeover: " + r60);
        FrameLayout r61 = r54.e;
        if ((!r60) == false) goto L193;
        int r62 = 0;
    L194:
        r61.setVisibility(r62);
        return;
    L193:
        r62 = 8;
        goto L194
    L170:
        if (r58.isEmpty() == true) goto L182;
        Iterator r63 = r58.iterator();
    L174:
        if (r63.hasNext() == false) goto L182;
        com.larus.bmhome.actionbar.model.z0 r64 = (com.larus.bmhome.actionbar.model.z0) r63.next();
        Lazy r65 = h38.b.a;
        com.larus.bmhome.actionbar.model.r r66 = r64.q;
        if (r66 == null) goto L178;
        Integer r67 = r66.a;
    L180:
        if (h38.b.a(r67) == true) goto L174;
        boolean r68 = false;
    L184:
        if (r68 != true) goto L186;
        r59 = true;
        goto L187
    L178:
        r67 = null;
    L182:
        r68 = true;
        goto L184
    L163:
        if ((!r56.isEmpty()) != true) goto L165;
        r57 = true;
    L189:
        r60 = false;
        goto L190
    L149:
        r53 = null;
        goto L150
    L153:
        r54 = r20;
        goto L155
    L144:
        r51 = null;
        goto L145
    L135:
        com.larus.bmhome.view.actionbar.edit.d r69 = r118;
        com.larus.uaigc.instruction.y r70 = r21.c;
        if (r70 == null) goto L138;
        ((up8.b) r70).g = r114;
        r70.n = r16;
        up8.d.a.a(r70, r7, r115, r69);
    L131:
        r49 = false;
        goto L132
    L112:
        Bundle r71 = r39.a;     // Catch: Throwable -> L120
        if (r71 == null) goto L117;
        String r72 = r71.getString("ref_image_album_path");     // Catch: Throwable -> L120
        if (r72 == null) goto L117;
        r46 = Boolean.valueOf(r40.add(UriProtector.parse(r72)));     // Catch: Throwable -> L120
    L117:
        r46 = null;
    L120:
        th = th;
    L124:
        Result.Companion r73 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L103:
        r43 = false;
        goto L198
    L102:
        r118 = r26;
    L94:
        th = th;
        r118 = r26;
        goto L124
    L96:
        r117 = r111;
        r42 = null;
    L122:
        th = th;
        r118 = r26;
        r117 = r111;
        goto L124
    L125:
        r118 = r26;
        r117 = r111;
        r40 = new ArrayList();
    L85:
        r37 = new ArrayList();
        goto L87
    L86:
        r37 = new ArrayList();
    L77:
        r33 = new ArrayList();
        goto L79
    L78:
        r33 = new ArrayList();
    L69:
        r29 = new ArrayList();
        goto L71
    L70:
        r29 = new ArrayList();
    L62:
        r114 = null;
        goto L63
    L154:
        r54 = r20;
        goto L155
    L48:
        r16 = 0;
    L196:
        r20.e.removeAllViews();
        return;
    L34:
        r7 = null;
        r8 = true;
        goto L35
    }

    public final boolean U5(int r11, int r12) {
        if (this.P1 == true) goto L187;
        if (r11 == r12) goto L187;
        com.larus.bmhome.actionbar.model.r r0 = this.s;
        if (r0 == null) goto L187;
        com.larus.bmhome.actionbar.model.y r1 = r0.i;
        if (r1 == null) goto L187;
        ArrayList r2 = r1.a;
        if (r2 == null) goto L187;
        com.larus.bmhome.actionbar.model.z0 r13 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.getOrNull(r2, r11);
        Double r3 = null;
        String r4 = null;
        if (r13 == null) goto L18;
        com.larus.bmhome.actionbar.model.r r14 = r13.q;
        if (r14 == null) goto L18;
        Integer r15 = r14.a;
    L19:
        com.larus.bmhome.actionbar.model.z0 r5 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.getOrNull(r2, r12);
        if (r5 != null) goto L22;
        return false;
    L22:
        com.larus.bmhome.actionbar.model.r r6 = r5.q;
        if (r6 == null) goto L25;
        Integer r7 = r6.a;
    L27:
        if (r15 != null) goto L30;
    L137:
        if (r7 != null) goto L140;
    L141:
        return false;
    L140:
        if (r7.intValue() != 18) goto L141;
        Long r16 = i4().getSelectedVideoModelId();
        if (r16 == null) goto L151;
        long r8 = r16.longValue();
        com.larus.bmhome.actionbar.model.r r17 = this.s;
        if (r17 == null) goto L149;
        com.larus.bmhome.actionbar.model.y r18 = r17.i;
        if (r18 == null) goto L149;
        com.larus.bmhome.actionbar.model.w0 r19 = r18.a(r8);
    L150:
        if (r19 == null) goto L151;
    L153:
        if (Intrinsics.areEqual(r19, com.larus.bmhome.actionbar.model.w0.b.a) == false) goto L156;
        return false;
    L156:
        if ((r19 instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L186;
        wa8.d1 r110 = ((com.larus.bmhome.actionbar.model.w0.a) r19).a;
        uz9.a r9 = this.r;
        if (r9 == null) goto L184;
        ry9.d r10 = r9.n();
        if (dk(r12) == false) goto L171;
        if (((Boolean) i4().getChosenAvatarInstructionStatus().getValue()).booleanValue() == false) goto L171;
        int r111 = Math.max(r10.b, 1);
        Double r20 = r10.c;
        if (r20 != null) goto L168;
        DigitalAvatarInfoManager.a.getClass();
        ey9.a r21 = DigitalAvatarInfoManager.f();
        if (r21 == null) goto L169;
        r3 = Double.valueOf(r21.c());
    L169:
        r10 = ry9.d.a(r10, r111, r3);
        goto L171
    L168:
        r3 = r20;
    L171:
        if (r10.a.isEmpty() == true) goto L173;
    L175:
        CreationReferenceAttachmentViolation r112 = ry9.e.b(r110, r10);
        if (r112 != CreationReferenceAttachmentViolation.METADATA_UNAVAILABLE) goto L179;
        r112 = ry9.e.c(r110, r10);
    L179:
        if (r7.intValue() != 18) goto L181;
        i4().getSelectedVideoModelId();
    L182:
        f5(this, "tab_switch", "creation_tab", r10, r112);
        return s5(r112, r110.a);
    L181:
        r7.intValue();
        goto L182
    L173:
        if (r10.b != 0) goto L175;
        return false;
    L184:
        return false;
    L186:
        throw new NoWhenBranchMatchedException();
    L149:
        r19 = null;
    L151:
        r19 = com.larus.bmhome.actionbar.model.w0.b.a;
        goto L153
    L30:
        if (r15.intValue() != 18) goto L137;
        if (r7 == null) goto L137;
        if (r7.intValue() != 4) goto L137;
        uz9.a r113 = this.r;
        if (r113 == null) goto L210;
        ry9.d r114 = r113.n();
        if (r114.a.isEmpty() == true) goto L211;
        Integer r115 = z5(r5);
        if (r115 != null) goto L43;
        Pair r22 = TuplesKt.to(CreationReferenceAttachmentViolation.UNSUPPORTED_TYPE, "IMAGE_TAB_CONFIG_UNAVAILABLE");
    L114:
        CreationReferenceAttachmentViolation r23 = (CreationReferenceAttachmentViolation) r22.component1();
        d5("tab_switch", "creation_tab", r114, r23, (String) r22.component2());
        if (r23 == null) goto L212;
        if (r115 == null) goto L120;
        int r116 = mz9.a.a;
        int r117 = r115.intValue();
        String r118 = AppHost.a.getApplication().getResources().getQuantityString(2131755117, r117, new Object[]{Integer.valueOf(r117)});
        if (r118 == null) goto L120;
    L129:
        if (r118 != null) goto L131;
    L135:
        FLogger.a.i("CreationEditorComponent", "image Tab switch rejected, violation=" + r23.name());
        return true;
    L131:
        if ((!StringsKt.isBlank(r118)) == false) goto L133;
        r4 = r118;
    L133:
        if (r4 == null) goto L135;
        t19.s r119 = t19.s.a;
        Application r120 = AppHost.a.getApplication();
        r119.getClass();
        t19.s.t(r120, r4);
        u3.c("materials_exceed_model_limit", r4);
    L120:
        com.larus.bmhome.actionbar.model.w0.a r121 = yn();
        if ((r121 instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L123;
        com.larus.bmhome.actionbar.model.w0.a r122 = r121;
    L124:
        if (r122 == null) goto L128;
        wa8.d1 r123 = r122.a;
        if (r123 == null) goto L128;
        r118 = r123.a;
    L128:
        r118 = null;
        goto L129
    L123:
        r122 = null;
        goto L124
    L212:
        return false;
    L43:
        List<ry9.c> r24 = r114.a;
        if ((r24 instanceof Collection) == true) goto L46;
    L48:
        Iterator<T> r25 = r24.iterator();
    L50:
        if (r25.hasNext() == false) goto L57;
        if (((ry9.c) r25.next()).getType() != CreationReferenceAttachmentType.VIDEO) goto L54;
        boolean r26 = true;
    L55:
        if (r26 == false) goto L50;
        boolean r27 = true;
    L58:
        if (r27 == false) goto L60;
        r22 = TuplesKt.to(CreationReferenceAttachmentViolation.UNSUPPORTED_TYPE, "IMAGE_TAB_VIDEO");
        goto L114
    L60:
        List<ry9.c> r28 = r114.a;
        if ((r28 instanceof Collection) == true) goto L63;
    L65:
        Iterator<T> r29 = r28.iterator();
    L67:
        if (r29.hasNext() == false) goto L74;
        if (((ry9.c) r29.next()).getType() != CreationReferenceAttachmentType.AUDIO) goto L71;
        boolean r30 = true;
    L72:
        if (r30 == false) goto L67;
        boolean r31 = true;
    L75:
        if (r31 == false) goto L77;
        r22 = TuplesKt.to(CreationReferenceAttachmentViolation.UNSUPPORTED_TYPE, "IMAGE_TAB_AUDIO");
        goto L114
    L77:
        List<ry9.c> r32 = r114.a;
        if ((r32 instanceof Collection) == true) goto L80;
    L82:
        Iterator<T> r33 = r32.iterator();
    L84:
        if (r33.hasNext() == false) goto L91;
        if (((ry9.c) r33.next()).getType() != CreationReferenceAttachmentType.UNKNOWN) goto L88;
        boolean r34 = true;
    L89:
        if (r34 == false) goto L84;
        boolean r35 = true;
    L92:
        if (r35 == false) goto L94;
        r22 = TuplesKt.to(CreationReferenceAttachmentViolation.UNSUPPORTED_TYPE, "IMAGE_TAB_UNSUPPORTED_TYPE");
        goto L114
    L94:
        List<ry9.c> r36 = r114.a;
        if ((r36 instanceof Collection) == true) goto L97;
    L99:
        Iterator<T> r37 = r36.iterator();
        int r38 = 0;
    L101:
        if (r37.hasNext() == false) goto L111;
        if (((ry9.c) r37.next()).getType() != CreationReferenceAttachmentType.IMAGE) goto L105;
        boolean r39 = true;
    L106:
        if (r39 == false) goto L101;
        r38 = r38 + 1;
        if (r38 >= 0) goto L101;
        CollectionsKt.throwCountOverflow();
        goto L101
    L105:
        r39 = false;
    L111:
        if (r38 <= r115.intValue()) goto L113;
        r22 = TuplesKt.to(CreationReferenceAttachmentViolation.TYPE_COUNT, "IMAGE_TAB_IMAGE_COUNT");
        goto L114
    L113:
        r22 = TuplesKt.to(null, null);
        goto L114
    L97:
        if (r36.isEmpty() == false) goto L99;
        r38 = 0;
        goto L111
    L88:
        r34 = false;
    L91:
        r35 = false;
        goto L92
    L80:
        if (r32.isEmpty() == false) goto L82;
    L71:
        r30 = false;
    L74:
        r31 = false;
        goto L75
    L63:
        if (r28.isEmpty() == false) goto L65;
    L54:
        r26 = false;
    L57:
        r27 = false;
        goto L58
    L46:
        if (r24.isEmpty() == false) goto L48;
    L211:
        return false;
    L210:
        return false;
    L25:
        r7 = null;
    L18:
        r15 = null;
    L187:
        return false;
    }

    public final void V3(String r14, Bundle r15) {
        ICreationWorkflowService.a.Y().a();
        i4().setChosenMsgInstruction(this.g1);
        va8.o r0 = X3();
        if (r0 == null) goto L5;
        String r1 = r0.u7();
    L6:
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        String r5 = r1;
        String r6 = y60(r5, true);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new CreationEditorComponent$finishAndSendMessages$1(this, r14, r15, r5, r6, null), 2, null);
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    public final void pz(int r9, Intent r10) {
        boolean r0 = false;
        String r1 = null;
        ny9.i r2 = null;
        if (r10 == null) goto L29;
        if (r10.getBooleanExtra("arg_need_finish_page", false) == false) goto L29;
        ny9.s r11 = W3();
        if (r11 == null) goto L9;
        r0 = r11.j();
    L9:
        if (r0 == false) goto L11;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$handleActivityResult$1$1(r10, this, null), 3, null);
        return;
    L11:
        Context r12 = getContext();
        if ((r12 instanceof ny9.i) == false) goto L14;
        ny9.i r13 = (ny9.i) r12;
    L15:
        if (r13 != null) goto L19;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r14 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if ((r14 instanceof ny9.i) == false) goto L21;
        r2 = (ny9.i) r14;
    L21:
        if (r2 == null) goto L23;
        r2.Dc(-1, r10);
    L24:
        py9.a r15 = c4();
        if (r15 == null) goto L72;
        r15.Oe();
        return;
    L72:
        return;
    L23:
        s1a.a.getActivity(this).setResult(-1, r10);
        goto L24
    L19:
        r2 = r13;
        goto L21
    L14:
        r13 = null;
    L29:
        if (r9 != 366) goto L31;
        if (r10 == null) goto L78;
        Bundle r16 = r10.getExtras();
        if (r16 == null) goto L79;
        V3(null, r16);
        return;
    L79:
        return;
    L78:
        return;
    L31:
        if (r9 != 367) goto L33;
        if (r10 == null) goto L50;
        String r17 = r10.getStringExtra("ipa_main_url");
    L51:
        FLogger.a.i("CreationEditorComponent", "handleReGenDigitalAvatarResult, ipaMainUrl = " + r17);
        if (r17 == null) goto L75;
        ry9.h r18 = l4();
        if (r18 == null) goto L60;
        String r19 = r18.yC();
        if (r19 == null) goto L60;
        ry9.h r3 = l4();
        if (r3 == null) goto L60;
        r3.lu(r19);
    L60:
        ry9.h r110 = l4();
        if (r110 == null) goto L63;
        r110.JZ(r17);
    L63:
        i4().setChosenAvatarInstructionStatus(true);
        wr(false);
        ICoreInputAbility r20 = a4();
        if (r20 == null) goto L76;
        ICoreInputAbility.b.e(r20, "reGenDigitalReplica", null, false, 6);
        return;
    L76:
        return;
    L75:
        return;
    L50:
        r17 = null;
        goto L51
    L33:
        if (r9 != 370) goto L35;
        mI(r10);
        return;
    L35:
        if (r9 != 372) goto L80;
        ICreationNotifyService.Companion r4 = ICreationNotifyService.a;
        r4.y();
        if (r10 == null) goto L42;
        Bundle r21 = r10.getExtras();
        if (r21 == null) goto L42;
        CreationDoSameNotifyInfo r5 = (CreationDoSameNotifyInfo) r21.getParcelable("creation_dosame_notify_info");
    L43:
        FragmentActivity r6 = s1a.a.getActivity(this);
        FragmentActivity r7 = s1a.a.getActivity(this);
        ny9.u r22 = d4();
        if (r22 == null) goto L46;
        r1 = r22.getEnterMethod();
    L46:
        r4.K(r5, r6, r7, r1, new k1(this));
        return;
    L42:
        r5 = null;
        goto L43
    }

    public final void selectRatio(int r2, long r3) {
        i4().selectRatio(r2, r3);
    }

    public final void v4(String r13, Map<String, ry9.k> r14) {
        if (UriProtector.parse(r13).getBooleanQueryParameter("need_ref_image", false) == false) goto L52;
        String r2 = null;
        if (T4() == false) goto L40;
        ry9.k r0 = (ry9.k) CollectionsKt.singleOrNull(r14.values());
        if (r0 == null) goto L11;
        ry9.j r1 = r0.b;
        if (r1 == null) goto L11;
        ry9.i r3 = r1.a();
    L13:
        if ((r3 instanceof ry9.i.a) == false) goto L15;
        ry9.i.a r5 = (ry9.i.a) r3;
    L17:
        if ((!r14.isEmpty()) == false) goto L35;
        if (r5 != null) goto L35;
        com.larus.bmhome.actionbar.model.w0.a r15 = yn();
        if ((r15 instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L22;
        com.larus.bmhome.actionbar.model.w0.a r16 = r15;
    L23:
        if (r16 == null) goto L54;
        wa8.d1 r17 = r16.a;
        if (r17 == null) goto L55;
        String r18 = r17.a;
        if (r18 != null) goto L29;
        return;
    L29:
        if ((!StringsKt.isBlank(r18)) == false) goto L31;
        r2 = r18;
    L31:
        if (r2 == null) goto L57;
        t19.s r19 = t19.s.a;
        Application r110 = AppHost.a.getApplication();
        r19.getClass();
        t19.s.t(r110, r2);
        return;
    L57:
        return;
    L55:
        return;
    L54:
        return;
    L22:
        r16 = null;
    L35:
        if (r14.size() != 1) goto L38;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$handleMsgInstructionRedirectSchema$3(r14, r5, this, r13, null), 3, null);
    L38:
        if (r14.isEmpty() == false) goto L58;
        q5(true);
        return;
    L58:
        return;
    L15:
        r5 = null;
    L11:
        r3 = null;
        goto L13
    L40:
        ry9.g r111 = k4();
        if (r111 == null) goto L45;
        kotlinx.coroutines.flow.i1<ry9.j> r112 = r111.D20();
        if (r112 == null) goto L45;
        ry9.j r113 = (ry9.j) r112.getValue();
    L47:
        if ((r113 instanceof ry9.j.c) == false) goto L50;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationEditorComponent$handleMsgInstructionRedirectSchema$4(this, r13, null), 3, null);
        return;
    L50:
        if ((r113 instanceof ry9.j.b) == false) goto L61;
        q5(true);
        return;
    L61:
        return;
    L45:
        r113 = null;
        goto L47
    L52:
        final com.bytedance.router.i r114 = SmartRouter.buildRoute(getContext(), r13);
        r114.c.putExtra("enable_compact_fragment_forseti", T5());
        r114.d = 2130772343;
        r114.e = 2130772399;
        o5(new a0(r114), 2130772343, 2130772399, new l0(r114));
    }

    public final String y60(String r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r21, "userInput");
        qy9.a r2 = e4();
        String r4 = null;
        Object r5 = null;
        if (r2 == null) goto L5;
        String r3 = r2.Kw();
    L6:
        boolean r6 = true;
        if (r3 != null) goto L9;
    L12:
        boolean r7 = true;
    L13:
        if (r7 == true) goto L15;
        qy9.a r8 = e4();
        if (r8 == null) goto L21;
        String r9 = r8.Kw();
    L22:
        com.larus.bmhome.instruction.j r10 = IAIChatUgcAIGCService.a.e0();
        Integer r11 = i4().getInstructionType();
        if (r9 != null) goto L25;
        r9 = "";
    L25:
        com.larus.bmhome.actionbar.model.r r14 = r10.e(r11, x5(r9), this.r, i4().getCurrentInstructionConf(), ((Number) i4().getInstructionSelectMenuPosition().getValue()).intValue());
        if (r14 != null) goto L99;
    L98:
        return r4;
    L99:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L87
        qy9.a r13 = e4();     // Catch: Throwable -> L87
        if (r13 == null) goto L30;
        List<com.larus.bmhome.actionbar.model.u> r15 = r13.di();     // Catch: Throwable -> L87
    L31:
        List<com.larus.bmhome.actionbar.model.u> r16 = r15;     // Catch: Throwable -> L87
        if (r16 != null) goto L34;
    L37:
        boolean r17 = true;
    L38:
        if (r17 == false) goto L50;
        List r18 = r14.b;     // Catch: Throwable -> L87
        if (r18 != null) goto L42;
        r18 = CollectionsKt.emptyList();     // Catch: Throwable -> L87
    L42:
        List r19 = r18;     // Catch: Throwable -> L87
        ry9.g r20 = k4();     // Catch: Throwable -> L87
        if (r20 == null) goto L45;
        List<com.larus.bmhome.actionbar.model.u> r0 = r20.th(r22);     // Catch: Throwable -> L87
    L46:
        if (r0 != null) goto L48;
        r0 = CollectionsKt.emptyList();     // Catch: Throwable -> L87
    L48:
        List r1 = CollectionsKt.plus(r19, r0);     // Catch: Throwable -> L87
    L85:
        Object r23 = Result.constructor-impl(xt7.d.b.a(com.larus.bmhome.actionbar.model.r.Companion.serializer(), IAIChatUgcAIGCService.a.e0().c(x5(r21), com.larus.bmhome.actionbar.model.r.a(r14, r1, null, null, null, 4093), i4(), this.r, i4().getChosenMsgInstruction(), i4().getChosenImgInspirePrompt())));     // Catch: Throwable -> L87
    L90:
        if (Result.isFailure-impl(r23) == true) goto L93;
        r5 = r23;
    L93:
        r4 = (String) r5;
        FLogger r24 = FLogger.a;
        StringBuilder r25 = new StringBuilder("getActionBarInstructionParam encodeSuccess=");
        if (r4 != null) goto L97;
        r6 = false;
    L97:
        r25.append(r6);
        r24.i("CreationEditorComponent", r25.toString());
        goto L98
    L45:
        r0 = null;
        goto L46
    L50:
        List r26 = r14.b;     // Catch: Throwable -> L87
        if (r26 != null) goto L53;
        r26 = CollectionsKt.emptyList();     // Catch: Throwable -> L87
    L53:
        List r27 = r26;     // Catch: Throwable -> L87
        ry9.g r28 = k4();     // Catch: Throwable -> L87
        if (r28 == null) goto L56;
        List<com.larus.bmhome.actionbar.model.u> r29 = r28.th(r22);     // Catch: Throwable -> L87
    L57:
        if (r29 != null) goto L59;
        r29 = CollectionsKt.emptyList();     // Catch: Throwable -> L87
    L59:
        r1 = CollectionsKt.plus(r27, r29);     // Catch: Throwable -> L87
        qy9.a r30 = e4();     // Catch: Throwable -> L87
        if (r30 == null) goto L62;
        List<Integer> r31 = r30.OJ();     // Catch: Throwable -> L87
    L63:
        List<Integer> r32 = r31;     // Catch: Throwable -> L87
        if (r32 != null) goto L66;
    L69:
        boolean r33 = true;
    L70:
        if (r33 == true) goto L85;
        ArrayList r34 = new ArrayList();     // Catch: Throwable -> L87
        Iterator r35 = r1.iterator();     // Catch: Throwable -> L87
    L74:
        if (r35.hasNext() == false) goto L78;
        Object r36 = r35.next();     // Catch: Throwable -> L87
        if (CollectionsKt.contains(r31, ((com.larus.bmhome.actionbar.model.u) r36).b) == false) goto L74;
        r34.add(r36);     // Catch: Throwable -> L87
        goto L74
    L78:
        qy9.a r37 = e4();     // Catch: Throwable -> L87
        if (r37 == null) goto L81;
        List<com.larus.bmhome.actionbar.model.u> r38 = r37.di();     // Catch: Throwable -> L87
    L82:
        if (r38 != null) goto L84;
        r38 = CollectionsKt.emptyList();     // Catch: Throwable -> L87
    L84:
        r1 = CollectionsKt.plus(r34, r38);     // Catch: Throwable -> L87
        goto L85
    L81:
        r38 = null;
        goto L82
    L66:
        if (r32.isEmpty() == true) goto L69;
        r33 = false;
        goto L70
    L62:
        r31 = null;
        goto L63
    L56:
        r29 = null;
        goto L57
    L34:
        if (r16.isEmpty() == true) goto L37;
        r17 = false;
        goto L38
    L30:
        r15 = null;
    L87:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L90
    L21:
        r9 = null;
        goto L22
    L15:
        if (i4().getChosenMsgInstruction() != null) goto L17;
        r9 = r21;
        goto L22
    L17:
        r9 = y6(r21);
        goto L22
    L9:
        if (r3.length() == 0) goto L12;
        r7 = false;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    public final void F4(com.larus.bmhome.actionbar.model.p1 r2, boolean r3, Map<String, ry9.k> r4) {
        this.g1 = r2;
        i4().setChosenMsgInstruction(r2);
        if (com.larus.utils.o0.d(r2.g) == false) goto L8;
        String r5 = r2.g;
        if (r5 != null) goto L7;
        r5 = "";
    L7:
        v4(r5, r4);
        return;
    L8:
        if (r3 == true) goto L10;
        t19.s r6 = t19.s.a;
        Application r7 = AppHost.a.getApplication();
        String r8 = getContext().getString(2131910630);
        r6.getClass();
        t19.s.t(r7, r8);
        return;
    L10:
        this.Y = true;
        va8.o r9 = X3();
        if (r9 == null) goto L16;
        r9.Vc();
        return;
    }

    public final boolean m6(String r12, MediaAttachment r13, Uri r14) {
        int r0 = CreationHostUiPolicy.f;
        ny9.s r1 = W3();
        Map r2 = null;
        if (r1 == null) goto L5;
        Bundle r3 = r1.a;
    L7:
        if (CreationHostUiPolicy.a.a(r3).a == true) goto L153;
        return false;
    L153:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L11
        Object r5 = Result.constructor-impl(UriProtector.parse(r12));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r5) == false) goto L16;
        r5 = null;
    L16:
        Uri r6 = (Uri) r5;
        if (r6 != null) goto L20;
    L26:
        boolean r15 = false;
    L27:
        if (r15 == false) goto L152;
        if (r13 != null) goto L31;
        if (r14 == null) goto L152;
    L31:
        C3();
        ICoreInputAbility r16 = a4();
        if (r16 == null) goto L34;
        r16.qp(false);
    L34:
        Bundle r17 = new Bundle();
        if (r13 == null) goto L37;
        r17.putSerializable("media_attachment", r13);
        r17.putBoolean("ignore_image_size_check", true);
    L37:
        if (r14 == null) goto L39;
        r17.putString("input_image_uri", r14.toString());
    L39:
        ny9.s r18 = W3();
        if (r18 != null) goto L42;
    L44:
        boolean r19 = false;
    L45:
        r17.putBoolean("open_new_chat_page", r19);
        i4().setChosenMsgInstruction(this.g1);
        va8.o r110 = X3();
        if (r110 == null) goto L48;
        String r111 = r110.u7();
    L49:
        String r112 = "";
        if (r111 != null) goto L52;
        r111 = "";
    L52:
        com.larus.bmhome.actionbar.model.p1 r7 = this.g1;
        if (r7 == null) goto L55;
        String r8 = r7.c;
    L56:
        if (r8 != null) goto L58;
        r8 = "";
    L58:
        String r9 = y6(r8);
        String r10 = y60(r111, true);
        ny9.s r11 = W3();
        if (r11 != null) goto L61;
    L63:
        boolean r20 = false;
    L64:
        if (r20 == false) goto L76;
        String r113 = StringsKt.trim(r111).toString();
        ny9.s r21 = W3();
        if (r21 == null) goto L70;
        CustomInputInitData r22 = r21.g();
        if (r22 == null) goto L70;
        String r23 = r22.b();
    L71:
        if (r23 != null) goto L74;
        r23 = "";
    L74:
        if (Intrinsics.areEqual(r113, StringsKt.trim(r23).toString()) == false) goto L84;
    L85:
        boolean r24 = false;
    L86:
        ny9.s r114 = W3();
        if (r114 == null) goto L89;
        com.larus.bmhome.actionbar.model.z0 r115 = r114.f();
    L90:
        com.larus.bmhome.instruction.j r25 = IAIChatUgcAIGCService.a.e0();
        if (r115 == null) goto L93;
        String r26 = r115.b;
    L94:
        if (r26 != null) goto L96;
        String r27 = "";
    L98:
        if (r115 == null) goto L100;
        Long r116 = r115.a;
    L101:
        Map r117 = r25.b(r27, "16", r10, r24, null, r116);
        CreationSendMessageConfig.Companion.getClass();
        CreationSendMessageConfig.a r28 = new CreationSendMessageConfig.a();
        ny9.s r29 = W3();
        if (r29 == null) goto L107;
        ChatParam r30 = r29.c();
        if (r30 == null) goto L107;
        String r31 = r30.a;
        if (r31 == null) goto L107;
    L111:
        r28.l(r31);
        ny9.s r32 = W3();
        if (r32 == null) goto L117;
        ChatParam r33 = r32.c();
        if (r33 == null) goto L117;
        String r34 = r33.b;
        if (r34 == null) goto L117;
    L121:
        r28.f(r34);
        r28.i(r9);
        r28.s("edit");
        r28.u("edit");
        ny9.u r35 = d4();
        if (r35 == null) goto L124;
        String r36 = r35.getEnterMethod();
    L125:
        if (r36 == null) goto L128;
        r112 = r36;
    L128:
        r28.m(r112);
        ny9.u r118 = d4();
        if (r118 == null) goto L131;
        String r119 = r118.b();
    L132:
        r28.r(r119);
        r28.d(16);
        r28.c(r117);
        r28.n(d4());
        py9.a r120 = c4();
        if (r120 == null) goto L135;
        Map<String, String> r121 = r120.Jw(r9);
    L136:
        r28.q(r121);
        ny9.s r122 = W3();
        if (r122 == null) goto L141;
        ICoreInputAbility.SendMessageTrackExtMap r123 = r122.n();
        if (r123 == null) goto L141;
        r2 = r123.a;
    L141:
        r28.t(r2);
        ny9.s r124 = W3();
        if (r124 == null) goto L144;
        boolean r125 = r124.y();
    L145:
        r28.h(r125);
        r28.g((ChatPageContext) s1a.d.a(this).a(ChatPageContext.class));
        CreationSendMessageConfig r126 = r28.a;
        if (r126 == null) goto L148;
        r17.putSerializable("creation_send_message_config", r126);
    L148:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentManager r127 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getParentFragmentManager();
        Intrinsics.checkNotNullParameter(this, "<this>");
        r127.setFragmentResultListener("ai_creation_applet_image_remove_result", com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), new o0(this));
        boolean r128 = ICreationWorkflowService.a.e0(getContext(), r17, false);
        if (r128 == true) goto L151;
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.larus.ui.arch.component.internal.attach.a.b(this, this).getParentFragmentManager().clearFragmentResultListener("ai_creation_applet_image_remove_result");
    L151:
        return r128;
    L144:
        r125 = false;
        goto L145
    L135:
        r121 = null;
        goto L136
    L131:
        r119 = null;
        goto L132
    L124:
        r36 = null;
    L117:
        ny9.u r37 = d4();
        if (r37 == null) goto L120;
        r34 = r37.getBotId();
        goto L121
    L120:
        r34 = null;
    L107:
        ny9.u r38 = d4();
        if (r38 == null) goto L110;
        r31 = r38.Y1();
        goto L111
    L110:
        r31 = null;
        goto L111
    L100:
        r116 = null;
        goto L101
    L96:
        r27 = r26;
        goto L98
    L93:
        r26 = null;
        goto L94
    L89:
        r115 = null;
    L84:
        r24 = true;
    L70:
        r23 = null;
        goto L71
    L76:
        String r129 = StringsKt.trim(r111).toString();
        ny9.s r39 = W3();
        if (r39 == null) goto L79;
        String r40 = r39.q();
    L80:
        if (r40 != null) goto L83;
        r40 = "";
    L83:
        if (Intrinsics.areEqual(r129, StringsKt.trim(r40).toString()) == true) goto L85;
    L79:
        r40 = null;
        goto L80
    L61:
        if (r11.z() != true) goto L63;
        r20 = true;
        goto L64
    L55:
        r8 = null;
        goto L56
    L48:
        r111 = null;
        goto L49
    L42:
        if (r18.j() != true) goto L44;
        r19 = true;
    L152:
        return false;
    L20:
        if (Intrinsics.areEqual(r6.getHost(), "flow") == false) goto L24;
        if (Intrinsics.areEqual(r6.getPath(), "/image_edit/remove") == false) goto L24;
    L25:
        r15 = true;
    L24:
        if (StringsKt.contains$default(r12, "//flow/image_edit/remove", false, 2, null) == false) goto L26;
    L11:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L5:
        r3 = null;
        goto L7
    }

    public final void onDigitalAvatarTemplateChoose(ab8.a r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "templateInfo");
        Intrinsics.checkNotNullParameter("template_list", "enterFrom");
        i4().onDigitalAvatarTemplateChoose(r2, r3, "template_list");
    }

    public void w5(int r4, hq8.a r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "multiTabViewCollector");
        View r0 = this.J.get(Integer.valueOf(r4));
        if (r0 != null) goto L5;
        return;
    L5:
        ViewParent r1 = r0.getParent();
        FrameLayout r2 = r5.f;
        if (r1 == r2) goto L8;
        r2.removeAllViews();
        r5.f.addView(r0);
    L8:
        if (r6 == false) goto L13;
        String r7 = O3(r4);
        if (r7 == null) goto L14;
        Q5(r7);
        return;
    L14:
        return;
    }

    public final void o5(Function0 r4, Integer r5, Integer r6, Function0 r7) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        CreationHalfChatFragment r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        Object r2 = null;
        if ((r0 instanceof CreationHalfChatFragment) == false) goto L5;
        CreationHalfChatFragment r1 = r0;
    L6:
        if (r1 != null) goto L24;
    L22:
        r7.invoke();
        return;
    L24:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        Object r8 = Result.constructor-impl((Intent) r4.invoke());     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r8) == true) goto L15;
        r2 = r8;
    L15:
        Intent r9 = (Intent) r2;
        if (r9 == null) goto L22;
        r1.startActivityForResult(r9, 99);
        if (r5 == null) goto L26;
        if (r6 == null) goto L27;
        s1a.a.getActivity(this).overridePendingTransition(r5.intValue(), r6.intValue());
        return;
    L27:
        return;
    L26:
        return;
    L9:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public static void X5(CreationEditorComponent r2, List r3, final boolean r4, final boolean r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = false;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = false;
    L8:
        final RecyclerView r7 = r2.E;
        if (r7 == null) goto L29;
        final ListAdapter<com.larus.bmhome.actionbar.model.z0, BaseActionBarHolder> r0 = r2.A;
        if (r0 != null) goto L15;
        return;
    L15:
        if (r3.isEmpty() == false) goto L17;
        com.larus.utils.e1.o(r7);
        r0.submitList(CollectionsKt.emptyList());
        return;
    L17:
        com.larus.utils.e1.x(r7);
        com.larus.bmhome.chat.api.e0 r1 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r1 == null) goto L22;
        LaunchInfo r8 = r1.a;
        if (r8 == null) goto L22;
        String r9 = r8.W();
    L23:
        com.larus.bmhome.view.actionbar.custom.cache.k r10 = (com.larus.bmhome.view.actionbar.custom.cache.k) r2.q.getValue();
        if (r9 != null) goto L26;
        r9 = "";
    L26:
        r10.b(r3, r9);
        r0.submitList(CollectionsKt.toList(r3), new j1(r4, r7, r5, r0));
        return;
    L22:
        r9 = null;
        goto L23
    }

    public static void d5(String r24, String r25, ry9.d r26, CreationReferenceAttachmentViolation r27, String r28) {
        List<ry9.c> r1 = r26.a;
        if ((r1 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r2 = r1.iterator();
        int r3 = 0;
    L9:
        if (r2.hasNext() == false) goto L18;
        if (((ry9.c) r2.next()).getType() != CreationReferenceAttachmentType.IMAGE) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L9;
        r3 = r3 + 1;
        if (r3 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L13:
        r5 = false;
        goto L14
    L18:
        int r6 = r3;
    L19:
        List<ry9.c> r4 = r26.a;
        if ((r4 instanceof Collection) == true) goto L22;
    L24:
        Iterator<T> r7 = r4.iterator();
        int r8 = 0;
    L26:
        if (r7.hasNext() == false) goto L35;
        if (((ry9.c) r7.next()).getType() != CreationReferenceAttachmentType.VIDEO) goto L30;
        boolean r9 = true;
    L31:
        if (r9 == false) goto L26;
        r8 = r8 + 1;
        if (r8 >= 0) goto L26;
        CollectionsKt.throwCountOverflow();
        goto L26
    L30:
        r9 = false;
    L35:
        int r10 = r8 + r26.b;
        List<ry9.c> r11 = r26.a;
        if ((r11 instanceof Collection) == true) goto L38;
    L40:
        Iterator<T> r12 = r11.iterator();
        int r13 = 0;
    L42:
        if (r12.hasNext() == false) goto L51;
        if (((ry9.c) r12.next()).getType() != CreationReferenceAttachmentType.AUDIO) goto L46;
        boolean r14 = true;
    L47:
        if (r14 == false) goto L42;
        r13 = r13 + 1;
        if (r13 >= 0) goto L42;
        CollectionsKt.throwCountOverflow();
        goto L42
    L46:
        r14 = false;
        goto L47
    L51:
        int r15 = r13;
    L52:
        List<ry9.c> r16 = r26.a;
        if ((r16 instanceof Collection) == true) goto L55;
    L57:
        Iterator<T> r17 = r16.iterator();
        int r18 = 0;
    L59:
        if (r17.hasNext() == false) goto L68;
        if (((ry9.c) r17.next()).getType() != CreationReferenceAttachmentType.UNKNOWN) goto L63;
        boolean r19 = true;
    L64:
        if (r19 == false) goto L59;
        r18 = r18 + 1;
        if (r18 >= 0) goto L59;
        CollectionsKt.throwCountOverflow();
        goto L59
    L63:
        r19 = false;
        goto L64
    L68:
        int r20 = r18;
    L69:
        List<ry9.c> r21 = r26.a;
        ArrayList r22 = new ArrayList();
        Iterator<T> r23 = r21.iterator();
    L71:
        if (r23.hasNext() == false) goto L78;
        Object r29 = r23.next();
        if (((ry9.c) r29).getType() != CreationReferenceAttachmentType.VIDEO) goto L75;
        boolean r110 = true;
    L76:
        if (r110 == false) goto L71;
        r22.add(r29);
        goto L71
    L75:
        r110 = false;
        goto L76
    L78:
        Iterator r30 = r22.iterator();
        double r111 = 0.0d;
    L80:
        if (r30.hasNext() == false) goto L86;
        Double r31 = ((ry9.c) r30.next()).j;
        if (r31 == null) goto L84;
        double r112 = r31.doubleValue();
    L85:
        r111 = r111 + r112;
        goto L80
    L84:
        r112 = 0.0d;
        goto L85
    L86:
        Double r32 = r26.c;
        if (r32 == null) goto L89;
        double r33 = r32.doubleValue();
    L90:
        double r34 = r33 + r111;
        List<ry9.c> r0 = r26.a;
        ArrayList r35 = new ArrayList();
        Iterator<T> r36 = r0.iterator();
    L92:
        if (r36.hasNext() == false) goto L99;
        Object r113 = r36.next();
        if (((ry9.c) r113).getType() != CreationReferenceAttachmentType.AUDIO) goto L96;
        boolean r114 = true;
    L97:
        if (r114 == false) goto L92;
        r35.add(r113);
        goto L92
    L96:
        r114 = false;
        goto L97
    L99:
        Iterator r37 = r35.iterator();
        double r115 = 0.0d;
    L101:
        if (r37.hasNext() == false) goto L107;
        Double r38 = ((ry9.c) r37.next()).j;
        if (r38 == null) goto L105;
        double r39 = r38.doubleValue();
    L106:
        r115 = r115 + r39;
        goto L101
    L105:
        r39 = 0.0d;
        goto L106
    L107:
        cq9.a r40 = new cq9.a(r6, r10, r15, r20, r34, r115, 64);
        if (r27 != null) goto L110;
        CreationMultiReferenceRuleResult r41 = CreationMultiReferenceRuleResult.PASS;
    L111:
        Set<String> r42 = cq9.b.a;
        CreationMultiReferenceLogEvent r116 = CreationMultiReferenceLogEvent.RULE_CHECKED;
        Boolean r43 = Boolean.TRUE;
        CreationMultiReferenceRuleResult r210 = r41;
        cq9.b.a(r116, r43, r24, r25, r40, null, r210, r28, 576);
        cq9.b.a(CreationMultiReferenceLogEvent.SWITCH_CHECKED, r43, r24, r25, r40, null, r210, r28, 576);
        return;
    L110:
        r41 = CreationMultiReferenceRuleResult.REJECT;
        goto L111
    L89:
        r33 = 0.0d;
        goto L90
    L55:
        if (r16.isEmpty() == false) goto L57;
        r20 = 0;
        goto L69
    L38:
        if (r11.isEmpty() == false) goto L40;
        r15 = 0;
        goto L52
    L22:
        if (r4.isEmpty() == false) goto L24;
        r8 = 0;
        goto L35
    L5:
        if (r1.isEmpty() == false) goto L7;
        r6 = 0;
        goto L19
    }

    public static /* synthetic */ void f5(CreationEditorComponent r1, String r2, String r3, ry9.d r4, CreationReferenceAttachmentViolation r5) {
        if (r5 == null) goto L4;
        String r0 = r5.name();
    L5:
        r1.getClass();
        d5(r2, r3, r4, r5, r0);
        return;
    L4:
        r0 = null;
        goto L5
    }
}
