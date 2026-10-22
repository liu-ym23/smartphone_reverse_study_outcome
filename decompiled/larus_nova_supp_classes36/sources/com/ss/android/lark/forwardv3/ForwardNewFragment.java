package com.ss.android.lark.forwardv3;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.basic.v1.ActionType;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.forwardv3.configuration.Forward$Source;
import com.ss.android.lark.forwardv3.configuration.Forward$Type;
import com.ss.android.lark.forwardv3.configuration.ForwardAdditionNoteConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardCommonConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardConfirmDialogConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardSelectConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTargetConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$GroupType;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$Shield;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$Status;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$Tenant;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$ThreadType;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$UserType;
import com.ss.android.lark.forwardv3.configuration.targetconfig.DisableConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem;
import com.ss.android.lark.forwardv3.configuration.targetconfig.GroupConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.ThreadConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig;
import com.ss.android.lark.forwardv3.data.ForwardErrorResultV3;
import com.ss.android.lark.forwardv3.dialogfragment.ForwardDialogFragment;
import com.ss.android.lark.forwardv3.doubao.DoubaoWorkSearchResultAdapterKt;
import com.ss.android.lark.forwardv3.messageforward.MergeMessageForwardContent;
import com.ss.android.lark.forwardv3.messageforward.OneByOneMessageForwardContent;
import com.ss.android.lark.forwardv3.messageforward.SingleMessageForwardContent;
import com.ss.android.lark.forwardv3.plugins.ForwardAtPlugin;
import com.ss.android.lark.forwardv3.plugins.ForwardCreateGroupChatPlugin;
import com.ss.android.lark.forwardv3.recentforward.RecentForwardAdapterV3;
import com.ss.android.lark.forwardv3.statistics.MergeForwardLimitFrom;
import com.ss.android.lark.forwardv3.utils.ConfigUtils;
import com.ss.android.lark.forwardv3.utils.ForwardDataUtils;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModelFactory;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.SearchResultAdapter;
import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.CommonTitleBarConstants;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.UIHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import z5c.c4;
import z5c.r;
import z5c.z2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u0085\u00012\u00020\u00012\u00020\u0002:\u0004\u0085\u0001\u0086\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0017J&\u0010*\u001a\u0004\u0018\u00010\u001a2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020'H\u0002J\b\u00102\u001a\u00020'H\u0002J\u0012\u00103\u001a\u00020'2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020\u001aH\u0002J\u0010\u00106\u001a\u00020'2\u0006\u00107\u001a\u00020 H\u0002J\u0010\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020:H\u0002J\n\u0010;\u001a\u0004\u0018\u00010<H\u0002J\u0016\u0010=\u001a\u00020>2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\b\u0010@\u001a\u00020'H\u0002J\b\u0010A\u001a\u00020'H\u0002J\b\u0010B\u001a\u00020'H\u0016J \u0010C\u001a\u00020'2\u0006\u0010D\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010H\u001a\u00020'2\u0006\u0010I\u001a\u00020\u0014H\u0002J\b\u0010J\u001a\u00020'H\u0002J\b\u0010K\u001a\u00020'H\u0002J\b\u0010L\u001a\u00020'H\u0002J\b\u0010M\u001a\u00020'H\u0002J%\u0010N\u001a\u00020'2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010P2\n\b\u0002\u0010Q\u001a\u0004\u0018\u000100H\u0002¢\u0006\u0002\u0010RJ\b\u0010S\u001a\u00020'H\u0002J\u0018\u0010T\u001a\u00020'2\u0006\u0010U\u001a\u00020\u00142\u0006\u0010V\u001a\u00020\u0014H\u0002J4\u0010W\u001a\u00020'*\u00020\u00062\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u00142\u0006\u0010[\u001a\u00020\u00142\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020PH\u0002J\u0014\u0010_\u001a\u00020'*\u00020\u00062\u0006\u0010`\u001a\u00020\u0014H\u0002J \u0010a\u001a\u00020'2\u0006\u0010b\u001a\u00020\u00122\u0006\u0010c\u001a\u00020]2\u0006\u0010d\u001a\u00020\u0014H\u0002J\u0010\u0010e\u001a\u00020\u00142\u0006\u0010f\u001a\u00020\u0012H\u0002J\u0010\u0010g\u001a\u00020G2\u0006\u0010h\u001a\u00020]H\u0002J \u0010i\u001a\u00020'2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010j\u001a\u00020]H\u0002J.\u0010k\u001a\u00020'2\u0006\u0010X\u001a\u00020Y2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010l\u001a\u00020]2\u0006\u0010m\u001a\u00020nH\u0002J\u0012\u0010o\u001a\u00020'2\b\u0010p\u001a\u0004\u0018\u00010qH\u0002J \u0010r\u001a\u00020'2\b\u0010s\u001a\u0004\u0018\u00010t2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0010\u0010u\u001a\u00020'2\u0006\u0010v\u001a\u00020qH\u0002J0\u0010w\u001a\u00020'2\u0006\u0010l\u001a\u00020]2\b\u0010m\u001a\u0004\u0018\u00010]2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010x\u001a\u00020GH\u0002J\u0006\u0010y\u001a\u00020\u0014J\b\u0010z\u001a\u00020'H\u0016J\"\u0010{\u001a\u00020'2\u0006\u0010|\u001a\u00020P2\u0006\u0010O\u001a\u00020P2\b\u0010f\u001a\u0004\u0018\u00010}H\u0016J\u0010\u0010~\u001a\u00020'2\u0006\u0010\u007f\u001a\u00020]H\u0002J\t\u0010\u0080\u0001\u001a\u00020'H\u0016J\u001f\u0010\u0081\u0001\u001a\u00020'2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010]2\t\u0010\u0083\u0001\u001a\u0004\u0018\u000100H\u0016J\t\u0010\u0084\u0001\u001a\u00020\u0014H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0087\u0001"}, d2 = {"Lcom/ss/android/lark/forwardv3/ForwardNewFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/ui/IActionCallback;", "<init>", "()V", "titleBar", "Lcom/ss/android/lark/ui/CommonTitleBar;", "chatPicker", "Lcom/ss/android/lark/forwardv3/dependency/IForwardChatPicker;", "viewModel", "Lcom/ss/android/lark/forwardv3/viewmodel/ForwardV3ViewModel;", "rightTextView", "Landroid/widget/TextView;", "recentForwardAdapter", "Lcom/ss/android/lark/forwardv3/recentforward/RecentForwardAdapterV3;", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "isFromCreateGroupChat", "", "forwardPluginManager", "Lcom/ss/android/lark/forwardv3/plugins/ForwardPluginManager;", "forwardSendHelper", "Lcom/ss/android/lark/forwardv3/IForwardSendHelper;", "recentForwardView", "Landroid/view/View;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "activityStartTime", "", "forwardTemplateNew", "Lcom/ss/android/lark/forwardv3/configuration/ForwardTemplateNew;", "isPickerInSearchMode", "itemClickHandler", "Lcom/ss/android/lark/forwardv3/recentforward/RecentForwardAdapterV3$OnItemClickListener;", "onItemBusinessConsumeClickListener", "Lcom/ss/android/lark/forwardv3/recentforward/RecentForwardAdapterV3$OnItemBusinessConsumeClickListener;", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initWindowInsets", "penetrationReport", "onActivityCreated", "bindView", "rootView", "initViewModel", "templateNew", "buildForwardSendHelper", "sendCallback", "Lcom/ss/android/lark/forwardv3/ForwardSendHelper$ForwardSendCallback;", "getExternalForwardSendMode", "Lcom/ss/android/lark/forwardv3/ExternalForwardSendMode;", "buildConfirmForwardTargetGroups", "Lcom/ss/android/lark/forwardv3/ForwardNewFragment$ConfirmForwardTargetGroups;", "items", "initTitleBar", "initChatPicker", "onDestroyView", "reportForwardPanelClick", "info", "isRecentForward", "click", "Lcom/ss/android/lark/statistics/extensions/IParam;", "resetFocus", "needResetKeyboardNavigation", "initRecentForward", "observeViewModel", "handleRightViewClick", "handleLeftViewClick", "findStrategyAndClose", "resultCode", "", "bundle", "(Ljava/lang/Integer;Landroid/os/Bundle;)V", "switchSelectMode", "updateTitleBarView", "changeLeft", "changeRight", "updateTitleRightBarView", "context", "Landroid/content/Context;", "isShow", "isEnable", "text", "", "textColorResId", "updateTitleBarLeftView", "isCancelState", "notifyRecentForwardDataChange", "searchBaseInfo", "id", "isSelected", "dealBusinessConsumeClick", "data", "getForwardScene", "sourceSceneTag", "showConfirmForwardDialog", "scene", "launchForwardTask", "note", "richText", "Lcom/ss/android/lark/widget/richtext/RichText;", "recordCreateP2PChatError", "errorResult", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "doSuccess", "result", "Lcom/ss/android/lark/forwardv3/data/ForwardResultV3;", "doError", "err", "sendOnConfirmClickHitPoint", "forwardScene", "onBackPressed", "onPause", "onActivityResult", "requestCode", "Landroid/content/Intent;", "onCreateGroupChatFinish", "chatId", "onDestroy", "onActionPerform", "methodName", "extra", "handleClose", "Companion", "ConfirmForwardTargetGroups", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardNewFragment extends BaseFragment implements com.ss.android.lark.ui.b {
    public static final /* synthetic */ int t = 0;
    public CommonTitleBar d;
    public tib.e e;
    public ForwardV3ViewModel f;
    public TextView g;
    public RecentForwardAdapterV3 h;
    public IGetDataCallback<List<SearchBaseInfo>> i;
    public boolean j;
    public com.ss.android.lark.forwardv3.plugins.f k;
    public z l;
    public View m;
    public RecyclerView n;
    public long o;
    public ForwardTemplateNew p;
    public boolean q;
    public final c r;
    public final e s;

    public static final class a {
        public static ForwardNewFragment a(Bundle r2) {
            if (r2 != null) goto L4;
        L9:
            ForwardNewFragment r0 = new ForwardNewFragment();
            r0.setArguments(r2);
            return r0;
        L4:
            if ((!r2.getBoolean("start_by_forward_act")) == false) goto L6;
            Bundle r1 = r2;
        L7:
            if (r1 == null) goto L9;
            boolean r3 = zib.b.d;
            zib.b.e(c4.d, "multi_tab");
            goto L9
        L6:
            r1 = null;
            goto L7
        }
    }

    public static final class b {
        public final List<SearchBaseInfo> a;
        public final List<SearchBaseInfo> b;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ConfirmForwardTargetGroups(internalItems=" + this.a + ", externalItems=" + this.b + ')';
        }

        public b(List<? extends SearchBaseInfo> r2, List<? extends SearchBaseInfo> r3) {
            Intrinsics.checkNotNullParameter(r2, "internalItems");
            Intrinsics.checkNotNullParameter(r3, "externalItems");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c implements RecentForwardAdapterV3.b {
        public final /* synthetic */ ForwardNewFragment a;

        public c(ForwardNewFragment r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.forwardv3.recentforward.RecentForwardAdapterV3.b
        public final void a(SearchBaseInfo r7, int r8, boolean r9) {
            Intrinsics.checkNotNullParameter(r7, "data");
            ForwardV3ViewModel r0 = this.a.f;
            ForwardV3ViewModel r2 = null;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r0 = null;
        L5:
            Integer r1 = (Integer) r0.getSelectMode().getValue();
            if (r1 != null) goto L9;
        L18:
            if (r1 != null) goto L21;
            return;
        L21:
            if (r1.intValue() != 0) goto L25;
            Log.i("NewForward", "show confirm forward dialog from: recent forward");
            this.a.ca0(CollectionsKt.mutableListOf(new SearchBaseInfo[]{r7}), "from_normal_select");
            boolean r10 = zib.b.d;
            zib.b.a(true, true);
            ForwardNewFragment.W90(this.a, r7, true, r.l);
            return;
        L25:
            return;
        L9:
            if (r1.intValue() != 1) goto L18;
            RecyclerView.Adapter r3 = this.a.h;
            if (r3 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("recentForwardAdapter");
            r3 = null;
        L13:
            r3.notifyItemChanged(r8, "view_checkbox");
            ForwardV3ViewModel r11 = this.a.f;
            if (r11 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L17:
            r2.updateMultiItemSelect(r7, r9);
            boolean r12 = zib.b.d;
            zib.b.a(false, true);
            ForwardNewFragment.W90(this.a, r7, true, r.l);
            return;
        L16:
            r2 = r11;
            goto L17
        }
    }

    public static final class d implements y.a {
        public final /* synthetic */ ForwardNewFragment a;

        public d(ForwardNewFragment r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.forwardv3.y.a
        public final void a(ErrorResult r2) {
            Intrinsics.checkNotNullParameter(r2, "err");
            ForwardNewFragment.T90(this.a, r2);
        }

        @Override // com.ss.android.lark.forwardv3.y.a
        public final void onError(ErrorResult r2) {
            Intrinsics.checkNotNullParameter(r2, "err");
            ForwardNewFragment.T90(this.a, r2);
        }

        @Override // com.ss.android.lark.forwardv3.y.a
        public final void b(rib.d r3, List<? extends SearchBaseInfo> r4) {
            Intrinsics.checkNotNullParameter(r4, "items");
            ForwardNewFragment r0 = this.a;
            int r1 = ForwardNewFragment.t;
            r0.getClass();
            UICallbackExecutor.post(h.a);
            UICallbackExecutor.execute(new i(r0, r3, r4));
        }
    }

    public static final class e implements RecentForwardAdapterV3.a {
        public final /* synthetic */ ForwardNewFragment a;

        public e(ForwardNewFragment r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.forwardv3.recentforward.RecentForwardAdapterV3.a
        public final boolean a(SearchBaseInfo r3) {
            Intrinsics.checkNotNullParameter(r3, "data");
            boolean r4 = ForwardNewFragment.S90(this.a, r3);
            Log.i("NewForward", "recent forward consume item click: " + r4);
            return r4;
        }
    }

    public static final class f implements com.ss.android.lark.forwardv3.plugins.g.b {
        public final /* synthetic */ b a;

        @Override // com.ss.android.lark.forwardv3.plugins.g.b
        public final List<SearchBaseInfo> a() {
            return this.a.a;
        }

        public f(b r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.forwardv3.ForwardNewFragment$onActivityCreated$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.forwardv3.ForwardNewFragment$onActivityCreated$3", f = "ForwardNewFragment.kt", i = {}, l = {305}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ForwardNewFragment this$0;

        public AnonymousClass3(ForwardNewFragment r1, Continuation<? super AnonymousClass3> r2) {
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

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            Log.i("NewForward", "start async load message params");
            ForwardV3ViewModel r5 = this.this$0.f;
            if (r5 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r5 = null;
        L11:
            this.label = 1;
            if (r5.asyncLoadMessageParams(this) != r0) goto L15;
            return r0;
        }
    }

    static {
    }

    public final boolean Z90() {
        ForwardV3ViewModel r0 = this.f;
        ForwardV3ViewModel r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        oib.b r2 = r0.getCloseForwardListener();
        if (r2 == null) goto L8;
        r2.onClose();
    L8:
        KeyboardUtils.hideKeyboard(getContext());
        ForwardV3ViewModel r3 = this.f;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L13:
        if (r1.getEnableBackOriginalApplication() == true) goto L15;
        return false;
    L15:
        if (getActivity() != null) goto L17;
        return false;
    L17:
        if (isAdded() == false) goto L26;
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L21;
        r4.moveTaskToBack(true);
    L21:
        zab.a.a(this);
        return true;
    L26:
        return false;
    L11:
        r1 = r3;
        goto L13
    }

    public final void aa0() {
        ForwardV3ViewModel r0 = this.f;
        ForwardV3ViewModel r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        com.ss.android.lark.forwardv3.data.a r1 = r0.getTitleBarShowInfo();
        StringBuilder r3 = new StringBuilder("handle left click + ");
        int r4 = com.ss.android.lark.forwardv3.data.a.g;
        r3.append(com.ss.android.lark.forwardv3.data.a.C0072a.a(r1));
        Log.i("NewForward", r3.toString());
        if (r1.e == false) goto L24;
        ForwardV3ViewModel r5 = this.f;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r5 = null;
    L10:
        oib.a r6 = r5.getCancelMultiSelectListener();
        if (r6 == null) goto L13;
        r6.cancel();
    L13:
        tib.e r7 = this.e;
        if (r7 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
        r7 = null;
    L16:
        r7.f(null);
        tib.e r8 = this.e;
        if (r8 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
        r8 = null;
    L19:
        r8.c();
        ForwardV3ViewModel r9 = this.f;
        if (r9 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L23:
        r2.clearSelectedItem();
        da0();
        return;
    L22:
        r2 = r9;
        goto L23
    L24:
        boolean r10 = com.ss.android.lark.forwardv3.utils.b.a("core.forward.handle_back_ef", false);
        Log.i("FGUtils", "FG key: core.forward.handle_back_ef: " + r10);
        if ((!r10) == true) goto L27;
        Z90();
        X90(null, null);
        return;
    L27:
        if (Z90() == true) goto L32;
        X90(null, null);
        return;
    }

    public final void ba0() {
        ForwardV3ViewModel r0 = this.f;
        ForwardV3ViewModel r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        com.ss.android.lark.forwardv3.data.a r1 = r0.getTitleBarShowInfo();
        StringBuilder r3 = new StringBuilder("handle right click: + ");
        int r4 = com.ss.android.lark.forwardv3.data.a.g;
        r3.append(com.ss.android.lark.forwardv3.data.a.C0072a.a(r1));
        Log.i("NewForward", r3.toString());
        int r5 = r1.f;
        if (r5 != 0) goto L8;
        da0();
        return;
    L8:
        if (r5 != 1) goto L10;
        da0();
        return;
    L10:
        if (r5 != 2) goto L12;
        Log.i("NewForward", "show confirm forward dialog from: confirm button multiple click");
        ForwardV3ViewModel r6 = this.f;
        if (r6 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L19:
        ca0(r2.getSelectedItemList(), "from_normal_select");
        return;
    L18:
        r2 = r6;
        goto L19
    L12:
        if (r5 != 3) goto L26;
        Log.e("NewForward", "title bar's right view button is disable or hidden");
        return;
    }

    public final void da0() {
        ForwardV3ViewModel r0 = this.f;
        ForwardV3ViewModel r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.switchSelectMode();
        RecentForwardAdapterV3 r1 = this.h;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recentForwardAdapter");
        r1 = null;
    L8:
        r1.y2();
        tib.e r3 = this.e;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
        r3 = null;
    L11:
        ForwardV3ViewModel r4 = this.f;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r4 = null;
    L14:
        Integer r5 = (Integer) r4.getSelectMode().getValue();
        boolean r6 = false;
        if (r5 != null) goto L18;
    L20:
        boolean r7 = false;
    L21:
        r3.b(r7);
        ForwardV3ViewModel r8 = this.f;
        if (r8 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r8 = null;
    L25:
        if (r8.getEnableRecentForward() == false) goto L41;
        RecentForwardAdapterV3 r9 = this.h;
        if (r9 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("recentForwardAdapter");
        r9 = null;
    L29:
        ForwardV3ViewModel r10 = this.f;
        if (r10 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L33:
        Integer r11 = (Integer) r2.getSelectMode().getValue();
        if (r11 != null) goto L37;
    L39:
        r9.switchMultiple(r6);
        return;
    L37:
        if (r11.intValue() != 1) goto L39;
        r6 = true;
        goto L39
    L32:
        r2 = r10;
        goto L33
    L41:
        return;
    L18:
        if (r5.intValue() != 1) goto L20;
        r7 = true;
        goto L21
    }

    public final void onDestroyView() {
        tib.e r0 = this.e;
        if (r0 == null) goto L7;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
        r0 = null;
    L6:
        r0.destroy();
    L7:
        super.onDestroyView();
    }

    public ForwardNewFragment() {
        this.r = new c(this);
        this.s = new e(this);
    }

    public final ExternalForwardSendMode Y90() {
        Bundle r0 = getArguments();
        Object r1 = null;
        if (r0 == null) goto L22;
        String r2 = r0.getString("key_intent_external_forward_send_mode");
        if (r2 == null) goto L23;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        Object r4 = Result.constructor-impl(ExternalForwardSendMode.valueOf(r2));     // Catch: Throwable -> L9
    L12:
        if (Result.exceptionOrNull-impl(r4) == null) goto L15;
        Log.w("NewForward", "invalid external forward send mode: ".concat(r2));
    L15:
        if (Result.isFailure-impl(r4) == true) goto L19;
        r1 = r4;
    L19:
        return (ExternalForwardSendMode) r1;
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L23:
        return null;
    L22:
        return null;
    }

    public final void onDestroy() {
        super.onDestroy();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        com.ss.android.lark.forwardv3.plugins.f r1 = this.k;     // Catch: Throwable -> L11
        if (r1 == null) goto L6;
        r1.a();     // Catch: Throwable -> L11
    L6:
        tib.e r2 = this.e;     // Catch: Throwable -> L11
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");     // Catch: Throwable -> L11
        r2 = null;
    L9:
        r2.destroy();     // Catch: Throwable -> L11
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L14:
        if (Result.exceptionOrNull-impl(r3) == null) goto L19;
        Log.e("NewForward", "onDestroy failed");
        return;
    L19:
        return;
    L11:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        KeyboardUtils.hideKeyboard(requireContext());
    }

    public final void Sl(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L7;
        Log.e("NewForward", "methodName is null or empty");
        return;
    L7:
        if (Intrinsics.areEqual(r3, "multiSelect") == false) goto L10;
        Log.i("NewForward", "start handle click right view outer");
        ba0();
        return;
    L10:
        if (Intrinsics.areEqual(r3, "onCancel") == false) goto L14;
        Log.i("NewForward", "start handle click left view outer");
        aa0();
        return;
    }

    public final void ea0(boolean r13) {
        ForwardV3ViewModel r0 = this.f;
        CommonTitleBar r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        com.ss.android.lark.forwardv3.data.a r2 = r0.getTitleBarShowInfo();
        StringBuilder r3 = new StringBuilder("update title bar view: ");
        int r4 = com.ss.android.lark.forwardv3.data.a.g;
        r3.append(com.ss.android.lark.forwardv3.data.a.C0072a.a(r2));
        Log.i("NewForward", r3.toString());
        LinearLayout r5 = this.d;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r5 = null;
    L8:
        Application r6 = com.larksuite.framework.utils.b.a;
        boolean r7 = r2.a;
        boolean r8 = r2.b;
        String r9 = r2.c;
        int r10 = r2.d;
        if ((getParentFragment() instanceof com.ss.android.lark.ui.b) == false) goto L11;
        new Bundle().putString("actionName", r9);
        com.ss.android.lark.ui.b r11 = getParentFragment();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.ss.android.lark.ui.IActionCallback");
        r11.Sl("");
    L11:
        TextView r12 = this.g;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rightTextView");
        r12 = null;
    L14:
        if (r7 == false) goto L16;
        int r14 = 0;
    L17:
        r12.setVisibility(r14);
        TextView r15 = this.g;
        if (r15 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("rightTextView");
        r15 = null;
    L20:
        r15.setEnabled(r5.isEnabled());
        TextView r16 = this.g;
        if (r16 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("rightTextView");
        r16 = null;
    L23:
        if (r8 == false) goto L25;
        float r17 = 1.0f;
    L26:
        r16.setAlpha(r17);
        TextView r18 = this.g;
        if (r18 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("rightTextView");
        r18 = null;
    L29:
        r18.setText(r9);
        TextView r19 = this.g;
        if (r19 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("rightTextView");
        r19 = null;
    L32:
        r19.setTextColor(y9c.d.c(r6, r10));
        if (r13 == false) goto L43;
        CommonTitleBar r110 = this.d;
        if (r110 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
    L39:
        if (r2.e == false) goto L41;
        r1.setLeftTextOnly(CommonTitleBarConstants.TEXT_CANCEL);
        return;
    L41:
        r1.setLeftText("");
        r1.setLeftImageResource(CommonTitleBarConstants.ICON_CLOSE);
        return;
    L37:
        r1 = r110;
        goto L39
    L43:
        return;
    L25:
        r17 = 0.6f;
        goto L26
    L16:
        r14 = 8;
        goto L17
    }

    public final void onActivityCreated(Bundle r41) {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onActivityCreated(r41);
        Log.i("NewForward", "fragment on activity created");
        this.k = new com.ss.android.lark.forwardv3.plugins.f(this);
        this.h = new RecentForwardAdapterV3(requireContext(), this.r, this.s);
        Bundle r2 = getArguments();
        if (r2 == null) goto L5;
        ForwardTemplateNew r3 = (ForwardTemplateNew) r2.getParcelable("key_intent_forward_template_new");
    L6:
        Bundle r4 = getArguments();
        if (r4 == null) goto L9;
        long r5 = r4.getLong("activity_start_time");
    L10:
        this.o = r5;
        if (r3 == null) goto L383;
        this.p = r3;
        com.ss.android.lark.forwardv3.plugins.f r6 = this.k;
        if (r6 == null) goto L22;
        IForwardContent r7 = r3.getForwardContent();
        if ((r7 instanceof com.ss.android.lark.forwardv3.plugins.h) == false) goto L17;
        com.ss.android.lark.forwardv3.plugins.h r8 = (com.ss.android.lark.forwardv3.plugins.h) r7;
    L18:
        if (r8 == null) goto L22;
        com.ss.android.lark.forwardv3.doubao.b r9 = r8.a(r6.a);
        if (r9 == null) goto L22;
        r6.c("doubao_forward_session_plugin", r9);
        goto L22
    L17:
        r8 = null;
    L22:
        Log.i("NewForward", "init view model");
        boolean r10 = com.ss.android.lark.forwardv3.utils.b.a("core.forward.view_model_owner_fragment", false);
        Log.i("FGUtils", "FG key: core.forward.view_model_owner_fragment: " + r10);
        if ((!r10) == false) goto L25;
        ForwardNewFragment r11 = this;
    L26:
        ForwardV3ViewModel r12 = (ForwardV3ViewModel) new ViewModelProvider(r11, new ForwardV3ViewModelFactory(r3)).get(ForwardV3ViewModel.class);
        this.f = r12;
        if (r12 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r12 = null;
    L29:
        r12.init();
        d r13 = new d(this);
        boolean r14 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("lark.message_forward_doubao.main");
        Log.i("FGUtils", "FG key: lark.message_forward_doubao.main: " + r14);
        if (r14 == true) goto L35;
        ForwardV3ViewModel r15 = this.f;
        if (r15 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r15 = null;
    L34:
        z r16 = new y(r15, r13);
    L54:
        this.l = r16;
        ForwardTemplateNew.CREATOR.getClass();
        StringBuilder r17 = new StringBuilder();
        StringBuilder r18 = new StringBuilder("   ForwardTargetConfig is:");
        ForwardTargetConfig.b r19 = ForwardTargetConfig.CREATOR;
        ForwardTargetConfig r110 = r3.getForwardTargetConfig();
        r19.getClass();
        StringBuilder r111 = new StringBuilder();
        if (r110 != null) goto L57;
        r111.append(" forward target config is null\n");
        StringBuilder r20 = r111;
        char r0 = '\n';
    L190:
        r18.append(r20.toString());
        r18.append(r0);
        r17.append(r18.toString());
        StringBuilder r1 = new StringBuilder("   ForwardSelectConfig is:");
        ForwardSelectConfig.b r21 = ForwardSelectConfig.CREATOR;
        ForwardSelectConfig r22 = r3.getForwardSelectConfig();
        r21.getClass();
        StringBuilder r23 = new StringBuilder();
        if (r22 != null) goto L193;
        r23.append(" forward select config is null\n");
    L198:
        r1.append(r23.toString());
        r1.append('\n');
        r17.append(r1.toString());
        StringBuilder r24 = new StringBuilder("   ForwardCommonConfig is:");
        ForwardCommonConfig.b r25 = ForwardCommonConfig.CREATOR;
        ForwardCommonConfig r26 = r3.getForwardCommonConfig();
        r25.getClass();
        StringBuilder r27 = new StringBuilder();
        if (r26 != null) goto L201;
        r27.append(" forward common config is null\n");
        char r28 = '\n';
    L210:
        r24.append(r27.toString());
        r24.append(r28);
        r17.append(r24.toString());
        StringBuilder r29 = new StringBuilder("   ForwardAdditionNoteConfig is:");
        ForwardAdditionNoteConfig.b r30 = ForwardAdditionNoteConfig.CREATOR;
        ForwardAdditionNoteConfig r31 = r3.getForwardAdditionNoteConfig();
        r30.getClass();
        StringBuilder r32 = new StringBuilder();
        if (r31 != null) goto L213;
        r32.append(" forward addition note config is null\n");
        char r33 = '\n';
    L218:
        r29.append(r32.toString());
        r29.append(r33);
        r17.append(r29.toString());
        StringBuilder r34 = new StringBuilder("   ForwardConfirmDialogConfig is:");
        ForwardConfirmDialogConfig.b r35 = ForwardConfirmDialogConfig.CREATOR;
        ForwardConfirmDialogConfig r36 = r3.getForwardConfirmDialogConfig();
        r35.getClass();
        StringBuilder r37 = new StringBuilder();
        if (r36 != null) goto L221;
        r37.append(" forward confirm dialog config is null\n");
        char r38 = '\n';
    L230:
        r34.append(r37.toString());
        r34.append(r38);
        r17.append(r34.toString());
        StringBuilder r39 = new StringBuilder("   has forwardContent ");
        if (r3.getForwardContent() == null) goto L233;
        boolean r40 = true;
    L234:
        r39.append(r40);
        r39.append(r38);
        r17.append(r39.toString());
        StringBuilder r42 = new StringBuilder("   forward type is: ");
        Forward$Type.a r43 = Forward$Type.Companion;
        int r44 = r3.getType();
        r43.getClass();
        r42.append(Forward$Type.a.a(r44));
        r42.append(r38);
        r17.append(r42.toString());
        Log.i("NewForward", r17.toString());
        Log.i("NewForward", "init title bar");
        View r45 = this.d;
        if (r45 != null) goto L237;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r45 = null;
    L237:
        ForwardV3ViewModel r46 = this.f;
        if (r46 != null) goto L241;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r46 = null;
    L241:
        if (r46.getShowTitleBar() == false) goto L243;
        int r47 = 0;
    L244:
        r45.setVisibility(r47);
        CommonTitleBar r48 = this.d;
        if (r48 != null) goto L247;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r48 = null;
    L247:
        r48.setMainTitleColor(y9c.d.c(com.larksuite.framework.utils.b.a, 2131106622));
        CommonTitleBar r49 = this.d;
        if (r49 != null) goto L250;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r49 = null;
    L250:
        ForwardV3ViewModel r50 = this.f;
        if (r50 != null) goto L253;
        Intrinsics.throwUninitializedPropertyAccessException(r8);
        r50 = null;
    L253:
        String r51 = r50.getTitleBarText();
        if (r51.length() != 0) goto L256;
        boolean r52 = true;
    L257:
        if (r52 == false) goto L259;
        r51 = UIUtils.getString(com.larksuite.framework.utils.b.a, 2131892188);
    L259:
        r49.setTitle(r51);
        ForwardV3ViewModel r53 = this.f;
        if (r53 != null) goto L262;
        Intrinsics.throwUninitializedPropertyAccessException(r8);
        r53 = null;
    L262:
        com.ss.android.lark.forwardv3.data.a r54 = r53.getTitleBarShowInfo();
        StringBuilder r55 = new StringBuilder("init state: + ");
        int r56 = com.ss.android.lark.forwardv3.data.a.g;
        r55.append(com.ss.android.lark.forwardv3.data.a.C0072a.a(r54));
        Log.i("NewForward", r55.toString());
        CommonTitleBar r57 = this.d;
        if (r57 != null) goto L265;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r57 = null;
    L265:
        r57.setLeftClickListener(new s(this));
        CommonTitleBar r58 = this.d;
        if (r58 != null) goto L268;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r58 = null;
    L268:
        r58.addAction(new t(this, r54.c));
        CommonTitleBar r59 = this.d;
        if (r59 != null) goto L271;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r59 = null;
    L271:
        this.g = r59.getRightText();
        CommonTitleBar r60 = this.d;
        if (r60 != null) goto L274;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r60 = null;
    L274:
        r60.setImmersive(true);
        ea0(true);
        Log.i("NewForward", "init chat picker");
        WeakReference<Message> r61 = ForwardDataUtils.a;
        com.ss.android.lark.forwardv3.utils.b.d();
        String r62 = UIHelper.getString(2131891132);
        Intrinsics.checkNotNull(r62);
        ForwardDataUtils.d = r62;
        o r63 = new o(this);
        q r64 = new q(this);
        n r65 = new n(this);
        ForwardV3ViewModel r66 = this.f;
        if (r66 != null) goto L277;
        Intrinsics.throwUninitializedPropertyAccessException(r8);
        r66 = null;
    L277:
        ConfigUtils.b r67 = r66.getSearchPickerParams();
        int r68 = ConfigUtils.b.g;
        StringBuilder r69 = new StringBuilder();
        if (r67 != null) goto L280;
        r69.append(" searchPickerParams is null\n");
    L281:
        Log.i("NewForward", r69.toString());
        m r70 = new m(this);
        p r71 = new p(this);
        boolean r72 = com.ss.android.lark.forwardv3.utils.b.a("im.forward.disabledoubaosearch", false);
        Log.i("FGUtils", "FG key: im.forward.disabledoubaosearch: " + r72);
        if (r72 == true) goto L287;
        ForwardV3ViewModel r73 = this.f;
        if (r73 != null) goto L286;
        Intrinsics.throwUninitializedPropertyAccessException(r8);
        r73 = null;
    L286:
        com.ss.android.lark.forwardv3.doubao.d r74 = DoubaoWorkSearchResultAdapterKt.a(r73.getEnableExternalTarget(), Y90(), ForwardModuleV3.a());
    L288:
        tib.e r75 = this.e;
        if (r75 != null) goto L291;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
        r75 = null;
    L291:
        ForwardV3ViewModel r112 = this.f;
        if (r112 != null) goto L295;
        Intrinsics.throwUninitializedPropertyAccessException(r8);
        r112 = null;
    L295:
        if (r112.getSource() != Forward$Source.KNOWLEDGE_AI) goto L297;
        String r113 = "knoai_profile_share";
    L298:
        String r210 = r113;
        List r211 = Collections.singletonList(ActionType.SHARE_MESSAGE_SELECT_USER);
        ForwardV3ViewModel r114 = this.f;
        if (r114 != null) goto L301;
        Intrinsics.throwUninitializedPropertyAccessException(r8);
        r114 = null;
    L301:
        boolean r115 = !r114.getDefaultSingleSelectMode();
        ForwardV3ViewModel r116 = this.f;
        if (r116 != null) goto L304;
        Intrinsics.throwUninitializedPropertyAccessException(r8);
        r116 = null;
    L304:
        boolean r117 = r116.getEnableChatPreview();
        ForwardTemplateNew r118 = this.p;
        if (r118 != null) goto L307;
        Intrinsics.throwUninitializedPropertyAccessException("forwardTemplateNew");
        r118 = null;
    L307:
        IncludeConfig r119 = r118.getForwardTargetConfig().d;
        ForwardV3ViewModel r120 = this.f;
        if (r120 != null) goto L310;
        Intrinsics.throwUninitializedPropertyAccessException(r8);
        r120 = null;
    L310:
        boolean r310 = r120.getEnableExternalTarget();
        tib.e r311 = r75;
        tib.d r121 = new tib.d(r67.a, r67.b, r67.c, r67.d, r67.e, r67.f);
        if (r74 == null) goto L313;
        Boolean r312 = Boolean.valueOf(r74.a);
    L314:
        if (r74 == null) goto L316;
        SearchResultAdapter r313 = r74.b;
    L317:
        r311.g(new tib.b(r210, r211, Boolean.valueOf(r115), Boolean.valueOf(r117), Boolean.TRUE, r64, r63, r65, r121, r119, r310, r70, r71, null, r312, r313, 1197104));
        tib.e r76 = this.e;
        if (r76 != null) goto L320;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
        r76 = null;
    L320:
        r76.e();
        ForwardV3ViewModel r77 = this.f;
        if (r77 != null) goto L324;
        Intrinsics.throwUninitializedPropertyAccessException(r8);
        r77 = null;
    L324:
        if (r77.getEnableCreateGroupChat() == false) goto L340;
        String r78 = "NewForward";
        Log.i(r78, "enable create group chat");
        View r79 = View.inflate(getContext(), 2131568150, null);
        boolean r80 = com.ss.android.lark.forwardv3.utils.b.a("core.forward.create_group_chat_with_filter", false);
        Log.i("FGUtils", "FG key: lark.forward.create_group_chat_with_filter, is " + r80);
        if (r80 == false) goto L335;
        com.ss.android.lark.forwardv3.plugins.f r81 = this.k;
        if (r81 == null) goto L336;
        ForwardTemplateNew r82 = this.p;
        if (r82 != null) goto L332;
        Intrinsics.throwUninitializedPropertyAccessException("forwardTemplateNew");
        r82 = null;
    L332:
        r81.c("forward_plugin_crate_group_chat", new ForwardCreateGroupChatPlugin(r82, new j(this)));
        com.ss.android.lark.forwardv3.plugins.i r83 = r81.b("forward_plugin_crate_group_chat");
        if (r83 == null) goto L336;
        FragmentActivity r84 = getActivity();
        Intrinsics.checkNotNull(r79);
        r83.b(r84, this, r79);
    L336:
        tib.e r85 = this.e;
        if (r85 != null) goto L339;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
        r85 = null;
    L339:
        r85.g(new tib.b(null, null, null, null, null, null, null, null, null, null, false, null, null, r79, null, null, 1966079));
    L341:
        ForwardV3ViewModel r86 = this.f;
        if (r86 != null) goto L345;
        Intrinsics.throwUninitializedPropertyAccessException(r8);
        r86 = null;
    L345:
        if (r86.getEnableRecentForward() == false) goto L350;
        Log.i(r78, "enable recent forward");
        l r87 = new l(this);
        tib.e r88 = this.e;
        if (r88 != null) goto L349;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
        r88 = null;
    L349:
        r88.setCustomBinder(r87);
    L351:
        ForwardV3ViewModel r89 = this.f;
        if (r89 != null) goto L354;
        Intrinsics.throwUninitializedPropertyAccessException(r8);
        r89 = null;
    L354:
        r89.getSelectMode().observe(getViewLifecycleOwner(), new u(this));
        ForwardV3ViewModel r90 = this.f;
        if (r90 != null) goto L357;
        Intrinsics.throwUninitializedPropertyAccessException(r8);
        r90 = null;
    L357:
        r90.getSelectedItem().observe(getViewLifecycleOwner(), new v(this));
        ForwardV3ViewModel r91 = this.f;
        if (r91 != null) goto L360;
        Intrinsics.throwUninitializedPropertyAccessException(r8);
        r91 = null;
    L360:
        r91.getRecommendData().observe(getViewLifecycleOwner(), new w(this));
        ForwardV3ViewModel r92 = this.f;
        if (r92 != null) goto L363;
        Intrinsics.throwUninitializedPropertyAccessException(r8);
        r92 = null;
    L363:
        IForwardContent r93 = r92.getForwardContent();
        if ((r93 instanceof SingleMessageForwardContent) == false) goto L366;
    L371:
        ForwardTemplateNew r94 = null;
        Log.i(r78, "viewModel's forwardContent is forward type");
    L372:
        FragmentActivity r95 = getActivity();
        if (r95 == null) goto L376;
        String r96 = Boolean.valueOf(com.ss.android.lark.ui.component_container.a.e(r95)).toString();
        if (r96 == null) goto L376;
    L377:
        Log.i(r78, "penetrationReport isResponsive:".concat(r96));
        int r97 = zib.e.a;
        ForwardTemplateNew r98 = this.p;
        if (r98 != null) goto L380;
        Intrinsics.throwUninitializedPropertyAccessException("forwardTemplateNew");
    L381:
        boolean r99 = r94.getForwardTargetConfig().b;
        s5c.d.o2.getClass();
        s5c.a r100 = new s5c.a("is_responsive", r96);
        Intrinsics.checkNotNullParameter(r100, "iParam");
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new zib.f(r99, r100));
        return;
    L380:
        r94 = r98;
    L376:
        r96 = "false";
        goto L377
    L366:
        if ((r93 instanceof MergeMessageForwardContent) == true) goto L371;
        if ((r93 instanceof OneByOneMessageForwardContent) == true) goto L371;
        Log.i(r78, "viewModel's forwardContent is share type");
        r94 = null;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass3(this, null), 3, null);
        goto L372
    L350:
        Log.i(r78, "disable recent forward");
        goto L351
    L335:
        r79.setOnClickListener(new k(this));
        goto L336
    L340:
        r78 = "NewForward";
        goto L341
    L316:
        r313 = null;
        goto L317
    L313:
        r312 = null;
        goto L314
    L297:
        r113 = "forward_new";
        goto L298
    L287:
        r74 = null;
        goto L288
    L280:
        r69.append(" searchPickerParams is:\n");
        r69.append("   excludeOuterUser is: " + r67.a + '\n');
        r69.append("   includeOutGroupChat is: " + r67.b + '\n');
        r69.append("   needSearchOuterTenant is: " + r67.c + '\n');
        r69.append("   includeBot is: " + r67.d + '\n');
        r69.append("   includeThread is: " + r67.e + '\n');
        r69.append("   includeAI is: " + r67.f + '\n');
        goto L281
    L256:
        r52 = false;
        goto L257
    L243:
        r47 = 8;
        goto L244
    L233:
        r40 = false;
        goto L234
    L221:
        StringBuilder r101 = new StringBuilder("   titleBarText is: ");
        r101.append(r36.a);
        r38 = '\n';
        r101.append('\n');
        r37.append(r101.toString());
        r37.append("   confirmButtonText is: " + r36.b + '\n');
        r37.append("   cancelButtonText is: " + r36.c + '\n');
        StringBuilder r102 = new StringBuilder("   has customConfirmDialogContentView ");
        if (r36.e == null) goto L224;
        boolean r103 = true;
    L225:
        r102.append(r103);
        r102.append('\n');
        r37.append(r102.toString());
        StringBuilder r104 = new StringBuilder("   has confirmDialogListener is: ");
        if (r36.f == null) goto L228;
        boolean r105 = true;
    L229:
        r104.append(r105);
        r104.append('\n');
        r37.append(r104.toString());
        goto L230
    L228:
        r105 = false;
        goto L229
    L224:
        r103 = false;
        goto L225
    L213:
        StringBuilder r106 = new StringBuilder("   enableAdditionNote is: ");
        r106.append(r31.a);
        r33 = '\n';
        r106.append('\n');
        r32.append(r106.toString());
        r32.append("   enableAdditionNoteAT is: " + r31.b + '\n');
        StringBuilder r107 = new StringBuilder("   has forwardNoteListener ");
        if (r31.c == null) goto L216;
        boolean r108 = true;
    L217:
        r107.append(r108);
        r107.append('\n');
        r32.append(r107.toString());
        goto L218
    L216:
        r108 = false;
        goto L217
    L201:
        StringBuilder r109 = new StringBuilder("   resultCode is: ");
        r109.append(r26.a);
        r28 = '\n';
        r109.append('\n');
        r27.append(r109.toString());
        r27.append("   showTitleBar is: " + r26.b + '\n');
        r27.append("   enableCreateGroupChat is: " + r26.c + '\n');
        r27.append("   enableRecentForward is: " + r26.d + '\n');
        r27.append("   enableBackOriginalApplication is: " + r26.f + '\n');
        StringBuilder r122 = new StringBuilder("   has onCloseForwardListener ");
        if (r26.g == null) goto L204;
        boolean r123 = true;
    L205:
        r122.append(r123);
        r122.append('\n');
        r27.append(r122.toString());
        StringBuilder r124 = new StringBuilder("   has forwardContentListener ");
        if (r26.i == null) goto L208;
        boolean r125 = true;
    L209:
        r124.append(r125);
        r124.append('\n');
        r27.append(r124.toString());
        goto L210
    L208:
        r125 = false;
        goto L209
    L204:
        r123 = false;
        goto L205
    L193:
        r23.append(" forward select config is:\n");
        r23.append("   enableSwitchSelectMode is: " + r22.a + '\n');
        r23.append("   defaultSingleSelectMode is: " + r22.b + '\n');
        r23.append("   maxLimitSelectNum is: " + r22.c + '\n');
        StringBuilder r126 = new StringBuilder("   has cancelMultiSelectListener ");
        if (r22.d == null) goto L196;
        boolean r127 = true;
    L197:
        r126.append(r127);
        r23.append(r126.toString());
        goto L198
    L196:
        r127 = false;
        goto L197
    L57:
        r111.append(" forward target config is:\n");
        r111.append("   enableChatPreview: " + r110.a + '\n');
        r111.append("   enableAiKnowledge: " + r110.b + '\n');
        r111.append("   enableExternalTarget: " + r110.c + '\n');
        StringBuilder r128 = new StringBuilder("   ");
        IncludeConfig.b r129 = IncludeConfig.CREATOR;
        IncludeConfig r130 = r110.d;
        r129.getClass();
        StringBuilder r131 = new StringBuilder();
        String r132 = "     tenant is: ";
        String r133 = "   user config:\n";
        if (r130 != null) goto L60;
        r131.append(" include config is null\n");
        String r134 = "   AiConfig:\n";
        String r314 = "     tenant is: ";
    L122:
        r128.append(r131.toString());
        r128.append('\n');
        r111.append(r128.toString());
        StringBuilder r135 = new StringBuilder("   ");
        DisableConfig.b r136 = DisableConfig.CREATOR;
        DisableConfig r137 = r110.e;
        r136.getClass();
        StringBuilder r138 = new StringBuilder();
        if (r137 != null) goto L125;
        r138.append(" disable config is null\n");
    L185:
        r135.append(r138.toString());
        r0 = '\n';
        r135.append('\n');
        r20 = r111;
        r20.append(r135.toString());
        StringBuilder r139 = new StringBuilder("   has customDisableListener: ");
        if (r110.f == null) goto L188;
        boolean r140 = true;
    L189:
        r139.append(r140);
        r139.append('\n');
        r20.append(r139.toString());
        goto L190
    L188:
        r140 = false;
        goto L189
    L125:
        r138.append(" disable config is:\n");
        Iterator r141 = ((ArrayList) r137.a).iterator();
    L127:
        if (r141.hasNext() == false) goto L185;
        EntityItem r142 = (EntityItem) r141.next();
        Iterator r212 = r141;
        if (r142.a == null) goto L145;
        r138.append(r133);
        StringBuilder r143 = new StringBuilder(r314);
        UserConfig r144 = r142.a;
        if (r144 == null) goto L133;
        Condition$Tenant r145 = r144.getTenant();
    L134:
        r143.append(r145);
        r143.append('\n');
        r138.append(r143.toString());
        StringBuilder r146 = new StringBuilder("     userType is: ");
        UserConfig r147 = r142.a;
        if (r147 == null) goto L137;
        Condition$UserType r148 = r147.getUserType();
    L138:
        r146.append(r148);
        r146.append('\n');
        r138.append(r146.toString());
        StringBuilder r149 = new StringBuilder("     shield is: ");
        UserConfig r150 = r142.a;
        if (r150 == null) goto L141;
        Condition$Shield r151 = r150.getShield();
    L142:
        r149.append(r151);
        r149.append('\n');
        r138.append(r149.toString());
        goto L145
    L141:
        r151 = null;
        goto L142
    L137:
        r148 = null;
        goto L138
    L133:
        r145 = null;
    L145:
        if (r142.b == null) goto L164;
        r138.append("   GroupChatConfig:\n");
        StringBuilder r152 = new StringBuilder("     tenant is ");
        GroupConfig r153 = r142.b;
        if (r153 == null) goto L149;
        Condition$Tenant r154 = r153.getTenant();
    L150:
        r152.append(r154);
        r152.append('\n');
        r138.append(r152.toString());
        StringBuilder r155 = new StringBuilder("     groupType is ");
        GroupConfig r156 = r142.b;
        if (r156 == null) goto L153;
        Condition$GroupType r157 = r156.getGroupType();
    L154:
        r155.append(r157);
        r155.append('\n');
        r138.append(r155.toString());
        StringBuilder r158 = new StringBuilder("     status is ");
        GroupConfig r159 = r142.b;
        if (r159 == null) goto L157;
        Condition$Status r160 = r159.getStatus();
    L158:
        r158.append(r160);
        r158.append('\n');
        r138.append(r158.toString());
        StringBuilder r161 = new StringBuilder("     shield is ");
        GroupConfig r162 = r142.b;
        if (r162 == null) goto L161;
        Condition$Shield r163 = r162.getShield();
    L162:
        r161.append(r163);
        r161.append(" \n");
        r138.append(r161.toString());
        goto L164
    L161:
        r163 = null;
        goto L162
    L157:
        r160 = null;
        goto L158
    L153:
        r157 = null;
        goto L154
    L149:
        r154 = null;
    L164:
        if (r142.d == null) goto L179;
        r138.append("   ThreadConfig:\n");
        StringBuilder r164 = new StringBuilder("     tenant is ");
        ThreadConfig r165 = r142.d;
        if (r165 == null) goto L168;
        Condition$Tenant r166 = r165.getTenant();
    L169:
        r164.append(r166);
        r164.append('\n');
        r138.append(r164.toString());
        StringBuilder r167 = new StringBuilder("     status is ");
        ThreadConfig r168 = r142.d;
        if (r168 == null) goto L172;
        Condition$Status r169 = r168.getStatus();
    L173:
        r167.append(r169);
        r167.append('\n');
        r138.append(r167.toString());
        StringBuilder r170 = new StringBuilder("     threadType is ");
        ThreadConfig r171 = r142.d;
        if (r171 == null) goto L176;
        Condition$ThreadType r172 = r171.getThreadType();
    L177:
        r170.append(r172);
        r170.append(" \n");
        r138.append(r170.toString());
        goto L179
    L176:
        r172 = null;
        goto L177
    L172:
        r169 = null;
        goto L173
    L168:
        r166 = null;
    L179:
        if (r142.c == null) goto L182;
        r138.append("   BotConfig:\n");
    L182:
        if (r142.e == null) goto L184;
        r138.append(r134);
    L184:
        r141 = r212;
        r133 = r133;
        goto L127
    L60:
        String r213 = "   AiConfig:\n";
        r131.append(" include config is:\n");
        Iterator r173 = ((ArrayList) r130.a).iterator();
    L62:
        if (r173.hasNext() == false) goto L121;
        EntityItem r174 = (EntityItem) r173.next();
        Iterator r214 = r173;
        if (r174.a == null) goto L80;
        r131.append("   user config:\n");
        StringBuilder r175 = new StringBuilder(r132);
        UserConfig r176 = r174.a;
        if (r176 == null) goto L68;
        Condition$Tenant r177 = r176.getTenant();
    L69:
        r175.append(r177);
        r175.append('\n');
        r131.append(r175.toString());
        StringBuilder r178 = new StringBuilder("     userType is: ");
        UserConfig r179 = r174.a;
        if (r179 == null) goto L72;
        Condition$UserType r180 = r179.getUserType();
    L73:
        r178.append(r180);
        r178.append('\n');
        r131.append(r178.toString());
        StringBuilder r181 = new StringBuilder("     shield is: ");
        UserConfig r182 = r174.a;
        if (r182 == null) goto L76;
        Condition$Shield r183 = r182.getShield();
    L77:
        r181.append(r183);
        r181.append('\n');
        r131.append(r181.toString());
        goto L80
    L76:
        r183 = null;
        goto L77
    L72:
        r180 = null;
        goto L73
    L68:
        r177 = null;
    L80:
        if (r174.b == null) goto L99;
        r131.append("   GroupChatConfig:\n");
        StringBuilder r184 = new StringBuilder("     tenant is ");
        GroupConfig r185 = r174.b;
        if (r185 == null) goto L84;
        Condition$Tenant r186 = r185.getTenant();
    L85:
        r184.append(r186);
        r184.append('\n');
        r131.append(r184.toString());
        StringBuilder r187 = new StringBuilder("     groupType is ");
        GroupConfig r188 = r174.b;
        if (r188 == null) goto L88;
        Condition$GroupType r189 = r188.getGroupType();
    L89:
        r187.append(r189);
        r187.append('\n');
        r131.append(r187.toString());
        StringBuilder r190 = new StringBuilder("     status is ");
        GroupConfig r191 = r174.b;
        if (r191 == null) goto L92;
        Condition$Status r192 = r191.getStatus();
    L93:
        r190.append(r192);
        r190.append('\n');
        r131.append(r190.toString());
        StringBuilder r193 = new StringBuilder("     shield is ");
        GroupConfig r194 = r174.b;
        if (r194 == null) goto L96;
        Condition$Shield r195 = r194.getShield();
    L97:
        r193.append(r195);
        r193.append(" \n");
        r131.append(r193.toString());
        goto L99
    L96:
        r195 = null;
        goto L97
    L92:
        r192 = null;
        goto L93
    L88:
        r189 = null;
        goto L89
    L84:
        r186 = null;
    L99:
        if (r174.d == null) goto L114;
        r131.append("   ThreadConfig:\n");
        StringBuilder r196 = new StringBuilder("     tenant is ");
        ThreadConfig r197 = r174.d;
        if (r197 == null) goto L103;
        Condition$Tenant r198 = r197.getTenant();
    L104:
        r196.append(r198);
        r196.append('\n');
        r131.append(r196.toString());
        StringBuilder r199 = new StringBuilder("     status is ");
        ThreadConfig r200 = r174.d;
        if (r200 == null) goto L107;
        Condition$Status r201 = r200.getStatus();
    L108:
        r199.append(r201);
        r199.append('\n');
        r131.append(r199.toString());
        StringBuilder r202 = new StringBuilder("     threadType is ");
        ThreadConfig r203 = r174.d;
        if (r203 == null) goto L111;
        Condition$ThreadType r204 = r203.getThreadType();
    L112:
        r202.append(r204);
        r202.append(" \n");
        r131.append(r202.toString());
        goto L114
    L111:
        r204 = null;
        goto L112
    L107:
        r201 = null;
        goto L108
    L103:
        r198 = null;
    L114:
        if (r174.c == null) goto L117;
        r131.append("   BotConfig:\n");
    L117:
        if (r174.e == null) goto L119;
        String r205 = r213;
        r131.append(r205);
    L120:
        r213 = r205;
        r173 = r214;
        r132 = r132;
        goto L62
    L119:
        r205 = r213;
        goto L120
    L121:
        r314 = r132;
        r134 = r213;
        goto L122
    L35:
        ExternalForwardSendMode r206 = Y90();
        ExternalForwardSendMode r1100 = ExternalForwardSendMode.DOUBAO_ENTRY;
        if (r206 != r1100) goto L41;
        ForwardV3ViewModel r1101 = this.f;
        if (r1101 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1101 = null;
    L40:
        r16 = new ExternalForwardSendHelper(r1101, r13, r1100);
        goto L54
    L41:
        ForwardV3ViewModel r207 = this.f;
        if (r207 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r207 = null;
    L45:
        if (r207.getEnableExternalTarget() == false) goto L50;
        ForwardV3ViewModel r1102 = this.f;
        if (r1102 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1102 = null;
    L49:
        r16 = new ExternalForwardSendHelper(r1102, r13, ExternalForwardSendMode.MIXED_EXTERNAL_TARGET);
        goto L54
    L50:
        ForwardV3ViewModel r1103 = this.f;
        if (r1103 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1103 = null;
    L53:
        r16 = new y(r1103, r13);
        goto L54
    L25:
        r11 = ((sua.a) ApiUtils.getApi(sua.a.class)).getFragmentLifecycleOwnerInForseti(requireActivity(), this);
        goto L26
    L383:
        Log.e("NewForward", "new template is null");
        zab.a.a(this);
        return;
    L9:
        r5 = 0;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        Log.i("NewForward", "on configuration changed, notify update RecentForwardAdapter");
        RecyclerView.Adapter r3 = this.h;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recentForwardAdapter");
        r3 = null;
    L5:
        r3.notifyDataSetChanged();
    }

    public static final boolean S90(ForwardNewFragment r8, SearchBaseInfo r9) {
        r8.getClass();
        StringBuilder r0 = new StringBuilder();
        r0.append("data id: " + r9.getId() + ", type: " + SearchCommonConstants.a(r9.getType()) + '\n');
        ForwardV3ViewModel r1 = r8.f;
        ForwardV3ViewModel r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L5:
        boolean r4 = false;
        if (x.b(r9, r1) == false) goto L54;
        r0.append("consume: true, because:\n");
        ForwardV3ViewModel r3 = r8.f;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L11:
        if (r3.isExternalTargetDisabledByMessageCount(r9) == false) goto L25;
        r0.append("external target message count exceeds limit\n");
        zib.m r10 = zib.m.a;
        MergeForwardLimitFrom r5 = MergeForwardLimitFrom.LARK_TO_DOUBAO;
        ForwardV3ViewModel r7 = r8.f;
        if (r7 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        int r6 = com.ss.android.lark.forwardv3.doubao.f.a(r2.getForwardContent());
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "from");
        Intrinsics.checkNotNullParameter(r5, "from");
        Map r11 = MapsKt.mapOf(new Pair[]{TuplesKt.to("from", r5.getValue()), TuplesKt.to("intercept_reason", "select_count_limit"), TuplesKt.to("select_count", Integer.valueOf(r6))});
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L19
        Statistics.sendEvent("im_msg_merge_forward_limit_intercept", new JSONObject(r11));     // Catch: Throwable -> L19
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L24;
        Log.e("MergeForwardLimitHitPoint", "send merge forward limit intercept event failed", r14);
    L24:
        Context r15 = r8.requireContext();
        yib.c.a.getClass();
        UDToast.show(r15, UIHelper.mustacheFormat(2131891058, "num", String.valueOf(yib.c.a())));
    L53:
        r4 = true;
    L19:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L15:
        r2 = r7;
        goto L16
    L25:
        ForwardV3ViewModel r17 = r8.f;
        if (r17 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r17 = null;
    L29:
        if (x.a(r9, r17) == false) goto L35;
        r0.append("exceed limit\n");
        Context r18 = r8.requireContext();
        ForwardV3ViewModel r19 = r8.f;
        if (r19 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L34:
        UDToast.show(r18, y9c.d.j(2131892185, "select_count", String.valueOf(r2.getMaxLimitSelectNum())));
        goto L53
    L33:
        r2 = r19;
        goto L34
    L35:
        ForwardV3ViewModel r20 = r8.f;
        if (r20 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r20 = null;
    L39:
        if (r20.disable(r9) == false) goto L41;
        r0.append("is disabled\n");
        UDToast.show(r8.requireContext(), y9c.d.h(2131892225));
        goto L53
    L41:
        ForwardV3ViewModel r21 = r8.f;
        if (r21 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r21 = null;
    L45:
        if (r21.customDisable(r9) == false) goto L53;
        r0.append("custom disable\n");
        ForwardV3ViewModel r22 = r8.f;
        if (r22 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L50:
        String r23 = r2.customDisableToastText();
        if (TextUtils.isEmpty(r23) == true) goto L53;
        UDToast.show(r8.requireContext(), r23);
        goto L53
    L49:
        r2 = r22;
    L54:
        r0.append("consume: false\n");
        Log.i("NewForward", r0.toString());
        return r4;
    }

    public static final void T90(ForwardNewFragment r4, ErrorResult r5) {
        r4.getClass();
        UICallbackExecutor.post(com.ss.android.lark.forwardv3.d.a);
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = y9c.d.h(2131891584);
        if ((r5 instanceof ForwardErrorResultV3) == true) goto L5;
        UICallbackExecutor.execute(new com.ss.android.lark.forwardv3.e(r4, r5, r0));
        return;
    L5:
        ForwardErrorResultV3 r2 = (ForwardErrorResultV3) r5;
        if (TextUtils.isEmpty(r2.getMessage()) == true) goto L8;
        String r1 = r2.getMessage();
    L9:
        r0.element = r1;
        if (r2.isIsDialog() == false) goto L12;
        UICallbackExecutor.execute(new com.ss.android.lark.forwardv3.f(r4, r2, r0));
        return;
    L12:
        UICallbackExecutor.execute(new g(r4, r5, r0, r2));
        return;
    L8:
        r1 = y9c.d.h(2131891584);
        goto L9
    }

    public static final void V90(ForwardNewFragment r2, ErrorResult r3) {
        r2.getClass();
        if (r3 != null) goto L5;
        r3 = new ErrorResult(-1011, "create_p2p_chat_error");
    L5:
        Log.e("NewForward", "create_p2p_chat_error");
        boolean r1 = zib.b.d;
        Forward$Type.a r4 = Forward$Type.Companion;
        ForwardTemplateNew r5 = r2.p;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("forwardTemplateNew");
        r5 = null;
    L8:
        int r6 = r5.getType();
        r4.getClass();
        zib.b.d(Forward$Type.a.a(r6), r3.getCode(), r3.getDebugMsg(), "create_p2p_chat_error");
    }

    public final void X90(Integer r4, Bundle r5) {
        s5c.a r0 = r.h;
        s5c.h r1 = s5c.h.a;
        int r2 = zib.e.a;
        r0.getClass();
        zib.e.a.c(s5c.d.b.b(r0, r1));
        if (ForsetiFGHelpers.d() == false) goto L8;
        int r3 = com.ss.android.lark.forwardv3.utils.n.a;
        if (com.ss.android.lark.forwardv3.utils.n.f(getContext()) == true) goto L8;
        boolean r6 = false;
    L9:
        if (r6 == false) goto L13;
        if (r4 == null) goto L13;
        if (r5 == null) goto L13;
        zab.a.b(this, r4.intValue(), r5);
        return;
    L13:
        if (r6 == false) goto L15;
        zab.a.a(this);
        return;
    L15:
        if (r5 == null) goto L17;
        Intent r7 = new Intent();
        r7.putExtras(r5);
    L18:
        FragmentActivity r8 = getActivity();
        if (r8 == null) goto L24;
        com.ss.android.lark.ui.component_container.a.c(r8, r7);
        return;
    L24:
        return;
    L17:
        r7 = null;
    L8:
        r6 = true;
        goto L9
    }

    public final void ca0(List<? extends SearchBaseInfo> r22, String r23) {
        Log.i("NewForward", "show confirm forward dialog");
        this.j = TextUtils.equals(r23, "from_create_group_chat");
        Context r2 = getContext();
        if (r2 != null) goto L5;
        return;
    L5:
        s5c.a r3 = z2.g;
        if (Intrinsics.areEqual(r23, r3.b) == false) goto L8;
        s5c.a r4 = r3;
    L9:
        int r0 = zib.e.a;
        Intrinsics.checkNotNullParameter(r4, "param");
        Statistics.sendEvent("im_msg_send_confirm_view", r4.plus(ChatParamUtils.e()).toJson());
        if (Y90() == ExternalForwardSendMode.DOUBAO_ENTRY) goto L34;
        ForwardV3ViewModel r1 = this.f;
        if (r1 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L15:
        if (r1.getEnableExternalTarget() == false) goto L34;
        String r5 = ForwardModuleV3.a().getExternalTargetId();
        if (r5 != null) goto L20;
    L23:
        boolean r6 = true;
    L24:
        if (r6 == false) goto L26;
        Log.w("NewForward", "build confirm target groups skip external split: externalTargetId is empty");
        b r7 = new b(r22, CollectionsKt.emptyList());
    L35:
        b r8 = r7;
    L36:
        ForwardV3ViewModel r9 = this.f;
        if (r9 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r9 = null;
    L40:
        if (r9.getEnableAdditionNote() == false) goto L50;
        ForwardV3ViewModel r10 = this.f;
        if (r10 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r10 = null;
    L45:
        if (r10.getEnableAdditionNoteAT() == false) goto L50;
        com.ss.android.lark.forwardv3.plugins.f r11 = this.k;
        if (r11 != null) goto L49;
        r11 = new com.ss.android.lark.forwardv3.plugins.f(this);
    L49:
        r11.c("forward_at_plugin", new ForwardAtPlugin(new com.ss.android.lark.forwardv3.plugins.a(this, new f(r8))));
    L50:
        ForwardNewFragment$showConfirmForwardDialog$onDialogListener$1 r14 = new ForwardNewFragment$showConfirmForwardDialog$onDialogListener$1(r2, this, r22, r4, r8);
        FragmentActivity r12 = getActivity();
        if (r12 == null) goto L167;
        ForwardV3ViewModel r13 = this.f;
        if (r13 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r13 = null;
    L56:
        if (r13.getSource() == Forward$Source.MY_AI) goto L112;
        ForwardV3ViewModel r15 = this.f;
        if (r15 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r15 = null;
    L61:
        if (r15.getSource() == Forward$Source.KNOWLEDGE_AI) goto L112;
        int r16 = com.ss.android.lark.forwardv3.utils.n.a;
        if (com.ss.android.lark.forwardv3.utils.n.f(getActivity()) == true) goto L112;
        ForwardV3ViewModel r17 = this.f;
        if (r17 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r17 = null;
    L68:
        String r18 = r17.getDialogTitleBarText();
        ForwardV3ViewModel r19 = this.f;
        if (r19 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r19 = null;
    L71:
        String r20 = r19.getConfirmButtonText();
        if (StringsKt.isBlank(r20) == false) goto L83;
        ForwardV3ViewModel r21 = this.f;
        if (r21 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r21 = null;
    L76:
        Integer r24 = (Integer) r21.getSelectMode().getValue();
        if (r24 != null) goto L80;
    L82:
        r20 = y9c.d.i(com.larksuite.framework.utils.b.a, 2131892196);
        goto L83
    L80:
        if (r24.intValue() != 1) goto L82;
        r20 = y9c.d.j(2131891134, "num", String.valueOf(r22.size()));
    L83:
        ForwardV3ViewModel r25 = this.f;
        if (r25 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r25 = null;
    L86:
        String r26 = r25.getCancelButtonText();
        if (StringsKt.isBlank(r26) == false) goto L89;
        r26 = y9c.d.i(com.larksuite.framework.utils.b.a, 2131891541);
    L89:
        ForwardV3ViewModel r27 = this.f;
        if (r27 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r27 = null;
    L92:
        boolean r110 = r27.getEnableAdditionNote();
        ForwardV3ViewModel r28 = this.f;
        if (r28 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r28 = null;
    L95:
        boolean r111 = r28.getEnableChatPreview();
        ForwardV3ViewModel r29 = this.f;
        if (r29 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r29 = null;
    L98:
        OnCustomForwardConfirmDialogContentView r30 = r29.getCustomConfirmDialogContentView();
        if (r30 == null) goto L101;
        boolean r112 = r30.n1();
    L102:
        com.ss.android.lark.forwardv3.plugins.f r31 = this.k;
        if (r31 != null) goto L105;
        r31 = new com.ss.android.lark.forwardv3.plugins.f(this);
    L105:
        com.ss.android.lark.forwardv3.plugins.f r32 = r31;
        Intrinsics.checkNotNullParameter(r12, "activity");
        Intrinsics.checkNotNullParameter(r18, "titleBarText");
        Intrinsics.checkNotNullParameter(r20, "confirmButtonText");
        Intrinsics.checkNotNullParameter(r26, "cancelButtonText");
        Intrinsics.checkNotNullParameter(r22, "items");
        Intrinsics.checkNotNullParameter(r14, "onDialogListener");
        Intrinsics.checkNotNullParameter(r32, "forwardPluginManager");
        UDDialog r33 = com.ss.android.lark.forwardv3.utils.n.e(r12, r18, r20, r26, r110, r111, r22, r14, r112, r32);
        if (r33 != null) goto L108;
        return;
    L108:
        if (DialogLancet.shouldBlockDialogShow(r33) == false) goto L159;
        DialogLancet.handleBlockedDialogShow(r33);
        return;
    L159:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L158
    L111:
        DialogLancet.beforeDialogShow(r33);
        r33.show();
        DialogLancet.afterDialogShow(r33);
        return;
    L101:
        r112 = false;
    L112:
        int r34 = com.ss.android.lark.forwardv3.utils.n.a;
        ForwardV3ViewModel r35 = this.f;
        if (r35 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r35 = null;
    L115:
        String r36 = r35.getDialogTitleBarText();
        ForwardV3ViewModel r37 = this.f;
        if (r37 != null) goto L118;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r37 = null;
    L118:
        String r38 = r37.getConfirmButtonText();
        if (StringsKt.isBlank(r38) == false) goto L130;
        ForwardV3ViewModel r39 = this.f;
        if (r39 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r39 = null;
    L123:
        Integer r40 = (Integer) r39.getSelectMode().getValue();
        if (r40 != null) goto L127;
    L129:
        r38 = y9c.d.i(com.larksuite.framework.utils.b.a, 2131892196);
        goto L130
    L127:
        if (r40.intValue() != 1) goto L129;
        r38 = y9c.d.j(2131891134, "num", String.valueOf(r22.size()));
    L130:
        ForwardV3ViewModel r41 = this.f;
        if (r41 != null) goto L133;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r41 = null;
    L133:
        String r42 = r41.getCancelButtonText();
        if (StringsKt.isBlank(r42) == false) goto L136;
        r42 = y9c.d.i(com.larksuite.framework.utils.b.a, 2131891541);
    L136:
        ForwardV3ViewModel r43 = this.f;
        if (r43 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r43 = null;
    L139:
        boolean r113 = r43.getEnableAdditionNote();
        ForwardV3ViewModel r44 = this.f;
        if (r44 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r44 = null;
    L142:
        boolean r114 = r44.getEnableChatPreview();
        ForwardV3ViewModel r45 = this.f;
        if (r45 != null) goto L145;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r45 = null;
    L145:
        OnCustomForwardConfirmDialogContentView r46 = r45.getCustomConfirmDialogContentView();
        if (r46 == null) goto L148;
        boolean r115 = r46.n1();
    L149:
        com.ss.android.lark.forwardv3.plugins.f r47 = this.k;
        if (r47 != null) goto L152;
        r47 = new com.ss.android.lark.forwardv3.plugins.f(this);
    L152:
        com.ss.android.lark.forwardv3.plugins.f r48 = r47;
        FragmentManager r49 = getChildFragmentManager();
        Intrinsics.checkNotNullParameter(r12, "activity");
        Intrinsics.checkNotNullParameter(r36, "titleBarText");
        Intrinsics.checkNotNullParameter(r38, "confirmButtonText");
        Intrinsics.checkNotNullParameter(r42, "cancelButtonText");
        Intrinsics.checkNotNullParameter(r22, "items");
        Intrinsics.checkNotNullParameter(r14, "onDialogListener");
        Intrinsics.checkNotNullParameter(r48, "forwardPluginManager");
        Intrinsics.checkNotNullParameter(r49, "fragmentManager");
        ForwardDialogFragment r50 = new ForwardDialogFragment();
        r50.d = com.ss.android.lark.forwardv3.utils.n.e(r12, r36, r38, r42, r113, r114, r22, r14, r115, r48);
        FragmentTransaction r51 = r49.beginTransaction();
        r51.setCustomAnimations(0, 0);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r51, r50, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "frowardDialog", 0) == true) goto L156;
        r51.add(r50, "frowardDialog");
    L156:
        r51.commitAllowingStateLoss();
        return;
    L148:
        r115 = false;
        goto L149
    L167:
        return;
    L26:
        ArrayList r52 = new ArrayList();
        ArrayList r53 = new ArrayList();
        Iterator<T> r54 = r22.iterator();
    L28:
        if (r54.hasNext() == false) goto L33;
        Object r116 = r54.next();
        if (Intrinsics.areEqual(((SearchBaseInfo) r116).getId(), r5) == true) goto L31;
        r53.add(r116);
        goto L28
    L31:
        r52.add(r116);
        goto L28
    L33:
        Pair r55 = new Pair(r52, r53);
        List r56 = (List) r55.component1();
        r8 = new b((List) r55.component2(), r56);
        goto L36
    L20:
        if (r5.length() == 0) goto L23;
        r6 = false;
    L34:
        r7 = new b(r22, CollectionsKt.emptyList());
        goto L35
    L8:
        r4 = z2.h;
        goto L9
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r2, r3, r4);
        if (r4 != null) goto L6;
        return;
    L6:
        if (r3 == (-1)) goto L8;
        return;
    L8:
        if (r2 != 1010) goto L10;
        String r5 = r4.getStringExtra(ForwardModuleV3.a().getCreateGroupChatResultKey());
        if (r5 != null) goto L20;
        r5 = "";
    L20:
        SearchChatInfo r6 = ForwardDataUtils.c(r5);
        if (r6 == null) goto L30;
        Log.i("NewForward", "show confirm forward dialog from: create group chat");
        ca0(Collections.singletonList(r6), "from_create_group_chat");
        return;
    L30:
        return;
    L10:
        if (r2 != 1911) goto L29;
        com.ss.android.lark.forwardv3.plugins.f r7 = this.k;
        if (r7 == null) goto L26;
        com.ss.android.lark.forwardv3.plugins.i r8 = r7.b("forward_at_plugin");
        if (r8 == null) goto L27;
        r8.a(r4);
        return;
    L27:
        return;
    L26:
        return;
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Log.i("NewForward", "fragment on create view");
        View r7 = r4.inflate(2131558495, r5, false);
        Intrinsics.checkNotNull(r7);
        Log.i("NewForward", "fragment init bind view");
        this.d = r7.findViewById(2131373255);
        ViewGroup r8 = (ViewGroup) r7.findViewById(2131373236);
        r8.removeAllViews();
        tib.c r9 = ForwardModuleV3.a().createForwardChatPicker(requireContext());
        r8.addView(r9.a, new ViewGroup.LayoutParams(-1, -1));
        this.e = r9.b;
        Intrinsics.checkNotNullParameter(this, "<this>");
        WindowInsetsUtils.b(this).o(true);
        return r7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void U90(ForwardNewFragment r8, SearchBaseInfo r9, String r10, boolean r11) {
        ForwardV3ViewModel r0 = r8.f;
        RecyclerView.Adapter r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        sib.a r2 = (sib.a) r0.getRecommendData().getValue();
        if ((r2 instanceof sib.a.b) == false) goto L19;
        List<SearchBaseInfo> r3 = ((rib.b) ((sib.a.b) r2).a).b;
        if (r3.isEmpty() == true) goto L19;
        Iterator<T> r4 = r3.iterator();
        int r5 = 0;
    L12:
        if (r4.hasNext() == false) goto L19;
        int r6 = r5 + 1;
        SearchBaseInfo r7 = (SearchBaseInfo) r4.next();
        if (TextUtils.equals(r7.getId(), r10) == false) goto L18;
        if (r7.getType() != r9.getType()) goto L18;
        r7.selected(r11);
    L20:
        Log.i("NewForward", "recent visit data id: " + r10 + ", position in recent forward is " + r5);
        if (r5 != (-1)) goto L23;
        return;
    L23:
        if (r5 >= 5) goto L35;
        RecyclerView.Adapter r12 = r8.h;
        if (r12 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("recentForwardAdapter");
    L28:
        r1.notifyItemChanged(r5, "view_checkbox");
        return;
    L27:
        r1 = r12;
        goto L28
    L35:
        return;
    L18:
        r5 = r6;
    L19:
        r5 = -1;
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void W90(ForwardNewFragment r8, SearchBaseInfo r9, boolean r10, s5c.a r11) {
        r8.getClass();
        int r0 = zib.e.a;
        ForwardV3ViewModel r1 = r8.f;
        ForwardTemplateNew r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L5:
        sib.a r3 = (sib.a) r1.getRecommendData().getValue();
        ForwardTemplateNew r4 = r8.p;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("forwardTemplateNew");
    L9:
        boolean r7 = r2.getForwardTargetConfig().b;
        boolean r5 = r8.q;
        Intrinsics.checkNotNullParameter(r9, "item");
        Intrinsics.checkNotNullParameter(r11, "click");
        if (r10 == false) goto L13;
        s5c.d.o2.getClass();
        s5c.a r6 = new s5c.a("list_item_number", "0");
    L17:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new zib.g(r9, r5, r11, r6, r7));
        return;
    L13:
        if ((r3 instanceof sib.a.b) == false) goto L15;
        int r12 = ((rib.b) ((sib.a.b) r3).a).a.indexOf(r9);
        com.ss.android.lark.forwardv3.utils.b.d();
        int r13 = r12 + 1;
    L16:
        s5c.d.a r14 = s5c.d.o2;
        String r15 = String.valueOf(r13);
        r14.getClass();
        r6 = new s5c.a("list_item_number", r15);
        goto L17
    L15:
        r13 = -1;
        goto L16
    L8:
        r2 = r4;
        goto L9
    }
}
