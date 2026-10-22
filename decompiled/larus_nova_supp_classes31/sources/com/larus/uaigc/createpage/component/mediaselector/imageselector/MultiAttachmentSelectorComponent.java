package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.MimeTypeMap;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.CreationReferenceMediaType;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.actionbar.model.VideoUploadInfo;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.picture.LocalTakePictureImpl;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.resource.access.ResourceCancelReason;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.bmhome.resource.access.ResourcePhase;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.bmhome.view.resourcebar.bean.ItemStatus;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.platform.AlbumHelper;
import com.larus.platform.api.creation.IBachDetectCenterAbility;
import com.larus.platform.creation.CreationMultiReferenceLogEvent;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.platform.model.album.AlbumSelectionMediaType;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.model.album.CreationReferenceAlbumAttachment;
import com.larus.platform.model.album.CreationReferenceAlbumConfig;
import com.larus.platform.model.album.CreationReferenceAlbumMediaRule;
import com.larus.platform.model.album.CreationReferenceAlbumMediaType;
import com.larus.platform.model.album.CreationReferenceAlbumMixedRule;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.uaigc.bean.createpage.component.mediacontainer.CreationReferenceAttachmentSource;
import com.larus.uaigc.bean.createpage.component.mediacontainer.CreationReferenceAttachmentState;
import com.larus.uaigc.bean.createpage.component.mediacontainer.CreationReferenceAttachmentType;
import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.larus.uaigc.createpage.component.helper.AlbumHelperKt;
import com.larus.uaigc.createpage.utils.CreationRemoteConversationHelper;
import com.larus.uaigc.helper.CreationResourceAccessPerfBridgeKt;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.uaigc.service.ICreationResourceAccessServiceKt;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
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
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Ô\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u0088\u00032\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0088\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\\\u001a\u00020/2\u0006\u0010J\u001a\u00020/2\b\u0010]\u001a\u0004\u0018\u00010/H\u0002J\u0012\u0010^\u001a\u00020E2\b\u0010_\u001a\u0004\u0018\u00010/H\u0016J\u0012\u0010`\u001a\u00020,2\b\u0010_\u001a\u0004\u0018\u00010/H\u0002J\t\u0010\u008a\u0001\u001a\u00020EH\u0016J\n\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0016J\u001e\u0010\u008d\u0001\u001a\u0017\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020/\u0012\u0005\u0012\u00030\u008e\u000102\u0018\u00010dH\u0016J\u0012\u0010\u008f\u0001\u001a\u00020E2\u0007\u0010\u0090\u0001\u001a\u00020,H\u0016J\u0014\u0010\u0091\u0001\u001a\u00020E2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010/H\u0016JA\u0010\u0093\u0001\u001a\u00020E2\u0006\u0010l\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020,2\u0007\u0010\u0095\u0001\u001a\u00020m2\u0007\u0010\u0096\u0001\u001a\u00020,2\u0007\u0010\u0097\u0001\u001a\u00020m2\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001H\u0016JA\u0010\u009a\u0001\u001a\u00020E2\u0006\u0010l\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020,2\u0007\u0010\u0095\u0001\u001a\u00020m2\u0007\u0010\u0096\u0001\u001a\u00020,2\u0007\u0010\u0097\u0001\u001a\u00020m2\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001H\u0002J\f\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001H\u0002J\t\u0010\u009d\u0001\u001a\u00020,H\u0002J\t\u0010\u009e\u0001\u001a\u00020EH\u0002J\t\u0010\u009f\u0001\u001a\u00020EH\u0002J%\u0010 \u0001\u001a\u00020E2\t\u0010¡\u0001\u001a\u0004\u0018\u00010/2\u0006\u0010p\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020,H\u0016J+\u0010¢\u0001\u001a\u00020E2\b\u0010x\u001a\u0004\u0018\u00010/2\u0007\u0010\u0094\u0001\u001a\u00020,2\r\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020E0wH\u0016J\u0011\u0010¤\u0001\u001a\u00020E2\u0006\u0010l\u001a\u00020mH\u0016J\u0012\u0010¥\u0001\u001a\u00020E2\u0007\u0010¦\u0001\u001a\u00020;H\u0016J\t\u0010§\u0001\u001a\u00020EH\u0016J\t\u0010¨\u0001\u001a\u00020mH\u0002J\"\u0010©\u0001\u001a\u0004\u0018\u00010{2\n\u0010ª\u0001\u001a\u0005\u0018\u00010\u0099\u00012\t\u0010«\u0001\u001a\u0004\u0018\u00010/H\u0002J\u000f\u0010¬\u0001\u001a\u00030\u00ad\u0001*\u00030®\u0001H\u0002J\u0011\u0010¯\u0001\u001a\u0005\u0018\u00010°\u0001*\u00030±\u0001H\u0002J\t\u0010²\u0001\u001a\u00020EH\u0002J\u0013\u0010³\u0001\u001a\u00020E2\b\u0010´\u0001\u001a\u00030µ\u0001H\u0002J\u0012\u0010¶\u0001\u001a\u00020E2\u0007\u0010·\u0001\u001a\u00020AH\u0002J\u0013\u0010¸\u0001\u001a\u00020A2\b\u0010´\u0001\u001a\u00030µ\u0001H\u0002J\u0019\u0010¹\u0001\u001a\u00020E2\u0007\u0010¦\u0001\u001a\u00020;H\u0096@¢\u0006\u0003\u0010º\u0001J\u0012\u0010»\u0001\u001a\u00020E2\u0007\u0010¦\u0001\u001a\u00020;H\u0002J\u0012\u0010¼\u0001\u001a\u00020E2\u0007\u0010¦\u0001\u001a\u00020;H\u0002J.\u0010½\u0001\u001a\u00020E2\u0007\u0010¦\u0001\u001a\u00020;2\b\u0010¾\u0001\u001a\u00030¿\u00012\t\b\u0002\u0010À\u0001\u001a\u00020,H\u0082@¢\u0006\u0003\u0010Á\u0001J\u001a\u0010Â\u0001\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010Ã\u0001\u001a\u00020/H\u0002J\u0019\u0010Ä\u0001\u001a\u00020E2\u0007\u0010¦\u0001\u001a\u00020;H\u0082@¢\u0006\u0003\u0010º\u0001J%\u0010Å\u0001\u001a\u00030Æ\u00012\u0006\u0010J\u001a\u00020/2\b\u0010Ç\u0001\u001a\u00030È\u00012\u0007\u0010¦\u0001\u001a\u00020;H\u0002J+\u0010É\u0001\u001a\u00020E2\b\u0010Ê\u0001\u001a\u00030Ë\u00012\u0007\u0010¦\u0001\u001a\u00020;2\u0006\u0010J\u001a\u00020/H\u0082@¢\u0006\u0003\u0010Ì\u0001J8\u0010Í\u0001\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010¦\u0001\u001a\u00020;2\u0007\u0010Î\u0001\u001a\u00020/2\u0013\u0010Ï\u0001\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/02H\u0002J*\u0010Ð\u0001\u001a\u0005\u0018\u00010Ñ\u00012\u0007\u0010¦\u0001\u001a\u00020;2\u0013\u0010Ï\u0001\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/02H\u0002J,\u0010Ò\u0001\u001a\u00020E2\u0007\u0010¦\u0001\u001a\u00020;2\b\u0010Ó\u0001\u001a\u00030Ô\u00012\u0007\u0010Î\u0001\u001a\u00020/H\u0082@¢\u0006\u0003\u0010Õ\u0001J%\u0010Ö\u0001\u001a\u00030×\u00012\u0006\u0010J\u001a\u00020/2\b\u0010Ç\u0001\u001a\u00030È\u00012\u0007\u0010¦\u0001\u001a\u00020;H\u0002J\u0012\u0010Ø\u0001\u001a\u0005\u0018\u00010Ù\u0001*\u0004\u0018\u00010/H\u0002J\u0010\u0010Ú\u0001\u001a\u00020,*\u0005\u0018\u00010Ù\u0001H\u0002J#\u0010Û\u0001\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010Ü\u0001\u001a\u00020>2\u0007\u0010Ý\u0001\u001a\u00020,H\u0016J(\u0010Þ\u0001\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010Ã\u0001\u001a\u00020/2\f\b\u0002\u0010ß\u0001\u001a\u0005\u0018\u00010à\u0001H\u0002J&\u0010á\u0001\u001a\u0005\u0018\u00010Ë\u00012\b\u0010â\u0001\u001a\u00030ã\u00012\u0007\u0010\u0092\u0001\u001a\u00020/H\u0082@¢\u0006\u0003\u0010ä\u0001J\u0015\u0010å\u0001\u001a\u0005\u0018\u00010æ\u00012\u0007\u0010Ã\u0001\u001a\u00020/H\u0002J\u0019\u0010ç\u0001\u001a\u00020E2\u0007\u0010·\u0001\u001a\u00020AH\u0082@¢\u0006\u0003\u0010è\u0001J\u001b\u0010é\u0001\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\b\u0010ê\u0001\u001a\u00030ë\u0001H\u0002J\u001a\u0010ì\u0001\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010í\u0001\u001a\u00020/H\u0002J\u0011\u0010î\u0001\u001a\u00020E2\u0006\u0010J\u001a\u00020/H\u0002J\u0011\u0010ï\u0001\u001a\u00020/2\u0006\u0010J\u001a\u00020/H\u0002J\u0011\u0010ð\u0001\u001a\u00020,2\u0006\u0010J\u001a\u00020/H\u0002J\u0012\u0010ñ\u0001\u001a\u00020,2\u0007\u0010ò\u0001\u001a\u00020/H\u0002J(\u0010ó\u0001\u001a\u00020E2\u0007\u0010ô\u0001\u001a\u00020,2\t\u0010õ\u0001\u001a\u0004\u0018\u00010/2\t\b\u0002\u0010ö\u0001\u001a\u00020/H\u0002J\f\u0010÷\u0001\u001a\u0005\u0018\u00010ø\u0001H\u0002J\u000b\u0010ù\u0001\u001a\u0004\u0018\u00010/H\u0002J\t\u0010ú\u0001\u001a\u00020,H\u0002J-\u0010û\u0001\u001a\u00020E2\u0007\u0010ü\u0001\u001a\u00020/2\b\u0010ê\u0001\u001a\u00030ý\u00012\u0007\u0010Ã\u0001\u001a\u00020/2\u0006\u0010J\u001a\u00020/H\u0002J\u0014\u0010þ\u0001\u001a\u0005\u0018\u00010ÿ\u00012\u0006\u0010J\u001a\u00020/H\u0002J6\u0010\u0080\u0002\u001a\u00020E2\u0007\u0010ü\u0001\u001a\u00020/2\b\u0010ê\u0001\u001a\u00030ý\u00012\u0007\u0010Ã\u0001\u001a\u00020/2\u0006\u0010J\u001a\u00020/2\u0007\u0010\u0081\u0002\u001a\u00020/H\u0002J\u000b\u0010\u0082\u0002\u001a\u0004\u0018\u00010/H\u0016J\t\u0010\u0083\u0002\u001a\u00020/H\u0002J\t\u0010\u0084\u0002\u001a\u00020/H\u0002JR\u0010\u0085\u0002\u001a\u00030×\u00012\u0007\u0010ü\u0001\u001a\u00020/2\u0007\u0010\u0081\u0002\u001a\u00020/2\u0007\u0010\u0086\u0002\u001a\u00020/2\u0007\u0010Ã\u0001\u001a\u00020/2\n\u0010ß\u0001\u001a\u0005\u0018\u00010à\u00012\u0016\u0010\u0087\u0002\u001a\u0011\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020m\u0018\u00010\u0088\u0002H\u0002J@\u0010\u0089\u0002\u001a\u00030\u008a\u00022\u0007\u0010ü\u0001\u001a\u00020/2\u0007\u0010Ã\u0001\u001a\u00020/2\n\u0010ß\u0001\u001a\u0005\u0018\u00010à\u00012\u0016\u0010\u0087\u0002\u001a\u0011\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020m\u0018\u00010\u0088\u0002H\u0002J!\u0010\u008b\u0002\u001a\u0011\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020m\u0018\u00010\u0088\u00022\u0007\u0010Ã\u0001\u001a\u00020/H\u0002J\u0011\u0010\u008c\u0002\u001a\u00030\u008d\u0002H\u0082@¢\u0006\u0003\u0010\u008e\u0002J\t\u0010\u008f\u0002\u001a\u00020/H\u0002J\t\u0010\u0090\u0002\u001a\u00020/H\u0002J\u001c\u0010\u0091\u0002\u001a\u00030\u0092\u00022\u0007\u0010\u0081\u0002\u001a\u00020/2\u0007\u0010\u0086\u0002\u001a\u00020/H\u0002J\u0011\u0010\u0093\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/H\u0002J\u001b\u0010\u0094\u0002\u001a\u00020E2\b\u0010Ó\u0001\u001a\u00030Ô\u00012\u0006\u0010J\u001a\u00020/H\u0002J¶\u0001\u0010\u0095\u0002\u001a\u00020E2\u0007\u0010Ã\u0001\u001a\u00020/2\u0006\u0010J\u001a\u00020/2\u0007\u0010ü\u0001\u001a\u00020/2\u0007\u0010\u0081\u0002\u001a\u00020/2\f\b\u0002\u0010ß\u0001\u001a\u0005\u0018\u00010à\u00012\u0018\b\u0002\u0010\u0087\u0002\u001a\u0011\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020m\u0018\u00010\u0088\u00022\t\b\u0002\u0010\u0096\u0002\u001a\u00020/2\f\b\u0002\u0010\u0097\u0002\u001a\u0005\u0018\u00010Ë\u00012\u0014\u0010\u0098\u0002\u001a\u000f\u0012\u0005\u0012\u00030Ô\u0001\u0012\u0004\u0012\u00020E0@2\u0014\u0010\u0099\u0002\u001a\u000f\u0012\u0005\u0012\u00030ý\u0001\u0012\u0004\u0012\u00020E0@2\u0014\u0010\u009a\u0002\u001a\u000f\u0012\u0005\u0012\u00030ë\u0001\u0012\u0004\u0012\u00020E0@H\u0082@¢\u0006\u0003\u0010\u009b\u0002JP\u0010\u009c\u0002\u001a\u00030Ë\u00012\u0007\u0010Ã\u0001\u001a\u00020/2\u0007\u0010ü\u0001\u001a\u00020/2\u0007\u0010\u0081\u0002\u001a\u00020/2\n\u0010ß\u0001\u001a\u0005\u0018\u00010à\u00012\u0016\u0010\u0087\u0002\u001a\u0011\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020m\u0018\u00010\u0088\u0002H\u0082@¢\u0006\u0003\u0010\u009d\u0002J\u001f\u0010\u009e\u0002\u001a\u00030\u009f\u00022\u0007\u0010Ã\u0001\u001a\u00020/2\n\u0010ß\u0001\u001a\u0005\u0018\u00010à\u0001H\u0002J\u001a\u0010 \u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010Î\u0001\u001a\u00020/H\u0002Jm\u0010¡\u0002\u001a\u00020E2\b\u0010Ê\u0001\u001a\u00030Ë\u00012\u0006\u0010J\u001a\u00020/2\u0007\u0010\u0096\u0002\u001a\u00020/2\u0014\u0010\u0098\u0002\u001a\u000f\u0012\u0005\u0012\u00030Ô\u0001\u0012\u0004\u0012\u00020E0@2\u0014\u0010\u0099\u0002\u001a\u000f\u0012\u0005\u0012\u00030ý\u0001\u0012\u0004\u0012\u00020E0@2\u0014\u0010\u009a\u0002\u001a\u000f\u0012\u0005\u0012\u00030ë\u0001\u0012\u0004\u0012\u00020E0@H\u0082@¢\u0006\u0003\u0010¢\u0002J\u0013\u0010£\u0002\u001a\u00020A2\b\u0010¤\u0002\u001a\u00030µ\u0001H\u0002J\u0013\u0010¥\u0002\u001a\u00020E2\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0002J\u001b\u0010¦\u0002\u001a\u00030¿\u00012\b\u0010Ç\u0001\u001a\u00030È\u0001H\u0082@¢\u0006\u0003\u0010§\u0002J\t\u0010¨\u0002\u001a\u00020EH\u0016J\t\u0010©\u0002\u001a\u00020EH\u0016J\t\u0010ª\u0002\u001a\u00020EH\u0016J\t\u0010«\u0002\u001a\u00020EH\u0016J\u001c\u0010¬\u0002\u001a\u00020E2\u0007\u0010\u00ad\u0002\u001a\u00020m2\b\u0010®\u0002\u001a\u00030¯\u0002H\u0002J\u001a\u0010°\u0002\u001a\t\u0012\u0004\u0012\u00020;0±\u00022\b\u0010®\u0002\u001a\u00030¯\u0002H\u0002J%\u0010²\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010Ã\u0001\u001a\u00020/2\t\u0010³\u0002\u001a\u0004\u0018\u00010/H\u0016J\u001a\u0010´\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010Ã\u0001\u001a\u00020/H\u0016J\u0011\u0010µ\u0002\u001a\u00020,2\u0006\u0010J\u001a\u00020/H\u0002J\u0011\u0010¶\u0002\u001a\u00020,2\u0006\u0010J\u001a\u00020/H\u0002J\u0012\u0010®\u0002\u001a\u00030¯\u00022\u0006\u0010J\u001a\u00020/H\u0002J\u001a\u0010·\u0002\u001a\u00030¸\u00022\u000e\u0010¹\u0002\u001a\t\u0012\u0004\u0012\u00020;0±\u0002H\u0016J#\u0010º\u0002\u001a\u00020E2\u000f\u0010»\u0002\u001a\n\u0012\u0005\u0012\u00030\u008a\u00020¼\u00022\u0007\u0010½\u0002\u001a\u00020;H\u0002J\u0012\u0010¾\u0002\u001a\u00020E2\u0007\u0010¿\u0002\u001a\u00020/H\u0002J\u000f\u0010À\u0002\u001a\u00030Á\u0002*\u00030\u0099\u0001H\u0002J\u001a\u0010Â\u0002\u001a\u00030\u0099\u00012\u000e\u0010¹\u0002\u001a\t\u0012\u0004\u0012\u00020;0±\u0002H\u0016J\u000e\u0010Ã\u0002\u001a\u00030Ä\u0002*\u00020;H\u0002J\u000e\u0010Å\u0002\u001a\u00030Æ\u0002*\u00020;H\u0002J\u000f\u0010Ç\u0002\u001a\u00030È\u0002*\u00030É\u0002H\u0002J\u000f\u0010Ç\u0002\u001a\u00030È\u0002*\u00030Ê\u0002H\u0002J\u001a\u0010Ë\u0002\u001a\u00030¸\u00022\u000e\u0010¹\u0002\u001a\t\u0012\u0004\u0012\u00020;0±\u0002H\u0002J\u000e\u0010Ì\u0002\u001a\u00020,*\u00030¯\u0002H\u0002J-\u0010Í\u0002\u001a\u00020E2\u000f\u0010»\u0002\u001a\n\u0012\u0005\u0012\u00030\u008a\u00020¼\u00022\b\u0010Î\u0002\u001a\u00030É\u00022\u0007\u0010½\u0002\u001a\u00020;H\u0002J-\u0010Ï\u0002\u001a\u00020E2\u000f\u0010»\u0002\u001a\n\u0012\u0005\u0012\u00030\u008a\u00020¼\u00022\b\u0010Î\u0002\u001a\u00030É\u00022\u0007\u0010½\u0002\u001a\u00020;H\u0002J\u001b\u0010Ð\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000201020dH\u0016J\u0013\u0010Ñ\u0002\u001a\u0004\u0018\u0001012\u0006\u0010J\u001a\u00020/H\u0016J\u0012\u0010Ò\u0002\u001a\u00020E2\u0007\u0010Ó\u0002\u001a\u00020bH\u0016J\t\u0010Ô\u0002\u001a\u00020,H\u0002Jf\u0010Õ\u0002\u001a\u0005\u0018\u00010Ö\u00022\u0006\u0010J\u001a\u00020/2\u0007\u0010×\u0002\u001a\u00020/2\t\u0010Ç\u0001\u001a\u0004\u0018\u00010/2\u0007\u0010\u0092\u0001\u001a\u00020/2\u0007\u0010Ø\u0002\u001a\u00020/2\u0007\u0010Ù\u0002\u001a\u00020/2\n\b\u0002\u0010Ú\u0002\u001a\u00030Û\u00022\n\b\u0002\u0010Ü\u0002\u001a\u00030Û\u00022\t\b\u0002\u0010Ý\u0002\u001a\u00020,H\u0002JR\u0010Þ\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010×\u0002\u001a\u00020/2\u0007\u0010\u0092\u0001\u001a\u00020/2\u0007\u0010Ø\u0002\u001a\u00020/2\u0007\u0010Ù\u0002\u001a\u00020/2\u0007\u0010Ý\u0001\u001a\u00020,2\u0007\u0010ß\u0002\u001a\u00020,2\t\u0010Ç\u0001\u001a\u0004\u0018\u00010/H\u0016JR\u0010à\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010×\u0002\u001a\u00020/2\u0007\u0010\u0092\u0001\u001a\u00020/2\u0007\u0010Ø\u0002\u001a\u00020/2\u0007\u0010Ù\u0002\u001a\u00020/2\u0007\u0010Ý\u0001\u001a\u00020,2\u0007\u0010ß\u0002\u001a\u00020,2\t\u0010Ç\u0001\u001a\u0004\u0018\u00010/H\u0002J\u001e\u0010á\u0002\u001a\u00030â\u00022\u0007\u0010×\u0002\u001a\u00020/2\t\u0010Ç\u0001\u001a\u0004\u0018\u00010/H\u0002J\u001c\u0010ã\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\t\u0010Î\u0001\u001a\u0004\u0018\u00010/H\u0002J2\u0010ä\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\n\u0010å\u0002\u001a\u0005\u0018\u00010â\u00022\u0013\u0010Ï\u0001\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/02H\u0002Ja\u0010æ\u0002\u001a\u00020E2\b\u0010Ê\u0001\u001a\u00030Ë\u00012\u0006\u0010J\u001a\u00020/2\u0007\u0010×\u0002\u001a\u00020/2\u0007\u0010\u0092\u0001\u001a\u00020/2\u0007\u0010Ø\u0002\u001a\u00020/2\u0007\u0010Ù\u0002\u001a\u00020/2\u0007\u0010\u0081\u0002\u001a\u00020/2\u0007\u0010Ý\u0001\u001a\u00020,2\u0007\u0010ß\u0002\u001a\u00020,H\u0082@¢\u0006\u0003\u0010ç\u0002J\u000e\u0010è\u0002\u001a\u00020,*\u00030é\u0002H\u0002JZ\u0010ê\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010×\u0002\u001a\u00020/2\u0007\u0010\u0092\u0001\u001a\u00020/2\u0007\u0010Ø\u0002\u001a\u00020/2\u0007\u0010Ù\u0002\u001a\u00020/2\u0007\u0010\u0081\u0002\u001a\u00020/2\u0007\u0010Ý\u0001\u001a\u00020,2\u0007\u0010ß\u0002\u001a\u00020,2\b\u0010ë\u0002\u001a\u00030ì\u0002H\u0002J5\u0010í\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010ò\u0001\u001a\u00020/2\u0007\u0010î\u0002\u001a\u00020/2\u0007\u0010Ý\u0001\u001a\u00020,2\u0007\u0010ß\u0002\u001a\u00020,H\u0002J\t\u0010ï\u0002\u001a\u00020,H\u0016J\t\u0010ð\u0002\u001a\u00020,H\u0016J\u0010\u0010ñ\u0002\u001a\t\u0012\u0004\u0012\u00020>0±\u0002H\u0016J\t\u0010ò\u0002\u001a\u00020,H\u0016J\\\u0010ó\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010×\u0002\u001a\u00020/2\b\u0010ô\u0002\u001a\u00030õ\u00022\u0007\u0010\u0092\u0001\u001a\u00020/2\u0007\u0010Ø\u0002\u001a\u00020/2\u0007\u0010Ù\u0002\u001a\u00020/2\t\b\u0002\u0010Ý\u0001\u001a\u00020,2\t\b\u0002\u0010ß\u0002\u001a\u00020,H\u0082@¢\u0006\u0003\u0010ö\u0002J8\u0010÷\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\b\u0010ô\u0002\u001a\u00030õ\u00022\t\b\u0002\u0010Ý\u0001\u001a\u00020,2\t\b\u0002\u0010ß\u0002\u001a\u00020,H\u0082@¢\u0006\u0003\u0010ø\u0002J.\u0010ù\u0002\u001a\u00020E2#\u0010ú\u0002\u001a\u001e\u0012\u0014\u0012\u00120A¢\u0006\r\bB\u0012\t\bC\u0012\u0005\b\b(¤\u0002\u0012\u0004\u0012\u00020E0@H\u0016J-\u0010û\u0002\u001a\u00020E2\"\u0010£\u0001\u001a\u001d\u0012\u0013\u0012\u00110;¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020E0@H\u0016J-\u0010ü\u0002\u001a\u00020E2\"\u0010£\u0001\u001a\u001d\u0012\u0013\u0012\u00110/¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020E0@H\u0016J\u001d\u0010ý\u0002\u001a\u00020E2\t\u0010×\u0002\u001a\u0004\u0018\u00010/2\u0007\u0010ß\u0002\u001a\u00020,H\u0016J\u000b\u0010þ\u0002\u001a\u0004\u0018\u00010/H\u0016J\u0011\u0010ÿ\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/H\u0016J&\u0010\u0080\u0003\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010Ã\u0001\u001a\u00020/2\n\u0010ß\u0001\u001a\u0005\u0018\u00010à\u0001H\u0016J\u0019\u0010\u0081\u0003\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001002\u0006\u0010J\u001a\u00020/H\u0002J\u0017\u0010\u0082\u0003\u001a\b\u0012\u0004\u0012\u000201002\u0006\u0010J\u001a\u00020/H\u0002J\u0011\u0010\u0083\u0003\u001a\u00020E2\u0006\u0010J\u001a\u00020/H\u0002J!\u0010\u0084\u0003\u001a\u00020E2\u0007\u0010\u0085\u0003\u001a\u00020/2\r\u0010\u0086\u0003\u001a\b\u0012\u0004\u0012\u00020100H\u0002J\u0011\u0010\u0087\u0003\u001a\u00020E2\u0006\u0010J\u001a\u00020/H\u0002R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b#\u0010$R\u001d\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\f\u001a\u0004\b(\u0010)R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000Rf\u0010-\u001aZ\u0012\f\u0012\n \b*\u0004\u0018\u00010/0/\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000201 \b*\n\u0012\u0004\u0012\u000201\u0018\u00010000 \b*,\u0012\f\u0012\n \b*\u0004\u0018\u00010/0/\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000201 \b*\n\u0012\u0004\u0012\u000201\u0018\u00010000\u0018\u0001020.X\u0082\u0004¢\u0006\u0002\n\u0000R \u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002010204X\u0082\u0004¢\u0006\u0002\n\u0000Rf\u00105\u001aZ\u0012\f\u0012\n \b*\u0004\u0018\u00010/0/\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000201 \b*\n\u0012\u0004\u0012\u000201\u0018\u00010000 \b*,\u0012\f\u0012\n \b*\u0004\u0018\u00010/0/\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000201 \b*\n\u0012\u0004\u0012\u000201\u0018\u00010000\u0018\u0001020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/07X\u0082\u0004¢\u0006\u0002\n\u0000RN\u00108\u001aB\u0012\f\u0012\n \b*\u0004\u0018\u00010/0/\u0012\f\u0012\n \b*\u0004\u0018\u00010,0, \b* \u0012\f\u0012\n \b*\u0004\u0018\u00010/0/\u0012\f\u0012\n \b*\u0004\u0018\u00010,0,\u0018\u00010909X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020;07X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/07X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010=\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020>07X\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010?\u001a%\u0012\u0013\u0012\u00110A¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020E\u0018\u00010@j\u0004\u0018\u0001`FX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010G\u001a\u001f\u0012\u0013\u0012\u00110;¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020E\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010I\u001a\u001f\u0012\u0013\u0012\u00110/¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020E\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010K\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020L07X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010M\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020,07X\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010N\u001aB\u0012\f\u0012\n \b*\u0004\u0018\u00010/0/\u0012\f\u0012\n \b*\u0004\u0018\u00010,0, \b* \u0012\f\u0012\n \b*\u0004\u0018\u00010/0/\u0012\f\u0012\n \b*\u0004\u0018\u00010,0,\u0018\u00010909X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0RX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010T\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\bW\u0010X*\u0004\bU\u0010VR\u0010\u0010Y\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010a\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010b0b00X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010c\u001a\b\u0012\u0004\u0012\u00020b0d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\be\u0010fR\u001c\u0010g\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010h0h00X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010i\u001a\b\u0012\u0004\u0012\u00020h0d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bj\u0010fR\u000e\u0010k\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010o\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010q\u001a\u00020r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bu\u0010\f\u001a\u0004\bs\u0010tR\u0016\u0010v\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010x\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010y\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010z\u001a\u0004\u0018\u00010{X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010|\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010}\u001a\u0004\u0018\u00010~8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0081\u0001\u001a\u00030\u0082\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R&\u0010\u0085\u0001\u001a\t\u0012\u0004\u0012\u0002010\u0086\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0089\u0001\u0010\f\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001¨\u0006\u0089\u0003"}, d2 = {"Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/MultiAttachmentSelectorComponent;", "Lcom/larus/ui/arch/component/external/api/Component;", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMultiAttachmentSelectorAbility;", "Lcom/larus/bmhome/instruction/kmp/IInstructionAttachmentHostAbility;", "<init>", "()V", "videoReferenceNoticeKeva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getVideoReferenceNoticeKeva", "()Lcom/bytedance/keva/Keva;", "videoReferenceNoticeKeva$delegate", "Lkotlin/Lazy;", "hitPointData", "Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "getHitPointData", "()Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "hitPointData$delegate", "argumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "argumentData$delegate", "instructionEditAbility", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "getInstructionEditAbility", "()Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "instructionEditAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "creationInputAbility", "Lcom/larus/uaigc/bean/createpage/component/input/CreationIInputAbility;", "getCreationInputAbility", "()Lcom/larus/uaigc/bean/createpage/component/input/CreationIInputAbility;", "creationInputAbility$delegate", "templateFeedAbility", "Lcom/larus/uaigc/bean/createpage/component/templatefeed/ITemplateFeedAbility;", "getTemplateFeedAbility", "()Lcom/larus/uaigc/bean/createpage/component/templatefeed/ITemplateFeedAbility;", "templateFeedAbility$delegate", "disableReUpload", "", "attachmentLiveDataCacheMap", "", "", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/MultiMediaSelectorStatus;", "", "allAttachmentLiveDataStatus", "Landroidx/lifecycle/MediatorLiveData;", "attachmentLiveDataRegisterMap", "attachmentIdentityRegisterMap", "Ljava/util/concurrent/ConcurrentHashMap;", "handoffUploadIdentifierSet", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "attachmentResourceItemBeanMap", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "instantUploadInfoJsonMap", "pipelineOriginalAttachmentMap", "Lcom/larus/bmhome/actionbar/model/MediaAttachment;", "onAlbumResultListener", "Lkotlin/Function1;", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/AlbumResourceConfig;", "Lkotlin/ParameterName;", "name", "config", "", "Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/OnAlbumResultListener;", "onUploadAvatarImageCallback", "resourceItemBean", "onDeleteAvatarImageCallback", "resourceKey", "imageUploadJobRegistry", "Lkotlinx/coroutines/Job;", "uploadPerfStartedResourceKeyMap", "videoPreprocessFailedResourceKeys", "takePictureHelper", "Lcom/larus/bmhome/chat/picture/LocalTakePictureImpl;", "albumPipelinePrewarmerDelegate", "Lkotlin/Lazy;", "Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/CreationAlbumPipelinePrewarmer;", "albumPipelinePrewarmer", "getAlbumPipelinePrewarmer$delegate", "(Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/MultiAttachmentSelectorComponent;)Ljava/lang/Object;", "getAlbumPipelinePrewarmer", "()Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/CreationAlbumPipelinePrewarmer;", "curLocalMessageId", "albumPrewarmSessionStarted", "albumPrewarmGeneratedLocalMessageId", "resolveAttachmentIdentifier", "fallbackIdentifier", "markUploadHandoffToSend", "fileIdentifier", "shouldKeepUploadForSend", "_passedImageUrlListLiveData", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/PassedImageUrlListData;", "passedImageUrlListLiveData", "Landroidx/lifecycle/LiveData;", "getPassedImageUrlListLiveData", "()Landroidx/lifecycle/LiveData;", "_updateUIStatus", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationUpdateUIStatus;", "updateUIStatus", "getUpdateUIStatus", "enableAlbumMultiSelect", "maxSelectCount", "", "currentReplaceIndex", "albumPrompt", "configInstructionType", "frescoCloseableHolder", "Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/FrescoCloseableHolder;", "getFrescoCloseableHolder", "()Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/FrescoCloseableHolder;", "frescoCloseableHolder$delegate", "openAlbumCallback", "Lkotlin/Function0;", "clickFrom", "currentUploadedAvatarResourceKey", "activeCreationReferenceAlbumConfig", "Lcom/larus/platform/model/album/CreationReferenceAlbumConfig;", "activeCreationReferenceReplaceKey", "currentSelectedVideoModelExtInfo", "Lcom/larus/bmhome/actionbar/model/VideoModelExtInfo;", "getCurrentSelectedVideoModelExtInfo", "()Lcom/larus/bmhome/actionbar/model/VideoModelExtInfo;", "currentCreationReferenceCapabilityState", "Lcom/larus/bmhome/actionbar/model/CreationReferenceCapabilityState;", "getCurrentCreationReferenceCapabilityState", "()Lcom/larus/bmhome/actionbar/model/CreationReferenceCapabilityState;", "creationUploadAndCheckObserver", "Landroidx/lifecycle/Observer;", "getCreationUploadAndCheckObserver", "()Landroidx/lifecycle/Observer;", "creationUploadAndCheckObserver$delegate", "onAttach", "getInstructionAttachmentProvider", "Lcom/larus/bmhome/instruction/core/platform/IInstructionAttachmentProvider;", "getInstructionAttachmentStatusLiveData", "", "openInstructionAlbum", "isReplace", "removeInstructionAttachment", "identifier", "openAlbum", "forceSingleSelect", "replaceIndex", "enableSeparateMediaSelection", "maxSelectVideoCount", "creationReferenceAttachmentSnapshot", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachmentSnapshot;", "openAlbumInternal", "buildAlbumPrewarmLaunchExtras", "Landroid/os/Bundle;", "isAlbumSelectionPrewarmEnabled", "cancelAlbumSelectionPrewarm", "finishAlbumSelectionPrewarm", "openAlbumWithPrompt", "prompt", "handleAlbumOpenFromActionMenu", "callback", "setMaxAlbumSelectCount", "addResourceItemBean", "bean", "onCreate", "getRemainSelectCount", "buildCreationReferenceAlbumConfig", "snapshot", "replaceResourceKey", "toAlbumMediaType", "Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;", "Lcom/larus/bmhome/actionbar/model/CreationReferenceMediaType;", "toAlbumAttachment", "Lcom/larus/platform/model/album/CreationReferenceAlbumAttachment;", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachment;", "initTakePictureHelper", "handleAlbumMultiSelectionForVideoUpload", "multiSelectItem", "Lcom/larus/platform/AlbumMultiSelectItem;", "showVideoReferenceQuotaNoticeIfNeeded", "resourceConfig", "buildResourceConfigForVideoUpload", "uploadResourceItemBean", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compressAndUploadImage", "preCheckAndUploadVideo", "toastVideoCheckFailed", "processResult", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "retainForRetry", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;Lcom/larus/bmhome/chat/bean/ProcessFileResult;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadVideo", "localResPath", "startVideoResourceAccess", "buildVideoResourceAccessRequest", "Lcom/larus/uaigc/service/ResourceAccessSubmitRequest;", "uri", "Landroid/net/Uri;", "observeVideoResourceAccessTask", "task", "Lcom/larus/bmhome/resource/access/ResourceAccessTask;", "(Lcom/larus/bmhome/resource/access/ResourceAccessTask;Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleVideoPreprocessReady", "localPath", "attributes", "buildPreprocessedVideoCover", "Lcom/larus/im/bean/message/Image;", "handleVideoResourceAccessFail", "error", "Lcom/larus/platform/model/upload/ResourceUploadError;", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;Lcom/larus/platform/model/upload/ResourceUploadError;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildVideoResourceCenterUploadParam", "Lcom/larus/platform/model/upload/ResourceCenterUploadParam;", "toProcessFileResultCode", "Lcom/larus/bmhome/chat/bean/ProcessFileResultCode;", "isVideoPreprocessError", "triggerVideoDownloadAndExplain", SlashMentionConfig.MENTION_CONTENT_ATTACHMENT, "isPrivate", "parseUriAndStartUpload", "fileInfo", "Lcom/larus/bmhome/chat/bean/ProcessFileInfo;", "submitAlbumSelectionPrewarm", "item", "Lcom/larus/platform/model/album/AlbumSelectionEventItem;", "(Lcom/larus/platform/model/album/AlbumSelectionEventItem;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveReadableLocalFile", "Ljava/io/File;", "onCompressUploadAndCheck", "(Lcom/larus/uaigc/bean/createpage/component/mediacontainer/AlbumResourceConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleUploadProcess", "result", "Lcom/larus/platform/model/upload/ResourceUploadProgressResult;", "startUploadPerfIfNeeded", "parentScene", "clearUploadPerfStarted", "resolveUploadPerfParentScene", "shouldReportUploadPerfManually", "isPreprocessErrorCode", "errorCode", "mobUploadAttachmentStatus", "success", "errorMsg", "messageType", "getSlidesMobConfig", "Lcom/larus/platform/model/slides/SlidesMobConfig;", "getCurrentPageName", "isHalfInstructionFragment", "handleUploadVideoSuccess", "uploaderIdentifier", "Lcom/larus/platform/model/upload/ResourceUploadResult;", "getVideoUploadCoverInfoByResourceKey", "Lcom/larus/bmhome/actionbar/model/VideoUploadCoverInfo;", "handleUploadSuccess", "localMessageId", "getCurrentNestedFileLocalMessageId", "getOrCreateLocalMessageId", "getOrCreateAlbumPrewarmLocalMessageId", "buildResourceCenterUploadParam", "conversationId", "imageSize", "Lkotlin/Pair;", "buildImageUploadEntity", "Lcom/larus/im/bean/message/UplinkFileEntity;", "resolveImageSize", "resolveConversationBeforeUpload", "Lcom/larus/uaigc/createpage/utils/CreationRemoteConversationHelper$ResolveResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveResourceConversationId", "resolveResourceBotId", "buildResourceAttachmentExtra", "Lcom/larus/platform/model/upload/ResourceAttachmentExtra;", "requireSelectedImageUrlInBackground", "handleUploadFail", "submitImageResourceAccess", "perfParentScene", "reusableTask", "onFailed", "onSuccess", "processCallback", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/bean/ProcessFileInfo;Lkotlin/Pair;Ljava/lang/String;Lcom/larus/bmhome/resource/access/ResourceAccessTask;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitImageResourceAccessTask", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/bean/ProcessFileInfo;Lkotlin/Pair;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildLocalImageResourceInput", "Lcom/larus/bmhome/resource/access/ResourceInput$LocalPath;", "updateImagePreprocessedLocalPath", "observeImageResourceAccessTask", "(Lcom/larus/bmhome/resource/access/ResourceAccessTask;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildResourceConfig", "multiConfig", "handleFailToast", "compressAlbumImg", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDestroy", "cancelResourceAccessForPageLeave", "updateResourceBarUI", "deleteAttachmentsIfNeeds", "deleteExceedMediaAttachments", "count", "resourceType", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceType;", "getCurrentMediaAttachmentList", "", "handleAttachmentRemove", "fromScene", "handleAttachmentRetry", "retryRemoteImage", "isResourceTypeVideo", "getCurrentNestedFileContent", "Lcom/larus/im/bean/message/NestedFileContent;", "resourceItemOrder", "addRemoteAudioEntityToList", "entities", "", "resourceItem", "logAttachmentChanged", "source", "toCreationMultiReferenceLogSummary", "Lcom/larus/platform/creation/CreationMultiReferenceLogSummary;", "getCreationReferenceAttachmentSnapshot", "toCreationReferenceAttachmentType", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachmentType;", "toCreationReferenceAttachmentSource", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachmentSource;", "toCreationReferenceAttachmentState", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachmentState;", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/MediaSelectorStatus;", "Lcom/larus/bmhome/view/resourcebar/bean/ItemStatus;", "getPipelineNestedFileContent", "isSnapshotMedia", "addVideoEntityToList", "status", "addImageEntityToList", "getAllAttachmentLiveDataStatus", "getMultiMediaSelectorStatus", "clearAndSetPassedImageUrlList", "passedImageUrlListData", "isPrefilledImage", "createPrefilledImageFilledStatus", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/MediaSelectorStatus$Filled;", "url", "resourceId", "localFilePath", "bitmapWidth", "", "bitmapHeight", "allowRemoteUrlOnly", "triggerDownloadUrlAndExplain", "isAvatar", "submitRemoteImageResourceAccess", "buildRemoteResourceInput", "Lcom/larus/bmhome/resource/access/ResourceInput;", "rememberImageLocalPathForRetry", "rememberResourceInputLocalPathForRetry", "resourceInput", "observeRemoteResourceAccessTask", "(Lcom/larus/bmhome/resource/access/ResourceAccessTask;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldShowRemoteUploading", "Lcom/larus/bmhome/resource/access/ResourceAccessState$Running;", "handleRemoteResourceAccessSuccess", "state", "Lcom/larus/bmhome/resource/access/ResourceAccessState$Ready;", "handleRemoteResourceAccessFail", "errorMessage", "isParsingAttachment", "hasVideoAttachment", "getCurrentAttachments", "isParsingVideoAttachment", "explainResourceUrl", "bitmap", "Landroid/graphics/Bitmap;", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reUploadImageOfPassedUrl", "(Ljava/lang/String;Landroid/graphics/Bitmap;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerOnAlbumResultListener", "onResult", "registerOnUploadAvatarImage", "registerOnDeleteAvatarImage", "triggerUploadAvatarImage", "getCurrentUploadedAvatarResourceKey", "triggerDeleteAvatarImage", "triggerUploadAndCheck", "getAttachmentLiveData", "getOrCreateAttachmentLiveData", "removeCreateAttachmentLiveData", "registerAttachmentLiveData", "key", "liveData", "unRegisterAttachmentLiveData", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MultiAttachmentSelectorComponent extends Component implements ry9.h, com.larus.bmhome.instruction.kmp.a {
    public static final /* synthetic */ int Z = 0;
    public final ConcurrentHashMap<String, MediaAttachment> A;
    public Function1<? super ry9.a, Unit> B;
    public Function1<? super ResourceItemBean, Unit> C;
    public Function1<? super String, Unit> D;
    public final ConcurrentHashMap<String, Job> E;
    public final ConcurrentHashMap<String, Boolean> F;
    public final ConcurrentHashMap.KeySetView<String, Boolean> G;
    public final LocalTakePictureImpl H;
    public final Lazy<CreationAlbumPipelinePrewarmer> I;
    public String J;
    public boolean K;
    public String L;
    public final MutableLiveData<ry9.l> M;
    public final MutableLiveData<ry9.f> N;
    public final boolean O;
    public int P;
    public int Q;
    public String R;
    public int S;
    public final Lazy T;
    public Function0<Unit> U;
    public String V;
    public String W;
    public CreationReferenceAlbumConfig X;
    public final Lazy Y;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final boolean s;
    public final Map<String, MutableLiveData<ry9.k>> t;
    public final MediatorLiveData<Map<String, ry9.k>> u;
    public final Map<String, MutableLiveData<ry9.k>> v;
    public final ConcurrentHashMap<String, String> w;
    public final ConcurrentHashMap.KeySetView<String, Boolean> x;
    public final ConcurrentHashMap<String, ResourceItemBean> y;
    public final ConcurrentHashMap<String, String> z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;
        public static final /* synthetic */ int[] d = null;
        public static final /* synthetic */ int[] e = null;
        public static final /* synthetic */ int[] f = null;

        static {
            int[] r0 = new int[CreationReferenceMediaType.values().length];
            r0[CreationReferenceMediaType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L81:
            r0[CreationReferenceMediaType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L91:
            r0[CreationReferenceMediaType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L36
        L8:
            a = r0;
            int[] r1 = new int[CreationReferenceAttachmentType.values().length];
            r1[CreationReferenceAttachmentType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L37
        L85:
            r1[CreationReferenceAttachmentType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L38
        L95:
            r1[CreationReferenceAttachmentType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L39
        L55:
            r1[CreationReferenceAttachmentType.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L40
        L14:
            b = r1;
            int[] r2 = new int[ResourcePhase.values().length];
            r2[ResourcePhase.PREPROCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L41
        L87:
            r2[ResourcePhase.UPLOAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L42
        L17:
            c = r2;
            int[] r3 = new int[ProcessFileResultCode.values().length];
            r3[ProcessFileResultCode.PREPARE_OVER_SIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L43
        L75:
            r3[ProcessFileResultCode.PREPARE_TYPE_NO_MATCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L44
        L20:
            d = r3;
            int[] r4 = new int[ResourceType.values().length];
            r4[ResourceType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L45
        L63:
            r4[ResourceType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L46
        L77:
            r4[ResourceType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L47
        L24:
            e = r4;
            int[] r5 = new int[ItemStatus.values().length];
            r5[ItemStatus.UPLINKING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L48
        L79:
            r5[ItemStatus.UPLINK_SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L49
        L89:
            r5[ItemStatus.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L50
        L59:
            r5[ItemStatus.UPLINK_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L51
        L69:
            r5[ItemStatus.PARSE_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L52
        L83:
            r5[ItemStatus.INSPECT_FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L53
        L93:
            r5[ItemStatus.EXPIRED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L54
        L32:
            f = r5;
        }
    }

    static {
    }

    public static boolean G4() {
        if (com.larus.platform.service.k2.a.x() == false) goto L9;
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L9;
        if (Intrinsics.areEqual(com.larus.uaigc.helper.f.c().a(), Boolean.TRUE) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // ry9.h
    public final List<MediaAttachment> DX() {
        ArrayList r0 = new ArrayList();
        Iterator r1 = MapsKt.toList(this.v).iterator();
    L4:
        if (r1.hasNext() == false) goto L34;
        String r2 = (String) ((Pair) r1.next()).component1();
        if (Intrinsics.areEqual(r2, this.W) == true) goto L4;
        Intrinsics.checkNotNull(r2);
        ry9.k r3 = Q00(r2);
        if (r3 == null) goto L4;
        ry9.j r4 = r3.b;
        ry9.i r5 = r4.a();
        if ((r4 instanceof ry9.j.c) == false) goto L4;
        if (r5 == null) goto L4;
        boolean r6 = r5 instanceof ry9.i.a;
        if (r6 == true) goto L17;
        if ((r5 instanceof ry9.i.b) == false) goto L4;
    L17:
        MediaAttachment r7 = null;
        if (r6 == false) goto L20;
        ry9.i.a r8 = (ry9.i.a) r5;
    L21:
        if (r8 == null) goto L27;
        MediaAttachment r9 = r8.a;
        if (r9 == null) goto L27;
        r7 = r9;
    L32:
        if (r7 == null) goto L4;
        r0.add(r7);
    L27:
        if ((r5 instanceof ry9.i.b) == false) goto L29;
        ry9.i.b r10 = (ry9.i.b) r5;
    L30:
        if (r10 == null) goto L32;
        r7 = r10.a;
        goto L32
    L29:
        r10 = null;
        goto L30
    L20:
        r8 = null;
        goto L21
    L34:
        return r0;
    }

    @Override // ry9.h
    public final void N6() {
        if (this.I.isInitialized() == false) goto L25;
        CreationAlbumPipelinePrewarmer r0 = V3();
        Object r4 = r0.c;
        monitor-enter(r4);
        String r5 = r0.d;     // Catch: Throwable -> L22
        r0.d = null;     // Catch: Throwable -> L22
        List r6 = CollectionsKt.distinct(CollectionsKt.plus(((LinkedHashMap) r0.e).values(), ((LinkedHashMap) r0.f).values()));     // Catch: Throwable -> L22
        ((LinkedHashMap) r0.e).clear();     // Catch: Throwable -> L22
        ((LinkedHashMap) r0.f).clear();     // Catch: Throwable -> L22
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r4);
        if (r5 == null) goto L12;
        ConcurrentHashMap<String, Function2<kq9.d, Boolean, Unit>> r8 = kq9.c.a;
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        if ((!StringsKt.isBlank(r5)) == false) goto L12;
        kq9.c.a.remove(r5);
    L12:
        ArrayList r9 = new ArrayList();
        Iterator r10 = r6.iterator();
    L14:
        if (r10.hasNext() == false) goto L21;
        Object r11 = r10.next();
        if (((CreationAlbumPipelinePrewarmer.b) r11).e != CreationAlbumPipelinePrewarmer.TaskOwner.SEND) goto L18;
        boolean r12 = true;
    L19:
        if (r12 == true) goto L14;
        r9.add(r11);
        goto L14
    L18:
        r12 = false;
        goto L19
    L21:
        r0.b(r9, ResourceCancelReason.PAGE_DESTROY);
    L22:
        th = move-exception;
        throw th;
    L25:
        this.K = false;
        this.L = null;
        List r1 = CollectionsKt.toList(this.E.keySet());
        Iterator<Map.Entry<String, Job>> r13 = this.E.entrySet().iterator();
    L27:
        if (r13.hasNext() == false) goto L44;
        Map.Entry<String, Job> r14 = r13.next();
        String r15 = r14.getKey();
        Job r16 = r14.getValue();
        String r17 = this.w.get(r15);
        if (r17 != null) goto L31;
    L40:
        boolean r18 = false;
    L41:
        if (r18 == false) goto L43;
        FLogger.a.i("MultiAttachmentSelector", "cancelResourceAccessForPageLeave keep resource access task for send, resourceKey=" + r15 + ", identifier=" + r17);
    L43:
        Job.DefaultImpls.cancel$default(r16, null, 1, null);
        goto L27
    L31:
        if (r17.length() <= 0) goto L33;
        boolean r19 = true;
    L34:
        if (r19 == false) goto L36;
        String r20 = r17;
    L37:
        if (r20 == null) goto L40;
        r18 = this.x.contains(r20);
        goto L41
    L36:
        r20 = null;
        goto L37
    L33:
        r19 = false;
        goto L34
    L44:
        this.E.clear();
        Iterator<Map.Entry<String, String>> r21 = this.w.entrySet().iterator();
    L46:
        if (r21.hasNext() == false) goto L73;
        Map.Entry<String, String> r22 = r21.next();
        String r23 = r22.getKey();
        String r24 = r22.getValue();
        if (r24 != null) goto L50;
    L59:
        boolean r25 = false;
    L60:
        if (r25 == true) goto L61;
        ICreationResourceAccessService.Companion r26 = ICreationResourceAccessService.a;
        com.larus.bmhome.resource.access.z r27 = ICreationResourceAccessService.a.c(r26, r24, null, null, 14);
        if (r27 == null) goto L69;
        com.larus.bmhome.resource.access.a0 r28 = r27.c;
        if (r28 == null) goto L69;
        if (com.larus.bmhome.resource.access.s.b(r28) != true) goto L69;
        boolean r29 = true;
    L70:
        if (r29 == true) goto L46;
        boolean r30 = r26.a(r24, ResourceCancelReason.PAGE_DESTROY);
        FLogger.a.i("MultiAttachmentSelector", "cancelResourceAccessForPageLeave cancel resource access task, resourceKey=" + r23 + ", identifier=" + r24 + ", cancelled=" + r30);
        nz9.b.f("-999", CollectionsKt.listOf(new String[]{"creation_page/album_upload", "creation_page/re_upload", "creation_page/album_upload/video"}), r23);
    L69:
        r29 = false;
        goto L70
    L61:
        FLogger.a.i("MultiAttachmentSelector", "cancelResourceAccessForPageLeave keep resource access task for send, resourceKey=" + r23 + ", identifier=" + r24);
        goto L46
    L50:
        if (r24.length() <= 0) goto L52;
        boolean r31 = true;
    L53:
        if (r31 == false) goto L55;
        String r32 = r24;
    L56:
        if (r32 == null) goto L59;
        r25 = this.x.contains(r32);
        goto L60
    L55:
        r32 = null;
        goto L56
    L52:
        r31 = false;
        goto L53
    L73:
        Set r33 = CollectionsKt.toSet(this.w.keySet());
        ArrayList r34 = new ArrayList();
        Iterator r2 = r1.iterator();
    L75:
        if (r2.hasNext() == false) goto L79;
        Object r35 = r2.next();
        if ((!r33.contains((String) r35)) == false) goto L75;
        r34.add(r35);
        goto L75
    L79:
        Iterator r3 = r34.iterator();
    L81:
        if (r3.hasNext() == false) goto L93;
        String r36 = (String) r3.next();
        ICreationResourceAccessService.Companion r37 = ICreationResourceAccessService.a;
        com.larus.bmhome.resource.access.z r38 = ICreationResourceAccessService.a.c(r37, r36, null, null, 14);
        if (r38 == null) goto L89;
        com.larus.bmhome.resource.access.a0 r39 = r38.c;
        if (r39 == null) goto L89;
        if (com.larus.bmhome.resource.access.s.b(r39) != true) goto L89;
        boolean r40 = true;
    L90:
        if (r40 == true) goto L81;
        boolean r41 = r37.a(r36, ResourceCancelReason.PAGE_DESTROY);
        FLogger.a.i("MultiAttachmentSelector", "cancelResourceAccessForPageLeave fallback cancel resource access task, resourceKey=" + r36 + ", cancelled=" + r41);
    L89:
        r40 = false;
        goto L90
    }

    @Override // ry9.h
    public final void Nn() {
        if ((Z3() instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L13;
        return;
    L13:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L7
        ResourceType r6 = ResourceType.VIDEO;     // Catch: Throwable -> L7
        List<ResourceItemBean> r7 = a4(r6);     // Catch: Throwable -> L7
        ResourceType r8 = ResourceType.IMAGE;     // Catch: Throwable -> L7
        List<ResourceItemBean> r9 = a4(r8);     // Catch: Throwable -> L7
        ResourceType r10 = ResourceType.AUDIO;     // Catch: Throwable -> L7
        List<ResourceItemBean> r11 = a4(r10);     // Catch: Throwable -> L7
        int r12 = ((ArrayList) r7).size();     // Catch: Throwable -> L7
        int r13 = ((ArrayList) r9).size();     // Catch: Throwable -> L7
        int r14 = ((ArrayList) r11).size();     // Catch: Throwable -> L7
        int r15 = r12 + r13;     // Catch: Throwable -> L7
        FLogger r16 = FLogger.a;     // Catch: Throwable -> L7
        r16.i("MultiAttachmentSelector", "[deleteAttachmentsIfNeeds] curSize: " + r15 + ", curVideoSize: " + r12 + ", curImageSize: " + r13 + ", curAudioSize: " + r14);     // Catch: Throwable -> L7
        StringBuilder r4 = new StringBuilder("[deleteAttachmentsIfNeeds] delete video count = ");     // Catch: Throwable -> L7
        r4.append(r12);     // Catch: Throwable -> L7
        r16.i("MultiAttachmentSelector", r4.toString());     // Catch: Throwable -> L7
        Q3(r12, r6);     // Catch: Throwable -> L7
        StringBuilder r3 = new StringBuilder("[deleteAttachmentsIfNeeds] delete audio count = ");     // Catch: Throwable -> L7
        r3.append(r14);     // Catch: Throwable -> L7
        r16.i("MultiAttachmentSelector", r3.toString());     // Catch: Throwable -> L7
        Q3(r14, r10);     // Catch: Throwable -> L7
        int r17 = (r15 - r12) - this.P;     // Catch: Throwable -> L7
        r16.i("MultiAttachmentSelector", "[deleteAttachmentsIfNeeds] delete image count = " + r17);     // Catch: Throwable -> L7
        Q3(r17, r8);     // Catch: Throwable -> L7
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r1 = Result.exceptionOrNull-impl(r0);
        if (r1 == null) goto L15;
        r1.printStackTrace();
        com.larus.platform.service.g.a.ensureNotReachHere(r1);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    @Override // ry9.h
    public final boolean SM() {
        return !a4(ResourceType.VIDEO).isEmpty();
    }

    public final CreationAlbumPipelinePrewarmer V3() {
        return (CreationAlbumPipelinePrewarmer) this.I.getValue();
    }

    public final ny9.s W3() {
        return (ny9.s) this.n.getValue();
    }

    @Override // ry9.h
    public final boolean Wb() {
        Map r0 = (Map) this.u.getValue();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isEmpty() == true) goto L29;
        Iterator r1 = r0.entrySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L30;
        Map.Entry r2 = (Map.Entry) r1.next();
        ResourceItemBean r3 = this.y.get(r2.getKey());
        if (r3 == null) goto L13;
        ResourceType r4 = r3.getResourceType();
    L15:
        if (r4 == ResourceType.VIDEO) goto L17;
    L19:
        boolean r5 = false;
    L20:
        if (r5 == false) goto L9;
        return true;
    L17:
        if ((((ry9.k) r2.getValue()).b instanceof ry9.j.a) == false) goto L19;
        r5 = true;
        goto L20
    L13:
        r4 = null;
        goto L15
    L30:
        return false;
    L29:
        return false;
    }

    public final ny9.u c4() {
        return (ny9.u) this.m.getValue();
    }

    public final ys8.a d4() {
        return (ys8.a) this.o.getValue();
    }

    public final String h4() {
        String r0 = this.J;
        if (r0 != null) goto L6;
        int r1 = wf9.b.a;
        String r2 = com.flow.kmp.common.util.i.a();
        this.J = r2;
        return r2;
    L6:
        return r0;
    }

    public final int j4() {
        Map<String, MutableLiveData<ry9.k>> r0 = this.v;
        int r2 = 1;
        if (r0.isEmpty() == false) goto L5;
        int r1 = 0;
    L11:
        com.larus.bmhome.actionbar.model.w0.a r3 = Z3();
        if ((r3 instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L14;
        com.larus.bmhome.actionbar.model.w0.a r4 = r3;
    L15:
        if (r4 == null) goto L21;
        wa8.d1 r5 = r4.a;
        if (r5 == null) goto L21;
        if (r5.a(CreationReferenceMediaType.VIDEO) != true) goto L21;
        boolean r6 = true;
    L22:
        if (r6 == true) goto L24;
    L26:
        r2 = 0;
    L27:
        int r7 = r1 + r2;
        com.larus.bmhome.actionbar.model.w0.a r8 = Z3();
        if ((r8 instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L34;
        Integer r9 = r8.a.c();
        if (r9 == null) goto L32;
        int r10 = r9.intValue();
    L37:
        return RangesKt.coerceAtLeast(r10 - r7, 0);
    L32:
        r10 = 0;
        goto L37
    L34:
        if (Intrinsics.areEqual(r8, com.larus.bmhome.actionbar.model.w0.b.a) == false) goto L39;
        r10 = this.P;
        goto L37
    L39:
        throw new NoWhenBranchMatchedException();
    L24:
        if (this.W == null) goto L26;
    L21:
        r6 = false;
        goto L22
    L14:
        r4 = null;
        goto L15
    L5:
        Iterator<Map.Entry<String, MutableLiveData<ry9.k>>> r11 = r0.entrySet().iterator();
        r1 = 0;
    L7:
        if (r11.hasNext() == false) goto L11;
        if ((!Intrinsics.areEqual(r11.next().getKey(), this.W)) == false) goto L7;
        r1 = r1 + 1;
        goto L7
    }

    @Override // ry9.h
    public final boolean jb() {
        Map r0 = (Map) this.u.getValue();
        if (r0 == null) goto L11;
        Iterator r1 = r0.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        if ((((ry9.k) ((Map.Entry) r1.next()).getValue()).b instanceof ry9.j.a) == false) goto L6;
        return true;
    L16:
        return false;
    L11:
        return false;
    }

    public final void onCreate() {
        if (this.O == false) goto L5;
        LocalTakePictureImpl r0 = this.H;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r6 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        MultiAttachmentSelectorComponent$initTakePictureHelper$1 r7 = new MultiAttachmentSelectorComponent$initTakePictureHelper$1(this);
        Function1<? super xp9.i, Unit> r8 = new d3(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "fragment");
        Intrinsics.checkNotNullParameter("instruction_multi_attachment_selector", "resultScene");
        Intrinsics.checkNotNullParameter(r7, "onCancel");
        Intrinsics.checkNotNullParameter(r8, "onSuccess");
        ((AlbumHelper) r0.f.getValue()).d(r6, "instruction_multi_attachment_selector", r7, r8);
    L5:
        LocalTakePictureImpl r1 = this.H;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r5 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        Function1<? super AlbumSelectItem, Unit> r9 = new e3(this);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter("instruction_multi_attachment_selector", "resultScene");
        Intrinsics.checkNotNullParameter(r9, "onSuccess");
        ((AlbumHelper) r1.f.getValue()).b(r5, "instruction_multi_attachment_selector", r9);
    }

    public final void onDestroy() {
        ((c) this.T.getValue()).b();
        N6();
    }

    public final KmpInstructionAttachmentProviderAdapter oy() {
        return new KmpInstructionAttachmentProviderAdapter(this);
    }

    public final MediatorLiveData p30() {
        MediatorLiveData<Map<String, ry9.k>> r0 = this.u;
        if ((r0 instanceof LiveData) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, ry9.h.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.bmhome.instruction.kmp.a.class);
    }

    public MultiAttachmentSelectorComponent() {
        this.l = LazyKt.lazy(new l1());
        this.m = LazyKt.lazy(new m1(this));
        this.n = LazyKt.lazy(new n1(this));
        this.o = LazyKt.lazy(new o1(this));
        this.p = LazyKt.lazy(new p1(this));
        this.q = LazyKt.lazy(new q1(this));
        this.r = LazyKt.lazy(new r1(this));
        com.larus.platform.service.z2 r0 = com.larus.platform.service.z2.a;
        this.s = r0.disableReUploadGeneratedImg();
        this.t = Collections.synchronizedMap(new HashMap());
        this.u = new MediatorLiveData(MapsKt.emptyMap());
        this.v = Collections.synchronizedMap(new LinkedHashMap());
        this.w = new ConcurrentHashMap();
        this.x = ConcurrentHashMap.newKeySet();
        this.y = new ConcurrentHashMap();
        this.z = new ConcurrentHashMap();
        this.A = new ConcurrentHashMap();
        this.E = new ConcurrentHashMap();
        this.F = new ConcurrentHashMap();
        this.G = ConcurrentHashMap.newKeySet();
        this.H = new LocalTakePictureImpl();
        this.I = LazyKt.lazy(new s1(this));
        this.M = new MutableLiveData(new ry9.l(true, 6));
        this.N = new MutableLiveData(new ry9.f(null, 0, null, null, 15));
        this.O = r0.enableCreationMixSkillAlbumMultiSelect();
        this.Q = -1;
        this.S = -1;
        this.T = LazyKt.lazy(new t1());
        this.Y = LazyKt.lazy(new u1(this));
    }

    public final void G3() {
        CreationAlbumPipelinePrewarmer r0 = V3();
        r0.getClass();
        r0.a(ResourceCancelReason.USER_CANCEL);
        if (this.K == true) goto L5;
    L9:
        this.K = false;
        this.L = null;
        return;
    L5:
        if (Intrinsics.areEqual(this.J, this.L) == false) goto L9;
        if (this.y.isEmpty() == false) goto L9;
        this.J = null;
        goto L9
    }

    public final com.larus.bmhome.actionbar.model.w0 Z3() {
        ys8.a r0 = d4();
        if (r0 == null) goto L7;
        com.larus.bmhome.actionbar.model.w0 r1 = r0.yn();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return com.larus.bmhome.actionbar.model.w0.b.a;
    }

    @Override // ry9.h
    public final void vB() {
        AlbumHelperKt.g(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), new MultiAttachmentSelectorComponent$updateResourceBarUI$1(this, null), 2);
    }

    public final String x5() {
        ny9.s r0 = W3();
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
        boolean r5 = true;
        if (r3.length() != 0) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == false) goto L37;
        ny9.u r7 = c4();
        if (r7 == null) goto L19;
        String r8 = r7.getBotId();
    L20:
        if (r8 != null) goto L23;
        r8 = "";
    L23:
        if (r8.length() == 0) goto L26;
        r5 = false;
    L26:
        if (r5 == false) goto L38;
        com.larus.bmhome.chat.api.e0 r9 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r9 == null) goto L32;
        LaunchInfo r10 = r9.a;
        if (r10 == null) goto L32;
        r1 = r10.W();
    L32:
        if (r1 == null) goto L36;
        r4 = r1;
    L36:
        return r4;
    L38:
        return r8;
    L19:
        r8 = null;
        goto L20
    L37:
        return r3;
    L14:
        r6 = false;
    L7:
        r3 = null;
        goto L8
    }

    @Override // ry9.h
    public final MutableLiveData BV() {
        return this.N;
    }

    @Override // ry9.h
    public final MutableLiveData Bw() {
        return this.M;
    }

    @Override // ry9.h
    public final String J6() {
        return this.J;
    }

    @Override // ry9.h
    public final LiveData<Map<String, ry9.k>> ja() {
        return this.u;
    }

    @Override // ry9.h
    public final String yC() {
        return this.W;
    }

    public static final void P2(MultiAttachmentSelectorComponent r2) {
        CreationAlbumPipelinePrewarmer r0 = r2.V3();
        r0.getClass();
        r0.a(ResourceCancelReason.USER_CANCEL);
        r2.K = false;
        r2.L = null;
    }

    public static CreationReferenceAlbumMediaType T5(CreationReferenceMediaType r1) {
        int r2 = b.a[r1.ordinal()];
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L15;
        if (r2 != 3) goto L10;
        return CreationReferenceAlbumMediaType.AUDIO;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return CreationReferenceAlbumMediaType.VIDEO;
    L13:
        return CreationReferenceAlbumMediaType.IMAGE;
    }

    public static final ICoreInputAbility U2(MultiAttachmentSelectorComponent r0) {
        return (ICoreInputAbility) r0.p.getValue();
    }

    public static PolarisFileWrapper w5(String r3) {
        if (StringsKt.isBlank(r3) == false) goto L5;
        return null;
    L5:
        PolarisFileWrapper r0 = new PolarisFileWrapper(r3);
        if (r0.exists() == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L37;
        return r0;
    L37:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        Object r4 = Result.constructor-impl(UriProtector.parse(r3));     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r4) == false) goto L18;
        r4 = null;
    L18:
        Uri r5 = (Uri) r4;
        if (r5 != null) goto L21;
    L26:
        String r6 = null;
    L27:
        if (r6 != null) goto L29;
        return null;
    L29:
        if ((!StringsKt.isBlank(r6)) == true) goto L32;
        r6 = null;
    L32:
        if (r6 == null) goto L40;
        PolarisFileWrapper r2 = new PolarisFileWrapper(r6);
        if (r2.exists() == true) goto L36;
        return null;
    L36:
        return r2;
    L40:
        return null;
    L21:
        if (Intrinsics.areEqual(r5.getScheme(), "file") == true) goto L24;
        r5 = null;
    L24:
        if (r5 == null) goto L26;
        r6 = r5.getPath();
    L13:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    @Override // ry9.h
    public final void C2(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r5 = null;
    L10:
        if (r5 != null) goto L13;
        return;
    L13:
        if (this.I.isInitialized() == false) goto L25;
        CreationAlbumPipelinePrewarmer r1 = V3();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "identifier");
        Object r2 = r1.c;
        monitor-enter(r2);
        CreationAlbumPipelinePrewarmer.b r3 = (CreationAlbumPipelinePrewarmer.b) ((LinkedHashMap) r1.f).get(r5);     // Catch: Throwable -> L22
        if (r3 == null) goto L19;
        CreationAlbumPipelinePrewarmer.TaskOwner r4 = CreationAlbumPipelinePrewarmer.TaskOwner.SEND;     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r4, "<set-?>");     // Catch: Throwable -> L22
        r3.e = r4;     // Catch: Throwable -> L22
    L19:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r2);
    L22:
        th = move-exception;
        throw th;
    L25:
        this.x.add(r5);
        FLogger.a.i("MultiAttachmentSelector", "mark upload handoff to send");
        return;
    L6:
        r0 = false;
        goto L7
    }

    @Override // ry9.h
    public final void IR(com.larus.uaigc.instruction.z r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.C = r2;
    }

    @Override // ry9.h
    public final void JZ(String r49) {
        DigitalAvatarInfoManager.a.getClass();
        if (DigitalAvatarInfoManager.i() == false) goto L6;
        String r0 = ContextCompat.getString(getContext(), 2131908806);
    L9:
        Intrinsics.checkNotNull(r0);
        String r2 = UUID.randomUUID().toString();
        HashMap r3 = new HashMap();
        r3.put("ext_show_re_select_layout", Boolean.FALSE);
        r3.put("ext_avatar_subscript_desc", r0);
        ItemStatus r18 = ItemStatus.UPLINKING;
        ResourceType r20 = ResourceType.AVATAR;
        ResourceItemBean r1 = new ResourceItemBean(r2, null, null, null, new Image(UUID.randomUUID().toString(), null, new ImageObj(r49, 0, 0, null, null, 30, null), null, null, null, null, null, null, null, null, null, null, null, 16378, null), null, 0, r18, false, r20, i5.w0(), 0, 0, 0, false, false, false, false, 0, r3, 522542, null);
        this.W = r2;
        this.y.put(r2, r1);
        Function1<? super ResourceItemBean, Unit> r4 = this.C;
        if (r4 == null) goto L12;
        r4.invoke(r1);
    L12:
        if (r49 != null) goto L14;
        String r5 = "";
    L15:
        q00(r2, r5, "", "", "", false, true, "");
        return;
    L14:
        r5 = r49;
        goto L15
    L6:
        if (DigitalAvatarInfoManager.h() == false) goto L8;
        r0 = ContextCompat.getString(getContext(), 2131908856);
        goto L9
    L8:
        r0 = "";
        goto L9
    }

    @Override // ry9.h
    public final void Lp(int r1) {
        this.P = r1;
    }

    @Override // ry9.h
    public final void OI(com.larus.uaigc.instruction.a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "onResult");
        this.B = r2;
    }

    @Override // ry9.h
    public final ry9.k Q00(String r2) {
        Intrinsics.checkNotNullParameter(r2, "resourceKey");
        Map r0 = (Map) this.u.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (ry9.k) r0.get(r2);
    }

    @Override // ry9.h
    public final void QA(ry9.l r8) {
        Intrinsics.checkNotNullParameter(r8, "passedImageUrlListData");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MultiAttachmentSelectorComponent$clearAndSetPassedImageUrlList$1(this, r8, null), 3, null);
    }

    public final void R4(String r21) {
        if ((Z3() instanceof com.larus.bmhome.actionbar.model.w0.a) == true) goto L5;
        return;
    L5:
        ry9.d r1 = yH(CollectionsKt.toList(this.y.values()));
        Set<String> r2 = cq9.b.a;
        CreationMultiReferenceLogEvent r3 = CreationMultiReferenceLogEvent.ATTACHMENT_CHANGED;
        Boolean r4 = Boolean.TRUE;
        com.larus.bmhome.actionbar.model.w0.a r5 = Z3();
        if ((r5 instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L8;
        com.larus.bmhome.actionbar.model.w0.a r6 = r5;
    L10:
        if (r6 == null) goto L16;
        wa8.d1 r7 = r6.a;
        if (r7 == null) goto L16;
        if (r7.a(CreationReferenceMediaType.VIDEO) != true) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == false) goto L19;
        int r9 = r1.b;
    L20:
        List<ry9.c> r10 = r1.a;
        if ((r10 instanceof Collection) == true) goto L23;
    L25:
        Iterator<T> r11 = r10.iterator();
        int r12 = 0;
    L27:
        if (r11.hasNext() == false) goto L36;
        if (((ry9.c) r11.next()).getType() != CreationReferenceAttachmentType.IMAGE) goto L31;
        boolean r13 = true;
    L32:
        if (r13 == false) goto L27;
        r12 = r12 + 1;
        if (r12 >= 0) goto L27;
        CollectionsKt.throwCountOverflow();
        goto L27
    L31:
        r13 = false;
        goto L32
    L36:
        int r14 = r12;
    L37:
        List<ry9.c> r15 = r1.a;
        if ((r15 instanceof Collection) == true) goto L40;
    L42:
        Iterator<T> r16 = r15.iterator();
        int r17 = 0;
    L44:
        if (r16.hasNext() == false) goto L53;
        if (((ry9.c) r16.next()).getType() != CreationReferenceAttachmentType.VIDEO) goto L48;
        boolean r18 = true;
    L49:
        if (r18 == false) goto L44;
        r17 = r17 + 1;
        if (r17 >= 0) goto L44;
        CollectionsKt.throwCountOverflow();
        goto L44
    L48:
        r18 = false;
    L53:
        int r19 = r17 + r9;
        List<ry9.c> r20 = r1.a;
        if ((r20 instanceof Collection) == true) goto L56;
    L58:
        Iterator<T> r22 = r20.iterator();
        int r23 = 0;
    L60:
        if (r22.hasNext() == false) goto L69;
        if (((ry9.c) r22.next()).getType() != CreationReferenceAttachmentType.AUDIO) goto L64;
        boolean r24 = true;
    L65:
        if (r24 == false) goto L60;
        r23 = r23 + 1;
        if (r23 >= 0) goto L60;
        CollectionsKt.throwCountOverflow();
        goto L60
    L64:
        r24 = false;
        goto L65
    L69:
        int r110 = r23;
    L70:
        List<ry9.c> r25 = r1.a;
        if ((r25 instanceof Collection) == true) goto L73;
    L75:
        Iterator<T> r26 = r25.iterator();
        int r27 = 0;
    L77:
        if (r26.hasNext() == false) goto L86;
        if (((ry9.c) r26.next()).getType() != CreationReferenceAttachmentType.UNKNOWN) goto L81;
        boolean r28 = true;
    L82:
        if (r28 == false) goto L77;
        r27 = r27 + 1;
        if (r27 >= 0) goto L77;
        CollectionsKt.throwCountOverflow();
        goto L77
    L81:
        r28 = false;
        goto L82
    L86:
        int r111 = r27;
    L87:
        List<ry9.c> r29 = r1.a;
        ArrayList r30 = new ArrayList();
        Iterator<T> r31 = r29.iterator();
    L89:
        if (r31.hasNext() == false) goto L96;
        Object r32 = r31.next();
        if (((ry9.c) r32).getType() != CreationReferenceAttachmentType.VIDEO) goto L93;
        boolean r112 = true;
    L94:
        if (r112 == false) goto L89;
        r30.add(r32);
        goto L89
    L93:
        r112 = false;
        goto L94
    L96:
        Iterator r33 = r30.iterator();
        double r113 = 0.0d;
    L98:
        if (r33.hasNext() == false) goto L104;
        Double r114 = ((ry9.c) r33.next()).j;
        if (r114 == null) goto L102;
        double r115 = r114.doubleValue();
    L103:
        r113 = r113 + r115;
        goto L98
    L102:
        r115 = 0.0d;
        goto L103
    L104:
        Double r34 = r1.c;
        if (r34 == null) goto L107;
        double r116 = r34.doubleValue();
    L108:
        double r117 = r113 + r116;
        List<ry9.c> r35 = r1.a;
        ArrayList r36 = new ArrayList();
        Iterator<T> r37 = r35.iterator();
    L110:
        if (r37.hasNext() == false) goto L118;
        Object r118 = r37.next();
        if (((ry9.c) r118).getType() != CreationReferenceAttachmentType.AUDIO) goto L114;
        boolean r38 = true;
    L115:
        if (r38 == false) goto L110;
        r36.add(r118);
        goto L110
    L114:
        r38 = false;
        goto L115
    L118:
        Iterator r39 = r36.iterator();
        double r119 = 0.0d;
    L120:
        if (r39.hasNext() == false) goto L126;
        Double r40 = ((ry9.c) r39.next()).j;
        if (r40 == null) goto L124;
        double r41 = r40.doubleValue();
    L125:
        r119 = r119 + r41;
        goto L120
    L124:
        r41 = 0.0d;
        goto L125
    L126:
        cq9.b.a(r3, r4, "video_creation", r21, new cq9.a(r14, r19, r110, r111, r117, r119, 64), null, null, null, 976);
        return;
    L107:
        r116 = 0.0d;
        goto L108
    L73:
        if (r25.isEmpty() == false) goto L75;
        r111 = 0;
        goto L87
    L56:
        if (r20.isEmpty() == false) goto L58;
        r110 = 0;
        goto L70
    L40:
        if (r15.isEmpty() == false) goto L42;
        r17 = 0;
        goto L53
    L23:
        if (r10.isEmpty() == false) goto L25;
        r14 = 0;
        goto L37
    L19:
        r9 = 0;
    L16:
        r8 = false;
        goto L17
    L8:
        r6 = null;
        goto L10
    }

    @Override // ry9.h
    public final NestedFileContent V20(List<ResourceItemBean> r47) {
        Intrinsics.checkNotNullParameter(r47, "resourceItemOrder");
        com.larus.uaigc.helper.f.a.getClass();
        boolean r8 = true;
        if (com.larus.uaigc.helper.f.a() == false) goto L235;
        ArrayList r10 = new ArrayList();
        if ((r47 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r2 = r47.iterator();
        int r9 = 0;
    L11:
        if (r2.hasNext() == false) goto L33;
        ResourceItemBean r11 = (ResourceItemBean) r2.next();
        ResourceType r12 = r11.getResourceType();
        if (r12 != ResourceType.IMAGE) goto L15;
    L20:
        boolean r13 = true;
    L21:
        if (r13 == false) goto L23;
    L28:
        boolean r14 = true;
    L29:
        if (r14 == false) goto L11;
        r9 = r9 + 1;
        if (r9 >= 0) goto L11;
        CollectionsKt.throwCountOverflow();
        goto L11
    L23:
        if (r11.getResourceType() == ResourceType.AUDIO) goto L25;
    L27:
        r14 = false;
        goto L29
    L25:
        if (i4(this, r11) == false) goto L27;
    L15:
        if (r12 == ResourceType.AVATAR) goto L20;
        if (r12 == ResourceType.VIDEO) goto L20;
        r13 = false;
    L33:
        Iterator<T> r1 = r47.iterator();
    L35:
        if (r1.hasNext() == false) goto L231;
        ResourceItemBean r3 = (ResourceItemBean) r1.next();
        if (r3.getResourceType() == ResourceType.AUDIO) goto L39;
        ResourceType r15 = r3.getResourceType();
        if (r15 != ResourceType.IMAGE) goto L44;
    L49:
        boolean r16 = true;
    L50:
        if (r16 == false) goto L35;
        ResourceItemBean r17 = this.y.get(r3.getKey());
        if (r17 != null) goto L55;
        ResourceItemBean r18 = r3;
    L56:
        MutableLiveData<ry9.k> r19 = this.t.get(r3.getKey());
        if (r19 == null) goto L61;
        ry9.k r110 = (ry9.k) r19.getValue();
        if (r110 == null) goto L61;
        ry9.j r111 = r110.b;
    L62:
        MediaAttachment r112 = this.A.get(r3.getKey());
        if (r111 == null) goto L65;
        ry9.i r113 = r111.a();
    L67:
        if ((r113 instanceof ry9.i.a) == false) goto L70;
        String r114 = ((ry9.i.a) r113).a.getIdentifier();
    L74:
        if (r114 != null) goto L76;
    L80:
        if (r112 == null) goto L86;
        r114 = r112.getIdentifier();
        if (r114 == null) goto L86;
        if ((!StringsKt.isBlank(r114)) == false) goto L86;
    L87:
        if (r114 != null) goto L114;
        Image r115 = r18.getImage();
        if (r115 == null) goto L95;
        r114 = r115.identifier;
        if (r114 == null) goto L95;
        if ((!StringsKt.isBlank(r114)) == false) goto L95;
    L96:
        if (r114 != null) goto L114;
        Image r116 = r18.getImage();
        if (r116 == null) goto L104;
        r114 = r116.md5;
        if (r114 == null) goto L104;
        if ((!StringsKt.isBlank(r114)) == false) goto L104;
    L105:
        if (r114 != null) goto L114;
        mt8.b r117 = r18.getVideo();
        if (r117 == null) goto L113;
        r114 = r117.f;
        if (r114 == null) goto L113;
        if ((!StringsKt.isBlank(r114)) == true) goto L114;
    L113:
        r114 = null;
    L104:
        r114 = null;
    L95:
        r114 = null;
    L114:
        String r118 = q5(r3.getKey(), r114);
        if (r18.getResourceType() != ResourceType.VIDEO) goto L117;
        boolean r5 = true;
    L118:
        ICreationResourceAccessService.Companion r119 = ICreationResourceAccessService.a;
        if (r5 == false) goto L121;
        com.larus.bmhome.resource.access.x r120 = com.larus.uaigc.service.f.c;
    L122:
        com.larus.bmhome.resource.access.x r6 = r120;
        if (r5 == false) goto L125;
        ResourceMediaType r121 = ResourceMediaType.VIDEO;
    L126:
        ResourceMediaType r4 = r121;
        if (r5 == false) goto L129;
        String r7 = "creation_video";
    L130:
        com.larus.bmhome.resource.access.z r20 = r119.d(r118, r6, r4, r7);
        if (r20 == null) goto L133;
        com.larus.bmhome.resource.access.a0 r21 = r20.c;
    L135:
        if ((r21 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L137;
        com.larus.bmhome.resource.access.a0.d r22 = (com.larus.bmhome.resource.access.a0.d) r21;
    L138:
        if (r22 == null) goto L141;
        com.larus.bmhome.resource.access.f0 r23 = r22.a;
        if (r23 == null) goto L141;
    L142:
        com.larus.bmhome.resource.access.f0 r122 = r23;
        if (r20 == null) goto L145;
        com.larus.bmhome.resource.access.a0 r24 = r20.c;
    L147:
        if ((r24 instanceof com.larus.bmhome.resource.access.a0.e) == false) goto L149;
        com.larus.bmhome.resource.access.a0.e r25 = (com.larus.bmhome.resource.access.a0.e) r24;
    L150:
        if (r25 == null) goto L153;
        com.larus.bmhome.resource.access.j0 r26 = r25.c;
        if (r26 == null) goto L153;
    L157:
        com.larus.bmhome.resource.access.j0 r123 = r26;
    L159:
        if (r20 == null) goto L165;
        Map r27 = r20.g;
        if (r27 == null) goto L165;
        com.larus.bmhome.resource.access.q0 r28 = (com.larus.bmhome.resource.access.q0) r27.get("preprocess");
        if (r28 == null) goto L165;
        Map r29 = r28.f;
    L166:
        if (r29 != null) goto L168;
        r29 = MapsKt.emptyMap();
    L168:
        Map r30 = MapsKt.toMutableMap(r29);
        if (r25 == null) goto L171;
        Map r31 = r25.d;
    L172:
        if (r31 != null) goto L174;
        r31 = MapsKt.emptyMap();
    L174:
        r30.putAll(r31);
        int r32 = com.larus.uaigc.createpage.component.mediaselector.imageselector.b.a;
        String r124 = this.z.get(r3.getKey());
        ny9.s r33 = W3();
        if (r33 != null) goto L177;
    L179:
        boolean r210 = false;
    L180:
        UplinkFileEntity r34 = com.larus.uaigc.createpage.component.mediaselector.imageselector.b.a(r18, r111, r112, r118, r122, r123, r30, r124, r210);
        if (r5 == false) goto L226;
        if (r34 == null) goto L189;
        Integer r35 = r34.getUpLinkStatus();
        int r36 = UpLinkState.PROCESSING.getValue();
        if (r35 == null) goto L189;
        if (r35.intValue() != r36) goto L189;
        boolean r37 = true;
    L190:
        if (r37 == false) goto L226;
        ConcurrentHashMap<String, com.larus.uaigc.createpage.component.sendmessage.r0.a> r38 = com.larus.uaigc.createpage.component.sendmessage.r0.a;
        ys8.a r39 = d4();
        if (r39 == null) goto L194;
        com.larus.bmhome.actionbar.model.e2 r40 = r39.tQ();
    L195:
        if (r40 == null) goto L199;
        Long r41 = r40.d;
        if (r41 == null) goto L199;
        long r42 = r41.longValue();
    L200:
        Intrinsics.checkNotNullParameter(r118, "identifier");
        com.larus.uaigc.createpage.component.sendmessage.r0.a();
        if (StringsKt.isBlank(r118) == true) goto L226;
        if (r42 <= 0) goto L226;
        ConcurrentHashMap<String, com.larus.uaigc.createpage.component.sendmessage.r0.a> r125 = com.larus.uaigc.createpage.component.sendmessage.r0.a;
        if (r125.size() < 64) goto L225;
        Iterator<T> r126 = r125.entrySet().iterator();
        if (r126.hasNext() == true) goto L210;
        Object r127 = null;
    L219:
        Map.Entry r128 = (Map.Entry) r127;
        if (r128 == null) goto L225;
        String r43 = (String) r128.getKey();
        if (r43 == null) goto L225;
        com.larus.uaigc.createpage.component.sendmessage.r0.a r44 = com.larus.uaigc.createpage.component.sendmessage.r0.a.remove(r43);
        goto L225
    L210:
        r127 = r126.next();
        if (r126.hasNext() == false) goto L219;
        long r129 = ((com.larus.uaigc.createpage.component.sendmessage.r0.a) ((Map.Entry) r127).getValue()).b;
    L214:
        Object r130 = r126.next();
        long r45 = ((com.larus.uaigc.createpage.component.sendmessage.r0.a) ((Map.Entry) r130).getValue()).b;
        if (r129 <= r45) goto L218;
        r129 = r45;
        r127 = r130;
    L218:
        if (r126.hasNext() == true) goto L214;
    L225:
        com.larus.uaigc.createpage.component.sendmessage.r0.a.put(r118, new com.larus.uaigc.createpage.component.sendmessage.r0.a(r42, System.currentTimeMillis()));
    L199:
        r42 = 0;
        goto L200
    L194:
        r40 = null;
    L189:
        r37 = false;
    L226:
        if (r34 == null) goto L35;
        r10.add(r34);
        goto L35
    L177:
        if (r33.x() != true) goto L179;
        r210 = true;
        goto L180
    L171:
        r31 = null;
    L165:
        r29 = null;
    L153:
        if (r20 == null) goto L158;
        com.larus.bmhome.resource.access.w r46 = r20.d;
        if (r46 == null) goto L158;
        r26 = r46.b;
    L158:
        r123 = null;
        goto L159
    L149:
        r25 = null;
        goto L150
    L145:
        r24 = null;
    L141:
        r23 = r119.c(r118);
        goto L142
    L137:
        r22 = null;
        goto L138
    L133:
        r21 = null;
        goto L135
    L129:
        r7 = null;
        goto L130
    L125:
        r121 = ResourceMediaType.IMAGE;
        goto L126
    L121:
        r120 = com.larus.uaigc.service.f.a;
        goto L122
    L117:
        r5 = false;
    L86:
        r114 = null;
        goto L87
    L76:
        if ((!StringsKt.isBlank(r114)) == true) goto L79;
        r114 = null;
    L79:
        if (r114 != null) goto L114;
    L70:
        if ((r113 instanceof ry9.i.b) == false) goto L72;
        r114 = ((ry9.i.b) r113).a.getIdentifier();
        goto L74
    L72:
        if (r113 != null) goto L229;
        r114 = null;
        goto L74
    L229:
        throw new NoWhenBranchMatchedException();
    L65:
        r113 = null;
    L61:
        r111 = null;
        goto L62
    L55:
        r18 = r17;
        goto L56
    L44:
        if (r15 == ResourceType.AVATAR) goto L49;
        if (r15 == ResourceType.VIDEO) goto L49;
        r16 = false;
        goto L50
    L39:
        if (i4(this, r3) == false) goto L35;
        B3(r10, r3);
        goto L35
    L231:
        if (r10.size() == r9) goto L233;
        FLogger.a.e("MultiAttachmentSelector", "[getPipelineNestedFileContent] snapshot count mismatch, expected=" + r9 + ", actual=" + r10.size());
    L233:
        FLogger.a.i("MultiAttachmentSelector", "[getPipelineNestedFileContent] finished, selected=" + r9 + ", entities=" + r10.size());
        return new NestedFileContent(r10, null, false, null, 14, null);
    L7:
        if (r47.isEmpty() == false) goto L9;
        r9 = 0;
        goto L33
    L235:
        ArrayList r48 = new ArrayList();
        FLogger r49 = FLogger.a;
        StringBuilder r50 = new StringBuilder("[getCurrentNestedFileContent] start, resourceItemOrder size: ");
        ArrayList r51 = (ArrayList) r47;
        r50.append(r51.size());
        r49.i("MultiAttachmentSelector", r50.toString());
        Iterator r52 = r51.iterator();
    L237:
        if (r52.hasNext() == false) goto L487;
        ResourceItemBean r53 = (ResourceItemBean) r52.next();
        String r54 = r53.getKey();
        ResourceType r55 = r53.getResourceType();
        if (r55 == ResourceType.AUDIO) goto L241;
        MutableLiveData<ry9.k> r56 = this.t.get(r54);
        if (r56 == null) goto L485;
        ry9.k r57 = (ry9.k) r56.getValue();
        if (r57 == null) goto L485;
        ry9.j r58 = r57.b;
        if ((r58 instanceof ry9.j.a) == false) goto L254;
        com.larus.uaigc.helper.f.a.getClass();
        if (Intrinsics.areEqual(com.larus.uaigc.helper.f.c().d(), Boolean.TRUE) == false) goto L254;
    L264:
        if (r55 != ResourceType.IMAGE) goto L266;
    L272:
        ry9.i r59 = r58.a();
        if ((r59 instanceof ry9.i.a) == false) goto L275;
        ry9.i.a r60 = (ry9.i.a) r59;
    L276:
        if (r60 != null) goto L291;
        Image r61 = r53.getImage();
        if (r61 != null) goto L280;
    L290:
        r60 = null;
        goto L291
    L280:
        if (r61.localResPath == null) goto L290;
        Image r131 = r53.getImage();
        if (r131 == null) goto L284;
        String r211 = r131.localResPath;
    L285:
        String r132 = r53.getKey();
        Image r133 = r53.getImage();
        if (r133 == null) goto L288;
        String r134 = r133.md5;
    L289:
        r60 = new ry9.i.a(new MediaAttachment(null, null, null, null, r211, q5(r132, r134), null, null, null, null, null, null, 4047, null), null);
        goto L291
    L288:
        r134 = null;
        goto L289
    L284:
        r211 = null;
    L291:
        if (r60 == null) goto L295;
        MediaAttachment r62 = r60.a;
        if (r62 == null) goto L295;
        String r135 = r62.getUri();
    L296:
        if (r60 == null) goto L300;
        MediaAttachment r63 = r60.a;
        if (r63 == null) goto L300;
        String r64 = r63.getLocalFilePath();
    L301:
        if (r60 == null) goto L305;
        MediaAttachment r136 = r60.a;
        if (r136 == null) goto L305;
        String r137 = r136.getIdentifier();
    L306:
        if (r60 == null) goto L310;
        MediaAttachment r138 = r60.a;
        if (r138 == null) goto L310;
        String r212 = r138.getResourceId();
    L311:
        String r310 = this.z.get(r53.getKey());
        FLogger r139 = FLogger.a;
        StringBuilder r140 = new StringBuilder("[addImageEntityToList] hasLocalFile=");
        if (r64 != null) goto L314;
    L317:
        boolean r141 = true;
    L318:
        r140.append(r141 ^ r8);
        r139.i("MultiAttachmentSelector", r140.toString());
        if (r64 != null) goto L321;
    L324:
        boolean r142 = true;
    L326:
        if (r142 == true) goto L390;
        if (new PolarisFileWrapper(r64).exists() == false) goto L390;
        ImFileUtil r143 = ImFileUtil.a;
        PolarisFileWrapper r144 = new PolarisFileWrapper(r64);
        r143.getClass();
        String r213 = ImFileUtil.g(r144);
        String r214 = r60.a.getUrl();
        ImageUploadInfo r145 = r60.a.getImageUploadInfo();
        if (r145 == null) goto L334;
        Long r146 = r145.getWidth();
        if (r146 == null) goto L334;
        long r147 = r146.longValue();
    L335:
        int r148 = (int) r147;
        ImageUploadInfo r65 = r60.a.getImageUploadInfo();
        if (r65 == null) goto L340;
        Long r66 = r65.getHeight();
        if (r66 == null) goto L340;
        long r67 = r66.longValue();
    L341:
        ImageObj r215 = new ImageObj(r214, r148, (int) r67, null, null, 24, null);
        ny9.s r68 = W3();
        if (r68 != null) goto L344;
    L346:
        boolean r69 = false;
    L348:
        if (Intrinsics.areEqual(r53.getExt().get("ext_creation_reference_do_same"), Boolean.TRUE) == true) goto L350;
        String r311 = "upload";
    L351:
        UplinkEntityContent r70 = new UplinkEntityContent(null, new Image(r135, r213, null, r215, r212, r64, r137, null, null, null, Boolean.valueOf(r69), null, null, r311, 7044, null), 1, null);
        Integer r216 = Integer.valueOf(UplinkEntityType.EntityTypeImage.getValue());
        if (r135 != null) goto L354;
    L357:
        boolean r71 = true;
    L358:
        if (r71 == false) goto L360;
    L363:
        FileReviewState r72 = FileReviewState.DEFAULT;
    L364:
        Integer r217 = Integer.valueOf(r72.getValue());
        if (Intrinsics.areEqual(r58, ry9.j.a.b) == false) goto L367;
        FileParseState r73 = FileParseState.PROCESSING;
    L368:
        Integer r218 = Integer.valueOf(r73.getValue());
        if (r135 != null) goto L371;
    L374:
        boolean r74 = true;
    L375:
        if (r74 == false) goto L377;
        int r75 = 0;
    L378:
        Integer r219 = Integer.valueOf(r75);
        if (r135 != null) goto L381;
    L384:
        boolean r76 = true;
    L385:
        if (r76 == false) goto L387;
        UpLinkState r77 = UpLinkState.PROCESSING;
    L388:
        r48.add(new UplinkFileEntity(r216, r70, r137, null, r217, r218, r219, Integer.valueOf(r77.getValue()), null, false, Uri.fromFile(new PolarisFileWrapper(r64)), r310, null, null, 13064, null));
    L486:
        r8 = true;
        goto L237
    L387:
        r77 = UpLinkState.SUCCESS;
        goto L388
    L381:
        if (r135.length() == 0) goto L384;
        r76 = false;
        goto L385
    L377:
        r75 = 100;
        goto L378
    L371:
        if (r135.length() == 0) goto L374;
        r74 = false;
        goto L375
    L367:
        r73 = FileParseState.SUCCESS;
        goto L368
    L360:
        if ((r58 instanceof ry9.j.g) == true) goto L363;
        r72 = FileReviewState.ACCESS;
        goto L364
    L354:
        if (r135.length() == 0) goto L357;
        r71 = false;
        goto L358
    L350:
        r311 = null;
        goto L351
    L344:
        if (r68.x() != true) goto L346;
        r69 = true;
    L340:
        r67 = 0;
    L334:
        r147 = 0;
    L390:
        if (r60 == null) goto L394;
        MediaAttachment r78 = r60.a;
        if (r78 == null) goto L394;
        String r149 = r78.getUri();
    L395:
        if (r60 == null) goto L399;
        MediaAttachment r79 = r60.a;
        if (r79 == null) goto L399;
        String r80 = r79.getUrl();
    L401:
        if (com.larus.utils.o0.d(r149) == true) goto L403;
    L404:
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == true) goto L407;
    L409:
        boolean r81 = false;
    L410:
        if (r81 == false) goto L486;
        if (r137 != null) goto L413;
    L419:
        String r82 = r53.getKey();
        Image r150 = r53.getImage();
        if (r150 == null) goto L422;
        String r151 = r150.md5;
    L423:
        String r83 = q5(r82, r151);
    L425:
        if (com.larus.utils.o0.d(r149) == false) goto L427;
    L430:
        boolean r152 = true;
    L431:
        if (r149 != null) goto L433;
        String r220 = "";
    L435:
        if (r60 == null) goto L443;
        MediaAttachment r153 = r60.a;
        if (r153 == null) goto L443;
        ImageUploadInfo r154 = r153.getImageUploadInfo();
        if (r154 == null) goto L443;
        Long r155 = r154.getWidth();
        if (r155 == null) goto L443;
        long r156 = r155.longValue();
    L444:
        int r157 = (int) r156;
        if (r60 == null) goto L453;
        MediaAttachment r84 = r60.a;
        if (r84 == null) goto L453;
        ImageUploadInfo r85 = r84.getImageUploadInfo();
        if (r85 == null) goto L453;
        Long r86 = r85.getHeight();
        if (r86 == null) goto L453;
        long r158 = r86.longValue();
    L454:
        ImageObj r221 = new ImageObj(r80, r157, (int) r158, null, null, 24, null);
        ny9.s r159 = W3();
        if (r159 != null) goto L457;
    L459:
        boolean r87 = false;
    L461:
        if (Intrinsics.areEqual(r53.getExt().get("ext_creation_reference_do_same"), Boolean.TRUE) == true) goto L463;
        String r312 = "upload";
    L464:
        UplinkEntityContent r88 = new UplinkEntityContent(null, new Image(r220, null, null, r221, r212, r64, r83, null, null, null, Boolean.valueOf(r87), null, null, r312, 7046, null), 1, null);
        Integer r222 = Integer.valueOf(UplinkEntityType.EntityTypeImage.getValue());
        if (r152 == false) goto L467;
        int r89 = FileReviewState.ACCESS.getValue();
    L468:
        Integer r313 = Integer.valueOf(r89);
        Integer r314 = Integer.valueOf(FileParseState.SUCCESS.getValue());
        if (r152 == false) goto L471;
        int r160 = 100;
    L472:
        Integer r315 = Integer.valueOf(r160);
        if (r152 == false) goto L475;
        int r90 = UpLinkState.SUCCESS.getValue();
    L476:
        Integer r316 = Integer.valueOf(r90);
        if (com.larus.utils.o0.d(r149) == true) goto L480;
        r149 = null;
    L480:
        if (r149 == null) goto L483;
        r80 = r149;
    L483:
        r48.add(new UplinkFileEntity(r222, r88, r83, null, r313, r314, r315, r316, null, false, UriProtector.parse(r80), r310, null, null, 13064, null));
        goto L486
    L475:
        r90 = UpLinkState.PROCESSING.getValue();
        goto L476
    L471:
        r160 = 0;
        goto L472
    L467:
        r89 = FileReviewState.DEFAULT.getValue();
        goto L468
    L463:
        r312 = null;
        goto L464
    L457:
        if (r159.x() != true) goto L459;
        r87 = true;
    L453:
        r158 = 0;
    L443:
        r156 = 0;
        goto L444
    L433:
        r220 = r149;
        goto L435
    L427:
        if (com.larus.utils.o0.d(r212) == true) goto L430;
        r152 = false;
        goto L431
    L422:
        r151 = null;
        goto L423
    L413:
        if ((!StringsKt.isBlank(r137)) == true) goto L416;
        r137 = null;
    L416:
        if (r137 == null) goto L419;
        r83 = r137;
        goto L425
    L407:
        if (com.larus.utils.o0.d(r80) == false) goto L409;
    L408:
        r81 = true;
        goto L410
    L403:
        if (com.larus.utils.o0.d(r80) == true) goto L408;
    L399:
        r80 = null;
    L394:
        r149 = null;
        goto L395
    L321:
        if (r64.length() == 0) goto L324;
        r142 = false;
        goto L326
    L314:
        if (StringsKt.isBlank(r64) == true) goto L317;
        r141 = false;
    L310:
        r212 = null;
    L305:
        r137 = null;
    L300:
        r64 = null;
    L295:
        r135 = null;
        goto L296
    L275:
        r60 = null;
        goto L276
    L266:
        if (r55 == ResourceType.AVATAR) goto L272;
        if (r55 != ResourceType.VIDEO) goto L271;
        C3(r48, r58, r53);
        goto L486
    L271:
        FLogger.a.e("MultiAttachmentSelector", "[getCurrentNestedFileContent] unsupported resource type");
    L254:
        if ((r58 instanceof ry9.j.h) == true) goto L264;
        if ((r58 instanceof ry9.j.g) == true) goto L264;
        if ((r58 instanceof ry9.j.c) == true) goto L260;
    L262:
        FLogger.a.e("MultiAttachmentSelector", "[getCurrentNestedFileContent] attachment is not ready");
        goto L486
    L260:
        if (((ry9.j.c) r58).b == null) goto L262;
    L485:
        FLogger.a.e("MultiAttachmentSelector", "[getCurrentNestedFileContent] no live attachment state");
        goto L486
    L241:
        if ((Z3() instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L243;
    L244:
        B3(r48, r53);
        goto L486
    L243:
        if (Intrinsics.areEqual(r53.getExt().get("ext_creation_reference_do_same"), Boolean.TRUE) == false) goto L486;
    L487:
        FLogger.a.i("MultiAttachmentSelector", "[getCurrentNestedFileContent] finished, entities size: " + r48.size());
        return new NestedFileContent(r48, null, false, null, 14, null);
    }

    public final void V5(String r4) {
        FLogger.a.i("MultiAttachmentSelector", "[unRegisterAttachmentLiveData] resourceKey = " + r4);
        MediatorLiveData<Map<String, ry9.k>> r0 = this.u;
        Map r1 = (Map) r0.getValue();
        if (r1 != null) goto L5;
        r1 = MapsKt.emptyMap();
    L5:
        Map r2 = MapsKt.toMutableMap(r1);
        r2.remove(r4);
        r0.setValue(r2);
        MutableLiveData<ry9.k> r3 = this.v.get(r4);
        if (r3 == null) goto L8;
        this.u.removeSource(r3);
    L8:
        this.v.remove(r4);
    }

    public final MutableLiveData<ry9.k> X3(String r2) {
        return this.t.get(r2);
    }

    public final List<ResourceItemBean> a4(ResourceType r6) {
        Map<String, MutableLiveData<ry9.k>> r0 = this.v;
        ArrayList r1 = new ArrayList();
        Iterator<Map.Entry<String, MutableLiveData<ry9.k>>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L14;
        ResourceItemBean r3 = this.y.get(r2.next().getKey());
        if (r3 == null) goto L8;
        ResourceType r4 = r3.getResourceType();
    L9:
        if (r4 == r6) goto L12;
        r3 = null;
    L12:
        if (r3 == null) goto L4;
        r1.add(r3);
        goto L4
    L8:
        r4 = null;
        goto L9
    L14:
        return r1;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.larus.uaigc.createpage.component.mediaselector.imageselector.h2] */
    public final MutableLiveData<ry9.k> e4(final String r14) {
        MutableLiveData<ry9.k> r0 = this.t.get(r14);
        if (r0 == null) goto L5;
        return r0;
    L5:
        FLogger r1 = FLogger.a;
        r1.i("MultiAttachmentSelector", "[getOrCreateAttachmentLiveData] create liveData, resourceKey = " + r14);
        MutableLiveData<ry9.k> r2 = new MutableLiveData();
        this.t.put(r14, r2);
        Intrinsics.checkNotNullParameter(this, "<this>");
        r2.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), (Observer) this.Y.getValue());
        r1.i("MultiAttachmentSelector", "[registerAttachmentLiveData] key = " + r14);
        if (this.v.containsKey(r14) == false) goto L8;
        r1.i("MultiAttachmentSelector", "[registerAttachmentLiveData] containsKey = " + r14);
        V5(r14);
    L8:
        MediatorLiveData<Map<String, ry9.k>> r3 = this.u;
        Map r4 = (Map) r3.getValue();
        if (r4 != null) goto L11;
        r4 = MapsKt.emptyMap();
    L11:
        Map r5 = MapsKt.toMutableMap(r4);
        ry9.k r6 = (ry9.k) r2.getValue();
        if (r6 != null) goto L14;
        r6 = new ry9.k(null, null, 0, false, false, false, 63);
    L14:
        r5.put(r14, r6);
        r3.setValue(r5);
        this.u.addSource(r2, new z3(new h2(this, r14)));
        this.v.put(r14, r2);
        return r2;
    }

    @Override // ry9.h
    public final void ew(ResourceItemBean r15) {
        Intrinsics.checkNotNullParameter(r15, "bean");
        this.y.put(r15.getKey(), r15);
        if (r15.getResourceType() != ResourceType.AUDIO) goto L26;
        Object r0 = r15.getExt().get("ext_audio_vid");
        Boolean r2 = null;
        if ((r0 instanceof String) == false) goto L7;
        String r1 = (String) r0;
    L9:
        if (r1 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        boolean r4 = !r3;
        MutableLiveData<ry9.k> r5 = e4(r15.getKey());
        String r6 = r15.getKey();
        if (r4 == false) goto L18;
        ry9.j r7 = new ry9.j.c(null);
    L19:
        ry9.j r8 = r7;
        Object r16 = r15.getExt().get("ext_audio_is_private");
        if ((r16 instanceof Boolean) == false) goto L22;
        r2 = (Boolean) r16;
    L22:
        if (r2 == null) goto L24;
        boolean r9 = r2.booleanValue();
    L25:
        r5.setValue(new ry9.k(r6, r8, 0, r9, false, false, 52));
        goto L26
    L24:
        r9 = false;
        goto L25
    L18:
        r7 = ry9.j.f.b;
        goto L19
    L11:
        if (StringsKt.isBlank(r1) == true) goto L14;
        r3 = false;
        goto L15
    L7:
        r1 = null;
    L26:
        R4("prefill");
    }

    public final void g80(boolean r4) {
        FLogger.a.i("MultiAttachmentSelector", "[openInstructionAlbum] isReplace=" + r4 + ", remain=" + j4());
        ry9.h.a.a(this, j4(), r4, 0, 60);
    }

    public final com.larus.bmhome.actionbar.model.f2 k4(String r6) {
        ResourceItemBean r7 = this.y.get(r6);
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[getVideoUploadCoverInfoByResourceKey] hasVideo=");
        String r2 = null;
        if (r7 == null) goto L5;
        mt8.b r3 = r7.getVideo();
    L6:
        int r4 = 0;
        if (r3 == null) goto L9;
        boolean r5 = true;
    L10:
        r1.append(r5);
        r0.i("MultiAttachmentSelector", r1.toString());
        if (r7 == null) goto L17;
        mt8.b r8 = r7.getVideo();
        if (r8 == null) goto L17;
        Image r9 = r8.a;
        if (r9 == null) goto L17;
        String r10 = r9.key;
    L18:
        if (r7 == null) goto L24;
        mt8.b r11 = r7.getVideo();
        if (r11 == null) goto L24;
        Image r12 = r11.a;
        if (r12 == null) goto L24;
        r2 = r12.localResPath;
    L24:
        if (r7 == null) goto L28;
        mt8.b r13 = r7.getVideo();
        if (r13 == null) goto L28;
        int r14 = r13.c;
    L29:
        if (r7 == null) goto L34;
        mt8.b r15 = r7.getVideo();
        if (r15 == null) goto L34;
        r4 = r15.d;
    L34:
        return new com.larus.bmhome.actionbar.model.f2(r10, r2, Integer.valueOf(r4), Integer.valueOf(r14));
    L28:
        r14 = 0;
    L17:
        r10 = null;
        goto L18
    L9:
        r5 = false;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    @Override // ry9.h
    public final void lu(String r2) {
        Intrinsics.checkNotNullParameter(r2, "resourceKey");
        if (r2.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        Function1<? super String, Unit> r1 = this.D;
        if (r1 == null) goto L10;
        r1.invoke(r2);
    L10:
        this.W = null;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void nf(String r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        Object r1 = null;
        if (r0 == true) goto L11;
        r6 = null;
    L11:
        if (r6 == null) goto L37;
        Iterator<T> r2 = this.w.entrySet().iterator();
    L15:
        if (r2.hasNext() == false) goto L19;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((Map.Entry) r3).getValue(), r6) == false) goto L15;
        r1 = r3;
    L19:
        Map.Entry r4 = (Map.Entry) r1;
        if (r4 == null) goto L23;
        String r5 = (String) r4.getKey();
        if (r5 == null) goto L23;
    L24:
        ResourceItemBean r7 = this.y.get(r5);
        if (r7 == null) goto L30;
        Image r8 = r7.getImage();
        if (r8 == null) goto L30;
        String r9 = r8.localResPath;
        if (r9 == null) goto L30;
    L31:
        FLogger.a.i("MultiAttachmentSelector", "[removeInstructionAttachment] identifier=" + r6 + ", resourceKey=" + r5);
        w60(r5, r9, "click_remove");
        return;
    L30:
        r9 = "";
    L23:
        r5 = r6;
        goto L24
    L37:
        return;
    L6:
        r0 = false;
        goto L7
    }

    public final void o5(String r7) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MultiAttachmentSelectorComponent$requireSelectedImageUrlInBackground$1(this, r7, null), 3, null);
    }

    public final Object s5(Continuation<? super CreationRemoteConversationHelper.a> r8) {
        if ((r8 instanceof MultiAttachmentSelectorComponent$resolveConversationBeforeUpload$1) == false) goto L7;
        MultiAttachmentSelectorComponent$resolveConversationBeforeUpload$1 r0 = (MultiAttachmentSelectorComponent$resolveConversationBeforeUpload$1) r8;
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
    L39:
        CreationRemoteConversationHelper.a r10 = (CreationRemoteConversationHelper.a) r9;
        if (r10.b == false) goto L46;
        ny9.s r4 = W3();
        if (r4 == null) goto L46;
        ChatParam r5 = r4.c();
        if (r5 == null) goto L46;
        r5.a = r10.a;
    L46:
        return r10;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        ny9.s r11 = W3();
        if (r11 == null) goto L19;
        ChatParam r12 = r11.c();
        if (r12 == null) goto L19;
        String r13 = r12.a;
    L20:
        String r6 = "";
        if (r13 != null) goto L24;
        r13 = "";
    L24:
        if (r13.length() != 0) goto L26;
        boolean r7 = true;
    L27:
        if (r7 == false) goto L36;
        ny9.u r14 = c4();
        if (r14 == null) goto L31;
        String r15 = r14.Y1();
    L32:
        if (r15 == null) goto L35;
        r6 = r15;
    L35:
        r13 = r6;
        goto L36
    L31:
        r15 = null;
    L36:
        String r16 = x5();
        CoroutineDispatcher r17 = Dispatchers.getIO();
        MultiAttachmentSelectorComponent$resolveConversationBeforeUpload$result$1 r18 = new MultiAttachmentSelectorComponent$resolveConversationBeforeUpload$result$1(r13, r16, null);
        r0.label = 1;
        r9 = BuildersKt.withContext(r17, r18, r0);
        if (r9 != r2) goto L39;
        return r2;
    L26:
        r7 = false;
    L19:
        r13 = null;
    L7:
        r0 = new MultiAttachmentSelectorComponent$resolveConversationBeforeUpload$1(this, r8);
        goto L8
    }

    @Override // ry9.h
    public final void tE(com.larus.uaigc.instruction.b0 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.D = r2;
    }

    public final String y5(String r2) {
        ResourceItemBean r3 = this.y.get(r2);
        if (r3 == null) goto L5;
        ResourceType r4 = r3.getResourceType();
    L7:
        if (r4 != ResourceType.VIDEO) goto L9;
        return "creation_page/album_upload/video";
    L9:
        return "creation_page/album_upload";
    L5:
        r4 = null;
        goto L7
    }

    @Override // ry9.h
    public final ry9.d yH(List<ResourceItemBean> r25) {
        Intrinsics.checkNotNullParameter(r25, "resourceItemOrder");
        List<ResourceItemBean> r0 = r25;
        int r3 = 1;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L16;
        if (((ResourceItemBean) r1.next()).getResourceType() != ResourceType.AVATAR) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L9;
        int r2 = 1;
    L17:
        if (r2 == 0) goto L21;
        DigitalAvatarInfoManager.a.getClass();
        ey9.a r5 = DigitalAvatarInfoManager.f();
        if (r5 == null) goto L21;
        Double r6 = Double.valueOf(r5.c());
    L22:
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r0.iterator();
        int r9 = 0;
    L24:
        if (r8.hasNext() == false) goto L255;
        Object r10 = r8.next();
        int r19 = r9 + 1;
        if (r9 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        ResourceItemBean r11 = (ResourceItemBean) r10;
        if (r11.getResourceType() != ResourceType.ADD) goto L31;
    L250:
        ry9.c r12 = null;
    L251:
        if (r12 == null) goto L253;
        r7.add(r12);
    L253:
        r9 = r19;
        r3 = 1;
        goto L24
    L31:
        if (r11.getResourceType() == ResourceType.CUSTOM) goto L250;
        if (r11.getResourceType() == ResourceType.AVATAR) goto L250;
        MutableLiveData<ry9.k> r13 = this.t.get(r11.getKey());
        if (r13 == null) goto L40;
        ry9.k r14 = (ry9.k) r13.getValue();
        if (r14 == null) goto L40;
        ry9.j r15 = r14.b;
    L42:
        if ((r15 instanceof ry9.j.c) == false) goto L44;
        ry9.j.c r16 = (ry9.j.c) r15;
    L45:
        if (r16 == null) goto L47;
        ry9.i r17 = r16.b;
    L49:
        if ((r17 instanceof ry9.i.a) == false) goto L51;
        ry9.i.a r18 = (ry9.i.a) r17;
    L52:
        if (r18 == null) goto L56;
        MediaAttachment r110 = r18.a;
        if (r110 == null) goto L56;
        ImageUploadInfo r111 = r110.getImageUploadInfo();
    L57:
        Image r112 = r11.getImage();
        if (r112 == null) goto L61;
        ImageObj r113 = r112.imageOri;
        if (r113 == null) goto L61;
    L70:
        String r114 = r11.getKey();
        int r115 = b.e[r11.getResourceType().ordinal()];
        if (r115 != r3) goto L73;
        CreationReferenceAttachmentType r116 = CreationReferenceAttachmentType.IMAGE;
    L81:
        if (Intrinsics.areEqual(r11.getExt().get("ext_creation_reference_do_same"), Boolean.TRUE) == false) goto L83;
        CreationReferenceAttachmentSource r20 = CreationReferenceAttachmentSource.DO_SAME;
    L111:
        if (r15 == null) goto L141;
        if (Intrinsics.areEqual(r15, ry9.j.b.b) == false) goto L116;
        CreationReferenceAttachmentState r21 = CreationReferenceAttachmentState.SELECTED;
    L136:
        if (r21 == null) goto L141;
    L150:
        CreationReferenceAttachmentState r117 = r21;
        String r22 = r11.getMimeType();
        if ((!StringsKt.isBlank(r22)) == false) goto L153;
        String r118 = r22;
    L154:
        String r23 = r11.getFileSuffixes();
        if ((!StringsKt.isBlank(r23)) == false) goto L157;
        String r119 = r23;
    L158:
        mt8.b r24 = r11.getVideo();
        if (r24 == null) goto L168;
        Integer r26 = Integer.valueOf(r24.c);
        if (r26.intValue() <= 0) goto L163;
        boolean r120 = true;
    L164:
        if (r120 == true) goto L167;
        r26 = null;
    L167:
        if (r26 == null) goto L168;
    L190:
        Integer r27 = r26;
    L191:
        mt8.b r28 = r11.getVideo();
        if (r28 == null) goto L201;
        Integer r29 = Integer.valueOf(r28.d);
        if (r29.intValue() <= 0) goto L196;
        boolean r30 = true;
    L197:
        if (r30 == true) goto L200;
        r29 = null;
    L200:
        if (r29 == null) goto L201;
    L223:
        mt8.b r31 = r11.getVideo();
        if (r31 == null) goto L234;
        Float r32 = Float.valueOf(r31.b);
        if (r32.floatValue() <= 0.0f) goto L228;
        boolean r121 = true;
    L229:
        if (r121 == true) goto L232;
        r32 = null;
    L232:
        if (r32 == null) goto L234;
        Double r33 = Double.valueOf(r32.floatValue());
    L240:
        Double r122 = r33;
    L242:
        Object r34 = r11.getExt().get("ext_creation_reference_file_size");
        if ((r34 instanceof Number) == false) goto L245;
        Number r35 = (Number) r34;
    L246:
        if (r35 == null) goto L248;
        Long r210 = Long.valueOf(r35.longValue());
    L249:
        r12 = new ry9.c(r114, r9, r116, r20, r117, r118, r119, r27, r29, r122, r210);
        goto L251
    L248:
        r210 = null;
        goto L249
    L245:
        r35 = null;
        goto L246
    L228:
        r121 = false;
    L234:
        Object r36 = r11.getExt().get("ext_audio_duration_seconds");
        if ((r36 instanceof Number) == false) goto L237;
        Number r37 = (Number) r36;
    L238:
        if (r37 == null) goto L241;
        r33 = Double.valueOf(r37.doubleValue());
        goto L240
    L241:
        r122 = null;
        goto L242
    L237:
        r37 = null;
        goto L238
    L196:
        r30 = false;
    L201:
        if (r113 == null) goto L208;
        r29 = Integer.valueOf(r113.height);
        if (r29.intValue() <= 0) goto L205;
        boolean r38 = true;
    L206:
        if (r38 == false) goto L208;
    L209:
        if (r29 != null) goto L223;
        if (r111 == null) goto L222;
        Long r39 = r111.getHeight();
        if (r39 == null) goto L222;
        if (r39.longValue() <= 0) goto L216;
        boolean r40 = true;
    L217:
        if (r40 == true) goto L220;
        r39 = null;
    L220:
        if (r39 == null) goto L222;
        r29 = Integer.valueOf((int) r39.longValue());
        goto L223
    L216:
        r40 = false;
    L222:
        r29 = null;
        goto L223
    L205:
        r38 = false;
    L208:
        r29 = null;
        goto L209
    L163:
        r120 = false;
    L168:
        if (r113 == null) goto L175;
        r26 = Integer.valueOf(r113.width);
        if (r26.intValue() <= 0) goto L172;
        boolean r123 = true;
    L173:
        if (r123 == false) goto L175;
    L176:
        if (r26 != null) goto L190;
        if (r111 == null) goto L189;
        Long r41 = r111.getWidth();
        if (r41 == null) goto L189;
        if (r41.longValue() <= 0) goto L183;
        boolean r124 = true;
    L184:
        if (r124 == true) goto L187;
        r41 = null;
    L187:
        if (r41 == null) goto L189;
        r27 = Integer.valueOf((int) r41.longValue());
        goto L191
    L183:
        r124 = false;
    L189:
        r27 = null;
        goto L191
    L172:
        r123 = false;
    L175:
        r26 = null;
        goto L176
    L157:
        r119 = null;
        goto L158
    L153:
        r118 = null;
        goto L154
    L116:
        if (Intrinsics.areEqual(r15, ry9.j.a.b) == false) goto L119;
        r21 = CreationReferenceAttachmentState.COMPRESSING;
        goto L136
    L119:
        if (Intrinsics.areEqual(r15, ry9.j.h.b) == false) goto L122;
        r21 = CreationReferenceAttachmentState.UPLOADING;
        goto L136
    L122:
        if (Intrinsics.areEqual(r15, ry9.j.g.b) == false) goto L125;
        r21 = CreationReferenceAttachmentState.UPLOAD_SUCCESS;
        goto L136
    L125:
        if (Intrinsics.areEqual(r15, ry9.j.f.b) == false) goto L128;
        r21 = CreationReferenceAttachmentState.UPLOAD_FAILED;
        goto L136
    L128:
        if (Intrinsics.areEqual(r15, ry9.j.e.b) == false) goto L131;
        r21 = CreationReferenceAttachmentState.PARSE_FAILED;
        goto L136
    L131:
        if (Intrinsics.areEqual(r15, ry9.j.d.b) == false) goto L134;
        r21 = CreationReferenceAttachmentState.INSPECT_FAILED;
        goto L136
    L134:
        if ((r15 instanceof ry9.j.c) == false) goto L139;
        r21 = CreationReferenceAttachmentState.UPLOAD_SUCCESS;
        goto L136
    L139:
        throw new NoWhenBranchMatchedException();
    L141:
        switch(b.f[r11.getStatus().ordinal()]) {
            case 1: goto L149;
            case 2: goto L148;
            case 3: goto L148;
            case 4: goto L147;
            case 5: goto L146;
            case 6: goto L145;
            case 7: goto L144;
            default: goto L143;
        };
    L144:
        r21 = CreationReferenceAttachmentState.EXPIRED;
        goto L150
    L145:
        r21 = CreationReferenceAttachmentState.INSPECT_FAILED;
        goto L150
    L146:
        r21 = CreationReferenceAttachmentState.PARSE_FAILED;
        goto L150
    L147:
        r21 = CreationReferenceAttachmentState.UPLOAD_FAILED;
        goto L150
    L148:
        r21 = CreationReferenceAttachmentState.UPLOAD_SUCCESS;
        goto L150
    L149:
        r21 = CreationReferenceAttachmentState.UPLOADING;
        goto L150
    L143:
        throw new NoWhenBranchMatchedException();
    L83:
        Image r42 = r11.getImage();
        if (r42 == null) goto L86;
        String r43 = r42.localResPath;
    L87:
        if (r43 != null) goto L89;
    L92:
        boolean r44 = true;
    L93:
        if (r44 == false) goto L107;
        mt8.b r45 = r11.getVideo();
        if (r45 == null) goto L97;
        String r46 = r45.e;
    L98:
        if (r46 != null) goto L100;
    L103:
        boolean r47 = true;
    L104:
        if (r47 == false) goto L107;
        boolean r48 = false;
    L108:
        if (r48 == false) goto L110;
        r20 = CreationReferenceAttachmentSource.MANUAL;
        goto L111
    L110:
        r20 = CreationReferenceAttachmentSource.UNKNOWN;
        goto L111
    L100:
        if (r46.length() == 0) goto L103;
        r47 = false;
        goto L104
    L97:
        r46 = null;
    L107:
        r48 = true;
        goto L108
    L89:
        if (r43.length() == 0) goto L92;
        r44 = false;
        goto L93
    L86:
        r43 = null;
        goto L87
    L73:
        if (r115 != 2) goto L75;
        r116 = CreationReferenceAttachmentType.VIDEO;
        goto L81
    L75:
        if (r115 == 3) goto L77;
        r116 = CreationReferenceAttachmentType.UNKNOWN;
        goto L81
    L77:
        r116 = CreationReferenceAttachmentType.AUDIO;
    L61:
        Image r125 = r11.getImage();
        if (r125 == null) goto L64;
        r113 = r125.imageThumb;
    L65:
        if (r113 != null) goto L70;
        Image r126 = r11.getImage();
        if (r126 == null) goto L69;
        r113 = r126.previewImage;
        goto L70
    L69:
        r113 = null;
        goto L70
    L64:
        r113 = null;
    L56:
        r111 = null;
        goto L57
    L51:
        r18 = null;
        goto L52
    L47:
        r17 = null;
        goto L49
    L44:
        r16 = null;
    L40:
        r15 = null;
        goto L42
    L255:
        return new ry9.d(CollectionsKt.toList(r7), r2, r6);
    L21:
        r6 = null;
        goto L22
    L13:
        r4 = false;
    L16:
        r2 = 0;
        goto L17
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    public final ResourceType z5(String r2) {
        ResourceItemBean r3 = this.y.get(r2);
        if (r3 == null) goto L7;
        ResourceType r4 = r3.getResourceType();
        if (r4 == null) goto L7;
        return r4;
    L7:
        return ResourceType.IMAGE;
    }

    public static void B3(List r28, ResourceItemBean r29) {
        Object r0 = r29.getExt().get("ext_audio_vid");
        if ((r0 instanceof String) == false) goto L5;
        String r1 = (String) r0;
    L7:
        if (r1 != null) goto L9;
    L11:
        String r5 = null;
    L12:
        if (r5 != null) goto L15;
        FLogger.a.w("MultiAttachmentSelector", "remote audio missing vid");
        return;
    L15:
        Object r2 = r29.getExt().get("ext_audio_type");
        if ((r2 instanceof String) == false) goto L18;
        String r3 = (String) r2;
    L20:
        if (r3 == null) goto L30;
        String r4 = StringsKt.trim(r3).toString();
        if (r4 == null) goto L30;
        String r6 = StringsKt.trimStart(r4, new char[]{'.'});
        if (r6 == null) goto L30;
        String r7 = r6.toLowerCase(Locale.ROOT);
        if (r7 == null) goto L30;
        if ((!StringsKt.isBlank(r7)) == false) goto L30;
        String r8 = r7;
    L31:
        String r9 = StringsKt.trim(r29.getTitle()).toString();
        if (r8 == null) goto L41;
        String r10 = StringsKt.substringBeforeLast(r9, '.', r9);
        if (StringsKt.isBlank(r10) == false) goto L36;
        r10 = "audio";
    L36:
        String r11 = r10 + '.' + r8;
        if (r11 == null) goto L41;
        r9 = r11;
    L44:
        Object r12 = r29.getExt().get("ext_audio_identifier");
        if ((r12 instanceof String) == false) goto L47;
        String r13 = (String) r12;
    L48:
        if (r13 != null) goto L50;
    L55:
        r13 = r29.getKey();
    L56:
        Integer r26 = Integer.valueOf(UplinkEntityType.EntityTypeFile.getValue());
        Integer r19 = Integer.valueOf(FileType.FileTypeAudio.getValue());
        Object r14 = r29.getExt().get("ext_audio_duration_seconds");
        if ((r14 instanceof Number) == false) goto L59;
        Number r15 = (Number) r14;
    L60:
        if (r15 == null) goto L62;
        Float r16 = Float.valueOf(r15.floatValue());
    L63:
        ((ArrayList) r28).add(new UplinkFileEntity(r26, new UplinkEntityContent(new UplinkFileInfo(r9, null, null, r19, null, null, new VideoExtension(r5, null, null, r8, null, null, r16, null, null, null, 950, null), r29.getMimeType(), null, null, 822, null), null, 2, null), r13, null, Integer.valueOf(FileReviewState.ACCESS.getValue()), Integer.valueOf(FileParseState.SUCCESS.getValue()), 100, Integer.valueOf(UpLinkState.SUCCESS.getValue()), null, false, null, null, null, null, 16136, null));
        return;
    L62:
        r16 = null;
        goto L63
    L59:
        r15 = null;
        goto L60
    L50:
        if ((true ^ StringsKt.isBlank(r13)) == true) goto L53;
        r13 = null;
    L53:
        if (r13 == null) goto L55;
    L47:
        r13 = null;
    L41:
        if ((!StringsKt.isBlank(r9)) == true) goto L44;
        r9 = null;
    L30:
        r8 = null;
        goto L31
    L18:
        r3 = null;
        goto L20
    L9:
        if ((!StringsKt.isBlank(r1)) == false) goto L11;
        r5 = r1;
        goto L12
    L5:
        r1 = null;
        goto L7
    }

    public static final ry9.a F2(MultiAttachmentSelectorComponent r50, xp9.i r51) {
        r50.getClass();
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        boolean r5 = G4();
        Iterator<T> r6 = r51.a.iterator();
    L4:
        if (r6.hasNext() == false) goto L63;
        Uri r7 = (Uri) r6.next();
        List<AlbumSelectItem> r0 = r51.c;
        ImageObj r8 = null;
        if (r0 == null) goto L15;
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        Object r9 = r1.next();
        if (Intrinsics.areEqual(((AlbumSelectItem) r9).a, r7) == false) goto L9;
    L14:
        AlbumSelectItem r10 = (AlbumSelectItem) r9;
    L64:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L18
        Object r11 = Result.constructor-impl(vqc.d.d(r50.getContext(), r7));     // Catch: Throwable -> L18
    L21:
        if (Result.isFailure-impl(r11) == false) goto L23;
        r11 = null;
    L23:
        String r12 = (String) r11;
        if (r12 == null) goto L4;
        r3.add(r12);
        HashMap r14 = new HashMap();
        r14.put("ext_img_show_path", r12);
        boolean r13 = true;
        if (r10 == null) goto L37;
        Long r15 = Long.valueOf(r10.e);
        if (r15.longValue() <= 0) goto L31;
        boolean r16 = true;
    L32:
        if (r16 == true) goto L35;
        r15 = null;
    L35:
        if (r15 == null) goto L37;
        r14.put("ext_creation_reference_file_size", Long.valueOf(r15.longValue()));
        goto L37
    L31:
        r16 = false;
    L37:
        com.larus.uaigc.helper.f.a.getClass();
        Boolean r17 = com.larus.uaigc.helper.f.c().d();
        Boolean r18 = Boolean.TRUE;
        if (Intrinsics.areEqual(r17, r18) == false) goto L40;
        r14.put("ext_silent_upload", r18);
    L40:
        if (r5 == false) goto L42;
        String r19 = r50.V3().c(r7, AlbumSelectionMediaType.IMAGE);
    L43:
        if (r19 != null) goto L45;
        r19 = UUID.randomUUID().toString();
    L45:
        String r28 = r19;
        String r30 = StringsKt.substringAfterLast$default(r12, '.', null, 2, null);
        String r20 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(StringsKt.substringAfterLast$default(r12, '.', null, 2, null));
        if (r20 != null) goto L48;
        r20 = "";
    L48:
        String r31 = r20;
        ItemStatus r35 = ItemStatus.UPLINKING;
        ResourceType r37 = ResourceType.IMAGE;
        String r21 = UUID.randomUUID().toString();
        if (r10 != null) goto L51;
    L61:
        ResourceItemBean r22 = new ResourceItemBean(r28, null, r30, r31, new Image(r21, "", null, r8, null, r12, null, null, null, null, null, null, null, null, 16340, null), null, 0, r35, false, r37, i5.w0(), 0, 0, 0, false, false, false, false, 0, r14, 522530, null);
        r4.add(r22);
        r50.y.put(r22.getKey(), r22);
        goto L4
    L51:
        if (r10.b > 0) goto L53;
    L55:
        r13 = false;
    L56:
        if (r13 == true) goto L59;
        r10 = null;
    L59:
        if (r10 == null) goto L61;
        r8 = new ImageObj(null, r10.b, r10.c, null, null, 25, null);
        goto L61
    L53:
        if (r10.c <= 0) goto L55;
    L42:
        r19 = null;
    L18:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L13:
        r9 = null;
        goto L14
    L15:
        r10 = null;
        goto L64
    L63:
        return new ry9.a(r4, r3, r50.Q);
    }

    public static final ry9.a L2(MultiAttachmentSelectorComponent r25, xp9.i r26) {
        r25.getClass();
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        boolean r3 = G4();
        List<AlbumSelectItem> r4 = r26.c;
        if (r4 == null) goto L47;
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L47;
        AlbumSelectItem r6 = (AlbumSelectItem) r5.next();
        ResourceItemBean r7 = com.larus.uaigc.helper.o0.c(r6.a, null);
        if (r7 == null) goto L6;
        ResourceType r8 = r7.getResourceType();
        ResourceType r9 = ResourceType.VIDEO;
        boolean r10 = true;
        if (r8 != r9) goto L17;
        mt8.b r14 = r7.getVideo();
        if (r14 == null) goto L15;
        mt8.b r11 = mt8.b.a(r14, null, RangesKt.coerceAtLeast(r6.d, 0) / 1000.0f, RangesKt.coerceAtLeast(r6.b, 0), RangesKt.coerceAtLeast(r6.c, 0), null, null, null, null, null, 497);
    L16:
        r7 = AlbumHelperKt.c(r7, null, r11, 1);
        goto L17
    L15:
        r11 = null;
    L17:
        Long r12 = Long.valueOf(r6.e);
        if (r12.longValue() > 0) goto L21;
        r10 = false;
    L21:
        if (r10 == true) goto L24;
        r12 = null;
    L24:
        if (r12 == null) goto L27;
        r7.getExt().put("ext_creation_reference_file_size", Long.valueOf(r12.longValue()));
    L27:
        if (r7.getResourceType() == ResourceType.IMAGE) goto L29;
    L35:
        if (r3 == false) goto L43;
        Uri r13 = r6.a;
        if (r13 == null) goto L43;
        CreationAlbumPipelinePrewarmer r15 = r25.V3();
        if (r7.getResourceType() != r9) goto L41;
        AlbumSelectionMediaType r16 = AlbumSelectionMediaType.VIDEO;
    L42:
        String r17 = r15.c(r13, r16);
    L44:
        if (r17 == null) goto L46;
        r7 = AlbumHelperKt.c(r7, r17, null, 2);
    L46:
        r2.add(r7);
        r25.y.put(r7.getKey(), r7);
        goto L6
    L41:
        r16 = AlbumSelectionMediaType.IMAGE;
    L43:
        r17 = null;
        goto L44
    L29:
        if (r6.b <= 0) goto L35;
        if (r6.c <= 0) goto L35;
        Image r18 = r7.getImage();
        if (r18 == null) goto L35;
        r18.imageOri = new ImageObj(null, r6.b, r6.c, null, null, 25, null);
    L47:
        r25.R4("album");
        return new ry9.a(r2, r1, r25.Q);
    }

    public static final void X2(MultiAttachmentSelectorComponent r1, ic8.n0 r2) {
        r1.getClass();
        ProcessFileResultCode r3 = r2.b;
        if (r3 != null) goto L5;
        int r4 = -1;
    L7:
        if (r4 != 1) goto L9;
        FLogger.a.e("MultiAttachmentSelector", "tryAttachmentUpload ProcessResult for OverSize");
        t19.s r5 = t19.s.a;
        Application r6 = AppHost.a.getApplication();
        r5.getClass();
        t19.s.s(r6, 2131906513);
        return;
    L9:
        if (r4 == 2) goto L11;
        t19.s r7 = t19.s.a;
        Application r8 = AppHost.a.getApplication();
        r7.getClass();
        t19.s.s(r8, 2131908214);
        return;
    L11:
        FLogger.a.e("MultiAttachmentSelector", "tryAttachmentUpload ProcessResult for PREPARE_TYPE_NO_MATCH");
        t19.s r9 = t19.s.a;
        Application r10 = AppHost.a.getApplication();
        r9.getClass();
        t19.s.s(r10, 2131906526);
        return;
    L5:
        r4 = b.d[r3.ordinal()];
        goto L7
    }

    public static final boolean i4(MultiAttachmentSelectorComponent r0, ResourceItemBean r1) {
        if ((r0.Z3() instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r1.getExt().get("ext_creation_reference_do_same"), Boolean.TRUE) == true) goto L8;
        return false;
    }

    public static final Unit m3(final MultiAttachmentSelectorComponent r14, ry9.a r15) {
        r14.getClass();
        Iterator<T> r16 = r15.a.iterator();
    L4:
        if (r16.hasNext() == false) goto L18;
        final ResourceItemBean r0 = (ResourceItemBean) r16.next();
        Image r1 = r0.getImage();
        if (r1 == null) goto L4;
        String r2 = r1.localResPath;
        if (r2 == null) goto L4;
        PolarisFileWrapper r3 = new PolarisFileWrapper(r2);
        if (r3.exists() == false) goto L4;
        nz9.b.h("creation_page/album_upload", "creation_page", r0.getKey(), null, 24);
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == true) goto L15;
        com.larus.utils.t0.e(new p2(r14, r0));
        BuildersKt.async$default(LifecycleOwnerKt.getLifecycleScope(r14), Dispatchers.getIO(), null, new MultiAttachmentSelectorComponent$onCompressUploadAndCheck$2$2(r0, r14, r3, null), 2, null);
        goto L4
    L15:
        r14.f5(r0.getKey(), r2, null);
        goto L4
    L18:
        return Unit.INSTANCE;
    }

    @Override // ry9.h
    public final Object BM(ResourceItemBean r4, Continuation<? super Unit> r5) {
        Object r6 = BuildersKt.withContext(Dispatchers.getIO(), new MultiAttachmentSelectorComponent$uploadResourceItemBean$2(r4, this, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public final void E5(String r3, String r4) {
        if (this.F.putIfAbsent(r3, Boolean.TRUE) != null) goto L6;
        nz9.b.h("upload", r4, r3, r3, 16);
        return;
    }

    public final void Q3(int r5, ResourceType r6) {
        AlbumHelperKt.g(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), new MultiAttachmentSelectorComponent$deleteExceedMediaAttachments$1(this, r5, r6, null), 2);
    }

    @Override // ry9.h
    public final void f90(boolean r3, com.larus.uaigc.createpage.component.input.t r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.V = "plus_panel_preview";
        this.U = r4;
        ry9.h.a.a(this, j4(), r3, 0, 60);
    }

    public final void i5(String r4, String r5) {
        if (r5 == null) goto L24;
        boolean r1 = true;
        if ((!StringsKt.isBlank(r5)) == true) goto L6;
    L8:
        r1 = false;
    L9:
        if (r1 == true) goto L12;
        r5 = null;
    L12:
        if (r5 == null) goto L26;
        ResourceItemBean r6 = this.y.get(r4);
        if (r6 == null) goto L25;
        Image r7 = r6.getImage();
        if (r7 != null) goto L20;
        return;
    L20:
        if (Intrinsics.areEqual(r7.localResPath, r5) == false) goto L22;
        return;
    L22:
        FLogger.a.i("MultiAttachmentSelector", "[rememberImageLocalPathForRetry] cached=true");
        r7.localResPath = r5;
        return;
    L25:
        return;
    L26:
        return;
    L6:
        if (new PolarisFileWrapper(r5).exists() == false) goto L8;
    }

    @Override // ry9.h
    public final void nE(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "resourceKey");
        Intrinsics.checkNotNullParameter(r9, "localResPath");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MultiAttachmentSelectorComponent$handleAttachmentRetry$1(this, r8, r9, null), 3, null);
    }

    public final void p4(ResourceUploadError r9, final String r10) {
        com.larus.uaigc.helper.f r0 = com.larus.uaigc.helper.f.a;
        r0.getClass();
        boolean r2 = false;
        if (com.larus.uaigc.helper.f.a() == true) goto L5;
    L8:
        com.larus.utils.t0.e(new l2(this, r10));
        r0.getClass();
        if ((!com.larus.uaigc.helper.f.a()) == false) goto L23;
        String r1 = r9.getCode();
        ProcessFileResultCode[] r3 = ProcessFileResultCode.values();
        int r4 = r3.length;
        int r5 = 0;
    L11:
        if (r5 >= r4) goto L21;
        ProcessFileResultCode r6 = r3[r5];
        if (Intrinsics.areEqual(r6.getValue(), r1) == true) goto L15;
    L17:
        boolean r7 = false;
    L18:
        if (r7 == true) goto L19;
        r5 = r5 + 1;
        goto L11
    L19:
        r2 = true;
        goto L21
    L15:
        if (Intrinsics.areEqual(r6.getErrorType(), "send_file_preprocess_fail") == false) goto L17;
        r7 = true;
    L21:
        if (r2 == true) goto L23;
        E5(r10, y5(r10));
        nz9.b.e("upload", r9.getCode(), r10);
        this.F.remove(r10);
    L23:
        nz9.b.e(y5(r10), r9.getCode(), r10);
        return;
    L5:
        if (ICreationResourceAccessServiceKt.f(r9) == false) goto L8;
        com.larus.utils.t0.e(new k2(this, r10));
        T4(false, "review", "pic");
        nz9.b.e("creation_page/album_upload", "-103", r10);
    }

    public final void q4(final String r2, final mr9.k r3) {
        com.larus.uaigc.helper.f.a.getClass();
        if ((!com.larus.uaigc.helper.f.a()) == false) goto L5;
        E5(r2, y5(r2));
    L5:
        com.larus.utils.t0.e(new v2(r3, this, r2));
    }

    public final String q5(String r6, String r7) {
        String r0 = this.w.get(r6);
        boolean r1 = true;
        String r3 = null;
        if (r0 != null) goto L5;
    L13:
        if (r7 != null) goto L15;
    L22:
        if (r3 != null) goto L25;
        return r6;
    L25:
        return r3;
    L15:
        if (r7.length() > 0) goto L18;
        r1 = false;
    L18:
        if (r1 == true) goto L21;
        r7 = null;
    L21:
        r3 = r7;
        goto L22
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L13;
        return r0;
    L7:
        r4 = false;
        goto L8
    }

    public static /* synthetic */ void V4(MultiAttachmentSelectorComponent r1, boolean r2, String r3) {
        r1.T4(r2, r3, "pic");
    }

    public static final Object p3(final MultiAttachmentSelectorComponent r16, final ResourceItemBean r17, Continuation r18) {
        r16.getClass();
        if ((r18 instanceof MultiAttachmentSelectorComponent$startVideoResourceAccess$1) == false) goto L7;
        MultiAttachmentSelectorComponent$startVideoResourceAccess$1 r2 = (MultiAttachmentSelectorComponent$startVideoResourceAccess$1) r18;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L20;
        if (r5 != 1) goto L19;
        Uri r1 = (Uri) r2.L$2;
        final String r6 = (String) r2.L$1;
        ResourceItemBean r7 = (ResourceItemBean) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L14 CancellationException -> L16
        ResourceItemBean r8 = r7;
        String r9 = r6;
    L78:
        com.larus.bmhome.resource.access.b0 r10 = (com.larus.bmhome.resource.access.b0) r0;     // Catch: CancellationException -> L16 Throwable -> L62
        if (r10 != null) goto L61;
        r10 = ICreationResourceAccessService.a.b(r16.E3(r9, r1, r8));     // Catch: CancellationException -> L16 Throwable -> L62
    L61:
        Job r11 = AlbumHelperKt.f(LifecycleOwnerKt.getLifecycleScope(r16), Dispatchers.getIO(), CoroutineStart.LAZY, new MultiAttachmentSelectorComponent$startVideoResourceAccess$observerJob$1(r16, r10, r8, r9, null));
        r16.E.put(r9, r11);
        r11.start();
        return Unit.INSTANCE;
    L62:
        th = th;
        r6 = r9;
    L66:
        FLogger.a.e("MultiAttachmentSelector", "[startVideoResourceAccess] submit failed, resourceKey=" + r6, th);
        com.larus.utils.t0.e(new g2(r16, r6));
        r16.T4(false, "upload", "video");
        nz9.b.e("creation_page/album_upload/video", "-101", r6);
        return Unit.INSTANCE;
    L14:
        th = th;
        goto L66
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r0);
        Object r14 = null;
        nz9.b.h("creation_page/album_upload/video", "creation_page", r17.getKey(), null, 24);
        com.larus.utils.t0.e(new k1(r16, r17));
        final String r12 = r17.getKey();
        Object r13 = r17.getExt().get("ext_video_local_uri");
        if ((r13 instanceof String) == false) goto L23;
        String r15 = (String) r13;
    L74:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L30
        if (r15 != null) goto L27;
        String r20 = "";
    L28:
        Object r21 = Result.constructor-impl(UriProtector.parse(r20));     // Catch: Throwable -> L30
    L33:
        if (Result.isFailure-impl(r21) == true) goto L36;
        r14 = r21;
    L36:
        Uri r22 = (Uri) r14;
        FLogger r110 = FLogger.a;
        StringBuilder r111 = new StringBuilder("[startVideoResourceAccess] hasUri=");
        if (r15 != null) goto L39;
    L42:
        boolean r23 = true;
    L43:
        r111.append(!r23);
        r110.i("MultiAttachmentSelector", r111.toString());
        if (r22 == null) goto L68;
        if (r15 != null) goto L47;
    L50:
        boolean r24 = true;
    L51:
        if (r24 == true) goto L68;
        r16.w.put(r12, r12);
        tx9.l0.d(r12);
        ResourceCenter r25 = ResourceCenter.a;
        FlowResourceScene r112 = FlowResourceScene.CreationUserVideoV2;
        r25.getClass();
        ResourceCenter.k(r12, r112);
        CreationAlbumPipelinePrewarmer r26 = r16.V3();     // Catch: CancellationException -> L16 Throwable -> L64
        r2.L$0 = r17;     // Catch: CancellationException -> L16 Throwable -> L64
        r2.L$1 = r12;     // Catch: CancellationException -> L16 Throwable -> L64
        r2.L$2 = r22;     // Catch: CancellationException -> L16 Throwable -> L64
        r2.label = 1;     // Catch: CancellationException -> L16 Throwable -> L64
        Object r27 = r26.e(r12, r2);     // Catch: CancellationException -> L16 Throwable -> L64
        if (r27 == r4) goto L81;
        r9 = r12;
        r8 = r17;
        r1 = r22;
        r0 = r27;
        goto L78
    L81:
        return r4;
    L64:
        th = th;
        r6 = r12;
        goto L66
    L47:
        if (StringsKt.isBlank(r15) == true) goto L50;
        r24 = false;
    L68:
        com.larus.utils.t0.e(new v1(r16, r12));
        r16.T4(false, "upload", "video");
        nz9.b.e("creation_page/album_upload/video", "-101", r12);
        return Unit.INSTANCE;
    L39:
        if (StringsKt.isBlank(r15) == true) goto L42;
        r23 = false;
        goto L43
    L27:
        r20 = r15;
    L30:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L23:
        r15 = null;
    L16:
        e = move-exception;
        throw e;
    L7:
        r2 = new MultiAttachmentSelectorComponent$startVideoResourceAccess$1(r16, r18);
        goto L8
    }

    public final void C3(List<UplinkFileEntity> r55, ry9.j r56, ResourceItemBean r57) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[addVideoEntityToList] start, resourceItem.key: ");
        r1.append(r57.getKey());
        r1.append(", current entities size: ");
        ArrayList r2 = (ArrayList) r55;
        r1.append(r2.size());
        r0.i("MultiAttachmentSelector", r1.toString());
        ry9.i r3 = r56.a();
        if ((r3 instanceof ry9.i.b) == false) goto L5;
        ry9.i.b r4 = (ry9.i.b) r3;
    L6:
        if (r4 != null) goto L21;
        mt8.b r5 = r57.getVideo();
        if (r5 != null) goto L10;
    L20:
        r4 = null;
        goto L21
    L10:
        if (r5.e == null) goto L20;
        String r12 = r57.getKey();
        mt8.b r6 = r57.getVideo();
        if (r6 == null) goto L14;
        String r11 = r6.e;
    L15:
        com.larus.bmhome.actionbar.model.f2 r15 = k4(r57.getKey());
        mt8.b r7 = r57.getVideo();
        if (r7 == null) goto L18;
        Double r16 = Double.valueOf(r7.b);
    L19:
        r4 = new ry9.i.b(new MediaAttachment(null, null, null, new VideoUploadInfo(null, r15, r16, 1, null), r11, r12, null, null, null, null, null, null, 4039, null));
        goto L21
    L18:
        r16 = null;
        goto L19
    L14:
        r11 = null;
    L21:
        if (r4 == null) goto L25;
        MediaAttachment r8 = r4.a;
        if (r8 == null) goto L25;
        String r9 = r8.getUri();
    L26:
        if (r4 == null) goto L30;
        MediaAttachment r10 = r4.a;
        if (r10 == null) goto L30;
        String r13 = r10.getLocalFilePath();
    L31:
        if (r4 == null) goto L35;
        MediaAttachment r14 = r4.a;
        if (r14 == null) goto L35;
        String r36 = r14.getIdentifier();
    L36:
        if (r4 == null) goto L40;
        MediaAttachment r17 = r4.a;
        if (r17 == null) goto L40;
        String r19 = r17.getResourceId();
    L41:
        if (r4 == null) goto L45;
        MediaAttachment r18 = r4.a;
        if (r18 == null) goto L45;
        VideoUploadInfo r20 = r18.getVideoUploadInfo();
    L46:
        StringBuilder r21 = new StringBuilder("[addVideoEntityToList] hasLocalFile=");
        boolean r22 = true;
        if (r13 != null) goto L49;
    L52:
        boolean r23 = true;
    L53:
        r21.append(!r23);
        r21.append(", hasRemoteKey=");
        if (r9 != null) goto L56;
    L59:
        boolean r24 = true;
    L60:
        r21.append(!r24);
        r0.i("MultiAttachmentSelector", r21.toString());
        if (r13 != null) goto L63;
    L66:
        boolean r25 = true;
    L67:
        int r26 = 100;
        if (r25 == false) goto L70;
    L144:
        String r110 = r13;
        if (r20 == null) goto L147;
        String r27 = r20.getVid();
    L149:
        if (com.larus.utils.o0.d(r27) == false) goto L199;
        Integer r28 = Integer.valueOf(FileType.FileTypeVideo.getValue());
        if (r20 == null) goto L153;
        String r29 = r20.getVid();
    L155:
        if (r20 == null) goto L159;
        com.larus.bmhome.actionbar.model.f2 r30 = r20.getCover();
        if (r30 == null) goto L159;
        String r38 = r30.a;
    L161:
        if (r20 == null) goto L165;
        com.larus.bmhome.actionbar.model.f2 r31 = r20.getCover();
        if (r31 == null) goto L165;
        String r210 = r31.a;
    L166:
        if (r20 == null) goto L172;
        com.larus.bmhome.actionbar.model.f2 r32 = r20.getCover();
        if (r32 == null) goto L172;
        Integer r33 = r32.c;
        if (r33 == null) goto L172;
        int r211 = r33.intValue();
    L173:
        if (r20 == null) goto L179;
        com.larus.bmhome.actionbar.model.f2 r34 = r20.getCover();
        if (r34 == null) goto L179;
        Integer r35 = r34.d;
        if (r35 == null) goto L179;
        int r212 = r35.intValue();
    L180:
        Image r111 = new Image(r38, null, null, new ImageObj(r210, r212, r211, null, null, 24, null), null, null, null, null, null, null, null, null, null, null, 16374, null);
        if (r20 == null) goto L185;
        Double r37 = r20.getDuration();
        if (r37 == null) goto L185;
        Float r39 = Float.valueOf((float) r37.doubleValue());
    L186:
        mt8.b r40 = r57.getVideo();
        if (r40 == null) goto L189;
        Integer r41 = Integer.valueOf(r40.d);
    L190:
        mt8.b r42 = r57.getVideo();
        if (r42 == null) goto L193;
        Integer r112 = Integer.valueOf(r42.c);
    L195:
        if (Intrinsics.areEqual(r57.getExt().get("ext_creation_reference_do_same"), Boolean.TRUE) == true) goto L197;
        String r113 = "upload";
    L198:
        r2.add(new UplinkFileEntity(Integer.valueOf(UplinkEntityType.EntityTypeFile.getValue()), new UplinkEntityContent(new UplinkFileInfo(null, r9, null, r28, null, r19, new VideoExtension(r29, r110, r111, null, null, null, r39, r41, r112, r113, 56, null), null, null, null, 917, null), null, 2, null), r36, null, Integer.valueOf(FileReviewState.DEFAULT.getValue()), Integer.valueOf(FileParseState.SUCCESS.getValue()), 100, Integer.valueOf(UpLinkState.SUCCESS.getValue()), null, false, null, null, null, null, 16136, null));
        r0.i("MultiAttachmentSelector", "[addVideoEntityToList] added remote video, entityCount=" + r2.size());
        return;
    L197:
        r113 = null;
        goto L198
    L193:
        r112 = null;
        goto L195
    L189:
        r41 = null;
    L185:
        r39 = null;
    L179:
        r212 = 0;
    L172:
        r211 = 0;
    L165:
        r210 = null;
    L159:
        r38 = null;
        goto L161
    L153:
        r29 = null;
        goto L155
    L199:
        r0.w("MultiAttachmentSelector", "[addVideoEntityToList] Remote video but videoUploadInfo?.vid is null or empty, skipped");
        return;
    L147:
        r27 = null;
        goto L149
    L70:
        if (new PolarisFileWrapper(r13).exists() == false) goto L144;
        ImFileUtil r43 = ImFileUtil.a;
        PolarisFileWrapper r44 = new PolarisFileWrapper(r13);
        r43.getClass();
        String r213 = ImFileUtil.g(r44);
        int r214 = FileType.FileTypeVideo.getValue();
        long r215 = new PolarisFileWrapper(r13).length();
        if (r20 == null) goto L74;
        String r45 = r20.getVid();
    L76:
        if (r20 == null) goto L80;
        com.larus.bmhome.actionbar.model.f2 r46 = r20.getCover();
        if (r46 == null) goto L80;
        String r310 = r46.a;
    L82:
        if (r20 == null) goto L86;
        com.larus.bmhome.actionbar.model.f2 r47 = r20.getCover();
        if (r47 == null) goto L86;
        String r216 = r47.a;
    L87:
        if (r20 == null) goto L93;
        com.larus.bmhome.actionbar.model.f2 r48 = r20.getCover();
        if (r48 == null) goto L93;
        Integer r49 = r48.c;
        if (r49 == null) goto L93;
        int r311 = r49.intValue();
    L94:
        if (r20 == null) goto L100;
        com.larus.bmhome.actionbar.model.f2 r50 = r20.getCover();
        if (r50 == null) goto L100;
        Integer r51 = r50.d;
        if (r51 == null) goto L100;
        int r217 = r51.intValue();
    L101:
        ImageObj r410 = new ImageObj(r216, r217, r311, null, null, 24, null);
        if (r20 == null) goto L106;
        com.larus.bmhome.actionbar.model.f2 r52 = r20.getCover();
        if (r52 == null) goto L106;
        String r411 = r52.b;
    L107:
        Image r114 = new Image(r310, null, null, r410, null, r411, null, null, null, null, null, null, null, null, 16342, null);
        if (r20 == null) goto L112;
        Double r53 = r20.getDuration();
        if (r53 == null) goto L112;
        Float r115 = Float.valueOf((float) r53.doubleValue());
    L113:
        mt8.b r54 = r57.getVideo();
        if (r54 == null) goto L116;
        Integer r116 = Integer.valueOf(r54.d);
    L117:
        mt8.b r58 = r57.getVideo();
        if (r58 == null) goto L120;
        Integer r59 = Integer.valueOf(r58.c);
    L122:
        if (Intrinsics.areEqual(r57.getExt().get("ext_creation_reference_do_same"), Boolean.TRUE) == true) goto L124;
        String r117 = "upload";
    L125:
        String r118 = r13;
        String r60 = r9;
        UplinkEntityContent r61 = new UplinkEntityContent(new UplinkFileInfo(null, r60, r213, Integer.valueOf(r214), Long.valueOf(r215), r19, new VideoExtension(r45, r13, r114, null, null, null, r115, r116, r59, r117, 56, null), null, r118, null, 641, null), null, 2, null);
        Integer r62 = Integer.valueOf(UplinkEntityType.EntityTypeFile.getValue());
        Integer r119 = Integer.valueOf(FileReviewState.DEFAULT.getValue());
        Integer r120 = Integer.valueOf(FileParseState.SUCCESS.getValue());
        if (r9 != null) goto L128;
    L131:
        boolean r63 = true;
    L132:
        if (r63 == false) goto L134;
        r26 = 0;
    L134:
        Integer r121 = Integer.valueOf(r26);
        if (r9 != null) goto L137;
    L140:
        if (r22 == false) goto L142;
        UpLinkState r64 = UpLinkState.PROCESSING;
    L143:
        r2.add(new UplinkFileEntity(r62, r61, r36, null, r119, r120, r121, Integer.valueOf(r64.getValue()), null, false, Uri.fromFile(new PolarisFileWrapper(r118)), null, null, null, 15112, null));
        r0.i("MultiAttachmentSelector", "[addVideoEntityToList] added local video, entityCount=" + r2.size());
        return;
    L142:
        r64 = UpLinkState.SUCCESS;
        goto L143
    L137:
        if (r9.length() == 0) goto L140;
        r22 = false;
        goto L140
    L128:
        if (r9.length() == 0) goto L131;
        r63 = false;
        goto L132
    L124:
        r117 = null;
        goto L125
    L120:
        r59 = null;
        goto L122
    L116:
        r116 = null;
    L112:
        r115 = null;
    L106:
        r411 = null;
    L100:
        r217 = 0;
    L93:
        r311 = 0;
    L86:
        r216 = null;
    L80:
        r310 = null;
        goto L82
    L74:
        r45 = null;
        goto L76
    L63:
        if (r13.length() == 0) goto L66;
        r25 = false;
        goto L67
    L56:
        if (StringsKt.isBlank(r9) == true) goto L59;
        r24 = false;
        goto L60
    L49:
        if (StringsKt.isBlank(r13) == true) goto L52;
        r23 = false;
    L45:
        r20 = null;
    L40:
        r19 = null;
    L35:
        r36 = null;
    L30:
        r13 = null;
    L25:
        r9 = null;
        goto L26
    L5:
        r4 = null;
        goto L6
    }

    public final com.larus.uaigc.service.p0 E3(String r36, Uri r37, ResourceItemBean r38) {
        int r0 = com.larus.uaigc.service.p0.x;
        com.larus.bmhome.resource.access.j0.a r1 = new com.larus.bmhome.resource.access.j0.a(r37.toString());
        ResourceCenter.a.getClass();
        boolean r2 = ResourceCenter.d(r36);
        int r3 = UplinkEntityType.EntityTypeFile.getValue();
        Integer r7 = Integer.valueOf(FileType.FileTypeVideo.getValue());
        VideoExtension r4 = new VideoExtension(null, null, null, null, null, null, null, null, null, null, 1023, null);
        mt8.b r10 = r38.getVideo();
        if (r10 == null) goto L5;
        String r11 = r10.e;
    L6:
        r4.setPath(r11);
        mt8.b r12 = r38.getVideo();
        if (r12 == null) goto L9;
        Image r13 = r12.a;
    L10:
        r4.setCover(r13);
        mt8.b r14 = r38.getVideo();
        if (r14 == null) goto L13;
        int r15 = Integer.valueOf(r14.c);
    L14:
        r4.setWidth(r15);
        mt8.b r16 = r38.getVideo();
        if (r16 == null) goto L17;
        int r17 = Integer.valueOf(r16.d);
    L18:
        r4.setHeight(r17);
        r4.setSource("upload");
        Unit r18 = Unit.INSTANCE;
        mr9.h r5 = new mr9.h(r2, null, new UplinkFileEntity(Integer.valueOf(r3), new UplinkEntityContent(new UplinkFileInfo(null, null, null, r7, null, null, r4, null, null, null, 951, null), null, 2, null), r36, null, null, null, null, null, null, false, r37, null, null, null, 15352, null), 26);
        CountDownLatch r6 = new CountDownLatch(1);
        String r8 = r38.getFileSuffixes();
        Boolean r9 = Boolean.TRUE;
        ys8.a r19 = d4();
        if (r19 == null) goto L21;
        com.larus.bmhome.actionbar.model.e2 r110 = r19.tQ();
    L22:
        if (r110 == null) goto L26;
        Long r20 = r110.d;
        if (r20 == null) goto L26;
        long r21 = r20.longValue();
    L27:
        Map r22 = MapsKt.mapOf(TuplesKt.to("video_max_duration_seconds", String.valueOf(r21)));
        com.larus.bmhome.resource.access.d0 r23 = com.larus.uaigc.service.g.a;
        return com.larus.uaigc.service.p0.a.f(r1, r36, r5, r6, r8, r9, r22, LifecycleOwnerKt.getLifecycleScope(this), 7424);
    L26:
        r21 = 0;
        goto L27
    L21:
        r110 = null;
        goto L22
    L17:
        r17 = 0;
        goto L18
    L13:
        r15 = 0;
        goto L14
    L9:
        r13 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    @Override // ry9.h
    public final void Ke(final String r11, MediaAttachment r12, final boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "resourceKey");
        Intrinsics.checkNotNullParameter(r12, SlashMentionConfig.MENTION_CONTENT_ATTACHMENT);
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L12;
        this.A.put(r11, r12);
        String r0 = r12.getIdentifier();
        if (r0 == null) goto L12;
        if ((!StringsKt.isBlank(r0)) == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L12;
        String r1 = this.w.putIfAbsent(r11, r0);
    L12:
        String r2 = r12.getLocalFilePath();
        if (r2 != null) goto L16;
        r2 = "";
    L16:
        if (new PolarisFileWrapper(r2).exists() == false) goto L18;
        final ry9.j.c r3 = new ry9.j.c(new ry9.i.b(r12));
        com.larus.utils.t0.e(new z1(this, r11, r3, r13));
        return;
    L18:
        com.larus.utils.t0.e(new a2(this, r11, r13));
        this.E.put(r11, AlbumHelperKt.g(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), new MultiAttachmentSelectorComponent$triggerVideoDownloadAndExplain$5(r12, r13, this, r11, null), 2));
    }

    public final void T4(boolean r56, String r57, String r58) {
        ny9.s r0 = W3();
        String r3 = null;
        if (r0 == null) goto L7;
        Bundle r1 = r0.a;
        if (r1 == null) goto L7;
        String r2 = r1.getString("open_from", "");
    L8:
        boolean r4 = false;
        if (Intrinsics.areEqual(r2, "slides") == false) goto L48;
        ny9.s r5 = W3();
        if (r5 == null) goto L15;
        Bundle r6 = r5.a;
        if (r6 == null) goto L15;
        String r7 = r6.getString("slides_mob_config", "");
    L16:
        if (r7 != null) goto L18;
    L19:
        r4 = true;
    L20:
        if (r4 == false) goto L121;
    L26:
        lr9.a r8 = null;
    L27:
        if (r56 == false) goto L29;
        String r14 = "1";
    L30:
        if (r8 == null) goto L32;
        String r40 = r8.e();
    L33:
        if (r8 == null) goto L35;
        String r41 = r8.f();
    L36:
        if (r8 == null) goto L38;
        Integer r42 = r8.g();
    L39:
        if (r8 == null) goto L41;
        String r43 = r8.b();
    L42:
        if (r8 == null) goto L44;
        Integer r44 = r8.c();
    L45:
        if (r8 == null) goto L47;
        r3 = r8.a();
    L47:
        tx9.y3.a(null, "aippt_new_detail", null, null, null, null, r14, null, null, "image_generate_page", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "aippt_new", r40, r41, r42, r43, r44, r3, null, null, null, null, null, null, null, -2115, 65027);
        return;
    L44:
        r44 = null;
        goto L45
    L41:
        r43 = null;
        goto L42
    L38:
        r42 = null;
        goto L39
    L35:
        r41 = null;
        goto L36
    L32:
        r40 = null;
        goto L33
    L29:
        r14 = "0";
        goto L30
    L121:
        r8 = (lr9.a) new Gson().fromJson(r7, lr9.a.class);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        FLogger.a.e("MultiAttachmentSelector", "getSlidesMobConfig error", e);
        com.larus.platform.service.g.a.ensureNotReachHere(e);
        goto L26
    L18:
        if (r7.length() != 0) goto L20;
    L15:
        r7 = null;
        goto L16
    L48:
        ny9.s r9 = W3();
        if (r9 == null) goto L53;
        ICoreInputAbility.SendMessageTrackExtMap r10 = r9.n();
        if (r10 == null) goto L53;
        Map r11 = r10.a;
    L54:
        ny9.u r12 = c4();
        if (r12 == null) goto L57;
        String r17 = r12.getClickFrom();
    L58:
        ny9.u r13 = c4();
        if (r13 == null) goto L61;
        String r19 = r13.m();
    L62:
        ny9.u r15 = c4();
        if (r15 == null) goto L65;
        String r20 = r15.i();
    L66:
        ny9.u r16 = c4();
        if (r16 == null) goto L69;
        String r21 = r16.c();
    L70:
        uy9.a r18 = (uy9.a) this.r.getValue();
        if (r18 == null) goto L73;
        r18.Rq();
        String r22 = "template_page";
    L74:
        if (r22 != null) goto L76;
    L79:
        boolean r23 = true;
    L80:
        if (r23 == true) goto L82;
    L94:
        String r24 = r22;
    L95:
        uy9.a r25 = (uy9.a) this.r.getValue();
        if (r25 == null) goto L98;
        String r110 = r25.PG();
    L99:
        ny9.u r26 = c4();
        if (r26 == null) goto L102;
        String r27 = r26.getEnterMethod();
    L103:
        ny9.u r28 = c4();
        if (r28 == null) goto L106;
        String r29 = r28.getBotId();
    L107:
        if (r56 == false) goto L109;
        String r111 = "1";
    L110:
        IAIChatControlTraceService.Companion r30 = IAIChatControlTraceService.a;
        String r210 = r30.h(r30.gb());
        if (r11 == null) goto L113;
        String r34 = (String) r11.get("from_template_id");
    L114:
        if (r11 == null) goto L116;
        String r35 = (String) r11.get("from_template_sub_type");
    L117:
        if (r11 == null) goto L119;
        r3 = (String) r11.get("template_rec_req_id");
    L119:
        tx9.y3.a(r29, r24, r110, r57, r58, null, r111, null, null, r17, null, r19, r20, r21, null, r27, null, r210, null, null, null, null, null, null, null, null, r34, r35, null, null, r3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -806021216, 65533);
        return;
    L116:
        r35 = null;
        goto L117
    L113:
        r34 = null;
        goto L114
    L109:
        r111 = "0";
        goto L110
    L106:
        r29 = null;
        goto L107
    L102:
        r27 = null;
        goto L103
    L98:
        r110 = null;
        goto L99
    L82:
        if ((getContext() instanceof ny9.i) == true) goto L85;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if ((com.larus.ui.arch.component.internal.attach.a.b(this, this) instanceof ny9.i) == true) goto L85;
    L86:
        if (r4 == false) goto L94;
        ny9.s r31 = W3();
        if (r31 == null) goto L93;
        Bundle r32 = r31.a;
        if (r32 == null) goto L92;
        r22 = r32.getString("previous_page_name");
        goto L94
    L92:
        r22 = null;
        goto L94
    L93:
        r24 = null;
    L85:
        r4 = true;
        goto L86
    L76:
        if (r22.length() == 0) goto L79;
        r23 = false;
        goto L80
    L73:
        r22 = null;
        goto L74
    L69:
        r21 = null;
        goto L70
    L65:
        r20 = null;
        goto L66
    L61:
        r19 = null;
        goto L62
    L57:
        r17 = null;
    L53:
        r11 = null;
    L7:
        r2 = null;
        goto L8
    }

    public final void f5(final String r20, String r21, ic8.m0 r22) {
        PolarisFileWrapper r5 = w5(r21);
        if (r5 != null) goto L21;
        FLogger.a.w("MultiAttachmentSelector", "[parseUriAndStartUpload] local file invalid");
        com.larus.utils.t0.e(new i2(this, r20));
        T4(false, "upload", "pic");
        nz9.b.e(y5(r20), "-101", r20);
        return;
    L21:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Object r1 = Result.constructor-impl(Uri.fromFile(r5));     // Catch: Throwable -> L8
    L11:
        if (Result.isSuccess-impl(r1) == false) goto L18;
        Uri r2 = (Uri) r1;
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L15;
        this.w.putIfAbsent(r20, r20);
        String r3 = (String) MapsKt.getValue(this.w, r20);
    L16:
        Job r4 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new MultiAttachmentSelectorComponent$parseUriAndStartUpload$3$uploadJob$1(r3, this, r20, r5, r22, null), 2, null);
        this.E.put(r20, r4);
        goto L18
    L15:
        r3 = null;
    L18:
        if (Result.exceptionOrNull-impl(r1) == null) goto L23;
        com.larus.utils.t0.e(new j2(this, r20));
        T4(false, "upload", "pic");
        return;
    L23:
        return;
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // ry9.h
    public final void uz(String r11, String r12, ic8.m0 r13) {
        Intrinsics.checkNotNullParameter(r11, "resourceKey");
        Intrinsics.checkNotNullParameter(r12, "localResPath");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MultiAttachmentSelectorComponent$triggerUploadAndCheck$1(this, r11, r12, r13, null), 3, null);
    }

    @Override // ry9.h
    public final void w60(String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "resourceKey");
        Intrinsics.checkNotNullParameter(r12, "localResPath");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MultiAttachmentSelectorComponent$handleAttachmentRemove$1(this, r11, r13, r12, null), 3, null);
    }

    @Override // ry9.h
    public final void xz(String r2, int r3, boolean r4) {
        this.R = r2;
        this.S = r3;
        ry9.h.a.a(this, j4(), r4, 0, 60);
    }

    public static final Object z3(MultiAttachmentSelectorComponent r9, kq9.d r10, String r11, Continuation r12) {
        r9.getClass();
        if ((r12 instanceof MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$1) == false) goto L7;
        MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$1 r0 = (MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$1 r7 = r0;
        Object r13 = r7.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r7.label;
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L18;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r13);
    L51:
        return r13;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r11 = (String) r7.L$0;
        ResultKt.throwOnFailure(r13);
    L17:
        String r4 = r11;
        String r14 = (String) r13;
        if (r14 == null) goto L53;
        PolarisFileWrapper r15 = w5(r14);
        if (r15 == null) goto L53;
        String r16 = r9.J;
        if (r16 != null) goto L47;
        int r17 = wf9.b.a;
        r16 = com.flow.kmp.common.util.i.a();
        r9.J = r16;
        r9.L = r16;
    L47:
        String r5 = r16;
        ResourceCenter r18 = ResourceCenter.a;
        FlowResourceScene r19 = FlowResourceScene.ImageVLM;
        r18.getClass();
        ResourceCenter.k(r4, r19);
        String r110 = r15.getAbsolutePath();
        r7.L$0 = null;
        r7.label = 3;
        r13 = r9.R5(r110, r4, r5, null, null, r7);
        if (r13 != r2) goto L51;
        return r2;
    L53:
        return null;
    L18:
        Uri r111 = (Uri) r7.L$1;
        r11 = (String) r7.L$0;
        ResultKt.throwOnFailure(r13);
    L31:
        ResourceItemBean r112 = (ResourceItemBean) r13;
        if (r112 == null) goto L53;
        ResourceCenter r6 = ResourceCenter.a;
        FlowResourceScene r8 = FlowResourceScene.CreationUserVideoV2;
        r6.getClass();
        ResourceCenter.k(r11, r8);
        return ICreationResourceAccessService.a.b(r9.E3(r11, r111, r112));
    L19:
        ResultKt.throwOnFailure(r13);
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L53;
        Uri r113 = r10.a.a;
        if (r113 == null) goto L53;
        if (r10.b != AlbumSelectionMediaType.VIDEO) goto L35;
        CoroutineDispatcher r114 = Dispatchers.getIO();
        MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$bean$1 r20 = new MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$bean$1(r113, r11, null);
        r7.L$0 = r11;
        r7.L$1 = r113;
        r7.label = 1;
        Object r115 = BuildersKt.withContext(r114, r20, r7);
        if (r115 == r2) goto L54;
        r13 = r115;
        r111 = r113;
        goto L31
    L54:
        return r2;
    L35:
        CoroutineDispatcher r116 = Dispatchers.getIO();
        MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$localResPath$1 r21 = new MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$localResPath$1(r9, r113, null);
        r7.L$0 = r11;
        r7.label = 2;
        r13 = BuildersKt.withContext(r116, r21, r7);
        if (r13 != r2) goto L17;
        return r2;
    L7:
        r0 = new MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$1(r9, r12);
        goto L8
    }

    public final void B4(final String r38, ResourceItemBean r39, String r40, Map<String, String> r41) {
        mt8.b r3 = r39.getVideo();
        if (r3 == null) goto L59;
        String r4 = r41.get("video_cover_key");
        if (r4 != null) goto L7;
        String r15 = "";
    L8:
        String r5 = r41.get("video_cover_local_path");
        if (r5 != null) goto L11;
        String r20 = "";
    L13:
        if (StringsKt.isBlank(r15) == true) goto L15;
    L20:
        String r6 = r41.get("video_cover_width");
        if (r6 == null) goto L25;
        Integer r7 = StringsKt.toIntOrNull(r6);
        if (r7 == null) goto L25;
        int r31 = r7.intValue();
    L26:
        String r8 = r41.get("video_cover_height");
        if (r8 == null) goto L31;
        Integer r9 = StringsKt.toIntOrNull(r8);
        if (r9 == null) goto L31;
        int r32 = r9.intValue();
    L32:
        Image r10 = new Image(r15, null, null, new ImageObj(null, r31, r32, null, null, 25, null), null, r20, null, null, null, null, null, null, null, null, 16342, null);
    L33:
        String r11 = r41.get("video_duration_ms");
        if (r11 == null) goto L38;
        Long r12 = StringsKt.toLongOrNull(r11);
        if (r12 == null) goto L38;
        long r13 = r12.longValue();
    L39:
        float r14 = r13 / 1000.0f;
        String r16 = r41.get("video_width");
        if (r16 == null) goto L44;
        Integer r17 = StringsKt.toIntOrNull(r16);
        if (r17 == null) goto L44;
        int r18 = r17.intValue();
    L48:
        String r2 = r41.get("video_height");
        if (r2 == null) goto L53;
        Integer r19 = StringsKt.toIntOrNull(r2);
        if (r19 == null) goto L53;
        int r21 = r19.intValue();
    L56:
        int r22 = r21;
    L58:
        mt8.b r23 = mt8.b.a(r3, r10, r14, r18, r22, r40, null, null, null, null, 480);
    L60:
        final ResourceItemBean r24 = AlbumHelperKt.c(r39, null, r23, 1);
        com.larus.uaigc.helper.f.a.getClass();
        Boolean r25 = com.larus.uaigc.helper.f.c().d();
        Boolean r26 = Boolean.TRUE;
        if (Intrinsics.areEqual(r25, r26) == false) goto L63;
        r24.getExt().put("ext_silent_upload", r26);
    L63:
        this.y.put(r38, r24);
        com.larus.utils.t0.e(new x2(this, r38, r24));
        return;
    L53:
        mt8.b r27 = r39.getVideo();
        if (r27 == null) goto L57;
        r21 = r27.d;
        goto L56
    L57:
        r22 = 0;
    L44:
        mt8.b r28 = r39.getVideo();
        if (r28 == null) goto L47;
        r18 = r28.c;
        goto L48
    L47:
        r18 = 0;
    L38:
        r13 = 0;
    L31:
        r32 = 0;
    L25:
        r31 = 0;
        goto L26
    L15:
        if (StringsKt.isBlank(r20) == false) goto L20;
        mt8.b r29 = r39.getVideo();
        if (r29 == null) goto L19;
        r10 = r29.a;
        goto L33
    L19:
        r10 = null;
        goto L33
    L11:
        r20 = r5;
        goto L13
    L7:
        r15 = r4;
        goto L8
    L59:
        r23 = null;
        goto L60
    }

    public final Object F4(ResourceItemBean r12, ResourceUploadError r13, String r14, Continuation<? super Unit> r15) {
        if ((r15 instanceof MultiAttachmentSelectorComponent$handleVideoResourceAccessFail$1) == false) goto L7;
        MultiAttachmentSelectorComponent$handleVideoResourceAccessFail$1 r0 = (MultiAttachmentSelectorComponent$handleVideoResourceAccessFail$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r17 = (String) r0.L$2;
        r13 = (ResourceUploadError) r0.L$1;
        ResourceItemBean r18 = (ResourceItemBean) r0.L$0;
        ResultKt.throwOnFailure(r16);
        r14 = r17;
        r12 = r18;
    L27:
        T4(false, "upload", "video");
        nz9.b.e("creation_page/album_upload/video", "-101", r12.getKey());
    L29:
        tx9.l0.c("video_edit", r12.getKey(), false, Boxing.boxLong(new PolarisFileWrapper(r14).length() / ((long) 1000)), mr9.i.a(r13.getCode()));
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        FLogger.a.w("MultiAttachmentSelector", "[handleVideoResourceAccessFail] errorCode=" + r13.getCode());
        String r19 = r13.getCode();
        ProcessFileResultCode[] r4 = ProcessFileResultCode.values();
        int r5 = r4.length;
        int r6 = 0;
    L16:
        if (r6 >= r5) goto L21;
        ProcessFileResultCode r8 = r4[r6];
        if (Intrinsics.areEqual(r8.getValue(), r19) == true) goto L23;
        r6 = r6 + 1;
    L23:
        if (CollectionsKt.contains(SetsKt.setOf(new ProcessFileResultCode[]{ProcessFileResultCode.PREPARE_FILE_NOT_FOUND, ProcessFileResultCode.PREPARE_OVER_STORAGE_FREE_SPACE, ProcessFileResultCode.PREPARE_OPEN_FILE_ERROR, ProcessFileResultCode.PREPARE_RES_NOT_FOUND, ProcessFileResultCode.PREPARE_TYPE_NO_MATCH, ProcessFileResultCode.PREPARE_OVER_SIZE, ProcessFileResultCode.PREPARE_OVER_DURATION, ProcessFileResultCode.PREPARE_OVER_META_LIMIT}), r8) == false) goto L28;
        ic8.n0 r110 = new ic8.n0(null, r8);
        r0.L$0 = r12;
        r0.L$1 = r13;
        r0.L$2 = r14;
        r0.label = 1;
        if (U5(r12, r110, true, r0) != r2) goto L27;
        return r2;
    L28:
        p4(r13, r12.getKey());
        goto L29
    L21:
        r8 = null;
    L7:
        r0 = new MultiAttachmentSelectorComponent$handleVideoResourceAccessFail$1(this, r15);
        goto L8
    }

    public final Object U5(ResourceItemBean r9, ic8.n0 r10, boolean r11, Continuation<? super Unit> r12) {
        Object r13 = BuildersKt.withContext(Dispatchers.getMain(), new MultiAttachmentSelectorComponent$toastVideoCheckFailed$2(r10, r11, this, r9, null), r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }

    public final void v4(String r39, mr9.l r40, String r41, final String r42) {
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == true) goto L6;
        E5(r42, "creation_page/album_upload/video");
        nz9.b.e("upload", "0", r42);
        this.F.remove(r42);
    L6:
        if (this.E.get(r42) != null) goto L8;
        return;
    L8:
        ResourceItemBean r3 = this.y.get(r42);
        if (r3 == null) goto L11;
        mt8.b r8 = r3.getVideo();
    L12:
        mr9.n r7 = r40.e;
        if (r7 == null) goto L15;
        mr9.e r9 = r7.c;
    L16:
        boolean r10 = false;
        if (r9 == null) goto L29;
        Integer r11 = r9.j();
        if (r11 == null) goto L29;
        if (r11.intValue() <= 0) goto L23;
        boolean r12 = true;
    L24:
        if (r12 == true) goto L27;
        r11 = null;
    L27:
        if (r11 == null) goto L29;
        int r13 = r11.intValue();
    L31:
        int r14 = r13;
    L33:
        if (r9 == null) goto L45;
        Integer r15 = r9.h();
        if (r15 == null) goto L45;
        if (r15.intValue() <= 0) goto L39;
        boolean r16 = true;
    L40:
        if (r16 == true) goto L43;
        r15 = null;
    L43:
        if (r15 == null) goto L45;
        int r17 = r15.intValue();
    L47:
        int r18 = r17;
    L49:
        if (r9 == null) goto L61;
        Long r19 = r9.d();
        if (r19 == null) goto L61;
        if (r19.longValue() <= 0) goto L55;
        boolean r110 = true;
    L56:
        if (r110 == true) goto L59;
        r19 = null;
    L59:
        if (r19 == null) goto L61;
        double r20 = r19.longValue() / 1000.0d;
    L71:
        double r111 = r20;
        if (r3 == null) goto L75;
        if (r8 == null) goto L75;
        boolean r21 = true;
        final ResourceItemBean r4 = AlbumHelperKt.c(r3, null, mt8.b.a(r8, null, (float) r111, r14, r18, null, null, null, null, null, 497), 1);
    L76:
        if (r4 == null) goto L78;
        this.y.put(r42, r4);
    L78:
        String r22 = r40.a;
        mr9.n r23 = r40.e;
        if (r23 == null) goto L81;
        String r24 = r23.a;
    L82:
        com.larus.bmhome.actionbar.model.f2 r112 = k4(r39);
        FLogger.a.i("MultiAttachmentSelector", "[handleUploadVideoSuccess] coverReady=true");
        Unit r113 = Unit.INSTANCE;
        final ry9.j.c r25 = new ry9.j.c(new ry9.i.b(new MediaAttachment(null, r22, null, new VideoUploadInfo(r24, r112, Double.valueOf(r111)), r41, r39, r40.c, null, null, null, null, null, 3973, null)));
        com.larus.utils.t0.e(new z2(r4, this, r42, r25));
        T4(r21, null, "video");
        nz9.b.e("creation_page/album_upload/video", "0", r42);
        return;
    L81:
        r24 = null;
    L75:
        r21 = true;
        r4 = null;
        goto L76
    L55:
        r110 = false;
    L61:
        if (r8 == null) goto L70;
        Float r26 = Float.valueOf(r8.b);
        if (r26.floatValue() <= 0.0f) goto L65;
        r10 = true;
    L65:
        if (r10 == true) goto L68;
        r26 = null;
    L68:
        if (r26 == null) goto L70;
        r20 = r26.floatValue();
    L70:
        r20 = 0.0d;
        goto L71
    L39:
        r16 = false;
    L45:
        if (r8 == null) goto L48;
        r17 = r8.d;
        goto L47
    L48:
        r18 = 0;
        goto L49
    L23:
        r12 = false;
    L29:
        if (r8 == null) goto L32;
        r13 = r8.c;
        goto L31
    L32:
        r14 = 0;
        goto L33
    L15:
        r9 = null;
        goto L16
    L11:
        r8 = null;
        goto L12
    }

    public static final Object h3(final MultiAttachmentSelectorComponent r18, final com.larus.bmhome.resource.access.b0 r19, final ResourceItemBean r20, final String r21, Continuation r22) {
        r18.getClass();
        if ((r22 instanceof MultiAttachmentSelectorComponent$observeVideoResourceAccessTask$1) == false) goto L7;
        MultiAttachmentSelectorComponent$observeVideoResourceAccessTask$1 r1 = (MultiAttachmentSelectorComponent$observeVideoResourceAccessTask$1) r22;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        MultiAttachmentSelectorComponent$observeVideoResourceAccessTask$1 r9 = r1;
        Object r0 = r9.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r9.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r0);
    L93:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r0);
    L94:
        return Unit.INSTANCE;
    L17:
        Ref.BooleanRef r4 = (Ref.BooleanRef) r9.L$3;
        Ref.ObjectRef r5 = (Ref.ObjectRef) r9.L$2;
        String r6 = (String) r9.L$1;
        ResourceItemBean r7 = (ResourceItemBean) r9.L$0;
        ResultKt.throwOnFailure(r0);
    L28:
        com.larus.bmhome.resource.access.a0.d r8 = (com.larus.bmhome.resource.access.a0) r0;
        if ((r8 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L73;
        if (r4.element == true) goto L57;
        com.larus.bmhome.resource.access.a0.d r11 = r8;
        CharSequence r12 = (CharSequence) r11.a.f.get("preprocess_result");
        if (r12 != null) goto L35;
    L38:
        boolean r13 = true;
    L39:
        if (r13 == true) goto L57;
        com.larus.bmhome.resource.access.j0.b r14 = r11.a.b;
        if ((r14 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L43;
        com.larus.bmhome.resource.access.j0.b r15 = r14;
    L44:
        if (r15 == null) goto L53;
        String r16 = r15.b;
        if (r16 == null) goto L53;
        if ((!StringsKt.isBlank(r16)) == true) goto L51;
        r16 = null;
    L51:
        if (r16 == null) goto L53;
    L55:
        if ((!StringsKt.isBlank(r16)) == false) goto L57;
        r5.element = r16;
        r18.B4(r6, r7, r16, r11.a.f);
    L53:
        r16 = (String) r5.element;
        goto L55
    L43:
        r15 = null;
        goto L44
    L35:
        if (StringsKt.isBlank(r12) == true) goto L38;
        r13 = false;
    L57:
        mr9.l r17 = ICreationResourceAccessServiceKt.h(r8);
        if (r17 != null) goto L63;
        ResourceUploadError r23 = new ResourceUploadError("empty_upload_result", "upload result is null");
        String r24 = (String) r5.element;
        r9.L$0 = null;
        r9.L$1 = null;
        r9.L$2 = null;
        r9.L$3 = null;
        r9.label = 2;
        if (r18.F4(r7, r23, r24, r9) != r10) goto L94;
        return r10;
    L63:
        FLogger.a.i("MultiAttachmentSelector", "[observeVideoResourceAccessTask] success");
        r18.G.remove(r6);
        r18.v4(r6, r17, (String) r5.element, r6);
        mr9.n r25 = r17.e;
        if (r25 == null) goto L70;
        mr9.e r26 = r25.c;
        if (r26 == null) goto L70;
        Long r27 = r26.i();
        if (r27 == null) goto L70;
        long r28 = r27.longValue();
    L71:
        tx9.l0.c("video_edit", r6, true, Boxing.boxLong(r28 / ((long) 1000)), null);
    L70:
        r28 = new PolarisFileWrapper((String) r5.element).length();
        goto L71
    L73:
        if ((r8 instanceof com.larus.bmhome.resource.access.a0.c) == true) goto L87;
        if ((r8 instanceof com.larus.bmhome.resource.access.a0.a) == true) goto L87;
        if (Intrinsics.areEqual(r8, com.larus.bmhome.resource.access.a0.b.a) == true) goto L93;
        if ((r8 instanceof com.larus.bmhome.resource.access.a0.e) == true) goto L93;
        if ((r8 instanceof com.larus.bmhome.resource.access.a0.f) == true) goto L93;
        throw new NoWhenBranchMatchedException();
    L87:
        if (ICreationResourceAccessServiceKt.d(r8) == false) goto L89;
        FLogger.a.i("MultiAttachmentSelector", "[observeVideoResourceAccessTask] page destroy cancel");
        return Unit.INSTANCE;
    L89:
        ResourceUploadError r29 = ICreationResourceAccessServiceKt.g(r8);
        String r30 = (String) r5.element;
        r9.L$0 = null;
        r9.L$1 = null;
        r9.L$2 = null;
        r9.L$3 = null;
        r9.label = 3;
        if (r18.F4(r7, r29, r30, r9) != r10) goto L93;
        return r10;
    L18:
        ResultKt.throwOnFailure(r0);
        final Ref.ObjectRef r110 = new Ref.ObjectRef();
        mt8.b r31 = r20.getVideo();
        if (r31 == null) goto L21;
        String r32 = r31.e;
    L22:
        if (r32 != null) goto L24;
        r32 = "";
    L24:
        r110.element = r32;
        final Ref.BooleanRef r33 = new Ref.BooleanRef();
        Function1 r111 = new x1(r19, r18, r21, r110, r20, r33);
        Function1 r34 = new y1(r18, r21);
        r9.L$0 = r20;
        r9.L$1 = r21;
        r9.L$2 = r110;
        r9.L$3 = r33;
        r9.label = 1;
        r0 = CreationResourceAccessPerfBridgeKt.a(r19, "creation_page/album_upload/video", r21, r21, r111, r34, r9);
        if (r0 == r10) goto L96;
        r7 = r20;
        r6 = r21;
        r5 = r110;
        r4 = r33;
        goto L28
    L96:
        return r10;
    L21:
        r32 = null;
    L7:
        r1 = new MultiAttachmentSelectorComponent$observeVideoResourceAccessTask$1(r18, r22);
        goto L8
    }

    @Override // ry9.h
    public final void YL(final int r17, final boolean r18, final int r19, final int r20, final ry9.d r21) {
        com.larus.bmhome.actionbar.model.w0.a r0 = Z3();
        if ((r0 instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L10;
        wa8.d1 r1 = r0.a;
        if (r1.a(CreationReferenceMediaType.IMAGE) == false) goto L7;
    L11:
        com.larus.bmhome.actionbar.model.w0.a r2 = Z3();
        if ((r2 instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L18;
        if (r2.a.a(CreationReferenceMediaType.VIDEO) == false) goto L19;
        if (r20 <= 0) goto L19;
        final boolean r5 = true;
    L20:
        if (r5 == true) goto L22;
    L25:
        d5(r17, r18, r19, r5, r20, r21);
        return;
    L22:
        if (com.larus.platform.service.k2.a.q() == false) goto L25;
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.larus.platform.api.g3.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), null, false, Boolean.TRUE, false, new b2(this, r17, r18, r19, r5, r20, r21), 22);
        return;
    L19:
        r5 = false;
        goto L20
    L18:
        if (Intrinsics.areEqual(r2, com.larus.bmhome.actionbar.model.w0.b.a) == true) goto L19;
        throw new NoWhenBranchMatchedException();
    L7:
        if (r1.a(CreationReferenceMediaType.VIDEO) == true) goto L11;
        return;
    L10:
        if (Intrinsics.areEqual(r0, com.larus.bmhome.actionbar.model.w0.b.a) == true) goto L11;
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Failed to calculate best type for var: r0v16 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v16 ??, new type: ny9.s
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v16 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v16 ??, new type: ny9.s
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v18 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v18 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v18 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v18 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v19 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v19 ??, new type: java.lang.Object
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v22 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v22 ??, new type: ny9.u
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v23 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v23 ??, new type: ny9.u
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v24 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v24 ??, new type: ny9.u
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v25 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v25 ??, new type: ny9.u
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v29 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v29 ??, new type: java.lang.Integer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v30 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v30 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v31 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v31 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v32 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v32 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v33 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v33 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v34 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v34 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v35 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v35 ??, new type: android.os.Bundle
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v36 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v36 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r12v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v2 ??, new type: com.larus.bmhome.actionbar.model.z0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r12v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v2 ??, new type: com.larus.bmhome.actionbar.model.z0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r12v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v3 ??, new type: com.larus.bmhome.actionbar.model.z0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r12v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v3 ??, new type: com.larus.bmhome.actionbar.model.z0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r12v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v5 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r12v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v6 ??, new type: com.larus.bmhome.actionbar.model.z0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r17v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v1 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r17v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v2 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r17v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v3 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r18v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r18v1 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r18v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r18v2 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r18v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r18v3 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r19v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v1 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r19v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v2 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r19v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v3 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r21v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r21v1 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r21v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r21v2 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r21v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r21v3 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r24v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r24v1 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r24v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r24v2 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r24v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r24v3 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r25v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r25v2 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r25v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r25v3 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r25v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r25v4 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r41v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r41v0 'this'  ??, new type: com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r41v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r41v0 'this'  ??, new type: com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v18 ??, new type: java.lang.CharSequence
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderAllow(TypeUpdate.java:66)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryWiderObjects(FixTypesVisitor.java:795)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:249)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    public final java.lang.Object h5(java.lang.String r42, android.graphics.Bitmap r43, boolean r44, boolean r45, kotlin.coroutines.Continuation<? super kotlin.Unit> r46) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01bb: INVOKE (r0v16 ?? I:ny9.s) = 
              (r41v0 'this' ?? I:com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent A[IMMUTABLE_TYPE, THIS])
             VIRTUAL call: com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent.W3():ny9.s A[DECLARE_VAR, MD:():ny9.s (m)] (LINE:83886523) in method: com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent.h5(java.lang.String, android.graphics.Bitmap, boolean, boolean, kotlin.coroutines.Continuation<? super kotlin.Unit>):java.lang.Object, file: /private/tmp/nixiang/classes31.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 634
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent.h5(java.lang.String, android.graphics.Bitmap, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void l4(String r14, String r15, String r16, boolean r17, boolean r18) {
        tx9.l0.b("creation_page_passed_image_re_upload", r14, false, mr9.i.a(r15), null, null, 48);
        int r2 = com.larus.uaigc.service.e.a;
        if (Intrinsics.areEqual(r15, "review_un_pass") == false) goto L5;
        T4(false, "review", "pic");
        ry9.j r3 = ry9.j.d.b;
    L6:
        e4(r14).setValue(new ry9.k(r14, r3, 0, r17, r18, false, 36));
        nz9.b.e("creation_page/re_upload", r15, r14);
        FLogger.a.e("MultiAttachmentSelector", "[handleRemoteResourceAccessFail] errorCode=" + r15 + ", errorMessage=" + r16);
        return;
    L5:
        T4(false, "upload", "pic");
        r3 = ry9.j.f.b;
        goto L6
    }

    public final mr9.h D3(String r40, String r41, String r42, String r43, ic8.m0 r44, Pair<Integer, Integer> r45) {
        boolean r2 = false;
        if (r40.length() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L9;
        ResourceCenter.a.getClass();
        boolean r14 = ResourceCenter.d(r40);
        String r9 = com.larus.platform.service.o.a.getDeviceId();
        String r11 = x5();
        ny9.s r3 = W3();
        if (r3 == null) goto L17;
        Bundle r4 = r3.b();
        if (r4 == null) goto L15;
        String r5 = r4.getString("chat_section_id");
    L16:
        String r12 = r5;
    L18:
        ResourceAttachmentExtra r6 = new ResourceAttachmentExtra(r9, r42, r11, r12, r41);
        if (r45 != null) goto L26;
        BitmapFactory.Options r7 = new BitmapFactory.Options();
        r7.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r43, r7);
        int r8 = r7.outWidth;
        if (r8 > 0) goto L23;
    L25:
        Pair<Integer, Integer> r10 = null;
    L27:
        int r17 = UplinkEntityType.EntityTypeImage.getValue();
        Uri r29 = Uri.fromFile(new PolarisFileWrapper(r43));
        if (r44 == null) goto L31;
        String r13 = r44.f;
        if (r13 == null) goto L31;
    L32:
        String r18 = r13;
        if (r10 == null) goto L35;
        ImageObj r19 = new ImageObj(null, ((Number) r10.component1()).intValue(), ((Number) r10.component2()).intValue(), null, null, 25, null);
    L36:
        if (r44 != null) goto L38;
    L40:
        if (r2 == false) goto L42;
        String r0 = "1";
    L44:
        return new mr9.h(r14, r6, new UplinkFileEntity(Integer.valueOf(r17), new UplinkEntityContent(null, new Image(null, r18, null, r19, null, r43, r40, MapsKt.mapOf(TuplesKt.to("is_marked", r0)), null, null, null, null, null, null, 16149, null), 1, null), r40, null, null, null, null, null, null, false, r29, null, null, null, 15352, null), 24);
    L42:
        r0 = "0";
        goto L44
    L38:
        if (r44.i != true) goto L40;
        r2 = true;
        goto L40
    L35:
        r19 = null;
    L31:
        ImFileUtil r15 = ImFileUtil.a;
        PolarisFileWrapper r16 = new PolarisFileWrapper(r43);
        r15.getClass();
        r13 = ImFileUtil.g(r16);
        goto L32
    L23:
        if (r7.outHeight <= 0) goto L25;
        r10 = TuplesKt.to(Integer.valueOf(r8), Integer.valueOf(r7.outHeight));
        goto L27
    L26:
        r10 = r45;
        goto L27
    L15:
        r5 = null;
        goto L16
    L17:
        r12 = null;
        goto L18
    L9:
        return new mr9.h(false, null, null, 31);
    L5:
        r1 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object R5(String r36, String r37, String r38, ic8.m0 r39, Pair<Integer, Integer> r40, Continuation<? super com.larus.bmhome.resource.access.b0> r41) {
        if ((r41 instanceof MultiAttachmentSelectorComponent$submitImageResourceAccessTask$1) == false) goto L7;
        MultiAttachmentSelectorComponent$submitImageResourceAccessTask$1 r1 = (MultiAttachmentSelectorComponent$submitImageResourceAccessTask$1) r41;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        MultiAttachmentSelectorComponent$submitImageResourceAccessTask$1 r10 = r1;
        Object r0 = r10.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r10.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ic8.m0 r4 = (ic8.m0) r10.L$2;
        String r5 = (String) r10.L$1;
        String r6 = (String) r10.L$0;
        ResultKt.throwOnFailure(r0);
        ic8.m0 r13 = r4;
        String r15 = r5;
        Object r7 = r0;
        String r8 = null;
    L24:
        mr9.h r17 = (mr9.h) r7;
        ICreationResourceAccessService.Companion r9 = ICreationResourceAccessService.a;
        int r12 = com.larus.uaigc.service.p0.x;
        if (r13 == null) goto L27;
        String r14 = r13.a;
    L28:
        int r16 = com.larus.uaigc.helper.g.a;
        if (r13 == null) goto L31;
        String r18 = r13.a;
    L32:
        Boolean r19 = Boolean.valueOf(com.larus.uaigc.helper.g.b(r18));
        if (r13 == null) goto L40;
        Long r20 = Long.valueOf(r13.c);
        if (r20.longValue() < 0) goto L37;
        boolean r21 = true;
    L38:
        if (r21 == false) goto L40;
        Long r22 = r20;
    L41:
        if (r13 == null) goto L43;
        mr9.c r23 = r13.l;
    L44:
        com.larus.bmhome.resource.access.j0.b r24 = new com.larus.bmhome.resource.access.j0.b(r6, r14, r19, r22, r23);
        CountDownLatch r25 = new CountDownLatch(1);
        com.larus.bmhome.resource.access.d0 r31 = com.larus.uaigc.service.g.a;
        return r9.b(com.larus.uaigc.service.p0.a.b(r24, r15, null, r17, true, r25, null, null, null, null, new m2(), new n2(), null, null, null, null, null, r31, false, null, 1304456));
    L43:
        r23 = r8;
        goto L44
    L37:
        r21 = false;
    L40:
        r22 = r8;
        goto L41
    L31:
        r18 = r8;
        goto L32
    L27:
        r14 = r8;
        goto L28
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Pair<Integer, Integer> r26 = (Pair) r10.L$4;
        ic8.m0 r27 = (ic8.m0) r10.L$3;
        String r28 = (String) r10.L$2;
        String r29 = (String) r10.L$1;
        String r30 = (String) r10.L$0;
        ResultKt.throwOnFailure(r0);
        Pair<Integer, Integer> r110 = r26;
        ic8.m0 r32 = r27;
        String r33 = r29;
        String r111 = r30;
    L20:
        String r34 = ((CreationRemoteConversationHelper.a) r0).a;
        CoroutineDispatcher r35 = Dispatchers.getIO();
        r13 = r32;
        String r112 = r33;
        MultiAttachmentSelectorComponent$submitImageResourceAccessTask$resourceCenterUploadParam$1 r42 = new MultiAttachmentSelectorComponent$submitImageResourceAccessTask$resourceCenterUploadParam$1(this, r33, r28, r34, r111, r32, r110, null);
        r10.L$0 = r111;
        r10.L$1 = r112;
        r10.L$2 = r13;
        r8 = null;
        r10.L$3 = null;
        r10.L$4 = null;
        r10.label = 2;
        r7 = BuildersKt.withContext(r35, r42, r10);
        if (r7 != r11) goto L23;
        return r11;
    L23:
        r6 = r111;
        r15 = r112;
        goto L24
    L16:
        ResultKt.throwOnFailure(r0);
        r10.L$0 = r36;
        r10.L$1 = r37;
        r10.L$2 = r38;
        r10.L$3 = r39;
        r10.L$4 = r40;
        r10.label = 1;
        Object r43 = s5(r10);
        if (r43 != r11) goto L19;
        return r11;
    L19:
        r111 = r36;
        r33 = r37;
        r32 = r39;
        r110 = r40;
        r0 = r43;
        r28 = r38;
    L7:
        r1 = new MultiAttachmentSelectorComponent$submitImageResourceAccessTask$1(this, r41);
        goto L8
    }

    public final void d5(int r31, boolean r32, int r33, boolean r34, int r35, ry9.d r36) {
        ry9.d r4 = r36;
        G3();
        if (r4 == null) goto L21;
        List<ry9.c> r8 = r4.a;
        if (r8 == null) goto L21;
        Iterator<T> r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L17;
        Object r10 = r9.next();
        ry9.c r11 = (ry9.c) r10;
        if (r32 == true) goto L12;
    L14:
        boolean r12 = false;
    L15:
        if (r12 == false) goto L8;
    L18:
        ry9.c r13 = (ry9.c) r10;
        if (r13 == null) goto L21;
        String r14 = r13.a;
    L22:
        com.larus.bmhome.actionbar.model.w0.a r15 = Z3();
        if ((r15 instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L25;
        com.larus.bmhome.actionbar.model.w0.a r16 = r15;
    L26:
        if (r16 == null) goto L80;
        wa8.d1 r17 = r16.a;
        if (r17 == null) goto L80;
        if (r4 != null) goto L31;
        r4 = yH(CollectionsKt.toList(this.y.values()));
    L31:
        Collection r18 = r17.c.values();
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator r110 = r18.iterator();
    L33:
        if (r110.hasNext() == false) goto L35;
        wa8.g1 r111 = (wa8.g1) r110.next();
        r19.add(new CreationReferenceAlbumMediaRule(T5(r111.getType()), r111.b, r111.d, r111.g, r111.j, r111.k, r111.l, r111.m, r111.n, r111.c, r111.f, r111.i));
        r110 = r110;
        r14 = r14;
        goto L33
    L35:
        String r29 = r14;
        List r0 = r17.d;
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = r0.iterator();
    L37:
        if (r1.hasNext() == false) goto L43;
        wa8.h1 r2 = (wa8.h1) r1.next();
        List r3 = r2.a;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L40:
        if (r5.hasNext() == false) goto L42;
        r113.add(T5((CreationReferenceMediaType) r5.next()));
        goto L40
    L42:
        r112.add(new CreationReferenceAlbumMixedRule(r113, r2.b, r2.d, r2.c, r2.f));
        goto L37
    L43:
        List<ry9.c> r6 = r4.a;
        ArrayList r7 = new ArrayList();
        Iterator<T> r20 = r6.iterator();
    L45:
        if (r20.hasNext() == false) goto L50;
        Object r21 = r20.next();
        String r22 = r29;
        if (Intrinsics.areEqual(((ry9.c) r21).a, r22) == true) goto L49;
        r7.add(r21);
    L49:
        r29 = r22;
        goto L45
    L50:
        ArrayList r114 = new ArrayList();
        Iterator r23 = r7.iterator();
    L52:
        if (r23.hasNext() == false) goto L79;
        ry9.c r24 = (ry9.c) r23.next();
        int r25 = b.b[r24.getType().ordinal()];
        if (r25 != 1) goto L56;
        CreationReferenceAlbumMediaType r26 = CreationReferenceAlbumMediaType.IMAGE;
    L67:
        CreationReferenceAlbumMediaType r115 = r26;
        Integer r27 = r24.h;
        Integer r28 = r24.i;
        Double r30 = r24.j;
        if (r30 != null) goto L70;
    L75:
        Double r116 = null;
    L76:
        CreationReferenceAlbumAttachment r37 = new CreationReferenceAlbumAttachment(r115, r27, r28, r116, r24.k);
    L77:
        if (r37 == null) goto L52;
        r114.add(r37);
        goto L52
    L70:
        if (r30.doubleValue() <= 0.0d) goto L72;
        boolean r38 = true;
    L73:
        if (r38 == false) goto L75;
        r116 = r30;
        goto L76
    L72:
        r38 = false;
        goto L73
    L56:
        if (r25 != 2) goto L58;
        r26 = CreationReferenceAlbumMediaType.VIDEO;
        goto L67
    L58:
        if (r25 != 3) goto L60;
        r26 = CreationReferenceAlbumMediaType.AUDIO;
        goto L67
    L60:
        if (r25 != 4) goto L63;
        r37 = null;
        goto L77
    L63:
        throw new NoWhenBranchMatchedException();
    L79:
        CreationReferenceAlbumConfig r39 = new CreationReferenceAlbumConfig(r19, r112, r114, r17.a, r4.b, r4.c);
    L81:
        this.X = r39;
        if (r32 == false) goto L90;
        this.Q = r33;
        AlbumSettingConfig.a r40 = new AlbumSettingConfig.a();
        r40.f = this.V;
        if (r34 == true) goto L86;
    L88:
        boolean r41 = false;
    L89:
        r40.i = r41;
        r40.c = false;
        r40.w = this.X;
        r40.y = true;
        AlbumSettingConfig r42 = r40.a();
        this.V = null;
        LocalTakePictureImpl r43 = this.H;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r43.g(com.larus.ui.arch.component.internal.attach.a.b(this, this), r42);
        com.larus.bmhome.actionbar.model.z0 r44 = null;
    L115:
        ny9.s r45 = W3();
        if (r45 == null) goto L118;
        com.larus.bmhome.actionbar.model.z0 r46 = r45.f();
    L119:
        ny9.u r47 = c4();
        if (r47 == null) goto L122;
        com.larus.bmhome.actionbar.model.z0 r48 = r47.getBotId();
    L123:
        ny9.u r49 = c4();
        if (r49 == null) goto L126;
        com.larus.bmhome.actionbar.model.z0 r50 = r49.getChatType();
    L127:
        ny9.u r51 = c4();
        if (r51 == null) goto L130;
        com.larus.bmhome.actionbar.model.z0 r52 = r51.r();
    L131:
        ny9.u r53 = c4();
        if (r53 == null) goto L134;
        com.larus.bmhome.actionbar.model.z0 r54 = r53.getEnterMethod();
    L135:
        if (r46 == null) goto L141;
        com.larus.bmhome.actionbar.model.r r55 = r46.q;
        if (r55 == null) goto L141;
        Integer r56 = r55.a;
        if (r56 == null) goto L141;
        com.larus.bmhome.actionbar.model.z0 r117 = r56.toString();
    L142:
        if (r46 == null) goto L146;
        com.larus.bmhome.actionbar.model.r r57 = r46.q;
        if (r57 == null) goto L146;
        com.larus.bmhome.actionbar.model.z0 r118 = r57.g;
    L147:
        ny9.u r58 = c4();
        if (r58 == null) goto L150;
        com.larus.bmhome.actionbar.model.z0 r59 = r58.q();
    L151:
        tx9.c0.H(r48, r52, r54, null, r50, r59, null, r117, r118, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, 33553992);
        return;
    L150:
        r59 = r44;
    L146:
        r118 = r44;
    L141:
        r117 = r44;
        goto L142
    L134:
        r54 = r44;
        goto L135
    L130:
        r52 = r44;
        goto L131
    L126:
        r50 = r44;
        goto L127
    L122:
        r48 = r44;
        goto L123
    L118:
        r46 = r44;
        goto L119
    L86:
        if (r35 <= 0) goto L88;
        r41 = true;
        goto L89
    L90:
        this.Q = -1;
        if (this.O == false) goto L109;
        AlbumSettingConfig.a r60 = new AlbumSettingConfig.a();
        r60.f = this.V;
        r60.i = r34;
        r60.d = r31;
        r60.s = r34;
        r60.t = r35;
        r60.c = true;
        r60.w = this.X;
        r60.y = true;
        AlbumSettingConfig r61 = r60.a();
        r44 = null;
        this.V = null;
        if (G4() == true) goto L95;
        Bundle r62 = null;
    L103:
        if (r62 != null) goto L105;
        LocalTakePictureImpl r63 = this.H;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r63.g(com.larus.ui.arch.component.internal.attach.a.b(this, this), r61);
        goto L115
    L105:
        LocalTakePictureImpl r64 = this.H;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r65 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        MultiAttachmentSelectorComponent$openAlbumInternal$2 r119 = new MultiAttachmentSelectorComponent$openAlbumInternal$2(this);
        r64.getClass();
        Intrinsics.checkNotNullParameter(r65, "fragment");
        Intrinsics.checkNotNullParameter(r61, "albumConfig");
        Intrinsics.checkNotNullParameter(r119, "onFail");
        r64.i(r65, r61, null, r62, new li8.l(), r119);
        goto L115
    L95:
        this.K = true;
        this.L = null;
        final CreationAlbumPipelinePrewarmer r66 = V3();
        r66.getClass();
        r66.a(ResourceCancelReason.REPLACED);
        final String r67 = UUID.randomUUID().toString();
        Object r68 = r66.c;
        monitor-enter(r68);
        r66.d = r67;     // Catch: Throwable -> L106
        Unit r69 = Unit.INSTANCE;     // Catch: Throwable -> L106
        monitor-exit(r68);
        ConcurrentHashMap<String, Function2<kq9.d, Boolean, Unit>> r70 = kq9.c.a;
        Function2<kq9.d, Boolean, Unit> r71 = new com.larus.uaigc.createpage.component.mediaselector.imageselector.a(r66, r67);
        Intrinsics.checkNotNullParameter(r67, "sessionId");
        Intrinsics.checkNotNullParameter(r71, "listener");
        if ((!StringsKt.isBlank(r67)) == false) goto L102;
        kq9.c.a.put(r67, r71);
    L102:
        Bundle r72 = new Bundle();
        r72.putString("extra.album.selection.session.id", r67);
        r62 = r72;
    L106:
        th = move-exception;
        throw th;
    L109:
        r44 = null;
        AlbumSettingConfig.a r73 = new AlbumSettingConfig.a();
        r73.f = this.V;
        if (r34 == false) goto L113;
        if (r35 <= 0) goto L113;
        boolean r74 = true;
    L114:
        r73.i = r74;
        r73.c = false;
        r73.w = this.X;
        r73.y = true;
        AlbumSettingConfig r75 = r73.a();
        LocalTakePictureImpl r76 = this.H;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r76.g(com.larus.ui.arch.component.internal.attach.a.b(this, this), r75);
    L113:
        r74 = false;
    L80:
        r39 = null;
        goto L81
    L25:
        r16 = null;
        goto L26
    L12:
        if (r11.b != r33) goto L14;
        r12 = true;
        goto L15
    L17:
        r10 = null;
    L21:
        r14 = null;
        goto L22
    }

    public final Object W4(final com.larus.bmhome.resource.access.b0 r9, final String r10, String r11, Function1<? super ResourceUploadError, Unit> r12, Function1<? super mr9.l, Unit> r13, final Function1<? super mr9.k, Unit> r14, Continuation<? super Unit> r15) {
        if ((r15 instanceof MultiAttachmentSelectorComponent$observeImageResourceAccessTask$1) == false) goto L7;
        MultiAttachmentSelectorComponent$observeImageResourceAccessTask$1 r0 = (MultiAttachmentSelectorComponent$observeImageResourceAccessTask$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        MultiAttachmentSelectorComponent$observeImageResourceAccessTask$1 r7 = r0;
        Object r16 = r7.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r7.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r13 = (Function1) r7.L$1;
        r12 = (Function1) r7.L$0;
        ResultKt.throwOnFailure(r16);
    L17:
        ICreationResourceAccessServiceKt.c((com.larus.bmhome.resource.access.a0) r16, r13, r12);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        Function1 r5 = new c2(r9, this, r10);
        Function1 r6 = new d2(r14);
        r7.L$0 = r12;
        r7.L$1 = r13;
        r7.label = 1;
        r16 = CreationResourceAccessPerfBridgeKt.a(r9, r11, r10, r10, r5, r6, r7);
        if (r16 != r2) goto L17;
        return r2;
    L7:
        r0 = new MultiAttachmentSelectorComponent$observeImageResourceAccessTask$1(this, r15);
        goto L8
    }

    @Override // ry9.h
    public final void q00(final String r34, String r35, String r36, String r37, String r38, final boolean r39, final boolean r40, String r41) {
        Intrinsics.checkNotNullParameter(r34, "resourceKey");
        Intrinsics.checkNotNullParameter(r35, "url");
        Intrinsics.checkNotNullParameter(r36, "identifier");
        Intrinsics.checkNotNullParameter(r37, "resourceId");
        Intrinsics.checkNotNullParameter(r38, "localFilePath");
        String r31 = null;
        boolean r16 = false;
        if ((!StringsKt.isBlank(r35)) == true) goto L13;
        if (r41 != null) goto L6;
    L9:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L13;
        MutableLiveData<ry9.k> r10 = null;
    L14:
        com.larus.uaigc.helper.f.a.getClass();
        MutableLiveData<ry9.k> r32 = r10;
        final ry9.j.c r3 = H3(this, r34, r35, r41, r36, r37, r38, 0, 0, com.larus.uaigc.helper.f.a(), 192);
        if (com.larus.uaigc.helper.f.a() == true) goto L17;
    L38:
        if (r3 == null) goto L41;
        com.larus.utils.t0.e(new f3(this, r34, r3, r39, r40));
        return;
    L41:
        this.E.put(r34, BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1(r35, this, r36, r38, r34, r41, r37, r39, r40, null), 3, null));
        return;
    L17:
        if ((!StringsKt.isBlank(r35)) == true) goto L23;
        if (r41 != null) goto L20;
    L21:
        r16 = true;
    L22:
        if (r16 == true) goto L38;
    L20:
        if (StringsKt.isBlank(r41) == false) goto L22;
    L23:
        this.A.put(r34, new MediaAttachment(r35, r41, null, null, r38, r36, r37, null, null, null, null, null, 3980, null));
        if (r32 == null) goto L31;
        if (r3 == null) goto L28;
        ry9.j r2 = r3;
    L29:
        r32.setValue(new ry9.k(r34, r2, 0, r39, r40, false, 36));
        goto L31
    L28:
        r2 = ry9.j.h.b;
    L31:
        if ((!StringsKt.isBlank(r36)) == false) goto L33;
        r31 = r36;
    L33:
        if (r31 != null) goto L35;
        StringBuilder r1 = new StringBuilder();
        r1.append(UUID.randomUUID());
        r1.append('_');
        r1.append(System.currentTimeMillis());
        String r4 = r1.toString();
    L36:
        this.w.put(r34, r4);
        this.E.put(r34, BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new MultiAttachmentSelectorComponent$submitRemoteImageResourceAccess$uploadJob$1(this, r34, r4, r38, r35, r41, r37, r39, r40, null), 2, null));
        return;
    L35:
        r4 = r31;
        goto L36
    L6:
        if (StringsKt.isBlank(r41) == true) goto L9;
        r0 = false;
    L13:
        r10 = e4(r34);
        goto L14
    }

    public static final Object N2(final MultiAttachmentSelectorComponent r30, String r31, String r32, Bitmap r33, String r34, String r35, String r36, boolean r37, boolean r38, Continuation r39) {
        r30.getClass();
        if ((r39 instanceof MultiAttachmentSelectorComponent$explainResourceUrl$1) == false) goto L7;
        MultiAttachmentSelectorComponent$explainResourceUrl$1 r1 = (MultiAttachmentSelectorComponent$explainResourceUrl$1) r39;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        boolean r8 = false;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 == 3) goto L16;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r0);
    L74:
        return Unit.INSTANCE;
    L17:
        boolean r5 = r1.Z$1;
        boolean r7 = r1.Z$0;
        String r9 = (String) r1.L$5;
        String r10 = (String) r1.L$4;
        String r11 = (String) r1.L$3;
        Bitmap r12 = (Bitmap) r1.L$2;
        String r13 = (String) r1.L$1;
        String r14 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
        String r20 = r9;
        String r22 = r10;
        String r21 = r11;
        Bitmap r15 = r12;
        String r16 = r13;
    L27:
        com.larus.network.http.y r6 = (com.larus.network.http.a) r0;
        if ((r6 instanceof com.larus.network.http.y) == false) goto L72;
        com.larus.uaigc.api.s r17 = (com.larus.uaigc.api.s) ((com.larus.network.http.a) r6).b;
        if (r17 == null) goto L34;
        List<com.larus.uaigc.api.q> r18 = r17.a();
        if (r18 == null) goto L34;
        com.larus.uaigc.api.q r19 = (com.larus.uaigc.api.q) CollectionsKt.firstOrNull(r18);
    L35:
        if (r19 == null) goto L37;
        String r110 = r19.c();
    L39:
        if (com.larus.utils.o0.d(r110) == false) goto L64;
        if (r19 == null) goto L42;
        r8 = Intrinsics.areEqual(r19.a(), Boxing.boxBoolean(false));
    L42:
        if (r8 == false) goto L64;
        FLogger.a.i("MultiAttachmentSelector", "explainResourceUrl success");
        com.larus.uaigc.api.p r23 = r19.b();
        if (r23 == null) goto L52;
        com.larus.uaigc.api.n r24 = r23.a();
        if (r24 == null) goto L52;
        com.larus.uaigc.api.m r25 = r24.a();
        if (r25 == null) goto L52;
        Long r26 = r25.b();
        if (r26 == null) goto L52;
        long r27 = r26.longValue();
    L53:
        Long r28 = Boxing.boxLong(r27);
        com.larus.uaigc.api.p r29 = r19.b();
        if (r29 == null) goto L62;
        com.larus.uaigc.api.n r40 = r29.a();
        if (r40 == null) goto L62;
        com.larus.uaigc.api.m r41 = r40.a();
        if (r41 == null) goto L62;
        Long r42 = r41.a();
        if (r42 == null) goto L62;
        long r43 = r42.longValue();
    L63:
        final ry9.j.c r44 = new ry9.j.c(new ry9.i.a(new MediaAttachment(r16, r110, new ImageUploadInfo(r28, Boxing.boxLong(r43)), null, r20, r21, r22, null, null, null, null, null, 3976, null), null));
        final String r310 = r14;
        final boolean r311 = r7;
        final boolean r312 = r5;
        com.larus.utils.t0.e(new w1(r30, r310, r44, r311, r312));
    L62:
        r43 = r15.getHeight();
    L52:
        r27 = r15.getWidth();
    L64:
        FLogger r45 = FLogger.a;
        StringBuilder r46 = new StringBuilder("explainResourceUrl success, but needRePush: ");
        if (r19 == null) goto L67;
        Boolean r47 = r19.a();
    L68:
        r46.append(r47);
        r45.i("MultiAttachmentSelector", r46.toString());
        r1.L$0 = null;
        r1.L$1 = null;
        r1.L$2 = null;
        r1.L$3 = null;
        r1.L$4 = null;
        r1.L$5 = null;
        r1.label = 2;
        if (r30.h5(r14, r15, r7, r5, r1) != r3) goto L74;
        return r3;
    L67:
        r47 = null;
        goto L68
    L37:
        r110 = null;
    L34:
        r19 = null;
        goto L35
    L72:
        FLogger.a.e("MultiAttachmentSelector", "explainResourceUrl failed");
        r1.L$0 = null;
        r1.L$1 = null;
        r1.L$2 = null;
        r1.L$3 = null;
        r1.L$4 = null;
        r1.L$5 = null;
        r1.label = 3;
        if (r30.h5(r14, r15, r7, r5, r1) != r3) goto L74;
        return r3;
    L18:
        ResultKt.throwOnFailure(r0);
        IBachDetectCenterAbility.Companion r48 = IBachDetectCenterAbility.a;
        if (r48.b() == false) goto L23;
        Uri r49 = com.larus.utils.y0.j(r32);
        if (r49 == null) goto L23;
        r48.a(r49);
    L23:
        List r50 = CollectionsKt.listOf(r32);
        r1.L$0 = r31;
        r1.L$1 = r32;
        r15 = r33;
        r1.L$2 = r15;
        r1.L$3 = r34;
        r1.L$4 = r35;
        r1.L$5 = r36;
        r1.Z$0 = r37;
        r1.Z$1 = r38;
        r1.label = 1;
        r0 = com.larus.uaigc.api.o.a(r50, false, r1);
        if (r0 == r3) goto L76;
        r16 = r32;
        r21 = r34;
        r22 = r35;
        r20 = r36;
        r7 = r37;
        r14 = r31;
        r5 = r38;
        goto L27
    L76:
        return r3;
    L7:
        r1 = new MultiAttachmentSelectorComponent$explainResourceUrl$1(r30, r39);
        goto L8
    }

    public static ry9.j.c H3(MultiAttachmentSelectorComponent r25, String r26, String r27, String r28, String r29, String r30, String r31, long r32, long r34, boolean r36, int r37) {
        long r3 = 0;
        if ((r37 & 64) == 0) goto L5;
        long r5 = 0;
    L7:
        if ((r37 & 128) != 0) goto L10;
        r3 = r34;
    L10:
        boolean r2 = false;
        if ((r37 & 256) == 0) goto L13;
        boolean r1 = false;
    L14:
        ny9.s r7 = r25.W3();
        if (r7 == null) goto L22;
        Bundle r8 = r7.a;
        if (r8 == null) goto L19;
        boolean r9 = r8.getBoolean("is_prefilled_image", false);
    L20:
        if (r9 != true) goto L22;
        boolean r10 = true;
    L24:
        if (r10 == true) goto L26;
        return null;
    L26:
        if (r25.s == false) goto L78;
        ResourceItemBean r0 = r25.y.get(r26);
        if (r0 == null) goto L34;
        Image r11 = r0.getImage();
        if (r11 == null) goto L34;
        ImageObj r12 = r11.imageOri;
        if (r12 == null) goto L34;
    L40:
        if (r31.length() != 0) goto L42;
        boolean r13 = true;
    L43:
        if (r13 == false) goto L52;
        if (r0 == null) goto L48;
        Image r4 = r0.getImage();
        if (r4 == null) goto L48;
        String r6 = r4.localResPath;
    L49:
        if (r6 != null) goto L51;
        r6 = "";
    L51:
        String r15 = r6;
    L53:
        if (r28 != null) goto L55;
    L58:
        boolean r14 = true;
    L59:
        if (r14 == false) goto L69;
        if (r15.length() != 0) goto L63;
        r2 = true;
    L63:
        if (r2 == false) goto L69;
        if (r1 == true) goto L66;
        return null;
    L66:
        if (StringsKt.isBlank(r27) == false) goto L69;
        return null;
    L69:
        if (r12 == null) goto L71;
        r5 = r12.width;
    L71:
        Long r16 = Long.valueOf(r5);
        if (r12 == null) goto L75;
        r3 = r12.height;
    L75:
        return new ry9.j.c(new ry9.i.a(new MediaAttachment(r27, r28, new ImageUploadInfo(r16, Long.valueOf(r3)), null, r15, r29, r30, null, null, null, null, null, 3976, null), null));
    L55:
        if (r28.length() == 0) goto L58;
        r14 = false;
    L48:
        r6 = null;
        goto L49
    L52:
        r15 = r31;
        goto L53
    L42:
        r13 = false;
    L34:
        if (r0 == null) goto L38;
        Image r17 = r0.getImage();
        if (r17 == null) goto L38;
        r12 = r17.imageThumb;
    L38:
        r12 = null;
        goto L40
    L78:
        return null;
    L19:
        r9 = false;
    L22:
        r10 = false;
        goto L24
    L13:
        r1 = r36;
        goto L14
    L5:
        r5 = r32;
        goto L7
    }

    public static final Object Y2(final MultiAttachmentSelectorComponent r31, final com.larus.bmhome.resource.access.b0 r32, final String r33, String r34, String r35, String r36, String r37, String r38, final boolean r39, final boolean r40, Continuation r41) {
        r31.getClass();
        if ((r41 instanceof MultiAttachmentSelectorComponent$observeRemoteResourceAccessTask$1) == false) goto L7;
        MultiAttachmentSelectorComponent$observeRemoteResourceAccessTask$1 r1 = (MultiAttachmentSelectorComponent$observeRemoteResourceAccessTask$1) r41;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        MultiAttachmentSelectorComponent$observeRemoteResourceAccessTask$1 r13 = r1;
        Object r0 = r13.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r13.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        boolean r4 = r13.Z$1;
        boolean r5 = r13.Z$0;
        String r6 = (String) r13.L$5;
        String r7 = (String) r13.L$4;
        String r8 = (String) r13.L$3;
        String r9 = (String) r13.L$2;
        String r10 = (String) r13.L$1;
        String r11 = (String) r13.L$0;
        ResultKt.throwOnFailure(r0);
        String r24 = r6;
        String r22 = r9;
        String r17 = r10;
    L18:
        com.larus.bmhome.resource.access.a0.d r12 = (com.larus.bmhome.resource.access.a0) r0;
        if ((r12 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L113;
        com.larus.bmhome.resource.access.a0.d r15 = r12;
        com.larus.bmhome.resource.access.f0 r16 = r15.a;
        mr9.l r18 = r16.e;
        if (r18 != null) goto L23;
        r18 = new mr9.l(r16.c, null, r16.d, null, null, false, null, 122);
    L23:
        String r19 = r18.a;
        boolean r20 = false;
        if (r19 != null) goto L26;
    L29:
        boolean r21 = true;
    L30:
        if (r21 == false) goto L40;
        String r23 = r18.c;
        if (r23 != null) goto L34;
    L37:
        boolean r25 = true;
    L38:
        if (r25 == false) goto L40;
        r31.l4(r11, "empty_upload_result", "upload result is null", r5, r4);
    L131:
        return Unit.INSTANCE;
    L34:
        if (r23.length() == 0) goto L37;
        r25 = false;
    L40:
        ResourceUploadInstantInfo r26 = r18.g;
        if (r26 == null) goto L45;
        zd9.h.a.getClass();
        String r27 = zd9.h.c(r26);
        if (r27 == null) goto L45;
        r31.z.put(r11, r27);
    L45:
        tx9.l0.b("creation_page_passed_image_re_upload", r11, true, null, null, null, 56);
        ResourceItemBean r28 = r31.y.get(r11);
        if (r28 == null) goto L51;
        Image r29 = r28.getImage();
        if (r29 == null) goto L51;
        ImageObj r30 = r29.imageOri;
        if (r30 == null) goto L51;
    L57:
        com.larus.bmhome.resource.access.j0.b r110 = r15.a.b;
        if ((r110 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L60;
        com.larus.bmhome.resource.access.j0.b r111 = r110;
    L61:
        if (r111 == null) goto L63;
        String r112 = r111.b;
    L64:
        if (r112 != null) goto L67;
        r112 = "";
    L67:
        if ((!StringsKt.isBlank(r7)) == true) goto L69;
    L71:
        if (r20 == true) goto L74;
        r7 = null;
    L74:
        if (r7 == null) goto L77;
        r112 = r7;
    L77:
        r31.i5(r11, r112);
        mr9.d r42 = r18.d;
        if (r42 == null) goto L80;
        long r113 = r42.b;
    L92:
        mr9.d r43 = r18.d;
        if (r43 == null) goto L95;
        long r44 = r43.a;
    L107:
        String r114 = r18.a;
        ImageUploadInfo r115 = new ImageUploadInfo(Long.valueOf(r113), Long.valueOf(r44));
        String r45 = r18.c;
        if (r45 != null) goto L110;
        String r210 = r8;
    L111:
        r31.e4(r11).setValue(new ry9.k(r11, new ry9.j.c(new ry9.i.a(new MediaAttachment(r17, r114, r115, null, r112, r22, r210, r24, null, null, null, null, 3848, null), null)), 0, r5, r4, false, 36));
        r31.T4(true, null, "pic");
        nz9.b.e("creation_page/re_upload", "0", r11);
        r31.o5(r11);
        goto L131
    L110:
        r210 = r45;
        goto L111
    L95:
        String r46 = (String) r15.a.f.get("height");
        if (r46 == null) goto L98;
        Long r47 = StringsKt.toLongOrNull(r46);
    L99:
        if (r47 != null) goto L105;
        if (r30 == null) goto L103;
        r47 = Long.valueOf(r30.height);
    L104:
        if (r47 != null) goto L105;
        r44 = 0;
        goto L107
    L103:
        r47 = null;
    L105:
        r44 = r47.longValue();
        goto L107
    L98:
        r47 = null;
        goto L99
    L80:
        String r48 = (String) r15.a.f.get("width");
        if (r48 == null) goto L83;
        Long r49 = StringsKt.toLongOrNull(r48);
    L84:
        if (r49 != null) goto L90;
        if (r30 == null) goto L88;
        r49 = Long.valueOf(r30.width);
    L89:
        if (r49 != null) goto L90;
        r113 = 0;
        goto L92
    L88:
        r49 = null;
    L90:
        r113 = r49.longValue();
        goto L92
    L83:
        r49 = null;
        goto L84
    L69:
        if (new PolarisFileWrapper(r7).exists() == false) goto L71;
        r20 = true;
        goto L71
    L63:
        r112 = null;
        goto L64
    L60:
        r111 = null;
    L51:
        ResourceItemBean r50 = r31.y.get(r11);
        if (r50 == null) goto L56;
        Image r51 = r50.getImage();
        if (r51 == null) goto L56;
        r30 = r51.imageThumb;
    L56:
        r30 = null;
        goto L57
    L26:
        if (r19.length() == 0) goto L29;
        r21 = false;
        goto L30
    L113:
        if ((r12 instanceof com.larus.bmhome.resource.access.a0.c) == false) goto L116;
        com.larus.bmhome.resource.access.r r52 = ((com.larus.bmhome.resource.access.a0.c) r12).a;
        r31.l4(r11, r52.b, r52.c, r5, r4);
        goto L131
    L116:
        if ((r12 instanceof com.larus.bmhome.resource.access.a0.a) == false) goto L122;
        if (ICreationResourceAccessServiceKt.d(r12) == false) goto L120;
        FLogger.a.i("MultiAttachmentSelector", "[observeRemoteResourceAccessTask] page destroy cancel");
        goto L131
    L120:
        ResourceUploadError r53 = ICreationResourceAccessServiceKt.g(r12);
        r31.l4(r11, r53.getCode(), r53.getMsg(), r5, r4);
        goto L131
    L122:
        if (Intrinsics.areEqual(r12, com.larus.bmhome.resource.access.a0.b.a) == true) goto L131;
        if ((r12 instanceof com.larus.bmhome.resource.access.a0.e) == true) goto L131;
        if ((r12 instanceof com.larus.bmhome.resource.access.a0.f) == true) goto L131;
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        Function1 r116 = new q2(r31, r33, r32, r39, r40);
        Function1 r117 = new s2(r32, r31, r33, r39, r40);
        r13.L$0 = r33;
        r13.L$1 = r34;
        r13.L$2 = r35;
        r13.L$3 = r36;
        r7 = r37;
        r13.L$4 = r7;
        r13.L$5 = r38;
        r13.Z$0 = r39;
        r13.Z$1 = r40;
        r13.label = 1;
        Object r54 = CreationResourceAccessPerfBridgeKt.a(r32, "creation_page/re_upload", r33, r33, r116, r117, r13);
        if (r54 == r14) goto L132;
        r11 = r33;
        r17 = r34;
        r22 = r35;
        r24 = r38;
        r0 = r54;
        r5 = r39;
        r4 = r40;
        r8 = r36;
        goto L18
    L132:
        return r14;
    L7:
        r1 = new MultiAttachmentSelectorComponent$observeRemoteResourceAccessTask$1(r31, r41);
        goto L8
    }

    public final Object I5(String r30, String r31, String r32, String r33, ic8.m0 r34, Pair<Integer, Integer> r35, String r36, com.larus.bmhome.resource.access.b0 r37, Function1<? super ResourceUploadError, Unit> r38, Function1<? super mr9.l, Unit> r39, Function1<? super mr9.k, Unit> r40, Continuation<? super Unit> r41) {
        Function1<? super mr9.l, Unit> r9 = r39;
        Function1<? super mr9.k, Unit> r10 = r40;
        if ((r41 instanceof MultiAttachmentSelectorComponent$submitImageResourceAccess$1) == false) goto L7;
        MultiAttachmentSelectorComponent$submitImageResourceAccess$1 r1 = (MultiAttachmentSelectorComponent$submitImageResourceAccess$1) r41;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        MultiAttachmentSelectorComponent$submitImageResourceAccess$1 r11 = r1;
        Object r0 = r11.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r11.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        Function1<? super mr9.k, Unit> r4 = (Function1) r11.L$7;
        Function1<? super mr9.l, Unit> r5 = (Function1) r11.L$6;
        Function1<? super ResourceUploadError, Unit> r6 = (Function1) r11.L$5;
        Pair<Integer, Integer> r7 = (Pair) r11.L$4;
        ic8.m0 r8 = (ic8.m0) r11.L$3;
        String r13 = (String) r11.L$2;
        String r14 = (String) r11.L$1;
        String r15 = (String) r11.L$0;
        ResultKt.throwOnFailure(r0);
        Function1<? super mr9.k, Unit> r22 = r4;
        Function1<? super mr9.l, Unit> r23 = r5;
        Function1<? super ResourceUploadError, Unit> r24 = r6;
        ic8.m0 r16 = r8;
        String r17 = r13;
        String r18 = r14;
        String r19 = r15;
    L36:
        String r310 = r18;
        String r311 = r17;
        mr9.h r110 = D3(r310, r311, ((CreationRemoteConversationHelper.a) r0).a, r19, r16, r7);
        ICreationResourceAccessService.Companion r20 = ICreationResourceAccessService.a;
        int r21 = com.larus.uaigc.service.p0.x;
        r20.b(com.larus.uaigc.service.p0.a.c(r19, r18, r16, r110, true, new CountDownLatch(1), null, null, null, r22, r23, r24, null, null, LifecycleOwnerKt.getLifecycleScope(this), 1033992));
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r0);
    L31:
        return Unit.INSTANCE;
    L17:
        Function1<? super mr9.k, Unit> r25 = (Function1) r11.L$4;
        Function1<? super mr9.l, Unit> r26 = (Function1) r11.L$3;
        Function1<? super ResourceUploadError, Unit> r27 = (Function1) r11.L$2;
        String r28 = (String) r11.L$1;
        String r29 = (String) r11.L$0;
        ResultKt.throwOnFailure(r0);
        r10 = r25;
        r9 = r26;
    L25:
        com.larus.bmhome.resource.access.b0 r42 = (com.larus.bmhome.resource.access.b0) r0;
    L27:
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.L$3 = null;
        r11.L$4 = null;
        r11.label = 2;
        if (W4(r42, r29, r28, r27, r9, r10, r11) != r12) goto L31;
        return r12;
    L18:
        ResultKt.throwOnFailure(r0);
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L32;
        if (r37 != null) goto L26;
        r11.L$0 = r31;
        r11.L$1 = r36;
        r11.L$2 = r38;
        r11.L$3 = r9;
        r11.L$4 = r10;
        r11.label = 1;
        r0 = R5(r30, r32, r33, r34, r35, r11);
        if (r0 != r12) goto L24;
        return r12;
    L24:
        r27 = r38;
        r29 = r31;
        r28 = r36;
        goto L25
    L26:
        r42 = r37;
        r27 = r38;
        r29 = r31;
        r28 = r36;
        goto L27
    L32:
        r11.L$0 = r30;
        r11.L$1 = r32;
        r17 = r33;
        r11.L$2 = r17;
        r11.L$3 = r34;
        r11.L$4 = r35;
        r11.L$5 = r38;
        r11.L$6 = r9;
        r11.L$7 = r10;
        r11.label = 3;
        Object r43 = s5(r11);
        if (r43 != r12) goto L35;
        return r12;
    L35:
        r19 = r30;
        r18 = r32;
        r0 = r43;
        r16 = r34;
        r7 = r35;
        r24 = r38;
        r23 = r9;
        r22 = r10;
    L7:
        r1 = new MultiAttachmentSelectorComponent$submitImageResourceAccess$1(this, r41);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object Q5(MultiAttachmentSelectorComponent r16, String r17, String r18, String r19, String r20, ic8.m0 r21, Pair r22, String r23, com.larus.bmhome.resource.access.b0 r24, Function1 r25, Function1 r26, Function1 r27, Continuation r28, int r29) {
        if ((r29 & 16) == 0) goto L5;
        ic8.m0 r8 = null;
    L7:
        if ((r29 & 32) == 0) goto L9;
        Pair r9 = null;
    L11:
        if ((r29 & 64) == 0) goto L13;
        String r10 = "creation_page/album_upload";
    L15:
        if ((r29 & 128) == 0) goto L17;
        com.larus.bmhome.resource.access.b0 r11 = null;
    L19:
        return r16.I5(r17, r18, r19, r20, r8, r9, r10, r11, r25, r26, r27, r28);
    L17:
        r11 = r24;
        goto L19
    L13:
        r10 = r23;
        goto L15
    L9:
        r9 = r22;
        goto L11
    L5:
        r8 = r21;
        goto L7
    }
}
