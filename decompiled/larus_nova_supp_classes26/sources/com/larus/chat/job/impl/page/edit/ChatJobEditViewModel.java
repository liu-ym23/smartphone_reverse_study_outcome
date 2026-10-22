package com.larus.chat.job.impl.page.edit;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.job.AIJob;
import com.larus.im.bean.job.AIJobScheduleConfig;
import com.larus.im.bean.job.AIJobScheduleParseRequest;
import com.larus.im.bean.job.AIJobScheduleParseResult;
import com.larus.im.bean.job.AIJobScheduleTime;
import com.larus.im.bean.job.AIJobUpdatePatch;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.core.job.AIJobServiceImpl;
import com.larus.im.service.IAIJobService;
import com.larus.utils.logger.FLogger;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowImpl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u0095\u00012\u00020\u0001:\u0004\u0094\u0001\u0095\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010.\u001a\u00020/2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u000203J\u001a\u00104\u001a\u00020/2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0017J\u0016\u00106\u001a\u00020/2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0006J\u000e\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020\u0006J\u0006\u0010<\u001a\u00020/J\u0006\u0010=\u001a\u00020/J\u0006\u0010>\u001a\u00020/J\u0006\u0010?\u001a\u00020/J\u0006\u0010@\u001a\u00020/J\u000e\u0010A\u001a\u00020/2\u0006\u0010B\u001a\u00020CJ\u000e\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020\u0006J\u0006\u0010F\u001a\u00020/J\u001e\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u0002032\u0006\u0010I\u001a\u0002032\u0006\u0010J\u001a\u000203J\u0006\u0010K\u001a\u00020LJ\u0016\u0010M\u001a\u00020/2\u0006\u0010N\u001a\u0002032\u0006\u0010O\u001a\u000203J\u000e\u0010P\u001a\u00020/2\u0006\u0010O\u001a\u000203J\u0006\u0010Q\u001a\u00020/JL\u0010R\u001a\u00020/2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010S\u001a\u00020\u00112\b\u0010T\u001a\u0004\u0018\u00010\u00112\u0006\u0010U\u001a\u00020\u00192\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010W\u001a\u0004\u0018\u00010\u00062\b\u0010X\u001a\u0004\u0018\u00010\u001cH\u0002J:\u0010Y\u001a\u00020/2\u0006\u0010\u000f\u001a\u00020\u00062\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010W\u001a\u0004\u0018\u00010\u00062\u0006\u0010Z\u001a\u00020[2\b\b\u0002\u0010\\\u001a\u00020\u0006H\u0002J\u0006\u0010]\u001a\u00020/J\u0006\u0010^\u001a\u00020/J\u0006\u0010_\u001a\u00020/J\u0006\u0010`\u001a\u00020/J\u0006\u0010a\u001a\u00020bJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J(\u0010c\u001a\u00020/2\u001e\u0010d\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002010f\u0012\u0004\u0012\u00020/0eH\u0002J\u0018\u0010g\u001a\u00020b2\u0006\u0010h\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020\u0006H\u0002J\u0010\u0010i\u001a\u00020/2\u0006\u0010j\u001a\u00020kH\u0002JP\u0010l\u001a\u00020/2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u00062\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020/0n2\u0012\u0010o\u001a\u000e\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020/0n2\u000e\b\u0002\u0010p\u001a\b\u0012\u0004\u0012\u00020/0qH\u0002J\b\u0010r\u001a\u00020/H\u0002J\u0010\u0010s\u001a\u00020/2\u0006\u0010t\u001a\u000201H\u0002J\f\u0010u\u001a\u00020\u0011*\u000201H\u0002J\b\u0010v\u001a\u00020/H\u0014J&\u0010w\u001a\u00020/2\b\b\u0002\u0010x\u001a\u00020b2\u0012\u0010y\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110nH\u0002J\u0016\u0010z\u001a\u00020b*\u00020\u00112\b\u0010{\u001a\u0004\u0018\u00010\u0011H\u0002J\u0016\u0010|\u001a\u00020b*\u00020\u00112\b\u0010{\u001a\u0004\u0018\u00010\u0011H\u0002J\u0016\u0010}\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010~\u001a\u000203H\u0002J\"\u0010\u007f\u001a\u00030\u0080\u0001*\u00020\u00112\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00112\b\u0010X\u001a\u0004\u0018\u00010\u001cH\u0002J\u0015\u0010\u0082\u0001\u001a\u00020b*\u00020\u00112\u0006\u0010X\u001a\u00020\u001cH\u0002J\r\u0010\u0083\u0001\u001a\u00020\u0006*\u00020\u0011H\u0002J\u001e\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00112\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0011H\u0002J\u000e\u0010\u0085\u0001\u001a\u00030\u0086\u0001*\u00020\u0011H\u0002J\u0018\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020$0\u00052\u0007\u0010\u0088\u0001\u001a\u00020\u0011H\u0002J\u0019\u0010\u0089\u0001\u001a\t\u0012\u0005\u0012\u00030\u008a\u00010\u00052\u0007\u0010\u0088\u0001\u001a\u00020\u0011H\u0002J\r\u0010\u008b\u0001\u001a\u000203*\u00020CH\u0002J\r\u0010\u008c\u0001\u001a\u000203*\u00020\u0006H\u0002J\u000f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0006*\u00020\u0011H\u0002J\u0012\u0010\u008e\u0001\u001a\u00020\u00062\u0007\u0010\u008f\u0001\u001a\u00020LH\u0002J\u0013\u0010\u0090\u0001\u001a\u00020\u00062\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0002J\u0011\u0010\u0093\u0001\u001a\u00020\u00062\u0006\u0010O\u001a\u000203H\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00050\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00050 ¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020)0+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006\u0096\u0001"}, d2 = {"Lcom/larus/chat/job/impl/page/edit/ChatJobEditViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "frequencyOptions", "", "", "getFrequencyOptions", "()Ljava/util/List;", "aiJobService", "Lcom/larus/im/service/IAIJobService;", "getAiJobService", "()Lcom/larus/im/service/IAIJobService;", "aiJobService$delegate", "Lkotlin/Lazy;", "jobId", "originalSnapshot", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditUiState;", "currentConversationId", "trackingRunEnvironment", "taskReplyModelKeys", "taskReplyModelFallbackName", "taskReplyModelDisplayNames", "", "userEditVersion", "", "customScheduleParseGeneration", "parsedCustomSchedule", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditViewModel$ParsedCustomSchedule;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "_listItems", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditListItem;", "listItems", "getListItems", "_effects", "Lkotlinx/coroutines/channels/Channel;", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditEffect;", "effects", "Lkotlinx/coroutines/flow/Flow;", "getEffects", "()Lkotlinx/coroutines/flow/Flow;", "load", "", "initialJob", "Lcom/larus/im/bean/job/AIJob;", "jobType", "", "updateTaskReplyModelDisplayNames", "displayNames", "updateText", "key", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditTextKey;", ShareType.TEXT, "selectRepeat", ChatJobEditViewModel.TRACKING_FIELD_REPEAT, "toggleModel", "toggleEnvironment", "toggleProject", "openFrequencyPage", "closeSubPage", "toggleWeekday", "weekday", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditWeekday;", "updateCustomFrequencyInput", "input", "confirmSubPage", "selectDate", "year", "month", "dayOfMonth", "minExecuteDate", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditDate;", "selectTime", "hourOfDay", "minute", "selectHourlyMinute", "saveDraft", "submitUpdate", "submittedState", "submittedOriginal", "saveEditVersion", "editFields", "repeatType", "parsedSchedule", "handleSaveFailure", "error", "Lcom/larus/im/callback/IIMError;", "operation", "runJob", "pauseJob", "resumeJob", "deleteJob", "isPaused", "", "mutateJob", "action", "Lkotlin/Function2;", "Lcom/larus/im/callback/IIMCallback;", "isCurrentJobCallback", "callbackJobId", "confirmCustomFrequency", "subPage", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditSubPageState$Custom;", "requestCustomScheduleParse", "onSuccess", "Lkotlin/Function1;", "onFailure", "onDiscarded", "Lkotlin/Function0;", "invalidateParsedCustomSchedule", "applyJob", "job", "toAuthoritativeEditState", "onCleared", "updateState", "markUserEdit", "reducer", "samePatchContent", "other", "sameScheduleContent", "asOriginalSnapshot", "status", "toPatch", "Lcom/larus/im/bean/job/AIJobUpdatePatch;", "original", "matchesParsedCustomSchedule", "customSchedulePrompt", "editTrackingFields", "scheduleConfig", "Lcom/larus/im/bean/job/AIJobScheduleConfig;", "buildListItems", "state", "buildScheduleRows", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditOptionRow;", "toProtocolWeekday", "toRepeatType", "trackingRepeatType", "formatDate", "date", "formatTime", "time", "Lcom/larus/chat/job/impl/page/edit/ChatJobEditTime;", "formatMinute", "ParsedCustomSchedule", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatJobEditViewModel extends ViewModel {
    public static final a Companion = null;
    private static final Set<ChatJobEditWeekday> DEFAULT_WEEKDAYS = null;
    private static final String SECTION_RUNTIME = "runtime";
    private static final String SECTION_SCHEDULE = "schedule";
    private static final String TAG = "ChatJobEditViewModel";
    private static final String TRACKING_FIELD_PROMPT = "prompt";
    private static final String TRACKING_FIELD_REPEAT = "repeat";
    private static final String TRACKING_FIELD_TITLE = "title";
    private static final String TRACKING_REPEAT_CUSTOM = "custom";
    private static final String TRACKING_REPEAT_DAILY = "daily";
    private static final String TRACKING_REPEAT_HOURLY = "hourly";
    private static final String TRACKING_REPEAT_NEVER = "never";
    private static final String TRACKING_REPEAT_WEEKLY = "weekly";
    private final Channel<com.larus.chat.job.impl.page.edit.i> _effects;
    private final kotlinx.coroutines.flow.z0<List<z>> _listItems;
    private final kotlinx.coroutines.flow.z0<f0> _uiState;
    private final Lazy aiJobService$delegate;
    private String currentConversationId;
    private long customScheduleParseGeneration;
    private final Flow<com.larus.chat.job.impl.page.edit.i> effects;
    private String jobId;
    private final kotlinx.coroutines.flow.i1<List<z>> listItems;
    private f0 originalSnapshot;
    private b parsedCustomSchedule;
    private Map<String, String> taskReplyModelDisplayNames;
    private String taskReplyModelFallbackName;
    private List<String> taskReplyModelKeys;
    private String trackingRunEnvironment;
    private final kotlinx.coroutines.flow.i1<f0> uiState;
    private long userEditVersion;

    public static final class a {
        public a() {
        }

        public static final f0 a(a r21) {
            r21.getClass();
            e0 r9 = new e0(9, 30);
            String r4 = gz8.f.d();
            Set r6 = ChatJobEditViewModel.access$getDEFAULT_WEEKDAYS$cp();
            com.larus.chat.job.impl.page.edit.h r10 = com.larus.chat.job.impl.page.edit.b.b(1);
            gz8.d.a.getClass();
            return new f0("", "", r4, "", r6, "", "", r10, r9, gz8.d.c(9, 30), gz8.f.b("model_menu_option_title_work_task_21pro_cn"), gz8.f.b("scheduledTasks_newTask_setting_environment_cloud"), gz8.f.b("scheduledTasks_newTask_setting_project_default"), 0, false, false, null, 1);
        }

        public static final String b(a r0) {
            r0.getClass();
            return gz8.f.c();
        }

        public static final String c(a r0) {
            r0.getClass();
            return gz8.f.g();
        }
    }

    public static final class b {
        public final String a;
        public final AIJobScheduleConfig b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            String r1 = this.c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "ParsedCustomSchedule(prompt=" + this.a + ", schedule=" + this.b + ", parseToken=" + this.c + ')';
        }

        public b(String r2, AIJobScheduleConfig r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, ChatJobEditViewModel.TRACKING_FIELD_PROMPT);
            Intrinsics.checkNotNullParameter(r3, ChatJobEditViewModel.SECTION_SCHEDULE);
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ChatJobEditTextKey.values().length];
            r0[ChatJobEditTextKey.TITLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L29:
            r0[ChatJobEditTextKey.PROMPT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L6:
            a = r0;
            int[] r1 = new int[ChatJobEditWeekday.values().length];
            r1[ChatJobEditWeekday.MONDAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L41:
            r1[ChatJobEditWeekday.TUESDAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L33:
            r1[ChatJobEditWeekday.WEDNESDAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L35:
            r1[ChatJobEditWeekday.THURSDAY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L25:
            r1[ChatJobEditWeekday.FRIDAY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L37:
            r1[ChatJobEditWeekday.SATURDAY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L23
        L27:
            r1[ChatJobEditWeekday.SUNDAY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L24
        L14:
            b = r1;
        }
    }

    public static final class d implements IIMCallback<Boolean> {
        public final /* synthetic */ ChatJobEditViewModel a;
        public final /* synthetic */ String b;

        public final boolean mustInMain() {
            return !com.larus.im.internal.delegate.y0.a();
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.e(ChatJobEditViewModel.TAG, "delete job failed, jobId=" + this.b + ", code=" + r4.getCode() + ", tips=" + r4.getTips());
            gz8.h.b(r4);
        }

        public final void onSuccess(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L5;
            ChatJobEditViewModel.access$get_effects$p(this.a).trySend-JP2dKIU(com.larus.chat.job.impl.page.edit.i.a.a);
            return;
        L5:
            gz8.h.a();
        }

        public d(ChatJobEditViewModel r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e implements IIMCallback<AIJob> {
        public final /* synthetic */ ChatJobEditViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.e(ChatJobEditViewModel.TAG, "get job failed, jobId=" + this.b + ", code=" + r4.getCode() + ", tips=" + r4.getTips());
            gz8.h.b(r4);
        }

        public final void onSuccess(Object r7) {
            AIJob r8 = (AIJob) r7;
            Intrinsics.checkNotNullParameter(r8, "result");
            if (Intrinsics.areEqual(ChatJobEditViewModel.access$getJobId$p(this.a), this.b) == false) goto L14;
            if (Intrinsics.areEqual(r8.getJobId(), this.b) == false) goto L14;
            int r0 = r8.getJobType();
            int r2 = this.c;
            if (r0 != r2) goto L14;
            if (r2 != 3) goto L14;
            if (r8.getStatus() != 4) goto L14;
            FLogger.a.i(ChatJobEditViewModel.TAG, "load editor skipped, event task is deleted jobId=" + this.b);
            t19.s r9 = t19.s.a;
            Application r1 = AppHost.a.getApplication();
            String r3 = gz8.f.b("triggerTasks_dialog_desc_alreadyDelete");
            r9.getClass();
            t19.s.c(r1, r3);
            return;
        L14:
            if (Intrinsics.areEqual(ChatJobEditViewModel.access$getJobId$p(this.a), this.b) == true) goto L16;
            return;
        L16:
            if (Intrinsics.areEqual(r8.getJobId(), this.b) == true) goto L18;
            return;
        L18:
            if (r8.getJobType() == this.c) goto L20;
            return;
        L20:
            if (com.larus.chat.job.impl.page.g0.c(r8) == true) goto L22;
            return;
        L22:
            if (ChatJobEditViewModel.access$getUserEditVersion$p(this.a) == this.d) goto L24;
            FLogger.a.i(ChatJobEditViewModel.TAG, "skip stale get job result, jobId=" + this.b);
            return;
        L24:
            FLogger.a.i(ChatJobEditViewModel.TAG, "get job success, jobId=" + this.b);
            ChatJobEditViewModel.access$applyJob(this.a, r8);
        }

        public e(ChatJobEditViewModel r1, String r2, int r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class f implements IIMCallback<AIJob> {
        public final /* synthetic */ ChatJobEditViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            if (ChatJobEditViewModel.access$isCurrentJobCallback(this.a, this.b, "mutate job failure") == true) goto L5;
            return;
        L5:
            FLogger.a.e(ChatJobEditViewModel.TAG, "mutate job failed, jobId=" + this.b + ", code=" + r4.getCode() + ", tips=" + r4.getTips());
            gz8.h.b(r4);
        }

        public final void onSuccess(Object r6) {
            final AIJob r7 = (AIJob) r6;
            Intrinsics.checkNotNullParameter(r7, "result");
            if (ChatJobEditViewModel.access$isCurrentJobCallback(this.a, this.b, "mutate job success") == true) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r7.getJobId(), this.b) == true) goto L7;
            return;
        L7:
            if (r7.getJobType() == this.c) goto L9;
            return;
        L9:
            if (com.larus.chat.job.impl.page.g0.c(r7) == true) goto L12;
            return;
        L12:
            if (ChatJobEditViewModel.access$getUserEditVersion$p(this.a) != this.d) goto L14;
            ChatJobEditViewModel.access$applyJob(this.a, r7);
            return;
        L14:
            ChatJobEditViewModel.access$setCurrentConversationId$p(this.a, r7.getConversationId());
            ChatJobEditViewModel.updateState$default(this.a, false, new j1(r7), 1, null);
        }

        public f(ChatJobEditViewModel r1, String r2, int r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class g implements IIMCallback<AIJobScheduleParseResult> {
        public final /* synthetic */ ChatJobEditViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Function0<Unit> d;
        public final /* synthetic */ Function1<b, Unit> e;
        public final /* synthetic */ String f;
        public final /* synthetic */ Function1<IIMError, Unit> g;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r6) {
            Intrinsics.checkNotNullParameter(r6, "error");
            if (Intrinsics.areEqual(ChatJobEditViewModel.access$getJobId$p(this.a), this.b) == true) goto L5;
        L9:
            this.d.invoke();
            return;
        L5:
            if (ChatJobEditViewModel.access$getCustomScheduleParseGeneration$p(this.a) != this.c) goto L9;
            this.g.invoke(r6);
        }

        public final void onSuccess(Object r6) {
            AIJobScheduleParseResult r7 = (AIJobScheduleParseResult) r6;
            Intrinsics.checkNotNullParameter(r7, "result");
            if (Intrinsics.areEqual(ChatJobEditViewModel.access$getJobId$p(this.a), this.b) == true) goto L5;
        L8:
            this.d.invoke();
            return;
        L5:
            if (ChatJobEditViewModel.access$getCustomScheduleParseGeneration$p(this.a) != this.c) goto L8;
            this.e.invoke(new b(this.f, r7.getSchedule(), r7.getParseToken()));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public g(ChatJobEditViewModel r1, String r2, long r3, Function0<Unit> r5, Function1<? super b, Unit> r6, String r7, Function1<? super IIMError, Unit> r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    public static final class h implements IIMCallback<AIJob> {
        public final /* synthetic */ String a;
        public final /* synthetic */ ChatJobEditViewModel b;

        public final boolean mustInMain() {
            return !com.larus.im.internal.delegate.y0.a();
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.e(ChatJobEditViewModel.TAG, "run job failed, jobId=" + this.a + ", code=" + r4.getCode() + ", tips=" + r4.getTips());
            gz8.h.b(r4);
        }

        public final void onSuccess(Object r3) {
            Intrinsics.checkNotNullParameter((AIJob) r3, "result");
            FLogger.a.i(ChatJobEditViewModel.TAG, "run job accepted, jobId=" + this.a);
            ChatJobEditViewModel.access$get_effects$p(this.b).trySend-JP2dKIU(com.larus.chat.job.impl.page.edit.i.b.a);
        }

        public h(String r1, ChatJobEditViewModel r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class i implements IIMCallback<AIJob> {
        public final /* synthetic */ ChatJobEditViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ f0 c;
        public final /* synthetic */ List<String> d;
        public final /* synthetic */ String e;
        public final /* synthetic */ long f;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r10) {
            Intrinsics.checkNotNullParameter(r10, "error");
            if (ChatJobEditViewModel.access$isCurrentJobCallback(this.a, this.b, "update job failure") == true) goto L5;
            return;
        L5:
            ChatJobEditViewModel.handleSaveFailure$default(this.a, this.b, this.d, this.e, r10, null, 16, null);
        }

        public final void onSuccess(Object r10) {
            final AIJob r11 = (AIJob) r10;
            Intrinsics.checkNotNullParameter(r11, "result");
            if (ChatJobEditViewModel.access$isCurrentJobCallback(this.a, this.b, "update job success") == true) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual(r11.getJobId(), this.b) == false) goto L17;
            if (r11.getJobType() != this.c.r) goto L17;
            if (com.larus.chat.job.impl.page.g0.c(r11) == false) goto L17;
            ez8.a r0 = ez8.a.a;
            String r5 = this.b;
            List<String> r6 = this.d;
            String r7 = this.e;
            r0.getClass();
            ez8.a.h(r5, r6, r7, true);
            final f0 r1 = ChatJobEditViewModel.access$toAuthoritativeEditState(this.a, r11);
            ChatJobEditViewModel.access$setCurrentConversationId$p(this.a, r11.getConversationId());
            ChatJobEditViewModel.access$setOriginalSnapshot$p(this.a, r1);
            ChatJobEditViewModel.access$setParsedCustomSchedule$p(this.a, null);
            FLogger.a.i(ChatJobEditViewModel.TAG, "update job success, jobId=" + this.b);
            if (ChatJobEditViewModel.access$getUserEditVersion$p(this.a) != this.f) goto L15;
            ChatJobEditViewModel.updateState$default(this.a, false, new l1(r1), 1, null);
            return;
        L15:
            ChatJobEditViewModel.updateState$default(this.a, false, new m1(r11), 1, null);
            return;
        L17:
            if (Intrinsics.areEqual(r11.getJobId(), this.b) == true) goto L19;
        L22:
            FLogger.a.e(ChatJobEditViewModel.TAG, "update job returned unexpected task, jobId=" + this.b + " type=" + r11.getJobType());
        L23:
            ChatJobEditViewModel.updateState$default(this.a, false, new k1(), 1, null);
            gz8.h.a();
            return;
        L19:
            if (r11.getJobType() != this.c.r) goto L22;
            FLogger.a.i(ChatJobEditViewModel.TAG, "update job returned unavailable task, jobId=" + this.b + " type=" + r11.getJobType());
            goto L23
        }

        public i(ChatJobEditViewModel r1, String r2, f0 r3, List<String> r4, String r5, long r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public static /* synthetic */ Unit Mo(ChatJobEditViewModel r0, String r1, String r2, IIMError r3) {
        return confirmCustomFrequency$lambda$39(r0, r1, r2, r3);
    }

    public static /* synthetic */ f0 No(int r0, f0 r1) {
        return load$lambda$1(r0, r1);
    }

    public static /* synthetic */ f0 Oo(f0 r0) {
        return openFrequencyPage$lambda$10(r0);
    }

    public static /* synthetic */ f0 Po(int r0, int r1, ChatJobEditViewModel r2, f0 r3) {
        return selectTime$lambda$17(r0, r1, r2, r3);
    }

    public static /* synthetic */ f0 Qo(f0 r0) {
        return saveDraft$lambda$26$lambda$25(r0);
    }

    public static /* synthetic */ f0 So(int r0, ChatJobEditViewModel r1, f0 r2) {
        return selectHourlyMinute$lambda$18(r0, r1, r2);
    }

    public static /* synthetic */ f0 To(String r0, d0.a r1, f0 r2) {
        return confirmCustomFrequency$lambda$34(r0, r1, r2);
    }

    public static /* synthetic */ Unit Wo(ChatJobEditViewModel r0, String r1, List r2, String r3, IIMError r4) {
        return saveDraft$lambda$24(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ f0 Yo(d0 r0, f0 r1) {
        return confirmSubPage$lambda$15(r0, r1);
    }

    public static /* synthetic */ f0 Zo(f0 r0) {
        return saveDraft$lambda$21(r0);
    }

    public static /* synthetic */ Unit ap(ChatJobEditViewModel r0) {
        return saveDraft$lambda$26(r0);
    }

    private static final f0 applyJob$lambda$41(f0 r1, f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r1;
    }

    public static /* synthetic */ f0 bp(String r0, f0 r1) {
        return updateTaskReplyModelDisplayNames$lambda$7(r0, r1);
    }

    public static /* synthetic */ f0 cp(d0.a r0, f0 r1) {
        return confirmCustomFrequency$lambda$39$lambda$38(r0, r1);
    }

    public static /* synthetic */ IAIJobService dp() {
        return aiJobService_delegate$lambda$0();
    }

    public static /* synthetic */ Unit ep() {
        return requestCustomScheduleParse$lambda$40();
    }

    public static /* synthetic */ f0 hp(f0 r0) {
        return handleSaveFailure$lambda$27(r0);
    }

    public static /* synthetic */ Unit ip(ChatJobEditViewModel r0, String r1, b r2) {
        return confirmCustomFrequency$lambda$37(r0, r1, r2);
    }

    public static /* synthetic */ Unit kp(ChatJobEditViewModel r0, String r1, IIMCallback r2) {
        return resumeJob$lambda$30(r0, r1, r2);
    }

    public static /* synthetic */ f0 lp(f0 r0) {
        return saveDraft$lambda$22(r0);
    }

    public static /* synthetic */ f0 np(String r0, f0 r1) {
        return updateCustomFrequencyInput$lambda$14(r0, r1);
    }

    public static /* synthetic */ f0 pp(String r0, f0 r1) {
        return selectRepeat$lambda$9(r0, r1);
    }

    public static /* synthetic */ Unit rp(ChatJobEditViewModel r0, String r1, IIMCallback r2) {
        return pauseJob$lambda$29(r0, r1, r2);
    }

    public static /* synthetic */ f0 sp(f0 r0, f0 r1) {
        return applyJob$lambda$41(r0, r1);
    }

    public static /* synthetic */ f0 tp(ChatJobEditWeekday r0, f0 r1) {
        return toggleWeekday$lambda$12(r0, r1);
    }

    public static /* synthetic */ Unit up(ChatJobEditViewModel r0, String r1, f0 r2, f0 r3, long r4, List r6, String r7, b r8) {
        return saveDraft$lambda$23(r0, r1, r2, r3, r4, r6, r7, r8);
    }

    public static /* synthetic */ f0 vp(String r0, String r1, f0 r2) {
        return confirmCustomFrequency$lambda$37$lambda$36(r0, r1, r2);
    }

    public static /* synthetic */ f0 wp(ChatJobEditTextKey r0, String r1, f0 r2) {
        return updateText$lambda$8(r0, r1, r2);
    }

    public static /* synthetic */ f0 xp(int r0, int r1, int r2, f0 r3) {
        return selectDate$lambda$16(r0, r1, r2, r3);
    }

    public static /* synthetic */ f0 yo(f0 r0) {
        return closeSubPage$lambda$11(r0);
    }

    public final List<String> getFrequencyOptions() {
        return CollectionsKt.listOf(new String[]{gz8.f.e(), gz8.f.d(), gz8.f.g(), gz8.f.c(), gz8.f.f()});
    }

    public final com.larus.chat.job.impl.page.edit.h minExecuteDate() {
        return com.larus.chat.job.impl.page.edit.b.b(0);
    }

    public final void toggleEnvironment() {
    }

    public final void toggleModel() {
    }

    public final void toggleProject() {
    }

    static {
        Companion = new a();
        DEFAULT_WEEKDAYS = SetsKt.setOf(new ChatJobEditWeekday[]{ChatJobEditWeekday.MONDAY, ChatJobEditWeekday.WEDNESDAY, ChatJobEditWeekday.FRIDAY});
    }

    private static final IAIJobService aiJobService_delegate$lambda$0() {
        int r0 = com.larus.im.d.a;
        return AIJobServiceImpl.INSTANCE;
    }

    private final IAIJobService getAiJobService() {
        return (IAIJobService) this.aiJobService$delegate.getValue();
    }

    private final void invalidateParsedCustomSchedule() {
        this.customScheduleParseGeneration++;
        this.parsedCustomSchedule = null;
    }

    public final void closeSubPage() {
        if ((((f0) this._uiState.getValue()).q instanceof d0.a) == false) goto L5;
        invalidateParsedCustomSchedule();
    L5:
        updateState$default(this, false, new z0(), 1, null);
    }

    public final void confirmSubPage() {
        final d0 r0 = ((f0) this._uiState.getValue()).q;
        if ((r0 instanceof d0.b) == false) goto L8;
        if ((!((d0.b) r0).a.isEmpty()) == false) goto L11;
        updateState(true, new g0(r0));
        return;
    L11:
        return;
    L8:
        if ((r0 instanceof d0.a) == false) goto L10;
        confirmCustomFrequency((d0.a) r0);
        return;
    L10:
        if (r0 != null) goto L13;
        return;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final void deleteJob() {
        int r0 = com.larus.chat.job.impl.page.g0.a;
        if (com.larus.chat.job.impl.page.g0.b(((f0) this._uiState.getValue()).r) == true) goto L5;
        return;
    L5:
        String r1 = this.jobId;
        if (r1 != null) goto L8;
        return;
    L8:
        if ((!StringsKt.isBlank(r1)) == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L16;
        getAiJobService().deleteJob(r1, ((f0) this._uiState.getValue()).r, new d(this, r1));
        return;
    }

    public final boolean isPaused() {
        if (((f0) this._uiState.getValue()).n != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final void openFrequencyPage() {
        if (((f0) this._uiState.getValue()).c() == true) goto L5;
        return;
    L5:
        updateState$default(this, false, new j0(), 1, null);
    }

    public final void pauseJob() {
        mutateJob(new i0(this));
    }

    public final void resumeJob() {
        mutateJob(new t0(this));
    }

    public final void runJob() {
        if (((f0) this._uiState.getValue()).c() == true) goto L6;
        FLogger.a.i(TAG, "run job skipped: event tasks cannot run manually");
        return;
    L6:
        String r0 = this.jobId;
        if (r0 != null) goto L9;
        return;
    L9:
        if ((!StringsKt.isBlank(r0)) == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L17;
        getAiJobService().runJob(r0, new h(r0, this));
        return;
    }

    public final void saveDraft() {
        String r0 = this.jobId;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((!StringsKt.isBlank(r0)) == false) goto L7;
        final String r10 = r0;
    L8:
        if (r10 == null) goto L58;
        final f0 r4 = (f0) this._uiState.getValue();
        if (r4.b() == true) goto L13;
        return;
    L13:
        final f0 r5 = this.originalSnapshot;
        final long r6 = this.userEditVersion;
        final List<String> r11 = editTrackingFields(r4, r5);
        final String r12 = trackingRepeatType(r4);
        b r1 = this.parsedCustomSchedule;
        if (r1 != null) goto L16;
    L18:
        b r8 = null;
    L20:
        if (r4.c() == true) goto L22;
    L27:
        boolean r2 = false;
    L28:
        String r13 = customSchedulePrompt(r4);
        if (r2 == true) goto L31;
    L37:
        ez8.a r14 = ez8.a.a;
        String r15 = this.trackingRunEnvironment;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r10, "jobId");
        Intrinsics.checkNotNullParameter(r11, "editFields");
        if (StringsKt.isBlank(r10) == false) goto L40;
    L51:
        updateState$default(this, false, new f1(), 1, null);
        if (r2 == false) goto L55;
        final String r3 = r10;
        requestCustomScheduleParse(r10, r13, new g1(this, r3, r4, r5, r6, r11, r12), new h1(this, r10, r11, r12), new i1(this));
        return;
    L55:
        submitUpdate(r10, r4, r5, r6, r11, r12, r8);
        return;
    L40:
        if (r11.isEmpty() == true) goto L51;
        JSONObject r7 = new JSONObject().put("job_id", r10).put("edit_field", CollectionsKt.joinToString$default(r11, ",", null, null, 0, null, null, 62, null)).put("repeat_type", r12);
        if (r15 != null) goto L45;
    L50:
        Intrinsics.checkNotNull(r7);
        ez8.a.f("edit_cron_job", r7);
        goto L51
    L45:
        if ((!StringsKt.isBlank(r15)) == true) goto L48;
        r15 = null;
    L48:
        if (r15 == null) goto L50;
        r7.put("run_env", r15);
        goto L50
    L31:
        if (r13.length() != 0) goto L33;
        boolean r16 = true;
    L34:
        if (r16 == false) goto L37;
        updateState$default(this, false, new e1(), 1, null);
        return;
    L33:
        r16 = false;
        goto L34
    L22:
        if (Intrinsics.areEqual(r4.c, a.b(Companion)) == false) goto L27;
        if (sameScheduleContent(r4, r5) == true) goto L27;
        if (r8 != null) goto L27;
        r2 = true;
        goto L28
    L16:
        if (matchesParsedCustomSchedule(r4, r1) == false) goto L18;
        r8 = r1;
        goto L20
    L58:
        return;
    L7:
        r10 = null;
        goto L8
    }

    public ChatJobEditViewModel() {
        this.aiJobService$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new o0());
        this.taskReplyModelKeys = CollectionsKt.emptyList();
        this.taskReplyModelFallbackName = "";
        this.taskReplyModelDisplayNames = MapsKt.emptyMap();
        StateFlowImpl r0 = kotlinx.coroutines.flow.j1.a(a.a(Companion));
        this._uiState = r0;
        this.uiState = r0;
        StateFlowImpl r1 = kotlinx.coroutines.flow.j1.a(buildListItems((f0) r0.getValue()));
        this._listItems = r1;
        this.listItems = r1;
        Channel<com.larus.chat.job.impl.page.edit.i> r2 = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._effects = r2;
        this.effects = kotlinx.coroutines.flow.e.A(r2);
    }

    public void onCleared() {
        invalidateParsedCustomSchedule();
        SendChannel.a.a(this._effects);
        super.onCleared();
    }

    public static final /* synthetic */ Set access$getDEFAULT_WEEKDAYS$cp() {
        return DEFAULT_WEEKDAYS;
    }

    private static final Unit requestCustomScheduleParse$lambda$40() {
        return Unit.INSTANCE;
    }

    public final String currentConversationId() {
        return this.currentConversationId;
    }

    public final Flow<com.larus.chat.job.impl.page.edit.i> getEffects() {
        return this.effects;
    }

    public final kotlinx.coroutines.flow.i1<List<z>> getListItems() {
        return this.listItems;
    }

    public final kotlinx.coroutines.flow.i1<f0> getUiState() {
        return this.uiState;
    }

    public static final /* synthetic */ long access$getCustomScheduleParseGeneration$p(ChatJobEditViewModel r2) {
        return r2.customScheduleParseGeneration;
    }

    public static final /* synthetic */ String access$getJobId$p(ChatJobEditViewModel r0) {
        return r0.jobId;
    }

    public static final /* synthetic */ long access$getUserEditVersion$p(ChatJobEditViewModel r2) {
        return r2.userEditVersion;
    }

    public static final /* synthetic */ Channel access$get_effects$p(ChatJobEditViewModel r0) {
        return r0._effects;
    }

    private final void applyJob(AIJob r4) {
        invalidateParsedCustomSchedule();
        this.currentConversationId = r4.getConversationId();
        final f0 r5 = toAuthoritativeEditState(r4);
        this.originalSnapshot = r5;
        updateState$default(this, false, new n0(r5), 1, null);
    }

    private final List<z> buildListItems(f0 r8) {
        z[] r0 = new z[4];
        r0[0] = new z.b(ChatJobEditTextKey.TITLE, r8.a, false);
        r0[1] = new z.b(ChatJobEditTextKey.PROMPT, r8.b, true);
        if (r8.c() == false) goto L5;
        z.a r1 = new z.a(SECTION_SCHEDULE, buildScheduleRows(r8));
    L6:
        r0[2] = r1;
        List r2 = CollectionsKt.createListBuilder();
        if ((!StringsKt.isBlank(r8.k)) == false) goto L9;
        r2.add(new a0(ChatJobEditOptionKey.MODEL, gz8.f.b("scheduledTasks_newTask_setting_model"), r8.k, 8));
    L9:
        r2.add(new a0(ChatJobEditOptionKey.ENVIRONMENT, gz8.f.b("scheduledTasks_newTask_setting_environment"), r8.l, 8));
        Unit r9 = Unit.INSTANCE;
        r0[3] = new z.a(SECTION_RUNTIME, CollectionsKt.build(r2));
        return CollectionsKt.listOfNotNull(r0);
    L5:
        r1 = null;
        goto L6
    }

    private final List<a0> buildScheduleRows(f0 r9) {
        List<a0> r0 = CollectionsKt.mutableListOf(new a0[]{new a0(ChatJobEditOptionKey.REPEAT, gz8.f.b("scheduledTasks_newTask_setting_repeats"), r9.c, 24)});
        String r1 = r9.c;
        Companion.getClass();
        if (Intrinsics.areEqual(r1, gz8.f.e()) == false) goto L6;
        r0.add(new a0(ChatJobEditOptionKey.HOURLY_MINUTE, gz8.f.b("scheduledTasks_newTask_repeats_hour_minute"), formatMinute(r9.i.b), 24));
    L15:
        return r0;
    L6:
        if (Intrinsics.areEqual(r1, gz8.f.g()) == false) goto L9;
        List<a0> r2 = r0;
        r2.add(new a0(ChatJobEditOptionKey.FREQUENCY, gz8.f.b("scheduledTasks_newTask_setting_frequency"), r9.d, 24));
        r2.add(new a0(ChatJobEditOptionKey.RUN_TIME, gz8.f.b("scheduledTasks_newTask_repeats_weekly_time"), formatTime(r9.i), 24));
        goto L15
    L9:
        if (Intrinsics.areEqual(r1, gz8.f.c()) == false) goto L12;
        r0.add(new a0(ChatJobEditOptionKey.FREQUENCY, gz8.f.b("scheduledTasks_newTask_setting_frequency"), r9.d, 24));
        goto L15
    L12:
        if (Intrinsics.areEqual(r1, gz8.f.f()) == false) goto L14;
        List<a0> r3 = r0;
        r3.add(new a0(ChatJobEditOptionKey.DATE, gz8.f.b("scheduledTasks_newTask_repeats_never_date"), formatDate(r9.h), 24));
        r3.add(new a0(ChatJobEditOptionKey.TIME, gz8.f.b("scheduledTasks_newTask_repeats_never_time"), formatTime(r9.i), 24));
        goto L15
    L14:
        r0.add(new a0(ChatJobEditOptionKey.RUN_TIME, gz8.f.b("scheduledTasks_newTask_repeats_weekly_time"), formatTime(r9.i), 24));
        goto L15
    }

    private static final f0 closeSubPage$lambda$11(f0 r20) {
        Intrinsics.checkNotNullParameter(r20, "it");
        return f0.a(r20, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, false, false, null, 0, 196607);
    }

    private final void confirmCustomFrequency(final d0.a r13) {
        String r0 = this.jobId;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((!StringsKt.isBlank(r0)) == false) goto L7;
        final String r5 = r0;
    L8:
        if (r5 == null) goto L22;
        final String r6 = StringsKt.trim(r13.a).toString();
        if (r6.length() != 0) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L16;
        return;
    L16:
        if (r13.b == true) goto L23;
        updateState$default(this, false, new v0(r6, r13), 1, null);
        requestCustomScheduleParse$default(this, r5, r6, new w0(this, r6), new x0(this, r6, r5), null, 16, null);
        return;
    L23:
        return;
    L13:
        r1 = false;
        goto L14
    L22:
        return;
    L7:
        r5 = null;
        goto L8
    }

    private final String customSchedulePrompt(f0 r3) {
        String r0 = StringsKt.trim(r3.f).toString();
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        return r0;
    L8:
        return StringsKt.trim(r3.d).toString();
    L5:
        r1 = false;
        goto L6
    }

    private final String formatDate(com.larus.chat.job.impl.page.edit.h r9) {
        gz8.d r0 = gz8.d.a;
        int r2 = r9.a;
        int r1 = r9.b;
        int r4 = r9.c;
        r0.getClass();
        Locale r10 = Locale.getDefault();
        Calendar r3 = Calendar.getInstance(r10);
        r3.set(r2, r1 - 1, r4, 0, 0, 0);
        r3.set(14, 0);
        return DateFormat.getDateInstance(0, r10).format(r3.getTime());
    }

    private final String formatMinute(int r3) {
        return String.valueOf(RangesKt.coerceIn(r3, 0, 59));
    }

    private final String formatTime(e0 r3) {
        gz8.d r0 = gz8.d.a;
        int r1 = r3.a;
        int r4 = r3.b;
        r0.getClass();
        return gz8.d.c(r1, r4);
    }

    private static final f0 handleSaveFailure$lambda$27(f0 r20) {
        Intrinsics.checkNotNullParameter(r20, "it");
        return f0.a(r20, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, false, false, null, 0, 229375);
    }

    private final void mutateJob(Function2<? super String, ? super IIMCallback<AIJob>, Unit> r9) {
        int r0 = com.larus.chat.job.impl.page.g0.a;
        if (com.larus.chat.job.impl.page.g0.b(((f0) this._uiState.getValue()).r) == true) goto L5;
        return;
    L5:
        String r1 = this.jobId;
        if (r1 != null) goto L8;
        return;
    L8:
        if ((!StringsKt.isBlank(r1)) == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L16;
        String r3 = r1;
        r9.invoke(r1, new f(this, r3, ((f0) this._uiState.getValue()).r, this.userEditVersion));
        return;
    }

    private static final f0 openFrequencyPage$lambda$10(f0 r20) {
        Intrinsics.checkNotNullParameter(r20, "state");
        String r1 = r20.c;
        if (Intrinsics.areEqual(r1, a.c(Companion)) == false) goto L6;
        return f0.a(r20, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, false, false, new d0.b(r20.e), 0, 196607);
    L6:
        if (Intrinsics.areEqual(r1, gz8.f.c()) == true) goto L8;
        return r20;
    L8:
        return f0.a(r20, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, false, false, new d0.a(r20.f, false), 0, 196607);
    }

    private static final f0 saveDraft$lambda$21(f0 r20) {
        Intrinsics.checkNotNullParameter(r20, "it");
        return f0.a(r20, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, false, false, new d0.a(r20.f, false), 0, 196607);
    }

    private static final f0 saveDraft$lambda$22(f0 r20) {
        Intrinsics.checkNotNullParameter(r20, "it");
        return f0.a(r20, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, false, true, null, 0, 229375);
    }

    private static final Unit saveDraft$lambda$26(ChatJobEditViewModel r4) {
        updateState$default(r4, false, new d1(), 1, null);
        return Unit.INSTANCE;
    }

    private static final f0 saveDraft$lambda$26$lambda$25(f0 r20) {
        Intrinsics.checkNotNullParameter(r20, "it");
        return f0.a(r20, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, false, false, null, 0, 229375);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final AIJobScheduleConfig scheduleConfig(f0 r11) {
        String r0 = r11.c;
        Companion.getClass();
        if (Intrinsics.areEqual(r0, gz8.f.f()) == false) goto L6;
        Integer r2 = Integer.valueOf(toRepeatType(r11.c));
        int r1 = com.larus.chat.job.impl.page.edit.b.a;
        return new AIJobScheduleConfig(r2, com.larus.chat.job.impl.page.edit.b.c(r11.h, r11.i), null, null, null, null, 60, null);
    L6:
        Integer r3 = Integer.valueOf(toRepeatType(r11.c));
        if (Intrinsics.areEqual(r11.c, gz8.f.f()) == false) goto L9;
        int r4 = com.larus.chat.job.impl.page.edit.b.a;
        String r5 = com.larus.chat.job.impl.page.edit.b.c(r11.h, r11.i);
    L10:
        String r6 = r11.c;
        if (Intrinsics.areEqual(r6, gz8.f.c()) == false) goto L14;
        AIJobScheduleTime r7 = null;
    L19:
        if (Intrinsics.areEqual(r11.c, gz8.f.g()) == false) goto L24;
        Set<ChatJobEditWeekday> r8 = r11.e;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r10 = r8.iterator();
    L22:
        if (r10.hasNext() == false) goto L26;
        r9.add(Integer.valueOf(toProtocolWeekday((ChatJobEditWeekday) r10.next())));
    L26:
        if (Intrinsics.areEqual(r11.c, a.b(Companion)) == false) goto L28;
        String r12 = customSchedulePrompt(r11);
    L29:
        String r13 = r11.c;
        if (Intrinsics.areEqual(r13, gz8.f.e()) == false) goto L33;
        int r14 = b0.a;
        int r15 = r11.i.b;
        gz8.d.a.getClass();
        String r16 = gz8.d.d(r15);
    L42:
        String r17 = r16;
    L44:
        return new AIJobScheduleConfig(r3, r5, r7, r9, r12, r17);
    L33:
        if (Intrinsics.areEqual(r13, gz8.f.g()) == false) goto L36;
        int r18 = b0.a;
        r16 = b0.a(r11.e);
        goto L42
    L36:
        if (Intrinsics.areEqual(r13, gz8.f.c()) == false) goto L41;
        String r19 = r11.d;
        if (StringsKt.isBlank(r19) == false) goto L40;
        r19 = r11.f;
    L40:
        r17 = r19;
        goto L44
    L41:
        r16 = r11.c;
        goto L42
    L28:
        r12 = null;
        goto L29
    L24:
        r9 = CollectionsKt.emptyList();
        goto L26
    L14:
        if (Intrinsics.areEqual(r6, gz8.f.e()) == false) goto L16;
        AIJobScheduleTime r20 = new AIJobScheduleTime(null, Integer.valueOf(r11.i.b), 1, null);
    L17:
        r7 = r20;
        goto L19
    L16:
        r20 = new AIJobScheduleTime(Integer.valueOf(r11.i.a), Integer.valueOf(r11.i.b));
        goto L17
    L9:
        r5 = null;
        goto L10
    }

    private final f0 toAuthoritativeEditState(AIJob r39) {
        int r1 = com.larus.chat.job.impl.page.edit.a.a;
        f0 r2 = a.a(Companion);
        Map<String, String> r3 = this.taskReplyModelDisplayNames;
        Intrinsics.checkNotNullParameter(r39, "job");
        Intrinsics.checkNotNullParameter(r2, "defaultState");
        Intrinsics.checkNotNullParameter(r3, "taskReplyModelDisplayNames");
        String r4 = com.larus.chat.job.impl.page.edit.a.a(r39.getContent());
        if (r4 == null) goto L5;
        JSONObject r5 = com.larus.chat.job.impl.page.edit.a.e(r4);
    L6:
        JSONObject r6 = com.larus.chat.job.impl.page.edit.a.e(r39.getContent());
        if (r6 == null) goto L9;
        int r7 = com.larus.chat.job.impl.page.g0.a;
        JSONObject r8 = r6.optJSONObject(com.larus.chat.job.impl.page.g0.a(r39.getJobType()));
    L10:
        char r12 = 0;
        char r11 = 1;
        List r9 = CollectionsKt.listOf(new JSONObject[]{r5, r8, r6, com.larus.chat.job.impl.page.edit.a.e(r39.getExt())});
        List r10 = CollectionsKt.createListBuilder();
        List r13 = r9;
        Iterator r14 = r13.iterator();
    L11:
        boolean r15 = r14.hasNext();
        int r16 = com.larus.chat.job.impl.page.edit.a.a;
        if (r15 == false) goto L57;
        JSONObject r17 = (JSONObject) r14.next();
        if (r17 == null) goto L53;
        JSONObject r18 = r17.optJSONObject("chat_query_option");
        String[] r19 = new String[8];
        r19[r12] = r17.optString("model_item_key");
        JSONObject r20 = r17.optJSONObject("model_config");
        if (r20 == null) goto L19;
        String r21 = r20.optString("model_item_key");
    L20:
        r19[r11] = r21;
        JSONObject r110 = r17.optJSONObject("conversation_init_ext");
        if (r110 == null) goto L23;
        String r111 = r110.optString("model_item_key");
    L24:
        r19[2] = r111;
        JSONObject r22 = r17.optJSONObject("aggregate_params");
        if (r22 == null) goto L27;
        String r23 = r22.optString("model_item_key");
    L28:
        r19[3] = r23;
        if (r18 == null) goto L31;
        String r24 = r18.optString("model_item_key");
    L32:
        r19[4] = r24;
        if (r18 == null) goto L37;
        JSONObject r25 = r18.optJSONObject("model_config");
        if (r25 == null) goto L37;
        String r26 = r25.optString("model_item_key");
    L38:
        r19[5] = r26;
        if (r18 == null) goto L43;
        JSONObject r27 = r18.optJSONObject("conversation_init_ext");
        if (r27 == null) goto L43;
        String r28 = r27.optString("model_item_key");
    L44:
        r19[6] = r28;
        if (r18 == null) goto L49;
        JSONObject r29 = r18.optJSONObject("aggregate_params");
        if (r29 == null) goto L49;
        String r30 = r29.optString("model_item_key");
    L50:
        r19[7] = r30;
        String r31 = com.larus.chat.job.impl.page.edit.a.b(r19);
        if ((!StringsKt.isBlank(r31)) == false) goto L53;
    L54:
        if (r31 == null) goto L56;
        r10.add(r31);
    L56:
        r11 = 1;
        r12 = 0;
    L49:
        r30 = null;
    L43:
        r28 = null;
    L37:
        r26 = null;
        goto L38
    L31:
        r24 = null;
        goto L32
    L27:
        r23 = null;
        goto L28
    L23:
        r111 = null;
        goto L24
    L19:
        r21 = null;
    L53:
        r31 = null;
        goto L54
    L57:
        List r32 = r10;
        Iterator r33 = r13.iterator();
    L59:
        if (r33.hasNext() == false) goto L75;
        JSONObject r34 = (JSONObject) r33.next();
        if (r34 == null) goto L68;
        Integer r35 = com.larus.chat.job.impl.page.edit.a.d(r34, "deep_think_switch");
        if (r35 == null) goto L68;
        String r36 = r35.toString();
        if (r36 == null) goto L68;
        String r37 = r36;
    L73:
        if (r37 == null) goto L59;
        r32.add(r37);
    L68:
        if (r34 == null) goto L72;
        Integer r38 = com.larus.chat.job.impl.page.edit.a.d(r34, "need_deep_think");
        if (r38 == null) goto L72;
        r37 = r38.toString();
    L72:
        r37 = null;
        goto L73
    L75:
        List<String> r112 = CollectionsKt.distinct(CollectionsKt.build(r10));
        String r40 = com.larus.chat.job.impl.page.edit.a.a(r39.getContent());
        if (r40 == null) goto L78;
        JSONObject r41 = com.larus.chat.job.impl.page.edit.a.e(r40);
    L79:
        JSONObject r42 = com.larus.chat.job.impl.page.edit.a.e(r39.getContent());
        if (r42 == null) goto L82;
        int r43 = com.larus.chat.job.impl.page.g0.a;
        JSONObject r44 = r42.optJSONObject(com.larus.chat.job.impl.page.g0.a(r39.getJobType()));
    L83:
        JSONObject r45 = com.larus.chat.job.impl.page.edit.a.e(r39.getExt());
        String[] r46 = new String[8];
        if (r41 == null) goto L86;
        String r47 = r41.optString("model_display_name");
    L87:
        r46[0] = r47;
        if (r44 == null) goto L90;
        String r48 = r44.optString("model_display_name");
    L91:
        r46[1] = r48;
        if (r44 == null) goto L94;
        String r49 = r44.optString("model_name");
    L95:
        r46[2] = r49;
        if (r42 == null) goto L98;
        String r50 = r42.optString("model_display_name");
    L99:
        r46[3] = r50;
        if (r42 == null) goto L102;
        String r51 = r42.optString("model_name");
    L103:
        r46[4] = r51;
        if (r45 == null) goto L106;
        String r52 = r45.optString("model_display_name");
    L107:
        r46[5] = r52;
        if (r45 == null) goto L110;
        String r53 = r45.optString("model_name");
    L111:
        r46[6] = r53;
        r46[7] = r2.k;
        String r113 = com.larus.chat.job.impl.page.edit.a.b(r46);
        String r54 = com.larus.chat.job.impl.page.edit.a.a(r39.getContent());
        if (r54 == null) goto L114;
        JSONObject r55 = com.larus.chat.job.impl.page.edit.a.e(r54);
    L115:
        JSONObject r56 = com.larus.chat.job.impl.page.edit.a.e(r39.getContent());
        if (r55 == null) goto L118;
        JSONObject r57 = r55.optJSONObject("display");
    L119:
        if (r56 == null) goto L121;
        int r58 = com.larus.chat.job.impl.page.g0.a;
        JSONObject r59 = r56.optJSONObject(com.larus.chat.job.impl.page.g0.a(r39.getJobType()));
    L122:
        JSONObject r60 = com.larus.chat.job.impl.page.edit.a.e(r39.getExt());
        if (r55 == null) goto L126;
        JSONObject r61 = r55.optJSONObject("runtime_config");
        if (r61 == null) goto L126;
    L134:
        if (r39.getJobType() != 3) goto L137;
    L163:
        JSONObject r62 = null;
    L167:
        if (r62 == null) goto L169;
        JSONObject r114 = r62.optJSONObject("time");
    L171:
        if (r114 == null) goto L179;
        String r210 = "runtime_config";
        Integer r115 = com.larus.chat.job.impl.page.edit.a.d(r114, "hour");
        if (r115 == null) goto L180;
        int r116 = r115.intValue();
        Integer r117 = com.larus.chat.job.impl.page.edit.a.d(r114, "minute");
        if (r117 == null) goto L177;
        int r118 = r117.intValue();
    L178:
        e0 r119 = new e0(RangesKt.coerceIn(r116, 0, 23), RangesKt.coerceIn(r118, 0, 59));
    L182:
        if (r119 != null) goto L257;
        String[] r120 = new String[3];
        if (r59 == null) goto L186;
        String r211 = r59.optString("display_time");
        char r212 = 0;
    L187:
        r120[r212] = r211;
        if (r56 == null) goto L190;
        String r213 = r56.optString("display_time");
        char r214 = 1;
    L191:
        r120[r214] = r213;
        if (r60 == null) goto L194;
        String r121 = r60.optString("display_time");
        int r63 = 2;
    L195:
        r120[r63] = r121;
        String r122 = com.larus.chat.job.impl.page.edit.a.b(r120);
        JSONObject r215 = r57;
        Map<String, String> r310 = r3;
        MatchResult r123 = Regex.find$default(new Regex("(\\d{1,2})[:：](\\d{1,2})"), r122, 0, r63, null);
        if (r123 == null) goto L242;
        Integer r64 = StringsKt.toIntOrNull((String) ListProtector.get(r123.getGroupValues(), 1));
        if (r64 == null) goto L242;
        int r65 = r64.intValue();
        Integer r66 = StringsKt.toIntOrNull((String) ListProtector.get(r123.getGroupValues(), r63));
        if (r66 == null) goto L242;
        int r67 = r66.intValue();
        gz8.d r68 = gz8.d.a;
        Locale r124 = Locale.getDefault();
        r68.getClass();
        Intrinsics.checkNotNullParameter(r122, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r124, "locale");
        List r69 = CollectionsKt.listOf(new Locale[]{r124, Locale.CHINA});
        ArrayList r125 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r69, 10));
        Iterator r70 = r69.iterator();
    L204:
        if (r70.hasNext() == false) goto L206;
        r125.add(gz8.d.b((Locale) r70.next()));
        goto L204
    L206:
        Iterator r71 = r125.iterator();
    L208:
        if (r71.hasNext() == false) goto L226;
        List r126 = (List) r71.next();
        String r127 = (String) ListProtector.get(r126, 0);
        Iterator r311 = r71;
        int r72 = 1;
        if ((!StringsKt.isBlank(r127)) == true) goto L212;
    L214:
        boolean r128 = false;
    L215:
        if (r128 == true) goto L216;
        String r129 = (String) ListProtector.get(r126, 1);
        if ((!StringsKt.isBlank(r129)) == true) goto L220;
    L222:
        boolean r130 = false;
    L223:
        if (r130 == true) goto L224;
        r71 = r311;
        goto L208
    L224:
        Integer r131 = 1;
    L227:
        if (r131 == null) goto L235;
        if (r131.intValue() != r72) goto L235;
        if (r65 >= 12) goto L241;
        r65 = r65 + 12;
    L241:
        e0 r73 = new e0(RangesKt.coerceIn(r65, 0, 23), RangesKt.coerceIn(r67, 0, 59));
    L243:
        if (r73 != null) goto L258;
        if (r62 == null) goto L254;
        String r74 = r62.optString("execute_at");
        Intrinsics.checkNotNull(r74);
        if ((!StringsKt.isBlank(r74)) == true) goto L249;
        r74 = null;
    L249:
        if (r74 == null) goto L254;
        int r75 = com.larus.chat.job.impl.page.edit.b.a;
        Intrinsics.checkNotNullParameter(r74, "raw");
        gz8.d.a.getClass();
        Long r76 = gz8.d.f(r74);
        if (r76 == null) goto L254;
        long r132 = r76.longValue();
        Calendar r77 = Calendar.getInstance(Locale.getDefault());
        r77.setTimeInMillis(r132);
        r73 = new e0(RangesKt.coerceIn(r77.get(11), 0, 23), RangesKt.coerceIn(r77.get(12), 0, 59));
    L255:
        if (r73 != null) goto L258;
        r73 = r2.i;
    L254:
        r73 = null;
    L258:
        String[] r78 = new String[4];
        if (r62 == null) goto L261;
        String r133 = r62.optString("display_frequency");
    L262:
        r78[0] = r133;
        if (r59 == null) goto L265;
        String r134 = r59.optString("display_frequency");
    L266:
        r78[1] = r134;
        if (r56 == null) goto L269;
        String r135 = r56.optString("display_frequency");
    L270:
        r78[2] = r135;
        if (r60 == null) goto L273;
        String r79 = r60.optString("display_frequency");
    L274:
        r78[3] = r79;
        String r80 = com.larus.chat.job.impl.page.edit.a.b(r78);
        if (r39.getJobType() != 3) goto L277;
        String r81 = "";
        String r312 = r81;
    L325:
        if (Intrinsics.areEqual(r81, gz8.f.e()) == false) goto L348;
        if (r119 != null) goto L348;
        if (r62 == null) goto L329;
        JSONObject r136 = r62.optJSONObject("time");
    L330:
        if (r136 == null) goto L334;
        Integer r82 = com.larus.chat.job.impl.page.edit.a.d(r136, "minute");
        if (r82 == null) goto L334;
        int r137 = 0;
        Integer r83 = Integer.valueOf(RangesKt.coerceIn(r82.intValue(), 0, 59));
    L335:
        if (r83 != null) goto L345;
        JSONArray r138 = null;
        MatchResult r84 = Regex.find$default(new Regex("第\\s*(\\d{1,2})\\s*分钟"), r80, r137, 2, null);
        if (r84 != null) goto L341;
        r84 = Regex.find$default(new Regex("(\\d{1,2})\\s*分钟"), r80, r137, 2, null);
        if (r84 != null) goto L341;
    L344:
        r83 = null;
    L346:
        if (r83 == null) goto L349;
        e0 r139 = new e0(r73.a, r83.intValue());
    L350:
        if (r62 == null) goto L352;
        JSONArray r85 = r62.optJSONArray("weekdays");
    L353:
        Set<ChatJobEditWeekday> r86 = r2.e;
        if (r85 != null) goto L356;
    L405:
        Set<ChatJobEditWeekday> r87 = r86;
        Iterator r88 = r112.iterator();
    L407:
        if (r88.hasNext() == false) goto L417;
        Map<String, String> r140 = r310;
        String r141 = r140.get((String) r88.next());
        if (r141 != null) goto L411;
    L413:
        r141 = null;
    L414:
        if (r141 != null) goto L415;
        r310 = r140;
        goto L407
    L415:
        int r89 = 5;
    L418:
        String[] r142 = new String[r89];
        if (r215 == null) goto L421;
        JSONObject r143 = r215;
        String r144 = r143.optString(TRACKING_FIELD_TITLE);
    L422:
        r142[0] = r144;
        if (r59 == null) goto L425;
        String r145 = r59.optString(TRACKING_FIELD_TITLE);
    L426:
        r142[1] = r145;
        if (r56 == null) goto L429;
        String r146 = r56.optString(TRACKING_FIELD_TITLE);
    L430:
        r142[2] = r146;
        if (r60 == null) goto L433;
        String r90 = r60.optString(TRACKING_FIELD_TITLE);
    L434:
        r142[3] = r90;
        r142[4] = r39.getJobId();
        String r91 = com.larus.chat.job.impl.page.edit.a.b(r142);
        String[] r147 = new String[7];
        if (r143 == null) goto L437;
        String r148 = r143.optString("summary");
    L438:
        r147[0] = r148;
        if (r59 == null) goto L441;
        String r149 = r59.optString(TRACKING_FIELD_PROMPT);
    L442:
        r147[1] = r149;
        if (r59 == null) goto L445;
        String r150 = r59.optString("instruction");
    L446:
        r147[2] = r150;
        if (r56 == null) goto L449;
        String r151 = r56.optString(TRACKING_FIELD_PROMPT);
    L450:
        r147[3] = r151;
        if (r56 == null) goto L453;
        String r152 = r56.optString("instruction");
    L454:
        r147[4] = r152;
        if (r60 == null) goto L457;
        String r153 = r60.optString(TRACKING_FIELD_PROMPT);
    L458:
        r147[5] = r153;
        if (r60 == null) goto L461;
        String r154 = r60.optString("instruction");
    L462:
        r147[6] = r154;
        String r155 = com.larus.chat.job.impl.page.edit.a.b(r147);
        if (Intrinsics.areEqual(r81, gz8.f.g()) == false) goto L466;
        String r156 = b0.a(r87);
    L469:
        String[] r92 = new String[1];
        if (r62 == null) goto L472;
        String r157 = r62.optString("custom_schedule_prompt");
    L473:
        r92[0] = r157;
        String r216 = com.larus.chat.job.impl.page.edit.a.b(r92);
        if (Intrinsics.areEqual(r81, gz8.f.c()) == false) goto L476;
        String r217 = r80;
    L477:
        if (r62 == null) goto L491;
        String r93 = r62.optString("execute_at");
        Intrinsics.checkNotNull(r93);
        if ((!StringsKt.isBlank(r93)) == true) goto L482;
        r93 = null;
    L482:
        if (r93 == null) goto L487;
        int r94 = com.larus.chat.job.impl.page.edit.b.a;
        Intrinsics.checkNotNullParameter(r93, "raw");
        gz8.d.a.getClass();
        Long r0 = gz8.d.f(r93);
        if (r0 == null) goto L487;
        long r95 = r0.longValue();
        Calendar r96 = Calendar.getInstance(Locale.getDefault());
        r96.setTimeInMillis(r95);
        com.larus.chat.job.impl.page.edit.h r97 = com.larus.chat.job.impl.page.edit.b.a(r96.get(1), r96.get(2) + 1, r96.get(5));
    L488:
        if (r97 == null) goto L492;
        com.larus.chat.job.impl.page.edit.h r98 = r97;
    L493:
        gz8.d r99 = gz8.d.a;
        int r100 = r139.a;
        int r101 = r139.b;
        r99.getClass();
        String r102 = gz8.d.c(r100, r101);
        if (r141 != null) goto L496;
        String r313 = r113;
    L497:
        String[] r103 = new String[6];
        if (r61 == null) goto L500;
        JSONObject r158 = r61;
        String r159 = r158.optString("display_name");
    L501:
        r103[0] = r159;
        if (r158 == null) goto L504;
        Integer r160 = com.larus.chat.job.impl.page.edit.a.d(r158, "runtime_type");
    L505:
        if (r160 != null) goto L507;
        String r218 = r102;
        String r161 = "runtime_type";
    L511:
        if (r160 != null) goto L514;
    L516:
        String r104 = r312;
    L517:
        r103[1] = r104;
        if (r59 == null) goto L522;
        JSONObject r162 = r59.optJSONObject(SECTION_RUNTIME);
        if (r162 == null) goto L522;
        String r163 = r162.optString("display_name");
    L523:
        r103[2] = r163;
        if (r56 == null) goto L528;
        JSONObject r164 = r56.optJSONObject(SECTION_RUNTIME);
        if (r164 == null) goto L528;
        String r165 = r164.optString("display_name");
    L529:
        r103[3] = r165;
        if (r60 == null) goto L534;
        JSONObject r166 = r60.optJSONObject(SECTION_RUNTIME);
        if (r166 == null) goto L534;
        String r105 = r166.optString("display_name");
    L535:
        r103[4] = r105;
        r103[5] = r2.l;
        String r314 = com.larus.chat.job.impl.page.edit.a.b(r103);
        String[] r106 = new String[5];
        if (r158 != null) goto L538;
        String r107 = r312;
    L555:
        r106[0] = r107;
        if (r59 == null) goto L560;
        JSONObject r108 = r59.optJSONObject("project");
        if (r108 == null) goto L560;
        String r109 = r108.optString("name");
    L561:
        r106[1] = r109;
        if (r56 == null) goto L566;
        JSONObject r167 = r56.optJSONObject("project");
        if (r167 == null) goto L566;
        String r168 = r167.optString("name");
    L567:
        r106[2] = r168;
        if (r60 == null) goto L572;
        JSONObject r169 = r60.optJSONObject("project");
        if (r169 == null) goto L572;
        String r170 = r169.optString("name");
    L573:
        r106[3] = r170;
        r106[4] = r2.m;
        String r171 = r161;
        String r172 = r210;
        String r315 = r113;
        List<String> r316 = r112;
        f0 r173 = f0.a(r2, r91, r155, r81, r156, r87, r216, r217, r98, r139, r218, r313, r314, com.larus.chat.job.impl.page.edit.a.b(r106), r39.getStatus(), false, false, null, r39.getJobType(), 114688);
        String r174 = com.larus.chat.job.impl.page.edit.a.a(r39.getContent());
        if (r174 == null) goto L576;
        JSONObject r175 = com.larus.chat.job.impl.page.edit.a.e(r174);
    L577:
        JSONObject r176 = com.larus.chat.job.impl.page.edit.a.e(r39.getContent());
        if (r176 == null) goto L580;
        int r177 = com.larus.chat.job.impl.page.g0.a;
        JSONObject r178 = r176.optJSONObject(com.larus.chat.job.impl.page.g0.a(r39.getJobType()));
    L581:
        JSONObject r179 = com.larus.chat.job.impl.page.edit.a.e(r39.getExt());
        if (r175 == null) goto L585;
        JSONObject r180 = r175.optJSONObject(r172);
        if (r180 == null) goto L585;
    L604:
        if (r180 == null) goto L606;
        Integer r181 = com.larus.chat.job.impl.page.edit.a.d(r180, r171);
    L607:
        if (r181 != null) goto L610;
    L612:
        if (r181 != null) goto L615;
    L617:
        String r182 = null;
    L618:
        Intrinsics.checkNotNullParameter(r173, "state");
        Intrinsics.checkNotNullParameter(r316, "taskReplyModelKeys");
        Intrinsics.checkNotNullParameter(r315, "taskReplyModelFallbackName");
        this.trackingRunEnvironment = r182;
        this.taskReplyModelKeys = r316;
        this.taskReplyModelFallbackName = r315;
        return asOriginalSnapshot$default(this, r173, 0, 1, null);
    L615:
        if (r181.intValue() != 2) goto L617;
        r182 = "local_pc";
        goto L618
    L610:
        if (r181.intValue() != 1) goto L612;
        r182 = "cloud";
        goto L618
    L606:
        r181 = null;
    L585:
        if (r178 == null) goto L587;
        r180 = r178.optJSONObject(r172);
    L588:
        if (r180 != null) goto L604;
        if (r176 == null) goto L591;
        r180 = r176.optJSONObject(r172);
    L592:
        if (r180 != null) goto L604;
        if (r178 == null) goto L595;
        String r183 = SECTION_RUNTIME;
        r180 = r178.optJSONObject(r183);
    L596:
        if (r180 != null) goto L604;
        if (r176 == null) goto L599;
        r180 = r176.optJSONObject(r183);
    L600:
        if (r180 != null) goto L604;
        if (r179 == null) goto L603;
        r180 = r179.optJSONObject(r183);
        goto L604
    L603:
        r180 = null;
        goto L604
    L599:
        r180 = null;
        goto L600
    L595:
        r183 = r1;
        r180 = null;
        goto L596
    L591:
        r180 = null;
        goto L592
    L587:
        r180 = null;
        goto L588
    L580:
        r178 = null;
        goto L581
    L576:
        r175 = null;
    L572:
        r170 = null;
    L566:
        r168 = null;
    L560:
        r109 = null;
        goto L561
    L538:
        String[] r184 = new String[4];
        JSONArray r185 = r158.optJSONArray("project");
        if (r185 == null) goto L541;
        String r186 = com.larus.chat.job.impl.page.edit.a.c(r185);
    L542:
        r184[0] = r186;
        JSONArray r187 = r158.optJSONArray("projects");
        if (r187 == null) goto L545;
        String r188 = com.larus.chat.job.impl.page.edit.a.c(r187);
    L546:
        r184[1] = r188;
        String r189 = r158.optString("project");
        if ((r158.opt("project") instanceof JSONArray) == true) goto L549;
        char r190 = 2;
    L550:
        r184[r190] = r189;
        String r191 = r158.optString("projects");
        if ((r158.opt("projects") instanceof JSONArray) == false) goto L554;
        r191 = null;
    L554:
        r184[3] = r191;
        r107 = com.larus.chat.job.impl.page.edit.a.b(r184);
        goto L555
    L549:
        r190 = 2;
        r189 = null;
        goto L550
    L545:
        r188 = null;
        goto L546
    L541:
        r186 = null;
    L534:
        r105 = null;
    L528:
        r165 = null;
    L522:
        r163 = null;
        goto L523
    L514:
        if (r160.intValue() != 2) goto L516;
        r104 = gz8.f.b("scheduledTasks_newTask_setting_environment_local");
        goto L517
    L507:
        r161 = "runtime_type";
        r218 = r102;
        if (r160.intValue() != 1) goto L511;
        r104 = gz8.f.b("scheduledTasks_newTask_setting_environment_cloud");
        goto L517
    L504:
        r160 = null;
        goto L505
    L500:
        r158 = r61;
        r159 = null;
        goto L501
    L496:
        r313 = r141;
    L492:
        r98 = r2.h;
    L487:
        r97 = null;
        goto L488
    L491:
        r87 = r87;
        goto L492
    L476:
        r217 = r312;
        goto L477
    L472:
        r157 = null;
        goto L473
    L466:
        if (Intrinsics.areEqual(r81, gz8.f.c()) == false) goto L468;
        r156 = r80;
        goto L469
    L468:
        r156 = r312;
        goto L469
    L461:
        r154 = null;
        goto L462
    L457:
        r153 = null;
        goto L458
    L453:
        r152 = null;
        goto L454
    L449:
        r151 = null;
        goto L450
    L445:
        r150 = null;
        goto L446
    L441:
        r149 = null;
        goto L442
    L437:
        r148 = null;
        goto L438
    L433:
        r90 = null;
        goto L434
    L429:
        r146 = null;
        goto L430
    L425:
        r145 = null;
        goto L426
    L421:
        r143 = r215;
        r144 = null;
        goto L422
    L411:
        if ((!StringsKt.isBlank(r141)) == false) goto L413;
    L417:
        r89 = 5;
        r141 = null;
        goto L418
    L356:
        if (r85.length() == 0) goto L405;
        Set r192 = SetsKt.createSetBuilder();
        int r193 = r85.length();
        int r194 = 0;
    L359:
        if (r194 >= r193) goto L400;
        int r219 = r85.optInt(r194);
        gz8.d.a.getClass();
        Integer r220 = gz8.d.e(r219);
        if (r220 != null) goto L363;
        JSONArray r221 = r85;
    L366:
        if (r220 != null) goto L369;
    L371:
        if (r220 != null) goto L374;
    L376:
        if (r220 != null) goto L379;
    L381:
        if (r220 != null) goto L384;
    L386:
        if (r220 != null) goto L389;
    L391:
        if (r220 != null) goto L394;
    L396:
        ChatJobEditWeekday r195 = null;
    L397:
        if (r195 == null) goto L399;
        r192.add(r195);
    L399:
        r194 = r194 + 1;
        r85 = r221;
        goto L359
    L394:
        if (r220.intValue() != 7) goto L396;
        r195 = ChatJobEditWeekday.SUNDAY;
        goto L397
    L389:
        if (r220.intValue() != 6) goto L391;
        r195 = ChatJobEditWeekday.SATURDAY;
        goto L397
    L384:
        if (r220.intValue() != 5) goto L386;
        r195 = ChatJobEditWeekday.FRIDAY;
        goto L397
    L379:
        if (r220.intValue() != 4) goto L381;
        r195 = ChatJobEditWeekday.THURSDAY;
        goto L397
    L374:
        if (r220.intValue() != 3) goto L376;
        r195 = ChatJobEditWeekday.WEDNESDAY;
        goto L397
    L369:
        if (r220.intValue() != 2) goto L371;
        r195 = ChatJobEditWeekday.TUESDAY;
        goto L397
    L363:
        r221 = r85;
        if (r220.intValue() != 1) goto L366;
        r195 = ChatJobEditWeekday.MONDAY;
        goto L397
    L400:
        Set<ChatJobEditWeekday> r196 = SetsKt.build(r192);
        if (r196.isEmpty() == true) goto L404;
        r86 = r196;
    L404:
        r86 = r86;
        goto L405
    L352:
        r85 = r138;
    L349:
        r139 = r73;
    L341:
        Integer r197 = StringsKt.toIntOrNull((String) ListProtector.get(r84.getGroupValues(), 1));
        if (r197 == null) goto L344;
        r83 = Integer.valueOf(RangesKt.coerceIn(r197.intValue(), r137, 59));
        goto L346
    L345:
        r138 = null;
    L334:
        r137 = 0;
        r83 = null;
        goto L335
    L329:
        r136 = null;
    L348:
        r138 = null;
        goto L349
    L277:
        gz8.d r198 = gz8.d.a;
        if (r62 == null) goto L282;
        Integer r199 = com.larus.chat.job.impl.page.edit.a.d(r62, "repeat_type");
        if (r199 == null) goto L282;
        int r1100 = r199.intValue();
    L283:
        if (r62 == null) goto L287;
        JSONArray r222 = r62.optJSONArray("weekdays");
        if (r222 == null) goto L287;
        int r223 = r222.length();
    L288:
        if (r223 <= 0) goto L290;
        boolean r224 = true;
    L291:
        r198.getClass();
        Intrinsics.checkNotNullParameter(r80, "displayFrequency");
        if (r1100 != 1) goto L294;
        r312 = "";
        r81 = gz8.f.f();
        goto L325
    L294:
        if (r1100 != 2) goto L296;
        r312 = "";
        r81 = gz8.f.e();
        goto L325
    L296:
        if (r1100 != 3) goto L298;
        r312 = "";
        r81 = gz8.f.d();
        goto L325
    L298:
        if (r1100 != 4) goto L300;
        r312 = "";
        r81 = gz8.f.g();
        goto L325
    L300:
        if (r1100 != 5) goto L302;
        r312 = "";
        r81 = gz8.f.c();
        goto L325
    L302:
        if (gz8.d.a(r80, new String[]{gz8.f.e(), "每小时"}) == false) goto L304;
        r81 = gz8.f.e();
        r312 = "";
        goto L325
    L304:
        r312 = "";
        if (gz8.d.a(r80, new String[]{gz8.f.d(), "每天", "每日"}) == false) goto L308;
        r81 = gz8.f.d();
        goto L325
    L308:
        if (gz8.d.a(r80, new String[]{gz8.f.g(), "每周"}) == true) goto L318;
        if (r224 == true) goto L318;
        if (gz8.d.a(r80, new String[]{gz8.f.f(), "永不", "一次"}) == false) goto L315;
        r81 = gz8.f.f();
        goto L325
    L315:
        if ((!StringsKt.isBlank(r80)) == false) goto L317;
        r81 = gz8.f.c();
        goto L325
    L317:
        r81 = gz8.f.d();
    L318:
        r81 = gz8.f.g();
        goto L325
    L290:
        r224 = false;
    L287:
        r223 = 0;
    L282:
        r1100 = 0;
        goto L283
    L273:
        r79 = null;
        goto L274
    L269:
        r135 = null;
        goto L270
    L265:
        r134 = null;
        goto L266
    L261:
        r133 = null;
    L235:
        if (r131 == null) goto L241;
        if (r131.intValue() != 0) goto L241;
        if (r65 != 12) goto L241;
        r65 = 0;
        goto L241
    L220:
        if (StringsKt.contains(r122, r129, true) == false) goto L222;
        r130 = true;
        goto L223
    L216:
        r131 = 0;
        goto L227
    L212:
        if (StringsKt.contains(r122, r127, true) == false) goto L214;
        r128 = true;
        goto L215
    L226:
        r72 = 1;
        r131 = null;
    L242:
        r73 = null;
        goto L243
    L194:
        r63 = 2;
        r121 = null;
        goto L195
    L190:
        r214 = 1;
        r213 = null;
        goto L191
    L186:
        r212 = 0;
        r211 = null;
        goto L187
    L257:
        r310 = r3;
        r215 = r57;
        r61 = r61;
        r112 = r112;
        r73 = r119;
        goto L258
    L177:
        r118 = 0;
    L180:
        r113 = r113;
        r119 = null;
        goto L182
    L179:
        r210 = "runtime_config";
        goto L180
    L169:
        r114 = null;
        goto L171
    L137:
        if (r55 == null) goto L140;
        r62 = r55.optJSONObject("schedule_config");
        if (r62 != null) goto L167;
    L140:
        if (r59 == null) goto L142;
        r62 = r59.optJSONObject("schedule_config");
    L143:
        if (r62 != null) goto L167;
        if (r59 == null) goto L147;
        JSONObject r225 = r59.optJSONObject(SECTION_SCHEDULE);
    L148:
        if (r225 != null) goto L165;
        if (r56 == null) goto L151;
        r225 = r56.optJSONObject("schedule_config");
    L152:
        if (r225 != null) goto L165;
        if (r56 == null) goto L155;
        r225 = r56.optJSONObject(SECTION_SCHEDULE);
    L156:
        if (r225 != null) goto L165;
        if (r60 == null) goto L159;
        JSONObject r1101 = r60.optJSONObject("schedule_config");
    L160:
        if (r1101 != null) goto L164;
        if (r60 == null) goto L163;
        r62 = r60.optJSONObject(SECTION_SCHEDULE);
        goto L167
    L164:
        r62 = r1101;
        goto L167
    L159:
        r1101 = null;
        goto L160
    L155:
        r225 = null;
        goto L156
    L151:
        r225 = null;
    L165:
        r62 = r225;
        goto L167
    L147:
        r225 = null;
        goto L148
    L142:
        r62 = null;
    L126:
        if (r59 == null) goto L128;
        r61 = r59.optJSONObject("runtime_config");
    L129:
        if (r61 != null) goto L134;
        if (r56 == null) goto L132;
        r61 = r56.optJSONObject("runtime_config");
        goto L134
    L132:
        r61 = null;
        goto L134
    L128:
        r61 = null;
        goto L129
    L121:
        r59 = null;
        goto L122
    L118:
        r57 = null;
        goto L119
    L114:
        r55 = null;
        goto L115
    L110:
        r53 = null;
        goto L111
    L106:
        r52 = null;
        goto L107
    L102:
        r51 = null;
        goto L103
    L98:
        r50 = null;
        goto L99
    L94:
        r49 = null;
        goto L95
    L90:
        r48 = null;
        goto L91
    L86:
        r47 = null;
        goto L87
    L82:
        r44 = null;
        goto L83
    L78:
        r41 = null;
        goto L79
    L9:
        r8 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    private final int toProtocolWeekday(ChatJobEditWeekday r2) {
        switch(c.b[r2.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        return 7;
    L7:
        return 6;
    L8:
        return 5;
    L9:
        return 4;
    L10:
        return 3;
    L11:
        return 2;
    L12:
        return 1;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    private final int toRepeatType(String r2) {
        gz8.d.a.getClass();
        Intrinsics.checkNotNullParameter(r2, TRACKING_FIELD_REPEAT);
        if (Intrinsics.areEqual(r2, gz8.f.f()) == false) goto L6;
        return 1;
    L6:
        if (Intrinsics.areEqual(r2, gz8.f.e()) == false) goto L9;
        return 2;
    L9:
        if (Intrinsics.areEqual(r2, gz8.f.d()) == false) goto L12;
    L17:
        return 3;
    L12:
        if (Intrinsics.areEqual(r2, gz8.f.g()) == false) goto L15;
        return 4;
    L15:
        if (Intrinsics.areEqual(r2, gz8.f.c()) == false) goto L17;
        return 5;
    }

    private final String trackingRepeatType(f0 r2) {
        if (r2.c() == true) goto L6;
        return null;
    L6:
        String r3 = r2.c;
        Companion.getClass();
        if (Intrinsics.areEqual(r3, gz8.f.f()) == false) goto L10;
        return TRACKING_REPEAT_NEVER;
    L10:
        if (Intrinsics.areEqual(r3, gz8.f.e()) == false) goto L13;
        return TRACKING_REPEAT_HOURLY;
    L13:
        if (Intrinsics.areEqual(r3, gz8.f.d()) == false) goto L16;
    L21:
        return TRACKING_REPEAT_DAILY;
    L16:
        if (Intrinsics.areEqual(r3, gz8.f.g()) == false) goto L19;
        return TRACKING_REPEAT_WEEKLY;
    L19:
        if (Intrinsics.areEqual(r3, gz8.f.c()) == false) goto L21;
        return TRACKING_REPEAT_CUSTOM;
    }

    public final void selectHourlyMinute(final int r2) {
        updateState(true, new m0(r2, this));
    }

    public final void selectRepeat(final String r2) {
        Intrinsics.checkNotNullParameter(r2, TRACKING_FIELD_REPEAT);
        if (((f0) this._uiState.getValue()).c() == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(((f0) this._uiState.getValue()).c, r2) == true) goto L8;
        invalidateParsedCustomSchedule();
    L8:
        updateState(true, new h0(r2));
    }

    public final void toggleWeekday(final ChatJobEditWeekday r4) {
        Intrinsics.checkNotNullParameter(r4, "weekday");
        updateState$default(this, false, new c1(r4), 1, null);
    }

    public final void updateCustomFrequencyInput(final String r6) {
        Intrinsics.checkNotNullParameter(r6, "input");
        d0 r0 = ((f0) this._uiState.getValue()).q;
        if ((r0 instanceof d0.a) == false) goto L5;
        d0.a r1 = (d0.a) r0;
    L6:
        if (r1 != null) goto L8;
    L10:
        updateState$default(this, false, new r0(r6), 1, null);
        return;
    L8:
        if (Intrinsics.areEqual(r1.a, r6) == true) goto L10;
        this.userEditVersion++;
        invalidateParsedCustomSchedule();
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final void updateTaskReplyModelDisplayNames(Map<String, String> r27) {
        Intrinsics.checkNotNullParameter(r27, "displayNames");
        this.taskReplyModelDisplayNames = r27;
        Iterator<T> r2 = this.taskReplyModelKeys.iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        final String r3 = r27.get((String) r2.next());
        if (r3 != null) goto L8;
    L10:
        r3 = null;
    L11:
        if (r3 == null) goto L4;
    L14:
        if (r3 != null) goto L22;
        String r1 = this.taskReplyModelFallbackName;
        if ((!StringsKt.isBlank(r1)) == false) goto L18;
        r3 = r1;
    L19:
        if (r3 != null) goto L22;
        return;
    L18:
        r3 = null;
    L22:
        if (Intrinsics.areEqual(((f0) this._uiState.getValue()).k, r3) == false) goto L24;
        return;
    L24:
        f0 r6 = this.originalSnapshot;
        if (r6 == null) goto L27;
        f0 r4 = f0.a(r6, null, null, null, null, null, null, null, null, null, null, r3, null, null, 0, false, false, null, 0, 261119);
    L28:
        this.originalSnapshot = r4;
        updateState$default(this, false, new p0(r3), 1, null);
        return;
    L27:
        r4 = null;
        goto L28
    L8:
        if ((!StringsKt.isBlank(r3)) == false) goto L10;
    L13:
        r3 = null;
        goto L14
    }

    public static final /* synthetic */ void access$applyJob(ChatJobEditViewModel r0, AIJob r1) {
        r0.applyJob(r1);
    }

    public static final /* synthetic */ void access$setCurrentConversationId$p(ChatJobEditViewModel r0, String r1) {
        r0.currentConversationId = r1;
    }

    public static final /* synthetic */ void access$setOriginalSnapshot$p(ChatJobEditViewModel r0, f0 r1) {
        r0.originalSnapshot = r1;
    }

    public static final /* synthetic */ void access$setParsedCustomSchedule$p(ChatJobEditViewModel r0, b r1) {
        r0.parsedCustomSchedule = r1;
    }

    public static final /* synthetic */ f0 access$toAuthoritativeEditState(ChatJobEditViewModel r0, AIJob r1) {
        return r0.toAuthoritativeEditState(r1);
    }

    private final f0 asOriginalSnapshot(f0 r21, int r22) {
        return f0.a(r21, null, null, null, null, null, null, null, null, null, null, null, null, null, r22, false, false, null, 0, 139263);
    }

    private static final f0 confirmCustomFrequency$lambda$39$lambda$38(d0.a r22, f0 r23) {
        Intrinsics.checkNotNullParameter(r23, "it");
        String r0 = r22.a;
        Intrinsics.checkNotNullParameter(r0, "input");
        return f0.a(r23, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, false, false, new d0.a(r0, false), 0, 196607);
    }

    private static final f0 confirmSubPage$lambda$15(d0 r20, f0 r21) {
        Intrinsics.checkNotNullParameter(r21, "it");
        Set<ChatJobEditWeekday> r1 = ((d0.b) r20).a;
        return f0.a(r21, null, null, null, b0.a(r1), r1, null, null, null, null, null, null, null, null, 0, false, false, null, 0, 196583);
    }

    private final List<String> editTrackingFields(f0 r4, f0 r5) {
        if (r5 == null) goto L4;
        List r0 = CollectionsKt.createListBuilder();
        if (Intrinsics.areEqual(r5.a, r4.a) == true) goto L9;
        r0.add(TRACKING_FIELD_TITLE);
    L9:
        if (Intrinsics.areEqual(r5.b, r4.b) == true) goto L12;
        r0.add(TRACKING_FIELD_PROMPT);
    L12:
        if (r4.c() == false) goto L17;
        if (sameScheduleContent(r4, r5) == true) goto L17;
        r0.add(TRACKING_FIELD_REPEAT);
    L17:
        return CollectionsKt.build(r0);
    L4:
        return CollectionsKt.emptyList();
    }

    private final boolean isCurrentJobCallback(String r5, String r6) {
        String r0 = this.jobId;
        if (Intrinsics.areEqual(r0, r5) == false) goto L6;
        return true;
    L6:
        FLogger.a.i(TAG, "skip stale " + r6 + " callback, callbackJobId=" + r5 + ", currentJobId=" + r0);
        return false;
    }

    private static final f0 load$lambda$1(int r20, f0 r21) {
        Intrinsics.checkNotNullParameter(r21, "it");
        return f0.a(r21, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, false, false, null, r20, 131071);
    }

    private final boolean matchesParsedCustomSchedule(f0 r3, b r4) {
        if (Intrinsics.areEqual(r3.c, a.b(Companion)) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(customSchedulePrompt(r3), r4.a) == false) goto L7;
        return true;
    }

    private final boolean samePatchContent(f0 r3, f0 r4) {
        if (r4 != null) goto L4;
    L14:
        return false;
    L4:
        if (r3.r != r4.r) goto L14;
        if (Intrinsics.areEqual(r3.a, r4.a) == false) goto L14;
        if (Intrinsics.areEqual(r3.b, r4.b) == false) goto L14;
        if (r3.c() == true) goto L12;
    L13:
        return true;
    L12:
        if (sameScheduleContent(r3, r4) == false) goto L14;
        goto L13
    }

    private final boolean sameScheduleContent(f0 r3, f0 r4) {
        if (r4 != null) goto L4;
    L14:
        return false;
    L4:
        if (Intrinsics.areEqual(r3.c, r4.c) == false) goto L14;
        if (Intrinsics.areEqual(r3.d, r4.d) == false) goto L14;
        if (Intrinsics.areEqual(r3.e, r4.e) == false) goto L14;
        if (Intrinsics.areEqual(r3.h, r4.h) == false) goto L14;
        if (Intrinsics.areEqual(r3.i, r4.i) == false) goto L14;
        return true;
    }

    private static final f0 selectRepeat$lambda$9(String r20, f0 r21) {
        Intrinsics.checkNotNullParameter(r21, "state");
        if (Intrinsics.areEqual(r20, a.c(Companion)) == false) goto L6;
        int r4 = b0.a;
        return f0.a(r21, null, null, r20, b0.a(r21.e), null, null, null, null, null, null, null, null, null, 0, false, false, null, 0, 262131);
    L6:
        if (Intrinsics.areEqual(r20, gz8.f.c()) == false) goto L9;
        return f0.a(r21, null, null, r20, r21.g, null, null, null, null, null, null, null, null, null, 0, false, false, null, 0, 262131);
    L9:
        return f0.a(r21, null, null, r20, "", null, null, null, null, null, null, null, null, null, 0, false, false, null, 0, 262131);
    }

    private static final f0 toggleWeekday$lambda$12(ChatJobEditWeekday r20, f0 r21) {
        Intrinsics.checkNotNullParameter(r21, "state");
        d0 r1 = r21.q;
        if ((r1 instanceof d0.b) == false) goto L5;
        d0.b r2 = (d0.b) r1;
    L6:
        if (r2 != null) goto L9;
        return r21;
    L9:
        if (r2.a.contains(r20) == false) goto L11;
        Set r0 = SetsKt.minus(r2.a, r20);
    L12:
        Intrinsics.checkNotNullParameter(r0, "selectedWeekdays");
        return f0.a(r21, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, false, false, new d0.b(r0), 0, 196607);
    L11:
        r0 = SetsKt.plus(r2.a, r20);
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    private static final f0 updateCustomFrequencyInput$lambda$14(String r21, f0 r22) {
        Intrinsics.checkNotNullParameter(r22, "state");
        d0 r1 = r22.q;
        if ((r1 instanceof d0.a) == false) goto L5;
        d0.a r2 = (d0.a) r1;
    L6:
        if (r2 != null) goto L8;
        return r22;
    L8:
        Intrinsics.checkNotNullParameter(r21, "input");
        return f0.a(r22, null, null, null, null, null, r21, null, null, null, null, null, null, null, 0, false, false, new d0.a(r21, false), 0, 196575);
    L5:
        r2 = null;
        goto L6
    }

    private final void updateState(boolean r24, Function1<? super f0, f0> r25) {
        f0 r1 = (f0) this._uiState.getValue();
        f0 r3 = (f0) r25.invoke(r1);
        if (r24 == true) goto L5;
    L7:
        f0 r2 = f0.a(r3, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, !samePatchContent(r3, this.originalSnapshot), false, null, 0, 245759);
        this._uiState.setValue(r2);
        this._listItems.setValue(buildListItems(r2));
        return;
    L5:
        if (samePatchContent(r3, r1) == true) goto L7;
        this.userEditVersion++;
        goto L7
    }

    private static final f0 updateTaskReplyModelDisplayNames$lambda$7(String r20, f0 r21) {
        Intrinsics.checkNotNullParameter(r21, "it");
        return f0.a(r21, null, null, null, null, null, null, null, null, null, null, r20, null, null, 0, false, false, null, 0, 261119);
    }

    public final void selectTime(final int r2, final int r3) {
        updateState(true, new b1(r2, r3, this));
    }

    public final void updateText(final ChatJobEditTextKey r2, final String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, ShareType.TEXT);
        updateState(true, new a1(r2, r3));
    }

    public static final /* synthetic */ boolean access$isCurrentJobCallback(ChatJobEditViewModel r0, String r1, String r2) {
        return r0.isCurrentJobCallback(r1, r2);
    }

    private static final f0 confirmCustomFrequency$lambda$34(String r21, d0.a r22, f0 r23) {
        Intrinsics.checkNotNullParameter(r23, "it");
        r22.getClass();
        Intrinsics.checkNotNullParameter(r21, "input");
        return f0.a(r23, null, null, null, null, null, r21, null, null, null, null, null, null, null, 0, false, false, new d0.a(r21, true), 0, 196575);
    }

    private static final Unit confirmCustomFrequency$lambda$37(ChatJobEditViewModel r3, final String r4, b r5) {
        Intrinsics.checkNotNullParameter(r5, "parsedSchedule");
        d0 r0 = ((f0) r3._uiState.getValue()).q;
        final String r2 = null;
        if ((r0 instanceof d0.a) == false) goto L5;
        d0.a r1 = (d0.a) r0;
    L6:
        if (r1 == null) goto L10;
        String r6 = r1.a;
        if (r6 == null) goto L10;
        String r7 = StringsKt.trim(r6).toString();
    L12:
        if (Intrinsics.areEqual(r7, r4) == false) goto L14;
        r3.parsedCustomSchedule = r5;
        String r8 = r5.b.getDisplayFrequency();
        if (r8 != null) goto L18;
    L22:
        r2 = r4;
    L23:
        r3.updateState(true, new q0(r2, r4));
        return Unit.INSTANCE;
    L18:
        if ((!StringsKt.isBlank(r8)) == false) goto L20;
        r2 = r8;
    L20:
        if (r2 == null) goto L22;
    L14:
        return Unit.INSTANCE;
    L10:
        r7 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    private static final f0 confirmCustomFrequency$lambda$37$lambda$36(String r20, String r21, f0 r22) {
        Intrinsics.checkNotNullParameter(r22, "it");
        return f0.a(r22, null, null, null, r20, null, r21, r20, null, null, null, null, null, null, 0, false, false, null, 0, 196503);
    }

    private static final Unit pauseJob$lambda$29(ChatJobEditViewModel r1, String r2, IIMCallback r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "callback");
        r1.getAiJobService().pauseJob(r2, ((f0) r1._uiState.getValue()).r, r3);
        return Unit.INSTANCE;
    }

    private static final Unit resumeJob$lambda$30(ChatJobEditViewModel r1, String r2, IIMCallback r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "callback");
        r1.getAiJobService().resumeJob(r2, ((f0) r1._uiState.getValue()).r, r3);
        return Unit.INSTANCE;
    }

    private static final f0 selectHourlyMinute$lambda$18(int r20, ChatJobEditViewModel r21, f0 r22) {
        Intrinsics.checkNotNullParameter(r22, "it");
        e0 r1 = r22.i;
        int r2 = RangesKt.coerceIn(r20, 0, 59);
        e0 r9 = new e0(r1.a, r2);
        return f0.a(r22, null, null, null, null, null, null, null, null, r9, r21.formatTime(r9), null, null, null, 0, false, false, null, 0, 261375);
    }

    private final AIJobUpdatePatch toPatch(f0 r20, f0 r21, b r22) {
        b r3 = r22;
        boolean r5 = true;
        if (r20.c() == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        String r7 = null;
        if (r3 == null) goto L17;
        if (r4 == true) goto L12;
    L14:
        boolean r8 = false;
    L15:
        if (r8 == false) goto L17;
    L18:
        String r9 = StringsKt.trim(r20.a).toString();
        if (r21 != null) goto L21;
    L24:
        boolean r10 = true;
    L25:
        if (r10 == true) goto L28;
        r9 = null;
    L28:
        String r11 = r20.b;
        if (r21 != null) goto L31;
    L34:
        if (r5 == true) goto L37;
        r11 = null;
    L37:
        if (r4 == false) goto L45;
        if (r3 == null) goto L41;
        AIJobScheduleConfig r2 = r3.b;
        if (r2 == null) goto L41;
    L42:
        AIJobScheduleConfig r12 = r2;
        if (r12.getRepeatType() != null) goto L46;
        r12 = AIJobScheduleConfig.copy$default(r12, Integer.valueOf(toRepeatType(r20.c)), null, null, null, null, null, 62, null);
    L46:
        if (r3 == null) goto L49;
        r7 = r3.c;
    L49:
        return new AIJobUpdatePatch(r9, r11, r12, r7);
    L41:
        r2 = scheduleConfig(r20);
        goto L42
    L45:
        r12 = null;
        goto L46
    L31:
        if (Intrinsics.areEqual(r11, r21.b) == false) goto L34;
        r5 = false;
        goto L34
    L21:
        if (Intrinsics.areEqual(r20.a, r21.a) == false) goto L24;
        r10 = false;
        goto L25
    L12:
        if (matchesParsedCustomSchedule(r20, r3) == false) goto L14;
        r8 = true;
    L17:
        r3 = null;
        goto L18
    L5:
        if (sameScheduleContent(r20, r21) == true) goto L7;
        r4 = true;
        goto L8
    }

    private static final f0 updateText$lambda$8(ChatJobEditTextKey r21, String r22, f0 r23) {
        Intrinsics.checkNotNullParameter(r23, "state");
        int r0 = c.a[r21.ordinal()];
        if (r0 == 1) goto L10;
        if (r0 != 2) goto L8;
        return f0.a(r23, null, r22, null, null, null, null, null, null, null, null, null, null, null, 0, false, false, null, 0, 262141);
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return f0.a(r23, r22, null, null, null, null, null, null, null, null, null, null, null, null, 0, false, false, null, 0, 262142);
    }

    public final void load(String r9, AIJob r10, final int r11) {
        if (r10 == null) goto L5;
        r11 = r10.getJobType();
    L5:
        if (com.larus.chat.job.impl.page.g0.b(r11) == true) goto L9;
        FLogger.a.i(TAG, "load skipped: unavailable task type=" + r11);
        gz8.h.a();
        return;
    L9:
        if (r9 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == false) goto L17;
        return;
    L17:
        if (Intrinsics.areEqual(this.jobId, r9) == true) goto L30;
        this.jobId = r9;
        updateState$default(this, false, new y0(r11), 1, null);
        this.currentConversationId = null;
        this.trackingRunEnvironment = null;
        this.taskReplyModelKeys = CollectionsKt.emptyList();
        this.taskReplyModelFallbackName = "";
        this.userEditVersion = 0;
        invalidateParsedCustomSchedule();
        if (r10 != null) goto L22;
    L27:
        getAiJobService().getJob(r9, r11, true, new e(this, r9, r11, this.userEditVersion));
        return;
    L22:
        if (Intrinsics.areEqual(r10.getJobId(), r9) == true) goto L25;
        r10 = null;
    L25:
        if (r10 == null) goto L27;
        FLogger.a.i(TAG, "apply initial job snapshot, jobId=" + r9);
        applyJob(r10);
        goto L27
    L30:
        return;
    L11:
        if (StringsKt.isBlank(r9) == true) goto L14;
        r2 = false;
        goto L15
    }

    public final void selectDate(final int r2, final int r3, final int r4) {
        updateState(true, new s0(r2, r3, r4));
    }

    private static final Unit confirmCustomFrequency$lambda$39(ChatJobEditViewModel r3, String r4, String r5, IIMError r6) {
        Intrinsics.checkNotNullParameter(r6, "error");
        d0 r0 = ((f0) r3._uiState.getValue()).q;
        if ((r0 instanceof d0.a) == false) goto L5;
        final d0.a r1 = (d0.a) r0;
    L6:
        if (r1 == null) goto L10;
        String r2 = r1.a;
        if (r2 == null) goto L10;
        String r7 = StringsKt.trim(r2).toString();
    L12:
        if (Intrinsics.areEqual(r7, r4) == false) goto L14;
        updateState$default(r3, false, new u0(r1), 1, null);
    L14:
        FLogger.a.e(TAG, "parse job schedule failed, jobId=" + r5 + ", code=" + r6.getCode() + ", tips=" + r6.getTips());
        gz8.h.b(r6);
        return Unit.INSTANCE;
    L10:
        r7 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    private static final f0 selectDate$lambda$16(int r21, int r22, int r23, f0 r24) {
        Intrinsics.checkNotNullParameter(r24, "it");
        com.larus.chat.job.impl.page.edit.h r0 = com.larus.chat.job.impl.page.edit.b.a(r21, r22, r23);
        boolean r9 = false;
        com.larus.chat.job.impl.page.edit.h r10 = com.larus.chat.job.impl.page.edit.b.b(0);
        Intrinsics.checkNotNullParameter(r0, "first");
        Intrinsics.checkNotNullParameter(r10, "second");
        int r11 = r0.a;
        int r12 = r10.a;
        if (r11 == r12) goto L6;
        if (r11 < r12) goto L12;
    L13:
        if (r9 == false) goto L15;
        com.larus.chat.job.impl.page.edit.h r13 = r10;
    L17:
        return f0.a(r24, null, null, null, null, null, null, null, r13, null, null, null, null, null, 0, false, false, null, 0, 262015);
    L15:
        r13 = r0;
    L12:
        r9 = true;
        goto L13
    L6:
        int r14 = r0.b;
        int r15 = r10.b;
        if (r14 == r15) goto L11;
        if (r14 >= r15) goto L13;
    L11:
        if (r0.c >= r10.c) goto L13;
        goto L12
    }

    private static final f0 selectTime$lambda$17(int r20, int r21, ChatJobEditViewModel r22, f0 r23) {
        Intrinsics.checkNotNullParameter(r23, "it");
        e0 r10 = new e0(r20, r21);
        return f0.a(r23, null, null, null, null, null, null, null, null, r10, r22.formatTime(r10), null, null, null, 0, false, false, null, 0, 261375);
    }

    public static f0 asOriginalSnapshot$default(ChatJobEditViewModel r0, f0 r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r2 = r1.n;
    L6:
        return r0.asOriginalSnapshot(r1, r2);
    }

    private final void handleSaveFailure(String r2, List<String> r3, String r4, IIMError r5, String r6) {
        ez8.a.a.getClass();
        ez8.a.h(r2, r3, r4, false);
        FLogger.a.e(TAG, r6 + " failed, jobId=" + r2 + ", code=" + r5.getCode() + ", tips=" + r5.getTips());
        updateState$default(this, false, new l0(), 1, null);
        gz8.h.b(r5);
    }

    private final void requestCustomScheduleParse(String r18, String r19, Function1<? super b, Unit> r20, Function1<? super IIMError, Unit> r21, Function0<Unit> r22) {
        if (((f0) this._uiState.getValue()).c() == true) goto L6;
        FLogger.a.i(TAG, "parse schedule skipped: event tasks have no schedule");
        r22.invoke();
        return;
    L6:
        this.parsedCustomSchedule = null;
        long r3 = this.customScheduleParseGeneration + 1;
        this.customScheduleParseGeneration = r3;
        getAiJobService().parseJobSchedule(new AIJobScheduleParseRequest(r19, r18, null, 4, null), new g(this, r18, r3, r22, r20, r19, r21));
    }

    private static final Unit saveDraft$lambda$24(ChatJobEditViewModel r7, String r8, List r9, String r10, IIMError r11) {
        Intrinsics.checkNotNullParameter(r11, "error");
        r7.handleSaveFailure(r8, r9, r10, r11, "parse job schedule");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void updateState$default(ChatJobEditViewModel r0, boolean r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.updateState(r1, r2);
    }

    public static /* synthetic */ void load$default(ChatJobEditViewModel r0, String r1, AIJob r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 1;
    L8:
        r0.load(r1, r2, r3);
    }

    private final void submitUpdate(String r14, f0 r15, f0 r16, long r17, List<String> r19, String r20, b r21) {
        getAiJobService().updateJob(r14, r15.r, toPatch(r15, r16, r21), new i(this, r14, r15, r19, r20, r17));
    }

    public static /* synthetic */ void handleSaveFailure$default(ChatJobEditViewModel r6, String r7, List r8, String r9, IIMError r10, String r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = "update job";
    L5:
        r6.handleSaveFailure(r7, r8, r9, r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void requestCustomScheduleParse$default(ChatJobEditViewModel r6, String r7, String r8, Function1 r9, Function1 r10, Function0 r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = new k0();
    L5:
        r6.requestCustomScheduleParse(r7, r8, r9, r10, r11);
    }

    private static final Unit saveDraft$lambda$23(ChatJobEditViewModel r1, String r2, f0 r3, f0 r4, long r5, List r7, String r8, b r9) {
        Intrinsics.checkNotNullParameter(r9, "parsedSchedule");
        r1.parsedCustomSchedule = r9;
        r1.submitUpdate(r2, r3, r4, r5, r7, r8, r9);
        return Unit.INSTANCE;
    }
}
