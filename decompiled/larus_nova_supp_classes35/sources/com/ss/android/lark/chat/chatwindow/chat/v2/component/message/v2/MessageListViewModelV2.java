package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.v2;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.bytedance.lark.pb.im.v1.UserGroupEntity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.thread.ThreadUtils;
import com.larksuite.framework.utils.AndroidThrottle;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.rucket.job.RucketJob;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.biz.im.api.b1;
import com.ss.android.lark.biz.im.api.bundle.ChatTeamBundle;
import com.ss.android.lark.biz.im.api.h1;
import com.ss.android.lark.biz.im.api.s0;
import com.ss.android.lark.biz.im.api.u0;
import com.ss.android.lark.biz.im.api.v0;
import com.ss.android.lark.biz.im.api.w0;
import com.ss.android.lark.biz.im.api.y0;
import com.ss.android.lark.biz.im.api.z0;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chat.api.service.track.sample.SampleConfigParser;
import com.ss.android.lark.chat.base.model.dispatch.ActionDispatcher;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.ChatTextLayoutPreCalculator;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.columns.ColumnsUtils;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.table.TableUtils;
import com.ss.android.lark.chat.chatwindow.chat.model.pin.MessageListPinExtraLoader;
import com.ss.android.lark.chat.chatwindow.chat.model.push.PersonalSignGetUrlPreviewBuffer;
import com.ss.android.lark.chat.chatwindow.chat.model.viewdata.IMFileAuthorityInterceptor;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.reader.ReplyInThreadMessageReader;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatFileAuthorityPushHandler;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatPinExtraPushHandler;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.l0;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.core.dependency.StickerDependency;
import com.ss.android.lark.chat.core.extension.ChatCoreRuntimeProvider;
import com.ss.android.lark.chat.core.model.ChannelDataFetcherStrategy;
import com.ss.android.lark.chat.core.model.MessageFetchScene;
import com.ss.android.lark.chat.core.model.ObservableMappedArrayList;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import com.ss.android.lark.chat.entity.chat.ChatTeamInfo;
import com.ss.android.lark.chat.entity.chat.PickChatEntity;
import com.ss.android.lark.chat.entity.chat.TeamChatType;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.media.MediaImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageUrlPreview;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.entity.message.content.FileState;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageType;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.chat.utils.UserStatusParseUrlPreViewUtils;
import com.ss.android.lark.chat.utils.o1;
import com.ss.android.lark.chat.utils.q0;
import com.ss.android.lark.chat.utils.r0;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.coremdbiz.facade.plugins.markdown.MarkdownPlugin;
import com.ss.android.lark.dto.group.GroupRecallEntity;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.flow.chat.message.image.model.FlowImageSet;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.MemoryCallbackManager;
import com.ss.android.lark.pb.messages.PutMessageFoldFollowRequest;
import com.ss.android.lark.pb.messages.PutMessageFoldFollowResponse;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams;
import com.ss.android.lark.team.TeamUtils;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.codeblock.theme.CodeBlockV2ThemeManager;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.suite.lark.platform.component.deviceperf.DevicePerfUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000ê\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f*\u0002\u009c\u0001\u0018\u0000 \u0085\u00032\u00020\u0001:\u0006\u0083\u0003\u0084\u0003\u0085\u0003BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014B1\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0017J&\u0010¢\u0001\u001a\u0014\u0012\u0004\u0012\u00020H\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0Y0X2\t\u0010£\u0001\u001a\u0004\u0018\u00010\u0005H\u0002J\t\u0010¤\u0001\u001a\u00020#H\u0002J%\u0010¥\u0001\u001a\u00030¦\u00012\u0007\u0010£\u0001\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\n\u0010§\u0001\u001a\u00030¦\u0001H\u0002J\u0014\u0010¨\u0001\u001a\u00030¦\u00012\b\u0010©\u0001\u001a\u00030ª\u0001H\u0016J\n\u0010«\u0001\u001a\u00030¦\u0001H\u0002J\n\u0010¬\u0001\u001a\u00030¦\u0001H\u0002J\u0014\u0010\u00ad\u0001\u001a\u00030¦\u00012\b\u0010®\u0001\u001a\u00030\u0087\u0001H\u0016J\u0014\u0010¯\u0001\u001a\u00030¦\u00012\b\u0010°\u0001\u001a\u00030±\u0001H\u0016J\u0015\u0010²\u0001\u001a\u00030¦\u00012\t\u0010£\u0001\u001a\u0004\u0018\u00010\u0005H\u0002J0\u0010³\u0001\u001a\u00030¦\u0001*\u0004\u0018\u00010\n2\u0007\u0010´\u0001\u001a\u00020\n2\u000f\u0010µ\u0001\u001a\n\u0012\u0005\u0012\u00030¦\u00010¶\u0001H\u0002¢\u0006\u0003\u0010·\u0001J\u0016\u0010¸\u0001\u001a\u00030¦\u00012\n\u0010°\u0001\u001a\u0005\u0018\u00010¹\u0001H\u0016J\u0013\u0010º\u0001\u001a\u00030¦\u00012\u0007\u0010»\u0001\u001a\u00020#H\u0016J\n\u0010¼\u0001\u001a\u00030¦\u0001H\u0002J\u0019\u0010½\u0001\u001a\u00030¦\u00012\r\u0010¾\u0001\u001a\b\u0012\u0004\u0012\u00020\n0DH\u0002J\u0019\u0010¿\u0001\u001a\u00030¦\u00012\r\u0010À\u0001\u001a\b\u0012\u0004\u0012\u00020H0DH\u0002J\u001b\u0010Á\u0001\u001a\u00030¦\u00012\u000f\u0010Â\u0001\u001a\n\u0012\u0005\u0012\u00030¦\u00010Ã\u0001H\u0016J\u001d\u0010Ä\u0001\u001a\u00030¦\u00012\u0011\u0010Â\u0001\u001a\f\u0012\u0005\u0012\u00030¦\u0001\u0018\u00010Ã\u0001H\u0016J\u001b\u0010Å\u0001\u001a\u0004\u0018\u00010H2\u0007\u0010Æ\u0001\u001a\u00020\nH\u0096@¢\u0006\u0003\u0010Ç\u0001J&\u0010È\u0001\u001a\u00030¦\u00012\u0007\u0010Æ\u0001\u001a\u00020\n2\u0011\u0010Â\u0001\u001a\f\u0012\u0005\u0012\u00030¦\u0001\u0018\u00010Ã\u0001H\u0016J\t\u0010É\u0001\u001a\u00020#H\u0016J\t\u0010Ê\u0001\u001a\u00020#H\u0016J5\u0010Ë\u0001\u001a\u00030¦\u00012\u0007\u0010Æ\u0001\u001a\u00020\n2\u0007\u0010Ì\u0001\u001a\u00020#2\u0017\u0010Â\u0001\u001a\u0012\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020H0Í\u0001\u0018\u00010Ã\u0001H\u0002J\u0014\u0010Î\u0001\u001a\u00030¦\u00012\b\u0010Ï\u0001\u001a\u00030Ð\u0001H\u0016J+\u0010Ñ\u0001\u001a\u00030¦\u00012\u000e\u0010Ò\u0001\u001a\t\u0012\u0004\u0012\u00020%0Ó\u00012\u000f\u0010Ô\u0001\u001a\n\u0012\u0005\u0012\u00030Ð\u00010Õ\u0001H\u0016J'\u0010Ö\u0001\u001a\u00030¦\u00012\u001b\u0010×\u0001\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020%\u0012\u0005\u0012\u00030Ð\u00010Ø\u00010DH\u0016J\u001a\u0010Ù\u0001\u001a\u00030¦\u00012\u000e\u0010Â\u0001\u001a\t\u0012\u0004\u0012\u00020\n0Ã\u0001H\u0016J*\u0010Ú\u0001\u001a\u00030¦\u00012\u0007\u0010Æ\u0001\u001a\u00020\n2\u0015\u0010Â\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020H0Í\u00010Ã\u0001H\u0002J\u0012\u0010Û\u0001\u001a\u00020#2\u0007\u0010£\u0001\u001a\u00020\u0005H\u0002J&\u0010Ü\u0001\u001a\u00030¦\u00012\u0012\u0010Ý\u0001\u001a\r\u0012\t\u0012\u0007\u0012\u0002\b\u00030Þ\u00010D2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010ß\u0001\u001a\u000b\u0012\u0004\u0012\u00020H\u0018\u00010\u0096\u0001H\u0002J\u001a\u0010à\u0001\u001a\u00030¦\u00012\u000e\u0010á\u0001\u001a\t\u0012\u0004\u0012\u00020H0â\u0001H\u0002J.\u0010ã\u0001\u001a\u00030¦\u00012\u0007\u0010ä\u0001\u001a\u00020%2\u0007\u0010å\u0001\u001a\u00020%2\n\u0010æ\u0001\u001a\u0005\u0018\u00010ç\u0001H\u0016¢\u0006\u0003\u0010è\u0001J\u001b\u0010é\u0001\u001a\u00030¦\u00012\u000f\u0010ê\u0001\u001a\n\u0012\u0005\u0012\u00030\u0098\u00010â\u0001H\u0002J\"\u0010ë\u0001\u001a\u00030¦\u00012\u000e\u0010ì\u0001\u001a\t\u0012\u0004\u0012\u00020%0â\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001f\u0010í\u0001\u001a\b\u0012\u0004\u0012\u00020H0D2\u000e\u0010î\u0001\u001a\t\u0012\u0004\u0012\u00020%0â\u0001H\u0016J\u0014\u0010ï\u0001\u001a\u0004\u0018\u00010H2\u0007\u0010ð\u0001\u001a\u00020%H\u0016J\u0013\u0010ñ\u0001\u001a\u00030¦\u00012\u0007\u0010ò\u0001\u001a\u00020%H\u0016J\u0013\u0010ó\u0001\u001a\u00030¦\u00012\u0007\u0010ò\u0001\u001a\u00020%H\u0016J\u001e\u0010ô\u0001\u001a\u00030¦\u00012\u0007\u0010õ\u0001\u001a\u00020%2\t\u0010ö\u0001\u001a\u0004\u0018\u00010%H\u0016JD\u0010÷\u0001\u001a\u00030¦\u00012\u0006\u0010$\u001a\u00020%2\u0019\u0010ø\u0001\u001a\u0014\u0012\u0004\u0012\u00020%0ù\u0001j\t\u0012\u0004\u0012\u00020%`ú\u00012\u0015\u0010Â\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020%0û\u00010Ã\u0001H\u0016J@\u0010ü\u0001\u001a\u00030¦\u00012\b\u0010$\u001a\u0004\u0018\u00010%2\u0011\u0010ý\u0001\u001a\f\u0012\u0005\u0012\u00030þ\u0001\u0018\u00010û\u00012\u0017\u0010Â\u0001\u001a\u0012\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030þ\u00010D\u0018\u00010Ã\u0001H\u0016J\u0013\u0010ÿ\u0001\u001a\u00030¦\u00012\u0007\u0010ð\u0001\u001a\u00020%H\u0016J3\u0010\u0080\u0002\u001a\u00030¦\u00012\u0007\u0010ð\u0001\u001a\u00020%2\t\u0010\u0081\u0002\u001a\u0004\u0018\u00010%2\t\u0010\u0082\u0002\u001a\u0004\u0018\u00010%2\b\u0010\u0083\u0002\u001a\u00030\u0084\u0002H\u0016J\t\u0010\u0085\u0002\u001a\u00020nH\u0016J\u0013\u0010\u0086\u0002\u001a\u00030¦\u00012\u0007\u0010ð\u0001\u001a\u00020%H\u0016J\u001c\u0010\u0087\u0002\u001a\u00030¦\u00012\u0007\u0010ð\u0001\u001a\u00020%2\u0007\u0010\u0088\u0002\u001a\u00020#H\u0016J\u001a\u0010\u0089\u0002\u001a\u00030¦\u00012\u0007\u0010ò\u0001\u001a\u00020%2\u0007\u0010\u008a\u0002\u001a\u00020#J\u0013\u0010\u008b\u0002\u001a\u00030¦\u00012\u0007\u0010ð\u0001\u001a\u00020%H\u0016J%\u0010\u008c\u0002\u001a\u00030¦\u00012\u0007\u0010ð\u0001\u001a\u00020%2\u0007\u0010\u008d\u0002\u001a\u00020%2\u0007\u0010\u008e\u0002\u001a\u00020#H\u0016J\u000b\u0010\u008f\u0002\u001a\u0004\u0018\u00010HH\u0016J\u0013\u0010\u0090\u0002\u001a\u00030¦\u00012\u0007\u0010ð\u0001\u001a\u00020%H\u0002J\u0014\u0010\u0091\u0002\u001a\u00030¦\u00012\b\u0010\u0092\u0002\u001a\u00030\u0093\u0002H\u0016J@\u0010\u0094\u0002\u001a\t\u0012\u0005\u0012\u00030\u0095\u00020D2\u0007\u0010\u0096\u0002\u001a\u00020%2\u0007\u0010\u0097\u0002\u001a\u00020#2\u0010\u0010\u0098\u0002\u001a\u000b\u0012\u0005\u0012\u00030\u0099\u0002\u0018\u00010D2\n\u0010\u009a\u0002\u001a\u0005\u0018\u00010\u009b\u0002H\u0017J@\u0010\u009c\u0002\u001a\t\u0012\u0005\u0012\u00030\u0095\u00020D2\u0007\u0010\u0096\u0002\u001a\u00020%2\u0007\u0010\u0097\u0002\u001a\u00020#2\u000e\u0010\u0098\u0002\u001a\t\u0012\u0005\u0012\u00030\u0099\u00020D2\f\b\u0002\u0010\u009a\u0002\u001a\u0005\u0018\u00010\u009b\u0002H\u0002JZ\u0010\u009d\u0002\u001a\u00030¦\u00012\u0007\u0010\u0096\u0002\u001a\u00020%2\u0007\u0010\u0097\u0002\u001a\u00020#2\r\u0010\u009e\u0002\u001a\b\u0012\u0004\u0012\u00020H0D2\u000f\u0010\u009f\u0002\u001a\n\u0012\u0005\u0012\u00030\u0095\u00020û\u00012\u000e\u0010\u0098\u0002\u001a\t\u0012\u0005\u0012\u00030\u0099\u00020D2\f\b\u0002\u0010\u009a\u0002\u001a\u0005\u0018\u00010\u009b\u0002H\u0002J\u0013\u0010 \u0002\u001a\u00030¦\u00012\u0007\u0010¡\u0002\u001a\u00020%H\u0016J\u0013\u0010¢\u0002\u001a\u00030¦\u00012\u0007\u0010£\u0002\u001a\u00020HH\u0002J)\u0010¤\u0002\u001a\t\u0012\u0004\u0012\u00020%0Ã\u00012\u0007\u0010£\u0002\u001a\u00020H2\u000e\u0010Â\u0001\u001a\t\u0012\u0004\u0012\u00020%0Ã\u0001H\u0002J\u0013\u0010¥\u0002\u001a\u00030¦\u00012\u0007\u0010ð\u0001\u001a\u00020%H\u0016J\u0013\u0010¦\u0002\u001a\u00030¦\u00012\u0007\u0010ð\u0001\u001a\u00020%H\u0016J5\u0010§\u0002\u001a\u00030¦\u00012\b\u0010$\u001a\u0004\u0018\u00010%2\r\u0010ø\u0001\u001a\b\u0012\u0004\u0012\u00020%0D2\u0010\u0010¨\u0002\u001a\u000b\u0012\u0005\u0012\u00030©\u0002\u0018\u00010DH\u0016J\u001d\u0010ª\u0002\u001a\u00030¦\u00012\u0007\u0010«\u0002\u001a\u00020\n2\b\u0010Â\u0001\u001a\u00030¬\u0002H\u0016J\u0013\u0010\u00ad\u0002\u001a\u00030¦\u00012\u0007\u0010ð\u0001\u001a\u00020%H\u0016J\u0013\u0010®\u0002\u001a\u00030¦\u00012\u0007\u0010£\u0002\u001a\u00020HH\u0002J\u0016\u0010¯\u0002\u001a\u00030¦\u00012\n\u0010°\u0002\u001a\u0005\u0018\u00010±\u0002H\u0002J\u0013\u0010²\u0002\u001a\u00030¦\u00012\u0007\u0010£\u0001\u001a\u00020\u0005H\u0016J\u0013\u0010³\u0002\u001a\u00030¦\u00012\u0007\u0010´\u0002\u001a\u00020\u0005H\u0002J\u0013\u0010µ\u0002\u001a\u00030¦\u00012\u0007\u0010£\u0001\u001a\u00020\u0005H\u0002J\n\u0010¶\u0002\u001a\u00030¦\u0001H\u0002J\u0013\u0010·\u0002\u001a\u00030¦\u00012\u0007\u0010£\u0001\u001a\u00020\u0005H\u0002J\n\u0010¸\u0002\u001a\u00030¦\u0001H\u0002J#\u0010¹\u0002\u001a\u00030¦\u00012\u000e\u0010á\u0001\u001a\t\u0012\u0004\u0012\u00020H0û\u00012\u0007\u0010º\u0002\u001a\u00020#H\u0016J,\u0010»\u0002\u001a\u00030¦\u00012\u0007\u0010£\u0001\u001a\u00020\u00052\u0017\u0010¼\u0002\u001a\u0012\u0012\u0004\u0012\u00020%\u0012\u0007\b\u0001\u0012\u00030¾\u00020½\u0002H\u0016J\u0013\u0010¿\u0002\u001a\u00030¦\u00012\u0007\u0010£\u0001\u001a\u00020\u0005H\u0016J\u0014\u0010À\u0002\u001a\u00030¦\u00012\b\u0010Á\u0002\u001a\u00030Â\u0002H\u0016J\u0013\u0010Ã\u0002\u001a\u00030¦\u00012\u0007\u0010£\u0002\u001a\u00020HH\u0016J\u001e\u0010Ä\u0002\u001a\u00030¦\u00012\t\u0010Å\u0002\u001a\u0004\u0018\u00010%2\u0007\u0010Æ\u0002\u001a\u00020\nH\u0016J!\u0010Ç\u0002\u001a\u00030¦\u00012\u0015\u0010È\u0002\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0005\u0012\u00030Ê\u00020É\u0002H\u0016J\n\u0010Ë\u0002\u001a\u00030¦\u0001H\u0016J\u0013\u0010Ì\u0002\u001a\u00030¦\u00012\u0007\u0010Í\u0002\u001a\u00020#H\u0016J\u0013\u0010Î\u0002\u001a\u00030¦\u00012\u0007\u0010Ï\u0002\u001a\u00020%H\u0016J\u0013\u0010Ð\u0002\u001a\u00030¦\u00012\u0007\u0010Ñ\u0002\u001a\u00020#H\u0016J\u0013\u0010Ò\u0002\u001a\u00030¦\u00012\u0007\u0010Ó\u0002\u001a\u00020#H\u0016J\u0014\u0010Ô\u0002\u001a\u00030¦\u00012\b\u0010Õ\u0002\u001a\u00030¾\u0002H\u0016J\u0014\u0010Ö\u0002\u001a\u00030¦\u00012\b\u0010\u0092\u0002\u001a\u00030\u0093\u0002H\u0016JV\u0010×\u0002\u001a\u00030¦\u00012$\u0010Ø\u0002\u001a\u001f\u0012\u0004\u0012\u00020%\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020%\u0012\u0005\u0012\u00030Ù\u00020É\u0002\u0018\u00010É\u00022$\u0010Ú\u0002\u001a\u001f\u0012\u0004\u0012\u00020%\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020%\u0012\u0005\u0012\u00030Û\u00020É\u0002\u0018\u00010É\u0002H\u0016J!\u0010Ü\u0002\u001a\u00030¦\u00012\u0015\u0010È\u0002\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0005\u0012\u00030Ý\u00020É\u0002H\u0016J\u001a\u0010Þ\u0002\u001a\u00030¦\u00012\u000e\u0010ß\u0002\u001a\t\u0012\u0005\u0012\u00030à\u00020DH\u0016J\u0014\u0010á\u0002\u001a\u00030¦\u00012\b\u0010Õ\u0002\u001a\u00030¾\u0002H\u0016J\u001c\u0010â\u0002\u001a\u00030¦\u00012\u0007\u0010ã\u0002\u001a\u00020%2\u0007\u0010ä\u0002\u001a\u00020%H\u0016J\"\u0010å\u0002\u001a\u00030¦\u00012\u0016\u0010æ\u0002\u001a\u0011\u0012\u0005\u0012\u00030ç\u0001\u0012\u0005\u0012\u00030ç\u00020É\u0002H\u0016J\u0013\u0010è\u0002\u001a\u00030¦\u00012\u0007\u0010ò\u0001\u001a\u00020%H\u0016J#\u0010é\u0002\u001a\u00030¦\u00012\u0006\u0010$\u001a\u00020%2\u0011\u0010ê\u0002\u001a\f\u0012\u0005\u0012\u00030ë\u0002\u0018\u00010Ã\u0001J\n\u0010ì\u0002\u001a\u00030¦\u0001H\u0014J\n\u0010í\u0002\u001a\u00030¦\u0001H\u0016J\n\u0010î\u0002\u001a\u00030¦\u0001H\u0002J\u0012\u0010ï\u0002\u001a\u00020#2\u0007\u0010ð\u0002\u001a\u00020\nH\u0016J\u0014\u0010ñ\u0002\u001a\u0004\u0018\u00010H2\u0007\u0010Æ\u0001\u001a\u00020\nH\u0016J\u000f\u0010ò\u0002\u001a\u00020\nH\u0016¢\u0006\u0003\u0010ó\u0002J\u0013\u0010ô\u0002\u001a\u00030¦\u00012\u0007\u0010õ\u0002\u001a\u00020%H\u0016J\u001c\u0010ö\u0002\u001a\u00030¦\u00012\u0007\u0010÷\u0002\u001a\u00020%2\u0007\u0010ø\u0002\u001a\u00020\nH\u0016J\u0011\u0010ù\u0002\u001a\n\u0012\u0005\u0012\u00030Ð\u00010ú\u0002H\u0016J\n\u0010û\u0002\u001a\u00030¦\u0001H\u0016J.\u0010ü\u0002\u001a\u00030¦\u00012\u0007\u0010ý\u0002\u001a\u00020\n2\u0007\u0010þ\u0002\u001a\u00020\n2\u0007\u0010ÿ\u0002\u001a\u00020\n2\u0007\u0010\u0080\u0003\u001a\u00020\nH\u0016J\n\u0010\u0081\u0003\u001a\u00030¦\u0001H\u0016J\n\u0010\u0082\u0003\u001a\u00030¦\u0001H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020%X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020#0.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00100R\u0011\u00103\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u00107\u001a\u000208¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010;\u001a\u00020<¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001c\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u00100R\u001c\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u00100R$\u0010C\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030E0D0.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u00100R \u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0D0.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u00100R \u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0D0.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u00100R\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020%0.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u00100R*\u0010N\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0006\u0012\u0004\u0018\u00010%0O0.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u00100R\u001c\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u00100R\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020#0.X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u00100R\u000e\u0010U\u001a\u00020VX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010W\u001a\u0014\u0012\u0004\u0012\u00020H\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0Y0XX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R \u0010\\\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030E\u0012\u0004\u0012\u00020H\u0018\u00010]X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010b\u001a\u00020cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u0010\u0010f\u001a\u0004\u0018\u00010gX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020iX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020iX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020lX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010o\u001a\u00020p8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bq\u0010rR\u000e\u0010u\u001a\u00020vX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010w\u001a\n y*\u0004\u0018\u00010x0xX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010z\u001a\u0004\u0018\u00010{X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010|\u001a\u0004\u0018\u00010}X\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0012\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0084\u0001\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0088\u0001\u001a\u0011\u0012\f\u0012\n y*\u0004\u0018\u00010\u00120\u00120\u0089\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u008c\u0001\u001a\u0015\u0012\u0004\u0012\u00020H\u0012\b\u0012\u0006\u0012\u0002\b\u00030E\u0018\u00010\u008d\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R5\u0010\u008e\u0001\u001a(\u0012\f\u0012\n y*\u0004\u0018\u00010%0% y*\u0013\u0012\f\u0012\n y*\u0004\u0018\u00010%0%\u0018\u00010\u0090\u00010\u008f\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0093\u0001\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0094\u0001\u0010t\u001a\u0005\b\u0093\u0001\u0010*R\u0018\u0010\u0095\u0001\u001a\u000b\u0012\u0004\u0012\u00020H\u0018\u00010\u0096\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0097\u0001\u001a\f\u0012\u0005\u0012\u00030\u0098\u0001\u0018\u00010\u0096\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u009b\u0001\u001a\u00030\u009c\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u009d\u0001R\u0010\u0010\u009e\u0001\u001a\u00030\u009f\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u0001\u001a\n\u0012\u0005\u0012\u00030¡\u00010\u0090\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0086\u0003"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/v2/MessageListViewModelV2;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListViewModel;", "context", "Landroid/content/Context;", "initChat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "selfChatter", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "p2pChatter", "showPosition", BuildConfig.FLAVOR, "teamBundle", "Lcom/ss/android/lark/biz/im/api/bundle/ChatTeamBundle;", "chatBundle", "Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "chatContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "dependency", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/MessageListViewModelDependency;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/chat/entity/chat/Chat;Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;ILcom/ss/android/lark/biz/im/api/bundle/ChatTeamBundle;Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/MessageListViewModelDependency;)V", "initData", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "(Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;Landroid/content/Context;Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/MessageListViewModelDependency;)V", "getShowPosition", "()I", "getTeamBundle", "()Lcom/ss/android/lark/biz/im/api/bundle/ChatTeamBundle;", "getChatBundle", "()Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "getChatContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "getDependency", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/MessageListViewModelDependency;", "destroyed", BuildConfig.FLAVOR, "chatId", BuildConfig.FLAVOR, "getChatId", "()Ljava/lang/String;", "selfMessageRTLDisplay", "getSelfMessageRTLDisplay", "()Z", "setSelfMessageRTLDisplay", "(Z)V", "currentChat", "Landroidx/lifecycle/MutableLiveData;", "getCurrentChat", "()Landroidx/lifecycle/MutableLiveData;", "messageReadable", "getMessageReadable", "chatService", "Lcom/ss/android/lark/im/sdk/service/ImSdkChatService;", "getChatService", "()Lcom/ss/android/lark/im/sdk/service/ImSdkChatService;", "messageService", "Lcom/ss/android/lark/im/sdk/service/ImSdkMessageService;", "getMessageService", "()Lcom/ss/android/lark/im/sdk/service/ImSdkMessageService;", "chatterService", "Lcom/ss/android/lark/im/sdk/service/ImSdkChatterService;", "getChatterService", "()Lcom/ss/android/lark/im/sdk/service/ImSdkChatterService;", "selfChatterLiveData", "getSelfChatterLiveData", "p2pChatterLiveData", "getP2pChatterLiveData", "messageList", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/vo/ChatMessageVO;", "getMessageList", "newMessageItems", "Lcom/ss/android/lark/chat/entity/message/MessageInfo;", "getNewMessageItems", "newMessageItemsAppend", "getNewMessageItemsAppend", "toastInfo", "getToastInfo", "dialogInfo", "Lkotlin/Pair;", "getDialogInfo", "closePageInfo", "getClosePageInfo", "needRelocateMessage", "getNeedRelocateMessage", "pushManager", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/PushHandlerManager;", "dataStore", "Lcom/ss/android/lark/chatbase/BasePageStore;", "Lcom/ss/android/lark/chat/core/model/BasePageData;", "getDataStore", "()Lcom/ss/android/lark/chatbase/BasePageStore;", "mDataListPipeline", "Lcom/ss/android/lark/chat/core/model/DataListPipeline;", "mChatRelationPushHandler", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/ChatRelationPushHandler;", "mMessageResourceLoader", "Lcom/ss/android/lark/chat/chatwindow/chat/model/preload/IMessageResourceLoader;", "mMessageReader", "Lcom/ss/android/lark/biz/im/api/IMessageReader;", "getMMessageReader", "()Lcom/ss/android/lark/biz/im/api/IMessageReader;", "mCancelableExecutor", "Lcom/larksuite/framework/callback/CancelableCallbackExecutor;", "mMessageHandlerExecutor", "Lcom/ss/android/lark/chat/core/model/ISerialExecutor;", "mBackgroundExecutor", "mCallbackManager", "Lcom/larksuite/framework/callback/CallbackManager;", "mUIModel", "Lcom/ss/android/lark/chat/chatwindow/chat/ChatWindowUIModel;", "mIMFileAuthorityChecker", "Lcom/ss/android/lark/auditsdk/v2/receivecheck/IAuthorityChecker;", "getMIMFileAuthorityChecker", "()Lcom/ss/android/lark/auditsdk/v2/receivecheck/IAuthorityChecker;", "mIMFileAuthorityChecker$delegate", "Lkotlin/Lazy;", "foldMessageService", "Lcom/ss/android/lark/chat/service/IFoldMessageService;", "mStickerService", "Lcom/ss/android/lark/chat/core/dependency/StickerDependency;", "kotlin.jvm.PlatformType", "textLayoutPreCalculator", "Lcom/ss/android/lark/chat/chatwindow/chat/data/convert/textprocess/ITextLayoutPreCalculateLifeCycle;", "pinExtraLoader", "Lcom/ss/android/lark/chat/chatwindow/chat/model/pin/MessageListPinExtraLoader;", "getPinExtraLoader", "()Lcom/ss/android/lark/chat/chatwindow/chat/model/pin/MessageListPinExtraLoader;", "setPinExtraLoader", "(Lcom/ss/android/lark/chat/chatwindow/chat/model/pin/MessageListPinExtraLoader;)V", "smartApplyAnswerDependencyLoader", "Lcom/ss/android/lark/chat/chatwindow/chat/model/SmartApplyAnswerDependencyLoader;", "mDissolveGroupByLocalFlag", "mQuitGroupBySelf", "mActionDispatcher", "Lcom/ss/android/lark/chat/base/model/dispatch/ActionDispatcher;", "mDependencyRefs", "Ljava/lang/ref/WeakReference;", "mConnectionStateListener", "Lcom/ss/android/lark/listener/IConnStateListener;", "dataMapper", "Lcom/ss/android/lark/chat/core/model/IDataMapper;", "mImmediatePushWhiteList", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "urlAsyncMeasureInterceptor", "Lcom/ss/android/lark/chat/chatwindow/chat/model/viewdata/URLAsyncMeasureInterceptor;", "isEnableGenerateDigest", "isEnableGenerateDigest$delegate", "mMessageUpdateThrottle", "Lcom/larksuite/framework/utils/AndroidThrottle;", "signUrlUpdateThrottle", "Lcom/ss/android/lark/chat/utils/UserStatusParseUrlPreViewUtils$GetSignUrlPreviewParams;", "mExtraItemInterceptor", "Lcom/ss/android/lark/chat/chatwindow/chat/model/viewdata/ExtraItemInterceptor;", "mOnDataChangeListener2", "com/ss/android/lark/chat/chatwindow/chat/v2/component/message/v2/MessageListViewModelV2$mOnDataChangeListener2$1", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/v2/MessageListViewModelV2$mOnDataChangeListener2$1;", "messageListRepository", "Lcom/ss/android/lark/biz/im/api/MessageListRepository;", "needImmediateFlushSystemTypes", "Lcom/ss/android/lark/chat/export/entity/message/content/SystemMessageType;", "initDataStore", "chat", "isLowDevice", "initResourceLoader", BuildConfig.FLAVOR, "initMessageSampleConfig", "executeMessage", "runnable", "Ljava/lang/Runnable;", "registerConnectionStateChangeListener", "syncWSReconnect", "setActionDispatch", "dispatcher", "setScreenItemProvider", "provider", "Lcom/ss/android/lark/chat/chatwindow/chat/model/ChatWindowDataStore$ILastScreenItemProvider;", "initPushHandler", "runWhenPushIsEnabled", "pushFlag", "runIfEnabled", "Lkotlin/Function0;", "(Ljava/lang/Integer;ILkotlin/jvm/functions/Function0;)V", "setWindowDataPreLoadTaskProvider", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IChatWindowPreLoadTaskProvider;", "loadFirstPage", "isFromOfflinePush", "openDataMapPreProcess", "loadMissingData", "missingPositions", "reloadFirstScreenData", "exitMessageList", "loadNextPage", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "loadPrePage", "loadSpecialPosition", "position", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadSpecialPage", "canLoadMore", "canLoadPre", "loadToPosition", "fromServer", "Lcom/ss/android/lark/chat/core/model/ObservableList;", "batchUpdate", "needUpdateMessage", "Lcom/ss/android/lark/chat/entity/message/IChatMessage;", "updateMsg", "key", "Lcom/ss/android/lark/biz/im/api/extension/store/ItemTwoKey;", "updater", "Lcom/ss/android/lark/biz/im/api/extension/store/IItemPatch;", "batchUpdateMsg", "patchProviderList", "Lcom/ss/android/lark/biz/im/api/extension/store/PatchProvider;", "ensureLastPageDataLoaded", "tryToLoadSpecificPosition", "needToReloadMessageBeforeSend", "readMessage", "intervalMessages", "Lcom/ss/android/lark/chat/vo/AbsMessageVO;", "getMsgUpdateThrottle", "handleUpdateMsg", "messageInfos", BuildConfig.FLAVOR, "sendSignRequest", "description", "sourceId", "privateDescriptionId", BuildConfig.FLAVOR, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "handleSignUrlRequest", "signUrlPreviewParamsList", "handleMessageRead", "messageIds", "getMessageInfoByIds", "msgIds", "getMessageInfoById", "msgId", "addSticker", "messageId", "deleteUrlPreview", "cancelUploadMediaMsg", "cId", "compressPath", "checkChatterInChat", "chatterIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BuildConfig.FLAVOR, "onCheckMembersInChat", "entities", "Lcom/ss/android/lark/dto/group/GroupRecallEntity;", "registerImmediateMsg", "prepareAudioData", "previewId", "msgLinkToken", "successState", "Lcom/ss/android/lark/chat/entity/message/content/AudioContent$AudioState;", "getUIModel", "handleShowMoreTextClick", "handleCollapsingUrlPreview", "isCollapsed", "onClickToggleReferences", "show", "updatePreviewByMessageId", "handleInteractiveState", "eleId", "inProcessing", "getTopicMessageInfo", "notifyMessageChange", "onPushUpdateThreadInfo", "threadInfo", "Lcom/ss/android/lark/chat/entity/thread/ThreadInfo;", "getAllImage", "Lcom/ss/android/lark/chat/entity/image/ImageSet;", "clickedMsgId", "isClickTranslated", "messageTypeList", "Lcom/ss/android/lark/chat/entity/message/Message$Type;", "externalHandler", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageDataExternalHandler;", "getAllImageInner", "parseImageSetFromMsgInfoList", "messageInfoList", "imageSetList", "retrySendMessage", "preMsgId", "retrySendMessageInner", "messageInfo", "wrapResendCallback", "burnMsg", "invalidGroupShare", "recallMembers", "entityList", "Lcom/ss/android/lark/chat/entity/chat/PickChatEntity;", "checkToClearDataStore", "newFirstMsgPosition", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/IMessageListComponent$IMessageClearedCallback;", "readAudioMsg", "handleLocalMessageUpdate", "handleSendMessageFailError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "onPushChat", "handleChatChange", "newChat", "handleQuitGroup", "updateFoldCardWhenChatChange", "scheduleQuitGroup", "handleQuitOnCallGroup", "onPushMessage", "updateImmediate", "onPushChatRemoveChatters", "chatterMap", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "onPushChatRemoveMe", "onPushThreadTopic", "threadTopic", "Lcom/ss/android/lark/biz/im/api/ThreadTopic;", "onPushDingMessage", "onPushUploadProgress", "cid", "progress", "onPushMyAIVote", "map", BuildConfig.FLAVOR, "Lcom/bytedance/lark/pb/basic/v1/Message$AIMessageLikeFeedbackStatus;", "onFileDownloadFail", "onSwitchToCellularDataNetwork", "isPause", "onSendChatAnnouncement", "content", "updateDissolveGroupLocalFlag", "localFlag", "onQuitGroup", "byMySelf", "onPushUpdatedChatter", "chatter", "onThreadRepliesUpdate", "onPushPreview", "previews", "Lcom/ss/android/lark/export/entity/UrlCardPreviewEntity;", "messageLinkMap", "Lcom/bytedance/lark/pb/basic/v1/MessageLink;", "onPushFileAuthority", "Lcom/ss/android/lark/auditsdk/v2/receivecheck/entity/ValidateIMFileResult;", "onPushSignUrlPreview", "entriesList", "Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntries;", "onUpdateSelfInfo", "onPushUpdatedNickname", "chatterId", "nickname", "onPushUserGroup", "userGroups", "Lcom/bytedance/lark/pb/im/v1/UserGroupEntity;", "toggleItemShowTime", "getChatchatters", "dataCallback", "Lcom/ss/android/lark/dto/chat/ChatChatterResponse;", "onCleared", "destroy", "checkToClearBadge", "containsPosition", "newPosition", "getDataOnPosition", "getExpiredPeriodTime", "()Ljava/lang/Integer;", "onAuditedFailed", "msg", "onFollowFold", "foldId", "count", "stream", "Lcom/ss/android/lark/chatbase/Stream;", "notifyDataChange", "onTrimMemory", "level", "javaHeapUsed", "nativeHeapUsed", "maxJavaHeapMem", "onJavaMemoryReachTop", "changeMessageAlignIfNeed", "MediaMessageResendCallback", "SafeRunnable", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageListViewModelV2 extends IMessageListViewModel {
    public static final f Companion = null;
    public static final int FROZEN_GROUP_SEND_MSG_ERROR = 4506;
    public static final int IS_NOT_FRIEND = 5009;
    public static final int MESSAGE_CONTENT_SIZE_LIMIT = 5007;
    public static final long PRELOAD_MINI_APP_DELAY_IN_MILLIS = 5000;
    public static final int PRIVATE_MODE_ENCRYPTION_SERVICE_ERROR = 105504;
    public static final int RELOCATE_MESSAGE_DELAY_IN_MILLS = 1000;
    public static final int SECRET_CHAT_UNAVAILABLE = 6003;
    public static final int STATIC_RESOURCE_IS_DELETED_BY_ADMIN = 5602;
    public static final int STATIC_RESOURCE_IS_FROZEN_BY_ADMIN = 5601;
    private static final String TAG = "MessageListViewModel";
    public static final String TAG_MESSAGE_LIST = "chat_window";
    private final fxa.b chatBundle;
    private final com.ss.android.lark.chat.chatwindow.chat.v2.push.v chatContainer;
    private final String chatId;
    private final ImSdkChatService chatService;
    private final com.ss.android.lark.im.sdk.service.h chatterService;
    private final MutableLiveData<String> closePageInfo;
    private final Context context;
    private final MutableLiveData<Chat> currentChat;
    private x4b.c<MessageInfo, y6b.c<?>> dataMapper;
    private final BasePageStore<MessageInfo, x4b.a<MessageInfo>> dataStore;
    private final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p dependency;
    private boolean destroyed;
    private final MutableLiveData<Pair<String, String>> dialogInfo;
    private final m6b.i foldMessageService;
    private final Chat initChat;
    private final Lazy isEnableGenerateDigest$delegate;
    private ActionDispatcher mActionDispatcher;
    private x4b.d mBackgroundExecutor;
    private final CallbackManager mCallbackManager;
    private com.larksuite.framework.callback.c mCancelableExecutor;
    private com.ss.android.lark.chat.chatwindow.chat.v2.push.o mChatRelationPushHandler;
    private aqb.d mConnectionStateListener;
    private com.ss.android.lark.chat.core.model.b<y6b.c<?>, MessageInfo> mDataListPipeline;
    private WeakReference<com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p> mDependencyRefs;
    private boolean mDissolveGroupByLocalFlag;
    private com.ss.android.lark.chat.chatwindow.chat.model.viewdata.a mExtraItemInterceptor;
    private final Lazy mIMFileAuthorityChecker$delegate;
    private final Set<String> mImmediatePushWhiteList;
    private x4b.d mMessageHandlerExecutor;
    private final com.ss.android.lark.biz.im.api.f0 mMessageReader;
    private com.ss.android.lark.chat.chatwindow.chat.model.preload.b mMessageResourceLoader;
    private AndroidThrottle<MessageInfo> mMessageUpdateThrottle;
    private final w mOnDataChangeListener2;
    private boolean mQuitGroupBySelf;
    private StickerDependency mStickerService;
    private final s2b.e mUIModel;
    private final MutableLiveData<List<y6b.c<?>>> messageList;
    private final y0 messageListRepository;
    private final MutableLiveData<Boolean> messageReadable;
    private final com.ss.android.lark.im.sdk.service.p messageService;
    private final Set<SystemMessageType> needImmediateFlushSystemTypes;
    private final MutableLiveData<Boolean> needRelocateMessage;
    private final MutableLiveData<List<MessageInfo>> newMessageItems;
    private final MutableLiveData<List<MessageInfo>> newMessageItemsAppend;
    private final MutableLiveData<ChatChatter> p2pChatterLiveData;
    private MessageListPinExtraLoader pinExtraLoader;
    private final com.ss.android.lark.chat.chatwindow.chat.v2.push.c0 pushManager;
    private final MutableLiveData<ChatChatter> selfChatterLiveData;
    private boolean selfMessageRTLDisplay;
    private final int showPosition;
    private AndroidThrottle<UserStatusParseUrlPreViewUtils.b> signUrlUpdateThrottle;
    private q3b.r smartApplyAnswerDependencyLoader;
    private final ChatTeamBundle teamBundle;
    private com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a textLayoutPreCalculator;
    private final MutableLiveData<String> toastInfo;
    private com.ss.android.lark.chat.chatwindow.chat.model.viewdata.e urlAsyncMeasureInterceptor;

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/v2/MessageListViewModelV2$MediaMessageResendCallback;", "Lcom/larksuite/framework/callback/IGetDataCallback;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/service/ISendMessageBegin;", "Lcom/ss/android/lark/chat/service/impl/IMediaCompressProgress;", "mMessageInfo", "Lcom/ss/android/lark/chat/entity/message/MessageInfo;", "callback", "model", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/v2/MessageListViewModelV2;", "messagePush", "Lcom/ss/android/lark/chat/service/ImSdkMessagePush;", "<init>", "(Lcom/ss/android/lark/chat/entity/message/MessageInfo;Lcom/larksuite/framework/callback/IGetDataCallback;Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/v2/MessageListViewModelV2;Lcom/ss/android/lark/chat/service/ImSdkMessagePush;)V", "getMessagePush", "()Lcom/ss/android/lark/chat/service/ImSdkMessagePush;", "mCallbackWr", "Ljava/lang/ref/SoftReference;", "wr", "Ljava/lang/ref/WeakReference;", "onSuccess", BuildConfig.FLAVOR, "messageId", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "onBeginSendMessage", "message", "Lcom/ss/android/lark/chat/entity/message/Message;", "onUpdateMediaCompressProgress", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MediaMessageResendCallback implements IGetDataCallback<String>, m6b.p, com.ss.android.lark.chat.service.impl.u {
        private final SoftReference<IGetDataCallback<String>> mCallbackWr;
        private final MessageInfo mMessageInfo;
        private final m6b.u messagePush;
        private final WeakReference<MessageListViewModelV2> wr;

        public final m6b.u getMessagePush() {
            return this.messagePush;
        }

        @Override // m6b.p
        public void onBeginSendMessage(Message r3) {
            Intrinsics.checkNotNullParameter(r3, "message");
            MessageListViewModelV2 r0 = this.wr.get();
            if (r0 == null) goto L6;
            this.mMessageInfo.setMessage(r3);
            MessageListViewModelV2.access$notifyMessageChange(r0, r3.getId());
            return;
        }

        public void onError(ErrorResult r2) {
            Intrinsics.checkNotNullParameter(r2, "err");
            IGetDataCallback<String> r0 = this.mCallbackWr.get();
            if (r0 == null) goto L6;
            r0.onError(r2);
            return;
        }

        public void onSuccess(String r2) {
            Intrinsics.checkNotNullParameter(r2, "messageId");
            IGetDataCallback<String> r0 = this.mCallbackWr.get();
            if (r0 == null) goto L6;
            r0.onSuccess(r2);
            return;
        }

        @Override // com.ss.android.lark.chat.service.impl.u
        public void onUpdateMediaCompressProgress(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            this.mMessageInfo.setMessage(r2);
            this.messagePush.I(this.mMessageInfo);
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((String) r1);
        }

        public MediaMessageResendCallback(MessageInfo r2, IGetDataCallback<String> r3, MessageListViewModelV2 r4, m6b.u r5) {
            Intrinsics.checkNotNullParameter(r2, "mMessageInfo");
            Intrinsics.checkNotNullParameter(r3, "callback");
            Intrinsics.checkNotNullParameter(r4, "model");
            Intrinsics.checkNotNullParameter(r5, "messagePush");
            this.mMessageInfo = r2;
            this.messagePush = r5;
            this.mCallbackWr = new SoftReference(r3);
            this.wr = new WeakReference(r4);
        }
    }

    public static final class a implements ReplyInThreadMessageReader.b {
        public final /* synthetic */ MessageListViewModelV2 a;

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.reader.ReplyInThreadMessageReader.b
        public final MessageInfo a() {
            return (MessageInfo) CollectionsKt.lastOrNull(this.a.getDataStore().b);
        }

        public a(MessageListViewModelV2 r1) {
            this.a = r1;
        }
    }

    public static final class a0 implements Runnable {
        public final /* synthetic */ MessageListViewModelV2 a;
        public final /* synthetic */ List<MessageInfo> b;

        /* JADX WARN: Multi-variable type inference failed */
        public a0(MessageListViewModelV2 r1, List<? extends MessageInfo> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            Chat r0 = this.a.getChatService().P6(this.a.getChatId(), ImSdkChatService.Source.CHAT_WINDOW);
            if (r0 != null) goto L5;
        L7:
            boolean r3 = false;
        L8:
            if (r3 == false) goto L10;
            this.a.onPushChat(r0);
            boolean r4 = true;
        L12:
            if (this.a.getShowPosition() < 0) goto L14;
            MessageFetchScene r5 = MessageFetchScene.SPECIFIED_POSITION;
        L15:
            com.ss.android.lark.im.sdk.service.a.a r6 = new com.ss.android.lark.im.sdk.service.a.a();
            r6.a(this.a.getChatId());
            r6.b(r5);
            r6.c = this.a.getShowPosition();
            r6.d = 15;
            r6.e = 5;
            r6.f = com.ss.android.lark.chat.core.model.a.b;
            r6.g = true;
            r6.c(ChannelDataFetcherStrategy.SYNC_SERVER_DATA);
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "contextId");
            r6.i = BuildConfig.FLAVOR;
            com.ss.android.lark.im.sdk.service.a r7 = new com.ss.android.lark.im.sdk.service.a(r6);
            ChatMessageResponse r8 = this.a.getMessageService().x2(r7);
            if (r8 != null) goto L19;
            Log.e(TitlebarViewModel.LOG_TAG, "reload first screen data failed");
            return;
        L19:
            List<MessageInfo> r9 = r8.messageInfoList;
            HashSet r10 = new HashSet();
            Iterator<MessageInfo> r11 = this.b.iterator();
        L21:
            if (r11.hasNext() == false) goto L24;
            r10.add(Integer.valueOf(r11.next().getMessage().getPosition()));
            goto L21
        L24:
            if (CollectionUtils.isNotEmpty(r9) == false) goto L30;
            this.a.onPushMessage(r9, false);
            Iterator<MessageInfo> r12 = r9.iterator();
        L27:
            if (r12.hasNext() == false) goto L30;
            r10.remove(Integer.valueOf(r12.next().getMessage().getPosition()));
        L30:
            if (CollectionUtils.isEmpty(r10) == false) goto L32;
            return;
        L32:
            ChatMessageResponse r13 = this.a.getMessageService().fd(this.a.getChatId(), new ArrayList(r10));
            if (r13 == null) goto L35;
            List<MessageInfo> r14 = r13.messageInfoList;
        L36:
            if (r14 != null) goto L38;
        L40:
            if (r0 == null) goto L46;
            if (r4 == true) goto L47;
            this.a.onPushChat(r0);
            return;
        L47:
            return;
        L46:
            return;
        L38:
            if ((true ^ r13.messageInfoList.isEmpty()) == false) goto L40;
            this.a.onPushMessage(r13.messageInfoList, false);
            goto L40
        L35:
            r14 = null;
            goto L36
        L14:
            r5 = MessageFetchScene.FIRST_SCREEN;
            goto L15
        L10:
            r4 = false;
            goto L12
        L5:
            if (r0.isSuper() != true) goto L7;
            r3 = true;
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements s2b.e.a {
        public final /* synthetic */ MessageListViewModelV2 a;

        public b(MessageListViewModelV2 r1) {
            this.a = r1;
        }

        @Override // s2b.e.a
        public final void a(String r2) {
            MessageListViewModelV2 r0 = this.a;
            Intrinsics.checkNotNull(r2);
            MessageListViewModelV2.access$notifyMessageChange(r0, r2);
        }
    }

    public static final class b0 extends com.ss.android.lark.chatbase.model.c.b<f5b.b> {
        public final /* synthetic */ MessageListViewModelV2 a;

        public b0(MessageListViewModelV2 r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chatbase.model.c.b
        public final f5b.b b(Object r5) {
            f5b.b r6 = (f5b.b) r5;
            Intrinsics.checkNotNullParameter(r6, "existedItem");
            Message r0 = r6.getMessage();
            if (r0.getType() != Message.Type.MEDIA) goto L11;
            MediaContent r1 = (MediaContent) r0.getContent();
            com.ss.android.lark.vfs.h r2 = com.ss.android.lark.im.base.a.b();
            String r3 = r1.getOriginPath();
            if (r3 != null) goto L8;
            r3 = BuildConfig.FLAVOR;
        L8:
            if (com.suite.lark.component.storage.ext.b.b(r2.z(r3)) == true) goto L10;
            this.a.getToastInfo().postValue(UIHelper.getString(2131892310));
        L12:
            return r6;
        L10:
            r1.setFileState(FileState.COMPRESSING);
        L11:
            r0.setUpdateTime(com.larksuite.framework.utils.e.e());
            r0.setSendStatus(SendStatus.SENDING);
            MessageListViewModelV2.access$retrySendMessageInner(this.a, (MessageInfo) r6);
            goto L12
        }
    }

    public static final class c<T> implements com.ss.android.lark.chat.core.model.b.InterfaceC0086b {
        public final /* synthetic */ MessageListViewModelV2 a;

        public c(MessageListViewModelV2 r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.core.model.b.InterfaceC0086b
        public final void onChanged(List<y6b.c<?>> r4) {
            StringBuilder r0 = new StringBuilder("size = ");
            ArrayList r1 = (ArrayList) r4;
            r0.append(r1.size());
            PerfLog.start("message_list_changed", r0.toString());
            com.ss.android.lark.chat.chatwindow.chat.model.viewdata.a r2 = MessageListViewModelV2.access$getMExtraItemInterceptor$p(this.a);
            if (r2 == null) goto L5;
            r1.size();
            r2.d(r4);
        L5:
            Iterator<T> r3 = this.a.getDependency().w().iterator();
        L7:
            if (r3.hasNext() == false) goto L9;
            u0 r5 = (u0) r3.next();
            Intrinsics.checkNotNull(r4);
            r5.a();
            goto L7
        L9:
            this.a.getMessageList().postValue(r4);
            PerfLog.end("message_list_changed", BuildConfig.FLAVOR);
        }
    }

    public static final class c0 implements Runnable {
        public final /* synthetic */ MessageListViewModelV2 a;
        public final /* synthetic */ Chat b;

        public c0(MessageListViewModelV2 r1, Chat r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.ss.android.lark.chat.entity.chat.b r0 = this.a.getChatContainer().j0().I0(this.b.getId());     // Catch: Throwable -> L11
            if (r0 == null) goto L5;
            String r1 = r0.b;     // Catch: Throwable -> L11
        L7:
            if (TextUtils.isEmpty(r1) == false) goto L9;
            r1 = UIHelper.getString(2131891449);     // Catch: Throwable -> L11
        L9:
            this.a.getClosePageInfo().postValue(r1);     // Catch: Throwable -> L11
            return;
        L5:
            r1 = null;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        }
    }

    public static final class d implements d2b.a.c {
        public d() {
        }
    }

    public static final class d0<T> implements AndroidThrottle.e {
        public final /* synthetic */ MessageListViewModelV2 a;

        public d0(MessageListViewModelV2 r1) {
            this.a = r1;
        }

        public final void a(Collection<UserStatusParseUrlPreViewUtils.b> r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            MessageListViewModelV2.access$handleSignUrlRequest(this.a, r2);
        }
    }

    public static final class e implements d2b.a.b {
        public e() {
        }
    }

    public static final class e0 implements Runnable {
        public final /* synthetic */ MessageListViewModelV2 a;

        public e0(MessageListViewModelV2 r1) {
            this.a = r1;
        }

        public final void a() {
            int r0 = 0;
        L4:
            if (r0 >= 3) goto L12;
            Chat r1 = this.a.getChatService().B2(this.a.getChatId());
            if (r1 != null) goto L7;
            Log.e(TitlebarViewModel.LOG_TAG, "cannot fetch chat when syncWSReconnect, times: " + r0);
            r0 = r0 + 1;
            goto L4
        L7:
            this.a.onPushChat(r1);
            Log.i(TitlebarViewModel.LOG_TAG, "latest chat id: " + r1.getId());
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f {
        public f() {
        }
    }

    public static final class f0 implements hya.c<String, f5b.b> {
        public final /* synthetic */ y6b.c<?> a;
        public final /* synthetic */ MessageListViewModelV2 b;

        public static final class a<T> implements hya.a {
            public final /* synthetic */ MessageListViewModelV2 a;

            public a(MessageListViewModelV2 r1) {
                this.a = r1;
            }

            public final Object a(Object r10) {
                f5b.b r11 = (f5b.b) r10;
                MessageFoldDetail r0 = null;
                if (r11 == null) goto L7;
                MessageFoldDetail r1 = r11.getMessageFoldDetail();
                if (r1 == null) goto L7;
                MessageFoldDetail.Builder r2 = r1.builder();
            L8:
                Chat r3 = (Chat) this.a.getCurrentChat().getValue();
                if (r2 == null) goto L11;
                long r4 = r2.getLastMessagePos();
            L12:
                boolean r5 = false;
                if (r3 == null) goto L15;
                int r6 = r3.getLastMessagePosition();
            L17:
                if (r4 >= r6) goto L19;
            L26:
                StringBuilder r7 = new StringBuilder("updateFoldCardWhenChatChange: fold message not enable follow: position is : ");
                if (r11 == null) goto L31;
                Message r8 = r11.getMessage();
                if (r8 == null) goto L31;
                Integer r9 = Integer.valueOf(r8.getPosition());
            L32:
                r7.append(r9);
                r7.append(" , mesId is ");
                if (r11 == null) goto L35;
                String r12 = r11.getId();
            L36:
                r7.append(r12);
                r7.append(" , foldLastMsgPos is ");
                if (r2 == null) goto L39;
                Long r13 = Long.valueOf(r2.getLastMessagePos());
            L40:
                r7.append(r13);
                r7.append(" , chatLastMsgPos is ");
                if (r3 == null) goto L43;
                Integer r14 = Integer.valueOf(r3.getLastMessagePosition());
            L44:
                r7.append(r14);
                r7.append(' ');
                Log.d(TitlebarViewModel.LOG_TAG, r7.toString());
                if (r11 == null) goto L51;
                if (r2 == null) goto L50;
                MessageFoldDetail.Builder r15 = r2.enableFollow(r5);
                if (r15 == null) goto L50;
                r0 = r15.build();
            L50:
                r11.setMessageFoldDetail(r0);
            L51:
                return r11;
            L43:
                r14 = null;
                goto L44
            L39:
                r13 = null;
                goto L40
            L35:
                r12 = null;
            L31:
                r9 = null;
                goto L32
            L19:
                if (r3 != null) goto L21;
            L23:
                boolean r16 = false;
            L24:
                if (r16 == false) goto L26;
                r5 = true;
                goto L26
            L21:
                if (r3.isAllowPost() != true) goto L23;
                r16 = true;
                goto L24
            L15:
                r6 = 0;
                goto L17
            L11:
                r4 = 0;
            L7:
                r2 = null;
                goto L8
            }
        }

        public final hya.a<f5b.b> a() {
            return new a(this.b);
        }

        public final hya.b<String> b() {
            return new BasePageStore.e(this.a.c);
        }

        public f0(y6b.c<?> r1, MessageListViewModelV2 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class g implements Runnable {
        public final MessageInfo a;
        public final ErrorResult b;
        public final WeakReference<MessageListViewModelV2> c;

        @Override // java.lang.Runnable
        public final void run() {
            MessageListViewModelV2 r0 = this.c.get();     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            this.a.getMessage().setSendStatus(SendStatus.FAIL);     // Catch: Throwable -> L6
            MessageListViewModelV2.access$handleLocalMessageUpdate(r0, this.a);     // Catch: Throwable -> L6
            MessageListViewModelV2.access$handleSendMessageFailError(r0, this.b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public g(MessageListViewModelV2 r2, MessageInfo r3, ErrorResult r4) {
            Intrinsics.checkNotNullParameter(r2, "model");
            Intrinsics.checkNotNullParameter(r3, "messageInfo");
            Intrinsics.checkNotNullParameter(r4, "errorResult");
            this.a = r3;
            this.b = r4;
            this.c = new WeakReference(r2);
        }
    }

    public static final class h extends com.ss.android.lark.chatbase.model.c.b<f5b.b> {
        public h() {
        }

        @Override // com.ss.android.lark.chatbase.model.c.b
        public final f5b.b b(Object r3) {
            f5b.b r4 = (f5b.b) r3;
            Intrinsics.checkNotNullParameter(r4, "existedItem");
            r4.getMessage().setBurned(true);
            b7b.b.f(r4.getMessage());
            return r4;
        }
    }

    public static final class i extends com.ss.android.lark.chatbase.model.c.b<f5b.b> {
        public final /* synthetic */ MessageListViewModelV2 a;
        public final /* synthetic */ String b;

        @Override // com.ss.android.lark.chatbase.model.c.b
        public final f5b.b b(Object r4) {
            f5b.b r5 = (f5b.b) r4;
            Intrinsics.checkNotNullParameter(r5, "existedItem");
            Message r0 = r5.getMessage();
            r0.setUpdateTime(com.larksuite.framework.utils.e.e());
            r0.setSendStatus(SendStatus.FAIL);
            this.a.getMessageService().mb(this.b);
            return r5;
        }

        public i(MessageListViewModelV2 r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class j implements Runnable {
        public final /* synthetic */ MessageListViewModelV2 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ IMessageListComponent.c c;

        public j(MessageListViewModelV2 r1, int r2, IMessageListComponent.c r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getDataStore().p(Integer.valueOf(this.b), this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class k<T> implements AndroidThrottle.e {
        public final /* synthetic */ MessageListViewModelV2 a;

        public k(MessageListViewModelV2 r1) {
            this.a = r1;
        }

        public final void a(Collection<MessageInfo> r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            MessageListViewModelV2.access$handleUpdateMsg(this.a, r2);
        }
    }

    public static final class l implements Runnable {
        public final /* synthetic */ MessageListViewModelV2 a;
        public final /* synthetic */ Collection<String> b;
        public final /* synthetic */ Context c;

        public static final class a implements Runnable {
            public final /* synthetic */ MessageListViewModelV2 a;
            public final /* synthetic */ ArrayList<MessageInfo> b;
            public final /* synthetic */ ArrayList<String> c;

            public a(MessageListViewModelV2 r1, ArrayList<MessageInfo> r2, ArrayList<String> r3, Context r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void a() {
                this.a.getMMessageReader().c(new ArrayList(this.b));
                com.ss.android.lark.chat.chatwindow.chat.model.preload.b r0 = MessageListViewModelV2.access$getMMessageResourceLoader$p(this.a);
                if (r0 == null) goto L6;
                r0.b(this.b);
            L6:
                if ((!this.c.isEmpty()) == true) goto L8;
                return;
            L8:
                if (this.a.getMessageReadable().getValue() != null) goto L10;
            L13:
                ChatCoreModule.a().getDingDependency().a();
                return;
            L10:
                if (Intrinsics.areEqual(this.a.getMessageReadable().getValue(), Boolean.TRUE) == true) goto L13;
                ChatCoreModule.a().getDingDependency().b();
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public l(MessageListViewModelV2 r1, Collection<String> r2, Context r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            List<T> r0 = this.a.getDataStore().w(this.b);
            if ((!r0.isEmpty()) == false) goto L15;
            Log.i(TitlebarViewModel.LOG_TAG, "last message of the chat is " + CollectionsKt.lastOrNull(r0));
            Log.i(TitlebarViewModel.LOG_TAG, "handleMessageRead found items:" + this.b.size() + '/' + r0.size());
            ArrayList r1 = new ArrayList();
            ArrayList r2 = new ArrayList();
            int r3 = r0.size();
            int r4 = 0;
        L5:
            if (r4 >= r3) goto L14;
            MessageInfo r5 = (MessageInfo) ListProtector.get(r0, r4);
            Message r6 = r5.getMessage();
            if (r6.isPreMessage() == true) goto L13;
            r1.add(r5);
            if (r6.isDing() == false) goto L13;
            if (r6.isFromMe() == true) goto L13;
            r2.add(r6.getId());
        L13:
            r4 = r4 + 1;
            goto L5
        L14:
            CoreThreadPool.getDefault().getFixedThreadPool().execute(new a(this.a, r1, r2, this.c));
            return;
        L15:
            Log.e(TitlebarViewModel.LOG_TAG, "handleMessageRead not found items:" + this.b.size());
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class m implements Runnable {
        public final /* synthetic */ MessageListViewModelV2 a;
        public final /* synthetic */ String b;

        public m(MessageListViewModelV2 r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            com.ss.android.lark.im.sdk.service.h r0 = this.a.getChatterService();
            String r1 = this.a.getChatId();
            String r2 = this.b;
            Intrinsics.checkNotNull(r2);
            ChatChatter r3 = r0.He(r1, r2);
            if (r3 == null) goto L5;
            Integer r4 = Integer.valueOf(r3.getOnCallRole());
        L6:
            if (r4 != null) goto L9;
        L10:
            if (r4 != null) goto L13;
        L14:
            if (r4 != null) goto L17;
        L19:
            String r5 = UIHelper.getString(2131891449);
        L26:
            this.a.getClosePageInfo().postValue(r5);
            return;
        L17:
            if (r4.intValue() != 6) goto L19;
        L20:
            Chat r6 = (Chat) this.a.getCurrentChat().getValue();
            if (r6 == null) goto L24;
            String r7 = r6.getName();
            if (r7 == null) goto L24;
        L25:
            r5 = UIHelper.mustacheFormat(2131890891, IPortraitService.NAME, r7);
        L24:
            r7 = BuildConfig.FLAVOR;
            goto L25
        L13:
            if (r4.intValue() == 5) goto L20;
        L9:
            if (r4.intValue() == 4) goto L20;
        L5:
            r4 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class n implements UserStatusParseUrlPreViewUtils.a {
        public final /* synthetic */ MessageListViewModelV2 a;

        public n(MessageListViewModelV2 r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.utils.UserStatusParseUrlPreViewUtils.a
        public final void a(List<String> r5) {
            if (r5 == null) goto L10;
            MessageListViewModelV2 r0 = this.a;
            List<String> r6 = r5;
            LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r6, 10)), 16));
            Iterator<T> r7 = r6.iterator();
        L5:
            if (r7.hasNext() == false) goto L7;
            Object r1 = r7.next();
            r2.put((String) r1, r1);
            goto L5
        L7:
            com.ss.android.lark.chatbase.k r8 = r0.getDataStore().N();
            r8.filter(new k4b.c(r2));
            r8.a(new com.ss.android.lark.chat.chatwindow.chat.v2.model.operation.k(r0.getChatContainer().P(), null, ChatHitPointExtraParams.DataSource.FROM_SDK));
            return;
        }
    }

    public static final class o implements com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b.InterfaceC0038b {
        public final /* synthetic */ MessageListViewModelV2 a;

        public o(MessageListViewModelV2 r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b.InterfaceC0038b
        public final Integer a() {
            m2b.a r0 = this.a.getDependency().a();
            if (r0 == null) goto L7;
            lya.a r1 = r0.l();
            if (r1 == null) goto L7;
            return r1.a();
        L7:
            return null;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.v2.MessageListViewModelV2$onFollowFold$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.component.message.v2.MessageListViewModelV2$onFollowFold$1", f = "MessageListViewModelV2.kt", i = {}, l = {2209}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $count;
        final /* synthetic */ String $foldId;
        int label;
        final /* synthetic */ MessageListViewModelV2 this$0;

        public C03591(String r1, int r2, MessageListViewModelV2 r3, Continuation<? super C03591> r4) {
            this.$foldId = r1;
            this.$count = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C03591(this.$foldId, this.$count, this.this$0, r5);
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
        L15:
            com.larksuite.rucket.job.base.b.b r7 = (com.larksuite.rucket.job.base.b) r6;
            if ((r7 instanceof com.larksuite.rucket.job.base.b.b) == false) goto L18;
            ErrorResult r8 = r7.b;
            Log.e(TitlebarViewModel.LOG_TAG, "follow fold message failed: " + r8.getCode() + ':' + r8.getDisplayMsg());
            this.this$0.getToastInfo().setValue(r8.getDisplayMsg());
        L20:
            return Unit.INSTANCE;
        L18:
            Log.i(TitlebarViewModel.LOG_TAG, "follow fold success , foldId :" + this.$foldId + " ; count : " + this.$count);
            goto L20
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            PutMessageFoldFollowRequest.Builder r9 = new PutMessageFoldFollowRequest.Builder();
            Long r2 = StringsKt.toLongOrNull(this.$foldId);
            if (r2 == null) goto L11;
            long r3 = r2.longValue();
        L12:
            RucketJob<PutMessageFoldFollowResponse> r10 = MessageListViewModelV2.access$getFoldMessageService$p(this.this$0).putMessageFoldFollow(r9.fold_id(Boxing.boxLong(r3)).count(Boxing.boxInt(this.$count)).build());
            this.label = 1;
            r6 = r10.awaitGet(this);
            if (r6 != r0) goto L15;
            return r0;
        L11:
            r3 = 0;
            goto L12
        }
    }

    public static final class p implements w0 {
        public final /* synthetic */ MessageListViewModelV2 b;

        public p(MessageListViewModelV2 r1) {
            this.b = r1;
        }

        public final int a() {
            Chat r0 = (Chat) this.b.getCurrentChat().getValue();
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getFirstMessagePosition();
        }
    }

    public static final class q implements Runnable {
        public static final q a = null;

        static {
            a = new q();
        }

        public q() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            new SampleConfigParser().initConfig();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class r implements com.ss.android.lark.chat.chatwindow.chat.v2.push.o.c {
        public final /* synthetic */ MessageListViewModelV2 a;

        public r(MessageListViewModelV2 r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.o.c
        public final MessageInfo getMessageById(String r2) {
            return (MessageInfo) this.a.getDataStore().u(r2);
        }
    }

    public static final class s implements com.ss.android.lark.chat.chatwindow.chat.v2.push.o.c {
        public final /* synthetic */ MessageListViewModelV2 a;

        public s(MessageListViewModelV2 r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.o.c
        public final MessageInfo getMessageById(String r2) {
            return (MessageInfo) this.a.getDataStore().u(r2);
        }
    }

    public static final class t implements Runnable {
        public final /* synthetic */ MessageListViewModelV2 a;

        public t(MessageListViewModelV2 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.ss.android.lark.chat.chatwindow.chat.model.preload.b r1 = MessageListViewModelV2.access$getMMessageResourceLoader$p(this.a);     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            r1.c("mini_app", null, null, null, null);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class u implements com.ss.android.lark.biz.im.api.extension.message.c {
        public final /* synthetic */ MessageListViewModelV2 a;

        public u(MessageListViewModelV2 r1) {
            this.a = r1;
        }

        public final void a(List<? extends hya.c<String, f5b.b>> r2) {
            Intrinsics.checkNotNullParameter(r2, "patchList");
            this.a.getDataStore().l(r2);
        }
    }

    public static final class v implements com.ss.android.lark.chat.chatwindow.chat.model.viewdata.a.InterfaceC0054a {
        public final /* synthetic */ MessageListViewModelV2 a;

        @Override // com.ss.android.lark.chat.chatwindow.chat.model.viewdata.a.InterfaceC0054a
        public final boolean a() {
            return this.a.canLoadMore();
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.model.viewdata.a.InterfaceC0054a
        public final boolean isSecret() {
            Chat r0 = MessageListViewModelV2.access$getInitChat$p(this.a);
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isSecret();
        }

        public v(MessageListViewModelV2 r1) {
            this.a = r1;
        }
    }

    public static final class w implements BasePageStore.c<MessageInfo> {
        public final /* synthetic */ MessageListViewModelV2 a;

        public static final class a implements Runnable {
            public final /* synthetic */ MessageListViewModelV2 a;

            public a(MessageListViewModelV2 r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.loadPrePage(null);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.ss.android.lark.chatbase.BasePageStore.c
        public final void a() {
            MessageListViewModelV2.access$getMBackgroundExecutor$p(this.a).execute(new a(this.a));
        }

        public w(MessageListViewModelV2 r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chatbase.BasePageStore.c
        public final void b(List<MessageInfo> r2) {
            if (r2 != null) goto L5;
            return;
        L5:
            if (CollectionUtils.isNotEmpty(r2) == false) goto L8;
            this.a.getNewMessageItemsAppend().postValue(r2);
            return;
        }

        @Override // com.ss.android.lark.chatbase.BasePageStore.c
        public final void c(List<MessageInfo> r2) {
            Intrinsics.checkNotNullParameter(r2, "newDataList");
            if (CollectionUtils.isNotEmpty(r2) == false) goto L6;
            this.a.getNewMessageItems().postValue(r2);
            return;
        }
    }

    public static final class x extends com.ss.android.lark.chatbase.model.c.b<f5b.b> {
        public x() {
        }

        @Override // com.ss.android.lark.chatbase.model.c.b
        public final f5b.b b(Object r2) {
            f5b.b r3 = (f5b.b) r2;
            Intrinsics.checkNotNullParameter(r3, "existedItem");
            return r3;
        }
    }

    public static final class y implements Runnable {
        public final /* synthetic */ MessageListViewModelV2 a;

        public y(MessageListViewModelV2 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ImageLoader.clearMemoryCache(MessageListViewModelV2.access$getContext$p(this.a));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class z implements aqb.d {
        public final /* synthetic */ MessageListViewModelV2 a;

        public z(MessageListViewModelV2 r1) {
            this.a = r1;
        }

        public final void a(boolean r1) {
            if (r1 == false) goto L5;
            MessageListViewModelV2.access$syncWSReconnect(this.a);
            return;
        }
    }

    static {
        Companion = new f();
    }

    private final synchronized AndroidThrottle<MessageInfo> getMsgUpdateThrottle() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mMessageUpdateThrottle != null) goto L6;
        AndroidThrottle.a r0 = new AndroidThrottle.a();     // Catch: Throwable -> L9
        r0.b = 300;     // Catch: Throwable -> L9
        r0.c = 2;     // Catch: Throwable -> L9
        r0.a = CoreThreadPool.getNonblockingHandler();     // Catch: Throwable -> L9
        r0.d = new com.ss.android.lark.chat.chatwindow.chat.model.push.b();     // Catch: Throwable -> L9
        r0.e = new k(this);     // Catch: Throwable -> L9
        this.mMessageUpdateThrottle = r0.a();     // Catch: Throwable -> L9
    L6:
        AndroidThrottle<MessageInfo> r1 = this.mMessageUpdateThrottle;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void onAuditedFailed(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public void onTrimMemory(int r1, int r2, int r3, int r4) {
    }

    private final com.ss.android.lark.auditsdk.v2.receivecheck.a getMIMFileAuthorityChecker() {
        return (com.ss.android.lark.auditsdk.v2.receivecheck.a) this.mIMFileAuthorityChecker$delegate.getValue();
    }

    private final void initMessageSampleConfig() {
        this.mBackgroundExecutor.execute(q.a);
    }

    private final boolean isEnableGenerateDigest() {
        return ((Boolean) this.isEnableGenerateDigest$delegate.getValue()).booleanValue();
    }

    private final void openDataMapPreProcess() {
        x4b.c<MessageInfo, y6b.c<?>> r0 = this.dataMapper;
        if ((r0 instanceof u2b.h) == true) goto L5;
        return;
    L5:
        if ((r0 instanceof u2b.h) == false) goto L7;
        u2b.h r1 = (u2b.h) r0;
    L8:
        if (r1 == null) goto L12;
        r1.a(false);
        return;
    L12:
        return;
    L7:
        r1 = null;
        goto L8
    }

    private final void registerConnectionStateChangeListener() {
        this.mConnectionStateListener = new z(this);
        ChatCoreModule.a().getWschannelDependency().a(this.mConnectionStateListener);
    }

    private final void syncWSReconnect() {
        Log.i(TitlebarViewModel.LOG_TAG, "ws reconnect");
        this.mBackgroundExecutor.execute(new e0(this));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public boolean canLoadMore() {
        return this.messageListRepository.canLoadMore();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public boolean canLoadPre() {
        return this.messageListRepository.canLoadPre();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void destroy() {
        if (this.destroyed == true) goto L27;
        MemoryCallbackManager.getInstance().unRegisterMemoryCallback(this);
        this.pushManager.c();
        this.mCallbackManager.cancelCallbacks();
        com.larksuite.framework.callback.c r0 = this.mCancelableExecutor;
        if (r0 == null) goto L7;
        r0.d();
    L7:
        ActionDispatcher r1 = this.mActionDispatcher;
        if (r1 == null) goto L10;
        r1.unregisterActionHandler(getDataStore());
    L10:
        this.mBackgroundExecutor.shutdown();
        this.mMessageHandlerExecutor.shutdown();
        com.ss.android.lark.chat.chatwindow.chat.model.preload.b r2 = this.mMessageResourceLoader;
        if (r2 == null) goto L13;
        r2.destroy();
    L13:
        ChatCoreModule.a().getWschannelDependency().b(this.mConnectionStateListener);
        ChatCoreModule.a().getChatDependency().l();
        c2b.d r3 = c2b.d.b(getChatId());
        Map<String, c2b.d> r4 = c2b.d.f;
        monitor-enter(r4);
        ((HashMap) r4).clear();     // Catch: Throwable -> L24
        monitor-exit(r4);     // Catch: Throwable -> L24
        r3.d.shutdown();
        HashMap<String, d2b.a> r5 = d2b.a.c;
        d2b.a.C0208a.a(getChatId()).b();
        getMMessageReader().b();
        com.ss.android.lark.chat.chatwindow.chat.model.preload.d.a.clear();
        o1.a.clear();
        MarkdownPlugin.Companion r6 = MarkdownPlugin.b;
        MarkdownPlugin.Companion.a();
        getMIMFileAuthorityChecker().destroy();
        MessageListPinExtraLoader r7 = getPinExtraLoader();
        if (r7 != null) goto L20;
    L23:
        this.destroyed = true;
        return;
    L20:
        if (r7.b == false) goto L23;
        r7.d().clear();
        ((CopyOnWriteArrayList) r7.e.getValue()).clear();
        CoroutineScopeKt.cancel$default(r7, null, 1, null);
    L24:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void notifyDataChange() {
        com.ss.android.lark.chat.core.model.b<y6b.c<?>, MessageInfo> r0 = this.mDataListPipeline;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    public void onJavaMemoryReachTop() {
        Log.i(TitlebarViewModel.LOG_TAG, "onJavaMemoryReachTop");
        com.ss.android.lark.chat.core.model.a.b = 10;
        BasePageStore<MessageInfo, x4b.a<MessageInfo>> r0 = getDataStore();
        if ((r0 instanceof q3b.m) == false) goto L5;
        q3b.m r1 = (q3b.m) r0;
    L6:
        if (r1 == null) goto L8;
        r1.V();
    L8:
        boolean r2 = z6b.a.a;
        z6b.a.a = true;
        CodeBlockV2ThemeManager.a();
        TextLayoutBuilder.b();
        z2b.a r3 = getDependency().r();
        if (r3 == null) goto L11;
        r3.clearCache();
    L11:
        ThreadUtils.runOnUIThread(new y(this));
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a r4 = this.textLayoutPreCalculator;
        if (r4 == null) goto L14;
        r4.a(false);
    L14:
        ChatCoreModule.a().getChatDependency().r();
        g6b.a.InterfaceC0223a r5 = g6b.a.a;
        g6b.a.InterfaceC0223a r6 = g6b.a.a;
        if (r6 == null) goto L17;
        r6.clearAllUrlCache();
    L17:
        TableUtils.a = null;
        ColumnsUtils.a = null;
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void checkToClearBadge() {
        Chat r0 = (Chat) getCurrentChat().getValue();
        if (r0 == null) goto L6;
        Channel r1 = new Channel(Channel.Type.CHAT, getChatId());
        j7b.a.C0239a.a.a(r0).a(r1, r0.getLastMessagePosition(), r0.getLastMessagePositionBadgeCount(), r0.isSuper());
        return;
    }

    private final void handleQuitOnCallGroup() {
        String r0 = ChatCoreModule.a().getLoginDependency().getUserId();
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new m(this, r0));
    }

    private final boolean isLowDevice() {
        DevicePerfUtils.DevicePerfLevel r0 = DevicePerfUtils.d();
        if (r0 != DevicePerfUtils.DevicePerfLevel.LOW) goto L5;
    L8:
        return true;
    L5:
        if (r0 == DevicePerfUtils.DevicePerfLevel.ULTRALOW) goto L8;
        return false;
    }

    private final void updateFoldCardWhenChatChange() {
        List r0 = (List) getMessageList().getValue();
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        ListIterator r1 = r0.listIterator(r0.size());
    L7:
        if (r1.hasPrevious() == false) goto L14;
        Object r2 = r1.previous();
        if (((y6b.c) r2).G == null) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L7;
    L15:
        y6b.c r4 = (y6b.c) r2;
        if (r4 != null) goto L19;
        Log.d(TitlebarViewModel.LOG_TAG, "last fold message is null , method return");
        return;
    L19:
        batchUpdateMsg(CollectionsKt.listOf(new f0(r4, this)));
        return;
    L11:
        r3 = false;
        goto L12
    L14:
        r2 = null;
        goto L15
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void changeMessageAlignIfNeed() {
        ChatCoreModule.a().getChatDependency().o();
        if (true != this.selfMessageRTLDisplay) goto L5;
        return;
    L5:
        this.selfMessageRTLDisplay = true;
        ChatCoreRuntimeProvider r2 = ChatCoreRuntimeProvider.a;
        com.ss.android.lark.chat.chatwindow.chat.v2.push.v r3 = getChatContainer();
        m2b.a r4 = getDependency().a();
        Chat r0 = this.initChat;
        if (r0 == null) goto L8;
        boolean r5 = r0.isSecret();
    L9:
        x4b.c<MessageInfo, y6b.c<?>> r1 = r2.d(r3, r4, r5, true, this.textLayoutPreCalculator);
        this.dataMapper = r1;
        if (r1 == null) goto L17;
        com.ss.android.lark.chat.core.model.b<y6b.c<?>, MessageInfo> r6 = this.mDataListPipeline;
        if (r6 == null) goto L14;
        ObservableMappedArrayList<String, T> r7 = getDataStore().b;
        r7.removeOnListUpdateCallback(r6);
        com.ss.android.lark.chat.core.model.b<y6b.c<?>, MessageInfo> r8 = new com.ss.android.lark.chat.core.model.b(r7, r1, r6.g, r6.f);
    L15:
        this.mDataListPipeline = r8;
        return;
    L14:
        r8 = null;
        goto L15
    L17:
        return;
    L8:
        r5 = false;
        goto L9
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public Integer getExpiredPeriodTime() {
        BasePageStore<MessageInfo, x4b.a<MessageInfo>> r0 = getDataStore();
        if ((r0 instanceof q3b.m) == false) goto L5;
        q3b.m r1 = (q3b.m) r0;
    L6:
        if (r1 == null) goto L8;
        int r2 = r1.r;
    L10:
        return Integer.valueOf(r2);
    L8:
        r2 = 0;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel, com.ss.android.lark.chat.chatwindow.chat.v2.push.l0.d
    public MessageInfo getTopicMessageInfo() {
        return getDataStore().y();
    }

    public void onCleared() {
        super.onCleared();
        destroy();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel, com.ss.android.lark.chat.chatwindow.chat.v2.push.f.a
    public void onFileDownloadFail() {
        getToastInfo().postValue(UIHelper.getString(2131891736));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel, com.ss.android.lark.chat.chatwindow.chat.v2.push.f.a, com.ss.android.lark.chat.chatwindow.chat.v2.push.y
    public com.ss.android.lark.chatbase.l<f5b.b> stream() {
        return getDataStore().N();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public fxa.b getChatBundle() {
        return this.chatBundle;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public com.ss.android.lark.chat.chatwindow.chat.v2.push.v getChatContainer() {
        return this.chatContainer;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public String getChatId() {
        return this.chatId;
    }

    public final ImSdkChatService getChatService() {
        return this.chatService;
    }

    public final com.ss.android.lark.im.sdk.service.h getChatterService() {
        return this.chatterService;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public MutableLiveData<String> getClosePageInfo() {
        return this.closePageInfo;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public MutableLiveData<Chat> getCurrentChat() {
        return this.currentChat;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public BasePageStore<MessageInfo, x4b.a<MessageInfo>> getDataStore() {
        return this.dataStore;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p getDependency() {
        return this.dependency;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public MutableLiveData<Pair<String, String>> getDialogInfo() {
        return this.dialogInfo;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public com.ss.android.lark.biz.im.api.f0 getMMessageReader() {
        return this.mMessageReader;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public MutableLiveData<List<y6b.c<?>>> getMessageList() {
        return this.messageList;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public MutableLiveData<Boolean> getMessageReadable() {
        return this.messageReadable;
    }

    public final com.ss.android.lark.im.sdk.service.p getMessageService() {
        return this.messageService;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public MutableLiveData<Boolean> getNeedRelocateMessage() {
        return this.needRelocateMessage;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public MutableLiveData<List<MessageInfo>> getNewMessageItems() {
        return this.newMessageItems;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public MutableLiveData<List<MessageInfo>> getNewMessageItemsAppend() {
        return this.newMessageItemsAppend;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public MutableLiveData<ChatChatter> getP2pChatterLiveData() {
        return this.p2pChatterLiveData;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public MessageListPinExtraLoader getPinExtraLoader() {
        return this.pinExtraLoader;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public MutableLiveData<ChatChatter> getSelfChatterLiveData() {
        return this.selfChatterLiveData;
    }

    public final boolean getSelfMessageRTLDisplay() {
        return this.selfMessageRTLDisplay;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public int getShowPosition() {
        return this.showPosition;
    }

    public final ChatTeamBundle getTeamBundle() {
        return this.teamBundle;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public MutableLiveData<String> getToastInfo() {
        return this.toastInfo;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public s2b.e getUIModel() {
        return this.mUIModel;
    }

    public static final /* synthetic */ Context access$getContext$p(MessageListViewModelV2 r0) {
        return r0.context;
    }

    public static final /* synthetic */ m6b.i access$getFoldMessageService$p(MessageListViewModelV2 r0) {
        return r0.foldMessageService;
    }

    public static final /* synthetic */ Chat access$getInitChat$p(MessageListViewModelV2 r0) {
        return r0.initChat;
    }

    public static final /* synthetic */ x4b.d access$getMBackgroundExecutor$p(MessageListViewModelV2 r0) {
        return r0.mBackgroundExecutor;
    }

    public static final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.push.o access$getMChatRelationPushHandler$p(MessageListViewModelV2 r0) {
        return r0.mChatRelationPushHandler;
    }

    public static final /* synthetic */ WeakReference access$getMDependencyRefs$p(MessageListViewModelV2 r0) {
        return r0.mDependencyRefs;
    }

    public static final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.model.viewdata.a access$getMExtraItemInterceptor$p(MessageListViewModelV2 r0) {
        return r0.mExtraItemInterceptor;
    }

    public static final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.model.preload.b access$getMMessageResourceLoader$p(MessageListViewModelV2 r0) {
        return r0.mMessageResourceLoader;
    }

    public static final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.push.c0 access$getPushManager$p(MessageListViewModelV2 r0) {
        return r0.pushManager;
    }

    public static final /* synthetic */ void access$openDataMapPreProcess(MessageListViewModelV2 r0) {
        r0.openDataMapPreProcess();
    }

    public static final /* synthetic */ void access$syncWSReconnect(MessageListViewModelV2 r0) {
        r0.syncWSReconnect();
    }

    private final void handleChatChange(Chat r3) {
        if (TextUtils.equals(getChatId(), r3.getId()) == true) goto L5;
        return;
    L5:
        Log.i(TitlebarViewModel.LOG_TAG, "onPushChatId:" + r3.getId());
        getCurrentChat().postValue(r3);
    }

    private final void handleLocalMessageUpdate(MessageInfo r4) {
        getDataStore().O(new q3b.o(r4.getMessage()), new s3b.f(r4));
    }

    private final void handleQuitGroup(Chat r4) {
        m2b.a r0 = getDependency().a();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.Y() != true) goto L7;
    L8:
        if (r1 == false) goto L17;
        Chat r2 = this.initChat;
        if (r2 == null) goto L12;
        Chat.Role r3 = r2.getRole();
    L14:
        if (r3 == Chat.Role.MEMBER) goto L17;
        return;
    L12:
        r3 = null;
    L17:
        if (this.mDissolveGroupByLocalFlag == false) goto L19;
    L25:
        getClosePageInfo().postValue(BuildConfig.FLAVOR);
    L26:
        w4b.m r5 = ChatCoreModule.a().getFeedDependency();
        new Channel(Channel.Type.CHAT, getChatId());
        r5.d();
        return;
    L19:
        if (this.mQuitGroupBySelf == true) goto L25;
        if (r4.isOnCall() == false) goto L24;
        handleQuitOnCallGroup();
        goto L26
    L24:
        scheduleQuitGroup(r4);
    L7:
        r1 = false;
        goto L8
    }

    private final void handleSendMessageFailError(ErrorResult r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r0 = r5.getErrorCode();
        if (r0 != 4042) goto L11;
        Chat r6 = (Chat) getCurrentChat().getValue();
        if (r6 != null) goto L9;
        return;
    L9:
        String r7 = UIHelper.mustacheFormat(2131890793, "group_name", r6.getName());
        getToastInfo().postValue(r7);
        return;
    L11:
        if (r0 != 5007) goto L14;
        getToastInfo().postValue(r5.getDisplayMsg(UIHelper.getString(2131891929)));
        return;
    L14:
        if (r0 != 5009) goto L16;
    L43:
        getToastInfo().postValue(r5.getDisplayMsg());
        return;
    L16:
        if (r0 == 6003) goto L43;
        if (r0 == 105504) goto L43;
        if (r0 == 4506) goto L43;
        if (r0 != 321000) goto L26;
        String r1 = ChatCoreModule.a().getAuditDependency().getUploadAuthorizationTip();
        String r2 = UIUtils.getString(this.context, 2131890278);
        getDialogInfo().postValue(new Pair(r2, r5.getDisplayMsg(r1)));
        return;
    L26:
        if (r0 != 4029) goto L29;
        String r3 = UIHelper.getString(2131890721);
        getDialogInfo().postValue(TuplesKt.to(null, r5.getDisplayMsg(r3)));
        return;
    L29:
        if (r0 != 260014) goto L34;
        String r8 = r5.getDisplayMsg();
        if (r8 == null) goto L49;
        getToastInfo().postValue(r8);
        return;
    L49:
        return;
    L34:
        if (r0 != owa.a.d().getUnifiedStorageLimitErrorCode()) goto L37;
        Activity r9 = Contexts.requireActivity(this.context);
        owa.a.d().showUnifiedStorageLimitCTADialog(r9);
        return;
    L37:
        if (owa.a.d().isHitStorageQuotaLimit(r0) == false) goto L40;
        Activity r10 = Contexts.requireActivity(this.context);
        owa.a.d().showQuotaLimitDialog(r10, r0);
        return;
    L40:
        if (r0 != 321001) goto L42;
        Log.i(TAG, "do nothing.");
        return;
    L42:
        String r4 = UIHelper.getString(2131891714);
        getToastInfo().postValue(r5.getDisplayMsg(r4));
    }

    private final void handleSignUrlRequest(Collection<UserStatusParseUrlPreViewUtils.b> r3) {
        UserStatusParseUrlPreViewUtils.b(getChatContainer().P(), r3, new n(this));
    }

    private final void handleUpdateMsg(Collection<? extends MessageInfo> r4) {
        BasePageStore<MessageInfo, x4b.a<MessageInfo>> r0 = getDataStore();
        r0.a.execute(new com.ss.android.lark.chatbase.g(r0, r4));
    }

    private final BasePageStore<MessageInfo, x4b.a<MessageInfo>> initDataStore(Chat r25) {
        w2b.b r5 = new w2b.b();
        r5.c(getDependency().r());
        boolean r8 = false;
        r5.b.a = false;
        r5.c.a = false;
        if (r25 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        u2b.h r10 = null;
        if (r2 == false) goto L11;
        ChatTextLayoutPreCalculator r11 = null;
    L12:
        this.textLayoutPreCalculator = r11;
        if (isLowDevice() == true) goto L17;
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a r3 = this.textLayoutPreCalculator;
        if (r3 == null) goto L17;
        r3.a(true);
    L17:
        ChatCoreRuntimeProvider r12 = ChatCoreRuntimeProvider.a;
        com.ss.android.lark.chat.chatwindow.chat.v2.push.v r13 = getChatContainer();
        m2b.a r14 = getDependency().a();
        if (r25 == null) goto L20;
        boolean r15 = r25.isSecret();
    L21:
        x4b.c<MessageInfo, y6b.c<?>> r4 = r12.d(r13, r14, r15, this.selfMessageRTLDisplay, this.textLayoutPreCalculator);
        this.dataMapper = r4;
        if ((r4 instanceof u2b.h) == false) goto L24;
        r10 = (u2b.h) r4;
    L24:
        if (r10 == null) goto L26;
        r10.a(isEnableGenerateDigest());
    L26:
        String r6 = getChatId();
        jdb.g r7 = getChatContainer().C();
        Intrinsics.checkNotNullParameter(r7, "fgService");
        if (r25 != null) goto L30;
    L38:
        boolean r9 = false;
    L39:
        MessageListPinExtraLoader r16 = new MessageListPinExtraLoader(r6, r9);
        r16.b();
        setPinExtraLoader(r16);
        if (r25 == null) goto L42;
        this.smartApplyAnswerDependencyLoader = new q3b.r(r25);
    L42:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.v2.b r17 = new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.v2.b(getDependency().a(), getChatContainer(), this.mMessageHandlerExecutor, this.mOnDataChangeListener2, this.textLayoutPreCalculator, getPinExtraLoader(), this.smartApplyAnswerDependencyLoader, getDependency().o());
        m2b.a r18 = r17.a;
        if (r18 != null) goto L45;
    L47:
        if (r8 == false) goto L49;
        w2c.c r19 = new w2c.c(r17.a.getContext(), r17.c, r17.a.N1(), r17.a.getChat(), r17.d, new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.v2.a(r17));
    L50:
        Iterator<T> r20 = getDependency().l().iterator();
    L52:
        if (r20.hasNext() == false) goto L54;
        r19.h((com.ss.android.lark.chatbase.i) r20.next());
        goto L52
    L54:
        getDependency().e(r19);
        r19.L(new p(this));
        w0 r21 = getDependency().i();
        if (r21 == null) goto L57;
        r19.L(r21);
    L57:
        a1 r22 = getDependency().h();
        if (r22 == null) goto L60;
        r19.M(r22);
    L60:
        v0 r23 = getDependency().p();
        if (r23 == null) goto L67;
        List r24 = r23.a();
        if (r24 == null) goto L67;
        if ((!r24.isEmpty()) == false) goto L67;
        getMessageList().setValue(r24);
    L67:
        if (r25 == null) goto L69;
        int r1 = r25.getLastMessagePosition();
    L71:
        if (r19.f.get() >= r1) goto L73;
        r19.f.set(r1);
    L73:
        return r19;
    L69:
        r1 = -1;
        goto L71
    L49:
        r19 = new q3b.m(r17.b, r17.c, r17.d, r17.e, r17.f, r17.g, r17.h);
        goto L50
    L45:
        if (r18.Y() != true) goto L47;
        r8 = true;
        goto L47
    L30:
        if (r25.isSecret() == true) goto L38;
        TeamUtils.b(r25);
        if (r7.isEnable("im.chat.pinned.url") == false) goto L38;
        if (r25.isThread() == true) goto L38;
        if (r25.isOnCall() == true) goto L38;
        r9 = true;
        goto L39
    L20:
        r15 = false;
        goto L21
    L11:
        r11 = new ChatTextLayoutPreCalculator(this.context, getMIMFileAuthorityChecker(), r5, getDependency().a(), getDependency().d());
        r11.g = new o(this);
        goto L12
    L5:
        if (r25.isSecret() != true) goto L7;
        r2 = true;
        goto L8
    }

    private final void initPushHandler(Chat r26) {
        Integer r0 = getDependency().v();
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        Log.i(TAG, "pushFlags: " + Integer.toBinaryString(r1));
        if (r1 != 0) goto L10;
        Log.i(TAG, "all push is disabled by flags");
        return;
    L10:
        final com.ss.android.lark.chat.chatwindow.chat.v2.push.f r11 = new com.ss.android.lark.chat.chatwindow.chat.v2.push.f(getChatId(), this);
        final com.ss.android.lark.chat.chatwindow.chat.v2.push.q r12 = new com.ss.android.lark.chat.chatwindow.chat.v2.push.q(getChatId(), this);
        final com.ss.android.lark.chat.chatwindow.chat.v2.push.e r13 = new com.ss.android.lark.chat.chatwindow.chat.v2.push.e(getChatId(), this);
        final com.ss.android.lark.chat.chatwindow.chat.v2.push.r r14 = new com.ss.android.lark.chat.chatwindow.chat.v2.push.r(this);
        final com.ss.android.lark.chat.chatwindow.chat.v2.push.d r15 = new com.ss.android.lark.chat.chatwindow.chat.v2.push.d(getChatId(), this);
        final com.ss.android.lark.chat.chatwindow.chat.v2.push.i r9 = new com.ss.android.lark.chat.chatwindow.chat.v2.push.i(getChatContainer().z(), this);
        final com.ss.android.lark.chat.chatwindow.chat.v2.push.g r8 = new com.ss.android.lark.chat.chatwindow.chat.v2.push.g(this);
        final com.ss.android.lark.chat.chatwindow.chat.v2.push.p r7 = new com.ss.android.lark.chat.chatwindow.chat.v2.push.p(getChatId(), getChatContainer().N(), this);
        final ChatFileAuthorityPushHandler r6 = new ChatFileAuthorityPushHandler(getMIMFileAuthorityChecker(), this);
        final ChatPinExtraPushHandler r5 = new ChatPinExtraPushHandler(getPinExtraLoader(), new MessageListViewModelV2$initPushHandler$pinExtraPushHandler$1(this));
        final com.ss.android.lark.chat.chatwindow.chat.v2.push.s r4 = new com.ss.android.lark.chat.chatwindow.chat.v2.push.s(getChatContainer().F(), getChatContainer().E(), this);
        if (r26 == null) goto L13;
        this.mChatRelationPushHandler = new com.ss.android.lark.chat.chatwindow.chat.v2.push.o(r26, getChatContainer().Q(), getChatContainer().L(), this, new r(this));
        runWhenPushIsEnabled(getDependency().v(), 512, new MessageListViewModelV2$initPushHandler$1$2(this));
    L14:
        if (r26 == null) goto L21;
        m2b.a r2 = getDependency().a();
        if (r2 == null) goto L18;
        ThreadTopic r3 = r2.N1();
    L19:
        final l0 r10 = new l0(r26, r3, getChatContainer().Q(), getChatContainer().L(), getChatContainer().N(), this.mMessageHandlerExecutor, this, this, new s(this));
        runWhenPushIsEnabled(getDependency().v(), 8192, new MessageListViewModelV2$initPushHandler$3$1(this, r10));
        goto L21
    L18:
        r3 = null;
    L21:
        runWhenPushIsEnabled(getDependency().v(), 2, new AnonymousClass4(this, r11));
        runWhenPushIsEnabled(getDependency().v(), 4, new AnonymousClass5(this, r12));
        runWhenPushIsEnabled(getDependency().v(), 8, new AnonymousClass6(this, r13));
        runWhenPushIsEnabled(getDependency().v(), 16, new AnonymousClass7(this, r14));
        runWhenPushIsEnabled(getDependency().v(), 32, new AnonymousClass8(this, r15));
        runWhenPushIsEnabled(getDependency().v(), 64, new AnonymousClass9(this, r9));
        runWhenPushIsEnabled(getDependency().v(), 128, new AnonymousClass10(this, r8));
        runWhenPushIsEnabled(getDependency().v(), 256, new AnonymousClass11(this, r7));
        runWhenPushIsEnabled(getDependency().v(), 1, new AnonymousClass12(this, r6));
        runWhenPushIsEnabled(getDependency().v(), ChameleonContainerUtils.MAX_URL_LENGTH, new AnonymousClass13(this));
        runWhenPushIsEnabled(getDependency().v(), 2048, new AnonymousClass14(this, r5));
        runWhenPushIsEnabled(getDependency().v(), 4096, new AnonymousClass15(this, r4));
        this.pushManager.b();
        return;
    L13:
        Log.i(TAG, "ChatRelationPushHandler is disabled, because Chat is null");
        goto L14
    L5:
        r1 = -8193;
        goto L6
    }

    private final void loadMissingData(List<Integer> r4) {
        final long r0 = SystemClock.elapsedRealtime();
        IGetDataCallback<Boolean> r2 = new MessageListViewModelV2$loadMissingData$callback$1(r0, this);
        this.messageListRepository.d(r4, r2);
    }

    private final boolean needToReloadMessageBeforeSend(Chat r6) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p r0 = this.mDependencyRefs.get();
        if (r0 == null) goto L9;
        s0 r1 = r0.b();
        if (r1 == null) goto L9;
        Integer r2 = r1.a(r6);
        if (r2 == null) goto L9;
        int r7 = r2.intValue();
    L10:
        BasePageStore<MessageInfo, x4b.a<MessageInfo>> r3 = getDataStore();
        if (r3.d != Integer.MIN_VALUE) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == true) goto L18;
    L20:
        return false;
    L18:
        if (r7 <= getDataStore().d) goto L20;
        return true;
    L13:
        if (r3.c == Integer.MAX_VALUE) goto L15;
        r4 = true;
    L9:
        r7 = r6.getLastMessagePosition();
        goto L10
    }

    private final void notifyMessageChange(String r3) {
        getDataStore().P(r3, new x());
    }

    private final void reloadFirstScreenData(List<? extends MessageInfo> r3) {
        this.mBackgroundExecutor.execute(new a0(this, r3));
    }

    private final void retrySendMessageInner(final MessageInfo r5) {
        Message r0 = r5.getMessage();
        IGetDataCallback<String> r1 = new MessageListViewModelV2$retrySendMessageInner$callback$1(this, r5);
        this.messageService.X3(r0, this.mCallbackManager.wrapAndAddCallback(wrapResendCallback(r5, r1)));
    }

    private final void scheduleQuitGroup(Chat r3) {
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new c0(this, r3));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void addSticker(String r4) {
        Intrinsics.checkNotNullParameter(r4, "messageId");
        MessageInfo r5 = getMessageInfoById(r4);
        if (r5 != null) goto L5;
        return;
    L5:
        final Message r6 = r5.getMessage();
        if (r6.getType() != Message.Type.STICKER) goto L20;
        Content r0 = r6.getContent();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.StickerContent");
        StickerContent r1 = (StickerContent) r0;
        if (r1.isPaid() == true) goto L11;
        getToastInfo().postValue(UIHelper.getString(2131890423));
        return;
    L11:
        String r2 = r1.getKey();
        ArrayList r3 = new ArrayList();
        if (r2 == null) goto L14;
        r3.add(r2);
    L14:
        Sticker r7 = u2b.o.a(r1);
        if (r7 != null) goto L18;
        Log.e(TitlebarViewModel.LOG_TAG, "addSticker2 called. sticker is null");
        return;
    L18:
        IGetDataCallback<Boolean> r8 = new MessageListViewModelV2$addSticker$callback$1(this, r6);
        this.mStickerService.n0(CollectionsKt.listOf(r7), (IGetDataCallback) this.mCallbackManager.wrapAndAddCallback(r8));
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void batchUpdate(f5b.b r4) {
        Intrinsics.checkNotNullParameter(r4, "needUpdateMessage");
        BasePageStore<MessageInfo, x4b.a<MessageInfo>> r0 = getDataStore();
        r0.a.execute(new com.ss.android.lark.chatbase.e(r0, r4));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void batchUpdateMsg(List<? extends hya.c<String, f5b.b>> r2) {
        Intrinsics.checkNotNullParameter(r2, "patchProviderList");
        getDataStore().l(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void burnMsg(String r3) {
        Intrinsics.checkNotNullParameter(r3, "msgId");
        getDataStore().P(r3, new h());
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public boolean containsPosition(int r2) {
        if (getDataStore().d >= r2) goto L5;
    L7:
        return false;
    L5:
        if (getDataStore().c > r2) goto L7;
        return true;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void deleteUrlPreview(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "messageId");
        MessageInfo r0 = getMessageInfoById(r4);
        if (r0 != null) goto L5;
        return;
    L5:
        final MessageUrlPreview r1 = r0.d(r0);
        IGetDataCallback<a2b.b> r2 = new MessageListViewModelV2$deleteUrlPreview$dataCallback$1(this, r4, r1);
        if (r1 == null) goto L9;
        String r3 = r1.getMessageId();
        r1.getSequenceId();
        a2b.b r5 = new a2b.b(r3);
        getChatContainer().P().ba(r5, this.mCallbackManager.wrapAndAddGetDataCallback(r2));
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void ensureLastPageDataLoaded(final IGetDataCallback<Integer> r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        Chat r0 = (Chat) getCurrentChat().getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        if (needToReloadMessageBeforeSend(r0) == false) goto L17;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p r1 = this.mDependencyRefs.get();
        if (r1 == null) goto L13;
        s0 r2 = r1.b();
        if (r2 == null) goto L13;
        Integer r3 = r2.a(r0);
        if (r3 == null) goto L13;
        final int r5 = r3.intValue();
    L14:
        tryToLoadSpecificPosition(r5, (IGetDataCallback) this.mCallbackManager.wrapAndAddCallback(new MessageListViewModelV2$ensureLastPageDataLoaded$1$1(r4, r5)));
        return;
    L13:
        r5 = r0.getLastMessagePosition();
        goto L14
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void executeMessage(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        this.mMessageHandlerExecutor.execute(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public MessageInfo getDataOnPosition(int r4) {
        CopyOnWriteArrayList r0 = new CopyOnWriteArrayList();
        r0.addAll(getDataStore().b);
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Object r2 = r1.next();
        if (((MessageInfo) r2).getMessage().getPosition() != r4) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L13:
        return (MessageInfo) r2;
    L8:
        r3 = false;
        goto L9
    L11:
        r2 = null;
        goto L13
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public MessageInfo getMessageInfoById(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        return (MessageInfo) getDataStore().u(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public List<MessageInfo> getMessageInfoByIds(Collection<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "msgIds");
        return getDataStore().w(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void handleShowMoreTextClick(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        this.mUIModel.e(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void invalidGroupShare(String r4) {
        Intrinsics.checkNotNullParameter(r4, "msgId");
        getChatContainer().j0().U6(r4, (IGetDataCallback) this.mCallbackManager.wrapAndAddCallback(new C03581(this)));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void loadFirstPage(boolean r2) {
        IGetDataCallback<ChatMessageResponse> r3 = new MessageListViewModelV2$loadFirstPage$newCallback$1(this);
        this.messageListRepository.c(r3);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void loadNextPage(final IGetDataCallback<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        q3b.q r0 = new q3b.q(getDataStore(), new MessageListViewModelV2$loadNextPage$pageResultReceiver$1(r4));
        this.messageListRepository.e(r0);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void loadPrePage(final IGetDataCallback<Unit> r4) {
        if (getDataStore().c > 0) goto L5;
        return;
    L5:
        q3b.q r0 = new q3b.q(getDataStore(), new MessageListViewModelV2$loadPrePage$pageResultReceiver$1(r4));
        this.messageListRepository.a(r0);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel, com.ss.android.lark.chat.chatwindow.chat.v2.push.o.d
    public void onPushChat(Chat r10) {
        Intrinsics.checkNotNullParameter(r10, "chat");
        if (this.teamBundle != null) goto L5;
    L36:
        handleChatChange(r10);
        if (r10.isDissolved() == false) goto L40;
        handleQuitGroup(r10);
    L40:
        if (getDependency().o() == false) goto L48;
        updateFoldCardWhenChatChange();
        return;
    L48:
        return;
    L5:
        if (TeamUtils.a((Chat) getCurrentChat().getValue(), Long.valueOf(this.teamBundle.a)) == false) goto L36;
        if (r10.getRole() == Chat.Role.MEMBER) goto L32;
        List<ChatTeamInfo> r0 = r10.getBoundTeamInfos();
        boolean r1 = false;
        if (r0 == null) goto L28;
        List<ChatTeamInfo> r2 = r0;
        if ((r2 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r3 = r2.iterator();
    L17:
        if (r3.hasNext() == false) goto L14;
        ChatTeamInfo r4 = (ChatTeamInfo) r3.next();
        if (r4.teamId == this.teamBundle.a) goto L21;
    L23:
        boolean r5 = false;
    L24:
        if (r5 == false) goto L17;
        boolean r6 = true;
    L26:
        if (true != r6) goto L28;
        r1 = true;
        goto L28
    L21:
        if (r4.teamChatType == TeamChatType.OPEN) goto L23;
        r5 = true;
    L14:
        r6 = false;
        goto L26
    L13:
        if (r2.isEmpty() == false) goto L15;
    L28:
        if (r1 == false) goto L32;
        getClosePageInfo().postValue(UIHelper.getString(2131891449));
        return;
    L32:
        if (TeamUtils.a(r10, Long.valueOf(this.teamBundle.a)) == true) goto L35;
        TeamUtils.c(this.context, r10, this.teamBundle.a);
        Log.i(TitlebarViewModel.LOG_TAG, "team reopen chat");
        return;
    L35:
        Log.w(TitlebarViewModel.LOG_TAG, "invalid state");
        goto L36
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel, com.ss.android.lark.chat.chatwindow.chat.v2.push.o.d
    public void onPushChatRemoveMe(Chat r2) {
        Intrinsics.checkNotNullParameter(r2, "chat");
        TeamUtils.b((Chat) getCurrentChat().getValue());
        handleChatChange(r2);
        handleQuitGroup(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void onPushDingMessage(MessageInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "messageInfo");
        MessageInfo r0 = (MessageInfo) getDataStore().u(r4.getId());
        if (r0 == null) goto L5;
        r4.setLastReplyInThreadTime(r0.getLastReplyInThreadTime());
        r4.setReplyInThreadCount(r0.getReplyInThreadCount());
    L5:
        ArrayList r1 = new ArrayList();
        r1.add(r4);
        onPushMessage(r1, false);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel, com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatFileAuthorityPushHandler.b
    public void onPushFileAuthority(final Map<String, ValidateIMFileResult> r5) {
        Intrinsics.checkNotNullParameter(r5, "map");
        CoreThreadPool.getBackgroundHandler().postDelayed(new RunnableC03601(r5, this), 300);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void onPushMyAIVote(final Map<String, ? extends com.bytedance.lark.pb.basic.v1.Message.AIMessageLikeFeedbackStatus> r3) {
        Intrinsics.checkNotNullParameter(r3, "map");
        com.ss.android.lark.chatbase.k r0 = getDataStore().N();
        r0.filter(new C03621(r3));
        r0.a(new C03632(r3));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel, com.ss.android.lark.chat.chatwindow.chat.v2.push.i.b
    public void onPushSignUrlPreview(List<UrlPreViewEntries> r5) {
        Intrinsics.checkNotNullParameter(r5, "entriesList");
        Chat r0 = (Chat) getCurrentChat().getValue();
        if (r0 == null) goto L5;
        Chat.Type r1 = r0.getType();
    L7:
        if (r1 != Chat.Type.P2P) goto L9;
        return;
    L9:
        List<UrlPreViewEntries> r2 = r5;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L11:
        if (r4.hasNext() == false) goto L16;
        String r6 = ((UrlPreViewEntries) r4.next()).getSourceId();
        if (r6 != null) goto L15;
        r6 = BuildConfig.FLAVOR;
    L15:
        r3.add(r6);
        goto L11
    L16:
        LinkedHashMap r7 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r3, 10)), 16));
        Iterator r8 = r3.iterator();
    L18:
        if (r8.hasNext() == false) goto L20;
        Object r9 = r8.next();
        r7.put((String) r9, r9);
        goto L18
    L20:
        com.ss.android.lark.chatbase.k r10 = getDataStore().N();
        r10.filter(new k4b.c(r7));
        r10.a(new com.ss.android.lark.chat.chatwindow.chat.v2.model.operation.k(getChatContainer().P(), r5, ChatHitPointExtraParams.DataSource.FROM_SDK_PUSH));
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel, com.ss.android.lark.chat.chatwindow.chat.v2.push.l0.d
    public void onPushThreadTopic(ThreadTopic r2) {
        Intrinsics.checkNotNullParameter(r2, "threadTopic");
        MutableLiveData<ThreadTopic> r0 = getCurrentThreadTopic();
        if (r0 == null) goto L6;
        r0.postValue(r2);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel, com.ss.android.lark.chat.chatwindow.chat.v2.push.l0.d
    public void onPushUpdateThreadInfo(n5b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "threadInfo");
        getDataStore().H(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel, com.ss.android.lark.chat.chatwindow.chat.v2.push.d.a
    public void onPushUpdatedChatter(Chatter r6) {
        Intrinsics.checkNotNullParameter(r6, "chatter");
        ChatChatter r0 = (ChatChatter) getSelfChatterLiveData().getValue();
        if (Intrinsics.areEqual(r6, r0) == true) goto L5;
    L17:
        MutableLiveData<Chat> r1 = getCurrentChat();
        boolean r2 = false;
        if (r1 == null) goto L22;
        Chat r3 = (Chat) r1.getValue();
        if (r3 == null) goto L22;
        boolean r4 = r3.isP2PChat();
    L24:
        if (r4 == true) goto L26;
    L30:
        com.ss.android.lark.chatbase.k r5 = getDataStore().N();
        r5.filter(new k4b.b(r6.getId(), true));
        r5.a(new com.ss.android.lark.chat.chatwindow.chat.v2.model.operation.i(r6, getChatId()));
        if (r2 == false) goto L34;
        com.ss.android.lark.chatbase.k r7 = getDataStore().N();
        ChatChatter r8 = (ChatChatter) r6;
        r7.filter(new k4b.e(r8.getId()));
        r7.a(new com.ss.android.lark.chat.chatwindow.chat.v2.model.operation.a(r8.getId(), r8.getAlias()));
        return;
    L34:
        return;
    L26:
        if ((r6 instanceof ChatChatter) == false) goto L30;
        if (Intrinsics.areEqual(getChatId(), ((ChatChatter) r6).getChatId()) == false) goto L30;
        r2 = true;
    L22:
        r4 = false;
        goto L24
    L5:
        if ((r6 instanceof ChatChatter) == false) goto L14;
        ChatChatter r9 = (ChatChatter) r6;
        if (Intrinsics.areEqual(r9.getId(), getChatId()) == false) goto L14;
        if (r0 == null) goto L10;
        r0.setChatter(r9.getChatter());
    L10:
        if (r0 == null) goto L12;
        r0.setOnCallRole(r9.getOnCallRole());
    L12:
        if (r0 == null) goto L16;
        r0.setNickName(r9.getNickName());
    L16:
        getSelfChatterLiveData().postValue(r0);
    L14:
        if (r0 == null) goto L16;
        r0.setChatter(r6);
        goto L16
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel, com.ss.android.lark.chat.chatwindow.chat.v2.push.s.b
    public void onPushUserGroup(Map<Long, UserGroupEntity> r3) {
        Intrinsics.checkNotNullParameter(r3, "userGroups");
        com.ss.android.lark.chatbase.k r0 = getDataStore().N();
        r0.filter(new k4b.f(r3));
        r0.a(new com.ss.android.lark.chat.chatwindow.chat.v2.model.operation.q(r3));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel, com.ss.android.lark.chat.chatwindow.chat.v2.push.q.a
    public void onQuitGroup(boolean r3) {
        Log.i(TitlebarViewModel.LOG_TAG, "event Quit Group: " + r3);
        this.mQuitGroupBySelf = r3;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void onSendChatAnnouncement(String r4) {
        Intrinsics.checkNotNullParameter(r4, "content");
        Log.i(TitlebarViewModel.LOG_TAG, "event Send Chat Announcement: " + getChatId());
        m2b.a r0 = getDependency().a();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.Y() != true) goto L7;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p r2 = this.mDependencyRefs.get();
        if (r2 == null) goto L16;
        q4b.a r3 = r2.getMessageSender();
        if (r3 == null) goto L17;
        r3.k(UIHelper.getString(2131891518), r4, com.ss.android.lark.widget.richtext.c.c(r4));
        return;
    L17:
        return;
    L16:
        return;
    L7:
        r1 = false;
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel, com.ss.android.lark.chat.chatwindow.chat.v2.push.f.a
    public void onSwitchToCellularDataNetwork(boolean r2) {
        if (r2 == false) goto L4;
        getToastInfo().postValue(UIHelper.getString(2131892253));
        return;
    L4:
        getToastInfo().postValue(UIHelper.getString(2131892252));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel, com.ss.android.lark.chat.chatwindow.chat.v2.push.p.b
    public void onThreadRepliesUpdate(n5b.a r4) {
        Intrinsics.checkNotNullParameter(r4, "threadInfo");
        com.ss.android.lark.chatbase.k r0 = getDataStore().N();
        r0.filter(new k4b.a(r4.b));
        r0.a(new com.ss.android.lark.chat.chatwindow.chat.v2.model.operation.h(r4));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel, com.ss.android.lark.chat.chatwindow.chat.v2.push.d.a
    public void onUpdateSelfInfo(Chatter r5) {
        Intrinsics.checkNotNullParameter(r5, "chatter");
        com.ss.android.lark.chatbase.k r0 = getDataStore().N();
        r0.filter(new k4b.b(r5.getId(), false));
        r0.a(new com.ss.android.lark.chat.chatwindow.chat.v2.model.operation.b(r5.getAvatarKey()));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void readAudioMsg(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        MessageInfo r3 = getMessageInfoById(r2);
        if (r3 != null) goto L5;
        return;
    L5:
        getMMessageReader().a(r3);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void registerImmediateMsg(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        this.mImmediatePushWhiteList.add(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void retrySendMessage(String r3) {
        Intrinsics.checkNotNullParameter(r3, "preMsgId");
        getDataStore().P(r3, new b0(this));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void setActionDispatch(ActionDispatcher r2) {
        Intrinsics.checkNotNullParameter(r2, "dispatcher");
        this.mActionDispatcher = r2;
        if (r2 == null) goto L6;
        r2.registerActionListener(getDataStore());
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void setPinExtraLoader(MessageListPinExtraLoader r1) {
        this.pinExtraLoader = r1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void setScreenItemProvider(q3b.m.c r3) {
        Intrinsics.checkNotNullParameter(r3, "provider");
        BasePageStore<MessageInfo, x4b.a<MessageInfo>> r0 = getDataStore();
        if ((r0 instanceof q3b.m) == false) goto L5;
        q3b.m r1 = (q3b.m) r0;
    L6:
        if (r1 == null) goto L9;
        r1.m = r3;
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setSelfMessageRTLDisplay(boolean r1) {
        this.selfMessageRTLDisplay = r1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void setWindowDataPreLoadTaskProvider(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.l r3) {
        y0 r0 = this.messageListRepository;
        if ((r0 instanceof com.ss.android.lark.chat.chatwindow.chat.v2.component.message.j) == false) goto L5;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.j r1 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.j) r0;
    L6:
        if (r1 == null) goto L10;
        if (r3 != null) goto L9;
        r3 = r1.f;
    L9:
        r1.g = r3;
        return;
    L10:
        Log.i(TAG, "messageListRepository is not a DefaultMessageListRepository");
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void toggleItemShowTime(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        this.mUIModel.i(r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel, com.ss.android.lark.chat.chatwindow.chat.v2.push.q.a
    public void updateDissolveGroupLocalFlag(boolean r1) {
        this.mDissolveGroupByLocalFlag = true;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void updatePreviewByMessageId(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "msgId");
        com.ss.android.lark.chatbase.k r0 = getDataStore().N();
        r0.filter(new C03681(r3));
        r0.a(C03692.INSTANCE);
    }

    public static final /* synthetic */ void access$handleLocalMessageUpdate(MessageListViewModelV2 r0, MessageInfo r1) {
        r0.handleLocalMessageUpdate(r1);
    }

    public static final /* synthetic */ void access$handleSendMessageFailError(MessageListViewModelV2 r0, ErrorResult r1) {
        r0.handleSendMessageFailError(r1);
    }

    public static final /* synthetic */ void access$handleSignUrlRequest(MessageListViewModelV2 r0, Collection r1) {
        r0.handleSignUrlRequest(r1);
    }

    public static final /* synthetic */ void access$handleUpdateMsg(MessageListViewModelV2 r0, Collection r1) {
        r0.handleUpdateMsg(r1);
    }

    public static final /* synthetic */ void access$notifyMessageChange(MessageListViewModelV2 r0, String r1) {
        r0.notifyMessageChange(r1);
    }

    public static final /* synthetic */ void access$retrySendMessageInner(MessageListViewModelV2 r0, MessageInfo r1) {
        r0.retrySendMessageInner(r1);
    }

    private final void handleMessageRead(Collection<String> r3, Context r4) {
        this.mMessageHandlerExecutor.execute(new l(this, r3, r4));
    }

    private final void tryToLoadSpecificPosition(int r2, IGetDataCallback<com.ss.android.lark.chat.core.model.d<MessageInfo>> r3) {
        if (containsPosition(r2) == true) goto L5;
        loadToPosition(r2, true, r3);
        return;
    L5:
        r3.onSuccess(getDataStore().b);
    }

    private final IGetDataCallback<String> wrapResendCallback(MessageInfo r3, IGetDataCallback<String> r4) {
        if (r3.getMessage().getType() == Message.Type.MEDIA) goto L5;
        return r4;
    L5:
        return new MediaMessageResendCallback(r3, r4, this, getChatContainer().L());
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void cancelUploadMediaMsg(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "cId");
        getDataStore().P(r2, new i(this, r2));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void checkToClearDataStore(int r3, IMessageListComponent.c r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.mMessageHandlerExecutor.execute(new j(this, r3, r4));
    }

    public final void getChatchatters(String r3, IGetDataCallback<ccb.a> r4) {
        Intrinsics.checkNotNullParameter(r3, "chatId");
        getChatContainer().j0().Ac(r3, this.mCallbackManager.wrapAndAddGetDataCallback(r4));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void handleCollapsingUrlPreview(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        this.mUIModel.g(r2, r3);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void loadSpecialPage(int r2, final IGetDataCallback<Unit> r3) {
        IGetDataCallback<com.ss.android.lark.chat.core.model.d<MessageInfo>> r0 = new MessageListViewModelV2$loadSpecialPage$callbackWrapper$1(r3);
        if (containsPosition(r2) == true) goto L6;
        loadToPosition(r2, true, r0);
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public Object loadSpecialPosition(int r6, Continuation<? super MessageInfo> r7) {
        Iterator<T> r8 = this.messageService.fd(getChatId(), CollectionsKt.mutableListOf(new Integer[]{Boxing.boxInt(r6)})).messageInfoList.iterator();
    L4:
        if (r8.hasNext() == false) goto L11;
        Object r0 = r8.next();
        if (((MessageInfo) r0).getMessage().getPosition() != r6) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L13:
        return (MessageInfo) r0;
    L8:
        r2 = false;
        goto L9
    L11:
        r0 = null;
        goto L13
    }

    public final void onClickToggleReferences(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        this.mUIModel.h(r2, r3);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void onFollowFold(String r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "foldId");
        if (getDependency().o() == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03591(r8, r9, this, null), 3, null);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel, com.ss.android.lark.chat.chatwindow.chat.v2.push.o.d
    public void onPushChatRemoveChatters(Chat r3, Map<String, ? extends Chatter> r4) {
        Intrinsics.checkNotNullParameter(r3, "chat");
        Intrinsics.checkNotNullParameter(r4, "chatterMap");
        String r0 = ChatCoreModule.a().getLoginDependency().getUserId();
        TeamUtils.b((Chat) getCurrentChat().getValue());
        if (r4.containsKey(r0) == false) goto L5;
    L6:
        handleChatChange(r3);
        handleQuitGroup(r3);
        return;
    L5:
        if (r4.containsKey(r3.getAnonymousId()) == true) goto L6;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel, com.ss.android.lark.chat.chatwindow.chat.v2.push.o.d
    public void onPushMessage(List<MessageInfo> r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "messageInfos");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p r0 = this.mDependencyRefs.get();
        if (r0 == null) goto L5;
        final List<b1> r1 = r0.k();
    L6:
        List<b1> r2 = r1;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L16;
        CollectionsKt.removeAll(r8, new C03611(r1));
    L16:
        if (CollectionUtils.isEmpty(r8) == false) goto L18;
        return;
    L18:
        Iterator<MessageInfo> r4 = r8.iterator();
    L20:
        if (r4.hasNext() == false) goto L57;
        MessageInfo r5 = r4.next();
        if (r5.isPreMessage() == false) goto L31;
        Chat r6 = (Chat) getCurrentChat().getValue();
        if (r6 == null) goto L28;
        ChatDisplayModeSetting r7 = r6.getChatDisplayModeSetting();
        if (r7 == null) goto L28;
        r5.getMessage().setChatDisplayModeSetting(r7);
    L28:
        Message r10 = r5.getMessage();
        ConcurrentHashMap r11 = com.ss.android.lark.statistics.chat.p.a;
        Intrinsics.checkNotNullParameter(r10, "preMessage");
        Function1 r12 = (Function1) com.ss.android.lark.statistics.chat.p.b.poll();
        if (r12 == null) goto L32;
        r12.invoke(r10);
    L32:
        Message r13 = r5.getMessage();
        String r14 = r13.getId();
        if (r9 == false) goto L35;
    L46:
        boolean r15 = true;
    L48:
        if (r15 == true) goto L49;
        AndroidThrottle<MessageInfo> r16 = getMsgUpdateThrottle();
        if (r16 == null) goto L56;
        r16.d(r5);
    L56:
        Log.i(TitlebarViewModel.LOG_TAG, "post push message,  message： " + r5.getId());
        goto L20
    L49:
        AndroidThrottle<MessageInfo> r17 = getMsgUpdateThrottle();
        if (r17 == null) goto L52;
        r17.c(r5);
    L52:
        Log.i(TitlebarViewModel.LOG_TAG, "flash push message,  message： " + r5.getId());
        goto L20
    L35:
        if (this.mImmediatePushWhiteList.contains(r14) == true) goto L46;
        if (r13.getType() == Message.Type.RED_PACKET) goto L46;
        if (r13.getType() != Message.Type.SYSTEM) goto L43;
        if (this.needImmediateFlushSystemTypes.contains(((SystemContent) r13.getContent()).getType()) == true) goto L46;
    L43:
        if (kkb.a.a(r13) == true) goto L46;
        r15 = false;
        goto L48
    L31:
        com.ss.android.lark.statistics.chat.p.a(r5.getMessage());
        goto L32
    L57:
        q0.b(r8);
        return;
    L9:
        if (r2.isEmpty() == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel, com.ss.android.lark.chat.chatwindow.chat.v2.push.i.b
    public void onPushPreview(final Map<String, ? extends Map<String, UrlCardPreviewEntity>> r3, final Map<String, ? extends Map<String, MessageLink>> r4) {
        CoreThreadPool.getBackgroundHandler().postDelayed(new RunnableC03641(r3, this, r4), 500);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel, com.ss.android.lark.chat.chatwindow.chat.v2.push.d.a
    public void onPushUpdatedNickname(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "chatterId");
        Intrinsics.checkNotNullParameter(r5, "nickname");
        com.ss.android.lark.chatbase.k r0 = getDataStore().N();
        r0.filter(new k4b.e(r4));
        r0.filter(new k4b.b(r4, false));
        r0.filter(new k4b.d(r4));
        r0.a(new com.ss.android.lark.chat.chatwindow.chat.v2.model.operation.j(getChatId(), r4, r5));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel, com.ss.android.lark.chat.chatwindow.chat.v2.push.g.a
    public void onPushUploadProgress(final String r3, int r4) {
        Log.i(TitlebarViewModel.LOG_TAG, "onPushUploadProgress, cid:" + r3 + ", progress:" + r4);
        com.ss.android.lark.chatbase.k r0 = getDataStore().N();
        r0.filter(new C03651(r3));
        r0.a(new com.ss.android.lark.chat.chatwindow.chat.v2.model.operation.n(r4));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void readMessage(List<? extends y6b.a<?>> r9, Context r10) {
        Intrinsics.checkNotNullParameter(r9, "intervalMessages");
        Intrinsics.checkNotNullParameter(r10, "context");
        HashSet r0 = new HashSet();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p r1 = this.mDependencyRefs.get();
        if (r1 == null) goto L5;
        List<h1> r2 = r1.s();
    L6:
        Iterator<? extends y6b.a<?>> r11 = r9.iterator();
    L8:
        if (r11.hasNext() == false) goto L26;
        y6b.a<?> r3 = r11.next();
        if (r2 == null) goto L19;
        Iterator<T> r4 = r2.iterator();
    L13:
        if (r4.hasNext() == false) goto L17;
        Object r5 = r4.next();
        if (((h1) r5).isSupported() == false) goto L13;
    L18:
        h1 r6 = (h1) r5;
    L20:
        if (r6 == null) goto L21;
        String r7 = r6.a();
        Log.i(TAG, "readMessage provider:" + r6.getTag() + ",origin:" + r3.getId() + ",id:" + r7);
        if (r7 == null) goto L8;
        r0.add(r7);
        goto L8
    L21:
        r0.add(r3.getId());
        goto L8
    L17:
        r5 = null;
        goto L18
    L19:
        r6 = null;
        goto L20
    L26:
        handleMessageRead(r0, r10);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void updateMsg(hya.b<String> r2, hya.a<f5b.b> r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "updater");
        getDataStore().O(r2, r3);
    }

    private final void initResourceLoader(Chat r4, ChatChatter r5, Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        u r0 = new u(this);
        Intrinsics.checkNotNullParameter(r0, "updater");
        com.ss.android.lark.biz.im.api.extension.message.f r1 = new com.ss.android.lark.biz.im.api.extension.message.f(r6.getApplicationContext(), r4, r5, r0);
        AtomicBoolean r7 = e1c.c.a;
        String r8 = "chat";
        if (e1c.c.c.get() == false) goto L10;
        if (r4.isSecret() == false) goto L8;
        r8 = "secret_chat";
    L8:
        com.ss.android.lark.chat.chatwindow.chat.model.preload.b r9 = new com.ss.android.lark.chat.chatwindow.chat.model.preload.v2.a(r8, r1);
    L14:
        this.mMessageResourceLoader = r9;
        r9.a(ChatCoreRuntimeProvider.a.i(r4));
        this.mCancelableExecutor = new com.larksuite.framework.callback.c(new Handler(Looper.getMainLooper()));
        com.larksuite.framework.callback.c r10 = this.mCancelableExecutor;
        if (r10 == null) goto L18;
        r10.b(new t(this), 5000);
        return;
    L18:
        return;
    L10:
        if (r4.isSecret() == false) goto L13;
        r8 = "secret_chat";
    L13:
        r9 = new com.ss.android.lark.chat.chatwindow.chat.model.preload.c(r8, r1);
        goto L14
    }

    private final void loadToPosition(int r4, boolean r5, IGetDataCallback<com.ss.android.lark.chat.core.model.d<MessageInfo>> r6) {
        this.messageListRepository.b(r4, r5, new q3b.q(getDataStore(), r6));
    }

    private final void runWhenPushIsEnabled(Integer r3, int r4, Function0<Unit> r5) {
        Log.i(TAG, "start check if push is enabled, push flag is " + Integer.toBinaryString(r4));
        if (r3 != null) goto L7;
        Log.i(TAG, "ChatMessageListParams not found, enable push by default");
        r5.invoke();
        return;
    L7:
        if ((r3.intValue() & r4) != r4) goto L9;
        Log.i(TAG, "push is enabled");
        r5.invoke();
        return;
    L9:
        Log.i(TAG, "push is disabled");
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void checkChatterInChat(String r4, ArrayList<String> r5, final IGetDataCallback<List<String>> r6) {
        Intrinsics.checkNotNullParameter(r4, "chatId");
        Intrinsics.checkNotNullParameter(r5, "chatterIds");
        Intrinsics.checkNotNullParameter(r6, "callback");
        this.chatService.Y6(r5, r4, this.mCallbackManager.wrapAndAddCallback(new AnonymousClass1(r6)));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void handleInteractiveState(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        Intrinsics.checkNotNullParameter(r3, "eleId");
        this.mUIModel.f(r2, r3, r4);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void onCheckMembersInChat(String r2, List<GroupRecallEntity> r3, IGetDataCallback<List<GroupRecallEntity>> r4) {
        getChatContainer().j0().f2(r3, r2, r4);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void recallMembers(String r4, List<String> r5, List<? extends PickChatEntity> r6) {
        Intrinsics.checkNotNullParameter(r5, "chatterIds");
        getChatContainer().j0().Dc(r4, r5, r6, (IGetDataCallback) this.mCallbackManager.wrapAndAddCallback(new C03671(this)));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void sendSignRequest(String r5, String r6, Long r7) {
        Intrinsics.checkNotNullParameter(r5, "description");
        Intrinsics.checkNotNullParameter(r6, "sourceId");
        String r1 = new String(w28.a.a(x28.a.a(r5)));
        if (this.signUrlUpdateThrottle != null) goto L5;
        AndroidThrottle.a r0 = new AndroidThrottle.a();
        r0.b = 100;
        r0.a = CoreThreadPool.getNonblockingHandler();
        r0.d = new PersonalSignGetUrlPreviewBuffer();
        r0.e = new d0(this);
        this.signUrlUpdateThrottle = r0.a();
    L5:
        AndroidThrottle<UserStatusParseUrlPreViewUtils.b> r2 = this.signUrlUpdateThrottle;
        if (r2 == null) goto L9;
        r2.d(new UserStatusParseUrlPreViewUtils.b(r5, r6, r1, r7));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<ImageSet> getAllImageInner(String r9, boolean r10, List<? extends Message.Type> r11, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.m r12) {
        List r4 = getDataStore().s();
        ArrayList r0 = new ArrayList();
        if (CollectionUtils.isEmpty(r4) == false) goto L5;
        return r0;
    L5:
        com.ss.android.lark.chat.chatwindow.chat.model.viewdata.b r1 = new com.ss.android.lark.chat.chatwindow.chat.model.viewdata.b(getMIMFileAuthorityChecker(), getChatContainer().C(), getChatContainer().M());
        Chat r2 = (Chat) getCurrentChat().getValue();
        Intrinsics.checkNotNull(r4);
        r1.a(r2, r4);
        parseImageSetFromMsgInfoList(r9, r10, r4, r0, r11, r12);
        return r0;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public List<ImageSet> getAllImage(String r4, boolean r5, List<? extends Message.Type> r6, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.m r7) {
        Intrinsics.checkNotNullParameter(r4, "clickedMsgId");
        List<? extends Message.Type> r0 = r6;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r6 = CollectionsKt.listOf(new Message.Type[]{Message.Type.IMAGE, Message.Type.MEDIA, Message.Type.POST, Message.Type.STICKER});
    L12:
        return getAllImageInner(r4, r5, r6, r7);
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel
    public void prepareAudioData(final String r8, String r9, String r10, final AudioContent.AudioState r11) {
        Intrinsics.checkNotNullParameter(r8, "msgId");
        Intrinsics.checkNotNullParameter(r11, "successState");
        ArrayList r3 = new ArrayList();
        final MessageInfo r0 = getMessageInfoById(r8);
        if (r0 != null) goto L5;
        return;
    L5:
        r3.add(r0);
        getDataStore().P(r8, new s3b.a(AudioContent.AudioState.DOWNLOADING));
        com.ss.android.lark.chat.chatwindow.chat.model.preload.b r1 = this.mMessageResourceLoader;
        if (r1 == null) goto L9;
        r1.c("audio", r3, r9, r10, (IGetDataCallback) this.mCallbackManager.wrapAndAddCallback(new C03661(r8, this, r11, r0)));
        return;
    }

    public MessageListViewModelV2(i7b.a r13, Context r14, fxa.b r15, com.ss.android.lark.chat.chatwindow.chat.v2.push.v r16, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p r17) {
        Intrinsics.checkNotNullParameter(r13, "initData");
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "chatBundle");
        Intrinsics.checkNotNullParameter(r16, "chatContainer");
        Intrinsics.checkNotNullParameter(r17, "dependency");
        this(r14, r13.f, r13.h, r13.g, r13.b, r13.n, r15, r16, r17);
    }

    private final void parseImageSetFromMsgInfoList(String r16, boolean r17, List<? extends MessageInfo> r18, List<ImageSet> r19, List<? extends Message.Type> r20, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.m r21) {
        ArrayList r4 = new ArrayList();
        Iterator<T> r3 = r18.iterator();
    L3:
        boolean r6 = false;
        if (r3.hasNext() == false) goto L12;
        Object r5 = r3.next();
        MessageInfo r8 = (MessageInfo) r5;
        if (r20.contains(r8.getMessage().getType()) == true) goto L8;
    L10:
        if (r6 == false) goto L3;
        r4.add(r5);
        goto L3
    L8:
        if (r8.getMessage().getStatus() == Message.Status.DELETED) goto L10;
        r6 = true;
        goto L10
    L12:
        Iterator r7 = r4.iterator();
    L14:
        if (r7.hasNext() == false) goto L101;
        MessageInfo r9 = (MessageInfo) r7.next();
        Message r10 = r9.getMessage();
        Message.Type r11 = r10.getType();
        Chat r12 = (Chat) getCurrentChat().getValue();
        ValidateIMFileResult r13 = r10.getValidateIMFileResult();
        Content r14 = null;
        if (r13 == null) goto L18;
        IMFileResult r15 = r13.getResultType();
    L19:
        int r110 = MessagePermissionUtil.h(r15).getValue();
        if (r12 != null) goto L22;
    L24:
        boolean r22 = false;
    L25:
        if (r22 == false) goto L27;
        boolean r23 = true;
    L28:
        boolean r111 = lpc.a.c(r10);
        ResourceCleanScene r112 = lpc.a.a(r10);
        if (r11 == Message.Type.IMAGE) goto L31;
        if (r11 == Message.Type.MEDIA) goto L46;
        if (r11 == Message.Type.POST) goto L50;
        if (r11 == Message.Type.STICKER) goto L70;
        if (r11 == Message.Type.DOUBAO) goto L84;
        if (r11 != Message.Type.TEXT) goto L14;
        if (r21 == null) goto L14;
        Content r24 = r10.getContent();
        if (r24 == null) goto L14;
        FlowImageSet r25 = r21.b(r10.getId(), r24);
        if (r25 == null) goto L14;
        r19.add(r25);
        goto L14
    L84:
        if (r21 == null) goto L14;
        Content r26 = r10.getContent();
        if (r26 == null) goto L14;
        List r27 = r21.a(r10.getId(), r26);
        if (r27 == null) goto L14;
        Iterator r28 = r27.iterator();
    L91:
        if (r28.hasNext() == false) goto L14;
        r19.add((ImageSet) r28.next());
        goto L91
    L70:
        Content r29 = r10.getContent();
        if ((r29 instanceof StickerContent) == false) goto L14;
        StickerContent r30 = (StickerContent) r29;
        String r31 = r30.getStickerSetId();
        if (r31 != null) goto L75;
    L78:
        boolean r32 = true;
    L79:
        if (r32 == false) goto L14;
        r19.add(com.ss.android.lark.chat.utils.v0.f(r9, r30, r23));
        goto L14
    L75:
        if (r31.length() == 0) goto L78;
        r32 = false;
        goto L79
    L50:
        if (TextUtils.equals(r16, r10.getId()) == false) goto L54;
        if (r17 == false) goto L57;
        Content r33 = r9.getTranslateContent();
    L56:
        r14 = r33;
        boolean r34 = true;
    L58:
        if (r14 != null) goto L60;
        r14 = r10.getContent();
    L60:
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.PostContent");
        PostContent r113 = (PostContent) r14;
        if (r113.isGroupAnnouncement() == true) goto L14;
        List r114 = CollectionsKt.filterNotNull(com.ss.android.lark.chat.utils.v0.e(r113.getRichText(), r10.isFromMe(), r10.getFromChatterTenantId()));
        Iterator r115 = r114.iterator();
    L65:
        if (r115.hasNext() == false) goto L67;
        ImageSet r116 = (ImageSet) r115.next();
        r116.setMessageIdentity(r0.c(r9));
        r116.setTranslated(r34);
        r116.setHasPreviewPermission(r23);
        com.ss.android.lark.chat.utils.w.a(r116, r10.getValidateIMFileResult());
        goto L65
    L67:
        r19.addAll(r114);
    L57:
        r34 = false;
        goto L58
    L54:
        if (r10.isTranslatedByDisplayRule() == false) goto L57;
        r33 = r9.getTranslateContent();
        goto L56
    L46:
        MediaImageSet r35 = com.ss.android.lark.parser.internal.d.b((MediaContent) r10.getContent());
        r35.setMessageIdentity(r0.c(r9));
        r35.getMessageIdentity().setSourceId(r35.getMessageIdentity().getMessageId());
        r35.setHasPreviewPermission(r23);
        r35.setReceiveAuthorizationStateValue(r110);
        r35.setValidateIMFileResult(r10.getValidateIMFileResult());
        r35.setResourceIsCleaned(r111);
        r35.setResourceCleanScene(r112);
        r19.add(r35);
        goto L14
    L31:
        if (TextUtils.equals(r16, r10.getId()) == false) goto L35;
        if (r17 == false) goto L38;
        Content r36 = r9.getTranslateContent();
    L37:
        r14 = r36;
        boolean r37 = true;
    L39:
        if (r14 != null) goto L41;
        r14 = r10.getContent();
    L41:
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.ImageContent");
        ImageSet r117 = ((ImageContent) r14).getImageSet();
        if (r117 == null) goto L14;
        r117.setMessageIdentity(r0.c(r9));
        r117.setTranslated(r37);
        r117.setHasPreviewPermission(r23);
        r117.setReceiveAuthorizationStateValue(r110);
        r117.setValidateIMFileResult(r10.getValidateIMFileResult());
        r117.setResourceIsCleaned(r111);
        r117.setResourceCleanScene(r112);
        r19.add(r117);
    L38:
        r37 = false;
        goto L39
    L35:
        if (r10.isTranslatedByDisplayRule() == false) goto L38;
        r36 = r9.getTranslateContent();
        goto L37
    L27:
        r23 = MessagePermissionUtil.c(r10, (Chat) getCurrentChat().getValue(), null);
        goto L28
    L22:
        if (r12.isSecret() != true) goto L24;
        r22 = true;
        goto L25
    L18:
        r15 = null;
        goto L19
    }

    public static /* synthetic */ List getAllImageInner$default(MessageListViewModelV2 r0, String r1, boolean r2, List r3, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.m r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = null;
    L6:
        return r0.getAllImageInner(r1, r2, r3, r4);
    }

    public MessageListViewModelV2(Context r20, Chat r21, ChatChatter r22, ChatChatter r23, int r24, ChatTeamBundle r25, fxa.b r26, com.ss.android.lark.chat.chatwindow.chat.v2.push.v r27, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.p r28) {
        Intrinsics.checkNotNullParameter(r20, "context");
        Intrinsics.checkNotNullParameter(r26, "chatBundle");
        Intrinsics.checkNotNullParameter(r27, "chatContainer");
        Intrinsics.checkNotNullParameter(r28, "dependency");
        this.context = r20;
        this.initChat = r21;
        this.showPosition = r24;
        this.teamBundle = r25;
        this.chatBundle = r26;
        this.chatContainer = r27;
        this.dependency = r28;
        if (r21 == null) goto L6;
        String r4 = r21.getId();
        if (r4 == null) goto L6;
    L7:
        this.chatId = r4;
        Boolean r5 = getDependency().n();
        boolean r6 = true;
        if (r5 == null) goto L10;
        boolean r7 = r5.booleanValue();
    L11:
        this.selfMessageRTLDisplay = r7;
        MutableLiveData r8 = new MutableLiveData();
        if (r21 == null) goto L14;
        r8.setValue(r21);
    L14:
        this.currentChat = com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.a(r8);
        MutableLiveData r9 = new MutableLiveData();
        if (getDependency().t() == null) goto L17;
        r9.setValue(getDependency().t());
    L39:
        this.messageReadable = com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.a(r9);
        this.chatService = getChatContainer().B();
        this.messageService = getChatContainer().w();
        this.chatterService = getChatContainer().T();
        this.selfChatterLiveData = new MutableLiveData();
        this.p2pChatterLiveData = new MutableLiveData();
        this.messageList = new MutableLiveData();
        this.newMessageItems = new MutableLiveData();
        this.newMessageItemsAppend = new MutableLiveData();
        this.toastInfo = new MutableLiveData();
        this.dialogInfo = new MutableLiveData();
        this.closePageInfo = new MutableLiveData();
        this.needRelocateMessage = new MutableLiveData();
        this.pushManager = new com.ss.android.lark.chat.chatwindow.chat.v2.push.c0();
        this.mMessageHandlerExecutor = new x4b.n(CoreThreadPool.getDefault().getSingleScheduledThreadPool("lk-chat-window-v2"));
        this.mBackgroundExecutor = new x4b.n(CoreThreadPool.getDefault().getSingleScheduledThreadPool("lk-chat-window-v2-bg"));
        CallbackManager r12 = new CallbackManager();
        this.mCallbackManager = r12;
        s2b.e r10 = new s2b.e();
        this.mUIModel = r10;
        this.mIMFileAuthorityChecker$delegate = LazyKt.lazy(MessageListViewModelV2$mIMFileAuthorityChecker$2.INSTANCE);
        this.foldMessageService = (m6b.i) getChatContainer().y().create(m6b.i.class);
        this.mStickerService = ChatCoreModule.a().getStickerDependency();
        this.mDependencyRefs = new WeakReference(getDependency());
        this.mImmediatePushWhiteList = Collections.synchronizedSet(new HashSet());
        this.isEnableGenerateDigest$delegate = LazyKt.lazy(new AnonymousClass2(this));
        this.mExtraItemInterceptor = new com.ss.android.lark.chat.chatwindow.chat.model.viewdata.a(new v(this));
        this.mOnDataChangeListener2 = new w(this);
        this.needImmediateFlushSystemTypes = SetsKt.setOf(new SystemMessageType[]{SystemMessageType.MyAI_NewTopicTip, SystemMessageType.MyAI_SceneTopicDynamicTip});
        getSelfChatterLiveData().setValue(r22);
        getP2pChatterLiveData().setValue(r23);
        this.dataStore = initDataStore(this.initChat);
        com.ss.android.lark.biz.im.api.f0 r11 = getDependency().m();
        com.ss.android.lark.biz.im.api.f0 r13 = r11;
        if (r11 != null) goto L54;
        String r14 = getChatContainer().getUserId();
        if (r14 != null) goto L44;
        r14 = BuildConfig.FLAVOR;
    L44:
        String r15 = r14;
        MutableLiveData<Chat> r16 = getCurrentChat();
        m2b.a r17 = getDependency().a();
        String r18 = null;
        if (r17 == null) goto L47;
        ThreadTopic r19 = r17.N1();
    L48:
        ReplyInThreadMessageReader r29 = new ReplyInThreadMessageReader(r15, r16, r19, getMessageReadable(), new a(this));
        m2b.a r30 = getDependency().a();
        if (r30 == null) goto L53;
        ThreadTopic r31 = r30.N1();
        if (r31 == null) goto L53;
        r18 = r31.getId();
    L53:
        r29.e = r18;
        r13 = r29;
        goto L54
    L47:
        r19 = null;
    L54:
        this.mMessageReader = r13;
        z0 r32 = getDependency().j();
        if (r32 != null) goto L57;
        r32 = new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.k(getChatContainer(), getChatBundle());
    L57:
        this.messageListRepository = r32.a(getDataStore(), this.mBackgroundExecutor, this.mMessageHandlerExecutor, r12, getChatId(), getCurrentChat(), getShowPosition());
        initPushHandler(this.initChat);
        registerConnectionStateChangeListener();
        ChatCoreModule.a().getChatDependency().f();
        ObservableMappedArrayList<String, T> r33 = getDataStore().b;
        ArrayList r34 = new ArrayList();
        jdb.g r110 = getChatContainer().C();
        if (r21 == null) goto L60;
        int r111 = r21.getFirstUnReadMessageBadgeCount();
    L61:
        if (r21 != null) goto L63;
    L65:
        boolean r112 = false;
    L66:
        com.ss.android.lark.chat.chatwindow.chat.model.viewdata.c r35 = new com.ss.android.lark.chat.chatwindow.chat.model.viewdata.c(r110, r111, !r112);
        r35.d = getDependency().a();
        r34.add(r35);
        r34.add(new com.ss.android.lark.chat.chatwindow.chat.model.viewdata.d(r10));
        r34.add(new q3b.p());
        com.ss.android.lark.chat.chatwindow.chat.model.viewdata.e r113 = new com.ss.android.lark.chat.chatwindow.chat.model.viewdata.e(r20, r21, getDependency().a(), getDependency().d());
        r34.add(r113);
        if (isLowDevice() == true) goto L69;
        r113.f = true;
    L69:
        this.urlAsyncMeasureInterceptor = r113;
        if (r21 != null) goto L72;
    L74:
        r6 = false;
    L75:
        if (r6 == true) goto L77;
        r34.add(new IMFileAuthorityInterceptor(getChatContainer().C(), getMIMFileAuthorityChecker()));
    L77:
        r10.c = new b(this);
        x4b.c<MessageInfo, y6b.c<?>> r0 = this.dataMapper;
        if (r0 == null) goto L89;
        com.ss.android.lark.chat.core.model.b<y6b.c<?>, MessageInfo> r36 = new com.ss.android.lark.chat.core.model.b(r33, r0, r34, new c(this));
        y6b.e<y6b.c<?>> r1 = getDependency().u();
        monitor-enter(r36);
        if (r1 != null) goto L96;
    L87:
        monitor-exit(r36);
        this.mDataListPipeline = r36;
        goto L89
    L96:
        ((ArrayList) r36.h).add(r1);     // Catch: Throwable -> L84
    L84:
        th = move-exception;
        throw th;
    L89:
        Chat r2 = this.initChat;
        if (r2 == null) goto L92;
        initResourceLoader(r2, r23, this.context);
    L92:
        initMessageSampleConfig();
        c2b.d.b(getChatId()).a(r21, new c2b.a(r33));
        HashMap<String, d2b.a> r3 = d2b.a.c;
        d2b.a.C0208a.a(getChatId()).a(r21, new d(), new e());
        MemoryCallbackManager.getInstance().registerMemoryCallback(this);
        jya.b r37 = getDependency().q();
        if (r37 == null) goto L98;
        getDataStore();
        r37.a();
        return;
    L98:
        return;
    L72:
        if (r21.isSecret() != true) goto L74;
    L63:
        if (r21.isAIChat() != true) goto L65;
        r112 = true;
        goto L66
    L60:
        r111 = 0;
        goto L61
    L17:
        if (r21 != null) goto L19;
        Boolean r38 = Boolean.TRUE;
    L38:
        r9.setValue(r38);
        goto L39
    L19:
        if (r21.isP2PChat() == false) goto L25;
        if (r23 == null) goto L22;
        boolean r39 = r23.isBot();
    L23:
        if (r39 == false) goto L25;
        boolean r40 = true;
    L27:
        if (r21.isP2PChat() == true) goto L29;
    L35:
        boolean r41 = true;
    L36:
        r38 = Boolean.valueOf(Boolean.valueOf(r41).booleanValue());
        goto L38
    L29:
        if (r21.isSecret() == true) goto L35;
        if (r21.isAIChat() == true) goto L35;
        if (r40 == true) goto L35;
        r41 = false;
        goto L36
    L22:
        r39 = false;
    L25:
        r40 = false;
        goto L27
    L10:
        ChatCoreModule.a().getChatDependency().o();
        r7 = true;
    L6:
        r4 = BuildConfig.FLAVOR;
        goto L7
    }

    public static /* synthetic */ void parseImageSetFromMsgInfoList$default(MessageListViewModelV2 r7, String r8, boolean r9, List r10, List r11, List r12, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.m r13, int r14, Object r15) {
        if ((r14 & 32) == 0) goto L5;
        r13 = null;
    L5:
        r7.parseImageSetFromMsgInfoList(r8, r9, r10, r11, r12, r13);
    }
}
