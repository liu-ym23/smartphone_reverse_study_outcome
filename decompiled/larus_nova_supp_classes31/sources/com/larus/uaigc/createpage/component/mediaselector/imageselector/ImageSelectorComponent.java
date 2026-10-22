package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.resource.access.ResourceCancelReason;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.platform.api.creation.IBachDetectCenterAbility;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.uaigc.createpage.utils.BitmapHelperKt;
import com.larus.uaigc.createpage.utils.CreationRemoteConversationHelper;
import com.larus.uaigc.helper.CreationResourceAccessPerfBridgeKt;
import com.larus.uaigc.impl.databinding.LarusFragmentCreationPageBinding;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.uaigc.service.ICreationResourceAccessServiceKt;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ¥\u00022\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0002¥\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0080\u0001\u001a\u00020|H\u0016J\t\u0010\u0081\u0001\u001a\u00020|H\u0016J\t\u0010\u0082\u0001\u001a\u00020|H\u0016J\u0013\u0010\u0083\u0001\u001a\u00020|2\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0016J\t\u0010\u0086\u0001\u001a\u00020|H\u0016J\t\u0010\u0087\u0001\u001a\u00020|H\u0016J\u001b\u0010\u0088\u0001\u001a\u000b\u0012\u0004\u0012\u00020+\u0018\u00010\u0089\u00012\u0007\u0010\u008a\u0001\u001a\u00020aH\u0016J\u0013\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0096@¢\u0006\u0003\u0010\u008d\u0001J\u0014\u0010\u008e\u0001\u001a\u00020|2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010LH\u0016J\u0014\u0010\u0090\u0001\u001a\u00020a2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010LH\u0002J\u0017\u0010\u0091\u0001\u001a\u00020Y*\u00020Y2\b\u0010\u0092\u0001\u001a\u00030\u008c\u0001H\u0002J$\u0010\u0093\u0001\u001a\u0013\u0012\u0005\u0012\u00030\u0095\u0001\u0012\u0005\u0012\u00030\u0095\u0001\u0018\u00010\u0094\u00012\b\u0010\u0092\u0001\u001a\u00030\u008c\u0001H\u0002J\u000f\u0010\u0096\u0001\u001a\u00030\u008c\u0001*\u00030\u008c\u0001H\u0002J#\u0010\u0097\u0001\u001a\u0013\u0012\u0005\u0012\u00030\u0095\u0001\u0012\u0005\u0012\u00030\u0095\u0001\u0018\u00010\u0094\u00012\u0007\u0010\u0098\u0001\u001a\u00020LH\u0002J\u0012\u0010\u009c\u0001\u001a\u0004\u0018\u00010LH\u0096@¢\u0006\u0003\u0010\u008d\u0001J\t\u0010\u009d\u0001\u001a\u00020|H\u0016J\t\u0010\u009e\u0001\u001a\u00020|H\u0016J\u0014\u0010\u009f\u0001\u001a\u00020|2\t\u0010 \u0001\u001a\u0004\u0018\u00010LH\u0016J\u000b\u0010¡\u0001\u001a\u0004\u0018\u00010LH\u0016J\t\u0010¢\u0001\u001a\u00020|H\u0016J\t\u0010£\u0001\u001a\u00020aH\u0016J\f\u0010¤\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0016J\u000b\u0010¥\u0001\u001a\u0004\u0018\u00010LH\u0002J\t\u0010¦\u0001\u001a\u00020|H\u0002J\t\u0010§\u0001\u001a\u00020|H\u0002J\t\u0010¨\u0001\u001a\u00020|H\u0002J\u0013\u0010©\u0001\u001a\u00020L2\b\u0010ª\u0001\u001a\u00030«\u0001H\u0002J\t\u0010¬\u0001\u001a\u00020|H\u0002J\n\u0010\u00ad\u0001\u001a\u00030®\u0001H\u0002J\t\u0010¯\u0001\u001a\u00020aH\u0002J\u0016\u0010°\u0001\u001a\u00020|2\u000b\b\u0002\u0010±\u0001\u001a\u0004\u0018\u00010LH\u0002J,\u0010²\u0001\u001a\u00020|2\u0007\u0010³\u0001\u001a\u00020L2\u0007\u0010´\u0001\u001a\u00020L2\b\u0010µ\u0001\u001a\u00030¶\u0001H\u0082@¢\u0006\u0003\u0010·\u0001J?\u0010¸\u0001\u001a\u00020|2\b\u0010¹\u0001\u001a\u00030º\u00012\u0007\u0010»\u0001\u001a\u00020L2\u0007\u0010³\u0001\u001a\u00020L2\b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010¼\u0001\u001a\u00020LH\u0082@¢\u0006\u0003\u0010½\u0001J\u0012\u0010¾\u0001\u001a\u00020a2\u0007\u0010»\u0001\u001a\u00020LH\u0002J\u000e\u0010¿\u0001\u001a\u00020a*\u00030À\u0001H\u0002J\u0013\u0010Á\u0001\u001a\u00020|2\b\u0010Â\u0001\u001a\u00030À\u0001H\u0002J\u0014\u0010Ã\u0001\u001a\u00020|2\t\u0010Ä\u0001\u001a\u0004\u0018\u00010LH\u0002J\u0012\u0010Å\u0001\u001a\u00020a2\u0007\u0010Ä\u0001\u001a\u00020LH\u0002J\u0013\u0010Æ\u0001\u001a\u00020|2\b\u0010µ\u0001\u001a\u00030¶\u0001H\u0002J/\u0010Ç\u0001\u001a\u00020|2\u0007\u0010³\u0001\u001a\u00020L2\b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010¼\u0001\u001a\u00020L2\b\u0010Â\u0001\u001a\u00030È\u0001H\u0002J\u0013\u0010É\u0001\u001a\u00020|2\b\u0010µ\u0001\u001a\u00030¶\u0001H\u0002J2\u0010Ê\u0001\u001a\u00020|2\b\u0010µ\u0001\u001a\u00030¶\u00012\u0007\u0010Ë\u0001\u001a\u00020L2\u0007\u0010Ì\u0001\u001a\u00020L2\u000b\b\u0002\u0010Í\u0001\u001a\u0004\u0018\u00010LH\u0002J\u0013\u0010Î\u0001\u001a\u0005\u0018\u00010¶\u0001H\u0082@¢\u0006\u0003\u0010\u008d\u0001J#\u0010Ï\u0001\u001a\u00020|2\u0007\u0010Ð\u0001\u001a\u00020L2\b\u0010µ\u0001\u001a\u00030¶\u0001H\u0082@¢\u0006\u0003\u0010Ñ\u0001J\u001a\u0010Ò\u0001\u001a\u00020|2\b\u0010µ\u0001\u001a\u00030¶\u0001H\u0082@¢\u0006\u0003\u0010Ó\u0001J\u001d\u0010Ô\u0001\u001a\u00020|2\u0007\u0010Õ\u0001\u001a\u00020a2\t\u0010Ö\u0001\u001a\u0004\u0018\u00010LH\u0002J\u0012\u0010×\u0001\u001a\u00020P2\u0007\u0010Ø\u0001\u001a\u00020LH\u0002J\t\u0010Ù\u0001\u001a\u00020|H\u0002J\u0016\u0010Ú\u0001\u001a\u00020|2\u000b\b\u0002\u0010¼\u0001\u001a\u0004\u0018\u00010LH\u0002J\t\u0010Û\u0001\u001a\u00020|H\u0002J\u0015\u0010Ü\u0001\u001a\u0004\u0018\u00010L2\b\u0010Ý\u0001\u001a\u00030Þ\u0001H\u0002J\u000f\u0010ß\u0001\u001a\u00030à\u0001*\u00030à\u0001H\u0002J\t\u0010á\u0001\u001a\u00020|H\u0002J\u0012\u0010â\u0001\u001a\u00020|2\u0007\u0010ã\u0001\u001a\u00020aH\u0002J\u0012\u0010ä\u0001\u001a\u00020|2\u0007\u0010ã\u0001\u001a\u00020aH\u0002J\t\u0010å\u0001\u001a\u00020|H\u0002J\u0012\u0010æ\u0001\u001a\u0004\u0018\u00010LH\u0082@¢\u0006\u0003\u0010\u008d\u0001J\t\u0010ç\u0001\u001a\u00020|H\u0002J\t\u0010è\u0001\u001a\u00020|H\u0002J\t\u0010é\u0001\u001a\u00020|H\u0002J\t\u0010ê\u0001\u001a\u00020|H\u0002J \u0010ë\u0001\u001a\u00020|2\u0007\u0010¼\u0001\u001a\u00020L2\f\b\u0002\u0010ì\u0001\u001a\u0005\u0018\u00010í\u0001H\u0002J1\u0010î\u0001\u001a\u0004\u0018\u00010a2\u0007\u0010ï\u0001\u001a\u00020P2\t\b\u0002\u0010ð\u0001\u001a\u00020a2\t\b\u0002\u0010ñ\u0001\u001a\u00020aH\u0082@¢\u0006\u0003\u0010ò\u0001J\u001d\u0010ó\u0001\u001a\u00020|2\u0007\u0010ï\u0001\u001a\u00020P2\t\b\u0002\u0010ð\u0001\u001a\u00020aH\u0002J\u001d\u0010ô\u0001\u001a\u00020|2\u0007\u0010ï\u0001\u001a\u00020P2\t\b\u0002\u0010ð\u0001\u001a\u00020aH\u0002J+\u0010õ\u0001\u001a\u00020U2\u0007\u0010ï\u0001\u001a\u00020P2\u0007\u0010ð\u0001\u001a\u00020a2\u000e\u0010ö\u0001\u001a\t\u0012\u0004\u0012\u00020|0÷\u0001H\u0002J-\u0010ø\u0001\u001a\u00020|2\u0007\u0010ù\u0001\u001a\u00020L2\u0007\u0010ú\u0001\u001a\u00020L2\u0010\b\u0002\u0010ö\u0001\u001a\t\u0012\u0004\u0012\u00020|0÷\u0001H\u0002J\"\u0010û\u0001\u001a\u00020|2\u0007\u0010ï\u0001\u001a\u00020P2\u0007\u0010ð\u0001\u001a\u00020aH\u0082@¢\u0006\u0003\u0010ü\u0001J\u0012\u0010ý\u0001\u001a\u00020|2\u0007\u0010þ\u0001\u001a\u00020{H\u0002J\t\u0010ÿ\u0001\u001a\u00020|H\u0002J\u0012\u0010\u0080\u0002\u001a\u00020a2\u0007\u0010Ë\u0001\u001a\u00020LH\u0002J'\u0010\u0081\u0002\u001a\u00020|2\u0007\u0010\u0082\u0002\u001a\u00020\u007f2\u0007\u0010¼\u0001\u001a\u00020L2\n\u0010\u0083\u0002\u001a\u0005\u0018\u00010\u0084\u0002H\u0002J\u0012\u0010\u0085\u0002\u001a\u00020a2\u0007\u0010Ë\u0001\u001a\u00020LH\u0002J\t\u0010\u0086\u0002\u001a\u00020LH\u0002J-\u0010\u0087\u0002\u001a\u00020|2\u0007\u0010\u0088\u0002\u001a\u00020a2\u000b\b\u0002\u0010Ë\u0001\u001a\u0004\u0018\u00010L2\f\b\u0002\u0010ì\u0001\u001a\u0005\u0018\u00010í\u0001H\u0002J\u001b\u0010\u0089\u0002\u001a\u00020|2\u0007\u0010\u0082\u0002\u001a\u00020\u007f2\u0007\u0010¼\u0001\u001a\u00020LH\u0002J\u0099\u0001\u0010\u008a\u0002\u001a\u00020|2\u0007\u0010\u008b\u0002\u001a\u00020L2\u0013\u0010\u008c\u0002\u001a\u000e\u0012\u0004\u0012\u00020{\u0012\u0004\u0012\u00020|0z2\u0013\u0010\u008d\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u007f\u0012\u0004\u0012\u00020|0z2\f\b\u0002\u0010ì\u0001\u001a\u0005\u0018\u00010í\u00012\u000b\b\u0002\u0010\u008e\u0002\u001a\u0004\u0018\u00010P2\t\b\u0002\u0010\u008f\u0002\u001a\u00020L2\u000b\b\u0002\u0010\u0090\u0002\u001a\u0004\u0018\u00010L2\t\b\u0002\u0010\u0091\u0002\u001a\u00020L2\u0016\b\u0002\u0010\u0092\u0002\u001a\u000f\u0012\u0005\u0012\u00030\u0093\u0002\u0012\u0004\u0012\u00020|0zH\u0082@¢\u0006\u0003\u0010\u0094\u0002J*\u0010\u0095\u0002\u001a\u00030\u0096\u00022\u0007\u0010\u008b\u0002\u001a\u00020L2\n\u0010ì\u0001\u001a\u0005\u0018\u00010í\u00012\t\u0010\u008e\u0002\u001a\u0004\u0018\u00010PH\u0002J^\u0010\u0097\u0002\u001a\u00020|2\b\u0010¹\u0001\u001a\u00030º\u00012\u0013\u0010\u0098\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u007f\u0012\u0004\u0012\u00020|0z2\u0013\u0010\u0099\u0002\u001a\u000e\u0012\u0004\u0012\u00020{\u0012\u0004\u0012\u00020|0z2\u0007\u0010\u0091\u0002\u001a\u00020L2\u0016\b\u0002\u0010\u0092\u0002\u001a\u000f\u0012\u0005\u0012\u00030\u0093\u0002\u0012\u0004\u0012\u00020|0zH\u0002J\u001c\u0010\u009a\u0002\u001a\u00030\u009b\u00022\u0007\u0010\u008f\u0001\u001a\u00020L2\u0007\u0010\u009c\u0002\u001a\u00020LH\u0002J\u0011\u0010\u009d\u0002\u001a\u00030\u009e\u0002H\u0082@¢\u0006\u0003\u0010\u008d\u0001J\t\u0010\u009f\u0002\u001a\u00020LH\u0002J\t\u0010 \u0002\u001a\u00020LH\u0002J\u0013\u0010¡\u0002\u001a\u00030¢\u00022\u0007\u0010\u009c\u0002\u001a\u00020LH\u0002J\t\u0010£\u0002\u001a\u00020|H\u0002J\t\u0010¤\u0002\u001a\u00020aH\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014*\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001a\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u001a\u001a\u0004\b,\u0010-R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u00101\u001a\u0004\u0018\u0001028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u001a\u001a\u0004\b3\u00104R\u001d\u00106\u001a\u0004\u0018\u0001078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u001a\u001a\u0004\b8\u00109R\u001d\u0010;\u001a\u0004\u0018\u00010<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u001a\u001a\u0004\b=\u0010>R\u001d\u0010@\u001a\u0004\u0018\u00010A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u001a\u001a\u0004\bB\u0010CR\u001d\u0010E\u001a\u0004\u0018\u00010F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\u001a\u001a\u0004\bG\u0010HR\u0016\u0010J\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010M\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u00010[X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010b\u001a\u00020c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010\u001a\u001a\u0004\bd\u0010eR\u001b\u0010g\u001a\u00020h8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010\u001a\u001a\u0004\bi\u0010jR\u000e\u0010l\u001a\u00020aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010o\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010p\u001a\u0004\u0018\u00010q8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\br\u0010sR\u001b\u0010t\u001a\u00020u8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bx\u0010\u001a\u001a\u0004\bv\u0010wR\u001c\u0010y\u001a\u0010\u0012\u0004\u0012\u00020{\u0012\u0004\u0012\u00020|\u0018\u00010zX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010}\u001a\u0016\u0012\u0004\u0012\u00020\u007f\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020|\u0018\u00010~X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0099\u0001\u001a\t\u0012\u0005\u0012\u00030\u009a\u00010\n8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u009b\u0001\u0010\f¨\u0006¦\u0002"}, d2 = {"Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/ImageSelectorComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/imageselector/IImageSelectorAbility;", "<init>", "()V", "_imageSelectorStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/MediaSelectorStatus;", "mediaSelectorStatus", "Lkotlinx/coroutines/flow/StateFlow;", "getMediaSelectorStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "imageSelectorViewDelegate", "Lkotlin/Lazy;", "Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/ImageSelectorView;", "imageSelectorView", "getImageSelectorView$delegate", "(Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/ImageSelectorComponent;)Ljava/lang/Object;", "getImageSelectorView", "()Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/ImageSelectorView;", "argumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "templateFeedAbility", "Lcom/larus/uaigc/bean/createpage/component/templatefeed/ITemplateFeedAbility;", "getTemplateFeedAbility", "()Lcom/larus/uaigc/bean/createpage/component/templatefeed/ITemplateFeedAbility;", "templateFeedAbility$delegate", "hitPointData", "Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "getHitPointData", "()Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "hitPointData$delegate", "actionBarInstructionItem", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionItem;", "getActionBarInstructionItem", "()Lcom/larus/bmhome/actionbar/model/ActionBarInstructionItem;", "actionBarInstructionItem$delegate", "curBindData", "Lcom/larus/bmhome/actionbar/model/MediaSelectorContainerTemplate;", "creationFragmentAbility", "Lcom/larus/uaigc/createpage/CreationFragmentAbility;", "getCreationFragmentAbility", "()Lcom/larus/uaigc/createpage/CreationFragmentAbility;", "creationFragmentAbility$delegate", "rootBinding", "Lcom/larus/uaigc/impl/databinding/LarusFragmentCreationPageBinding;", "getRootBinding", "()Lcom/larus/uaigc/impl/databinding/LarusFragmentCreationPageBinding;", "rootBinding$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "creationInputAbility", "Lcom/larus/uaigc/bean/createpage/component/input/CreationIInputAbility;", "getCreationInputAbility", "()Lcom/larus/uaigc/bean/createpage/component/input/CreationIInputAbility;", "creationInputAbility$delegate", "instructionEditAbility", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "getInstructionEditAbility", "()Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "instructionEditAbility$delegate", "pickLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "pickSDKLauncher", "Landroid/content/Intent;", "curSelectedAlbumUri", "Landroid/net/Uri;", "cachedLocalPathForReUpload", "preparedLocalPathForUpload", "curUploadTaskId", "uploadJob", "Lkotlinx/coroutines/Job;", "passedImageUrl", "passedAlbumPath", "passedImage", "Lcom/larus/im/bean/message/Image;", "passedRefImageInstantUploadInfo", "Lcom/larus/platform/model/upload/ResourceUploadInstantInfo;", "curUploaderIdentifier", "handoffUploadIdentifier", "curLocalMessageId", "initReferenceImageScene", "isFirstResume", "", "frescoCloseableHolder", "Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/FrescoCloseableHolder;", "getFrescoCloseableHolder", "()Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/FrescoCloseableHolder;", "frescoCloseableHolder$delegate", "uploadPreviewHelper", "Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/ImageSelectorUploadPreviewHelper;", "getUploadPreviewHelper", "()Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/ImageSelectorUploadPreviewHelper;", "uploadPreviewHelper$delegate", "disableReUpload", "imageSecondEditScene", "isPrivateImage", "albumPrompt", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "instructionEditorViewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "getInstructionEditorViewModel", "()Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "instructionEditorViewModel$delegate", "handleUploadFailBlock", "Lkotlin/Function1;", "Lcom/larus/platform/model/upload/ResourceUploadError;", "", "handleUploadSuccessBlock", "Lkotlin/Function2;", "Lcom/larus/platform/model/upload/ResourceUploadResult;", "onAttach", "onCreate", "onStart", "onViewCreated", "view", "Landroid/view/View;", "onDestroy", "cancelResourceAccessForPageLeave", "collectInstructionItemData", "", "forceNotEmpty", "getSendAttachmentInfo", "Lcom/larus/bmhome/view/AttachmentInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markUploadHandoffToSend", "fileIdentifier", "shouldKeepUploadForSend", "toRegisterImageMeta", "attachmentInfo", "resolveImageSizeForRegister", "Lkotlin/Pair;", "", "withResolvedImageSize", "resolveLocalImageSize", "filePath", "uiState", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/imageselector/UIState;", "getUiState", "getCurFilledImageLocalPath", "onClickRefImageAddItem", "clearSelectedImage", "openAlbumWithPrompt", "prompt", "getImageSecondEditScene", "refreshTitle", "isCurrentPrivateImage", "getCurPreprocessingAttachmentInfo", "getCurUploadingFilePath", "initData", "initImageSelectorView", "attachComponent", "getRefImageUrl", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "bindObservers", "getSelectorViewConfig", "Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/ImageSelectorView$Config;", "shouldShowImeWhenInit", "initPassedUrl", "passedUrl", "submitPassedRemoteResourceAccess", "previewUrl", "rawUrl", "bitmap", "Landroid/graphics/Bitmap;", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observePassedRemoteResourceAccessTask", "task", "Lcom/larus/bmhome/resource/access/ResourceAccessTask;", "expectedIdentifier", "localFilePath", "(Lcom/larus/bmhome/resource/access/ResourceAccessTask;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCurrentPassedRemoteResourceAccessTask", "shouldShowPassedRemoteUploading", "Lcom/larus/bmhome/resource/access/ResourceAccessState$Running;", "rememberRemoteFallbackLocalPath", "state", "rememberRetryLocalPath", "path", "isRetryPathAvailable", "showPassedRemoteUploadingIfNeeded", "handlePassedRemoteResourceAccessSuccess", "Lcom/larus/bmhome/resource/access/ResourceAccessState$Ready;", "ensurePassedRemotePreviewFilled", "handlePassedRemoteResourceAccessFail", "errorCode", "errorMessage", "fallbackLocalPath", "getPassedRawImageBitmap", "explainResourceUrl", "url", "(Ljava/lang/String;Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reUploadImageOfPassedUrl", "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mobUploadAttachmentStatus", "success", "errorMsg", "getLocalResUri", "localResPath", "initPassedImage", "initPassedAlbumImg", "checkShowImeWhenInit", "getCurMediaSelectorContainerTemplateData", "data", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/MediaSelectorData$ImageSelectorData;", "withAiCreationFlag", "Lcom/larus/bmhome/actionbar/model/MediaAttachment;", "observeImeChange", "adjustTitle", "isImeShown", "adjustSelectorViewPadding", "handleClickRetry", "resolveRetryLocalPath", "handleClickDelete", "handleClickEmptyContainer", "openSystemAlbum", "initImageResourceAccessCallbacks", "onAlbumPreprocessed", "fileInfo", "Lcom/larus/bmhome/chat/bean/ProcessFileInfo;", "preShowUploadingUri", "uri", "fromInit", "reportDecodeFailure", "(Landroid/net/Uri;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAlbumSelected", "startAlbumResourceAccess", "startAlbumUploadingUiForPipeline", "onPreviewStateReady", "Lkotlin/Function0;", "showPreprocessedUploadingPreview", "sourceLocalPath", "preprocessedLocalPath", "prepareAlbumUploadingUi", "(Landroid/net/Uri;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleUploadFail", "error", "refreshUploadFailedState", "handleResourceAccessPreprocessFail", "handleResourceAccessSuccess", "result", "accessArtifact", "Lcom/larus/bmhome/resource/access/ResourceArtifact;", "isPreprocessErrorCode", "albumUploadSourceScene", "mobAlbumImageUploadResult", "isSuccess", "handleUploadSuccess", "submitImageResourceAccess", "localPath", "onFailed", "onSuccess", "sourceUri", "uploadSourceScene", "preprocessSubScene", "perfParentScene", "onPreprocessedLocalPathReady", "Lcom/larus/bmhome/resource/access/ResourceInput$LocalPath;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/larus/bmhome/chat/bean/ProcessFileInfo;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildImageResourceInput", "Lcom/larus/bmhome/resource/access/ResourceInput;", "observeResourceAccessTask", "successCallback", "failedCallback", "buildResourceCenterUploadParam", "Lcom/larus/platform/model/upload/ResourceCenterUploadParam;", "conversationId", "resolveConversationBeforeUpload", "Lcom/larus/uaigc/createpage/utils/CreationRemoteConversationHelper$ResolveResult;", "resolveResourceConversationId", "resolveResourceBotId", "buildResourceAttachmentExtra", "Lcom/larus/platform/model/upload/ResourceAttachmentExtra;", "requireSelectedImageUrlInBackground", "showFull", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImageSelectorComponent extends BaseContentWidget implements sy9.a {
    public static final Lazy<Long> X = null;
    public ActivityResultLauncher<Intent> A;
    public Uri B;
    public String C;
    public String D;
    public String E;
    public Job F;
    public String G;
    public Image H;
    public ResourceUploadInstantInfo I;
    public String J;
    public String K;
    public String L;
    public String M;
    public boolean N;
    public final Lazy O;
    public final Lazy P;
    public final boolean Q;
    public String R;
    public boolean S;
    public String T;
    public final Lazy U;
    public c0 V;
    public d0 W;
    public final StateFlowImpl m;
    public final Lazy<ImageSelectorView> n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public com.larus.bmhome.actionbar.model.m1 t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public ActivityResultLauncher<String> z;

    public static final class a {
        public static final long a() {
            Lazy<Long> r0 = ImageSelectorComponent.X;
            return ((Number) ImageSelectorComponent.X.getValue()).longValue();
        }

        public a() {
        }
    }

    public final void i4() {
        this.M = null;
        String r1 = this.J;
        boolean r3 = false;
        if (r1 != null) goto L5;
    L14:
        Job r4 = this.F;
        if (r4 == null) goto L17;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L17:
        this.F = null;
        if (r3 == true) goto L21;
        this.K = null;
    L21:
        if (IBachDetectCenterAbility.a.b() == false) goto L42;
        String r2 = this.C;
        if (com.larus.utils.o0.d(r2) == true) goto L26;
        r2 = null;
    L26:
        if (r2 == null) goto L42;
        PolarisFileWrapper r5 = new PolarisFileWrapper(r2);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L34
        if (r5.exists() == false) goto L31;
        Uri r7 = Uri.fromFile(r5);     // Catch: Throwable -> L34
    L32:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L34
    L37:
        if (Result.isSuccess-impl(r8) == false) goto L41;
        Uri r9 = (Uri) r8;
        if (r9 == null) goto L41;
        IBachDetectCenterAbility.a.d(r9);
    L41:
        Result.box-impl(r8);
        goto L42
    L31:
        r7 = null;
    L34:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L42:
        this.C = null;
        this.D = null;
        this.E = null;
        this.m.setValue(ry9.j.b.b);
        X3().V5(new sy9.b.a(h5()));
        if (r3 == false) goto L45;
        FLogger.a.i("ImageSelectorComponent", "handleClickDelete keep resource access task for send, identifier=" + r1);
        return;
    L45:
        ICreationResourceAccessService.a.a(r1, ResourceCancelReason.USER_CANCEL);
        nz9.b.f("-99999", CollectionsKt.listOf(new String[]{"creation_page/album_upload", "creation_page/re_upload", "upload", "preprocess"}), null);
        return;
    L5:
        if (r1.length() <= 0) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == false) goto L10;
        String r12 = r1;
    L11:
        if (r12 == null) goto L14;
        r3 = Intrinsics.areEqual(r12, this.K);
        goto L14
    L10:
        r12 = null;
        goto L11
    L7:
        r11 = false;
        goto L8
    }

    static {
        new a();
        X = LazyKt.lazy(new p());
    }

    private final Activity getActivity() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity());     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        return (Activity) r1;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // sy9.a
    public final boolean As() {
        if (this.S == false) goto L13;
        ImageSelectorView r0 = X3();
        if (r0.i == true) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if ((r0.j.getValue() instanceof sy9.b.a) == true) goto L9;
        r1 = true;
        goto L10
    L13:
        return false;
    }

    @Override // ry9.g
    public final kotlinx.coroutines.flow.i1<ry9.j> D20() {
        return kotlinx.coroutines.flow.e.b(this.m);
    }

    public final ny9.s G3() {
        return (ny9.s) this.o.getValue();
    }

    public final com.larus.uaigc.createpage.v H3() {
        return (com.larus.uaigc.createpage.v) this.u.getValue();
    }

    @Override // ry9.g
    public final void N6() {
        String r0 = this.J;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L14:
        boolean r4 = false;
    L15:
        Job r5 = this.F;
        if (r5 == null) goto L18;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L18:
        this.F = null;
        if (r0 != null) goto L21;
    L24:
        boolean r6 = true;
    L25:
        if (r6 == false) goto L27;
        return;
    L27:
        ICreationResourceAccessService.Companion r7 = ICreationResourceAccessService.a;
        com.larus.bmhome.resource.access.z r8 = ICreationResourceAccessService.a.c(r7, r0, null, null, 14);
        if (r8 == null) goto L34;
        com.larus.bmhome.resource.access.a0 r9 = r8.c;
        if (r9 == null) goto L34;
        if (com.larus.bmhome.resource.access.s.b(r9) != true) goto L34;
    L35:
        if (r1 == false) goto L38;
        return;
    L38:
        if (r4 == false) goto L40;
        FLogger.a.i("ImageSelectorComponent", "cancelResourceAccessForPageLeave keep resource access task for send, identifier=" + r0);
        return;
    L40:
        boolean r3 = r7.a(r0, ResourceCancelReason.PAGE_DESTROY);
        FLogger.a.i("ImageSelectorComponent", "cancelResourceAccessForPageLeave cancel resource access task, identifier=" + r0 + ", cancelled=" + r3);
        this.J = null;
        return;
    L34:
        r1 = false;
        goto L35
    L21:
        if (r0.length() == 0) goto L24;
        r6 = false;
        goto L25
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == false) goto L10;
        String r11 = r0;
    L11:
        if (r11 == null) goto L14;
        r4 = Intrinsics.areEqual(r11, this.K);
        goto L15
    L10:
        r11 = null;
        goto L11
    L7:
        r10 = false;
        goto L8
    }

    public final py9.a Q3() {
        return (py9.a) this.x.getValue();
    }

    public final c V3() {
        return (c) this.O.getValue();
    }

    public final ny9.u W3() {
        return (ny9.u) this.r.getValue();
    }

    public final ImageSelectorView X3() {
        return (ImageSelectorView) this.n.getValue();
    }

    public final ys8.a Z3() {
        return (ys8.a) this.y.getValue();
    }

    public final LarusFragmentCreationPageBinding d4() {
        return (LarusFragmentCreationPageBinding) this.v.getValue();
    }

    @Override // sy9.a
    public final String dU() {
        Object r0 = this.m.getValue();
        if ((r0 instanceof ry9.j.c) == false) goto L5;
        ry9.j.c r1 = (ry9.j.c) r0;
    L6:
        if (r1 == null) goto L8;
        ry9.i r2 = r1.b;
    L10:
        if ((r2 instanceof ry9.i.a) == false) goto L12;
        ry9.i.a r3 = (ry9.i.a) r2;
    L13:
        if (r3 == null) goto L15;
        MediaAttachment r4 = r3.a;
    L17:
        if (com.larus.utils.o0.d(this.R) == false) goto L29;
        if (r4 == null) goto L29;
        if (Intrinsics.areEqual(r4.getUrl(), this.G) == true) goto L28;
        String r5 = r4.getUri();
        Image r6 = this.H;
        if (r6 == null) goto L24;
        String r7 = r6.key;
    L26:
        if (Intrinsics.areEqual(r5, r7) == false) goto L29;
    L24:
        r7 = null;
    L28:
        return this.R;
    L29:
        return null;
    L15:
        r4 = null;
        goto L17
    L12:
        r3 = null;
        goto L13
    L8:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final uy9.a e4() {
        return (uy9.a) this.q.getValue();
    }

    public final ImageSelectorUploadPreviewHelper h4() {
        return (ImageSelectorUploadPreviewHelper) this.P.getValue();
    }

    public final void j4() {
        String r5 = null;
        com.obric.assistant.spi.keyguard.a.a(new e0(this), new f0(), null, false, 28);
        ny9.s r0 = G3();
        if (r0 == null) goto L5;
        com.larus.bmhome.actionbar.model.z0 r1 = r0.f();
    L6:
        ny9.u r2 = W3();
        if (r2 == null) goto L9;
        String r6 = r2.getBotId();
    L10:
        ny9.u r3 = W3();
        if (r3 == null) goto L13;
        String r10 = r3.getChatType();
    L14:
        ny9.u r4 = W3();
        if (r4 == null) goto L17;
        String r7 = r4.r();
    L18:
        ny9.u r8 = W3();
        if (r8 == null) goto L21;
        String r9 = r8.getEnterMethod();
    L22:
        if (r1 == null) goto L28;
        com.larus.bmhome.actionbar.model.r r11 = r1.q;
        if (r11 == null) goto L28;
        Integer r12 = r11.a;
        if (r12 == null) goto L28;
        String r13 = r12.toString();
    L29:
        if (r1 == null) goto L33;
        com.larus.bmhome.actionbar.model.r r14 = r1.q;
        if (r14 == null) goto L33;
        String r15 = r14.g;
    L34:
        ny9.u r16 = W3();
        if (r16 == null) goto L37;
        r5 = r16.q();
    L37:
        tx9.c0.H(r6, r7, r9, null, r10, r5, null, r13, r15, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, 33553992);
        return;
    L33:
        r15 = null;
    L28:
        r13 = null;
        goto L29
    L21:
        r9 = null;
        goto L22
    L17:
        r7 = null;
        goto L18
    L13:
        r10 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final void onStart() {
        if (this.N == true) goto L7;
        LarusFragmentCreationPageBinding r0 = d4();
        if (r0 == null) goto L7;
        boolean r1 = ViewExtKt.h(r0.e);
        C3(r1);
        B3(r1);
    L7:
        this.N = false;
    }

    @Override // sy9.a
    public final AttachmentInfo t20() {
        if ((D20().getValue() instanceof ry9.j.h) == true) goto L5;
    L22:
        return null;
    L5:
        if (this.B == null) goto L22;
        String r9 = vqc.d.d(getContext(), this.B);
        if (r9 == null) goto L22;
        com.larus.bmhome.resource.access.f0 r3 = ICreationResourceAccessService.a.c(this.J);
        if (r3 == null) goto L11;
        String r12 = r3.d;
    L12:
        String r13 = this.J;
        String r4 = this.L;
        ny9.s r5 = G3();
        if (r5 == null) goto L17;
        boolean r2 = true;
        if (r5.x() != true) goto L17;
    L18:
        if (r2 == false) goto L20;
        Boolean r21 = Boolean.TRUE;
    L24:
        return q5(new AttachmentInfo(true, "", null, null, r9, null, "", r12, r13, null, null, null, null, null, null, r4, r21, 32268, null));
    L20:
        r21 = null;
    L17:
        r2 = false;
        goto L18
    L11:
        r12 = null;
        goto L12
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, sy9.a.class);
    }

    public ImageSelectorComponent() {
        this.m = kotlinx.coroutines.flow.j1.a(ry9.j.b.b);
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        this.n = LazyKt.lazy(r0, new d(this));
        this.o = LazyKt.lazy(new j0(this));
        this.p = LazyKt.lazy(new k0(this));
        this.q = LazyKt.lazy(new l0(this));
        this.r = LazyKt.lazy(new m0(this));
        this.s = LazyKt.lazy(new n0(this));
        this.t = new com.larus.bmhome.actionbar.model.m1(1, 13);
        this.u = LazyKt.lazy(r0, new e(this));
        this.v = LazyKt.lazy(r0, new f(this));
        this.w = LazyKt.lazy(new g(this));
        this.x = LazyKt.lazy(new h(this));
        this.y = LazyKt.lazy(new o(this));
        this.N = true;
        this.O = LazyKt.lazy(new z());
        this.P = LazyKt.lazy(new h0(this));
        this.Q = com.larus.platform.service.z2.a.disableReUploadGeneratedImg();
        this.U = LazyKt.lazy(new i0(this));
    }

    public final void R4() {
        Bitmap r0 = X3().getCurBitmap();
        if (r0 == null) goto L6;
        h4().c(r0);
        return;
    L6:
        String r1 = this.C;
        boolean r2 = true;
        if (r1 != null) goto L9;
    L16:
        Uri r3 = this.B;
        if (r3 == null) goto L19;
        r1 = r3.toString();
    L20:
        if (r1 != null) goto L22;
    L25:
        if (r2 == false) goto L28;
        h4().c(null);
        return;
    L28:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new ImageSelectorComponent$refreshUploadFailedState$2(this, this.C, r1, null), 2, null);
        return;
    L22:
        if (r1.length() == 0) goto L25;
        r2 = false;
        goto L25
    L19:
        r1 = null;
        goto L20
    L9:
        if (r1.length() <= 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == true) goto L15;
        r1 = null;
    L15:
        if (r1 != null) goto L20;
    L11:
        r4 = false;
        goto L12
    }

    public final void V4() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new ImageSelectorComponent$requireSelectedImageUrlInBackground$1(this, null), 2, null);
    }

    public final String f5() {
        ny9.s r0 = G3();
        String r1 = null;
        if (r0 == null) goto L7;
        ChatParam r2 = r0.c();
        if (r2 == null) goto L7;
        String r3 = r2.b;
    L8:
        String r4 = "";
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        boolean r5 = false;
        if (r3.length() != 0) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == false) goto L47;
        ny9.u r7 = W3();
        if (r7 == null) goto L19;
        String r8 = r7.getBotId();
    L20:
        if (r8 != null) goto L23;
        r8 = "";
    L23:
        if (r8.length() != 0) goto L25;
        boolean r9 = true;
    L26:
        if (r9 == false) goto L48;
        com.larus.bmhome.chat.component.cvs.y r10 = (com.larus.bmhome.chat.component.cvs.y) this.p.getValue();
        if (r10 == null) goto L30;
        String r11 = r10.getBotId();
    L31:
        if (r11 != null) goto L34;
        r11 = "";
    L34:
        if (r11.length() != 0) goto L36;
        r5 = true;
    L36:
        if (r5 == false) goto L49;
        com.larus.bmhome.chat.api.e0 r12 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r12 == null) goto L42;
        LaunchInfo r13 = r12.a;
        if (r13 == null) goto L42;
        r1 = r13.W();
    L42:
        if (r1 == null) goto L46;
        r4 = r1;
    L46:
        return r4;
    L49:
        return r11;
    L30:
        r11 = null;
        goto L31
    L48:
        return r8;
    L25:
        r9 = false;
        goto L26
    L19:
        r8 = null;
        goto L20
    L47:
        return r3;
    L14:
        r6 = false;
    L7:
        r3 = null;
        goto L8
    }

    @Override // sy9.a
    public final kotlinx.coroutines.flow.i1<sy9.b> getUiState() {
        return X3().getCurState();
    }

    public final boolean h5() {
        LarusFragmentCreationPageBinding r0 = d4();
        boolean r1 = false;
        if (r0 == null) goto L10;
        ChatConstraintLayout r2 = r0.e;
        if (r2 == null) goto L10;
        if (ViewExtKt.h(r2) != true) goto L10;
        r1 = true;
    L10:
        return !r1;
    }

    @Override // sy9.a
    public final void lI() {
        LarusFragmentCreationPageBinding r0 = d4();
        if (r0 == null) goto L6;
        C3(ViewExtKt.h(r0.e));
        return;
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        k1a.b.b(this, new y(this));
        ny9.s r0 = G3();
        boolean r1 = false;
        if (r0 == null) goto L7;
        Bundle r2 = r0.a;
        if (r2 == null) goto L7;
        boolean r3 = r2.getBoolean("is_show_reselect", false);
    L8:
        ny9.s r4 = G3();
        if (r4 == null) goto L13;
        Bundle r5 = r4.a;
        if (r5 == null) goto L13;
        boolean r6 = r5.getBoolean("is_private_image", false);
    L14:
        this.S = r6;
        X3().setEnableShowReselectIcon(r3);
        FLogger.a.i("ImageSelectorComponent", "onlyChooseOnce:" + r3 + ",isPrivateImage:" + this.S);
        String r7 = null;
        p4(null);
        l4(null);
        ny9.s r8 = (ny9.s) s1a.d.a(this).a(ny9.s.class);
        if (r8 == null) goto L74;
        Image r9 = r8.r();
        if (r9 == null) goto L74;
        String r10 = r9.key;
        if (r10 != null) goto L21;
    L24:
        boolean r11 = true;
    L25:
        if (r11 == true) goto L27;
        this.H = r9;
        ny9.s r12 = G3();
        if (r12 == null) goto L41;
        Bundle r13 = r12.a;
        if (r13 == null) goto L37;
        Serializable r14 = r13.getSerializable("ref_image_instant_upload_info");
    L39:
        if ((r14 instanceof ResourceUploadInstantInfo) == false) goto L41;
        ResourceUploadInstantInfo r15 = (ResourceUploadInstantInfo) r14;
    L42:
        this.I = r15;
        ny9.s r16 = G3();
        if (r16 == null) goto L58;
        Bundle r17 = r16.a;
        if (r17 == null) goto L47;
        String r18 = r17.getString("ref_image_local_message_id");
    L48:
        if (r18 == null) goto L58;
        if (r18.length() <= 0) goto L52;
        boolean r19 = true;
    L53:
        if (r19 == true) goto L56;
        r18 = null;
    L56:
        if (r18 == null) goto L58;
        this.L = r18;
        goto L58
    L52:
        r19 = false;
        goto L53
    L47:
        r18 = null;
    L58:
        ny9.s r20 = G3();
        if (r20 == null) goto L63;
        Bundle r21 = r20.a;
        if (r21 == null) goto L63;
        String r22 = r21.getString("image_second_edit_scene");
    L64:
        this.R = r22;
        ny9.s r23 = G3();
        if (r23 != null) goto L67;
    L69:
        if (r1 == false) goto L73;
        ys8.a r24 = Z3();
        if (r24 == null) goto L73;
        r24.setOriginalRatioEnable(true);
    L73:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new ImageSelectorComponent$initPassedImage$1$3(this, r9, null), 2, null);
        goto L74
    L67:
        if (r23.D() != true) goto L69;
        r1 = true;
    L63:
        r22 = null;
        goto L64
    L37:
        r14 = null;
    L41:
        r15 = null;
        goto L42
    L27:
        if (com.larus.utils.o0.d(r9.localResPath) == false) goto L74;
        String r25 = r9.localResPath;
        if (r25 != null) goto L31;
        r25 = "";
    L31:
        l4(com.larus.utils.y0.k(a4(r25)));
        goto L74
    L21:
        if (r10.length() == 0) goto L24;
        r11 = false;
    L74:
        ny9.u r26 = W3();
        if (r26 == null) goto L77;
        r7 = r26.o();
    L77:
        this.M = r7;
        return;
    L13:
        r6 = false;
    L7:
        r3 = false;
        goto L8
    }

    public final void onDestroy() {
        com.larus.uaigc.createpage.v r0 = H3();
        if (r0 == null) goto L5;
        r0.UV(false);
    L5:
        N6();
        if (this.n.isInitialized() == false) goto L8;
        ImageSelectorView r1 = X3();
        r1.j.setValue(sy9.b.d.a);
        r1.a.i.setImageDrawable(null);
    L8:
        V3().b();
        this.V = null;
        this.W = null;
    }

    @Override // sy9.a
    public final void YO() {
        i4();
    }

    @Override // sy9.a
    public final void oF() {
        j4();
    }

    public static Uri a4(String r4) {
        if (StringsKt.contains$default(r4, "file://", false, 2, null) == true) goto L7;
        r4 = "file://".concat(r4);
    L7:
        return UriProtector.parse(r4);
    }

    public static Pair d5(AttachmentInfo r5) {
        Integer r0 = r5.getWidth();
        Integer r1 = r5.getHeight();
        if (r0 == null) goto L11;
        if (r1 == null) goto L11;
        if (r0.intValue() <= 0) goto L11;
        if (r1.intValue() <= 0) goto L11;
        return TuplesKt.to(r0, r1);
    L11:
        String r6 = r5.getFilePath();
        boolean r2 = false;
        if (r6.length() <= 0) goto L14;
        boolean r3 = true;
    L16:
        if (r3 == true) goto L19;
        r6 = null;
    L19:
        if (r6 != null) goto L21;
        return null;
    L21:
        BitmapFactory.Options r4 = new BitmapFactory.Options();
        r4.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r6, r4);
        if (r4.outWidth > 0) goto L24;
        return null;
    L24:
        if (r4.outHeight <= 0) goto L52;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L38
        int r8 = new ExifInterface(r6).getAttributeInt("Orientation", 1);     // Catch: Throwable -> L38
        if (r8 != 5) goto L29;
    L35:
        r2 = true;
    L36:
        Object r9 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L38
    L40:
        Boolean r10 = Boolean.FALSE;
        if (Result.isFailure-impl(r9) == false) goto L44;
        r9 = r10;
    L44:
        if (((Boolean) r9).booleanValue() == false) goto L46;
        Pair r11 = TuplesKt.to(Integer.valueOf(r4.outHeight), Integer.valueOf(r4.outWidth));
    L48:
        return r11;
    L46:
        r11 = TuplesKt.to(Integer.valueOf(r4.outWidth), Integer.valueOf(r4.outHeight));
        goto L48
    L29:
        if (r8 == 6) goto L35;
        if (r8 == 7) goto L35;
        if (r8 == 8) goto L35;
    L38:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    L52:
        return null;
    L14:
        r3 = false;
        goto L16
    }

    public static final /* synthetic */ Activity h3(ImageSelectorComponent r0) {
        return r0.getActivity();
    }

    public static AttachmentInfo q5(AttachmentInfo r20) {
        Integer r0 = r20.getWidth();
        Integer r1 = r20.getHeight();
        if (r0 == null) goto L10;
        if (r1 == null) goto L10;
        if (r0.intValue() <= 0) goto L10;
        if (r1.intValue() <= 0) goto L10;
        return r20;
    L10:
        Pair r2 = d5(r20);
        if (r2 != null) goto L13;
        return r20;
    L13:
        int r4 = ((Number) r2.getFirst()).intValue();
        return AttachmentInfo.copy$default(r20, false, null, Integer.valueOf(((Number) r2.getSecond()).intValue()), Integer.valueOf(r4), null, null, null, null, null, null, null, null, null, null, null, null, null, 131059, null);
    }

    public final void B3(boolean r15) {
        LarusFragmentCreationPageBinding r0 = d4();
        if (r0 == null) goto L30;
        int r2 = c7.b(12);
        int r3 = r0.j.getHeight() + c7.b(12);
        View r1 = F2();
        if (r15 == false) goto L9;
        com.larus.uaigc.createpage.v r4 = H3();
        if (r4 == null) goto L10;
        r2 = r4.Ts(r2, r0.j.getHeight());
    L10:
        int r5 = r1.getPaddingStart();
        int r6 = r1.getPaddingEnd();
        int r7 = r1.getPaddingBottom();
        FLogger r8 = FLogger.a;
        r8.i("updatePaddingRelative", "view:" + r1.getClass().getSimpleName() + ",source:,start:" + r5 + ",top:" + r2 + ",end:" + r6 + ",bottom:" + r7);
        r1.setPaddingRelative(r5, r2, r6, r7);
        ConstraintLayout r9 = X3();
        int r10 = c7.b(32);
        int r11 = 24;
        if (r15 == false) goto L13;
        int r12 = 0;
    L14:
        int r13 = c7.b(32);
        if (r15 == false) goto L17;
        r11 = 8;
    L17:
        int r14 = c7.b(Integer.valueOf(r11));
        r8.i("updatePaddingRelative", "view:" + r9.getClass().getSimpleName() + ",source:,start:" + r10 + ",top:" + r12 + ",end:" + r13 + ",bottom:" + r14);
        r9.setPaddingRelative(r10, r12, r13, r14);
        sy9.b r16 = (sy9.b) X3().getCurState().getValue();
        if ((r16 instanceof sy9.b.a) == false) goto L21;
        ImageSelectorView r17 = X3();
        Object r18 = X3().getCurState().getValue();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.larus.uaigc.bean.createpage.component.mediacontainer.imageselector.UIState.Empty");
        ((sy9.b.a) r18).getClass();
        r17.V5(new sy9.b.a(!r15));
        return;
    L21:
        if ((r16 instanceof sy9.b.C0075b) == false) goto L24;
        ImageSelectorView r19 = X3();
        Object r20 = X3().getCurState().getValue();
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type com.larus.uaigc.bean.createpage.component.mediacontainer.imageselector.UIState.Failed");
        r19.V5(new sy9.b.C0075b(((sy9.b.C0075b) r20).a, !r15));
        return;
    L24:
        if ((r16 instanceof sy9.b.c) == false) goto L27;
        ImageSelectorView r21 = X3();
        Object r22 = X3().getCurState().getValue();
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type com.larus.uaigc.bean.createpage.component.mediacontainer.imageselector.UIState.Filled");
        r21.V5(new sy9.b.c(((sy9.b.c) r22).a, !r15));
        return;
    L27:
        if ((r16 instanceof sy9.b.e) == false) goto L34;
        ImageSelectorView r23 = X3();
        Object r24 = X3().getCurState().getValue();
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type com.larus.uaigc.bean.createpage.component.mediacontainer.imageselector.UIState.Uploading");
        r23.V5(sy9.b.e.a((sy9.b.e) r24, !r15, false, 13));
        return;
    L34:
        return;
    L13:
        r12 = c7.b(24);
        goto L14
    L9:
        r2 = r3;
        goto L10
    }

    @Override // ry9.g
    public final void C2(String r3) {
        if (r3.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r3 = null;
    L9:
        if (r3 != null) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r3, this.J) == true) goto L14;
        return;
    L14:
        this.K = r3;
        FLogger.a.i("ImageSelectorComponent", "mark upload handoff to send, identifier=".concat(r3));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void C3(boolean r9) {
        com.larus.uaigc.createpage.v r0 = H3();
        if (r0 == null) goto L5;
        r0.UV(r9);
    L5:
        boolean r1 = false;
        if (F2().getVisibility() != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L17;
        uy9.a r3 = e4();
        if (r3 != null) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == false) goto L17;
        return;
    L13:
        if (r3.Ah() != true) goto L15;
        r4 = true;
    L17:
        LarusFragmentCreationPageBinding r5 = d4();
        if (r5 == null) goto L52;
        com.larus.uaigc.createpage.v r6 = H3();
        if (r6 != null) goto L22;
    L24:
        boolean r7 = false;
    L25:
        com.larus.uaigc.createpage.v r8 = H3();
        if (r8 != null) goto L28;
    L30:
        boolean r10 = false;
    L31:
        ny9.s r11 = (ny9.s) s1a.d.a(this).a(ny9.s.class);
        if (r11 == null) goto L34;
        String r12 = r11.w();
    L35:
        String r13 = "";
        if (r12 != null) goto L38;
        r12 = "";
    L38:
        NovaTitleBarEx r14 = r5.j;
        if (r9 == false) goto L42;
        if (r10 == true) goto L42;
    L48:
        r12 = r13;
    L49:
        NovaTitleBarEx.Y5(r14, r12, null, null, 6);
        return;
    L42:
        if (r7 == false) goto L49;
        if (r12.length() != 0) goto L46;
        r1 = true;
    L46:
        if (r1 == false) goto L49;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r13 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getString(2131897499);
        Intrinsics.checkNotNull(r13);
        goto L48
    L34:
        r12 = null;
        goto L35
    L28:
        if (r8.Fl() != true) goto L30;
        r10 = true;
        goto L31
    L22:
        if (r6.wD() != true) goto L24;
        r7 = true;
        goto L25
    L52:
        return;
    L8:
        r2 = false;
        goto L9
    }

    public final void E3(Bitmap r4) {
        if ((X3().getCurState().getValue() instanceof sy9.b.c) == true) goto L5;
    L7:
        ImageSelectorView r0 = X3();
        Bitmap r2 = X3().getCurBitmap();
        if (r2 == null) goto L11;
        r4 = r2;
    L11:
        r0.V5(new sy9.b.c(r4, h5()));
        return;
    L5:
        if (X3().getCurBitmap() == null) goto L7;
    }

    @Override // sy9.a
    public final Object Ov(Continuation<? super String> r8) {
        if ((r8 instanceof ImageSelectorComponent$getCurFilledImageLocalPath$1) == false) goto L7;
        ImageSelectorComponent$getCurFilledImageLocalPath$1 r0 = (ImageSelectorComponent$getCurFilledImageLocalPath$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r4 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Ref.ObjectRef r5 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L44:
        File r10 = (File) r9;
        if (r10 == null) goto L47;
        r4 = r10.getPath();
    L47:
        r5.element = r4;
        Ref.ObjectRef r11 = r5;
    L49:
        return r11.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        if ((X3().getCurState().getValue() instanceof sy9.b.c) == true) goto L17;
    L50:
        return null;
    L17:
        if (X3().getCurBitmap() == null) goto L50;
        r11 = new Ref.ObjectRef();
        ry9.i r6 = ((ry9.j) this.m.getValue()).a();
        if ((r6 instanceof ry9.i.a) == false) goto L22;
        ry9.i.a r7 = (ry9.i.a) r6;
    L23:
        if (r7 == null) goto L27;
        MediaAttachment r12 = r7.a;
        if (r12 == null) goto L27;
        String r13 = r12.getLocalFilePath();
    L28:
        r11.element = r13;
        if (r13 != null) goto L31;
    L34:
        boolean r14 = true;
    L35:
        if (r14 == false) goto L37;
    L38:
        Bitmap r15 = X3().getCurBitmap();
        if (r15 == null) goto L49;
        Context r16 = getContext();
        r0.L$0 = r11;
        r0.label = 1;
        Object r17 = BitmapHelperKt.d(r16, r15, "image_selector_default_image.jpeg", r0);
        if (r17 != r2) goto L43;
        return r2;
    L43:
        r5 = r11;
        r9 = r17;
        goto L44
    L37:
        if (new PolarisFileWrapper((String) r11.element).exists() == true) goto L49;
    L31:
        if (r13.length() == 0) goto L34;
        r14 = false;
    L27:
        r13 = null;
        goto L28
    L22:
        r7 = null;
    L7:
        r0 = new ImageSelectorComponent$getCurFilledImageLocalPath$1(this, r8);
        goto L8
    }

    public final void T4(String r4) {
        if (r4 == null) goto L19;
        boolean r1 = true;
        String r2 = null;
        if ((!StringsKt.isBlank(r4)) == true) goto L7;
        r4 = null;
    L7:
        if (r4 != null) goto L9;
        return;
    L9:
        if (com.larus.uaigc.helper.g.b(r4) == false) goto L11;
    L14:
        if (r1 == false) goto L16;
        r2 = r4;
    L16:
        if (r2 == null) goto L21;
        this.C = r2;
        this.D = r2;
        return;
    L21:
        return;
    L11:
        if (new PolarisFileWrapper(r4).exists() == true) goto L14;
        r1 = false;
        goto L14
    }

    public final Object W4(Continuation<? super CreationRemoteConversationHelper.a> r8) {
        if ((r8 instanceof ImageSelectorComponent$resolveConversationBeforeUpload$1) == false) goto L7;
        ImageSelectorComponent$resolveConversationBeforeUpload$1 r0 = (ImageSelectorComponent$resolveConversationBeforeUpload$1) r8;
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
    L49:
        CreationRemoteConversationHelper.a r10 = (CreationRemoteConversationHelper.a) r9;
        if (r10.b == false) goto L56;
        ny9.s r4 = G3();
        if (r4 == null) goto L56;
        ChatParam r5 = r4.c();
        if (r5 == null) goto L56;
        r5.a = r10.a;
    L56:
        return r10;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        ny9.s r11 = G3();
        if (r11 == null) goto L19;
        ChatParam r12 = r11.c();
        if (r12 == null) goto L19;
        String r13 = r12.a;
    L20:
        String r6 = "";
        if (r13 != null) goto L23;
        r13 = "";
    L23:
        boolean r7 = false;
        if (r13.length() != 0) goto L26;
        boolean r14 = true;
    L27:
        if (r14 == false) goto L46;
        ny9.u r15 = W3();
        if (r15 == null) goto L31;
        r13 = r15.Y1();
    L32:
        if (r13 != null) goto L35;
        r13 = "";
    L35:
        if (r13.length() != 0) goto L37;
        r7 = true;
    L37:
        if (r7 == false) goto L46;
        com.larus.bmhome.chat.component.cvs.y r16 = (com.larus.bmhome.chat.component.cvs.y) this.p.getValue();
        if (r16 == null) goto L41;
        String r17 = r16.Y1();
    L42:
        if (r17 == null) goto L45;
        r6 = r17;
    L45:
        r13 = r6;
        goto L46
    L41:
        r17 = null;
        goto L42
    L31:
        r13 = null;
    L46:
        String r18 = f5();
        CoroutineDispatcher r19 = Dispatchers.getIO();
        ImageSelectorComponent$resolveConversationBeforeUpload$result$1 r20 = new ImageSelectorComponent$resolveConversationBeforeUpload$result$1(r13, r18, null);
        r0.label = 1;
        r9 = BuildersKt.withContext(r19, r20, r0);
        if (r9 != r2) goto L49;
        return r2;
    L26:
        r14 = false;
    L19:
        r13 = null;
    L7:
        r0 = new ImageSelectorComponent$resolveConversationBeforeUpload$1(this, r8);
        goto L8
    }

    @Override // ry9.g
    public final Object Zt(Continuation<? super AttachmentInfo> r42) {
        if ((r42 instanceof ImageSelectorComponent$getSendAttachmentInfo$1) == false) goto L7;
        ImageSelectorComponent$getSendAttachmentInfo$1 r2 = (ImageSelectorComponent$getSendAttachmentInfo$1) r42;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        boolean r6 = false;
        Image r7 = null;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        MediaAttachment r8 = (MediaAttachment) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L60:
        AttachmentInfo r9 = (AttachmentInfo) r1;
    L62:
        if (r9 == null) goto L64;
        AttachmentInfo r10 = q5(r9);
    L65:
        if (r10 != null) goto L67;
        return null;
    L67:
        if (com.larus.utils.o0.d(this.M) == false) goto L69;
        String r11 = String.valueOf(this.M);
    L70:
        String r15 = r11;
        String r12 = r8.getUri();
        Image r13 = this.H;
        if (r13 == null) goto L73;
        String r14 = r13.key;
    L75:
        if (Intrinsics.areEqual(r12, r14) == false) goto L77;
        ResourceUploadInstantInfo r16 = this.I;
    L78:
        ResourceUploadInstantInfo r22 = r16;
        String r17 = r8.getUri();
        Image r18 = this.H;
        if (r18 == null) goto L81;
        String r19 = r18.key;
    L83:
        if (Intrinsics.areEqual(r17, r19) == false) goto L91;
        Image r20 = this.H;
        if (r20 == null) goto L92;
        Pair r21 = d5(r10);
        if (r21 == null) goto L89;
        ImageObj r27 = new ImageObj(null, ((Number) r21.component1()).intValue(), ((Number) r21.component2()).intValue(), null, null, 25, null);
    L90:
        r7 = Image.copy$default(r20, null, null, null, r27, null, r10.getFilePath(), null, null, null, null, null, null, null, null, 7874, null);
        goto L92
    L89:
        r27 = null;
    L92:
        Image r23 = r7;
        ny9.s r24 = G3();
        if (r24 != null) goto L95;
    L97:
        if (r6 == false) goto L99;
        Boolean r25 = Boxing.boxBoolean(true);
    L101:
        return AttachmentInfo.copy$default(r10, false, null, null, null, null, null, r15, null, null, null, null, null, null, r22, r23, null, r25, 40895, null);
    L99:
        r25 = r10.getAiCreationImage();
        goto L101
    L95:
        if (r24.x() != true) goto L97;
        r6 = true;
        goto L97
    L91:
        r7 = r10.getImage();
        goto L92
    L81:
        r19 = null;
        goto L83
    L77:
        r16 = r10.getInstantUploadInfo();
        goto L78
    L73:
        r14 = null;
        goto L75
    L69:
        r11 = r10.getFromScene();
        goto L70
    L64:
        r10 = null;
        goto L65
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        ry9.i r26 = ((ry9.j) this.m.getValue()).a();
        if ((r26 instanceof ry9.i.a) == false) goto L17;
        ry9.i.a r28 = (ry9.i.a) r26;
    L18:
        if (r28 == null) goto L22;
        MediaAttachment r29 = r28.a;
        if (r29 == null) goto L22;
    L47:
        Activity r30 = getActivity();
        if (r30 == null) goto L102;
        if (r29 == null) goto L61;
        String r31 = r29.getLocalFilePath();
        if (r31 != null) goto L53;
    L55:
        boolean r32 = false;
    L56:
        r2.L$0 = r29;
        r2.label = 1;
        Object r33 = BuildersKt.withContext(Dispatchers.getIO(), new DataConverterKt$toAttachmentInfo$2(r29, r32, r30, null), r2);
        if (r33 != r4) goto L59;
        return r4;
    L59:
        r8 = r29;
        r1 = r33;
        goto L60
    L53:
        if (StringsKt.contains$default(r31, "image_selector_default_image.jpeg", false, 2, null) != true) goto L55;
        r32 = true;
        goto L56
    L61:
        r8 = r29;
        r9 = null;
        goto L62
    L102:
        return null;
    L22:
        if ((D20().getValue() instanceof ry9.j.h) == false) goto L35;
        String r34 = this.D;
        if (r34 != null) goto L26;
    L33:
        r34 = this.C;
    L34:
        String r110 = r34;
    L36:
        if (r110 == null) goto L46;
        com.larus.bmhome.resource.access.f0 r35 = ICreationResourceAccessService.a.c(this.J);
        if (r35 == null) goto L40;
        String r111 = r35.c;
    L41:
        String r112 = this.J;
        if (r35 == null) goto L44;
        String r113 = r35.d;
    L45:
        r29 = new MediaAttachment(null, r111, null, null, r110, r112, r113, this.L, null, null, null, null, 3853, null);
        goto L47
    L44:
        r113 = null;
        goto L45
    L40:
        r111 = null;
        goto L41
    L46:
        r29 = null;
        goto L47
    L26:
        if (r34.length() <= 0) goto L28;
        boolean r36 = true;
    L29:
        if (r36 == true) goto L32;
        r34 = null;
    L32:
        if (r34 != null) goto L34;
    L28:
        r36 = false;
        goto L29
    L35:
        r110 = null;
        goto L36
    L17:
        r28 = null;
    L7:
        r2 = new ImageSelectorComponent$getSendAttachmentInfo$1(this, r42);
        goto L8
    }

    public final Object c4(Continuation<? super Bitmap> r5) {
        ny9.s r0 = G3();
        if (r0 == null) goto L14;
        Bundle r1 = r0.a;
        if (r1 == null) goto L7;
        String r2 = r1.getString("ref_raw_image_url");
    L8:
        if (r2 == null) goto L15;
        Object r6 = BuildersKt.withContext(Dispatchers.getIO(), new ImageSelectorComponent$getPassedRawImageBitmap$2$1(r2, this, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r6;
    L13:
        return (Bitmap) r6;
    L15:
        return null;
    L7:
        r2 = null;
        goto L8
    L14:
        return null;
    }

    public final void l4(String r8) {
        if (r8 != null) goto L8;
        ny9.s r9 = (ny9.s) s1a.d.a(this).a(ny9.s.class);
        if (r9 == null) goto L7;
        r8 = r9.p();
        goto L8
    L7:
        r8 = null;
    L8:
        if (r8 == null) goto L11;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new ImageSelectorComponent$initPassedAlbumImg$1$1(this, r8, null), 2, null);
        return;
    }

    public final void onViewCreated(View r15) {
        String r0 = "";
        Intrinsics.checkNotNullParameter(r15, "view");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        ouc.v r2 = xt7.d.b;     // Catch: Throwable -> L11
        juc.c r3 = com.larus.bmhome.actionbar.model.m1.Companion.serializer();     // Catch: Throwable -> L11
        com.larus.bmhome.actionbar.model.u r4 = (com.larus.bmhome.actionbar.model.u) this.s.getValue();     // Catch: Throwable -> L11
        if (r4 == null) goto L6;
        String r5 = r4.d;     // Catch: Throwable -> L11
    L7:
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        Object r6 = Result.constructor-impl((com.larus.bmhome.actionbar.model.m1) r2.c(r3, r5));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r6) == false) goto L16;
        r6 = null;
    L16:
        this.t = (com.larus.bmhome.actionbar.model.m1) r6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.z = com.larus.ui.arch.component.internal.attach.a.b(this, this).registerForActivityResult(new ActivityResultContracts.GetContent(), new u(this));
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.A = com.larus.ui.arch.component.internal.attach.a.b(this, this).registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new v(this));
        py9.a r7 = Q3();
        boolean r8 = false;
        if (r7 != null) goto L19;
    L21:
        boolean r9 = false;
    L22:
        if (r9 == false) goto L26;
        py9.a r10 = Q3();
        if (r10 == null) goto L26;
        r10.Bl("instructionPageAutoShow");
    L26:
        ImageSelectorView r11 = X3();
        int r12 = ImageSelectorView.c.e;
        ImageSelectorView.c r13 = ImageSelectorView.c.a.a(getContext());
        boolean r14 = v19.h.a;
        if (v19.h.b(getContext()) == false) goto L35;
        com.larus.bmhome.actionbar.model.m1 r16 = this.t;
        if (r16 == null) goto L42;
        com.larus.bmhome.actionbar.model.l1 r17 = r16.c;
        if (r17 == null) goto L42;
        com.larus.bmhome.actionbar.model.g1 r18 = r17.b;
        if (r18 == null) goto L42;
        String r19 = r18.b;
    L43:
        if (r19 != null) goto L47;
        r19 = r13.a;
        if (r19 != null) goto L47;
        r19 = "";
    L47:
        com.larus.bmhome.actionbar.model.m1 r20 = this.t;
        if (r20 == null) goto L52;
        com.larus.bmhome.actionbar.model.l1 r21 = r20.c;
        if (r21 == null) goto L52;
        String r22 = r21.c;
    L53:
        if (r22 != null) goto L56;
        r22 = "";
    L56:
        if (r22.length() != 0) goto L58;
        boolean r23 = true;
    L59:
        if (r23 == false) goto L65;
        String r24 = r13.b;
        if (r24 == null) goto L64;
        r0 = r24;
    L64:
        r22 = r0;
    L65:
        ny9.s r25 = G3();
        if (r25 == null) goto L75;
        com.larus.bmhome.actionbar.model.r r26 = r25.k();
        if (r26 == null) goto L75;
        Integer r27 = r26.a;
        if (r27 == null) goto L75;
        if (r27.intValue() != 18) goto L75;
        boolean r28 = true;
    L76:
        if (r28 == true) goto L91;
        ny9.s r29 = G3();
        if (r29 == null) goto L87;
        com.larus.bmhome.actionbar.model.r r30 = r29.k();
        if (r30 == null) goto L87;
        Integer r31 = r30.a;
        if (r31 == null) goto L87;
        if (r31.intValue() != 24) goto L87;
        boolean r32 = true;
    L88:
        if (r32 == true) goto L91;
        int r33 = r13.c;
    L92:
        ImageSelectorView.c r34 = new ImageSelectorView.c(r19, r22, r33, new p0(this));
        r11.getClass();
        Intrinsics.checkNotNullParameter(r34, "config");
        r11.b = r34;
        ImageSelectorView r35 = X3();
        py9.a r36 = Q3();
        if (r36 != null) goto L95;
    L97:
        r35.V5(new sy9.b.a(r8));
        View r37 = F2();
        if ((r37 instanceof FrameLayout) == false) goto L100;
        FrameLayout r38 = (FrameLayout) r37;
    L101:
        if (r38 == null) goto L103;
        r38.addView(X3(), -1, -1);
    L103:
        F2().post(new w(this));
        LarusFragmentCreationPageBinding r39 = d4();
        if (r39 == null) goto L108;
        FrameLayout r40 = r39.d;
        if (r40 == null) goto L108;
        r40.setOnTouchListener(new x(this));
    L108:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ImageSelectorComponent$bindObservers$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ImageSelectorComponent$bindObservers$2(this, null), 3, null);
        return;
    L100:
        r38 = null;
        goto L101
    L95:
        if (r36.n70() != true) goto L97;
        r8 = true;
    L87:
        r32 = false;
    L91:
        r33 = 0;
    L75:
        r28 = false;
        goto L76
    L58:
        r23 = false;
    L52:
        r22 = null;
    L42:
        r19 = null;
        goto L43
    L35:
        com.larus.bmhome.actionbar.model.m1 r41 = this.t;
        if (r41 == null) goto L42;
        com.larus.bmhome.actionbar.model.l1 r42 = r41.c;
        if (r42 == null) goto L42;
        com.larus.bmhome.actionbar.model.g1 r43 = r42.a;
        if (r43 == null) goto L42;
        r19 = r43.b;
        goto L43
    L19:
        if (r7.n70() != true) goto L21;
        r9 = true;
        goto L22
    L6:
        r5 = null;
    L11:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final void p4(String r9) {
        if (r9 != null) goto L8;
        ny9.s r10 = G3();
        if (r10 == null) goto L7;
        r9 = r10.o();
        goto L8
    L7:
        r9 = null;
    L8:
        if (r9 != null) goto L10;
        return;
    L10:
        if ((!StringsKt.isBlank(r9)) == false) goto L20;
        this.G = r9;
        ny9.s r1 = G3();
        if (r1 == null) goto L16;
        Bundle r2 = r1.a;
        if (r2 == null) goto L16;
        String r3 = r2.getString("image_second_edit_scene");
    L17:
        this.R = r3;
        this.F = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ImageSelectorComponent$initPassedUrl$1$1(r9, this, null), 3, null);
        return;
    L16:
        r3 = null;
        goto L17
    }

    @Override // ry9.g
    public final List<com.larus.bmhome.actionbar.model.u> th(boolean r26) {
        ry9.j r0 = (ry9.j) this.m.getValue();
        Object r3 = null;
        if ((r0 instanceof ry9.j.c) == false) goto L44;
        com.larus.bmhome.actionbar.model.u r4 = (com.larus.bmhome.actionbar.model.u) this.s.getValue();
        if (r4 == null) goto L7;
        Integer r5 = r4.a;
    L8:
        ry9.i r1 = ((ry9.j.c) r0).b;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.larus.uaigc.bean.createpage.component.mediacontainer.MediaSelectorData.ImageSelectorData");
        ry9.i.a r2 = (ry9.i.a) r1;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L37
        com.larus.bmhome.actionbar.model.m1 r7 = this.t;     // Catch: Throwable -> L37
        if (r7 == null) goto L34;
        ouc.v r8 = xt7.d.b;     // Catch: Throwable -> L37
        juc.n r9 = com.larus.bmhome.actionbar.model.m1.Companion.serializer();     // Catch: Throwable -> L37
        MediaAttachment r10 = r2.a;     // Catch: Throwable -> L37
        ny9.s r11 = G3();     // Catch: Throwable -> L37
        if (r11 == null) goto L16;
        boolean r12 = true;
        if (r11.x() != true) goto L16;
    L17:
        if (r12 == false) goto L33;
        String r13 = r10.getPreviewUrl();     // Catch: Throwable -> L37
        if (r13 != null) goto L22;
    L26:
        r13 = r10.getUrl();     // Catch: Throwable -> L37
    L27:
        String r14 = r13;
        Boolean r15 = r10.getAiCreationImage();     // Catch: Throwable -> L37
        Boolean r16 = Boolean.TRUE;     // Catch: Throwable -> L37
        if (Intrinsics.areEqual(r15, r16) == true) goto L30;
    L32:
        r10 = MediaAttachment.copy$default(r10, r14, null, null, null, null, null, null, null, null, null, null, r16, 2046, null);     // Catch: Throwable -> L37
        goto L33
    L30:
        if (Intrinsics.areEqual(r14, r10.getUrl()) == false) goto L32;
    L22:
        if (com.larus.utils.o0.d(r13) == true) goto L25;
        r13 = null;
    L25:
        if (r13 != null) goto L27;
    L33:
        String r17 = r8.a(r9, com.larus.bmhome.actionbar.model.m1.a(r7, r10));     // Catch: Throwable -> L37
    L35:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L37
    L40:
        if (Result.isFailure-impl(r18) == true) goto L57;
        r3 = r18;
    L57:
        return CollectionsKt.listOf(new com.larus.bmhome.actionbar.model.u(r5, 14, null, (String) r3, null, null, null, 244));
    L16:
        r12 = false;
        goto L17
    L34:
        r17 = null;
    L37:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    L7:
        r5 = null;
        goto L8
    L44:
        if (r26 == false) goto L58;
        com.larus.bmhome.actionbar.model.u r20 = (com.larus.bmhome.actionbar.model.u) this.s.getValue();
        if (r20 == null) goto L48;
        Integer r21 = r20.a;
    L49:
        com.larus.bmhome.actionbar.model.u r22 = (com.larus.bmhome.actionbar.model.u) this.s.getValue();
        if (r22 == null) goto L52;
        String r23 = r22.d;
    L54:
        return CollectionsKt.listOf(new com.larus.bmhome.actionbar.model.u(r21, 14, null, r23, null, null, null, 244));
    L52:
        r23 = null;
        goto L54
    L48:
        r21 = null;
        goto L49
    L58:
        return null;
    }

    public static final Object p3(ImageSelectorComponent r7, Continuation r8) {
        r7.getClass();
        if ((r8 instanceof ImageSelectorComponent$resolveRetryLocalPath$1) == false) goto L7;
        ImageSelectorComponent$resolveRetryLocalPath$1 r0 = (ImageSelectorComponent$resolveRetryLocalPath$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L39:
        File r10 = (File) r9;
        if (r10 == null) goto L54;
        String r11 = r10.getPath();
        if (r11 == null) goto L54;
        if ((!StringsKt.isBlank(r11)) == true) goto L46;
    L48:
        if (r4 == true) goto L51;
        r11 = null;
    L51:
        if (r11 == null) goto L54;
        r7.T4(r11);
    L55:
        return r11;
    L46:
        if (new PolarisFileWrapper(r11).exists() == false) goto L48;
        r4 = true;
    L54:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        r11 = r7.C;
        if (r11 != null) goto L17;
    L33:
        Bitmap r12 = r7.X3().getCurBitmap();
        if (r12 == null) goto L54;
        CoroutineDispatcher r5 = Dispatchers.getIO();
        ImageSelectorComponent$resolveRetryLocalPath$localFile$1 r6 = new ImageSelectorComponent$resolveRetryLocalPath$localFile$1(r7, r12, null);
        r0.label = 1;
        r9 = BuildersKt.withContext(r5, r6, r0);
        if (r9 != r2) goto L39;
        return r2;
    L17:
        if ((!StringsKt.isBlank(r11)) == true) goto L20;
        r11 = null;
    L20:
        if (r11 == null) goto L33;
        if (com.larus.uaigc.helper.g.b(r11) == false) goto L24;
    L27:
        boolean r13 = true;
    L28:
        if (r13 == true) goto L31;
        r11 = null;
    L31:
        if (r11 == null) goto L33;
    L24:
        if (new PolarisFileWrapper(r11).exists() == true) goto L27;
        r13 = false;
    L7:
        r0 = new ImageSelectorComponent$resolveRetryLocalPath$1(r7, r8);
        goto L8
    }

    public final mr9.h D3(String r12, String r13) {
        boolean r1 = false;
        if (r12.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L9;
        ResourceCenter.a.getClass();
        boolean r14 = ResourceCenter.d(r12);
        String r6 = com.larus.platform.service.o.a.getDeviceId();
        String r8 = f5();
        ny9.s r4 = G3();
        if (r4 == null) goto L15;
        Bundle r5 = r4.b();
        if (r5 == null) goto L15;
        String r7 = r5.getString("chat_section_id");
    L16:
        String r9 = "";
        if (r7 != null) goto L20;
        r7 = "";
    L20:
        if (r7.length() != 0) goto L22;
        r1 = true;
    L22:
        if (r1 == false) goto L33;
        com.larus.bmhome.chat.component.cvs.y r2 = (com.larus.bmhome.chat.component.cvs.y) this.p.getValue();
        if (r2 == null) goto L28;
        wc9.e r3 = r2.h();
        if (r3 == null) goto L28;
        String r10 = r3.B;
    L29:
        if (r10 == null) goto L32;
        r9 = r10;
    L32:
        String r11 = r9;
    L34:
        String r15 = this.L;
        if (r15 != null) goto L38;
        int r16 = wf9.b.a;
        r15 = com.flow.kmp.common.util.i.a();
        this.L = r15;
        Unit r17 = Unit.INSTANCE;
    L38:
        return new mr9.h(r14, new ResourceAttachmentExtra(r6, r13, r8, r11, r15), null, 28);
    L28:
        r10 = null;
        goto L29
    L33:
        r11 = r7;
    L15:
        r7 = null;
        goto L16
    L9:
        return new mr9.h(false, null, null, 31);
    L5:
        r0 = false;
        goto L7
    }

    public final void F4(String r11, ic8.m0 r12) {
        this.C = r11;
        this.D = r11;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(Uri.fromFile(new PolarisFileWrapper(r11)));     // Catch: Throwable -> L5
    L8:
        if (Result.isSuccess-impl(r1) == false) goto L15;
        Uri r2 = (Uri) r1;
        IBachDetectCenterAbility.Companion r3 = IBachDetectCenterAbility.a;
        if (r3.b() == false) goto L13;
        if (r2 == null) goto L13;
        r3.a(r2);
    L13:
        this.F = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new ImageSelectorComponent$onAlbumPreprocessed$2$2(this, r11, r12, null), 2, null);
    L15:
        if (Result.exceptionOrNull-impl(r1) == null) goto L20;
        FLogger.a.e("ImageSelectorComponent", "get uri of preprocessResult.path failed");
        t19.s r13 = t19.s.a;
        Context r14 = getContext();
        r13.getClass();
        t19.s.s(r14, 2131908214);
        X3().V5(new sy9.b.a(h5()));
        this.m.setValue(ry9.j.b.b);
        v4(false, "upload");
        return;
    L20:
        return;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final Object G4(Bitmap r40, Continuation<? super Unit> r41) {
        if ((r41 instanceof ImageSelectorComponent$reUploadImageOfPassedUrl$1) == false) goto L7;
        ImageSelectorComponent$reUploadImageOfPassedUrl$1 r1 = (ImageSelectorComponent$reUploadImageOfPassedUrl$1) r41;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        ImageSelectorComponent$reUploadImageOfPassedUrl$1 r10 = r1;
        Object r0 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r10.label;
        String r14 = null;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r0);
    L62:
        ny9.s r4 = G3();
        if (r4 == null) goto L65;
        com.larus.bmhome.actionbar.model.z0 r5 = r4.f();
    L66:
        ny9.u r6 = W3();
        if (r6 == null) goto L69;
        String r15 = r6.getBotId();
    L70:
        ny9.u r7 = W3();
        if (r7 == null) goto L73;
        String r19 = r7.getChatType();
    L74:
        ny9.u r8 = W3();
        if (r8 == null) goto L77;
        String r16 = r8.r();
    L78:
        ny9.u r9 = W3();
        if (r9 == null) goto L81;
        String r17 = r9.getEnterMethod();
    L82:
        if (r5 == null) goto L88;
        com.larus.bmhome.actionbar.model.r r11 = r5.q;
        if (r11 == null) goto L88;
        Integer r12 = r11.a;
        if (r12 == null) goto L88;
        String r22 = r12.toString();
    L89:
        if (r5 == null) goto L93;
        com.larus.bmhome.actionbar.model.r r18 = r5.q;
        if (r18 == null) goto L93;
        String r23 = r18.g;
    L94:
        ny9.u r20 = W3();
        if (r20 == null) goto L97;
        r14 = r20.q();
    L97:
        tx9.c0.H(r15, r16, r17, null, r19, r14, null, r22, r23, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, 33553992);
        return Unit.INSTANCE;
    L93:
        r23 = null;
    L88:
        r22 = null;
        goto L89
    L81:
        r17 = null;
        goto L82
    L77:
        r16 = null;
        goto L78
    L73:
        r19 = null;
        goto L74
    L69:
        r15 = null;
        goto L70
    L65:
        r5 = null;
        goto L66
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r0);
    L19:
        final File r21 = (File) r0;
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L22;
    L38:
        if (r21 == null) goto L40;
        String r24 = r21.getPath();
    L42:
        if (r24 != null) goto L44;
        r24 = "";
    L44:
        this.C = r24;
        if (r21 == null) goto L47;
        String r25 = r21.getPath();
    L48:
        if (r25 != null) goto L50;
        r25 = "";
    L50:
        this.D = r25;
        String r26 = UUID.randomUUID().toString();
        this.E = r26;
        if (r26 == null) goto L53;
        tx9.l0.d(r26);
    L54:
        if (r21 == null) goto L56;
        String r27 = r21.getPath();
    L57:
        if (r27 != null) goto L59;
        r27 = "";
    L59:
        Function1 r28 = new m(this);
        Function1 r29 = new n(this, r21);
        r10.label = 2;
        if (o5(this, r27, r28, r29, null, null, null, "creation_page/re_upload", null, r10, 376) != r13) goto L62;
        return r13;
    L56:
        r27 = null;
        goto L57
    L53:
        FLogger.a.i("ImageSelectorComponent", "curUploadTaskId is null before recordUploadStartTime");
        goto L54
    L47:
        r25 = null;
        goto L48
    L40:
        r24 = null;
        goto L42
    L22:
        if (IBachDetectCenterAbility.a.b() == false) goto L38;
        if (r21 == null) goto L38;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L30
        if (r21.exists() == false) goto L27;
        Uri r31 = Uri.fromFile(r21);     // Catch: Throwable -> L30
    L28:
        Object r32 = Result.constructor-impl(r31);     // Catch: Throwable -> L30
    L33:
        if (Result.isSuccess-impl(r32) == false) goto L37;
        Uri r33 = (Uri) r32;
        if (r33 == null) goto L37;
        IBachDetectCenterAbility.a.a(r33);
    L37:
        Result.box-impl(r32);
        goto L38
    L27:
        r31 = null;
    L30:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L16:
        ResultKt.throwOnFailure(r0);
        nz9.b.h("creation_page/re_upload", "creation_page", null, null, 28);
        Context r35 = getContext();
        r10.label = 1;
        r0 = BitmapHelperKt.d(r35, r40, "image_selector_default_image.jpeg", r10);
        if (r0 != r13) goto L19;
        return r13;
    L7:
        r1 = new ImageSelectorComponent$reUploadImageOfPassedUrl$1(this, r41);
        goto L8
    }

    public final void tM(Uri r13, boolean r14) {
        nz9.b.h("creation_page/album_upload", "creation_page", null, null, 28);
        this.B = r13;
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L6;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ImageSelectorComponent$startAlbumResourceAccess$1(r13, this, r14, null), 3, null);
        return;
    L6:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ImageSelectorComponent$onAlbumSelected$1(this, r13, r14, null), 3, null);
    }

    public final void v4(boolean r50, String r51) {
        ny9.u r0 = W3();
        String r1 = null;
        if (r0 == null) goto L5;
        String r11 = r0.getClickFrom();
    L6:
        ny9.u r2 = W3();
        if (r2 == null) goto L9;
        String r13 = r2.m();
    L10:
        ny9.u r3 = W3();
        if (r3 == null) goto L13;
        String r14 = r3.i();
    L14:
        uy9.a r4 = e4();
        if (r4 == null) goto L17;
        r4.Rq();
        String r5 = "template_page";
    L18:
        uy9.a r6 = e4();
        if (r6 == null) goto L21;
        String r7 = r6.PG();
    L22:
        ny9.u r8 = W3();
        if (r8 == null) goto L25;
        String r17 = r8.getEnterMethod();
    L26:
        ny9.u r9 = W3();
        if (r9 == null) goto L29;
        r1 = r9.getBotId();
    L29:
        String r10 = r1;
        if (r50 == false) goto L32;
        String r12 = "1";
    L33:
        String r15 = r12;
        IAIChatControlTraceService.Companion r16 = IAIChatControlTraceService.a;
        tx9.y3.a(r10, r5, r7, r51, "pic", null, r15, null, null, r11, null, r13, r14, null, null, r17, null, r16.h(r16.gb()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -682080, 65535);
        return;
    L32:
        r12 = "0";
        goto L33
    L25:
        r17 = null;
        goto L26
    L21:
        r7 = null;
        goto L22
    L17:
        r5 = null;
        goto L18
    L13:
        r14 = null;
        goto L14
    L9:
        r13 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public final void q4(boolean r8, String r9, ic8.m0 r10) {
        com.larus.bmhome.resource.access.f0 r0 = ICreationResourceAccessService.a.c(this.J);
        String r2 = this.E;
        if (r2 != null) goto L6;
        return;
    L6:
        if (r9 == null) goto L8;
        Integer r4 = mr9.i.a(r9);
    L9:
        if (r0 == null) goto L17;
        Map r11 = r0.f;
        if (r11 == null) goto L17;
        String r12 = (String) r11.get("preprocess_file_size");
        if (r12 == null) goto L17;
        Long r13 = StringsKt.toLongOrNull(r12);
        if (r13 == null) goto L17;
    L19:
        Long r5 = r13;
    L21:
        if (r0 == null) goto L26;
        Map r14 = r0.f;
        if (r14 == null) goto L26;
        String r15 = (String) r14.get("preprocess_file_type");
        if (r15 == null) goto L26;
    L28:
        String r6 = r15;
    L30:
        tx9.l0.a("creation_page_album_single_image", r2, r8, r4, r5, r6);
        return;
    L26:
        if (r10 == null) goto L29;
        r15 = r10.d;
        goto L28
    L29:
        r6 = null;
    L17:
        if (r10 == null) goto L20;
        r13 = Long.valueOf(r10.c);
        goto L19
    L20:
        r5 = null;
        goto L21
    L8:
        r4 = null;
        goto L9
    }

    public static final Object Y2(ImageSelectorComponent r27, String r28, Bitmap r29, Continuation r30) {
        ImageSelectorComponent r0 = r27;
        r27.getClass();
        if ((r30 instanceof ImageSelectorComponent$explainResourceUrl$1) == false) goto L7;
        ImageSelectorComponent$explainResourceUrl$1 r2 = (ImageSelectorComponent$explainResourceUrl$1) r30;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        boolean r10 = false;
        if (r5 == 0) goto L22;
        if (r5 == 1) goto L21;
        if (r5 == 2) goto L20;
        if (r5 == 3) goto L19;
        if (r5 == 4) goto L18;
        if (r5 == 5) goto L19;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r0 = (ImageSelectorComponent) r2.L$1;
        Bitmap r6 = (Bitmap) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L87:
        Bitmap r7 = (Bitmap) r1;
        if (r7 == null) goto L91;
        r6 = r7;
    L91:
        r2.L$0 = null;
        r2.L$1 = null;
        r2.label = 5;
        if (r0.G4(r6, r2) != r4) goto L95;
        return r4;
    L95:
        return Unit.INSTANCE;
    L19:
        ResultKt.throwOnFailure(r1);
        goto L95
    L20:
        r0 = (ImageSelectorComponent) r2.L$1;
        Bitmap r8 = (Bitmap) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L76:
        Bitmap r9 = (Bitmap) r1;
        if (r9 == null) goto L80;
        r8 = r9;
    L80:
        r2.L$0 = null;
        r2.L$1 = null;
        r2.label = 3;
        if (r0.G4(r8, r2) != r4) goto L95;
        return r4;
    L21:
        Bitmap r11 = (Bitmap) r2.L$1;
        String r12 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
        Bitmap r13 = r11;
        String r14 = r12;
    L31:
        com.larus.network.http.y r15 = (com.larus.network.http.a) r1;
        if ((r15 instanceof com.larus.network.http.y) == false) goto L83;
        com.larus.uaigc.api.s r16 = (com.larus.uaigc.api.s) ((com.larus.network.http.a) r15).b;
        if (r16 == null) goto L38;
        List<com.larus.uaigc.api.q> r17 = r16.a();
        if (r17 == null) goto L38;
        com.larus.uaigc.api.q r18 = (com.larus.uaigc.api.q) CollectionsKt.firstOrNull(r17);
    L39:
        if (r18 == null) goto L41;
        String r19 = r18.c();
    L43:
        if (com.larus.utils.o0.d(r19) == false) goto L68;
        if (r18 == null) goto L46;
        r10 = Intrinsics.areEqual(r18.a(), Boxing.boxBoolean(false));
    L46:
        if (r10 == false) goto L68;
        FLogger.a.i("ImageSelectorComponent", "explainResourceUrl success, uri: " + r19);
        StateFlowImpl r20 = r0.m;
        com.larus.uaigc.api.p r21 = r18.b();
        if (r21 == null) goto L56;
        com.larus.uaigc.api.n r22 = r21.a();
        if (r22 == null) goto L56;
        com.larus.uaigc.api.m r23 = r22.a();
        if (r23 == null) goto L56;
        Long r24 = r23.b();
        if (r24 == null) goto L56;
        long r25 = r24.longValue();
    L57:
        Long r26 = Boxing.boxLong(r25);
        com.larus.uaigc.api.p r31 = r18.b();
        if (r31 == null) goto L66;
        com.larus.uaigc.api.n r32 = r31.a();
        if (r32 == null) goto L66;
        com.larus.uaigc.api.m r33 = r32.a();
        if (r33 == null) goto L66;
        Long r34 = r33.a();
        if (r34 == null) goto L66;
        long r35 = r34.longValue();
    L67:
        r20.setValue(new ry9.j.c(new ry9.i.a(new MediaAttachment(r14, r19, new ImageUploadInfo(r26, Boxing.boxLong(r35)), null, null, null, null, null, null, null, null, null, 4088, null), null)));
    L66:
        r35 = r13.getHeight();
    L56:
        r25 = r13.getWidth();
    L68:
        FLogger r36 = FLogger.a;
        StringBuilder r37 = new StringBuilder("explainResourceUrl success, but needRePush: ");
        if (r18 == null) goto L71;
        Boolean r38 = r18.a();
    L72:
        r37.append(r38);
        r36.i("ImageSelectorComponent", r37.toString());
        r2.L$0 = r13;
        r2.L$1 = r0;
        r2.label = 2;
        r1 = r0.c4(r2);
        if (r1 == r4) goto L97;
        r8 = r13;
        goto L76
    L97:
        return r4;
    L71:
        r38 = null;
        goto L72
    L41:
        r19 = null;
    L38:
        r18 = null;
        goto L39
    L83:
        FLogger.a.e("ImageSelectorComponent", "explainResourceUrl failed");
        r2.L$0 = r13;
        r2.L$1 = r0;
        r2.label = 4;
        r1 = r0.c4(r2);
        if (r1 == r4) goto L99;
        r6 = r13;
        goto L87
    L99:
        return r4;
    L22:
        ResultKt.throwOnFailure(r1);
        IBachDetectCenterAbility.Companion r39 = IBachDetectCenterAbility.a;
        if (r39.b() == false) goto L27;
        Uri r40 = com.larus.utils.y0.j(r28);
        if (r40 == null) goto L27;
        r39.a(r40);
    L27:
        List r41 = CollectionsKt.listOf(r28);
        r2.L$0 = r28;
        r13 = r29;
        r2.L$1 = r13;
        r2.label = 1;
        r1 = com.larus.uaigc.api.o.a(r41, false, r2);
        if (r1 == r4) goto L96;
        r14 = r28;
        goto L31
    L96:
        return r4;
    L7:
        r2 = new ImageSelectorComponent$explainResourceUrl$1(r0, r30);
        goto L8
    }

    public static final Object m3(ImageSelectorComponent r17, Uri r18, boolean r19, Continuation r20) {
        r17.getClass();
        if ((r20 instanceof ImageSelectorComponent$prepareAlbumUploadingUi$1) == false) goto L7;
        ImageSelectorComponent$prepareAlbumUploadingUi$1 r1 = (ImageSelectorComponent$prepareAlbumUploadingUi$1) r20;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        ImageSelectorComponent$prepareAlbumUploadingUi$1 r7 = r1;
        Object r0 = r7.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r7.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Job r4 = (Job) r7.L$0;
        ResultKt.throwOnFailure(r0);
    L18:
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
        uy9.a r5 = r17.e4();
        if (r5 == null) goto L22;
        r5.aL();
    L22:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r17), null, null, new ImageSelectorComponent$prepareAlbumUploadingUi$2(r17, null), 3, null);
        r17.X3().setEnableShowReselectIcon(false);
        Job r11 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r17), null, null, new ImageSelectorComponent$prepareAlbumUploadingUi$delayJob$1(r17, null), 3, null);
        r7.L$0 = r11;
        r7.label = 1;
        if (BuildersKt.withContext(Dispatchers.getIO(), new ImageSelectorComponent$preShowUploadingUri$2(r18, r17, r19, true, null), r7) == r8) goto L23;
        r4 = r11;
        goto L18
    L23:
        return r8;
    L7:
        r1 = new ImageSelectorComponent$prepareAlbumUploadingUi$1(r17, r20);
        goto L8
    }

    public final void k4(Bitmap r10, String r11, String r12, String r13) {
        FLogger.a.e("ImageSelectorComponent", "[handlePassedRemoteResourceAccessFail] errorCode=" + r11 + ", errorMessage=" + r12);
        String r14 = this.E;
        if (r14 != null) goto L7;
        r14 = this.J;
        if (r14 != null) goto L7;
        r14 = "";
    L7:
        tx9.l0.b("creation_page_passed_image_re_upload", r14, false, mr9.i.a(r11), null, null, 48);
        this.E = null;
        int r0 = com.larus.uaigc.service.e.a;
        if (Intrinsics.areEqual(r11, "review_un_pass") == false) goto L10;
        this.C = null;
        this.D = null;
        t19.s r15 = t19.s.a;
        Context r16 = getContext();
        r15.getClass();
        t19.s.s(r16, 2131908918);
        X3().V5(new sy9.b.a(h5()));
        this.m.setValue(ry9.j.b.b);
        v4(false, "review");
        nz9.b.e("creation_page/re_upload", "-103", null);
        return;
    L10:
        T4(r13);
        ImageSelectorView r17 = X3();
        Bitmap r3 = X3().getCurBitmap();
        if (r3 == null) goto L14;
        r10 = r3;
    L14:
        r17.V5(new sy9.b.C0075b(r10, h5()));
        this.m.setValue(ry9.j.f.b);
        v4(false, "upload");
        nz9.b.e("creation_page/re_upload", r11, null);
    }

    public static final Object z3(ImageSelectorComponent r50, String r51, String r52, Bitmap r53, Continuation r54) {
        r50.getClass();
        if ((r54 instanceof ImageSelectorComponent$submitPassedRemoteResourceAccess$1) == false) goto L7;
        ImageSelectorComponent$submitPassedRemoteResourceAccess$1 r2 = (ImageSelectorComponent$submitPassedRemoteResourceAccess$1) r54;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        ImageSelectorComponent$submitPassedRemoteResourceAccess$1 r6 = r2;
        Object r1 = r6.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r6.label;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        ResultKt.throwOnFailure(r1);
        String r10 = null;
    L70:
        ny9.u r0 = r50.W3();
        if (r0 == null) goto L73;
        String r11 = r0.getBotId();
    L74:
        ny9.u r5 = r50.W3();
        if (r5 == null) goto L77;
        String r15 = r5.getChatType();
    L78:
        ny9.u r7 = r50.W3();
        if (r7 == null) goto L81;
        String r12 = r7.r();
    L82:
        ny9.u r9 = r50.W3();
        if (r9 == null) goto L85;
        String r13 = r9.getEnterMethod();
    L86:
        ny9.s r14 = r50.G3();
        if (r14 == null) goto L95;
        com.larus.bmhome.actionbar.model.z0 r16 = r14.f();
        if (r16 == null) goto L95;
        com.larus.bmhome.actionbar.model.r r17 = r16.q;
        if (r17 == null) goto L95;
        Integer r18 = r17.a;
        if (r18 == null) goto L95;
        String r19 = r18.toString();
    L96:
        ny9.s r20 = r50.G3();
        if (r20 == null) goto L103;
        com.larus.bmhome.actionbar.model.z0 r21 = r20.f();
        if (r21 == null) goto L103;
        com.larus.bmhome.actionbar.model.r r22 = r21.q;
        if (r22 == null) goto L103;
        String r110 = r22.g;
    L104:
        ny9.u r23 = r50.W3();
        if (r23 == null) goto L107;
        String r111 = r23.q();
    L108:
        tx9.c0.H(r11, r12, r13, null, r15, r111, null, r19, r110, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, 33553992);
        return Unit.INSTANCE;
    L107:
        r111 = r10;
    L103:
        r110 = r10;
    L95:
        r19 = r10;
        goto L96
    L85:
        r13 = r10;
        goto L86
    L81:
        r12 = r10;
        goto L82
    L77:
        r15 = r10;
        goto L78
    L73:
        r11 = r10;
        goto L74
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r24 = (String) r6.L$4;
        String r25 = (String) r6.L$3;
        Bitmap r26 = (Bitmap) r6.L$2;
        String r112 = (String) r6.L$1;
        String r113 = (String) r6.L$0;
        ResultKt.throwOnFailure(r1);
        String r27 = r24;
        String r28 = r113;
    L58:
        String r29 = ((CreationRemoteConversationHelper.a) r1).a;
        ICreationResourceAccessService.Companion r30 = ICreationResourceAccessService.a;
        int r31 = com.larus.uaigc.service.p0.x;
        com.larus.bmhome.resource.access.j0.c r32 = new com.larus.bmhome.resource.access.j0.c(r112);
        mr9.h r33 = r50.D3(r25, r29);
        CountDownLatch r34 = new CountDownLatch(1);
        if ((true ^ StringsKt.isBlank(r27)) == false) goto L61;
        String r114 = r27;
    L62:
        if (r114 == null) goto L66;
        Map r115 = MapsKt.mapOf(TuplesKt.to("remote_detect_local_path", r114));
        if (r115 == null) goto L66;
    L67:
        String r210 = r25;
        com.larus.bmhome.resource.access.b0 r35 = r30.b(com.larus.uaigc.service.p0.a.b(r32, r210, "creation_remote", r33, true, r34, null, "ai_creation", "remote", null, new k(), new l(), null, null, null, null, r115, com.larus.uaigc.service.g.a, false, null, 1172608));
        r10 = null;
        r6.L$0 = null;
        r6.L$1 = null;
        r6.L$2 = null;
        r6.L$3 = null;
        r6.L$4 = null;
        r6.label = 3;
        if (r50.B4(r35, r25, r28, r26, r27, r6) != r8) goto L70;
        return r8;
    L66:
        r115 = MapsKt.emptyMap();
        goto L67
    L61:
        r114 = null;
        goto L62
    L17:
        String r36 = (String) r6.L$3;
        Bitmap r37 = (Bitmap) r6.L$2;
        String r116 = (String) r6.L$1;
        String r117 = (String) r6.L$0;
        ResultKt.throwOnFailure(r1);
        String r118 = r36;
        String r38 = r117;
        Object r119 = r1;
        String r39 = r116;
    L48:
        File r120 = (File) r119;
        if (r120 == null) goto L51;
        String r121 = r120.getPath();
    L52:
        if (r121 != null) goto L54;
        r121 = "";
    L54:
        String r122 = r121;
        r50.C = null;
        r50.D = null;
        r50.T4(r122);
        r50.E3(r37);
        String r40 = r118;
        r50.m.setValue(new ry9.j.c(new ry9.i.a(new MediaAttachment(r38, null, new ImageUploadInfo(Boxing.boxLong(r37.getWidth()), Boxing.boxLong(r37.getHeight())), null, r122, r40, null, r50.L, null, null, null, null, 3914, null), null)));
        tx9.l0.d(r40);
        ResourceCenter r41 = ResourceCenter.a;
        FlowResourceScene r42 = FlowResourceScene.ImageVLM;
        r41.getClass();
        ResourceCenter.k(r40, r42);
        r6.L$0 = r38;
        r6.L$1 = r39;
        r6.L$2 = r37;
        r6.L$3 = r40;
        r6.L$4 = r122;
        r6.label = 2;
        Object r43 = r50.W4(r6);
        if (r43 == r8) goto L111;
        r112 = r39;
        r1 = r43;
        r27 = r122;
        r28 = r38;
        r26 = r37;
        r25 = r40;
        goto L58
    L111:
        return r8;
    L51:
        r121 = null;
        goto L52
    L18:
        ResultKt.throwOnFailure(r1);
        nz9.b.h("creation_page/re_upload", "creation_page", null, null, 28);
        StringBuilder r44 = new StringBuilder();
        r44.append(UUID.randomUUID());
        r44.append('_');
        r44.append(System.currentTimeMillis());
        String r45 = r44.toString();
        r50.J = r45;
        r50.K = null;
        r50.E = r45;
        ny9.s r46 = r50.G3();
        boolean r123 = false;
        if (r46 == null) goto L34;
        Bundle r47 = r46.a;
        if (r47 == null) goto L23;
        String r48 = r47.getString("ref_image_local_message_id");
    L24:
        if (r48 == null) goto L34;
        if (r48.length() <= 0) goto L28;
        boolean r124 = true;
    L29:
        if (r124 == true) goto L32;
        r48 = null;
    L32:
        if (r48 == null) goto L34;
    L44:
        r50.L = r48;
        CoroutineDispatcher r49 = Dispatchers.getIO();
        ImageSelectorComponent$submitPassedRemoteResourceAccess$localFile$1 r125 = new ImageSelectorComponent$submitPassedRemoteResourceAccess$localFile$1(r50, r53, null);
        r6.L$0 = r51;
        r6.L$1 = r52;
        r6.L$2 = r53;
        r6.L$3 = r45;
        r6.label = 1;
        Object r55 = BuildersKt.withContext(r49, r125, r6);
        if (r55 == r8) goto L110;
        r118 = r45;
        r119 = r55;
        r39 = r52;
        r37 = r53;
        r38 = r51;
        goto L48
    L110:
        return r8;
    L28:
        r124 = false;
        goto L29
    L23:
        r48 = null;
    L34:
        r48 = r50.L;
        if (r48 != null) goto L37;
    L41:
        r48 = null;
    L42:
        if (r48 != null) goto L44;
        int r56 = wf9.b.a;
        r48 = com.flow.kmp.common.util.i.a();
        goto L44
    L37:
        if (r48.length() <= 0) goto L39;
        r123 = true;
    L39:
        if (r123 == false) goto L41;
    L7:
        r2 = new ImageSelectorComponent$submitPassedRemoteResourceAccess$1(r50, r54);
        goto L8
    }

    public final Object B4(com.larus.bmhome.resource.access.b0 r35, String r36, String r37, Bitmap r38, String r39, Continuation<? super Unit> r40) {
        final com.larus.bmhome.resource.access.b0 r1 = r35;
        final Bitmap r2 = r38;
        if ((r40 instanceof ImageSelectorComponent$observePassedRemoteResourceAccessTask$1) == false) goto L7;
        ImageSelectorComponent$observePassedRemoteResourceAccessTask$1 r4 = (ImageSelectorComponent$observePassedRemoteResourceAccessTask$1) r40;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        String r8 = (String) r4.L$4;
        r2 = (Bitmap) r4.L$3;
        String r9 = (String) r4.L$2;
        String r10 = (String) r4.L$1;
        com.larus.bmhome.resource.access.b0 r11 = (com.larus.bmhome.resource.access.b0) r4.L$0;
        ResultKt.throwOnFailure(r3);
        String r12 = r9;
        String r13 = r10;
        String r14 = r8;
        r1 = r11;
        Object r15 = r3;
    L18:
        com.larus.bmhome.resource.access.a0.d r16 = (com.larus.bmhome.resource.access.a0) r15;
        boolean r17 = false;
        if (r13.length() <= 0) goto L21;
        boolean r18 = true;
    L22:
        if (r18 == true) goto L24;
    L26:
        boolean r19 = false;
    L28:
        if (r19 == true) goto L32;
        FLogger.a.i("ImageSelectorComponent", "[observePassedRemoteResourceAccessTask] ignore stale callback, expected=" + r13 + ", current=" + this.J);
        return Unit.INSTANCE;
    L32:
        if ((r16 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L106;
        com.larus.bmhome.resource.access.a0.d r20 = r16;
        com.larus.bmhome.resource.access.f0 r21 = r20.a;
        mr9.l r22 = r21.e;
        if (r22 != null) goto L36;
        r22 = new mr9.l(r21.c, null, r21.d, null, null, false, null, 122);
    L36:
        String r23 = r22.a;
        if (r23 != null) goto L39;
    L42:
        boolean r24 = true;
    L44:
        if (r24 == false) goto L54;
        String r25 = r22.c;
        if (r25 != null) goto L48;
    L51:
        boolean r26 = true;
    L52:
        if (r26 == false) goto L54;
        k4(r2, "empty_upload_result", "upload result is null", null);
    L124:
        return Unit.INSTANCE;
    L48:
        if (r25.length() == 0) goto L51;
        r26 = false;
    L54:
        com.larus.bmhome.resource.access.j0.b r27 = r20.a.b;
        if ((r27 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L57;
        com.larus.bmhome.resource.access.j0.b r28 = r27;
    L58:
        if (r28 == null) goto L60;
        String r29 = r28.b;
    L61:
        String r210 = "";
        if (r29 != null) goto L65;
        r29 = "";
    L65:
        if (r14.length() <= 0) goto L67;
        r17 = true;
    L67:
        if (r17 == true) goto L70;
        r14 = null;
    L70:
        if (r14 != null) goto L72;
        String r110 = r29;
    L73:
        mr9.d r30 = r22.d;
        if (r30 == null) goto L76;
        int r31 = r30.b;
    L83:
        long r111 = r31;
    L84:
        mr9.d r32 = r22.d;
        if (r32 == null) goto L87;
        int r33 = r32.a;
    L94:
        long r34 = r33;
    L95:
        ResourceUploadInstantInfo r41 = r22.g;
        if (r41 != null) goto L98;
        r41 = this.I;
    L98:
        this.I = r41;
        E3(r2);
        this.C = null;
        this.D = null;
        this.m.setValue(new ry9.j.c(new ry9.i.a(new MediaAttachment(r12, r22.a, new ImageUploadInfo(Long.valueOf(r111), Long.valueOf(r34)), null, r110, this.J, r22.c, this.L, null, null, null, null, 3848, null), null)));
        String r42 = this.E;
        if (r42 != null) goto L103;
        r42 = this.J;
        if (r42 != null) goto L103;
    L104:
        tx9.l0.b("creation_page_passed_image_re_upload", r210, true, null, null, null, 56);
        this.E = null;
        v4(true, null);
        nz9.b.e("creation_page/re_upload", "0", null);
        V4();
    L103:
        r210 = r42;
        goto L104
    L87:
        String r43 = (String) r20.a.f.get("height");
        if (r43 == null) goto L90;
        Long r44 = StringsKt.toLongOrNull(r43);
    L91:
        if (r44 == null) goto L93;
        r34 = r44.longValue();
        goto L95
    L93:
        r33 = r2.getHeight();
        goto L94
    L90:
        r44 = null;
        goto L91
    L76:
        String r45 = (String) r20.a.f.get("width");
        if (r45 == null) goto L79;
        Long r46 = StringsKt.toLongOrNull(r45);
    L80:
        if (r46 == null) goto L82;
        r111 = r46.longValue();
        goto L84
    L82:
        r31 = r2.getWidth();
        goto L83
    L79:
        r46 = null;
        goto L80
    L72:
        r110 = r14;
        goto L73
    L60:
        r29 = null;
        goto L61
    L57:
        r28 = null;
        goto L58
    L39:
        if (r23.length() == 0) goto L42;
        r24 = false;
        goto L44
    L106:
        if ((r16 instanceof com.larus.bmhome.resource.access.a0.c) == false) goto L109;
        com.larus.bmhome.resource.access.r r47 = ((com.larus.bmhome.resource.access.a0.c) r16).a;
        k4(r2, r47.b, r47.c, r14);
        goto L124
    L109:
        if ((r16 instanceof com.larus.bmhome.resource.access.a0.a) == false) goto L115;
        if (ICreationResourceAccessServiceKt.d(r16) == false) goto L113;
        FLogger.a.i("ImageSelectorComponent", "[observePassedRemoteResourceAccessTask] page destroy cancel, taskId=" + r1.getTaskId());
        goto L124
    L113:
        ResourceUploadError r48 = ICreationResourceAccessServiceKt.g(r16);
        k4(r2, r48.getCode(), r48.getMsg(), r14);
        goto L124
    L115:
        if (Intrinsics.areEqual(r16, com.larus.bmhome.resource.access.a0.b.a) == true) goto L124;
        if ((r16 instanceof com.larus.bmhome.resource.access.a0.e) == true) goto L124;
        if ((r16 instanceof com.larus.bmhome.resource.access.a0.f) == true) goto L124;
        throw new NoWhenBranchMatchedException();
    L24:
        if (Intrinsics.areEqual(this.J, r13) == false) goto L26;
        r19 = true;
        goto L28
    L21:
        r18 = false;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        Function1 r49 = new i(r1, this, r2);
        Function1 r50 = new j(r1, this, r2);
        r4.L$0 = r1;
        r13 = r36;
        r4.L$1 = r13;
        r4.L$2 = r37;
        r4.L$3 = r2;
        r4.L$4 = r39;
        r4.label = 1;
        Object r51 = CreationResourceAccessPerfBridgeKt.b(r1, "creation_page/re_upload", r49, r50, r4);
        if (r51 != r6) goto L17;
        return r6;
    L17:
        r15 = r51;
        r14 = r39;
        r12 = r37;
    L7:
        r4 = new ImageSelectorComponent$observePassedRemoteResourceAccessTask$1(this, r40);
        goto L8
    }

    public final Object i5(String r37, final Function1<? super ResourceUploadError, Unit> r38, final Function1<? super mr9.l, Unit> r39, ic8.m0 r40, Uri r41, String r42, String r43, String r44, Function1<? super com.larus.bmhome.resource.access.j0.b, Unit> r45, Continuation<? super Unit> r46) {
        if ((r46 instanceof ImageSelectorComponent$submitImageResourceAccess$1) == false) goto L7;
        ImageSelectorComponent$submitImageResourceAccess$1 r3 = (ImageSelectorComponent$submitImageResourceAccess$1) r46;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        boolean r1 = r3.Z$0;
        Function1 r7 = (Function1) r3.L$9;
        Function1 r8 = (Function1) r3.L$8;
        String r9 = (String) r3.L$7;
        Function1<? super com.larus.bmhome.resource.access.j0.b, Unit> r10 = (Function1) r3.L$6;
        String r11 = (String) r3.L$5;
        String r12 = (String) r3.L$4;
        String r13 = (String) r3.L$3;
        Uri r14 = (Uri) r3.L$2;
        ic8.m0 r15 = (ic8.m0) r3.L$1;
        String r16 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        String r23 = r12;
        String r22 = r13;
        Uri r17 = r14;
        ic8.m0 r18 = r15;
        String r19 = r11;
        String r110 = r16;
    L27:
        String r20 = ((CreationRemoteConversationHelper.a) r2).a;
        if (r1 == false) goto L56;
        ICreationResourceAccessService.Companion r21 = ICreationResourceAccessService.a;
        int r24 = com.larus.uaigc.service.p0.x;
        if (r17 == null) goto L32;
        com.larus.bmhome.resource.access.j0 r111 = new com.larus.bmhome.resource.access.j0.a(r17.toString());
    L52:
        CountDownLatch r25 = new CountDownLatch(1);
        String r112 = r9;
        com.larus.bmhome.resource.access.b0 r26 = r21.b(com.larus.uaigc.service.p0.a.b(r111, r112, null, D3(r9, r20), true, r25, null, r22, r23, null, new s(), new t(), null, null, null, null, null, com.larus.uaigc.service.g.a, false, null, 1303688));
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L58;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new ImageSelectorComponent$observeResourceAccessTask$2(r26, r19, r10, r8, r7, null), 2, null);
    L58:
        return Unit.INSTANCE;
    L32:
        if (r18 == null) goto L34;
        String r27 = r18.a;
    L35:
        int r113 = com.larus.uaigc.helper.g.a;
        if (r18 == null) goto L38;
        String r114 = r18.a;
    L39:
        Boolean r115 = Boolean.valueOf(com.larus.uaigc.helper.g.b(r114));
        if (r18 == null) goto L47;
        Long r28 = Long.valueOf(r18.c);
        if (r28.longValue() < 0) goto L44;
        boolean r29 = true;
    L45:
        if (r29 == false) goto L47;
    L48:
        if (r18 == null) goto L50;
        mr9.c r30 = r18.l;
    L51:
        r111 = new com.larus.bmhome.resource.access.j0.b(r110, r27, r115, r28, r30);
        goto L52
    L50:
        r30 = null;
        goto L51
    L44:
        r29 = false;
    L47:
        r28 = null;
        goto L48
    L38:
        r114 = null;
        goto L39
    L34:
        r27 = null;
        goto L35
    L56:
        ICreationResourceAccessService.Companion r31 = ICreationResourceAccessService.a;
        int r32 = com.larus.uaigc.service.p0.x;
        String r116 = r9;
        r31.b(com.larus.uaigc.service.p0.a.c(r110, r116, r18, D3(r9, r20), true, new CountDownLatch(1), null, r22, r23, null, r8, r7, null, null, LifecycleOwnerKt.getLifecycleScope(this), 1034504));
        goto L58
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        com.larus.uaigc.helper.f.a.getClass();
        boolean r33 = com.larus.uaigc.helper.f.a();
        if (r33 == false) goto L17;
    L20:
        StringBuilder r34 = new StringBuilder();
        r34.append(UUID.randomUUID());
        r34.append('_');
        r34.append(System.currentTimeMillis());
        this.J = r34.toString();
        this.K = null;
        int r35 = wf9.b.a;
        this.L = com.flow.kmp.common.util.i.a();
        String r36 = this.J;
        if (r36 != null) goto L23;
        r36 = "";
    L23:
        r9 = r36;
        FLogger.a.i("ImageSelectorComponent", "[submitImageResourceAccess] localMessageId=" + this.L + ", identifier=" + r9);
        ResourceCenter r47 = ResourceCenter.a;
        FlowResourceScene r48 = FlowResourceScene.ImageVLM;
        r47.getClass();
        ResourceCenter.k(r9, r48);
        r8 = new q(this, r39);
        Function1 r49 = new r(this, r38);
        r3.L$0 = r37;
        r3.L$1 = r40;
        r17 = r41;
        r3.L$2 = r17;
        r3.L$3 = r42;
        r3.L$4 = r43;
        r19 = r44;
        r3.L$5 = r19;
        r3.L$6 = r45;
        r3.L$7 = r9;
        r3.L$8 = r8;
        r3.L$9 = r49;
        r3.Z$0 = r33;
        r3.label = 1;
        Object r50 = W4(r3);
        if (r50 != r5) goto L26;
        return r5;
    L26:
        r7 = r49;
        r22 = r42;
        r23 = r43;
        r10 = r45;
        r18 = r40;
        r110 = r37;
        r1 = r33;
        r2 = r50;
        goto L27
    L17:
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L20;
        r38.invoke(new ResourceUploadError(ResourceUploadError.NO_NETWORK, "network not available"));
    L7:
        r3 = new ImageSelectorComponent$submitImageResourceAccess$1(this, r46);
        goto L8
    }

    public static /* synthetic */ Object o5(ImageSelectorComponent r14, String r15, Function1 r16, Function1 r17, ic8.m0 r18, Uri r19, String r20, String r21, c1 r22, Continuation r23, int r24) {
        if ((r24 & 8) == 0) goto L5;
        ic8.m0 r7 = null;
    L7:
        if ((r24 & 16) == 0) goto L9;
        Uri r8 = null;
    L11:
        if ((r24 & 32) == 0) goto L13;
        String r9 = "ai_creation";
    L15:
        if ((r24 & 128) == 0) goto L17;
        String r11 = "creation_page/album_upload";
    L19:
        if ((r24 & 256) == 0) goto L21;
        Function1<? super com.larus.bmhome.resource.access.j0.b, Unit> r12 = new b0();
    L23:
        return r14.i5(r15, r16, r17, r7, r8, r9, null, r11, r12, r23);
    L21:
        r12 = r22;
        goto L23
    L17:
        r11 = r21;
        goto L19
    L13:
        r9 = r20;
        goto L15
    L9:
        r8 = r19;
        goto L11
    L5:
        r7 = r18;
        goto L7
    }
}
