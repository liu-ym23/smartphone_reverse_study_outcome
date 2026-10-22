package com.bytedance.android.live.browser;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.service.network.IAnnieNetworkService;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.browser.jsbridge.ApiHookImpl;
import com.bytedance.android.live.browser.service.AnnieExternalServiceImpl;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.i2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.lynx.api.Jsb2MethodFinder;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.live.platformplayer.model.LivePanelType;
import com.bytedance.android.live.platformplayer.panel.StreamAutoAdapterService;
import com.bytedance.android.live.room.api.panel.PanelName;
import com.bytedance.android.live.schema.api.WebcastRedirect;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.live.schema.vo.WebHybridParamVo;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.depend.HostBoeParams;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.config.d51;
import com.bytedance.android.livesdk.config.iy0;
import com.bytedance.android.livesdk.config.jy0;
import com.bytedance.android.livesdk.config.ky0;
import com.bytedance.android.livesdk.config.ly0;
import com.bytedance.android.livesdk.config.m50;
import com.bytedance.android.livesdk.config.o70;
import com.bytedance.android.livesdk.config.xk0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.IDialogListener;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.base.ILiveBrowserFragment;
import com.bytedance.android.livesdkapi.config.TTLiveWebOfflineConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.android.livesdkapi.jsb.IExternalBrowserService;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.performance.PerformanceEventKitUtil;
import com.bytedance.android.livesdkapi.service.IFloatWindowDegradeManager;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxView;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dagger.internal.DoubleCheck;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000ì\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0017\u0018\u0000 \u008e\u00022\u00020\u0001:\u0004\u008f\u0002\u0090\u0002B\t¢\u0006\u0006\b\u008c\u0002\u0010\u008d\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J4\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J4\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bH\u0016J*\u0010!\u001a\u00020 2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J\u0012\u0010$\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010%\u001a\u00020 H\u0016J\u0010\u0010&\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\u001e\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020(\u0018\u00010'2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\u0012\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\u0010\u0010-\u001a\u00020,2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\u0010\u0010.\u001a\u00020,2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J$\u00101\u001a\u00020,2\u0006\u0010\u001e\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u00010\u000b2\b\u00100\u001a\u0004\u0018\u00010*H\u0016J\u0010\u00102\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J$\u00107\u001a\u0004\u0018\u0001062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u000b2\b\u00105\u001a\u0004\u0018\u000104H\u0016J\u0012\u00108\u001a\u0004\u0018\u00010,2\u0006\u00103\u001a\u00020\u000bH\u0016J\u0010\u0010:\u001a\u0002092\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010<\u001a\u00020;2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\u0010\u0010=\u001a\u0002092\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010A\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010@\"\b\b\u0000\u0010?*\u00020>H\u0016J\u001a\u0010B\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010@\"\b\b\u0000\u0010?*\u00020>H\u0016J\u0010\u0010C\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J%\u0010E\u001a\u00020 \"\u0004\b\u0000\u0010?2\u0006\u0010D\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\bE\u0010FJ\b\u0010H\u001a\u00020GH\u0016J\u0016\u0010L\u001a\b\u0012\u0004\u0012\u00020 0K2\u0006\u0010J\u001a\u00020IH\u0016J\u0018\u0010N\u001a\u00020 2\u0006\u0010M\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020*H\u0016J\u000e\u0010Q\u001a\b\u0012\u0004\u0012\u00020P0OH\u0016J.\u0010S\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010R\u001a\u00020\u000b2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0'H\u0016J\b\u0010T\u001a\u00020 H\u0016J\u0018\u0010W\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010V\u001a\u00020UH\u0016J\u0012\u0010Y\u001a\u00020 2\b\u0010X\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010Z\u001a\b\u0012\u0004\u0012\u00020(0OH\u0016J\u0010\u0010[\u001a\u0002092\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010]\u001a\u00020\\2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0016\u0010_\u001a\b\u0012\u0004\u0012\u00020^0K2\u0006\u0010M\u001a\u00020\u000bH\u0016J\u0010\u0010`\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\u0010\u0010a\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\u0018\u0010d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010c\u001a\u00020bH\u0016J\u0018\u0010h\u001a\u00020g2\u0006\u0010#\u001a\u00020\"2\u0006\u0010f\u001a\u00020eH\u0016J\b\u0010i\u001a\u00020 H\u0016J\b\u0010j\u001a\u00020 H\u0016J\b\u0010k\u001a\u00020\u0004H\u0016J\u000e\u0010m\u001a\b\u0012\u0004\u0012\u00020(0lH\u0016J\b\u0010n\u001a\u00020 H\u0016J\u0010\u0010o\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J0\u0010s\u001a\u00020 2&\u0010r\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020(0@0pj\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020(0@`qH\u0016J$\u0010t\u001a\u0004\u0018\u0001062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u00105\u001a\u0004\u0018\u000104H\u0016J.\u0010w\u001a\u0004\u0018\u0001062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u00105\u001a\u0004\u0018\u0001042\b\u0010v\u001a\u0004\u0018\u00010uH\u0016J8\u0010t\u001a\u0004\u0018\u0001062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u00105\u001a\u0004\u0018\u0001042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010v\u001a\u0004\u0018\u00010uH\u0016J,\u0010x\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u00105\u001a\u0004\u0018\u0001042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010y\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J$\u0010~\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010{\u001a\u0004\u0018\u00010z2\b\u0010}\u001a\u0004\u0018\u00010|H\u0016J$\u0010~\u001a\u0004\u0018\u00010\u007f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u00105\u001a\u0004\u0018\u000104H\u0016J-\u0010~\u001a\u0004\u0018\u00010\u007f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0007\u0010\u0080\u0001\u001a\u00020\u00132\b\u00105\u001a\u0004\u0018\u000104H\u0016J\u001c\u0010\u0082\u0001\u001a\u00030\u0081\u00012\u0006\u0010#\u001a\u00020\"2\b\u0010{\u001a\u0004\u0018\u00010zH\u0016J&\u0010\u0082\u0001\u001a\u00030\u0081\u00012\u0006\u0010#\u001a\u00020\"2\b\u0010{\u001a\u0004\u0018\u00010z2\b\u0010}\u001a\u0004\u0018\u00010|H\u0016J.\u0010\u0082\u0001\u001a\u00030\u0081\u00012\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u000b2\b\u0010{\u001a\u0004\u0018\u00010z2\b\u0010}\u001a\u0004\u0018\u00010|H\u0016J?\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00012\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u000b2\u0007\u0010\u0083\u0001\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J?\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00012\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0007\u0010\u0086\u0001\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J.\u0010~\u001a\u0004\u0018\u00010\u007f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u00105\u001a\u0004\u0018\u0001042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00012\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u00105\u001a\u0004\u0018\u000104H\u0016J0\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00012\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u00105\u001a\u0004\u0018\u0001042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J2\u0010\u008b\u0001\u001a\u00020 \"\u0004\b\u0000\u0010?2\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0089\u00012\b\u00100\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J/\u0010\u0091\u0001\u001a\u00020 \"\u0004\b\u0000\u0010?2\u001e\u0010\u0090\u0001\u001a\u0019\u0012\u0005\u0012\u00030\u008e\u0001\u0012\r\u0012\u000b\u0012\u0006\b\u0001\u0012\u00028\u00000\u008f\u00010\u008d\u0001H\u0016J8\u0010\u0097\u0001\u001a\u00020 2\b\u0010\u0093\u0001\u001a\u00030\u0092\u00012\u0006\u0010\u001e\u001a\u00020\u000b2\u0007\u0010\u0094\u0001\u001a\u00020\u000b2\u0007\u0010\u0095\u0001\u001a\u00020\u00132\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u000bH\u0016J@\u0010\u009c\u0001\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001042-\b\u0002\u0010\u009b\u0001\u001a&\u0012\u0019\u0012\u0017\u0018\u00010\u0092\u0001¢\u0006\u000f\b\u0098\u0001\u0012\n\b\u0099\u0001\u0012\u0005\b\b(\u009a\u0001\u0012\u0004\u0012\u00020 \u0018\u00010\u008d\u0001J\u001a\u0010\u009e\u0001\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u000b2\u0007\u0010\u009d\u0001\u001a\u00020\u000bH\u0016J5\u0010¤\u0001\u001a\u00020 2\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u000e\u0010¡\u0001\u001a\t\u0012\u0004\u0012\u00020\u000b0 \u00012\u0007\u0010¢\u0001\u001a\u00020\b2\u0007\u0010£\u0001\u001a\u00020\bJ\u0015\u0010§\u0001\u001a\u0005\u0018\u00010¦\u00012\u0007\u0010¥\u0001\u001a\u00020\u000bH\u0016J\t\u0010¨\u0001\u001a\u00020 H\u0016J&\u0010¬\u0001\u001a\u0004\u0018\u00010*2\u0007\u0010©\u0001\u001a\u00020\u000b2\u0007\u0010ª\u0001\u001a\u00020\u000b2\u0007\u0010«\u0001\u001a\u00020\u000bH\u0016J&\u0010\u00ad\u0001\u001a\u0004\u0018\u00010*2\u0007\u0010©\u0001\u001a\u00020\u000b2\u0007\u0010ª\u0001\u001a\u00020\u000b2\u0007\u0010«\u0001\u001a\u00020\u000bH\u0016J$\u0010®\u0001\u001a\u00020\b2\u0007\u0010©\u0001\u001a\u00020\u000b2\u0007\u0010ª\u0001\u001a\u00020\u000b2\u0007\u0010«\u0001\u001a\u00020\u000bH\u0016J\u0015\u0010±\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010°\u0001\u001a\u00030¯\u0001H\u0016J8\u0010³\u0001\u001a\u00020 2\b\u0010°\u0001\u001a\u00030¯\u00012#\u0010²\u0001\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\fH\u0016J\n\u0010µ\u0001\u001a\u00030´\u0001H\u0016J#\u0010º\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0005\u0012\u00030¹\u00010¸\u00012\n\u0010·\u0001\u001a\u0005\u0018\u00010¶\u0001H\u0016J\u001c\u0010½\u0001\u001a\u000b\u0012\u0002\b\u0003\u0012\u0002\b\u00030¼\u00012\b\u0010»\u0001\u001a\u00030\u008e\u0001H\u0016J\u001c\u0010¾\u0001\u001a\u000b\u0012\u0002\b\u0003\u0012\u0002\b\u00030¼\u00012\b\u0010»\u0001\u001a\u00030\u008e\u0001H\u0016J\u001c\u0010¿\u0001\u001a\u000b\u0012\u0002\b\u0003\u0012\u0002\b\u00030¼\u00012\b\u0010»\u0001\u001a\u00030\u008e\u0001H\u0016J\u001c\u0010À\u0001\u001a\u000b\u0012\u0002\b\u0003\u0012\u0002\b\u00030¼\u00012\b\u0010»\u0001\u001a\u00030\u008e\u0001H\u0016J\u000f\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00020(0OH\u0016J7\u0010È\u0001\u001a\u00020\b2\u0007\u0010Â\u0001\u001a\u00020\u007f2\u0007\u0010Ã\u0001\u001a\u00020\u000b2\b\u0010Å\u0001\u001a\u00030Ä\u00012\u0007\u0010Æ\u0001\u001a\u00020\u00132\u0007\u0010Ç\u0001\u001a\u00020\u0013H\u0016J$\u0010Ê\u0001\u001a\u00020 2\u0007\u0010Â\u0001\u001a\u00020\u007f2\u0007\u0010Ã\u0001\u001a\u00020\u000b2\u0007\u0010É\u0001\u001a\u00020\bH\u0016J\u001c\u0010Ì\u0001\u001a\u0005\u0018\u00010Ë\u00012\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J&\u0010Ì\u0001\u001a\u0005\u0018\u00010Ë\u00012\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J_\u0010Ó\u0001\u001a\u00020 2\n\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0092\u00012\t\u0010Í\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\t\u0010Î\u0001\u001a\u0004\u0018\u00010*2\t\u0010Ï\u0001\u001a\u0004\u0018\u00010*2\t\u0010Ð\u0001\u001a\u0004\u0018\u00010*2\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010*2\u0007\u0010Ò\u0001\u001a\u00020\u0013H\u0016J\n\u0010Õ\u0001\u001a\u00030Ô\u0001H\u0016J+\u0010Ø\u0001\u001a\u00020 2\b\u0010×\u0001\u001a\u00030Ö\u00012\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R8\u0010Û\u0001\u001a\u0005\u0018\u00010Ù\u00012\n\u0010Ú\u0001\u001a\u0005\u0018\u00010Ù\u00018\u0006@GX\u0086\u000e¢\u0006\u0018\n\u0006\bÛ\u0001\u0010Ü\u0001\u001a\u0006\bÝ\u0001\u0010Þ\u0001\"\u0006\bß\u0001\u0010à\u0001R4\u0010â\u0001\u001a\u00030á\u00012\b\u0010Ú\u0001\u001a\u00030á\u00018\u0006@GX\u0086.¢\u0006\u0018\n\u0006\bâ\u0001\u0010ã\u0001\u001a\u0006\bä\u0001\u0010å\u0001\"\u0006\bæ\u0001\u0010ç\u0001R4\u0010é\u0001\u001a\u00030è\u00012\b\u0010Ú\u0001\u001a\u00030è\u00018\u0006@GX\u0086.¢\u0006\u0018\n\u0006\bé\u0001\u0010ê\u0001\u001a\u0006\bë\u0001\u0010ì\u0001\"\u0006\bí\u0001\u0010î\u0001R4\u0010ð\u0001\u001a\u00030ï\u00012\b\u0010Ú\u0001\u001a\u00030ï\u00018\u0006@GX\u0086.¢\u0006\u0018\n\u0006\bð\u0001\u0010ñ\u0001\u001a\u0006\bò\u0001\u0010ó\u0001\"\u0006\bô\u0001\u0010õ\u0001RB\u0010ø\u0001\u001a\n\u0012\u0005\u0012\u00030÷\u00010ö\u00012\u000f\u0010Ú\u0001\u001a\n\u0012\u0005\u0012\u00030÷\u00010ö\u00018\u0006@GX\u0086.¢\u0006\u0018\n\u0006\bø\u0001\u0010ù\u0001\u001a\u0006\bú\u0001\u0010û\u0001\"\u0006\bü\u0001\u0010ý\u0001R\u0017\u0010þ\u0001\u001a\u00020\u00138\u0002X\u0082D¢\u0006\b\n\u0006\bþ\u0001\u0010ÿ\u0001R!\u0010\u0085\u0002\u001a\u00030\u0080\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0081\u0002\u0010\u0082\u0002\u001a\u0006\b\u0083\u0002\u0010\u0084\u0002R\u0019\u0010\u0086\u0002\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0002\u0010\u0087\u0002R \u0010\u008b\u0002\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0088\u0002\u0010\u0082\u0002\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002¨\u0006\u0091\u0002"}, d2 = {"Lcom/bytedance/android/live/browser/BrowserServiceImpl;", "Lcom/bytedance/android/live/browser/IBrowserService;", "Landroid/net/Uri;", "uri", "", "isShowAnimInLandscapeEnable", "Landroid/os/Bundle;", "bundle", "", "getUriEncodedStartTimeOrCurrent", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "uriAppendParams", "addLiveUISpecification", "isLocalTest", "Landroid/content/Context;", "context", "", "presetWidth", "Lcom/bytedance/android/live/browser/LynxThreadStrategy;", "threadStrategy", "Lcom/bytedance/android/live/browser/d0;", "lynxCallback", "resPrefix", "Lcom/bytedance/android/live/lynx/api/d;", "createOpenLynxComponent", "Landroid/view/ViewGroup;", "viewGroup", LiveSlardarConstants.EXTRA_KEY_URL, "isLynx", "", "addHybridDebugTool", "Landroid/app/Activity;", "activity", "dismissAllWebDialogs", "initPrefetch", "prefetch", "", "", "getCacheByScheme", "Lorg/json/JSONObject;", "getCacheJsonByScheme", "Lcom/bytedance/android/live/browser/webview/fragment/n;", "buildWebDialog", "buildHostWebDialog", "fallbackSchema", "data", "buildLynxDialog", "getRenderUrlByH5Service", "scheme", "Lb7/a;", "commonLifecycle", "Lcom/bytedance/android/annie/api/container/HybridDialog;", "showHybridDialogByGenerate", "generateWebDialogBuilder", "Lcom/bytedance/android/livesdkapi/base/ILiveBrowserFragment;", "createBrowserFragment", "Lu30/b;", "buildFullScreenWebPage", "createAnnieFragmentProxy", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "T", "Ljava/lang/Class;", "provideTestWidgetClass", "provideBridgeSupportWidgetClass", "tryInitEnvIfNeeded", "event", "sendEventToAllJsBridges", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lv30/a;", "webViewMonitorHelper", "Lcom/bytedance/android/livesdkapi/hybridapi/BaseJsBridgeMethodFactory;", "factory", "Lio/reactivex/Observable;", "registerExternalMethodFactory", "eventName", "enqueueEvent", "", "Ljava/util/regex/Pattern;", "getOfflinePatterns", "userId", "openHybridUserProfilePage", "initAnnieGecko", "Lcom/google/gson/JsonObject;", "settings", "updateAnnieSetting", "result", "prepareRemoteDebug", "getLiveExportedXElements", "createSimpleBrowserFragment", "Lw30/a;", "getStorageProcessor", "Lcom/bytedance/android/livesdkapi/hybridapi/SubscriberJsEvent;", "registerJsEventSubscriber", "filterRequestUrl", "appendCommonParams", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", NewBroadcastMonitor.PAGE.ROOM, "appendFeedCommonParams", "Lcom/bytedance/ies/web/jsbridge2/b;", "bridgeImpl", "Lcom/bytedance/android/livesdkapi/hybridapi/IJsBridgeManager;", "createJsBridgeManager", "idleInit", "initAnnie", "initAnnieXCardLiveEnv", "", "getBehaviorList", "xBridge3Adapter", "enableDynamicWebOffline", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "arrayList", "addXBridgeList", "showHybridDialog", "Landroid/content/DialogInterface$OnDismissListener;", "dismissListener", "showHybridDialogWithListener", "showLitePage", "getFinalUri", "Lcom/bytedance/android/live/browser/IBrowserService$PageFinishedListener;", "pageFinishedListener", "Lcom/bytedance/android/live/browser/IBrowserService$PageErrorListener;", "pageErrorListener", "getHybridCard", "Lcom/bytedance/android/annie/api/card/HybridCard;", "presetWidthPx", "Lu30/c;", "createWebViewRecord", "loadTaro", "Lcom/bytedance/android/live/lynx/api/c;", "createLynxComponent", "oriScheme", "Lcom/bytedance/android/annie/api/container/HybridFragment;", "getHybridFragment", "Lcom/bytedance/android/live/browser/jsbridge/i$e$e;", "state", "registerOrNotifyState", "(Lcom/bytedance/android/live/browser/jsbridge/i$e$e;Ljava/lang/Object;)V", "Lkotlin/Function1;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "Lcom/bytedance/android/live/browser/jsbridge/i$a;", "stateCreation", "registerStaticState", "Landroid/view/View;", "lynxView", "method", "statusCode", "errMsg", "reportLynxFetchJsbError", "Lkotlin/ParameterName;", "name", "view", "onloadSuccess", "wrapCommonLifecycle", "tag", "useOldContainerSchemaMonitor", "hybridView", "", "stateKeys", "prefetchToRenderDuration", "initialPropsDuration", "prefetchMonitor", "key", "Lcom/bytedance/android/live/browser/jsbridge/i$c;", "getStateByKey", "initRedirectProcessor", "pageUrl", "channel", "configName", "readGeckoFile", "readGeckoFromChannel", "readGeckoFileVersion", "Landroid/content/Intent;", "intent", "getWebOriginSchema", "fetchInfo", "addPrefetchInfoToWeb", "Lcom/bytedance/android/live/schema/api/d;", "createRedirectProcessor", "Lcom/bytedance/android/livesdkapi/service/MessageHub;", "messageHub", "", "Lcom/bytedance/ies/web/jsbridge2/f$b;", "provideRegisterMessageMethodInFeed", "dataCenter", "Lcom/bytedance/ies/web/jsbridge2/f;", "provideRegisterMessageLatchMethod", "provideRegisterWRDSMethod", "provideDynamicUnRegisterWRDSMethod", "provideGetLiveNtpTimeMethod", "provideLynxLiveBehaviors", "hybridCard", "canvasId", "Landroid/view/Surface;", "surface", "width", "height", "startLynxCast", "surfaceId", "stopLynxCast", "Landroidx/fragment/app/Fragment;", "createLynxFragment", "eventType", "category", "metric", "extra", "common", "canSample", "reportCustomV2", "Lcom/bytedance/android/live/lynx/api/a;", "provideJsb2MethodFinder", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "kitType", "anniePreload", "Lcom/bytedance/android/live/browser/jsbridge/h;", "<set-?>", "prefetchProcessor", "Lcom/bytedance/android/live/browser/jsbridge/h;", "getPrefetchProcessor", "()Lcom/bytedance/android/live/browser/jsbridge/h;", "setPrefetchProcessor", "(Lcom/bytedance/android/live/browser/jsbridge/h;)V", "Lcom/bytedance/android/live/browser/v;", "jsBridgeService", "Lcom/bytedance/android/live/browser/v;", "getJsBridgeService", "()Lcom/bytedance/android/live/browser/v;", "setJsBridgeService", "(Lcom/bytedance/android/live/browser/v;)V", "Lcom/bytedance/android/live/browser/u;", "h5Service", "Lcom/bytedance/android/live/browser/u;", "getH5Service", "()Lcom/bytedance/android/live/browser/u;", "setH5Service", "(Lcom/bytedance/android/live/browser/u;)V", "Lcom/bytedance/android/live/browser/w;", "lynxService", "Lcom/bytedance/android/live/browser/w;", "getLynxService", "()Lcom/bytedance/android/live/browser/w;", "setLynxService", "(Lcom/bytedance/android/live/browser/w;)V", "Ldagger/Lazy;", "Lcom/bytedance/android/live/browser/jsbridge/i;", "stateObservingService", "Ldagger/Lazy;", "getStateObservingService", "()Ldagger/Lazy;", "setStateObservingService", "(Ldagger/Lazy;)V", "TYPE_LIVE_BROWSER", "I", "Lcom/bytedance/android/live/schema/api/WebcastRedirect;", "webcastRedirect$delegate", "Lkotlin/Lazy;", "getWebcastRedirect", "()Lcom/bytedance/android/live/schema/api/WebcastRedirect;", "webcastRedirect", "isUseV2", "Z", "fixLandScale$delegate", "getFixLandScale", "()Z", "fixLandScale", "<init>", "()V", "Companion", "b", "c", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BrowserServiceImpl implements IBrowserService {
    public static final b Companion = null;
    private static final s20.h diComponent = null;
    private final int TYPE_LIVE_BROWSER;
    private final Lazy fixLandScale$delegate;
    public u h5Service;
    private boolean isUseV2;
    public v jsBridgeService;
    public w lynxService;
    private com.bytedance.android.live.browser.jsbridge.h prefetchProcessor;
    public dagger.Lazy<com.bytedance.android.live.browser.jsbridge.i> stateObservingService;
    private final Lazy webcastRedirect$delegate;

    public static final class a implements InvocationHandler {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r2, Method r3, Object[] r4) {
            ALogger.w("Brick", "Dynamic proxy : " + r3.getName() + ", args: " + r4);
            Double r5 = qc.c.a;
            Class<?> r6 = r3.getReturnType();
            if (r6 == Boolean.TYPE) goto L51;
            if (r6 == Boolean.class) goto L51;
            if (r6 == Character.TYPE) goto L59;
            if (r6 == Character.class) goto L59;
            if (r6 == Byte.TYPE) goto L58;
            if (r6 == Byte.class) goto L58;
            if (r6 == Short.TYPE) goto L57;
            if (r6 == Short.class) goto L57;
            if (r6 == Integer.TYPE) goto L56;
            if (r6 == Integer.class) goto L56;
            if (r6 == Long.TYPE) goto L55;
            if (r6 == Long.class) goto L55;
            if (r6 == Float.TYPE) goto L54;
            if (r6 == Float.class) goto L54;
            if (r6 == Double.TYPE) goto L53;
            if (r6 == Double.class) goto L53;
            return null;
        L53:
            return qc.c.a;
        L54:
            return qc.c.b;
        L55:
            return 0L;
        L56:
            return 0;
        L57:
            return (short) 0;
        L58:
            return (byte) 0;
        L59:
            return (char) 0;
        L51:
            return Boolean.FALSE;
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c implements com.bytedance.android.live.room.api.panel.b {
        public final PanelName a;
        public final WeakReference<Dialog> b;

        public static final class a implements Runnable {
            public final /* synthetic */ View a;
            public final /* synthetic */ Function1 b;

            public a(View r1, Function1 r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.b.invoke(Integer.valueOf(this.a.getHeight()));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final int getUnionId() {
            return hashCode();
        }

        public final PanelName getPanelName() {
            return this.a;
        }

        public c(PanelName r2, WeakReference<Dialog> r3) {
            Intrinsics.checkNotNullParameter(r2, "panelName");
            Intrinsics.checkNotNullParameter(r3, "dialog");
            this.a = r2;
            this.b = r3;
        }

        public final void a(Function1<? super Integer, Unit> r3, Function1<? super String, Unit> r4) {
            Intrinsics.checkNotNullParameter(r3, "continueAction");
            Intrinsics.checkNotNullParameter(r4, "stopAction");
            Dialog r0 = this.b.get();
            if (r0 == null) goto L7;
            View r1 = r0.findViewById(2131374651);
            if (r1 == null) goto L7;
            r1.post(new a(r1, r3));
            return;
        L7:
            r4.invoke("root view is null");
        }
    }

    public static final class d implements HybridDialog.a {
        public final Lazy a;
        public final Lazy b;
        public final Lazy c;
        public final /* synthetic */ HybridDialog d;
        public final /* synthetic */ String e;
        public final /* synthetic */ BrowserServiceImpl f;
        public final /* synthetic */ Uri g;
        public final /* synthetic */ Ref.BooleanRef h;
        public final /* synthetic */ DialogInterface.OnDismissListener i;
        public final /* synthetic */ boolean j;

        public final void onDismiss() {
            String r0 = (String) this.a.getValue();
            if (r0 == null) goto L7;
            IFloatWindowDegradeManager r1 = jc1.k.f(IFloatWindowDegradeManager.class);
            if (r1 == null) goto L7;
            r1.checkRecoverForHybrid(r0, "dismiss");
        L7:
            DialogInterface.OnDismissListener r2 = this.i;
            if (r2 == null) goto L10;
            r2.onDismiss(this.d.getDialog());
        L10:
            IDialogListener r3 = (IDialogListener) this.b.getValue();
            if (r3 == null) goto L13;
            LinkedHashMap r4 = new LinkedHashMap();
            r4.put("schema", this.g);
            Unit r5 = Unit.INSTANCE;
            r3.onDismiss(r4);
        L13:
            com.bytedance.android.livesdk.f.d().f();
            com.bytedance.android.livesdk.f r6 = com.bytedance.android.livesdk.f.d();
            String r7 = (String) this.a.getValue();
            if (r7 != null) goto L16;
            r6.getClass();
        L17:
            com.bytedance.android.livesdk.f.d().g(this.e);
            if (this.h.element == false) goto L20;
        L21:
            MatchRoomLandScapeAnimUtil.E.j(this.e);
        L22:
            com.bytedance.android.live.platformplayer.service.a r8 = jc1.k.f(com.bytedance.android.live.platformplayer.service.a.class);
            if (r8 == null) goto L36;
            r8.Z2();
            StreamAutoAdapterService r9 = StreamAutoAdapterService.o;
            ds0.b r11 = new ds0.b();
            String r12 = UriProtector.getQueryParameter(this.g, "panel_scene");
            if (r12 != null) goto L27;
            r12 = UriProtector.getQueryParameter(this.g, "business_type");
        L27:
            r11.a(ds0.b.a.a(r12));
            if (r11.getType() != LivePanelType.UN_KNOW) goto L35;
            ALogger.i("BrowserServiceImpl_showHybridDialog", "onDismiss LivePanelType.UN_KNOW, uri=" + this.g.toString());
            String r13 = UriProtector.getQueryParameter(this.g, LiveSlardarConstants.EXTRA_KEY_URL);
            if (r13 == null) goto L33;
            String r14 = UriProtector.parse(r13).toString();
            if (r14 == null) goto L33;
        L34:
            Intrinsics.checkNotNullParameter(r14, "<set-?>");
            r11.i = r14;
        L33:
            r14 = this.g.toString();
        L35:
            Intrinsics.checkNotNullParameter("close", "<set-?>");
            r11.b = "close";
            Unit r15 = Unit.INSTANCE;
            r9.w1(r11);
        L36:
            com.bytedance.android.live.room.api.panel.c r16 = com.bytedance.android.live.room.api.panel.d.c(null, 3);
            if (r16 == null) goto L40;
            r16.notifyPanelClose(((com.bytedance.android.live.room.api.panel.b) this.c.getValue()).getPanelName(), (com.bytedance.android.live.room.api.panel.b) this.c.getValue());
            return;
        L40:
            return;
        L20:
            if (this.j == false) goto L22;
        L16:
            ((HashMap) r6.f).remove(r7);
            goto L17
        }

        public final void onShow() {
            String r0 = (String) this.a.getValue();
            if (r0 == null) goto L8;
            IFloatWindowDegradeManager r1 = jc1.k.f(IFloatWindowDegradeManager.class);
            if (r1 == null) goto L8;
            r1.checkDegradeForHybrid(r0);
        L8:
            if (this.d.getDialog() != null) goto L10;
            return;
        L10:
            com.bytedance.android.livesdk.f.d().a();
            xs2.b.a().post(new b30.f0(UriProtector.getQueryParameter(this.g, LiveSlardarConstants.EXTRA_KEY_URL)));
            int r2 = 0;
            if (this.h.element == true) goto L13;
        L48:
            com.bytedance.android.livesdk.f.d().b(this.e, this.d.getDialog());
            IDialogListener r3 = (IDialogListener) this.b.getValue();
            if (r3 == null) goto L51;
            r3.onShow(this.e);
        L51:
            ds0.b r4 = new ds0.b();
            String r5 = UriProtector.getQueryParameter(this.g, "panel_scene");
            if (r5 != null) goto L54;
            r5 = UriProtector.getQueryParameter(this.g, "business_type");
        L54:
            r4.a(ds0.b.a.a(r5));
            if (r4.getType() != LivePanelType.UN_KNOW) goto L62;
            ALogger.i("BrowserServiceImpl_showHybridDialog", "onShow LivePanelType.UN_KNOW, uri=" + this.g.toString());
            String r6 = UriProtector.getQueryParameter(this.g, LiveSlardarConstants.EXTRA_KEY_URL);
            if (r6 == null) goto L60;
            String r7 = UriProtector.parse(r6).toString();
            if (r7 == null) goto L60;
        L61:
            Intrinsics.checkNotNullParameter(r7, "<set-?>");
            r4.i = r7;
        L60:
            r7 = this.g.toString();
        L62:
            Intrinsics.checkNotNullParameter("open", "<set-?>");
            r4.b = "open";
            WeakReference r8 = new WeakReference(this.d.getDialog());
            Intrinsics.checkNotNullParameter(r8, "<set-?>");
            r4.d = r8;
            LivePanelType r9 = r4.getType();
            Intrinsics.checkNotNullParameter(r9, "type");
            if (ds0.a.a[r9.ordinal()] != 1) goto L66;
            r2 = (int) (((double) s1.w()) * 0.4d);
        L66:
            r4.c = r2;
            r4.e = 2131374651;
            if (this.d.S90() == false) goto L69;
            r4.e = 2131363000;
        L70:
            com.bytedance.android.live.platformplayer.service.a r11 = jc1.k.f(com.bytedance.android.live.platformplayer.service.a.class);
            if (r11 == null) goto L73;
            r11.Z2();
            StreamAutoAdapterService.o.w1(r4);
        L73:
            com.bytedance.android.live.room.api.panel.c r12 = com.bytedance.android.live.room.api.panel.d.c(null, 3);
            if (r12 == null) goto L77;
            r12.notifyPanelOpen(((com.bytedance.android.live.room.api.panel.b) this.c.getValue()).getPanelName(), (com.bytedance.android.live.room.api.panel.b) this.c.getValue());
            return;
        L77:
            return;
        L69:
            r4.e = 2131374651;
            goto L70
        L13:
            if (BrowserServiceImpl.access$getFixLandScale$p(this.f) == true) goto L48;
            if (TextUtils.equals(a36.b.e(this.g, "unit"), "px") == false) goto L20;
            String r13 = a36.b.e(this.g, "horizontal_width");
            if (r13 == null) goto L19;
            long r14 = CastLongProtector.parseLong(r13);
        L25:
            String r15 = a36.b.e(this.g, "horizontal_width_percent");
            if (r15 == null) goto L28;
            Long r16 = a36.b.f(r15);
        L30:
            if (r14 > 0) goto L47;
            if (r16 == null) goto L47;
            if (r16.longValue() <= 0) goto L47;
            FragmentActivity r17 = this.d.getActivity();
            if (r17 == null) goto L45;
            Window r18 = r17.getWindow();
            if (r18 == null) goto L45;
            View r19 = r18.getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L43;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r21 = ThreadMethodProxy.currentThread();
            if (r21 == com.larus.home.impl.utils.c.a) goto L43;
            com.larus.home.impl.utils.c.a(r21, "getDecorView");
        L43:
            if (r19 == null) goto L45;
            int r22 = r19.getMeasuredWidth();
        L46:
            r14 = (((long) r22) * r16.longValue()) / ((long) 100);
        L45:
            r22 = 0;
        L47:
            boolean r23 = MatchRoomLandScapeAnimUtil.a;
            MatchRoomLandScapeAnimUtil.x(this.e, this.d.getDialog(), Integer.valueOf((int) r14));
            goto L48
        L28:
            r16 = null;
            goto L30
        L19:
            r14 = -1;
            goto L25
        L20:
            String r24 = a36.b.e(this.g, "horizontal_width");
            if (r24 == null) goto L23;
            float r25 = CastFloatProtector.parseFloat(r24);
        L24:
            r14 = s1.f(r25);
            goto L25
        L23:
            r25 = -1.0f;
            goto L24
        }

        public final void onScroll(int r2) {
            IDialogListener r0 = (IDialogListener) this.b.getValue();
            if (r0 == null) goto L6;
            r0.onScroll(r2);
            return;
        }

        public d(HybridDialog r1, String r2, BrowserServiceImpl r3, Uri r4, Ref.BooleanRef r5, DialogInterface.OnDismissListener r6, boolean r7) {
            this.d = r1;
            this.e = r2;
            this.f = r3;
            this.g = r4;
            this.h = r5;
            this.i = r6;
            this.j = r7;
            this.a = LazyKt.lazy(new BrowserServiceImpl$showHybridDialog$$inlined$apply$lambda$1$1(this));
            this.b = LazyKt.lazy(new BrowserServiceImpl$showHybridDialog$$inlined$apply$lambda$1$2(this));
            this.c = LazyKt.lazy(new BrowserServiceImpl$showHybridDialog$$inlined$apply$lambda$1$3(this));
        }
    }

    public static final class e extends b7.a {
        public long a;
        public long b;
        public String c;
        public final /* synthetic */ BrowserServiceImpl d;
        public final /* synthetic */ b7.a e;
        public final /* synthetic */ Function1 f;

        public final void onBeforeGlobalPropsInitialize() {
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onBeforeGlobalPropsInitialize();
            return;
        }

        public final void onBeforeInitialPropsInitialize() {
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onBeforeInitialPropsInitialize();
            return;
        }

        public final void onBeforeJsbRegister() {
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onBeforeJsbRegister();
            return;
        }

        public final void onCardLoadStart() {
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onCardLoadStart();
            return;
        }

        public final void onContainerInitEnd() {
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onContainerInitEnd();
            return;
        }

        public final void onContainerInitStart() {
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onContainerInitStart();
            return;
        }

        public final void onEngineLoadEnd() {
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onEngineLoadEnd();
            return;
        }

        public final void onEngineLoadStart() {
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onEngineLoadStart();
            return;
        }

        public final void onGlobalPropsInitialized() {
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onGlobalPropsInitialized();
            return;
        }

        public final void onInitialPropsInitialized() {
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onInitialPropsInitialized();
            return;
        }

        public final void onJsbRegistered() {
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onJsbRegistered();
            return;
        }

        public final void onLynxEnvInitialized() {
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onLynxEnvInitialized();
            return;
        }

        public final void onPrepareComponentEnd() {
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onPrepareComponentEnd();
            return;
        }

        public final void onPrepareComponentStart() {
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onPrepareComponentStart();
            return;
        }

        public final void onPrepareInitDataEnd() {
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onPrepareInitDataEnd();
            return;
        }

        public final void onPrepareTemplateStart() {
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onPrepareTemplateStart();
            return;
        }

        public final void onRelease() {
            b7.a r0 = this.e;
            if (r0 == null) goto L5;
            r0.onRelease();
        L5:
            String r1 = a(this.c);
            if ((!StringsKt.isBlank(r1)) == false) goto L11;
            IFloatWindowDegradeManager r2 = jc1.k.f(IFloatWindowDegradeManager.class);
            if (r2 == null) goto L12;
            r2.checkRecoverForHybrid(r1, "life_release");
            return;
        L12:
            return;
        }

        public final void onBeforeOpenContainer() {
            this.a = SystemClock.uptimeMillis();
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onBeforeOpenContainer();
            return;
        }

        public static String a(String r1) {
            if (r1 != null) goto L4;
        L7:
            boolean r0 = true;
        L8:
            if (r0 == false) goto L21;
        L19:
            return "";
        L21:
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
            Object r3 = Result.constructor-impl(UriProtector.getQueryParameter(UriProtector.parse(r1), LiveSlardarConstants.EXTRA_KEY_URL));     // Catch: Throwable -> L12
        L15:
            if (Result.isFailure-impl(r3) == false) goto L17;
            r3 = null;
        L17:
            String r4 = (String) r3;
            if (r4 == null) goto L19;
            return r4;
        L12:
            th = move-exception;
            Result.Companion r5 = Result.Companion;
            r3 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L15
        L4:
            if (r1.length() == 0) goto L7;
            r0 = false;
            goto L8
        }

        public final void onBeforeCreateRenderData(View r3) {
            Intrinsics.checkNotNullParameter(r3, "hybridView");
            this.b = SystemClock.uptimeMillis();
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onBeforeCreateRenderData(r3);
            return;
        }

        public final void onBeforeLynxEnvInitialize(boolean r2) {
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onBeforeLynxEnvInitialize(r2);
            return;
        }

        public final void onInit(c7.a r2) {
            Intrinsics.checkNotNullParameter(r2, "annieContext");
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onInit(r2);
            return;
        }

        public final void onLoadSuccess(View r2) {
            Function1 r0 = this.f;
            if (r0 == null) goto L5;
            Unit r1 = (Unit) r0.invoke(r2);
        L5:
            b7.a r3 = this.e;
            if (r3 == null) goto L9;
            r3.onLoadSuccess(r2);
            return;
        }

        public final void onPrepareTemplateEnd(boolean r2) {
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onPrepareTemplateEnd(r2);
            return;
        }

        public final void onCreateRenderData(View r9, Set<String> r11) {
            Intrinsics.checkNotNullParameter(r9, "hybridView");
            Intrinsics.checkNotNullParameter(r11, "stateKeys");
            b7.a r0 = this.e;
            if (r0 == null) goto L5;
            r0.onCreateRenderData(r9, r11);
        L5:
            this.d.prefetchMonitor(r9, r11, SystemClock.uptimeMillis() - this.a, SystemClock.uptimeMillis() - this.b);
        }

        public final boolean onFallback(int r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "errorMessage");
            if (r3 == 100) goto L7;
            w r0 = this.d.getLynxService();
            if (r0 == null) goto L7;
            r0.reportLynxFallback(a(this.c), r3, r4);
        L7:
            b7.a r1 = this.e;
            if (r1 != null) goto L12;
            return false;
        L12:
            return r1.onFallback(r3, r4);
        }

        public final void onInnerFallback(int r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "errorMessage");
            w r0 = this.d.getLynxService();
            if (r0 == null) goto L5;
            r0.reportLynxFallback(a(this.c), r3, r4);
        L5:
            b7.a r1 = this.e;
            if (r1 == null) goto L9;
            r1.onInnerFallback(r3, r4);
            return;
        }

        public final void onLoadStart(View r2, boolean r3) {
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onLoadStart(r2, r3);
            return;
        }

        public final void onPrepareTemplateEnd(boolean r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "resFrom");
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onPrepareTemplateEnd(r2, r3);
            return;
        }

        public e(BrowserServiceImpl r1, b7.a r2, Function1 r3) {
            this.d = r1;
            this.e = r2;
            this.f = r3;
        }

        public final boolean enableInvoke(String r2, JSONObject r3, String r4) {
            b7.a r0 = this.e;
            if (r0 != null) goto L7;
            return true;
        L7:
            return r0.enableInvoke(r2, r3, r4);
        }

        public final void onAttachView(View r2, IHybridComponent.HybridType r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "hybridType");
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onAttachView(r2, r3, r4);
            return;
        }

        public final void onContainerError(View r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "errorMessage");
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onContainerError(r2, r3, r4);
            return;
        }

        public final void onLoadFail(View r2, String r3, String r4) {
            b7.a r0 = this.e;
            if (r0 == null) goto L6;
            r0.onLoadFail(r2, r3, r4);
            return;
        }

        public final void onPrepareInitDataStart(String r2, String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "scheme");
            Intrinsics.checkNotNullParameter(r3, "fallbackUrl");
            b7.a r0 = this.e;
            if (r0 == null) goto L5;
            r0.onPrepareInitDataStart(r2, r3, r4);
        L5:
            this.c = r2;
        }
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    private final boolean getFixLandScale() {
        return ((Boolean) this.fixLandScale$delegate.getValue()).booleanValue();
    }

    private final WebcastRedirect getWebcastRedirect() {
        return (WebcastRedirect) this.webcastRedirect$delegate.getValue();
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public void getHybridCard(Context r1, IBrowserService.PageFinishedListener r2, IBrowserService.PageErrorListener r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public void xBridge3Adapter() {
    }

    static {
        Companion = new b();
        diComponent = new s20.b(new s20.c(), new s20.f(), new ml0.a(), new s20.d());
    }

    private final boolean isLocalTest() {
        if (jc1.k.f(IMiddleWareHostContext.class) == null) goto L8;
        IMiddleWareHostContext r0 = jc1.k.f(IMiddleWareHostContext.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isLocalTest();
    L8:
        return false;
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public List<Object> getBehaviorList() {
        w r0 = this.lynxService;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L6:
        return CollectionsKt.toMutableList(r0.getBehaviorList());
    }

    public final u getH5Service() {
        u r0 = this.h5Service;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L5:
        return r0;
    }

    public final v getJsBridgeService() {
        v r0 = this.jsBridgeService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public List<Object> getLiveExportedXElements() {
        w r0 = this.lynxService;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L6:
        return r0.getLiveExportedXElements();
    }

    public final w getLynxService() {
        w r0 = this.lynxService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L5:
        return r0;
    }

    public final dagger.Lazy<com.bytedance.android.live.browser.jsbridge.i> getStateObservingService() {
        dagger.Lazy<com.bytedance.android.live.browser.jsbridge.i> r0 = this.stateObservingService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stateObservingService");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public void idleInit() {
        if (this.isUseV2 == false) goto L8;
        u r0 = this.h5Service;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L7:
        r0.d();
        return;
    L8:
        u r1 = this.h5Service;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L11:
        r1.a();
    }

    @Override // com.bytedance.android.live.browser.IBrowserService, com.bytedance.android.live.browser.IBaseBrowserService
    public void initAnnie() {
        boolean r0 = AnnieNGInitHelper.a;
        v r1 = this.jsBridgeService;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L5:
        w r2 = this.lynxService;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L8:
        u r3 = this.h5Service;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L11:
        AnnieNGInitHelper.c(r1, r2, r3);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public void initAnnieGecko() {
        boolean r0 = AnnieNGInitHelper.a;
        w r1 = this.lynxService;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L5:
        AnnieNGInitHelper.b(r1, Boolean.TRUE);
        com.bytedance.android.annie.a.e(f9.b.class, new AnnieExternalServiceImpl(), true, 4);
        com.bytedance.android.annie.a.e(IAnnieNetworkService.class, new com.bytedance.android.live.browser.service.x(), true, 4);
        Single.fromCallable(k.a).subscribeOn(Schedulers.io()).subscribe();
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public boolean initAnnieXCardLiveEnv() {
        boolean r0 = AnnieNGInitHelper.a;
        v r1 = this.jsBridgeService;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L5:
        w r2 = this.lynxService;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L8:
        u r3 = this.h5Service;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L12:
        return AnnieNGInitHelper.d(r1, r2, r3);
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public void initPrefetch() {
        com.bytedance.android.live.browser.jsbridge.h r0 = this.prefetchProcessor;
        if (r0 == null) goto L6;
        r0.init();
        return;
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public void initRedirectProcessor() {
        if (((Boolean) xa1.a.e.getValue()).booleanValue() == false) goto L10;
        Context r0 = jc1.k.n(IMiddleWareHostContext.class).context();
        jc1.k.n(IHostContext.class).getVersionName();
        int r1 = s8.a.a;
        Context r2 = r0.getApplicationContext();
        if (r2 == null) goto L9;
        Intrinsics.checkNotNullParameter((Application) r2, "context");
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    L10:
        WebcastRedirect r3 = getWebcastRedirect();
        r3.getClass();
        new WebcastRedirect.WebcastRedirectProcessorImpl(r3, 1).a(com.bytedance.android.live.schema.api.utils.b.a, null);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public <T extends LiveRecyclableWidget> Class<T> provideBridgeSupportWidgetClass() {
        v r0 = this.jsBridgeService;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L6:
        return r0.provideBridgeSupportWidgetClass();
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public com.bytedance.android.live.lynx.api.a provideJsb2MethodFinder() {
        return new Jsb2MethodFinder();
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public List<Object> provideLynxLiveBehaviors() {
        w r0 = this.lynxService;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L6:
        return r0.provideLynxLiveBehaviors();
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public <T extends LiveRecyclableWidget> Class<T> provideTestWidgetClass() {
        w r0 = this.lynxService;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L6:
        return r0.createTestWidgetClass();
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public v30.a webViewMonitorHelper() {
        return n30.f.a.e();
    }

    public BrowserServiceImpl() {
        this.TYPE_LIVE_BROWSER = 1;
        this.webcastRedirect$delegate = LazyKt.lazy(BrowserServiceImpl$webcastRedirect$2.INSTANCE);
        this.isUseV2 = LiveInitSettingKeys.get_LIVE_HYBRID_USE_MONITOR_SAMPLE_RATE().booleanValue();
        this.fixLandScale$delegate = LazyKt.lazy(BrowserServiceImpl$fixLandScale$2.INSTANCE);
        ConcurrentHashMap r0 = qc.a.a;
        a r1 = a.a;
        qc.a.a.put(w.class, r1);
        jc1.k.l(IExternalBrowserService.class, new ExternalBrowserService());
        s20.b r2 = (s20.b) diComponent;
        setPrefetchProcessor((com.bytedance.android.live.browser.jsbridge.h) r2.c.get());
        setJsBridgeService((v) r2.e.get());
        setH5Service((u) r2.g.get());
        setLynxService((w) r2.h.get());
        setStateObservingService(DoubleCheck.lazy(r2.k));
        v r3 = this.jsBridgeService;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L5:
        r3.initPermissionCheck();
        if (this.isUseV2 == false) goto L11;
        u r4 = this.h5Service;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L10:
        r4.d();
    L15:
        jc1.k.l(IBrowserService.class, this);
        jc1.k.l(IBaseBrowserService.class, this);
        return;
    L11:
        u r5 = this.h5Service;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L14:
        r5.a();
        goto L15
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public com.bytedance.android.live.schema.api.d createRedirectProcessor() {
        WebcastRedirect r0 = getWebcastRedirect();
        r0.getClass();
        return new WebcastRedirect.WebcastRedirectProcessorImpl(r0, 1);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public List<Pattern> getOfflinePatterns() {
        return TTLiveWebOfflineConfig.getOfflinePatterns();
    }

    public static final /* synthetic */ s20.h access$getDiComponent$cp() {
        return diComponent;
    }

    public final com.bytedance.android.live.browser.jsbridge.h getPrefetchProcessor() {
        return this.prefetchProcessor;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_live_browser_BrowserServiceImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static final /* synthetic */ boolean access$getFixLandScale$p(BrowserServiceImpl r0) {
        return r0.getFixLandScale();
    }

    private final Uri addLiveUISpecification(Uri r7) {
        if (PadConfigUtils.c() == false) goto L5;
    L6:
        boolean r2 = true;
        if (UriProtector.getQueryParameter(r7, "margin_bottom") != null) goto L9;
        boolean r1 = true;
    L11:
        if (UriProtector.getQueryParameter(r7, "margin_right") == null) goto L14;
        r2 = false;
    L14:
        if (r1 == true) goto L16;
        if (r2 == true) goto L16;
        return r7;
    L16:
        Uri.Builder r8 = r7.buildUpon();
        if (r1 == false) goto L19;
        r8.appendQueryParameter("margin_bottom", "20");
    L19:
        if (r2 == false) goto L22;
        r8.appendQueryParameter("margin_right", "20");
    L22:
        return r8.build();
    L9:
        r1 = false;
        goto L11
    L5:
        if (FoldScreenUtils.f() == true) goto L6;
        return r7;
    }

    private final boolean isShowAnimInLandscapeEnable(Uri r7) {
        String r0 = UriProtector.getQueryParameter(r7, "gravity");
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L8;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L8;
        Room r3 = (Room) r2.getValue();
    L8:
        if (((d51) m50.a.getValue()).n() == false) goto L20;
        if (r0 != null) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r0, "bottom") == true) goto L17;
        if (Intrinsics.areEqual(r0, "right") == true) goto L17;
        if (Intrinsics.areEqual(r0, "end") == true) goto L17;
        return false;
    L17:
        if (e5.n() == false) goto L23;
        return true;
    L23:
        return false;
    L20:
        return r7.getBooleanQueryParameter("use_anim_in_landscape", false);
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public void addXBridgeList(ArrayList<Class<? extends Object>> r2) {
        Intrinsics.checkNotNullParameter(r2, "arrayList");
        b0.b(r2);
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public String appendCommonParams(String r3) {
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        u r0 = this.h5Service;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L6:
        return r0.appendCommonParams(r3);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public com.bytedance.android.live.browser.webview.fragment.n buildHostWebDialog(String r3) {
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        com.bytedance.android.live.browser.webview.fragment.o r0 = new com.bytedance.android.live.browser.webview.fragment.o(r3);
        BaseHybridParamVo.HybridType r4 = BaseHybridParamVo.HybridType.HOST_H5;
        Intrinsics.checkNotNullParameter(r4, "hybridType");
        r0.D = r4;
        return r0;
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public com.bytedance.android.live.browser.webview.fragment.n buildWebDialog(String r3) {
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        com.bytedance.android.live.browser.jsbridge.h r0 = this.prefetchProcessor;
        if (r0 == null) goto L5;
        r0.prefetch(r3);
    L5:
        com.bytedance.android.live.browser.webview.fragment.o r1 = new com.bytedance.android.live.browser.webview.fragment.o(r3);
        BaseHybridParamVo.HybridType r4 = BaseHybridParamVo.HybridType.H5;
        Intrinsics.checkNotNullParameter(r4, "hybridType");
        r1.D = r4;
        return r1;
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public ILiveBrowserFragment createAnnieFragmentProxy(Bundle r6) {
        Intrinsics.checkNotNullParameter(r6, "bundle");
        int r1 = com.bytedance.android.live.schema.helper.a.a;
        if (r6 == null) goto L16;
        BaseHybridParamVo r2 = null;
        WebHybridParamVo r3 = (WebHybridParamVo) r6.get("hybrid_web_vo");     // Catch: ClassNotFoundException -> L8
    L10:
        if (r3 != null) goto L16;
        com.bytedance.android.live.schema.api.utils.a.d("tag_hybrid_parse", "HybridParamHelper->checkFullScreenVo: webHybridParamVo is null");
        WebHybridParamVo r4 = com.bytedance.android.live.schema.helper.a.f(r6.getString(LiveSlardarConstants.EXTRA_KEY_URL), null, r6);
        r6.putParcelable("hybrid_web_vo", r4);
        if (r4 == null) goto L14;
        r2 = r4.h;
    L14:
        r6.putParcelable("hybrid_pop_vo", r2);
    L8:
        e = move-exception;
        com.bytedance.android.live.schema.api.utils.a.c("HybridParamHelper", e);
        r3 = null;
    L16:
        return new com.bytedance.android.live.browser.webview.fragment.i(r6);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public ILiveBrowserFragment createBrowserFragment(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "bundle");
        u r0 = this.h5Service;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L6:
        return r0.createBrowserFragment(r3);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public ILiveBrowserFragment createSimpleBrowserFragment(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "bundle");
        u r0 = this.h5Service;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L6:
        return r0.createSimpleBrowserFragment(r3);
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public void dismissAllWebDialogs(Activity r3) {
        u r0 = this.h5Service;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L5:
        r0.g();
        SettingKey<Boolean> r1 = com.bytedance.android.live.b.a;
        if (com.bytedance.android.live.b.a.getValue().booleanValue() == true) goto L8;
        Annie.closeAllAnnieDialog(r3);
        return;
    L8:
        Annie.closeAllAnnieDialog$default(null, 1, null);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public boolean enableDynamicWebOffline(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r1 = p20.c.a;
        Intrinsics.checkNotNullParameter(r5, "context");
        boolean r2 = false;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L21;
        SharedPreferences r6 = SharedPrefHelper.c(r5, "ttlive_sdk_hybrid_test").a;
        IMiddleWareHostContext r0 = jc1.k.f(IMiddleWareHostContext.class);
        if (r0 == null) goto L20;
        HostBoeParams r3 = r0.getHostBoeParams();
        if (r3 == null) goto L20;
        if (r3.getBoeEnable() == false) goto L15;
        if (TextUtils.equals("prod", r3.getBoeLane()) == true) goto L20;
    L18:
        r2 = true;
        goto L20
    L15:
        if (r3.getPpeEnable() == false) goto L20;
        if (TextUtils.equals("prod", r3.getPpeLane()) == false) goto L18;
    L20:
        return r6.getBoolean("ttlive_lynx_enable_dynamic_weboffline", r2);
    L21:
        return false;
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public String filterRequestUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, LiveSlardarConstants.EXTRA_KEY_URL);
        return ApiHookImpl.a(r2, 0);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public com.bytedance.android.live.browser.webview.fragment.n generateWebDialogBuilder(String r8) {
        Intrinsics.checkNotNullParameter(r8, "scheme");
        Uri r2 = UriProtector.parse(r8);     // Catch: Exception -> L52
        String r3 = r2.getHost();     // Catch: Exception -> L52
        String r4 = UriProtector.getQueryParameter(r2, LiveSlardarConstants.EXTRA_KEY_URL);     // Catch: Exception -> L52
        if (r4 != null) goto L7;
        return null;
    L7:
        if (Intrinsics.areEqual(r3, "webcast_lynxview") == false) goto L9;
        com.bytedance.android.live.browser.webview.fragment.n r5 = buildLynxDialog(r4, UriProtector.getQueryParameter(r2, "fallback_url"), null);     // Catch: Exception -> L52
    L10:
        i2.d(r2, "type", "bottom");     // Catch: Exception -> L52
        boolean r6 = false;
        if (Intrinsics.areEqual(i2.d(r2, "gravity", "bottom"), "bottom") == false) goto L14;
        com.bytedance.android.live.browser.webview.fragment.o r0 = r5.b(i2.c(r2, "radius", 8), i2.c(r2, "radius", 8), 0, 0);     // Catch: Exception -> L52
        r0.i = 80;     // Catch: Exception -> L52
    L15:
        r0.b = i2.c(r2, "height", 400);     // Catch: Exception -> L52
        r0.a = i2.c(r2, "width", (int) s1.G(s1.y()));     // Catch: Exception -> L52
        r0.c = i2.c(r2, "margin", 0);     // Catch: Exception -> L52
        r0.t = i2.c(r2, "height_percent", 0);     // Catch: Exception -> L52
        r0.u = i2.c(r2, "width_percent", 0);     // Catch: Exception -> L52
        r0.v = i2.c(r2, "rate_height", -1);     // Catch: Exception -> L52
        if (i2.c(r2, "pull_down_indicator_not_show", 1) != 1) goto L18;
        boolean r7 = true;
    L19:
        r0.w = r7;     // Catch: Exception -> L52
        r0.x = i2.c(r2, "pull_down_height", 0);     // Catch: Exception -> L52
        if (i2.c(r2, "show_back", 0) != 1) goto L22;
        boolean r9 = true;
    L23:
        r0.A = r9;     // Catch: Exception -> L52
        if (i2.c(r2, "show_close", 0) != 1) goto L26;
        boolean r11 = true;
    L27:
        r0.y = r11;     // Catch: Exception -> L52
        if (i2.c(r2, "pull_down_close", 0) != 1) goto L30;
        boolean r12 = true;
    L31:
        r0.B = r12;     // Catch: Exception -> L52
        if (i2.c(r2, "landscape_custom_height", 0) != 1) goto L34;
        boolean r13 = true;
    L35:
        r0.m = r13;     // Catch: Exception -> L52
        if (i2.c(r2, "landscape_custom_width", 0) != 1) goto L38;
        boolean r14 = true;
    L39:
        r0.n = r14;     // Catch: Exception -> L52
        r0.H = i2.c(r2, "lynx_thread", 0);     // Catch: Exception -> L52
        if (i2.c(r2, "window_floating", 1) != 1) goto L42;
        boolean r15 = true;
    L43:
        r0.J = r15;     // Catch: Exception -> L52
        if (i2.c(r2, "abandon_coordinate", 0) != 1) goto L46;
        boolean r16 = true;
    L47:
        r0.K = r16;     // Catch: Exception -> L52
        if (i2.c(r2, "enable_lynx_bg", 0) != 1) goto L50;
        r6 = true;
    L50:
        r0.L = r6;     // Catch: Exception -> L52
        Intrinsics.checkNotNullParameter(r8, "oriScheme");     // Catch: Exception -> L52
        r0.M = r8;     // Catch: Exception -> L52
        return r0;
    L46:
        r16 = false;
        goto L47
    L42:
        r15 = false;
        goto L43
    L38:
        r14 = false;
        goto L39
    L34:
        r13 = false;
        goto L35
    L30:
        r12 = false;
        goto L31
    L26:
        r11 = false;
        goto L27
    L22:
        r9 = false;
        goto L23
    L18:
        r7 = false;
        goto L19
    L14:
        r0 = r5.d(i2.c(r2, "radius", 8));     // Catch: Exception -> L52
        r0.i = 17;     // Catch: Exception -> L52
        goto L15
    L9:
        r5 = buildWebDialog(r4);     // Catch: Exception -> L52
    L52:
        return null;
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public Map<String, Object> getCacheByScheme(String r2) {
        Intrinsics.checkNotNullParameter(r2, LiveSlardarConstants.EXTRA_KEY_URL);
        com.bytedance.android.live.browser.jsbridge.h r0 = this.prefetchProcessor;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCacheByScheme(r2);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public JSONObject getCacheJsonByScheme(String r2) {
        Intrinsics.checkNotNullParameter(r2, LiveSlardarConstants.EXTRA_KEY_URL);
        com.bytedance.android.live.browser.jsbridge.h r0 = this.prefetchProcessor;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCacheJsonByScheme(r2);
    }

    public final Uri getFinalUri(Uri r11) {
        Intrinsics.checkNotNullParameter(r11, "uri");
        Map<String, r20.a> r1 = q20.h.a;
        SettingKey r2 = xa1.a.a;
        if (((Boolean) r2.getValue()).booleanValue() == true) goto L5;
        return r11;
    L5:
        Intrinsics.checkNotNullParameter(r11, "uri");
        if (((Boolean) r2.getValue()).booleanValue() == false) goto L58;
        Intrinsics.checkNotNullParameter(r11, "uri");
        Map<String, String> r3 = r20.c.a;
        Intrinsics.checkNotNullParameter(r11, "originUri");
        Uri r4 = UriProtector.parse((String) ((HashMap) r20.c.a).get(q20.j.a(r11)));     // Catch: Exception -> L11
    L13:
        if (r4 == null) goto L42;
        int r5 = q20.j.a;
        Intrinsics.checkNotNullParameter(r11, "originUri");
        Intrinsics.checkNotNullParameter(r4, "targetUri");
        Uri.Builder r6 = UriProtector.parse(UriProtector.getQueryParameter(r11, LiveSlardarConstants.EXTRA_KEY_URL)).buildUpon();     // Catch: Exception -> L41
        String r7 = r4.getScheme();     // Catch: Exception -> L41
        boolean r8 = true;
        if (r7 != null) goto L18;
    L23:
        String r9 = r4.getAuthority();     // Catch: Exception -> L41
        if (r9 != null) goto L26;
    L31:
        String r12 = r4.getPath();     // Catch: Exception -> L41
        if (r12 != null) goto L34;
    L39:
        Uri r13 = q20.j.b(r11, r6.build().toString());     // Catch: Exception -> L41
    L43:
        Intrinsics.checkNotNullParameter(r11, "originUri");
        Intrinsics.checkNotNullParameter(r13, "finalUri");
        if (q20.h.a != null) goto L46;
        q20.h.a = new LinkedHashMap();
    L46:
        Map<String, r20.a> r14 = q20.h.a;
        if (r14 == null) goto L49;
        Intrinsics.checkNotNullParameter(r11, "uri");
        Uri r0 = UriProtector.parse(UriProtector.getQueryParameter(r11, LiveSlardarConstants.EXTRA_KEY_URL));
        r20.a r15 = r14.put(r11.getHost() + '/' + r11.getPath() + '-' + r0.getScheme() + "://" + r0.getHost() + r0.getPath(), new r20.a(r11, r13));
    L49:
        com.bytedance.android.livesdk.sharedpref.e r16 = com.bytedance.android.livesdk.sharedpref.b.y;
        if (((List) r16.getValue()).size() <= 30) goto L52;
        List r17 = (List) r16.getValue();
        r17.removeAll(r17.subList(r17.size() / 2, r17.size() - 1));
    L52:
        ((List) r16.getValue()).add(r11.toString());
        com.bytedance.android.livesdk.sharedpref.f.d(r16, r16.getValue());
        return r13;
    L34:
        if (r12.length() > 0) goto L37;
        r8 = false;
    L37:
        if (r8 == false) goto L39;
        r6.path(r12);     // Catch: Exception -> L41
        goto L39
    L26:
        if (r9.length() <= 0) goto L28;
        boolean r18 = true;
    L29:
        if (r18 == false) goto L31;
        r6.encodedAuthority(r9);     // Catch: Exception -> L41
        goto L31
    L28:
        r18 = false;
        goto L29
    L18:
        if (r7.length() <= 0) goto L20;
        boolean r19 = true;
    L21:
        if (r19 == false) goto L23;
        r6.scheme(r7);     // Catch: Exception -> L41
        goto L23
    L20:
        r19 = false;
    L42:
        r13 = r11;
    L11:
        r4 = null;
        goto L13
    L58:
        return r11;
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public String getRenderUrlByH5Service(String r3) {
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        if (((Boolean) o70.a.getValue()).booleanValue() == false) goto L9;
        u r0 = this.h5Service;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L8:
        return r0.appendCommonParams(r3);
    L9:
        return r3;
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public com.bytedance.android.live.browser.jsbridge.i.c getStateByKey(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        dagger.Lazy<com.bytedance.android.live.browser.jsbridge.i> r0 = this.stateObservingService;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("stateObservingService");
    L6:
        return ((com.bytedance.android.live.browser.jsbridge.i) r0.get()).a().get(r3);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public w30.a getStorageProcessor(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        v r0 = this.jsBridgeService;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L6:
        return r0.getStorageProcessor(r3);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public String getWebOriginSchema(Intent r3) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        Bundle r4 = r3.getExtras();
        if (r4 == null) goto L5;
        WebHybridParamVo r1 = (WebHybridParamVo) r4.getParcelable("hybrid_web_vo");
    L6:
        if (r1 == null) goto L13;
        BaseHybridParamVo r2 = r1.h;
        if (r2 == null) goto L13;
        String r5 = r2.o;
        if (r5 == null) goto L13;
        return r5;
    L13:
        if (r4 != null) goto L15;
        return null;
    L15:
        return r4.getString(LiveSlardarConstants.EXTRA_KEY_URL);
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public void prefetch(String r2) {
        Intrinsics.checkNotNullParameter(r2, LiveSlardarConstants.EXTRA_KEY_URL);
        com.bytedance.android.live.browser.jsbridge.h r0 = this.prefetchProcessor;
        if (r0 == null) goto L6;
        r0.prefetch(r2);
        return;
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public void prepareRemoteDebug(String r3) {
        w r0 = this.lynxService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L5:
        r0.prepareRemoteDebug(r3);
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public com.bytedance.ies.web.jsbridge2.f<?, ?> provideDynamicUnRegisterWRDSMethod(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        v r0 = this.jsBridgeService;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L6:
        return r0.provideDynamicUnRegisterWRDSMethod(r3);
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public com.bytedance.ies.web.jsbridge2.f<?, ?> provideGetLiveNtpTimeMethod(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        v r0 = this.jsBridgeService;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L6:
        return r0.provideGetLiveNtpTimeMethod(r3);
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public com.bytedance.ies.web.jsbridge2.f<?, ?> provideRegisterMessageLatchMethod(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        v r0 = this.jsBridgeService;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L6:
        return r0.provideRegisterMessageLatchMethod(r3);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideRegisterMessageMethodInFeed(MessageHub r3) {
        v r0 = this.jsBridgeService;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L6:
        return r0.provideRegisterMessageMethodInFeed(r3);
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public com.bytedance.ies.web.jsbridge2.f<?, ?> provideRegisterWRDSMethod(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        v r0 = this.jsBridgeService;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L6:
        return r0.provideRegisterWRDSMethod(r3);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService, com.bytedance.android.live.browser.IBaseBrowserService
    public Observable<Unit> registerExternalMethodFactory(BaseJsBridgeMethodFactory r3) {
        Intrinsics.checkNotNullParameter(r3, "factory");
        v r0 = this.jsBridgeService;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L6:
        return r0.registerExternalMethodFactory(r3);
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public Observable<SubscriberJsEvent> registerJsEventSubscriber(String r3) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        v r0 = this.jsBridgeService;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L6:
        return r0.registerJsEventSubscriber(r3);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public <T> void registerStaticState(Function1<? super DataCenter, ? extends com.bytedance.android.live.browser.jsbridge.i.a<? extends T>> r3) {
        Intrinsics.checkNotNullParameter(r3, "stateCreation");
        dagger.Lazy<com.bytedance.android.live.browser.jsbridge.i> r0 = this.stateObservingService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stateObservingService");
    L5:
        ((com.bytedance.android.live.browser.jsbridge.i) r0.get()).registerStaticState(r3);
    }

    @Inject
    public final void setH5Service(u r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h5Service = r2;
    }

    @Inject
    public final void setJsBridgeService(v r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.jsBridgeService = r2;
    }

    @Inject
    public final void setLynxService(w r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.lynxService = r2;
    }

    @Inject
    public final void setPrefetchProcessor(com.bytedance.android.live.browser.jsbridge.h r1) {
        this.prefetchProcessor = r1;
    }

    @Inject
    public final void setStateObservingService(dagger.Lazy<com.bytedance.android.live.browser.jsbridge.i> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.stateObservingService = r2;
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public void tryInitEnvIfNeeded(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        w r0 = this.lynxService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L5:
        r0.tryInitEnvIfNeeded(r3);
    }

    private final long getUriEncodedStartTimeOrCurrent(Uri r5, Bundle r6) {
        String r7 = UriProtector.getQueryParameter(r5, "open_time");
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r7) == false) goto L7;
        if (r7 != null) goto L6;
        return 0;
    L6:
        return CastLongProtector.parseLong(r7);
    L7:
        long r8 = r6.getLong("open_time");
        if (r8 <= 0) goto L11;
        return r8;
    L11:
        return System.currentTimeMillis();
    }

    private final String uriAppendParams(Uri r4, HashMap<String, String> r5) {
        Uri.Builder r6 = r4.buildUpon();
        Iterator<T> r0 = r5.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        String r1 = (String) r0.next();
        r6.appendQueryParameter(r1, r5.get(r1));
        goto L4
    L7:
        return r6.build().toString();
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public void addPrefetchInfoToWeb(Intent r7, HashMap<String, String> r8) {
        Intrinsics.checkNotNullParameter(r7, "intent");
        Intrinsics.checkNotNullParameter(r8, "fetchInfo");
        Bundle r0 = r7.getExtras();
        Unit r2 = null;
        if (r0 == null) goto L5;
        WebHybridParamVo r3 = (WebHybridParamVo) r0.getParcelable("hybrid_web_vo");
    L6:
        if (r3 == null) goto L19;
        BaseHybridParamVo r4 = r3.h;
        if (r4 == null) goto L10;
        String r5 = r4.o;
    L34:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L16
        Uri r9 = UriProtector.parse(r5);     // Catch: Throwable -> L16
        BaseHybridParamVo r11 = r3.h;     // Catch: Throwable -> L16
        if (r11 == null) goto L14;
        r11.o = uriAppendParams(r9, r8);     // Catch: Throwable -> L16
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L14:
        Result.constructor-impl(r2);     // Catch: Throwable -> L16
    L18:
        r0.putParcelable("hybrid_web_vo", r3);
    L31:
        if (r0 == null) goto L36;
        r7.putExtras(r0);
        return;
    L36:
        return;
    L16:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L10:
        r5 = null;
        goto L34
    L19:
        if (r0 == null) goto L31;
        String r13 = r0.getString(LiveSlardarConstants.EXTRA_KEY_URL);
        if (r13 == null) goto L31;
        WebHybridParamVo r14 = com.bytedance.android.live.schema.helper.a.f(r13, null, r0);
        if (r14 == null) goto L27;
        BaseHybridParamVo r15 = r14.h;
        if (r15 == null) goto L27;
        r15.o = uriAppendParams(x6.a.a(r13).build(), r8);
    L27:
        r0.putParcelable("hybrid_web_vo", r14);
        if (r14 == null) goto L30;
        r2 = r14.h;
    L30:
        r0.putParcelable("hybrid_pop_vo", r2);
        goto L31
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public String appendFeedCommonParams(String r3, IRoom r4) {
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r4, NewBroadcastMonitor.PAGE.ROOM);
        u r0 = this.h5Service;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L6:
        return r0.appendFeedCommonParams(r3, r4);
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public u30.b buildFullScreenWebPage(Context r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, LiveSlardarConstants.EXTRA_KEY_URL);
        com.bytedance.android.live.browser.utils.h.b();
        com.bytedance.android.live.browser.utils.h.a();
        PerformanceEventKitUtil.trigger$default(PerformanceEventKitUtil.INSTANCE, "full_screen", null, 2, null);
        u r0 = this.h5Service;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L6:
        return r0.i(r5, r6);
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public IJsBridgeManager createJsBridgeManager(Activity r3, com.bytedance.ies.web.jsbridge2.b r4) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "bridgeImpl");
        v r0 = this.jsBridgeService;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L6:
        return r0.createJsBridgeManager(r3, r4, 1);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public Fragment createLynxFragment(Context r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bundle");
        return createLynxFragment(r2, r3, null);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public u30.c createWebViewRecord(Activity r2, IBrowserService.PageFinishedListener r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        u r4 = this.h5Service;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L5:
        r4.b(r2);
        return null;
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public void enqueueEvent(String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r6, "params");
        EventCenter.enqueueEvent(new Event(r5, System.currentTimeMillis(), new f66.d(r6)));
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public <T> void registerOrNotifyState(com.bytedance.android.live.browser.jsbridge.i.e.AbstractC0111e<T> r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "state");
        dagger.Lazy<com.bytedance.android.live.browser.jsbridge.i> r0 = this.stateObservingService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stateObservingService");
    L5:
        ((com.bytedance.android.live.browser.jsbridge.i) r0.get()).b(r3, r4);
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public <T> void sendEventToAllJsBridges(String r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        v r0 = this.jsBridgeService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L5:
        r0.sendEventToAllJsBridges(r3, r4);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public void updateAnnieSetting(Context r2, JsonObject r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "settings");
        com.bytedance.android.annie.a.c(y9.o.class).x1(r2, r3);
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public void useOldContainerSchemaMonitor(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r13, "tag");
        Uri r2 = UriProtector.parse(r12);
        JSONObject r8 = new JSONObject();
        r8.put("path", r2.getHost() + "/" + r2.getPath());
        r8.put("tag", r13);
        JSONObject r11 = new JSONObject();
        r11.put(LiveSlardarConstants.EXTRA_KEY_URL, r12);
        LiveTracingMonitor.c("ttlive_hybrid_use_old_container", LiveTracingMonitor.EventModule.hybrid, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 0, "", r8, null, r11);
    }

    public final b7.a wrapCommonLifecycle(b7.a r2, Function1<? super View, Unit> r3) {
        return new e(this, r2, r3);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public com.bytedance.android.live.browser.webview.fragment.n buildLynxDialog(String r3, String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        if (((Boolean) o70.a.getValue()).booleanValue() == false) goto L8;
        u r0 = this.h5Service;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L7:
        r3 = r0.appendCommonParams(r3);
    L8:
        com.bytedance.android.live.browser.jsbridge.h r1 = this.prefetchProcessor;
        if (r1 == null) goto L11;
        r1.prefetch(r3);
    L11:
        com.bytedance.android.live.browser.webview.fragment.o r2 = new com.bytedance.android.live.browser.webview.fragment.o(r3, r4, r5);
        BaseHybridParamVo.HybridType r6 = BaseHybridParamVo.HybridType.LYNX;
        Intrinsics.checkNotNullParameter(r6, "hybridType");
        r2.D = r6;
        return r2;
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public Fragment createLynxFragment(Context r3, Bundle r4, d0 r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "bundle");
        w r0 = this.lynxService;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L6:
        return r0.createLynxFragment(r3, r4, r5);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public u30.c createWebViewRecord(Activity r1, IBrowserService.PageFinishedListener r2, IBrowserService.PageErrorListener r3) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        u r4 = this.h5Service;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L5:
        r4.b(r1);
        return null;
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public HybridCard getHybridCard(Context r2, Uri r3, b7.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        return getHybridCard(r2, r3, r4, null);
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public HybridFragment getHybridFragment(Context r2, Uri r3, b7.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        return getHybridFragment(r2, r3, r4, null);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public void openHybridUserProfilePage(Context r8, String r9, Map<String, String> r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "userId");
        Intrinsics.checkNotNullParameter(r11, "data");
        Bundle r12 = new Bundle();
        String r1 = (String) xk0.a.getValue();
        r12.putBoolean("use_annie", true);
        String r13 = UriProtector.getQueryParameter(UriProtector.parse(r1), LiveSlardarConstants.EXTRA_KEY_URL);
        String r14 = UriProtector.parse(r13).buildUpon().appendQueryParameter("target_user_open_id", r9).build().toString();
        String r15 = StringsKt.replace$default(r1, Uri.encode(r13), Uri.encode(r14), false, 4, null);
        ILiveService r16 = TTLiveService.getLiveService();
        if (r16 == null) goto L6;
        r16.handleSchema(r8, UriProtector.parse(r15));
        return;
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public JSONObject readGeckoFile(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "pageUrl");
        Intrinsics.checkNotNullParameter(r3, "channel");
        Intrinsics.checkNotNullParameter(r4, "configName");
        return e0.c(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public long readGeckoFileVersion(String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "pageUrl");
        Intrinsics.checkNotNullParameter(r6, "channel");
        Intrinsics.checkNotNullParameter(r7, "configName");
        int r3 = e0.a;
        Intrinsics.checkNotNullParameter(r5, "pageUrl");
        Intrinsics.checkNotNullParameter(r6, "channel");
        Intrinsics.checkNotNullParameter(r7, "configName");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        d1 r8 = e0.a(r5, r6, r7);     // Catch: Throwable -> L7
        if (r8 == null) goto L9;
        return r8.f;
    L9:
        return 0;
    L7:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public JSONObject readGeckoFromChannel(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "pageUrl");
        Intrinsics.checkNotNullParameter(r3, "channel");
        Intrinsics.checkNotNullParameter(r4, "configName");
        return e0.d(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public HybridDialog showHybridDialog(Context r8, Uri r9, b7.a r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "uri");
        return showHybridDialog(r8, r9, r11, null, null);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public HybridDialog showHybridDialogByGenerate(Context r22, String r23, b7.a r24) {
        Intrinsics.checkNotNullParameter(r22, "context");
        Intrinsics.checkNotNullParameter(r23, "scheme");
        Uri r1 = UriProtector.parse(r23);     // Catch: Exception -> L65
        String r2 = r1.getHost();     // Catch: Exception -> L65
        String r3 = UriProtector.getQueryParameter(r1, LiveSlardarConstants.EXTRA_KEY_URL);     // Catch: Exception -> L65
        if (r3 != null) goto L8;
        return null;
    L8:
        if (Intrinsics.areEqual(r2, "webcast_lynxview") == false) goto L10;
        Uri.Builder r4 = x6.a.c(getRenderUrlByH5Service(r3)).appendQueryParameter("fallback_url", UriProtector.getQueryParameter(r1, "fallback_url"));     // Catch: Exception -> L65
    L11:
        String r5 = i2.d(r1, "type", "");     // Catch: Exception -> L65
        if (Intrinsics.areEqual(r5, "") == false) goto L16;
        r4 = r4.appendQueryParameter("type", "popup");     // Catch: Exception -> L65
    L19:
        String r11 = "0";
        if (Intrinsics.areEqual(i2.d(r1, "gravity", "bottom"), "bottom") == false) goto L24;
        Uri.Builder r0 = r4.appendQueryParameter("radius_top_left", String.valueOf(i2.c(r1, "radius", 8))).appendQueryParameter("radius_top_right", String.valueOf(i2.c(r1, "radius", 8))).appendQueryParameter("radius_bottom_right", "0").appendQueryParameter("radius_bottom_left", "0").appendQueryParameter("gravity", "bottom");     // Catch: Exception -> L23
    L25:
        Uri.Builder r6 = r0.appendQueryParameter("type", r5).appendQueryParameter("height", String.valueOf(i2.c(r1, "height", 400))).appendQueryParameter("width", String.valueOf(i2.c(r1, "width", (int) s1.G(s1.y())))).appendQueryParameter("margin", String.valueOf(i2.c(r1, "margin", 0))).appendQueryParameter("height_percent", String.valueOf(i2.c(r1, "height_percent", 0))).appendQueryParameter("width_percent", String.valueOf(i2.c(r1, "width_percent", 0))).appendQueryParameter("rate_height", String.valueOf(i2.c(r1, "rate_height", -1)));     // Catch: Exception -> L23
        if (i2.c(r1, "pull_down_indicator_not_show", 1) != 1) goto L29;
        String r7 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L30:
        Uri.Builder r8 = r6.appendQueryParameter("pull_down_indicator_not_show", r7).appendQueryParameter("pull_down_height", String.valueOf(i2.c(r1, "pull_down_height", 0)));     // Catch: Exception -> L23
        if (i2.c(r1, "show_back", 0) != 1) goto L33;
        String r9 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L34:
        Uri.Builder r12 = r8.appendQueryParameter("show_back", r9);     // Catch: Exception -> L23
        if (i2.c(r1, "show_close", 0) != 1) goto L37;
        String r13 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L38:
        Uri.Builder r14 = r12.appendQueryParameter("show_close", r13);     // Catch: Exception -> L23
        if (i2.c(r1, "pull_down_close", 0) != 1) goto L41;
        String r15 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L42:
        Uri.Builder r16 = r14.appendQueryParameter("pull_down_close", r15);     // Catch: Exception -> L23
        if (i2.c(r1, "landscape_custom_height", 0) != 1) goto L45;
        String r17 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L46:
        Uri.Builder r18 = r16.appendQueryParameter("landscape_custom_height", r17);     // Catch: Exception -> L23
        if (i2.c(r1, "landscape_custom_width", 0) != 1) goto L49;
        String r19 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L50:
        Uri.Builder r21 = r18.appendQueryParameter("landscape_custom_width", r19).appendQueryParameter("lynx_thread", String.valueOf(i2.c(r1, "lynx_thread", 0)));     // Catch: Exception -> L23
        if (i2.c(r1, "window_floating", 1) != 1) goto L53;
        String r25 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L54:
        Uri.Builder r26 = r21.appendQueryParameter("window_floating", r25);     // Catch: Exception -> L23
        if (i2.c(r1, "abandon_coordinate", 0) != 1) goto L57;
        String r27 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L58:
        Uri.Builder r28 = r26.appendQueryParameter("abandon_coordinate", r27);     // Catch: Exception -> L23
        if (i2.c(r1, "enable_lynx_bg", 0) != 1) goto L61;
        r11 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L61:
        return showHybridDialog(r22, r28.appendQueryParameter("enable_lynx_bg", r11).build(), r24);
    L76:
        return null;
    L57:
        r27 = "0";
        goto L58
    L53:
        r25 = "0";
        goto L54
    L49:
        r19 = "0";
        goto L50
    L45:
        r17 = "0";
        goto L46
    L41:
        r15 = "0";
        goto L42
    L37:
        r13 = "0";
        goto L38
    L33:
        r9 = "0";
        goto L34
    L29:
        r7 = "0";
        goto L30
    L24:
        r0 = r4.appendQueryParameter("radius", String.valueOf(i2.c(r1, "radius", 8))).appendQueryParameter("gravity", "center");     // Catch: Exception -> L23
    L75:
        return null;
    L16:
        if ((!Intrinsics.areEqual(r5, "popup")) == false) goto L19;
        return null;
    L10:
        r4 = x6.a.a(r3);     // Catch: Exception -> L65
    L66:
        return null;
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public void stopLynxCast(HybridCard r3, String r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "hybridCard");
        Intrinsics.checkNotNullParameter(r4, "canvasId");
        View r6 = r3.getHybridView();
        if ((r6 instanceof LynxView) == true) goto L5;
        r6 = null;
    L5:
        LynxView r7 = (LynxView) r6;
        if (r7 == null) goto L12;
        w r0 = this.lynxService;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L10:
        r0.stopLynxCast(r7, r4, r5);
        return;
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public void addHybridDebugTool(Context r3, ViewGroup r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        Intrinsics.checkNotNullParameter(r5, LiveSlardarConstants.EXTRA_KEY_URL);
        w r0 = this.lynxService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L5:
        r0.addHybridDebugTool(r3, r4, r5, r6);
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public void anniePreload(KitType r11, Context r12, Uri r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r11, "kitType");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "uri");
        Intrinsics.checkNotNullParameter(r14, "bundle");
        Uri r15 = getFinalUri(r13);
        boolean r0 = AnnieNGInitHelper.a;
        v r1 = this.jsBridgeService;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L5:
        w r2 = this.lynxService;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L8:
        u r3 = this.h5Service;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L11:
        AnnieNGInitHelper.c(r1, r2, r3);
        r14.putLong("open_time", getUriEncodedStartTimeOrCurrent(r15, r14));
        if (isLocalTest() == true) goto L14;
    L29:
        Method r4 = INVOKESTATIC_com_bytedance_android_live_browser_BrowserServiceImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.android.annie.Annie").getDeclaredMethod("anniePreload", new Class[]{KitType.class, Context.class, Uri.class, Bundle.class});     // Catch: Exception -> L26
        r4.setAccessible(true);     // Catch: Exception -> L26
        r4.invoke(null, new Object[]{r11, r12, r15, r14});     // Catch: Exception -> L26
        return;
    L26:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        if (r11 != KitType.WEB) goto L29;
        r14.putBoolean("bundle_webview_debug_enable", ((Boolean) jy0.a.getValue()).booleanValue());
        r14.putBoolean("bundle_webiew_debug_inject", ((Boolean) iy0.a.getValue()).booleanValue());
        if (((Boolean) ly0.a.getValue()).booleanValue() == false) goto L22;
        IHostContext r5 = jc1.k.f(IHostContext.class);
        Intrinsics.checkNotNull(r5);
        if (r5.isBoe() == true) goto L22;
        if (((Boolean) ky0.a.getValue()).booleanValue() == true) goto L22;
        boolean r6 = true;
    L23:
        r14.putBoolean("bundle_live_webview_offline_enable", r6);
    L22:
        r6 = false;
        goto L23
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public u30.c createWebViewRecord(Activity r2, String r3, IBrowserService.PageFinishedListener r4, IBrowserService.PageErrorListener r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        com.bytedance.android.live.browser.jsbridge.h r0 = this.prefetchProcessor;
        if (r0 == null) goto L5;
        r0.prefetch(r3);
    L5:
        createWebViewRecord(r2, r4, r5);
        return null;
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public HybridCard getHybridCard(Context r8, Uri r9, b7.a r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "uri");
        Uri r0 = getFinalUri(r9);
        com.bytedance.android.live.browser.utils.h.b();
        com.bytedance.android.live.browser.utils.h.a();
        PerformanceEventKitUtil.trigger$default(PerformanceEventKitUtil.INSTANCE, "card", null, 2, null);
        if (r12 == null) goto L5;
        Bundle r1 = new Bundle(r12);
    L6:
        r1.putLong("open_time", getUriEncodedStartTimeOrCurrent(r9, r1));
        boolean r13 = AnnieNGInitHelper.a;
        v r14 = this.jsBridgeService;
        if (r14 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L9:
        w r15 = this.lynxService;
        if (r15 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L12:
        u r2 = this.h5Service;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L15:
        AnnieNGInitHelper.c(r14, r15, r2);
        return Annie.getHybridCard(r8, r0, wrapCommonLifecycle$default(this, r11, null, 2, null), r1);
    L5:
        r1 = new Bundle();
        goto L6
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public HybridFragment getHybridFragment(Context r5, Uri r6, b7.a r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "uri");
        Uri r9 = getFinalUri(r6);
        boolean r0 = AnnieNGInitHelper.a;
        v r1 = this.jsBridgeService;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L5:
        w r2 = this.lynxService;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L8:
        u r3 = this.h5Service;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L11:
        AnnieNGInitHelper.c(r1, r2, r3);
        if (r8 != null) goto L14;
        r8 = new Bundle();
    L14:
        r8.putLong("open_time", getUriEncodedStartTimeOrCurrent(r9, r8));
        return Annie.getHybridFragment(r5, r9, wrapCommonLifecycle$default(this, r7, null, 2, null), r8);
    }

    public final void prefetchMonitor(View r11, Set<String> r12, long r13, long r14) {
        Intrinsics.checkNotNullParameter(r12, "stateKeys");
        if (com.bytedance.android.annie.a.c(r9.c.class).c(r11) == true) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        r0.put("state_keys", r12.toString());
        JSONObject r6 = new JSONObject();
        r6.put("duration", r13);
        JSONObject r15 = new JSONObject();
        r15.put("duration", r14);
        w r16 = this.lynxService;
        if (r16 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L8:
        r16.getHybridMonitor().a(r11, "prefetch_to_render_monitor", "", r0, r6, null, true);
        w r17 = this.lynxService;
        if (r17 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L11:
        r17.getHybridMonitor().a(r11, "create_initial_props_monitor", "", r0, r15, null, true);
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public HybridDialog showHybridDialogWithListener(Context r8, Uri r9, b7.a r11, DialogInterface.OnDismissListener r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "uri");
        return showHybridDialog(r8, r9, r11, null, r12);
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public boolean showLitePage(Context r6, Uri r7, b7.a r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "uri");
        if (jc1.k.f(IMiddleWareHostContext.class) != null) goto L5;
        return false;
    L5:
        boolean r0 = AnnieNGInitHelper.a;
        v r1 = this.jsBridgeService;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L8:
        w r2 = this.lynxService;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L11:
        u r3 = this.h5Service;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L14:
        AnnieNGInitHelper.d(r1, r2, r3);
        IHostAction r4 = jc1.k.f(IHostAction.class);
        if (r4 == null) goto L20;
        Boolean r11 = r4.showLitePage(r6, r7, r8, r9);
        if (r11 != null) goto L19;
        return false;
    L19:
        return r11.booleanValue();
    L20:
        return false;
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public HybridCard getHybridCard(Context r3, Uri r4, int r5, b7.a r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "uri");
        Bundle r0 = new Bundle();
        r0.putInt("preset_width_px", r5);
        Unit r7 = Unit.INSTANCE;
        return getHybridCard(r3, r4, r6, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ b7.a wrapCommonLifecycle$default(BrowserServiceImpl r0, b7.a r1, Function1 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = null;
    L7:
        return r0.wrapCommonLifecycle(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: wrapCommonLifecycle");
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    /* JADX INFO: renamed from: createOpenLynxComponent, reason: collision with other method in class */
    public com.bytedance.android.live.lynx.api.d mo462createOpenLynxComponent(Context r8, int r9, LynxThreadStrategy r11, d0 r12, String r13) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r11, "threadStrategy");
        w r1 = this.lynxService;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L6:
        return r1.create(r8, Integer.valueOf(r9), r11, r12, r13);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public void reportLynxFetchJsbError(View r8, String r9, String r11, int r12, String r13) {
        Intrinsics.checkNotNullParameter(r8, "lynxView");
        Intrinsics.checkNotNullParameter(r9, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "method");
        w r1 = this.lynxService;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L5:
        if (r1 == null) goto L8;
        r1.reportLynxFetchJsbError(r8, r9, r11, r12, r13);
        return;
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public HybridDialog showHybridDialog(Context r16, Uri r17, b7.a r18, Bundle r19, DialogInterface.OnDismissListener r21) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r17, "uri");
        Uri r7 = addLiveUISpecification(getFinalUri(r17));
        com.bytedance.android.live.browser.utils.h.b();
        com.bytedance.android.live.browser.utils.h.a();
        PerformanceEventKitUtil.trigger$default(PerformanceEventKitUtil.INSTANCE, "dialog", null, 2, null);
        boolean r1 = AnnieNGInitHelper.a;
        v r2 = this.jsBridgeService;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeService");
    L5:
        w r3 = this.lynxService;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L8:
        u r4 = this.h5Service;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("h5Service");
    L11:
        AnnieNGInitHelper.c(r2, r3, r4);
        if (FoldScreenUtils.e() == false) goto L18;
        Activity r5 = ContextUtil.contextToActivity(r16);
        if (r5 == null) goto L18;
        if (e5.g(r5) != true) goto L18;
        boolean r11 = true;
    L19:
        final Ref.BooleanRef r12 = new Ref.BooleanRef();
        r12.element = isShowAnimInLandscapeEnable(r17);
        final Ref.ObjectRef r13 = new Ref.ObjectRef();
        r13.element = null;
        final Ref.ObjectRef r14 = new Ref.ObjectRef();
        r14.element = null;
        final boolean r6 = r11;
        HybridDialog r15 = Annie.showHybridDialog(r16, r7, wrapCommonLifecycle(r18, new AnonymousClass1(this, r12, r6, r14, r13)), r19);
        if (r15 == null) goto L23;
        String r8 = "HybridDialog[" + Integer.valueOf(r15.hashCode()).intValue() + ']';
        r14.element = r15;
        r13.element = r8;
        r15.T90(new d(r15, r8, this, r7, r12, r21, r11));
        return r15;
    L23:
        return null;
    L18:
        r11 = false;
        goto L19
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public long startLynxCast(HybridCard r7, String r8, Surface r9, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r7, "hybridCard");
        Intrinsics.checkNotNullParameter(r8, "canvasId");
        Intrinsics.checkNotNullParameter(r9, "surface");
        View r13 = r7.getHybridView();
        if ((r13 instanceof LynxView) == true) goto L5;
        r13 = null;
    L5:
        LynxView r1 = (LynxView) r13;
        if (r1 == null) goto L11;
        w r0 = this.lynxService;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L13:
        return r0.startLynxCast(r1, r8, r9, r11, r12);
    L11:
        return 0;
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public /* bridge */ /* synthetic */ com.bytedance.android.live.lynx.api.b createOpenLynxComponent(Context r1, int r2, LynxThreadStrategy r3, d0 r4, String r5) {
        return mo462createOpenLynxComponent(r1, r2, r3, r4, r5);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public com.bytedance.android.live.lynx.api.c createLynxComponent(Activity r9, int r11, String r12, LynxThreadStrategy r13, String r14, d0 r15) {
        Intrinsics.checkNotNullParameter(r9, "activity");
        Intrinsics.checkNotNullParameter(r12, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r13, "threadStrategy");
        Intrinsics.checkNotNullParameter(r14, "oriScheme");
        w r1 = this.lynxService;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L6:
        return r1.create(r9, Integer.valueOf(r11), r12, r13, r14, r15);
    }

    @Override // com.bytedance.android.live.browser.IBrowserService
    public com.bytedance.android.live.lynx.api.c createLynxComponent(Activity r8, int r9, String r11, boolean r12, LynxThreadStrategy r13, d0 r14) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r11, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r13, "threadStrategy");
        return createLynxComponent(r8, r9, r11, r13, "", r14);
    }

    @Override // com.bytedance.android.live.browser.IBaseBrowserService
    public void reportCustomV2(View r13, String r14, String r15, JSONObject r16, JSONObject r17, JSONObject r18, JSONObject r19, int r21) {
        w r1 = this.lynxService;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L5:
        r1.getHybridMonitor().reportCustomV2(r13, r14, r15, r16, r17, r18, r19, r21);
    }
}
