package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.t;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.config.xj;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.ContainerType;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.api.RoomChannelRetrofitApi;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.ChannelInviteMessageItem;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.syncdata.RoomChannelSettingsSyncData;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.syncdata.RoomChannelSyncModel;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.api.message.InteractivityMessageType;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageChangeSource;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageType;
import com.bytedance.android.livesdk.interactivity.api.settings.config.v0;
import com.bytedance.android.livesdk.interactivity.base.im.RoomChannelIMManager;
import com.bytedance.android.livesdk.interactivity.chatchannel.toolbar.ChatChannelWidgetManager;
import com.bytedance.android.livesdk.interactivity.common.utils.LimitQueue;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.RoomAnchorFansChannelMessage;
import com.bytedance.android.livesdk.message.model.l4;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.FansChannelCreateInfo;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.RoomChannelData;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.RoomChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.RoomChannelRtcExtInfo;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.SecretChatInfo;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000ú\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Î\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002Ï\u0001B1\u0012\b\u0010Â\u0001\u001a\u00030Á\u0001\u0012\b\u0010Å\u0001\u001a\u00030Ä\u0001\u0012\b\u0010È\u0001\u001a\u00030Ç\u0001\u0012\b\u0010Ê\u0001\u001a\u00030\u0082\u0001¢\u0006\u0006\bÌ\u0001\u0010Í\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J<\u0010'\u001a\u0004\u0018\u00010\u000e2\b\u0010!\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\"2\b\b\u0002\u0010&\u001a\u00020\"H\u0002J\u001e\u0010(\u001a\u0004\u0018\u00010\u000e2\b\u0010!\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010$\u001a\u00020\u0004H\u0002J\u001c\u0010+\u001a\u0004\u0018\u00010\u000e2\u0006\u0010)\u001a\u00020\u00042\b\b\u0002\u0010*\u001a\u00020\"H\u0002J\b\u0010,\u001a\u00020\u0006H\u0002J\b\u0010-\u001a\u00020\u0006H\u0002J\u0012\u00100\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010.H\u0002J\u001c\u00104\u001a\u00020\u00062\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u000601H\u0002J\u0012\u00107\u001a\u00020\u00062\b\u00106\u001a\u0004\u0018\u000105H\u0002J\u001a\u00109\u001a\u00020\u00062\b\u00108\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010:\u001a\u00020\u0006H\u0016J\u0010\u0010;\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010<\u001a\u00020\u0006H\u0014J\u0012\u0010?\u001a\u00020\u00062\b\u0010>\u001a\u0004\u0018\u00010=H\u0016J\u0012\u0010?\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0010\u0010A\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u0004H\u0016J3\u0010D\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00042\b\u0010C\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\bD\u0010EJ5\u0010G\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00042\b\u0010F\u001a\u0004\u0018\u00010\u00042\b\u0010C\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\bG\u0010HJ\u0010\u0010I\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0004H\u0016J\u0010\u0010J\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0004H\u0016J\u0010\u0010K\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0004H\u0016J \u0010N\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\"2\u0006\u0010M\u001a\u00020\"H\u0016J\u001a\u0010R\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u00142\b\u0010Q\u001a\u0004\u0018\u00010PH\u0016J\u0012\u0010T\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010SH\u0016J,\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020P0X0W2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u00142\u0006\u0010V\u001a\u00020\u0014H\u0016J\u001c\u0010[\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Z0X0W2\u0006\u0010)\u001a\u00020\u0004H\u0016J\u001e\u0010_\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00042\f\u0010^\u001a\b\u0012\u0004\u0012\u00020]0\\H\u0016J,\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0X0W2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0016J\u0010\u0010f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020eH\u0016J\b\u0010h\u001a\u00020gH\u0016J\b\u0010j\u001a\u00020iH\u0016J\b\u0010l\u001a\u00020kH\u0016J\b\u0010n\u001a\u00020mH\u0016J\b\u0010p\u001a\u00020oH\u0016J\n\u0010r\u001a\u0004\u0018\u00010qH\u0016J\b\u0010s\u001a\u00020\u0004H\u0016J\u0010\u0010u\u001a\u00020\u00062\u0006\u0010t\u001a\u000202H\u0016J\u0010\u0010v\u001a\u00020\u00062\u0006\u0010t\u001a\u000202H\u0016J\u0010\u0010w\u001a\u00020\u00062\u0006\u0010t\u001a\u000202H\u0016J\u0014\u0010z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0y0xH\u0016J\u0010\u0010{\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u0004H\u0016J\u0012\u0010|\u001a\u0004\u0018\u00010\u000e2\u0006\u0010)\u001a\u00020\u0004H\u0016J\u000e\u0010}\u001a\b\u0012\u0004\u0012\u00020\u000e0\\H\u0016J\n\u0010~\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0081\u0001\u001a\u00020\u00062\u0006\u0010\u007f\u001a\u00020\u000e2\u0007\u0010\u0080\u0001\u001a\u00020`H\u0016J\n\u0010\u0083\u0001\u001a\u00030\u0082\u0001H\u0016J\u001a\u0010\u0085\u0001\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00042\u0007\u0010\u0015\u001a\u00030\u0084\u0001H\u0016R\u0015\u0010F\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bF\u0010\u0086\u0001R\u0019\u0010\u0087\u0001\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u0002020\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001f\u0010\u008d\u0001\u001a\n\u0012\u0005\u0012\u00030\u008c\u00010\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008b\u0001R9\u0010\u0090\u0001\u001a$\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010P0\u008e\u0001j\u0011\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010P`\u008f\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0018\u0010\u0093\u0001\u001a\u00030\u0092\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0018\u0010\u0096\u0001\u001a\u00030\u0095\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0018\u0010\u0099\u0001\u001a\u00030\u0098\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0018\u0010\u009c\u0001\u001a\u00030\u009b\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0018\u0010\u009f\u0001\u001a\u00030\u009e\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u001c\u0010¢\u0001\u001a\u0005\u0018\u00010¡\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u0018\u0010¥\u0001\u001a\u00030¤\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R$\u0010¨\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0y0§\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u001b\u0010ª\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R\u001b\u0010¬\u0001\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R!\u0010®\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010\u008b\u0001R\u001b\u0010¯\u0001\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010\u00ad\u0001R(\u0010±\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0018\u00010°\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u0019\u0010³\u0001\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010\u0088\u0001R\u0019\u0010´\u0001\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010\u0088\u0001R\u001e\u0010¶\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040µ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u001e\u0010¸\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040µ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010·\u0001R\u001e\u0010¹\u0001\u001a\t\u0012\u0004\u0012\u00020\u00140µ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010·\u0001R\u001e\u0010º\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040µ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bº\u0001\u0010·\u0001R\u0017\u0010»\u0001\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b»\u0001\u0010\u0088\u0001R\u0017\u0010¼\u0001\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¼\u0001\u0010\u0088\u0001R\u0019\u0010½\u0001\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010\u0088\u0001R\u0018\u0010¿\u0001\u001a\u00030¾\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u0018\u0010Â\u0001\u001a\u00030Á\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u0018\u0010Å\u0001\u001a\u00030Ä\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\u0018\u0010È\u0001\u001a\u00030Ç\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÈ\u0001\u0010É\u0001R\u0018\u0010Ê\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001¨\u0006Ð\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/manager/ChatChannelManager;", "Ls22/e;", "Landroidx/lifecycle/ViewModel;", "Lvlc/l;", BuildConfig.FLAVOR, "anchorFansChannelType", BuildConfig.FLAVOR, "deleteWRDSAnchorFansChannel", "processFansclubChannel", "processFansclubChannelList", "processSubscribeChannel", "processFansGroupChannel", "Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelInfo;", "newChannelInfo", "Ls22/a;", "shouldRefreshChannel", "chatChannel", "afterProcessAudienceChannel", "roomChannelInfo", "receiveAnchorChannel", BuildConfig.FLAVOR, "source", BuildConfig.BUILD_TYPE, "Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelData;", "roomChannelData", "initRoomChannelData", "Lcom/bytedance/android/livesdk/message/model/RoomAnchorFansChannelMessage;", "message", "processWRDSMessageForAudience", "processWRDSMessageForAnchor", "doAnchorFansChannelAfterProcess", "groupId", "shareRoomToConversation", "channelInfo", BuildConfig.FLAVOR, "firstPosition", "startTimeForReport", "isValid", "isGuide", "createAndAddRoomChannel", "refreshRoomChannel", "channelId", "autoChangeChannel", "removeRoomChannel", "tryStartFetchMessage", "tryStopFetchMessage", BuildConfig.FLAVOR, "t", "showPromptToast", "Lkotlin/Function1;", "Ls22/e$c;", "callback", "notifyListener", "Lcom/bytedance/android/livesdk/log/filter/n;", "logger", "updateChatChannelLogFilter", "channelData", "onRoomEnter", "onLoginSuccess", "onRoomDestroy", "onCleared", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/e;", "logInfo", "createChannel", "inviteId", "joinChannel", "channelCreateType", "fansChannelType", "joinAnchorFansChannel", "(JJLjava/lang/Long;Ljava/lang/Long;)V", "roomId", "applyAnchorFansChannel", "(JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "quitChannel", "dissolveChannel", "deleteAnchorFansChannel", "linkMicSwitch", "memberInviteSwitch", "updateSetting", "key", BuildConfig.FLAVOR, "value", "recordChatChannelDialog", "Ltlc/d;", "onMessage", "userId", "secId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "kickOutChannel", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/j;", "getInviteId", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/ChannelInviteMessageItem;", "inviteItems", "notifyInviteResult", BuildConfig.FLAVOR, "offset", "limit", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/h;", "getChannelUserList", "Ly32/a;", "insertLocalMessage", "Ls22/d;", "getIMManager", "Ls22/g;", "getWidgetManager", "Ls22/f;", "getToolbarManager", "Ls22/b;", "getEmojiManager", "Lcom/bytedance/android/livesdk/interactivity/api/b;", "getAnimManager", "Ls22/c;", "getGreetingManager", "getRoomId", "listener", "addListener", "addListenerFirst", "removeListener", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "Lsh6/b;", "getCurrentChannel", "changeCurrentChannel", "getChannel", "getAllChannel", "getLatestChannel", "channel", "unreadCount", "notifyChannelUnreadCountChanged", "Ls22/e$b;", "getConfig", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/PublicScreenAreaPageChangeSource;", "trySwitchToChannelPage", "J", "enableCreateChannel", "Z", BuildConfig.FLAVOR, "listenerList", "Ljava/util/List;", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/manager/c;", "channelList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dialogHashMap", "Ljava/util/HashMap;", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/api/RoomChannelRetrofitApi;", "roomChannelApi", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/api/RoomChannelRetrofitApi;", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/toolbar/ChatChannelWidgetManager;", "widgetManager", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/toolbar/ChatChannelWidgetManager;", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/manager/r;", "channelToolbarManager", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/manager/r;", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/manager/n;", "emojiManager", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/manager/n;", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/manager/ChatChannelAnimManager;", "animManager", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/manager/ChatChannelAnimManager;", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/manager/ChatChannelGreetingManager;", "greetingManager", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/manager/ChatChannelGreetingManager;", "Lcom/bytedance/android/livesdk/interactivity/base/im/RoomChannelIMManager;", "channelMessageManager", "Lcom/bytedance/android/livesdk/interactivity/base/im/RoomChannelIMManager;", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "currentChannel", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "_currentChannel", "Ls22/a;", "fansClubChannel", "Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelInfo;", "fansClubChannelList", "subscribeChannel", BuildConfig.FLAVOR, "fansGroupChannel", "Ljava/util/Map;", "isFansClub", "isSubscribe", BuildConfig.FLAVOR, "alreadInfansGroupIdSet", "Ljava/util/Set;", "alreadApplyChannelIdSet", "userInFansClubMap", "channelBanSet", "showGuideEntry", "enableMultiFansclubChannel", "isReceiveEncryptMessage", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "roomContext", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "config", "Ls22/e$b;", "<init>", "(Lcom/bytedance/android/livesdk/chatroom/RoomContext;Lcom/bytedance/ies/sdk/widgets/DataCenter;Landroid/content/Context;Ls22/e$b;)V", "Companion", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelManager extends ViewModel implements s22.e, vlc.l {
    public static final a Companion = null;
    private static final boolean DEFAULT_CHANNEL_CREATE_ENABLE_STATE = true;
    private static final String SCENE_FOR_ROOM_INFO = "enter_room_channel";
    private s22.a _currentChannel;
    private final Set<Long> alreadApplyChannelIdSet;
    private final Set<Long> alreadInfansGroupIdSet;
    private final ChatChannelAnimManager animManager;
    private final Set<Long> channelBanSet;
    private final List<com.bytedance.android.livesdk.interactivity.chatchannel.manager.c> channelList;
    private final RoomChannelIMManager channelMessageManager;
    private final com.bytedance.android.livesdk.interactivity.chatchannel.manager.r channelToolbarManager;
    private final CompositeDisposable compositeDisposable;
    private final s22.e.b config;
    private final Context context;
    private final PropertyOwner<sh6.b<s22.a>> currentChannel;
    private final DataCenter dataCenter;
    private final HashMap<String, Object> dialogHashMap;
    private final com.bytedance.android.livesdk.interactivity.chatchannel.manager.n emojiManager;
    private boolean enableCreateChannel;
    private final boolean enableMultiFansclubChannel;
    private RoomChannelInfo fansClubChannel;
    private List<RoomChannelInfo> fansClubChannelList;
    private Map<Long, RoomChannelInfo> fansGroupChannel;
    private ChatChannelGreetingManager greetingManager;
    private boolean isFansClub;
    private boolean isReceiveEncryptMessage;
    private boolean isSubscribe;
    private final List<s22.e.c> listenerList;
    private final RoomChannelRetrofitApi roomChannelApi;
    private final RoomContext roomContext;
    private final long roomId;
    private final boolean showGuideEntry;
    private RoomChannelInfo subscribeChannel;
    private final Set<String> userInFansClubMap;
    private final ChatChannelWidgetManager widgetManager;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ChatChannelManager a;
        public final /* synthetic */ long b;

        public b(ChatChannelManager r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Response r4 = (Response) r3;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("apply success");
            ChatChannelManager.access$getAlreadApplyChannelIdSet$p(this.a).add(Long.valueOf(this.b));
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("apply error,e:" + ((Throwable) r3));
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ChatChannelManager a;
        public final /* synthetic */ long b;

        public d(ChatChannelManager r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r10) {
            final Response r11 = (Response) r10;
            final s22.a r0 = ChatChannelManager.createAndAddRoomChannel$default(this.a, ((com.bytedance.android.livesdk.interactivity.api.chatchannel.model.f) ((BaseResponse) r11).data).a(), ChatChannelManager.DEFAULT_CHANNEL_CREATE_ENABLE_STATE, this.b, false, false, 24, null);
            if (r0 == null) goto L6;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.e(r0);
            ChatChannelManager r1 = this.a;
            int r2 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.d.a;
            long r3 = r0.getChannelId();
            Text r4 = ((com.bytedance.android.livesdk.interactivity.api.chatchannel.model.f) ((BaseResponse) r11).data).b();
            com.bytedance.android.livesdk.interactivity.api.chatchannel.message.p r5 = new com.bytedance.android.livesdk.interactivity.api.chatchannel.message.p();
            CommonMessageData r6 = new CommonMessageData();
            r6.messageId = 0;
            r6.channelId = r3;
            r6.setDisplayText(r4);
            Unit r7 = Unit.INSTANCE;
            ((BaseMessage) r5).baseMessage = r6;
            r5.b = ChatChannelManager.DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
            r1.insertLocalMessage(r5);
            this.a.changeCurrentChannel(r0.getChannelId());
            this.a.trySwitchToChannelPage(r0.getChannelId(), PublicScreenAreaPageChangeSource.ChannelCreate);
            ChatChannelManager.access$notifyListener(this.a, new ChatChannelManager$createChannel$1$$special$$inlined$let$lambda$1(r0, this, r11));
            ChatChannelManager.access$tryStartFetchMessage(this.a);
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.e(r0);
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ChatChannelManager a;
        public final /* synthetic */ long b;

        public e(ChatChannelManager r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r11) {
            final Throwable r13 = (Throwable) r11;
            String r0 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.l.a(r13);
            int r1 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.a;
            Intrinsics.checkNotNullParameter(r0, "reason");
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("create failed, reason is " + r0);
            int r2 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
            long r3 = this.b;
            int r5 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.e(r13);
            String r6 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.f(r13);
            long r7 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.c(Long.valueOf(r3));
            LinkedHashMap r9 = new LinkedHashMap();
            r9.put("reason", com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.d(r13));
            Unit r4 = Unit.INSTANCE;
            com.bytedance.android.livesdk.interactivity.api.monitor.c r8 = new com.bytedance.android.livesdk.interactivity.api.monitor.c(r5, r6, r7, r9);
            r8.a(InteractivityMonitor.Event.ChatChannelCreate);
            r8.b(InteractivityTraceMonitor.Event.ChatChannelCreate);
            ChatChannelManager.access$showPromptToast(this.a, r13);
            ChatChannelManager.access$notifyListener(this.a, new ChatChannelManager$createChannel$2$1(r13));
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ ChatChannelManager a;
        public final /* synthetic */ s22.a b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;

        public f(ChatChannelManager r1, s22.a r2, long r3, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r13) {
            final Response r14 = (Response) r13;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.f(this.b, "user action");
            int r0 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
            s22.a r1 = this.b;
            String r2 = ((BaseResponse) r14).logId;
            long r3 = this.c;
            Intrinsics.checkNotNullParameter(r1, "channel");
            long r8 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.c(Long.valueOf(r3));
            LinkedHashMap r10 = new LinkedHashMap();
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.j(r10, r1);
            if (r2 != null) goto L5;
            r2 = BuildConfig.FLAVOR;
        L5:
            r10.put("log_id", r2);
            Unit r4 = Unit.INSTANCE;
            com.bytedance.android.livesdk.interactivity.api.monitor.c r5 = new com.bytedance.android.livesdk.interactivity.api.monitor.c(0, null, r8, r10, 3);
            r5.a(InteractivityMonitor.Event.ChatChannelDissolve);
            r5.b(InteractivityTraceMonitor.Event.ChatChannelDissolve);
            if (ChatChannelManager.removeRoomChannel$default(this.a, this.d, false, 2, null) == null) goto L13;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.model.g r6 = (com.bytedance.android.livesdk.interactivity.api.chatchannel.model.g) ((BaseResponse) r14).data;
            if (r6 == null) goto L10;
            String r7 = r6.a();
        L11:
            f2.c(r7, 0);
            ChatChannelManager.access$tryStopFetchMessage(this.a);
            ChatChannelManager.access$notifyListener(this.a, new ChatChannelManager$dissolveChannel$1$$special$$inlined$let$lambda$1(this, r14));
            return;
        L10:
            r7 = null;
            goto L11
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ ChatChannelManager a;
        public final /* synthetic */ long b;
        public final /* synthetic */ s22.a c;
        public final /* synthetic */ long d;

        public g(ChatChannelManager r1, long r2, s22.a r4, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }

        public final void accept(Object r13) {
            final Throwable r14 = (Throwable) r13;
            long r0 = this.b;
            String r2 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.l.a(r14);
            int r3 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.a;
            Intrinsics.checkNotNullParameter("user action", "source");
            Intrinsics.checkNotNullParameter(r2, "reason");
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("dissolve failed, channelId is " + r0 + ", source is user action, reason is " + r2);
            int r1 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
            s22.a r4 = this.c;
            long r5 = this.d;
            Intrinsics.checkNotNullParameter(r4, "channel");
            int r6 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.e(r14);
            String r7 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.f(r14);
            long r8 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.c(Long.valueOf(r5));
            LinkedHashMap r10 = new LinkedHashMap();
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.j(r10, r4);
            r10.put("reason", com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.d(r14));
            Unit r9 = Unit.INSTANCE;
            com.bytedance.android.livesdk.interactivity.api.monitor.c r11 = new com.bytedance.android.livesdk.interactivity.api.monitor.c(r6, r7, r8, r10);
            r11.a(InteractivityMonitor.Event.ChatChannelDissolve);
            r11.b(InteractivityTraceMonitor.Event.ChatChannelDissolve);
            ChatChannelManager.access$showPromptToast(this.a, r14);
            ChatChannelManager.access$notifyListener(this.a, new ChatChannelManager$dissolveChannel$2$1(r14));
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ ChatChannelManager a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;

        public h(ChatChannelManager r1, long r2, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r14) {
            Response r15 = (Response) r14;
            ChatChannelManager.access$removeRoomChannel(this.a, this.b, false);
            final s22.a r0 = ChatChannelManager.createAndAddRoomChannel$default(this.a, ((com.bytedance.android.livesdk.interactivity.api.chatchannel.model.a) ((BaseResponse) r15).data).a(), ChatChannelManager.DEFAULT_CHANNEL_CREATE_ENABLE_STATE, 0, false, false, 28, null);
            if (r0 == null) goto L14;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.j(r0);
            int r1 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.i(r0, ((BaseResponse) r15).logId, this.c);
            if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.c(ChatChannelManager.access$getRoomContext$p(this.a), ChatChannelManager.access$getDataCenter$p(this.a)) == false) goto L12;
            String r3 = String.valueOf(r0.y());
            boolean r4 = ((Boolean) r0.v().a).booleanValue();
            FansChannelCreateInfo r16 = r0.C();
            if (r16 == null) goto L10;
            String r17 = String.valueOf(r16.getFansChannelType());
            if (r17 == null) goto L10;
        L11:
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.i.a(false, "join", r3, r4, r17, String.valueOf(r0.getChannelId()), String.valueOf(r0.f()), r0.s(), r0.x());
        L10:
            r17 = "0";
        L12:
            ChatChannelManager.access$notifyListener(this.a, new ChatChannelManager$joinAnchorFansChannel$1$1$1(r0));
            this.a.changeCurrentChannel(r0.getChannelId());
            ChatChannelManager.access$tryStartFetchMessage(this.a);
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.b(r0, "qualified");
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ ChatChannelManager a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Long d;
        public final /* synthetic */ Long e;

        public i(ChatChannelManager r1, long r2, long r4, Long r6, Long r7) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r6;
            this.e = r7;
        }

        public final void accept(Object r3) {
            final Throwable r4 = (Throwable) r3;
            ChatChannelManager.access$notifyListener(this.a, new ChatChannelManager$joinAnchorFansChannel$2$1(this, r4));
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ ChatChannelManager a;
        public final /* synthetic */ long b;

        public j(ChatChannelManager r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r18) {
            final Response r1 = (Response) r18;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.model.a r2 = (com.bytedance.android.livesdk.interactivity.api.chatchannel.model.a) ((BaseResponse) r1).data;
            if (r2 == null) goto L7;
            RoomChannelInfo r3 = r2.a();
            if (r3 == null) goto L7;
            long r4 = r3.getChannelId();
        L8:
            Iterator<T> r5 = ChatChannelManager.access$getChannelList$p(this.a).iterator();
        L10:
            if (r5.hasNext() == false) goto L17;
            T r6 = r5.next();
            if (((com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r6).p != r4) goto L14;
            boolean r8 = ChatChannelManager.DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
        L15:
            if (r8 == false) goto L10;
        L18:
            com.bytedance.android.livesdk.interactivity.chatchannel.manager.c r7 = r6;
            if (r7 == null) goto L24;
            if (r7.y == true) goto L24;
            ChatChannelManager.access$removeRoomChannel(this.a, r4, false);
        L24:
            if (this.a.getChannel(r4) != null) goto L26;
            final s22.a r9 = ChatChannelManager.createAndAddRoomChannel$default(this.a, ((com.bytedance.android.livesdk.interactivity.api.chatchannel.model.a) ((BaseResponse) r1).data).a(), ChatChannelManager.DEFAULT_CHANNEL_CREATE_ENABLE_STATE, 0, false, false, 28, null);
            if (r9 == null) goto L65;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.j(r9);
            int r10 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.i(r9, ((BaseResponse) r1).logId, this.b);
            if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.c(ChatChannelManager.access$getRoomContext$p(this.a), ChatChannelManager.access$getDataCenter$p(this.a)) == false) goto L54;
            String r11 = String.valueOf(r9.y());
            boolean r13 = ((Boolean) r9.v().a).booleanValue();
            FansChannelCreateInfo r14 = r9.C();
            if (r14 == null) goto L52;
            String r15 = String.valueOf(r14.getFansChannelType());
            if (r15 == null) goto L52;
            String r16 = r15;
        L53:
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.i.a(false, "join", r11, r13, r16, String.valueOf(r9.getChannelId()), String.valueOf(r9.f()), r9.s(), r9.x());
        L52:
            r16 = "0";
        L54:
            this.a.trySwitchToChannelPage(r9.getChannelId(), PublicScreenAreaPageChangeSource.ChannelJoin);
            if (r9.y() != 2) goto L57;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.b(r9, "invited");
        L57:
            ChatChannelManager.access$notifyListener(this.a, new ChatChannelManager$joinChannel$1$$special$$inlined$let$lambda$1(r9, this, r1));
            this.a.changeCurrentChannel(r9.getChannelId());
            ChatChannelManager.access$tryStartFetchMessage(this.a);
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.i();
            return;
        L65:
            return;
        L26:
            if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.c(ChatChannelManager.access$getRoomContext$p(this.a), ChatChannelManager.access$getDataCenter$p(this.a)) == false) goto L41;
            s22.a r17 = this.a.getChannel(r4);
            if (r17 == null) goto L41;
            String r19 = String.valueOf(r17.y());
            if (((Boolean) r17.v().a).booleanValue() != true) goto L32;
            boolean r110 = ChatChannelManager.DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
        L33:
            FansChannelCreateInfo r20 = r17.C();
            if (r20 == null) goto L39;
            String r21 = String.valueOf(r20.getFansChannelType());
            if (r21 == null) goto L39;
            String r111 = r21;
        L40:
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.i.a(false, "join", r19, r110, r111, String.valueOf(r17.getChannelId()), String.valueOf(r17.f()), r17.s(), r17.x());
        L39:
            r111 = "0";
            goto L40
        L32:
            r110 = false;
        L41:
            this.a.trySwitchToChannelPage(r4, PublicScreenAreaPageChangeSource.ChannelJoin);
            ChatChannelManager.access$notifyListener(this.a, ChatChannelManager$joinChannel$1$3.INSTANCE);
            return;
        L14:
            r8 = false;
            goto L15
        L17:
            r6 = (T) null;
        L7:
            r4 = 0;
            goto L8
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ ChatChannelManager a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;

        public k(ChatChannelManager r1, long r2, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r11) {
            final Throwable r13 = (Throwable) r11;
            String r0 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.l.a(r13);
            int r1 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.a;
            Intrinsics.checkNotNullParameter(r0, "reason");
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("join failed, reason is " + r0);
            int r2 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
            long r3 = this.b;
            int r5 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.e(r13);
            String r6 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.f(r13);
            long r7 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.c(Long.valueOf(r3));
            LinkedHashMap r9 = new LinkedHashMap();
            r9.put("reason", com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.d(r13));
            Unit r4 = Unit.INSTANCE;
            com.bytedance.android.livesdk.interactivity.api.monitor.c r8 = new com.bytedance.android.livesdk.interactivity.api.monitor.c(r5, r6, r7, r9);
            r8.a(InteractivityMonitor.Event.ChatChannelJoin);
            r8.b(InteractivityTraceMonitor.Event.ChatChannelJoin);
            ChatChannelManager.access$notifyListener(this.a, new ChatChannelManager$joinChannel$2$1(this, r13));
        }
    }

    public static final class l<T> implements Consumer {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Response r2 = (Response) r1;
        }
    }

    public static final class m<T> implements Consumer {
        public static final m a = null;

        static {
            a = new m();
        }

        public m() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ ChatChannelManager a;

        public n(ChatChannelManager r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Room r4 = (Room) ((BaseResponse) ((Response) r3)).data;
            if (r4 == null) goto L8;
            RoomChannelData r5 = r4.roomChannel;
            if (r5 == null) goto L9;
            ChatChannelManager.access$initRoomChannelData(this.a, r5, "onLoginSuccess");
            return;
        L9:
            return;
        }
    }

    public static final class o<T> implements Consumer {
        public static final o a = null;

        static {
            a = new o();
        }

        public o() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class p<T> implements Consumer {
        public final /* synthetic */ ChatChannelManager a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ s22.a d;

        public p(ChatChannelManager r1, long r2, long r4, s22.a r6) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r6;
        }

        public final void accept(Object r8) {
            final Response r9 = (Response) r8;
            s22.a r0 = ChatChannelManager.removeRoomChannel$default(this.a, this.b, false, 2, null);
            if (r0 != null) goto L5;
            ChatChannelManager r1 = this.a;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.l(this.d, "user action");
            int r2 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.k(this.d, ((BaseResponse) r9).logId, this.c);
            ChatChannelManager.access$notifyListener(r1, new ChatChannelManager$quitChannel$1$$special$$inlined$run$lambda$1(this, r9));
            return;
        L5:
            if (r0.y() != 2) goto L7;
            ChatChannelManager.access$getChannelBanSet$p(this.a).add(Long.valueOf(r0.getChannelId()));
        L7:
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.l(r0, "user action");
            int r3 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.k(r0, ((BaseResponse) r9).logId, this.c);
            com.bytedance.android.livesdk.interactivity.api.chatchannel.model.k r4 = (com.bytedance.android.livesdk.interactivity.api.chatchannel.model.k) ((BaseResponse) r9).data;
            if (r4 == null) goto L10;
            String r5 = r4.a();
        L11:
            f2.c(r5, 0);
            ChatChannelManager.access$tryStopFetchMessage(this.a);
            ChatChannelManager.access$notifyListener(this.a, new ChatChannelManager$quitChannel$1$$special$$inlined$let$lambda$1(this, r9));
            return;
        L10:
            r5 = null;
            goto L11
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ ChatChannelManager a;
        public final /* synthetic */ long b;
        public final /* synthetic */ s22.a c;
        public final /* synthetic */ long d;

        public q(ChatChannelManager r1, long r2, s22.a r4, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }

        public final void accept(Object r13) {
            final Throwable r14 = (Throwable) r13;
            long r0 = this.b;
            String r2 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.l.a(r14);
            int r3 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.a;
            Intrinsics.checkNotNullParameter("user action", "source");
            Intrinsics.checkNotNullParameter(r2, "reason");
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("quit failed, channelId is " + r0 + ", source is user action, reason is " + r2);
            int r1 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
            s22.a r4 = this.c;
            long r5 = this.d;
            Intrinsics.checkNotNullParameter(r4, "channel");
            int r6 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.e(r14);
            String r7 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.f(r14);
            long r8 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.c(Long.valueOf(r5));
            LinkedHashMap r10 = new LinkedHashMap();
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.j(r10, r4);
            r10.put("reason", com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.d(r14));
            Unit r9 = Unit.INSTANCE;
            com.bytedance.android.livesdk.interactivity.api.monitor.c r11 = new com.bytedance.android.livesdk.interactivity.api.monitor.c(r6, r7, r8, r10);
            r11.a(InteractivityMonitor.Event.ChatChannelQuit);
            r11.b(InteractivityTraceMonitor.Event.ChatChannelQuit);
            ChatChannelManager.access$showPromptToast(this.a, r14);
            ChatChannelManager.access$notifyListener(this.a, new ChatChannelManager$quitChannel$2$1(this, r14));
        }
    }

    public static final class r<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ s22.a d;
        public final /* synthetic */ long e;

        public r(long r1, boolean r3, boolean r4, s22.a r5, long r6) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public final void accept(Object r14) {
            long r0 = this.a;
            boolean r2 = this.b;
            boolean r3 = this.c;
            int r4 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.a;
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("set setting success, channelId is " + r0 + ", linkState is " + r2 + ", inviteState is " + r3);
            int r1 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
            s22.a r5 = this.d;
            boolean r6 = this.b;
            boolean r7 = this.c;
            String r15 = ((BaseResponse) ((Response) r14)).logId;
            long r8 = this.e;
            Intrinsics.checkNotNullParameter(r5, "channel");
            long r9 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.c(Long.valueOf(r8));
            LinkedHashMap r11 = new LinkedHashMap();
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.j(r11, r5);
            r11.put("link_mic_switch", String.valueOf(r6));
            r11.put("member_invite_switch", String.valueOf(r7));
            if (r15 != null) goto L5;
            r15 = BuildConfig.FLAVOR;
        L5:
            r11.put("log_id", r15);
            Unit r16 = Unit.INSTANCE;
            com.bytedance.android.livesdk.interactivity.api.monitor.c r17 = new com.bytedance.android.livesdk.interactivity.api.monitor.c(0, null, r9, r11, 3);
            r17.a(InteractivityMonitor.Event.ChatChannelSettingSet);
            r17.b(InteractivityTraceMonitor.Event.ChatChannelSettingSet);
        }
    }

    public static final class s<T> implements Consumer {
        public final /* synthetic */ ChatChannelManager a;
        public final /* synthetic */ long b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ s22.a e;
        public final /* synthetic */ long f;

        public s(ChatChannelManager r1, long r2, boolean r4, boolean r5, s22.a r6, long r7) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }

        public final void accept(Object r14) {
            Throwable r15 = (Throwable) r14;
            long r0 = this.b;
            boolean r2 = this.c;
            boolean r3 = this.d;
            String r4 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.l.a(r15);
            int r5 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.a;
            Intrinsics.checkNotNullParameter(r4, "reason");
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("set setting failed, channelId is " + r0 + ", linkState is " + r2 + ", inviteState is " + r3 + ", reason is " + r4);
            int r1 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
            s22.a r6 = this.e;
            boolean r7 = this.c;
            boolean r8 = this.d;
            long r9 = this.f;
            Intrinsics.checkNotNullParameter(r6, "channel");
            int r10 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.e(r15);
            String r11 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.f(r15);
            long r13 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.c(Long.valueOf(r9));
            LinkedHashMap r16 = new LinkedHashMap();
            com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.j(r16, r6);
            r16.put("link_mic_switch", String.valueOf(r7));
            r16.put("member_invite_switch", String.valueOf(r8));
            r16.put("reason", com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.d(r15));
            Unit r17 = Unit.INSTANCE;
            com.bytedance.android.livesdk.interactivity.api.monitor.c r18 = new com.bytedance.android.livesdk.interactivity.api.monitor.c(r10, r11, r13, r16);
            r18.a(InteractivityMonitor.Event.ChatChannelSettingSet);
            r18.b(InteractivityTraceMonitor.Event.ChatChannelSettingSet);
            ChatChannelManager.access$showPromptToast(this.a, r15);
        }
    }

    static {
        Companion = new a();
    }

    private final void processFansGroupChannel() {
        Map<Long, RoomChannelInfo> r0 = this.fansGroupChannel;
        if (r0 == null) goto L32;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<Long, RoomChannelInfo>> r2 = r0.entrySet().iterator();
    L5:
        boolean r3 = r2.hasNext();
        boolean r4 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
        if (r3 == false) goto L17;
        Map.Entry<Long, RoomChannelInfo> r5 = r2.next();
        if (this.alreadInfansGroupIdSet.contains(r5.getKey()) == true) goto L12;
        if (this.showGuideEntry == true) goto L12;
    L14:
        r4 = false;
    L15:
        if (r4 == false) goto L5;
        r1.put(r5.getKey(), r5.getValue());
    L12:
        if (this.channelBanSet.contains(Long.valueOf(r5.getValue().getChannelId())) == true) goto L14;
    L17:
        Iterator r6 = r1.entrySet().iterator();
    L19:
        if (r6.hasNext() == false) goto L46;
        Map.Entry r7 = (Map.Entry) r6.next();
        final s22.a r8 = shouldRefreshChannel((RoomChannelInfo) r7.getValue());
        if (r8 != null) goto L22;
        if (this.alreadInfansGroupIdSet.contains(r7.getKey()) == false) goto L26;
    L28:
        boolean r11 = false;
    L29:
        s22.a r9 = createAndAddRoomChannel$default(this, (RoomChannelInfo) r7.getValue(), false, 0, false, r11, 4, null);
        if (r9 == null) goto L19;
        afterProcessAudienceChannel(r9);
        goto L19
    L26:
        if (this.showGuideEntry == false) goto L28;
        r11 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
        goto L29
    L22:
        notifyListener(new ChatChannelManager$processFansGroupChannel$2$1$1(r8));
        goto L19
    L46:
        return;
    }

    private final void processFansclubChannel() {
        if (this.isFansClub == false) goto L5;
    L6:
        RoomChannelInfo r0 = this.fansClubChannel;
        if (r0 == null) goto L28;
        Set<Long> r1 = this.channelBanSet;
        if (r0 == null) goto L11;
        Long r2 = Long.valueOf(r0.getChannelId());
    L13:
        if (CollectionsKt.contains(r1, r2) == true) goto L29;
        final s22.a r3 = shouldRefreshChannel(this.fansClubChannel);
        if (r3 == null) goto L18;
        notifyListener(new ChatChannelManager$processFansclubChannel$1$1(r3));
        return;
    L18:
        if (this.isFansClub == false) goto L20;
    L22:
        boolean r7 = false;
    L23:
        s22.a r4 = createAndAddRoomChannel$default(this, this.fansClubChannel, false, 0, false, r7, 4, null);
        if (r4 == null) goto L31;
        afterProcessAudienceChannel(r4);
        return;
    L31:
        return;
    L20:
        if (this.showGuideEntry == false) goto L22;
        r7 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
        goto L23
    L29:
        return;
    L11:
        r2 = null;
        goto L13
    L28:
        return;
    L5:
        if (this.showGuideEntry == true) goto L6;
    }

    private final void processFansclubChannelList() {
        List<RoomChannelInfo> r0 = this.fansClubChannelList;
        if (r0 == null) goto L46;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L5:
        boolean r3 = false;
        if (r2.hasNext() == false) goto L14;
        Object r4 = r2.next();
        RoomChannelInfo r5 = (RoomChannelInfo) r4;
        if (this.showGuideEntry == true) goto L10;
    L12:
        if (r3 == false) goto L5;
        r1.add(r4);
        goto L5
    L10:
        if (this.channelBanSet.contains(Long.valueOf(r5.getChannelId())) == true) goto L12;
        r3 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
        goto L12
    L14:
        Iterator r6 = r1.iterator();
    L16:
        if (r6.hasNext() == false) goto L61;
        RoomChannelInfo r7 = (RoomChannelInfo) r6.next();
        final s22.a r8 = shouldRefreshChannel(r7);
        if (r8 != null) goto L19;
        Set<String> r9 = this.userInFansClubMap;
        User r10 = r7.getGroupLiveMember();
        String r11 = null;
        if (r10 == null) goto L23;
        String r13 = r10.getIdString();
    L24:
        boolean r14 = CollectionsKt.contains(r9, r13) ^ DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
        Set<String> r15 = this.userInFansClubMap;
        User r16 = r7.getOwner();
        if (r16 == null) goto L27;
        String r17 = r16.getIdString();
    L28:
        boolean r18 = CollectionsKt.contains(r15, r17) ^ DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
        Set<String> r19 = this.userInFansClubMap;
        if (r19 == null) goto L34;
        Iterator<T> r20 = r19.iterator();
    L32:
        if (r20.hasNext() == false) goto L34;
        ALogger.i("ChatChannelManager", "userInFansClubMap 有 " + ((String) r20.next()));
    L34:
        StringBuilder r21 = new StringBuilder("groupLiveMember is ");
        User r23 = r7.getGroupLiveMember();
        if (r23 == null) goto L37;
        r11 = r23.getIdString();
    L37:
        r21.append(r11);
        ALogger.i("ChatChannelManager", r21.toString());
        if (this.showGuideEntry == false) goto L42;
        if (r14 == false) goto L42;
        if (r18 == false) goto L42;
        boolean r110 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
    L43:
        s22.a r24 = createAndAddRoomChannel$default(this, r7, false, 0, false, r110, 4, null);
        if (r24 == null) goto L16;
        afterProcessAudienceChannel(r24);
    L42:
        r110 = false;
        goto L43
    L27:
        r17 = null;
        goto L28
    L23:
        r13 = null;
        goto L24
    L19:
        notifyListener(new ChatChannelManager$processFansclubChannelList$2$1$1(r8));
        goto L16
    L61:
        return;
    }

    private final void processSubscribeChannel() {
        if (this.isSubscribe == false) goto L5;
    L6:
        RoomChannelInfo r0 = this.subscribeChannel;
        if (r0 == null) goto L28;
        Set<Long> r1 = this.channelBanSet;
        if (r0 == null) goto L11;
        Long r2 = Long.valueOf(r0.getChannelId());
    L13:
        if (CollectionsKt.contains(r1, r2) == true) goto L29;
        final s22.a r3 = shouldRefreshChannel(this.subscribeChannel);
        if (r3 == null) goto L18;
        notifyListener(new ChatChannelManager$processSubscribeChannel$1$1(r3));
        return;
    L18:
        if (this.isSubscribe == false) goto L20;
    L22:
        boolean r7 = false;
    L23:
        s22.a r4 = createAndAddRoomChannel$default(this, this.subscribeChannel, false, 0, false, r7, 4, null);
        if (r4 == null) goto L31;
        afterProcessAudienceChannel(r4);
        return;
    L31:
        return;
    L20:
        if (this.showGuideEntry == false) goto L22;
        r7 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
        goto L23
    L29:
        return;
    L11:
        r2 = null;
        goto L13
    L28:
        return;
    L5:
        if (this.showGuideEntry == true) goto L6;
    }

    private final void tryStartFetchMessage() {
        vlc.e r0 = this.channelMessageManager.f;
        if ((r0 instanceof vlc.e) == true) goto L5;
        r0 = null;
    L5:
        if (r0 == null) goto L7;
        boolean r1 = r0.isRunning();
    L8:
        if (r1 == true) goto L11;
        RoomChannelIMManager r2 = this.channelMessageManager;
        com.bytedance.android.livesdk.interactivity.base.im.b r3 = r2.a;
        long r4 = r2.j;
        r3.getClass();
        r3.b("start fetch message, roomId is " + r4);
        r2.f.startMessage();
        return;
    L11:
        return;
    L7:
        r1 = false;
        goto L8
    }

    private final void tryStopFetchMessage() {
        if (this.channelList.isEmpty() == false) goto L6;
        this.channelMessageManager.f();
        return;
    }

    @Override // s22.e
    public com.bytedance.android.live.core.arch.mvvm.d<sh6.b<s22.a>> getCurrentChannel() {
        PropertyOwner<sh6.b<s22.a>> r0 = this.currentChannel;
        r0.getClass();
        return r0;
    }

    @Override // s22.e
    public s22.a getLatestChannel() {
        Iterator<T> r0 = this.channelList.iterator();
        if (r0.hasNext() == true) goto L5;
        Object r1 = null;
    L23:
        return (s22.a) r1;
    L5:
        Object r2 = r0.next();
        if (r0.hasNext() == true) goto L8;
    L7:
        r1 = r2;
        goto L23
    L8:
        com.bytedance.android.livesdk.interactivity.service.messagelist.l r3 = ((com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r2).b.h.b();
        if (r3 == null) goto L11;
        long r5 = r3.f;
    L12:
        Object r4 = r0.next();
        com.bytedance.android.livesdk.interactivity.service.messagelist.l r7 = ((com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r4).b.h.b();
        if (r7 == null) goto L15;
        long r8 = r7.f;
    L17:
        if (r5 >= r8) goto L20;
        r2 = r4;
        r5 = r8;
    L20:
        if (r0.hasNext() == true) goto L12;
    L15:
        r8 = 0;
        goto L17
    L11:
        r5 = 0;
        goto L12
    }

    public void onCleared() {
        release("onCleared");
    }

    public /* bridge */ /* synthetic */ id0.a getIMManager() {
        return mo555getIMManager();
    }

    @Override // s22.e
    public void onLoginSuccess() {
        RxUtilKt.c(((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).getRoomInfoByScene(this.roomId, SCENE_FOR_ROOM_INFO).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(this), o.a), this.compositeDisposable);
    }

    @Override // s22.e
    public List<s22.a> getAllChannel() {
        return this.channelList;
    }

    @Override // s22.e
    public com.bytedance.android.livesdk.interactivity.api.b getAnimManager() {
        return this.animManager;
    }

    @Override // s22.e
    public s22.e.b getConfig() {
        return this.config;
    }

    @Override // s22.e
    public s22.b getEmojiManager() {
        return this.emojiManager;
    }

    @Override // s22.e
    public s22.c getGreetingManager() {
        return this.greetingManager;
    }

    public long getRoomId() {
        return this.roomId;
    }

    @Override // s22.e
    public s22.f getToolbarManager() {
        return this.channelToolbarManager;
    }

    @Override // s22.e
    public s22.g getWidgetManager() {
        return this.widgetManager;
    }

    @Override // s22.e
    /* JADX INFO: renamed from: getIMManager, reason: collision with other method in class */
    public s22.d mo555getIMManager() {
        return this.channelMessageManager;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_livesdk_interactivity_chatchannel_manager_ChatChannelManager_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(DialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_livesdk_interactivity_chatchannel_manager_ChatChannelManager_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(AppCompatDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static final /* synthetic */ Set access$getAlreadApplyChannelIdSet$p(ChatChannelManager r0) {
        return r0.alreadApplyChannelIdSet;
    }

    public static final /* synthetic */ Set access$getChannelBanSet$p(ChatChannelManager r0) {
        return r0.channelBanSet;
    }

    public static final /* synthetic */ List access$getChannelList$p(ChatChannelManager r0) {
        return r0.channelList;
    }

    public static final /* synthetic */ DataCenter access$getDataCenter$p(ChatChannelManager r0) {
        return r0.dataCenter;
    }

    public static final /* synthetic */ boolean access$getEnableMultiFansclubChannel$p(ChatChannelManager r0) {
        return r0.enableMultiFansclubChannel;
    }

    public static final /* synthetic */ RoomContext access$getRoomContext$p(ChatChannelManager r0) {
        return r0.roomContext;
    }

    public static final /* synthetic */ boolean access$isFansClub$p(ChatChannelManager r0) {
        return r0.isFansClub;
    }

    public static final /* synthetic */ boolean access$isSubscribe$p(ChatChannelManager r0) {
        return r0.isSubscribe;
    }

    public static final /* synthetic */ void access$processFansclubChannel(ChatChannelManager r0) {
        r0.processFansclubChannel();
    }

    public static final /* synthetic */ void access$processFansclubChannelList(ChatChannelManager r0) {
        r0.processFansclubChannelList();
    }

    public static final /* synthetic */ void access$processSubscribeChannel(ChatChannelManager r0) {
        r0.processSubscribeChannel();
    }

    public static final /* synthetic */ void access$tryStartFetchMessage(ChatChannelManager r0) {
        r0.tryStartFetchMessage();
    }

    public static final /* synthetic */ void access$tryStopFetchMessage(ChatChannelManager r0) {
        r0.tryStopFetchMessage();
    }

    private final void afterProcessAudienceChannel(final s22.a r5) {
        notifyListener(new C03071(r5));
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.j(r5);
        if (this.channelList.size() != 1) goto L6;
        changeCurrentChannel(r5.getChannelId());
    L6:
        if (this.isReceiveEncryptMessage == false) goto L8;
        return;
    L8:
        if (r5.x() == true) goto L10;
        return;
    L10:
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c.i == false) goto L18;
        vlc.d r6 = (vlc.d) this.roomContext.getMessageManager().getValue();
        if (r6 == null) goto L14;
        r6.addMessageListener(InteractivityMessageType.RoomChannelEncrypt.getMessageIntType(), this);
    L14:
        this.isReceiveEncryptMessage = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
        return;
    }

    private final void deleteWRDSAnchorFansChannel(long r10) {
        List<com.bytedance.android.livesdk.interactivity.chatchannel.manager.c> r0 = this.channelList;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L17;
        Object r3 = r2.next();
        com.bytedance.android.livesdk.interactivity.chatchannel.manager.c r4 = (com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r3;
        if (r4.y == false) goto L8;
    L14:
        boolean r5 = false;
    L15:
        if (r5 == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        if (r4.r != 2) goto L14;
        FansChannelCreateInfo r6 = r4.w;
        if (r6 == null) goto L14;
        if (r6.getFansChannelType() != r10) goto L14;
        r5 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
        goto L15
    L17:
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r13 = r1.iterator();
    L19:
        if (r13.hasNext() == false) goto L21;
        r11.add(Long.valueOf(((com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r13.next()).p));
        goto L19
    L21:
        Iterator r14 = r11.iterator();
    L23:
        if (r14.hasNext() == false) goto L27;
        final s22.a r15 = removeRoomChannel$default(this, ((Number) r14.next()).longValue(), false, 2, null);
        if (r15 == null) goto L23;
        notifyListener(new ChatChannelManager$deleteWRDSAnchorFansChannel$3$1$1(r15));
        goto L23
    }

    private final void doAnchorFansChannelAfterProcess(s22.a r18) {
        long r3 = 0;
        if (r18.b() != 0) goto L18;
        trySwitchToChannelPage(r18.getChannelId(), PublicScreenAreaPageChangeSource.ChannelCreate);
        changeCurrentChannel(r18.getChannelId());
        if (this.channelList.size() <= 1) goto L18;
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.c(this.roomContext, this.dataCenter) == false) goto L18;
        s22.a r1 = this._currentChannel;
        if (r1 == null) goto L18;
        if (r1.getChannelId() != r18.getChannelId()) goto L18;
        String r10 = String.valueOf(r18.y());
        boolean r11 = ((Boolean) r18.v().a).booleanValue();
        FansChannelCreateInfo r2 = r18.C();
        if (r2 == null) goto L16;
        String r4 = String.valueOf(r2.getFansChannelType());
        if (r4 == null) goto L16;
    L17:
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.i.a(false, "create", r10, r11, r4, String.valueOf(r18.getChannelId()), String.valueOf(r18.f()), r18.s(), r18.x());
    L16:
        r4 = "0";
    L18:
        FansChannelCreateInfo r5 = r18.C();
        if (r5 != null) goto L21;
    L26:
        tryStartFetchMessage();
        return;
    L21:
        if (r5.getFansChannelType() != 3) goto L26;
        FansChannelCreateInfo r6 = r18.C();
        if (r6 == null) goto L25;
        r3 = r6.getGroupId();
    L25:
        shareRoomToConversation(r3);
        goto L26
    }

    private final void notifyListener(Function1<? super s22.e.c, Unit> r3) {
        ArrayList r0 = new ArrayList();
        r0.addAll(this.listenerList);
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r3.invoke((s22.e.c) r1.next());
        goto L4
    }

    private final void processWRDSMessageForAnchor(RoomAnchorFansChannelMessage r2) {
        RoomChannelInfo r0 = r2.getFansClubChannel();
        if (r0 == null) goto L5;
        receiveAnchorChannel(r0);
    L5:
        RoomChannelInfo r1 = r2.getSubscribeChannel();
        if (r1 == null) goto L8;
        receiveAnchorChannel(r1);
    L8:
        Map r3 = r2.getFansGroupChannelMap();
        if (r3 == null) goto L14;
        Iterator r4 = r3.entrySet().iterator();
    L12:
        if (r4.hasNext() == false) goto L16;
        receiveAnchorChannel((RoomChannelInfo) ((Map.Entry) r4.next()).getValue());
        goto L12
    L16:
        return;
    }

    private final void processWRDSMessageForAudience(RoomAnchorFansChannelMessage r5) {
        if (this.enableMultiFansclubChannel == false) goto L12;
        this.fansClubChannelList = r5.getFansClubChannelList();
        if (r5.getFansClubChannelList() == null) goto L11;
        List r0 = r5.getFansClubChannelList();
        if (r0 != null) goto L9;
    L10:
        processFansclubChannelList();
    L16:
        this.subscribeChannel = r5.getSubscribeChannel();
        if (r5.getSubscribeChannel() == null) goto L19;
        processSubscribeChannel();
    L20:
        this.fansGroupChannel = r5.getFansGroupChannelMap();
        Map r6 = r5.getFansGroupChannelMap();
        if (r6 != null) goto L23;
    L25:
        deleteWRDSAnchorFansChannel(3);
        return;
    L23:
        if ((r6.isEmpty() ^ DEFAULT_CHANNEL_CREATE_ENABLE_STATE) != true) goto L25;
        processFansGroupChannel();
        return;
    L19:
        deleteWRDSAnchorFansChannel(2);
        goto L20
    L9:
        if (r0.isEmpty() != true) goto L10;
    L11:
        deleteWRDSAnchorFansChannel(1);
        goto L16
    L12:
        this.fansClubChannel = r5.getFansClubChannel();
        if (r5.getFansClubChannel() == null) goto L15;
        processFansclubChannel();
        goto L16
    L15:
        deleteWRDSAnchorFansChannel(1);
        goto L16
    }

    private final void receiveAnchorChannel(RoomChannelInfo r13) {
        List<com.bytedance.android.livesdk.interactivity.chatchannel.manager.c> r0 = this.channelList;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L16;
        boolean r2 = false;
        if (((com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r1.next()).p != r13.getChannelId()) goto L13;
        boolean r3 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
    L14:
        if (r3 == false) goto L9;
    L17:
        if (r2 == false) goto L30;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.l(r13, DEFAULT_CHANNEL_CREATE_ENABLE_STATE);
        r13.setOwner(DEFAULT_CHANNEL_CREATE_ENABLE_STATE);
        final s22.a r14 = createAndAddRoomChannel$default(this, r13, false, 0, DEFAULT_CHANNEL_CREATE_ENABLE_STATE, false, 4, null);
        if (r14 == null) goto L31;
        notifyListener(new ChatChannelManager$receiveAnchorChannel$2$1(r14));
        if (this.channelList.size() != 1) goto L23;
        changeCurrentChannel(r14.getChannelId());
    L23:
        doAnchorFansChannelAfterProcess(r14);
        return;
    L31:
        return;
    L30:
        return;
    L13:
        r3 = false;
    L16:
        r2 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
        goto L17
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    private final void release(String r6) {
        long r0 = this.roomId;
        int r2 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.a;
        Intrinsics.checkNotNullParameter(r6, "source");
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("destroy room channel, roomId is " + r0 + ", source is " + r6);
        this.compositeDisposable.dispose();
        this.listenerList.clear();
        Iterator<T> r7 = this.channelList.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r7.next()).D(this);
        goto L4
    L6:
        this.channelList.clear();
        vlc.d r8 = (vlc.d) this.roomContext.getMessageManager().getValue();
        if (r8 == null) goto L9;
        r8.removeMessageListener(this);
    L9:
        this.channelMessageManager.removeMessageListener(this);
        this.channelMessageManager.f();
        RoomChannelIMManager r9 = this.channelMessageManager;
        com.bytedance.android.livesdk.interactivity.base.im.b r1 = r9.a;
        long r3 = r9.j;
        r1.getClass();
        r1.b("destroy, roomId is " + r3);
        r9.b.clear();
        c62.b r4 = r9.d;
        Iterator r5 = ((LinkedHashMap) r4.a).entrySet().iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        c62.b.c r10 = (c62.b.c) ((Map.Entry) r5.next()).getValue();
        r10.a.clear();
        r10.b.clear();
        goto L11
    L13:
        ((LinkedHashMap) r4.a).clear();
        r9.e.a.clear();
        d62.b r11 = r9.c;
        Iterator r13 = ((LinkedHashMap) r11.a).entrySet().iterator();
    L15:
        if (r13.hasNext() == false) goto L23;
        Map.Entry r14 = (Map.Entry) r13.next();
        ((LinkedHashMap) ((d62.b.a) r14.getValue()).a).clear();
        Iterator<Map.Entry<String, Set<ylc.c>>> r15 = ((d62.b.a) r14.getValue()).b.entrySet().iterator();
    L18:
        if (r15.hasNext() == false) goto L15;
        Iterator<T> r16 = r15.next().getValue().iterator();
    L21:
        if (r16.hasNext() == false) goto L18;
        ((ylc.c) r16.next()).onClear();
        goto L21
    L23:
        r11.b.clear();
        r9.f.release();
        r9.g.clear();
        this.alreadInfansGroupIdSet.clear();
        this.alreadApplyChannelIdSet.clear();
        this.channelBanSet.clear();
        ChatChannelWidgetManager r17 = this.widgetManager;
        r17.getClass();
        Intrinsics.checkNotNullParameter(this, "manager");
        DataCenter r18 = r17.b;
        if (r18 == null) goto L26;
        r18.removeObserver(r17);
    L26:
        CompositeDisposable r19 = r17.e;
        if (r19 == null) goto L29;
        r19.dispose();
    L29:
        r17.a = null;
        r17.b = null;
        r17.c = null;
        r17.d = null;
        com.bytedance.android.livesdk.interactivity.chatchannel.manager.r r20 = this.channelToolbarManager;
        CompositeDisposable r21 = r20.d;
        if (r21 == null) goto L32;
        r21.dispose();
    L32:
        r20.a = null;
        r20.b = null;
        r20.c = null;
        com.bytedance.android.livesdk.interactivity.chatchannel.manager.n r23 = this.emojiManager;
        Disposable r24 = r23.a;
        if (r24 == null) goto L35;
        r24.dispose();
    L35:
        r23.a = null;
        r23.b = null;
        r23.c = null;
        ChatChannelAnimManager r25 = this.animManager;
        r25.getClass();
        ChatChannelAnimManager.e("onManagerDestroy");
        int r26 = 0;
        r25.d = false;
        r25.b = null;
        ((PriorityQueue) r25.a).clear();
        r25.d().removeCallbacksAndMessages(null);
        ChatChannelGreetingManager r27 = this.greetingManager;
        if (r27 == null) goto L46;
        r27.o.clear();
        r27.h = false;
        r27.h().removeCallbacks(r27.f());
        r27.m(false);
        ChatChannelGreetingManager.b r28 = r27.q;
        if (r28 == null) goto L42;
        ViewGroup r29 = r28.b;
        if (r29 == null) goto L42;
        r29.removeView(r27.e());
    L42:
        r27.q = null;
    L44:
        if (r26 >= 2) goto L46;
        r27.p[r26] = null;
        r26 = r26 + 1;
    L46:
        Iterator<Map.Entry<String, Object>> r30 = this.dialogHashMap.entrySet().iterator();
    L48:
        if (r30.hasNext() == false) goto L55;
        Object r31 = r30.next().getValue();
        if ((r31 instanceof DialogFragment) == true) goto L51;
        if ((r31 instanceof AppCompatDialog) == false) goto L48;
        INVOKEVIRTUAL_com_bytedance_android_livesdk_interactivity_chatchannel_manager_ChatChannelManager_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss((AppCompatDialog) r31);
        goto L48
    L51:
        INVOKEVIRTUAL_com_bytedance_android_livesdk_interactivity_chatchannel_manager_ChatChannelManager_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss((DialogFragment) r31);
        goto L48
    L55:
        this.dialogHashMap.clear();
        updateChatChannelLogFilter(null);
    }

    private final void shareRoomToConversation(long r23) {
        if (r23 > 0) goto L5;
        return;
    L5:
        String r1 = String.valueOf(r23);
        ILiveShareService r2 = jc1.k.f(ILiveShareService.class);
        if (r2 == null) goto L17;
        com.bytedance.android.live.base.model.user.f r6 = r2.getContactUserObjById(r1);
        if (r6 == null) goto L19;
        ShareParams.Builder r3 = ShareParams.buildUponRoom((IRoom) this.roomContext.getRoom().getValue());
        ILiveShareService r4 = jc1.k.f(ILiveShareService.class);
        if (r4 == null) goto L18;
        ShareParams r7 = r3.build();
        Context r5 = this.context;
        if ((r5 instanceof Activity) == true) goto L15;
        r5 = null;
    L15:
        Intrinsics.checkNotNullParameter(r6, "contactUser");
        r4.share(new i81.a(null, (Activity) r5, r6, r7, null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, null, false), "ChatChannel", LiveShareType.SHARE_IM, null);
        return;
    L18:
        return;
    L19:
        return;
    }

    private final s22.a shouldRefreshChannel(RoomChannelInfo r13) {
        Iterator<T> r0 = this.channelList.iterator();
    L3:
        boolean r1 = r0.hasNext();
        boolean r2 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
        if (r1 == false) goto L13;
        Object r3 = r0.next();
        long r5 = ((com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r3).p;
        if (r13 != null) goto L8;
    L10:
        boolean r6 = false;
    L11:
        if (r6 == false) goto L3;
    L14:
        com.bytedance.android.livesdk.interactivity.chatchannel.manager.c r4 = (com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r3;
        if (r4 != null) goto L17;
        return null;
    L17:
        if (r4.y == true) goto L23;
        PropertyOwner<Long> r7 = r4.h;
        r7.getClass();
        long r8 = ((Number) r7.a).longValue();
        if (r13 != null) goto L21;
    L24:
        if (r2 == true) goto L27;
        r4 = null;
    L27:
        if (r4 != null) goto L29;
        return null;
    L29:
        return refreshRoomChannel$default(this, r13, 0, 2, null);
    L21:
        if (r8 != r13.getMemberCount()) goto L24;
    L23:
        r2 = false;
        goto L24
    L8:
        if (r5 != r13.getChannelId()) goto L10;
        r6 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
        goto L11
    L13:
        r3 = null;
        goto L14
    }

    private final void showPromptToast(Throwable r2) {
        if ((r2 instanceof ApiServerException) == true) goto L5;
        r2 = null;
    L5:
        ApiServerException r3 = (ApiServerException) r2;
        if (r3 == null) goto L11;
        String r4 = r3.getPrompt();
        if (r4 == null) goto L12;
        f2.c(r4, 0);
        return;
    L12:
        return;
    }

    private final void updateChatChannelLogFilter(com.bytedance.android.livesdk.log.filter.n r3) {
        com.bytedance.android.livesdk.log.filter.o r0 = u.l().c(com.bytedance.android.livesdk.log.filter.n.class);
        if (r0 == null) goto L6;
        r0.setData(r3);
        return;
    }

    @Override // s22.e
    public void addListener(s22.e.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.listenerList.contains(r2) == false) goto L5;
        return;
    L5:
        this.listenerList.add(r2);
        r2.hb(this.channelList);
    }

    @Override // s22.e
    public void addListenerFirst(s22.e.c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (this.listenerList.contains(r3) == false) goto L5;
        return;
    L5:
        ListProtector.add(this.listenerList, 0, r3);
        r3.hb(this.channelList);
    }

    @Override // s22.e
    public boolean changeCurrentChannel(long r13) {
        Iterator<T> r0 = this.channelList.iterator();
    L3:
        Long r3 = null;
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r1).p != r13) goto L8;
        boolean r4 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
    L9:
        if (r4 == false) goto L3;
    L12:
        s22.a r2 = (s22.a) r1;
        this._currentChannel = r2;
        if (r2 != null) goto L15;
    L28:
        this.currentChannel.onNext(sh6.c.a(this._currentChannel));
        return DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
    L15:
        if (r2.s() == true) goto L28;
        if (r2.x() == true) goto L28;
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.c(this.roomContext, this.dataCenter) == false) goto L28;
        long r5 = r2.getChannelId();
        long r7 = r2.y();
        FansChannelCreateInfo r14 = r2.C();
        if (r14 == null) goto L23;
        Long r9 = Long.valueOf(r14.getFansChannelType());
    L24:
        FansChannelCreateInfo r15 = r2.C();
        if (r15 == null) goto L27;
        r3 = Long.valueOf(r15.getGroupId());
    L27:
        joinAnchorFansChannel(r5, r7, r9, r3);
        goto L28
    L23:
        r9 = null;
        goto L24
    L8:
        r4 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    @Override // s22.e
    public void createChannel(com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e r7) {
        long r0 = System.currentTimeMillis();
        xj r8 = xj.a;
        Integer r2 = (Integer) r8.getValue();
        if (r2 != null) goto L6;
    L7:
        Integer r9 = (Integer) r8.getValue();
        if (r9 != null) goto L11;
    L13:
        boolean r10 = false;
    L15:
        RxUtilKt.c(this.roomChannelApi.createChannel(this.roomId, r10 ^ DEFAULT_CHANNEL_CREATE_ENABLE_STATE).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r0), new e(this, r0)), this.compositeDisposable);
        return;
    L11:
        if (r9.intValue() != 1) goto L13;
    L14:
        r10 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
        goto L15
    L6:
        if (r2.intValue() == 0) goto L14;
        goto L7
    }

    @Override // s22.e
    public void deleteAnchorFansChannel(final long r7) {
        if (removeRoomChannel$default(this, r7, false, 2, null) == null) goto L6;
        notifyListener(new ChatChannelManager$deleteAnchorFansChannel$$inlined$let$lambda$1(this, r7));
        return;
    }

    @Override // s22.e
    public void dissolveChannel(long r14) {
        s22.a r7 = getChannel(r14);
        if (r7 != null) goto L5;
        return;
    L5:
        long r8 = System.currentTimeMillis();
        RxUtilKt.c(this.roomChannelApi.disbandChannel(this.roomId, r14).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, r7, r8, r14), new g(this, r14, r7, r8)), this.compositeDisposable);
    }

    @Override // s22.e
    public s22.a getChannel(long r6) {
        Iterator<T> r0 = this.channelList.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r1).p != r6) goto L8;
        boolean r2 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
    L9:
        if (r2 == false) goto L4;
    L13:
        return (s22.a) r1;
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L13
    }

    @Override // s22.e
    public Observable<Response<com.bytedance.android.livesdk.interactivity.api.chatchannel.model.j>> getInviteId(long r4) {
        return this.roomChannelApi.inviteChannel(this.roomId, r4);
    }

    @Override // s22.e
    public void insertLocalMessage(y32.a r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        RoomChannelIMManager r1 = this.channelMessageManager;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "message");
        r1.f.j(r3, DEFAULT_CHANNEL_CREATE_ENABLE_STATE);
    }

    @Override // s22.e
    public void joinChannel(long r18) {
        long r2 = System.currentTimeMillis();
        RxUtilKt.c(RoomChannelRetrofitApi.a.a(this.roomChannelApi, this.roomId, r18, null, null, null, null, 60).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this, r2), new k(this, r2, r18)), this.compositeDisposable);
    }

    public void onMessage(tlc.d r21) {
        long r10 = 0;
        if ((r21 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.a) == false) goto L19;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.message.a r13 = (com.bytedance.android.livesdk.interactivity.api.chatchannel.message.a) r21;
        if (r13.G() == false) goto L12;
        if (r13.H() == null) goto L12;
        final s22.a r0 = createAndAddRoomChannel$default(this, r13.H(), DEFAULT_CHANNEL_CREATE_ENABLE_STATE, 0, false, false, 28, null);
        if (r0 == null) goto L172;
        int r1 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.a;
        Intrinsics.checkNotNullParameter(r0, "channel");
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("join reply success, channelInfo is " + com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.a(r0));
        f2.c(r13.getToast(), 0);
        trySwitchToChannelPage(r0.getChannelId(), PublicScreenAreaPageChangeSource.ChannelReplyJoin);
        notifyListener(new C03091(r0));
        changeCurrentChannel(r0.getChannelId());
        tryStartFetchMessage();
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.i();
        return;
    L172:
        return;
    L12:
        if (r13.G() == false) goto L14;
        return;
    L14:
        if (TextUtils.isEmpty(r13.getToast()) == true) goto L175;
        RoomChannelInfo r2 = r13.H();
        if (r2 == null) goto L18;
        r10 = r2.getChannelId();
    L18:
        int r3 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.a;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("join reply failed, channelId is " + r10);
        f2.c(r13.getToast(), 0);
        return;
    L175:
        return;
    L19:
        Object r4 = null;
        if ((r21 instanceof l4) == false) goto L47;
        l4 r5 = (l4) r21;
        if (r5.getAction() != 2) goto L177;
        List<com.bytedance.android.livesdk.interactivity.chatchannel.manager.c> r6 = this.channelList;
        if (r6 == null) goto L178;
        Iterator<T> r7 = r6.iterator();
    L27:
        if (r7.hasNext() == false) goto L43;
        Object r8 = r7.next();
        User r9 = ((com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r8).A;
        if (r9 == null) goto L31;
        long r11 = r9.id;
    L32:
        String r14 = String.valueOf(r11);
        User r15 = r5.getUser();
        if (r15 == null) goto L39;
        t r16 = r15.getFansClub();
        if (r16 == null) goto L39;
        py.h r17 = r16.getData();
        if (r17 == null) goto L39;
        String r18 = r17.getAnchorId();
    L41:
        if (Intrinsics.areEqual(r14, r18) == false) goto L27;
        r4 = r8;
    L39:
        r18 = null;
        goto L41
    L31:
        r11 = 0;
    L43:
        com.bytedance.android.livesdk.interactivity.chatchannel.manager.c r19 = (com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r4;
        if (r19 == null) goto L179;
        r19.z = false;
        return;
    L179:
        return;
    L178:
        return;
    L177:
        return;
    L47:
        if ((r21 instanceof com.bytedance.android.livesdk.message.model.xj) == false) goto L50;
        this.alreadInfansGroupIdSet.add(Long.valueOf(((com.bytedance.android.livesdk.message.model.xj) r21).getGroupId()));
        processFansGroupChannel();
        return;
    L50:
        if ((r21 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.j) == false) goto L58;
        final s22.a r20 = removeRoomChannel$default(this, com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.o.a((BaseMessage) r21), false, 2, null);
        if (r20 != null) goto L54;
        return;
    L54:
        if (r20.y() != 2) goto L56;
        this.channelBanSet.add(Long.valueOf(r20.getChannelId()));
    L56:
        StringBuilder r23 = new StringBuilder("kick out message_");
        com.bytedance.android.livesdk.interactivity.api.chatchannel.message.j r24 = (com.bytedance.android.livesdk.interactivity.api.chatchannel.message.j) r21;
        r23.append(r24.getMessageId());
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.l(r20, r23.toString());
        f2.c(r24.getToast(), 0);
        tryStopFetchMessage();
        notifyListener(new ChatChannelManager$onMessage$3$1(r20));
        return;
    L58:
        if ((r21 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.f) == false) goto L63;
        final s22.a r25 = removeRoomChannel$default(this, com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.o.a((BaseMessage) r21), false, 2, null);
        if (r25 == null) goto L184;
        StringBuilder r26 = new StringBuilder("disband message_");
        com.bytedance.android.livesdk.interactivity.api.chatchannel.message.f r27 = (com.bytedance.android.livesdk.interactivity.api.chatchannel.message.f) r21;
        r26.append(r27.getMessageId());
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.f(r25, r26.toString());
        f2.c(r27.getToast(), 0);
        tryStopFetchMessage();
        notifyListener(new ChatChannelManager$onMessage$4$1(r25));
        return;
    L184:
        return;
    L63:
        if ((r21 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.l) == false) goto L129;
        int r28 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.message.l r29 = (com.bytedance.android.livesdk.interactivity.api.chatchannel.message.l) r21;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.l(r29.G(), false);
        RoomChannelInfo r30 = r29.G();
        if (r30 == null) goto L186;
        long r31 = r30.getChannelId();
        Iterator<T> r33 = this.channelList.iterator();
    L68:
        if (r33.hasNext() == false) goto L77;
        Object r34 = r33.next();
        com.bytedance.android.livesdk.interactivity.chatchannel.manager.c r35 = (com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r34;
        if (r35.p == r31) goto L72;
    L74:
        boolean r36 = false;
    L75:
        if (r36 == false) goto L68;
        r4 = r34;
        goto L77
    L72:
        if (r35.r != 2) goto L74;
        r36 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
    L77:
        com.bytedance.android.livesdk.interactivity.chatchannel.manager.c r37 = (com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r4;
        if (r37 != null) goto L80;
    L82:
        final s22.a r38 = createAndAddRoomChannel$default(this, r30, DEFAULT_CHANNEL_CREATE_ENABLE_STATE, 0, false, false, 28, null);
        if (r38 != null) goto L85;
        return;
    L85:
        if (r38.y() == 2) goto L87;
    L95:
        notifyListener(new ChatChannelManager$onMessage$5$4(r38));
        if (this.channelList.size() != 1) goto L99;
        changeCurrentChannel(r38.getChannelId());
    L99:
        if (r38.y() == 2) goto L101;
        long r39 = r38.getChannelId();
        long r110 = r38.y();
        boolean r111 = ((Boolean) r38.v().a).booleanValue();
        FansChannelCreateInfo r40 = r38.C();
        if (r40 == null) goto L121;
        r10 = r40.getFansChannelType();
    L121:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.j r41 = new com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.j(r39, r110, r111, r10, r38.f());
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r43 = ChatChannelUtils.g(this.roomContext);
        if (r43 == null) goto L126;
        PublishSubject<com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.j> r44 = r43.getRedDotStatus();
        if (r44 == null) goto L126;
        r44.onNext(r41);
    L126:
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.e(r38);
    L127:
        tryStartFetchMessage();
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.i();
        return;
    L101:
        if (((Boolean) r38.v().a).booleanValue() == false) goto L104;
        doAnchorFansChannelAfterProcess(r38);
        goto L127
    L104:
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.c(this.roomContext, this.dataCenter) == false) goto L116;
        s22.a r45 = this._currentChannel;
        if (r45 == null) goto L116;
        if (r45.getChannelId() != r38.getChannelId()) goto L116;
        String r112 = String.valueOf(r38.y());
        boolean r113 = ((Boolean) r38.v().a).booleanValue();
        FansChannelCreateInfo r46 = r38.C();
        if (r46 == null) goto L113;
        String r47 = String.valueOf(r46.getFansChannelType());
        if (r47 == null) goto L113;
    L114:
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.i.a(false, "join", r112, r113, r47, String.valueOf(r38.getChannelId()), String.valueOf(r38.f()), r38.s(), r38.x());
    L113:
        r47 = "0";
    L116:
        if (this.alreadApplyChannelIdSet.contains(Long.valueOf(r38.getChannelId())) == false) goto L127;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.b(r38, "unqualified");
        goto L127
    L87:
        if (((Boolean) r38.v().a).booleanValue() == true) goto L95;
        notifyListener(new ChatChannelManager$onMessage$5$3(r38));
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.c(this.roomContext, this.dataCenter) == false) goto L99;
        s22.a r48 = this._currentChannel;
        if (r48 == null) goto L99;
        if (r48.getChannelId() != r38.getChannelId()) goto L99;
        changeCurrentChannel(r38.getChannelId());
        goto L99
    L80:
        if (r37.y == true) goto L82;
        removeRoomChannel(r37.p, false);
        goto L82
    L186:
        return;
    L129:
        if ((r21 instanceof RoomAnchorFansChannelMessage) == false) goto L135;
        if (((Boolean) this.roomContext.isAnchor().getValue()).booleanValue() == false) goto L133;
        processWRDSMessageForAnchor((RoomAnchorFansChannelMessage) r21);
        return;
    L133:
        processWRDSMessageForAudience((RoomAnchorFansChannelMessage) r21);
        return;
    L135:
        if ((r21 instanceof com.bytedance.android.livesdk.interactivity.api.chatchannel.message.e) == false) goto L191;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.message.e r49 = (com.bytedance.android.livesdk.interactivity.api.chatchannel.message.e) r21;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.message.d r50 = r49.G();
        if (r50 != null) goto L139;
        return;
    L139:
        Iterator<T> r51 = this.channelList.iterator();
    L141:
        if (r51.hasNext() == false) goto L152;
        Object r53 = r51.next();
        long r54 = ((com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r53).p;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.message.d r55 = r49.G();
        if (r55 == null) goto L149;
        CommonMessageData r56 = ((BaseMessage) r55).baseMessage;
        if (r56 == null) goto L149;
        if (r54 != r56.channelId) goto L149;
        boolean r57 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
    L150:
        if (r57 == false) goto L141;
        r4 = r53;
    L149:
        r57 = false;
    L152:
        com.bytedance.android.livesdk.interactivity.chatchannel.manager.c r58 = (com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r4;
        if (r58 != null) goto L155;
        return;
    L155:
        com.bytedance.android.livesdk.interactivity.service.messagelist.c r59 = g62.a.a(r50);
        if (r59 == null) goto L192;
        r58.c.f(r59);
        return;
    L192:
        return;
    }

    @Override // s22.e
    public void onRoomDestroy(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        release("onRoomDestroy");
    }

    @Override // s22.e
    public void quitChannel(long r14) {
        s22.a r7 = getChannel(r14);
        if (r7 != null) goto L5;
        return;
    L5:
        long r8 = System.currentTimeMillis();
        RxUtilKt.c(this.roomChannelApi.quitChannel(this.roomId, r14).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new p(this, r14, r8, r7), new q(this, r14, r7, r8)), this.compositeDisposable);
    }

    @Override // s22.e
    public void removeListener(s22.e.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.listenerList.remove(r2);
    }

    @Override // s22.e
    public s22.a createChannel(RoomChannelInfo r11) {
        Intrinsics.checkNotNullParameter(r11, "roomChannelInfo");
        final s22.a r13 = createAndAddRoomChannel$default(this, r11, DEFAULT_CHANNEL_CREATE_ENABLE_STATE, System.currentTimeMillis(), false, false, 24, null);
        if (r13 == null) goto L6;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.e(r13);
        trySwitchToChannelPage(r13.getChannelId(), PublicScreenAreaPageChangeSource.ChannelCreate);
        notifyListener(new ChatChannelManager$createChannel$3$1(r13));
        changeCurrentChannel(r13.getChannelId());
        tryStartFetchMessage();
        return r13;
    L6:
        return null;
    }

    public static final /* synthetic */ void access$notifyListener(ChatChannelManager r0, Function1 r1) {
        r0.notifyListener(r1);
    }

    public static final /* synthetic */ void access$setFansClub$p(ChatChannelManager r0, boolean r1) {
        r0.isFansClub = r1;
    }

    public static final /* synthetic */ void access$setSubscribe$p(ChatChannelManager r0, boolean r1) {
        r0.isSubscribe = r1;
    }

    public static final /* synthetic */ void access$showPromptToast(ChatChannelManager r0, Throwable r1) {
        r0.showPromptToast(r1);
    }

    private final void initRoomChannelData(RoomChannelData r10, String r11) {
        long r0 = this.roomId;
        List r2 = r10.getChannelList();
        if (r2 == null) goto L5;
        int r3 = r2.size();
    L6:
        boolean r4 = r10.getCanCreate();
        int r5 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.a;
        Intrinsics.checkNotNullParameter(r11, "source");
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("init room channel, roomId is " + r0 + ", channelSize is " + r3 + ", createState is " + r4 + ",  source is " + r11);
        this.enableCreateChannel = r10.getCanCreate();
        List r13 = r10.getChannelList();
        if (r13 != null) goto L9;
        return;
    L9:
        if ((r13.isEmpty() ^ DEFAULT_CHANNEL_CREATE_ENABLE_STATE) == true) goto L12;
        r13 = null;
    L12:
        if (r13 == null) goto L37;
        Iterator r14 = r13.iterator();
    L15:
        if (r14.hasNext() == false) goto L24;
        s22.a r15 = createAndAddRoomChannel$default(this, (RoomChannelInfo) r14.next(), false, 0, false, false, 30, null);
        if (r15 == null) goto L15;
        if (r15.y() != 2) goto L15;
        if (((Boolean) r15.v().a).booleanValue() == true) goto L15;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.j(r15);
        goto L15
    L24:
        if ((this.channelList.isEmpty() ^ DEFAULT_CHANNEL_CREATE_ENABLE_STATE) == false) goto L38;
        notifyListener(new ChatChannelManager$initRoomChannelData$$inlined$let$lambda$1(this));
        tryStartFetchMessage();
        changeCurrentChannel(((com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) CollectionsKt.first(this.channelList)).p);
        return;
    L38:
        return;
    L37:
        return;
    L5:
        r3 = 0;
        goto L6
    }

    private final s22.a refreshRoomChannel(RoomChannelInfo r9, long r10) {
        if (r9 != null) goto L7;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.i(0, "info empty");
        return null;
    L7:
        if (r9.getChannelId() > 0) goto L10;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.i(r9.getChannelId(), "info error");
        return null;
    L10:
        Iterator<T> r11 = this.channelList.iterator();
    L12:
        if (r11.hasNext() == false) goto L19;
        Object r13 = r11.next();
        if (((com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r13).p != r9.getChannelId()) goto L16;
        boolean r1 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
    L17:
        if (r1 == false) goto L12;
    L20:
        com.bytedance.android.livesdk.interactivity.chatchannel.manager.c r14 = (com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r13;
        if (r14 == null) goto L24;
        Intrinsics.checkNotNullParameter(r9, "info");
        r14.E(r9.getChannelName(), r9.getAvatarThumb(), r9.getMemberCount(), r9.getOwner(), r9.getTopUserList());
        return r14;
    L24:
        return null;
    L16:
        r1 = false;
        goto L17
    L19:
        r13 = null;
        goto L20
    }

    private final s22.a removeRoomChannel(long r17, boolean r19) {
        Iterator<T> r3 = this.channelList.iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        Object r4 = r3.next();
        if (((com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r4).p != r17) goto L8;
        boolean r7 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
    L9:
        if (r7 == false) goto L4;
    L12:
        com.bytedance.android.livesdk.interactivity.chatchannel.manager.c r5 = (com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r4;
        if (r5 != null) goto L16;
        int r6 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.a;
        Intrinsics.checkNotNullParameter("unknown channelId", "reason");
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("remove item failed, channelId is " + r17 + ", reason is unknown channelId");
        return null;
    L16:
        int r1 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
        Intrinsics.checkNotNullParameter(r5, "chatChannel");
        LinkedHashMap r13 = new LinkedHashMap();
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.j(r13, r5);
        Unit r2 = Unit.INSTANCE;
        new com.bytedance.android.livesdk.interactivity.api.monitor.c(0, null, 0, r13, 7).b(InteractivityTraceMonitor.Event.ChatChannelDelete);
        this.channelList.remove(r5);
        r5.D(this);
        Iterator<T> r8 = this.channelList.iterator();
    L18:
        if (r8.hasNext() == false) goto L22;
        Object r9 = r8.next();
        if (((com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r9).z == false) goto L18;
    L23:
        if (r9 != null) goto L28;
        vlc.d r10 = (vlc.d) this.roomContext.getMessageManager().getValue();
        if (r10 == null) goto L27;
        r10.removeMessageListener(InteractivityMessageType.RoomChannelEncrypt.getMessageIntType(), this);
    L27:
        this.isReceiveEncryptMessage = false;
    L28:
        RoomChannelIMManager r11 = this.channelMessageManager;
        long r14 = r5.p;
        r11.b.remove(Long.valueOf(r14));
        c62.b r15 = r11.d;
        c62.b.c r16 = (c62.b.c) ((LinkedHashMap) r15.a).get(Long.valueOf(r14));
        if (r16 == null) goto L31;
        r16.a.clear();
        r16.b.clear();
    L31:
        r15.a.remove(Long.valueOf(r14));
        r11.a.c(r11.b);
        if (r19 == false) goto L44;
        s22.a r18 = getLatestChannel();
        if (r18 == null) goto L43;
        changeCurrentChannel(r18.getChannelId());
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.c(this.roomContext, this.dataCenter) == false) goto L44;
        String r20 = String.valueOf(r18.y());
        boolean r110 = ((Boolean) r18.v().a).booleanValue();
        FansChannelCreateInfo r21 = r18.C();
        if (r21 == null) goto L41;
        String r23 = String.valueOf(r21.getFansChannelType());
        if (r23 == null) goto L41;
    L42:
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.i.a(false, "quit", r20, r110, r23, String.valueOf(r18.getChannelId()), String.valueOf(r18.f()), r18.s(), r18.x());
    L41:
        r23 = "0";
        goto L42
    L43:
        changeCurrentChannel(0);
    L44:
        updateChatChannelLogFilter(null);
        return r5;
    L22:
        r9 = null;
        goto L23
    L8:
        r7 = false;
        goto L9
    L11:
        r4 = null;
        goto L12
    }

    @Override // s22.e
    public void notifyChannelUnreadCountChanged(final s22.a r2, final int r3) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        notifyListener(new C03081(r2, r3));
    }

    @Override // s22.e
    public void notifyInviteResult(long r7, List<? extends ChannelInviteMessageItem> r9) {
        Intrinsics.checkNotNullParameter(r9, "inviteItems");
        String r10 = GsonHelper.get().toJson(r9);     // Catch: Exception -> L5
    L7:
        String r5 = r10;
        if (r5 != null) goto L10;
        return;
    L10:
        RxUtilKt.c(this.roomChannelApi.inviteMessage(this.roomId, r7, r5).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(l.a, m.a), this.compositeDisposable);
        return;
    L5:
        e = move-exception;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("notifyInviteResult error, message is " + e.getMessage());
        r10 = null;
        goto L7
    }

    @Override // s22.e
    public void onRoomEnter(RoomChannelData r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "source");
        if (r5 == null) goto L5;
        initRoomChannelData(r5, r6);
    L5:
        v0 r7 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c.a;
        RoomContext r8 = this.roomContext;
        Intrinsics.checkNotNullParameter(r8, "roomContext");
        boolean r0 = ((Boolean) r8.isAnchor().getValue()).booleanValue() ^ DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
        boolean r2 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c.e.e();
        boolean r3 = ((Room) r8.getRoom().getValue()).getRoomAuthStatus().isEnableAnchorChannel();
        boolean r9 = ((Room) r8.getRoom().getValue()).getRoomAuthStatus().isEnableRoomChannel();
        if (r0 == false) goto L11;
        if (r2 == false) goto L11;
        if (r3 == false) goto L11;
        if (r9 == false) goto L11;
        boolean r10 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
    L12:
        if (r10 == false) goto L71;
        Map r11 = null;
        if (r5 == null) goto L29;
        Map r1 = r5.getUserFansGroupMap();
        if (r1 == null) goto L29;
        if ((r1.isEmpty() ^ DEFAULT_CHANNEL_CREATE_ENABLE_STATE) == true) goto L21;
        r1 = null;
    L21:
        if (r1 == null) goto L29;
        Iterator r4 = r1.entrySet().iterator();
    L24:
        if (r4.hasNext() == false) goto L29;
        Map.Entry r13 = (Map.Entry) r4.next();
        if (((Boolean) r13.getValue()).booleanValue() != true) goto L28;
        this.alreadInfansGroupIdSet.add((Long) r13.getKey());
    L28:
        processFansGroupChannel();
    L29:
        if (r5 == null) goto L43;
        Map r14 = r5.getUserChannelApplyMap();
        if (r14 == null) goto L43;
        if ((r14.isEmpty() ^ DEFAULT_CHANNEL_CREATE_ENABLE_STATE) == true) goto L36;
        r14 = null;
    L36:
        if (r14 == null) goto L43;
        Iterator r15 = r14.entrySet().iterator();
    L39:
        if (r15.hasNext() == false) goto L43;
        Map.Entry r16 = (Map.Entry) r15.next();
        if (((Boolean) r16.getValue()).booleanValue() != true) goto L39;
        this.alreadApplyChannelIdSet.add((Long) r16.getKey());
    L43:
        if (r5 == null) goto L56;
        Map r17 = r5.getUserInFansClubMap();
        if (r17 == null) goto L56;
        if ((r17.isEmpty() ^ DEFAULT_CHANNEL_CREATE_ENABLE_STATE) == false) goto L49;
        r11 = r17;
    L49:
        if (r11 == null) goto L56;
        Iterator r18 = r11.entrySet().iterator();
    L52:
        if (r18.hasNext() == false) goto L56;
        Map.Entry r19 = (Map.Entry) r18.next();
        if (((Boolean) r19.getValue()).booleanValue() != true) goto L52;
        this.userInFansClubMap.add(String.valueOf(((Number) r19.getKey()).longValue()));
    L56:
        this.roomContext.getMessageManager().c(new AnonymousClass8(this));
        return;
    L71:
        return;
    L11:
        r10 = false;
        goto L12
    }

    @Override // s22.e
    public void recordChatChannelDialog(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.dialogHashMap.put(r2, r3);
    }

    @Override // s22.e
    public void trySwitchToChannelPage(long r3, PublicScreenAreaPageChangeSource r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r0 = ChatChannelUtils.f(this.roomContext);
        if (r0 == null) goto L5;
        r0.tryChangePage(PublicScreenAreaPageType.ChatChannel, r3, r5);
    L5:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r1 = ChatChannelUtils.g(this.roomContext);
        if (r1 == null) goto L9;
        r1.tryChangePage(PublicScreenAreaPageType.ChatChannel, r3, r5);
        return;
    }

    public static final /* synthetic */ void access$initRoomChannelData(ChatChannelManager r0, RoomChannelData r1, String r2) {
        r0.initRoomChannelData(r1, r2);
    }

    public static final /* synthetic */ s22.a access$removeRoomChannel(ChatChannelManager r0, long r1, boolean r3) {
        return r0.removeRoomChannel(r1, r3);
    }

    @Override // s22.e
    public Observable<Response<com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h>> getChannelUserList(long r8, int r10, int r11) {
        return this.roomChannelApi.getChannelUserList(this.roomId, r8, r10, r11);
    }

    @Override // s22.e
    public Observable<Response<Object>> kickOutChannel(long r9, String r11, String r13) {
        Intrinsics.checkNotNullParameter(r11, "userId");
        Intrinsics.checkNotNullParameter(r13, "secId");
        return this.roomChannelApi.kickOutChannel(this.roomId, r9, r11, r13);
    }

    @Override // s22.e
    public void updateSetting(long r16, boolean r18, boolean r19) {
        s22.a r8 = getChannel(r16);
        if (r8 != null) goto L5;
        return;
    L5:
        long r10 = System.currentTimeMillis();
        RxUtilKt.c(this.roomChannelApi.updateSetting(this.roomId, r16, r18, r19).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new r(r16, r18, r19, r8, r10), new s(this, r16, r18, r19, r8, r10)), this.compositeDisposable);
    }

    public ChatChannelManager(RoomContext r9, DataCenter r10, Context r11, s22.e.b r13) {
        Intrinsics.checkNotNullParameter(r9, "roomContext");
        Intrinsics.checkNotNullParameter(r10, "dataCenter");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r13, "config");
        this.roomContext = r9;
        this.dataCenter = r10;
        this.context = r11;
        this.config = r13;
        long r2 = ((Room) r9.getRoom().getValue()).getRoomId();
        this.roomId = r2;
        this.enableCreateChannel = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
        this.listenerList = new ArrayList();
        this.channelList = new ArrayList();
        this.dialogHashMap = new HashMap();
        this.currentChannel = new PropertyOwner(sh6.a.a);
        this.alreadInfansGroupIdSet = new LinkedHashSet();
        this.alreadApplyChannelIdSet = new LinkedHashSet();
        this.userInFansClubMap = new LinkedHashSet();
        this.channelBanSet = new LinkedHashSet();
        this.showGuideEntry = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c.g;
        this.enableMultiFansclubChannel = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.c.h;
        CompositeDisposable r5 = new CompositeDisposable();
        this.compositeDisposable = r5;
        r9.getMessageManager().c(new AnonymousClass1(this));
        RoomChannelIMManager r6 = new RoomChannelIMManager(r11, r2, ((Boolean) r9.isAnchor().getValue()).booleanValue());
        int r3 = InteractivityMessageType.RoomChannelDisband.getMessageIntType();
        Intrinsics.checkNotNullParameter(this, "listener");
        r6.f.addMessageListener(r3, this);
        int r4 = InteractivityMessageType.RoomChannelKickOut.getMessageIntType();
        Intrinsics.checkNotNullParameter(this, "listener");
        r6.f.addMessageListener(r4, this);
        Unit r7 = Unit.INSTANCE;
        this.channelMessageManager = r6;
        com.bytedance.android.livesdk.interactivity.chatchannel.manager.r r8 = new com.bytedance.android.livesdk.interactivity.chatchannel.manager.r();
        this.channelToolbarManager = r8;
        Intrinsics.checkNotNullParameter(r9, "roomContext");
        Intrinsics.checkNotNullParameter(r10, "dataCenter");
        Intrinsics.checkNotNullParameter(this, "manager");
        r8.a = r9;
        r8.b = r10;
        r8.c = this;
        r8.d = new CompositeDisposable();
        ChatChannelWidgetManager r1 = new ChatChannelWidgetManager();
        this.widgetManager = r1;
        r1.b(r9, r10, this, r11);
        com.bytedance.android.livesdk.interactivity.chatchannel.manager.n r14 = new com.bytedance.android.livesdk.interactivity.chatchannel.manager.n();
        this.emojiManager = r14;
        Intrinsics.checkNotNullParameter(this, "manager");
        if (getConfig().g == true) goto L5;
        r14.d = false;
    L11:
        ChatChannelAnimManager r0 = new ChatChannelAnimManager();
        this.animManager = r0;
        ChatChannelAnimManager.e("onManagerInit");
        r0.d = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
        if (r13.g == false) goto L29;
        final ChatChannelGreetingManager r15 = new ChatChannelGreetingManager(this, r10, r9, r11);
        ChatChannelUtils.m(r15.s, new ChatChannelGreetingManager$onManagerInit$1(r15));
        com.bytedance.live.datacontext.j<s22.e> r16 = ChatChannelUtils.n(r15.t);
        if (r16 == null) goto L18;
        Disposable r17 = n32.a.a(r16, new ChatChannelGreetingManager$onManagerInit$2(r15));
        if (r17 == null) goto L18;
        RxUtilKt.c(r17, r15.o);
    L18:
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.p.a(r15.r.getCurrentChannel(), new ChatChannelGreetingManager$onManagerInit$3(r15));
        if (PadConfigUtils.c() == true) goto L21;
    L30:
        this.greetingManager = r15;
        this.roomChannelApi = (RoomChannelRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomChannelRetrofitApi.class);
        com.bytedance.android.live.profit.fansclub.o r18 = yt0.c.c();
        if (r18 == null) goto L37;
        com.bytedance.live.datacontext.m r19 = r18.getProfile();
        if (r19 == null) goto L37;
        Disposable r20 = i80.a.a(r19, new AnonymousClass4(this));
        if (r20 == null) goto L37;
        RxUtilKt.c(r20, r5);
    L37:
        com.bytedance.android.live.profit.vip.e r21 = yt0.c.l();
        if (r21 == null) goto L45;
        com.bytedance.live.datacontext.m r23 = r21.getSubscribeInfo();
        if (r23 == null) goto L46;
        Disposable r24 = i80.a.a(r23, new AnonymousClass5(this));
        if (r24 == null) goto L47;
        RxUtilKt.c(r24, r5);
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L21:
        if (r15.r.getConfig().a != ContainerType.MultiTab) goto L30;
        RoomContext r25 = r15.t;
        if (r25 == null) goto L30;
        com.bytedance.live.datacontext.n r26 = r25.getPadOrientation();
        if (r26 == null) goto L30;
        Disposable r27 = i80.a.b(r26, new ChatChannelGreetingManager$onManagerInit$4(r15));
        if (r27 == null) goto L30;
        RxUtilKt.c(r27, r15.o);
        goto L30
    L29:
        r15 = null;
        goto L30
    L5:
        List<String> r28 = getConfig().h;
        if (r28.size() <= 4) goto L9;
        r28 = r28.subList(0, 4);
    L9:
        if ((r28.isEmpty() ^ DEFAULT_CHANNEL_CREATE_ENABLE_STATE) == false) goto L11;
        AtomicInteger r29 = new AtomicInteger(0);
        r14.a = Observable.create(new com.bytedance.android.livesdk.interactivity.chatchannel.manager.i(r28)).retryWhen(new com.bytedance.android.livesdk.interactivity.chatchannel.manager.k(r29)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.interactivity.chatchannel.manager.l(r14), com.bytedance.android.livesdk.interactivity.chatchannel.manager.m.a);
        goto L11
    }

    @Override // s22.e
    public void applyAnchorFansChannel(long r3, Long r5, Long r6, Long r7) {
        if (this.alreadApplyChannelIdSet.contains(Long.valueOf(r3)) == false) goto L5;
        return;
    L5:
        RxUtilKt.c(this.roomChannelApi.applyChannel(r5, Long.valueOf(r3), r6, r7).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r3), c.a), this.compositeDisposable);
    }

    @Override // s22.e
    public void joinAnchorFansChannel(long r20, long r23, Long r24, Long r25) {
        long r4 = System.currentTimeMillis();
        RxUtilKt.c(RoomChannelRetrofitApi.a.a(this.roomChannelApi, this.roomId, 0, Long.valueOf(r20), Long.valueOf(r23), r24, r25, 2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this, r20, r4), new i(this, r20, r23, r24, r25)), this.compositeDisposable);
    }

    private final s22.a createAndAddRoomChannel(RoomChannelInfo r39, boolean r40, long r41, boolean r43, boolean r44) {
        long r2 = 0;
        if (r39 != null) goto L7;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.i(0, "info empty");
        return null;
    L7:
        if (r39.getChannelId() > 0) goto L10;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.i(r39.getChannelId(), "info error");
        return null;
    L10:
        Iterator<T> r5 = this.channelList.iterator();
    L12:
        if (r5.hasNext() == false) goto L19;
        Object r6 = r5.next();
        if (((com.bytedance.android.livesdk.interactivity.chatchannel.manager.c) r6).p != r39.getChannelId()) goto L16;
        boolean r9 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
    L17:
        if (r9 == false) goto L12;
    L20:
        if (r6 == null) goto L23;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.i(r39.getChannelId(), "repeat channelId");
        return null;
    L23:
        String r7 = com.bytedance.android.livesdk.interactivity.chatchannel.manager.c.E;
        Intrinsics.checkNotNullParameter(r39, "channelInfo");
        long r10 = r39.getChannelId();
        String r8 = r39.getToken();
        if (r8 != null) goto L26;
        r8 = BuildConfig.FLAVOR;
    L26:
        String r13 = r8;
        String r11 = r39.getChannelName();
        if (r11 != null) goto L29;
    L33:
        r11 = com.bytedance.android.livesdk.interactivity.chatchannel.manager.c.E;
    L34:
        String r29 = r11;
        List r14 = r39.getAvatarThumb();
        if (r14 != null) goto L37;
    L44:
        r14 = new ArrayList();
    L45:
        List r30 = r14;
        Long r15 = Long.valueOf(r39.getMaxMemberCount());
        if (r15.longValue() < 0) goto L48;
        boolean r16 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
    L49:
        if (r16 == true) goto L52;
        r15 = null;
    L52:
        if (r15 == null) goto L54;
        long r17 = r15.longValue();
    L55:
        long r18 = r17;
        RoomChannelRtcExtInfo r19 = r39.getRtcInfo();
        if (r19 != null) goto L58;
    L67:
        RoomChannelRtcExtInfo r27 = null;
    L68:
        r39.getRtcInfo();
        boolean r28 = r39.isOwner();
        long r33 = r39.getMemberCount();
        List r4 = r39.getTopUserList();
        if (r4 != null) goto L71;
        r4 = new ArrayList();
    L71:
        List r34 = r4;
        User r20 = r39.getOwner();
        if (r20 != null) goto L74;
        r20 = new User();
    L74:
        User r35 = r20;
        SecretChatInfo r21 = r39.getSecretChatInfo();
        long r110 = r39.getCreateType();
        Long r23 = r39.getChannelState();
        if (r23 == null) goto L77;
        r2 = r23.longValue();
    L77:
        long r111 = r2;
        long r112 = r39.getCreateAppId();
        User r26 = r39.getGroupLiveMember();
        if (r39.getCreateType() != 1) goto L84;
        SecretChatInfo r3 = r39.getSecretChatInfo();
        if (r3 == null) goto L84;
        if (r3.getStatus() != 1) goto L84;
        boolean r36 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
    L85:
        com.bytedance.android.livesdk.interactivity.chatchannel.manager.c r1 = new com.bytedance.android.livesdk.interactivity.chatchannel.manager.c(r10, r13, r18, r110, r111, r112, r21, r39.getFansChannelCreateInfo(), r39.getDisableInvite(), r43, r44, r26, r27, r28, r29, r30, r39.getInviteDisableToast(), r33, r34, r35, r36, r39.getEnableAnnouncement());
        int r24 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
        Intrinsics.checkNotNullParameter(r1, "channel");
        LinkedHashMap r113 = new LinkedHashMap();
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.j(r113, r1);
        Unit r25 = Unit.INSTANCE;
        com.bytedance.android.livesdk.interactivity.api.monitor.c r31 = new com.bytedance.android.livesdk.interactivity.api.monitor.c(0, null, 0, r113, 7);
        r31.a(InteractivityMonitor.Event.ChatChannelCreate);
        r31.b(InteractivityTraceMonitor.Event.ChatChannelCreate);
        if (r40 == false) goto L88;
        ListProtector.add(this.channelList, 0, r1);
    L89:
        updateChatChannelLogFilter(r1);
        if (r43 == true) goto L92;
        return r1;
    L92:
        Intrinsics.checkNotNullParameter(this, "manager");
        int r37 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.a;
        Intrinsics.checkNotNullParameter(r1, "channel");
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("add item success, channelInfo is " + com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.a(r1));
        r1.a = this;
        s22.d r38 = mo555getIMManager();
        r38.e(r1.p, r1);
        r38.c(r1.p, InteractivityMessageType.RoomChannelRole.getMessageIntType(), r1);
        r38.c(r1.p, InteractivityMessageType.RoomChannelAccess.getMessageIntType(), r1);
        r38.c(r1.p, InteractivityMessageType.RoomChannelSystem.getMessageIntType(), r1);
        r38.c(r1.p, InteractivityMessageType.RoomChannelChat.getMessageIntType(), r1);
        r38.c(r1.p, InteractivityMessageType.RoomChannelEmojiChat.getMessageIntType(), r1);
        r38.c(r1.p, InteractivityMessageType.RoomChannelState.getMessageIntType(), r1);
        r38.c(r1.p, InteractivityMessageType.RoomChannelSocialGroup.getMessageIntType(), r1);
        r38.c(r1.p, InteractivityMessageType.RoomChannelGift.getMessageIntType(), r1);
        r38.c(r1.p, InteractivityMessageType.RoomChannelSecretChatStatus.getMessageIntType(), r1);
        if (getConfig().g == false) goto L95;
        r38.c(r1.p, InteractivityMessageType.RoomChannelInteractivityEmojiChat.getMessageIntType(), r1);
    L95:
        r1.o = (RoomChannelSyncModel) mo555getIMManager().d(r1.p, ChatChannel$onAdded$2.INSTANCE);
        r1.m.a(Boolean.valueOf(r1.w()));
        if (r1.x == true) goto L106;
        RoomChannelSyncModel r45 = r1.o;
        if (r45 == null) goto L106;
        dc2.c<RoomChannelSettingsSyncData> r46 = r45.getSetting();
        if (r46 == null) goto L106;
        Observable<RoomChannelSettingsSyncData> r47 = r46.d;
        if (r47 == null) goto L106;
        Disposable r48 = r47.subscribe(new com.bytedance.android.livesdk.interactivity.chatchannel.manager.d(r1));
        if (r48 == null) goto L106;
        RxUtilKt.c(r48, r1.d);
    L106:
        PublishSubject r49 = r1.b.b();
        if (r49 == null) goto L111;
        Disposable r50 = r49.subscribe(new com.bytedance.android.livesdk.interactivity.chatchannel.manager.e(r1, this));
        if (r50 == null) goto L111;
        RxUtilKt.c(r50, r1.d);
    L111:
        RoomChannelIMManager r51 = this.channelMessageManager;
        long r53 = r1.p;
        r51.b.add(Long.valueOf(r53));
        c62.a r54 = r51.e;
        LimitQueue r55 = r54.a;
        ArrayList r56 = new ArrayList();
        Iterator<E> r57 = r55.iterator();
    L113:
        if (r57.hasNext() == false) goto L120;
        Object r114 = r57.next();
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.o.b((tlc.d) r114) != r53) goto L117;
        boolean r115 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
    L118:
        if (r115 == false) goto L113;
        r56.add(r114);
        goto L113
    L117:
        r115 = false;
        goto L118
    L120:
        List r58 = CollectionsKt.toList(r56);
        r54.a.removeAll(r58);
        Iterator r59 = r58.iterator();
    L122:
        if (r59.hasNext() == false) goto L124;
        r54.c.invoke((tlc.d) r59.next());
        goto L122
    L124:
        r51.a.c(r51.b);
        return r1;
    L88:
        this.channelList.add(r1);
    L84:
        r36 = false;
        goto L85
    L58:
        if (TextUtils.isEmpty(r19.getLinkMicIdStr()) == false) goto L60;
    L64:
        boolean r60 = false;
    L65:
        if (r60 == false) goto L67;
        r27 = r19;
        goto L68
    L60:
        if (TextUtils.isEmpty(r19.getRtcExtInfo()) == true) goto L64;
        if (TextUtils.isEmpty(r19.getRtcStrategy()) == true) goto L64;
        r60 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
        goto L65
    L54:
        r17 = 500;
        goto L55
    L48:
        r16 = false;
        goto L49
    L37:
        if (r14.size() <= 0) goto L39;
        boolean r61 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
    L40:
        if (r61 == true) goto L43;
        r14 = null;
    L43:
        if (r14 != null) goto L45;
    L39:
        r61 = false;
        goto L40
    L29:
        if ((TextUtils.isEmpty(r11) ^ DEFAULT_CHANNEL_CREATE_ENABLE_STATE) == true) goto L32;
        r11 = null;
    L32:
        if (r11 != null) goto L34;
    L16:
        r9 = false;
        goto L17
    L19:
        r6 = null;
        goto L20
    }

    public static /* synthetic */ s22.a refreshRoomChannel$default(ChatChannelManager r0, RoomChannelInfo r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.refreshRoomChannel(r1, r2);
    }

    public static /* synthetic */ s22.a removeRoomChannel$default(ChatChannelManager r0, long r1, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r3 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
    L6:
        return r0.removeRoomChannel(r1, r3);
    }

    public static /* synthetic */ s22.a createAndAddRoomChannel$default(ChatChannelManager r6, RoomChannelInfo r7, boolean r8, long r9, boolean r11, boolean r13, int r14, Object r15) {
        boolean r1 = false;
        if ((r14 & 2) == 0) goto L5;
        boolean r0 = false;
    L7:
        if ((r14 & 4) == 0) goto L9;
        long r2 = 0;
    L11:
        if ((r14 & 8) == 0) goto L13;
        boolean r4 = DEFAULT_CHANNEL_CREATE_ENABLE_STATE;
    L15:
        if ((r14 & 16) != 0) goto L19;
        r1 = r13;
    L19:
        return r6.createAndAddRoomChannel(r7, r0, r2, r4, r1);
    L13:
        r4 = r11;
        goto L15
    L9:
        r2 = r9;
        goto L11
    L5:
        r0 = r8;
        goto L7
    }
}
