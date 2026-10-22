package com.obric.memorydata.realtimecontext;

import android.app.assist.AssistStructure;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.WebsiteEntity;
import com.obric.capabilitykit.entity.enums.AssetTypeEnum;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.dc.PageContextData;
import com.obric.memorydata.dc.PageContextRequest;
import com.obric.memorydata.dc.PageContextResult;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.realtimecontext.cache.State;
import com.obric.memorydata.realtimecontext.session.RealTimeContextLink;
import com.obric.memorydata.sdk.realtime.ActionContext;
import com.obric.memorydata.sdk.realtime.FileActionContext;
import com.obric.memorydata.sdk.realtime.PhotoActionContext;
import com.obric.memorydata.sdk.realtime.RealTimeContextResult;
import com.obric.memorydata.sdk.realtime.VideoActionContext;
import com.obric.memorydata.sdk.realtime.WebsiteActionContext;
import com.obric.memorydata.sdk.server.AssistantStateTag;
import com.obric.memorydata.sdk.server.IPoolService;
import com.obric.memorydata.sdk.service.BinderCode;
import com.obric.memorydata.utils.ak;
import com.obric.memorydata.utils.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 :2\u00020\u0001:\u0002:;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020$H\u0016J\u0018\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\tH\u0002J1\u0010/\u001a\u00020$2\b\u00100\u001a\u0004\u0018\u0001012\u000e\u00102\u001a\n\u0012\u0004\u0012\u000204\u0018\u0001032\b\b\u0002\u00105\u001a\u00020\u000fH\u0000¢\u0006\u0002\b6J\b\u00107\u001a\u00020$H\u0002J\b\u00108\u001a\u00020$H\u0002J\b\u00109\u001a\u00020$H\u0002R\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/obric/memorydata/realtimecontext/RealTimeContextService;", "Lcom/obric/memorydata/sdk/server/IPoolService;", "<init>", "()V", "binder", "Lcom/obric/memorydata/realtimecontext/RealTimeContextService$RealTimeContextServiceBinder;", "realtimeContextProcessors", "", "Lcom/obric/memorydata/realtimecontext/session/RealTimeContextLink;", "Lcom/obric/memorydata/realtimecontext/session/AbsRealTimeContextProcessor;", "defaultScope", "Lkotlinx/coroutines/CoroutineScope;", "getDefaultScope$realtime_context_obricRelease", "()Lkotlinx/coroutines/CoroutineScope;", "assistDataRequestTs", "", "assistDataJob", "Lkotlinx/coroutines/Job;", "appContentJob", "screenshotJob", "actionContextJob", "curRealTimeLink", "onScreenTracker", "Lcom/obric/memorydata/realtimecontext/tracker/OnScreenTracker;", "getOnScreenTracker$realtime_context_obricRelease", "()Lcom/obric/memorydata/realtimecontext/tracker/OnScreenTracker;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "screenCacheClearRunnable", "Ljava/lang/Runnable;", "screenTaskClearRunnable", "provideBinderCode", "Lcom/obric/memorydata/sdk/service/BinderCode;", "provideBinder", "Landroid/os/IBinder;", "onCreate", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "onBind", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onUnbind", "", "onDestroy", "registerProcessor", "link", "processor", "dispatchAssist", "assistStructure", "Landroid/app/assist/AssistStructure;", "entities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "actionContextStartMs", "dispatchAssist$realtime_context_obricRelease", "clearData", "resetBeginTs", "cancelJobAll", "Companion", "RealTimeContextServiceBinder", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RealTimeContextService implements IPoolService {
    private static final String ACTION_RECOMMEND_SCENE_VIDEO = "video";
    private static final String APPLET_CLASS_NAME = "com.obric.appletapp.ui.AppletActivity";
    private static final String APPLET_PACKAGE = "com.obric.appletapp";
    private static final Set<ComponentName> ASSIST_STRUCTURE_NER_BLACK_COMPONENT = null;
    private static final String CONTACTS_DETAIL_CLASS_NAME = "com.android.contacts.activities.ContactDetailActivity";
    private static final String CONTACTS_LIST_CLASS_NAME = "com.android.contacts.activities.DialtactsActivity";
    private static final String CONTACTS_PACKAGE = "com.android.contacts";
    public static final a Companion = null;
    private static final String MMS_DETAIL_CLASS_NAME = "com.android.mms.ui.ComposeMessageActivity";
    private static final String MMS_PACKAGE = "com.android.mms";
    private static final String NOTES_DETAIL_CLASS_NAME = "com.obric.notes.NotesActivity";
    private static final String NOTES_PACKAGE = "com.obric.notes";
    public static final String TAG = "RealTimeContextService";
    public static final String VIRTUAL_CONTACT_ID_PREFIX = "virtual_contact_";
    private static final ComponentName appletComponent = null;
    private static final ComponentName contactDetailComponent = null;
    private static final ComponentName contactsListComponent = null;
    private static final ComponentName mmsDetailComponent = null;
    private static final ComponentName notesActivityComponent = null;
    private bx actionContextJob;
    private bx appContentJob;
    private bx assistDataJob;
    private long assistDataRequestTs;
    private final b binder;
    private RealTimeContextLink curRealTimeLink;
    private final al defaultScope;
    private AtomicBoolean initialized;
    private final com.obric.memorydata.realtimecontext.tracker.a onScreenTracker;
    private final Map<RealTimeContextLink, com.obric.memorydata.realtimecontext.session.a> realtimeContextProcessors;
    private final Runnable screenCacheClearRunnable;
    private final Runnable screenTaskClearRunnable;
    private bx screenshotJob;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u000e\u0010\u001a\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/realtimecontext/RealTimeContextService$Companion;", "", "<init>", "()V", "TAG", "", "CONTACTS_PACKAGE", "ACTION_RECOMMEND_SCENE_VIDEO", "CONTACTS_LIST_CLASS_NAME", "CONTACTS_DETAIL_CLASS_NAME", "MMS_PACKAGE", "MMS_DETAIL_CLASS_NAME", "NOTES_PACKAGE", "NOTES_DETAIL_CLASS_NAME", "APPLET_PACKAGE", "APPLET_CLASS_NAME", "contactsListComponent", "Landroid/content/ComponentName;", "getContactsListComponent$realtime_context_obricRelease", "()Landroid/content/ComponentName;", "contactDetailComponent", "getContactDetailComponent$realtime_context_obricRelease", "mmsDetailComponent", "getMmsDetailComponent$realtime_context_obricRelease", "notesActivityComponent", "getNotesActivityComponent$realtime_context_obricRelease", "appletComponent", "VIRTUAL_CONTACT_ID_PREFIX", "ASSIST_STRUCTURE_NER_BLACK_COMPONENT", "", "useClientOcrSwitchOn", "", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final ComponentName a() {
            return RealTimeContextService.access$getContactsListComponent$cp();
        }

        public final ComponentName b() {
            return RealTimeContextService.access$getContactDetailComponent$cp();
        }

        public final ComponentName c() {
            return RealTimeContextService.access$getMmsDetailComponent$cp();
        }
    }

    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J,\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u0010\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J1\u0010\u0013\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\"\u0010\u0017\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\"\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J*\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011H\u0002J:\u0010'\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\u000e\u0010,\u001a\n0-R\u00060\u0000R\u00020.H\u0082@¢\u0006\u0002\u0010/J(\u00100\u001a\u00020\b2\u0006\u0010*\u001a\u00020+2\u0006\u00101\u001a\u00020$2\u000e\u0010,\u001a\n0-R\u00060\u0000R\u00020.H\u0002J\u0018\u00102\u001a\u00020\b2\u000e\u0010,\u001a\n0-R\u00060\u0000R\u00020.H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/obric/memorydata/realtimecontext/RealTimeContextService$RealTimeContextServiceBinder;", "Lcom/obric/memorydata/sdk/realtime/IRealTimeContextService$Stub;", "<init>", "(Lcom/obric/memorydata/realtimecontext/RealTimeContextService;)V", "callPkg", "", "getCallingPkg", "onHandleAssistWithCallback", "", "assistStructure", "Landroid/app/assist/AssistStructure;", "entities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "callback", "Lcom/obric/memorydata/sdk/realtime/IRealTimeContextCallback;", "onHandleAssist", "", "dumpAssistStructureViewTreeIfNeeded", "dispatchAssist", "actionContextStartMs", "", "dispatchAssist$realtime_context_obricRelease", "processAppEntity", "componentName", "Landroid/content/ComponentName;", "onHandleScreenshot", "screenshot", "Landroid/graphics/Bitmap;", "queryRealTimeContext", "Lcom/obric/memorydata/sdk/realtime/RealTimeContextResult;", ChatMessage.TYPE_QUERY, "rewriteQuery", "queryId", "processActionContext", "createEntityActionContext", "Lcom/obric/memorydata/sdk/realtime/ActionContext;", ObricMemoryConstants.KEY_PACKAGE_NAME, "activityName", "commitVideoActionContext", "sceneMatchResult", "Lcom/obric/memorydata/realtimecontext/ActionRecommendSceneMatchResult;", "realTimeData", "Lcom/obric/memorydata/realtimecontext/session/RealTimeData;", "timing", "Lcom/obric/memorydata/realtimecontext/RealTimeContextService$RealTimeContextServiceBinder$ActionContextTiming;", "Lcom/obric/memorydata/realtimecontext/RealTimeContextService;", "(Landroid/content/ComponentName;Lcom/obric/memorydata/realtimecontext/ActionRecommendSceneMatchResult;Lcom/obric/memorydata/realtimecontext/session/RealTimeData;Lcom/obric/memorydata/realtimecontext/RealTimeContextService$RealTimeContextServiceBinder$ActionContextTiming;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commitActionWithTiming", "actionContext", "logActionContextTiming", "ActionContextTiming", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class b extends com.obric.memorydata.sdk.realtime.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RealTimeContextService f12426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f12427b;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0012\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010#\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001a\u0010\u001a\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR\u001a\u0010\u001d\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010\nR\u001a\u0010 \u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010\n¨\u0006$"}, d2 = {"Lcom/obric/memorydata/realtimecontext/RealTimeContextService$RealTimeContextServiceBinder$ActionContextTiming;", "", "beginMs", "", "<init>", "(Lcom/obric/memorydata/realtimecontext/RealTimeContextService$RealTimeContextServiceBinder;J)V", "entityBuildCostMs", "getEntityBuildCostMs", "()J", "setEntityBuildCostMs", "(J)V", "scenePrepareCostMs", "getScenePrepareCostMs", "setScenePrepareCostMs", "sceneMatchCostMs", "getSceneMatchCostMs", "setSceneMatchCostMs", "sceneNodeCount", "", "getSceneNodeCount", "()I", "setSceneNodeCount", "(I)V", "preprocessCostMs", "getPreprocessCostMs", "setPreprocessCostMs", "captureStartCostMs", "getCaptureStartCostMs", "setCaptureStartCostMs", "captureAwaitCostMs", "getCaptureAwaitCostMs", "setCaptureAwaitCostMs", "commitActionCostMs", "getCommitActionCostMs", "setCommitActionCostMs", "elapsed", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        private final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f12430a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final long f12431b;
            private long c;
            private long d;
            private long e;
            private int f;
            private long g;
            private long h;
            private long i;
            private long j;

            public a(b r1, long r2) {
                this.f12430a = r1;
                this.f12431b = r2;
            }

            public final long a() {
                return this.d;
            }

            public final void a(int r1) {
                this.f = r1;
            }

            public final void a(long r1) {
                this.c = r1;
            }

            public final long b() {
                return this.e;
            }

            public final void b(long r1) {
                this.d = r1;
            }

            public final long c() {
                return this.h;
            }

            public final void c(long r1) {
                this.e = r1;
            }

            public final long d() {
                return this.i;
            }

            public final void d(long r1) {
                this.g = r1;
            }

            public final long e() {
                return SystemClock.elapsedRealtime() - this.f12431b;
            }

            public final void e(long r1) {
                this.h = r1;
            }

            public final void f(long r1) {
                this.i = r1;
            }

            public final void g(long r1) {
                this.j = r1;
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.realtimecontext.RealTimeContextService$b$b, reason: collision with other inner class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class C0664b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f12432a = null;

            static {
                int[] r0 = new int[State.values().length];
                r0[State.CACHED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[State.CACHING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f12432a = r0;
            }
        }

        public b(final RealTimeContextService r4) {
            this.f12426a = r4;
            com.obric.memorydata.sdk.server.assistant.a.f12858a.a(AssistantStateTag.REALTIME_CONTEXT, (com.obric.memorydata.sdk.server.assistant.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4, this), com.obric.memorydata.sdk.server.assistant.b.class, "com.obric.memorydata.plugin"));
        }

        private final ActionContext a(String r12, String r13, List<? extends AppEntity> r14) {
            List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
            Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin");
            if (r15 != null) goto L5;
        L8:
            boolean r16 = true;
        L10:
            if (r16 == false) goto L12;
            return null;
        L12:
            if (r11.size() != 1) goto L30;
            AppEntity r17 = (AppEntity) ZeusTransformUtils.preCheckCast(r11.get(0), AppEntity.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r17, PhotoEntity.class) == false) goto L21;
            if (((PhotoEntity) ZeusTransformUtils.preCheckCast(r17, PhotoEntity.class, "com.obric.memorydata.plugin")).getAssetType() == AssetTypeEnum.PHOTO) goto L19;
            return null;
        L19:
            Object r18 = new PhotoActionContext(0, r12, r13, (PhotoEntity) ZeusTransformUtils.preCheckCast(r17, PhotoEntity.class, "com.obric.memorydata.plugin"), 1, null);
        L28:
            return (ActionContext) ZeusTransformUtils.preCheckCast(r18, ActionContext.class, "com.obric.memorydata.plugin");
        L21:
            if (ZeusTransformUtils.instanceOf(r17, FileEntity.class) == false) goto L25;
            r18 = new FileActionContext(0, r12, r13, (FileEntity) ZeusTransformUtils.preCheckCast(r17, FileEntity.class, "com.obric.memorydata.plugin"), 1, null);
            goto L28
        L25:
            if (ZeusTransformUtils.instanceOf(r17, WebsiteEntity.class) == false) goto L29;
            r18 = new WebsiteActionContext(0, r12, r13, (WebsiteEntity) ZeusTransformUtils.preCheckCast(r17, WebsiteEntity.class, "com.obric.memorydata.plugin"), 1, null);
            goto L28
        L29:
            return null;
        L30:
            return null;
        L5:
            if (r15.isEmpty() == true) goto L8;
            r16 = false;
            goto L10
        }

        private final Object a(ComponentName r23, com.obric.memorydata.realtimecontext.a r24, com.obric.memorydata.realtimecontext.session.c r25, a r26, Continuation<? super Unit> r27) {
            b r1 = this;
            a r9 = r26;
            Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r27, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r0, RealTimeContextService$RealTimeContextServiceBinder$commitVideoActionContext$1.class) == false) goto L7;
            RealTimeContextService$RealTimeContextServiceBinder$commitVideoActionContext$1 r2 = (RealTimeContextService$RealTimeContextServiceBinder$commitVideoActionContext$1) ZeusTransformUtils.preCheckCast(r0, RealTimeContextService$RealTimeContextServiceBinder$commitVideoActionContext$1.class, "com.obric.memorydata.plugin");
            if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
            r2.label -= Integer.MIN_VALUE;
        L8:
            RealTimeContextService$RealTimeContextServiceBinder$commitVideoActionContext$1 r3 = r2;
            Object r4 = r3.result;
            Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r5 = r3.label;
            if (r5 == 0) goto L20;
            if (r5 != 1) goto L19;
            long r6 = r3.J$0;
            a r7 = (a) ZeusTransformUtils.preCheckCast(r3.L$3, a.class, "com.obric.memorydata.plugin");
            com.obric.memorydata.realtimecontext.session.c r8 = (com.obric.memorydata.realtimecontext.session.c) ZeusTransformUtils.preCheckCast(r3.L$2, com.obric.memorydata.realtimecontext.session.c.class, "com.obric.memorydata.plugin");
            ComponentName r10 = (ComponentName) ZeusTransformUtils.preCheckCast(r3.L$1, ComponentName.class, "com.obric.memorydata.plugin");
            b r11 = (b) ZeusTransformUtils.preCheckCast(r3.L$0, b.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L14 CancellationException -> L16
            r9 = r7;
            r1 = r11;
        L72:
            PageContextResult r13 = (PageContextResult) ZeusTransformUtils.preCheckCast(r4, PageContextResult.class, "com.obric.memorydata.plugin");     // Catch: CancellationException -> L16 Throwable -> L58
            if (r13 == null) goto L66;
            PageContextData r14 = r13.getData();     // Catch: CancellationException -> L16 Throwable -> L58
            if (r14 == null) goto L66;
            String r15 = r14.getUrl();     // Catch: CancellationException -> L16 Throwable -> L58
            if (r15 == null) goto L66;
        L56:
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L66;
            String r16 = r15;
        L67:
            r9.f(SystemClock.elapsedRealtime() - r6);
            if (r16 != null) goto L70;
            b r17 = (b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "commit video action context skipped, url is empty, packageName=" + r10.getPackageName() + ", activityName=" + r10.getClassName(), false, 4, null);
        L24:
            r17.a(r9);
        L26:
            return Unit.INSTANCE;
        L70:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "commit video action context, packageName=" + r10.getPackageName() + ", activityName=" + r10.getClassName() + ", urlHash=" + r16.hashCode() + ", urlLength=" + r16.length(), false, 4, null);
            RunLog.INSTANCE.debug(RealTimeContextService.TAG, "commit video action context, url=" + r16);
            String r18 = r10.getPackageName();
            Intrinsics.checkNotNullExpressionValue(r18, "getPackageName(...)");
            String r19 = r10.getClassName();
            Intrinsics.checkNotNullExpressionValue(r19, "getClassName(...)");
            r1.a(r8, (ActionContext) ZeusTransformUtils.preCheckCast(new VideoActionContext(0, r18, r19, r16, 1, null), ActionContext.class, "com.obric.memorydata.plugin"), r9);
        L66:
            r16 = null;
        L58:
            th = th;
        L65:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "video action context capture failed: " + th.getClass().getSimpleName(), null, 4, null);
        L14:
            th = th;
            r9 = r7;
            r1 = r11;
            goto L65
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L20:
            ResultKt.throwOnFailure(r4);
            if (r23 != null) goto L27;
            r17 = (b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.memorydata.plugin");
            IRunLog r20 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            boolean r21 = false;
            int r22 = 4;
            Object r28 = null;
            String r29 = RealTimeContextService.TAG;
            String r30 = "commit video action context skipped, componentName is null";
        L23:
            IRunLog.a.a(r20, r29, r30, r21, r22, r28);
            goto L24
        L27:
            boolean r31 = false;
            if (r24 != null) goto L30;
        L32:
            if (r31 == true) goto L38;
            IRunLog r32 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r33 = new StringBuilder().append("commit video action context skipped, scene rule not matched, packageName=").append(r23.getPackageName()).append(", activityName=").append(r23.getClassName()).append(", reason=");
            if (r24 == null) goto L36;
            String r110 = r24.b();
        L37:
            IRunLog.a.a(r32, RealTimeContextService.TAG, r33.append(r110).toString(), false, 4, null);
            r1.a(r9);
            goto L26
        L36:
            r110 = null;
            goto L37
        L38:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "try commit video action context, packageName=" + r23.getPackageName() + ", activityName=" + r23.getClassName(), false, 4, null);
            long r111 = SystemClock.elapsedRealtime();
            com.obric.memorydata.dc.a r34 = com.obric.memorydata.dc.b.f9848a.a(new PageContextRequest(r23, 0, 2, null));
            if (r34 != null) goto L41;
            r17 = (b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.memorydata.plugin");
            r9.e(SystemClock.elapsedRealtime() - r111);
            r20 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            r30 = "commit video action context skipped, capture not started, packageName=" + r23.getPackageName() + ", activityName=" + r23.getClassName();
            r21 = false;
            r22 = 4;
            r28 = null;
            r29 = RealTimeContextService.TAG;
            goto L23
        L41:
            r9.e(SystemClock.elapsedRealtime() - r111);
            r6 = SystemClock.elapsedRealtime();
            ar<PageContextResult> r35 = r34.a();     // Catch: CancellationException -> L16 Throwable -> L62
            r3.L$0 = r1;     // Catch: CancellationException -> L16 Throwable -> L62
            r3.L$1 = r23;     // Catch: CancellationException -> L16 Throwable -> L62
            r8 = r25;
            r3.L$2 = r8;     // Catch: CancellationException -> L16 Throwable -> L60
            r3.L$3 = r9;     // Catch: CancellationException -> L16 Throwable -> L60
            r3.J$0 = r6;     // Catch: CancellationException -> L16 Throwable -> L60
            r3.label = 1;     // Catch: CancellationException -> L16 Throwable -> L60
            r4 = r35.a(r3);     // Catch: CancellationException -> L16 Throwable -> L60
            if (r4 != r12) goto L47;
            return r12;
        L47:
            r10 = r23;
        L60:
            th = th;
        L64:
            r10 = r23;
        L62:
            th = th;
            r8 = r25;
            goto L64
        L30:
            if (r24.a() != true) goto L32;
            r31 = true;
        L16:
            e = move-exception;
            throw e;
        L7:
            r2 = new RealTimeContextService$RealTimeContextServiceBinder$commitVideoActionContext$1(r1, r0);
            goto L8
        }

        public static final /* synthetic */ Object a(b r6, ComponentName r7, com.obric.memorydata.realtimecontext.a r8, com.obric.memorydata.realtimecontext.session.c r9, a r10, Continuation r11) {
            return r6.a(r7, r8, r9, r10, (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin"));
        }

        private final String a() {
            int r3 = Binder.getCallingUid();
            String[] r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackagesForUid(r3);
            if (r4 != null) goto L7;
            return null;
        L7:
            return (String) ZeusTransformUtils.preCheckCast(ArraysKt.getOrNull(r4, 0), String.class, "com.obric.memorydata.plugin");
        }

        public static final /* synthetic */ String a(b r0) {
            return r0.a();
        }

        private final void a(AssistStructure r4) {
            if (AppContext.INSTANCE.isDebug() == true) goto L5;
            return;
        L5:
            if (r4 == null) goto L14;
            ComponentName r0 = r4.getActivityComponent();
            if (r0 != null) goto L10;
            return;
        L10:
            if (d.f12461a.b(RealTimeContextService.ACTION_RECOMMEND_SCENE_VIDEO, r0) == true) goto L12;
            return;
        L12:
            j.f12471a.a(r4, this.f12426a.getDefaultScope$realtime_context_obricRelease());
            return;
        }

        private final void a(a r7) {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "[actionContextCost] match=" + (r7.a() + r7.b()) + ", capture=" + (r7.c() + r7.d()) + ", total=" + r7.e(), false, 4, null);
        }

        public static final /* synthetic */ void a(b r0, com.obric.memorydata.realtimecontext.session.c r1, ActionContext r2, a r3) {
            r0.a(r1, r2, r3);
        }

        public static final /* synthetic */ void a(b r0, String r1) {
            r0.f12427b = r1;
        }

        private final void a(com.obric.memorydata.realtimecontext.session.c r3, ActionContext r4, a r5) {
            long r0 = SystemClock.elapsedRealtime();
            r3.a(r4);
            r5.g(SystemClock.elapsedRealtime() - r0);
            a(r5);
        }

        private final void a(List<? extends AppEntity> r13, ComponentName r14) {
            List<? extends AppEntity> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
            if (AppContext.INSTANCE.isDebug() == false) goto L13;
            RunLog r0 = RunLog.INSTANCE;
            StringBuilder r2 = new StringBuilder().append("[processAppEntity] screen appEntity ");
            if (r15 == null) goto L11;
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
            Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r8 = r6.iterator();
        L8:
            if (r8.hasNext() == false) goto L10;
            r7.add((AppEntity) ZeusTransformUtils.preCheckCast(r8.next(), AppEntity.class, "com.obric.memorydata.plugin"));
            goto L8
        L10:
            List r9 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
        L12:
            r0.debug(RealTimeContextService.TAG, r2.append(r9).toString());
        L18:
            com.obric.memorydata.realtimecontext.session.a r1 = (com.obric.memorydata.realtimecontext.session.a) ZeusTransformUtils.preCheckCast(RealTimeContextService.access$getRealtimeContextProcessors$p(this.f12426a).get(RealTimeContextService.access$getCurRealTimeLink$p(this.f12426a)), com.obric.memorydata.realtimecontext.session.a.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L67;
            com.obric.memorydata.realtimecontext.session.c r3 = r1.b();
            if (r3 == null) goto L71;
            Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L26;
        L29:
            boolean r5 = true;
        L30:
            if (r5 == false) goto L33;
            r3.a(7);
            return;
        L33:
            RealTimeContextService.access$getAssistDataRequestTs$p(this.f12426a);
            if (r14 == null) goto L36;
            com.obric.memorydata.realtimecontext.cache.c r10 = com.obric.memorydata.realtimecontext.cache.f.f12457a.a(r14, r15);
        L37:
            if (r10 != null) goto L39;
        L59:
            bx r11 = RealTimeContextService.access$getAppContentJob$p(this.f12426a);
            if (r11 == null) goto L62;
            bx.a.a(r11, null, 1, null);
        L62:
            RealTimeContextService r12 = this.f12426a;
            RealTimeContextService.access$setAppContentJob$p(r12, kotlinx.coroutines.i.a(r12.getDefaultScope$realtime_context_obricRelease(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new RealTimeContextService$RealTimeContextServiceBinder$processAppEntity$4(r15, r14, r3, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));
            return;
        L39:
            if (r10.a() == false) goto L59;
            int r16 = C0664b.f12432a[r10.b().ordinal()];
            if (r16 == 1) goto L47;
            if (r16 == 2) goto L45;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "[processAppEntity] donation cache hit, but state illegal", null, 4, null);
            return;
        L45:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "[processAppEntity] donation cache hit, ignore current request", false, 4, null);
            return;
        L47:
            if (AppContext.INSTANCE.isDebug() == false) goto L57;
            RunLog r17 = RunLog.INSTANCE;
            StringBuilder r18 = new StringBuilder().append("[processAppEntity] donation cache hit, appEntity: ");
            Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r10.d(), Iterable.class, "com.obric.memorydata.plugin");
            Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r21 = r19.iterator();
        L50:
            if (r21.hasNext() == false) goto L52;
            r20.add((AppEntity) ZeusTransformUtils.preCheckCast(r21.next(), AppEntity.class, "com.obric.memorydata.plugin"));
            goto L50
        L52:
            r17.debug(RealTimeContextService.TAG, r18.append((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin")).toString());
            RunLog r110 = RunLog.INSTANCE;
            StringBuilder r111 = new StringBuilder().append("[processAppEntity] donation cache hit, metaValue: ");
            Iterable r112 = (Iterable) ZeusTransformUtils.preCheckCast(r10.c(), Iterable.class, "com.obric.memorydata.plugin");
            Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r113 = r112.iterator();
        L54:
            if (r113.hasNext() == false) goto L56;
            r22.add((MetaValue) ZeusTransformUtils.preCheckCast(r113.next(), MetaValue.class, "com.obric.memorydata.plugin"));
            goto L54
        L56:
            r110.debug(RealTimeContextService.TAG, r111.append((List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.memorydata.plugin")).toString());
        L58:
            r3.b(r10.d());
            r3.a(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r10.c(), Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r3.a(), Iterable.class, "com.obric.memorydata.plugin")));
            r3.a(3);
            return;
        L57:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "[processAppEntity] donation cache hit, appEntity: " + r10.d().size(), false, 4, null);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "[processAppEntity] donation cache hit, metaValue: " + r10.c().size(), false, 4, null);
            goto L58
        L36:
            r10 = null;
            goto L37
        L26:
            if (r4.isEmpty() == true) goto L29;
            r5 = false;
            goto L30
        L71:
            return;
        L67:
            return;
        L11:
            r9 = null;
            goto L12
        L13:
            IRunLog r23 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r24 = new StringBuilder().append("[processAppEntity] screen appEntity ");
            if (r15 == null) goto L16;
            Integer r25 = Integer.valueOf(r15.size());
        L17:
            IRunLog.a.a(r23, RealTimeContextService.TAG, r24.append(r25).toString(), false, 4, null);
            goto L18
        L16:
            r25 = null;
            goto L17
        }

        public static final /* synthetic */ String b(b r0) {
            return r0.f12427b;
        }

        private final void b(AssistStructure r20, List<? extends AppEntity> r21, long r22) {
            List<? extends AppEntity> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
            a r4 = new a(this, r22);
            com.obric.memorydata.realtimecontext.session.a r3 = (com.obric.memorydata.realtimecontext.session.a) ZeusTransformUtils.preCheckCast(RealTimeContextService.access$getRealtimeContextProcessors$p(this.f12426a).get(RealTimeContextService.access$getCurRealTimeLink$p(this.f12426a)), com.obric.memorydata.realtimecontext.session.a.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L53;
            com.obric.memorydata.realtimecontext.session.c r5 = r3.b();
            if (r5 == null) goto L54;
            String r6 = "";
            if (r20 == null) goto L13;
            ComponentName r7 = r20.getActivityComponent();
            if (r7 == null) goto L13;
            String r8 = r7.getPackageName();
            if (r8 == null) goto L13;
        L14:
            if (r20 == null) goto L22;
            ComponentName r9 = r20.getActivityComponent();
            if (r9 == null) goto L22;
            String r10 = r9.getClassName();
            if (r10 == null) goto L22;
            r6 = r10;
        L22:
            if (AppContext.INSTANCE.isDebug() == false) goto L32;
            RunLog r11 = RunLog.INSTANCE;
            StringBuilder r12 = new StringBuilder().append("[processActionContext] packageName: ").append(r8).append(", activityName: ").append(r6).append(", appEntity: ");
            if (r1 == null) goto L30;
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
            Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r15 = r13.iterator();
        L27:
            if (r15.hasNext() == false) goto L29;
            r14.add((AppEntity) ZeusTransformUtils.preCheckCast(r15.next(), AppEntity.class, "com.obric.memorydata.plugin"));
            goto L27
        L29:
            List r16 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin");
        L31:
            r11.debug(RealTimeContextService.TAG, r12.append(r16).toString());
        L38:
            if (Intrinsics.areEqual(AppInfo.OAssistant.getPackageName(), r8) == false) goto L40;
            return;
        L40:
            if (r20 == null) goto L42;
            ComponentName r17 = r20.getActivityComponent();
        L43:
            long r18 = SystemClock.elapsedRealtime();
            ActionContext r2 = a(r8, r6, r1);
            r4.a(SystemClock.elapsedRealtime() - r18);
            if (r2 != null) goto L46;
            long r19 = SystemClock.elapsedRealtime();
            com.obric.memorydata.realtimecontext.b r23 = d.f12461a.a(RealTimeContextService.ACTION_RECOMMEND_SCENE_VIDEO, r17);
            r4.b(SystemClock.elapsedRealtime() - r19);
            long r24 = SystemClock.elapsedRealtime();
            com.obric.memorydata.realtimecontext.a r0 = d.f12461a.a(r23, r20);
            r4.c(SystemClock.elapsedRealtime() - r24);
            r4.a(r0.c());
            d.f12461a.a(r23, r0);
            com.obric.memorydata.realtimecontext.a r25 = r0;
        L47:
            r4.d(r4.e());
            bx r26 = RealTimeContextService.access$getActionContextJob$p(this.f12426a);
            if (r26 == null) goto L50;
            bx.a.a(r26, null, 1, null);
        L50:
            RealTimeContextService r27 = this.f12426a;
            RealTimeContextService.access$setActionContextJob$p(r27, kotlinx.coroutines.i.a(r27.getDefaultScope$realtime_context_obricRelease(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new RealTimeContextService$RealTimeContextServiceBinder$processActionContext$2(r2, this, r5, r4, r17, r25, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));
            return;
        L46:
            r25 = null;
            goto L47
        L42:
            r17 = null;
            goto L43
        L30:
            r16 = null;
            goto L31
        L32:
            IRunLog r110 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r28 = new StringBuilder().append("[processActionContext] packageName: ").append(r8).append(", activityName: ").append(r6).append(", appEntity: ");
            if (r1 == null) goto L35;
            Integer r29 = Integer.valueOf(r1.size());
        L36:
            IRunLog.a.a(r110, RealTimeContextService.TAG, r28.append(r29).toString(), false, 4, null);
            goto L38
        L35:
            r29 = null;
        L13:
            r8 = "";
            goto L14
        L54:
            return;
        }

        @Override // com.obric.memorydata.sdk.realtime.b
        public RealTimeContextResult a(String r9, String r10, String r11) {
            if (ak.f13164a.a() == true) goto L10;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "queryRealTimeContext", false, 4, null);
            com.obric.memorydata.realtimecontext.session.a r8 = (com.obric.memorydata.realtimecontext.session.a) ZeusTransformUtils.preCheckCast(RealTimeContextService.access$getRealtimeContextProcessors$p(this.f12426a).get(RealTimeContextLink.CLIENT), com.obric.memorydata.realtimecontext.session.a.class, "com.obric.memorydata.plugin");
            if (r8 == null) goto L9;
            RealTimeContextResult r12 = r8.a(r9, r10, r11);
            if (r12 == null) goto L9;
            return r12;
        L9:
            return RealTimeContextResult.Companion.a();
        L10:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "call is refuse", null, 4, null);
            throw new SecurityException("call is refuse");
        }

        @Override // com.obric.memorydata.sdk.realtime.b
        public void a(AssistStructure r9, List<? extends AppEntity> r10) {
            List<? extends AppEntity> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "onHandleAssist", false, 4, null);
            if (ak.f13164a.a() == false) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "call is refuse", null, 4, null);
            return;
        L6:
            RealTimeContextService.access$setCurRealTimeLink$p(this.f12426a, RealTimeContextLink.CLIENT);
            com.obric.memorydata.realtimecontext.session.a r8 = (com.obric.memorydata.realtimecontext.session.a) ZeusTransformUtils.preCheckCast(RealTimeContextService.access$getRealtimeContextProcessors$p(this.f12426a).get(RealTimeContextLink.CLIENT), com.obric.memorydata.realtimecontext.session.a.class, "com.obric.memorydata.plugin");
            if (r8 == null) goto L10;
            r8.a(r9, r11);
            return;
        }

        public final void a(AssistStructure r11, List<? extends AppEntity> r12, long r13) {
            List<? extends AppEntity> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "[dispatchAssist]", false, 4, null);
            String r0 = null;
            if (r11 == null) goto L5;
            ComponentName r2 = r11.getActivityComponent();
        L6:
            if (r11 == null) goto L8;
            if (r2 == null) goto L8;
        L9:
            b(r11, r14, r13);
            ComponentName r15 = ba.d();
            if (Intrinsics.areEqual(r2, r15) == true) goto L19;
            IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r16 = new StringBuilder().append("[dispatchAssist] Ignore Assist, AssistComponent: ");
            if (r2 == null) goto L14;
            String r4 = r2.toShortString();
        L15:
            StringBuilder r17 = r16.append(r4).append(", TopIgnoreAssistantComponent: ");
            if (r15 == null) goto L18;
            r0 = r15.toShortString();
        L18:
            IRunLog.a.a(r3, RealTimeContextService.TAG, r17.append(r0).toString(), null, 4, null);
        L27:
            com.obric.memorydata.realtimecontext.session.a r18 = (com.obric.memorydata.realtimecontext.session.a) ZeusTransformUtils.preCheckCast(RealTimeContextService.access$getRealtimeContextProcessors$p(this.f12426a).get(RealTimeContextService.access$getCurRealTimeLink$p(this.f12426a)), com.obric.memorydata.realtimecontext.session.a.class, "com.obric.memorydata.plugin");
            if (r18 == null) goto L34;
            com.obric.memorydata.realtimecontext.session.c r19 = r18.b();
            if (r19 == null) goto L35;
            r19.a(r2);
            a(r14, r2);
            return;
        L35:
            return;
        L34:
            return;
        L14:
            r4 = null;
            goto L15
        L19:
            IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r110 = new StringBuilder().append("[dispatchAssist] AssistComponent: ");
            if (r2 == null) goto L22;
            String r6 = r2.toShortString();
        L23:
            StringBuilder r111 = r110.append(r6).append(", TopIgnoreAssistantComponent: ");
            if (r15 == null) goto L26;
            r0 = r15.toShortString();
        L26:
            IRunLog.a.a(r5, RealTimeContextService.TAG, r111.append(r0).toString(), false, 4, null);
            goto L27
        L22:
            r6 = null;
        L8:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "[dispatchAssist] assistStructure: " + r11, null, 4, null);
            goto L9
        L5:
            r2 = null;
            goto L6
        }

        @Override // com.obric.memorydata.sdk.realtime.b
        public void a(AssistStructure r16, List<AppEntity> r17, com.obric.memorydata.sdk.realtime.a r18) {
            List<AppEntity> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
            com.obric.memorydata.sdk.realtime.a r6 = (com.obric.memorydata.sdk.realtime.a) ZeusTransformUtils.wrapperContextForParams(r18, com.obric.memorydata.sdk.realtime.a.class, "com.obric.memorydata.plugin");
            long r7 = SystemClock.elapsedRealtime();
            IRunLog r9 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r1 = new StringBuilder().append("onHandleAssistWithCallback, ");
            if (r16 == null) goto L5;
            ComponentName r3 = r16.getActivityComponent();
        L6:
            IRunLog.a.a(r9, RealTimeContextService.TAG, r1.append(r3).toString(), false, 4, null);
            if (ak.f13164a.a() == false) goto L10;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "call is refuse", null, 4, null);
            return;
        L10:
            RealTimeContextService.access$setCurRealTimeLink$p(this.f12426a, RealTimeContextLink.CLOUD);
            com.obric.memorydata.realtimecontext.session.a r4 = (com.obric.memorydata.realtimecontext.session.a) ZeusTransformUtils.preCheckCast(RealTimeContextService.access$getRealtimeContextProcessors$p(this.f12426a).get(RealTimeContextLink.CLOUD), com.obric.memorydata.realtimecontext.session.a.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L13;
            r4.a(r16, r5, r6, r7);
        L13:
            a(r16);
            return;
        L5:
            r3 = null;
            goto L6
        }

        @Override // com.obric.memorydata.sdk.realtime.b
        public void a(Bitmap r1) {
        }
    }

    static {
        Companion = new a(null);
        ComponentName r0 = new ComponentName(CONTACTS_PACKAGE, CONTACTS_LIST_CLASS_NAME);
        contactsListComponent = r0;
        contactDetailComponent = new ComponentName(CONTACTS_PACKAGE, CONTACTS_DETAIL_CLASS_NAME);
        ComponentName r1 = new ComponentName(MMS_PACKAGE, MMS_DETAIL_CLASS_NAME);
        mmsDetailComponent = r1;
        notesActivityComponent = new ComponentName(NOTES_PACKAGE, NOTES_DETAIL_CLASS_NAME);
        ComponentName r2 = new ComponentName(APPLET_PACKAGE, APPLET_CLASS_NAME);
        appletComponent = r2;
        ASSIST_STRUCTURE_NER_BLACK_COMPONENT = SetsKt.setOf(new ComponentName[]{r1, r0, r2});
    }

    public RealTimeContextService() {
        this.binder = new b(this);
        this.realtimeContextProcessors = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.defaultScope = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin"));
        this.curRealTimeLink = RealTimeContextLink.CLOUD;
        this.onScreenTracker = new com.obric.memorydata.realtimecontext.tracker.a();
        this.initialized = new AtomicBoolean(false);
        this.screenCacheClearRunnable = $$Lambda$RealTimeContextService$h1mkuYTUIhWFuWt0_mhSX4E7n0w.INSTANCE;
        this.screenTaskClearRunnable = new $$Lambda$RealTimeContextService$Baq91gU2PqEVuti82u7PdYvHo0(this);
    }

    public static final /* synthetic */ bx access$getActionContextJob$p(RealTimeContextService r0) {
        return r0.actionContextJob;
    }

    public static final /* synthetic */ bx access$getAppContentJob$p(RealTimeContextService r0) {
        return r0.appContentJob;
    }

    public static final /* synthetic */ long access$getAssistDataRequestTs$p(RealTimeContextService r2) {
        return r2.assistDataRequestTs;
    }

    public static final /* synthetic */ ComponentName access$getContactDetailComponent$cp() {
        return contactDetailComponent;
    }

    public static final /* synthetic */ ComponentName access$getContactsListComponent$cp() {
        return contactsListComponent;
    }

    public static final /* synthetic */ RealTimeContextLink access$getCurRealTimeLink$p(RealTimeContextService r0) {
        return r0.curRealTimeLink;
    }

    public static final /* synthetic */ AtomicBoolean access$getInitialized$p(RealTimeContextService r0) {
        return r0.initialized;
    }

    public static final /* synthetic */ ComponentName access$getMmsDetailComponent$cp() {
        return mmsDetailComponent;
    }

    public static final /* synthetic */ ComponentName access$getNotesActivityComponent$cp() {
        return notesActivityComponent;
    }

    public static final /* synthetic */ Map access$getRealtimeContextProcessors$p(RealTimeContextService r0) {
        return r0.realtimeContextProcessors;
    }

    public static final /* synthetic */ Runnable access$getScreenCacheClearRunnable$p(RealTimeContextService r0) {
        return r0.screenCacheClearRunnable;
    }

    public static final /* synthetic */ Runnable access$getScreenTaskClearRunnable$p(RealTimeContextService r0) {
        return r0.screenTaskClearRunnable;
    }

    public static final /* synthetic */ void access$init(RealTimeContextService r0) {
        r0.init();
    }

    public static final /* synthetic */ void access$setActionContextJob$p(RealTimeContextService r2, bx r3) {
        r2.actionContextJob = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$setAppContentJob$p(RealTimeContextService r2, bx r3) {
        r2.appContentJob = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$setAssistDataRequestTs$p(RealTimeContextService r0, long r1) {
        r0.assistDataRequestTs = r1;
    }

    public static final /* synthetic */ void access$setCurRealTimeLink$p(RealTimeContextService r0, RealTimeContextLink r1) {
        r0.curRealTimeLink = r1;
    }

    private final void cancelJobAll() {
        bx r0 = this.assistDataJob;
        if (r0 == null) goto L5;
        bx.a.a(r0, null, 1, null);
    L5:
        bx r1 = this.appContentJob;
        if (r1 == null) goto L8;
        bx.a.a(r1, null, 1, null);
    L8:
        bx r2 = this.screenshotJob;
        if (r2 == null) goto L11;
        bx.a.a(r2, null, 1, null);
    L11:
        bx r3 = this.actionContextJob;
        if (r3 == null) goto L15;
        bx.a.a(r3, null, 1, null);
        return;
    }

    private final void clearData() {
        resetBeginTs();
        this.onScreenTracker.a();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.realtimeContextProcessors.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.obric.memorydata.realtimecontext.session.a) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.memorydata.realtimecontext.session.a.class, "com.obric.memorydata.plugin")).c();
        goto L4
    }

    public static /* synthetic */ void dispatchAssist$realtime_context_obricRelease$default(RealTimeContextService r1, AssistStructure r2, List r3, long r4, int r6, Object r7) {
        List<? extends AppEntity> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L5;
        r4 = SystemClock.elapsedRealtime();
    L5:
        r1.dispatchAssist$realtime_context_obricRelease(r2, r5, r4);
    }

    private final void init() {
        registerProcessor(RealTimeContextLink.CLOUD, (com.obric.memorydata.realtimecontext.session.a) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.realtimecontext.session.b(this), com.obric.memorydata.realtimecontext.session.a.class, "com.obric.memorydata.plugin"));
        clearData();
        com.obric.memorydata.realtimecontext.cache.f.f12457a.e();
        this.initialized.set(true);
    }

    /* JADX INFO: renamed from: lambda$Baq91gU2PqEVuti82-u7PdYvHo0, reason: not valid java name */
    public static /* synthetic */ void m1107lambda$Baq91gU2PqEVuti82u7PdYvHo0(RealTimeContextService r0) {
        screenTaskClearRunnable$lambda$1(r0);
    }

    public static /* synthetic */ void lambda$h1mkuYTUIhWFuWt0_mhSX4E7n0w() {
        screenCacheClearRunnable$lambda$0();
    }

    private final void registerProcessor(RealTimeContextLink r1, com.obric.memorydata.realtimecontext.session.a r2) {
        this.realtimeContextProcessors.put(r1, r2);
    }

    private final void resetBeginTs() {
        this.assistDataRequestTs = 0;
    }

    private static final void screenCacheClearRunnable$lambda$0() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "clear screen cache when idle", false, 4, null);
        com.obric.memorydata.realtimecontext.cache.f.f12457a.e();
    }

    private static final void screenTaskClearRunnable$lambda$1(RealTimeContextService r7) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "clear screen task when idle", false, 4, null);
        r7.cancelJobAll();
        r7.clearData();
        com.obric.memorydata.realtimecontext.cache.f.f12457a.d();
    }

    public final void dispatchAssist$realtime_context_obricRelease(AssistStructure r3, List<? extends AppEntity> r4, long r5) {
        List<? extends AppEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.binder.a(r3, r6, r5);
    }

    public final al getDefaultScope$realtime_context_obricRelease() {
        return this.defaultScope;
    }

    public final com.obric.memorydata.realtimecontext.tracker.a getOnScreenTracker$realtime_context_obricRelease() {
        return this.onScreenTracker;
    }

    @Override // com.obric.memorydata.sdk.server.IPoolService
    public void onBind(Intent r7) {
        Intrinsics.checkNotNullParameter(r7, MemorySourceLinkType.INTENT);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onBind", false, 4, null);
    }

    @Override // com.obric.memorydata.sdk.server.IPoolService
    public void onCreate() {
        IPoolService.a.a(this);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onCreate", false, 4, null);
        init();
    }

    @Override // com.obric.memorydata.sdk.server.IPoolService
    public void onDestroy() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onDestroy", false, 4, null);
        IPoolService.a.b(this);
        am.a(this.defaultScope, null, 1, null);
        clearData();
        com.obric.memorydata.realtimecontext.cache.f.f12457a.e();
    }

    @Override // com.obric.memorydata.sdk.server.IPoolService
    public boolean onUnbind(Intent r8) {
        Intrinsics.checkNotNullParameter(r8, MemorySourceLinkType.INTENT);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onUnbind", false, 4, null);
        return IPoolService.a.b(this, r8);
    }

    @Override // com.obric.memorydata.sdk.server.IPoolService
    public IBinder provideBinder() {
        return (IBinder) ZeusTransformUtils.preCheckCast(this.binder, IBinder.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.sdk.server.IPoolService
    public BinderCode provideBinderCode() {
        return BinderCode.REALTIME_CONTEXT;
    }
}
