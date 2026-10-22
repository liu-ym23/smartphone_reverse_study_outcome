package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.feature.MmOfficeSdkFeature;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmUpdateAudioStatusResponse;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.HeadsetPromptSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.MmAIInterpretationRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.o;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.p;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.MmRecordingAINoteRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmAudioSaveIdentityType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmAudioSaveType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmRecordingAudioSaveRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmRecordingAutoSaveDecisionScene;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmQuotaType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmRecordingQuotaCtaRenderType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmRecordingQuotaCtaRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmRecordingEndWindowRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.MmRecordingLocationRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingMetaRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.MmRecordingNotificationRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.MmRecordingSpeakerRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRootRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.MmRecordingSummaryRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.r;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingSessionState;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.service.MmRecordingUiProviders;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.UIHelper;
import iub.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__LimitKt$take$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.v0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 Æ\u00012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0004Æ\u0001Ç\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010G\u001a\u00020\nJ\u0012\u0010L\u001a\u0004\u0018\u00010\n2\u0006\u0010M\u001a\u00020\nH\u0002J\u0006\u0010N\u001a\u00020\u0016J\n\u0010O\u001a\u0004\u0018\u00010PH\u0002J\r\u0010Q\u001a\u00020\nH\u0000¢\u0006\u0002\bRJ\u0006\u0010S\u001a\u00020TJ\u0006\u0010U\u001a\u00020TJ\u0006\u0010V\u001a\u00020TJ\u0006\u0010W\u001a\u00020TJ\u0006\u0010X\u001a\u00020TJ\u0006\u0010Y\u001a\u00020TJ\u0006\u0010Z\u001a\u00020\u0016J\u0006\u0010[\u001a\u00020\u0016J\u0006\u0010\\\u001a\u00020TJ\u0006\u0010]\u001a\u00020TJ\u0006\u0010^\u001a\u00020TJ(\u0010_\u001a\u00020T2\u0006\u0010`\u001a\u00020\n2\u0018\b\u0002\u0010a\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010c\u0018\u00010bJ(\u0010d\u001a\u00020T2\u0006\u0010e\u001a\u00020\n2\u0018\b\u0002\u0010a\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010c\u0018\u00010bJ\u0006\u0010f\u001a\u00020TJ\u0006\u0010g\u001a\u00020TJ\u0006\u0010h\u001a\u00020TJ\u000e\u0010i\u001a\u00020T2\u0006\u0010j\u001a\u00020\u0016J\u0016\u0010k\u001a\u00020T2\u0006\u0010l\u001a\u00020\n2\u0006\u0010m\u001a\u00020\nJ\u001a\u0010n\u001a\u00020T2\u0006\u0010o\u001a\u00020\n2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010\nJ\b\u0010q\u001a\u00020\u0002H\u0016J\u0010\u0010r\u001a\u00020T2\u0006\u0010s\u001a\u00020\u0004H\u0016J\u001a\u0010t\u001a\u00020T2\n\b\u0002\u0010u\u001a\u0004\u0018\u00010vH\u0082@¢\u0006\u0002\u0010wJ*\u0010x\u001a\u00020\n2\u0006\u0010y\u001a\u00020\u00162\u0006\u0010z\u001a\u00020\u00162\b\u0010{\u001a\u0004\u0018\u00010v2\u0006\u0010u\u001a\u00020vH\u0002J\u001f\u0010|\u001a\u00020T2\u0006\u0010}\u001a\u00020\n2\u0006\u0010~\u001a\u00020\u007f2\u0007\u0010\u0080\u0001\u001a\u00020\u007fJ\u001f\u0010\u0081\u0001\u001a\u00020T2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010I\u001a\u00020HJ\u0019\u0010\u0082\u0001\u001a\u00020T2\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0006\u0010I\u001a\u00020HJ/\u0010\u0085\u0001\u001a\u00020T2\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0006\u0010I\u001a\u00020H2\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0002J\u0011\u0010\u008a\u0001\u001a\u00020T2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0011\u0010\u008b\u0001\u001a\u00020T2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\"\u0010\u008c\u0001\u001a\u00020T2\u0007\u0010M\u001a\u00030\u008d\u00012\u0007\u0010\u008e\u0001\u001a\u00020\nH\u0082@¢\u0006\u0003\u0010\u008f\u0001J\u0012\u0010\u0090\u0001\u001a\u00020T2\u0007\u0010\u0091\u0001\u001a\u00020\nH\u0002J\u001b\u0010\u0090\u0001\u001a\u00020T2\u0007\u0010\u0091\u0001\u001a\u00020\n2\u0007\u0010\u0092\u0001\u001a\u00020\u0016H\u0002J\t\u0010\u0093\u0001\u001a\u00020TH\u0002J\t\u0010\u0094\u0001\u001a\u00020TH\u0002J\u0019\u0010\u0095\u0001\u001a\u00020T2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010M\u001a\u00020\nH\u0002J\u0011\u0010\u0096\u0001\u001a\u00020T2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0011\u0010\u0097\u0001\u001a\u00020T2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0011\u0010\u0098\u0001\u001a\u00020T2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0011\u0010\u0099\u0001\u001a\u00020T2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0011\u0010\u009a\u0001\u001a\u00020T2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0011\u0010\u009b\u0001\u001a\u00020T2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0011\u0010\u009c\u0001\u001a\u00020T2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0011\u0010\u009d\u0001\u001a\u00020T2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\t\u0010\u009e\u0001\u001a\u00020TH\u0002J\t\u0010\u009f\u0001\u001a\u00020TH\u0002J\u0011\u0010 \u0001\u001a\u00020T2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0011\u0010¡\u0001\u001a\u00020T2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J&\u0010¢\u0001\u001a\u00020T2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010£\u0001\u001a\u00030¤\u00012\t\b\u0002\u0010\u0091\u0001\u001a\u00020\nH\u0002J\t\u0010¥\u0001\u001a\u00020\u0016H\u0002J\u001b\u0010¦\u0001\u001a\u00020T2\u0007\u0010§\u0001\u001a\u00020\n2\u0007\u0010¨\u0001\u001a\u00020\nH\u0002J\n\u0010©\u0001\u001a\u0005\u0018\u00010ª\u0001J\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001J\u0011\u0010\u00ad\u0001\u001a\u00020T2\b\u0010®\u0001\u001a\u00030¯\u0001J#\u0010°\u0001\u001a\u00030¯\u00012\b\u0010±\u0001\u001a\u00030²\u00012\u0007\u0010³\u0001\u001a\u00020PH\u0000¢\u0006\u0003\b´\u0001J\u001a\u0010\u00ad\u0001\u001a\u00020T2\b\u0010±\u0001\u001a\u00030²\u00012\u0007\u0010³\u0001\u001a\u00020PJ\u0011\u0010µ\u0001\u001a\u00020T2\b\u0010®\u0001\u001a\u00030¯\u0001J\u001a\u0010µ\u0001\u001a\u00020T2\b\u0010±\u0001\u001a\u00030²\u00012\u0007\u0010³\u0001\u001a\u00020PJ\u0010\u0010¶\u0001\u001a\u00020T2\u0007\u0010·\u0001\u001a\u00020\nJ\u0011\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001*\u00030¯\u0001H\u0002J\u001d\u0010º\u0001\u001a\u00030»\u00012\b\u0010¼\u0001\u001a\u00030»\u00012\u0007\u0010½\u0001\u001a\u00020PH\u0002J\u001b\u0010¾\u0001\u001a\u00020T2\t\u0010½\u0001\u001a\u0004\u0018\u00010PH\u0082@¢\u0006\u0003\u0010¿\u0001J\u0011\u0010À\u0001\u001a\u00030Á\u0001*\u0005\u0018\u00010¯\u0001H\u0002J\u0007\u0010Â\u0001\u001a\u00020\u0016J\t\u0010Ã\u0001\u001a\u00020TH\u0002J\u0007\u0010Ä\u0001\u001a\u00020TJ\t\u0010Å\u0001\u001a\u00020TH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\"\u001a\u0004\u0018\u00010#8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0013\u0010&\u001a\u0004\u0018\u00010'8F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0013\u0010*\u001a\u0004\u0018\u00010+8F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0013\u0010.\u001a\u0004\u0018\u00010/8F¢\u0006\u0006\u001a\u0004\b0\u00101R\u0013\u00102\u001a\u0004\u0018\u0001038F¢\u0006\u0006\u001a\u0004\b4\u00105R\u0013\u00106\u001a\u0004\u0018\u0001078F¢\u0006\u0006\u001a\u0004\b8\u00109R\u0013\u0010:\u001a\u0004\u0018\u00010;8F¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0011\u0010>\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b?\u0010@R\u001e\u0010B\u001a\u00020A2\u0006\u0010\u0010\u001a\u00020A@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0013\u0010E\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\bF\u0010\fR\u001e\u0010I\u001a\u00020H2\u0006\u0010\u0010\u001a\u00020H@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010K¨\u0006È\u0001"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/MviViewModel;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingVMState;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingVMEvent;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingUIEvent;", "mmUccApi", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;)V", "logDetail", "", "getLogDetail", "()Ljava/lang/String;", "logDetail$delegate", "Lkotlin/Lazy;", "recordingId", "value", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/MmRecordingSession;", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "getSession", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/MmRecordingSession;", "pendingRefreshQuotaAfterUpgradeReturn", "", "hasPendingFinishAudioSaveCheck", "hasTrackedAiNotesRecordingView", "hasTrackedAiNotesOnboardingView", "hasRequestedAiNoteTooltipGuide", "hasRequestedFirstMarkTooltipGuide", "aiInterpretationHeadsetDialogShowing", "pendingAIInterpretationSwitchTipBubble", "notificationProcessor", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/notification/IMmRecordingNotificationProcessor;", "autoSaveDialogLimiter", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingAutoSaveDialogLimiter;", "summaryRepo", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmRecordingSummaryRepo;", "getSummaryRepo", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmRecordingSummaryRepo;", "metaRepo", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/meta/MmRecordingMetaRepo;", "getMetaRepo", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/meta/MmRecordingMetaRepo;", "subtitleRepo", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/MmRecordingSubtitleRepo;", "getSubtitleRepo", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/MmRecordingSubtitleRepo;", "speakerRepo", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmRecordingSpeakerRepo;", "getSpeakerRepo", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmRecordingSpeakerRepo;", "languageRepo", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmRecordingLanguageRepo;", "getLanguageRepo", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmRecordingLanguageRepo;", "quotaCtaRepo", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmRecordingQuotaCtaRepo;", "getQuotaCtaRepo", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmRecordingQuotaCtaRepo;", "aiNoteRepo", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteRepo;", "getAiNoteRepo", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteRepo;", "userContext", "getUserContext", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;", "Lcom/ss/android/lark/officesdk/minutes/ui/service/MmRecordingUiProviders;", "uiProviders", "getUiProviders", "()Lcom/ss/android/lark/officesdk/minutes/ui/service/MmRecordingUiProviders;", "meetingId", "getMeetingId", "resolveSubtitleTranslateLanguage", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "uiLaunchMode", "getUiLaunchMode", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "getCurrentRecordingId", "source", "hasTrackerToken", "currentQuotaCtaEntity", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmRecordingQuotaCtaEntity;", "getAINoteEnableStatus", "getAINoteEnableStatus$officesdk_minutes_base_ui_release", "trackAINoteEntryViewIfNeeded", "", "trackAINoteEntryClickIfNeeded", "refreshAINoteTooltipIfNeeded", "markAINoteTooltipDismissed", "trackAINoteOnboardingViewIfNeeded", "trackAINoteOnboardingCloseClickIfNeeded", "hasAINoteQuotaData", "isAINoteAsrQuotaExceeded", "consumeAndDismissAINoteTooltip", "showFirstMarkFeedbackIfNeeded", "markFirstMarkTooltipDismissed", "trackPageView", "viewScene", "extraParams", "", "", "trackPageClick", PickerReporterConstants.KEY.CLICK, "trackPageBackgroundRunStart", "trackPageBackgroundRunStop", "trackPageBackgroundRunEnd", "trackAIInterpretationView", "isAIOn", "trackAIInterpretationClick", "clickAction", "language", "trackAIInterpretationToast", "toastContent", "notSupportLang", "defaultState", "dispatchEvent", "event", "linkSubtitleTranslationIfNeeded", "targetLanguage", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/aiinterpretation/MmAIInterpretationLanguage;", "(Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/aiinterpretation/MmAIInterpretationLanguage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAIInterpretationClickAction", "targetEnabled", "currentEnabled", "activeLanguage", "trackVoicePrintChange", "clusterId", "oldSpeaker", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmMarkedSpeaker;", "newSpeaker", "initSession", "bindRecordingNotification", "host", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/notification/IRecordingNotificationHost;", "startRecordingNotificationProcessor", "notificationRepo", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/notification/MmRecordingNotificationRepo;", "sessionType", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/RecordingSessionType;", "observeAudioSaveSetting", "observeAIInterpretation", "showAIInterpretationHeadsetPrompt", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/aiinterpretation/HeadsetPromptSource;", "toastText", "(Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/aiinterpretation/HeadsetPromptSource;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAIInterpretationHeadsetDialogDismissed", "reason", "showPendingSwitchTip", "showOrDeferAIInterpretationSwitchTipBubble", "sendAIInterpretationSwitchTipBubbleEvent", "refreshAIInterpretationSettingIfReady", "observeRecordingMetaInfo", "observeMetaRepoEvents", "observeToastEvents", "observeLanguageRepoEvents", "observeSummaryRepoEvents", "observeEndWindowRepoEvents", "observeHasUnviewedSummary", "observeLocationInfo", "observeRecordingLanguage", "observeSubtitleDegradation", "observeSessionState", "checkAutoSaveBeforeRecordFinish", "sendRecordStopEventAfterAudioSaveCheck", "endReason", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/EndRecordingReason;", "isAudioRetentionEnabled", "updateTitle", "oldTitle", "newTitle", "feedbackService", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/IOfficeSDKFeedbackService;", "hostBridge", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/IMmRecordingHostBridge;", "trackQuotaCtaView", "state", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmRecordingQuotaCtaUiState;", "resolveQuotaCtaTrackingState", "tab", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/meta/MmRecordingUITab;", "entity", "resolveQuotaCtaTrackingState$officesdk_minutes_base_ui_release", "trackQuotaCtaClick", "refreshQuotaAfterUpgradeReturnIfNeeded", "from", "quotaTypeOrNull", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmQuotaType;", "resolveAudioSaveType", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmAudioSaveType;", "audioSaveType", "quotaCtaEntity", "showForceAudioSaveToast", "(Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmRecordingQuotaCtaEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toForceAudioSaveToastRes", "", "isRecordingActiveForFloat", "sendEndRecordingPage", "clearNotificationManager", "onCleared", "Companion", "Factory", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmRecordingViewModel extends MviViewModel<i, h, g> {
    private static final String AI_NOTE_TOOLTIP_GUIDE_KEY = "vc_recording_personal_notes";
    private static final a Companion = null;
    private static final long FINISH_AUDIO_SAVE_CHECK_TIMEOUT_MS = 1000;
    private static final String FIRST_MARK_TOOLTIP_GUIDE_KEY = "vc_recording_personal_note_first_mark";
    private boolean aiInterpretationHeadsetDialogShowing;
    private final c autoSaveDialogLimiter;
    private boolean hasPendingFinishAudioSaveCheck;
    private boolean hasRequestedAiNoteTooltipGuide;
    private boolean hasRequestedFirstMarkTooltipGuide;
    private boolean hasTrackedAiNotesOnboardingView;
    private boolean hasTrackedAiNotesRecordingView;
    private final Lazy logDetail$delegate;
    private final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a mmUccApi;
    private ewb.a notificationProcessor;
    private boolean pendingAIInterpretationSwitchTipBubble;
    private boolean pendingRefreshQuotaAfterUpgradeReturn;
    private String recordingId;
    private MmRecordingSession session;
    private MmRecordingUILaunchMode uiLaunchMode;
    private MmRecordingUiProviders uiProviders;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "mmUccApi", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Factory extends ViewModelProvider.NewInstanceFactory {
        public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;

        public Factory(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2) {
            Intrinsics.checkNotNullParameter(r2, "mmUccApi");
            this.a = r2;
        }

        public final <T extends ViewModel> T create(Class<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "modelClass");
            if (r2.isAssignableFrom(MmRecordingViewModel.class) == false) goto L7;
            return new MmRecordingViewModel(this.a);
        L7:
            return (T) super.create(r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmRecordingQuotaCtaRenderType.values().length];
            r0[MmRecordingQuotaCtaRenderType.WindowLimited5H.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MmRecordingQuotaCtaRenderType.WindowLimited7D.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MmRecordingQuotaCtaRenderType.Default.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$checkAutoSaveBeforeRecordFinish$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$checkAutoSaveBeforeRecordFinish$1", f = "MmRecordingViewModel.kt", i = {}, l = {1438, 1464}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MmRecordingSession $session;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public AnonymousClass1(MmRecordingSession r1, MmRecordingViewModel r2, Continuation<? super AnonymousClass1> r3) {
            this.$session = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$session, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r3 = true;
            Boolean r4 = null;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r14);
        L41:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r14);
        L13:
            Result r15 = (Result) r14;
            if (r15 == null) goto L21;
            Object r2 = r15.unbox-impl();
            if (Result.isFailure-impl(r2) == false) goto L18;
            r2 = null;
        L18:
            MmUpdateAudioStatusResponse r5 = (MmUpdateAudioStatusResponse) r2;
            if (r5 == null) goto L21;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.g r12 = new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.g(MmRecordingAutoSaveDecisionScene.RECORD_FINISH, r5.shouldForceSaveAudio(), MmAudioSaveType.SAVE.getValue(), r5.getForceSaveReason(), r5.getUnavailableReason(), 32);
        L23:
            if (r12 != null) goto L33;
            int r6 = bwb.b.a;
            MmUiLogScene r7 = MmUiLogScene.RECORDING;
            StringBuilder r8 = new StringBuilder("no finish decision, syncCompleted=");
            if (r15 != null) goto L28;
            r3 = false;
        L28:
            r8.append(r3);
            r8.append(", syncSuccess=");
            if (r15 == null) goto L31;
            r4 = Boxing.boxBoolean(Result.isSuccess-impl(r15.unbox-impl()));
        L31:
            r8.append(r4);
            bwb.b.f(r7, "checkAutoSaveBeforeRecordFinish", r8.toString(), MmRecordingViewModel.access$getLogDetail(this.this$0));
            MmRecordingViewModel.access$sendRecordStopEventAfterAudioSaveCheck(this.this$0, this.$session, EndRecordingReason.RECORD_FINISH_AUDIO_SAVE_CONTINUE, "no decision");
            return Unit.INSTANCE;
        L33:
            com.ss.android.lark.officesdk.minutes.ui.record.recording.base.b r16 = MmRecordingViewModel.access$getAutoSaveDialogLimiter$p(this.this$0).a(r12);
            if (r16 != null) goto L37;
            int r17 = bwb.b.a;
            bwb.b.f(MmUiLogScene.RECORDING, "checkAutoSaveBeforeRecordFinish", "no dialog, decision=" + r12, MmRecordingViewModel.access$getLogDetail(this.this$0));
            MmRecordingViewModel.access$sendRecordStopEventAfterAudioSaveCheck(this.this$0, this.$session, EndRecordingReason.RECORD_FINISH_AUDIO_SAVE_CONTINUE, "no dialog");
            return Unit.INSTANCE;
        L37:
            int r9 = bwb.b.a;
            bwb.b.f(MmUiLogScene.RECORDING, "checkAutoSaveBeforeRecordFinish", "show finish dialog, reason=" + r16.b + ", decision=" + r12, MmRecordingViewModel.access$getLogDetail(this.this$0));
            MmRecordingViewModel r10 = this.this$0;
            h.d r11 = new h.d(r16);
            this.label = 2;
            if (r10.sendVMEvent(r11, this) != r0) goto L41;
            return r0;
        L21:
            r12 = null;
            goto L23
        L10:
            ResultKt.throwOnFailure(r14);
            MmRecordingViewModel$checkAutoSaveBeforeRecordFinish$1$syncResult$1 r13 = new MmRecordingViewModel$checkAutoSaveBeforeRecordFinish$1$syncResult$1(this.$session.i().E(), null);
            this.label = 1;
            r14 = TimeoutKt.c(MmRecordingViewModel.FINISH_AUDIO_SAVE_CHECK_TIMEOUT_MS, r13, this);
            if (r14 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$1", f = "MmRecordingViewModel.kt", i = {0}, l = {423, 427}, m = "invokeSuspend", n = {"currentSession"}, s = {"L$0"})
    public static final class C02231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02231(MmRecordingViewModel r1, Continuation<? super C02231> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02231(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r3 = true;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r9);
        L35:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            MmRecordingSession r2 = (MmRecordingSession) this.L$0;
            ResultKt.throwOnFailure(r9);
        L17:
            com.ss.android.lark.officesdk.minutes.service.recording.hardware.e r10 = (com.ss.android.lark.officesdk.minutes.service.recording.hardware.e) r9;
            if (r10 == null) goto L20;
            String r5 = r10.f;
        L22:
            if (Intrinsics.areEqual(r5, r2.e()) == false) goto L37;
            Intrinsics.checkNotNullParameter(r10, "<this>");
            HardwareRecordingSessionState r6 = r10.e;
            if (r6 != HardwareRecordingSessionState.WAITING_CALL_RECOVERY) goto L26;
        L29:
            boolean r7 = true;
        L30:
            if (r7 == false) goto L37;
            MmRecordingViewModel r4 = this.this$0;
            h.g r8 = new h.g(new svb.a.b(UIHelper.getString(com.ss.android.lark.officesdk.minutes.ui.record.recording.base.a.a(r10))));
            this.L$0 = null;
            this.label = 2;
            if (r4.sendVMEvent(r8, this) != r0) goto L35;
            return r0;
        L26:
            if (r6 == HardwareRecordingSessionState.WAITING_INPUT_RECOVERY) goto L29;
            r7 = false;
        L37:
            if (this.this$0.getState().d == MMRecordingState.PAUSED) goto L40;
            r3 = false;
        L40:
            if (r3 == false) goto L42;
            com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a r11 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.i.a;
        L43:
            r2.u(r11);
            return Unit.INSTANCE;
        L42:
            r11 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.h.a;
            goto L43
        L20:
            r5 = null;
            goto L22
        L10:
            ResultKt.throwOnFailure(r9);
            r2 = this.this$0.getSession();
            if (r2 != null) goto L14;
            int r12 = bwb.b.a;
            bwb.b.d(MmUiLogScene.RECORDING, "dispatchEvent", "unexpected, session not found", MmRecordingViewModel.access$getLogDetail(this.this$0));
            return Unit.INSTANCE;
        L14:
            com.ss.android.lark.officesdk.minutes.service.recording.hardware.i r13 = MmRecordingViewModel.access$getMmUccApi$p(this.this$0).L();
            this.L$0 = r2;
            this.label = 1;
            r9 = r13.a(this);
            if (r9 != r0) goto L17;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$10, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$10", f = "MmRecordingViewModel.kt", i = {}, l = {554, 562}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ g $event;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public AnonymousClass10(MmRecordingViewModel r1, g r2, Continuation<? super AnonymousClass10> r3) {
            this.this$0 = r1;
            this.$event = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass10(this.this$0, this.$event, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r15);
        L66:
            p r16 = (p) r15;
        L68:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r15);
        L54:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r15);
            MmRecordingSession r17 = this.this$0.getSession();
            String r2 = null;
            if (r17 == null) goto L13;
            RecordingSessionType r18 = r17.a;
        L15:
            if (r18 != RecordingSessionType.HARDWARE_RECORDING) goto L18;
            int r19 = bwb.b.a;
            bwb.b.f(MmUiLogScene.RECORDING, "dispatchEvent", "SetAIInterpretationEnabled skip hardware recording", MmRecordingViewModel.access$getLogDetail(this.this$0));
            return Unit.INSTANCE;
        L18:
            String r110 = this.this$0.getState().b;
            MmRecordingViewModel r4 = this.this$0;
            boolean r7 = false;
            if (r110.length() != 0) goto L21;
            boolean r6 = true;
        L22:
            if (r6 == false) goto L26;
            r110 = r4.getMeetingId();
            if (r110 != null) goto L26;
            r110 = "";
        L26:
            String r9 = r110;
            if (r9.length() != 0) goto L29;
            r7 = true;
        L29:
            if (r7 == false) goto L32;
            int r111 = bwb.b.a;
            bwb.b.d(MmUiLogScene.RECORDING, "dispatchEvent", "SetAIInterpretationEnabled without meetingId", MmRecordingViewModel.access$getLogDetail(this.this$0));
            return Unit.INSTANCE;
        L32:
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r11 = this.this$0.getState().y;
            MmRecordingViewModel r112 = this.this$0;
            String r113 = MmRecordingViewModel.access$getAIInterpretationClickAction(r112, ((g.n) this.$event).a, r112.getState().v, r11, ((g.n) this.$event).b);
            int r5 = bwb.b.a;
            MmUiLogScene r8 = MmUiLogScene.RECORDING;
            StringBuilder r10 = new StringBuilder("SetAIInterpretationEnabled enabled=");
            r10.append(((g.n) this.$event).a);
            r10.append(", , language=");
            r10.append(((g.n) this.$event).b.a);
            r10.append(", currentOn=");
            r10.append(this.this$0.getState().v);
            r10.append(", activeLanguage=");
            if (r11 == null) goto L35;
            r2 = r11.a;
        L35:
            r10.append(r2);
            r10.append(", clickAction=");
            r10.append(r113);
            bwb.b.f(r8, "dispatchEvent", r10.toString(), MmRecordingViewModel.access$getLogDetail(this.this$0));
            this.this$0.trackAIInterpretationClick(r113, ((g.n) this.$event).b.a);
            if (((g.n) this.$event).a == true) goto L38;
        L55:
            MmRecordingSession r114 = this.this$0.getSession();
            if (r114 == null) goto L68;
            MmRecordingRepo r115 = r114.f();
            if (r115 == null) goto L68;
            MmAIInterpretationRepo r116 = r115.q();
            if (r116 == null) goto L68;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a r117 = r116.n();
            if (r117 == null) goto L68;
            g.n r3 = (g.n) this.$event;
            boolean r12 = r3.a;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r13 = r3.b;
            this.label = 2;
            r15 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a.C0039a.a(r117, r9, r12, r13, this);
            if (r15 != r0) goto L66;
            return r0;
        L38:
            if (this.this$0.getState().v == false) goto L55;
            if (r11 == null) goto L55;
            if (Intrinsics.areEqual(r11.a, ((g.n) this.$event).b.a) == true) goto L55;
            bwb.b.f(r8, "dispatchEvent", "SetAIInterpretationEnabled switch language, activeLanguage=" + r11.a + ", targetLanguage=" + ((g.n) this.$event).b.a, MmRecordingViewModel.access$getLogDetail(this.this$0));
            MmRecordingSession r118 = this.this$0.getSession();
            if (r118 == null) goto L54;
            MmRecordingRepo r119 = r118.f();
            if (r119 == null) goto L54;
            MmAIInterpretationRepo r120 = r119.q();
            if (r120 == null) goto L54;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a r14 = r120.n();
            if (r14 == null) goto L54;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r121 = ((g.n) this.$event).b;
            this.label = 1;
            if (r14.w(r9, "", r11, r121, this) != r0) goto L54;
            return r0;
        L21:
            r6 = false;
            goto L22
        L13:
            r18 = null;
            goto L15
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$11, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$11", f = "MmRecordingViewModel.kt", i = {}, l = {593, 602, 631}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass11 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ g $event;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public AnonymousClass11(MmRecordingViewModel r1, g r2, Continuation<? super AnonymousClass11> r3) {
            this.this$0 = r1;
            this.$event = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass11(this.this$0, this.$event, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r12);
        L90:
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.e r13 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.e) r12;
        L92:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r12);
        L49:
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.e r7 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.e) r12;
        L51:
            if (Intrinsics.areEqual(r7, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.e.b.a) == false) goto L54;
            com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.f(2131892908);
        L57:
            return Unit.INSTANCE;
        L54:
            if (Intrinsics.areEqual(r7, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.e.a.a) == false) goto L57;
            com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.f(2131892900);
            goto L57
        L11:
            ResultKt.throwOnFailure(r12);
        L29:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r12);
            MmAudioSaveType r14 = this.this$0.getState().r;
            if (r14.isSave() != ((g.o) this.$event).a) goto L16;
            int r2 = bwb.b.a;
            bwb.b.f(MmUiLogScene.RECORDING, "dispatchEvent", "skip same audioSaveType=" + r14, MmRecordingViewModel.access$getLogDetail(this.this$0));
            return Unit.INSTANCE;
        L16:
            boolean r5 = false;
            if (r14.isForce() == false) goto L30;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r3 = MmRecordingViewModel.access$currentQuotaCtaEntity(this.this$0);
            if (r3 == null) goto L25;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r4 = r3.a;
            if (r4 == null) goto L25;
            if (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.f.a(r4) != true) goto L25;
            r5 = true;
        L25:
            int r6 = bwb.b.a;
            bwb.b.f(MmUiLogScene.RECORDING, "dispatchEvent", "blocked force audioSaveType=" + r14 + ", quotaExceeded=" + r5, MmRecordingViewModel.access$getLogDetail(this.this$0));
            MmRecordingViewModel r15 = this.this$0;
            this.label = 1;
            if (MmRecordingViewModel.access$showForceAudioSaveToast(r15, r3, this) != r0) goto L29;
            return r0;
        L30:
            MmRecordingSession r16 = this.this$0.getSession();
            if (r16 != null) goto L34;
            int r17 = bwb.b.a;
            bwb.b.d(MmUiLogScene.RECORDING, "dispatchEvent", "unexpected, session not found", MmRecordingViewModel.access$getLogDetail(this.this$0));
            return Unit.INSTANCE;
        L34:
            k r8 = r16.f;
            r7 = null;
            if (r8 == null) goto L37;
            MmRecordingSource r9 = r8.a;
        L39:
            if (r9 != MmRecordingSource.FEISHU_HARDWARE_D1204) goto L58;
            MmRecordingRepo r18 = r16.f();
            if (r18 == null) goto L51;
            MmRecordingAudioSaveRepo r19 = r18.s();
            if (r19 == null) goto L51;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.b r110 = r19.m();
            if (r110 == null) goto L51;
            boolean r10 = ((g.o) this.$event).a;
            this.label = 2;
            r12 = r110.E0(null, r10, this);
            if (r12 != r0) goto L49;
            return r0;
        L58:
            ovb.b r11 = r16.w;
            boolean r20 = r16.v();
            String r21 = r11.c;
            String r22 = this.this$0.getState().a;
            if (r22.length() != 0) goto L61;
            boolean r111 = true;
        L62:
            if (r111 == false) goto L64;
            r22 = r11.d;
        L64:
            Intrinsics.checkNotNullParameter(r21, "recordingId");
            Intrinsics.checkNotNullParameter(r22, "minutesToken");
            if (r20 == false) goto L67;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.c r23 = new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.c(r21, MmAudioSaveIdentityType.RECORDING_ID);
        L69:
            if (r23.a.length() != 0) goto L71;
            r5 = true;
        L71:
            if (r5 == false) goto L81;
            int r112 = bwb.b.a;
            MmUiLogScene r113 = MmUiLogScene.RECORDING;
            int r24 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.c.a.a[r23.b.ordinal()];
            if (r24 == 1) goto L78;
            if (r24 != 2) goto L77;
            String r25 = "unexpected, minutesToken not found";
        L79:
            bwb.b.d(r113, "dispatchEvent", r25, MmRecordingViewModel.access$getLogDetail(this.this$0));
            return Unit.INSTANCE;
        L77:
            throw new NoWhenBranchMatchedException();
        L78:
            r25 = "unexpected, recordingId not found";
            goto L79
        L81:
            MmRecordingRepo r114 = r16.f();
            if (r114 == null) goto L92;
            MmRecordingAudioSaveRepo r115 = r114.s();
            if (r115 == null) goto L92;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.b r116 = r115.m();
            if (r116 == null) goto L92;
            boolean r26 = ((g.o) this.$event).a;
            this.label = 3;
            r12 = r116.E0(r23, r26, this);
            if (r12 != r0) goto L90;
            return r0;
        L67:
            r23 = new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.c(r22, MmAudioSaveIdentityType.MINUTES_TOKEN);
            goto L69
        L61:
            r111 = false;
            goto L62
        L37:
            r9 = null;
            goto L39
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$12, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$12", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass12 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public AnonymousClass12(MmRecordingViewModel r1, Continuation<? super AnonymousClass12> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass12(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L16;
            ResultKt.throwOnFailure(r2);
            MmRecordingSession r3 = this.this$0.getSession();
            if (r3 == null) goto L14;
            MmRecordingRepo r4 = r3.f();
            if (r4 == null) goto L14;
            MmRecordingLocationRepo r5 = r4.v();
            if (r5 == null) goto L14;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.a r6 = r5.m();
            if (r6 == null) goto L14;
            r6.getLocation();
        L14:
            return Unit.INSTANCE;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$13, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$13", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass13 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ g $event;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public AnonymousClass13(MmRecordingViewModel r1, g r2, Continuation<? super AnonymousClass13> r3) {
            this.this$0 = r1;
            this.$event = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass13(this.this$0, this.$event, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L16;
            ResultKt.throwOnFailure(r2);
            MmRecordingSession r3 = this.this$0.getSession();
            if (r3 == null) goto L14;
            MmRecordingRepo r4 = r3.f();
            if (r4 == null) goto L14;
            MmRecordingLocationRepo r5 = r4.v();
            if (r5 == null) goto L14;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.a r6 = r5.m();
            if (r6 == null) goto L14;
            r6.K0(((g.h) this.$event).a);
        L14:
            return Unit.INSTANCE;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$2", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public AnonymousClass2(MmRecordingViewModel r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L15;
            ResultKt.throwOnFailure(r4);
            MmRecordingSession r5 = this.this$0.getSession();
            if (r5 != null) goto L8;
            int r6 = bwb.b.a;
            bwb.b.d(MmUiLogScene.RECORDING, "dispatchEvent", "unexpected, session not found", MmRecordingViewModel.access$getLogDetail(this.this$0));
            return Unit.INSTANCE;
        L8:
            MmRecordingViewModel.access$markAIInterpretationHeadsetDialogDismissed(this.this$0, "stop recording");
            MmRecordingViewModel.access$sendEndRecordingPage(this.this$0);
            if (MmRecordingViewModel.access$isAudioRetentionEnabled(this.this$0) == false) goto L11;
            MmRecordingViewModel.access$checkAutoSaveBeforeRecordFinish(this.this$0, r5);
        L13:
            return Unit.INSTANCE;
        L11:
            Boxing.boxBoolean(r5.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.k(EndRecordingReason.RECORDING_PAGE_CLICK_STOP)));
            goto L13
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$3", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public AnonymousClass3(MmRecordingViewModel r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r2);
            MmRecordingLanguageRepo r3 = this.this$0.getLanguageRepo();
            if (r3 == null) goto L10;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a r4 = r3.l();
            if (r4 == null) goto L10;
            r4.l0();
        L10:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$4", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ g $event;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public AnonymousClass4(MmRecordingViewModel r1, g r2, Continuation<? super AnonymousClass4> r3) {
            this.this$0 = r1;
            this.$event = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass4(this.this$0, this.$event, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r2);
            MmRecordingLanguageRepo r3 = this.this$0.getLanguageRepo();
            if (r3 == null) goto L10;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a r4 = r3.l();
            if (r4 == null) goto L10;
            r4.F(((g.q) this.$event).a);
        L10:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$5", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ g $event;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public AnonymousClass5(MmRecordingViewModel r1, g r2, Continuation<? super AnonymousClass5> r3) {
            this.this$0 = r1;
            this.$event = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass5(this.this$0, this.$event, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r3);
            MmRecordingLanguageRepo r4 = this.this$0.getLanguageRepo();
            if (r4 == null) goto L10;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a r5 = r4.l();
            if (r5 == null) goto L10;
            r5.e0(((g.r) this.$event).a, true);
        L10:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$6", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ g $event;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public AnonymousClass6(MmRecordingViewModel r1, g r2, Continuation<? super AnonymousClass6> r3) {
            this.this$0 = r1;
            this.$event = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass6(this.this$0, this.$event, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r2);
            MmRecordingLanguageRepo r3 = this.this$0.getLanguageRepo();
            if (r3 == null) goto L10;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a r4 = r3.l();
            if (r4 == null) goto L10;
            r4.Y(((g.p) this.$event).a);
        L10:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$7", f = "MmRecordingViewModel.kt", i = {}, l = {494}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public AnonymousClass7(MmRecordingViewModel r1, Continuation<? super AnonymousClass7> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass7(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L20:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            MmRecordingSession r5 = this.this$0.getSession();
            if (r5 == null) goto L20;
            MmRecordingRepo r6 = r5.f();
            if (r6 == null) goto L20;
            MmRecordingAudioSaveRepo r7 = r6.s();
            if (r7 == null) goto L20;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.b r8 = r7.m();
            if (r8 == null) goto L20;
            this.label = 1;
            if (r8.A(this) != r0) goto L20;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$8, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$8", f = "MmRecordingViewModel.kt", i = {}, l = {510}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public AnonymousClass8(MmRecordingViewModel r1, Continuation<? super AnonymousClass8> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass8(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L43:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            MmRecordingSession r9 = this.this$0.getSession();
            if (r9 == null) goto L11;
            RecordingSessionType r10 = r9.a;
        L13:
            if (r10 != RecordingSessionType.HARDWARE_RECORDING) goto L16;
            int r11 = bwb.b.a;
            bwb.b.f(MmUiLogScene.RECORDING, "dispatchEvent", "AIInterpretationClick skip hardware recording", MmRecordingViewModel.access$getLogDetail(this.this$0));
            return Unit.INSTANCE;
        L16:
            String r12 = this.this$0.getState().b;
            MmRecordingViewModel r2 = this.this$0;
            boolean r5 = false;
            if (r12.length() != 0) goto L19;
            boolean r4 = true;
        L21:
            if (r4 == false) goto L26;
            r12 = r2.getMeetingId();
            if (r12 != null) goto L26;
            r12 = "";
        L26:
            if (r12.length() != 0) goto L28;
            r5 = true;
        L28:
            if (r5 == false) goto L31;
            int r13 = bwb.b.a;
            bwb.b.d(MmUiLogScene.RECORDING, "dispatchEvent", "AIInterpretationClick without meetingId", MmRecordingViewModel.access$getLogDetail(this.this$0));
            return Unit.INSTANCE;
        L31:
            int r3 = bwb.b.a;
            bwb.b.f(MmUiLogScene.RECORDING, "dispatchEvent", "AIInterpretationClick", MmRecordingViewModel.access$getLogDetail(this.this$0));
            MmRecordingSession r6 = this.this$0.getSession();
            if (r6 == null) goto L43;
            MmRecordingRepo r7 = r6.f();
            if (r7 == null) goto L43;
            MmAIInterpretationRepo r14 = r7.q();
            if (r14 == null) goto L43;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a r15 = r14.n();
            if (r15 == null) goto L43;
            this.label = 1;
            if (r15.r0(r12, "", this) != r0) goto L43;
            return r0;
        L19:
            r4 = false;
            goto L21
        L11:
            r10 = null;
            goto L13
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$9, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$dispatchEvent$9", f = "MmRecordingViewModel.kt", i = {}, l = {521}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ g $event;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public AnonymousClass9(MmRecordingViewModel r1, g r2, Continuation<? super AnonymousClass9> r3) {
            this.this$0 = r1;
            this.$event = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass9(this.this$0, this.$event, r4);
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
        L28:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            MmRecordingSession r7 = this.this$0.getSession();
            if (r7 == null) goto L11;
            RecordingSessionType r8 = r7.a;
        L13:
            if (r8 != RecordingSessionType.HARDWARE_RECORDING) goto L16;
            int r9 = bwb.b.a;
            bwb.b.f(MmUiLogScene.RECORDING, "dispatchEvent", "SelectAIInterpretationLanguage skip hardware recording", MmRecordingViewModel.access$getLogDetail(this.this$0));
            return Unit.INSTANCE;
        L16:
            int r10 = bwb.b.a;
            bwb.b.f(MmUiLogScene.RECORDING, "dispatchEvent", "SelectAIInterpretationLanguage language=" + ((g.m) this.$event).a.a, MmRecordingViewModel.access$getLogDetail(this.this$0));
            MmRecordingSession r11 = this.this$0.getSession();
            if (r11 == null) goto L28;
            MmRecordingRepo r12 = r11.f();
            if (r12 == null) goto L28;
            MmAIInterpretationRepo r13 = r12.q();
            if (r13 == null) goto L28;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a r14 = r13.n();
            if (r14 == null) goto L28;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r2 = ((g.m) this.$event).a;
            this.label = 1;
            if (r14.I(r2, this) != r0) goto L28;
            return r0;
        L11:
            r8 = null;
            goto L13
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$markAINoteTooltipDismissed$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$markAINoteTooltipDismissed$2", f = "MmRecordingViewModel.kt", i = {}, l = {259}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02262 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MmRecordingSource $source;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02262(MmRecordingViewModel r1, MmRecordingSource r2, Continuation<? super C02262> r3) {
            this.this$0 = r1;
            this.$source = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02262(this.this$0, this.$source, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
            Object r6 = ((Result) r5).unbox-impl();
        L11:
            MmRecordingViewModel r2 = this.this$0;
            Throwable r7 = Result.exceptionOrNull-impl(r6);
            if (r7 == null) goto L15;
            int r3 = bwb.b.a;
            bwb.b.d(MmUiLogScene.AI_NOTE, "markAINoteTooltipDismissed", "saveUserGuide failed: " + r7, MmRecordingViewModel.access$getLogDetail(r2));
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MmRecordingNetHelper r8 = MmRecordingViewModel.access$getMmUccApi$p(this.this$0).G();
            MmRecordingSource r4 = this.$source;
            this.label = 1;
            r6 = r8.v(MmRecordingViewModel.AI_NOTE_TOOLTIP_GUIDE_KEY, r4, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$markFirstMarkTooltipDismissed$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$markFirstMarkTooltipDismissed$1", f = "MmRecordingViewModel.kt", i = {}, l = {346}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MmRecordingSource $source;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02271(MmRecordingViewModel r1, MmRecordingSource r2, Continuation<? super C02271> r3) {
            this.this$0 = r1;
            this.$source = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02271(this.this$0, this.$source, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
            Object r6 = ((Result) r5).unbox-impl();
        L11:
            MmRecordingViewModel r2 = this.this$0;
            Throwable r7 = Result.exceptionOrNull-impl(r6);
            if (r7 == null) goto L15;
            int r3 = bwb.b.a;
            bwb.b.d(MmUiLogScene.AI_NOTE, "markFirstMarkTooltipDismissed", "saveUserGuide failed: " + r7, MmRecordingViewModel.access$getLogDetail(r2));
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MmRecordingNetHelper r8 = MmRecordingViewModel.access$getMmUccApi$p(this.this$0).G();
            MmRecordingSource r4 = this.$source;
            this.label = 1;
            r6 = r8.v(MmRecordingViewModel.FIRST_MARK_TOOLTIP_GUIDE_KEY, r4, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeAIInterpretation$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/aiinterpretation/MmAIInterpretationRepoEvent;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeAIInterpretation$2", f = "MmRecordingViewModel.kt", i = {}, l = {1038, 1047, 1057, 1070}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02282 extends SuspendLambda implements Function2<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.i, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02282(MmRecordingViewModel r1, Continuation<? super C02282> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02282 r0 = new C02282(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.i r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.i) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L11;
            if (r1 == 3) goto L11;
            if (r1 == 4) goto L11;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r9);
        L37:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r9);
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.i r10 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.i) this.L$0;
            if ((r10 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.i.c) == false) goto L18;
            MmRecordingViewModel.trackAIInterpretationToast$default(this.this$0, "recommend_earphone", null, 2, null);
            MmRecordingViewModel r2 = this.this$0;
            HeadsetPromptSource r11 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.i.c) r10).a;
            String r3 = UIHelper.getString(2131894012);
            this.label = 1;
            if (MmRecordingViewModel.access$showAIInterpretationHeadsetPrompt(r2, r11, r3, this) != r0) goto L37;
            return r0;
        L18:
            if ((r10 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.i.b) == false) goto L23;
            MmRecordingViewModel.trackAIInterpretationToast$default(this.this$0, "recommend_earphone", null, 2, null);
            MmRecordingViewModel r4 = this.this$0;
            HeadsetPromptSource r12 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.i.b) r10).a;
            String r5 = UIHelper.getString(2131894013);
            this.label = 2;
            if (MmRecordingViewModel.access$showAIInterpretationHeadsetPrompt(r4, r12, r5, this) != r0) goto L37;
            return r0;
        L23:
            if (Intrinsics.areEqual(r10, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.i.d.a) == true) goto L37;
            if (Intrinsics.areEqual(r10, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.i.a.a) == false) goto L30;
            MmRecordingViewModel.access$markAIInterpretationHeadsetDialogDismissed(this.this$0, "ai interpretation stopped");
            MmRecordingViewModel r13 = this.this$0;
            h.g r6 = new h.g(new svb.a.b(UIHelper.getString(2131893525)));
            this.label = 3;
            if (r13.sendVMEvent(r6, this) != r0) goto L37;
            return r0;
        L30:
            if ((r10 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.i.e) == false) goto L35;
            this.this$0.trackAIInterpretationToast("not_support_lang", ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.i.e) r10).a);
            MmRecordingViewModel r14 = this.this$0;
            h.g r7 = new h.g(new svb.a.b(UIHelper.getString(2131894011)));
            this.label = 4;
            if (r14.sendVMEvent(r7, this) != r0) goto L37;
            return r0;
        L35:
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeAudioSaveSetting$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "audioSaveType", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmAudioSaveType;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeAudioSaveSetting$3", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02303 extends SuspendLambda implements Function2<MmAudioSaveType, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02303(MmRecordingViewModel r1, Continuation<? super C02303> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02303 r0 = new C02303(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(MmAudioSaveType r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((MmAudioSaveType) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            final MmAudioSaveType r6 = (MmAudioSaveType) this.L$0;
            int r0 = bwb.b.a;
            bwb.b.f(MmUiLogScene.RECORDING, "observeAudioSaveSetting", "D1204 default audioSaveType=" + r6, MmRecordingViewModel.access$getLogDetail(this.this$0));
            this.this$0.setState(new AnonymousClass1(r6));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeAudioSaveSetting$5, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "audioSaveType", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmAudioSaveType;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeAudioSaveSetting$5", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02325 extends SuspendLambda implements Function2<MmAudioSaveType, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02325(MmRecordingViewModel r1, Continuation<? super C02325> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02325 r0 = new C02325(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(MmAudioSaveType r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((MmAudioSaveType) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            final MmAudioSaveType r6 = (MmAudioSaveType) this.L$0;
            int r0 = bwb.b.a;
            bwb.b.f(MmUiLogScene.RECORDING, "observeAudioSaveSetting", "only audio save audio saveType=" + r6, MmRecordingViewModel.access$getLogDetail(this.this$0));
            this.this$0.setState(new AnonymousClass1(r6));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeAudioSaveSetting$6, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmAudioSaveType;", "audioSaveEntity", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmRecordingAudioSaveEntity;", "quotaCtaEntity", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/cta/MmRecordingQuotaCtaEntity;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeAudioSaveSetting$6", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02336 extends SuspendLambda implements Function3<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.f, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c, Continuation<? super MmAudioSaveType>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02336(MmRecordingViewModel r1, Continuation<? super C02336> r2) {
            this.this$0 = r1;
            super(3, r2);
        }

        public final Object invoke(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.f r3, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r4, Continuation<? super MmAudioSaveType> r5) {
            C02336 r0 = new C02336(this.this$0, r5);
            r0.L$0 = r3;
            r0.L$1 = r4;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.f) r1, (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c) r2, (Continuation) r3);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.f r4 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.f) this.L$0;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r0 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c) this.L$1;
            return MmRecordingViewModel.access$resolveAudioSaveType(this.this$0, r4.a, r0);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeAudioSaveSetting$7, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "audioSaveType", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmAudioSaveType;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeAudioSaveSetting$7", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02347 extends SuspendLambda implements Function2<MmAudioSaveType, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02347(MmRecordingViewModel r1, Continuation<? super C02347> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02347 r0 = new C02347(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(MmAudioSaveType r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((MmAudioSaveType) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            final MmAudioSaveType r6 = (MmAudioSaveType) this.L$0;
            int r0 = bwb.b.a;
            bwb.b.f(MmUiLogScene.RECORDING, "observeAudioSaveSetting", "audio saveType=" + r6, MmRecordingViewModel.access$getLogDetail(this.this$0));
            this.this$0.setState(new AnonymousClass1(r6));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeEndWindowRepoEvents$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmRecordingEndWindowRepoEvent$EndRecording;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeEndWindowRepoEvents$1", f = "MmRecordingViewModel.kt", i = {}, l = {1287}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02351 extends SuspendLambda implements Function2<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.g, Continuation<? super Unit>, Object> {
        final /* synthetic */ MmRecordingSession $session;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02351(MmRecordingViewModel r1, MmRecordingSession r2, Continuation<? super C02351> r3) {
            this.this$0 = r1;
            this.$session = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02351(this.this$0, this.$session, r4);
        }

        public final Object invoke(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.g r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.g) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MmRecordingViewModel r6 = this.this$0;
            h.a r2 = new h.a(this.$session.e());
            this.label = 1;
            if (r6.sendVMEvent(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeLanguageRepoEvents$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmRecordingLanguageRepoEvent;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeLanguageRepoEvents$1", f = "MmRecordingViewModel.kt", i = {}, l = {1253}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02361 extends SuspendLambda implements Function2<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.g, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02361(MmRecordingViewModel r1, Continuation<? super C02361> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02361 r0 = new C02361(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.g r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.g) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L19:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.g r5 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.g) this.L$0;
            Intrinsics.checkNotNullParameter(r5, "<this>");
            if ((r5 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.g.a) == false) goto L12;
            h.e r6 = h.e.a;
        L14:
            if (r6 == null) goto L19;
            MmRecordingViewModel r2 = this.this$0;
            this.label = 1;
            if (r2.sendVMEvent(r6, this) != r0) goto L19;
            return r0;
        L12:
            if ((r5 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.g.b) == false) goto L21;
            r6 = null;
            goto L14
        L21:
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeMetaRepoEvents$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/meta/MmRecordingMetaRepoEvent;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeMetaRepoEvents$1", f = "MmRecordingViewModel.kt", i = {}, l = {1232}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02371 extends SuspendLambda implements Function2<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.c, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02371(MmRecordingViewModel r1, Continuation<? super C02371> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02371 r0 = new C02371(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.c r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.c) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.c r7 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.c) this.L$0;
            if ((r7 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.c.a) == false) goto L16;
            MmRecordingViewModel r2 = this.this$0;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.c.a r8 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.c.a) r7;
            h.C0063h r3 = new h.C0063h(r8.a, r8.b);
            this.label = 1;
            if (r2.sendVMEvent(r3, this) != r0) goto L14;
            return r0;
        L16:
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeRecordingLanguage$10, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeRecordingLanguage$10", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C023910 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C023910(MmRecordingViewModel r1, Continuation<? super C023910> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C023910 r0 = new C023910(this.this$0, r4);
            r0.Z$0 = ((Boolean) r3).booleanValue();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
        }

        public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
            return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            final boolean r6 = this.Z$0;
            int r0 = bwb.b.a;
            bwb.b.f(MmUiLogScene.RECORDING, "observeRecordingLanguage", "isBilingual=" + r6, MmRecordingViewModel.access$getLogDetail(this.this$0));
            this.this$0.setState(new AnonymousClass1(r6));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeRecordingLanguage$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmSubtitleLanguage;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeRecordingLanguage$2", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02402 extends SuspendLambda implements Function2<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02402(MmRecordingViewModel r1, Continuation<? super C02402> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02402 r0 = new C02402(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r5);
            final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r6 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h) this.L$0;
            if (r6.a.length() != 0) goto L7;
            boolean r0 = true;
        L8:
            if (r0 == true) goto L10;
            int r1 = bwb.b.a;
            bwb.b.f(MmUiLogScene.RECORDING, "observeRecordingLanguage", "currSpokenLanguage=" + r6, MmRecordingViewModel.access$getLogDetail(this.this$0));
            this.this$0.setState(new AnonymousClass1(r6));
            return Unit.INSTANCE;
        L10:
            return Unit.INSTANCE;
        L7:
            r0 = false;
            goto L8
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeRecordingLanguage$4, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmSubtitleLanguage;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeRecordingLanguage$4", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02424 extends SuspendLambda implements Function2<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02424(MmRecordingViewModel r1, Continuation<? super C02424> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02424 r0 = new C02424(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r5);
            final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r6 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h) this.L$0;
            if (r6.a.length() != 0) goto L7;
            boolean r0 = true;
        L8:
            if (r0 == true) goto L10;
            int r1 = bwb.b.a;
            bwb.b.f(MmUiLogScene.RECORDING, "observeRecordingLanguage", "currTranslateLanguage=" + r6, MmRecordingViewModel.access$getLogDetail(this.this$0));
            this.this$0.setState(new AnonymousClass1(r6));
            return Unit.INSTANCE;
        L10:
            return Unit.INSTANCE;
        L7:
            r0 = false;
            goto L8
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeRecordingLanguage$6, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "spokenLanguageList", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmSubtitleLanguage;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeRecordingLanguage$6", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02446 extends SuspendLambda implements Function2<List<? extends com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02446(MmRecordingViewModel r1, Continuation<? super C02446> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02446 r0 = new C02446(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((List) r1, (Continuation) r2);
        }

        public final Object invoke(List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r5);
            final List r6 = (List) this.L$0;
            if (r6.isEmpty() == true) goto L7;
            int r0 = bwb.b.a;
            bwb.b.f(MmUiLogScene.RECORDING, "observeRecordingLanguage", "spokenLanguageList size=" + r6.size(), MmRecordingViewModel.access$getLogDetail(this.this$0));
            this.this$0.setState(new AnonymousClass1(r6));
            return Unit.INSTANCE;
        L7:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeRecordingLanguage$8, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "translateLanguageList", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmSubtitleLanguage;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeRecordingLanguage$8", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02468 extends SuspendLambda implements Function2<List<? extends com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeRecordingLanguage$8$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeRecordingLanguage$8$2", f = "MmRecordingViewModel.kt", i = {}, l = {1354}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ MmRecordingViewModel this$0;

            public AnonymousClass2(MmRecordingViewModel r1, Continuation<? super AnonymousClass2> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass2(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                MmRecordingViewModel r5 = this.this$0;
                this.label = 1;
                if (MmRecordingViewModel.linkSubtitleTranslationIfNeeded$default(r5, null, this, 1, null) != r0) goto L12;
                return r0;
            }
        }

        public C02468(MmRecordingViewModel r1, Continuation<? super C02468> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02468 r0 = new C02468(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((List) r1, (Continuation) r2);
        }

        public final Object invoke(List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r7);
            final List r8 = (List) this.L$0;
            if (r8.isEmpty() == true) goto L7;
            int r0 = bwb.b.a;
            bwb.b.f(MmUiLogScene.RECORDING, "observeRecordingLanguage", "translateLanguageList size=" + r8.size(), MmRecordingViewModel.access$getLogDetail(this.this$0));
            this.this$0.setState(new AnonymousClass1(r8));
            BuildersKt.launch$default(MmRecordingViewModel.access$getViewModelScope(this.this$0), null, null, new AnonymousClass2(this.this$0, null), 3, null);
            return Unit.INSTANCE;
        L7:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeRecordingMetaInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "volume", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeRecordingMetaInfo$1", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02481 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
        /* synthetic */ int I$0;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02481(MmRecordingViewModel r1, Continuation<? super C02481> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02481 r0 = new C02481(this.this$0, r4);
            r0.I$0 = ((Number) r3).intValue();
            return r0;
        }

        public final Object invoke(int r1, Continuation<? super Unit> r2) {
            return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Number) r1).intValue(), (Continuation) r2);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            final int r4 = this.I$0;
            this.this$0.setState(new C00601(r4));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeRecordingMetaInfo$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "duration", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeRecordingMetaInfo$2", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02492 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {
        /* synthetic */ long J$0;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02492(MmRecordingViewModel r1, Continuation<? super C02492> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02492 r0 = new C02492(this.this$0, r4);
            r0.J$0 = ((Number) r3).longValue();
            return r0;
        }

        public final Object invoke(long r1, Continuation<? super Unit> r3) {
            return create(Long.valueOf(r1), r3).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
            return invoke(((Number) r3).longValue(), (Continuation) r4);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            final long r0 = this.J$0;
            this.this$0.setState(new AnonymousClass1(r0));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeSessionState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeSessionState$1", f = "MmRecordingViewModel.kt", i = {}, l = {1380}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isD1204Recording;
        final /* synthetic */ MmRecordingSession $session;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeSessionState$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ MmRecordingViewModel a;
            public final /* synthetic */ boolean b;

            public a(MmRecordingViewModel r1, boolean r2) {
                this.a = r1;
                this.b = r2;
            }

            public final Object emit(Object r4, Continuation r5) {
                com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r6 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c) ((Pair) r4).getSecond();
                int r7 = bwb.b.a;
                MmUiLogScene r8 = MmUiLogScene.RECORDING;
                bwb.b.f(r8, "observeSessionState", "newState=" + r6, MmRecordingViewModel.access$getLogDetail(this.a));
                if (Intrinsics.areEqual(r6, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.k.c) == false) goto L6;
                MmRecordingViewModel r9 = this.a;
                final boolean r0 = this.b;
                r9.setState(new MmRecordingViewModel$observeSessionState$1$1$1(r0));
            L22:
                return Unit.INSTANCE;
            L6:
                if (Intrinsics.areEqual(r6, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.d.c) == false) goto L9;
                this.a.setState(MmRecordingViewModel$observeSessionState$1$1$2.INSTANCE);
                goto L22
            L9:
                if (Intrinsics.areEqual(r6, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.h.c) == false) goto L12;
                this.a.setState(MmRecordingViewModel$observeSessionState$1$1$3.INSTANCE);
                goto L22
            L12:
                if ((r6 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.b) == false) goto L15;
                MmRecordingViewModel.access$markAIInterpretationHeadsetDialogDismissed(this.a, "end recording");
                bwb.b.f(r8, "observeSessionState", "EndRecording, handled by Capacity layer", MmRecordingViewModel.access$getLogDetail(this.a));
                goto L22
            L15:
                if ((r6 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.m) == false) goto L17;
            L20:
                MmRecordingViewModel.access$markAIInterpretationHeadsetDialogDismissed(this.a, "recording ended");
                bwb.b.f(r8, "observeSessionState", "recording ended, state=" + r6, MmRecordingViewModel.access$getLogDetail(this.a));
                goto L22
            L17:
                if (Intrinsics.areEqual(r6, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c.n.c) == true) goto L20;
                bwb.b.a(r8, "observeSessionState", "unhandled state: " + r6, MmRecordingViewModel.access$getLogDetail(this.a));
                goto L22
            }
        }

        public C02501(MmRecordingSession r1, MmRecordingViewModel r2, boolean r3, Continuation<? super C02501> r4) {
            this.$session = r1;
            this.this$0 = r2;
            this.$isD1204Recording = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C02501(this.$session, this.this$0, this.$isD1204Recording, r5);
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
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            b1 r7 = this.$session.t;
            a r2 = new a(this.this$0, this.$isD1204Recording);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeSubtitleDegradation$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "degraded", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeSubtitleDegradation$2", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02522 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02522(MmRecordingViewModel r1, Continuation<? super C02522> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02522 r0 = new C02522(this.this$0, r4);
            r0.Z$0 = ((Boolean) r3).booleanValue();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
        }

        public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
            return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            final boolean r4 = this.Z$0;
            this.this$0.setState(new AnonymousClass1(r4));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeSummaryRepoEvents$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/summary/MmRecordingSummaryRepoEvent;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeSummaryRepoEvents$1", f = "MmRecordingViewModel.kt", i = {}, l = {1264, 1274}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02531 extends SuspendLambda implements Function2<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.d, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02531(MmRecordingViewModel r1, Continuation<? super C02531> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02531 r0 = new C02531(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.d r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.d) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r6);
        L24:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r6);
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.d r7 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.d) this.L$0;
            if ((r7 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.d.a) == false) goto L19;
            if (((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.d.a) r7).a == false) goto L15;
            this.this$0.showFirstMarkFeedbackIfNeeded();
            goto L24
        L15:
            MmRecordingViewModel r8 = this.this$0;
            h.g r2 = new h.g(new svb.a.b(UIHelper.getString(2131894003)));
            this.label = 1;
            if (r8.sendVMEvent(r2, this) != r0) goto L24;
            return r0;
        L19:
            if (Intrinsics.areEqual(r7, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.d.b.a) == false) goto L26;
            MmRecordingViewModel r9 = this.this$0;
            h.i r3 = h.i.a;
            this.label = 2;
            if (r9.sendVMEvent(r3, this) != r0) goto L24;
            return r0;
        L26:
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeToastEvents$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/toast/MmRecordingToastRepoEvent;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeToastEvents$1", f = "MmRecordingViewModel.kt", i = {}, l = {1245}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02541 extends SuspendLambda implements Function2<svb.c, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02541(MmRecordingViewModel r1, Continuation<? super C02541> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02541 r0 = new C02541(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((svb.c) r1, (Continuation) r2);
        }

        public final Object invoke(svb.c r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 != 0) goto L5;
            ResultKt.throwOnFailure(r3);
            svb.c r4 = (svb.c) this.L$0;
            if ((r4 instanceof svb.c.a) == false) goto L15;
            ((svb.c.a) r4).getClass();
            new h.g(null);
            throw null;
        L15:
            throw new NoWhenBranchMatchedException();
        L5:
            if (r0 != 1) goto L9;
            ResultKt.throwOnFailure(r3);
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$refreshAIInterpretationSettingIfReady$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$refreshAIInterpretationSettingIfReady$1", f = "MmRecordingViewModel.kt", i = {}, l = {1160}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $currentMeetingId;
        final /* synthetic */ MmRecordingSession $session;
        final /* synthetic */ String $source;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02551(String r1, MmRecordingViewModel r2, MmRecordingSession r3, String r4, Continuation<? super C02551> r5) {
            this.$source = r1;
            this.this$0 = r2;
            this.$session = r3;
            this.$currentMeetingId = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C02551(this.$source, this.this$0, this.$session, this.$currentMeetingId, r8);
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
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            int r7 = bwb.b.a;
            bwb.b.f(MmUiLogScene.RECORDING, "refreshAIInterpretationSettingIfReady", "source=" + this.$source, MmRecordingViewModel.access$getLogDetail(this.this$0));
            MmRecordingRepo r8 = this.$session.f();
            if (r8 == null) goto L18;
            MmAIInterpretationRepo r9 = r8.q();
            if (r9 == null) goto L18;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a r10 = r9.n();
            if (r10 == null) goto L18;
            String r2 = this.$currentMeetingId;
            this.label = 1;
            if (r10.r0(r2, "", this) != r0) goto L18;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$refreshAINoteTooltipIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$refreshAINoteTooltipIfNeeded$1", f = "MmRecordingViewModel.kt", i = {}, l = {243}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MmRecordingSource $source;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02561(MmRecordingViewModel r1, MmRecordingSource r2, Continuation<? super C02561> r3) {
            this.this$0 = r1;
            this.$source = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02561(this.this$0, this.$source, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            final boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
            Object r6 = ((Result) r5).unbox-impl();
        L11:
            MmRecordingViewModel r3 = this.this$0;
            if (Result.isSuccess-impl(r6) == false) goto L22;
            kvb.a r4 = (kvb.a) r6;
            if (r4 == null) goto L20;
            String[] r7 = r4.a();
            if (r7 == null) goto L20;
            if (ArraysKt.contains(r7, MmRecordingViewModel.AI_NOTE_TOOLTIP_GUIDE_KEY) != true) goto L20;
        L21:
            r3.setState(new MmRecordingViewModel$refreshAINoteTooltipIfNeeded$1$1$1(r2));
        L20:
            r2 = false;
        L22:
            MmRecordingViewModel r8 = this.this$0;
            Throwable r9 = Result.exceptionOrNull-impl(r6);
            if (r9 == null) goto L26;
            int r10 = bwb.b.a;
            bwb.b.d(MmUiLogScene.AI_NOTE, "refreshAINoteTooltipIfNeeded", "getUserGuide failed: " + r9, MmRecordingViewModel.access$getLogDetail(r8));
        L26:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MmRecordingNetHelper r11 = MmRecordingViewModel.access$getMmUccApi$p(this.this$0).G();
            MmRecordingSource r12 = this.$source;
            this.label = 1;
            r6 = r11.q(r12, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$sendAIInterpretationSwitchTipBubbleEvent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$sendAIInterpretationSwitchTipBubbleEvent$1", f = "MmRecordingViewModel.kt", i = {}, l = {1145}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02571(MmRecordingViewModel r1, Continuation<? super C02571> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02571(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            MmRecordingViewModel r5 = this.this$0;
            h.c r2 = h.c.a;
            this.label = 1;
            if (r5.sendVMEvent(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$showFirstMarkFeedbackIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$showFirstMarkFeedbackIfNeeded$1", f = "MmRecordingViewModel.kt", i = {}, l = {300}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02581(MmRecordingViewModel r1, Continuation<? super C02581> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02581(this.this$0, r3);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            MmRecordingViewModel r7 = this.this$0;
            h.g r2 = new h.g(new svb.a.b(UIHelper.getString(2131893999)));
            this.label = 1;
            if (r7.sendVMEvent(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$showFirstMarkFeedbackIfNeeded$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$showFirstMarkFeedbackIfNeeded$2", f = "MmRecordingViewModel.kt", i = {}, l = {313, 316, 322, 332}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02592 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MmRecordingSource $source;
        Object L$0;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02592(MmRecordingViewModel r1, MmRecordingSource r2, Continuation<? super C02592> r3) {
            this.this$0 = r1;
            this.$source = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02592(this.this$0, this.$source, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r6 = true;
            if (r1 == 0) goto L13;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L11;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L10;
            ResultKt.throwOnFailure(r10);
        L39:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            Object r2 = this.L$0;
            ResultKt.throwOnFailure(r10);
        L33:
            MmRecordingViewModel r11 = this.this$0;
            Throwable r4 = Result.exceptionOrNull-impl(r2);
            if (r4 == null) goto L39;
            int r5 = bwb.b.a;
            bwb.b.d(MmUiLogScene.AI_NOTE, "showFirstMarkFeedbackIfNeeded", "getUserGuide failed: " + r4, MmRecordingViewModel.access$getLogDetail(r11));
            h.g r7 = new h.g(new svb.a.b(UIHelper.getString(2131893999)));
            this.L$0 = r2;
            this.label = 4;
            if (r11.sendVMEvent(r7, this) != r0) goto L39;
            return r0;
        L12:
            ResultKt.throwOnFailure(r10);
            Object r12 = ((Result) r10).unbox-impl();
        L16:
            r2 = r12;
            MmRecordingViewModel r13 = this.this$0;
            if (Result.isSuccess-impl(r2) == false) goto L33;
            kvb.a r8 = (kvb.a) r2;
            if (r8 == null) goto L25;
            String[] r9 = r8.a();
            if (r9 == null) goto L25;
            if (ArraysKt.contains(r9, MmRecordingViewModel.FIRST_MARK_TOOLTIP_GUIDE_KEY) != true) goto L25;
        L26:
            if (r6 == false) goto L30;
            h.f r14 = new h.f(UIHelper.getString(2131893986));
            this.L$0 = r2;
            this.label = 2;
            if (r13.sendVMEvent(r14, this) != r0) goto L33;
            return r0;
        L30:
            h.g r15 = new h.g(new svb.a.b(UIHelper.getString(2131893999)));
            this.L$0 = r2;
            this.label = 3;
            if (r13.sendVMEvent(r15, this) != r0) goto L33;
            return r0;
        L25:
            r6 = false;
            goto L26
        L13:
            ResultKt.throwOnFailure(r10);
            MmRecordingNetHelper r16 = MmRecordingViewModel.access$getMmUccApi$p(this.this$0).G();
            MmRecordingSource r3 = this.$source;
            this.label = 1;
            r12 = r16.q(r3, this);
            if (r12 != r0) goto L16;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$updateTitle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$updateTitle$1", f = "MmRecordingViewModel.kt", i = {}, l = {1497, 1500}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $newTitle;
        final /* synthetic */ String $oldTitle;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public C02601(MmRecordingViewModel r1, String r2, String r3, Continuation<? super C02601> r4) {
            this.this$0 = r1;
            this.$oldTitle = r2;
            this.$newTitle = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C02601(this.this$0, this.$oldTitle, this.$newTitle, r5);
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r6);
        L24:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r6);
        L19:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r6);
            MmRecordingMetaRepo r7 = this.this$0.getMetaRepo();
            if (r7 == null) goto L13;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.a r8 = r7.l();
        L14:
            if (r8 != null) goto L20;
            int r9 = bwb.b.a;
            bwb.b.d(MmUiLogScene.RECORDING, "updateTitle", "metaRepo is null", MmRecordingViewModel.access$getLogDetail(this.this$0));
            MmRecordingViewModel r10 = this.this$0;
            h.C0063h r2 = new h.C0063h(this.$oldTitle, false);
            this.label = 1;
            if (r10.sendVMEvent(r2, this) != r0) goto L19;
            return r0;
        L20:
            String r3 = this.$oldTitle;
            String r4 = this.$newTitle;
            this.label = 2;
            if (r8.O(r3, r4, this) != r0) goto L24;
            return r0;
        L13:
            r8 = null;
            goto L14
        }
    }

    static {
        Companion = new a();
    }

    private final String getLogDetail() {
        return (String) this.logDetail$delegate.getValue();
    }

    private final boolean isAudioRetentionEnabled() {
        int r0 = com.ss.android.lark.officesdk.minutes.service.foundation.feature.b.a;
        com.ss.android.lark.officesdk.minutes.service.foundation.feature.a r1 = this.mmUccApi.getFeatureService();
        Intrinsics.checkNotNullParameter(r1, "featureService");
        return r1.h(MmOfficeSdkFeature.RecordAudioSave);
    }

    private final void sendEndRecordingPage() {
        MmRecordingSession r0 = this.session;
        if (r0 != null) goto L6;
        int r1 = bwb.b.a;
        bwb.b.h(MmUiLogScene.RECORDING, "sendEndRecordingPage", "sendEndRecordingPage skip: session is null", getLogDetail());
        return;
    L6:
        ((tvb.a) this.mmUccApi.N().g.getValue()).b(r0.e());
    }

    private final void showOrDeferAIInterpretationSwitchTipBubble() {
        if (this.aiInterpretationHeadsetDialogShowing == false) goto L6;
        int r0 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "showOrDeferAIInterpretationSwitchTipBubble", "defer while headset dialog showing", getLogDetail());
        this.pendingAIInterpretationSwitchTipBubble = true;
        return;
    L6:
        this.pendingAIInterpretationSwitchTipBubble = false;
        sendAIInterpretationSwitchTipBubbleEvent();
    }

    public final void clearNotificationManager() {
        ewb.a r0 = this.notificationProcessor;
        if (r0 == null) goto L5;
        r0.clearAll();
    L5:
        this.notificationProcessor = null;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public i defaultState() {
        return new i(0);
    }

    public final kub.b feedbackService() {
        return (kub.b) this.mmUccApi.u(kub.b.class);
    }

    public final MmRecordingAINoteRepo getAiNoteRepo() {
        MmRecordingSession r0 = this.session;
        if (r0 == null) goto L7;
        MmRecordingRepo r1 = r0.f();
        if (r1 == null) goto L7;
        return r1.r();
    L7:
        return null;
    }

    public final MmRecordingLanguageRepo getLanguageRepo() {
        MmRecordingSession r0 = this.session;
        if (r0 == null) goto L8;
        MmRecordingRepo r1 = r0.f();
        if (r1 == null) goto L8;
        MmRecordingLanguageRepo r2 = r1.l();
        if (r2 == null) goto L8;
        return r2;
    L8:
        MmRecordingSession r3 = this.session;
        if (r3 == null) goto L13;
        MmStandaloneAIInterpretationRootRepo r4 = r3.h();
        if (r4 == null) goto L13;
        return r4.l();
    L13:
        return null;
    }

    public final String getMeetingId() {
        MmRecordingSession r0 = this.session;
        if (r0 == null) goto L7;
        ovb.b r1 = r0.w;
        if (r1 == null) goto L7;
        return r1.a;
    L7:
        return null;
    }

    public final MmRecordingMetaRepo getMetaRepo() {
        MmRecordingSession r0 = this.session;
        if (r0 == null) goto L7;
        MmRecordingRepo r1 = r0.f();
        if (r1 == null) goto L7;
        return r1.w();
    L7:
        return null;
    }

    public final MmRecordingQuotaCtaRepo getQuotaCtaRepo() {
        MmRecordingSession r0 = this.session;
        if (r0 == null) goto L7;
        MmRecordingRepo r1 = r0.f();
        if (r1 == null) goto L7;
        return r1.i();
    L7:
        return null;
    }

    public final MmRecordingSpeakerRepo getSpeakerRepo() {
        MmRecordingSession r0 = this.session;
        if (r0 == null) goto L8;
        MmRecordingRepo r1 = r0.f();
        if (r1 == null) goto L8;
        MmRecordingSpeakerRepo r2 = r1.h();
        if (r2 == null) goto L8;
        return r2;
    L8:
        MmRecordingSession r3 = this.session;
        if (r3 == null) goto L13;
        MmStandaloneAIInterpretationRootRepo r4 = r3.h();
        if (r4 == null) goto L13;
        return r4.h();
    L13:
        return null;
    }

    public final MmRecordingSubtitleRepo getSubtitleRepo() {
        MmRecordingSession r0 = this.session;
        if (r0 == null) goto L8;
        MmRecordingRepo r1 = r0.f();
        if (r1 == null) goto L8;
        MmRecordingSubtitleRepo r2 = r1.x();
        if (r2 == null) goto L8;
        return r2;
    L8:
        MmRecordingSession r3 = this.session;
        if (r3 == null) goto L13;
        MmStandaloneAIInterpretationRootRepo r4 = r3.h();
        if (r4 == null) goto L13;
        return r4.b();
    L13:
        return null;
    }

    public final MmRecordingSummaryRepo getSummaryRepo() {
        MmRecordingSession r0 = this.session;
        if (r0 == null) goto L7;
        MmRecordingRepo r1 = r0.f();
        if (r1 == null) goto L7;
        return r1.y();
    L7:
        return null;
    }

    public final boolean hasTrackerToken() {
        String r0 = getCurrentRecordingId("hasTrackerToken");
        if (r0 != null) goto L5;
        return false;
    L5:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.j r2 = (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.j) this.mmUccApi.N().c.getValue();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "sessionId");
        MmRecordingCommonParam r1 = r2.a.b(r0);
        if (r1 == null) goto L16;
        String r3 = r1.getToken();
        if (r3 != null) goto L10;
        return false;
    L10:
        if (r3.length() <= 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 != true) goto L18;
        return true;
    L18:
        return false;
    L12:
        r4 = false;
        goto L13
    L16:
        return false;
    }

    public final qub.f hostBridge() {
        return (qub.f) this.mmUccApi.u(qub.f.class);
    }

    public final boolean isRecordingActiveForFloat() {
        MmRecordingSession r0 = this.session;
        if (r0 == null) goto L10;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r1 = r0.g();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.a() != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final void markFirstMarkTooltipDismissed() {
        MmRecordingSession r0 = this.session;
        if (r0 == null) goto L7;
        k r1 = r0.f;
        if (r1 == null) goto L7;
        MmRecordingSource r2 = r1.a;
    L8:
        BuildersKt.launch$default(getViewModelScope(), null, null, new C02271(this, r2, null), 3, null);
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void refreshAINoteTooltipIfNeeded() {
        if (this.hasRequestedAiNoteTooltipGuide == false) goto L5;
        return;
    L5:
        int r0 = com.ss.android.lark.officesdk.minutes.service.foundation.feature.b.a;
        if (com.ss.android.lark.officesdk.minutes.service.foundation.feature.b.a(this.mmUccApi.getFeatureService()) == true) goto L8;
        return;
    L8:
        com.ss.android.lark.officesdk.minutes.service.foundation.feature.a r1 = this.mmUccApi.getFeatureService();
        Intrinsics.checkNotNullParameter(r1, "featureService");
        if (r1.h(MmOfficeSdkFeature.RecordingPersonalNotesLiveRewriting) == true) goto L13;
        int r2 = bwb.b.a;
        bwb.b.f(MmUiLogScene.AI_NOTE, "refreshAINoteTooltipIfNeeded", "skip, live rewriting fg disabled", getLogDetail());
        return;
    L13:
        if (hasTrackerToken() == true) goto L15;
        return;
    L15:
        this.hasRequestedAiNoteTooltipGuide = true;
        MmRecordingSession r3 = this.session;
        if (r3 == null) goto L20;
        k r4 = r3.f;
        if (r4 == null) goto L20;
        MmRecordingSource r5 = r4.a;
    L21:
        BuildersKt.launch$default(getViewModelScope(), null, null, new C02561(this, r5, null), 3, null);
        return;
    L20:
        r5 = null;
        goto L21
    }

    public final String resolveSubtitleTranslateLanguage() {
        MmRecordingSession r0 = this.session;
        String r1 = null;
        if (r0 == null) goto L5;
        RecordingSessionType r2 = r0.a;
    L7:
        if (r2 != RecordingSessionType.STANDALONE_AI_INTERPRETATION) goto L18;
        MmStandaloneAIInterpretationRootRepo r3 = r0.h();
        if (r3 == null) goto L18;
        String r4 = r3.o();
        if (r4 == null) goto L18;
        if ((!StringsKt.isBlank(r4)) == true) goto L16;
        r4 = null;
    L16:
        if (r4 == null) goto L18;
        return r4;
    L18:
        if (r0 == null) goto L29;
        MmRecordingRepo r5 = r0.f();
        if (r5 == null) goto L29;
        String r6 = r5.o();
        if (r6 == null) goto L29;
        if ((!StringsKt.isBlank(r6)) == true) goto L27;
        r6 = null;
    L27:
        if (r6 == null) goto L29;
        return r6;
    L29:
        MmRecordingLanguageRepo r7 = getLanguageRepo();
        if (r7 == null) goto L40;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a r8 = r7.l();
        if (r8 == null) goto L40;
        i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f> r9 = r8.b();
        if (r9 == null) goto L40;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f r10 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f) r9.getValue();
        if (r10 == null) goto L40;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r11 = r10.d;
        if (r11 == null) goto L40;
        r1 = r11.a;
    L40:
        if (r1 != null) goto L43;
        return "";
    L43:
        return r1;
    L5:
        r2 = null;
        goto L7
    }

    public final void showFirstMarkFeedbackIfNeeded() {
        if (this.hasRequestedFirstMarkTooltipGuide == false) goto L6;
        BuildersKt.launch$default(getViewModelScope(), null, null, new C02581(this, null), 3, null);
        return;
    L6:
        MmRecordingSession r0 = this.session;
        if (r0 == null) goto L11;
        k r1 = r0.f;
        if (r1 == null) goto L11;
        MmRecordingSource r2 = r1.a;
    L12:
        this.hasRequestedFirstMarkTooltipGuide = true;
        BuildersKt.launch$default(getViewModelScope(), null, null, new C02592(this, r2, null), 3, null);
        return;
    L11:
        r2 = null;
        goto L12
    }

    public final void trackAINoteEntryClickIfNeeded() {
        int r0 = com.ss.android.lark.officesdk.minutes.service.foundation.feature.b.a;
        if (com.ss.android.lark.officesdk.minutes.service.foundation.feature.b.a(this.mmUccApi.getFeatureService()) == true) goto L6;
        return;
    L6:
        if (hasTrackerToken() == true) goto L8;
        return;
    L8:
        trackPageClick("ai_notes_entry", MapsKt.mapOf(TuplesKt.to("is_enable", getAINoteEnableStatus$officesdk_minutes_base_ui_release())));
    }

    public final void trackAINoteEntryViewIfNeeded() {
        if (this.hasTrackedAiNotesRecordingView == false) goto L5;
        return;
    L5:
        int r0 = com.ss.android.lark.officesdk.minutes.service.foundation.feature.b.a;
        if (com.ss.android.lark.officesdk.minutes.service.foundation.feature.b.a(this.mmUccApi.getFeatureService()) == true) goto L9;
        return;
    L9:
        if (hasTrackerToken() == true) goto L11;
        return;
    L11:
        String r1 = getAINoteEnableStatus$officesdk_minutes_base_ui_release();
        this.hasTrackedAiNotesRecordingView = true;
        trackPageView("ai_notes_entry", MapsKt.mapOf(TuplesKt.to("is_enable", r1)));
    }

    public final void trackAINoteOnboardingCloseClickIfNeeded() {
        String r0 = getCurrentRecordingId("trackAINoteOnboardingCloseClickIfNeeded");
        if (r0 != null) goto L5;
        return;
    L5:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.g r1 = this.mmUccApi.N().a();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "sessionId");
        Intrinsics.checkNotNullParameter("close", PickerReporterConstants.KEY.CLICK);
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r2 = r1.a;
        JSONObject r4 = new JSONObject();
        r4.put("scene", "record");
        r2.g(r0, "vc_minutes_ai_notes_onboarding_click", r4.put(PickerReporterConstants.KEY.CLICK, "close"));
    }

    public final void trackAINoteOnboardingViewIfNeeded() {
        if (this.hasTrackedAiNotesOnboardingView == false) goto L5;
        return;
    L5:
        String r0 = getCurrentRecordingId("trackAINoteOnboardingViewIfNeeded");
        if (r0 != null) goto L8;
        return;
    L8:
        this.hasTrackedAiNotesOnboardingView = true;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.g r1 = this.mmUccApi.N().a();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "sessionId");
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r2 = r1.a;
        JSONObject r3 = new JSONObject();
        r3.put("scene", "record");
        r2.g(r0, "vc_minutes_ai_notes_onboarding_view", r3);
    }

    public final void trackPageBackgroundRunEnd() {
        int r0 = bwb.b.a;
        MmUiLogScene r1 = MmUiLogScene.RECORDING;
        StringBuilder r2 = new StringBuilder("recording=");
        MmRecordingSession r3 = this.session;
        if (r3 == null) goto L5;
        String r4 = r3.e();
    L6:
        r2.append(r4);
        bwb.b.f(r1, "trackPageBackgroundRunEnd", r2.toString(), getLogDetail());
        String r5 = getCurrentRecordingId("trackPageBackgroundRunEnd");
        if (r5 != null) goto L9;
        return;
    L9:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.h r6 = (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.h) this.mmUccApi.N().e.getValue();
        monitor-enter(r6);
        Intrinsics.checkNotNullParameter(r5, "sessionId");     // Catch: Throwable -> L25
        lvb.a.e("MmRecordingBackgroundRunTracker", "onPageDestroyed");     // Catch: Throwable -> L25
        if (r5.length() != 0) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L19;
        lvb.a.h("MmRecordingBackgroundRunTracker", "[onPageDestroyed] skip: sessionId is empty");     // Catch: Throwable -> L25
        monitor-exit(r6);
        return;
    L19:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.h.b r8 = (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.h.b) ((LinkedHashMap) r6.b).get(r5);     // Catch: Throwable -> L25
        if (r8 == null) goto L22;
        r6.b(r5, r8);     // Catch: Throwable -> L25
    L22:
        r6.b.remove(r5);     // Catch: Throwable -> L25
        monitor-exit(r6);
        return;
    L14:
        r7 = false;
    L25:
        th = move-exception;
        throw th;
    L5:
        r4 = null;
        goto L6
    }

    public final void trackPageBackgroundRunStart() {
        int r0 = bwb.b.a;
        MmUiLogScene r1 = MmUiLogScene.RECORDING;
        StringBuilder r2 = new StringBuilder("recording=");
        MmRecordingSession r3 = this.session;
        if (r3 == null) goto L5;
        String r4 = r3.e();
    L6:
        r2.append(r4);
        bwb.b.f(r1, "trackPageBackgroundRunStart", r2.toString(), getLogDetail());
        String r5 = getCurrentRecordingId("trackPageBackgroundRunStart");
        if (r5 != null) goto L9;
        return;
    L9:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.h r6 = (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.h) this.mmUccApi.N().e.getValue();
        monitor-enter(r6);
        Intrinsics.checkNotNullParameter(r5, "sessionId");     // Catch: Throwable -> L25
        lvb.a.e("MmRecordingBackgroundRunTracker", "onPageBackground");     // Catch: Throwable -> L25
        if (r5.length() != 0) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L19;
        lvb.a.h("MmRecordingBackgroundRunTracker", "[onPageBackground] skip: sessionId is empty");     // Catch: Throwable -> L25
        monitor-exit(r6);
        return;
    L19:
        LinkedHashMap r8 = (LinkedHashMap) r6.b;     // Catch: Throwable -> L25
        Object r9 = r8.get(r5);     // Catch: Throwable -> L25
        if (r9 != null) goto L22;
        r9 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.h.b();     // Catch: Throwable -> L25
        r8.put(r5, r9);     // Catch: Throwable -> L25
    L22:
        r6.a(r5, (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.h.b) r9);     // Catch: Throwable -> L25
        monitor-exit(r6);
        return;
    L14:
        r7 = false;
    L25:
        th = move-exception;
        throw th;
    L5:
        r4 = null;
        goto L6
    }

    public final void trackPageBackgroundRunStop() {
        int r0 = bwb.b.a;
        MmUiLogScene r1 = MmUiLogScene.RECORDING;
        StringBuilder r2 = new StringBuilder("recording=");
        MmRecordingSession r3 = this.session;
        if (r3 == null) goto L5;
        String r4 = r3.e();
    L6:
        r2.append(r4);
        bwb.b.f(r1, "trackPageBackgroundRunStop", r2.toString(), getLogDetail());
        String r5 = getCurrentRecordingId("trackPageBackgroundRunStop");
        if (r5 != null) goto L9;
        return;
    L9:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.h r6 = (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.h) this.mmUccApi.N().e.getValue();
        monitor-enter(r6);
        Intrinsics.checkNotNullParameter(r5, "sessionId");     // Catch: Throwable -> L24
        if (r5.length() != 0) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L19;
        lvb.a.h("MmRecordingBackgroundRunTracker", "[onPageForeground] skip: sessionId is empty");     // Catch: Throwable -> L24
        monitor-exit(r6);
        return;
    L19:
        lvb.a.e("MmRecordingBackgroundRunTracker", "onPageForeground");     // Catch: Throwable -> L24
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.h.b r8 = (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.h.b) ((LinkedHashMap) r6.b).get(r5);     // Catch: Throwable -> L24
        if (r8 == null) goto L22;
        r6.b(r5, r8);     // Catch: Throwable -> L24
    L22:
        monitor-exit(r6);
        return;
    L14:
        r7 = false;
    L24:
        th = move-exception;
        throw th;
    L5:
        r4 = null;
        goto L6
    }

    private final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c currentQuotaCtaEntity() {
        MmRecordingQuotaCtaRepo r0 = getQuotaCtaRepo();
        if (r0 == null) goto L7;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.a r1 = r0.l();
        if (r1 == null) goto L7;
        return r1.m();
    L7:
        return null;
    }

    private final void observeRecordingLanguage() {
        MmRecordingLanguageRepo r0 = getLanguageRepo();
        if (r0 == null) goto L11;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a r1 = r0.l();
        if (r1 == null) goto L12;
        i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f> r2 = r1.b();
        if (r2 == null) goto L13;
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r2, getViewModelScope(), C02381.INSTANCE, null, new C02402(this, null), 12);
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r2, getViewModelScope(), C02413.INSTANCE, null, new C02424(this, null), 12);
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r2, getViewModelScope(), C02435.INSTANCE, null, new C02446(this, null), 12);
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r2, getViewModelScope(), C02457.INSTANCE, null, new C02468(this, null), 12);
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r2, getViewModelScope(), C02479.INSTANCE, null, new C023910(this, null), 12);
        return;
    L13:
        return;
    L12:
        return;
    }

    private final void observeSubtitleDegradation() {
        MmRecordingSubtitleRepo r0 = getSubtitleRepo();
        if (r0 == null) goto L10;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.a r1 = r0.l();
        if (r1 == null) goto L11;
        i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.d> r2 = r1.b();
        if (r2 == null) goto L12;
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r2, getViewModelScope(), C02511.INSTANCE, null, new C02522(this, null), 12);
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void sendAIInterpretationSwitchTipBubbleEvent() {
        BuildersKt.launch$default(getViewModelScope(), null, null, new C02571(this, null), 3, null);
    }

    public final void consumeAndDismissAINoteTooltip() {
        if (getState().t == true) goto L5;
        return;
    L5:
        markAINoteTooltipDismissed();
    }

    public final String getAINoteEnableStatus$officesdk_minutes_base_ui_release() {
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r0 = currentQuotaCtaEntity();
        boolean r1 = false;
        if (r0 == null) goto L9;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r2 = r0.a;
        if (r2 == null) goto L9;
        if (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.f.a(r2) != true) goto L9;
        r1 = true;
    L9:
        if (r1 == false) goto L11;
        return "no_asr";
    L11:
        return "enable";
    }

    public final boolean hasAINoteQuotaData() {
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r0 = currentQuotaCtaEntity();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.f.b(r0) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isAINoteAsrQuotaExceeded() {
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r0 = currentQuotaCtaEntity();
        if (r0 == null) goto L10;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r1 = r0.a;
        if (r1 != null) goto L7;
        return false;
    L7:
        if (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.f.a(r1) != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final void markAINoteTooltipDismissed() {
        if (getState().t == true) goto L5;
        return;
    L5:
        setState(C02251.INSTANCE);
        MmRecordingSession r0 = this.session;
        if (r0 == null) goto L10;
        k r1 = r0.f;
        if (r1 == null) goto L10;
        MmRecordingSource r2 = r1.a;
    L11:
        BuildersKt.launch$default(getViewModelScope(), null, null, new C02262(this, r2, null), 3, null);
        return;
    L10:
        r2 = null;
        goto L11
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public void onCleared() {
        super.onCleared();
        clearNotificationManager();
    }

    public final MmRecordingSession getSession() {
        return this.session;
    }

    public final MmRecordingUILaunchMode getUiLaunchMode() {
        return this.uiLaunchMode;
    }

    public final MmRecordingUiProviders getUiProviders() {
        return this.uiProviders;
    }

    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a getUserContext() {
        return this.mmUccApi;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public /* bridge */ /* synthetic */ l defaultState() {
        return defaultState();
    }

    public MmRecordingViewModel(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2) {
        Intrinsics.checkNotNullParameter(r2, "mmUccApi");
        this.mmUccApi = r2;
        this.logDetail$delegate = LazyKt.lazy(new MmRecordingViewModel$logDetail$2(this));
        this.autoSaveDialogLimiter = new c();
        MmRecordingUiProviders r3 = MmRecordingUiProviders.h;
        this.uiProviders = MmRecordingUiProviders.h;
        this.uiLaunchMode = MmRecordingUILaunchMode.UNKNOWN;
    }

    public static final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c access$currentQuotaCtaEntity(MmRecordingViewModel r0) {
        return r0.currentQuotaCtaEntity();
    }

    public static final /* synthetic */ c access$getAutoSaveDialogLimiter$p(MmRecordingViewModel r0) {
        return r0.autoSaveDialogLimiter;
    }

    public static final /* synthetic */ String access$getLogDetail(MmRecordingViewModel r0) {
        return r0.getLogDetail();
    }

    public static final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a access$getMmUccApi$p(MmRecordingViewModel r0) {
        return r0.mmUccApi;
    }

    public static final /* synthetic */ CoroutineScope access$getViewModelScope(MmRecordingViewModel r0) {
        return r0.getViewModelScope();
    }

    public static final /* synthetic */ boolean access$isAudioRetentionEnabled(MmRecordingViewModel r0) {
        return r0.isAudioRetentionEnabled();
    }

    public static final /* synthetic */ void access$sendEndRecordingPage(MmRecordingViewModel r0) {
        r0.sendEndRecordingPage();
    }

    private final void checkAutoSaveBeforeRecordFinish(MmRecordingSession r8) {
        if (this.hasPendingFinishAudioSaveCheck == false) goto L6;
        int r9 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "checkAutoSaveBeforeRecordFinish", "skip duplicate check", getLogDetail());
        return;
    L6:
        this.hasPendingFinishAudioSaveCheck = true;
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass1(r8, this, null), 3, null);
    }

    private final String getCurrentRecordingId(String r5) {
        MmRecordingSession r0 = this.session;
        if (r0 == null) goto L16;
        String r1 = r0.e();
        if (r1 == null) goto L16;
        if (r1.length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L16;
        return r1;
    L9:
        r2 = false;
    L16:
        int r3 = bwb.b.a;
        bwb.b.d(MmUiLogScene.RECORDING, r5, "session not found", getLogDetail());
        return null;
    }

    private final void markAIInterpretationHeadsetDialogDismissed(String r2) {
        markAIInterpretationHeadsetDialogDismissed(r2, false);
    }

    private final void observeAIInterpretation(MmRecordingSession r11) {
        if (r11.a != RecordingSessionType.HARDWARE_RECORDING) goto L6;
        int r12 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "observeAIInterpretation", "skip hardware recording", getLogDetail());
        return;
    L6:
        MmRecordingRepo r0 = r11.f();
        if (r0 == null) goto L15;
        MmAIInterpretationRepo r1 = r0.q();
        if (r1 == null) goto L15;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a r2 = r1.n();
        if (r2 == null) goto L15;
        i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.d> r3 = r2.b();
        if (r3 == null) goto L15;
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r3, getViewModelScope(), MmRecordingViewModel$observeAIInterpretation$1$1.INSTANCE, null, new MmRecordingViewModel$observeAIInterpretation$1$2(this, null), 12);
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r3, getViewModelScope(), MmRecordingViewModel$observeAIInterpretation$1$3.INSTANCE, null, new MmRecordingViewModel$observeAIInterpretation$1$4(this, null), 12);
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r3, getViewModelScope(), MmRecordingViewModel$observeAIInterpretation$1$5.INSTANCE, null, new MmRecordingViewModel$observeAIInterpretation$1$6(this, null), 12);
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r3, getViewModelScope(), MmRecordingViewModel$observeAIInterpretation$1$7.INSTANCE, null, new MmRecordingViewModel$observeAIInterpretation$1$8(this, null), 12);
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r3, getViewModelScope(), MmRecordingViewModel$observeAIInterpretation$1$9.INSTANCE, null, new MmRecordingViewModel$observeAIInterpretation$1$10(this, null), 12);
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r3, getViewModelScope(), MmRecordingViewModel$observeAIInterpretation$1$11.INSTANCE, null, new MmRecordingViewModel$observeAIInterpretation$1$12(this, null), 12);
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r3, getViewModelScope(), MmRecordingViewModel$observeAIInterpretation$1$13.INSTANCE, null, new MmRecordingViewModel$observeAIInterpretation$1$14(this, null), 12);
    L15:
        MmRecordingRepo r13 = r11.f();
        if (r13 == null) goto L23;
        MmAIInterpretationRepo r14 = r13.q();
        if (r14 == null) goto L24;
        d1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.i> r15 = r14.e();
        if (r15 == null) goto L25;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r15, new C02282(this, null)), getViewModelScope());
        return;
    L25:
        return;
    L24:
        return;
    }

    private final void observeAudioSaveSetting(MmRecordingSession r12) {
        MmRecordingRepo r0 = r12.f();
        if (r0 == null) goto L33;
        MmRecordingAudioSaveRepo r1 = r0.s();
        if (r1 == null) goto L34;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.b r2 = r1.m();
        if (r2 == null) goto L35;
        i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.f> r7 = r2.b();
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r7, getViewModelScope(), MmRecordingViewModel$observeAudioSaveSetting$1$1.INSTANCE, null, new MmRecordingViewModel$observeAudioSaveSetting$1$2(this, null), 12);
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r7, getViewModelScope(), MmRecordingViewModel$observeAudioSaveSetting$1$3.INSTANCE, null, new MmRecordingViewModel$observeAudioSaveSetting$1$4(this, null), 12);
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r7, getViewModelScope(), MmRecordingViewModel$observeAudioSaveSetting$1$5.INSTANCE, null, new MmRecordingViewModel$observeAudioSaveSetting$1$6(this, r2, null), 12);
        k r3 = r12.f;
        if (r3 == null) goto L12;
        MmRecordingSource r4 = r3.a;
    L14:
        if (r4 != MmRecordingSource.FEISHU_HARDWARE_D1204) goto L17;
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r7, getViewModelScope(), C02292.INSTANCE, null, new C02303(this, null), 12);
        return;
    L17:
        MmRecordingRepo r13 = r12.f();
        if (r13 == null) goto L24;
        MmRecordingQuotaCtaRepo r14 = r13.i();
        if (r14 == null) goto L24;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.a r15 = r14.l();
        if (r15 == null) goto L24;
        i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c> r16 = r15.b();
    L25:
        if (r16 != null) goto L27;
    L31:
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r7, getViewModelScope(), C02314.INSTANCE, null, new C02325(this, null), 12);
        return;
    L27:
        if (isAudioRetentionEnabled() == false) goto L31;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(new v0(r7, r16, new C02336(this, null)), new C02347(this, null)), getViewModelScope());
        return;
    L24:
        r16 = null;
        goto L25
    L12:
        r4 = null;
        goto L14
    L35:
        return;
    L34:
        return;
    }

    private final void observeEndWindowRepoEvents(MmRecordingSession r4) {
        MmRecordingRepo r0 = r4.f();
        if (r0 == null) goto L10;
        MmRecordingEndWindowRepo r1 = r0.u();
        if (r1 == null) goto L11;
        final d1<Object> r2 = r1.e();
        if (r2 == null) goto L12;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(new FlowKt__LimitKt$take$.inlined.unsafeFlow.1(new MmRecordingViewModel$observeEndWindowRepoEvents$$inlined$filterIsInstance$1(r2)), new C02351(this, r4, null)), getViewModelScope());
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void observeHasUnviewedSummary(MmRecordingSession r7) {
        MmRecordingRepo r8 = r7.f();
        if (r8 == null) goto L12;
        MmRecordingSummaryRepo r9 = r8.y();
        if (r9 == null) goto L13;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.a r10 = r9.l();
        if (r10 == null) goto L14;
        i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.c> r0 = r10.b();
        if (r0 == null) goto L15;
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r0, getViewModelScope(), MmRecordingViewModel$observeHasUnviewedSummary$1$1.INSTANCE, null, new MmRecordingViewModel$observeHasUnviewedSummary$1$2(this, null), 12);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    private final void observeLanguageRepoEvents(MmRecordingSession r3) {
        MmRecordingRepo r4 = r3.f();
        if (r4 == null) goto L10;
        MmRecordingLanguageRepo r5 = r4.l();
        if (r5 == null) goto L11;
        d1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.g> r6 = r5.e();
        if (r6 == null) goto L12;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r6, new C02361(this, null)), getViewModelScope());
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void observeLocationInfo(MmRecordingSession r7) {
        MmRecordingRepo r8 = r7.f();
        if (r8 == null) goto L12;
        MmRecordingLocationRepo r9 = r8.v();
        if (r9 == null) goto L13;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.a r10 = r9.m();
        if (r10 == null) goto L14;
        i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.d> r0 = r10.b();
        if (r0 == null) goto L15;
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r0, getViewModelScope(), MmRecordingViewModel$observeLocationInfo$1$1.INSTANCE, null, new MmRecordingViewModel$observeLocationInfo$1$2(this, null), 12);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    private final void observeMetaRepoEvents(MmRecordingSession r3) {
        MmRecordingRepo r4 = r3.f();
        if (r4 == null) goto L10;
        MmRecordingMetaRepo r5 = r4.w();
        if (r5 == null) goto L11;
        d1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.c> r6 = r5.e();
        if (r6 == null) goto L12;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r6, new C02371(this, null)), getViewModelScope());
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void observeRecordingMetaInfo(MmRecordingSession r10) {
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r10.o, new C02481(this, null)), getViewModelScope());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r10.p, new C02492(this, null)), getViewModelScope());
        MmRecordingMetaRepo r11 = getMetaRepo();
        if (r11 == null) goto L10;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.a r12 = r11.l();
        if (r12 == null) goto L11;
        i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.b> r13 = r12.b();
        if (r13 == null) goto L12;
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r13, getViewModelScope(), MmRecordingViewModel$observeRecordingMetaInfo$3$1.INSTANCE, null, new MmRecordingViewModel$observeRecordingMetaInfo$3$2(this, null), 12);
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r13, getViewModelScope(), MmRecordingViewModel$observeRecordingMetaInfo$3$3.INSTANCE, null, new MmRecordingViewModel$observeRecordingMetaInfo$3$4(this, null), 12);
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r13, getViewModelScope(), MmRecordingViewModel$observeRecordingMetaInfo$3$5.INSTANCE, null, new MmRecordingViewModel$observeRecordingMetaInfo$3$6(this, null), 12);
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r13, getViewModelScope(), MmRecordingViewModel$observeRecordingMetaInfo$3$7.INSTANCE, null, new MmRecordingViewModel$observeRecordingMetaInfo$3$8(this, null), 12);
        com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.a.a(r13, getViewModelScope(), MmRecordingViewModel$observeRecordingMetaInfo$3$9.INSTANCE, null, new MmRecordingViewModel$observeRecordingMetaInfo$3$10(this, null), 12);
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void observeSessionState(MmRecordingSession r9) {
        k r0 = r9.f;
        if (r0 == null) goto L5;
        MmRecordingSource r1 = r0.a;
    L7:
        if (r1 != MmRecordingSource.FEISHU_HARDWARE_D1204) goto L9;
        boolean r2 = true;
    L10:
        BuildersKt.launch$default(getViewModelScope(), null, null, new C02501(r9, this, r2, null), 3, null);
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    private final void observeSummaryRepoEvents(MmRecordingSession r3) {
        MmRecordingRepo r4 = r3.f();
        if (r4 == null) goto L10;
        MmRecordingSummaryRepo r5 = r4.y();
        if (r5 == null) goto L11;
        d1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.d> r6 = r5.e();
        if (r6 == null) goto L12;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r6, new C02531(this, null)), getViewModelScope());
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void observeToastEvents(MmRecordingSession r3) {
        MmRecordingRepo r4 = r3.f();
        if (r4 == null) goto L10;
        svb.b r5 = (svb.b) r4.o.getValue();
        if (r5 == null) goto L11;
        d1<svb.c> r6 = r5.e();
        if (r6 == null) goto L12;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r6, new C02541(this, null)), getViewModelScope());
        return;
    L12:
        return;
    L11:
        return;
    }

    private final MmQuotaType quotaTypeOrNull(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r2) {
        if ((r2 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c) == false) goto L6;
        return ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c) r2).a;
    L6:
        if ((r2 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) == false) goto L9;
        return ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) r2).a;
    L9:
        if (Intrinsics.areEqual(r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.a.a) == false) goto L11;
    L15:
        return null;
    L11:
        if (Intrinsics.areEqual(r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.b.a) == true) goto L15;
        throw new NoWhenBranchMatchedException();
    }

    private final int toForceAudioSaveToastRes(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r2) {
        if ((r2 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c) == false) goto L6;
        MmRecordingQuotaCtaRenderType r3 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.c) r2).d;
    L17:
        int r4 = b.a[r3.ordinal()];
        if (r4 != 1) goto L20;
        return 2131894030;
    L20:
        if (r4 != 2) goto L22;
        return 2131894031;
    L22:
        if (r4 != 3) goto L25;
        return 2131894032;
    L25:
        throw new NoWhenBranchMatchedException();
    L6:
        if ((r2 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) == false) goto L9;
        r3 = ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.d) r2).d;
        goto L17
    L9:
        if (Intrinsics.areEqual(r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.a.a) == false) goto L11;
    L16:
        r3 = MmRecordingQuotaCtaRenderType.Default;
        goto L17
    L11:
        if (Intrinsics.areEqual(r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h.b.a) == true) goto L16;
        if (r2 == null) goto L16;
        throw new NoWhenBranchMatchedException();
    }

    public void dispatchEvent(g r11) {
        Intrinsics.checkNotNullParameter(r11, "event");
        int r0 = bwb.b.a;
        MmUiLogScene r1 = MmUiLogScene.RECORDING;
        bwb.b.f(r1, "dispatchEvent", r11.toString(), getLogDetail());
        if ((r11 instanceof g.t) == false) goto L15;
        MmRecordingMetaRepo r2 = getMetaRepo();
        if (r2 == null) goto L9;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.a r3 = r2.l();
        if (r3 == null) goto L9;
        r3.k(((g.t) r11).a);
    L9:
        MmRecordingSummaryRepo r4 = getSummaryRepo();
        if (r4 == null) goto L120;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary.a r5 = r4.l();
        if (r5 == null) goto L121;
        r5.S(((g.t) r11).a);
        return;
    L121:
        return;
    L120:
        return;
    L15:
        if ((r11 instanceof g.j) == false) goto L18;
        BuildersKt.launch$default(getViewModelScope(), null, null, new C02231(this, null), 3, null);
        return;
    L18:
        if ((r11 instanceof g.s) == false) goto L21;
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass2(this, null), 3, null);
        return;
    L21:
        if ((r11 instanceof g.i) == false) goto L24;
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass3(this, null), 3, null);
        return;
    L24:
        if ((r11 instanceof g.q) == false) goto L27;
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass4(this, r11, null), 3, null);
        return;
    L27:
        if ((r11 instanceof g.r) == false) goto L30;
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass5(this, r11, null), 3, null);
        return;
    L30:
        if ((r11 instanceof g.p) == false) goto L33;
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass6(this, r11, null), 3, null);
        return;
    L33:
        if ((r11 instanceof g.v) == false) goto L36;
        g.v r12 = (g.v) r11;
        updateTitle(r12.a, r12.b);
        return;
    L36:
        if ((r11 instanceof g.d) == false) goto L39;
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass7(this, null), 3, null);
        return;
    L39:
        if ((r11 instanceof g.a) == false) goto L42;
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass8(this, null), 3, null);
        return;
    L42:
        if ((r11 instanceof g.m) == false) goto L45;
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass9(this, r11, null), 3, null);
        return;
    L45:
        if ((r11 instanceof g.n) == false) goto L48;
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass10(this, r11, null), 3, null);
        return;
    L48:
        if (Intrinsics.areEqual(r11, g.b.a) == false) goto L51;
        markAIInterpretationHeadsetDialogDismissed("user dismissed", true);
        return;
    L51:
        if (Intrinsics.areEqual(r11, g.c.a) == false) goto L54;
        showOrDeferAIInterpretationSwitchTipBubble();
        return;
    L54:
        if ((r11 instanceof g.o) == false) goto L57;
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass11(this, r11, null), 3, null);
        return;
    L57:
        if (Intrinsics.areEqual(r11, g.f.a) == false) goto L68;
        MmRecordingSession r13 = this.session;
        if (r13 == null) goto L137;
        MmRecordingRepo r14 = r13.f();
        if (r14 == null) goto L138;
        MmRecordingAudioSaveRepo r15 = r14.s();
        if (r15 == null) goto L139;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.b r16 = r15.m();
        if (r16 == null) goto L140;
        r16.C0();
        return;
    L140:
        return;
    L139:
        return;
    L138:
        return;
    L137:
        return;
    L68:
        if (Intrinsics.areEqual(r11, g.e.a) == false) goto L79;
        MmRecordingSession r17 = this.session;
        if (r17 == null) goto L142;
        MmRecordingRepo r18 = r17.f();
        if (r18 == null) goto L143;
        MmRecordingAudioSaveRepo r19 = r18.s();
        if (r19 == null) goto L144;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.b r110 = r19.m();
        if (r110 == null) goto L145;
        r110.l();
        return;
    L145:
        return;
    L144:
        return;
    L143:
        return;
    L142:
        return;
    L79:
        if ((r11 instanceof g.C0062g) == false) goto L90;
        g.C0062g r111 = (g.C0062g) r11;
        if (r111.a == MmRecordingAutoSaveDecisionScene.RECORD_FINISH) goto L84;
        bwb.b.f(r1, "dispatchEvent", "ignore auto save dialog closed, scene=" + r111.a, getLogDetail());
        return;
    L84:
        MmRecordingSession r112 = this.session;
        if (r112 != null) goto L88;
        bwb.b.d(r1, "dispatchEvent", "unexpected, session not found", getLogDetail());
        return;
    L88:
        sendRecordStopEventAfterAudioSaveCheck(r112, EndRecordingReason.RECORD_FINISH_AUDIO_SAVE_CONTINUE, "auto save dialog closed");
        return;
    L90:
        if ((r11 instanceof g.l) == false) goto L93;
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass12(this, null), 3, null);
        return;
    L93:
        if ((r11 instanceof g.h) == false) goto L96;
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass13(this, r11, null), 3, null);
        return;
    L96:
        if ((r11 instanceof g.k) == false) goto L107;
        MmRecordingSession r6 = this.session;
        if (r6 == null) goto L150;
        MmRecordingRepo r7 = r6.f();
        if (r7 == null) goto L151;
        MmRecordingLocationRepo r8 = r7.v();
        if (r8 == null) goto L152;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.a r9 = r8.m();
        if (r9 == null) goto L153;
        r9.r(((g.k) r11).a);
        return;
    L153:
        return;
    L152:
        return;
    L151:
        return;
    L150:
        return;
    L107:
        if ((r11 instanceof g.u) == false) goto L119;
        MmRecordingSession r10 = this.session;
        if (r10 == null) goto L155;
        MmRecordingRepo r20 = r10.f();
        if (r20 == null) goto L156;
        MmRecordingLocationRepo r21 = r20.v();
        if (r21 == null) goto L157;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.a r22 = r21.m();
        if (r22 == null) goto L158;
        r22.x0(((g.u) r11).a);
        return;
    L158:
        return;
    L157:
        return;
    L156:
        return;
    L155:
        return;
    L119:
        throw new NoWhenBranchMatchedException();
    }

    public final void refreshQuotaAfterUpgradeReturnIfNeeded(String r5) {
        Intrinsics.checkNotNullParameter(r5, "from");
        if (this.pendingRefreshQuotaAfterUpgradeReturn == true) goto L5;
        return;
    L5:
        this.pendingRefreshQuotaAfterUpgradeReturn = false;
        int r0 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "refreshQuotaAfterUpgradeReturnIfNeeded", "from=" + r5, getLogDetail());
        MmRecordingQuotaCtaRepo r1 = getQuotaCtaRepo();
        if (r1 == null) goto L11;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.a r2 = r1.l();
        if (r2 == null) goto L12;
        r2.B0("upgradeReturn:" + r5);
        return;
    L12:
        return;
    }

    public final void trackAIInterpretationView(boolean r7) {
        String r0 = getCurrentRecordingId("trackAIInterpretationView");
        if (r0 != null) goto L5;
        return;
    L5:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.f r1 = (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.f) this.mmUccApi.N().f.getValue();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "sessionId");
        MmRecordingCommonParam r2 = r1.a.b(r0);
        if (r2 == null) goto L10;
        boolean r4 = true;
        if (r2.isValid() != true) goto L10;
    L11:
        if (r4 == true) goto L13;
        lvb.a.b("MmRecordingAIInterpretationTracker", "[trackView] commonParam invalid");
        return;
    L13:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r3 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r3.e("view_scene", "ai_si");
        if (r7 == false) goto L16;
        String r8 = "open";
    L17:
        r3.e("is_ai_si_open", r8);
        r3.e("entrance", r2.getEntrance());
        r1.a.g(r0, "vc_navigation_minutes_recording_view", r3.a());
        return;
    L16:
        r8 = "close";
    L10:
        r4 = false;
        goto L11
    }

    public final void trackQuotaCtaClick(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r7) {
        Intrinsics.checkNotNullParameter(r7, "state");
        String r1 = getCurrentRecordingId("trackQuotaCtaClick");
        if (r1 != null) goto L5;
        return;
    L5:
        MmQuotaType r2 = quotaTypeOrNull(r7);
        if (r2 != null) goto L8;
        return;
    L8:
        this.pendingRefreshQuotaAfterUpgradeReturn = true;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.k r4 = (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.k) this.mmUccApi.N().j.getValue();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r7, "state");
        Intrinsics.checkNotNullParameter(r7, "state");
        JSONObject r8 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.k.a(r7);
        if (r8 == null) goto L11;
        r8.put(PickerReporterConstants.KEY.CLICK, "go_upgrade");
        r8.put(PickerReporterConstants.KEY.TARGET, "none");
        r8.put("cta_style", 1);
    L12:
        if (r8 == null) goto L15;
        r4.a.g(r1, "common_pricing_popup_click", r8);
    L15:
        MmRecordingQuotaCtaRepo r9 = getQuotaCtaRepo();
        if (r9 == null) goto L21;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.a r10 = r9.l();
        if (r10 == null) goto L22;
        r10.B(r2);
        return;
    L22:
        return;
    L21:
        return;
    L11:
        r8 = null;
        goto L12
    }

    public final void trackQuotaCtaView(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        String r1 = getCurrentRecordingId("trackQuotaCtaView");
        if (r1 != null) goto L5;
        return;
    L5:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.k r2 = (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.k) this.mmUccApi.N().j.getValue();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r5, "state");
        Intrinsics.checkNotNullParameter(r5, "state");
        JSONObject r6 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.k.a(r5);
        if (r6 == null) goto L8;
        r6.put("view_type", "go_upgrade");
        r6.put("cta_style", 1);
    L9:
        if (r6 == null) goto L13;
        r2.a.g(r1, "common_pricing_popup_view", r6);
        return;
    L13:
        return;
    L8:
        r6 = null;
        goto L9
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.MviViewModel
    public /* bridge */ /* synthetic */ void dispatchEvent(com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j r1) {
        dispatchEvent((g) r1);
    }

    public static final /* synthetic */ void access$checkAutoSaveBeforeRecordFinish(MmRecordingViewModel r0, MmRecordingSession r1) {
        r0.checkAutoSaveBeforeRecordFinish(r1);
    }

    public static final /* synthetic */ void access$markAIInterpretationHeadsetDialogDismissed(MmRecordingViewModel r0, String r1) {
        r0.markAIInterpretationHeadsetDialogDismissed(r1);
    }

    private final Object linkSubtitleTranslationIfNeeded(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r9, Continuation<? super Unit> r10) {
        MmRecordingSession r11 = this.session;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h r0 = null;
        Object r1 = null;
        if (r11 == null) goto L11;
        MmRecordingRepo r12 = r11.f();
        if (r12 == null) goto L11;
        MmAIInterpretationRepo r13 = r12.q();
        if (r13 == null) goto L11;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a r14 = r13.n();
        if (r14 == null) goto L11;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.d r15 = r14.m();
    L12:
        if (r9 != null) goto L17;
        if (r15 == null) goto L15;
        r9 = r15.d;
        goto L17
    L15:
        r9 = null;
    L17:
        if (r9 != null) goto L20;
        int r16 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "linkSubtitleTranslationIfNeeded", "skip, active ai interpretation language is null", getLogDetail());
        return Unit.INSTANCE;
    L20:
        boolean r2 = true;
        if (r15 != null) goto L23;
    L25:
        boolean r4 = false;
    L26:
        if (r4 == false) goto L34;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r17 = r15.d;
        if (r17 == null) goto L30;
        String r18 = r17.a;
    L32:
        if (Intrinsics.areEqual(r18, r9.a) == false) goto L34;
    L35:
        if (r2 == true) goto L38;
        int r19 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "linkSubtitleTranslationIfNeeded", "skip, ai interpretation not enabled, targetLanguage=" + r9.a, getLogDetail());
        return Unit.INSTANCE;
    L38:
        MmRecordingLanguageRepo r110 = getLanguageRepo();
        if (r110 == null) goto L66;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a r111 = r110.l();
        if (r111 == null) goto L66;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.f r3 = r111.m();
        if (r3.b.isEmpty() == false) goto L47;
        int r5 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "linkSubtitleTranslationIfNeeded", "skip, translate language list empty, targetLanguage=" + r9.a, getLogDetail());
        r111.l0();
        return Unit.INSTANCE;
    L47:
        int r6 = o.a;
        Intrinsics.checkNotNullParameter(r3, "languageEntity");
        Intrinsics.checkNotNullParameter(r9, "targetLanguage");
        if (Intrinsics.areEqual(r3.d.a, "source") == false) goto L57;
        String r7 = StringsKt.removePrefix(r9.a, "ai_");
        Iterator<T> r8 = r3.b.iterator();
    L52:
        if (r8.hasNext() == false) goto L56;
        Object r20 = r8.next();
        if (Intrinsics.areEqual(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h) r20).a, r7) == false) goto L52;
        r1 = r20;
    L56:
        r0 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h) r1;
    L57:
        if (r0 != null) goto L64;
        int r112 = bwb.b.a;
        MmUiLogScene r113 = MmUiLogScene.RECORDING;
        StringBuilder r21 = new StringBuilder("skip, translate language is not none or unsupported, targetLanguage=");
        r21.append(r9.a);
        r21.append(", currTranslateLanguage=");
        r21.append(r3.d.a);
        r21.append(", translateLanguageList=");
        List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h> r22 = r3.b;
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator<T> r24 = r22.iterator();
    L60:
        if (r24.hasNext() == false) goto L62;
        r23.add(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h) r24.next()).a);
        goto L60
    L62:
        r21.append(r23);
        bwb.b.f(r113, "linkSubtitleTranslationIfNeeded", r21.toString(), getLogDetail());
        return Unit.INSTANCE;
    L64:
        int r25 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "linkSubtitleTranslationIfNeeded", "set translate language, language=" + r0.a, getLogDetail());
        r111.e0(r0, false);
        return Unit.INSTANCE;
    L66:
        int r26 = bwb.b.a;
        bwb.b.d(MmUiLogScene.RECORDING, "linkSubtitleTranslationIfNeeded", "language repo unavailable", getLogDetail());
        return Unit.INSTANCE;
    L30:
        r18 = null;
    L34:
        r2 = false;
        goto L35
    L23:
        if (r15.a != true) goto L25;
        r4 = true;
    L11:
        r15 = null;
        goto L12
    }

    private final void markAIInterpretationHeadsetDialogDismissed(String r5, boolean r6) {
        if (this.aiInterpretationHeadsetDialogShowing == true) goto L6;
        this.pendingAIInterpretationSwitchTipBubble = false;
        return;
    L6:
        int r0 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "markAIInterpretationHeadsetDialogDismissed", "reason=" + r5, getLogDetail());
        this.aiInterpretationHeadsetDialogShowing = false;
        if (this.pendingAIInterpretationSwitchTipBubble == false) goto L10;
        if (r6 == false) goto L10;
        this.pendingAIInterpretationSwitchTipBubble = false;
        sendAIInterpretationSwitchTipBubbleEvent();
        return;
    L10:
        this.pendingAIInterpretationSwitchTipBubble = false;
    }

    private final void refreshAIInterpretationSettingIfReady(MmRecordingSession r11, String r12) {
        if (r11.a != RecordingSessionType.HARDWARE_RECORDING) goto L5;
        return;
    L5:
        String r5 = r11.w.a;
        if (r5.length() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        int r13 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "refreshAIInterpretationSettingIfReady", "skip empty meetingId, source=" + r12, getLogDetail());
        return;
    L12:
        BuildersKt.launch$default(getViewModelScope(), null, null, new C02551(r12, this, r11, r5, null), 3, null);
        return;
    L8:
        r0 = false;
        goto L9
    }

    private final MmAudioSaveType resolveAudioSaveType(MmAudioSaveType r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r3) {
        if (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.f.a(r3.a) == false) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L13;
        return r2.toNormalType();
    L13:
        if (r2.isSave() == false) goto L16;
        return MmAudioSaveType.FORCE_SAVE;
    L16:
        return MmAudioSaveType.FORCE_NOT_SAVE;
    L5:
        if (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.f.a(r3.b) == true) goto L8;
        r4 = false;
        goto L9
    }

    private final Object showForceAudioSaveToast(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r4, Continuation<? super Unit> r5) {
        boolean r0 = false;
        if (r4 == null) goto L9;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r1 = r4.a;
        if (r1 == null) goto L9;
        if (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.f.a(r1) != true) goto L9;
        r0 = true;
    L9:
        if (r0 == false) goto L11;
        int r6 = toForceAudioSaveToastRes(r4.a);
    L15:
        Object r7 = sendVMEvent(new h.g(new svb.a.b(UIHelper.getString(r6))), r5);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        return r7;
    L19:
        return Unit.INSTANCE;
    L11:
        if (r4 == null) goto L13;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h r8 = r4.b;
    L14:
        r6 = toForceAudioSaveToastRes(r8);
        goto L15
    L13:
        r8 = null;
        goto L14
    }

    private final void updateTitle(String r7, String r8) {
        BuildersKt.launch$default(getViewModelScope(), null, null, new C02601(this, r7, r8, null), 3, null);
    }

    public final void bindRecordingNotification(ewb.b r4, MmRecordingUILaunchMode r5) {
        Intrinsics.checkNotNullParameter(r4, "host");
        Intrinsics.checkNotNullParameter(r5, "uiLaunchMode");
        MmRecordingSession r0 = this.session;
        if (r0 != null) goto L6;
        int r6 = bwb.b.a;
        bwb.b.d(MmUiLogScene.RECORDING, "bindRecordingNotification", "session not found", getLogDetail());
        return;
    L6:
        MmRecordingRepo r2 = r0.f();
        if (r2 == null) goto L9;
        MmRecordingNotificationRepo r3 = (MmRecordingNotificationRepo) r2.r.getValue();
    L10:
        if (r3 != null) goto L13;
        int r7 = bwb.b.a;
        bwb.b.d(MmUiLogScene.RECORDING, "bindRecordingNotification", "notificationRepo not found", getLogDetail());
        return;
    L13:
        startRecordingNotificationProcessor(r4, r5, r3, r0.a);
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.h resolveQuotaCtaTrackingState$officesdk_minutes_base_ui_release(MmRecordingUITab r4, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r5) {
        Intrinsics.checkNotNullParameter(r4, "tab");
        Intrinsics.checkNotNullParameter(r5, "entity");
        int r2 = f.a;
        Intrinsics.checkNotNullParameter(r4, "tab");
        Intrinsics.checkNotNullParameter(r5, "entity");
        int r6 = f.a.a[r4.ordinal()];
        if (r6 == 1) goto L10;
        if (r6 != 2) goto L8;
        return r5.b;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return r5.a;
    }

    public final void trackAIInterpretationClick(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "clickAction");
        Intrinsics.checkNotNullParameter(r7, "language");
        String r2 = getCurrentRecordingId("trackAIInterpretationClick");
        if (r2 != null) goto L5;
        return;
    L5:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.f r3 = (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.f) this.mmUccApi.N().f.getValue();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r6, "clickAction");
        Intrinsics.checkNotNullParameter(r7, "language");
        MmRecordingCommonParam r0 = r3.a.b(r2);
        if (r0 == null) goto L10;
        boolean r1 = true;
        if (r0.isValid() != true) goto L10;
    L11:
        if (r1 == true) goto L13;
        lvb.a.b("MmRecordingAIInterpretationTracker", "[trackClick] commonParam invalid, " + r6);
        return;
    L13:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r4 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r4.e(PickerReporterConstants.KEY.CLICK, r6);
        r4.e("translation_language", r7);
        r3.a.g(r2, "vc_navigation_minutes_recording_click", r4.a());
        return;
    L10:
        r1 = false;
        goto L11
    }

    public final void trackAIInterpretationToast(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "toastContent");
        String r1 = getCurrentRecordingId("trackAIInterpretationToast");
        if (r1 != null) goto L5;
        return;
    L5:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.f r2 = (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.f) this.mmUccApi.N().f.getValue();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r9, "toastContent");
        MmRecordingCommonParam r0 = r2.a.b(r1);
        boolean r3 = false;
        if (r0 != null) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == true) goto L13;
        lvb.a.b("MmRecordingAIInterpretationTracker", "[trackToast] commonParam invalid, " + r9);
        return;
    L13:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r6 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r6.e("view_scene", "ai_si_toast");
        r6.e("entrance", r0.getEntrance());
        r6.e("ai_si_toast_content", r9);
        if (r10 != null) goto L16;
    L17:
        r3 = true;
    L18:
        if (r3 == true) goto L20;
        r6.e("not_support_lang", r10);
    L20:
        r2.a.g(r1, "vc_navigation_minutes_recording_view", r6.a());
        return;
    L16:
        if (r10.length() != 0) goto L18;
    L8:
        if (r0.isValid() != true) goto L10;
        r5 = true;
        goto L11
    }

    public final void trackPageClick(String r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r3, PickerReporterConstants.KEY.CLICK);
        String r0 = getCurrentRecordingId("trackPageClick");
        if (r0 != null) goto L5;
        return;
    L5:
        ((com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.j) this.mmUccApi.N().c.getValue()).a(r0, r3, r4);
    }

    public final void trackPageView(String r5, Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r5, "viewScene");
        String r1 = getCurrentRecordingId("trackPageView");
        if (r1 != null) goto L5;
        return;
    L5:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.j r2 = (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.j) this.mmUccApi.N().c.getValue();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r5, "viewScene");
        MmRecordingCommonParam r0 = r2.a.b(r1);
        if (r0 == null) goto L10;
        boolean r3 = true;
        if (r0.isValid() != true) goto L10;
    L11:
        if (r3 == true) goto L13;
        lvb.a.b("MmRecordingPageTracker", "[trackView] commonParam invalid, " + r5);
        return;
    L13:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r4 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();
        r4.e("view_scene", r5);
        if (r6 == null) goto L19;
        Iterator<Map.Entry<String, ? extends Object>> r7 = r6.entrySet().iterator();
    L17:
        if (r7.hasNext() == false) goto L19;
        Map.Entry<String, ? extends Object> r8 = r7.next();
        r4.d(r8.getKey(), r8.getValue());
    L19:
        r2.a.g(r1, "vc_navigation_minutes_recording_view", r4.a());
        return;
    L10:
        r3 = false;
        goto L11
    }

    public final void trackQuotaCtaClick(MmRecordingUITab r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r3) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        Intrinsics.checkNotNullParameter(r3, "entity");
        trackQuotaCtaClick(resolveQuotaCtaTrackingState$officesdk_minutes_base_ui_release(r2, r3));
    }

    public final void trackQuotaCtaView(MmRecordingUITab r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r3) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        Intrinsics.checkNotNullParameter(r3, "entity");
        trackQuotaCtaView(resolveQuotaCtaTrackingState$officesdk_minutes_base_ui_release(r2, r3));
    }

    public static final /* synthetic */ Object access$linkSubtitleTranslationIfNeeded(MmRecordingViewModel r0, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r1, Continuation r2) {
        return r0.linkSubtitleTranslationIfNeeded(r1, r2);
    }

    public static final /* synthetic */ MmAudioSaveType access$resolveAudioSaveType(MmRecordingViewModel r0, MmAudioSaveType r1, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r2) {
        return r0.resolveAudioSaveType(r1, r2);
    }

    public static final /* synthetic */ Object access$showForceAudioSaveToast(MmRecordingViewModel r0, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.c r1, Continuation r2) {
        return r0.showForceAudioSaveToast(r1, r2);
    }

    private final void sendRecordStopEventAfterAudioSaveCheck(MmRecordingSession r5, EndRecordingReason r6, String r7) {
        if (this.hasPendingFinishAudioSaveCheck == true) goto L5;
        int r0 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "sendRecordStopEventAfterAudioSaveCheck", "no pending check, reason=" + r7, getLogDetail());
    L6:
        int r1 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "sendRecordStopEventAfterAudioSaveCheck", "endReason=" + r6 + ", reason=" + r7, getLogDetail());
        r5.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.k(r6));
        return;
    L5:
        this.hasPendingFinishAudioSaveCheck = false;
        goto L6
    }

    private final Object showAIInterpretationHeadsetPrompt(HeadsetPromptSource r2, String r3, Continuation<? super Unit> r4) {
        if (r2 != HeadsetPromptSource.AI_ENABLED) goto L10;
        this.aiInterpretationHeadsetDialogShowing = true;
        Object r5 = sendVMEvent(new h.b(r3), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r5;
    L8:
        return Unit.INSTANCE;
    L10:
        if (this.aiInterpretationHeadsetDialogShowing == false) goto L13;
        int r6 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "showAIInterpretationHeadsetPrompt", "skip toast while headset dialog showing, source=" + r2, getLogDetail());
        return Unit.INSTANCE;
    L13:
        Object r7 = sendVMEvent(new h.g(new svb.a.b(r3)), r4);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        return r7;
    L17:
        return Unit.INSTANCE;
    }

    public final void initSession(String r5, MmRecordingSession r6, MmRecordingUILaunchMode r7) {
        Intrinsics.checkNotNullParameter(r5, "recordingId");
        Intrinsics.checkNotNullParameter(r6, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r7, "uiLaunchMode");
        if (Intrinsics.areEqual(this.recordingId, r5) == true) goto L5;
    L8:
        this.hasTrackedAiNotesRecordingView = false;
        this.hasTrackedAiNotesOnboardingView = false;
        this.hasRequestedAiNoteTooltipGuide = false;
        this.hasRequestedFirstMarkTooltipGuide = false;
        int r0 = bwb.b.a;
        bwb.b.f(MmUiLogScene.ENTRY, "initSession", "recording=" + r5 + ", meeting=" + r6.w.a, getLogDetail());
        this.recordingId = r5;
        this.session = r6;
        this.uiLaunchMode = r7;
        this.uiProviders = new MmRecordingUiProviders(this.mmUccApi, r7);
        observeSessionState(r6);
        observeRecordingMetaInfo(r6);
        observeMetaRepoEvents(r6);
        MmRecordingMetaRepo r8 = getMetaRepo();
        if (r8 == null) goto L18;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.a r9 = r8.l();
        if (r9 == null) goto L18;
        i1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.b> r10 = r9.b();
        if (r10 == null) goto L18;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.b r11 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.b) r10.getValue();
        if (r11 == null) goto L18;
        final MmRecordingUITab r12 = r11.e;
        if (r12 == null) goto L18;
    L19:
        setState(new C02241(r12));
        bwb.b.f(MmUiLogScene.CONTENT, "initSession", "tab=" + r12, getLogDetail());
        observeRecordingLanguage();
        observeSubtitleDegradation();
        observeLanguageRepoEvents(r6);
        observeAudioSaveSetting(r6);
        observeAIInterpretation(r6);
        observeToastEvents(r6);
        observeSummaryRepoEvents(r6);
        observeEndWindowRepoEvents(r6);
        observeHasUnviewedSummary(r6);
        observeLocationInfo(r6);
        refreshAIInterpretationSettingIfReady(r6, "initSession");
        return;
    L18:
        r12 = MmRecordingUITab.SUBTITLE;
        goto L19
    L5:
        if (this.session == null) goto L8;
        int r13 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "initSession", "already initialized", getLogDetail());
    }

    public final void trackVoicePrintChange(String r8, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r9, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c r10) {
        Intrinsics.checkNotNullParameter(r8, "clusterId");
        Intrinsics.checkNotNullParameter(r9, "oldSpeaker");
        Intrinsics.checkNotNullParameter(r10, "newSpeaker");
        MmRecordingSession r0 = this.session;
        if (r0 == null) goto L9;
        String r2 = r0.e();
        if (r2 == null) goto L9;
        ((r) this.mmUccApi.N().h.getValue()).a(r2, r8, r9, r10, "subtitle");
        return;
    L9:
        int r11 = bwb.b.a;
        bwb.b.d(MmUiLogScene.RECORDING, "trackVoicePrintChange", "session not found", getLogDetail());
    }

    public static final /* synthetic */ void access$sendRecordStopEventAfterAudioSaveCheck(MmRecordingViewModel r0, MmRecordingSession r1, EndRecordingReason r2, String r3) {
        r0.sendRecordStopEventAfterAudioSaveCheck(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$showAIInterpretationHeadsetPrompt(MmRecordingViewModel r0, HeadsetPromptSource r1, String r2, Continuation r3) {
        return r0.showAIInterpretationHeadsetPrompt(r1, r2, r3);
    }

    private final String getAIInterpretationClickAction(boolean r1, boolean r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r3, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r4) {
        if (r1 == false) goto L8;
        if (r2 == false) goto L8;
        if (r3 == null) goto L8;
        if (Intrinsics.areEqual(r3.a, r4.a) == true) goto L8;
        return "switch_ai_si";
    L8:
        if (r1 == false) goto L10;
        return "start_ai_si";
    L10:
        return "end_ai_si";
    }

    private final void startRecordingNotificationProcessor(ewb.b r2, MmRecordingUILaunchMode r3, MmRecordingNotificationRepo r4, RecordingSessionType r5) {
        clearNotificationManager();
        com.ss.android.lark.officesdk.minutes.ui.style.e.a.getClass();
        ewb.a r6 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r3).createRecordingNotificationProcessor();
        r6.a(r2, r4, r5, getViewModelScope());
        this.notificationProcessor = r6;
    }

    public static final /* synthetic */ String access$getAIInterpretationClickAction(MmRecordingViewModel r0, boolean r1, boolean r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r3, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r4) {
        return r0.getAIInterpretationClickAction(r1, r2, r3, r4);
    }

    public static /* synthetic */ Object linkSubtitleTranslationIfNeeded$default(MmRecordingViewModel r0, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r1, Continuation r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.linkSubtitleTranslationIfNeeded(r1, r2);
    }

    public static /* synthetic */ void trackAIInterpretationToast$default(MmRecordingViewModel r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.trackAIInterpretationToast(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackPageClick$default(MmRecordingViewModel r0, String r1, Map r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.trackPageClick(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackPageView$default(MmRecordingViewModel r0, String r1, Map r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.trackPageView(r1, r2);
    }

    public static /* synthetic */ void sendRecordStopEventAfterAudioSaveCheck$default(MmRecordingViewModel r0, MmRecordingSession r1, EndRecordingReason r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = "";
    L5:
        r0.sendRecordStopEventAfterAudioSaveCheck(r1, r2, r3);
    }
}
