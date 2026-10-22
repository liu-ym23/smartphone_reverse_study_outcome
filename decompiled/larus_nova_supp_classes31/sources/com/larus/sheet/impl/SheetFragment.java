package com.larus.sheet.impl;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common.apphost.AppHost;
import com.larus.office.OfficeInputParam;
import com.larus.office.base.OfficeBaseFragment;
import com.larus.office.base.view.CotHeaderView;
import com.larus.office.permission.DocPermissionFullData;
import com.larus.platform.api.f3$a;
import com.larus.platform.service.e2;
import com.larus.sheet.biz.impl.databinding.LarusLayoutSheetDetailFragmentBinding;
import com.larus.sheet.impl.view.SheetLoadLayout;
import com.larus.sheet.sdk.api.ISheetSdkProxyService;
import com.larus.sheet.sdk.api.ISheetSdkServiceV2;
import com.larus.sheet.sdk.api.orientation.TitleBarStates;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import tx9.a1;
import v19.c7;
import v19.i5;
import va8.g0;
import va8.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002AL\b\u0016\u0018\u0000 Ì\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002Ì\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010N\u001a\u00020\u000bH\u0016J\u0012\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\b\u0010S\u001a\u00020\rH\u0014J\u001a\u0010T\u001a\u00020\u00022\u0006\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010XH\u0014J\u0010\u0010Y\u001a\u00020P2\u0006\u0010Z\u001a\u00020[H\u0014J\u0012\u0010\\\u001a\u0004\u0018\u00010D2\u0006\u0010Z\u001a\u00020[H\u0014J\b\u0010]\u001a\u00020PH\u0016J\b\u0010^\u001a\u00020RH\u0014J\u001a\u0010_\u001a\u00020P2\u0006\u0010`\u001a\u00020a2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\b\u0010b\u001a\u00020PH\u0002J\b\u0010c\u001a\u00020PH\u0002J\u0010\u0010d\u001a\u00020P2\u0006\u0010e\u001a\u00020fH\u0016J\u0010\u0010g\u001a\u00020\u000b2\u0006\u0010h\u001a\u00020fH\u0002J\b\u0010i\u001a\u00020PH\u0002J\b\u0010j\u001a\u00020PH\u0002J\u0006\u0010k\u001a\u00020PJ\b\u0010l\u001a\u00020mH\u0002J\b\u0010n\u001a\u00020\u0014H\u0014J\b\u0010o\u001a\u00020\rH\u0014J\b\u0010p\u001a\u00020\u0014H\u0014J\u001c\u0010q\u001a\u00020P2\b\u00101\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010r\u001a\u00020PH\u0002J\b\u0010s\u001a\u00020PH\u0002J\b\u0010t\u001a\u00020\u000bH\u0016J\b\u0010u\u001a\u00020\rH\u0016J\b\u0010v\u001a\u00020PH\u0002J\n\u0010w\u001a\u0004\u0018\u00010XH\u0016J\u0012\u0010x\u001a\u00020P2\b\u0010y\u001a\u0004\u0018\u00010XH\u0016Jv\u0010z\u001a\u00020P2\b\u0010{\u001a\u0004\u0018\u00010|2\u0012\u0010}\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020P0~2\u0006\u0010\u007f\u001a\u00020\r2\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u00012\u0012\b\u0002\u0010\u0082\u0001\u001a\u000b\u0012\u0004\u0012\u00020P\u0018\u00010\u0083\u00012\u0012\b\u0002\u0010\u0084\u0001\u001a\u000b\u0012\u0004\u0012\u00020P\u0018\u00010\u0083\u00012\u0012\b\u0002\u0010\u0085\u0001\u001a\u000b\u0012\u0004\u0012\u00020P\u0018\u00010\u0083\u0001H\u0002J \u0010\u0086\u0001\u001a\u00020P2\u0015\u0010\u0087\u0001\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020P\u0018\u00010~H\u0002J\t\u0010\u0088\u0001\u001a\u00020PH\u0002J\u0012\u0010\u0089\u0001\u001a\u00020P2\u0007\u0010\u008a\u0001\u001a\u00020\u000bH\u0002J\u001b\u0010\u008b\u0001\u001a\u00020P2\u0007\u0010\u008c\u0001\u001a\u00020\u000b2\u0007\u0010\u008d\u0001\u001a\u00020\rH\u0002J\t\u0010\u008e\u0001\u001a\u00020PH\u0002J\u001f\u0010\u008f\u0001\u001a\u00020P2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\r2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\rH\u0002J\t\u0010\u0092\u0001\u001a\u00020PH\u0002J\t\u0010\u0093\u0001\u001a\u00020PH\u0002J\u0010\u0010\u0094\u0001\u001a\u00020P2\u0007\u0010\u008c\u0001\u001a\u00020\u000bJ\t\u0010\u0095\u0001\u001a\u00020PH\u0016J1\u0010\u0096\u0001\u001a\u00020P2\b\u00101\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\b\u00102\u001a\u0004\u0018\u00010\rH\u0016J\t\u0010\u0097\u0001\u001a\u00020PH\u0002J\t\u0010\u0098\u0001\u001a\u00020\rH\u0016J\u000b\u0010\u0099\u0001\u001a\u0004\u0018\u00010\rH\u0002J\t\u0010\u009a\u0001\u001a\u00020PH\u0016J\n\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0016J\t\u0010\u009d\u0001\u001a\u00020\u0014H\u0002J\t\u0010 \u0001\u001a\u00020PH\u0002J\u0013\u0010£\u0001\u001a\u00020P2\b\u0010¤\u0001\u001a\u00030¢\u0001H\u0016J\u0010\u0010¥\u0001\u001a\u00020P2\u0007\u0010¦\u0001\u001a\u00020\u000bJ\t\u0010¨\u0001\u001a\u00020PH\u0002J\t\u0010©\u0001\u001a\u00020PH\u0002J\t\u0010ª\u0001\u001a\u00020PH\u0016J\t\u0010«\u0001\u001a\u00020PH\u0014J\t\u0010¬\u0001\u001a\u00020PH\u0016J\u0012\u0010\u00ad\u0001\u001a\u00020P2\u0007\u0010®\u0001\u001a\u00020\u0014H\u0016J\u0007\u0010¯\u0001\u001a\u00020PJ\u001b\u0010°\u0001\u001a\u00020P2\u0007\u0010±\u0001\u001a\u00020\u00142\u0007\u0010\u008d\u0001\u001a\u00020\rH\u0002J\u001d\u0010²\u0001\u001a\u00020P2\u0007\u0010\u008d\u0001\u001a\u00020\r2\t\b\u0002\u0010³\u0001\u001a\u00020<H\u0002J\t\u0010´\u0001\u001a\u00020\u0014H\u0002J\t\u0010µ\u0001\u001a\u00020\u0014H\u0002J\u000b\u0010¶\u0001\u001a\u0004\u0018\u00010\rH\u0002J\u000b\u0010·\u0001\u001a\u0004\u0018\u00010\rH\u0002J\t\u0010¸\u0001\u001a\u00020\u000bH\u0002J\t\u0010¹\u0001\u001a\u00020PH\u0002J\t\u0010º\u0001\u001a\u00020PH\u0002J\f\u0010»\u0001\u001a\u0005\u0018\u00010¼\u0001H\u0016J\u000b\u0010½\u0001\u001a\u0004\u0018\u00010DH\u0016J\u0014\u0010¾\u0001\u001a\u00020P2\t\u0010¿\u0001\u001a\u0004\u0018\u00010DH\u0016J\u000b\u0010À\u0001\u001a\u0004\u0018\u00010\rH\u0016J\t\u0010Á\u0001\u001a\u00020\u0014H\u0016J\t\u0010Â\u0001\u001a\u00020\u0014H\u0016J\u0019\u0010Ã\u0001\u001a\u00020P2\u000e\u0010Ä\u0001\u001a\t\u0012\u0004\u0012\u00020P0\u0083\u0001H\u0016J\u001a\u0010Å\u0001\u001a\u0004\u0018\u00010D2\u0006\u0010Z\u001a\u00020[H\u0096@¢\u0006\u0003\u0010Æ\u0001J\u000b\u0010Ç\u0001\u001a\u0004\u0018\u00010>H\u0002J\n\u0010È\u0001\u001a\u00030É\u0001H\u0016J\u000b\u0010Ê\u0001\u001a\u0004\u0018\u00010[H\u0016J\t\u0010Ë\u0001\u001a\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010+\"\u0004\b/\u0010-R\u000e\u00100\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r05X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00109\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010:R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0004\n\u0002\u0010BR\u001c\u0010C\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u000e\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u00020LX\u0082\u000e¢\u0006\u0004\n\u0002\u0010MR\u0012\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010§\u0001\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Í\u0001"}, d2 = {"Lcom/larus/sheet/impl/SheetFragment;", "Lcom/larus/office/base/OfficeBaseFragment;", "Lcom/larus/sheet/biz/impl/databinding/LarusLayoutSheetDetailFragmentBinding;", "Lcom/larus/bmhome/ability/FloatChatFoldStatusChangeListener;", "Lcom/larus/sheet/api/ISheetCotInfoListener;", "Lcom/larus/sheet/sdk/api/ISupportChangeScreenConfigPage;", "Lcom/larus/sheet/sdk/api/IGetTrackInfo;", "Lcom/larus/office/base/component/permission/NoPermissionPageHost;", "<init>", "()V", "customHeaderShowing", "", "slidesToken", "", "getSlidesToken", "()Ljava/lang/String;", "setSlidesToken", "(Ljava/lang/String;)V", "artifactVersionId", "resourceVersion", "", "conversationId", "sheetName", "firstInitChatFrag", "chatService", "Lcom/larus/sheet/sdk/api/IChatService;", "titleBarService", "Lcom/larus/office/base/service/ITitleBarService;", "selectionChangeService", "Lcom/larus/sheet/sdk/api/ISelectionChangeService;", "loadingService", "Lcom/larus/office/base/page/ILoadingService;", "enterMethod", "isSlidesDeleted", "hasReportPresentationBtnShow", "undoBtnEnabled", "hasReportUndoBtnShow", "redoBtnEnabled", "hasReportRedoBtnShow", "moreBtnEnabled", "hasReportMoreBtnShow", "renderStared", "isLandscapeMode", "()Z", "setLandscapeMode", "(Z)V", "isPad", "setPad", "cotRefArtifacts", "artifactMetaId", "boundMessageId", "botId", "deferredMsgId", "Lkotlinx/coroutines/CompletableDeferred;", "pendingSelectionData", "pendingSelectionPlainText", "latestSpreadsheetVersion", "lastAppBarHeight", "Ljava/lang/Integer;", "setServiceTimeStamp", "", "permissionAbility", "Lcom/larus/office/base/component/permission/IOfficePermissionChangeAbility;", "hasReceivedPermissionData", "permissionStateListener", "com/larus/sheet/impl/SheetFragment$permissionStateListener$1", "Lcom/larus/sheet/impl/SheetFragment$permissionStateListener$1;", "docContainerFragment", "Landroidx/fragment/app/Fragment;", "getDocContainerFragment", "()Landroidx/fragment/app/Fragment;", "setDocContainerFragment", "(Landroidx/fragment/app/Fragment;)V", "chatInputAndCotLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "speakStateListener", "com/larus/sheet/impl/SheetFragment$speakStateListener$1", "Lcom/larus/sheet/impl/SheetFragment$speakStateListener$1;", "canDelete", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getLogTag", "getViewBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onInitHostFragment", "context", "Landroid/content/Context;", "initChameleonFragment", "onFloatChatFragmentInited", "getParamsBundle", "onViewCreated", "view", "Landroid/view/View;", "adapterSourceTitleBarContainerBeforeInjectToOfficeSDKLayout", "initParams", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "getOrientationParam", "configuration", "adaptChatSpeakerInPad", "initHeadView", "onBackPressed", "getWebTrackParams", "Lcom/google/gson/JsonObject;", "getFloatChatFragmentContainerId", "getLocalConvIdSuffix", "getResourceType", "refreshArtifactInfo", "attachServices", "detachServices", "autoLogEnterPage", "generateDocLogicKeyForFindService", "initTitleBarService", "onObtainTitleBar", "onReadyInitTitleBar", "titleBar", "setupSearchMenuItem", "menuData", "Lcom/larus/office/base/service/BizMenuData;", "onMenuClick", "Lkotlin/Function1;", "itemId", "itemView", "Landroid/widget/ImageView;", "onMobShow", "Lkotlin/Function0;", "onMobClick", "onItemClick", "showMoreMenu", "moreMenuItemClick", "initChatService", "updateEditPanelHeight", "isActive", "updateChatInputVisibility", "isVisible", "from", "initSelectionChangeService", "applySelectionChange", "elementData", "plainText", "applyPendingSelectionChangeIfNeeded", "initLoadingService", "setSheetChatInputVisible", "onDestroy", "updateArtifactInfo", "reportEnterPage", "getCurrentPageName", "getPreviousPage", "foldStatusChanged", "getTraceParams", "Lorg/json/JSONObject;", "getTrackingResourceType", "appBackgroundListener", "Lcom/larus/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;", "initAppBackgroundListener", "curCotInfo", "Lcom/larus/bmhome/chat/bean/HeadTitleInfoSimplify;", "onCotInfoUpdate", "cotInfo", "setFullscreenMode", "fullScreenMode", "isHeaderViewLastVisible", "resetHeaderViewLastVisible", "interceptHeaderViewVisible", "changeOrientationMode", "adapterTitleBarOnOrientationMode", "onDestroyView", "toggleTitleBar", "states", "hideKeyboard", "updateHeaderViewVisibility", "visibility", "notifyChatInputAndCotHeightChanged", "delay", "calculateChatInputHeight", "calculateChatInputAndCotHeight", "getArtifactCreateMethod", "getEnterMethod", "isSheetOwner", "attachComponent", "initPermissionAbility", "getSupportFragmentManager", "Landroidx/fragment/app/FragmentManager;", "getOfficeContainerFragment", "setOfficeContainerFragment", "fragment", "getToken", "getNoPermissionContainerId", "getOfficeContainerId", "runWhenAdded", "action", "createOfficeFragment", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPermissionAbility", "getNoPermissionBundleData", "Lcom/larus/office/base/component/permission/NoPermissionBundleData;", "getHostContext", "isHistoryVersion", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public class SheetFragment extends OfficeBaseFragment<LarusLayoutSheetDetailFragmentBinding> implements mw9.b, pw9.e, pw9.b, com.larus.office.base.component.permission.c {
    public static final /* synthetic */ int R = 0;
    public boolean A;
    public String B;
    public String C;
    public final CompletableDeferred<String> D;
    public String E;
    public String F;
    public String G;
    public final long H;
    public com.larus.office.base.component.permission.a I;
    public boolean J;
    public final b K;
    public Fragment L;
    public final com.larus.sheet.impl.c M;
    public final c N;
    public l O;
    public ic8.t P;
    public boolean Q;
    public boolean i;
    public String j;
    public String k;
    public String l;
    public String m;
    public n n;
    public SheetFragment$initTitleBarService$1 o;
    public p p;
    public o q;
    public String r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public static final class a {
    }

    public static final class b implements com.larus.office.base.component.permission.a.a {
        public final /* synthetic */ SheetFragment a;

        public b(SheetFragment r1) {
            this.a = r1;
        }

        public final void a(DocPermissionFullData r2) {
            Intrinsics.checkNotNullParameter(r2, "permission");
            this.a.J = true;
        }
    }

    public static final class c implements com.larus.bmhome.chat.component.bottom.core.speaker.h {
        public final /* synthetic */ SheetFragment a;

        public c(SheetFragment r1) {
            this.a = r1;
        }

        public final void a(com.larus.bmhome.chat.component.bottom.core.speaker.g r6) {
            Intrinsics.checkNotNullParameter(r6, "state");
            FLogger.a.i("onStateChanged", "onStateChanged state=" + r6);
            boolean r3 = true;
            if (Intrinsics.areEqual(r6, com.larus.bmhome.chat.component.bottom.core.speaker.g.c.a) == false) goto L15;
            SheetFragment r7 = this.a;
            int r0 = SheetFragment.R;
            LarusLayoutSheetDetailFragmentBinding r8 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) r7).e;
            if (r8 == null) goto L11;
            CotHeaderView r9 = r8.e;
            if (r9 == null) goto L11;
            if (r9.getVisibility() != 0) goto L11;
        L12:
            if (r3 == false) goto L46;
            this.a.sa0(4, "speakerStateChanged");
            return;
        L46:
            return;
        L11:
            r3 = false;
            goto L12
        L15:
            if (Intrinsics.areEqual(r6, com.larus.bmhome.chat.component.bottom.core.speaker.g.b.a) == false) goto L17;
            SheetFragment r10 = this.a;
            r10.Q = false;
            r10.sa0(8, "speakerStateChanged");
            return;
        L17:
            SheetFragment r11 = this.a;
            int r1 = SheetFragment.R;
            LarusLayoutSheetDetailFragmentBinding r12 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) r11).e;
            if (r12 == null) goto L24;
            CotHeaderView r13 = r12.e;
            if (r13 == null) goto L24;
            if (r13.getVisibility() != 4) goto L24;
            boolean r14 = true;
        L25:
            if (r14 == false) goto L49;
            Fragment r15 = ((OfficeBaseFragment) this.a).f;
            if (r15 != null) goto L29;
        L31:
            boolean r16 = false;
        L32:
            if (r16 == false) goto L50;
            Fragment r17 = ((OfficeBaseFragment) this.a).f;
            if (r17 == null) goto L42;
            t1a.b r18 = s1a.a.g(r17);
            if (r18 == null) goto L42;
            g0 r19 = r18.getAbility(g0.class);
            if (r19 == null) goto L42;
            if (r19.YC() != true) goto L42;
        L43:
            if (r3 == true) goto L51;
            this.a.ma0();
            return;
        L51:
            return;
        L42:
            r3 = false;
            goto L43
        L50:
            return;
        L29:
            if (r15.isAdded() != true) goto L31;
            r16 = true;
            goto L32
        L49:
            return;
        L24:
            r14 = false;
            goto L25
        }
    }

    /* JADX INFO: renamed from: com.larus.sheet.impl.SheetFragment$onCotInfoUpdate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.sheet.impl.SheetFragment$onCotInfoUpdate$1", f = "SheetFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ic8.t $cotInfo;
        final /* synthetic */ Ref.ObjectRef<ic8.t> $result;
        int label;
        final /* synthetic */ SheetFragment this$0;

        public AnonymousClass1(ic8.t r1, SheetFragment r2, Ref.ObjectRef<ic8.t> r3, Continuation<? super AnonymousClass1> r4) {
            this.$cotInfo = r1;
            this.this$0 = r2;
            this.$result = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$cotInfo, this.this$0, this.$result, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L30;
            ResultKt.throwOnFailure(r5);
            boolean r2 = false;
            if (this.$cotInfo.f != 3) goto L7;
            SheetFragment r6 = this.this$0;
            r6.Q = false;
            r6.sa0(8, "onCotInfoUpdateDismiss");
        L22:
            SheetFragment r7 = this.this$0;
            int r0 = SheetFragment.R;
            LarusLayoutSheetDetailFragmentBinding r8 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) r7).e;
            if (r8 == null) goto L28;
            CotHeaderView r9 = r8.e;
            if (r9 == null) goto L28;
            r9.R5((ic8.t) this.$result.element);
        L28:
            return Unit.INSTANCE;
        L7:
            SheetFragment r10 = this.this$0;
            int r1 = SheetFragment.R;
            r10.getClass();
            ic8.t r11 = this.$cotInfo;
            if (r11.f != 2) goto L10;
            Ref.ObjectRef<ic8.t> r3 = this.$result;
            r3.element = ic8.t.a(r11);
            SheetFragment r12 = this.this$0;
            r12.Q = false;
            r12.sa0(8, "onCotInfoUpdateEnd");
            goto L22
        L10:
            Fragment r13 = ((OfficeBaseFragment) this.this$0).f;
            if (r13 == null) goto L19;
            t1a.b r14 = s1a.a.g(r13);
            if (r14 == null) goto L19;
            g0 r15 = r14.getAbility(g0.class);
            if (r15 == null) goto L19;
            if (r15.YC() != true) goto L19;
            r2 = true;
        L19:
            if (r2 == false) goto L21;
            this.this$0.sa0(4, "onCotInfoUpdateExpand");
            goto L22
        L21:
            this.this$0.ma0();
            goto L22
        L30:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final int C3() {
        return 2131369315;
    }

    public final int J7() {
        return 2131386184;
    }

    public final int V90() {
        return 2131386154;
    }

    public final String W90() {
        return "-sheets-detail";
    }

    public final int Y90() {
        return 12;
    }

    public final String getLogTag() {
        return "SheetFragment";
    }

    @Override // pw9.e
    public final String ha() {
        return "";
    }

    public final String k() {
        return "aisheet_detail";
    }

    public final com.larus.office.base.component.permission.b X2() {
        com.larus.office.base.component.permission.a r0 = this.I;
        if (r0 != null) goto L5;
        r0 = (com.larus.office.base.component.permission.a) s1a.a.g(this).getAbility(com.larus.office.base.component.permission.a.class);
    L5:
        ArrayList r1 = null;
        if (r0 == null) goto L13;
        DocPermissionFullData r2 = r0.C4();
        if (r2 == null) goto L13;
        fo9.f r3 = r2.getOwner();
        if (r3 == null) goto L13;
        String r4 = r3.a;
        if (r4 == null) goto L13;
    L30:
        String r6 = r4;
        Bundle r5 = getArguments();
        if (r5 == null) goto L33;
        String r7 = r5.getString("sheets_token");
    L34:
        String r8 = this.m;
        Bundle r9 = getArguments();
        if (r9 == null) goto L37;
        String r10 = r9.getString("enter_method");
    L38:
        Bundle r11 = getArguments();
        if (r11 == null) goto L41;
        String r12 = r11.getString("key_apply_permission_message_id");
    L42:
        Bundle r13 = getArguments();
        if (r13 == null) goto L45;
        String r14 = r13.getString("key_apply_permission_conversation_id");
    L46:
        Bundle r15 = getArguments();
        if (r15 == null) goto L50;
        r1 = com.larus.office.base.preview.a.a(r15, "key_doc_list_to_apply_permission");
    L50:
        return new com.larus.office.base.component.permission.b(r7, r8, r6, 3, r10, r12, r14, r1);
    L45:
        r14 = null;
        goto L46
    L41:
        r12 = null;
        goto L42
    L37:
        r10 = null;
        goto L38
    L33:
        r7 = null;
    L13:
        if (r0 == null) goto L19;
        DocPermissionFullData r16 = r0.C4();
        if (r16 == null) goto L19;
        fo9.f r17 = r16.getOwner();
        if (r17 == null) goto L19;
        r4 = r17.b;
    L20:
        if (r4 != null) goto L30;
        if (r0 == null) goto L27;
        DocPermissionFullData r18 = r0.C4();
        if (r18 == null) goto L27;
        fo9.f r19 = r18.getOwner();
        if (r19 == null) goto L27;
        r4 = r19.c;
    L28:
        if (r4 != null) goto L30;
        r4 = "";
    L27:
        r4 = null;
    L19:
        r4 = null;
        goto L20
    }

    public final void ca0() {
        Fragment r0 = ((OfficeBaseFragment) this).f;
        if (r0 == null) goto L9;
        t1a.b r1 = s1a.a.g(r0);
        if (r1 == null) goto L9;
        va8.r r2 = r1.o(Reflection.getOrCreateKotlinClass(va8.r.class));
        if (r2 == null) goto L9;
        r2.JD("aisheet_detail");
    L9:
        Fragment r3 = ((OfficeBaseFragment) this).f;
        if (r3 == null) goto L16;
        t1a.b r4 = s1a.a.g(r3);
        if (r4 == null) goto L16;
        va8.o r5 = r4.o(Reflection.getOrCreateKotlinClass(va8.o.class));
        if (r5 == null) goto L16;
        int r6 = com.larus.office.k.a;
        r5.S6(getString(2131897740));
    L16:
        Fragment r7 = ((OfficeBaseFragment) this).f;
        if (r7 == null) goto L23;
        t1a.b r8 = s1a.a.g(r7);
        if (r8 == null) goto L23;
        va8.o r9 = r8.o(Reflection.getOrCreateKotlinClass(va8.o.class));
        if (r9 == null) goto L23;
        int r10 = com.larus.office.k.a;
        r9.HH(getString(2131897740));
    L23:
        Fragment r11 = ((OfficeBaseFragment) this).f;
        if (r11 == null) goto L30;
        t1a.b r12 = s1a.a.g(r11);
        if (r12 == null) goto L30;
        mw9.a r13 = r12.o(Reflection.getOrCreateKotlinClass(mw9.a.class));
        if (r13 == null) goto L30;
        r13.f80(this);
    L30:
        Fragment r14 = ((OfficeBaseFragment) this).f;
        if (r14 == null) goto L37;
        t1a.b r15 = s1a.a.g(r14);
        if (r15 == null) goto L37;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r16 = r15.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r16 == null) goto L37;
        r16.e8(this.N);
    L37:
        Fragment r17 = ((OfficeBaseFragment) this).f;
        if (r17 == null) goto L42;
        boolean r18 = true;
        if (r17.isAdded() != true) goto L42;
    L43:
        if (r18 == false) goto L52;
        String r19 = this.E;
        if (r19 == null) goto L48;
    L50:
        String r20 = this.F;
        this.E = null;
        this.F = null;
        fa0(r19, r20);
        return;
    L48:
        if (this.F != null) goto L50;
        return;
    L52:
        return;
    L42:
        r18 = false;
        goto L43
    }

    public final void ea0() {
        if (e2.a.isPad() == true) goto L5;
        return;
    L5:
        LarusLayoutSheetDetailFragmentBinding r0 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r0 == null) goto L12;
        if (r0 == null) goto L13;
        CotHeaderView r1 = r0.e;
        if (r1 == null) goto L14;
        r1.setPadding(i5.h() + f3$a.b(), r1.getPaddingTop(), (i5.h() + f3$a.b()) + i5.Y(), r1.getPaddingBottom());
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void foldStatusChanged() {
        Fragment r0 = ((OfficeBaseFragment) this).f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isAdded() == false) goto L62;
        g0 r1 = s1a.a.g(r0).getAbility(g0.class);
        boolean r2 = true;
        if (r1 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        Integer r5 = null;
        Drawable r6 = null;
        r6 = null;
        r5 = null;
        if (r3 == false) goto L40;
        g0 r4 = s1a.a.g(r0).getAbility(g0.class);
        if (r4 == null) goto L22;
        Context r7 = r0.getContext();
        if (r7 == null) goto L21;
        Resources r8 = r7.getResources();
        if (r8 == null) goto L21;
        r6 = r8.getDrawable(2131240729);
    L21:
        r4.gA(r6);
    L22:
        LarusLayoutSheetDetailFragmentBinding r9 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r9 == null) goto L27;
        View r10 = r9.b;
        if (r10 == null) goto L27;
        e1.x(r10);
    L27:
        ISheetSdkProxyService r11 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r11 == null) goto L30;
        r11.a();
    L30:
        FLogger.a.i("SheetFragment", "foldStatusChanged loadingText invisible");
        LarusLayoutSheetDetailFragmentBinding r12 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r12 == null) goto L37;
        CotHeaderView r13 = r12.e;
        if (r13 == null) goto L37;
        if (r13.getVisibility() != 0) goto L37;
    L38:
        if (r2 == false) goto L63;
        sa0(4, "foldStatusChangedExpand");
        return;
    L63:
        return;
    L37:
        r2 = false;
        goto L38
    L40:
        LarusLayoutSheetDetailFragmentBinding r14 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r14 == null) goto L45;
        View r15 = r14.b;
        if (r15 == null) goto L45;
        e1.o(r15);
    L45:
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("foldStatusChanged loadingText visibility=");
        LarusLayoutSheetDetailFragmentBinding r18 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r18 == null) goto L50;
        CotHeaderView r19 = r18.e;
        if (r19 == null) goto L50;
        r5 = Integer.valueOf(r19.getVisibility());
    L50:
        r17.append(r5);
        r16.i("SheetFragment", r17.toString());
        LarusLayoutSheetDetailFragmentBinding r20 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r20 == null) goto L57;
        CotHeaderView r21 = r20.e;
        if (r21 == null) goto L57;
        if (r21.getVisibility() != 4) goto L57;
    L58:
        if (r2 == false) goto L65;
        ma0();
        return;
    L65:
        return;
    L57:
        r2 = false;
        goto L58
    L9:
        if (r1.YC() != true) goto L11;
        r3 = true;
        goto L12
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.sheet.impl.SheetFragment$initTitleBarService$1] */
    public final void ga0() {
        this.o = new SheetFragment$initTitleBarService$1(this);
        ISheetSdkProxyService r0 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r0 == null) goto L5;
        r0.addTitleBarService(this.o);
    L5:
        this.n = new n(this);
        ISheetSdkProxyService r1 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r1 == null) goto L8;
        r1.f(this.n);
    L8:
        this.p = new p(this);
        ISheetSdkProxyService r2 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r2 == null) goto L11;
        r2.l(this.p);
    L11:
        FLogger r3 = FLogger.a;
        r3.d("SheetFragment", "initLoadingService");
        this.q = new o(this);
        r3.d("SheetFragment", "addLoadingService loadingService=" + this.q + " hashCode=" + hashCode());
        ISheetSdkProxyService r4 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r4 == null) goto L15;
        r4.addLoadingService(this.q);
        return;
    }

    public final int ha0() {
        LarusLayoutSheetDetailFragmentBinding r0 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        Integer r1 = null;
        if (r0 == null) goto L5;
        CotHeaderView r2 = r0.e;
    L6:
        boolean r3 = true;
        int r4 = 0;
        if (r2 != null) goto L9;
    L11:
        boolean r5 = false;
    L12:
        if (r5 == false) goto L23;
        Integer r6 = Integer.valueOf(r2.getHeight());
        if (r6.intValue() <= 0) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == true) goto L20;
        r6 = null;
    L20:
        if (r6 == null) goto L22;
        int r8 = r6.intValue();
    L24:
        LarusLayoutSheetDetailFragmentBinding r9 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r9 == null) goto L27;
        FrameLayout r10 = r9.f;
    L28:
        if (r10 != null) goto L30;
    L32:
        boolean r11 = false;
    L33:
        if (r11 == false) goto L43;
        if (r10 == null) goto L43;
        Integer r12 = Integer.valueOf(r10.getHeight());
        if (r12.intValue() > 0) goto L39;
        r3 = false;
    L39:
        if (r3 == false) goto L41;
        r1 = r12;
    L41:
        if (r1 == null) goto L43;
        int r13 = r1.intValue();
    L44:
        if (r11 == false) goto L49;
        if (r13 <= 0) goto L47;
        r4 = r13;
        goto L49
    L47:
        r4 = ia0();
    L49:
        return r8 + r4;
    L43:
        r13 = 0;
        goto L44
    L30:
        if (r10.getVisibility() != 0) goto L32;
        r11 = true;
        goto L33
    L27:
        r10 = null;
        goto L28
    L22:
        r8 = r2.getMeasuredHeight();
        goto L24
    L16:
        r7 = false;
        goto L17
    L23:
        r8 = 0;
        goto L24
    L9:
        if (r2.getVisibility() != 0) goto L11;
        r5 = true;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public final int ia0() {
        LarusLayoutSheetDetailFragmentBinding r0 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r0 == null) goto L7;
        FrameLayout r1 = r0.f;
        if (r1 == null) goto L7;
        View r2 = r1.findViewById(2131375324);
    L8:
        if (r2 == null) goto L10;
        int r3 = r2.getHeight();
    L11:
        if (r3 <= 0) goto L13;
        return r3;
    L13:
        return c7.b(110);
    L10:
        r3 = 0;
    L7:
        r2 = null;
        goto L8
    }

    public final int la0() {
        int r0 = com.larus.office.base.utils.o.a;
        Bundle r1 = getArguments();
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.getInt("resource_type", 12));
    L6:
        Integer r3 = com.larus.office.base.utils.o.b(r2, 12);
        if (r3 != null) goto L9;
        return 12;
    L9:
        return r3.intValue();
    L5:
        r2 = null;
        goto L6
    }

    public final void ma0() {
        ic8.t r0 = this.P;
        if (r0 == null) goto L8;
        Map r1 = r0.e;
        if (r1 == null) goto L8;
        String r2 = (String) r1.get("cot_ref_artifacts");
        if (r2 == null) goto L8;
    L10:
        if (this.z == true) goto L31;
        boolean r3 = true;
        if (r2.length() <= 0) goto L14;
        boolean r4 = true;
    L15:
        String r5 = null;
        if (r4 == true) goto L18;
    L24:
        Bundle r6 = getArguments();
        if (r6 == null) goto L28;
        r5 = r6.getString("drive_override_current_page");
    L28:
        if (Intrinsics.areEqual(r5, "ai_space_detail") == false) goto L32;
    L29:
        sa0(0, "interceptHeaderViewVisible");
        return;
    L32:
        return;
    L18:
        if (this.B.length() > 0) goto L21;
        r3 = false;
    L21:
        if (r3 == false) goto L24;
        if (StringsKt.contains$default(r2, this.B, false, 2, null) == true) goto L29;
    L14:
        r4 = false;
        goto L15
    L31:
        return;
    L8:
        r2 = "";
        goto L10
    }

    public final void onDestroy() {
        FLogger r0 = FLogger.a;
        r0.i("SheetFragment", "[onDestroy]");
        Fragment r2 = ((OfficeBaseFragment) this).f;
        if (r2 != null) goto L5;
    L9:
        l r3 = this.O;
        if (r3 == null) goto L13;
        AppHost.a.a().c(r3);
    L13:
        if (this.s == true) goto L15;
        int r4 = nw9.a.b;
        nw9.a.c("click_back", Long.valueOf(System.currentTimeMillis() - nw9.a.a), t9());
    L15:
        Fragment r5 = ((OfficeBaseFragment) this).f;
        if (r5 == null) goto L22;
        t1a.b r6 = s1a.a.g(r5);
        if (r6 == null) goto L22;
        mw9.a r7 = r6.o(Reflection.getOrCreateKotlinClass(mw9.a.class));
        if (r7 == null) goto L22;
        r7.iI(this);
    L22:
        Fragment r8 = ((OfficeBaseFragment) this).f;
        if (r8 == null) goto L29;
        t1a.b r9 = s1a.a.g(r8);
        if (r9 == null) goto L29;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r10 = r9.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r10 == null) goto L29;
        r10.B9(this.N);
    L29:
        com.larus.office.base.component.permission.a r11 = this.I;
        if (r11 == null) goto L32;
        r11.LR(this.K);
    L32:
        ISheetSdkProxyService r12 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r12 == null) goto L35;
        r12.e(this.n);
    L35:
        ISheetSdkProxyService r13 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r13 == null) goto L38;
        r13.j(this.o);
    L38:
        ISheetSdkProxyService r14 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r14 == null) goto L41;
        r14.g(this.p);
    L41:
        r0.d("SheetFragment", "removeLoadingService loadingService=" + this.q + " hashCode=" + hashCode());
        ISheetSdkProxyService r1 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r1 == null) goto L44;
        r1.h(this.q);
    L44:
        super.onDestroy();
        return;
    L5:
        if (r2.isAdded() == false) goto L9;
        g0 r15 = s1a.a.g(r2).getAbility(g0.class);
        if (r15 == null) goto L9;
        r15.Zh(this);
        goto L9
    }

    public final void onDestroyView() {
        LarusLayoutSheetDetailFragmentBinding r0 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r0 == null) goto L7;
        CotHeaderView r1 = r0.e;
        if (r1 == null) goto L7;
        r1.removeOnLayoutChangeListener(this.M);
    L7:
        LarusLayoutSheetDetailFragmentBinding r2 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r2 == null) goto L12;
        FrameLayout r3 = r2.f;
        if (r3 == null) goto L12;
        r3.removeOnLayoutChangeListener(this.M);
    L12:
        ISheetSdkProxyService r4 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r4 == null) goto L15;
        r4.a();
    L15:
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final void pa0() {
        if (TextUtils.isEmpty(this.B) == false) goto L9;
        Bundle r1 = getArguments();
        if (r1 == null) goto L8;
        String r2 = r1.getString("artifact_meta_id");
        if (r2 == null) goto L8;
    L10:
        Bundle r4 = getArguments();
        String r6 = null;
        if (r4 == null) goto L16;
        String r5 = r4.getString("previous_page");
        if (r5 != null) goto L15;
        String r20 = "";
    L17:
        Bundle r3 = getArguments();
        if (r3 == null) goto L20;
        r6 = r3.getString("previous_page");
    L20:
        String r7 = "ai_space_list";
        if (Intrinsics.areEqual(r6, "ai_space_list") == true) goto L24;
        r7 = this.r;
    L24:
        String r12 = r7;
        JSONObject r8 = new JSONObject();
        Bundle r9 = getArguments();
        if (r9 == null) goto L30;
        String r10 = r9.getString("resource_id");
        if (r10 == null) goto L29;
        r8.put("spreadsheet_id", r10);
        r8.put("resource_id", r10);
    L29:
        r8.put("resource_type", la0());
        r8.put("artifact_meta_id", r2);
        r8.put("artifact_type", 12);
    L30:
        a1.c(null, null, null, null, null, "aisheet_detail", null, null, r12, null, null, null, null, null, null, null, r20, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r8, null, null, null, null, null, null, null, null, -1049729, -8388609, 7);
        return;
    L15:
        r20 = r5;
        goto L17
    L16:
        r20 = null;
    L8:
        r2 = "";
        goto L10
    L9:
        r2 = this.B;
        goto L10
    }

    @Override // pw9.b
    public final JSONObject t9() {
        JSONObject r0 = new JSONObject();
        Object r1 = by7.h.a(this).getParams().get("previous_page");
        String r4 = null;
        if ((r1 instanceof String) == false) goto L5;
        String r2 = (String) r1;
    L6:
        r0.put("previous_page", r2);
        r0.put("current_page", "aisheet_detail");
        r0.put("canvas_type", "aisheet");
        r0.put("artifact_create_method", ka0());
        Bundle r3 = getArguments();
        if (r3 == null) goto L9;
        r4 = r3.getString("previous_page");
    L9:
        String r5 = "ai_space_list";
        if (Intrinsics.areEqual(r4, "ai_space_list") == true) goto L13;
        r5 = this.r;
    L13:
        if (r5 == null) goto L15;
        r0.put("enter_method", r5);
    L15:
        Bundle r6 = getArguments();
        if (r6 == null) goto L35;
        String r7 = r6.getString("resource_id");
        if (r7 == null) goto L20;
        r0.put("resource_id", r7);
        r0.put("spreadsheet_id", r7);
    L20:
        r0.put("resource_type", la0());
        String r8 = r6.getString("artifact_meta_id");
        if (r8 == null) goto L23;
        r0.put("artifact_meta_id", r8);
    L23:
        r0.put("artifact_type", 12);
        String r9 = r6.getString("message_id");
        if (r9 == null) goto L26;
        r0.put("message_id", r9);
    L26:
        String r10 = r6.getString("aippt_task_id");
        if (r10 == null) goto L29;
        r0.put("aippt_task_id", r10);
    L29:
        String r11 = r6.getString("conversation_id");
        if (r11 == null) goto L32;
        r0.put("conversation_id", r11);
    L32:
        String r12 = r6.getString("bot_id");
        if (r12 == null) goto L35;
        r0.put("bot_id", r12);
    L35:
        return r0;
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.sheet.impl.c] */
    public SheetFragment() {
        this.j = "";
        this.k = "";
        this.l = "";
        this.B = "";
        this.D = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.H = System.currentTimeMillis();
        this.K = new b(this);
        this.M = new com.larus.sheet.impl.c(this);
        this.N = new c(this);
    }

    public final Bundle X90() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        String r1 = r0.getString("previous_page");
        if (r1 == null) goto L6;
    L7:
        Bundle r2 = getArguments();
        String r3 = null;
        if (r2 == null) goto L10;
        String r4 = r2.getString("drive_override_current_page");
    L11:
        Pair[] r5 = new Pair[10];
        r5[0] = TuplesKt.to("sheets_token", this.j);
        r5[1] = TuplesKt.to("artifact_version_id", this.k);
        r5[2] = TuplesKt.to("conversation_id", this.l);
        r5[3] = TuplesKt.to("artifact_meta_id", this.B);
        r5[4] = TuplesKt.to("argPreviousPage", r1);
        r5[5] = TuplesKt.to("token", this.j);
        r5[6] = TuplesKt.to("drive_override_current_page", r4);
        Bundle r6 = getArguments();
        if (r6 == null) goto L14;
        String r7 = r6.getString("resource_id");
    L15:
        r5[7] = TuplesKt.to("resource_id", r7);
        Bundle r8 = getArguments();
        if (r8 == null) goto L18;
        Integer r9 = Integer.valueOf(r8.getInt("resource_type", 0));
    L19:
        r5[8] = TuplesKt.to("resource_type", r9);
        Bundle r10 = getArguments();
        if (r10 == null) goto L22;
        r3 = r10.getString("key_source_url_for_params");
    L22:
        r5[9] = TuplesKt.to("key_source_url_for_params", r3);
        return BundleKt.bundleOf(r5);
    L18:
        r9 = null;
        goto L19
    L14:
        r7 = null;
        goto L15
    L10:
        r4 = null;
    L6:
        r1 = "";
        goto L7
    }

    public final Context getHostContext() {
        return getContext();
    }

    public final String ja0() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        String r1 = r0.getString("sheets_token");
        if (r1 == null) goto L6;
    L8:
        return r1 + '_' + this.H;
    L6:
        r1 = "";
        goto L8
    }

    public final String ka0() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString("drive_override_current_page");
    L7:
        if (Intrinsics.areEqual(r1, "ai_space_detail") == true) goto L10;
        return "ai_space";
    L10:
        return null;
    L5:
        r1 = null;
        goto L7
    }

    public final boolean na0() {
        Bundle r0 = getArguments();
        int r1 = -1;
        if (r0 == null) goto L5;
        r1 = r0.getInt("resource_version", -1);
    L5:
        if (r1 < 0) goto L7;
        return true;
    L7:
        return false;
    }

    public final FragmentManager y1() {
        return getChildFragmentManager();
    }

    public final Fragment d5() {
        return this.L;
    }

    public final String getToken() {
        return this.j;
    }

    public final Fragment aa0(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        FLogger.a.i("SheetFragment", "Init SheetFragment");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SheetFragment$initChameleonFragment$1(r8, this, r0, null), 3, null);
        return (Fragment) r0.element;
    }

    @Override // pw9.e
    public final void d4(int r6) {
        if (r6 != TitleBarStates.VISIBLE.getStates()) goto L5;
        boolean r7 = true;
    L6:
        FLogger.a.i("SheetFragment", "toggleTitleBar: isVisible -> " + r7 + ", isLandscapeMode -> " + this.z);
        if (this.z == false) goto L11;
        vm9.d r0 = com.larus.office.base.service.m.b();
        if (r0 == null) goto L14;
        r0.setTitleBarVisible(r7, true);
    L14:
        if (r7 == false) goto L20;
        LarusLayoutSheetDetailFragmentBinding r8 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r8 == null) goto L26;
        FrameLayout r9 = r8.l;
        if (r9 == null) goto L27;
        e1.x(r9);
        return;
    L27:
        return;
    L26:
        return;
    L20:
        LarusLayoutSheetDetailFragmentBinding r10 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r10 == null) goto L29;
        FrameLayout r11 = r10.l;
        if (r11 == null) goto L30;
        e1.o(r11);
        return;
    L30:
        return;
    L29:
        return;
    L11:
        vm9.d r1 = com.larus.office.base.service.m.b();
        if (r1 == null) goto L14;
        r1.setTitleBarVisible(r7, false);
        goto L14
    L5:
        r7 = false;
        goto L6
    }

    public final void d7(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if (isAdded() == false) goto L6;
        r2.invoke();
        return;
    }

    public final void da0(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L74
        Bundle r1 = getArguments();     // Catch: Throwable -> L74
        String r2 = "";
        if (r1 == null) goto L8;
        String r3 = r1.getString("sheets_token");     // Catch: Throwable -> L74
        if (r3 == null) goto L8;
    L9:
        this.j = r3;     // Catch: Throwable -> L74
        Bundle r4 = getArguments();     // Catch: Throwable -> L74
        if (r4 == null) goto L13;
        String r6 = r4.getString("artifact_version_id");     // Catch: Throwable -> L74
        if (r6 == null) goto L13;
    L14:
        this.k = r6;     // Catch: Throwable -> L74
        Bundle r7 = getArguments();     // Catch: Throwable -> L74
        if (r7 == null) goto L17;
        r7.getInt("resource_version", -1);     // Catch: Throwable -> L74
    L17:
        Bundle r8 = getArguments();     // Catch: Throwable -> L74
        if (r8 == null) goto L23;
        String r9 = r8.getString("conversation_id");     // Catch: Throwable -> L74
        if (r9 == null) goto L23;
        r2 = r9;
    L23:
        this.l = r2;     // Catch: Throwable -> L74
        Bundle r10 = getArguments();     // Catch: Throwable -> L74
        ConstraintLayout.LayoutParams r11 = null;
        if (r10 == null) goto L26;
        String r12 = r10.getString("enter_method");     // Catch: Throwable -> L74
    L27:
        this.r = r12;     // Catch: Throwable -> L74
        int r13 = 0;
        if (this.j.length() != 0) goto L31;
        boolean r14 = true;
    L33:
        if (r14 == false) goto L36;
        FLogger.a.i("SheetFragment", "Invalid slides token");     // Catch: Throwable -> L74
        requireActivity().finish();     // Catch: Throwable -> L74
        return;
    L36:
        Fragment r15 = aa0(r5);     // Catch: Throwable -> L74
        if (r15 == null) goto L39;
        this.L = r15;     // Catch: Throwable -> L74
    L39:
        FLogger.a.i("SheetFragment", "onInitHostFragment setupServices");     // Catch: Throwable -> L74
        ga0();     // Catch: Throwable -> L74
        ViewBinding r16 = ((OfficeBaseFragment) this).e;     // Catch: Throwable -> L74
        LarusLayoutSheetDetailFragmentBinding r17 = (LarusLayoutSheetDetailFragmentBinding) r16;     // Catch: Throwable -> L74
        if (r17 == null) goto L59;
        FrameLayout r18 = r17.l;     // Catch: Throwable -> L74
        if (r18 == null) goto L59;
        LarusLayoutSheetDetailFragmentBinding r19 = (LarusLayoutSheetDetailFragmentBinding) r16;     // Catch: Throwable -> L74
        if (r19 == null) goto L48;
        FrameLayout r20 = r19.l;     // Catch: Throwable -> L74
        if (r20 == null) goto L48;
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();     // Catch: Throwable -> L74
    L50:
        if ((r21 instanceof ConstraintLayout.LayoutParams) == false) goto L52;
        ConstraintLayout.LayoutParams r22 = (ConstraintLayout.LayoutParams) r21;     // Catch: Throwable -> L74
    L53:
        if (r22 == null) goto L58;
        FragmentActivity r23 = getActivity();     // Catch: Throwable -> L74
        if (r23 == null) goto L57;
        r13 = com.larus.utils.u.c(r23);     // Catch: Throwable -> L74
    L57:
        ((ViewGroup.MarginLayoutParams) r22).topMargin = r13;     // Catch: Throwable -> L74
        r11 = r22;
    L58:
        r18.setLayoutParams(r11);     // Catch: Throwable -> L74
        goto L59
    L52:
        r22 = null;
    L48:
        r21 = null;
    L59:
        LarusLayoutSheetDetailFragmentBinding r24 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;     // Catch: Throwable -> L74
        if (r24 == null) goto L64;
        ImageView r25 = r24.k;     // Catch: Throwable -> L74
        if (r25 == null) goto L64;
        e1.d(r25, new e(this));     // Catch: Throwable -> L74
    L64:
        LarusLayoutSheetDetailFragmentBinding r26 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;     // Catch: Throwable -> L74
        if (r26 == null) goto L69;
        LinearLayout r27 = r26.i;     // Catch: Throwable -> L74
        if (r27 == null) goto L69;
        e1.d(r27, new f());     // Catch: Throwable -> L74
    L69:
        HashMap<String, MutableLiveData<Boolean>> r28 = com.larus.sheet.operation.f.a;     // Catch: Throwable -> L74
        com.larus.sheet.operation.f.d(this.j);     // Catch: Throwable -> L74
        if (TextUtils.isEmpty(this.l) == true) goto L72;
        pa0();     // Catch: Throwable -> L74
    L72:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L74
        return;
    L31:
        r14 = false;
        goto L33
    L26:
        r12 = null;
    L13:
        r6 = "";
    L8:
        r3 = "";
    L74:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void onConfigurationChanged(Configuration r8) {
        Intrinsics.checkNotNullParameter(r8, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r8);
        ea0();
        if (r8.orientation != 2) goto L5;
        boolean r9 = true;
    L6:
        this.z = r9;
        ISheetSdkProxyService r10 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r10 == null) goto L9;
        r10.a();
    L9:
        LarusLayoutSheetDetailFragmentBinding r11 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r11 == null) goto L14;
        ConstraintLayout r12 = r11.j;
        if (r12 == null) goto L14;
        com.larus.bmhome.view.screenmenu.d r0 = com.larus.bmhome.view.screenmenu.d.a;
        com.larus.bmhome.view.screenmenu.d.b(r12);
    L14:
        ConstraintLayout.LayoutParams r4 = null;
        if (this.z == true) goto L17;
    L61:
        LarusLayoutSheetDetailFragmentBinding r13 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r13 == null) goto L66;
        ConstraintLayout r14 = r13.j;
        if (r14 == null) goto L66;
        r14.setPadding(i5.r0(), 0, i5.r0(), 0);
    L66:
        LarusLayoutSheetDetailFragmentBinding r15 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r15 == null) goto L71;
        NovaTitleBarEx r16 = r15.m;
        if (r16 == null) goto L71;
        r16.setPadding(0, 0, 0, 0);
    L71:
        LarusLayoutSheetDetailFragmentBinding r17 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r17 == null) goto L81;
        NovaTitleBarEx r18 = r17.m;
        if (r18 == null) goto L81;
        if (r18.getVisibility() != 0) goto L78;
        boolean r19 = true;
    L79:
        if (r19 != true) goto L81;
        boolean r20 = true;
    L82:
        if (r20 == false) goto L84;
    L86:
        ra0(false, "setOrientationMode");
    L88:
        if (this.Q == false) goto L90;
        this.Q = false;
        ma0();
    L90:
        Fragment r21 = ((OfficeBaseFragment) this).f;
        if (r21 == null) goto L97;
        t1a.b r22 = s1a.a.g(r21);
        if (r22 == null) goto L97;
        va8.n r23 = r22.getAbility(va8.n.class);
        if (r23 == null) goto L97;
        r23.hideKeyboard();
    L97:
        LarusLayoutSheetDetailFragmentBinding r24 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r24 == null) goto L100;
        FrameLayout r25 = r24.c;
    L101:
        if (r25 == null) goto L103;
        ConstraintLayout.LayoutParams r1 = r25.getLayoutParams();
    L105:
        if ((r1 instanceof ConstraintLayout.LayoutParams) == false) goto L107;
        r4 = r1;
    L107:
        if (r4 == null) goto L109;
        r4.topToTop = -1;
        r4.topToBottom = 2131386202;
        r25.setLayoutParams(r4);
        r25.requestLayout();
    L109:
        vm9.d r26 = com.larus.office.base.service.m.b();
        if (r26 == null) goto L113;
        r26.changeNavigationNestedScrollState(false);
    L113:
        if (this.z == true) goto L115;
    L119:
        vm9.d r27 = com.larus.office.base.service.m.b();
        if (r27 == null) goto L122;
        r27.onCustomHeaderPaddingChanged(0, 0);
    L122:
        FLogger.a.i("SheetFragment", "onConfigurationChanged isLandscape=" + this.z);
        return;
    L115:
        if (this.A == true) goto L119;
        vm9.d r28 = com.larus.office.base.service.m.b();
        if (r28 == null) goto L122;
        r28.onCustomHeaderPaddingChanged(i5.d0(), i5.d0());
        goto L122
    L103:
        r1 = null;
        goto L105
    L100:
        r25 = null;
        goto L101
    L84:
        if (this.i == true) goto L86;
        ra0(true, "setOrientationMode");
        goto L88
    L78:
        r19 = false;
    L81:
        r20 = false;
        goto L82
    L17:
        if (this.A == true) goto L61;
        LarusLayoutSheetDetailFragmentBinding r29 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r29 == null) goto L24;
        ConstraintLayout r30 = r29.j;
        if (r30 == null) goto L24;
        r30.setPadding(i5.k0(), 0, i5.k0(), 0);
    L24:
        LarusLayoutSheetDetailFragmentBinding r31 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r31 == null) goto L29;
        NovaTitleBarEx r32 = r31.m;
        if (r32 == null) goto L29;
        r32.setPadding(i5.g0(), 0, i5.g0(), 0);
    L29:
        ra0(false, "setOrientationMode");
        LarusLayoutSheetDetailFragmentBinding r33 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r33 == null) goto L39;
        CotHeaderView r34 = r33.e;
        if (r34 == null) goto L39;
        if (r34.getVisibility() != 0) goto L36;
        boolean r35 = true;
    L37:
        if (r35 != true) goto L39;
        boolean r36 = true;
    L40:
        if (r36 == false) goto L42;
        this.Q = true;
        sa0(8, "setOrientationMode");
    L42:
        Fragment r37 = ((OfficeBaseFragment) this).f;
        if (r37 == null) goto L49;
        t1a.b r38 = s1a.a.g(r37);
        if (r38 == null) goto L49;
        va8.n r39 = r38.getAbility(va8.n.class);
        if (r39 == null) goto L49;
        r39.hideKeyboard();
    L49:
        LarusLayoutSheetDetailFragmentBinding r40 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r40 == null) goto L52;
        FrameLayout r41 = r40.c;
    L53:
        if (r41 == null) goto L55;
        ViewGroup.LayoutParams r2 = r41.getLayoutParams();
    L57:
        if ((r2 instanceof ConstraintLayout.LayoutParams) == false) goto L59;
        r4 = (ConstraintLayout.LayoutParams) r2;
    L59:
        if (r4 == null) goto L109;
        r4.topToBottom = -1;
        r4.topToTop = 0;
        r41.setLayoutParams(r4);
        r41.requestLayout();
        goto L109
    L55:
        r2 = null;
        goto L57
    L52:
        r41 = null;
        goto L53
    L36:
        r35 = false;
    L39:
        r36 = false;
        goto L40
    L5:
        r9 = false;
        goto L6
    }

    @Override // mw9.b
    public final void onCotInfoUpdate(ic8.t r12) {
        Intrinsics.checkNotNullParameter(r12, "cotInfo");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = r12;
        this.P = r12;
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("onCotInfoUpdate cotInfo: title=");
        ic8.t r3 = this.P;
        if (r3 == null) goto L5;
        String r4 = r3.b;
    L6:
        r2.append(r4);
        r2.append(" headerStatus=");
        ic8.t r5 = this.P;
        if (r5 == null) goto L9;
        Integer r6 = Integer.valueOf(r5.f);
    L10:
        r2.append(r6);
        r2.append(" curCotRefArtifacts=");
        ic8.t r7 = this.P;
        if (r7 == null) goto L16;
        Map r8 = r7.e;
        if (r8 == null) goto L16;
        String r9 = (String) r8.get("cot_ref_artifacts");
        if (r9 == null) goto L16;
    L17:
        r2.append(r9);
        r1.d("SheetFragment", r2.toString());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new AnonymousClass1(r12, this, r0, null), 2, null);
        return;
    L16:
        r9 = "";
        goto L17
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final void onCreate(Bundle r3) {
        super/*com.larus.trace.tracknode.TraceFragment*/.onCreate(r3);
        int r4 = nw9.a.b;
        nw9.a.a = System.currentTimeMillis();
        l r5 = new l(this);
        AppHost.a.a().j(r5);
        this.O = r5;
        if (getResources().getConfiguration().orientation != 2) goto L5;
        boolean r6 = true;
    L6:
        this.z = r6;
        this.A = ku5.c.k(getContext());
        FLogger.a.i("SheetFragment", "onCreate isPad=" + this.A + ", isLandscapeMode=" + this.z);
        return;
    L5:
        r6 = false;
        goto L6
    }

    public final void qa0(boolean r5) {
        int r0 = 0;
        ConstraintLayout.LayoutParams r1 = null;
        if (r5 == false) goto L21;
        ViewBinding r6 = ((OfficeBaseFragment) this).e;
        LarusLayoutSheetDetailFragmentBinding r2 = (LarusLayoutSheetDetailFragmentBinding) r6;
        if (r2 == null) goto L42;
        FrameLayout r3 = r2.l;
        if (r3 == null) goto L43;
        LarusLayoutSheetDetailFragmentBinding r7 = (LarusLayoutSheetDetailFragmentBinding) r6;
        if (r7 == null) goto L13;
        FrameLayout r8 = r7.l;
        if (r8 == null) goto L13;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
    L15:
        if ((r9 instanceof ConstraintLayout.LayoutParams) == false) goto L17;
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) r9;
    L18:
        if (r10 == null) goto L20;
        ((ViewGroup.MarginLayoutParams) r10).topMargin = 0;
        r1 = r10;
    L20:
        r3.setLayoutParams(r1);
        return;
    L17:
        r10 = null;
    L13:
        r9 = null;
        goto L15
    L43:
        return;
    L42:
        return;
    L21:
        ViewBinding r11 = ((OfficeBaseFragment) this).e;
        LarusLayoutSheetDetailFragmentBinding r4 = (LarusLayoutSheetDetailFragmentBinding) r11;
        if (r4 == null) goto L45;
        FrameLayout r12 = r4.l;
        if (r12 == null) goto L46;
        LarusLayoutSheetDetailFragmentBinding r13 = (LarusLayoutSheetDetailFragmentBinding) r11;
        if (r13 == null) goto L30;
        FrameLayout r14 = r13.l;
        if (r14 == null) goto L30;
        ConstraintLayout.LayoutParams r15 = r14.getLayoutParams();
    L32:
        if ((r15 instanceof ConstraintLayout.LayoutParams) == false) goto L34;
        ConstraintLayout.LayoutParams r16 = r15;
    L35:
        if (r16 == null) goto L40;
        FragmentActivity r17 = getActivity();
        if (r17 == null) goto L39;
        r0 = com.larus.utils.u.c(r17);
    L39:
        ((ViewGroup.MarginLayoutParams) r16).topMargin = r0;
        r1 = r16;
    L40:
        r12.setLayoutParams(r1);
        return;
    L34:
        r16 = null;
    L30:
        r15 = null;
        goto L32
    L46:
        return;
    }

    public final void x5(Fragment r1) {
        this.L = r1;
    }

    public static void oa0(SheetFragment r3, String r4) {
        int r5 = r3.ha0();
        ISheetSdkProxyService r0 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r0 == null) goto L5;
        r0.i(r5);
    L5:
        FLogger.a.d("SheetFragment", "notifyChatInputAndCotHeightChanged from:" + r4 + " height:" + r5);
    }

    public final void D8(String r3, String r4) {
        Fragment r0 = ((OfficeBaseFragment) this).f;
        if (r0 == null) goto L10;
        t1a.b r1 = s1a.a.g(r0);
        if (r1 == null) goto L11;
        n0 r2 = r1.getAbility(n0.class);
        if (r2 == null) goto L12;
        r2.D8(r3, r4);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final Object V3(Context r7, Continuation<? super Fragment> r8) {
        ISheetSdkServiceV2 r0 = (ISheetSdkServiceV2) ServiceManager.get().getService(ISheetSdkServiceV2.class);
        String r9 = null;
        if (r0 == null) goto L74;
        OfficeInputParam r1 = new OfficeInputParam();
        Bundle r2 = getArguments();
        String r3 = "";
        if (r2 == null) goto L8;
        String r4 = r2.getString("resource_id");
        if (r4 == null) goto L8;
    L9:
        r1.setResourceId(r4);
        Bundle r5 = getArguments();
        if (r5 == null) goto L13;
        String r6 = r5.getString("sheets_token");
        if (r6 == null) goto L13;
    L14:
        r1.setSlidesToken(r6);
        r1.setDocLogicKey(ja0());
        r1.setResourceType(12);
        Bundle r10 = getArguments();
        int r11 = -1;
        if (r10 == null) goto L17;
        r11 = r10.getInt("resource_version", -1);
    L17:
        r1.setResourceVersion(r11);
        Bundle r12 = getArguments();
        if (r12 == null) goto L21;
        String r13 = r12.getString("conversation_id");
        if (r13 == null) goto L21;
    L22:
        r1.setConversationId(r13);
        Bundle r14 = getArguments();
        if (r14 == null) goto L26;
        String r15 = r14.getString("artifact_meta_id");
        if (r15 == null) goto L26;
    L27:
        r1.setArtifactMetaId(r15);
        Bundle r16 = getArguments();
        if (r16 == null) goto L31;
        String r17 = r16.getString("enter_method");
        if (r17 == null) goto L31;
    L32:
        r1.setEnterMethod(r17);
        Bundle r18 = getArguments();
        if (r18 == null) goto L35;
        String r19 = r18.getString("doc_title");
    L36:
        r1.setDocTitle(r19);
        Bundle r20 = getArguments();
        if (r20 == null) goto L39;
        long r21 = r20.getLong("click_timestamp");
    L40:
        r1.setClickTimestamp(r21);
        r1.setBeginLoadTimestamp(System.currentTimeMillis());
        Bundle r22 = getArguments();
        boolean r23 = false;
        if (r22 == null) goto L43;
        boolean r24 = r22.getBoolean("has_report_finish_event");
    L44:
        r1.setHasReportFinishEvent(r24);
        Bundle r25 = getArguments();
        if (r25 == null) goto L48;
        String r26 = r25.getString("enter_from", "");
        if (r26 == null) goto L48;
    L49:
        r1.setEnterFrom(r26);
        Bundle r27 = getArguments();
        if (r27 == null) goto L55;
        String r28 = r27.getString("sheet");
        if (r28 == null) goto L55;
        r3 = r28;
    L55:
        r1.setSheet(r3);
        r1.setObjType(Boxing.boxInt(3));
        Bundle r29 = getArguments();
        if (r29 != null) goto L58;
    L60:
        boolean r30 = false;
    L61:
        r1.setDocPreloaded(r30);
        Bundle r31 = getArguments();
        if (r31 == null) goto L64;
        r9 = r31.getString("key_source_url_for_params");
    L64:
        r1.setSourceUrlForParams(r9);
        Bundle r32 = getArguments();
        if (r32 != null) goto L67;
    L69:
        r1.setOpenChatWithNewLocalConv(r23);
        Unit r33 = Unit.INSTANCE;
        Object r34 = r0.T(r1, this.I, null, null, r8);
        if (r34 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L73;
        return r34;
    L73:
        return (Fragment) r34;
    L67:
        if (r32.getBoolean("open_chat_with_new_local_conv", false) != true) goto L69;
        r23 = true;
        goto L69
    L58:
        if (r29.getBoolean("key_office_preloaded", false) != true) goto L60;
        r30 = true;
    L48:
        r26 = "";
        goto L49
    L43:
        r24 = false;
        goto L44
    L39:
        r21 = System.currentTimeMillis();
        goto L40
    L35:
        r19 = null;
    L31:
        r17 = "";
    L26:
        r15 = "";
    L21:
        r13 = "";
    L13:
        r6 = "";
    L8:
        r4 = "";
        goto L9
    L74:
        return null;
    }

    public final ViewBinding Z90(LayoutInflater r23, ViewGroup r24) {
        Intrinsics.checkNotNullParameter(r23, "inflater");
        ConstraintLayout r0 = r23.inflate(2131562887, r24, false);
        int r1 = 2131365538;
        View r4 = ViewBindings.findChildViewById(r0, 2131365538);
        if (r4 == null) goto L43;
        r1 = 2131369315;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131369315);
        if (r5 == null) goto L43;
        r1 = 2131373339;
        View r6 = ViewBindings.findChildViewById(r0, 2131373339);
        if (r6 == null) goto L43;
        r1 = 2131374318;
        CotHeaderView r7 = ViewBindings.findChildViewById(r0, 2131374318);
        if (r7 == null) goto L43;
        r1 = 2131386154;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131386154);
        if (r8 == null) goto L43;
        r1 = 2131386183;
        SheetLoadLayout r9 = (SheetLoadLayout) ViewBindings.findChildViewById(r0, 2131386183);
        if (r9 == null) goto L43;
        r1 = 2131386184;
        FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131386184);
        if (r10 == null) goto L43;
        r1 = 2131386198;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131386198);
        if (r11 == null) goto L43;
        r1 = 2131386199;
        ConstraintLayout r12 = ViewBindings.findChildViewById(r0, 2131386199);
        if (r12 == null) goto L43;
        r1 = 2131386200;
        ImageView r13 = (ImageView) ViewBindings.findChildViewById(r0, 2131386200);
        if (r13 == null) goto L43;
        r1 = 2131386201;
        if (((ImageView) ViewBindings.findChildViewById(r0, 2131386201)) == null) goto L43;
        r1 = 2131386202;
        FrameLayout r14 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131386202);
        if (r14 == null) goto L43;
        r1 = 2131386203;
        NovaTitleBarEx r15 = ViewBindings.findChildViewById(r0, 2131386203);
        if (r15 == null) goto L43;
        r1 = 2131386204;
        ImageView r16 = (ImageView) ViewBindings.findChildViewById(r0, 2131386204);
        if (r16 == null) goto L43;
        r1 = 2131386205;
        ImageView r17 = (ImageView) ViewBindings.findChildViewById(r0, 2131386205);
        if (r17 == null) goto L43;
        r1 = 2131386206;
        ImageView r18 = (ImageView) ViewBindings.findChildViewById(r0, 2131386206);
        if (r18 == null) goto L43;
        r1 = 2131386207;
        TextView r19 = (TextView) ViewBindings.findChildViewById(r0, 2131386207);
        if (r19 == null) goto L43;
        r1 = 2131386208;
        TextView r20 = (TextView) ViewBindings.findChildViewById(r0, 2131386208);
        if (r20 == null) goto L43;
        r1 = 2131386209;
        ImageView r21 = (ImageView) ViewBindings.findChildViewById(r0, 2131386209);
        if (r21 == null) goto L43;
        return new LarusLayoutSheetDetailFragmentBinding(r0, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public final void fa0(String r3, String r4) {
        if (o0.d(r3) == false) goto L32;
        if (r4 != null) goto L44;
        r4 = "";
    L44:
    L30:
        e = move-exception;
        FLogger.a.e("SheetFragment", "Parse selection data error: " + e.getMessage());
        Unit r5 = Unit.INSTANCE;
    L39:
        Lazy r6 = com.larus.office.base.service.m.a;
        ym9.c r7 = com.larus.office.base.service.m.a(ja0());
        if (r7 == null) goto L42;
        r7.onEditPanelHeightChanged(200);
    L42:
        oa0(this, "applySelectionChange");
        return;
    L7:
        if (o0.d(r4) == false) goto L15;
        Fragment r0 = ((OfficeBaseFragment) this).f;     // Catch: Exception -> L30
        if (r0 == null) goto L22;
        t1a.b r1 = s1a.a.g(r0);     // Catch: Exception -> L30
        if (r1 == null) goto L22;
        com.larus.bmhome.chat.component.bottom.reference.a r2 = r1.getAbility(com.larus.bmhome.chat.component.bottom.reference.a.class);     // Catch: Exception -> L30
        if (r2 == null) goto L22;
        r2.Dk(r4);     // Catch: Exception -> L30
    L22:
        Fragment r8 = ((OfficeBaseFragment) this).f;     // Catch: Exception -> L30
        if (r8 == null) goto L39;
        t1a.b r9 = s1a.a.g(r8);     // Catch: Exception -> L30
        if (r9 == null) goto L39;
        n0 r10 = r9.getAbility(n0.class);     // Catch: Exception -> L30
        if (r10 == null) goto L39;
        r10.a6(r3);     // Catch: Exception -> L30
        Unit r11 = Unit.INSTANCE;     // Catch: Exception -> L30
        goto L39
    L15:
        Fragment r12 = ((OfficeBaseFragment) this).f;     // Catch: Exception -> L30
        if (r12 == null) goto L22;
        t1a.b r13 = s1a.a.g(r12);     // Catch: Exception -> L30
        if (r13 == null) goto L22;
        com.larus.bmhome.chat.component.bottom.reference.a r14 = r13.getAbility(com.larus.bmhome.chat.component.bottom.reference.a.class);     // Catch: Exception -> L30
        if (r14 == null) goto L22;
        r14.NR();     // Catch: Exception -> L30
        goto L22
    L32:
        Fragment r15 = ((OfficeBaseFragment) this).f;
        if (r15 == null) goto L39;
        t1a.b r16 = s1a.a.g(r15);
        if (r16 == null) goto L39;
        com.larus.bmhome.chat.component.bottom.reference.a r17 = r16.getAbility(com.larus.bmhome.chat.component.bottom.reference.a.class);
        if (r17 == null) goto L39;
        r17.NR();
        goto L39
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        Bundle r4 = getArguments();
        String r5 = "";
        if (r4 == null) goto L5;
        r4.getString("cot_ref_artifacts", "");
    L5:
        Bundle r6 = getArguments();
        if (r6 == null) goto L11;
        String r7 = r6.getString("artifact_meta_id", "");
        if (r7 == null) goto L11;
        r5 = r7;
    L11:
        this.B = r5;
        LarusLayoutSheetDetailFragmentBinding r8 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r8 == null) goto L16;
        CotHeaderView r9 = r8.e;
        if (r9 == null) goto L16;
        e1.d(r9, new d(this));
    L16:
        ea0();
        LarusLayoutSheetDetailFragmentBinding r10 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r10 == null) goto L21;
        CotHeaderView r11 = r10.e;
        if (r11 == null) goto L21;
        r11.addOnLayoutChangeListener(this.M);
    L21:
        LarusLayoutSheetDetailFragmentBinding r12 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r12 == null) goto L26;
        FrameLayout r13 = r12.f;
        if (r13 == null) goto L26;
        r13.addOnLayoutChangeListener(this.M);
    L26:
        LarusLayoutSheetDetailFragmentBinding r14 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        ConstraintLayout.LayoutParams r15 = null;
        if (r14 == null) goto L31;
        FrameLayout r16 = r14.l;
        if (r16 == null) goto L31;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
    L33:
        if ((r17 instanceof ConstraintLayout.LayoutParams) == false) goto L35;
        r15 = (ConstraintLayout.LayoutParams) r17;
    L35:
        if (r15 == null) goto L37;
        ((ViewGroup.MarginLayoutParams) r15).height = 0;
    L37:
        if (r15 == null) goto L39;
        r15.matchConstraintDefaultHeight = 2;
    L39:
        if (r15 == null) goto L41;
        r15.matchConstraintPercentHeight = 0.0f;
    L41:
        LarusLayoutSheetDetailFragmentBinding r18 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r18 == null) goto L46;
        FrameLayout r19 = r18.l;
        if (r19 == null) goto L46;
        r19.setLayoutParams(r15);
    L46:
        LarusLayoutSheetDetailFragmentBinding r20 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r20 == null) goto L52;
        FrameLayout r21 = r20.l;
        if (r21 == null) goto L53;
        r21.requestLayout();
        return;
    L53:
        return;
    L52:
        return;
    L31:
        r17 = null;
        goto L33
    }

    public final void ra0(boolean r7, String r8) {
        boolean r1 = false;
        boolean r2 = true;
        if (this.A == false) goto L8;
        if (r7 == true) goto L6;
    L14:
        boolean r0 = false;
    L15:
        LarusLayoutSheetDetailFragmentBinding r3 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r3 == null) goto L25;
        FrameLayout r4 = r3.f;
        if (r4 == null) goto L25;
        if (r4.getVisibility() != 0) goto L22;
        boolean r5 = true;
    L23:
        if (r5 != true) goto L25;
        r1 = true;
        goto L25
    L22:
        r5 = false;
    L25:
        if (r0 == false) goto L31;
        LarusLayoutSheetDetailFragmentBinding r6 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r6 == null) goto L37;
        FrameLayout r9 = r6.f;
        if (r9 == null) goto L37;
        e1.x(r9);
    L37:
        if (r1 == r0) goto L45;
        Lazy r10 = com.larus.office.base.service.m.a;
        ym9.c r11 = com.larus.office.base.service.m.a(ja0());
        if (r11 == null) goto L41;
        r11.onEditPanelActive(r0);
    L41:
        ym9.c r12 = com.larus.office.base.service.m.a(ja0());
        if (r12 == null) goto L44;
        r12.onEditPanelHeightChanged(200);
    L44:
        oa0(this, "updateEditPanelHeight");
        FLogger.a.i("SheetFragment", "updateEditPanelHeight, isActive:" + r0);
    L45:
        FLogger r13 = FLogger.a;
        StringBuilder r14 = new StringBuilder("updateChatInputVisibility, isPad:");
        r14.append(this.A);
        r14.append(", isLandscapeMode:");
        r14.append(this.z);
        r14.append(", isVisible:");
        r14.append(r7);
        r14.append(", from:");
        r14.append(r8);
        r14.append(", isOwner:");
        Bundle r15 = getArguments();
        if (r15 != null) goto L49;
    L51:
        r14.append(r2);
        r14.append(", isHistoryVersion:");
        r14.append(na0());
        r13.d("SheetFragment", r14.toString());
        return;
    L49:
        if (r15.containsKey("is_sheet_owner") == false) goto L51;
        r2 = r15.getBoolean("is_sheet_owner");
        goto L51
    L31:
        LarusLayoutSheetDetailFragmentBinding r16 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r16 == null) goto L37;
        FrameLayout r17 = r16.f;
        if (r17 == null) goto L37;
        e1.o(r17);
        goto L37
    L6:
        if (na0() == true) goto L14;
    L13:
        r0 = true;
        goto L15
    L8:
        if (r7 == false) goto L14;
        if (na0() == true) goto L14;
        if (this.z == true) goto L14;
        goto L13
    }

    public final void sa0(int r3, String r4) {
        LarusLayoutSheetDetailFragmentBinding r0 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) this).e;
        if (r0 == null) goto L21;
        CotHeaderView r1 = r0.e;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.getVisibility() != r3) goto L10;
        return;
    L10:
        if (r3 != 0) goto L12;
        e1.x(r1);
    L19:
        oa0(this, "headerView:".concat(r4));
        return;
    L12:
        if (r3 != 4) goto L14;
        e1.q(r1);
        goto L19
    L14:
        if (r3 == 8) goto L16;
        r1.setVisibility(r3);
        goto L19
    L16:
        e1.o(r1);
        goto L19
    }

    public final void F8(String r10, String r11, String r12, String r13) {
        String r0 = "";
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        this.k = r11;
        if (r10 != null) goto L8;
        String r14 = "";
    L9:
        this.B = r14;
        if (r12 == null) goto L13;
        r0 = r12;
    L13:
        this.l = r0;
        this.D.complete(r13);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new SheetFragment$updateArtifactInfo$1(this, r12, r10, r13, null), 2, null);
        pa0();
        return;
    L8:
        r14 = r10;
        goto L9
    }
}
