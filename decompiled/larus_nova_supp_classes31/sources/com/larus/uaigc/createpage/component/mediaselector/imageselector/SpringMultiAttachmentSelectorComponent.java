package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.net.Uri;
import android.os.Bundle;
import android.util.LruCache;
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
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.picture.LocalTakePictureImpl;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.bmhome.view.resourcebar.bean.ItemStatus;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.AlbumHelper;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u009e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ¾\u00012\u00020\u00012\u00020\u0002:\u0002¾\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010[\u001a\u000200H\u0016J:\u0010\\\u001a\u0002002\u0006\u0010H\u001a\u00020I2\u0006\u0010]\u001a\u00020G2\u0006\u0010^\u001a\u00020I2\u0006\u0010_\u001a\u00020G2\u0006\u0010`\u001a\u00020I2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\"\u0010c\u001a\u0002002\b\u0010d\u001a\u0004\u0018\u00010!2\u0006\u0010L\u001a\u00020I2\u0006\u0010]\u001a\u00020GH\u0016J(\u0010e\u001a\u0002002\b\u0010T\u001a\u0004\u0018\u00010!2\u0006\u0010]\u001a\u00020G2\f\u0010f\u001a\b\u0012\u0004\u0012\u0002000SH\u0016J\u0010\u0010g\u001a\u0002002\u0006\u0010H\u001a\u00020IH\u0016J\b\u0010h\u001a\u000200H\u0016J\b\u0010i\u001a\u00020IH\u0002J\b\u0010j\u001a\u000200H\u0002J\u0018\u0010k\u001a\u0002002\u0006\u00106\u001a\u00020!2\u0006\u0010l\u001a\u00020!H\u0002J\u0016\u0010m\u001a\u0002002\u0006\u0010n\u001a\u00020,H\u0082@¢\u0006\u0002\u0010oJ\u0018\u0010p\u001a\u0002002\u0006\u00106\u001a\u00020!2\u0006\u0010q\u001a\u00020rH\u0002J\u001a\u0010s\u001a\u0002002\u0006\u0010t\u001a\u00020G2\b\u0010u\u001a\u0004\u0018\u00010!H\u0002J\n\u0010v\u001a\u0004\u0018\u00010!H\u0002J\b\u0010w\u001a\u00020GH\u0002J(\u0010x\u001a\u0002002\u0006\u0010y\u001a\u00020!2\u0006\u0010q\u001a\u00020z2\u0006\u0010l\u001a\u00020!2\u0006\u00106\u001a\u00020!H\u0002J\u0010\u0010{\u001a\u0002002\u0006\u00106\u001a\u00020!H\u0002J\u0018\u0010|\u001a\u0002002\u0006\u0010}\u001a\u00020~2\u0006\u00106\u001a\u00020!H\u0002Jf\u0010\u007f\u001a\u0002002\u0006\u0010l\u001a\u00020!2\u0006\u00106\u001a\u00020!2\u0006\u0010y\u001a\u00020!2\u0013\u0010\u0080\u0001\u001a\u000e\u0012\u0004\u0012\u00020~\u0012\u0004\u0012\u0002000+2\u0013\u0010\u0081\u0001\u001a\u000e\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u0002000+2\u0013\u0010\u0082\u0001\u001a\u000e\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u0002000+H\u0082@¢\u0006\u0003\u0010\u0083\u0001J\u0013\u0010\u0084\u0001\u001a\u00020,2\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0002J\u0013\u0010\u0087\u0001\u001a\u0002002\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0002J\u001b\u0010\u008a\u0001\u001a\u00030\u0089\u00012\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0082@¢\u0006\u0003\u0010\u008d\u0001J\t\u0010\u008e\u0001\u001a\u000200H\u0016J$\u0010\u008f\u0001\u001a\u0002002\u0006\u00106\u001a\u00020!2\u0006\u0010l\u001a\u00020!2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010!H\u0016J\u0019\u0010\u0091\u0001\u001a\u0002002\u0006\u00106\u001a\u00020!2\u0006\u0010l\u001a\u00020!H\u0016J\u001a\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u000e\u0010\u0094\u0001\u001a\t\u0012\u0004\u0012\u0002030\u0095\u0001H\u0016J\u001b\u0010\u0096\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020#0&0?H\u0016J\u0013\u0010\u0097\u0001\u001a\u0004\u0018\u00010#2\u0006\u00106\u001a\u00020!H\u0016J\u0012\u0010\u0098\u0001\u001a\u0002002\u0007\u0010\u0099\u0001\u001a\u00020<H\u0016JR\u0010\u009a\u0001\u001a\u0002002\u0006\u00106\u001a\u00020!2\u0007\u0010\u009b\u0001\u001a\u00020!2\u0007\u0010\u009c\u0001\u001a\u00020!2\u0007\u0010\u009d\u0001\u001a\u00020!2\u0007\u0010\u009e\u0001\u001a\u00020!2\u0007\u0010\u009f\u0001\u001a\u00020G2\u0007\u0010 \u0001\u001a\u00020G2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010!H\u0016J\t\u0010¡\u0001\u001a\u00020GH\u0016J\t\u0010¢\u0001\u001a\u00020GH\u0016J\t\u0010£\u0001\u001a\u00020GH\u0016J.\u0010¤\u0001\u001a\u0002002#\u0010¥\u0001\u001a\u001e\u0012\u0014\u0012\u00120,¢\u0006\r\b-\u0012\t\b.\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u0002000+H\u0016J,\u0010¦\u0001\u001a\u0002002!\u0010f\u001a\u001d\u0012\u0013\u0012\u001103¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(4\u0012\u0004\u0012\u0002000+H\u0016J,\u0010§\u0001\u001a\u0002002!\u0010f\u001a\u001d\u0012\u0013\u0012\u00110!¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(6\u0012\u0004\u0012\u0002000+H\u0016J\u001d\u0010¨\u0001\u001a\u0002002\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010!2\u0007\u0010 \u0001\u001a\u00020GH\u0016J\u000b\u0010©\u0001\u001a\u0004\u0018\u00010!H\u0016J\u0011\u0010ª\u0001\u001a\u0002002\u0006\u00106\u001a\u00020!H\u0016J\t\u0010«\u0001\u001a\u000200H\u0016J\t\u0010¬\u0001\u001a\u000200H\u0016J\u0012\u0010\u00ad\u0001\u001a\u0002002\u0007\u0010®\u0001\u001a\u000203H\u0016J\u0019\u0010¯\u0001\u001a\u0002002\u0007\u0010®\u0001\u001a\u000203H\u0096@¢\u0006\u0003\u0010°\u0001J$\u0010±\u0001\u001a\u0002002\u0006\u00106\u001a\u00020!2\b\u0010²\u0001\u001a\u00030³\u00012\u0007\u0010\u009f\u0001\u001a\u00020GH\u0016J%\u0010´\u0001\u001a\u0002002\u0006\u00106\u001a\u00020!2\u0006\u0010l\u001a\u00020!2\n\u0010µ\u0001\u001a\u0005\u0018\u00010¶\u0001H\u0016J\u0019\u0010·\u0001\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u0006\u00106\u001a\u00020!H\u0002J\u0017\u0010¸\u0001\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u00106\u001a\u00020!H\u0002J\u0011\u0010¹\u0001\u001a\u0002002\u0006\u00106\u001a\u00020!H\u0002J!\u0010º\u0001\u001a\u0002002\u0007\u0010»\u0001\u001a\u00020!2\r\u0010¼\u0001\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\u0011\u0010½\u0001\u001a\u0002002\u0006\u00106\u001a\u00020!H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR \u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0 X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020#0&0%X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010'\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0(X\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010*\u001a%\u0012\u0013\u0012\u00110,¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u00010+j\u0004\u0018\u0001`1X\u0082\u000e¢\u0006\u0002\n\u0000R+\u00102\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(4\u0012\u0004\u0012\u000200\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R+\u00105\u001a\u001f\u0012\u0013\u0012\u00110!¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(6\u0012\u0004\u0012\u000200\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u0002080(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010;\u001a\u0010\u0012\f\u0012\n =*\u0004\u0018\u00010<0<0\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020<0?8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u001c\u0010B\u001a\u0010\u0012\f\u0012\n =*\u0004\u0018\u00010C0C0\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020C0?8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010AR\u000e\u0010F\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020IX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010M\u001a\u00020N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\n\u001a\u0004\bO\u0010PR\u0016\u0010R\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010V\u001a\b\u0012\u0004\u0012\u00020#0W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\n\u001a\u0004\bX\u0010Y¨\u0006¿\u0001"}, d2 = {"Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/SpringMultiAttachmentSelectorComponent;", "Lcom/larus/ui/arch/component/external/api/Component;", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMultiAttachmentSelectorAbility;", "<init>", "()V", "hitPointData", "Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "getHitPointData", "()Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "hitPointData$delegate", "Lkotlin/Lazy;", "argumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "argumentData$delegate", "instructionEditAbility", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "getInstructionEditAbility", "()Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "instructionEditAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "templateFeedAbility", "Lcom/larus/uaigc/bean/createpage/component/templatefeed/ITemplateFeedAbility;", "getTemplateFeedAbility", "()Lcom/larus/uaigc/bean/createpage/component/templatefeed/ITemplateFeedAbility;", "templateFeedAbility$delegate", "attachmentLiveDataCacheMap", "Landroid/util/LruCache;", "", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/MultiMediaSelectorStatus;", "allAttachmentLiveDataStatus", "Landroidx/lifecycle/MediatorLiveData;", "", "attachmentLiveDataRegisterMap", "Ljava/util/concurrent/ConcurrentHashMap;", "attachmentIdentityRegisterMap", "onAlbumResultListener", "Lkotlin/Function1;", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/AlbumResourceConfig;", "Lkotlin/ParameterName;", "name", "config", "", "Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/OnAlbumResultListener;", "onUploadAvatarImageCallback", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "resourceItemBean", "onDeleteAvatarImageCallback", "resourceKey", "imageUploadJobRegistry", "Lkotlinx/coroutines/Job;", "takePictureHelper", "Lcom/larus/bmhome/chat/picture/LocalTakePictureImpl;", "_passedImageUrlListLiveData", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/PassedImageUrlListData;", "kotlin.jvm.PlatformType", "passedImageUrlListLiveData", "Landroidx/lifecycle/LiveData;", "getPassedImageUrlListLiveData", "()Landroidx/lifecycle/LiveData;", "_updateUIStatus", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationUpdateUIStatus;", "updateUIStatus", "getUpdateUIStatus", "enableAlbumMultiSelect", "", "maxSelectCount", "", "currentReplaceIndex", "albumPrompt", "configInstructionType", "frescoCloseableHolder", "Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/FrescoCloseableHolder;", "getFrescoCloseableHolder", "()Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/FrescoCloseableHolder;", "frescoCloseableHolder$delegate", "openAlbumCallback", "Lkotlin/Function0;", "clickFrom", "currentUploadedAvatarResourceKey", "creationUploadAndCheckObserver", "Landroidx/lifecycle/Observer;", "getCreationUploadAndCheckObserver", "()Landroidx/lifecycle/Observer;", "creationUploadAndCheckObserver$delegate", "onAttach", "openAlbum", "forceSingleSelect", "replaceIndex", "enableSeparateMediaSelection", "maxSelectVideoCount", "creationReferenceAttachmentSnapshot", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachmentSnapshot;", "openAlbumWithPrompt", "prompt", "handleAlbumOpenFromActionMenu", "callback", "setMaxAlbumSelectCount", "onCreate", "getRemainSelectCount", "initTakePictureHelper", "parseUriAndStartUpload", "localResPath", "onCompressUploadAndCheck", "resourceConfig", "(Lcom/larus/uaigc/bean/createpage/component/mediacontainer/AlbumResourceConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleUploadProcess", "result", "Lcom/larus/platform/model/upload/ResourceUploadProgressResult;", "mobUploadAttachmentStatus", "success", "errorMsg", "getCurrentPageName", "isHalfInstructionFragment", "handleUploadSuccess", "uploaderIdentifier", "Lcom/larus/platform/model/upload/ResourceUploadResult;", "requireSelectedImageUrlInBackground", "handleUploadFail", "error", "Lcom/larus/platform/model/upload/ResourceUploadError;", "imageXUpload", "onFailed", "onSuccess", "processCallback", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildResourceConfig", "multiConfig", "Lcom/larus/platform/AlbumMultiSelectItem;", "handleFailToast", "processResult", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "compressAlbumImg", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDestroy", "handleAttachmentRemove", "fromScene", "handleAttachmentRetry", "getCurrentNestedFileContent", "Lcom/larus/im/bean/message/NestedFileContent;", "resourceItemOrder", "", "getAllAttachmentLiveDataStatus", "getMultiMediaSelectorStatus", "clearAndSetPassedImageUrlList", "passedImageUrlListData", "triggerDownloadUrlAndExplain", "url", "identifier", "resourceId", "localFilePath", "isPrivate", "isAvatar", "isParsingAttachment", "hasVideoAttachment", "isParsingVideoAttachment", "registerOnAlbumResultListener", "onResult", "registerOnUploadAvatarImage", "registerOnDeleteAvatarImage", "triggerUploadAvatarImage", "getCurrentUploadedAvatarResourceKey", "triggerDeleteAvatarImage", "updateResourceBarUI", "deleteAttachmentsIfNeeds", "addResourceItemBean", "bean", "uploadResourceItemBean", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "triggerVideoDownloadAndExplain", SlashMentionConfig.MENTION_CONTENT_ATTACHMENT, "Lcom/larus/bmhome/actionbar/model/MediaAttachment;", "triggerUploadAndCheck", "fileInfo", "Lcom/larus/bmhome/chat/bean/ProcessFileInfo;", "getAttachmentLiveData", "getOrCreateAttachmentLiveData", "removeCreateAttachmentLiveData", "registerAttachmentLiveData", "key", "liveData", "unRegisterAttachmentLiveData", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SpringMultiAttachmentSelectorComponent extends Component implements ry9.h {
    public static final /* synthetic */ int L = 0;
    public final MutableLiveData<ry9.f> A;
    public final boolean B;
    public int C;
    public int D;
    public String E;
    public int F;
    public final Lazy G;
    public Function0<Unit> H;
    public String I;
    public String J;
    public final Lazy K;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final LruCache<String, MutableLiveData<ry9.k>> q;
    public final MediatorLiveData<Map<String, ry9.k>> r;
    public final ConcurrentHashMap<String, MutableLiveData<ry9.k>> s;
    public final ConcurrentHashMap<String, String> t;
    public Function1<? super ry9.a, Unit> u;
    public Function1<? super ResourceItemBean, Unit> v;
    public Function1<? super String, Unit> w;
    public final ConcurrentHashMap<String, Job> x;
    public final LocalTakePictureImpl y;
    public final MutableLiveData<ry9.l> z;

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

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(j4 r2) {
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

    @Override // ry9.h
    public final void C2(String r1) {
    }

    @Override // ry9.h
    public final String J6() {
        return null;
    }

    @Override // ry9.h
    public final void Ke(String r1, MediaAttachment r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "resourceKey");
        Intrinsics.checkNotNullParameter(r2, SlashMentionConfig.MENTION_CONTENT_ATTACHMENT);
    }

    @Override // ry9.h
    public final void N6() {
    }

    @Override // ry9.h
    public final void Nn() {
    }

    @Override // ry9.h
    public final boolean SM() {
        return false;
    }

    @Override // ry9.h
    public final boolean Wb() {
        return false;
    }

    @Override // ry9.h
    public final void ew(ResourceItemBean r2) {
        Intrinsics.checkNotNullParameter(r2, "bean");
    }

    @Override // ry9.h
    public final void vB() {
    }

    public final ny9.u U2() {
        return (ny9.u) this.l.getValue();
    }

    public final int Y2() {
        ConcurrentHashMap<String, MutableLiveData<ry9.k>> r0 = this.s;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<String, MutableLiveData<ry9.k>>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Map.Entry<String, MutableLiveData<ry9.k>> r3 = r2.next();
        if ((!Intrinsics.areEqual(r3.getKey(), this.J)) == false) goto L4;
        r1.put(r3.getKey(), r3.getValue());
        goto L4
    L9:
        return RangesKt.coerceAtLeast(this.C - r1.size(), 0);
    }

    @Override // ry9.h
    public final boolean jb() {
        Map r0 = (Map) this.r.getValue();
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
        if (this.B == false) goto L5;
        LocalTakePictureImpl r0 = this.y;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r6 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        Function1<? super xp9.i, Unit> r7 = new a4(this);
        int r8 = LocalTakePictureImpl.h;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "fragment");
        Intrinsics.checkNotNullParameter("local_take_picture", "resultScene");
        Intrinsics.checkNotNullParameter(r7, "onSuccess");
        ((AlbumHelper) r0.f.getValue()).e(r6, "local_take_picture", r7);
    L5:
        LocalTakePictureImpl r1 = this.y;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r5 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        Function1<? super AlbumSelectItem, Unit> r9 = new i4(this);
        int r10 = LocalTakePictureImpl.h;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter("local_take_picture", "resultScene");
        Intrinsics.checkNotNullParameter(r9, "onSuccess");
        ((AlbumHelper) r1.f.getValue()).b(r5, "local_take_picture", r9);
    }

    public final void onDestroy() {
        ((com.larus.uaigc.createpage.component.mediaselector.imageselector.c) this.G.getValue()).b();
        Iterator<Map.Entry<String, String>> r0 = this.t.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ResourceUploader.c(r0.next().getValue());
        goto L4
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, ry9.h.class);
    }

    public SpringMultiAttachmentSelectorComponent() {
        this.l = LazyKt.lazy(new m4(this));
        this.m = LazyKt.lazy(new n4(this));
        this.n = LazyKt.lazy(new o4(this));
        this.o = LazyKt.lazy(new p4(this));
        this.p = LazyKt.lazy(new q4(this));
        this.q = new LruCache(10);
        this.r = new MediatorLiveData(MapsKt.emptyMap());
        this.s = new ConcurrentHashMap();
        this.t = new ConcurrentHashMap();
        this.x = new ConcurrentHashMap();
        this.y = new LocalTakePictureImpl();
        this.z = new MutableLiveData(new ry9.l(true, 6));
        this.A = new MutableLiveData(new ry9.f(null, 0, null, null, 15));
        this.B = com.larus.platform.service.z2.a.enableCreationMixSkillAlbumMultiSelect();
        this.D = -1;
        this.F = -1;
        this.G = LazyKt.lazy(new b4());
        this.K = LazyKt.lazy(new c4(this));
    }

    @Override // ry9.h
    public final List<MediaAttachment> DX() {
        return CollectionsKt.emptyList();
    }

    @Override // ry9.h
    public final MutableLiveData BV() {
        return this.A;
    }

    @Override // ry9.h
    public final MutableLiveData Bw() {
        return this.z;
    }

    @Override // ry9.h
    public final LiveData<Map<String, ry9.k>> ja() {
        return this.r;
    }

    @Override // ry9.h
    public final String yC() {
        return this.J;
    }

    public static final ICoreInputAbility L2(SpringMultiAttachmentSelectorComponent r0) {
        return (ICoreInputAbility) r0.o.getValue();
    }

    @Override // ry9.h
    public final void IR(com.larus.uaigc.instruction.z r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.v = r2;
    }

    @Override // ry9.h
    public final void JZ(String r50) {
        DigitalAvatarInfoManager.a.getClass();
        if (DigitalAvatarInfoManager.i() == false) goto L6;
        String r0 = ContextCompat.getString(getContext(), 2131908806);
    L9:
        Intrinsics.checkNotNull(r0);
        String r2 = UUID.randomUUID().toString();
        HashMap r3 = new HashMap();
        r3.put("ext_show_re_select_layout", Boolean.FALSE);
        r3.put("ext_avatar_subscript_desc", r0);
        ItemStatus r19 = ItemStatus.UPLINKING;
        ResourceType r21 = ResourceType.AVATAR;
        ResourceItemBean r1 = new ResourceItemBean(r2, null, null, null, new Image(UUID.randomUUID().toString(), null, new ImageObj(r50, 0, 0, null, null, 30, null), null, null, null, null, null, null, null, null, null, null, null, 16378, null), null, 0, r19, false, r21, i5.w0(), 0, 0, 0, false, false, false, false, 0, r3, 522542, null);
        this.J = r2;
        Function1<? super ResourceItemBean, Unit> r4 = this.v;
        if (r4 == null) goto L12;
        r4.invoke(r1);
    L12:
        if (r50 != null) goto L14;
        String r5 = "";
    L15:
        ry9.h.a.b(this, r2, r5, "", "", "", false, true, null, 128);
        return;
    L14:
        r5 = r50;
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
        this.C = r1;
    }

    @Override // ry9.h
    public final void OI(com.larus.uaigc.instruction.a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "onResult");
        this.u = r2;
    }

    @Override // ry9.h
    public final ry9.k Q00(String r2) {
        Intrinsics.checkNotNullParameter(r2, "resourceKey");
        Map r0 = (Map) this.r.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (ry9.k) r0.get(r2);
    }

    @Override // ry9.h
    public final void QA(ry9.l r8) {
        Intrinsics.checkNotNullParameter(r8, "passedImageUrlListData");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SpringMultiAttachmentSelectorComponent$clearAndSetPassedImageUrlList$1(this, r8, null), 3, null);
    }

    @Override // ry9.h
    public final NestedFileContent V20(List<ResourceItemBean> r40) {
        Intrinsics.checkNotNullParameter(r40, "resourceItemOrder");
        ArrayList r2 = new ArrayList();
        Iterator r0 = r40.iterator();
    L4:
        if (r0.hasNext() == false) goto L163;
        ResourceItemBean r1 = (ResourceItemBean) r0.next();
        MutableLiveData<ry9.k> r3 = this.q.get(r1.getKey());
        if (r3 == null) goto L4;
        ry9.k r4 = (ry9.k) r3.getValue();
        if (r4 == null) goto L4;
        ry9.j r5 = r4.b;
        if ((r5 instanceof ry9.j.h) == true) goto L23;
        if ((r5 instanceof ry9.j.a) == true) goto L23;
        if ((r5 instanceof ry9.j.g) == true) goto L23;
        if ((r5 instanceof ry9.j.c) == false) goto L22;
        ry9.i r6 = ((ry9.j.c) r5).b;
        if (r6 == null) goto L22;
        if ((r6 instanceof ry9.i.a) == true) goto L23;
    L22:
        FLogger.a.e("MultiAttachmentSelector", "[getCurrentNestedFileContent] error status");
    L23:
        ry9.i r7 = r5.a();
        if ((r7 instanceof ry9.i.a) == false) goto L26;
        ry9.i.a r8 = (ry9.i.a) r7;
    L27:
        if (r8 != null) goto L42;
        Image r9 = r1.getImage();
        if (r9 != null) goto L31;
    L41:
        r8 = null;
        goto L42
    L31:
        if (r9.localResPath == null) goto L41;
        Image r10 = r1.getImage();
        if (r10 == null) goto L35;
        String r14 = r10.localResPath;
    L36:
        Image r11 = r1.getImage();
        if (r11 == null) goto L39;
        String r15 = r11.md5;
    L40:
        r8 = new ry9.i.a(new MediaAttachment(null, null, null, null, r14, r15, null, null, null, null, null, null, 4047, null), null);
        goto L42
    L39:
        r15 = null;
        goto L40
    L35:
        r14 = null;
    L42:
        if (r8 == null) goto L46;
        MediaAttachment r12 = r8.a;
        if (r12 == null) goto L46;
        String r13 = r12.getUri();
    L47:
        if (r8 == null) goto L51;
        MediaAttachment r16 = r8.a;
        if (r16 == null) goto L51;
        String r17 = r16.getLocalFilePath();
    L52:
        if (r8 == null) goto L56;
        MediaAttachment r18 = r8.a;
        if (r18 == null) goto L56;
        String r19 = r18.getIdentifier();
    L57:
        if (r8 == null) goto L61;
        MediaAttachment r20 = r8.a;
        if (r20 == null) goto L61;
        String r21 = r20.getResourceId();
    L62:
        boolean r26 = false;
        if (r17 != null) goto L65;
    L68:
        boolean r110 = true;
    L69:
        long r111 = 0;
        int r27 = 100;
        if (r110 == true) goto L116;
        if (new PolarisFileWrapper(r17).exists() == false) goto L116;
        ImFileUtil r112 = ImFileUtil.a;
        PolarisFileWrapper r113 = new PolarisFileWrapper(r17);
        r112.getClass();
        String r114 = ImFileUtil.g(r113);
        if (r21 != null) goto L76;
    L79:
        boolean r115 = true;
    L80:
        if (r115 == false) goto L82;
        String r116 = null;
    L83:
        String r29 = r8.a.getUrl();
        ImageUploadInfo r22 = r8.a.getImageUploadInfo();
        if (r22 == null) goto L88;
        Long r23 = r22.getWidth();
        if (r23 == null) goto L88;
        long r24 = r23.longValue();
    L89:
        int r117 = (int) r24;
        ImageUploadInfo r25 = r8.a.getImageUploadInfo();
        if (r25 == null) goto L94;
        Long r28 = r25.getHeight();
        if (r28 == null) goto L94;
        r111 = r28.longValue();
    L94:
        UplinkEntityContent r118 = new UplinkEntityContent(null, new Image(r13, r114, null, new ImageObj(r29, r117, (int) r111, null, null, 24, null), r116, r17, r19, null, null, null, null, null, null, null, 16260, null), 1, null);
        Integer r119 = Integer.valueOf(UplinkEntityType.EntityTypeImage.getValue());
        Integer r120 = Integer.valueOf(FileReviewState.PROCESSING.getValue());
        if ((r5 instanceof ry9.j.a) == false) goto L97;
        FileParseState r30 = FileParseState.PROCESSING;
    L98:
        Integer r31 = Integer.valueOf(r30.getValue());
        if (r13 != null) goto L101;
    L104:
        boolean r32 = true;
    L105:
        if (r32 == false) goto L107;
        r27 = 0;
    L107:
        Integer r121 = Integer.valueOf(r27);
        if (r13 != null) goto L110;
    L111:
        r26 = true;
    L112:
        if (r26 == false) goto L114;
        UpLinkState r33 = UpLinkState.PROCESSING;
    L115:
        r2.add(new UplinkFileEntity(r119, r118, r19, null, r120, r31, r121, Integer.valueOf(r33.getValue()), null, false, Uri.fromFile(new PolarisFileWrapper(r17)), null, null, null, 15112, null));
        goto L4
    L114:
        r33 = UpLinkState.SUCCESS;
        goto L115
    L110:
        if (r13.length() != 0) goto L112;
    L101:
        if (r13.length() == 0) goto L104;
        r32 = false;
        goto L105
    L97:
        r30 = FileParseState.SUCCESS;
    L88:
        r24 = 0;
        goto L89
    L82:
        r116 = r21;
        goto L83
    L76:
        if (r21.length() == 0) goto L79;
        r115 = false;
    L116:
        if (r8 == null) goto L120;
        MediaAttachment r34 = r8.a;
        if (r34 == null) goto L120;
        String r35 = r34.getUri();
    L121:
        if (r8 == null) goto L125;
        MediaAttachment r122 = r8.a;
        if (r122 == null) goto L125;
        String r123 = r122.getUrl();
    L127:
        if (com.larus.utils.o0.d(r35) == false) goto L4;
        if (com.larus.utils.o0.d(r123) == false) goto L4;
        if (r21 != null) goto L133;
    L134:
        r26 = true;
    L135:
        if (r26 == false) goto L137;
        String r210 = null;
    L139:
        if (r8 == null) goto L147;
        MediaAttachment r36 = r8.a;
        if (r36 == null) goto L147;
        ImageUploadInfo r37 = r36.getImageUploadInfo();
        if (r37 == null) goto L147;
        Long r38 = r37.getWidth();
        if (r38 == null) goto L147;
        long r39 = r38.longValue();
    L148:
        int r124 = (int) r39;
        if (r8 == null) goto L157;
        MediaAttachment r41 = r8.a;
        if (r41 == null) goto L157;
        ImageUploadInfo r42 = r41.getImageUploadInfo();
        if (r42 == null) goto L157;
        Long r43 = r42.getHeight();
        if (r43 == null) goto L157;
        r111 = r43.longValue();
    L157:
        Iterator r44 = r0;
        UplinkEntityContent r125 = new UplinkEntityContent(null, new Image(r35, null, null, new ImageObj(r123, r124, (int) r111, null, null, 24, null), r210, r17, null, null, null, null, null, null, null, null, 16326, null), 1, null);
        Integer r126 = Integer.valueOf(UplinkEntityType.EntityTypeImage.getValue());
        Integer r127 = Integer.valueOf(FileReviewState.PROCESSING.getValue());
        if ((r5 instanceof ry9.j.a) == false) goto L160;
        FileParseState r45 = FileParseState.PROCESSING;
    L161:
        r2.add(new UplinkFileEntity(r126, r125, r19, null, r127, Integer.valueOf(r45.getValue()), 100, Integer.valueOf(UpLinkState.SUCCESS.getValue()), null, false, UriProtector.parse(r35), null, null, null, 15112, null));
        r0 = r44;
        goto L4
    L160:
        r45 = FileParseState.SUCCESS;
    L147:
        r39 = 0;
        goto L148
    L137:
        r210 = r21;
        goto L139
    L133:
        if (r21.length() != 0) goto L135;
    L125:
        r123 = null;
    L120:
        r35 = null;
        goto L121
    L65:
        if (r17.length() == 0) goto L68;
        r110 = false;
    L61:
        r21 = null;
    L56:
        r19 = null;
    L51:
        r17 = null;
    L46:
        r13 = null;
        goto L47
    L26:
        r8 = null;
        goto L27
    L163:
        return new NestedFileContent(r2, null, false, null, 14, null);
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.larus.uaigc.createpage.component.mediaselector.imageselector.j4] */
    public final MutableLiveData<ry9.k> X2(final String r14) {
        MutableLiveData<ry9.k> r0 = this.q.get(r14);
        if (r0 == null) goto L5;
        return r0;
    L5:
        FLogger r1 = FLogger.a;
        r1.i("MultiAttachmentSelector", "[getOrCreateAttachmentLiveData] create liveData, resourceKey = " + r14);
        MutableLiveData<ry9.k> r2 = new MutableLiveData();
        this.q.put(r14, r2);
        Intrinsics.checkNotNullParameter(this, "<this>");
        r2.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), (Observer) this.K.getValue());
        r1.i("MultiAttachmentSelector", "[registerAttachmentLiveData] key = " + r14);
        if (this.s.containsKey(r14) == false) goto L8;
        r1.i("MultiAttachmentSelector", "[registerAttachmentLiveData] containsKey = " + r14);
        m3(r14);
    L8:
        MediatorLiveData<Map<String, ry9.k>> r3 = this.r;
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
        this.r.addSource(r2, new c(new j4(this, r14)));
        this.s.put(r14, r2);
        return r2;
    }

    @Override // ry9.h
    public final void lu(String r2) {
        Intrinsics.checkNotNullParameter(r2, "resourceKey");
        if (r2.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        Function1<? super String, Unit> r1 = this.w;
        if (r1 == null) goto L10;
        r1.invoke(r2);
    L10:
        this.J = null;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void m3(String r4) {
        FLogger.a.i("MultiAttachmentSelector", "[unRegisterAttachmentLiveData] resourceKey = " + r4);
        MediatorLiveData<Map<String, ry9.k>> r0 = this.r;
        Map r1 = (Map) r0.getValue();
        if (r1 != null) goto L5;
        r1 = MapsKt.emptyMap();
    L5:
        Map r2 = MapsKt.toMutableMap(r1);
        r2.remove(r4);
        r0.setValue(r2);
        MutableLiveData<ry9.k> r3 = this.s.get(r4);
        if (r3 == null) goto L8;
        this.r.removeSource(r3);
    L8:
        this.s.remove(r4);
    }

    @Override // ry9.h
    public final void tE(com.larus.uaigc.instruction.b0 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.w = r2;
    }

    @Override // ry9.h
    public final ry9.d yH(List<ResourceItemBean> r2) {
        Intrinsics.checkNotNullParameter(r2, "resourceItemOrder");
        return new ry9.d(0);
    }

    public static final ry9.a F2(SpringMultiAttachmentSelectorComponent r45, xp9.i r46) {
        r45.getClass();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r46.a.iterator();
    L3:
        Boolean r3 = null;
        if (r2.hasNext() == false) goto L13;
        Uri r0 = (Uri) r2.next();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L11
        String r5 = vqc.d.d(r45.getContext(), r0);     // Catch: Throwable -> L11
        if (r5 == null) goto L9;
        r3 = Boolean.valueOf(r1.add(r5));     // Catch: Throwable -> L11
    L9:
        Result.constructor-impl(r3);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L3
    L13:
        ArrayList r7 = new ArrayList();
        Iterator r8 = r1.iterator();
    L15:
        if (r8.hasNext() == false) goto L21;
        String r11 = (String) r8.next();
        HashMap r9 = new HashMap();
        r9.put("ext_img_show_path", r11);
        String r23 = UUID.randomUUID().toString();
        String r25 = StringsKt.substringAfterLast$default(r11, '.', null, 2, null);
        String r10 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(StringsKt.substringAfterLast$default(r11, '.', null, 2, null));
        if (r10 != null) goto L19;
        r10 = "";
    L19:
        ItemStatus r30 = ItemStatus.UPLINKING;
        ResourceType r32 = ResourceType.IMAGE;
        r7.add(new ResourceItemBean(r23, null, r25, r10, new Image(UUID.randomUUID().toString(), "", null, null, null, r11, null, null, null, null, null, null, null, null, 16348, null), null, 0, r30, false, r32, i5.w0(), 0, 0, 0, false, false, false, false, 0, r9, 522530, null));
        goto L15
    L21:
        return new ry9.a(r7, r1, r45.D);
    }

    public static final Unit N2(final SpringMultiAttachmentSelectorComponent r9, ry9.a r10) {
        r9.getClass();
        Iterator<T> r11 = r10.a.iterator();
    L4:
        if (r11.hasNext() == false) goto L15;
        final ResourceItemBean r0 = (ResourceItemBean) r11.next();
        com.larus.utils.t0.e(new k4(r9, r0));
        Image r1 = r0.getImage();
        if (r1 == null) goto L4;
        String r2 = r1.localResPath;
        if (r2 == null) goto L4;
        PolarisFileWrapper r3 = new PolarisFileWrapper(r2);
        if (r3.exists() == false) goto L4;
        BuildersKt.async$default(LifecycleOwnerKt.getLifecycleScope(r9), Dispatchers.getIO(), null, new SpringMultiAttachmentSelectorComponent$onCompressUploadAndCheck$2$2(r9, r3, r0, null), 2, null);
        goto L4
    L15:
        return Unit.INSTANCE;
    }

    @Override // ry9.h
    public final Object BM(ResourceItemBean r1, Continuation<? super Unit> r2) {
        return Unit.INSTANCE;
    }

    @Override // ry9.h
    public final void f90(boolean r3, com.larus.uaigc.createpage.component.input.t r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.I = "plus_panel_preview";
        this.H = r4;
        ry9.h.a.a(this, Y2(), r3, 0, 60);
    }

    public final void h3(boolean r56, String r57) {
        ny9.s r1 = (ny9.s) this.m.getValue();
        String r2 = null;
        if (r1 == null) goto L7;
        ICoreInputAbility.SendMessageTrackExtMap r3 = r1.n();
        if (r3 == null) goto L7;
        Map r4 = r3.a;
    L8:
        uy9.a r5 = (uy9.a) this.p.getValue();
        if (r5 == null) goto L11;
        r5.Rq();
        String r6 = "template_page";
    L12:
        boolean r7 = false;
        if (r6 != null) goto L15;
    L18:
        boolean r8 = true;
    L19:
        if (r8 == true) goto L21;
    L32:
        ny9.u r9 = U2();
        if (r9 == null) goto L35;
        String r10 = r9.getClickFrom();
    L36:
        ny9.u r11 = U2();
        if (r11 == null) goto L39;
        String r12 = r11.getEnterMethod();
    L40:
        Map<String, String> r13 = IAIChatRenderTraceService.a.i();
        if (r13 == null) goto L85;
        String r14 = r13.get("key_current_page");
        if (r14 != null) goto L45;
    L50:
        String r15 = r13.get("spring_guide_card_id");
        if (r15 != null) goto L53;
    L58:
        r15 = null;
    L59:
        String r16 = r13.get("key_click_from");
        if (r16 != null) goto L62;
    L67:
        String r17 = r13.get("key_enter_method");
        if (r17 != null) goto L70;
    L75:
        String r18 = r13.get("key_action_bar_key");
        if (r18 != null) goto L78;
    L83:
        r18 = null;
    L84:
        String r19 = r6;
        String r110 = r10;
        String r23 = r12;
        String r22 = r18;
        String r46 = r15;
    L86:
        ny9.u r20 = U2();
        if (r20 == null) goto L89;
        String r111 = r20.m();
    L90:
        ny9.u r21 = U2();
        if (r21 == null) goto L93;
        String r24 = r21.i();
    L94:
        ny9.u r25 = U2();
        if (r25 == null) goto L97;
        String r26 = r25.c();
    L98:
        uy9.a r27 = (uy9.a) this.p.getValue();
        if (r27 == null) goto L101;
        String r112 = r27.PG();
    L102:
        ny9.u r28 = U2();
        if (r28 == null) goto L105;
        String r29 = r28.getBotId();
    L106:
        if (r56 == false) goto L108;
        String r30 = "1";
    L109:
        String r113 = r30;
        IAIChatControlTraceService.Companion r31 = IAIChatControlTraceService.a;
        String r210 = r31.h(r31.gb());
        if (r4 == null) goto L112;
        String r34 = (String) r4.get("from_template_id");
    L113:
        if (r4 == null) goto L115;
        String r35 = (String) r4.get("from_template_sub_type");
    L116:
        if (r4 == null) goto L118;
        r2 = (String) r4.get("template_rec_req_id");
    L118:
        tx9.y3.a(r29, r19, r112, r57, "pic", null, r113, null, null, r110, null, r111, r24, r26, r22, r23, null, r210, null, null, null, null, null, null, null, null, r34, r35, null, null, r2, null, null, null, null, null, null, null, r46, null, null, null, null, null, null, -806086752, 65021);
        return;
    L115:
        r35 = null;
        goto L116
    L112:
        r34 = null;
        goto L113
    L108:
        r30 = "0";
        goto L109
    L105:
        r29 = null;
        goto L106
    L101:
        r112 = null;
        goto L102
    L97:
        r26 = null;
        goto L98
    L93:
        r24 = null;
        goto L94
    L89:
        r111 = null;
        goto L90
    L78:
        if (com.larus.utils.o0.d(r18) == true) goto L81;
        r18 = null;
    L81:
        if (r18 == null) goto L83;
    L70:
        if (com.larus.utils.o0.d(r17) == true) goto L73;
        r17 = null;
    L73:
        if (r17 == null) goto L75;
        r12 = r17;
        goto L75
    L62:
        if (com.larus.utils.o0.d(r16) == true) goto L65;
        r16 = null;
    L65:
        if (r16 == null) goto L67;
        r10 = r16;
        goto L67
    L53:
        if (com.larus.utils.o0.d(r15) == true) goto L56;
        r15 = null;
    L56:
        if (r15 == null) goto L58;
    L45:
        if (com.larus.utils.o0.d(r14) == true) goto L48;
        r14 = null;
    L48:
        if (r14 == null) goto L50;
        r6 = r14;
        goto L50
    L85:
        r22 = null;
        r46 = null;
        r19 = r6;
        r110 = r10;
        r23 = r12;
        goto L86
    L39:
        r12 = null;
        goto L40
    L35:
        r10 = null;
        goto L36
    L21:
        if ((getContext() instanceof ny9.i) == true) goto L24;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if ((com.larus.ui.arch.component.internal.attach.a.b(this, this) instanceof ny9.i) == true) goto L24;
    L25:
        if (r7 == false) goto L32;
        ny9.s r32 = (ny9.s) this.m.getValue();
        if (r32 == null) goto L31;
        Bundle r33 = r32.a;
        if (r33 == null) goto L31;
        r6 = r33.getString("previous_page_name");
    L31:
        r6 = null;
    L24:
        r7 = true;
        goto L25
    L15:
        if (r6.length() == 0) goto L18;
        r8 = false;
        goto L19
    L11:
        r6 = null;
    L7:
        r4 = null;
        goto L8
    }

    @Override // ry9.h
    public final void nE(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "resourceKey");
        Intrinsics.checkNotNullParameter(r9, "localResPath");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SpringMultiAttachmentSelectorComponent$handleAttachmentRetry$1(this, r8, r9, null), 3, null);
    }

    public static final void P2(final SpringMultiAttachmentSelectorComponent r8, final String r9, String r10) {
        r8.getClass();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(Uri.fromFile(new PolarisFileWrapper(r10)));     // Catch: Throwable -> L5
    L8:
        if (Result.isSuccess-impl(r1) == false) goto L11;
        Uri r2 = (Uri) r1;
        Job r11 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r8), Dispatchers.getMain(), null, new SpringMultiAttachmentSelectorComponent$parseUriAndStartUpload$2$uploadJob$1(r8, r9, r10, null), 2, null);
        r8.x.put(r9, r11);
    L11:
        if (Result.exceptionOrNull-impl(r1) == null) goto L16;
        com.larus.utils.t0.e(new l4(r8, r9));
        r8.h3(false, "upload");
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // ry9.h
    public final void uz(String r7, String r8, ic8.m0 r9) {
        Intrinsics.checkNotNullParameter(r7, "resourceKey");
        Intrinsics.checkNotNullParameter(r8, "localResPath");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SpringMultiAttachmentSelectorComponent$triggerUploadAndCheck$1(this, r7, r8, null), 3, null);
    }

    @Override // ry9.h
    public final void w60(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "resourceKey");
        Intrinsics.checkNotNullParameter(r8, "localResPath");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SpringMultiAttachmentSelectorComponent$handleAttachmentRemove$1(this, r7, r8, null), 3, null);
    }

    @Override // ry9.h
    public final void xz(String r2, int r3, boolean r4) {
        this.E = r2;
        this.F = r3;
        ry9.h.a.a(this, Y2(), r4, 0, 60);
    }

    @Override // ry9.h
    public final void YL(int r1, boolean r2, int r3, int r4, ry9.d r5) {
        if (r2 == false) goto L5;
        this.D = r3;
        AlbumSettingConfig.a r6 = new AlbumSettingConfig.a();
        r6.f = this.I;
        r6.c = false;
        AlbumSettingConfig r7 = r6.a();
        this.I = null;
        LocalTakePictureImpl r8 = this.y;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r8.g(com.larus.ui.arch.component.internal.attach.a.b(this, this), r7);
        return;
    L5:
        this.D = -1;
        if (this.B == false) goto L8;
        AlbumSettingConfig.a r9 = new AlbumSettingConfig.a();
        r9.f = this.I;
        r9.d = r1;
        r9.c = true;
        AlbumSettingConfig r10 = r9.a();
        this.I = null;
        LocalTakePictureImpl r11 = this.y;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r11.g(com.larus.ui.arch.component.internal.attach.a.b(this, this), r10);
        return;
    L8:
        AlbumSettingConfig.Companion.getClass();
        AlbumSettingConfig r12 = AlbumSettingConfig.b.a();
        LocalTakePictureImpl r13 = this.y;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r13.g(com.larus.ui.arch.component.internal.attach.a.b(this, this), r12);
    }

    @Override // ry9.h
    public final void q00(String r17, String r18, String r19, String r20, String r21, boolean r22, boolean r23, String r24) {
        Intrinsics.checkNotNullParameter(r17, "resourceKey");
        Intrinsics.checkNotNullParameter(r18, "url");
        Intrinsics.checkNotNullParameter(r19, "identifier");
        Intrinsics.checkNotNullParameter(r20, "resourceId");
        Intrinsics.checkNotNullParameter(r21, "localFilePath");
        Job r0 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SpringMultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1(r18, this, r19, r21, r24, r20, r17, r22, r23, null), 3, null);
        this.x.put(r17, r0);
    }
}
