package com.obric.assistant.tipoff;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.ReportReason;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.tipoff.TipOffDialogParams;
import com.larus.bmhome.utils.x1;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.MaxHeightScrollView;
import com.larus.common_ui.widget.NestedScrollEditText;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.feedback.IObricFeedbackService;
import com.obric.assistant.impl.databinding.ObricDialogfragTipOffBinding;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.base.model.AssistantActivityExpandState;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.spi.feedback.FeedbackServiceDelegate;
import com.obric.assistant.spi.feedback.ObricFeedbackPanelServiceDelegate;
import com.obric.assistant.t1;
import com.obric.assistant.view.ObricFlowTagLayout;
import com.obric.oui.checkbox.OCheckBoxLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import v19.o5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0084\u00012\u00020\u00012\u00020\u0002:\u0004\u0084\u0001\u0085\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010C\u001a\u00020D2\u0006\u0010)\u001a\u00020*H\u0016J\u0012\u0010E\u001a\u00020D2\b\u0010F\u001a\u0004\u0018\u000102H\u0016J\b\u0010G\u001a\u00020DH\u0016J\b\u0010H\u001a\u00020DH\u0016J\b\u0010I\u001a\u00020DH\u0016J$\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010O2\b\u0010F\u001a\u0004\u0018\u000102H\u0016J\u001a\u0010P\u001a\u00020D2\u0006\u0010Q\u001a\u00020K2\b\u0010F\u001a\u0004\u0018\u000102H\u0016J\u0010\u0010R\u001a\u00020D2\u0006\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u00020DH\u0002J\b\u0010V\u001a\u00020DH\u0002J\u0012\u0010W\u001a\u00020D2\b\b\u0002\u0010X\u001a\u000200H\u0002J\b\u0010Y\u001a\u00020DH\u0002J\u001a\u0010Z\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\u00150[0$H\u0002J\b\u0010]\u001a\u00020DH\u0002J \u0010^\u001a\u00020\u00152\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00152\u0006\u0010b\u001a\u00020\u0015H\u0002J\b\u0010c\u001a\u000200H\u0002J\b\u0010d\u001a\u00020BH\u0002J\b\u0010e\u001a\u000200H\u0002J\b\u0010f\u001a\u00020DH\u0002J\b\u0010g\u001a\u00020DH\u0002J\b\u0010h\u001a\u00020DH\u0002J\u0018\u0010i\u001a\u00020D2\u0006\u0010j\u001a\u00020\u00062\u0006\u0010k\u001a\u000200H\u0002J\b\u0010l\u001a\u00020DH\u0002J\b\u0010m\u001a\u00020DH\u0002J\n\u0010n\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010o\u001a\u00020pH\u0002J\b\u0010q\u001a\u00020\u0006H\u0002J\b\u0010r\u001a\u00020DH\u0002J\u001a\u0010s\u001a\u00020D2\u0006\u0010t\u001a\u0002002\b\b\u0002\u0010u\u001a\u000200H\u0002J\b\u0010v\u001a\u00020DH\u0002J\b\u0010w\u001a\u00020DH\u0002J\b\u0010x\u001a\u00020DH\u0002J\u0010\u0010y\u001a\u00020D2\u0006\u0010z\u001a\u00020{H\u0016J2\u0010|\u001a\u00020D2\u0006\u0010}\u001a\u0002002\u0006\u0010~\u001a\u0002002\u000b\b\u0002\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\u000b\b\u0002\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u0082\u0001\u001a\u0002002\u0006\u0010t\u001a\u000200H\u0082@¢\u0006\u0003\u0010\u0083\u0001R\u0014\u0010\u0005\u001a\u00020\u0006X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00103\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010<\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010=R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0086\u0001"}, d2 = {"Lcom/obric/assistant/tipoff/ObricTipOffDialogFragment;", "Lcom/obric/assistant/tipoff/BaseObricTipOffDialogFragment;", "Lcom/ixigua/lib/track/ITrackNode;", "<init>", "()V", "logTag", "", "getLogTag", "()Ljava/lang/String;", "binding", "Lcom/obric/assistant/impl/databinding/ObricDialogfragTipOffBinding;", "model", "Lcom/obric/assistant/tipoff/ObricTipOffDialogViewModel;", "getModel", "()Lcom/obric/assistant/tipoff/ObricTipOffDialogViewModel;", "model$delegate", "Lkotlin/Lazy;", "launchInfo", "Landroidx/lifecycle/LiveData;", "Lcom/larus/bmhome/chat/api/LaunchInfoWithStatus;", "reportType", "", "entityId", "botId", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "searchMobParam", "Lcom/larus/platform/model/SearchMobParam;", "previousPage", "conversationId", "serverIndex", "reportSource", "isImmersiveBackground", "commonMobParam", "successReportToastString", "overrideReportReason", "", "Lcom/larus/bmhome/auth/ReportReason;", "batchIds", "extraParams", "", "callback", "Lcom/larus/bmhome/tipoff/ITipOffDialogCallback;", "dialogTitle", "dialogSubtitle", "inputHint", "commitBtnText", "isFromDislike", "", "dislikeExtraBundle", "Landroid/os/Bundle;", "guiLogList", "omniTaskId", "feedbackMsgId", "feedbackSource", "feedbackBizType", "searchTool", "feedbackTrackBotId", "feedbackTrackConversationId", "feedbackTrackMessageId", "feedbackScore", "Ljava/lang/Integer;", "experiencePlanProvider", "Lcom/obric/assistant/spi/feedback/IObricExperiencePlanFeedbackProvider;", "experiencePlanSubmitHandled", "guiLogPathSplitResult", "Lcom/obric/assistant/util/AttachmentPathUtils$PathSplitResult;", "setCallback", "", "onCreate", "savedInstanceState", "onDestroy", "onStart", "onStop", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onCancel", "dialog", "Landroid/content/DialogInterface;", "initReasonList", "setupViewModel", "updateSubmitButtonState", "enabled", "initFeedbackScoreView", "feedbackScoreViews", "Lkotlin/Pair;", "Lcom/larus/common_ui/widget/roundlayout/RoundTextView;", "updateFeedbackScoreView", "resolveCommonColor", "context", "Landroid/content/Context;", "attrRes", "colorRes", "hasGuiImagePaths", "getGuiLogPathSplitResult", "isAutoDrainInternalEnabled", "checkSubmit", "checkSearchFeedbackSubmit", "reportConsentPopupShow", "reportConsentPopupClick", "clickAction", "isConsentChecked", "reportFeedbackPopupCancel", "reportFeedbackPopupSubmit", "getFeedbackLabel", "getFeedbackEventContext", "Lcom/obric/assistant/feedback/ObricFeedbackTrackHelper$FeedbackEventContext;", "getObricWindowMode", "initView", "doSubmit", "withGuiImage", "reportFeedbackSubmitClick", "submit", "submitDislike", "notifyExperiencePlanSubmit", "fillTrackParams", "params", "Lcom/ixigua/lib/track/TrackParams;", "setDislikeResult", "manualDismiss", "isSubmit", "selectedTag", "Lcom/obric/assistant/view/ObricFlowTagLayout$TagBean;", "inputContent", "reportToObric", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Builder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTipOffDialogFragment extends BaseObricTipOffDialogFragment implements by7.e {
    public static final /* synthetic */ int Q = 0;
    public String A;
    public boolean B;
    public Bundle C;
    public List<String> D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;
    public String L;
    public Integer M;
    public nga.a N;
    public boolean O;
    public com.obric.assistant.util.a.b P;
    public final String e;
    public ObricDialogfragTipOffBinding f;
    public final Lazy g;
    public final LiveData<e0> h;
    public int i;
    public String j;
    public String k;
    public RecommendFrom l;
    public SearchMobParam m;
    public String n;
    public String o;
    public int p;
    public String q;
    public String r;
    public String s;
    public List<ReportReason> t;
    public List<String> u;
    public Map<String, String> v;
    public com.larus.bmhome.tipoff.a w;
    public String x;
    public String y;
    public String z;

    public static final class a {
        public TipOffDialogParams a;
        public ObricTipOffDialogExtraParams b;

        public a() {
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AssistantActivityExpandState.values().length];
            r0[AssistantActivityExpandState.FULL_SCREEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[AssistantActivityExpandState.HALF_WINDOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[AssistantActivityExpandState.CHAT_WINDOW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[AssistantActivityExpandState.INVISIBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class d implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public d(g r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public static boolean ia0() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        JsonObject r2 = t1.a.getObricCloudConfig("obric_omni_upload_image_auto_drain_toggle_map");     // Catch: Throwable -> L11
        if (r2 == null) goto L8;
        JsonElement r3 = r2.get("enable");     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        boolean r4 = r3.getAsBoolean();     // Catch: Throwable -> L11
    L9:
        Object r5 = Result.constructor-impl(Boolean.valueOf(r4));     // Catch: Throwable -> L11
    L13:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L16;
        FLogger.a.e("ObricTipOffDialogFragment", "isAutoDrainInternalEnabled parse failed", r6);
    L16:
        Boolean r7 = Boolean.FALSE;
        if (Result.isFailure-impl(r5) == false) goto L20;
        r5 = r7;
    L20:
        if (((Boolean) r5).booleanValue() == false) goto L22;
    L23:
        return true;
    L22:
        if (AppHost.a.isDebug() == true) goto L23;
        return false;
    L8:
        r4 = false;
    L11:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public final void onDestroy() {
        this.N = null;
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        FLogger.a.i("ObricTipOffDialogFragment", "onDestroy");
    }

    public final List<Pair<RoundTextView, Integer>> ca0() {
        ObricDialogfragTipOffBinding r0 = this.f;
        if (r0 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return CollectionsKt.listOf(new Pair[]{TuplesKt.to(r0.j, 1), TuplesKt.to(r0.k, 2), TuplesKt.to(r0.l, 3), TuplesKt.to(r0.m, 4), TuplesKt.to(r0.n, 5)});
    }

    public final com.obric.assistant.feedback.d.a da0() {
        String r0 = this.J;
        boolean r2 = true;
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        r0 = this.k;
    L8:
        String r3 = this.K;
        if (r3.length() != 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
        r3 = this.n;
    L14:
        String r5 = this.L;
        if (r5.length() == 0) goto L18;
        r2 = false;
    L18:
        if (r2 == false) goto L24;
        String r6 = this.F;
        if (r6 != null) goto L22;
        r6 = this.j;
    L22:
        r5 = r6;
    L24:
        return new com.obric.assistant.feedback.d.a(r0, r3, r5);
    L11:
        r4 = false;
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    public final String ea0() {
        ObricDialogfragTipOffBinding r0 = this.f;
        if (r0 == null) goto L9;
        ObricFlowTagLayout r1 = r0.o;
        if (r1 == null) goto L9;
        ObricFlowTagLayout.a r2 = r1.getCurSelectedTagBean();
        if (r2 == null) goto L9;
        Integer r3 = Integer.valueOf(r2.b);
    L10:
        List<ObricFeedbackReasonConfig.FeedbackReason> r4 = ObricFeedbackReasonConfig.a;
        if (r3 != null) goto L13;
        return null;
    L13:
        return ObricFeedbackReasonConfig.f.get(Integer.valueOf(r3.intValue()));
    L9:
        r3 = null;
        goto L10
    }

    public final com.obric.assistant.util.a.b fa0() {
        com.obric.assistant.util.a.b r0 = this.P;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Set<String> r1 = com.obric.assistant.util.a.a;
        List<String> r2 = this.D;
        if (r2 != null) goto L8;
        r2 = CollectionsKt.emptyList();
    L8:
        Intrinsics.checkNotNullParameter(r2, "rawPaths");
        Intrinsics.checkNotNullParameter("ObricTipOffDialogFragment", "logTag");
        Intrinsics.checkNotNullParameter("gui log", "logScene");
        LinkedHashSet r3 = new LinkedHashSet();
        LinkedHashSet r4 = new LinkedHashSet();
        Iterator<T> r5 = r2.iterator();
    L10:
        if (r5.hasNext() == false) goto L15;
        String r6 = (String) r5.next();
        if (StringsKt.isBlank(r6) == true) goto L10;
        Set<String> r7 = com.obric.assistant.util.a.a;
        com.obric.assistant.util.a.C0027a r8 = com.obric.assistant.util.a.a(new PolarisFileWrapper(r6));
        r3.addAll(r8.a);
        r4.addAll(r8.b);
        goto L10
    L15:
        com.obric.assistant.util.a.b r9 = new com.obric.assistant.util.a.b(CollectionsKt.toList(r3), CollectionsKt.toList(r4));
        FLogger.a.i("ObricTipOffDialogFragment", "gui log classification finished: rawPathCount=" + r2.size() + ", imagePathCount=" + r9.a.size() + ", otherPathCount=" + r9.b.size());
        this.P = r9;
        return r9;
    }

    public final ObricTipOffDialogViewModel ga0() {
        return (ObricTipOffDialogViewModel) this.g.getValue();
    }

    public final void ka0() {
        com.obric.assistant.feedback.d r0 = com.obric.assistant.feedback.d.a;
        com.obric.assistant.feedback.d.a r1 = da0();
        com.obric.assistant.feedback.d.b r2 = new com.obric.assistant.feedback.d.b(this.H, this.I);
        String r3 = ha0();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "eventContext");
        Intrinsics.checkNotNullParameter("consent_upload", "popupType");
        if (com.obric.assistant.feedback.d.f(r2) == false) goto L7;
        JSONObject r4 = com.obric.assistant.feedback.d.c(r1, r2, r3);
        r4.put("popup_type", "consent_upload");
        com.larus.platform.service.o.a.reportEvent("obric_popup_show", r4);
        return;
    }

    public final void la0() {
        ObricDialogfragTipOffBinding r0 = this.f;
        Boolean r1 = null;
        if (r0 == null) goto L22;
        RelativeLayout r2 = r0.q;
        if (r2 == null) goto L22;
        boolean r3 = false;
        if (r2.getVisibility() != 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L22;
        ObricDialogfragTipOffBinding r5 = this.f;
        if (r5 == null) goto L21;
        OCheckBoxLayout r6 = r5.p;
        if (r6 == null) goto L21;
        if (r6.isChecked() != true) goto L21;
        r3 = true;
    L21:
        r1 = Boolean.valueOf(r3);
        goto L22
    L9:
        r4 = false;
    L22:
        com.obric.assistant.feedback.d r7 = com.obric.assistant.feedback.d.a;
        com.obric.assistant.feedback.d.a r8 = da0();
        com.obric.assistant.feedback.d.b r9 = new com.obric.assistant.feedback.d.b(this.H, this.I);
        String r10 = ha0();
        String r11 = ea0();
        r7.getClass();
        com.obric.assistant.feedback.d.e(r8, r9, r10, "feedback", WindowEvent.WindowOpenPerfResult.CANCEL, r11, r1);
    }

    public final void oa0() {
        ObricDialogfragTipOffBinding r0 = this.f;
        if (r0 == null) goto L30;
        FrameLayout r1 = r0.a;
        if (r1 == null) goto L34;
        Context r2 = r1.getContext();
        if (r2 == null) goto L35;
        int r3 = ma0(r2, 2130972123, 2131103203);
        int r4 = ma0(r2, 2130972082, 2131103146);
        int r5 = ma0(r2, 2130972127, 2131103215);
        int r6 = ma0(r2, 2130972128, 2131103218);
        int r7 = ma0(r2, 2130972087, 2131103162);
        int r8 = ma0(r2, 2130972118, 2131103188);
        int r9 = r2.getResources().getDimensionPixelSize(v19.c.b(2130971138, r2, 2131166647));
        Iterator<T> r10 = ca0().iterator();
    L11:
        if (r10.hasNext() == false) goto L36;
        Pair r11 = (Pair) r10.next();
        RoundTextView r12 = (RoundTextView) r11.component1();
        int r13 = ((Number) r11.component2()).intValue();
        Integer r14 = this.M;
        int r15 = 0;
        if (r14 != null) goto L16;
    L18:
        boolean r16 = false;
    L19:
        if (r16 == false) goto L21;
        int r17 = r3;
    L22:
        r12.setTextColor(r17);
        c29.a r18 = r12.getDelegate();
        r18.j(r4);
        r18.i(r9);
        if (r16 == false) goto L25;
        int r19 = r6;
    L26:
        r18.g(r19);
        r18.h(r7);
        if (r16 == false) goto L29;
        r15 = r5;
    L29:
        r18.a(r15);
        r18.b(r8);
        goto L11
    L25:
        r19 = r7;
        goto L26
    L21:
        r17 = r4;
        goto L22
    L16:
        if (r14.intValue() != r13) goto L18;
        r16 = true;
        goto L19
    L36:
        return;
    L35:
        return;
    L34:
        return;
    }

    public ObricTipOffDialogFragment() {
        this.e = "ObricTipOffDialogFragment";
        final Function0<Fragment> r0 = new ObricTipOffDialogFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ObricTipOffDialogViewModel.class), new ObricTipOffDialogFragment$special$$inlined$viewModels$default$2(r0), new ObricTipOffDialogFragment$special$$inlined$viewModels$default$3(r0, this));
        this.h = AuthModelDelegate.b.e();
        this.j = "";
        this.k = "";
        this.n = "";
        this.o = "";
        this.J = "";
        this.K = "";
        this.L = "";
    }

    public final String ha0() {
        AssistantActivityExpandState r0 = IAssistantInteractionServiceKt.getInteractionStateService().getInteractionActivityExpandState();
        int r1 = c.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        return "full_screen";
    L5:
        if (r1 != 2) goto L7;
        return "global_quad_screen";
    L7:
        if (r1 != 3) goto L9;
    L11:
        return "global_small_window";
    L9:
        if (r1 == 4) goto L11;
        return "unknown";
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Y90();
    }

    public final by7.e parentTrackNode() {
        return by7.i.c(this);
    }

    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    @Override // com.obric.assistant.tipoff.BaseObricTipOffDialogFragment
    public final String getLogTag() {
        return this.e;
    }

    public final void onStop() {
        super/*androidx.fragment.app.DialogFragment*/.onStop();
    }

    public static void aa0(ObricTipOffDialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void S90(com.larus.bmhome.tipoff.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.w = r2;
    }

    public final void fillTrackParams(TrackParams r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        SearchMobParam r0 = this.m;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.a;
    L6:
        r4.putIfNull("query", r2);
        SearchMobParam r3 = this.m;
        if (r3 == null) goto L9;
        String r5 = r3.b;
    L10:
        r4.putIfNull("query_id", r5);
        SearchMobParam r6 = this.m;
        if (r6 == null) goto L13;
        String r7 = r6.c;
    L14:
        r4.putIfNull("search_id", r7);
        SearchMobParam r8 = this.m;
        if (r8 == null) goto L17;
        String r9 = r8.d;
    L18:
        r4.putIfNull("search_request_id", r9);
        SearchMobParam r10 = this.m;
        if (r10 == null) goto L21;
        String r11 = r10.e;
    L22:
        r4.putIfNull("search_result_id", r11);
        SearchMobParam r12 = this.m;
        if (r12 == null) goto L25;
        r1 = r12.f;
    L25:
        r4.putIfNull("rank", r1);
        return;
    L21:
        r11 = null;
        goto L22
    L17:
        r9 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super/*androidx.fragment.app.DialogFragment*/.onCancel(r2);
        if (this.B == false) goto L6;
        na0(false, false, null, null);
        return;
    }

    @Override // com.obric.assistant.tipoff.BaseObricTipOffDialogFragment
    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        FLogger r7 = FLogger.a;
        r7.i("ObricTipOffDialogFragment", "onCreate");
        Bundle r0 = getArguments();
        String r2 = "";
        if (r0 == null) goto L22;
        TipOffDialogParams r3 = r0.getParcelable("tip_off_params");
        if (r3 == null) goto L10;
        this.i = r3.a;
        this.j = r3.b;
        this.l = r3.c;
        this.n = r3.e;
        this.o = r3.f;
        this.p = r3.g;
        this.m = r3.h;
        this.q = r3.i;
        String r4 = r3.j;
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        this.k = r4;
        this.r = r3.k;
        this.s = r3.l;
        this.t = r3.n;
        this.u = r3.m;
        this.v = r3.o;
    L10:
        ObricTipOffDialogExtraParams r1 = (ObricTipOffDialogExtraParams) r0.getParcelable("obric_extra_params");
        if (r1 == null) goto L22;
        this.x = r1.a;
        this.y = r1.b;
        this.z = r1.c;
        this.A = r1.d;
        this.B = r1.e;
        this.C = r1.f;
        this.D = r1.g;
        this.P = null;
        this.E = r1.h;
        this.F = r1.i;
        this.G = r1.j;
        this.H = r1.k;
        this.I = r1.l;
        String r5 = r1.m;
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        this.J = r5;
        String r8 = r1.n;
        if (r8 != null) goto L18;
        r8 = "";
    L18:
        this.K = r8;
        String r9 = r1.o;
        if (r9 != null) goto L21;
        r9 = "";
    L21:
        this.L = r9;
    L22:
        StringBuilder r10 = new StringBuilder("isFromDislike = ");
        r10.append(this.B);
        r10.append(", feedbackSource = ");
        String r11 = this.G;
        if (r11 != null) goto L25;
        r11 = "";
    L25:
        r10.append(r11);
        r10.append(", feedbackBizType = ");
        String r12 = this.H;
        if (r12 != null) goto L28;
        r12 = "";
    L28:
        r10.append(r12);
        r10.append(", searchTool = ");
        String r13 = this.I;
        if (r13 == null) goto L32;
        r2 = r13;
    L32:
        r10.append(r2);
        r7.i("ObricTipOffDialogFragment", r10.toString());
    }

    public final void ba0(boolean r18, boolean r19) {
        FLogger r1 = FLogger.a;
        Integer r2 = this.M;
        if (r2 == null) goto L5;
        String r3 = r2.toString();
    L6:
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r1.i("ObricTipOffDialogFragment", "doSubmit: feedback_score = ".concat(r3));
        if (r19 == false) goto L32;
        ObricDialogfragTipOffBinding r4 = this.f;
        if (r4 == null) goto L30;
        RelativeLayout r5 = r4.q;
        if (r5 == null) goto L30;
        boolean r6 = false;
        if (r5.getVisibility() != 0) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == true) goto L21;
        r5 = null;
    L21:
        if (r5 == null) goto L30;
        ObricDialogfragTipOffBinding r8 = this.f;
        if (r8 == null) goto L29;
        OCheckBoxLayout r9 = r8.p;
        if (r9 == null) goto L29;
        if (r9.isChecked() != true) goto L29;
        r6 = true;
    L29:
        Boolean r10 = Boolean.valueOf(r6);
    L31:
        com.obric.assistant.feedback.d r11 = com.obric.assistant.feedback.d.a;
        com.obric.assistant.feedback.d.a r12 = da0();
        com.obric.assistant.feedback.d.b r13 = new com.obric.assistant.feedback.d.b(this.H, this.I);
        String r14 = ha0();
        String r15 = ea0();
        r11.getClass();
        com.obric.assistant.feedback.d.e(r12, r13, r14, "feedback", "submit", r15, r10);
        goto L32
    L17:
        r7 = false;
    L30:
        r10 = null;
    L32:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricTipOffDialogFragment$doSubmit$1(this, r18, null), 3, null);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void ja0(String r9, boolean r10) {
        com.obric.assistant.feedback.d r0 = com.obric.assistant.feedback.d.a;
        com.obric.assistant.feedback.d.a r1 = da0();
        com.obric.assistant.feedback.d.b r2 = new com.obric.assistant.feedback.d.b(this.H, this.I);
        String r3 = ha0();
        String r6 = ea0();
        Boolean r7 = Boolean.valueOf(r10);
        r0.getClass();
        com.obric.assistant.feedback.d.e(r1, r2, r3, "consent_upload", r9, r6, r7);
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [com.obric.assistant.tipoff.g] */
    public final void onViewCreated(View r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r19, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r19, r20);
        LifecycleOwner r0 = getViewLifecycleOwner();
        if (r0 == null) goto L5;
        ga0().getSubmitEnable().observe(r0, new d(new g(this)));
    L5:
        Dialog r1 = getDialog();
        if (r1 == null) goto L8;
        r1.setCanceledOnTouchOutside(true);
    L8:
        final ObricDialogfragTipOffBinding r2 = this.f;
        if (r2 == null) goto L18;
        r2.c.setOnClickListener(new i());
        r2.a.setOnClickListener(new j(this));
        r2.s.setOnClickListener(new k(this));
        r2.h.setHint(getString(2131905655));
        String r3 = FeedbackServiceDelegate.b.d();
        if (r3 == null) goto L13;
        r2.b.setText(r3);
    L13:
        r2.b.setOnClickListener(new l(r2, this));
        Iterator<T> r4 = ca0().iterator();
    L15:
        if (r4.hasNext() == false) goto L17;
        Pair r5 = (Pair) r4.next();
        RoundTextView r6 = (RoundTextView) r5.component1();
        final int r7 = ((Number) r5.component2()).intValue();
        r6.setText(String.valueOf(r7));
        e1.d(r6, new n(this, r7));
        goto L15
    L17:
        oa0();
    L18:
        String r8 = this.x;
        if (r8 != null) goto L21;
    L24:
        boolean r9 = true;
    L25:
        if (r9 == true) goto L31;
        ObricDialogfragTipOffBinding r10 = this.f;
        if (r10 == null) goto L31;
        AppCompatTextView r11 = r10.g;
        if (r11 == null) goto L31;
        r11.setText(this.x);
    L31:
        String r12 = this.y;
        if (r12 != null) goto L34;
    L37:
        boolean r13 = true;
    L38:
        if (r13 == true) goto L49;
        ObricDialogfragTipOffBinding r14 = this.f;
        if (r14 == null) goto L44;
        AppCompatTextView r15 = r14.f;
        if (r15 == null) goto L44;
        r15.setText(this.y);
    L44:
        ObricDialogfragTipOffBinding r16 = this.f;
        if (r16 == null) goto L54;
        AppCompatTextView r17 = r16.f;
        if (r17 == null) goto L54;
        j19.c.f(r17);
    L54:
        String r18 = this.z;
        if (r18 != null) goto L57;
    L60:
        boolean r21 = true;
    L61:
        if (r21 == true) goto L67;
        ObricDialogfragTipOffBinding r22 = this.f;
        if (r22 == null) goto L67;
        NestedScrollEditText r23 = r22.h;
        if (r23 == null) goto L67;
        r23.setHint(this.z);
    L67:
        String r24 = this.A;
        if (r24 != null) goto L70;
    L73:
        boolean r25 = true;
    L74:
        if (r25 == true) goto L81;
        ObricDialogfragTipOffBinding r26 = this.f;
        if (r26 == null) goto L81;
        RoundTextView r27 = r26.b;
        if (r27 == null) goto L81;
        r27.setText(this.A);
    L81:
        if (Intrinsics.areEqual(this.H, "search") == false) goto L98;
        ObricDialogfragTipOffBinding r28 = this.f;
        if (r28 == null) goto L87;
        RelativeLayout r29 = r28.q;
        if (r29 == null) goto L87;
        j19.c.f(r29);
    L87:
        ObricDialogfragTipOffBinding r30 = this.f;
        if (r30 == null) goto L92;
        TextView r31 = r30.r;
        if (r31 == null) goto L92;
        r31.setText(2131912396);
    L92:
        ObricDialogfragTipOffBinding r32 = this.f;
        if (r32 == null) goto L97;
        OCheckBoxLayout r33 = r32.p;
        if (r33 == null) goto L97;
        r33.setChecked(false);
    L97:
        FLogger.a.i("ObricTipOffDialogFragment", "initView: search feedback shows unchecked log consent option");
    L143:
        ObricDialogfragTipOffBinding r34 = this.f;
        if (r34 == null) goto L148;
        TextView r35 = r34.r;
        if (r35 == null) goto L148;
        e1.d(r35, new m(this));
    L148:
        boolean r36 = Intrinsics.areEqual(ga0().getSubmitEnable().getValue(), Boolean.TRUE);
        ObricDialogfragTipOffBinding r37 = this.f;
        if (r37 == null) goto L157;
        RoundTextView r38 = r37.b;
        if (r38 == null) goto L157;
        r38.setEnabled(r36);
        if (r36 == false) goto L155;
        float r39 = 1.0f;
    L156:
        r38.setAlpha(r39);
        goto L157
    L155:
        r39 = 0.3f;
    L157:
        ArrayList r40 = new ArrayList();
        List<ReportReason> r41 = this.t;
        if (r41 == null) goto L160;
        r40.addAll(r41);
    L219:
        ArrayList r42 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r40, 10));
        Iterator r43 = r40.iterator();
    L221:
        if (r43.hasNext() == false) goto L226;
        ReportReason r44 = (ReportReason) r43.next();
        String r45 = r44.a();
        if (r45 != null) goto L225;
        r45 = "";
    L225:
        r42.add(new ObricFlowTagLayout.a(r45, r44.b()));
        goto L221
    L226:
        ObricDialogfragTipOffBinding r46 = this.f;
        if (r46 == null) goto L242;
        final ObricFlowTagLayout r47 = r46.o;
        if (r47 == null) goto L242;
        final MutableLiveData<Boolean> r48 = ga0().getSubmitEnable();
        ObricFlowTagLayout.a r49 = (ObricFlowTagLayout.a) CollectionsKt.lastOrNull(r42);
        int r50 = ObricFlowTagLayout.t;
        Intrinsics.checkNotNullParameter(r42, "tags");
        Intrinsics.checkNotNullParameter(r48, "isSelected");
        ((ArrayList) r47.p).clear();
        ((ArrayList) r47.p).addAll(r42);
        r47.removeAllViews();
        Iterator r51 = ((ArrayList) r47.p).iterator();
    L232:
        if (r51.hasNext() == false) goto L240;
        final ObricFlowTagLayout.a r52 = (ObricFlowTagLayout.a) r51.next();
        String r53 = r52.a;
        Function1<? super String, ? extends TextView> r54 = r47.s;
        if (r54 == null) goto L238;
        TextView r55 = (TextView) r54.invoke(r53);
        if (r55 == null) goto L238;
    L239:
        r55.setTag(r52);
        final Function1 r56 = null;
        r55.setOnClickListener(new com.obric.assistant.view.p(r47, r52, r48, r56));
        r47.addView(r55, new FrameLayout.LayoutParams(-2, -2));
    L238:
        r55 = new RoundTextView(r47.getContext());
        r55.setMinHeight(r47.o);
        r55.setTextColor(r47.h);
        r55.setTextSize(0, r47.e);
        int r57 = r47.c;
        int r110 = r47.d;
        r55.setPadding(r57, r110, r57, r110);
        r55.setText(r53);
        r55.setGravity(8388627);
        c29.a r58 = r55.getDelegate();
        r58.j(r47.h);
        r58.e(r47.f);
        r58.i(r47.g);
        r58.g(r47.j);
        r58.h(r47.j);
        r58.a(r47.l);
        r58.b(r47.m);
        goto L239
    L240:
        if (r49 == null) goto L242;
        r47.q = r49;
        r47.a();
        r48.postValue(Boolean.TRUE);
    L242:
        FeedbackServiceDelegate.b.c(r40);
        nga.a r59 = ObricFeedbackPanelServiceDelegate.b.b();
        this.N = r59;
        ObricDialogfragTipOffBinding r60 = this.f;
        if (r60 == null) goto L248;
        FrameLayout r61 = r60.i;
        if (r61 == null) goto L248;
        if (r59 == null) goto L248;
        r59.a(r61, getViewLifecycleOwner());
    L248:
        ObricDialogfragTipOffBinding r62 = this.f;
        if (r62 == null) goto L259;
        final RoundLinearLayout r111 = r62.c;
        final MaxHeightScrollView r63 = r62.e;
        final View r112 = r62.d;
        Intrinsics.checkNotNullParameter(r111, "containerLayout");
        final int r113 = r111.getPaddingBottom();
        final BaseObricTipOffDialogFragment.a r114 = new BaseObricTipOffDialogFragment.a();
        final LinkedHashSet r115 = new LinkedHashSet();
        final LinkedHashSet r116 = new LinkedHashSet();
        final Ref.ObjectRef r117 = new Ref.ObjectRef();
        ViewCompat.setOnApplyWindowInsetsListener(r111, new com.obric.assistant.tipoff.a(r117, r115, r116, this, r63, r112, r114, r113));
        ViewCompat.setWindowInsetsAnimationCallback(r111, new BaseObricTipOffDialogFragment$applyNavigationBarInsets$2(r115, this, r116, r111, r117, r63, r112, r114, r113));
        ViewCompat.requestApplyInsets(r111);
        return;
    L259:
        return;
    L160:
        int r64 = this.i;
        if (r64 != 1) goto L163;
        e0 r65 = (e0) this.h.getValue();
        if (r65 == null) goto L219;
        LaunchInfo r66 = r65.a;
        if (r66 == null) goto L219;
        List r67 = r66.k();
        if (r67 == null) goto L219;
        r40.addAll(r67);
        goto L219
    L163:
        if (r64 != 2) goto L165;
    L205:
        e0 r68 = (e0) this.h.getValue();
        if (r68 == null) goto L219;
        LaunchInfo r69 = r68.a;
        if (r69 == null) goto L219;
        List r70 = r69.O0();
        if (r70 == null) goto L219;
        r40.addAll(r70);
        goto L219
    L165:
        if (r64 == 18) goto L205;
        if (r64 == 25) goto L198;
        switch(r64) {
            case 6: goto L191;
            case 7: goto L184;
            case 8: goto L177;
            case 9: goto L170;
            default: goto L219;
        };
    L170:
        e0 r71 = (e0) this.h.getValue();
        if (r71 == null) goto L219;
        LaunchInfo r72 = r71.a;
        if (r72 == null) goto L219;
        List r73 = r72.O0();
        if (r73 == null) goto L219;
        r40.addAll(r73);
        goto L219
    L177:
        e0 r74 = (e0) this.h.getValue();
        if (r74 == null) goto L219;
        LaunchInfo r75 = r74.a;
        if (r75 == null) goto L219;
        List r76 = r75.O0();
        if (r76 == null) goto L219;
        r40.addAll(r76);
        goto L219
    L184:
        e0 r77 = (e0) this.h.getValue();
        if (r77 == null) goto L219;
        LaunchInfo r78 = r77.a;
        if (r78 == null) goto L219;
        List r79 = r78.O0();
        if (r79 == null) goto L219;
        r40.addAll(r79);
        goto L219
    L191:
        e0 r80 = (e0) this.h.getValue();
        if (r80 == null) goto L219;
        LaunchInfo r81 = r80.a;
        if (r81 == null) goto L219;
        List r82 = r81.k();
        if (r82 == null) goto L219;
        r40.addAll(r82);
        goto L219
    L198:
        e0 r83 = (e0) this.h.getValue();
        if (r83 == null) goto L219;
        LaunchInfo r84 = r83.a;
        if (r84 == null) goto L219;
        List r85 = r84.O0();
        if (r85 == null) goto L219;
        r40.addAll(r85);
        goto L219
    L98:
        IObricFeedbackService.a r86 = IObricFeedbackService.a;
        String r87 = this.H;
        r86.getClass();
        if (IObricFeedbackService.a.b(r87) == false) goto L112;
        ObricDialogfragTipOffBinding r88 = this.f;
        if (r88 == null) goto L105;
        RelativeLayout r89 = r88.q;
        if (r89 == null) goto L105;
        e1.o(r89);
    L105:
        ObricDialogfragTipOffBinding r90 = this.f;
        if (r90 == null) goto L110;
        OCheckBoxLayout r91 = r90.p;
        if (r91 == null) goto L110;
        r91.setChecked(false);
    L110:
        FLogger.a.i("ObricTipOffDialogFragment", "initView: memory feedback hides gui log consent option");
        goto L143
    L112:
        if ((!fa0().a.isEmpty()) == true) goto L124;
        ObricDialogfragTipOffBinding r92 = this.f;
        if (r92 == null) goto L118;
        RelativeLayout r93 = r92.q;
        if (r93 == null) goto L118;
        e1.o(r93);
    L118:
        ObricDialogfragTipOffBinding r94 = this.f;
        if (r94 == null) goto L123;
        OCheckBoxLayout r95 = r94.p;
        if (r95 == null) goto L123;
        r95.setChecked(false);
    L123:
        FLogger.a.i("ObricTipOffDialogFragment", "initView: no image detected, hide image consent option");
        goto L143
    L124:
        boolean r96 = ia0();
        ObricDialogfragTipOffBinding r97 = this.f;
        if (r97 == null) goto L129;
        RelativeLayout r98 = r97.q;
        if (r98 == null) goto L129;
        j19.c.f(r98);
    L129:
        ObricDialogfragTipOffBinding r99 = this.f;
        if (r99 == null) goto L134;
        OCheckBoxLayout r100 = r99.p;
        if (r100 == null) goto L134;
        r100.setChecked(r96);
    L134:
        FLogger r101 = FLogger.a;
        StringBuilder r102 = new StringBuilder("initView: image detected, show image consent option, autoDrainInternalEnabled=");
        r102.append(r96);
        r102.append(", defaultChecked=");
        ObricDialogfragTipOffBinding r103 = this.f;
        if (r103 == null) goto L141;
        OCheckBoxLayout r104 = r103.p;
        if (r104 == null) goto L141;
        if (r104.isChecked() != true) goto L141;
        boolean r105 = true;
    L142:
        r102.append(r105);
        r101.i("ObricTipOffDialogFragment", r102.toString());
    L141:
        r105 = false;
        goto L142
    L70:
        if (r24.length() == 0) goto L73;
        r25 = false;
        goto L74
    L57:
        if (r18.length() == 0) goto L60;
        r21 = false;
        goto L61
    L49:
        ObricDialogfragTipOffBinding r106 = this.f;
        if (r106 == null) goto L54;
        AppCompatTextView r107 = r106.f;
        if (r107 == null) goto L54;
        e1.o(r107);
        goto L54
    L34:
        if (r12.length() == 0) goto L37;
        r13 = false;
        goto L38
    L21:
        if (r8.length() == 0) goto L24;
        r9 = false;
        goto L25
    }

    public static int ma0(Context r0, int r1, int r2) {
        return ContextCompat.getColor(r0, v19.c.b(r1, r0, r2));
    }

    public final View onCreateView(LayoutInflater r25, ViewGroup r26, Bundle r27) {
        Intrinsics.checkNotNullParameter(r25, "inflater");
        View r0 = r25.inflate(2131563982, r26, false);
        int r1 = 2131364848;
        RoundTextView r6 = ViewBindings.findChildViewById(r0, 2131364848);
        if (r6 == null) goto L52;
        r1 = 2131367771;
        RoundLinearLayout r7 = ViewBindings.findChildViewById(r0, 2131367771);
        if (r7 == null) goto L52;
        r1 = 2131367851;
        View r8 = ViewBindings.findChildViewById(r0, 2131367851);
        if (r8 == null) goto L52;
        r1 = 2131367852;
        MaxHeightScrollView r9 = ViewBindings.findChildViewById(r0, 2131367852);
        if (r9 == null) goto L52;
        r1 = 2131368981;
        AppCompatTextView r10 = ViewBindings.findChildViewById(r0, 2131368981);
        if (r10 == null) goto L52;
        r1 = 2131368982;
        AppCompatTextView r11 = ViewBindings.findChildViewById(r0, 2131368982);
        if (r11 == null) goto L52;
        r1 = 2131371800;
        NestedScrollEditText r12 = ViewBindings.findChildViewById(r0, 2131371800);
        if (r12 == null) goto L52;
        r1 = 2131371916;
        FrameLayout r13 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131371916);
        if (r13 == null) goto L52;
        r1 = 2131372304;
        RoundTextView r14 = ViewBindings.findChildViewById(r0, 2131372304);
        if (r14 == null) goto L52;
        r1 = 2131372305;
        RoundTextView r15 = ViewBindings.findChildViewById(r0, 2131372305);
        if (r15 == null) goto L52;
        r1 = 2131372306;
        RoundTextView r16 = ViewBindings.findChildViewById(r0, 2131372306);
        if (r16 == null) goto L52;
        r1 = 2131372307;
        RoundTextView r17 = ViewBindings.findChildViewById(r0, 2131372307);
        if (r17 == null) goto L52;
        r1 = 2131372308;
        RoundTextView r18 = ViewBindings.findChildViewById(r0, 2131372308);
        if (r18 == null) goto L52;
        r1 = 2131372309;
        if (((LinearLayout) ViewBindings.findChildViewById(r0, 2131372309)) == null) goto L52;
        r1 = 2131372310;
        if (((LinearLayout) ViewBindings.findChildViewById(r0, 2131372310)) == null) goto L52;
        r1 = 2131373037;
        ObricFlowTagLayout r19 = (ObricFlowTagLayout) ViewBindings.findChildViewById(r0, 2131373037);
        if (r19 == null) goto L52;
        r1 = 2131374083;
        OCheckBoxLayout r20 = (OCheckBoxLayout) ViewBindings.findChildViewById(r0, 2131374083);
        if (r20 == null) goto L52;
        r1 = 2131374084;
        RelativeLayout r21 = (RelativeLayout) ViewBindings.findChildViewById(r0, 2131374084);
        if (r21 == null) goto L52;
        r1 = 2131374085;
        TextView r22 = (TextView) ViewBindings.findChildViewById(r0, 2131374085);
        if (r22 == null) goto L52;
        r1 = 2131375355;
        if (ViewBindings.findChildViewById(r0, 2131375355) == null) goto L52;
        r1 = 2131376107;
        AppCompatImageView r23 = ViewBindings.findChildViewById(r0, 2131376107);
        if (r23 == null) goto L52;
        FrameLayout r2 = (FrameLayout) r0;
        ObricDialogfragTipOffBinding r3 = new ObricDialogfragTipOffBinding(r2, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);
        Y90();
        Dialog r4 = getDialog();
        if (r4 == null) goto L49;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L49;
        r5.setBackgroundDrawable(new ColorDrawable(0));
    L49:
        this.f = r3;
        return r2;
    L52:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public final void na0(boolean r5, boolean r6, ObricFlowTagLayout.a r7, String r8) {
        FLogger.a.i("ObricTipOffDialogFragment", "setDislikeResult");
        Bundle r0 = this.C;
        if (r0 == null) goto L6;
        String r1 = r0.getString("feedback_request_key");
        if (r1 == null) goto L6;
    L7:
        Bundle r2 = new Bundle();
        r2.putBoolean("is_submit", r6);
        r2.putBundle("extra_data", r0);
        r2.putInt("selected_code", 4);
        if (r7 == null) goto L10;
        Object r9 = r7.c;
    L12:
        if ((r9 instanceof FeedbackMeta) == false) goto L14;
        r2.putParcelable("selected_tag", (Parcelable) r7.c);
    L14:
        if (r8 != null) goto L16;
        r8 = "";
    L16:
        r2.putString("input_txt", r8);
        Unit r10 = Unit.INSTANCE;
        o5.a(this, r1, r2);
        ObricDialogfragTipOffBinding r11 = this.f;
        if (r11 == null) goto L21;
        NestedScrollEditText r12 = r11.h;
        if (r12 == null) goto L21;
        new x1(r12).a(false);
    L21:
        if (r5 == false) goto L24;
        aa0(this);
        return;
    L24:
        return;
    L10:
        r9 = null;
    L6:
        r1 = "dislikeDialogClose";
        goto L7
    }
}
