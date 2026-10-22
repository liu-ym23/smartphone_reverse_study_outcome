package com.obric.memorydata.memory.island.gr;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
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
import com.obric.capabilitykit.entity.memory.OrderCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderFlightMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderMovieTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.memory.island.BatchMemoryIslandKind;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.ui.detail.MemoryDetailActivity;
import com.obric.memorydata.memory.ui.detail.t;
import com.obric.memorydata.memory.ui.list.MemoryTab;
import com.obric.memorydata.memory.utils.o;
import com.obric.memorydata.memory.utils.q;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.sdk.memory.State;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/IslandSessionUtilsGr;", "", "<init>", "()V", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10213a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<IslandSession> f10214b = null;
    private static String c;
    private static a.C0502a d;
    private static bx e;
    private static final o f = null;
    private static long g;
    private static final al h = null;
    private static volatile Bitmap i;

    @Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010$\u001a\u00020%H\u0002J\u0006\u0010&\u001a\u00020'JR\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002002\b\b\u0002\u00102\u001a\u00020\u001b2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000bH\u0007J\u0018\u00104\u001a\u00020'2\b\b\u0002\u00105\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u00106J\u000e\u00107\u001a\u00020'H\u0082@¢\u0006\u0002\u00108J\u000e\u00109\u001a\u00020'H\u0086@¢\u0006\u0002\u00108J(\u0010:\u001a\u00020'2\u0006\u0010;\u001a\u00020<2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?J\u0016\u0010:\u001a\u00020'2\u0006\u00103\u001a\u00020\u000bH\u0087@¢\u0006\u0002\u0010AJ \u0010B\u001a\u00020'2\u0006\u0010C\u001a\u00020@2\b\u0010D\u001a\u0004\u0018\u00010\u0005H\u0087@¢\u0006\u0002\u0010EJF\u0010F\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010G\u001a\u00020H2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010<2\b\b\u0002\u0010/\u001a\u0002002\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?H\u0007J\u0010\u0010I\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0005H\u0007J\"\u0010J\u001a\u00020'2\u0006\u0010K\u001a\u00020L2\u0006\u0010G\u001a\u00020H2\b\b\u0002\u0010/\u001a\u000200H\u0007J\u0010\u0010M\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0005H\u0003J:\u0010N\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010;\u001a\u00020<2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?2\u0006\u0010/\u001a\u000200H\u0003J\u0018\u0010O\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010/\u001a\u000200H\u0003J\u0018\u0010P\u001a\u00020'2\u0006\u0010K\u001a\u00020L2\u0006\u0010/\u001a\u000200H\u0003J*\u0010Q\u001a\u0004\u0018\u00010\u000b2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010<2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?H\u0002J\u0012\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020UH\u0002J\u0010\u0010V\u001a\u00020\u00052\u0006\u0010C\u001a\u00020@H\u0002J\u0018\u0010W\u001a\u00020'2\u0006\u0010T\u001a\u00020U2\u0006\u0010X\u001a\u00020YH\u0003J\u0018\u0010W\u001a\u00020'2\u0006\u0010T\u001a\u00020U2\u0006\u0010X\u001a\u00020ZH\u0003J\u0012\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010T\u001a\u00020UH\u0003J\n\u0010_\u001a\u0004\u0018\u00010\\H\u0007J\u0010\u0010`\u001a\u00020\u00052\u0006\u0010T\u001a\u00020UH\u0002J\u0010\u0010a\u001a\u00020\u00052\u0006\u0010T\u001a\u00020UH\u0002J\b\u0010b\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010c\u001a\u00020'R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u0004\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/IslandSessionUtilsGr$Companion;", "", "<init>", "()V", "TAG", "", "islandSession", "", "Lcom/obric/memorydata/memory/island/gr/IslandSession;", "currentId", "currentContent", "Lcom/obric/memorydata/memory/island/gr/IslandSessionUtilsGr$Companion$IslandContent;", "job", "Lkotlinx/coroutines/Job;", "islandSessionMutex", "Lcom/obric/memorydata/memory/utils/ReentrantMutex;", "COLLAPSE_ICON_KEY", "EXPAND_ICON_KEY", "CALENDAR_ICON_KEY", "COMMON_ICON_KEY", "RESULT_ICON_KEY", "PROFILE_ICON_KEY", "SMALL_COLLAPSE_ICON_KEY", "ACTION_CALENDAR_CANCEL", "ACTION_CALENDAR_CONFIRM", "GR_CALENDAR_PKG", "DISMISS_SUCCESS_WITH_CALENDAR", "", "DISMISS_SUCCESS_NO_CALENDAR", "DISMISS_FAILED", "DISMISS_CALENDAR_RECOMMEND", "DISMISS_CALENDAR_CONFIRM", "lastUpdateTs", "SHOW_TIME_DELTA", "scope", "Lkotlinx/coroutines/CoroutineScope;", "createSmallCollapseWidget", "Lcom/obric/memorydata/memory/island/gr/IslandWidget;", "showEffect", "", "showIslandWidget", OaidModel.KEY_ID, "collapseWidgetData", "Lcom/obric/memorydata/memory/island/gr/MemoryCollapseTemplate;", "expandWidgetData", "Lcom/obric/memorydata/memory/island/gr/MemoryExpandedTemplate;", "collapseTitle", "needEffect", "", "needDismiss", "dismissInterval", Params.CONTENT, "autoDismiss", "delayMs", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDismissCallback", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "destroyAll", "showCalendar", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "oldEntity", "calendars", "", "Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "(Lcom/obric/memorydata/memory/island/gr/IslandSessionUtilsGr$Companion$IslandContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showCalendarConfirm", "calendarItem", "eventUuid", "(Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showMemory", "state", "", "showMemoryCancelled", "showBatchMemorySummary", "summary", "Lcom/obric/memorydata/memory/island/BatchMemoryIslandSummary;", "onPassiveMemoryFailed", "onPassiveMemorySuccess", "onPassiveMemoryBegin", "onBatchMemorySuccess", "transformEntity2Content", "buildCardClickPendingIntent", "Landroid/app/PendingIntent;", "ctx", "Landroid/content/Context;", "buildCalendarContent", "overrideCalendarIcon", "template", "Lcom/obric/memorydata/memory/island/gr/CalendarExpandedTemplate;", "Lcom/obric/memorydata/memory/island/gr/NormalExpandedTemplate;", "loadCalendarAppIcon", "Landroid/graphics/drawable/Icon;", "calendarIconBitmap", "Landroid/graphics/Bitmap;", "getCalendarIconOverride", "getAccentTextColor1", "getAccentTextColor3", "getCurrentContent", "clearCurrentContent", "IslandContent", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: com.obric.memorydata.memory.island.gr.f$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/IslandSessionUtilsGr$Companion$IslandContent;", "", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "title", "", Params.CONTENT, "calendars", "", "Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "<init>", "(Lcom/obric/capabilitykit/entity/memory/MemoryEntity;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getEntity", "()Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "getTitle", "()Ljava/lang/String;", "getContent", "getCalendars", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0502a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final MemoryEntity f10215a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f10216b;
            private final String c;
            private final List<PendingMemoryCalendar> d;

            public C0502a(MemoryEntity r3, String r4, String r5, List<PendingMemoryCalendar> r6) {
                List<PendingMemoryCalendar> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, "entity");
                Intrinsics.checkNotNullParameter(r4, "title");
                Intrinsics.checkNotNullParameter(r5, Params.CONTENT);
                Intrinsics.checkNotNullParameter(r7, "calendars");
                this.f10215a = r3;
                this.f10216b = r4;
                this.c = r5;
                this.d = r7;
            }

            public static /* synthetic */ C0502a a(C0502a r1, MemoryEntity r2, String r3, String r4, List r5, int r6, Object r7) {
                List<PendingMemoryCalendar> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
                if ((r6 & 1) == 0) goto L6;
                r2 = r1.f10215a;
            L6:
                if ((r6 & 2) == 0) goto L9;
                r3 = r1.f10216b;
            L9:
                if ((r6 & 4) == 0) goto L12;
                r4 = r1.c;
            L12:
                if ((r6 & 8) == 0) goto L15;
                r8 = r1.d;
            L15:
                return r1.a(r2, r3, r4, r8);
            }

            public final MemoryEntity a() {
                return this.f10215a;
            }

            public final C0502a a(MemoryEntity r2, String r3, String r4, List<PendingMemoryCalendar> r5) {
                List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r2, "entity");
                Intrinsics.checkNotNullParameter(r3, "title");
                Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
                Intrinsics.checkNotNullParameter(r1, "calendars");
                return new C0502a(r2, r3, r4, r1);
            }

            public final String b() {
                return this.f10216b;
            }

            public final String c() {
                return this.c;
            }

            public final List<PendingMemoryCalendar> d() {
                return this.d;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0502a.class) == true) goto L8;
                return false;
            L8:
                C0502a r6 = (C0502a) ZeusTransformUtils.preCheckCast(r5, C0502a.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f10215a, r6.f10215a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f10216b, r6.f10216b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
                return false;
            L20:
                return true;
            }

            public int hashCode() {
                return (((((this.f10215a.hashCode() * 31) + this.f10216b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
            }

            public String toString() {
                return "IslandContent(entity=" + this.f10215a + ", title=" + this.f10216b + ", content=" + this.c + ", calendars=" + this.d + ')';
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final PendingIntent a(Context r3) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "buildCardClickPendingIntent: pkg=" + r2.getPackageName());
            Intent r4 = new Intent("com.obric.memorydata.ACTION_ISLAND_CARD_CLICK").setPackage(r2.getPackageName());
            Intrinsics.checkNotNullExpressionValue(r4, "setPackage(...)");
            return PendingIntent.getBroadcast(r2, 0, r4, 201326592);
        }

        public static final /* synthetic */ PendingIntent a(a r2, Context r3) {
            return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        }

        public static final /* synthetic */ IslandWidget a(a r0) {
            return r0.e();
        }

        public static /* synthetic */ Object a(a r1, long r2, Continuation r4, int r5, Object r6) {
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            if ((r5 & 1) == 0) goto L6;
            r2 = 5000;
        L6:
            return r1.a(r2, r7);
        }

        public static final /* synthetic */ Object a(a r2, Continuation r3) {
            return r2.b((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        private final String a(PendingMemoryCalendar r12) {
            List r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            String r0 = t.f10875a.a(r12);
            boolean r3 = true;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
            boolean r2 = true;
        L6:
            String r5 = null;
            if (r2 == true) goto L10;
            r0 = null;
        L10:
            if (r0 == null) goto L12;
            r11.add(r0);
        L12:
            String r13 = r12.getLocation();
            if (r13 != null) goto L15;
        L22:
            String r14 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" · ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "buildCalendarContent: result=" + r14);
            return r14;
        L15:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L18;
            r3 = false;
        L18:
            if (r3 == false) goto L20;
            r5 = r13;
        L20:
            if (r5 == null) goto L22;
            r11.add(r5);
            goto L22
        L5:
            r2 = false;
            goto L6
        }

        private final void a(Context r10, CalendarExpandedTemplate r11) {
            Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "overrideCalendarIcon(CalendarExpandedTemplate): START");
            Icon r9 = b(r12);     // Catch: Exception -> L8
            if (r9 == null) goto L6;
            r11.getIconTextInfo().getAnimIconInfo().setIconOverride(r9);     // Catch: Exception -> L8
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "overrideCalendarIcon(CalendarExpandedTemplate): SUCCESS", false, 4, null);     // Catch: Exception -> L8
        L11:
            return;
        L6:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "overrideCalendarIcon(CalendarExpandedTemplate): icon is null, using fallback", null, 4, null);     // Catch: Exception -> L8
        L8:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtilsGr", "overrideCalendarIcon(CalendarExpandedTemplate): EXCEPTION: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        }

        private final void a(Context r10, NormalExpandedTemplate r11) {
            Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "overrideCalendarIcon(NormalExpandedTemplate): START");
            Icon r9 = b(r12);     // Catch: Exception -> L8
            if (r9 == null) goto L6;
            r11.getIconTextInfo().getAnimIconInfo().setIconOverride(r9);     // Catch: Exception -> L8
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "overrideCalendarIcon(NormalExpandedTemplate): SUCCESS", false, 4, null);     // Catch: Exception -> L8
        L11:
            return;
        L6:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "overrideCalendarIcon(NormalExpandedTemplate): icon is null, using fallback", null, 4, null);     // Catch: Exception -> L8
        L8:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtilsGr", "overrideCalendarIcon(NormalExpandedTemplate): EXCEPTION: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        }

        private final void a(com.obric.memorydata.memory.island.c r33, boolean r34) {
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f10211a.b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            com.obric.memorydata.memory.island.b r2 = (com.obric.memorydata.memory.island.b) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r33.d()), com.obric.memorydata.memory.island.b.class, "com.obric.memorydata.plugin");
            if (r2 != null) goto L5;
            return;
        L5:
            C0502a r14 = b(r2.b(), r2.c(), r33.e());
            if (r14 != null) goto L9;
            return;
        L9:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.island.gr.a.f10204a.a(r14.d()), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L11;
            long r3 = 1000;
        L12:
            long r12 = r3;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "onBatchMemorySuccess: id=" + r33.a() + ", content=" + r14.c(), false, 4, null);
            String r6 = r33.a();
            BigIslandImageTextInfoLeft r1 = new BigIslandImageTextInfoLeft(1, BigIslandPicInfo.Companion.a("miui.focus.pic_memory_result", ZeusTransformUtils.mapRes(R.drawable.ic_memory_result, "drawable", "ic_memory_result")), null, 4, null);
            String r4 = r0.getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_success, TypedValues.Custom.S_STRING, "memory_island_memory_success"));
            Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
            MemoryCollapseTemplate r7 = new MemoryCollapseTemplate(r1, new BigIslandTextInfo(null, r4, null, null, null, 29, null));
            MemoryExpandedTemplate r5 = new MemoryExpandedTemplate(new ExpandedBaseInfo(1, r14.b(), r14.c(), null, null, 24, null), new ExpandedIdentifyPicInfo(2, "miui.focus.pic_memory_result", Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_memory_result, "drawable", "ic_memory_result")), null, null, null, 56, null), null, null, 12, null);
            String r9 = r0.getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_success, TypedValues.Custom.S_STRING, "memory_island_memory_success"));
            Intrinsics.checkNotNullExpressionValue(r9, "getString(...)");
            a(r6, r7, r5, r9, r34, true, r12, r14);
            return;
        L11:
            r3 = 3000;
            goto L12
        }

        static /* synthetic */ void a(a r6, String r7, MemoryEntity r8, MemoryEntity r9, List r10, boolean r11, int r12, Object r13) {
            List<PendingMemoryCalendar> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
            if ((r12 & 4) == 0) goto L5;
            r9 = null;
        L5:
            r6.a(r7, r8, r9, r4, r11);
        }

        public static /* synthetic */ void a(a r12, String r13, MemoryCollapseTemplate r14, MemoryExpandedTemplate r15, String r16, boolean r17, boolean r18, long r19, C0502a r21, int r22, Object r23) {
            if ((r22 & 8) == 0) goto L5;
            String r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f10211a.b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_in_progress, TypedValues.Custom.S_STRING, "memory_island_memory_in_progress"));
        L7:
            if ((r22 & 32) == 0) goto L9;
            boolean r8 = false;
        L11:
            if ((r22 & 64) == 0) goto L13;
            long r9 = 3000;
        L15:
            if ((r22 & 128) == 0) goto L17;
            C0502a r11 = null;
        L18:
            r12.a(r13, r14, r15, r6, r17, r8, r9, r11);
            return;
        L17:
            r11 = r21;
            goto L18
        L13:
            r9 = r19;
            goto L15
        L9:
            r8 = r18;
            goto L11
        L5:
            r6 = r16;
            goto L7
        }

        private final void a(String r38, MemoryEntity r39, MemoryEntity r40, List<PendingMemoryCalendar> r41, boolean r42) {
            List<PendingMemoryCalendar> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r41, List.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "onPassiveMemorySuccess: id=" + r38 + ", entity.type=" + r39.getType() + ", calendars.size=" + r6.size() + ", needEffect=" + r42, false, 4, null);
            Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f10211a.b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
            C0502a r19 = b(r39, r40, r6);     // Catch: Exception -> L13
            if (r19 != null) goto L7;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "onPassiveMemorySuccess: transformEntity2Content returned null, skipping", null, 4, null);     // Catch: Exception -> L13
            return;
        L7:
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "onPassiveMemorySuccess: content.title=" + r19.b() + ", content.content=" + StringsKt.take(r19.c(), 50));     // Catch: Exception -> L13
            List<PendingMemoryCalendar> r7 = com.obric.memorydata.memory.island.gr.a.f10204a.a(r19.d());     // Catch: Exception -> L13
            boolean r10 = !((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty();     // Catch: Exception -> L13
            if (r10 == false) goto L10;
            long r11 = 1000;
        L11:
            long r13 = r11;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "onPassiveMemorySuccess: hasCalendar=" + r10 + ", filteredCalendars=" + r7.size() + '/' + r19.d().size() + ", dismissInterval=" + r13 + "ms", false, 4, null);     // Catch: Exception -> L13
            BigIslandImageTextInfoLeft r9 = new BigIslandImageTextInfoLeft(1, BigIslandPicInfo.Companion.a("miui.focus.pic_memory_result", ZeusTransformUtils.mapRes(R.drawable.ic_memory_result, "drawable", "ic_memory_result")), null, 4, null);     // Catch: Exception -> L13
            String r12 = r8.getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_success, TypedValues.Custom.S_STRING, "memory_island_memory_success"));     // Catch: Exception -> L13
            Intrinsics.checkNotNullExpressionValue(r12, "getString(...)");     // Catch: Exception -> L13
            MemoryCollapseTemplate r14 = new MemoryCollapseTemplate(r9, new BigIslandTextInfo(null, r12, null, null, null, 29, null));     // Catch: Exception -> L13
            MemoryExpandedTemplate r15 = new MemoryExpandedTemplate(new ExpandedBaseInfo(1, r19.b(), r19.c(), null, null, 24, null), new ExpandedIdentifyPicInfo(2, "miui.focus.pic_memory_result", Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_memory_result, "drawable", "ic_memory_result")), null, null, null, 56, null), null, null, 12, null);     // Catch: Exception -> L13
            String r1 = r8.getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_success, TypedValues.Custom.S_STRING, "memory_island_memory_success"));     // Catch: Exception -> L13
            Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");     // Catch: Exception -> L13
            a(r38, r14, r15, r1, r42, true, r13, r19);     // Catch: Exception -> L13
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "onPassiveMemorySuccess: showIslandWidget called");     // Catch: Exception -> L13
            return;
        L10:
            r11 = 3000;
        L13:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtilsGr", "onPassiveMemorySuccess: EXCEPTION: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        }

        private final void a(String r34, boolean r35) {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "onPassiveMemoryBegin: id=" + r34 + ", needEffect=" + r35, false, 4, null);
            BigIslandImageTextInfoLeft r6 = new BigIslandImageTextInfoLeft(1, BigIslandPicInfo.Companion.a("miui.focus.pic_memory_start", ZeusTransformUtils.mapRes(R.drawable.ic_memory_start, "drawable", "ic_memory_start")), null, 4, null);     // Catch: Exception -> L5
            String r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f10211a.b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_in_progress, TypedValues.Custom.S_STRING, "memory_island_memory_in_progress"));     // Catch: Exception -> L5
            Intrinsics.checkNotNullExpressionValue(r10, "getString(...)");     // Catch: Exception -> L5
            MemoryCollapseTemplate r12 = new MemoryCollapseTemplate(r6, new BigIslandTextInfo(null, r10, null, null, null, 29, null));     // Catch: Exception -> L5
            String r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f10211a.b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_in_progress, TypedValues.Custom.S_STRING, "memory_island_memory_in_progress"));     // Catch: Exception -> L5
            Intrinsics.checkNotNullExpressionValue(r9, "getString(...)");     // Catch: Exception -> L5
            MemoryExpandedTemplate r13 = new MemoryExpandedTemplate(new ExpandedBaseInfo(1, r9, "", null, null, 24, null), new ExpandedIdentifyPicInfo(2, "miui.focus.pic_memory_start", Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_memory_start, "drawable", "ic_memory_start")), null, null, null, 56, null), null, null, 12, null);     // Catch: Exception -> L5
            String r14 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f10211a.b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_in_progress, TypedValues.Custom.S_STRING, "memory_island_memory_in_progress"));     // Catch: Exception -> L5
            Intrinsics.checkNotNullExpressionValue(r14, "getString(...)");     // Catch: Exception -> L5
            a(this, r34, r12, r13, r14, r35, false, 0, null, 64, null);     // Catch: Exception -> L5
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "onPassiveMemoryBegin: showIslandWidget called, needDismiss=false");     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtilsGr", "onPassiveMemoryBegin: EXCEPTION: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        }

        private final Icon b(Context r8) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "loadCalendarAppIcon: loading icon for pkg=com.android.calendar");
            Drawable r9 = r7.getPackageManager().getApplicationIcon("com.android.calendar");     // Catch: Exception -> L9 PackageManager.NameNotFoundException -> L11
            Intrinsics.checkNotNullExpressionValue(r9, "getApplicationIcon(...)");     // Catch: Exception -> L9 PackageManager.NameNotFoundException -> L11
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "loadCalendarAppIcon: got drawable, class=" + r9.getClass().getSimpleName() + ", intrinsicW=" + r9.getIntrinsicWidth() + ", intrinsicH=" + r9.getIntrinsicHeight());     // Catch: Exception -> L9 PackageManager.NameNotFoundException -> L11
            if (ZeusTransformUtils.instanceOf(r9, BitmapDrawable.class) == false) goto L6;
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "loadCalendarAppIcon: drawable is BitmapDrawable, using directly");     // Catch: Exception -> L9 PackageManager.NameNotFoundException -> L11
            Bitmap r10 = ((BitmapDrawable) ZeusTransformUtils.preCheckCast(r9, BitmapDrawable.class, "com.obric.memorydata.plugin")).getBitmap();     // Catch: Exception -> L9 PackageManager.NameNotFoundException -> L11
        L7:
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "loadCalendarAppIcon: bitmap " + r10.getWidth() + 'x' + r10.getHeight() + ", byteCount=" + r10.getByteCount());     // Catch: Exception -> L9 PackageManager.NameNotFoundException -> L11
            f.a(r10);     // Catch: Exception -> L9 PackageManager.NameNotFoundException -> L11
        L16:
            return Icon.createWithBitmap(r10);
        L6:
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "loadCalendarAppIcon: drawable is " + r9.getClass().getSimpleName() + ", converting to bitmap");     // Catch: Exception -> L9 PackageManager.NameNotFoundException -> L11
            Bitmap r2 = Bitmap.createBitmap(RangesKt.coerceAtLeast(r9.getIntrinsicWidth(), 1), RangesKt.coerceAtLeast(r9.getIntrinsicHeight(), 1), Bitmap.Config.ARGB_8888);     // Catch: Exception -> L9 PackageManager.NameNotFoundException -> L11
            Intrinsics.checkNotNullExpressionValue(r2, "createBitmap(...)");     // Catch: Exception -> L9 PackageManager.NameNotFoundException -> L11
            Canvas r3 = new Canvas(r2);     // Catch: Exception -> L9 PackageManager.NameNotFoundException -> L11
            r9.setBounds(0, 0, r3.getWidth(), r3.getHeight());     // Catch: Exception -> L9 PackageManager.NameNotFoundException -> L11
            r9.draw(r3);     // Catch: Exception -> L9 PackageManager.NameNotFoundException -> L11
            r10 = r2;
        L11:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "loadCalendarAppIcon: com.android.calendar not found, using fallback icon", null, 4, null);
            return null;
        L9:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtilsGr", "loadCalendarAppIcon: EXCEPTION: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            return null;
        }

        private final C0502a b(MemoryEntity r9, MemoryEntity r10, List<PendingMemoryCalendar> r11) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
            RunLog r12 = RunLog.INSTANCE;
            StringBuilder r1 = new StringBuilder().append("transformEntity2Content: entity.class=").append(r9.getClass().getSimpleName()).append(", hasOldEntity=");
            if (r10 == null) goto L5;
            boolean r13 = true;
        L6:
            r12.debug("IslandSessionUtilsGr", r1.append(r13).append(", calendars.size=").append(r8.size()).toString());
        L74:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtilsGr", "transformEntity2Content: EXCEPTION: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            return null;
        L8:
            if (ZeusTransformUtils.instanceOf(r9, OrderFlightMemoryEntity.class) == false) goto L11;
            C0502a r14 = new C0502a(r9, MemoryTab.COLLECT.getText(), ((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r9, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getFlightNumber() + ' ' + ((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r9, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getDeparturePlace() + '-' + ((OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r9, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin")).getDestination(), r8);     // Catch: Exception -> L74
        L62:
            RunLog r15 = RunLog.INSTANCE;     // Catch: Exception -> L74
            StringBuilder r16 = new StringBuilder().append("transformEntity2Content: result → title=");     // Catch: Exception -> L74
            if (r14 == null) goto L65;
            String r2 = r14.b();     // Catch: Exception -> L74
        L66:
            StringBuilder r17 = r16.append(r2).append(", content=");     // Catch: Exception -> L74
            if (r14 == null) goto L71;
            String r3 = r14.c();     // Catch: Exception -> L74
            if (r3 == null) goto L71;
            String r4 = StringsKt.take(r3, 50);     // Catch: Exception -> L74
        L72:
            r15.debug("IslandSessionUtilsGr", r17.append(r4).toString());     // Catch: Exception -> L74
            return r14;
        L71:
            r4 = null;
            goto L72
        L65:
            r2 = null;
            goto L66
        L11:
            if (ZeusTransformUtils.instanceOf(r9, OrderTrainMemoryEntity.class) == false) goto L14;
            r14 = new C0502a(r9, MemoryTab.COLLECT.getText(), ((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r9, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getTrainNumber() + ' ' + ((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r9, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getDeparturePlace() + '-' + ((OrderTrainMemoryEntity) ZeusTransformUtils.preCheckCast(r9, OrderTrainMemoryEntity.class, "com.obric.memorydata.plugin")).getDestination(), r8);     // Catch: Exception -> L74
            goto L62
        L14:
            if (ZeusTransformUtils.instanceOf(r9, OrderHotelMemoryEntity.class) == false) goto L17;
            r14 = new C0502a(r9, MemoryTab.COLLECT.getText(), ((OrderHotelMemoryEntity) ZeusTransformUtils.preCheckCast(r9, OrderHotelMemoryEntity.class, "com.obric.memorydata.plugin")).getHotelName(), r8);     // Catch: Exception -> L74
            goto L62
        L17:
            if (ZeusTransformUtils.instanceOf(r9, OrderMovieTicketMemoryEntity.class) == false) goto L20;
            r14 = new C0502a(r9, MemoryTab.COLLECT.getText(), ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r9, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getMovieName(), r8);     // Catch: Exception -> L74
            goto L62
        L20:
            if (ZeusTransformUtils.instanceOf(r9, OrderTicketMemoryEntity.class) == false) goto L23;
            r14 = new C0502a(r9, MemoryTab.COLLECT.getText(), ((OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r9, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getName(), r8);     // Catch: Exception -> L74
            goto L62
        L23:
            if (ZeusTransformUtils.instanceOf(r9, OrderCommonMemoryEntity.class) == false) goto L26;
            r14 = new C0502a(r9, MemoryTab.COLLECT.getText(), ((OrderCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r9, OrderCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getOrderName(), r8);     // Catch: Exception -> L74
            goto L62
        L26:
            if (ZeusTransformUtils.instanceOf(r9, CollectContentMemoryEntity.class) == false) goto L29;
            r14 = new C0502a(r9, MemoryTab.COLLECT.getText(), ((CollectContentMemoryEntity) ZeusTransformUtils.preCheckCast(r9, CollectContentMemoryEntity.class, "com.obric.memorydata.plugin")).getTitle(), r8);     // Catch: Exception -> L74
            goto L62
        L29:
            if (ZeusTransformUtils.instanceOf(r9, CollectStoreMemoryEntity.class) == false) goto L32;
            r14 = new C0502a(r9, MemoryTab.COLLECT.getText(), ((CollectStoreMemoryEntity) ZeusTransformUtils.preCheckCast(r9, CollectStoreMemoryEntity.class, "com.obric.memorydata.plugin")).getStoreName(), r8);     // Catch: Exception -> L74
            goto L62
        L32:
            if (ZeusTransformUtils.instanceOf(r9, EventScheduleMemoryEntity.class) == false) goto L35;
            r14 = new C0502a(r9, MemoryTab.COLLECT.getText(), ((EventScheduleMemoryEntity) ZeusTransformUtils.preCheckCast(r9, EventScheduleMemoryEntity.class, "com.obric.memorydata.plugin")).getScheduleNme(), r8);     // Catch: Exception -> L74
            goto L62
        L35:
            if (ZeusTransformUtils.instanceOf(r9, EventTodoMemoryEntity.class) == false) goto L38;
            r14 = new C0502a(r9, MemoryTab.COLLECT.getText(), ((EventTodoMemoryEntity) ZeusTransformUtils.preCheckCast(r9, EventTodoMemoryEntity.class, "com.obric.memorydata.plugin")).getContent(), r8);     // Catch: Exception -> L74
            goto L62
        L38:
            if (ZeusTransformUtils.instanceOf(r9, InfoDocumentsMemoryEntity.class) == false) goto L44;
            String r5 = MemoryTab.PROFILE.getText();     // Catch: Exception -> L74
            StringBuilder r6 = new StringBuilder();     // Catch: Exception -> L74
            String r7 = ((InfoDocumentsMemoryEntity) ZeusTransformUtils.preCheckCast(r9, InfoDocumentsMemoryEntity.class, "com.obric.memorydata.plugin")).getPerson();     // Catch: Exception -> L74
            if (r7 != null) goto L42;
            r7 = "";
        L42:
            r14 = new C0502a(r9, r5, r6.append(r7).append(((InfoDocumentsMemoryEntity) ZeusTransformUtils.preCheckCast(r9, InfoDocumentsMemoryEntity.class, "com.obric.memorydata.plugin")).getIdType()).toString(), r8);     // Catch: Exception -> L74
            goto L62
        L44:
            if (ZeusTransformUtils.instanceOf(r9, InfoAddressMemoryEntity.class) == false) goto L47;
            r14 = new C0502a(r9, MemoryTab.PROFILE.getText(), ((InfoAddressMemoryEntity) ZeusTransformUtils.preCheckCast(r9, InfoAddressMemoryEntity.class, "com.obric.memorydata.plugin")).getAddressType(), r8);     // Catch: Exception -> L74
            goto L62
        L47:
            if (ZeusTransformUtils.instanceOf(r9, InfoAnniversaryMemoryEntity.class) == false) goto L50;
            r14 = new C0502a(r9, MemoryTab.PROFILE.getText(), ((InfoAnniversaryMemoryEntity) ZeusTransformUtils.preCheckCast(r9, InfoAnniversaryMemoryEntity.class, "com.obric.memorydata.plugin")).getAnniversaryType(), r8);     // Catch: Exception -> L74
            goto L62
        L50:
            if (ZeusTransformUtils.instanceOf(r9, InfoRelationshipMemoryEntity.class) == false) goto L53;
            r14 = new C0502a(r9, MemoryTab.PROFILE.getText(), ((InfoRelationshipMemoryEntity) ZeusTransformUtils.preCheckCast(r9, InfoRelationshipMemoryEntity.class, "com.obric.memorydata.plugin")).getPersonName() + ((InfoRelationshipMemoryEntity) ZeusTransformUtils.preCheckCast(r9, InfoRelationshipMemoryEntity.class, "com.obric.memorydata.plugin")).getRelationType(), r8);     // Catch: Exception -> L74
            goto L62
        L53:
            if (ZeusTransformUtils.instanceOf(r9, InfoCommonMemoryEntity.class) == false) goto L56;
            r14 = new C0502a(r9, MemoryTab.PROFILE.getText(), ((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r9, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")).getInfoValue(), r8);     // Catch: Exception -> L74
            goto L62
        L56:
            if (ZeusTransformUtils.instanceOf(r9, CommonTextMemoryEntity.class) == false) goto L61;
            String r18 = MemoryTab.COLLECT.getText();     // Catch: Exception -> L74
            String r19 = ((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r9, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).getTitle();     // Catch: Exception -> L74
            if (r19 != null) goto L60;
            r19 = ((CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r9, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin")).getSummary();     // Catch: Exception -> L74
        L60:
            r14 = new C0502a(r9, r18, r19, r8);     // Catch: Exception -> L74
            goto L62
        L61:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "transformEntity2Content: unknown entity type: " + r9.getClass().getSimpleName(), null, 4, null);     // Catch: Exception -> L74
            r14 = null;
            goto L62
        L5:
            r13 = false;
            goto L6
        }

        private final Object b(Continuation<? super Unit> r18) {
            Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r1, IslandSessionUtilsGr$Companion$onDismissCallback$1.class) == false) goto L7;
            IslandSessionUtilsGr$Companion$onDismissCallback$1 r3 = (IslandSessionUtilsGr$Companion$onDismissCallback$1) ZeusTransformUtils.preCheckCast(r1, IslandSessionUtilsGr$Companion$onDismissCallback$1.class, "com.obric.memorydata.plugin");
            if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
            r3.label -= Integer.MIN_VALUE;
        L8:
            Object r2 = r3.result;
            Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r5 = r3.label;
            if (r5 == 0) goto L17;
            if (r5 != 1) goto L16;
            ResultKt.throwOnFailure(r2);     // Catch: Exception -> L13
        L28:
            RunLog r0 = RunLog.INSTANCE;     // Catch: Exception -> L13
            String r6 = "onDismissCallback: calendar shown, keeping currentContent for confirm action";
        L29:
            r0.debug("IslandSessionUtilsGr", r6);     // Catch: Exception -> L13
        L35:
            return Unit.INSTANCE;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L17:
            ResultKt.throwOnFailure(r2);
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "onDismissCallback: hasCurrentContent=${currentContent != null}");
            C0502a r8 = f.f();     // Catch: Exception -> L13
            if (r8 == null) goto L21;
            C0502a r7 = C0502a.a(r8, null, null, null, null, 15, null);     // Catch: Exception -> L13
        L22:
            if (r7 == null) goto L31;
            int r9 = r7.d().size();     // Catch: Exception -> L13
            int r10 = com.obric.memorydata.memory.island.gr.a.f10204a.a(r7.d()).size();     // Catch: Exception -> L13
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "onDismissCallback: has content, calendars=" + r9 + ", filteredCalendars=" + r10 + ", calling showCalendar", false, 4, null);     // Catch: Exception -> L13
            if (r10 <= 0) goto L30;
            r3.label = 1;     // Catch: Exception -> L13
            if (a(r7, r3) != r4) goto L28;
            return r4;
        L30:
            f.a(null);     // Catch: Exception -> L13
            r0 = RunLog.INSTANCE;     // Catch: Exception -> L13
            r6 = "onDismissCallback: no filterable calendars, cleared currentContent";
            goto L29
        L31:
            r0 = RunLog.INSTANCE;     // Catch: Exception -> L13
            r6 = "onDismissCallback: no content, skipping showCalendar";
            goto L29
        L21:
            r7 = null;
        L13:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtilsGr", "onDismissCallback: EXCEPTION: ${e.message}", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        L7:
            r3 = new IslandSessionUtilsGr$Companion$onDismissCallback$1(this, r1);
            goto L8
        }

        private final void b(String r31) {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "onPassiveMemoryFailed: id=" + r31, false, 4, null);
            BigIslandImageTextInfoLeft r6 = new BigIslandImageTextInfoLeft(1, BigIslandPicInfo.Companion.a("miui.focus.pic_memory_result", ZeusTransformUtils.mapRes(R.drawable.ic_memory_result, "drawable", "ic_memory_result")), null, 4, null);     // Catch: Exception -> L5
            String r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f10211a.b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_failed, TypedValues.Custom.S_STRING, "memory_island_memory_failed"));     // Catch: Exception -> L5
            Intrinsics.checkNotNullExpressionValue(r10, "getString(...)");     // Catch: Exception -> L5
            MemoryCollapseTemplate r12 = new MemoryCollapseTemplate(r6, new BigIslandTextInfo(null, r10, null, null, null, 29, null));     // Catch: Exception -> L5
            String r15 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f10211a.b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_failed, TypedValues.Custom.S_STRING, "memory_island_memory_failed"));     // Catch: Exception -> L5
            Intrinsics.checkNotNullExpressionValue(r15, "getString(...)");     // Catch: Exception -> L5
            MemoryExpandedTemplate r7 = new MemoryExpandedTemplate(new ExpandedBaseInfo(1, r15, "", null, null, 24, null), new ExpandedIdentifyPicInfo(2, "miui.focus.pic_memory_result", Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_memory_result, "drawable", "ic_memory_result")), null, null, null, 56, null), null, null, 12, null);     // Catch: Exception -> L5
            String r14 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f10211a.b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_failed, TypedValues.Custom.S_STRING, "memory_island_memory_failed"));     // Catch: Exception -> L5
            Intrinsics.checkNotNullExpressionValue(r14, "getString(...)");     // Catch: Exception -> L5
            a(r31, r12, r7, r14, false, true, 3000, null);     // Catch: Exception -> L5
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "onPassiveMemoryFailed: showIslandWidget called with DISMISS_FAILED=3000ms");     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtilsGr", "onPassiveMemoryFailed: EXCEPTION: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        }

        private final IslandWidget e() {
            return SmallCollapseTemplate.create$default(new SmallCollapseTemplate(BigIslandPicInfo.Companion.a("miui.focus.pic_small_collapse", ZeusTransformUtils.mapRes(R.drawable.ic_island_small_icon, "drawable", "ic_island_small_icon"))), null, 1, null);
        }

        public final Object a(long r19, Continuation<? super Unit> r21) {
            long r0 = r19;
            Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r2, IslandSessionUtilsGr$Companion$autoDismiss$1.class) == false) goto L7;
            IslandSessionUtilsGr$Companion$autoDismiss$1 r4 = (IslandSessionUtilsGr$Companion$autoDismiss$1) ZeusTransformUtils.preCheckCast(r2, IslandSessionUtilsGr$Companion$autoDismiss$1.class, "com.obric.memorydata.plugin");
            if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
            r4.label -= Integer.MIN_VALUE;
        L8:
            Object r3 = r4.result;
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r6 = r4.label;
            if (r6 == 0) goto L24;
            if (r6 == 1) goto L21;
            if (r6 == 2) goto L18;
            if (r6 != 3) goto L14;
            th = (Throwable) ZeusTransformUtils.preCheckCast(r4.L$0, Throwable.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r3);     // Catch: Exception -> L45
        L44:
            throw th;     // Catch: Exception -> L45
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            Unit r1 = (Unit) ZeusTransformUtils.preCheckCast(r4.L$0, Unit.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r3);     // Catch: Exception -> L45
        L48:
            return Unit.INSTANCE;
        L21:
            r0 = r4.J$0;
            CoroutineContext.Element r7 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(r4.L$1, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
            o r11 = (o) ZeusTransformUtils.preCheckCast(r4.L$0, o.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r3);     // Catch: Exception -> L45
        L50:
        L40:
            th = th;
            r4.L$0 = th;     // Catch: Exception -> L45
            r4.L$1 = null;     // Catch: Exception -> L45
            r4.label = 3;     // Catch: Exception -> L45
            if (r11.b(r7, r4) != r5) goto L44;
            return r5;
        L30:
            if (((IslandSession) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(f.e()), IslandSession.class, "com.obric.memorydata.plugin")) == null) goto L35;
            bx r12 = f.g();     // Catch: Throwable -> L40
            if (r12 == null) goto L34;
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "autoDismiss: cancelling previous dismiss job, isActive=" + r12.a());     // Catch: Throwable -> L40
            bx.a.a(r12, null, 1, null);     // Catch: Throwable -> L40
        L34:
            a r10 = f.f10213a;     // Catch: Throwable -> L40
            f.a(i.a(f.b(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new IslandSessionUtilsGr$Companion$autoDismiss$2$1$2(r0, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));     // Catch: Throwable -> L40
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "autoDismiss: dismiss job scheduled");     // Catch: Throwable -> L40
        L36:
            r4.L$0 = Unit.INSTANCE;     // Catch: Exception -> L45
            r4.L$1 = null;     // Catch: Exception -> L45
            r4.label = 2;     // Catch: Exception -> L45
            if (r11.b(r7, r4) != r5) goto L48;
            return r5;
        L35:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "autoDismiss: no session in list, nothing to dismiss", null, 4, null);     // Catch: Throwable -> L40
            goto L36
        L24:
            ResultKt.throwOnFailure(r3);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "autoDismiss: delayMs=" + r0 + "ms, sessionCount=" + f.e().size(), false, 4, null);
            r11 = f.c();     // Catch: Exception -> L45
            r7 = r4.getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L45
            r4.L$0 = r11;     // Catch: Exception -> L45
            r4.L$1 = r7;     // Catch: Exception -> L45
            r4.J$0 = r0;     // Catch: Exception -> L45
            r4.label = 1;     // Catch: Exception -> L45
            if (r11.a(r7, r4) != r5) goto L50;
            return r5;
        L45:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtilsGr", "autoDismiss: EXCEPTION: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        L7:
            r4 = new IslandSessionUtilsGr$Companion$autoDismiss$1(this, r2);
            goto L8
        }

        public final Object a(PendingMemoryCalendar r45, String r46, Continuation<? super Unit> r47) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r47, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r5, IslandSessionUtilsGr$Companion$showCalendarConfirm$1.class) == false) goto L7;
            IslandSessionUtilsGr$Companion$showCalendarConfirm$1 r7 = (IslandSessionUtilsGr$Companion$showCalendarConfirm$1) ZeusTransformUtils.preCheckCast(r5, IslandSessionUtilsGr$Companion$showCalendarConfirm$1.class, "com.obric.memorydata.plugin");
            if ((r7.label & Integer.MIN_VALUE) == 0) goto L7;
            r7.label -= Integer.MIN_VALUE;
        L8:
            Object r6 = r7.result;
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r9 = r7.label;
            if (r9 == 0) goto L30;
            if (r9 == 1) goto L27;
            if (r9 == 2) goto L22;
            if (r9 == 3) goto L19;
            if (r9 != 4) goto L15;
            th = (Throwable) ZeusTransformUtils.preCheckCast(r7.L$0, Throwable.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r6);     // Catch: Exception -> L74
        L73:
            throw th;     // Catch: Exception -> L74
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L19:
            Unit r0 = (Unit) ZeusTransformUtils.preCheckCast(r7.L$0, Unit.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r6);     // Catch: Exception -> L74
        L67:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showCalendarConfirm: DONE", false, 4, null);     // Catch: Exception -> L74
        L77:
            return Unit.INSTANCE;
        L22:
            CoroutineContext.Element r1 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(r7.L$1, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
            o r2 = (o) ZeusTransformUtils.preCheckCast(r7.L$0, o.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L25
        L63:
            r7.L$0 = Unit.INSTANCE;     // Catch: Exception -> L74
            r7.L$1 = null;     // Catch: Exception -> L74
            r7.label = 3;     // Catch: Exception -> L74
            if (r2.b(r1, r7) != r8) goto L67;
            return r8;
        L25:
            th = th;
        L70:
            r7.L$0 = th;     // Catch: Exception -> L74
            r7.L$1 = null;     // Catch: Exception -> L74
            r7.L$2 = null;     // Catch: Exception -> L74
            r7.L$3 = null;     // Catch: Exception -> L74
            r7.label = 4;     // Catch: Exception -> L74
            if (r2.b(r1, r7) != r8) goto L73;
            return r8;
        L27:
            CoroutineContext.Element r3 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(r7.L$3, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
            o r4 = (o) ZeusTransformUtils.preCheckCast(r7.L$2, o.class, "com.obric.memorydata.plugin");
            IslandSession r10 = (IslandSession) ZeusTransformUtils.preCheckCast(r7.L$1, IslandSession.class, "com.obric.memorydata.plugin");
            Context r11 = (Context) ZeusTransformUtils.preCheckCast(r7.L$0, Context.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r6);     // Catch: Exception -> L74
            Context r12 = r11;
            o r13 = r4;
            r1 = r3;
        L80:
            IslandSession r14 = (IslandSession) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(f.e()), IslandSession.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L68
            if (r14 == null) goto L59;
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "showCalendarConfirm: destroying old session: " + r14);     // Catch: Throwable -> L68
            f.e().remove(r14);     // Catch: Throwable -> L68
            e.f10211a.a(r14);     // Catch: Throwable -> L68
        L59:
            f.e().add(r10);     // Catch: Throwable -> L68
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "showCalendarConfirm: confirm session added, total=" + f.e().size());     // Catch: Throwable -> L68
            e.f10211a.a(r10, r12);     // Catch: Throwable -> L68
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showCalendarConfirm: scheduling autoDismiss 3000ms", false, 4, null);     // Catch: Throwable -> L68
            a r15 = f.f10213a;     // Catch: Throwable -> L68
            r7.L$0 = r13;     // Catch: Throwable -> L68
            r7.L$1 = r1;     // Catch: Throwable -> L68
            r7.L$2 = null;     // Catch: Throwable -> L68
            r7.L$3 = null;     // Catch: Throwable -> L68
            r7.label = 2;     // Catch: Throwable -> L68
            if (r15.a(3000, r7) != r8) goto L62;
            return r8;
        L62:
            r2 = r13;
        L68:
            th = th;
            r2 = r13;
            goto L70
        L30:
            ResultKt.throwOnFailure(r6);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showCalendarConfirm: START, calendarTitle=" + r45.getTitle() + ", eventUuid=" + r46, false, 4, null);
            r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f10211a.b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L74
            if (Intrinsics.areEqual(r45.getEventType(), PendingMemoryCalendar.TYPE_EVENT) == false) goto L36;
            int r16 = R.string.memory_island_event_added_to_calendar;     // Catch: Exception -> L74
            String r17 = "memory_island_event_added_to_calendar";
        L37:
            String r18 = r12.getString(ZeusTransformUtils.mapRes(r16, TypedValues.Custom.S_STRING, r17));     // Catch: Exception -> L74
            Intrinsics.checkNotNullExpressionValue(r18, "getString(...)");     // Catch: Exception -> L74
            String r19 = r12.getString(ZeusTransformUtils.mapRes(R.string.memory_island_doubao_assistant, TypedValues.Custom.S_STRING, "memory_island_doubao_assistant"));     // Catch: Exception -> L74
            Intrinsics.checkNotNullExpressionValue(r19, "getString(...)");     // Catch: Exception -> L74
            NormalExpandedTemplate r110 = new NormalExpandedTemplate(new ExpandedIconTextInfo(r18, r19, null, null, null, null, new ExpandedAnimIconInfo(0, "miui.focus.pic_calendar_icon", ZeusTransformUtils.mapRes(R.drawable.ic_island_calendar, "drawable", "ic_island_calendar"), null, null, null, 57, null), 60, null), null, null, null, 14, null);     // Catch: Exception -> L74
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "showCalendarConfirm: NormalExpandedTemplate built, templateId=com.obric.island_assistant:gr_common_expand_template_16");     // Catch: Exception -> L74
            a(r12, r110);     // Catch: Exception -> L74
            if (r46 == null) goto L40;
            Intent r20 = new Intent();     // Catch: Exception -> L74
            r20.setAction("com.obric.memorydata.ACTION_OPEN_CALENDAR");     // Catch: Exception -> L74
            r20.setPackage(r12.getPackageName());     // Catch: Exception -> L74
            r20.putExtra("event_uuid", r46);     // Catch: Exception -> L74
        L41:
            RunLog r111 = RunLog.INSTANCE;     // Catch: Exception -> L74
            StringBuilder r112 = new StringBuilder().append("showCalendarConfirm: clickIntent=");     // Catch: Exception -> L74
            if (r20 == null) goto L44;
            String r113 = "OPEN_CALENDAR";
        L45:
            r111.debug("IslandSessionUtilsGr", r112.append(r113).toString());     // Catch: Exception -> L74
            if (r20 == null) goto L51;
            if (r46 == null) goto L49;
            int r21 = r46.hashCode();     // Catch: Exception -> L74
        L50:
            PendingIntent r22 = PendingIntent.getBroadcast(r12, r21, r20, 201326592);     // Catch: Exception -> L74
        L52:
            r10 = new IslandSession(new MemoryCollapseTemplate(new BigIslandImageTextInfoLeft(1, BigIslandPicInfo.Companion.a("miui.focus.pic_calendar_icon", ZeusTransformUtils.mapRes(R.drawable.ic_island_calendar, "drawable", "ic_island_calendar")), null, 4, null), new BigIslandTextInfo(null, r18, null, null, null, 29, null)).create(Boxing.boxBoolean(true)), r110.create(Boxing.boxBoolean(false)), e(), r22, ZeusTransformUtils.mapRes(R.drawable.ic_island_small_icon, "drawable", "ic_island_small_icon"), 0, SlardarSettingsConstants.PERF_KEY_MEMORY, true, true, true, false, null, null, r18, null, null, r18, null, null, null, null, null, null, 8313888, null);     // Catch: Exception -> L74
            r10.logSummary("showCalendarConfirm → ");     // Catch: Exception -> L74
            o r23 = f.c();     // Catch: Exception -> L74
            r1 = r7.getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L74
            r7.L$0 = r12;     // Catch: Exception -> L74
            r7.L$1 = r10;     // Catch: Exception -> L74
            r7.L$2 = r23;     // Catch: Exception -> L74
            r7.L$3 = r1;     // Catch: Exception -> L74
            r7.label = 1;     // Catch: Exception -> L74
            if (r23.a(r1, r7) != r8) goto L55;
            return r8;
        L55:
            r13 = r23;
            goto L80
        L49:
            r21 = 0;
            goto L50
        L51:
            r22 = null;
            goto L52
        L44:
            r113 = "null";
            goto L45
        L40:
            r20 = null;
            goto L41
        L36:
            r16 = R.string.memory_island_todo_added_to_calendar;     // Catch: Exception -> L74
            r17 = "memory_island_todo_added_to_calendar";
        L74:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtilsGr", "showCalendarConfirm: EXCEPTION: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        L7:
            r7 = new IslandSessionUtilsGr$Companion$showCalendarConfirm$1(this, r5);
            goto L8
        }

        public final Object a(C0502a r65, Continuation<? super Unit> r66) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r66, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r5, IslandSessionUtilsGr$Companion$showCalendar$2.class) == false) goto L7;
            IslandSessionUtilsGr$Companion$showCalendar$2 r7 = (IslandSessionUtilsGr$Companion$showCalendar$2) ZeusTransformUtils.preCheckCast(r5, IslandSessionUtilsGr$Companion$showCalendar$2.class, "com.obric.memorydata.plugin");
            if ((r7.label & Integer.MIN_VALUE) == 0) goto L7;
            r7.label -= Integer.MIN_VALUE;
        L8:
            Object r6 = r7.result;
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r9 = r7.label;
            if (r9 == 0) goto L30;
            if (r9 == 1) goto L27;
            if (r9 == 2) goto L22;
            if (r9 == 3) goto L19;
            if (r9 != 4) goto L15;
            th = (Throwable) ZeusTransformUtils.preCheckCast(r7.L$0, Throwable.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r6);     // Catch: Exception -> L59
        L58:
            throw th;     // Catch: Exception -> L59
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L19:
            Unit r0 = (Unit) ZeusTransformUtils.preCheckCast(r7.L$0, Unit.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r6);     // Catch: Exception -> L59
        L52:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showCalendar: DONE", false, 4, null);     // Catch: Exception -> L59
        L62:
            return Unit.INSTANCE;
        L22:
            CoroutineContext.Element r1 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(r7.L$1, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
            o r2 = (o) ZeusTransformUtils.preCheckCast(r7.L$0, o.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L25
        L48:
            r7.L$0 = Unit.INSTANCE;     // Catch: Exception -> L59
            r7.L$1 = null;     // Catch: Exception -> L59
            r7.label = 3;     // Catch: Exception -> L59
            if (r2.b(r1, r7) != r8) goto L52;
            return r8;
        L25:
            th = th;
        L55:
            r7.L$0 = th;     // Catch: Exception -> L59
            r7.L$1 = null;     // Catch: Exception -> L59
            r7.L$2 = null;     // Catch: Exception -> L59
            r7.L$3 = null;     // Catch: Exception -> L59
            r7.label = 4;     // Catch: Exception -> L59
            if (r2.b(r1, r7) != r8) goto L58;
            return r8;
        L27:
            CoroutineContext.Element r3 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(r7.L$3, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
            o r4 = (o) ZeusTransformUtils.preCheckCast(r7.L$2, o.class, "com.obric.memorydata.plugin");
            IslandSession r10 = (IslandSession) ZeusTransformUtils.preCheckCast(r7.L$1, IslandSession.class, "com.obric.memorydata.plugin");
            Context r11 = (Context) ZeusTransformUtils.preCheckCast(r7.L$0, Context.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r6);     // Catch: Exception -> L59
            Context r12 = r11;
            o r13 = r4;
            r1 = r3;
        L66:
            f.e().add(r10);     // Catch: Throwable -> L53
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "showCalendar: session added, total=" + f.e().size());     // Catch: Throwable -> L53
            e.f10211a.a(r10, r12);     // Catch: Throwable -> L53
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showCalendar: scheduling autoDismiss 5000ms", false, 4, null);     // Catch: Throwable -> L53
            a r14 = f.f10213a;     // Catch: Throwable -> L53
            r7.L$0 = r13;     // Catch: Throwable -> L53
            r7.L$1 = r1;     // Catch: Throwable -> L53
            r7.L$2 = null;     // Catch: Throwable -> L53
            r7.L$3 = null;     // Catch: Throwable -> L53
            r7.label = 2;     // Catch: Throwable -> L53
            if (r14.a(5000, r7) != r8) goto L47;
            return r8;
        L47:
            r2 = r13;
        L53:
            th = th;
            r2 = r13;
            goto L55
        L30:
            ResultKt.throwOnFailure(r6);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showCalendar(content): START, calendars.size=" + r65.d().size(), false, 4, null);
            List<PendingMemoryCalendar> r15 = com.obric.memorydata.memory.island.gr.a.f10204a.a(r65.d());     // Catch: Exception -> L59
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "showCalendar: after filter: " + r15.size() + '/' + r65.d().size());     // Catch: Exception -> L59
            if (r15.isEmpty() == false) goto L35;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showCalendar: no includable calendars after filter, SKIP", false, 4, null);     // Catch: Exception -> L59
            return Unit.INSTANCE;
        L35:
            PendingMemoryCalendar r16 = (PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r15), PendingMemoryCalendar.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L59
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showCalendar: latest calendar item: title=" + r16.getTitle() + ", eventType=" + r16.getEventType(), false, 4, null);     // Catch: Exception -> L59
            r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f10211a.b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L59
            Intent r17 = new Intent("com.obric.memorydata.ACTION_CALENDAR_CANCEL").setPackage(r12.getPackageName());     // Catch: Exception -> L59
            Intrinsics.checkNotNullExpressionValue(r17, "setPackage(...)");     // Catch: Exception -> L59
            Intent r18 = new Intent("com.obric.memorydata.ACTION_CALENDAR_CONFIRM").setPackage(r12.getPackageName());     // Catch: Exception -> L59
            Intrinsics.checkNotNullExpressionValue(r18, "setPackage(...)");     // Catch: Exception -> L59
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "showCalendar: built cancel/confirm intents, pkg=" + r12.getPackageName());     // Catch: Exception -> L59
            int r20 = ZeusTransformUtils.mapRes(R.drawable.ic_island_calendar, "drawable", "ic_island_calendar");     // Catch: Exception -> L59
            String r19 = a(r16);     // Catch: Exception -> L59
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "showCalendar: calendarContent=" + r19);     // Catch: Exception -> L59
            CalendarExpandedTemplate r21 = new CalendarExpandedTemplate(new ExpandedIconTextInfo(r16.getTitle(), r19, null, null, null, null, new ExpandedAnimIconInfo(0, "miui.focus.pic_calendar_icon", r20, null, null, null, 57, null), 60, null), CollectionsKt.listOf(new ExpandedButtonActionInfo[]{new ExpandedButtonActionInfo("miui.focus.action_calendar_cancel", r17, true, r12.getString(ZeusTransformUtils.mapRes(R.string.memory_island_ignore, TypedValues.Custom.S_STRING, "memory_island_ignore")), ZeusTransformUtils.mapRes(R.drawable.ic_island_close, "drawable", "ic_island_close"), Boxing.boxInt(2), null, 64, null), new ExpandedButtonActionInfo("miui.focus.action_calendar_confirm", r18, true, r12.getString(ZeusTransformUtils.mapRes(R.string.memory_island_add_to_calendar, TypedValues.Custom.S_STRING, "memory_island_add_to_calendar")), ZeusTransformUtils.mapRes(R.drawable.ic_island_calendar, "drawable", "ic_island_calendar"), Boxing.boxInt(2), null, 64, null)}), new ExpandedIdentifyPicInfo(1, null, null, null, null, null, 62, null), null, 8, null);     // Catch: Exception -> L59
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "showCalendar: CalendarExpandedTemplate built, templateId=com.obric.island_assistant:gr_common_expand_template_18");     // Catch: Exception -> L59
            a(r12, r21);     // Catch: Exception -> L59
            Intent r110 = MemoryDetailActivity.Companion.a(r12, r65.a(), MemoryEventTracker.SourceType.DYNAMIC_ISLAND.getValue(), true);     // Catch: Exception -> L59
            int r22 = r65.a().hashCode();     // Catch: Exception -> L38
        L40:
            PendingIntent r41 = PendingIntent.getActivity(r12, r22, r110, 201326592);     // Catch: Exception -> L59
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "showCalendar: built detail PendingIntent, requestCode=" + r22);     // Catch: Exception -> L59
            IslandSession r23 = new IslandSession(new MemoryCollapseTemplate(new BigIslandImageTextInfoLeft(1, BigIslandPicInfo.Companion.a("miui.focus.pic_calendar_icon", ZeusTransformUtils.mapRes(R.drawable.ic_island_calendar, "drawable", "ic_island_calendar")), null, 4, null), new BigIslandTextInfo(null, r16.getTitle(), null, null, null, 29, null)).create(Boxing.boxBoolean(true)), r21.create(Boxing.boxBoolean(false)), e(), r41, ZeusTransformUtils.mapRes(R.drawable.ic_island_small_icon, "drawable", "ic_island_small_icon"), 0, SlardarSettingsConstants.PERF_KEY_MEMORY, true, true, true, false, null, null, r16.getTitle(), null, null, r16.getTitle(), null, null, null, null, null, null, 8313888, null);     // Catch: Exception -> L59
            r23.logSummary("showCalendar → ");     // Catch: Exception -> L59
            o r24 = f.c();     // Catch: Exception -> L59
            r1 = r7.getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L59
            r7.L$0 = r12;     // Catch: Exception -> L59
            r7.L$1 = r23;     // Catch: Exception -> L59
            r7.L$2 = r24;     // Catch: Exception -> L59
            r7.L$3 = r1;     // Catch: Exception -> L59
            r7.label = 1;     // Catch: Exception -> L59
            if (r24.a(r1, r7) != r8) goto L43;
            return r8;
        L43:
            r10 = r23;
            r13 = r24;
            goto L66
        L38:
            e = move-exception;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showCalendar: entity.hashCode() failed, falling back to id.hashCode(): " + e.getMessage(), null, 4, null);     // Catch: Exception -> L59
            r22 = r65.a().getId().hashCode();     // Catch: Exception -> L59
        L59:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtilsGr", "showCalendar(content): EXCEPTION: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        L7:
            r7 = new IslandSessionUtilsGr$Companion$showCalendar$2(this, r5);
            goto L8
        }

        public final Object a(Continuation<? super Unit> r13) {
            Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "destroyAll: START, sessionCount=" + f.e().size(), false, 4, null);
            bx r15 = f.g();     // Catch: Exception -> L20
            if (r15 == null) goto L6;
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "destroyAll: cancelling dismiss job");     // Catch: Exception -> L20
            bx.a.a(r15, null, 1, null);     // Catch: Exception -> L20
        L6:
            f.a("");     // Catch: Exception -> L20
            f.a(null);     // Catch: Exception -> L20
            int r1 = 0;
            Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(f.e(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L20
        L8:
            if (r16.hasNext() == false) goto L18;
            Object r3 = r16.next();     // Catch: Exception -> L20
            int r4 = r1 + 1;     // Catch: Exception -> L20
            if (r1 >= 0) goto L12;
            CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L20
        L12:
            IslandSession r5 = (IslandSession) ZeusTransformUtils.preCheckCast(r3, IslandSession.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L20
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "destroyAll: [" + r1 + "] destroying session: " + r5, false, 4, null);     // Catch: Exception -> L20
            e.f10211a.a(r5);     // Catch: Exception -> L15
        L17:
            r1 = r4;
        L15:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtilsGr", "destroyAll: [" + r1 + "] error: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L20
            goto L17
        L18:
            f.e().clear();     // Catch: Exception -> L20
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "destroyAll: DONE", false, 4, null);     // Catch: Exception -> L20
        L23:
            return Unit.INSTANCE;
        L20:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtilsGr", "destroyAll: EXCEPTION: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            goto L23
        }

        public final void a() {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showEffect: triggering screen shot effect ...", false, 4, null);
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
            a r9 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
            ZeusProviderTransform.call(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getContentResolver(), Uri.parse("content://com.obric.assistantaiagent.provider.HybridAbilityProvider"), "show_screen_shot_effect", null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showEffect: triggered successfully", false, 4, null);     // Catch: Throwable -> L5
            Object r10 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L7:
            Throwable r11 = Result.m1424exceptionOrNullimpl(r10);
            if (r11 == null) goto L13;
            RunLog.INSTANCE.error("IslandSessionUtilsGr", "showEffect: error: " + r11.getMessage(), r11);
            return;
        L13:
            return;
        L5:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        public final void a(MemoryEntity r10, MemoryEntity r11, List<PendingMemoryCalendar> r12) {
            List<PendingMemoryCalendar> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r10, "entity");
            Intrinsics.checkNotNullParameter(r13, "calendars");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showCalendar(entity): entity.type=" + r10.getType() + ", calendars.size=" + r13.size(), false, 4, null);
            C0502a r9 = b(r10, r11, r13);     // Catch: Exception -> L9
            if (r9 != null) goto L7;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showCalendar(entity): transformEntity2Content returned null", null, 4, null);     // Catch: Exception -> L9
            return;
        L7:
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "showCalendar(entity): content.title=" + r9.b() + ", content.content=" + StringsKt.take(r9.c(), 50));     // Catch: Exception -> L9
            i.a(f.b(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new IslandSessionUtilsGr$Companion$showCalendar$1(r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Exception -> L9
            return;
        L9:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtilsGr", "showCalendar(entity): EXCEPTION: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final void a(com.obric.memorydata.memory.island.c r10, int r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r10, "summary");
            IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r0 = new StringBuilder().append("showBatchMemorySummary: id=").append(r10.a()).append(", state=").append(r11).append(", total=").append(r10.b()).append(", success=").append(r10.f()).append(", failure=").append(r10.c()).append(", groups=");
            Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r10.d(), Iterable.class, "com.obric.memorydata.plugin");
            Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            Iterator r2 = r1.iterator();
        L4:
            if (r2.hasNext() == false) goto L9;
            Object r5 = r2.next();
            BatchMemoryIslandKind r6 = ((com.obric.memorydata.memory.island.b) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.island.b.class, "com.obric.memorydata.plugin")).a();
            Object r7 = r4.get(r6);
            if (r7 != null) goto L8;
            r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            r4.put(r6, r7);
        L8:
            ((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin")).add(r5);
            goto L4
        L9:
            Map r8 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r4.size())), Map.class, "com.obric.memorydata.plugin");
            Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L11:
            if (r9.hasNext() == false) goto L13;
            Object r13 = r9.next();
            r8.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r13, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Integer.valueOf(((List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r13, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), List.class, "com.obric.memorydata.plugin")).size()));
            goto L11
        L13:
            IRunLog.a.a(r3, "IslandSessionUtilsGr", r0.append(r8).toString(), false, 4, null);
        L30:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtilsGr", "showBatchMemorySummary: EXCEPTION: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            return;
        L15:
            if (r11 == State.SUCCESS_NEW.ordinal()) goto L26;
            if (r11 == State.SUCCESS_UPDATE.ordinal()) goto L26;
            if (r11 != State.TIMEOUT.ordinal()) goto L22;
        L23:
            String r14 = r10.a();     // Catch: Exception -> L30
        L24:
            b(r14);     // Catch: Exception -> L30
            return;
        L22:
            if (r11 == State.FAILURE_ERROR.ordinal()) goto L23;
            return;
        L26:
            if (r10.f() <= 0) goto L28;
            a(r10, r12);     // Catch: Exception -> L30
            return;
        L28:
            r14 = r10.a();     // Catch: Exception -> L30
            goto L24
        }

        public final void a(String r27) {
            Intrinsics.checkNotNullParameter(r27, OaidModel.KEY_ID);
            String r12 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f10211a.b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_cancelled, TypedValues.Custom.S_STRING, "memory_island_memory_cancelled"));
            Intrinsics.checkNotNullExpressionValue(r12, "getString(...)");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showMemoryCancelled: id=" + r27, false, 4, null);
            a(this, r27, new MemoryCollapseTemplate(new BigIslandImageTextInfoLeft(1, BigIslandPicInfo.Companion.a("miui.focus.pic_memory_result", ZeusTransformUtils.mapRes(R.drawable.ic_memory_result, "drawable", "ic_memory_result")), null, 4, null), new BigIslandTextInfo(null, r12, null, null, null, 29, null)), new MemoryExpandedTemplate(new ExpandedBaseInfo(1, r12, "", null, null, 24, null), new ExpandedIdentifyPicInfo(2, "miui.focus.pic_memory_result", Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_memory_result, "drawable", "ic_memory_result")), null, null, null, 56, null), null, null, 12, null), r12, false, true, 0, null, 64, null);
        }

        public final void a(String r17, int r18, MemoryEntity r19, MemoryEntity r20, boolean r21, List<PendingMemoryCalendar> r22) {
            List<PendingMemoryCalendar> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r17, OaidModel.KEY_ID);
            Intrinsics.checkNotNullParameter(r5, "calendars");
            IRunLog r10 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r2 = new StringBuilder().append("showMemory: id=").append(r17).append(", state=").append(r18).append(", entity.type=");
            Object r3 = "null";
            if (r19 == null) goto L5;
            Object r4 = Integer.valueOf(r19.getType());
        L6:
            StringBuilder r6 = r2.append(r4).append(", oldEntity.type=");
            if (r20 == null) goto L9;
            r3 = Integer.valueOf(r20.getType());
        L9:
            IRunLog.a.a(r10, "IslandSessionUtilsGr", r6.append(r3).append(", calendars.size=").append(r5.size()).append(", needEffect=").append(r21).toString(), false, 4, null);
        L37:
            e = move-exception;
            RunLog.INSTANCE.error("IslandSessionUtilsGr", "showMemory: EXCEPTION: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            return;
        L11:
            if (r18 != State.BEGIN.ordinal()) goto L14;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showMemory: → BEGIN (记忆中), no auto-dismiss", false, 4, null);     // Catch: Exception -> L37
            a(r17, r21);     // Catch: Exception -> L37
            return;
        L14:
            if (r18 != State.SUCCESS_NEW.ordinal()) goto L21;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showMemory: → SUCCESS_NEW", false, 4, null);     // Catch: Exception -> L37
            if (r19 == null) goto L18;
        L17:
            a(this, r17, r19, null, r5, r21, 4, null);     // Catch: Exception -> L37
            return;
        L18:
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showMemory: SUCCESS_NEW but entity is null! → fallback to FAILED", null, 4, null);     // Catch: Exception -> L37
        L19:
            b(r17);     // Catch: Exception -> L37
            return;
        L21:
            if (r18 != State.SUCCESS_UPDATE.ordinal()) goto L30;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showMemory: → SUCCESS_UPDATE", false, 4, null);     // Catch: Exception -> L37
            if (r19 == null) goto L26;
            if (r20 == null) goto L26;
            a(r17, r19, r20, r5, r21);     // Catch: Exception -> L37
            return;
        L26:
            if (r19 == null) goto L28;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showMemory: SUCCESS_UPDATE but oldEntity is null!", null, 4, null);     // Catch: Exception -> L37
            goto L17
        L28:
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showMemory: SUCCESS_UPDATE but entity+oldEntity both null! → FAILED", null, 4, null);     // Catch: Exception -> L37
            goto L19
        L30:
            if (r18 != State.TIMEOUT.ordinal()) goto L32;
        L35:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showMemory: → TIMEOUT/FAILURE_ERROR (state=" + r18 + ')', false, 4, null);     // Catch: Exception -> L37
            goto L19
        L32:
            if (r18 == State.FAILURE_ERROR.ordinal()) goto L35;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showMemory: unknown state=" + r18 + ", ignoring", null, 4, null);     // Catch: Exception -> L37
            return;
        L5:
            r4 = "null";
            goto L6
        }

        public final void a(String r19, MemoryCollapseTemplate r20, MemoryExpandedTemplate r21, String r22, boolean r23, boolean r24, long r25, C0502a r27) {
            Intrinsics.checkNotNullParameter(r19, OaidModel.KEY_ID);
            Intrinsics.checkNotNullParameter(r20, "collapseWidgetData");
            Intrinsics.checkNotNullParameter(r21, "expandWidgetData");
            Intrinsics.checkNotNullParameter(r22, "collapseTitle");
            IRunLog r12 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r0 = new StringBuilder().append("showIslandWidget: id=").append(r19).append(", needEffect=").append(r23).append(", needDismiss=").append(r24).append(", dismissInterval=").append(r25).append("ms, collapseTitle=").append(r22).append(", hasContent=");
            if (r27 == null) goto L5;
            boolean r2 = true;
        L6:
            IRunLog.a.a(r12, "IslandSessionUtilsGr", r0.append(r2).append(", currentId=").append(f.a()).toString(), false, 4, null);
            i.a(f.b(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new IslandSessionUtilsGr$Companion$showIslandWidget$1(r19, r27, r20, r21, r22, r23, r24, r25, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            return;
        L5:
            r2 = false;
            goto L6
        }

        public final Icon b() {
            if (f.h() == null) goto L5;
            boolean r3 = true;
        L6:
            RunLog.INSTANCE.debug("IslandSessionUtilsGr", "getCalendarIconOverride: hasCachedBitmap=" + r3);
            Bitmap r4 = f.h();
            if (r4 != null) goto L11;
            return null;
        L11:
            return Icon.createWithBitmap(r4);
        L5:
            r3 = false;
            goto L6
        }

        public final C0502a c() {
            C0502a r0 = f.f();
            if (r0 == null) goto L5;
            C0502a r7 = C0502a.a(r0, null, null, null, null, 15, null);
        L6:
            RunLog r1 = RunLog.INSTANCE;
            StringBuilder r2 = new StringBuilder().append("getCurrentContent: hasContent=");
            if (r7 == null) goto L9;
            boolean r3 = true;
        L10:
            StringBuilder r4 = r2.append(r3).append(", title=");
            if (r7 == null) goto L14;
            String r5 = r7.b();
            if (r5 == null) goto L14;
        L15:
            r1.debug("IslandSessionUtilsGr", r4.append(r5).toString());
            return r7;
        L14:
            r5 = "null";
            goto L15
        L9:
            r3 = false;
            goto L10
        L5:
            r7 = null;
            goto L6
        }

        public final void d() {
            RunLog r2 = RunLog.INSTANCE;
            StringBuilder r0 = new StringBuilder().append("clearCurrentContent: was=");
            C0502a r1 = f.f();
            if (r1 == null) goto L6;
            String r3 = r1.b();
            if (r3 == null) goto L6;
        L7:
            r2.debug("IslandSessionUtilsGr", r0.append(r3).toString());
            f.a(null);
            return;
        L6:
            r3 = "null";
            goto L7
        }
    }

    static {
        f10213a = new a(null);
        f10214b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        c = "";
        f = q.a(false, 1, null);
        g = System.currentTimeMillis();
        h = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(new ak("IslandSessionUtilsGr"), CoroutineContext.class, "com.obric.memorydata.plugin")));
    }

    public static final /* synthetic */ String a() {
        return c;
    }

    public static final /* synthetic */ void a(long r0) {
        g = r0;
    }

    public static final /* synthetic */ void a(Bitmap r0) {
        i = r0;
    }

    public static final /* synthetic */ void a(a.C0502a r0) {
        d = r0;
    }

    public static final /* synthetic */ void a(String r0) {
        c = r0;
    }

    public static final /* synthetic */ void a(bx r2) {
        e = (bx) ZeusTransformUtils.wrapperContextForParams(r2, bx.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ al b() {
        return h;
    }

    public static final /* synthetic */ o c() {
        return f;
    }

    public static final /* synthetic */ long d() {
        return g;
    }

    public static final /* synthetic */ List e() {
        return f10214b;
    }

    public static final /* synthetic */ a.C0502a f() {
        return d;
    }

    public static final /* synthetic */ bx g() {
        return e;
    }

    public static final /* synthetic */ Bitmap h() {
        return i;
    }
}
