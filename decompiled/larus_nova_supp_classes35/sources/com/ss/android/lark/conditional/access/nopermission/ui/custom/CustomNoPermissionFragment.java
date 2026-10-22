package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.lark.pb.security.v1.ChallengeType;
import com.bytedance.lark.pb.security.v1.CustomDisplayContent;
import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.bytedance.lark.pb.security.v1.CustomDisplayModelResponse;
import com.bytedance.lark.pb.security.v1.CustomDisplayTemplate;
import com.bytedance.lark.pb.security.v1.GetDeviceApplySwitchResponse;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.air.AirActivity;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.n0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.chameleon.api.OpenConfig;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonWebViewClient;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.error.DocErrorCode;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.conditional.access.databinding.ScsFragmentCustomNoPermissionBinding;
import com.ss.android.lark.conditional.access.databinding.ScsWidgetLoadingViewBinding;
import com.ss.android.lark.conditional.access.display.DisplayUtilsKt;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.nopermission.ui.NoPermissionActivity;
import com.ss.android.lark.conditional.access.nopermission.viewmodel.NoPermissionViewModel;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.traffic.handler.policy.center.PolicyCenterDisplayIdActionGate;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.conditional.access.utils.OfficeSDKExternalDeviceFactorHelper;
import com.ss.android.lark.conditional.access.widget.CustomDisplayUDButton;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.p0;
import com.ss.android.lark.widget.linked_emojicon.widget.CustomTypefaceSpan;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import io.reactivex.disposables.Disposable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@DwarfInjectPoint(parent = NoPermissionActivity.class)
@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0007\u0018\u0000 \u0099\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0006\u0099\u0001\u009a\u0001\u009b\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0016H\u0002J\u0010\u0010/\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0016H\u0002J\u0012\u00100\u001a\u00020+2\b\u00101\u001a\u0004\u0018\u000102H\u0002J\b\u00103\u001a\u00020+H\u0016J\u000e\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020!J\b\u00106\u001a\u00020+H\u0016J\b\u00107\u001a\u00020+H\u0002J\b\u00108\u001a\u00020\u0016H\u0002J\b\u00109\u001a\u00020+H\u0002J\b\u0010:\u001a\u00020+H\u0002J\b\u0010;\u001a\u00020+H\u0002J\u0012\u0010<\u001a\u00020+2\b\b\u0002\u0010=\u001a\u00020\u0016H\u0002J\b\u0010>\u001a\u00020+H\u0002J\b\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020\u0016H\u0002J\b\u0010B\u001a\u00020+H\u0002J\b\u0010C\u001a\u00020+H\u0002J$\u0010D\u001a\u00020+2\u0006\u0010E\u001a\u00020F2\b\b\u0003\u0010G\u001a\u00020H2\b\b\u0003\u0010I\u001a\u00020HH\u0002J\u001a\u0010J\u001a\u00020+2\u0006\u0010K\u001a\u00020!2\b\b\u0003\u0010I\u001a\u00020HH\u0002J\"\u0010J\u001a\u00020+2\u0006\u0010L\u001a\u00020M2\u0006\u0010K\u001a\u00020!2\b\b\u0003\u0010I\u001a\u00020HH\u0002J\u0010\u0010N\u001a\u00020+2\u0006\u0010O\u001a\u00020\u001dH\u0002J\b\u0010P\u001a\u00020\u001dH\u0002J\u0010\u0010Q\u001a\u00020+2\u0006\u0010O\u001a\u00020\u001dH\u0002J\b\u0010R\u001a\u00020+H\u0002J\b\u0010S\u001a\u00020\u0016H\u0002J\u0012\u0010T\u001a\u0004\u0018\u00010!2\u0006\u0010E\u001a\u00020FH\u0002J.\u0010U\u001a\u00020+2\u0006\u0010V\u001a\u00020!2\b\b\u0002\u0010W\u001a\u00020\u00162\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020+0YH\u0002J\u000e\u0010Z\u001a\u00020+2\u0006\u0010[\u001a\u00020HJ\u000e\u0010\\\u001a\u00020+2\u0006\u0010]\u001a\u00020HJ\b\u0010^\u001a\u00020+H\u0002J\b\u0010_\u001a\u00020+H\u0016J\b\u0010`\u001a\u00020aH\u0016J\"\u0010b\u001a\u00020+2\u0006\u0010c\u001a\u00020d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010e\u001a\u00020fH\u0016J\"\u0010g\u001a\u00020+2\u0006\u0010c\u001a\u00020d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010e\u001a\u00020fH\u0016J\"\u0010h\u001a\u00020+2\u0006\u0010c\u001a\u00020d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010e\u001a\u00020fH\u0016J\"\u0010i\u001a\u00020+2\u0006\u0010c\u001a\u00020d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010e\u001a\u00020fH\u0016J\"\u0010j\u001a\u00020+2\u0006\u0010c\u001a\u00020d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010e\u001a\u00020fH\u0016J\"\u0010k\u001a\u00020+2\u0006\u0010c\u001a\u00020d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010e\u001a\u00020fH\u0016J\"\u0010l\u001a\u00020+2\u0006\u0010c\u001a\u00020d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010e\u001a\u00020fH\u0016J&\u0010m\u001a\u00020\u0016*\u00020d2\u0006\u0010n\u001a\u00020!2\b\u0010o\u001a\u0004\u0018\u00010\u00142\u0006\u0010e\u001a\u00020fH\u0002J*\u0010p\u001a\u00020\u00162\u0006\u0010c\u001a\u00020d2\u0006\u0010n\u001a\u00020!2\b\u0010o\u001a\u0004\u0018\u00010\u00142\u0006\u0010e\u001a\u00020fH\u0002J4\u0010q\u001a\u00020#2\u0006\u0010e\u001a\u00020f2\u0006\u0010r\u001a\u00020s2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020+0u2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020+0uH\u0002J\u0012\u0010w\u001a\u00020!2\b\b\u0001\u0010x\u001a\u00020HH\u0002J\u0012\u0010y\u001a\u00020z2\b\b\u0001\u0010{\u001a\u00020HH\u0002J\b\u0010|\u001a\u00020}H\u0002J\b\u0010~\u001a\u00020!H\u0002J\u0011\u0010\u007f\u001a\u00020+2\u0007\u0010\u0080\u0001\u001a\u00020!H\u0002J#\u0010\u0081\u0001\u001a\u00020+2\u0006\u0010c\u001a\u00020d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010e\u001a\u00020fH\u0016J\u001a\u0010\u0082\u0001\u001a\u00020+2\u0006\u0010c\u001a\u00020d2\u0007\u0010\u0083\u0001\u001a\u00020\u0016H\u0002J\t\u0010\u0084\u0001\u001a\u00020+H\u0002J\u0015\u0010\u0085\u0001\u001a\u0004\u0018\u00010!2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u001b\u0010\u0086\u0001\u001a\u00020+2\u0006\u0010c\u001a\u00020d2\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0002J#\u0010\u0089\u0001\u001a\u00020+2\u0006\u0010c\u001a\u00020d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010e\u001a\u00020fH\u0016J\u0011\u0010\u008a\u0001\u001a\u00020+2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J#\u0010\u008b\u0001\u001a\u00020+2\u0006\u0010c\u001a\u00020d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010e\u001a\u00020fH\u0016J#\u0010\u008c\u0001\u001a\u00020+2\u0006\u0010c\u001a\u00020d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010e\u001a\u00020fH\u0016J#\u0010\u008d\u0001\u001a\u00020+2\u0006\u0010c\u001a\u00020d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010e\u001a\u00020fH\u0016J*\u0010\u008e\u0001\u001a\u00020+2\u000f\u0010\u0087\u0001\u001a\n\u0012\u0005\u0012\u00030\u0090\u00010\u008f\u00012\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0002¢\u0006\u0003\u0010\u0093\u0001J\u0013\u0010\u0094\u0001\u001a\u00020+2\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0002J\t\u0010\u0097\u0001\u001a\u00020+H\u0002J\t\u0010\u0098\u0001\u001a\u00020+H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u009c\u0001"}, d2 = {"Lcom/ss/android/lark/conditional/access/nopermission/ui/custom/CustomNoPermissionFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/ss/android/lark/conditional/access/nopermission/ui/custom/ButtonTypeFunction;", "Lcom/ss/android/lark/conditional/access/nopermission/ui/PageUpdateFragment;", IPortraitService.TYPE, "Lcom/ss/android/lark/conditional/access/utils/NoPermissionType;", "<init>", "(Lcom/ss/android/lark/conditional/access/utils/NoPermissionType;)V", "getType", "()Lcom/ss/android/lark/conditional/access/utils/NoPermissionType;", "viewModel", "Lcom/ss/android/lark/conditional/access/nopermission/viewmodel/NoPermissionViewModel;", "getViewModel", "()Lcom/ss/android/lark/conditional/access/nopermission/viewmodel/NoPermissionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewBinding", "Lcom/ss/android/lark/conditional/access/databinding/ScsFragmentCustomNoPermissionBinding;", "internalSecurityAction", "Lcom/ss/android/lark/conditional/access/traffic/InternalSecurityAction;", "hasSilentAuthed", BuildConfig.FLAVOR, "hasSilentCertAuthed", "disposable", "Lio/reactivex/disposables/Disposable;", "dynamicDisplayDisposable", "needRefreshOnStart", "pageUiMode", "Lcom/ss/android/lark/conditional/access/nopermission/ui/custom/CustomDisplayPageUiMode;", "pendingLowLocationAccuracyToast", "hasTriedGeoAutoCollect", "currentAdvancedLoginPageType", BuildConfig.FLAVOR, "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", BuildConfig.FLAVOR, "view", "proceedAuthResult", "authResult", "proceedCertAuthResult", "proceedApplySwitchResponse", "getDeviceApplySwitchResponse", "Lcom/bytedance/lark/pb/security/v1/GetDeviceApplySwitchResponse;", "onStart", "ping", "pingSource", "onPageUpdate", "parseData", "isCurrentDeviceGpsSupported", "renderTemplate", "startGeoAutoCollect", "renderGeoAuthPrompt", "showLoadingView", "isCertAuth", "showGeoAutoCollectLoadingView", "parseDeviceAuthInfo", "Lcom/ss/android/lark/conditional/access/nopermission/ui/custom/CustomNoPermissionFragment$DeviceAuthInfo;", "checkDeviceCertAuthFreq", "showEmptyView", "showFallbackView", "setCustomDisplayTemplate", "displayTemplate", "Lcom/bytedance/lark/pb/security/v1/CustomDisplayTemplate;", "defaultIconRes", BuildConfig.FLAVOR, "bodyColorRes", "handleRichText", "message", "textView", "Landroid/widget/TextView;", "applyLoadingUiMode", "mode", "resolveBasePageUiMode", "applyPageUiMode", "applyTemplateBaseStyle", "isDynamicDisplayEnabled", "getSubRichText", "loadDynamicPageTemplate", "displayKey", "replaceTextOnly", "onSuccess", "Lkotlin/Function1;", "tryCompressInnerScrollView", "compressHeight", "tryExpandInnerScrollView", "expandHeight", "resetDoubaoInnerScrollViewHeight", "onDestroyView", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "onMFAButtonClick", "handler", "Lcom/bytedance/lark/pb/security/v1/CustomDisplayHandler;", "context", "Landroid/content/Context;", "onUserConfirmButtonClick", "onDeviceApplyButtonClick", "onCustomLinkClick", "onCustomAppLinkClick", "onDeviceAuthButtonClick", "onDeviceCertAuthButtonClick", "openOfficeSDKExternalDeviceFactorIfNeeded", "handlerType", Keys.API_PARAM_KEY_ACTION, "showOpenFeishuConfirmDialogIfNeeded", "createOpenFeishuConfirmDialogView", "scene", "Lcom/ss/android/lark/conditional/access/nopermission/ui/custom/CustomNoPermissionFragment$OpenFeishuConfirmScene;", "onPrimaryClick", "Lkotlin/Function0;", "onSecondaryClick", "formatOpenFeishuConfirmText", "resId", "buildOpenFeishuConfirmMessage", BuildConfig.FLAVOR, "descriptionRes", "createDoubaoPolicyCenterSemiboldTypeface", "Landroid/graphics/Typeface;", "getCurrentUserDisplayName", "endDeviceButtonLoadingOnFeishuLaunched", "buttonType", "onDeviceTokenClaimsChallengeButtonClick", "setDeviceTokenClaimsChallengeLoading", "loading", "handleDeviceTokenClaimsChallengeSuccess", "getDeviceTokenClaimsChallengeCode", "handleDeviceTokenClaimsChallengeResult", ChameleonOpenTracker.ParamKey.RESULT, "Lcom/ss/android/lark/conditional/access/dependency/DeviceTokenClaimsChallengeResult;", "onRetryButtonClick", "refreshWithGeoFactors", "onCancelButtonClick", "onSkipVerifyButtonClick", "onGeoAuthButtonClick", "handleGeoAuthResult", "Lkotlin/Result;", "Lcom/ss/android/lark/endpoint/security/detection/factor/EndpointSecurityFactorReportResult;", "durationMs", BuildConfig.FLAVOR, "(Ljava/lang/Object;J)V", "dispatchGeoAuthErrorFeedback", "err", BuildConfig.FLAVOR, "showGoToLocationSettingsDialog", "showLocationServicesDisabledDialog", "Companion", "DeviceAuthInfo", "OpenFeishuConfirmScene", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomNoPermissionFragment extends Hilt_CustomNoPermissionFragment implements d0c.c, com.ss.android.lark.conditional.access.nopermission.ui.custom.a, com.ss.android.lark.conditional.access.nopermission.ui.y {
    public static long s;
    public static long t;
    public static final /* synthetic */ int u = 0;
    public final NoPermissionType f;
    public final Lazy g;
    public ScsFragmentCustomNoPermissionBinding h;
    public InternalSecurityAction i;
    public boolean j;
    public boolean k;
    public Disposable l;
    public Disposable m;
    public boolean n;
    public CustomDisplayPageUiMode o;
    public boolean p;
    public boolean q;
    public String r;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final int b;
        public final boolean c;

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
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "DeviceAuthInfo(nonce=" + this.a + ", challengeType=" + this.b + ", needCertVerify=" + this.c + ')';
        }

        public b(String r2, int r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_NONCE);
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c {
        public final int a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "OpenFeishuConfirmScene(titleRes=" + this.a + ", descriptionRes=" + this.b + ')';
        }

        public c(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements k8b.d {
        public final /* synthetic */ CustomNoPermissionFragment a;
        public final /* synthetic */ CustomDisplayHandler b;

        @Override // k8b.d
        public final void a(k8b.b r10) {
            Intrinsics.checkNotNullParameter(r10, ChameleonOpenTracker.ParamKey.RESULT);
            CustomNoPermissionFragment r0 = this.a;
            CustomDisplayHandler r1 = this.b;
            int r2 = CustomNoPermissionFragment.u;
            r0.getClass();
            ScsFragmentCustomNoPermissionBinding r5 = null;
            boolean r6 = false;
            if (Intrinsics.areEqual(r10, k8b.b.d.a) == false) goto L13;
            ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "device token claims challenge authorization success");
            r0.fa0(r1, false);
            if (r0.isAdded() == false) goto L47;
            ScsFragmentCustomNoPermissionBinding r11 = r0.h;
            if (r11 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        L11:
            r5.a.post(new com.ss.android.lark.conditional.access.nopermission.ui.custom.j(r0));
            return;
        L10:
            r5 = r11;
            goto L11
        L47:
            return;
        L13:
            if ((r10 instanceof k8b.b.c) == false) goto L32;
            int r3 = ScsLogger.a;
            StringBuilder r4 = new StringBuilder("device token claims challenge authorization failed, code: ");
            k8b.b.c r12 = (k8b.b.c) r10;
            r4.append(r12.a);
            ScsLogger.c("SecurityPolicy_CustomNoPermissionFragment", r4.toString());
            r0.fa0(r1, false);
            String r7 = r12.b;
            if (r7 == null) goto L30;
            String r8 = StringsKt.trim(r7).toString();
            if (r8 == null) goto L30;
            if (r8.length() <= 0) goto L21;
            r6 = true;
        L21:
            if (r6 == true) goto L24;
            r8 = null;
        L24:
            if (r8 == null) goto L30;
            ScsFragmentCustomNoPermissionBinding r9 = r0.h;
            if (r9 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        L29:
            r5.a.post(new com.ss.android.lark.conditional.access.nopermission.ui.custom.i(r0, r8));
            goto L30
        L28:
            r5 = r9;
        L30:
            FileAuthMonitor.UpdateTrigger[] r13 = FileAuthMonitor.a;
            FileAuthMonitor.j("page", r12.a, r12.b);
            return;
        L32:
            if (Intrinsics.areEqual(r10, k8b.b.C0247b.a) == false) goto L35;
            ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "device token claims challenge authorization cancelled");
            r0.fa0(r1, false);
            FileAuthMonitor.UpdateTrigger[] r14 = FileAuthMonitor.a;
            FileAuthMonitor.j("page", "cancelled", null);
            return;
        L35:
            if (Intrinsics.areEqual(r10, k8b.b.a.a) == false) goto L38;
            ScsLogger.c("SecurityPolicy_CustomNoPermissionFragment", "device token claims challenge authorization failed, app not installed");
            r0.fa0(r1, false);
            FileAuthMonitor.UpdateTrigger[] r15 = FileAuthMonitor.a;
            FileAuthMonitor.j("page", "app_not_installed", null);
            return;
        L38:
            if (Intrinsics.areEqual(r10, k8b.b.e.a) == false) goto L42;
            ScsLogger.c("SecurityPolicy_CustomNoPermissionFragment", "device token claims challenge is unsupported by passport dependency");
            r0.fa0(r1, false);
            FileAuthMonitor.UpdateTrigger[] r16 = FileAuthMonitor.a;
            FileAuthMonitor.j("page", "unsupported", null);
            return;
        L42:
            throw new NoWhenBranchMatchedException();
        }

        public d(CustomNoPermissionFragment r1, CustomDisplayHandler r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ CustomNoPermissionFragment a;
        public final /* synthetic */ CustomDisplayHandler b;

        public e(CustomNoPermissionFragment r1, CustomDisplayHandler r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CustomNoPermissionFragment r0 = this.a;     // Catch: Throwable -> L4
            CustomDisplayHandler r1 = this.b;     // Catch: Throwable -> L4
            int r2 = CustomNoPermissionFragment.u;     // Catch: Throwable -> L4
            r0.fa0(r1, false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ CustomNoPermissionFragment a;

        public f(CustomNoPermissionFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Boolean r6 = (Boolean) r5;
            CustomNoPermissionFragment r0 = this.a;
            boolean r1 = r0.p;
            r0.p = false;
            ScsFragmentCustomNoPermissionBinding r2 = r0.h;
            u8b.b r3 = null;
            if (r2 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            r2 = null;
        L5:
            KeyEvent.Callback r4 = r2.a.findViewWithTag("RetryAccess");
            if ((r4 instanceof u8b.b) == false) goto L8;
            r3 = (u8b.b) r4;
        L8:
            if (r3 == null) goto L11;
            r3.endLoading();
        L11:
            if (r6.booleanValue() == false) goto L13;
            Lazy r7 = PolicyCenterDisplayIdActionGate.a;
            ((com.ss.android.lark.conditional.access.traffic.handler.policy.center.a) PolicyCenterDisplayIdActionGate.a.getValue()).i3(this.a.i);
            this.a.finish();
            com.ss.android.lark.conditional.access.nopermission.interception.a.a.getClass();
            com.ss.android.lark.conditional.access.nopermission.interception.a.a();
            return;
        L13:
            if (r1 == false) goto L17;
            UDToast.show(this.a.requireContext(), 2131890270, 2131255144);
            return;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ CustomNoPermissionFragment a;

        public g(CustomNoPermissionFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            CustomDisplayModelResponse r5 = (CustomDisplayModelResponse) r4;
            if (r5 == null) goto L12;
            int r0 = ScsLogger.a;
            StringBuilder r1 = new StringBuilder("displayTemplate observer: internalSecurityAction isNull=");
            if (this.a.i != null) goto L7;
            boolean r2 = true;
        L8:
            r1.append(r2);
            r1.append(", title=");
            r1.append(r5.config.template.title);
            r1.append(", handlerListSize=");
            r1.append(r5.config.template.handler_list.size());
            ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", r1.toString());
            CustomNoPermissionFragment r3 = this.a;
            InternalSecurityAction r6 = r3.i;
            if (r6 == null) goto L11;
            r3.ea0(DisplayUtilsKt.e(r5.config.template, r6), 2131238146, 2131106622);
            return;
        L11:
            ScsLogger.c("SecurityPolicy_CustomNoPermissionFragment", "internalSecurityAction is NULL, template not rendered!");
            return;
        L7:
            r2 = false;
            goto L8
        L12:
            CustomNoPermissionFragment r7 = this.a;
            int r8 = CustomNoPermissionFragment.u;
            r7.ga0();
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ CustomNoPermissionFragment a;

        public h(CustomNoPermissionFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Boolean r5 = (Boolean) r4;
            ScsFragmentCustomNoPermissionBinding r0 = this.a.h;
            u8b.b r1 = null;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            r0 = null;
        L5:
            KeyEvent.Callback r2 = r0.a.findViewWithTag("MFA");
            if ((r2 instanceof u8b.b) == false) goto L8;
            r1 = (u8b.b) r2;
        L8:
            if (r1 == null) goto L11;
            r1.endLoading();
        L11:
            if (r5.booleanValue() == false) goto L13;
            this.a.aa0("mfa_success");
            return;
        L13:
            ScsLogger.c("SecurityPolicy_CustomNoPermissionFragment", "MFA error!");
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ CustomNoPermissionFragment a;

        public i(CustomNoPermissionFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            GetDeviceApplySwitchResponse r6 = (GetDeviceApplySwitchResponse) r5;
            CustomNoPermissionFragment r0 = this.a;
            ScsFragmentCustomNoPermissionBinding r1 = r0.h;
            u8b.b r2 = null;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            r1 = null;
        L5:
            KeyEvent.Callback r3 = r1.a.findViewWithTag("DeviceApply");
            if ((r3 instanceof u8b.b) == false) goto L8;
            r2 = (u8b.b) r3;
        L8:
            if (r2 == null) goto L11;
            r2.endLoading();
        L11:
            if (r6 != null) goto L13;
            ScsLogger.c("SecurityPolicy_CustomNoPermissionFragment", "device apply error！");
            CustomNoPermissionFragment.T90(new UDDialogBuilder(r0.requireContext()).message(2131890724).addActionButton(2131391778, 2131890503, com.ss.android.lark.conditional.access.nopermission.ui.custom.n.a).build());
            return;
        L13:
            if (r6.is_enable.booleanValue() == false) goto L15;
            int r7 = g8b.b.a;
            g8b.b.a.a().getDependency().m(r0.requireActivity(), PassportcConvention.b(r0));
            return;
        L15:
            CustomNoPermissionFragment.T90(new UDDialogBuilder(r0.requireContext()).title(2131892523).message(2131892522).addActionButton(2131391777, 2131890503, com.ss.android.lark.conditional.access.nopermission.ui.custom.m.a).build());
        }
    }

    public static final class j<T> implements Observer {
        public final /* synthetic */ CustomNoPermissionFragment a;

        public j(CustomNoPermissionFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Boolean r5 = (Boolean) r4;
            ScsFragmentCustomNoPermissionBinding r0 = this.a.h;
            u8b.b r1 = null;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            r0 = null;
        L5:
            KeyEvent.Callback r2 = r0.a.findViewWithTag("UserConfirm");
            if ((r2 instanceof u8b.b) == false) goto L8;
            r1 = (u8b.b) r2;
        L8:
            if (r1 == null) goto L11;
            r1.endLoading();
        L11:
            if (r5.booleanValue() == false) goto L13;
            this.a.aa0("user_confirm");
            return;
        L13:
            UDToast.show(this.a.requireContext(), 2131892540, 2131255144);
            ScsLogger.c("SecurityPolicy_CustomNoPermissionFragment", "user confirm error!");
        }
    }

    public static final class k<T> implements Observer {
        public final /* synthetic */ CustomNoPermissionFragment a;

        public k(CustomNoPermissionFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            Boolean r7 = (Boolean) r6;
            CustomNoPermissionFragment r0 = this.a;
            Intrinsics.checkNotNull(r7);
            boolean r8 = r7.booleanValue();
            ScsFragmentCustomNoPermissionBinding r1 = r0.h;
            ScsFragmentCustomNoPermissionBinding r3 = null;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            r1 = null;
        L5:
            KeyEvent.Callback r2 = r1.a.findViewWithTag("DeviceAuth");
            if ((r2 instanceof u8b.b) == false) goto L8;
            u8b.b r4 = (u8b.b) r2;
        L9:
            if (r4 == null) goto L11;
            r4.endLoading();
        L11:
            if (r8 == false) goto L18;
            ScsFragmentCustomNoPermissionBinding r9 = r0.h;
            if (r9 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        L16:
            r3.a.postDelayed(new o(r0), 1000);
            return;
        L15:
            r3 = r9;
            goto L16
        L18:
            if (r0.j == true) goto L27;
            r0.j = true;
            ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "firstLoad auth fail, show fallback UI.");
            ScsFragmentCustomNoPermissionBinding r10 = r0.h;
            if (r10 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            r10 = null;
        L22:
            r10.h.b.cancelAnimation();
            ScsFragmentCustomNoPermissionBinding r11 = r0.h;
            if (r11 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        L26:
            t4c.b.a(r3.h.c);
            r0.parseData();
            return;
        L25:
            r3 = r11;
            goto L26
        L27:
            ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "auth fail, show auth retry dialog.");
            new UDDialogBuilder(r0.requireContext()).cancelable(false).cancelOnTouchOutside(false).title(2131890477).actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL).addActionButton(2131391777, 2131890478, new p(r0)).addActionButton(2131391778, 2131890476, q.a).show();
            return;
        L8:
            r4 = null;
            goto L9
        }
    }

    public static final class l<T> implements Observer {
        public final /* synthetic */ CustomNoPermissionFragment a;

        public l(CustomNoPermissionFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            Boolean r7 = (Boolean) r6;
            CustomNoPermissionFragment r0 = this.a;
            Intrinsics.checkNotNull(r7);
            boolean r8 = r7.booleanValue();
            ScsFragmentCustomNoPermissionBinding r1 = r0.h;
            ScsFragmentCustomNoPermissionBinding r3 = null;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            r1 = null;
        L5:
            KeyEvent.Callback r2 = r1.a.findViewWithTag("DeviceCertAuth");
            if ((r2 instanceof u8b.b) == false) goto L8;
            u8b.b r4 = (u8b.b) r2;
        L9:
            if (r4 == null) goto L11;
            r4.endLoading();
        L11:
            if (r8 == false) goto L18;
            ScsFragmentCustomNoPermissionBinding r9 = r0.h;
            if (r9 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        L16:
            r3.a.postDelayed(new r(r0), 1000);
            return;
        L15:
            r3 = r9;
            goto L16
        L18:
            if (r0.k == true) goto L27;
            r0.k = true;
            ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "firstLoad cert auth fail, show fallback UI.");
            ScsFragmentCustomNoPermissionBinding r10 = r0.h;
            if (r10 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            r10 = null;
        L22:
            r10.h.b.cancelAnimation();
            ScsFragmentCustomNoPermissionBinding r11 = r0.h;
            if (r11 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        L26:
            t4c.b.a(r3.h.c);
            r0.parseData();
            return;
        L25:
            r3 = r11;
            goto L26
        L27:
            ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "cert auth fail, show auth retry dialog.");
            new UDDialogBuilder(r0.requireContext()).cancelable(false).cancelOnTouchOutside(false).title(2131890291).actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL).addActionButton(2131391777, 2131890294, new s(r0)).addActionButton(2131391778, 2131890289, t.a).show();
            return;
        L8:
            r4 = null;
            goto L9
        }
    }

    public static final class m implements Runnable {
        public final /* synthetic */ CustomNoPermissionFragment a;

        public m(CustomNoPermissionFragment r1) {
            this.a = r1;
        }

        public final void a() {
            if (this.a.isAdded() == true) goto L5;
            return;
        L5:
            FragmentActivity r0 = this.a.getActivity();
            if (r0 != null) goto L8;
            return;
        L8:
            Configuration r1 = r0.getResources().getConfiguration();
            r0.onConfigurationChanged(r1);
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L23
            if (dc9.d.a() == true) goto L28;
            int r4 = r0.getRequestedOrientation();     // Catch: Throwable -> L23
            if (r1 == null) goto L14;
            Integer r2 = Integer.valueOf(r1.orientation);     // Catch: Throwable -> L23
        L15:
            if (r2 != null) goto L18;
        L20:
            if (r4 != 3) goto L30;
            r0.setRequestedOrientation(1);     // Catch: Throwable -> L23
            FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:" + r0.getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L23
            return;
        L30:
            return;
        L18:
            if (r2.intValue() != r4) goto L20;
            return;
        L14:
            r2 = null;
            goto L15
        L28:
            return;
        L23:
            th = move-exception;
            FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class n implements Runnable {
        public final /* synthetic */ CustomNoPermissionFragment a;
        public final /* synthetic */ ConstraintLayout b;
        public final /* synthetic */ CustomDisplayHandler c;
        public final /* synthetic */ boolean d;

        public n(CustomNoPermissionFragment r1, ConstraintLayout r2, CustomDisplayHandler r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L16:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L25;
            throw th;
        L25:
            return;
        L3:
            if (this.a.isAdded() == false) goto L19;
            KeyEvent.Callback r0 = this.b.findViewWithTag(this.c.type);     // Catch: Throwable -> L16
            if ((r0 instanceof u8b.b) == false) goto L8;
            u8b.b r1 = (u8b.b) r0;     // Catch: Throwable -> L16
        L10:
            if (this.d == false) goto L13;
            if (r1 == null) goto L22;
            r1.startLoading();     // Catch: Throwable -> L16
            return;
        L22:
            return;
        L13:
            if (r1 == null) goto L24;
            r1.endLoading();     // Catch: Throwable -> L16
            return;
        L24:
            return;
        L8:
            r1 = null;
            goto L10
        }
    }

    static {
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    public final NoPermissionViewModel W90() {
        return (NoPermissionViewModel) this.g.getValue();
    }

    public final void ba0() {
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "renderGeoAuthPrompt()");
        final CustomDisplayTemplate r0 = new CustomDisplayTemplate.Builder().icon(BuildConfig.FLAVOR).title(getString(2131890260)).text(UIHelper.mustacheFormat(2131890261, "APP_DISPLAY_NAME", UIHelper.getAppName())).richText(BuildConfig.FLAVOR).locale(BuildConfig.FLAVOR).content_list(CollectionsKt.emptyList()).handler_list(CollectionsKt.listOf(new CustomDisplayHandler.Builder().name(getString(2131890265)).type("GeoAuth").style("primary").build())).build();
        Intrinsics.checkNotNull(r0);
        ea0(r0, 2131247524, 2131106607);
        this.r = "geo_auth";
        int r2 = com.ss.android.lark.conditional.access.utils.a.a;
        com.ss.android.lark.conditional.access.utils.a.f("geo_auth", "show", this.i);
        Function1<CustomDisplayTemplate, Unit> r1 = new CustomNoPermissionFragment$renderGeoAuthPrompt$1(r0, this);
        if ((!w4c.c.a().a()) == false) goto L22;
        Disposable r3 = this.m;
        if (r3 == null) goto L20;
        r3.dispose();
    L20:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L10
        LarkAppContext.Companion.getClass();     // Catch: Throwable -> L10
        Object r5 = Result.constructor-impl((com.ss.android.lark.conditional.access.display.g) e0c.k.a(LarkAppContext.access$getInstance$cp().getContext(), com.ss.android.lark.conditional.access.display.g.class));     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r5) == false) goto L15;
        r5 = null;
    L15:
        com.ss.android.lark.conditional.access.display.g r6 = (com.ss.android.lark.conditional.access.display.g) r5;
        if (r6 == null) goto L23;
        this.m = t4c.a.a(r6.v5(qqb.a.d())).subscribe(new com.ss.android.lark.conditional.access.nopermission.ui.custom.k(this, r1), new com.ss.android.lark.conditional.access.nopermission.ui.custom.l());
        return;
    L23:
        return;
    L10:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public final void ca0() {
        this.r = "template";
        int r1 = com.ss.android.lark.conditional.access.utils.a.a;
        com.ss.android.lark.conditional.access.utils.a.f("template", "show", this.i);
        InternalSecurityAction r0 = this.i;
        if (r0 == null) goto L9;
        DecisionData.Action r2 = r0.getCurrentAction();
        if (r2 == null) goto L9;
        Map<String, String> r3 = r2.getParams();
        if (r3 == null) goto L9;
        String r4 = r3.get("displayID");
    L10:
        if (r4 != null) goto L12;
    L15:
        boolean r5 = true;
    L16:
        if (r5 == false) goto L18;
        ScsLogger.c("SecurityPolicy_CustomNoPermissionFragment", "displayID is empty!");
        FileAuthMonitor.UpdateTrigger[] r6 = FileAuthMonitor.a;
        FileAuthMonitor.e(101, String.valueOf(this.i));
        ga0();
        return;
    L18:
        showEmptyView();
        W90().fetchDisplayTemplate(r4);
        return;
    L12:
        if (r4.length() == 0) goto L15;
        r5 = false;
    L9:
        r4 = null;
        goto L10
    }

    public final void da0() {
        ScsFragmentCustomNoPermissionBinding r0 = this.h;
        ScsFragmentCustomNoPermissionBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L5:
        NestedScrollView r2 = r0.g;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L14;
        r3.height = -2;
        r2.setLayoutParams(r3);
        ScsFragmentCustomNoPermissionBinding r4 = this.h;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L11:
        r1.g.setMinimumHeight(0);
        return;
    L10:
        r1 = r4;
        goto L11
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void ga0() {
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "showFallbackView()");
        CustomDisplayTemplate r0 = new CustomDisplayTemplate.Builder().icon(BuildConfig.FLAVOR).title(getResources().getString(2131892537)).text(getResources().getString(2131892521)).richText(BuildConfig.FLAVOR).locale(BuildConfig.FLAVOR).content_list(CollectionsKt.emptyList()).handler_list(CollectionsKt.listOf(new CustomDisplayHandler.Builder().name(getResources().getString(2131892539)).type("RetryAccess").style("secondary").build())).build();
        FileAuthMonitor.UpdateTrigger[] r1 = FileAuthMonitor.a;
        FileAuthMonitor.l(DocErrorCode.ERR_KEY_NATIVE, this.i);
        Intrinsics.checkNotNull(r0);
        ea0(r0, 2131238146, 2131106622);
    }

    public final void onDestroyView() {
        Disposable r0 = this.m;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        super.onDestroyView();
        FileAuthMonitor.UpdateTrigger[] r1 = FileAuthMonitor.a;
        FileAuthMonitor.d(this.i, "dismiss", this.f);
        String r2 = this.r;
        if (r2 == null) goto L9;
        int r3 = com.ss.android.lark.conditional.access.utils.a.a;
        com.ss.android.lark.conditional.access.utils.a.f(r2, "dismiss", this.i);
        this.r = null;
        return;
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.y
    public final void onPageUpdate() {
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "onPageUpdate()");
        Disposable r0 = this.l;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.j = false;
        this.k = false;
        this.q = false;
        parseData();
    }

    public final void parseData() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        InternalSecurityAction r1 = (InternalSecurityAction) r0.getParcelable("param_action");
    L6:
        this.i = r1;
        int r4 = com.ss.android.lark.conditional.access.nopermission.ui.custom.d.a;
        V90(com.ss.android.lark.conditional.access.nopermission.ui.custom.d.a(this.f, r1));
        Map<String, String> r2 = DisplayUtilsKt.a(this.i);     // Catch: Exception -> L30
        String r7 = r2.get("challengeType");     // Catch: Exception -> L30
        if (r7 == null) goto L12;
        Integer r8 = StringsKt.toIntOrNull(r7);     // Catch: Exception -> L30
        if (r8 == null) goto L12;
        int r9 = r8.intValue();     // Catch: Exception -> L30
    L13:
        String r10 = r2.get(Keys.API_RETURN_KEY_NONCE);     // Catch: Exception -> L30
        if (r10 != null) goto L16;
        r10 = BuildConfig.FLAVOR;
    L16:
        String r3 = r2.get("certInfo");     // Catch: Exception -> L30
        if (r3 != null) goto L20;
        r3 = BuildConfig.FLAVOR;
    L20:
        if (r3.length() <= 0) goto L22;
        boolean r11 = true;
    L23:
        if (r11 == false) goto L27;
        Boolean r5 = JSON.parseObject(r3).getBoolean("needCertVerify");     // Catch: Exception -> L30
        if (r5 == null) goto L27;
        boolean r6 = r5.booleanValue();     // Catch: Exception -> L30
    L28:
        b r12 = new b(r10, r9, r6);     // Catch: Exception -> L30
    L32:
        String r13 = r12.a;
        int r14 = r12.b;
        boolean r15 = r12.c;
        ChallengeType r16 = ChallengeType.NEED_REGISTERED_DEVICE;
        boolean r17 = ArraysKt.contains(new Integer[]{Integer.valueOf(r16.getValue()), Integer.valueOf(ChallengeType.NEED_MANAGED_DEVICE.getValue())}, Integer.valueOf(r14));
        if (r14 != ChallengeType.NOT_MANAGED_DEVICE.getValue()) goto L35;
        boolean r18 = true;
    L37:
        if (r14 != r16.getValue()) goto L40;
        if (r15 == false) goto L40;
        boolean r19 = true;
    L41:
        Integer r110 = DisplayUtilsKt.c(this.i);
        if (r110 != null) goto L45;
    L51:
        boolean r111 = false;
    L53:
        if (this.j == true) goto L57;
        if (r17 == false) goto L57;
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "start device authentication silent.");
        int r20 = com.ss.android.lark.conditional.access.utils.a.a;
        com.ss.android.lark.conditional.access.utils.a.c("detection_equipment", "need_device_cert", this.i);
        W90().startDeviceAuthenticationWithNonce(qqb.a.d(), r13, r14, r15);
        ha0(r19);
        return;
    L57:
        if (this.k == true) goto L66;
        if (r18 == false) goto L66;
        long r21 = System.currentTimeMillis();
        if ((r21 - s) <= OpenConfig.DEFAULT_LOADING_TIMEOUT) goto L62;
        s = r21;
        boolean r112 = true;
    L63:
        if (r112 == false) goto L66;
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "start device cert authentication silent.");
        int r22 = com.ss.android.lark.conditional.access.utils.a.a;
        com.ss.android.lark.conditional.access.utils.a.c("detection_equipment", "need_device_cert", this.i);
        W90().startDeviceCertAuthentication(qqb.a.d(), "noPermissionCertAuthAuto");
        ha0(true);
        return;
    L62:
        r112 = false;
    L66:
        if (r110 == null) goto L77;
        if (Y90() == true) goto L70;
    L71:
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "parseData: bypass geo (gps unsupported or switch off), render template.");
        if (Y90() == true) goto L74;
        String r23 = "gps_unsupported";
    L75:
        int r24 = com.ss.android.lark.conditional.access.utils.a.a;
        com.ss.android.lark.conditional.access.utils.a.c("template", r23, this.i);
        ca0();
        return;
    L74:
        r23 = "switch_off";
        goto L75
    L70:
        if (w4c.c.a().P() == false) goto L71;
    L77:
        if (r111 == false) goto L92;
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "start geo auto collect silent.");
        int r25 = com.ss.android.lark.conditional.access.utils.a.a;
        com.ss.android.lark.conditional.access.utils.a.c("geo_challenge", "available", this.i);
        this.q = true;
        t = System.currentTimeMillis();
        Context r26 = getContext();
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L81
        LarkAppContext.Companion.getClass();     // Catch: Throwable -> L81
        Object r28 = Result.constructor-impl((com.ss.android.lark.endpoint.security.detection.location.a) e0c.k.a(LarkAppContext.access$getInstance$cp().getContext(), com.ss.android.lark.endpoint.security.detection.location.a.class));     // Catch: Throwable -> L81
    L84:
        if (Result.isFailure-impl(r28) == false) goto L86;
        r28 = null;
    L86:
        com.ss.android.lark.endpoint.security.detection.location.a r29 = (com.ss.android.lark.endpoint.security.detection.location.a) r28;
        if (r26 == null) goto L91;
        if (r29 == null) goto L91;
        r29.a(r26);
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "geoAutoCollect: no location permission, render state2");
        ba0();
        return;
    L91:
        ScsLogger.c("SecurityPolicy_CustomNoPermissionFragment", "geoAutoCollect: ctx/locationClient null, render state2");
        ba0();
        return;
    L81:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L84
    L92:
        if (r110 != null) goto L95;
    L97:
        int r31 = com.ss.android.lark.conditional.access.utils.a.a;
        com.ss.android.lark.conditional.access.utils.a.c("template", "no_geo_required", this.i);
        ca0();
        return;
    L95:
        if (r110.intValue() != 1) goto L97;
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "geoChallengeType=1, in fallback window or already tried, render state2.");
        int r32 = com.ss.android.lark.conditional.access.utils.a.a;
        com.ss.android.lark.conditional.access.utils.a.c("geo_challenge", "available", this.i);
        ba0();
        return;
    L45:
        if (r110.intValue() != 1) goto L51;
        if (this.q == true) goto L51;
        if ((System.currentTimeMillis() - t) <= OpenConfig.DEFAULT_LOADING_TIMEOUT) goto L51;
        r111 = true;
    L40:
        r19 = false;
        goto L41
    L35:
        r18 = false;
    L27:
        r6 = false;
        goto L28
    L22:
        r11 = false;
    L12:
        r9 = 0;
    L30:
        e = move-exception;
        int r33 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_CustomNoPermissionFragment", "parseDeviceAuthInfo error: " + e.getMessage());
        r12 = new b(BuildConfig.FLAVOR, 0, false);
        goto L32
    L5:
        r1 = null;
        goto L6
    }

    public final void showEmptyView() {
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "showEmptyView()");
        if (this.o == CustomDisplayPageUiMode.LARK) goto L5;
        boolean r1 = true;
    L6:
        ScsFragmentCustomNoPermissionBinding r2 = this.h;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r2 = null;
    L9:
        r2.j.setImageTintList(null);
        ScsFragmentCustomNoPermissionBinding r3 = this.h;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r3 = null;
    L12:
        ImageView r4 = r3.j;
        ViewGroup.LayoutParams r7 = r4.getLayoutParams();
        if (r7 == null) goto L234;
        LinearLayout.LayoutParams r8 = (LinearLayout.LayoutParams) r7;
        Context r9 = requireContext();
        float r10 = 56.0f;
        if (r1 == false) goto L17;
        float r12 = 56.0f;
    L18:
        r8.width = UIUtils.dp2px(r9, r12);
        Context r11 = requireContext();
        if (r1 == true) goto L22;
        r10 = 100.0f;
    L22:
        r8.height = UIUtils.dp2px(r11, r10);
        r4.setLayoutParams(r8);
        ScsFragmentCustomNoPermissionBinding r5 = this.h;
        if (r5 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r5 = null;
    L25:
        LinearLayout r6 = r5.i;
        ViewGroup.LayoutParams r13 = r6.getLayoutParams();
        if (r13 == null) goto L232;
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r13;
        Context r15 = requireContext();
        if (r1 == false) goto L30;
        float r16 = 0.0f;
    L31:
        r14.topMargin = UIUtils.dp2px(r15, r16);
        Context r17 = requireContext();
        if (r1 == false) goto L34;
        float r18 = 0.0f;
    L35:
        r14.bottomMargin = UIUtils.dp2px(r17, r18);
        r6.setLayoutParams(r14);
        ScsFragmentCustomNoPermissionBinding r19 = this.h;
        if (r19 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r19 = null;
    L38:
        TextView r20 = r19.f;
        r20.setTypeface(null);
        r20.setTextAppearance(requireContext(), 2131953919);
        Context r21 = requireContext();
        if (r1 == false) goto L41;
        float r110 = 31.0f;
    L42:
        TextViewCompat.setLineHeight(r20, UIUtils.dp2px(r21, r110));
        int r111 = 2;
        if (r1 == false) goto L45;
        Intrinsics.checkNotNull(r20);
        h0.a(r20, 600);
        r20.setTextSize(2, 22.0f);
    L45:
        Context r112 = requireContext();
        int r113 = 2131106622;
        if (r1 == false) goto L48;
        int r114 = 2131101391;
    L49:
        r20.setTextColor(ContextCompat.getColor(r112, r114));
        Intrinsics.checkNotNull(r20);
        ViewGroup.LayoutParams r115 = r20.getLayoutParams();
        if (r115 == null) goto L230;
        LinearLayout.LayoutParams r116 = (LinearLayout.LayoutParams) r115;
        Context r117 = requireContext();
        if (r1 == false) goto L54;
        float r22 = 24.0f;
    L55:
        r116.leftMargin = UIUtils.dp2px(r117, r22);
        Context r23 = requireContext();
        if (r1 == false) goto L58;
        float r118 = 24.0f;
    L59:
        r116.rightMargin = UIUtils.dp2px(r23, r118);
        Context r24 = requireContext();
        float r119 = 12.0f;
        float r120 = 20.0f;
        if (r1 == false) goto L62;
        float r121 = 20.0f;
    L63:
        r116.topMargin = UIUtils.dp2px(r24, r121);
        r20.setLayoutParams(r116);
        TextView[] r25 = new TextView[2];
        ScsFragmentCustomNoPermissionBinding r26 = this.h;
        if (r26 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r26 = null;
    L66:
        r25[0] = r26.d;
        ScsFragmentCustomNoPermissionBinding r27 = this.h;
        if (r27 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r27 = null;
    L69:
        r25[1] = r27.e;
        Iterator r28 = CollectionsKt.listOf(r25).iterator();
    L71:
        if (r28.hasNext() == false) goto L93;
        TextView r29 = (TextView) r28.next();
        if (r1 == false) goto L75;
        float r30 = 15.0f;
    L76:
        r29.setTextSize(r111, r30);
        Context r31 = requireContext();
        if (r1 == false) goto L79;
        float r122 = 24.0f;
    L80:
        TextViewCompat.setLineHeight(r29, UIUtils.dp2px(r31, r122));
        Intrinsics.checkNotNull(r29);
        ViewGroup.LayoutParams r32 = r29.getLayoutParams();
        if (r32 == null) goto L92;
        LinearLayout.LayoutParams r33 = (LinearLayout.LayoutParams) r32;
        Context r123 = requireContext();
        float r124 = 32.0f;
        if (r1 == false) goto L85;
        float r125 = 32.0f;
    L86:
        r33.leftMargin = UIUtils.dp2px(r123, r125);
        Context r126 = requireContext();
        if (r1 == true) goto L90;
        r124 = 16.0f;
    L90:
        r33.rightMargin = UIUtils.dp2px(r126, r124);
        r29.setLayoutParams(r33);
        r111 = 2;
        goto L71
    L85:
        r125 = 16.0f;
        goto L86
    L92:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L79:
        r122 = 22.0f;
        goto L80
    L75:
        r30 = 14.0f;
        goto L76
    L93:
        ScsFragmentCustomNoPermissionBinding r34 = this.h;
        if (r34 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r34 = null;
    L96:
        TextView r35 = r34.d;
        Context r36 = requireContext();
        int r37 = 2131101392;
        if (r1 == false) goto L99;
        r113 = 2131101392;
    L99:
        r35.setTextColor(ContextCompat.getColor(r36, r113));
        ScsFragmentCustomNoPermissionBinding r38 = this.h;
        if (r38 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r38 = null;
    L102:
        TextView r39 = r38.e;
        Context r40 = requireContext();
        if (r1 == true) goto L106;
        r37 = 2131106607;
    L106:
        r39.setTextColor(ContextCompat.getColor(r40, r37));
        ScsFragmentCustomNoPermissionBinding r41 = this.h;
        if (r41 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r41 = null;
    L109:
        TextView r42 = r41.d;
        ScsFragmentCustomNoPermissionBinding r43 = this.h;
        if (r43 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r43 = null;
    L112:
        int r44 = r43.d.getPaddingLeft();
        Context r45 = requireContext();
        float r46 = 4.0f;
        if (r1 == false) goto L115;
        float r127 = 12.0f;
    L116:
        int r47 = UIUtils.dp2px(r45, r127);
        ScsFragmentCustomNoPermissionBinding r128 = this.h;
        if (r128 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r128 = null;
    L119:
        int r129 = r128.d.getPaddingRight();
        Context r130 = requireContext();
        if (r1 == false) goto L122;
        r46 = 0.0f;
    L122:
        r42.setPadding(r44, r47, r129, UIUtils.dp2px(r130, r46));
        ScsFragmentCustomNoPermissionBinding r48 = this.h;
        if (r48 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r48 = null;
    L125:
        LinearLayout r49 = r48.c;
        if (r1 == false) goto L128;
        GradientDrawable r50 = new GradientDrawable();
        r50.setColor(ContextCompat.getColor(requireContext(), 2131101383));
        r50.setCornerRadius(UIUtils.dp2px(requireContext(), 16.0f));
        Drawable r51 = r50;
    L129:
        r49.setBackground(r51);
        int r52 = UIUtils.dp2px(requireContext(), 20.0f);
        Context r53 = requireContext();
        if (r1 == false) goto L132;
        r119 = 20.0f;
    L132:
        int r54 = UIUtils.dp2px(r53, r119);
        ScsFragmentCustomNoPermissionBinding r55 = this.h;
        if (r55 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r55 = null;
    L135:
        r55.c.setPadding(r52, r54, r52, r54);
        ScsFragmentCustomNoPermissionBinding r56 = this.h;
        if (r56 != null) goto L138;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r56 = null;
    L138:
        NestedScrollView r57 = r56.g;
        ViewGroup.LayoutParams r58 = r57.getLayoutParams();
        if (r58 == null) goto L228;
        ViewGroup.MarginLayoutParams r59 = (ViewGroup.MarginLayoutParams) r58;
        Context r60 = requireContext();
        if (r1 == false) goto L143;
        float r61 = 24.0f;
    L144:
        r59.leftMargin = UIUtils.dp2px(r60, r61);
        Context r62 = requireContext();
        if (r1 == false) goto L147;
        float r63 = 24.0f;
    L148:
        r59.rightMargin = UIUtils.dp2px(r62, r63);
        r57.setLayoutParams(r59);
        ScsFragmentCustomNoPermissionBinding r64 = this.h;
        if (r64 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r64 = null;
    L151:
        LinearLayoutCompat r65 = r64.b;
        ViewGroup.LayoutParams r66 = r65.getLayoutParams();
        if (r66 == null) goto L226;
        ViewGroup.MarginLayoutParams r67 = (ViewGroup.MarginLayoutParams) r66;
        Context r68 = requireContext();
        if (r1 == false) goto L156;
        float r69 = 24.0f;
    L157:
        r67.leftMargin = UIUtils.dp2px(r68, r69);
        Context r70 = requireContext();
        if (r1 == false) goto L160;
        float r71 = 24.0f;
    L161:
        r67.rightMargin = UIUtils.dp2px(r70, r71);
        Context r72 = requireContext();
        if (r1 == true) goto L165;
        r120 = 0.0f;
    L165:
        r67.topMargin = UIUtils.dp2px(r72, r120);
        Context r73 = requireContext();
        if (r1 == false) goto L168;
        float r131 = 0.0f;
    L169:
        r67.bottomMargin = UIUtils.dp2px(r73, r131);
        r65.setLayoutParams(r67);
        ScsFragmentCustomNoPermissionBinding r74 = this.h;
        if (r74 != null) goto L172;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r74 = null;
    L172:
        t4c.b.a(r74.i);
        ScsFragmentCustomNoPermissionBinding r75 = this.h;
        if (r75 != null) goto L175;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r75 = null;
    L175:
        t4c.b.a(r75.h.c);
        ScsFragmentCustomNoPermissionBinding r76 = this.h;
        if (r76 != null) goto L178;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r76 = null;
    L178:
        r76.f.setText(BuildConfig.FLAVOR);
        ScsFragmentCustomNoPermissionBinding r77 = this.h;
        if (r77 != null) goto L181;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r77 = null;
    L181:
        t4c.b.a(r77.f);
        ScsFragmentCustomNoPermissionBinding r78 = this.h;
        if (r78 != null) goto L184;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r78 = null;
    L184:
        r78.d.setText(BuildConfig.FLAVOR);
        ScsFragmentCustomNoPermissionBinding r79 = this.h;
        if (r79 != null) goto L187;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r79 = null;
    L187:
        t4c.b.a(r79.d);
        ScsFragmentCustomNoPermissionBinding r80 = this.h;
        if (r80 != null) goto L190;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r80 = null;
    L190:
        r80.e.setText(BuildConfig.FLAVOR);
        ScsFragmentCustomNoPermissionBinding r81 = this.h;
        if (r81 != null) goto L193;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r81 = null;
    L193:
        t4c.b.a(r81.e);
        ScsFragmentCustomNoPermissionBinding r82 = this.h;
        if (r82 != null) goto L196;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r82 = null;
    L196:
        r82.c.removeAllViews();
        ScsFragmentCustomNoPermissionBinding r83 = this.h;
        if (r83 != null) goto L199;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r83 = null;
    L199:
        t4c.b.a(r83.c);
        ScsFragmentCustomNoPermissionBinding r84 = this.h;
        if (r84 != null) goto L202;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r84 = null;
    L202:
        r84.b.removeAllViews();
        ScsFragmentCustomNoPermissionBinding r85 = this.h;
        if (r85 != null) goto L205;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r85 = null;
    L205:
        t4c.b.a(r85.b);
        ScsFragmentCustomNoPermissionBinding r86 = this.h;
        if (r86 != null) goto L208;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r86 = null;
    L208:
        NestedScrollView r87 = r86.g;
        ViewGroup.LayoutParams r88 = r87.getLayoutParams();
        if (r88 == null) goto L224;
        r88.height = -2;
        r87.setLayoutParams(r88);
        ScsFragmentCustomNoPermissionBinding r89 = this.h;
        if (r89 != null) goto L213;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r89 = null;
    L213:
        r89.g.setMinimumHeight(0);
        ScsFragmentCustomNoPermissionBinding r90 = this.h;
        if (r90 != null) goto L216;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        ScsFragmentCustomNoPermissionBinding r91 = null;
    L217:
        NestedScrollView r92 = r91.g;
        ViewGroup.LayoutParams r93 = r92.getLayoutParams();
        if (r93 == null) goto L222;
        ViewGroup.MarginLayoutParams r94 = (ViewGroup.MarginLayoutParams) r93;
        r94.topMargin = 0;
        r94.bottomMargin = 0;
        r92.setLayoutParams(r94);
        return;
    L222:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L216:
        r91 = r90;
        goto L217
    L224:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L168:
        r131 = 16.0f;
        goto L169
    L160:
        r71 = 16.0f;
        goto L161
    L156:
        r69 = 16.0f;
        goto L157
    L226:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L147:
        r63 = 16.0f;
        goto L148
    L143:
        r61 = 16.0f;
        goto L144
    L228:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L128:
        r51 = ContextCompat.getDrawable(requireContext(), 2131256314);
        goto L129
    L115:
        r127 = 4.0f;
        goto L116
    L62:
        r121 = 12.0f;
        goto L63
    L58:
        r118 = 16.0f;
        goto L59
    L54:
        r22 = 16.0f;
        goto L55
    L230:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L48:
        r114 = 2131106622;
        goto L49
    L41:
        r110 = 24.0f;
        goto L42
    L34:
        r18 = 10.0f;
        goto L35
    L30:
        r16 = 40.0f;
        goto L31
    L232:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L17:
        r12 = 100.0f;
        goto L18
    L234:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L5:
        r1 = false;
        goto L6
    }

    public final boolean Y90() {
        Context r0 = getContext();
        if (r0 != null) goto L17;
        return true;
    L17:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        LarkAppContext.Companion.getClass();     // Catch: Throwable -> L7
        Object r3 = Result.constructor-impl((com.ss.android.lark.endpoint.security.detection.location.a) e0c.k.a(LarkAppContext.access$getInstance$cp().getContext(), com.ss.android.lark.endpoint.security.detection.location.a.class));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r3) == false) goto L12;
        r3 = null;
    L12:
        com.ss.android.lark.endpoint.security.detection.location.a r4 = (com.ss.android.lark.endpoint.security.detection.location.a) r3;
        if (r4 != null) goto L15;
        return true;
    L15:
        r4.isGpsSupported(r0);
        return false;
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStart() {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onStart();
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "onStart()");
        if (this.n == false) goto L6;
        aa0("on_start");
        this.n = false;
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m981provideComponent() {
        return provideComponent();
    }

    public final NoPermissionType getType() {
        return this.f;
    }

    public CustomNoPermissionFragment(NoPermissionType r4) {
        Intrinsics.checkNotNullParameter(r4, IPortraitService.TYPE);
        this.f = r4;
        final Function0<Fragment> r5 = new CustomNoPermissionFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NoPermissionViewModel.class), new CustomNoPermissionFragment$special$$inlined$viewModels$default$2(r5), new CustomNoPermissionFragment$special$$inlined$viewModels$default$3(r5, this));
        this.o = CustomDisplayPageUiMode.LARK;
    }

    public static void T90(UDDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public final void U90(CustomDisplayPageUiMode r6) {
        if (r6 == CustomDisplayPageUiMode.LARK) goto L5;
        boolean r7 = true;
    L6:
        ScsFragmentCustomNoPermissionBinding r0 = this.h;
        ScsFragmentCustomNoPermissionBinding r1 = null;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L9:
        TextView r2 = r0.h.e;
        r2.setTextAppearance(requireContext(), 2131953919);
        Context r3 = requireContext();
        if (r7 == false) goto L12;
        int r4 = 2131101391;
    L13:
        r2.setTextColor(ContextCompat.getColor(r3, r4));
        ScsFragmentCustomNoPermissionBinding r5 = this.h;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L17:
        TextView r8 = r1.h.d;
        r8.setTextAppearance(requireContext(), 2131953910);
        Context r9 = requireContext();
        if (r7 == false) goto L20;
        int r10 = 2131101392;
    L21:
        r8.setTextColor(ContextCompat.getColor(r9, r10));
        return;
    L20:
        r10 = 2131106607;
        goto L21
    L16:
        r1 = r5;
        goto L17
    L12:
        r4 = 2131106622;
        goto L13
    L5:
        r7 = false;
        goto L6
    }

    public final void V90(CustomDisplayPageUiMode r6) {
        this.o = r6;
        AirActivity r0 = getActivity();
        NoPermissionActivity.d r2 = null;
        if ((r0 instanceof NoPermissionActivity) == false) goto L5;
        AirActivity r1 = (NoPermissionActivity) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        CustomDisplayPageUiMode r3 = CustomDisplayPageUiMode.LARK;
        if (r6 != r3) goto L33;
        r1.k = r3;
        NoPermissionActivity.d r7 = r1.d;
        if (r7 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r7 = null;
    L13:
        r7.b().setFitsSystemWindows(true);
        NoPermissionActivity.d r8 = r1.d;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r8 = null;
    L16:
        t4c.b.b(r8.e());
        r1.I1();
        r1.getWindow().setNavigationBarColor(r1.i);
        NoPermissionActivity.z1(r1.getWindow()).setSystemUiVisibility(r1.j);
        NoPermissionActivity.d r9 = r1.d;
        if (r9 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r9 = null;
    L19:
        r9.a().setTextAppearance(r1, 2131953910);
        NoPermissionActivity.d r10 = r1.d;
        if (r10 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r10 = null;
    L22:
        r10.a().setTypeface(h18.e.b(r1, 0));
        NoPermissionActivity.d r11 = r1.d;
        if (r11 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r11 = null;
    L25:
        r11.a().setTextSize(14.0f);
        NoPermissionActivity.d r12 = r1.d;
        if (r12 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r12 = null;
    L28:
        r12.a().setTextColor(r1.getResources().getColor(2131105548));
        NoPermissionActivity.d r13 = r1.d;
        if (r13 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L32:
        r2.b().setBackgroundColor(ContextCompat.getColor(r1, 2131100548));
        return;
    L31:
        r2 = r13;
        goto L32
    L33:
        r1.A1(r6);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void aa0(String r3) {
        Intrinsics.checkNotNullParameter(r3, "pingSource");
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "ping()");
        W90().ping(r3, this.i);
    }

    public final void ha0(boolean r5) {
        int r0 = com.ss.android.lark.conditional.access.nopermission.ui.custom.d.a;
        CustomDisplayPageUiMode r1 = com.ss.android.lark.conditional.access.nopermission.ui.custom.d.a(this.f, this.i);
        V90(r1);
        U90(r1);
        showEmptyView();
        ScsFragmentCustomNoPermissionBinding r2 = this.h;
        ScsFragmentCustomNoPermissionBinding r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r2 = null;
    L5:
        t4c.b.b(r2.h.c);
        if (r5 == false) goto L17;
        ScsFragmentCustomNoPermissionBinding r6 = this.h;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r6 = null;
    L10:
        r6.h.e.setText(requireContext().getText(2131892476));
        ScsFragmentCustomNoPermissionBinding r7 = this.h;
        if (r7 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r7 = null;
    L13:
        t4c.b.b(r7.h.e);
        ScsFragmentCustomNoPermissionBinding r8 = this.h;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r8 = null;
    L16:
        t4c.b.a(r8.h.d);
    L30:
        ScsFragmentCustomNoPermissionBinding r9 = this.h;
        if (r9 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L34:
        r3.h.b.playAnimation();
        return;
    L33:
        r3 = r9;
        goto L34
    L17:
        ScsFragmentCustomNoPermissionBinding r10 = this.h;
        if (r10 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r10 = null;
    L20:
        r10.h.e.setText(requireContext().getText(2131890511));
        ScsFragmentCustomNoPermissionBinding r11 = this.h;
        if (r11 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r11 = null;
    L23:
        t4c.b.b(r11.h.e);
        ScsFragmentCustomNoPermissionBinding r12 = this.h;
        if (r12 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r12 = null;
    L26:
        r12.h.d.setText(requireContext().getText(2131890512));
        ScsFragmentCustomNoPermissionBinding r13 = this.h;
        if (r13 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r13 = null;
    L29:
        t4c.b.b(r13.h.d);
        goto L30
    }

    public final void fa0(CustomDisplayHandler r3, boolean r4) {
        if (isAdded() == true) goto L5;
        return;
    L5:
        ScsFragmentCustomNoPermissionBinding r0 = this.h;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L8:
        ConstraintLayout r1 = r0.a;
        r1.post(new n(this, r1, r3, r4));
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.e
    public final void nb(CustomDisplayHandler r17, Context r18) {
        Intrinsics.checkNotNullParameter(r17, "handler");
        Intrinsics.checkNotNullParameter(r18, "context");
        String r1 = (String) r17.link.get("mobile");
        String r2 = BuildConfig.FLAVOR;
        if (r1 != null) goto L7;
        r1 = (String) r17.link.get("general");
        if (r1 != null) goto L7;
        r1 = BuildConfig.FLAVOR;
    L7:
        String r0 = (String) r17.params.get("domainKey");
        Uri r3 = UriProtector.parse(r1);
        String r4 = r3.getHost();
        boolean r5 = false;
        if (r4 != null) goto L10;
    L15:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L19;
        r2 = r3.toString();
        Intrinsics.checkNotNull(r2);
    L29:
        String r7 = StringsKt.replace$default(((apb.a) e0c.k.a(requireActivity().getApplication(), apb.a.class)).g(), '_', '-', false, 4, null);
        HttpUrl r8 = HttpUrl.parse(r2);
        if (r8 == null) goto L34;
        HttpUrl.a r9 = r8.newBuilder();
        if (r9 == null) goto L34;
        r9.a("language", r7);
        URL r10 = r9.b().url();
    L35:
        if (r10 == null) goto L45;
        String r11 = r10.toString();
        if (r11 == null) goto L45;
        int r12 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "onCustomLinkClick: " + p0.d(r11));
        if (w4c.c.a().O() == false) goto L42;
        FragmentActivity r13 = getActivity();
        if (r13 == null) goto L42;
    L43:
        com.ss.android.lark.conditional.access.utils.g.a(r13, r11);
        this.n = true;
        FileAuthMonitor.UpdateTrigger[] r14 = FileAuthMonitor.a;
        FileAuthMonitor.p("CustomLink", "page", null);
        return;
    L42:
        r13 = LarkContext.getApplication();
    L45:
        return;
    L34:
        r10 = null;
        goto L35
    L19:
        if (r0 != null) goto L21;
    L26:
        if (r5 == false) goto L28;
        r2 = v4c.a.a(r0) + r1;
        goto L29
    L28:
        ScsLogger.c("SecurityPolicy_CustomNoPermissionFragment", "domainAlias is empty!");
        FileAuthMonitor.UpdateTrigger[] r15 = FileAuthMonitor.a;
        FileAuthMonitor.p("CustomLink", "page", "domainAlias is empty. link: ".concat(r1));
        goto L29
    L21:
        if (r0.length() <= 0) goto L23;
        boolean r16 = true;
    L24:
        if (r16 != true) goto L26;
        r5 = true;
        goto L26
    L23:
        r16 = false;
        goto L24
    L10:
        if (r4.length() <= 0) goto L12;
        boolean r19 = true;
    L13:
        if (r19 != true) goto L15;
        r6 = true;
        goto L17
    L12:
        r19 = false;
        goto L13
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "onViewCreated");
        FileAuthMonitor.UpdateTrigger[] r4 = FileAuthMonitor.a;
        FileAuthMonitor.d(this.i, "show", this.f);
        V90(CustomDisplayPageUiMode.LARK);
        this.j = false;
        parseData();
        W90().getPingLiveData().observe(getViewLifecycleOwner(), new f(this));
        W90().getDisplayTemplateLiveData().observe(getViewLifecycleOwner(), new g(this));
        W90().getNewMFAStatusLiveData().observe(getViewLifecycleOwner(), new h(this));
        W90().getDeviceApplySwitchLiveDataV2().observe(getViewLifecycleOwner(), new i(this));
        W90().getUserConfirmLiveData().observe(getViewLifecycleOwner(), new j(this));
        W90().getAuthLiveData().observe(getViewLifecycleOwner(), new k(this));
        W90().getCertAuthLiveData().observe(getViewLifecycleOwner(), new l(this));
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.f0
    public final void Dx(CustomDisplayHandler r4, InternalSecurityAction r5, Context r6) {
        Intrinsics.checkNotNullParameter(r4, "handler");
        Intrinsics.checkNotNullParameter(r6, "context");
        FileAuthMonitor.UpdateTrigger[] r0 = FileAuthMonitor.a;
        FileAuthMonitor.p("DeviceCertAuth", "page", null);
        if (ia0(r4, "DeviceCertAuth", r5, r6) == false) goto L6;
        return;
    L6:
        if (Z90(r4, "DeviceCertAuth", r5, r6) == false) goto L15;
        return;
    L15:
        qqb.a.h(BuildConfig.FLAVOR);     // Catch: Throwable -> L12
        this.l = W90().startDeviceCertAuthentication(qqb.a.d(), "noPermissionReCertAuthButton");     // Catch: Throwable -> L12
        qqb.a.a();
        return;
    L12:
        th = move-exception;
        qqb.a.a();
        throw th;
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.d0
    public final void Fw(CustomDisplayHandler r4, InternalSecurityAction r5, Context r6) {
        Intrinsics.checkNotNullParameter(r4, "handler");
        Intrinsics.checkNotNullParameter(r6, "context");
        FileAuthMonitor.UpdateTrigger[] r0 = FileAuthMonitor.a;
        FileAuthMonitor.p("DeviceApply", "page", null);
        if (ia0(r4, "DeviceApply", r5, r6) == false) goto L6;
        return;
    L6:
        if (Z90(r4, "DeviceApply", r5, r6) == false) goto L8;
        return;
    L8:
        W90().getDeviceApplySwitchDataV2();
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.b
    public final void KT(CustomDisplayHandler r1, InternalSecurityAction r2, Context r3) {
        Intrinsics.checkNotNullParameter(r1, "handler");
        Intrinsics.checkNotNullParameter(r3, "context");
        ScsLogger.c("SecurityPolicy_CustomNoPermissionFragment", "onCancelButtonClick");
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.i0
    public final void QY(CustomDisplayHandler r20, InternalSecurityAction r21, Context r22) {
        Intrinsics.checkNotNullParameter(r20, "handler");
        Intrinsics.checkNotNullParameter(r22, "context");
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "onGeoAuthButtonClick");
        FileAuthMonitor.UpdateTrigger[] r0 = FileAuthMonitor.a;
        ScsFragmentCustomNoPermissionBinding r5 = null;
        FileAuthMonitor.p("GeoAuth", "page", null);
        com.ss.android.lark.conditional.access.utils.a.b("geo_auth_now", r21);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        LarkAppContext.Companion.getClass();     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl((scb.b) e0c.k.b(((com.ss.android.lark.passportc.internal.v) e0c.k.a(LarkAppContext.access$getInstance$cp().getContext(), com.ss.android.lark.passportc.internal.v.class)).c(PassportcConvention.b(this)), scb.b.class));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r2) == false) goto L10;
        r2 = null;
    L10:
        scb.b r3 = (scb.b) r2;
        if (r3 != null) goto L14;
        ScsLogger.c("SecurityPolicy_CustomNoPermissionFragment", "onGeoAuthButtonClick: SPI unavailable");
        com.ss.android.lark.conditional.access.utils.a.e("geo_auth", false, -1, "system_error", 0, r21);
        return;
    L14:
        ScsFragmentCustomNoPermissionBinding r4 = this.h;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r4 = null;
    L17:
        KeyEvent.Callback r6 = r4.a.findViewWithTag(r20.type);
        if ((r6 instanceof u8b.b) == false) goto L20;
        u8b.b r8 = (u8b.b) r6;
    L21:
        long r7 = System.currentTimeMillis();
        ScsFragmentCustomNoPermissionBinding r9 = this.h;
        if (r9 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L25:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CustomNoPermissionFragment$onGeoAuthButtonClick$1(r3, this, r22, r7, r5.a, r8, null), 3, null);
        return;
    L24:
        r5 = r9;
        goto L25
    L20:
        r8 = null;
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.j0
    public final void To(CustomDisplayHandler r4, InternalSecurityAction r5, Context r6) {
        Intrinsics.checkNotNullParameter(r4, "handler");
        Intrinsics.checkNotNullParameter(r6, "context");
        FileAuthMonitor.UpdateTrigger[] r7 = FileAuthMonitor.a;
        FileAuthMonitor.p("MFA", "page", null);
        String r8 = (String) r4.params.get("acSettings");
        String r9 = BuildConfig.FLAVOR;
        if (r8 != null) goto L5;
        r8 = BuildConfig.FLAVOR;
    L5:
        String r0 = (String) r4.params.get("customContent");
        if (r0 != null) goto L8;
        r0 = BuildConfig.FLAVOR;
    L8:
        String r1 = (String) r4.params.get("mfaParams");
        if (r1 != null) goto L11;
        r1 = BuildConfig.FLAVOR;
    L11:
        String r10 = (String) r4.params.get("scope");
        if (r10 == null) goto L15;
        r9 = r10;
    L15:
        JSONObject r11 = new JSONObject();
        r11.put("ac_setting", JSON.parseObject(r8));
        r11.put("custom_content", JSON.parseObject(r0));
        r11.put("extra", r1);
        W90().startNewMfaAuth(requireActivity(), r9, r11, r1);
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.k0
    public final void VB(CustomDisplayHandler r15, InternalSecurityAction r16, Context r17) {
        Intrinsics.checkNotNullParameter(r15, "handler");
        Intrinsics.checkNotNullParameter(r17, "context");
        this.p = false;
        FileAuthMonitor.UpdateTrigger[] r0 = FileAuthMonitor.a;
        Object r3 = null;
        FileAuthMonitor.p("RetryAccess", "page", null);
        if (r16 == null) goto L5;
        Integer r2 = DisplayUtilsKt.c(r16);
    L45:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        Object r4 = Result.constructor-impl(Boolean.valueOf(w4c.c.a().G()));     // Catch: Throwable -> L8
    L10:
        Boolean r5 = Boolean.TRUE;
        if (Result.isFailure-impl(r4) == false) goto L14;
        r4 = r5;
    L14:
        if (((Boolean) r4).booleanValue() == false) goto L43;
        if (r2 == null) goto L43;
        if (r16 == null) goto L43;
        Integer r6 = DisplayUtilsKt.c(r16);
        if (r6 != null) goto L21;
    L23:
        boolean r7 = false;
    L24:
        Context r8 = getActivity();
        if (r8 != null) goto L30;
        r8 = getContext();
        if (r8 != null) goto L30;
        ScsLogger.c("SecurityPolicy_CustomNoPermissionFragment", "refreshWithGeoFactors: no context, fallback to ping");
        aa0("refresh_button");
        return;
    L30:
        Context r9 = r8;
        LarkAppContext.Companion.getClass();     // Catch: Throwable -> L33
        Object r10 = Result.constructor-impl((scb.b) e0c.k.b(((com.ss.android.lark.passportc.internal.v) e0c.k.a(LarkAppContext.access$getInstance$cp().getContext(), com.ss.android.lark.passportc.internal.v.class)).c(PassportcConvention.b(this)), scb.b.class));     // Catch: Throwable -> L33
    L36:
        if (Result.isFailure-impl(r10) == true) goto L39;
        r3 = r10;
    L39:
        scb.b r11 = (scb.b) r3;
        if (r11 != null) goto L42;
        ScsLogger.c("SecurityPolicy_CustomNoPermissionFragment", "refreshWithGeoFactors: SPI unavailable, fallback to ping");
        aa0("refresh_button");
        return;
    L42:
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "refreshWithGeoFactors: report begin");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CustomNoPermissionFragment$refreshWithGeoFactors$1(r11, this, r9, r7, null), 3, null);
        return;
    L33:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L21:
        if (r6.intValue() != 2) goto L23;
        r7 = true;
    L43:
        aa0("refresh_button");
        return;
    L8:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L5:
        r2 = null;
        goto L45
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.e0
    public final void Vy(CustomDisplayHandler r4, InternalSecurityAction r5, Context r6) {
        Intrinsics.checkNotNullParameter(r4, "handler");
        Intrinsics.checkNotNullParameter(r6, "context");
        FileAuthMonitor.UpdateTrigger[] r0 = FileAuthMonitor.a;
        FileAuthMonitor.p("DeviceAuth", "page", null);
        if (ia0(r4, "DeviceAuth", r5, r6) == false) goto L6;
        return;
    L6:
        if (Z90(r4, "DeviceAuth", r5, r6) == false) goto L15;
        return;
    L15:
        qqb.a.h(BuildConfig.FLAVOR);     // Catch: Throwable -> L12
        this.l = W90().startDeviceAuthentication(qqb.a.d());     // Catch: Throwable -> L12
        qqb.a.a();
        return;
    L12:
        th = move-exception;
        qqb.a.a();
        throw th;
    }

    public final void X90(TextView r3, String r4, int r5) {
        r3.setText(DisplayUtilsKt.f(r4, requireContext(), new CustomNoPermissionFragment$handleRichText$cs$1(this)));
        r3.setTextColor(ContextCompat.getColor(r3.getContext(), r5));
        r3.setTextAlignment(4);
        r3.setGravity(17);
        r3.setMovementMethod(LinkMovementMethod.getInstance());
        bab.b.a(r3);
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.a
    public final boolean dL(CustomDisplayHandler r1, InternalSecurityAction r2, Context r3) {
        return com.ss.android.lark.conditional.access.nopermission.ui.custom.a.C0157a.a(this, r1, r2, r3);
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.c
    public final void eG(CustomDisplayHandler r4, InternalSecurityAction r5, Context r6) {
        Intrinsics.checkNotNullParameter(r4, "handler");
        Intrinsics.checkNotNullParameter(r6, "context");
        String r7 = (String) r4.link.get("mobile");
        if (r7 != null) goto L7;
        r7 = (String) r4.link.get("general");
        if (r7 != null) goto L7;
        r7 = BuildConfig.FLAVOR;
    L7:
        String r8 = "lark://applink".concat(r7);
        if (ova.f.m().i(LarkContext.getApplication(), r8, 14) == false) goto L10;
        ova.f.m().y(LarkContext.getApplication(), r8, 14);
        this.n = true;
        FileAuthMonitor.UpdateTrigger[] r9 = FileAuthMonitor.a;
        FileAuthMonitor.p("CustomAppLink", "page", null);
        return;
    L10:
        FileAuthMonitor.UpdateTrigger[] r10 = FileAuthMonitor.a;
        FileAuthMonitor.p("CustomAppLink", "page", "can not open internal. link: " + r8);
    }

    public final void ea0(CustomDisplayTemplate r18, int r19, int r20) {
        int r3 = com.ss.android.lark.conditional.access.nopermission.ui.custom.d.a;
        CustomDisplayPageUiMode r4 = com.ss.android.lark.conditional.access.nopermission.ui.custom.d.a(this.f, this.i);
        V90(r4);
        showEmptyView();
        CustomDisplayPageUiMode r5 = CustomDisplayPageUiMode.LARK;
        int r6 = 0;
        ScsFragmentCustomNoPermissionBinding r8 = null;
        if (r4 == r5) goto L12;
        ScsFragmentCustomNoPermissionBinding r2 = this.h;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r2 = null;
    L7:
        r2.j.setImageTintList(null);
        ScsFragmentCustomNoPermissionBinding r7 = this.h;
        if (r7 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r7 = null;
    L10:
        r7.j.setImageResource(2131247526);
    L30:
        if (r18.title.length() <= 0) goto L32;
        boolean r9 = true;
    L33:
        if (r9 == false) goto L41;
        ScsFragmentCustomNoPermissionBinding r10 = this.h;
        if (r10 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r10 = null;
    L37:
        t4c.b.b(r10.f);
        ScsFragmentCustomNoPermissionBinding r11 = this.h;
        if (r11 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r11 = null;
    L40:
        r11.f.setText(r18.title);
    L41:
        String r12 = r18.text + r18.richText;
        if (r12.length() <= 0) goto L44;
        boolean r13 = true;
    L45:
        int r14 = 2131101392;
        if (r13 == false) goto L59;
        ScsFragmentCustomNoPermissionBinding r15 = this.h;
        if (r15 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r15 = null;
    L50:
        t4c.b.b(r15.d);
        if (r4 != r5) goto L53;
        int r16 = r20;
    L54:
        ScsFragmentCustomNoPermissionBinding r17 = this.h;
        if (r17 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r17 = null;
    L57:
        X90(r17.d, r12, r16);
        goto L59
    L53:
        r16 = 2131101392;
    L59:
        if (w4c.c.a().S() == true) goto L61;
        String r21 = null;
    L62:
        if (r21 != null) goto L64;
    L67:
        boolean r22 = true;
    L69:
        if (r22 == true) goto L80;
        ScsFragmentCustomNoPermissionBinding r23 = this.h;
        if (r23 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r23 = null;
    L73:
        t4c.b.b(r23.e);
        ScsFragmentCustomNoPermissionBinding r24 = this.h;
        if (r24 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r24 = null;
    L76:
        TextView r25 = r24.e;
        if (r4 != r5) goto L79;
        r14 = 2131106607;
    L79:
        X90(r25, r21, r14);
    L101:
        int r26 = -2;
        if ((!r18.content_list.isEmpty()) == false) goto L149;
        ScsFragmentCustomNoPermissionBinding r27 = this.h;
        if (r27 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r27 = null;
    L106:
        t4c.b.b(r27.c);
        ScsFragmentCustomNoPermissionBinding r28 = this.h;
        if (r28 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r28 = null;
    L109:
        NestedScrollView r29 = r28.g;
        if (r4 != r5) goto L112;
        int r110 = UIUtils.dp2px(requireContext(), 120.0f);
    L113:
        r29.setMinimumHeight(r110);
        ScsFragmentCustomNoPermissionBinding r30 = this.h;
        if (r30 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r30 = null;
    L116:
        NestedScrollView r31 = r30.g;
        ViewGroup.LayoutParams r111 = r31.getLayoutParams();
        if (r111 == null) goto L148;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
        Context r113 = requireContext();
        if (r4 != r5) goto L121;
        float r114 = 12.0f;
    L122:
        r112.topMargin = UIUtils.dp2px(r113, r114);
        Context r115 = requireContext();
        if (r4 != r5) goto L125;
        float r32 = 8.0f;
    L126:
        r112.bottomMargin = UIUtils.dp2px(r115, r32);
        r31.setLayoutParams(r112);
        Iterator r33 = r18.content_list.iterator();
        int r34 = 0;
    L128:
        if (r33.hasNext() == false) goto L149;
        Object r116 = r33.next();
        int r117 = r34 + 1;
        if (r34 >= 0) goto L132;
        CollectionsKt.throwIndexOverflow();
    L132:
        CustomDisplayContent r118 = (CustomDisplayContent) r116;
        u8b.a r119 = new u8b.a(requireContext(), 0);
        Intrinsics.checkNotNull(r118);
        r119.b(r118, this.i, this, r4);
        ScsFragmentCustomNoPermissionBinding r120 = this.h;
        if (r120 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r120 = r8;
    L135:
        LinearLayout r121 = r120.c;
        LinearLayout.LayoutParams r122 = new LinearLayout.LayoutParams(-1, r26);
        CustomDisplayPageUiMode r35 = CustomDisplayPageUiMode.LARK;
        if (r4 != r35) goto L138;
        float r36 = h18.d.b(requireContext(), 8);
    L140:
        int r37 = (int) r36;
    L142:
        r122.topMargin = r37;
        if (r4 != r35) goto L145;
        int r38 = (int) h18.d.b(requireContext(), 8);
    L146:
        r122.bottomMargin = r38;
        Unit r39 = Unit.INSTANCE;
        r121.addView(r119, r122);
        r34 = r117;
        r8 = null;
        r26 = -2;
        goto L128
    L145:
        r38 = 0;
        goto L146
    L138:
        if (r34 <= 0) goto L141;
        r36 = h18.d.b(requireContext(), 20);
        goto L140
    L141:
        r37 = 0;
        goto L142
    L125:
        r32 = 0.0f;
        goto L126
    L121:
        r114 = 20.0f;
        goto L122
    L148:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L112:
        r110 = 0;
    L149:
        List r1 = r18.handler_list;
        ArrayList r40 = new ArrayList();
        Iterator r41 = r1.iterator();
    L151:
        if (r41.hasNext() == false) goto L156;
        Object r42 = r41.next();
        CustomDisplayHandler r43 = (CustomDisplayHandler) r42;
        Intrinsics.checkNotNull(r43);
        if (com.ss.android.lark.conditional.access.utils.b.a(r43) == false) goto L151;
        r40.add(r42);
        goto L151
    L156:
        if ((!r40.isEmpty()) == false) goto L215;
        ScsFragmentCustomNoPermissionBinding r44 = this.h;
        if (r44 != null) goto L160;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r44 = null;
    L160:
        t4c.b.b(r44.b);
        Iterator r45 = r40.iterator();
        int r46 = 0;
    L162:
        if (r45.hasNext() == false) goto L215;
        Object r47 = r45.next();
        int r48 = r46 + 1;
        if (r46 >= 0) goto L166;
        CollectionsKt.throwIndexOverflow();
    L166:
        CustomDisplayHandler r49 = (CustomDisplayHandler) r47;
        AppCompatButton r50 = new CustomDisplayUDButton(requireContext());
        Intrinsics.checkNotNull(r49);
        InternalSecurityAction r123 = this.i;
        Intrinsics.checkNotNullParameter(r49, "handler");
        Intrinsics.checkNotNullParameter(this, "buttonTypeFunction");
        Intrinsics.checkNotNullParameter(r4, "pageUiMode");
        r50.setOnClickListener(r50);
        r50.setTag(r49.type);
        r50.a = r49;
        r50.b = r123;
        r50.c = this;
        r50.setText(r49.name);
        CustomDisplayPageUiMode r124 = CustomDisplayPageUiMode.LARK;
        if (r4 != r124) goto L169;
        String r51 = r49.style;
        if (Intrinsics.areEqual(r51, "secondary") == false) goto L202;
        r50.applyStyle(2131953828);
        r50.setTextAppearance(r50.getContext(), 2131953920);
        r50.setTextColor(r50.getResources().getColor(2131106622));
        r50.setTextSize(2, 17.0f);
        ColorStateList r52 = AppCompatResources.getColorStateList(r50.getContext(), 2131108893);
        r50.e = r52;
        r50.setBackgroundColor(r52);
        r50.g = 2131108893;
        r50.h = 2131106622;
        r50.setStrokeWidth(UIUtils.dp2px(r50.getContext(), 1.0f));
        r50.setStrokeColor(r50.getResources().getColor(2131103352));
    L205:
        ScsFragmentCustomNoPermissionBinding r53 = this.h;
        if (r53 != null) goto L208;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r53 = null;
    L208:
        LinearLayoutCompat r54 = r53.b;
        LinearLayoutCompat.LayoutParams r55 = new LinearLayoutCompat.LayoutParams(r50.getLayoutParams());
        if (r4 == r124) goto L213;
        if (r46 > 0) goto L213;
        int r56 = 0;
    L214:
        ((LinearLayout.LayoutParams) r55).topMargin = r56;
        Unit r57 = Unit.INSTANCE;
        r54.addView(r50, r55);
        r46 = r48;
        r6 = 0;
    L213:
        r56 = getResources().getDimensionPixelSize(2131166264);
        goto L214
    L202:
        if (Intrinsics.areEqual(r51, "primaryRed") == false) goto L204;
        r50.applyStyle(2131953828);
        r50.setTextAppearance(r50.getContext(), 2131953920);
        r50.setTextColor(r50.getResources().getColor(2131106521));
        r50.setTextSize(2, 17.0f);
        ColorStateList r58 = AppCompatResources.getColorStateList(r50.getContext(), 2131108885);
        r50.e = r58;
        r50.setBackgroundColor(r58);
        r50.g = 2131102095;
        r50.h = 2131106521;
        r50.setStrokeWidth(UIUtils.dp2px(r50.getContext(), 1.0f));
        r50.setStrokeColor(r50.getResources().getColor(2131103352));
        goto L205
    L204:
        r50.applyStyle(2131953828);
        r50.setTextAppearance(r50.getContext(), 2131953920);
        r50.setTextColor(r50.getResources().getColor(2131106521));
        r50.setTextSize(2, 17.0f);
        ColorStateList r59 = AppCompatResources.getColorStateList(r50.getContext(), 2131108881);
        r50.e = r59;
        r50.setBackgroundColor(r59);
        r50.g = 2131105550;
        r50.h = 2131106521;
        r50.setStrokeWidth(UIUtils.dp2px(r50.getContext(), 1.0f));
        goto L205
    L169:
        if (Intrinsics.areEqual(r49.type, "RetryAccess") == false) goto L171;
    L174:
        boolean r125 = true;
    L175:
        r50.applyStyle(2131953828);
        h0.a(r50, ChameleonWebViewClient.DEFAULT_SAFE_TIME);
        r50.setStrokeWidth(r6);
        Context r60 = r50.getContext();
        float r126 = 16.0f;
        if (r125 == false) goto L178;
        float r127 = 12.0f;
    L179:
        r50.setCornerRadius(UIUtils.dp2px(r60, r127));
        if (r125 == true) goto L183;
        r126 = 17.0f;
    L183:
        r50.setTextSize(2, r126);
        ViewGroup.LayoutParams r61 = r50.getLayoutParams();
        if (r61 != null) goto L187;
        r61 = new ViewGroup.LayoutParams(-1, -2);
    L187:
        Context r128 = r50.getContext();
        if (r125 == false) goto L190;
        float r129 = 44.0f;
    L191:
        r61.height = UIUtils.dp2px(r128, r129);
        r50.setLayoutParams(r61);
        if (r125 == false) goto L195;
        r50.setTextColor(CustomDisplayUDButton.a(r50.getResources().getColor(2131101388), r50.getResources().getColor(2131101388), r50.getResources().getColor(2131106610)));
        r50.f = r50.getTextColors();
        ColorStateList r62 = CustomDisplayUDButton.a(r6, r50.getResources().getColor(2131101389), r6);
        r50.e = r62;
        r50.setBackgroundColor(r62);
        r50.g = R.color.transparent;
        r50.h = 2131106610;
        goto L205
    L195:
        if (Intrinsics.areEqual(r49.style, "primaryRed") == false) goto L197;
        r50.setTextColor(CustomDisplayUDButton.a(r50.getResources().getColor(2131101390), r50.getResources().getColor(2131101390), r50.getResources().getColor(2131109013)));
        r50.f = r50.getTextColors();
        ColorStateList r63 = CustomDisplayUDButton.a(r50.getResources().getColor(2131101384), r50.getResources().getColor(2131102096), r50.getResources().getColor(2131101948));
        r50.e = r63;
        r50.setBackgroundColor(r63);
        r50.g = 2131101384;
        r50.h = 2131101390;
        goto L205
    L197:
        r50.setTextColor(CustomDisplayUDButton.a(r50.getResources().getColor(2131102022), r50.getResources().getColor(2131102063), r50.getResources().getColor(2131101393)));
        r50.f = r50.getTextColors();
        ColorStateList r64 = CustomDisplayUDButton.a(r50.getResources().getColor(2131101386), r50.getResources().getColor(2131101387), ColorUtils.setAlphaComponent(r50.getResources().getColor(2131102034), 77));
        r50.e = r64;
        r50.setBackgroundColor(r64);
        r50.g = 2131102034;
        r50.h = 2131101393;
        goto L205
    L190:
        r129 = 56.0f;
        goto L191
    L178:
        r127 = 16.0f;
        goto L179
    L171:
        if (Intrinsics.areEqual(r49.style, "secondary") == true) goto L174;
        r125 = false;
    L215:
        ScsFragmentCustomNoPermissionBinding r65 = this.h;
        if (r65 != null) goto L218;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r65 = null;
    L218:
        t4c.b.b(r65.i);
        ScsFragmentCustomNoPermissionBinding r66 = this.h;
        if (r66 != null) goto L221;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        ScsFragmentCustomNoPermissionBinding r67 = null;
    L222:
        r67.i.post(new m(this));
        return;
    L221:
        r67 = r66;
        goto L222
    L80:
        String r68 = r18.sub_text;
        if (r68 != null) goto L83;
    L86:
        boolean r69 = true;
    L87:
        if (r69 == true) goto L101;
        ScsFragmentCustomNoPermissionBinding r70 = this.h;
        if (r70 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r70 = null;
    L91:
        t4c.b.b(r70.e);
        ScsFragmentCustomNoPermissionBinding r71 = this.h;
        if (r71 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r71 = null;
    L94:
        r71.e.setText(r18.sub_text);
        ScsFragmentCustomNoPermissionBinding r72 = this.h;
        if (r72 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r72 = null;
    L97:
        TextView r73 = r72.e;
        Context r74 = requireContext();
        if (r4 != r5) goto L100;
        r14 = 2131106607;
    L100:
        r73.setTextColor(ContextCompat.getColor(r74, r14));
        goto L101
    L83:
        if (r68.length() == 0) goto L86;
        r69 = false;
        goto L87
    L64:
        if (r21.length() == 0) goto L67;
        r22 = false;
        goto L69
    L61:
        r21 = r18.sub_rich_text;
        goto L62
    L44:
        r13 = false;
        goto L45
    L32:
        r9 = false;
        goto L33
    L12:
        if (r18.icon.length() <= 0) goto L14;
        boolean r75 = true;
    L15:
        if (r75 == true) goto L17;
    L22:
        ScsFragmentCustomNoPermissionBinding r76 = this.h;
        if (r76 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r76 = null;
    L25:
        r76.j.setImageTintList(null);
        ScsFragmentCustomNoPermissionBinding r77 = this.h;
        if (r77 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r77 = null;
    L28:
        r77.j.setImageResource(r19);
        goto L30
    L17:
        if (n0.c(r18.icon) == false) goto L22;
        IRequestCreator r78 = ImageLoader.with(this).load(r18.icon).error(r19).setErrorScaleType(ImageView.ScaleType.FIT_CENTER).fitCenter();
        ScsFragmentCustomNoPermissionBinding r79 = this.h;
        if (r79 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r79 = null;
    L21:
        r78.into(r79.j);
        goto L30
    L14:
        r75 = false;
        goto L15
    }

    public final View onCreateView(LayoutInflater r12, ViewGroup r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        ConstraintLayout r15 = r12.inflate(2131564433, r13, false);
        int r16 = 2131368367;
        LinearLayoutCompat r2 = ViewBindings.findChildViewById(r15, 2131368367);
        if (r2 == null) goto L23;
        r16 = 2131368369;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131368369);
        if (r3 == null) goto L23;
        r16 = 2131368460;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r15, 2131368460);
        if (r4 == null) goto L23;
        r16 = 2131368466;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r15, 2131368466);
        if (r5 == null) goto L23;
        r16 = 2131368470;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r15, 2131368470);
        if (r6 == null) goto L23;
        r16 = 2131375307;
        NestedScrollView r7 = ViewBindings.findChildViewById(r15, 2131375307);
        if (r7 == null) goto L23;
        r16 = 2131379091;
        View r17 = ViewBindings.findChildViewById(r15, 2131379091);
        if (r17 == null) goto L23;
        ScsWidgetLoadingViewBinding r8 = ScsWidgetLoadingViewBinding.a(r17);
        r16 = 2131380912;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131380912);
        if (r9 == null) goto L23;
        r16 = 2131389100;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r15, 2131389100);
        if (r10 == null) goto L23;
        ScsFragmentCustomNoPermissionBinding r18 = new ScsFragmentCustomNoPermissionBinding(r15, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        this.h = r18;
        return r18.a;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r16)));
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.l0
    public final void qF(CustomDisplayHandler r1, InternalSecurityAction r2, Context r3) {
        Intrinsics.checkNotNullParameter(r1, "handler");
        Intrinsics.checkNotNullParameter(r3, "context");
        ScsLogger.d("SecurityPolicy_CustomNoPermissionFragment", "onSkipVerifyButtonClick");
        ca0();
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.g0
    public final void sI(CustomDisplayHandler r6, InternalSecurityAction r7, Context r8) {
        Intrinsics.checkNotNullParameter(r6, "handler");
        Intrinsics.checkNotNullParameter(r8, "context");
        FileAuthMonitor.UpdateTrigger[] r9 = FileAuthMonitor.a;
        ScsFragmentCustomNoPermissionBinding r1 = null;
        FileAuthMonitor.p("DeviceTokenClaimsChallenge", "page", null);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L9
        String r11 = DisplayUtilsKt.a(r7).get("tokenChallengeCode");     // Catch: Throwable -> L9
        if (r11 == null) goto L6;
        String r12 = StringsKt.trim(r11).toString();     // Catch: Throwable -> L9
    L7:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L9
    L11:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L15;
        int r3 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_CustomNoPermissionFragment", "parse device token claims challenge code failed: " + r14.getMessage());
    L15:
        if (Result.isFailure-impl(r13) == false) goto L17;
        r13 = null;
    L17:
        String r15 = (String) r13;
        if (r15 != null) goto L20;
    L23:
        boolean r4 = true;
    L24:
        if (r4 == false) goto L27;
        ScsLogger.c("SecurityPolicy_CustomNoPermissionFragment", "device token claims challenge code is missing");
        FileAuthMonitor.UpdateTrigger[] r16 = FileAuthMonitor.a;
        FileAuthMonitor.j("page", "missing_challenge_code", null);
        return;
    L27:
        fa0(r6, true);
        int r17 = g8b.b.a;
        g8b.b.a.a().getDependency().getPassportDependency().a(r15, new d(this, r6));
        ScsFragmentCustomNoPermissionBinding r18 = this.h;
        if (r18 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L31:
        r1.a.postDelayed(new e(this, r6), 2000);
        return;
    L30:
        r1 = r18;
        goto L31
    L20:
        if (StringsKt.isBlank(r15) == true) goto L23;
        r4 = false;
        goto L24
    L6:
        r12 = null;
    L9:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // com.ss.android.lark.conditional.access.nopermission.ui.custom.m0
    public final void uR(CustomDisplayHandler r2, InternalSecurityAction r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        Intrinsics.checkNotNullParameter(r4, "context");
        FileAuthMonitor.UpdateTrigger[] r5 = FileAuthMonitor.a;
        FileAuthMonitor.p("UserConfirm", "page", null);
        String r6 = (String) r2.params.get("confirmParams");
        if (r6 != null) goto L5;
        r6 = BuildConfig.FLAVOR;
    L5:
        W90().userConfirm(r6);
    }

    public final boolean Z90(final CustomDisplayHandler r8, String r9, InternalSecurityAction r10, Context r11) {
        List<String> r0 = OfficeSDKExternalDeviceFactorHelper.a;
        return OfficeSDKExternalDeviceFactorHelper.b(r11, r9, r10, "page", r8.type, new CustomNoPermissionFragment$openOfficeSDKExternalDeviceFactorIfNeeded$1(this, r8));
    }

    public final boolean ia0(final CustomDisplayHandler r29, final String r30, final InternalSecurityAction r31, final Context r32) {
        if (this.o != CustomDisplayPageUiMode.LARK) goto L5;
        return false;
    L5:
        int r1 = r30.hashCode();
        if (r1 == (-2055224702)) goto L20;
        if (r1 == (-1520881346)) goto L17;
        if (r1 == 97165976) goto L13;
    L21:
        return false;
    L13:
        if (r30.equals("DeviceApply") == false) goto L21;
        c r2 = new c(2131892532, 2131892531);
    L23:
        c r11 = r2;
        final Ref.ObjectRef r12 = new Ref.ObjectRef();
        Function0<Unit> r13 = new CustomNoPermissionFragment$showOpenFeishuConfirmDialogIfNeeded$contentView$1(this, r29, r30, r31, r32, r12);
        Function0<Unit> r6 = new CustomNoPermissionFragment$showOpenFeishuConfirmDialogIfNeeded$contentView$2(this, r29, r12);
        LinearLayout r7 = new LinearLayout(r32);
        r7.setOrientation(1);
        GradientDrawable r0 = new GradientDrawable();
        r0.setColor(ContextCompat.getColor(r32, 2131102028));
        r0.setCornerRadius(UIUtils.dp2px(r32, 34.0f));
        r7.setBackground(r0);
        r7.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LinearLayout r3 = new LinearLayout(r32);
        r3.setOrientation(1);
        r3.setGravity(1);
        r3.setPadding(UIUtils.dp2px(r32, 24.0f), UIUtils.dp2px(r32, 24.0f), UIUtils.dp2px(r32, 24.0f), UIUtils.dp2px(r32, 24.0f));
        TextView r4 = new TextView(r32);
        r4.setText(UIHelper.mustacheFormat(r11.a, "APP_DISPLAY_NAME", UIHelper.getString(2131891485)));
        r4.setGravity(17);
        r4.setTextAlignment(4);
        r4.setTextColor(ContextCompat.getColor(r32, 2131101391));
        r4.setTextSize(2, 18.0f);
        h0.a(r4, 600);
        TextViewCompat.setLineHeight(r4, UIUtils.dp2px(r32, 27.0f));
        r3.addView(r4, new LinearLayout.LayoutParams(-1, -2));
        TextView r5 = new TextView(r32);
        int r14 = r11.b;
        Object r19 = BuildConfig.FLAVOR;
        UDDialog r20 = null;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L39
        User r9 = ((yzb.b) e0c.k.a(LarkContext.getApplication(), yzb.b.class)).getForegroundUser();     // Catch: Throwable -> L39
        String r10 = b0c.a.a(r9);     // Catch: Throwable -> L39
        if (r10.length() <= 0) goto L27;
        boolean r22 = true;
    L28:
        if (r22 == true) goto L31;
        r10 = null;
    L31:
        if (r10 != null) goto L37;
        if (r9 == null) goto L34;
        r10 = r9.userId;     // Catch: Throwable -> L39
    L35:
        if (r10 != null) goto L37;
        r10 = BuildConfig.FLAVOR;
        goto L37
    L34:
        r10 = null;
    L37:
        Object r15 = Result.constructor-impl(r10);     // Catch: Throwable -> L39
    L42:
        if (Result.isFailure-impl(r15) == true) goto L45;
        r19 = r15;
    L45:
        String r16 = (String) r19;
        CharSequence r17 = UIHelper.mustacheFormat(r14, MapsKt.mapOf(new Pair[]{TuplesKt.to("APP_DISPLAY_NAME", UIHelper.getString(2131891485)), TuplesKt.to("user", r16)}));
        Intrinsics.checkNotNull(r17);
        int r18 = StringsKt.indexOf$default(r17, r16, 0, false, 6, null);
        if (r18 < 0) goto L55;
        if (r16.length() != 0) goto L50;
        boolean r110 = true;
    L51:
        if (r110 == true) goto L55;
        SpannableString r111 = new SpannableString(r17);
        r111.setSpan(new CustomTypefaceSpan(h0.b(requireContext(), 600)), r18, r16.length() + r18, 33);
        r17 = r111;
        goto L55
    L50:
        r110 = false;
    L55:
        r5.setText(r17);
        r5.setGravity(17);
        r5.setTextAlignment(4);
        r5.setTextColor(ContextCompat.getColor(r32, 2131101391));
        r5.setTextSize(2, 15.0f);
        TextViewCompat.setLineHeight(r5, UIUtils.dp2px(r32, 21.0f));
        LinearLayout.LayoutParams r21 = new LinearLayout.LayoutParams(-1, -2);
        r21.topMargin = UIUtils.dp2px(r32, 8.0f);
        Unit r112 = Unit.INSTANCE;
        r3.addView(r5, r21);
        r7.addView(r3, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout r113 = new LinearLayout(r32);
        r113.setOrientation(1);
        r113.setGravity(1);
        r113.setPadding(UIUtils.dp2px(r32, 16.0f), 0, UIUtils.dp2px(r32, 16.0f), UIUtils.dp2px(r32, 16.0f));
        UDButton r23 = new UDButton(r32, null, 0, 6, null);
        r23.setText(UIHelper.mustacheFormat(2131892533, "APP_DISPLAY_NAME", UIHelper.getString(2131891485)));
        r23.setAllCaps(false);
        r23.setGravity(17);
        r23.setTextColor(ContextCompat.getColor(r32, 2131102063));
        r23.setTextSize(2, 17.0f);
        h0.a(r23, 600);
        TextViewCompat.setLineHeight(r23, UIUtils.dp2px(r32, 24.0f));
        r23.setStrokeWidth(0);
        r23.setCornerRadius(UIUtils.dp2px(r32, 16.0f));
        r23.setBackgroundColor(ContextCompat.getColor(r32, 2131102062));
        r23.setOnClickListener(new com.ss.android.lark.conditional.access.nopermission.ui.custom.f(r13));
        r113.addView(r23, new LinearLayout.LayoutParams(-1, UIUtils.dp2px(r32, 56.0f)));
        UDButton r114 = new UDButton(r32, null, 0, 6, null);
        r114.setText(getString(2131892528));
        r114.setAllCaps(false);
        r114.setGravity(17);
        r114.setTextColor(ContextCompat.getColor(r32, 2131101392));
        r114.setTextSize(2, 17.0f);
        TextViewCompat.setLineHeight(r114, UIUtils.dp2px(r32, 24.0f));
        r114.setStrokeWidth(0);
        r114.setCornerRadius(UIUtils.dp2px(r32, 12.0f));
        r114.setBackgroundColor(ContextCompat.getColor(r32, R.color.transparent));
        r114.setOnClickListener(new com.ss.android.lark.conditional.access.nopermission.ui.custom.g(r6));
        LinearLayout.LayoutParams r24 = new LinearLayout.LayoutParams(-1, UIUtils.dp2px(r32, 24.0f));
        r24.topMargin = UIUtils.dp2px(r32, 16.0f);
        r113.addView(r114, r24);
        r7.addView(r113, new LinearLayout.LayoutParams(-1, -2));
        UDDialogBuilder r25 = new UDDialogBuilder(r32).cancelable(false).cancelOnTouchOutside(false).maskAlpha(0.3f).width(1.0f).maxWidth(new UDDimension.Dp(326)).marginInDp(32).backgroundColor(R.color.transparent).contentLayout(r7);
        View r26 = new View(r32);
        r26.setLayoutParams(new ViewGroup.LayoutParams(-1, 0));
        UDDialog r27 = r25.footerLayout(r26).build();
        r12.element = r27;
        if (r27 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
    L59:
        T90(r20);
        return true;
    L58:
        r20 = r27;
        goto L59
    L27:
        r22 = false;
    L39:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L42
    L17:
        if (r30.equals("DeviceAuth") == false) goto L21;
    L22:
        r2 = new c(2131892530, 2131892529);
        goto L23
    L20:
        if (r30.equals("DeviceCertAuth") == true) goto L22;
        goto L21
    }
}
