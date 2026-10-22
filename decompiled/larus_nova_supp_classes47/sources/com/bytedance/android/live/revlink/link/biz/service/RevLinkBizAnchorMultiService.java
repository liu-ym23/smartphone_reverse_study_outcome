package com.bytedance.android.live.revlink.link.biz.service;

import android.graphics.RectF;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.model.ChorusInfo;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenuelink.rtc.q;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectUtilsKt;
import com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.impl.multianchor.ui.r;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiAnchorLinkContext;
import com.bytedance.android.live.revlink.impl.pk.scope.service.MultiPkScopeProviderService;
import com.bytedance.android.live.revlink.impl.pk.service.PkServiceContext;
import com.bytedance.android.live.revlink.impl.plantform.RevLinkMultiChannelDataContext;
import com.bytedance.android.live.revlink.link.biz.component.AiAssistantAnchorComponent;
import com.bytedance.android.live.revlink.link.biz.component.AutoStartPKComponent;
import com.bytedance.android.live.revlink.link.biz.component.BackgroundComponent;
import com.bytedance.android.live.revlink.link.biz.component.DoubleCompactComponent;
import com.bytedance.android.live.revlink.link.biz.component.MultiBizLifeControlComponent;
import com.bytedance.android.live.revlink.link.biz.component.MultiFollowState;
import com.bytedance.android.live.revlink.link.biz.component.MultiForegroundComponent;
import com.bytedance.android.live.revlink.link.biz.component.MultiInteractIconComponent;
import com.bytedance.android.live.revlink.link.biz.component.MultiLastResultComponent;
import com.bytedance.android.live.revlink.link.biz.component.MultiLinkContextComponent;
import com.bytedance.android.live.revlink.link.biz.component.MultiNativeComponent;
import com.bytedance.android.live.revlink.link.biz.component.MultiPKContextHolder;
import com.bytedance.android.live.revlink.link.biz.component.MultiPKLauncherComponent;
import com.bytedance.android.live.revlink.link.biz.component.MultiRTCBizComponent;
import com.bytedance.android.live.revlink.link.biz.component.MultiSwitchToPkImplV2;
import com.bytedance.android.live.revlink.link.biz.component.MultiWindowBizComponent;
import com.bytedance.android.live.revlink.link.biz.component.RoomStateDispatchAnchorComponent;
import com.bytedance.android.live.revlink.link.biz.component.SwitchSceneCompactComponent;
import com.bytedance.android.live.revlink.link.biz.component.s;
import com.bytedance.android.live.revlink.link.biz.doublecomponent.DoubleAudienceLinkComponent;
import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import com.bytedance.android.live.revlink.link.domain.anchorimpl.WindowClickImpl;
import com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAnchorService;
import com.bytedance.android.live.revlink.link.infra.rtcbiz.RTCAdvanceManagerService;
import com.bytedance.android.live.revlink.link.streaminteract.biz.PushModeManagerService;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.link.model.IAnchorUpdateLayoutContent;
import com.bytedance.android.livesdk.link.model.ILinkerKickOutContent;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.bridge.f0;
import com.bytedance.android.livesdk.link.model.bridge.w1;
import com.bytedance.android.livesdk.link.model.i7;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.x3;
import com.bytedance.android.scope.o;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import fr2.g0;
import fr2.v;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000º\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Á\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002Â\u0001B\u009f\u0001\u0012\b\u0010\u0091\u0001\u001a\u00030\u0090\u0001\u0012\b\u0010\u0096\u0001\u001a\u00030\u0095\u0001\u0012\b\u0010\u0099\u0001\u001a\u00030\u0098\u0001\u0012\b\u0010\u009c\u0001\u001a\u00030\u009b\u0001\u0012\b\u0010\u009f\u0001\u001a\u00030\u009e\u0001\u0012\b\u0010¢\u0001\u001a\u00030¡\u0001\u0012\b\u0010¥\u0001\u001a\u00030¤\u0001\u0012\b\u0010¨\u0001\u001a\u00030§\u0001\u0012\b\u0010«\u0001\u001a\u00030ª\u0001\u0012\b\u0010®\u0001\u001a\u00030\u00ad\u0001\u0012\b\u0010±\u0001\u001a\u00030°\u0001\u0012\b\u0010´\u0001\u001a\u00030³\u0001\u0012\b\u0010·\u0001\u001a\u00030¶\u0001\u0012\b\u0010º\u0001\u001a\u00030¹\u0001\u0012\b\u0010½\u0001\u001a\u00030¼\u0001¢\u0006\u0006\b¿\u0001\u0010À\u0001J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\"\u0010\u0017\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\"\u0010\u001c\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\"\u0010!\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\tH\u0016J\b\u0010&\u001a\u00020\u001aH\u0016J\"\u0010(\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010'\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010+\u001a\u00020\t2\u0006\u0010*\u001a\u00020)H\u0016J\n\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u0012\u00100\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J.\u00105\u001a\u00020\t2\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020\t\u0018\u000101j\u0004\u0018\u0001`22\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u00104\u001a\u00020\rH\u0016J\u0018\u00109\u001a\u0012\u0012\u0004\u0012\u00020706j\b\u0012\u0004\u0012\u000207`8H\u0016J\u0010\u0010<\u001a\u00020\t2\u0006\u0010;\u001a\u00020:H\u0016J\u0010\u0010=\u001a\u00020\t2\u0006\u0010;\u001a\u00020:H\u0016J#\u0010?\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010>\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b?\u0010@J\b\u0010A\u001a\u00020\tH\u0016J\b\u0010B\u001a\u00020\tH\u0016J\u0010\u0010D\u001a\u00020\t2\u0006\u0010C\u001a\u00020\u0007H\u0016J\u0012\u0010G\u001a\u0004\u0018\u00010F2\u0006\u0010E\u001a\u00020\rH\u0016J\u0018\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\r0Hj\b\u0012\u0004\u0012\u00020\r`IH\u0016J\u0018\u0010L\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0007H\u0016J\u0010\u0010N\u001a\u00020\t2\u0006\u0010M\u001a\u00020\rH\u0016J\u0010\u0010P\u001a\u00020\t2\u0006\u0010O\u001a\u00020\u001aH\u0016J\b\u0010Q\u001a\u00020\tH\u0016J\b\u0010R\u001a\u00020\tH\u0016R\u0014\u0010T\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010X\u001a\u00060Vj\u0002`W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010Z\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010]\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010`\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010c\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010f\u001a\u00020e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010i\u001a\u00020h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010l\u001a\u00020k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010o\u001a\u00020n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u0014\u0010r\u001a\u00020q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u0014\u0010u\u001a\u00020t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010x\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0014\u0010{\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u0014\u0010~\u001a\u00020}8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001c\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001a\u0010\u0084\u0001\u001a\u00030\u0083\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001a\u0010\u0087\u0001\u001a\u00030\u0086\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001a\u0010\u008a\u0001\u001a\u00030\u0089\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001f\u0010\u008e\u0001\u001a\n\u0012\u0005\u0012\u00030\u008d\u00010\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R \u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0018\u0010\u0096\u0001\u001a\u00030\u0095\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0018\u0010\u0099\u0001\u001a\u00030\u0098\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0018\u0010\u009c\u0001\u001a\u00030\u009b\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0018\u0010\u009f\u0001\u001a\u00030\u009e\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u0018\u0010¢\u0001\u001a\u00030¡\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u0018\u0010¥\u0001\u001a\u00030¤\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u0018\u0010¨\u0001\u001a\u00030§\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u0018\u0010«\u0001\u001a\u00030ª\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u0018\u0010®\u0001\u001a\u00030\u00ad\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u0018\u0010±\u0001\u001a\u00030°\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u0018\u0010´\u0001\u001a\u00030³\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u0018\u0010·\u0001\u001a\u00030¶\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R\u0018\u0010º\u0001\u001a\u00030¹\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R\u0018\u0010½\u0001\u001a\u00030¼\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001¨\u0006Ã\u0001"}, d2 = {"Lcom/bytedance/android/live/revlink/link/biz/service/RevLinkBizAnchorMultiService;", "Lcom/bytedance/android/scope/o;", "Lcom/bytedance/android/live/revlink/impl/multianchor/service/b;", "Ln21/a;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/pk/service/h;", "Lcom/bytedance/android/live/revlink/link/biz/service/a;", "", "source", "", "stopRtc", "startRtc", "checkShareDoubleCompactService", "", "mute", "setDoubleMute", "joinChannel", "isFinisher", "setAnchorLinkFinisher", "Lcom/bytedance/android/livesdk/link/model/p;", "linkUser", "useBackupStream", "reqSrc", "selectLinkAnchorTargetStream", "uid", "linkerID", "", "windowFollowState", "showMicPanel", "Lcom/bytedance/android/live/revlink/impl/multianchor/ui/i;", "getMuteManager", "Lcom/bytedance/android/livesdk/link/model/ILinkerKickOutContent$KickOutSource;", "kickOutSource", "kickOut", "Lcom/bytedance/android/livesdk/link/model/b7;", "multiChannelInfo", "onReceiveSwitchChannelReply", "invalidateSei", "getWindowCount", "follow", "setFollowState", "Lcom/bytedance/android/livesdk/link/model/bridge/f0;", "message", "receiveChorusMessage", "Lf31/j;", "getEndingLinkStatus", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkdouble/g;", "switchToPkDataContext", "startSwitchPk", "Lkotlin/Function0;", "Lcom/bytedance/android/live/revlink/impl/multianchor/service/AfterRunnable;", "runnable", "clearAfterSuccess", "finishInternal", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "", "Lcom/bytedance/android/live/revenue/common/NextLiveData;", "linkRecordTime", "Lf31/h;", Constants.Keys.DATA, "handleMultiDynamicData", "handleMuteAiDynamicData", "tabIndex", "finishInteract", "(Ljava/lang/String;Ljava/lang/Integer;)V", "pkOptOpenBattleByFirstFrame", "pkBizOptOpenBattleByAck", "req", "finish", "needValid", "Loq2/d;", "getPkLayoutData", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/LiveData;", "getGuestMuteState", "openId", "sendGuestKickOut", "isCloseRoom", "handlePkRoomClose", "type", "onLynxMicInteractionEvent", "onStart", "onStop", "Lcom/bytedance/android/live/revlink/link/biz/component/h;", "bizDataContext", "Lcom/bytedance/android/live/revlink/link/biz/component/h;", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "muteManager", "Lcom/bytedance/android/live/revlink/impl/multianchor/ui/i;", "Lcom/bytedance/android/live/revlink/link/biz/component/MultiLinkContextComponent;", "linkContextComponent", "Lcom/bytedance/android/live/revlink/link/biz/component/MultiLinkContextComponent;", "Lcom/bytedance/android/live/revlink/link/biz/component/g;", "chorusComponent", "Lcom/bytedance/android/live/revlink/link/biz/component/g;", "Lcom/bytedance/android/live/revlink/link/biz/component/MultiBizLifeControlComponent;", "lifeControlComponent", "Lcom/bytedance/android/live/revlink/link/biz/component/MultiBizLifeControlComponent;", "Lcom/bytedance/android/live/revlink/link/biz/component/d;", "switchToPkImpl", "Lcom/bytedance/android/live/revlink/link/biz/component/d;", "Lcom/bytedance/android/live/revlink/link/biz/component/MultiRTCBizComponent;", "rtcBizComponent", "Lcom/bytedance/android/live/revlink/link/biz/component/MultiRTCBizComponent;", "Lcom/bytedance/android/live/revlink/link/biz/component/e;", "linkTimeRecorder", "Lcom/bytedance/android/live/revlink/link/biz/component/e;", "Lcom/bytedance/android/live/revlink/link/biz/component/MultiWindowBizComponent;", "windowBizComponent", "Lcom/bytedance/android/live/revlink/link/biz/component/MultiWindowBizComponent;", "Lcom/bytedance/android/live/revlink/link/biz/component/BackgroundComponent;", "backgroundComponent", "Lcom/bytedance/android/live/revlink/link/biz/component/BackgroundComponent;", "Lcom/bytedance/android/live/revlink/link/biz/component/MultiPKContextHolder;", "pkContextHolder", "Lcom/bytedance/android/live/revlink/link/biz/component/MultiPKContextHolder;", "Lcom/bytedance/android/live/revlink/link/biz/component/MultiNativeComponent;", "nativeComponent", "Lcom/bytedance/android/live/revlink/link/biz/component/MultiNativeComponent;", "Lcom/bytedance/android/live/revlink/link/biz/component/MultiFollowState;", "followComponent", "Lcom/bytedance/android/live/revlink/link/biz/component/MultiFollowState;", "Lcom/bytedance/android/live/revlink/link/biz/component/MultiPKLauncherComponent;", "multiPKLauncherComponent", "Lcom/bytedance/android/live/revlink/link/biz/component/MultiPKLauncherComponent;", "Lcom/bytedance/android/live/revlink/link/biz/component/AiAssistantAnchorComponent;", "aiAssistantComponent", "Lcom/bytedance/android/live/revlink/link/biz/component/AiAssistantAnchorComponent;", "Lcom/bytedance/android/live/revlink/link/biz/component/AutoStartPKComponent;", "autoStartPKComponent", "Lcom/bytedance/android/live/revlink/link/biz/component/AutoStartPKComponent;", "Lcom/bytedance/android/live/revlink/link/biz/component/DoubleCompactComponent;", "doubleCompactComponent", "Lcom/bytedance/android/live/revlink/link/biz/component/DoubleCompactComponent;", "Lcom/bytedance/android/live/revlink/link/biz/doublecomponent/c;", "doublePKContextHolder", "Lcom/bytedance/android/live/revlink/link/biz/doublecomponent/c;", "", "Lcom/bytedance/android/live/revlink/link/biz/service/e;", "components", "Ljava/util/List;", "Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/g;", "context", "Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/g;", "getContext", "()Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/g;", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "roomService", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "Lyz0/g;", "newRoomService", "Lyz0/g;", "Lcom/bytedance/android/live/revlink/link/domain/service/RevLinkDomainAnchorService;", "domainService", "Lcom/bytedance/android/live/revlink/link/domain/service/RevLinkDomainAnchorService;", "Lcom/bytedance/android/live/revenuelink/rtc/i;", "rtcManager", "Lcom/bytedance/android/live/revenuelink/rtc/i;", "Lld/a;", "linkInternalDataSet", "Lld/a;", "Lyz0/f;", "messageService", "Lyz0/f;", "Lcom/bytedance/android/livesdk/revenue/service/message/d;", "messageManagerService", "Lcom/bytedance/android/livesdk/revenue/service/message/d;", "Lcom/bytedance/android/live/revlink/link/streaminteract/biz/c;", "streamMixManagerService", "Lcom/bytedance/android/live/revlink/link/streaminteract/biz/c;", "Lcom/bytedance/android/live/revlink/impl/pk/scope/service/MultiPkScopeProviderService;", "multiPkScopeService", "Lcom/bytedance/android/live/revlink/impl/pk/scope/service/MultiPkScopeProviderService;", "Lcom/bytedance/android/live/revlink/link/streaminteract/biz/PushModeManagerService;", "pushManager", "Lcom/bytedance/android/live/revlink/link/streaminteract/biz/PushModeManagerService;", "Lcom/bytedance/android/live/revlink/link/core/service/AnchorUILayoutManager;", "uiLayoutManager", "Lcom/bytedance/android/live/revlink/link/core/service/AnchorUILayoutManager;", "Lx11/a;", "internalLinkService", "Lx11/a;", "Lk11/f;", "dynamicLinkInfoService", "Lk11/f;", "Lcom/bytedance/android/live/revlink/link/infra/rtcbiz/RTCAdvanceManagerService;", "rtcAdvanceManagerService", "Lcom/bytedance/android/live/revlink/link/infra/rtcbiz/RTCAdvanceManagerService;", "<init>", "(Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/g;Lcom/bytedance/android/livesdk/revenue/service/room/c;Lyz0/g;Lcom/bytedance/android/live/revlink/link/domain/service/RevLinkDomainAnchorService;Lcom/bytedance/android/live/revenuelink/rtc/i;Lld/a;Lyz0/f;Lcom/bytedance/android/livesdk/revenue/service/message/d;Lcom/bytedance/android/live/revlink/link/streaminteract/biz/c;Lcom/bytedance/android/live/revlink/impl/pk/scope/service/MultiPkScopeProviderService;Lcom/bytedance/android/live/revlink/link/streaminteract/biz/PushModeManagerService;Lcom/bytedance/android/live/revlink/link/core/service/AnchorUILayoutManager;Lx11/a;Lk11/f;Lcom/bytedance/android/live/revlink/link/infra/rtcbiz/RTCAdvanceManagerService;)V", "Companion", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkBizAnchorMultiService extends DataContext implements o, com.bytedance.android.live.revlink.impl.multianchor.service.b, n21.a, com.bytedance.android.live.revlink.impl.pk.service.h, com.bytedance.android.live.revlink.link.biz.service.a {
    public static final a Companion = null;
    public static final int INTER_COM_INTERACTION_EVENT = 2;
    public static final int MUTE_INTERACTION_EVENT = 1;
    private AiAssistantAnchorComponent aiAssistantComponent;
    private AutoStartPKComponent autoStartPKComponent;
    private final BackgroundComponent backgroundComponent;
    private final com.bytedance.android.live.revlink.link.biz.component.h bizDataContext;
    private final CompositeDisposable cd;
    private final com.bytedance.android.live.revlink.link.biz.component.g chorusComponent;
    private final List<e> components;
    private final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g context;
    private final RevLinkDomainAnchorService domainService;
    private DoubleCompactComponent doubleCompactComponent;
    private com.bytedance.android.live.revlink.link.biz.doublecomponent.c doublePKContextHolder;
    private final k11.f dynamicLinkInfoService;
    private final MultiFollowState followComponent;
    private final x11.a internalLinkService;
    private final MultiBizLifeControlComponent lifeControlComponent;
    private final MultiLinkContextComponent linkContextComponent;
    private final ld.a linkInternalDataSet;
    private final com.bytedance.android.live.revlink.link.biz.component.e linkTimeRecorder;
    private final com.bytedance.android.livesdk.revenue.service.message.d messageManagerService;
    private final yz0.f messageService;
    private final MultiPKLauncherComponent multiPKLauncherComponent;
    private final MultiPkScopeProviderService multiPkScopeService;
    private final com.bytedance.android.live.revlink.impl.multianchor.ui.i muteManager;
    private MultiNativeComponent nativeComponent;
    private final yz0.g newRoomService;
    private final MultiPKContextHolder pkContextHolder;
    private final PushModeManagerService pushManager;
    private final com.bytedance.android.livesdk.revenue.service.room.c roomService;
    private final RTCAdvanceManagerService rtcAdvanceManagerService;
    private final MultiRTCBizComponent rtcBizComponent;
    private final com.bytedance.android.live.revenuelink.rtc.i rtcManager;
    private final com.bytedance.android.live.revlink.link.streaminteract.biz.c streamMixManagerService;
    private final com.bytedance.android.live.revlink.link.biz.component.d switchToPkImpl;
    private final AnchorUILayoutManager uiLayoutManager;
    private final MultiWindowBizComponent windowBizComponent;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.service.RevLinkBizAnchorMultiService$onStart$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "mute", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class C03721 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public C03721(RevLinkBizAnchorMultiService r8) {
            super(1, r8, RevLinkBizAnchorMultiService.class, "setDoubleMute", "setDoubleMute(Z)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke(((Boolean) r1).booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean r2) {
            RevLinkBizAnchorMultiService.access$setDoubleMute((RevLinkBizAnchorMultiService) ((CallableReference) this).receiver, r2);
        }
    }

    static {
        Companion = new a();
    }

    public void pkBizOptOpenBattleByAck() {
    }

    public void pkOptOpenBattleByFirstFrame() {
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.h
    public void sendGuestKickOut(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r3, "openId");
    }

    public void showMicPanel(String r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "linkerID");
    }

    private final void checkShareDoubleCompactService() {
        Pair r0 = com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE);
        PkServiceContext r1 = (PkServiceContext) r0.component1();
        Disposable r2 = (Disposable) r0.component2();
        r1.getService().d(this);
        getContext().T6("IPkService", r1);
        com.bytedance.revenue.platform.api.core.rx.f.a(r2, this.cd);
    }

    private final void startRtc() {
        MultiRTCBizComponent r0 = this.rtcBizComponent;
        r0.getClass();
        vc0.a r2 = null;
        if (AnchorRtcConnectUtilsKt.f() == true) goto L5;
    L7:
        RevLinkMultiChannelDataContext r3 = r0.getContext().Lj();
        if (r3 == null) goto L12;
        LiveData<b7> r4 = r3.getMultiChannelData();
        if (r4 == null) goto L12;
        b7 r5 = (b7) r4.getValue();
    L13:
        q r1 = new q(r5, 7);
    L14:
        AnchorRtcConnectModel r6 = r0.j();
        if (r6 == null) goto L19;
        com.bytedance.live.datacontext.k<Object> r7 = r6.getOnStartRtcEvent();
        if (r7 == null) goto L19;
        r7.post(Boolean.TRUE);
    L19:
        com.bytedance.android.live.revenuelink.connect.f r8 = r0.getContext().Z0();
        if (r8 == null) goto L27;
        LiveData<ey.f> r9 = r8.connectState();
        if (r9 == null) goto L27;
        ey.f r10 = (ey.f) r9.getValue();
        if (r10 == null) goto L27;
        String r12 = r10.f;
        if (r12 == null) goto L27;
    L28:
        com.bytedance.android.live.revenuelink.rtc.i r13 = r0.k;
        vc0.a r14 = vc0.b.a(r0.getContext().getLiveVideoClientFactory());
        Object r15 = r14.b;
        if ((r15 instanceof xh6.c) == true) goto L31;
        xh6.c r16 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(v.class), r14.a);
        if ((r16 instanceof v) == true) goto L37;
        r16 = null;
    L37:
        v r17 = (v) r16;
    L38:
        if (r17 == null) goto L40;
        r2 = vc0.b.a(r17);
    L40:
        r0.getContext().getScene();
        r13.U1(r2, r0, r12, r1);
        if (r0.e == false) goto L52;
        AnchorRtcConnectModel r18 = r0.j();
        if (r18 == null) goto L52;
        n<com.bytedance.android.live.revlink.impl.multianchor.connect.o> r19 = r18.getRtcForwardData();
        if (r19 == null) goto L52;
        com.bytedance.android.live.revlink.impl.multianchor.connect.o r20 = (com.bytedance.android.live.revlink.impl.multianchor.connect.o) r19.getValue();
        if (r20 == null) goto L52;
        if (r20.a.isEmpty() == false) goto L51;
        r0.getContext().Rn().n("joinChannelSuccess");
        r0.f.a(101, "joinChannelFallback", "forwardRoomEmpty");
        goto L52
    L51:
        r0.k.c1(r20.a, "joinChannelSuccess", String.valueOf(r0.getContext().G()));
    L52:
        r0.getContext().A7().getClass();
        return;
    L31:
        if ((r15 instanceof v) == true) goto L33;
        r15 = null;
    L33:
        r17 = (v) r15;
    L27:
        r12 = "";
    L12:
        r5 = null;
        goto L13
    L5:
        if (r0.j() == null) goto L7;
        r1 = new q(null, 11);
        goto L14
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.b
    public f31.j getEndingLinkStatus() {
        return this.lifeControlComponent.c;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.h
    public LiveData<Boolean> getGuestMuteState() {
        RevLinkDomainAnchorService r0 = this.domainService;
        Intrinsics.checkNotNullParameter(this, "$this$doubleGuestUID");
        s51.c r1 = RevLinkDomainAnchorService.f(r0, i.u(this), null, 2);
        if (r1 == null) goto L8;
        NextLiveData<Boolean> r2 = r1.i.b;
        if (r2 == null) goto L8;
        return r2;
    L8:
        return new NextLiveData();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.b
    public int getWindowCount() {
        List r0 = (List) this.domainService.e.getValue();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public void invalidateSei() {
        this.streamMixManagerService.f.f();
    }

    public void joinChannel() {
        this.lifeControlComponent.b();
    }

    @Override // n21.a
    public NextLiveData<Long> linkRecordTime() {
        return this.linkTimeRecorder.a.c;
    }

    public void onStart() {
        MultiLinkContextComponent r0 = this.linkContextComponent;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "multiLinkService");
        r0.b.getService().d(this);
        MultiLinkContextComponent r1 = this.linkContextComponent;
        r1.getClass();
        Intrinsics.checkNotNullParameter(this, "service");
        r1.b.getCommonService().d(this);
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r2 = getContext();
        r2.c = new C03721(this);
        checkShareDoubleCompactService();
        Iterator<T> r3 = this.components.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((e) r3.next()).attach();
        goto L4
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    public void onStop() {
        getContext().d.y.N5().setValue(Unit.INSTANCE);
        Iterator r0 = CollectionsKt.reversed(this.components).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).detach();
        goto L4
    L6:
        this.cd.clear();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.b
    public com.bytedance.android.live.revlink.impl.multianchor.ui.i getMuteManager() {
        return this.muteManager;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g getContext() {
        return this.context;
    }

    public static final /* synthetic */ RevLinkDomainAnchorService access$getDomainService$p(RevLinkBizAnchorMultiService r0) {
        return r0.domainService;
    }

    public static final /* synthetic */ void access$startRtc(RevLinkBizAnchorMultiService r0) {
        r0.startRtc();
    }

    private final void setDoubleMute(final boolean r3) {
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r0 = getContext();
        Function1<com.bytedance.android.live.revlink.link.biz.service.a, Unit> r1 = new C03731(this, r3);
        Intrinsics.checkNotNullParameter(r0, "$this$holderScope");
        Intrinsics.checkNotNullParameter(r1, "scope");
        r1.invoke(new com.bytedance.android.live.revlink.link.infra.lifecontrol.context.i(r0));
    }

    private final void stopRtc(String r2) {
        this.rtcBizComponent.w(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.h
    public void finish(String r4) {
        Intrinsics.checkNotNullParameter(r4, "req");
        this.lifeControlComponent.a(null, r4, false, false);
    }

    public String getLinkerID(String r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$linkerID");
        Intrinsics.checkNotNullParameter(r2, "$this$linkerID");
        return j.a.a(this, r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.h
    public oq2.d getPkLayoutData(boolean r6) {
        DoubleCompactComponent r7 = this.doubleCompactComponent;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("doubleCompactComponent");
    L5:
        f31.f r0 = (f31.f) r7.getContext().hh().getValue();
        if (r0 == null) goto L22;
        List<f31.k> r1 = r0.a;
        boolean r2 = false;
        if (r1 == null) goto L10;
        int r3 = r1.size();
    L12:
        if (r3 >= 2) goto L14;
    L16:
        if (r2 == true) goto L19;
        r0 = null;
    L19:
        if (r0 == null) goto L22;
        RectF r4 = r0.b;
        r7.c = new oq2.d((int) r4.top, ((int) r4.width()) / 2, (int) r0.b.height());
        goto L22
    L14:
        if (r0.c.height() <= 0) goto L16;
        r2 = true;
        goto L16
    L10:
        r3 = 0;
    L22:
        return r7.c;
    }

    public String getUid(String r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$uid");
        Intrinsics.checkNotNullParameter(r2, "$this$uid");
        return j.a.b(this, r2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // n21.a
    public void handleMultiDynamicData(f31.h r9) {
        Intrinsics.checkNotNullParameter(r9, Constants.Keys.DATA);
        MultiWindowBizComponent r1 = this.windowBizComponent;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, Constants.Keys.DATA);
        int r2 = 0;
        boolean r3 = false;
        r3 = false;
        boolean r4 = false;
        r4 = false;
        Object r5 = null;
        if ((r9 instanceof f31.d) == false) goto L42;
        f31.d r10 = (f31.d) r9;
        Integer r0 = r10.c();
        if (r0 != null) goto L8;
    L10:
        boolean r6 = false;
    L11:
        if (r6 == false) goto L26;
        Integer r7 = r10.a();
        if (r7 != null) goto L16;
    L18:
        boolean r8 = false;
    L19:
        Integer r12 = r10.b();
        if (r12 != null) goto L23;
    L25:
        r1.f.i(r8, r.c.a, r3);
        return;
    L23:
        if (r12.intValue() != 1) goto L25;
        r3 = true;
        goto L25
    L16:
        if (r7.intValue() != 1) goto L18;
        r8 = true;
        goto L19
    L26:
        Integer r13 = r10.b();
        if (r13 != null) goto L30;
    L32:
        Iterator<T> r14 = r1.c.iterator();
    L34:
        if (r14.hasNext() == false) goto L38;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((s) r15).i, r10.d()) == false) goto L34;
        r5 = r15;
    L38:
        s r16 = (s) r5;
        if (r16 == null) goto L120;
        r16.e(r4);
        return;
    L120:
        return;
    L30:
        if (r13.intValue() != 1) goto L32;
        r4 = true;
        goto L32
    L8:
        if (r0.intValue() != 1) goto L10;
        r6 = true;
        goto L11
    L42:
        if ((r9 instanceof f31.c) == false) goto L45;
        r1.getContext().getCommonService().h().b();
        return;
    L45:
        if ((r9 instanceof f31.e) == false) goto L57;
        s51.c r17 = RevLinkDomainAnchorService.f(r1.g, ((f31.e) r9).a(), null, 2);
        if (r17 == null) goto L123;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r18 = r1.getContext();
        if (r18 == null) goto L55;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r19 = (com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a) r18;
        List r20 = (List) r1.g.e.getValue();
        if (r20 == null) goto L53;
        r2 = r20.size();
    L53:
        new WindowClickImpl(r17, r19, r2).a();
        return;
    L55:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.link.infra.lifecontrol.context.AnchorContext");
    L123:
        return;
    L57:
        if ((r9 instanceof f31.b) == false) goto L125;
        f31.b r22 = (f31.b) r9;
        Integer r23 = r22.a();
        if (r23 != null) goto L62;
    L64:
        boolean r24 = false;
    L65:
        Iterator<T> r25 = r1.c.iterator();
    L67:
        if (r25.hasNext() == false) goto L71;
        Object r26 = r25.next();
        if (Intrinsics.areEqual(((s) r26).i, r22.b()) == false) goto L67;
        r5 = r26;
    L71:
        s r27 = (s) r5;
        if (r27 == null) goto L126;
        com.bytedance.android.live.revlink.link.biz.component.b r28 = r27.d;
        if (Intrinsics.areEqual(o51.g.b(r28.b.e), r27.i) != true) goto L76;
        boolean r29 = true;
    L77:
        com.bytedance.android.live.revlink.link.biz.component.b r30 = r27.d;
        if (Intrinsics.areEqual(o51.g.b(r30.b.e), r27.i) == false) goto L85;
        o51.e r32 = r30.b.e;
        Intrinsics.checkNotNullParameter(r32, "$this$isAllRoom");
        if (r32.c != IAnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeAllRoom) goto L82;
        boolean r33 = true;
    L83:
        if (r33 != true) goto L85;
        boolean r34 = true;
    L86:
        if (r34 != true) goto L88;
        boolean r35 = true;
    L89:
        if (r29 == true) goto L96;
        if (r35 == true) goto L96;
        if (o51.g.c(r27.d.b.e) != UILayout.FULL) goto L95;
        String r36 = "connection_mini_window";
    L97:
        if (r24 == false) goto L105;
        r27.d.b.c(r27.i, !r35, true);
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.b() == true) goto L127;
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r37 = r27.getContext().getMultiAnchorLinkLogUtils();
        if (r29 == false) goto L103;
        String r38 = "average";
    L104:
        r37.t(r38, r36);
        return;
    L103:
        r38 = "enlarge";
        goto L104
    L127:
        return;
    L105:
        r27.d.b.c(r27.i, !r29, false);
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.b() == true) goto L129;
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r39 = r27.getContext().getMultiAnchorLinkLogUtils();
        if (r35 == false) goto L110;
        String r40 = "average_all";
    L111:
        r39.t(r40, r36);
        return;
    L110:
        r40 = "enlarge_all";
        goto L111
    L129:
        return;
    L95:
        r36 = "";
    L96:
        r36 = "connection_info_area";
        goto L97
    L88:
        r35 = false;
        goto L89
    L82:
        r33 = false;
    L85:
        r34 = false;
        goto L86
    L76:
        r29 = false;
        goto L77
    L126:
        return;
    L62:
        if (r23.intValue() != 1) goto L64;
        r24 = true;
        goto L65
    }

    @Override // n21.a
    public void handleMuteAiDynamicData(f31.h r17) {
        Intrinsics.checkNotNullParameter(r17, Constants.Keys.DATA);
        AiAssistantAnchorComponent r3 = this.aiAssistantComponent;
        if (r3 == null) goto L35;
        Intrinsics.checkNotNullParameter(r17, Constants.Keys.DATA);
        boolean r4 = true;
        if ((r17 instanceof f31.a) == false) goto L23;
        f31.a r0 = (f31.a) r17;
        HashMap<String, HashMap<String, Integer>> r1 = l51.a.a();
        HashMap<String, Integer> r10 = r1.get(r3.getContext().Ab());
        if (r10 != null) goto L9;
        r10 = new HashMap();
    L9:
        Integer r12 = r10.get("reject_count");
        if (r12 != null) goto L12;
        r12 = 0;
    L12:
        int r13 = r12.intValue();
        i97.a r14 = i97.a.a;
        r10.put("last_show_ts", Integer.valueOf((int) (System.currentTimeMillis() / ((long) WebcastRedirectException.UNKNOWN))));
        Integer r2 = r0.a();
        if (r2 != null) goto L16;
    L18:
        r3.d = false;
        r10.put("cellular_open", 0);
        int r15 = r13 + 1;
        r10.put("reject_count", Integer.valueOf(r15));
        if (r15 < 4) goto L21;
        r10.put("freq_control_always", 1);
    L21:
        r1.put(r3.getContext().Ab(), r10);
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        l51.a.O0.setValue(null, l51.a.a[104(0x68, float:1.46E-43)], r1);
        return;
    L16:
        if (r2.intValue() != 1) goto L18;
        r10.put("cellular_open", 1);
        r3.n(true);
        goto L21
    L23:
        if ((r17 instanceof f31.d) == false) goto L37;
        StringBuilder r5 = new StringBuilder("handleMuteAiDynamicData, ");
        f31.d r6 = (f31.d) r17;
        r5.append(r6.d());
        r5.append(", ");
        r5.append(r6.a());
        jy0.b.c("RevenueLinkBaseComponent", r5.toString(), null, 4);
        String r7 = r6.d();
        if (r7 == null) goto L38;
        Integer r8 = r6.a();
        if (r8 != null) goto L30;
    L33:
        r3.j(r7, r4);
        return;
    L30:
        if (r8.intValue() != 0) goto L33;
        r4 = false;
        goto L33
    L38:
        return;
    L37:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.h
    public void handlePkRoomClose(boolean r5) {
        if (r5 == false) goto L4;
        String r0 = "close_icon_room";
    L5:
        com.bytedance.android.live.revlink.link.biz.doublecomponent.c r1 = this.doublePKContextHolder;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("doublePKContextHolder");
    L8:
        r1.c.getDoublePkContext().handlePkEnd(r5);
        this.lifeControlComponent.a(null, r0, false, r5);
        return;
    L4:
        r0 = "close_icon_disconnect";
        goto L5
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.h
    public void onLynxMicInteractionEvent(int r6) {
        MultiWindowBizComponent r0 = this.windowBizComponent;
        if (r6 != 1) goto L26;
        Iterator<T> r7 = r0.c.iterator();
    L6:
        if (r7.hasNext() == false) goto L21;
        Object r1 = r7.next();
        String r2 = ((s) r1).i;
        Intrinsics.checkNotNullParameter(r0, "$this$mergeDoubleGuestUID");
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r3 = r0.getContext();
        if ((r3 instanceof com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a) == false) goto L13;
        f r4 = i.a(r0);
        if (r4 == null) goto L17;
        String r5 = i.u(r4);
    L19:
        if (Intrinsics.areEqual(r2, r5) == false) goto L6;
    L22:
        s r8 = (s) r1;
        if (r8 == null) goto L33;
        r8.e(false);
        return;
    L33:
        return;
    L17:
        r5 = "";
        goto L19
    L13:
        if ((r3 instanceof com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b) == false) goto L17;
        g r9 = i.b(r0);
        if (r9 == null) goto L17;
        r5 = i.v(r9);
        goto L19
    L21:
        r1 = null;
        goto L22
    L26:
        if (r6 != 2) goto L28;
        r0.getContext().getCommonService().h().b();
        return;
    L28:
        r0.getClass();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.b
    public void onReceiveSwitchChannelReply(b7 r12) {
        Intrinsics.checkNotNullParameter(r12, "multiChannelInfo");
        MultiRTCBizComponent r1 = this.rtcBizComponent;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r12, "multiChannelInfo");
        if (r12.getUseMultiChannel() == false) goto L17;
        Map r0 = r12.getChannelMap();
        if (r0 == null) goto L17;
        if ((!r0.isEmpty()) != true) goto L17;
        if (r1.e == true) goto L16;
        r1.p.setMultiChannelInfo(r12, true);
        Map<Long, String> r2 = r12.getChannelMap();
        if (r2 == null) goto L13;
        r1.k.a1(r2, "receiveSwitchChannelReply", String.valueOf(r1.getContext().G()));
    L13:
        UnexpectedFrameMonitor r3 = r1.k();
        if (r3 == null) goto L16;
        r3.o("receiveSwitchChannelReply");
    L16:
        r1.f.b("receiveSwitchChannelReply");
    L17:
        Map r13 = r12.getChannelMap();
        int r4 = 0;
        if (r13 == null) goto L30;
        Set r14 = r13.keySet();
        if (r14 == null) goto L30;
        ArrayList r5 = new ArrayList();
        Iterator r15 = r14.iterator();
    L23:
        if (r15.hasNext() == false) goto L31;
        Object r6 = r15.next();
        if (((Number) r6).longValue() == r1.getContext().getRoomID()) goto L27;
        boolean r7 = true;
    L28:
        if (r7 == false) goto L23;
        r5.add(r6);
        goto L23
    L27:
        r7 = false;
    L31:
        if (r5 == null) goto L33;
        r4 = r5.size();
    L33:
        if (r4 <= 1) goto L41;
        r1.p.getConnectionSubType().setValue("manual_nlink");
        return;
    L41:
        return;
    L30:
        r5 = null;
        goto L31
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.b, com.bytedance.android.live.revlink.impl.pk.service.h
    public void receiveChorusMessage(f0 r19) {
        Intrinsics.checkNotNullParameter(r19, "message");
        com.bytedance.android.live.revlink.link.biz.component.g r3 = this.chorusComponent;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r19, "message");
        int r1 = r19.getMsgType();
        boolean r4 = true;
        x3 r8 = null;
        if (r1 != 1) goto L5;
        w1 r2 = r19.getOpenChorusContent();
        if (r2 == null) goto L65;
        ChorusInfo r5 = r2.getChorusInfo();
        if (r5 == null) goto L65;
        Intrinsics.checkNotNullParameter(r5, "$this$leadSingerIdStringEx");
        String r6 = r5.getLeadSingerIdString();
    L67:
        if (r6 == null) goto L95;
        w1 r7 = r19.getOpenChorusContent();
        if (r7 == null) goto L73;
        ChorusInfo r9 = r7.getChorusInfo();
        if (r9 == null) goto L73;
        Intrinsics.checkNotNullParameter(r9, "$this$leadSingerIdStringEx");
        String r10 = r9.getLeadSingerIdString();
    L75:
        if (Intrinsics.areEqual(r10, r3.getContext().eg()) == false) goto L95;
        r3.e.c(true, true);
        r3.f.N1(true);
        Iterator r0 = ((CopyOnWriteArrayList) i.t(r3).a).iterator();
    L78:
        if (r0.hasNext() == false) goto L148;
        p r12 = (p) r0.next();
        IBaseUser r13 = r12.getUser();
        if (r13 == null) goto L82;
        String r14 = r13.getIdString();
    L84:
        if ((!Intrinsics.areEqual(r14, r3.getContext().eg())) == false) goto L78;
        com.bytedance.android.live.revenuelink.rtc.o r15 = r3.f.L().k(r12.getInteractId());
        if (r15 != null) goto L88;
    L90:
        boolean r16 = false;
    L91:
        com.bytedance.android.live.revenuelink.rtc.i r17 = r3.f;
        String r18 = r12.getInteractId();
        if (r18 != null) goto L94;
        r18 = "";
    L94:
        r17.R1(r18, r16);
        com.bytedance.android.live.revlink.impl.multianchor.ui.i r110 = r3.e;
        IBaseUser r20 = r12.getUser();
        Intrinsics.checkNotNull(r20);
        r110.l(r20.getIdString(), true, true, r16, true);
        jy0.b.f("ttlive_pk_link_chorus", "receiveOpenChorusMsg, isLeader, beforeMuteRemoteState: " + r16, null, 4);
        goto L78
    L88:
        if (r15.g != true) goto L90;
        r16 = true;
        goto L91
    L82:
        r14 = null;
        goto L84
    L148:
        return;
    L73:
        r10 = null;
    L95:
        r3.e.c(true, false);
        r3.f.N1(false);
        Iterator r22 = ((CopyOnWriteArrayList) i.t(r3).a).iterator();
    L97:
        if (r22.hasNext() == false) goto L114;
        p r23 = (p) r22.next();
        IBaseUser r111 = r23.getUser();
        if (r111 == null) goto L101;
        String r112 = r111.getIdString();
    L103:
        if ((!Intrinsics.areEqual(r112, r3.getContext().eg())) == false) goto L97;
        com.bytedance.android.live.revenuelink.rtc.o r113 = r3.f.L().k(r23.getInteractId());
        if (r113 != null) goto L107;
    L109:
        boolean r114 = false;
    L110:
        com.bytedance.android.live.revenuelink.rtc.i r115 = r3.f;
        String r116 = r23.getInteractId();
        if (r116 != null) goto L113;
        r116 = "";
    L113:
        r115.R1(r116, r114);
        com.bytedance.android.live.revlink.impl.multianchor.ui.i r117 = r3.e;
        IBaseUser r24 = r23.getUser();
        Intrinsics.checkNotNull(r24);
        r117.l(r24.getIdString(), true, true, r114, false);
        jy0.b.f("ttlive_pk_link_chorus", "receiveOpenChorusMsg, isSub, beforeMuteRemoteState: " + r114, null, 4);
        goto L97
    L107:
        if (r113.g != true) goto L109;
        r114 = true;
        goto L110
    L101:
        r112 = null;
        goto L103
    L114:
        Intrinsics.checkNotNullParameter(r19, "$this$openChorusContentEx");
        w1 r25 = r19.getOpenChorusContent();
        if (r25 == null) goto L117;
        r8 = (i7) r25.castTo(i7.class);
    L117:
        if (r8 == null) goto L144;
        String r26 = r8.getSubSingerToast();
        if (r26 != null) goto L121;
        return;
    L121:
        if (r26.length() > 0) goto L124;
        r4 = false;
    L124:
        if (r4 == false) goto L146;
        ToastUtil.b(r26, 0);
        return;
    L146:
        return;
    L144:
        return;
    L65:
        r6 = null;
        goto L67
    L5:
        if (r1 != 2) goto L147;
        r3.e.c(false, false);
        r3.f.n1();
        Iterator r27 = ((CopyOnWriteArrayList) i.t(r3).a).iterator();
    L9:
        if (r27.hasNext() == false) goto L23;
        p r28 = (p) r27.next();
        IBaseUser r118 = r28.getUser();
        if (r118 == null) goto L13;
        String r119 = r118.getIdString();
    L15:
        if ((!Intrinsics.areEqual(r119, r3.getContext().eg())) == false) goto L9;
        com.bytedance.android.live.revenuelink.rtc.o r120 = r3.f.L().k(r28.getInteractId());
        if (r120 != null) goto L19;
    L21:
        boolean r121 = false;
    L22:
        com.bytedance.android.live.revlink.impl.multianchor.ui.i r122 = r3.e;
        IBaseUser r29 = r28.getUser();
        Intrinsics.checkNotNull(r29);
        r122.l(r29.getIdString(), false, true, r121, false);
        jy0.b.f("ttlive_pk_link_chorus", "receiveCloseChorusMsg, beforeMuteRemoteState: " + r121, null, 4);
        goto L9
    L19:
        if (r120.k != true) goto L21;
        r121 = true;
        goto L22
    L13:
        r119 = null;
        goto L15
    L23:
        Intrinsics.checkNotNullParameter(r19, "$this$closeChorusContentEx");
        com.bytedance.android.livesdk.link.model.bridge.g0 r30 = r19.getCloseChorusContent();
        if (r30 == null) goto L26;
        r8 = r30.castTo(x3.class);
    L26:
        if (r8 == null) goto L142;
        Intrinsics.checkNotNullParameter(r8, "$this$closerIdEx");
        if (Intrinsics.areEqual(r8.getCloserId(), r3.getContext().eg()) == false) goto L33;
        if (r8.getCloseReason() == 9) goto L33;
        int r32 = ToastUtil.a;
        int r33 = w11.a.a;
        ToastUtil.a(2131921392, 0);
    L39:
        com.bytedance.android.live.liveinteract.model.a r34 = r8.getChorusInfo();
        long r35 = 0;
        if (r34 == null) goto L42;
        long r36 = r34.getFinishTime();
    L44:
        if (r36 <= 0) goto L59;
        com.bytedance.android.live.liveinteract.model.a r37 = r8.getChorusInfo();
        if (r37 == null) goto L48;
        long r38 = r37.getStartTime();
    L50:
        if (r38 <= 0) goto L59;
        com.bytedance.android.live.liveinteract.model.a r39 = r8.getChorusInfo();
        if (r39 == null) goto L54;
        long r40 = r39.getFinishTime();
    L55:
        com.bytedance.android.live.liveinteract.model.a r42 = r8.getChorusInfo();
        if (r42 == null) goto L58;
        r35 = r42.getStartTime();
    L58:
        r35 = r40 - r35;
        goto L59
    L54:
        r40 = 0;
        goto L55
    L48:
        r38 = 0;
    L59:
        r3.a(r8.getCloseReason(), r4, r35);
        return;
    L42:
        r36 = 0;
    L33:
        if (r8.getToast().length() > 0) goto L36;
        r4 = false;
    L36:
        if (r4 == false) goto L38;
        int r43 = ToastUtil.a;
        ToastUtil.b(r8.getToast(), 0);
    L38:
        r4 = false;
        goto L39
    L142:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.b
    public void setAnchorLinkFinisher(boolean r5) {
        this.bizDataContext.a(r5, this.pkContextHolder.c.getBasePKContext(), this.pkContextHolder.c, false);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.b
    public void startSwitchPk(com.bytedance.android.live.revlink.impl.mergepk.pkdouble.g r2) {
        this.switchToPkImpl.startSwitchPk(r2);
    }

    public static final /* synthetic */ void access$setDoubleMute(RevLinkBizAnchorMultiService r0, boolean r1) {
        r0.setDoubleMute(r1);
    }

    public static final /* synthetic */ void access$stopRtc(RevLinkBizAnchorMultiService r0, String r1) {
        r0.stopRtc(r1);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.h
    public void finishInteract(String r2, Integer r3) {
        DoubleCompactComponent r4 = this.doubleCompactComponent;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("doubleCompactComponent");
    L5:
        r4.a(r3);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.b
    public void finishInternal(Function0<Unit> r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "reqSrc");
        this.lifeControlComponent.a(r3, r4, r5, false);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.b
    public void kickOut(String r6, String r7, ILinkerKickOutContent.KickOutSource r8) {
        Intrinsics.checkNotNullParameter(r7, "reqSrc");
        Intrinsics.checkNotNullParameter(r8, "kickOutSource");
        s51.c r9 = RevLinkDomainAnchorService.f(this.domainService, r6, null, 2);
        if (r9 == null) goto L6;
        Function1<String, Boolean> r2 = new C03711(this);
        Intrinsics.checkNotNullParameter(r7, "reqSrc");
        Intrinsics.checkNotNullParameter(r8, "kickOutSource");
        Intrinsics.checkNotNullParameter(r2, "validCheck");
        r9.k.a(r7, r8, r2);
        return;
    }

    public void selectLinkAnchorTargetStream(p r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "reqSrc");
        this.rtcBizComponent.q(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.b
    public void setFollowState(String r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        this.followComponent.a(r2, r3, r4);
    }

    public RevLinkBizAnchorMultiService(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r23, com.bytedance.android.livesdk.revenue.service.room.c r24, yz0.g r25, RevLinkDomainAnchorService r26, com.bytedance.android.live.revenuelink.rtc.i r27, ld.a r28, yz0.f r29, com.bytedance.android.livesdk.revenue.service.message.d r30, com.bytedance.android.live.revlink.link.streaminteract.biz.c r32, MultiPkScopeProviderService r33, PushModeManagerService r34, AnchorUILayoutManager r35, x11.a r36, k11.f r37, RTCAdvanceManagerService r38) {
        Intrinsics.checkNotNullParameter(r23, "context");
        Intrinsics.checkNotNullParameter(r24, "roomService");
        Intrinsics.checkNotNullParameter(r25, "newRoomService");
        Intrinsics.checkNotNullParameter(r26, "domainService");
        Intrinsics.checkNotNullParameter(r27, "rtcManager");
        Intrinsics.checkNotNullParameter(r28, "linkInternalDataSet");
        Intrinsics.checkNotNullParameter(r29, "messageService");
        Intrinsics.checkNotNullParameter(r30, "messageManagerService");
        Intrinsics.checkNotNullParameter(r32, "streamMixManagerService");
        Intrinsics.checkNotNullParameter(r33, "multiPkScopeService");
        Intrinsics.checkNotNullParameter(r34, "pushManager");
        Intrinsics.checkNotNullParameter(r35, "uiLayoutManager");
        Intrinsics.checkNotNullParameter(r36, "internalLinkService");
        Intrinsics.checkNotNullParameter(r37, "dynamicLinkInfoService");
        Intrinsics.checkNotNullParameter(r38, "rtcAdvanceManagerService");
        this.context = r23;
        this.roomService = r24;
        this.newRoomService = r25;
        this.domainService = r26;
        this.rtcManager = r27;
        this.linkInternalDataSet = r28;
        this.messageService = r29;
        this.messageManagerService = r30;
        this.streamMixManagerService = r32;
        this.multiPkScopeService = r33;
        this.pushManager = r34;
        this.uiLayoutManager = r35;
        this.internalLinkService = r36;
        this.dynamicLinkInfoService = r37;
        this.rtcAdvanceManagerService = r38;
        com.bytedance.android.live.revlink.link.biz.component.h r1 = new com.bytedance.android.live.revlink.link.biz.component.h(getContext(), r27, r24, r36);
        this.bizDataContext = r1;
        this.cd = new CompositeDisposable();
        com.bytedance.android.live.revlink.link.domain.service.a r3 = r26.g;
        this.muteManager = r3;
        e[] r2 = new e[23];
        BackgroundComponent r14 = new BackgroundComponent(getContext());
        this.backgroundComponent = r14;
        Unit r4 = Unit.INSTANCE;
        r2[0] = r14;
        MultiPKContextHolder r5 = new MultiPKContextHolder(getContext(), r24, r29, r30, r14);
        this.pkContextHolder = r5;
        r2[1] = r5;
        com.bytedance.android.live.revlink.link.biz.doublecomponent.c r6 = new com.bytedance.android.live.revlink.link.biz.doublecomponent.c(getContext(), r24, r29, r30);
        this.doublePKContextHolder = r6;
        r2[2] = r6;
        MultiLinkContextComponent r8 = new MultiLinkContextComponent(getContext(), r24);
        this.linkContextComponent = r8;
        r2[3] = r8;
        MultiBizLifeControlComponent r7 = new MultiBizLifeControlComponent(getContext(), r28, r24, r1, r29, r27, r34, r35, new RevLinkBizAnchorMultiService$components$5(this), new RevLinkBizAnchorMultiService$components$6(this));
        this.lifeControlComponent = r7;
        r2[4] = r7;
        r2[5] = new RoomStateDispatchAnchorComponent(getContext(), r27, r35, r1, r24, r5.c.getBasePKContext());
        MultiWindowBizComponent r9 = new MultiWindowBizComponent(getContext(), r24, r3, r26, r35);
        this.windowBizComponent = r9;
        r2[6] = r9;
        MultiRTCBizComponent r12 = new MultiRTCBizComponent(getContext(), r1, r27, r3, r7, r24, r32, r8.b, r29, new RevLinkBizAnchorMultiService$components$9(this));
        this.rtcBizComponent = r12;
        r2[7] = r12;
        r2[8] = new MultiInteractIconComponent(getContext(), r5);
        MultiFollowState r10 = new MultiFollowState(getContext(), r26);
        this.followComponent = r10;
        r2[9] = r10;
        com.bytedance.android.live.revlink.link.biz.component.g r13 = new com.bytedance.android.live.revlink.link.biz.component.g(getContext(), r3, r27, r1);
        this.chorusComponent = r13;
        r2[10] = r13;
        AutoStartPKComponent r15 = new AutoStartPKComponent(getContext(), r5, r38, r37);
        this.autoStartPKComponent = r15;
        r2[11] = r15;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r16 = getContext();
        MultiAnchorLinkContext r17 = r8.b;
        AutoStartPKComponent r18 = this.autoStartPKComponent;
        if (r18 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("autoStartPKComponent");
    L5:
        MultiSwitchToPkImplV2 r19 = new MultiSwitchToPkImplV2(r16, r24, r27, r1, r17, r5, r12, r35, r34, r18);
        this.switchToPkImpl = r19;
        r2[12] = r19;
        r2[13] = new MultiForegroundComponent(getContext(), r12, r1, r32, r29);
        MultiPKLauncherComponent r20 = new MultiPKLauncherComponent(getContext(), r1, r19);
        this.multiPKLauncherComponent = r20;
        r2[14] = r20;
        r2[15] = new MultiLastResultComponent(getContext(), r5);
        DoubleCompactComponent r22 = new DoubleCompactComponent(getContext(), r24, r7, r5.c.getBasePKContext(), r20.c, r1);
        this.doubleCompactComponent = r22;
        r2[16] = r22;
        com.bytedance.android.live.revlink.link.biz.component.e r39 = new com.bytedance.android.live.revlink.link.biz.component.e(getContext());
        this.linkTimeRecorder = r39;
        r2[17] = r39;
        r2[18] = new DoubleAudienceLinkComponent(getContext(), r35);
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r40 = getContext();
        PkBaseDataContext r42 = r5.c.getBasePKContext();
        com.bytedance.android.live.revlink.link.biz.doublecomponent.c r110 = this.doublePKContextHolder;
        if (r110 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("doublePKContextHolder");
    L8:
        r2[19] = new SwitchSceneCompactComponent(r40, r24, r14, r42, r32, r1, r27, r5, r110, r13, r12, r29, r26, r8.b, r33);
        r2[20] = new com.bytedance.android.live.revlink.link.biz.component.p(getContext());
        r2[21] = new com.bytedance.android.live.revlink.link.biz.component.c(getContext());
        AiAssistantAnchorComponent r43 = new AiAssistantAnchorComponent(getContext(), r24, r25, r29, r12, r3);
        this.aiAssistantComponent = r43;
        r2[22] = r43;
        this.components = CollectionsKt.listOf(r2);
    }
}
