package com.larus.canvas.feature.component.logic;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.chat.trace.ReeditType;
import com.larus.bmhome.resource.access.ResourceCancelReason;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.canvas.feature.CreationCanvasActivity;
import com.larus.canvas.feature.component.instruction.model.InstructionTabState;
import com.larus.canvas.feature.component.logic.bean.ImageSaveStatus;
import com.larus.canvas.feature.component.logic.helper.QuotaCtaResult;
import com.larus.canvas.feature.component.logic.loading.CanvasProgressState;
import com.larus.canvas.feature.component.logic.loading.CanvasProgressViewModel;
import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.canvas.service.bean.CanvasImageBlock;
import com.larus.canvas.service.bean.CanvasInfo;
import com.larus.canvas.service.bean.CanvasMsgInfo;
import com.larus.canvas.service.bean.ImageObject;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.MaskUri;
import com.larus.canvas.service.bean.OptionItem;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.commercemembership.api.ICommerceMembershipService$b;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.platform.api.d3;
import com.larus.platform.model.NotificationType;
import com.larus.platform.service.z2;
import com.larus.uaigc.api.ReviewUgcImageApi;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.uaigc.service.ICreationResourceAccessServiceKt;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import hq9.n3;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
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
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowImpl;
import tx9.y3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u008a\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0092\u00022\u00020\u00012\u00020\u0002:\u0002\u0092\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010|\u001a\u00020wH\u0016J\b\u0010}\u001a\u00020wH\u0016J\b\u0010~\u001a\u00020wH\u0016J\b\u0010\u007f\u001a\u00020wH\u0016J\t\u0010\u0080\u0001\u001a\u00020wH\u0016J\u0013\u0010\u0081\u0001\u001a\u00020w2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016J\u001a\u0010\u0084\u0001\u001a\u00020w2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0082@¢\u0006\u0003\u0010\u0085\u0001J\u001d\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u00012\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0082@¢\u0006\u0003\u0010\u0085\u0001J&\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00012\b\u0010\u0089\u0001\u001a\u00030\u008a\u00012\u0007\u0010\u008b\u0001\u001a\u00020FH\u0082@¢\u0006\u0003\u0010\u008c\u0001J%\u0010\u008d\u0001\u001a\u00020w2\u0007\u0010\u008b\u0001\u001a\u00020F2\u0007\u0010\u008e\u0001\u001a\u00020F2\b\u0010\u008f\u0001\u001a\u00030\u0087\u0001H\u0002J\u001d\u0010\u0090\u0001\u001a\u00020w2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0002J\u001f\u0010\u0093\u0001\u001a\u00020w2\u0007\u0010\u0094\u0001\u001a\u00020s2\u000b\b\u0002\u0010\u0095\u0001\u001a\u0004\u0018\u00010FH\u0002J\u001c\u0010\u0096\u0001\u001a\u00020w2\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\u0007\u0010\u0099\u0001\u001a\u00020sH\u0016J\u0013\u0010\u009a\u0001\u001a\u00020w2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016J\u0012\u0010\u009b\u0001\u001a\u00020w2\u0007\u0010\u009c\u0001\u001a\u00020FH\u0016J\u0012\u0010\u009d\u0001\u001a\u00020w2\u0007\u0010\u009e\u0001\u001a\u00020\u0012H\u0016J\f\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0016J>\u0010 \u0001\u001a\u00020w2\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u00012\n\u0010£\u0001\u001a\u0005\u0018\u00010¤\u00012\t\u0010¥\u0001\u001a\u0004\u0018\u00010F2\u0007\u0010¦\u0001\u001a\u00020s2\u0007\u0010§\u0001\u001a\u00020FH\u0016J\u0012\u0010¨\u0001\u001a\u00020w2\u0007\u0010©\u0001\u001a\u00020FH\u0016J\u001b\u0010ª\u0001\u001a\u00020w2\u0007\u0010©\u0001\u001a\u00020F2\u0007\u0010«\u0001\u001a\u00020sH\u0016J\t\u0010¬\u0001\u001a\u00020wH\u0016J\n\u0010\u00ad\u0001\u001a\u00030®\u0001H\u0016J\t\u0010¯\u0001\u001a\u00020sH\u0016J\u0015\u0010°\u0001\u001a\u0005\u0018\u00010±\u00012\u0007\u0010©\u0001\u001a\u00020FH\u0016J\u001d\u0010²\u0001\u001a\u00020w2\u0007\u0010©\u0001\u001a\u00020F2\t\b\u0001\u0010³\u0001\u001a\u00020\u0012H\u0016J\u0011\u0010´\u0001\u001a\u0004\u0018\u00010HH\u0016¢\u0006\u0003\u0010µ\u0001J\u001b\u0010¶\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010F\u0012\u0006\u0012\u0004\u0018\u00010F\u0018\u00010\u0011H\u0016J\t\u0010·\u0001\u001a\u00020\u0012H\u0016J\t\u0010¸\u0001\u001a\u00020\u0012H\u0016J\t\u0010¹\u0001\u001a\u00020\u0012H\u0016J\t\u0010º\u0001\u001a\u00020\u0012H\u0016J\t\u0010»\u0001\u001a\u00020\u0012H\u0016J\u0011\u0010¼\u0001\u001a\u0004\u0018\u00010HH\u0016¢\u0006\u0003\u0010µ\u0001J\u001b\u0010½\u0001\u001a\u0004\u0018\u00010W2\u0007\u0010¾\u0001\u001a\u00020\u0013H\u0096@¢\u0006\u0003\u0010¿\u0001J\u0019\u0010À\u0001\u001a\u00020s2\u0007\u0010\u008e\u0001\u001a\u00020FH\u0082@¢\u0006\u0003\u0010Á\u0001J\t\u0010Â\u0001\u001a\u00020MH\u0002J\u0012\u0010Ã\u0001\u001a\u00020w2\u0007\u0010\u008e\u0001\u001a\u00020FH\u0002J\u0019\u0010Ä\u0001\u001a\u00020w2\u0007\u0010\u008e\u0001\u001a\u00020FH\u0082@¢\u0006\u0003\u0010Á\u0001J\u0010\u0010Å\u0001\u001a\u00020wH\u0082@¢\u0006\u0003\u0010Æ\u0001J\u0013\u0010Ç\u0001\u001a\u00020w2\b\u0010¾\u0001\u001a\u00030±\u0001H\u0002J\"\u0010È\u0001\u001a\u00020w2\u0007\u0010©\u0001\u001a\u00020F2\u000e\u0010É\u0001\u001a\t\u0012\u0005\u0012\u00030Ê\u00010\u000eH\u0002J\u001a\u0010Ë\u0001\u001a\u00020w2\b\u0010Ì\u0001\u001a\u00030Í\u0001H\u0082@¢\u0006\u0003\u0010Î\u0001J0\u0010Ï\u0001\u001a\t\u0012\u0005\u0012\u00030Ê\u00010\u000e2\u0007\u0010©\u0001\u001a\u00020F2\u000e\u0010É\u0001\u001a\t\u0012\u0005\u0012\u00030Ê\u00010\u000eH\u0082@¢\u0006\u0003\u0010Ð\u0001J \u0010Ñ\u0001\u001a\t\u0012\u0005\u0012\u00030Ò\u00010\u000e2\u000e\u0010É\u0001\u001a\t\u0012\u0005\u0012\u00030Ê\u00010\u000eH\u0002J\"\u0010Ó\u0001\u001a\u00020w2\u0007\u0010©\u0001\u001a\u00020F2\u000e\u0010É\u0001\u001a\t\u0012\u0005\u0012\u00030Ê\u00010\u000eH\u0002J\u0010\u0010Ô\u0001\u001a\u0004\u0018\u00010F*\u00030Ò\u0001H\u0002J+\u0010Õ\u0001\u001a\u0005\u0018\u00010¢\u00012\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u00012\n\u0010£\u0001\u001a\u0005\u0018\u00010¤\u0001H\u0082@¢\u0006\u0003\u0010Ö\u0001J(\u0010×\u0001\u001a\u00020w2\u0007\u0010Ø\u0001\u001a\u00020\u00132\b\u0010¡\u0001\u001a\u00030¢\u00012\n\u0010£\u0001\u001a\u0005\u0018\u00010¤\u0001H\u0002J\b\u0010q\u001a\u00020\u0012H\u0002JE\u0010Ù\u0001\u001a\u00020w2\u0007\u0010©\u0001\u001a\u00020F2\u0012\b\u0002\u0010Ú\u0001\u001a\u000b\u0012\u0005\u0012\u00030Ê\u0001\u0018\u00010\u000e2\u000b\b\u0002\u0010Û\u0001\u001a\u0004\u0018\u00010F2\t\b\u0002\u0010Ü\u0001\u001a\u00020sH\u0082@¢\u0006\u0003\u0010Ý\u0001J\u0019\u0010Ü\u0001\u001a\u00020w2\u0007\u0010Þ\u0001\u001a\u00020FH\u0082@¢\u0006\u0003\u0010Á\u0001J\"\u0010ß\u0001\u001a\u00020w2\u0007\u0010©\u0001\u001a\u00020F2\u000e\u0010É\u0001\u001a\t\u0012\u0005\u0012\u00030Ê\u00010\u000eH\u0002JP\u0010à\u0001\u001a\u00020w2\u0007\u0010©\u0001\u001a\u00020F2\n\u0010á\u0001\u001a\u0005\u0018\u00010¢\u00012\n\u0010â\u0001\u001a\u0005\u0018\u00010¤\u00012\t\u0010¥\u0001\u001a\u0004\u0018\u00010F2\u0007\u0010¦\u0001\u001a\u00020s2\u0007\u0010Ø\u0001\u001a\u00020\u00132\u0007\u0010§\u0001\u001a\u00020FH\u0002J\u000b\u0010ã\u0001\u001a\u0004\u0018\u00010\u0013H\u0002J\u0011\u0010ä\u0001\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eH\u0002J\u001d\u0010å\u0001\u001a\u0005\u0018\u00010æ\u00012\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0082@¢\u0006\u0003\u0010ç\u0001J\u0015\u0010è\u0001\u001a\u00020w2\n\u0010é\u0001\u001a\u0005\u0018\u00010æ\u0001H\u0002J&\u0010ê\u0001\u001a\u00020w2\u0007\u0010ë\u0001\u001a\u00020F2\u000b\b\u0002\u0010ì\u0001\u001a\u0004\u0018\u00010FH\u0082@¢\u0006\u0003\u0010í\u0001J#\u0010î\u0001\u001a\u00020w2\u0007\u0010ë\u0001\u001a\u00020F2\b\u0010ï\u0001\u001a\u00030ð\u0001H\u0082@¢\u0006\u0003\u0010ñ\u0001J9\u0010ò\u0001\u001a\u00020w2\u0007\u0010ë\u0001\u001a\u00020F2\b\u0010ï\u0001\u001a\u00030ð\u00012\u000b\b\u0002\u0010ì\u0001\u001a\u0004\u0018\u00010F2\u0007\u0010ó\u0001\u001a\u00020sH\u0082@¢\u0006\u0003\u0010ô\u0001J\t\u0010õ\u0001\u001a\u00020wH\u0002J#\u0010ö\u0001\u001a\u00020w2\b\u0010é\u0001\u001a\u00030÷\u00012\u0007\u0010ø\u0001\u001a\u00020FH\u0082@¢\u0006\u0003\u0010ù\u0001J\t\u0010ú\u0001\u001a\u00020wH\u0002J\u001c\u0010û\u0001\u001a\u00020w2\b\u0010é\u0001\u001a\u00030÷\u00012\u0007\u0010ø\u0001\u001a\u00020FH\u0002J\u001c\u0010ü\u0001\u001a\u0005\u0018\u00010÷\u00012\u0007\u0010ë\u0001\u001a\u00020FH\u0082@¢\u0006\u0003\u0010Á\u0001J\u001c\u0010ý\u0001\u001a\u0005\u0018\u00010÷\u00012\u0007\u0010ë\u0001\u001a\u00020FH\u0082@¢\u0006\u0003\u0010Á\u0001J(\u0010þ\u0001\u001a\u0005\u0018\u00010\u0087\u00012\b\u0010ï\u0001\u001a\u00030ð\u00012\t\b\u0002\u0010ÿ\u0001\u001a\u00020sH\u0082@¢\u0006\u0003\u0010\u0080\u0002J\u001e\u0010\u0081\u0002\u001a\u00020s2\t\u0010\u0082\u0002\u001a\u0004\u0018\u00010F2\b\u0010\u009c\u0001\u001a\u00030\u0083\u0002H\u0002J\t\u0010\u0084\u0002\u001a\u00020sH\u0002J\t\u0010\u0085\u0002\u001a\u00020wH\u0002J\u0014\u0010\u0086\u0002\u001a\u00020w2\t\u0010\u0087\u0002\u001a\u0004\u0018\u00010FH\u0002J\u0012\u0010\u0088\u0002\u001a\u00020w2\u0007\u0010\u0089\u0002\u001a\u00020MH\u0002J2\u0010\u008a\u0002\u001a\u00020w2\u0007\u0010©\u0001\u001a\u00020F2\u001e\u0010\u008b\u0002\u001a\u0019\u0012\u0005\u0012\u00030±\u0001\u0012\u0007\u0012\u0005\u0018\u00010±\u00010\u008c\u0002¢\u0006\u0003\b\u008d\u0002H\u0002J3\u0010\u008e\u0002\u001a\u00020w2\u000e\u0010\u008f\u0002\u001a\t\u0012\u0005\u0012\u00030±\u00010\u000e2\t\u0010\u0090\u0002\u001a\u0004\u0018\u00010H2\u0007\u0010\u009c\u0001\u001a\u00020FH\u0002¢\u0006\u0003\u0010\u0091\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00110\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0014\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00110\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001b\u001a\u0004\b$\u0010%R\u001d\u0010'\u001a\u0004\u0018\u00010(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001b\u001a\u0004\b)\u0010*R\u001d\u0010,\u001a\u0004\u0018\u00010-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u001b\u001a\u0004\b.\u0010/R\u001d\u00101\u001a\u0004\u0018\u0001028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u001b\u001a\u0004\b3\u00104R\u001d\u00106\u001a\u0004\u0018\u0001078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u001b\u001a\u0004\b8\u00109R\u001d\u0010;\u001a\u0004\u0018\u00010<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u001b\u001a\u0004\b=\u0010>R\u001b\u0010@\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u001b\u001a\u0004\bB\u0010CR\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010K\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010N\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\u001b\u001a\u0004\bP\u0010QR\u0014\u0010S\u001a\b\u0012\u0004\u0012\u00020F0TX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010U\u001a\u001e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020W0Vj\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020W`XX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000RC\u0010Z\u001a*\u0012\u0004\u0012\u00020H\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0T0[j\u0014\u0012\u0004\u0012\u00020H\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0T`\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010\u001b\u001a\u0004\b]\u0010^RC\u0010`\u001a*\u0012\u0004\u0012\u00020H\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0T0[j\u0014\u0012\u0004\u0012\u00020H\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0T`\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010\u001b\u001a\u0004\ba\u0010^R\u0014\u0010c\u001a\b\u0012\u0004\u0012\u00020F0dX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010e\u001a\b\u0012\u0004\u0012\u00020F0f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010\u001b\u001a\u0004\bg\u0010hR\u001b\u0010j\u001a\u00020k8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bn\u0010\u001b\u001a\u0004\bl\u0010mR\u0010\u0010o\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010p\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020sX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020sX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010u\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020w0vX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010x\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020w0vX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010y\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020w0vX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010z\u001a\u0004\u0018\u00010{X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0093\u0002"}, d2 = {"Lcom/larus/canvas/feature/component/logic/GenImagePlannerComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/canvas/feature/component/logic/IGenImagePlannerAbility;", "<init>", "()V", "genImageTasksState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/canvas/feature/component/logic/bean/GenImageTasksState;", "historyFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getHistoryFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "imagePagerListFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/larus/canvas/feature/component/resultdisplay/image/PageItemData;", "_curPageDataFlow", "Lkotlin/Pair;", "", "Lcom/larus/canvas/feature/component/logic/bean/ITaskItem;", "curPageDataFlow", "getCurPageDataFlow", "imagePagerAbility", "Lcom/larus/canvas/feature/component/resultdisplay/image/IImagePagerAbility;", "getImagePagerAbility", "()Lcom/larus/canvas/feature/component/resultdisplay/image/IImagePagerAbility;", "imagePagerAbility$delegate", "Lkotlin/Lazy;", "progressViewModel", "Lcom/larus/canvas/feature/component/logic/loading/CanvasProgressViewModel;", "getProgressViewModel", "()Lcom/larus/canvas/feature/component/logic/loading/CanvasProgressViewModel;", "progressViewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "canvasEditorAbility", "Lcom/larus/canvas/feature/ability/CreationCanvasEditorAbility;", "getCanvasEditorAbility", "()Lcom/larus/canvas/feature/ability/CreationCanvasEditorAbility;", "canvasEditorAbility$delegate", "canvasImageEditAbility", "Lcom/larus/canvas/feature/component/input/ICanvasImageEditAbility;", "getCanvasImageEditAbility", "()Lcom/larus/canvas/feature/component/input/ICanvasImageEditAbility;", "canvasImageEditAbility$delegate", "canvasInstructionAbility", "Lcom/larus/canvas/feature/ability/CanvasInstructionAbility;", "getCanvasInstructionAbility", "()Lcom/larus/canvas/feature/ability/CanvasInstructionAbility;", "canvasInstructionAbility$delegate", "imageDownloadAbility", "Lcom/larus/canvas/feature/component/logic/ImageOperatorAbility;", "getImageDownloadAbility", "()Lcom/larus/canvas/feature/component/logic/ImageOperatorAbility;", "imageDownloadAbility$delegate", "argumentData", "Lcom/larus/canvas/feature/data/CanvasArgumentData;", "getArgumentData", "()Lcom/larus/canvas/feature/data/CanvasArgumentData;", "argumentData$delegate", "canvasGenImageTraceAbility", "Lcom/larus/canvas/feature/component/logic/trace/CanvasGenImageTraceAbility;", "getCanvasGenImageTraceAbility", "()Lcom/larus/canvas/feature/component/logic/trace/CanvasGenImageTraceAbility;", "canvasGenImageTraceAbility$delegate", "canvasGenerator", "Lcom/larus/canvas/feature/component/logic/canvasGenerator/ICanvasGenerator;", "getCanvasGenerator", "()Lcom/larus/canvas/feature/component/logic/canvasGenerator/ICanvasGenerator;", "canvasGenerator$delegate", "curUploaderIdentifier", "", "curUploadStartTime", "", "onListSubmitRunnable", "Ljava/lang/Runnable;", "pendingJobsBeforeGenerate", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlinx/coroutines/Job;", "creationCanvasClientConfig", "Lcom/larus/platform/model/CreationCanvasClientConfig;", "getCreationCanvasClientConfig", "()Lcom/larus/platform/model/CreationCanvasClientConfig;", "creationCanvasClientConfig$delegate", "handledFailLocalIds", "", "idMediaAttachmentCacheMap", "Ljava/util/HashMap;", "Lcom/larus/bmhome/actionbar/model/MediaAttachment;", "Lkotlin/collections/HashMap;", "curLocalCanvasId", "reqHistoryMap", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "getReqHistoryMap", "()Ljava/util/LinkedHashMap;", "reqHistoryMap$delegate", "successHistoryMap", "getSuccessHistoryMap", "successHistoryMap$delegate", "taskIdQueue", "Lkotlinx/coroutines/channels/Channel;", "pendingMirror", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getPendingMirror", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "pendingMirror$delegate", "pendingMutex", "Lkotlinx/coroutines/sync/Mutex;", "getPendingMutex", "()Lkotlinx/coroutines/sync/Mutex;", "pendingMutex$delegate", "consumerJob", "prepareOriginalImageJob", "maxGenerateCountPerRound", "isPreprocessingImage", "", "pendingAiCreationImage", "prefetchedIdLruCache", "Landroidx/collection/LruCache;", "", "noWatermarkReviewPrefetchLruCache", "noWatermarkPrefetchedIdLruCache", "cachedMsgInfo", "Lcom/larus/canvas/service/bean/CanvasMsgInfo;", "onAttach", "onCreate", "onStart", "onFragmentViewDestroyed", "onDestroy", "onRemoteImageSelected", "imageInfo", "Lcom/larus/canvas/feature/component/logic/bean/OriginImageInfo;", "prepareRemoteImageWithPipeline", "(Lcom/larus/canvas/feature/component/logic/bean/OriginImageInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadRemoteImage", "Lcom/larus/bmhome/resource/access/ResourceAccessState;", "submitCanvasImageAccess", "request", "Lcom/larus/uaigc/service/ResourceAccessSubmitRequest;", "logScene", "(Lcom/larus/uaigc/service/ResourceAccessSubmitRequest;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logCanvasAccessState", "taskId", "state", "handleOriginRemoteAccessSuccess", "readyState", "Lcom/larus/bmhome/resource/access/ResourceAccessState$Ready;", "mobCanvasRemoteUploadResult", "success", "errorMessage", "onAlbumSelected", "uri", "Landroid/net/Uri;", "isAiCreation", "onLocalImageSelected", "resetTasks", "reason", "mockClickAIBeautifyFunction", "id", "getOriginalImageInfo", "startGenerate", "instructionTab", "Lcom/larus/canvas/service/bean/InstructionTab;", "optionItem", "Lcom/larus/canvas/service/bean/OptionItem;", "prompt", "isRegenerate", "scene", "regenerate", "localId", "onImageLoaded", "isSuccess", "onListSubmit", "getProgressState", "Lcom/larus/canvas/feature/component/logic/loading/CanvasProgressState;", "hasTaskInProcess", "getTaskItem", "Lcom/larus/canvas/feature/component/logic/bean/GenImageTaskItem;", "updateImageSaveStatus", "status", "getCurCanvasId", "()Ljava/lang/Long;", "getCurMsgInfo", "getTotalReqCnt", "getTotalSuccessCnt", "getTotalCanvasCnt", "getCurRoundReqCnt", "getCurRoundSuccessCnt", "getCurLocalCanvasId", "getMediaAttachment", "task", "(Lcom/larus/canvas/feature/component/logic/bean/ITaskItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markStarted", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startConsumer", "submitTask", "startGenerateAndWaitRelease", "waitOriginalImagePrepared", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prefetchBitmaps", "prefetchNoWatermarkBlocksForReview", "canvasBlocks", "Lcom/larus/canvas/service/bean/CanvasBlock;", "startGenerateAndObserve", "param", "Lcom/larus/canvas/feature/component/logic/bean/CanvasGenerateParam;", "(Lcom/larus/canvas/feature/component/logic/bean/CanvasGenerateParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareNoWatermarkBlocksForDisplay", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectNoWatermarkCanvasImages", "Lcom/larus/im/bean/message/ImageData;", "prefetchNoWatermarkBitmaps", "noWatermarkPreviewUrl", "mergeOptionItemIntoInstructionTab", "(Lcom/larus/canvas/service/bean/InstructionTab;Lcom/larus/canvas/service/bean/OptionItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleEraseClickEvent", "curTask", "handleGenerateFail", "resp", "errorCode", "cancelPendingChildrenTasks", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parentId", "updateCanvasBlockList", "addLoadingTaskToEnd", "clickInstructionTab", "clickOptionItem", "getOriginalTask", "getInProcessTask", "preprocessAlbumImg", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAlbumPreprocessFailed", "result", "onAlbumPreprocessed", "localPath", "displayLocalPath", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onRawOriginImageReady", "resourceInput", "Lcom/larus/bmhome/resource/access/ResourceInput;", "(Ljava/lang/String;Lcom/larus/bmhome/resource/access/ResourceInput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAndUploadOriginImage", "enablePipelinePreprocess", "(Ljava/lang/String;Lcom/larus/bmhome/resource/access/ResourceInput;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleOriginUploadFail", "handleOriginUploadSuccess", "Lcom/larus/platform/model/upload/ResourceUploadResult;", "localFilePath", "(Lcom/larus/platform/model/upload/ResourceUploadResult;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleOriginReviewFail", "handleOriginAccessSuccess", "uploadImage", "uploadImageLegacy", "uploadImageAccessState", "enablePreprocess", "(Lcom/larus/bmhome/resource/access/ResourceInput;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelUpload", "identifier", "Lcom/larus/bmhome/resource/access/ResourceCancelReason;", "shouldShowCanvasUploadLoading", "bindObservers", "explainOriginImageUrl", ShareType.URL, "enqueuePendingJobsBeforeGenerate", "job", "updateGenImageTaskItemData", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "reportSubCanvasCancel", "toCancelTasks", "canvasId", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;)V", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GenImagePlannerComponent extends BaseContentWidget implements n2 {
    public static final /* synthetic */ int W = 0;
    public String A;
    public long B;
    public t0 C;
    public CopyOnWriteArrayList<Job> D;
    public final Lazy E;
    public final Set<String> F;
    public final HashMap<String, MediaAttachment> G;
    public long H;
    public final Lazy I;
    public final Lazy J;
    public Channel<String> K;
    public final Lazy L;
    public final Lazy M;
    public Job N;
    public Job O;
    public int P;
    public boolean Q;
    public boolean R;
    public final LruCache<String, Unit> S;
    public final LruCache<String, Unit> T;
    public final LruCache<String, Unit> U;
    public CanvasMsgInfo V;
    public final StateFlowImpl m;
    public final kotlinx.coroutines.flow.b1 n;
    public final Flow<List<com.larus.canvas.feature.component.resultdisplay.image.y>> o;
    public final StateFlowImpl p;
    public final kotlinx.coroutines.flow.b1 q;
    public final Lazy r;
    public final com.larus.ui.arch.vm.internal.l s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ProcessFileResultCode.values().length];
            r0[ProcessFileResultCode.PREPARE_OVER_SIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ProcessFileResultCode.PREPARE_TYPE_NO_MATCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public c(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class d implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public d(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class e implements Function0<ViewModelProvider.Factory> {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    static {
    }

    public final void A2() {
        SendChannel.a.a(this.K);
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final boolean M20() {
        Collection<ky8.h> r0 = ((ky8.g) this.n.getValue()).a.values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L3:
        boolean r3 = true;
        if (r2.hasNext() == false) goto L14;
        Object r4 = r2.next();
        ky8.h r5 = (ky8.h) r4;
        if ((r5 instanceof ky8.f) == true) goto L8;
    L10:
        r3 = false;
    L11:
        if (r3 == false) goto L3;
        r1.add(r4);
        goto L3
    L8:
        if (((ky8.f) r5).k() == false) goto L10;
    L14:
        if ((!r1.isEmpty()) == true) goto L23;
        return false;
    L23:
        return true;
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final int Sr() {
        Iterator r0 = ((LinkedHashMap) this.J.getValue()).values().iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 + ((Set) r0.next()).size();
        goto L4
    L6:
        return r1;
    }

    public final my8.q W3() {
        return (my8.q) this.x.getValue();
    }

    public final com.larus.canvas.feature.component.logic.trace.a X3() {
        return (com.larus.canvas.feature.component.logic.trace.a) this.y.getValue();
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final Long XF() {
        Iterator<T> r0 = ((ky8.g) this.n.getValue()).a.values().iterator();
        Object r2 = null;
    L4:
        if (r0.hasNext() == false) goto L20;
        Object r3 = r0.next();
        ky8.h r4 = (ky8.h) r3;
        if ((r4 instanceof ky8.f) == false) goto L16;
        CanvasInfo r5 = ((ky8.f) r4).a();
        if (r5 == null) goto L12;
        Long r6 = r5.canvasId;
        if (r6 == null) goto L12;
        long r7 = r6.longValue();
    L14:
        if (r7 == 0) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == false) goto L4;
        r2 = r3;
    L12:
        r7 = 0;
    L16:
        r8 = false;
        goto L17
    L20:
        if ((r2 instanceof ky8.f) == false) goto L22;
        ky8.f r9 = (ky8.f) r2;
    L23:
        if (r9 == null) goto L33;
        CanvasInfo r1 = r9.a();
        if (r1 != null) goto L27;
        return null;
    L27:
        return r1.canvasId;
    L33:
        return null;
    L22:
        r9 = null;
        goto L23
    }

    public final com.larus.canvas.feature.component.resultdisplay.image.r Z3() {
        return (com.larus.canvas.feature.component.resultdisplay.image.r) this.r.getValue();
    }

    public final ky8.j c4() {
        ky8.h r0 = ((ky8.g) this.n.getValue()).a.get("origin");
        if ((r0 instanceof ky8.k) == false) goto L5;
        ky8.k r1 = (ky8.k) r0;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.b;
    L5:
        r1 = null;
        goto L6
    }

    public final ConcurrentLinkedDeque<String> d4() {
        return (ConcurrentLinkedDeque) this.L.getValue();
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final int dx() {
        Set r0 = (Set) CollectionsKt.lastOrNull(((LinkedHashMap) this.J.getValue()).values());
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final CanvasProgressViewModel e4() {
        return (CanvasProgressViewModel) this.s.getValue();
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final void gu() {
        t0 r0 = this.C;
        if (r0 == null) goto L5;
        r0.run();
    L5:
        this.C = null;
    }

    public final LinkedHashMap<Long, Set<String>> h4() {
        return (LinkedHashMap) this.I.getValue();
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final Pair<String, String> j50() {
        Iterator<T> r0 = ((ky8.g) this.n.getValue()).a.values().iterator();
        Object r2 = null;
    L4:
        if (r0.hasNext() == false) goto L14;
        Object r3 = r0.next();
        ky8.h r4 = (ky8.h) r3;
        if ((r4 instanceof ky8.f) == true) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == false) goto L4;
        r2 = r3;
        goto L4
    L8:
        if (((ky8.f) r4).m() == null) goto L10;
        r5 = true;
        goto L11
    L14:
        if ((r2 instanceof ky8.f) == false) goto L16;
        ky8.f r6 = (ky8.f) r2;
    L17:
        if (r6 == null) goto L23;
        CanvasMsgInfo r1 = r6.m();
        if (r1 == null) goto L23;
        Pair<String, String> r7 = TuplesKt.to(r1.sendMsgId, r1.replyMsgId);
        if (r7 == null) goto L23;
        return r7;
    L23:
        CanvasMsgInfo r8 = this.V;
        if (r8 != null) goto L26;
        return null;
    L26:
        return TuplesKt.to(r8.sendMsgId, r8.replyMsgId);
    L16:
        r6 = null;
        goto L17
    }

    public final void k4() {
        t19.s r1 = t19.s.a;
        Context r2 = getContext();
        r1.getClass();
        t19.s.s(r2, 2131900615);
        bs("based_task_fail");
        my8.q r3 = W3();
        String r4 = null;
        if (r3 == null) goto L5;
        String r12 = r3.v;
    L6:
        my8.q r5 = W3();
        if (r5 == null) goto L9;
        String r14 = r5.a();
    L10:
        my8.q r6 = W3();
        if (r6 == null) goto L13;
        String r7 = r6.t;
    L14:
        my8.q r8 = W3();
        if (r8 == null) goto L17;
        String r18 = r8.q;
    L18:
        my8.q r9 = W3();
        if (r9 == null) goto L21;
        String r10 = r9.b();
    L22:
        my8.q r11 = W3();
        if (r11 == null) goto L25;
        String r20 = r11.c();
    L26:
        my8.q r13 = W3();
        if (r13 == null) goto L29;
        r4 = r13.z;
    L29:
        y3.a(r10, r7, null, "review", ReeditType.IMAGE, null, TriggerSendLoading.NO_LOADING, null, null, r12, null, r14, null, null, null, r18, TriggerSendLoading.NO_LOADING, r20, "album", r4, null, null, null, null, null, null, null, null, null, Long.valueOf(System.currentTimeMillis() - this.B), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -4073564, 65534);
        return;
    L25:
        r20 = null;
        goto L26
    L21:
        r10 = null;
        goto L22
    L17:
        r18 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r14 = null;
        goto L10
    L5:
        r12 = null;
        goto L6
    }

    public final void l4() {
        String r7 = null;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GenImagePlannerComponent$handleOriginUploadFail$1(this, null), 3, null);
        bs("based_task_fail");
        my8.q r1 = W3();
        if (r1 == null) goto L5;
        String r17 = r1.v;
    L6:
        my8.q r2 = W3();
        if (r2 == null) goto L9;
        String r19 = r2.a();
    L10:
        my8.q r3 = W3();
        if (r3 == null) goto L13;
        String r9 = r3.t;
    L14:
        my8.q r4 = W3();
        if (r4 == null) goto L17;
        String r23 = r4.q;
    L18:
        my8.q r5 = W3();
        if (r5 == null) goto L21;
        String r8 = r5.b();
    L22:
        my8.q r6 = W3();
        if (r6 == null) goto L25;
        String r25 = r6.c();
    L26:
        my8.q r10 = W3();
        if (r10 == null) goto L29;
        r7 = r10.z;
    L29:
        y3.a(r8, r9, null, "upload", ReeditType.IMAGE, null, TriggerSendLoading.NO_LOADING, null, null, r17, null, r19, null, null, null, r23, TriggerSendLoading.NO_LOADING, r25, "album", r7, null, null, null, null, null, null, null, null, null, Long.valueOf(System.currentTimeMillis() - this.B), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -4073564, 65534);
        return;
    L25:
        r25 = null;
        goto L26
    L21:
        r8 = null;
        goto L22
    L17:
        r23 = null;
        goto L18
    L13:
        r9 = null;
        goto L14
    L9:
        r19 = null;
        goto L10
    L5:
        r17 = null;
        goto L6
    }

    public final void onStart() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GenImagePlannerComponent$bindObservers$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GenImagePlannerComponent$bindObservers$2(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GenImagePlannerComponent$bindObservers$3(this, null), 3, null);
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, n2.class);
    }

    public GenImagePlannerComponent() {
        StateFlowImpl r0 = kotlinx.coroutines.flow.j1.a(new ky8.g(MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("origin", new ky8.k(false, 3))})));
        this.m = r0;
        final kotlinx.coroutines.flow.b1 r1 = kotlinx.coroutines.flow.e.b(r0);
        this.n = r1;
        this.o = kotlinx.coroutines.flow.e.n(new GenImagePlannerComponent$special$$inlined$map$1(r1));
        StateFlowImpl r2 = kotlinx.coroutines.flow.j1.a(TuplesKt.to(0, null));
        this.p = r2;
        this.q = kotlinx.coroutines.flow.e.b(r2);
        LazyThreadSafetyMode r3 = LazyThreadSafetyMode.NONE;
        this.r = LazyKt.lazy(r3, new h0(this));
        this.s = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(CanvasProgressViewModel.class), Reflection.getOrCreateKotlinClass(CanvasProgressState.class), new c(this), new d(this), e.a);
        this.t = LazyKt.lazy(new a1(this));
        this.u = LazyKt.lazy(new b1(this));
        this.v = LazyKt.lazy(new c1(this));
        this.w = LazyKt.lazy(new d1(this));
        this.x = LazyKt.lazy(r3, new e1(this));
        this.y = LazyKt.lazy(new f1(this));
        this.z = LazyKt.lazy(new i0());
        this.E = LazyKt.lazy(new j0());
        this.F = new LinkedHashSet();
        this.G = new HashMap();
        this.I = LazyKt.lazy(new k0());
        this.J = LazyKt.lazy(new s0());
        this.K = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.L = LazyKt.lazy(new y0());
        this.M = LazyKt.lazy(new z0());
        this.S = new LruCache(20);
        this.T = new LruCache(20);
        this.U = new LruCache(20);
    }

    public final Job G4() {
        return BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)), null, new GenImagePlannerComponent$startConsumer$1(this, null), 2, null);
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final int Jx() {
        Iterator<T> r0 = h4().values().iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 + ((Set) r0.next()).size();
        goto L4
    L6:
        return r1;
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final int PT() {
        return h4().size();
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        this.N = G4();
    }

    public final void onDestroy() {
        ConcurrentLinkedDeque<String> r0 = d4();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        String r3 = (String) r2.next();
        Intrinsics.checkNotNull(r3);
        ky8.f r4 = O30(r3);
        if (r4 == null) goto L4;
        r1.add(r4);
        goto L4
    L8:
        Long r5 = XF();
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new GenImagePlannerComponent$reportSubCanvasCancel$1(r1, r5, "leave_canvas_page", null), 3, null);
        SendChannel.a.a(this.K);
        H3(this.A, ResourceCancelReason.PAGE_DESTROY);
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final int re() {
        Set r0 = (Set) CollectionsKt.lastOrNull(h4().values());
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final CanvasProgressState zm() {
        return (CanvasProgressState) e4().getState();
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final kotlinx.coroutines.flow.i1<ky8.g> bt() {
        return this.n;
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final kotlinx.coroutines.flow.b1 tx() {
        return this.q;
    }

    public static List Q3(List r4) {
        ArrayList r0 = new ArrayList();
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L22;
        CanvasImageBlock r1 = ((CanvasBlock) r5.next()).content;
        if (r1 == null) goto L19;
        ImageData r2 = r1.image;
        if (r2 == null) goto L19;
        String r3 = r2.imageUri;
        if (r3 != null) goto L12;
    L15:
        boolean r6 = true;
    L17:
        if ((!r6) == false) goto L19;
    L20:
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L12:
        if (r3.length() == 0) goto L15;
        r6 = false;
    L19:
        r2 = null;
        goto L20
    L22:
        return r0;
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final void Fp(ky8.j r9) {
        Intrinsics.checkNotNullParameter(r9, "imageInfo");
        this.B = System.currentTimeMillis();
        this.O = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new GenImagePlannerComponent$onRemoteImageSelected$1(this, r9, null), 2, null);
        T4("origin");
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final ky8.f O30(String r2) {
        Intrinsics.checkNotNullParameter(r2, "localId");
        ky8.h r3 = ((ky8.g) this.n.getValue()).a.get(r2);
        if ((r3 instanceof ky8.f) == true) goto L7;
        return null;
    L7:
        return (ky8.f) r3;
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final void SS(ky8.j r8) {
        Intrinsics.checkNotNullParameter(r8, "imageInfo");
        this.O = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new GenImagePlannerComponent$onLocalImageSelected$1(r8, this, null), 2, null);
        T4("origin");
    }

    public final void T4(String r7) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GenImagePlannerComponent$submitTask$1(this, r7, null), 3, null);
    }

    public final void V3(String r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        Job r8 = BuildersKt.async$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new GenImagePlannerComponent$explainOriginImageUrl$job$1(r7, this, null), 2, null);
        if (this.D != null) goto L7;
        this.D = new CopyOnWriteArrayList();
    L7:
        CopyOnWriteArrayList<Job> r0 = this.D;
        if (r0 == null) goto L11;
        r0.add(r8);
        return;
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final void Xu(int r12) {
        fy8.h r0 = (fy8.h) this.v.getValue();
        if (r0 == null) goto L78;
        kotlinx.coroutines.flow.b1 r1 = r0.i70();
        if (r1 == null) goto L79;
        InstructionTabState r2 = (InstructionTabState) r1.getValue();
        if (r2 == null) goto L80;
        List<InstructionTab> r3 = r2.getInstructionTabList();
        if (r3 == null) goto L81;
        List<InstructionTab> r4 = r3;
        Iterator<T> r5 = r4.iterator();
    L11:
        OptionItem r6 = null;
        Object r7 = null;
        if (r5.hasNext() == false) goto L29;
        Object r8 = r5.next();
        InstructionTab r9 = (InstructionTab) r8;
        Integer r10 = r9.getTabType();
        if (r10 != null) goto L17;
    L26:
        boolean r11 = false;
    L27:
        if (r11 == false) goto L11;
    L30:
        InstructionTab r13 = (InstructionTab) r8;
        if (r13 == null) goto L33;
        n2.a.a(this, r13, null, false);
        return;
    L33:
        Iterator<T> r14 = r4.iterator();
    L35:
        if (r14.hasNext() == false) goto L45;
        Object r15 = r14.next();
        Integer r16 = ((InstructionTab) r15).getTabType();
        if (r16 != null) goto L40;
    L42:
        boolean r17 = false;
    L43:
        if (r17 == false) goto L35;
    L46:
        InstructionTab r18 = (InstructionTab) r15;
        if (r18 == null) goto L83;
        List<OptionItem> r19 = r18.getOptionList();
        if (r19 == null) goto L60;
        Iterator<T> r20 = r19.iterator();
    L52:
        if (r20.hasNext() == false) goto L59;
        Object r21 = r20.next();
        if (((OptionItem) r21).getId() != r12) goto L56;
        boolean r22 = true;
    L57:
        if (r22 == false) goto L52;
        r7 = r21;
        goto L59
    L56:
        r22 = false;
    L59:
        r6 = (OptionItem) r7;
    L60:
        if (r6 == null) goto L84;
        n2.a.a(this, r18, r6, false);
        return;
    L84:
        return;
    L83:
        return;
    L40:
        if (r16.intValue() != 3) goto L42;
        r17 = true;
        goto L43
    L45:
        r15 = null;
        goto L46
    L17:
        if (r10.intValue() != 4) goto L26;
        OptionItem r23 = r9.getSingleOption();
        if (r23 != null) goto L21;
    L23:
        boolean r24 = false;
    L24:
        if (r24 == false) goto L26;
        r11 = true;
        goto L27
    L21:
        if (r23.getId() != r12) goto L23;
        r24 = true;
        goto L24
    L29:
        r8 = null;
        goto L30
    L81:
        return;
    L80:
        return;
    L79:
        return;
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final void bs(String r15) {
        Intrinsics.checkNotNullParameter(r15, "reason");
        this.V = null;
        ConcurrentLinkedDeque<String> r1 = d4();
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        String r4 = (String) r3.next();
        Intrinsics.checkNotNull(r4);
        ky8.f r5 = O30(r4);
        if (r5 == null) goto L4;
        r2.add(r5);
        goto L4
    L8:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new GenImagePlannerComponent$reportSubCanvasCancel$1(r2, XF(), r15, null), 3, null);
        Job r16 = this.O;
        if (r16 == null) goto L11;
        Job.DefaultImpls.cancel$default(r16, null, 1, null);
    L11:
        com.larus.canvas.feature.component.logic.canvasGenerator.j r17 = (com.larus.canvas.feature.component.logic.canvasGenerator.j) this.z.getValue();
        Collection<ky8.h> r6 = ((ky8.g) this.m.getValue()).a.values();
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L13:
        if (r8.hasNext() == false) goto L23;
        ky8.h r9 = (ky8.h) r8.next();
        if ((r9 instanceof ky8.f) == false) goto L17;
        ky8.f r10 = (ky8.f) r9;
    L18:
        if (r10 == null) goto L20;
        String r11 = r10.a;
    L21:
        if (r11 == null) goto L13;
        r7.add(r11);
        goto L13
    L20:
        r11 = null;
        goto L21
    L17:
        r10 = null;
        goto L18
    L23:
        r17.b(r7);
        H3(this.A, ResourceCancelReason.USER_CANCEL);
        this.m.setValue(new ky8.g(MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("origin", new ky8.k(false, 3))})));
        CopyOnWriteArrayList<Job> r18 = this.D;
        if (r18 == null) goto L29;
        Iterator<Job> r19 = r18.iterator();
    L27:
        if (r19.hasNext() == false) goto L29;
        Job.DefaultImpls.cancel$default(r19.next(), null, 1, null);
    L29:
        this.D = null;
        SendChannel.a.a(this.K);
        this.G.clear();
        Job r110 = this.N;
        if (r110 == null) goto L32;
        Job.DefaultImpls.cancel$default(r110, null, 1, null);
    L32:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GenImagePlannerComponent$resetTasks$4(this, null), 3, null);
        this.K = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.N = G4();
        my8.q r111 = W3();
        if (r111 == null) goto L35;
        Intrinsics.checkNotNullParameter("upload", "<set-?>");
        r111.z = "upload";
    L35:
        this.H = System.currentTimeMillis();
        this.m.setValue(new ky8.g(MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("origin", new ky8.k(false, 3))})));
        com.larus.canvas.feature.component.resultdisplay.image.r r112 = Z3();
        if (r112 == null) goto L38;
        r112.yS(new com.larus.canvas.feature.component.resultdisplay.image.t.a(0, false));
    L38:
        h4().put(Long.valueOf(this.H), new LinkedHashSet());
        ((LinkedHashMap) this.J.getValue()).put(Long.valueOf(this.H), new LinkedHashSet());
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final void lH(String r23) {
        Intrinsics.checkNotNullParameter(r23, "localId");
        Object r1 = ((Pair) this.q.getValue()).getSecond();
        String r3 = null;
        if ((r1 instanceof ky8.f) == false) goto L5;
        ky8.f r2 = (ky8.f) r1;
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        n2.a.a(this, null, null, true);
        my8.q r4 = W3();
        if (r4 == null) goto L11;
        String r15 = r4.w;
    L12:
        my8.q r5 = W3();
        if (r5 == null) goto L15;
        String r6 = r5.b();
    L16:
        ImageData r7 = r2.h();
        if (r7 == null) goto L19;
        String r18 = r7.taskId;
    L20:
        CanvasInfo r8 = r2.a();
        if (r8 == null) goto L25;
        Long r9 = r8.canvasId;
        if (r9 == null) goto L25;
        String r10 = r9.toString();
    L26:
        my8.q r11 = W3();
        if (r11 == null) goto L29;
        String r12 = r11.c();
    L30:
        my8.q r13 = W3();
        if (r13 == null) goto L33;
        String r14 = r13.t;
    L34:
        CanvasInfo r16 = r2.a();
        if (r16 == null) goto L37;
        r3 = r16.replySubId;
    L37:
        tx9.c0.x(r6, r12, "answer", r10, r14, r3, ReeditType.IMAGE, null, null, null, null, r15, null, null, r18, null, null, 230686496);
        return;
    L33:
        r14 = null;
        goto L34
    L29:
        r12 = null;
    L25:
        r10 = null;
        goto L26
    L19:
        r18 = null;
        goto L20
    L15:
        r6 = null;
        goto L16
    L11:
        r15 = null;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public static final Object D3(GenImagePlannerComponent r4, Continuation r5) {
        r4.getClass();
        if ((r5 instanceof GenImagePlannerComponent$waitOriginalImagePrepared$1) == false) goto L7;
        GenImagePlannerComponent$waitOriginalImagePrepared$1 r0 = (GenImagePlannerComponent$waitOriginalImagePrepared$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r7 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L19:
        ky8.h r8 = ((ky8.g) r4.n.getValue()).a.get("origin");
        ky8.k r9 = null;
        if ((r8 instanceof ky8.k) == false) goto L22;
        ky8.k r10 = (ky8.k) r8;
    L24:
        if ((r10 instanceof ky8.k) == false) goto L26;
        r9 = r10;
    L26:
        if (r9 != null) goto L28;
    L30:
        r7 = false;
    L32:
        if (r7 == true) goto L34;
    L36:
        FLogger.a.e("GenImagePlannerComponent", "waitOriginalImagePrepared, but original image is not ready");
    L38:
        return Unit.INSTANCE;
    L34:
        if (r9.b == null) goto L36;
        FLogger.a.i("GenImagePlannerComponent", "waitOriginalImagePrepared and original image is ready");
        goto L38
    L28:
        if (r9.a == true) goto L30;
    L22:
        r10 = null;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        Job r11 = r4.O;
        if (r11 == null) goto L19;
        r0.label = 1;
        if (r11.join(r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new GenImagePlannerComponent$waitOriginalImagePrepared$1(r4, r5);
        goto L8
    }

    public static void H3(String r4, ResourceCancelReason r5) {
        if (r4 == null) goto L18;
        boolean r1 = true;
        if (r4.length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r4 = null;
    L10:
        if (r4 != null) goto L13;
        return;
    L13:
        if (z2.a.enableCreationResourceAccessPipeline() == false) goto L15;
        r1 = ICreationResourceAccessService.a.a(r4, r5);
    L16:
        FLogger.a.i("GenImagePlannerComponent", "[cancelUpload] identifier=" + r4 + ", reason=" + r5 + ", cancelled=" + r1);
        return;
    L15:
        ResourceUploader.c(r4);
        goto L16
    L6:
        r0 = false;
        goto L7
    }

    public static final void m3(GenImagePlannerComponent r51, ic8.n0 r52) {
        r51.getClass();
        FLogger r2 = FLogger.a;
        r2.e("GenImagePlannerComponent", "preprocess albumImg failed");
        String r3 = null;
        if (r52 == null) goto L5;
        ProcessFileResultCode r1 = r52.b;
    L6:
        if (r1 != null) goto L8;
        int r4 = -1;
    L10:
        if (r4 != 1) goto L12;
        r2.e("GenImagePlannerComponent", "tryAttachmentUpload ProcessResult for OverSize");
        t19.s r5 = t19.s.a;
        Context r6 = r51.getContext();
        r5.getClass();
        t19.s.s(r6, 2131906513);
    L16:
        r51.bs("based_task_fail");
        my8.q r7 = r51.W3();
        if (r7 == null) goto L19;
        String r13 = r7.v;
    L20:
        my8.q r8 = r51.W3();
        if (r8 == null) goto L23;
        String r15 = r8.a();
    L24:
        my8.q r9 = r51.W3();
        if (r9 == null) goto L27;
        String r10 = r9.t;
    L28:
        my8.q r11 = r51.W3();
        if (r11 == null) goto L31;
        String r19 = r11.q;
    L32:
        my8.q r12 = r51.W3();
        if (r12 == null) goto L35;
        String r14 = r12.b();
    L36:
        my8.q r16 = r51.W3();
        if (r16 == null) goto L39;
        String r21 = r16.c();
    L40:
        my8.q r17 = r51.W3();
        if (r17 == null) goto L43;
        r3 = r17.z;
    L43:
        y3.a(r14, r10, null, "preprocess", ReeditType.IMAGE, null, TriggerSendLoading.NO_LOADING, null, null, r13, null, r15, null, null, null, r19, TriggerSendLoading.NO_LOADING, r21, "album", r3, null, null, null, null, null, null, null, null, null, Long.valueOf(System.currentTimeMillis() - r51.B), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -4073564, 65534);
        return;
    L39:
        r21 = null;
        goto L40
    L35:
        r14 = null;
        goto L36
    L31:
        r19 = null;
        goto L32
    L27:
        r10 = null;
        goto L28
    L23:
        r15 = null;
        goto L24
    L19:
        r13 = null;
        goto L20
    L12:
        if (r4 == 2) goto L14;
        t19.s r18 = t19.s.a;
        Context r20 = r51.getContext();
        r18.getClass();
        t19.s.s(r20, 2131908214);
        goto L16
    L14:
        r2.e("GenImagePlannerComponent", "tryAttachmentUpload ProcessResult for PREPARE_TYPE_NO_MATCH");
        t19.s r22 = t19.s.a;
        Context r23 = r51.getContext();
        r22.getClass();
        t19.s.s(r23, 2131906526);
        goto L16
    L8:
        r4 = b.a[r1.ordinal()];
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final void F4(String r17, List<CanvasBlock> r18) {
        ArrayList r2 = new ArrayList();
        Iterator<T> r1 = r18.iterator();
    L3:
        boolean r4 = false;
        String r6 = null;
        if (r1.hasNext() == false) goto L77;
        CanvasImageBlock r3 = ((CanvasBlock) r1.next()).content;
        if (r3 == null) goto L75;
        ImageData r5 = r3.image;
        if (r5 == null) goto L75;
        CreationNoWatermarkManager r7 = CreationNoWatermarkManager.a;
        r7.getClass();
        CreationNoWatermarkManager.d r8 = r7.W(CreationNoWatermarkManager.z(r5), r5);
        if (r8.b == true) goto L13;
        List r9 = CollectionsKt.emptyList();
    L76:
        CollectionsKt.addAll(r2, r9);
        goto L3
    L13:
        ImageData r10 = (ImageData) r8.a;
        if (r10 != null) goto L16;
        r9 = CollectionsKt.emptyList();
        goto L76
    L16:
        String[] r11 = new String[2];
        ImageObj r12 = r10.imageThumb;
        if (r12 == null) goto L19;
        String r13 = r12.url;
    L20:
        r11[0] = r13;
        String r14 = "";
        if (z2.a.enableBlockImagePreviewResize() == false) goto L58;
        ImageObj r15 = r10.imagePreviewResize;
        if (r15 == null) goto L25;
        String r16 = r15.getHeicUrl();
    L26:
        if (r16 != null) goto L29;
        r16 = "";
    L29:
        if (r16.length() != 0) goto L31;
        boolean r19 = true;
    L32:
        if (r19 == false) goto L74;
        ImageObj r20 = r10.imagePreviewResize;
        if (r20 == null) goto L36;
        r16 = r20.url;
    L37:
        if (r16 != null) goto L40;
        r16 = "";
    L40:
        if (r16.length() != 0) goto L42;
        boolean r110 = true;
    L43:
        if (r110 == false) goto L74;
        ImageObj r21 = r10.imagePreview;
        if (r21 == null) goto L47;
        String r22 = r21.getHeicUrl();
    L48:
        if (r22 == null) goto L52;
        r14 = r22;
    L52:
        if (r14.length() != 0) goto L54;
        r4 = true;
    L54:
        if (r4 == false) goto L73;
        ImageObj r23 = r10.imagePreview;
        if (r23 == null) goto L72;
        r6 = r23.url;
    L72:
        r16 = r6;
    L73:
        r16 = r14;
        goto L74
    L47:
        r22 = null;
        goto L48
    L42:
        r110 = false;
        goto L43
    L36:
        r16 = null;
    L74:
        r11[1] = r16;
        r9 = CollectionsKt.listOfNotNull(r11);
        goto L76
    L31:
        r19 = false;
        goto L32
    L25:
        r16 = null;
        goto L26
    L58:
        ImageObj r24 = r10.imagePreview;
        if (r24 == null) goto L61;
        String r25 = r24.getHeicUrl();
    L62:
        if (r25 == null) goto L66;
        r14 = r25;
    L66:
        if (r14.length() != 0) goto L68;
        r4 = true;
    L68:
        if (r4 == false) goto L73;
        ImageObj r26 = r10.imagePreview;
        if (r26 == null) goto L72;
        r6 = r26.url;
        goto L72
    L61:
        r25 = null;
        goto L62
    L19:
        r13 = null;
    L75:
        r9 = CollectionsKt.emptyList();
        goto L76
    L77:
        ArrayList r27 = new ArrayList();
        Iterator r28 = r2.iterator();
    L79:
        if (r28.hasNext() == false) goto L86;
        Object r29 = r28.next();
        if (((String) r29).length() <= 0) goto L83;
        boolean r30 = true;
    L84:
        if (r30 == false) goto L79;
        r27.add(r29);
        goto L79
    L83:
        r30 = false;
        goto L84
    L86:
        List r31 = CollectionsKt.distinct(r27);
        if (r31.isEmpty() == false) goto L89;
        return;
    L89:
        String r32 = r17 + ':' + CollectionsKt.joinToString$default(r31, "|", null, null, 0, null, null, 62, null);
        if (this.U.get(r32) == null) goto L92;
        return;
    L92:
        this.U.put(r32, Unit.INSTANCE);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new GenImagePlannerComponent$prefetchNoWatermarkBitmaps$1(r31, null), 2, null);
    }

    public final Object G3(String r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof GenImagePlannerComponent$cancelPendingChildrenTasks$1) == false) goto L7;
        GenImagePlannerComponent$cancelPendingChildrenTasks$1 r0 = (GenImagePlannerComponent$cancelPendingChildrenTasks$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        Iterator r14 = (Iterator) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L47:
        if (r14.hasNext() == false) goto L52;
        String r3 = ((ky8.f) r14.next()).a;
        r0.L$0 = r14;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 2;
        if (j4(this, r3, null, null, r0, 6) != r7) goto L47;
        return r7;
    L52:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        kotlinx.coroutines.sync.a r15 = (kotlinx.coroutines.sync.a) r0.L$2;
        Collection r4 = (List) r0.L$1;
        String r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L56:
    L53:
        th = move-exception;
        r15.unlock(null);
        throw th;
    L21:
        if (d4().isEmpty() == false) goto L25;
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L53
        r15.unlock(null);
        return r16;
    L25:
        Iterator<String> r17 = d4().iterator();     // Catch: Throwable -> L53
    L27:
        if (r17.hasNext() == false) goto L42;
        String r6 = r17.next();     // Catch: Throwable -> L53
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L53
        ky8.f r8 = O30(r6);     // Catch: Throwable -> L53
        if (r8 == null) goto L31;
        ky8.h r9 = r8.c;     // Catch: Throwable -> L53
    L33:
        if ((r9 instanceof ky8.f) == false) goto L35;
        ky8.f r10 = (ky8.f) r9;     // Catch: Throwable -> L53
    L36:
        if (r10 == null) goto L38;
        String r18 = r10.a;     // Catch: Throwable -> L53
    L40:
        if (Intrinsics.areEqual(r18, r5) == false) goto L27;
        r4.add(r8);     // Catch: Throwable -> L53
        r17.remove();     // Catch: Throwable -> L53
        goto L27
    L38:
        r18 = null;
        goto L40
    L35:
        r10 = null;
        goto L36
    L31:
        r9 = null;
        goto L33
    L42:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L53
        r15.unlock(null);
        if ((!r4.isEmpty()) == false) goto L52;
        r14 = r4.iterator();
        goto L47
    L16:
        ResultKt.throwOnFailure(r13);
        r4 = new ArrayList();
        kotlinx.coroutines.sync.a r110 = (kotlinx.coroutines.sync.a) this.M.getValue();
        r0.L$0 = r11;
        r0.L$1 = r4;
        r0.L$2 = r110;
        r0.label = 1;
        if (r110.a(null, r0) != r7) goto L19;
        return r7;
    L19:
        r5 = r11;
        r15 = r110;
    L7:
        r0 = new GenImagePlannerComponent$cancelPendingChildrenTasks$1(this, r12);
        goto L8
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final void IQ(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "localId");
        ky8.f r0 = O30(r3);
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L14;
        W4(r3, new n0());
        ky8.f r5 = O30(r3);
        if (r5 == null) goto L15;
        com.larus.canvas.feature.component.logic.trace.a r2 = X3();
        if (r2 == null) goto L16;
        r2.Vz(r5, r4);
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (r0.f == true) goto L7;
        r1 = true;
        goto L7
    }

    public final void W4(final String r3, final Function1<? super ky8.f, ky8.f> r4) {
        com.larus.canvas.feature.component.logic.helper.f.a(this.m, new x0(r3, r4));
    }

    public final Object a4(ky8.h r28, Continuation<? super MediaAttachment> r29) {
        ky8.h r1 = r28;
        if ((r29 instanceof GenImagePlannerComponent$getMediaAttachment$1) == false) goto L7;
        GenImagePlannerComponent$getMediaAttachment$1 r3 = (GenImagePlannerComponent$getMediaAttachment$1) r29;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        Long r7 = null;
        boolean r9 = true;
        String r10 = "";
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        String r8 = (String) r3.L$1;
        ky8.h r11 = (ky8.h) r3.L$0;
        ResultKt.throwOnFailure(r2);
        String r12 = r8;
        r1 = r11;
    L120:
        File r13 = (File) r2;
        if (r13 == null) goto L138;
        ky8.f r14 = (ky8.f) r1;
        ImageData r15 = r14.h();
        if (r15 == null) goto L125;
        String r16 = r15.imageUri;
    L126:
        String r17 = com.larus.utils.y0.k(Uri.fromFile(r13));
        if (r15 == null) goto L131;
        ImageObj r18 = r15.imageOrigin;
        if (r18 == null) goto L131;
        Long r19 = Boxing.boxLong(r18.width);
    L132:
        if (r15 == null) goto L136;
        ImageObj r20 = r15.imageOrigin;
        if (r20 == null) goto L136;
        r7 = Boxing.boxLong(r20.height);
    L136:
        r7 = new MediaAttachment(r12, r16, new ImageUploadInfo(r19, r7), null, r17, null, null, null, null, null, null, null, 4072, null);
        this.G.put(r14.a, r7);
    L131:
        r19 = null;
        goto L132
    L125:
        r16 = null;
    L138:
        return r7;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        GenImagePlannerComponent r21 = (GenImagePlannerComponent) r3.L$1;
        ky8.h r22 = (ky8.h) r3.L$0;
        ResultKt.throwOnFailure(r2);
        GenImagePlannerComponent r23 = r21;
        r1 = r22;
        Object r24 = r2;
    L70:
        File r25 = (File) r24;
        if (r25 == null) goto L138;
        ky8.k r26 = (ky8.k) r1;
        ky8.j r27 = r26.b;
        if (r27 == null) goto L75;
        String r30 = r27.a;
    L76:
        if (r30 != null) goto L78;
        String r110 = "";
    L79:
        if (r27 == null) goto L81;
        String r111 = r27.b;
    L82:
        String r112 = com.larus.utils.y0.k(Uri.fromFile(r25));
        ky8.j r31 = r26.b;
        if (r31 == null) goto L87;
        Integer r32 = r31.d;
        if (r32 == null) goto L87;
        Long r33 = Boxing.boxLong(r32.intValue());
    L88:
        ky8.j r34 = r26.b;
        if (r34 == null) goto L93;
        Integer r35 = r34.c;
        if (r35 == null) goto L93;
        r7 = Boxing.boxLong(r35.intValue());
    L93:
        r7 = new MediaAttachment(r111, r110, new ImageUploadInfo(r33, r7), null, r112, null, null, null, null, null, null, null, 4072, null);
        r23.G.put("origin", r7);
    L87:
        r33 = null;
        goto L88
    L81:
        r111 = null;
        goto L82
    L78:
        r110 = r30;
        goto L79
    L75:
        r30 = null;
        goto L76
    L16:
        ResultKt.throwOnFailure(r2);
        if ((r1 instanceof ky8.k) == false) goto L95;
        MediaAttachment r36 = this.G.get("origin");
        if (r36 != null) goto L141;
        ky8.k r37 = (ky8.k) r1;
        ky8.j r38 = r37.b;
        if (r38 == null) goto L23;
        String r39 = r38.e;
    L25:
        if (com.larus.utils.o0.d(r39) == false) goto L54;
        ky8.j r40 = r37.b;
        if (r40 == null) goto L29;
        String r41 = r40.a;
    L30:
        if (r41 != null) goto L32;
        String r113 = "";
    L33:
        if (r40 == null) goto L35;
        String r114 = r40.b;
    L36:
        if (r40 == null) goto L38;
        String r42 = r40.e;
    L39:
        if (r42 == null) goto L42;
        r10 = r42;
    L42:
        String r115 = com.larus.canvas.feature.component.logic.helper.a.a(r10);
        ky8.j r43 = r37.b;
        if (r43 == null) goto L47;
        Integer r44 = r43.d;
        if (r44 == null) goto L47;
        Long r45 = Boxing.boxLong(r44.intValue());
    L48:
        ky8.j r46 = r37.b;
        if (r46 == null) goto L53;
        Integer r47 = r46.c;
        if (r47 == null) goto L53;
        r7 = Boxing.boxLong(r47.intValue());
    L53:
        r7 = new MediaAttachment(r114, r113, new ImageUploadInfo(r45, r7), null, r115, null, null, null, null, null, null, null, 4072, null);
        this.G.put("origin", r7);
    L47:
        r45 = null;
        goto L48
    L38:
        r42 = null;
        goto L39
    L35:
        r114 = null;
        goto L36
    L32:
        r113 = r41;
        goto L33
    L29:
        r41 = null;
        goto L30
    L54:
        ky8.j r48 = r37.b;
        if (r48 == null) goto L57;
        String r49 = r48.b;
    L59:
        if (com.larus.utils.o0.d(r49) == false) goto L138;
        Context r50 = getContext();
        ky8.j r51 = r37.b;
        if (r51 == null) goto L63;
        String r52 = r51.b;
    L64:
        if (r52 != null) goto L66;
        r52 = "";
    L66:
        r3.L$0 = r1;
        r3.L$1 = this;
        r3.label = 1;
        Object r53 = com.larus.canvas.feature.component.logic.helper.g.b(r50, r52, r3);
        if (r53 != r5) goto L69;
        return r5;
    L69:
        r24 = r53;
        r23 = this;
        goto L70
    L63:
        r52 = null;
        goto L64
    L57:
        r49 = null;
        goto L59
    L23:
        r39 = null;
        goto L25
    L141:
        return r36;
    L95:
        if ((r1 instanceof ky8.f) == false) goto L140;
        ky8.f r54 = (ky8.f) r1;
        MediaAttachment r55 = this.G.get(r54.a);
        if (r55 != null) goto L142;
        String r56 = r54.i();
        if (r56 != null) goto L102;
        r56 = "";
    L102:
        if (r56.length() == 0) goto L105;
        r9 = false;
    L105:
        if (r9 == false) goto L116;
        ImageData r57 = r54.h();
        if (r57 == null) goto L111;
        ImageObj r58 = r57.imageThumb;
        if (r58 == null) goto L111;
        String r59 = r58.url;
    L112:
        if (r59 == null) goto L115;
        r10 = r59;
    L115:
        r56 = r10;
    L111:
        r59 = null;
    L116:
        Context r60 = getContext();
        r3.L$0 = r1;
        r3.L$1 = r56;
        r3.label = 2;
        Object r61 = com.larus.canvas.feature.component.logic.helper.g.b(r60, r56, r3);
        if (r61 != r5) goto L119;
        return r5;
    L119:
        r12 = r56;
        r2 = r61;
        goto L120
    L142:
        return r55;
    L140:
        throw new NoWhenBranchMatchedException();
    L7:
        r3 = new GenImagePlannerComponent$getMediaAttachment$1(this, r29);
        goto L8
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final void cc(String r2, @ImageSaveStatus final int r3) {
        Intrinsics.checkNotNullParameter(r2, "localId");
        W4(r2, new o0(r3));
    }

    public final Object d5(String r12, Continuation<? super mr9.l> r13) {
        if ((r13 instanceof GenImagePlannerComponent$uploadImage$1) == false) goto L7;
        GenImagePlannerComponent$uploadImage$1 r0 = (GenImagePlannerComponent$uploadImage$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r14);
    L29:
        return r14;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
    L21:
        com.larus.bmhome.resource.access.a0 r15 = (com.larus.bmhome.resource.access.a0) r14;
        if (r15 != null) goto L30;
        return null;
    L30:
        return ICreationResourceAccessServiceKt.h(r15);
    L16:
        ResultKt.throwOnFailure(r14);
        if (z2.a.enableCreationResourceAccessPipeline() == false) goto L26;
        com.larus.bmhome.resource.access.j0 r16 = new com.larus.bmhome.resource.access.j0.b(r12, null, null, null, 30);
        r0.label = 1;
        r14 = f5(r16, true, r0);
        if (r14 != r2) goto L21;
        return r2;
    L26:
        r0.label = 2;
        r14 = h5(r12, r0);
        if (r14 != r2) goto L29;
        return r2;
    L7:
        r0 = new GenImagePlannerComponent$uploadImage$1(this, r13);
        goto L8
    }

    public final Object h5(String r10, ContinuationImpl r11) {
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r11), 1);
        r0.C();
        StringBuilder r1 = new StringBuilder();
        r1.append(UUID.randomUUID());
        r1.append('_');
        r1.append(System.currentTimeMillis());
        String r2 = r1.toString();
        this.A = r2;
        r0.i(new s1(r2));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new GenImagePlannerComponent$uploadImageLegacy$2$2(r10, this, r0, null), 2, null);
        Object r12 = r0.B();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L5:
        return r12;
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final void tM(Uri r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "uri");
        boolean r1 = true;
        this.Q = true;
        this.R = r12;
        this.B = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r11, "uri");
        ImFileUtil.a.getClass();
        String r0 = ImFileUtil.i(r11);
        if (r0 != null) goto L6;
        boolean r3 = false;
    L12:
        if (r3 == false) goto L14;
        com.larus.canvas.feature.component.logic.helper.f.a(this.m, new q0());
    L14:
        this.O = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new GenImagePlannerComponent$onAlbumSelected$2(r3, this, r11, r12, null), 2, null);
        T4("origin");
        return;
    L6:
        if (StringsKt.equals(r0, "image/heif", true) == false) goto L8;
    L11:
        r3 = r1;
        goto L12
    L8:
        if (StringsKt.equals(r0, "image/heic", true) == true) goto L11;
        r1 = false;
        goto L11
    }

    public final void v4(boolean r50, String r51) {
        my8.q r0 = W3();
        String r1 = null;
        if (r0 == null) goto L5;
        String r11 = r0.v;
    L6:
        my8.q r2 = W3();
        if (r2 == null) goto L9;
        String r13 = r2.a();
    L10:
        my8.q r3 = W3();
        if (r3 == null) goto L13;
        String r4 = r3.t;
    L14:
        my8.q r5 = W3();
        if (r5 == null) goto L17;
        String r17 = r5.q;
    L18:
        my8.q r6 = W3();
        if (r6 == null) goto L21;
        String r7 = r6.b();
    L22:
        if (r50 == false) goto L24;
        String r8 = "1";
    L25:
        String r9 = r8;
        my8.q r10 = W3();
        if (r10 == null) goto L28;
        String r19 = r10.c();
    L29:
        my8.q r12 = W3();
        if (r12 == null) goto L32;
        r1 = r12.z;
    L32:
        y3.a(r7, r4, null, r51, ReeditType.IMAGE, null, r9, null, null, r11, null, r13, null, null, null, r17, TriggerSendLoading.NO_LOADING, r19, "remote", r1, null, null, null, null, null, null, null, null, null, Long.valueOf(System.currentTimeMillis() - this.B), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -4073564, 65534);
        return;
    L28:
        r19 = null;
        goto L29
    L24:
        r8 = TriggerSendLoading.NO_LOADING;
        goto L25
    L21:
        r7 = null;
        goto L22
    L17:
        r17 = null;
        goto L18
    L13:
        r4 = null;
        goto L14
    L9:
        r13 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public static final Object B3(GenImagePlannerComponent r34, String r35, Continuation r36) {
        r34.getClass();
        if ((r36 instanceof GenImagePlannerComponent$startGenerateAndWaitRelease$1) == false) goto L7;
        GenImagePlannerComponent$startGenerateAndWaitRelease$1 r2 = (GenImagePlannerComponent$startGenerateAndWaitRelease$1) r36;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        GenImagePlannerComponent$startGenerateAndWaitRelease$1 r4 = r2;
        Object r1 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r4.label;
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L19;
        if (r5 == 2) goto L18;
        if (r5 == 3) goto L17;
        if (r5 != 4) goto L16;
        ResultKt.throwOnFailure(r1);
    L133:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        Ref.ObjectRef r7 = (Ref.ObjectRef) r4.L$2;
        ky8.f r9 = (ky8.f) r4.L$1;
        ky8.f r10 = (ky8.f) r4.L$0;
        ResultKt.throwOnFailure(r1);
    L84:
        InstructionTab r8 = (InstructionTab) r1;
        if (r8 == null) goto L87;
        r7.element = r8;
    L87:
        List<InstructionTab> r11 = r10.e.i;
        if (r11 == null) goto L94;
        List r12 = CollectionsKt.toMutableList(r11);
        if (r12 == null) goto L94;
        Object r13 = r7.element;
        if (r13 == null) goto L95;
        ListProtector.add(r12, 0, r13);
    L95:
        List r17 = r12;
        ky8.f r15 = r9;
    L97:
        ky8.j r14 = r34.c4();
        if (r14 == null) goto L100;
        Intrinsics.checkNotNullParameter(r14, "<this>");
        ImageObject r18 = new ImageObject(r14.a, r14.b, r14.d, r14.c, null, r14.f, 16, null);
    L101:
        if (r18 != null) goto L103;
        FLogger.a.e("GenImagePlannerComponent", "startGenerateAndObserve failed, not found originImageInfo");
        r34.bs("based_task_fail");
        return Unit.INSTANCE;
    L103:
        Pair<String, String> r16 = r34.j50();
        int r19 = r10.e.h;
        String r110 = r10.a;
        Long r20 = r34.XF();
        if (r15 == null) goto L114;
        List<CanvasBlock> r21 = r15.b;
        if (r21 == null) goto L114;
        CanvasBlock r22 = (CanvasBlock) CollectionsKt.firstOrNull(r21);
        if (r22 == null) goto L114;
        CanvasImageBlock r23 = r22.content;
        if (r23 == null) goto L114;
        CanvasInfo r24 = r23.canvasInfo;
        if (r24 == null) goto L114;
        Long r111 = r24.canvasSubId;
    L115:
        String r25 = r10.e.c;
        if (r16 == null) goto L118;
        String r26 = (String) r16.getFirst();
    L119:
        if (r16 == null) goto L121;
        String r27 = (String) r16.getSecond();
    L122:
        my8.q r28 = r34.W3();
        if (r28 == null) goto L125;
        String r29 = (String) r28.h.getValue();
    L126:
        ky8.c r30 = new ky8.c(r19, r110, r20, r111, r17, r18, r25, r26, r27, r29, r10.e.a());
        r4.L$0 = null;
        r4.L$1 = null;
        r4.L$2 = null;
        r4.label = 4;
        CompletableDeferred r31 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r34), null, null, new GenImagePlannerComponent$startGenerateAndObserve$2(r34, r30, r31, null), 3, null);
        Object r0 = r31.await(r4);
        if (r0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L130;
        r0 = Unit.INSTANCE;
    L130:
        if (r0 != r6) goto L133;
        return r6;
    L125:
        r29 = null;
        goto L126
    L121:
        r27 = null;
        goto L122
    L118:
        r26 = null;
    L114:
        r111 = null;
        goto L115
    L100:
        r18 = null;
    L94:
        r12 = null;
        goto L95
    L18:
        ky8.f r32 = (ky8.f) r4.L$1;
        r10 = (ky8.f) r4.L$0;
        ResultKt.throwOnFailure(r1);
    L76:
        r15 = r32;
    L79:
        if (r10.e.d == true) goto L96;
        r7 = new Ref.ObjectRef();
        ky8.i r33 = r10.e;
        InstructionTab r37 = r33.a;
        r7.element = r37;
        OptionItem r38 = r33.b;
        r4.L$0 = r10;
        r4.L$1 = r15;
        r4.L$2 = r7;
        r4.label = 3;
        r1 = r34.q4(r37, r38, r4);
        if (r1 == r6) goto L139;
        r9 = r15;
        goto L84
    L139:
        return r6;
    L96:
        r17 = null;
        goto L97
    L19:
        ResultKt.throwOnFailure(r1);
    L135:
        return Unit.INSTANCE;
    L20:
        ResultKt.throwOnFailure(r1);
        CanvasProgressViewModel.startProgress$default(r34.e4(), r35, 0, 2, null);
        ky8.f r39 = r34.O30(r35);
        if (r39 != null) goto L23;
        FLogger.a.e("GenImagePlannerComponent", "startGenerateAndWaitRelease, not found taskId = ".concat(r35));
        return Unit.INSTANCE;
    L23:
        r39.i = System.currentTimeMillis();
        com.larus.canvas.feature.component.logic.trace.a r112 = r34.X3();
        if (r112 == null) goto L26;
        r112.tR(r39);
    L26:
        ky8.h r113 = r39.c;
        boolean r114 = r113 instanceof ky8.k;
        if ((r113 instanceof ky8.f) == false) goto L29;
        ky8.f r115 = (ky8.f) r113;
    L30:
        if (r115 == null) goto L32;
        String r116 = r115.a;
    L33:
        if (r116 == null) goto L35;
        r15 = r34.O30(r116);
    L36:
        if (r15 != null) goto L42;
        if (r114 == true) goto L42;
        FLogger.a.e("GenImagePlannerComponent", "startGenerateAndWaitRelease, not found parentTask, parentTaskId = " + r116);
        r4.label = 1;
        if (j4(r34, r35, null, null, r4, 14) != r6) goto L135;
        return r6;
    L42:
        ky8.j r40 = r34.c4();
        if (r40 == null) goto L45;
        Intrinsics.checkNotNullParameter(r40, "<this>");
        ImageObject r117 = new ImageObject(r40.a, r40.b, r40.d, r40.c, null, r40.f, 16, null);
    L46:
        if (r117 == null) goto L48;
        String r41 = r117.uri;
    L49:
        if (r41 != null) goto L51;
    L54:
        boolean r42 = true;
    L55:
        if (r42 == true) goto L66;
        Integer r43 = r117.width;
        if (r43 == null) goto L59;
        int r44 = r43.intValue();
    L60:
        if (r44 == 0) goto L66;
        Integer r45 = r117.height;
        if (r45 == null) goto L64;
        int r46 = r45.intValue();
    L65:
        if (r46 == 0) goto L66;
    L70:
        CopyOnWriteArrayList<Job> r47 = r34.D;
        if (r47 == null) goto L77;
        r4.L$0 = r39;
        r4.L$1 = r15;
        r4.label = 2;
        if (AwaitKt.c(r47, r4) == r6) goto L138;
        r10 = r39;
        r32 = r15;
        goto L76
    L138:
        return r6;
    L77:
        r10 = r39;
        goto L79
    L64:
        r46 = 0;
        goto L65
    L59:
        r44 = 0;
    L66:
        if (r117 == null) goto L68;
        String r48 = r117.url;
    L69:
        r34.V3(r48);
        goto L70
    L68:
        r48 = null;
        goto L69
    L51:
        if (r41.length() == 0) goto L54;
        r42 = false;
        goto L55
    L48:
        r41 = null;
        goto L49
    L45:
        r117 = null;
        goto L46
    L35:
        r15 = null;
        goto L36
    L32:
        r116 = null;
        goto L33
    L29:
        r115 = null;
    L7:
        r2 = new GenImagePlannerComponent$startGenerateAndWaitRelease$1(r34, r36);
        goto L8
    }

    public static final void C3(GenImagePlannerComponent r11, String r12, final List r13) {
        r11.G.remove(r12);
        r11.W4(r12, new p0(r13));
        ky8.f r14 = r11.O30(r12);
        if (r14 != null) goto L5;
        return;
    L5:
        if (r11.V != null) goto L18;
        CanvasMsgInfo r0 = r14.m();
        if (r0 == null) goto L9;
        String r2 = r0.replyMsgId;
    L11:
        if (com.larus.utils.o0.d(r2) == false) goto L18;
        if (r0 == null) goto L14;
        String r3 = r0.sendMsgId;
    L16:
        if (com.larus.utils.o0.d(r3) == false) goto L18;
        r11.V = r0;
        goto L18
    L14:
        r3 = null;
        goto L16
    L9:
        r2 = null;
    L18:
        String r1 = r14.j();
        if (r1 == null) goto L21;
        r11.e4().onReceiveTaskId(r1, r12);
    L21:
        String r4 = r14.i();
        if (r4 == null) goto L28;
        if (r11.S.get(r14.a) != null) goto L28;
        r11.S.put(r14.a, Unit.INSTANCE);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r11), Dispatchers.getIO(), null, new GenImagePlannerComponent$prefetchBitmaps$1(r14, r4, null), 2, null);
    L28:
        if (r11.P > 0) goto L44;
        CanvasInfo r5 = r14.a();
        if (r5 == null) goto L34;
        Integer r6 = r5.canvasMaxCount;
        if (r6 == null) goto L34;
        int r7 = r6.intValue();
    L35:
        if (r7 <= 0) goto L44;
        CanvasInfo r8 = r14.a();
        if (r8 == null) goto L41;
        Integer r9 = r8.canvasMaxCount;
        if (r9 == null) goto L41;
        int r10 = r9.intValue();
    L42:
        r11.P = r10;
    L41:
        r10 = 0;
    L34:
        r7 = 0;
    L44:
        if (r14.l() == false) goto L49;
        Set r15 = (Set) ((LinkedHashMap) r11.J.getValue()).get(Long.valueOf(r11.H));
        if (r15 == null) goto L48;
        r15.add(r12);
        goto L49
    L48:
        ((LinkedHashMap) r11.J.getValue()).put(Long.valueOf(r11.H), SetsKt.mutableSetOf(new String[]{r12}));
    L49:
        com.larus.canvas.feature.component.logic.trace.a r16 = r11.X3();
        if (r16 == null) goto L52;
        r16.Xv(r14, true);
    L52:
        com.larus.canvas.feature.component.logic.trace.a r17 = r11.X3();
        if (r17 == null) goto L55;
        com.larus.canvas.feature.component.logic.trace.a.C0094a.a(r17, r14, false);
    L55:
        com.larus.canvas.feature.component.logic.trace.a r18 = r11.X3();
        if (r18 == null) goto L60;
        r18.Q90(r14);
        return;
    }

    public static final Object h3(GenImagePlannerComponent r5, String r6, Continuation r7) {
        r5.getClass();
        if ((r7 instanceof GenImagePlannerComponent$markStarted$1) == false) goto L7;
        GenImagePlannerComponent$markStarted$1 r0 = (GenImagePlannerComponent$markStarted$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        kotlinx.coroutines.sync.a r9 = (kotlinx.coroutines.sync.a) r0.L$1;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);
        kotlinx.coroutines.sync.a r10 = r9;
        r6 = r4;
    L23:
        r2 = Boxing.boxBoolean(r5.d4().remove(r6));     // Catch: Throwable -> L20
        r10.unlock(null);
    L19:
        return r2;
    L20:
        th = move-exception;
        r10.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r10 = (kotlinx.coroutines.sync.a) r5.M.getValue();
        r0.L$0 = r6;
        r0.L$1 = r10;
        r0.label = 1;
        if (r10.a(null, r0) != r2) goto L23;
    L7:
        r0 = new GenImagePlannerComponent$markStarted$1(r5, r7);
        goto L8
    }

    public static final Object z3(GenImagePlannerComponent r12, final ky8.j r13, Continuation r14) {
        r12.getClass();
        if ((r14 instanceof GenImagePlannerComponent$prepareRemoteImageWithPipeline$1) == false) goto L7;
        GenImagePlannerComponent$prepareRemoteImageWithPipeline$1 r0 = (GenImagePlannerComponent$prepareRemoteImageWithPipeline$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r13 = (ky8.j) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L47:
        com.larus.bmhome.resource.access.a0 r16 = (com.larus.bmhome.resource.access.a0) r15;
        if (JobKt.isActive(r0.getContext()) == true) goto L51;
        return Unit.INSTANCE;
    L51:
        if ((r16 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L85;
        com.larus.bmhome.resource.access.a0.d r17 = (com.larus.bmhome.resource.access.a0.d) r16;
        mr9.l r5 = com.larus.bmhome.resource.access.s.c(r17.a);
        if (r5 == null) goto L56;
        final String r6 = r5.a;
        if (r6 == null) goto L56;
    L57:
        if (r6 != null) goto L59;
    L60:
        r4 = true;
    L61:
        if (r4 == false) goto L63;
        r12.l4();
    L89:
        return Unit.INSTANCE;
    L63:
        if (r5 == null) goto L67;
        mr9.d r7 = r5.d;
        if (r7 == null) goto L67;
        final Integer r8 = Integer.valueOf(r7.b);
    L73:
        if (r5 == null) goto L77;
        mr9.d r9 = r5.d;
        if (r9 == null) goto L77;
        final Integer r18 = Integer.valueOf(r9.a);
    L83:
        com.larus.canvas.feature.component.logic.helper.f.a(r12.m, new l0(r13, r6, r18, r8));
        r12.v4(true, null);
    L77:
        String r19 = r17.a.f.get("height");
        if (r19 == null) goto L80;
        r18 = StringsKt.toIntOrNull(r19);
    L81:
        if (r18 != null) goto L83;
        r18 = r13.c;
        goto L83
    L80:
        r18 = null;
    L67:
        String r10 = r17.a.f.get("width");
        if (r10 == null) goto L70;
        r8 = StringsKt.toIntOrNull(r10);
    L71:
        if (r8 != null) goto L73;
        r8 = r13.d;
        goto L73
    L70:
        r8 = null;
        goto L71
    L59:
        if (r6.length() != 0) goto L61;
    L56:
        r6 = r13.a;
        goto L57
    L85:
        if (ICreationResourceAccessServiceKt.e(r16) == false) goto L87;
        r12.k4();
        goto L89
    L87:
        r12.l4();
        goto L89
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L17;
        t19.s r110 = t19.s.a;
        Context r111 = r12.getContext();
        r110.getClass();
        t19.s.s(r111, 2131908080);
        r12.bs("based_task_fail");
        r12.v4(false, "upload");
        return Unit.INSTANCE;
    L17:
        r0.L$0 = r13;
        r0.label = 1;
        String r11 = "";
        if (com.larus.utils.o0.d(r13.a) == false) goto L26;
        String r20 = r13.a;
        if (r20 == null) goto L23;
        r11 = r20;
    L23:
        com.larus.bmhome.resource.access.j0 r112 = new com.larus.bmhome.resource.access.j0.d(r11);
    L24:
        com.larus.bmhome.resource.access.j0 r21 = r112;
        StringBuilder r113 = new StringBuilder();
        r113.append(UUID.randomUUID());
        r113.append('_');
        r113.append(System.currentTimeMillis());
        String r22 = r113.toString();
        r12.A = r22;
        int r114 = com.larus.uaigc.service.p0.x;
        String r115 = r13.e;
        if (r115 != null) goto L35;
    L42:
        Map r116 = MapsKt.emptyMap();
    L43:
        r15 = r12.R4(com.larus.uaigc.service.p0.a.a(r21, r22, "canvas_remote", "canvas_remote", r116, 848), "uploadRemoteImage", r0);
    L45:
        if (r15 != r2) goto L47;
        return r2;
    L35:
        if ((!StringsKt.isBlank(r115)) == true) goto L38;
        r115 = null;
    L38:
        if (r115 == null) goto L42;
        r116 = MapsKt.mapOf(TuplesKt.to("remote_detect_local_path", r115));
        if (r116 == null) goto L42;
    L26:
        if (com.larus.utils.o0.d(r13.b) == false) goto L44;
        String r23 = r13.b;
        if (r23 == null) goto L31;
        r11 = r23;
    L31:
        r112 = new com.larus.bmhome.resource.access.j0.c(r11);
        goto L24
    L44:
        FLogger.a.e("GenImagePlannerComponent", "[uploadRemoteImage] remote canvas image source is empty");
        r15 = null;
    L7:
        r0 = new GenImagePlannerComponent$prepareRemoteImageWithPipeline$1(r12, r14);
        goto L8
    }

    public final Object B4(String r8, String r9, Continuation<? super Unit> r10) {
        Object r11 = V4(r8, new com.larus.bmhome.resource.access.j0.b(r8, null, null, null, 30), r9, false, r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    public final Object R4(com.larus.uaigc.service.p0 r6, String r7, Continuation<? super com.larus.bmhome.resource.access.a0> r8) {
        if ((r8 instanceof GenImagePlannerComponent$submitCanvasImageAccess$1) == false) goto L7;
        GenImagePlannerComponent$submitCanvasImageAccess$1 r0 = (GenImagePlannerComponent$submitCanvasImageAccess$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r7 = (String) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L22 CancellationException -> L25
    L20:
    L29:
        return (com.larus.bmhome.resource.access.a0) r9;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r9);
        CoroutineDispatcher r10 = Dispatchers.getIO();     // Catch: Throwable -> L22 CancellationException -> L25
        GenImagePlannerComponent$submitCanvasImageAccess$2 r4 = new GenImagePlannerComponent$submitCanvasImageAccess$2(r6, this, r7, null);     // Catch: Throwable -> L22 CancellationException -> L25
        r0.L$0 = r7;     // Catch: Throwable -> L22 CancellationException -> L25
        r0.label = 1;     // Catch: Throwable -> L22 CancellationException -> L25
        r9 = BuildersKt.withContext(r10, r4, r0);     // Catch: Throwable -> L22 CancellationException -> L25
        if (r9 != r2) goto L20;
        return r2;
    L25:
        e = move-exception;
        throw e;
    L22:
        th = move-exception;
        FLogger.a.e("GenImagePlannerComponent", "[" + r7 + "] observe resource access task failed", th);
        return null;
    L7:
        r0 = new GenImagePlannerComponent$submitCanvasImageAccess$1(this, r8);
        goto L8
    }

    public final Object f5(com.larus.bmhome.resource.access.j0 r37, boolean r38, ContinuationImpl r39) {
        StringBuilder r1 = new StringBuilder();
        r1.append(UUID.randomUUID());
        r1.append('_');
        r1.append(System.currentTimeMillis());
        String r5 = r1.toString();
        this.A = r5;
        int r2 = com.larus.uaigc.service.p0.x;
        com.larus.uaigc.service.p0 r3 = com.larus.uaigc.service.p0.a.a(r37, r5, null, null, null, 1016);
        Boolean r18 = Boxing.boxBoolean(r38);
        com.larus.bmhome.resource.access.x r4 = r3.a;
        ResourceMediaType r15 = r3.b;
        com.larus.bmhome.resource.access.j0 r14 = r3.c;
        String r13 = r3.d;
        String r12 = r3.e;
        String r8 = r3.f;
        mr9.h r11 = r3.g;
        Boolean r10 = r3.h;
        CountDownLatch r16 = r3.i;
        String r17 = r3.j;
        String r6 = r3.k;
        String r19 = r3.l;
        Function1 r7 = r3.m;
        Function1 r9 = r3.n;
        Function1 r110 = r3.o;
        Boolean r111 = r3.q;
        Boolean r112 = r3.r;
        Map r113 = r3.s;
        Map r114 = r3.t;
        com.larus.bmhome.resource.access.d0 r115 = r3.u;
        boolean r116 = r3.v;
        CoroutineScope r20 = r3.w;
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter(r15, "mediaType");
        Intrinsics.checkNotNullParameter(r14, "resourceInput");
        Intrinsics.checkNotNullParameter(r13, "uploadBizScene");
        Intrinsics.checkNotNullParameter(r12, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r11, "resourceCenterUploadParam");
        Intrinsics.checkNotNullParameter(r6, "uploadSourceScene");
        Intrinsics.checkNotNullParameter(r7, "processCallback");
        Intrinsics.checkNotNullParameter(r9, "successCallback");
        Intrinsics.checkNotNullParameter(r110, "failedCallback");
        Intrinsics.checkNotNullParameter(r113, "extraExt");
        Intrinsics.checkNotNullParameter(r114, "runtimeExt");
        Intrinsics.checkNotNullParameter(r115, "timeoutConfig");
        return R4(new com.larus.uaigc.service.p0(r4, r15, r14, r13, r12, r8, r11, r10, r16, r17, r6, r19, r7, r9, r110, r18, r111, r112, r113, r114, r115, r116, r20), "uploadImage", r39);
    }

    public final Object p4(mr9.l r57, String r58, Continuation<? super Unit> r59) {
        final mr9.l r1 = r57;
        if ((r59 instanceof GenImagePlannerComponent$handleOriginUploadSuccess$1) == false) goto L7;
        GenImagePlannerComponent$handleOriginUploadSuccess$1 r3 = (GenImagePlannerComponent$handleOriginUploadSuccess$1) r59;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r7 = false;
        String r8 = null;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        String r9 = (String) r3.L$1;
        mr9.l r10 = (mr9.l) r3.L$0;
        ResultKt.throwOnFailure(r2);
        final String r11 = r9;
        r1 = r10;
    L64:
        dm9.a.b r12 = (dm9.a) r2;
        boolean r13 = r12 instanceof dm9.a.b;
        if (r13 == false) goto L106;
        dm9.a.b r14 = r12;
        if (r14.a.isSuccess() == false) goto L106;
        ReviewUgcImageApi.c r15 = (ReviewUgcImageApi.c) r14.a.getData();
        if (r15 == null) goto L76;
        Integer r16 = r15.a();
        if (r16 == null) goto L76;
        if (r16.intValue() != 3) goto L76;
        boolean r17 = true;
    L77:
        if (r17 == false) goto L106;
        t19.s r18 = t19.s.a;
        Context r19 = getContext();
        r18.getClass();
        t19.s.s(r19, 2131900615);
        bs("based_task_fail");
        my8.q r20 = W3();
        if (r20 == null) goto L81;
        String r110 = r20.v;
    L82:
        my8.q r21 = W3();
        if (r21 == null) goto L85;
        String r22 = r21.a();
    L86:
        my8.q r23 = W3();
        if (r23 == null) goto L89;
        String r111 = r23.t;
    L90:
        my8.q r24 = W3();
        if (r24 == null) goto L93;
        String r25 = r24.q;
    L94:
        my8.q r26 = W3();
        if (r26 == null) goto L97;
        String r27 = r26.b();
    L98:
        my8.q r28 = W3();
        if (r28 == null) goto L101;
        String r29 = r28.c();
    L102:
        my8.q r30 = W3();
        if (r30 == null) goto L105;
        r8 = r30.z;
    L105:
        y3.a(r27, r111, null, "review", ReeditType.IMAGE, null, TriggerSendLoading.NO_LOADING, null, null, r110, null, r22, null, null, null, r25, TriggerSendLoading.NO_LOADING, r29, "album", r8, null, null, null, null, null, null, null, null, null, Boxing.boxLong(System.currentTimeMillis() - this.B), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -4073564, 65534);
    L181:
        return Unit.INSTANCE;
    L101:
        r29 = null;
        goto L102
    L97:
        r27 = null;
        goto L98
    L93:
        r25 = null;
        goto L94
    L89:
        r111 = null;
        goto L90
    L85:
        r22 = null;
        goto L86
    L81:
        r110 = null;
    L76:
        r17 = false;
    L106:
        if (r13 == false) goto L108;
    L137:
        ky8.j r31 = c4();
        if (r31 == null) goto L140;
        String r32 = r31.e;
    L141:
        if (r32 != null) goto L143;
    L152:
        com.larus.canvas.feature.component.logic.helper.f.a(this.m, new v0(r1, this, r11));
        my8.q r33 = W3();
        if (r33 == null) goto L155;
        String r112 = r33.v;
    L156:
        my8.q r34 = W3();
        if (r34 == null) goto L159;
        String r210 = r34.a();
    L160:
        my8.q r35 = W3();
        if (r35 == null) goto L163;
        String r113 = r35.t;
    L164:
        my8.q r36 = W3();
        if (r36 == null) goto L167;
        String r211 = r36.q;
    L168:
        my8.q r37 = W3();
        if (r37 == null) goto L171;
        String r38 = r37.b();
    L172:
        my8.q r39 = W3();
        if (r39 == null) goto L175;
        String r212 = r39.c();
    L176:
        my8.q r40 = W3();
        if (r40 == null) goto L179;
        r8 = r40.z;
    L179:
        y3.a(r38, r113, null, null, ReeditType.IMAGE, null, "1", null, null, r112, null, r210, null, null, null, r211, TriggerSendLoading.NO_LOADING, r212, "album", r8, null, null, null, null, null, null, null, null, null, Boxing.boxLong(System.currentTimeMillis() - this.B), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -4073556, 65534);
        goto L181
    L175:
        r212 = null;
        goto L176
    L171:
        r38 = null;
        goto L172
    L167:
        r211 = null;
        goto L168
    L163:
        r113 = null;
        goto L164
    L159:
        r210 = null;
        goto L160
    L155:
        r112 = null;
        goto L156
    L143:
        if (com.larus.utils.o0.d(r32) == true) goto L145;
    L147:
        if (r7 == true) goto L150;
        r32 = null;
    L150:
        if (r32 == null) goto L152;
        r11 = r32;
        goto L152
    L145:
        if (new PolarisFileWrapper(r32).canRead() == false) goto L147;
        r7 = true;
        goto L147
    L140:
        r32 = null;
        goto L141
    L108:
        if (NetworkUtils.isNetworkAvailable(getContext()) == true) goto L137;
        t19.s r41 = t19.s.a;
        Context r42 = getContext();
        r41.getClass();
        t19.s.s(r42, 2131908080);
        bs("based_task_fail");
        my8.q r43 = W3();
        if (r43 == null) goto L112;
        String r114 = r43.v;
    L113:
        my8.q r44 = W3();
        if (r44 == null) goto L116;
        String r213 = r44.a();
    L117:
        my8.q r45 = W3();
        if (r45 == null) goto L120;
        String r115 = r45.t;
    L121:
        my8.q r46 = W3();
        if (r46 == null) goto L124;
        String r214 = r46.q;
    L125:
        my8.q r47 = W3();
        if (r47 == null) goto L128;
        String r48 = r47.b();
    L129:
        my8.q r49 = W3();
        if (r49 == null) goto L132;
        String r215 = r49.c();
    L133:
        my8.q r50 = W3();
        if (r50 == null) goto L136;
        r8 = r50.z;
    L136:
        y3.a(r48, r115, null, "review", ReeditType.IMAGE, null, TriggerSendLoading.NO_LOADING, null, null, r114, null, r213, null, null, null, r214, TriggerSendLoading.NO_LOADING, r215, "album", r8, null, null, null, null, null, null, null, null, null, Boxing.boxLong(System.currentTimeMillis() - this.B), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -4073564, 65534);
        goto L181
    L132:
        r215 = null;
        goto L133
    L128:
        r48 = null;
        goto L129
    L124:
        r214 = null;
        goto L125
    L120:
        r115 = null;
        goto L121
    L116:
        r213 = null;
        goto L117
    L112:
        r114 = null;
        goto L113
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        if (z2.a.enableCreationResourceAccessPipeline() == false) goto L61;
        ky8.j r51 = c4();
        if (r51 == null) goto L19;
        final String r52 = r51.e;
    L20:
        if (r52 != null) goto L22;
    L31:
        r52 = r58;
    L32:
        com.larus.canvas.feature.component.logic.helper.f.a(this.m, new w0(r1, this, r52));
        my8.q r53 = W3();
        if (r53 == null) goto L35;
        String r116 = r53.v;
    L36:
        my8.q r54 = W3();
        if (r54 == null) goto L39;
        String r216 = r54.a();
    L40:
        my8.q r55 = W3();
        if (r55 == null) goto L43;
        String r117 = r55.t;
    L44:
        my8.q r56 = W3();
        if (r56 == null) goto L47;
        String r217 = r56.q;
    L48:
        my8.q r60 = W3();
        if (r60 == null) goto L51;
        String r61 = r60.b();
    L52:
        my8.q r62 = W3();
        if (r62 == null) goto L55;
        String r218 = r62.c();
    L56:
        my8.q r63 = W3();
        if (r63 == null) goto L59;
        r8 = r63.z;
    L59:
        y3.a(r61, r117, null, null, ReeditType.IMAGE, null, "1", null, null, r116, null, r216, null, null, null, r217, TriggerSendLoading.NO_LOADING, r218, "album", r8, null, null, null, null, null, null, null, null, null, Long.valueOf(System.currentTimeMillis() - this.B), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -4073556, 65534);
        return Unit.INSTANCE;
    L55:
        r218 = null;
        goto L56
    L51:
        r61 = null;
        goto L52
    L47:
        r217 = null;
        goto L48
    L43:
        r117 = null;
        goto L44
    L39:
        r216 = null;
        goto L40
    L35:
        r116 = null;
        goto L36
    L22:
        if (com.larus.utils.o0.d(r52) == true) goto L24;
    L26:
        if (r7 == true) goto L29;
        r52 = null;
    L29:
        if (r52 == null) goto L31;
    L24:
        if (new PolarisFileWrapper(r52).canRead() == false) goto L26;
        r7 = true;
        goto L26
    L19:
        r52 = null;
        goto L20
    L61:
        ReviewUgcImageApi.Companion r64 = ReviewUgcImageApi.a;
        GenImagePlannerComponent$handleOriginUploadSuccess$checkResult$1 r65 = new GenImagePlannerComponent$handleOriginUploadSuccess$checkResult$1(r1, null);
        r3.L$0 = r1;
        r11 = r58;
        r3.L$1 = r11;
        r3.label = 1;
        r64.getClass();
        r2 = ReviewUgcImageApi.Companion.a(r65, r3);
        if (r2 != r5) goto L64;
        return r5;
    L7:
        r3 = new GenImagePlannerComponent$handleOriginUploadSuccess$1(this, r59);
        goto L8
    }

    public final Object q4(InstructionTab r41, OptionItem r42, Continuation<? super InstructionTab> r43) {
        InstructionTab r2 = r41;
        OptionItem r3 = r42;
        if ((r43 instanceof GenImagePlannerComponent$mergeOptionItemIntoInstructionTab$1) == false) goto L7;
        GenImagePlannerComponent$mergeOptionItemIntoInstructionTab$1 r4 = (GenImagePlannerComponent$mergeOptionItemIntoInstructionTab$1) r43;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r0 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        boolean r9 = true;
        if (r7 == 0) goto L18;
        if (r7 != 1) goto L17;
        OptionItem r8 = (OptionItem) r4.L$1;
        InstructionTab r10 = (InstructionTab) r4.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L14
        r3 = r8;
        r2 = r10;
    L56:
        Object r1 = Result.constructor-impl((mr9.l) r0);     // Catch: Throwable -> L58
    L60:
        InstructionTab r11 = r2;
        OptionItem r12 = r3;
        if (Result.isFailure-impl(r1) == false) goto L63;
        r1 = null;
    L63:
        mr9.l r13 = (mr9.l) r1;
        if (r13 == null) goto L118;
        String r14 = r13.a;
        if (r14 == null) goto L118;
        if (r11 == null) goto L74;
        Integer r15 = r11.getTabType();
        if (r15 == null) goto L74;
        if (r15.intValue() != 4) goto L74;
        boolean r16 = true;
    L75:
        if (r16 == false) goto L95;
        OptionItem r17 = r11.getSingleOption();
        if (r17 == null) goto L92;
        OptionItem r18 = r11.getSingleOption();
        if (r18 == null) goto L82;
        MaskUri r19 = r18.getMaskUri();
        if (r19 == null) goto L82;
    L83:
        mr9.d r110 = r13.d;
        if (r110 == null) goto L86;
        Long r111 = Boxing.boxLong(r110.b);
    L87:
        mr9.d r20 = r13.d;
        if (r20 == null) goto L90;
        Long r112 = Boxing.boxLong(r20.a);
    L91:
        OptionItem r113 = OptionItem.copy$default(r17, 0, null, null, null, null, null, null, MaskUri.copy$default(r19, r14, null, r111, r112, null, null, 50, null), null, null, null, null, null, null, null, 32639, null);
    L94:
        return InstructionTab.copy$default(r11, null, null, null, null, null, null, null, r113, null, 383, null);
    L90:
        r112 = null;
        goto L91
    L86:
        r111 = null;
    L82:
        r19 = new MaskUri(null, null, null, null, null, null, 63, null);
        goto L83
    L92:
        r113 = null;
        goto L94
    L95:
        if (r11 == null) goto L102;
        Integer r21 = r11.getTabType();
        if (r21 == null) goto L102;
        if (r21.intValue() != 3) goto L102;
    L103:
        if (r9 == false) goto L118;
        if (r12 == null) goto L118;
        MaskUri r114 = r12.getMaskUri();
        if (r114 != null) goto L108;
        r114 = new MaskUri(null, null, null, null, null, null, 63, null);
    L108:
        mr9.d r22 = r13.d;
        if (r22 == null) goto L111;
        int r23 = r22.b;
    L112:
        Long r115 = Boxing.boxLong(r23);
        mr9.d r24 = r13.d;
        if (r24 == null) goto L115;
        int r25 = r24.a;
    L117:
        return InstructionTab.copy$default(r11, null, null, null, null, null, null, CollectionsKt.listOf(OptionItem.copy$default(r12, 0, null, null, null, null, null, null, MaskUri.copy$default(r114, r14, null, r115, Boxing.boxLong(r25), null, null, 50, null), null, null, null, null, null, null, null, 32639, null)), null, null, 447, null);
    L115:
        r25 = 0;
        goto L117
    L111:
        r23 = 0;
    L102:
        r9 = false;
    L74:
        r16 = false;
    L118:
        r2 = r11;
    L120:
        if (r12 == null) goto L125;
        if (r2 != null) goto L130;
        return null;
    L130:
        return InstructionTab.copy$default(r2, null, null, null, null, null, null, CollectionsKt.listOf(r12), null, null, 447, null);
    L125:
        return r2;
    L58:
        Throwable th = th;
    L59:
        Result.Companion r26 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
    L14:
        th = th;
        r3 = r8;
        r2 = r10;
        goto L59
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        if (r2 == null) goto L21;
        Integer r27 = r41.getTabType();
    L22:
        String r28 = "";
        if (r27 != null) goto L26;
    L35:
        if (r27 != null) goto L38;
    L46:
        String r29 = null;
    L48:
        if (com.larus.utils.o0.d(r29) == true) goto L128;
        r12 = r3;
        goto L120
    L128:
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L58
        if (r29 == null) goto L53;
        r28 = r29;
    L53:
        r4.L$0 = r2;     // Catch: Throwable -> L58
        r4.L$1 = r3;     // Catch: Throwable -> L58
        r4.label = 1;     // Catch: Throwable -> L58
        r0 = d5(r28, r4);     // Catch: Throwable -> L58
        if (r0 != r6) goto L56;
        return r6;
    L38:
        if (r27.intValue() != 3) goto L46;
        if (r3 == null) goto L43;
        MaskUri r30 = r42.getMaskUri();
        if (r30 == null) goto L43;
        r29 = r30.getLocalFilePath();
    L44:
        if (r29 != null) goto L48;
    L34:
        r29 = "";
    L43:
        r29 = null;
        goto L44
    L26:
        if (r27.intValue() != 4) goto L35;
        OptionItem r31 = r41.getSingleOption();
        if (r31 == null) goto L32;
        MaskUri r32 = r31.getMaskUri();
        if (r32 == null) goto L32;
        r29 = r32.getLocalFilePath();
    L33:
        if (r29 != null) goto L48;
    L32:
        r29 = null;
        goto L33
    L21:
        r27 = null;
    L7:
        r4 = new GenImagePlannerComponent$mergeOptionItemIntoInstructionTab$1(this, r43);
        goto L8
    }

    public static final void Y2(GenImagePlannerComponent r6, String r7, String r8, com.larus.bmhome.resource.access.a0 r9) {
        r6.getClass();
        if ((r9 instanceof com.larus.bmhome.resource.access.a0.e) == false) goto L6;
        FLogger r10 = FLogger.a;
        StringBuilder r3 = new StringBuilder("[");
        r3.append(r7);
        r3.append("] node=");
        com.larus.bmhome.resource.access.a0.e r11 = (com.larus.bmhome.resource.access.a0.e) r9;
        r3.append(r11.b);
        r3.append(", stage=");
        r3.append(r11.a);
        r3.append(", taskId=");
        r3.append(r8);
        r10.i("GenImagePlannerComponent", r3.toString());
        return;
    L6:
        if ((r9 instanceof com.larus.bmhome.resource.access.a0.f) == false) goto L9;
        FLogger.a.i("GenImagePlannerComponent", "[" + r7 + "] uploading progress=" + ((com.larus.bmhome.resource.access.a0.f) r9).a + ", taskId=" + r8);
        return;
    L9:
        if ((r9 instanceof com.larus.bmhome.resource.access.a0.c) == false) goto L15;
        com.larus.bmhome.resource.access.a0.c r12 = (com.larus.bmhome.resource.access.a0.c) r9;
        Throwable r13 = r12.a.d;
        if (r13 == null) goto L13;
        FLogger.a.e("GenImagePlannerComponent", "[" + r7 + "] resource access failed, code=" + r12.a.b + ", message=" + r12.a.c, r13);
        return;
    L13:
        FLogger.a.e("GenImagePlannerComponent", "[" + r7 + "] resource access failed, code=" + r12.a.b + ", message=" + r12.a.c);
        return;
    L15:
        if ((r9 instanceof com.larus.bmhome.resource.access.a0.a) == false) goto L18;
        FLogger.a.i("GenImagePlannerComponent", "[" + r7 + "] resource access cancelled, reason=" + ((com.larus.bmhome.resource.access.a0.a) r9).a.name());
        return;
    L18:
        if (Intrinsics.areEqual(r9, com.larus.bmhome.resource.access.a0.b.a) == false) goto L20;
        return;
    L20:
        if ((r9 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L23;
        return;
    L23:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object p3(GenImagePlannerComponent r6, String r7, List r8, Continuation r9) {
        r6.getClass();
        if ((r9 instanceof GenImagePlannerComponent$prepareNoWatermarkBlocksForDisplay$1) == false) goto L7;
        GenImagePlannerComponent$prepareNoWatermarkBlocksForDisplay$1 r0 = (GenImagePlannerComponent$prepareNoWatermarkBlocksForDisplay$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        List r11 = (List) r0.L$2;
        r8 = (List) r0.L$1;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r10);
        List r12 = r11;
        r7 = r4;
    L35:
        r6.F4(r7, r8);
        FLogger.a.i("GenImagePlannerComponent", "prepare canvas no watermark blocks, localId=" + r7 + ", imageCount=" + r12.size());
        return r8;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        CanvasBlock r13 = (CanvasBlock) CollectionsKt.firstOrNull(r8);
        if (r13 == null) goto L26;
        CanvasImageBlock r14 = r13.content;
        if (r14 == null) goto L26;
        CanvasInfo r15 = r14.canvasInfo;
        if (r15 == null) goto L26;
        Integer r16 = r15.canvasStatus;
        if (r16 == null) goto L26;
        if (r16.intValue() != 10) goto L26;
        boolean r17 = true;
    L27:
        if (r17 == false) goto L38;
        r12 = Q3(r8);
        if (((ArrayList) r12).isEmpty() == true) goto L39;
        CoroutineDispatcher r5 = Dispatchers.getIO();
        GenImagePlannerComponent$prepareNoWatermarkBlocksForDisplay$2 r18 = new GenImagePlannerComponent$prepareNoWatermarkBlocksForDisplay$2(r12, null);
        r0.L$0 = r7;
        r0.L$1 = r8;
        r0.L$2 = r12;
        r0.label = 1;
        if (BuildersKt.withContext(r5, r18, r0) != r2) goto L35;
        return r2;
    L39:
        return r8;
    L38:
        return r8;
    L26:
        r17 = false;
    L7:
        r0 = new GenImagePlannerComponent$prepareNoWatermarkBlocksForDisplay$1(r6, r9);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    public final Object V4(String r59, com.larus.bmhome.resource.access.j0 r60, String r61, boolean r62, Continuation<? super Unit> r63) {
        if ((r63 instanceof GenImagePlannerComponent$updateAndUploadOriginImage$1) == false) goto L7;
        Continuation<? super Unit> r2 = (GenImagePlannerComponent$updateAndUploadOriginImage$1) r63;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        String r9 = null;
        if (r5 == 0) goto L22;
        if (r5 == 1) goto L21;
        if (r5 == 2) goto L20;
        if (r5 == 3) goto L17;
        if (r5 != 4) goto L16;
        ResultKt.throwOnFailure(r0);
    L113:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        String r6 = (String) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L98
        r5 = r6;
    L96:
        Object r1 = Result.constructor-impl((mr9.l) r0);     // Catch: Throwable -> L98
        String r7 = r5;
    L101:
        if (Result.isFailure-impl(r1) == false) goto L103;
        r1 = null;
    L103:
        mr9.l r8 = (mr9.l) r1;
        if (r8 == null) goto L106;
        String r10 = r8.a;
    L108:
        if (com.larus.utils.o0.d(r10) == false) goto L114;
        Intrinsics.checkNotNull(r8);
        r2.L$0 = null;
        r2.label = 4;
        if (p4(r8, r7, r2) != r4) goto L113;
        return r4;
    L114:
        l4();
    L144:
        return Unit.INSTANCE;
    L106:
        r10 = null;
        goto L108
    L20:
        ResultKt.throwOnFailure(r0);
    L88:
        return Unit.INSTANCE;
    L21:
        boolean r11 = r2.Z$0;
        String r12 = (String) r2.L$0;
        ResultKt.throwOnFailure(r0);
        Object r13 = r0;
        String r14 = r12;
    L70:
        com.larus.bmhome.resource.access.a0 r15 = (com.larus.bmhome.resource.access.a0) r13;
    L71:
        boolean r57 = r11;
        String r16 = r14;
        if (JobKt.isActive(r2.getContext()) == false) goto L144;
        if (r57 == false) goto L93;
        if (r15 == null) goto L78;
        mr9.l r17 = ICreationResourceAccessServiceKt.h(r15);
    L79:
        if (r17 == null) goto L81;
        String r18 = r17.a;
    L83:
        if (com.larus.utils.o0.d(r18) == false) goto L90;
        Intrinsics.checkNotNull(r17);
        r2.L$0 = null;
        r2.label = 2;
        if (p4(r17, r16, r2) != r4) goto L88;
        return r4;
    L90:
        if (ICreationResourceAccessServiceKt.e(r15) == false) goto L92;
        k4();
        goto L144
    L92:
        l4();
        goto L144
    L81:
        r18 = null;
        goto L83
    L78:
        r17 = null;
        goto L79
    L93:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L98
        r2.L$0 = r16;     // Catch: Throwable -> L98
        r2.label = 3;     // Catch: Throwable -> L98
        r0 = h5(r16, r2);     // Catch: Throwable -> L98
        r5 = r16;
        if (r0 != r4) goto L96;
        return r4;
    L22:
        ResultKt.throwOnFailure(r0);
        ky8.h r20 = ((ky8.g) this.n.getValue()).a.get("origin");
        if ((r20 instanceof ky8.k) == false) goto L25;
        ky8.k r21 = (ky8.k) r20;
    L26:
        if (r21 == null) goto L30;
        ky8.j r22 = r21.b;
        if (r22 == null) goto L30;
        String r23 = r22.e;
    L31:
        if (r61 != null) goto L45;
        if (r23 != null) goto L34;
    L41:
        r23 = null;
    L42:
        if (r23 != null) goto L44;
        String r110 = r59;
    L46:
        Pair<Integer, Integer> r24 = com.larus.canvas.feature.component.logic.helper.g.c(UriProtector.parse(com.larus.canvas.feature.component.logic.helper.a.a(r59)));
        if (r24 == null) goto L49;
        Integer r111 = Boxing.boxInt(((Number) r24.getFirst()).intValue());
    L53:
        Integer r112 = r111;
    L55:
        if (r24 == null) goto L57;
        Integer r25 = Boxing.boxInt(((Number) r24.getSecond()).intValue());
    L61:
        Integer r113 = r25;
    L63:
        final ky8.j r26 = new ky8.j(null, null, r113, r112, r110, Boxing.boxBoolean(this.R), 3);
        com.larus.canvas.feature.component.logic.helper.f.a(this.m, new u0(r26));
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == false) goto L115;
        r11 = z2.a.enableCreationResourceAccessPipeline();
        if (r11 == false) goto L72;
        r14 = r59;
        r2.L$0 = r14;
        r2.Z$0 = r11;
        r2.label = 1;
        r13 = f5(r60, r62, r2);
        if (r13 != r4) goto L70;
        return r4;
    L72:
        r14 = r59;
        r15 = null;
        goto L71
    L115:
        t19.s r27 = t19.s.a;
        Context r28 = getContext();
        r27.getClass();
        t19.s.s(r28, 2131908080);
        bs("based_task_fail");
        my8.q r29 = W3();
        if (r29 == null) goto L118;
        String r114 = r29.v;
    L119:
        my8.q r30 = W3();
        if (r30 == null) goto L122;
        String r210 = r30.a();
    L123:
        my8.q r31 = W3();
        if (r31 == null) goto L126;
        String r115 = r31.t;
    L127:
        my8.q r32 = W3();
        if (r32 == null) goto L130;
        String r211 = r32.q;
    L131:
        my8.q r33 = W3();
        if (r33 == null) goto L134;
        String r116 = r33.b();
    L135:
        my8.q r34 = W3();
        if (r34 == null) goto L138;
        String r212 = r34.c();
    L139:
        my8.q r35 = W3();
        if (r35 == null) goto L142;
        r9 = r35.z;
    L142:
        y3.a(r116, r115, null, "upload", ReeditType.IMAGE, null, TriggerSendLoading.NO_LOADING, null, null, r114, null, r210, null, null, null, r211, TriggerSendLoading.NO_LOADING, r212, "album", r9, null, null, null, null, null, null, null, null, null, Boxing.boxLong(System.currentTimeMillis() - this.B), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -4073564, 65534);
        goto L144
    L138:
        r212 = null;
        goto L139
    L134:
        r116 = null;
        goto L135
    L130:
        r211 = null;
        goto L131
    L126:
        r115 = null;
        goto L127
    L122:
        r210 = null;
        goto L123
    L118:
        r114 = null;
        goto L119
    L57:
        if (r21 == null) goto L62;
        ky8.j r36 = r21.b;
        if (r36 == null) goto L62;
        r25 = r36.c;
    L62:
        r113 = null;
        goto L63
    L49:
        if (r21 == null) goto L54;
        ky8.j r117 = r21.b;
        if (r117 == null) goto L54;
        r111 = r117.d;
    L54:
        r112 = null;
        goto L55
    L44:
        r110 = r23;
        goto L46
    L34:
        if (com.larus.utils.o0.d(r23) == true) goto L36;
    L38:
        boolean r118 = false;
    L39:
        if (r118 == false) goto L41;
    L36:
        if (new PolarisFileWrapper(r23).canRead() == false) goto L38;
        r118 = true;
        goto L39
    L45:
        r110 = r61;
    L30:
        r23 = null;
        goto L31
    L25:
        r21 = null;
    L98:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        r7 = r5;
    L7:
        r2 = new GenImagePlannerComponent$updateAndUploadOriginImage$1(this, r63);
        goto L8
    }

    @Override // com.larus.canvas.feature.component.logic.n2
    public final void h70(InstructionTab r17, OptionItem r18, String r19, boolean r20, String r21) {
        Intrinsics.checkNotNullParameter(r21, "scene");
        if (NetworkUtils.isNetworkAvailable(getContext()) == true) goto L7;
        FLogger.a.i("GenImagePlannerComponent", "startGenerate failed, no network");
        t19.s r0 = t19.s.a;
        Context r1 = getContext();
        r0.getClass();
        t19.s.s(r1, 2131908080);
        return;
    L7:
        if (c4() != null) goto L10;
        FLogger.a.e("GenImagePlannerComponent", "startGenerate failed, not found originImageInfo");
        return;
    L10:
        int r2 = ((ky8.g) this.n.getValue()).a.size();
        int r3 = this.P;
        if (r3 > 0) goto L13;
        r3 = ((hq9.r0) this.E.getValue()).h;
    L13:
        boolean r4 = true;
        if (r2 <= r3) goto L20;
        FLogger.a.i("GenImagePlannerComponent", "startGenerate failed, canvas cnt over limit");
        if ((!d4().isEmpty()) == false) goto L18;
        t19.s r5 = t19.s.a;
        Context r6 = getContext();
        r5.getClass();
        t19.s.s(r6, 2131900612);
        return;
    L18:
        t19.s r7 = t19.s.a;
        Context r8 = getContext();
        r7.getClass();
        t19.s.s(r8, 2131900611);
        return;
    L20:
        ky8.h r9 = (ky8.h) ((Pair) this.q.getValue()).getSecond();
        if (r9 != null) goto L23;
        return;
    L23:
        boolean r10 = false;
        String r11 = null;
        if (r17 == null) goto L57;
        if (r18 != null) goto L45;
        Integer r12 = r17.getTabType();
        if (r12 != null) goto L30;
    L43:
        FLogger.a.e("GenImagePlannerComponent", "startGenerate failed, optionItem = null but instructionTab is not MSG_INSTRUCTION");
        return;
    L30:
        if (r12.intValue() != 4) goto L43;
        OptionItem r13 = r17.getSingleOption();
        if (r13 == null) goto L34;
        String r14 = r13.getRedirectSchema();
    L36:
        if (com.larus.utils.o0.d(r14) == false) goto L55;
        OptionItem r15 = r17.getSingleOption();
        if (r15 == null) goto L40;
        MaskUri r16 = r15.getMaskUri();
    L41:
        if (r16 != null) goto L55;
    L56:
        String r22 = null;
        r10 = r4;
    L58:
        if (r10 == false) goto L77;
        if (r17 == null) goto L77;
        if ((r9 instanceof ky8.k) == false) goto L68;
        if (this.Q == false) goto L65;
        return;
    L65:
        if (((ky8.k) r9).b == null) goto L149;
    L73:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GenImagePlannerComponent$handleEraseClickEvent$1(this, r9, r17, r18, null), 3, null);
        return;
    L149:
        return;
    L68:
        if ((r9 instanceof ky8.f) == false) goto L76;
        if (((ky8.f) r9).k() == false) goto L73;
        t19.s r23 = t19.s.a;
        Context r24 = getContext();
        r23.getClass();
        t19.s.s(r24, 2131900614);
        return;
    L76:
        throw new NoWhenBranchMatchedException();
    L77:
        fy8.i r25 = (fy8.i) this.t.getValue();
        if (r25 == null) goto L80;
        r25.J3();
    L80:
        if (r17 != null) goto L85;
        if (r18 != null) goto L85;
        fy8.i r26 = (fy8.i) this.t.getValue();
        if (r26 == null) goto L85;
        fy8.i.a.a(r26, "", 24);
    L85:
        com.larus.canvas.feature.component.logic.helper.h r27 = (com.larus.canvas.feature.component.logic.helper.h) com.larus.canvas.feature.component.logic.canvasGenerator.h.c.getValue();
        monitor-enter(r27);
        long r28 = Math.max(System.currentTimeMillis(), r27.k + (SystemClock.elapsedRealtime() - r27.l));     // Catch: Throwable -> L141
        if (r28 != r27.i) goto L97;
        r27.j = (r27.j + 1) & r27.e;     // Catch: Throwable -> L141
        if (r27.j != 0) goto L108;
        long r110 = System.currentTimeMillis();     // Catch: Throwable -> L141
    L93:
        if (r110 > r28) goto L95;
        r110 = System.currentTimeMillis();     // Catch: Throwable -> L141
        goto L93
    L95:
        r28 = r110;
    L108:
        r27.i = r28;     // Catch: Throwable -> L141
        long r29 = ((((r28 - r27.c) << r27.h) | (r27.b << r27.g)) | (r27.a << r27.f)) | r27.j;
        monitor-exit(r27);
        String r30 = String.valueOf(r29);
        if (r20 == false) goto L138;
        boolean r31 = r9 instanceof ky8.f;
        if (r31 == false) goto L116;
        ky8.f r32 = (ky8.f) r9;
    L117:
        if (r32 == null) goto L121;
        ky8.i r33 = r32.e;
        if (r33 == null) goto L121;
        InstructionTab r34 = r33.a;
    L122:
        if (r31 == false) goto L124;
        ky8.f r35 = (ky8.f) r9;
    L125:
        if (r35 == null) goto L129;
        ky8.i r36 = r35.e;
        if (r36 == null) goto L129;
        OptionItem r37 = r36.b;
    L130:
        if (r31 == false) goto L132;
        ky8.f r38 = (ky8.f) r9;
    L133:
        if (r38 == null) goto L137;
        ky8.i r39 = r38.e;
        if (r39 == null) goto L137;
        r11 = r39.c;
    L137:
        E3(r30, r34, r37, r11, true, r9, r21);
    L139:
        T4(r30);
        return;
    L132:
        r38 = null;
    L129:
        r37 = null;
        goto L130
    L124:
        r35 = null;
    L121:
        r34 = null;
        goto L122
    L116:
        r32 = null;
        goto L117
    L138:
        E3(r30, r17, r18, r22, false, r9, r21);
        goto L139
    L97:
        if (r28 < r27.i) goto L99;
        r27.j = 0;     // Catch: Throwable -> L141
        goto L108
    L99:
        if ((r27.i - r28) > r27.d) goto L105;
        long r40 = r27.i;     // Catch: Throwable -> L141
        long r111 = System.currentTimeMillis();     // Catch: Throwable -> L141
    L102:
        if (r111 >= r40) goto L104;
        r111 = System.currentTimeMillis();     // Catch: Throwable -> L141
        goto L102
    L104:
        r28 = r111;
        long r112 = 0;
    L106:
        r27.j = r112;     // Catch: Throwable -> L141
        goto L108
    L105:
        r28 = Math.max(r27.i, r27.k + (SystemClock.elapsedRealtime() - r27.l));     // Catch: Throwable -> L141
        r112 = 0;
    L141:
        th = move-exception;
        throw th;
    L40:
        r16 = null;
    L55:
        r4 = false;
        goto L56
    L34:
        r14 = null;
        goto L36
    L45:
        Integer r41 = r17.getTabType();
        if (r41 == null) goto L55;
        if (r41.intValue() != 3) goto L55;
        if (com.larus.utils.o0.d(r18.getRedirectSchema()) == false) goto L55;
        if (r18.getMaskUri() != null) goto L55;
    L57:
        r22 = r19;
        goto L58
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v35 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6, types: [android.app.Activity, com.larus.canvas.feature.CreationCanvasActivity] */
    /* JADX WARN: Type inference failed for: r30v0, types: [android.app.Activity] */
    public final Object i4(String r37, List<CanvasBlock> r38, String r39, boolean r40, Continuation<? super Unit> r41) {
        String r2 = r37;
        List<CanvasBlock> r3 = r38;
        if ((r41 instanceof GenImagePlannerComponent$handleGenerateFail$1) == false) goto L7;
        GenImagePlannerComponent$handleGenerateFail$1 r4 = (GenImagePlannerComponent$handleGenerateFail$1) r41;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r0 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        String r9 = null;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        String r8 = (String) r4.L$2;
        r3 = (List) r4.L$1;
        String r10 = (String) r4.L$0;
        ResultKt.throwOnFailure(r0);
        Object r11 = r8;
        r2 = r10;
    L210:
        com.larus.canvas.feature.component.logic.trace.h r1 = com.larus.canvas.feature.component.logic.trace.h.a;
        if (r11 != null) goto L221;
        if (r3 == null) goto L220;
        CanvasBlock r12 = (CanvasBlock) CollectionsKt.firstOrNull(r3);
        if (r12 == null) goto L220;
        CanvasImageBlock r13 = r12.content;
        if (r13 == null) goto L220;
        CanvasInfo r14 = r13.canvasInfo;
        if (r14 == null) goto L220;
        r11 = r14.errCode;
    L220:
        r11 = null;
    L221:
        if (r11 == null) goto L223;
        String r15 = r11.toString();
    L224:
        if (r3 == null) goto L228;
        CanvasBlock r16 = (CanvasBlock) CollectionsKt.firstOrNull(r3);
        if (r16 == null) goto L228;
        r9 = r16.logId;
    L228:
        r1.getClass();
        com.larus.canvas.feature.component.logic.trace.h.a(r2, false, r15, r9);
        return Unit.INSTANCE;
    L223:
        r15 = null;
        goto L224
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        if (this.F.contains(r2) == false) goto L19;
        return Unit.INSTANCE;
    L19:
        if (((ky8.g) this.n.getValue()).a.containsKey(r2) == false) goto L21;
        this.F.add(r2);
        ky8.h r17 = (ky8.h) ((Pair) this.q.getValue()).getSecond();
        int r18 = ((Number) ((Pair) this.q.getValue()).getFirst()).intValue();
        com.larus.canvas.feature.component.logic.helper.c.a.getClass();
        if (r3 != null) goto L25;
        List<CanvasBlock> r19 = CollectionsKt.emptyList();
    L26:
        Iterator r110 = r19.iterator();
    L28:
        if (r110.hasNext() == false) goto L90;
        CanvasImageBlock r20 = ((CanvasBlock) r110.next()).content;
        if (r20 == null) goto L87;
        CanvasInfo r21 = r20.canvasInfo;
        if (r21 == null) goto L87;
        Long r111 = r21.errCode;
        if (r111 == null) goto L87;
        if (r111.longValue() != 20000008) goto L87;
        Map<String, String> r22 = r21.ext;
        if (r22 == null) goto L44;
        String r23 = r22.get("cta_result");
    L45:
        com.larus.canvas.feature.component.logic.helper.c.a.getClass();
        if (r23 != null) goto L48;
    L51:
        boolean r112 = true;
    L52:
        if (r112 == true) goto L87;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L56
        Object r24 = Result.constructor-impl((QuotaCtaResult) com.larus.canvas.feature.component.logic.helper.c.b.fromJson(r23, QuotaCtaResult.class));     // Catch: Throwable -> L56
    L58:
        Throwable r114 = Result.exceptionOrNull-impl(r24);
        if (r114 == null) goto L62;
        FLogger.a.e("CanvasMemberQuotaPush", "parse push info failed", r114);
    L62:
        if (Result.isFailure-impl(r24) == false) goto L64;
        r24 = null;
    L64:
        QuotaCtaResult r25 = (QuotaCtaResult) r24;
        if (r25 == null) goto L87;
        com.larus.canvas.feature.component.logic.helper.c.a.getClass();
        String r115 = r25.getCtaGuideTitle();
        if (r115 != null) goto L69;
    L72:
        boolean r116 = true;
    L73:
        if (r116 == false) goto L84;
        String r117 = r25.getGuideContent();
        if (r117 != null) goto L77;
    L80:
        boolean r118 = true;
    L81:
        if (r118 == false) goto L84;
        boolean r119 = false;
    L85:
        if (r119 == false) goto L87;
    L88:
        if (r25 == null) goto L28;
    L91:
        String r120 = "";
        if (r25 == null) goto L175;
        com.larus.canvas.feature.component.logic.helper.c r121 = com.larus.canvas.feature.component.logic.helper.c.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r122 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        r121.getClass();
        Intrinsics.checkNotNullParameter(r122, "fragment");
        Intrinsics.checkNotNullParameter(r25, "pushInfo");
        CreationCanvasActivity r123 = r122.getActivity();
        if ((r123 instanceof CreationCanvasActivity) == false) goto L96;
        ?? r124 = r123;
    L98:
        if (r122.isAdded() == true) goto L100;
    L174:
        FLogger.a.i("CanvasMemberQuotaPush", "skip show, fragment or activity is not active");
    L194:
        e4().cancelProgress(r2);
        if ((r17 instanceof ky8.f) == false) goto L197;
        ky8.f r26 = (ky8.f) r17;
    L198:
        if (r26 == null) goto L200;
        String r27 = r26.a;
    L202:
        if (Intrinsics.areEqual(r27, r2) == false) goto L204;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GenImagePlannerComponent$handleGenerateFail$2(this, r2, r18, null), 3, null);
    L205:
        if (r40 == false) goto L209;
        r4.L$0 = r2;
        r4.L$1 = r3;
        r11 = r39;
        r4.L$2 = r11;
        r4.label = 1;
        if (G3(r2, r4) != r6) goto L210;
        return r6;
    L209:
        r11 = r39;
        goto L210
    L204:
        W4(r2, new m0());
        goto L205
    L200:
        r27 = null;
        goto L202
    L197:
        r26 = null;
        goto L198
    L100:
        if (r122.isResumed() == false) goto L174;
        if (r124 == 0) goto L174;
        if (r124.isFinishing() == true) goto L174;
        if (r124.isDestroyed() == true) goto L174;
        String r125 = r25.getActionUrl();
        if (r125 != null) goto L110;
    L113:
        boolean r126 = true;
    L114:
        if (r126 == true) goto L129;
        Uri r127 = com.larus.canvas.feature.component.logic.helper.c.b(r125);
        if (r127 == null) goto L129;
        String r128 = com.larus.canvas.feature.component.logic.helper.c.d(r127);
        if (r128 != null) goto L122;
    L125:
        boolean r129 = true;
    L126:
        if (r129 == false) goto L128;
        r125 = com.larus.canvas.feature.component.logic.helper.c.a(r125);
        goto L129
    L128:
        r125 = com.larus.canvas.feature.component.logic.helper.c.c(r127, MapsKt.mapOf(TuplesKt.to("target_url", com.larus.canvas.feature.component.logic.helper.c.a(r128)))).toString();
        goto L129
    L122:
        if (StringsKt.isBlank(r128) == true) goto L125;
        r129 = false;
    L129:
        NotificationType r28 = NotificationType.QUOTA_LIMIT;
        String r29 = r25.getCtaGuideTitle();
        if (r29 != null) goto L132;
        String r130 = "";
    L133:
        String r30 = r25.getGuideContent();
        if (r30 != null) goto L136;
        String r131 = "";
    L137:
        String r31 = r25.getImageUrl();
        if (r31 != null) goto L140;
        String r132 = "";
    L141:
        boolean r32 = d3.a.c(new n3(null, r132, r130, r131, r28, r25.getDisplayDurationMSec(), "canvas_creation", CollectionsKt.listOf("creation_canvas"), new com.larus.canvas.feature.component.logic.helper.b(r125, r124), null, null, null, null, r124, false, null, false, null, 1014785));
        FLogger.a.i("CanvasMemberQuotaPush", "show member quota push result=" + r32);
        if (r125 != null) goto L144;
    L147:
        boolean r33 = true;
    L148:
        if (r33 == true) goto L194;
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r133 = ICommerceMembershipService.a.a();
        if (r133 == null) goto L194;
        Uri r34 = com.larus.canvas.feature.component.logic.helper.c.b(r125);
        if (r34 == null) goto L160;
        String r35 = com.larus.canvas.feature.component.logic.helper.c.d(r34);
        if (r35 == null) goto L160;
        r125 = r35;
    L160:
        uz8.c r36 = r133.z(r125);
        if (r36 == null) goto L163;
        String r134 = r36.b;
    L164:
        if (r36 == null) goto L166;
        String r135 = r36.c;
    L167:
        if (r36 == null) goto L169;
        String r210 = r36.d;
    L170:
        if (r36 == null) goto L172;
        String r211 = r36.f;
    L173:
        ICommerceMembershipService$b.b(r133, "in_app_push", "image_generate_canvas", r134, r135, r210, r211, null, null, null, null, null, null, 4032);
        goto L194
    L172:
        r211 = null;
        goto L173
    L169:
        r210 = null;
        goto L170
    L166:
        r135 = null;
        goto L167
    L163:
        r134 = null;
        goto L164
    L144:
        if (StringsKt.isBlank(r125) == true) goto L147;
        r33 = false;
        goto L148
    L140:
        r132 = r31;
        goto L141
    L136:
        r131 = r30;
        goto L137
    L132:
        r130 = r29;
        goto L133
    L110:
        if (StringsKt.isBlank(r125) == true) goto L113;
        r126 = false;
        goto L114
    L96:
        r124 = 0;
        goto L98
    L175:
        if (r3 == null) goto L183;
        CanvasBlock r42 = (CanvasBlock) CollectionsKt.firstOrNull(r38);
        if (r42 == null) goto L183;
        CanvasImageBlock r43 = r42.content;
        if (r43 == null) goto L183;
        CanvasInfo r44 = r43.canvasInfo;
        if (r44 == null) goto L183;
        String r45 = r44.errMsg;
    L184:
        if (r45 == null) goto L188;
        r120 = r45;
    L188:
        if (r120.length() != 0) goto L190;
        boolean r46 = true;
    L191:
        if (r46 == false) goto L193;
        r120 = ContextCompat.getString(getContext(), 2131900604);
    L193:
        t19.s r47 = t19.s.a;
        Context r48 = getContext();
        r47.getClass();
        t19.s.t(r48, r120);
        goto L194
    L190:
        r46 = false;
    L183:
        r45 = null;
        goto L184
    L77:
        if (StringsKt.isBlank(r117) == true) goto L80;
        r118 = false;
    L84:
        r119 = true;
        goto L85
    L69:
        if (StringsKt.isBlank(r115) == true) goto L72;
        r116 = false;
    L56:
        th = move-exception;
        Result.Companion r136 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L48:
        if (StringsKt.isBlank(r23) == true) goto L51;
        r112 = false;
        goto L52
    L44:
        r23 = null;
    L87:
        r25 = null;
        goto L88
    L90:
        r25 = null;
        goto L91
    L25:
        r19 = r3;
        goto L26
    L21:
        return Unit.INSTANCE;
    L7:
        r4 = new GenImagePlannerComponent$handleGenerateFail$1(this, r41);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object j4(GenImagePlannerComponent r8, String r9, List r10, String r11, Continuation r12, int r13) {
        if ((r13 & 2) == 0) goto L5;
        List r4 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r13 & 8) == 0) goto L13;
        boolean r6 = true;
    L15:
        return r8.i4(r9, r4, r5, r6, r12);
    L13:
        r6 = false;
        goto L15
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }

    public final void E3(final String r17, final InstructionTab r18, final OptionItem r19, final String r20, final boolean r21, final ky8.h r22, final String r23) {
        o2 r0 = (o2) this.w.getValue();
        if (r0 == null) goto L5;
        r0.n80(r17);
    L5:
        e4().createProgressMocker(r17);
        if (((ky8.g) this.n.getValue()).a.size() != 1) goto L8;
        CanvasProgressViewModel.startProgress$default(e4(), r17, 0, 2, null);
    L8:
        if (r21 == false) goto L10;
        final int r9 = 2;
    L19:
        final Ref.ObjectRef r15 = new Ref.ObjectRef();
        com.larus.canvas.feature.component.logic.helper.f.a(this.m, new r0(r17, r22, this, r18, r19, r20, r21, r23, r9, r15));
        this.C = new t0(r17, this);
        ky8.f r1 = (ky8.f) r15.element;
        if (r1 != null) goto L22;
    L29:
        Set<String> r2 = h4().get(Long.valueOf(this.H));
        if (r2 == null) goto L32;
        r2.add(r17);
        return;
    L32:
        h4().put(Long.valueOf(this.H), SetsKt.mutableSetOf(new String[]{r17}));
        return;
    L22:
        if ((!r1.e.d) == true) goto L25;
        r1 = null;
    L25:
        if (r1 == null) goto L29;
        com.larus.canvas.feature.component.logic.trace.a r3 = X3();
        if (r3 == null) goto L29;
        r3.Nz(r1);
        goto L29
    L10:
        com.larus.canvas.feature.component.resultdisplay.image.r r4 = Z3();
        if (r4 == null) goto L15;
        kotlinx.coroutines.flow.b1 r5 = r4.OP();
        if (r5 == null) goto L15;
        int r6 = ((Number) r5.getValue()).intValue();
    L16:
        if (r6 <= 0) goto L18;
        r9 = 3;
        goto L19
    L18:
        r9 = 1;
    L15:
        r6 = 0;
        goto L16
    }
}
