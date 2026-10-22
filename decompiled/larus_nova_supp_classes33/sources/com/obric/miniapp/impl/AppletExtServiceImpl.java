package com.obric.miniapp.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import androidx.core.util.Consumer;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.ai.api.AppletExtService;
import com.bytedance.ai.api.o;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.lynx.AISDKLynxBehaviorRegistry;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.news.common.settings.SettingsUpdateListener;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.larus.account.base.api.ILoginService;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.AppletBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.observer.MessageListState;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.t0;
import com.larus.utils.y0;
import com.larus.utils.z;
import com.lynx.tasm.LynxEnv;
import com.obric.assistant.chat.IObricChatPageStateService;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.state.api.v2.core.ObricDeviceStateDelegate;
import com.obric.capabilitykit.entity.app.MusicEntity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.miniapp.aibridge.AddContactMethod;
import com.obric.miniapp.aibridge.CalendarOperationMethod;
import com.obric.miniapp.aibridge.CloseSheetPageMethod;
import com.obric.miniapp.aibridge.DatePickerMethod;
import com.obric.miniapp.aibridge.DeleteAlarmMethod;
import com.obric.miniapp.aibridge.DeleteIcsDataMethod;
import com.obric.miniapp.aibridge.GetAlarmInfoMethod;
import com.obric.miniapp.aibridge.GetAllAlarmMethod;
import com.obric.miniapp.aibridge.GetAppVariantMethod;
import com.obric.miniapp.aibridge.GetScreenModeMethod;
import com.obric.miniapp.aibridge.IndexIcsDataMethod;
import com.obric.miniapp.aibridge.IntentCardOperationMethod;
import com.obric.miniapp.aibridge.IsSleepModeMethod;
import com.obric.miniapp.aibridge.LiveCardDestroyMethod;
import com.obric.miniapp.aibridge.LiveCardJsbSessionManager;
import com.obric.miniapp.aibridge.LiveCardShowMethod;
import com.obric.miniapp.aibridge.LiveCardUpdateMethod;
import com.obric.miniapp.aibridge.MakePhoneCallMethod;
import com.obric.miniapp.aibridge.OpenMemoryDetailMethod;
import com.obric.miniapp.aibridge.OpenSheetPageMethod;
import com.obric.miniapp.aibridge.PerformVibratorMethod;
import com.obric.miniapp.aibridge.QueryAppIconMethod;
import com.obric.miniapp.aibridge.SendSmsMethod;
import com.obric.miniapp.aibridge.SetAlarmMethod;
import com.obric.miniapp.aibridge.SetTitleBarMethod;
import com.obric.miniapp.aibridge.ShowDatePickerMethod;
import com.obric.miniapp.aibridge.ShowOptionDialogMethod;
import com.obric.miniapp.aibridge.TimePickerMethod;
import com.obric.miniapp.aibridge.UpdateModelContextMethod;
import com.obric.miniapp.aibridge.t;
import com.obric.miniapp.alarm.AlarmManager;
import com.obric.miniapp.calendar.proxy.function.AppletVersionInfo;
import com.obric.miniapp.intent.u;
import com.obric.miniapp.lynx.v5;
import com.obric.miniapp.utils.DevicePowerManager$registerSleepModeReceiver$1;
import com.obric.miniapp.utils.MiniAppUtils;
import com.obric.miniapp.utils.g1;
import com.obric.miniapp.utils.h1;
import com.obric.miniapp.utils.j1;
import com.obric.miniapp.utils.k0;
import com.obric.miniapp.utils.k1;
import com.obric.miniapp.utils.p0;
import com.obric.miniapp.utils.q0;
import com.obric.miniapp.utils.r0;
import com.obric.miniapp.utils.w0;
import com.obric.miniapp.view.MiniAppBaseActivity;
import com.obric.miniapp.view.MiniAppFragment;
import com.obric.oui.selection.OActionSheet;
import com.obric.oui.sheet.OInsetSheet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import d3.b0;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rv3.c0;
import t19.s;
import vd9.r;
import zka.p;
import zka.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000ñ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0013*\u0003\u001d 9\b\u0007\u0018\u0000 «\u00012\u00020\u0001:\u0002«\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H\u0002J\u0012\u0010%\u001a\u00020&*\u00020$H\u0082@¢\u0006\u0002\u0010'J,\u0010(\u001a\b\u0012\u0004\u0012\u00020$0)2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0082@¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u0004\u0018\u00010,*\u00020,H\u0002¢\u0006\u0002\u00101J\u0010\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u0010H\u0016J\b\u00104\u001a\u00020\u0015H\u0002J\u0010\u00105\u001a\u00020\u00152\u0006\u00103\u001a\u000206H\u0016J\b\u00107\u001a\u00020\u0015H\u0002J(\u0010;\u001a\u00020\u00152\u001e\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u00150\u000fH\u0016J\b\u0010<\u001a\u00020\u0015H\u0016J\u0010\u0010=\u001a\u00020&2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020\r2\u0006\u0010>\u001a\u00020?H\u0016J\u001a\u0010A\u001a\u00020&2\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u001e\u0010F\u001a\u00020&2\u0014\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00100HH\u0016J\u000e\u0010I\u001a\b\u0012\u0004\u0012\u00020\r0)H\u0016J\u0010\u0010J\u001a\u00020&2\u0006\u0010K\u001a\u00020\rH\u0016J\u0012\u0010L\u001a\u0004\u0018\u00010E2\u0006\u0010D\u001a\u00020EH\u0016J\u0016\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r0HH\u0016J@\u0010N\u001a\u00020&2\u0006\u0010B\u001a\u00020C2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\r0)2\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00150Q2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\u0012\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0012\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010W\u001a\u00020\rH\u0016J\u0010\u0010X\u001a\u00020\u00152\u0006\u0010Y\u001a\u00020\rH\u0016J\u0012\u0010Z\u001a\u00020\u00152\b\u0010[\u001a\u0004\u0018\u00010\rH\u0002J\u001c\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010^\u001a\u00020]2\b\u0010_\u001a\u0004\u0018\u00010]H\u0002J\u0012\u0010`\u001a\u0004\u0018\u00010]2\u0006\u0010^\u001a\u00020]H\u0002J\u0014\u0010a\u001a\u0004\u0018\u00010b2\b\u0010[\u001a\u0004\u0018\u00010\rH\u0002J\u001c\u0010c\u001a\u0004\u0018\u00010]2\b\u0010d\u001a\u0004\u0018\u00010\r2\u0006\u0010B\u001a\u00020bH\u0002J\b\u0010e\u001a\u00020&H\u0002J\b\u0010f\u001a\u00020&H\u0002J\u001c\u0010g\u001a\u0004\u0018\u00010\r2\u0006\u0010h\u001a\u00020]2\b\u0010i\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010j\u001a\u0004\u0018\u00010]2\u0006\u0010k\u001a\u00020\rH\u0002J-\u0010l\u001a\u0004\u0018\u00010]2\b\u0010m\u001a\u0004\u0018\u00010]2\u0012\u0010n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0o\"\u00020\rH\u0002¢\u0006\u0002\u0010pJ\u0010\u0010q\u001a\u00020\r2\u0006\u0010k\u001a\u00020\rH\u0002J\u001b\u0010r\u001a\u0004\u0018\u00010s2\n\u0010t\u001a\u00060uj\u0002`vH\u0002¢\u0006\u0002\u0010wJ\u001f\u0010x\u001a\u0004\u0018\u00010s2\u0006\u0010y\u001a\u00020\r2\u0006\u0010z\u001a\u00020.H\u0002¢\u0006\u0002\u0010{J6\u0010|\u001a\u00020\u00152\u0006\u0010}\u001a\u00020\r2\b\u0010~\u001a\u0004\u0018\u00010\r2\u0006\u0010\u007f\u001a\u00020]2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\r2\u0007\u0010\u0081\u0001\u001a\u00020]H\u0002J&\u0010\u0082\u0001\u001a\u00020\r2\u0007\u0010\u0083\u0001\u001a\u00020\r2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\r2\u0007\u0010\u0085\u0001\u001a\u00020\rH\u0002J$\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020\r0)2\b\u0010~\u001a\u0004\u0018\u00010\r2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\rH\u0002J\u0016\u0010\u0087\u0001\u001a\u0004\u0018\u00010\r2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\rH\u0002J\u0014\u0010\u0088\u0001\u001a\u00020&2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\rH\u0002J4\u0010\u0089\u0001\u001a\u0004\u0018\u00010\r2\u0006\u0010h\u001a\u00020]2\u0007\u0010\u008a\u0001\u001a\u00020]2\u0007\u0010\u008b\u0001\u001a\u00020]2\r\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020\r0)H\u0002J7\u0010\u008d\u0001\u001a\u00020\u00152\u0006\u0010}\u001a\u00020\r2\b\u0010~\u001a\u0004\u0018\u00010\r2\u0006\u0010\u007f\u001a\u00020]2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\r2\u0007\u0010\u0081\u0001\u001a\u00020]H\u0002J\u001d\u0010\u008e\u0001\u001a\u00020&2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\r2\u0007\u0010\u0085\u0001\u001a\u00020\rH\u0002J\u0012\u0010\u008f\u0001\u001a\u00020\u00152\u0007\u0010\u008b\u0001\u001a\u00020]H\u0002J\u0012\u0010\u0090\u0001\u001a\u00020\u00152\u0007\u0010\u008b\u0001\u001a\u00020]H\u0002J\u0012\u0010\u0091\u0001\u001a\u00020\r2\u0007\u0010\u008b\u0001\u001a\u00020]H\u0002J#\u0010\u0092\u0001\u001a\u00020]2\u0006\u0010y\u001a\u00020\r2\u0007\u0010\u0093\u0001\u001a\u00020.2\u0007\u0010\u0094\u0001\u001a\u00020\rH\u0002J(\u0010\u0095\u0001\u001a\u00020\r2\u0017\u0010\u0096\u0001\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0o\"\u0004\u0018\u00010\rH\u0002¢\u0006\u0003\u0010\u0097\u0001Jf\u0010\u0098\u0001\u001a\u00030\u0099\u00012\u0006\u0010}\u001a\u00020\r2\u0006\u0010~\u001a\u00020\r2\u0006\u0010\u007f\u001a\u00020]2\u0007\u0010\u0080\u0001\u001a\u00020\r2\u0007\u0010\u0081\u0001\u001a\u00020]2\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010&2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010,2\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\r2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0003\u0010\u009e\u0001J3\u0010\u009f\u0001\u001a\u00030\u0099\u00012\u0006\u0010}\u001a\u00020\r2\t\u0010 \u0001\u001a\u0004\u0018\u00010]2\t\u0010¡\u0001\u001a\u0004\u0018\u00010]2\t\u0010¢\u0001\u001a\u0004\u0018\u00010\rH\u0016J\u001d\u0010£\u0001\u001a\u00030\u0099\u00012\u0006\u0010}\u001a\u00020\r2\t\u0010¤\u0001\u001a\u0004\u0018\u00010\rH\u0016J\t\u0010¥\u0001\u001a\u00020&H\u0016J\t\u0010¦\u0001\u001a\u00020\u0015H\u0002J\t\u0010§\u0001\u001a\u00020\u0015H\u0002J\t\u0010¨\u0001\u001a\u00020\u0015H\u0002J\u0012\u0010©\u0001\u001a\u00020\u00152\u0007\u0010ª\u0001\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000RL\u0010\u000e\u001a@\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000fj\u0004\u0018\u0001`\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\u0018\u001a&\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\r0\r \u001a*\u0012\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\r0\r\u0018\u00010\u001b0\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u0010\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0004\n\u0002\u0010:¨\u0006¬\u0001"}, d2 = {"Lcom/obric/miniapp/impl/AppletExtServiceImpl;", "Lcom/bytedance/ai/api/AppletExtService;", "<init>", "()V", "hasInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasLoaded", "hasRegisterLiveIslandReceiver", "hasRegisterLynxBehaviors", "liveIslandAnnouncementScope", "Lkotlinx/coroutines/CoroutineScope;", "musicCardAutoplayScope", "currentUid", "", "deleteAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "widgetContainer", "Lkotlin/Function0;", "", "callback", "Lcom/bytedance/applet/model/menu/SystemMenuItemAction;", "appList", "", "kotlin.jvm.PlatformType", "", "accountStatusListener", "com/obric/miniapp/impl/AppletExtServiceImpl$accountStatusListener$1", "Lcom/obric/miniapp/impl/AppletExtServiceImpl$accountStatusListener$1;", "listener", "com/obric/miniapp/impl/AppletExtServiceImpl$listener$1", "Lcom/obric/miniapp/impl/AppletExtServiceImpl$listener$1;", "handleMusicDecodeCardAutoplay", "message", "Lcom/larus/im/bean/message/Message;", "isLatestRoundReply", "", "(Lcom/larus/im/bean/message/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLocalMessagePage", "", "conversationId", "maxIndex", "", "limit", "", "(Ljava/lang/String;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toEpochMillis", "(J)Ljava/lang/Long;", "processAISDKConfig", "config", "registerLynxBehaviorsIfNeeded", "init", "Lcom/bytedance/ai/api/AppletAppConfig;", "registerLiveIslandReceiverOnce", "liveIslandNotifyReceiver", "com/obric/miniapp/impl/AppletExtServiceImpl$liveIslandNotifyReceiver$1", "Lcom/obric/miniapp/impl/AppletExtServiceImpl$liveIslandNotifyReceiver$1;", "injectWidgetMenuAction", "notifyChatWillReady", "checkIsAppletAppActivity", "activity", "Landroid/app/Activity;", "getAppletAppId", "interceptNavigation", "context", "Landroid/content/Context;", "args", "Landroid/os/Bundle;", "openAppletApp", "params", "", "getAlarmListWithKeepStatus", "triggerCalendarSync", "userId", "processRequest", "getLastPageInfo", "showMapSelectDialog", "optionList", "selectedCallback", "Lkotlin/Function1;", "cancelCallback", "obtainWidgetLongClickListener", "Landroid/view/View$OnLongClickListener;", "createAppletAppFragment", "Landroidx/fragment/app/Fragment;", "appId", "updateAppList", "appletId", "handleLiveIslandNotifyData", "data", "parseLiveIslandPayload", "Lorg/json/JSONObject;", "root", "businessJson", "parseBusinessDataJson", "parseLiveIslandNotifyContext", "Lcom/obric/miniapp/impl/LiveIslandNotifyContext;", "buildLiveIslandAnnouncementRequest", "rawData", "shouldPlayLiveIslandAnnouncement", "isKeyguardLocked", "resolveLiveIslandSessionKey", "payload", "businessNoticeId", "parseLiveIslandStringPayload", "raw", "readLiveIslandPayload", "json", "keys", "", "(Lorg/json/JSONObject;[Ljava/lang/String;)Lorg/json/JSONObject;", "sanitizeLiveIslandJsonString", "lastNonSpaceChar", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "(Ljava/lang/StringBuilder;)Ljava/lang/Character;", "nextNonSpaceChar", "text", "start", "(Ljava/lang/String;I)Ljava/lang/Character;", "showOrUpdateLiveIslandCard", "sessionKey", "collapseTemplateId", "collapseTemplateData", "expandTemplateId", "expandTemplateData", "resolveLiveIslandTemplateId", "namespace", "templateId", "fallbackTemplateId", "resolveLiveIslandNamespaces", "extractLiveIslandNamespace", "shouldPreferAppletLiveIslandNamespace", "resolveLiveIslandPayloadTemplateId", "islandBizData", "nodeData", "preferredKeys", "applyLiveIslandCommonTemplateCompat", "shouldUseCommonLiveIslandTemplate", "ensureCommonCollapseTemplateData", "ensureCommonExpandTemplateData", "buildCommonExpandContent", "buildLiveIslandText", "textSize", "textColor", "firstNonBlank", "candidates", "([Ljava/lang/String;)Ljava/lang/String;", "showLiveCardByKey", "Lcom/bytedance/ai/api/LiveCardClientResult;", "canFrontShow", "autoDismissDurationMs", "traceBiz", "traceId", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/ai/api/LiveCardClientResult;", "updateLiveCardByKey", "collapsePatch", "expandPatch", "mode", "destroyLiveCardByKey", WindowEvent.Params.REASON, "dismissMapSelectDialog", "onUpdateFinish", "initMiniAppList", "autoLoadApplet", "realLoadApplet", "packageName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletExtServiceImpl implements AppletExtService {
    public static final /* synthetic */ int l = 0;
    public final AtomicBoolean a;
    public final AtomicBoolean b;
    public final AtomicBoolean c;
    public final AtomicBoolean d;
    public final CoroutineScope e;
    public final CoroutineScope f;
    public Function2<Object, ? super Function0<Unit>, Unit> g;
    public final Set<String> h;
    public final AppletExtServiceImpl$accountStatusListener$1 i;
    public final c j;
    public final AppletExtServiceImpl$liveIslandNotifyReceiver$1 k;

    public static final class a {
    }

    public static final class b implements SettingsUpdateListener {
        public final /* synthetic */ AppletExtServiceImpl a;

        public b(AppletExtServiceImpl r1) {
            this.a = r1;
        }

        public final void onSettingsUpdate(SettingsData r3) {
            com.bytedance.ai.utils.g.a.i("MiniAppService", "onSettingsUpdate");
            AppletExtServiceImpl r4 = this.a;
            int r0 = AppletExtServiceImpl.l;
            r4.v();
        }
    }

    public static final class c implements nf9.b {
        public final /* synthetic */ AppletExtServiceImpl a;

        public final void a(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void f(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void onMessageListReplaced(String r2, List<Message> r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "oldMsgList");
            Intrinsics.checkNotNullParameter(r4, "newMsgList");
        }

        public c(AppletExtServiceImpl r1) {
            this.a = r1;
        }

        public final void d(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
            AppletExtServiceImpl.a(this.a, r3);
        }

        public final void b(String r2, MessageListState r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "state");
            Intrinsics.checkNotNullParameter(r4, "msgList");
            if (r3 != MessageListState.INSERT) goto L8;
            AppletExtServiceImpl r5 = this.a;
            Iterator<T> r6 = r4.iterator();
        L6:
            if (r6.hasNext() == false) goto L10;
            AppletExtServiceImpl.a(r5, (Message) r6.next());
            goto L6
        L10:
            return;
        }

        public final void c(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
            AppletExtServiceImpl.a(this.a, r2);
        }

        public final void e(String r2, Message r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
            AppletExtServiceImpl.a(this.a, r3);
            com.bytedance.ai.utils.c.a r5 = (com.bytedance.ai.utils.c.a) CollectionsKt.lastOrNull(com.bytedance.ai.utils.c.a);
            if (r5 != null) goto L6;
            return;
        L6:
            if (r5.d == false) goto L8;
            return;
        L8:
            Gson r6 = z.a;
            JSONObject r7 = z.b(r3.getContent());
            String r8 = null;
            if (r7 == null) goto L11;
            String r0 = r7.optString("mcpName");
        L12:
            if (r7 == null) goto L15;
            r8 = r7.optString("widget_data");
        L15:
            if (Intrinsics.areEqual(r0, r5.a.getMcpName()) == true) goto L17;
            return;
        L17:
            if (r5.a.getFullScreenRefresh() == null) goto L26;
            k2.j r9 = (k2.j) r5.b.get();
            if (r9 == null) goto L23;
            b0 r10 = r9.getAIBridge();
            if (r10 == null) goto L23;
            JsonObject r11 = new JsonObject();
            r11.addProperty("viewData", r8);
            Unit r12 = Unit.INSTANCE;
            r10.a("viewDataChanged", r11);
        L23:
            s.a.g(AppHost.a.getApplication().getApplicationContext(), 2131911815, false);
            return;
        L26:
            return;
        L11:
            r0 = null;
            goto L12
        }
    }

    static {
    }

    public final boolean n() {
        return false;
    }

    public final List<String> d() {
        return CollectionsKt.listOf("alarm_channel");
    }

    public final void e() {
        if (ObricFeatureServiceDelegate.b.c() == true) goto L5;
        return;
    L5:
        if (ILoginService.a.getAccountInfo().a == false) goto L9;
        MiniAppUtils r0 = MiniAppUtils.a;
        MiniAppUtils.h(AppHost.a.getApplication().getApplicationContext());
        return;
    }

    public final Map<String, String> j() {
        HashMap r0 = new HashMap();
        com.bytedance.ai.utils.c.a r1 = (com.bytedance.ai.utils.c.a) CollectionsKt.lastOrNull(com.bytedance.ai.utils.c.a);
        if (r1 != null) goto L6;
        return r0;
    L6:
        if (r1.d == false) goto L8;
        return r0;
    L8:
        PageInfo r2 = r1.a;
        r0.put("o_mcp_name", r2.getMcpName());
        r0.put("o_full_screen_refresh", r2.getFullScreenRefresh());
        return r0;
    }

    public final void u() {
        com.obric.miniapp.settings.b.a.getClass();
        List<String> r0 = com.obric.miniapp.settings.b.b().miniAppConfig().a();
        if (r0 == null) goto L8;
        List r1 = CollectionsKt.filterNotNull(r0);
        this.h.addAll(r1);
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        String r3 = (String) r2.next();
        AIManager r4 = AIManager.a;
        Intrinsics.checkNotNullParameter(r3, "appId");
        n5.a.a.getClass();
        AIManager.o.add(r3);
        AIManager.f(r3);
        goto L6
    L10:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.obric.miniapp.impl.AppletExtServiceImpl$accountStatusListener$1] */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.obric.miniapp.impl.AppletExtServiceImpl$liveIslandNotifyReceiver$1] */
    public AppletExtServiceImpl() {
        this.a = new AtomicBoolean(false);
        this.b = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.e = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.h = Collections.newSetFromMap(new ConcurrentHashMap());
        this.i = new AppletExtServiceImpl$accountStatusListener$1();
        this.j = new c(this);
        this.k = new AppletExtServiceImpl$liveIslandNotifyReceiver$1(this);
    }

    public final void v() {
        u();
        if (this.b.compareAndSet(false, true) == false) goto L13;
        com.obric.miniapp.settings.b.a.getClass();
        List<String> r0 = com.obric.miniapp.settings.b.b().miniAppConfig().b();
        if (r0 == null) goto L10;
        Iterator<T> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        x((String) r1.next());
    L10:
        com.bytedance.ai.utils.g.a.i("MiniAppSettingsManager", "autoLaunchList");
        return;
    }

    public static String t(String... r5) {
        int r0 = r5.length;
        int r2 = 0;
    L3:
        String r3 = "";
        if (r2 >= r0) goto L19;
        String r4 = r5[r2];
        if (r4 == null) goto L8;
        String r6 = StringsKt.trim(r4).toString();
    L9:
        if (r6 == null) goto L13;
        r3 = r6;
    L13:
        if (r3.length() <= 0) goto L15;
        boolean r7 = true;
    L16:
        if (r7 == true) goto L17;
        r2 = r2 + 1;
        goto L3
    L17:
        return r3;
    L15:
        r7 = false;
        goto L16
    L8:
        r6 = null;
        goto L9
    L19:
        return "";
    }

    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "appletId");
        if (this.h.add(r4) == false) goto L5;
        com.bytedance.ai.utils.g.a.d("MiniAppService", "add new app " + r4 + " into appList");
    L5:
        AIManager r0 = AIManager.a;
        AIManager.f(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String g(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        if ((r2 instanceof MiniAppBaseActivity) == true) goto L7;
        return "";
    L7:
        return ((MiniAppBaseActivity) r2).P1();
    }

    public final boolean h(Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r11, "params");
        Bundle r0 = new Bundle();
        Iterator<Map.Entry<String, ? extends Object>> r12 = r11.entrySet().iterator();
    L3:
        boolean r2 = true;
        if (r12.hasNext() == false) goto L79;
        Map.Entry<String, ? extends Object> r1 = r12.next();
        String r3 = r1.getKey();
        Object r4 = r1.getValue();
        if (r4 == null) goto L3;
        if ((r4 instanceof String) == true) goto L9;
        if ((r4 instanceof Integer) == true) goto L12;
        if ((r4 instanceof Long) == true) goto L15;
        if ((r4 instanceof Boolean) == true) goto L18;
        if ((r4 instanceof Float) == true) goto L21;
        if ((r4 instanceof Double) == true) goto L24;
        if ((r4 instanceof Bundle) == true) goto L27;
        if ((r4 instanceof Parcelable) == true) goto L30;
        if ((r4 instanceof Serializable) == true) goto L33;
        if ((r4 instanceof int[]) == true) goto L36;
        if ((r4 instanceof long[]) == true) goto L39;
        if ((r4 instanceof boolean[]) == true) goto L42;
        if ((r4 instanceof float[]) == true) goto L45;
        if ((r4 instanceof double[]) == true) goto L48;
        if ((r4 instanceof ArrayList) == false) goto L3;
        ArrayList<String> r5 = (ArrayList) r4;
        if (r5.isEmpty() == true) goto L3;
        Iterable r6 = (Iterable) r4;
        boolean r7 = r6 instanceof Collection;
        if (r7 == true) goto L56;
    L58:
        Iterator r8 = r6.iterator();
    L60:
        if (r8.hasNext() == false) goto L64;
        if ((r8.next() instanceof String) == true) goto L60;
        boolean r9 = false;
    L65:
        if (r9 == true) goto L66;
        if (r7 == true) goto L69;
    L71:
        Iterator r10 = r6.iterator();
    L73:
        if (r10.hasNext() == false) goto L77;
        if ((r10.next() instanceof Parcelable) == true) goto L73;
        r2 = false;
    L77:
        if (r2 == false) goto L3;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type java.util.ArrayList<android.os.Parcelable>");
        r0.putParcelableArrayList(r3, r5);
        goto L3
    L69:
        if (((Collection) r6).isEmpty() == false) goto L71;
    L66:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
        r0.putStringArrayList(r3, r5);
    L64:
        r9 = true;
        goto L65
    L56:
        if (((Collection) r6).isEmpty() == false) goto L58;
    L48:
        r0.putDoubleArray(r3, (double[]) r4);
        goto L3
    L45:
        r0.putFloatArray(r3, (float[]) r4);
        goto L3
    L42:
        r0.putBooleanArray(r3, (boolean[]) r4);
        goto L3
    L39:
        r0.putLongArray(r3, (long[]) r4);
        goto L3
    L36:
        r0.putIntArray(r3, (int[]) r4);
        goto L3
    L33:
        r0.putSerializable(r3, (Serializable) r4);
        goto L3
    L30:
        r0.putParcelable(r3, (Parcelable) r4);
        goto L3
    L27:
        r0.putBundle(r3, (Bundle) r4);
        goto L3
    L24:
        r0.putDouble(r3, ((Number) r4).doubleValue());
        goto L3
    L21:
        r0.putFloat(r3, ((Number) r4).floatValue());
        goto L3
    L18:
        r0.putBoolean(r3, ((Boolean) r4).booleanValue());
        goto L3
    L15:
        r0.putLong(r3, ((Number) r4).longValue());
        goto L3
    L12:
        r0.putInt(r3, ((Number) r4).intValue());
        goto L3
    L9:
        r0.putString(r3, (String) r4);
        goto L3
    L79:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r13 = AppletRuntimeManager.d;
        if (r13 == null) goto L82;
        Context r14 = r13.currentActivity();
    L83:
        if (r14 != null) goto L86;
        r14 = AppHost.a.getApplication().getApplicationContext();
    L86:
        Intrinsics.checkNotNull(r14);
        if (p(r14, r0) == false) goto L90;
        return true;
    L90:
        if ((r14 instanceof Application) == false) goto L97;
        g2.b r15 = AppletRuntimeManager.d;
        if (r15 == null) goto L97;
        Activity r16 = r15.currentActivity();
        if (r16 == null) goto L97;
        r14 = r16;
    L97:
        com.bytedance.router.i r17 = SmartRouter.buildRoute(r14, "//flow/applet");
        r17.c.putExtras(r0);
        r17.d = 2130772401;
        r17.e = 2130772399;
        r17.d();
        return true;
    L82:
        r14 = null;
        goto L83
    }

    public final boolean i(String r12) {
        Intrinsics.checkNotNullParameter(r12, "userId");
        if (StringsKt.isBlank(r12) == false) goto L6;
        com.bytedance.ai.utils.g.a.w("MiniAppService", "triggerCalendarSync failed: blank userId");
        return false;
    L6:
        final JsonObject r1 = new JsonObject();
        r1.addProperty("userId", r12);
        AppletRuntimeManager.o(AppletRuntimeManager.INSTANCE, "com.flow.calendar", "SYSTEM_CVS_ID", "SYSTEM_CVS_ID", null, null, null, new com.obric.miniapp.impl.a(r1), 56);
        return true;
    }

    public final void k(Function2<Object, ? super Function0<Unit>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "deleteAction");
        this.g = r2;
    }

    public final View.OnLongClickListener l(Object r46) {
        Intrinsics.checkNotNullParameter(r46, "widgetContainer");
        Function1<WidgetContainer, Unit> r3 = null;
        if ((r46 instanceof WidgetContainer) == false) goto L5;
        WidgetContainer r1 = (WidgetContainer) r46;
    L6:
        if (r1 == null) goto L19;
        Widget r2 = r1.x();
        if (r2 == null) goto L19;
        if (this.h.contains(((AIPackage) r2).b) == false) goto L19;
        final j1 r4 = new j1(r1);
        ot8.a r5 = new l0(2131907182, 2131907182, null, null, null, 2131102650, null, null, null, false, false, null, 2131241933, null, false, false, null, null, "delete", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528420, 127);
        final Function2<Object, ? super Function0<Unit>, Unit> r6 = this.g;
        if (r6 == null) goto L14;
        r3 = new d(r6);
    L14:
        Intrinsics.checkNotNullParameter(r5, "item");
        if (r3 == null) goto L18;
        r4.b.put(r5, r3);
    L18:
        return new h1(r4);
    L19:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    public final Fragment m(String r2) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        if (this.h.contains(r2) == true) goto L7;
        return null;
    L7:
        return new MiniAppFragment();
    }

    public final boolean o(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return r2 instanceof MiniAppBaseActivity;
    }

    public final Bundle q(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "args");
        return com.obric.miniapp.request.b.a(r2);
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [com.obric.miniapp.utils.DevicePowerManager$registerSleepModeReceiver$1] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.obric.miniapp.impl.e] */
    public final void r(final com.bytedance.ai.api.a r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        if (ObricFeatureServiceDelegate.b.c() == true) goto L5;
        return;
    L5:
        if (this.a.compareAndSet(false, true) == true) goto L7;
        return;
    L7:
        com.obric.miniapp.settings.b r1 = com.obric.miniapp.settings.b.a;
        final ?? r4 = new e(this);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "config");
        com.obric.miniapp.settings.b.b = r10.k;
        com.bytedance.ai.utils.g.a.d("MiniAppSettingsManager", "init MiniAppSettingsManager");
        com.obric.miniapp.settings.b.a().a = new com.obric.miniapp.settings.a(r10, r4);
        u();
        com.obric.miniapp.settings.b.a().d(new b(this), false);
        com.obric.miniapp.settings.b.a().e(true);
        yka.a r0 = yka.a.b;
        Context r11 = r10.a;
        Consumer<AppletVersionInfo> r2 = new f(this);
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r2, "observer");
        q r5 = yka.a.c;
        if (r5.e.b(r5.a) == false) goto L10;
        zka.a r6 = r5.d;
    L11:
        if (r6 == null) goto L37;
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r2, "observer");
        if (StringsKt.isBlank("com.flow.calendar") == false) goto L15;
    L18:
        String r3 = null;
    L19:
        if (r3 == null) goto L36;
        Context r12 = r11.getApplicationContext();
        Intrinsics.checkNotNull(r12);
        if (r6.a.compareAndSet(false, true) == false) goto L28;
        zka.b r7 = new zka.b(r6, new Handler(Looper.getMainLooper()));
        Uri r8 = UriProtector.parse("content://com.obric.appletapp.SystemAppletProvider").buildUpon().appendPath("ai_package_version").build();
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L26
        r12.getContentResolver().registerContentObserver(r8, true, r7);     // Catch: Throwable -> L26
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L28:
        ConcurrentHashMap<String, CopyOnWriteArraySet<Consumer<AppletVersionInfo>>> r14 = r6.b;
        CopyOnWriteArraySet<Consumer<AppletVersionInfo>> r15 = r14.get(r3);
        if (r15 != null) goto L34;
        r15 = new CopyOnWriteArraySet();
        CopyOnWriteArraySet<Consumer<AppletVersionInfo>> r16 = r14.putIfAbsent(r3, r15);
        if (r16 == null) goto L34;
        r15 = r16;
    L34:
        r15.add(r2);
        goto L37
    L36:
        throw new IllegalArgumentException("Invalid arguments: packageName/appId must both be null for global observing, or both be non-blank for exact observing. Current: packageName=com.flow.calendar, appId=com.flow.calendar");
    L15:
        if (StringsKt.isBlank("com.flow.calendar") == true) goto L18;
        r3 = "com.flow.calendar|com.flow.calendar";
    L37:
        ILoginService r17 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r17 == null) goto L40;
        r17.f(this.i, Boolean.FALSE);
    L40:
        com.larus.im.d.e().registerOnGlobalMessageObserver(this.j);
        AlarmManager.a.getClass();
        AlarmManager.k();
        boolean r18 = k0.a;
        ObricDeviceStateDelegate.b.b(new com.obric.miniapp.utils.l0());
        Object r19 = k0.d.getValue();     // Catch: Exception -> L50
        if (r19 == null) goto L52;
        Object r20 = r19.getClass().getMethod("inSleepMode", new Class[0]).invoke(r19, new Object[0]);     // Catch: Exception -> L50
        if ((r20 instanceof Boolean) == false) goto L46;
        Boolean r21 = (Boolean) r20;     // Catch: Exception -> L50
    L47:
        if (r21 == null) goto L52;
        boolean r22 = r21.booleanValue();     // Catch: Exception -> L50
    L53:
        k0.a = r22;
        FLogger r23 = FLogger.a;
        r23.d("DevicePowerManager", "Initial screenMode: ".concat(k0.e()));
        r23.d("DevicePowerManager", "Initial isDeviceSleeping: " + k0.a);
        DevicePowerManager$registerSleepModeReceiver$1 r24 = k0.c;
        if (r24 != null) goto L87;
    L64:
        k0.c = new DevicePowerManager$registerSleepModeReceiver$1();
    L71:
        e = move-exception;
        FLogger.a.e("DevicePowerManager", "Failed to register sleep mode receiver", e);
    L73:
        String r110 = com.obric.miniapp.utils.c.a;
        boolean r111 = k0.a;
        com.obric.miniapp.utils.c.b r112 = com.obric.miniapp.utils.c.c;
        Intrinsics.checkNotNullParameter(r112, "listener");
        k0.e.add(r112);
        com.obric.miniapp.utils.c.a r113 = com.obric.miniapp.utils.c.d;
        Intrinsics.checkNotNullParameter(r113, "listener");
        k0.f.add(r113);
        com.obric.miniapp.utils.c.a = k0.e();
        com.obric.miniapp.utils.c.b = Boolean.valueOf(k0.a);
        FLogger.a.i("AppletEventCenter", "AppletEventCenter initialized with screenMode: " + com.obric.miniapp.utils.c.a + ", deviceSleeping: " + com.obric.miniapp.utils.c.b);
        if (this.c.compareAndSet(false, true) == false) goto L77;
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).registerReceiver(this.k, new IntentFilter("com.larus.chat.action.live_island_notify"));
        com.bytedance.ai.utils.g.a.i("MiniAppService", "live island receiver registered");
    L77:
        f3.k r114 = f3.k.b;
        r114.b(CloseSheetPageMethod.class);
        r114.b(DatePickerMethod.class);
        r114.b(OpenSheetPageMethod.class);
        r114.b(ShowDatePickerMethod.class);
        r114.b(TimePickerMethod.class);
        r114.b(LiveCardShowMethod.class);
        r114.b(LiveCardUpdateMethod.class);
        r114.b(LiveCardDestroyMethod.class);
        r114.b(SetAlarmMethod.class);
        r114.b(DeleteAlarmMethod.class);
        r114.b(GetAllAlarmMethod.class);
        r114.b(GetAlarmInfoMethod.class);
        r114.b(GetScreenModeMethod.class);
        r114.b(IsSleepModeMethod.class);
        r114.b(CalendarOperationMethod.class);
        r114.b(IntentCardOperationMethod.class);
        r114.b(GetAppVariantMethod.class);
        r114.b(PerformVibratorMethod.class);
        r114.b(QueryAppIconMethod.class);
        r114.b(IndexIcsDataMethod.class);
        r114.b(DeleteIcsDataMethod.class);
        r114.b(OpenMemoryDetailMethod.class);
        r114.b(UpdateModelContextMethod.class);
        r114.b(ShowOptionDialogMethod.class);
        r114.b(MakePhoneCallMethod.class);
        r114.b(SendSmsMethod.class);
        r114.b(AddContactMethod.class);
        r114.b(SetTitleBarMethod.class);
        return;
    L66:
        if (Build.VERSION.SDK_INT < 33) goto L68;
        int r25 = 2;
    L69:
        k0.b(AppHost.a.getApplication(), k0.c, new IntentFilter("com.bytedanceos.action.SLEEP_MODE_CHANGED"), t0.b, r25);     // Catch: Exception -> L71
        goto L73
    L68:
        r25 = 0;
        goto L69
    L87:
        k0.c(AppHost.a.getApplication(), r24);     // Catch: Throwable -> L57 Exception -> L59
    L61:
        k0.c = null;
        goto L64
    L59:
        e = move-exception;
        FLogger.a.w("DevicePowerManager", "Failed to unregister sleep mode receiver", e);     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        k0.c = null;
        throw th;
    L46:
        r21 = null;
    L52:
        r22 = false;
    L50:
        e = move-exception;
        FLogger.a.w("DevicePowerManager", "Failed to check sleep mode", e);
        goto L52
    L10:
        r6 = null;
        goto L11
    }

    public final void s(Object r14) {
        Intrinsics.checkNotNullParameter(r14, "config");
        if (Build.VERSION.SDK_INT >= 30) goto L6;
        return;
    L6:
        if (this.d.compareAndSet(false, true) == false) goto L36;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L10
        Object r16 = Result.constructor-impl(v5.a());     // Catch: Throwable -> L10
    L12:
        Throwable r0 = Result.exceptionOrNull-impl(r16);
        if (r0 != null) goto L26;
        Map r17 = (Map) r16;
        Iterator r1 = r17.entrySet().iterator();     // Catch: Throwable -> L21
    L17:
        if (r1.hasNext() == false) goto L19;
        Map.Entry r3 = (Map.Entry) r1.next();     // Catch: Throwable -> L21
        String r4 = (String) r3.getKey();     // Catch: Throwable -> L21
        com.lynx.tasm.behavior.a r5 = (com.lynx.tasm.behavior.a) r3.getValue();     // Catch: Throwable -> L21
        LynxEnv.inst().addBehavior(r5);     // Catch: Throwable -> L21
        AISDKLynxBehaviorRegistry.registerBehavior(r4, r5);     // Catch: Throwable -> L21
        goto L17
    L19:
        com.bytedance.ai.utils.g.a.i("MiniAppService", "registerLynxBehaviors success tags=" + CollectionsKt.joinToString$default(r17.keySet(), ",", null, null, 0, null, null, 62, null));     // Catch: Throwable -> L21
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L33;
        this.d.set(false);
        com.bytedance.ai.utils.g.a.w("MiniAppService", "registerLynxBehaviors failed", r19);
        return;
    L33:
        return;
    L21:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L26:
        this.d.set(false);
        com.bytedance.ai.utils.g.a.w("MiniAppService", "build MiniApp Lynx behaviors failed", r0);
        return;
    L10:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final void x(final String r10) {
        b(r10);
        AppletRuntimeManager r0 = AppletRuntimeManager.INSTANCE;
        r0.getClass();
        if (AppletRuntimeManager.i("SYSTEM_CVS_ID", "SYSTEM_CVS_ID", r10) != null) goto L6;
        AppletRuntimeManager.o(r0, r10, "SYSTEM_CVS_ID", "SYSTEM_CVS_ID", "", null, null, new h(r10), 48);
        return;
    }

    public static boolean A(String r4, String r5) {
        if (r4 == null) goto L5;
        String r6 = StringsKt.trim(r4).toString();
    L6:
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        if (r6.length() != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        return true;
    L14:
        if (Intrinsics.areEqual(r6, r5) == false) goto L16;
        return true;
    L16:
        if (StringsKt.endsWith$default(r6, ":".concat(r5), false, 2, null) == true) goto L22;
        return false;
    L22:
        return true;
    L11:
        r1 = false;
        goto L12
    L5:
        r6 = null;
        goto L6
    }

    public static final void a(AppletExtServiceImpl r16, Message r17) {
        r16.getClass();
        LinkedHashSet r0 = new LinkedHashSet();
        String r1 = r17.getContent();
        if (r1 != null) goto L5;
    L10:
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Iterator r2 = r.a(r17).iterator();
    L12:
        if (r2.hasNext() == false) goto L26;
        BlockContent r4 = ((Block) r2.next()).getContent();
        if (r4 == null) goto L12;
        AppletBlock r5 = r4.getAppletBlock();
        if (r5 == null) goto L12;
        String r6 = r5.renderData;
        if (r6 == null) goto L12;
        if ((!StringsKt.isBlank(r6)) == true) goto L23;
        r6 = null;
    L23:
        if (r6 == null) goto L12;
        r0.add(r6);
        goto L12
    L26:
        if (r0.isEmpty() == true) goto L196;
        long r7 = r17.getCreateTime();
        if (r7 > 0) goto L32;
        Long r8 = null;
    L35:
        u r3 = u.a;
        Iterator r9 = r0.iterator();
    L37:
        if (r9.hasNext() == false) goto L124;
        String r10 = (String) r9.next();
        r3.getClass();
        if (r10 != null) goto L41;
    L44:
        boolean r11 = true;
    L45:
        if (r11 == false) goto L164;
    L64:
        u.a r12 = null;
    L108:
        u.a r13 = r12;
    L122:
        if (r13 == null) goto L37;
        u.a r14 = r13;
    L125:
        if (r14 == null) goto L197;
        String r15 = r17.getLocalMessageId();
        if (r15 != null) goto L130;
        r15 = "";
    L130:
        com.obric.miniapp.intent.s r18 = com.obric.miniapp.intent.s.d;
        String r19 = r14.a;
        monitor-enter(r18);
        Intrinsics.checkNotNullParameter(r19, "cardId");     // Catch: Throwable -> L155
        Intrinsics.checkNotNullParameter(r15, "localMessageId");     // Catch: Throwable -> L155
        if (StringsKt.isBlank(r19) == false) goto L135;
    L152:
        monitor-exit(r18);
    L153:
        BuildersKt.launch$default(r16.f, null, null, new AppletExtServiceImpl$handleMusicDecodeCardAutoplay$4(r14, r16, r17, r8, null), 3, null);
        return;
    L135:
        if (StringsKt.isBlank(r15) == true) goto L152;
        String r20 = r18.b.remove(r19);     // Catch: Throwable -> L155
        if (r20 == null) goto L140;
        String r21 = r18.c.remove(r20);     // Catch: Throwable -> L155
    L140:
        String r22 = r18.c.remove(r15);     // Catch: Throwable -> L155
        if (r22 == null) goto L143;
        String r23 = r18.b.remove(r22);     // Catch: Throwable -> L155
    L143:
        r18.b.put(r19, r15);     // Catch: Throwable -> L155
        r18.c.put(r15, r19);     // Catch: Throwable -> L155
    L144:
        if (r18.b.size() <= RangesKt.coerceAtLeast(r18.a, 1)) goto L150;
        Iterator<Map.Entry<String, String>> r24 = r18.b.entrySet().iterator();     // Catch: Throwable -> L155
        if (r24.hasNext() == false) goto L150;
        Map.Entry<String, String> r25 = r24.next();     // Catch: Throwable -> L155
        r24.remove();     // Catch: Throwable -> L155
        r18.c.remove(r25.getValue());     // Catch: Throwable -> L155
    L150:
        monitor-exit(r18);
    L155:
        th = move-exception;
        throw th;
    L197:
        return;
    L164:
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L115
        JSONObject r27 = new JSONObject(r10);     // Catch: Throwable -> L115
        if (Intrinsics.areEqual(r27.optString("applet_id"), "ability.intent.card") == false) goto L64;
        if (Intrinsics.areEqual(r27.optString("widget_id"), "appintent_music") == false) goto L64;
        String r28 = StringsKt.trim(r27.optString("mixture_card_id")).toString();     // Catch: Throwable -> L115
        if (r28.length() != 0) goto L56;
        boolean r29 = true;
    L57:
        if (r29 == true) goto L64;
        JSONObject r30 = u.a(r27);     // Catch: Throwable -> L115
        if (r30 == null) goto L64;
        JSONArray r31 = r30.optJSONArray("cards");     // Catch: Throwable -> L115
        if (r31 == null) goto L64;
        int r110 = r31.length();     // Catch: Throwable -> L115
        int r111 = 0;
    L66:
        if (r111 >= r110) goto L110;
        JSONObject r32 = r31.optJSONObject(r111);     // Catch: Throwable -> L115
        if (r32 == null) goto L109;
        JSONArray r112 = r32.optJSONArray("items");     // Catch: Throwable -> L115
        if (r112 == null) goto L109;
        List r113 = CollectionsKt.createListBuilder();     // Catch: Throwable -> L115
        int r114 = r112.length();     // Catch: Throwable -> L115
        int r115 = 0;
    L72:
        if (r115 >= r114) goto L105;
        JSONObject r33 = r112.optJSONObject(r115);     // Catch: Throwable -> L115
        if (r33 == null) goto L104;
        String r34 = r33.optString("state");     // Catch: Throwable -> L115
        if (Intrinsics.areEqual(r34, "") == false) goto L79;
    L82:
        boolean r35 = true;
    L83:
        if (r35 == false) goto L104;
        JSONObject r36 = r33.optJSONObject("entity");     // Catch: Throwable -> L115
        if (r36 == null) goto L104;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L93
        zda.a.a.getClass();     // Catch: Throwable -> L93
        MusicEntity r38 = zda.a.d(r36);     // Catch: Throwable -> L93
        if ((r38 instanceof MusicEntity) == false) goto L90;
        MusicEntity r39 = r38;     // Catch: Throwable -> L93
    L91:
        Object r40 = Result.constructor-impl(r39);     // Catch: Throwable -> L93
    L96:
        if (Result.isFailure-impl(r40) == false) goto L98;
        r40 = null;
    L98:
        MusicEntity r41 = (MusicEntity) r40;     // Catch: Throwable -> L115
        if (r41 == null) goto L104;
        if (StringsKt.isBlank(r41.getId()) == true) goto L104;
        r113.add(r41);     // Catch: Throwable -> L115
        goto L104
    L90:
        r39 = null;
        goto L91
    L93:
        th = move-exception;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L115
        r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L115
        goto L96
    L79:
        if (Intrinsics.areEqual(r34, "normal") == true) goto L82;
        r35 = false;
    L104:
        r115 = r115 + 1;     // Catch: Throwable -> L115
        goto L72
    L105:
        List r43 = CollectionsKt.build(r113);     // Catch: Throwable -> L115
        if ((!r43.isEmpty()) == false) goto L109;
        r12 = new u.a(r28, (MusicEntity[]) r43.toArray(new MusicEntity[0]));     // Catch: Throwable -> L115
    L109:
        r111 = r111 + 1;
        goto L66
    L110:
        Object r44 = null;
        Object r45 = Result.constructor-impl(null);     // Catch: Throwable -> L113
    L119:
        if (Result.isFailure-impl(r45) == false) goto L121;
        r45 = r44;
    L121:
        r13 = (u.a) r45;
    L113:
        th = th;
    L117:
        Result.Companion r46 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L119
    L56:
        r29 = false;
    L115:
        th = th;
        r44 = null;
        goto L117
    L41:
        if (StringsKt.isBlank(r10) == true) goto L44;
        r11 = false;
        goto L45
    L124:
        r14 = null;
        goto L125
    L32:
        if (r7 >= 100000000000L) goto L34;
        r7 = r7 * 1000;
    L34:
        r8 = Long.valueOf(r7);
        goto L35
    L196:
        return;
    L5:
        if ((!StringsKt.isBlank(r1)) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L10;
        r0.add(r1);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static JSONObject w(JSONObject r20, String... r21) {
        JSONObject r3 = null;
        if (r20 != null) goto L5;
        return null;
    L5:
        int r4 = r21.length;
        int r6 = 0;
    L6:
        if (r6 >= r4) goto L101;
        Object r0 = r20.opt(r21[r6]);
        if ((r0 instanceof JSONObject) == true) goto L10;
        if ((r0 instanceof String) == false) goto L100;
        String r1 = StringsKt.replace$default(StringsKt.replace$default((String) r0, 65292, ',', false, 4, null), 65306, ':', false, 4, null);
        StringBuilder r7 = new StringBuilder(r1.length());
        int r8 = 0;
        boolean r9 = false;
        boolean r10 = false;
    L15:
        if (r8 >= r1.length()) goto L88;
        char r11 = r1.charAt(r8);
        if (r9 == true) goto L18;
        if (r11 != '\"') goto L30;
        r7.append(r11);
        r8 = r8 + 1;
        r9 = true;
        goto L15
    L30:
        if (r11 != '/') goto L85;
        int r14 = r8 + 1;
        if (r14 >= r1.length()) goto L85;
        if (r1.charAt(r14) != '/') goto L85;
        r8 = r8 + 2;
    L37:
        if (r8 >= r1.length()) goto L48;
        char r12 = r1.charAt(r8);
        if (r12 == '\n') goto L48;
        if (r12 == '\r') goto L48;
        if (r12 == '\"') goto L48;
        if (r12 == ']') goto L48;
        if (r12 == '}') goto L48;
        r8 = r8 + 1;
    L48:
        int r13 = r7.length();
    L49:
        r13 = r13 - 1;
        if (r13 < 0) goto L54;
        char r15 = r7.charAt(r13);
        if (CharsKt.isWhitespace(r15) == true) goto L49;
        Character r16 = Character.valueOf(r15);
    L55:
        int r17 = r8;
    L57:
        if (r17 >= r1.length()) goto L62;
        char r18 = r1.charAt(r17);
        if (CharsKt.isWhitespace(r18) == false) goto L60;
        r17 = r17 + 1;
        goto L57
    L60:
        Character r19 = Character.valueOf(r18);
    L63:
        if (r16 != 0) goto L65;
    L87:
        r3 = null;
        goto L15
    L65:
        if (r16.charValue() == ',') goto L87;
        if (r16.charValue() == '{') goto L87;
        if (r16.charValue() == '[') goto L87;
        if (r16.charValue() == ':') goto L87;
        if (r19 != 0) goto L75;
    L76:
        if (r19 != 0) goto L79;
    L80:
        if (r19 == 0) goto L87;
        if (r19.charValue() != '[') goto L87;
    L84:
        r7.append(',');
        goto L87
    L79:
        if (r19.charValue() == '{') goto L84;
    L75:
        if (r19.charValue() == '\"') goto L84;
    L62:
        r19 = r3;
        goto L63
    L54:
        r16 = r3;
    L85:
        r7.append(r11);
    L86:
        r8 = r8 + 1;
        goto L87
    L18:
        r7.append(r11);
        if (r10 == false) goto L21;
        r10 = false;
        goto L86
    L21:
        if (r11 != '\"') goto L23;
        r9 = false;
        goto L86
    L23:
        if (r11 != '\\') goto L86;
        r10 = true;
        goto L86
    L88:
        String r2 = r7.toString();
        JSONObject r5 = z.b(r2);
        if (r5 == null) goto L102;
    L98:
        if (r5 == null) goto L100;
        return r5;
    L102:
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L92
        Object r23 = Result.constructor-impl(new JSONObject(r2));     // Catch: Throwable -> L92
    L95:
        if (Result.isFailure-impl(r23) == false) goto L97;
        r23 = null;
    L97:
        r5 = (JSONObject) r23;
    L92:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
    L100:
        r6 = r6 + 1;
        r3 = null;
        goto L6
    L10:
        return (JSONObject) r0;
    L101:
        return r3;
    }

    public final boolean p(Context r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r20, "context");
        if (ObricFeatureServiceDelegate.b.c() == false) goto L150;
        if (r21 == null) goto L7;
        String r7 = r21.getString("appletId", "");
    L9:
        if (Intrinsics.areEqual(r7, "com.flow.calendar") == false) goto L12;
        String r12 = "//flow/applet/calendar";
    L28:
        if (o0.d(r12) == false) goto L36;
        if (r21 == null) goto L31;
        String r13 = r21.getString(MemorySourceLinkType.URL);
    L32:
        if (r13 == null) goto L36;
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(UriProtector.parse(r13), "launchFrom"), "doubao_widget") == false) goto L36;
        ((IObricChatPageStateService) ServiceManager.get().getService(IObricChatPageStateService.class)).c(null, true);
        goto L36
    L31:
        r13 = null;
    L36:
        if (r12 != null) goto L38;
    L41:
        boolean r14 = true;
    L42:
        if (r14 == true) goto L150;
        if ((r20 instanceof Application) == false) goto L50;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r15 = AppletRuntimeManager.d;
        if (r15 == null) goto L50;
        Context r16 = r15.currentActivity();
        if (r16 == null) goto L50;
    L51:
        w0.a.getClass();
        w0.a.b.getClass();
        t1a.b r0 = ObricChatContextServiceDelegate.b.b(AppHost.a.a().getCurrentActivity());
        if (r0 == null) goto L54;
        laa.d r1 = (laa.d) r0.getAbility(laa.d.class);
    L55:
        if (r1 != null) goto L57;
    L59:
        boolean r2 = false;
    L60:
        boolean r3 = !r2;
        com.bytedance.ai.utils.g.a.i("PageTransitionUtils", "create OpenPageTransitionFactory, isFullActivity=" + r3);
        if (r3 == false) goto L63;
        p0 r4 = com.obric.miniapp.utils.d.a;
    L64:
        p0 r5 = r4;
        yka.a r6 = yka.a.b;
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r12, MemorySourceLinkType.URL);
        Intrinsics.checkNotNullParameter(r5, "transition");
        q r8 = yka.a.c;
        if (r8.e.c(r8.a) == false) goto L67;
        p r9 = r8.f;
    L69:
        if (r9 == null) goto L125;
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r12, MemorySourceLinkType.URL);
        Intrinsics.checkNotNullParameter(r5, "transition");
        if (Intrinsics.areEqual(r12, "//flow/applet/calendar") == false) goto L125;
        if (r21 != null) goto L75;
        Bundle r10 = Bundle.EMPTY;
    L76:
        String r11 = r10.getString("appletId");
        if (Intrinsics.areEqual(r11, "com.flow.calendar") == false) goto L125;
        zka.r.a.getClass();
        if (zka.r.a.a(r16) == false) goto L125;
        if (r21 == null) goto L86;
        String r17 = r21.getString("pageId");
        if (r17 == null) goto L86;
    L87:
        AppletRuntimeManager.INSTANCE.getClass();
        com.bytedance.ai.model.widgets.c r18 = AppletRuntimeManager.e(r17);
        if (r18 == null) goto L106;
        PageInfo r19 = r18.getPageInfo();
        if (r19 == null) goto L106;
        String r22 = r19.getPageName();
        FLogger r23 = FLogger.a;
        String r110 = r7;
        String r111 = r12;
        r23.d("CalendarPageProxy", "pageId: " + r22);
        String r24 = r19.getPageData();
        if (r24 != null) goto L153;
    L99:
        boolean r25 = true;
    L101:
        if (r25 == false) goto L103;
        JSONObject r26 = new JSONObject();     // Catch: JSONException -> L97
        r26.put("fromMiniApp", true);     // Catch: JSONException -> L97
        r19.setPageData(r26.toString());     // Catch: JSONException -> L97
        r23.i("CalendarPageProxy", "pageData is NULL, set fromMiniApp");     // Catch: JSONException -> L97
    L107:
        Intent r27 = new Intent("android.intent.action.VIEW", y0.j("applet://open_calendar"));
        r27.setPackage("com.obric.appletapp");
        r27.putExtras(r10);
        r27.putExtra("appletId", r11);
        r27.putExtra("mini_app_transition", r5.a());
        r27.putExtra("fromLauncher", true);
        if (r18 == null) goto L113;
        PageInfo r28 = r18.getPageInfo();
        if (r28 == null) goto L113;
        String r29 = r28.getPageData();
        if (r29 == null) goto L113;
    L114:
        r27.putExtra("pageData", r29);
        if (r18 == null) goto L119;
        PageInfo r30 = r18.getPageInfo();
        if (r30 == null) goto L119;
        String r31 = r30.getPageName();
    L120:
        r27.putExtra("pageId", r31);
        r27.addFlags(872415232);
        r16.startActivity(r27);     // Catch: Exception -> L123
        boolean r32 = true;
    L127:
        if (r32 == true) goto L129;
        com.bytedance.router.i r33 = SmartRouter.buildRoute(r16, r111);
        r33.f = y0.j(r110);
        r33.c.putExtra("appletId", r110);
        r33.c.putExtras(r21);
        r33.c.putExtra("mini_app_transition", r5.a());
        r33.c.putExtra("fromLauncher", false);
        g1 r34 = r5.b();
        if (r34 == null) goto L148;
        int r35 = r34.a;
        int r36 = r34.b;
        r33.d = r35;
        r33.e = r36;
    L148:
        r33.d();
        return true;
    L129:
        if ((r16 instanceof Activity) == false) goto L131;
        Object r112 = (Activity) r16;
    L132:
        if (r112 != null) goto L137;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r37 = AppletRuntimeManager.d;
        if (r37 == null) goto L136;
        Object r38 = r37.currentActivity();
    L139:
        if ((r38 instanceof MiniAppBaseActivity) == false) goto L155;
        MiniAppBaseActivity r39 = (MiniAppBaseActivity) r38;
        if (Intrinsics.areEqual(r39.P1(), "com.flow.calendar") == false) goto L156;
        r39.finish();
        return true;
    L156:
        return true;
    L155:
        return true;
    L136:
        r38 = null;
        goto L139
    L137:
        r38 = r112;
        goto L139
    L131:
        r112 = null;
    L123:
        e = move-exception;
        FLogger.a.e("CalendarPageProxy", "Failed to start CalendarMiniAppActivity", e);
    L126:
        r32 = false;
    L119:
        r31 = null;
    L113:
        r29 = "";
        goto L114
    L103:
        JSONObject r40 = new JSONObject(r24);     // Catch: JSONException -> L97
        r40.put("fromMiniApp", true);     // Catch: JSONException -> L97
        r19.setPageData(r40.toString());     // Catch: JSONException -> L97
        r23.i("CalendarPageProxy", "set fromMiniApp");     // Catch: JSONException -> L97
        goto L107
    L153:
    L97:
        e = move-exception;
        FLogger.a.e("CalendarPageProxy", "exception in preprocessing pageData: " + e + ' ');
        goto L107
    L94:
        if (r24.length() == 0) goto L99;
        r25 = false;
    L106:
        r110 = r7;
        r111 = r12;
    L86:
        r17 = "2147483647";
        goto L87
    L75:
        r10 = r21;
    L125:
        r110 = r7;
        r111 = r12;
        goto L126
    L67:
        r9 = null;
        goto L69
    L63:
        r4 = k1.a;
        goto L64
    L57:
        if (r1.JY() != true) goto L59;
        r2 = true;
        goto L60
    L54:
        r1 = null;
    L50:
        r16 = r20;
        goto L51
    L38:
        if (r12.length() == 0) goto L41;
        r14 = false;
        goto L42
    L12:
        if (r7 != null) goto L14;
    L16:
        boolean r113 = false;
    L17:
        if (r113 == true) goto L26;
        if (r7 != null) goto L20;
    L22:
        boolean r114 = false;
    L23:
        if (r114 == true) goto L26;
        r12 = null;
        goto L28
    L20:
        if (Intrinsics.areEqual(IAISDKDebugService.a.h(r7), "1") != true) goto L22;
        r114 = true;
    L26:
        r12 = "//flow/applet/miniapp";
        goto L28
    L14:
        if (this.h.contains(r7) != true) goto L16;
        r113 = true;
        goto L17
    L7:
        r7 = null;
    L150:
        return false;
    }

    public static JSONObject c(String r2, int r3, String r4) {
        JSONObject r0 = new JSONObject();
        r0.put("text", r2);
        r0.put("textSize", r3);
        r0.put("textColor", r4);
        return r0;
    }

    public static String z(String r3, String r4, String r5) {
        if (r4 == null) goto L12;
        if (o0.d(r4) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L12;
        r5 = r4;
    L12:
        if (StringsKt.contains$default(r5, ':', false, 2, null) == false) goto L15;
        return r5;
    L15:
        return r3 + ':' + r5;
    }

    public static String y(JSONObject r4, JSONObject r5, JSONObject r6, List r7) {
        Iterator r8 = r7.iterator();
    L3:
        String r1 = null;
        if (r8.hasNext() == false) goto L16;
        String r0 = (String) r8.next();
        String r2 = r6.optString(r0);
        if (o0.d(r2) == true) goto L9;
        r2 = null;
    L9:
        if (r2 != null) goto L10;
        String r3 = r5.optString(r0);
        if (o0.d(r3) == false) goto L14;
        r1 = r3;
    L14:
        if (r1 == null) goto L3;
        return r1;
    L10:
        return r2;
    L16:
        String r9 = j.b(r4, new String[]{"template_id", "templateId"});
        if (r9 == null) goto L19;
        return r9;
    L19:
        return null;
    }

    public final boolean f(Context r9, List r10, final rv3.b0 r11, c0 r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "optionList");
        Intrinsics.checkNotNullParameter(r11, "selectedCallback");
        Intrinsics.checkNotNullParameter(r12, "cancelCallback");
        if (Build.VERSION.SDK_INT < 30) goto L10;
        int r4 = r0.a;
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "optionList");
        Intrinsics.checkNotNullParameter(r11, "selectedCallback");
        Intrinsics.checkNotNullParameter(r12, "cancelCallback");
        ArrayList r0 = new ArrayList();
        Iterator r13 = r10.iterator();
    L6:
        if (r13.hasNext() == false) goto L8;
        String r5 = (String) r13.next();
        r0.add(new fla.a(OActionSheet.Companion.ItemStyle.LIST_BUTTON, null, r5, new q0(r11), 10));
        goto L6
    L8:
        WeakReference<OActionSheet> r14 = fla.g.a;
        fla.g.b(r9, r0, r9.getString(2131911808), OInsetSheet.PanelWidth.NARROW_WIDTH, r12);
        return true;
    L10:
        com.bytedance.ai.utils.g.a.w("MiniAppService", "System API Version is less than 30");
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.obric.miniapp.aibridge.j] */
    public final o B(final String r23, String r24, JSONObject r25, String r26, JSONObject r27, final Boolean r28, final Long r29, String r30, String r31) {
        Intrinsics.checkNotNullParameter(r23, "sessionKey");
        Intrinsics.checkNotNullParameter(r24, "collapseTemplateId");
        Intrinsics.checkNotNullParameter(r25, "collapseTemplateData");
        Intrinsics.checkNotNullParameter(r26, "expandTemplateId");
        Intrinsics.checkNotNullParameter(r27, "expandTemplateData");
        com.bytedance.ai.utils.g r10 = com.bytedance.ai.utils.g.a;
        StringBuilder r11 = new StringBuilder("live island showLiveCardByKey enter sessionKey=");
        r11.append(r23);
        r11.append(" collapseTemplateId=");
        r11.append(r24);
        r11.append(" expandTemplateId=");
        r11.append(r26);
        r11.append(" canFrontShow=");
        if (r28 == null) goto L5;
        boolean r15 = r28.booleanValue();
    L6:
        r11.append(r15);
        r11.append(" autoDismissMs=");
        long r16 = -1;
        if (r29 == null) goto L9;
        long r14 = r29.longValue();
    L10:
        r11.append(r14);
        r10.i("MiniAppService", r11.toString());
        LiveCardJsbSessionManager r12 = LiveCardJsbSessionManager.a;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r23, "sessionKey");
        Intrinsics.checkNotNullParameter(r24, "collapseTemplateId");
        Intrinsics.checkNotNullParameter(r25, "collapseTemplateData");
        Intrinsics.checkNotNullParameter(r26, "expandTemplateId");
        Intrinsics.checkNotNullParameter(r27, "expandTemplateData");
        String r4 = LiveCardJsbSessionManager.b(r23);
        StringBuilder r5 = new StringBuilder("collapseTemplateId=");
        r5.append(r24);
        r5.append(" expandTemplateId=");
        r5.append(r26);
        r5.append(" canFrontShow=");
        if (r28 == null) goto L13;
        boolean r6 = r28.booleanValue();
    L14:
        r5.append(r6);
        r5.append(" autoDismissMs=");
        if (r29 == null) goto L17;
        r16 = r29.longValue();
    L17:
        r5.append(r16);
        LiveCardJsbSessionManager.n("clientShow.enter", r23, r4, r5.toString());
        String r7 = LiveCardJsbSessionManager.o(r23);
        String r13 = "";
        if (r7 == null) goto L20;
        LiveCardJsbSessionManager.m(r12, "clientShow.invalidParam", r23, LiveCardJsbSessionManager.b(r23), "msg=".concat(r7), null, 16);
        o r0 = new o(r23, LiveCardJsbSessionManager.b(r23), "INVALID_PARAM", r7);
    L88:
        com.bytedance.ai.utils.g r1 = com.bytedance.ai.utils.g.a;
        StringBuilder r2 = new StringBuilder("live island showLiveCardByKey exit sessionKey=");
        r2.append(r23);
        r2.append(" ok=");
        r2.append(r0.a);
        r2.append(" code=");
        String r3 = r0.d;
        if (r3 != null) goto L91;
        r3 = "";
    L91:
        r2.append(r3);
        r2.append(" msg=");
        String r8 = r0.e;
        if (r8 == null) goto L95;
        r13 = r8;
    L95:
        r2.append(r13);
        r1.i("MiniAppService", r2.toString());
        return r0;
    L20:
        final JSONObject r9 = new JSONObject();
        r9.put("templateId", r24);
        r9.put("templateData", r25);
        final JSONObject r17 = new JSONObject();
        r17.put("templateId", r26);
        r17.put("templateData", r27);
        JSONObject r18 = new JSONObject();
        JSONObject r19 = null;
        if (r30 != null) goto L23;
    L28:
        if (r31 == null) goto L36;
        if ((!StringsKt.isBlank(r31)) == false) goto L32;
        String r20 = r31;
    L33:
        if (r20 == null) goto L36;
        r18.put("traceId", r20);
        goto L36
    L32:
        r20 = null;
    L36:
        if (r18.length() <= 0) goto L38;
        boolean r21 = true;
    L39:
        if (r21 == false) goto L41;
        final JSONObject r22 = r18;
    L42:
        final Context r32 = AppHost.a.getApplication().getApplicationContext();
        final ?? r33 = new com.obric.miniapp.aibridge.j(r32, r23, r28, r9, r17, r22, r29);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L45;
        t r34 = (t) r33.invoke();
    L62:
        String r35 = LiveCardJsbSessionManager.b(r23);
        StringBuilder r36 = new StringBuilder("ok=");
        r36.append(r34.a);
        r36.append(" errCode=");
        JSONObject r37 = r34.d;
        if (r37 == null) goto L65;
        String r38 = r37.optString("code");
    L66:
        if (r38 != null) goto L68;
        r38 = "";
    L68:
        r36.append(r38);
        LiveCardJsbSessionManager.n("clientShow.exit", r23, r35, r36.toString());
        JSONObject r39 = r34.d;
        if (r39 == null) goto L75;
        String r40 = r39.optString("code");
        if (r40 == null) goto L75;
        if ((!StringsKt.isBlank(r40)) == false) goto L75;
    L76:
        JSONObject r41 = r34.d;
        if (r41 == null) goto L83;
        String r42 = r41.optString("message");
        if (r42 == null) goto L83;
        if ((!StringsKt.isBlank(r42)) == false) goto L83;
    L84:
        JSONObject r43 = r34.d;
        if (r43 == null) goto L87;
        r19 = r43.optJSONObject("detail");
    L87:
        r0 = new o(r34.a, r34.b, r34.c, r40, r42, r19);
    L83:
        r42 = null;
    L75:
        r40 = null;
        goto L76
    L65:
        r38 = null;
        goto L66
    L45:
        LiveCardJsbSessionManager.n("runOnMainSync.post", r23, LiveCardJsbSessionManager.b(r23), "waitMs=5000");
        final CountDownLatch r44 = new CountDownLatch(1);
        final AtomicReference r45 = new AtomicReference(null);
        LiveCardJsbSessionManager.c.post(new com.obric.miniapp.aibridge.p(r45, r33, r44));
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L48
        Object r47 = Result.constructor-impl(Boolean.valueOf(r44.await(5000, TimeUnit.MILLISECONDS)));     // Catch: Throwable -> L48
    L50:
        Boolean r48 = Boolean.FALSE;
        if (Result.isFailure-impl(r47) == false) goto L53;
        r47 = r48;
    L53:
        boolean r49 = ((Boolean) r47).booleanValue();
        if (r49 == true) goto L57;
        LiveCardJsbSessionManager.m(r12, "runOnMainSync.timeout", r23, LiveCardJsbSessionManager.b(r23), "waitMs=5000", null, 16);
    L57:
        if (r49 == false) goto L61;
        r34 = (t) r45.get();
        if (r34 != null) goto L62;
        int r50 = t.e;
        r34 = t.a.a(r23, LiveCardJsbSessionManager.b(r23), "TIMEOUT", "runOnMainSync timeout");
        goto L62
    L61:
        int r51 = t.e;
        r34 = t.a.a(r23, LiveCardJsbSessionManager.b(r23), "TIMEOUT", "runOnMainSync timeout");
    L48:
        th = move-exception;
        Result.Companion r52 = Result.Companion;
        r47 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L50
    L41:
        r22 = null;
        goto L42
    L38:
        r21 = false;
        goto L39
    L23:
        if ((!StringsKt.isBlank(r30)) == false) goto L25;
        String r53 = r30;
    L26:
        if (r53 == null) goto L28;
        r18.put("biz", r53);
        goto L28
    L25:
        r53 = null;
        goto L26
    L13:
        r6 = true;
        goto L14
    L9:
        r14 = -1;
        goto L10
    L5:
        r15 = true;
        goto L6
    }
}
