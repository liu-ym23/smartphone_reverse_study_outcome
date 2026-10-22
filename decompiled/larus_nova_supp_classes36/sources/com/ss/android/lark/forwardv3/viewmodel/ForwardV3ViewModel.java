package com.ss.android.lark.forwardv3.viewmodel;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.i18n.claymore.PluginServiceLoader;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.biz.im.api.p0;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forwardv3.ForwardImServices;
import com.ss.android.lark.forwardv3.ForwardModuleV3;
import com.ss.android.lark.forwardv3.configuration.BasicDialogContentConfig;
import com.ss.android.lark.forwardv3.configuration.Forward$Source;
import com.ss.android.lark.forwardv3.configuration.Forward$Type;
import com.ss.android.lark.forwardv3.configuration.ForwardAdditionNoteConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardCommonConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardConfirmDialogConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardSelectConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTargetConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.configuration.e;
import com.ss.android.lark.forwardv3.configuration.g;
import com.ss.android.lark.forwardv3.configuration.h;
import com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$Tenant;
import com.ss.android.lark.forwardv3.configuration.targetconfig.DisableConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem;
import com.ss.android.lark.forwardv3.configuration.targetconfig.GroupConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig;
import com.ss.android.lark.forwardv3.data.ForwardErrorResultV3;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.data.ForwardTargetChatterInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetGroupChatInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetShieldP2PChatInfo;
import com.ss.android.lark.forwardv3.data.ForwardTargetThreadInfo;
import com.ss.android.lark.forwardv3.data.services.ForwardSendServices;
import com.ss.android.lark.forwardv3.data.services.ForwardSendServices$sendMessage$2$1$1;
import com.ss.android.lark.forwardv3.data.services.ForwardSendServices$sendMessage$2$1$2;
import com.ss.android.lark.forwardv3.data.services.ForwardSendServices$share$1$1;
import com.ss.android.lark.forwardv3.messageforward.MergeMessageForwardContent;
import com.ss.android.lark.forwardv3.messageforward.OneByOneMessageForwardContent;
import com.ss.android.lark.forwardv3.messageforward.SingleMessageForwardContent;
import com.ss.android.lark.forwardv3.utils.ConfigUtils;
import com.ss.android.lark.forwardv3.utils.Constants$ForwardTargetType;
import com.ss.android.lark.forwardv3.utils.ForwardDataUtils;
import com.ss.android.lark.forwardv3.utils.n;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.ai_knowledge.GetQueryByMessageIDsRequest;
import com.ss.android.lark.pb.ai_knowledge.GetQueryByMessageIDsResponse;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.messages.BatchShareMessageRequest;
import com.ss.android.lark.picker.base.view.avatar.ExternalTargetAvatarProviderStore;
import com.ss.android.lark.picker.config.AI;
import com.ss.android.lark.picker.config.Bot;
import com.ss.android.lark.picker.config.SearcherConfig;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.search.dto.Scene;
import com.ss.android.lark.search.dto.info.SearchAiKnowledgeInfo;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo;
import com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo;
import com.ss.android.lark.search.dto.info.SearchThreadInfo;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import oib.c;
import oib.d;
import tib.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000²\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 »\u00012\u00020\u0001:\u0004»\u0001¼\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0086@¢\u0006\u0003\u0010\u0089\u0001J:\u0010\u008a\u0001\u001a\u00030\u0088\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\u0007\u0010\u008d\u0001\u001a\u00020\u00122\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0011\u0010\u0090\u0001\u001a\f\u0012\u0005\u0012\u00030\u0092\u0001\u0018\u00010\u0091\u0001J.\u0010\u0093\u0001\u001a\u00030\u0088\u00012\u000e\u0010\u0094\u0001\u001a\t\u0012\u0004\u0012\u00020k0\u0095\u00012\u0014\u0010\u0096\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0;0\u0097\u0001J\b\u0010\u0098\u0001\u001a\u00030\u0088\u0001J\n\u0010\u0099\u0001\u001a\u00030\u0088\u0001H\u0002J\u001d\u0010\u009a\u0001\u001a\u00030\u0088\u00012\b\u0010\u009b\u0001\u001a\u00030\u009c\u00012\t\b\u0002\u0010\u009d\u0001\u001a\u00020\u000eJ\u0013\u0010\u009e\u0001\u001a\u00030\u0088\u00012\u0007\u0010\u009f\u0001\u001a\u00020_H\u0002J\u0013\u0010 \u0001\u001a\u00030\u0088\u00012\u0007\u0010\u009f\u0001\u001a\u00020_H\u0002J\u0019\u0010¡\u0001\u001a\u00030\u0088\u00012\u0006\u0010l\u001a\u00020k2\u0007\u0010¢\u0001\u001a\u00020\u000eJ\b\u0010£\u0001\u001a\u00030\u0088\u0001J\u000e\u0010¤\u0001\u001a\t\u0012\u0004\u0012\u00020k0\u0095\u0001J\b\u0010¥\u0001\u001a\u00030¦\u0001J\u0010\u0010§\u0001\u001a\u00020\u000e2\u0007\u0010¨\u0001\u001a\u00020kJ\u0010\u0010©\u0001\u001a\u00020\u000e2\u0007\u0010¨\u0001\u001a\u00020kJ\u0010\u0010ª\u0001\u001a\u00020\u000e2\u0007\u0010¨\u0001\u001a\u00020kJ\u0007\u0010«\u0001\u001a\u00020\u0012J\b\u0010¬\u0001\u001a\u00030\u00ad\u0001J\u0012\u0010®\u0001\u001a\u00030\u0088\u00012\b\u0010¯\u0001\u001a\u00030°\u0001J\b\u0010±\u0001\u001a\u00030\u0088\u0001J\u0010\u0010²\u0001\u001a\u00020\u000e2\u0007\u0010³\u0001\u001a\u00020kJ\u0010\u0010´\u0001\u001a\u00020\u000e2\u0007\u0010³\u0001\u001a\u00020kJ\u0010\u0010µ\u0001\u001a\u00020\u00072\u0007\u0010¶\u0001\u001a\u00020kJ8\u0010·\u0001\u001a\u00030\u0088\u00012\b\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0007\u0010\u008d\u0001\u001a\u00020\u00122\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0011\u0010\u0090\u0001\u001a\f\u0012\u0005\u0012\u00030\u0092\u0001\u0018\u00010\u0091\u0001J&\u0010¸\u0001\u001a\u00030\u0088\u00012\u000b\b\u0002\u0010¹\u0001\u001a\u0004\u0018\u00010\u00122\u000f\u0010\u0096\u0001\u001a\n\u0012\u0005\u0012\u00030º\u00010\u0097\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u001e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u001e\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u001e\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u001e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0011R \u0010#\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0011R\u001e\u0010%\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0015R\u001e\u0010'\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0015R\u001e\u0010)\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0015R\u001e\u0010+\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0011R\u001e\u0010-\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0011R\u001e\u00100\u001a\u00020/2\u0006\u0010\r\u001a\u00020/@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\"\u00104\u001a\u0004\u0018\u0001032\b\u0010\r\u001a\u0004\u0018\u000103@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\"\u00108\u001a\u0004\u0018\u0001072\b\u0010\r\u001a\u0004\u0018\u000107@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R*\u0010=\u001a\b\u0012\u0004\u0012\u00020<0;2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020<0;@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\"\u0010A\u001a\u0004\u0018\u00010@2\b\u0010\r\u001a\u0004\u0018\u00010@@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\"\u0010E\u001a\u0004\u0018\u00010D2\b\u0010\r\u001a\u0004\u0018\u00010D@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\"\u0010I\u001a\u0004\u0018\u00010H2\b\u0010\r\u001a\u0004\u0018\u00010H@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\"\u0010M\u001a\u0004\u0018\u00010L2\b\u0010\r\u001a\u0004\u0018\u00010L@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u001e\u0010P\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0011R\"\u0010S\u001a\u0004\u0018\u00010R2\b\u0010\r\u001a\u0004\u0018\u00010R@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\"\u0010W\u001a\u0004\u0018\u00010V2\b\u0010\r\u001a\u0004\u0018\u00010V@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\"\u0010Z\u001a\u0004\u0018\u0001032\b\u0010\r\u001a\u0004\u0018\u000103@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b[\u00106R \u0010\\\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020`0^0]X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020`0^0b¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0019\u0010e\u001a\r\u0012\t\u0012\u00070\u0007¢\u0006\u0002\bf0]X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010g\u001a\r\u0012\t\u0012\u00070\u0007¢\u0006\u0002\bf0b¢\u0006\b\n\u0000\u001a\u0004\bh\u0010dR \u0010i\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020k0j0]X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010l\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020k0j0b¢\u0006\b\n\u0000\u001a\u0004\bm\u0010dR\u0016\u0010n\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010p\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010qX\u0082\u000e¢\u0006\u0002\n\u0000R:\u0010r\u001a.\u0012(\u0012&\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030u\u0018\u00010tj\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030u\u0018\u0001`v\u0018\u00010sX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010w\u001a\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020x\u0018\u00010tj\n\u0012\u0004\u0012\u00020x\u0018\u0001`v\u0018\u00010sX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010y\u001a\u00020\u0007X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\bz\u0010{R\u0014\u0010|\u001a\u00020\u0007X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b}\u0010{R\u000e\u0010~\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u007f\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0081\u0001\u001a\u00030\u0082\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001¨\u0006½\u0001"}, d2 = {"Lcom/ss/android/lark/forwardv3/viewmodel/ForwardV3ViewModel;", "Landroidx/lifecycle/ViewModel;", "templateNew", "Lcom/ss/android/lark/forwardv3/configuration/ForwardTemplateNew;", "<init>", "(Lcom/ss/android/lark/forwardv3/configuration/ForwardTemplateNew;)V", "resultCode", "", "getResultCode", "()Ljava/lang/Integer;", "setResultCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "value", "", "showTitleBar", "getShowTitleBar", "()Z", "", "titleBarText", "getTitleBarText", "()Ljava/lang/String;", "enableSwitchSelectMode", "getEnableSwitchSelectMode", "defaultSingleSelectMode", "getDefaultSingleSelectMode", "enableChatPreview", "getEnableChatPreview", "enableExternalTarget", "getEnableExternalTarget", "maxLimitSelectNum", "getMaxLimitSelectNum", "()I", "enableCreateGroupChat", "getEnableCreateGroupChat", "enableRecentForward", "getEnableRecentForward", "dialogTitleBarText", "getDialogTitleBarText", "confirmButtonText", "getConfirmButtonText", "cancelButtonText", "getCancelButtonText", "enableAdditionNote", "getEnableAdditionNote", "enableAdditionNoteAT", "getEnableAdditionNoteAT", "Lcom/ss/android/lark/forwardv3/configuration/BasicDialogContentConfig;", "dialogContent", "getDialogContent", "()Lcom/ss/android/lark/forwardv3/configuration/BasicDialogContentConfig;", "Lcom/ss/android/lark/chat/entity/message/Message;", "displayMessage", "getDisplayMessage", "()Lcom/ss/android/lark/chat/entity/message/Message;", "Lcom/ss/android/lark/forwardv3/configuration/IForwardContent;", "forwardContent", "getForwardContent", "()Lcom/ss/android/lark/forwardv3/configuration/IForwardContent;", "", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "forwardTargets", "getForwardTargets", "()Ljava/util/List;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnCancelMultiSelectListener;", "cancelMultiSelectListener", "getCancelMultiSelectListener", "()Lcom/ss/android/lark/forwardv3/configuration/listener/OnCancelMultiSelectListener;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnCloseForwardListener;", "closeForwardListener", "getCloseForwardListener", "()Lcom/ss/android/lark/forwardv3/configuration/listener/OnCloseForwardListener;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardConfirmDialogListener;", "confirmDialogListener", "getConfirmDialogListener", "()Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardConfirmDialogListener;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnCustomForwardConfirmDialogContentView;", "customConfirmDialogContentView", "getCustomConfirmDialogContentView", "()Lcom/ss/android/lark/forwardv3/configuration/listener/OnCustomForwardConfirmDialogContentView;", "enableBackOriginalApplication", "getEnableBackOriginalApplication", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "forwardContentListener", "getForwardContentListener", "()Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardContentListener;", "Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardNoteListener;", "forwardNoteListener", "getForwardNoteListener", "()Lcom/ss/android/lark/forwardv3/configuration/listener/OnForwardNoteListener;", "sourceMessage", "getSourceMessage", "_recommendData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/forwardv3/data/loadstate/LoadState;", "Lcom/ss/android/lark/forwardv3/data/ChatPickerRecommendData;", "", "recommendData", "Landroidx/lifecycle/LiveData;", "getRecommendData", "()Landroidx/lifecycle/LiveData;", "_selectMode", "Lcom/ss/android/lark/forwardv3/utils/Constants$SelectMode;", "selectMode", "getSelectMode", "_selectedItem", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "selectedItem", "getSelectedItem", "messageParamConvertHandler", "Lcom/ss/android/lark/forwardv3/configuration/IConvertMessageParamsHandler;", "shareParamConvertHandler", "Lcom/ss/android/lark/forwardv3/configuration/IConvertShareParamsHandler;", "messageDeferred", "Lkotlinx/coroutines/Deferred;", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chat/entity/message/MessageParams$Builder;", "Lkotlin/collections/ArrayList;", "shareDeferred", "Lcom/ss/android/lark/forwardv3/configuration/param/ShareOption;", "netDataStatus", "getNetDataStatus$annotations", "()V", "localDataStatus", "getLocalDataStatus$annotations", "localDataHasUpdate", "externalTargetId", "disableExternalTargetByMessageCount", "source", "Lcom/ss/android/lark/forwardv3/configuration/Forward$Source;", "getSource", "()Lcom/ss/android/lark/forwardv3/configuration/Forward$Source;", "setSource", "(Lcom/ss/android/lark/forwardv3/configuration/Forward$Source;)V", "asyncLoadMessageParams", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performForward", "context", "Landroid/content/Context;", "note", "richText", "Lcom/ss/android/lark/widget/richtext/RichText;", "forwardContentCallbackInner", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/forwardv3/data/ForwardResultV3;", "prepareChatBeforeForward", "items", "", "callback", "Lcom/larksuite/framework/callback/UIGetDataCallback;", "init", "initConvertHandler", "loadRecommendData", "activityStartTime", "", "isLocal", "insertAIKnowledgeIfNeed", "chatPickerRecommendData", "insertExternalTargetIfNeed", "updateMultiItemSelect", "isSelected", "switchSelectMode", "getSelectedItemList", "getTitleBarShowInfo", "Lcom/ss/android/lark/forwardv3/data/TitleBarShowInfo;", "disable", "info", "isExternalTargetDisabledByMessageCount", "customDisable", "customDisableToastText", "getSearchPickerParams", "Lcom/ss/android/lark/forwardv3/utils/ConfigUtils$SearchPickerParams;", "getSearchPickerV2Params", "searcherConfig", "Lcom/ss/android/lark/picker/config/SearcherConfig;", "clearSelectedItem", "disableByInclude", "searchBaseInfo", "isDisableByCreateGroupChat", "createGroupChatDisableToastText", "data", "performShareForward", "requestAiKnowledgeData", "additionNote", "Lcom/ss/android/lark/forwardv3/data/ForwardAiKnowledgeInfo;", "Companion", "RequestStatus", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardV3ViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String FG_KEY_PICKER_SUPPORT_ADD_BOT = "im.chat.picker_support_add_bot";
    private static final String TAG = "ForwardNewViewModel";
    private final MutableLiveData<sib.a<rib.b, Throwable>> _recommendData;
    private final MutableLiveData<Integer> _selectMode;
    private final MutableLiveData<Map<String, SearchBaseInfo>> _selectedItem;
    private String cancelButtonText;
    private oib.a cancelMultiSelectListener;
    private oib.b closeForwardListener;
    private String confirmButtonText;
    private c confirmDialogListener;
    private OnCustomForwardConfirmDialogContentView customConfirmDialogContentView;
    private boolean defaultSingleSelectMode;
    private BasicDialogContentConfig dialogContent;
    private String dialogTitleBarText;
    private boolean disableExternalTargetByMessageCount;
    private Message displayMessage;
    private boolean enableAdditionNote;
    private boolean enableAdditionNoteAT;
    private boolean enableBackOriginalApplication;
    private boolean enableChatPreview;
    private boolean enableCreateGroupChat;
    private boolean enableExternalTarget;
    private boolean enableRecentForward;
    private boolean enableSwitchSelectMode;
    private String externalTargetId;
    private IForwardContent forwardContent;
    private OnForwardContentListener forwardContentListener;
    private d forwardNoteListener;
    private List<ForwardTargetBaseInfoNew> forwardTargets;
    private boolean localDataHasUpdate;
    private int localDataStatus;
    private int maxLimitSelectNum;
    private Deferred<? extends ArrayList<MessageParams.a<?, ?>>> messageDeferred;
    private g<IForwardContent> messageParamConvertHandler;
    private int netDataStatus;
    private final LiveData<sib.a<rib.b, Throwable>> recommendData;
    private Integer resultCode;
    private final LiveData<Integer> selectMode;
    private final LiveData<Map<String, SearchBaseInfo>> selectedItem;
    private Deferred<? extends ArrayList<pib.d>> shareDeferred;
    private h<IForwardContent> shareParamConvertHandler;
    private boolean showTitleBar;
    private Forward$Source source;
    private Message sourceMessage;
    private final ForwardTemplateNew templateNew;
    private String titleBarText;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/forwardv3/viewmodel/ForwardV3ViewModel$RequestStatus;", "", "Companion", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface RequestStatus {
        public static final int AVAILABLE = 1;
        public static final a Companion = null;
        public static final int ERROR = 2;
        public static final int NOT_ARRIVE = 0;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel$asyncLoadMessageParams$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel$asyncLoadMessageParams$2", f = "ForwardV3ViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ForwardV3ViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel$asyncLoadMessageParams$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a&\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0018\u00010\u0001j\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0018\u0001`\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chat/entity/message/MessageParams$Builder;", "Lkotlin/collections/ArrayList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
        @DebugMetadata(c = "com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel$asyncLoadMessageParams$2$1", f = "ForwardV3ViewModel.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<MessageParams.a<?, ?>>>, Object> {
            int label;
            final /* synthetic */ ForwardV3ViewModel this$0;

            public AnonymousClass1(ForwardV3ViewModel r1, Continuation<? super AnonymousClass1> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass1(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super ArrayList<MessageParams.a<?, ?>>> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L16:
                return (ArrayList) r4;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                g r5 = ForwardV3ViewModel.access$getMessageParamConvertHandler$p(this.this$0);
                if (r5 == null) goto L14;
                IForwardContent r2 = this.this$0.getForwardContent();
                this.label = 1;
                r4 = r5.a(r2);
                if (r4 != r0) goto L16;
                return r0;
            L14:
                return null;
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel$asyncLoadMessageParams$2$2, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/forwardv3/configuration/param/ShareOption;", "Lkotlin/collections/ArrayList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
        @DebugMetadata(c = "com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel$asyncLoadMessageParams$2$2", f = "ForwardV3ViewModel.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00772 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<pib.d>>, Object> {
            int label;
            final /* synthetic */ ForwardV3ViewModel this$0;

            public C00772(ForwardV3ViewModel r1, Continuation<? super C00772> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00772(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super ArrayList<pib.d>> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L16:
                return (ArrayList) r4;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                h r5 = ForwardV3ViewModel.access$getShareParamConvertHandler$p(this.this$0);
                if (r5 == null) goto L14;
                IForwardContent r2 = this.this$0.getForwardContent();
                this.label = 1;
                r4 = r5.b(r2);
                if (r4 != r0) goto L16;
                return r0;
            L14:
                return null;
            }
        }

        public AnonymousClass2(ForwardV3ViewModel r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r9);
            CoroutineScope r10 = (CoroutineScope) this.L$0;
            ForwardV3ViewModel.access$setMessageDeferred$p(this.this$0, BuildersKt.async$default(r10, Dispatchers.getIO(), null, new AnonymousClass1(this.this$0, null), 2, null));
            ForwardV3ViewModel.access$setShareDeferred$p(this.this$0, BuildersKt.async$default(r10, Dispatchers.getIO(), null, new C00772(this.this$0, null), 2, null));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel$loadRecommendData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel$loadRecommendData$1", f = "ForwardV3ViewModel.kt", i = {0, 1}, l = {454, 455}, m = "invokeSuspend", n = {"recentVisitFuture", "recentForwardResult"}, s = {"L$0", "L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $activityStartTime;
        final /* synthetic */ boolean $isLocal;
        final /* synthetic */ long $startGetDataTime;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ForwardV3ViewModel this$0;

        public AnonymousClass1(long r1, boolean r3, ForwardV3ViewModel r4, long r5, Continuation<? super AnonymousClass1> r7) {
            this.$startGetDataTime = r1;
            this.$isLocal = r3;
            this.this$0 = r4;
            this.$activityStartTime = r5;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r8 = new AnonymousClass1(this.$startGetDataTime, this.$isLocal, this.this$0, this.$activityStartTime, r11);
            r8.L$0 = r10;
            return r8;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r18) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            boolean r4 = true;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            List<SearchBaseInfo> r3 = (List) this.L$0;
            ResultKt.throwOnFailure(r18);
            Object r5 = r18;
        L17:
            List<SearchBaseInfo> r6 = (List) r5;
            long r7 = SystemClock.elapsedRealtime();
            rib.b.a r8 = new rib.b.a();
            Intrinsics.checkNotNullParameter(r3, "recentForwardData");
            r8.b = r3;
            Intrinsics.checkNotNullParameter(r6, "recentVisitData");
            r8.a = r6;
            r8.c = r7 - this.$startGetDataTime;
            r8.d = this.$isLocal;
            rib.b r9 = r8.a();
            if (this.$isLocal == false) goto L20;
            ForwardV3ViewModel.access$setLocalDataStatus$p(this.this$0, 1);
        L21:
            ForwardV3ViewModel.access$insertAIKnowledgeIfNeed(this.this$0, r9);
            ForwardV3ViewModel.access$insertExternalTargetIfNeed(this.this$0, r9);
            if (this.$isLocal == true) goto L24;
        L26:
            boolean r10 = false;
        L28:
            if (this.$isLocal == false) goto L38;
            if (ForwardV3ViewModel.access$getNetDataStatus$p(this.this$0) == 1) goto L38;
            Log.i(ForwardV3ViewModel.TAG, "callback from local, net data is not available");
            if (r10 == false) goto L35;
            Log.e(ForwardV3ViewModel.TAG, "local chatPickerRecommendData is empty");
            return Unit.INSTANCE;
        L35:
            ForwardV3ViewModel.access$get_recommendData$p(this.this$0).postValue(new sib.a.b(r9));
            ForwardV3ViewModel.access$setLocalDataHasUpdate$p(this.this$0, true);
            return Unit.INSTANCE;
        L38:
            if (this.$isLocal == true) goto L52;
            Log.i(ForwardV3ViewModel.TAG, "callback from net, local data is: " + ForwardV3ViewModel.access$getLocalDataStatus$p(this.this$0) + ", net data is: " + ForwardV3ViewModel.access$getNetDataStatus$p(this.this$0));
            if (CollectionUtils.isEmpty(r9.b) == true) goto L42;
        L44:
            r4 = false;
        L45:
            if (r4 == true) goto L47;
        L50:
            ForwardV3ViewModel.access$get_recommendData$p(this.this$0).postValue(new sib.a.b(r9));
            goto L52
        L47:
            if (ForwardV3ViewModel.access$getLocalDataHasUpdate$p(this.this$0) == false) goto L50;
            Log.e(ForwardV3ViewModel.TAG, "net data is null, and local data has update");
            return Unit.INSTANCE;
        L42:
            if (CollectionUtils.isEmpty(r9.a) == false) goto L44;
        L52:
            return Unit.INSTANCE;
        L24:
            if (r9.a() == false) goto L26;
            r10 = true;
            goto L28
        L20:
            ForwardV3ViewModel.access$setNetDataStatus$p(this.this$0, 1);
            goto L21
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Deferred r11 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r18);
            Object r12 = r18;
        L13:
            List<SearchBaseInfo> r13 = (List) r12;
            this.L$0 = r13;
            this.label = 2;
            r5 = r11.await(this);
            if (r5 != r1) goto L16;
            return r1;
        L16:
            r3 = r13;
            goto L17
        L10:
            ResultKt.throwOnFailure(r18);
            CoroutineScope r14 = (CoroutineScope) this.L$0;
            Deferred r15 = BuildersKt.async$default(r14, null, null, new ForwardV3ViewModel$loadRecommendData$1$recentForwardFuture$1(this.$activityStartTime, this.this$0, this.$isLocal, null), 3, null);
            r11 = BuildersKt.async$default(r14, null, null, new ForwardV3ViewModel$loadRecommendData$1$recentVisitFuture$1(this.$activityStartTime, this.this$0, this.$isLocal, null), 3, null);
            this.L$0 = r11;
            this.label = 1;
            r12 = r15.await(this);
            if (r12 != r1) goto L13;
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel$performForward$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel$performForward$1", f = "ForwardV3ViewModel.kt", i = {}, l = {209}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ IGetDataCallback<rib.d> $forwardContentCallbackInner;
        final /* synthetic */ String $note;
        final /* synthetic */ RichText $richText;
        int label;
        final /* synthetic */ ForwardV3ViewModel this$0;

        public C03821(ForwardV3ViewModel r1, Context r2, String r3, RichText r4, IGetDataCallback<rib.d> r5, Continuation<? super C03821> r6) {
            this.this$0 = r1;
            this.$context = r2;
            this.$note = r3;
            this.$richText = r4;
            this.$forwardContentCallbackInner = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new C03821(this.this$0, this.$context, this.$note, this.$richText, this.$forwardContentCallbackInner, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r44) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r44);
            Object r3 = r44;
        L11:
            ArrayList r4 = (ArrayList) r3;
            if (r4 != null) goto L14;
        L57:
            Log.e(ForwardV3ViewModel.TAG, "messageParamsBuilders is null");
            boolean r0 = zib.b.d;
            Forward$Type.a r5 = Forward$Type.Companion;
            int r6 = ForwardV3ViewModel.access$getTemplateNew$p(this.this$0).getType();
            r5.getClass();
            zib.b.d(Forward$Type.a.a(r6), -1001, "messageParamsBuilders is null", "messageParamsBuilders is null");
        L59:
            return Unit.INSTANCE;
        L14:
            if (CollectionUtils.isEmpty(this.this$0.getForwardTargets()) == true) goto L57;
            int r7 = ForwardSendServices.a;
            final Context r8 = this.$context;
            final List<ForwardTargetBaseInfoNew> r15 = this.this$0.getForwardTargets();
            final String r14 = this.$note;
            final RichText r13 = this.$richText;
            IGetDataCallback<rib.d> r12 = this.$forwardContentCallbackInner;
            OnForwardContentListener r11 = this.this$0.getForwardContentListener();
            final d r23 = this.this$0.getForwardNoteListener();
            final int r24 = ForwardV3ViewModel.access$getTemplateNew$p(this.this$0).getType();
            Intrinsics.checkNotNullParameter(r4, "messageParamsBuilder");
            Intrinsics.checkNotNullParameter(r15, "targets");
            Intrinsics.checkNotNullParameter(r14, "note");
            Intrinsics.checkNotNullParameter(r13, "richText");
            if (r8 == null) goto L59;
            f r10 = (f) ForwardModuleV3.b.getValue();
            char r9 = 0;
            if (r10 != null) goto L26;
            Log.e("ForwardSendServices", "IForwardImDependency is not registered");
            if (r11 == null) goto L24;
            r11.onFailed("IForwardImDependency is not registered");
        L24:
            if (r12 == null) goto L59;
            r12.onError(new ForwardErrorResultV3("IForwardImDependency is not registered", false));
            goto L59
        L26:
            StringBuilder r16 = new StringBuilder("start send message\n");
            Iterator<T> r17 = r15.iterator();
        L28:
            if (r17.hasNext() == false) goto L30;
            ForwardTargetBaseInfoNew r18 = (ForwardTargetBaseInfoNew) r17.next();
            StringBuilder r19 = new StringBuilder("target id is: ");
            r19.append(r18.a);
            r19.append(", type is: ");
            Constants$ForwardTargetType.a r20 = Constants$ForwardTargetType.Companion;
            int r21 = r18.getType();
            r20.getClass();
            r19.append(Constants$ForwardTargetType.a.a(r21));
            r19.append('\n');
            r16.append(r19.toString());
            goto L28
        L30:
            Log.i("ForwardSendServices", r16.toString());
            AtomicBoolean r22 = new AtomicBoolean(false);
            final Ref.ObjectRef r25 = new Ref.ObjectRef();
            final LinkedHashMap r26 = new LinkedHashMap();
            final LinkedHashMap r27 = new LinkedHashMap();
            final int r28 = r4.size();
            Map r29 = ForwardSendServices.d(r15, false);
            final int r210 = r29.size();
            final Ref.IntRef r30 = new Ref.IntRef();
            if (CollectionUtils.isEmpty(r29) == false) goto L33;
            Log.e("ForwardSendServices", "target_empty");
            boolean r31 = zib.b.d;
            Forward$Type.Companion.getClass();
            zib.b.d(Forward$Type.a.a(r24), -1001, "target_empty", "target_empty");
        L33:
            Iterator r32 = ((LinkedHashMap) r29).entrySet().iterator();
        L35:
            if (r32.hasNext() == false) goto L59;
            final Map.Entry r33 = (Map.Entry) r32.next();
            final Ref.IntRef r34 = new Ref.IntRef();
            Iterator r35 = r4.iterator();
        L38:
            if (r35.hasNext() == false) goto L35;
            p0.a r36 = (MessageParams.a) r35.next();
            if ((r36 instanceof p0.a) == true) goto L42;
            r4 = r4;
            final OnForwardContentListener r38 = r11;
            final IGetDataCallback<rib.d> r39 = r12;
            r13 = r13;
            r14 = r14;
            r15 = r15;
            f r110 = r10;
            ((MessageParams.a) r36).c = ((com.ss.android.lark.forwardv3.data.services.g) r33.getValue()).a;
            ((MessageParams.a) r36).b = ((com.ss.android.lark.forwardv3.data.services.g) r33.getValue()).c;
            ((MessageParams.a) r36).a = ((com.ss.android.lark.forwardv3.data.services.g) r33.getValue()).c;
            ((MessageParams.a) r36).i = ((com.ss.android.lark.forwardv3.data.services.g) r33.getValue()).c;
            ((MessageParams.a) r36).m = ((com.ss.android.lark.forwardv3.data.services.g) r33.getValue()).d;
            ((MessageParams.a) r36).n = MessageParams.CreateScene.COMMON_SHARE;
            MessageParams<?, ?> r37 = r36.a();
            Intrinsics.checkNotNull(r37);
            final AtomicBoolean r111 = r22;
            f r40 = r110;
            r40.sendMessage(r37, new ForwardSendServices$sendMessage$2$1$2(r33, r34, r28, r30, r111, r210, r14, r13, r15, r39, r38, r23, r25, r8, r26, r27, r24));
        L54:
            r4 = r4;
            r10 = r40;
            r22 = r22;
            r11 = r38;
            r12 = r39;
            r13 = r13;
            r14 = r14;
            r15 = r15;
            r9 = 0;
            goto L38
        L42:
            if ((((ForwardTargetBaseInfoNew) r33.getKey()) instanceof ForwardTargetThreadInfo) == true) goto L51;
            p0.a r41 = r36;
            ((MessageParams.a) r41).c = ((com.ss.android.lark.forwardv3.data.services.g) r33.getValue()).a;
            ((MessageParams.a) r41).h = Message.Type.IMAGE;
            String r42 = ((MessageParams.a) r41).c;
            Message.Type r43 = ((MessageParams.a) r41).h;
            Channel.Type r45 = Channel.Type.UNKNOWN;
            if (TextUtils.isEmpty(((MessageParams.a) r41).d) == false) goto L46;
            UUID.randomUUID().toString();
        L46:
            if (r42 == null) goto L50;
            if (r43 == null) goto L50;
            String r46 = r41.A;
            String r47 = ((com.ss.android.lark.forwardv3.data.services.g) r33.getValue()).a;
            String[] r48 = new String[1];
            r48[r9] = r46;
            f r310 = r10;
            final AtomicBoolean r112 = r22;
            r38 = r11;
            r39 = r12;
            final String r113 = r14;
            final List<ForwardTargetBaseInfoNew> r114 = r15;
            f r115 = r310;
            r115.sendImages(r47, CollectionsKt.arrayListOf(r48), true, new ForwardSendServices$sendMessage$2$1$1(r33, r34, r28, r30, r112, r210, r113, r13, r114, r39, r38, r23, r25, r8, r26, r27, r24));
        L52:
            r40 = r115;
        L50:
            throw new IllegalArgumentException("miss required field");
        L51:
            r38 = r11;
            r39 = r12;
            r115 = r10;
            goto L52
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r44);
            CoroutineDispatcher r49 = Dispatchers.getIO();
            ForwardV3ViewModel$performForward$1$messageParamsBuilders$1 r50 = new ForwardV3ViewModel$performForward$1$messageParamsBuilders$1(this.this$0, null);
            this.label = 1;
            r3 = BuildersKt.withContext(r49, r50, this);
            if (r3 != r1) goto L11;
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel$performShareForward$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel$performShareForward$1", f = "ForwardV3ViewModel.kt", i = {}, l = {676}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ IGetDataCallback<rib.d> $forwardContentCallbackInner;
        final /* synthetic */ String $note;
        final /* synthetic */ RichText $richText;
        int label;
        final /* synthetic */ ForwardV3ViewModel this$0;

        public C03831(ForwardV3ViewModel r1, Context r2, String r3, RichText r4, IGetDataCallback<rib.d> r5, Continuation<? super C03831> r6) {
            this.this$0 = r1;
            this.$context = r2;
            this.$note = r3;
            this.$richText = r4;
            this.$forwardContentCallbackInner = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new C03831(this.this$0, this.$context, this.$note, this.$richText, this.$forwardContentCallbackInner, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r21) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r21);
            Object r3 = r21;
        L13:
            ArrayList r4 = (ArrayList) r3;
        L16:
            if (r4 != null) goto L18;
        L65:
            Log.e("common_share_interface", "shareParamsBuilders is null");
            boolean r5 = zib.b.d;
            Forward$Type.a r6 = Forward$Type.Companion;
            int r7 = ForwardV3ViewModel.access$getTemplateNew$p(this.this$0).getType();
            r6.getClass();
            zib.b.d(Forward$Type.a.a(r7), -1001, "shareParamsBuilders is null", "shareParamsBuilders is null");
        L67:
            return Unit.INSTANCE;
        L18:
            if (CollectionUtils.isEmpty(r4) == true) goto L65;
            int r8 = ForwardSendServices.a;
            final Context r12 = this.$context;
            final List<ForwardTargetBaseInfoNew> r14 = this.this$0.getForwardTargets();
            final String r9 = this.$note;
            final RichText r10 = this.$richText;
            final IGetDataCallback<rib.d> r15 = this.$forwardContentCallbackInner;
            OnForwardContentListener r13 = this.this$0.getForwardContentListener();
            final d r11 = this.this$0.getForwardNoteListener();
            final int r16 = ForwardV3ViewModel.access$getTemplateNew$p(this.this$0).getType();
            Intrinsics.checkNotNullParameter(r12, "context");
            Intrinsics.checkNotNullParameter(r4, "shareOptionParams");
            Intrinsics.checkNotNullParameter(r14, "targets");
            Intrinsics.checkNotNullParameter(r9, "note");
            Intrinsics.checkNotNullParameter(r10, "richText");
            final LinkedHashMap r17 = new LinkedHashMap();
            final LinkedHashMap r18 = new LinkedHashMap();
            final ArrayList r19 = new ArrayList();
            ForwardSendServices.e(r17, r18, r19, r14);
            pib.d r20 = (pib.d) CollectionsKt.first(r4);
            Log.i("common_share_interface", "start share by  shareOptionParams type: " + r20.getType());
            BatchShareMessageRequest.Builder r22 = new BatchShareMessageRequest.Builder();
            if ((r20 instanceof pib.c) == false) goto L24;
            Log.i("common_share_interface", "createRequestBuilder params: " + r20);
            BatchShareMessageRequest.MessageShareOption.Builder r0 = new BatchShareMessageRequest.MessageShareOption.Builder();
            r0.message_id(r20.a);
            pib.c r23 = (pib.c) r20;
            r0.resource_key(r23.c);
            r0.origin_mergeforward_id(r23.d);
            r22.mmessage_share_option = r0.build();
            BatchShareMessageRequest.Scene r24 = BatchShareMessageRequest.Scene.CHAT_MESSAGE_SHARE;
        L30:
            r22.mscene = r24;
            ForwardTargetBaseInfoNew.CREATOR.getClass();
            Intrinsics.checkNotNullParameter(r14, "targets");
            List<ForwardTargetBaseInfoNew> r25 = r14;
            ArrayList r26 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r25, 10));
            Iterator r110 = r25.iterator();
        L32:
            if (r110.hasNext() == false) goto L48;
            ForwardTargetBaseInfoNew r27 = (ForwardTargetBaseInfoNew) r110.next();
            Iterator r111 = r110;
            if ((r27 instanceof ForwardTargetChatterInfo) == false) goto L37;
            String r28 = ((ForwardTargetChatterInfo) r27).h;
        L47:
            r26.add(r28);
            r110 = r111;
            r13 = r13;
            goto L32
        L37:
            if ((r27 instanceof ForwardTargetGroupChatInfo) == false) goto L40;
            r28 = ((ForwardTargetGroupChatInfo) r27).j;
            goto L47
        L40:
            if ((r27 instanceof ForwardTargetShieldP2PChatInfo) == false) goto L43;
            r28 = ((ForwardTargetShieldP2PChatInfo) r27).h;
            goto L47
        L43:
            if ((r27 instanceof ForwardTargetThreadInfo) == false) goto L46;
            r28 = ((ForwardTargetThreadInfo) r27).g.getId();
            goto L47
        L46:
            Log.w("NewForward", "Unknown ForwardTargetBaseInfoNew subtype");
            r28 = r27.a;
            goto L47
        L48:
            final OnForwardContentListener r112 = r13;
            r22.mchat_ids = r26;
            ForwardTargetBaseInfoNew.CREATOR.getClass();
            Intrinsics.checkNotNullParameter(r14, "targets");
            ArrayList r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r25, 10));
            Iterator<T> r30 = r25.iterator();
        L50:
            if (r30.hasNext() == false) goto L64;
            ForwardTargetBaseInfoNew r31 = (ForwardTargetBaseInfoNew) r30.next();
            BatchShareMessageRequest.TargetInfo.Builder r32 = new BatchShareMessageRequest.TargetInfo.Builder();
            r32.cid(UUID.randomUUID().toString());
            if ((r31 instanceof ForwardTargetShieldP2PChatInfo) == false) goto L55;
            ForwardTargetShieldP2PChatInfo r33 = (ForwardTargetShieldP2PChatInfo) r31;
            r32.target_id(r33.h);
            r32.target_type(BatchShareMessageRequest.TargetInfo.TargetType.CHAT);
            Log.i("common_share_interface", "ShieldP2P_p2pChatId: " + r33.h);
        L63:
            r29.add(r32.build());
            goto L50
        L55:
            if ((r31 instanceof ForwardTargetChatterInfo) == false) goto L58;
            ForwardTargetChatterInfo r34 = (ForwardTargetChatterInfo) r31;
            r32.target_id(r34.h);
            r32.target_type(BatchShareMessageRequest.TargetInfo.TargetType.CHAT);
            Log.i("common_share_interface", "Chatter_p2pChatId: " + r34.h);
            goto L63
        L58:
            if ((r31 instanceof ForwardTargetGroupChatInfo) == false) goto L61;
            ForwardTargetGroupChatInfo r35 = (ForwardTargetGroupChatInfo) r31;
            r32.target_id(r35.j);
            r32.target_type(BatchShareMessageRequest.TargetInfo.TargetType.CHAT);
            Log.i("common_share_interface", "group_chatId: " + r35.j);
            goto L63
        L61:
            if ((r31 instanceof ForwardTargetThreadInfo) == false) goto L63;
            ForwardTargetThreadInfo r36 = (ForwardTargetThreadInfo) r31;
            r32.target_id(r36.h);
            r32.target_type(BatchShareMessageRequest.TargetInfo.TargetType.THREAD);
            Log.i("common_share_interface", "thread_threadId: " + r36.h);
            goto L63
        L64:
            r22.mtargets = r29;
            SdkSender.sendPassThroughRequest(Command.BATCH_SHARE_MESSAGE, r22, new ForwardSendServices$share$1$1(r9, r10, r18, r17, r19, r11, r12, r112, r14, r15, r16), com.ss.android.lark.forwardv3.data.services.f.a);
            goto L67
        L24:
            if ((r20 instanceof pib.a) == false) goto L27;
            Log.i("common_share_interface", "createRequestBuilder params: " + r20);
            BatchShareMessageRequest.FavShareOption.Builder r37 = new BatchShareMessageRequest.FavShareOption.Builder();
            r37.message_id(r20.a);
            pib.a r38 = (pib.a) r20;
            r37.resource_key(r38.c);
            r37.fav_id(r38.d);
            r22.mfav_share_option = r37.build();
            r24 = BatchShareMessageRequest.Scene.FAV_MESSAGE_SHARE;
            goto L30
        L27:
            if ((r20 instanceof pib.b) == false) goto L29;
            Log.i("common_share_interface", "createRequestBuilder params: " + r20);
            BatchShareMessageRequest.FlagShareOption.Builder r39 = new BatchShareMessageRequest.FlagShareOption.Builder();
            r39.message_id(r20.a);
            pib.b r40 = (pib.b) r20;
            r39.resource_key(r40.c);
            r39.origin_mergeforward_id(r40.d);
            r22.mflag_share_option = r39.build();
            r24 = BatchShareMessageRequest.Scene.FLAG_MESSAGE_SHARE;
            goto L30
        L29:
            r24 = null;
            goto L30
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r21);
            Deferred r41 = ForwardV3ViewModel.access$getShareDeferred$p(this.this$0);
            if (r41 == null) goto L14;
            this.label = 1;
            r3 = r41.await(this);
            if (r3 != r1) goto L13;
            return r1;
        L14:
            r4 = null;
            goto L16
        }
    }

    static {
        Companion = new a();
    }

    private static /* synthetic */ void getLocalDataStatus$annotations() {
    }

    private static /* synthetic */ void getNetDataStatus$annotations() {
    }

    private final void initConvertHandler() {
        Iterator r0 = SequencesKt.asSequence(PluginServiceLoader.loadAll(g.class)).iterator();
    L3:
        h<IForwardContent> r4 = null;
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((g) r1).getType() != this.templateNew.getType()) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L3;
    L13:
        if ((r1 instanceof g) == false) goto L15;
        g<IForwardContent> r2 = (g) r1;
    L16:
        this.messageParamConvertHandler = r2;
        Iterator r3 = SequencesKt.asSequence(PluginServiceLoader.loadAll(h.class)).iterator();
    L18:
        if (r3.hasNext() == false) goto L25;
        Object r6 = r3.next();
        if (((h) r6).getType() != this.templateNew.getType()) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == false) goto L18;
    L27:
        if ((r6 instanceof h) == false) goto L29;
        r4 = (h) r6;
    L29:
        this.shareParamConvertHandler = r4;
        if (r4 == null) goto L32;
    L34:
        Forward$Type.a r8 = Forward$Type.Companion;
        int r9 = this.templateNew.getType();
        r8.getClass();
        Log.i(TAG, "get convert handler, type: ".concat(Forward$Type.a.a(r9)));
        return;
    L32:
        if (this.messageParamConvertHandler != null) goto L34;
        StringBuilder r10 = new StringBuilder("convert handler is null, type: ");
        Forward$Type.a r11 = Forward$Type.Companion;
        int r12 = this.templateNew.getType();
        r11.getClass();
        r10.append(Forward$Type.a.a(r12));
        r10.append(" doesn't match");
        Log.i(TAG, r10.toString());
        return;
    L22:
        r7 = false;
        goto L23
    L25:
        r6 = null;
        goto L27
    L15:
        r2 = null;
        goto L16
    L8:
        r5 = false;
        goto L9
    L11:
        r1 = null;
        goto L13
    }

    public final void clearSelectedItem() {
        this._selectedItem.setValue(new LinkedHashMap());
    }

    public final String customDisableToastText() {
        ForwardTargetConfig r0 = this.templateNew.getForwardTargetConfig();
        if (r0.f == null) goto L5;
    L7:
        com.ss.android.lark.forwardv3.configuration.f r1 = r0.f;
        if (r1 == null) goto L11;
        String r2 = r1.customDisableToastText();
        if (r2 == null) goto L11;
        return r2;
    L11:
        return "";
    L5:
        if (r0.g == null) goto L7;
        r0.f = new com.ss.android.lark.forwardv3.configuration.f(r0);
        goto L7
    }

    public final boolean getEnableRecentForward() {
        if (this.enableRecentForward == false) goto L7;
        com.ss.android.lark.forwardv3.utils.b.d();
        return false;
    L7:
        return false;
    }

    public final ConfigUtils.b getSearchPickerParams() {
        int r0 = ConfigUtils.a;
        IncludeConfig r1 = this.templateNew.getForwardTargetConfig().d;
        ConfigUtils.b r2 = new ConfigUtils.b();
        if (r1 != null) goto L5;
    L39:
        return r2;
    L5:
        if (CollectionUtils.isEmpty(r1.a) == true) goto L39;
        Iterator r3 = ((ArrayList) r1.a).iterator();
    L9:
        if (r3.hasNext() == false) goto L39;
        EntityItem r4 = (EntityItem) r3.next();
        UserConfig r5 = r4.a;
        if (r5 == null) goto L20;
        Condition$Tenant r6 = r5.getTenant();
        int r7 = ConfigUtils.c.b[r6.ordinal()];
        if (r7 == 1) goto L19;
        if (r7 == 2) goto L20;
        if (r7 != 3) goto L18;
        r2.c = false;
        goto L20
    L18:
        throw new NoWhenBranchMatchedException();
    L19:
        r2.c = true;
        r2.a = false;
    L20:
        GroupConfig r8 = r4.b;
        if (r8 == null) goto L31;
        Condition$Tenant r9 = r8.getTenant();
        int r10 = ConfigUtils.c.b[r9.ordinal()];
        if (r10 == 1) goto L29;
        if (r10 == 2) goto L31;
        if (r10 != 3) goto L28;
        r2.b = false;
        goto L31
    L28:
        throw new NoWhenBranchMatchedException();
    L29:
        r2.b = true;
    L31:
        if (r4.c == null) goto L34;
        r2.d = true;
    L34:
        if (r4.d == null) goto L37;
        r2.e = true;
    L37:
        if (r4.e == null) goto L9;
        r2.f = true;
        goto L9
    }

    public final List<SearchBaseInfo> getSelectedItemList() {
        ArrayList r0 = new ArrayList();
        Map r1 = (Map) this._selectedItem.getValue();
        if (r1 == null) goto L6;
        Collection r2 = r1.values();
        if (r2 == null) goto L6;
    L7:
        r0.addAll(r2);
        return r0;
    L6:
        r2 = CollectionsKt.emptyList();
        goto L7
    }

    public final com.ss.android.lark.forwardv3.data.a getTitleBarShowInfo() {
        int r1 = n.a;
        boolean r2 = this.enableSwitchSelectMode;
        Integer r3 = (Integer) this._selectMode.getValue();
        boolean r4 = false;
        if (r3 != null) goto L6;
    L8:
        boolean r5 = false;
    L9:
        Map r6 = (Map) this._selectedItem.getValue();
        if (r6 == null) goto L12;
        int r7 = r6.size();
    L13:
        if (r7 == 0) goto L16;
        r4 = true;
    L16:
        if (r2 == false) goto L20;
        if (r5 == true) goto L20;
        if (r4 == true) goto L20;
        return new com.ss.android.lark.forwardv3.data.a(true, true, y9c.d.h(2131892181), 2131106622, false, 1);
    L20:
        if (r2 == false) goto L24;
        if (r5 == true) goto L24;
        if (r4 == false) goto L24;
        return new com.ss.android.lark.forwardv3.data.a(true, true, y9c.d.h(2131892181), 2131106622, false, 1);
    L24:
        if (r2 == false) goto L29;
        if (r5 == false) goto L29;
        if (r4 == true) goto L29;
        return new com.ss.android.lark.forwardv3.data.a(true, true, y9c.d.h(2131892187), 2131106622, true, 0);
    L29:
        if (r2 == false) goto L33;
        if (r5 == false) goto L33;
        if (r4 == false) goto L33;
        return new com.ss.android.lark.forwardv3.data.a(true, true, y9c.d.j(2131892073, "count", String.valueOf(r7)), 2131105576, true, 2);
    L33:
        if (r2 == true) goto L37;
        if (r5 == true) goto L37;
        if (r4 == true) goto L37;
        return new com.ss.android.lark.forwardv3.data.a(false, false, "", 2131106622, false, 3);
    L37:
        if (r2 == true) goto L41;
        if (r5 == true) goto L41;
        if (r4 == false) goto L41;
        return new com.ss.android.lark.forwardv3.data.a(false, false, "", 2131106622, false, 3);
    L41:
        if (r2 == true) goto L46;
        if (r5 == false) goto L46;
        if (r4 == true) goto L46;
        return new com.ss.android.lark.forwardv3.data.a(true, false, y9c.d.h(2131891627), 2131106622, false, 3);
    L46:
        return new com.ss.android.lark.forwardv3.data.a(true, true, y9c.d.j(2131892073, "count", String.valueOf(r7)), 2131105576, false, 2);
    L12:
        r7 = 0;
        goto L13
    L6:
        if (r3.intValue() != 1) goto L8;
        r5 = true;
        goto L9
    }

    public final void init() {
        this.resultCode = this.templateNew.getForwardCommonConfig().a;
        this.showTitleBar = this.templateNew.getForwardCommonConfig().b;
        this.titleBarText = this.templateNew.getForwardCommonConfig().e;
        this.enableSwitchSelectMode = this.templateNew.getForwardSelectConfig().a;
        this.defaultSingleSelectMode = this.templateNew.getForwardSelectConfig().b;
        this.enableChatPreview = this.templateNew.getForwardTargetConfig().a;
        this.enableExternalTarget = this.templateNew.getForwardTargetConfig().c;
        this.maxLimitSelectNum = this.templateNew.getForwardSelectConfig().c;
        this.enableCreateGroupChat = this.templateNew.getForwardCommonConfig().c;
        this.enableRecentForward = this.templateNew.getForwardCommonConfig().d;
        this.dialogTitleBarText = this.templateNew.getForwardConfirmDialogConfig().a;
        this.confirmButtonText = this.templateNew.getForwardConfirmDialogConfig().b;
        this.cancelButtonText = this.templateNew.getForwardConfirmDialogConfig().c;
        this.enableAdditionNote = this.templateNew.getForwardAdditionNoteConfig().a;
        this.enableAdditionNoteAT = this.templateNew.getForwardAdditionNoteConfig().b;
        BasicDialogContentConfig r0 = this.templateNew.getForwardConfirmDialogConfig().d;
        if (r0 != null) goto L5;
        r0 = new BasicDialogContentConfig();
    L5:
        this.dialogContent = r0;
        ForwardSelectConfig r1 = this.templateNew.getForwardSelectConfig();
        if (r1.d == null) goto L8;
    L10:
        this.cancelMultiSelectListener = r1.d;
        ForwardCommonConfig r2 = this.templateNew.getForwardCommonConfig();
        if (r2.g == null) goto L13;
    L15:
        this.closeForwardListener = r2.g;
        ForwardConfirmDialogConfig r3 = this.templateNew.getForwardConfirmDialogConfig();
        if (r3.f == null) goto L18;
    L20:
        this.confirmDialogListener = r3.f;
        this.customConfirmDialogContentView = this.templateNew.getForwardConfirmDialogConfig().e;
        this.enableBackOriginalApplication = this.templateNew.getForwardCommonConfig().f;
        this.forwardContentListener = this.templateNew.getForwardCommonConfig().i;
        ForwardAdditionNoteConfig r4 = this.templateNew.getForwardAdditionNoteConfig();
        if (r4.c == null) goto L23;
    L25:
        this.forwardNoteListener = r4.c;
        this.forwardContent = this.templateNew.getForwardContent();
        Message r5 = null;
        if (this.enableExternalTarget == false) goto L28;
        String r6 = ForwardModuleV3.a().getExternalTargetId();
    L29:
        this.externalTargetId = r6;
        if (this.enableExternalTarget == false) goto L37;
        IForwardContent r7 = this.forwardContent;
        yib.c.a.getClass();
        if (com.ss.android.lark.forwardv3.doubao.f.a(r7) <= yib.c.a()) goto L34;
        boolean r8 = true;
    L35:
        if (r8 == false) goto L37;
        boolean r9 = true;
    L38:
        this.disableExternalTargetByMessageCount = r9;
        Log.i(TAG, "external target message count limit: enableExternalTarget=" + this.enableExternalTarget + ", disableByMessageCount=" + this.disableExternalTargetByMessageCount);
        this.source = this.templateNew.getSource();
        WeakReference<Message> r10 = ForwardDataUtils.a;
        if (com.ss.android.lark.forwardv3.utils.b.c() == false) goto L41;
        Message r11 = ForwardDataUtils.b;
        ForwardDataUtils.b = null;
    L46:
        this.sourceMessage = r11;
        IForwardContent r12 = this.templateNew.getForwardContent();
        if ((r12 instanceof SingleMessageForwardContent) == false) goto L50;
        r5 = this.sourceMessage;
    L53:
        this.displayMessage = r5;
        if (this.sourceMessage == null) goto L58;
        OnCustomForwardConfirmDialogContentView r13 = this.customConfirmDialogContentView;
        if (r13 == null) goto L59;
        r13.U0();
    L59:
        MutableLiveData<Integer> r14 = this._selectMode;
        if (this.templateNew.getForwardSelectConfig().b == false) goto L62;
        int r15 = 0;
    L63:
        r14.setValue(r15);
        this._selectedItem.setValue(new HashMap());
        initConvertHandler();
        this._recommendData.setValue(new sib.a.C0325a());
        return;
    L62:
        r15 = 1;
        goto L63
    L58:
        Log.i(TAG, "sourceMessage is empty");
        goto L59
    L50:
        if ((r12 instanceof MergeMessageForwardContent) == true) goto L53;
        boolean r16 = r12 instanceof OneByOneMessageForwardContent;
        goto L53
    L41:
        WeakReference<Message> r17 = ForwardDataUtils.a;
        if (r17 == null) goto L44;
        r11 = r17.get();
    L45:
        ForwardDataUtils.a = null;
        goto L46
    L44:
        r11 = null;
        goto L45
    L34:
        r8 = false;
    L37:
        r9 = false;
        goto L38
    L28:
        r6 = null;
        goto L29
    L23:
        if (r4.d == null) goto L25;
        r4.c = new com.ss.android.lark.forwardv3.configuration.b(r4);
        goto L25
    L18:
        if (r3.g == null) goto L20;
        r3.f = new com.ss.android.lark.forwardv3.configuration.d(r3);
        goto L20
    L13:
        if (r2.h == null) goto L15;
        r2.g = new com.ss.android.lark.forwardv3.configuration.c(r2);
        goto L15
    L8:
        if (r1.e == null) goto L10;
        r1.d = new e(r1);
        goto L10
    }

    public final void switchSelectMode() {
        MutableLiveData<Integer> r0 = this._selectMode;
        Integer r1 = (Integer) r0.getValue();
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L6:
        r0.setValue(Integer.valueOf((r2 + 1) % 2));
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public final String getCancelButtonText() {
        return this.cancelButtonText;
    }

    public final oib.a getCancelMultiSelectListener() {
        return this.cancelMultiSelectListener;
    }

    public final oib.b getCloseForwardListener() {
        return this.closeForwardListener;
    }

    public final String getConfirmButtonText() {
        return this.confirmButtonText;
    }

    public final c getConfirmDialogListener() {
        return this.confirmDialogListener;
    }

    public final OnCustomForwardConfirmDialogContentView getCustomConfirmDialogContentView() {
        return this.customConfirmDialogContentView;
    }

    public final boolean getDefaultSingleSelectMode() {
        return this.defaultSingleSelectMode;
    }

    public final BasicDialogContentConfig getDialogContent() {
        return this.dialogContent;
    }

    public final String getDialogTitleBarText() {
        return this.dialogTitleBarText;
    }

    public final Message getDisplayMessage() {
        return this.displayMessage;
    }

    public final boolean getEnableAdditionNote() {
        return this.enableAdditionNote;
    }

    public final boolean getEnableAdditionNoteAT() {
        return this.enableAdditionNoteAT;
    }

    public final boolean getEnableBackOriginalApplication() {
        return this.enableBackOriginalApplication;
    }

    public final boolean getEnableChatPreview() {
        return this.enableChatPreview;
    }

    public final boolean getEnableCreateGroupChat() {
        return this.enableCreateGroupChat;
    }

    public final boolean getEnableExternalTarget() {
        return this.enableExternalTarget;
    }

    public final boolean getEnableSwitchSelectMode() {
        return this.enableSwitchSelectMode;
    }

    public final IForwardContent getForwardContent() {
        return this.forwardContent;
    }

    public final OnForwardContentListener getForwardContentListener() {
        return this.forwardContentListener;
    }

    public final d getForwardNoteListener() {
        return this.forwardNoteListener;
    }

    public final List<ForwardTargetBaseInfoNew> getForwardTargets() {
        return this.forwardTargets;
    }

    public final int getMaxLimitSelectNum() {
        return this.maxLimitSelectNum;
    }

    public final LiveData<sib.a<rib.b, Throwable>> getRecommendData() {
        return this.recommendData;
    }

    public final Integer getResultCode() {
        return this.resultCode;
    }

    public final LiveData<Integer> getSelectMode() {
        return this.selectMode;
    }

    public final LiveData<Map<String, SearchBaseInfo>> getSelectedItem() {
        return this.selectedItem;
    }

    public final boolean getShowTitleBar() {
        return this.showTitleBar;
    }

    public final Forward$Source getSource() {
        return this.source;
    }

    public final Message getSourceMessage() {
        return this.sourceMessage;
    }

    public final String getTitleBarText() {
        return this.titleBarText;
    }

    public ForwardV3ViewModel(ForwardTemplateNew r3) {
        Intrinsics.checkNotNullParameter(r3, "templateNew");
        this.templateNew = r3;
        this.showTitleBar = true;
        this.titleBarText = "";
        this.enableSwitchSelectMode = true;
        this.defaultSingleSelectMode = true;
        this.enableChatPreview = true;
        this.maxLimitSelectNum = 10;
        this.enableCreateGroupChat = true;
        this.enableRecentForward = true;
        this.dialogTitleBarText = "";
        this.confirmButtonText = "";
        this.cancelButtonText = "";
        this.enableAdditionNote = true;
        this.enableAdditionNoteAT = true;
        this.dialogContent = new BasicDialogContentConfig();
        this.forwardTargets = new ArrayList();
        MutableLiveData<sib.a<rib.b, Throwable>> r4 = new MutableLiveData();
        this._recommendData = r4;
        this.recommendData = r4;
        MutableLiveData<Integer> r5 = new MutableLiveData();
        this._selectMode = r5;
        this.selectMode = r5;
        MutableLiveData<Map<String, SearchBaseInfo>> r6 = new MutableLiveData();
        this._selectedItem = r6;
        this.selectedItem = r6;
        this.source = Forward$Source.UNKNOWN;
    }

    public static final /* synthetic */ boolean access$getLocalDataHasUpdate$p(ForwardV3ViewModel r0) {
        return r0.localDataHasUpdate;
    }

    public static final /* synthetic */ int access$getLocalDataStatus$p(ForwardV3ViewModel r0) {
        return r0.localDataStatus;
    }

    public static final /* synthetic */ Deferred access$getMessageDeferred$p(ForwardV3ViewModel r0) {
        return r0.messageDeferred;
    }

    public static final /* synthetic */ g access$getMessageParamConvertHandler$p(ForwardV3ViewModel r0) {
        return r0.messageParamConvertHandler;
    }

    public static final /* synthetic */ int access$getNetDataStatus$p(ForwardV3ViewModel r0) {
        return r0.netDataStatus;
    }

    public static final /* synthetic */ Deferred access$getShareDeferred$p(ForwardV3ViewModel r0) {
        return r0.shareDeferred;
    }

    public static final /* synthetic */ h access$getShareParamConvertHandler$p(ForwardV3ViewModel r0) {
        return r0.shareParamConvertHandler;
    }

    public static final /* synthetic */ ForwardTemplateNew access$getTemplateNew$p(ForwardV3ViewModel r0) {
        return r0.templateNew;
    }

    public static final /* synthetic */ MutableLiveData access$get_recommendData$p(ForwardV3ViewModel r0) {
        return r0._recommendData;
    }

    private final void insertAIKnowledgeIfNeed(rib.b r8) {
        List<SearchBaseInfo> r0 = r8.a;
        if (this.templateNew.getForwardTargetConfig().b == false) goto L32;
        List<SearchBaseInfo> r1 = r0;
        if ((r1 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L8;
        boolean r5 = true;
        if (((SearchBaseInfo) r2.next()).getType() != 26) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L11;
    L18:
        if (r5 == false) goto L21;
        Log.i(TAG, "ai knowledge is already in list");
        return;
    L21:
        int r6 = 4;
        if (r0.size() > 4) goto L25;
        r6 = r0.size();
    L25:
        Log.i(TAG, "insert ai knowledge at index: " + r6);
        WeakReference<Message> r4 = ForwardDataUtils.a;
        SearchAiKnowledgeInfo r7 = new SearchAiKnowledgeInfo();
        Intrinsics.checkNotNullParameter(r7, "<this>");
        r7.setHeaderId(0);
        r7.setHeaderLabel(ForwardDataUtils.d);
        r7.setScene(Scene.Type.TRANSMIT_MESSAGES);
        r7.setId("forward_ai_knowledge_id");
        r7.setType(26);
        r7.setTitle(UIHelper.getString(2131891129));
        ListProtector.add(r0, r6, r7);
        Log.i(TAG, "insert ai knowledge success, size: " + r0.size());
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r8.a = r0;
        return;
    L15:
        r3 = false;
    L8:
        r5 = false;
        goto L18
    L7:
        if (r1.isEmpty() == false) goto L9;
    }

    private final void insertExternalTargetIfNeed(rib.b r8) {
        if (this.enableExternalTarget == true) goto L6;
        Log.i(TAG, "insertExternalTargetIfNeed skip, disabled");
        return;
    L6:
        List<SearchBaseInfo> r0 = r8.a;
        tib.g r2 = ForwardModuleV3.a();
        String r3 = this.externalTargetId;
        if (r3 != null) goto L10;
        Log.w(TAG, "insertExternalTargetIfNeed skip, external target id is null");
        return;
    L10:
        tib.a r4 = r2.getExternalTargetItem();
        if (r4 != null) goto L14;
        Log.w(TAG, "insertExternalTargetIfNeed skip, external target item is null");
        return;
    L14:
        List<SearchBaseInfo> r5 = r0;
        if ((r5 instanceof Collection) == true) goto L17;
    L19:
        Iterator<T> r6 = r5.iterator();
    L21:
        if (r6.hasNext() == false) goto L25;
        if (Intrinsics.areEqual(((SearchBaseInfo) r6.next()).getId(), r3) == false) goto L21;
        boolean r7 = true;
    L26:
        if (r7 == false) goto L29;
        Log.i(TAG, "insertExternalTargetIfNeed skip, duplicated target id: ".concat(r3));
        return;
    L29:
        int r1 = r0.size();
        Integer r9 = r4.c;
        if (r9 == null) goto L32;
        int r10 = RangesKt.coerceAtLeast(r9.intValue() - 1, 0);
    L33:
        int r11 = RangesKt.coerceAtMost(r10, r1);
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, "externalTargetId");
        ExternalTargetAvatarProviderStore.INSTANCE.register(r4.a);
        SearchChatInfo r12 = new SearchChatInfo();
        r12.setId(r3);
        r12.setTitle(r4.b);
        r12.setAvatarKey("");
        r12.setHeaderId(0);
        r12.setHeaderLabel(ForwardDataUtils.d);
        r12.setExtraParams(MapsKt.mapOf(TuplesKt.to("external_target_avatar_provider_marker", Boolean.TRUE)));
        ListProtector.add(r0, r11, r12);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r8.a = r0;
        return;
    L32:
        r10 = 0;
    L25:
        r7 = false;
        goto L26
    L17:
        if (r5.isEmpty() == false) goto L19;
        goto L19
    }

    public final Object asyncLoadMessageParams(Continuation<? super Unit> r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(this, null), 3, null);
        return Unit.INSTANCE;
    }

    public final int createGroupChatDisableToastText(SearchBaseInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        int r1 = ConfigUtils.a;
        Intrinsics.checkNotNullParameter(r3, "data");
        if ((r3 instanceof SearchChatterInfo) == false) goto L14;
        SearchChatterInfo r0 = (SearchChatterInfo) r3;
        if (r0.isHasOUPermission() == true) goto L8;
        return 2131890862;
    L8:
        if (r0.isBlock() == false) goto L11;
        return 2131892420;
    L11:
        if (ForwardModuleV3.a().getLoginUserAuthorityDeniedReason() != r0.getDeniedReason()) goto L14;
        return 2131890554;
    L14:
        if ((r3 instanceof SearchChatInfo) == true) goto L16;
    L18:
        return 0;
    L16:
        if (((SearchChatInfo) r3).isCrossTenant() == false) goto L18;
        return 2131892779;
    }

    public final boolean customDisable(SearchBaseInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        ForwardTargetBaseInfoNew r4 = ForwardDataUtils.f(r3);
        if (r4 == null) goto L15;
        ForwardTargetConfig r0 = this.templateNew.getForwardTargetConfig();
        if (r0.f == null) goto L7;
    L9:
        com.ss.android.lark.forwardv3.configuration.f r1 = r0.f;
        if (r1 == null) goto L12;
        Boolean r5 = Boolean.valueOf(r1.customDisable(r4));
    L13:
        if (r5 == null) goto L15;
        return r5.booleanValue();
    L12:
        r5 = null;
        goto L13
    L7:
        if (r0.g == null) goto L9;
        r0.f = new com.ss.android.lark.forwardv3.configuration.f(r0);
    L15:
        return false;
    }

    public final boolean disable(SearchBaseInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        int r1 = ConfigUtils.a;
        DisableConfig r2 = this.templateNew.getForwardTargetConfig().e;
        Intrinsics.checkNotNullParameter(r3, "info");
        if (r2 != null) goto L5;
    L8:
        return false;
    L5:
        if (((ArrayList) r2.a).isEmpty() == true) goto L8;
        return ConfigUtils.a(r2.a, r3);
    }

    public final boolean disableByInclude(SearchBaseInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "searchBaseInfo");
        if ((r4 instanceof SearchChatInfo) == false) goto L5;
    L12:
        int r0 = ConfigUtils.a;
        IncludeConfig r1 = this.templateNew.getForwardTargetConfig().d;
        Intrinsics.checkNotNullParameter(r4, "info");
        if (r1 != null) goto L15;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == true) goto L23;
        return true;
    L23:
        return false;
    L15:
        if (((ArrayList) r1.a).isEmpty() == true) goto L18;
        r5 = ConfigUtils.a(r1.a, r4);
        goto L19
    L5:
        if ((r4 instanceof SearchChatterInfo) == true) goto L12;
        if ((r4 instanceof SearchShieldP2PChatInfo) == true) goto L12;
        if ((r4 instanceof SearchThreadInfo) == true) goto L12;
        if ((r4 instanceof SearchReplyInThreadInfo) == true) goto L12;
        return false;
    }

    public final void getSearchPickerV2Params(SearcherConfig r4) {
        Intrinsics.checkNotNullParameter(r4, "searcherConfig");
        int r0 = ConfigUtils.a;
        ConfigUtils.c(r4, this.templateNew.getForwardTargetConfig().d);
        boolean r1 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable(FG_KEY_PICKER_SUPPORT_ADD_BOT);
        r4.getEntities().remove(Reflection.getOrCreateKotlinClass(AI.class));
        if (r1 == true) goto L6;
        r4.getEntities().remove(Reflection.getOrCreateKotlinClass(Bot.class));
        Log.i(TAG, "remove bot");
        return;
    }

    public final boolean isDisableByCreateGroupChat(SearchBaseInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "searchBaseInfo");
        int r0 = ConfigUtils.a;
        Intrinsics.checkNotNullParameter(r2, "data");
        if ((r2 instanceof SearchChatterInfo) == false) goto L12;
        SearchChatterInfo r3 = (SearchChatterInfo) r2;
        if (r3.isHasOUPermission() == true) goto L7;
    L10:
        return true;
    L7:
        if (r3.isBlock() == true) goto L10;
        if (ForwardModuleV3.a().getLoginUserAuthorityDeniedReason() == r3.getDeniedReason()) goto L10;
    L14:
        return false;
    L12:
        if ((r2 instanceof SearchChatInfo) == false) goto L14;
        return ((SearchChatInfo) r2).isCrossTenant();
    }

    public final boolean isExternalTargetDisabledByMessageCount(SearchBaseInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "info");
        String r0 = this.externalTargetId;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (this.disableExternalTargetByMessageCount == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(r4.getId(), r0) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public final void setResultCode(Integer r1) {
        this.resultCode = r1;
    }

    public final void setSource(Forward$Source r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.source = r2;
    }

    public static final /* synthetic */ void access$insertAIKnowledgeIfNeed(ForwardV3ViewModel r0, rib.b r1) {
        r0.insertAIKnowledgeIfNeed(r1);
    }

    public static final /* synthetic */ void access$insertExternalTargetIfNeed(ForwardV3ViewModel r0, rib.b r1) {
        r0.insertExternalTargetIfNeed(r1);
    }

    public static final /* synthetic */ void access$setLocalDataHasUpdate$p(ForwardV3ViewModel r0, boolean r1) {
        r0.localDataHasUpdate = r1;
    }

    public static final /* synthetic */ void access$setLocalDataStatus$p(ForwardV3ViewModel r0, int r1) {
        r0.localDataStatus = r1;
    }

    public static final /* synthetic */ void access$setMessageDeferred$p(ForwardV3ViewModel r0, Deferred r1) {
        r0.messageDeferred = r1;
    }

    public static final /* synthetic */ void access$setNetDataStatus$p(ForwardV3ViewModel r0, int r1) {
        r0.netDataStatus = r1;
    }

    public static final /* synthetic */ void access$setShareDeferred$p(ForwardV3ViewModel r0, Deferred r1) {
        r0.shareDeferred = r1;
    }

    public final void loadRecommendData(long r18, boolean r20) {
        Log.i(TAG, "start load recommend data, from local: " + r20);
        long r1 = SystemClock.elapsedRealtime();
        int r0 = ConfigUtils.a;
        IncludeConfig r2 = this.templateNew.getForwardTargetConfig().d;
        DisableConfig r4 = this.templateNew.getForwardTargetConfig().e;
        int r5 = ConfigUtils.a.g;
        boolean r6 = false;
        ConfigUtils.a r7 = ConfigUtils.a.C0076a.a(false);
        if (r4 != null) goto L5;
    L71:
        int r8 = ConfigUtils.a.g;
        ConfigUtils.a r9 = ConfigUtils.a.C0076a.a(true);
        if (r2 != null) goto L74;
    L167:
        ConfigUtils.a r3 = new ConfigUtils.a();
        if (r7.a == false) goto L170;
    L173:
        boolean r10 = true;
    L174:
        r3.a = r10;
        if (r7.b == false) goto L177;
    L180:
        boolean r11 = true;
    L181:
        r3.b = r11;
        if (r7.c == false) goto L184;
    L187:
        boolean r12 = true;
    L188:
        r3.c = r12;
        if (r7.d == false) goto L191;
    L194:
        boolean r13 = true;
    L195:
        r3.d = r13;
        if (r7.e == false) goto L198;
    L201:
        boolean r14 = true;
    L202:
        r3.e = r14;
        if (r9.f == true) goto L205;
    L207:
        r3.f = r6;
        StringBuilder r15 = new StringBuilder();
        r15.append("   filterGroupChat is: " + r3.a + '\n');
        r15.append("   filterP2PChat is: " + r3.b + '\n');
        r15.append("   filterThreadChat is: " + r3.c + '\n');
        r15.append("   filterCrossTenant is: " + r3.d + '\n');
        r15.append("   filterMySelf is: " + r3.e + '\n');
        r15.append("   includeAI is: " + r3.f + '\n');
        Log.i("NewForward", r15.toString());
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(r1, r20, this, r18, null), 3, null);
        return;
    L205:
        if (r7.f == false) goto L207;
        r6 = true;
        goto L207
    L198:
        if (r9.e == true) goto L201;
        r14 = false;
        goto L202
    L191:
        if (r9.d == true) goto L194;
        r13 = false;
        goto L195
    L184:
        if (r9.c == true) goto L187;
        r12 = false;
        goto L188
    L177:
        if (r9.b == true) goto L180;
        r11 = false;
        goto L181
    L170:
        if (r9.a == true) goto L173;
        r10 = false;
        goto L174
    L74:
        if (CollectionUtils.isEmpty(r2.a) == true) goto L167;
        Iterator r16 = ((ArrayList) r2.a).iterator();
        boolean r17 = false;
        boolean r19 = false;
    L78:
        if (r16.hasNext() == false) goto L115;
        EntityItem r110 = (EntityItem) r16.next();
        UserConfig r111 = r110.a;
        if (r111 == null) goto L97;
        int r112 = ConfigUtils.c.a[r111.getUserType().ordinal()];
        if (r112 == 1) goto L88;
        if (r112 == 2) goto L88;
        if (r112 != 3) goto L87;
        r9.e = true;
    L89:
        int r113 = ConfigUtils.c.b[r111.getTenant().ordinal()];
        if (r113 == 1) goto L96;
        if (r113 == 2) goto L96;
        if (r113 != 3) goto L95;
        r19 = true;
        goto L97
    L95:
        throw new NoWhenBranchMatchedException();
    L96:
        r19 = false;
        goto L97
    L87:
        throw new NoWhenBranchMatchedException();
    L88:
        r9.e = false;
    L97:
        GroupConfig r114 = r110.b;
        if (r114 == null) goto L78;
        int r115 = ConfigUtils.c.c[r114.getGroupType().ordinal()];
        if (r115 == 1) goto L106;
        if (r115 == 2) goto L106;
        if (r115 != 3) goto L105;
        r9.c = true;
    L107:
        int r116 = ConfigUtils.c.b[r114.getTenant().ordinal()];
        if (r116 == 1) goto L114;
        if (r116 == 2) goto L114;
        if (r116 != 3) goto L113;
        r17 = true;
        goto L78
    L113:
        throw new NoWhenBranchMatchedException();
    L114:
        r17 = false;
        goto L78
    L105:
        throw new NoWhenBranchMatchedException();
    L106:
        r9.c = false;
        goto L107
    L115:
        List<EntityItem> r21 = r2.a;
        if ((r21 instanceof Collection) == true) goto L118;
    L120:
        Iterator r22 = ((ArrayList) r21).iterator();
    L122:
        if (r22.hasNext() == false) goto L129;
        if (((EntityItem) r22.next()).b == null) goto L126;
        boolean r117 = true;
    L127:
        if (r117 == false) goto L122;
        boolean r23 = true;
    L130:
        r9.a = !r23;
        List<EntityItem> r24 = r2.a;
        if ((r24 instanceof Collection) == true) goto L133;
    L135:
        Iterator r25 = ((ArrayList) r24).iterator();
    L137:
        if (r25.hasNext() == false) goto L144;
        if (((EntityItem) r25.next()).a == null) goto L141;
        boolean r118 = true;
    L142:
        if (r118 == false) goto L137;
        boolean r26 = true;
    L145:
        r9.b = !r26;
        if (r17 == true) goto L150;
        if (r19 == true) goto L150;
        boolean r27 = false;
    L151:
        r9.d = r27;
        List<EntityItem> r28 = r2.a;
        if ((r28 instanceof Collection) == true) goto L154;
    L156:
        Iterator r29 = ((ArrayList) r28).iterator();
    L158:
        if (r29.hasNext() == false) goto L165;
        if (((EntityItem) r29.next()).e == null) goto L162;
        boolean r30 = true;
    L163:
        if (r30 == false) goto L158;
        boolean r31 = true;
    L166:
        r9.f = r31;
        goto L167
    L162:
        r30 = false;
    L165:
        r31 = false;
        goto L166
    L154:
        if (((ArrayList) r28).isEmpty() == false) goto L156;
    L150:
        r27 = true;
        goto L151
    L141:
        r118 = false;
    L144:
        r26 = false;
        goto L145
    L133:
        if (((ArrayList) r24).isEmpty() == false) goto L135;
    L126:
        r117 = false;
    L129:
        r23 = false;
        goto L130
    L118:
        if (((ArrayList) r21).isEmpty() == false) goto L120;
    L5:
        if (CollectionUtils.isEmpty(r4.a) == true) goto L71;
        Iterator r119 = ((ArrayList) r4.a).iterator();
        boolean r120 = false;
        boolean r121 = false;
    L9:
        if (r119.hasNext() == false) goto L50;
        EntityItem r122 = (EntityItem) r119.next();
        UserConfig r123 = r122.a;
        if (r123 == null) goto L30;
        int r124 = ConfigUtils.c.a[r123.getUserType().ordinal()];
        if (r124 == 1) goto L20;
        if (r124 == 2) goto L19;
        if (r124 != 3) goto L18;
        r7.e = false;
    L21:
        int r125 = ConfigUtils.c.b[r123.getTenant().ordinal()];
        if (r125 == 1) goto L29;
        if (r125 == 2) goto L28;
        if (r125 == 3) goto L29;
        throw new NoWhenBranchMatchedException();
    L28:
        r121 = true;
    L29:
        r121 = false;
        goto L30
    L18:
        throw new NoWhenBranchMatchedException();
    L19:
        r7.e = true;
        goto L21
    L20:
        r7.e = false;
        r7.b = false;
    L30:
        GroupConfig r126 = r122.b;
        if (r126 == null) goto L9;
        int r127 = ConfigUtils.c.c[r126.getGroupType().ordinal()];
        if (r127 == 1) goto L40;
        if (r127 == 2) goto L39;
        if (r127 != 3) goto L38;
        r7.c = false;
    L41:
        int r128 = ConfigUtils.c.b[r126.getTenant().ordinal()];
        if (r128 == 1) goto L49;
        if (r128 == 2) goto L48;
        if (r128 == 3) goto L49;
        throw new NoWhenBranchMatchedException();
    L48:
        r120 = true;
    L49:
        r120 = false;
        goto L9
    L38:
        throw new NoWhenBranchMatchedException();
    L39:
        r7.c = true;
        goto L41
    L40:
        r7.a = false;
        r7.c = false;
        goto L41
    L50:
        if (r120 == true) goto L54;
        if (r121 == true) goto L54;
        boolean r129 = false;
    L55:
        r7.d = r129;
        List<EntityItem> r32 = r4.a;
        if ((r32 instanceof Collection) == true) goto L58;
    L60:
        Iterator r33 = ((ArrayList) r32).iterator();
    L62:
        if (r33.hasNext() == false) goto L69;
        if (((EntityItem) r33.next()).e == null) goto L66;
        boolean r130 = true;
    L67:
        if (r130 == false) goto L62;
        boolean r34 = true;
    L70:
        r7.f = !r34;
        goto L71
    L66:
        r130 = false;
    L69:
        r34 = false;
        goto L70
    L58:
        if (((ArrayList) r32).isEmpty() == false) goto L60;
    L54:
        r129 = true;
        goto L55
    }

    public final void prepareChatBeforeForward(List<? extends SearchBaseInfo> r7, final UIGetDataCallback<List<ForwardTargetBaseInfoNew>> r8) {
        Intrinsics.checkNotNullParameter(r7, "items");
        Intrinsics.checkNotNullParameter(r8, "callback");
        final HashMap r1 = new HashMap();
        if (CollectionUtils.isEmpty(r7) == false) goto L5;
        return;
    L5:
        this.forwardTargets = SequencesKt.toMutableList(SequencesKt.filterNotNull(SequencesKt.map(CollectionsKt.asSequence(r7), new C03841(r1))));
        if (r1.isEmpty() == false) goto L9;
        r8.onSuccess(this.forwardTargets);
        return;
    L9:
        StringBuilder r9 = new StringBuilder("need create p2p chat's chatterId:\n");
        Iterator r2 = r1.entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        r9.append(" ++++ " + ((SearchBaseInfo) ((Map.Entry) r2.next()).getValue()).getId());
        goto L11
    L13:
        Log.i(TAG, r9.toString());
        IGetDataCallback<Map<String, Chat>> r10 = new ForwardV3ViewModel$prepareChatBeforeForward$createChatCallback$1(this, r8, r1);
        int r11 = com.ss.android.lark.forwardv3.data.services.a.a;
        ArrayList r12 = new ArrayList(r1.size());
        Iterator r3 = r1.entrySet().iterator();
    L15:
        if (r3.hasNext() == false) goto L17;
        r12.add((String) ((Map.Entry) r3.next()).getKey());
        goto L15
    L17:
        Intrinsics.checkNotNullParameter(r12, "chatterIds");
        Intrinsics.checkNotNullParameter(r10, "callback");
        ImSdkChatService r0 = (ImSdkChatService) ForwardImServices.a.getValue();
        if (r0 != null) goto L20;
        Log.e("ForwardGetServices", "ImSdkChatService is not registered");
        r10.onError(new ErrorResult("ImSdkChatService is not registered"));
        return;
    L20:
        r0.C2(r12, r10);
    }

    public final void requestAiKnowledgeData(String r9, final UIGetDataCallback<rib.c> r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        GetQueryByMessageIDsRequest.Builder r0 = new GetQueryByMessageIDsRequest.Builder();
        if (r9 == null) goto L5;
        r0.leave_note(r9);
    L5:
        IForwardContent r11 = this.forwardContent;
        GetQueryByMessageIDsRequest.Builder r4 = null;
        if ((r11 instanceof MergeMessageForwardContent) == false) goto L28;
        Log.i(TAG, "build MergeMessageForwardContent");
        IForwardContent r12 = this.forwardContent;
        if ((r12 instanceof MergeMessageForwardContent) == false) goto L10;
        r4 = (MergeMessageForwardContent) r12;
    L10:
        if (r4 != null) goto L65;
    L63:
        Command r13 = Command.LARK_AI_KNOWLEDGE_GET_QUERY_BY_MESSAGE_IDS;
        IGetDataCallback<GetQueryByMessageIDsResponse> r1 = new AnonymousClass8(r10);
        final ProtoAdapter r14 = GetQueryByMessageIDsResponse.ADAPTER;
        SdkSender.sendPassThroughRequest(r13, r0, r1, new b(r14));
        return;
    L65:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L21
        r0.origin_merge_forward_id(r4.b).chat_id(Long.valueOf(CastLongProtector.parseLong(r4.h)));     // Catch: Throwable -> L21
        if (r4.e == false) goto L14;
        GetQueryByMessageIDsRequest.Builder r16 = r0.message_ids(CollectionsKt.listOf(Long.valueOf(CastLongProtector.parseLong(r4.f))));     // Catch: Throwable -> L21
    L19:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L21
    L23:
        Throwable r2 = Result.exceptionOrNull-impl(r17);
        if (r2 == null) goto L26;
        Log.e(TAG, "build fail", r2);
    L26:
        Result.box-impl(r17);
        goto L63
    L14:
        ArrayList<String> r18 = r4.c;     // Catch: Throwable -> L21
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));     // Catch: Throwable -> L21
        Iterator<T> r19 = r18.iterator();     // Catch: Throwable -> L21
    L16:
        if (r19.hasNext() == false) goto L18;
        r3.add(Long.valueOf(CastLongProtector.parseLong((String) r19.next())));     // Catch: Throwable -> L21
        goto L16
    L18:
        r16 = r0.message_ids(r3);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L28:
        if ((r11 instanceof OneByOneMessageForwardContent) == false) goto L46;
        Log.i(TAG, "build OneByOneMessageForwardContent");
        IForwardContent r20 = this.forwardContent;
        if ((r20 instanceof OneByOneMessageForwardContent) == false) goto L32;
        r4 = (OneByOneMessageForwardContent) r20;
    L32:
        if (r4 == null) goto L63;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L39
        ArrayList<String> r22 = r4.c;     // Catch: Throwable -> L39
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));     // Catch: Throwable -> L39
        Iterator<T> r23 = r22.iterator();     // Catch: Throwable -> L39
    L35:
        if (r23.hasNext() == false) goto L37;
        r6.add(Long.valueOf(CastLongProtector.parseLong((String) r23.next())));     // Catch: Throwable -> L39
        goto L35
    L37:
        Object r24 = Result.constructor-impl(r0.message_ids(r6).origin_merge_forward_id(r4.b).chat_id(Long.valueOf(CastLongProtector.parseLong(r4.d))));     // Catch: Throwable -> L39
    L41:
        Throwable r7 = Result.exceptionOrNull-impl(r24);
        if (r7 == null) goto L44;
        Log.e(TAG, "build fail", r7);
    L44:
        Result.box-impl(r24);
    L39:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L46:
        if ((r11 instanceof SingleMessageForwardContent) == false) goto L63;
        Log.i(TAG, "build SingleMessageForwardContent");
        IForwardContent r25 = this.forwardContent;
        if ((r25 instanceof SingleMessageForwardContent) == false) goto L50;
        SingleMessageForwardContent r26 = (SingleMessageForwardContent) r25;
    L51:
        if (r26 == null) goto L63;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L57
        Message r28 = this.sourceMessage;     // Catch: Throwable -> L57
        if (r28 == null) goto L55;
        r4 = r0.chat_id(Long.valueOf(CastLongProtector.parseLong(r28.getChatId()))).message_ids(CollectionsKt.listOf(Long.valueOf(CastLongProtector.parseLong(r28.getId())))).origin_merge_forward_id(r26.b);     // Catch: Throwable -> L57
    L55:
        Object r29 = Result.constructor-impl(r4);     // Catch: Throwable -> L57
    L59:
        Throwable r30 = Result.exceptionOrNull-impl(r29);
        if (r30 == null) goto L62;
        Log.e(TAG, "build fail", r30);
    L62:
        Result.box-impl(r29);
    L57:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L59
    L50:
        r26 = null;
        goto L51
    }

    public final void updateMultiItemSelect(SearchBaseInfo r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "selectedItem");
        String r0 = r5.getId();
        Map r1 = (Map) this._selectedItem.getValue();
        if (r1 == null) goto L5;
        boolean r2 = r1.containsKey(r0);
    L7:
        if (r6 == false) goto L10;
        if (r2 == false) goto L10;
        Log.i("NewForward", "searchBaseInfo is selected, but map has contained. id: " + r5.getId() + ", type: " + r5.getType());
        return;
    L10:
        if (r6 == false) goto L16;
        if (r2 == true) goto L16;
        LinkedHashMap r7 = new LinkedHashMap();
        Object r3 = (Map) this._selectedItem.getValue();
        if (r3 != null) goto L15;
        r3 = new LinkedHashMap();
    L15:
        r7.putAll(r3);
        r7.put(r0, r5);
        this._selectedItem.setValue(r7);
        return;
    L16:
        if (r6 == true) goto L22;
        if (r2 == false) goto L22;
        LinkedHashMap r8 = new LinkedHashMap();
        Object r9 = (Map) this._selectedItem.getValue();
        if (r9 != null) goto L21;
        r9 = new LinkedHashMap();
    L21:
        r8.putAll(r9);
        r8.remove(r0);
        this._selectedItem.setValue(r8);
        return;
    L22:
        Log.i("NewForward", "searchBaseInfo is  not selected, but map doesn't have contained. id: " + r5.getId() + ", type: " + r5.getType());
        return;
    L5:
        r2 = false;
        goto L7
    }

    public final void performForward(Context r12, String r13, RichText r14, IGetDataCallback<rib.d> r15) {
        Intrinsics.checkNotNullParameter(r13, "note");
        Intrinsics.checkNotNullParameter(r14, "richText");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03821(this, r12, r13, r14, r15, null), 3, null);
    }

    public final void performShareForward(Context r12, String r13, RichText r14, IGetDataCallback<rib.d> r15) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "note");
        Intrinsics.checkNotNullParameter(r14, "richText");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03831(this, r12, r13, r14, r15, null), 3, null);
    }

    public static /* synthetic */ void loadRecommendData$default(ForwardV3ViewModel r0, long r1, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r3 = false;
    L5:
        r0.loadRecommendData(r1, r3);
    }

    public static /* synthetic */ void requestAiKnowledgeData$default(ForwardV3ViewModel r0, String r1, UIGetDataCallback r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.requestAiKnowledgeData(r1, r2);
    }
}
