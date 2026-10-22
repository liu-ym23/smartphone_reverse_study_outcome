package com.obric.memorydata.memory.ui.detail;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.paging.PagingData;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.cr;
import com.obric.memorydata.memory.databinding.ActivityMemoryDetailBinding;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.memory.ui.feedback.MemoryFeedbackScene;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.app.UserStateManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.at;
import com.obric.memorydata.utils.ax;
import com.obric.memorydata.utils.ba;
import com.obric.memorydata.utils.bb;
import com.obric.memorydata.utils.handler.GlobalHandlerUtil;
import com.obric.oui.orecyclerview.widget.ConcatAdapter;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.flow.ai;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 S2\u00020\u0001:\u0003QRSB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020\u001bH\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u001bH\u0002J\u001a\u0010&\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020$H\u0002J\b\u0010*\u001a\u00020\u001bH\u0002JG\u0010+\u001a\u00020\u001b\"\u0004\b\u0000\u0010,*\b\u0012\u0004\u0012\u0002H,0-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u00020\u001b0/2\u0018\u00100\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H,0-\u0012\u0004\u0012\u00020\u001b0/H\u0082\bJ2\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020$2\f\u00103\u001a\b\u0012\u0004\u0012\u00020$0-2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001b0/H\u0002J=\u00105\u001a\b\u0012\u0004\u0012\u00020$0-*\u0014\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0-062\u0012\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020$08\"\u00020$H\u0002¢\u0006\u0002\u00109J\b\u0010:\u001a\u00020\u001bH\u0002J\f\u0010;\u001a\u00020\u001b*\u00020<H\u0002J\b\u0010=\u001a\u00020\u001bH\u0014J\b\u0010>\u001a\u00020\u001bH\u0002J\n\u0010?\u001a\u0004\u0018\u00010@H\u0002J\b\u0010A\u001a\u00020\u001bH\u0002J\b\u0010B\u001a\u00020\u001bH\u0002J\u0012\u0010C\u001a\u00020\u001b2\b\b\u0002\u0010D\u001a\u00020\u0019H\u0002J\b\u0010E\u001a\u00020\u0015H\u0003J4\u0010F\u001a\u0014\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0-062\u0018\u0010G\u001a\u0014\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0-06H\u0002J\u0010\u0010H\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u00020\u001b2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010N\u001a\u00020\u001b2\u0006\u0010O\u001a\u00020PH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryDetailActivity;", "Lcom/obric/memorydata/memory/ui/BaseMemoryActivity;", "<init>", "()V", "binding", "Lcom/obric/memorydata/memory/databinding/ActivityMemoryDetailBinding;", "viewModel", "Lcom/obric/memorydata/memory/ui/detail/AbsMemoryDetailViewModel;", "memoryDetailAdapter", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailAdapter;", "memoryCorrelationAdapter", "Lcom/obric/memorydata/memory/ui/detail/MemoryCorrelationAdapter;", "memoryCalendarAdapter", "Lcom/obric/memorydata/memory/ui/detail/MemoryCalendarAdapter;", "concatAdapter", "Lcom/obric/oui/orecyclerview/widget/ConcatAdapter;", "calendarDialog", "Lcom/obric/memorydata/memory/ui/detail/CalendarDialog;", "hasBind", "", "observeDataJob", "Lkotlinx/coroutines/Job;", "isValidatingEntity", "isTextSelectionActionModeActive", "memoryListDefaultOverScrollMode", "", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "onActionModeStarted", "mode", "Landroid/view/ActionMode;", "onActionModeFinished", "onBackPressed", "getEnterFrom", "", "initFromIntent", "trackDetailPageShow", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "enterFrom", "initView", "singleOrPick", ExifInterface.GPS_DIRECTION_TRUE, "", LocationInfoConst.SINGLE, "Lkotlin/Function1;", "multiple", "showListPicker", "title", "items", "onSelect", "validValues", "", "keys", "", "(Ljava/util/Map;[Ljava/lang/String;)Ljava/util/List;", "setupRecyclerView", "clearActiveBounceEffect", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "onResumeChecked", "observeSafetyRemoval", "currentSafetyRemovalKey", "Lcom/obric/memorydata/memory/llm/MemorySafetyRemovalEvents$MemoryKey;", "validateCurrentEntityOnResume", "handleDeletedEntityOnResume", "showDeletedToastOnce", "messageRes", "observeData", "filterInvalidUrlKeyInfo", "keyInfoMap", "showDeleteDialog", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "showDeleteEpisodicMemoryDialog", SlardarSettingsConstants.PERF_KEY_MEMORY, "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "showPopupMenu", "anchor", "Landroid/view/View;", "DetailPageState", "DetailEntityValidity", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryDetailActivity extends BaseMemoryActivity {
    public static final String ARG_ENTITY = "entity";
    private static final String ARG_FROM = "from";
    public static final a Companion = null;
    private static final long DELETED_TOAST_INTERVAL_MS = 1000;
    private static final String EPISODIC_MEMORY_ENTITY_ID = "episodic_memory_entity_id";
    public static final int RESULT_DELETED = 2;
    private static final String TAG = "MemoryDetailActivity";
    private static volatile long lastDeletedToastTime;
    private static final al scope = null;
    private ActivityMemoryDetailBinding binding;
    private com.obric.memorydata.memory.ui.detail.c calendarDialog;
    private ConcatAdapter concatAdapter;
    private boolean hasBind;
    private boolean isTextSelectionActionModeActive;
    private boolean isValidatingEntity;
    private s memoryCalendarAdapter;
    private MemoryCorrelationAdapter memoryCorrelationAdapter;
    private u memoryDetailAdapter;
    private int memoryListDefaultOverScrollMode;
    private bx observeDataJob;
    private AbsMemoryDetailViewModel<?> viewModel;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryDetailActivity$DetailEntityValidity;", "", "<init>", "(Ljava/lang/String;I)V", "Exists", "Deleted", "Error", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final enum DetailEntityValidity extends Enum<DetailEntityValidity> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ DetailEntityValidity[] $VALUES = null;
        public static final DetailEntityValidity Deleted = null;
        public static final DetailEntityValidity Error = null;
        public static final DetailEntityValidity Exists = null;

        private static final /* synthetic */ DetailEntityValidity[] $values() {
            return new DetailEntityValidity[]{Exists, Deleted, Error};
        }

        static {
            Exists = new DetailEntityValidity("Exists", 0);
            Deleted = new DetailEntityValidity("Deleted", 1);
            Error = new DetailEntityValidity("Error", 2);
            DetailEntityValidity[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private DetailEntityValidity(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<DetailEntityValidity> getEntries() {
            return $ENTRIES;
        }

        public static DetailEntityValidity valueOf(String r2) {
            return (DetailEntityValidity) ZeusTransformUtils.preCheckCast(Enum.valueOf(DetailEntityValidity.class, r2), DetailEntityValidity.class, "com.obric.memorydata.plugin");
        }

        public static DetailEntityValidity[] values() {
            return (DetailEntityValidity[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DetailEntityValidity[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0018J(\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0018J(\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0018J(\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J(\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryDetailActivity$Companion;", "", "<init>", "()V", "TAG", "", "ARG_ENTITY", "ARG_FROM", "EPISODIC_MEMORY_ENTITY_ID", "RESULT_DELETED", "", "DELETED_TOAST_INTERVAL_MS", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "lastDeletedToastTime", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "enterFrom", "clearTask", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "startEpisodicMemoryDetailActivity", "episodicMemoryEntityId", "realStart", "buildCalendarInfoWorkaround", "memoryEntity", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private static final void a(Context r7, MemoryEntity r8, String r9) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
            a(MemoryDetailActivity.Companion, r1, r8, r9, false, 8, null);
        }

        private static final void a(Context r7, String r8, String r9) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
            a(MemoryDetailActivity.Companion, r1, r8, r9, false, 8, null);
        }

        private final void a(MemoryEntity r24) {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryDetailActivity.TAG, "buildCalendarInfoWorkaround, memoryEntity: " + r24.getUuid(), false, 4, null);
            if (com.obric.memorydata.memory.utils.f.f11537a.b(r24) == true) goto L38;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryDetailActivity.TAG, "no extracted", false, 4, null);
            RawMemoryEntity r1 = com.obric.memorydata.database.entity.memoryindex.m.a().toRawMemoryEntity(r24);
            Long r2 = r1.getEndTime();
            String r4 = PendingMemoryCalendar.TYPE_TODO;
            if (r2 != null) goto L7;
        L17:
            Long r3 = r1.getStartTime();
            if (r3 != null) goto L20;
            r3 = r1.getEndTime();
        L20:
            if (r3 != null) goto L22;
        L25:
            Long r13 = r3;
            Long r14 = r13;
            String r11 = PendingMemoryCalendar.TYPE_TODO;
        L26:
            if (r11 == null) goto L36;
            String r9 = com.obric.memorydata.memory.ui.f.f10920a.a(r24);
            String r5 = r24.getSourcePackageName();
            if (r5 != null) goto L30;
            String r16 = "";
        L31:
            String r6 = r24.getSourceAppName();
            if (r6 != null) goto L34;
            String r17 = "";
        L35:
            PendingMemoryCalendar r7 = new PendingMemoryCalendar(0, r9, null, r11, null, r13, r14, null, r16, r17, r24.getUuid(), Integer.valueOf(r24.getType()), 0, 4245, null);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryDetailActivity.TAG, "saveCalendarData pendingMemoryCalendar: " + com.obric.memorydata.utils.q.f13259a.b(r7.getTitle()), false, 4, null);
            com.obric.memorydata.memory.calendar.b.f10085a.a(CollectionsKt.listOf(r7));
            goto L36
        L34:
            r17 = r6;
            goto L35
        L30:
            r16 = r5;
        L36:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryDetailActivity.TAG, "mark extracted", false, 4, null);
            com.obric.memorydata.memory.utils.f.f11537a.a(new cr(0, r24.getId(), 1, null));
            return;
        L22:
            if (r3.longValue() > System.currentTimeMillis()) goto L25;
        L24:
            r11 = null;
            r13 = null;
            r14 = null;
            goto L26
        L7:
            if (r1.getStartTime() == null) goto L17;
            Long r8 = r1.getEndTime();
            Intrinsics.checkNotNull(r8);
            long r10 = r8.longValue();
            Long r12 = r1.getStartTime();
            Intrinsics.checkNotNull(r12);
            if (r10 < r12.longValue()) goto L24;
            Long r15 = r1.getEndTime();
            Intrinsics.checkNotNull(r15);
            if (r15.longValue() <= System.currentTimeMillis()) goto L24;
            if (Intrinsics.areEqual(r1.getEndTime(), r1.getStartTime()) == true) goto L16;
            r4 = PendingMemoryCalendar.TYPE_EVENT;
        L16:
            Long r18 = r1.getStartTime();
            r14 = r1.getEndTime();
            r11 = r4;
            r13 = r18;
            goto L26
        }

        public static final /* synthetic */ void a(a r2, Context r3, MemoryEntity r4, String r5, boolean r6) {
            r2.c((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, r5, r6);
        }

        public static /* synthetic */ void a(a r1, Context r2, MemoryEntity r3, String r4, boolean r5, int r6, Object r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            if ((r6 & 8) == 0) goto L5;
            r5 = true;
        L5:
            r1.b(r8, r3, r4, r5);
        }

        public static final /* synthetic */ void a(a r2, Context r3, String r4, String r5, boolean r6) {
            r2.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, r5, r6);
        }

        public static /* synthetic */ void a(a r1, Context r2, String r3, String r4, boolean r5, int r6, Object r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            if ((r6 & 8) == 0) goto L5;
            r5 = false;
        L5:
            r1.a(r8, r3, r4, r5);
        }

        public static final /* synthetic */ void a(a r0, MemoryEntity r1) {
            r0.a(r1);
        }

        private final void b(Context r4, String r5, String r6, boolean r7) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            RunLog.INSTANCE.debug(MemoryDetailActivity.TAG, "realStart, episodicMemoryEntityId: " + r5);
            Intent r8 = new Intent(r3, MemoryDetailActivity.class);
            r8.putExtra(MemoryDetailActivity.EPISODIC_MEMORY_ENTITY_ID, r5);
            r8.putExtra("from", r6);
            if (((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r3), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")) == null) goto L5;
            if (r7 == true) goto L5;
        L6:
            ZeusTransformUtils.startActivity(r3, r8, "com.obric.memorydata.plugin");
            return;
        L5:
            r8.addFlags(268468224);
            RunLog.INSTANCE.debug(MemoryDetailActivity.TAG, "clearTask: " + r7);
            goto L6
        }

        private static final Unit c(Context r6, final String r7, final String r8, boolean r9) {
            final Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            if (r9 == false) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryDetailActivity.TAG, "agree", false, 4, null);
            GlobalHandlerUtil.Companion.getInstance().postDelay(10, new $$Lambda$MemoryDetailActivity$a$ZU0Fp9BiVjoLZZjxspg1bPNWj4(r10, r7, r8));
        L6:
            return Unit.INSTANCE;
        }

        private final void c(Context r3, MemoryEntity r4, String r5, boolean r6) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intent r7 = new Intent(r2, MemoryDetailActivity.class);
            r7.putExtra("entity", (Parcelable) ZeusTransformUtils.preCheckCast(r4, Parcelable.class, "com.obric.memorydata.plugin"));
            r7.putExtra("from", r5);
            if (((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r2), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")) == null) goto L5;
            if (r6 == true) goto L5;
        L6:
            ZeusTransformUtils.startActivity(r2, r7, "com.obric.memorydata.plugin");
            return;
        L5:
            r7.addFlags(268468224);
            RunLog.INSTANCE.debug(MemoryDetailActivity.TAG, "clearTask: " + r6);
            goto L6
        }

        private static final Unit d(Context r6, final MemoryEntity r7, final String r8, boolean r9) {
            final Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            if (r9 == false) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryDetailActivity.TAG, "agree", false, 4, null);
            GlobalHandlerUtil.Companion.getInstance().postDelay(10, new $$Lambda$MemoryDetailActivity$a$Cio67lNorb3zhy2bm6oQjntgUcE(r10, r7, r8));
        L6:
            return Unit.INSTANCE;
        }

        public static /* synthetic */ void lambda$Cio67lNorb3zhy2bm6oQjntgUcE(Context r0, MemoryEntity r1, String r2) {
            a(r0, r1, r2);
        }

        /* JADX INFO: renamed from: lambda$ZU0Fp-9BiVjoLZZjxspg1bPNWj4, reason: not valid java name */
        public static /* synthetic */ void m848lambda$ZU0Fp9BiVjoLZZjxspg1bPNWj4(Context r0, String r1, String r2) {
            a(r0, r1, r2);
        }

        public static /* synthetic */ Unit lambda$ltaaAWrmfq46Vf3SDe9lsm5IDWM(Context r0, MemoryEntity r1, String r2, boolean r3) {
            return d(r0, r1, r2, r3);
        }

        public static /* synthetic */ Unit lambda$tjUnJ7IiIi4P10TwkZhfLUPhzcw(Context r0, String r1, String r2, boolean r3) {
            return c(r0, r1, r2, r3);
        }

        public final Intent a(Context r4, MemoryEntity r5, String r6, boolean r7) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r5, "entity");
            Intrinsics.checkNotNullParameter(r6, "enterFrom");
            Intent r1 = new Intent(r3, MemoryDetailActivity.class);
            r1.putExtra("entity", (Parcelable) ZeusTransformUtils.preCheckCast(r5, Parcelable.class, "com.obric.memorydata.plugin"));
            r1.putExtra("from", r6);
            if (r7 == false) goto L5;
            r1.addFlags(268468224);
        L5:
            return r1;
        }

        public final void a(Context r10, final String r11, final String r12, boolean r13) {
            final Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r11, "episodicMemoryEntityId");
            Intrinsics.checkNotNullParameter(r12, "enterFrom");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryDetailActivity.TAG, "start memory detail activity", false, 4, null);
            if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L6;
            UserStateManager.INSTANCE.requestAgreePrivacyAndLogin(r2, new $$Lambda$MemoryDetailActivity$a$tjUnJ7IiIi4P10TwkZhfLUPhzcw(r2, r11, r12));
            return;
        L6:
            kotlinx.coroutines.i.a(MemoryDetailActivity.access$getScope$cp(), (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryDetailActivity$Companion$startEpisodicMemoryDetailActivity$2(r2, r11, r12, r13, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        }

        public final void b(Context r11, final MemoryEntity r12, final String r13, boolean r14) {
            final Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r12, "entity");
            Intrinsics.checkNotNullParameter(r13, "enterFrom");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryDetailActivity.TAG, "start memory detail activity", false, 4, null);
            if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L6;
            UserStateManager.INSTANCE.requestAgreePrivacyAndLogin(r3, new $$Lambda$MemoryDetailActivity$a$ltaaAWrmfq46Vf3SDe9lsm5IDWM(r3, r12, r13));
            return;
        L6:
            kotlinx.coroutines.i.a(MemoryDetailActivity.access$getScope$cp(), (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryDetailActivity$Companion$start$2(r12, r3, r13, r14, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u001b\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\u000bHÆ\u0003JK\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\tHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryDetailActivity$DetailPageState;", "", "memoryEntity", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "calendarList", "", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$Calendar;", "keyInfo", "", "", "streamState", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailViewModel$DetailStreamUiState;", "<init>", "(Lcom/obric/memorydata/memory/ui/data/MemoryItem;Ljava/util/List;Ljava/util/Map;Lcom/obric/memorydata/memory/ui/detail/MemoryDetailViewModel$DetailStreamUiState;)V", "getMemoryEntity", "()Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "getCalendarList", "()Ljava/util/List;", "getKeyInfo", "()Ljava/util/Map;", "getStreamState", "()Lcom/obric/memorydata/memory/ui/detail/MemoryDetailViewModel$DetailStreamUiState;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.memorydata.memory.ui.data.a f10816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<com.obric.memorydata.memory.ui.data.a.c> f10817b;
        private final Map<String, List<String>> c;
        private final MemoryDetailViewModel.b d;

        public b(com.obric.memorydata.memory.ui.data.a r3, List<com.obric.memorydata.memory.ui.data.a.c> r4, Map<String, ? extends List<String>> r5, MemoryDetailViewModel.b r6) {
            List<com.obric.memorydata.memory.ui.data.a.c> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Map<String, List<String>> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "calendarList");
            Intrinsics.checkNotNullParameter(r8, "keyInfo");
            Intrinsics.checkNotNullParameter(r6, "streamState");
            this.f10816a = r3;
            this.f10817b = r7;
            this.c = r8;
            this.d = r6;
        }

        public final com.obric.memorydata.memory.ui.data.a a() {
            return this.f10816a;
        }

        public final List<com.obric.memorydata.memory.ui.data.a.c> b() {
            return this.f10817b;
        }

        public final Map<String, List<String>> c() {
            return this.c;
        }

        public final MemoryDetailViewModel.b d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10816a, r6.f10816a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f10817b, r6.f10817b) == true) goto L15;
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
            com.obric.memorydata.memory.ui.data.a r0 = this.f10816a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((((r1 * 31) + this.f10817b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "DetailPageState(memoryEntity=" + this.f10816a + ", calendarList=" + this.f10817b + ", keyInfo=" + this.c + ", streamState=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"com/obric/memorydata/memory/ui/detail/MemoryDetailActivity$setupRecyclerView$2$1", "Lcom/obric/oui/orecyclerview/widget/LinearLayoutManager;", "requestChildRectangleOnScreen", "", "parent", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "child", "Landroid/view/View;", "rect", "Landroid/graphics/Rect;", "immediate", "focusedChildVisible", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends LinearLayoutManager {
        c(Context r3) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h
        public boolean a(RecyclerView r1, View r2, Rect r3, boolean r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r1, "parent");
            Intrinsics.checkNotNullParameter(r2, "child");
            Intrinsics.checkNotNullParameter(r3, "rect");
            return false;
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/obric/memorydata/memory/ui/detail/MemoryDetailActivity$setupRecyclerView$2$2", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "state", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$State;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends RecyclerView.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MemoryDetailActivity f10818a;

        d(MemoryDetailActivity r3) {
            this.f10818a = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
        public void a(Rect r4, View r5, RecyclerView r6, RecyclerView.s r7) {
            Intrinsics.checkNotNullParameter(r4, "outRect");
            Intrinsics.checkNotNullParameter(r5, "view");
            Intrinsics.checkNotNullParameter(r6, "parent");
            Intrinsics.checkNotNullParameter(r7, "state");
            int r8 = r6.getChildAdapterPosition(r5);
            if (r8 != (-1)) goto L5;
            return;
        L5:
            RecyclerView.Adapter r9 = r6.getAdapter();
            com.obric.memorydata.memory.ui.data.a.e r1 = null;
            if (ZeusTransformUtils.instanceOf(r9, ConcatAdapter.class) == false) goto L8;
            ConcatAdapter r10 = (ConcatAdapter) ZeusTransformUtils.preCheckCast(r9, ConcatAdapter.class, "com.obric.memorydata.plugin");
        L9:
            if (r10 != null) goto L12;
            return;
        L12:
            if ((r8 + 1) < r10.d()) goto L15;
            return;
        L15:
            if (r10.d() != 2) goto L41;
            u r3 = MemoryDetailActivity.access$getMemoryDetailAdapter$p(this.f10818a);
            if (r3 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("memoryDetailAdapter");
            r3 = null;
        L19:
            com.obric.memorydata.memory.ui.data.a r11 = r3.a();
            if (ZeusTransformUtils.instanceOf(r11, com.obric.memorydata.memory.ui.data.a.e.class) == false) goto L22;
            r1 = (com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r11, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin");
        L22:
            if (r1 != null) goto L24;
            return;
        L24:
            if (r1.b().getSourceLinkType() == null) goto L26;
        L38:
            int r12 = 0;
        L39:
            r4.bottom = r12;
            return;
        L26:
            if (r1.c() == true) goto L38;
            if (r1.d().isEmpty() == false) goto L30;
        L37:
            r12 = MathKt.roundToInt(TypedValue.applyDimension(1, -8, Resources.getSystem().getDisplayMetrics()));
            goto L39
        L30:
            if (r1.d().size() != 1) goto L38;
            if (r1.d().containsKey(MemoryKeyInfoEntity.KEY_IDENTIFIER) == false) goto L38;
            if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(f.f10855a.a(r1.b()), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L38;
            if (r1.b().getDetail() != null) goto L38;
        L41:
            return;
        L8:
            r10 = null;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$initFromIntent$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$initFromIntent$1", f = "MemoryDetailActivity.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $enterFrom;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MemoryDetailActivity this$0;

        AnonymousClass1(MemoryDetailActivity r3, String r4, Continuation<? super AnonymousClass1> r5) {
            MemoryDetailActivity r6 = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r6;
            this.$enterFrom = r4;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$enterFrom, r6);
            r0.L$0 = r4;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r8);
        L15:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            final al r9 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            AbsMemoryDetailViewModel r2 = MemoryDetailActivity.access$getViewModel$p(this.this$0);
            if (r2 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r2 = null;
        L11:
            ar<com.obric.memorydata.memory.ui.data.a> r3 = r2.getMemoryEntityStateFlow();
            final MemoryDetailActivity r5 = this.this$0;
            final String r6 = this.$enterFrom;
            kotlinx.coroutines.flow.j<? super com.obric.memorydata.memory.ui.data.a> r10 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05411(r5, r6, r9), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r3.collect(r10, r4) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$observeData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$observeData$1", f = "MemoryDetailActivity.kt", i = {}, l = {InputDeviceCompat.SOURCE_DPAD}, m = "invokeSuspend", n = {}, s = {})
    static final class C11441 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryDetailActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$observeData$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$observeData$1$1", f = "MemoryDetailActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C05421 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MemoryDetailActivity this$0;

            /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$observeData$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$observeData$1$1$1", f = "MemoryDetailActivity.kt", i = {}, l = {515}, m = "invokeSuspend", n = {}, s = {})
            static final class C05431 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ MemoryDetailActivity this$0;

                /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$observeData$1$1$1$1, reason: invalid class name and collision with other inner class name */
                @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroidx/paging/PagingData;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$observeData$1$1$1$1", f = "MemoryDetailActivity.kt", i = {}, l = {516}, m = "invokeSuspend", n = {}, s = {})
                static final class C05441 extends SuspendLambda implements Function2<PagingData<com.obric.memorydata.memory.ui.data.a>, Continuation<? super Unit>, Object> {
                    /* synthetic */ Object L$0;
                    int label;
                    final /* synthetic */ MemoryDetailActivity this$0;

                    C05441(MemoryDetailActivity r3, Continuation<? super C05441> r4) {
                        MemoryDetailActivity r5 = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
                        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                        this.this$0 = r5;
                        super(2, r6);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                        C05441 r0 = new C05441(this.this$0, r5);
                        r0.L$0 = r3;
                        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final Object invoke2(PagingData<com.obric.memorydata.memory.ui.data.a> r3, Continuation<? super Unit> r4) {
                        return ((C05441) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05441.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* synthetic */ Object invoke(PagingData<com.obric.memorydata.memory.ui.data.a> r3, Continuation<? super Unit> r4) {
                        return invoke2((PagingData) ZeusTransformUtils.preCheckCast(r3, PagingData.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object r6) {
                        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int r1 = this.label;
                        if (r1 == 0) goto L8;
                        if (r1 != 1) goto L7;
                        ResultKt.throwOnFailure(r6);
                    L15:
                        return Unit.INSTANCE;
                    L7:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    L8:
                        ResultKt.throwOnFailure(r6);
                        PagingData r7 = (PagingData) ZeusTransformUtils.preCheckCast(this.L$0, PagingData.class, "com.obric.memorydata.plugin");
                        MemoryCorrelationAdapter r2 = MemoryDetailActivity.access$getMemoryCorrelationAdapter$p(this.this$0);
                        if (r2 != null) goto L11;
                        Intrinsics.throwUninitializedPropertyAccessException("memoryCorrelationAdapter");
                        r2 = null;
                    L11:
                        Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                        this.label = 1;
                        if (r2.a(r7, r3) != r0) goto L15;
                        return r0;
                    }
                }

                C05431(MemoryDetailActivity r3, Continuation<? super C05431> r4) {
                    MemoryDetailActivity r5 = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
                    Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                    this.this$0 = r5;
                    super(2, r6);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                    Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                    return (Continuation) ZeusTransformUtils.preCheckCast(new C05431(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                    return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                    return ((C05431) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05431.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r6) {
                    Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r1 = this.label;
                    if (r1 == 0) goto L8;
                    if (r1 != 1) goto L7;
                    ResultKt.throwOnFailure(r6);
                L15:
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    ResultKt.throwOnFailure(r6);
                    AbsMemoryDetailViewModel r7 = MemoryDetailActivity.access$getViewModel$p(this.this$0);
                    if (r7 != null) goto L11;
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    r7 = null;
                L11:
                    kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> r8 = r7.getPagingDataFlow();
                    Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C05441(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
                    Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                    this.label = 1;
                    if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L15;
                    return r0;
                }
            }

            /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$observeData$1$1$2, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$observeData$1$1$2", f = "MemoryDetailActivity.kt", i = {}, l = {529}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ MemoryDetailActivity this$0;

                /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$observeData$1$1$2$1, reason: invalid class name and collision with other inner class name */
                @Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\b2\u0006\u0010\n\u001a\u00020\u000bH\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailActivity$DetailPageState;", "memoryEntity", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "calendarList", "", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$Calendar;", "keyInfo", "", "", "streamState", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailViewModel$DetailStreamUiState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$observeData$1$1$2$1", f = "MemoryDetailActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                static final class C05451 extends SuspendLambda implements Function5<com.obric.memorydata.memory.ui.data.a, List<? extends com.obric.memorydata.memory.ui.data.a.c>, Map<String, ? extends List<? extends String>>, MemoryDetailViewModel.b, Continuation<? super b>, Object> {
                    /* synthetic */ Object L$0;
                    /* synthetic */ Object L$1;
                    /* synthetic */ Object L$2;
                    /* synthetic */ Object L$3;
                    int label;

                    C05451(Continuation<? super C05451> r3) {
                        super(5, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final Object invoke2(com.obric.memorydata.memory.ui.data.a r2, List<com.obric.memorydata.memory.ui.data.a.c> r3, Map<String, ? extends List<String>> r4, MemoryDetailViewModel.b r5, Continuation<? super b> r6) {
                        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
                        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
                        C05451 r8 = new C05451((Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
                        r8.L$0 = r2;
                        r8.L$1 = r1;
                        r8.L$2 = r7;
                        r8.L$3 = r5;
                        return r8.invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.jvm.functions.Function5
                    public /* synthetic */ Object invoke(com.obric.memorydata.memory.ui.data.a r9, List<? extends com.obric.memorydata.memory.ui.data.a.c> r10, Map<String, ? extends List<? extends String>> r11, MemoryDetailViewModel.b r12, Continuation<? super b> r13) {
                        return invoke2((com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.memorydata.plugin"), (MemoryDetailViewModel.b) ZeusTransformUtils.preCheckCast(r12, MemoryDetailViewModel.b.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r13, Continuation.class, "com.obric.memorydata.plugin"));
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object r5) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) goto L7;
                        ResultKt.throwOnFailure(r5);
                        return new b((com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(this.L$0, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.preCheckCast(this.L$1, List.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.preCheckCast(this.L$2, Map.class, "com.obric.memorydata.plugin"), (MemoryDetailViewModel.b) ZeusTransformUtils.preCheckCast(this.L$3, MemoryDetailViewModel.b.class, "com.obric.memorydata.plugin"));
                    L7:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }

                /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$observeData$1$1$2$2, reason: invalid class name and collision with other inner class name */
                @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailActivity$DetailPageState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$observeData$1$1$2$2", f = "MemoryDetailActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                static final class C05462 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
                    /* synthetic */ Object L$0;
                    int label;
                    final /* synthetic */ MemoryDetailActivity this$0;

                    C05462(MemoryDetailActivity r3, Continuation<? super C05462> r4) {
                        MemoryDetailActivity r5 = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
                        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                        this.this$0 = r5;
                        super(2, r6);
                    }

                    private static final void invokeSuspend$lambda$2$lambda$1(MemoryDetailActivity r2, RecyclerView.e r3) {
                        ActivityMemoryDetailBinding r4 = MemoryDetailActivity.access$getBinding$p((MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryDetailActivity.class, "com.obric.memorydata.plugin"));
                        if (r4 != null) goto L5;
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        r4 = null;
                    L5:
                        r4.rvMemoryList.setItemAnimator(r3);
                    }

                    public static /* synthetic */ void lambda$xjjhqW5QNd0rBRHjge64UpHNWtI(MemoryDetailActivity r0, RecyclerView.e r1) {
                        invokeSuspend$lambda$2$lambda$1(r0, r1);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                        C05462 r0 = new C05462(this.this$0, r5);
                        r0.L$0 = r3;
                        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final Object invoke2(b r3, Continuation<? super Unit> r4) {
                        return ((C05462) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05462.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* synthetic */ Object invoke(b r3, Continuation<? super Unit> r4) {
                        return invoke2((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object r14) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) goto L42;
                        ResultKt.throwOnFailure(r14);
                        b r15 = (b) ZeusTransformUtils.preCheckCast(this.L$0, b.class, "com.obric.memorydata.plugin");
                        com.obric.memorydata.memory.ui.data.a r0 = r15.a();
                        List<com.obric.memorydata.memory.ui.data.a.c> r2 = r15.b();
                        Map<String, List<String>> r3 = r15.c();
                        MemoryDetailViewModel.b r16 = r15.d();
                        com.obric.memorydata.memory.ui.detail.c r6 = null;
                        if (r0 == null) goto L25;
                        final MemoryDetailActivity r7 = this.this$0;
                        ActivityMemoryDetailBinding r8 = MemoryDetailActivity.access$getBinding$p(r7);
                        if (r8 != null) goto L9;
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        r8 = null;
                    L9:
                        final RecyclerView.e r9 = r8.rvMemoryList.getItemAnimator();
                        ActivityMemoryDetailBinding r10 = MemoryDetailActivity.access$getBinding$p(r7);
                        if (r10 != null) goto L12;
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        r10 = null;
                    L12:
                        r10.rvMemoryList.setItemAnimator(null);
                        if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.memory.ui.data.a.e.class) == false) goto L15;
                        com.obric.memorydata.memory.ui.data.a.e r11 = (com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin");
                    L16:
                        if (r11 == null) goto L18;
                        Map r12 = MemoryDetailActivity.access$filterInvalidUrlKeyInfo(r7, r3);
                        Map<String, ? extends List<String>> r13 = MemoryDetailActivity.access$filterInvalidUrlKeyInfo(r7, r16.d());
                        r11.a(MapsKt.plus(r12, r13));
                        r11.a(!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty());
                        r11.a(r16.a());
                        r11.a(r16.b());
                        r11.a(r16.c());
                        r11.b(r13);
                        r11.b(r16.e());
                    L18:
                        u r17 = MemoryDetailActivity.access$getMemoryDetailAdapter$p(r7);
                        if (r17 != null) goto L21;
                        Intrinsics.throwUninitializedPropertyAccessException("memoryDetailAdapter");
                        r17 = null;
                    L21:
                        r17.a(r0);
                        ActivityMemoryDetailBinding r18 = MemoryDetailActivity.access$getBinding$p(r7);
                        if (r18 != null) goto L24;
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        r18 = null;
                    L24:
                        r18.rvMemoryList.post(new $$Lambda$MemoryDetailActivity$observeData$1$1$2$2$xjjhqW5QNd0rBRHjge64UpHNWtI(r7, r9));
                        goto L25
                    L15:
                        r11 = null;
                    L25:
                        RunLog.INSTANCE.debug(MemoryDetailActivity.TAG, "memoryEntity: " + r0);
                        RunLog r19 = RunLog.INSTANCE;
                        StringBuilder r20 = new StringBuilder().append("memoryEntity == null: ");
                        if (r0 != null) goto L28;
                        boolean r1 = true;
                    L29:
                        StringBuilder r4 = r20.append(r1).append(", itemCount: ");
                        u r21 = MemoryDetailActivity.access$getMemoryDetailAdapter$p(this.this$0);
                        if (r21 != null) goto L32;
                        Intrinsics.throwUninitializedPropertyAccessException("memoryDetailAdapter");
                        r21 = null;
                    L32:
                        r19.debug(MemoryDetailActivity.TAG, r4.append(r21.d()).append(", calendarList: ").append(r2).append(", keyInfo: ").append(r3).toString());
                        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L40;
                        com.obric.memorydata.memory.ui.detail.c r110 = MemoryDetailActivity.access$getCalendarDialog$p(this.this$0);
                        if (r110 != null) goto L37;
                        Intrinsics.throwUninitializedPropertyAccessException("calendarDialog");
                    L38:
                        r6.a(r2);
                        goto L40
                    L37:
                        r6 = r110;
                    L40:
                        return Unit.INSTANCE;
                    L28:
                        r1 = false;
                        goto L29
                    L42:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }

                AnonymousClass2(MemoryDetailActivity r3, Continuation<? super AnonymousClass2> r4) {
                    MemoryDetailActivity r5 = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
                    Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                    this.this$0 = r5;
                    super(2, r6);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                    Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                    return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                    return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                    return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r18) {
                    Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r2 = this.label;
                    if (r2 == 0) goto L8;
                    if (r2 != 1) goto L7;
                    ResultKt.throwOnFailure(r18);
                L33:
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    ResultKt.throwOnFailure(r18);
                    AbsMemoryDetailViewModel r3 = MemoryDetailActivity.access$getViewModel$p(this.this$0);
                    if (r3 != null) goto L11;
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    r3 = null;
                L11:
                    kotlinx.coroutines.flow.i r4 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r3.getMemoryEntityStateFlow(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
                    AbsMemoryDetailViewModel r6 = MemoryDetailActivity.access$getViewModel$p(this.this$0);
                    if (r6 != null) goto L14;
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    r6 = null;
                L14:
                    kotlinx.coroutines.flow.i r7 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r6.getMemoryCalendarItemsFlow(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
                    AbsMemoryDetailViewModel r8 = MemoryDetailActivity.access$getViewModel$p(this.this$0);
                    if (r8 != null) goto L17;
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    r8 = null;
                L17:
                    kotlinx.coroutines.flow.i r9 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r8.getMemoryKeyInfo(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
                    AbsMemoryDetailViewModel r10 = MemoryDetailActivity.access$getViewModel$p(this.this$0);
                    if (r10 != null) goto L21;
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    r10 = null;
                L21:
                    if (ZeusTransformUtils.instanceOf(r10, MemoryDetailViewModel.class) == false) goto L23;
                    MemoryDetailViewModel r5 = (MemoryDetailViewModel) ZeusTransformUtils.preCheckCast(r10, MemoryDetailViewModel.class, "com.obric.memorydata.plugin");
                L24:
                    if (r5 == null) goto L28;
                    ar<MemoryDetailViewModel.b> r11 = r5.getDetailStreamUiState();
                    if (r11 == null) goto L28;
                    kotlinx.coroutines.flow.i r12 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r11, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
                L29:
                    kotlinx.coroutines.flow.i r13 = kotlinx.coroutines.flow.k.a(r4, r7, r9, r12, (Function5) ZeusTransformUtils.preCheckCast(new C05451(null), Function5.class, "com.obric.memorydata.plugin"));
                    Function2 r14 = (Function2) ZeusTransformUtils.preCheckCast(new C05462(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
                    Continuation r15 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                    this.label = 1;
                    if (kotlinx.coroutines.flow.k.a(r13, r14, r15) != r1) goto L33;
                    return r1;
                L28:
                    r12 = kotlinx.coroutines.flow.k.a(new MemoryDetailViewModel.b(null, null, null, null, null, 31, null));
                    goto L29
                L23:
                    r5 = null;
                    goto L24
                }
            }

            C05421(MemoryDetailActivity r3, Continuation<? super C05421> r4) {
                MemoryDetailActivity r5 = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r5;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                C05421 r0 = new C05421(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((C05421) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05421.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r10) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r10);
                al r11 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
                kotlinx.coroutines.i.a(r11, null, null, (Function2) ZeusTransformUtils.preCheckCast(new C05431(this.this$0, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
                kotlinx.coroutines.i.a(r11, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C11441(MemoryDetailActivity r3, Continuation<? super C11441> r4) {
            MemoryDetailActivity r5 = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11441(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11441) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11441.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            LifecycleOwner r9 = (LifecycleOwner) ZeusTransformUtils.preCheckCast(this.this$0, LifecycleOwner.class, "com.obric.memorydata.plugin");
            Lifecycle.State r2 = Lifecycle.State.STARTED;
            Function2 r4 = (Function2) ZeusTransformUtils.preCheckCast(new C05421(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r9, r2, r4, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$observeSafetyRemoval$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$observeSafetyRemoval$1", f = "MemoryDetailActivity.kt", i = {}, l = {416}, m = "invokeSuspend", n = {}, s = {})
    static final class C11451 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryDetailActivity this$0;

        C11451(MemoryDetailActivity r3, Continuation<? super C11451> r4) {
            MemoryDetailActivity r5 = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11451(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11451) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11451.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ai<Set<com.obric.memorydata.memory.llm.f.a>> r7 = com.obric.memorydata.memory.llm.f.f10283a.a();
            final MemoryDetailActivity r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super Set<com.obric.memorydata.memory.llm.f.a>> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05471(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$validateCurrentEntityOnResume$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$validateCurrentEntityOnResume$1", f = "MemoryDetailActivity.kt", i = {}, l = {462}, m = "invokeSuspend", n = {}, s = {})
    static final class C11461 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MemoryDetailActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$validateCurrentEntityOnResume$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$validateCurrentEntityOnResume$1$1", f = "MemoryDetailActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C05481 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            final /* synthetic */ DetailEntityValidity $result;
            int label;
            final /* synthetic */ MemoryDetailActivity this$0;

            /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailActivity$validateCurrentEntityOnResume$1$1$a */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            public /* synthetic */ class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f10822a = null;

                static {
                    int[] r0 = new int[DetailEntityValidity.values().length];
                    r0[DetailEntityValidity.Exists.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
                L11:
                    r0[DetailEntityValidity.Deleted.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
                L15:
                    r0[DetailEntityValidity.Error.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
                L6:
                    f10822a = r0;
                }
            }

            C05481(MemoryDetailActivity r3, DetailEntityValidity r4, Continuation<? super C05481> r5) {
                MemoryDetailActivity r6 = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
                Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r6;
                this.$result = r4;
                super(2, r7);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C05481(this.this$0, this.$result, r5), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((C05481) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05481.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L24;
                ResultKt.throwOnFailure(r2);
                MemoryDetailActivity.access$setValidatingEntity$p(this.this$0, false);
                if (this.this$0.isFinishing() == true) goto L22;
                if (this.this$0.isDestroyed() == true) goto L22;
                DetailEntityValidity r3 = this.$result;
                int r4 = a.f10822a[r3.ordinal()];
                if (r4 == 1) goto L20;
                if (r4 != 2) goto L14;
                MemoryDetailActivity.access$handleDeletedEntityOnResume(this.this$0);
                goto L20
            L14:
                if (r4 == 3) goto L20;
                throw new NoWhenBranchMatchedException();
            L20:
                return Unit.INSTANCE;
            L22:
                return Unit.INSTANCE;
            L24:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C11461(MemoryDetailActivity r3, Continuation<? super C11461> r4) {
            MemoryDetailActivity r5 = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            C11461 r0 = new C11461(this.this$0, r5);
            r0.L$0 = r3;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11461) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11461.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L28:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            al r9 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            MemoryDetailActivity r10 = this.this$0;
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L18
            AbsMemoryDetailViewModel r11 = MemoryDetailActivity.access$getViewModel$p(r10);     // Catch: Throwable -> L18
            if (r11 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Throwable -> L18
            r11 = null;
        L13:
            if (r11.refresh() != null) goto L15;
            DetailEntityValidity r12 = DetailEntityValidity.Deleted;     // Catch: Throwable -> L18
        L16:
            Object r13 = Result.m1421constructorimpl(r12);     // Catch: Throwable -> L18
        L20:
            Throwable r5 = Result.m1424exceptionOrNullimpl(r13);
            if (r5 == null) goto L24;
            RunLog.INSTANCE.error(MemoryDetailActivity.TAG, "validateCurrentEntityOnResume failed", r5);
            r13 = DetailEntityValidity.Error;
        L24:
            DetailEntityValidity r14 = (DetailEntityValidity) ZeusTransformUtils.preCheckCast(r13, DetailEntityValidity.class, "com.obric.memorydata.plugin");
            CoroutineContext r6 = (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r15 = (Function2) ZeusTransformUtils.preCheckCast(new C05481(this.this$0, r14, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.i.a(r6, r15, r2) != r0) goto L28;
            return r0;
        L15:
            r12 = DetailEntityValidity.Exists;     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L20
        }
    }

    static {
        Companion = new a(null);
        scope = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.b().a(), CoroutineContext.class, "com.obric.memorydata.plugin")));
    }

    public MemoryDetailActivity() {
    }

    public static final /* synthetic */ com.obric.memorydata.memory.llm.f.a access$currentSafetyRemovalKey(MemoryDetailActivity r2) {
        return ((MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryDetailActivity.class, "com.obric.memorydata.plugin")).currentSafetyRemovalKey();
    }

    public static final /* synthetic */ Map access$filterInvalidUrlKeyInfo(MemoryDetailActivity r2, Map r3) {
        return ((MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryDetailActivity.class, "com.obric.memorydata.plugin")).filterInvalidUrlKeyInfo((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ ActivityMemoryDetailBinding access$getBinding$p(MemoryDetailActivity r2) {
        return ((MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryDetailActivity.class, "com.obric.memorydata.plugin")).binding;
    }

    public static final /* synthetic */ com.obric.memorydata.memory.ui.detail.c access$getCalendarDialog$p(MemoryDetailActivity r2) {
        return ((MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryDetailActivity.class, "com.obric.memorydata.plugin")).calendarDialog;
    }

    public static final /* synthetic */ MemoryCorrelationAdapter access$getMemoryCorrelationAdapter$p(MemoryDetailActivity r2) {
        return ((MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryDetailActivity.class, "com.obric.memorydata.plugin")).memoryCorrelationAdapter;
    }

    public static final /* synthetic */ u access$getMemoryDetailAdapter$p(MemoryDetailActivity r2) {
        return ((MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryDetailActivity.class, "com.obric.memorydata.plugin")).memoryDetailAdapter;
    }

    public static final /* synthetic */ al access$getScope$cp() {
        return scope;
    }

    public static final /* synthetic */ AbsMemoryDetailViewModel access$getViewModel$p(MemoryDetailActivity r2) {
        return ((MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryDetailActivity.class, "com.obric.memorydata.plugin")).viewModel;
    }

    public static final /* synthetic */ void access$handleDeletedEntityOnResume(MemoryDetailActivity r2) {
        ((MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryDetailActivity.class, "com.obric.memorydata.plugin")).handleDeletedEntityOnResume();
    }

    public static final /* synthetic */ void access$setValidatingEntity$p(MemoryDetailActivity r2, boolean r3) {
        ((MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryDetailActivity.class, "com.obric.memorydata.plugin")).isValidatingEntity = r3;
    }

    public static final /* synthetic */ void access$showDeletedToastOnce(MemoryDetailActivity r2, int r3) {
        ((MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryDetailActivity.class, "com.obric.memorydata.plugin")).showDeletedToastOnce(r3);
    }

    public static final /* synthetic */ void access$trackDetailPageShow(MemoryDetailActivity r2, AppEntity r3, String r4) {
        ((MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryDetailActivity.class, "com.obric.memorydata.plugin")).trackDetailPageShow(r3, r4);
    }

    private final void clearActiveBounceEffect(RecyclerView r2) {
        boolean r1 = r2.getClipToPadding();
        r2.setClipToPadding(!r1);
        r2.setClipToPadding(r1);
        r2.invalidate();
    }

    private final com.obric.memorydata.memory.llm.f.a currentSafetyRemovalKey() {
        AbsMemoryDetailViewModel<?> r0 = this.viewModel;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        com.obric.memorydata.memory.ui.data.a r1 = (com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r0.getMemoryEntityStateFlow().c(), com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, com.obric.memorydata.memory.ui.data.a.e.class) == false) goto L10;
        return new com.obric.memorydata.memory.llm.f.a(((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b().getId(), ((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b().getType());
    L10:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.memorydata.memory.ui.data.a.i.class) == true) goto L12;
        Intent r2 = getIntent();
        if (r2 == null) goto L19;
        MemoryEntity r3 = (MemoryEntity) ZeusTransformUtils.preCheckCast(r2.getParcelableExtra("entity"), MemoryEntity.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L19;
        return new com.obric.memorydata.memory.llm.f.a(r3.getId(), r3.getType());
    L19:
        Intent r5 = getIntent();
        if (r5 == null) goto L25;
        String r6 = r5.getStringExtra(EPISODIC_MEMORY_ENTITY_ID);
        if (r6 != null) goto L24;
        return null;
    L24:
        return new com.obric.memorydata.memory.llm.f.a(r6, EntityType.MEMORY_COMMON_TEXT);
    L25:
        return null;
    L12:
        return new com.obric.memorydata.memory.llm.f.a(((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getEntityId(), EntityType.MEMORY_COMMON_TEXT);
    }

    private final Map<String, List<String>> filterInvalidUrlKeyInfo(Map<String, ? extends List<String>> r10) {
        Map<String, List<String>> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        List r1 = (List) ZeusTransformUtils.preCheckCast(r9.get("url"), List.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return r9;
    L5:
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L14;
        Object r5 = r4.next();
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        boolean r7 = ax.f13189a.d(r6);
        if (r7 == true) goto L11;
        RunLog.INSTANCE.debug(TAG, "filter invalid url from keyInfoMap: " + r6);
    L11:
        if (r7 == false) goto L7;
        r3.add(r5);
        goto L7
    L14:
        return MapsKt.plus(r9, TuplesKt.to("url", (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin")));
    }

    private final void handleDeletedEntityOnResume() {
        int r0 = ba.c();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "handleDeletedEntityOnResume taskId=" + getTaskId() + ", numActivities=" + r0, false, 4, null);
        AbsMemoryDetailViewModel<?> r4 = null;
        showDeletedToastOnce$default(this, 0, 1, null);
        if (r0 <= 1) goto L6;
        ZeusTransformUtils.setResult(this, 2, "com.obric.memorydata.plugin");
    L5:
        finish();
        return;
    L6:
        MemoryListActivity.a r1 = MemoryListActivity.Companion;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin");
        AbsMemoryDetailViewModel<?> r2 = this.viewModel;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L10:
        MemoryListActivity.a.a(r1, r5, null, (String) ZeusTransformUtils.preCheckCast(r4.getEnterFrom().c(), String.class, "com.obric.memorydata.plugin"), MemoryListActivity.JUMP_FROM_DETAIL, null, false, null, 114, null);
        goto L5
    L9:
        r4 = r2;
        goto L10
    }

    private final void initFromIntent() {
        Intent r0 = getIntent();
        if (r0 == null) goto L5;
        MemoryEntity r1 = (MemoryEntity) ZeusTransformUtils.preCheckCast(r0.getParcelableExtra("entity"), MemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        Intent r3 = getIntent();
        if (r3 == null) goto L9;
        String r4 = r3.getStringExtra("from");
    L10:
        Intent r5 = getIntent();
        if (r5 == null) goto L13;
        String r6 = r5.getStringExtra(EPISODIC_MEMORY_ENTITY_ID);
    L14:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "show memory detail", false, 4, null);
        RunLog r7 = RunLog.INSTANCE;
        if (r1 == null) goto L18;
        String r8 = String.valueOf(r1);
    L17:
        r7.debug(TAG, r8);
        if (r1 != null) goto L23;
        if (r6 != null) goto L23;
    L24:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "memoryEntity is null, finish", null, 4, null);
        finish();
        return;
    L23:
        if (r4 == null) goto L24;
        if (r1 == null) goto L37;
        AbsMemoryDetailViewModel<?> r9 = (AbsMemoryDetailViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(this, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(MemoryDetailViewModel.class), AbsMemoryDetailViewModel.class, "com.obric.memorydata.plugin");
        this.viewModel = r9;
        if (r9 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r9 = null;
    L32:
        if (ZeusTransformUtils.instanceOf(r9, MemoryDetailViewModel.class) == false) goto L34;
        MemoryDetailViewModel r10 = (MemoryDetailViewModel) ZeusTransformUtils.preCheckCast(r9, MemoryDetailViewModel.class, "com.obric.memorydata.plugin");
    L35:
        if (r10 == null) goto L47;
        r10.init2(r1, r4);
    L47:
        if (r1 == null) goto L49;
        trackDetailPageShow((AppEntity) ZeusTransformUtils.preCheckCast(r1, AppEntity.class, "com.obric.memorydata.plugin"), r4);
        return;
    L49:
        AbsMemoryDetailViewModel<?> r2 = this.viewModel;
        if (r2 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r2 = null;
    L53:
        if (ZeusTransformUtils.instanceOf(r2, EpisodicMemoryDetailViewModel.class) == false) goto L57;
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r4, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L57:
        return;
    L34:
        r10 = null;
        goto L35
    L37:
        if (r6 == null) goto L47;
        AbsMemoryDetailViewModel<?> r11 = (AbsMemoryDetailViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(this, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(EpisodicMemoryDetailViewModel.class), AbsMemoryDetailViewModel.class, "com.obric.memorydata.plugin");
        this.viewModel = r11;
        if (r11 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r11 = null;
    L42:
        if (ZeusTransformUtils.instanceOf(r11, EpisodicMemoryDetailViewModel.class) == false) goto L44;
        EpisodicMemoryDetailViewModel r12 = (EpisodicMemoryDetailViewModel) ZeusTransformUtils.preCheckCast(r11, EpisodicMemoryDetailViewModel.class, "com.obric.memorydata.plugin");
    L45:
        if (r12 == null) goto L47;
        r12.init2(r6, r4);
        goto L47
    L44:
        r12 = null;
        goto L45
    L18:
        if (r6 == null) goto L20;
        r8 = "episodicMemoryEntityId: " + r6;
        goto L17
    L20:
        r8 = "episodicMemoryEntityId and memoryEntity is null";
        goto L17
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    private final void initView() {
        ActivityMemoryDetailBinding r0 = this.binding;
        ActivityMemoryDetailBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OFloatingTitleBar r3 = r0.viewTitle;
        Intrinsics.checkNotNull(r3);
        ActivityMemoryDetailBinding r2 = this.binding;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L8:
        View r4 = (View) ZeusTransformUtils.preCheckCast(r2.rvMemoryList, View.class, "com.obric.memorydata.plugin");
        int r5 = MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
        ActivityMemoryDetailBinding r6 = this.binding;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        setupTitleBarBackAction(r3, r4, r5, r1.cutOff);
        final View r9 = OFloatingTitleBar.b(r3, ZeusTransformUtils.mapRes(R.drawable.ic_memory_detail_operation, "drawable", "ic_memory_detail_operation"), 0, null, 6, null);
        bb.a(r9, 0, new $$Lambda$MemoryDetailActivity$Fdx44UjtMfWIZPGLuynqB67Ujo(this, r9), 1, null);
        this.calendarDialog = new com.obric.memorydata.memory.ui.detail.c(new $$Lambda$MemoryDetailActivity$HAy738IguAIEnfAxTDouucLIuyM(this));
        setupRecyclerView();
        return;
    L11:
        r1 = r6;
        goto L12
    }

    private static final Unit initView$lambda$2$lambda$1(MemoryDetailActivity r2, View r3, View r4) {
        MemoryDetailActivity r5 = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "it");
        r5.showPopupMenu(r3);
        return Unit.INSTANCE;
    }

    private static final Unit initView$lambda$7(MemoryDetailActivity r8) {
        final MemoryDetailActivity r9 = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r8, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.ui.detail.c r0 = r9.calendarDialog;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("calendarDialog");
        r0 = null;
    L5:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0.b(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r2.add(((com.obric.memorydata.memory.ui.data.a.c) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.memorydata.memory.ui.data.a.c.class, "com.obric.memorydata.plugin")).b());
        goto L7
    L9:
        List<PendingMemoryCalendar> r4 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L11:
        if (r7.hasNext() == false) goto L13;
        r6.add(((PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(r7.next(), PendingMemoryCalendar.class, "com.obric.memorydata.plugin")).getEventType());
        goto L11
    L13:
        List r10 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r10.size() != 1) goto L20;
        if (Intrinsics.areEqual(CollectionsKt.first(r10), PendingMemoryCalendar.TYPE_EVENT) == false) goto L20;
        int r11 = ZeusTransformUtils.mapRes(R.string.memory_card_schedule_title, TypedValues.Custom.S_STRING, "memory_card_schedule_title");
    L18:
        final String r12 = r9.getString(r11);
    L25:
        Intrinsics.checkNotNull(r12);
        com.obric.memorydata.memory.island.d.f10194a.a((Context) ZeusTransformUtils.preCheckCast(r9, Context.class, "com.obric.memorydata.plugin"), r4, new $$Lambda$MemoryDetailActivity$5m0B6SCScZs5PBw7_Y4lebrOzs(r9, r12));
        return Unit.INSTANCE;
    L20:
        if (r10.size() == 1) goto L22;
    L24:
        r12 = r9.getString(ZeusTransformUtils.mapRes(R.string.memory_card_schedule_title, TypedValues.Custom.S_STRING, "memory_card_schedule_title")) + r9.getString(ZeusTransformUtils.mapRes(R.string.memory_card_todo_title, TypedValues.Custom.S_STRING, "memory_card_todo_title"));
        goto L25
    L22:
        if (Intrinsics.areEqual(CollectionsKt.first(r10), PendingMemoryCalendar.TYPE_TODO) == false) goto L24;
        r11 = ZeusTransformUtils.mapRes(R.string.memory_card_todo_title, TypedValues.Custom.S_STRING, "memory_card_todo_title");
        goto L18
    }

    private static final Unit initView$lambda$7$lambda$6(MemoryDetailActivity r9, String r10, List r11) {
        MemoryDetailActivity r12 = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r9, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "results");
        boolean r2 = true;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L17;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, Collection.class) == true) goto L7;
    L9:
        Iterator r15 = r14.iterator();
    L11:
        if (r15.hasNext() == false) goto L8;
        if (((com.obric.memorydata.memory.island.d.a) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.memorydata.memory.island.d.a.class, "com.obric.memorydata.plugin")).a() == true) goto L11;
        boolean r16 = false;
    L15:
        if (r16 == false) goto L17;
    L18:
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(r12, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryDetailActivity$initView$2$1$1(r12, r2, r10, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        return Unit.INSTANCE;
    L8:
        r16 = true;
        goto L15
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
    L17:
        r2 = false;
        goto L18
    }

    /* JADX INFO: renamed from: lambda$-y82SQ5f5yHmBKj2lQ9Yq7jr4EA, reason: not valid java name */
    public static /* synthetic */ Unit m842lambda$y82SQ5f5yHmBKj2lQ9Yq7jr4EA(DialogInterface r0, int r1) {
        return showDeleteEpisodicMemoryDialog$lambda$30(r0, r1);
    }

    public static /* synthetic */ Unit lambda$3LoAetBtproYwFP9r035S_ECo44(MemoryDetailActivity r0, MemoryFeedbackScene r1, com.obric.memorydata.memory.ui.data.a r2) {
        return showPopupMenu$lambda$36$lambda$35(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$4V5tKoQg77FQD9IGX_qBwLMilE0(MemoryDetailActivity r0, u.a r1) {
        return setupRecyclerView$lambda$21(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$5m0B6SCScZs5PBw7_Y4lebr-Ozs, reason: not valid java name */
    public static /* synthetic */ Unit m843lambda$5m0B6SCScZs5PBw7_Y4lebrOzs(MemoryDetailActivity r0, String r1, List r2) {
        return initView$lambda$7$lambda$6(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$7pLh0eJhRDwZJ3oouGl0iAW7LBU(MemoryDetailViewModel r0, MemoryEntity r1, MemoryDetailActivity r2, DialogInterface r3, int r4) {
        return showDeleteDialog$lambda$28(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$Fdx44UjtMfWIZP-GLuynqB67Ujo, reason: not valid java name */
    public static /* synthetic */ Unit m844lambda$Fdx44UjtMfWIZPGLuynqB67Ujo(MemoryDetailActivity r0, View r1, View r2) {
        return initView$lambda$2$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$HAy738IguAIEnfAxTDouucLIuyM(MemoryDetailActivity r0) {
        return initView$lambda$7(r0);
    }

    /* JADX INFO: renamed from: lambda$I4wXSb4zNVz6NGu4Ud-pl1xl6rc, reason: not valid java name */
    public static /* synthetic */ Unit m845lambda$I4wXSb4zNVz6NGu4Udpl1xl6rc(EpisodicMemoryDetailViewModel r0, EpisodicMemoryEntity r1, MemoryDetailActivity r2, DialogInterface r3, int r4) {
        return showDeleteEpisodicMemoryDialog$lambda$31(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ List lambda$JyRgiARMnuss7kUkGhU8YttUXU0(com.obric.memorydata.memory.ui.data.a r0, MemoryFeedbackScene r1, String r2) {
        return showPopupMenu$lambda$36$lambda$35$lambda$33(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$ObXZ76l78qsQQqTFSeR0kEAcefs(String r0, List r1, Function1 r2, com.obric.memorydata.markdown.custom.f r3) {
        return showListPicker$lambda$10(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$RWAeJzLhev_UzDE88m31nmBEwn8(MemoryDetailActivity r0, com.obric.memorydata.memory.ui.data.a r1) {
        return showPopupMenu$lambda$39(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$UvEowAYIUSUeOQMzZY9Kyh-aG1A, reason: not valid java name */
    public static /* synthetic */ com.obric.memorydata.memory.ui.feedback.h m846lambda$UvEowAYIUSUeOQMzZY9KyhaG1A(com.obric.memorydata.memory.ui.data.a r0) {
        return showPopupMenu$lambda$36$lambda$35$lambda$34(r0);
    }

    public static /* synthetic */ Unit lambda$W2Lus7twAfyxh8cjs4qvU6G1bJQ(Function1 r0, String r1) {
        return showListPicker$lambda$10$lambda$9$lambda$8(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$dYwY8rQoC65aGF2Q9By-qYMo5uM, reason: not valid java name */
    public static /* synthetic */ Unit m847lambda$dYwY8rQoC65aGF2Q9ByqYMo5uM(DialogInterface r0, int r1) {
        return showDeleteDialog$lambda$27(r0, r1);
    }

    public static /* synthetic */ Unit lambda$nDuogrPYVny5ns1nLXZLKYaaNBE(MemoryDetailActivity r0, com.obric.memorydata.memory.ui.data.a r1) {
        return showPopupMenu$lambda$38(r0, r1);
    }

    public static /* synthetic */ Unit lambda$q8OQM_hYFGiSeYmfND_xolSGh7k(String r0) {
        return setupRecyclerView$lambda$21$lambda$18$lambda$17(r0);
    }

    private final bx observeData() {
        bx r0 = this.observeDataJob;
        if (r0 == null) goto L5;
        bx.a.a(r0, null, 1, null);
    L5:
        bx r1 = kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11441(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        this.observeDataJob = r1;
        return r1;
    }

    private final void observeSafetyRemoval() {
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11451(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void setupRecyclerView() {
        this.memoryDetailAdapter = new u(new $$Lambda$MemoryDetailActivity$4V5tKoQg77FQD9IGX_qBwLMilE0(this));
        this.memoryCalendarAdapter = new s();
        this.memoryCorrelationAdapter = new MemoryCorrelationAdapter();
        RecyclerView.Adapter[] r1 = new RecyclerView.Adapter[3];
        u r2 = this.memoryDetailAdapter;
        ConcatAdapter r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("memoryDetailAdapter");
        r2 = null;
    L5:
        r1[0] = r2;
        s r4 = this.memoryCalendarAdapter;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("memoryCalendarAdapter");
        r4 = null;
    L8:
        r1[1] = r4;
        MemoryCorrelationAdapter r5 = this.memoryCorrelationAdapter;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("memoryCorrelationAdapter");
        r5 = null;
    L11:
        r1[2] = r5;
        this.concatAdapter = new ConcatAdapter(r1);
        ActivityMemoryDetailBinding r0 = this.binding;
        if (r0 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L14:
        RecyclerView r6 = r0.rvMemoryList;
        this.memoryListDefaultOverScrollMode = r6.getOverScrollMode();
        r6.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        ConcatAdapter r7 = this.concatAdapter;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
    L18:
        r6.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r3, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        r6.addItemDecoration((RecyclerView.g) ZeusTransformUtils.preCheckCast(new d(this), RecyclerView.g.class, "com.obric.memorydata.plugin"));
        return;
    L17:
        r3 = r7;
        goto L18
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private static final Unit setupRecyclerView$lambda$21(MemoryDetailActivity r7, u.a r8) {
        MemoryDetailActivity r9 = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r7, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "event");
        RunLog.INSTANCE.debug(TAG, "onSendCapsuleEvent: " + r8);
        u r0 = r9.memoryDetailAdapter;
        List<String> r2 = null;
        com.obric.memorydata.memory.ui.detail.c r3 = null;
        List<String> r4 = null;
        List<String> r5 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("memoryDetailAdapter");
        r0 = null;
    L5:
        com.obric.memorydata.memory.ui.data.a r1 = r0.a();
        if (ZeusTransformUtils.instanceOf(r1, com.obric.memorydata.memory.ui.data.a.e.class) == false) goto L8;
        com.obric.memorydata.memory.ui.data.a.e r6 = (com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin");
    L9:
        if (r6 == null) goto L14;
        if (ZeusTransformUtils.instanceOf(r8, u.a.d.class) == true) goto L14;
        MemoryEventTracker.f10515a.a((AppEntity) ZeusTransformUtils.preCheckCast(r6.b(), AppEntity.class, "com.obric.memorydata.plugin"), MemoryEventTracker.ReactionType.QUICK_ACTION.getValue(), r9.getEnterFrom());
    L14:
        if (r6 == null) goto L17;
        Map<String, List<String>> r10 = r6.d();
        if (r10 == null) goto L17;
    L22:
        if (ZeusTransformUtils.instanceOf(r8, u.a.d.class) == true) goto L60;
        if (ZeusTransformUtils.instanceOf(r8, u.a.b.class) == false) goto L37;
        com.obric.memorydata.memory.ui.detail.c r11 = r9.calendarDialog;
        if (r11 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("calendarDialog");
        r11 = null;
    L28:
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(r9, Context.class, "com.obric.memorydata.plugin");
        AbsMemoryDetailViewModel<?> r13 = r9.viewModel;
        if (r13 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r13 = null;
    L31:
        r11.a(r12, (List) ZeusTransformUtils.preCheckCast(r13.getMemoryCalendarItemsFlow().c(), List.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.memory.ui.detail.c r14 = r9.calendarDialog;
        if (r14 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("calendarDialog");
    L35:
        r3.c();
        goto L60
    L34:
        r3 = r14;
        goto L35
    L37:
        if (ZeusTransformUtils.instanceOf(r8, u.a.c.class) == false) goto L44;
        List<String> r15 = r9.validValues(r10, new String[]{MemoryKeyInfoEntity.KEY_PHONE});
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L41;
        r4 = r15;
    L41:
        if (r4 == null) goto L60;
        com.obric.memorydata.markdown.custom.j.f9994a.a((Context) ZeusTransformUtils.preCheckCast(r9, Context.class, "com.obric.memorydata.plugin"), r4);
        goto L60
    L44:
        if (ZeusTransformUtils.instanceOf(r8, u.a.C0555a.class) == false) goto L51;
        List<String> r16 = r9.validValues(r10, new String[]{MemoryKeyInfoEntity.KEY_ADDRESS, "location"});
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L48;
        r5 = r16;
    L48:
        if (r5 == null) goto L60;
        com.obric.memorydata.markdown.custom.e.f9983a.a((Context) ZeusTransformUtils.preCheckCast(r9, Context.class, "com.obric.memorydata.plugin"), r5, (String) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.ui.settings.l.f11479a.a().e().c(), String.class, "com.obric.memorydata.plugin"), $$Lambda$MemoryDetailActivity$q8OQM_hYFGiSeYmfND_xolSGh7k.INSTANCE);
        goto L60
    L51:
        if (ZeusTransformUtils.instanceOf(r8, u.a.e.class) == false) goto L58;
        List<String> r17 = r9.validValues(r10, new String[]{"url"});
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L55;
        r2 = r17;
    L55:
        if (r2 == null) goto L60;
        com.obric.memorydata.markdown.custom.m.f9998a.a((Context) ZeusTransformUtils.preCheckCast(r9, Context.class, "com.obric.memorydata.plugin"), r2);
        goto L60
    L58:
        throw new NoWhenBranchMatchedException();
    L60:
        return Unit.INSTANCE;
    L17:
        AbsMemoryDetailViewModel<?> r18 = r9.viewModel;
        if (r18 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r18 = null;
    L20:
        r10 = (Map) ZeusTransformUtils.preCheckCast(r18.getMemoryKeyInfo().c(), Map.class, "com.obric.memorydata.plugin");
        goto L22
    L8:
        r6 = null;
        goto L9
    }

    private static final Unit setupRecyclerView$lambda$21$lambda$18$lambda$17(String r1) {
        Intrinsics.checkNotNullParameter(r1, "defaultMapPackageName");
        com.obric.memorydata.memory.ui.settings.l.f11479a.a().a(r1);
        return Unit.INSTANCE;
    }

    private final void showDeleteDialog(final MemoryEntity r9) {
        AbsMemoryDetailViewModel<?> r0 = this.viewModel;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, MemoryDetailViewModel.class) == false) goto L8;
        final MemoryDetailViewModel r1 = (MemoryDetailViewModel) ZeusTransformUtils.preCheckCast(r0, MemoryDetailViewModel.class, "com.obric.memorydata.plugin");
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        ActivityMemoryDetailBinding r4 = this.binding;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L14:
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r5, "getContext(...)");
        com.obric.oui.dialog.v2.alert.a r8 = (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(com.obric.oui.dialog.v2.alert.b.a(new com.obric.oui.dialog.v2.alert.b(r5).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(at.a(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_title_single, TypedValues.Custom.S_STRING, "memory_card_delete_notice_title_single")), CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a(null).a(true).b((CharSequence) ZeusTransformUtils.preCheckCast(at.a(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_cancel, TypedValues.Custom.S_STRING, "memory_card_delete_notice_cancel")), CharSequence.class, "com.obric.memorydata.plugin"), $$Lambda$MemoryDetailActivity$dYwY8rQoC65aGF2Q9ByqYMo5uM.INSTANCE).a((CharSequence) ZeusTransformUtils.preCheckCast(at.a(ZeusTransformUtils.mapRes(R.string.memory_detail_notice_delete, TypedValues.Custom.S_STRING, "memory_detail_notice_delete")), CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$MemoryDetailActivity$7pLh0eJhRDwZJ3oouGl0iAW7LBU(r1, r9, this)).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
        r8.setCanceledOnTouchOutside(true);
        r8.setCancelable(true);
        r8.show();
        return;
    L8:
        r1 = null;
        goto L9
    }

    private static final Unit showDeleteDialog$lambda$27(DialogInterface r1, int r2) {
        DialogInterface r3 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        r3.dismiss();
        return Unit.INSTANCE;
    }

    private static final Unit showDeleteDialog$lambda$28(MemoryDetailViewModel r1, MemoryEntity r2, MemoryDetailActivity r3, DialogInterface r4, int r5) {
        MemoryDetailActivity r6 = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r7 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "dialog");
        r1.deleteMemoryEntity2(r2);
        r1.get_memoryEntityStateFlow().b(null);
        r7.dismiss();
        r6.onBackPressed();
        return Unit.INSTANCE;
    }

    private final void showDeleteEpisodicMemoryDialog(final EpisodicMemoryEntity r9) {
        AbsMemoryDetailViewModel<?> r0 = this.viewModel;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, EpisodicMemoryDetailViewModel.class) == false) goto L8;
        final EpisodicMemoryDetailViewModel r1 = (EpisodicMemoryDetailViewModel) ZeusTransformUtils.preCheckCast(r0, EpisodicMemoryDetailViewModel.class, "com.obric.memorydata.plugin");
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        ActivityMemoryDetailBinding r4 = this.binding;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L14:
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r5, "getContext(...)");
        com.obric.oui.dialog.v2.alert.a r8 = (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(com.obric.oui.dialog.v2.alert.b.a(new com.obric.oui.dialog.v2.alert.b(r5).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(at.a(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_title_single, TypedValues.Custom.S_STRING, "memory_card_delete_notice_title_single")), CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a(null).a(true).b((CharSequence) ZeusTransformUtils.preCheckCast(at.a(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_cancel, TypedValues.Custom.S_STRING, "memory_card_delete_notice_cancel")), CharSequence.class, "com.obric.memorydata.plugin"), $$Lambda$MemoryDetailActivity$y82SQ5f5yHmBKj2lQ9Yq7jr4EA.INSTANCE).a((CharSequence) ZeusTransformUtils.preCheckCast(at.a(ZeusTransformUtils.mapRes(R.string.memory_detail_notice_delete, TypedValues.Custom.S_STRING, "memory_detail_notice_delete")), CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$MemoryDetailActivity$I4wXSb4zNVz6NGu4Udpl1xl6rc(r1, r9, this)).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
        r8.setCanceledOnTouchOutside(true);
        r8.setCancelable(true);
        r8.show();
        return;
    L8:
        r1 = null;
        goto L9
    }

    private static final Unit showDeleteEpisodicMemoryDialog$lambda$30(DialogInterface r1, int r2) {
        DialogInterface r3 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        r3.dismiss();
        return Unit.INSTANCE;
    }

    private static final Unit showDeleteEpisodicMemoryDialog$lambda$31(EpisodicMemoryDetailViewModel r1, EpisodicMemoryEntity r2, MemoryDetailActivity r3, DialogInterface r4, int r5) {
        MemoryDetailActivity r6 = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r7 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "dialog");
        r1.deleteMemoryEntity2(r2.getEntityId());
        r1.get_memoryEntityStateFlow().b(null);
        r7.dismiss();
        r6.onBackPressed();
        return Unit.INSTANCE;
    }

    private final void showDeletedToastOnce(int r7) {
        long r0 = System.currentTimeMillis();
        if ((r0 - lastDeletedToastTime) >= 1000) goto L5;
        return;
    L5:
        lastDeletedToastTime = r0;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin");
        String r6 = getString(r7);
        Intrinsics.checkNotNullExpressionValue(r6, "getString(...)");
        ba.a(r1, r6, 0, 4, null);
    }

    static /* synthetic */ void showDeletedToastOnce$default(MemoryDetailActivity r1, int r2, int r3, Object r4) {
        MemoryDetailActivity r5 = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = ZeusTransformUtils.mapRes(R.string.memory_source_jump_not_exist, TypedValues.Custom.S_STRING, "memory_source_jump_not_exist");
    L5:
        r5.showDeletedToastOnce(r2);
    }

    private final void showListPicker(final String r3, List<String> r4, Function1<? super String, Unit> r5) {
        final List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        final Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.markdown.custom.g.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), new $$Lambda$MemoryDetailActivity$ObXZ76l78qsQQqTFSeR0kEAcefs(r3, r6, r7));
    }

    private static final Unit showListPicker$lambda$10(String r2, List r3, Function1 r4, com.obric.memorydata.markdown.custom.f r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        final Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "$this$showMenu");
        r5.a(r2);
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L7;
        final String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        r5.a(r9, new $$Lambda$MemoryDetailActivity$W2Lus7twAfyxh8cjs4qvU6G1bJQ(r7, r9));
        goto L4
    L7:
        return Unit.INSTANCE;
    }

    private static final Unit showListPicker$lambda$10$lambda$9$lambda$8(Function1 r2, String r3) {
        ((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3);
        return Unit.INSTANCE;
    }

    private final void showPopupMenu(View r15) {
        AbsMemoryDetailViewModel<?> r0 = this.viewModel;
        Function1 r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        com.obric.memorydata.memory.ui.data.a r4 = (com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r0.getMemoryEntityStateFlow().c(), com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        return;
    L8:
        final MemoryFeedbackScene r2 = MemoryFeedbackScene.Companion.a(r4);
        if (r2 == null) goto L11;
        r1 = new $$Lambda$MemoryDetailActivity$3LoAetBtproYwFP9r035S_ECo44(this, r2);
    L11:
        new com.obric.memorydata.memory.ui.g(r15, r4, null, new $$Lambda$MemoryDetailActivity$nDuogrPYVny5ns1nLXZLKYaaNBE(this), new $$Lambda$MemoryDetailActivity$RWAeJzLhev_UzDE88m31nmBEwn8(this), null, null, r1, null, 356, null).a(80);
    }

    private static final Unit showPopupMenu$lambda$36$lambda$35(MemoryDetailActivity r9, final MemoryFeedbackScene r10, final com.obric.memorydata.memory.ui.data.a r11) {
        MemoryDetailActivity r12 = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r9, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "item");
        com.obric.memorydata.memory.ui.feedback.f.a(new com.obric.memorydata.memory.ui.feedback.f((Activity) ZeusTransformUtils.preCheckCast(r12, Activity.class, "com.obric.memorydata.plugin")), r10, null, new $$Lambda$MemoryDetailActivity$JyRgiARMnuss7kUkGhU8YttUXU0(r11, r10), new $$Lambda$MemoryDetailActivity$UvEowAYIUSUeOQMzZY9KyhaG1A(r11), 2, null);
        return Unit.INSTANCE;
    }

    private static final List showPopupMenu$lambda$36$lambda$35$lambda$33(com.obric.memorydata.memory.ui.data.a r1, MemoryFeedbackScene r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "readableDesc");
        return com.obric.memorydata.memory.ui.feedback.e.f10935a.a(r1, r2, r3);
    }

    private static final com.obric.memorydata.memory.ui.feedback.h showPopupMenu$lambda$36$lambda$35$lambda$34(com.obric.memorydata.memory.ui.data.a r1) {
        return com.obric.memorydata.memory.ui.feedback.i.f10952a.a(r1);
    }

    private static final Unit showPopupMenu$lambda$38(MemoryDetailActivity r2, com.obric.memorydata.memory.ui.data.a r3) {
        MemoryDetailActivity r4 = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "item");
        if (ZeusTransformUtils.instanceOf(r3, com.obric.memorydata.memory.ui.data.a.e.class) == false) goto L6;
        r4.showDeleteDialog(((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b());
    L9:
        return Unit.INSTANCE;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L9;
        r4.showDeleteEpisodicMemoryDialog(((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b());
        goto L9
    }

    private static final Unit showPopupMenu$lambda$39(MemoryDetailActivity r5, com.obric.memorydata.memory.ui.data.a r6) {
        MemoryDetailActivity r7 = (MemoryDetailActivity) ZeusTransformUtils.wrapperContextForParams(r5, MemoryDetailActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "item");
        if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L6;
        String r8 = ((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b().getLogId();
    L9:
        RunLog.INSTANCE.debug("MemoryListItemViewHolder", "logId: " + r8);
        if (r8 != null) goto L12;
        r8 = "19700101000000";
    L12:
        String r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_copy_to_clipboard_text, TypedValues.Custom.S_STRING, "memory_copy_to_clipboard_text"));
        Intrinsics.checkNotNullExpressionValue(r0, "getString(...)");
        ba.a(r8, "screen_observation_logId", r0, (Activity) ZeusTransformUtils.preCheckCast(r7, Activity.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.memorydata.memory.ui.data.a.e.class) == false) goto L8;
        r8 = ((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b().getLogId();
        goto L9
    L8:
        r8 = null;
        goto L9
    }

    private final <T> void singleOrPick(List<? extends T> r2, Function1<? super T, Unit> r3, Function1<? super List<? extends T>, Unit> r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if (r1.size() != 1) goto L5;
        r5.invoke(CollectionsKt.first(r1));
        return;
    L5:
        r6.invoke(r1);
    }

    private final void trackDetailPageShow(AppEntity r11, String r12) {
        MemoryEventTracker r0 = MemoryEventTracker.f10515a;
        String r3 = MemoryEventTracker.MemoryPage.MEMORY_DETAIL.getValue();
        if (Intrinsics.areEqual(r12, MemoryEventTracker.SourceType.MEMORY_RELATION.getValue()) == false) goto L8;
        MemoryEventTracker.MemoryPage r10 = MemoryEventTracker.MemoryPage.MEMORY_DETAIL;
    L5:
        String r13 = r10.getValue();
    L11:
        MemoryEventTracker.a(r0, r11, r12, r3, r13, null, null, null, 112, null);
        return;
    L8:
        if (Intrinsics.areEqual(r12, MemoryEventTracker.SourceType.MEMORY_LIST.getValue()) == false) goto L10;
        r10 = MemoryEventTracker.MemoryPage.MEMORY_LIST;
        goto L5
    L10:
        r13 = null;
        goto L11
    }

    private final List<String> validValues(Map<String, ? extends List<String>> r6, String... r7) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r1 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        List r3 = (List) ZeusTransformUtils.preCheckCast(r5.get(r7[r2]), List.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        r3 = CollectionsKt.emptyList();
    L7:
        CollectionsKt.addAll(r8, (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"));
        r2 = r2 + 1;
        goto L3
    L8:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        r10.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        goto L10
    L12:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L14:
        if (r14.hasNext() == false) goto L19;
        Object r15 = r14.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L14;
        r13.add(r15);
        goto L14
    L19:
        return CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    }

    private final void validateCurrentEntityOnResume() {
        if (this.viewModel != null) goto L5;
        return;
    L5:
        if (isFinishing() == false) goto L7;
        return;
    L7:
        if (isDestroyed() == false) goto L9;
        return;
    L9:
        if (this.isValidatingEntity == true) goto L16;
        this.isValidatingEntity = true;
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new C11461(this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        return;
    }

    @Override // com.obric.memorydata.memory.ui.BaseMemoryActivity
    public String getEnterFrom() {
        AbsMemoryDetailViewModel<?> r2 = this.viewModel;
        if (r2 == null) goto L7;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r2 = null;
    L9:
        return (String) ZeusTransformUtils.preCheckCast(r2.getEnterFrom().c(), String.class, "com.obric.memorydata.plugin");
    L7:
        return "";
    }

    public void onActionModeFinished(ActionMode r3) {
        Intrinsics.checkNotNullParameter(r3, "mode");
        ActivityMemoryDetailBinding r0 = this.binding;
        if (r0 != null) goto L5;
    L9:
        super.onActionModeFinished(r3);
        return;
    L5:
        if (this.isTextSelectionActionModeActive == false) goto L9;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L8:
        r0.rvMemoryList.setOverScrollMode(this.memoryListDefaultOverScrollMode);
        this.isTextSelectionActionModeActive = false;
        goto L9
    }

    public void onActionModeStarted(ActionMode r2) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        super.onActionModeStarted(r2);
        ActivityMemoryDetailBinding r3 = this.binding;
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.isTextSelectionActionModeActive == true) goto L13;
        this.isTextSelectionActionModeActive = true;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L10:
        RecyclerView r4 = r3.rvMemoryList;
        r4.stopScroll();
        r4.setOverScrollMode(2);
        Intrinsics.checkNotNull(r4);
        clearActiveBounceEffect(r4);
        return;
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        int r0 = ba.c();
        boolean r1 = isLocked();
        AbsMemoryDetailViewModel<?> r2 = this.viewModel;
        if (r2 == null) goto L7;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r2 = null;
    L6:
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getEnterFrom().c(), String.class, "com.obric.memorydata.plugin");
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onBackPressed taskId=" + getTaskId() + ", numActivities=" + r0 + ", locked=" + r1 + ", enterFrom=" + r3, false, 4, null);
        if (r1 == true) goto L11;
    L14:
        super.onBackPressed();
        return;
    L11:
        if (MemoryEventTracker.f10515a.a().contains(r3) == false) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onBackPressed: locked && enterFrom in MemoryEventTracker.externalSourceTypes → exitApp", false, 4, null);
        exitApp();
        return;
    L7:
        r3 = "";
        goto L8
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r12) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onCreateChecked taskId=" + getTaskId() + ", isTaskRoot=" + isTaskRoot(), false, 4, null);
        prepareSystemBar();
        ActivityMemoryDetailBinding r13 = ActivityMemoryDetailBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r13, "inflate(...)");
        this.binding = r13;
        ActivityMemoryDetailBinding r2 = null;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r13.getRoot(), View.class, "com.obric.memorydata.plugin"));
        ActivityMemoryDetailBinding r14 = this.binding;
        if (r14 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L8:
        RecyclerView r15 = r14.rvMemoryList;
        Intrinsics.checkNotNullExpressionValue(r15, "rvMemoryList");
        boolean r3 = false;
        com.obric.memorydata.ui.g.a((View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.memorydata.plugin"), 0, 1, null);
        initFromIntent();
        if (this.viewModel != null) goto L11;
    L21:
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r16 = new StringBuilder().append("onCreate return early after initFromIntent, viewModelInitialized=");
        if (this.viewModel == null) goto L24;
        r3 = true;
    L24:
        IRunLog.a.a(r5, TAG, r16.append(r3).append(", isFinishing=").append(isFinishing()).append(", isDestroyed=").append(isDestroyed()).toString(), null, 4, null);
        return;
    L11:
        if (isFinishing() == true) goto L21;
        if (isDestroyed() == true) goto L21;
        initView();
        ActivityMemoryDetailBinding r17 = this.binding;
        if (r17 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L19:
        OFloatingTitleBar r18 = r2.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r18, "viewTitle");
        registerFloatingTitleBar(r18);
        observeData();
        observeSafetyRemoval();
        return;
    L18:
        r2 = r17;
        goto L19
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onResumeChecked() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onResumeChecked", false, 4, null);
        validateCurrentEntityOnResume();
    }
}
