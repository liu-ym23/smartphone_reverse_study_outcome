package com.obric.memorydata.memory.ui.list;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.widget.RemoteViews;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.trace.TraceCons;
import com.obric.capabilitykit.entity.memory.CollectContentMemoryEntity;
import com.obric.capabilitykit.entity.memory.CollectStoreMemoryEntity;
import com.obric.capabilitykit.entity.memory.CommonTextMemoryEntity;
import com.obric.capabilitykit.entity.memory.EventScheduleMemoryEntity;
import com.obric.capabilitykit.entity.memory.EventTodoMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoAddressMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoAnniversaryMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoDocumentsMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoRelationshipMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.entity.memory.OrderCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderFlightMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderMovieTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0003\u0011\u0012\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryWidgetProvider;", "Landroid/appwidget/AppWidgetProvider;", "<init>", "()V", "onUpdate", "", "context", "Landroid/content/Context;", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "appWidgetIds", "", "onEnabled", "onDisabled", "onReceive", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "ResourceTuple", "WidgetData", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class al extends AppWidgetProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11186a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f11187b = 0;
    private static final kotlinx.coroutines.al c = null;
    private static bx d;
    private static long e;
    private static Handler f;
    private static final AtomicBoolean g = null;
    private static final com.obric.memorydata.ability.d h = null;
    private static final com.obric.memorydata.ability.f i = null;
    private static final b j = null;
    private static final MemoryWidgetProvider$Companion$observer$1 k = null;
    private static final c l = null;

    @Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0003\u001f\"%\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u0005J\u0012\u0010*\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u0005H\u0002J\b\u0010+\u001a\u00020(H\u0002J\u000e\u0010,\u001a\u00020(H\u0082@¢\u0006\u0002\u0010-J\u000e\u0010.\u001a\u00020/H\u0082@¢\u0006\u0002\u0010-J\u001e\u00100\u001a\u00020(2\f\u00101\u001a\b\u0012\u0004\u0012\u000203022\u0006\u00104\u001a\u00020\u0014H\u0002J\b\u00105\u001a\u00020(H\u0002J\u0010\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020/H\u0002J\u0018\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u00107\u001a\u00020/H\u0002J\u0018\u0010<\u001a\u00020(2\u0006\u0010:\u001a\u00020;2\u0006\u0010=\u001a\u000209H\u0002J\u0010\u0010>\u001a\u00020(2\u0006\u0010=\u001a\u000209H\u0002J&\u0010?\u001a\u00020(2\u0006\u0010:\u001a\u00020;2\u0006\u0010=\u001a\u0002092\f\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0002J\u0018\u0010@\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010A\u001a\u000203H\u0002J\u0012\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020EH\u0002J(\u0010F\u001a\u00020(2\u0006\u0010:\u001a\u00020;2\u0006\u0010G\u001a\u0002092\u0006\u0010H\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0002J\u0006\u0010I\u001a\u00020(J\u0016\u0010J\u001a\u00020(2\u0006\u0010K\u001a\u00020LH\u0086@¢\u0006\u0002\u0010MJ\u000e\u0010N\u001a\u00020(H\u0086@¢\u0006\u0002\u0010-R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R\u0010\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&¨\u0006O"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryWidgetProvider$Companion;", "", "<init>", "()V", "MEMORY_ITEM_CLICK", "", "MEMORY_CONTAINER_CLICK", "MEMORY_DATA_REMIND", "", "MEMORY_DATA_LATEST", "MEMORY_DATA_EMPTY", "EXTRA_ITEM_ID", "EXTRA_MEMORY_ENTITY", "TAG", "REQUEST_CODE", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "updateJob", "Lkotlinx/coroutines/Job;", "UPDATE_DEBOUNCE_MS", "", "timeDelta", "eliminateHandler", "Landroid/os/Handler;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "abilityManager", "Lcom/obric/memorydata/ability/AbilityManager;", "abilityParams", "Lcom/obric/memorydata/ability/AbilityParams;", "abilityDataReceiver", "com/obric/memorydata/memory/ui/list/MemoryWidgetProvider$Companion$abilityDataReceiver$1", "Lcom/obric/memorydata/memory/ui/list/MemoryWidgetProvider$Companion$abilityDataReceiver$1;", "observer", "com/obric/memorydata/memory/ui/list/MemoryWidgetProvider$Companion$observer$1", "Lcom/obric/memorydata/memory/ui/list/MemoryWidgetProvider$Companion$observer$1;", "customReceiver", "com/obric/memorydata/memory/ui/list/MemoryWidgetProvider$Companion$customReceiver$1", "Lcom/obric/memorydata/memory/ui/list/MemoryWidgetProvider$Companion$customReceiver$1;", "reload", "", NotificationCompat.CATEGORY_MESSAGE, "loadDataAndUpdateWidgets", "initializeComponents", "doLoadDataAndUpdateWidgets", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFreshData", "Lcom/obric/memorydata/memory/ui/list/MemoryWidgetProvider$WidgetData;", "calculateTimeDelta", "items", "", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "currentTimestamp", "scheduleDataElimination", "updateAllWidgets", "widgetData", "createWidgetViews", "Landroid/widget/RemoteViews;", "context", "Landroid/content/Context;", "setupContainerClickIntent", "views", "setupEmptyState", "setupContentState", "createItemView", "item", "createResourceTuple", "Lcom/obric/memorydata/memory/ui/list/MemoryWidgetProvider$ResourceTuple;", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "setupItemView", "itemView", "tuple", SlardarSettingsConstants.SETTING_GENERAL_CLEANUP, "handleItemClick", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "(Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleContainerClick", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final RemoteViews a(Context r10, RawMemoryEntity r11) {
            Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
            RemoteViews r1 = new RemoteViews(r12.getPackageName(), ZeusTransformUtils.mapRes(R.layout.item_widget, "layout", "item_widget"));
            RunLog.INSTANCE.debug("MemoryWidgetProvider", "creating item view for type: " + r11.getMemoryType());     // Catch: Exception -> L12
            MemoryEntity r13 = com.obric.memorydata.database.entity.memoryindex.m.a().toMemoryEntity(r11);     // Catch: Exception -> L12
            if (r13 == null) goto L10;
            d r3 = al.f11186a.a(r13);     // Catch: Exception -> L12
            if (r3 == null) goto L8;
            al.f11186a.a(r12, r1, r3, r13);     // Catch: Exception -> L12
            Unit r14 = Unit.INSTANCE;     // Catch: Exception -> L12
        L9:
            if (r14 == null) goto L10;
        L14:
            return r1;
        L8:
            r14 = null;
        L10:
            a r9 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryWidgetProvider", "failed to convert RawMemoryEntity to MemoryEntity", null, 4, null);     // Catch: Exception -> L12
        L12:
            e = move-exception;
            RunLog.INSTANCE.error("MemoryWidgetProvider", "failed to create item view", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            goto L14
        }

        private final RemoteViews a(Context r6, e r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            RemoteViews r0 = new RemoteViews(r8.getPackageName(), ZeusTransformUtils.mapRes(R.layout.memory_widget, "layout", "memory_widget"));
            a(r8, r0);
            if (r7.b() != 2) goto L5;
            a(r0);
        L6:
            return r0;
        L5:
            a(r8, r0, r7.a());
            goto L6
        }

        private final d a(MemoryEntity r20) {
            if (ZeusTransformUtils.instanceOf(r20, OrderFlightMemoryEntity.class) == false) goto L6;
            return new d(ZeusTransformUtils.mapRes(R.drawable.ic_widget_order_flight, "drawable", "ic_widget_order_flight"), ZeusTransformUtils.mapRes(R.drawable.widget_item_background_order, "drawable", "widget_item_background_order"), ZeusTransformUtils.mapRes(R.color.widget_text_content_order, TypedValues.Custom.S_COLOR, "widget_text_content_order"), ZeusTransformUtils.mapRes(R.color.widget_text_time_order, TypedValues.Custom.S_COLOR, "widget_text_time_order"), com.obric.memorydata.memory.ui.f.f10920a.a(r20), com.obric.memorydata.memory.ui.e.f10891a.a((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")));
        L6:
            if (ZeusTransformUtils.instanceOf(r20, OrderTrainMemoryEntity.class) == false) goto L9;
            return new d(ZeusTransformUtils.mapRes(R.drawable.ic_widget_order_train, "drawable", "ic_widget_order_train"), ZeusTransformUtils.mapRes(R.drawable.widget_item_background_order, "drawable", "widget_item_background_order"), ZeusTransformUtils.mapRes(R.color.widget_text_content_order, TypedValues.Custom.S_COLOR, "widget_text_content_order"), ZeusTransformUtils.mapRes(R.color.widget_text_time_order, TypedValues.Custom.S_COLOR, "widget_text_time_order"), com.obric.memorydata.memory.ui.f.f10920a.a(r20), com.obric.memorydata.memory.ui.e.f10891a.a((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")));
        L9:
            if (ZeusTransformUtils.instanceOf(r20, OrderHotelMemoryEntity.class) == false) goto L12;
            return new d(ZeusTransformUtils.mapRes(R.drawable.ic_widget_order_hotel, "drawable", "ic_widget_order_hotel"), ZeusTransformUtils.mapRes(R.drawable.widget_item_background_order, "drawable", "widget_item_background_order"), ZeusTransformUtils.mapRes(R.color.widget_text_content_order, TypedValues.Custom.S_COLOR, "widget_text_content_order"), ZeusTransformUtils.mapRes(R.color.widget_text_time_order, TypedValues.Custom.S_COLOR, "widget_text_time_order"), com.obric.memorydata.memory.ui.f.f10920a.a(r20), com.obric.memorydata.memory.ui.e.f10891a.a((OrderHotelMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderHotelMemoryEntity.class, "com.obric.memorydata.plugin")));
        L12:
            if (ZeusTransformUtils.instanceOf(r20, OrderMovieTicketMemoryEntity.class) == false) goto L15;
            return new d(ZeusTransformUtils.mapRes(R.drawable.ic_widget_order_movie_ticket, "drawable", "ic_widget_order_movie_ticket"), ZeusTransformUtils.mapRes(R.drawable.widget_item_background_order, "drawable", "widget_item_background_order"), ZeusTransformUtils.mapRes(R.color.widget_text_content_order, TypedValues.Custom.S_COLOR, "widget_text_content_order"), ZeusTransformUtils.mapRes(R.color.widget_text_time_order, TypedValues.Custom.S_COLOR, "widget_text_time_order"), com.obric.memorydata.memory.ui.f.f10920a.a(r20), com.obric.memorydata.memory.ui.e.f10891a.a((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")));
        L15:
            if (ZeusTransformUtils.instanceOf(r20, OrderTicketMemoryEntity.class) == false) goto L18;
            return new d(ZeusTransformUtils.mapRes(R.drawable.ic_widget_order_common, "drawable", "ic_widget_order_common"), ZeusTransformUtils.mapRes(R.drawable.widget_item_background_order, "drawable", "widget_item_background_order"), ZeusTransformUtils.mapRes(R.color.widget_text_content_order, TypedValues.Custom.S_COLOR, "widget_text_content_order"), ZeusTransformUtils.mapRes(R.color.widget_text_time_order, TypedValues.Custom.S_COLOR, "widget_text_time_order"), com.obric.memorydata.memory.ui.f.f10920a.a(r20), com.obric.memorydata.memory.ui.e.f10891a.a((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")));
        L18:
            if (ZeusTransformUtils.instanceOf(r20, OrderCommonMemoryEntity.class) == false) goto L21;
            return new d(ZeusTransformUtils.mapRes(R.drawable.ic_widget_order_common, "drawable", "ic_widget_order_common"), ZeusTransformUtils.mapRes(R.drawable.widget_item_background_order, "drawable", "widget_item_background_order"), ZeusTransformUtils.mapRes(R.color.widget_text_content_order, TypedValues.Custom.S_COLOR, "widget_text_content_order"), ZeusTransformUtils.mapRes(R.color.widget_text_time_order, TypedValues.Custom.S_COLOR, "widget_text_time_order"), com.obric.memorydata.memory.ui.f.f10920a.a(r20), com.obric.memorydata.memory.ui.e.f10891a.a((OrderCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r20, OrderCommonMemoryEntity.class, "com.obric.memorydata.plugin"), false));
        L21:
            if (ZeusTransformUtils.instanceOf(r20, CollectContentMemoryEntity.class) == false) goto L24;
            return new d(ZeusTransformUtils.mapRes(R.drawable.ic_widget_collect_content, "drawable", "ic_widget_collect_content"), ZeusTransformUtils.mapRes(R.drawable.widget_item_background_collect, "drawable", "widget_item_background_collect"), ZeusTransformUtils.mapRes(R.color.widget_text_content_collect, TypedValues.Custom.S_COLOR, "widget_text_content_collect"), ZeusTransformUtils.mapRes(R.color.widget_text_time_collect, TypedValues.Custom.S_COLOR, "widget_text_time_collect"), com.obric.memorydata.memory.ui.f.f10920a.a(r20), "");
        L24:
            if (ZeusTransformUtils.instanceOf(r20, CollectStoreMemoryEntity.class) == false) goto L27;
            return new d(ZeusTransformUtils.mapRes(R.drawable.ic_widget_collect_store, "drawable", "ic_widget_collect_store"), ZeusTransformUtils.mapRes(R.drawable.widget_item_background_collect, "drawable", "widget_item_background_collect"), ZeusTransformUtils.mapRes(R.color.widget_text_content_collect, TypedValues.Custom.S_COLOR, "widget_text_content_collect"), ZeusTransformUtils.mapRes(R.color.widget_text_time_collect, TypedValues.Custom.S_COLOR, "widget_text_time_collect"), com.obric.memorydata.memory.ui.f.f10920a.a(r20), "");
        L27:
            if (ZeusTransformUtils.instanceOf(r20, EventScheduleMemoryEntity.class) == false) goto L30;
            return new d(ZeusTransformUtils.mapRes(R.drawable.ic_widget_event_schedule, "drawable", "ic_widget_event_schedule"), ZeusTransformUtils.mapRes(R.drawable.widget_item_background_schedule, "drawable", "widget_item_background_schedule"), ZeusTransformUtils.mapRes(R.color.widget_text_content_schedule, TypedValues.Custom.S_COLOR, "widget_text_content_schedule"), ZeusTransformUtils.mapRes(R.color.widget_text_time_schedule, TypedValues.Custom.S_COLOR, "widget_text_time_schedule"), com.obric.memorydata.memory.ui.f.f10920a.a(r20), com.obric.memorydata.memory.ui.e.f10891a.a((EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r20, EventScheduleMemoryEntity.class, "com.obric.memorydata.plugin")));
        L30:
            if (ZeusTransformUtils.instanceOf(r20, EventTodoMemoryEntity.class) == false) goto L33;
            return new d(ZeusTransformUtils.mapRes(R.drawable.ic_widget_event_todo, "drawable", "ic_widget_event_todo"), ZeusTransformUtils.mapRes(R.drawable.widget_item_background_todo, "drawable", "widget_item_background_todo"), ZeusTransformUtils.mapRes(R.color.widget_text_content_todo, TypedValues.Custom.S_COLOR, "widget_text_content_todo"), ZeusTransformUtils.mapRes(R.color.widget_text_time_todo, TypedValues.Custom.S_COLOR, "widget_text_time_todo"), com.obric.memorydata.memory.ui.f.f10920a.a(r20), com.obric.memorydata.memory.ui.e.f10891a.a((EventTodoMemoryEntity) ZeusTransformUtils.preCheckCast(r20, EventTodoMemoryEntity.class, "com.obric.memorydata.plugin"), false));
        L33:
            if (ZeusTransformUtils.instanceOf(r20, InfoDocumentsMemoryEntity.class) == false) goto L36;
            return new d(ZeusTransformUtils.mapRes(R.drawable.ic_widget_info_documents, "drawable", "ic_widget_info_documents"), ZeusTransformUtils.mapRes(R.drawable.widget_item_background_info, "drawable", "widget_item_background_info"), ZeusTransformUtils.mapRes(R.color.widget_text_content_info, TypedValues.Custom.S_COLOR, "widget_text_content_info"), ZeusTransformUtils.mapRes(R.color.widget_text_time_info, TypedValues.Custom.S_COLOR, "widget_text_time_info"), com.obric.memorydata.memory.ui.f.f10920a.a(r20), "");
        L36:
            if (ZeusTransformUtils.instanceOf(r20, InfoAddressMemoryEntity.class) == false) goto L39;
            return new d(ZeusTransformUtils.mapRes(R.drawable.ic_widget_info_address, "drawable", "ic_widget_info_address"), ZeusTransformUtils.mapRes(R.drawable.widget_item_background_info, "drawable", "widget_item_background_info"), ZeusTransformUtils.mapRes(R.color.widget_text_content_info, TypedValues.Custom.S_COLOR, "widget_text_content_info"), ZeusTransformUtils.mapRes(R.color.widget_text_time_info, TypedValues.Custom.S_COLOR, "widget_text_time_info"), com.obric.memorydata.memory.ui.f.f10920a.a(r20), "");
        L39:
            if (ZeusTransformUtils.instanceOf(r20, InfoAnniversaryMemoryEntity.class) == false) goto L42;
            return new d(ZeusTransformUtils.mapRes(R.drawable.ic_widget_info_anniversary, "drawable", "ic_widget_info_anniversary"), ZeusTransformUtils.mapRes(R.drawable.widget_item_background_info, "drawable", "widget_item_background_info"), ZeusTransformUtils.mapRes(R.color.widget_text_content_info, TypedValues.Custom.S_COLOR, "widget_text_content_info"), ZeusTransformUtils.mapRes(R.color.widget_text_time_info, TypedValues.Custom.S_COLOR, "widget_text_time_info"), com.obric.memorydata.memory.ui.f.f10920a.a(r20), "");
        L42:
            if (ZeusTransformUtils.instanceOf(r20, InfoRelationshipMemoryEntity.class) == false) goto L45;
            return new d(ZeusTransformUtils.mapRes(R.drawable.ic_widget_info_relationship, "drawable", "ic_widget_info_relationship"), ZeusTransformUtils.mapRes(R.drawable.widget_item_background_info, "drawable", "widget_item_background_info"), ZeusTransformUtils.mapRes(R.color.widget_text_content_info, TypedValues.Custom.S_COLOR, "widget_text_content_info"), ZeusTransformUtils.mapRes(R.color.widget_text_time_info, TypedValues.Custom.S_COLOR, "widget_text_time_info"), com.obric.memorydata.memory.ui.f.f10920a.a(r20), "");
        L45:
            if (ZeusTransformUtils.instanceOf(r20, InfoCommonMemoryEntity.class) == false) goto L68;
            String r5 = ((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r20, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getInfoKey();
            switch(r5.hashCode()) {
                case 678376: goto L62;
                case 714256: goto L58;
                case 1129301: goto L54;
                case 31948986: goto L50;
                default: goto L65;
            };
        L65:
            int r2 = ZeusTransformUtils.mapRes(R.drawable.ic_widget_info_common, "drawable", "ic_widget_info_common");
        L86:
            return new d(r2, ZeusTransformUtils.mapRes(R.drawable.widget_item_background_info, "drawable", "widget_item_background_info"), ZeusTransformUtils.mapRes(R.color.widget_text_content_info, TypedValues.Custom.S_COLOR, "widget_text_content_info"), ZeusTransformUtils.mapRes(R.color.widget_text_time_info, TypedValues.Custom.S_COLOR, "widget_text_time_info"), com.obric.memorydata.memory.ui.f.f10920a.a(r20), "");
        L50:
            if (r5.equals(InfoCommonMemoryEntity.InfoKeyType.ANNIVERSARY) == false) goto L65;
            r2 = ZeusTransformUtils.mapRes(R.drawable.ic_widget_info_anniversary, "drawable", "ic_widget_info_anniversary");
            goto L86
        L54:
            if (r5.equals(InfoCommonMemoryEntity.InfoKeyType.IDENTIFICATION) == false) goto L65;
            r2 = ZeusTransformUtils.mapRes(R.drawable.ic_widget_info_documents, "drawable", "ic_widget_info_documents");
            goto L86
        L58:
            if (r5.equals(InfoCommonMemoryEntity.InfoKeyType.ADDRESS) == false) goto L65;
            r2 = ZeusTransformUtils.mapRes(R.drawable.ic_widget_info_address, "drawable", "ic_widget_info_address");
            goto L86
        L62:
            if (r5.equals(InfoCommonMemoryEntity.InfoKeyType.RELATIONSHIP) == false) goto L65;
            r2 = ZeusTransformUtils.mapRes(R.drawable.ic_widget_info_relationship, "drawable", "ic_widget_info_relationship");
            goto L86
        L68:
            if (ZeusTransformUtils.instanceOf(r20, CommonTextMemoryEntity.class) == true) goto L87;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryWidgetProvider", "unknown MemoryEntity type: " + r20.getClass().getSimpleName(), null, 4, null);
            return null;
        L87:
            return new d(ZeusTransformUtils.mapRes(R.drawable.ic_widget_common_text, "drawable", "ic_widget_common_text"), ZeusTransformUtils.mapRes(R.drawable.widget_item_background_info, "drawable", "widget_item_background_info"), ZeusTransformUtils.mapRes(R.color.widget_text_content_info, TypedValues.Custom.S_COLOR, "widget_text_content_info"), ZeusTransformUtils.mapRes(R.color.widget_text_time_info, TypedValues.Custom.S_COLOR, "widget_text_time_info"), com.obric.memorydata.memory.ui.f.f10920a.a(r20), "");
        }

        public static final /* synthetic */ Object a(a r2, Continuation r3) {
            return r2.b((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        private final void a(Context r3, RemoteViews r4) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intent r5 = new Intent(r2, al.class);
            r5.setAction("com.obric.memorydata.memory.ui.list.MEMORY_CONTAINER_CLICK");
            PendingIntent r6 = PendingIntent.getBroadcast(r2, al.k(), r5, 167772160);
            r4.setOnClickPendingIntent(ZeusTransformUtils.mapRes(R.id.widget_container, OaidModel.KEY_ID, "widget_container"), r6);
        }

        private final void a(Context r7, RemoteViews r8, d r9, MemoryEntity r10) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
            r8.setImageViewResource(ZeusTransformUtils.mapRes(R.id.widget_icon, OaidModel.KEY_ID, "widget_icon"), r9.a());
            r8.setInt(ZeusTransformUtils.mapRes(R.id.widget_item, OaidModel.KEY_ID, "widget_item"), "setBackgroundResource", r9.b());
            r8.setTextColor(ZeusTransformUtils.mapRes(R.id.widget_content, OaidModel.KEY_ID, "widget_content"), r6.getColor(r9.c()));
            r8.setTextColor(ZeusTransformUtils.mapRes(R.id.widget_time, OaidModel.KEY_ID, "widget_time"), r6.getColor(r9.d()));
            r8.setTextViewText(ZeusTransformUtils.mapRes(R.id.widget_content, OaidModel.KEY_ID, "widget_content"), (CharSequence) ZeusTransformUtils.preCheckCast(r9.e(), CharSequence.class, "com.obric.memorydata.plugin"));
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r9.f(), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
            boolean r11 = true;
        L7:
            if (r11 == false) goto L9;
            r8.setViewVisibility(ZeusTransformUtils.mapRes(R.id.container_small_margin, OaidModel.KEY_ID, "container_small_margin"), 8);
            r8.setViewVisibility(ZeusTransformUtils.mapRes(R.id.widget_time, OaidModel.KEY_ID, "widget_time"), 8);
        L10:
            Intent r12 = new Intent();
            r12.putExtra("item_id", r10.getId());
            r12.putExtra("memory_entity", (Parcelable) ZeusTransformUtils.preCheckCast(r10, Parcelable.class, "com.obric.memorydata.plugin"));
            r8.setOnClickFillInIntent(ZeusTransformUtils.mapRes(R.id.widget_item, OaidModel.KEY_ID, "widget_item"), r12);
            RunLog.INSTANCE.debug("MemoryWidgetProvider", "item setup - content: " + r9.e() + ", time: " + r9.f());
            return;
        L9:
            r8.setViewVisibility(ZeusTransformUtils.mapRes(R.id.container_small_margin, OaidModel.KEY_ID, "container_small_margin"), 0);
            r8.setViewVisibility(ZeusTransformUtils.mapRes(R.id.widget_time, OaidModel.KEY_ID, "widget_time"), 0);
            r8.setTextViewText(ZeusTransformUtils.mapRes(R.id.widget_time, OaidModel.KEY_ID, "widget_time"), (CharSequence) ZeusTransformUtils.preCheckCast(r9.f(), CharSequence.class, "com.obric.memorydata.plugin"));
            goto L10
        L5:
            r11 = false;
            goto L7
        }

        private final void a(Context r10, RemoteViews r11, List<RawMemoryEntity> r12) {
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
            List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
            int r3 = 0;
            r11.setViewVisibility(ZeusTransformUtils.mapRes(R.id.widget_title, OaidModel.KEY_ID, "widget_title"), 0);
            r11.setViewVisibility(ZeusTransformUtils.mapRes(R.id.widget_items, OaidModel.KEY_ID, "widget_items"), 0);
            r11.setViewVisibility(ZeusTransformUtils.mapRes(R.id.widget_empty, OaidModel.KEY_ID, "widget_empty"), 8);
            r11.setTextViewText(ZeusTransformUtils.mapRes(R.id.widget_title, OaidModel.KEY_ID, "widget_title"), (CharSequence) ZeusTransformUtils.preCheckCast(r9.getString(ZeusTransformUtils.mapRes(R.string.memory_widget_latest_text, TypedValues.Custom.S_STRING, "memory_widget_latest_text")), CharSequence.class, "com.obric.memorydata.plugin"));
            Intent r14 = new Intent(r9, al.class);
            r14.setAction("com.obric.memorydata.memory.ui.list.MEMORY_ITEM_CLICK");
            r11.setPendingIntentTemplate(ZeusTransformUtils.mapRes(R.id.widget_items, OaidModel.KEY_ID, "widget_items"), PendingIntent.getBroadcast(r9, al.k(), r14, 167772160));
            RemoteViews.RemoteCollectionItems.Builder r15 = new RemoteViews.RemoteCollectionItems.Builder();
            Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r16.hasNext() == false) goto L14;
            Object r2 = r16.next();
            int r5 = r3 + 1;
            if (r3 >= 0) goto L16;
            CollectionsKt.throwIndexOverflow();
        L16:
            Intrinsics.checkNotNull(r15.addItem(r3, al.f11186a.a(r9, (RawMemoryEntity) ZeusTransformUtils.preCheckCast(r2, RawMemoryEntity.class, "com.obric.memorydata.plugin"))));     // Catch: Exception -> L11
        L13:
            r3 = r5;
        L11:
            e = move-exception;
            RunLog.INSTANCE.error("MemoryWidgetProvider", "failed to create item view for index " + r3, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            goto L13
        L14:
            r15.setHasStableIds(true);
            r15.setViewTypeCount(1);
            r11.setRemoteAdapter(ZeusTransformUtils.mapRes(R.id.widget_items, OaidModel.KEY_ID, "widget_items"), r15.build());
        }

        private final void a(RemoteViews r4) {
            r4.setViewVisibility(ZeusTransformUtils.mapRes(R.id.widget_title, OaidModel.KEY_ID, "widget_title"), 8);
            r4.setViewVisibility(ZeusTransformUtils.mapRes(R.id.widget_items, OaidModel.KEY_ID, "widget_items"), 8);
            r4.setViewVisibility(ZeusTransformUtils.mapRes(R.id.widget_empty, OaidModel.KEY_ID, "widget_empty"), 0);
        }

        public static final /* synthetic */ void a(a r0) {
            r0.c();
        }

        public static final /* synthetic */ void a(a r0, e r1) {
            r0.a(r1);
        }

        private final void a(e r9) {
            Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
            AppWidgetManager r3 = AppWidgetManager.getInstance(r2);     // Catch: Exception -> L12
            int[] r4 = r3.getAppWidgetIds(new ComponentName(r2, al.class));     // Catch: Exception -> L12
            Intrinsics.checkNotNull(r4);     // Catch: Exception -> L12
            if (r4.length != 0) goto L6;
            boolean r5 = true;
        L7:
            if (r5 == false) goto L10;
            RunLog.INSTANCE.debug("MemoryWidgetProvider", "no widget instances found");     // Catch: Exception -> L12
            return;
        L10:
            RunLog.INSTANCE.debug("MemoryWidgetProvider", "updating " + r4.length + " widget instances");     // Catch: Exception -> L12
            r3.updateAppWidget(r4, a(r2, r9));     // Catch: Exception -> L12
            RunLog.INSTANCE.debug("MemoryWidgetProvider", "batch updated " + r4.length + " widgets with shared views");     // Catch: Exception -> L12
            return;
        L6:
            r5 = false;
        L12:
            e = move-exception;
            RunLog.INSTANCE.error("MemoryWidgetProvider", "failed to update widgets", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        }

        private final void a(List<RawMemoryEntity> r11, long r12) {
            List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
            if (r13.isEmpty() == false) goto L6;
            al.a(DurationKt.MAX_MILLIS);
            return;
        L6:
            RawMemoryEntity r14 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r13), RawMemoryEntity.class, "com.obric.memorydata.plugin");
            MemoryEntity r0 = com.obric.memorydata.database.entity.memoryindex.m.a().toMemoryEntity(r14);     // Catch: Exception -> L53
            if (ZeusTransformUtils.instanceOf(r0, OrderFlightMemoryEntity.class) == true) goto L41;
            if (ZeusTransformUtils.instanceOf(r0, OrderTrainMemoryEntity.class) == true) goto L41;
            if (ZeusTransformUtils.instanceOf(r0, OrderHotelMemoryEntity.class) == true) goto L41;
            if (ZeusTransformUtils.instanceOf(r0, OrderMovieTicketMemoryEntity.class) == true) goto L41;
            if (ZeusTransformUtils.instanceOf(r0, OrderTicketMemoryEntity.class) == true) goto L41;
            if (ZeusTransformUtils.instanceOf(r0, OrderCommonMemoryEntity.class) == true) goto L41;
            if (ZeusTransformUtils.instanceOf(r0, EventScheduleMemoryEntity.class) == true) goto L41;
            if (ZeusTransformUtils.instanceOf(r0, EventTodoMemoryEntity.class) == true) goto L25;
            IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L53
            StringBuilder r15 = new StringBuilder().append("Non-time-sensitive memory entity: ");     // Catch: Exception -> L53
            if (r0 == null) goto L37;
            Class<?> r16 = r0.getClass();     // Catch: Exception -> L53
            if (r16 == null) goto L37;
            String r17 = r16.getSimpleName();     // Catch: Exception -> L53
        L38:
            IRunLog.a.a(r4, "MemoryWidgetProvider", r15.append(r17).toString(), false, 4, null);     // Catch: Exception -> L53
        L39:
            long r5 = 4611686018427387903L;
        L48:
            al.a(r5);     // Catch: Exception -> L53
            if (al.i() >= 0) goto L51;
            al.a(DurationKt.MAX_MILLIS);     // Catch: Exception -> L53
        L51:
            RunLog.INSTANCE.debug("MemoryWidgetProvider", "calculated timeDelta: " + al.i());     // Catch: Exception -> L53
            return;
        L37:
            r17 = null;
            goto L38
        L25:
            if (com.obric.memorydata.utils.b.a(r14.getEndTime()) == true) goto L28;
            Long r18 = r14.getEndTime();     // Catch: Exception -> L53
            Intrinsics.checkNotNull(r18);     // Catch: Exception -> L53
        L30:
            long r6 = r18.longValue();     // Catch: Exception -> L53
        L43:
            r5 = r6 - r12;     // Catch: Exception -> L53
            goto L48
        L28:
            if (com.obric.memorydata.utils.b.a(r14.getEndDate()) == true) goto L31;
            r18 = r14.getEndDate();     // Catch: Exception -> L53
            Intrinsics.checkNotNull(r18);     // Catch: Exception -> L53
            goto L30
        L31:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryWidgetProvider", "TodoMemory without end time/date: " + r14, null, 4, null);     // Catch: Exception -> L53
        L41:
            if (com.obric.memorydata.utils.b.a(r14.getStartTime()) == true) goto L45;
            r18 = r14.getStartTime();     // Catch: Exception -> L53
            Intrinsics.checkNotNull(r18);     // Catch: Exception -> L53
            goto L30
        L45:
            if (com.obric.memorydata.utils.b.a(r14.getStartDate()) == true) goto L47;
            r18 = r14.getStartDate();     // Catch: Exception -> L53
            Intrinsics.checkNotNull(r18);     // Catch: Exception -> L53
            goto L30
        L47:
            r6 = r14.getCreateTime();     // Catch: Exception -> L53
        L53:
            e = move-exception;
            RunLog.INSTANCE.error("MemoryWidgetProvider", "failed to calculate timeDelta", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            al.a(DurationKt.MAX_MILLIS);
        }

        public static final /* synthetic */ Object b(a r2, Continuation r3) {
            return r2.c((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        private final Object b(Continuation<? super Unit> r4) {
            Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r5 = kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new MemoryWidgetProvider$Companion$doLoadDataAndUpdateWidgets$2(null), Function2.class, "com.obric.memorydata.plugin"), r3);
            if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r5;
        L6:
            return Unit.INSTANCE;
        }

        private final void b() {
            RunLog.INSTANCE.debug("MemoryWidgetProvider", "initializing components");
            kotlinx.coroutines.i.a(al.c(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryWidgetProvider$Companion$initializeComponents$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            al.e().a(al.f(), (com.obric.memorydata.ability.k) ZeusTransformUtils.preCheckCast(al.g(), com.obric.memorydata.ability.k.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L5
            IntentFilter r9 = new IntentFilter();     // Catch: Exception -> L5
            r9.addAction("android.intent.action.TIME_SET");     // Catch: Exception -> L5
            r9.addAction("android.intent.action.LOCALE_CHANGED");     // Catch: Exception -> L5
            r9.addAction("android.intent.action.TIME_TICK");     // Catch: Exception -> L5
            r9.addAction("android.intent.action.DATE_CHANGED");     // Catch: Exception -> L5
            r9.addAction("android.intent.action.TIMEZONE_CHANGED");     // Catch: Exception -> L5
            ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(al.h(), PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), r9, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            RunLog.INSTANCE.error("MemoryWidgetProvider", "failed to initialize components", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        }

        private final void b(String r9) {
            bx r8 = al.b();
            if (r8 == null) goto L5;
            bx.a.a(r8, null, 1, null);
        L5:
            al.a(kotlinx.coroutines.i.a(al.c(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryWidgetProvider$Companion$loadDataAndUpdateWidgets$1(r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));
        }

        private final Object c(Continuation<? super e> r13) {
            Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r14, MemoryWidgetProvider$Companion$loadFreshData$1.class) == false) goto L7;
            MemoryWidgetProvider$Companion$loadFreshData$1 r0 = (MemoryWidgetProvider$Companion$loadFreshData$1) ZeusTransformUtils.preCheckCast(r14, MemoryWidgetProvider$Companion$loadFreshData$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r15 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            int r4 = 1;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            long r5 = r0.J$0;
            a this = (a) ZeusTransformUtils.preCheckCast(r0.L$0, a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r15);
        L18:
            Pair r16 = (Pair) ZeusTransformUtils.preCheckCast(r15, Pair.class, "com.obric.memorydata.plugin");
            List r1 = (List) ZeusTransformUtils.preCheckCast(r16.component1(), List.class, "com.obric.memorydata.plugin");
            List r17 = (List) ZeusTransformUtils.preCheckCast(r16.component2(), List.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryWidgetProvider", "loaded " + r1.size() + " timeSensitive, " + r17.size() + " latest", false, 4, null);
            List r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            r6.addAll((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin"));
            r6.addAll((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin"));
            List<RawMemoryEntity> r7 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"), 3);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryWidgetProvider", "merged " + (r1.size() + r17.size()) + " -> " + r7.size() + " items", false, 4, null);
            if (r7.isEmpty() == false) goto L21;
            r4 = 2;
        L21:
            this.a(r7, r5);
            return new e(r7, r4, r5);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r15);
            long r8 = System.currentTimeMillis();
            Function2 r18 = (Function2) ZeusTransformUtils.preCheckCast(new MemoryWidgetProvider$Companion$loadFreshData$2(null), Function2.class, "com.obric.memorydata.plugin");
            r0.L$0 = this;
            r0.J$0 = r8;
            r0.label = 1;
            r15 = kotlinx.coroutines.am.a(r18, r0);
            if (r15 != r2) goto L17;
            return r2;
        L17:
            r5 = r8;
        L7:
            r0 = new MemoryWidgetProvider$Companion$loadFreshData$1(this, r14);
            goto L8
        }

        private final void c() {
            al.j().removeCallbacksAndMessages(null);
            if (al.i() >= DurationKt.MAX_MILLIS) goto L6;
            al.j().postDelayed($$Lambda$al$a$Xflw0uFUdITskvoPX6BcSf3a0bo.INSTANCE, al.i());
            return;
        }

        private static final void d() {
            al.f11186a.a("data elimination triggered");
        }

        public static /* synthetic */ void lambda$Xflw0uFUdITskvoPX6BcSf3a0bo() {
            d();
        }

        public final Object a(Intent r8, Continuation<? super Unit> r9) {
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r10, MemoryWidgetProvider$Companion$handleItemClick$1.class) == false) goto L7;
            MemoryWidgetProvider$Companion$handleItemClick$1 r0 = (MemoryWidgetProvider$Companion$handleItemClick$1) ZeusTransformUtils.preCheckCast(r10, MemoryWidgetProvider$Companion$handleItemClick$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r7 = r0.result;
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.label;
            if (r2 == 0) goto L17;
            if (r2 != 1) goto L16;
            ResultKt.throwOnFailure(r7);     // Catch: Exception -> L13
        L31:
            Unit r12 = (Unit) ZeusTransformUtils.preCheckCast(r7, Unit.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
        L35:
            return Unit.INSTANCE;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L17:
            ResultKt.throwOnFailure(r7);
            String r13 = r8.getStringExtra("item_id");     // Catch: Exception -> L13
            if (r13 == null) goto L21;
            RunLog.INSTANCE.debug("MemoryWidgetProvider", "item clicked: " + r13);     // Catch: Exception -> L13
            if (Build.VERSION.SDK_INT < 33) goto L27;
            Object r14 = ZeusTransformUtils.preCheckCast(r8.getParcelableExtra("memory_entity", MemoryEntity.class), MemoryEntity.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
        L26:
            MemoryEntity r15 = (MemoryEntity) r14;     // Catch: Exception -> L13
            RunLog.INSTANCE.debug("MemoryWidgetProvider", "memoryEntity: " + r15);     // Catch: Exception -> L13
            CoroutineContext r16 = (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
            Function2 r17 = (Function2) ZeusTransformUtils.preCheckCast(new MemoryWidgetProvider$Companion$handleItemClick$2(r15, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
            r0.label = 1;     // Catch: Exception -> L13
            r7 = kotlinx.coroutines.i.a(r16, r17, r0);     // Catch: Exception -> L13
            if (r7 != r11) goto L31;
            return r11;
        L27:
            r14 = ZeusTransformUtils.preCheckCast(r8.getParcelableExtra("memory_entity"), MemoryEntity.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
            goto L26
        L21:
            return Unit.INSTANCE;
        L13:
            e = move-exception;
            RunLog.INSTANCE.error("MemoryWidgetProvider", "failed to handle item click", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        L7:
            r0 = new MemoryWidgetProvider$Companion$handleItemClick$1(this, r10);
            goto L8
        }

        public final Object a(Continuation<? super Unit> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r8, MemoryWidgetProvider$Companion$handleContainerClick$1.class) == false) goto L7;
            MemoryWidgetProvider$Companion$handleContainerClick$1 r0 = (MemoryWidgetProvider$Companion$handleContainerClick$1) ZeusTransformUtils.preCheckCast(r8, MemoryWidgetProvider$Companion$handleContainerClick$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r6 = r0.result;
            Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.label;
            if (r2 == 0) goto L17;
            if (r2 != 1) goto L16;
            ResultKt.throwOnFailure(r6);     // Catch: Exception -> L13
        L24:
        L23:
            return Unit.INSTANCE;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L17:
            ResultKt.throwOnFailure(r6);
            RunLog.INSTANCE.debug("MemoryWidgetProvider", "container clicked");     // Catch: Exception -> L13
            CoroutineContext r10 = (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
            Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(new MemoryWidgetProvider$Companion$handleContainerClick$2(null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
            r0.label = 1;     // Catch: Exception -> L13
            if (kotlinx.coroutines.i.a(r10, r3, r0) != r9) goto L24;
            return r9;
        L13:
            e = move-exception;
            RunLog.INSTANCE.error("MemoryWidgetProvider", "failed to handle container click", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        L7:
            r0 = new MemoryWidgetProvider$Companion$handleContainerClick$1(this, r8);
            goto L8
        }

        public final void a() {
            RunLog.INSTANCE.debug("MemoryWidgetProvider", "cleaning up resources");
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
            a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
            ZeusTransformUtils.unregisterReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(al.h(), PluginBroadcastReceiver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
            Object r4 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L7:
            Throwable r5 = Result.m1424exceptionOrNullimpl(r4);
            if (r5 == null) goto L10;
            RunLog.INSTANCE.error("MemoryWidgetProvider", "failed to unregister receiver", r5);
        L10:
            Unit r6 = null;
            kotlinx.coroutines.i.a(al.c(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryWidgetProvider$Companion$cleanup$3(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L13
            a r8 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
            Object r9 = Result.m1421constructorimpl(Boolean.valueOf(al.e().b(al.f(), (com.obric.memorydata.ability.k) ZeusTransformUtils.preCheckCast(al.g(), com.obric.memorydata.ability.k.class, "com.obric.memorydata.plugin"))));     // Catch: Throwable -> L13
        L15:
            Throwable r10 = Result.m1424exceptionOrNullimpl(r9);
            if (r10 == null) goto L37;
            RunLog.INSTANCE.error("MemoryWidgetProvider", "failed to unsubscribe ability", r10);
        L37:
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L20
            a r12 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
            al.j().removeCallbacksAndMessages(null);     // Catch: Throwable -> L20
            Object r13 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
        L22:
            Throwable r14 = Result.m1424exceptionOrNullimpl(r13);
            if (r14 == null) goto L39;
            RunLog.INSTANCE.error("MemoryWidgetProvider", "failed to clear eliminate callbacks", r14);
        L39:
            Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L30
            a r16 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
            bx r17 = al.b();     // Catch: Throwable -> L30
            if (r17 == null) goto L28;
            bx.a.a(r17, null, 1, null);     // Catch: Throwable -> L30
            r6 = Unit.INSTANCE;     // Catch: Throwable -> L30
        L28:
            Object r18 = Result.m1421constructorimpl(r6);     // Catch: Throwable -> L30
        L32:
            Throwable r19 = Result.m1424exceptionOrNullimpl(r18);
            if (r19 == null) goto L35;
            RunLog.INSTANCE.error("MemoryWidgetProvider", "failed to cancel update job", r19);
        L35:
            al.a().set(false);
            return;
        L30:
            th = move-exception;
            Result.Companion r0 = Result.Companion;
            r18 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        L20:
            th = move-exception;
            Result.Companion r20 = Result.Companion;
            r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        L13:
            th = move-exception;
            Result.Companion r21 = Result.Companion;
            r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        L5:
            th = move-exception;
            Result.Companion r22 = Result.Companion;
            r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        public final void a(String r6) {
            Intrinsics.checkNotNullParameter(r6, NotificationCompat.CATEGORY_MESSAGE);
            RunLog.INSTANCE.debug("MemoryWidgetProvider", "reload requested: " + r6);
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            int[] r1 = AppWidgetManager.getInstance(r0).getAppWidgetIds(new ComponentName(r0, al.class));
            Intrinsics.checkNotNull(r1);
            if (r1.length != 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L10;
            RunLog.INSTANCE.debug("MemoryWidgetProvider", "skip reload because no widget instances exist");
            return;
        L10:
            if (al.a().compareAndSet(false, true) == false) goto L12;
            b();
            RunLog.INSTANCE.debug("MemoryWidgetProvider", "components initialized");
        L12:
            b(r6);
            return;
        L5:
            r2 = false;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/ui/list/MemoryWidgetProvider$Companion$abilityDataReceiver$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.ability.k {
        b() {
        }

        @Override // com.obric.memorydata.ability.k
        public void a(com.obric.memorydata.ability.data.h r4) {
            com.obric.memorydata.ability.data.h r3 = (com.obric.memorydata.ability.data.h) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "data");
            if (ZeusTransformUtils.instanceOf(r3, com.obric.memorydata.ability.data.p.class) == false) goto L8;
            RunLog.INSTANCE.debug("MemoryWidgetProvider", "screen state: " + ((com.obric.memorydata.ability.data.p) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.ability.data.p.class, "com.obric.memorydata.plugin")).a());
            if (Intrinsics.areEqual(((com.obric.memorydata.ability.data.p) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.ability.data.p.class, "com.obric.memorydata.plugin")).a(), com.tom_roush.pdfbox.pdmodel.a.d.f.f) == false) goto L9;
            al.f11186a.a("screen on");
            return;
        L9:
            return;
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return com.obric.memorydata.ability.k.a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/list/MemoryWidgetProvider$Companion$customReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends PluginBroadcastReceiver {
        c() {
        }

        public void onReceive(Context r2, Intent r3) {
            Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "context");
            Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
            RunLog.INSTANCE.debug("MemoryWidgetProvider", "in customReceiver, action: " + r3.getAction());
            String r1 = r3.getAction();
            if (r1 != null) goto L5;
            return;
        L5:
            switch(r1.hashCode()) {
                case -1513032534: goto L20;
                case -19011148: goto L17;
                case 502473491: goto L14;
                case 505380757: goto L11;
                case 1041332296: goto L8;
                default: goto L25;
            };
        L25:
            return;
        L8:
            if (r1.equals("android.intent.action.DATE_CHANGED") == false) goto L26;
        L21:
            al.f11186a.a("time changed ...");
            return;
        L26:
            return;
        L11:
            if (r1.equals("android.intent.action.TIME_SET") == true) goto L21;
            return;
        L14:
            if (r1.equals("android.intent.action.TIMEZONE_CHANGED") == true) goto L21;
            return;
        L17:
            if (r1.equals("android.intent.action.LOCALE_CHANGED") == true) goto L21;
            return;
        L20:
            if (r1.equals("android.intent.action.TIME_TICK") == true) goto L21;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006 "}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryWidgetProvider$ResourceTuple;", "", "icon", "", TraceCons.METRIC_BACKGROUND, "contentColor", "timeColor", "contentText", "", "timeText", "<init>", "(IIIILjava/lang/String;Ljava/lang/String;)V", "getIcon", "()I", "getBackground", "getContentColor", "getTimeColor", "getContentText", "()Ljava/lang/String;", "getTimeText", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f11188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f11189b;
        private final int c;
        private final int d;
        private final String e;
        private final String f;

        public d(int r2, int r3, int r4, int r5, String r6, String r7) {
            Intrinsics.checkNotNullParameter(r6, "contentText");
            Intrinsics.checkNotNullParameter(r7, "timeText");
            this.f11188a = r2;
            this.f11189b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }

        public final int a() {
            return this.f11188a;
        }

        public final int b() {
            return this.f11189b;
        }

        public final int c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public final String e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
            if (this.f11188a == r6.f11188a) goto L12;
            return false;
        L12:
            if (this.f11189b == r6.f11189b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final String f() {
            return this.f;
        }

        public int hashCode() {
            return (((((((((Integer.hashCode(this.f11188a) * 31) + Integer.hashCode(this.f11189b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
        }

        public String toString() {
            return "ResourceTuple(icon=" + this.f11188a + ", background=" + this.f11189b + ", contentColor=" + this.c + ", timeColor=" + this.d + ", contentText=" + this.e + ", timeText=" + this.f + ')';
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryWidgetProvider$WidgetData;", "", "items", "", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "memoryDataType", "", "timestamp", "", "<init>", "(Ljava/util/List;IJ)V", "getItems", "()Ljava/util/List;", "getMemoryDataType", "()I", "getTimestamp", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<RawMemoryEntity> f11190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f11191b;
        private final long c;

        public e(List<RawMemoryEntity> r3, int r4, long r5) {
            List<RawMemoryEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "items");
            this.f11190a = r6;
            this.f11191b = r4;
            this.c = r5;
        }

        public final List<RawMemoryEntity> a() {
            return this.f11190a;
        }

        public final int b() {
            return this.f11191b;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, e.class) == true) goto L8;
            return false;
        L8:
            e r8 = (e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11190a, r8.f11190a) == true) goto L12;
            return false;
        L12:
            if (this.f11191b == r8.f11191b) goto L15;
            return false;
        L15:
            if (this.c == r8.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f11190a.hashCode() * 31) + Integer.hashCode(this.f11191b)) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "WidgetData(items=" + this.f11190a + ", memoryDataType=" + this.f11191b + ", timestamp=" + this.c + ')';
        }
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [com.obric.memorydata.memory.ui.list.MemoryWidgetProvider$Companion$observer$1] */
    static {
        f11186a = new a(null);
        f11187b = 1070901206;
        c = kotlinx.coroutines.am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        e = DurationKt.MAX_MILLIS;
        f = new Handler(Looper.getMainLooper());
        g = new AtomicBoolean(false);
        h = new com.obric.memorydata.ability.d();
        i = new com.obric.memorydata.ability.f(100000005, MapsKt.emptyMap());
        j = new b();
        final String[] r0 = {"RawMemoryEntity"};
        k = new MemoryWidgetProvider$Companion$observer$1(r0);
        l = new c();
    }

    public al() {
    }

    public static final /* synthetic */ AtomicBoolean a() {
        return g;
    }

    public static final /* synthetic */ void a(long r0) {
        e = r0;
    }

    public static final /* synthetic */ void a(bx r2) {
        d = (bx) ZeusTransformUtils.wrapperContextForParams(r2, bx.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ bx b() {
        return d;
    }

    public static final /* synthetic */ kotlinx.coroutines.al c() {
        return c;
    }

    public static final /* synthetic */ MemoryWidgetProvider$Companion$observer$1 d() {
        return k;
    }

    public static final /* synthetic */ com.obric.memorydata.ability.d e() {
        return h;
    }

    public static final /* synthetic */ com.obric.memorydata.ability.f f() {
        return i;
    }

    public static final /* synthetic */ b g() {
        return j;
    }

    public static final /* synthetic */ c h() {
        return l;
    }

    public static final /* synthetic */ long i() {
        return e;
    }

    public static final /* synthetic */ Handler j() {
        return f;
    }

    public static final /* synthetic */ int k() {
        return f11187b;
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("MemoryWidgetProvider", "onDisabled");
        super.onDisabled(r5);
        f11186a.a();
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("MemoryWidgetProvider", "onEnabled");
        super.onEnabled(r5);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r11, MemorySourceLinkType.INTENT);
        RunLog.INSTANCE.debug("MemoryWidgetProvider", "onReceive - action: " + r11.getAction());
        super.onReceive(r12, r11);
        String r9 = r11.getAction();
        if (r9 == null) goto L19;
        int r13 = r9.hashCode();
        if (r13 == 1161494008) goto L14;
        if (r13 == 1940676814) goto L10;
        return;
    L10:
        if (r9.equals("com.obric.memorydata.memory.ui.list.MEMORY_CONTAINER_CLICK") == false) goto L21;
        kotlinx.coroutines.al r3 = c;
        CoroutineContext r4 = null;
        CoroutineStart r5 = null;
        Object r14 = new MemoryWidgetProvider$onReceive$2(null);
    L17:
        kotlinx.coroutines.i.a(r3, r4, r5, (Function2) ZeusTransformUtils.preCheckCast(r14, Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L21:
        return;
    L14:
        if (r9.equals("com.obric.memorydata.memory.ui.list.MEMORY_ITEM_CLICK") == false) goto L22;
        r3 = c;
        r4 = null;
        r5 = null;
        r14 = new MemoryWidgetProvider$onReceive$1(r11, null);
        goto L17
    L22:
        return;
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context r2, AppWidgetManager r3, int[] r4) {
        Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "context");
        Intrinsics.checkNotNullParameter(r3, "appWidgetManager");
        Intrinsics.checkNotNullParameter(r4, "appWidgetIds");
        RunLog.INSTANCE.debug("MemoryWidgetProvider", "onUpdate called for " + r4.length + " widgets");
        f11186a.a("onUpdate");
    }
}
